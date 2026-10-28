package com.gigabyte.bookstore.learning.presentation.home

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
    onOpenIntro: (String) -> Unit
) {
    val contentState by viewModel.contentState.collectAsStateWithLifecycle()
    val syllabus by viewModel.syllabus.collectAsStateWithLifecycle()
    val isSpeaking by viewModel.isSpeaking.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val isJapanese = language.equals("japanese", ignoreCase = true)
    val isUrdu = language.equals("urdu", ignoreCase = true)

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

    val jpStandardParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("jp-std-") && it.part.isEnabled } }
    val jpStandardPartCount = jpStandardParts.size.coerceAtLeast(1)
    val jpStandardLessonCount = jpStandardParts.sumOf { it.lessons.size }.let { if (it > 0) it else 110 }
    val jpStandardSentenceCount = jpStandardParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 900 }

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
                                isJapanese -> "জাপানিজ স্পোকেন মাস্টারক্লাস"
                                else -> "স্পোকেন ইংলিশ মাস্টারক্লাস"
                            },
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = when {
                                isUrdu -> "বাংলা থেকে সহজ নিয়মে শূন্য থেকে উর্দু বলা"
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

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        InfoPill(text = "📚 ${partCount.toBanglaDigits()}টি অংশ")
                        InfoPill(text = "🎧 ${lessonCount.toBanglaDigits()}টি লেসন")
                        InfoPill(text = "💬 ${if (sentenceCount >= 100) "${(sentenceCount / 100 * 100).toBanglaDigits()}+" else sentenceCount.toBanglaDigits()} বাক্য")
                    }

                    Surface(
                        color = accentColor,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = "লেসনগুলো দেখুন",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(Modifier.width(4.dp))
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
