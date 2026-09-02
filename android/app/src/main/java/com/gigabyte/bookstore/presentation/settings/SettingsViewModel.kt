package com.gigabyte.bookstore.presentation.settings

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.preferences.AppPreferences
import com.gigabyte.bookstore.domain.tts.BanglaTTSManager
import com.gigabyte.bookstore.domain.tts.BanglaVoiceProfile
import com.gigabyte.bookstore.domain.tts.TTSVoiceStatus
import kotlinx.coroutines.flow.StateFlow

class SettingsViewModel(application: Application) : AndroidViewModel(application) {

    private val app = application as BanglaAudiobookApp
    private val preferences: AppPreferences = app.preferences
    val ttsManager: BanglaTTSManager = app.ttsManager

    val voiceStatus: StateFlow<TTSVoiceStatus> = ttsManager.voiceStatus
    val allVoices: StateFlow<List<BanglaVoiceProfile>> = ttsManager.allVoices
    val currentVoice: StateFlow<BanglaVoiceProfile> = ttsManager.currentVoice
    val isSamplePlaying: StateFlow<Boolean> = ttsManager.isSamplePlaying
    val speechRate: StateFlow<Float> = preferences.speechRate
    val speechPitch: StateFlow<Float> = preferences.speechPitch
    val autoPlayNext: StateFlow<Boolean> = preferences.autoPlayNext
    val keepScreenAwake: StateFlow<Boolean> = preferences.keepScreenAwake
    val fullAudiobookMode: StateFlow<Boolean> = preferences.fullAudiobookMode

    fun selectVoiceProfile(profile: BanglaVoiceProfile) {
        preferences.setSelectedVoiceId(profile.id)
        preferences.setSpeechPitch(profile.targetPitch)
        preferences.setSpeechRate(profile.targetSpeed)
        ttsManager.selectVoiceProfile(profile, applyPitchSpeed = true)
    }

    fun testVoiceSample(profile: BanglaVoiceProfile) {
        ttsManager.testVoiceSample(profile)
    }

    fun setSpeechRate(rate: Float) {
        preferences.setSpeechRate(rate)
        ttsManager.setSpeechRate(rate)
    }

    fun setSpeechPitch(pitch: Float) {
        preferences.setSpeechPitch(pitch)
        ttsManager.setPitch(pitch)
    }

    fun setAutoPlayNext(autoPlay: Boolean) {
        preferences.setAutoPlayNext(autoPlay)
    }

    fun setKeepScreenAwake(keepAwake: Boolean) {
        preferences.setKeepScreenAwake(keepAwake)
    }

    fun setFullAudiobookMode(isFull: Boolean) {
        preferences.setFullAudiobookMode(isFull)
    }

    fun testBanglaVoice() {
        ttsManager.testBanglaVoice()
    }

    fun openTtsSettings() {
        ttsManager.openTtsSettings()
    }

    fun reloadTts() {
        ttsManager.initializeTTS()
    }
}
