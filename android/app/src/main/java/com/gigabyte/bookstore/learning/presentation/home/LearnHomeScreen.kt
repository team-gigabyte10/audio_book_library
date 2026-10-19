package com.gigabyte.bookstore.learning.presentation.home

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.RecordVoiceOver
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.learning.data.ContinueLesson
import com.gigabyte.bookstore.learning.data.LessonItemSummary
import com.gigabyte.bookstore.learning.data.PartSummary
import com.gigabyte.bookstore.learning.data.PartWithLessons
import com.gigabyte.bookstore.learning.data.content.ContentState
import com.gigabyte.bookstore.learning.domain.model.LessonState
import com.gigabyte.bookstore.presentation.components.AppBackground
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar
import com.gigabyte.bookstore.ui.theme.GoldenAccent

private data class PartTheme(
    val accentColor: Color,
    val badgeBgColor: Color,
    val icon: ImageVector
)

private fun getPartTheme(order: Int): PartTheme = when (order) {
    1 -> PartTheme(
        accentColor = Color(0xFF1565C0),
        badgeBgColor = Color(0xFF0D47A1),
        icon = Icons.Default.People
    )
    2 -> PartTheme(
        accentColor = Color(0xFF00796B),
        badgeBgColor = Color(0xFF004D40),
        icon = Icons.Default.AutoStories
    )
    3 -> PartTheme(
        accentColor = Color(0xFFD97706),
        badgeBgColor = Color(0xFF92400E),
        icon = Icons.Default.RecordVoiceOver
    )
    else -> PartTheme(
        accentColor = Color(0xFF6D28D9),
        badgeBgColor = Color(0xFF4C1D95),
        icon = Icons.Default.Headphones
    )
}

@Composable
fun LearnHomeScreen(
    viewModel: LearnHomeViewModel,
    onBackClick: () -> Unit,
    onOpenPart: (String) -> Unit,
    onOpenLesson: (String) -> Unit
) {
    val contentState by viewModel.contentState.collectAsStateWithLifecycle()
    val syllabus by viewModel.syllabus.collectAsStateWithLifecycle()
    val continueLesson by viewModel.continueLesson.collectAsStateWithLifecycle()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = {
                    Column {
                        Text("স্পোকেন ইংলিশ মাস্টারক্লাস", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text("বাংলা থেকে সহজ নিয়মে ফ্লুয়েন্ট ইংরেজি", style = MaterialTheme.typography.bodySmall)
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
                    // 1. Course Header Banner
                    item {
                        CourseHeroCard()
                    }

                    // 2. Continue Lesson Card (if available)
                    continueLesson?.let { lesson ->
                        item {
                            ContinueCard(lesson, onClick = { onOpenLesson(lesson.lessonId) })
                        }
                    }

                    // 3. Section Title
                    item {
                        Text(
                            "কোর্সের সিলেবাস ও লেসনসমূহ",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                        )
                    }

                    // 4. Syllabus Groups: Each Part with its Lessons directly accessible
                    syllabus.forEach { item ->
                        val part = item.part
                        val lessons = item.lessons
                        val theme = getPartTheme(part.order)

                        item(key = "part_${part.id}") {
                            PartHeaderCard(
                                part = part,
                                theme = theme,
                                onClick = {
                                    if (part.isEnabled) {
                                        if (lessons.isNotEmpty()) {
                                            onOpenLesson(lessons.first().id)
                                        } else {
                                            onOpenPart(part.id)
                                        }
                                    } else {
                                        Toast.makeText(context, "এই অংশটি শীঘ্রই আসছে", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            )
                        }

                        items(lessons, key = { it.id }) { lesson ->
                            LessonCard(
                                lesson = lesson,
                                partTheme = theme,
                                onClick = { onOpenLesson(lesson.id) }
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
private fun CourseHeroCard() {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.5.dp, Color(0xFF1565C0).copy(alpha = 0.4f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF1565C0).copy(alpha = 0.18f),
                            Color(0xFF0D47A1).copy(alpha = 0.08f)
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
                        color = Color(0xFF1565C0),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "🇬🇧 স্পোকেন ইংলিশ ফাউন্ডেশন",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                        )
                    }
                    Text(
                        text = "১০০% ফ্রি",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = GoldenAccent
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "সহজ নিয়মে কথা বলুন (Be-Verbs & Self Presentation)",
                    fontSize = 19.sp,
                    lineHeight = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "পেশা, ব্যক্তিত্বের বৈশিষ্ট্য ও সম্পূর্ণ আত্মপরিচয় উপস্থাপনা নেটিভ অডিও দিয়ে অনুশীলন করুন।",
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    InfoPill(text = "📚 ৩টি অংশ")
                    InfoPill(text = "🎧 ৫টি লেসন")
                    InfoPill(text = "💬 ৬৯টি বাক্য")
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
private fun PartHeaderCard(
    part: PartSummary,
    theme: PartTheme,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.5.dp, theme.accentColor.copy(alpha = 0.5f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
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
                            theme.accentColor.copy(alpha = 0.16f),
                            theme.accentColor.copy(alpha = 0.04f)
                        )
                    )
                )
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Topic Icon
                Surface(
                    color = theme.accentColor,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.size(46.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = theme.icon,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Surface(
                            color = theme.accentColor,
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Text(
                                text = "অংশ 0${part.order}",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                        Surface(
                            color = theme.accentColor.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Text(
                                text = "লেভেল ${part.level}",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = theme.accentColor,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = part.titleBn.orEmpty(),
                        fontSize = 18.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    if (!part.titleTarget.isNullOrBlank()) {
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = part.titleTarget,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = theme.accentColor.copy(alpha = 0.15f)
                ) {
                    Text(
                        text = "${part.lessonCount}টি লেসন",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = theme.accentColor,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun LessonCard(
    lesson: LessonItemSummary,
    partTheme: PartTheme,
    onClick: () -> Unit
) {
    val isDone = lesson.state == LessonState.DONE

    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(
            1.dp,
            if (isDone) Color(0xFF10B981).copy(alpha = 0.5f) else partTheme.accentColor.copy(alpha = 0.25f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp) // Visual indentation showing it belongs to the Part
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Play / Done Icon
                Surface(
                    color = if (isDone) Color(0xFF10B981).copy(alpha = 0.18f) else partTheme.accentColor.copy(alpha = 0.14f),
                    shape = CircleShape,
                    modifier = Modifier.size(38.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = if (isDone) Icons.Default.CheckCircle else Icons.Default.PlayCircle,
                            contentDescription = null,
                            tint = if (isDone) Color(0xFF10B981) else partTheme.accentColor,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "লেসন 0${lesson.order}: ${lesson.titleBn ?: lesson.titleTarget.orEmpty()}",
                        fontSize = 16.sp,
                        lineHeight = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    if (!lesson.titleTarget.isNullOrBlank() && lesson.titleBn != null) {
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = lesson.titleTarget,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                // Interactive CTA Pill
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = partTheme.accentColor.copy(alpha = 0.15f),
                    border = BorderStroke(1.dp, partTheme.accentColor.copy(alpha = 0.4f))
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
                    ) {
                        Text(
                            text = if (isDone) "রিভিউ" else "শুরু ▶",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = partTheme.accentColor
                        )
                    }
                }
            }

            // Grammar preview if available
            if (!lesson.introBn.isNullOrBlank()) {
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "💡 ${lesson.introBn}",
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Footer row with stats
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "💬 ${lesson.itemCount}টি প্র্যাকটিস বাক্য",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                if (lesson.bestScore > 0) {
                    Text(
                        text = "🏆 স্কোর: ${lesson.bestScore}%",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF10B981)
                    )
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

@Composable
private fun ContinueCard(lesson: ContinueLesson, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Surface(
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape,
                modifier = Modifier.size(42.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(26.dp)
                    )
                }
            }
            Spacer(Modifier.width(14.dp))
            Column(Modifier.weight(1f)) {
                Text(
                    text = if (lesson.isDone) "পুনরায় অনুশীলন করুন" else "যেখানে থামিয়েছিলেন সেখান থেকে শুনুন",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = lesson.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
