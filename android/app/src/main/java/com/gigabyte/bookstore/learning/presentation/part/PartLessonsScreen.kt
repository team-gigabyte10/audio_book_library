package com.gigabyte.bookstore.learning.presentation.part

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.gigabyte.bookstore.learning.data.LessonSummary
import com.gigabyte.bookstore.learning.domain.model.LessonState
import com.gigabyte.bookstore.presentation.components.AppBackground
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar

@Composable
fun PartLessonsScreen(
    viewModel: PartLessonsViewModel,
    onBackClick: () -> Unit,
    onOpenLesson: (String) -> Unit
) {
    val lessons by viewModel.lessons.collectAsStateWithLifecycle()
    val title by viewModel.title.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = { Text(title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "ফিরে যান")
                    }
                }
            )
        }
    ) { padding ->
        AppBackground(modifier = Modifier.fillMaxSize().padding(padding)) {
            val list = lessons
            when {
                list == null -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
                list.isEmpty() -> Box(Modifier.fillMaxSize().padding(24.dp), contentAlignment = Alignment.Center) {
                    Text("এই অংশে এখনো যাচাই করা লেসন নেই।")
                }
                else -> LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(list, key = { it.id }) { lesson ->
                        LessonRow(lesson) { onOpenLesson(lesson.id) }
                    }
                }
            }
        }
    }
}

@Composable
private fun LessonRow(lesson: LessonSummary, onClick: () -> Unit) {
    val done = lesson.state == LessonState.DONE
    Card(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = if (done) Icons.Default.CheckCircle else Icons.Default.PlayCircle,
                contentDescription = null,
                tint = if (done) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
            )
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                val isVeryImportant = lesson.titleTarget?.contains("Very Important", ignoreCase = true) == true ||
                    lesson.titleBn?.contains("অতি গুরুত্বপূর্ণ") == true
                if (isVeryImportant) {
                    Surface(
                        color = Color(0xFFE11D48).copy(alpha = 0.12f),
                        border = BorderStroke(1.dp, Color(0xFFE11D48).copy(alpha = 0.4f)),
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier.padding(bottom = 4.dp)
                    ) {
                        Text(
                            text = "🔥 VERY IMPORTANT FOR SPOKEN ENGLISH",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFE11D48),
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
                Text(
                    "${lesson.order}. ${lesson.titleBn ?: lesson.titleTarget.orEmpty()}",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold
                )
                if (lesson.titleBn != null && !lesson.titleTarget.isNullOrBlank()) {
                    Text(lesson.titleTarget, style = MaterialTheme.typography.bodySmall)
                }
                val detail = buildString {
                    append("${lesson.itemCount}টি আইটেম")
                    if (lesson.bestScore > 0) append(" · সেরা স্কোর ${lesson.bestScore}%")
                }
                Text(detail, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}
