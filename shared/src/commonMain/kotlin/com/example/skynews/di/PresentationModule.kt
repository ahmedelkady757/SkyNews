package com.example.skynews.di

import com.example.skynews.presentation.articles.viewModel.ArticlesViewModel
import com.example.skynews.presentation.detail.viewModel.DetailViewModel
import com.example.skynews.presentation.favorites.viewModel.FavoritesViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { ArticlesViewModel(get(), get()) }
    factory { FavoritesViewModel(get(), get()) }
    factory { DetailViewModel(get(), get()) }
}
