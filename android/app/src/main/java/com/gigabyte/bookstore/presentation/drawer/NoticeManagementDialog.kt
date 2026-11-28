package com.gigabyte.bookstore.presentation.drawer

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PostAdd
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.data.models.AppNotice
import com.gigabyte.bookstore.presentation.home.HomeViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun NoticeManagementDialog(
    viewModel: HomeViewModel,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val allNotices by viewModel.allNotices.collectAsStateWithLifecycle()
    val isLoading by viewModel.isNoticeLoading.collectAsStateWithLifecycle()

    var selectedTabIndex by remember { mutableIntStateOf(0) } // 0: Post Notice, 1: Manage Notices
    var noticeToDelete by remember { mutableStateOf<AppNotice?>(null) }

    LaunchedEffect(Unit) {
        viewModel.loadAllNotices()
    }

    val accentColor = Color(0xFFD97706)

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.85f),
            shape = RoundedCornerShape(20.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 6.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Dialog Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = accentColor.copy(alpha = 0.15f),
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.Campaign,
                                    contentDescription = null,
                                    tint = accentColor,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                        Column {
                            Text(
                                text = "বিজ্ঞপ্তি পরিচালনা (Admin)",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "হোমপেজের মারকি নোটিশ পোস্ট ও নিয়ন্ত্রণ",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    IconButton(onClick = onDismiss, modifier = Modifier.size(36.dp)) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "বন্ধ করুন")
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Navigation Tabs
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                    contentColor = accentColor,
                    indicator = { tabPositions ->
                        TabRowDefaults.SecondaryIndicator(
                            modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                            color = accentColor,
                            height = 3.dp
                        )
                    },
                    modifier = Modifier.clip(RoundedCornerShape(10.dp))
                ) {
                    Tab(
                        selected = selectedTabIndex == 0,
                        onClick = { selectedTabIndex = 0 },
                        text = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(Icons.Default.PostAdd, contentDescription = null, modifier = Modifier.size(16.dp))
                                Text(text = "নতুন নোটিশ", fontWeight = FontWeight.Bold)
                            }
                        }
                    )
                    Tab(
                        selected = selectedTabIndex == 1,
                        onClick = {
                            selectedTabIndex = 1
                            viewModel.loadAllNotices()
                        },
                        text = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(Icons.Default.ViewList, contentDescription = null, modifier = Modifier.size(16.dp))
                                Text(text = "সব নোটিশ (${allNotices.size})", fontWeight = FontWeight.Bold)
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Tab Content
                if (selectedTabIndex == 0) {
                    PostNoticeForm(
                        isLoading = isLoading,
                        accentColor = accentColor,
                        onPublish = { title, message, url ->
                            viewModel.postNotice(title, message, url) { success, err ->
                                if (success) {
                                    Toast.makeText(context, "বিজ্ঞপ্তি সফলভাবে প্রকাশিত হয়েছে!", Toast.LENGTH_SHORT).show()
                                    selectedTabIndex = 1
                                } else {
                                    Toast.makeText(context, "ব্যর্থ হয়েছে: ${err ?: "অজানা ত্রুটি"}", Toast.LENGTH_LONG).show()
                                }
                            }
                        }
                    )
                } else {
                    ManageNoticesList(
                        notices = allNotices,
                        isLoading = isLoading,
                        accentColor = accentColor,
                        onRefresh = { viewModel.loadAllNotices() },
                        onToggleStatus = { notice ->
                            viewModel.toggleNoticeStatus(notice.id, notice.isActive)
                        },
                        onDeleteClick = { notice ->
                            noticeToDelete = notice
                        }
                    )
                }
            }
        }
    }

    // Delete Confirmation Dialog
    noticeToDelete?.let { notice ->
        AlertDialog(
            onDismissRequest = { noticeToDelete = null },
            title = { Text(text = "নোটিশ মুছে ফেলতে চান?", fontWeight = FontWeight.Bold) },
            text = { Text(text = "এই নোটিশটি স্থায়ীভাবে মুছে যাবে এবং হোমস্ক্রিনের মারকি থেকে সরিয়ে নেওয়া হবে।") },
            confirmButton = {
                Button(
                    onClick = {
                        val id = notice.id
                        noticeToDelete = null
                        viewModel.deleteNotice(id) { success ->
                            if (success) {
                                Toast.makeText(context, "নোটিশ মুছে ফেলা হয়েছে!", Toast.LENGTH_SHORT).show()
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF4444))
                ) {
                    Text(text = "মুছে ফেলুন", color = Color.White, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { noticeToDelete = null }) {
                    Text(text = "বাতিল")
                }
            }
        )
    }
}

@Composable
private fun PostNoticeForm(
    isLoading: Boolean,
    accentColor: Color,
    onPublish: (title: String, message: String, url: String?) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var actionUrl by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 4.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("নোটিশের শিরোনাম (Title)") },
            placeholder = { Text("যেমন: বিশেষ রমজান অফার বা নতুন বই আপডেট") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = accentColor,
                focusedLabelColor = accentColor
            )
        )

        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            label = { Text("বিজ্ঞপ্তির মূল বার্তা / মারকি টেক্সট *") },
            placeholder = { Text("এখানে যা লিখবেন তা হোমপেজের নোটিশ বারে চলমান স্ক্রোলিং আকারে দেখাবে...") },
            minLines = 4,
            maxLines = 6,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = accentColor,
                focusedLabelColor = accentColor
            )
        )

        OutlinedTextField(
            value = actionUrl,
            onValueChange = { actionUrl = it },
            label = { Text("অ্যাকশন লিংক (Action URL - ঐচ্ছিক)") },
            placeholder = { Text("যেমন: https://facebook.com/... বা কোনো লিংক") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = accentColor,
                focusedLabelColor = accentColor
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                if (message.isBlank()) return@Button
                onPublish(title, message, actionUrl.ifBlank { null })
            },
            enabled = message.isNotBlank() && !isLoading,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = accentColor,
                contentColor = Color.White
            )
        ) {
            if (isLoading) {
                CircularProgressIndicator(color = Color.White, modifier = Modifier.size(20.dp), strokeWidth = 2.dp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "পোস্ট হচ্ছে...", fontWeight = FontWeight.Bold)
            } else {
                Icon(imageVector = Icons.Default.Campaign, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "নোটিশ প্রকাশ করুন (Publish)", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }
        }
    }
}

@Composable
private fun ManageNoticesList(
    notices: List<AppNotice>,
    isLoading: Boolean,
    accentColor: Color,
    onRefresh: () -> Unit,
    onToggleStatus: (AppNotice) -> Unit,
    onDeleteClick: (AppNotice) -> Unit
) {
    if (isLoading && notices.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(color = accentColor)
        }
    } else if (notices.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "কোনো নোটিশ পাওয়া যায়নি!",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                OutlinedButton(onClick = onRefresh) {
                    Icon(imageVector = Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("রিফ্রেশ করুন")
                }
            }
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(notices, key = { it.id }) { notice ->
                NoticeItemCard(
                    notice = notice,
                    accentColor = accentColor,
                    onToggle = { onToggleStatus(notice) },
                    onDelete = { onDeleteClick(notice) }
                )
            }
        }
    }
}

@Composable
private fun NoticeItemCard(
    notice: AppNotice,
    accentColor: Color,
    onToggle: () -> Unit,
    onDelete: () -> Unit
) {
    val formattedDate = remember(notice.createdAt) {
        try {
            val sdf = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())
            sdf.format(Date(notice.createdAt))
        } catch (e: Exception) {
            ""
        }
    }

    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)
        ),
        border = BorderStroke(
            1.dp,
            if (notice.isActive) accentColor.copy(alpha = 0.5f) else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f)
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Header: Status badge & Switch
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = if (notice.isActive) Color(0xFF10B981).copy(alpha = 0.15f) else Color.Gray.copy(alpha = 0.15f)
                ) {
                    Text(
                        text = if (notice.isActive) "● সক্রিয় (হোমস্ক্রিনে চলছে)" else "○ নিষ্ক্রিয়",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = if (notice.isActive) Color(0xFF10B981) else Color.Gray,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Switch(
                        checked = notice.isActive,
                        onCheckedChange = { onToggle() },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = accentColor
                        ),
                        modifier = Modifier.size(36.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    IconButton(
                        onClick = onDelete,
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "মুছে ফেলুন",
                            tint = Color(0xFFEF4444),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }

            // Title
            if (notice.title.isNotBlank()) {
                Text(
                    text = notice.title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Message preview
            Text(
                text = notice.message,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 18.sp
            )

            // Date & Author
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = formattedDate,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                    fontSize = 11.sp
                )
                if (!notice.authorEmail.isNullOrBlank()) {
                    Text(
                        text = "দ্বারা: ${notice.authorEmail}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                        fontSize = 10.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}
