package com.gigabyte.bookstore.learning.domain.audio

import android.content.Context
import android.content.Intent
import android.speech.tts.TextToSpeech
import android.speech.tts.Voice
import java.util.Locale

/**
 * Verified Male Qari reciters supported for real Quranic Ayah recitation (Tilawat).
 */
enum class QuranReciter(
    val id: String,
    val titleBn: String,
    val subtitleBn: String,
    val everyAyahFolder: String
) {
    HUSARY_MUALLIM(
        id = "husary_muallim",
        titleBn = "শেখ আল-হুসারী (মুয়াল্লিম)",
        subtitleBn = "শিক্ষার্থীদের জন্য ধীরস্থির ও স্পষ্ট তাজবীদ তিলাওয়াত",
        everyAyahFolder = "Husary_Muallim_128kbps"
    ),
    ALAFASY(
        id = "alafasy",
        titleBn = "শেখ মিশারি আল-আফাসি",
        subtitleBn = "সুমধুর ও হৃদয়স্পর্শী মুরাত্তাল তিলাওয়াত",
        everyAyahFolder = "Alafasy_128kbps"
    );

    companion object {
        fun fromId(id: String?): QuranReciter =
            entries.firstOrNull { it.id.equals(id, ignoreCase = true) } ?: HUSARY_MUALLIM
    }
}

enum class VoiceGenderClass {
    MALE,
    FEMALE,
    NEUTRAL
}

data class MaleVoiceSelection(
    val voice: Voice?,
    val isVerifiedMale: Boolean
)

/**
 * Enforces Male-only Qari/Ustad voice selection and deep baritone pitch calibration
 * strictly for "সহজে কুরআন শিক্ষা" (`qr-*`) lessons without affecting other courses.
 */
object QuranVoiceManager {

    private val KNOWN_AR_MALE_TOKENS = listOf(
        "ar-xa-x-arc", "ar-xa-x-ard", "ar-xa-x-arm",
        "ar-sa-x-arc", "ar-sa-x-ard", "-arc-", "-ard-", "-arm-"
    )

    private val KNOWN_AR_FEMALE_TOKENS = listOf(
        "ar-xa-x-arz", "ar-xa-x-are", "ar-xa-x-ari",
        "ar-sa-x-arz", "ar-sa-x-are", "-arz-", "-are-", "-ari-"
    )

    fun classifyArabicVoiceGender(voiceName: String, features: Collection<String>): VoiceGenderClass {
        val name = voiceName.lowercase(Locale.ROOT)
        val featList = features.map { it.lowercase(Locale.ROOT) }

        if (featList.any { it.contains("gender=male") || it == "male" }) return VoiceGenderClass.MALE
        if (featList.any { it.contains("gender=female") || it == "female" }) return VoiceGenderClass.FEMALE

        if (name.contains("female") || name.contains("woman") || name.contains("-f-")) return VoiceGenderClass.FEMALE
        if (name.contains("male") || name.contains("man") || name.contains("-m-")) return VoiceGenderClass.MALE

        if (KNOWN_AR_MALE_TOKENS.any { name.contains(it) }) return VoiceGenderClass.MALE
        if (KNOWN_AR_FEMALE_TOKENS.any { name.contains(it) }) return VoiceGenderClass.FEMALE

        return VoiceGenderClass.NEUTRAL
    }

    fun classifyBanglaVoiceGender(voiceName: String, features: Collection<String>): VoiceGenderClass {
        val name = voiceName.lowercase(Locale.ROOT)
        val featList = features.map { it.lowercase(Locale.ROOT) }

        if (featList.any { it.contains("gender=male") || it == "male" }) return VoiceGenderClass.MALE
        if (featList.any { it.contains("gender=female") || it == "female" }) return VoiceGenderClass.FEMALE

        if (name.contains("female") || name.contains("fem") || name.contains("woman") || name.contains("-f-") || name.contains("bnf")) {
            return VoiceGenderClass.FEMALE
        }
        if (name.contains("male") || name.contains("man") || name.contains("-m-") || name.contains("bnm")) {
            return VoiceGenderClass.MALE
        }

        return VoiceGenderClass.NEUTRAL
    }

    fun selectMaleArabicVoice(tts: TextToSpeech): MaleVoiceSelection {
        val voices = runCatching { tts.voices.orEmpty() }.getOrDefault(emptySet())
        val arVoices = voices.filter { it.locale?.language.equals("ar", ignoreCase = true) }
        if (arVoices.isEmpty()) return MaleVoiceSelection(null, isVerifiedMale = false)

        val installed = arVoices.filterNot {
            it.features.orEmpty().contains(TextToSpeech.Engine.KEY_FEATURE_NOT_INSTALLED)
        }
        val pool = if (installed.isNotEmpty()) installed else arVoices

        val verifiedMales = pool.filter {
            classifyArabicVoiceGender(it.name, it.features.orEmpty()) == VoiceGenderClass.MALE
        }
        if (verifiedMales.isNotEmpty()) {
            val best = verifiedMales.maxByOrNull { rateVoiceClarity(it) }
            return MaleVoiceSelection(best, isVerifiedMale = true)
        }

        val neutrals = pool.filter {
            classifyArabicVoiceGender(it.name, it.features.orEmpty()) == VoiceGenderClass.NEUTRAL
        }
        if (neutrals.isNotEmpty()) {
            val best = neutrals.maxByOrNull { rateVoiceClarity(it) }
            return MaleVoiceSelection(best, isVerifiedMale = false)
        }

        // Last resort when device only has female Arabic TTS voices: pick clearest & rely on pitch shift.
        val fallback = pool.maxByOrNull { rateVoiceClarity(it) }
        return MaleVoiceSelection(fallback, isVerifiedMale = false)
    }

    fun selectMaleBanglaVoice(tts: TextToSpeech): MaleVoiceSelection {
        val voices = runCatching { tts.voices.orEmpty() }.getOrDefault(emptySet())
        val bnVoices = voices.filter { it.locale?.language.equals("bn", ignoreCase = true) }
        if (bnVoices.isEmpty()) return MaleVoiceSelection(null, isVerifiedMale = false)

        val installed = bnVoices.filterNot {
            it.features.orEmpty().contains(TextToSpeech.Engine.KEY_FEATURE_NOT_INSTALLED)
        }
        val pool = if (installed.isNotEmpty()) installed else bnVoices

        val verifiedMales = pool.filter {
            classifyBanglaVoiceGender(it.name, it.features.orEmpty()) == VoiceGenderClass.MALE
        }
        if (verifiedMales.isNotEmpty()) {
            return MaleVoiceSelection(verifiedMales.maxByOrNull { rateVoiceClarity(it) }, isVerifiedMale = true)
        }

        val neutrals = pool.filter {
            classifyBanglaVoiceGender(it.name, it.features.orEmpty()) == VoiceGenderClass.NEUTRAL
        }
        if (neutrals.isNotEmpty()) {
            return MaleVoiceSelection(neutrals.maxByOrNull { rateVoiceClarity(it) }, isVerifiedMale = false)
        }

        return MaleVoiceSelection(pool.maxByOrNull { rateVoiceClarity(it) }, isVerifiedMale = false)
    }

    private fun rateVoiceClarity(voice: Voice): Int {
        var score = voice.quality
        if (!voice.isNetworkConnectionRequired) score += 30
        val name = voice.name.lowercase(Locale.ROOT)
        if (name.contains("network") || name.contains("wavenet") || name.contains("neural") || name.contains("hd")) {
            score += 60
        }
        if (voice.locale?.country.equals("SA", ignoreCase = true)) {
            score += 20
        }
        return score
    }

    /**
     * Deep, calm baritone pitch suited for Quranic Qari & Ustad delivery.
     * Verified male voices get a subtle warm drop (0.90f); fallback/unlabeled voices
     * receive deeper pitch compensation (0.76f) so they sound masculine rather than soprano.
     */
    fun getArabicQariPitch(isVerifiedMale: Boolean): Float =
        if (isVerifiedMale) 0.90f else 0.76f

    fun getBanglaInstructorPitch(isVerifiedMale: Boolean): Float =
        if (isVerifiedMale) 0.94f else 0.80f

    fun openDeviceTtsSettings(context: Context) {
        val ttsIntent = Intent("com.android.settings.TTS_SETTINGS").apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        val ok = runCatching { context.startActivity(ttsIntent) }.isSuccess
        if (!ok) {
            val installIntent = Intent(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            runCatching { context.startActivity(installIntent) }
        }
    }
}
