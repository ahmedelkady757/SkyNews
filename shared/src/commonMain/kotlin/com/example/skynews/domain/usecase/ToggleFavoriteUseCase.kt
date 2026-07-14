package com.example.skynews.domain.usecase

import com.example.skynews.domain.repository.ArticleRepository

class ToggleFavoriteUseCase(private val repository: ArticleRepository) {
    suspend operator fun invoke(articleId: String) = repository.toggleFavorite(articleId)
}
