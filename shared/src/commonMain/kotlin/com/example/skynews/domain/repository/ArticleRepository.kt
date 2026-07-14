package com.example.skynews.domain.repository

import com.example.skynews.domain.entity.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getArticles(): Flow<List<Article>>

    fun getFavoriteArticles(): Flow<List<Article>>

    suspend fun toggleFavorite(articleId: String)
}
