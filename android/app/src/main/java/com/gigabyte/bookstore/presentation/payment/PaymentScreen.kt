package com.gigabyte.bookstore.presentation.payment

import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.repository.UserRepository
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val app = context.applicationContext as BanglaAudiobookApp
    val userRepository = remember { UserRepository(context.applicationContext as Application, app.appPreferences) }
    val scope = rememberCoroutineScope()

    val userName by app.appPreferences.userName.collectAsStateWithLifecycle()
    val userEmail by app.appPreferences.userEmail.collectAsStateWithLifecycle()
    val userStatus by app.appPreferences.userStatus.collectAsStateWithLifecycle()
    val userBalance by app.appPreferences.userBalance.collectAsStateWithLifecycle()

    var selectedMethod by remember { mutableStateOf("bKash") }
    var transactionId by remember { mutableStateOf("") }
    var amountText by remember { mutableStateOf("99") }
    var isSubmitting by remember { mutableStateOf(false) }
    var submitSuccess by remember { mutableStateOf(false) }

    val paymentNumbers = mapOf(
        "bKash" to "01700-000000",
        "Nagad" to "01800-000000",
        "Rocket" to "01900-000000"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "পেমেন্ট ও মেম্বারশিপ",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 19.sp
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "ফিরে যান"
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
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1. Current Account Info Card
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.45f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = userName.ifBlank { "ইউজার" },
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = userEmail.ifBlank { "" },
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        val isPaid = userStatus.equals("paid", ignoreCase = true) || userStatus.equals("active", ignoreCase = true)
                        Surface(
                            color = if (isPaid) Color(0xFF10B981) else Color(0xFFF59E0B),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = if (isPaid) "PAID USER" else "TRIAL USER",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f))
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "ব্যালেন্স:",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = "৳ ${"%.2f".format(userBalance)}",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            // 2. Packages Pricing Card
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "পেইড মেম্বারশিপ প্যাকেজসমূহ",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        PackageOptionCard(
                            title = "১ মাস",
                            price = "৳ ৯৯",
                            selected = amountText == "99",
                            onClick = { amountText = "99" },
                            modifier = Modifier.weight(1f)
                        )
                        PackageOptionCard(
                            title = "৬ মাস",
                            price = "৳ ২৯৯",
                            selected = amountText == "299",
                            onClick = { amountText = "299" },
                            modifier = Modifier.weight(1f)
                        )
                        PackageOptionCard(
                            title = "১ বছর",
                            price = "৳ ৪৯৯",
                            selected = amountText == "499",
                            onClick = { amountText = "499" },
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "✓ সকল বইয়ের সম্পূর্ণ অধ্যায় পাঠ ও অডিওবুক প্লেব্যাক\n✓ মূল হাই-কোয়ালিটি PDF ফাইল অফলাইন ডাউনলোড\n✓ কোনো বিজ্ঞাপন বা বাধা ছাড়াই আনলিমিটেড পাঠ",
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // 3. Payment Method Selection
            Column {
                Text(
                    text = "পেমেন্ট মাধ্যম বেছে নিন (Send Money):",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("bKash", "Nagad", "Rocket").forEach { method ->
                        FilterChip(
                            selected = selectedMethod == method,
                            onClick = { selectedMethod = method },
                            label = { Text(method, fontWeight = FontWeight.Medium) },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            // 4. Number & Copy Box
            val currentNumber = paymentNumbers[selectedMethod] ?: ""
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "$selectedMethod Personal Number:",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = currentNumber,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    FilledTonalButton(
                        onClick = {
                            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            clipboard.setPrimaryClip(ClipData.newPlainText("Payment Number", currentNumber))
                            Toast.makeText(context, "নম্বর কপি করা হয়েছে!", Toast.LENGTH_SHORT).show()
                        },
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ContentCopy,
                            contentDescription = "Copy",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("কপি")
                    }
                }
            }

            // 5. Steps Instructions
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = "কীভাবে পেমেন্ট করবেন?",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "১. আপনার $selectedMethod অ্যাপে প্রবেশ করুন।\n২. 'Send Money' অপশন সিলেক্ট করে উপরের নম্বরে নির্বাচিত প্যাকেজের টাকা পাঠান।\n৩. সফল ট্রানজেকশনের পর SMS বা অ্যাপ স্টেটমেন্ট থেকে Transaction ID (TrxID) কপি করুন।\n৪. নিচের ফর্মে Transaction ID দিয়ে সাবমিট করুন।",
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // 6. Transaction ID Form
            Column {
                Text(
                    text = "পেমেন্ট নিশ্চিতকরণ ফর্ম:",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = transactionId,
                    onValueChange = { transactionId = it },
                    label = { Text("Transaction ID (TrxID)") },
                    placeholder = { Text("যেমন: 9J3K5L92P") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = amountText,
                    onValueChange = { amountText = it },
                    label = { Text("টাকার পরিমাণ (৳)") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                )

                if (submitSuccess) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF10B981).copy(alpha = 0.15f)
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = Color(0xFF10B981),
                                modifier = Modifier.size(22.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = "পেমেন্ট অনুরোধ সফলভাবে জমা দেওয়া হয়েছে! অ্যাডমিন যাচাই করার পর আপনার অ্যাকাউন্টটি পেইড মেম্বারশিপে সক্রিয় হবে।",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF065F46)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (transactionId.isNotBlank()) {
                            isSubmitting = true
                            val amount = amountText.toDoubleOrNull() ?: 99.0
                            scope.launch {
                                val res = userRepository.submitPaymentRequest(selectedMethod, transactionId.trim(), amount)
                                isSubmitting = false
                                if (res.isSuccess) {
                                    submitSuccess = true
                                    Toast.makeText(context, "অনুরোধ পাঠানো হয়েছে!", Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(context, "ব্যর্থ হয়েছে। অনুগ্রহ করে ইন্টারনেট সংযোগ চেক করুন।", Toast.LENGTH_LONG).show()
                                }
                            }
                        }
                    },
                    enabled = !isSubmitting && transactionId.isNotBlank() && !submitSuccess,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    if (isSubmitting) {
                        CircularProgressIndicator(modifier = Modifier.size(20.dp), strokeWidth = 2.dp)
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    Text(
                        text = if (submitSuccess) "সাবমিট সম্পন্ন হয়েছে" else "পেমেন্ট সাবমিট করুন",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun PackageOptionCard(
    title: String,
    price: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(if (selected) 4.dp else 1.dp),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = if (selected) Color.White else MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = price,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = if (selected) Color.White else MaterialTheme.colorScheme.primary
            )
        }
    }
}
