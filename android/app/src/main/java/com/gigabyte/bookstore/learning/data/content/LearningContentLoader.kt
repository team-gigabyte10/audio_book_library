package com.gigabyte.bookstore.learning.data.content

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface ContentState {
    data object Checking : ContentState
    data class Importing(val done: Int, val total: Int) : ContentState
    data object Ready : ContentState
    data class Failed(val message: String) : ContentState
}

/** Runs [ContentImporter] at most once at a time and shares its progress with every screen. */
class LearningContentLoader(
    private val importer: ContentImporter,
    private val scope: CoroutineScope
) {
    private val _state = MutableStateFlow<ContentState>(ContentState.Checking)
    val state: StateFlow<ContentState> = _state.asStateFlow()

    private var job: Job? = null

    fun ensureLoaded() {
        if (_state.value == ContentState.Ready || job?.isActive == true) return
        job = scope.launch {
            _state.value = ContentState.Checking
            _state.value = try {
                importer.ensureImported { done, total -> _state.value = ContentState.Importing(done, total) }
                ContentState.Ready
            } catch (e: Exception) {
                ContentState.Failed(e.localizedMessage ?: e.javaClass.simpleName)
            }
        }
    }
}
