package com.gigabyte.bookstore.domain.tts

enum class VoiceTone {
    SYSTEM_ENGINE,      // অ্যান্ড্রয়েড সিস্টেম ভয়েস (Direct System Voice from Engine)
    REAL_HUMAN_HD,      // রিয়েল হিউম্যান এইচডি (Natural real system voice)
    FEMALE_SYSTEM,      // নারীকণ্ঠ (Female System Voice)
    MALE_SYSTEM         // পুরুষকণ্ঠ (Male System Voice)
}

data class BanglaVoiceProfile(
    val id: String,
    val nameBangla: String,
    val subtitleBangla: String,
    val description: String,
    val tone: VoiceTone,
    val targetPitch: Float,
    val targetSpeed: Float,
    val systemVoiceName: String? = null,
    val systemLocaleTag: String? = null,
    val tag: String = "সিস্টেম ভয়েস",
    val sampleText: String = "আমি অ্যান্ড্রয়েড সিস্টেমের সরাসরি বাংলা কণ্ঠস্বর।"
)

object BanglaVoicePresets {
    val DEFAULT_SYSTEM_VOICE = BanglaVoiceProfile(
        id = "sys_default",
        nameBangla = "ডিফল্ট সিস্টেম ভয়েস (Default Real System Voice)",
        subtitleBangla = "অ্যান্ড্রয়েড সিস্টেমের সরাসরি বাচিক কণ্ঠ",
        description = "অ্যান্ড্রয়েড টেক্সট-টু-স্পিচ ইঞ্জিনের সরাসরি সিস্টেম ভয়েস।",
        tone = VoiceTone.SYSTEM_ENGINE,
        targetPitch = 1.00f,
        targetSpeed = 1.00f,
        tag = "সিস্টেম ভয়েস",
        sampleText = "আমি অ্যান্ড্রয়েড সিস্টেমের সরাসরি বাংলা কণ্ঠস্বর।"
    )

    val PRESETS = listOf(DEFAULT_SYSTEM_VOICE)

    fun getPresetById(id: String): BanglaVoiceProfile {
        return PRESETS.firstOrNull { it.id == id } ?: DEFAULT_SYSTEM_VOICE
    }
}
