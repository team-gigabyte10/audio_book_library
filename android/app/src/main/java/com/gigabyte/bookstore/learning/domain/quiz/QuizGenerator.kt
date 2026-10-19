package com.gigabyte.bookstore.learning.domain.quiz

import com.gigabyte.bookstore.learning.domain.model.LessonItem
import kotlin.random.Random

sealed interface QuizQuestion {
    val item: LessonItem

    /** Play the English audio, pick the Bangla meaning. */
    data class ListenPickBangla(override val item: LessonItem, val options: List<String>, val answerIndex: Int) : QuizQuestion

    /** Show the Bangla, pick the English sentence. */
    data class BanglaPickTarget(override val item: LessonItem, val options: List<String>, val answerIndex: Int) : QuizQuestion

    /** Put shuffled English words back in order. */
    data class ArrangeWords(override val item: LessonItem, val shuffled: List<String>, val answer: List<String>) : QuizQuestion

    /** Pick the missing word. */
    data class FillBlank(
        override val item: LessonItem,
        val prompt: String,
        val options: List<String>,
        val answerIndex: Int
    ) : QuizQuestion
}

/**
 * Builds quiz questions from lesson items. Distractors come from the lesson first,
 * then from [pool] (other items in the same part). Deterministic for a given [random].
 */
class QuizGenerator(private val random: Random = Random.Default) {

    fun generate(items: List<LessonItem>, pool: List<LessonItem> = emptyList()): List<QuizQuestion> {
        val candidates = (items + pool).distinctBy { it.conceptId }
        return items.mapIndexedNotNull { index, item ->
            // Rotate question types so a lesson gets a mix.
            val order = listOf(0, 1, 2, 3).let { types -> types.drop(index % 4) + types.take(index % 4) }
            order.firstNotNullOfOrNull { type ->
                when (type) {
                    0 -> listenPickBangla(item, candidates)
                    1 -> banglaPickTarget(item, candidates)
                    2 -> arrangeWords(item)
                    else -> fillBlank(item, candidates)
                }
            }
        }
    }

    fun listenPickBangla(item: LessonItem, candidates: List<LessonItem>): QuizQuestion.ListenPickBangla? {
        val answer = item.bn?.takeIf { it.isNotBlank() } ?: return null
        val distractors = candidates.asSequence()
            .filter { it.conceptId != item.conceptId }
            .mapNotNull { it.bn?.takeIf(String::isNotBlank) }
            .filter { it != answer }
            .distinct()
            .take(3)
            .toList()
        if (distractors.size < 2) return null
        val options = (distractors + answer).shuffled(random)
        return QuizQuestion.ListenPickBangla(item, options, options.indexOf(answer))
    }

    fun banglaPickTarget(item: LessonItem, candidates: List<LessonItem>): QuizQuestion.BanglaPickTarget? {
        if (item.bn.isNullOrBlank()) return null
        val answer = item.target
        val distractors = candidates.asSequence()
            .filter { it.conceptId != item.conceptId && it.type == item.type }
            .map { it.target }
            .filter { !it.equals(answer, ignoreCase = true) }
            .distinct()
            .take(3)
            .toList()
        if (distractors.size < 2) return null
        val options = (distractors + answer).shuffled(random)
        return QuizQuestion.BanglaPickTarget(item, options, options.indexOf(answer))
    }

    fun arrangeWords(item: LessonItem): QuizQuestion.ArrangeWords? {
        val words = item.tokens.map { it.text }
        if (!item.isSentenceLike || words.size !in 3..10) return null
        var shuffled = words.shuffled(random)
        // Make sure the learner never gets the answer pre-arranged.
        var attempts = 0
        while (shuffled == words && attempts++ < 5) shuffled = words.shuffled(random)
        if (shuffled == words) shuffled = words.reversed()
        return QuizQuestion.ArrangeWords(item, shuffled, words)
    }

    fun fillBlank(item: LessonItem, candidates: List<LessonItem>): QuizQuestion.FillBlank? {
        val words = item.tokens.map { it.text }
        if (!item.isSentenceLike || words.size < 3) return null
        // Hide a content word: never the first word, and only words with letters.
        val blankIndex = (1 until words.size)
            .filter { normalize(words[it]).length >= 3 }
            .takeIf { it.isNotEmpty() }
            ?.random(random) ?: return null
        val answer = normalize(words[blankIndex])
        val distractors = candidates.asSequence()
            .flatMap { it.tokens.asSequence() }
            .map { normalize(it.text) }
            .filter { it.length >= 3 && !it.equals(answer, ignoreCase = true) }
            .distinct()
            .toList()
            .shuffled(random)
            .take(3)
        if (distractors.size < 2) return null
        val trailing = words[blankIndex].drop(words[blankIndex].trimEnd(*PUNCTUATION).length)
        val prompt = words.mapIndexed { i, w -> if (i == blankIndex) "_____$trailing" else w }.joinToString(" ")
        val options = (distractors + answer).shuffled(random)
        return QuizQuestion.FillBlank(item, prompt, options, options.indexOf(answer))
    }

    companion object {
        private val PUNCTUATION = charArrayOf('.', ',', '?', '!', ';', ':', '"', '\'')

        fun normalize(word: String): String = word.trim().trim(*PUNCTUATION)
    }
}
