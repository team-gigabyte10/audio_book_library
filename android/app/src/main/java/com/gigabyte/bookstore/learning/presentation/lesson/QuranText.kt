package com.gigabyte.bookstore.learning.presentation.lesson

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.TextUnit

internal fun isQuranItem(itemId: String): Boolean = itemId.startsWith("qr-")

/** Quranic Arabic text: Right-to-left, generous line height (1.6x) so harakat & diacritics do not collide. */
internal fun quranTextStyle(fontSize: TextUnit, bold: Boolean = false): TextStyle = TextStyle(
    fontSize = fontSize,
    lineHeight = fontSize * 1.6f,
    fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal,
    textDirection = TextDirection.Rtl,
    textAlign = TextAlign.Right
)
