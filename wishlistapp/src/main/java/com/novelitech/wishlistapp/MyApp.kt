package com.novelitech.wishlistapp

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.novelitech.wishlistapp.core.di.viewmodels.ViewModelsDI
import com.novelitech.wishlistapp.core.navigation.AppNavigation
import com.novelitech.wishlistapp.core.navigation.serializableNavType
import com.novelitech.wishlistapp.data.entities.WishEntity
import com.novelitech.wishlistapp.ui.pages.newwish.NewWishPage
import com.novelitech.wishlistapp.ui.pages.newwish.NewWishViewModel
import com.novelitech.wishlistapp.ui.pages.wishlist.WishlistPage
import com.novelitech.wishlistapp.ui.pages.wishlist.WishlistViewModel
import kotlin.reflect.typeOf

@Composable
fun MyApp(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    /**
     * Using this approach to obtain the instances of what I need from my 'Service Locator':
     * - ViewModel scoped correctly
     * - DB instance reused
     * - No leaks
     * - No static context
     */
    val context = LocalContext.current
    val application = context.applicationContext as Application

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppNavigation.Wishlist
    ) {
        composable<AppNavigation.Wishlist> { backStackEntry ->

            val viewModel: WishlistViewModel = viewModel(
                viewModelStoreOwner = backStackEntry,
                factory = ViewModelsDI.provideWishlistViewModelFactory(application)
            )

            WishlistPage(
                navController = navController,
                viewModel = viewModel,
            )
        }
        composable<AppNavigation.NewWish>(
            typeMap = mapOf(
                typeOf<WishEntity?>() to serializableNavType<WishEntity?>()
            ),
        ) { backStackEntry ->

            val wish = backStackEntry.toRoute<AppNavigation.NewWish>().wish

            val viewModel: NewWishViewModel = viewModel(
                viewModelStoreOwner = backStackEntry,
                factory = ViewModelsDI.provideNewWishViewModelFactory(application)
            )

            NewWishPage(
                navController = navController,
                viewModel = viewModel,
                wish = wish,
            )
        }
    }
}