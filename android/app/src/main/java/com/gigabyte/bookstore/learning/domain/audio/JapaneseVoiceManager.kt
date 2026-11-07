package com.gigabyte.bookstore.learning.domain.audio

import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.speech.tts.TextToSpeech
import android.speech.tts.Voice
import java.util.Locale

enum class JapaneseVoiceGender(val id: String, val titleBn: String, val icon: String) {
    FEMALE("female", "স্পষ্ট নারী কণ্ঠ", "👩"),
    MALE("male", "স্পষ্ট পুরুষ কণ্ঠ", "👨"),
    AUTO("auto", "স্বয়ংক্রিয় সেরা কণ্ঠ", "🌟");

    companion object {
        fun fromId(id: String?): JapaneseVoiceGender {
            return entries.firstOrNull { it.id.equals(id, ignoreCase = true) } ?: FEMALE
        }
    }
}

object JapaneseVoiceManager {

    /**
     * Creates standard speech-optimized audio attributes for clearer vocal delivery.
     */
    fun createAudioAttributes(): AudioAttributes {
        return AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_ASSISTANCE_ACCESSIBILITY)
            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
            .build()
    }

    /**
     * Resolves the best available Japanese voice on the device based on the user's selected gender.
     */
    fun selectBestVoice(tts: TextToSpeech, gender: JapaneseVoiceGender): Voice? {
        val voices = runCatching { tts.voices.orEmpty() }.getOrDefault(emptySet())
        val jaVoices = voices.filter { it.locale.language == Locale.JAPANESE.language }
        if (jaVoices.isEmpty()) return null

        // Exclude voices explicitly marked as not installed
        val installedVoices = jaVoices.filterNot {
            it.features.orEmpty().contains(TextToSpeech.Engine.KEY_FEATURE_NOT_INSTALLED)
        }
        val candidatePool = if (installedVoices.isNotEmpty()) installedVoices else jaVoices

        return when (gender) {
            JapaneseVoiceGender.FEMALE -> {
                candidatePool.filter { isFemaleVoice(it) }
                    .maxByOrNull { rateVoiceClarity(it) }
                    ?: candidatePool.firstOrNull()
            }
            JapaneseVoiceGender.MALE -> {
                candidatePool.filter { isMaleVoice(it) }
                    .maxByOrNull { rateVoiceClarity(it) }
                    ?: candidatePool.firstOrNull()
            }
            JapaneseVoiceGender.AUTO -> {
                candidatePool.maxByOrNull { rateVoiceClarity(it) } ?: candidatePool.firstOrNull()
            }
        }
    }

    fun isFemaleVoice(voice: Voice): Boolean {
        val name = voice.name.lowercase(Locale.ROOT)
        val features = voice.features.orEmpty().map { it.lowercase(Locale.ROOT) }
        if (features.any { it.contains("gender=female") || it.contains("female") }) return true
        if (features.any { it.contains("gender=male") || it.contains("male") }) return false
        if (name.contains("female") || name.contains("woman")) return true
        if (name.contains("male") || name.contains("man")) return false
        // Google TTS Japanese voices:
        // htm, jab, jaf, cdn, rcb are female voices
        // jad, gce, jac, tda are male voices
        if (name.contains("htm") || name.contains("jab") || name.contains("jaf") || name.contains("cdn") || name.contains("rcb")) return true
        if (name.contains("jad") || name.contains("gce") || name.contains("jac") || name.contains("tda")) return false
        return true // Default fallback for Japanese TTS is typically female
    }

    fun isMaleVoice(voice: Voice): Boolean {
        val name = voice.name.lowercase(Locale.ROOT)
        val features = voice.features.orEmpty().map { it.lowercase(Locale.ROOT) }
        if (features.any { it.contains("gender=male") || it.contains("male") }) return true
        if (features.any { it.contains("gender=female") || it.contains("female") }) return false
        if (name.contains("male") || name.contains("man")) return true
        if (name.contains("female") || name.contains("woman")) return false
        if (name.contains("jad") || name.contains("gce") || name.contains("jac") || name.contains("tda")) return true
        return false
    }

    private fun rateVoiceClarity(voice: Voice): Int {
        var score = voice.quality
        // Installed offline voices are dependable
        if (!voice.isNetworkConnectionRequired) score += 30
        val name = voice.name.lowercase(Locale.ROOT)
        // High-definition neural/wavenet voices have higher clarity
        if (name.contains("network") || name.contains("wavenet") || name.contains("neural")) score += 60
        // Well-tuned Google TTS voice models for Japanese
        if (name.contains("htm") || name.contains("jad") || name.contains("jab")) score += 40
        return score
    }

    /**
     * Pitch optimized for speech clarity:
     * Female voice: 0.97f removes sibilant/tinny high-frequency distortion and adds vocal body.
     * Male voice: 1.00f delivers a natural, rich baritone.
     */
    fun getOptimizedPitch(gender: JapaneseVoiceGender): Float {
        return when (gender) {
            JapaneseVoiceGender.FEMALE -> 0.97f
            JapaneseVoiceGender.MALE -> 1.00f
            JapaneseVoiceGender.AUTO -> 0.98f
        }
    }

    /**
     * Prevents abrupt TTS truncation on single Kana characters (e.g. "あ", "つ", "き")
     * by appending Japanese punctuation touten ('、'), allowing natural citation mora decay.
     */
    fun formatForClearPronunciation(text: String): String {
        val trimmed = text.trim()
        if (trimmed.isEmpty()) return trimmed
        return if (trimmed.length <= 2 && !trimmed.endsWith("、") && !trimmed.endsWith("。")) {
            "$trimmed、"
        } else {
            trimmed
        }
    }

    /**
     * Intent to open Android Text-to-Speech settings so users can download Google's High Quality Japanese Voice data.
     */
    fun createTtsSettingsIntent(): Intent {
        val intent = Intent("com.android.settings.TTS_SETTINGS")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        return intent
    }

    fun createInstallVoiceIntent(): Intent {
        val intent = Intent(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        return intent
    }

    fun openDeviceTtsSettings(context: Context) {
        val ttsIntent = createTtsSettingsIntent()
        val success = runCatching { context.startActivity(ttsIntent) }.isSuccess
        if (!success) {
            val installIntent = createInstallVoiceIntent()
            runCatching { context.startActivity(installIntent) }
        }
    }
}

