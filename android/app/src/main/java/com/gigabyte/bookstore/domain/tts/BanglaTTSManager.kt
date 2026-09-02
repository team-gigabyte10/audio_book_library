package com.gigabyte.bookstore.domain.tts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.speech.tts.Voice
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Locale

interface TTSPlaybackListener {
    fun onChunkStarted(utteranceId: String, chunkIndex: Int)
    fun onChunkCompleted(utteranceId: String, chunkIndex: Int)
    fun onPlaybackError(utteranceId: String, errorMessage: String)
}

class BanglaTTSManager(
    private val context: Context,
    private val scope: CoroutineScope
) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null
    private var isInitialized = false
    private var activeLocale: Locale = Locale("bn", "BD")

    private val _voiceStatus = MutableStateFlow<TTSVoiceStatus>(TTSVoiceStatus.Checking)
    val voiceStatus: StateFlow<TTSVoiceStatus> = _voiceStatus.asStateFlow()

    private val _isSpeaking = MutableStateFlow(false)
    val isSpeaking: StateFlow<Boolean> = _isSpeaking.asStateFlow()

    private val _isSamplePlaying = MutableStateFlow(false)
    val isSamplePlaying: StateFlow<Boolean> = _isSamplePlaying.asStateFlow()

    private val _allVoices = MutableStateFlow<List<BanglaVoiceProfile>>(BanglaVoicePresets.PRESETS)
    val allVoices: StateFlow<List<BanglaVoiceProfile>> = _allVoices.asStateFlow()

    private val _currentVoice = MutableStateFlow<BanglaVoiceProfile>(BanglaVoicePresets.PRESETS[0])
    val currentVoice: StateFlow<BanglaVoiceProfile> = _currentVoice.asStateFlow()

    private val listeners = mutableListOf<TTSPlaybackListener>()

    private var currentSpeechRate: Float = 1.0f
    private var currentPitch: Float = 1.0f
    private var pendingChunk: Pair<String, Int>? = null

    init {
        initializeTTS()
    }

    fun addListener(listener: TTSPlaybackListener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener)
        }
    }

    fun removeListener(listener: TTSPlaybackListener) {
        listeners.remove(listener)
    }

    fun initializeTTS() {
        _voiceStatus.value = TTSVoiceStatus.Checking
        try {
            tts?.shutdown()
            tts = TextToSpeech(context.applicationContext, this)
        } catch (e: Exception) {
            _voiceStatus.value = TTSVoiceStatus.Error("TTS ইঞ্জিন শুরু করা যায়নি: ${e.localizedMessage}")
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val engineTts = tts ?: return
            isInitialized = true

            val engineName = engineTts.defaultEngine ?: "ডিফল্ট TTS ইঞ্জিন"
            val enginesList = try {
                engineTts.engines?.map { it.label ?: it.name } ?: emptyList()
            } catch (e: Exception) {
                emptyList()
            }

            // Try Locale("bn", "BD") first, then fallback to Locale("bn", "IN"), then Locale("bn")
            val bdLocale = Locale("bn", "BD")
            val inLocale = Locale("bn", "IN")
            val generalLocale = Locale("bn")

            val bdResult = engineTts.isLanguageAvailable(bdLocale)
            val isBdAvailable = bdResult == TextToSpeech.LANG_AVAILABLE ||
                    bdResult == TextToSpeech.LANG_COUNTRY_AVAILABLE ||
                    bdResult == TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE

            val inResult = engineTts.isLanguageAvailable(inLocale)
            val isInAvailable = inResult == TextToSpeech.LANG_AVAILABLE ||
                    inResult == TextToSpeech.LANG_COUNTRY_AVAILABLE ||
                    inResult == TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE

            val genResult = engineTts.isLanguageAvailable(generalLocale)
            val isGenAvailable = genResult == TextToSpeech.LANG_AVAILABLE ||
                    genResult == TextToSpeech.LANG_COUNTRY_AVAILABLE ||
                    genResult == TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE

            if (isBdAvailable) {
                activeLocale = bdLocale
            } else if (isInAvailable) {
                activeLocale = inLocale
            } else if (isGenAvailable) {
                activeLocale = generalLocale
            }

            engineTts.language = activeLocale
            engineTts.setSpeechRate(currentSpeechRate)
            engineTts.setPitch(currentPitch)
            setupProgressListener()

            // Query physical voices from TTS engine and combine with presets
            populateVoicesList(engineTts)

            if (isBdAvailable || isInAvailable || isGenAvailable) {
                _voiceStatus.value = TTSVoiceStatus.Available(
                    engineName = engineName,
                    enginePackage = engineTts.defaultEngine ?: "",
                    locale = activeLocale,
                    availableEngines = enginesList
                )
            } else {
                _voiceStatus.value = TTSVoiceStatus.Unavailable(
                    reason = "বাংলা TTS voice পাওয়া যায়নি। সেটিংস থেকে বাংলা ভয়েস ডাটা ডাউনলোড করুন।",
                    currentEngine = engineName,
                    availableEngines = enginesList
                )
            }

            // Drain any speak request queued while TTS was initializing
            val pending = pendingChunk
            if (pending != null) {
                pendingChunk = null
                speakChunk(pending.first, pending.second)
            }
        } else {
            _voiceStatus.value = TTSVoiceStatus.Error("Android TTS ইনিশিয়ালাইজেশন ব্যর্থ হয়েছে।")
        }
    }

    private fun populateVoicesList(engineTts: TextToSpeech) {
        val combinedList = mutableListOf<BanglaVoiceProfile>()

        try {
            val systemVoices = engineTts.voices
            if (!systemVoices.isNullOrEmpty()) {
                val bengaliVoices = systemVoices.filter { voice ->
                    val lang = voice.locale?.language?.lowercase()
                    lang == "bn" || lang == "ben" || voice.name.contains("bn", ignoreCase = true)
                }

                var voiceCounter = 1
                for (v in bengaliVoices) {
                    val country = v.locale?.country?.uppercase() ?: ""
                    val locationName = when (country) {
                        "BD" -> "বাংলাদেশ"
                        "IN" -> "ভারত"
                        else -> "বাংলা"
                    }
                    val isNetwork = try { v.isNetworkConnectionRequired } catch (e: Exception) { false }
                    val isFemale = v.name.contains("female", ignoreCase = true) ||
                            v.name.contains("fem", ignoreCase = true) ||
                            v.name.contains("-f-", ignoreCase = true)
                    val isMale = v.name.contains("male", ignoreCase = true) ||
                            v.name.contains("-m-", ignoreCase = true)
                    val isNeural = isNetwork || v.name.contains("neural", ignoreCase = true) || v.name.contains("hd", ignoreCase = true)

                    val typeLabel = when {
                        isFemale && isNeural -> "রিয়েল হিউম্যান নারীকণ্ঠ HD"
                        isFemale -> "নারীকণ্ঠ (Female)"
                        isMale && isNeural -> "রিয়েল হিউম্যান পুরুষকণ্ঠ HD"
                        isMale -> "পুরুষকণ্ঠ (Male)"
                        isNeural -> "রিয়েল হিউম্যান HD"
                        else -> "সিস্টেম ভয়েস"
                    }

                    val networkTag = if (isNetwork) "অনলাইন HD" else "অফলাইন লোকাল"
                    val toneType = when {
                        isFemale -> VoiceTone.FEMALE_SYSTEM
                        isMale -> VoiceTone.MALE_SYSTEM
                        isNeural -> VoiceTone.REAL_HUMAN_HD
                        else -> VoiceTone.SYSTEM_ENGINE
                    }

                    combinedList.add(
                        BanglaVoiceProfile(
                            id = "sys_${v.name}",
                            nameBangla = "$typeLabel #$voiceCounter ($locationName)",
                            subtitleBangla = "${v.name} • $networkTag",
                            description = "অ্যান্ড্রয়েড সিস্টেমের সরাসরি $typeLabel প্রোফাইল ($locationName)।",
                            tone = toneType,
                            targetPitch = 1.0f,
                            targetSpeed = 1.0f,
                            systemVoiceName = v.name,
                            systemLocaleTag = v.locale?.toLanguageTag(),
                            tag = if (isFemale) "নারীকণ্ঠ (Female)" else if (isNeural) "রিয়েল হিউম্যান HD" else "সিস্টেম $networkTag",
                            sampleText = "আমি অ্যান্ড্রয়েড সিস্টেমের সরাসরি বাংলা কণ্ঠস্বর।"
                        )
                    )
                    voiceCounter++
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        if (combinedList.isNotEmpty()) {
            _allVoices.value = combinedList
            // Automatically select HD #4 as default
            val hd4Profile = combinedList.firstOrNull { it.nameBangla.contains("#4") }
                ?: combinedList.getOrNull(3)
                ?: combinedList.firstOrNull { it.tone == VoiceTone.REAL_HUMAN_HD }
                ?: combinedList.first()

            val savedProfile = combinedList.firstOrNull { it.id == _currentVoice.value.id }
            _currentVoice.value = if (savedProfile != null && savedProfile.id != "sys_default") savedProfile else hd4Profile
        } else {
            _allVoices.value = listOf(BanglaVoicePresets.DEFAULT_SYSTEM_VOICE)
            _currentVoice.value = BanglaVoicePresets.DEFAULT_SYSTEM_VOICE
        }
    }

    private var activeUtteranceId: String? = null

    private fun setupProgressListener() {
        tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {
                if (utteranceId?.startsWith("test_") == true) {
                    _isSamplePlaying.value = true
                } else {
                    if (utteranceId != null && utteranceId == activeUtteranceId) {
                        _isSpeaking.value = true
                        val chunkIdx = parseChunkIndex(utteranceId)
                        scope.launch(Dispatchers.Main) {
                            listeners.forEach { it.onChunkStarted(utteranceId, chunkIdx) }
                        }
                    }
                }
            }

            override fun onDone(utteranceId: String?) {
                if (utteranceId?.startsWith("test_") == true) {
                    _isSamplePlaying.value = false
                    // Restore main pitch & rate
                    tts?.setPitch(currentPitch)
                    tts?.setSpeechRate(currentSpeechRate)
                } else {
                    if (utteranceId != null && utteranceId == activeUtteranceId) {
                        val chunkIdx = parseChunkIndex(utteranceId)
                        scope.launch(Dispatchers.Main) {
                            listeners.forEach { it.onChunkCompleted(utteranceId, chunkIdx) }
                        }
                    }
                }
            }

            @Deprecated("Deprecated in Java")
            override fun onError(utteranceId: String?) {
                onError(utteranceId, TextToSpeech.ERROR)
            }

            override fun onError(utteranceId: String?, errorCode: Int) {
                if (utteranceId?.startsWith("test_") == true) {
                    _isSamplePlaying.value = false
                    tts?.setPitch(currentPitch)
                    tts?.setSpeechRate(currentSpeechRate)
                } else {
                    if (utteranceId != null && utteranceId == activeUtteranceId) {
                        _isSpeaking.value = false
                        scope.launch(Dispatchers.Main) {
                            listeners.forEach { it.onPlaybackError(utteranceId, "TTS ত্রুটি (কোড: $errorCode)") }
                        }
                    }
                }
            }
        })
    }

    private fun parseChunkIndex(utteranceId: String): Int {
        return try {
            if (utteranceId.startsWith("chunk_")) {
                utteranceId.substringAfter("chunk_").substringBefore("_").toInt()
            } else {
                0
            }
        } catch (e: Exception) {
            0
        }
    }

    fun speakChunk(text: String, chunkIndex: Int): Boolean {
        val currentTts = tts
        if (currentTts == null || !isInitialized) {
            pendingChunk = Pair(text, chunkIndex)
            if (currentTts == null) {
                initializeTTS()
            }
            return false
        }

        currentTts.setPitch(currentPitch)
        currentTts.setSpeechRate(currentSpeechRate)

        val utteranceId = "chunk_${chunkIndex}_${System.currentTimeMillis()}"
        activeUtteranceId = utteranceId
        val params = Bundle().apply {
            putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, utteranceId)
        }

        var result = currentTts.speak(text, TextToSpeech.QUEUE_FLUSH, params, utteranceId)
        if (result != TextToSpeech.SUCCESS) {
            try {
                Thread.sleep(50)
            } catch (_: Exception) {}
            result = currentTts.speak(text, TextToSpeech.QUEUE_FLUSH, params, utteranceId)
        }

        if (result == TextToSpeech.SUCCESS) {
            _isSpeaking.value = true
            return true
        } else {
            pendingChunk = Pair(text, chunkIndex)
            initializeTTS()
            return false
        }
    }

    fun selectVoiceProfile(profile: BanglaVoiceProfile, applyPitchSpeed: Boolean = true) {
        _currentVoice.value = profile
        val currentTts = tts ?: return

        // 1. If profile has a specific system voice name, try setting it
        if (!profile.systemVoiceName.isNullOrBlank()) {
            try {
                val matchedVoice = currentTts.voices?.firstOrNull { it.name == profile.systemVoiceName }
                if (matchedVoice != null) {
                    currentTts.voice = matchedVoice
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        // 2. Set Pitch and Rate according to profile
        if (applyPitchSpeed) {
            currentPitch = profile.targetPitch
            currentSpeechRate = profile.targetSpeed
            currentTts.setPitch(currentPitch)
            currentTts.setSpeechRate(currentSpeechRate)
        }
    }

    fun testVoiceSample(profile: BanglaVoiceProfile) {
        val currentTts = tts ?: return
        if (!isInitialized) return

        try {
            val langResult = currentTts.setLanguage(activeLocale)
            if (langResult < TextToSpeech.LANG_AVAILABLE) {
                currentTts.setLanguage(Locale("bn"))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val utteranceId = "test_sample_${profile.id}"
        val params = Bundle().apply {
            putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, utteranceId)
        }

        // Apply physical voice if available
        if (!profile.systemVoiceName.isNullOrBlank()) {
            try {
                val matchedVoice = currentTts.voices?.firstOrNull { it.name == profile.systemVoiceName }
                if (matchedVoice != null) {
                    currentTts.voice = matchedVoice
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            try {
                if (currentTts.voice?.locale?.language?.lowercase() != activeLocale.language.lowercase()) {
                    val defaultVoice = currentTts.voices?.firstOrNull { 
                        it.locale?.language?.lowercase() == activeLocale.language.lowercase() 
                    }
                    if (defaultVoice != null) {
                        currentTts.voice = defaultVoice
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        currentTts.setPitch(profile.targetPitch)
        currentTts.setSpeechRate(profile.targetSpeed)
        _isSamplePlaying.value = true
        val speakResult = currentTts.speak(profile.sampleText, TextToSpeech.QUEUE_FLUSH, params, utteranceId)
        if (speakResult != TextToSpeech.SUCCESS) {
            _isSamplePlaying.value = false
        }
    }

    fun testBanglaVoice(sampleSentence: String = "এটি বাংলা ভাষার একটি অত্যন্ত সুস্পষ্ট পরীক্ষামূলক বাক্য।") {
        val currentTts = tts ?: return
        if (!isInitialized) return

        try {
            val langResult = currentTts.setLanguage(activeLocale)
            if (langResult < TextToSpeech.LANG_AVAILABLE) {
                currentTts.setLanguage(Locale("bn"))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val utteranceId = "test_bangla_sample"
        val params = Bundle().apply {
            putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, utteranceId)
        }
        currentTts.setPitch(currentPitch)
        currentTts.setSpeechRate(currentSpeechRate)
        _isSamplePlaying.value = true
        val speakResult = currentTts.speak(sampleSentence, TextToSpeech.QUEUE_FLUSH, params, utteranceId)
        if (speakResult != TextToSpeech.SUCCESS) {
            _isSamplePlaying.value = false
        }
    }

    fun setSpeechRate(rate: Float) {
        currentSpeechRate = rate
        tts?.setSpeechRate(rate)
    }

    fun setPitch(pitch: Float) {
        currentPitch = pitch
        tts?.setPitch(pitch)
    }

    fun stop() {
        activeUtteranceId = null
        try {
            tts?.stop()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        _isSpeaking.value = false
        _isSamplePlaying.value = false
    }

    fun openTtsSettings() {
        try {
            val intent = Intent("com.android.settings.TTS_SETTINGS").apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            try {
                val intent = Intent(android.provider.Settings.ACTION_SETTINGS).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
                context.startActivity(intent)
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }

    fun shutdown() {
        try {
            tts?.stop()
            tts?.shutdown()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        tts = null
        isInitialized = false
        _isSpeaking.value = false
        _isSamplePlaying.value = false
    }
}
