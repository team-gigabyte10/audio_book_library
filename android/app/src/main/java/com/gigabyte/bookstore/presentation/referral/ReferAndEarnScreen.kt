package com.gigabyte.bookstore.presentation.referral

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.models.AppPricingConfig
import com.gigabyte.bookstore.data.models.ReferredUserItem
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReferAndEarnScreen(
    onNavigateBack: () -> Unit,
    onNavigateToWallet: () -> Unit,
    onNavigateToPayment: (() -> Unit)? = null,
    viewModel: ReferralViewModel = viewModel()
) {
    val context = LocalContext.current
    val app = context.applicationContext as BanglaAudiobookApp
    val pricingConfig by app.appPreferences.pricingConfig.collectAsStateWithLifecycle()
    val localReferralCode by app.appPreferences.referralCode.collectAsStateWithLifecycle()
    val localBalance by app.appPreferences.userBalance.collectAsStateWithLifecycle()

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = { Text("রেফার ও আয় (Refer & Earn)") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.loadData() }) {
                        Icon(imageVector = Icons.Default.Refresh, contentDescription = "Refresh")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (val state = uiState) {
                is ReferralUiState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
                is ReferralUiState.Error -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(24.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.error,
                                modifier = Modifier.size(48.dp)
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(text = state.message, textAlign = TextAlign.Center)
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(onClick = { viewModel.loadData() }) {
                                Text("পুনরায় চেষ্টা করুন")
                            }
                        }
                    }
                }
                is ReferralUiState.Success -> {
                    val stats = state.stats
                    val refCode = stats.referralCode.ifBlank { localReferralCode }

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(top = 16.dp, bottom = 32.dp)
                    ) {
                        // 1. Promotional Hero Banner
                        item {
                            ReferAndEarnHeroCard(pricingConfig = pricingConfig)
                        }

                        // 2. Referral Code & Share Buttons Card
                        item {
                            ReferralCodeShareCard(
                                referralCode = refCode,
                                pricingConfig = pricingConfig,
                                onCopy = {
                                    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                    val clip = ClipData.newPlainText("Referral Code", refCode)
                                    clipboard.setPrimaryClip(clip)
                                    Toast.makeText(context, "রেফার কোড কপি করা হয়েছে!", Toast.LENGTH_SHORT).show()
                                },
                                onShare = {
                                    shareReferralIntent(context, refCode, pricingConfig)
                                }
                            )
                        }

                        // 3. Social Media 1-Tap Share Channels
                        item {
                            SocialShareChannelsCard(
                                referralCode = refCode,
                                pricingConfig = pricingConfig
                            )
                        }

                        // 4. How It Works (Backend Controlled 3 Steps)
                        item {
                            HowReferralWorksCard(pricingConfig = pricingConfig)
                        }

                        // 5. Referral Performance & Wallet CTA Card
                        item {
                            ReferralEarningsSummaryCard(
                                totalFriends = stats.totalFriendsJoined,
                                paidMembers = stats.paidMembersCount,
                                totalEarned = stats.totalEarned,
                                currentBalance = stats.currentBalance.coerceAtLeast(localBalance),
                                pricingConfig = pricingConfig,
                                onNavigateToWallet = onNavigateToWallet
                            )
                        }

                        // 6. Recent Referred Friends List
                        if (stats.referredUsers.isNotEmpty()) {
                            item {
                                Text(
                                    text = "আমন্ত্রিত বন্ধুদের তালিকা (${stats.referredUsers.size} জন)",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.padding(top = 6.dp)
                                )
                            }
                            items(stats.referredUsers.take(10)) { userItem ->
                                ReferredFriendItemCard(user = userItem)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ReferAndEarnHeroCard(pricingConfig: AppPricingConfig) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF064E3B),
                            Color(0xFF0F766E)
                        )
                    )
                )
                .padding(20.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Surface(
                    color = Color(0xFF10B981).copy(alpha = 0.25f),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, Color(0xFF34D399))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Stars,
                            contentDescription = null,
                            tint = Color(0xFFFBBF24),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "প্রতি রেফারে নগদ ৳${pricingConfig.singleReferralBonus.toInt()} থেকে ৳${pricingConfig.bundleReferralBonus.toInt()} বোনাস!",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = "বন্ধুদের রেফার করুন\nআনলিমিটেড আয় করুন!",
                    fontSize = 22.sp,
                    lineHeight = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "আপনার বন্ধুদের বাংলা অডিওবুক ও স্পোকেন কোর্স অ্যাপে আমন্ত্রণ জানান। বন্ধু যেকোনো কোর্স কিনলেই আপনার ওয়ালেটে সাথে সাথে বোনাস যোগ হবে!",
                    fontSize = 12.5.sp,
                    lineHeight = 18.sp,
                    color = Color(0xFFA7F3D0)
                )
            }
        }
    }
}

@Composable
private fun ReferralCodeShareCard(
    referralCode: String,
    pricingConfig: AppPricingConfig,
    onCopy: () -> Unit,
    onShare: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "🎁 আপনার নিজস্ব রেফারেল কোড",
                fontSize = 13.5.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(10.dp))

            Surface(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.5.dp, Color(0xFF10B981).copy(alpha = 0.6f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = referralCode.ifBlank { "..." },
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = 4.sp,
                    color = Color(0xFF047857),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "বন্ধু পেইড সাবস্ক্রিপশনে যেকোনো কোর্স (৳${pricingConfig.singleCoursePrice.toInt()}) নিলে আপনি পাবেন ৳${pricingConfig.singleReferralBonus.toInt()} এবং মেগা বান্ডেল (৳${pricingConfig.megaBundlePrice.toInt()}) নিলে পাবেন ৳${pricingConfig.bundleReferralBonus.toInt()} বোনাস!",
                fontSize = 12.sp,
                lineHeight = 17.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedButton(
                    onClick = onCopy,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(imageVector = Icons.Default.ContentCopy, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = "কপি কোড", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }

                Button(
                    onClick = onShare,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = "শেয়ার করুন", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
            }
        }
    }
}

@Composable
private fun SocialShareChannelsCard(
    referralCode: String,
    pricingConfig: AppPricingConfig
) {
    val context = LocalContext.current
    val shareText = createShareMessage(referralCode, pricingConfig)

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)
        )
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Text(
                text = "📲 সরাসরি সোশ্যাল মিডিয়ায় শেয়ার করুন:",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                SocialShareButton(
                    label = "WhatsApp",
                    iconColor = Color(0xFF25D366),
                    icon = Icons.Default.Chat,
                    onClick = {
                        try {
                            val intent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                `package` = "com.whatsapp"
                                putExtra(Intent.EXTRA_TEXT, shareText)
                            }
                            context.startActivity(intent)
                        } catch (e: Exception) {
                            shareReferralIntent(context, referralCode, pricingConfig)
                        }
                    }
                )

                SocialShareButton(
                    label = "Messenger",
                    iconColor = Color(0xFF0084FF),
                    icon = Icons.Default.Send,
                    onClick = {
                        try {
                            val intent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                `package` = "com.facebook.orca"
                                putExtra(Intent.EXTRA_TEXT, shareText)
                            }
                            context.startActivity(intent)
                        } catch (e: Exception) {
                            shareReferralIntent(context, referralCode, pricingConfig)
                        }
                    }
                )

                SocialShareButton(
                    label = "Telegram",
                    iconColor = Color(0xFF0088CC),
                    icon = Icons.Default.Send,
                    onClick = {
                        try {
                            val intent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                `package` = "org.telegram.messenger"
                                putExtra(Intent.EXTRA_TEXT, shareText)
                            }
                            context.startActivity(intent)
                        } catch (e: Exception) {
                            shareReferralIntent(context, referralCode, pricingConfig)
                        }
                    }
                )

                SocialShareButton(
                    label = "SMS",
                    iconColor = Color(0xFF10B981),
                    icon = Icons.Default.Sms,
                    onClick = {
                        try {
                            val intent = Intent(Intent.ACTION_VIEW).apply {
                                data = Uri.parse("sms:")
                                putExtra("sms_body", shareText)
                            }
                            context.startActivity(intent)
                        } catch (e: Exception) {
                            shareReferralIntent(context, referralCode, pricingConfig)
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun SocialShareButton(
    label: String,
    iconColor: Color,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(4.dp)
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .size(46.dp)
                .background(iconColor.copy(alpha = 0.15f), CircleShape)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = iconColor,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun HowReferralWorksCard(pricingConfig: AppPricingConfig) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.35f)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "কীভাবে আয় করবেন? (৩টি সহজ ধাপ)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }

            ReferStepItem(
                number = "১",
                title = "রেফার কোড শেয়ার করুন",
                description = "ফেসবুক, হোয়াটসঅ্যাপ বা মেসেঞ্জারে বন্ধুদের সাথে আপনার রেফারেল কোড বা লিংক শেয়ার করুন।"
            )
            ReferStepItem(
                number = "২",
                title = "বন্ধু ফ্রি সাইন-আপ করবে",
                description = "বন্ধু অ্যাপ ডাউনলোড করে রেজিস্ট্রেশনের সময় আপনার কোডটি ব্যবহার করবে।"
            )
            ReferStepItem(
                number = "৩",
                title = "নগদ ৳${pricingConfig.singleReferralBonus.toInt()} থেকে ৳${pricingConfig.bundleReferralBonus.toInt()} বোনাস পান",
                description = "বন্ধু যেকোনো কোর্স (৳${pricingConfig.singleCoursePrice.toInt()}) কিনলে পাবেন ৳${pricingConfig.singleReferralBonus.toInt()} এবং মেগা বান্ডেল (৳${pricingConfig.megaBundlePrice.toInt()}) কিনলে সাথে সাথে আপনার ওয়ালেটে ৳${pricingConfig.bundleReferralBonus.toInt()} জমা হবে!"
            )
        }
    }
}

@Composable
private fun ReferStepItem(number: String, title: String, description: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Surface(
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(22.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = number,
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(text = title, fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = description,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun ReferralEarningsSummaryCard(
    totalFriends: Int,
    paidMembers: Int,
    totalEarned: Double,
    currentBalance: Double,
    pricingConfig: AppPricingConfig,
    onNavigateToWallet: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "📊 আপনার রেফারেল পারফরম্যান্স",
                fontWeight = FontWeight.Bold,
                fontSize = 14.5.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                MiniStatCard(
                    modifier = Modifier.weight(1f),
                    label = "আমন্ত্রিত বন্ধু",
                    value = "$totalFriends জন",
                    color = Color(0xFF3B82F6)
                )
                MiniStatCard(
                    modifier = Modifier.weight(1f),
                    label = "পেইড মেম্বার",
                    value = "$paidMembers জন",
                    color = Color(0xFF10B981)
                )
                MiniStatCard(
                    modifier = Modifier.weight(1f),
                    label = "মোট আয়",
                    value = "৳${"%.0f".format(totalEarned)}",
                    color = Color(0xFFF59E0B)
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "বর্তমান ওয়ালেট ব্যালেন্স:",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "৳ ${"%.0f".format(currentBalance)}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF047857)
                    )
                }

                Button(
                    onClick = onNavigateToWallet,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF047857)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Icon(imageVector = Icons.Default.AccountBalanceWallet, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = "ওয়ালেট ও ক্যাশআউট", fontWeight = FontWeight.Bold, fontSize = 12.5.sp)
                }
            }
        }
    }
}

@Composable
private fun MiniStatCard(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    color: Color
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        color = color.copy(alpha = 0.12f),
        border = BorderStroke(1.dp, color.copy(alpha = 0.3f))
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = value, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = color)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = label, fontSize = 10.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
private fun ReferredFriendItemCard(user: ReferredUserItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    shape = CircleShape,
                    color = if (user.isPaid) Color(0xFF10B981).copy(alpha = 0.2f) else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f),
                    modifier = Modifier.size(36.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = if (user.isPaid) Icons.Default.CheckCircle else Icons.Default.Person,
                            contentDescription = null,
                            tint = if (user.isPaid) Color(0xFF10B981) else MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = user.name.ifBlank { user.email.takeWhile { it != '@' } },
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.5.sp
                    )
                    Text(
                        text = user.email,
                        fontSize = 11.5.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Surface(
                color = if (user.isPaid) Color(0xFF10B981).copy(alpha = 0.15f) else Color(0xFFF59E0B).copy(alpha = 0.15f),
                shape = RoundedCornerShape(6.dp)
            ) {
                Text(
                    text = if (user.isPaid) "পেইড মেম্বার" else "ফ্রি ট্রায়াল",
                    color = if (user.isPaid) Color(0xFF047857) else Color(0xFFB45309),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
}

private fun createShareMessage(referralCode: String, pricingConfig: AppPricingConfig): String {
    return """
        📚 বাংলা অডিওবুক লাইব্রেরি ও স্পোকেন ল্যাঙ্গুয়েজ লার্নিং অ্যাপে যুক্ত হও!
        জনপ্রিয় সব বইয়ের চমৎকার বাংলা অডিওবুক, ফুল টেক্সট এবং স্পোকেন কোর্স শেখার সেরা প্ল্যাটফর্ম।

        রেজিস্টার করার সময় আমার রেফার কোড ব্যবহার করো:
        👉 $referralCode

        বন্ধু যেকোনো কোর্স নিলে তুমি পাবে বিশেষ ছাড় এবং বোনাস!
        অ্যাপটি ডাউনলোড করে এখনই শুরু করো:
        https://play.google.com/store/apps/details?id=com.gigabyte.bookstore
    """.trimIndent()
}

private fun shareReferralIntent(context: Context, referralCode: String, pricingConfig: AppPricingConfig) {
    val shareText = createShareMessage(referralCode, pricingConfig)
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, shareText)
    }
    context.startActivity(Intent.createChooser(intent, "রেফার কোড শেয়ার করুন"))
}
