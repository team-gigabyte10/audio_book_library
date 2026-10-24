package com.gigabyte.bookstore.learning.domain.model

/** CEFR-style levels used by the ESCB content, in ascending order. */
enum class Level {
    A0, A1, A2, B1, B2;

    companion object {
        fun parse(raw: String?): Level =
            entries.firstOrNull { it.name.equals(raw?.trim(), ignoreCase = true) } ?: A1
    }
}

enum class SpeechLang { EN, BN, JA }

/** One step of the repetition ladder (`ladder_default` in the content JSON). */
data class LadderStep(
    val play: SpeechLang? = null,
    val speed: Float = 1.0f,
    val minLevel: Level? = null,
    val pauseMs: Long = 0L
) {
    val isPause: Boolean get() = play == null

    companion object {
        /** Guideline §4 default, used when the content has no ladder. */
        val DEFAULT = listOf(
            LadderStep(SpeechLang.EN, 0.6f),
            LadderStep(SpeechLang.BN, 1.0f),
            LadderStep(SpeechLang.EN, 0.6f),
            LadderStep(SpeechLang.EN, 0.8f),
            LadderStep(SpeechLang.EN, 1.0f),
            LadderStep(SpeechLang.EN, 1.2f, minLevel = Level.B1),
            LadderStep(pauseMs = 1500L)
        )

        /** Compact storage format: `en:0.6;bn:1.0;en:1.2@B1;pause:1500`. */
        fun encode(steps: List<LadderStep>): String = steps.joinToString(";") { step ->
            if (step.isPause) {
                "pause:${step.pauseMs}"
            } else {
                val lang = when (step.play) {
                    SpeechLang.BN -> "bn"
                    SpeechLang.JA -> "ja"
                    else -> "en"
                }
                "$lang:${step.speed}" + (step.minLevel?.let { "@${it.name}" } ?: "")
            }
        }

        fun decode(raw: String?): List<LadderStep> {
            if (raw.isNullOrBlank()) return DEFAULT
            val steps = raw.split(';').mapNotNull { token ->
                val (kind, rest) = token.split(':', limit = 2).takeIf { it.size == 2 } ?: return@mapNotNull null
                when (kind) {
                    "pause" -> rest.toLongOrNull()?.let { LadderStep(pauseMs = it) }
                    "en", "bn", "ja" -> {
                        val speed = rest.substringBefore('@').toFloatOrNull() ?: return@mapNotNull null
                        val minLevel = rest.substringAfter('@', "").takeIf { it.isNotBlank() }?.let(Level::parse)
                        val playLang = when (kind) {
                            "bn" -> SpeechLang.BN
                            "ja" -> SpeechLang.JA
                            else -> SpeechLang.EN
                        }
                        LadderStep(playLang, speed, minLevel)
                    }
                    else -> null
                }
            }
            return steps.ifEmpty { DEFAULT }
        }
    }
}

data class Token(val text: String, val bn: String?)

data class LessonItem(
    val id: String,
    val conceptId: String,
    val type: String,
    val level: Level,
    val target: String,
    val bn: String?,
    val bnPron: String? = null,
    val tokens: List<Token>,
    val exampleTarget: String? = null,
    val exampleBn: String? = null,
    val speaker: String? = null
) {
    val isSentenceLike: Boolean get() = type == "sentence" || type == "dialogue_line" || type == "phrase"
}

/** Per-learner playback settings (stored in AppPreferences with a `learn_` prefix). */
data class LearnSettings(
    val bnAudio: Boolean = true,
    val wordByWord: Boolean = false,
    val gapMs: Long? = null,
    val autoAdvance: Boolean = true,
    val loopLesson: Boolean = false,
    /** How many English → Bangla pairs each item plays (1..5). */
    val repeatCount: Int = DEFAULT_REPEAT_COUNT,
    /** Continuous mode: repeat the current item non-stop until Next, Previous or Pause. */
    val repeatItem: Boolean = false
) {
    companion object {
        const val DEFAULT_REPEAT_COUNT = 3
        const val MIN_REPEAT_COUNT = 1
        const val MAX_REPEAT_COUNT = 5
    }
}

/** A single unit of work for the lesson player (Guideline §5: a queue of steps). */
sealed interface PlaybackStep {
    val itemIndex: Int

    data class Speak(
        val text: String,
        val lang: SpeechLang,
        val rate: Float,
        override val itemIndex: Int,
        val phase: Phase
    ) : PlaybackStep

    data class Pause(val ms: Long, override val itemIndex: Int) : PlaybackStep

    enum class Phase { WORD, BUILD_UP, LADDER }
}
