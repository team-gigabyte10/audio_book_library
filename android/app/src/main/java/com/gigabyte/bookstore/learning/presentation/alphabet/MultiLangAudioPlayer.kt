package com.gigabyte.bookstore.learning.presentation.alphabet

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import com.gigabyte.bookstore.data.preferences.AppPreferences
import com.gigabyte.bookstore.learning.domain.audio.JapaneseVoiceGender
import com.gigabyte.bookstore.learning.domain.audio.JapaneseVoiceManager
import com.gigabyte.bookstore.learning.domain.audio.TtsStepEngine
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import java.util.Locale
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong
import kotlin.coroutines.resume

class MultiLangAudioPlayer(context: Context) {

    private val scope = CoroutineScope(Dispatchers.Main + Job())
    private val appPreferences = AppPreferences(context)

    private val _isReady = MutableStateFlow(false)
    val isReady: StateFlow<Boolean> = _isReady.asStateFlow()

    private val _isSpeaking = MutableStateFlow(false)
    val isSpeaking: StateFlow<Boolean> = _isSpeaking.asStateFlow()

    private val _activeSpeakingId = MutableStateFlow<String?>(null)
    val activeSpeakingId: StateFlow<String?> = _activeSpeakingId.asStateFlow()

    private val pending = ConcurrentHashMap<String, () -> Unit>()
    private val counter = AtomicLong()
    private var sequenceJob: Job? = null

    private var tts: TextToSpeech? = null
    private var currentLang: SpeechLang? = null

    init {
        tts = TextToSpeech(context.applicationContext) { status ->
            if (status == TextToSpeech.SUCCESS) {
                setupEngine()
            } else {
                _isReady.value = false
            }
        }
    }

    private fun setupEngine() {
        val engine = tts ?: return
        runCatching {
            engine.setAudioAttributes(JapaneseVoiceManager.createAudioAttributes())
        }
        engine.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {
                _isSpeaking.value = true
            }

            override fun onDone(utteranceId: String?) {
                finishUtterance(utteranceId)
            }

            @Deprecated("Deprecated in Java")
            override fun onError(utteranceId: String?) {
                finishUtterance(utteranceId)
            }

            override fun onError(utteranceId: String?, errorCode: Int) {
                finishUtterance(utteranceId)
            }

            override fun onStop(utteranceId: String?, interrupted: Boolean) {
                finishUtterance(utteranceId)
            }
        })
        _isReady.value = true
    }

    private fun finishUtterance(utteranceId: String?) {
        if (utteranceId != null) {
            pending.remove(utteranceId)?.invoke()
        }
        if (pending.isEmpty() && sequenceJob?.isActive != true) {
            _isSpeaking.value = false
            _activeSpeakingId.value = null
        }
    }

    private fun setLanguage(lang: SpeechLang): Boolean {
        val engine = tts ?: return false
        if (currentLang == lang) return true

        val locales = when (lang) {
            SpeechLang.EN -> TtsStepEngine.ENGLISH_LOCALES
            SpeechLang.UR -> TtsStepEngine.URDU_LOCALES
            SpeechLang.HI -> TtsStepEngine.HINDI_LOCALES
            SpeechLang.DE -> TtsStepEngine.GERMAN_LOCALES
            SpeechLang.JA -> TtsStepEngine.JAPANESE_LOCALES
            SpeechLang.BN -> TtsStepEngine.BANGLA_LOCALES
        }

        val targetLocale = locales.firstOrNull {
            val res = engine.isLanguageAvailable(it)
            TtsStepEngine.isAvailable(res)
        } ?: locales.firstOrNull() ?: Locale.US

        val switched = runCatching { engine.language = targetLocale }.isSuccess
        if (switched) {
            currentLang = lang
            // Optimize voice pitch and select clearest voice
            if (lang == SpeechLang.JA) {
                val jaGender = JapaneseVoiceGender.fromId(appPreferences.learnJaSpeakerGender.value)
                JapaneseVoiceManager.selectBestVoice(engine, jaGender)?.let { voice ->
                    runCatching { engine.voice = voice }
                }
                engine.setPitch(JapaneseVoiceManager.getOptimizedPitch(jaGender))
            } else {
                engine.setPitch(1.0f)
            }
        }
        return switched
    }

    fun speakLetter(letter: AlphabetLetter, lang: SpeechLang, speechRate: Float = 1.0f) {
        stopSequence()
        scope.launch {
            _activeSpeakingId.value = letter.id
            val ttsText = if (lang == SpeechLang.JA) {
                JapaneseVoiceManager.formatForClearPronunciation(letter.ttsText)
            } else {
                letter.ttsText
            }
            speakInternal(ttsText, lang, speechRate)
            _activeSpeakingId.value = null
            _isSpeaking.value = false
        }
    }

    fun speakText(text: String, letterId: String? = null, lang: SpeechLang, speechRate: Float = 1.0f) {
        stopSequence()
        scope.launch {
            if (letterId != null) _activeSpeakingId.value = letterId
            speakInternal(text, lang, speechRate)
            if (letterId != null) _activeSpeakingId.value = null
            _isSpeaking.value = false
        }
    }

    fun playRowSequence(letters: List<AlphabetLetter>, lang: SpeechLang, speechRate: Float = 1.0f) {
        stopSequence()
        sequenceJob = scope.launch {
            _isSpeaking.value = true
            for (letter in letters) {
                _activeSpeakingId.value = letter.id
                val ttsText = if (lang == SpeechLang.JA) {
                    JapaneseVoiceManager.formatForClearPronunciation(letter.ttsText)
                } else {
                    letter.ttsText
                }
                speakInternal(ttsText, lang, speechRate)
                delay(400L) // pause between row letters for comprehension
            }
            _activeSpeakingId.value = null
            _isSpeaking.value = false
        }
    }

    private suspend fun speakInternal(text: String, lang: SpeechLang, rate: Float) {
        val engine = tts
        if (engine == null || !_isReady.value || text.isBlank()) return
        setLanguage(lang)
        engine.setSpeechRate(rate)

        val id = "alphabet_${counter.incrementAndGet()}"
        withTimeoutOrNull(4500L) {
            suspendCancellableCoroutine<Unit> { cont ->
                pending[id] = {
                    if (cont.isActive) cont.resume(Unit)
                }
                val res = engine.speak(text, TextToSpeech.QUEUE_FLUSH, null, id)
                if (res != TextToSpeech.SUCCESS) {
                    pending.remove(id)
                    if (cont.isActive) cont.resume(Unit)
                }
            }
        }
    }

    fun stop() {
        stopSequence()
        runCatching { tts?.stop() }
        pending.clear()
        _isSpeaking.value = false
        _activeSpeakingId.value = null
    }

    private fun stopSequence() {
        sequenceJob?.cancel()
        sequenceJob = null
    }

    fun shutdown() {
        stop()
        runCatching { tts?.shutdown() }
        tts = null
    }
}

