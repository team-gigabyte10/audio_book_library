package com.gigabyte.bookstore.presentation.bookdetails

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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import android.content.Intent
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.data.models.Chapter
import com.gigabyte.bookstore.presentation.components.BookCoverView
import com.gigabyte.bookstore.presentation.components.MiniPlayerBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailsScreen(
    viewModel: BookDetailsViewModel,
    onBackClick: () -> Unit,
    onPlayChapter: (Int) -> Unit,
    onOpenPlayer: () -> Unit,
    onOpenReader: (Int) -> Unit,
    onSearchInBook: (String) -> Unit,
    onOpenPayment: () -> Unit = {}
) {

    val context = LocalContext.current
    val book by viewModel.book.collectAsStateWithLifecycle()
    val chapters by viewModel.chapters.collectAsStateWithLifecycle()
    val history by viewModel.history.collectAsStateWithLifecycle()
    val playbackState by viewModel.playbackState.collectAsStateWithLifecycle()

    val userStatus by viewModel.userStatus.collectAsStateWithLifecycle()
    val isPdfDownloaded by viewModel.isPdfDownloaded.collectAsStateWithLifecycle()
    val isFullBookDownloaded by viewModel.isFullBookDownloaded.collectAsStateWithLifecycle()
    val pdfProgress by viewModel.pdfDownloadProgress.collectAsStateWithLifecycle()
    val downloadError by viewModel.downloadErrorMessage.collectAsStateWithLifecycle()
    val downloadSuccess by viewModel.downloadSuccessMessage.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var showUpgradeDialog by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(downloadError) {
        downloadError?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.clearMessages()
        }
    }

    LaunchedEffect(downloadSuccess) {
        downloadSuccess?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.clearMessages()
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("বইয়ের বিবরণ", maxLines = 1) },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.testTag("book_details_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ফিরে যান"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { book?.let { onSearchInBook(it.id) } },
                        modifier = Modifier.testTag("book_details_search_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "বইয়ে খুঁজুন"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            MiniPlayerBar(
                playbackState = playbackState,
                onBarClick = onOpenPlayer,
                onPlayPauseClick = { viewModel.player.togglePlayPause() },
                onNextClick = { viewModel.player.nextChapter() },
                onCloseClick = { viewModel.player.stopAndClose() }
            )
        }
    ) { innerPadding ->
        if (book == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            val currentBook = book!!

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = if (playbackState.bookId.isNotBlank()) 96.dp else 24.dp
                ),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // 1. Header Card with Cover and Info
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        BookCoverView(
                            title = currentBook.title,
                            author = currentBook.author,
                            coverPath = currentBook.coverPath,
                            modifier = Modifier.size(width = 160.dp, height = 220.dp),
                            cornerRadius = 16.dp,
                            elevation = 6.dp
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = currentBook.title,
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp
                            ),
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )

                        if (!currentBook.author.isNullOrBlank()) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = currentBook.author,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "অধ্যায় সংখ্যা: ${chapters.size}",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.SemiBold
                                )
                            )
                            if (currentBook.isAsset) {
                                Text(
                                    text = "• বিল্ট-ইন বই",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = MaterialTheme.colorScheme.secondary
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Action buttons - Audio & Summary
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Button(
                                onClick = {
                                    val startIdx = history?.chapterIndex ?: 0
                                    viewModel.continueListening()
                                    onOpenReader(startIdx)
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .testTag("book_details_play_button")
                            ) {
                                Icon(Icons.Default.PlayArrow, contentDescription = null)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    if (history != null) "চালিয়ে যান" else "শুনুন"
                                )
                            }

                            OutlinedButton(
                                onClick = {
                                    val startIdx = history?.chapterIndex ?: 0
                                    onOpenReader(startIdx)
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .testTag("book_details_read_button")
                            ) {
                                Icon(Icons.Default.MenuBook, contentDescription = null)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("সারসংক্ষেপ পড়ুন")
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Paid Exclusive Features: Full Book & PDF Document
                        val isPaid = userStatus.equals("paid", ignoreCase = true) || userStatus.equals("active", ignoreCase = true)

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            // Full Book Button
                            OutlinedButton(
                                onClick = {
                                    if (isPaid) {
                                        onOpenReader(0)
                                    } else {
                                        showUpgradeDialog = "সম্পূর্ণ বই পড়ার সুবিধা শুধুমাত্র পেইড (Paid) ব্যবহারকারীদের জন্য। অনুগ্রহ করে আপনার অ্যাকাউন্ট আপগ্রেড করুন।"
                                    }
                                },
                                modifier = Modifier.weight(1f),
                                colors = if (!isPaid) ButtonDefaults.outlinedButtonColors(
                                    contentColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                                ) else ButtonDefaults.outlinedButtonColors()
                            ) {
                                Icon(
                                    imageVector = if (isPaid) Icons.Default.AutoStories else Icons.Default.Lock,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = if (isPaid) "সম্পূর্ণ বই" else "সম্পূর্ণ বই (পেইড)",
                                    fontSize = 12.sp,
                                    maxLines = 1
                                )
                            }

                            // PDF Document Button (Manual Download or Open)
                            OutlinedButton(
                                onClick = {
                                    if (!isPaid) {
                                        showUpgradeDialog = "মূল পিডিএফ ডকুমেন্ট পড়ার সুবিধা শুধুমাত্র পেইড (Paid) ব্যবহারকারীদের জন্য। অনুগ্রহ করে আপনার অ্যাকাউন্ট আপগ্রেড করুন।"
                                    } else {
                                        if (isPdfDownloaded) {
                                            val pdfUri = viewModel.getPdfFileUri(context)
                                            if (pdfUri != null) {
                                                val intent = Intent(Intent.ACTION_VIEW).apply {
                                                    setDataAndType(pdfUri, "application/pdf")
                                                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                                                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                                }
                                                try {
                                                    context.startActivity(Intent.createChooser(intent, "পিডিএফ ওপেন করুন"))
                                                } catch (e: Exception) {
                                                    scope.launch {
                                                        snackbarHostState.showSnackbar("পিডিএফ ওপেন করার মতো কোনো অ্যাপ ডিভাইসে পাওয়া যায়নি")
                                                    }
                                                }
                                            } else {
                                                viewModel.downloadPdf()
                                            }
                                        } else {
                                            viewModel.downloadPdf()
                                        }
                                    }
                                },
                                modifier = Modifier.weight(1f),
                                enabled = pdfProgress == null,
                                colors = if (!isPaid) ButtonDefaults.outlinedButtonColors(
                                    contentColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                                ) else ButtonDefaults.outlinedButtonColors()
                            ) {
                                if (pdfProgress != null) {
                                    CircularProgressIndicator(
                                        modifier = Modifier.size(16.dp),
                                        strokeWidth = 2.dp
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(text = "$pdfProgress%", fontSize = 12.sp)
                                } else {
                                    Icon(
                                        imageVector = when {
                                            !isPaid -> Icons.Default.Lock
                                            isPdfDownloaded -> Icons.Default.PictureAsPdf
                                            else -> Icons.Default.Download
                                        },
                                        contentDescription = null,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = when {
                                            !isPaid -> "পিডিএফ (পেইড)"
                                            isPdfDownloaded -> "পিডিএফ পড়ুন"
                                            else -> "পিডিএফ ডাউনলোড"
                                        },
                                        fontSize = 12.sp,
                                        maxLines = 1
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Upgrade Dialog for Trial Users
    if (showUpgradeDialog != null) {
        AlertDialog(
            onDismissRequest = { showUpgradeDialog = null },
            icon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(32.dp)
                )
            },
            title = {
                Text(
                    text = "পেইড ফিচার (Paid Feature)",
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(text = showUpgradeDialog ?: "")
            },
            confirmButton = {
                Button(onClick = {
                    showUpgradeDialog = null
                    onOpenPayment()
                }) {
                    Text("পেমেন্ট পেইজে যান")
                }
            },
            dismissButton = {
                TextButton(onClick = { showUpgradeDialog = null }) {
                    Text("বাতিল")
                }
            }
        )
    }
}


