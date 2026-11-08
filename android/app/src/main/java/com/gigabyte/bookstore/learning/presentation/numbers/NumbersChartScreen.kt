package com.gigabyte.bookstore.learning.presentation.numbers

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumbersChartScreen(
    viewModel: NumbersChartViewModel,
    onBackClick: () -> Unit
) {
    val config = viewModel.config
    val accentColor = Color(config.accentColorHex)

    val selectedRangeId by viewModel.selectedRangeId.collectAsState()
    val speechRate by viewModel.speechRate.collectAsState()
    val filteredNumbers by viewModel.filteredNumbers.collectAsState()
    val selectedNumberForDetail by viewModel.selectedNumberForDetail.collectAsState()
    val isAutoPlaying by viewModel.isAutoPlaying.collectAsState()
    val isSpeaking by viewModel.audioPlayer.isSpeaking.collectAsState()
    val activeSpeakingId by viewModel.audioPlayer.activeSpeakingId.collectAsState()

    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = {
                    Column {
                        Text(
                            text = config.titleBn,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = config.subtitleBn,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White.copy(alpha = 0.88f),
                            fontSize = 11.5.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    if (isSpeaking || isAutoPlaying) {
                        IconButton(onClick = { viewModel.stopAudio() }) {
                            Icon(
                                imageVector = Icons.Default.Stop,
                                contentDescription = "Stop Audio",
                                tint = Color.White
                            )
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Speed & Auto-Play Quick Control Bar
            Surface(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 6.dp)
                ) {
                    // Play All / Stop All Action Button
                    Surface(
                        onClick = { viewModel.toggleAutoPlay(filteredNumbers) },
                        shape = RoundedCornerShape(8.dp),
                        color = if (isAutoPlaying) Color(0xFFC62828) else accentColor,
                        modifier = Modifier.padding(vertical = 2.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                        ) {
                            Icon(
                                imageVector = if (isAutoPlaying) Icons.Default.Stop else Icons.Default.PlayArrow,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(
                                text = if (isAutoPlaying) "থামান" else "ধারাবাহিক শুনুন",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }

                    // Speed Toggle
                    Surface(
                        onClick = { viewModel.toggleSpeechRate() },
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surface,
                        border = BorderStroke(1.dp, accentColor.copy(alpha = 0.45f))
                    ) {
                        Text(
                            text = if (speechRate <= 0.75f) "⚡ ০.৭x (ধীর)" else "⚡ ১.০x (স্বাভাবিক)",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = accentColor,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            // Range Category Tabs (1-20, 21-40, 41-60, etc.)
            ScrollableTabRow(
                selectedTabIndex = config.categories.indexOfFirst { it.id == selectedRangeId }.coerceAtLeast(0),
                edgePadding = 12.dp,
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = accentColor
            ) {
                config.categories.forEach { cat ->
                    val selected = cat.id == selectedRangeId
                    Tab(
                        selected = selected,
                        onClick = { viewModel.selectRange(cat.id) },
                        text = {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = cat.titleBn,
                                    fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                                    fontSize = 13.sp,
                                    color = if (selected) accentColor else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    text = cat.countLabel,
                                    fontSize = 10.5.sp,
                                    color = if (selected) accentColor.copy(alpha = 0.8f) else MaterialTheme.colorScheme.outline
                                )
                            }
                        }
                    )
                }
            }

            // Grid of 1-100 Number Cards
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 100.dp),
                contentPadding = PaddingValues(10.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                items(filteredNumbers, key = { it.number }) { item ->
                    val isCurrentlySpeaking = activeSpeakingId == item.number.toString()
                    NumberItemCard(
                        item = item,
                        accentColor = accentColor,
                        isSpeaking = isCurrentlySpeaking,
                        onClick = { viewModel.playNumber(item) }
                    )
                }
            }
        }
    }

    // Detail BottomSheet
    selectedNumberForDetail?.let { item ->
        val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        ModalBottomSheet(
            onDismissRequest = { viewModel.selectNumberForDetail(null) },
            sheetState = sheetState
        ) {
            NumberDetailSheetContent(
                item = item,
                accentColor = accentColor,
                onPlay = { viewModel.playNumber(item) },
                onDismiss = { viewModel.selectNumberForDetail(null) }
            )
        }
    }
}

@Composable
fun NumberItemCard(
    item: LanguageNumber,
    accentColor: Color,
    isSpeaking: Boolean,
    onClick: () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulseAlpha by infiniteTransition.animateFloat(
        initialValue = 0.15f,
        targetValue = 0.45f,
        animationSpec = infiniteRepeatable(
            animation = tween(450),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulseAlpha"
    )

    val cardBg by animateColorAsState(
        targetValue = if (isSpeaking) accentColor.copy(alpha = pulseAlpha) else MaterialTheme.colorScheme.surface,
        label = "cardBg"
    )
    val borderColor = if (isSpeaking) accentColor else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.45f)
    val borderWidth = if (isSpeaking) 2.dp else 1.dp

    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        color = cardBg,
        border = BorderStroke(borderWidth, borderColor),
        shadowElevation = if (isSpeaking) 4.dp else 1.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 8.dp)
        ) {
            // Header: Western Digit & Audio Indicator
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(accentColor.copy(alpha = 0.15f))
                ) {
                    Text(
                        text = item.digitDisplay,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = accentColor
                    )
                }

                Icon(
                    imageVector = Icons.Default.VolumeUp,
                    contentDescription = "Speak",
                    tint = if (isSpeaking) accentColor else MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
                    modifier = Modifier.size(16.dp)
                )
            }

            Spacer(Modifier.height(6.dp))

            // Highlighted Native Numeral (e.g. Japanese Kanji / Urdu / Hindi numeral)
            if (item.nativeNumeral != null && item.nativeNumeral != item.digitDisplay) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = accentColor.copy(alpha = if (isSpeaking) 0.22f else 0.10f),
                    modifier = Modifier.padding(vertical = 2.dp)
                ) {
                    Text(
                        text = item.nativeNumeral,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = accentColor,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 2.dp)
                    )
                }

                Spacer(Modifier.height(3.dp))

                // Native script word (e.g. Hiragana: いち, に, さん / Urdu: ایک)
                Text(
                    text = item.wordTarget,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = if (isSpeaking) accentColor else MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            } else {
                // For languages without separate native numeral (e.g. German)
                Text(
                    text = item.wordTarget,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 17.sp,
                    color = if (isSpeaking) accentColor else MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(Modifier.height(4.dp))

            // Bangla Pronunciation (Enlarged, Clear, English translation removed)
            Text(
                text = item.bnPron,
                fontSize = 12.5.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun NumberDetailSheetContent(
    item: LanguageNumber,
    accentColor: Color,
    onPlay: () -> Unit,
    onDismiss: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Text(
            text = "সংখ্যা ${item.digitDisplay} ${item.nativeNumeral?.let { "($it)" } ?: ""}",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.outline
        )

        Spacer(Modifier.height(10.dp))

        if (item.nativeNumeral != null && item.nativeNumeral != item.digitDisplay) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = accentColor.copy(alpha = 0.12f),
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    text = item.nativeNumeral,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = accentColor,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
                )
            }
            Spacer(Modifier.height(4.dp))
        }

        Text(
            text = item.wordTarget,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(Modifier.height(10.dp))

        Surface(
            shape = RoundedCornerShape(8.dp),
            color = accentColor.copy(alpha = 0.1f),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Text(
                text = "বাংলা উচ্চারণ: ${item.bnPron}",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = accentColor,
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
            )
        }

        Spacer(Modifier.height(20.dp))

        Surface(
            onClick = onPlay,
            shape = RoundedCornerShape(12.dp),
            color = accentColor,
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(vertical = 12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.VolumeUp,
                    contentDescription = null,
                    tint = Color.White
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = "উচ্চারণ শুনুন",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(Modifier.height(16.dp))
    }
}

