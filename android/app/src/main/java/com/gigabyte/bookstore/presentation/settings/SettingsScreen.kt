package com.gigabyte.bookstore.presentation.settings

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.BrightnessAuto
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.ui.draw.clip
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import com.gigabyte.bookstore.presentation.components.AppBackground
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.domain.tts.BanglaVoiceProfile
import com.gigabyte.bookstore.domain.tts.TTSVoiceStatus
import com.gigabyte.bookstore.presentation.components.TTSStatusBanner
import com.gigabyte.bookstore.presentation.components.VoiceItemCard
import com.gigabyte.bookstore.presentation.components.VoiceSelectionSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    onBackClick: () -> Unit,
    onAccountDeleted: () -> Unit = {}
) {
    val voiceStatus by viewModel.voiceStatus.collectAsStateWithLifecycle()
    val allVoices by viewModel.allVoices.collectAsStateWithLifecycle()
    val currentVoice by viewModel.currentVoice.collectAsStateWithLifecycle()
    val isSamplePlaying by viewModel.isSamplePlaying.collectAsStateWithLifecycle()
    val speechRate by viewModel.speechRate.collectAsStateWithLifecycle()
    val speechPitch by viewModel.speechPitch.collectAsStateWithLifecycle()
    val autoPlayNext by viewModel.autoPlayNext.collectAsStateWithLifecycle()
    val keepScreenAwake by viewModel.keepScreenAwake.collectAsStateWithLifecycle()
    val fullAudiobookMode by viewModel.fullAudiobookMode.collectAsStateWithLifecycle()
    val themeMode by viewModel.themeMode.collectAsStateWithLifecycle()
    val userEmail by viewModel.userEmail.collectAsStateWithLifecycle()

    var showVoiceSheet by remember { mutableStateOf(false) }
    var showDeleteAccountDialog by remember { mutableStateOf(false) }
    var isDeletingAccount by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = { Text("সেটিংস ও ভয়েস কনফিগারেশন") },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.testTag("settings_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ফিরে যান"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        AppBackground(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
            // 1. TTS Voice Engine Status Banner
            TTSStatusBanner(
                status = voiceStatus,
                onOpenSettings = { viewModel.openTtsSettings() },
                onTestVoice = { viewModel.testBanglaVoice() }
            )

            // 2. Multiple Clear Voices Selection Section
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerLow
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.RecordVoiceOver,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "একাধিক ক্লিয়ার ভয়েস",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                            )
                        }

                        FilledTonalButton(
                            onClick = { showVoiceSheet = true },
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                            modifier = Modifier.testTag("settings_view_all_voices_button")
                        ) {
                            Text("সকল ভয়েস দেখুন", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "বর্তমানে নির্বাচিত: ${currentVoice.nameBangla}",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold
                        )
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Show first 4 top presets directly in settings with quick select & listen
                    allVoices.take(4).forEach { voice ->
                        val isSelected = voice.id == currentVoice.id
                        VoiceItemCard(
                            voice = voice,
                            isSelected = isSelected,
                            isSamplePlaying = isSamplePlaying,
                            onSelect = { viewModel.selectVoiceProfile(voice) },
                            onTestSample = { viewModel.testVoiceSample(voice) },
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
            }

            // 3. Fine-tuning Rate & Pitch Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerLow
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Tune,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "গতি ও সুর ফাইন-টিউনিং",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Speech Rate Slider
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("কথা বলার গতি (Speech Rate)", style = MaterialTheme.typography.bodyMedium)
                        Text(
                            text = String.format("%.2fx", speechRate),
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                    Slider(
                        value = speechRate,
                        onValueChange = { viewModel.setSpeechRate(it) },
                        valueRange = 0.5f..2.0f,
                        steps = 5,
                        modifier = Modifier.testTag("settings_speech_rate_slider")
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Speech Pitch Slider
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("ভয়েসের সুর ও তীক্ষ্ণতা (Pitch)", style = MaterialTheme.typography.bodyMedium)
                        Text(
                            text = String.format("%.2fx", speechPitch),
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                    Slider(
                        value = speechPitch,
                        onValueChange = { viewModel.setSpeechPitch(it) },
                        valueRange = 0.7f..1.4f,
                        steps = 6,
                        modifier = Modifier.testTag("settings_speech_pitch_slider")
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedButton(
                            onClick = { viewModel.testBanglaVoice() },
                            modifier = Modifier
                                .weight(1f)
                                .testTag("settings_test_voice_button")
                        ) {
                            Icon(Icons.Default.VolumeUp, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("টেস্ট বাক্য")
                        }

                        OutlinedButton(
                            onClick = { viewModel.reloadTts() },
                            modifier = Modifier
                                .weight(1f)
                                .testTag("settings_reload_tts_button")
                        ) {
                            Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("রিলোড TTS")
                        }
                    }
                }
            }

            // 4. Playback Preferences Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerLow
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "প্লেব্যাক পছন্দসমূহ",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "পরবর্তী অধ্যায় স্বয়ংক্রিয়ভাবে শুরু",
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
                            )
                            Text(
                                text = "একটি অধ্যায় শেষ হলে পরেরটি বাজানো হবে",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        }
                        Switch(
                            checked = autoPlayNext,
                            onCheckedChange = { viewModel.setAutoPlayNext(it) },
                            modifier = Modifier.testTag("settings_autoplay_switch")
                        )
                    }

                    HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "সম্পূর্ণ অডিওবুক অবিরাম প্লেব্যাক মোড",
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
                            )
                            Text(
                                text = "পুরো বইটি একটানা অডিওবুক হিসেবে শুনুন",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        }
                        Switch(
                            checked = fullAudiobookMode,
                            onCheckedChange = { viewModel.setFullAudiobookMode(it) },
                            modifier = Modifier.testTag("settings_full_audiobook_switch")
                        )
                    }
                }
            }

            // 5. Theme & Display Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerLow
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Palette,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "থিম ও ডিসপ্লে (Theme)",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = "অ্যাপের জন্য আপনার পছন্দের মোড বেছে নিন",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        val themes = listOf(
                            Triple("system", "সিস্টেম", Icons.Default.BrightnessAuto),
                            Triple("light", "লাইট মোড", Icons.Default.LightMode),
                            Triple("dark", "ডার্ক মোড", Icons.Default.DarkMode)
                        )

                        themes.forEach { (mode, label, icon) ->
                            val isSelected = themeMode == mode
                            Surface(
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(12.dp))
                                    .clickable { viewModel.setThemeMode(mode) },
                                color = if (isSelected) MaterialTheme.colorScheme.primaryContainer
                                else MaterialTheme.colorScheme.surfaceContainerHighest.copy(alpha = 0.5f),
                                shape = RoundedCornerShape(12.dp),
                                border = if (isSelected) BorderStroke(
                                    1.5.dp,
                                    MaterialTheme.colorScheme.primary
                                ) else null
                            ) {
                                Column(
                                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 4.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = label,
                                        tint = if (isSelected) MaterialTheme.colorScheme.primary
                                        else MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(
                                        text = label,
                                        style = MaterialTheme.typography.labelMedium.copy(
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                            color = if (isSelected) MaterialTheme.colorScheme.primary
                                            else MaterialTheme.colorScheme.onSurfaceVariant,
                                            fontSize = 12.sp
                                        )
                                    )
                                }
                            }
                        }
                    }
                }

                // 6. Account Management & Deletion (Google Play Compliance)
                if (userEmail.isNotBlank()) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.error.copy(alpha = 0.3f)),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Security,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.error,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Column {
                                    Text(
                                        text = "অ্যাকাউন্ট ব্যবস্থাপনা (Account Data)",
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    Text(
                                        text = userEmail,
                                        style = MaterialTheme.typography.bodySmall.copy(
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(14.dp))
                            Text(
                                text = "গুগল প্লে স্টোর পলিসি অনুযায়ী আপনি যেকোনো সময় আপনার অ্যাকাউন্ট ও সমস্ত সংরক্ষিত ডেটা স্থায়ীভাবে মুছে ফেলতে পারেন।",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    lineHeight = 18.sp
                                )
                            )

                            Spacer(modifier = Modifier.height(14.dp))
                            OutlinedButton(
                                onClick = { showDeleteAccountDialog = true },
                                colors = ButtonDefaults.outlinedButtonColors(
                                    contentColor = MaterialTheme.colorScheme.error
                                ),
                                border = BorderStroke(1.dp, MaterialTheme.colorScheme.error.copy(alpha = 0.6f)),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Icon(
                                    imageVector = Icons.Default.DeleteForever,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.error,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "অ্যাকাউন্ট ডিলিট করুন (Delete Account)",
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }

        // Delete Account Confirmation Dialog
        if (showDeleteAccountDialog) {
            AlertDialog(
                onDismissRequest = { if (!isDeletingAccount) showDeleteAccountDialog = false },
                icon = {
                    Icon(
                        imageVector = Icons.Default.DeleteForever,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.error,
                        modifier = Modifier.size(32.dp)
                    )
                },
                title = {
                    Text(
                        text = "অ্যাকাউন্ট স্থায়ীভাবে ডিলিট করতে চান?",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                text = {
                    Text(
                        text = "আপনার অ্যাকাউন্ট ডিলিট করলে নাম, ইমেইল, ডিভাইস লাইসেন্স, বুকমার্ক ও সমস্ত শেখার অগ্রগতি স্থায়ীভাবে মুছে ফেলা হবে। এই কাজটি আর ফিরিয়ে আনা যাবে না। আপনি কি নিশ্চিত?",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                confirmButton = {
                    Button(
                        onClick = {
                            isDeletingAccount = true
                            viewModel.deleteAccount {
                                isDeletingAccount = false
                                showDeleteAccountDialog = false
                                onAccountDeleted()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error
                        ),
                        enabled = !isDeletingAccount
                    ) {
                        Text(if (isDeletingAccount) "ডিলিট হচ্ছে..." else "হ্যাঁ, ডিলিট করুন")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showDeleteAccountDialog = false },
                        enabled = !isDeletingAccount
                    ) {
                        Text("বাতিল (Cancel)")
                    }
                }
            )
        }

        // Full Voice Selection Sheet
        if (showVoiceSheet) {
            VoiceSelectionSheet(
                voices = allVoices,
                currentVoice = currentVoice,
                isSamplePlaying = isSamplePlaying,
                onVoiceSelected = { voice ->
                    viewModel.selectVoiceProfile(voice)
                },
                onTestSample = { voice ->
                    viewModel.testVoiceSample(voice)
                },
                onOpenTtsSettings = {
                    viewModel.openTtsSettings()
                },
                onDismiss = { showVoiceSheet = false }
            )
        }
    }
}
}
