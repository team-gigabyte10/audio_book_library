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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.VolumeUp
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
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
    onBackClick: () -> Unit
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

    var showVoiceSheet by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
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
