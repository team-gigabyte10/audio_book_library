package com.gigabyte.bookstore.learning.domain.speech

/**
 * Compares what the speech recognizer heard with the Japanese target (plan §11.4).
 * Feedback only: the result never blocks progress.
 */
object JapaneseSpeechMatch {

    enum class Result { MATCH, NEAR, NO_MATCH }

    private const val NEAR_THRESHOLD = 0.6

    /**
     * [heard] is the recognizer's list of guesses, best first.
     * [expected] holds every accepted written form (for example the kanji target and its kana reading).
     */
    fun evaluate(heard: List<String>, expected: List<String>): Result {
        val targets = expected.map(::normalize).filter { it.isNotEmpty() }
        val guesses = heard.map(::normalize).filter { it.isNotEmpty() }
        if (targets.isEmpty() || guesses.isEmpty()) return Result.NO_MATCH

        var best = 0.0
        for (guess in guesses) {
            for (target in targets) {
                if (guess == target || guess.contains(target)) return Result.MATCH
                best = maxOf(best, similarity(guess, target))
            }
        }
        return if (best >= NEAR_THRESHOLD) Result.NEAR else Result.NO_MATCH
    }

    /** Drops spaces and punctuation, and writes katakana as hiragana so ネコ and ねこ compare equal. */
    fun normalize(text: String): String = buildString {
        for (c in text) {
            when {
                c.isWhitespace() -> Unit
                c in PUNCTUATION -> Unit
                c in 'ァ'..'ヶ' -> append(c - 0x60)
                else -> append(c.lowercaseChar())
            }
        }
    }

    fun isKanaOnly(text: String): Boolean {
        val letters = normalize(text)
        return letters.isNotEmpty() && letters.all { it in 'ぁ'..'ゟ' || it == 'ー' }
    }

    private fun similarity(a: String, b: String): Double {
        val longest = maxOf(a.length, b.length)
        return if (longest == 0) 1.0 else 1.0 - editDistance(a, b).toDouble() / longest
    }

    private fun editDistance(a: String, b: String): Int {
        var previous = IntArray(b.length + 1) { it }
        for (i in 1..a.length) {
            val current = IntArray(b.length + 1)
            current[0] = i
            for (j in 1..b.length) {
                val cost = if (a[i - 1] == b[j - 1]) 0 else 1
                current[j] = minOf(previous[j] + 1, current[j - 1] + 1, previous[j - 1] + cost)
            }
            previous = current
        }
        return previous[b.length]
    }

    private const val PUNCTUATION = "。、．，,.!！?？「」『』・〜~…―-"
}
