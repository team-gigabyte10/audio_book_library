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
    private val assetName: String = ASSET_NAME,
    private val openAsset: () -> InputStream = { context.assets.open(assetName) }
) {

    private val dao = database.learningDao()

    /** Returns true if an import ran. [onProgress] gets (lessonsImported, totalLessons or 0). */
    suspend fun ensureImported(onProgress: (Int, Int) -> Unit = { _, _ -> }): Boolean = withContext(Dispatchers.IO) {
        val meta = dao.getMeta()
        when {
            meta == null -> {
                import(onProgress)
                true
            }
            meta.appVersionCode == appVersionCode -> false
            else -> {
                // App updated: only re-import if the asset itself changed.
                val hash = hashAsset()
                if (hash == meta.contentHash) {
                    dao.upsertMeta(meta.copy(appVersionCode = appVersionCode))
                    false
                } else {
                    import(onProgress)
                    true
                }
            }
        }
    }

    private suspend fun import(onProgress: (Int, Int) -> Unit) {
        val parser = EscbJsonParser()
        database.withTransaction {
            dao.clearItems()
            dao.clearLessons()
            dao.clearParts()

            val hashing = HashingSource.sha256(openAsset().source())
            hashing.buffer().use { buffered ->
                var totalLessons = 0
                var imported = 0
                val header = parser.parse(buffered, object : EscbContentSink {
                    override suspend fun onTotalLessons(total: Int) {
                        totalLessons = total
                        onProgress(0, total)
                    }

                    override suspend fun onPart(part: PartEntity) {
                        dao.insertParts(listOf(part))
                    }

                    override suspend fun onLesson(lesson: LessonEntity, items: List<ItemEntity>) {
                        dao.insertLessons(listOf(lesson))
                        if (items.isNotEmpty()) dao.insertItems(items)
                        imported++
                        if (imported % 25 == 0 || imported == totalLessons) onProgress(imported, totalLessons)
                    }
                })
                // Drain trailing bytes so the hash covers the whole file.
                buffered.readAll(blackholeSink())

                dao.upsertMeta(
                    ContentMetaEntity(
                        schemaVersion = header.schemaVersion,
                        contentHash = hashing.hash.hex(),
                        appVersionCode = appVersionCode,
                        ladder = LadderStep.encode(header.ladder),
                        titleBn = header.titleBn,
                        titleTarget = header.titleTarget,
                        importedAt = System.currentTimeMillis()
                    )
                )
            }
        }
    }

    private fun hashAsset(): String {
        val hashing = HashingSource.sha256(openAsset().source())
        hashing.buffer().use { it.readAll(blackholeSink()) }
        return hashing.hash.hex()
    }

    companion object {
        const val ASSET_NAME = "spoken_english_foundations.json"
    }
}
