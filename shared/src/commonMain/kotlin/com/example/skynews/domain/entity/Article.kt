package com.example.skynews.domain.entity

data class Article(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val source: String,
    val category: String,
    val publishedAt: String,
    val content: String,
    val isFavorite: Boolean = false
)
