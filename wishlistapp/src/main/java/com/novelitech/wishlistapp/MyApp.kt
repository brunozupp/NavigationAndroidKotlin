package com.novelitech.wishlistapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.novelitech.wishlistapp.core.di.viewmodels.ViewModelsDI
import com.novelitech.wishlistapp.core.navigation.AppNavigation
import com.novelitech.wishlistapp.ui.pages.newwish.NewWishPage
import com.novelitech.wishlistapp.ui.pages.newwish.NewWishViewModel
import com.novelitech.wishlistapp.ui.pages.wishlist.WishlistPage
import com.novelitech.wishlistapp.ui.pages.wishlist.WishlistViewModel

@Composable
fun MyApp(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppNavigation.Wishlist
    ) {
        composable<AppNavigation.Wishlist> { backStackEntry ->

            val viewModel: WishlistViewModel = viewModel(
                viewModelStoreOwner = backStackEntry,
                factory = ViewModelsDI.provideWishlistViewModelFactory()
            )

            WishlistPage(
                navController = navController,
                viewModel = viewModel,
            )
        }
        composable<AppNavigation.NewWish> { backStackEntry ->

            val viewModel: NewWishViewModel = viewModel(
                viewModelStoreOwner = backStackEntry,
                factory = ViewModelsDI.provideNewWishViewModelFactory()
            )

            NewWishPage(
                navController = navController,
                viewModel = viewModel,
            )
        }
    }
}