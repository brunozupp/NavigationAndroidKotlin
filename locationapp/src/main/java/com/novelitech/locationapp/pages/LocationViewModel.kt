package com.novelitech.locationapp.pages

import androidx.lifecycle.ViewModel
import com.novelitech.locationapp.models.LocationModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LocationViewModel : ViewModel() {

    private val _location = MutableStateFlow<LocationModel?>(null)

    val location: StateFlow<LocationModel?> = _location.asStateFlow()

    fun updateLocation(
        location: LocationModel,
    ) {
        _location.value = location
    }
}