package com.gigabyte.bookstore.learning.domain.audio

/**
 * Maps exact Quranic Ayah lesson items (`qr-*`) to universal 6-digit `SSSYAA` (Surah + Ayah) keys
 * so full Ayah items play authentic Male Qari Tilawat audio while Qaida drills and half-verse
 * fragments use Male-only Qari-tuned TTS.
 */
object QuranAudioCatalog {

    private val ITEM_TO_SURAH_AYAH: Map<String, String> = mapOf(
        // Surah Al-Fatiha (001) - qr-p4-u07-l01
        "qr-p4-u07-l01-001" to "001001", // Bismillah
        "qr-p4-u07-l01-002" to "001002",
        "qr-p4-u07-l01-003" to "001003",
        "qr-p4-u07-l01-004" to "001004",
        "qr-p4-u07-l01-005" to "001005",
        "qr-p4-u07-l01-006" to "001006",
        "qr-p4-u07-l01-007" to "001007", // Ayah 7

        // Surah Al-Fil (105) - qr-p4-u07-l02
        "qr-p4-u07-l02-001" to "105001",
        "qr-p4-u07-l02-002" to "105002",
        "qr-p4-u07-l02-003" to "105003",
        "qr-p4-u07-l02-004" to "105004",
        "qr-p4-u07-l02-005" to "105005",

        // Surah Quraysh (106) - qr-p4-u07-l03
        "qr-p4-u07-l03-001" to "106001",
        "qr-p4-u07-l03-002" to "106002",
        "qr-p4-u07-l03-003" to "106003",
        "qr-p4-u07-l03-004" to "106004",

        // Surah Al-Ma'un (107) - qr-p4-u07-l04
        "qr-p4-u07-l04-001" to "107001",
        "qr-p4-u07-l04-002" to "107002",
        "qr-p4-u07-l04-003" to "107003",
        "qr-p4-u07-l04-004" to "107004",
        "qr-p4-u07-l04-005" to "107005",
        "qr-p4-u07-l04-006" to "107006",
        "qr-p4-u07-l04-007" to "107007",

        // Surah Al-Kawthar (108) - qr-p4-u07-l05
        "qr-p4-u07-l05-001" to "108001",
        "qr-p4-u07-l05-002" to "108002",
        "qr-p4-u07-l05-003" to "108003",

        // Surah Al-Kafirun (109) - qr-p4-u07-l06
        "qr-p4-u07-l06-001" to "109001",
        "qr-p4-u07-l06-002" to "109002",
        "qr-p4-u07-l06-003" to "109003",
        "qr-p4-u07-l06-004" to "109004",
        "qr-p4-u07-l06-005" to "109005",
        "qr-p4-u07-l06-006" to "109006",

        // Surah An-Nasr (110) - qr-p4-u08-l01
        "qr-p4-u08-l01-001" to "110001",
        "qr-p4-u08-l01-002" to "110002",
        "qr-p4-u08-l01-003" to "110003",

        // Surah Al-Masad (111) - qr-p4-u08-l02
        "qr-p4-u08-l02-001" to "111001",
        "qr-p4-u08-l02-002" to "111002",
        "qr-p4-u08-l02-003" to "111003",
        "qr-p4-u08-l02-004" to "111004",
        "qr-p4-u08-l02-005" to "111005",

        // Surah Al-Ikhlas (112) - qr-p4-u08-l03
        "qr-p4-u08-l03-001" to "112001",
        "qr-p4-u08-l03-002" to "112002",
        "qr-p4-u08-l03-003" to "112003",
        "qr-p4-u08-l03-004" to "112004",

        // Surah Al-Falaq (113) - qr-p4-u08-l04
        "qr-p4-u08-l04-001" to "113001",
        "qr-p4-u08-l04-002" to "113002",
        "qr-p4-u08-l04-003" to "113003",
        "qr-p4-u08-l04-004" to "113004",
        "qr-p4-u08-l04-005" to "113005",

        // Surah An-Nas (114) - qr-p4-u08-l05
        "qr-p4-u08-l05-001" to "114001",
        "qr-p4-u08-l05-002" to "114002",
        "qr-p4-u08-l05-003" to "114003",
        "qr-p4-u08-l05-004" to "114004",
        "qr-p4-u08-l05-005" to "114005",
        "qr-p4-u08-l05-006" to "114006",

        // Ayatul Kursi (2:255) & Surah Al-Hashr (59:22-24) - qr-p5-u09-l01
        "qr-p5-u09-l01-001" to "002255", // Ayatul Kursi
        "qr-p5-u09-l01-002" to "059022", // Hashr 22
        "qr-p5-u09-l01-003" to "059023", // Hashr 23
        "qr-p5-u09-l01-004" to "059024", // Hashr 24

        // Surah Yasin (036:001-083) - qr-p5-u09-l02
        "qr-p5-u09-l02-001" to "036001",
        "qr-p5-u09-l02-002" to "036002",
        "qr-p5-u09-l02-003" to "036003",
        "qr-p5-u09-l02-004" to "036004",
        "qr-p5-u09-l02-005" to "036005",
        "qr-p5-u09-l02-006" to "036006",
        "qr-p5-u09-l02-007" to "036007",
        "qr-p5-u09-l02-008" to "036008",
        "qr-p5-u09-l02-009" to "036009",
        "qr-p5-u09-l02-010" to "036010",
        "qr-p5-u09-l02-011" to "036011",
        "qr-p5-u09-l02-012" to "036012",
        "qr-p5-u09-l02-013" to "036013",
        "qr-p5-u09-l02-014" to "036014",
        "qr-p5-u09-l02-015" to "036015",
        "qr-p5-u09-l02-016" to "036016",
        "qr-p5-u09-l02-017" to "036017",
        "qr-p5-u09-l02-018" to "036018",
        "qr-p5-u09-l02-019" to "036019",
        "qr-p5-u09-l02-020" to "036020",
        "qr-p5-u09-l02-021" to "036021",
        "qr-p5-u09-l02-022" to "036022",
        "qr-p5-u09-l02-023" to "036023",
        "qr-p5-u09-l02-024" to "036024",
        "qr-p5-u09-l02-025" to "036025",
        "qr-p5-u09-l02-026" to "036026",
        "qr-p5-u09-l02-027" to "036027",
        "qr-p5-u09-l02-028" to "036028",
        "qr-p5-u09-l02-029" to "036029",
        "qr-p5-u09-l02-030" to "036030",
        "qr-p5-u09-l02-031" to "036031",
        "qr-p5-u09-l02-032" to "036032",
        "qr-p5-u09-l02-033" to "036033",
        "qr-p5-u09-l02-034" to "036034",
        "qr-p5-u09-l02-035" to "036035",
        "qr-p5-u09-l02-036" to "036036",
        "qr-p5-u09-l02-037" to "036037",
        "qr-p5-u09-l02-038" to "036038",
        "qr-p5-u09-l02-039" to "036039",
        "qr-p5-u09-l02-040" to "036040",
        "qr-p5-u09-l02-041" to "036041",
        "qr-p5-u09-l02-042" to "036042",
        "qr-p5-u09-l02-043" to "036043",
        "qr-p5-u09-l02-044" to "036044",
        "qr-p5-u09-l02-045" to "036045",
        "qr-p5-u09-l02-046" to "036046",
        "qr-p5-u09-l02-047" to "036047",
        "qr-p5-u09-l02-048" to "036048",
        "qr-p5-u09-l02-049" to "036049",
        "qr-p5-u09-l02-050" to "036050",
        "qr-p5-u09-l02-051" to "036051",
        "qr-p5-u09-l02-052" to "036052",
        "qr-p5-u09-l02-053" to "036053",
        "qr-p5-u09-l02-054" to "036054",
        "qr-p5-u09-l02-055" to "036055",
        "qr-p5-u09-l02-056" to "036056",
        "qr-p5-u09-l02-057" to "036057",
        "qr-p5-u09-l02-058" to "036058",
        "qr-p5-u09-l02-059" to "036059",
        "qr-p5-u09-l02-060" to "036060",
        "qr-p5-u09-l02-061" to "036061",
        "qr-p5-u09-l02-062" to "036062",
        "qr-p5-u09-l02-063" to "036063",
        "qr-p5-u09-l02-064" to "036064",
        "qr-p5-u09-l02-065" to "036065",
        "qr-p5-u09-l02-066" to "036066",
        "qr-p5-u09-l02-067" to "036067",
        "qr-p5-u09-l02-068" to "036068",
        "qr-p5-u09-l02-069" to "036069",
        "qr-p5-u09-l02-070" to "036070",
        "qr-p5-u09-l02-071" to "036071",
        "qr-p5-u09-l02-072" to "036072",
        "qr-p5-u09-l02-073" to "036073",
        "qr-p5-u09-l02-074" to "036074",
        "qr-p5-u09-l02-075" to "036075",
        "qr-p5-u09-l02-076" to "036076",
        "qr-p5-u09-l02-077" to "036077",
        "qr-p5-u09-l02-078" to "036078",
        "qr-p5-u09-l02-079" to "036079",
        "qr-p5-u09-l02-080" to "036080",
        "qr-p5-u09-l02-081" to "036081",
        "qr-p5-u09-l02-082" to "036082",
        "qr-p5-u09-l02-083" to "036083",

        // Surah Ar-Rahman (055:001-078) - qr-p5-u09-l03
        "qr-p5-u09-l03-001" to "055001",
        "qr-p5-u09-l03-002" to "055002",
        "qr-p5-u09-l03-003" to "055003",
        "qr-p5-u09-l03-004" to "055004",
        "qr-p5-u09-l03-005" to "055005",
        "qr-p5-u09-l03-006" to "055006",
        "qr-p5-u09-l03-007" to "055007",
        "qr-p5-u09-l03-008" to "055008",
        "qr-p5-u09-l03-009" to "055009",
        "qr-p5-u09-l03-010" to "055010",
        "qr-p5-u09-l03-011" to "055011",
        "qr-p5-u09-l03-012" to "055012",
        "qr-p5-u09-l03-013" to "055013",
        "qr-p5-u09-l03-014" to "055014",
        "qr-p5-u09-l03-015" to "055015",
        "qr-p5-u09-l03-016" to "055016",
        "qr-p5-u09-l03-017" to "055017",
        "qr-p5-u09-l03-018" to "055018",
        "qr-p5-u09-l03-019" to "055019",
        "qr-p5-u09-l03-020" to "055020",
        "qr-p5-u09-l03-021" to "055021",
        "qr-p5-u09-l03-022" to "055022",
        "qr-p5-u09-l03-023" to "055023",
        "qr-p5-u09-l03-024" to "055024",
        "qr-p5-u09-l03-025" to "055025",
        "qr-p5-u09-l03-026" to "055026",
        "qr-p5-u09-l03-027" to "055027",
        "qr-p5-u09-l03-028" to "055028",
        "qr-p5-u09-l03-029" to "055029",
        "qr-p5-u09-l03-030" to "055030",
        "qr-p5-u09-l03-031" to "055031",
        "qr-p5-u09-l03-032" to "055032",
        "qr-p5-u09-l03-033" to "055033",
        "qr-p5-u09-l03-034" to "055034",
        "qr-p5-u09-l03-035" to "055035",
        "qr-p5-u09-l03-036" to "055036",
        "qr-p5-u09-l03-037" to "055037",
        "qr-p5-u09-l03-038" to "055038",
        "qr-p5-u09-l03-039" to "055039",
        "qr-p5-u09-l03-040" to "055040",
        "qr-p5-u09-l03-041" to "055041",
        "qr-p5-u09-l03-042" to "055042",
        "qr-p5-u09-l03-043" to "055043",
        "qr-p5-u09-l03-044" to "055044",
        "qr-p5-u09-l03-045" to "055045",
        "qr-p5-u09-l03-046" to "055046",
        "qr-p5-u09-l03-047" to "055047",
        "qr-p5-u09-l03-048" to "055048",
        "qr-p5-u09-l03-049" to "055049",
        "qr-p5-u09-l03-050" to "055050",
        "qr-p5-u09-l03-051" to "055051",
        "qr-p5-u09-l03-052" to "055052",
        "qr-p5-u09-l03-053" to "055053",
        "qr-p5-u09-l03-054" to "055054",
        "qr-p5-u09-l03-055" to "055055",
        "qr-p5-u09-l03-056" to "055056",
        "qr-p5-u09-l03-057" to "055057",
        "qr-p5-u09-l03-058" to "055058",
        "qr-p5-u09-l03-059" to "055059",
        "qr-p5-u09-l03-060" to "055060",
        "qr-p5-u09-l03-061" to "055061",
        "qr-p5-u09-l03-062" to "055062",
        "qr-p5-u09-l03-063" to "055063",
        "qr-p5-u09-l03-064" to "055064",
        "qr-p5-u09-l03-065" to "055065",
        "qr-p5-u09-l03-066" to "055066",
        "qr-p5-u09-l03-067" to "055067",
        "qr-p5-u09-l03-068" to "055068",
        "qr-p5-u09-l03-069" to "055069",
        "qr-p5-u09-l03-070" to "055070",
        "qr-p5-u09-l03-071" to "055071",
        "qr-p5-u09-l03-072" to "055072",
        "qr-p5-u09-l03-073" to "055073",
        "qr-p5-u09-l03-074" to "055074",
        "qr-p5-u09-l03-075" to "055075",
        "qr-p5-u09-l03-076" to "055076",
        "qr-p5-u09-l03-077" to "055077",
        "qr-p5-u09-l03-078" to "055078",

        // Quranic Rabbana Munajat - qr-p5-u10-l02
        "qr-p5-u10-l02-001" to "002201", // Baqarah 201
        "qr-p5-u10-l02-002" to "017024", // Isra 24
        "qr-p5-u10-l02-003" to "025074", // Furqan 74
        "qr-p5-u10-l02-004" to "003008", // Ali Imran 8
        "qr-p5-u10-l02-005" to "007023", // A'raf 23
        "qr-p5-u10-l02-006" to "002286", // Baqarah 286
        "qr-p5-u10-l02-007" to "020025", // Ta-Ha 25
        "qr-p5-u10-l02-008" to "002127", // Baqarah 127
        "qr-p5-u10-l02-009" to "002250", // Baqarah 250
        "qr-p5-u10-l02-010" to "023118", // Mu'minun 118
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
