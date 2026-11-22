package com.gigabyte.bookstore.presentation.drawer

import android.content.Intent
import android.net.Uri
import android.widget.Toast
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.gigabyte.bookstore.ui.theme.GoldenAccent
import kotlinx.coroutines.delay
import java.util.Calendar

@Composable
fun AboutUsDialog(
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current
    val currentYear = remember { Calendar.getInstance().get(Calendar.YEAR) }
    val supportEmail = "teamgigabyte10@gmail.com"

    var isEmailCopied by remember { mutableStateOf(false) }

    LaunchedEffect(isEmailCopied) {
        if (isEmailCopied) {
            delay(2000L)
            isEmailCopied = false
        }
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .padding(vertical = 16.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(22.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 1. BRANDED HERO HEADER
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
                            )
                        )
                        .padding(20.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                                .border(2.dp, GoldenAccent, CircleShape)
                                .background(Color.White.copy(alpha = 0.2f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.AutoStories,
                                contentDescription = null,
                                tint = GoldenAccent,
                                modifier = Modifier.size(32.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "বই ও ভাষা একাডেমি",
                            fontSize = 21.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )

                        Text(
                            text = "Book & Language Academy",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = GoldenAccent.copy(alpha = 0.95f)
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "জ্ঞান, সাহিত্য ও বহুভাষিক দক্ষতার ডিজিটাল প্ল্যাটফর্ম",
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            color = Color.White.copy(alpha = 0.9f)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color.White.copy(alpha = 0.16f),
                            modifier = Modifier.border(
                                width = 1.dp,
                                color = GoldenAccent.copy(alpha = 0.35f),
                                shape = RoundedCornerShape(8.dp)
                            )
                        ) {
                            Text(
                                text = "Version 1.2.0 • Release $currentYear",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }
                    }
                }

                // 2. CORE PILLARS & FEATURES
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 16.dp)
                ) {
                    Text(
                        text = "আমাদের মূল বিভাগসমূহ",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    AboutFeatureRow(
                        icon = Icons.Default.MenuBook,
                        iconTint = Color(0xFF1565C0),
                        title = "বাংলা অডিওবুক ও লাইব্রেরি",
                        description = "কালজয়ী সাহিত্য, আত্মউন্নয়ন ও শিক্ষণীয় বইয়ের বাংলা টেক্সট ও অডিও সারাংশ।"
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    AboutFeatureRow(
                        icon = Icons.Default.Language,
                        iconTint = Color(0xFF00897B),
                        title = "আন্তর্জাতিক স্পোকেন একাডেমি",
                        description = "ইংরেজি, জাপানিজ, উর্দু, হিন্দি, জার্মান, চাইনিজ, আরবি ও কোরিয়ান—৮টি ভাষার কোর্স।"
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    AboutFeatureRow(
                        icon = Icons.Default.Mosque,
                        iconTint = Color(0xFF2E7D32),
                        title = "নূরানী কুরআন ও তাজবীদ শিক্ষা",
                        description = "সহীহ হরফ, মাখরাজ, তাজবীদ নিয়মাবলি ও ছোট সূরা মশ্‌ক প্রশিক্ষণ।"
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    AboutFeatureRow(
                        icon = Icons.Default.RecordVoiceOver,
                        iconTint = Color(0xFFD97706),
                        title = "১০ অঞ্চলের কথ্য ভাষা ও অনুবাদক",
                        description = "চট্টগ্রাম, সিলেট, নোয়াখালী, ঢাকাইয়া ও কলকাতাসহ ১০ অঞ্চলের তুলনামূলক পাঠ ও লাইভ ডায়ালেক্ট ট্রান্সলেটর।"
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // Tech highlights card
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f)
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = "প্রযুক্তি ও বিশেষ সুবিধা:",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.5.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "• ১০০% অফলাইন স্মার্ট ক্যাশিং ও ডাটা সাশ্রয়ী প্লেব্যাক\n• ডুয়াল-স্পিড ভয়েস অডিও লেডার ও টোকেনাইজড লার্নিং\n• ডিভাইস-আইডি ও ক্লাউড সিঙ্ক সিকিউরিটি",
                                fontSize = 11.5.sp,
                                lineHeight = 17.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Support & Contact Card
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.25f),
                                shape = RoundedCornerShape(12.dp)
                            )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    clipboardManager.setText(AnnotatedString(supportEmail))
                                    isEmailCopied = true
                                    Toast.makeText(context, "ইমেইল কপি হয়েছে!", Toast.LENGTH_SHORT).show()
                                    try {
                                        val intent = Intent(Intent.ACTION_SENDTO).apply {
                                            data = Uri.parse("mailto:$supportEmail")
                                            putExtra(Intent.EXTRA_SUBJECT, "বই ও ভাষা একাডেমি অ্যাপ সাপোর্ট")
                                        }
                                        context.startActivity(intent)
                                    } catch (_: Exception) { }
                                }
                                .padding(12.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "যোগাযোগ ও সহায়তা (Support)",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    text = supportEmail,
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp)
                                ) {
                                    Icon(
                                        imageVector = if (isEmailCopied) Icons.Default.Check else Icons.Default.ContentCopy,
                                        contentDescription = "Copy email",
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(12.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = if (isEmailCopied) "কপি হয়েছে!" else "কপি",
                                        fontSize = 10.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Team Copyright
                    Text(
                        text = "টিম কপিরাইট: Team Gigabyte • $currentYear\nসর্বস্বত্ব সংরক্ষিত © $currentYear",
                        fontSize = 11.5.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 16.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Dismiss Button
                    Button(
                        onClick = onDismiss,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                    ) {
                        Text(
                            text = "ঠিক আছে (Close)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun AboutFeatureRow(
    icon: ImageVector,
    iconTint: Color,
    title: String,
    description: String
) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(iconTint.copy(alpha = 0.12f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconTint,
                modifier = Modifier.size(18.dp)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = description,
                fontSize = 11.5.sp,
                lineHeight = 16.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
