package com.gigabyte.bookstore.learning.presentation.lesson

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AllInclusive
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.learning.domain.model.LearnSettings
import com.gigabyte.bookstore.learning.domain.model.LessonItem
import com.gigabyte.bookstore.learning.domain.model.PlaybackStep
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.gigabyte.bookstore.learning.domain.model.Token
import com.gigabyte.bookstore.presentation.components.AppBackground
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonScreen(
    viewModel: LessonViewModel,
    onBackClick: () -> Unit,
    onOpenQuiz: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val playerState by viewModel.playerState.collectAsStateWithLifecycle()
    val settings by viewModel.settings.collectAsStateWithLifecycle()
    val englishAvailable by viewModel.englishAvailable.collectAsStateWithLifecycle()
    val banglaAvailable by viewModel.banglaAvailable.collectAsStateWithLifecycle()
    var showSettings by remember { mutableStateOf(false) }

    // Keep the screen on while the lesson is playing.
    val view = LocalView.current
    DisposableEffect(playerState.isPlaying) {
        view.keepScreenOn = playerState.isPlaying
        onDispose { view.keepScreenOn = false }
    }

    val content = uiState.content
    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = {
                    Text(
                        content?.lesson?.let { it.titleBn ?: it.titleTarget } ?: "লেসন",
                        maxLines = 1
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "ফিরে যান")
                    }
                },
                actions = {
                    IconButton(onClick = { showSettings = true }) {
                        Icon(Icons.Default.Settings, contentDescription = "সেটিংস")
                    }
                }
            )
        }
    ) { padding ->
        AppBackground(modifier = Modifier.fillMaxSize().padding(padding)) {
            when {
                uiState.isLoading -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
                uiState.notFound || content == null -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("লেসনটি পাওয়া যায়নি।")
                }
                uiState.showIntro -> IntroPanel(
                    intro = content.lesson.introBn,
                    structure = content.structure,
                    onStart = viewModel::start
                )
                else -> Column(Modifier.fillMaxSize()) {
                    if (englishAvailable == false) {
                        VoiceWarning("ইংরেজি ভয়েস ইনস্টল করা নেই। ফোনের Text-to-speech সেটিংস থেকে English (US) ভয়েস ইনস্টল করুন।")
                    } else if (banglaAvailable == false && settings.bnAudio) {
                        VoiceWarning("বাংলা ভয়েস নেই, তাই বাংলা অর্থ শুধু লেখা হিসেবে দেখানো হবে।")
                    }

                    TabRow(selectedTabIndex = uiState.mode.ordinal) {
                        Tab(
                            selected = uiState.mode == LessonMode.LISTEN,
                            onClick = { viewModel.setMode(LessonMode.LISTEN) },
                            text = { Text("শুনুন ও বলুন") }
                        )
                        Tab(
                            selected = uiState.mode == LessonMode.SPEAK,
                            onClick = { viewModel.setMode(LessonMode.SPEAK) },
                            text = { Text("নিজে বলুন") }
                        )
                    }

                    val items = content.items
                    val index = playerState.itemIndex.coerceIn(0, items.lastIndex)
                    LinearProgressIndicator(
                        progress = { (index + 1).toFloat() / items.size },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Column(
                        Modifier
                            .weight(1f)
                            .verticalScroll(rememberScrollState())
                            .padding(16.dp)
                    ) {
                        var showGrammarRule by remember { mutableStateOf(false) }
                        if (!content.lesson.introBn.isNullOrBlank() || content.structure.isNotEmpty()) {
                            Surface(
                                onClick = { showGrammarRule = !showGrammarRule },
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f),
                                border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f)),
                                modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)
                            ) {
                                Column(Modifier.padding(12.dp)) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Info,
                                                contentDescription = null,
                                                tint = MaterialTheme.colorScheme.secondary,
                                                modifier = Modifier.size(18.dp)
                                            )
                                            Spacer(Modifier.width(8.dp))
                                            Text(
                                                "💡 নিয়ম ও বাক্য গঠন (Grammar & Rule)",
                                                style = MaterialTheme.typography.labelLarge,
                                                fontWeight = FontWeight.Bold,
                                                color = MaterialTheme.colorScheme.onSecondaryContainer
                                            )
                                        }
                                        Icon(
                                            imageVector = if (showGrammarRule) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                            contentDescription = null,
                                            tint = MaterialTheme.colorScheme.onSecondaryContainer
                                        )
                                    }
                                    if (showGrammarRule) {
                                        Spacer(Modifier.height(8.dp))
                                        if (!content.lesson.introBn.isNullOrBlank()) {
                                            Text(
                                                content.lesson.introBn,
                                                style = MaterialTheme.typography.bodyMedium,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                            Spacer(Modifier.height(6.dp))
                                        }
                                        content.structure.forEach { formula ->
                                            Surface(
                                                shape = androidx.compose.foundation.shape.RoundedCornerShape(6.dp),
                                                color = MaterialTheme.colorScheme.surface,
                                                modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
                                            ) {
                                                Text(
                                                    text = formula,
                                                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
                                                    color = MaterialTheme.colorScheme.primary,
                                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        Text(
                            "${index + 1} / ${items.size}",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(Modifier.height(8.dp))
                        val currentItem = items[index]
                        if (currentItem.speaker == "pair_practice") {
                            PairPracticeVoiceCard(
                                item = currentItem,
                                onSpeakQuestion = { viewModel.speakText(currentItem.target) },
                                onSpeakYes = { currentItem.exampleTarget?.let { viewModel.speakText(it) } },
                                onSpeakNo = { currentItem.exampleBn?.let { viewModel.speakText(it) } },
                                onSpeakText = { viewModel.speakText(it) },
                                onNext = viewModel::next,
                                hasNext = index < items.lastIndex,
                                onPauseAudio = viewModel::pause
                            )
                        } else if (uiState.mode == LessonMode.LISTEN) {
                            SpeakingPromptBanner(isPlaying = playerState.isPlaying)
                            Spacer(Modifier.height(10.dp))
                            ItemCard(
                                item = currentItem,
                                currentStep = playerState.currentStep,
                                revealTarget = true,
                                onSpeakToken = viewModel::speakToken,
                                onSpeakTarget = { viewModel.speakText(currentItem.target) },
                                onSpeakText = { viewModel.speakText(it) }
                            )
                        } else {
                            // "নিজে বলুন" tab: 10x Speed Drill Timer Challenge with English sentence & Bangla meaning
                            SpeedDrillChallengeCard(
                                item = currentItem,
                                onSpeakTarget = { viewModel.speakText(currentItem.target) },
                                onNextItem = viewModel::next,
                                hasNextItem = index < items.lastIndex,
                                onStartChallenge = viewModel::pause
                            )
                        }
                        if (currentItem.id.startsWith(JP_STANDARD_PREFIX)) {
                            Spacer(Modifier.height(10.dp))
                            JapaneseSpeechCheckCard(
                                item = currentItem,
                                onSpeakTarget = { viewModel.speakText(currentItem.target) },
                                onPauseAudio = viewModel::pause
                            )
                        }
                    }

                    if (playerState.isFinished || index == items.lastIndex) {
                        Button(
                            onClick = {
                                viewModel.onFinishedListening()
                                onOpenQuiz()
                            },
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                        ) {
                            Icon(Icons.Default.Quiz, contentDescription = null)
                            Text("  কুইজ দিন")
                        }
                    }

                    if (settings.repeatItem) {
                        Text(
                            "অবিরাম চালু: এই আইটেমটি বারবার চলবে। পরের আইটেমে যেতে ⏭ চাপুন।",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp)
                        )
                    }
                    PlayerControls(
                        isPlaying = playerState.isPlaying,
                        repeatItem = settings.repeatItem,
                        onToggleRepeat = viewModel::toggleRepeatItem,
                        onPrevious = viewModel::previous,
                        onTogglePlay = viewModel::togglePlayPause,
                        onNext = viewModel::next
                    )
                }
            }
        }
    }

    if (showSettings) {
        ModalBottomSheet(onDismissRequest = { showSettings = false }) {
            SettingsSheet(
                settings = settings,
                onBnAudio = viewModel::setBnAudio,
                onWordByWord = viewModel::setWordByWord,
                onAutoAdvance = viewModel::setAutoAdvance,
                onLoop = viewModel::setLoopLesson,
                onRepeatCount = viewModel::setRepeatCount
            )
        }
    }
}

@Composable
private fun IntroPanel(intro: String?, structure: List<String>, onStart: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("এই লেসনে যা শিখবেন", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        if (!intro.isNullOrBlank()) {
            Text(intro, style = MaterialTheme.typography.bodyLarge)
        }
        if (structure.isNotEmpty()) {
            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)) {
                Column(Modifier.padding(16.dp)) {
                    Text("গঠন (Structure)", style = MaterialTheme.typography.labelLarge)
                    structure.forEach { formula ->
                        Text(formula, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
        Button(onClick = onStart, modifier = Modifier.fillMaxWidth()) { Text("লেসন শুরু করুন") }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ItemCard(
    item: LessonItem,
    currentStep: PlaybackStep?,
    revealTarget: Boolean,
    onSpeakToken: (Token) -> Unit,
    onSpeakTarget: () -> Unit,
    onSpeakText: (String) -> Unit = {}
) {
    val speakingBn = (currentStep as? PlaybackStep.Speak)?.lang == SpeechLang.BN
    val speakingRate = (currentStep as? PlaybackStep.Speak)?.takeIf { it.lang == SpeechLang.EN || it.lang == SpeechLang.JA }?.rate

    Card(modifier = Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
        Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            item.speaker?.let {
                Text(it, style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.secondary)
            }
            if (revealTarget) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        item.target,
                        fontSize = 26.sp,
                        lineHeight = 34.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f).clickable(onClick = onSpeakTarget)
                    )
                    IconButton(onClick = onSpeakTarget) {
                        Icon(Icons.AutoMirrored.Filled.VolumeUp, contentDescription = "শুনুন")
                    }
                }
                speakingRate?.let {
                    Text("গতি: ${it}x", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                }

                if (!item.bnPron.isNullOrBlank()) {
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = Color(0xFFC62828).copy(alpha = 0.08f),
                        border = BorderStroke(1.dp, Color(0xFFC62828).copy(alpha = 0.25f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "🗣️ উচ্চারণ: ",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFC62828)
                            )
                            Text(
                                text = item.bnPron,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFFC62828)
                            )
                        }
                    }
                }
            } else {
                Text("?", fontSize = 26.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            }

            item.bn?.let { bn ->
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    if (speakingBn) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = MaterialTheme.colorScheme.primaryContainer,
                            modifier = Modifier.padding(bottom = 2.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                                    modifier = Modifier.size(13.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "🔊 বাংলায় অর্থ শুনছেন",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        }
                    }
                    Text(
                        bn,
                        fontSize = 20.sp,
                        lineHeight = 28.sp,
                        fontWeight = if (speakingBn) FontWeight.Bold else FontWeight.Normal,
                        color = if (speakingBn) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            val isJapanese = remember(item.id, item.target) {
                item.id.startsWith("jp-") || item.target.any { it in '\u3040'..'\u309F' || it in '\u30A0'..'\u30FF' || it in '\u4E00'..'\u9FAF' }
            }

            if (isJapanese) {
                // The standard course has its own 6-way "pattern" items, so it skips the generated drill.
                if (!item.id.startsWith(JP_STANDARD_PREFIX)) {
                    JapaneseSixWayPracticeAlertCard(targetSentence = item.target, onSpeakText = onSpeakText)
                }
            } else {
                val isGoodAt = remember(item.target, item.conceptId) {
                    item.conceptId.contains("goodat", ignoreCase = true) || item.target.contains("good at", ignoreCase = true)
                }
                val isBadAt = remember(item.target, item.conceptId) {
                    item.conceptId.contains("badat", ignoreCase = true) || item.target.contains("bad at", ignoreCase = true)
                }
                if (isGoodAt || isBadAt) {
                    SixWayPracticeAlertCard(isGoodAt = isGoodAt, targetSentence = item.target)
                }
            }

            if (revealTarget && item.tokens.size > 1) {
                Text("শব্দে ট্যাপ করে আলাদা করে শুনুন", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                FlowRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    item.tokens.forEach { token ->
                        AssistChip(
                            onClick = { onSpeakToken(token) },
                            label = { Text(if (token.bn != null) "${token.text} · ${token.bn}" else token.text) }
                        )
                    }
                }
            }

            if (revealTarget && !item.exampleTarget.isNullOrBlank()) {
                Text("উদাহরণ", style = MaterialTheme.typography.labelMedium)
                Text(item.exampleTarget, style = MaterialTheme.typography.bodyLarge)
                item.exampleBn?.let { Text(it, style = MaterialTheme.typography.bodyMedium) }
            }
        }
    }
}

@Composable
private fun VoiceWarning(message: String) {
    Text(
        message,
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onErrorContainer,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
private fun PlayerControls(
    isPlaying: Boolean,
    repeatItem: Boolean,
    onToggleRepeat: () -> Unit,
    onPrevious: () -> Unit,
    onTogglePlay: () -> Unit,
    onNext: () -> Unit
) {
    Row(
        Modifier.fillMaxWidth().padding(12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Continuous mode: repeat the current item non-stop until Next, Previous or Pause.
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (repeatItem) {
                FilledIconButton(onClick = onToggleRepeat) {
                    Icon(Icons.Default.AllInclusive, contentDescription = "অবিরাম বন্ধ করুন")
                }
            } else {
                IconButton(onClick = onToggleRepeat) {
                    Icon(Icons.Default.AllInclusive, contentDescription = "অবিরাম চালু করুন")
                }
            }
            Text(
                "অবিরাম",
                style = MaterialTheme.typography.labelSmall,
                color = if (repeatItem) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        IconButton(onClick = onPrevious) { Icon(Icons.Default.SkipPrevious, contentDescription = "আগের আইটেম") }
        FilledIconButton(onClick = onTogglePlay, modifier = Modifier.size(64.dp)) {
            Icon(
                if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                contentDescription = if (isPlaying) "থামান" else "চালান",
                modifier = Modifier.size(36.dp)
            )
        }
        IconButton(onClick = onNext) { Icon(Icons.Default.SkipNext, contentDescription = "পরের আইটেম") }
    }
}

@Composable
private fun SettingsSheet(
    settings: LearnSettings,
    onBnAudio: (Boolean) -> Unit,
    onWordByWord: (Boolean) -> Unit,
    onAutoAdvance: (Boolean) -> Unit,
    onLoop: (Boolean) -> Unit,
    onRepeatCount: (Int) -> Unit
) {
    Column(Modifier.padding(horizontal = 20.dp, vertical = 8.dp)) {
        Text("প্লেব্যাক সেটিংস", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        // Each repeat = English once + Bangla once, so both are heard the same number of times.
        Row(Modifier.fillMaxWidth().padding(vertical = 6.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text("বার বার শুনুন")
                Text(
                    "প্রতিবার ইংরেজি ১ বার + বাংলা ১ বার",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            IconButton(
                onClick = { onRepeatCount(settings.repeatCount - 1) },
                enabled = settings.repeatCount > LearnSettings.MIN_REPEAT_COUNT
            ) { Icon(Icons.Default.Remove, contentDescription = "কমান") }
            Text("${settings.repeatCount}", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            IconButton(
                onClick = { onRepeatCount(settings.repeatCount + 1) },
                enabled = settings.repeatCount < LearnSettings.MAX_REPEAT_COUNT
            ) { Icon(Icons.Default.Add, contentDescription = "বাড়ান") }
        }
        SettingRow("বাংলা অর্থ শুনুন", settings.bnAudio, onBnAudio)
        SettingRow("শব্দে শব্দে শুনুন (বাক্য)", settings.wordByWord, onWordByWord)
        SettingRow("স্বয়ংক্রিয়ভাবে পরের আইটেমে যান", settings.autoAdvance, onAutoAdvance)
        SettingRow("লেসন বারবার চালান", settings.loopLesson, onLoop)
        if (settings.repeatItem) {
            Text(
                "অবিরাম চালু থাকলে উপরের দুটি সেটিং কাজ করে না।",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Spacer(Modifier.height(24.dp))
    }
}

@Composable
private fun SettingRow(label: String, checked: Boolean, onChange: (Boolean) -> Unit) {
    Row(
        Modifier.fillMaxWidth().padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, modifier = Modifier.weight(1f))
        Switch(checked = checked, onCheckedChange = onChange)
    }
}

@Composable
private fun SpeakingPromptBanner(isPlaying: Boolean) {
    Surface(
        color = if (isPlaying) Color(0xFF00796B).copy(alpha = 0.15f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            width = if (isPlaying) 1.5.dp else 1.dp,
            color = if (isPlaying) Color(0xFF00796B).copy(alpha = 0.6f) else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
        ) {
            Surface(
                shape = CircleShape,
                color = if (isPlaying) Color(0xFF00796B) else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.15f),
                modifier = Modifier.size(36.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = if (isPlaying) Icons.Default.RecordVoiceOver else Icons.Default.Headphones,
                        contentDescription = null,
                        tint = if (isPlaying) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(Modifier.width(12.dp))

            Column {
                Text(
                    text = if (isPlaying) "আমার সাথে জোরে জোরে বলতে থাকুন" else "অডিও শুনুন ও সাথে সাথে জোরে বলুন",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isPlaying) Color(0xFF00796B) else MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = if (isPlaying) "ভয়েস শোনার সাথে সাথে মুখ দিয়ে উচ্চারণ করুন" else "প্লে বাটনে চাপ দিয়ে জোরে জোরে প্র্যাকটিস শুরু করুন",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun SpeedDrillChallengeCard(
    item: LessonItem,
    onSpeakTarget: () -> Unit,
    onNextItem: () -> Unit,
    hasNextItem: Boolean,
    onStartChallenge: () -> Unit = {}
) {
    val wordCount = remember(item.target) {
        item.target.trim().split(Regex("\\s+")).filter { it.isNotBlank() }.size
    }
    // Dynamic timer duration based on sentence length (e.g. 15s for short, 22s for medium, 30s+ for long)
    val totalSeconds = remember(item.target) {
        maxOf(15, (wordCount * 2.2).toInt() + 4)
    }

    var isRunning by remember(item.id) { mutableStateOf(false) }
    var remainingSeconds by remember(item.id) { mutableStateOf(totalSeconds) }
    var repCount by remember(item.id) { mutableStateOf(0) }
    var isCompleted by remember(item.id) { mutableStateOf(false) }
    var isFailed by remember(item.id) { mutableStateOf(false) }

    // Countdown timer
    LaunchedEffect(isRunning, remainingSeconds) {
        if (isRunning && remainingSeconds > 0 && !isCompleted) {
            delay(1000L)
            remainingSeconds -= 1
            if (remainingSeconds <= 0) {
                isRunning = false
                isFailed = true
            }
        }
    }

    fun onRepetition() {
        if (!isRunning) return
        val next = repCount + 1
        repCount = next
        if (next >= 10) {
            isRunning = false
            isCompleted = true
        }
    }

    fun reset() {
        isRunning = false
        remainingSeconds = totalSeconds
        repCount = 0
        isCompleted = false
        isFailed = false
    }

    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.5.dp, Color(0xFF00796B).copy(alpha = 0.5f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            // Header
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        color = Color(0xFF00796B),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "⏱️ স্পিড ড্রিল চ্যালেঞ্জ",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "১০ বার জোরে বলুন",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF00796B)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF00796B).copy(alpha = 0.12f)
                ) {
                    Text(
                        text = "সময়: ${totalSeconds}s",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF00796B),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(Modifier.height(14.dp))

            // Sentence + Bangla Meaning Box (English sentence with Bangla meaning)
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = item.target,
                            fontSize = 24.sp,
                            lineHeight = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.weight(1f)
                        )
                        IconButton(
                            onClick = onSpeakTarget,
                            modifier = Modifier.size(38.dp)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                                contentDescription = "শুনুন",
                                tint = Color(0xFF00796B)
                            )
                        }
                    }

                    if (!item.bnPron.isNullOrBlank()) {
                        Spacer(Modifier.height(6.dp))
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFFC62828).copy(alpha = 0.08f),
                            border = BorderStroke(1.dp, Color(0xFFC62828).copy(alpha = 0.25f)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "🗣️ উচ্চারণ: ",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFC62828)
                                )
                                Text(
                                    text = item.bnPron,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xFFC62828)
                                )
                            }
                        }
                    }

                    if (!item.bn.isNullOrBlank()) {
                        Spacer(Modifier.height(6.dp))
                        Text(
                            text = item.bn,
                            fontSize = 18.sp,
                            lineHeight = 25.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF00796B)
                        )
                    }
                }
            }

            val isGoodAt = remember(item.target, item.conceptId) {
                item.conceptId.contains("goodat", ignoreCase = true) || item.target.contains("good at", ignoreCase = true)
            }
            val isBadAt = remember(item.target, item.conceptId) {
                item.conceptId.contains("badat", ignoreCase = true) || item.target.contains("bad at", ignoreCase = true)
            }
            if (isGoodAt || isBadAt) {
                Spacer(Modifier.height(12.dp))
                SixWayPracticeAlertCard(isGoodAt = isGoodAt, targetSentence = item.target)
            }

            Spacer(Modifier.height(14.dp))

            // Timer & Repetition Indicators
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = if (isCompleted) "✓ সম্পন্ন!" else if (isFailed) "সময় শেষ" else if (isRunning) "বাকি: ${remainingSeconds} সেকেন্ড" else "সময়সীমা: ${totalSeconds} সেকেন্ড",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isCompleted) Color(0xFF10B981) else if (remainingSeconds <= 5 && isRunning) Color(0xFFDC2626) else MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "পুনরাবৃত্তি: ${repCount} / 10 বার",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00796B)
                )
            }

            Spacer(Modifier.height(8.dp))

            // Progress bar
            LinearProgressIndicator(
                progress = {
                    if (isCompleted) 1f else if (!isRunning && repCount == 0) 1f else (remainingSeconds.toFloat() / totalSeconds.coerceAtLeast(1))
                },
                modifier = Modifier.fillMaxWidth().height(7.dp),
                color = if (isCompleted) Color(0xFF10B981) else if (remainingSeconds <= 5) Color(0xFFDC2626) else Color(0xFF00796B),
                trackColor = Color(0xFF00796B).copy(alpha = 0.15f)
            )

            Spacer(Modifier.height(10.dp))

            // 10-Dot Step Indicator
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (i in 1..10) {
                    val isDone = i <= repCount
                    Surface(
                        shape = CircleShape,
                        color = if (isDone) Color(0xFF00796B) else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f),
                        modifier = Modifier.size(24.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = "$i",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isDone) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            // Action Buttons
            when {
                isCompleted -> {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFF10B981).copy(alpha = 0.15f),
                        border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.4f)),
                        modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "🎉 অসাধারণ সাবলীলতা!",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF10B981)
                            )
                            Spacer(Modifier.height(2.dp))
                            Text(
                                text = "আপনি ${totalSeconds - remainingSeconds} সেকেন্ডে সফলভাবে ১০ বার বলেছেন! বাক্যটি আপনার স্মৃতিতে স্থায়ী হয়ে গেছে।",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        OutlinedButton(
                            onClick = ::reset,
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(4.dp))
                            Text("আবার দিন")
                        }

                        if (hasNextItem) {
                            Button(
                                onClick = onNextItem,
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00796B)),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("পরের বাক্য ⏭️", fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
                isFailed -> {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFFDC2626).copy(alpha = 0.12f),
                        border = BorderStroke(1.dp, Color(0xFFDC2626).copy(alpha = 0.3f)),
                        modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "⏱️ সময় শেষ!",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFDC2626)
                            )
                            Spacer(Modifier.height(2.dp))
                            Text(
                                text = "আপনি ${repCount} বার বলতে পেরেছেন। গতি ও সাবলীলতা বাড়াতে আবার চেষ্টা করুন!",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    Button(
                        onClick = ::reset,
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00796B)),
                        modifier = Modifier.fillMaxWidth().height(48.dp)
                    ) {
                        Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(6.dp))
                        Text("পুনরায় চ্যালেঞ্জ নিন", fontWeight = FontWeight.Bold)
                    }
                }
                isRunning -> {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = ::onRepetition,
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00796B)),
                            modifier = Modifier.weight(1f).height(54.dp)
                        ) {
                            Icon(Icons.Default.RecordVoiceOver, contentDescription = null, modifier = Modifier.size(22.dp))
                            Spacer(Modifier.width(8.dp))
                            Text(
                                text = "🗣️ ১ বার বলেছি (${repCount}/10)",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        OutlinedButton(
                            onClick = ::reset,
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.size(54.dp),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Icon(Icons.Default.Refresh, contentDescription = "রিসেট")
                        }
                    }
                }
                else -> {
                    Button(
                        onClick = {
                            onStartChallenge()
                            remainingSeconds = totalSeconds
                            repCount = 0
                            isCompleted = false
                            isFailed = false
                            isRunning = true
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00796B)),
                        modifier = Modifier.fillMaxWidth().height(52.dp)
                    ) {
                        Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(22.dp))
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = "▶️ চ্যালেঞ্জ শুরু করুন (${totalSeconds} সেকেন্ডে ১০ বার)",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SixWayPracticeAlertCard(isGoodAt: Boolean, targetSentence: String) {
    val infiniteTransition = rememberInfiniteTransition(label = "red_alert_transition")
    val borderAlpha by infiniteTransition.animateFloat(
        initialValue = 0.4f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "border_alpha"
    )

    val redAlertColor = Color(0xFFDC2626) // Deep vibrant red
    val patterns = remember(targetSentence, isGoodAt) {
        buildSixWayPatterns(target = targetSentence, isGoodAt = isGoodAt)
    }

    Surface(
        shape = RoundedCornerShape(14.dp),
        color = redAlertColor.copy(alpha = 0.06f),
        border = BorderStroke(1.5.dp, redAlertColor.copy(alpha = borderAlpha)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {
            // Animated Red Alert Header Badge
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = redAlertColor.copy(alpha = borderAlpha)
                ) {
                    Text(
                        text = "🚨 RED ALERT",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
                    )
                }

                Text(
                    text = "প্রতিটি বাক্য অর্থসহ নিজে নিজে ৬ ভাবে প্রাক্টিস করুন",
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = redAlertColor,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(Modifier.height(10.dp))

            // Transformation Box
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f),
                border = BorderStroke(1.dp, redAlertColor.copy(alpha = 0.25f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    patterns.forEachIndexed { index, sentence ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = redAlertColor.copy(alpha = 0.15f),
                                modifier = Modifier.size(20.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(
                                        text = "${index + 1}",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = redAlertColor
                                    )
                                }
                            }
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = sentence,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun buildSixWayPatterns(target: String, isGoodAt: Boolean): List<String> {
    val clean = target.trim().removeSuffix(".").removeSuffix("?").removeSuffix("!").trim()
    val adj = if (isGoodAt) "good" else "bad"

    val regex = Regex(
        pattern = """^(.+?)\s+(am|is|are|'m|'re|'s)\s+(?:good|bad)\s+at\s+(.+)$""",
        option = RegexOption.IGNORE_CASE
    )
    val match = regex.find(clean)

    val (subj, verb, topic) = if (match != null) {
        val s = match.groupValues[1].trim()
        val v = match.groupValues[2].trim().lowercase()
        val t = match.groupValues[3].trim()
        Triple(s, v, t)
    } else {
        Triple("I", "am", "English")
    }

    val subjLower = subj.lowercase()
    val pos: String
    val neg: String
    val beVerb: String
    val qSubj: String

    when (subjLower) {
        "i" -> {
            pos = "I'm"
            neg = "I'm not"
            beVerb = "am"
            qSubj = "I"
        }
        "you" -> {
            pos = "You're"
            neg = "You're not"
            beVerb = "are"
            qSubj = "you"
        }
        "we" -> {
            pos = "We're"
            neg = "We're not"
            beVerb = "are"
            qSubj = "we"
        }
        "they" -> {
            pos = "They're"
            neg = "They're not"
            beVerb = "are"
            qSubj = "they"
        }
        "he" -> {
            pos = "He's"
            neg = "He's not"
            beVerb = "is"
            qSubj = "he"
        }
        "she" -> {
            pos = "She's"
            neg = "She's not"
            beVerb = "is"
            qSubj = "she"
        }
        "it" -> {
            pos = "It's"
            neg = "It's not"
            beVerb = "is"
            qSubj = "it"
        }
        else -> {
            val isPlural = verb in listOf("are", "'re")
            val vStr = if (isPlural) "are" else "is"
            pos = "$subj $vStr"
            neg = "$subj $vStr not"
            beVerb = vStr
            qSubj = subj
        }
    }

    val qBe = beVerb.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }

    return listOf(
        "$pos $adj at $topic",
        "$neg $adj at $topic",
        "$qBe $qSubj $adj at $topic?",
        "$qBe $qSubj not $adj at $topic?",
        "How $beVerb $qSubj $adj at $topic?",
        "Why $beVerb $qSubj not $adj at $topic?"
    )
}

data class JapaneseTransformation(
    val label: String,
    val japanese: String,
    val meaning: String
)

@Composable
private fun JapaneseSixWayPracticeAlertCard(
    targetSentence: String,
    onSpeakText: (String) -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "jp_alert_transition")
    val borderAlpha by infiniteTransition.animateFloat(
        initialValue = 0.4f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "jp_border_alpha"
    )

    val redAlertColor = Color(0xFFC62828) // Japanese Hinomaru Crimson
    val patterns = remember(targetSentence) {
        buildJapaneseSixWayPatterns(target = targetSentence)
    }

    if (patterns.isEmpty()) return

    Surface(
        shape = RoundedCornerShape(14.dp),
        color = redAlertColor.copy(alpha = 0.06f),
        border = BorderStroke(1.5.dp, redAlertColor.copy(alpha = borderAlpha)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {
            // Header
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = redAlertColor.copy(alpha = borderAlpha)
                ) {
                    Text(
                        text = "🇯🇵 6-WAY DRILL",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
                    )
                }

                Text(
                    text = "জাপানিজে ৬ ভাবে মুখে বলার দ্রুত রিফ্লেক্স তৈরি করুন",
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = redAlertColor,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(Modifier.height(10.dp))

            // Transformation Box
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.95f),
                border = BorderStroke(1.dp, redAlertColor.copy(alpha = 0.25f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    patterns.forEachIndexed { index, item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onSpeakText(item.japanese) }
                                .padding(vertical = 2.dp)
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = redAlertColor.copy(alpha = 0.15f),
                                modifier = Modifier.size(22.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(
                                        text = "${index + 1}",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = redAlertColor
                                    )
                                }
                            }
                            Spacer(Modifier.width(10.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = item.japanese,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "${item.label} · ${item.meaning}",
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            IconButton(
                                onClick = { onSpeakText(item.japanese) },
                                modifier = Modifier.size(28.dp)
                            ) {
                                Icon(
                                    Icons.AutoMirrored.Filled.VolumeUp,
                                    contentDescription = "উচ্চারণ শুনুন",
                                    tint = redAlertColor,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun buildJapaneseSixWayPatterns(target: String): List<JapaneseTransformation> {
    val t = target.trim().removeSuffix("。").removeSuffix("?").removeSuffix("！").trim()
    val results = mutableListOf<JapaneseTransformation>()

    when {
        t.contains("でした") -> {
            val base = t.replace("でした", "").trim()
            results.add(JapaneseTransformation("অতীত হ্যাঁ (+)", "$base でした。", "অতীতে ছিল / হয়েছিল"))
            results.add(JapaneseTransformation("অতীত না (-)", "$base ではありませんでした。", "অতীতে ছিল না / হয়নি"))
            results.add(JapaneseTransformation("অতীত প্রশ্ন (?)", "$base でしたか。", "অতীতে কি ছিল?"))
            results.add(JapaneseTransformation("অতীত নেগেটিভ প্রশ্ন (-?)", "$base ではありませんでしたか。", "অতীতে কি ছিল না?"))
            results.add(JapaneseTransformation("অতীত জিজ্ঞাসা (WH?)", "$base は どうでしたか。", "কেমন ছিল?"))
            results.add(JapaneseTransformation("অতীত বিকল্প (Choice)", "$base でしたか、そうではありませんでしたか。", "ছিল নাকি ছিল না?"))
        }
        t.contains("ました") -> {
            val base = t.replace("ました", "").trim()
            results.add(JapaneseTransformation("অতীত হ্যাঁ (+)", "$base ました。", "অতীতে করেছিলাম"))
            results.add(JapaneseTransformation("অতীত না (-)", "$base ませんでした。", "অতীতে করিনি"))
            results.add(JapaneseTransformation("অতীত প্রশ্ন (?)", "$base ましたか。", "করেছিলেন কি?"))
            results.add(JapaneseTransformation("অতীত নেগেটিভ প্রশ্ন (-?)", "$base ませんでしたか。", "করেননি কি?"))
            results.add(JapaneseTransformation("অতীত জিজ্ঞাসা (WH?)", "何をしたか / $base ましたか。", "কী করেছিলেন?"))
            results.add(JapaneseTransformation("অতীত বিকল্প (Choice)", "$base ましたか、しませんでしたか。", "করেছিলেন নাকি করেননি?"))
        }
        t.contains("です") -> {
            val base = t.replace("です", "").trim()
            results.add(JapaneseTransformation("হ্যাঁ-বোধক (+)", "$base です。", "হয় / আছি"))
            results.add(JapaneseTransformation("না-বোধক (-)", "$base ではありません。", "নয় / নেই"))
            results.add(JapaneseTransformation("প্রশ্নবোধক (?)", "$base ですか。", "কি?"))
            results.add(JapaneseTransformation("নেগেটিভ প্রশ্ন (-?)", "$base ではありませんか。", "নয় কি?"))
            results.add(JapaneseTransformation("তথ্য জিজ্ঞাসা (WH?)", "$base は 何/だれ ですか。", "কে বা কী?"))
            results.add(JapaneseTransformation("বিকল্প নির্বাচন (Choice)", "$base ですか、ちがいますか。", "নাকি অন্য কিছু?"))
        }
        t.contains("ます") -> {
            val base = t.replace("ます", "").trim()
            results.add(JapaneseTransformation("হ্যাঁ-বোধক (+)", "$base ます。", "করি / করব"))
            results.add(JapaneseTransformation("না-বোধক (-)", "$base ません。", "করি না / করব না"))
            results.add(JapaneseTransformation("প্রশ্নবোধক (?)", "$base ますか。", "করেন কি?"))
            results.add(JapaneseTransformation("নেগেটিভ প্রশ্ন (-?)", "$base ませんか。", "করবেন না কি? (আমন্ত্রণ)"))
            results.add(JapaneseTransformation("তথ্য জিজ্ঞাসা (WH?)", "何を $base ますか。", "কী করবেন?"))
            results.add(JapaneseTransformation("বিকল্প নির্বাচন (Choice)", "$base ますか、しませんか。", "করবেন নাকি করবেন না?"))
        }
    }
    return results
}

