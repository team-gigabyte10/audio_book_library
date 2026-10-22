package com.gigabyte.bookstore.learning.presentation.part

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.learning.data.LessonSummary
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PartLessonsViewModel(application: Application, partId: String) : AndroidViewModel(application) {

    private val app = application as BanglaAudiobookApp

    /** null while loading. */
    val lessons: StateFlow<List<LessonSummary>?> = app.learningRepository.observeLessons(partId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)

    private val _part = MutableStateFlow<com.gigabyte.bookstore.learning.data.db.PartEntity?>(null)
    val part: StateFlow<com.gigabyte.bookstore.learning.data.db.PartEntity?> = _part.asStateFlow()

    private val _title = MutableStateFlow("")
    val title: StateFlow<String> = _title.asStateFlow()

    init {
        app.learningContent.ensureLoaded()
        viewModelScope.launch {
            val p = app.learningRepository.getPart(partId)
            _part.value = p
            _title.value = p?.let { it.titleBn ?: it.titleTarget }.orEmpty()
        }
    }
}
