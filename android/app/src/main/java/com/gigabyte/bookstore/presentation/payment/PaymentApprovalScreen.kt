package com.gigabyte.bookstore.presentation.payment

import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.models.PaymentRequest
import com.gigabyte.bookstore.data.repository.UserRepository
import kotlinx.coroutines.launch

enum class PaymentFilter(val label: String) {
    ALL("সব (All)"),
    PENDING("অপেক্ষমাণ (Pending)"),
    APPROVED("অনুমোদিত (Approved)"),
    REJECTED("বাতিল (Rejected)")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentApprovalScreen(
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val app = context.applicationContext as BanglaAudiobookApp
    val userRepository = remember { UserRepository(context.applicationContext as Application, app.appPreferences) }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    var requests by remember { mutableStateOf<List<PaymentRequest>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isProcessingAction by remember { mutableStateOf(false) }

    var selectedFilter by remember { mutableStateOf(PaymentFilter.PENDING) }
    var searchQuery by remember { mutableStateOf("") }

    // Dialog states
    var requestToApprove by remember { mutableStateOf<PaymentRequest?>(null) }
    var requestToReject by remember { mutableStateOf<PaymentRequest?>(null) }
    var rejectionReasonInput by remember { mutableStateOf("") }

    fun loadRequests() {
        scope.launch {
            isLoading = true
            errorMessage = null
            val result = userRepository.getAllPaymentRequests()
            result.onSuccess { list ->
                requests = list
                isLoading = false
            }.onFailure { ex ->
                errorMessage = ex.localizedMessage ?: "অনুরোধ লোড করতে ব্যর্থ হয়েছে"
                isLoading = false
            }
        }
    }

    LaunchedEffect(Unit) {
        loadRequests()
    }

    // Filtered requests
    val filteredRequests = remember(requests, selectedFilter, searchQuery) {
        requests.filter { req ->
            val matchesFilter = when (selectedFilter) {
                PaymentFilter.ALL -> true
                PaymentFilter.PENDING -> req.status.equals("pending", ignoreCase = true)
                PaymentFilter.APPROVED -> req.status.equals("approved", ignoreCase = true)
                PaymentFilter.REJECTED -> req.status.equals("rejected", ignoreCase = true)
            }
            val matchesSearch = if (searchQuery.isBlank()) {
                true
            } else {
                req.email.contains(searchQuery.trim(), ignoreCase = true) ||
                        req.transactionId.contains(searchQuery.trim(), ignoreCase = true) ||
                        req.method.contains(searchQuery.trim(), ignoreCase = true)
            }
            matchesFilter && matchesSearch
        }
    }

    // Statistics
    val pendingCount = remember(requests) { requests.count { it.status.equals("pending", ignoreCase = true) } }
    val approvedCount = remember(requests) { requests.count { it.status.equals("approved", ignoreCase = true) } }
    val totalApprovedAmount = remember(requests) {
        requests.filter { it.status.equals("approved", ignoreCase = true) }.sumOf { it.amount }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "পেমেন্ট অনুমোদন",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 19.sp
                            )
                        )
                        Text(
                            text = "Payment Request Management",
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "ফিরে যান"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { loadRequests() },
                        enabled = !isLoading && !isProcessingAction
                    ) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "রিফ্রেশ করুন"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // 1. KPI Summary Cards
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                KpiCard(
                    title = "অপেক্ষমাণ (Pending)",
                    value = "$pendingCount টি",
                    color = Color(0xFFF59E0B),
                    icon = Icons.Default.HourglassEmpty
                )
                KpiCard(
                    title = "অনুমোদিত (Approved)",
                    value = "$approvedCount টি",
                    color = Color(0xFF10B981),
                    icon = Icons.Default.CheckCircle
                )
                KpiCard(
                    title = "মোট সংগৃহীত (Revenue)",
                    value = "৳ ${"%.2f".format(totalApprovedAmount)}",
                    color = MaterialTheme.colorScheme.primary,
                    icon = Icons.Default.AccountBalanceWallet
                )
            }

            // 2. Search Box
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                placeholder = { Text("ইমেইল বা ট্রানজেকশন আইডি দিয়ে খুঁজুন...", fontSize = 13.sp) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "মুছুন",
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                },
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )

            // 3. Filter Chips
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                PaymentFilter.values().forEach { filter ->
                    val isSelected = selectedFilter == filter
                    FilterChip(
                        selected = isSelected,
                        onClick = { selectedFilter = filter },
                        label = {
                            val badgeCount = when (filter) {
                                PaymentFilter.ALL -> requests.size
                                PaymentFilter.PENDING -> pendingCount
                                PaymentFilter.APPROVED -> approvedCount
                                PaymentFilter.REJECTED -> requests.count { it.status.equals("rejected", ignoreCase = true) }
                            }
                            Text("${filter.label} ($badgeCount)", fontSize = 12.sp)
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(top = 4.dp),
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
            )

            // 4. Content Area
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                if (isLoading) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator(modifier = Modifier.size(36.dp))
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "অনুরোধ তালিকা লোড হচ্ছে...",
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                } else if (errorMessage != null) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.ErrorOutline,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.error,
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = errorMessage ?: "",
                            color = MaterialTheme.colorScheme.error,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(onClick = { loadRequests() }) {
                            Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("পুনরায় চেষ্টা করুন")
                        }
                    }
                } else if (filteredRequests.isEmpty()) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Inbox,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                            modifier = Modifier.size(56.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "কোন পেমেন্ট অনুরোধ পাওয়া যায়নি",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "অন্য ফিল্টার নির্বাচন করুন বা ট্রানজেকশন অনুসন্ধান করুন",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                        )
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(filteredRequests, key = { it.id }) { req ->
                            PaymentRequestCard(
                                request = req,
                                isProcessing = isProcessingAction,
                                onCopyTrx = { trx ->
                                    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                    clipboard.setPrimaryClip(ClipData.newPlainText("Transaction ID", trx))
                                    scope.launch {
                                        snackbarHostState.showSnackbar("ট্রানজেকশন আইডি কপি করা হয়েছে: $trx")
                                    }
                                },
                                onApproveClick = {
                                    requestToApprove = req
                                },
                                onRejectClick = {
                                    rejectionReasonInput = ""
                                    requestToReject = req
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    // Approve Confirmation Dialog
    if (requestToApprove != null) {
        val req = requestToApprove!!
        AlertDialog(
            onDismissRequest = { if (!isProcessingAction) requestToApprove = null },
            icon = {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null,
                    tint = Color(0xFF10B981),
                    modifier = Modifier.size(36.dp)
                )
            },
            title = {
                Text(text = "পেমেন্ট অনুমোদন নিশ্চিতকরণ", fontWeight = FontWeight.Bold, fontSize = 17.sp)
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(
                        text = "আপনি কি এই পেমেন্ট অনুরোধটি অনুমোদন করতে চান?",
                        fontSize = 13.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Surface(
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text("ব্যবহারকারী: ${req.email}", fontSize = 12.sp, fontWeight = FontWeight.Medium)
                            Text("মাধ্যম: ${req.method}", fontSize = 12.sp)
                            Text("ট্রানজেকশন আইডি: ${req.transactionId}", fontSize = 12.sp)
                            Text("টাকার পরিমাণ: ৳ ${"%.2f".format(req.amount)}", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF10B981))
                        }
                    }
                    Text(
                        text = "অনুমোদনের পর ব্যবহারকারী 'PAID' স্ট্যাটাস পাবেন এবং ব্যালেন্সে ৳ ${"%.2f".format(req.amount)} যোগ হবে।",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val currentReq = req
                        requestToApprove = null
                        isProcessingAction = true
                        scope.launch {
                            val res = userRepository.approvePaymentRequest(
                                requestId = currentReq.id,
                                userEmail = currentReq.email,
                                amount = currentReq.amount
                            )
                            isProcessingAction = false
                            res.onSuccess {
                                snackbarHostState.showSnackbar("পেমেন্ট সফলভাবে অনুমোদন করা হয়েছে (${currentReq.email})")
                                loadRequests()
                            }.onFailure { ex ->
                                snackbarHostState.showSnackbar("অনুমোদনে ত্রুটি: ${ex.localizedMessage}")
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                    enabled = !isProcessingAction
                ) {
                    Text("হ্যাঁ, অনুমোদন করুন")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { requestToApprove = null },
                    enabled = !isProcessingAction
                ) {
                    Text("বাতিল")
                }
            }
        )
    }

    // Reject Confirmation Dialog
    if (requestToReject != null) {
        val req = requestToReject!!
        AlertDialog(
            onDismissRequest = { if (!isProcessingAction) requestToReject = null },
            icon = {
                Icon(
                    imageVector = Icons.Default.Cancel,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error,
                    modifier = Modifier.size(36.dp)
                )
            },
            title = {
                Text(text = "অনুরোধ প্রত্যাখ্যান করুন", fontWeight = FontWeight.Bold, fontSize = 17.sp)
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "আপনি কি নিশ্চিত যে আপনি এই অনুরোধটি প্রত্যাখ্যান করতে চান?",
                        fontSize = 13.sp
                    )
                    OutlinedTextField(
                        value = rejectionReasonInput,
                        onValueChange = { rejectionReasonInput = it },
                        label = { Text("প্রত্যাখ্যানের কারণ (ঐচ্ছিক)") },
                        placeholder = { Text("যেমন: অবৈধ ট্রানজেকশন আইডি") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        singleLine = false,
                        maxLines = 3
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val currentReq = req
                        val reason = rejectionReasonInput
                        requestToReject = null
                        isProcessingAction = true
                        scope.launch {
                            val res = userRepository.rejectPaymentRequest(
                                requestId = currentReq.id,
                                reason = reason
                            )
                            isProcessingAction = false
                            res.onSuccess {
                                snackbarHostState.showSnackbar("অনুরোধ প্রত্যাখ্যান করা হয়েছে (${currentReq.email})")
                                loadRequests()
                            }.onFailure { ex ->
                                snackbarHostState.showSnackbar("ত্রুটি: ${ex.localizedMessage}")
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                    enabled = !isProcessingAction
                ) {
                    Text("প্রত্যাখ্যান করুন")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { requestToReject = null },
                    enabled = !isProcessingAction
                ) {
                    Text("ফিরে যান")
                }
            }
        )
    }
}

@Composable
private fun KpiCard(
    title: String,
    value: String,
    color: Color,
    icon: androidx.compose.ui.graphics.vector.ImageVector
) {
    Surface(
        color = color.copy(alpha = 0.12f),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.width(150.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .clip(CircleShape)
                    .background(color.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = color,
                    modifier = Modifier.size(18.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = value,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = color,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = title,
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun PaymentRequestCard(
    request: PaymentRequest,
    isProcessing: Boolean,
    onCopyTrx: (String) -> Unit,
    onApproveClick: () -> Unit,
    onRejectClick: () -> Unit
) {
    val methodColor = when (request.method.lowercase()) {
        "bkash" -> Color(0xFFE2136E)
        "nagad" -> Color(0xFFFA6400)
        "rocket" -> Color(0xFF8C3494)
        else -> MaterialTheme.colorScheme.primary
    }

    val isPending = request.status.equals("pending", ignoreCase = true)
    val isApproved = request.status.equals("approved", ignoreCase = true)
    val isRejected = request.status.equals("rejected", ignoreCase = true)

    val statusColor = when {
        isApproved -> Color(0xFF10B981)
        isRejected -> MaterialTheme.colorScheme.error
        else -> Color(0xFFF59E0B)
    }

    val statusText = when {
        isApproved -> "অনুমোদিত"
        isRejected -> "বাতিল"
        else -> "অপেক্ষমাণ"
    }

    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // Header Row: Method + Amount + Status
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Method Badge
                Surface(
                    color = methodColor.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(methodColor)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = request.method.ifBlank { "Manual" },
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = methodColor
                        )
                    }
                }

                // Amount
                Text(
                    text = "৳ ${"%.2f".format(request.amount)}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )

                // Status Badge
                Surface(
                    color = statusColor.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = when {
                                isApproved -> Icons.Default.CheckCircle
                                isRejected -> Icons.Default.Cancel
                                else -> Icons.Default.HourglassEmpty
                            },
                            contentDescription = null,
                            tint = statusColor,
                            modifier = Modifier.size(12.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = statusText,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = statusColor
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // User Email
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = request.email.ifBlank { "অজ্ঞাত ব্যবহারকারী" },
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Transaction ID with Copy Button
            Surface(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "ট্রানজেকশন আইডি (TrxID)",
                            fontSize = 10.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = request.transactionId.ifBlank { "N/A" },
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    IconButton(
                        onClick = { onCopyTrx(request.transactionId) },
                        modifier = Modifier.size(30.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ContentCopy,
                            contentDescription = "কপি করুন",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Timestamps and Device ID
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.AccessTime,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                        modifier = Modifier.size(12.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = request.submittedAt.ifBlank { "তারিখ নেই" },
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                if (request.deviceId.isNotBlank()) {
                    Text(
                        text = "ডিভাইস: ${request.deviceId.take(8)}...",
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                    )
                }
            }

            // Reviewed details if available
            if (request.reviewedAt.isNotBlank()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "যাচাই করা হয়েছে: ${request.reviewedAt}" + if (request.rejectionReason.isNotBlank()) " (${request.rejectionReason})" else "",
                    fontSize = 11.sp,
                    color = statusColor.copy(alpha = 0.85f)
                )
            }

            // Action Buttons (for pending status)
            if (isPending) {
                Spacer(modifier = Modifier.height(10.dp))
                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Approve Button
                    Button(
                        onClick = onApproveClick,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                        shape = RoundedCornerShape(10.dp),
                        enabled = !isProcessing,
                        contentPadding = PaddingValues(vertical = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("অনুমোদন", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    }

                    // Reject Button
                    OutlinedButton(
                        onClick = onRejectClick,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.error),
                        shape = RoundedCornerShape(10.dp),
                        enabled = !isProcessing,
                        contentPadding = PaddingValues(vertical = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("বাতিল", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
