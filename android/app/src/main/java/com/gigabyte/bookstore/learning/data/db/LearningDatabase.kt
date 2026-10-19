package com.gigabyte.bookstore.learning.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Separate from AudiobookDatabase on purpose: that one uses fallbackToDestructiveMigration,
 * which would wipe learner progress. Schema changes here need a real Migration.
 */
@Database(
    entities = [
        PartEntity::class,
        LessonEntity::class,
        ItemEntity::class,
        ContentMetaEntity::class,
        LessonProgressEntity::class,
        AttemptEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class LearningDatabase : RoomDatabase() {
    abstract fun learningDao(): LearningDao

    companion object {
        @Volatile
        private var INSTANCE: LearningDatabase? = null

        fun getInstance(context: Context): LearningDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    LearningDatabase::class.java,
                    "learning.db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
