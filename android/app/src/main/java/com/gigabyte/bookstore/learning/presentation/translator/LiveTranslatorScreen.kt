package com.gigabyte.bookstore.learning.presentation.translator

import android.Manifest
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.VolumeOff
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.SlowMotionVideo
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.learning.domain.translator.RegionalDialectChoice
import com.gigabyte.bookstore.learning.domain.translator.SpeechCaptureState
import com.gigabyte.bookstore.learning.domain.translator.TranslationResult
import com.gigabyte.bookstore.learning.domain.translator.TranslatorDirection
import com.gigabyte.bookstore.learning.domain.translator.TranslatorLanguage
import com.gigabyte.bookstore.learning.presentation.lesson.quranTextStyle
import com.gigabyte.bookstore.learning.presentation.lesson.urduTextStyle
import com.gigabyte.bookstore.presentation.components.AppBackground
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar

private val BANGLA_SAMPLE_PHRASES = listOf(
    "আপনি কেমন আছেন?",
    "ভাই, এর দাম কত?",
    "একটু ঠান্ডা পানি দিন",
    "রাস্তাটা কোথায়?",
    "আমি সাহায্য চাই",
    "ধন্যবাদ, ভালো থাকবেন"
)

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun LiveTranslatorScreen(
    viewModel: LiveTranslatorViewModel,
    onBackClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val speechState by viewModel.speechState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val accent = Color(uiState.selectedLanguage.accentHex)

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) {
            viewModel.startVoiceCapture()
        } else {
            Toast.makeText(context, "ভয়েস অনুবাদের জন্য মাইক্রোফোন অনুমতি প্রয়োজন।", Toast.LENGTH_SHORT).show()
        }
    }

    fun triggerVoiceCapture() {
        val granted = ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) ==
            PackageManager.PERMISSION_GRANTED
        if (granted) viewModel.startVoiceCapture() else permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
    }

    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = {
                    Column {
                        Text("লাইভ ভয়েস অনুবাদক", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(
                            "বাংলা স্পিচ-টু-টেক্সট থেকে বহুভাষিক অনুবাদ",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "ফিরে যান")
                    }
                },
                actions = {
                    IconButton(onClick = viewModel::toggleAutoSpeak) {
                        Icon(
                            imageVector = if (uiState.autoSpeak) Icons.AutoMirrored.Filled.VolumeUp else Icons.AutoMirrored.Filled.VolumeOff,
                            contentDescription = if (uiState.autoSpeak) "অটো অডিও চালু" else "অটো অডিও বন্ধ"
                        )
                    }
                }
            )
        }
    ) { padding ->
        AppBackground(Modifier.fillMaxSize().padding(padding)) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // 1. Target Language Picker
                item {
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(TranslatorLanguage.entries) { lang ->
                            val selected = lang == uiState.selectedLanguage
                            FilterChip(
                                selected = selected,
                                onClick = { viewModel.selectLanguage(lang) },
                                label = { Text("${lang.flag} ${lang.titleBn}", fontWeight = FontWeight.SemiBold) },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = Color(lang.accentHex),
                                    selectedLabelColor = Color.White
                                )
                            )
                        }
                    }
                }

                // 1b. Optional 9-Dialect Picker when Regional Bangla is selected
                if (uiState.selectedLanguage == TranslatorLanguage.REGIONAL_BANGLA) {
                    item {
                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text(
                                "অঞ্চল নির্বাচন করুন:",
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF006A4E)
                            )
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                items(RegionalDialectChoice.entries) { dialect ->
                                    val selected = dialect == uiState.selectedDialect
                                    FilterChip(
                                        selected = selected,
                                        onClick = { viewModel.selectDialect(dialect) },
                                        label = { Text(dialect.labelBn, fontSize = 12.sp) },
                                        colors = FilterChipDefaults.filterChipColors(
                                            selectedContainerColor = Color(0xFF006A4E),
                                            selectedLabelColor = Color.White
                                        )
                                    )
                                }
                            }
                        }
                    }
                }

                // 2. Translation Direction Switcher
                item {
                    val fromLabel = if (uiState.direction == TranslatorDirection.BN_TO_TARGET) {
                        "🇧🇩 বাংলা (বলুন বা লিখুন)"
                    } else {
                        "${uiState.selectedLanguage.flag} ${uiState.selectedLanguage.titleBn}"
                    }
                    val toLabel = if (uiState.direction == TranslatorDirection.BN_TO_TARGET) {
                        "${uiState.selectedLanguage.flag} ${uiState.selectedLanguage.titleBn}"
                    } else {
                        "🇧🇩 প্রমিত বাংলা"
                    }

                    Surface(
                        shape = RoundedCornerShape(14.dp),
                        color = accent.copy(alpha = 0.08f),
                        border = BorderStroke(1.dp, accent.copy(alpha = 0.28f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(fromLabel, fontWeight = FontWeight.Bold, color = accent, fontSize = 13.sp, modifier = Modifier.weight(1f))
                            IconButton(onClick = viewModel::toggleDirection) {
                                Icon(Icons.Default.SwapHoriz, contentDescription = "ভাষা অদলবদল করুন", tint = accent)
                            }
                            Text(
                                toLabel,
                                fontWeight = FontWeight.Bold,
                                color = accent,
                                fontSize = 13.sp,
                                modifier = Modifier.weight(1f),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }

                // 3. Live Speech-to-Text Input Card
                item {
                    val isListening = speechState is SpeechCaptureState.Listening
                    val liveListening = speechState as? SpeechCaptureState.Listening
                    val displayedInput = if (isListening && !liveListening?.partialText.isNullOrBlank()) {
                        liveListening?.partialText.orEmpty()
                    } else {
                        uiState.inputText
                    }

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            OutlinedTextField(
                                value = displayedInput,
                                onValueChange = viewModel::updateInputText,
                                label = {
                                    Text(
                                        if (uiState.direction == TranslatorDirection.BN_TO_TARGET) {
                                            "বাংলায় বলুন অথবা লিখুন..."
                                        } else {
                                            "${uiState.selectedLanguage.titleBn} ভাষায় বলুন বা লিখুন..."
                                        }
                                    )
                                },
                                modifier = Modifier.fillMaxWidth(),
                                minLines = 2,
                                maxLines = 4,
                                trailingIcon = {
                                    if (displayedInput.isNotEmpty() && !isListening) {
                                        IconButton(onClick = { viewModel.updateInputText("") }) {
                                            Icon(Icons.Default.Clear, contentDescription = "মুছুন")
                                        }
                                    }
                                }
                            )

                            // Live Voice Mic & Animated Waveform Row
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                val pulse = rememberInfiniteTransition(label = "micPulse")
                                val animScale by pulse.animateFloat(
                                    initialValue = 1.0f,
                                    targetValue = if (isListening) 1.12f else 1.0f,
                                    animationSpec = infiniteRepeatable(
                                        tween(650, easing = FastOutSlowInEasing),
                                        RepeatMode.Reverse
                                    ),
                                    label = "micScale"
                                )

                                FloatingActionButton(
                                    onClick = { if (isListening) viewModel.stopVoiceCapture() else triggerVoiceCapture() },
                                    containerColor = if (isListening) Color(0xFFC62828) else accent,
                                    contentColor = Color.White,
                                    modifier = Modifier.size(52.dp).scale(if (isListening) animScale else 1.0f),
                                    shape = CircleShape
                                ) {
                                    Icon(
                                        imageVector = if (isListening) Icons.Default.Stop else Icons.Default.Mic,
                                        contentDescription = if (isListening) "শোনা থামান" else "কথা বলে লিখুন"
                                    )
                                }

                                Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                    if (isListening) {
                                        val rms = liveListening?.rmsNormalized ?: 0.3f
                                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                            Icon(Icons.Default.GraphicEq, contentDescription = null, tint = Color(0xFFC62828), modifier = Modifier.size(18.dp))
                                            Text("শুনছি... পরিষ্কারভাবে বলুন", fontWeight = FontWeight.Bold, color = Color(0xFFC62828), fontSize = 13.sp)
                                        }
                                        LiveVoiceWaveBar(rmsNormalized = rms, color = Color(0xFFC62828))
                                    } else {
                                        Text(
                                            if (uiState.direction == TranslatorDirection.BN_TO_TARGET) {
                                                "মাইক চাপুন এবং বাংলায় কথা বলুন"
                                            } else {
                                                "মাইক চাপুন (${uiState.selectedLanguage.titleBn} ভয়েস)"
                                            },
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 13.sp
                                        )
                                        Text(
                                            "কথা বলার সাথে সাথে লাইভ টেক্সট ও অনুবাদ হবে",
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }

                                Button(
                                    onClick = viewModel::translateNow,
                                    enabled = !uiState.isTranslating && !isListening && uiState.inputText.isNotBlank(),
                                    colors = ButtonDefaults.buttonColors(containerColor = accent)
                                ) {
                                    if (uiState.isTranslating) {
                                        CircularProgressIndicator(modifier = Modifier.size(18.dp), color = Color.White, strokeWidth = 2.dp)
                                    } else {
                                        Icon(Icons.Default.Translate, contentDescription = null, modifier = Modifier.size(18.dp))
                                        Spacer(Modifier.width(6.dp))
                                        Text("অনুবাদ")
                                    }
                                }
                            }

                            val speechErr = (speechState as? SpeechCaptureState.Error)?.messageBn
                            val errText = speechErr ?: uiState.errorMessage
                            AnimatedVisibility(visible = !errText.isNullOrBlank()) {
                                Surface(
                                    color = MaterialTheme.colorScheme.errorContainer,
                                    shape = RoundedCornerShape(10.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = errText.orEmpty(),
                                        color = MaterialTheme.colorScheme.onErrorContainer,
                                        style = MaterialTheme.typography.bodySmall,
                                        modifier = Modifier.padding(10.dp)
                                    )
                                }
                            }
                        }
                    }
                }

                // 4. Quick Sample Prompts when translating BN -> Target
                if (uiState.direction == TranslatorDirection.BN_TO_TARGET) {
                    item {
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            items(BANGLA_SAMPLE_PHRASES) { phrase ->
                                AssistChip(
                                    onClick = { viewModel.translateSample(phrase) },
                                    label = { Text(phrase, fontSize = 12.sp) }
                                )
                            }
                        }
                    }
                }

                // 5. Rich Translation Output Card
                uiState.result?.let { result ->
                    item {
                        TranslationOutputCard(
                            result = result,
                            language = TranslatorLanguage.fromKey(result.languageKey),
                            onPlayNormal = { viewModel.speakResult(slow = false) },
                            onPlaySlow = { viewModel.speakResult(slow = true) },
                            onSpeakWord = { viewModel.speakWord(it) },
                            onCopy = {
                                val cm = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                cm.setPrimaryClip(ClipData.newPlainText("translation", result.targetText))
                                Toast.makeText(context, "অনুবাদ কপি করা হয়েছে", Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }

                // 6. Recent History
                if (uiState.history.isNotEmpty()) {
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(top = 6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Icon(Icons.Default.History, contentDescription = null, modifier = Modifier.size(18.dp), tint = MaterialTheme.colorScheme.onSurfaceVariant)
                                Text("সাম্প্রতিক অনুবাদ", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                            }
                            TextButton(onClick = viewModel::clearHistory) {
                                Icon(Icons.Default.DeleteOutline, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(Modifier.width(4.dp))
                                Text("মুছুন", fontSize = 12.sp)
                            }
                        }
                    }
                    items(uiState.history.take(15)) { past ->
                        val pastLang = TranslatorLanguage.fromKey(past.languageKey)
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.surface,
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)),
                            modifier = Modifier.fillMaxWidth().clickable { viewModel.selectHistoryItem(past) }
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                                    Text("${pastLang.flag} ${past.sourceText}", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                    Text(past.targetText, fontWeight = FontWeight.Bold, fontSize = 15.sp, maxLines = 2, overflow = TextOverflow.Ellipsis)
                                    past.banglaPronunciation?.let {
                                        Text("উচ্চারণ: $it", fontSize = 12.sp, color = Color(pastLang.accentHex), maxLines = 1, overflow = TextOverflow.Ellipsis)
                                    }
                                }
                                Icon(Icons.AutoMirrored.Filled.VolumeUp, contentDescription = "শুনুন", tint = Color(pastLang.accentHex))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun LiveVoiceWaveBar(rmsNormalized: Float, color: Color) {
    val heights = listOf(0.4f, 0.75f, 1.0f, 0.65f, 0.9f, 0.5f, 0.8f)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.height(20.dp)
    ) {
        heights.forEach { factor ->
            val animHeight by animateFloatAsState(
                targetValue = (6f + 14f * (rmsNormalized * factor).coerceIn(0.1f, 1.0f)),
                animationSpec = tween(120),
                label = "wave"
            )
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .height(animHeight.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(color)
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun TranslationOutputCard(
    result: TranslationResult,
    language: TranslatorLanguage,
    onPlayNormal: () -> Unit,
    onPlaySlow: () -> Unit,
    onSpeakWord: (String) -> Unit,
    onCopy: () -> Unit
) {
    val accent = Color(language.accentHex)
    val isRtlTarget = result.direction == TranslatorDirection.BN_TO_TARGET && language.isRtl

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.5.dp, accent.copy(alpha = 0.4f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(shape = RoundedCornerShape(10.dp), color = accent.copy(alpha = 0.12f)) {
                    Text(
                        "${language.flag} ${result.sourceTier.badgeBn}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = accent,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
                IconButton(onClick = onCopy, modifier = Modifier.size(32.dp)) {
                    Icon(Icons.Default.ContentCopy, contentDescription = "কপি করুন", tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(18.dp))
                }
            }

            // Target translated text with native script styling
            if (isRtlTarget && language == TranslatorLanguage.URDU) {
                Text(result.targetText, style = urduTextStyle(26.sp, bold = true))
            } else if (isRtlTarget && language == TranslatorLanguage.ARABIC) {
                Text(result.targetText, style = quranTextStyle(26.sp, bold = true))
            } else {
                Text(
                    result.targetText,
                    fontSize = 22.sp,
                    lineHeight = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            // Bangla Pronunciation Bridge & Romanization
            if (!result.banglaPronunciation.isNullOrBlank() || !result.romanization.isNullOrBlank()) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = accent.copy(alpha = 0.08f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        result.banglaPronunciation?.let {
                            Text(
                                "বাংলা উচ্চারণ: $it",
                                fontWeight = FontWeight.Bold,
                                color = accent,
                                fontSize = 15.sp
                            )
                        }
                        result.romanization?.let {
                            Text(
                                "পঠন সহায়িকা: $it",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            // Audio Buttons
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = onPlayNormal,
                    colors = ButtonDefaults.buttonColors(containerColor = accent),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.AutoMirrored.Filled.VolumeUp, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("শুনুন")
                }
                OutlinedButton(
                    onClick = onPlaySlow,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.SlowMotionVideo, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("ধীরে শুনুন")
                }
            }

            // Tap-to-hear Word Breakdown
            if (result.wordBreakdown.isNotEmpty() && result.direction == TranslatorDirection.BN_TO_TARGET) {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(
                        "শব্দে ট্যাপ করে আলাদা উচ্চারণ শুনুন:",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        result.wordBreakdown.forEach { tok ->
                            AssistChip(
                                onClick = { onSpeakWord(tok.text) },
                                label = {
                                    Text(
                                        if (!tok.bn.isNullOrBlank()) "${tok.text} · ${tok.bn}" else tok.text,
                                        fontSize = 12.sp
                                    )
                                }
                            )
                        }
                    }
                }
            }

            // Grammar / Politeness Tip
            result.grammarTipBn?.let { tip ->
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.65f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "💡 $tip",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }
}
