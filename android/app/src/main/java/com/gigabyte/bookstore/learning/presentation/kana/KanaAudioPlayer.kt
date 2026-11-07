package com.gigabyte.bookstore.learning.presentation.kana

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import com.gigabyte.bookstore.data.preferences.AppPreferences
import com.gigabyte.bookstore.learning.domain.audio.JapaneseVoiceGender
import com.gigabyte.bookstore.learning.domain.audio.JapaneseVoiceManager
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

class KanaAudioPlayer(private val context: Context) {

    private val scope = CoroutineScope(Dispatchers.Main + Job())
    private val prefs = AppPreferences(context)

    private val _isReady = MutableStateFlow(false)
    val isReady: StateFlow<Boolean> = _isReady.asStateFlow()

    private val _isSpeaking = MutableStateFlow(false)
    val isSpeaking: StateFlow<Boolean> = _isSpeaking.asStateFlow()

    private val _activeSpeakingId = MutableStateFlow<String?>(null)
    val activeSpeakingId: StateFlow<String?> = _activeSpeakingId.asStateFlow()

    private val _voiceGender = MutableStateFlow(JapaneseVoiceGender.fromId(prefs.learnJaSpeakerGender.value))
    val voiceGender: StateFlow<JapaneseVoiceGender> = _voiceGender.asStateFlow()

    private val pending = ConcurrentHashMap<String, () -> Unit>()
    private val counter = AtomicLong()
    private var sequenceJob: Job? = null

    private var tts: TextToSpeech? = null

    init {
        tts = TextToSpeech(context.applicationContext) { status ->
            if (status == TextToSpeech.SUCCESS) {
                setupJapaneseVoice()
            } else {
                _isReady.value = false
            }
        }
    }

    private fun setupJapaneseVoice() {
        val engine = tts ?: return

        // Set speech-optimized AudioAttributes so hardware speaker delivers clear voice
        runCatching {
            engine.setAudioAttributes(JapaneseVoiceManager.createAudioAttributes())
        }

        val candidates = listOf(Locale.JAPAN, Locale.JAPANESE)
        val selectedLocale = candidates.firstOrNull {
            val res = engine.isLanguageAvailable(it)
            res == TextToSpeech.LANG_AVAILABLE ||
                res == TextToSpeech.LANG_COUNTRY_AVAILABLE ||
                res == TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE
        } ?: Locale.JAPAN

        engine.language = selectedLocale

        applyVoiceAndPitch(engine)

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

    private fun applyVoiceAndPitch(engine: TextToSpeech) {
        val gender = _voiceGender.value
        val bestVoice = JapaneseVoiceManager.selectBestVoice(engine, gender)
        if (bestVoice != null) {
            runCatching { engine.voice = bestVoice }
        }

        // Set pitch: 0.97f for female removes high-frequency tinny/sibilant distortion; 1.0f for male
        val pitch = JapaneseVoiceManager.getOptimizedPitch(gender)
        engine.setPitch(pitch)
    }

    fun setVoiceGender(gender: JapaneseVoiceGender) {
        _voiceGender.value = gender
        prefs.setLearnJaSpeakerGender(gender.id)
        val engine = tts ?: return
        applyVoiceAndPitch(engine)
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

    fun speakLetter(letter: KanaLetter, speechRate: Float = 0.88f) {
        stopSequence()
        scope.launch {
            _activeSpeakingId.value = letter.id
            val formatted = JapaneseVoiceManager.formatForClearPronunciation(letter.hiragana)
            speakInternal(formatted, speechRate)
            _activeSpeakingId.value = null
            _isSpeaking.value = false
        }
    }

    fun speakText(text: String, letterId: String? = null, speechRate: Float = 0.90f) {
        stopSequence()
        scope.launch {
            if (letterId != null) _activeSpeakingId.value = letterId
            speakInternal(text, speechRate)
            if (letterId != null) _activeSpeakingId.value = null
            _isSpeaking.value = false
        }
    }

    fun playRowSequence(letters: List<KanaLetter>, speechRate: Float = 0.88f) {
        stopSequence()
        sequenceJob = scope.launch {
            _isSpeaking.value = true
            for (letter in letters) {
                _activeSpeakingId.value = letter.id
                val formatted = JapaneseVoiceManager.formatForClearPronunciation(letter.hiragana)
                speakInternal(formatted, speechRate)
                delay(400L) // Comfortable interval between row letters for learner comprehension
            }
            _activeSpeakingId.value = null
            _isSpeaking.value = false
        }
    }

    private suspend fun speakInternal(text: String, rate: Float) {
        val engine = tts
        if (engine == null || !_isReady.value || text.isBlank()) return
        engine.setSpeechRate(rate)

        val id = "kana_${counter.incrementAndGet()}"
        withTimeoutOrNull(4000L) {
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
