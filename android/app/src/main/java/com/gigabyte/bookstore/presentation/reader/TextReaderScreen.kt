package com.gigabyte.bookstore.presentation.reader

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.presentation.components.MiniPlayerBar
import com.gigabyte.bookstore.presentation.components.VoiceSelectionSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextReaderScreen(
    viewModel: TextReaderViewModel,
    onBackClick: () -> Unit,
    onOpenPlayer: () -> Unit
) {
    val book by viewModel.book.collectAsStateWithLifecycle()
    val chapters by viewModel.chapters.collectAsStateWithLifecycle()
    val chapterChunksMap by viewModel.chapterChunksMap.collectAsStateWithLifecycle()
    val playbackState by viewModel.playbackState.collectAsStateWithLifecycle()
    val fontSize by viewModel.fontSize.collectAsStateWithLifecycle()
    val allVoices by viewModel.allVoices.collectAsStateWithLifecycle()
    val currentVoice by viewModel.currentVoice.collectAsStateWithLifecycle()
    val isSamplePlaying by viewModel.isSamplePlaying.collectAsStateWithLifecycle()


    val listState = rememberLazyListState()
    val isBookPlaying = playbackState.isPlaying && playbackState.bookId == book?.id

    // Auto-scroll to active speaking sentence chunk across all lessons/chapters on the single page
    LaunchedEffect(playbackState.chapterIndex, playbackState.chunkIndex, playbackState.isPlaying) {
        if (isBookPlaying && chapters.isNotEmpty()) {
            var targetIndex = 0
            val currentChap = playbackState.chapterIndex.coerceIn(0, chapters.size - 1)
            for (c in 0 until currentChap) {
                val chunks = chapterChunksMap[c] ?: viewModel.getChunksForPage(c)
                targetIndex += 1 + chunks.size // 1 for header + N chunks
            }
            targetIndex += 1 + playbackState.chunkIndex.coerceAtLeast(0) // +1 for current chapter header
            if (targetIndex >= 0) {
                listState.animateScrollToItem(targetIndex)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = book?.title ?: "পাঠ মোড",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "${chapters.size} টি পাঠ • এক পাতা রিডার",
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.testTag("reader_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ফিরে যান"
                        )
                    }
                },
                actions = {
                    // Voice Play / Pause Control Button
                    FilledTonalIconButton(
                        onClick = {
                            if (isBookPlaying) {
                                viewModel.player.pause()
                            } else {
                                val targetChap = playbackState.chapterIndex.coerceAtLeast(0)
                                val targetChunk = playbackState.chunkIndex.coerceAtLeast(0)
                                viewModel.speakFromChunk(targetChap, targetChunk)
                            }
                        },
                        modifier = Modifier.testTag("reader_voice_play_button")
                    ) {
                        Icon(
                            imageVector = if (isBookPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                            contentDescription = if (isBookPlaying) "অডিও থামান" else "অডিও চালান",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }


                    // Font Size Minus / Plus
                    IconButton(
                        onClick = { viewModel.decreaseFontSize() },
                        modifier = Modifier.testTag("reader_font_decrease")
                    ) {
                        Text("A-", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    }
                    IconButton(
                        onClick = { viewModel.increaseFontSize() },
                        modifier = Modifier.testTag("reader_font_increase")
                    ) {
                        Text("A+", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }

                    // Open Full Audio Player
                    IconButton(
                        onClick = onOpenPlayer,
                        modifier = Modifier.testTag("reader_open_player_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Headphones,
                            contentDescription = "অডিও প্লেয়ার"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            MiniPlayerBar(
                playbackState = playbackState,
                onBarClick = onOpenPlayer,
                onPlayPauseClick = { viewModel.player.togglePlayPause() },
                onNextClick = { viewModel.player.nextChapter() },
                onCloseClick = { viewModel.closePlayer() }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Active Voice Header Bar
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "একক পৃষ্ঠায় সব পাঠ ও বই • যেকোনো বাক্য বা প্লে আইকনে ট্যাপ করে শুনুন",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 11.sp
                        ),
                        modifier = Modifier.weight(1f)
                    )

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f),
                        modifier = Modifier.testTag("reader_voice_badge")
                    ) {
                        Text(
                            text = currentVoice.nameBangla.substringBefore("(").trim(),
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                fontSize = 10.sp
                            ),
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }

            // Continuous Single Page LazyColumn for ALL Chapters and Text
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .testTag("reader_single_page_column"),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = if (playbackState.bookId.isNotBlank()) 96.dp else 24.dp
                ),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                chapters.forEachIndexed { chapIdx, chapter ->
                    val chunks = chapterChunksMap[chapIdx] ?: viewModel.getChunksForPage(chapIdx)
                    val isThisChapPlaying = isBookPlaying && playbackState.chapterIndex == chapIdx

                    // 1. Chapter Header Card with Voice Play Icon
                    item(key = "chap_header_$chapIdx") {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = if (chapIdx > 0) 16.dp else 0.dp, bottom = 8.dp),
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isThisChapPlaying) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                                else MaterialTheme.colorScheme.surfaceContainerLow
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(14.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = "অধ্যায় ${chapIdx + 1}",
                                        style = MaterialTheme.typography.labelMedium.copy(
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = chapter.title,
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 17.sp
                                        )
                                    )
                                }

                                // Voice Play Icon Button for this Lesson/Chapter
                                FilledTonalIconButton(
                                    onClick = {
                                        if (isThisChapPlaying) {
                                            viewModel.player.togglePlayPause()
                                        } else {
                                            viewModel.speakFromChunk(chapIdx, 0)
                                        }
                                    },
                                    modifier = Modifier.testTag("play_chapter_voice_$chapIdx")
                                ) {
                                    Icon(
                                        imageVector = if (isThisChapPlaying) Icons.Default.VolumeUp else Icons.Default.PlayArrow,
                                        contentDescription = "অধ্যায় অডিও শুনুন",
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                        }
                    }

                    // 2. Chunks for this Lesson
                    items(
                        count = chunks.size,
                        key = { chunkIdx -> "chap_${chapIdx}_chunk_$chunkIdx" }
                    ) { chunkIdx ->
                        val chunk = chunks[chunkIdx]
                        val isSpokenNow = isThisChapPlaying && playbackState.chunkIndex == chunkIdx

                        val backgroundColor by animateColorAsState(
                            targetValue = when {
                                isSpokenNow -> MaterialTheme.colorScheme.primaryContainer
                                else -> Color.Transparent
                            },
                            label = "chunk_highlight_color"
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(backgroundColor)
                                .clickable { viewModel.speakFromChunk(chapIdx, chunkIdx) }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                                .testTag("reader_page_${chapIdx}_sentence_$chunkIdx")
                        ) {
                            Text(
                                text = chunk.text,
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontSize = fontSize.sp,
                                    lineHeight = (fontSize * 1.6).sp,
                                    fontWeight = if (isSpokenNow) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isSpokenNow) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                                )
                            )
                        }
                    }
                }
            }
        }

    }
}
