package com.gigabyte.bookstore.learning.presentation.quiz

import android.app.Application
import android.os.SystemClock
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.learning.data.QuizAnswer
import com.gigabyte.bookstore.learning.domain.model.LessonUnlock
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.gigabyte.bookstore.learning.domain.quiz.QuizGenerator
import com.gigabyte.bookstore.learning.domain.quiz.QuizQuestion
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class QuizUiState(
    val isLoading: Boolean = true,
    val questions: List<QuizQuestion> = emptyList(),
    val index: Int = 0,
    /** Chosen option for choice questions. */
    val selected: Int? = null,
    /** Indices into ArrangeWords.shuffled, in the order tapped. */
    val arranged: List<Int> = emptyList(),
    /** null = not answered yet. */
    val lastCorrect: Boolean? = null,
    val correctCount: Int = 0,
    val finished: Boolean = false,
    val score: Int = 0,
    val passed: Boolean = false,
    val nextLessonId: String? = null
) {
    val current: QuizQuestion? get() = questions.getOrNull(index)
}

class QuizViewModel(application: Application, private val lessonId: String) : AndroidViewModel(application) {

    private val app = application as BanglaAudiobookApp
    private val repository = app.learningRepository
    private val engine = app.lessonAudio

    private val _uiState = MutableStateFlow(QuizUiState())
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()

    private val answers = mutableListOf<QuizAnswer>()
    private var questionShownAt = 0L
    private var speakJob: Job? = null

    init {
        viewModelScope.launch {
            val content = repository.getLessonContent(lessonId)
            if (content == null) {
                _uiState.value = QuizUiState(isLoading = false, finished = true)
                return@launch
            }
            val pool = repository.getDistractorPool(content.lesson)
            val questions = QuizGenerator().generate(content.items, pool)
            if (questions.isEmpty()) {
                // Too little content to quiz on: listening to the lesson counts as completing it.
                repository.completeWithoutQuiz(lessonId)
                _uiState.value = QuizUiState(
                    isLoading = false,
                    finished = true,
                    score = 100,
                    passed = true,
                    nextLessonId = repository.getNextLessonId(content.lesson)
                )
                return@launch
            }
            _uiState.value = QuizUiState(isLoading = false, questions = questions)
            onQuestionShown()
        }
    }

    fun playPrompt() {
        val question = _uiState.value.current ?: return
        if (app.player.playbackState.value.isPlaying) app.player.pause()
        speakJob?.cancel()
        engine.stop()
        speakJob = viewModelScope.launch { engine.speak(question.item.target, SpeechLang.EN, 0.9f) }
    }

    fun selectOption(option: Int) {
        val state = _uiState.value
        if (state.lastCorrect != null) return
        val correct = when (val q = state.current) {
            is QuizQuestion.ListenPickBangla -> option == q.answerIndex
            is QuizQuestion.BanglaPickTarget -> option == q.answerIndex
            is QuizQuestion.FillBlank -> option == q.answerIndex
            else -> return
        }
        _uiState.update { it.copy(selected = option) }
        submit(correct)
    }

    fun tapWord(shuffledIndex: Int) {
        val state = _uiState.value
        if (state.lastCorrect != null || shuffledIndex in state.arranged) return
        _uiState.update { it.copy(arranged = it.arranged + shuffledIndex) }
    }

    fun removeLastWord() {
        if (_uiState.value.lastCorrect != null) return
        _uiState.update { it.copy(arranged = it.arranged.dropLast(1)) }
    }

    fun checkArrangement() {
        val state = _uiState.value
        val q = state.current as? QuizQuestion.ArrangeWords ?: return
        if (state.lastCorrect != null || state.arranged.size != q.answer.size) return
        submit(state.arranged.map { q.shuffled[it] } == q.answer)
    }

    fun next() {
        val state = _uiState.value
        if (state.lastCorrect == null) return
        if (state.index + 1 < state.questions.size) {
            _uiState.update { it.copy(index = it.index + 1, selected = null, arranged = emptyList(), lastCorrect = null) }
            onQuestionShown()
        } else {
            finish()
        }
    }

    private fun submit(correct: Boolean) {
        val question = _uiState.value.current ?: return
        answers += QuizAnswer(question.item.conceptId, correct, SystemClock.elapsedRealtime() - questionShownAt)
        _uiState.update { it.copy(lastCorrect = correct, correctCount = it.correctCount + if (correct) 1 else 0) }
        // Hearing the right answer reinforces it, whether the learner got it or not.
        playPrompt()
    }

    private fun finish() {
        viewModelScope.launch {
            val score = repository.recordQuiz(lessonId, answers.toList())
            val lesson = repository.getLessonContent(lessonId)?.lesson
            val next = lesson?.let { repository.getNextLessonId(it) }
            _uiState.update {
                it.copy(finished = true, score = score, passed = score >= LessonUnlock.PASS_SCORE, nextLessonId = next)
            }
        }
    }

    private fun onQuestionShown() {
        questionShownAt = SystemClock.elapsedRealtime()
        if (_uiState.value.current is QuizQuestion.ListenPickBangla) playPrompt()
    }

    override fun onCleared() {
        speakJob?.cancel()
        engine.stop()
        super.onCleared()
    }
}
