package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.presentation.alphabet.EnglishAlphabetData
import com.gigabyte.bookstore.learning.presentation.alphabet.GermanAlphabetData
import com.gigabyte.bookstore.learning.presentation.alphabet.HindiVarnamalaData
import com.gigabyte.bookstore.learning.presentation.alphabet.LanguageAlphabetConfig
import com.gigabyte.bookstore.learning.presentation.alphabet.UrduAlphabetData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AlphabetDataTest {

    @Test
    fun `English alphabet dataset has expected counts and valid fields`() {
        verifyConfig(EnglishAlphabetData.CONFIG, expectedCount = 34)
    }

    @Test
    fun `Urdu alphabet dataset has expected counts and valid fields`() {
        verifyConfig(UrduAlphabetData.CONFIG, expectedCount = 53)
    }

    @Test
    fun `Hindi varnamala dataset has expected counts and valid fields`() {
        verifyConfig(HindiVarnamalaData.CONFIG, expectedCount = 57)
    }

    @Test
    fun `German alphabet dataset has expected counts and valid fields`() {
        verifyConfig(GermanAlphabetData.CONFIG, expectedCount = 38)
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
        }
    }
}

