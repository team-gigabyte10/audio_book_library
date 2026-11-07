package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.presentation.numbers.GermanNumberData
import com.gigabyte.bookstore.learning.presentation.numbers.HindiNumberData
import com.gigabyte.bookstore.learning.presentation.numbers.JapaneseNumberData
import com.gigabyte.bookstore.learning.presentation.numbers.LanguageNumberConfig
import com.gigabyte.bookstore.learning.presentation.numbers.UrduNumberData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class NumbersDataTest {

    @Test
    fun `Japanese numbers dataset contains complete 1 to 100 sequence with valid fields`() {
        val config = JapaneseNumberData.CONFIG
        verifyNumberConfig(config)

        val one = config.numbers.first { it.number == 1 }
        assertEquals("いち", one.wordTarget)
        assertEquals("一", one.secondaryDisplay)
        assertEquals("ichi", one.phoneticTranslit)

        val twenty = config.numbers.first { it.number == 20 }
        assertEquals("にじゅう", twenty.wordTarget)
        assertEquals("二十", twenty.secondaryDisplay)

        val hundred = config.numbers.first { it.number == 100 }
        assertEquals("ひゃく", hundred.wordTarget)
        assertEquals("百", hundred.secondaryDisplay)
    }

    @Test
    fun `Urdu numbers dataset contains complete 1 to 100 sequence with valid fields`() {
        val config = UrduNumberData.CONFIG
        verifyNumberConfig(config)

        val one = config.numbers.first { it.number == 1 }
        assertEquals("ایک", one.wordTarget)
        assertEquals("aik", one.phoneticTranslit)
        assertEquals("۱", one.nativeNumeral)

        val twenty = config.numbers.first { it.number == 20 }
        assertEquals("بیس", twenty.wordTarget)
        assertEquals("bees", twenty.phoneticTranslit)
        assertEquals("۲۰", twenty.nativeNumeral)

        val hundred = config.numbers.first { it.number == 100 }
        assertEquals("سو", hundred.wordTarget)
        assertEquals("۱۰۰", hundred.nativeNumeral)
    }

    @Test
    fun `Hindi numbers dataset contains complete 1 to 100 sequence with valid fields`() {
        val config = HindiNumberData.CONFIG
        verifyNumberConfig(config)

        val one = config.numbers.first { it.number == 1 }
        assertEquals("एक", one.wordTarget)
        assertEquals("ek", one.phoneticTranslit)
        assertEquals("१", one.nativeNumeral)

        val twenty = config.numbers.first { it.number == 20 }
        assertEquals("बीस", twenty.wordTarget)
        assertEquals("२०", twenty.nativeNumeral)

        val hundred = config.numbers.first { it.number == 100 }
        assertEquals("सौ", hundred.wordTarget)
        assertEquals("१००", hundred.nativeNumeral)
    }

    @Test
    fun `German numbers dataset contains complete 1 to 100 sequence with valid fields`() {
        val config = GermanNumberData.CONFIG
        verifyNumberConfig(config)

        val one = config.numbers.first { it.number == 1 }
        assertEquals("eins", one.wordTarget)

        val twentyOne = config.numbers.first { it.number == 21 }
        assertEquals("einundzwanzig", twentyOne.wordTarget)

        val hundred = config.numbers.first { it.number == 100 }
        assertEquals("hundert", hundred.wordTarget)
    }

    private fun verifyNumberConfig(config: LanguageNumberConfig) {
        val numbers = config.numbers
        assertEquals("${config.langCode} must have exactly 100 numbers", 100, numbers.size)

        for (i in 1..100) {
            val item = numbers[i - 1]
            assertEquals("Number order for ${config.langCode}", i, item.number)
            assertEquals("Digit display for ${config.langCode}", i.toString(), item.digitDisplay)
            assertTrue("wordTarget non-empty for ${config.langCode} #$i", item.wordTarget.isNotBlank())
            assertTrue("phoneticTranslit non-empty for ${config.langCode} #$i", item.phoneticTranslit.isNotBlank())
            assertTrue("bnPron non-empty for ${config.langCode} #$i", item.bnPron.isNotBlank())
            assertTrue("ttsText non-empty for ${config.langCode} #$i", item.ttsText.isNotBlank())
            assertTrue("rangeGroup non-empty for ${config.langCode} #$i", item.rangeGroup.isNotBlank())
        }

        // Verify categories
        assertTrue("Categories should not be empty", config.categories.isNotEmpty())
    }
}

