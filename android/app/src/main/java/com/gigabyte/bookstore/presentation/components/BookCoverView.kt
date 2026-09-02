package com.gigabyte.bookstore.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Headphones
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

private val CoverGradients = listOf(
    listOf(Color(0xFF004D40), Color(0xFF00796B), Color(0xFF00241B)),
    listOf(Color(0xFF1A237E), Color(0xFF283593), Color(0xFF0D1238)),
    listOf(Color(0xFF4A148C), Color(0xFF6A1B9A), Color(0xFF240747)),
    listOf(Color(0xFF880E4F), Color(0xFFAD1457), Color(0xFF420425)),
    listOf(Color(0xFFB71C1C), Color(0xFFC62828), Color(0xFF4A0808)),
    listOf(Color(0xFFBF360C), Color(0xFFD84315), Color(0xFF4E1400))
)

@Composable
fun BookCoverView(
    title: String,
    author: String?,
    modifier: Modifier = Modifier,
    coverPath: String? = null,
    cornerRadius: Dp = 12.dp,
    elevation: Dp = 4.dp
) {
    val gradientIndex = (title.hashCode().let { if (it < 0) -it else it }) % CoverGradients.size
    val gradientColors = CoverGradients[gradientIndex]

    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .testTag("book_cover_card"),
        shape = RoundedCornerShape(cornerRadius),
        tonalElevation = elevation,
        shadowElevation = elevation
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            if (!coverPath.isNullOrBlank()) {
                AsyncImage(
                    model = coverPath,
                    contentDescription = "কভার ছবি - $title",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                // Generated artistic cover
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = gradientColors
                            )
                        )
                        .padding(14.dp)
                ) {
                    // Top sound badge
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.AutoStories,
                            contentDescription = null,
                            tint = Color.White.copy(alpha = 0.7f),
                            modifier = Modifier.size(18.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Headphones,
                            contentDescription = null,
                            tint = Color(0xFFFFD54F),
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    // Centered Content
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(RoundedCornerShape(22.dp))
                                .background(Color.White.copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = title.take(1),
                                color = Color(0xFFFFD54F),
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                lineHeight = 20.sp
                            ),
                            textAlign = TextAlign.Center,
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis
                        )

                        if (!author.isNullOrBlank()) {
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = author,
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = Color.White.copy(alpha = 0.85f),
                                    fontSize = 12.sp
                                ),
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    // Bottom Bangla Audiobook label
                    Text(
                        text = "বাংলা অডিওবুক",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = Color.White.copy(alpha = 0.5f),
                            fontSize = 9.sp,
                            letterSpacing = 1.sp
                        ),
                        modifier = Modifier.align(Alignment.BottomCenter)
                    )
                }
            }
        }
    }
}
