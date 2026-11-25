package com.gigabyte.bookstore.presentation.payment

import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.models.RecipientValidationResult
import com.gigabyte.bookstore.data.repository.UserRepository
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar
import com.gigabyte.bookstore.presentation.components.UserQrCodeDialog
import com.gigabyte.bookstore.presentation.components.startQrCodeScanner
import kotlinx.coroutines.launch

data class AppCoursePackage(
    val id: String,
    val title: String,
    val subtitle: String,
    val price: Double,
    val priceDisplay: String,
    val icon: ImageVector,
    val flagEmoji: String,
    val tag: String? = null,
    val highlights: List<String>
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(
    initialPackageId: String? = null,
    onNavigateBack: () -> Unit,
    onNavigateToReferral: (() -> Unit)? = null
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
    val pricingConfig by app.appPreferences.pricingConfig.collectAsStateWithLifecycle()
    val walletPin by app.appPreferences.walletPin.collectAsStateWithLifecycle()

    val packages = remember(pricingConfig) {
        listOf(
            AppCoursePackage(
                id = "audiobook_bundle",
                title = "অডিওবুক বান্ডেল",
                subtitle = "লাইব্রেরির সব পূর্ণ বই ও মূল PDF",
                price = pricingConfig.getPackagePrice("audiobook_bundle"),
                priceDisplay = "৳ ${pricingConfig.getPackagePrice("audiobook_bundle").toInt()}",
                icon = Icons.Default.MenuBook,
                flagEmoji = "📚",
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
                price = pricingConfig.getPackagePrice("english_course"),
                priceDisplay = "৳ ${pricingConfig.getPackagePrice("english_course").toInt()}",
                icon = Icons.Default.RecordVoiceOver,
                flagEmoji = "🇬🇧",
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
                price = pricingConfig.getPackagePrice("japanese_course"),
                priceDisplay = "৳ ${pricingConfig.getPackagePrice("japanese_course").toInt()}",
                icon = Icons.Default.Translate,
                flagEmoji = "🇯🇵",
                tag = null,
                highlights = listOf(
                    "বেসিক হিরাগানা, কাতাকানা ও প্রয়োজনীয় শব্দভাণ্ডার",
                    "দৈনন্দিন জাপানিজ সিচুয়েশনাল কথোপকথন অডিও",
                    "জাপান ভিসা ও উচ্চশিক্ষার্থীদের বিশেষ সিলেবাস"
                )
            ),
            AppCoursePackage(
                id = "urdu_course",
                title = "উর্দু স্পোকেন কোর্স",
                subtitle = "শূন্য থেকে A1: হরফ, উচ্চারণ ও কথা বলা",
                price = pricingConfig.getPackagePrice("urdu_course"),
                priceDisplay = "৳ ${pricingConfig.getPackagePrice("urdu_course").toInt()}",
                icon = Icons.Default.Translate,
                flagEmoji = "🇵🇰",
                tag = null,
                highlights = listOf(
                    "উর্দু হরফ, নতুন ধ্বনি ও বাংলা-উর্দু মিল শব্দ",
                    "দৈনন্দিন কথোপকথন ও রোল-প্লে অডিও লেসন",
                    "নারী ও পুরুষ দুই রূপেই অনুশীলন"
                )
            ),
            AppCoursePackage(
                id = "hindi_course",
                title = "হিন্দি স্পোকেন কোর্স",
                subtitle = "শূন্য থেকে A1: দেবনগরী, উচ্চারণ ও কথা বলা",
                price = pricingConfig.getPackagePrice("hindi_course"),
                priceDisplay = "৳ ${pricingConfig.getPackagePrice("hindi_course").toInt()}",
                icon = Icons.Default.Translate,
                flagEmoji = "🇮🇳",
                tag = null,
                highlights = listOf(
                    "দেবনগরী বর্ণমালা, মাত্রা ও বাংলা-হিন্দি মিল শব্দ",
                    "দৈনন্দিন কথোপকথন, ভ্রমণ ও রোল-প্লে অডিও লেসন",
                    "নারী ও পুরুষ দুই রূপেই অনুশীলন"
                )
            ),
            AppCoursePackage(
                id = "german_course",
                title = "জার্মান স্পোকেন কোর্স",
                subtitle = "শূন্য থেকে A1: উচ্চারণ, ব্যাকরণ ও কথা বলা",
                price = pricingConfig.getPackagePrice("german_course"),
                priceDisplay = "৳ ${pricingConfig.getPackagePrice("german_course").toInt()}",
                icon = Icons.Default.Translate,
                flagEmoji = "🇩🇪",
                tag = null,
                highlights = listOf(
                    "জার্মান বর্ণমালা, উমলাউট (ä, ö, ü, ß) ও উচ্চারণ",
                    "der/die/das আর্টিকেল ও একুশে নিয়ম (V2 স্ট্রাকচার)",
                    "A1 স্পিকিং টেস্ট ও জার্মানি ভিসা/উচ্চশিক্ষা প্রস্তুতি"
                )
            ),
            AppCoursePackage(
                id = "chinese_course",
                title = "চাইনিজ (ম্যান্ডারিন) স্পোকেন কোর্স",
                subtitle = "শূন্য থেকে HSK 1: পিনইন, ৪টি সুর ও কথা বলা",
                price = pricingConfig.getPackagePrice("chinese_course"),
                priceDisplay = "৳ ${pricingConfig.getPackagePrice("chinese_course").toInt()}",
                icon = Icons.Default.Translate,
                flagEmoji = "🇨🇳",
                tag = "নতুন",
                highlights = listOf(
                    "পিনইন, ৪টি সুর ও টোন সন্ধি (Tone Sandhi) মাস্টারি",
                    "হালাল খাবার, কেনাকাটা, মেট্রো ও হোটেল রোল-প্লে",
                    "১,০০০ শব্দের ভল্ট ও ৬৪টি অডিও লেসন"
                )
            ),
            AppCoursePackage(
                id = "arabic_course",
                title = "আরবি স্পোকেন কোর্স",
                subtitle = "শূন্য থেকে A1 ও গাল্ফ প্রবাস: মাখরাজ, হরকত ও কথা বলা",
                price = pricingConfig.getPackagePrice("arabic_course"),
                priceDisplay = "৳ ${pricingConfig.getPackagePrice("arabic_course").toInt()}",
                icon = Icons.Default.Translate,
                flagEmoji = "🇸🇦",
                tag = "নতুন",
                highlights = listOf(
                    "২৮টি হরফের মাখরাজ, হরকত-তানভীন ও আরবি-বাংলা কগনেট",
                    "সৌদি-দুবাই প্রবাস, বাজার-দামদর, এয়ারপোর্ট ও ওমরাহ রোল-প্লে",
                    "১,০০০ শব্দের ভল্ট ও ৬৪টি অডিও লেসন"
                )
            ),
            AppCoursePackage(
                id = "korean_course",
                title = "কোরিয়ান স্পোকেন কোর্স",
                subtitle = "শূন্য থেকে A1 ও EPS-TOPIK: হাঙ্গুল, বাচ্ছিম ও কথা বলা",
                price = pricingConfig.getPackagePrice("korean_course"),
                priceDisplay = "৳ ${pricingConfig.getPackagePrice("korean_course").toInt()}",
                icon = Icons.Default.Translate,
                flagEmoji = "🇰🇷",
                tag = "নতুন",
                highlights = listOf(
                    "হাঙ্গুল (한글) বর্ণমালা, বাচ্ছিম নিয়ম ও দ্বৈত সংখ্যা গণনা",
                    "EPS-TOPIK কর্মক্ষেত্র, সাবওয়ে, হালাল খাবার ও হাসপাতাল রোল-প্লে",
                    "১,০০০ শব্দের ভল্ট ও ৬৪টি অডিও লেসন"
                )
            ),
            AppCoursePackage(
                id = "regional_course",
                title = "বাংলা আঞ্চলিক ভাষা তুলনামূলক স্পোকেন কোর্স",
                subtitle = "একই বাক্য ১০টি অঞ্চলের কথ্য ভাষায় পাশাপাশি শিক্ষা",
                price = pricingConfig.getPackagePrice("regional_course"),
                priceDisplay = "৳ ${pricingConfig.getPackagePrice("regional_course").toInt()}",
                icon = Icons.Default.Translate,
                flagEmoji = "🇧🇩",
                tag = "নতুন",
                highlights = listOf(
                    "প্রতিটি বাক্য চট্টগ্রাম, নোয়াখালী, সিলেট, ঢাকাসহ ১০ অঞ্চলে পাশাপাশি",
                    "বরিশাল, রাজশাহী, রংপুর, খুলনা, ময়মনসিংহ ও কলকাতার তুলনামূলক রূপ",
                    "৩২টি অডিও লেসন ও ৬৪টি বাক্য × ১০ অঞ্চল (৬৪০টি রূপ)"
                )
            ),
            AppCoursePackage(
                id = "mega_bundle",
                title = "অল-ইন-ওয়ান মেগা বান্ডেল",
                subtitle = "সবগুলো কোর্স ও অডিওবুক একসাথে",
                price = pricingConfig.megaBundlePrice,
                priceDisplay = "৳ ${pricingConfig.megaBundlePrice.toInt()}",
                icon = Icons.Default.Stars,
                flagEmoji = "👑",
                tag = "সেরা অফার",
                highlights = listOf(
                    "সম্পূর্ণ অডিওবুক বান্ডেল (সব বই ও PDF)",
                    "সব স্পোকেন ল্যাঙ্গুয়েজ কোর্স (ইংরেজি, জাপানিজ, জার্মান, চাইনিজ, আরবি, কোরিয়ান, উর্দু, হিন্দি)",
                    "এককালীন পেমেন্টে আজীবন সব কোর্সের আনলিমিটেড অ্যাক্সেস"
                )
            )
        )
    }

    var isGiftMode by remember { mutableStateOf(false) }
    var showMyQrDialog by remember { mutableStateOf(false) }
    var recipientEmail by remember { mutableStateOf("") }
    var isVerifyingRecipient by remember { mutableStateOf(false) }
    var recipientValidation by remember { mutableStateOf<RecipientValidationResult?>(null) }
    var recipientError by remember { mutableStateOf<String?>(null) }
    var showSetPinDialog by remember { mutableStateOf(false) }
    var showEnterPinDialog by remember { mutableStateOf(false) }
    var enteredPinText by remember { mutableStateOf("") }
    var confirmPinText by remember { mutableStateOf("") }
    var pinDialogError by remember { mutableStateOf<String?>(null) }
    var isGiftPurchasing by remember { mutableStateOf(false) }
    var giftSuccessDialogData by remember { mutableStateOf<Triple<String, String, Double>?>(null) }

    var showResetPinDialog by remember { mutableStateOf(false) }
    var resetPhoneInput by remember { mutableStateOf("") }
    var resetNewPinInput by remember { mutableStateOf("") }
    var isResettingPin by remember { mutableStateOf(false) }
    var resetPinError by remember { mutableStateOf<String?>(null) }

    val displayedPackages = remember(packages, unlockedBundles, isGiftMode) {
        if (isGiftMode) {
            packages
        } else {
            packages.filter { !app.appPreferences.isBundleUnlocked(it.id) }
        }
    }
    var selectedPackageId by remember(initialPackageId) {
        mutableStateOf(initialPackageId ?: "audiobook_bundle")
    }
    val selectedPackage = displayedPackages.firstOrNull { it.id == selectedPackageId }
        ?: displayedPackages.firstOrNull()
        ?: packages.first()
    val isPackageAlreadyUnlocked = if (isGiftMode) {
        recipientValidation?.isPackageUnlocked(selectedPackage.id) ?: false
    } else {
        app.appPreferences.isBundleUnlocked(selectedPackage.id)
    }
    val hasSufficientBalance = userBalance >= selectedPackage.price && userBalance >= 100.0

    var selectedMethod by remember { mutableStateOf("bKash") }
    var transactionId by remember { mutableStateOf("") }
    var isSubmitting by remember { mutableStateOf(false) }
    var submissionError by remember { mutableStateOf<String?>(null) }
    var showPaymentCheckoutDialog by remember { mutableStateOf(false) }
    var paymentSuccessPackageTitle by remember { mutableStateOf<String?>(null) }
    var showWalletConfirmDialog by remember { mutableStateOf(false) }
    var isWalletPurchasing by remember { mutableStateOf(false) }

    var paymentNumbers by remember {
        mutableStateOf(
            mapOf(
                "bKash" to "01700-000000",
                "Nagad" to "01800-000000",
                "Rocket" to "01900-000000"
            )
        )
    }
    var paymentTypes by remember {
        mutableStateOf(
            mapOf(
                "bKash" to "Personal",
                "Nagad" to "Personal",
                "Rocket" to "Personal"
            )
        )
    }

    LaunchedEffect(Unit) {
        val config = userRepository.getPaymentNumbers()
        paymentNumbers = config.numbers
        paymentTypes = config.types
    }

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
        },
        bottomBar = {
            AnimatedVisibility(
                visible = displayedPackages.isNotEmpty() && !isPackageAlreadyUnlocked && !isGiftMode && userBalance < 100.0,
                enter = androidx.compose.animation.slideInVertically(initialOffsetY = { it }) + androidx.compose.animation.fadeIn(),
                exit = androidx.compose.animation.slideOutVertically(targetOffsetY = { it }) + androidx.compose.animation.fadeOut()
            ) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shadowElevation = 10.dp,
                    color = MaterialTheme.colorScheme.surface,
                    tonalElevation = 3.dp,
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.35f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .windowInsetsPadding(WindowInsets.navigationBars)
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 12.dp)
                        ) {
                            Text(
                                text = "${selectedPackage.flagEmoji} ${selectedPackage.title}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                maxLines = 1,
                                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                            )
                            Text(
                                text = selectedPackage.priceDisplay,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                        Button(
                            onClick = {
                                transactionId = ""
                                submissionError = null
                                showPaymentCheckoutDialog = true
                            },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                            contentPadding = PaddingValues(horizontal = 18.dp, vertical = 10.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.LockOpen,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("পেমেন্ট করুন", fontWeight = FontWeight.Bold, fontSize = 14.5.sp)
                        }
                    }
                }
            }
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

            // 2. Direct Wallet Purchase & Course Sell / Resell Section (Shown when wallet balance >= 100.0)
            if (userBalance >= 100.0) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.45f)
                    ),
                    border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary),
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
                                        imageVector = Icons.Default.AccountBalanceWallet,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.onPrimary,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = "💰 রেফারেল ব্যালেন্স দিয়ে ক্রয় ও রেফার",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = if (userBalance >= selectedPackage.price)
                                        "আপনার ওয়ালেট ব্যালেন্স: ৳ ${"%.2f".format(userBalance)} (পর্যাপ্ত)"
                                    else
                                        "আপনার ওয়ালেট ব্যালেন্স: ৳ ${"%.2f".format(userBalance)} (প্রয়োজন ৳${selectedPackage.price.toInt()})",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = if (userBalance >= selectedPackage.price) Color(0xFF10B981) else Color(0xFFF59E0B)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        // Segmented Action Cards for Self vs Course Sell
                        val resellBonus = pricingConfig.getReferralBonus(selectedPackage.id, selectedPackage.price).toInt()

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            // Option 1: Self-Purchase
                            Surface(
                                onClick = { isGiftMode = false },
                                shape = RoundedCornerShape(12.dp),
                                color = if (!isGiftMode) Color(0xFF10B981).copy(alpha = 0.18f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
                                border = BorderStroke(
                                    if (!isGiftMode) 2.dp else 1.dp,
                                    if (!isGiftMode) Color(0xFF10B981) else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
                                ),
                                modifier = Modifier.weight(1f)
                            ) {
                                Column(
                                    modifier = Modifier.padding(12.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Person,
                                        contentDescription = null,
                                        tint = if (!isGiftMode) Color(0xFF047857) else MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(22.dp)
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "👤 নিজের জন্য",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.5.sp,
                                        color = if (!isGiftMode) Color(0xFF047857) else MaterialTheme.colorScheme.onSurface
                                    )
                                    Text(
                                        text = "১-ক্লিকে আনলক",
                                        fontSize = 11.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }

                            // Option 2: Course Resell / Gift
                            Surface(
                                onClick = { isGiftMode = true },
                                shape = RoundedCornerShape(12.dp),
                                color = if (isGiftMode) Color(0xFF10B981).copy(alpha = 0.18f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
                                border = BorderStroke(
                                    if (isGiftMode) 2.dp else 1.dp,
                                    if (isGiftMode) Color(0xFF10B981) else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
                                ),
                                modifier = Modifier.weight(1f)
                            ) {
                                Column(
                                    modifier = Modifier.padding(12.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.MonetizationOn,
                                        contentDescription = null,
                                        tint = if (isGiftMode) Color(0xFF047857) else MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(22.dp)
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "💼 কোর্স বিক্রি",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.5.sp,
                                        color = if (isGiftMode) Color(0xFF047857) else MaterialTheme.colorScheme.onSurface
                                    )
                                    Surface(
                                        color = Color(0xFF10B981),
                                        shape = RoundedCornerShape(4.dp)
                                    ) {
                                        Text(
                                            text = "+৳$resellBonus নগদ লাভ",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        if (!isGiftMode) {
                            // Self-Purchase Mode
                            val isSelfUnlocked = app.appPreferences.isBundleUnlocked(selectedPackage.id)
                            if (isSelfUnlocked) {
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = Color(0xFF10B981).copy(alpha = 0.12f),
                                    border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.4f)),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(
                                        modifier = Modifier.padding(10.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.CheckCircle,
                                            contentDescription = null,
                                            tint = Color(0xFF10B981),
                                            modifier = Modifier.size(18.dp)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = "✅ '${selectedPackage.title}' ইতোমধ্যে আপনার অ্যাকাউন্টে সক্রিয় আছে।",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = Color(0xFF065F46)
                                        )
                                    }
                                }
                            } else {
                                Text(
                                    text = "কোনো প্রকার বিকাশ/নগদ পেমেন্ট ছাড়াই সরাসরি আপনার অর্জিত রেফারেল বোনাস থেকে '${selectedPackage.title}' সাথে সাথে আনলক করুন।",
                                    fontSize = 12.sp,
                                    lineHeight = 17.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )

                                Spacer(modifier = Modifier.height(12.dp))
                                Button(
                                    onClick = { showWalletConfirmDialog = true },
                                    modifier = Modifier.fillMaxWidth(),
                                    enabled = hasSufficientBalance && !isWalletPurchasing && !isSubmitting,
                                    shape = RoundedCornerShape(10.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981))
                                ) {
                                    if (isWalletPurchasing) {
                                        CircularProgressIndicator(modifier = Modifier.size(18.dp), color = Color.White, strokeWidth = 2.dp)
                                        Spacer(modifier = Modifier.width(8.dp))
                                    } else {
                                        Icon(
                                            imageVector = Icons.Default.FlashOn,
                                            contentDescription = null,
                                            tint = Color.White,
                                            modifier = Modifier.size(18.dp)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                    }
                                    Text(
                                        text = if (hasSufficientBalance) "নিজের অ্যাকাউন্টে আনলক করুন (${selectedPackage.priceDisplay})" else "ব্যালেন্স অপর্যাপ্ত (${selectedPackage.priceDisplay})",
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }
                            }
                        } else {
                            // Course Resell / Gift to Others Mode (Cash without withdraw + 20 Taka bonus)
                            val bonusEarned = pricingConfig.getReferralBonus(selectedPackage.id, selectedPackage.price).toInt()
                            val packagePrice = selectedPackage.price.toInt()

                            Card(
                                shape = RoundedCornerShape(12.dp),
                                colors = CardDefaults.cardColors(containerColor = Color(0xFF10B981).copy(alpha = 0.1f)),
                                border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.35f)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(12.dp)) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            imageVector = Icons.Default.MonetizationOn,
                                            contentDescription = null,
                                            tint = Color(0xFF047857),
                                            modifier = Modifier.size(18.dp)
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(
                                            text = "উইথড্র ছাড়াই সরাসরি নগদ ক্যাশ আয়:",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.5.sp,
                                            color = Color(0xFF047857)
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(
                                        text = "• ক্রেতার কাছ থেকে নগদ নেবেন: ৳$packagePrice (হাতে ক্যাশ টাকা)\n• আপনার ব্যালেন্স থেকে ছাড় হবে: ৳$packagePrice\n• সাথে সাথে ওয়ালেটে বোনাস ব্যাক: +৳$bonusEarned\n• আপনার ইনস্ট্যান্ট লাভ: নগদ ৳$bonusEarned (উইথড্র রিকোয়েস্ট বা অপেক্ষা ছাড়াই)!",
                                        fontSize = 11.5.sp,
                                        lineHeight = 16.5.sp,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            OutlinedTextField(
                                value = recipientEmail,
                                onValueChange = {
                                    recipientEmail = it
                                    recipientValidation = null
                                    recipientError = null
                                },
                                label = { Text("প্রাপকের রেজিস্টার্ড ইমেইল") },
                                placeholder = { Text("friend@gmail.com") },
                                singleLine = true,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                                modifier = Modifier.fillMaxWidth(),
                                trailingIcon = {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(end = 4.dp)
                                    ) {
                                        IconButton(
                                            onClick = {
                                                startQrCodeScanner(
                                                    context = context,
                                                    onScanned = { scannedEmail ->
                                                        recipientEmail = scannedEmail
                                                        recipientError = null
                                                        recipientValidation = null
                                                        isVerifyingRecipient = true
                                                        scope.launch {
                                                            val res = userRepository.verifyRecipientUser(scannedEmail, selectedPackage.id)
                                                            isVerifyingRecipient = false
                                                            if (res.isSuccess) {
                                                                val validation = res.getOrNull()
                                                                recipientValidation = validation
                                                                if (validation != null && validation.isPackageUnlocked(selectedPackageId)) {
                                                                    val firstAvail = packages.firstOrNull { !validation.isPackageUnlocked(it.id) }
                                                                    if (firstAvail != null) {
                                                                        selectedPackageId = firstAvail.id
                                                                    }
                                                                }
                                                            } else {
                                                                recipientError = res.exceptionOrNull()?.message ?: "যাচাই ব্যর্থ হয়েছে"
                                                            }
                                                        }
                                                    },
                                                    onError = { err ->
                                                        Toast.makeText(context, err, Toast.LENGTH_SHORT).show()
                                                    }
                                                )
                                            },
                                            modifier = Modifier.size(34.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.QrCodeScanner,
                                                contentDescription = "Scan QR Code",
                                                tint = Color(0xFF10B981),
                                                modifier = Modifier.size(20.dp)
                                            )
                                        }

                                        Spacer(modifier = Modifier.width(4.dp))

                                        Button(
                                            onClick = {
                                                if (recipientEmail.isBlank()) return@Button
                                                isVerifyingRecipient = true
                                                recipientError = null
                                                recipientValidation = null
                                                scope.launch {
                                                    val res = userRepository.verifyRecipientUser(recipientEmail, selectedPackage.id)
                                                    isVerifyingRecipient = false
                                                    if (res.isSuccess) {
                                                        val validation = res.getOrNull()
                                                        recipientValidation = validation
                                                        if (validation != null && validation.isPackageUnlocked(selectedPackageId)) {
                                                            val firstAvail = packages.firstOrNull { !validation.isPackageUnlocked(it.id) }
                                                            if (firstAvail != null) {
                                                                selectedPackageId = firstAvail.id
                                                            }
                                                        }
                                                    } else {
                                                        recipientError = res.exceptionOrNull()?.message ?: "যাচাই ব্যর্থ হয়েছে"
                                                    }
                                                }
                                            },
                                            enabled = recipientEmail.isNotBlank() && !isVerifyingRecipient,
                                            shape = RoundedCornerShape(8.dp),
                                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                                        ) {
                                            if (isVerifyingRecipient) {
                                                CircularProgressIndicator(modifier = Modifier.size(14.dp), color = Color.White, strokeWidth = 2.dp)
                                            } else {
                                                Text("যাচাই", fontSize = 11.5.sp)
                                            }
                                        }
                                    }
                                }
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp, bottom = 4.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "📷 স্ক্যান করতে QR আইকনে চাপুন",
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                TextButton(
                                    onClick = { showMyQrDialog = true },
                                    contentPadding = PaddingValues(horizontal = 4.dp, vertical = 0.dp),
                                    modifier = Modifier.height(28.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.QrCode,
                                        contentDescription = null,
                                        tint = Color(0xFF10B981),
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "আমার QR কোড",
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color(0xFF047857)
                                    )
                                }
                            }

                            if (recipientValidation != null) {
                                val isCurrentPackageUnlockedForRecipient = recipientValidation!!.isPackageUnlocked(selectedPackage.id)
                                val recipientAvailable = packages.filter { !recipientValidation!!.isPackageUnlocked(it.id) }
                                val recipientOwned = packages.filter { recipientValidation!!.isPackageUnlocked(it.id) }

                                Spacer(modifier = Modifier.height(6.dp))
                                Card(
                                    shape = RoundedCornerShape(8.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = if (isCurrentPackageUnlockedForRecipient) Color(0xFFEF4444).copy(alpha = 0.12f) else Color(0xFF10B981).copy(alpha = 0.12f)
                                    ),
                                    border = BorderStroke(1.dp, if (isCurrentPackageUnlockedForRecipient) Color(0xFFEF4444) else Color(0xFF10B981)),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            imageVector = if (isCurrentPackageUnlockedForRecipient) Icons.Default.Warning else Icons.Default.CheckCircle,
                                            contentDescription = null,
                                            tint = if (isCurrentPackageUnlockedForRecipient) Color(0xFFEF4444) else Color(0xFF10B981),
                                            modifier = Modifier.size(20.dp)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Column {
                                            Text(
                                                text = "প্রাপক: ${recipientValidation!!.name} (${recipientValidation!!.email})",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 13.sp,
                                                color = if (isCurrentPackageUnlockedForRecipient) Color(0xFF991B1B) else Color(0xFF065F46)
                                            )
                                            Text(
                                                text = if (isCurrentPackageUnlockedForRecipient)
                                                    "⚠️ প্রাপকের ইতোমধ্যে '${selectedPackage.title}' সক্রিয় আছে! নিচের তালিকা থেকে অন্য কোর্স বেছে নিন।"
                                                else
                                                    "✅ '${selectedPackage.title}' এর জন্য প্রাপক প্রস্তুত। ব্যালেন্স দিয়ে রেফার করুন।",
                                                fontSize = 11.5.sp,
                                                color = if (isCurrentPackageUnlockedForRecipient) Color(0xFFB91C1C) else Color(0xFF047857)
                                            )
                                        }
                                    }
                                }

                                // Interactive Available Courses List for the Recipient
                                if (recipientAvailable.isNotEmpty()) {
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Card(
                                        shape = RoundedCornerShape(10.dp),
                                        colors = CardDefaults.cardColors(
                                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f)
                                        ),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Text(
                                                text = "🎯 প্রাপকের ক্রয়যোগ্য উপলব্ধ কোর্স (${recipientAvailable.size}টি):",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 12.5.sp,
                                                color = MaterialTheme.colorScheme.primary
                                            )
                                            Spacer(modifier = Modifier.height(8.dp))
                                            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                                recipientAvailable.forEach { availPkg ->
                                                    val isChosen = selectedPackage.id == availPkg.id
                                                    val bonus = pricingConfig.getReferralBonus(availPkg.id, availPkg.price).toInt()
                                                    Surface(
                                                        onClick = { selectedPackageId = availPkg.id },
                                                        shape = RoundedCornerShape(8.dp),
                                                        color = if (isChosen) Color(0xFF10B981) else MaterialTheme.colorScheme.surface,
                                                        border = BorderStroke(
                                                            if (isChosen) 1.5.dp else 1.dp,
                                                            if (isChosen) Color(0xFF047857) else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                                                        ),
                                                        modifier = Modifier.fillMaxWidth()
                                                    ) {
                                                        Row(
                                                            modifier = Modifier
                                                                .fillMaxWidth()
                                                                .padding(horizontal = 10.dp, vertical = 8.dp),
                                                            horizontalArrangement = Arrangement.SpaceBetween,
                                                            verticalAlignment = Alignment.CenterVertically
                                                        ) {
                                                            Row(
                                                                verticalAlignment = Alignment.CenterVertically,
                                                                modifier = Modifier.weight(1f)
                                                            ) {
                                                                Icon(
                                                                    imageVector = if (isChosen) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked,
                                                                    contentDescription = null,
                                                                    tint = if (isChosen) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                                                                    modifier = Modifier.size(16.dp)
                                                                )
                                                                Spacer(modifier = Modifier.width(8.dp))
                                                                Column {
                                                                    Text(
                                                                        text = availPkg.title,
                                                                        fontSize = 12.sp,
                                                                        fontWeight = if (isChosen) FontWeight.Bold else FontWeight.Medium,
                                                                        color = if (isChosen) Color.White else MaterialTheme.colorScheme.onSurface
                                                                    )
                                                                    Text(
                                                                        text = "মূল্য: ${availPkg.priceDisplay}",
                                                                        fontSize = 11.sp,
                                                                        color = if (isChosen) Color.White.copy(alpha = 0.9f) else MaterialTheme.colorScheme.onSurfaceVariant
                                                                    )
                                                                }
                                                            }
                                                            Surface(
                                                                color = if (isChosen) Color(0xFF047857) else Color(0xFF10B981).copy(alpha = 0.15f),
                                                                shape = RoundedCornerShape(6.dp)
                                                            ) {
                                                                Text(
                                                                    text = "+৳$bonus লাভ",
                                                                    fontSize = 10.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    color = if (isChosen) Color.White else Color(0xFF047857),
                                                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                                                )
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "ℹ️ প্রাপক ইতোমধ্যে সব কোর্স ও মেগা বান্ডেল সম্পন্ন করেছেন।",
                                        fontSize = 11.5.sp,
                                        color = Color(0xFFB91C1C)
                                    )
                                }

                                if (recipientOwned.isNotEmpty()) {
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(
                                        text = "✓ প্রাপকের ইতোমধ্যেই আছে: " + recipientOwned.joinToString(", ") { it.title },
                                        fontSize = 11.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }

                            if (recipientError != null) {
                                Spacer(modifier = Modifier.height(8.dp))
                                Card(
                                    shape = RoundedCornerShape(8.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color(0xFFEF4444).copy(alpha = 0.1f)),
                                    border = BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.5f)),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
                                        Icon(imageVector = Icons.Default.ErrorOutline, contentDescription = null, tint = Color(0xFFEF4444), modifier = Modifier.size(18.dp))
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(text = recipientError!!, fontSize = 11.5.sp, color = Color(0xFF991B1B))
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            val isCurrentPackageUnlockedForRecipient = recipientValidation?.isPackageUnlocked(selectedPackage.id) == true
                            val canAffordForRecipient = userBalance >= selectedPackage.price

                            Button(
                                onClick = {
                                    enteredPinText = ""
                                    confirmPinText = ""
                                    pinDialogError = null
                                    if (walletPin.isBlank()) {
                                        showSetPinDialog = true
                                    } else {
                                        showEnterPinDialog = true
                                    }
                                },
                                enabled = recipientValidation != null && !isCurrentPackageUnlockedForRecipient && canAffordForRecipient && !isGiftPurchasing,
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981))
                            ) {
                                Icon(imageVector = Icons.Default.Share, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = when {
                                        recipientValidation == null -> "প্রাপকের ইমেইল যাচাই করুন"
                                        isCurrentPackageUnlockedForRecipient -> "প্রাপকের এই কোর্সটি ইতোমধ্যেই আছে"
                                        !canAffordForRecipient -> "ব্যালেন্স অপর্যাপ্ত (${selectedPackage.priceDisplay})"
                                        else -> "💼 কোর্স বিক্রি সম্পন্ন করুন (পাবেন ৳$bonusEarned বোনাস)"
                                    },
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }

            // 2. Selectable Course Packages
            val showAllPurchasedBanner = !isGiftMode && displayedPackages.isEmpty()
            if (showAllPurchasedBanner) {
                Card(
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF10B981).copy(alpha = 0.12f)),
                    border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.4f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFF10B981),
                            modifier = Modifier.size(52.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                        }
                        Text(
                            text = "সব কোর্স সফলভাবে আনলক করা হয়েছে!",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color(0xFF065F46)
                        )
                        Text(
                            text = "🎉 অভিনন্দন! আপনার অ্যাকাউন্টে সব কোর্স ও বান্ডেল ইতোমধ্যে সক্রিয় রয়েছে। নতুন কোনো পেমেন্টের প্রয়োজন নেই।",
                            fontSize = 12.5.sp,
                            lineHeight = 18.sp,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                            color = Color(0xFF047857)
                        )
                    }
                }
            } else {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = if (isGiftMode) "বিক্রির জন্য কোর্স বা বান্ডেল নির্বাচন করুন:" else "কোর্স বা বান্ডেল নির্বাচন করুন:",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )

                    displayedPackages.forEach { pkg ->
                        val isSelected = selectedPackageId == pkg.id
                        val isPkgUnlocked = if (isGiftMode) {
                            recipientValidation?.isPackageUnlocked(pkg.id) ?: false
                        } else {
                            app.appPreferences.isBundleUnlocked(pkg.id)
                        }

                        CourseBundleCard(
                            pkg = pkg,
                            isSelected = isSelected,
                            isUnlocked = isPkgUnlocked,
                            onClick = {
                                selectedPackageId = pkg.id
                            }
                        )
                    }
                }
            }

            // 3. Selected Package Highlights Summary
            if (displayedPackages.isNotEmpty()) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = selectedPackage.flagEmoji,
                                fontSize = 20.sp
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
            }

            val isPackageAlreadyUnlocked = app.appPreferences.isBundleUnlocked(selectedPackage.id)

            if (isPackageAlreadyUnlocked) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF10B981).copy(alpha = 0.15f)
                    ),
                    border = BorderStroke(1.dp, Color(0xFF10B981)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = Color(0xFF10B981),
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "এই কোর্সটি ইতোমধ্যে আপনার আনলক করা আছে!",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color(0xFF065F46)
                            )
                            Text(
                                text = "আপনি সরাসরি হোম বা লাইব্রেরি থেকে পুরো কনটেন্ট উপভোগ করতে পারেন।",
                                fontSize = 12.sp,
                                color = Color(0xFF047857)
                            )
                        }
                    }
                }
            }

            // 4. Mobile Banking Purchase Action (Shown only when wallet balance < 100.0)
            if (displayedPackages.isNotEmpty() && !isPackageAlreadyUnlocked && !isGiftMode && userBalance < 100.0) {
                Card(
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.primaryContainer,
                                modifier = Modifier.size(36.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Default.Payment,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = "মোবাইল ব্যাংকিং পেমেন্ট (bKash / Nagad / Rocket)",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.5.sp,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "সেন্ড মানি করে TrxID সাবমিট করলেই কোর্স সক্রিয় হবে",
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Info,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "নিচের স্টিকি বারের 'পেমেন্ট করুন' বাটনে চাপ দিয়ে বিকাশ, নগদ বা রকেটে পেমেন্ট সম্পন্ন করুন।",
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        }

        if (showWalletConfirmDialog) {
            AlertDialog(
                onDismissRequest = { if (!isWalletPurchasing) showWalletConfirmDialog = false },
                title = {
                    Text("কোর্স ক্রয়ের নিশ্চিতকরণ", fontWeight = FontWeight.Bold)
                },
                text = {
                    Text(
                        text = "আপনি কি নিশ্চিত যে আপনার রেফারেল ওয়ালেট ব্যালেন্স থেকে ৳${selectedPackage.price.toInt()} দিয়ে '${selectedPackage.title}' সাথে সাথে আনলক করতে চান?\n\nবর্তমান ব্যালেন্স: ৳${"%.2f".format(userBalance)}\nক্রয়ের পর ব্যালেন্স: ৳${"%.2f".format(userBalance - selectedPackage.price)}",
                        fontSize = 13.sp,
                        lineHeight = 19.sp
                    )
                },
                confirmButton = {
                    Button(
                        onClick = {
                            isWalletPurchasing = true
                            scope.launch {
                                val res = userRepository.purchaseCourseWithWalletBalance(
                                    packageType = selectedPackage.id,
                                    amount = selectedPackage.price
                                )
                                isWalletPurchasing = false
                                showWalletConfirmDialog = false
                                if (res.isSuccess) {
                                    Toast.makeText(
                                        context,
                                        "🎉 অভিনন্দন! '${selectedPackage.title}' কোর্সটি সফলভাবে আনলক হয়েছে!",
                                        Toast.LENGTH_LONG
                                    ).show()
                                } else {
                                    val err = res.exceptionOrNull()?.message ?: "কোর্স আনলক করতে সমস্যা হয়েছে"
                                    Toast.makeText(context, err, Toast.LENGTH_LONG).show()
                                }
                            }
                        },
                        enabled = !isWalletPurchasing,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981))
                    ) {
                        if (isWalletPurchasing) {
                            CircularProgressIndicator(modifier = Modifier.size(16.dp), color = Color.White, strokeWidth = 2.dp)
                            Spacer(modifier = Modifier.width(6.dp))
                        }
                        Text("হ্যাঁ, আনলক করুন", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showWalletConfirmDialog = false },
                        enabled = !isWalletPurchasing
                    ) {
                        Text("বাতিল")
                    }
                }
            )
        }

        // Payment Checkout Dialog (Standard Popup Flow)
        if (showPaymentCheckoutDialog) {
            val currentNumber = paymentNumbers[selectedMethod] ?: ""
            val currentType = paymentTypes[selectedMethod] ?: "Personal"
            AlertDialog(
                onDismissRequest = { if (!isSubmitting) showPaymentCheckoutDialog = false },
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.Payment,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(text = "পেমেন্ট সম্পন্ন করুন", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Text(
                                text = "${selectedPackage.flagEmoji} ${selectedPackage.title} • ${selectedPackage.priceDisplay}",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                },
                text = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "পেমেন্ট মাধ্যম বেছে নিন:",
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            listOf("bKash", "Nagad", "Rocket").forEach { method ->
                                FilterChip(
                                    selected = selectedMethod == method,
                                    onClick = { selectedMethod = method },
                                    label = { Text(method, fontSize = 12.sp, fontWeight = FontWeight.Medium) },
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp, vertical = 10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(
                                        text = "$selectedMethod $currentType Number:",
                                        fontSize = 10.5.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Text(
                                        text = currentNumber,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                FilledTonalButton(
                                    onClick = {
                                        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                        clipboard.setPrimaryClip(ClipData.newPlainText("Payment Number", currentNumber))
                                        Toast.makeText(context, "নম্বর কপি করা হয়েছে!", Toast.LENGTH_SHORT).show()
                                    },
                                    shape = RoundedCornerShape(6.dp),
                                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.ContentCopy,
                                        contentDescription = "Copy",
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text("কপি", fontSize = 12.sp)
                                }
                            }
                        }

                        Text(
                            text = "💡 উপরের নম্বরে ${selectedPackage.priceDisplay} Send Money করুন। সফল লেনদেনের পর TrxID নিচে লিখে জমা দিন।",
                            fontSize = 11.5.sp,
                            lineHeight = 16.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        OutlinedTextField(
                            value = transactionId,
                            onValueChange = {
                                transactionId = it
                                submissionError = null
                            },
                            label = { Text("Transaction ID (TrxID) *") },
                            placeholder = { Text("যেমন: 9J3K5L92P") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            trailingIcon = {
                                if (transactionId.trim().isNotBlank()) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                        )

                        if (submissionError != null) {
                            Text(
                                text = submissionError!!,
                                color = MaterialTheme.colorScheme.error,
                                fontSize = 11.5.sp,
                                lineHeight = 16.sp
                            )
                        }
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            if (transactionId.isNotBlank()) {
                                isSubmitting = true
                                submissionError = null
                                scope.launch {
                                    val res = userRepository.submitPaymentRequest(
                                        method = selectedMethod,
                                        transactionId = transactionId.trim(),
                                        amount = selectedPackage.price,
                                        packageType = selectedPackageId
                                    )
                                    isSubmitting = false
                                    if (res.isSuccess) {
                                        showPaymentCheckoutDialog = false
                                        paymentSuccessPackageTitle = selectedPackage.title
                                        Toast.makeText(context, "অনুরোধ সফলভাবে পাঠানো হয়েছে!", Toast.LENGTH_SHORT).show()
                                    } else {
                                        val err = res.exceptionOrNull()?.message ?: "পেমেন্ট অনুরোধ পাঠাতে ব্যর্থ হয়েছে। অনুগ্রহ করে ইন্টারনেট চেক করুন।"
                                        submissionError = err
                                        Toast.makeText(context, err, Toast.LENGTH_LONG).show()
                                    }
                                }
                            }
                        },
                        enabled = transactionId.trim().isNotBlank() && !isSubmitting,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        if (isSubmitting) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(16.dp),
                                color = MaterialTheme.colorScheme.onPrimary,
                                strokeWidth = 2.dp
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                        }
                        Text("পেমেন্ট জমা দিন", fontWeight = FontWeight.Bold)
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showPaymentCheckoutDialog = false },
                        enabled = !isSubmitting
                    ) {
                        Text("বাতিল")
                    }
                }
            )
        }

        // Payment Submission Success Dialog
        paymentSuccessPackageTitle?.let { title ->
            AlertDialog(
                onDismissRequest = { paymentSuccessPackageTitle = null },
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFF10B981))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("পেমেন্ট অনুরোধ গৃহীত হয়েছে!", fontWeight = FontWeight.Bold)
                    }
                },
                text = {
                    Text(
                        text = "🎉 ধন্যবাদ! '$title' এর পেমেন্ট অনুরোধ অ্যাডমিনের কাছে সফলভাবে জমা হয়েছে। অ্যাডমিন TrxID ভেরিফাই করার সাথে সাথেই কোর্সটি স্বয়ংক্রিয়ভাবে সক্রিয় হবে।",
                        fontSize = 13.5.sp,
                        lineHeight = 19.sp
                    )
                },
                confirmButton = {
                    Button(onClick = { paymentSuccessPackageTitle = null }) {
                        Text("ঠিক আছে")
                    }
                }
            )
        }

        // Set Wallet PIN Dialog
        if (showSetPinDialog) {
            AlertDialog(
                onDismissRequest = { showSetPinDialog = false },
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("৪-ডিজিটের ওয়ালেট পিন সেট করুন", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                },
                text = {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text(
                            text = "আপনার অর্জিত ব্যালেন্সের শতভাগ সুরক্ষায় একটি ৪-সংখ্যার গোপন পিন সেট করুন। অন্য কেউ ফোন হাতে পেলেও এই পিন ছাড়া কোনো ব্যালেন্স খরচ করতে পারবে না।",
                            fontSize = 12.sp,
                            lineHeight = 17.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        OutlinedTextField(
                            value = enteredPinText,
                            onValueChange = { if (it.length <= 4 && it.all { ch -> ch.isDigit() }) enteredPinText = it },
                            label = { Text("৪-ডিজিট নতুন পিন") },
                            placeholder = { Text("যেমন: 1234") },
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                        OutlinedTextField(
                            value = confirmPinText,
                            onValueChange = { if (it.length <= 4 && it.all { ch -> ch.isDigit() }) confirmPinText = it },
                            label = { Text("পিন পুনরায় নিশ্চিত করুন") },
                            placeholder = { Text("একই পিন আবার লিখুন") },
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                        if (pinDialogError != null) {
                            Text(text = pinDialogError!!, color = MaterialTheme.colorScheme.error, fontSize = 12.sp)
                        }
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            if (enteredPinText.length != 4) {
                                pinDialogError = "পিন অবশ্যই ৪ ডিজিটের হতে হবে"
                                return@Button
                            }
                            if (enteredPinText != confirmPinText) {
                                pinDialogError = "উভয় পিন মেলেনি! পুনরায় চেক করুন"
                                return@Button
                            }
                            scope.launch {
                                val res = userRepository.setWalletPin(enteredPinText)
                                if (res.isSuccess) {
                                    showSetPinDialog = false
                                    pinDialogError = null
                                    showEnterPinDialog = true
                                } else {
                                    pinDialogError = res.exceptionOrNull()?.message ?: "পিন সেভ করতে সমস্যা হয়েছে"
                                }
                            }
                        }
                    ) {
                        Text("পিন সংরক্ষণ করুন")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showSetPinDialog = false }) {
                        Text("বাতিল")
                    }
                }
            )
        }

        // Enter Wallet PIN & Confirm Gift Dialog
        if (showEnterPinDialog) {
            AlertDialog(
                onDismissRequest = { if (!isGiftPurchasing) showEnterPinDialog = false },
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Share, contentDescription = null, tint = Color(0xFF10B981))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("রেফার নিশ্চিতকরণ ও ওয়ালেট পিন", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                },
                text = {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text(
                            text = "প্যাকেজ: ${selectedPackage.title}\nমূল্য: ৳${selectedPackage.price.toInt()}\nপ্রাপক: ${recipientValidation?.name ?: recipientEmail}\nইমেইল: ${recipientValidation?.email ?: recipientEmail}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 18.sp
                        )
                        HorizontalDivider()
                        Text(
                            text = "বর্তমান ব্যালেন্স: ৳${"%.2f".format(userBalance)}\nক্রয়ের পর ব্যালেন্স: ৳${"%.2f".format(userBalance - selectedPackage.price)}",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        OutlinedTextField(
                            value = enteredPinText,
                            onValueChange = {
                                if (it.length <= 4 && it.all { ch -> ch.isDigit() }) {
                                    enteredPinText = it
                                    pinDialogError = null
                                }
                            },
                            label = { Text("৪-ডিজিটের ওয়ালেট পিন দিন") },
                            placeholder = { Text("••••") },
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                        if (pinDialogError != null) {
                            Text(text = pinDialogError!!, color = MaterialTheme.colorScheme.error, fontSize = 12.sp)
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            TextButton(
                                onClick = {
                                    showEnterPinDialog = false
                                    showResetPinDialog = true
                                    resetPhoneInput = ""
                                    resetNewPinInput = ""
                                    resetPinError = null
                                },
                                contentPadding = PaddingValues(0.dp)
                            ) {
                                Text(
                                    text = "পিন ভুলে গেছেন? রিসেট করুন",
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            if (enteredPinText.length != 4) {
                                pinDialogError = "৪ ডিজিটের ওয়ালেট পিন দিন"
                                return@Button
                            }
                            isGiftPurchasing = true
                            pinDialogError = null
                            scope.launch {
                                val res = userRepository.purchaseCourseForOtherUser(
                                    recipientEmail = recipientValidation?.email ?: recipientEmail,
                                    packageType = selectedPackage.id,
                                    amount = selectedPackage.price,
                                    enteredPin = enteredPinText
                                )
                                isGiftPurchasing = false
                                if (res.isSuccess) {
                                    val bonusEarned = res.getOrDefault(20.0)
                                    val giftedName = recipientValidation?.name ?: recipientEmail
                                    val giftedTitle = selectedPackage.title
                                    showEnterPinDialog = false
                                    enteredPinText = ""
                                    recipientEmail = ""
                                    recipientValidation = null
                                    giftSuccessDialogData = Triple(giftedName, giftedTitle, bonusEarned)
                                } else {
                                    pinDialogError = res.exceptionOrNull()?.message ?: "লেনদেন ব্যর্থ হয়েছে"
                                }
                            }
                        },
                        enabled = !isGiftPurchasing,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981))
                    ) {
                        if (isGiftPurchasing) {
                            CircularProgressIndicator(modifier = Modifier.size(16.dp), color = Color.White, strokeWidth = 2.dp)
                            Spacer(modifier = Modifier.width(6.dp))
                        }
                        Text("নিশ্চিত করুন ও রেফার করুন", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showEnterPinDialog = false },
                        enabled = !isGiftPurchasing
                    ) {
                        Text("বাতিল")
                    }
                }
            )
        }

        if (showResetPinDialog) {
            AlertDialog(
                onDismissRequest = { if (!isResettingPin) showResetPinDialog = false },
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = null, tint = Color(0xFFEF4444))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("ওয়ালেট পিন রিসেট করুন", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                },
                text = {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text(
                            text = "আপনার অ্যাকাউন্টে রেজিস্টার করা ফোন নম্বর দিয়ে পিন রিসেট করুন।",
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        OutlinedTextField(
                            value = resetPhoneInput,
                            onValueChange = {
                                resetPhoneInput = it
                                resetPinError = null
                            },
                            label = { Text("রেজিস্টার্ড ফোন নম্বর") },
                            placeholder = { Text("01XXXXXXXXX") },
                            leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                        OutlinedTextField(
                            value = resetNewPinInput,
                            onValueChange = {
                                if (it.length <= 4 && it.all { ch -> ch.isDigit() }) {
                                    resetNewPinInput = it
                                    resetPinError = null
                                }
                            },
                            label = { Text("নতুন ৪-ডিজিটের পিন") },
                            placeholder = { Text("••••") },
                            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                        if (resetPinError != null) {
                            Text(text = resetPinError!!, color = MaterialTheme.colorScheme.error, fontSize = 12.sp)
                        }
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            if (resetPhoneInput.trim().length < 10) {
                                resetPinError = "সঠিক ফোন নম্বর দিন"
                                return@Button
                            }
                            if (resetNewPinInput.trim().length != 4) {
                                resetPinError = "নতুন পিন অবশ্যই ৪ ডিজিট হতে হবে"
                                return@Button
                            }
                            isResettingPin = true
                            resetPinError = null
                            scope.launch {
                                val res = userRepository.resetWalletPin(resetPhoneInput, resetNewPinInput)
                                isResettingPin = false
                                if (res.isSuccess) {
                                    showResetPinDialog = false
                                    enteredPinText = resetNewPinInput
                                    showEnterPinDialog = true
                                    Toast.makeText(context, "ওয়ালেট পিন সফলভাবে রিসেট হয়েছে! 🎉", Toast.LENGTH_LONG).show()
                                } else {
                                    resetPinError = res.exceptionOrNull()?.message ?: "রিসেট করতে সমস্যা হয়েছে"
                                }
                            }
                        },
                        enabled = !isResettingPin,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF4444))
                    ) {
                        if (isResettingPin) {
                            CircularProgressIndicator(modifier = Modifier.size(16.dp), color = Color.White, strokeWidth = 2.dp)
                            Spacer(modifier = Modifier.width(6.dp))
                        }
                        Text("পিন রিসেট করুন", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showResetPinDialog = false },
                        enabled = !isResettingPin
                    ) {
                        Text("বাতিল")
                    }
                }
            )
        }

        // Gift Success Dialog
        giftSuccessDialogData?.let { (name, course, bonus) ->
            AlertDialog(
                onDismissRequest = { giftSuccessDialogData = null },
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFF10B981))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("কোর্স বিক্রি সফল হয়েছে!", fontWeight = FontWeight.Bold)
                    }
                },
                text = {
                    Text(
                        text = "🎉 অভিনন্দন! '$name' এর অ্যাকাউন্টে সফলভাবে '$course' অ্যাক্টিভ করা হয়েছে। আপনি ক্রেতার কাছ থেকে সরাসরি নগদ ক্যাশ টাকা পেয়ে গেলেন এবং আপনার ওয়ালেটেও সাথে সাথে আরও ৳${bonus.toInt()} সেলস বোনাস জমা হয়েছে!",
                        fontSize = 13.5.sp,
                        lineHeight = 19.sp
                    )
                },
                confirmButton = {
                    Button(onClick = { giftSuccessDialogData = null }) {
                        Text("ঠিক আছে")
                    }
                }
            )
        }

        if (showMyQrDialog) {
            UserQrCodeDialog(
                userName = userName,
                userEmail = userEmail,
                onDismiss = { showMyQrDialog = false }
            )
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
                            if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.22f) else MaterialTheme.colorScheme.primary.copy(alpha = 0.10f)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = pkg.flagEmoji,
                        fontSize = 22.sp
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
