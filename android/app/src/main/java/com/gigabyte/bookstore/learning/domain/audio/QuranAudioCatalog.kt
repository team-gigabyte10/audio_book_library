package com.gigabyte.bookstore.learning.domain.audio

/**
 * Maps exact Quranic Ayah lesson items (`qr-*`) to universal 6-digit `SSSYAA` (Surah + Ayah) keys
 * so full Ayah items play authentic Male Qari Tilawat audio while Qaida drills and half-verse
 * fragments use Male-only Qari-tuned TTS.
 */
object QuranAudioCatalog {

    private val ITEM_TO_SURAH_AYAH: Map<String, String> = mapOf(
        // Surah Al-Fatiha (001) - qr-p4-u07-l01
        "qr-p4-u07-l01-001" to "001001",
        "qr-p4-u07-l01-002" to "001002",
        "qr-p4-u07-l01-003" to "001003",
        "qr-p4-u07-l01-004" to "001004",
        "qr-p4-u07-l01-005" to "001005",
        "qr-p4-u07-l01-006" to "001006",

        // Surah Al-Ikhlas (112) - qr-p4-u07-l02
        "qr-p4-u07-l02-001" to "112001",
        "qr-p4-u07-l02-002" to "112002",
        "qr-p4-u07-l02-003" to "112003",
        "qr-p4-u07-l02-004" to "112004",

        // Surah Al-Falaq (113) - qr-p4-u07-l03
        "qr-p4-u07-l03-001" to "113001",
        "qr-p4-u07-l03-002" to "113002",
        "qr-p4-u07-l03-003" to "113003",
        "qr-p4-u07-l03-004" to "113004",
        "qr-p4-u07-l03-005" to "113005",

        // Surah An-Nas (114) - qr-p4-u07-l04
        "qr-p4-u07-l04-001" to "114001",
        "qr-p4-u07-l04-002" to "114002",
        "qr-p4-u07-l04-003" to "114003",
        "qr-p4-u07-l04-004" to "114004",
        "qr-p4-u07-l04-005" to "114005",
        "qr-p4-u07-l04-006" to "114006",

        // Surah Al-Kawthar (108) & Surah An-Nasr (110) - qr-p4-u08-l01
        "qr-p4-u08-l01-001" to "108001",
        "qr-p4-u08-l01-002" to "108002",
        "qr-p4-u08-l01-003" to "108003",
        "qr-p4-u08-l01-004" to "110001",
        "qr-p4-u08-l01-005" to "110002",

        // Surah Al-Ma'un (107) & Surah Quraysh (106) - qr-p4-u08-l02
        "qr-p4-u08-l02-001" to "107001",
        "qr-p4-u08-l02-002" to "107002",
        "qr-p4-u08-l02-003" to "107003",
        "qr-p4-u08-l02-004" to "107004",
        "qr-p4-u08-l02-005" to "107005",
        "qr-p4-u08-l02-006" to "106001",
        "qr-p4-u08-l02-007" to "106002",
        "qr-p4-u08-l02-008" to "106003",

        // Surah Al-Fil (105) & Surah Al-Kafirun (109) - qr-p4-u08-l03
        "qr-p4-u08-l03-001" to "105001",
        "qr-p4-u08-l03-002" to "105002",
        "qr-p4-u08-l03-003" to "105003",
        "qr-p4-u08-l03-004" to "105004",
        "qr-p4-u08-l03-005" to "105005",
        "qr-p4-u08-l03-006" to "109001",
        "qr-p4-u08-l03-007" to "109002",
        "qr-p4-u08-l03-008" to "109006"
    )

    fun audioRefForItem(itemId: String?): String? {
        if (itemId.isNullOrBlank()) return null
        return ITEM_TO_SURAH_AYAH[itemId]
    }

    fun audioRefsForLesson(lessonId: String): List<String> {
        val prefix = "$lessonId-"
        return ITEM_TO_SURAH_AYAH.entries
            .filter { it.key.startsWith(prefix) }
            .map { it.value }
            .distinct()
    }

    fun buildEveryAyahUrl(reciter: QuranReciter, surahAyah: String): String =
        "https://everyayah.com/data/${reciter.everyAyahFolder}/$surahAyah.mp3"
}
