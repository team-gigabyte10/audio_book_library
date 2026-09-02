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
            # সোনার বাংলা
            
            **আমার সোনার বাংলা**, আমি তোমায় *ভালোবাসি*।
            > চিরদিন তোমার আকাশ, তোমার বাতাস, আমার প্রাণে বাজায় বাঁশি?
            
            [রবীন্দ্রনাথ ঠাকুর](https://example.com)
            ```kotlin
            val tts = "test"
            ```
            - প্রথম দফা
            - দ্বিতীয় দফা!
        """.trimIndent()

        val cleaned = MarkdownCleaner.cleanForTTS(markdown)

        assertTrue(cleaned.contains("আমার সোনার বাংলা"))
        assertTrue(cleaned.contains("আমি তোমায় ভালোবাসি।"))
        assertTrue(cleaned.contains("চিরদিন তোমার আকাশ"))
        assertTrue(cleaned.contains("?"))
        assertTrue(cleaned.contains("!"))
        // Markdown symbols should be removed
        assertTrue(!cleaned.contains("**"))
        assertTrue(!cleaned.contains("```"))
        assertTrue(!cleaned.contains("https://example.com"))
    }

    @Test
    fun testSentenceChunker_splitsOnBanglaDari() {
        val banglaText = "আমার সোনার বাংলা, আমি তোমায় ভালোবাসি। চিরদিন তোমার আকাশ, তোমার বাতাস, আমার প্রাণে বাজায় বাঁশি। ও মা, ফাগুনে তোর আমের বনে ঘ্রাণে পাগল করে।"
        val chunks = SentenceChunker.splitIntoChunks(banglaText)

        assertTrue(chunks.isNotEmpty())
        assertTrue(chunks.size >= 3)
        assertEquals(0, chunks[0].index)
        assertTrue(chunks[0].text.endsWith("।"))
    }

    @Test
    fun testMarkdownParser_parsesFrontmatterAndChapters() {
        val markdown = """
            ---
            title: গীতাঞ্জলি
            author: রবীন্দ্রনাথ ঠাকুর
            description: নির্বাচিত কবিতা
            ---
            
            # গীতাঞ্জলি
            
            ## অধ্যায় ১: চিত্ত যেথা ভয়শূন্য
            চিত্ত যেথা ভয়শূন্য, উচ্চ যেথা শির। জ্ঞান যেথা মুক্ত।
            
            ## অধ্যায় ২: অঞ্জলি ও সমর্পণ
            তুমি কেমন করে গান করো হে গুণী, আমি অবাক হয়ে শুনি কেবল শুনি।
        """.trimIndent()

        val parsed = MarkdownParser.parse(markdown)

        assertEquals("গীতাঞ্জলি", parsed.book.title)
        assertEquals("রবীন্দ্রনাথ ঠাকুর", parsed.book.author)
        assertEquals(2, parsed.chapters.size)
        assertEquals("অধ্যায় ১: চিত্ত যেথা ভয়শূন্য", parsed.chapters[0].title)
        assertEquals("অধ্যায় ২: অঞ্জলি ও সমর্পণ", parsed.chapters[1].title)
    }
}
