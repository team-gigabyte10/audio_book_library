package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.domain.speech.SpeechMatch
import com.gigabyte.bookstore.learning.domain.speech.SpeechMatch.Result
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SpeechMatchTest {

    @Test
    fun `exact text matches without punctuation and spaces`() {
        assertEquals(Result.MATCH, SpeechMatch.evaluate(listOf("おはよう ございます"), listOf("おはようございます。")))
    }

    @Test
    fun `katakana and hiragana compare equal`() {
        assertEquals(Result.MATCH, SpeechMatch.evaluate(listOf("ネコ"), listOf("ねこ")))
    }

    @Test
    fun `any accepted form and any guess can match`() {
        val expected = listOf("毎朝7時に起きます。", "まいあさしちじにおきます")
        assertEquals(Result.MATCH, SpeechMatch.evaluate(listOf("毎朝7時に起きます"), expected))
        assertEquals(Result.MATCH, SpeechMatch.evaluate(listOf("猫", "ねこ"), listOf("ねこ")))
    }

    @Test
    fun `a small slip is near and a different phrase is no match`() {
        assertEquals(Result.NEAR, SpeechMatch.evaluate(listOf("ありがとございます"), listOf("ありがとうございます")))
        assertEquals(Result.NO_MATCH, SpeechMatch.evaluate(listOf("さようなら"), listOf("ありがとうございます")))
    }

    @Test
    fun `empty input is no match`() {
        assertEquals(Result.NO_MATCH, SpeechMatch.evaluate(emptyList(), listOf("ねこ")))
        assertEquals(Result.NO_MATCH, SpeechMatch.evaluate(listOf("ねこ"), listOf("。")))
    }

    @Test
    fun `kana only check`() {
        assertTrue(SpeechMatch.isKanaOnly("まいあさ しちじに おきます"))
        assertTrue(SpeechMatch.isKanaOnly("コーヒー"))
        assertFalse(SpeechMatch.isKanaOnly("neko"))
        assertFalse(SpeechMatch.isKanaOnly("毎朝"))
    }

    @Test
    fun `Urdu ignores vowel marks and punctuation`() {
        assertEquals(Result.MATCH, SpeechMatch.evaluate(listOf("میرا نام رحیم ہے"), listOf("مِیرا نام رَحِیم ہے۔")))
    }

    @Test
    fun `Arabic letter forms match Urdu letters`() {
        // ي ك ه are the Arabic forms that some recognizers return for ی ک ہ.
        assertEquals(Result.MATCH, SpeechMatch.evaluate(listOf("كتاب يه"), listOf("کتاب یہ")))
    }
}
