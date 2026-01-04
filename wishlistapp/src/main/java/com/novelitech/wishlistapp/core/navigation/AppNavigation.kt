package com.novelitech.wishlistapp.core.navigation

import kotlinx.serialization.Serializable

sealed interface AppNavigation {

    @Serializable
    data object Wishlist : AppNavigation

    @Serializable
    data object NewWish : AppNavigation
}