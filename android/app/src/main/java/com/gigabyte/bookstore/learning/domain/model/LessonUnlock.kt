package com.gigabyte.bookstore.learning.domain.model

enum class LessonState { AVAILABLE, IN_PROGRESS, DONE }

/**
 * Lesson rules. Every lesson is open: no purchase gate and no required order.
 * - Lessons with fewer than [MIN_VISIBLE_ITEMS] items after the quality gate are hidden.
 * - A quiz score >= [PASS_SCORE] marks a lesson DONE.
 */
object LessonUnlock {
    const val MIN_VISIBLE_ITEMS = 3
    const val PASS_SCORE = 70

    const val STATE_IN_PROGRESS = "IN_PROGRESS"
    const val STATE_DONE = "DONE"

    /** Maps a saved progress state (null = never opened) to what the lesson list shows. */
    fun stateOf(saved: String?): LessonState = when (saved) {
        STATE_DONE -> LessonState.DONE
        STATE_IN_PROGRESS -> LessonState.IN_PROGRESS
        else -> LessonState.AVAILABLE
    }
}
