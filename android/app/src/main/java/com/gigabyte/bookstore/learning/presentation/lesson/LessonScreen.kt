package com.gigabyte.bookstore.learning.presentation.lesson

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AllInclusive
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                        Text(
                            "${index + 1} / ${items.size}",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(Modifier.height(8.dp))
                        // In speak mode each item is [gap, answer, pause]: hide the answer during the gap.
                        val revealTarget = uiState.mode == LessonMode.LISTEN ||
                            (playerState.stepIndex % 3 != 0) || playerState.isFinished
                        ItemCard(
                            item = items[index],
                            currentStep = playerState.currentStep,
                            revealTarget = revealTarget,
                            onSpeakToken = viewModel::speakToken,
                            onSpeakTarget = { viewModel.speakText(items[index].target) }
                        )
                        if (uiState.mode == LessonMode.SPEAK && !revealTarget) {
                            Spacer(Modifier.height(12.dp))
                            Text(
                                "বাংলাটি দেখে ইংরেজিতে জোরে বলুন। একটু পরে সঠিক উত্তর শুনবেন।",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
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
    onSpeakTarget: () -> Unit
) {
    val speakingBn = (currentStep as? PlaybackStep.Speak)?.lang == SpeechLang.BN
    val speakingRate = (currentStep as? PlaybackStep.Speak)?.takeIf { it.lang == SpeechLang.EN }?.rate

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
            } else {
                Text("?", fontSize = 26.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            }

            item.bn?.let { bn ->
                Text(
                    bn,
                    fontSize = 20.sp,
                    lineHeight = 28.sp,
                    color = if (speakingBn) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                )
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
