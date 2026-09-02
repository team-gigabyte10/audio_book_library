package com.gigabyte.bookstore.presentation.library

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.data.models.Book
import com.gigabyte.bookstore.presentation.components.BookCoverView
import com.gigabyte.bookstore.presentation.components.MiniPlayerBar
import com.gigabyte.bookstore.presentation.components.TTSStatusBanner

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreen(
    viewModel: LibraryViewModel,
    onBookClick: (String) -> Unit,
    onPlayClick: (String, Int) -> Unit,
    onOpenPlayer: () -> Unit,
    onOpenReader: (String, Int) -> Unit,
    onOpenSearch: () -> Unit,
    onOpenSettings: () -> Unit
) {
    val books by viewModel.books.collectAsStateWithLifecycle()
    val lastPlayed by viewModel.lastPlayed.collectAsStateWithLifecycle()
    val playbackState by viewModel.playbackState.collectAsStateWithLifecycle()
    val voiceStatus by viewModel.voiceStatus.collectAsStateWithLifecycle()
    val importState by viewModel.importState.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostStateStateWrapper() }
    var bookToDelete by remember { mutableStateOf<Book?>(null) }

    // SAF Document Picker for .md files
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        uri?.let { viewModel.importBook(it) }
    }

    LaunchedEffect(importState) {
        when (val state = importState) {
            is ImportUiState.Success -> {
                snackbarHostState.showSnackbar("বই সফলভাবে যোগ করা হয়েছে: ${state.book.title}")
                viewModel.clearImportState()
            }
            is ImportUiState.Error -> {
                snackbarHostState.showSnackbar("ত্রুটি: ${state.message}")
                viewModel.clearImportState()
            }
            else -> Unit
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Headphones,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(28.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "বাংলা অডিওবুক",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            )
                            Text(
                                text = "Native Android TTS",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        }
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            filePickerLauncher.launch(
                                arrayOf(
                                    "text/markdown",
                                    "text/plain",
                                    "application/octet-stream",
                                    "*/*"
                                )
                            )
                        },
                        modifier = Modifier.testTag("library_add_book_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "বই যোগ করুন",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    IconButton(
                        onClick = onOpenSearch,
                        modifier = Modifier.testTag("library_search_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "অনুসন্ধান"
                        )
                    }
                    IconButton(
                        onClick = onOpenSettings,
                        modifier = Modifier.testTag("library_settings_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "সেটিংস"
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = if (playbackState.bookId.isNotBlank()) 96.dp else 24.dp
                ),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // 1. Bangla TTS Voice Check Banner
                item {
                    TTSStatusBanner(
                        status = voiceStatus,
                        onOpenSettings = { viewModel.openTtsSettings() },
                        onTestVoice = { viewModel.testBanglaVoice() }
                    )
                }

                // 2. Continue Listening Hero Card (if history exists)
                if (lastPlayed != null) {
                    item {
                        ContinueListeningCard(
                            bookTitle = lastPlayed!!.bookTitle,
                            author = lastPlayed!!.author,
                            chapterTitle = lastPlayed!!.chapterTitle,
                            coverPath = lastPlayed!!.coverPath,
                            chunkIndex = lastPlayed!!.chunkIndex,
                            totalChunks = lastPlayed!!.totalChunks,
                            isPlaying = playbackState.isPlaying && playbackState.bookId == lastPlayed!!.bookId,
                            onContinueClick = { viewModel.continueLastPlayed() },
                            onOpenBook = { onBookClick(lastPlayed!!.bookId) }
                        )
                    }
                }

                // 3. Section Header: My Books
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "আমার বইসমূহ (${books.size})",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        )

                        TextButton(
                            onClick = {
                                filePickerLauncher.launch(
                                    arrayOf("text/markdown", "text/plain", "*/*")
                                )
                            },
                            modifier = Modifier.testTag("header_add_book_button")
                        ) {
                            Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("বই যোগ করুন", fontWeight = FontWeight.SemiBold)
                        }
                    }
                }

                // 4. Books List
                if (books.isEmpty()) {
                    item {
                        EmptyLibraryState(
                            onAddBookClick = {
                                filePickerLauncher.launch(
                                    arrayOf("text/markdown", "text/plain", "*/*")
                                )
                            }
                        )
                    }
                } else {
                    items(books, key = { it.id }) { book ->
                        BookListItemCard(
                            book = book,
                            isPlaying = playbackState.isPlaying && playbackState.bookId == book.id,
                            onCardClick = { onBookClick(book.id) },
                            onPlayClick = { onPlayClick(book.id, 0) },
                            onReadClick = { onOpenReader(book.id, 0) },
                            onDeleteClick = { bookToDelete = book }
                        )
                    }
                }
            }

            // Loading dialog when importing Markdown
            if (importState is ImportUiState.Loading) {
                AlertDialog(
                    onDismissRequest = {},
                    title = { Text("বই প্রস্তুত করা হচ্ছে...") },
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(12.dp)
                        ) {
                            CircularProgressIndicator(modifier = Modifier.size(24.dp))
                            Spacer(modifier = Modifier.width(16.dp))
                            Text("Markdown ফাইল পড়া ও অধ্যায় বিভাজন চলছে...")
                        }
                    },
                    confirmButton = {}
                )
            }

            // Delete confirmation dialog
            bookToDelete?.let { book ->
                AlertDialog(
                    onDismissRequest = { bookToDelete = null },
                    icon = { Icon(Icons.Default.Delete, contentDescription = null, tint = MaterialTheme.colorScheme.error) },
                    title = { Text("বই মুছে ফেলতে চান?") },
                    text = { Text("'${book.title}' অডিওবুক লাইব্রেরি থেকে মুছে যাবে।") },
                    confirmButton = {
                        Button(
                            onClick = {
                                viewModel.deleteBook(book.id)
                                bookToDelete = null
                            }
                        ) {
                            Text("মুছুন")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { bookToDelete = null }) {
                            Text("বাতিল")
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ContinueListeningCard(
    bookTitle: String,
    author: String?,
    chapterTitle: String,
    coverPath: String?,
    chunkIndex: Int,
    totalChunks: Int,
    isPlaying: Boolean,
    onContinueClick: () -> Unit,
    onOpenBook: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onOpenBook() }
            .testTag("continue_listening_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BookCoverView(
                title = bookTitle,
                author = author,
                coverPath = coverPath,
                modifier = Modifier.size(68.dp),
                cornerRadius = 10.dp,
                elevation = 3.dp
            )

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "চালিয়ে যান (Continue)",
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = bookTitle,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = chapterTitle,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            IconButton(
                onClick = onContinueClick,
                modifier = Modifier
                    .size(46.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .testTag("continue_listening_play_button")
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "চালিয়ে যান",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}

@Composable
fun BookListItemCard(
    book: Book,
    isPlaying: Boolean,
    onCardClick: () -> Unit,
    onPlayClick: () -> Unit,
    onReadClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCardClick() }
            .testTag("book_item_${book.id}"),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow
        ),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BookCoverView(
                title = book.title,
                author = book.author,
                coverPath = book.coverPath,
                modifier = Modifier.size(72.dp),
                cornerRadius = 10.dp,
                elevation = 2.dp
            )

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = book.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                if (!book.author.isNullOrBlank()) {
                    Text(
                        text = book.author,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "অধ্যায়: ${book.chapterCount}",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    if (book.isAsset) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "বিল্ট-ইন",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = MaterialTheme.colorScheme.secondary
                            )
                        )
                    }
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = onReadClick,
                    modifier = Modifier.testTag("read_book_${book.id}")
                ) {
                    Icon(
                        imageVector = Icons.Default.MenuBook,
                        contentDescription = "পড়ুন",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                IconButton(
                    onClick = onPlayClick,
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .testTag("play_book_${book.id}")
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "শুনুন",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.size(22.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun EmptyLibraryState(
    onAddBookClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.AutoStories,
            contentDescription = null,
            modifier = Modifier.size(72.dp),
            tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "লাইব্রেরিতে কোনো বই নেই",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "আপনার ডিভাইসের যেকোনো বাংলা .md Markdown বই যোগ করুন",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = onAddBookClick,
            modifier = Modifier.testTag("empty_add_book_button")
        ) {
            Icon(Icons.Default.Add, contentDescription = null)
            Spacer(modifier = Modifier.width(6.dp))
            Text("Markdown বই যোগ করুন")
        }
    }
}

class SnackbarHostStateStateWrapper {
    suspend fun showSnackbar(message: String) {
        // Simple wrapper if needed
    }
}
