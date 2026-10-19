package com.gigabyte.bookstore.learning

import com.gigabyte.bookstore.learning.domain.model.LessonState
import com.gigabyte.bookstore.learning.domain.model.LessonUnlock
import com.gigabyte.bookstore.learning.domain.model.LockReason
import org.junit.Assert.assertEquals
import org.junit.Test

class LessonUnlockTest {

    @Test
    fun `without purchase only the first lesson is open`() {
        val s = LessonUnlock.compute(listOf(null, null, null), purchased = false)
        assertEquals(LessonState.AVAILABLE, s[0].state)
        assertEquals(LockReason.PURCHASE_REQUIRED, s[1].lockReason)
        assertEquals(LockReason.PURCHASE_REQUIRED, s[2].lockReason)
    }

    @Test
    fun `with purchase lessons open one by one`() {
        val s = LessonUnlock.compute(listOf("DONE", "IN_PROGRESS", null), purchased = true)
        assertEquals(LessonState.DONE, s[0].state)
        assertEquals(LessonState.IN_PROGRESS, s[1].state)
        assertEquals(LockReason.PREVIOUS_NOT_DONE, s[2].lockReason)
    }

    @Test
    fun `done lessons stay done`() {
        val s = LessonUnlock.compute(listOf("DONE", "DONE"), purchased = false)
        assertEquals(listOf(LessonState.DONE, LessonState.DONE), s.map { it.state })
    }
}
