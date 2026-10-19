package com.gigabyte.bookstore.learning.presentation.intro

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.gigabyte.bookstore.presentation.components.AppBackground
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar
import com.gigabyte.bookstore.ui.theme.GoldenAccent
import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

private data class IntroParagraph(
    val rawText: String,
    val spokenText: String,
    val isHeader: Boolean = false,
    val isTable: Boolean = false
)

@Composable
fun CourseIntroScreen(
    assetFileName: String = "Intro.md",
    onBackClick: () -> Unit
) {
    val context = LocalContext.current
    val app = context.applicationContext as BanglaAudiobookApp
    val audio = app.lessonAudio
    val coroutineScope = rememberCoroutineScope()

    val isEnglishOnly = assetFileName.contains("self_presentation", ignoreCase = true)
    val targetLang = if (isEnglishOnly) SpeechLang.EN else SpeechLang.BN
    val baseRate = if (isEnglishOnly) 1.05f else 1.15f

    // Load and parse paragraphs
    val paragraphs = remember(assetFileName) {
        runCatching {
            context.assets.open(assetFileName).bufferedReader().use { it.readText() }
        }.getOrDefault("").lines()
            .map { it.trim() }
            .filter { it.isNotBlank() && !it.startsWith("---") }
            .map { line ->
                val isHeader = line.startsWith("#")
                val isTable = line.startsWith("|")
                val cleanSpoken = line
                    .replace(Regex("^#+\\s*"), "")
                    .replace(Regex("[*`_#|]"), "")
                    .replace(Regex("[-]{3,}"), "")
                    .replace("➔", "বা")
                    .trim()
                IntroParagraph(
                    rawText = line,
                    spokenText = cleanSpoken,
                    isHeader = isHeader,
                    isTable = isTable
                )
            }
            .filter { it.spokenText.isNotBlank() }
    }

    var isPlaying by remember { mutableStateOf(false) }
    var currentIndex by remember { mutableIntStateOf(-1) }
    var speedMultiplier by remember { mutableFloatStateOf(1.0f) }
    var playbackJob by remember { mutableStateOf<Job?>(null) }

    val listState = rememberLazyListState()

    // Stop playback on screen exit
    DisposableEffect(Unit) {
        onDispose {
            playbackJob?.cancel()
            audio.stop()
        }
    }

    fun stopAudio() {
        playbackJob?.cancel()
        playbackJob = null
        audio.stop()
        isPlaying = false
        currentIndex = -1
    }

    fun playFromIndex(startIndex: Int) {
        if (paragraphs.isEmpty()) return
        playbackJob?.cancel()
        isPlaying = true

        playbackJob = coroutineScope.launch {
            var idx = startIndex.coerceIn(0, paragraphs.lastIndex)
            while (isActive && idx < paragraphs.size) {
                currentIndex = idx
                // Auto scroll into view
                launch {
                    runCatching { listState.animateScrollToItem(idx) }
                }
                val p = paragraphs[idx]
                if (p.spokenText.isNotBlank()) {
                    val actualRate = (baseRate * speedMultiplier).coerceIn(0.7f, 2.0f)
                    audio.speak(p.spokenText, targetLang, actualRate)
                }
                idx++
            }
            isPlaying = false
            currentIndex = -1
        }
    }

    fun togglePlayPause() {
        if (isPlaying) {
            playbackJob?.cancel()
            playbackJob = null
            audio.stop()
            isPlaying = false
        } else {
            val start = if (currentIndex >= 0) currentIndex else 0
            playFromIndex(start)
        }
    }

    val pageTitle = if (isEnglishOnly) "সেলফ প্রেজেন্টেশন (English Only)" else "📖 কোর্স পরিচিতি ও গাইডলাইন"
    val pageSubtitle = if (isEnglishOnly) "Complete English Self Presentation" else "ভয়েস রিডিংসহ পূর্ণাঙ্গ অডিও গাইড"

    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = {
                    Column {
                        Text(pageTitle, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                        Text(pageSubtitle, style = MaterialTheme.typography.bodySmall)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {
                        stopAudio()
                        onBackClick()
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "ফিরে যান")
                    }
                }
            )
        },
        bottomBar = {
            // Floating Audio Controller Bar
            Surface(
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = 8.dp,
                shadowElevation = 8.dp,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Current status info
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                                contentDescription = null,
                                tint = if (isPlaying) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(
                                text = if (isPlaying && currentIndex >= 0) "প্যারাগ্রাফ ${currentIndex + 1} / ${paragraphs.size}" else if (isPlaying) "পড়ছে..." else "অডিও শুনুন",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        // Speed selector
                        Surface(
                            onClick = {
                                speedMultiplier = when (speedMultiplier) {
                                    1.0f -> 1.25f
                                    1.25f -> 1.5f
                                    else -> 1.0f
                                }
                                if (isPlaying) {
                                    playFromIndex(currentIndex.coerceAtLeast(0))
                                }
                            },
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.6f),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.4f))
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Icon(Icons.Default.Speed, contentDescription = null, modifier = Modifier.size(14.dp))
                                Spacer(Modifier.width(4.dp))
                                Text(
                                    text = "${speedMultiplier}x",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSecondaryContainer
                                )
                            }
                        }
                    }

                    Spacer(Modifier.height(8.dp))

                    // Player Controls Row
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Previous Paragraph
                        IconButton(
                            onClick = {
                                val prev = (currentIndex - 1).coerceAtLeast(0)
                                playFromIndex(prev)
                            },
                            enabled = paragraphs.isNotEmpty() && currentIndex > 0
                        ) {
                            Icon(Icons.Default.SkipPrevious, contentDescription = "পূর্ববর্তী")
                        }

                        Spacer(Modifier.width(16.dp))

                        // Play / Pause FAB
                        Surface(
                            onClick = { togglePlayPause() },
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(54.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                                    contentDescription = if (isPlaying) "থামান" else "চালান",
                                    tint = MaterialTheme.colorScheme.onPrimary,
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                        }

                        Spacer(Modifier.width(16.dp))

                        // Next Paragraph
                        IconButton(
                            onClick = {
                                val next = (currentIndex + 1).coerceAtMost(paragraphs.lastIndex)
                                playFromIndex(next)
                            },
                            enabled = paragraphs.isNotEmpty() && currentIndex < paragraphs.lastIndex
                        ) {
                            Icon(Icons.Default.SkipNext, contentDescription = "পরবর্তী")
                        }

                        Spacer(Modifier.width(12.dp))

                        // Stop Button
                        if (isPlaying) {
                            IconButton(onClick = { stopAudio() }) {
                                Icon(Icons.Default.Stop, contentDescription = "বন্ধ করুন", tint = MaterialTheme.colorScheme.error)
                            }
                        }
                    }
                }
            }
        }
    ) { padding ->
        AppBackground(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(paragraphs) { index, paragraph ->
                    val isCurrent = index == currentIndex

                    ParagraphCard(
                        paragraph = paragraph,
                        isCurrent = isCurrent,
                        isEnglishOnly = isEnglishOnly,
                        onClick = { playFromIndex(index) }
                    )
                }

                item {
                    Spacer(Modifier.height(80.dp))
                }
            }
        }
    }
}

@Composable
private fun ParagraphCard(
    paragraph: IntroParagraph,
    isCurrent: Boolean,
    isEnglishOnly: Boolean,
    onClick: () -> Unit
) {
    val borderColor = if (isCurrent) MaterialTheme.colorScheme.primary else Color.Transparent
    val containerColor = when {
        isCurrent -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
        paragraph.isHeader -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
        paragraph.isTable -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)
        else -> MaterialTheme.colorScheme.surface
    }

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        border = BorderStroke(if (isCurrent) 2.dp else 1.dp, if (isCurrent) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f)),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isCurrent) 4.dp else 1.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Box(modifier = Modifier.padding(14.dp)) {
            val text = paragraph.rawText
                .replace(Regex("^#+\\s*"), "")
                .replace("**", "")

            when {
                paragraph.isHeader -> {
                    Text(
                        text = text,
                        fontSize = if (paragraph.rawText.startsWith("## ")) 18.sp else 20.sp,
                        lineHeight = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isCurrent) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                    )
                }
                isEnglishOnly -> {
                    Text(
                        text = text,
                        fontSize = 19.sp,
                        lineHeight = 28.sp,
                        fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Medium,
                        color = if (isCurrent) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                    )
                }
                else -> {
                    Text(
                        text = text,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = if (isCurrent) FontWeight.SemiBold else FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}
