package com.gigabyte.bookstore.presentation.home

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
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
import androidx.compose.ui.platform.LocalContext
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
import com.gigabyte.bookstore.presentation.components.ExitConfirmationDialog
import com.gigabyte.bookstore.presentation.components.MiniPlayerBar
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar
import com.gigabyte.bookstore.presentation.drawer.AboutUsDialog
import com.gigabyte.bookstore.presentation.drawer.AppDrawerContent
import com.gigabyte.bookstore.presentation.drawer.ProfileUpdateDialog
import com.gigabyte.bookstore.presentation.home.components.BundleCard
import com.gigabyte.bookstore.presentation.home.components.CourseCard
import com.gigabyte.bookstore.presentation.home.components.CourseDetailsBottomSheet
import com.gigabyte.bookstore.presentation.home.components.HeroBannerCarousel
import com.gigabyte.bookstore.presentation.home.components.HomeShowcaseCard
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
    onNavigateToBookCategories: ((String?) -> Unit)? = null,
    onNavigateToLearnEnglish: () -> Unit = {},
    onNavigateToLearnJapanese: () -> Unit = {},
    onNavigateToLearnUrdu: () -> Unit = {},
    onNavigateToLastRead: () -> Unit = {},
    onLogout: (() -> Unit)? = null,
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
    val unlockedBundles by viewModel.unlockedBundles.collectAsStateWithLifecycle()

    val isAudiobookUnlocked = remember(userStatus, unlockedBundles) {
        viewModel.isBundleUnlocked("audiobook_bundle")
    }
    val isEnglishUnlocked = remember(userStatus, unlockedBundles) {
        viewModel.isBundleUnlocked("english_course")
    }
    val isJapaneseUnlocked = remember(userStatus, unlockedBundles) {
        viewModel.isBundleUnlocked("japanese_course")
    }
    val isUrduUnlocked = remember(userStatus, unlockedBundles) {
        viewModel.isBundleUnlocked("urdu_course")
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    var showProfileDialog by remember { mutableStateOf(false) }
    var showAboutUsDialog by remember { mutableStateOf(false) }
    var showExitDialog by remember { mutableStateOf(false) }
    var backPressedTime by remember { mutableStateOf(0L) }

    BackHandler(enabled = true) {
        if (showExitDialog) {
            showExitDialog = false
        } else if (drawerState.isOpen) {
            scope.launch { drawerState.close() }
        } else {
            val currentTime = System.currentTimeMillis()
            if (currentTime - backPressedTime < 2000L) {
                showExitDialog = true
            } else {
                backPressedTime = currentTime
                Toast.makeText(context, "অ্যাপ বন্ধ করতে আবার ব্যাক চাপুন", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Bottom sheet state for Course
    var selectedCourse by remember { mutableStateOf<Course?>(null) }

    // Filter Chip State (3 categories: bundles, english, japanese)
    var selectedCategory by remember { mutableStateOf("all") }

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
                    onNavigateToLastRead()
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
                },
                onLogoutClick = onLogout?.let { logout ->
                    {
                        scope.launch { drawerState.close() }
                        logout()
                    }
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
                                            courses = uiState.englishCourses + uiState.japaneseCourses,
                                            onSelectCourse = { selectedCourse = it },
                                            onNavigateToLibrary = onNavigateToLibrary,
                                            onNavigateToBook = onNavigateToBook,
                                            onNavigateToLearnEnglish = onNavigateToLearnEnglish,
                                            onNavigateToLearnJapanese = onNavigateToLearnJapanese
                                        )
                                    }
                                )
                            }
                        }

                        // 1. 📚 BUNDLE BOOKS SHOWCASE CARD
                        item {
                            Spacer(modifier = Modifier.height(14.dp))
                            val bundle = uiState.audioBundles.firstOrNull()
                            HomeShowcaseCard(
                                title = bundle?.title?.ifBlank { "আত্ম উন্নয়নমূলক বাংলা বই বান্ডেল" } ?: "আত্ম উন্নয়নমূলক বাংলা বই বান্ডেল",
                                subtitle = bundle?.subtitle ?: "৫০+ বিশ্বসেরা বই, জীবনী, ক্যারিয়ার ও মোটিভেশনাল সংকলন",
                                badgeText = "📚 বাংলা বই বান্ডেল",
                                badgeColor = Color(0xFF0D9488),
                                priceText = "১০০ টাকা",
                                isPurchased = isAudiobookUnlocked,
                                imageUrl = bundle?.coverUrl,
                                fallbackGradientColors = listOf(Color(0xFF0D9488), Color(0xFF042F2E)),
                                accentColor = Color(0xFF0D9488),
                                statsText = "📚 ${bundle?.bookCount ?: 50}+ টি বই · সকল ক্যাটাগরি",
                                ctaText = "ক্যাটাগরি সমূহ দেখুন",
                                onClick = { onNavigateToBookCategories?.invoke(bundle?.id) },
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
                        }

                        // 2. 🇬🇧 ENGLISH LANGUAGE COURSE SHOWCASE CARD
                        item {
                            Spacer(modifier = Modifier.height(16.dp))
                            val englishCourse = uiState.englishCourses.firstOrNull()
                            val spokenBanner = uiState.banners.find { it.id == "banner_spoken_english" }
                            val englishTitle = spokenBanner?.title?.ifBlank { null }
                                ?: englishCourse?.title?.takeIf { !it.contains("ভোকাবুলারি") }
                                ?: "স্পোকেন ইংলিশ কোর্স"
                            val englishSubtitle = spokenBanner?.subtitle?.ifBlank { null }
                                ?: englishCourse?.subtitle
                                ?: "নেটিভ অডিও ও সহজ নিয়মে ফ্লুয়েন্টলি কথা বলুন"
                            val englishImageUrl = spokenBanner?.imageUrl?.ifBlank { null }
                                ?: englishCourse?.bannerUrl
                                ?: englishCourse?.thumbnailUrl

                            HomeShowcaseCard(
                                title = englishTitle,
                                subtitle = englishSubtitle,
                                badgeText = spokenBanner?.tag?.ifBlank { null } ?: "🇬🇧 স্পোকেন ইংলিশ কোর্স",
                                badgeColor = Color(0xFF1565C0),
                                priceText = "১০০ টাকা",
                                isPurchased = isEnglishUnlocked,
                                imageUrl = englishImageUrl,
                                fallbackGradientColors = listOf(Color(0xFF1565C0), Color(0xFF0D47A1)),
                                accentColor = Color(0xFF1565C0),
                                statsText = "🎧 ${englishCourse?.lessonCount ?: 15}টি অডিও লেসন · লেভেল: ${englishCourse?.level?.ifBlank { "Beginner" } ?: "Beginner"}",
                                ctaText = "কোর্সটি শুরু করুন",
                                onClick = onNavigateToLearnEnglish,
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
                        }

                        // 3. 🇯🇵 JAPANESE LANGUAGE COURSE SHOWCASE CARD
                        item {
                            Spacer(modifier = Modifier.height(16.dp))
                            val japaneseCourse = uiState.japaneseCourses.firstOrNull()
                            val japaneseBanner = uiState.banners.find { it.id == "banner_japanese_jlpt" }
                            val japaneseTitle = japaneseBanner?.title?.ifBlank { null }
                                ?: japaneseCourse?.title
                                ?: "জাপানি ভাষা শিক্ষা (JLPT N5/N4)"
                            val japaneseSubtitle = japaneseBanner?.subtitle?.ifBlank { null }
                                ?: japaneseCourse?.subtitle
                                ?: "জাপানে ভিসা, উচ্চশিক্ষা ও চাকরির জন্য পূর্ণাঙ্গ অডিও গাইড"
                            val japaneseImageUrl = japaneseBanner?.imageUrl?.ifBlank { null }
                                ?: japaneseCourse?.bannerUrl
                                ?: japaneseCourse?.thumbnailUrl

                            HomeShowcaseCard(
                                title = japaneseTitle,
                                subtitle = japaneseSubtitle,
                                badgeText = japaneseBanner?.tag?.ifBlank { null } ?: "🇯🇵 জাপানি ভাষা কোর্স",
                                badgeColor = Color(0xFFC62828),
                                priceText = "১০০ টাকা",
                                isPurchased = isJapaneseUnlocked,
                                imageUrl = japaneseImageUrl,
                                fallbackGradientColors = listOf(Color(0xFFC62828), Color(0xFF7F1D1D)),
                                accentColor = Color(0xFFC62828),
                                statsText = "🎧 ${japaneseCourse?.lessonCount ?: 12}টি অডিও লেসন · JLPT প্রস্তুতি",
                                ctaText = "কোর্সটি শুরু করুন",
                                onClick = onNavigateToLearnJapanese,
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
                        }

                        // 4. URDU LANGUAGE COURSE SHOWCASE CARD (Urdu-Spoken-Curriculum-Plan.md)
                        item {
                            Spacer(modifier = Modifier.height(16.dp))
                            HomeShowcaseCard(
                                title = "উর্দু স্পোকেন কোর্স (শূন্য থেকে A1)",
                                subtitle = "বাংলা থেকে সহজ নিয়মে উর্দু হরফ, উচ্চারণ ও দৈনন্দিন কথা বলা",
                                badgeText = "🇵🇰 উর্দু ভাষা কোর্স",
                                badgeColor = Color(0xFF1B5E20),
                                priceText = "১০০ টাকা",
                                isPurchased = isUrduUnlocked,
                                imageUrl = null,
                                fallbackGradientColors = listOf(Color(0xFF2E7D32), Color(0xFF1B5E20)),
                                accentColor = Color(0xFF1B5E20),
                                statsText = "🎧 ১০৫টি অডিও লেসন · শূন্য থেকে A1",
                                ctaText = "কোর্সটি শুরু করুন",
                                // Locked until the urdu_course bundle is bought (or the mega bundle).
                                onClick = if (isUrduUnlocked) onNavigateToLearnUrdu else onNavigateToPayment,
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
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
                val isCourseUnlocked = if (course.language.equals("Japanese", ignoreCase = true)) {
                    isJapaneseUnlocked
                } else {
                    isEnglishUnlocked
                }
                if (isCourseUnlocked) {
                    val firstLesson = course.modules.firstOrNull()?.lessons?.firstOrNull()
                    if (firstLesson != null) {
                        viewModel.playCourseLesson(course, firstLesson)
                    }
                } else {
                    onNavigateToPayment()
                }
            },
            onPlayLesson = { clickedCourse, lesson ->
                viewModel.playCourseLesson(clickedCourse, lesson)
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

    // Exit Confirmation Dialog
    if (showExitDialog) {
        ExitConfirmationDialog(
            onConfirmExit = {
                showExitDialog = false
                (context as? Activity)?.finish()
            },
            onDismiss = {
                showExitDialog = false
            }
        )
    }
}

private fun handleBannerClick(
    banner: HeroBanner,
    courses: List<Course>,
    onSelectCourse: (Course) -> Unit,
    onNavigateToLibrary: () -> Unit,
    onNavigateToBook: (String) -> Unit,
    onNavigateToLearnEnglish: () -> Unit = {},
    onNavigateToLearnJapanese: () -> Unit = {}
) {
    if (banner.id == "banner_spoken_english" || banner.targetId == "learn_english" || banner.actionType == "learn" || banner.actionType == "english") {
        onNavigateToLearnEnglish()
        return
    }
    if (banner.id == "banner_japanese_jlpt" || banner.targetId == "learn_japanese" || banner.actionType == "japanese") {
        onNavigateToLearnJapanese()
        return
    }
    when (banner.actionType) {
        "bundle" -> onNavigateToLibrary()
        "course" -> {
            val course = courses.find { it.id == banner.targetId } ?: courses.firstOrNull()
            course?.let { onSelectCourse(it) }
        }
        "book" -> onNavigateToBook(banner.targetId)
        else -> onNavigateToLibrary()
    }
}

@Composable
fun CategoryFilterChipsRow(
    selected: String,
    onSelect: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val categories = listOf(
        "all" to "সব ক্যাটেগরী",
        "bundles" to "📚 আত্ম উন্নয়নমূলক বাংলা বই",
        "english" to "🇬🇧 ইংলিশ কোর্স",
        "japanese" to "🇯🇵 জাপানি কোর্স"
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
