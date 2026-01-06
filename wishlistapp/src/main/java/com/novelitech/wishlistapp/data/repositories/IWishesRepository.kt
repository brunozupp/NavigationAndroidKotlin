package com.novelitech.wishlistapp.data.repositories

import com.novelitech.wishlistapp.data.entities.WishEntity
import kotlinx.coroutines.flow.Flow

interface IWishesRepository {

    suspend fun insert(wish: WishEntity)

    suspend fun update(wish: WishEntity)

    suspend fun delete(wish: WishEntity)

    fun getAll() : Flow<List<WishEntity>>

    fun getById(id: Long) : Flow<WishEntity>
}