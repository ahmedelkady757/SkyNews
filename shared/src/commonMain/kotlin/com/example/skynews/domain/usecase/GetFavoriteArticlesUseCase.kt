package com.example.skynews.domain.usecase

import com.example.skynews.domain.entity.Article
import com.example.skynews.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteArticlesUseCase(private val repository: ArticleRepository) {
    operator fun invoke(): Flow<List<Article>> = repository.getFavoriteArticles()
}
