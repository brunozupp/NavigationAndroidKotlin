package com.novelitech.wishlistapp.core.di

import android.app.Application
import com.novelitech.wishlistapp.data.repositories.IWishesRepository
import com.novelitech.wishlistapp.data.repositories.WishesRepository

object RepositoriesDI {

    fun provideWishesRepository(application: Application) : IWishesRepository {
        return WishesRepository(
            DaosDI.provideWishesDao(application)
        )
    }
}