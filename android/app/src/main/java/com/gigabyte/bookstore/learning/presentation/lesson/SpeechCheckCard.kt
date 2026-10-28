package com.gigabyte.bookstore.learning.presentation.lesson

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.gigabyte.bookstore.learning.domain.model.LessonItem
import com.gigabyte.bookstore.learning.domain.speech.SpeechMatch

/** ID prefix of the Japanese standard course (tools/japanese/build_standard_course.py). */
internal const val JP_STANDARD_PREFIX = "jp-std-"

/** ID prefix of the Urdu standard course (tools/urdu/build_urdu_course.py). */
internal const val UR_STANDARD_PREFIX = "ur-std-"

/** Recognizer language for the speech check, or null when the item's course has no check. */
internal fun speechCheckLanguage(itemId: String): String? = when {
    itemId.startsWith(JP_STANDARD_PREFIX) -> "ja-JP"
    itemId.startsWith(UR_STANDARD_PREFIX) -> "ur-PK"
    else -> null
}

private sealed interface SpeechCheckState {
    data object Idle : SpeechCheckState
    data object Listening : SpeechCheckState
    data class Checked(val result: SpeechMatch.Result, val heard: String) : SpeechCheckState
    /** No recognizer, no permission or an error: the learner rates their own try. */
    data class SelfRate(val reason: String) : SpeechCheckState
    data class Rated(val emoji: String) : SpeechCheckState
}

/**
 * "Speak" step speech check (Japanese plan §11.4, Urdu plan §11.6).
 * Uses on-device recognition in [languageTag] as feedback only; it never blocks the next item.
 */
@Composable
fun SpeechCheckCard(
    item: LessonItem,
    languageTag: String,
    onSpeakTarget: () -> Unit,
    onPauseAudio: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var state by remember(item.id, item.target) { mutableStateOf<SpeechCheckState>(SpeechCheckState.Idle) }
    var recognizer by remember { mutableStateOf<SpeechRecognizer?>(null) }

    // Japanese: the kana reading is the text before " · " in the hint line (built by tools/japanese).
    val expected = remember(item.id, item.target) {
        listOfNotNull(
            item.target,
            item.bnPron?.substringBefore(" · ")?.takeIf { SpeechMatch.isKanaOnly(it) }
        )
    }

    DisposableEffect(Unit) {
        onDispose {
            try {
                recognizer?.destroy()
            } catch (_: Exception) {
            }
            recognizer = null
        }
    }

    fun listen() {
        onPauseAudio()
        if (!SpeechRecognizer.isRecognitionAvailable(context)) {
            state = SpeechCheckState.SelfRate("এই ফোনে স্পিচ রিকগনিশন নেই।")
            return
        }
        try {
            recognizer?.destroy()
            val created = SpeechRecognizer.createSpeechRecognizer(context)
            recognizer = created
            created.setRecognitionListener(object : RecognitionListener {
                override fun onReadyForSpeech(params: Bundle?) {
                    state = SpeechCheckState.Listening
                }

                override fun onBeginningOfSpeech() {}
                override fun onRmsChanged(rmsdB: Float) {}
                override fun onBufferReceived(buffer: ByteArray?) {}
                override fun onEndOfSpeech() {}
                override fun onPartialResults(partialResults: Bundle?) {}
                override fun onEvent(eventType: Int, params: Bundle?) {}

                override fun onError(error: Int) {
                    state = when (error) {
                        SpeechRecognizer.ERROR_NO_MATCH, SpeechRecognizer.ERROR_SPEECH_TIMEOUT ->
                            SpeechCheckState.Checked(SpeechMatch.Result.NO_MATCH, "")
                        else -> SpeechCheckState.SelfRate("ভয়েস যাচাই এখন কাজ করছে না।")
                    }
                }

                override fun onResults(results: Bundle?) {
                    val heard = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION).orEmpty()
                    state = SpeechCheckState.Checked(
                        SpeechMatch.evaluate(heard, expected),
                        heard.firstOrNull().orEmpty()
                    )
                }
            })
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                putExtra(RecognizerIntent.EXTRA_LANGUAGE, languageTag)
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, languageTag)
                putExtra(RecognizerIntent.EXTRA_PREFER_OFFLINE, true)
                putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, context.packageName)
                putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 5)
            }
            state = SpeechCheckState.Listening
            created.startListening(intent)
        } catch (_: Exception) {
            state = SpeechCheckState.SelfRate("ভয়েস যাচাই চালু করা যায়নি।")
        }
    }

    val permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        if (granted) listen() else state = SpeechCheckState.SelfRate("মাইক্রোফোন পারমিশন দেওয়া হয়নি।")
    }

    fun start() {
        val granted = ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) ==
            PackageManager.PERMISSION_GRANTED
        if (granted) listen() else permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("🎤 জোরে বলুন, তারপর যাচাই করুন", fontWeight = FontWeight.Bold)

            when (val s = state) {
                SpeechCheckState.Idle -> Text(
                    "বাক্যটি নিজে বলুন। এটি শুধু ফিডব্যাক, পরের আইটেমে যেতে কোনো বাধা নেই।",
                    style = MaterialTheme.typography.bodySmall
                )
                SpeechCheckState.Listening -> Row(verticalAlignment = Alignment.CenterVertically) {
                    CircularProgressIndicator(Modifier.size(18.dp), strokeWidth = 2.dp)
                    Text("  শুনছি… এখন বলুন", style = MaterialTheme.typography.bodyMedium)
                }
                is SpeechCheckState.Checked -> {
                    val (text, color) = when (s.result) {
                        SpeechMatch.Result.MATCH -> "✓ ঠিক হয়েছে!" to Color(0xFF2E7D32)
                        SpeechMatch.Result.NEAR -> "প্রায় ঠিক। আরেকবার চেষ্টা করুন।" to Color(0xFFEF6C00)
                        SpeechMatch.Result.NO_MATCH -> "আবার শুনুন, তারপর বলুন।" to Color(0xFFC62828)
                    }
                    Text(text, color = color, fontWeight = FontWeight.Bold)
                    if (s.heard.isNotBlank()) {
                        Text("শোনা গেছে: ${s.heard}", style = MaterialTheme.typography.bodySmall)
                    }
                }
                is SpeechCheckState.SelfRate -> {
                    Text("${s.reason} নিজেই যাচাই করুন: কেমন হলো?", style = MaterialTheme.typography.bodySmall)
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        listOf("😀", "😐", "😟").forEach { emoji ->
                            TextButton(onClick = {
                                state = SpeechCheckState.Rated(emoji)
                                if (emoji != "😀") onSpeakTarget()
                            }) { Text(emoji, style = MaterialTheme.typography.titleLarge) }
                        }
                    }
                }
                is SpeechCheckState.Rated -> Text(
                    if (s.emoji == "😀") "চমৎকার! পরের আইটেমে যান।" else "আরেকবার শুনুন এবং সাথে সাথে বলুন।",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = { start() }, enabled = state != SpeechCheckState.Listening) {
                    Icon(Icons.Default.Mic, contentDescription = null, modifier = Modifier.size(18.dp))
                    Text("  বলুন")
                }
                OutlinedButton(onClick = onSpeakTarget) {
                    Icon(Icons.AutoMirrored.Filled.VolumeUp, contentDescription = null, modifier = Modifier.size(18.dp))
                    Text("  আবার শুনুন")
                }
            }
        }
    }
}
