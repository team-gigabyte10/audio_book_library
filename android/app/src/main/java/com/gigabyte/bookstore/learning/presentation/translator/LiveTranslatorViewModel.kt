package com.gigabyte.bookstore.learning.presentation.translator

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.learning.data.translator.LiveTranslatorRepository
import com.gigabyte.bookstore.learning.domain.model.PlaybackStep
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.gigabyte.bookstore.learning.domain.model.Token
import com.gigabyte.bookstore.learning.domain.translator.RegionalDialectChoice
import com.gigabyte.bookstore.learning.domain.translator.SpeechCaptureState
import com.gigabyte.bookstore.learning.domain.translator.StreamingSpeechRecognizer
import com.gigabyte.bookstore.learning.domain.translator.TranslationResult
import com.gigabyte.bookstore.learning.domain.translator.TranslationSourceTier
import com.gigabyte.bookstore.learning.domain.translator.TranslatorDirection
import com.gigabyte.bookstore.learning.domain.translator.TranslatorLanguage
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

data class LiveTranslatorUiState(
    val selectedLanguage: TranslatorLanguage = TranslatorLanguage.ENGLISH,
    val selectedDialect: RegionalDialectChoice = RegionalDialectChoice.CTG,
    val direction: TranslatorDirection = TranslatorDirection.BN_TO_TARGET,
    val inputText: String = "",
    val isTranslating: Boolean = false,
    val result: TranslationResult? = null,
    val errorMessage: String? = null,
    val autoSpeak: Boolean = true,
    val history: List<TranslationResult> = emptyList()
)

class LiveTranslatorViewModel(
    application: Application,
    initialLangKey: String
) : AndroidViewModel(application) {

    private val app = application as BanglaAudiobookApp
    private val preferences = app.preferences
    private val engine = app.lessonAudio
    private val translatorRepository = LiveTranslatorRepository(app.learningRepository)
    private val speechRecognizer = StreamingSpeechRecognizer(application.applicationContext)

    val speechState: StateFlow<SpeechCaptureState> = speechRecognizer.state

    private val _uiState = MutableStateFlow(
        LiveTranslatorUiState(
            selectedLanguage = TranslatorLanguage.fromKey(initialLangKey),
            autoSpeak = preferences.learnTranslatorAutoSpeak.value,
            history = decodeHistory(preferences.learnTranslatorHistoryJson.value)
        )
    )
    val uiState: StateFlow<LiveTranslatorUiState> = _uiState.asStateFlow()

    private var translateJob: Job? = null
    private var speakJob: Job? = null

    fun selectLanguage(language: TranslatorLanguage) {
        speechRecognizer.destroy()
        _uiState.update {
            it.copy(
                selectedLanguage = language,
                result = null,
                errorMessage = null
            )
        }
        val currentText = _uiState.value.inputText
        if (currentText.isNotBlank()) {
            translateNow()
        }
    }

    fun selectDialect(dialect: RegionalDialectChoice) {
        _uiState.update { it.copy(selectedDialect = dialect, errorMessage = null) }
        val currentText = _uiState.value.inputText
        if (currentText.isNotBlank() && _uiState.value.selectedLanguage == TranslatorLanguage.REGIONAL_BANGLA) {
            translateNow()
        }
    }

    fun toggleDirection() {
        speechRecognizer.destroy()
        _uiState.update {
            val nextDir = if (it.direction == TranslatorDirection.BN_TO_TARGET) {
                TranslatorDirection.TARGET_TO_BN
            } else {
                TranslatorDirection.BN_TO_TARGET
            }
            it.copy(direction = nextDir, inputText = "", result = null, errorMessage = null)
        }
    }

    fun updateInputText(text: String) {
        speechRecognizer.resetError()
        _uiState.update { it.copy(inputText = text, errorMessage = null) }
    }

    fun translateSample(sample: String) {
        speechRecognizer.destroy()
        _uiState.update { it.copy(inputText = sample, errorMessage = null) }
        translateNow()
    }

    fun startVoiceCapture() {
        engine.stop()
        if (app.player.playbackState.value.isPlaying) app.player.pause()

        val stateSnapshot = _uiState.value
        val localeTag = if (stateSnapshot.direction == TranslatorDirection.BN_TO_TARGET) {
            "bn-BD"
        } else {
            stateSnapshot.selectedLanguage.sttLocaleTag
        }

        speechRecognizer.startListening(localeTag) { recognizedText ->
            _uiState.update { it.copy(inputText = recognizedText, errorMessage = null) }
            translateNow()
        }
    }

    fun stopVoiceCapture() {
        speechRecognizer.stopListening()
    }

    fun clearSpeechError() = speechRecognizer.resetError()

    fun translateNow() {
        val snap = _uiState.value
        val query = snap.inputText.trim()
        if (query.isEmpty()) {
            _uiState.update { it.copy(errorMessage = "অনুবাদ করার জন্য কিছু বলুন বা লিখুন।") }
            return
        }

        translateJob?.cancel()
        translateJob = viewModelScope.launch {
            _uiState.update { it.copy(isTranslating = true, errorMessage = null) }
            val outcome = translatorRepository.translate(
                inputText = query,
                language = snap.selectedLanguage,
                direction = snap.direction,
                dialect = snap.selectedDialect
            )
            outcome.onSuccess { res ->
                val updatedHistory = (listOf(res) + _uiState.value.history.filterNot {
                    it.sourceText == res.sourceText && it.languageKey == res.languageKey && it.direction == res.direction
                }).take(MAX_HISTORY_ITEMS)
                preferences.setLearnTranslatorHistoryJson(encodeHistory(updatedHistory))

                _uiState.update {
                    it.copy(
                        isTranslating = false,
                        result = res,
                        errorMessage = null,
                        history = updatedHistory
                    )
                }
                if (_uiState.value.autoSpeak) {
                    speakResult(slow = false)
                }
            }.onFailure { err ->
                _uiState.update {
                    it.copy(
                        isTranslating = false,
                        errorMessage = err.message ?: "অনুবাদ সম্পন্ন করা যায়নি।"
                    )
                }
            }
        }
    }

    fun speakResult(slow: Boolean = false) {
        val res = _uiState.value.result ?: return
        val lang = if (res.direction == TranslatorDirection.TARGET_TO_BN) {
            SpeechLang.BN
        } else {
            TranslatorLanguage.fromKey(res.languageKey).speechLang
        }
        val baseRate = when {
            slow -> 0.72f
            lang == SpeechLang.AR -> 0.85f
            else -> 0.96f
        }
        speakText(res.targetText, lang, baseRate, preferMale = lang == SpeechLang.AR)
    }

    fun speakWord(word: String) {
        val res = _uiState.value.result ?: return
        val lang = TranslatorLanguage.fromKey(res.languageKey).speechLang
        speakText(word, lang, rate = 0.82f, preferMale = lang == SpeechLang.AR)
    }

    private fun speakText(text: String, lang: SpeechLang, rate: Float, preferMale: Boolean) {
        if (text.isBlank()) return
        speakJob?.cancel()
        speakJob = viewModelScope.launch {
            engine.stop()
            engine.speakStep(
                PlaybackStep.Speak(
                    text = text,
                    lang = lang,
                    rate = rate,
                    itemIndex = 0,
                    phase = PlaybackStep.Phase.LADDER,
                    preferMale = preferMale
                )
            )
        }
    }

    fun toggleAutoSpeak() {
        val next = !_uiState.value.autoSpeak
        preferences.setLearnTranslatorAutoSpeak(next)
        _uiState.update { it.copy(autoSpeak = next) }
    }

    fun selectHistoryItem(item: TranslationResult) {
        _uiState.update {
            it.copy(
                selectedLanguage = TranslatorLanguage.fromKey(item.languageKey),
                selectedDialect = RegionalDialectChoice.fromKey(item.dialectKey),
                direction = item.direction,
                inputText = item.sourceText,
                result = item,
                errorMessage = null
            )
        }
        speakResult(slow = false)
    }

    fun clearHistory() {
        preferences.setLearnTranslatorHistoryJson("[]")
        _uiState.update { it.copy(history = emptyList()) }
    }

    override fun onCleared() {
        speechRecognizer.destroy()
        engine.stop()
        super.onCleared()
    }

    class Factory(
        private val application: Application,
        private val initialLang: String
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            LiveTranslatorViewModel(application, initialLang) as T
    }

    companion object {
        private const val MAX_HISTORY_ITEMS = 40

        internal fun encodeHistory(items: List<TranslationResult>): String = runCatching {
            val arr = JSONArray()
            for (item in items.take(MAX_HISTORY_ITEMS)) {
                val obj = JSONObject().apply {
                    put("src", item.sourceText)
                    put("dst", item.targetText)
                    put("pron", item.banglaPronunciation ?: "")
                    put("rom", item.romanization ?: "")
                    put("tip", item.grammarTipBn ?: "")
                    put("lang", item.languageKey)
                    put("dial", item.dialectKey ?: "")
                    put("dir", item.direction.name)
                    put("tier", item.sourceTier.name)
                    put("ts", item.timestampMs)
                    val tokArr = JSONArray()
                    for (t in item.wordBreakdown) {
                        tokArr.put(JSONObject().apply {
                            put("t", t.text)
                            put("bn", t.bn ?: "")
                        })
                    }
                    put("tokens", tokArr)
                }
                arr.put(obj)
            }
            arr.toString()
        }.getOrDefault("[]")

        internal fun decodeHistory(rawJson: String): List<TranslationResult> = runCatching {
            val arr = JSONArray(rawJson)
            val list = mutableListOf<TranslationResult>()
            for (i in 0 until arr.length()) {
                val obj = arr.optJSONObject(i) ?: continue
                val src = obj.optString("src", "").trim()
                val dst = obj.optString("dst", "").trim()
                if (src.isEmpty() || dst.isEmpty()) continue
                val tokList = mutableListOf<Token>()
                val tokArr = obj.optJSONArray("tokens")
                if (tokArr != null) {
                    for (j in 0 until tokArr.length()) {
                        val tObj = tokArr.optJSONObject(j) ?: continue
                        val tw = tObj.optString("t", "").trim()
                        val tb = tObj.optString("bn", "").trim().takeIf { it.isNotEmpty() }
                        if (tw.isNotEmpty()) tokList.add(Token(tw, tb))
                    }
                }
                list.add(
                    TranslationResult(
                        sourceText = src,
                        targetText = dst,
                        banglaPronunciation = obj.optString("pron", "").takeIf { it.isNotBlank() },
                        romanization = obj.optString("rom", "").takeIf { it.isNotBlank() },
                        wordBreakdown = tokList,
                        grammarTipBn = obj.optString("tip", "").takeIf { it.isNotBlank() },
                        languageKey = obj.optString("lang", "english"),
                        dialectKey = obj.optString("dial", "").takeIf { it.isNotBlank() },
                        direction = runCatching { TranslatorDirection.valueOf(obj.optString("dir")) }
                            .getOrDefault(TranslatorDirection.BN_TO_TARGET),
                        sourceTier = runCatching { TranslationSourceTier.valueOf(obj.optString("tier")) }
                            .getOrDefault(TranslationSourceTier.AI_TUTOR),
                        timestampMs = obj.optLong("ts", 0L)
                    )
                )
            }
            list
        }.getOrDefault(emptyList())
    }
}

