package com.gigabyte.bookstore.learning.presentation.vocab

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gigabyte.bookstore.learning.presentation.lesson.NastaliqFontFamily

@Composable
fun VocabVaultScreen(
    viewModel: VocabVaultViewModel,
    onBack: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val focusManager = LocalFocusManager.current
    val accentColor = Color(uiState.config.accentColorHex)
    val isUrdu = uiState.config.langCode.lowercase() == "ur"

    Scaffold(
        topBar = {
            VocabTopBar(
                config = uiState.config,
                accentColor = accentColor,
                totalCount = uiState.totalCount,
                filteredCount = uiState.filteredCount,
                onBack = onBack
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            // Search Input
            VocabSearchBar(
                query = uiState.searchQuery,
                onQueryChange = viewModel::onSearchQueryChanged,
                onClear = {
                    viewModel.onSearchQueryChanged("")
                    focusManager.clearFocus()
                },
                accentColor = accentColor
            )

            // Category Chips Carousel
            CategoryChipsRow(
                selectedCategory = uiState.selectedCategory,
                onCategorySelect = viewModel::onCategorySelected,
                accentColor = accentColor
            )

            // Count summary header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${uiState.selectedCategory.titleBn} (${uiState.filteredCount}টি শব্দ)",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                if (uiState.searchQuery.isNotBlank() || uiState.selectedCategory != VocabCategory.ALL) {
                    Text(
                        text = "ফিল্টার রিসেট করুন",
                        style = MaterialTheme.typography.labelMedium,
                        color = accentColor,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.clickable {
                            viewModel.onCategorySelected(VocabCategory.ALL)
                            viewModel.onSearchQueryChanged("")
                        }
                    )
                }
            }

            // Word Cards List
            if (uiState.items.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "🔍",
                            fontSize = 48.sp
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "কোনো শব্দ খুঁজে পাওয়া যায়নি",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "অন্য কোনো শব্দ দিয়ে খুঁজুন অথবা ক্যাটাগরি পরিবর্তন করুন",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(uiState.items, key = { it.id }) { item ->
                        VocabItemCard(
                            item = item,
                            langCode = uiState.config.langCode,
                            accentColor = accentColor,
                            isUrdu = isUrdu,
                            activeSpeakingId = uiState.activeSpeakingId,
                            onPlaySingular = { viewModel.playSingular(item) },
                            onPlayPlural = { viewModel.playPlural(item) }
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(32.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun VocabTopBar(
    config: VocabLanguageConfig,
    accentColor: Color,
    totalCount: Int,
    filteredCount: Int,
    onBack: () -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 3.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            accentColor.copy(alpha = 0.12f),
                            Color.Transparent
                        )
                    )
                )
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "ফিরে যান",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = config.titleBn,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = accentColor.copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = "১,০০০ শব্দ",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = accentColor,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                            )
                        }
                    }
                    Text(
                        text = "${config.nativeTitle} • একবচন ও বহুবচন",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Composable
private fun VocabSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onClear: () -> Unit,
    accentColor: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "শব্দ, উচ্চারণ বা অর্থ দিয়ে খুঁজুন...",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
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
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = accentColor,
                unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant,
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface
            ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search)
        )
    }
}

@Composable
private fun CategoryChipsRow(
    selectedCategory: VocabCategory,
    onCategorySelect: (VocabCategory) -> Unit,
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
        VocabCategory.values().forEach { category ->
            val isSelected = category == selectedCategory
            val chipBg by animateColorAsState(
                targetValue = if (isSelected) accentColor else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                label = "chipBg"
            )
            val textColor by animateColorAsState(
                targetValue = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface,
                label = "textColor"
            )

            Surface(
                shape = RoundedCornerShape(20.dp),
                color = chipBg,
                border = if (!isSelected) BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant) else null,
                modifier = Modifier.clickable { onCategorySelect(category) }
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(text = category.iconEmoji, fontSize = 14.sp)
                    Text(
                        text = category.titleBn,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = textColor
                    )
                }
            }
        }
    }
}

@Composable
private fun VocabItemCard(
    item: VocabItem,
    langCode: String,
    accentColor: Color,
    isUrdu: Boolean,
    activeSpeakingId: String?,
    onPlaySingular: () -> Unit,
    onPlayPlural: () -> Unit
) {
    val isSingularPlaying = activeSpeakingId == "${item.id}_sg"
    val isPluralPlaying = activeSpeakingId == "${item.id}_pl"

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.5.dp),
        border = BorderStroke(
            width = if (isSingularPlaying || isPluralPlaying) 1.5.dp else 1.dp,
            color = if (isSingularPlaying || isPluralPlaying) accentColor else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.6f)
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header Row: Category Badge + Gender Badge
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Category Chip
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
                ) {
                    Text(
                        text = "${item.category.iconEmoji} ${item.category.titleBn}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                // Gender Badge or German Article Badge
                if (langCode == "de") {
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        if (!item.germanArticleSingular.isNullOrBlank()) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = accentColor.copy(alpha = 0.15f)
                            ) {
                                Text(
                                    text = "একবচন: ${item.germanArticleSingular}",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = accentColor,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                                )
                            }
                        }
                        if (item.gender != GrammaticalGender.NONE) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = Color(item.gender.badgeColorHex).copy(alpha = 0.12f)
                            ) {
                                Text(
                                    text = item.gender.labelBn,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(item.gender.badgeColorHex),
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                                )
                            }
                        }
                    }
                } else if (item.gender != GrammaticalGender.NONE) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(item.gender.badgeColorHex).copy(alpha = 0.12f)
                    ) {
                        Text(
                            text = item.gender.labelBn,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(item.gender.badgeColorHex),
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                }
            }

            // Bengali Meaning (Large bold)
            Text(
                text = item.bnMeaning,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            // Singular & Plural Forms
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                // Singular Row
                FormPlayRow(
                    label = "একবচন (Singular)",
                    article = item.germanArticleSingular,
                    targetText = item.singularTarget,
                    pronText = item.singularBnPron,
                    secondaryText = item.singularSecondary,
                    isUrdu = isUrdu,
                    isPlaying = isSingularPlaying,
                    accentColor = accentColor,
                    onPlay = onPlaySingular
                )

                // Plural Row (if available)
                if (!item.pluralTarget.isNullOrBlank()) {
                    FormPlayRow(
                        label = "বহুবচন (Plural)",
                        article = item.germanArticlePlural ?: if (langCode == "de") "die" else null,
                        targetText = item.pluralTarget,
                        pronText = item.pluralBnPron ?: "",
                        secondaryText = item.pluralSecondary,
                        isUrdu = isUrdu,
                        isPlaying = isPluralPlaying,
                        accentColor = accentColor,
                        onPlay = onPlayPlural
                    )
                }
            }

            // Optional Note
            if (!item.noteBn.isNullOrBlank()) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "💡 ${item.noteBn}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun FormPlayRow(
    label: String,
    article: String?,
    targetText: String,
    pronText: String,
    secondaryText: String?,
    isUrdu: Boolean,
    isPlaying: Boolean,
    accentColor: Color,
    onPlay: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = if (isPlaying) accentColor.copy(alpha = 0.08f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
        border = if (isPlaying) BorderStroke(1.dp, accentColor) else null,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                // Tag label
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.75f)
                )

                // Target word
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    if (!article.isNullOrBlank()) {
                        Text(
                            text = article,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = accentColor
                        )
                    }
                    Text(
                        text = targetText,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontFamily = if (isUrdu) NastaliqFontFamily else null,
                            textDirection = if (isUrdu) TextDirection.Rtl else TextDirection.Ltr
                        ),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    if (!secondaryText.isNullOrBlank()) {
                        Text(
                            text = "($secondaryText)",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                // Bengali Pronunciation
                if (pronText.isNotBlank()) {
                    Text(
                        text = "উচ্চারণ: $pronText",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // Play / Stop Icon Button
            Surface(
                shape = CircleShape,
                color = if (isPlaying) accentColor else MaterialTheme.colorScheme.surface,
                border = BorderStroke(1.dp, if (isPlaying) accentColor else MaterialTheme.colorScheme.outlineVariant),
                modifier = Modifier
                    .size(38.dp)
                    .clickable(onClick = onPlay)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = if (isPlaying) Icons.Default.Stop else Icons.AutoMirrored.Filled.VolumeUp,
                        contentDescription = "শুনুন",
                        tint = if (isPlaying) Color.White else accentColor,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

