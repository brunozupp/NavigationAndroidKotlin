package com.novelitech.wishlistapp.core.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.novelitech.wishlistapp.core.AppInitializers
import com.novelitech.wishlistapp.data.WishlistDatabase
import com.novelitech.wishlistapp.data.daos.WishesDao

object DaosDI {

    private fun provideDatabase(application: Application) : WishlistDatabase
        = (application as AppInitializers).database

    fun provideWishesDao(application: Application) : WishesDao {
        return provideDatabase(application).wishesDao()
    }
}