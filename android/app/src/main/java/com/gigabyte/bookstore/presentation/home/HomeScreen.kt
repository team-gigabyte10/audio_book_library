package com.gigabyte.bookstore.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.CastForEducation
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.LocalMall
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.gigabyte.bookstore.data.local.entities.PlaybackHistoryEntity
import com.gigabyte.bookstore.data.models.AudioBundle
import com.gigabyte.bookstore.data.models.Course
import com.gigabyte.bookstore.data.models.HeroBanner
import com.gigabyte.bookstore.data.models.PlaybackState
import com.gigabyte.bookstore.data.models.RemoteBook
import com.gigabyte.bookstore.presentation.components.AppBackground
import com.gigabyte.bookstore.presentation.components.AudioWaveAnimation
import com.gigabyte.bookstore.presentation.components.BookCoverView
import com.gigabyte.bookstore.presentation.components.MiniPlayerBar
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar
import com.gigabyte.bookstore.presentation.drawer.AboutUsDialog
import com.gigabyte.bookstore.presentation.drawer.AppDrawerContent
import com.gigabyte.bookstore.presentation.drawer.ProfileUpdateDialog
import com.gigabyte.bookstore.presentation.home.components.BundleCard
import com.gigabyte.bookstore.presentation.home.components.BundleDetailsBottomSheet
import com.gigabyte.bookstore.presentation.home.components.CourseCard
import com.gigabyte.bookstore.presentation.home.components.CourseDetailsBottomSheet
import com.gigabyte.bookstore.presentation.home.components.HeroBannerCarousel
import com.gigabyte.bookstore.presentation.home.components.SectionHeader
import com.gigabyte.bookstore.ui.theme.GoldenAccent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onNavigateToLibrary: () -> Unit,
    onNavigateToBook: (String) -> Unit,
    onNavigateToPlayer: () -> Unit,
    onPlayBook: (String, Int) -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToPayment: () -> Unit,
    onNavigateToReferral: () -> Unit,
    onNavigateToApproval: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val lastPlayed by viewModel.lastPlayed.collectAsStateWithLifecycle()
    val playbackState by viewModel.playbackState.collectAsStateWithLifecycle()

    val userName by viewModel.userName.collectAsStateWithLifecycle()
    val userEmail by viewModel.userEmail.collectAsStateWithLifecycle()
    val userStatus by viewModel.userStatus.collectAsStateWithLifecycle()
    val userBalance by viewModel.userBalance.collectAsStateWithLifecycle()
    val userInstitute by viewModel.userInstitute.collectAsStateWithLifecycle()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var showProfileDialog by remember { mutableStateOf(false) }
    var showAboutUsDialog by remember { mutableStateOf(false) }

    // Bottom sheet states for Bundle and Course
    var selectedBundle by remember { mutableStateOf<AudioBundle?>(null) }
    var selectedCourse by remember { mutableStateOf<Course?>(null) }

    // Filter Chip State
    var selectedCategory by remember { mutableStateOf("all") } // "all", "bundles", "english", "japanese", "books"

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
                        onNavigateToPlayer()
                    }
                },
                onBookmarksClick = {
                    scope.launch { drawerState.close() }
                    onNavigateToLibrary()
                },
                onPaymentClick = {
                    scope.launch { drawerState.close() }
                    onNavigateToPayment()
                },
                onApprovePaymentsClick = {
                    scope.launch { drawerState.close() }
                    onNavigateToApproval()
                },
                onReferralClick = {
                    scope.launch { drawerState.close() }
                    onNavigateToReferral()
                },
                onAboutUsClick = {
                    scope.launch { drawerState.close() }
                    showAboutUsDialog = true
                },
                onHomeClick = {
                    scope.launch { drawerState.close() }
                },
                onLibraryClick = {
                    scope.launch { drawerState.close() }
                    onNavigateToLibrary()
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                ThemedTopAppBar(
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
                                tint = GoldenAccent,
                                modifier = Modifier.size(26.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(
                                    text = "বই ও ভাষা একাডেমি",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 17.sp
                                    )
                                )
                                Text(
                                    text = "Audiobooks & Language Courses",
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        fontSize = 10.sp,
                                        color = Color(0xFFE0F2F1)
                                    )
                                )
                            }
                        }
                    },
                    actions = {
                        // User balance badge
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = MaterialTheme.colorScheme.surface.copy(alpha = 0.2f),
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .clickable { onNavigateToPayment() }
                                .padding(end = 4.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = "৳ ${"%.0f".format(userBalance)}",
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = GoldenAccent
                                    )
                                )
                            }
                        }

                        IconButton(onClick = onNavigateToSearch) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "অনুসন্ধান"
                            )
                        }
                    }
                )
            },
            bottomBar = {
                if (playbackState.isPlaying || playbackState.bookId.isNotBlank()) {
                    MiniPlayerBar(
                        playbackState = playbackState,
                        onBarClick = onNavigateToPlayer,
                        onPlayPauseClick = { viewModel.player.togglePlayPause() },
                        onNextClick = { viewModel.player.nextChapter() },
                        onCloseClick = { viewModel.player.stopAndClose() }
                    )
                }
            }
        ) { paddingValues ->
            AppBackground(
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                if (uiState.isLoading) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            CircularProgressIndicator(
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(42.dp)
                            )
                            Spacer(modifier = Modifier.height(14.dp))
                            Text(
                                text = "ফায়ারবেস থেকে লাইভ কনটেন্ট লোড হচ্ছে...",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        }
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(bottom = 24.dp)
                    ) {
                        // 1. Hero Banner Carousel from Firestore
                        if (uiState.banners.isNotEmpty()) {
                            item {
                                Spacer(modifier = Modifier.height(12.dp))
                                HeroBannerCarousel(
                                    banners = uiState.banners,
                                    onBannerClick = { banner ->
                                        handleBannerClick(
                                            banner = banner,
                                            bundles = uiState.audioBundles,
                                            courses = uiState.englishCourses + uiState.japaneseCourses,
                                            onSelectBundle = { selectedBundle = it },
                                            onSelectCourse = { selectedCourse = it },
                                            onNavigateToBook = onNavigateToBook
                                        )
                                    }
                                )
                            }
                        }

                        // 2. Category Filter Chips
                        item {
                            Spacer(modifier = Modifier.height(12.dp))
                            CategoryFilterChipsRow(
                                selected = selectedCategory,
                                onSelect = { selectedCategory = it }
                            )
                        }

                        // 3. Continue Listening/Learning card
                        if (lastPlayed != null) {
                            item {
                                Spacer(modifier = Modifier.height(12.dp))
                                HomeContinueListeningCard(
                                    lastPlayed = lastPlayed!!,
                                    playbackState = playbackState,
                                    onContinueClick = {
                                        viewModel.continueLastPlayed()
                                        onNavigateToPlayer()
                                    }
                                )
                            }
                        }

                        // 4. 📦 AUDIO BOOK BUNDLES (Fetched directly from Firestore)
                        if ((selectedCategory == "all" || selectedCategory == "bundles") &&
                            uiState.audioBundles.isNotEmpty()
                        ) {
                            item {
                                Spacer(modifier = Modifier.height(16.dp))
                                SectionHeader(
                                    title = "অডিওবুক মেগা বান্ডেল",
                                    subtitle = "একাধিক বেস্টসেলার বই একসাথে আকর্ষণীয় ছাড়ে",
                                    icon = Icons.Default.LocalMall,
                                    onViewAllClick = { selectedCategory = "bundles" }
                                )
                                LazyRow(
                                    contentPadding = PaddingValues(horizontal = 16.dp),
                                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    items(uiState.audioBundles, key = { it.id }) { bundle ->
                                        BundleCard(
                                            bundle = bundle,
                                            onClick = { selectedBundle = bundle }
                                        )
                                    }
                                }
                            }
                        }

                        // 5. 🇬🇧 ENGLISH LANGUAGE COURSES (Fetched directly from Firestore)
                        if ((selectedCategory == "all" || selectedCategory == "english") &&
                            uiState.englishCourses.isNotEmpty()
                        ) {
                            item {
                                Spacer(modifier = Modifier.height(20.dp))
                                SectionHeader(
                                    title = "ইংরেজি ভাষা শিক্ষা কোর্স",
                                    subtitle = "স্পোকেন ইংলিশ, উচ্চারণ ও ভোকাবুলারি অডিও লেসন",
                                    icon = Icons.Default.Translate,
                                    onViewAllClick = { selectedCategory = "english" }
                                )
                                LazyRow(
                                    contentPadding = PaddingValues(horizontal = 16.dp),
                                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    items(uiState.englishCourses, key = { it.id }) { course ->
                                        CourseCard(
                                            course = course,
                                            onClick = { selectedCourse = course }
                                        )
                                    }
                                }
                            }
                        }

                        // 6. 🇯🇵 JAPANESE LANGUAGE COURSES (Fetched directly from Firestore)
                        if ((selectedCategory == "all" || selectedCategory == "japanese") &&
                            uiState.japaneseCourses.isNotEmpty()
                        ) {
                            item {
                                Spacer(modifier = Modifier.height(20.dp))
                                SectionHeader(
                                    title = "জাপানি ভাষা শিক্ষা (JLPT N5/N4)",
                                    subtitle = "জাপানে ভিসা, উচ্চশিক্ষা ও চাকরির জন্য পূর্ণাঙ্গ অডিও কোর্স",
                                    icon = Icons.Default.CastForEducation,
                                    onViewAllClick = { selectedCategory = "japanese" }
                                )
                                LazyRow(
                                    contentPadding = PaddingValues(horizontal = 16.dp),
                                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    items(uiState.japaneseCourses, key = { it.id }) { course ->
                                        CourseCard(
                                            course = course,
                                            onClick = { selectedCourse = course }
                                        )
                                    }
                                }
                            }
                        }

                        // 7. 🎧 TRENDING AUDIOBOOKS (From Firestore books collection)
                        if ((selectedCategory == "all" || selectedCategory == "books") &&
                            uiState.trendingBooks.isNotEmpty()
                        ) {
                            item {
                                Spacer(modifier = Modifier.height(20.dp))
                                SectionHeader(
                                    title = "জনপ্রিয় অডিওবুকসমূহ",
                                    subtitle = "অ্যাপ লাইব্রেরির নির্বাচিত বইগুলো শুনুন বা পড়ুন",
                                    icon = Icons.Default.Headphones,
                                    onViewAllClick = onNavigateToLibrary,
                                    viewAllText = "লাইব্রেরি দেখুন"
                                )
                                LazyRow(
                                    contentPadding = PaddingValues(horizontal = 16.dp),
                                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    items(uiState.trendingBooks, key = { it.id }) { book ->
                                        HomeTrendingBookCard(
                                            book = book,
                                            onClick = { onNavigateToBook(book.id) },
                                            onPlay = { onPlayBook(book.id, 0) }
                                        )
                                    }
                                }
                            }
                        }

                        // Bottom Spacer
                        item {
                            Spacer(modifier = Modifier.height(40.dp))
                        }
                    }
                }
            }
        }
    }

    // Interactive Bottom Sheet for Course Details
    selectedCourse?.let { course ->
        CourseDetailsBottomSheet(
            course = course,
            onDismiss = { selectedCourse = null },
            onEnrollClick = {
                selectedCourse = null
                onNavigateToPayment()
            }
        )
    }

    // Interactive Bottom Sheet for Bundle Details
    selectedBundle?.let { bundle ->
        BundleDetailsBottomSheet(
            bundle = bundle,
            onDismiss = { selectedBundle = null },
            onUnlockClick = {
                selectedBundle = null
                onNavigateToPayment()
            }
        )
    }

    // Profile Dialog
    if (showProfileDialog) {
        ProfileUpdateDialog(
            initialName = userName,
            initialInstitute = userInstitute,
            initialAddress = "",
            initialPhone = "",
            email = userEmail,
            onDismiss = { showProfileDialog = false },
            onSave = { _, _, _, _ ->
                showProfileDialog = false
            }
        )
    }

    // About Us Dialog
    if (showAboutUsDialog) {
        AboutUsDialog(onDismiss = { showAboutUsDialog = false })
    }
}

private fun handleBannerClick(
    banner: HeroBanner,
    bundles: List<AudioBundle>,
    courses: List<Course>,
    onSelectBundle: (AudioBundle) -> Unit,
    onSelectCourse: (Course) -> Unit,
    onNavigateToBook: (String) -> Unit
) {
    when (banner.actionType) {
        "bundle" -> {
            val bundle = bundles.find { it.id == banner.targetId } ?: bundles.firstOrNull()
            bundle?.let { onSelectBundle(it) }
        }
        "course" -> {
            val course = courses.find { it.id == banner.targetId } ?: courses.firstOrNull()
            course?.let { onSelectCourse(it) }
        }
        "book" -> {
            onNavigateToBook(banner.targetId)
        }
    }
}

@Composable
fun CategoryFilterChipsRow(
    selected: String,
    onSelect: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val categories = listOf(
        "all" to "সকল কনটেন্ট",
        "bundles" to "📦 অডিও বান্ডেল",
        "english" to "🇬🇧 ইংরেজি কোর্স",
        "japanese" to "🇯🇵 জাপানি কোর্স",
        "books" to "🎧 অডিওবুক"
    )

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        items(categories) { (key, label) ->
            val isSelected = selected == key
            Surface(
                color = if (isSelected) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .clickable { onSelect(key) }
            ) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
fun HomeContinueListeningCard(
    lastPlayed: PlaybackHistoryEntity,
    playbackState: PlaybackState,
    onContinueClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isCurrentPlaying = playbackState.isPlaying && playbackState.bookId == lastPlayed.bookId

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.25f),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onContinueClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Headphones,
                    contentDescription = null,
                    tint = GoldenAccent,
                    modifier = Modifier.size(26.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "পড়া/শোনা চালিয়ে যান",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    )
                    if (isCurrentPlaying) {
                        Spacer(modifier = Modifier.width(6.dp))
                        AudioWaveAnimation(isPlaying = true, maxHeight = 10.dp)
                    }
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = lastPlayed.bookTitle,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = lastPlayed.chapterTitle,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(
                onClick = onContinueClick,
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(if (isCurrentPlaying) GoldenAccent else MaterialTheme.colorScheme.primary)
            ) {
                Icon(
                    imageVector = if (isCurrentPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                    contentDescription = "চালিয়ে যান",
                    tint = if (isCurrentPlaying) Color.Black else Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun HomeTrendingBookCard(
    book: RemoteBook,
    onClick: () -> Unit,
    onPlay: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
            .width(160.dp)
            .clip(RoundedCornerShape(14.dp))
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f),
                shape = RoundedCornerShape(14.dp)
            )
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
            ) {
                BookCoverView(
                    title = book.title,
                    author = book.author,
                    coverPath = book.coverUrl ?: book.localCoverPath,
                    modifier = Modifier.fillMaxSize()
                )

                IconButton(
                    onClick = onPlay,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(6.dp)
                        .size(34.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "শুনুন",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = book.title,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if (!book.author.isNullOrBlank()) {
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = book.author,
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}
