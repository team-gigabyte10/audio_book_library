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
import androidx.compose.material.icons.filled.PlayArrow
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
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.learning.data.content.ContentState
import com.gigabyte.bookstore.presentation.components.AppBackground
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar
import com.gigabyte.bookstore.ui.theme.GoldenAccent

@Composable
fun LearnHomeScreen(
    viewModel: LearnHomeViewModel,
    onBackClick: () -> Unit,
    onOpenCourse: () -> Unit,
    onOpenIntro: (String) -> Unit
) {
    val contentState by viewModel.contentState.collectAsStateWithLifecycle()
    val syllabus by viewModel.syllabus.collectAsStateWithLifecycle()
    val context = LocalContext.current

    val activeParts = remember(syllabus) { syllabus.filter { it.part.isEnabled } }
    val partCount = activeParts.size.coerceAtLeast(4)
    val lessonCount = activeParts.sumOf { it.lessons.size }.let { if (it > 0) it else 20 }
    val sentenceCount = activeParts.sumOf { part -> part.lessons.sumOf { it.itemCount } }.let { if (it > 0) it else 400 }

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
                    // 1. Course Introduction & Audio Guidelines Card
                    item {
                        CourseIntroHeroCard(
                            onClick = { onOpenIntro("Intro.md") }
                        )
                    }

                    // 2. Present Tens (বর্তমান কাল) - Main Active Course Card
                    item {
                        MainCourseCard(
                            partCount = partCount,
                            lessonCount = lessonCount,
                            sentenceCount = sentenceCount,
                            onClick = onOpenCourse
                        )
                    }

                    // 3. Past Tens (অতীত কাল)
                    item {
                        UpcomingCourseCard(
                            tag = "🇬🇧 Past Tens (অতীত কাল)",
                            title = "অতীতের কথা বলুন (Was/Were, Had & Past Actions)",
                            description = "অতীতের অভ্যাস, স্মৃতি, অভিজ্ঞতা ও অতীতের কাজ বর্ণনার সহজ স্পোকেন রুলস ও অডিও ড্রিল।",
                            accentColor = Color(0xFF5E35B1),
                            onClick = {
                                Toast.makeText(context, "Past Tens (অতীত কাল) কোর্সটি প্রস্তুত হচ্ছে, খুব শীঘ্রই উন্মুক্ত করা হবে!", Toast.LENGTH_SHORT).show()
                            }
                        )
                    }

                    // 4. Future Tens (ভবিষ্যৎ কাল)
                    item {
                        UpcomingCourseCard(
                            tag = "🇬🇧 Future Tens (ভবিষ্যৎ কাল)",
                            title = "ভবিষ্যতের কথা বলুন (Will, Shall & Future Plans)",
                            description = "ভবিষ্যতের পরিকল্পনা, প্রতিশ্রুতি ও সম্ভাবনা প্রকাশের আধুনিক স্পোকেন স্ট্রাকচার।",
                            accentColor = Color(0xFFC2410C),
                            onClick = {
                                Toast.makeText(context, "Future Tens (ভবিষ্যৎ কাল) কোর্সটি প্রস্তুত হচ্ছে, খুব শীঘ্রই উন্মুক্ত করা হবে!", Toast.LENGTH_SHORT).show()
                            }
                        )
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
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.5.dp, Color(0xFF1565C0).copy(alpha = 0.45f)),
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
                            text = "📖 অডিও গাইডলাইন",
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
                    text = "📖 কোর্স পরিচিতি ও অডিও গাইডলাইন",
                    fontSize = 18.sp,
                    lineHeight = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "ইংরেজি শেখার সঠিক নিয়ম, টিপস ও অনুপ্রেরণামূলক দিকনির্দেশনা",
                    fontSize = 13.sp,
                    lineHeight = 19.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    InfoPill(text = "🎙️ অডিও রিডার")
                    InfoPill(text = "⚡ ৪টি সহজ নিয়ম")
                    InfoPill(text = "💡 সেরা টিপস")
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
    partCount: Int,
    lessonCount: Int,
    sentenceCount: Int,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.5.dp, Color(0xFF00796B).copy(alpha = 0.5f)),
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
                            Color(0xFF00796B).copy(alpha = 0.18f),
                            Color(0xFF004D40).copy(alpha = 0.08f)
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
                        color = Color(0xFF00796B),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "🇬🇧 Present Tens (বর্তমান কাল)",
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

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "সহজ নিয়মে কথা বলুন (Present Tens: Be-Verbs, Q&A & Presentation)",
                    fontSize = 19.sp,
                    lineHeight = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "পেশা, ব্যক্তিত্ব, দৈনন্দিন বস্তু, অবস্থান, প্রশ্ন-উত্তর, গুড অ্যাট/ব্যাড অ্যাট ও সম্পূর্ণ প্রেজেন্টেশন বর্তমান কালে সাবলীলভাবে অনুশীলন করুন।",
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
                        color = Color(0xFF00796B),
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
