package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.domain.model.LessonState
import com.gigabyte.bookstore.learning.domain.model.LessonUnlock
import org.junit.Assert.assertEquals
import org.junit.Test

class LessonUnlockTest {

    @Test
    fun `every lesson is open and shows its saved progress`() {
        assertEquals(LessonState.AVAILABLE, LessonUnlock.stateOf(null))
        assertEquals(LessonState.IN_PROGRESS, LessonUnlock.stateOf("IN_PROGRESS"))
        assertEquals(LessonState.DONE, LessonUnlock.stateOf("DONE"))
    }

    @Test
    fun `unknown saved state falls back to available`() {
        assertEquals(LessonState.AVAILABLE, LessonUnlock.stateOf("SOMETHING_ELSE"))
    }
}
