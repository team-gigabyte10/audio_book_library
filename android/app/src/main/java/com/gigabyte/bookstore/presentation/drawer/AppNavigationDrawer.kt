package com.gigabyte.bookstore.presentation.drawer

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.models.AppPricingConfig
import com.gigabyte.bookstore.presentation.components.UserQrCodeDialog
import com.gigabyte.bookstore.ui.theme.DarkStatusBarColor
import com.gigabyte.bookstore.ui.theme.LightStatusBarColor

@Composable
fun AppDrawerContent(
    userName: String,
    userEmail: String,
    userInstitute: String,
    userStatus: String,
    userBalance: Double,
    isAdmin: Boolean = false,
    onProfileClick: () -> Unit,
    onLastReadClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    onPaymentClick: () -> Unit,
    onApprovePaymentsClick: () -> Unit,
    onReferralClick: () -> Unit,
    onReferAndEarnClick: (() -> Unit)? = null,
    onAboutUsClick: () -> Unit,
    onHomeClick: (() -> Unit)? = null,
    onLibraryClick: (() -> Unit)? = null,
    onLogoutClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    var showLogoutConfirm by remember { mutableStateOf(false) }
    if (showLogoutConfirm && onLogoutClick != null) {
        LogoutConfirmDialog(
            userName = userName,
            userEmail = userEmail,
            onDismiss = { showLogoutConfirm = false },
            onConfirm = {
                showLogoutConfirm = false
                onLogoutClick()
            }
        )
    }

    val isDark = MaterialTheme.colorScheme.surface.luminance() < 0.5f
    val actualStatusBarColor = if (isDark) DarkStatusBarColor else LightStatusBarColor

    val context = LocalContext.current
    val app = context.applicationContext as? BanglaAudiobookApp
    val pricingConfig = app?.appPreferences?.pricingConfig?.collectAsStateWithLifecycle()?.value ?: AppPricingConfig()
    var showQrCodeDialog by remember { mutableStateOf(false) }

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

                            Spacer(modifier = Modifier.width(8.dp))

                            IconButton(
                                onClick = { showQrCodeDialog = true },
                                modifier = Modifier
                                    .size(38.dp)
                                    .clip(CircleShape)
                                    .background(Color.White.copy(alpha = 0.2f))
                            ) {
                                Icon(
                                    imageVector = Icons.Default.QrCode,
                                    contentDescription = "My QR Code",
                                    tint = Color(0xFFFFD54F),
                                    modifier = Modifier.size(22.dp)
                                )
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
                DrawerSectionHeader(title = "ন্যাভিগেশন ও লাইব্রেরি")

                DrawerMenuItem(
                    icon = Icons.Default.History,
                    title = "সর্বশেষ পড়া ও শোনা (Last Read)",
                    onClick = onLastReadClick
                )

                DrawerMenuItem(
                    icon = Icons.Default.AccountCircle,
                    title = "প্রোফাইল আপডেট (Profile Update)",
                    onClick = onProfileClick
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
                    title = "রেফার ও আয় (Reffer and Earn)",
                    badge = "৳${pricingConfig.singleReferralBonus.toInt()}",
                    badgeColor = Color(0xFF10B981),
                    onClick = onReferAndEarnClick ?: onReferralClick
                )

                DrawerMenuItem(
                    icon = Icons.Default.AccountBalanceWallet,
                    title = "আমার ওয়ালেট ও উইথড্র (My Wallet)",
                    badge = "৳${"%.0f".format(userBalance)}",
                    badgeColor = Color(0xFF8B5CF6),
                    onClick = onReferralClick
                )

                DrawerMenuItem(
                    icon = Icons.Default.Payment,
                    title = "পেমেন্ট নির্দেশনা (Payment Info)",
                    onClick = onPaymentClick
                )

                if (isAdmin) {
                    DrawerMenuItem(
                        icon = Icons.Default.CheckCircle,
                        title = "পেমেন্ট অনুমোদন (Approve Payments)",
                        onClick = onApprovePaymentsClick
                    )
                }

                DrawerMenuItem(
                    icon = Icons.Default.Info,
                    title = "আমাদের সম্পর্কে (About Us)",
                    onClick = onAboutUsClick
                )

                if (onLogoutClick != null) {
                    DrawerMenuItem(
                        icon = Icons.AutoMirrored.Filled.Logout,
                        title = "লগআউট (Logout)",
                        onClick = { showLogoutConfirm = true }
                    )
                }

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
                        text = "বাংলা অডিওবুক ও স্পোকেন কোর্স",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                    )
                }
            }
        }

        if (showQrCodeDialog) {
            UserQrCodeDialog(
                userName = userName,
                userEmail = userEmail,
                onDismiss = { showQrCodeDialog = false }
            )
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

/**
 * Modern, beautifully styled Logout Confirmation Dialog with account context and data security reassurance.
 */
@Composable
fun LogoutConfirmDialog(
    userName: String,
    userEmail: String,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(22.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 6.dp,
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(22.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Warning / Logout Icon Badge
                Surface(
                    shape = CircleShape,
                    color = Color(0xFFEF4444).copy(alpha = 0.12f),
                    modifier = Modifier.size(56.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Logout,
                            contentDescription = "Logout",
                            tint = Color(0xFFDC2626),
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = "লগআউট নিশ্চিতকরণ",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Current Account Card
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.35f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFF00695C),
                            modifier = Modifier.size(38.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = userName.take(1).uppercase().ifBlank { "U" },
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = userName.ifBlank { "ব্যবহারকারী" },
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = userEmail.ifBlank { "রেজিস্টার্ড ইমেইল" },
                                fontSize = 11.5.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Reassurance points
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color(0xFF10B981).copy(alpha = 0.08f),
                    border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.25f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(verticalAlignment = Alignment.Top) {
                            Text(text = "🛡️", fontSize = 12.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "আপনার কেনা সকল কোর্স, অডিওবুক ও ওয়ালেট ব্যালেন্স ১০০% নিরাপদ থাকবে।",
                                fontSize = 11.5.sp,
                                lineHeight = 16.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(verticalAlignment = Alignment.Top) {
                            Text(text = "🔑", fontSize = 12.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "যেকোনো সময় এই ইমেইল দিয়ে আবার লগইন করতে পারবেন।",
                                fontSize = 11.5.sp,
                                lineHeight = 16.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                // Action Buttons Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = onDismiss,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.weight(1f),
                        contentPadding = PaddingValues(vertical = 10.dp)
                    ) {
                        Text(
                            text = "বাতিল",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 13.5.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Button(
                        onClick = onConfirm,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.weight(1f),
                        contentPadding = PaddingValues(vertical = 10.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Logout,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "লগআউট",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.5.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
