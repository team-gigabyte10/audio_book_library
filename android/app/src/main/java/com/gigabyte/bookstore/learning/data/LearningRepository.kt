package com.gigabyte.bookstore.learning.data

import com.gigabyte.bookstore.learning.data.db.AttemptEntity
import com.gigabyte.bookstore.learning.data.db.ItemEntity
import com.gigabyte.bookstore.learning.data.db.LearningDao
import com.gigabyte.bookstore.learning.data.db.LessonEntity
import com.gigabyte.bookstore.learning.data.db.LessonProgressEntity
import com.gigabyte.bookstore.learning.domain.model.LadderStep
import com.gigabyte.bookstore.learning.domain.model.LessonItem
import com.gigabyte.bookstore.learning.domain.model.LessonState
import com.gigabyte.bookstore.learning.domain.model.LessonUnlock
import com.gigabyte.bookstore.learning.domain.model.Level
import com.gigabyte.bookstore.learning.domain.model.Token
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

data class PartSummary(
    val id: String,
    val order: Int,
    val level: String,
    val titleBn: String?,
    val titleTarget: String?,
    val lessonCount: Int,
    val isEnabled: Boolean
)

data class LessonSummary(
    val id: String,
    val order: Int,
    val titleBn: String?,
    val titleTarget: String?,
    val itemCount: Int,
    val bestScore: Int,
    val state: LessonState
)

data class LessonContent(
    val lesson: LessonEntity,
    val items: List<LessonItem>,
    val ladder: List<LadderStep>
) {
    val structure: List<String> get() = lesson.structure.split('\n').filter { it.isNotBlank() }
}

data class QuizAnswer(val conceptId: String, val correct: Boolean, val latencyMs: Long)

class LearningRepository(private val dao: LearningDao) {

    fun observeParts(): Flow<List<PartSummary>> = dao.observeParts().map { rows ->
        rows.map { row ->
            PartSummary(
                id = row.part.id,
                order = row.part.order,
                level = row.part.level,
                titleBn = row.part.titleBn,
                titleTarget = row.part.titleTarget,
                lessonCount = row.lessonCount,
                // Every part with at least one visible lesson is open (Part 0 has no content yet).
                isEnabled = row.lessonCount > 0
            )
        }
    }

    /** Lessons of a part that pass the quality gate, with their progress. Re-emits when progress changes. */
    fun observeLessons(partId: String): Flow<List<LessonSummary>> =
        dao.observeProgress().map { progress ->
            val byLesson = progress.associateBy { it.lessonId }
            dao.getLessonsWithCount(partId)
                .filter { it.visibleCount >= LessonUnlock.MIN_VISIBLE_ITEMS }
                .map { row ->
                    val saved = byLesson[row.lesson.id]
                    LessonSummary(
                        id = row.lesson.id,
                        order = row.lesson.order,
                        titleBn = row.lesson.titleBn,
                        titleTarget = row.lesson.titleTarget,
                        itemCount = row.visibleCount,
                        bestScore = saved?.bestScore ?: 0,
                        state = LessonUnlock.stateOf(saved?.state)
                    )
                }
        }

    suspend fun getPartTitle(partId: String): String? = dao.getPart(partId)?.let { it.titleBn ?: it.titleTarget }

    suspend fun getLessonContent(lessonId: String): LessonContent? {
        val lesson = dao.getLesson(lessonId) ?: return null
        val ladder = LadderStep.decode(dao.getMeta()?.ladder)
        return LessonContent(lesson, dao.getVisibleItems(lessonId).map { it.toLessonItem() }, ladder)
    }

    suspend fun getDistractorPool(lesson: LessonEntity): List<LessonItem> =
        dao.getDistractorPool(lesson.partId, lesson.id, DISTRACTOR_POOL_SIZE).map { it.toLessonItem() }

    /** The next lesson in the same part that passes the quality gate, if any. */
    suspend fun getNextLessonId(lesson: LessonEntity): String? {
        val lessons = dao.getLessonsWithCount(lesson.partId).filter { it.visibleCount >= LessonUnlock.MIN_VISIBLE_ITEMS }
        val index = lessons.indexOfFirst { it.lesson.id == lesson.id }
        return lessons.getOrNull(index + 1)?.lesson?.id
    }

    suspend fun markInProgress(lessonId: String, itemIndex: Int) {
        val existing = dao.getProgress(lessonId)
        if (existing?.state == LessonProgressEntity.STATE_DONE) {
            dao.upsertProgress(existing.copy(lastItemIndex = itemIndex, updatedAt = now()))
            return
        }
        dao.upsertProgress(
            LessonProgressEntity(
                lessonId = lessonId,
                state = LessonProgressEntity.STATE_IN_PROGRESS,
                bestScore = existing?.bestScore ?: 0,
                lastItemIndex = itemIndex,
                updatedAt = now()
            )
        )
    }

    suspend fun getLastItemIndex(lessonId: String): Int = dao.getProgress(lessonId)?.lastItemIndex ?: 0

    /** Saves quiz attempts and returns the score (0–100). A score >= PASS_SCORE marks the lesson DONE. */
    suspend fun recordQuiz(lessonId: String, answers: List<QuizAnswer>): Int {
        if (answers.isEmpty()) return 0
        val at = now()
        dao.insertAttempts(answers.map { AttemptEntity(conceptId = it.conceptId, lessonId = lessonId, kind = "QUIZ", correct = it.correct, latencyMs = it.latencyMs, at = at) })
        val score = answers.count { it.correct } * 100 / answers.size
        val existing = dao.getProgress(lessonId)
        val passed = score >= LessonUnlock.PASS_SCORE || existing?.state == LessonProgressEntity.STATE_DONE
        dao.upsertProgress(
            LessonProgressEntity(
                lessonId = lessonId,
                state = if (passed) LessonProgressEntity.STATE_DONE else LessonProgressEntity.STATE_IN_PROGRESS,
                bestScore = maxOf(score, existing?.bestScore ?: 0),
                lastItemIndex = existing?.lastItemIndex ?: 0,
                updatedAt = at
            )
        )
        return score
    }

    /** For lessons too small to build a quiz from: finishing the listening counts as done. */
    suspend fun completeWithoutQuiz(lessonId: String) {
        val existing = dao.getProgress(lessonId)
        dao.upsertProgress(
            LessonProgressEntity(
                lessonId = lessonId,
                state = LessonProgressEntity.STATE_DONE,
                bestScore = existing?.bestScore ?: 0,
                lastItemIndex = existing?.lastItemIndex ?: 0,
                updatedAt = now()
            )
        )
    }

    /** Most recently touched lesson, for "Continue lesson" on the learning home. */
    fun observeContinueLesson(): Flow<ContinueLesson?> = dao.observeLastProgress().map { progress ->
        val lesson = progress?.let { dao.getLesson(it.lessonId) } ?: return@map null
        ContinueLesson(lesson.id, lesson.titleBn ?: lesson.titleTarget ?: lesson.id, progress.state == LessonProgressEntity.STATE_DONE)
    }

    private fun now() = System.currentTimeMillis()

    companion object {
        private const val DISTRACTOR_POOL_SIZE = 40
    }
}

data class ContinueLesson(val lessonId: String, val title: String, val isDone: Boolean)

fun ItemEntity.toLessonItem(): LessonItem {
    val texts = if (tokens.isEmpty()) emptyList() else tokens.split(ItemEntity.TOKEN_SEPARATOR)
    val glosses = if (tokenBn.isEmpty()) emptyList() else tokenBn.split(ItemEntity.TOKEN_SEPARATOR)
    return LessonItem(
        id = id,
        conceptId = conceptId,
        type = type,
        level = Level.parse(level),
        target = target,
        bn = bn,
        tokens = texts.mapIndexed { i, t -> Token(t, glosses.getOrNull(i)?.takeIf { it.isNotBlank() }) },
        exampleTarget = exampleTarget,
        exampleBn = exampleBn,
        speaker = speaker
    )
}
