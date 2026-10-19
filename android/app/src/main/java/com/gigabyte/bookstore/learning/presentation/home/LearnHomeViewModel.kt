package com.gigabyte.bookstore.learning.presentation.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.learning.data.ContinueLesson
import com.gigabyte.bookstore.learning.data.PartSummary
import com.gigabyte.bookstore.learning.data.PartWithLessons
import com.gigabyte.bookstore.learning.data.content.ContentState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

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

    init {
        app.learningContent.ensureLoaded()
    }

    fun retry() = app.learningContent.ensureLoaded()
}
