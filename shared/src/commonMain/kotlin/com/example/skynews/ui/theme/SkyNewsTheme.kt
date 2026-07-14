package com.example.skynews.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val SkyNewsDarkColorScheme = darkColorScheme(
    // Backgrounds
    background        = NavyDeep,
    surface           = NavyMedium,
    surfaceVariant    = NavyCard,
    surfaceContainer  = NavySurface,

    // Primary — sky blue
    primary           = SkyBlue,
    onPrimary         = NavyDeep,
    primaryContainer  = SkyBlueDeep,
    onPrimaryContainer = TextPrimary,

    // Secondary — gold
    secondary         = GoldAccent,
    onSecondary       = NavyDeep,
    secondaryContainer = Color(0xFF78350F),
    onSecondaryContainer = GoldLight,

    // Text / icons
    onBackground      = TextPrimary,
    onSurface         = TextPrimary,
    onSurfaceVariant  = TextSecondary,

    // Outline
    outline           = NavySurface,
    outlineVariant    = NavyCard,

    // Error
    error             = Color(0xFFF87171),
    onError           = NavyDeep,
)

@Composable
fun SkyNewsTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = SkyNewsDarkColorScheme,
        typography  = SkyNewsTypography,
        content     = content
    )
}
