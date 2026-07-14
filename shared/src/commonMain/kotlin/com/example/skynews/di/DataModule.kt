package com.example.skynews.di

import com.example.skynews.data.local.AppDatabase
import com.example.skynews.data.local.getDatabaseBuilder
import com.example.skynews.data.network.NewsApiClient
import com.example.skynews.data.repository.ArticleRepositoryImpl
import com.example.skynews.domain.repository.ArticleRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val dataModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }
        }
    }

    single { NewsApiClient(get()) }

    single {
        getDatabaseBuilder()
            .setDriver(androidx.sqlite.driver.bundled.BundledSQLiteDriver())
            .build()
    }

    single { get<AppDatabase>().articleDao() }

    single<ArticleRepository> { ArticleRepositoryImpl(get(), get()) }
}
