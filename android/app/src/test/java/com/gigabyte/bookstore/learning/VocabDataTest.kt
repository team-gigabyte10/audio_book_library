package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.presentation.vocab.EnglishVocabData
import com.gigabyte.bookstore.learning.presentation.vocab.GermanVocabData
import com.gigabyte.bookstore.learning.presentation.vocab.GrammaticalGender
import com.gigabyte.bookstore.learning.presentation.vocab.HindiVocabData
import com.gigabyte.bookstore.learning.presentation.vocab.JapaneseVocabData
import com.gigabyte.bookstore.learning.presentation.vocab.UrduVocabData
import com.gigabyte.bookstore.learning.presentation.vocab.VocabCategory
import com.gigabyte.bookstore.learning.presentation.vocab.VocabRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class VocabDataTest {

    @Test
    fun testEnglishVocabHas1000Items() {
        val config = EnglishVocabData.config
        assertEquals(1000, config.items.size)
        assertEquals("en", config.langCode)
        for (item in config.items) {
            assertTrue("Item ID ${item.id} singularTarget must not be blank", item.singularTarget.isNotBlank())
            assertTrue("Item ID ${item.id} singularBnPron must not be blank", item.singularBnPron.isNotBlank())
            assertTrue("Item ID ${item.id} bnMeaning must not be blank", item.bnMeaning.isNotBlank())
        }
    }

    @Test
    fun testGermanVocabHas1000ItemsAndArticles() {
        val config = GermanVocabData.config
        assertEquals(1000, config.items.size)
        assertEquals("de", config.langCode)
        var articlesFound = 0
        for (item in config.items) {
            assertTrue("Item ID ${item.id} singularTarget must not be blank", item.singularTarget.isNotBlank())
            assertTrue("Item ID ${item.id} singularBnPron must not be blank", item.singularBnPron.isNotBlank())
            assertTrue("Item ID ${item.id} bnMeaning must not be blank", item.bnMeaning.isNotBlank())
            if (!item.germanArticleSingular.isNullOrBlank()) {
                articlesFound++
                assertTrue(
                    "Article must be der, die, or das",
                    item.germanArticleSingular in listOf("der", "die", "das")
                )
            }
        }
        assertTrue("German should have many articles defined", articlesFound > 500)
    }

    @Test
    fun testHindiVocabHas1000ItemsAndGenders() {
        val config = HindiVocabData.config
        assertEquals(1000, config.items.size)
        assertEquals("hi", config.langCode)
        var gendersAssigned = 0
        for (item in config.items) {
            assertTrue("Item ID ${item.id} singularTarget must not be blank", item.singularTarget.isNotBlank())
            assertTrue("Item ID ${item.id} singularBnPron must not be blank", item.singularBnPron.isNotBlank())
            assertTrue("Item ID ${item.id} bnMeaning must not be blank", item.bnMeaning.isNotBlank())
            if (item.gender != GrammaticalGender.NONE) {
                gendersAssigned++
            }
        }
        assertTrue("Hindi should have grammatical genders assigned", gendersAssigned > 500)
    }

    @Test
    fun testUrduVocabHas1000ItemsAndGenders() {
        val config = UrduVocabData.config
        assertEquals(1000, config.items.size)
        assertEquals("ur", config.langCode)
        var gendersAssigned = 0
        for (item in config.items) {
            assertTrue("Item ID ${item.id} singularTarget must not be blank", item.singularTarget.isNotBlank())
            assertTrue("Item ID ${item.id} singularBnPron must not be blank", item.singularBnPron.isNotBlank())
            assertTrue("Item ID ${item.id} bnMeaning must not be blank", item.bnMeaning.isNotBlank())
            if (item.gender != GrammaticalGender.NONE) {
                gendersAssigned++
            }
        }
        assertTrue("Urdu should have grammatical genders assigned", gendersAssigned > 500)
    }

    @Test
    fun testJapaneseVocabHas1000ItemsAndReadings() {
        val config = JapaneseVocabData.config
        assertEquals(1000, config.items.size)
        assertEquals("ja", config.langCode)
        for (item in config.items) {
            assertTrue("Item ID ${item.id} singularTarget must not be blank", item.singularTarget.isNotBlank())
            assertTrue("Item ID ${item.id} singularBnPron must not be blank", item.singularBnPron.isNotBlank())
            assertTrue("Item ID ${item.id} bnMeaning must not be blank", item.bnMeaning.isNotBlank())
        }
    }

    @Test
    fun testAll20CategoriesCovered() {
        val allCategories = VocabCategory.values().filter { it != VocabCategory.ALL }
        assertEquals(20, allCategories.size)

        val enCategories = EnglishVocabData.config.items.map { it.category }.distinct()
        assertEquals("All 20 categories should be present in English data", 20, enCategories.size)

        // Each category has exactly 50 items
        for (cat in allCategories) {
            val count = EnglishVocabData.config.items.count { it.category == cat }
            assertEquals("Category ${cat.name} should have 50 items", 50, count)
        }
    }

    @Test
    fun testVocabRepositoryReturnsCorrectConfig() {
        assertEquals("en", VocabRepository.getConfigForLanguage("en").langCode)
        assertEquals("en", VocabRepository.getConfigForLanguage("english").langCode)
        assertEquals("de", VocabRepository.getConfigForLanguage("de").langCode)
        assertEquals("de", VocabRepository.getConfigForLanguage("german").langCode)
        assertEquals("hi", VocabRepository.getConfigForLanguage("hi").langCode)
        assertEquals("hi", VocabRepository.getConfigForLanguage("hindi").langCode)
        assertEquals("ur", VocabRepository.getConfigForLanguage("ur").langCode)
        assertEquals("ur", VocabRepository.getConfigForLanguage("urdu").langCode)
        assertEquals("ja", VocabRepository.getConfigForLanguage("ja").langCode)
        assertEquals("ja", VocabRepository.getConfigForLanguage("japanese").langCode)
    }
}

