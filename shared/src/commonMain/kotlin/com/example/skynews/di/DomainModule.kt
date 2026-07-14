package com.example.skynews.di

import com.example.skynews.domain.usecase.GetArticlesUseCase
import com.example.skynews.domain.usecase.GetFavoriteArticlesUseCase
import com.example.skynews.domain.usecase.ToggleFavoriteUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetArticlesUseCase(get()) }
    factory { GetFavoriteArticlesUseCase(get()) }
    factory { ToggleFavoriteUseCase(get()) }
}
