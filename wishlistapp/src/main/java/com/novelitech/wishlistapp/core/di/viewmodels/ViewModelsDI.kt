package com.novelitech.wishlistapp.core.di.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.novelitech.wishlistapp.core.di.RepositoriesDI
import com.novelitech.wishlistapp.data.repositories.IWishesRepository

object ViewModelsDI {

    fun provideNewWishViewModelFactory(application: Application) : ViewModelProvider.Factory {
        return NewWishViewModelFactory(RepositoriesDI.provideWishesRepository(application))
    }

    fun provideWishlistViewModelFactory(application: Application) : ViewModelProvider.Factory {
        return WishlistViewModelFactory(RepositoriesDI.provideWishesRepository(application))
    }
}