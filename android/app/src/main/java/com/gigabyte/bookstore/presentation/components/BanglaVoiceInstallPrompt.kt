package com.gigabyte.bookstore.presentation.components

import android.content.Intent
import android.speech.tts.TextToSpeech
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.domain.tts.TTSVoiceStatus

/**
 * Asks the user to install a Bangla TTS voice every time the app opens while none is installed.
 * "Opens" = a new app process (cold start): rotation and returning from the background don't ask again.
 * There is deliberately no "don't ask again" option.
 */
@Composable
fun BanglaVoiceInstallPrompt() {
    val context = LocalContext.current
    val app = context.applicationContext as BanglaAudiobookApp
    val voiceStatus by app.ttsManager.voiceStatus.collectAsStateWithLifecycle()
    var visible by rememberSaveable { mutableStateOf(false) }
    var waitingForInstall by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(voiceStatus) {
        if (voiceStatus is TTSVoiceStatus.Unavailable && !app.banglaVoicePromptHandled) {
            app.banglaVoicePromptHandled = true
            visible = true
        }
    }

    // Back from the install screen: re-check so Bangla speech turns on without restarting the app.
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner, waitingForInstall) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME && waitingForInstall) {
                waitingForInstall = false
                app.ttsManager.initializeTTS()
                app.refreshLessonBanglaVoice()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    if (visible) {
        AlertDialog(
            onDismissRequest = { visible = false },
            title = { Text("বাংলা ভয়েস ইনস্টল করুন") },
            text = {
                Text(
                    "আপনার ফোনে বাংলা Text-to-speech ভয়েস নেই। বাংলা অডিওবুক ও ইংরেজি লেসনের বাংলা অর্থ শুনতে " +
                        "বাংলা ভয়েস ইনস্টল করুন। সবচেয়ে ভালো ফল পেতে Google \"Speech Services\" ব্যবহার করুন।"
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    visible = false
                    waitingForInstall = true
                    val opened = runCatching {
                        context.startActivity(
                            Intent(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        )
                    }.isSuccess
                    if (!opened) app.ttsManager.openTtsSettings()
                }) { Text("ইনস্টল করুন") }
            },
            dismissButton = {
                TextButton(onClick = { visible = false }) { Text("এখন না") }
            }
        )
    }
}
