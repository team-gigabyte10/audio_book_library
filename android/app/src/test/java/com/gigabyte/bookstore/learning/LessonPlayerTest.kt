package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.domain.audio.StepAudioEngine
import com.gigabyte.bookstore.learning.domain.model.PlaybackStep
import com.gigabyte.bookstore.learning.domain.model.PlaybackStep.Phase
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.gigabyte.bookstore.learning.domain.player.LessonPlayer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LessonPlayerTest {

    private class FakeEngine : StepAudioEngine {
        override val englishAvailable: StateFlow<Boolean?> = MutableStateFlow(true)
        override val banglaAvailable: StateFlow<Boolean?> = MutableStateFlow(true)
        val spoken = mutableListOf<String>()
        override suspend fun speak(text: String, lang: SpeechLang, rate: Float) {
            delay(100)
            spoken += text
        }
        override fun stop() = Unit
    }

    private fun speak(text: String, item: Int) = PlaybackStep.Speak(text, SpeechLang.EN, 1f, item, Phase.LADDER)

    private val steps = listOf(
        speak("a1", 0), speak("a2", 0), PlaybackStep.Pause(500, 0),
        speak("b1", 1), speak("b2", 1)
    )

    @Test
    fun `plays the whole queue then finishes`() = runTest {
        val engine = FakeEngine()
        val player = LessonPlayer(engine, backgroundScope)
        player.load(steps)
        player.play()
        advanceUntilIdle()
        assertEquals(listOf("a1", "a2", "b1", "b2"), engine.spoken)
        assertTrue(player.state.value.isFinished)
        assertFalse(player.state.value.isPlaying)
    }

    @Test
    fun `without auto advance it stops at the end of each item`() = runTest {
        val engine = FakeEngine()
        val player = LessonPlayer(engine, backgroundScope).apply { autoAdvance = false }
        player.load(steps)
        player.play()
        advanceUntilIdle()
        assertEquals(listOf("a1", "a2"), engine.spoken)
        assertEquals(1, player.state.value.itemIndex)
        assertFalse(player.state.value.isPlaying)
    }

    @Test
    fun `next item jumps and load resumes at a given item`() = runTest {
        val engine = FakeEngine()
        val player = LessonPlayer(engine, backgroundScope)
        player.load(steps, startItem = 1)
        assertEquals(1, player.state.value.itemIndex)
        player.previousItem()
        assertEquals(0, player.state.value.itemIndex)
        player.nextItem()
        player.play()
        advanceUntilIdle()
        assertEquals(listOf("b1", "b2"), engine.spoken)
    }
}
