package com.gigabyte.bookstore.learning.domain.audio

/**
 * Maps regional dialect items (`bd-*`) to authentic recorded audio reference keys,
 * bypassing robotic Android TTS completely in favor of native human regional voice recordings.
 */
object RegionalAudioCatalog {

    private const val CDN_BASE_URL = "https://raw.githubusercontent.com/team-gigabyte10/audio_book_library_assets/main/regional_audio"

    fun audioRefForItem(itemId: String?): String? {
        if (itemId.isNullOrBlank() || !itemId.startsWith("bd-")) return null
        return itemId.replace("-", "_")
    }

    fun audioRefsForLesson(lessonId: String): List<String> {
        val prefix = lessonId.replace("-", "_")
        // Generates references for 20 items per standard regional lesson
        return (1..20).map { idx ->
            String.format("%s_%03d", prefix, idx)
        }
    }

    fun buildAudioUrl(audioRef: String): String =
        "$CDN_BASE_URL/$audioRef.mp3"
}
