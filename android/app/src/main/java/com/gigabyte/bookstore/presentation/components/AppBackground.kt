package com.gigabyte.bookstore.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

/**
 * A luxury ambient background canvas that gives pages a refined, modern depth.
 * Blends subtle top illumination from the App Bar down into a soothing reading canvas.
 */
@Composable
fun AppBackground(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    val isDark = MaterialTheme.colorScheme.surface.luminance() < 0.5f

    val bgBrush = if (isDark) {
        Brush.verticalGradient(
            colors = listOf(
                Color(0xFF0F1E1B), // Soft ambient dark emerald glow at top
                Color(0xFF091211), // Deep obsidian slate
                Color(0xFF070E0D)
            )
        )
    } else {
        Brush.verticalGradient(
            colors = listOf(
                Color(0xFFE2F0EC), // Soft misty teal illumination at top
                Color(0xFFF3F8F6), // Soothing clean canvas
                Color(0xFFF8FCFA)
            )
        )
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush = bgBrush),
        content = content
    )
}
