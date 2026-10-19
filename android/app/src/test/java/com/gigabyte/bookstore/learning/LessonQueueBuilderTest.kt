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

    private fun speaks(steps: List<PlaybackStep>) = steps.filterIsInstance<PlaybackStep.Speak>()

    @Test
    fun `default ladder below B1 skips the fast step`() {
        val steps = LessonQueueBuilder.buildItem(item(Level.A1), 0, LadderStep.DEFAULT, LearnSettings())
        assertEquals(listOf(0.6f, 1.0f, 0.6f, 0.8f, 1.0f), speaks(steps).map { it.rate })
        assertEquals(listOf(SpeechLang.EN, SpeechLang.BN, SpeechLang.EN, SpeechLang.EN, SpeechLang.EN), speaks(steps).map { it.lang })
        assertEquals(PlaybackStep.Pause(1500L, 0), steps.last())
    }

    @Test
    fun `B1 items get the 1_2x step`() {
        val steps = LessonQueueBuilder.buildItem(item(Level.B1), 0, LadderStep.DEFAULT, LearnSettings())
        assertTrue(speaks(steps).any { it.rate == 1.2f })
    }

    @Test
    fun `missing Bangla or Bangla turned off drops the Bangla step`() {
        val noBn = LessonQueueBuilder.buildItem(item(bn = null), 0, LadderStep.DEFAULT, LearnSettings())
        val off = LessonQueueBuilder.buildItem(item(), 0, LadderStep.DEFAULT, LearnSettings(bnAudio = false))
        assertTrue(speaks(noBn).none { it.lang == SpeechLang.BN })
        assertTrue(speaks(off).none { it.lang == SpeechLang.BN })
    }

    @Test
    fun `gap setting overrides ladder pause`() {
        val steps = LessonQueueBuilder.buildItem(item(), 0, LadderStep.DEFAULT, LearnSettings(gapMs = 3000L))
        assertEquals(PlaybackStep.Pause(3000L, 0), steps.last())
    }

    @Test
    fun `word by word plays tokens then cumulative prefixes before the ladder`() {
        val steps = LessonQueueBuilder.buildItem(item(), 0, LadderStep.DEFAULT, LearnSettings(wordByWord = true))
        val texts = speaks(steps).takeWhile { it.phase != PlaybackStep.Phase.LADDER }.map { it.text }
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
