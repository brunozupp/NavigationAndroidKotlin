package com.novelitech.locationapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.novelitech.locationapp.core.helpers.LocationHelper
import com.novelitech.locationapp.pages.LocationPage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {

    /// This is the activity context
    val context = LocalContext.current

    val locationHelper = LocationHelper(context)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentColor = Color.White,
        topBar = {
            TopAppBar(
                title = {
                    Text("Location")
                }
            )
        }
    ) { innerPadding ->
        LocationPage(
            modifier = Modifier.padding(innerPadding),
            context = context,
            locationHelper = locationHelper,
        )
    }
}