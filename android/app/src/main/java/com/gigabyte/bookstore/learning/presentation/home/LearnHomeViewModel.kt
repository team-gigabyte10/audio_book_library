package com.gigabyte.bookstore.learning.presentation.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.learning.data.ContinueLesson
import com.gigabyte.bookstore.learning.data.PartSummary
import com.gigabyte.bookstore.learning.data.PartWithLessons
import com.gigabyte.bookstore.learning.data.content.ContentState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.json.JSONObject

class LearnHomeViewModel(application: Application) : AndroidViewModel(application) {

    private val app = application as BanglaAudiobookApp
    private val repository = app.learningRepository

    val contentState: StateFlow<ContentState> = app.learningContent.state

    val syllabus: StateFlow<List<PartWithLessons>> = repository.observeSyllabus()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    val parts: StateFlow<List<PartSummary>> = repository.observeParts()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    val continueLesson: StateFlow<ContinueLesson?> = repository.observeContinueLesson()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)

    val isSpeaking: StateFlow<Boolean> = app.ttsManager.isSpeaking

    private var hasAutoPlayedWelcome = false

    val welcomeText: String by lazy {
        loadWelcomeText()
    }

    init {
        app.learningContent.ensureLoaded()
    }

    private fun loadWelcomeText(): String {
        return try {
            app.assets.open("spoken_english_foundations.json").bufferedReader().use { reader ->
                val jsonString = reader.readText()
                val json = JSONObject(jsonString)
                val course = json.optJSONObject("course")
                course?.optString("welcome_text", "")?.takeIf { it.isNotBlank() }
            } ?: "স্পোকেন ইংলিশ মাস্টারক্লাসে আপনাকে স্বাগতম। আপনার স্পোকেন দক্ষতা বাড়াতে এই অ্যাপটির সাথে বেশি বেশি প্রাক্টিস করুন, ধন্যবাদ।"
        } catch (e: Exception) {
            "স্পোকেন ইংলিশ মাস্টারক্লাসে আপনাকে স্বাগতম। আপনার স্পোকেন দক্ষতা বাড়াতে এই অ্যাপটির সাথে বেশি বেশি প্রাক্টিস করুন, ধন্যবাদ।"
        }
    }

    fun playWelcomeGreeting(language: String = "english", force: Boolean = false) {
        if (hasAutoPlayedWelcome && !force) return
        hasAutoPlayedWelcome = true

        val text = if (language.equals("japanese", ignoreCase = true)) {
            "জাপানিজ স্পোকেন মাস্টারক্লাসে আপনাকে স্বাগতম। হিরাগানা, কাতাকানা, কাঞ্জি ও সাবলীল স্পোকেন ড্রিল বেশি বেশি অনুশীলন করুন।"
        } else {
            welcomeText
        }

        viewModelScope.launch(Dispatchers.IO) {
            delay(400) // Small delay to let screen transition settle
            app.ttsManager.speakChunk(text, 0)
        }
    }

    fun stopWelcomeGreeting() {
        app.ttsManager.stop()
    }

    override fun onCleared() {
        super.onCleared()
        stopWelcomeGreeting()
    }

    fun retry() = app.learningContent.ensureLoaded()
}

