package com.novelitech.locationapp.core.helpers

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.core.content.ContextCompat

class LocationHelper(val context: Context) {

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
}