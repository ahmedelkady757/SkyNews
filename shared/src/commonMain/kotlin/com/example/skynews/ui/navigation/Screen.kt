package com.example.skynews.ui.navigation

import io.ktor.http.encodeURLPathPart

/** Type-safe navigation route definitions. */
sealed class Screen(val route: String) {
    data object Articles  : Screen("articles")
    data object Favorites : Screen("favorites")
    data object Detail    : Screen("detail/{articleId}") {
        fun createRoute(articleId: String): String {
            val encodedId = articleId.encodeURLPathPart()
            return "detail/$encodedId"
        }
    }
}
