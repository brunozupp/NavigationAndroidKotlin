package com.novelitech.locationapp.pages

import android.Manifest
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import com.novelitech.locationapp.MainActivity
import com.novelitech.locationapp.core.helpers.LocationHelper

@Composable
fun LocationPage(
    modifier: Modifier = Modifier,
    context: Context,
    locationHelper: LocationHelper,
) {

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = { permissions ->

            println("AFTER close de permission's dialog")

            // Verify if the response was permission granted
            if(permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true &&
                permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true) {

                // I got the permissions and I do what I need to do

            } else {

                /**
                 * I denied the permission, so I will verify the current status of this permission
                 * It verifies the status of the permission, if it was denied twice or more times
                 * Behavior of this statements -> rationaleRequired is a boolean variable
                 * true -> when I didn't deny twice yet
                 * false -> when I denied twice the permission
                 */
                val rationaleRequired = ActivityCompat.shouldShowRequestPermissionRationale(
                    context as MainActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                ) || ActivityCompat.shouldShowRequestPermissionRationale(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                )

                /**
                 * If I deny it once this "if" will be executed
                 * Otherwise the "else will execute when denying twice
                 */
                if(rationaleRequired) {
                    Toast.makeText(
                        context,
                        "Location permission is required for this feature to work",
                        Toast.LENGTH_LONG
                    ).show()
                } else { // The app can not change the permission by itself. The user needs to go to the configuration
                    Toast.makeText(
                        context,
                        "Location permission is required for this feature to work. Please, enable it in the Android Settings",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    )

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Text(
            text = "Location not available"
        )

        Button(
            onClick = {
                if(locationHelper.hasLocationPermission()) {

                } else {
                    /**
                     * The dialog will be opened or not here, depending on the situation of the
                     * permissions I passed to the array. So, just after giving or not giving the
                     * permission is that the block of code "onResult = { permissions ->" will be
                     * executed
                     */
                    requestPermissionLauncher.launch(
                        arrayOf(
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                        )
                    )
                }
            }
        ) {
            Text(
                text = "Get Location"
            )
        }
    }
}