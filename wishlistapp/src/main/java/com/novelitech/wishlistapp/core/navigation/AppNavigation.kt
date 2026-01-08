package com.novelitech.wishlistapp.core.navigation

import com.novelitech.wishlistapp.data.entities.WishEntity
import kotlinx.serialization.Serializable

sealed interface AppNavigation {

    @Serializable
    data object Wishlist : AppNavigation

    @Serializable
    data class NewWish(
        val wish: WishEntity? = null
    ) : AppNavigation
}