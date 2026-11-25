package com.gigabyte.bookstore.presentation.sync

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.repository.BookSyncManager
import com.gigabyte.bookstore.data.repository.SyncProgressState
import com.gigabyte.bookstore.data.repository.UserRepository
import com.gigabyte.bookstore.data.repository.VerificationResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class InitialSyncState {
    object CheckingAuth : InitialSyncState()
    object NeedRegistration : InitialSyncState()
    data class DeviceMismatch(val registeredDeviceId: String) : InitialSyncState()
    data class SyncingFiles(
        val completed: Int,
        val total: Int,
        val percentage: Int,
        val currentFileName: String,
        val status: String
    ) : InitialSyncState()
    object Ready : InitialSyncState()
    data class Error(val message: String) : InitialSyncState()
}

class SyncViewModel(application: Application) : AndroidViewModel(application) {
    private val app = application as BanglaAudiobookApp
    private val appPreferences = app.appPreferences
    private val userRepository = UserRepository(application, appPreferences)
    val syncManager = app.syncManager

    private val _state = MutableStateFlow<InitialSyncState>(InitialSyncState.CheckingAuth)
    val state: StateFlow<InitialSyncState> = _state.asStateFlow()

    private var splashStartTime: Long = 0L

    /**
     * Enforces that the branded Splash Screen stays visible for at least 3.5 seconds (3 to 5s window)
     * so learners can enjoy the hero artwork and brand identity before entering the app.
     */
    private suspend fun enforceMinimumSplashDuration(minDurationMs: Long = 3500L) {
        val elapsed = System.currentTimeMillis() - splashStartTime
        val remaining = (minDurationMs - elapsed).coerceAtLeast(0L)
        if (remaining > 0L) {
            kotlinx.coroutines.delay(remaining)
        }
    }

    init {
        startSyncWorkflow()
    }

    fun startSyncWorkflow() {
        viewModelScope.launch {
            splashStartTime = System.currentTimeMillis()
            _state.value = InitialSyncState.CheckingAuth

            // 1. Check if user is logged in locally
            if (!appPreferences.isLoggedIn.value) {
                enforceMinimumSplashDuration()
                _state.value = InitialSyncState.NeedRegistration
                return@launch
            }

            // 2. Verify login & device ID in background with Firestore
            when (val authCheck = userRepository.verifyLoginAndDevice()) {
                is VerificationResult.DeviceMismatch -> {
                    enforceMinimumSplashDuration()
                    _state.value = InitialSyncState.DeviceMismatch(authCheck.expectedDeviceId)
                    return@launch
                }
                is VerificationResult.UserNotFound -> {
                    appPreferences.clearUserSession()
                    enforceMinimumSplashDuration()
                    _state.value = InitialSyncState.NeedRegistration
                    return@launch
                }
                is VerificationResult.Success -> {
                    // Refreshed status & balance from Firestore
                    proceedToFileSync(authCheck.user.status)
                }
                is VerificationResult.Offline -> {
                    // Offline fallback: wait for minimum splash branding duration
                    enforceMinimumSplashDuration()
                    _state.value = InitialSyncState.Ready
                }
                is VerificationResult.Error -> {
                    // Network error fallback
                    enforceMinimumSplashDuration()
                    _state.value = InitialSyncState.Ready
                }
            }
        }
    }


    private suspend fun proceedToFileSync(userStatus: String) {
        // Collect sync progress
        viewModelScope.launch {
            syncManager.syncState.collect { progress ->
                when (progress) {
                    is SyncProgressState.Syncing -> {
                        _state.value = InitialSyncState.SyncingFiles(
                            completed = progress.completedFiles,
                            total = progress.totalFiles,
                            percentage = progress.percentage,
                            currentFileName = progress.currentFileName,
                            status = userStatus
                        )
                    }
                    is SyncProgressState.Completed -> {
                        enforceMinimumSplashDuration()
                        _state.value = InitialSyncState.Ready
                    }
                    is SyncProgressState.Error -> {
                        enforceMinimumSplashDuration()
                        _state.value = InitialSyncState.Ready // Proceed with offline cached books
                    }
                    else -> {}
                }
            }
        }

        // Run sync (checks disk, downloads only missing files matching status)
        syncManager.syncBooksForUser(userStatus)
    }
}
