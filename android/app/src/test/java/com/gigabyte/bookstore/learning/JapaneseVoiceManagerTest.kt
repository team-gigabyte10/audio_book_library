package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.domain.audio.JapaneseVoiceGender
import com.gigabyte.bookstore.learning.domain.audio.JapaneseVoiceManager
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class JapaneseVoiceManagerTest {

    @Test
    fun `female voice pitch is optimized to 0_97 to eliminate sibilance and distortion`() {
        val femalePitch = JapaneseVoiceManager.getOptimizedPitch(JapaneseVoiceGender.FEMALE)
        assertEquals(0.97f, femalePitch, 0.001f)
        assertTrue("Female pitch must be lower than 1.0 to prevent tinny distortion", femalePitch < 1.0f)
    }

    @Test
    fun `male voice pitch is set to natural baritone 1_00`() {
        val malePitch = JapaneseVoiceManager.getOptimizedPitch(JapaneseVoiceGender.MALE)
        assertEquals(1.00f, malePitch, 0.001f)
    }

    @Test
    fun `single kana mora has citation pause appended for natural acoustic release`() {
        assertEquals("あ、", JapaneseVoiceManager.formatForClearPronunciation("あ"))
        assertEquals("つ、", JapaneseVoiceManager.formatForClearPronunciation("つ"))
        assertEquals("し、", JapaneseVoiceManager.formatForClearPronunciation("し"))
        assertEquals("ふ、", JapaneseVoiceManager.formatForClearPronunciation("ふ"))
        assertEquals("きゃ、", JapaneseVoiceManager.formatForClearPronunciation("きゃ"))
    }

    @Test
    fun `multi character words are not modified with trailing touten`() {
        assertEquals("ありがとう", JapaneseVoiceManager.formatForClearPronunciation("ありがとう"))
        assertEquals("こんにちは", JapaneseVoiceManager.formatForClearPronunciation("こんにちは"))
        assertEquals("さようなら", JapaneseVoiceManager.formatForClearPronunciation("さようなら"))
    }

    @Test
    fun `gender parsing from id handles all values correctly with safe fallback`() {
        assertEquals(JapaneseVoiceGender.FEMALE, JapaneseVoiceGender.fromId("female"))
        assertEquals(JapaneseVoiceGender.MALE, JapaneseVoiceGender.fromId("male"))
        assertEquals(JapaneseVoiceGender.AUTO, JapaneseVoiceGender.fromId("auto"))
        assertEquals(JapaneseVoiceGender.FEMALE, JapaneseVoiceGender.fromId(null))
        assertEquals(JapaneseVoiceGender.FEMALE, JapaneseVoiceGender.fromId("unknown"))
    }
}

