package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.domain.audio.QuranAudioCatalog
import com.gigabyte.bookstore.learning.domain.audio.QuranProsodyFormatter
import com.gigabyte.bookstore.learning.domain.audio.QuranReciter
import com.gigabyte.bookstore.learning.domain.audio.QuranVoiceManager
import com.gigabyte.bookstore.learning.domain.audio.VoiceGenderClass
import com.gigabyte.bookstore.learning.domain.ladder.LessonQueueBuilder
import com.gigabyte.bookstore.learning.domain.model.LadderStep
import com.gigabyte.bookstore.learning.domain.model.LearnSettings
import com.gigabyte.bookstore.learning.domain.model.LessonItem
import com.gigabyte.bookstore.learning.domain.model.Level
import com.gigabyte.bookstore.learning.domain.model.PlaybackStep
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class QuranVoiceAndTilawatTest {

    @Test
    fun `QuranVoiceManager classifies male and female Arabic and Bangla voices`() {
        assertEquals(
            VoiceGenderClass.MALE,
            QuranVoiceManager.classifyArabicVoiceGender("ar-xa-x-arc-local", emptyList())
        )
        assertEquals(
            VoiceGenderClass.MALE,
            QuranVoiceManager.classifyArabicVoiceGender("custom-voice", listOf("gender=male"))
        )
        assertEquals(
            VoiceGenderClass.FEMALE,
            QuranVoiceManager.classifyArabicVoiceGender("ar-xa-x-arz-local", emptyList())
        )
        assertEquals(
            VoiceGenderClass.FEMALE,
            QuranVoiceManager.classifyArabicVoiceGender("ar-SA-female-network", emptyList())
        )
        assertEquals(
            VoiceGenderClass.NEUTRAL,
            QuranVoiceManager.classifyArabicVoiceGender("ar-SA-default", emptyList())
        )

        assertEquals(
            VoiceGenderClass.MALE,
            QuranVoiceManager.classifyBanglaVoiceGender("bn-bd-x-bnm-local", emptyList())
        )
        assertEquals(
            VoiceGenderClass.FEMALE,
            QuranVoiceManager.classifyBanglaVoiceGender("bn-bd-x-bnf-local", emptyList())
        )
    }

    @Test
    fun `QuranVoiceManager applies deeper pitch compensation when no verified male voice exists`() {
        assertTrue(QuranVoiceManager.getArabicQariPitch(isVerifiedMale = false) < QuranVoiceManager.getArabicQariPitch(isVerifiedMale = true))
        assertTrue(QuranVoiceManager.getBanglaInstructorPitch(isVerifiedMale = false) < QuranVoiceManager.getBanglaInstructorPitch(isVerifiedMale = true))
        assertEquals(QuranReciter.HUSARY_MUALLIM, QuranReciter.fromId(null))
        assertEquals(QuranReciter.ALAFASY, QuranReciter.fromId("alafasy"))
    }

    @Test
    fun `QuranProsodyFormatter expands isolated letters, Tatweel shapes, and Uthmani dagger alif`() {
        assertEquals("أَلِفْ", QuranProsodyFormatter.formatForTilawat("أ"))
        assertEquals("بَاءْ", QuranProsodyFormatter.formatForTilawat("ب"))
        assertEquals("بَاءْ", QuranProsodyFormatter.formatForTilawat("بـ"))
        assertEquals("هَاءْ", QuranProsodyFormatter.formatForTilawat("هـ"))
        assertEquals("لَامْ أَلِفْ", QuranProsodyFormatter.formatForTilawat("لا"))

        assertEquals(
            "أَلِفْ، بَاءْ، تَاءْ، ثَاءْ",
            QuranProsodyFormatter.formatForTilawat("أ ب ت ث")
        )

        assertEquals("الرَّحْمَانِ", QuranProsodyFormatter.formatForTilawat("الرَّحْمَٰنِ"))
        assertEquals("إِلَاهِ", QuranProsodyFormatter.formatForTilawat("إِلَٰهِ"))
        assertEquals("بَ،", QuranProsodyFormatter.formatForTilawat("بَ"))
    }

    @Test
    fun `QuranAudioCatalog maps full Ayahs cleanly and excludes Qaida and half verses`() {
        assertEquals("001001", QuranAudioCatalog.audioRefForItem("qr-p4-u07-l01-001"))
        assertEquals("112001", QuranAudioCatalog.audioRefForItem("qr-p4-u07-l02-001"))
        assertEquals("113005", QuranAudioCatalog.audioRefForItem("qr-p4-u07-l03-005"))
        assertEquals("114006", QuranAudioCatalog.audioRefForItem("qr-p4-u07-l04-006"))
        assertEquals("108001", QuranAudioCatalog.audioRefForItem("qr-p4-u08-l01-001"))
        assertEquals("109006", QuranAudioCatalog.audioRefForItem("qr-p4-u08-l03-008"))

        // Half-verse split items and Qaida items must stay on matching TTS rather than full-Ayah MP3
        assertNull(QuranAudioCatalog.audioRefForItem("qr-p4-u07-l01-007"))
        assertNull(QuranAudioCatalog.audioRefForItem("qr-p1-u01-l01-001"))

        assertEquals(
            listOf("001001", "001002", "001003", "001004", "001005", "001006"),
            QuranAudioCatalog.audioRefsForLesson("qr-p4-u07-l01")
        )
        assertEquals(
            "https://everyayah.com/data/Husary_Muallim_128kbps/001001.mp3",
            QuranAudioCatalog.buildEveryAyahUrl(QuranReciter.HUSARY_MUALLIM, "001001")
        )
    }

    @Test
    fun `LessonQueueBuilder marks Quran steps preferMale and calm Bangla rate without affecting English`() {
        val qrItem = LessonItem(
            id = "qr-p4-u07-l01-001",
            conceptId = "c-qr-p4-u07-l01-001",
            type = "quran_verse",
            level = Level.A1,
            target = "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ",
            bn = "পরম করুণাময় আল্লাহর নামে।",
            tokens = emptyList()
        )
        val qrLadder = listOf(
            LadderStep(SpeechLang.AR, 0.72f),
            LadderStep(SpeechLang.BN, 0.95f),
            LadderStep(SpeechLang.AR, 0.88f),
            LadderStep(pauseMs = 2000L)
        )
        val qrSteps = LessonQueueBuilder.buildItem(qrItem, 0, qrLadder, LearnSettings(repeatCount = 2))
            .filterIsInstance<PlaybackStep.Speak>()

        assertTrue(qrSteps.isNotEmpty())
        assertTrue(qrSteps.all { it.preferMale })
        assertEquals("qr-p4-u07-l01-001", qrSteps.first { it.lang == SpeechLang.AR }.itemId)
        assertEquals(0.95f, qrSteps.first { it.lang == SpeechLang.BN }.rate)

        val enItem = LessonItem(
            id = "en-a1-01-l01-001",
            conceptId = "c-en-a1-01-l01-001",
            type = "sentence",
            level = Level.A1,
            target = "Hello!",
            bn = "হ্যালো!",
            tokens = emptyList()
        )
        val enSteps = LessonQueueBuilder.buildItem(enItem, 0, LadderStep.DEFAULT, LearnSettings(repeatCount = 2))
            .filterIsInstance<PlaybackStep.Speak>()
        assertFalse(enSteps.any { it.preferMale })
        assertTrue(enSteps.all { it.itemId == null })
    }
}
