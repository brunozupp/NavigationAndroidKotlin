package com.novelitech.wishlistapp.data.repositories

import com.novelitech.wishlistapp.data.daos.WishesDao
import com.novelitech.wishlistapp.data.entities.WishEntity
import kotlinx.coroutines.flow.Flow

class WishesRepository(private val dao: WishesDao) : IWishesRepository {
    override suspend fun insert(wish: WishEntity) {
        dao.insert(wish)
    }

    override suspend fun update(wish: WishEntity) {
        dao.update(wish)
    }

    override suspend fun delete(wish: WishEntity) {
        dao.delete(wish)
    }

    override fun getAll(): Flow<List<WishEntity>> = dao.getAll()

    override fun getById(id: Long): Flow<WishEntity> = dao.getById(id)
}