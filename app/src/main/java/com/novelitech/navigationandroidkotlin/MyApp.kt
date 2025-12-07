package com.novelitech.navigationandroidkotlin

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.novelitech.navigationandroidkotlin.core.navigation.AppScreens
import com.novelitech.navigationandroidkotlin.screens.FirstScreen
import com.novelitech.navigationandroidkotlin.screens.SecondScreen

@Composable
fun MyApp() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.FIRST_SCREEN.route
    ) {
        composable(AppScreens.FIRST_SCREEN.route) { FirstScreen(navController = navController) }
        composable(AppScreens.SECOND_SCREEN.route) { SecondScreen(navController = navController) }
    }
}