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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.Info
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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.gigabyte.bookstore.data.local.entities.PlaybackHistoryEntity
import com.gigabyte.bookstore.data.models.PlaybackState
import com.gigabyte.bookstore.domain.tts.TTSVoiceStatus
import com.gigabyte.bookstore.data.models.Book
import com.gigabyte.bookstore.presentation.components.BookCoverView
import com.gigabyte.bookstore.presentation.components.MiniPlayerBar
import com.gigabyte.bookstore.presentation.components.TTSStatusBanner
import com.gigabyte.bookstore.presentation.drawer.AboutUsDialog
import com.gigabyte.bookstore.presentation.drawer.AppDrawerContent
import com.gigabyte.bookstore.presentation.drawer.BookmarksDialog
import com.gigabyte.bookstore.presentation.drawer.ProfileUpdateDialog
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreen(
    viewModel: LibraryViewModel,
    onBookClick: (String) -> Unit,
    onPlayClick: (String, Int) -> Unit,
    onOpenPlayer: () -> Unit,
    onOpenReader: (String, Int) -> Unit,
    onOpenSearch: () -> Unit,
    onOpenSettings: () -> Unit,
    onOpenPayment: () -> Unit,
    onOpenPaymentApproval: () -> Unit
) {
    val books: List<Book> by viewModel.books.collectAsStateWithLifecycle()
    val lastPlayed: PlaybackHistoryEntity? by viewModel.lastPlayed.collectAsStateWithLifecycle()
    val playbackState: PlaybackState by viewModel.playbackState.collectAsStateWithLifecycle()
    val voiceStatus: TTSVoiceStatus by viewModel.voiceStatus.collectAsStateWithLifecycle()
    val importState: ImportUiState by viewModel.importState.collectAsStateWithLifecycle()

    val userStatus: String by viewModel.userStatus.collectAsStateWithLifecycle()
    val userName: String by viewModel.userName.collectAsStateWithLifecycle()
    val userEmail: String by viewModel.userEmail.collectAsStateWithLifecycle()
    val userInstitute: String by viewModel.userInstitute.collectAsStateWithLifecycle()
    val userAddress: String by viewModel.userAddress.collectAsStateWithLifecycle()
    val userPhone: String by viewModel.userPhone.collectAsStateWithLifecycle()
    val userBalance: Double by viewModel.userBalance.collectAsStateWithLifecycle()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var showProfileDialog by remember { mutableStateOf(false) }
    var showBookmarksDialog by remember { mutableStateOf(false) }
    var showAboutUsDialog by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }
    var bookToDelete by remember { mutableStateOf<Book?>(null) }

    // SAF Document Picker for .md files
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument(),
        onResult = { uri: Uri? ->
            uri?.let { viewModel.importBook(it) }
        }
    )

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


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawerContent(
                userName = userName,
                userEmail = userEmail,
                userInstitute = userInstitute,
                userStatus = userStatus,
                userBalance = userBalance,
                onProfileClick = {
                    scope.launch { drawerState.close() }
                    showProfileDialog = true
                },
                onLastReadClick = {
                    scope.launch { drawerState.close() }
                    if (lastPlayed != null) {
                        viewModel.continueLastPlayed()
                        onOpenReader(lastPlayed!!.bookId, lastPlayed!!.chapterIndex)
                    }
                },
                onBookmarksClick = {
                    scope.launch { drawerState.close() }
                    showBookmarksDialog = true
                },
                onPaymentClick = {
                    scope.launch { drawerState.close() }
                    onOpenPayment()
                },
                onApprovePaymentsClick = {
                    scope.launch { drawerState.close() }
                    onOpenPaymentApproval()
                },
                onAboutUsClick = {
                    scope.launch { drawerState.close() }
                    showAboutUsDialog = true
                }
            )
        }
    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "মেনু ওপেন করুন"
                            )
                        }
                    },
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

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "বাংলা অডিওবুক",
                                    style = MaterialTheme.typography.titleLarge.copy(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp
                                    )
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                // User Status Badge (Trial or Active)
                                Surface(
                                    color = if (userStatus.equals("trial", ignoreCase = true))
                                        MaterialTheme.colorScheme.tertiaryContainer
                                    else
                                        MaterialTheme.colorScheme.primaryContainer,
                                    shape = androidx.compose.foundation.shape.CircleShape
                                ) {
                                    Text(
                                        text = if (userStatus.equals("trial", ignoreCase = true)) "Trial" else "Active",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (userStatus.equals("trial", ignoreCase = true))
                                            MaterialTheme.colorScheme.onTertiaryContainer
                                        else
                                            MaterialTheme.colorScheme.onPrimaryContainer,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }

                            Text(
                                text = if (userName.isNotBlank()) "User: $userName" else "Native Android TTS",
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

                // 1.1 Status Notice Banner
                if (userStatus.equals("trial", ignoreCase = true)) {
                    item {
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.6f)
                            ),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Info,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.tertiary,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "ট্রায়াল মোড সক্রিয়: শুধুমাত্র অডিওবুক সারসংক্ষেপ উপলব্ধ। সম্পূর্ণ বই ও মূল পিডিএফ পড়তে পেইড একাউন্ট প্রয়োজন।",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onTertiaryContainer
                                )
                            }
                        }
                    }
                } else if (userStatus.equals("paid", ignoreCase = true) || userStatus.equals("active", ignoreCase = true)) {
                    item {
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                            ),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "পেইড মেম্বারশিপ সক্রিয়: সম্পূর্ণ বই পড়া ও মূল পিডিএফ ডাউনলোড আনলক করা হয়েছে।",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        }
                    }
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

                // 4. Books Grid (2 books per row)
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
                    items(books.chunked(2), key = { pair -> pair.first().id }) { pair ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            for (book in pair) {
                                BookGridItemCard(
                                    book = book,
                                    isPlaying = playbackState.isPlaying && playbackState.bookId == book.id,
                                    onCardClick = { onBookClick(book.id) },
                                    onPlayClick = { onPlayClick(book.id, 0) },
                                    onReadClick = { onOpenReader(book.id, 0) },
                                    onDeleteClick = { bookToDelete = book },
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            if (pair.size == 1) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
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

        // Dialogs triggered from Navigation Drawer

        if (showProfileDialog) {
            ProfileUpdateDialog(
                initialName = userName,
                initialInstitute = userInstitute,
                initialAddress = userAddress,
                initialPhone = userPhone,
                email = userEmail,
                onDismiss = { showProfileDialog = false },
                onSave = { name, institute, address, phone ->
                    viewModel.updateUserProfile(name, institute, address, phone) {
                        showProfileDialog = false
                    }
                }
            )
        }

        if (showBookmarksDialog) {

            BookmarksDialog(
                books = books,
                onSelectBook = onBookClick,
                onDismiss = { showBookmarksDialog = false }
            )
        }

        if (showAboutUsDialog) {
            AboutUsDialog(
                onDismiss = { showAboutUsDialog = false }
            )
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
fun BookGridItemCard(
    book: Book,
    isPlaying: Boolean,
    onCardClick: () -> Unit,
    onPlayClick: () -> Unit,
    onReadClick: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onCardClick() }
            .testTag("book_item_${book.id}"),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow
        ),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Book Cover Image with overlay Play Button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {
                BookCoverView(
                    title = book.title,
                    author = book.author,
                    coverPath = book.coverPath,
                    modifier = Modifier.fillMaxSize(),
                    cornerRadius = 0.dp,
                    elevation = 0.dp
                )

                // Floating Play Button
                IconButton(
                    onClick = onPlayClick,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .testTag("play_book_${book.id}")
                ) {
                    Icon(
                        imageVector = if (isPlaying) Icons.Default.Headphones else Icons.Default.PlayArrow,
                        contentDescription = "শুনুন",
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // Info & Actions Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    text = book.title,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    ),
                    maxLines = 2,
                    minLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = book.author?.ifBlank { "বাংলা অডিওবুক" } ?: "বাংলা অডিওবুক",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = 11.sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "অধ্যায়: ${book.chapterCount}",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(
                            onClick = onReadClick,
                            modifier = Modifier
                                .size(28.dp)
                                .testTag("read_book_${book.id}")
                        ) {
                            Icon(
                                imageVector = Icons.Default.MenuBook,
                                contentDescription = "পড়ুন",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(16.dp)
                            )
                        }

                        IconButton(
                            onClick = onDeleteClick,
                            modifier = Modifier
                                .size(28.dp)
                                .testTag("delete_book_${book.id}")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "মুছুন",
                                tint = MaterialTheme.colorScheme.error.copy(alpha = 0.7f),
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
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

