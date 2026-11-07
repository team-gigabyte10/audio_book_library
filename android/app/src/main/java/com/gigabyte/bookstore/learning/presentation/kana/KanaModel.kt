package com.gigabyte.bookstore.learning.presentation.kana

enum class ScriptMode(val titleBn: String, val subtitleBn: String) {
    HIRAGANA("হিরাগানা (ひらがな)", "মূল জাপানি শব্দ ও ব্যাকরণে ব্যবহৃত"),
    KATAKANA("কাতাকানা (カタカナ)", "বিদেশি শব্দ ও বৈজ্ঞানিক পরিভাষায় ব্যবহৃত"),
    BOTH("উভয় লিপি (পাশাপাশি)", "হিরাগানা ও কাতাকানা একসাথে তুলনা")
}

enum class KanaCategory(val titleBn: String, val countLabel: String) {
    ALL("সম্পূর্ণ চার্ট", "১০৪ ধ্বনি"),
    GOJUON("মূল বর্ণ (Gojūon)", "৪৬টি বর্ণ"),
    DAKUTEN("ভয়েসড ধ্বনি (Dakuon)", "২৫টি বর্ণ"),
    YOON("যুক্তধ্বনি (Yōon)", "৩৩টি ধ্বনি")
}

data class KanaLetter(
    val id: String,
    val hiragana: String,
    val katakana: String,
    val romaji: String,
    val bnPron: String,
    val rowId: String,
    val category: KanaCategory,
    val exampleWord: String? = null,
    val exampleKanji: String? = null,
    val exampleRomaji: String? = null,
    val exampleBn: String? = null,
    val pronunciationTipBn: String? = null
)

data class KanaRow(
    val id: String,
    val nameBn: String,
    val nameTarget: String,
    val category: KanaCategory,
    /**
     * Columns for standard grid:
     * - Gojūon / Dakuon: 5 slots [a, i, u, e, o]
     * - Yōon: 3 slots [ya, yu, yo]
     * - Null represents unassigned grid positions (e.g. Yi, Ye)
     */
    val letters: List<KanaLetter?>
)

