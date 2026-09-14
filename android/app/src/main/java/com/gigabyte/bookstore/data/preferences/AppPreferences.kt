package com.gigabyte.bookstore.data.preferences

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppPreferences(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("bangla_audiobook_prefs", Context.MODE_PRIVATE)

    private val _speechRate = MutableStateFlow(prefs.getFloat(KEY_SPEECH_RATE, 1.0f))
    val speechRate: StateFlow<Float> = _speechRate.asStateFlow()

    private val _speechPitch = MutableStateFlow(prefs.getFloat(KEY_SPEECH_PITCH, 1.0f))
    val speechPitch: StateFlow<Float> = _speechPitch.asStateFlow()

    private val _autoPlayNext = MutableStateFlow(prefs.getBoolean(KEY_AUTO_PLAY_NEXT, true))
    val autoPlayNext: StateFlow<Boolean> = _autoPlayNext.asStateFlow()

    private val _keepScreenAwake = MutableStateFlow(prefs.getBoolean(KEY_KEEP_SCREEN_AWAKE, false))
    val keepScreenAwake: StateFlow<Boolean> = _keepScreenAwake.asStateFlow()

    private val _fullAudiobookMode = MutableStateFlow(prefs.getBoolean(KEY_FULL_AUDIOBOOK_MODE, true))
    val fullAudiobookMode: StateFlow<Boolean> = _fullAudiobookMode.asStateFlow()

    private val _readerFontSize = MutableStateFlow(prefs.getInt(KEY_READER_FONT_SIZE, 18))
    val readerFontSize: StateFlow<Int> = _readerFontSize.asStateFlow()

    private val _selectedVoiceId = MutableStateFlow(prefs.getString(KEY_SELECTED_VOICE_ID, "voice_natural_clear") ?: "voice_natural_clear")
    val selectedVoiceId: StateFlow<String> = _selectedVoiceId.asStateFlow()

    fun setSpeechRate(rate: Float) {
        prefs.edit().putFloat(KEY_SPEECH_RATE, rate).apply()
        _speechRate.value = rate
    }

    fun setSpeechPitch(pitch: Float) {
        prefs.edit().putFloat(KEY_SPEECH_PITCH, pitch).apply()
        _speechPitch.value = pitch
    }

    fun setSelectedVoiceId(voiceId: String) {
        prefs.edit().putString(KEY_SELECTED_VOICE_ID, voiceId).apply()
        _selectedVoiceId.value = voiceId
    }

    fun setAutoPlayNext(autoPlay: Boolean) {
        prefs.edit().putBoolean(KEY_AUTO_PLAY_NEXT, autoPlay).apply()
        _autoPlayNext.value = autoPlay
    }

    fun setKeepScreenAwake(keepAwake: Boolean) {
        prefs.edit().putBoolean(KEY_KEEP_SCREEN_AWAKE, keepAwake).apply()
        _keepScreenAwake.value = keepAwake
    }

    fun setFullAudiobookMode(isFull: Boolean) {
        prefs.edit().putBoolean(KEY_FULL_AUDIOBOOK_MODE, isFull).apply()
        _fullAudiobookMode.value = isFull
    }

    fun setReaderFontSize(size: Int) {
        prefs.edit().putInt(KEY_READER_FONT_SIZE, size).apply()
        _readerFontSize.value = size
    }

    companion object {
        private const val KEY_SPEECH_RATE = "speech_rate"
        private const val KEY_SPEECH_PITCH = "speech_pitch"
        private const val KEY_AUTO_PLAY_NEXT = "auto_play_next"
        private const val KEY_KEEP_SCREEN_AWAKE = "keep_screen_awake"
        private const val KEY_FULL_AUDIOBOOK_MODE = "full_audiobook_mode"
        private const val KEY_READER_FONT_SIZE = "reader_font_size"
        private const val KEY_SELECTED_VOICE_ID = "selected_voice_id"

        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_USER_NAME = "user_name"
        private const val KEY_USER_EMAIL = "user_email"
        private const val KEY_USER_INSTITUTE = "user_institute"
        private const val KEY_USER_ADDRESS = "user_address"
        private const val KEY_USER_PHONE = "user_phone"
        private const val KEY_DEVICE_ID = "device_id"
        private const val KEY_USER_STATUS = "user_status"
        private const val KEY_USER_BALANCE = "user_balance"
        private const val KEY_CREATED_AT = "created_at"
        private const val KEY_LAST_LOGIN_AT = "last_login_at"
    }

    // User session flows
    private val _isLoggedIn = MutableStateFlow(prefs.getBoolean(KEY_IS_LOGGED_IN, false))
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    private val _userEmail = MutableStateFlow(prefs.getString(KEY_USER_EMAIL, "") ?: "")
    val userEmail: StateFlow<String> = _userEmail.asStateFlow()

    private val _userName = MutableStateFlow(prefs.getString(KEY_USER_NAME, "") ?: "")
    val userName: StateFlow<String> = _userName.asStateFlow()

    private val _userInstitute = MutableStateFlow(prefs.getString(KEY_USER_INSTITUTE, "") ?: "")
    val userInstitute: StateFlow<String> = _userInstitute.asStateFlow()

    private val _userAddress = MutableStateFlow(prefs.getString(KEY_USER_ADDRESS, "") ?: "")
    val userAddress: StateFlow<String> = _userAddress.asStateFlow()

    private val _userPhone = MutableStateFlow(prefs.getString(KEY_USER_PHONE, "") ?: "")
    val userPhone: StateFlow<String> = _userPhone.asStateFlow()

    private val _deviceId = MutableStateFlow(prefs.getString(KEY_DEVICE_ID, "") ?: "")
    val deviceId: StateFlow<String> = _deviceId.asStateFlow()

    private val _userStatus = MutableStateFlow(prefs.getString(KEY_USER_STATUS, "trial") ?: "trial")
    val userStatus: StateFlow<String> = _userStatus.asStateFlow()

    private val _userBalance = MutableStateFlow(prefs.getFloat(KEY_USER_BALANCE, 0.0f).toDouble())
    val userBalance: StateFlow<Double> = _userBalance.asStateFlow()

    fun saveUserSession(
        name: String,
        email: String,
        institute: String,
        address: String,
        phone: String?,
        deviceId: String,
        status: String = "trial",
        balance: Double = 0.0,
        createdAt: String = "",
        lastLoginAt: String = ""
    ) {
        prefs.edit()
            .putBoolean(KEY_IS_LOGGED_IN, true)
            .putString(KEY_USER_NAME, name)
            .putString(KEY_USER_EMAIL, email)
            .putString(KEY_USER_INSTITUTE, institute)
            .putString(KEY_USER_ADDRESS, address)
            .putString(KEY_USER_PHONE, phone ?: "")
            .putString(KEY_DEVICE_ID, deviceId)
            .putString(KEY_USER_STATUS, status)
            .putFloat(KEY_USER_BALANCE, balance.toFloat())
            .putString(KEY_CREATED_AT, createdAt)
            .putString(KEY_LAST_LOGIN_AT, lastLoginAt)
            .apply()

        _isLoggedIn.value = true
        _userName.value = name
        _userEmail.value = email
        _userInstitute.value = institute
        _userAddress.value = address
        _userPhone.value = phone ?: ""
        _deviceId.value = deviceId
        _userStatus.value = status
        _userBalance.value = balance
    }

    fun updateProfile(name: String, institute: String, address: String, phone: String?) {
        prefs.edit()
            .putString(KEY_USER_NAME, name)
            .putString(KEY_USER_INSTITUTE, institute)
            .putString(KEY_USER_ADDRESS, address)
            .putString(KEY_USER_PHONE, phone ?: "")
            .apply()

        _userName.value = name
        _userInstitute.value = institute
        _userAddress.value = address
        _userPhone.value = phone ?: ""
    }


    fun updateUserStatus(status: String, balance: Double, lastLoginDate: String = "") {
        val editor = prefs.edit()
            .putString(KEY_USER_STATUS, status)
            .putFloat(KEY_USER_BALANCE, balance.toFloat())

        if (lastLoginDate.isNotBlank()) {
            editor.putString(KEY_LAST_LOGIN_AT, lastLoginDate)
        }
        editor.apply()

        _userStatus.value = status
        _userBalance.value = balance
    }

    fun getStoredDeviceId(): String = prefs.getString(KEY_DEVICE_ID, "") ?: ""

    fun clearUserSession() {
        prefs.edit()
            .putBoolean(KEY_IS_LOGGED_IN, false)
            .remove(KEY_USER_NAME)
            .remove(KEY_USER_EMAIL)
            .remove(KEY_USER_STATUS)
            .remove(KEY_USER_BALANCE)
            .apply()

        _isLoggedIn.value = false
        _userName.value = ""
        _userEmail.value = ""
        _userStatus.value = "trial"
        _userBalance.value = 0.0
    }
}

