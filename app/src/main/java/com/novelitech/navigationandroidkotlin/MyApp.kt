package com.novelitech.navigationandroidkotlin

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.novelitech.navigationandroidkotlin.screens.FirstScreen
import com.novelitech.navigationandroidkotlin.screens.SecondScreen

@Composable
fun MyApp() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "first-screen"
    ) {
        composable("first-screen") { FirstScreen(navController = navController) }
        composable("second-screen") { SecondScreen(navController = navController) }
    }
}