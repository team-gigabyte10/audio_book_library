package com.gigabyte.bookstore.learning.presentation.kana

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gigabyte.bookstore.presentation.components.ThemedTopAppBar

private val JapaneseCrimson = Color(0xFFC62828)
private val JapaneseRose = Color(0xFFD81B60)
private val JapaneseIndigo = Color(0xFF283593)
private val JapaneseTeal = Color(0xFF00695C)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JapaneseKanaChartScreen(
    viewModel: JapaneseKanaChartViewModel,
    onBackClick: () -> Unit
) {
    val scriptMode by viewModel.scriptMode.collectAsState()
    val category by viewModel.category.collectAsState()
    val speechRate by viewModel.speechRate.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val rows by viewModel.filteredRows.collectAsState()
    val selectedLetter by viewModel.selectedLetterForDetail.collectAsState()

    val isSpeaking by viewModel.audioPlayer.isSpeaking.collectAsState()
    val activeSpeakingId by viewModel.audioPlayer.activeSpeakingId.collectAsState()

    var isSearchVisible by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            ThemedTopAppBar(
                title = {
                    Column {
                        Text(
                            text = "জাপানি বর্ণমালা ও উচ্চারণ চার্ট",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "সব বর্ণ ও যুক্তধ্বনি · ট্যাপ করলেই অডিও",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    // Search toggle
                    IconButton(onClick = { isSearchVisible = !isSearchVisible }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = if (searchQuery.isNotEmpty()) JapaneseCrimson else MaterialTheme.colorScheme.onSurface
                        )
                    }

                    // Speed Toggle Button
                    Surface(
                        onClick = { viewModel.toggleSpeechRate() },
                        shape = RoundedCornerShape(12.dp),
                        color = JapaneseCrimson.copy(alpha = 0.12f),
                        border = BorderStroke(1.dp, JapaneseCrimson.copy(alpha = 0.35f)),
                        modifier = Modifier.padding(end = 6.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Speed,
                                contentDescription = null,
                                tint = JapaneseCrimson,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (speechRate == 1.0f) "1.0x" else "0.7x (Slow)",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = JapaneseCrimson
                            )
                        }
                    }

                    // Stop button if audio is playing
                    if (isSpeaking) {
                        IconButton(onClick = { viewModel.stopAudio() }) {
                            Icon(
                                imageVector = Icons.Default.Stop,
                                contentDescription = "Stop Audio",
                                tint = JapaneseCrimson
                            )
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Search Input Field (Collapsible)
            AnimatedVisibility(visible = isSearchVisible) {
                Surface(
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { viewModel.setSearchQuery(it) },
                        placeholder = { Text("রোমাজি বা বাংলায় খুঁজুন (যেমন: ka, sa, কা, ফুল)...") },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Search, contentDescription = null)
                        },
                        trailingIcon = {
                            if (searchQuery.isNotEmpty()) {
                                IconButton(onClick = { viewModel.setSearchQuery("") }) {
                                    Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")
                                }
                            }
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(14.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = JapaneseCrimson,
                            unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }

            // Script Mode Selector Chips (হিরাগানা | কাতাকানা | উভয়)
            ScriptModeSelector(
                currentMode = scriptMode,
                onModeSelected = { viewModel.setScriptMode(it) }
            )

            // Category Tabs (সব | মূল বর্ণ | ভয়েসড | যুক্তধ্বনি)
            CategoryTabRow(
                currentCategory = category,
                onCategorySelected = { viewModel.setCategory(it) }
            )

            // Helper Instruction Banner
            Surface(
                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "যেকোনো অক্ষরে ট্যাপ করলেই উচ্চারণ শুনবেন। বিস্তারিত ও উদাহরণের জন্য চেপে ধরুন।",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.5.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // Kana Rows List
            if (rows.isEmpty()) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "কোনো অক্ষর খুঁজে পাওয়া যায়নি",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextButton(onClick = { viewModel.setSearchQuery("") }) {
                            Text("ফিল্টার রিসেট করুন", color = JapaneseCrimson)
                        }
                    }
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(rows, key = { it.id }) { row ->
                        KanaRowSection(
                            row = row,
                            scriptMode = scriptMode,
                            activeSpeakingId = activeSpeakingId,
                            onPlayLetter = { viewModel.playLetter(it) },
                            onPlayRow = { viewModel.playRow(row) },
                            onLongClickLetter = { viewModel.openDetail(it) }
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(32.dp))
                    }
                }
            }
        }
    }

    // Modal Bottom Sheet for Letter Detail & Real Vocabulary
    selectedLetter?.let { letter ->
        ModalBottomSheet(
            onDismissRequest = { viewModel.closeDetail() },
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        ) {
            KanaDetailContent(
                letter = letter,
                speechRate = speechRate,
                isSpeaking = isSpeaking && activeSpeakingId == letter.id,
                onPlayLetter = { viewModel.playLetter(letter) },
                onPlayExample = { viewModel.playExample(letter) },
                onDismiss = { viewModel.closeDetail() }
            )
        }
    }
}

@Composable
private fun ScriptModeSelector(
    currentMode: ScriptMode,
    onModeSelected: (ScriptMode) -> Unit
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(ScriptMode.entries.toTypedArray()) { mode ->
            val isSelected = currentMode == mode
            FilterChip(
                selected = isSelected,
                onClick = { onModeSelected(mode) },
                label = {
                    Text(
                        text = mode.titleBn,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        fontSize = 12.5.sp
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = JapaneseCrimson,
                    selectedLabelColor = Color.White
                ),
                border = FilterChipDefaults.filterChipBorder(
                    enabled = true,
                    selected = isSelected,
                    borderColor = if (isSelected) JapaneseCrimson else MaterialTheme.colorScheme.outlineVariant
                )
            )
        }
    }
}

@Composable
private fun CategoryTabRow(
    currentCategory: KanaCategory,
    onCategorySelected: (KanaCategory) -> Unit
) {
    ScrollableTabRow(
        selectedTabIndex = KanaCategory.entries.indexOf(currentCategory),
        edgePadding = 12.dp,
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.fillMaxWidth()
    ) {
        KanaCategory.entries.forEach { cat ->
            val isSelected = currentCategory == cat
            Tab(
                selected = isSelected,
                onClick = { onCategorySelected(cat) },
                text = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = cat.titleBn,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                            fontSize = 13.sp,
                            color = if (isSelected) JapaneseCrimson else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = cat.countLabel,
                            fontSize = 10.sp,
                            color = if (isSelected) JapaneseCrimson.copy(alpha = 0.8f) else MaterialTheme.colorScheme.outline
                        )
                    }
                }
            )
        }
    }
}

@Composable
private fun KanaRowSection(
    row: KanaRow,
    scriptMode: ScriptMode,
    activeSpeakingId: String?,
    onPlayLetter: (KanaLetter) -> Unit,
    onPlayRow: () -> Unit,
    onLongClickLetter: (KanaLetter) -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            // Row Header (Title + Play Row Button)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 2.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = row.nameBn,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.5.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = row.nameTarget,
                        fontSize = 11.5.sp,
                        color = MaterialTheme.colorScheme.outline
                    )
                }

                // Row Audio Button
                Surface(
                    onClick = onPlayRow,
                    shape = RoundedCornerShape(10.dp),
                    color = JapaneseRose.copy(alpha = 0.1f),
                    border = BorderStroke(1.dp, JapaneseRose.copy(alpha = 0.25f))
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                            contentDescription = "Play Row",
                            tint = JapaneseRose,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "সারি শুনুন",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = JapaneseRose
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Grid of Letters
            val columnCount = if (row.category == KanaCategory.YOON) 3 else 5
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                for (letter in row.letters) {
                    Box(modifier = Modifier.weight(1f)) {
                        if (letter != null) {
                            val isCurrentlySpeaking = activeSpeakingId == letter.id
                            KanaLetterCell(
                                letter = letter,
                                scriptMode = scriptMode,
                                isSpeaking = isCurrentlySpeaking,
                                onClick = { onPlayLetter(letter) },
                                onLongClick = { onLongClickLetter(letter) }
                            )
                        } else {
                            // Blank placeholder for missing vowels (like Yi, Ye in Japanese)
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(68.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun KanaLetterCell(
    letter: KanaLetter,
    scriptMode: ScriptMode,
    isSpeaking: Boolean,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1.0f,
        targetValue = 1.08f,
        animationSpec = infiniteRepeatable(
            animation = tween(400),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse_scale"
    )

    val borderColor by animateColorAsState(
        targetValue = if (isSpeaking) JapaneseCrimson else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.7f),
        label = "cell_border"
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (isSpeaking) JapaneseCrimson.copy(alpha = 0.16f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
        label = "cell_bg"
    )

    Surface(
        shape = RoundedCornerShape(12.dp),
        color = backgroundColor,
        border = BorderStroke(if (isSpeaking) 2.dp else 1.dp, borderColor),
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .scale(if (isSpeaking) pulseScale else 1.0f)
            .clip(RoundedCornerShape(12.dp))
            .combinedClickable(
                onClick = onClick,
                onLongClick = onLongClick
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(2.dp)
        ) {
            // Main Japanese Character(s)
            val characterText = when (scriptMode) {
                ScriptMode.HIRAGANA -> letter.hiragana
                ScriptMode.KATAKANA -> letter.katakana
                ScriptMode.BOTH -> "${letter.hiragana} ${letter.katakana}"
            }

            Text(
                text = characterText,
                fontSize = when (scriptMode) {
                    ScriptMode.BOTH -> if (letter.category == KanaCategory.YOON) 13.sp else 15.sp
                    else -> if (letter.category == KanaCategory.YOON) 18.sp else 21.sp
                },
                fontWeight = FontWeight.Bold,
                color = if (isSpeaking) JapaneseCrimson else MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            // Romaji
            Text(
                text = letter.romaji,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // Bangla Hint
            Text(
                text = letter.bnPron,
                fontSize = 10.5.sp,
                color = JapaneseIndigo,
                maxLines = 1
            )
        }
    }
}

@Composable
private fun KanaDetailContent(
    letter: KanaLetter,
    speechRate: Float,
    isSpeaking: Boolean,
    onPlayLetter: () -> Unit,
    onPlayExample: () -> Unit,
    onDismiss: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        // Top Letter Showcase
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Hiragana Box
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = JapaneseCrimson.copy(alpha = 0.1f),
                    border = BorderStroke(1.5.dp, JapaneseCrimson.copy(alpha = 0.4f)),
                    modifier = Modifier.size(68.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = letter.hiragana,
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                color = JapaneseCrimson
                            )
                            Text(text = "হিরাগানা", fontSize = 9.sp, color = JapaneseCrimson)
                        }
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Katakana Box
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = JapaneseIndigo.copy(alpha = 0.1f),
                    border = BorderStroke(1.5.dp, JapaneseIndigo.copy(alpha = 0.4f)),
                    modifier = Modifier.size(68.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = letter.katakana,
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                color = JapaneseIndigo
                            )
                            Text(text = "কাতাকানা", fontSize = 9.sp, color = JapaneseIndigo)
                        }
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = letter.romaji,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "বাংলা: ${letter.bnPron}",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = JapaneseIndigo
                    )
                }
            }

            // Big Speak Button
            IconButton(
                onClick = onPlayLetter,
                modifier = Modifier
                    .size(52.dp)
                    .background(JapaneseCrimson, CircleShape)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                    contentDescription = "Speak Letter",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // Pronunciation Tip (if available)
        letter.pronunciationTipBn?.let { tip ->
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.padding(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = tip,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Example Vocabulary Word
        letter.exampleWord?.let { word ->
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(14.dp)
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "বাস্তব শব্দের উদাহরণ:",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.outline
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Row(verticalAlignment = Alignment.Bottom) {
                            Text(
                                text = letter.exampleKanji ?: word,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            if (letter.exampleKanji != null) {
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "($word)",
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            letter.exampleRomaji?.let { romaji ->
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "[$romaji]",
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.outline
                                )
                            }
                        }
                        letter.exampleBn?.let { bn ->
                            Text(
                                text = "অর্থ: $bn",
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.Medium,
                                color = JapaneseIndigo
                            )
                        }
                    }

                    // Word Play Button
                    IconButton(
                        onClick = onPlayExample,
                        modifier = Modifier
                            .size(42.dp)
                            .background(JapaneseTeal.copy(alpha = 0.12f), CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                            contentDescription = "Speak Word",
                            tint = JapaneseTeal,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Close Button
        Button(
            onClick = onDismiss,
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "বন্ধ করুন",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

