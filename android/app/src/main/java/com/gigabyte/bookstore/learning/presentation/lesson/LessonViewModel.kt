package com.gigabyte.bookstore.learning.presentation.lesson

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.learning.data.LessonContent
import com.gigabyte.bookstore.learning.domain.ladder.LessonQueueBuilder
import com.gigabyte.bookstore.learning.domain.model.LearnSettings
import com.gigabyte.bookstore.learning.domain.model.PlaybackStep
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.gigabyte.bookstore.learning.domain.model.Token
import com.gigabyte.bookstore.learning.domain.player.LessonPlayer
import com.gigabyte.bookstore.learning.domain.player.LessonPlayerState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

enum class LessonMode { LISTEN, SPEAK }

data class LessonUiState(
    val isLoading: Boolean = true,
    val content: LessonContent? = null,
    val mode: LessonMode = LessonMode.LISTEN,
    val showIntro: Boolean = false,
    val notFound: Boolean = false
)

class LessonViewModel(application: Application, private val lessonId: String) : AndroidViewModel(application) {

    private val app = application as BanglaAudiobookApp
    private val repository = app.learningRepository
    private val preferences = app.preferences
    private val engine = app.lessonAudio
    private val player = LessonPlayer(engine, viewModelScope)

    private val _uiState = MutableStateFlow(LessonUiState())
    val uiState: StateFlow<LessonUiState> = _uiState.asStateFlow()

    val playerState: StateFlow<LessonPlayerState> = player.state
    val englishAvailable: StateFlow<Boolean?> = engine.englishAvailable
    val banglaAvailable: StateFlow<Boolean?> = engine.banglaAvailable

    val settings: StateFlow<LearnSettings> = combine(
        combine(
            preferences.learnBnAudio,
            preferences.learnWordByWord,
            preferences.learnAutoAdvance,
            preferences.learnLoopLesson
        ) { bnAudio, wordByWord, autoAdvance, loop ->
            LearnSettings(bnAudio = bnAudio, wordByWord = wordByWord, autoAdvance = autoAdvance, loopLesson = loop)
        },
        preferences.learnRepeatCount,
        preferences.learnRepeatItem
    ) { base, repeatCount, repeatItem ->
        base.copy(repeatCount = repeatCount, repeatItem = repeatItem)
    }.stateIn(viewModelScope, SharingStarted.Eagerly, LearnSettings())

    init {
        viewModelScope.launch {
            val content = repository.getLessonContent(lessonId)
            if (content == null || content.items.isEmpty()) {
                _uiState.value = LessonUiState(isLoading = false, notFound = true)
                return@launch
            }
            val startItem = repository.getLastItemIndex(lessonId).coerceIn(0, content.items.lastIndex)
            _uiState.value = LessonUiState(isLoading = false, content = content, showIntro = false)
            rebuildQueue(startItem)

            // Rebuild when settings or Bangla voice availability change, keeping the current item.
            // Continuous mode is left out: toggling it must not restart the current item.
            launch {
                combine(settings.map { it.copy(repeatItem = false) }, engine.banglaAvailable) { s, bn -> s to bn }
                    .distinctUntilChanged()
                    .drop(1)
                    .collect { rebuildQueue(player.state.value.itemIndex) }
            }
            launch {
                settings.map { it.repeatItem }.distinctUntilChanged().collect { player.repeatItem = it }
            }
            // Save the position so "Continue lesson" resumes at the same item.
            launch {
                player.state.map { it.itemIndex }.distinctUntilChanged().collect { index ->
                    repository.markInProgress(lessonId, index)
                }
            }
        }
    }

    fun start() {
        _uiState.update { it.copy(showIntro = false) }
        play()
    }

    fun togglePlayPause() {
        if (player.state.value.isPlaying) player.pause() else play()
    }

    fun next() = player.nextItem()

    fun previous() = player.previousItem()

    fun jumpTo(item: Int) = player.jumpToItem(item)

    fun setMode(mode: LessonMode) {
        if (_uiState.value.mode == mode) return
        _uiState.update { it.copy(mode = mode) }
        rebuildQueue(player.state.value.itemIndex)
    }

    fun speakToken(token: Token) = player.speakOnce(token.text, SpeechLang.EN)

    fun speakText(text: String) = player.speakOnce(text, SpeechLang.EN, rate = 1.05f)

    fun setBnAudio(enabled: Boolean) = preferences.setLearnBnAudio(enabled)
    fun setWordByWord(enabled: Boolean) = preferences.setLearnWordByWord(enabled)
    fun setAutoAdvance(enabled: Boolean) = preferences.setLearnAutoAdvance(enabled)
    fun setLoopLesson(enabled: Boolean) = preferences.setLearnLoopLesson(enabled)
    fun setRepeatCount(count: Int) = preferences.setLearnRepeatCount(
        count.coerceIn(LearnSettings.MIN_REPEAT_COUNT, LearnSettings.MAX_REPEAT_COUNT)
    )
    fun toggleRepeatItem() = preferences.setLearnRepeatItem(!settings.value.repeatItem)

    fun onFinishedListening() {
        player.pause()
    }

    private fun play() {
        // Never talk over an audiobook.
        if (app.player.playbackState.value.isPlaying) app.player.pause()
        player.play()
    }

    private fun rebuildQueue(startItem: Int) {
        val content = _uiState.value.content ?: return
        val current = settings.value
        val effective = current.copy(bnAudio = current.bnAudio && engine.banglaAvailable.value == true)
        val steps = when (_uiState.value.mode) {
            LessonMode.LISTEN -> LessonQueueBuilder.buildLesson(content.items, content.ladder, effective)
            LessonMode.SPEAK -> speakSteps(content)
        }
        val wasPlaying = player.state.value.isPlaying
        player.autoAdvance = current.autoAdvance
        player.loop = current.loopLesson
        player.repeatItem = current.repeatItem
        player.load(steps, startItem)
        if (wasPlaying) player.play()
    }

    /** Speak drill (lesson template step 5): show the Bangla, leave a gap to answer aloud, then play the answer. */
    private fun speakSteps(content: LessonContent): List<PlaybackStep> =
        content.items.flatMapIndexed { index, item ->
            listOf(
                PlaybackStep.Pause(SPEAK_GAP_MS, index),
                PlaybackStep.Speak(item.target, SpeechLang.EN, 1.0f, index, PlaybackStep.Phase.LADDER),
                PlaybackStep.Pause(1_000L, index)
            )
        }

    override fun onCleared() {
        player.release()
        super.onCleared()
    }

    companion object {
        private const val SPEAK_GAP_MS = 4_000L
    }
}
