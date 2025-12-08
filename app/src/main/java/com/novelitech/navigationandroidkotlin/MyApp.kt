package com.novelitech.navigationandroidkotlin

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.novelitech.navigationandroidkotlin.core.navigation.AppRoutes
import com.novelitech.navigationandroidkotlin.screens.FirstScreen
import com.novelitech.navigationandroidkotlin.screens.SecondScreen

@Composable
fun MyApp() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.First
    ) {
        composable<AppRoutes.First> { FirstScreen(navController = navController) }
        composable<AppRoutes.Second> { backStackEntry ->

            val args = backStackEntry.toRoute<AppRoutes.Second>()

            SecondScreen(navController = navController, name = args.name)
        }
    }
}