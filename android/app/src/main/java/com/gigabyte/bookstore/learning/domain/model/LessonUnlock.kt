package com.gigabyte.bookstore.learning.domain.model

enum class LessonState { LOCKED, AVAILABLE, IN_PROGRESS, DONE }

enum class LockReason { NONE, PREVIOUS_NOT_DONE, PURCHASE_REQUIRED }

data class LessonStatus(val state: LessonState, val lockReason: LockReason, val isFree: Boolean)

/**
 * Unlock rules:
 * - Only parts in [ENABLED_PARTS] are playable (cleanest data; plan §3 Phase 1).
 * - Lessons with fewer than [MIN_VISIBLE_ITEMS] items after the quality gate are hidden.
 * - The first lesson of each part is free; the rest need the `english_course` bundle.
 * - A lesson opens when the previous one is DONE (quiz score >= [PASS_SCORE]).
 */
object LessonUnlock {
    val ENABLED_PARTS = setOf(1, 2, 3, 4)
    const val MIN_VISIBLE_ITEMS = 3
    const val PASS_SCORE = 70
    const val BUNDLE_ID = "english_course"

    /** [progressStates] is the saved state per lesson in order (null = never opened). */
    fun compute(progressStates: List<String?>, purchased: Boolean): List<LessonStatus> {
        return progressStates.mapIndexed { index, saved ->
            val isFree = index == 0
            val done = saved == STATE_DONE
            val previousDone = index == 0 || progressStates[index - 1] == STATE_DONE
            when {
                done -> LessonStatus(LessonState.DONE, LockReason.NONE, isFree)
                !isFree && !purchased -> LessonStatus(LessonState.LOCKED, LockReason.PURCHASE_REQUIRED, isFree)
                !previousDone -> LessonStatus(LessonState.LOCKED, LockReason.PREVIOUS_NOT_DONE, isFree)
                saved == STATE_IN_PROGRESS -> LessonStatus(LessonState.IN_PROGRESS, LockReason.NONE, isFree)
                else -> LessonStatus(LessonState.AVAILABLE, LockReason.NONE, isFree)
            }
        }
    }

    const val STATE_IN_PROGRESS = "IN_PROGRESS"
    const val STATE_DONE = "DONE"
}
