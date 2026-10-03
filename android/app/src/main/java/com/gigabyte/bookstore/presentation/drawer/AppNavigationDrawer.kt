package com.gigabyte.bookstore.presentation.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gigabyte.bookstore.ui.theme.DarkStatusBarColor
import com.gigabyte.bookstore.ui.theme.LightStatusBarColor

@Composable
fun AppDrawerContent(
    userName: String,
    userEmail: String,
    userInstitute: String,
    userStatus: String,
    userBalance: Double,
    onProfileClick: () -> Unit,
    onLastReadClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    onPaymentClick: () -> Unit,
    onApprovePaymentsClick: () -> Unit,
    onReferralClick: () -> Unit,
    onAboutUsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isDark = MaterialTheme.colorScheme.surface.luminance() < 0.5f
    val actualStatusBarColor = if (isDark) DarkStatusBarColor else LightStatusBarColor

    // Cohesive executive teal gradient matching App Bar
    val headerBrush = if (isDark) {
        Brush.verticalGradient(
            colors = listOf(
                Color(0xFF102621),
                Color(0xFF16322C)
            )
        )
    } else {
        Brush.verticalGradient(
            colors = listOf(
                Color(0xFF004D40),
                Color(0xFF00695C)
            )
        )
    }

    ModalDrawerSheet(
        modifier = modifier.width(320.dp),
        drawerContainerColor = MaterialTheme.colorScheme.surface,
        windowInsets = WindowInsets(0, 0, 0, 0)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // 1. Status bar area spacer matching the exact system status bar
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsTopHeight(WindowInsets.statusBars)
                    .background(actualStatusBarColor)
            )

            // Scrollable upper content
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                // 2. Redesigned User Info Card (Clean, modern layout without top gap)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = headerBrush,
                            shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                        )
                        .padding(horizontal = 20.dp, vertical = 18.dp)
                ) {
                    Column {
                        // User Profile: Avatar + Name & Email
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Avatar with warm amber/gold border
                            Box(
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                                    .border(2.dp, Color(0xFFFFD54F), CircleShape)
                                    .background(Color.White.copy(alpha = 0.2f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = userName.take(1).uppercase().ifBlank { "U" },
                                    fontSize = 26.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = userName.ifBlank { "User" },
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = userEmail.ifBlank { "No email registered" },
                                    fontSize = 12.sp,
                                    color = Color.White.copy(alpha = 0.85f),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )

                                if (userInstitute.isNotBlank()) {
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(Color.White.copy(alpha = 0.15f))
                                            .padding(horizontal = 6.dp, vertical = 2.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.School,
                                            contentDescription = null,
                                            tint = Color(0xFFFFE082),
                                            modifier = Modifier.size(12.dp)
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(
                                            text = userInstitute,
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = Color.White,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Status Badge & Balance Chip Row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val isPaid = userStatus.equals("paid", ignoreCase = true) || userStatus.equals("active", ignoreCase = true)

                            // Status Pill
                            Surface(
                                color = if (isPaid) Color(0xFF065F46) else Color(0xFF78350F),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.border(
                                    width = 1.dp,
                                    color = if (isPaid) Color(0xFF34D399).copy(alpha = 0.6f) else Color(0xFFFBBF24).copy(alpha = 0.6f),
                                    shape = RoundedCornerShape(10.dp)
                                )
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = if (isPaid) Icons.Default.Verified else Icons.Default.HourglassTop,
                                        contentDescription = null,
                                        tint = if (isPaid) Color(0xFF34D399) else Color(0xFFFBBF24),
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isPaid) "PRO MEMBER" else "TRIAL USER",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isPaid) Color(0xFFECFDF5) else Color(0xFFFFFBEB)
                                    )
                                }
                            }

                            // Balance Pill
                            Surface(
                                color = Color.White.copy(alpha = 0.15f),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.border(
                                    width = 1.dp,
                                    color = Color.White.copy(alpha = 0.25f),
                                    shape = RoundedCornerShape(10.dp)
                                )
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.AccountBalanceWallet,
                                        contentDescription = null,
                                        tint = Color(0xFFFFD54F),
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "৳ ${"%.2f".format(userBalance)}",
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Section 1: লাইব্রেরি ও অ্যাক্টিভিটি
                DrawerSectionHeader(title = "লাইব্রেরি ও অ্যাক্টিভিটি")

                DrawerMenuItem(
                    icon = Icons.Default.AccountCircle,
                    title = "প্রোফাইল আপডেট (Profile Update)",
                    onClick = onProfileClick
                )

                DrawerMenuItem(
                    icon = Icons.Default.History,
                    title = "সম্প্রতি পড়া (Last Read)",
                    onClick = onLastReadClick
                )

                DrawerMenuItem(
                    icon = Icons.Default.Bookmark,
                    title = "বুকমার্কসমূহ (Bookmarks)",
                    onClick = onBookmarksClick
                )

                Spacer(modifier = Modifier.height(8.dp))

                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 6.dp),
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.35f)
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Section 2: অ্যাকাউন্ট ও সেবা
                DrawerSectionHeader(title = "অ্যাকাউন্ট ও সেবা")

                DrawerMenuItem(
                    icon = Icons.Default.CardGiftcard,
                    title = "রেফার ও আয় (Learn & Earn)",
                    badge = "৳২০",
                    badgeColor = Color(0xFF10B981),
                    onClick = onReferralClick
                )

                DrawerMenuItem(
                    icon = Icons.Default.Payment,
                    title = "পেমেন্ট নির্দেশনা (Payment Info)",
                    onClick = onPaymentClick
                )

                DrawerMenuItem(
                    icon = Icons.Default.CheckCircle,
                    title = "পেমেন্ট অনুমোদন (Approve Payments)",
                    onClick = onApprovePaymentsClick
                )

                DrawerMenuItem(
                    icon = Icons.Default.Info,
                    title = "আমাদের সম্পর্কে (About Us)",
                    onClick = onAboutUsClick
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            // Pinned Bottom Footer
            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.35f)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Headphones,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "AudioBook Studio v1.2",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Bangla Audiobook Library",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                    )
                }
            }
        }
    }
}

@Composable
private fun DrawerSectionHeader(title: String) {
    Text(
        text = title.uppercase(),
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.6.sp,
        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.85f),
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)
    )
}

@Composable
private fun DrawerMenuItem(
    icon: ImageVector,
    title: String,
    badge: String? = null,
    badgeColor: Color = Color(0xFF10B981),
    onClick: () -> Unit
) {
    NavigationDrawerItem(
        icon = {
            Surface(
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f),
                shape = CircleShape,
                modifier = Modifier.size(34.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        },
        label = {
            Text(
                text = title,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Medium
            )
        },
        badge = if (badge != null) {
            {
                Surface(
                    color = badgeColor.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(8.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, badgeColor.copy(alpha = 0.4f))
                ) {
                    Text(
                        text = badge,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = badgeColor,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                }
            }
        } else null,
        selected = false,
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 2.dp),
        shape = RoundedCornerShape(12.dp)
    )
}
