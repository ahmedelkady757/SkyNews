package com.example.skynews.ui.theme

import androidx.compose.ui.graphics.Color

// ── Brand palette ─────────────────────────────────────────────────────────────
val SkyBlue        = Color(0xFF38BDF8)
val SkyBlueDim     = Color(0xFF0EA5E9)
val SkyBlueDeep    = Color(0xFF0369A1)
val GoldAccent     = Color(0xFFF59E0B)
val GoldLight      = Color(0xFFFBBF24)

// ── Dark background scale ─────────────────────────────────────────────────────
val NavyDeep       = Color(0xFF060C18)
val NavyDark       = Color(0xFF0A1020)
val NavyMedium     = Color(0xFF111827)
val NavyCard       = Color(0xFF192033)
val NavySurface    = Color(0xFF1E2D45)

// ── Text ──────────────────────────────────────────────────────────────────────
val TextPrimary    = Color(0xFFF1F5F9)
val TextSecondary  = Color(0xFF94A3B8)
val TextMuted      = Color(0xFF64748B)

// ── Category chip colours ─────────────────────────────────────────────────────
val CategoryFinance    = Color(0xFF22C55E)
val CategoryScience    = Color(0xFF8B5CF6)
val CategoryTechnology = Color(0xFF38BDF8)
val CategoryWorld      = Color(0xFFF59E0B)
val CategoryHealth     = Color(0xFFF472B6)
val CategorySports     = Color(0xFFFB923C)
val CategoryDefault    = Color(0xFF94A3B8)

fun categoryColor(category: String): Color = when (category.lowercase()) {
    "finance"    -> CategoryFinance
    "science"    -> CategoryScience
    "technology" -> CategoryTechnology
    "world"      -> CategoryWorld
    "health"     -> CategoryHealth
    "sports"     -> CategorySports
    else         -> CategoryDefault
}
