package com.gigabyte.bookstore.domain.tts

import java.util.Locale

sealed class TTSVoiceStatus {
    object Checking : TTSVoiceStatus()
    data class Available(
        val engineName: String,
        val enginePackage: String,
        val locale: Locale,
        val availableEngines: List<String> = emptyList()
    ) : TTSVoiceStatus()
    data class Unavailable(
        val reason: String,
        val currentEngine: String? = null,
        val availableEngines: List<String> = emptyList()
    ) : TTSVoiceStatus()
    data class Error(val message: String) : TTSVoiceStatus()
}
