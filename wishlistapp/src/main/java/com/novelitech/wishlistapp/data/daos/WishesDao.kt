package com.novelitech.wishlistapp.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.novelitech.wishlistapp.data.entities.WishEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WishesDao {

    companion object {
        private const val TABLE_NAME: String = "wishes"
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(wish: WishEntity)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAll() : Flow<List<WishEntity>>

    @Update
    suspend fun update(wish: WishEntity)

    @Delete
    suspend fun delete(wish: WishEntity)

    @Query("SELECT * FROM $TABLE_NAME WHERE id=:id")
    fun getById(id: Long): Flow<WishEntity>
}