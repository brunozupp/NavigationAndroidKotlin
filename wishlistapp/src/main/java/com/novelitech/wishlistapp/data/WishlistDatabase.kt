package com.novelitech.wishlistapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.novelitech.wishlistapp.data.daos.WishesDao
import com.novelitech.wishlistapp.data.entities.WishEntity

@Database(
    entities = [WishEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class WishlistDatabase : RoomDatabase() {

    abstract fun wishesDao() : WishesDao
}