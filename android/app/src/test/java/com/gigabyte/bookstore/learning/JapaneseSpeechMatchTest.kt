package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.domain.speech.JapaneseSpeechMatch
import com.gigabyte.bookstore.learning.domain.speech.JapaneseSpeechMatch.Result
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class JapaneseSpeechMatchTest {

    @Test
    fun `exact text matches without punctuation and spaces`() {
        assertEquals(Result.MATCH, JapaneseSpeechMatch.evaluate(listOf("おはよう ございます"), listOf("おはようございます。")))
    }

    @Test
    fun `katakana and hiragana compare equal`() {
        assertEquals(Result.MATCH, JapaneseSpeechMatch.evaluate(listOf("ネコ"), listOf("ねこ")))
    }

    @Test
    fun `any accepted form and any guess can match`() {
        val expected = listOf("毎朝7時に起きます。", "まいあさしちじにおきます")
        assertEquals(Result.MATCH, JapaneseSpeechMatch.evaluate(listOf("毎朝7時に起きます"), expected))
        assertEquals(Result.MATCH, JapaneseSpeechMatch.evaluate(listOf("猫", "ねこ"), listOf("ねこ")))
    }

    @Test
    fun `a small slip is near and a different phrase is no match`() {
        assertEquals(Result.NEAR, JapaneseSpeechMatch.evaluate(listOf("ありがとございます"), listOf("ありがとうございます")))
        assertEquals(Result.NO_MATCH, JapaneseSpeechMatch.evaluate(listOf("さようなら"), listOf("ありがとうございます")))
    }

    @Test
    fun `empty input is no match`() {
        assertEquals(Result.NO_MATCH, JapaneseSpeechMatch.evaluate(emptyList(), listOf("ねこ")))
        assertEquals(Result.NO_MATCH, JapaneseSpeechMatch.evaluate(listOf("ねこ"), listOf("。")))
    }

    @Test
    fun `kana only check`() {
        assertTrue(JapaneseSpeechMatch.isKanaOnly("まいあさ しちじに おきます"))
        assertTrue(JapaneseSpeechMatch.isKanaOnly("コーヒー"))
        assertFalse(JapaneseSpeechMatch.isKanaOnly("neko"))
        assertFalse(JapaneseSpeechMatch.isKanaOnly("毎朝"))
    }
}
