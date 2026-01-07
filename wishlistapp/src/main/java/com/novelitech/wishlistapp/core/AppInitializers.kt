package com.novelitech.wishlistapp.core

import android.app.Application
import androidx.room.Room
import com.novelitech.wishlistapp.data.WishlistDatabase

/**
 * In Android, we have the Application class that is useful for initializing any global state that
 * needs to be available throughout the app. This class is instantiated before any other class
 * when the process of an application is created. To use the Application class, it's needed to extend
 * the Application() in a subclass
 */
class AppInitializers : Application() {

    /**
     * This is the best approach because:
     * - Single instance
     * - Application context (safe)
     * - Lazy initialization
     *
     * This is Room lifecycle-safe:
     * - Application outlives all screens
     * - No accidental recreation
     */
    val database: WishlistDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            WishlistDatabase::class.java,
            DATABASE_NAME,
        ).build()
    }

    companion object {

        private const val DATABASE_NAME = "wishlistapp.db"
    }
}