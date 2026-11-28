package com.gigabyte.bookstore.presentation.story

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.data.ads.AdConfig
import com.gigabyte.bookstore.data.ads.SmartInterstitialAdManager
import com.gigabyte.bookstore.data.models.MotivationalCategory
import com.gigabyte.bookstore.data.models.MotivationalStory
import com.gigabyte.bookstore.presentation.components.AppBackground
import com.gigabyte.bookstore.presentation.components.FacebookBannerAd
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar

private fun Int.toBanglaDigits(): String {
    val bnDigits = charArrayOf('০', '১', '২', '৩', '৪', '৫', '৬', '৭', '৮', '৯')
    return this.toString().map { c ->
        if (c in '0'..'9') bnDigits[c - '0'] else c
    }.joinToString("")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MotivationalStoryScreen(
    viewModel: MotivationalStoryViewModel,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val categories by viewModel.categories.collectAsStateWithLifecycle()
    val selectedCategorySlug by viewModel.selectedCategorySlug.collectAsStateWithLifecycle()
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    val stories by viewModel.filteredStories.collectAsStateWithLifecycle()
    val activeStory by viewModel.activeStory.collectAsStateWithLifecycle()
    val isSpeaking by viewModel.isSpeaking.collectAsStateWithLifecycle()
    val fontSize by viewModel.fontSize.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    val focusManager = LocalFocusManager.current
    val accentFlame = Color(0xFFF97316)

    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "অনুপ্রেরণার গল্প",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = accentFlame.copy(alpha = 0.25f)
                            ) {
                                Text(
                                    text = "৫০টি গল্প",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = accentFlame,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(
                            text = "ব্যর্থতা জয়, অদম্য ইচ্ছাশক্তি ও কখনো হাল না ছাড়ার অনুপ্রেরণা",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White.copy(alpha = 0.75f),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                },
                navigationIcon = {
                    val activity = LocalContext.current as? Activity
                    IconButton(onClick = {
                        if (activity != null) {
                            SmartInterstitialAdManager.getInstance(activity).showInterstitialIfReady(activity) {
                                onBackClick()
                            }
                        } else {
                            onBackClick()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ফিরে যান",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    if (isSpeaking) {
                        IconButton(onClick = { viewModel.stopTts() }) {
                            Icon(
                                imageVector = Icons.Default.Stop,
                                contentDescription = "ভয়েস থামান",
                                tint = Color(0xFFEF4444)
                            )
                        }
                    }
                }
            )
        },
        bottomBar = {
            FacebookBannerAd(
                placementId = AdConfig.ADMOB_BANNER_AD_UNIT_ID,
                adSize = com.google.android.gms.ads.AdSize.BANNER
            )
        }
    ) { innerPadding ->
        AppBackground {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                // Search Input
                MotivationalSearchBar(
                    query = searchQuery,
                    onQueryChange = viewModel::updateSearchQuery,
                    onClear = {
                        viewModel.updateSearchQuery("")
                        focusManager.clearFocus()
                    },
                    accentColor = accentFlame
                )

                // Category Filter Chips
                MotivationalCategoryChips(
                    categories = categories,
                    selectedSlug = selectedCategorySlug,
                    onSelect = viewModel::selectCategory,
                    accentColor = accentFlame
                )

                // Story List Header Count
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "গল্পের তালিকা (${stories.size.toBanglaDigits()}টি)",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    if (searchQuery.isNotBlank() || selectedCategorySlug != "all") {
                        Text(
                            text = "ফিল্টার রিসেট",
                            style = MaterialTheme.typography.labelMedium,
                            color = accentFlame,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.clickable {
                                viewModel.selectCategory("all")
                                viewModel.updateSearchQuery("")
                            }
                        )
                    }
                }

                // Story Cards
                if (isLoading) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(color = accentFlame)
                    }
                } else if (stories.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "কোনো গল্প পাওয়া যায়নি!\nঅন্য কোনো শব্দ দিয়ে সার্চ করে দেখুন।",
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(stories, key = { it.id }) { story ->
                            MotivationalStoryCard(
                                story = story,
                                isSpeakingThis = isSpeaking && activeStory?.id == story.id,
                                onReadClick = { viewModel.openStory(story) },
                                onAudioClick = {
                                    viewModel.openStory(story)
                                    viewModel.toggleTts(story)
                                },
                                accentColor = accentFlame
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }

    // Modal Story Reader
    activeStory?.let { currentStory ->
        val activity = LocalContext.current as? Activity
        MotivationalStoryReaderBottomSheet(
            story = currentStory,
            isSpeaking = isSpeaking,
            fontSize = fontSize,
            onDismiss = {
                viewModel.closeStory()
                if (activity != null) {
                    val manager = SmartInterstitialAdManager.getInstance(activity)
                    manager.recordAction()
                    manager.showInterstitialIfReady(activity) {}
                }
            },
            onToggleTts = { viewModel.toggleTts(currentStory) },
            onIncreaseFontSize = { viewModel.increaseFontSize() },
            onDecreaseFontSize = { viewModel.decreaseFontSize() },
            onNextStory = { viewModel.goToNextStory() },
            onPreviousStory = { viewModel.goToPreviousStory() },
            accentColor = accentFlame
        )
    }
}

@Composable
private fun MotivationalSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onClear: () -> Unit,
    accentColor: Color
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        placeholder = {
            Text(
                text = "অনুপ্রেরণার গল্প খুঁজুন (যেমন: এডিসন, চাকরি, হাল না ছাড়া...)",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "সার্চ",
                tint = accentColor
            )
        },
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(onClick = onClear) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "মুছুন",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        shape = RoundedCornerShape(14.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = accentColor,
            unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
            focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f)
        )
    )
}

@Composable
private fun MotivationalCategoryChips(
    categories: List<MotivationalCategory>,
    selectedSlug: String,
    onSelect: (String) -> Unit,
    accentColor: Color
) {
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState)
            .padding(horizontal = 16.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        categories.forEach { cat ->
            val isSelected = selectedSlug == cat.slug
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = if (isSelected) accentColor else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
                border = BorderStroke(
                    width = 1.dp,
                    color = if (isSelected) accentColor else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                ),
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .clickable { onSelect(cat.slug) }
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(text = cat.icon, fontSize = 14.sp)
                    Text(
                        text = cat.name,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "(${cat.storyCount.toBanglaDigits()})",
                        style = MaterialTheme.typography.labelSmall,
                        color = if (isSelected) Color.White.copy(alpha = 0.85f) else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun MotivationalStoryCard(
    story: MotivationalStory,
    isSpeakingThis: Boolean,
    onReadClick: () -> Unit,
    onAudioClick: () -> Unit,
    accentColor: Color
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.35f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable { onReadClick() }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Category & Order Badges
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = accentColor.copy(alpha = 0.15f)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(text = story.categoryIcon, fontSize = 12.sp)
                        Text(
                            text = story.category,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = accentColor
                        )
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "⏱️ ${story.readingMinutes.toBanglaDigits()} মিনিট",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Surface(
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Text(
                            text = "#${story.order.toBanglaDigits()}",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Title
            Text(
                text = story.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Snippet preview
            Text(
                text = story.content.take(130).replace("\n", " ").trim() + "...",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = onReadClick,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = accentColor,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AutoStories,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "পড়ুন",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelLarge
                    )
                }

                OutlinedButton(
                    onClick = onAudioClick,
                    modifier = Modifier.weight(1f),
                    border = BorderStroke(
                        1.dp,
                        if (isSpeakingThis) Color(0xFFEF4444) else accentColor
                    ),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = if (isSpeakingThis) Color(0xFFEF4444) else accentColor
                    ),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    Icon(
                        imageVector = if (isSpeakingThis) Icons.Default.Stop else Icons.Default.Headphones,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isSpeakingThis) "থামান" else "শুনুন 🎧",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MotivationalStoryReaderBottomSheet(
    story: MotivationalStory,
    isSpeaking: Boolean,
    fontSize: Int,
    onDismiss: () -> Unit,
    onToggleTts: () -> Unit,
    onIncreaseFontSize: () -> Unit,
    onDecreaseFontSize: () -> Unit,
    onNextStory: () -> Unit,
    onPreviousStory: () -> Unit,
    accentColor: Color
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val context = LocalContext.current

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .padding(bottom = 24.dp)
        ) {
            // Header: Category, Font & Controls
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = accentColor.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(text = story.categoryIcon, fontSize = 14.sp)
                        Text(
                            text = "${story.category} · #${story.order.toBanglaDigits()}",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = accentColor
                        )
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    // Font decrease
                    IconButton(onClick = onDecreaseFontSize, modifier = Modifier.size(36.dp)) {
                        Text(text = "A-", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }
                    // Font size badge
                    Text(
                        text = "${fontSize.toBanglaDigits()}px",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    // Font increase
                    IconButton(onClick = onIncreaseFontSize, modifier = Modifier.size(36.dp)) {
                        Text(text = "A+", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    // Close button
                    IconButton(onClick = onDismiss, modifier = Modifier.size(36.dp)) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "বন্ধ করুন",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Action Toolbar (TTS, Copy, Share)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onToggleTts,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSpeaking) Color(0xFFEF4444) else accentColor,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.weight(1f),
                    contentPadding = PaddingValues(vertical = 6.dp)
                ) {
                    Icon(
                        imageVector = if (isSpeaking) Icons.Default.Stop else Icons.AutoMirrored.Filled.VolumeUp,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isSpeaking) "ভয়েস থামান" else "ভয়েসে শুনুন 🎧",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelMedium
                    )
                }

                IconButton(
                    onClick = {
                        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        val clip = ClipData.newPlainText(story.title, "${story.title}\n\n${story.content}")
                        clipboard.setPrimaryClip(clip)
                        Toast.makeText(context, "গল্পটি কপি করা হয়েছে!", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Icon(
                        imageVector = Icons.Default.ContentCopy,
                        contentDescription = "কপি করুন",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }

                IconButton(
                    onClick = {
                        val shareIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_SUBJECT, story.title)
                            putExtra(
                                Intent.EXTRA_TEXT,
                                "${story.title}\n\n${story.content}\n\n- অনুপ্রেরণার গল্প সংকলন (Audiobook Library)"
                            )
                        }
                        context.startActivity(Intent.createChooser(shareIntent, "গল্প শেয়ার করুন"))
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "শেয়ার করুন",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.35f))
            Spacer(modifier = Modifier.height(12.dp))

            // Scrollable Story Content
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(scrollState)
            ) {
                Text(
                    text = story.title,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = story.content,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = fontSize.sp,
                        lineHeight = (fontSize * 1.65).sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )

                Spacer(modifier = Modifier.height(32.dp))
            }

            // Bottom Navigation (Previous / Next story)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = onPreviousStory,
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "পূর্ববর্তী গল্প", style = MaterialTheme.typography.labelMedium)
                }

                Button(
                    onClick = onNextStory,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = accentColor,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp)
                ) {
                    Text(text = "পরবর্তী গল্প", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelMedium)
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}
