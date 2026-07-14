package com.example.skynews.ui

import androidx.compose.runtime.Composable
import com.example.skynews.ui.navigation.SkyNewsNavGraph
import com.example.skynews.ui.theme.SkyNewsTheme

@Composable
fun SkyNewsApp() {
    SkyNewsTheme {
        SkyNewsNavGraph()
    }
}
