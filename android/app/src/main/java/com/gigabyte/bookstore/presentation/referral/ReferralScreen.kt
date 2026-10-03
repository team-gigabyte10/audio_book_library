package com.gigabyte.bookstore.presentation.referral

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gigabyte.bookstore.data.models.ReferralReward
import com.gigabyte.bookstore.data.models.WithdrawalRequest
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReferralScreen(
    onNavigateBack: () -> Unit,
    viewModel: ReferralViewModel = viewModel()
) {
    val context = LocalContext.current
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
                title = { Text("রেফার ও আয় (Learn & Earn)") },
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
                        // 1. Referral Code Hero Card
                        item {
                            ReferralCodeCard(
                                referralCode = stats.referralCode,
                                onCopy = {
                                    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                    val clip = ClipData.newPlainText("Referral Code", stats.referralCode)
                                    clipboard.setPrimaryClip(clip)
                                    Toast.makeText(context, "রেফার কোড কপি করা হয়েছে!", Toast.LENGTH_SHORT).show()
                                },
                                onShare = {
                                    val shareText = """
                                        📚 বাংলা অডিওবুক লাইব্রেরিতে যুক্ত হও!
                                        জনপ্রিয় সব বইয়ের চমৎকার বাংলা অডিওবুক ও সামারি শুনো খুব সহজে।
                                        
                                        রেজিস্টার করার সময় আমার রেফার কোড ব্যবহার করো:
                                        👉 ${stats.referralCode}
                                        
                                        অ্যাপটি ডাউনলোড করে এখনই শুরু করো!
                                    """.trimIndent()
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
                                onWithdrawClick = { showWithdrawDialog = true }
                            )
                        }

                        // 3. How It Works (Learn & Earn Model)
                        item {
                            HowItWorksCard()
                        }

                        // 4. Rewards History
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

                        // 5. Withdrawal History
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
    onCopy: () -> Unit,
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
                    text = "বন্ধু পেইড সাবস্ক্রিপশনে আপগ্রেড করলে আপনি পাবেন নগদ ২০ টাকা!",
                    fontSize = 12.5.sp,
                    color = Color.White.copy(alpha = 0.9f),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = onCopy,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.2f)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(imageVector = Icons.Default.ContentCopy, contentDescription = null, tint = Color.White)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(text = "কপি করুন", color = Color.White, fontWeight = FontWeight.Bold)
                    }

                    Button(
                        onClick = onShare,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(imageVector = Icons.Default.Share, contentDescription = null, tint = Color.White)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(text = "শেয়ার করুন", color = Color.White, fontWeight = FontWeight.Bold)
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
                title = "মোট আয় (@২০৳)",
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
            enabled = currentBalance >= 100.0,
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
                text = if (currentBalance >= 100.0) "টাকা উত্তোলন করুন (উইথড্র)" else "উইথড্র করতে সর্বনিম্ন ১০০ টাকা ব্যালেন্স প্রয়োজন",
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
fun HowItWorksCard() {
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
                    text = "কীভাবে আয় করবেন? (Learn & Earn Rules)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }

            StepItem(number = "১", text = "আপনার রেফার কোড বন্ধুদের কাছে শেয়ার করুন।")
            StepItem(number = "২", text = "বন্ধু অ্যাপ ইনস্টল করে আপনার কোড দিয়ে ট্রায়াল মোডে সারসংক্ষেপ শুনবে।")
            StepItem(number = "৩", text = "বন্ধু যখন সম্পূর্ণ বই ও পিডিএফ পড়ার জন্য পেইড মেম্বার হবে, আপনি পেয়ে যাবেন ২০ টাকা বোনাস!")
            StepItem(number = "৪", text = "ব্যালেন্স ১০০ টাকা হলেই বিকাশ, নগদ বা রকেটে সরাসরি ক্যাশ-আউট করুন।")
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
    isSubmitting: Boolean,
    onDismiss: () -> Unit,
    onSubmit: (method: String, account: String, type: String, amount: Double) -> Unit
) {
    var selectedMethod by remember { mutableStateOf("bKash") }
    var accountNumber by remember { mutableStateOf("") }
    var accountType by remember { mutableStateOf("personal") }
    var amountText by remember { mutableStateOf(currentBalance.toInt().toString()) }

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
                    label = { Text("উত্তোলনের পরিমাণ (৳)") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val amount = amountText.toDoubleOrNull() ?: 0.0
                    onSubmit(selectedMethod, accountNumber, accountType, amount)
                },
                enabled = !isSubmitting && accountNumber.length >= 11 && (amountText.toDoubleOrNull() ?: 0.0) >= 100.0
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
