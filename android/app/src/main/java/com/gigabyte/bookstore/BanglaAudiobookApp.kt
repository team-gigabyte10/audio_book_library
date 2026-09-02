package com.gigabyte.bookstore

import android.app.Application
import com.gigabyte.bookstore.data.local.AudiobookDatabase
import com.gigabyte.bookstore.data.preferences.AppPreferences
import com.gigabyte.bookstore.data.repository.AudiobookRepository
import com.gigabyte.bookstore.domain.player.AudiobookPlayer
import com.gigabyte.bookstore.domain.tts.BanglaTTSManager
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

    lateinit var ttsManager: BanglaTTSManager
        private set

    lateinit var player: AudiobookPlayer
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this

        database = AudiobookDatabase.getInstance(this)
        repository = AudiobookRepository(this, database)
        preferences = AppPreferences(this)
        ttsManager = BanglaTTSManager(this, applicationScope)
        player = AudiobookPlayer(this, repository, ttsManager, preferences, applicationScope)

        // Initialize built-in Bangla books if first launch
        applicationScope.launch(Dispatchers.IO) {
            repository.initializeSampleBooksIfNeeded()
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        ttsManager.shutdown()
    }

    companion object {
        lateinit var instance: BanglaAudiobookApp
            private set
    }
}
