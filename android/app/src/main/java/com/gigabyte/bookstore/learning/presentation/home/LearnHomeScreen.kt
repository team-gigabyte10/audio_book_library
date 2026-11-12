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
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.Translate
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
import com.gigabyte.bookstore.learning.domain.translator.TranslatorLanguage
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
    onOpenNumbersChart: (String) -> Unit = {},
    onOpenCalendarChart: (String) -> Unit = {},
    onOpenVocabVault: (String) -> Unit = {},
    onOpenTranslator: (String) -> Unit = {}
) {
    val contentState by viewModel.contentState.collectAsStateWithLifecycle()
    val syllabus by viewModel.syllabus.collectAsStateWithLifecycle()
    val isSpeaking by viewModel.isSpeaking.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val isJapanese = language.equals("japanese", ignoreCase = true)
    val isUrdu = language.equals("urdu", ignoreCase = true)
    val isHindi = language.equals("hindi", ignoreCase = true)
    val isGerman = language.equals("german", ignoreCase = true)
    val isChinese = language.equals("chinese", ignoreCase = true) || language.equals("zh", ignoreCase = true)
    val isArabic = language.equals("arabic", ignoreCase = true) || language.equals("ar", ignoreCase = true)
    val isKorean = language.equals("korean", ignoreCase = true) || language.equals("ko", ignoreCase = true)
    val isRegionalBangla = language.equals("regional_bangla", ignoreCase = true) || language.equals("regional", ignoreCase = true)
    val isQuran = language.equals("quran", ignoreCase = true) || language.startsWith("qr")

    DisposableEffect(language) {
        viewModel.playWelcomeGreeting(language = language)
        onDispose {
            viewModel.stopWelcomeGreeting()
        }
    }

    val qrParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("qr-") && it.part.isEnabled } }
    val qrPartCount = qrParts.size.coerceAtLeast(1)
    val qrLessonCount = qrParts.sumOf { it.lessons.size }.let { if (it > 0) it else 31 }
    val qrSentenceCount = qrParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 248 }

    val bdParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("bd-") && it.part.isEnabled } }
    val bdPartCount = bdParts.size.coerceAtLeast(1)
    val bdLessonCount = bdParts.sumOf { it.lessons.size }.let { if (it > 0) it else 32 }
    val bdSentenceCount = bdParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 576 }

    val enStandardA1Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("en-a1-") && it.part.isEnabled } }
    val enStandardA1PartCount = enStandardA1Parts.size.coerceAtLeast(1)
    val enStandardA1LessonCount = enStandardA1Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val enStandardA1SentenceCount = enStandardA1Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val enStandardA2Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("en-a2-") && it.part.isEnabled } }
    val enStandardA2PartCount = enStandardA2Parts.size.coerceAtLeast(1)
    val enStandardA2LessonCount = enStandardA2Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val enStandardA2SentenceCount = enStandardA2Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val enStandardB1Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("en-b1-") && it.part.isEnabled } }
    val enStandardB1PartCount = enStandardB1Parts.size.coerceAtLeast(1)
    val enStandardB1LessonCount = enStandardB1Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val enStandardB1SentenceCount = enStandardB1Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val enStandardB2Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("en-b2-") && it.part.isEnabled } }
    val enStandardB2PartCount = enStandardB2Parts.size.coerceAtLeast(1)
    val enStandardB2LessonCount = enStandardB2Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val enStandardB2SentenceCount = enStandardB2Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val presentParts = remember(syllabus) { syllabus.filter { (it.part.id.startsWith("en-foundations-") || (it.part.id.startsWith("en-") && !it.part.id.startsWith("en-a1-") && !it.part.id.startsWith("en-a2-") && !it.part.id.startsWith("en-b1-") && !it.part.id.startsWith("en-b2-"))) && it.part.isEnabled } }
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

    val urC1Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("ur-c1-") && it.part.isEnabled } }
    val urC1PartCount = urC1Parts.size.coerceAtLeast(1)
    val urC1LessonCount = urC1Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val urC1SentenceCount = urC1Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val urSpParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("ur-sp-") && it.part.isEnabled } }
    val urSpPartCount = urSpParts.size.coerceAtLeast(1)
    val urSpLessonCount = urSpParts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val urSpSentenceCount = urSpParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

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

    val hiB2Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("hi-b2-") && it.part.isEnabled } }
    val hiB2PartCount = hiB2Parts.size.coerceAtLeast(1)
    val hiB2LessonCount = hiB2Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val hiB2SentenceCount = hiB2Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val hiSpParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("hi-sp-") && it.part.isEnabled } }
    val hiSpPartCount = hiSpParts.size.coerceAtLeast(1)
    val hiSpLessonCount = hiSpParts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val hiSpSentenceCount = hiSpParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

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

    val deB2Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("de-b2-") && it.part.isEnabled } }
    val deB2PartCount = deB2Parts.size.coerceAtLeast(1)
    val deB2LessonCount = deB2Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val deB2SentenceCount = deB2Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val deSpParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("de-sp-") && it.part.isEnabled } }
    val deSpPartCount = deSpParts.size.coerceAtLeast(1)
    val deSpLessonCount = deSpParts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val deSpSentenceCount = deSpParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val zhHsk1Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("zh-hsk1-") && it.part.isEnabled } }
    val zhHsk1PartCount = zhHsk1Parts.size.let { if (it > 0) it else 16 }
    val zhHsk1LessonCount = zhHsk1Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val zhHsk1SentenceCount = zhHsk1Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val zhHsk2Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("zh-hsk2-") && it.part.isEnabled } }
    val zhHsk2PartCount = zhHsk2Parts.size.let { if (it > 0) it else 16 }
    val zhHsk2LessonCount = zhHsk2Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val zhHsk2SentenceCount = zhHsk2Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val zhHsk3Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("zh-hsk3-") && it.part.isEnabled } }
    val zhHsk3PartCount = zhHsk3Parts.size.let { if (it > 0) it else 16 }
    val zhHsk3LessonCount = zhHsk3Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val zhHsk3SentenceCount = zhHsk3Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val zhHsk4Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("zh-hsk4-") && it.part.isEnabled } }
    val zhHsk4PartCount = zhHsk4Parts.size.let { if (it > 0) it else 16 }
    val zhHsk4LessonCount = zhHsk4Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val zhHsk4SentenceCount = zhHsk4Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val zhSpParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("zh-sp-") && it.part.isEnabled } }
    val zhSpPartCount = zhSpParts.size.let { if (it > 0) it else 16 }
    val zhSpLessonCount = zhSpParts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val zhSpSentenceCount = zhSpParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val arStdParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("ar-std-") && it.part.isEnabled } }
    val arStdPartCount = arStdParts.size.let { if (it > 0) it else 16 }
    val arStdLessonCount = arStdParts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val arStdSentenceCount = arStdParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val arA2Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("ar-a2-") && it.part.isEnabled } }
    val arA2PartCount = arA2Parts.size.let { if (it > 0) it else 16 }
    val arA2LessonCount = arA2Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val arA2SentenceCount = arA2Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val arB1Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("ar-b1-") && it.part.isEnabled } }
    val arB1PartCount = arB1Parts.size.let { if (it > 0) it else 16 }
    val arB1LessonCount = arB1Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val arB1SentenceCount = arB1Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val arB2Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("ar-b2-") && it.part.isEnabled } }
    val arB2PartCount = arB2Parts.size.let { if (it > 0) it else 16 }
    val arB2LessonCount = arB2Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val arB2SentenceCount = arB2Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val arSpParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("ar-sp-") && it.part.isEnabled } }
    val arSpPartCount = arSpParts.size.let { if (it > 0) it else 16 }
    val arSpLessonCount = arSpParts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val arSpSentenceCount = arSpParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

    val koStdParts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("ko-std-") && it.part.isEnabled } }
    val koStdPartCount = koStdParts.size.let { if (it > 0) it else 16 }
    val koStdLessonCount = koStdParts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val koStdSentenceCount = koStdParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

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

    val jpN2Parts = remember(syllabus) { syllabus.filter { it.part.id.startsWith("jp-n2-") && it.part.isEnabled } }
    val jpN2PartCount = jpN2Parts.size.coerceAtLeast(1)
    val jpN2LessonCount = jpN2Parts.sumOf { it.lessons.size }.let { if (it > 0) it else 64 }
    val jpN2SentenceCount = jpN2Parts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 512 }

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
                                isQuran -> "সহজে কুরআন শিক্ষা ও তাজবীদ কোর্স"
                                isRegionalBangla -> "বিভাগীয় আঞ্চলিক ভাষা স্পোকেন কোর্স"
                                isUrdu -> "উর্দু স্পোকেন কোর্স"
                                isHindi -> "হিন্দি স্পোকেন কোর্স"
                                isGerman -> "জার্মান স্পোকেন কোর্স"
                                isChinese -> "চাইনিজ (ম্যান্ডারিন) স্পোকেন কোর্স"
                                isArabic -> "আরবি স্পোকেন কোর্স"
                                isKorean -> "কোরিয়ান স্পোকেন কোর্স"
                                isJapanese -> "জাপানিজ স্পোকেন মাস্টারক্লাস"
                                else -> "স্পোকেন ইংলিশ মাস্টারক্লাস"
                            },
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = when {
                                isQuran -> "নূরানী পদ্ধতিতে শূন্য থেকে সহীহ তিলাওয়াত ও তাজবীদ"
                                isRegionalBangla -> "৮টি বিভাগের খাঁটি আঞ্চলিক কথ্য ভাষা ও উপভাষা শিক্ষা"
                                isUrdu -> "বাংলা থেকে সহজ নিয়মে শূন্য থেকে উর্দু বলা"
                                isHindi -> "বাংলা থেকে সহজ নিয়মে শূন্য থেকে হিন্দি বলা"
                                isGerman -> "বাংলা থেকে সহজ নিয়মে শূন্য থেকে জার্মান বলা"
                                isChinese -> "বাংলা থেকে সহজ নিয়মে পিনইন, ৪ সুর ও HSK 1 স্পোকেন"
                                isArabic -> "বাংলা থেকে সহজ নিয়মে শূন্য থেকে আরবি ও গাল্ফ কথোপকথন"
                                isKorean -> "বাংলা থেকে সহজ নিয়মে হাঙ্গুল, বাচ্ছিম ও EPS-TOPIK স্পোকেন"
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
                },
                actions = {
                    IconButton(onClick = { onOpenTranslator(language) }) {
                        Icon(Icons.Default.Translate, contentDescription = "লাইভ অনুবাদক")
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
                    item {
                        val translatorLang = remember(language) { TranslatorLanguage.fromKey(language) }
                        CourseLiveTranslatorCard(
                            translatorLanguage = translatorLang,
                            onClick = { onOpenTranslator(translatorLang.key) }
                        )
                    }
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

                        // Urdu Calendar & Time Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇵🇰 দিন, মাস ও ঋতু · ৩৮টি শব্দ",
                                title = "উর্দু দিন, মাস ও ঋতু চার্ট (دن، مہینے اور موسم)",
                                description = "সপ্তাহের ৭ দিন, ১২ মাস, ৫টি ঋতু এবং আজ, কাল, সকাল, রাতসহ সময় সংক্রান্ত প্রয়োজনীয় শব্দাবলি ও অডিও উচ্চারণ।",
                                accentColor = Color(0xFF1B5E20),
                                partCount = 4,
                                lessonCount = 38,
                                sentenceCount = 38,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "চার্ট দেখুন",
                                customPills = listOf("🗓️ ৭ দিন", "📅 ১২ মাস", "🌸 ৫ ঋতু", "⏰ দিনকাল"),
                                onClick = { onOpenCalendarChart("urdu") }
                            )
                        }

                        // Urdu 1000 Vocabulary Vault Card
                        item {
                            MainCourseCard(
                                tag = "🇵🇰 শব্দভাণ্ডার · ১,০০০টি শব্দ",
                                title = "১০০০ দৈনন্দিন প্রয়োজনীয় উর্দু শব্দ (الفاظ کا خزانہ)",
                                description = "পরিবার, শরীর, খাবার, পোশাক, শহর, ভ্রমণসহ ২০টি বিষয়ে ১,০০০টি গুরুত্বপূর্ণ উর্দু শব্দ, একবচন-বহুবচন, লিঙ্গ ও দ্বৈত অডিও উচ্চারণ।",
                                accentColor = Color(0xFF00695C),
                                partCount = 20,
                                lessonCount = 1000,
                                sentenceCount = 1000,
                                badgeText = "Vault",
                                actionButtonText = "শব্দভাণ্ডার খুলুন",
                                customPills = listOf("🗂️ ২০ ক্যাটাগরি", "🗣️ ১,০০০ শব্দ", "👥 একবচন ও বহুবচন", "🔊 দ্বৈত অডিও"),
                                onClick = { onOpenVocabVault("urdu") }
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

                        // Urdu C1 Course Card
                        item {
                            MainCourseCard(
                                tag = "🇵🇰 স্ট্যান্ডার্ড কোর্স: লেভেল C1",
                                title = "উর্দু C1: বাগধারা, গজল-নজম, সাহিত্যিক গদ্য ও বিতর্ক",
                                description = "উর্দু বাগধারা (محاورے), প্রবাদ, ধ্রুপদী গজল ও আধুনিক কবিতা, সাহিত্যিক গদ্য, একাডেমিক পরিভাষা, আঞ্চলিক উপভাষা ও লাইভ মিডিয়া সাক্ষাৎকার।",
                                accentColor = Color(0xFF00695C),
                                partCount = urC1PartCount,
                                lessonCount = urC1LessonCount,
                                sentenceCount = urC1SentenceCount,
                                customPills = listOf("🇵🇰 ১৬টি পার্ট", "📜 গজল, বাগধারা ও সাহিত্য", "🎙️ বিতর্ক ও মিডিয়া"),
                                onClick = { onOpenCourse("ur_c1") }
                            )
                        }

                        // Urdu Specialist Professional Track Card
                        item {
                            MainCourseCard(
                                tag = "🇵🇰 স্পেশালিস্ট প্রফেশনাল কোর্স (গাল্ফ, বাণিজ্য ও সাহিত্য)",
                                title = "উর্দু স্পেশালিস্ট: গাল্ফ কর্মক্ষেত্র, বাণিজ্য ও দোভাষী",
                                description = "দুবাই, সৌদি ও কাতারের কর্মক্ষেত্র ও নির্মাণ সাইট, গাল্ফ রিটেইল ও হাসপাতাল, গার্মেন্টস ও আমদানি-রপ্তানি বাণিজ্য, ইসলামিক সাহিত্য ও দোভাষী দক্ষতা।",
                                accentColor = Color(0xFF004D40),
                                partCount = urSpPartCount,
                                lessonCount = urSpLessonCount,
                                sentenceCount = urSpSentenceCount,
                                customPills = listOf("🇵🇰 ১৬টি পার্ট", "🏗️ গাল্ফ কর্মক্ষেত্র ও বাণিজ্য", "🕌 সিরাত, না'ত ও দোভাষী"),
                                onClick = { onOpenCourse("ur_specialist") }
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

                        // Hindi Calendar & Time Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇮🇳 দিন, মাস ও ঋতু · ৩৯টি শব্দ",
                                title = "হিন্দি দিন, মাস ও ঋতু চার্ট (दिन, महीने और ऋतुएँ)",
                                description = "সপ্তাহের ৭ দিন, ১২ মাস, ৬টি ঋতু এবং আজ, কাল, সকাল, রাতসহ সময় সংক্রান্ত প্রয়োজনীয় শব্দাবলি ও অডিও উচ্চারণ।",
                                accentColor = Color(0xFFE65100),
                                partCount = 4,
                                lessonCount = 39,
                                sentenceCount = 39,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "চার্ট দেখুন",
                                customPills = listOf("🗓️ ৭ দিন", "📅 ১২ মাস", "🌸 ৬ ঋতু", "⏰ দিনকাল"),
                                onClick = { onOpenCalendarChart("hindi") }
                            )
                        }

                        // Hindi 1000 Vocabulary Vault Card
                        item {
                            MainCourseCard(
                                tag = "🇮🇳 শব্দভাণ্ডার · ১,০০০টি শব্দ",
                                title = "১০০০ দৈনন্দিন প্রয়োজনীয় হিন্দি শব্দ (हिन्दी शब्दकोश)",
                                description = "পরিবার, শরীর, খাদ্য, বাসস্থান, ভ্রমণসহ ২০টি বিষয়ে ১,০০০টি নিত্যপ্রয়োজনীয় হিন্দি শব্দ, একবচন-বহুবচন, পুং/স্ত্রীলিঙ্গ ও দ্বৈত অডিও উচ্চারণ।",
                                accentColor = Color(0xFFD84315),
                                partCount = 20,
                                lessonCount = 1000,
                                sentenceCount = 1000,
                                badgeText = "Vault",
                                actionButtonText = "শব্দভাণ্ডার খুলুন",
                                customPills = listOf("🗂️ ২০ ক্যাটাগরি", "🗣️ ১,০০০ শব্দ", "👥 একবচন ও বহুবচন", "🔊 দ্বৈত অডিও"),
                                onClick = { onOpenVocabVault("hindi") }
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

                        // Hindi B2 Course Card
                        item {
                            MainCourseCard(
                                tag = "🇮🇳 স্ট্যান্ডার্ড কোর্স: লেভেল B2",
                                title = "হিন্দি B2: শুদ্ধ হিন্দি, অফিস মিটিং, ইন্টারভিউ ও বিতর্ক",
                                description = "কথ্য হিন্দুস্তানি বনাম শুদ্ধ হিন্দি, আনুষ্ঠানিক শিষ্টাচার, চাকরির ইন্টারভিউ, কর্মক্ষেত্রের মিটিং, প্রেজেন্টেশন, পাইকারি বাণিজ্য ও যুক্তিতর্ক।",
                                accentColor = Color(0xFFB71C1C),
                                partCount = hiB2PartCount,
                                lessonCount = hiB2LessonCount,
                                sentenceCount = hiB2SentenceCount,
                                customPills = listOf("🇮🇳 ১৬টি পার্ট", "💼 শুদ্ধ হিন্দি ও ইন্টারভিউ", "🤝 মিটিং ও দরকষাকষি"),
                                onClick = { onOpenCourse("hi_b2") }
                            )
                        }

                        // Hindi Specialist Professional Track Card
                        item {
                            MainCourseCard(
                                tag = "🇮🇳 স্পেশালিস্ট প্রফেশনাল কোর্স (মেডিকেল, বাণিজ্য ও প্রবাস)",
                                title = "হিন্দি স্পেশালিস্ট: মেডিকেল ট্যুরিজম, বাণিজ্য ও দোভাষী",
                                description = "ভারত ভ্রমণ ও ইমিগ্রেশন, চেন্নাই-ভেলোর-দিল্লির হাসপাতাল কনসালটেশন ও সার্জারি, পাইকারি বাজার ও এলসি আমদানি, প্রবাসী কর্মক্ষেত্র ও দোভাষী দক্ষতা।",
                                accentColor = Color(0xFF880E4F),
                                partCount = hiSpPartCount,
                                lessonCount = hiSpLessonCount,
                                sentenceCount = hiSpSentenceCount,
                                customPills = listOf("🇮🇳 ১৬টি পার্ট", "🏥 মেডিকেল ট্যুরিজম ও হাসপাতাল", "🚢 পাইকারি বাণিজ্য ও দোভাষী"),
                                onClick = { onOpenCourse("hi_specialist") }
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

                        // German Calendar & Time Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇩🇪 দিন, মাস ও ঋতু · ৩৮টি শব্দ",
                                title = "জার্মান দিন, মাস ও ঋতু চার্ট (Tage, Monate & Jahreszeiten)",
                                description = "সপ্তাহের ৭ দিন, ১২ মাস, ৪টি ঋতু এবং আজ, কাল, সকাল, রাতসহ সময় সংক্রান্ত প্রয়োজনীয় শব্দাবলি ও অডিও উচ্চারণ।",
                                accentColor = Color(0xFF004D40),
                                partCount = 4,
                                lessonCount = 38,
                                sentenceCount = 38,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "চার্ট দেখুন",
                                customPills = listOf("🗓️ ৭ দিন", "📅 ১২ মাস", "🌸 ৪ ঋতু", "⏰ দিনকাল"),
                                onClick = { onOpenCalendarChart("german") }
                            )
                        }

                        // German 1000 Vocabulary Vault Card
                        item {
                            MainCourseCard(
                                tag = "🇩🇪 শব্দভাণ্ডার · ১,০০০টি শব্দ",
                                title = "১০০০ প্রয়োজনীয় জার্মান শব্দ (Deutscher Wortschatz)",
                                description = "der/die/das আর্টিকেল, একবচন ও বহুবচন রূপ সহ ২০টি প্রধান বিষয়ের ১,০০০টি অতিপ্রয়োজনীয় জার্মান শব্দ ও দ্বৈত অডিও উচ্চারণ।",
                                accentColor = Color(0xFFE65100),
                                partCount = 20,
                                lessonCount = 1000,
                                sentenceCount = 1000,
                                badgeText = "Vault",
                                actionButtonText = "শব্দভাণ্ডার খুলুন",
                                customPills = listOf("🗂️ ২০ ক্যাটাগরি", "🗣️ ১,০০০ শব্দ", "🏷️ der/die/das", "🔊 দ্বৈত অডিও"),
                                onClick = { onOpenVocabVault("german") }
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

                        // German B2 Course Card
                        item {
                            MainCourseCard(
                                tag = "🇩🇪 স্ট্যান্ডার্ড কোর্স: লেভেল B2",
                                title = "জার্মান B2: মিটিং, দরকষাকষি ও গোয়েথে B2 স্পিকিং",
                                description = "কর্পোরেট মিটিং ও টিম ডিসকাশন, ব্যবসায়িক দরকষাকষি, বিরোধ নিরসন, জার্মান সংবাদ বিশ্লেষণ, হাই-স্কিল জব ইন্টারভিউ ও গোয়েথে B2 স্পিকিং মডেল।",
                                accentColor = Color(0xFF1565C0),
                                partCount = deB2PartCount,
                                lessonCount = deB2LessonCount,
                                sentenceCount = deB2SentenceCount,
                                customPills = listOf("🇩🇪 ১৬টি পার্ট", "💼 বিজনেস মিটিং ও জব ইন্টারভিউ", "🎯 গোয়েথে B2 স্পিকিং"),
                                onClick = { onOpenCourse("de_b2") }
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
                    } else if (isChinese) {
                        item {
                            WelcomeBanner(
                                text = "চাইনিজ ম্যান্ডারিন স্পোকেন কোর্সে আপনাকে স্বাগতম! প্রতিটি সুর, হানয্য ও বাক্য শুনুন এবং জোরে জোরে বলুন।",
                                isSpeaking = isSpeaking,
                                onPlayTts = { viewModel.playWelcomeGreeting(language = "chinese", force = true) },
                                onStopTts = { viewModel.stopWelcomeGreeting() }
                            )
                        }

                        // Pinyin & 4-Tones Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇨🇳 পিনইন ও ৪টি সুর · ৪২ ধ্বনি",
                                title = "চাইনিজ পিনইন ও ৪টি সুর চার্ট (Pinyin & Tones)",
                                description = "ম্যান্ডারিনের ৪টি মূল সুর + নিউট্রাল টোন, ২৩টি ইনিশিয়াল ও ১৪টি ফাইনাল। প্রতিটি অক্ষরে ট্যাপ করলেই সঠিক চীনা অডিও শুনুন।",
                                accentColor = Color(0xFFC62828),
                                partCount = 3,
                                lessonCount = 42,
                                sentenceCount = 42,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "চার্ট দেখুন",
                                customPills = listOf("🇨🇳 ৪২ ধ্বনি", "🎵 ৪টি সুর", "🔊 সব অডিও"),
                                onClick = { onOpenAlphabetChart("chinese") }
                            )
                        }

                        // Chinese Numbers 1-100 Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇨🇳 সংখ্যা ও গণনা · ১ থেকে ১০০",
                                title = "১ থেকে ১০০ চাইনিজ সংখ্যা (中文数字)",
                                description = "১ থেকে ১০০ পর্যন্ত প্রতিটি চীনা সংখ্যা, হানয্য, পিনইন ও বাংলা উচ্চারণ। প্রতিটি সংখ্যায় ট্যাপ করলেই ম্যান্ডারিন অডিও শুনুন।",
                                accentColor = Color(0xFF4527A0),
                                partCount = 5,
                                lessonCount = 100,
                                sentenceCount = 100,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "সংখ্যা দেখুন",
                                customPills = listOf("🔢 ১-১০০ সংখ্যা", "🔊 সব অডিও", "⚡ ধীর ও স্বাভাবিক গতি"),
                                onClick = { onOpenNumbersChart("chinese") }
                            )
                        }

                        // Chinese Calendar & Time Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇨🇳 দিন, মাস ও ঋতু · ৩৮টি শব্দ",
                                title = "চাইনিজ দিন, মাস ও ঋতু চার্ট (星期 · 月份 · 季节)",
                                description = "সপ্তাহের ৭ দিন, ১২ মাস, ৪টি ঋতু এবং আজ, কাল, এখন, সকাল-রাতসহ সময় সংক্রান্ত প্রয়োজনীয় শব্দাবলি ও অডিও।",
                                accentColor = Color(0xFF00695C),
                                partCount = 4,
                                lessonCount = 38,
                                sentenceCount = 38,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "চার্ট দেখুন",
                                customPills = listOf("🗓️ ৭ দিন", "📅 ১২ মাস", "🌸 ৪ ঋতু", "⏰ সময়কাল"),
                                onClick = { onOpenCalendarChart("chinese") }
                            )
                        }

                        // Chinese 1000 Vocabulary Vault Card
                        item {
                            MainCourseCard(
                                tag = "🇨🇳 শব্দভাণ্ডার · ১,০০০টি শব্দ",
                                title = "১০০০ প্রয়োজনীয় চাইনিজ শব্দ (中文 常用词汇)",
                                description = "হানয্য, পিনইন, পরিমাপক শব্দ ও খাঁটি বাংলা উচ্চারণসহ ২০টি দৈনন্দিন বিষয়ের ১,০০০টি অতিপ্রয়োজনীয় চীনা শব্দ ও দ্বৈত অডিও।",
                                accentColor = Color(0xFFE65100),
                                partCount = 20,
                                lessonCount = 1000,
                                sentenceCount = 1000,
                                badgeText = "Vault",
                                actionButtonText = "শব্দভাণ্ডার খুলুন",
                                customPills = listOf("🗂️ ২০ ক্যাটাগরি", "🗣️ ১,০০০ শব্দ", "🈶 হানয্য ও পিনইন", "🔊 দ্বৈত অডিও"),
                                onClick = { onOpenVocabVault("chinese") }
                            )
                        }

                        // Chinese Stage 0 + HSK 1 Course Card
                        item {
                            MainCourseCard(
                                tag = "🇨🇳 স্ট্যান্ডার্ড কোর্স: শূন্য থেকে HSK 1",
                                title = "শূন্য থেকে চাইনিজ বলা (পিনইন, ৪ সুর ও HSK 1)",
                                description = "স্টেজ ০ টোন বুটক্যাম্প, হালাল খাবার, কেনাকাটা ও আলিপে/উইচ্যাট পে, মেট্রো-ট্যাক্সি, হোটেল-ক্যাম্পাস রোল-প্লে এবং HSK 1-এর ১৬টি পূর্ণাঙ্গ ইউনিট।",
                                accentColor = Color(0xFFC62828),
                                partCount = zhHsk1PartCount,
                                lessonCount = zhHsk1LessonCount,
                                sentenceCount = zhHsk1SentenceCount,
                                customPills = listOf("🇨🇳 ১৬টি পার্ট", "🎧 ৬৪টি অডিও লেসন", "🗣️ ৫১২টি বাক্য"),
                                onClick = { onOpenCourse("zh_hsk1") }
                            )
                        }

                        // Chinese HSK 2 Course Card
                        item {
                            MainCourseCard(
                                tag = "🚄 এলিমেন্টারি (A2): HSK 2",
                                title = "দৈনন্দিন চাইনিজ: HSK 2",
                                description = "তুলনা (比/更/最), হাই-স্পিড ট্রেন ও বিমানবন্দর, হোটেল চেক-ইন, ব্যাংক ও আলিপে, হাসপাতাল, অফিস এবং ফলিত ক্রিয়া সম্পূরক।",
                                accentColor = Color(0xFFD84315),
                                partCount = zhHsk2PartCount,
                                lessonCount = zhHsk2LessonCount,
                                sentenceCount = zhHsk2SentenceCount,
                                customPills = listOf("📘 HSK 2 (A2)", "🎧 ৬৪টি অডিও লেসন", "🗣️ ৫১২টি বাক্য"),
                                onClick = { onOpenCourse("zh_hsk2") }
                            )
                        }

                        // Chinese HSK 3 Course Card
                        item {
                            MainCourseCard(
                                tag = "🎓 ইন্টারমিডিয়েট (B1): HSK 3",
                                title = "সাবলীল চাইনিজ কথোপকথন: HSK 3",
                                description = "把 ও 被 বাক্যগঠন, দিক-নির্দেশক ও সম্ভাব্যতা, CSC স্কলারশিপ ও ক্যাম্পাস সাক্ষাৎকার, বাসা ভাড়া, চিকিৎসা, ডিজিটাল জীবন ও পরিবেশ-সমাজ।",
                                accentColor = Color(0xFF00796B),
                                partCount = zhHsk3PartCount,
                                lessonCount = zhHsk3LessonCount,
                                sentenceCount = zhHsk3SentenceCount,
                                customPills = listOf("🎓 HSK 3 (B1)", "🎧 ৬৪টি অডিও লেসন", "🗣️ ৫১২টি বাক্য"),
                                onClick = { onOpenCourse("zh_hsk3") }
                            )
                        }

                        // Chinese HSK 4 Course Card
                        item {
                            MainCourseCard(
                                tag = "🏆 আপার-ইন্টারমিডিয়েট (B2): HSK 4",
                                title = "অ্যাডভান্সড চাইনিজ ও বাগধারা: HSK 4",
                                description = "উচ্চতর যৌগিক বাক্য, চাইনিজ প্রবাদ (成语), অর্থনীতি, এআই ও প্রযুক্তি, পরিবেশ, থিসিস ডিফেন্স, নেতৃত্ব ও HSKK মক স্পিকিং।",
                                accentColor = Color(0xFF6A1B9A),
                                partCount = zhHsk4PartCount,
                                lessonCount = zhHsk4LessonCount,
                                sentenceCount = zhHsk4SentenceCount,
                                customPills = listOf("🏆 HSK 4 (B2)", "🎧 ৬৪টি অডিও লেসন", "🗣️ ৫১২টি বাক্য"),
                                onClick = { onOpenCourse("zh_hsk4") }
                            )
                        }

                        // Chinese Specialist Pro Course Card
                        item {
                            MainCourseCard(
                                tag = "🚢 স্পেশালিস্ট প্রো: চায়না ট্রেড, ইঞ্জিনিয়ারিং ও সিএসসি",
                                title = "চায়না ব্যবসা, ইঞ্জিনিয়ারিং ও CSC স্কলারশিপ প্রো",
                                description = "ক্যান্টন ফেয়ার ও ইয়িউ মার্কেট, MOQ/OEM, L/C ও শিপিং, গার্মেন্টস বায়িং, ১৬৮৮ সোর্সিং, মেট্রো-সোলার-ইটিপি সাইট এবং CSC ভাইভা সিমুলেশন।",
                                accentColor = Color(0xFF1565C0),
                                partCount = zhSpPartCount,
                                lessonCount = zhSpLessonCount,
                                sentenceCount = zhSpSentenceCount,
                                customPills = listOf("🚢 স্পেশালিস্ট প্রো", "🎧 ৬৪টি অডিও লেসন", "🗣️ ৫১২টি বাক্য"),
                                onClick = { onOpenCourse("zh_specialist") }
                            )
                        }
                    } else if (isArabic) {
                        item {
                            WelcomeBanner(
                                text = "আরবি স্পোকেন কোর্সে স্বাগতম! প্রতিটি মাখরাজ, হরকত ও বাক্য মন দিয়ে শুনুন এবং জোরে বলুন।",
                                isSpeaking = isSpeaking,
                                onPlayTts = { viewModel.playWelcomeGreeting(language = "arabic", force = true) },
                                onStopTts = { viewModel.stopWelcomeGreeting() }
                            )
                        }

                        // Arabic Alphabet & Makharij Sound Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇸🇦 হরফ, মাখরাজ ও হরকত",
                                title = "আরবি বর্ণমালা ও মাখরাজ চার্ট (الحروف والمخارج)",
                                description = "২৮টি আরবি হরফ, হামযাহ, গোল তা (ة) ও হরকত-তানভীন-শাদ্দাহ। থ্রোট ও এমফ্যাটিক ধ্বনির সঠিক মাখরাজ এবং অডিও।",
                                accentColor = Color(0xFF006C35),
                                partCount = 5,
                                lessonCount = 40,
                                sentenceCount = 40,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "চার্ট দেখুন",
                                customPills = listOf("🇸🇦 মাখরাজ ও হরফ", "🔤 হরকত ও তানভীন", "🔊 সব অডিও"),
                                onClick = { onOpenAlphabetChart("arabic") }
                            )
                        }

                        // Arabic Numbers & Riyal/Dirham Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇸🇦 সংখ্যা ও রিয়াল-দিরহাম",
                                title = "আরবি সংখ্যা, রিয়াল ও সময় চার্ট (الأرقام العربية)",
                                description = "আরবি সংখ্যা (٠–٩), ১ থেকে ১,০০০+, সৌদি রিয়াল ও দিরহাম গণনা এবং ঘড়ির সময় বলার নিয়ম ও অডিও।",
                                accentColor = Color(0xFF4527A0),
                                partCount = 5,
                                lessonCount = 100,
                                sentenceCount = 100,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "সংখ্যা দেখুন",
                                customPills = listOf("🔢 আরবি সংখ্যা", "💵 রিয়াল-দিরহাম", "🔊 সব অডিও"),
                                onClick = { onOpenNumbersChart("arabic") }
                            )
                        }

                        // Arabic Calendar & Hijri Months Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇸🇦 দিন, মাস ও হিজরি ক্যালেন্ডার",
                                title = "আরবি দিন, হিজরি ও ইংরেজি মাস চার্ট (الأيام والشهور)",
                                description = "সপ্তাহের ৭ দিন (الأحد–السبت), ১২ হিজরি ও ইংরেজি মাস, ঋতু এবং আজ-কাল-এখন সংক্রান্ত শব্দ ও অডিও।",
                                accentColor = Color(0xFF00695C),
                                partCount = 4,
                                lessonCount = 41,
                                sentenceCount = 41,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "চার্ট দেখুন",
                                customPills = listOf("🗓️ ৭ দিন", "🌙 ১২ হিজরি মাস", "📅 ১২ ইংরেজি মাস", "⏰ সময়কাল"),
                                onClick = { onOpenCalendarChart("arabic") }
                            )
                        }

                        // Arabic 1000 Vocabulary Vault Card
                        item {
                            MainCourseCard(
                                tag = "🇸🇦 শব্দভাণ্ডার · ১,০০০টি শব্দ",
                                title = "১০০০ প্রয়োজনীয় আরবি শব্দ (١٠٠٠ كلمة عربية)",
                                description = "হরকতযুক্ত আরবি, বাংলা-আরবি কগনেট শব্দ, গাল্ফ প্রবাস, ওমরাহ, বাজার, হাসপাতাল ও দৈনন্দিন ২০ ক্যাটাগরির ১,০০০ শব্দ।",
                                accentColor = Color(0xFFE65100),
                                partCount = 20,
                                lessonCount = 1000,
                                sentenceCount = 1000,
                                badgeText = "Vault",
                                actionButtonText = "শব্দভাণ্ডার খুলুন",
                                customPills = listOf("🗂️ ২০ ক্যাটাগরি", "🗣️ ১,০০০ শব্দ", "📖 হরকতসহ", "🔊 দ্বৈত অডিও"),
                                onClick = { onOpenVocabVault("arabic") }
                            )
                        }

                        // Arabic Stage 0 + A1 Standard Course Card
                        item {
                            MainCourseCard(
                                tag = "🇸🇦 স্ট্যান্ডার্ড কোর্স: শূন্য থেকে A1",
                                title = "শূন্য থেকে আরবি বলা (মাখরাজ, হরকত ও A1)",
                                description = "স্টেজ ০ মাখরাজ ও হরকত বুটক্যাম্প, শুভেচ্ছা, বাজার-দামদর, খাবার, যাতায়াত, এয়ারপোর্ট-হোটেল এবং মক্কা-মদিনা ওমরাহ রোল-প্লেসহ ১৬টি পূর্ণাঙ্গ ইউনিট।",
                                accentColor = Color(0xFF006C35),
                                partCount = arStdPartCount,
                                lessonCount = arStdLessonCount,
                                sentenceCount = arStdSentenceCount,
                                customPills = listOf("🇸🇦 ১৬টি পার্ট", "🎧 ৬৪টি অডিও লেসন", "🗣️ ৫১২টি বাক্য"),
                                onClick = { onOpenCourse("ar_standard") }
                            )
                        }

                        // Arabic Elementary A2 Course Card
                        item {
                            MainCourseCard(
                                tag = "🇸🇦 এলিমেন্টারি: লেভেল A2",
                                title = "দৈনন্দিন প্রবাস ও গাল্ফ আরবি: A2",
                                description = "অতীত ও ভবিষ্যৎ কাল, হাসপাতাল-ক্লিনিক, ব্যাংক-রেমিট্যান্স, হোটেল, এয়ারপোর্ট, ড্রাইভিং-সিম কার্ড ও গাল্ফ কথ্য আরবির ১৬টি ইউনিট।",
                                accentColor = Color(0xFF00796B),
                                partCount = arA2PartCount,
                                lessonCount = arA2LessonCount,
                                sentenceCount = arA2SentenceCount,
                                customPills = listOf("🇸🇦 ১৬টি পার্ট", "🎧 ৬৪টি অডিও লেসন", "🗣️ ৫১২টি বাক্য"),
                                onClick = { onOpenCourse("ar_a2") }
                            )
                        }

                        // Arabic Intermediate B1 Course Card
                        item {
                            MainCourseCard(
                                tag = "🇸🇦 ইন্টারমিডিয়েট: লেভেল B1",
                                title = "প্রফেশনাল ও সাবলীল আরবি: B1",
                                description = "শর্তমূলক বাক্য, মতামত ও যুক্তি, ইজার বাসা ভাড়া চুক্তি, আবশের-সরকারি সেবা, চাকরির ইন্টারভিউ, গ্রাহক সেবা ও প্রমিত-গাল্ফ সমন্বয়।",
                                accentColor = Color(0xFF1565C0),
                                partCount = arB1PartCount,
                                lessonCount = arB1LessonCount,
                                sentenceCount = arB1SentenceCount,
                                customPills = listOf("🇸🇦 ১৬টি পার্ট", "🎧 ৬৪টি অডিও লেসন", "🗣️ ৫১২টি বাক্য"),
                                onClick = { onOpenCourse("ar_b1") }
                            )
                        }

                        // Arabic Upper-Intermediate B2 Course Card
                        item {
                            MainCourseCard(
                                tag = "🇸🇦 আপার-ইন্টারমিডিয়েট: লেভেল B2",
                                title = "দক্ষ ও প্রমিত আরবি: B2",
                                description = "উচ্চতর প্রমিত আরবি, বিতর্ক ও প্রবাদ, কর্পোরেট মিটিং, আইন ও চুক্তি, সংবাদ-মিডিয়া, এআই ও প্রযুক্তি এবং পেশাদার উপস্থাপনা।",
                                accentColor = Color(0xFF6A1B9A),
                                partCount = arB2PartCount,
                                lessonCount = arB2LessonCount,
                                sentenceCount = arB2SentenceCount,
                                customPills = listOf("🇸🇦 ১৬টি পার্ট", "🎧 ৬৪টি অডিও লেসন", "🗣️ ৫১২টি বাক্য"),
                                onClick = { onOpenCourse("ar_b2") }
                            )
                        }

                        // Arabic Specialist Pro Course Card
                        item {
                            MainCourseCard(
                                tag = "🕋 প্রো স্পেশালাইজেশন: গাল্ফ ও হজ্জ",
                                title = "স্পেশালিস্ট প্রো: গাল্ফ, হজ্জ ও বাণিজ্য",
                                description = "হজ্জ-উমরাহ গাইডিং, দুবাই-রিয়াদ ইমপোর্ট ও এল/সি, গাল্ফ প্রবাসী জীবন, আদালত-থানা, ইসলামী দাওয়াহ ও দ্রুত গাল্ফ স্ল্যাং মাস্টারি।",
                                accentColor = Color(0xFF00695C),
                                partCount = arSpPartCount,
                                lessonCount = arSpLessonCount,
                                sentenceCount = arSpSentenceCount,
                                customPills = listOf("🕋 ১৬টি পার্ট", "🎧 ৬৪টি অডিও লেসন", "🗣️ ৫১২টি বাক্য"),
                                onClick = { onOpenCourse("ar_specialist") }
                            )
                        }
                    } else if (isKorean) {
                        item {
                            WelcomeBanner(
                                text = "কোরিয়ান স্পোকেন কোর্সে স্বাগতম! হাঙ্গুল, বাচ্ছিম এবং প্রতিটি বাক্য মন দিয়ে শুনুন ও জোরে বলুন।",
                                isSpeaking = isSpeaking,
                                onPlayTts = { viewModel.playWelcomeGreeting(language = "korean", force = true) },
                                onStopTts = { viewModel.stopWelcomeGreeting() }
                            )
                        }

                        // Korean Hangul & Batchim Sound Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇰🇷 হাঙ্গুল ও বাচ্ছিম",
                                title = "কোরিয়ান হাঙ্গুল বর্ণমালা ও বাচ্ছিম চার্ট (한글)",
                                description = "১৪টি মৌলিক ব্যঞ্জন, ৫টি যুগ্ম ব্যঞ্জন, ২১টি স্বরবর্ণ ও ৭টি বাচ্ছিম (받침) উচ্চারণ নিয়ম এবং অডিও।",
                                accentColor = Color(0xFF0047A0),
                                partCount = 5,
                                lessonCount = 47,
                                sentenceCount = 47,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "চার্ট দেখুন",
                                customPills = listOf("🇰🇷 মৌলিক ও যুগ্ম", "🔤 ২১টি স্বরবর্ণ", "🔊 সব অডিও"),
                                onClick = { onOpenAlphabetChart("korean") }
                            )
                        }

                        // Korean Dual Numbers & Won Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇰🇷 দ্বৈত সংখ্যা ও ওন",
                                title = "কোরিয়ান সংখ্যা ও গণনা চার্ট (숫자)",
                                description = "সিনো-কোরিয়ান (일, 이, 삼) এবং নেটিভ কোরিয়ান (하나, 둘, 셋) সংখ্যা, বয়স, সময় ও ওন (원) গণনা ও অডিও।",
                                accentColor = Color(0xFF4527A0),
                                partCount = 5,
                                lessonCount = 100,
                                sentenceCount = 100,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "সংখ্যা দেখুন",
                                customPills = listOf("🔢 ১–১০০ সংখ্যা", "💵 ওন ও সময়", "🔊 সব অডিও"),
                                onClick = { onOpenNumbersChart("korean") }
                            )
                        }

                        // Korean Calendar & Seasons Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇰🇷 দিন, মাস, ঋতু ও ছুটি",
                                title = "কোরিয়ান ক্যালেন্ডার ও ঋতু চার্ট (요일·월)",
                                description = "৭ দিন (월–일), ১২ মাস (1월–12월), ৪ ঋতু (বসন্ত-শীত) এবং সল্লাল-ছুসক ছুটিসহ ৩১টি কার্ড ও অডিও।",
                                accentColor = Color(0xFF00695C),
                                partCount = 4,
                                lessonCount = 31,
                                sentenceCount = 31,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "চার্ট দেখুন",
                                customPills = listOf("🗓️ ৭ দিন", "📅 ১২ মাস", "🌸 ৪ ঋতু", "⏰ সময় ও ছুটি"),
                                onClick = { onOpenCalendarChart("korean") }
                            )
                        }

                        // Korean 1000 Vocabulary Vault Card
                        item {
                            MainCourseCard(
                                tag = "🇰🇷 শব্দভাণ্ডার · ১,০০০টি শব্দ",
                                title = "১০০০ প্রয়োজনীয় কোরিয়ান শব্দ (필수 단어)",
                                description = "পরিবার, খাবার-হালাল, কারখানা-যন্ত্রপাতি, সাবওয়ে, ব্যাংক, হাসপাতাল ও জরুরি ২০ ক্যাটাগরির ১,০০০ কোরিয়ান শব্দ।",
                                accentColor = Color(0xFFE65100),
                                partCount = 20,
                                lessonCount = 1000,
                                sentenceCount = 1000,
                                badgeText = "Vault",
                                actionButtonText = "শব্দভাণ্ডার খুলুন",
                                customPills = listOf("🗂️ ২০ ক্যাটাগরি", "🗣️ ১,০০০ শব্দ", "📖 রোমানাইজেশন", "🔊 দ্বৈত অডিও"),
                                onClick = { onOpenVocabVault("korean") }
                            )
                        }

                        // Korean Stage 0 + A1 Standard Course Card
                        item {
                            MainCourseCard(
                                tag = "🇰🇷 স্ট্যান্ডার্ড কোর্স: শূন্য থেকে A1",
                                title = "শূন্য থেকে কোরিয়ান বলা (হাঙ্গুল, বাচ্ছিম ও A1)",
                                description = "স্টেজ ০ হাঙ্গুল ও বাচ্ছিম বুটক্যাম্প, অভিবাদন, দ্বৈত সংখ্যা, হালাল খাবার, সাবওয়ে-বাস, কারখানা-অফিস ও ১১২/১১৯ ইমার্জেন্সিসহ ১৬টি পূর্ণাঙ্গ ইউনিট।",
                                accentColor = Color(0xFF0047A0),
                                partCount = koStdPartCount,
                                lessonCount = koStdLessonCount,
                                sentenceCount = koStdSentenceCount,
                                customPills = listOf("🇰🇷 ১৬টি পার্ট", "🎧 ৬৪টি অডিও লেসন", "🗣️ ৫১২টি বাক্য"),
                                onClick = { onOpenCourse("ko_standard") }
                            )
                        }
                    } else if (isQuran) {
                        item {
                            WelcomeBanner(
                                text = "সহজে কুরআন শিক্ষা ও তাজবীদ কোর্সে আপনাকে স্বাগতম! প্রতিটি হরফ, মাখরাজ ও আয়াত শুনুন এবং তিলাওয়াত অনুশীলন করুন।",
                                isSpeaking = isSpeaking,
                                onPlayTts = { viewModel.playWelcomeGreeting(language = "quran", force = true) },
                                onStopTts = { viewModel.stopWelcomeGreeting() }
                            )
                        }

                        // Complete 8 Stages Quran Course Card
                        item {
                            MainCourseCard(
                                tag = "📖 নূরানী ও নাদিয়াতুল ক্বোরআন মেথডোলজি",
                                title = "সহজে কুরআন শিক্ষা ও তাজবীদ কোর্স (৮টি পর্যায়)",
                                description = "আরবি ২৯টি হরফ, ১৭টি মাখরাজ, হরকত, তানভীন, জযম, তাশদীদ, নূন সাকিন, মীম সাকিন, মাদ্দ ও ১০টি ছোট সূরা।",
                                accentColor = Color(0xFF1B5E20),
                                partCount = qrPartCount,
                                lessonCount = qrLessonCount,
                                sentenceCount = qrSentenceCount,
                                customPills = listOf("📖 ৮টি পর্যায়", "🎧 ৩১টি অডিও লেসন", "🕌 ২৪৮টি মশ্‌ক ও আয়াত"),
                                onClick = { onOpenCourse("quran") }
                            )
                        }
                    } else if (isRegionalBangla) {
                        item {
                            WelcomeBanner(
                                text = "বাংলাদেশের বিভাগীয় আঞ্চলিক ভাষা স্পোকেন কোর্সে আপনাকে স্বাগতম! প্রতিটি শব্দ ও বাক্য শুনুন এবং জোরে জোরে বলুন।",
                                isSpeaking = isSpeaking,
                                onPlayTts = { viewModel.playWelcomeGreeting(language = "regional_bangla", force = true) },
                                onStopTts = { viewModel.stopWelcomeGreeting() }
                            )
                        }

                        // Complete 9 Regions Side-by-Side Comparative Course Card
                        item {
                            MainCourseCard(
                                tag = "🇧🇩 ৯ অঞ্চল পাশাপাশি · তুলনামূলক কোর্স",
                                title = "একই বাক্য ৯টি অঞ্চলের কথ্য ভাষায় পাশাপাশি শিক্ষা",
                                description = "চট্টগ্রাম, নোয়াখালী, সিলেট, পুরান ঢাকা, বরিশাল, রাজশাহী, রংপুর, খুলনা ও ময়মনসিংহের খাঁটি কথ্য রূপ একসাথে তুলনা করে শিখুন।",
                                accentColor = Color(0xFF006A4E),
                                partCount = bdPartCount,
                                lessonCount = bdLessonCount,
                                sentenceCount = bdSentenceCount,
                                customPills = listOf("🇧🇩 ৮টি অধ্যায়", "🎧 ৩২টি তুলনামূলক লেসন", "🗣️ ৫৭৬টি আঞ্চলিক বাক্য"),
                                onClick = { onOpenCourse("regional_bangla") }
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

                        // English Calendar & Time Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇬🇧 দিন, মাস ও ঋতু · ৪০টি শব্দ",
                                title = "ইংরেজি দিন, মাস ও ঋতু চার্ট (Days, Months & Seasons)",
                                description = "সপ্তাহের ৭ দিন, ১২ মাস, ৬টি ঋতু এবং আজ, কাল, সকাল, রাতসহ সময় সংক্রান্ত প্রয়োজনীয় শব্দাবলি ও অডিও উচ্চারণ।",
                                accentColor = Color(0xFF1565C0),
                                partCount = 4,
                                lessonCount = 40,
                                sentenceCount = 40,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "চার্ট দেখুন",
                                customPills = listOf("🗓️ ৭ দিন", "📅 ১২ মাস", "🌸 ৬ ঋতু", "⏰ দিনকাল"),
                                onClick = { onOpenCalendarChart("english") }
                            )
                        }

                        // English 1000 Vocabulary Vault Card
                        item {
                            MainCourseCard(
                                tag = "🇬🇧 শব্দভাণ্ডার · ১,০০০টি শব্দ",
                                title = "১০০০ দৈনন্দিন প্রয়োজনীয় ইংরেজি শব্দ (Vocabulary Vault)",
                                description = "পরিবার, কাজ, ব্যবসা, প্রযুক্তি, স্বাস্থ্যসহ ২০টি জীবনের গুরুত্বপূর্ণ বিষয়ের ১,০০০টি ইংরেজি শব্দ, একবচন-বহুবচন ও সঠিক অডিও উচ্চারণ।",
                                accentColor = Color(0xFF1976D2),
                                partCount = 20,
                                lessonCount = 1000,
                                sentenceCount = 1000,
                                badgeText = "Vault",
                                actionButtonText = "শব্দভাণ্ডার খুলুন",
                                customPills = listOf("🗂️ ২০ ক্যাটাগরি", "🗣️ ১,০০০ শব্দ", "👥 একবচন ও বহুবচন", "🔊 দ্বৈত অডিও"),
                                onClick = { onOpenVocabVault("english") }
                            )
                        }

                        // English Level A1: Standard Course
                        item {
                            MainCourseCard(
                                tag = "🇬🇧 স্ট্যান্ডার্ড কোর্স: শূন্য থেকে A1",
                                title = "মৌলিক স্পোকেন ইংলিশ (English A1: Foundations)",
                                description = "প্রথম পরিচয়, পরিবার, সংখ্যা, দৈনন্দিন রুটিন, সময় ও তারিখ, প্রেজেন্ট কন্টিনিউয়াস, WH প্রশ্ন, কেনাকাটা, রেস্তোরাঁ, দিকনির্দেশনা ও A1 স্পিকিং টেস্ট।",
                                accentColor = Color(0xFF1E3A8A),
                                partCount = enStandardA1PartCount,
                                lessonCount = enStandardA1LessonCount,
                                sentenceCount = enStandardA1SentenceCount,
                                customPills = listOf("🇬🇧 ১৬ ইউনিট", "💬 ৫১২ বাক্য", "🎯 A1 ফ্লুয়েন্সি"),
                                onClick = { onOpenCourse("en_standard_a1") }
                            )
                        }

                        // English Level A2: Standard Course
                        item {
                            MainCourseCard(
                                tag = "🇬🇧 স্ট্যান্ডার্ড কোর্স: লেভেল A2",
                                title = "প্রাত্যহিক ফ্লুয়েন্সি (English A2: Elementary Fluency)",
                                description = "অতীতের গল্প, Was/Were ও ভার্বস, ভবিষ্যৎ পরিকল্পনা (Going to/Will), প্রস্তাব ও নিমন্ত্রণ, বাধ্যবাধকতা (Must), পরামর্শ (Should), স্বাস্থ্য, হোটেল, বিমানবন্দর, তুলনা, পোশাক কেনাকাটা ও অফিসিয়াল যোগাযোগ।",
                                accentColor = Color(0xFF0F766E),
                                partCount = enStandardA2PartCount,
                                lessonCount = enStandardA2LessonCount,
                                sentenceCount = enStandardA2SentenceCount,
                                customPills = listOf("🇬🇧 ১৬ ইউনিট", "💬 ৫১২ বাক্য", "🎯 A2 ফ্লুয়েন্সি"),
                                onClick = { onOpenCourse("en_standard_a2") }
                            )
                        }

                        // English Level B1: Standard Course
                        item {
                            MainCourseCard(
                                tag = "🇬🇧 স্ট্যান্ডার্ড কোর্স: লেভেল B1",
                                title = "ইন্টারমিডিয়েট ফ্লুয়েন্সি (English B1: Intermediate Fluency)",
                                description = "মতামত প্রকাশ ও বিতর্ক, পরামর্শ ও মোডাল ভার্ব, কাল্পনিক পরিস্থিতি ও শর্তমূলক বাক্য, প্যাসিভ ভয়েস, পরোক্ষ উক্তি, রিলেটিভ ক্লজ, ফ্রেজাল ভার্ব, প্রফেশনাল নেটওয়ার্কিং ও ৩ মিনিটের প্রেজেন্টেশন।",
                                accentColor = Color(0xFF6B21A8),
                                partCount = enStandardB1PartCount,
                                lessonCount = enStandardB1LessonCount,
                                sentenceCount = enStandardB1SentenceCount,
                                customPills = listOf("🇬🇧 ১৬ ইউনিট", "💬 ৫১২ বাক্য", "🎯 B1 ফ্লুয়েন্সি"),
                                onClick = { onOpenCourse("en_standard_b1") }
                            )
                        }

                        // English Level B2: Standard Course
                        item {
                            MainCourseCard(
                                tag = "🇬🇧 স্ট্যান্ডার্ড কোর্স: লেভেল B2",
                                title = "কর্পোরেট ও ক্যারিয়ার ফ্লুয়েন্সি (English B2: Corporate & Career Mastery)",
                                description = "হাই-ইমপ্যাক্ট সেলফ-ইন্ট্রোডাকশন, STAR ইন্টারভিউ মেথড, মিটিং পরিচালনা, বিজনেস পিচ, নেগোসিয়েশন, কনস্ট্রাক্টিভ ফিডব্যাক, সংকট নিরসন, ডিপ্লোম্যাটিক ভাষা, ইডিয়াম ও এক্সিকিউটিভ অ্যাসেসমেন্ট।",
                                accentColor = Color(0xFF4338CA),
                                partCount = enStandardB2PartCount,
                                lessonCount = enStandardB2LessonCount,
                                sentenceCount = enStandardB2SentenceCount,
                                customPills = listOf("🇬🇧 ১৬ ইউনিট", "💬 ৫১২ বাক্য", "🎯 B2 ফ্লুয়েন্সি"),
                                onClick = { onOpenCourse("en_standard_b2") }
                            )
                        }

                        // 4. Present Tense (বর্তমান কাল)
                        item {
                            MainCourseCard(
                                tag = "🇬🇧 Present Tense (বর্তমান কাল)",
                                title = "সহজ নিয়মে কথা বলুন (Present Tense: Be-Verbs, Q&A & Presentation)",
                                description = "পেশা, ব্যক্তিত্ব, দৈনন্দিন বস্তু, অবস্থান, প্রশ্ন-উত্তর, গুড অ্যাট/ব্যাড অ্যাট ও সম্পূর্ণ প্রেজেন্টেশন বর্তমান কালে সাবলীলভাবে অনুশীলন করুন।",
                                accentColor = Color(0xFF00796B),
                                partCount = presentPartCount,
                                lessonCount = presentLessonCount,
                                sentenceCount = presentSentenceCount,
                                onClick = { onOpenCourse("present") }
                            )
                        }

                        // 5. Past Tense (অতীত কাল)
                        item {
                            MainCourseCard(
                                tag = "🇬🇧 Past Tense (অতীত কাল)",
                                title = "অতীতের কথা বলুন (Was/Were, Had & Past Actions)",
                                description = "অতীতের অভ্যাস, স্মৃতি, অভিজ্ঞতা ও অতীতের কাজ বর্ণনার সহজ স্পোকেন রুলস ও অডিও ড্রিল।",
                                accentColor = Color(0xFF5E35B1),
                                partCount = pastPartCount,
                                lessonCount = pastLessonCount,
                                sentenceCount = pastSentenceCount,
                                onClick = { onOpenCourse("past") }
                            )
                        }

                        // 6. Future Tense (ভবিষ্যৎ কাল)
                        item {
                            MainCourseCard(
                                tag = "🇬🇧 Future Tense (ভবিষ্যৎ কাল)",
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

                        // Japanese Calendar & Time Chart Card
                        item {
                            MainCourseCard(
                                tag = "🇯🇵 দিন, মাস ও ঋতু · ৩৮টি শব্দ",
                                title = "জাপানি দিন, মাস ও ঋতু চার্ট (曜日・月・季節)",
                                description = "সপ্তাহের ৭ দিন, ১২ মাস, ৪টি ঋতু এবং আজ, কাল, সকাল, রাতসহ সময় সংক্রান্ত প্রয়োজনীয় শব্দাবলি ও অডিও উচ্চারণ।",
                                accentColor = Color(0xFFC62828),
                                partCount = 4,
                                lessonCount = 38,
                                sentenceCount = 38,
                                badgeText = "১০০% ফ্রি",
                                actionButtonText = "চার্ট দেখুন",
                                customPills = listOf("🗓️ ৭ দিন", "📅 ১২ মাস", "🌸 ৪ ঋতু", "⏰ দিনকাল"),
                                onClick = { onOpenCalendarChart("japanese") }
                            )
                        }

                        // Japanese 1000 Vocabulary Vault Card
                        item {
                            MainCourseCard(
                                tag = "🇯🇵 শব্দভাণ্ডার · ১,০০০টি শব্দ",
                                title = "১০০০ প্রয়োজনীয় জাপানি শব্দ (日本語 必須単語 1000)",
                                description = "কাঞ্জি, হিরাগানা রিডিং, একবচন-বহুবচন ও অর্থসহ দৈনন্দিন জীবনের ২০টি বিষয়ের ১,০০০টি অতিপ্রয়োজনীয় জাপানি শব্দ ও দ্বৈত অডিও।",
                                accentColor = Color(0xFFAD1457),
                                partCount = 20,
                                lessonCount = 1000,
                                sentenceCount = 1000,
                                badgeText = "Vault",
                                actionButtonText = "শব্দভাণ্ডার খুলুন",
                                customPills = listOf("🗂️ ২০ ক্যাটাগরি", "🗣️ ১,০০০ শব্দ", "🈁 কাঞ্জি ও হিরাগানা", "🔊 দ্বৈত অডিও"),
                                onClick = { onOpenVocabVault("japanese") }
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

                        // Standard curriculum (Japanese-Spoken-Curriculum-Plan.md, phase 4): Upper Intermediate N2
                        item {
                            MainCourseCard(
                                tag = "🇯🇵 স্ট্যান্ডার্ড কোর্স: লেভেল JLPT N2",
                                title = "জাপানিজ N2: মিটিং, প্রেজেন্টেশন ও N2 স্পিকিং",
                                description = "ব্যবসায়িক মিটিং ও এজেন্ডা, ৫ মিনিটের প্রেজেন্টেশন, সংবাদ ও সমাজ বিশ্লেষণ, কেইগো শিষ্টাচার, গ্রাহক সেবা ও JLPT N2 স্পিকিং টেস্ট।",
                                accentColor = Color(0xFF4A148C),
                                partCount = jpN2PartCount,
                                lessonCount = jpN2LessonCount,
                                sentenceCount = jpN2SentenceCount,
                                customPills = listOf("🇯🇵 ১৬টি পার্ট", "💼 বিজনেস মিটিং ও প্রেজেন্টেশন", "🎯 JLPT N2 স্পিকিং"),
                                onClick = { onOpenCourse("jp_n2") }
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
private fun CourseLiveTranslatorCard(
    translatorLanguage: TranslatorLanguage,
    onClick: () -> Unit
) {
    val accent = Color(translatorLanguage.accentHex)
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.2.dp, accent.copy(alpha = 0.42f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            accent.copy(alpha = 0.14f),
                            accent.copy(alpha = 0.04f)
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
                    color = accent,
                    modifier = Modifier.size(44.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Mic,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
                Spacer(Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Surface(
                            color = accent.copy(alpha = 0.15f),
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Text(
                                text = "${translatorLanguage.flag} লাইভ ভয়েস অনুবাদক",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = accent,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                        Text(
                            text = "• বাংলা উচ্চারণ",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF10B981)
                        )
                    }
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "বাংলা ➔ ${translatorLanguage.titleBn} বলুন ও শুনুন",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "কথা বলে বা লিখে তাৎক্ষণিক অনুবাদ ও শুদ্ধ বাংলা উচ্চারণ পান",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(Modifier.width(8.dp))
                Surface(
                    color = accent,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "খুলুন",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(Modifier.width(3.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(12.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CenteredMessage(content: @Composable () -> Unit) {
    Box(Modifier.fillMaxSize().padding(24.dp), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) { content() }
    }
}
