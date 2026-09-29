package com.gigabyte.bookstore.presentation.pdf

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color as AndroidColor
import android.graphics.pdf.PdfRenderer
import android.os.ParcelFileDescriptor
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ZoomOutMap
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gigabyte.bookstore.BanglaAudiobookApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PdfViewerScreen(
    bookId: String,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current
    val app = context.applicationContext as BanglaAudiobookApp
    val repository = app.repository
    val preferences = app.preferences

    val cleanBookId = bookId.removeSuffix("_full")
    var bookTitle by remember { mutableStateOf("পিডিএফ বই") }

    val savedPageIndex = remember(cleanBookId) { preferences.getPdfLastReadPage(cleanBookId) }
    val listState = rememberLazyListState(initialFirstVisibleItemIndex = savedPageIndex)

    LaunchedEffect(cleanBookId) {
        val book = repository.getBookById(cleanBookId)
        if (book != null) {
            bookTitle = book.title
        }
    }

    val booksDir = remember { File(context.filesDir, "book-store") }
    val pdfFile = remember(cleanBookId) {
        File(booksDir, "$cleanBookId.pdf").takeIf { it.exists() && it.length() > 0 }
            ?: File(booksDir, "$bookId.pdf").takeIf { it.exists() && it.length() > 0 }
    }

    var fileDescriptor by remember { mutableStateOf<ParcelFileDescriptor?>(null) }
    var pdfRenderer by remember { mutableStateOf<PdfRenderer?>(null) }
    var pageCount by remember { mutableStateOf(0) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // Initialize PdfRenderer
    LaunchedEffect(pdfFile) {
        if (pdfFile == null || !pdfFile.exists()) {
            errorMessage = "ডিভাইসে পিডিএফ ফাইলটি পাওয়া যায়নি।"
            return@LaunchedEffect
        }
        withContext(Dispatchers.IO) {
            try {
                val fd = ParcelFileDescriptor.open(pdfFile, ParcelFileDescriptor.MODE_READ_ONLY)
                val renderer = PdfRenderer(fd)
                fileDescriptor = fd
                pdfRenderer = renderer
                pageCount = renderer.pageCount
            } catch (e: Exception) {
                e.printStackTrace()
                errorMessage = "পিডিএফ ওপেন করতে সমস্যা হয়েছে: ${e.localizedMessage ?: "ফাইলটি ক্ষতিগ্রস্ত"}"
            }
        }
    }

    // Ensure last read page is scrolled to once PDF pages are loaded
    LaunchedEffect(pageCount) {
        if (pageCount > 0 && savedPageIndex in 0 until pageCount) {
            listState.scrollToItem(savedPageIndex)
        }
    }

    // Auto-save last read page as user scrolls
    LaunchedEffect(listState, pageCount, cleanBookId) {
        snapshotFlow { listState.firstVisibleItemIndex }
            .distinctUntilChanged()
            .collect { pageIdx ->
                if (pageCount > 0 && pageIdx in 0 until pageCount) {
                    preferences.setPdfLastReadPage(cleanBookId, pageIdx)
                }
            }
    }

    // Cleanup and save progress when exiting screen
    DisposableEffect(cleanBookId) {
        onDispose {
            try {
                val currentIdx = listState.firstVisibleItemIndex
                if (pageCount > 0 && currentIdx in 0 until pageCount) {
                    preferences.setPdfLastReadPage(cleanBookId, currentIdx)
                }
                pdfRenderer?.close()
                fileDescriptor?.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    val currentPage by remember {
        derivedStateOf { (listState.firstVisibleItemIndex + 1).coerceAtMost(pageCount) }
    }

    // Zoom & Pan transformation state
    var scale by remember { mutableFloatStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = bookTitle,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        if (pageCount > 0) {
                            Text(
                                text = "মোট $pageCount টি পৃষ্ঠা",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                ),
                                maxLines = 1
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ফিরে যান"
                        )
                    }
                },
                actions = {
                    if (scale > 1f) {
                        IconButton(onClick = {
                            scale = 1f
                            offset = Offset.Zero
                        }) {
                            Icon(
                                imageVector = Icons.Default.ZoomOutMap,
                                contentDescription = "জুম রিসেট",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFF202124))
        ) {
            when {
                errorMessage != null -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = errorMessage ?: "",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
                pdfRenderer == null || pageCount == 0 -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(36.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "পিডিএফ প্রস্তুত করা হচ্ছে...",
                            color = Color.White.copy(alpha = 0.8f),
                            fontSize = 14.sp
                        )
                    }
                }
                else -> {
                    val renderer = pdfRenderer!!

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .pointerInput(Unit) {
                                detectTransformGestures { _, pan, zoom, _ ->
                                    val newScale = (scale * zoom).coerceIn(1f, 4f)
                                    val maxOffsetX = (size.width * (newScale - 1f)) / 2f
                                    val maxOffsetY = (size.height * (newScale - 1f)) / 2f

                                    val newOffset = if (newScale > 1f) {
                                        Offset(
                                            x = (offset.x + pan.x).coerceIn(-maxOffsetX, maxOffsetX),
                                            y = (offset.y + pan.y).coerceIn(-maxOffsetY, maxOffsetY)
                                        )
                                    } else {
                                        Offset.Zero
                                    }

                                    scale = newScale
                                    offset = newOffset
                                }
                            }
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onDoubleTap = {
                                        if (scale > 1f) {
                                            scale = 1f
                                            offset = Offset.Zero
                                        } else {
                                            scale = 2.2f
                                        }
                                    }
                                )
                            }
                            .graphicsLayer {
                                scaleX = scale
                                scaleY = scale
                                translationX = offset.x
                                translationY = offset.y
                            }
                    ) {
                        LazyColumn(
                            state = listState,
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 12.dp),
                            verticalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            items(pageCount, key = { it }) { pageIndex ->
                                PdfPageItem(
                                    renderer = renderer,
                                    pageIndex = pageIndex
                                )
                            }
                        }
                    }

                    // Floating Page Indicator Pill
                    AnimatedVisibility(
                        visible = pageCount > 1,
                        enter = fadeIn(),
                        exit = fadeOut(),
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 20.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(20.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.9f),
                            shadowElevation = 6.dp
                        ) {
                            Text(
                                text = "পৃষ্ঠা $currentPage / $pageCount",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                ),
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PdfPageItem(
    renderer: PdfRenderer,
    pageIndex: Int
) {
    val context = LocalContext.current
    var bitmap by remember(pageIndex) { mutableStateOf<Bitmap?>(null) }
    var pageAspectRatio by remember(pageIndex) { mutableFloatStateOf(1f / 1.414f) } // Default A4 ratio

    LaunchedEffect(pageIndex, renderer) {
        withContext(Dispatchers.IO) {
            try {
                synchronized(renderer) {
                    val page = renderer.openPage(pageIndex)
                    pageAspectRatio = page.width.toFloat() / page.height.toFloat()

                    // Render at high clarity matching device screen resolution
                    val displayMetrics = context.resources.displayMetrics
                    val renderWidth = (displayMetrics.widthPixels * 1.3f).toInt().coerceAtLeast(page.width)
                    val renderHeight = (renderWidth / pageAspectRatio).toInt()

                    val bmp = Bitmap.createBitmap(renderWidth, renderHeight, Bitmap.Config.ARGB_8888)
                    val canvas = Canvas(bmp)
                    canvas.drawColor(AndroidColor.WHITE)

                    page.render(bmp, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
                    page.close()
                    bitmap = bmp
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .aspectRatio(pageAspectRatio),
        contentAlignment = Alignment.Center
    ) {
        val currentBitmap = bitmap
        if (currentBitmap != null) {
            Image(
                bitmap = currentBitmap.asImageBitmap(),
                contentDescription = "পৃষ্ঠা ${pageIndex + 1}",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth
            )
        } else {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(
                    strokeWidth = 2.dp,
                    modifier = Modifier.size(24.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
