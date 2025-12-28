package com.novelitech.locationapp.core.helpers

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.location.Address
import android.location.Geocoder
import android.os.Looper
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.LatLng
import com.novelitech.locationapp.models.LocationModel
import java.util.Locale

class LocationHelper(val context: Context) {

    private val _fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    fun getLocation(callback: (LocationModel?) -> Unit) {

        if(!hasLocationPermission()) {
            println("No permission granted")
            return
        }

        val locationCallback = object: LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)

                if(locationResult.lastLocation == null) {
                    callback(null)
                } else {
                    locationResult.lastLocation?.let {
                        callback(LocationModel(
                            latitude = it.latitude,
                            longitude = it.longitude,
                        ))
                    }
                }
            }
        }

        val locationRequest = LocationRequest.Builder(
            Priority.PRIORITY_HIGH_ACCURACY,
            1000
        ).build()

        _fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper(),
        )
    }

    fun hasLocationPermission() : Boolean {

        val fineLocationPermisson = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_FINE_LOCATION,
        )

        val coarseLocationPermisson = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_COARSE_LOCATION,
        )

        return fineLocationPermisson == PERMISSION_GRANTED &&
                coarseLocationPermisson == PERMISSION_GRANTED
    }

    fun reverseGeocodeLocation(location: LocationModel) : String {

        val geocoder = Geocoder(context, Locale.getDefault())

        val coordinates = LatLng(location.latitude, location.longitude)

        val addresses: MutableList<Address>? = geocoder.getFromLocation(
            coordinates.latitude,
            coordinates.longitude,
            1,
        )

        return if(addresses?.isNotEmpty() == true) {
            addresses[0].getAddressLine(0)
        } else {
            "Address not found"
        }
    }
}