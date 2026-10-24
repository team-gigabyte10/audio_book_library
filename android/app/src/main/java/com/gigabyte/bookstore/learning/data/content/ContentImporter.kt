package com.gigabyte.bookstore.learning.data.content

import android.content.Context
import androidx.room.withTransaction
import com.gigabyte.bookstore.learning.data.db.ContentMetaEntity
import com.gigabyte.bookstore.learning.data.db.ItemEntity
import com.gigabyte.bookstore.learning.data.db.LearningDatabase
import com.gigabyte.bookstore.learning.data.db.LessonEntity
import com.gigabyte.bookstore.learning.data.db.PartEntity
import com.gigabyte.bookstore.learning.domain.model.LadderStep
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.HashingSource
import okio.blackholeSink
import okio.buffer
import okio.source
import java.io.InputStream

/**
 * Imports the bundled ESCB JSON into [LearningDatabase] (plan §1.1).
 *
 * Runs on first launch, and again only when the app was updated *and* the asset bytes changed.
 * Content tables are replaced in one transaction; progress tables are never touched.
 */
class ContentImporter(
    private val context: Context,
    private val database: LearningDatabase,
    private val appVersionCode: Int,
    private val assetNames: List<String> = ASSET_NAMES
) {

    private val dao = database.learningDao()

    /** Returns true if an import ran. [onProgress] gets (lessonsImported, totalLessons or 0). */
    suspend fun ensureImported(onProgress: (Int, Int) -> Unit = { _, _ -> }): Boolean = withContext(Dispatchers.IO) {
        val meta = dao.getMeta()
        val hash = hashAssets()
        when {
            meta == null -> {
                import(onProgress)
                true
            }
            meta.contentHash != hash -> {
                // Content asset changed: re-import content and update hash
                import(onProgress)
                true
            }
            meta.appVersionCode != appVersionCode -> {
                dao.upsertMeta(meta.copy(appVersionCode = appVersionCode))
                false
            }
            else -> false
        }
    }

    private suspend fun import(onProgress: (Int, Int) -> Unit) {
        val parser = EscbJsonParser()
        database.withTransaction {
            dao.clearItems()
            dao.clearLessons()
            dao.clearParts()

            var totalLessons = 0
            var imported = 0
            var primaryHeader: CourseHeader? = null

            for (assetName in assetNames) {
                try {
                    context.assets.open(assetName).source().buffer().use { buffered ->
                        val header = parser.parse(buffered, object : EscbContentSink {
                            override suspend fun onTotalLessons(total: Int) {
                                totalLessons += total
                                onProgress(imported, totalLessons)
                            }

                            override suspend fun onPart(part: PartEntity) {
                                dao.insertParts(listOf(part))
                            }

                            override suspend fun onLesson(lesson: LessonEntity, items: List<ItemEntity>) {
                                dao.insertLessons(listOf(lesson))
                                if (items.isNotEmpty()) dao.insertItems(items)
                                imported++
                                if (imported % 15 == 0 || imported == totalLessons) {
                                    onProgress(imported, totalLessons)
                                }
                            }
                        })
                        if (primaryHeader == null) {
                            primaryHeader = header
                        }
                    }
                } catch (e: Exception) {
                    android.util.Log.e("ContentImporter", "Failed to import $assetName", e)
                }
            }

            val hash = hashAssets()
            dao.upsertMeta(
                ContentMetaEntity(
                    schemaVersion = primaryHeader?.schemaVersion ?: 1,
                    contentHash = hash,
                    appVersionCode = appVersionCode,
                    ladder = LadderStep.encode(primaryHeader?.ladder ?: LadderStep.DEFAULT),
                    titleBn = "স্পোকেন ইংলিশ মাস্টারক্লাস",
                    titleTarget = "Spoken English Masterclass",
                    importedAt = System.currentTimeMillis()
                )
            )
        }
    }

    private fun hashAssets(): String {
        val md = java.security.MessageDigest.getInstance("SHA-256")
        for (name in assetNames) {
            try {
                context.assets.open(name).use { input ->
                    val buf = ByteArray(8192)
                    var read: Int
                    while (input.read(buf).also { read = it } != -1) {
                        md.update(buf, 0, read)
                    }
                }
            } catch (e: Exception) {
                md.update(name.toByteArray())
            }
        }
        return md.digest().joinToString("") { "%02x".format(it) }
    }

    companion object {
        const val ASSET_NAME = "spoken_english_foundations.json"
        val ASSET_NAMES = listOf(
            "spoken_english_foundations.json",
            "spoken_english_past_tense.json",
            "spoken_english_future_tense.json",
            "spoken_japanese_foundations.json",
            "spoken_japanese_past_tense.json",
            "spoken_japanese_casual_fluency.json",
            "spoken_japanese_business_advanced.json"
        )
    }
}
