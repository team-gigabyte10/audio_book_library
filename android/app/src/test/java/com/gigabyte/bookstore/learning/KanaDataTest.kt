package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.presentation.kana.KanaCategory
import com.gigabyte.bookstore.learning.presentation.kana.KanaData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class KanaDataTest {

    @Test
    fun `Japanese letters count matches exactly 104 standard sounds`() {
        // 46 Gojūon + 25 Dakuon/Handakuon + 33 Yōon = 104 total phonetic sounds
        assertEquals(104, KanaData.ALL_LETTERS.size)
    }

    @Test
    fun `category counts match curriculum specifications`() {
        val gojuon = KanaData.ALL_LETTERS.filter { it.category == KanaCategory.GOJUON }
        val dakuten = KanaData.ALL_LETTERS.filter { it.category == KanaCategory.DAKUTEN }
        val yoon = KanaData.ALL_LETTERS.filter { it.category == KanaCategory.YOON }

        assertEquals(46, gojuon.size)
        assertEquals(25, dakuten.size)
        assertEquals(33, yoon.size)
    }

    @Test
    fun `every letter has valid Hiragana Katakana Romaji and Bangla phonetics`() {
        for (letter in KanaData.ALL_LETTERS) {
            assertTrue("Hiragana cannot be empty for ${letter.id}", letter.hiragana.isNotBlank())
            assertTrue("Katakana cannot be empty for ${letter.id}", letter.katakana.isNotBlank())
            assertTrue("Romaji cannot be empty for ${letter.id}", letter.romaji.isNotBlank())
            assertTrue("Bangla pronunciation cannot be empty for ${letter.id}", letter.bnPron.isNotBlank())
        }
    }

    @Test
    fun `letter IDs are unique across all sounds`() {
        val ids = KanaData.ALL_LETTERS.map { it.id }
        assertEquals("All letter IDs must be distinct", ids.size, ids.toSet().size)
    }

    @Test
    fun `look up by id works properly`() {
        val letterA = KanaData.findLetterById("a")
        assertNotNull(letterA)
        assertEquals("あ", letterA?.hiragana)
        assertEquals("ア", letterA?.katakana)
        assertEquals("আ", letterA?.bnPron)

        val letterKyu = KanaData.findLetterById("kyu")
        assertNotNull(letterKyu)
        assertEquals("きゅ", letterKyu?.hiragana)
        assertEquals("キュ", letterKyu?.katakana)
        assertEquals("কিউ", letterKyu?.bnPron)
    }
}

