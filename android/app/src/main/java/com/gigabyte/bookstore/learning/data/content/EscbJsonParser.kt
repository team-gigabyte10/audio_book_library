package com.gigabyte.bookstore.learning.data.content

import com.gigabyte.bookstore.learning.data.db.ItemEntity
import com.gigabyte.bookstore.learning.data.db.LessonEntity
import com.gigabyte.bookstore.learning.data.db.PartEntity
import com.gigabyte.bookstore.learning.domain.model.LadderStep
import com.gigabyte.bookstore.learning.domain.model.Level
import com.gigabyte.bookstore.learning.domain.model.SpeechLang
import com.squareup.moshi.JsonReader
import okio.BufferedSource

data class CourseHeader(
    val schemaVersion: Int,
    val titleBn: String?,
    val titleTarget: String?,
    val ladder: List<LadderStep>
)

/** Receives parsed content one lesson at a time so the whole 19 MB tree is never in memory. */
interface EscbContentSink {
    /** Called with `stats.lessons` when present, before any lesson, so the UI can show progress. */
    suspend fun onTotalLessons(total: Int) {}
    suspend fun onPart(part: PartEntity)
    suspend fun onLesson(lesson: LessonEntity, items: List<ItemEntity>)
}

/**
 * Streaming parser for ESCB-Latest-Version.json (schema_version 1).
 * Unknown fields are skipped, so the extractor can add fields without breaking the app.
 * The `audio` object is ignored on purpose: the app only uses on-device TTS.
 */
class EscbJsonParser {

    suspend fun parse(source: BufferedSource, sink: EscbContentSink): CourseHeader {
        val reader = JsonReader.of(source)
        var schemaVersion = 0
        var titleBn: String? = null
        var titleTarget: String? = null
        var ladder: List<LadderStep> = LadderStep.DEFAULT

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "schema_version" -> schemaVersion = reader.nextInt()
                "course" -> {
                    reader.beginObject()
                    while (reader.hasNext()) {
                        when (reader.nextName()) {
                            "title_bn" -> titleBn = reader.stringOrNull()
                            "title_target" -> titleTarget = reader.stringOrNull()
                            else -> reader.skipValue()
                        }
                    }
                    reader.endObject()
                }
                "ladder_default" -> ladder = readLadder(reader).ifEmpty { LadderStep.DEFAULT }
                "stats" -> {
                    reader.beginObject()
                    while (reader.hasNext()) {
                        if (reader.nextName() == "lessons") sink.onTotalLessons(reader.nextInt()) else reader.skipValue()
                    }
                    reader.endObject()
                }
                "parts" -> {
                    reader.beginArray()
                    while (reader.hasNext()) readPart(reader, sink)
                    reader.endArray()
                }
                else -> reader.skipValue()
            }
        }
        reader.endObject()
        return CourseHeader(schemaVersion, titleBn, titleTarget, ladder)
    }

    private fun readLadder(reader: JsonReader): List<LadderStep> {
        val steps = mutableListOf<LadderStep>()
        reader.beginArray()
        while (reader.hasNext()) {
            var play: String? = null
            var speed = 1.0f
            var minLevel: String? = null
            var pauseMs = 0L
            reader.beginObject()
            while (reader.hasNext()) {
                when (reader.nextName()) {
                    "play" -> play = reader.stringOrNull()
                    "speed" -> speed = reader.nextDouble().toFloat()
                    "min_level" -> minLevel = reader.stringOrNull()
                    "pause_ms" -> pauseMs = reader.nextLong()
                    else -> reader.skipValue()
                }
            }
            reader.endObject()
            val lang = when (play) {
                "target" -> SpeechLang.EN
                "bn" -> SpeechLang.BN
                else -> null
            }
            when {
                lang != null -> steps += LadderStep(lang, speed, minLevel?.let(Level::parse))
                pauseMs > 0 -> steps += LadderStep(pauseMs = pauseMs)
            }
        }
        reader.endArray()
        return steps
    }

    private suspend fun readPart(reader: JsonReader, sink: EscbContentSink) {
        var id = ""
        var order = 0
        var level = "A1"
        var titleBn: String? = null
        var titleTarget: String? = null
        var contentNeeded: String? = null

        fun part() = PartEntity(id, order, level, titleBn, titleTarget, contentNeeded)

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "id" -> id = reader.nextString()
                "order" -> order = reader.nextInt()
                "level" -> level = reader.stringOrNull() ?: level
                "title_bn" -> titleBn = reader.stringOrNull()
                "title_target" -> titleTarget = reader.stringOrNull()
                "content_needed" -> contentNeeded = reader.stringOrNull()
                "lessons" -> {
                    // Lessons reference the part, so emit the part first (fields before "lessons" are known).
                    sink.onPart(part())
                    reader.beginArray()
                    while (reader.hasNext()) readLesson(reader, id, sink)
                    reader.endArray()
                }
                else -> reader.skipValue()
            }
        }
        reader.endObject()
        // Re-emit so fields that came after "lessons" (e.g. content_needed) are stored too.
        sink.onPart(part())
    }

    private suspend fun readLesson(reader: JsonReader, partId: String, sink: EscbContentSink) {
        var id = ""
        var order = 0
        var titleBn: String? = null
        var titleTarget: String? = null
        var introBn: String? = null
        val structure = mutableListOf<String>()
        var sourceSection: String? = null
        val items = mutableListOf<ItemEntity>()

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "id" -> id = reader.nextString()
                "order" -> order = reader.nextInt()
                "title_bn" -> titleBn = reader.stringOrNull()
                "title_target" -> titleTarget = reader.stringOrNull()
                "intro_bn" -> introBn = reader.stringOrNull()
                "structure" -> {
                    reader.beginArray()
                    while (reader.hasNext()) reader.stringOrNull()?.let { structure += it }
                    reader.endArray()
                }
                "source_section" -> sourceSection = reader.stringOrNull()
                "items" -> {
                    reader.beginArray()
                    // "id" may come after "items", so lessonId is filled in once the lesson is complete.
                    while (reader.hasNext()) items += readItem(reader, items.size)
                    reader.endArray()
                }
                else -> reader.skipValue()
            }
        }
        reader.endObject()

        val lesson = LessonEntity(id, partId, order, titleBn, titleTarget, introBn, structure.joinToString("\n"), sourceSection)
        sink.onLesson(lesson, items.map { it.copy(lessonId = id) })
    }

    private fun readItem(reader: JsonReader, index: Int): ItemEntity {
        var id = ""
        var conceptId = ""
        var type = "sentence"
        var level = "A1"
        var target = ""
        var bn: String? = null
        var bnPron: String? = null
        val tokenTexts = mutableListOf<String>()
        val tokenBn = mutableListOf<String>()
        var sentenceType: String? = null
        var polarity: String? = null
        var tense: String? = null
        var question: String? = null
        var wh: String? = null
        var exampleTarget: String? = null
        var exampleBn: String? = null
        var speaker: String? = null
        var source: String? = null
        var status = "needs_review"
        val flags = mutableListOf<String>()

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "id" -> id = reader.nextString()
                "concept_id" -> conceptId = reader.stringOrNull() ?: ""
                "type" -> type = reader.stringOrNull() ?: type
                "level" -> level = reader.stringOrNull() ?: level
                "target" -> target = reader.stringOrNull() ?: ""
                "bn" -> bn = reader.stringOrNull()
                "bn_pron" -> bnPron = reader.stringOrNull()
                "tokens" -> {
                    reader.beginArray()
                    while (reader.hasNext()) {
                        var t: String? = null
                        var tBn: String? = null
                        reader.beginObject()
                        while (reader.hasNext()) {
                            when (reader.nextName()) {
                                "t" -> t = reader.stringOrNull()
                                "bn" -> tBn = reader.stringOrNull()
                                else -> reader.skipValue()
                            }
                        }
                        reader.endObject()
                        if (!t.isNullOrBlank()) {
                            tokenTexts += t.replace(ItemEntity.TOKEN_SEPARATOR, " ")
                            tokenBn += tBn?.replace(ItemEntity.TOKEN_SEPARATOR, " ") ?: ""
                        }
                    }
                    reader.endArray()
                }
                "tags" -> {
                    if (reader.peek() == JsonReader.Token.NULL) {
                        reader.nextNull<Any>()
                    } else {
                        reader.beginObject()
                        while (reader.hasNext()) {
                            when (reader.nextName()) {
                                "sentence_type" -> sentenceType = reader.stringOrNull()
                                "polarity" -> polarity = reader.stringOrNull()
                                "tense" -> tense = reader.stringOrNull()
                                "question" -> question = reader.stringOrNull()
                                "wh" -> wh = reader.stringOrNull()
                                else -> reader.skipValue()
                            }
                        }
                        reader.endObject()
                    }
                }
                "example" -> {
                    if (reader.peek() == JsonReader.Token.NULL) {
                        reader.nextNull<Any>()
                    } else {
                        reader.beginObject()
                        while (reader.hasNext()) {
                            when (reader.nextName()) {
                                "target" -> exampleTarget = reader.stringOrNull()
                                "bn" -> exampleBn = reader.stringOrNull()
                                else -> reader.skipValue()
                            }
                        }
                        reader.endObject()
                    }
                }
                "speaker" -> speaker = reader.stringOrNull()
                "source" -> source = reader.stringOrNull()
                "status" -> status = reader.stringOrNull() ?: status
                "review_flags" -> {
                    if (reader.peek() == JsonReader.Token.NULL) {
                        reader.nextNull<Any>()
                    } else {
                        reader.beginArray()
                        while (reader.hasNext()) reader.stringOrNull()?.let { flags += it }
                        reader.endArray()
                    }
                }
                else -> reader.skipValue() // includes "audio": TTS only, never used
            }
        }
        reader.endObject()

        if (tokenTexts.isEmpty() && target.isNotBlank()) {
            target.split(' ').filter { it.isNotBlank() }.forEach { tokenTexts += it; tokenBn += "" }
        }

        return ItemEntity(
            id = id,
            lessonId = "",
            order = index,
            conceptId = conceptId.ifBlank { id },
            type = type,
            level = level,
            target = target.trim(),
            bn = bn?.trim(),
            bnPron = bnPron,
            tokens = tokenTexts.joinToString(ItemEntity.TOKEN_SEPARATOR),
            tokenBn = tokenBn.joinToString(ItemEntity.TOKEN_SEPARATOR),
            sentenceType = sentenceType,
            polarity = polarity,
            tense = tense,
            question = question,
            wh = wh,
            exampleTarget = exampleTarget,
            exampleBn = exampleBn,
            speaker = speaker,
            source = source,
            status = status,
            reviewFlags = flags.joinToString(",")
        )
    }

    private fun JsonReader.stringOrNull(): String? =
        if (peek() == JsonReader.Token.NULL) nextNull<String>() else nextString()
}
