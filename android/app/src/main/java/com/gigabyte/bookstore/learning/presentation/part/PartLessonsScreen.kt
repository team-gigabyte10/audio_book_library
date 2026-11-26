package com.gigabyte.bookstore.learning.presentation.part

import android.app.Activity
import android.widget.Toast
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
import androidx.compose.foundation.lazy.items
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.ads.AdConfig
import com.gigabyte.bookstore.data.ads.FacebookRewardAdManager
import com.gigabyte.bookstore.data.preferences.AppPreferences
import com.gigabyte.bookstore.learning.data.LessonSummary
import com.gigabyte.bookstore.learning.domain.model.LessonState
import com.gigabyte.bookstore.learning.presentation.syllabus.SyllabusPartTheme
import com.gigabyte.bookstore.learning.presentation.syllabus.getSyllabusPartTheme
import com.gigabyte.bookstore.presentation.components.AppBackground
import com.gigabyte.bookstore.presentation.components.ModuleUnlockDialog
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar
import kotlinx.coroutines.flow.MutableStateFlow

private fun Int.toBanglaDigits(): String {
    val bnDigits = charArrayOf('০', '১', '২', '৩', '৪', '৫', '৬', '৭', '৮', '৯')
    return this.toString().map { if (it in '0'..'9') bnDigits[it - '0'] else it }.joinToString("")
}

@Composable
fun PartLessonsScreen(
    viewModel: PartLessonsViewModel,
    onBackClick: () -> Unit,
    onOpenLesson: (String) -> Unit,
    onOpenIntro: (String) -> Unit = {},
    onNavigateToPayment: (() -> Unit)? = null
) {
    val lessons by viewModel.lessons.collectAsStateWithLifecycle()
    val part by viewModel.part.collectAsStateWithLifecycle()
    val title by viewModel.title.collectAsStateWithLifecycle()
    val theme = getSyllabusPartTheme(part?.order ?: 1)

    val context = LocalContext.current
    val app = context.applicationContext as? BanglaAudiobookApp
    val appPrefs = app?.appPreferences
    val unlockedBundles by (appPrefs?.unlockedBundles ?: MutableStateFlow(emptySet())).collectAsStateWithLifecycle()
    val isAdmin by (appPrefs?.isAdmin ?: MutableStateFlow(false)).collectAsStateWithLifecycle()
    val moduleUpdates by (appPrefs?.unlockedModuleUpdates ?: MutableStateFlow(0L)).collectAsStateWithLifecycle()
    val allowRewardAdUnlock by (appPrefs?.allowRewardAdUnlock ?: MutableStateFlow(true)).collectAsStateWithLifecycle()
    val rewardUnlockHours by (appPrefs?.rewardUnlockHours ?: MutableStateFlow(24)).collectAsStateWithLifecycle()

    val currentPart = part
    val courseBundleId = remember(currentPart) {
        AppPreferences.getCourseBundleId("", currentPart?.id.orEmpty())
    }
    val isQuran = currentPart?.id?.startsWith("qr-") == true
    val isCourseOwned = remember(unlockedBundles, isAdmin, courseBundleId, isQuran) {
        isQuran || isAdmin || unlockedBundles.contains("mega_bundle") || unlockedBundles.contains(courseBundleId)
    }

    val isPartUnlocked = remember(isCourseOwned, currentPart, moduleUpdates) {
        if (currentPart == null) true
        else isCourseOwned || currentPart.order <= 1 || (appPrefs?.isCourseModuleUnlocked(currentPart.order, currentPart.id, "") == true)
    }

    var showUnlockDialog by remember { mutableStateOf(false) }
    var isLoadingRewardAd by remember { mutableStateOf(false) }
    val isAdAllowed = remember(currentPart) { !isQuran && AdConfig.isAdAllowedForCourse(currentPart?.id) }
    val effectiveAllowRewardAd = remember(isAdAllowed, allowRewardAdUnlock) {
        if (isAdAllowed) allowRewardAdUnlock else false
    }

    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = {
                    Column {
                        Text(
                            text = title.ifBlank { "লেসনসমূহ" },
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        if (!part?.titleTarget.isNullOrBlank()) {
                            Text(
                                text = part?.titleTarget.orEmpty(),
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.White.copy(alpha = 0.88f),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "ফিরে যান", tint = Color.White)
                    }
                }
            )
        }
    ) { padding ->
        AppBackground(modifier = Modifier.fillMaxSize().padding(padding)) {
            val list = lessons
            when {
                list == null -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
                list.isEmpty() -> Box(Modifier.fillMaxSize().padding(24.dp), contentAlignment = Alignment.Center) {
                    Text("এই অংশে এখনো যাচাই করা লেসন নেই।", style = MaterialTheme.typography.bodyMedium)
                }
                else -> {
                    val standardLessons = list.filter { !it.id.startsWith("en-wh-") }
                    val whLessons = list.filter { it.id.startsWith("en-wh-") }
                    val completedLessons = standardLessons.count { it.state == LessonState.DONE }
                    val progressPercent = if (standardLessons.isNotEmpty()) ((completedLessons.toFloat() / standardLessons.size) * 100).toInt() else 0

                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        // Part Header Overview Card
                        item {
                            PartOverviewBanner(
                                partOrder = part?.order ?: 1,
                                titleBn = part?.titleBn ?: title,
                                titleTarget = part?.titleTarget,
                                lessonCount = standardLessons.size,
                                completedLessons = completedLessons,
                                progressPercent = progressPercent,
                                theme = theme
                            )
                        }

                        item {
                            Text(
                                text = "লেসন তালিকা (${standardLessons.size}টি লেসন)",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(top = 4.dp, bottom = 2.dp)
                            )
                        }

                        items(standardLessons, key = { it.id }) { lesson ->
                            PartLessonCard(
                                lesson = lesson,
                                theme = theme,
                                isUnlocked = isPartUnlocked,
                                onClick = {
                                    if (isPartUnlocked) {
                                        onOpenLesson(lesson.id)
                                    } else {
                                        showUnlockDialog = true
                                    }
                                }
                            )
                        }

                        // English Foundations Specific Monologues & WH Expandable List
                        val isEnglishFoundations = part?.id?.startsWith("en-foundations-") == true

                        // Bottom of Lesson 4: Self Presentation Monologue (English Foundations Part 1 only)
                        if (isEnglishFoundations && part?.order == 1) {
                            item(key = "monologue_self_presentation") {
                                SpeechMonologueCard(
                                    badgeText = "🎙️ অংশ ০১ সমাপনী স্পিচ",
                                    actionText = "ইংলিশ স্পিচ শুনুন",
                                    title = "🗣️ আত্মপরিচয় উপস্থাপনা (Self Presentation)",
                                    subtitle = "১২টি বাক্যে সম্পূর্ণ আত্মপরিচয় কেবল ইংরেজিতে শুনুন এবং সাবলীলভাবে অনুশীলন করুন।",
                                    pills = listOf("🇬🇧 Only English", "🎧 Natural Audio", "⚡ 12 Sentences"),
                                    accentColor = Color(0xFF2E7D32),
                                    onClick = { onOpenIntro("self_presentation.md") }
                                )
                            }
                        }

                        // Bottom of Lesson 12: 100 Essential WH-Questions Mastery (Expandable List - English Foundations Part 3 only)
                        if (isEnglishFoundations && part?.order == 3 && whLessons.isNotEmpty()) {
                            item(key = "expandable_100_wh_questions") {
                                Wh100ExpandableCard(
                                    lessons = whLessons,
                                    isUnlocked = isPartUnlocked,
                                    onOpenLesson = { lessonId ->
                                        if (isPartUnlocked) {
                                            onOpenLesson(lessonId)
                                        } else {
                                            showUnlockDialog = true
                                        }
                                    }
                                )
                            }
                        }

                    // Bottom of Lesson 17: Daily Activities Monologue & Mini Presentations (English Foundations Part 4 only)
                    if (isEnglishFoundations && part?.order == 4) {
                        item(key = "monologue_daily_activities") {
                            SpeechMonologueCard(
                                badgeText = "🎙️ অংশ ০৪ সমাপনী স্পিচ",
                                actionText = "ইংলিশ স্পিচ শুনুন",
                                title = "🗣️ দৈনন্দিন কাজকর্মের বর্ণনা (Daily Activities)",
                                subtitle = "সকাল থেকে রাত পর্যন্ত আপনার দৈনন্দিন রুটিন ইংরেজিতে সাবলীলভাবে বলার একক অনুশীলন।",
                                pills = listOf("🇬🇧 Only English", "🎧 Natural Audio", "⚡ 13 Sentences"),
                                accentColor = Color(0xFF6D28D9),
                                onClick = {
                                    if (isPartUnlocked) {
                                        onOpenIntro("daily_activities.md")
                                    } else {
                                        showUnlockDialog = true
                                    }
                                }
                            )
                        }

                        item(key = "monologue_mini_presentations") {
                            SpeechMonologueCard(
                                badgeText = "🎙️ মিনি প্রেজেন্টেশন স্পিচ",
                                actionText = "প্রেজেন্টেশন শুনুন",
                                title = "📱 টেকনোলজি উপস্থাপনা (Mini Presentations)",
                                subtitle = "Cell Phone, Laptop এবং Facebook ID নিয়ে সহজ ও সাবলীল স্পোকেন ইংলিশ প্রেজেন্টেশন।",
                                pills = listOf("🇬🇧 Only English", "🎧 Natural Audio", "⚡ 3 Topics"),
                                accentColor = Color(0xFF0284C7),
                                onClick = {
                                    if (isPartUnlocked) {
                                        onOpenIntro("mini_presentations.md")
                                    } else {
                                        showUnlockDialog = true
                                    }
                                }
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

    if (showUnlockDialog && currentPart != null) {
        val activity = context as? Activity
        ModuleUnlockDialog(
            partTitleBn = currentPart.titleBn ?: currentPart.titleTarget ?: "মডিউল",
            partOrder = currentPart.order,
            lessonCount = lessons?.size ?: 0,
            isLoadingAd = isLoadingRewardAd,
            allowRewardAd = effectiveAllowRewardAd,
            rewardHours = rewardUnlockHours,
            onDismiss = {
                if (!isLoadingRewardAd) {
                    showUnlockDialog = false
                }
            },
            onWatchAdClick = {
                val partId = currentPart.id
                if (activity != null && isAdAllowed) {
                    isLoadingRewardAd = true
                    FacebookRewardAdManager.getInstance(context).showAd(
                        activity = activity,
                        onRewardEarned = {
                            isLoadingRewardAd = false
                            showUnlockDialog = false
                            appPrefs?.unlockCourseModuleFor24Hours(partId)
                            Toast.makeText(context, "🎉 অভিনন্দন! মডিউলটি পরবর্তী ২৪ ঘণ্টার জন্য আনলক হয়েছে!", Toast.LENGTH_LONG).show()
                        },
                        onClosed = {
                            isLoadingRewardAd = false
                        },
                        onError = { errorMsg ->
                            isLoadingRewardAd = false
                            showUnlockDialog = false
                            // Graceful fallback
                            appPrefs?.unlockCourseModuleFor24Hours(partId)
                            Toast.makeText(context, "বিজ্ঞাপন সার্ভার ব্যস্ত থাকায় আপনার সুবিধার জন্য মডিউলটি আনলক করে দেওয়া হলো! 🎉", Toast.LENGTH_LONG).show()
                        }
                    )
                } else {
                    showUnlockDialog = false
                    appPrefs?.unlockCourseModuleFor24Hours(partId)
                }
            },
            onGoPremiumClick = {
                showUnlockDialog = false
                onNavigateToPayment?.invoke()
            }
        )
    }
}

@Composable
private fun PartOverviewBanner(
    partOrder: Int,
    titleBn: String,
    titleTarget: String?,
    lessonCount: Int,
    completedLessons: Int = 0,
    progressPercent: Int = 0,
    theme: SyllabusPartTheme
) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.5.dp, theme.accentColor.copy(alpha = 0.45f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            theme.accentColor.copy(alpha = 0.18f),
                            theme.accentColor.copy(alpha = 0.04f)
                        )
                    )
                )
                .padding(18.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        color = theme.accentColor,
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.size(52.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = theme.icon,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "PART 0$partOrder · A1 FOUNDATION",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = theme.accentColor,
                            letterSpacing = 0.5.sp
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = titleBn,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        if (!titleTarget.isNullOrBlank()) {
                            Text(
                                text = titleTarget,
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = theme.accentColor.copy(alpha = 0.16f),
                        border = BorderStroke(1.dp, theme.accentColor.copy(alpha = 0.35f))
                    ) {
                        Text(
                            text = "${lessonCount}টি লেসন",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = theme.accentColor,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                    }
                }

                if (lessonCount > 0) {
                    Spacer(modifier = Modifier.height(14.dp))
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "মডিউলের অগ্রগতি",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = "${completedLessons.toBanglaDigits()}/${lessonCount.toBanglaDigits()} সম্পন্ন (${progressPercent.toBanglaDigits()}%)",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (progressPercent == 100) Color(0xFF10B981) else theme.accentColor
                            )
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        LinearProgressIndicator(
                            progress = { (progressPercent / 100f).coerceIn(0f, 1f) },
                            color = if (progressPercent == 100) Color(0xFF10B981) else theme.accentColor,
                            trackColor = theme.accentColor.copy(alpha = 0.15f),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(6.dp)
                                .clip(RoundedCornerShape(3.dp))
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PartLessonCard(
    lesson: LessonSummary,
    theme: SyllabusPartTheme,
    isUnlocked: Boolean = true,
    onClick: () -> Unit
) {
    val isDone = lesson.state == LessonState.DONE
    val isInProgress = lesson.state == LessonState.IN_PROGRESS
    val isVeryImportant = lesson.titleTarget?.contains("Very Important", ignoreCase = true) == true ||
        lesson.titleBn?.contains("অতি গুরুত্বপূর্ণ") == true

    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(
            if (isVeryImportant) 1.5.dp else 1.dp,
            when {
                !isUnlocked -> theme.accentColor.copy(alpha = 0.25f)
                isDone -> Color(0xFF10B981).copy(alpha = 0.5f)
                isInProgress -> Color(0xFFF59E0B).copy(alpha = 0.5f)
                isVeryImportant -> Color(0xFFE11D48).copy(alpha = 0.45f)
                else -> theme.accentColor.copy(alpha = 0.25f)
            }
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isVeryImportant) 3.dp else 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            if (isVeryImportant) {
                Surface(
                    color = Color(0xFFE11D48).copy(alpha = 0.12f),
                    border = BorderStroke(1.dp, Color(0xFFE11D48).copy(alpha = 0.4f)),
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Text(
                        text = "🔥 VERY IMPORTANT FOR SPOKEN ENGLISH",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFE11D48),
                        letterSpacing = 0.4.sp,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    color = when {
                        !isUnlocked -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        isDone -> Color(0xFF10B981).copy(alpha = 0.18f)
                        isInProgress -> Color(0xFFF59E0B).copy(alpha = 0.18f)
                        else -> theme.accentColor.copy(alpha = 0.14f)
                    },
                    shape = CircleShape,
                    modifier = Modifier.size(38.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = when {
                                !isUnlocked -> Icons.Default.Lock
                                isDone -> Icons.Default.CheckCircle
                                isInProgress -> Icons.Default.PlayArrow
                                else -> Icons.Default.PlayCircle
                            },
                            contentDescription = null,
                            tint = when {
                                !isUnlocked -> theme.accentColor
                                isDone -> Color(0xFF10B981)
                                isInProgress -> Color(0xFFD97706)
                                else -> theme.accentColor
                            },
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    val orderFormatted = if (lesson.order < 10) "0${lesson.order}" else "${lesson.order}"
                    Text(
                        text = "Lesson $orderFormatted: ${lesson.titleBn ?: lesson.titleTarget.orEmpty()}",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    if (lesson.titleBn != null && !lesson.titleTarget.isNullOrBlank()) {
                        Text(
                            text = lesson.titleTarget,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    val detail = buildString {
                        append("${lesson.itemCount}টি বাক্য")
                        if (lesson.bestScore > 0) append(" · সেরা স্কোর ${lesson.bestScore}%")
                    }
                    Text(
                        text = detail,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = when {
                        !isUnlocked -> theme.accentColor.copy(alpha = 0.15f)
                        isDone -> Color(0xFF10B981).copy(alpha = 0.16f)
                        isInProgress -> Color(0xFFF59E0B).copy(alpha = 0.16f)
                        else -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                    },
                    border = BorderStroke(
                        1.dp,
                        when {
                            !isUnlocked -> theme.accentColor.copy(alpha = 0.35f)
                            isDone -> Color(0xFF10B981).copy(alpha = 0.45f)
                            isInProgress -> Color(0xFFF59E0B).copy(alpha = 0.45f)
                            else -> Color.Transparent
                        }
                    )
                ) {
                    Text(
                        text = when {
                            !isUnlocked -> "🔒 আনলক"
                            isDone -> "✓ সম্পন্ন"
                            isInProgress -> "চলছে"
                            else -> "শুরু করুন"
                        },
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = when {
                            !isUnlocked -> theme.accentColor
                            isDone -> Color(0xFF10B981)
                            isInProgress -> Color(0xFFD97706)
                            else -> MaterialTheme.colorScheme.onSurfaceVariant
                        },
                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
                    )
                }
            }

            if (isInProgress && lesson.itemCount > 0) {
                Spacer(modifier = Modifier.height(8.dp))
                val itemProgress = ((lesson.lastItemIndex + 1).toFloat() / lesson.itemCount.coerceAtLeast(1)).coerceIn(0f, 1f)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    LinearProgressIndicator(
                        progress = { itemProgress },
                        color = Color(0xFFF59E0B),
                        trackColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.10f),
                        modifier = Modifier
                            .weight(1f)
                            .height(4.dp)
                            .clip(RoundedCornerShape(2.dp))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "বাক্য ${(lesson.lastItemIndex + 1).toBanglaDigits()}/${lesson.itemCount.toBanglaDigits()}",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFD97706)
                    )
                }
            }
        }
    }
}

@Composable
private fun SpeechMonologueCard(
    badgeText: String,
    actionText: String,
    title: String,
    subtitle: String,
    pills: List<String>,
    accentColor: Color,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.5.dp, accentColor.copy(alpha = 0.5f)),
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
                .padding(16.dp)
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
                            text = badgeText,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                    Surface(
                        color = accentColor.copy(alpha = 0.18f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Icon(
                                Icons.Default.PlayArrow,
                                contentDescription = null,
                                tint = accentColor,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(
                                text = actionText,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = accentColor
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = title,
                    fontSize = 17.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = subtitle,
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    pills.forEach { pillText ->
                        Surface(
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = pillText,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun Wh100ExpandableCard(
    lessons: List<LessonSummary>,
    isUnlocked: Boolean = true,
    onOpenLesson: (String) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    val accentColor = Color(0xFFD97706) // Rich amber / golden orange matching WH/Interrogative

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.5.dp, accentColor.copy(alpha = if (isExpanded) 0.85f else 0.45f)),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isExpanded) 4.dp else 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            accentColor.copy(alpha = 0.14f),
                            accentColor.copy(alpha = 0.04f)
                        )
                    )
                )
                .padding(16.dp)
        ) {
            // Header clickable area
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isExpanded = !isExpanded }
            ) {
                Surface(
                    color = accentColor,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "⭐ ১০০টি প্রশ্নোত্তর সংকলন",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                Surface(
                    color = accentColor.copy(alpha = 0.18f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = if (isExpanded) "লুকান" else "তালিকা দেখুন",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = accentColor
                        )
                        Spacer(Modifier.width(4.dp))
                        Icon(
                            imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = if (isExpanded) "Collapse" else "Expand",
                            tint = accentColor,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isExpanded = !isExpanded }
            ) {
                Text(
                    text = "১০০টি প্রয়োজনীয় ডব্লিউএইচ প্রশ্নোত্তর",
                    fontSize = 17.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "When, Who, Why, What, Where, How, How Often, How Long, How Much, How Many — প্রতিটির ১০টি করে বাস্তবসম্মত প্রশ্নোত্তর লেসন আকারে শিখুন।",
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Pills row
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                listOf("১০টি WH শব্দ", "১০০টি প্রশ্নোত্তর", "অডিও + কুইজ").forEach { pillText ->
                    Surface(
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = pillText,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                }
            }

            // Expanded list
            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(
                    modifier = Modifier.padding(top = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    lessons.forEachIndexed { index, lesson ->
                        WhLessonTile(
                            index = index + 1,
                            lesson = lesson,
                            accentColor = accentColor,
                            isUnlocked = isUnlocked,
                            onClick = { onOpenLesson(lesson.id) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun WhLessonTile(
    index: Int,
    lesson: LessonSummary,
    accentColor: Color,
    isUnlocked: Boolean = true,
    onClick: () -> Unit
) {
    val whWord = when {
        lesson.id.contains("how-often") -> "How Often"
        lesson.id.contains("how-long") -> "How Long"
        lesson.id.contains("how-much") -> "How Much"
        lesson.id.contains("how-many") -> "How Many"
        lesson.id.contains("when") -> "When"
        lesson.id.contains("who") -> "Who"
        lesson.id.contains("why") -> "Why"
        lesson.id.contains("what") -> "What"
        lesson.id.contains("where") -> "Where"
        lesson.id.contains("how") -> "How"
        else -> "WH"
    }

    val isDone = lesson.state == LessonState.DONE

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, accentColor.copy(alpha = 0.25f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                color = accentColor.copy(alpha = 0.14f),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.width(72.dp).height(38.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = whWord,
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = accentColor
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = lesson.titleBn ?: lesson.titleTarget.orEmpty(),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${lesson.itemCount}টি প্রশ্নোত্তর · অডিও সহ অনুশীলন",
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 11.5.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Surface(
                color = when {
                    !isUnlocked -> accentColor.copy(alpha = 0.12f)
                    isDone -> Color(0xFF10B981).copy(alpha = 0.18f)
                    else -> accentColor.copy(alpha = 0.12f)
                },
                shape = CircleShape,
                modifier = Modifier.size(32.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = when {
                            !isUnlocked -> Icons.Default.Lock
                            isDone -> Icons.Default.CheckCircle
                            else -> Icons.Default.PlayArrow
                        },
                        contentDescription = "Start Lesson",
                        tint = if (isDone && isUnlocked) Color(0xFF10B981) else accentColor,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}
