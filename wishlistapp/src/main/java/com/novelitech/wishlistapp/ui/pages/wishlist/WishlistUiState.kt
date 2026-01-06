package com.novelitech.wishlistapp.ui.pages.wishlist

import com.novelitech.wishlistapp.data.entities.WishEntity

data class WishlistUiState(
    val loading: Boolean = false,
    val error: String? = null,
    val wishes: List<WishEntity> = listOf()
) {

    val hasError: Boolean
        get() = error != null && error.isNotBlank()

    val hasWishes: Boolean
        get() = wishes.isNotEmpty()
}
