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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 1. BRANDED HERO WELCOME CARD
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary.copy(alpha = 0.9f),
                                Color(0xFF004D40)
                            )
                        ),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = GoldenAccent.copy(alpha = 0.35f),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(20.dp)
            ) {
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .size(46.dp)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.2f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.AutoStories,
                                contentDescription = null,
                                tint = GoldenAccent,
                                modifier = Modifier.size(26.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "বই ও ভাষা একাডেমি",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White
                            )
                            Text(
                                text = "Book & Language Academy",
                                fontSize = 12.sp,
                                color = GoldenAccent.copy(alpha = 0.95f),
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "আপনার রেজিস্টার করা ইমেইল দিয়ে সহজে লগইন করুন। বইয়ের অডিও সারাংশ ও সকল ভাষা শিক্ষা চালু রাখুন!",
                        fontSize = 13.sp,
                        lineHeight = 19.sp,
                        color = Color.White.copy(alpha = 0.92f)
                    )

                    Spacer(modifier = Modifier.height(14.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        LoginBadgePill(text = "🎧 অডিও সারাংশ")
                        LoginBadgePill(text = "🌍 ১০টি ভাষা")
                        LoginBadgePill(text = "⚡ অফলাইন")
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // 2. CREDENTIALS INPUT CARD
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.6f),
                        shape = RoundedCornerShape(18.dp)
                    )
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "লগইন তথ্য (Account Credentials)",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
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

            // 4. SUBMIT / LOGIN BUTTON
            Button(
                onClick = { submit() },
                enabled = isEmailValid && uiState !is LoginUiState.Loading,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 3.dp)
            ) {
                if (uiState is LoginUiState.Loading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = MaterialTheme.colorScheme.onPrimary,
                        strokeWidth = 2.dp
                    )
                } else {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Login,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "লগইন করুন (Login)",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
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

            // 5. REGISTRATION INVITATION CARD
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = if (error?.suggestRegister == true) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                        },
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Column(
                    modifier = Modifier.padding(18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "নতুন ব্যবহারকারী? (Don't have an account?)",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "নিবন্ধন করলেই পাবেন ৭ দিনের সম্পূর্ণ ফ্রি ট্রায়াল সুবিধা!",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    OutlinedButton(
                        onClick = onNavigateToRegister,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp),
                        border = androidx.compose.foundation.BorderStroke(
                            width = 1.5.dp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.PersonAdd,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "নতুন অ্যাকাউন্ট তৈরি করুন (Register)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.5.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun RowScope.LoginBadgePill(text: String) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color.White.copy(alpha = 0.15f),
        modifier = Modifier.weight(1f)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(vertical = 5.dp)
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}
