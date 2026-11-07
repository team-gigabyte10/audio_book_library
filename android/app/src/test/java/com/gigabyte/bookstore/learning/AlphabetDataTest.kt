package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.presentation.alphabet.EnglishAlphabetData
import com.gigabyte.bookstore.learning.presentation.alphabet.GermanAlphabetData
import com.gigabyte.bookstore.learning.presentation.alphabet.HindiVarnamalaData
import com.gigabyte.bookstore.learning.presentation.alphabet.LanguageAlphabetConfig
import com.gigabyte.bookstore.learning.presentation.alphabet.UrduAlphabetData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AlphabetDataTest {

    @Test
    fun `English alphabet dataset has expected counts and valid fields`() {
        verifyConfig(EnglishAlphabetData.CONFIG, expectedCount = 34)
    }

    @Test
    fun `Urdu alphabet dataset has expected counts and valid fields`() {
        val config = UrduAlphabetData.CONFIG
        verifyConfig(config, expectedCount = 53)

        val alif = config.allLetters.first { it.id == "ur_alif" }
        assertEquals("الف", alif.ttsText)
        assertEquals("انار", alif.exampleWord)
        assertNotEquals(alif.ttsText, alif.exampleWord)

        val bay = config.allLetters.first { it.id == "ur_bay" }
        assertEquals("بے", bay.ttsText)

        val bha = config.allLetters.first { it.id == "ur_bha" }
        assertEquals("بھ", bha.ttsText)
    }

    @Test
    fun `Hindi varnamala dataset has expected counts and valid fields`() {
        val config = HindiVarnamalaData.CONFIG
        verifyConfig(config, expectedCount = 57)

        val a = config.allLetters.first { it.id == "hi_a" }
        assertEquals("अ", a.ttsText)
        assertEquals("अनार", a.exampleWord)
        assertNotEquals(a.ttsText, a.exampleWord)

        val ka = config.allLetters.first { it.id == "hi_ka" }
        assertEquals("क", ka.ttsText)
        assertEquals("कमल", ka.exampleWord)
        assertNotEquals(ka.ttsText, ka.exampleWord)
    }

    @Test
    fun `German alphabet dataset has expected counts and valid fields`() {
        val config = GermanAlphabetData.CONFIG
        verifyConfig(config, expectedCount = 38)

        val a = config.allLetters.first { it.id == "de_a" }
        assertEquals("A", a.ttsText)
        assertEquals("Apfel", a.exampleWord)

        val j = config.allLetters.first { it.id == "de_j" }
        assertEquals("Jot", j.ttsText)
        assertEquals("Ja", j.exampleWord)

        val v = config.allLetters.first { it.id == "de_v" }
        assertEquals("Vau", v.ttsText)
        assertEquals("Vater", v.exampleWord)

        val ss = config.allLetters.first { it.id == "de_ss" }
        assertEquals("Eszett", ss.ttsText)
        assertEquals("Straße", ss.exampleWord)
    }

    private fun verifyConfig(config: LanguageAlphabetConfig, expectedCount: Int) {
        val letters = config.allLetters
        assertEquals("${config.langCode} total letter count", expectedCount, letters.size)

        val ids = letters.map { it.id }
        assertEquals("${config.langCode} letter IDs must be unique", ids.size, ids.toSet().size)

        for (letter in letters) {
            assertTrue("primaryDisplay non-empty for ${letter.id}", letter.primaryDisplay.isNotBlank())
            assertTrue("phoneticName non-empty for ${letter.id}", letter.phoneticName.isNotBlank())
            assertTrue("bnPron non-empty for ${letter.id}", letter.bnPron.isNotBlank())
            assertTrue("ttsText non-empty for ${letter.id}", letter.ttsText.isNotBlank())

            // TTS text should speak the letter phonics/name, not the full example vocabulary word
            if (!letter.exampleWord.isNullOrBlank()) {
                assertNotEquals(
                    "Letter ${letter.id} ttsText should not simply be the example word",
                    letter.exampleWord,
                    letter.ttsText
                )
            }
        }
    }
}
