package com.example.skynews.data.mapper

import com.example.skynews.data.local.entity.LocalArticle
import com.example.skynews.data.network.model.NetworkArticle
import com.example.skynews.domain.entity.Article

fun NetworkArticle.toLocalArticle(): LocalArticle {
    val articleId = url ?: (title ?: "unknown")
    return LocalArticle(
        id = articleId,
        title = title ?: "",
        description = description ?: "",
        imageUrl = urlToImage ?: "",
        source = source?.name ?: "",
        category = "business",
        publishedAt = publishedAt ?: "",
        content = content ?: "",
        isFavorite = false
    )
}

fun LocalArticle.toDomainArticle(): Article {
    return Article(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        source = source,
        category = category,
        publishedAt = publishedAt,
        content = content,
        isFavorite = isFavorite
    )
}
