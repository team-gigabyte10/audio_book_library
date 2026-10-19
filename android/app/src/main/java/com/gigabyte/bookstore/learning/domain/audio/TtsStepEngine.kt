package com.gigabyte.bookstore.learning.domain.audio

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.speech.tts.Voice
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
 * Two TextToSpeech instances so alternating EN ↔ BN never calls setLanguage per step.
 */
class TtsStepEngine(private val context: Context) : StepAudioEngine {

    private val _englishAvailable = MutableStateFlow<Boolean?>(null)
    override val englishAvailable: StateFlow<Boolean?> = _englishAvailable.asStateFlow()

    private val _banglaAvailable = MutableStateFlow<Boolean?>(null)
    override val banglaAvailable: StateFlow<Boolean?> = _banglaAvailable.asStateFlow()

    private var english = Engine(listOf(Locale.US, Locale.UK, Locale.ENGLISH), _englishAvailable)
    private var bangla = Engine(BANGLA_LOCALES, _banglaAvailable)

    override suspend fun speak(text: String, lang: SpeechLang, rate: Float) {
        val engine = if (lang == SpeechLang.EN) english else bangla
        engine.speak(text, rate)
    }

    override fun stop() {
        english.stop()
        bangla.stop()
    }

    /** Re-checks the Bangla voice, e.g. after the user returns from the install-voice screen. */
    fun refreshBangla() {
        bangla.shutdown()
        _banglaAvailable.value = null
        bangla = Engine(BANGLA_LOCALES, _banglaAvailable)
    }

    fun shutdown() {
        english.shutdown()
        bangla.shutdown()
    }

    private inner class Engine(
        private val locales: List<Locale>,
        private val available: MutableStateFlow<Boolean?>
    ) : TextToSpeech.OnInitListener {

        private val ready = CompletableDeferred<Boolean>()
        private val pending = ConcurrentHashMap<String, CancellableContinuation<Unit>>()
        private val tts: TextToSpeech = TextToSpeech(context.applicationContext, this)

        override fun onInit(status: Int) {
            if (status != TextToSpeech.SUCCESS) {
                finishInit(false)
                return
            }
            val locale = locales.firstOrNull { isAvailable(tts.isLanguageAvailable(it)) }
            if (locale == null) {
                finishInit(false)
                return
            }
            tts.language = locale
            bestOfflineVoice(locale)?.let { voice -> runCatching { tts.voice = voice } }
            tts.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) = Unit
                override fun onDone(utteranceId: String?) = complete(utteranceId)

                @Deprecated("Deprecated in Java")
                override fun onError(utteranceId: String?) = complete(utteranceId)
                override fun onError(utteranceId: String?, errorCode: Int) = complete(utteranceId)
                override fun onStop(utteranceId: String?, interrupted: Boolean) = complete(utteranceId)
            })
            finishInit(true)
        }

        private fun finishInit(ok: Boolean) {
            available.value = ok
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

        suspend fun speak(text: String, rate: Float) {
            if (text.isBlank() || !ready.await()) return
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
        val BANGLA_LOCALES = listOf(Locale("bn", "BD"), Locale("bn", "IN"), Locale("bn"))

        fun isAvailable(result: Int) = result == TextToSpeech.LANG_AVAILABLE ||
            result == TextToSpeech.LANG_COUNTRY_AVAILABLE ||
            result == TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE
    }
}
