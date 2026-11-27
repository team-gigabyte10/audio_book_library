package com.gigabyte.bookstore.presentation.auth

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar
import com.gigabyte.bookstore.presentation.components.AppBackground
import com.gigabyte.bookstore.ui.theme.GoldenAccent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    onRegistrationSuccess: () -> Unit,
    onNavigateToLogin: (() -> Unit)? = null,
    viewModel: RegisterViewModel = viewModel()
) {
    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var institute by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var referralCode by rememberSaveable { mutableStateOf("") }

    var isOptionalExpanded by rememberSaveable { mutableStateOf(false) }

    val uiState by viewModel.uiState.collectAsState()
    val focusManager = LocalFocusManager.current

    val trimmedEmail = email.trim()
    val isEmailValid = trimmedEmail.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(trimmedEmail).matches()
    val isEmailFormatError = trimmedEmail.isNotEmpty() && !isEmailValid
    val isFormValid = name.trim().isNotEmpty() && isEmailValid

    LaunchedEffect(uiState) {
        if (uiState is RegisterUiState.Success) {
            onRegistrationSuccess()
        }
    }

    fun submit() {
        if (!isFormValid || uiState is RegisterUiState.Loading) return
        focusManager.clearFocus()
        viewModel.register(
            name = name.trim(),
            email = email.trim(),
            institute = institute.takeIf { it.isNotBlank() },
            address = address.takeIf { it.isNotBlank() },
            phone = phone.takeIf { it.isNotBlank() },
            referralCodeInput = referralCode.takeIf { it.isNotBlank() }
        )
    }

    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = {
                    Text(
                        text = "অ্যাকাউন্ট তৈরি (Register)",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            )
        }
    ) { paddingValues ->
        AppBackground(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 1. VIBRANT GRADIENT HERO HEADER
                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .background(
                            Brush.linearGradient(
                                listOf(
                                    Color(0xFF00897B),
                                    Color(0xFF004D40)
                                )
                            )
                        )
                        .border(
                            width = 2.dp,
                            color = Color(0xFFFFD54F).copy(alpha = 0.6f),
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.AutoStories,
                        contentDescription = null,
                        tint = Color(0xFFFFE082),
                        modifier = Modifier.size(36.dp)
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = "বই ও ভাষা একাডেমি",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )

                Spacer(modifier = Modifier.height(4.dp))

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.10f),
                    border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.25f))
                ) {
                    Text(
                        text = "📚 Book & Language Academy",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // 7-DAY FREE TRIAL HERO BANNER
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                Brush.linearGradient(
                                    listOf(
                                        Color(0xFF00695C),
                                        Color(0xFF004D40)
                                    )
                                )
                            )
                            .padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(46.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFFFD54F)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.CardGiftcard,
                                    contentDescription = null,
                                    tint = Color(0xFF004D40),
                                    modifier = Modifier.size(26.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(14.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "🎁 ৭ দিনের ফ্রি ট্রায়াল চালু হবে!",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFFD54F)
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = "রেজিস্টার করলেই সব বইয়ের অডিও সারাংশ ও ১০টি ভাষা শিক্ষা উন্মুক্ত পাবেন সম্পূর্ণ ফ্রিতে।",
                                    fontSize = 12.sp,
                                    lineHeight = 17.sp,
                                    color = Color.White.copy(alpha = 0.95f)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TrialBadgePill(
                        text = "🎧 অডিও সারাংশ",
                        bgColor = Color(0xFFEDE7F6),
                        textColor = Color(0xFF5E35B1),
                        borderColor = Color(0xFFD1C4E9)
                    )
                    TrialBadgePill(
                        text = "🌍 ১০টি ভাষা",
                        bgColor = Color(0xFFE0F7FA),
                        textColor = Color(0xFF00796B),
                        borderColor = Color(0xFFB2DFDB)
                    )
                    TrialBadgePill(
                        text = "⚡ অফলাইন",
                        bgColor = Color(0xFFFFF8E1),
                        textColor = Color(0xFFD97706),
                        borderColor = Color(0xFFFFE082)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

            // 2. MANDATORY DETAILS CARD (NAME & EMAIL)
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(20.dp)
                    )
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFE0F2F1)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = Color(0xFF00695C),
                                modifier = Modifier.size(18.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "আবশ্যক তথ্য (Required)",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFFE8F5E9),
                            border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFA5D6A7))
                        ) {
                            Text(
                                text = "* আবশ্যক",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1B5E20),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Full Name (Mandatory)
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("পূর্ণ নাম (Full Name) *") },
                        placeholder = { Text("আপনার নাম লিখুন") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Person,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        },
                        trailingIcon = {
                            if (name.trim().isNotEmpty()) {
                                Icon(
                                    Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.Words,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // Email Address (Mandatory)
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("ইমেইল ঠিকানা (Email Address) *") },
                        placeholder = { Text("যেমন: nayem@example.com") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Email,
                                contentDescription = null,
                                tint = if (isEmailFormatError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                            )
                        },
                        trailingIcon = {
                            if (isEmailValid) {
                                Icon(
                                    Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        },
                        isError = isEmailFormatError,
                        supportingText = {
                            if (isEmailFormatError) {
                                Text(
                                    text = "সঠিক ইমেইল ঠিকানা দিন (যেমন: name@example.com)",
                                    color = MaterialTheme.colorScheme.error,
                                    fontSize = 11.sp
                                )
                            }
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = if (isOptionalExpanded) ImeAction.Next else ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) },
                            onDone = { submit() }
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 3. OPTIONAL DETAILS SECTION (EXPANDABLE / ACCORDION)
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(18.dp)
                    )
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { isOptionalExpanded = !isOptionalExpanded }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Tune,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "অতিরিক্ত তথ্য (ঐচ্ছিক / Optional)",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = if (isOptionalExpanded) "ট্যাপ করে গোপন করুন" else "ফোন, প্রতিষ্ঠান, ঠিকানা ও রেফার কোড যোগ করতে ট্যাপ করুন",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        IconButton(onClick = { isOptionalExpanded = !isOptionalExpanded }) {
                            Icon(
                                imageVector = if (isOptionalExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                contentDescription = if (isOptionalExpanded) "সংকোচন করুন" else "প্রসারিত করুন",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }

                    AnimatedVisibility(
                        visible = isOptionalExpanded,
                        enter = fadeIn() + expandVertically(),
                        exit = fadeOut() + shrinkVertically()
                    ) {
                        Column {
                            Spacer(modifier = Modifier.height(14.dp))
                            HorizontalDivider(
                                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
                            )
                            Spacer(modifier = Modifier.height(14.dp))

                            // Phone Number (Optional)
                            OutlinedTextField(
                                value = phone,
                                onValueChange = { phone = it },
                                label = { Text("মোবাইল নম্বর (Phone - ঐচ্ছিক)") },
                                placeholder = { Text("যেমন: 017xxxxxxxx") },
                                leadingIcon = {
                                    Icon(Icons.Default.Phone, contentDescription = null)
                                },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth(),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Phone,
                                    imeAction = ImeAction.Next
                                ),
                                keyboardActions = KeyboardActions(
                                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                                ),
                                shape = RoundedCornerShape(12.dp)
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            // Institute / Organization (Optional)
                            OutlinedTextField(
                                value = institute,
                                onValueChange = { institute = it },
                                label = { Text("প্রতিষ্ঠান বা পেশা (Institute - ঐচ্ছিক)") },
                                placeholder = { Text("যেমন: ঢাকা বিশ্ববিদ্যালয় / চাকুরিজীবী") },
                                leadingIcon = {
                                    Icon(Icons.Default.School, contentDescription = null)
                                },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth(),
                                keyboardOptions = KeyboardOptions(
                                    capitalization = KeyboardCapitalization.Words,
                                    imeAction = ImeAction.Next
                                ),
                                keyboardActions = KeyboardActions(
                                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                                ),
                                shape = RoundedCornerShape(12.dp)
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            // Address / City (Optional)
                            OutlinedTextField(
                                value = address,
                                onValueChange = { address = it },
                                label = { Text("ঠিকানা বা জেলা (Address - ঐচ্ছিক)") },
                                placeholder = { Text("যেমন: ধানমন্ডি, ঢাকা") },
                                leadingIcon = {
                                    Icon(Icons.Default.LocationOn, contentDescription = null)
                                },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth(),
                                keyboardOptions = KeyboardOptions(
                                    capitalization = KeyboardCapitalization.Words,
                                    imeAction = ImeAction.Next
                                ),
                                keyboardActions = KeyboardActions(
                                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                                ),
                                shape = RoundedCornerShape(12.dp)
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            // Referral Code Highlighted Card (Optional)
                            Surface(
                                shape = RoundedCornerShape(14.dp),
                                color = Color(0xFFFFFBEB),
                                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFFDE68A)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(12.dp)) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            Icons.Default.CardGiftcard,
                                            contentDescription = null,
                                            tint = Color(0xFFD97706),
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(
                                            text = "রেফার কোড বোনাস (ঐচ্ছিক)",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFFB45309)
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))
                                    OutlinedTextField(
                                        value = referralCode,
                                        onValueChange = { referralCode = it.uppercase() },
                                        placeholder = { Text("যেমন: SUMON1234") },
                                        singleLine = true,
                                        modifier = Modifier.fillMaxWidth(),
                                        colors = OutlinedTextFieldDefaults.colors(
                                            focusedContainerColor = Color.White,
                                            unfocusedContainerColor = Color.White
                                        ),
                                        keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.Text,
                                            imeAction = ImeAction.Done
                                        ),
                                        keyboardActions = KeyboardActions(onDone = { submit() }),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "বন্ধুর রেফার কোড থাকলে যুক্ত করুন এবং বোনাস উপভোগ করুন!",
                                        fontSize = 11.sp,
                                        color = Color(0xFFB45309)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Error display
            val error = uiState as? RegisterUiState.Error
            if (error != null) {
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.85f)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(14.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ErrorOutline,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.error,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = error.message,
                            color = MaterialTheme.colorScheme.onErrorContainer,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 4. SUBMIT / REGISTER BUTTON (PREMIUM REDESIGNED)
            val isRegisterEnabled = isFormValid && uiState !is RegisterUiState.Loading
            val registerGradient = if (isRegisterEnabled) {
                Brush.horizontalGradient(
                    listOf(
                        Color(0xFF00897B),
                        Color(0xFF00695C),
                        Color(0xFF004D40)
                    )
                )
            } else {
                Brush.horizontalGradient(
                    listOf(
                        Color(0xFF78909C).copy(alpha = 0.45f),
                        Color(0xFF546E7A).copy(alpha = 0.45f)
                    )
                )
            }

            Surface(
                onClick = { submit() },
                enabled = isRegisterEnabled,
                shape = RoundedCornerShape(16.dp),
                color = Color.Transparent,
                shadowElevation = if (isRegisterEnabled) 6.dp else 0.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 54.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(registerGradient)
                    .border(
                        width = 1.dp,
                        color = if (isRegisterEnabled) Color.White.copy(alpha = 0.35f) else Color.Transparent,
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 14.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (uiState is RegisterUiState.Loading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(22.dp),
                            color = Color.White,
                            strokeWidth = 2.5.dp
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "অ্যাকাউন্ট তৈরি হচ্ছে...",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    } else {
                        Surface(
                            shape = CircleShape,
                            color = if (isRegisterEnabled) Color.White.copy(alpha = 0.20f) else Color.White.copy(alpha = 0.10f),
                            modifier = Modifier.size(30.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = if (isRegisterEnabled) Color.White else Color.White.copy(alpha = 0.6f)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "অ্যাকাউন্ট তৈরি করুন (Register)",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isRegisterEnabled) Color.White else Color.White.copy(alpha = 0.65f),
                            letterSpacing = 0.3.sp
                        )
                        if (isRegisterEnabled) {
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp),
                                tint = Color.White.copy(alpha = 0.85f)
                            )
                        }
                    }
                }
            }

            if (!isFormValid) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "* নাম ও সঠিক ইমেইল ঠিকানা দিলেই বাটন চালু হবে",
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                )
            }

            // 5. LOGIN NAVIGATION FOOTER (MATCHING CARD BUTTON)
            if (onNavigateToLogin != null) {
                Spacer(modifier = Modifier.height(18.dp))
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)
                    ),
                    border = androidx.compose.foundation.BorderStroke(
                        1.dp,
                        MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .clickable { onNavigateToLogin() }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFF00695C).copy(alpha = 0.15f),
                            modifier = Modifier.size(32.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.Login,
                                    contentDescription = null,
                                    tint = Color(0xFF00695C),
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "আগে থেকেই অ্যাকাউন্ট আছে?",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = "এখানে ক্লিক করে লগইন করুন (Log In) →",
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF00695C)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
}

@Composable
private fun RowScope.TrialBadgePill(
    text: String,
    bgColor: Color,
    textColor: Color,
    borderColor: Color
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = bgColor,
        border = androidx.compose.foundation.BorderStroke(1.dp, borderColor),
        modifier = Modifier.weight(1f)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 11.5.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(vertical = 7.dp)
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}
