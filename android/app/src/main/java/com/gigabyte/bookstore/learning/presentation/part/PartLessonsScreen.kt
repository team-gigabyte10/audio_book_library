package com.gigabyte.bookstore.learning.presentation.part

import android.widget.Toast
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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.learning.data.LessonSummary
import com.gigabyte.bookstore.learning.data.isPlayable
import com.gigabyte.bookstore.learning.data.needsPurchase
import com.gigabyte.bookstore.learning.domain.model.LessonState
import com.gigabyte.bookstore.presentation.components.AppBackground
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar

@Composable
fun PartLessonsScreen(
    viewModel: PartLessonsViewModel,
    onBackClick: () -> Unit,
    onOpenLesson: (String) -> Unit,
    onOpenPayment: () -> Unit
) {
    val lessons by viewModel.lessons.collectAsStateWithLifecycle()
    val title by viewModel.title.collectAsStateWithLifecycle()
    val context = LocalContext.current
    var showPurchaseDialog by remember { mutableStateOf(false) }

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
                        LessonRow(lesson) {
                            when {
                                lesson.status.isPlayable -> onOpenLesson(lesson.id)
                                lesson.status.needsPurchase -> showPurchaseDialog = true
                                else -> Toast.makeText(context, "আগের লেসনের কুইজে ৭০% পেলে এটি খুলবে", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }
        }
    }

    if (showPurchaseDialog) {
        AlertDialog(
            onDismissRequest = { showPurchaseDialog = false },
            title = { Text("কোর্সটি আনলক করুন") },
            text = { Text("প্রতিটি অংশের প্রথম লেসন ফ্রি। বাকি লেসনগুলো শুনতে স্পোকেন ইংলিশ কোর্সটি কিনুন।") },
            confirmButton = {
                TextButton(onClick = { showPurchaseDialog = false; onOpenPayment() }) { Text("কিনুন") }
            },
            dismissButton = {
                TextButton(onClick = { showPurchaseDialog = false }) { Text("পরে") }
            }
        )
    }
}

@Composable
private fun LessonRow(lesson: LessonSummary, onClick: () -> Unit) {
    val state = lesson.status.state
    Card(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = when (state) {
                    LessonState.DONE -> Icons.Default.CheckCircle
                    LessonState.LOCKED -> Icons.Default.Lock
                    else -> Icons.Default.PlayCircle
                },
                contentDescription = null,
                tint = when (state) {
                    LessonState.DONE -> MaterialTheme.colorScheme.primary
                    LessonState.LOCKED -> MaterialTheme.colorScheme.outline
                    else -> MaterialTheme.colorScheme.secondary
                }
            )
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
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
                    if (lesson.status.isFree && state != LessonState.DONE) append(" · ফ্রি")
                }
                Text(detail, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}
