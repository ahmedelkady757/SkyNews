package com.example.skynews.data.repository

import com.example.skynews.data.local.dao.ArticleDao
import com.example.skynews.data.mapper.toDomainArticle
import com.example.skynews.data.mapper.toLocalArticle
import com.example.skynews.data.network.NewsApiClient
import com.example.skynews.domain.entity.Article
import com.example.skynews.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class ArticleRepositoryImpl(
    private val apiClient: NewsApiClient,
    private val articleDao: ArticleDao
) : ArticleRepository {

    override fun getArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles()
            .map { localArticles -> localArticles.map { it.toDomainArticle() } }
            .onStart {
                try {
                    val networkArticles = apiClient.getTopHeadlines().articles
                    val favoriteIds = articleDao.getFavoriteArticles().first().map { it.id }.toSet()
                    val localArticles = networkArticles.map { networkArticle ->
                        val local = networkArticle.toLocalArticle()
                        if (favoriteIds.contains(local.id)) local.copy(isFavorite = true) else local
                    }
                    articleDao.insertArticles(localArticles)
                } catch (e: Exception) {
                }
            }
    }

    override fun getFavoriteArticles(): Flow<List<Article>> {
        return articleDao.getFavoriteArticles()
            .map { localArticles -> localArticles.map { it.toDomainArticle() } }
    }

    override suspend fun toggleFavorite(articleId: String) {
        val article = articleDao.getArticleById(articleId)
        if (article != null) {
            articleDao.updateFavoriteStatus(articleId, !article.isFavorite)
        }
    }
}
