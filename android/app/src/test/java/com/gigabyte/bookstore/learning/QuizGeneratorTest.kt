package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.domain.model.LessonItem
import com.gigabyte.bookstore.learning.domain.model.Level
import com.gigabyte.bookstore.learning.domain.model.Token
import com.gigabyte.bookstore.learning.domain.quiz.QuizGenerator
import com.gigabyte.bookstore.learning.domain.quiz.QuizQuestion
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.random.Random

class QuizGeneratorTest {

    private fun item(i: Int, target: String, bn: String?) = LessonItem(
        id = "i$i", conceptId = "c$i", type = "sentence", level = Level.A1, target = target, bn = bn,
        tokens = target.split(' ').map { Token(it, null) }
    )

    private val items = listOf(
        item(1, "I eat rice every day.", "আমি প্রতিদিন ভাত খাই।"),
        item(2, "She reads a book.", "সে একটি বই পড়ে।"),
        item(3, "They play football.", "তারা ফুটবল খেলে।"),
        item(4, "We go to school.", "আমরা স্কুলে যাই।")
    )

    @Test
    fun `choice questions contain the answer once and unique options`() {
        val gen = QuizGenerator(Random(42))
        val q = gen.listenPickBangla(items[0], items)!!
        assertEquals(items[0].bn, q.options[q.answerIndex])
        assertEquals(q.options.size, q.options.toSet().size)
        val t = gen.banglaPickTarget(items[1], items)!!
        assertEquals(items[1].target, t.options[t.answerIndex])
    }

    @Test
    fun `no Bangla means no Bangla-based question`() {
        val gen = QuizGenerator(Random(1))
        assertNull(gen.listenPickBangla(item(9, "Hello there friend.", null), items))
        assertNull(gen.banglaPickTarget(item(9, "Hello there friend.", null), items))
    }

    @Test
    fun `arrange words is never pre-solved and only for 3 to 10 words`() {
        val gen = QuizGenerator(Random(7))
        val q = gen.arrangeWords(items[0])!!
        assertNotEquals(q.answer, q.shuffled)
        assertEquals(q.answer.sorted(), q.shuffled.sorted())
        assertNull(gen.arrangeWords(item(9, "Hi there", "হাই")))
    }

    @Test
    fun `fill blank never hides the first word`() {
        repeat(20) { seed ->
            val q = QuizGenerator(Random(seed)).fillBlank(items[0], items) ?: return@repeat
            assertTrue(q.prompt.startsWith("I "))
            assertTrue(q.prompt.contains("_____"))
            assertEquals(q.options.size, q.options.toSet().size)
        }
    }

    @Test
    fun `generate makes one question per item with a mix of types`() {
        val questions = QuizGenerator(Random(3)).generate(items)
        assertEquals(items.size, questions.size)
        assertTrue(questions.map { it::class }.toSet().size > 1)
        assertTrue(questions.all { it !is QuizQuestion.ArrangeWords || it.answer.size in 3..10 })
    }
}
