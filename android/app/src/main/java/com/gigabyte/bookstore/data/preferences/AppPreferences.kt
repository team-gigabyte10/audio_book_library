package com.gigabyte.bookstore.data.preferences

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppPreferences(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("bangla_audiobook_prefs", Context.MODE_PRIVATE)

    private val _speechRate = MutableStateFlow(prefs.getFloat(KEY_SPEECH_RATE, 1.0f))
    val speechRate: StateFlow<Float> = _speechRate.asStateFlow()

    private val _speechPitch = MutableStateFlow(prefs.getFloat(KEY_SPEECH_PITCH, 1.0f))
    val speechPitch: StateFlow<Float> = _speechPitch.asStateFlow()

    private val _autoPlayNext = MutableStateFlow(prefs.getBoolean(KEY_AUTO_PLAY_NEXT, true))
    val autoPlayNext: StateFlow<Boolean> = _autoPlayNext.asStateFlow()

    private val _keepScreenAwake = MutableStateFlow(prefs.getBoolean(KEY_KEEP_SCREEN_AWAKE, false))
    val keepScreenAwake: StateFlow<Boolean> = _keepScreenAwake.asStateFlow()

    private val _fullAudiobookMode = MutableStateFlow(prefs.getBoolean(KEY_FULL_AUDIOBOOK_MODE, true))
    val fullAudiobookMode: StateFlow<Boolean> = _fullAudiobookMode.asStateFlow()

    private val _readerFontSize = MutableStateFlow(prefs.getInt(KEY_READER_FONT_SIZE, 18))
    val readerFontSize: StateFlow<Int> = _readerFontSize.asStateFlow()

    private val _selectedVoiceId = MutableStateFlow(prefs.getString(KEY_SELECTED_VOICE_ID, "voice_natural_clear") ?: "voice_natural_clear")
    val selectedVoiceId: StateFlow<String> = _selectedVoiceId.asStateFlow()

    fun setSpeechRate(rate: Float) {
        prefs.edit().putFloat(KEY_SPEECH_RATE, rate).apply()
        _speechRate.value = rate
    }

    fun setSpeechPitch(pitch: Float) {
        prefs.edit().putFloat(KEY_SPEECH_PITCH, pitch).apply()
        _speechPitch.value = pitch
    }

    fun setSelectedVoiceId(voiceId: String) {
        prefs.edit().putString(KEY_SELECTED_VOICE_ID, voiceId).apply()
        _selectedVoiceId.value = voiceId
    }

    fun setAutoPlayNext(autoPlay: Boolean) {
        prefs.edit().putBoolean(KEY_AUTO_PLAY_NEXT, autoPlay).apply()
        _autoPlayNext.value = autoPlay
    }

    fun setKeepScreenAwake(keepAwake: Boolean) {
        prefs.edit().putBoolean(KEY_KEEP_SCREEN_AWAKE, keepAwake).apply()
        _keepScreenAwake.value = keepAwake
    }

    fun setFullAudiobookMode(isFull: Boolean) {
        prefs.edit().putBoolean(KEY_FULL_AUDIOBOOK_MODE, isFull).apply()
        _fullAudiobookMode.value = isFull
    }

    fun setReaderFontSize(size: Int) {
        prefs.edit().putInt(KEY_READER_FONT_SIZE, size).apply()
        _readerFontSize.value = size
    }

    companion object {
        private const val KEY_SPEECH_RATE = "speech_rate"
        private const val KEY_SPEECH_PITCH = "speech_pitch"
        private const val KEY_AUTO_PLAY_NEXT = "auto_play_next"
        private const val KEY_KEEP_SCREEN_AWAKE = "keep_screen_awake"
        private const val KEY_FULL_AUDIOBOOK_MODE = "full_audiobook_mode"
        private const val KEY_READER_FONT_SIZE = "reader_font_size"
        private const val KEY_SELECTED_VOICE_ID = "selected_voice_id"
    }
}
