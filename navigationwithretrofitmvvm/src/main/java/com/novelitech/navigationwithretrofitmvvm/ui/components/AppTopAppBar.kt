package com.novelitech.navigationwithretrofitmvvm.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.novelitech.navigationwithretrofitmvvm.ui.theme.Colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopAppBar(
    navController: NavController,
    title: String,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title
            )
        },
        navigationIcon = {
            NavigationIcon(navController = navController)
        },
        colors = TopAppBarDefaults.topAppBarColors().copy(
            containerColor = Colors.Primary
        )
    )
}

@Composable
private fun NavigationIcon(navController: NavController) {

    if(navController.previousBackStackEntry == null) {
        return Box {}
    }

    IconButton(
        onClick = {
            navController.navigateUp()
        }
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
            contentDescription = "Back"
        )
    }
}