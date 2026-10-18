package com.gigabyte.bookstore

import com.gigabyte.bookstore.domain.parser.MarkdownCleaner
import com.gigabyte.bookstore.domain.parser.MarkdownParser
import com.gigabyte.bookstore.domain.parser.SentenceChunker
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun testMarkdownCleaner_preservesBanglaPunctuationAndText() {
        val markdown = """
            # αª╕αºïαª¿αª╛αª░ αª¼αª╛αªéαª▓αª╛
            
            **αªåαª«αª╛αª░ αª╕αºïαª¿αª╛αª░ αª¼αª╛αªéαª▓αª╛**, αªåαª«αª┐ αªñαºïαª«αª╛αª»αª╝ *αª¡αª╛αª▓αºïαª¼αª╛αª╕αª┐*αÑñ
            > αªÜαª┐αª░αªªαª┐αª¿ αªñαºïαª«αª╛αª░ αªåαªòαª╛αª╢, αªñαºïαª«αª╛αª░ αª¼αª╛αªñαª╛αª╕, αªåαª«αª╛αª░ αª¬αºìαª░αª╛αªúαºç αª¼αª╛αª£αª╛αª»αª╝ αª¼αª╛αªüαª╢αª┐?
            
            [αª░αª¼αºÇαª¿αºìαªªαºìαª░αª¿αª╛αªÑ αªáαª╛αªòαºüαª░](https://example.com)
            ```kotlin
            val tts = "test"
            ```
            - αª¬αºìαª░αªÑαª« αªªαª½αª╛
            - αªªαºìαª¼αª┐αªñαºÇαª»αª╝ αªªαª½αª╛!
        """.trimIndent()

        val cleaned = MarkdownCleaner.cleanForTTS(markdown)

        assertTrue(cleaned.contains("αªåαª«αª╛αª░ αª╕αºïαª¿αª╛αª░ αª¼αª╛αªéαª▓αª╛"))
        assertTrue(cleaned.contains("αªåαª«αª┐ αªñαºïαª«αª╛αª»αª╝ αª¡αª╛αª▓αºïαª¼αª╛αª╕αª┐αÑñ"))
        assertTrue(cleaned.contains("αªÜαª┐αª░αªªαª┐αª¿ αªñαºïαª«αª╛αª░ αªåαªòαª╛αª╢"))
        assertTrue(cleaned.contains("?"))
        assertTrue(cleaned.contains("!"))
        // Markdown symbols should be removed
        assertTrue(!cleaned.contains("**"))
        assertTrue(!cleaned.contains("```"))
        assertTrue(!cleaned.contains("https://example.com"))
    }

    @Test
    fun testSentenceChunker_splitsOnBanglaDari() {
        val banglaText = "αªåαª«αª╛αª░ αª╕αºïαª¿αª╛αª░ αª¼αª╛αªéαª▓αª╛, αªåαª«αª┐ αªñαºïαª«αª╛αª»αª╝ αª¡αª╛αª▓αºïαª¼αª╛αª╕αª┐αÑñ αªÜαª┐αª░αªªαª┐αª¿ αªñαºïαª«αª╛αª░ αªåαªòαª╛αª╢, αªñαºïαª«αª╛αª░ αª¼αª╛αªñαª╛αª╕, αªåαª«αª╛αª░ αª¬αºìαª░αª╛αªúαºç αª¼αª╛αª£αª╛αª»αª╝ αª¼αª╛αªüαª╢αª┐αÑñ αªô αª«αª╛, αª½αª╛αªùαºüαª¿αºç αªñαºïαª░ αªåαª«αºçαª░ αª¼αª¿αºç αªÿαºìαª░αª╛αªúαºç αª¬αª╛αªùαª▓ αªòαª░αºçαÑñ"
        val chunks = SentenceChunker.splitIntoChunks(banglaText)

        assertTrue(chunks.isNotEmpty())
        assertTrue(chunks.size >= 3)
        assertEquals(0, chunks[0].index)
        assertTrue(chunks[0].text.endsWith("αÑñ"))
    }

    @Test
    fun testMarkdownParser_parsesFrontmatterAndChapters() {
        val markdown = """
            ---
            title: αªùαºÇαªñαª╛αª₧αºìαª£αª▓αª┐
            author: αª░αª¼αºÇαª¿αºìαªªαºìαª░αª¿αª╛αªÑ αªáαª╛αªòαºüαª░
            description: αª¿αª┐αª░αºìαª¼αª╛αªÜαª┐αªñ αªòαª¼αª┐αªñαª╛
            ---
            
            # αªùαºÇαªñαª╛αª₧αºìαª£αª▓αª┐
            
            ## αªàαªºαºìαª»αª╛αª»αª╝ αºº: αªÜαª┐αªñαºìαªñ αª»αºçαªÑαª╛ αª¡αª»αª╝αª╢αºéαª¿αºìαª»
            αªÜαª┐αªñαºìαªñ αª»αºçαªÑαª╛ αª¡αª»αª╝αª╢αºéαª¿αºìαª», αªëαªÜαºìαªÜ αª»αºçαªÑαª╛ αª╢αª┐αª░αÑñ αª£αºìαª₧αª╛αª¿ αª»αºçαªÑαª╛ αª«αºüαªòαºìαªñαÑñ
            
            ## αªàαªºαºìαª»αª╛αª»αª╝ αº¿: αªàαª₧αºìαª£αª▓αª┐ αªô αª╕αª«αª░αºìαª¬αªú
            αªñαºüαª«αª┐ αªòαºçαª«αª¿ αªòαª░αºç αªùαª╛αª¿ αªòαª░αºï αª╣αºç αªùαºüαªúαºÇ, αªåαª«αª┐ αªàαª¼αª╛αªò αª╣αª»αª╝αºç αª╢αºüαª¿αª┐ αªòαºçαª¼αª▓ αª╢αºüαª¿αª┐αÑñ
        """.trimIndent()

        val parsed = MarkdownParser.parse(markdown)

        assertEquals("αªùαºÇαªñαª╛αª₧αºìαª£αª▓αª┐", parsed.book.title)
        assertEquals("αª░αª¼αºÇαª¿αºìαªªαºìαª░αª¿αª╛αªÑ αªáαª╛αªòαºüαª░", parsed.book.author)
        assertEquals(2, parsed.chapters.size)
        assertEquals("αªàαªºαºìαª»αª╛αª»αª╝ αºº: αªÜαª┐αªñαºìαªñ αª»αºçαªÑαª╛ αª¡αª»αª╝αª╢αºéαª¿αºìαª»", parsed.chapters[0].title)
        assertEquals("αªàαªºαºìαª»αª╛αª»αª╝ αº¿: αªàαª₧αºìαª£αª▓αª┐ αªô αª╕αª«αª░αºìαª¬αªú", parsed.chapters[1].title)
    }
}
