package com.gigabyte.bookstore.presentation.payment

import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.repository.UserRepository
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar
import kotlinx.coroutines.launch

data class AppCoursePackage(
    val id: String,
    val title: String,
    val subtitle: String,
    val price: Double,
    val priceDisplay: String,
    val icon: ImageVector,
    val tag: String? = null,
    val highlights: List<String>
)

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
    val unlockedBundles by app.appPreferences.unlockedBundles.collectAsStateWithLifecycle()

    val packages = remember {
        listOf(
            AppCoursePackage(
                id = "audiobook_bundle",
                title = "অডিওবুক বান্ডেল",
                subtitle = "লাইব্রেরির সব পূর্ণ বই ও মূল PDF",
                price = 100.0,
                priceDisplay = "৳ ১০০",
                icon = Icons.Default.MenuBook,
                tag = "জনপ্রিয়",
                highlights = listOf(
                    "সব বইয়ের সম্পূর্ণ অধ্যায় অডিও ও টেক্সট",
                    "হাই-কোয়ালিটি মূল PDF ফাইল সরাসরি ডাউনলোড",
                    "আজীবন আনলিমিটেড লাইব্রেরি অ্যাক্সেস"
                )
            ),
            AppCoursePackage(
                id = "english_course",
                title = "স্পোকেন ইংলিশ কোর্স",
                subtitle = "সহজে অনর্গল ইংরেজি বলা শিখুন",
                price = 100.0,
                priceDisplay = "৳ ১০০",
                icon = Icons.Default.RecordVoiceOver,
                tag = null,
                highlights = listOf(
                    "দৈনন্দিন কথোপকথনের অডিও লেসন (১–২০)",
                    "উচ্চারণ ও ফ্লুয়েন্সি মাস্টারক্লাস অডিও",
                    "প্র্যাকটিস শিট ও লেকচার নোটস PDF"
                )
            ),
            AppCoursePackage(
                id = "japanese_course",
                title = "জাপানিজ স্পোকেন কোর্স",
                subtitle = "JLPT N5 বেসিক টু স্পিকিং",
                price = 100.0,
                priceDisplay = "৳ ১০০",
                icon = Icons.Default.Translate,
                tag = null,
                highlights = listOf(
                    "বেসিক হিরাগানা, কাতাকানা ও প্রয়োজনীয় শব্দভাণ্ডার",
                    "দৈনন্দিন জাপানিজ সিচুয়েশনাল কথোপকথন অডিও",
                    "জাপান ভিসা ও উচ্চশিক্ষার্থীদের বিশেষ সিলেবাস"
                )
            ),
            AppCoursePackage(
                id = "mega_bundle",
                title = "অল-ইন-ওয়ান মেগা বান্ডেল",
                subtitle = "৩টি কোর্স একসাথে (৫০ টাকা ছাড়!)",
                price = 250.0,
                priceDisplay = "৳ ২৫০",
                icon = Icons.Default.Stars,
                tag = "সেরা অফার",
                highlights = listOf(
                    "সম্পূর্ণ অডিওবুক বান্ডেল (সব বই ও PDF)",
                    "সম্পূর্ণ স্পোকেন ইংলিশ কোর্স (সব লেসন ও নোট)",
                    "সম্পূর্ণ জাপানিজ স্পোকেন কোর্স (JLPT N5 সিলেবাস)",
                    "এককালীন পেমেন্টে আজীবন ৩টি কোর্সের অ্যাক্সেস"
                )
            )
        )
    }

    var selectedPackageId by remember { mutableStateOf("audiobook_bundle") }
    val selectedPackage = packages.firstOrNull { it.id == selectedPackageId } ?: packages.first()

    var selectedMethod by remember { mutableStateOf("bKash") }
    var transactionId by remember { mutableStateOf("") }
    var amountText by remember { mutableStateOf(selectedPackage.price.toInt().toString()) }
    var isSubmitting by remember { mutableStateOf(false) }
    var submissionError by remember { mutableStateOf<String?>(null) }
    var submitSuccess by remember { mutableStateOf(false) }

    val paymentNumbers = mapOf(
        "bKash" to "01700-000000",
        "Nagad" to "01800-000000",
        "Rocket" to "01900-000000"
    )

    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = {
                    Text(
                        text = "কোর্স ও মেম্বারশিপ প্যাকেজ",
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
                }
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
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f)
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
                                text = userName.ifBlank { "শিক্ষার্থী / ইউজার" },
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
                                text = if (isPaid) "PAID MEMBER" else "FREE PREVIEW",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "রেফারেল ওয়ালেট ব্যালেন্স:",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = "৳ ${"%.2f".format(userBalance)}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            // 2. Selectable Course Packages
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = "কোর্স বা বান্ডেল নির্বাচন করুন:",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )

                packages.forEach { pkg ->
                    val isSelected = selectedPackageId == pkg.id
                    val isAlreadyUnlocked = app.appPreferences.isBundleUnlocked(pkg.id)

                    CourseBundleCard(
                        pkg = pkg,
                        isSelected = isSelected,
                        isUnlocked = isAlreadyUnlocked,
                        onClick = {
                            selectedPackageId = pkg.id
                            amountText = pkg.price.toInt().toString()
                        }
                    )
                }
            }

            // 3. Selected Package Highlights Summary
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = selectedPackage.icon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "${selectedPackage.title} (${selectedPackage.priceDisplay}) এর সুবিধা:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.5.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    selectedPackage.highlights.forEach { point ->
                        Row(
                            modifier = Modifier.padding(vertical = 2.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            Text(
                                text = "✓ ",
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF10B981),
                                fontSize = 12.sp
                            )
                            Text(
                                text = point,
                                fontSize = 12.sp,
                                lineHeight = 17.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            // 4. Payment Method Selection
            Column {
                Text(
                    text = "পেমেন্ট মাধ্যম বেছে নিন (Send Money):",
                    fontSize = 13.5.sp,
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

            // 5. Payment Number & Copy Box
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

            // 6. Payment Instructions
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.25f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = "পেমেন্ট নির্দেশিকা:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "১. আপনার $selectedMethod অ্যাপে গিয়ে 'Send Money' সিলেক্ট করুন।\n২. উপরের নম্বরে ${selectedPackage.priceDisplay} সেন্ড মানি করুন।\n৩. সফল ট্রানজেকশনের পর SMS বা অ্যাপ থেকে TrxID কপি করে নিচে লিখুন।\n৪. অ্যাডমিন ভেরিফাই করলেই আপনার কোর্সটি অবিলম্বে আনলক হয়ে যাবে।",
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // 7. Transaction Confirmation Form
            Column {
                Text(
                    text = "পেমেন্ট নিশ্চিতকরণ তথ্য:",
                    fontSize = 13.5.sp,
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

                if (submissionError != null) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFFEE2E2)
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = null,
                                tint = Color(0xFFDC2626),
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = submissionError ?: "",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFFB91C1C)
                            )
                        }
                    }
                }

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
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = "'${selectedPackage.title}' এর জন্য ৳$amountText পেমেন্ট অনুরোধ সফলভাবে জমা দেওয়া হয়েছে! অ্যাডমিন যাচাই করার পর আপনার কোর্সটি সক্রিয় হবে।",
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
                            submissionError = null
                            val amount = amountText.toDoubleOrNull() ?: selectedPackage.price
                            scope.launch {
                                val res = userRepository.submitPaymentRequest(
                                    method = selectedMethod,
                                    transactionId = transactionId.trim(),
                                    amount = amount,
                                    packageType = selectedPackageId
                                )
                                isSubmitting = false
                                if (res.isSuccess) {
                                    submitSuccess = true
                                    submissionError = null
                                    Toast.makeText(context, "অনুরোধ সফলভাবে পাঠানো হয়েছে!", Toast.LENGTH_SHORT).show()
                                } else {
                                    val err = res.exceptionOrNull()?.message ?: "পেমেন্ট অনুরোধ পাঠাতে ব্যর্থ হয়েছে। অনুগ্রহ করে ইন্টারনেট চেক করুন।"
                                    submissionError = err
                                    Toast.makeText(context, err, Toast.LENGTH_LONG).show()
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
                        text = if (submitSuccess) "অনুরোধ পাঠানো সম্পন্ন" else "পেমেন্ট জমা দিন (${selectedPackage.priceDisplay})",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun CourseBundleCard(
    pkg: AppCoursePackage,
    isSelected: Boolean,
    isUnlocked: Boolean,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) {
                MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.45f)
            } else {
                MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)
            }
        ),
        border = if (isSelected) {
            androidx.compose.foundation.BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
        } else if (isUnlocked) {
            androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.6f))
        } else {
            androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(
                            if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = pkg.icon,
                        contentDescription = null,
                        tint = if (isSelected) Color.White else MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(22.dp)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = pkg.title,
                            fontSize = 14.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        if (pkg.tag != null) {
                            Spacer(modifier = Modifier.width(6.dp))
                            Surface(
                                color = Color(0xFFEC4899),
                                shape = RoundedCornerShape(6.dp)
                            ) {
                                Text(
                                    text = pkg.tag,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = pkg.subtitle,
                        fontSize = 11.5.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    if (isUnlocked) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = Color(0xFF10B981),
                                modifier = Modifier.size(13.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "ইতিমধ্যে কেনা হয়েছে (Unlocked)",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF10B981)
                            )
                        }
                    }
                }
            }

            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = pkg.priceDisplay,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                RadioButton(
                    selected = isSelected,
                    onClick = onClick,
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}
