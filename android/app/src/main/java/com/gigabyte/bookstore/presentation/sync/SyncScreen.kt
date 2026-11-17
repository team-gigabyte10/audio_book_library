package com.gigabyte.bookstore.presentation.sync

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.CloudDownload
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gigabyte.bookstore.R
import com.gigabyte.bookstore.ui.theme.GoldenAccent

@Composable
fun SyncScreen(
    onNavigateToRegister: () -> Unit,
    onNavigateToLibrary: () -> Unit,
    viewModel: SyncViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(state) {
        when (state) {
            is InitialSyncState.NeedRegistration -> onNavigateToRegister()
            is InitialSyncState.Ready -> onNavigateToLibrary()
            else -> {}
        }
    }

    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val scale by infiniteTransition.animateFloat(
        initialValue = 0.95f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = EaseInOutCubic),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Full screen Splash Hero Background
        Image(
            painter = painterResource(id = R.drawable.splash_branding_hero),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Dark multi-stop gradient scrim for guaranteed crystal-clear text readability
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF040A0D).copy(alpha = 0.52f),
                            Color(0xFF020608).copy(alpha = 0.78f),
                            Color(0xFF010405).copy(alpha = 0.94f)
                        )
                    )
                )
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            // Animated Brand Hero Badge
            Box(
                modifier = Modifier
                    .size(112.dp)
                    .scale(scale)
                    .clip(RoundedCornerShape(28.dp))
                    .border(2.dp, GoldenAccent.copy(alpha = 0.7f), RoundedCornerShape(28.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.splash_branding_hero),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // App Name (Official stringResource)
            Text(
                text = stringResource(R.string.app_name),
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "অডিওবুক • ১০+ ভাষা শিক্ষা • কুরআন একাডেমি",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = GoldenAccent,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(28.dp))

            when (val s = state) {
                is InitialSyncState.CheckingAuth -> {
                    Text(
                        text = "ডিভাইস ও অ্যাকাউন্ট যাচাই করা হচ্ছে...",
                        fontSize = 14.sp,
                        color = Color(0xFFE2E8F0)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CircularProgressIndicator(
                        modifier = Modifier.size(36.dp),
                        color = GoldenAccent,
                        strokeWidth = 3.dp
                    )
                }

                is InitialSyncState.SyncingFiles -> {
                    Text(
                        text = "কন্টেন্ট প্রস্তুত হচ্ছে (${s.status.replaceFirstChar { it.uppercase() }})",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = GoldenAccent
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "অফলাইন কনটেন্ট মেমরি থেকে দ্রুত লোড হচ্ছে...",
                        fontSize = 12.sp,
                        color = Color(0xFFCBD5E1),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // Progress Bar
                    LinearProgressIndicator(
                        progress = { s.percentage / 100f },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        trackColor = Color.White.copy(alpha = 0.15f),
                        color = GoldenAccent
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${s.completed} / ${s.total} ফাইল",
                            fontSize = 12.sp,
                            color = Color(0xFFCBD5E1)
                        )
                        Text(
                            text = "${s.percentage}%",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = GoldenAccent
                        )
                    }

                    if (s.currentFileName.isNotBlank()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "লোড হচ্ছে: ${s.currentFileName}",
                            fontSize = 11.sp,
                            color = Color(0xFF94A3B8),
                            maxLines = 1
                        )
                    }
                }

                is InitialSyncState.DeviceMismatch -> {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.errorContainer
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.error,
                                modifier = Modifier.size(32.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "অ্যাকাউন্টটি অন্য ফোনে চালু আছে",
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onErrorContainer
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "একটি অ্যাকাউন্ট একটি ফোনেই ব্যবহার করা যায়। অন্য অ্যাকাউন্ট দিয়ে লগইন করুন, " +
                                    "অথবা ফোন পরিবর্তনের জন্য আমাদের সাথে যোগাযোগ করুন। (This account is active on another phone.)",
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colorScheme.onErrorContainer
                            )
                            Spacer(modifier = Modifier.height(14.dp))
                            Button(
                                onClick = onNavigateToRegister, // routed to the Login screen in AppNavHost
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.error
                                )
                            ) {
                                Text("লগইন পেজে যান (Go to Login)")
                            }
                        }
                    }
                }

                is InitialSyncState.Error -> {
                    Text(
                        text = s.message,
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 13.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { viewModel.startSyncWorkflow() }) {
                        Text("Retry")
                    }
                }

                else -> {}
            }
        }
    }
}
