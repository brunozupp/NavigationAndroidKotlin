package com.novelitech.navigationwithretrofitmvvm

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.novelitech.navigationwithretrofitmvvm.core.navigation.AppRoutes
import com.novelitech.navigationwithretrofitmvvm.features.categories.presentation.CategoriesPage
import com.novelitech.navigationwithretrofitmvvm.features.mealDetails.presentation.MealDetailsPage
import com.novelitech.navigationwithretrofitmvvm.features.meals.presentation.MealsPage

@Composable
fun MyApp() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.Categories
    ) {
        composable<AppRoutes.Categories> { CategoriesPage() }
        composable<AppRoutes.Meals> { MealsPage() }
        composable<AppRoutes.MealDetails> { MealDetailsPage() }
    }
}