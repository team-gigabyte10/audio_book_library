package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.domain.ladder.LessonQueueBuilder
import com.gigabyte.bookstore.learning.domain.model.LadderStep
import com.gigabyte.bookstore.learning.domain.model.LearnSettings
import com.gigabyte.bookstore.learning.domain.model.LessonItem
import com.gigabyte.bookstore.learning.domain.model.Level
import com.gigabyte.bookstore.learning.domain.model.PlaybackStep
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.gigabyte.bookstore.learning.domain.model.Token
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LessonQueueBuilderTest {

    private fun item(level: Level = Level.A1, bn: String? = "আমি ভাত খাই।", target: String = "I eat rice.") = LessonItem(
        id = "x", conceptId = "c", type = "sentence", level = level, target = target, bn = bn,
        tokens = target.split(' ').map { Token(it, null) }
    )

    private fun ladderSpeaks(steps: List<PlaybackStep>) =
        steps.filterIsInstance<PlaybackStep.Speak>().filter { it.phase == PlaybackStep.Phase.LADDER }

    @Test
    fun `default plays 3 English and 3 Bangla as EN-BN pairs`() {
        val steps = LessonQueueBuilder.buildItem(item(Level.A1), 0, LadderStep.DEFAULT, LearnSettings())
        val speaks = ladderSpeaks(steps)
        assertEquals(
            listOf(SpeechLang.EN, SpeechLang.BN, SpeechLang.EN, SpeechLang.BN, SpeechLang.EN, SpeechLang.BN),
            speaks.map { it.lang }
        )
        assertEquals(listOf(0.6f, 0.8f, 1.0f), speaks.filter { it.lang == SpeechLang.EN }.map { it.rate })
        assertEquals(PlaybackStep.Pause(1500L, 0), steps.last())
    }

    @Test
    fun `English and Bangla counts are equal for every repeat count`() {
        for (count in 1..5) {
            val speaks = ladderSpeaks(
                LessonQueueBuilder.buildItem(item(), 0, LadderStep.DEFAULT, LearnSettings(repeatCount = count))
            )
            assertEquals(count, speaks.count { it.lang == SpeechLang.EN })
            assertEquals(count, speaks.count { it.lang == SpeechLang.BN })
        }
    }

    @Test
    fun `repeat count speeds go from slow to normal`() {
        assertEquals(listOf(1.0f), LessonQueueBuilder.englishSpeeds(item(), LadderStep.DEFAULT, 1))
        assertEquals(listOf(0.6f, 1.0f), LessonQueueBuilder.englishSpeeds(item(), LadderStep.DEFAULT, 2))
        assertEquals(listOf(0.6f, 0.7f, 0.8f, 0.9f, 1.0f), LessonQueueBuilder.englishSpeeds(item(), LadderStep.DEFAULT, 5))
        // Out-of-range counts are clamped to 1..5.
        assertEquals(5, LessonQueueBuilder.englishSpeeds(item(), LadderStep.DEFAULT, 99).size)
    }

    @Test
    fun `B1 items add one more 1_2x pair and stay equal`() {
        val speaks = ladderSpeaks(LessonQueueBuilder.buildItem(item(Level.B1), 0, LadderStep.DEFAULT, LearnSettings()))
        assertEquals(4, speaks.count { it.lang == SpeechLang.EN })
        assertEquals(4, speaks.count { it.lang == SpeechLang.BN })
        assertTrue(speaks.any { it.lang == SpeechLang.EN && it.rate == 1.2f })
    }

    @Test
    fun `missing Bangla or Bangla turned off plays English only`() {
        val noBn = ladderSpeaks(LessonQueueBuilder.buildItem(item(bn = null), 0, LadderStep.DEFAULT, LearnSettings()))
        val off = ladderSpeaks(LessonQueueBuilder.buildItem(item(), 0, LadderStep.DEFAULT, LearnSettings(bnAudio = false)))
        assertTrue(noBn.none { it.lang == SpeechLang.BN })
        assertTrue(off.none { it.lang == SpeechLang.BN })
        assertEquals(3, off.count { it.lang == SpeechLang.EN })
    }

    @Test
    fun `gap setting overrides ladder pause`() {
        val steps = LessonQueueBuilder.buildItem(item(), 0, LadderStep.DEFAULT, LearnSettings(gapMs = 3000L))
        assertEquals(PlaybackStep.Pause(3000L, 0), steps.last())
    }

    @Test
    fun `word by word plays tokens then cumulative prefixes before the pairs`() {
        val steps = LessonQueueBuilder.buildItem(item(), 0, LadderStep.DEFAULT, LearnSettings(wordByWord = true))
        val texts = steps.filterIsInstance<PlaybackStep.Speak>()
            .takeWhile { it.phase != PlaybackStep.Phase.LADDER }
            .map { it.text }
        assertEquals(listOf("I", "eat", "rice.", "I eat"), texts)
    }

    @Test
    fun `lesson queue keeps item indices`() {
        val steps = LessonQueueBuilder.buildLesson(listOf(item(), item()), LadderStep.DEFAULT, LearnSettings())
        assertEquals(setOf(0, 1), steps.map { it.itemIndex }.toSet())
    }

    @Test
    fun `ladder encode and decode round trip`() {
        assertEquals(LadderStep.DEFAULT, LadderStep.decode(LadderStep.encode(LadderStep.DEFAULT)))
        assertEquals(LadderStep.DEFAULT, LadderStep.decode(null))
        assertEquals(LadderStep.DEFAULT, LadderStep.decode("garbage"))
    }
}
