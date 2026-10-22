package com.gigabyte.bookstore

import android.app.Application
import com.gigabyte.bookstore.data.local.AudiobookDatabase
import com.gigabyte.bookstore.data.preferences.AppPreferences
import com.gigabyte.bookstore.data.repository.AudiobookRepository
import com.gigabyte.bookstore.data.repository.BookSyncManager
import com.gigabyte.bookstore.domain.player.AudiobookPlayer
import com.gigabyte.bookstore.domain.tts.BanglaTTSManager
import com.gigabyte.bookstore.learning.data.LearningRepository
import com.gigabyte.bookstore.learning.data.content.ContentImporter
import com.gigabyte.bookstore.learning.data.content.LearningContentLoader
import com.gigabyte.bookstore.learning.data.db.LearningDatabase
import com.gigabyte.bookstore.learning.domain.audio.TtsStepEngine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class BanglaAudiobookApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    lateinit var database: AudiobookDatabase
        private set

    lateinit var repository: AudiobookRepository
        private set

    lateinit var preferences: AppPreferences
        private set

    val appPreferences: AppPreferences
        get() = preferences


    lateinit var ttsManager: BanglaTTSManager
        private set

    lateinit var player: AudiobookPlayer
        private set

    lateinit var syncManager: BookSyncManager
        private set

    // English learning module (created on first use)
    val learningDatabase: LearningDatabase by lazy { LearningDatabase.getInstance(this) }
    val learningRepository: LearningRepository by lazy { LearningRepository(learningDatabase.learningDao()) }
    val learningContent: LearningContentLoader by lazy {
        LearningContentLoader(ContentImporter(this, learningDatabase, BuildConfig.VERSION_CODE), applicationScope)
    }
    private val lessonAudioDelegate = lazy { TtsStepEngine(this) }
    val lessonAudio: TtsStepEngine by lessonAudioDelegate

    /** Process-wide, so the Bangla voice prompt shows once per app open (cold start), not on rotation. */
    var banglaVoicePromptHandled = false

    fun refreshLessonBanglaVoice() {
        if (lessonAudioDelegate.isInitialized()) lessonAudio.refreshBangla()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        database = AudiobookDatabase.getInstance(this)
        repository = AudiobookRepository(this, database)
        preferences = AppPreferences(this)
        ttsManager = BanglaTTSManager(this, applicationScope)
        player = AudiobookPlayer(this, repository, ttsManager, preferences, applicationScope)
        syncManager = BookSyncManager(this, database, repository)

        // Purge legacy sample books if any exist so only synced books are shown
        applicationScope.launch(Dispatchers.IO) {
            repository.removeBuiltInBooksIfNeeded()
        }

        // Ensure English learning content is imported/updated on launch
        learningContent.ensureLoaded()
    }


    override fun onTerminate() {
        super.onTerminate()
        ttsManager.shutdown()
        if (lessonAudioDelegate.isInitialized()) lessonAudio.shutdown()
    }

    companion object {
        lateinit var instance: BanglaAudiobookApp
            private set
    }
}
