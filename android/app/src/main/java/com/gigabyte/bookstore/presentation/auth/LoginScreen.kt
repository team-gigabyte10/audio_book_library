package com.gigabyte.bookstore.presentation.auth

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar
import com.gigabyte.bookstore.presentation.components.AppBackground
import com.gigabyte.bookstore.ui.theme.GoldenAccent

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onNavigateToRegister: () -> Unit,
    viewModel: LoginViewModel = viewModel()
) {
    var email by rememberSaveable { mutableStateOf(viewModel.lastEmail) }
    val uiState by viewModel.uiState.collectAsState()
    val focusManager = LocalFocusManager.current

    var showForgotEmailDialog by remember { mutableStateOf(false) }
    var forgotPhoneInput by remember { mutableStateOf("") }
    var isSearchingEmail by remember { mutableStateOf(false) }
    var forgotEmailResult by remember { mutableStateOf<String?>(null) }
    var forgotPhoneError by remember { mutableStateOf<String?>(null) }

    val trimmedEmail = email.trim()
    val isEmailValid = trimmedEmail.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(trimmedEmail).matches()
    val isEmailFormatError = trimmedEmail.isNotEmpty() && !isEmailValid

    LaunchedEffect(uiState) {
        if (uiState is LoginUiState.Success) onLoginSuccess()
    }

    fun submit() {
        if (!isEmailValid || uiState is LoginUiState.Loading) return
        focusManager.clearFocus()
        viewModel.login(trimmedEmail)
    }

    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = {
                    Text(
                        text = "লগইন (Login)",
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

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "আপনার রেজিস্টার করা ইমেইল দিয়ে সহজে লগইন করুন। বইয়ের অডিও সারাংশ ও সকল ভাষা শিক্ষা চালু রাখুন!",
                    fontSize = 13.sp,
                    lineHeight = 19.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    LoginBadgePill(
                        text = "🎧 অডিও সারাংশ",
                        bgColor = Color(0xFFEDE7F6),
                        textColor = Color(0xFF5E35B1),
                        borderColor = Color(0xFFD1C4E9)
                    )
                    LoginBadgePill(
                        text = "🌍 ১০টি ভাষা",
                        bgColor = Color(0xFFE0F7FA),
                        textColor = Color(0xFF00796B),
                        borderColor = Color(0xFFB2DFDB)
                    )
                    LoginBadgePill(
                        text = "⚡ অফলাইন",
                        bgColor = Color(0xFFFFF8E1),
                        textColor = Color(0xFFD97706),
                        borderColor = Color(0xFFFFE082)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

            // 2. CREDENTIALS INPUT CARD
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
                                imageVector = Icons.Default.Lock,
                                contentDescription = null,
                                tint = Color(0xFF00695C),
                                modifier = Modifier.size(18.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "লগইন তথ্য (Account Credentials)",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    // Quick-fill chip if previous email is available and different
                    if (viewModel.lastEmail.isNotBlank() && email != viewModel.lastEmail) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f),
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .clickable { email = viewModel.lastEmail }
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.History,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(14.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "আগের অ্যাকাউন্ট: ${viewModel.lastEmail}",
                                    fontSize = 11.5.sp,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("ইমেইল ঠিকানা (Email Address)") },
                        placeholder = { Text("যেমন: name@example.com") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Email,
                                contentDescription = null,
                                tint = if (isEmailFormatError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                            )
                        },
                        trailingIcon = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                if (email.isNotEmpty()) {
                                    IconButton(
                                        onClick = { email = "" },
                                        modifier = Modifier.size(24.dp)
                                    ) {
                                        Icon(
                                            Icons.Default.Clear,
                                            contentDescription = "Clear email",
                                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                            modifier = Modifier.size(18.dp)
                                        )
                                    }
                                }
                                if (isEmailValid) {
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Icon(
                                        Icons.Default.CheckCircle,
                                        contentDescription = "Valid email",
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                }
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
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(onDone = { submit() }),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(
                            onClick = {
                                showForgotEmailDialog = true
                                forgotPhoneInput = ""
                                forgotEmailResult = null
                                forgotPhoneError = null
                            },
                            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 2.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                modifier = Modifier.size(15.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "ইমেইল ভুলে গেছেন? ফোন নম্বর দিয়ে খুঁজুন",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }

            // 3. ERROR / ALERT CARD
            val error = uiState as? LoginUiState.Error
            if (error != null) {
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (error.suggestRegister) {
                            Color(0xFFFFFBEB)
                        } else {
                            MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.85f)
                        }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = if (error.suggestRegister) Color(0xFFFBBF24) else MaterialTheme.colorScheme.error,
                            shape = RoundedCornerShape(14.dp)
                        )
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(verticalAlignment = Alignment.Top) {
                            Icon(
                                imageVector = if (error.suggestRegister) Icons.Default.PersonOff else Icons.Default.ErrorOutline,
                                contentDescription = null,
                                tint = if (error.suggestRegister) Color(0xFFB45309) else MaterialTheme.colorScheme.error,
                                modifier = Modifier
                                    .size(22.dp)
                                    .padding(top = 2.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = error.message,
                                color = if (error.suggestRegister) Color(0xFF78350F) else MaterialTheme.colorScheme.onErrorContainer,
                                fontSize = 13.sp,
                                lineHeight = 18.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        if (error.suggestRegister) {
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(
                                onClick = onNavigateToRegister,
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD97706)),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(40.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.PersonAdd,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = Color.White
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "এখনই নতুন অ্যাকাউন্ট খুলুন (Register Now)",
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 4. SUBMIT / LOGIN BUTTON (VIBRANT GRADIENT)
            Button(
                onClick = { submit() },
                enabled = isEmailValid && uiState !is LoginUiState.Loading,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    disabledContainerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
                ),
                contentPadding = PaddingValues(),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = if (isEmailValid) 4.dp else 0.dp)
            ) {
                val buttonBrush = if (isEmailValid && uiState !is LoginUiState.Loading) {
                    Brush.horizontalGradient(
                        listOf(
                            Color(0xFF00897B),
                            Color(0xFF004D40)
                        )
                    )
                } else {
                    Brush.horizontalGradient(
                        listOf(
                            Color(0xFFB0BEC5),
                            Color(0xFF90A4AE)
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(buttonBrush)
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    if (uiState is LoginUiState.Loading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(24.dp),
                            color = Color.White,
                            strokeWidth = 2.dp
                        )
                    } else {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Login,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp),
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "লগইন করুন (Login)",
                                fontSize = 15.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }

            if (!isEmailValid) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "* সঠিক ইমেইল ঠিকানা দিলেই লগইন বাটন চালু হবে",
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 5. REGISTRATION INVITATION CARD (COLORFUL PROMO)
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE0F2F1).copy(alpha = 0.45f)
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.2.dp,
                        color = Color(0xFF00796B).copy(alpha = 0.35f),
                        shape = RoundedCornerShape(18.dp)
                    )
            ) {
                Column(
                    modifier = Modifier.padding(18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF00695C)
                    ) {
                        Text(
                            text = "🎁 নতুন ব্যবহারকারী অফার",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "নতুন অ্যাকাউন্ট তৈরি করে ৭ দিনের ফ্রি ট্রায়াল নিন!",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "বইয়ের অডিও সারাংশ ও ১০টি ভাষা শিক্ষা উপভোগ করুন সম্পূর্ণ ফ্রিতে।",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    OutlinedButton(
                        onClick = onNavigateToRegister,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        border = androidx.compose.foundation.BorderStroke(
                            width = 1.5.dp,
                            color = Color(0xFF00695C)
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.PersonAdd,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                            tint = Color(0xFF00695C)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "নতুন অ্যাকাউন্ট তৈরি করুন (Register)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.5.sp,
                            color = Color(0xFF00695C)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }

    if (showForgotEmailDialog) {
        AlertDialog(
            onDismissRequest = { if (!isSearchingEmail) showForgotEmailDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.ContactPhone,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "ইমেইল অ্যাকাউন্ট খুঁজুন",
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "আপনার রেজিস্টার করা ফোন নম্বরটি লিখুন। আমরা অ্যাকাউন্টের সাথে যুক্ত ইমেইলটি খুঁজে দেব।",
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    OutlinedTextField(
                        value = forgotPhoneInput,
                        onValueChange = {
                            forgotPhoneInput = it
                            forgotPhoneError = null
                            forgotEmailResult = null
                        },
                        label = { Text("মোবাইল নম্বর (Phone Number)") },
                        placeholder = { Text("01XXXXXXXXX") },
                        leadingIcon = {
                            Icon(Icons.Default.Phone, contentDescription = null)
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    if (forgotPhoneError != null) {
                        Text(
                            text = forgotPhoneError!!,
                            color = MaterialTheme.colorScheme.error,
                            fontSize = 12.sp
                        )
                    }

                    if (forgotEmailResult != null) {
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFE8F5E9),
                            border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF81C784)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(
                                    text = "✅ আপনার অ্যাকাউন্টের ইমেইল পাওয়া গেছে:",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF2E7D32)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = forgotEmailResult!!,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFF1B5E20)
                                )
                            }
                        }
                    }
                }
            },
            confirmButton = {
                if (forgotEmailResult != null) {
                    Button(
                        onClick = {
                            email = forgotEmailResult!!
                            showForgotEmailDialog = false
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00897B))
                    ) {
                        Text("এই ইমেইল দিয়ে লগইন করুন", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                } else {
                    Button(
                        onClick = {
                            if (forgotPhoneInput.trim().length < 10) {
                                forgotPhoneError = "সঠিক ১১ ডিজিটের ফোন নম্বর দিন"
                                return@Button
                            }
                            isSearchingEmail = true
                            forgotPhoneError = null
                            viewModel.findEmailByPhone(forgotPhoneInput) { result ->
                                isSearchingEmail = false
                                if (result.isSuccess) {
                                    forgotEmailResult = result.getOrNull()
                                } else {
                                    forgotPhoneError = result.exceptionOrNull()?.message ?: "ইমেইল খুঁজে পাওয়া যায়নি"
                                }
                            }
                        },
                        enabled = !isSearchingEmail && forgotPhoneInput.trim().isNotBlank(),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                    ) {
                        if (isSearchingEmail) {
                            CircularProgressIndicator(modifier = Modifier.size(16.dp), color = Color.White, strokeWidth = 2.dp)
                            Spacer(modifier = Modifier.width(6.dp))
                        }
                        Text("ইমেইল খুঁজুন")
                    }
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showForgotEmailDialog = false },
                    enabled = !isSearchingEmail
                ) {
                    Text("বাতিল")
                }
            }
        )
    }
}
}

@Composable
private fun RowScope.LoginBadgePill(
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
