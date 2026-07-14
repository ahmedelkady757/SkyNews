package com.example.skynews.data.network

import com.example.skynews.data.network.model.NewsApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class NewsApiClient(private val httpClient: HttpClient) {

    suspend fun getTopHeadlines(): NewsApiResponse {
        return httpClient.get("https://newsapi.org/v2/top-headlines") {
            parameter("country", "us")
            parameter("category", "business")
            parameter("apiKey", Secrets.API_KEY)
        }.body()
    }
}
