package com.gigabyte.bookstore.presentation.bookdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.Brush
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.material.icons.filled.CheckCircle
import com.gigabyte.bookstore.data.ads.FacebookRewardAdManager
import com.gigabyte.bookstore.presentation.components.BookUnlockDialog
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.material3.AlertDialog
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import android.content.Intent
import android.net.Uri
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.data.models.Chapter
import com.gigabyte.bookstore.presentation.components.BookCoverView
import com.gigabyte.bookstore.presentation.components.AppBackground
import com.gigabyte.bookstore.presentation.components.MiniPlayerBar
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailsScreen(
    viewModel: BookDetailsViewModel,
    onBackClick: () -> Unit,
    onPlayChapter: (Int) -> Unit,
    onOpenPlayer: () -> Unit,
    onOpenReader: (Int) -> Unit,
    onOpenFullBook: (String) -> Unit = {},
    onOpenPdf: (String) -> Unit = {},
    onSearchInBook: (String) -> Unit,
    onOpenPayment: () -> Unit = {}
) {

    val context = LocalContext.current
    val activity = context as? Activity
    val book by viewModel.book.collectAsStateWithLifecycle()
    val chapters by viewModel.chapters.collectAsStateWithLifecycle()
    val history by viewModel.history.collectAsStateWithLifecycle()
    val playbackState by viewModel.playbackState.collectAsStateWithLifecycle()

    val userStatus by viewModel.userStatus.collectAsStateWithLifecycle()
    val pricingConfig by viewModel.appPreferences.pricingConfig.collectAsStateWithLifecycle()
    val unlockedModuleUpdates by viewModel.unlockedModuleUpdates.collectAsStateWithLifecycle()
    val unlockedBundles by viewModel.unlockedBundles.collectAsStateWithLifecycle()
    val rewardHours by viewModel.rewardUnlockHours.collectAsStateWithLifecycle()

    val isPdfDownloaded by viewModel.isPdfDownloaded.collectAsStateWithLifecycle()
    val isFullBookDownloaded by viewModel.isFullBookDownloaded.collectAsStateWithLifecycle()
    val isDownloadingFullBook by viewModel.isDownloadingFullBook.collectAsStateWithLifecycle()
    val pdfProgress by viewModel.pdfDownloadProgress.collectAsStateWithLifecycle()
    val downloadError by viewModel.downloadErrorMessage.collectAsStateWithLifecycle()
    val downloadSuccess by viewModel.downloadSuccessMessage.collectAsStateWithLifecycle()
    val remotePdfUrl by viewModel.remotePdfUrl.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var showUnlockDialog by remember { mutableStateOf(false) }
    var showPaidOnlyPdfDialog by remember { mutableStateOf(false) }
    var isLoadingRewardAd by remember { mutableStateOf(false) }

    val isBookUnlocked = remember(userStatus, unlockedBundles, unlockedModuleUpdates) {
        viewModel.isBookUnlockedForReading()
    }
    val isPdfUnlocked = remember(userStatus, unlockedBundles, unlockedModuleUpdates) {
        viewModel.isPdfUnlocked()
    }
    val remainingMillis = remember(unlockedModuleUpdates) {
        viewModel.getBookRemainingMillis()
    }

    LaunchedEffect(Unit) {
        FacebookRewardAdManager.getInstance(context).preloadAd()
    }

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
            ThemedTopAppBar(
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
                    val bookmarkedBookIds by viewModel.bookmarkedBookIds.collectAsStateWithLifecycle()
                    val isBookmarked = bookmarkedBookIds.contains(book?.id ?: "")

                    IconButton(
                        onClick = {
                            book?.let {
                                val added = viewModel.toggleBookmark()
                                Toast.makeText(
                                    context,
                                    if (added) "বুকমার্কে যোগ করা হয়েছে" else "বুকমার্ক থেকে সরানো হয়েছে",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        },
                        modifier = Modifier.testTag("book_details_bookmark_button")
                    ) {
                        Icon(
                            imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                            contentDescription = "বুকমার্ক",
                            tint = if (isBookmarked) Color(0xFFFFD54F) else MaterialTheme.colorScheme.onSurface
                        )
                    }

                    IconButton(
                        onClick = { book?.let { onSearchInBook(it.id) } },
                        modifier = Modifier.testTag("book_details_search_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "বইয়ে খুঁজুন"
                        )
                    }
                }
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
        AppBackground(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (book == null) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
            val currentBook = book!!

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
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
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        // Ambient radial glow behind cover
                        Box(
                            modifier = Modifier
                                .size(190.dp)
                                .background(
                                    brush = Brush.radialGradient(
                                        colors = listOf(
                                            MaterialTheme.colorScheme.primary.copy(alpha = 0.35f),
                                            Color(0xFFFFD54F).copy(alpha = 0.15f),
                                            Color.Transparent
                                        )
                                    ),
                                    shape = CircleShape
                                )
                        )

                        BookCoverView(
                            title = currentBook.title,
                            author = currentBook.author,
                            coverPath = currentBook.coverPath,
                            modifier = Modifier.size(width = 165.dp, height = 225.dp),
                            cornerRadius = 18.dp,
                            elevation = 8.dp
                        )
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                        Text(
                            text = currentBook.title,
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp
                            ),
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )

                        val displayAuthor = currentBook.author?.takeIf {
                            !it.equals("Unknown", ignoreCase = true) && !it.equals("Unknown Author", ignoreCase = true)
                        }
                        if (!displayAuthor.isNullOrBlank()) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = displayAuthor,
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

                        // Primary Action Button - Audiobook Playback (Audio Player)
                        Button(
                            onClick = {
                                val startIdx = history?.chapterIndex ?: 0
                                viewModel.continueListening()
                                onPlayChapter(startIdx)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(min = 48.dp)
                                .testTag("book_details_play_button"),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = null,
                                modifier = Modifier.size(22.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (history != null) "চালিয়ে যান (অডিওবুক)" else "শুনুন (অডিওবুক)",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Full Book Reading & PDF Document
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            // Full Book Button
                            OutlinedButton(
                                onClick = {
                                    if (isBookUnlocked) {
                                        viewModel.openFullBook(
                                            onSuccess = { fullBookId ->
                                                onOpenFullBook(fullBookId)
                                            },
                                            onError = { errMsg ->
                                                scope.launch {
                                                    snackbarHostState.showSnackbar(errMsg)
                                                }
                                            }
                                        )
                                    } else {
                                        showUnlockDialog = true
                                    }
                                },
                                enabled = !isDownloadingFullBook,
                                modifier = Modifier
                                    .weight(1f)
                                    .heightIn(min = 44.dp),
                                colors = if (!isBookUnlocked) ButtonDefaults.outlinedButtonColors(
                                    contentColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.85f)
                                ) else ButtonDefaults.outlinedButtonColors()
                            ) {
                                if (isDownloadingFullBook) {
                                    CircularProgressIndicator(
                                        modifier = Modifier.size(16.dp),
                                        strokeWidth = 2.dp
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "লোড হচ্ছে...",
                                        fontSize = 12.sp,
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                } else {
                                    Icon(
                                        imageVector = if (isBookUnlocked) Icons.Default.AutoStories else Icons.Default.Lock,
                                        contentDescription = null,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isBookUnlocked) "সম্পূর্ণ বই পড়ুন" else "সম্পূর্ণ বই (বিজ্ঞাপন/পেইড)",
                                        fontSize = 12.sp,
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                            }

                            // PDF Document Button (Drive View, Download or Open - Paid users only)
                            OutlinedButton(
                                onClick = {
                                    if (!isPdfUnlocked) {
                                        showPaidOnlyPdfDialog = true
                                    } else {
                                        if (isPdfDownloaded) {
                                            onOpenPdf(currentBook.id)
                                        } else if (!remotePdfUrl.isNullOrBlank() && (remotePdfUrl!!.contains("drive.google.com") || remotePdfUrl!!.startsWith("http"))) {
                                            try {
                                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(remotePdfUrl))
                                                context.startActivity(intent)
                                            } catch (e: Exception) {
                                                viewModel.downloadPdf()
                                            }
                                        } else {
                                            viewModel.downloadPdf()
                                        }
                                    }
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .heightIn(min = 44.dp),
                                enabled = pdfProgress == null,
                                colors = if (!isPdfUnlocked) ButtonDefaults.outlinedButtonColors(
                                    contentColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.85f)
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
                                            !isPdfUnlocked -> Icons.Default.Lock
                                            isPdfDownloaded -> Icons.Default.PictureAsPdf
                                            !remotePdfUrl.isNullOrBlank() && remotePdfUrl!!.contains("drive.google.com") -> Icons.Default.PictureAsPdf
                                            else -> Icons.Default.Download
                                        },
                                        contentDescription = null,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = when {
                                            !isPdfUnlocked -> "পিডিএফ (শুধুমাত্র পেইড)"
                                            isPdfDownloaded -> "পিডিএফ পড়ুন"
                                            !remotePdfUrl.isNullOrBlank() && remotePdfUrl!!.contains("drive.google.com") -> "ড্রাইভ পিডিএফ"
                                            else -> "পিডিএফ ডাউনলোড"
                                        },
                                        fontSize = 12.sp,
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                            }
                        }

                        // 24-Hour Free Pass Active Banner
                        if (remainingMillis > 0L) {
                            val remainingHours = (remainingMillis / (1000 * 60 * 60)).coerceAtLeast(1)
                            Spacer(modifier = Modifier.height(4.dp))
                            Surface(
                                color = Color(0xFF10B981).copy(alpha = 0.15f),
                                shape = RoundedCornerShape(8.dp),
                                border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.35f)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = null,
                                        tint = Color(0xFF10B981),
                                        modifier = Modifier.size(15.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "✓ বিজ্ঞাপন রিওয়ার্ড সক্রিয়: পরবর্তী ${remainingHours} ঘণ্টা বইটি সম্পূর্ণ ফ্রি!",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color(0xFF065F46),
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Unlock Dialog for Locked Books (Rewarded Ad or Buy Bundle)
    if (showUnlockDialog && book != null) {
        val currentBook = book!!
        BookUnlockDialog(
            bookTitle = currentBook.title,
            bookAuthor = currentBook.author,
            isLoadingAd = isLoadingRewardAd,
            rewardHours = rewardHours,
            bundlePrice = pricingConfig.getPackagePrice("audiobook_bundle"),
            onWatchAdClick = {
                if (activity != null) {
                    isLoadingRewardAd = true
                    FacebookRewardAdManager.getInstance(context).showAd(
                        activity = activity,
                        onRewardEarned = {
                            isLoadingRewardAd = false
                            showUnlockDialog = false
                            viewModel.unlockBookFor24Hours()
                            Toast.makeText(context, "🎉 অভিনন্দন! বইটি পরবর্তী ${rewardHours} ঘণ্টার জন্য আনলক হয়েছে!", Toast.LENGTH_LONG).show()
                            viewModel.openFullBook(
                                onSuccess = { fullBookId ->
                                    onOpenFullBook(fullBookId)
                                },
                                onError = { errMsg ->
                                    scope.launch {
                                        snackbarHostState.showSnackbar(errMsg)
                                    }
                                }
                            )
                        },
                        onClosed = {
                            isLoadingRewardAd = false
                        },
                        onError = { errorMsg ->
                            isLoadingRewardAd = false
                            showUnlockDialog = false
                            // Graceful fallback if ad network is busy
                            viewModel.unlockBookFor24Hours()
                            Toast.makeText(context, "বিজ্ঞাপন সার্ভার ব্যস্ত থাকায় আপনার সুবিধার জন্য বইটি আনলক করে দেওয়া হলো! 🎉", Toast.LENGTH_LONG).show()
                            viewModel.openFullBook(
                                onSuccess = { fullBookId ->
                                    onOpenFullBook(fullBookId)
                                },
                                onError = { errMsg ->
                                    scope.launch {
                                        snackbarHostState.showSnackbar(errMsg)
                                    }
                                }
                            )
                        }
                    )
                } else {
                    showUnlockDialog = false
                    viewModel.unlockBookFor24Hours()
                }
            },
            onBuyBundleClick = {
                showUnlockDialog = false
                onOpenPayment()
            },
            onDismiss = {
                if (!isLoadingRewardAd) {
                    showUnlockDialog = false
                }
            }
        )
    }

    // Dedicated Paid-Only Google Drive PDF Dialog
    if (showPaidOnlyPdfDialog) {
        val bundlePrice = pricingConfig.getPackagePrice("audiobook_bundle")
        AlertDialog(
            onDismissRequest = { showPaidOnlyPdfDialog = false },
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
                    text = "পিডিএফ শুধুমাত্র পেইড ইউজারদের জন্য",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
            },
            text = {
                Text(
                    text = "বইটির সম্পূর্ণ Google Drive পিডিএফ ডাউনলোড ও পড়ার সুবিধাটি শুধুমাত্র পেইড সদস্যদের জন্য সংরক্ষিত। পুরো বান্ডেলের সকল বই আজীবনের জন্য আনলক করতে বান্ডেল কিনুন।",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        showPaidOnlyPdfDialog = false
                        onOpenPayment()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "বান্ডেল কিনুন ($bundlePrice টাকা)",
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showPaidOnlyPdfDialog = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "বাতিল")
                }
            },
            shape = RoundedCornerShape(18.dp)
        )
    }
}
}


