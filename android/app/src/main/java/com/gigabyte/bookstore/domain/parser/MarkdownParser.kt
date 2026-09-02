package com.gigabyte.bookstore.domain.parser

import com.gigabyte.bookstore.data.models.Book
import com.gigabyte.bookstore.data.models.Chapter
import java.util.UUID

data class ParsedBook(
    val book: Book,
    val chapters: List<Chapter>
)

object MarkdownParser {

    /**
     * Parses a Markdown book file content into a Book entity and ordered Chapters.
     */
    fun parse(
        content: String,
        fallbackId: String = UUID.randomUUID().toString(),
        fallbackTitle: String = "বাংলা বই",
        filePath: String = "",
        isAsset: Boolean = false
    ): ParsedBook {
        var raw = content.replace("\r\n", "\n").replace("\r", "\n")

        var title: String? = null
        var author: String? = null
        var coverImage: String? = null
        var description: String? = null

        // 1. Check for YAML front matter
        val frontMatterRegex = Regex("^---\\s*\\n([\\s\\S]*?)\\n---\\s*\\n")
        val frontMatterMatch = frontMatterRegex.find(raw)

        if (frontMatterMatch != null) {
            val yamlBlock = frontMatterMatch.groupValues[1]
            raw = raw.substring(frontMatterMatch.range.last + 1)

            yamlBlock.lines().forEach { line ->
                val parts = line.split(":", limit = 2)
                if (parts.size == 2) {
                    val key = parts[0].trim().lowercase()
                    val value = parts[1].trim().removeSurrounding("\"").removeSurrounding("'")
                    when (key) {
                        "title" -> title = value
                        "author" -> author = value
                        "cover", "image", "cover_image" -> coverImage = value
                        "description", "desc" -> description = value
                    }
                }
            }
        }

        // 2. Look for inline metadata fallbacks if not set in YAML
        if (author == null) {
            val authorMatch = Regex("(?m)^\\*\\*(?:মূল\\s+)?লেখক:\\*\\*\\s*(.+)$").find(raw)
            if (authorMatch != null) {
                author = authorMatch.groupValues[1].trim()
            }
        }

        if (description == null) {
            val descMatch = Regex("(?m)^\\*\\*(?:মূল\\s+)?থিম:\\*\\*\\s*(.+)$").find(raw)
            if (descMatch != null) {
                description = descMatch.groupValues[1].trim()
            }
        }

        // 3. Look for cover image syntax if not in YAML: ![Cover](url/path)
        if (coverImage == null) {
            val imageMatch = Regex("!\\[.*?\\]\\((.*?)\\)").find(raw)
            if (imageMatch != null) {
                coverImage = imageMatch.groupValues[1]
            }
        }

        // 3. Look for # Book Title heading (H1) and extract title if not set, then remove H1
        val titleMatch = Regex("(?m)^#\\s+(.+)$").find(raw)
        if (titleMatch != null) {
            if (title == null) {
                title = MarkdownCleaner.cleanForTTS(titleMatch.groupValues[1])
            }
            // Strip the H1 book title so it doesn't create a false chapter or intro
            raw = raw.replaceFirst(titleMatch.value, "").trim()
        }

        val finalTitle = title?.takeIf { it.isNotBlank() } ?: fallbackTitle

        // 4. Split by Chapters (## Chapter / ### Section)
        val chapterRegex = Regex("(?m)^(#{2,3}\\s+.+)$")
        val chapterMatches = chapterRegex.findAll(raw).toList()

        val chapters = mutableListOf<Chapter>()

        if (chapterMatches.isEmpty()) {
            // Single chapter book
            val cleanContent = MarkdownCleaner.cleanForTTS(raw)
            val chunks = SentenceChunker.splitIntoChunks(cleanContent)
            chapters.add(
                Chapter(
                    id = "$fallbackId-ch0",
                    bookId = fallbackId,
                    index = 0,
                    title = "অধ্যায় ১: সম্পূর্ণ পাঠ",
                    content = raw.trim(),
                    chunkCount = chunks.size
                )
            )
        } else {
            // Check if there is preface/intro text before first chapter heading
            val firstChapterStart = chapterMatches.first().range.first
            val introText = raw.substring(0, firstChapterStart).trim()

            var chapterIndex = 0
            if (introText.isNotBlank() && MarkdownCleaner.cleanForTTS(introText).isNotBlank()) {
                val cleanIntro = MarkdownCleaner.cleanForTTS(introText)
                val chunks = SentenceChunker.splitIntoChunks(cleanIntro)
                chapters.add(
                    Chapter(
                        id = "$fallbackId-ch$chapterIndex",
                        bookId = fallbackId,
                        index = chapterIndex++,
                        title = "ভূমিকা ও পরিচয়",
                        content = introText,
                        chunkCount = chunks.size
                    )
                )
            }

            for (i in chapterMatches.indices) {
                val headingMatch = chapterMatches[i]
                val rawHeading = headingMatch.groupValues[1]
                val cleanHeading = MarkdownCleaner.cleanForTTS(rawHeading)

                val startContent = headingMatch.range.last + 1
                val endContent = if (i + 1 < chapterMatches.size) {
                    chapterMatches[i + 1].range.first
                } else {
                    raw.length
                }

                val chapterBody = raw.substring(startContent, endContent).trim()
                val fullCleanText = "$cleanHeading。\n\n" + MarkdownCleaner.cleanForTTS(chapterBody)
                val chunks = SentenceChunker.splitIntoChunks(fullCleanText)

                chapters.add(
                    Chapter(
                        id = "$fallbackId-ch$chapterIndex",
                        bookId = fallbackId,
                        index = chapterIndex++,
                        title = cleanHeading.ifBlank { "অধ্যায় $chapterIndex" },
                        content = chapterBody.ifBlank { rawHeading },
                        chunkCount = chunks.size
                    )
                )
            }
        }

        val book = Book(
            id = fallbackId,
            title = finalTitle,
            author = author,
            filePath = filePath,
            coverPath = coverImage,
            chapterCount = chapters.size,
            description = description,
            isAsset = isAsset
        )

        return ParsedBook(book, chapters)
    }
}
