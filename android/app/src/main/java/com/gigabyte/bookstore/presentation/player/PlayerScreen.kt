package com.gigabyte.bookstore.presentation.player

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Forward10
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.Replay10
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.RepeatOne
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.StopCircle
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.domain.player.SleepTimerOption
import com.gigabyte.bookstore.presentation.components.BookCoverView
import com.gigabyte.bookstore.presentation.components.SleepTimerDialog
import com.gigabyte.bookstore.presentation.components.VoiceSelectionSheet

private val AVAILABLE_SPEEDS = listOf(0.75f, 0.85f, 1.0f, 1.15f, 1.25f, 1.5f, 1.75f, 2.0f)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerScreen(
    viewModel: PlayerViewModel,
    onBackClick: () -> Unit,
    onOpenReader: (String, Int) -> Unit
) {
    val playbackState by viewModel.playbackState.collectAsStateWithLifecycle()
    val allVoices by viewModel.allVoices.collectAsStateWithLifecycle()
    val currentVoice by viewModel.currentVoice.collectAsStateWithLifecycle()
    val isSamplePlaying by viewModel.isSamplePlaying.collectAsStateWithLifecycle()

    val scrollState = rememberScrollState()

    var showSpeedMenu by remember { mutableStateOf(false) }
    var showSleepTimerDialog by remember { mutableStateOf(false) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "এখন বাজছে (Now Playing)",
                            style = MaterialTheme.typography.labelMedium.copy(
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = playbackState.bookTitle.ifBlank { "বাংলা অডিওবুক" },
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.testTag("player_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ফিরে যান"
                        )
                    }
                },
                actions = {


                    // Open Reader Screen
                    IconButton(
                        onClick = {
                            onOpenReader(playbackState.bookId, playbackState.chapterIndex)
                        },
                        modifier = Modifier.testTag("player_open_reader_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.MenuBook,
                            contentDescription = "টেক্সট পড়ুন"
                        )
                    }

                    // Close running audio player and exit
                    IconButton(
                        onClick = {
                            viewModel.closePlayer()
                            onBackClick()
                        },
                        modifier = Modifier.testTag("player_close_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "প্লেয়ার বন্ধ করুন",
                            tint = MaterialTheme.colorScheme.error
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
                .padding(horizontal = 24.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(4.dp))

            // 1. Large Cover Art
            BookCoverView(
                title = playbackState.bookTitle.ifBlank { "অডিওবুক" },
                author = playbackState.author,
                coverPath = playbackState.coverPath,
                modifier = Modifier.size(width = 190.dp, height = 240.dp),
                cornerRadius = 18.dp,
                elevation = 8.dp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 2. Book & Chapter Info
            Text(
                text = playbackState.chapterTitle.ifBlank { "অধ্যায়" },
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                ),
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            if (!playbackState.author.isNullOrBlank()) {
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = playbackState.author!!,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "অধ্যায় ${playbackState.chapterIndex + 1} / ${playbackState.totalChapters.coerceAtLeast(1)}",
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Text(
                    text = "•",
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )

                // Voice Chip Info Display
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f),
                    modifier = Modifier.testTag("player_voice_chip")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.RecordVoiceOver,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = currentVoice.nameBangla.substringBefore("(").trim(),
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // 3. Live Spoken Sentence Highlighting Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("player_highlight_card"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                ),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "লাইভ বাক্য (Live Speech)",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = "খণ্ড: ${playbackState.chunkIndex + 1}/${playbackState.totalChunks.coerceAtLeast(1)}",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    AnimatedContent(
                        targetState = playbackState.currentChunkText,
                        transitionSpec = { fadeIn() togetherWith fadeOut() },
                        label = "spoken_chunk_text"
                    ) { targetText ->
                        Text(
                            text = targetText.ifBlank { "অডিওবুক বাজানোর জন্য প্লে চাপুন..." },
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 16.sp,
                                lineHeight = 25.sp,
                                fontWeight = FontWeight.Medium,
                                color = if (targetText.isNotBlank()) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant
                            ),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // 4. Scrubber / Slider
            val maxChunks = (playbackState.totalChunks - 1).coerceAtLeast(0)
            val currentChunk = playbackState.chunkIndex.coerceIn(0, maxChunks)

            var sliderValue by remember(currentChunk) {
                mutableFloatStateOf(currentChunk.toFloat())
            }

            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                onValueChangeFinished = {
                    viewModel.seekToChunk(sliderValue.toInt())
                },
                valueRange = 0f..maxChunks.toFloat().coerceAtLeast(1f),
                steps = if (maxChunks > 1) maxChunks - 1 else 0,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("player_chunk_slider"),
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.primary,
                    activeTrackColor = MaterialTheme.colorScheme.primary,
                    inactiveTrackColor = MaterialTheme.colorScheme.surfaceVariant
                )
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "খণ্ড ${playbackState.chunkIndex + 1}",
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
                Text(
                    text = "মোট খণ্ড ${playbackState.totalChunks}",
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 5. Main Playback Controls
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Previous Chapter
                IconButton(
                    onClick = { viewModel.previousChapter() },
                    modifier = Modifier.testTag("player_prev_chapter_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.SkipPrevious,
                        contentDescription = "পূর্ববর্তী অধ্যায়",
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.size(30.dp)
                    )
                }

                // 10s Backward
                IconButton(
                    onClick = { viewModel.skipBackward10s() },
                    modifier = Modifier.testTag("player_skip_back_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.Replay10,
                        contentDescription = "১০ সেকেন্ড পেছনে",
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.size(30.dp)
                    )
                }

                // Play / Pause Primary Button
                FilledIconButton(
                    onClick = { viewModel.togglePlayPause() },
                    modifier = Modifier
                        .size(64.dp)
                        .testTag("player_play_pause_button"),
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Icon(
                        imageVector = if (playbackState.isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                        contentDescription = if (playbackState.isPlaying) "বিরতি" else "চালান",
                        modifier = Modifier.size(36.dp)
                    )
                }

                // 10s Forward
                IconButton(
                    onClick = { viewModel.skipForward10s() },
                    modifier = Modifier.testTag("player_skip_forward_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.Forward10,
                        contentDescription = "১০ সেকেন্ড সামনে",
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.size(30.dp)
                    )
                }

                // Next Chapter
                IconButton(
                    onClick = { viewModel.nextChapter() },
                    modifier = Modifier.testTag("player_next_chapter_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.SkipNext,
                        contentDescription = "পরবর্তী অধ্যায়",
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Speech Speed Selector
                Box {
                    TextButton(
                        onClick = { showSpeedMenu = true },
                        modifier = Modifier.testTag("player_speed_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Speed,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = "${playbackState.speed}x",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }

                    DropdownMenu(
                        expanded = showSpeedMenu,
                        onDismissRequest = { showSpeedMenu = false }
                    ) {
                        AVAILABLE_SPEEDS.forEach { speed ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = "${speed}x",
                                        fontWeight = if (speed == playbackState.speed) FontWeight.Bold else FontWeight.Normal
                                    )
                                },
                                onClick = {
                                    viewModel.setSpeechRate(speed)
                                    showSpeedMenu = false
                                }
                            )
                        }
                    }
                }

                // Mode Toggle (Full Audiobook vs Single Chapter)
                FilledTonalIconButton(
                    onClick = { viewModel.toggleFullAudiobookMode() },
                    modifier = Modifier.testTag("player_mode_toggle_button")
                ) {
                    Icon(
                        imageVector = if (playbackState.isFullAudiobookMode) Icons.Default.Repeat else Icons.Default.RepeatOne,
                        contentDescription = if (playbackState.isFullAudiobookMode) "সম্পূর্ণ অডিওবুক মোড" else "একক অধ্যায় মোড",
                        tint = if (playbackState.isFullAudiobookMode) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(18.dp)
                    )
                }

                // Sleep Timer Trigger
                TextButton(
                    onClick = { showSleepTimerDialog = true },
                    modifier = Modifier.testTag("player_sleep_timer_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.Bedtime,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        text = when (val remaining = playbackState.sleepTimerMinutesRemaining) {
                            null -> "স্লিপ"
                            -1 -> "অধ্যায়"
                            else -> "${remaining}মি"
                        },
                        fontWeight = if (playbackState.sleepTimerMinutesRemaining != null) FontWeight.Bold else FontWeight.Normal,
                        fontSize = 13.sp
                    )
                }

                // Restart Chapter
                FilledTonalIconButton(
                    onClick = { viewModel.restartChapter() },
                    modifier = Modifier.testTag("player_restart_chapter_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.Replay,
                        contentDescription = "অধ্যায় পুনরায় শুরু",
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Stop and Close Active Audio Session Button
            OutlinedButton(
                onClick = {
                    viewModel.closePlayer()
                    onBackClick()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("player_stop_and_close_button"),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colorScheme.error
                )
            ) {
                Icon(
                    imageVector = Icons.Default.StopCircle,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("প্লেয়ার ও অডিও বন্ধ করুন", fontWeight = FontWeight.SemiBold)
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        // Sleep Timer Dialog
        if (showSleepTimerDialog) {
            SleepTimerDialog(
                currentMinutesRemaining = playbackState.sleepTimerMinutesRemaining,
                onOptionSelected = { option ->
                    viewModel.setSleepTimer(option)
                },
                onDismiss = { showSleepTimerDialog = false }
            )
        }

    }
}
