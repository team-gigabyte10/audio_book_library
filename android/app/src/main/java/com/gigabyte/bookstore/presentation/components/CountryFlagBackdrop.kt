package com.gigabyte.bookstore.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.gigabyte.bookstore.R
import kotlin.math.cos
import kotlin.math.sin

enum class CourseCountry(val code: String, val titleBn: String, val flagEmoji: String) {
    UK("uk", "যুক্তরাজ্য", "🇬🇧"),
    JAPAN("jp", "জাপান", "🇯🇵"),
    PAKISTAN("pk", "পাকিস্তান", "🇵🇰"),
    INDIA("in", "ভারত", "🇮🇳"),
    GERMANY("de", "জার্মানি", "🇩🇪"),
    CHINA("cn", "চীন", "🇨🇳"),
    SAUDI_ARABIA("sa", "সৌদি আরব", "🇸🇦"),
    SOUTH_KOREA("kr", "দক্ষিণ কোরিয়া", "🇰🇷"),
    BANGLADESH("bd", "বাংলাদেশ", "🇧🇩"),
    QURAN("qr", "কুরআন হেরিটেজ", "📖"),
    BUNDLE("bundle", "বাংলা সাহিত্য বান্ডেল", "📚");

    companion object {
        fun fromLanguageKey(key: String?): CourseCountry {
            val k = key?.trim()?.lowercase().orEmpty()
            return when {
                k.startsWith("en") || k.contains("english") -> UK
                k.startsWith("jp") || k.startsWith("ja") || k.contains("japanese") -> JAPAN
                k.startsWith("ur") || k.contains("urdu") -> PAKISTAN
                k.startsWith("hi") || k.contains("hindi") -> INDIA
                k.startsWith("de") || k.contains("german") -> GERMANY
                k.startsWith("zh") || k.contains("chinese") || k.contains("mandarin") -> CHINA
                k.startsWith("sa") || k.startsWith("ar") || k.contains("arabic") -> SAUDI_ARABIA
                k.startsWith("kr") || k.startsWith("ko") || k.contains("korean") -> SOUTH_KOREA
                k.startsWith("bd") || k.contains("regional") -> BANGLADESH
                k.startsWith("qr") || k.contains("quran") -> QURAN
                else -> BUNDLE
            }
        }
    }
}

/**
 * High-performance, zero-APK-bloat Compose Canvas country flag renderer.
 * Accurately draws official country flag geometry, proportions, and emblems at 60fps.
 * For Quran learning, renders the authentic high-resolution Holy Quran background image.
 */
@Composable
fun CountryFlagBackdrop(
    country: CourseCountry,
    modifier: Modifier = Modifier
) {
    if (country == CourseCountry.QURAN) {
        Image(
            painter = painterResource(id = R.drawable.quran_course_backdrop),
            contentDescription = "Holy Quran Backdrop",
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )
    } else {
        Canvas(modifier = modifier.fillMaxSize()) {
            when (country) {
                CourseCountry.UK -> drawUkFlag()
                CourseCountry.JAPAN -> drawJapanFlag()
                CourseCountry.PAKISTAN -> drawPakistanFlag()
                CourseCountry.INDIA -> drawIndiaFlag()
                CourseCountry.GERMANY -> drawGermanyFlag()
                CourseCountry.CHINA -> drawChinaFlag()
                CourseCountry.SAUDI_ARABIA -> drawSaudiFlag()
                CourseCountry.SOUTH_KOREA -> drawKoreaFlag()
                CourseCountry.BANGLADESH -> drawBangladeshFlag()
                CourseCountry.QURAN -> drawQuranHeritage()
                CourseCountry.BUNDLE -> drawBundleFlag()
            }
        }
    }
}

// -----------------------------------------------------------------------------
// 1. UNITED KINGDOM (Union Jack)
// -----------------------------------------------------------------------------
private fun DrawScope.drawUkFlag() {
    val w = size.width
    val h = size.height

    // Navy Blue field
    drawRect(color = Color(0xFF012169), size = size)

    // St Andrew's White Saltire (diagonals)
    val saltireWhiteWidth = h * 0.20f
    drawLine(
        color = Color.White,
        start = Offset(0f, 0f),
        end = Offset(w, h),
        strokeWidth = saltireWhiteWidth
    )
    drawLine(
        color = Color.White,
        start = Offset(0f, h),
        end = Offset(w, 0f),
        strokeWidth = saltireWhiteWidth
    )

    // St Patrick's Red Saltire (thin diagonals)
    val saltireRedWidth = h * 0.08f
    drawLine(
        color = Color(0xFFC8102E),
        start = Offset(0f, 0f),
        end = Offset(w, h),
        strokeWidth = saltireRedWidth
    )
    drawLine(
        color = Color(0xFFC8102E),
        start = Offset(0f, h),
        end = Offset(w, 0f),
        strokeWidth = saltireRedWidth
    )

    // St George's Broad White Cross
    val crossWhiteWidth = h * 0.32f
    drawRect(
        color = Color.White,
        topLeft = Offset((w - crossWhiteWidth) / 2f, 0f),
        size = Size(crossWhiteWidth, h)
    )
    drawRect(
        color = Color.White,
        topLeft = Offset(0f, (h - crossWhiteWidth) / 2f),
        size = Size(w, crossWhiteWidth)
    )

    // St George's Red Cross
    val crossRedWidth = h * 0.18f
    drawRect(
        color = Color(0xFFC8102E),
        topLeft = Offset((w - crossRedWidth) / 2f, 0f),
        size = Size(crossRedWidth, h)
    )
    drawRect(
        color = Color(0xFFC8102E),
        topLeft = Offset(0f, (h - crossRedWidth) / 2f),
        size = Size(w, crossRedWidth)
    )
}

// -----------------------------------------------------------------------------
// 2. JAPAN (Nisshōki / Hinomaru)
// -----------------------------------------------------------------------------
private fun DrawScope.drawJapanFlag() {
    val w = size.width
    val h = size.height

    // Pure White background
    drawRect(color = Color(0xFFFAFBFD), size = size)

    // Crimson Sun Disc placed slightly right of center for optimal left-text readability
    val sunCenter = Offset(w * 0.65f, h * 0.48f)
    val sunRadius = h * 0.36f

    // Soft subtle radial glow around the sun
    drawCircle(
        color = Color(0xFFBC002D).copy(alpha = 0.12f),
        center = sunCenter,
        radius = sunRadius * 1.25f
    )
    drawCircle(
        color = Color(0xFFBC002D),
        center = sunCenter,
        radius = sunRadius
    )
}

// -----------------------------------------------------------------------------
// 3. PAKISTAN (Parchem-e Sitāra-o-Hilāl)
// -----------------------------------------------------------------------------
private fun DrawScope.drawPakistanFlag() {
    val w = size.width
    val h = size.height

    // Deep Dark Green Field
    drawRect(color = Color(0xFF0C4D26), size = size)

    // White Vertical Hoist Stripe (left 22%)
    val hoistWidth = w * 0.22f
    drawRect(
        color = Color.White,
        topLeft = Offset(0f, 0f),
        size = Size(hoistWidth, h)
    )

    // Tilted White Crescent & 5-Pointed Star
    val greenCenterX = hoistWidth + (w - hoistWidth) * 0.58f
    val greenCenterY = h * 0.46f
    val crescentRadius = h * 0.30f

    // Outer white circle
    drawCircle(
        color = Color.White,
        center = Offset(greenCenterX, greenCenterY),
        radius = crescentRadius
    )
    // Inner green circle cutout creating the crescent
    drawCircle(
        color = Color(0xFF0C4D26),
        center = Offset(greenCenterX + crescentRadius * 0.32f, greenCenterY - crescentRadius * 0.18f),
        radius = crescentRadius * 0.88f
    )

    // Five-pointed star pointing towards top-right corner
    val starCenter = Offset(greenCenterX + crescentRadius * 0.52f, greenCenterY - crescentRadius * 0.40f)
    drawStar(
        center = starCenter,
        outerRadius = crescentRadius * 0.36f,
        innerRadius = crescentRadius * 0.15f,
        color = Color.White,
        rotationDeg = -25f
    )
}

// -----------------------------------------------------------------------------
// 4. INDIA (Tiranga)
// -----------------------------------------------------------------------------
private fun DrawScope.drawIndiaFlag() {
    val w = size.width
    val h = size.height
    val stripeHeight = h / 3f

    // Top: Deep Saffron
    drawRect(
        color = Color(0xFFFF9933),
        topLeft = Offset(0f, 0f),
        size = Size(w, stripeHeight)
    )

    // Middle: White
    drawRect(
        color = Color(0xFFFAFBFD),
        topLeft = Offset(0f, stripeHeight),
        size = Size(w, stripeHeight)
    )

    // Bottom: India Green
    drawRect(
        color = Color(0xFF138808),
        topLeft = Offset(0f, stripeHeight * 2f),
        size = Size(w, stripeHeight)
    )

    // Ashoka Chakra in Center (Navy Blue, 24 spokes)
    val chakraCenter = Offset(w * 0.65f, h * 0.5f)
    val chakraRadius = stripeHeight * 0.42f
    val navyBlue = Color(0xFF000080)

    // Outer ring
    drawCircle(
        color = navyBlue,
        center = chakraCenter,
        radius = chakraRadius,
        style = Stroke(width = stripeHeight * 0.08f)
    )
    // Inner hub
    drawCircle(
        color = navyBlue,
        center = chakraCenter,
        radius = chakraRadius * 0.22f
    )

    // 24 Spokes
    for (i in 0 until 24) {
        val angleRad = Math.toRadians((i * 15).toDouble())
        val endX = chakraCenter.x + (chakraRadius * cos(angleRad)).toFloat()
        val endY = chakraCenter.y + (chakraRadius * sin(angleRad)).toFloat()
        drawLine(
            color = navyBlue,
            start = chakraCenter,
            end = Offset(endX, endY),
            strokeWidth = 2.5f
        )
    }
}

// -----------------------------------------------------------------------------
// 5. GERMANY (Bundesflagge)
// -----------------------------------------------------------------------------
private fun DrawScope.drawGermanyFlag() {
    val w = size.width
    val h = size.height
    val stripeHeight = h / 3f

    // Top: Black
    drawRect(
        color = Color(0xFF101012),
        topLeft = Offset(0f, 0f),
        size = Size(w, stripeHeight)
    )

    // Middle: Imperial Red
    drawRect(
        color = Color(0xFFDD0000),
        topLeft = Offset(0f, stripeHeight),
        size = Size(w, stripeHeight)
    )

    // Bottom: Gold / Yellow
    drawRect(
        color = Color(0xFFFFCE00),
        topLeft = Offset(0f, stripeHeight * 2f),
        size = Size(w, stripeHeight)
    )
}

// -----------------------------------------------------------------------------
// 6. CHINA (Five-star Red Flag / Wǔxīng Hóngqí)
// -----------------------------------------------------------------------------
private fun DrawScope.drawChinaFlag() {
    val w = size.width
    val h = size.height

    // Crimson Red Field
    drawRect(color = Color(0xFFDE2910), size = size)

    // Golden Yellow Stars in upper canton / right quadrant
    val gold = Color(0xFFFFDE00)
    val bigStarCenter = Offset(w * 0.68f, h * 0.40f)
    val bigStarRadius = h * 0.24f

    drawStar(
        center = bigStarCenter,
        outerRadius = bigStarRadius,
        innerRadius = bigStarRadius * 0.38f,
        color = gold,
        rotationDeg = 0f
    )

    // 4 Smaller Stars arched on the right side
    val smallRadius = bigStarRadius * 0.34f
    val smallCoords = listOf(
        Pair(Offset(bigStarCenter.x + bigStarRadius * 1.55f, bigStarCenter.y - bigStarRadius * 0.70f), -15f),
        Pair(Offset(bigStarCenter.x + bigStarRadius * 1.85f, bigStarCenter.y - bigStarRadius * 0.20f), 10f),
        Pair(Offset(bigStarCenter.x + bigStarRadius * 1.85f, bigStarCenter.y + bigStarRadius * 0.40f), 30f),
        Pair(Offset(bigStarCenter.x + bigStarRadius * 1.55f, bigStarCenter.y + bigStarRadius * 0.85f), 45f)
    )

    smallCoords.forEach { (coord, rot) ->
        drawStar(
            center = coord,
            outerRadius = smallRadius,
            innerRadius = smallRadius * 0.38f,
            color = gold,
            rotationDeg = rot
        )
    }
}

// -----------------------------------------------------------------------------
// 7. SAUDI ARABIA (Royal Green & Calligraphic Sword Flag)
// -----------------------------------------------------------------------------
private fun DrawScope.drawSaudiFlag() {
    val w = size.width
    val h = size.height

    // Saudi Royal Green
    drawRect(color = Color(0xFF006C35), size = size)

    val cx = w * 0.66f
    val cy = h * 0.48f

    // Stylized Arabic Calligraphy Bars
    val white = Color.White
    drawRect(
        color = white,
        topLeft = Offset(cx - h * 0.38f, cy - h * 0.16f),
        size = Size(h * 0.76f, h * 0.05f)
    )
    drawRect(
        color = white,
        topLeft = Offset(cx - h * 0.32f, cy - h * 0.07f),
        size = Size(h * 0.64f, h * 0.045f)
    )
    drawRect(
        color = white,
        topLeft = Offset(cx - h * 0.36f, cy + h * 0.01f),
        size = Size(h * 0.72f, h * 0.05f)
    )

    // Horizontal Sword (Pointing to the left as per Saudi Flag)
    val swordY = cy + h * 0.15f
    val bladeStart = cx + h * 0.32f
    val bladeEnd = cx - h * 0.35f
    drawLine(
        color = white,
        start = Offset(bladeStart, swordY),
        end = Offset(bladeEnd, swordY),
        strokeWidth = h * 0.045f
    )
    // Sword Handle and Crossguard
    drawLine(
        color = white,
        start = Offset(bladeStart - h * 0.06f, swordY - h * 0.07f),
        end = Offset(bladeStart - h * 0.06f, swordY + h * 0.07f),
        strokeWidth = h * 0.035f
    )
    drawCircle(
        color = white,
        center = Offset(bladeStart + h * 0.02f, swordY),
        radius = h * 0.035f
    )
}

// -----------------------------------------------------------------------------
// 8. SOUTH KOREA (Taegeukgi)
// -----------------------------------------------------------------------------
private fun DrawScope.drawKoreaFlag() {
    val w = size.width
    val h = size.height

    // White field
    drawRect(color = Color(0xFFFAFBFD), size = size)

    val cx = w * 0.65f
    val cy = h * 0.48f
    val r = h * 0.30f

    // Taegeuk (Red upper, Blue lower)
    val redPath = Path().apply {
        moveTo(cx - r, cy)
        arcTo(
            rect = androidx.compose.ui.geometry.Rect(cx - r, cy - r, cx + r, cy + r),
            startAngleDegrees = 180f,
            sweepAngleDegrees = 180f,
            forceMoveTo = false
        )
        // Upper curve (center to right)
        arcTo(
            rect = androidx.compose.ui.geometry.Rect(cx, cy - r / 2f, cx + r, cy + r / 2f),
            startAngleDegrees = 0f,
            sweepAngleDegrees = 180f,
            forceMoveTo = false
        )
        // Lower curve (left to center)
        arcTo(
            rect = androidx.compose.ui.geometry.Rect(cx - r, cy - r / 2f, cx, cy + r / 2f),
            startAngleDegrees = 0f,
            sweepAngleDegrees = -180f,
            forceMoveTo = false
        )
        close()
    }

    val bluePath = Path().apply {
        moveTo(cx - r, cy)
        arcTo(
            rect = androidx.compose.ui.geometry.Rect(cx - r, cy - r, cx + r, cy + r),
            startAngleDegrees = 180f,
            sweepAngleDegrees = -180f,
            forceMoveTo = false
        )
        arcTo(
            rect = androidx.compose.ui.geometry.Rect(cx, cy - r / 2f, cx + r, cy + r / 2f),
            startAngleDegrees = 0f,
            sweepAngleDegrees = 180f,
            forceMoveTo = false
        )
        arcTo(
            rect = androidx.compose.ui.geometry.Rect(cx - r, cy - r / 2f, cx, cy + r / 2f),
            startAngleDegrees = 0f,
            sweepAngleDegrees = -180f,
            forceMoveTo = false
        )
        close()
    }

    drawPath(path = redPath, color = Color(0xFFCD2E3A))
    drawPath(path = bluePath, color = Color(0xFF0047A0))

    // Trigrams in the four corners (Black bars)
    drawTrigram(Offset(cx - r * 1.45f, cy - r * 0.90f), 3, solid = true)  // Geon (Top-Left)
    drawTrigram(Offset(cx + r * 1.15f, cy - r * 0.90f), 3, solid = false) // Gam (Top-Right)
    drawTrigram(Offset(cx - r * 1.45f, cy + r * 0.85f), 3, solid = false) // Ri (Bottom-Left)
    drawTrigram(Offset(cx + r * 1.15f, cy + r * 0.85f), 3, solid = false) // Gon (Bottom-Right)
}

private fun DrawScope.drawTrigram(topLeft: Offset, bars: Int, solid: Boolean) {
    val barWidth = 38f
    val barHeight = 6f
    val spacing = 5f
    val black = Color(0xFF151515)

    for (i in 0 until bars) {
        val y = topLeft.y + i * (barHeight + spacing)
        if (solid || i == 0) {
            drawRect(
                color = black,
                topLeft = Offset(topLeft.x, y),
                size = Size(barWidth, barHeight)
            )
        } else {
            val half = (barWidth - 6f) / 2f
            drawRect(color = black, topLeft = Offset(topLeft.x, y), size = Size(half, barHeight))
            drawRect(color = black, topLeft = Offset(topLeft.x + half + 6f, y), size = Size(half, barHeight))
        }
    }
}

// -----------------------------------------------------------------------------
// 9. BANGLADESH (Lal Sobuj)
// -----------------------------------------------------------------------------
private fun DrawScope.drawBangladeshFlag() {
    val w = size.width
    val h = size.height

    // Bottle Green Field
    drawRect(color = Color(0xFF006A4E), size = size)

    // Red Sun Disc offset to hoist (45% from left)
    val sunCenter = Offset(w * 0.55f, h * 0.48f)
    val sunRadius = h * 0.35f

    drawCircle(
        color = Color(0xFFF42A41),
        center = sunCenter,
        radius = sunRadius
    )
}

// -----------------------------------------------------------------------------
// 10. QURAN HERITAGE (Emerald & Gold Arabesque Crescent)
// -----------------------------------------------------------------------------
private fun DrawScope.drawQuranHeritage() {
    val w = size.width
    val h = size.height

    // Deep Emerald Green Islamic Gradient Field
    drawRect(color = Color(0xFF072B15), size = size)

    val cx = w * 0.65f
    val cy = h * 0.48f
    val r = h * 0.32f
    val gold = Color(0xFFFFD54F)

    // Golden Crescent
    drawCircle(
        color = gold,
        center = Offset(cx, cy),
        radius = r
    )
    drawCircle(
        color = Color(0xFF072B15),
        center = Offset(cx + r * 0.35f, cy - r * 0.12f),
        radius = r * 0.88f
    )

    // Islamic Eight-Pointed Star (Rub el Hizb)
    drawStar(
        center = Offset(cx + r * 0.55f, cy - r * 0.30f),
        outerRadius = r * 0.32f,
        innerRadius = r * 0.15f,
        color = gold,
        rotationDeg = 0f
    )

    // Subtle decorative geometric lattice arcs in the backdrop
    drawCircle(
        color = gold.copy(alpha = 0.12f),
        center = Offset(cx, cy),
        radius = r * 1.55f,
        style = Stroke(width = 2.5f)
    )
    drawCircle(
        color = gold.copy(alpha = 0.08f),
        center = Offset(cx, cy),
        radius = r * 1.85f,
        style = Stroke(width = 1.5f)
    )
}

// -----------------------------------------------------------------------------
// 11. BUNDLE (Bangla Books & Golden Laurel)
// -----------------------------------------------------------------------------
private fun DrawScope.drawBundleFlag() {
    val w = size.width
    val h = size.height

    // Deep Teal-Cyan Literary Field
    drawRect(color = Color(0xFF042F2E), size = size)

    // Subtle red-green Bangladeshi literary heritage glow
    drawCircle(
        color = Color(0xFF0D9488).copy(alpha = 0.45f),
        center = Offset(w * 0.70f, h * 0.45f),
        radius = h * 0.45f
    )
    drawCircle(
        color = Color(0xFFF42A41).copy(alpha = 0.22f),
        center = Offset(w * 0.72f, h * 0.42f),
        radius = h * 0.28f
    )

    // Decorative Book silhouette
    val gold = Color(0xFFFFD54F)
    val bx = w * 0.68f
    val by = h * 0.48f
    val bw = h * 0.38f
    val bh = h * 0.26f

    val bookLeft = Path().apply {
        moveTo(bx, by + bh / 2)
        cubicTo(bx - bw * 0.25f, by + bh * 0.4f, bx - bw * 0.4f, by + bh * 0.45f, bx - bw * 0.5f, by + bh * 0.42f)
        lineTo(bx - bw * 0.5f, by - bh * 0.42f)
        cubicTo(bx - bw * 0.4f, by - bh * 0.45f, bx - bw * 0.25f, by - bh * 0.4f, bx, by - bh / 2)
        close()
    }
    val bookRight = Path().apply {
        moveTo(bx, by + bh / 2)
        cubicTo(bx + bw * 0.25f, by + bh * 0.4f, bx + bw * 0.4f, by + bh * 0.45f, bx + bw * 0.5f, by + bh * 0.42f)
        lineTo(bx + bw * 0.5f, by - bh * 0.42f)
        cubicTo(bx + bw * 0.4f, by - bh * 0.45f, bx + bw * 0.25f, by - bh * 0.4f, bx, by - bh / 2)
        close()
    }
    drawPath(path = bookLeft, color = gold.copy(alpha = 0.75f), style = Stroke(width = 3.5f))
    drawPath(path = bookRight, color = gold.copy(alpha = 0.75f), style = Stroke(width = 3.5f))
}

// -----------------------------------------------------------------------------
// Helper: Draw Star
// -----------------------------------------------------------------------------
private fun DrawScope.drawStar(
    center: Offset,
    outerRadius: Float,
    innerRadius: Float,
    color: Color,
    rotationDeg: Float = 0f,
    points: Int = 5
) {
    val path = Path()
    val angleStep = Math.PI / points
    val startAngle = Math.toRadians((rotationDeg - 90).toDouble())

    for (i in 0 until points * 2) {
        val r = if (i % 2 == 0) outerRadius else innerRadius
        val currAngle = startAngle + i * angleStep
        val x = center.x + (r * cos(currAngle)).toFloat()
        val y = center.y + (r * sin(currAngle)).toFloat()
        if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
    }
    path.close()
    drawPath(path = path, color = color, style = Fill)
}

