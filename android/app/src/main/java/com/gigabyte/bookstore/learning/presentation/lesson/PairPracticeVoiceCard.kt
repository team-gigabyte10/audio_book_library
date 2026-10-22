package com.gigabyte.bookstore.learning.presentation.lesson

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.gigabyte.bookstore.learning.domain.model.LessonItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Locale

enum class MatchedAnswerType { YES, NO, UNKNOWN }

data class VoiceEvaluation(
    val spokenText: String,
    val matchedType: MatchedAnswerType,
    val expectedAnswer: String,
    val accuracyPercent: Int,
    val isPassed: Boolean,
    val feedbackMessage: String
)

sealed interface VoiceRecognitionState {
    object Idle : VoiceRecognitionState
    object Listening : VoiceRecognitionState
    object Processing : VoiceRecognitionState
    data class Success(val evaluation: VoiceEvaluation) : VoiceRecognitionState
    data class Error(val message: String) : VoiceRecognitionState
}

@Composable
fun PairPracticeVoiceCard(
    item: LessonItem,
    onSpeakQuestion: () -> Unit,
    onSpeakYes: () -> Unit,
    onSpeakNo: () -> Unit,
    onSpeakText: (String) -> Unit,
    onNext: () -> Unit,
    hasNext: Boolean,
    onPauseAudio: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    var state by remember(item.id) { mutableStateOf<VoiceRecognitionState>(VoiceRecognitionState.Idle) }
    var speechRecognizer by remember { mutableStateOf<SpeechRecognizer?>(null) }
    var hasPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
        )
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        hasPermission = granted
        if (!granted) {
            Toast.makeText(context, "ভয়েস দিয়ে উত্তর চেক করার জন্য মাইক্রোফোন পারমিশন প্রয়োজন", Toast.LENGTH_SHORT).show()
        }
    }

    val yesAnswer = item.exampleTarget.orEmpty()
    val noAnswer = item.exampleBn.orEmpty()

    // Dispose recognizer on exit
    DisposableEffect(Unit) {
        onDispose {
            try {
                speechRecognizer?.destroy()
                speechRecognizer = null
            } catch (_: Exception) {}
        }
    }

    // Auto-read question on new item
    LaunchedEffect(item.id) {
        delay(350)
        onSpeakQuestion()
    }

    fun startListening() {
        onPauseAudio()

        if (!hasPermission) {
            permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
            return
        }

        if (!SpeechRecognizer.isRecognitionAvailable(context)) {
            state = VoiceRecognitionState.Error("আপনার ডিভাইসে স্পিচ রিকগনিশন সার্ভিস পাওয়া যায়নি।")
            return
        }

        try {
            speechRecognizer?.destroy()
            val recognizer = SpeechRecognizer.createSpeechRecognizer(context)
            speechRecognizer = recognizer

            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US")
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "en-US")
                putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, context.packageName)
                putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3)
            }

            recognizer.setRecognitionListener(object : RecognitionListener {
                override fun onReadyForSpeech(params: Bundle?) {
                    state = VoiceRecognitionState.Listening
                }

                override fun onBeginningOfSpeech() {}
                override fun onRmsChanged(rmsdB: Float) {}
                override fun onBufferReceived(buffer: ByteArray?) {}
                override fun onEndOfSpeech() {
                    state = VoiceRecognitionState.Processing
                }

                override fun onError(error: Int) {
                    val msg = when (error) {
                        SpeechRecognizer.ERROR_NO_MATCH -> "কোনো কথা পরিষ্কার বোঝা যায়নি। আবার চেষ্টা করুন।"
                        SpeechRecognizer.ERROR_SPEECH_TIMEOUT -> "কোনো শব্দ শোনা যায়নি। মাইক্রোফোন ট্যাপ করে কথা বলুন।"
                        SpeechRecognizer.ERROR_AUDIO -> "মাইক্রোফোন রেকর্ডিং সমস্যা। অনুগ্রহ করে আবার চেষ্টা করুন।"
                        SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS -> "মাইক্রোফোন ব্যবহারের অনুমতি নেই।"
                        SpeechRecognizer.ERROR_NETWORK -> "ইন্টারনেট কানেকশন চেক করুন।"
                        else -> "দুঃখিত, আবার বলুন (Error: $error)"
                    }
                    state = VoiceRecognitionState.Error(msg)
                }

                override fun onResults(results: Bundle?) {
                    val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    val spoken = matches?.firstOrNull()
                    if (spoken.isNullOrBlank()) {
                        state = VoiceRecognitionState.Error("কিছু শোনা যায়নি, আবার স্পষ্ট করে বলুন।")
                    } else {
                        val evaluation = evaluateVoiceAnswer(spoken, yesAnswer, noAnswer)
                        state = VoiceRecognitionState.Success(evaluation)

                        // Read aloud what the user spoke and the correct answer / try again feedback!
                        coroutineScope.launch {
                            delay(250)
                            onSpeakText(evaluation.feedbackMessage)
                        }
                    }
                }

                override fun onPartialResults(partialResults: Bundle?) {}
                override fun onEvent(eventType: Int, params: Bundle?) {}
            })

            state = VoiceRecognitionState.Listening
            recognizer.startListening(intent)
        } catch (e: Exception) {
            state = VoiceRecognitionState.Error("রিকগনিশন চালু করা সম্ভব হয়নি: ${e.localizedMessage}")
        }
    }

    fun stopListening() {
        try {
            speechRecognizer?.stopListening()
        } catch (_: Exception) {}
        state = VoiceRecognitionState.Idle
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Header: Pair Practice Badge
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = Color(0xFFE11D48).copy(alpha = 0.12f),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Mic,
                            contentDescription = null,
                            tint = Color(0xFFE11D48),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(
                            text = "জোড়ায় ভয়েস প্র্যাকটিস (Pair Practice)",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFE11D48)
                        )
                    }
                }

                Text(
                    text = "Interactive Voice Q&A",
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Question Card Box
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.25f))
            ) {
                Column(Modifier.padding(16.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "🗣️ অ্যাপের প্রশ্ন (App asks):",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Surface(
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f),
                            modifier = Modifier
                                .clip(CircleShape)
                                .clickable { onSpeakQuestion() }
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                                    contentDescription = "প্রশ্ন শুনুন",
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(Modifier.width(4.dp))
                                Text(
                                    text = "শুনুন",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = item.target,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 26.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            // Expected Answer Choices Instructions
            Text(
                text = "যেকোনো একটি উত্তর বেছে নিয়ে মুখে বলুন (Yes অথবা No):",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // Yes Answer Choice
            AnswerChoiceCard(
                label = "Yes উত্তর (ইতিবাচক)",
                text = yesAnswer,
                badgeColor = Color(0xFF00796B),
                onSpeak = onSpeakYes
            )

            // No Answer Choice
            AnswerChoiceCard(
                label = "No উত্তর (নেতিবাচক)",
                text = noAnswer,
                badgeColor = Color(0xFFD97706),
                onSpeak = onSpeakNo
            )

            Spacer(Modifier.height(4.dp))

            // Voice Recognition Control Section & Audio Evaluation Result
            VoiceRecognitionControls(
                state = state,
                onStartListening = { startListening() },
                onStopListening = { stopListening() },
                onRetry = { startListening() },
                onSpeakText = onSpeakText,
                onNext = onNext,
                hasNext = hasNext
            )
        }
    }
}

@Composable
private fun AnswerChoiceCard(
    label: String,
    text: String,
    badgeColor: Color,
    onSpeak: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = badgeColor.copy(alpha = 0.06f),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, badgeColor.copy(alpha = 0.25f))
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Surface(
                    color = badgeColor.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = label,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = badgeColor,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
                Spacer(Modifier.height(4.dp))
                Text(
                    text = text,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            IconButton(
                onClick = onSpeak,
                modifier = Modifier.size(34.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                    contentDescription = "Play Pronunciation",
                    tint = badgeColor,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

@Composable
private fun VoiceRecognitionControls(
    state: VoiceRecognitionState,
    onStartListening: () -> Unit,
    onStopListening: () -> Unit,
    onRetry: () -> Unit,
    onSpeakText: (String) -> Unit,
    onNext: () -> Unit,
    hasNext: Boolean
) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.18f,
        animationSpec = infiniteRepeatable(
            animation = tween(650, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulseScale"
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        when (state) {
            is VoiceRecognitionState.Idle -> {
                Surface(
                    onClick = onStartListening,
                    shape = RoundedCornerShape(16.dp),
                    color = Color(0xFF00796B),
                    shadowElevation = 3.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(vertical = 14.dp, horizontal = 20.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = Color.White.copy(alpha = 0.2f),
                            modifier = Modifier.size(32.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.Mic,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                        Spacer(Modifier.width(12.dp))
                        Text(
                            text = "🎤 মাইক্রোফোন ট্যাপ করে উত্তর বলুন",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }

            is VoiceRecognitionState.Listening -> {
                Surface(
                    onClick = onStopListening,
                    shape = RoundedCornerShape(16.dp),
                    color = Color(0xFFE11D48),
                    shadowElevation = 4.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(vertical = 14.dp, horizontal = 20.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(34.dp)
                                .scale(pulseScale)
                                .background(Color.White.copy(alpha = 0.25f), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Mic,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Spacer(Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "🔴 শুনছি... আপনার উত্তরটি বলুন...",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "শেষ করতে ট্যাপ করুন",
                                fontSize = 11.sp,
                                color = Color.White.copy(alpha = 0.85f)
                            )
                        }
                    }
                }
            }

            is VoiceRecognitionState.Processing -> {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CircularProgressIndicator(modifier = Modifier.size(22.dp), strokeWidth = 2.5.dp)
                    Spacer(Modifier.width(10.dp))
                    Text(
                        text = "উত্তর যাচাই করা হচ্ছে...",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            is VoiceRecognitionState.Error -> {
                Surface(
                    color = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(Modifier.padding(14.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.ErrorOutline,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.error,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(
                                text = state.message,
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.onErrorContainer
                            )
                        }
                        Spacer(Modifier.height(10.dp))
                        Button(
                            onClick = onRetry,
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("আবার চেষ্টা করুন")
                        }
                    }
                }
            }

            is VoiceRecognitionState.Success -> {
                val eval = state.evaluation
                val isPassed = eval.isPassed
                val accentColor = if (isPassed) Color(0xFF00796B) else Color(0xFFE11D48)

                Surface(
                    color = accentColor.copy(alpha = 0.08f),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.5.dp, accentColor.copy(alpha = 0.5f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        // Title row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.weight(1f)
                            ) {
                                Icon(
                                    imageVector = if (isPassed) Icons.Default.CheckCircle else Icons.Default.Close,
                                    contentDescription = null,
                                    tint = accentColor,
                                    modifier = Modifier.size(22.dp)
                                )
                                Spacer(Modifier.width(8.dp))
                                Text(
                                    text = if (isPassed) "✅ উত্তর সঠিক হয়েছে!" else "❌ উত্তরটি সঠিক হয়নি (Try Again)",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = accentColor
                                )
                            }

                            Surface(
                                color = accentColor.copy(alpha = 0.15f),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Text(
                                    text = "${eval.accuracyPercent}% Match",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = accentColor,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }

                        // Replay audio feedback button
                        Surface(
                            onClick = { onSpeakText(eval.feedbackMessage) },
                            shape = RoundedCornerShape(10.dp),
                            color = accentColor.copy(alpha = 0.12f),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                                    contentDescription = "ফিডব্যাক শুনুন",
                                    tint = accentColor,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(Modifier.width(8.dp))
                                Text(
                                    text = "ফিডব্যাক আবার অডিওতে শুনুন",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = accentColor
                                )
                            }
                        }

                        // What user said
                        Surface(
                            color = MaterialTheme.colorScheme.surface,
                            shape = RoundedCornerShape(10.dp),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = "🗣️ আপনি বলেছেন (You spoke):",
                                        fontSize = 11.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Spacer(Modifier.height(2.dp))
                                    Text(
                                        text = "\"${eval.spokenText}\"",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }

                                IconButton(
                                    onClick = { onSpeakText("You said: ${eval.spokenText}") },
                                    modifier = Modifier.size(32.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                                        contentDescription = "Play spoken text",
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                        }

                        // Correct answer guidance when wrong OR confirmed matched reply
                        if (!isPassed) {
                            Surface(
                                color = MaterialTheme.colorScheme.surface,
                                shape = RoundedCornerShape(10.dp),
                                border = BorderStroke(1.dp, Color(0xFF00796B).copy(alpha = 0.35f)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = "💡 সঠিক উত্তরটি শুনুন (Correct Answer):",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            color = Color(0xFF00796B)
                                        )
                                        Spacer(Modifier.height(2.dp))
                                        Text(
                                            text = "\"${eval.expectedAnswer}\"",
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                    }

                                    IconButton(
                                        onClick = { onSpeakText("The correct answer is: ${eval.expectedAnswer}") },
                                        modifier = Modifier.size(32.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                                            contentDescription = "Play correct answer",
                                            tint = Color(0xFF00796B),
                                            modifier = Modifier.size(18.dp)
                                        )
                                    }
                                }
                            }
                        } else {
                            val typeLabel = if (eval.matchedType == MatchedAnswerType.YES) "🟢 Yes উত্তর শনাক্ত হয়েছে" else "🔵 No উত্তর শনাক্ত হয়েছে"
                            Text(
                                text = typeLabel,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = accentColor
                            )
                        }

                        // Action Buttons: Try Again & Next Question
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            if (!isPassed) {
                                Button(
                                    onClick = onRetry,
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE11D48)),
                                    modifier = Modifier.weight(1.2f)
                                ) {
                                    Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(16.dp))
                                    Spacer(Modifier.width(6.dp))
                                    Text("আবার বলুন (Try Again)")
                                }

                                if (hasNext) {
                                    OutlinedButton(
                                        onClick = onNext,
                                        modifier = Modifier.weight(0.8f)
                                    ) {
                                        Text("এড়িয়ে যান")
                                        Spacer(Modifier.width(4.dp))
                                        Icon(Icons.Default.SkipNext, contentDescription = null, modifier = Modifier.size(16.dp))
                                    }
                                }
                            } else {
                                OutlinedButton(
                                    onClick = onRetry,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(16.dp))
                                    Spacer(Modifier.width(4.dp))
                                    Text("আবার বলুন")
                                }

                                if (hasNext) {
                                    Button(
                                        onClick = onNext,
                                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00796B)),
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Text("পরের প্রশ্ন")
                                        Spacer(Modifier.width(4.dp))
                                        Icon(Icons.Default.SkipNext, contentDescription = null, modifier = Modifier.size(16.dp))
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Normalizes punctuation and standard English spoken contractions.
 */
private fun normalizeVoiceText(text: String): String {
    return text.lowercase(Locale.ROOT)
        .replace("there's", "there is")
        .replace("there isn't", "there is not")
        .replace("isn't", "is not")
        .replace("aren't", "are not")
        .replace("don't", "do not")
        .replace("doesn't", "does not")
        .replace("haven't", "have not")
        .replace("hasn't", "has not")
        .replace("can't", "cannot")
        .replace("i'm", "i am")
        .replace("i've", "i have")
        .replace("you're", "you are")
        .replace("we're", "we are")
        .replace("they're", "they are")
        .replace("[^a-z0-9\\s]".toRegex(), " ")
        .replace("\\s+".toRegex(), " ")
        .trim()
}

/**
 * Computes sentence similarity using Unigram (F1) and Bigram sequence overlap.
 * No artificial score boosting; completely authentic similarity.
 */
private fun computeSentenceSimilarity(spokenWords: List<String>, targetWords: List<String>): Int {
    if (spokenWords.isEmpty() || targetWords.isEmpty()) return 0

    // 1. Unigram (word) overlap
    val targetSet = targetWords.toSet()
    val matchCount = spokenWords.count { it in targetSet }

    val precision = matchCount.toFloat() / spokenWords.size
    val recall = matchCount.toFloat() / targetWords.size
    val f1 = if (precision + recall > 0f) (2 * precision * recall) / (precision + recall) else 0f

    // 2. Bigram (consecutive words sequence) overlap
    val spokenBigrams = if (spokenWords.size > 1) {
        (0 until spokenWords.size - 1).map { "${spokenWords[it]} ${spokenWords[it + 1]}" }.toSet()
    } else emptySet()

    val targetBigrams = if (targetWords.size > 1) {
        (0 until targetWords.size - 1).map { "${targetWords[it]} ${targetWords[it + 1]}" }.toSet()
    } else emptySet()

    val bigramMatch = if (targetBigrams.isNotEmpty()) {
        spokenBigrams.count { it in targetBigrams }.toFloat() / targetBigrams.size
    } else f1

    val combined = (f1 * 0.7f + bigramMatch * 0.3f) * 100f
    return combined.toInt().coerceIn(0, 100)
}

/**
 * Smart Evaluator: Checks spoken words against both Yes and No expected answers.
 * Implements strict polarity verification, contradiction detection, and high-accuracy word sequence similarity.
 */
private fun evaluateVoiceAnswer(spoken: String, yesAnswer: String, noAnswer: String): VoiceEvaluation {
    val normSpoken = normalizeVoiceText(spoken)
    val normYes = normalizeVoiceText(yesAnswer)
    val normNo = normalizeVoiceText(noAnswer)

    val spokenWords = normSpoken.split(" ").filter { it.isNotBlank() }
    val yesWords = normYes.split(" ").filter { it.isNotBlank() }
    val noWords = normNo.split(" ").filter { it.isNotBlank() }

    if (spokenWords.isEmpty()) {
        return VoiceEvaluation(
            spokenText = spoken,
            matchedType = MatchedAnswerType.UNKNOWN,
            expectedAnswer = yesAnswer,
            accuracyPercent = 0,
            isPassed = false,
            feedbackMessage = "Nothing was detected. Please tap the microphone and speak your answer clearly."
        )
    }

    val firstWord = spokenWords.firstOrNull().orEmpty()
    val startsWithYes = firstWord == "yes" || firstWord == "yeah" || firstWord == "yep"
    val startsWithNo = firstWord == "no" || firstWord == "nope"

    val negationWords = setOf("not", "never", "cannot")
    val hasNegation = spokenWords.any { it in negationWords }

    // Case 1: Contradiction - "Yes" combined with negation (e.g., "Yes, I don't wake up...")
    if (startsWithYes && hasNegation) {
        return VoiceEvaluation(
            spokenText = spoken,
            matchedType = MatchedAnswerType.UNKNOWN,
            expectedAnswer = yesAnswer,
            accuracyPercent = 0,
            isPassed = false,
            feedbackMessage = "You said: \"$spoken\". You cannot combine 'Yes' with negative words like 'don't'. The correct answer is: \"$yesAnswer\", or \"$noAnswer\". Please try again."
        )
    }

    // Case 2: Contradiction - "No" without negation (e.g., "No, I wake up early...")
    if (startsWithNo && !hasNegation) {
        return VoiceEvaluation(
            spokenText = spoken,
            matchedType = MatchedAnswerType.UNKNOWN,
            expectedAnswer = noAnswer,
            accuracyPercent = 0,
            isPassed = false,
            feedbackMessage = "You said: \"$spoken\". A negative answer requires a negative verb like 'don't' or 'isn't'. The correct answer is: \"$noAnswer\". Please try again."
        )
    }

    // Case 3: Starts with neither Yes nor No
    if (!startsWithYes && !startsWithNo) {
        return VoiceEvaluation(
            spokenText = spoken,
            matchedType = MatchedAnswerType.UNKNOWN,
            expectedAnswer = yesAnswer,
            accuracyPercent = 10,
            isPassed = false,
            feedbackMessage = "You said: \"$spoken\". Please start your answer with either 'Yes' or 'No'. Please try again."
        )
    }

    // Only evaluate against the matching polarity answer
    val (targetWords, expectedAnswer, candidateType) = if (startsWithYes) {
        Triple(yesWords, yesAnswer, MatchedAnswerType.YES)
    } else {
        Triple(noWords, noAnswer, MatchedAnswerType.NO)
    }

    val score = computeSentenceSimilarity(spokenWords, targetWords)
    val isPassed = score >= 78

    val feedback = if (isPassed) {
        "You said: \"$spoken\". That is correct!"
    } else {
        "You said: \"$spoken\". The correct answer is: \"$expectedAnswer\". Please try again."
    }

    return VoiceEvaluation(
        spokenText = spoken,
        matchedType = if (isPassed) candidateType else MatchedAnswerType.UNKNOWN,
        expectedAnswer = expectedAnswer,
        accuracyPercent = score,
        isPassed = isPassed,
        feedbackMessage = feedback
    )
}
