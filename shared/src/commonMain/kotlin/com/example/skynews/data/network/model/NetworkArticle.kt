package com.example.skynews.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkArticle(
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
    val source: NetworkSource?
)
@Serializable
data class NetworkSource(
    val id: String?,
    val name: String?
)
