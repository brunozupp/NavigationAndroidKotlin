package com.novelitech.wishlistapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wishes")
data class WishEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val description: String,
)
