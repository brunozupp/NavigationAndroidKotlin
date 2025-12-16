package com.novelitech.navigationwithretrofitmvvm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.novelitech.navigationwithretrofitmvvm.core.navigation.AppRoutes
import com.novelitech.navigationwithretrofitmvvm.features.categories.presentation.CategoriesPage
import com.novelitech.navigationwithretrofitmvvm.features.categories.presentation.CategoriesViewModel
import com.novelitech.navigationwithretrofitmvvm.features.mealDetails.presentation.MealDetailsPage
import com.novelitech.navigationwithretrofitmvvm.features.meals.presentation.MealsPage
import com.novelitech.navigationwithretrofitmvvm.features.providers.ProviderViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.novelitech.navigationwithretrofitmvvm.features.mealDetails.presentation.MealDetailsViewModel
import com.novelitech.navigationwithretrofitmvvm.features.meals.presentation.MealsViewModel

@Composable
fun MyApp() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.Categories
    ) {
        composable<AppRoutes.Categories> { backStackEntry ->

            /**
             * Creating an instance of viewModel inside a composable:
             * - Every recomposition -> new instance
             * - Every time you navigate away and back -> new instance
             * - When not using ViewModelStoreOwner -> no retention
             * With this, my screen would resets every time my composable rebuilds
             *
             * To avoid this, I need to hook my viewmodel into Android's ViewModel System (factory)
             * solution, because I have parameters inside my ViewModel. If I didn't have those
             * I could simply do this: val viewModel: CategoriesViewModel = viewModel()
             * So, in order to see the explanation of this, look for file ProviderViewModel
             */
            val viewModel: CategoriesViewModel = viewModel(
                viewModelStoreOwner = backStackEntry,
                factory = ProviderViewModel.provideCategoriesViewModelFactory()
            )

            CategoriesPage(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable<AppRoutes.Meals> { backStackEntry ->

            val categoryName = backStackEntry.toRoute<AppRoutes.Meals>().categoryName

            /**
             * About the property viewModelStoreOwner
             * ViewModelStoreOwner is an interface that owns a ViewModelStore - basically, a container
             * where ViewModels live. A ViewModel survives as long as its ViewModelStoreOwner survives.
             * Example:
             * Activity -> ViewModel survives while the activity exists
             * Fragment -> ViewModel survives while the fragment exists
             * NavBackStackEntry -> Viewmodel survives while that navigation destination stays in
             * the back stack
             *
             * So, in Compose Navigation each destination has its own NavBackStackEntry, and that
             * entry implements ViewModelStoreOwner.
             * That's the reason I must pass backStackEntry to the parameter viewModelStoreOwner,
             * indicating that this viewmodel will live while my page is the navigation stack.
             * If I don't do this, the viewmodel gets recreated every time you navigate
             */
            val viewModel: MealsViewModel = viewModel(
                viewModelStoreOwner = backStackEntry,
                factory = ProviderViewModel.provideMealsViewModelFactory()
            )

            MealsPage(
                navController = navController,
                viewModel = viewModel,
                categoryName = categoryName,
            )
        }
        composable<AppRoutes.MealDetails> { backStackEntry ->

            val mealId = backStackEntry.toRoute<AppRoutes.MealDetails>().mealId

            val viewModel: MealDetailsViewModel = viewModel(
                viewModelStoreOwner = backStackEntry,
                factory = ProviderViewModel.provideMealDetailsViewModelFactory()
            )

            MealDetailsPage(
                navController = navController,
                viewModel = viewModel,
                mealId = mealId,
            )
        }
    }
}