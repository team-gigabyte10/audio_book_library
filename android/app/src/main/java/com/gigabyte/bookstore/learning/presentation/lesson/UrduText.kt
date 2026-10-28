package com.gigabyte.bookstore.learning.presentation.lesson

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.TextUnit
import com.gigabyte.bookstore.R

/** Noto Nastaliq Urdu (OFL, license in assets/licenses). Used for Urdu text only (Urdu plan §9). */
internal val NastaliqFontFamily = FontFamily(Font(R.font.noto_nastaliq_urdu))

internal fun isUrduItem(itemId: String): Boolean = itemId.startsWith("ur-")

/** Urdu text: Nastaliq, right to left, and about 1.8× line height so the marks do not overlap. */
internal fun urduTextStyle(fontSize: TextUnit, bold: Boolean = false): TextStyle = TextStyle(
    fontFamily = NastaliqFontFamily,
    fontSize = fontSize,
    lineHeight = fontSize * 1.8f,
    fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal,
    textDirection = TextDirection.Rtl,
    textAlign = TextAlign.Right
)
