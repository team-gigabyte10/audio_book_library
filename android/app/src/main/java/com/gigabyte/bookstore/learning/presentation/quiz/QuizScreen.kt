package com.gigabyte.bookstore.learning.presentation.quiz

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Backspace
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.data.ads.FacebookRewardAdManager
import com.gigabyte.bookstore.data.ads.SmartInterstitialAdManager
import com.gigabyte.bookstore.learning.domain.model.LessonUnlock
import com.gigabyte.bookstore.learning.domain.quiz.QuizQuestion
import com.gigabyte.bookstore.presentation.components.AppBackground
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar

private val CorrectColor = Color(0xFF2E7D32)
private val WrongColor = Color(0xFFC62828)

@Composable
fun QuizScreen(
    viewModel: QuizViewModel,
    onBackClick: () -> Unit,
    onRetry: () -> Unit,
    onOpenNextLesson: (String) -> Unit
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = { Text("কুইজ", color = Color.White, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "ফিরে যান", tint = Color.White)
                    }
                }
            )
        }
    ) { padding ->
        AppBackground(modifier = Modifier.fillMaxSize().padding(padding)) {
            val question = state.current
            when {
                state.isLoading -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
                state.finished -> ResultPanel(
                    state = state,
                    lessonId = viewModel.lessonId,
                    onBack = onBackClick,
                    onRetry = onRetry,
                    onOpenNextLesson = onOpenNextLesson
                )
                question != null -> Column(Modifier.fillMaxSize()) {
                    LinearProgressIndicator(
                        progress = { (state.index + 1).toFloat() / state.questions.size },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Column(
                        Modifier
                            .weight(1f)
                            .verticalScroll(rememberScrollState())
                            .padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Text("প্রশ্ন ${state.index + 1} / ${state.questions.size}", style = MaterialTheme.typography.labelMedium)
                        QuestionBody(question, state, viewModel)
                        Feedback(question, state.lastCorrect)
                    }
                    if (state.lastCorrect != null) {
                        Button(
                            onClick = viewModel::next,
                            modifier = Modifier.fillMaxWidth().padding(16.dp)
                        ) {
                            Text(if (state.index + 1 < state.questions.size) "পরের প্রশ্ন" else "ফলাফল দেখুন")
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun QuestionBody(question: QuizQuestion, state: QuizUiState, viewModel: QuizViewModel) {
    when (question) {
        is QuizQuestion.ListenPickBangla -> {
            Text("শুনে সঠিক বাংলা অর্থ বেছে নিন", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            FilledTonalButton(onClick = viewModel::playPrompt) {
                Icon(Icons.AutoMirrored.Filled.VolumeUp, contentDescription = null)
                Text("  আবার শুনুন")
            }
            Options(question.options, question.answerIndex, state, viewModel::selectOption)
        }
        is QuizQuestion.BanglaPickTarget -> {
            Text("সঠিক ইংরেজি বাক্যটি বেছে নিন", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(question.item.bn.orEmpty(), fontSize = 22.sp, lineHeight = 30.sp)
            Options(question.options, question.answerIndex, state, viewModel::selectOption)
        }
        is QuizQuestion.FillBlank -> {
            Text("খালি জায়গায় সঠিক শব্দ বসান", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(question.prompt, fontSize = 22.sp, lineHeight = 30.sp, fontWeight = FontWeight.SemiBold)
            question.item.bn?.let { Text(it, style = MaterialTheme.typography.bodyMedium) }
            Options(question.options, question.answerIndex, state, viewModel::selectOption)
        }
        is QuizQuestion.ArrangeWords -> {
            Text("শব্দগুলো সঠিক ক্রমে সাজান", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            question.item.bn?.let { Text(it, fontSize = 20.sp, lineHeight = 28.sp) }
            OutlinedCard(Modifier.fillMaxWidth().heightIn(min = 64.dp)) {
                Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        state.arranged.joinToString(" ") { question.shuffled[it] },
                        fontSize = 20.sp,
                        modifier = Modifier.weight(1f)
                    )
                    if (state.arranged.isNotEmpty() && state.lastCorrect == null) {
                        IconButton(onClick = viewModel::removeLastWord) {
                            Icon(Icons.AutoMirrored.Filled.Backspace, contentDescription = "শেষ শব্দ মুছুন")
                        }
                    }
                }
            }
            FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                question.shuffled.forEachIndexed { i, word ->
                    if (i !in state.arranged) {
                        AssistChip(onClick = { viewModel.tapWord(i) }, label = { Text(word, fontSize = 18.sp) })
                    }
                }
            }
            if (state.lastCorrect == null) {
                Button(
                    onClick = viewModel::checkArrangement,
                    enabled = state.arranged.size == question.answer.size
                ) { Text("যাচাই করুন") }
            }
        }
    }
}

@Composable
private fun Options(options: List<String>, answerIndex: Int, state: QuizUiState, onSelect: (Int) -> Unit) {
    options.forEachIndexed { i, option ->
        val answered = state.lastCorrect != null
        val border = when {
            answered && i == answerIndex -> BorderStroke(2.dp, CorrectColor)
            answered && i == state.selected -> BorderStroke(2.dp, WrongColor)
            else -> null
        }
        OutlinedButton(
            onClick = { onSelect(i) },
            enabled = !answered,
            border = border ?: BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(option, modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp), fontSize = 17.sp)
        }
    }
}

@Composable
private fun Feedback(question: QuizQuestion, correct: Boolean?) {
    if (correct == null) return
    Column {
        Text(
            if (correct) "সঠিক!" else "ভুল হয়েছে",
            color = if (correct) CorrectColor else WrongColor,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Text("সঠিক উত্তর: ${question.item.target}", style = MaterialTheme.typography.bodyLarge)
        question.item.bn?.let { Text(it, style = MaterialTheme.typography.bodyMedium) }
    }
}

@Composable
private fun ResultPanel(
    state: QuizUiState,
    lessonId: String,
    onBack: () -> Unit,
    onRetry: () -> Unit,
    onOpenNextLesson: (String) -> Unit
) {
    val context = LocalContext.current
    var isClaimingReward by remember { mutableStateOf(false) }
    var rewardClaimed by remember { mutableStateOf(false) }
    val isQuran = lessonId.startsWith("qr-")

    Column(
        Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("${state.score}%", fontSize = 56.sp, fontWeight = FontWeight.Bold, color = if (state.passed) CorrectColor else WrongColor)
        Spacer(Modifier.height(8.dp))
        Text(
            if (state.passed) "অভিনন্দন! লেসনটি সম্পন্ন হয়েছে।"
            else "লেসনটি সম্পন্ন করতে ${LessonUnlock.PASS_SCORE}% লাগবে। আবার শুনে চেষ্টা করুন, অথবা পরের লেসনে যান।",
            style = MaterialTheme.typography.titleMedium
        )
        if (state.questions.isNotEmpty()) {
            Text("${state.correctCount} / ${state.questions.size} সঠিক", style = MaterialTheme.typography.bodyMedium)
        }

        // Optional Voluntary Double Reward (Allowed for all non-Quran courses)
        if (!isQuran && state.passed && !rewardClaimed) {
            Spacer(Modifier.height(16.dp))
            OutlinedCard(
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, Color(0xFFF59E0B)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "🎁 ২X রিওয়ার্ড কয়েন বোনাস",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFD97706)
                        )
                        Text(
                            text = "একটি ছোট ভিডিও দেখে দ্বিগুণ কয়েন নিন (ঐচ্ছিক)",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Button(
                        onClick = {
                            val activity = context as? Activity
                            if (activity != null) {
                                isClaimingReward = true
                                FacebookRewardAdManager.getInstance(context).showAd(
                                    activity = activity,
                                    onRewardEarned = {
                                        isClaimingReward = false
                                        rewardClaimed = true
                                        Toast.makeText(context, "🎉 অভিনন্দন! ২X রিওয়ার্ড বোনাস সফলভাবে যুক্ত হয়েছে!", Toast.LENGTH_LONG).show()
                                    },
                                    onClosed = { isClaimingReward = false },
                                    onError = {
                                        isClaimingReward = false
                                        rewardClaimed = true
                                        Toast.makeText(context, "বোনাস কয়েন যুক্ত হয়েছে! 🎉", Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }
                        },
                        enabled = !isClaimingReward,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        if (isClaimingReward) {
                            CircularProgressIndicator(modifier = Modifier.size(14.dp), strokeWidth = 2.dp, color = Color.White)
                        } else {
                            Text("২X নিন", fontSize = 11.sp)
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(24.dp))
        val next = state.nextLessonId
        if (next != null) {
            Button(
                onClick = {
                    val activity = context as? Activity
                    if (activity != null) {
                        SmartInterstitialAdManager.getInstance(context).showInterstitialIfReady(activity, forceIgnoreCounter = true) {
                            onOpenNextLesson(next)
                        }
                    } else {
                        onOpenNextLesson(next)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) { Text("পরের লেসন") }
            Spacer(Modifier.height(8.dp))
        }
        if (!state.passed) {
            Button(onClick = onRetry, modifier = Modifier.fillMaxWidth()) { Text("আবার কুইজ দিন") }
            Spacer(Modifier.height(8.dp))
        }
        OutlinedButton(
            onClick = {
                val activity = context as? Activity
                if (activity != null) {
                    SmartInterstitialAdManager.getInstance(context).showInterstitialIfReady(activity, forceIgnoreCounter = true) {
                        onBack()
                    }
                } else {
                    onBack()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("লেসনে ফিরে যান") }
    }
}
