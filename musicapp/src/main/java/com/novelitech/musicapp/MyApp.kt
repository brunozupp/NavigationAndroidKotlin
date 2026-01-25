package com.novelitech.musicapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.novelitech.musicapp.core.navigation.AppRoutes
import com.novelitech.musicapp.features.elo_card.presentation.EloCardPage
import com.novelitech.musicapp.features.helpdesk.presentation.HelpdeskPage
import com.novelitech.musicapp.features.home.presentation.HomePage
import com.novelitech.musicapp.features.notes.presentation.NotesPage

@Composable
fun MyApp(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.Home,
    ) {
        composable<AppRoutes.Home> { backStackEntry ->
            HomePage()
        }
        composable<AppRoutes.Helpdesk> { backStackEntry ->
            HelpdeskPage()
        }
        composable<AppRoutes.EloCard> { backStackEntry ->
            EloCardPage()
        }
        composable<AppRoutes.Notes> { backStackEntry ->
            NotesPage()
        }
    }
}