package com.gigabyte.bookstore.learning.presentation.home

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.learning.data.content.ContentState
import com.gigabyte.bookstore.presentation.components.AppBackground
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar
import com.gigabyte.bookstore.ui.theme.GoldenAccent

@Composable
fun LearnHomeScreen(
    viewModel: LearnHomeViewModel,
    language: String = "english",
    onBackClick: () -> Unit,
    onOpenCourse: (String) -> Unit,
    onOpenIntro: (String) -> Unit,
    onOpenKanaChart: () -> Unit = {},
    onOpenAlphabetChart: (String) -> Unit = {},
    onOpenNumbersChart: (String) -> Unit = {}
) {
    val contentState by viewModel.contentState.collectAsStateWithLifecycle()
    val syllabus by viewModel.syllabus.collectAsStateWithLifecycle()
    val isSpeaking by viewModel.isSpeaking.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val isJapanese = language.equals("japanese", ignoreCase = true)
    val isUrdu = language.equals("urdu", ignoreCase = true)
    val isHindi = language.equals("hindi", ignoreCase = true)
    val isGerman = language.equals("german", ignoreCase = true)

    DisposableEffect(language) {
        viewModel.playWelcomeGreeting(language = language)
        onDispose {
            viewModel.stopWelcomeGreeting()
        }
    }

    val presentParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("en-") && it.part.isEnabled } }
    val presentPartCount = presentParts.size.coerceAtLeast(1)
    val presentLessonCount = presentParts.sumOf { it.lessons.size }.let { if (it > 0) it else 20 }
    val presentSentenceCount = presentParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 400 }

    val pastParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("past-") && it.part.isEnabled } }
    val pastPartCount = pastParts.size.coerceAtLeast(1)
    val pastLessonCount = pastParts.sumOf { it.lessons.size }.let { if (it > 0) it else 35 }
    val pastSentenceCount = pastParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 260 }

    val futureParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("fut-") && it.part.isEnabled } }
    val futurePartCount = futureParts.size.coerceAtLeast(1)
    val futureLessonCount = futureParts.sumOf { it.lessons.size }.let { if (it > 0) it else 31 }
    val futureSentenceCount = futureParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 230 }

    val urStandardParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("ur-std-") && it.part.isEnabled } }
    val urStandardPartCount = urStandardParts.size.coerceAtLeast(1)
    val urStandardLessonCount = urStandardParts.sumOf { it.lessons.size }.let { if (it > 0) it else 105 }
    val urStandardSentenceCount = urStandardParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 900 }

    val urA2Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("ur-a2-") && it.part.isEnabled } }
    val urA2PartCount = urA2Parts.size.coerceAtLeast(1)
    val urA2LessonCount = urA2Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 60 }
    val urA2SentenceCount = urA2Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 480 }

    val urB1Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("ur-b1-") && it.part.isEnabled } }
    val urB1PartCount = urB1Parts.size.coerceAtLeast(1)
    val urB1LessonCount = urB1Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val urB1SentenceCount = urB1Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val urB2Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("ur-b2-") && it.part.isEnabled } }
    val urB2PartCount = urB2Parts.size.coerceAtLeast(1)
    val urB2LessonCount = urB2Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val urB2SentenceCount = urB2Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val hiStandardParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("hi-std-") && it.part.isEnabled } }
    val hiStandardPartCount = hiStandardParts.size.coerceAtLeast(1)
    val hiStandardLessonCount = hiStandardParts.sumOf { it.lessons.size }.let { if (it > 0) it else 105 }
    val hiStandardSentenceCount = hiStandardParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 1100 }

    val hiA2Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("hi-a2-") && it.part.isEnabled } }
    val hiA2PartCount = hiA2Parts.size.coerceAtLeast(1)
    val hiA2LessonCount = hiA2Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 60 }
    val hiA2SentenceCount = hiA2Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 480 }

    val hiB1Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("hi-b1-") && it.part.isEnabled } }
    val hiB1PartCount = hiB1Parts.size.coerceAtLeast(1)
    val hiB1LessonCount = hiB1Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val hiB1SentenceCount = hiB1Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val deStandardParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("de-std-") && it.part.isEnabled } }
    val deStandardPartCount = deStandardParts.size.coerceAtLeast(1)
    val deStandardLessonCount = deStandardParts.sumOf { it.lessons.size }.let { if (it > 0) it else 105 }
    val deStandardSentenceCount = deStandardParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 1200 }

    val deA2Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("de-a2-") && it.part.isEnabled } }
    val deA2PartCount = deA2Parts.size.coerceAtLeast(1)
    val deA2LessonCount = deA2Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 60 }
    val deA2SentenceCount = deA2Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 480 }

    val deB1Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("de-b1-") && it.part.isEnabled } }
    val deB1PartCount = deB1Parts.size.coerceAtLeast(1)
    val deB1LessonCount = deB1Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val deB1SentenceCount = deB1Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val deSpParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("de-sp-") && it.part.isEnabled } }
    val deSpPartCount = deSpParts.size.coerceAtLeast(1)
    val deSpLessonCount = deSpParts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val deSpSentenceCount = deSpParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val jpStandardParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("jp-std-") && it.part.isEnabled } }
    val jpStandardPartCount = jpStandardParts.size.coerceAtLeast(1)
    val jpStandardLessonCount = jpStandardParts.sumOf { it.lessons.size }.let { if (it > 0) it else 110 }
    val jpStandardSentenceCount = jpStandardParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 900 }

    val jpN4Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("jp-n4-") && it.part.isEnabled } }
    val jpN4PartCount = jpN4Parts.size.coerceAtLeast(1)
    val jpN4LessonCount = jpN4Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 60 }
    val jpN4SentenceCount = jpN4Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 480 }

    val jpN3Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("jp-n3-") && it.part.isEnabled } }
    val jpN3PartCount = jpN3Parts.size.coerceAtLeast(1)
    val jpN3LessonCount = jpN3Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val jpN3SentenceCount = jpN3Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val jpFoundationsParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("jp-foundations-") && it.part.isEnabled } }
    val jpFoundationsPartCount = jpFoundationsParts.size.coerceAtLeast(1)
    val jpFoundationsLessonCount = jpFoundationsParts.sumOf { it.lessons.size }.let { if (it > 0) it else 60 }
    val jpFoundationsSentenceCount = jpFoundationsParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 185 }

    val jpPastParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("jp-past-") && it.part.isEnabled } }
    val jpPastPartCount = jpPastParts.size.coerceAtLeast(1)
    val jpPastLessonCount = jpPastParts.sumOf { it.lessons.size }.let { if (it > 0) it else 20 }
    val jpPastSentenceCount = jpPastParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 62 }

    val jpCasualParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("jp-casual-") && it.part.isEnabled } }
    val jpCasualPartCount = jpCasualParts.size.coerceAtLeast(1)
    val jpCasualLessonCount = jpCasualParts.sumOf { it.lessons.size }.let { if (it > 0) it else 14 }
    val jpCasualSentenceCount = jpCasualParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 41 }

    val jpBusinessParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("jp-business-") && it.part.isEnabled } }
    val jpBusinessPartCount = jpBusinessParts.size.coerceAtLeast(1)
    val jpBusinessLessonCount = jpBusinessParts.sumOf { it.lessons.size }.let { if (it > 0) it else 8 }
    val jpBusinessSentenceCount = jpBusinessParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 20 }

    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = {
                    Column {
                        Text(
                            text = when {
                                isUrdu -> "উর্দু স্পোকেন কোর্স"
                                isHindi -> "হিন্দি স্পোকেন কোর্স"
                                isGerman -> "জার্মান স্পোকেন কোর্স"
                                isJapanese -> "জাপানিজ স্পোকেন মাস্টারক্লাস"
                                else -> "স্পোকেন ইংলিশ মাস্টারক্লাস"
                            },
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = when {
                                isUrdu -> "বাংলা থেকে সহজ নিয়মে শূন্য থেকে উর্দু বলা"
                                isHindi -> "বাংলা থেকে সহজ নিয়মে শূন্য থেকে হিন্দি বলা"
                                isGerman -> "বাংলা থেকে সহজ নিয়মে শূন্য থেকে জার্মান বলা"
                                isJapanese -> "বাংলা থেকে সহজ নিয়মে ফ্লুয়েন্ট জাপানিজ (JLPT N5-N2)"
                                else -> "বাংলা থেকে সহজ নিয়মে ফ্লুয়েন্ট ইংরেজি"
                            },
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "ফিরে যান")
                    }
                }
            )
        }
    ) { padding ->
        AppBackground(modifier = Modifier.fillMaxSize().padding(padding)) {
            when (val state = contentState) {
                ContentState.Checking -> CenteredMessage {
                    CircularProgressIndicator()
                    Spacer(Modifier.height(12.dp))
                    Text("কোর্স প্রস্তুত হচ্ছে...")
                }
                is ContentState.Importing -> CenteredMessage {
                    Text("প্রথমবার কোর্স সেটআপ হচ্ছে", style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(16.dp))
                    if (state.total > 0) {
                        LinearProgressIndicator(
                            progress = { state.done.toFloat() / state.total },
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )
                        Spacer(Modifier.height(8.dp))
                        Text("${state.done} / ${state.total} লেসন", style = MaterialTheme.typography.bodySmall)
                    } else {
                        LinearProgressIndicator(modifier = Modifier.fillMaxWidth(0.8f))
                    }
                }
                is ContentState.Failed -> CenteredMessage {
                    Text("কোর্স লোড করা যায়নি", style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(8.dp))
                    Text(state.message, style = MaterialTheme.typography.bodySmall, textAlign = TextAlign.Center)
                    Spacer(Modifier.height(16.dp))
                    Button(onClick = viewModel::retry) { Text("আবার চেষ্টা করুন") }
                }
                ContentState.Ready -> LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    if (isUrdu) {
                        item {
                            WelcomeBanner(
                                text = "উর্দু স্পোকেন কোর্সে আপনাকে স্বাগতম! প্রতিটি অক্ষর, শব্দ ও বাক্য শুনুন এবং জোরে জোরে বলুন।",
                                isSpeaking = isSpeaking,
                                onPlayTts = { viewModel.playWelcomeGreeting(language = "urdu", force = true) },
                                onStopTts = { viewModel.stopWelcomeGreeting() }
                            )
                        }

                        // Urdu Alphabet Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇵🇰 হুরুফে তাহাজ্জি · ৫৩ ধ্বনি",
                                title = "উর্দু বর্ণমালা ও উচ্চারণ চার্ট (حروف تہجی)",
                                description = "৩৯টি একক হরফ ও ১৪টি দো-চশমী মহাপ্রাণ যুক্তধ্বনি, রোমাজি ও বাংলা উচ্চারণ। প্রতিটি হরফে ট্যাপ করলেই সঠিক অডিও শুনুন।",
                                accentColor = Color(0xFF1B5E20),
                                partCount = 2,
                                lessonCount = 53,
                                sentenceCount = 53,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "চার্ট দেখুন",
                                customPills = listOf("🇵🇰 ৫৩ হরফ", "🔊 সব অডিও", "⚡ ধীর ও স্বাভাবিক গতি"),
                                onClick = { onOpenAlphabetChart("urdu") }
                            )
                        }

                        // Urdu Numbers 1-100 Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇵🇰 সংখ্যা ও গণনা · ১ থেকে ১০০",
                                title = "১ থেকে ১০০ উর্দু সংখ্যা ও গণনা (اردو گنتی)",
                                description = "১ থেকে ১০০ পর্যন্ত প্রতিটি সংখ্যার উর্দু লিপি, সংখ্যা ও বাংলা উচ্চারণ। প্রতিটি সংখ্যায় ট্যাপ করলেই সঠিক অডিও শুনুন।",
                                accentColor = Color(0xFF1B5E20),
                                partCount = 5,
                                lessonCount = 100,
                                sentenceCount = 100,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "সংখ্যা দেখুন",
                                customPills = listOf("🔢 ১-১০০ গিনতি", "🔊 সব অডিও", "⚡ ধীর ও স্বাভাবিক গতি"),
                                onClick = { onOpenNumbersChart("urdu") }
                            )
                        }

                        // Urdu-Spoken-Curriculum-Plan.md, phase 1: Stage 0 + A1
                        item {
                            MainCourseCard(
                                tag = "🇵🇰 স্ট্যান্ডার্ড কোর্স: শূন্য থেকে A1",
                                title = "শূন্য থেকে উর্দু বলা (অক্ষর, উচ্চারণ ও A1 স্পিকিং)",
                                description = "উর্দু হরফ, নতুন ধ্বনি (ق خ غ ز ف), বাংলা-উর্দু মিল শব্দ, জরুরি বাক্য, তারপর A1-এর ১৫টি ইউনিট ও স্পিকিং টেস্ট।",
                                accentColor = Color(0xFF1B5E20),
                                partCount = urStandardPartCount,
                                lessonCount = urStandardLessonCount,
                                sentenceCount = urStandardSentenceCount,
                                onClick = { onOpenCourse("ur_standard") }
                            )
                        }

                        // Urdu A2 Course Card
                        item {
                            MainCourseCard(
                                tag = "🇵🇰 স্ট্যান্ডার্ড কোর্স: লেভেল A2",
                                title = "উর্দু A2: অতীত কাল, 'নে' নিয়ম ও কর্মক্ষেত্র",
                                description = "অতীতের কাজ, সকর্মক ক্রিয়ার 'نے' নিয়ম, ইচ্ছা-প্রয়োজন, তুলনা, স্বাস্থ্য, দিকনির্দেশনা ও কর্মক্ষেত্রের বাস্তব স্পোকেন।",
                                accentColor = Color(0xFF2E7D32),
                                partCount = urA2PartCount,
                                lessonCount = urA2LessonCount,
                                sentenceCount = urA2SentenceCount,
                                customPills = listOf("🇵🇰 ১৫টি পার্ট", "🗣️ অতীত ও نے নিয়ম", "🏢 অফিস ও বাস্তব কাজ"),
                                onClick = { onOpenCourse("ur_a2") }
                            )
                        }

                        // Urdu B1 Course Card
                        item {
                            MainCourseCard(
                                tag = "🇵🇰 স্ট্যান্ডার্ড কোর্স: লেভেল B1",
                                title = "উর্দু B1: শর্ত, অনুমান, যুক্তি ও সাবলীল স্পোকেন",
                                description = "শর্তসাপেক্ষ বাক্য (যদি...তবে), সম্বন্ধসূচক বাক্য, পরোক্ষ উক্তি, কর্মবাচ্য, প্রযোজক ক্রিয়া, অভিমত প্রকাশ ও প্রবাদ-বাগধারা।",
                                accentColor = Color(0xFF1B5E20),
                                partCount = urB1PartCount,
                                lessonCount = urB1LessonCount,
                                sentenceCount = urB1SentenceCount,
                                customPills = listOf("🇵🇰 ১৬টি পার্ট", "🧠 শর্ত ও মতামত", "💬 সাবলীল ইন্টারমিডিয়েট"),
                                onClick = { onOpenCourse("ur_b1") }
                            )
                        }

                        // Urdu B2 Course Card
                        item {
                            MainCourseCard(
                                tag = "🇵🇰 স্ট্যান্ডার্ড কোর্স: লেভেল B2",
                                title = "উর্দু B2: মার্জিত শিষ্টাচার, اضافত ও পেশাদার উর্দু",
                                description = "উচ্চাঙ্গের ফর্মাল রেজিস্টার, ইযাফত সমাস, চাকরির ইন্টারভিউ, অফিস মিটিং, ব্যবসায়িক দরকষাকষি, সংবাদ বিশ্লেষণ ও টেলিভিশন টকশো বিতর্ক।",
                                accentColor = Color(0xFF004D40),
                                partCount = urB2PartCount,
                                lessonCount = urB2LessonCount,
                                sentenceCount = urB2SentenceCount,
                                customPills = listOf("🇵🇰 ১৬টি পার্ট", "💼 মার্জিত রেজিস্টার ও اضافত", "📺 মিডিয়া ও বিজনেস"),
                                onClick = { onOpenCourse("ur_b2") }
                            )
                        }
                    } else if (isHindi) {
                        item {
                            WelcomeBanner(
                                text = "হিন্দি স্পোকেন কোর্সে আপনাকে স্বাগতম! প্রতিটি অক্ষর, শব্দ ও বাক্য শুনুন এবং জোরে জোরে বলুন।",
                                isSpeaking = isSpeaking,
                                onPlayTts = { viewModel.playWelcomeGreeting(language = "hindi", force = true) },
                                onStopTts = { viewModel.stopWelcomeGreeting() }
                            )
                        }

                        // Hindi Varnamala Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇮🇳 দেবনাগরী বর্ণমালা · ৫৭ ধ্বনি",
                                title = "হিন্দি বর্ণমালা ও উচ্চারণ চার্ট (वर्णमाला)",
                                description = "১৩টি স্বরবর্ণ, ৩৩টি ব্যঞ্জনবর্ণ ও ১১টি যুক্ত/নুক্তা ধ্বনি, রোমাজি ও বাংলা উচ্চারণ। প্রতিটি অক্ষরে ট্যাপ করলেই সঠিক অডিও শুনুন।",
                                accentColor = Color(0xFFE65100),
                                partCount = 3,
                                lessonCount = 57,
                                sentenceCount = 57,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "চার্ট দেখুন",
                                customPills = listOf("🇮🇳 ৫৭ বর্ণ", "🔊 সব অডিও", "⚡ ধীর ও স্বাভাবিক গতি"),
                                onClick = { onOpenAlphabetChart("hindi") }
                            )
                        }

                        // Hindi Numbers 1-100 Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇮🇳 সংখ্যা ও গণনা · ১ থেকে ১০০",
                                title = "১ থেকে ১০০ হিন্দি সংখ্যা ও গণনা (हिंदी गिनती)",
                                description = "১ থেকে ১০০ পর্যন্ত প্রতিটি সংখ্যার দেবনাগরী লিপি, সংখ্যা ও বাংলা উচ্চারণ। প্রতিটি সংখ্যায় ট্যাপ করলেই সঠিক অডিও শুনুন।",
                                accentColor = Color(0xFFE65100),
                                partCount = 5,
                                lessonCount = 100,
                                sentenceCount = 100,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "সংখ্যা দেখুন",
                                customPills = listOf("🔢 ১-১০০ গিনতি", "🔊 সব অডিও", "⚡ ধীর ও স্বাভাবিক গতি"),
                                onClick = { onOpenNumbersChart("hindi") }
                            )
                        }

                        // Hindi-Spoken-Curriculum-Plan.md, phase 1: Stage 0 + A1
                        item {
                            MainCourseCard(
                                tag = "🇮🇳 স্ট্যান্ডার্ড কোর্স: শূন্য থেকে A1",
                                title = "শূন্য থেকে হিন্দি বলা (দেবনগরী, উচ্চারণ ও A1 স্পিকিং)",
                                description = "দেবনগরী বর্ণমালা ও মাত্রা, উচ্চারণ কৌশল (ব/ভ, স/শ, ज़/फ़), বাংলা-হিন্দি মিল ও সাবধান শব্দ, জরুরি বাক্য ও A1-এর ১৫টি ইউনিট।",
                                accentColor = Color(0xFFE65100),
                                partCount = hiStandardPartCount,
                                lessonCount = hiStandardLessonCount,
                                sentenceCount = hiStandardSentenceCount,
                                onClick = { onOpenCourse("hi_standard") }
                            )
                        }

                        // Hindi A2 Course Card
                        item {
                            MainCourseCard(
                                tag = "🇮🇳 স্ট্যান্ডার্ড কোর্স: লেভেল A2",
                                title = "হিন্দি A2: অতীত কাল, 'ने' নিয়ম ও কথোপকথন",
                                description = "অতীত কাল (था/थी/थे), এরগেটিভ कर्ता ও 'ने' নিয়ম, ইচ্ছা ও বাধ্যবাধকতা (चाहिए/पड़ता है), ডাক্তার-হাসপাতাল ও কর্মক্ষেত্রের সম্পূর্ণ স্পোকেন।",
                                accentColor = Color(0xFFBF360C),
                                partCount = hiA2PartCount,
                                lessonCount = hiA2LessonCount,
                                sentenceCount = hiA2SentenceCount,
                                customPills = listOf("🇮🇳 ১৫টি পার্ট", "🗣️ 'ने' নিয়ম ও অতীত কাল", "🏥 হাসপাতাল ও কর্মক্ষেত্র"),
                                onClick = { onOpenCourse("hi_a2") }
                            )
                        }

                        // Hindi B1 Course Card
                        item {
                            MainCourseCard(
                                tag = "🇮🇳 স্ট্যান্ডার্ড কোর্স: লেভেল B1",
                                title = "হিন্দি B1: শর্তসাপেক্ষ বাক্য, সাপেক্ষ পদ ও কর্মবাচ্য",
                                description = "বাস্তব ও কল্পনামূলক শর্ত (अगर ... तो), সম্বন্ধসূচক ও সাপেক্ষ পদ (जो ... वह), পরোক্ষ উক্তি, কর্মবাচ্য, প্রযোজক ক্রিয়া (करवाना) ও বাগধারা।",
                                accentColor = Color(0xFFD84315),
                                partCount = hiB1PartCount,
                                lessonCount = hiB1LessonCount,
                                sentenceCount = hiB1SentenceCount,
                                customPills = listOf("🇮🇳 ১৬টি পার্ট", "🗣️ শর্ত ও সাপেক্ষ পদ", "📝 প্রযোজক ক্রিয়া ও বাগধারা"),
                                onClick = { onOpenCourse("hi_b1") }
                            )
                        }
                    } else if (isGerman) {
                        item {
                            WelcomeBanner(
                                text = "জার্মান স্পোকেন কোর্সে আপনাকে স্বাগতম! প্রতিটি শব্দ ও বাক্য শুনুন এবং জোরে জোরে বলুন।",
                                isSpeaking = isSpeaking,
                                onPlayTts = { viewModel.playWelcomeGreeting(language = "german", force = true) },
                                onStopTts = { viewModel.stopWelcomeGreeting() }
                            )
                        }

                        // German Alphabet Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇩🇪 জার্মান বর্ণমালা · ৩৮ ধ্বনি",
                                title = "জার্মান বর্ণমালা ও উমলাউত চার্ট (Alphabet)",
                                description = "২৬টি বর্ণমালা, ৪টি বিশেষ উমলাউত (Ä, Ö, Ü, ß) ও ৮টি প্রয়োজনীয় ধ্বনিগুচ্ছ। প্রতিটি বর্ণে ট্যাপ করলেই সঠিক জার্মান অডিও শুনুন।",
                                accentColor = Color(0xFF004D40),
                                partCount = 3,
                                lessonCount = 38,
                                sentenceCount = 38,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "চার্ট দেখুন",
                                customPills = listOf("🇩🇪 ৩৮ ধ্বনি", "🔊 সব অডিও", "⚡ ধীর ও স্বাভাবিক গতি"),
                                onClick = { onOpenAlphabetChart("german") }
                            )
                        }

                        // German Numbers 1-100 Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇩🇪 সংখ্যা ও গণনা · ১ থেকে ১০০",
                                title = "১ থেকে ১০০ জার্মান সংখ্যা (Deutsche Zahlen)",
                                description = "১ থেকে ১০০ পর্যন্ত প্রতিটি জার্মান সংখ্যার বানান, উচ্চারণ ও একুশে নিয়ম। প্রতিটি সংখ্যায় ট্যাপ করলেই সঠিক জার্মান অডিও শুনুন।",
                                accentColor = Color(0xFF4527A0),
                                partCount = 5,
                                lessonCount = 100,
                                sentenceCount = 100,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "সংখ্যা দেখুন",
                                customPills = listOf("🔢 ১-১০০ সংখ্যা", "🔊 সব অডিও", "⚡ ধীর ও স্বাভাবিক গতি"),
                                onClick = { onOpenNumbersChart("german") }
                            )
                        }

                        // German-Spoken-Curriculum-Plan.md, phase 1: Stage 0 + A1
                        item {
                            MainCourseCard(
                                tag = "🇩🇪 স্ট্যান্ডার্ড কোর্স: শূন্য থেকে A1",
                                title = "শূন্য থেকে জার্মান বলা (উচ্চারণ, ব্যাকরণ ও A1 স্পিকিং)",
                                description = "জার্মান বর্ণমালা, উমলাউট (ä, ö, ü, ß), der/die/das আর্টিকেল, একুশে নিয়ম (V2) ও A1-এর ১৫টি পূর্ণাঙ্গ ইউনিট।",
                                accentColor = Color(0xFF004D40),
                                partCount = deStandardPartCount,
                                lessonCount = deStandardLessonCount,
                                sentenceCount = deStandardSentenceCount,
                                onClick = { onOpenCourse("de_standard") }
                            )
                        }

                        // German A2 Course Card
                        item {
                            MainCourseCard(
                                tag = "🇩🇪 স্ট্যান্ডার্ড কোর্স: লেভেল A2",
                                title = "জার্মান A2: ডাটিক, দিকনির্দেশনা ও জটিল বাক্য",
                                description = "ডাটিক কেস, উভমুখী অব্যয় (Wechselpräpositionen), ডাক্তারের পরামর্শ, কারণ ও শর্ত (weil, dass, wenn) এবং গোয়েথে A2 প্রস্তুতি।",
                                accentColor = Color(0xFF1B5E20),
                                partCount = deA2PartCount,
                                lessonCount = deA2LessonCount,
                                sentenceCount = deA2SentenceCount,
                                customPills = listOf("🇩🇪 ১৫টি পার্ট", "🗣️ ডাটিক ও কারণ (weil)", "🎯 গোয়েথে A2 স্পিকিং"),
                                onClick = { onOpenCourse("de_a2") }
                            )
                        }

                        // German B1 Course Card
                        item {
                            MainCourseCard(
                                tag = "🇩🇪 স্ট্যান্ডার্ড কোর্স: লেভেল B1",
                                title = "জার্মান B1: প্যাসিভ, কনজুঙ্কটিভ ও গোয়েথে B1 স্পিকিং",
                                description = "Konjunktiv II, Passiv, Relativsätze, ইনফিনিটিভ ক্লজ, চাকরি ও আউসবিল্ডুং ইন্টারভিউ এবং সম্পূর্ণ গোয়েথে B1 স্পিকিং পরীক্ষা মডেল।",
                                accentColor = Color(0xFF0D47A1),
                                partCount = deB1PartCount,
                                lessonCount = deB1LessonCount,
                                sentenceCount = deB1SentenceCount,
                                customPills = listOf("🇩🇪 ১৬টি পার্ট", "🗣️ Passiv & Konjunktiv", "🎯 গোয়েথে B1 স্পিকিং"),
                                onClick = { onOpenCourse("de_b1") }
                            )
                        }

                        // German Specialist Professional Track Card (Nursing & Higher Education)
                        item {
                            MainCourseCard(
                                tag = "🇩🇪 স্পেশালিস্ট প্রফেশনাল কোর্স (B2/C1 প্রিপারেশন)",
                                title = "জার্মান স্পেশালিস্ট: নার্সিং, ক্লিনিক্যাল ও বিশ্ববিদ্যালয়",
                                description = "নার্স ও ডাক্তারদের জন্য ক্লিনিক্যাল অ্যানামনেসিস, ওষুধ ও ISBAR হ্যান্ডওভার এবং উচ্চশিক্ষা শিক্ষার্থীদের জন্য APS, Uni-Assist, ভিসা ইন্টারভিউ ও মাস্টার্স থিসিস ডিফেন্স।",
                                accentColor = Color(0xFF00695C),
                                partCount = deSpPartCount,
                                lessonCount = deSpLessonCount,
                                sentenceCount = deSpSentenceCount,
                                customPills = listOf("🇩🇪 ১৬টি পার্ট", "🏥 নার্সিং ও ক্লিনিক্যাল", "🎓 বিশ্ববিদ্যালয় ও ভিসা"),
                                onClick = { onOpenCourse("de_specialist") }
                            )
                        }
                    } else if (!isJapanese) {
                        // 1. Welcome & Spoken Practice Advice Banner (English)
                        item {
                            WelcomeBanner(
                                text = "আপনার স্পোকেন দক্ষতা বাড়াতে এই app এর সাথে সাথে বেশি বেশি প্রাক্টিস করুন, ধন্যবাদ।",
                                isSpeaking = isSpeaking,
                                onPlayTts = { viewModel.playWelcomeGreeting(language = "english", force = true) },
                                onStopTts = { viewModel.stopWelcomeGreeting() }
                            )
                        }

                        // 3. Course Introduction & Audio Guidelines Card
                        item {
                            CourseIntroHeroCard(
                                onClick = { onOpenIntro("Intro.md") }
                            )
                        }

                        // English Alphabet & Phonics Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇬🇧 বর্ণমালা ও ফোনেটিক্স · ৩৪ ধ্বনি",
                                title = "ইংরেজি বর্ণমালা ও ফোনেটিক্স চার্ট (Alphabet & Phonics)",
                                description = "২৬টি ইংরেজি বর্ণ (A-Z) ও ৮টি জরুরি ফোনেটিক ব্লেন্ডস (Ch, Sh, Th...) ও বাংলা উচ্চারণ। প্রতিটি অক্ষরে ট্যাপ করলেই সঠিক অডিও শুনুন।",
                                accentColor = Color(0xFF1565C0),
                                partCount = 3,
                                lessonCount = 34,
                                sentenceCount = 34,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "চার্ট দেখুন",
                                customPills = listOf("🇬🇧 ৩৪ ধ্বনি", "🔊 সব অডিও", "⚡ ধীর ও স্বাভাবিক গতি"),
                                onClick = { onOpenAlphabetChart("english") }
                            )
                        }

                        // 4. Present Tens (বর্তমান কাল)
                        item {
                            MainCourseCard(
                                tag = "🇬🇧 Present Tens (বর্তমান কাল)",
                                title = "সহজ নিয়মে কথা বলুন (Present Tens: Be-Verbs, Q&A & Presentation)",
                                description = "পেশা, ব্যক্তিত্ব, দৈনন্দিন বস্তু, অবস্থান, প্রশ্ন-উত্তর, গুড অ্যাট/ব্যাড অ্যাট ও সম্পূর্ণ প্রেজেন্টেশন বর্তমান কালে সাবলীলভাবে অনুশীলন করুন।",
                                accentColor = Color(0xFF00796B),
                                partCount = presentPartCount,
                                lessonCount = presentLessonCount,
                                sentenceCount = presentSentenceCount,
                                onClick = { onOpenCourse("present") }
                            )
                        }

                        // 5. Past Tens (অতীত কাল)
                        item {
                            MainCourseCard(
                                tag = "🇬🇧 Past Tens (অতীত কাল)",
                                title = "অতীতের কথা বলুন (Was/Were, Had & Past Actions)",
                                description = "অতীতের অভ্যাস, স্মৃতি, অভিজ্ঞতা ও অতীতের কাজ বর্ণনার সহজ স্পোকেন রুলস ও অডিও ড্রিল।",
                                accentColor = Color(0xFF5E35B1),
                                partCount = pastPartCount,
                                lessonCount = pastLessonCount,
                                sentenceCount = pastSentenceCount,
                                onClick = { onOpenCourse("past") }
                            )
                        }

                        // 6. Future Tens (ভবিষ্যৎ কাল)
                        item {
                            MainCourseCard(
                                tag = "🇬🇧 Future Tens (ভবিষ্যৎ কাল)",
                                title = "ভবিষ্যতের কথা বলুন (Will, Shall & Future Plans)",
                                description = "ভবিষ্যতের পরিকল্পনা, প্রতিশ্রুতি ও সম্ভাবনা প্রকাশের আধুনিক স্পোকেন স্ট্রাকচার।",
                                accentColor = Color(0xFFC2410C),
                                partCount = futurePartCount,
                                lessonCount = futureLessonCount,
                                sentenceCount = futureSentenceCount,
                                onClick = { onOpenCourse("future") }
                            )
                        }
                    } else {
                        // 1. Welcome & Spoken Practice Advice Banner (Japanese)
                        item {
                            WelcomeBanner(
                                text = "জাপানিজ স্পোকেন মাস্টারক্লাসে আপনাকে স্বাগতম! বাংলা নিয়মে সহজভাবে জাপানি ভাষায় ফ্লুয়েন্টলি কথা বলা শিখুন।",
                                isSpeaking = isSpeaking,
                                onPlayTts = { viewModel.playWelcomeGreeting(language = "japanese", force = true) },
                                onStopTts = { viewModel.stopWelcomeGreeting() }
                            )
                        }

                        // 3. Course Introduction & Audio Guidelines Card (Japanese)
                        item {
                            CourseIntroHeroCard(
                                title = "📖 জাপানি স্পোকেন গাইডলাইন ও অরিয়েন্টেশন",
                                subtitle = "হিরাগানা, কাতাকানা, কাঞ্জি ও বাংলা নিয়মে দ্রুত সাবলীল জাপানি শেখার কৌশল",
                                tag = "🇯🇵 JLPT N5-N2 গাইডলাইন",
                                badgeColor = Color(0xFFC62828),
                                pills = listOf("🇯🇵 JLPT N5-N2", "⚡ স্পিড ল্যাডার ড্রিল", "💡 মার্জিত কেইগো"),
                                onClick = { onOpenIntro("Japanese_Intro.md") }
                            )
                        }

                        // 3.1 All Japanese Letters & Sounds Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇯🇵 বর্ণমালা চার্ট · ১০৪ ধ্বনি",
                                title = "জাপানি বর্ণমালা ও উচ্চারণ চার্ট (All Letters & Sounds)",
                                description = "হিরাগানা ও কাতাকানা সমস্ত ১০৪টি বর্ণ, রোমাজি ও বাংলা উচ্চারণ। প্রতিটি অক্ষরে ট্যাপ করলেই সঠিক জাপানি অডিও সাউন্ড শুনুন।",
                                accentColor = Color(0xFFC62828),
                                partCount = 3,
                                lessonCount = 104,
                                sentenceCount = 104,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "চার্ট দেখুন",
                                customPills = listOf("🈁 ১০৪ বর্ণ", "🔊 সব অডিও", "⚡ ধীর ও স্বাভাবিক গতি"),
                                onClick = onOpenKanaChart
                            )
                        }

                        // Japanese Numbers 1-100 Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇯🇵 সংখ্যা ও গণনা · ১ থেকে ১০০",
                                title = "১ থেকে ১০০ জাপানি সংখ্যা ও গণনা (数字 1-100)",
                                description = "১ থেকে ১০০ পর্যন্ত প্রতিটি সংখ্যার কানজি, হিরাগানা, রোমাজি ও বাংলা উচ্চারণ। প্রতিটি সংখ্যায় ট্যাপ করলেই সঠিক জাপানি অডিও শুনুন।",
                                accentColor = Color(0xFFC62828),
                                partCount = 5,
                                lessonCount = 100,
                                sentenceCount = 100,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "সংখ্যা দেখুন",
                                customPills = listOf("🔢 ১-১০০ সংখ্যা", "🔊 সব অডিও", "⚡ ধীর ও স্বাভাবিক গতি"),
                                onClick = { onOpenNumbersChart("japanese") }
                            )
                        }

                        // Standard curriculum (Japanese-Spoken-Curriculum-Plan.md, phase 1): Stage 0 + N5
                        item {
                            MainCourseCard(
                                tag = "🇯🇵 স্ট্যান্ডার্ড কোর্স: শূন্য থেকে JLPT N5",
                                title = "শূন্য থেকে জাপানি বলা (অক্ষর, উচ্চারণ ও N5 স্পিকিং)",
                                description = "স্বরধ্বনি, হিরাগানা, কাতাকানা, বিশেষ ধ্বনি, পিচ অ্যাকসেন্ট, জরুরি বাক্য, তারপর N5-এর ১৫টি ইউনিট ও স্পিকিং টেস্ট।",
                                accentColor = Color(0xFFAD1457),
                                partCount = jpStandardPartCount,
                                lessonCount = jpStandardLessonCount,
                                sentenceCount = jpStandardSentenceCount,
                                onClick = { onOpenCourse("jp_standard") }
                            )
                        }

                        // Standard curriculum (Japanese-Spoken-Curriculum-Plan.md, phase 2): Elementary N4
                        item {
                            MainCourseCard(
                                tag = "🇯🇵 স্ট্যান্ডার্ড কোর্স: লেভেল JLPT N4",
                                title = "সাবলীল জাপানিজ (Plain Form, শর্ত, কর্মবাচ্য, কজেটিভ ও কেইগো)",
                                description = "সাধারণ কথ্য রূপ, চার প্রকার শর্তসাপেক্ষ বাক্য, দেওয়া-নেওয়া, অনুমান ও সম্ভাবনা, কর্মবাচ্য, প্রযোজক ক্রিয়া ও বিনম্র ভাষা কেইগো।",
                                accentColor = Color(0xFFE65100),
                                partCount = jpN4PartCount,
                                lessonCount = jpN4LessonCount,
                                sentenceCount = jpN4SentenceCount,
                                onClick = { onOpenCourse("jp_n4") }
                            )
                        }

                        // Standard curriculum (Japanese-Spoken-Curriculum-Plan.md, phase 3): Intermediate N3
                        item {
                            MainCourseCard(
                                tag = "🇯🇵 স্ট্যান্ডার্ড কোর্স: লেভেল JLPT N3",
                                title = "ইন্টারমিডিয়েট জাপানিজ (পূর্ণাঙ্গ কেইগো, অফিস ও টেলিফোন)",
                                description = "অভ্যাস ও পরিবর্তন, যুক্তি ও কর্তব্য, পূর্ণাঙ্গ কেইগো, টেলিফোন ও বার্তা গ্রহণ, কর্মক্ষেত্রে যোগাযোগ এবং অনোমাটোপিয়া।",
                                accentColor = Color(0xFF2E7D32),
                                partCount = jpN3PartCount,
                                lessonCount = jpN3LessonCount,
                                sentenceCount = jpN3SentenceCount,
                                onClick = { onOpenCourse("jp_n3") }
                            )
                        }

                        // 4. Course 1: JLPT N5 Foundations
                        item {
                            MainCourseCard(
                                tag = "🇯🇵 JLPT N5 Foundations (ভিত্তি ও বর্তমান কাল)",
                                title = "সহজ নিয়মে কথা বলুন (N5 Basics: Desu/Masu, Q&A & Daily Living)",
                                description = "দৈনন্দিন পরিচয়, জাতীয়তা, পেশা, জিনিসপত্র কেনাকাটা, সময়, ক্যালেন্ডার, স্থান, পছন্দ-অপছন্দ ও ৫টি স্ব-প্রেজেন্টেশন।",
                                accentColor = Color(0xFFC62828),
                                partCount = jpFoundationsPartCount,
                                lessonCount = jpFoundationsLessonCount,
                                sentenceCount = jpFoundationsSentenceCount,
                                onClick = { onOpenCourse("jp_foundations") }
                            )
                        }

                        // 5. Course 2: JLPT N5/N4 Past Tense & Life Experience
                        item {
                            MainCourseCard(
                                tag = "🇯🇵 JLPT N5/N4 Past Tense (অতীত কাল ও অভিজ্ঞতা)",
                                title = "অতীতের কথা বলুন (Deshita/Mashita, Te-Form & Past Experiences)",
                                description = "অতীতের কাজ, অবস্থা, Te-form দিয়ে কাজের ধারাবাহিকতা, অনুমতি ও বারণ, জীবন অভিজ্ঞতা ও অতীত স্মৃতি বর্ণনা।",
                                accentColor = Color(0xFF4527A0),
                                partCount = jpPastPartCount,
                                lessonCount = jpPastLessonCount,
                                sentenceCount = jpPastSentenceCount,
                                onClick = { onOpenCourse("jp_past") }
                            )
                        }

                        // 6. Course 3: JLPT N4 Casual Fluency & Plain Form
                        item {
                            MainCourseCard(
                                tag = "🇯🇵 JLPT N4 Casual Fluency (ক্যাজুয়াল আড্ডা ও প্লেইন ফর্ম)",
                                title = "স্বাভাবিক জাপানি আড্ডা (Plain/Dictionary Form, Opinions & Why)",
                                description = "জাপানিদের স্বাভাবিক বন্ধুত্বপূর্ণ কথাবার্তা, ডিকশনারি ফর্ম, অনুভূতি ও মতামত প্রকাশ, কারণ ব্যাখ্যা ও আড্ডা।",
                                accentColor = Color(0xFF00695C),
                                partCount = jpCasualPartCount,
                                lessonCount = jpCasualLessonCount,
                                sentenceCount = jpCasualSentenceCount,
                                onClick = { onOpenCourse("jp_casual") }
                            )
                        }

                        // 7. Course 4: JLPT N3/N2 Business Japanese & Keigo
                        item {
                            MainCourseCard(
                                tag = "🇯🇵 JLPT N3/N2 Business & Keigo (মার্জিত ভাষা ও অফিস)",
                                title = "বিজনেস কেইগো (Sonkeigo, Kenjougo, Office & Interview)",
                                description = "উচ্চসম্মানসূচক ও বিনম্র ভাষা, বিনম্র অনুরোধ, অফিসিয়াল ফোন কল, মিটিং ও কর্পোরেট ইন্টারভিউ প্রশ্নোত্তর।",
                                accentColor = Color(0xFFD84315),
                                partCount = jpBusinessPartCount,
                                lessonCount = jpBusinessLessonCount,
                                sentenceCount = jpBusinessSentenceCount,
                                onClick = { onOpenCourse("jp_business") }
                            )
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(32.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun CourseIntroHeroCard(
    title: String = "📖 কোর্স পরিচিতি ও অডিও গাইডলাইন",
    subtitle: String = "ইংরেজি শেখার সঠিক নিয়ম, টিপস ও অনুপ্রেরণামূলক দিকনির্দেশনা",
    tag: String = "📖 অডিও গাইডলাইন",
    badgeColor: Color = Color(0xFF1565C0),
    pills: List<String> = listOf("🎙️ অডিও রিডার", "⚡ ৪টি সহজ নিয়ম", "💡 সেরা টিপস"),
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.5.dp, badgeColor.copy(alpha = 0.45f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            badgeColor.copy(alpha = 0.18f),
                            badgeColor.copy(alpha = 0.08f)
                        )
                    )
                )
                .padding(18.dp)
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Surface(
                        color = badgeColor,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = tag,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                        )
                    }
                    Surface(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Icon(
                                Icons.Default.PlayArrow,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(
                                text = "শুনুন ও পড়ুন",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = title,
                    fontSize = 18.sp,
                    lineHeight = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = subtitle,
                    fontSize = 13.sp,
                    lineHeight = 19.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    pills.forEach { pillText ->
                        InfoPill(text = pillText)
                    }
                }
            }
        }
    }
}

private fun Int.toBanglaDigits(): String {
    val bnDigits = charArrayOf('০', '১', '২', '৩', '৪', '৫', '৬', '৭', '৮', '৯')
    return this.toString().map { if (it in '0'..'9') bnDigits[it - '0'] else it }.joinToString("")
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun MainCourseCard(
    tag: String,
    title: String,
    description: String,
    accentColor: Color,
    partCount: Int,
    lessonCount: Int,
    sentenceCount: Int,
    badgeText: String = "১০০% ফ্রি",
    actionButtonText: String = "লেসনগুলো দেখুন",
    customPills: List<String>? = null,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.5.dp, accentColor.copy(alpha = 0.5f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            accentColor.copy(alpha = 0.18f),
                            accentColor.copy(alpha = 0.08f)
                        )
                    )
                )
                .padding(18.dp)
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Surface(
                        color = accentColor,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = tag,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                        )
                    }
                    Text(
                        text = badgeText,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = GoldenAccent
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = title,
                    fontSize = 19.sp,
                    lineHeight = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = description,
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(14.dp))

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    if (customPills != null) {
                        customPills.forEach { pillText ->
                            InfoPill(text = pillText)
                        }
                    } else {
                        InfoPill(text = "📚 ${partCount.toBanglaDigits()}টি অংশ")
                        InfoPill(text = "🎧 ${lessonCount.toBanglaDigits()}টি লেসন")
                        InfoPill(text = "💬 ${if (sentenceCount >= 100) "${(sentenceCount / 100 * 100).toBanglaDigits()}+" else sentenceCount.toBanglaDigits()} বাক্য")
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        color = accentColor,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 7.dp)
                        ) {
                            Text(
                                text = actionButtonText,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(Modifier.width(6.dp))
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun UpcomingCourseCard(
    tag: String,
    title: String,
    description: String,
    accentColor: Color,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.5.dp, accentColor.copy(alpha = 0.45f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            accentColor.copy(alpha = 0.16f),
                            accentColor.copy(alpha = 0.05f)
                        )
                    )
                )
                .padding(18.dp)
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Surface(
                        color = accentColor,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = tag,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                        )
                    }

                    Surface(
                        color = accentColor.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "⏳ শীঘ্রই আসছে",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = accentColor,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = title,
                    fontSize = 18.sp,
                    lineHeight = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = description,
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        InfoPill(text = "📚 ৪টি অংশ")
                        InfoPill(text = "🎧 ২০টি লেসন")
                        InfoPill(text = "⚡ প্রস্তুতি চলছে")
                    }

                    Surface(
                        color = accentColor.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = "শীঘ্রই উন্মুক্ত",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = accentColor
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun WelcomeBanner(
    text: String,
    isSpeaking: Boolean,
    onPlayTts: () -> Unit,
    onStopTts: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, Color(0xFF00796B).copy(alpha = 0.35f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF00796B).copy(alpha = 0.12f),
                            Color(0xFF004D40).copy(alpha = 0.05f)
                        )
                    )
                )
                .padding(14.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Surface(
                    shape = CircleShape,
                    color = Color(0xFF00796B).copy(alpha = 0.15f),
                    modifier = Modifier.size(42.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = if (isSpeaking) "🔊" else "🎙️",
                            fontSize = 20.sp
                        )
                    }
                }

                Spacer(Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "স্বাগতম বার্তা",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF00796B)
                        )
                        if (isSpeaking) {
                            Spacer(Modifier.width(6.dp))
                            Text(
                                text = "• ভয়েস চলছে...",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF10B981)
                            )
                        }
                    }
                    Spacer(Modifier.height(3.dp))
                    Text(
                        text = text,
                        fontSize = 13.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                Spacer(Modifier.width(8.dp))

                IconButton(
                    onClick = {
                        if (isSpeaking) onStopTts() else onPlayTts()
                    },
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = if (isSpeaking) Icons.Default.Stop else Icons.AutoMirrored.Filled.VolumeUp,
                        contentDescription = if (isSpeaking) "থামান" else "শুনুন",
                        tint = Color(0xFF00796B)
                    )
                }
            }
        }
    }
}

@Composable
private fun InfoPill(text: String) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = text,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

@Composable
private fun CenteredMessage(content: @Composable () -> Unit) {
    Box(Modifier.fillMaxSize().padding(24.dp), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) { content() }
    }
}
