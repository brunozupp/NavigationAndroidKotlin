package com.novelitech.wishlistapp.core.di.viewmodels

import androidx.lifecycle.ViewModelProvider

object ViewModelsDI {

    fun provideNewWishViewModelFactory() : ViewModelProvider.Factory {
        return NewWishViewModelFactory()
    }

    fun provideWishlistViewModelFactory() : ViewModelProvider.Factory {
        return WishlistViewModelFactory()
    }
}