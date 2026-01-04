package com.novelitech.wishlistapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.novelitech.wishlistapp.core.navigation.AppNavigation
import com.novelitech.wishlistapp.ui.pages.newwish.NewWishPage
import com.novelitech.wishlistapp.ui.pages.wishlist.WishlistPage

@Composable
fun MyApp(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppNavigation.Wishlist
    ) {
        composable<AppNavigation.Wishlist> { backStackEntry ->

            WishlistPage(
                navController = navController
            )
        }
        composable<AppNavigation.NewWish> { backStackEntry ->

            NewWishPage(
                navController = navController
            )
        }
    }
}