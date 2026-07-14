package com.example.skynews.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class LocalArticle(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val source: String,
    val category: String,
    val publishedAt: String,
    val content: String,
    val isFavorite: Boolean = false
)
