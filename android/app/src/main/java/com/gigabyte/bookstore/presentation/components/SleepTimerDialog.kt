package com.gigabyte.bookstore.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gigabyte.bookstore.domain.player.SleepTimerOption

@Composable
fun SleepTimerDialog(
    currentMinutesRemaining: Int?,
    onOptionSelected: (SleepTimerOption) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        icon = {
            Icon(
                imageVector = Icons.Default.Bedtime,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        },
        title = {
            Text(
                text = "ঘুমের টাইমার (Sleep Timer)",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                SleepTimerOption.values().forEach { option ->
                    val isSelected = when (option) {
                        SleepTimerOption.OFF -> currentMinutesRemaining == null
                        SleepTimerOption.END_OF_CHAPTER -> currentMinutesRemaining == -1
                        else -> currentMinutesRemaining != null && currentMinutesRemaining > 0
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                onOptionSelected(option)
                                onDismiss()
                            }
                            .padding(vertical = 10.dp, horizontal = 8.dp)
                            .testTag("sleep_timer_option_${option.name}"),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = isSelected,
                            onClick = {
                                onOptionSelected(option)
                                onDismiss()
                            }
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = option.titleBn,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("বাতিল")
            }
        }
    )
}
