package com.gigabyte.bookstore.learning.domain.ladder

import com.gigabyte.bookstore.learning.domain.model.LadderStep
import com.gigabyte.bookstore.learning.domain.model.LearnSettings
import com.gigabyte.bookstore.learning.domain.model.LessonItem
import com.gigabyte.bookstore.learning.domain.model.PlaybackStep
import com.gigabyte.bookstore.learning.domain.model.PlaybackStep.Phase
import com.gigabyte.bookstore.learning.domain.model.SpeechLang

/** Turns lesson items + ladder + settings into the flat step queue the player runs. */
object LessonQueueBuilder {

    private const val WORD_RATE = 0.95f
    private const val BANGLA_RATE = 1.15f
    private const val QURAN_BANGLA_RATE = 0.95f
    private const val MAX_WORD_BY_WORD_TOKENS = 12

    fun buildLesson(
        items: List<LessonItem>,
        ladder: List<LadderStep>,
        settings: LearnSettings
    ): List<PlaybackStep> = items.flatMapIndexed { index, item ->
        val prev = items.getOrNull(index - 1)
        val next = items.getOrNull(index + 1)
        val inComparativeGroup = item.id.startsWith("bd-") &&
            (prev?.conceptId == item.conceptId || next?.conceptId == item.conceptId)
        if (inComparativeGroup) {
            buildComparativeRegionalItem(
                item = item,
                itemIndex = index,
                ladder = ladder,
                settings = settings,
                isGroupStart = prev?.conceptId != item.conceptId,
                isGroupEnd = next?.conceptId != item.conceptId
            )
        } else {
            buildItem(item, index, ladder, settings)
        }
    }

    private fun cleanRegionLabel(speaker: String?): String =
        speaker.orEmpty()
            .replace(Regex("[^\\u0980-\\u09FFa-zA-Z0-9\\s]"), " ")
            .replace(Regex("\\s+"), " ")
            .trim()

    private fun buildComparativeRegionalItem(
        item: LessonItem,
        itemIndex: Int,
        ladder: List<LadderStep>,
        settings: LearnSettings,
        isGroupStart: Boolean,
        isGroupEnd: Boolean
    ): List<PlaybackStep> {
        val steps = mutableListOf<PlaybackStep>()
        val targetLang = SpeechLang.BD
        val bn = item.bn?.takeIf { settings.bnAudio && it.isNotBlank() }

        // Speak Standard Bangla master sentence once at the start of the 9-region group.
        if (isGroupStart && bn != null) {
            steps += PlaybackStep.Speak(formatBnForSpeech(bn), SpeechLang.BN, 1.0f, itemIndex, Phase.LADDER)
            steps += PlaybackStep.Pause(350L, itemIndex)
        }

        if (settings.wordByWord) {
            steps += wordByWord(item, itemIndex, settings, targetLang, isQuran = false)
        }

        // Announce which region is speaking before playing the dialect repetitions.
        val regionLabel = cleanRegionLabel(item.speaker)
        if (regionLabel.isNotBlank()) {
            steps += PlaybackStep.Speak(regionLabel, SpeechLang.BD, 1.0f, itemIndex, Phase.LADDER)
            steps += PlaybackStep.Pause(250L, itemIndex)
        }

        val speeds = targetSpeeds(item, ladder, settings.repeatCount, targetLang)
        for (speed in speeds) {
            steps += PlaybackStep.Speak(item.target, targetLang, speed, itemIndex, Phase.LADDER)
        }

        val fullPauseMs = settings.gapMs ?: ladder.filter { it.isPause }.sumOf { it.pauseMs }
        val pauseMs = if (isGroupEnd) fullPauseMs else minOf(fullPauseMs, 650L)
        if (pauseMs > 0) steps += PlaybackStep.Pause(pauseMs, itemIndex)
        return steps
    }

    fun buildItem(
        item: LessonItem,
        itemIndex: Int,
        ladder: List<LadderStep>,
        settings: LearnSettings
    ): List<PlaybackStep> {
        val steps = mutableListOf<PlaybackStep>()
        val targetLang = ladder.firstOrNull { it.play != null && it.play != SpeechLang.BN }?.play ?: SpeechLang.EN
        val isQuran = item.id.startsWith("qr-") || targetLang == SpeechLang.AR
        val stepItemId = if (isQuran) item.id else null
        val bnRate = if (isQuran) QURAN_BANGLA_RATE else BANGLA_RATE
        if (settings.wordByWord) steps += wordByWord(item, itemIndex, settings, targetLang, isQuran)

        val speeds = targetSpeeds(item, ladder, settings.repeatCount, targetLang)
        val bn = item.bn?.takeIf { settings.bnAudio && it.isNotBlank() }
        val qa = splitQa(item.target, bn)

        if (qa != null) {
            // Sequential Q&A: [Target Question] -> [BN Question] -> [Target Answer] -> [BN Answer]
            for (speed in speeds) {
                steps += PlaybackStep.Speak(qa.questionEn, targetLang, speed, itemIndex, Phase.LADDER, itemId = stepItemId, preferMale = isQuran)
                if (qa.questionBn != null) {
                    steps += PlaybackStep.Speak(formatBnForSpeech(qa.questionBn), SpeechLang.BN, bnRate, itemIndex, Phase.LADDER, preferMale = isQuran)
                }
                steps += PlaybackStep.Speak(qa.answerEn, targetLang, speed, itemIndex, Phase.LADDER, itemId = stepItemId, preferMale = isQuran)
                if (qa.answerBn != null) {
                    steps += PlaybackStep.Speak(formatBnForSpeech(qa.answerBn), SpeechLang.BN, bnRate, itemIndex, Phase.LADDER, preferMale = isQuran)
                }
            }
        } else {
            // Standard single sentence Target -> BN pair
            for (speed in speeds) {
                steps += PlaybackStep.Speak(item.target, targetLang, speed, itemIndex, Phase.LADDER, itemId = stepItemId, preferMale = isQuran)
                if (bn != null) steps += PlaybackStep.Speak(formatBnForSpeech(bn), SpeechLang.BN, bnRate, itemIndex, Phase.LADDER, preferMale = isQuran)
            }
        }

        val pauseMs = settings.gapMs ?: ladder.filter { it.isPause }.sumOf { it.pauseMs }
        if (pauseMs > 0) steps += PlaybackStep.Pause(pauseMs, itemIndex)
        return steps
    }

    /** The Bangla meaning is spoken as written, with no prefix word. */
    private fun formatBnForSpeech(text: String): String = text.trim()

    internal data class QaSplit(
        val questionEn: String,
        val questionBn: String?,
        val answerEn: String,
        val answerBn: String?
    )

    internal fun splitQa(target: String, bn: String?): QaSplit? {
        val qIdx = target.indexOf('?')
        if (qIdx == -1 || qIdx >= target.length - 2) return null
        val questionEn = target.substring(0, qIdx + 1).trim()
        val answerEn = target.substring(qIdx + 1).trim()
        if (questionEn.isEmpty() || answerEn.isEmpty()) return null

        val bnIdx = bn?.indexOf('?') ?: -1
        val (questionBn, answerBn) = if (bn != null && bnIdx != -1 && bnIdx < bn.length - 1) {
            bn.substring(0, bnIdx + 1).trim() to bn.substring(bnIdx + 1).trim()
        } else {
            null to bn
        }

        return QaSplit(questionEn, questionBn, answerEn, answerBn)
    }

    /**
     * English speeds for [repeatCount] pairs, from the ladder's slowest to its normal speed
     * (0.6 → 0.8 → 1.0 for 3 repeats). Level-gated ladder steps (1.2x for B1+) add one more pair.
     */
    fun englishSpeeds(item: LessonItem, ladder: List<LadderStep>, repeatCount: Int): List<Float> =
        targetSpeeds(item, ladder, repeatCount, SpeechLang.EN)

    fun targetSpeeds(
        item: LessonItem,
        ladder: List<LadderStep>,
        repeatCount: Int,
        targetLang: SpeechLang = SpeechLang.EN
    ): List<Float> {
        val targetSteps = ladder.filter { it.play == targetLang }
        val base = targetSteps.filter { it.minLevel == null }.map { it.speed }
        val slow = base.minOrNull() ?: 0.9f
        val normal = base.maxOrNull() ?: 1.1f
        val count = repeatCount.coerceIn(LearnSettings.MIN_REPEAT_COUNT, LearnSettings.MAX_REPEAT_COUNT)

        val speeds = if (count == 1) {
            listOf(normal)
        } else {
            (0 until count).map { i -> round2(slow + (normal - slow) * i / (count - 1)) }
        }
        val extra = targetSteps.filter { step -> step.minLevel != null && item.level >= step.minLevel }.map { it.speed }
        return speeds + extra
    }

    private fun round2(value: Float): Float = Math.round(value * 100f) / 100f

    /** Each token (target → bn gloss when known), then cumulative prefixes: I → I eat → I eat rice. */
    private fun wordByWord(
        item: LessonItem,
        itemIndex: Int,
        settings: LearnSettings,
        targetLang: SpeechLang,
        isQuran: Boolean = false
    ): List<PlaybackStep> {
        val tokens = item.tokens
        if ((!item.isSentenceLike && !isQuran) || tokens.size < 2 || tokens.size > MAX_WORD_BY_WORD_TOKENS) return emptyList()

        val wordRate = if (isQuran) 0.78f else WORD_RATE
        val bnRate = if (isQuran) QURAN_BANGLA_RATE else 1.0f
        val steps = mutableListOf<PlaybackStep>()
        for (token in tokens) {
            steps += PlaybackStep.Speak(token.text, targetLang, wordRate, itemIndex, Phase.WORD, preferMale = isQuran)
            val gloss = token.bn
            if (settings.bnAudio && !gloss.isNullOrBlank()) {
                steps += PlaybackStep.Speak(gloss, SpeechLang.BN, bnRate, itemIndex, Phase.WORD, preferMale = isQuran)
            }
        }
        // The full sentence is covered by the EN → BN pairs, so build up to n-1 tokens only.
        for (end in 2 until tokens.size) {
            val prefix = tokens.subList(0, end).joinToString(" ") { it.text }
            steps += PlaybackStep.Speak(prefix, targetLang, wordRate, itemIndex, Phase.BUILD_UP, preferMale = isQuran)
        }
        return steps
    }
}
