package com.gigabyte.bookstore.presentation.referral

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.models.ReferredUserItem
import com.gigabyte.bookstore.data.models.ReferralReward
import com.gigabyte.bookstore.data.models.WithdrawalRequest
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReferralScreen(
    onNavigateBack: () -> Unit,
    onNavigateToPayment: (() -> Unit)? = null,
    viewModel: ReferralViewModel = viewModel()
) {
    val context = LocalContext.current
    val app = context.applicationContext as BanglaAudiobookApp
    val userStatus by app.appPreferences.userStatus.collectAsStateWithLifecycle()
    val isPaidUser = userStatus.equals("paid", ignoreCase = true) || userStatus.equals("active", ignoreCase = true)
    val pricingConfig by app.appPreferences.pricingConfig.collectAsStateWithLifecycle()

    val uiState by viewModel.uiState.collectAsState()
    val isWithdrawing by viewModel.isWithdrawing.collectAsState()
    val actionMessage by viewModel.actionMessage.collectAsState()

    var showWithdrawDialog by remember { mutableStateOf(false) }

    LaunchedEffect(actionMessage) {
        actionMessage?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            viewModel.clearActionMessage()
        }
    }

    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = { Text("রেফার ও আয় (Reffer and Earn)") },
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
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(top = 16.dp, bottom = 32.dp)
                    ) {
                        // 0. Affiliate Partner Eligibility Banner
                        item {
                            AffiliatePartnerBanner(
                                isPaidUser = isPaidUser,
                                onNavigateToPayment = onNavigateToPayment
                            )
                        }

                        // 1. Referral Code Hero Card
                        item {
                            ReferralCodeCard(
                                referralCode = stats.referralCode,
                                bundleBonus = pricingConfig.bundleReferralBonus,
                                singleBonus = pricingConfig.singleReferralBonus,
                                onCopy = {
                                    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                    val clip = ClipData.newPlainText("Referral Code", stats.referralCode)
                                    clipboard.setPrimaryClip(clip)
                                    Toast.makeText(context, "রেফার কোড কপি করা হয়েছে!", Toast.LENGTH_SHORT).show()
                                },
                                onCopyLink = {
                                    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                    val clip = ClipData.newPlainText("Play Store App Link", pricingConfig.playStoreAppUrl)
                                    clipboard.setPrimaryClip(clip)
                                    Toast.makeText(context, "অ্যাপের প্লে স্টোর লিঙ্ক কপি করা হয়েছে!", Toast.LENGTH_SHORT).show()
                                },
                                onShare = {
                                    val shareText = createShareMessage(stats.referralCode, pricingConfig)
                                    val intent = Intent(Intent.ACTION_SEND).apply {
                                        type = "text/plain"
                                        putExtra(Intent.EXTRA_TEXT, shareText)
                                    }
                                    context.startActivity(Intent.createChooser(intent, "রেফার কোড শেয়ার করুন"))
                                }
                            )
                        }

                        // 2. Stats Grid
                        item {
                            StatsGrid(
                                totalFriends = stats.totalFriendsJoined,
                                paidMembers = stats.paidMembersCount,
                                totalEarned = stats.totalEarned,
                                currentBalance = stats.currentBalance,
                                minWithdrawal = pricingConfig.minWithdrawalAmount,
                                onWithdrawClick = { showWithdrawDialog = true }
                            )
                        }

                        // 3. Purchase Courses with Wallet Balance Card
                        item {
                            WalletCoursePurchaseCard(
                                currentBalance = stats.currentBalance,
                                onNavigateToPayment = onNavigateToPayment
                            )
                        }

                        // 4. Referred Users List with Bought/Trial Status
                        item {
                            ReferredUsersSection(users = stats.referredUsers)
                        }

                        // 5. How It Works (Learn & Earn Model)
                        item {
                            HowItWorksCard(
                                megaBundlePrice = pricingConfig.megaBundlePrice,
                                singleCoursePrice = pricingConfig.singleCoursePrice,
                                bundleBonus = pricingConfig.bundleReferralBonus,
                                singleBonus = pricingConfig.singleReferralBonus,
                                minWithdrawal = pricingConfig.minWithdrawalAmount
                            )
                        }

                        // 6. Rewards History
                        if (stats.rewards.isNotEmpty()) {
                            item {
                                Text(
                                    text = "সফল রেফারাল হিস্ট্রি (${stats.rewards.size})",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(top = 8.dp)
                                )
                            }
                            items(stats.rewards) { reward ->
                                RewardItemCard(reward = reward)
                            }
                        }

                        // 7. Withdrawal History
                        if (state.withdrawals.isNotEmpty()) {
                            item {
                                Text(
                                    text = "টাকা উত্তোলন হিস্ট্রি (${state.withdrawals.size})",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(top = 12.dp)
                                )
                            }
                            items(state.withdrawals) { withdrawal ->
                                WithdrawalItemCard(withdrawal = withdrawal)
                            }
                        }
                    }

                    // Withdraw Dialog
                    if (showWithdrawDialog) {
                        WithdrawDialog(
                            currentBalance = stats.currentBalance,
                            minWithdrawal = pricingConfig.minWithdrawalAmount,
                            isSubmitting = isWithdrawing,
                            onDismiss = { showWithdrawDialog = false },
                            onSubmit = { method, account, type, amount ->
                                viewModel.requestWithdrawal(method, account, type, amount)
                                showWithdrawDialog = false
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ReferralCodeCard(
    referralCode: String,
    bundleBonus: Double = 40.0,
    singleBonus: Double = 20.0,
    onCopy: () -> Unit,
    onCopyLink: (() -> Unit)? = null,
    onShare: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "🎁 আপনার রেফারেল কোড",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFA7F3D0)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Surface(
                    color = Color.Black.copy(alpha = 0.35f),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.border(1.dp, Color(0xFF34D399).copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                ) {
                    Text(
                        text = referralCode.ifBlank { "..." },
                        fontSize = 26.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = 3.sp,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "বন্ধু পেইড সাবস্ক্রিপশনে বান্ডেল নিলে নগদ ৳${bundleBonus.toInt()} ও কোর্স নিলে ৳${singleBonus.toInt()} বোনাস!",
                    fontSize = 12.5.sp,
                    color = Color.White.copy(alpha = 0.9f),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = onCopy,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.2f)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.weight(1f),
                        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 4.dp)
                    ) {
                        Icon(imageVector = Icons.Default.ContentCopy, contentDescription = null, tint = Color.White, modifier = Modifier.size(15.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "কোড কপি", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    }

                    if (onCopyLink != null) {
                        Button(
                            onClick = onCopyLink,
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.25f)),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.weight(1f),
                            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 4.dp)
                        ) {
                            Icon(imageVector = Icons.Default.Link, contentDescription = null, tint = Color.White, modifier = Modifier.size(15.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = "লিঙ্ক কপি", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        }
                    }

                    Button(
                        onClick = onShare,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.weight(1f),
                        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 4.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Share, contentDescription = null, tint = Color.White, modifier = Modifier.size(15.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "শেয়ার", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun StatsGrid(
    totalFriends: Int,
    paidMembers: Int,
    totalEarned: Double,
    currentBalance: Double,
    minWithdrawal: Double = 100.0,
    onWithdrawClick: () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            StatCard(
                modifier = Modifier.weight(1f),
                title = "মোট আমন্ত্রিত",
                value = "$totalFriends জন",
                icon = Icons.Default.People,
                color = Color(0xFF3B82F6)
            )

            StatCard(
                modifier = Modifier.weight(1f),
                title = "পেইড মেম্বার",
                value = "$paidMembers জন",
                icon = Icons.Default.Verified,
                color = Color(0xFF10B981)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            StatCard(
                modifier = Modifier.weight(1f),
                title = "মোট আয় (Reffer and Earn)",
                value = "৳ ${"%.0f".format(totalEarned)}",
                icon = Icons.Default.MonetizationOn,
                color = Color(0xFFF59E0B)
            )

            StatCard(
                modifier = Modifier.weight(1f),
                title = "বর্তমান ব্যালেন্স",
                value = "৳ ${"%.0f".format(currentBalance)}",
                icon = Icons.Default.AccountBalanceWallet,
                color = Color(0xFF8B5CF6)
            )
        }

        // Withdraw Action Button
        Button(
            onClick = onWithdrawClick,
            enabled = currentBalance >= minWithdrawal,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF10B981),
                disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Icon(imageVector = Icons.Default.Payments, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = if (currentBalance >= minWithdrawal) "টাকা উত্তোলন করুন (উইথড্র)" else "উইথড্র করতে সর্বনিম্ন ${minWithdrawal.toInt()} টাকা ব্যালেন্স প্রয়োজন",
                fontWeight = FontWeight.Bold,
                fontSize = 13.5.sp
            )
        }
    }
}

@Composable
fun StatCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    color: Color
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f))
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(color.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = color,
                    modifier = Modifier.size(18.dp)
                )
            }
            Text(
                text = title,
                fontSize = 11.5.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = value,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun HowItWorksCard(
    megaBundlePrice: Double = 300.0,
    singleCoursePrice: Double = 100.0,
    bundleBonus: Double = 40.0,
    singleBonus: Double = 20.0,
    minWithdrawal: Double = 100.0
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f))
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
                    text = "কীভাবে আয় করবেন? (Reffer and Earn Rules)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }

            StepItem(number = "১", text = "আপনার রেফার কোড বন্ধুদের কাছে শেয়ার করুন।")
            StepItem(number = "২", text = "বন্ধু অ্যাপ ইনস্টল করে আপনার কোড দিয়ে ট্রায়াল মোডে সারসংক্ষেপ শুনবে।")
            StepItem(number = "৩", text = "বন্ধু যখন মেগা বান্ডেল (৳${megaBundlePrice.toInt()}) নেবে আপনি পাবেন নগদ ৳${bundleBonus.toInt()} এবং সাধারণ কোর্স (৳${singleCoursePrice.toInt()}) নিলে পাবেন ৳${singleBonus.toInt()} বোনাস!")
            StepItem(number = "৪", text = "ব্যালেন্স ${minWithdrawal.toInt()} টাকা হলেই বিকাশ, নগদ বা রকেটে উইথড্র করুন অথবা বিনামূল্যে যেকোনো কোর্স ক্রয় করুন।")
        }
    }
}

@Composable
fun StepItem(number: String, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Surface(
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(20.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = number,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = text,
            fontSize = 12.5.sp,
            color = MaterialTheme.colorScheme.onSurface,
            lineHeight = 18.sp
        )
    }
}

@Composable
fun RewardItemCard(reward: ReferralReward) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF10B981).copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = Color(0xFF10B981),
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = reward.refereeName.ifBlank { reward.refereeEmail },
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.5.sp
                    )
                    Text(
                        text = "পেইড মেম্বারশিপ আপগ্রেড • ${reward.paidAt.take(10)}",
                        fontSize = 11.5.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Surface(
                color = Color(0xFFECFDF5),
                shape = RoundedCornerShape(8.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.4f))
            ) {
                Text(
                    text = "+৳${"%.0f".format(reward.amount)}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Color(0xFF047857),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
}

@Composable
fun WithdrawalItemCard(withdrawal: WithdrawalRequest) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "${withdrawal.method} (${withdrawal.accountNumber})",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.5.sp
                )
                Text(
                    text = "${withdrawal.submittedAt.take(16)}",
                    fontSize = 11.5.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "-৳${"%.0f".format(withdrawal.amount)}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                val (statusText, statusColor) = when (withdrawal.status.lowercase()) {
                    "approved" -> "সম্পন্ন" to Color(0xFF10B981)
                    "rejected" -> "বাতিল" to Color(0xFFEF4444)
                    else -> "পেন্ডিং" to Color(0xFFF59E0B)
                }
                Text(
                    text = statusText,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = statusColor
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WithdrawDialog(
    currentBalance: Double,
    minWithdrawal: Double = 100.0,
    isSubmitting: Boolean,
    onDismiss: () -> Unit,
    onSubmit: (method: String, account: String, type: String, amount: Double) -> Unit
) {
    var selectedMethod by remember { mutableStateOf("bKash") }
    var accountNumber by remember { mutableStateOf("") }
    var accountType by remember { mutableStateOf("personal") }
    var amountText by remember { mutableStateOf(if (currentBalance >= minWithdrawal) currentBalance.toInt().toString() else minWithdrawal.toInt().toString()) }

    val amount = amountText.toDoubleOrNull() ?: 0.0
    val isAmountValid = amount >= minWithdrawal && amount <= currentBalance

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = "টাকা উত্তোলন করুন", fontWeight = FontWeight.Bold)
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    text = "বর্তমান ব্যালেন্স: ৳${"%.0f".format(currentBalance)}",
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )

                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "⚠️ সর্বনিম্ন উত্তোলনের পরিমাণ ৳ ${minWithdrawal.toInt()}.০০। অনুরোধ অনুমোদনের পর ২৪ ঘণ্টার মধ্যে মোবাইল ব্যাংকিং নম্বরে টাকা পাঠানো হবে।",
                        fontSize = 11.5.sp,
                        lineHeight = 16.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(10.dp)
                    )
                }

                // Method selection chips
                Text(text = "পেমেন্ট মেথড:", fontSize = 12.sp, fontWeight = FontWeight.Medium)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf("bKash", "Nagad", "Rocket").forEach { method ->
                        FilterChip(
                            selected = selectedMethod == method,
                            onClick = { selectedMethod = method },
                            label = { Text(method) }
                        )
                    }
                }

                OutlinedTextField(
                    value = accountNumber,
                    onValueChange = { accountNumber = it },
                    label = { Text("মোবাইল ব্যাংকিং নম্বর") },
                    placeholder = { Text("01XXXXXXXXX") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = amountText,
                    onValueChange = { amountText = it },
                    label = { Text("উত্তোলনের পরিমাণ (সর্বনিম্ন ৳ ১০০)") },
                    singleLine = true,
                    isError = amountText.isNotBlank() && (!isAmountValid),
                    supportingText = {
                        if (amountText.isNotBlank()) {
                            if (amount < 100.0) {
                                Text("সর্বনিম্ন ১০০ টাকা লিখতে হবে", color = MaterialTheme.colorScheme.error)
                            } else if (amount > currentBalance) {
                                Text("ব্যালেন্সের চেয়ে বেশি তোলা যাবে না", color = MaterialTheme.colorScheme.error)
                            }
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onSubmit(selectedMethod, accountNumber, accountType, amount)
                },
                enabled = !isSubmitting && accountNumber.length >= 11 && isAmountValid
            ) {
                if (isSubmitting) {
                    CircularProgressIndicator(modifier = Modifier.size(16.dp), color = MaterialTheme.colorScheme.onPrimary)
                } else {
                    Text("অনুরোধ পাঠান")
                }
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("বাতিল")
            }
        }
    )
}

/**
 * Banner showing whether the current user is a verified Paid Affiliate Partner
 * or a Trial user who needs to buy a course to participate.
 */
@Composable
fun AffiliatePartnerBanner(
    isPaidUser: Boolean,
    onNavigateToPayment: (() -> Unit)?
) {
    if (isPaidUser) {
        Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF10B981).copy(alpha = 0.12f)),
            border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.4f)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = CircleShape,
                    color = Color(0xFF10B981),
                    modifier = Modifier.size(38.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Verified,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "👑 ভেরিফাইড অ্যাফিলিয়েট পার্টনার",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.5.sp,
                        color = Color(0xFF065F46)
                    )
                    Text(
                        text = "আপনি একজন পেইড মেম্বার। আপনার রেফার করা বন্ধুরা কোর্স কিনলে প্রতিটিতে ৳২০ সরাসরি ওয়ালেটে জমা হবে।",
                        fontSize = 11.5.sp,
                        lineHeight = 16.sp,
                        color = Color(0xFF047857)
                    )
                }
            }
        }
    } else {
        Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
            ),
            border = BorderStroke(1.2.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(36.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.WorkspacePremium,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = "অ্যাফিলিয়েট পার্টনার প্রোগ্রাম",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "রেফারেল কমিশন শুধুমাত্র পেইড মেম্বারদের জন্য",
                            fontSize = 11.5.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "যেকোনো একটি কোর্স কিনে পেইড মেম্বার হয়ে যান এবং বন্ধুদের রেফার করে আনলিমিটেড বোনাস (প্রতিটি কোর্স ক্রয়ে ৳২০) আয় শুরু করুন!",
                    fontSize = 12.sp,
                    lineHeight = 17.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                if (onNavigateToPayment != null) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick = onNavigateToPayment,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.FlashOn, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("💎 যেকোনো কোর্স কিনে পার্টনার হোন", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

/**
 * Card explaining and enabling course purchase using affiliate wallet balance.
 */
@Composable
fun WalletCoursePurchaseCard(
    currentBalance: Double,
    onNavigateToPayment: (() -> Unit)?
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.35f)),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "🎓 ব্যালেন্স দিয়ে কোর্স ক্রয় ও রেফার",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.5.sp
                )
                Text(
                    text = if (currentBalance >= 100.0) {
                        "আপনার অর্জিত ৳${"%.0f".format(currentBalance)} দিয়ে নিজের জন্য অথবা অন্য যেকোনো বন্ধুর ইমেইল দিয়ে তার জন্য সম্পূর্ণ বিনামূল্যে কোর্স আনলক করতে পারবেন। এছাড়া প্রতিটি সফল রেফারে আপনি পাবেন আরও ২০ টাকা বোনাস!"
                    } else {
                        "রেফার করে ৳১০০ আয় করলেই সেই ব্যালেন্স দিয়ে নিজের জন্য বা বন্ধুর জন্য যেকোনো কোর্স বা বান্ডেল সরাসরি রেফার/আনলক করে দিতে পারবেন এবং প্রতিটি সফল রেফারে আপনি পাবেন আরও ২০ টাকা বোনাস!"
                    },
                    fontSize = 11.5.sp,
                    lineHeight = 16.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            if (onNavigateToPayment != null) {
                Spacer(modifier = Modifier.width(10.dp))
                FilledTonalButton(
                    onClick = onNavigateToPayment,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("কোর্সসমূহ", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

/**
 * Section showing the user's referred friends and whether each friend has bought a course or is still in trial.
 */
@Composable
fun ReferredUsersSection(
    users: List<ReferredUserItem>
) {
    var selectedFilter by remember { mutableStateOf("all") }

    val paidCount = remember(users) { users.count { it.isPaid } }
    val trialCount = remember(users) { users.count { !it.isPaid } }

    val filteredList = remember(users, selectedFilter) {
        when (selectedFilter) {
            "paid" -> users.filter { it.isPaid }
            "trial" -> users.filter { !it.isPaid }
            else -> users
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "রেফার করা বন্ধুদের তালিকা (${users.size})",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Filter chips: All, Paid, Trial
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedFilter == "all",
                onClick = { selectedFilter = "all" },
                label = { Text("সকল (${users.size})", fontSize = 12.sp) }
            )
            FilterChip(
                selected = selectedFilter == "paid",
                onClick = { selectedFilter = "paid" },
                label = { Text("🟢 কোর্স কেনা (${paidCount})", fontSize = 12.sp) }
            )
            FilterChip(
                selected = selectedFilter == "trial",
                onClick = { selectedFilter = "trial" },
                label = { Text("⏳ এখনো কেনেনি (${trialCount})", fontSize = 12.sp) }
            )
        }

        if (filteredList.isEmpty()) {
            Card(
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.padding(18.dp), contentAlignment = Alignment.Center) {
                    Text(
                        text = if (users.isEmpty()) {
                            "এখনো কোনো বন্ধু আপনার রেফার কোড দিয়ে যুক্ত হয়নি। উপরে দেওয়া রেফার কোডটি বন্ধুদের সাথে শেয়ার করুন!"
                        } else {
                            "এই ফিল্টারে কোনো বন্ধু পাওয়া যায়নি।"
                        },
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        } else {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                filteredList.forEach { friend ->
                    ReferredUserCard(friend = friend)
                }
            }
        }
    }
}

@Composable
fun ReferredUserCard(friend: ReferredUserItem) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(
            1.dp,
            if (friend.isPaid) Color(0xFF10B981).copy(alpha = 0.35f) else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Surface(
                    shape = CircleShape,
                    color = if (friend.isPaid) Color(0xFF10B981).copy(alpha = 0.15f) else MaterialTheme.colorScheme.surfaceVariant,
                    modifier = Modifier.size(40.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = (friend.name.firstOrNull()?.toString() ?: "U").uppercase(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = if (friend.isPaid) Color(0xFF047857) else MaterialTheme.colorScheme.primary
                        )
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = friend.name.ifBlank { "ব্যবহারকারী" },
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.5.sp
                    )
                    Text(
                        text = friend.email,
                        fontSize = 11.5.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    if (friend.registeredAt.isNotBlank()) {
                        Text(
                            text = "যুক্ত হয়েছেন: ${friend.registeredAt.take(10)}",
                            fontSize = 10.sp,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            if (friend.isPaid) {
                Surface(
                    color = Color(0xFF10B981).copy(alpha = 0.15f),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.4f))
                ) {
                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
                    ) {
                        Text(
                            text = "✓ কোর্স কেনা হয়েছে",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF065F46)
                        )
                        Text(
                            text = "+৳${friend.earnedReward.toInt()} বোনাস প্রাপ্ত",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF047857)
                        )
                    }
                }
            } else {
                Surface(
                    color = Color(0xFFF59E0B).copy(alpha = 0.15f),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color(0xFFF59E0B).copy(alpha = 0.4f))
                ) {
                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
                    ) {
                        Text(
                            text = "⏳ এখনো কেনেনি",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF92400E)
                        )
                        Text(
                            text = "ট্রায়াল মেম্বার",
                            fontSize = 10.sp,
                            color = Color(0xFFB45309)
                        )
                    }
                }
            }
        }
    }
}
