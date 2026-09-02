package com.gigabyte.bookstore.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gigabyte.bookstore.data.local.dao.BookDao
import com.gigabyte.bookstore.data.local.dao.ChapterDao
import com.gigabyte.bookstore.data.local.dao.PlaybackHistoryDao
import com.gigabyte.bookstore.data.local.entities.BookEntity
import com.gigabyte.bookstore.data.local.entities.ChapterEntity
import com.gigabyte.bookstore.data.local.entities.PlaybackHistoryEntity

@Database(
    entities = [
        BookEntity::class,
        ChapterEntity::class,
        PlaybackHistoryEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AudiobookDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun chapterDao(): ChapterDao
    abstract fun playbackHistoryDao(): PlaybackHistoryDao

    companion object {
        @Volatile
        private var INSTANCE: AudiobookDatabase? = null

        fun getInstance(context: Context): AudiobookDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AudiobookDatabase::class.java,
                    "bangla_audiobook.db"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
