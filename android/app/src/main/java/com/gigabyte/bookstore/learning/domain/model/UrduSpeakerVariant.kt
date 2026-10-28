package com.gigabyte.bookstore.learning.domain.model

/**
 * Urdu plan decision 11.5: verbs and adjectives change with the speaker's gender (جاتا / جاتی).
 * tools/urdu/build_urdu_course.py stores the female version of an item in the example slot
 * (exampleTarget = female text, exampleBn = its Bangla sound hint).
 *
 * For a female speaker this swaps the two versions, so the female one is played and shown,
 * and the male one stays visible as the other form. Other items are returned unchanged.
 */
fun LessonItem.forUrduSpeaker(female: Boolean): LessonItem {
    val variant = exampleTarget?.trim()
    if (!female || !id.startsWith("ur-") || variant.isNullOrEmpty()) return this
    return copy(
        target = variant,
        bnPron = exampleBn ?: bnPron,
        tokens = femaleTokens(tokens, variant),
        exampleTarget = target,
        exampleBn = bnPron
    )
}

/**
 * Keeps each male token that is unchanged in [variant]; a changed token takes the same number
 * of words from [variant] and keeps its gloss, with the gender label switched.
 */
internal fun femaleTokens(maleTokens: List<Token>, variant: String): List<Token> {
    val result = mutableListOf<Token>()
    var rest = variant
    for (token in maleTokens) {
        rest = rest.trimStart()
        if (rest.isEmpty()) break
        if (rest.startsWith(token.text)) {
            result += token
            rest = rest.removePrefix(token.text)
        } else {
            val wordCount = token.text.trim().split(' ').size
            val piece = rest.split(' ').take(wordCount).joinToString(" ")
            result += Token(piece.trimEnd('۔', '؟', '!', '،'), token.bn?.replace("পুং", "স্ত্রী"))
            rest = rest.removePrefix(piece)
        }
    }
    val tail = rest.trim()
    if (tail.any { it.isLetter() }) result += Token(tail.trimEnd('۔', '؟', '!', '،'), null)
    return result
}
