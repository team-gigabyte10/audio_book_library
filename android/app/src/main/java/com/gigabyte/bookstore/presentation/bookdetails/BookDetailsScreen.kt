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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
    onSearchInBook: (String) -> Unit
) {
    val book by viewModel.book.collectAsStateWithLifecycle()
    val chapters by viewModel.chapters.collectAsStateWithLifecycle()
    val history by viewModel.history.collectAsStateWithLifecycle()
    val playbackState by viewModel.playbackState.collectAsStateWithLifecycle()

    Scaffold(
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

                        // Action buttons
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
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
                                Text("পড়ুন")
                            }
                        }
                    }
                }
            }
        }
    }
}
