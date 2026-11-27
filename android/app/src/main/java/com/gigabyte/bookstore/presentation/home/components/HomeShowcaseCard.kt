package com.gigabyte.bookstore.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.gigabyte.bookstore.presentation.components.CountryFlagBackdrop
import com.gigabyte.bookstore.presentation.components.CourseCountry
import com.gigabyte.bookstore.ui.theme.GoldenAccent

@Composable
fun HomeShowcaseCard(
    title: String,
    subtitle: String?,
    badgeText: String,
    badgeColor: Color,
    priceText: String,
    isPurchased: Boolean,
    imageUrl: String?,
    fallbackGradientColors: List<Color> = emptyList(),
    accentColor: Color,
    statsText: String? = null,
    ctaText: String = "বিস্তারিত দেখুন →",
    country: CourseCountry? = null,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 200.dp)
            .clip(RoundedCornerShape(20.dp))
            .border(
                width = 1.5.dp,
                color = accentColor.copy(alpha = 0.55f),
                shape = RoundedCornerShape(20.dp)
            )
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 200.dp)
        ) {
            // Background Image or Quran Backdrop or Standard Gradient
            if (!imageUrl.isNullOrBlank()) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.matchParentSize()
                )
            } else if (country == CourseCountry.QURAN) {
                CountryFlagBackdrop(
                    country = country,
                    modifier = Modifier.matchParentSize()
                )
            } else {
                val gradientColors = if (fallbackGradientColors.isNotEmpty()) {
                    fallbackGradientColors
                } else {
                    listOf(
                        accentColor.copy(alpha = 0.90f),
                        accentColor.copy(alpha = 0.60f),
                        Color(0xFF0F172A)
                    )
                }
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(Brush.linearGradient(gradientColors))
                )
            }

            // Dark Multi-stop Gradient Overlay for guaranteed crystal-clear text readability over flags
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Black.copy(alpha = 0.35f),
                                Color(0xFF040A0D).copy(alpha = 0.68f),
                                Color(0xFF020608).copy(alpha = 0.94f)
                            )
                        )
                    )
            )

            // Content Column
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 200.dp)
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Top Bar: Badge & Price
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        color = badgeColor.copy(alpha = 0.92f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = badgeText,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 11.sp
                            ),
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                        )
                    }

                    Surface(
                        color = if (isPurchased) Color(0xFF10B981) else GoldenAccent,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = if (isPurchased) "✓ আনলকড" else priceText,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                color = if (isPurchased) Color.White else Color(0xFF0F172A),
                                fontSize = 12.sp
                            ),
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                        )
                    }
                }

                // Middle & Bottom Section
                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.White
                        ),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    if (!subtitle.isNullOrBlank()) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = subtitle,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 12.sp,
                                color = Color.White.copy(alpha = 0.82f)
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Footer Row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (!statsText.isNullOrBlank()) {
                            Text(
                                text = statsText,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.weight(1f, fill = false),
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontSize = 11.sp,
                                    color = GoldenAccent,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                        } else {
                            Spacer(modifier = Modifier.weight(1f))
                        }

                        val isBrightAccent = (0.299 * accentColor.red + 0.587 * accentColor.green + 0.114 * accentColor.blue) > 0.55
                        val buttonTextColor = if (isBrightAccent) Color(0xFF0F172A) else Color.White

                        Surface(
                            color = accentColor,
                            shape = RoundedCornerShape(12.dp),
                            shadowElevation = 3.dp,
                            modifier = Modifier.clip(RoundedCornerShape(12.dp))
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .heightIn(min = 36.dp)
                                    .padding(horizontal = 14.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = ctaText,
                                    maxLines = 1,
                                    softWrap = false,
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = buttonTextColor,
                                        fontSize = 12.sp
                                    )
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                    contentDescription = null,
                                    tint = buttonTextColor,
                                    modifier = Modifier.size(13.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
