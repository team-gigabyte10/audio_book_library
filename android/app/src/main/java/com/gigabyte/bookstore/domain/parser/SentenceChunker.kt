package com.gigabyte.bookstore.domain.parser

import com.gigabyte.bookstore.data.models.ChunkInfo

object SentenceChunker {

    private const val MIN_CHUNK_LENGTH = 3

    /**
     * Splits chapter content into ordered TTS chunks with sentence boundaries.
     * Recognizes Bengali punctuation (।, ?, !) and paragraph breaks.
     * Yields clean sentence-level chunks for accurate TTS reading and highlighting.
     */
    fun splitIntoChunks(cleanedText: String): List<ChunkInfo> {
        if (cleanedText.isBlank()) return emptyList()

        val chunks = mutableListOf<ChunkInfo>()
        val paragraphs = cleanedText.split(Regex("\\n+"))
        var chunkIndex = 0

        for ((paragraphIndex, paragraph) in paragraphs.withIndex()) {
            val trimmedParagraph = paragraph.trim()
            if (trimmedParagraph.isBlank()) continue

            // Split by Bengali sentence enders: Dari (।), Question (?), Exclamation (!)
            val sentences = splitIntoSentences(trimmedParagraph)

            for (sentence in sentences) {
                val trimmedSentence = sentence.trim()
                if (trimmedSentence.length >= MIN_CHUNK_LENGTH) {
                    chunks.add(
                        ChunkInfo(
                            index = chunkIndex++,
                            text = trimmedSentence,
                            rawText = trimmedSentence,
                            paragraphIndex = paragraphIndex
                        )
                    )
                }
            }
        }

        return chunks
    }

    /**
     * Splits text into sentences by preserving ending punctuation (।, ?, !).
     */
    private fun splitIntoSentences(text: String): List<String> {
        val results = mutableListOf<String>()
        val current = StringBuilder()

        var i = 0
        while (i < text.length) {
            val char = text[i]
            current.append(char)

            // Check if character is a Bengali or standard sentence terminator
            if (char == '।' || char == '?' || char == '!' || char == '\n') {
                // Include any following quotes if attached
                while (i + 1 < text.length && (text[i + 1] == '”' || text[i + 1] == '’' || text[i + 1] == '"' || text[i + 1] == '\'')) {
                    i++
                    current.append(text[i])
                }
                val sentence = current.toString().trim()
                if (sentence.isNotEmpty()) {
                    results.add(sentence)
                }
                current.clear()
            }
            i++
        }

        if (current.isNotEmpty()) {
            val remaining = current.toString().trim()
            if (remaining.isNotEmpty()) {
                results.add(remaining)
            }
        }

        return results
    }
}
