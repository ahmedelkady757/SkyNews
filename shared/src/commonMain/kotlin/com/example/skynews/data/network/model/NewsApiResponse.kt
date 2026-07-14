package com.example.skynews.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NewsApiResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NetworkArticle>
)
