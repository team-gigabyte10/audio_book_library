package com.gigabyte.bookstore.learning.domain.translator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed interface SpeechCaptureState {
    data object Idle : SpeechCaptureState
    data class Listening(val partialText: String = "", val rmsNormalized: Float = 0.2f) : SpeechCaptureState
    data class Completed(val finalText: String) : SpeechCaptureState
    data class Error(val messageBn: String) : SpeechCaptureState
}

/**
 * Streaming Android Speech-to-Text controller supporting live partial results (`bn-BD` and course target locales).
 */
class StreamingSpeechRecognizer(private val context: Context) {

    private val _state = MutableStateFlow<SpeechCaptureState>(SpeechCaptureState.Idle)
    val state: StateFlow<SpeechCaptureState> = _state.asStateFlow()

    private var recognizer: SpeechRecognizer? = null
    private var lastPartialText: String = ""

    fun isAvailable(): Boolean = SpeechRecognizer.isRecognitionAvailable(context)

    fun startListening(localeTag: String, onFinalText: (String) -> Unit = {}) {
        if (!isAvailable()) {
            _state.value = SpeechCaptureState.Error("এই ডিভাইসে ভয়েস-টু-টেক্সট সাপোর্ট পাওয়া যায়নি। টাইপ করে অনুবাদ করুন।")
            return
        }
        stopListeningInternal()
        lastPartialText = ""

        runCatching {
            val sr = SpeechRecognizer.createSpeechRecognizer(context)
            recognizer = sr
            sr.setRecognitionListener(object : RecognitionListener {
                override fun onReadyForSpeech(params: Bundle?) {
                    _state.value = SpeechCaptureState.Listening(partialText = lastPartialText, rmsNormalized = 0.25f)
                }

                override fun onBeginningOfSpeech() = Unit

                override fun onRmsChanged(rmsdB: Float) {
                    val current = _state.value
                    if (current is SpeechCaptureState.Listening) {
                        val norm = ((rmsdB + 2f) / 12f).coerceIn(0.1f, 1.0f)
                        _state.value = current.copy(rmsNormalized = norm)
                    }
                }

                override fun onBufferReceived(buffer: ByteArray?) = Unit
                override fun onEndOfSpeech() = Unit

                override fun onPartialResults(partialResults: Bundle?) {
                    val partial = partialResults
                        ?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                        ?.firstOrNull()
                        ?.trim()
                        .orEmpty()
                    if (partial.isNotEmpty()) {
                        lastPartialText = partial
                        val currentRms = (_state.value as? SpeechCaptureState.Listening)?.rmsNormalized ?: 0.5f
                        _state.value = SpeechCaptureState.Listening(partialText = partial, rmsNormalized = currentRms)
                    }
                }

                override fun onEvent(eventType: Int, params: Bundle?) = Unit

                override fun onError(error: Int) {
                    // If partial speech was already captured on timeout, accept it gracefully instead of throwing it away.
                    if ((error == SpeechRecognizer.ERROR_NO_MATCH || error == SpeechRecognizer.ERROR_SPEECH_TIMEOUT) &&
                        lastPartialText.isNotBlank()
                    ) {
                        val finalStr = lastPartialText
                        _state.value = SpeechCaptureState.Completed(finalStr)
                        onFinalText(finalStr)
                        return
                    }
                    _state.value = SpeechCaptureState.Error(
                        when (error) {
                            SpeechRecognizer.ERROR_NO_MATCH -> "কথা স্পষ্ট বোঝা যায়নি। মাইক্রোফোন ট্যাপ করে আবার বলুন।"
                            SpeechRecognizer.ERROR_SPEECH_TIMEOUT -> "কোনো শব্দ শোনা যায়নি। মাইক্রোফোনের কাছে পরিষ্কারভাবে বলুন।"
                            SpeechRecognizer.ERROR_AUDIO -> "মাইক্রোফোন অডিও সমস্যা। আবার চেষ্টা করুন।"
                            SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS -> "মাইক্রোফোন ব্যবহারের অনুমতি দিন।"
                            SpeechRecognizer.ERROR_NETWORK, SpeechRecognizer.ERROR_NETWORK_TIMEOUT ->
                                "ভয়েস চিনতে ইন্টারনেট বা অফলাইন ভয়েস প্যাক প্রয়োজন।"
                            else -> "স্পিচ রিকগনিশন চালু করা যায়নি। আবার চেষ্টা করুন।"
                        }
                    )
                }

                override fun onResults(results: Bundle?) {
                    val heard = results
                        ?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                        ?.firstOrNull()
                        ?.trim()
                        .orEmpty()
                        .ifEmpty { lastPartialText }
                    if (heard.isNotEmpty()) {
                        _state.value = SpeechCaptureState.Completed(heard)
                        onFinalText(heard)
                    } else {
                        _state.value = SpeechCaptureState.Error("কোনো কথা শোনা যায়নি। আবার চেষ্টা করুন।")
                    }
                }
            })

            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                putExtra(RecognizerIntent.EXTRA_LANGUAGE, localeTag)
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, localeTag)
                putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true)
                putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, context.packageName)
                putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3)
            }
            _state.value = SpeechCaptureState.Listening()
            sr.startListening(intent)
        }.onFailure {
            _state.value = SpeechCaptureState.Error("মাইক্রোফোন চালু করা যায়নি।")
        }
    }

    fun stopListening() {
        runCatching { recognizer?.stopListening() }
        if (_state.value is SpeechCaptureState.Listening && lastPartialText.isBlank()) {
            _state.value = SpeechCaptureState.Idle
        }
    }

    fun resetError() {
        if (_state.value is SpeechCaptureState.Error) {
            _state.value = SpeechCaptureState.Idle
        }
    }

    private fun stopListeningInternal() {
        runCatching {
            recognizer?.cancel()
            recognizer?.destroy()
        }
        recognizer = null
    }

    fun destroy() {
        stopListeningInternal()
        _state.value = SpeechCaptureState.Idle
    }
}
