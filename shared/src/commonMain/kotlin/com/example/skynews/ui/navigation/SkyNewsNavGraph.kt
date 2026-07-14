package com.example.skynews.ui.navigation

import io.ktor.http.decodeURLPart

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.skynews.presentation.articles.view.ArticlesScreen
import com.example.skynews.presentation.detail.view.ArticleDetailScreen
import com.example.skynews.presentation.favorites.view.FavoritesScreen
import com.example.skynews.ui.theme.GoldAccent
import com.example.skynews.ui.theme.NavyDeep
import com.example.skynews.ui.theme.NavySurface
import com.example.skynews.ui.theme.SkyBlue

@Composable
fun SkyNewsNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Articles.route
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentRoute = currentDestination?.route

    val isBottomBarVisible = currentRoute == Screen.Articles.route || currentRoute == Screen.Favorites.route

    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (isBottomBarVisible) {
                NavigationBar(
                    containerColor = NavyDeep,
                    contentColor = SkyBlue
                ) {
                    val articlesSelected = currentDestination?.hierarchy?.any { it.route == Screen.Articles.route } == true
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = if (articlesSelected) Icons.Filled.Home else Icons.Outlined.Home,
                                contentDescription = "Articles"
                            )
                        },
                        label = { Text("Articles") },
                        selected = articlesSelected,
                        onClick = {
                            navController.navigate(Screen.Articles.route) {
                                popUpTo(navController.graph.findStartDestination().route ?: Screen.Articles.route) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = SkyBlue,
                            selectedTextColor = SkyBlue,
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray,
                            indicatorColor = NavySurface
                        )
                    )

                    val favoritesSelected = currentDestination?.hierarchy?.any { it.route == Screen.Favorites.route } == true
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = if (favoritesSelected) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                                contentDescription = "Favorites"
                            )
                        },
                        label = { Text("Saved") },
                        selected = favoritesSelected,
                        onClick = {
                            navController.navigate(Screen.Favorites.route) {
                                popUpTo(navController.graph.findStartDestination().route ?: Screen.Articles.route) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = GoldAccent,
                            selectedTextColor = GoldAccent,
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray,
                            indicatorColor = NavySurface
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(innerPadding),
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) },
            popEnterTransition = { fadeIn(animationSpec = tween(300)) },
            popExitTransition = { fadeOut(animationSpec = tween(300)) }
        ) {
            composable(route = Screen.Articles.route) {
                ArticlesScreen(
                    onArticleClick = { articleId ->
                        navController.navigate(Screen.Detail.createRoute(articleId))
                    }
                )
            }
            composable(route = Screen.Favorites.route) {
                FavoritesScreen(
                    onArticleClick = { articleId ->
                        navController.navigate(Screen.Detail.createRoute(articleId))
                    }
                )
            }
            composable(
                route = Screen.Detail.route,
                enterTransition = {
                    slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(300))
                },
                popExitTransition = {
                    slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, animationSpec = tween(300))
                }
            ) { backStackEntry ->
                val encodedId = backStackEntry.arguments?.getString("articleId") ?: return@composable
                val articleId = encodedId.decodeURLPart()
                ArticleDetailScreen(
                    articleId = articleId,
                    onBack = { navController.navigateUp() }
                )
            }
        }
    }
}
