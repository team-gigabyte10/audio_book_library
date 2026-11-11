package com.gigabyte.bookstore.learning.domain.translator

import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.gigabyte.bookstore.learning.domain.model.Token

enum class TranslatorLanguage(
    val key: String,
    val titleBn: String,
    val nativeName: String,
    val flag: String,
    val speechLang: SpeechLang,
    val sttLocaleTag: String,
    val isoCode: String,
    val itemIdPrefix: String,
    val isRtl: Boolean = false,
    val accentHex: Long = 0xFF1565C0
) {
    ENGLISH(
        key = "english",
        titleBn = "ইংরেজি",
        nativeName = "English",
        flag = "🇬🇧",
        speechLang = SpeechLang.EN,
        sttLocaleTag = "en-US",
        isoCode = "en",
        itemIdPrefix = "en-",
        accentHex = 0xFF1565C0
    ),
    JAPANESE(
        key = "japanese",
        titleBn = "জাপানি",
        nativeName = "日本語",
        flag = "🇯🇵",
        speechLang = SpeechLang.JA,
        sttLocaleTag = "ja-JP",
        isoCode = "ja",
        itemIdPrefix = "jp-",
        accentHex = 0xFFC62828
    ),
    URDU(
        key = "urdu",
        titleBn = "উর্দু",
        nativeName = "اردو",
        flag = "🇵🇰",
        speechLang = SpeechLang.UR,
        sttLocaleTag = "ur-PK",
        isoCode = "ur",
        itemIdPrefix = "ur-",
        isRtl = true,
        accentHex = 0xFF2E7D32
    ),
    HINDI(
        key = "hindi",
        titleBn = "হিন্দি",
        nativeName = "हिन्दी",
        flag = "🇮🇳",
        speechLang = SpeechLang.HI,
        sttLocaleTag = "hi-IN",
        isoCode = "hi",
        itemIdPrefix = "hi-",
        accentHex = 0xFFE65100
    ),
    GERMAN(
        key = "german",
        titleBn = "জার্মান",
        nativeName = "Deutsch",
        flag = "🇩🇪",
        speechLang = SpeechLang.DE,
        sttLocaleTag = "de-DE",
        isoCode = "de",
        itemIdPrefix = "de-",
        accentHex = 0xFF37474F
    ),
    ARABIC(
        key = "arabic",
        titleBn = "আরবি",
        nativeName = "العربية",
        flag = "🕌",
        speechLang = SpeechLang.AR,
        sttLocaleTag = "ar-SA",
        isoCode = "ar",
        itemIdPrefix = "qr-",
        isRtl = true,
        accentHex = 0xFF1B5E20
    ),
    REGIONAL_BANGLA(
        key = "regional",
        titleBn = "আঞ্চলিক বাংলা",
        nativeName = "বাংলাদেশের ৯ অঞ্চল",
        flag = "🇧🇩",
        speechLang = SpeechLang.BD,
        sttLocaleTag = "bn-BD",
        isoCode = "bn",
        itemIdPrefix = "bd-",
        accentHex = 0xFF006A4E
    );

    companion object {
        fun fromKey(raw: String?): TranslatorLanguage {
            val v = raw?.trim()?.lowercase().orEmpty()
            return when {
                v.startsWith("jp") || v.startsWith("ja") || v == "japanese" -> JAPANESE
                v.startsWith("ur") || v == "urdu" -> URDU
                v.startsWith("hi") || v == "hindi" -> HINDI
                v.startsWith("de") || v == "german" -> GERMAN
                v.startsWith("qr") || v.startsWith("ar") || v == "quran" || v == "arabic" -> ARABIC
                v.startsWith("bd") || v.contains("regional") -> REGIONAL_BANGLA
                else -> ENGLISH
            }
        }
    }
}

enum class RegionalDialectChoice(val key: String, val labelBn: String, val speakerQuery: String) {
    CTG("ctg", "চট্টগ্রাম (চাটগাঁইয়া)", "চট্টগ্রাম"),
    NOA("noa", "নোয়াখালী", "নোয়াখালী"),
    SYL("syl", "সিলেট (সিলেটি)", "সিলেট"),
    DHK("dhk", "পুরান ঢাকা", "ঢাকা"),
    BAR("bar", "বরিশাল", "বরিশাল"),
    RAJ("raj", "রাজশাহী (বরেন্দ্রী)", "রাজশাহী"),
    RNG("rng", "রংপুর (রংপুরিয়া)", "রংপুর"),
    KHL("khl", "খুলনা-যশোর", "খুলনা"),
    MYM("mym", "ময়মনসিংহ", "ময়মনসিংহ");

    companion object {
        fun fromKey(raw: String?): RegionalDialectChoice =
            entries.firstOrNull { it.key.equals(raw, ignoreCase = true) } ?: CTG
    }
}

enum class TranslatorDirection {
    BN_TO_TARGET,
    TARGET_TO_BN
}

enum class TranslationSourceTier(val badgeBn: String) {
    OFFLINE_CURRICULUM("📚 কোর্স অফলাইন"),
    AI_TUTOR("✨ AI শিক্ষক"),
    WEB_FALLBACK("🌐 লাইভ অনুবাদ")
}

data class TranslationResult(
    val sourceText: String,
    val targetText: String,
    val banglaPronunciation: String? = null,
    val romanization: String? = null,
    val wordBreakdown: List<Token> = emptyList(),
    val grammarTipBn: String? = null,
    val languageKey: String,
    val dialectKey: String? = null,
    val direction: TranslatorDirection = TranslatorDirection.BN_TO_TARGET,
    val sourceTier: TranslationSourceTier = TranslationSourceTier.AI_TUTOR,
    val timestampMs: Long = System.currentTimeMillis()
)

