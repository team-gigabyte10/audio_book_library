package com.gigabyte.bookstore.domain.parser

object MarkdownCleaner {

    /**
     * Cleans Markdown syntax while preserving Bangla Unicode, letters, numbers,
     * spaces, and Bengali/standard punctuation (।, ?, !, ,, :, ;, “, ”, ‘, ’, -, —).
     */
    fun cleanForTTS(markdownText: String): String {
        if (markdownText.isBlank()) return ""

        var text = markdownText

        // 1. Remove HTML tags if any (e.g. <br>, <b>)
        text = text.replace(Regex("<[^>]*>"), " ")

        // 2. Remove code blocks ```...``` and inline code `...`
        text = text.replace(Regex("```[\\s\\S]*?```"), " ")
        text = text.replace(Regex("`([^`]+)`"), "$1")

        // 3. Remove image syntax: ![alt](url) -> ""
        text = text.replace(Regex("!\\[[^\\]]*\\]\\([^\\)]*\\)"), " ")

        // 4. Convert links: [text](url) -> text
        text = text.replace(Regex("\\[([^\\]]+)\\]\\([^\\)]*\\)"), "$1")

        // 5. Remove headers formatting: # Header -> Header
        text = text.replace(Regex("(?m)^#{1,6}\\s*"), "")

        // 6. Remove blockquote markers: > Quote -> Quote
        text = text.replace(Regex("(?m)^>+\\s*"), "")

        // 7. Remove list markers: unordered (*, -, +) and ordered (1., 2.)
        text = text.replace(Regex("(?m)^[\\s]*[-*+]\\s+"), "")
        text = text.replace(Regex("(?m)^[\\s]*\\d+[.)]\\s+"), "")

        // 8. Remove bold/italic: ***text***, **text**, *text*, ___text___, __text__, _text_
        text = text.replace(Regex("\\*\\*\\*([^\\*]+)\\*\\*\\*"), "$1")
        text = text.replace(Regex("\\*\\*([^\\*]+)\\*\\*"), "$1")
        text = text.replace(Regex("\\*([^\\*]+)\\*"), "$1")
        text = text.replace(Regex("___([^_]+)___"), "$1")
        text = text.replace(Regex("__([^_]+)__"), "$1")
        text = text.replace(Regex("_([^_]+)_"), "$1")
        text = text.replace(Regex("~~([^~]+)~~"), "$1")

        // 9. Remove horizontal rules: ---, ***, ___
        text = text.replace(Regex("(?m)^[-*_]{3,}\\s*$"), "")

        // 10. Clean any leftover brackets/parentheses around Markdown syntax
        text = text.replace(Regex("[\\[\\]{}#*`_~]"), " ")

        // 11. Normalize multiple whitespaces while preserving sentence structure
        text = text.replace(Regex("[ \\t]+"), " ")
        text = text.replace(Regex("\\n\\s*\\n"), "\n\n")

        return text.trim()
    }
}
