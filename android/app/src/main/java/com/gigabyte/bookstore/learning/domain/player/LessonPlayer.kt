package com.gigabyte.bookstore.learning.domain.player

import com.gigabyte.bookstore.learning.domain.audio.StepAudioEngine
import com.gigabyte.bookstore.learning.domain.model.PlaybackStep
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class LessonPlayerState(
    val isPlaying: Boolean = false,
    val itemIndex: Int = 0,
    val stepIndex: Int = 0,
    val currentStep: PlaybackStep? = null,
    val isFinished: Boolean = false
)

/** Runs a queue of [PlaybackStep]s one at a time (Guideline §5). */
class LessonPlayer(
    private val engine: StepAudioEngine,
    private val scope: CoroutineScope
) {
    private val _state = MutableStateFlow(LessonPlayerState())
    val state: StateFlow<LessonPlayerState> = _state.asStateFlow()

    private var steps: List<PlaybackStep> = emptyList()
    private var position = 0
    private var job: Job? = null
    private var onceJob: Job? = null

    var autoAdvance: Boolean = true
    var loop: Boolean = false

    /** Replaces the queue and positions at the first step of [startItem]. Does not start playback. */
    fun load(newSteps: List<PlaybackStep>, startItem: Int = 0) {
        stopJob()
        steps = newSteps
        position = firstStepOf(startItem).coerceAtLeast(0)
        publish(isPlaying = false, isFinished = steps.isEmpty())
    }

    fun play() {
        if (job?.isActive == true || steps.isEmpty()) return
        onceJob?.cancel()
        onceJob = null
        if (position >= steps.size) position = 0
        publish(isPlaying = true, isFinished = false)
        job = scope.launch { runQueue() }
    }

    fun pause() {
        stopJob()
        publish(isPlaying = false)
    }

    fun togglePlayPause() = if (_state.value.isPlaying) pause() else play()

    fun nextItem() = jumpToItem(currentItem() + 1)

    fun previousItem() = jumpToItem(currentItem() - 1)

    fun jumpToItem(item: Int) {
        val target = firstStepOf(item)
        if (target < 0) return
        val wasPlaying = _state.value.isPlaying
        stopJob()
        position = target
        publish(isPlaying = false, isFinished = false)
        if (wasPlaying) play()
    }

    /** Speaks one text outside the queue (e.g. tapping a token). Pauses the queue first. */
    fun speakOnce(text: String, lang: SpeechLang, rate: Float = 0.8f) {
        pause()
        onceJob = scope.launch { engine.speak(text, lang, rate) }
    }

    fun release() {
        stopJob()
        publish(isPlaying = false)
    }

    private suspend fun runQueue() {
        while (true) {
            while (position < steps.size) {
                val step = steps[position]
                publish(isPlaying = true)
                when (step) {
                    is PlaybackStep.Speak -> engine.speak(step.text, step.lang, step.rate)
                    is PlaybackStep.Pause -> delay(step.ms)
                }
                position++
                val next = steps.getOrNull(position)
                if (!autoAdvance && next != null && next.itemIndex != step.itemIndex) {
                    publish(isPlaying = false)
                    return
                }
            }
            if (!loop) break
            position = 0
        }
        position = steps.size
        _state.update { it.copy(isPlaying = false, isFinished = true) }
    }

    private fun stopJob() {
        job?.cancel()
        job = null
        onceJob?.cancel()
        onceJob = null
        engine.stop()
    }

    private fun currentItem(): Int = steps.getOrNull(position.coerceAtMost(steps.size - 1))?.itemIndex ?: 0

    private fun firstStepOf(item: Int): Int = steps.indexOfFirst { it.itemIndex == item }

    private fun publish(isPlaying: Boolean, isFinished: Boolean? = null) {
        val step = steps.getOrNull(position.coerceAtMost(steps.size - 1))
        _state.update {
            it.copy(
                isPlaying = isPlaying,
                itemIndex = step?.itemIndex ?: 0,
                stepIndex = position,
                currentStep = if (position < steps.size) step else null,
                isFinished = isFinished ?: it.isFinished
            )
        }
    }
}
