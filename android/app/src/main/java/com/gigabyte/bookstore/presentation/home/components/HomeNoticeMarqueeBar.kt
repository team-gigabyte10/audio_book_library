package com.gigabyte.bookstore.presentation.home.components

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gigabyte.bookstore.data.models.AppNotice
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HomeNoticeMarqueeBar(
    notice: AppNotice?,
    isAdmin: Boolean = false,
    onAdminManageClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    if (notice == null || !notice.isActive || notice.message.isBlank()) {
        return
    }

    var showDetailDialog by remember { mutableStateOf(false) }

    val accentAmber = Color(0xFFD97706)
    val containerBg = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
    val textMarqueeColor = MaterialTheme.colorScheme.onSurface

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = containerBg),
        border = BorderStroke(1.dp, accentAmber.copy(alpha = 0.4f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { showDetailDialog = true }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Notice Tag Badge with Megaphone icon
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = accentAmber
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Campaign,
                        contentDescription = "Notice",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "বিজ্ঞপ্তি",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 11.sp
                    )
                }
            }

            // Marquee Scrolling Text
            val marqueeText = if (notice.title.isNotBlank()) {
                "${notice.title} — ${notice.message}     ✦     ${notice.title} — ${notice.message}"
            } else {
                "${notice.message}     ✦     ${notice.message}"
            }

            Text(
                text = marqueeText,
                modifier = Modifier
                    .weight(1f)
                    .basicMarquee(
                        iterations = Int.MAX_VALUE,
                        velocity = 45.dp
                    ),
                maxLines = 1,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = textMarqueeColor
            )

            // Admin edit icon if user has admin privileges
            if (isAdmin) {
                Surface(
                    shape = CircleShape,
                    color = accentAmber.copy(alpha = 0.15f),
                    modifier = Modifier.clickable { onAdminManageClick() }
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "নোটিশ সম্পাদনা",
                        tint = accentAmber,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(14.dp)
                    )
                }
            }
        }
    }

    // Notice Detail Popup Dialog
    if (showDetailDialog) {
        NoticeDetailDialog(
            notice = notice,
            onDismiss = { showDetailDialog = false }
        )
    }
}

@Composable
private fun NoticeDetailDialog(
    notice: AppNotice,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val formattedDate = remember(notice.createdAt) {
        try {
            val sdf = SimpleDateFormat("dd MMMM yyyy, hh:mm a", Locale.getDefault())
            sdf.format(Date(notice.createdAt))
        } catch (e: Exception) {
            ""
        }
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Campaign,
                        contentDescription = null,
                        tint = Color(0xFFD97706),
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = if (notice.title.isNotBlank()) notice.title else "জরুরি বিজ্ঞপ্তি",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                IconButton(onClick = onDismiss, modifier = Modifier.size(32.dp)) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "বন্ধ করুন")
                }
            }
        },
        text = {
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
            ) {
                if (formattedDate.isNotBlank()) {
                    Text(
                        text = "প্রকাশিত: $formattedDate",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
                    Spacer(modifier = Modifier.height(10.dp))
                }

                Text(
                    text = notice.message,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    lineHeight = 22.sp
                )

                if (!notice.actionUrl.isNullOrBlank()) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            try {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(notice.actionUrl))
                                context.startActivity(intent)
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706)),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(imageVector = Icons.Default.OpenInNew, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(text = "বিস্তারিত দেখুন / লিংকে যান", fontWeight = FontWeight.Bold)
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "ঠিক আছে", fontWeight = FontWeight.Bold)
            }
        },
        shape = RoundedCornerShape(18.dp)
    )
}
