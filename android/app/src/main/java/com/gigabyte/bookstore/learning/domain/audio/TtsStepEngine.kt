package com.gigabyte.bookstore.learning.domain.audio

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.speech.tts.Voice
import com.gigabyte.bookstore.data.preferences.AppPreferences
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import java.util.Locale
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong
import kotlin.coroutines.resume

/** Plays one spoken step and suspends until it finishes. Lets LessonPlayer be tested with a fake. */
interface StepAudioEngine {
    /** null while the engine is still starting, then true/false. */
    val englishAvailable: StateFlow<Boolean?>
    val banglaAvailable: StateFlow<Boolean?>
    suspend fun speak(text: String, lang: SpeechLang, rate: Float)
    fun stop()
}

/**
 * On-device TTS only (no audio files, by design).
 * One TextToSpeech instance for both languages: it switches language (and voice)
 * only when a step needs a different language from the previous step.
 */
class TtsStepEngine(private val context: Context) : StepAudioEngine {

    private val appPreferences = AppPreferences(context)

    private val _englishAvailable = MutableStateFlow<Boolean?>(null)
    override val englishAvailable: StateFlow<Boolean?> = _englishAvailable.asStateFlow()

    private val _banglaAvailable = MutableStateFlow<Boolean?>(null)
    override val banglaAvailable: StateFlow<Boolean?> = _banglaAvailable.asStateFlow()

    /** Japanese only: the Japanese course shows a warning when this is false. Not part of [StepAudioEngine]. */
    private val _japaneseAvailable = MutableStateFlow<Boolean?>(null)
    val japaneseAvailable: StateFlow<Boolean?> = _japaneseAvailable.asStateFlow()

    /** Urdu only: the Urdu course shows a warning when this is false. Not part of [StepAudioEngine]. */
    private val _urduAvailable = MutableStateFlow<Boolean?>(null)
    val urduAvailable: StateFlow<Boolean?> = _urduAvailable.asStateFlow()

    /** Hindi only: the Hindi course shows a warning when this is false. Not part of [StepAudioEngine]. */
    private val _hindiAvailable = MutableStateFlow<Boolean?>(null)
    val hindiAvailable: StateFlow<Boolean?> = _hindiAvailable.asStateFlow()

    /** German only: the German course shows a warning when this is false. Not part of [StepAudioEngine]. */
    private val _germanAvailable = MutableStateFlow<Boolean?>(null)
    val germanAvailable: StateFlow<Boolean?> = _germanAvailable.asStateFlow()

    private var engine = Engine()

    override suspend fun speak(text: String, lang: SpeechLang, rate: Float) = engine.speak(text, lang, rate)

    override fun stop() = engine.stop()

    /**
     * Restarts the engine so it sees newly installed voice data,
     * e.g. after the user returns from the install-voice screen.
     */
    fun refreshBangla() {
        engine.shutdown()
        _englishAvailable.value = null
        _banglaAvailable.value = null
        _urduAvailable.value = null
        _hindiAvailable.value = null
        _germanAvailable.value = null
        engine = Engine()
    }

    fun shutdown() = engine.shutdown()

    private inner class Engine : TextToSpeech.OnInitListener {

        private val ready = CompletableDeferred<Boolean>()
        private val pending = ConcurrentHashMap<String, CancellableContinuation<Unit>>()
        private val tts: TextToSpeech = TextToSpeech(context.applicationContext, this)

        /** Resolved once at init: the locale and best offline voice for each language (null = not installed). */
        private val locales = mutableMapOf<SpeechLang, Locale>()
        private val voices = mutableMapOf<SpeechLang, Voice>()
        private var currentLang: SpeechLang? = null

        override fun onInit(status: Int) {
            if (status != TextToSpeech.SUCCESS) {
                finishInit(ok = false)
                return
            }
            runCatching {
                tts.setAudioAttributes(JapaneseVoiceManager.createAudioAttributes())
            }
            resolve(SpeechLang.EN, ENGLISH_LOCALES)
            resolve(SpeechLang.BN, BANGLA_LOCALES)
            resolve(SpeechLang.BD, BANGLA_LOCALES)
            resolve(SpeechLang.JA, JAPANESE_LOCALES)
            resolve(SpeechLang.UR, URDU_LOCALES)
            resolve(SpeechLang.HI, HINDI_LOCALES)
            resolve(SpeechLang.DE, GERMAN_LOCALES)
            tts.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) = Unit
                override fun onDone(utteranceId: String?) = complete(utteranceId)

                @Deprecated("Deprecated in Java")
                override fun onError(utteranceId: String?) = complete(utteranceId)
                override fun onError(utteranceId: String?, errorCode: Int) = complete(utteranceId)
                override fun onStop(utteranceId: String?, interrupted: Boolean) = complete(utteranceId)
            })
            finishInit(ok = true)
        }

        private fun resolve(lang: SpeechLang, candidates: List<Locale>) {
            val locale = candidates.firstOrNull { isAvailable(tts.isLanguageAvailable(it)) } ?: return
            locales[lang] = locale
            if (lang == SpeechLang.JA) {
                val gender = JapaneseVoiceGender.fromId(appPreferences.learnJaSpeakerGender.value)
                JapaneseVoiceManager.selectBestVoice(tts, gender)?.let { voices[lang] = it }
            } else {
                bestOfflineVoice(locale)?.let { voices[lang] = it }
            }
        }

        private fun finishInit(ok: Boolean) {
            _englishAvailable.value = ok && SpeechLang.EN in locales
            _banglaAvailable.value = ok && SpeechLang.BN in locales
            _japaneseAvailable.value = ok && SpeechLang.JA in locales
            _urduAvailable.value = ok && SpeechLang.UR in locales
            _hindiAvailable.value = ok && SpeechLang.HI in locales
            _germanAvailable.value = ok && SpeechLang.DE in locales
            ready.complete(ok)
        }

        private fun complete(utteranceId: String?) {
            utteranceId?.let { pending.remove(it)?.resume(Unit) }
        }

        /** Highest-quality installed voice for [locale] that works offline. */
        private fun bestOfflineVoice(locale: Locale): Voice? = runCatching {
            tts.voices.orEmpty()
                .filter { it.locale.language == locale.language && (locale.country.isEmpty() || it.locale.country == locale.country) }
                .filter { !it.isNetworkConnectionRequired }
                .filterNot { it.features.orEmpty().contains(TextToSpeech.Engine.KEY_FEATURE_NOT_INSTALLED) }
                .maxByOrNull { it.quality }
        }.getOrNull()

        /** Switches the single engine to [lang]. Returns false if that language is not installed. */
        private fun switchTo(lang: SpeechLang): Boolean {
            if (lang == currentLang) return true
            val locale = locales[lang] ?: return false
            val voice = voices[lang]
            val switched = if (voice != null) {
                runCatching { tts.voice = voice }.isSuccess || runCatching { tts.language = locale }.isSuccess
            } else {
                runCatching { tts.language = locale }.isSuccess
            }
            if (switched) currentLang = lang
            return switched
        }

        suspend fun speak(text: String, lang: SpeechLang, rate: Float) {
            if (text.isBlank() || !ready.await()) return
            if (!switchTo(lang)) return // language not installed: skip this step
            if (lang == SpeechLang.JA) {
                val jaGender = JapaneseVoiceGender.fromId(appPreferences.learnJaSpeakerGender.value)
                JapaneseVoiceManager.selectBestVoice(tts, jaGender)?.let { voice ->
                    runCatching { tts.voice = voice }
                }
                val pitch = JapaneseVoiceManager.getOptimizedPitch(jaGender)
                tts.setPitch(pitch)
            } else {
                tts.setPitch(1.0f)
            }
            tts.setSpeechRate(rate)
            // Guard against engines that never call onDone.
            val timeoutMs = 4_000L + (text.length * 150L / rate.coerceAtLeast(0.3f)).toLong()
            withTimeoutOrNull(timeoutMs) {
                suspendCancellableCoroutine { cont ->
                    val id = "learn_${counter.incrementAndGet()}"
                    pending[id] = cont
                    cont.invokeOnCancellation {
                        pending.remove(id)
                        runCatching { tts.stop() }
                    }
                    val result = tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, id)
                    if (result != TextToSpeech.SUCCESS) {
                        pending.remove(id)?.resume(Unit)
                    }
                }
            }
        }

        fun stop() {
            runCatching { tts.stop() }
            pending.keys.toList().forEach { complete(it) }
        }

        fun shutdown() {
            stop()
            runCatching { tts.shutdown() }
        }
    }

    companion object {
        private val counter = AtomicLong()
        val ENGLISH_LOCALES = listOf(Locale.US, Locale.UK, Locale.ENGLISH)
        val BANGLA_LOCALES = listOf(Locale("bn", "BD"), Locale("bn", "IN"), Locale("bn"))
        val JAPANESE_LOCALES = listOf(Locale.JAPAN, Locale.JAPANESE)
        val URDU_LOCALES = listOf(Locale("ur", "PK"), Locale("ur", "IN"), Locale("ur"))
        val HINDI_LOCALES = listOf(Locale("hi", "IN"), Locale("hi"))
        val GERMAN_LOCALES = listOf(Locale.GERMANY, Locale.GERMAN)

        fun isAvailable(result: Int) = result == TextToSpeech.LANG_AVAILABLE ||
            result == TextToSpeech.LANG_COUNTRY_AVAILABLE ||
            result == TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE
    }
}
