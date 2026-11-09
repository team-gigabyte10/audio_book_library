package com.gigabyte.bookstore.learning.presentation.vocab

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

enum class VocabCategory(val id: String, val titleBn: String, val iconEmoji: String) {
    ALL("all", "সব একসাথে", "🌟"),
    FAMILY("family", "পরিবার ও মানুষ", "👨‍👩‍👧‍👦"),
    BODY("body", "শরীর ও স্বাস্থ্য", "🩺"),
    FOOD("food", "খাবার ও পানীয়", "🍲"),
    FRUITS("fruits", "ফল ও শাকসবজি", "🍎"),
    HOME("home", "বাড়ি ও আসবাবপত্র", "🏠"),
    CLOTHES("clothes", "পোশাক ও পরিধান", "👕"),
    PLACES("places", "শহর ও স্থান", "🏙️"),
    TRAVEL("travel", "ভ্রমণ ও যাতায়াত", "✈️"),
    EDUCATION("education", "শিক্ষা ও পড়াশোনা", "📚"),
    WORK("work", "পেশা ও জীবিকা", "💼"),
    NATURE("nature", "প্রকৃতি ও আবহাওয়া", "🌳"),
    ANIMALS("animals", "পশুপাখি ও প্রাণী", "🐾"),
    ACTIONS("actions", "দৈনন্দিন কাজ (Verbs)", "🏃"),
    EMOTIONS("emotions", "অনুভূতি ও অবস্থা", "😊"),
    ADJECTIVES("adjectives", "বিশেষণ ও বিপরীত", "⚖️"),
    COLORS("colors", "রং ও আকার", "🎨"),
    KITCHEN("kitchen", "রান্নাঘর ও তৈজসপত্র", "🍳"),
    SHOPPING("shopping", "কেনাকাটা ও অর্থ", "🛒"),
    TECH("tech", "যোগাযোগ ও প্রযুক্তি", "📱"),
    EMERGENCY("emergency", "জরুরি ও প্রয়োজনীয়", "🚨")
}

enum class GrammaticalGender(val id: String, val labelBn: String, val badgeColorHex: Long) {
    MASCULINE("m", "পুংলিঙ্গ", 0xFF1565C0),   // Blue
    FEMININE("f", "স্ত্রীলিঙ্গ", 0xFFC2185B),   // Rose/Pink
    NEUTER("n", "ক্লীবলিঙ্গ", 0xFF2E7D32),       // Green
    COMMON("c", "উভয়লিঙ্গ", 0xFF6A1B9A),       // Purple
    NONE("none", "", 0x00000000)
}

data class VocabItem(
    val id: String,
    val category: VocabCategory,
    // Singular Form (একবচন)
    val singularTarget: String,
    val singularBnPron: String,
    val singularSecondary: String? = null, // e.g. Hiragana reading for Japanese Kanji
    // Plural Form (বহুবচন)
    val pluralTarget: String? = null,
    val pluralBnPron: String? = null,
    val pluralSecondary: String? = null,
    // Meaning
    val bnMeaning: String,
    // Grammar & Attributes
    val gender: GrammaticalGender = GrammaticalGender.NONE,
    val germanArticleSingular: String? = null, // "der", "die", "das"
    val germanArticlePlural: String? = null,   // "die"
    val noteBn: String? = null
)

data class VocabLanguageConfig(
    val langCode: String,
    val speechLang: SpeechLang,
    val titleBn: String,
    val subtitleBn: String,
    val nativeTitle: String,
    val accentColorHex: Long,
    val items: List<VocabItem>
)
