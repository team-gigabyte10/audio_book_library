package com.gigabyte.bookstore.presentation.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.preferences.AppPreferences
import com.gigabyte.bookstore.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class RegisterUiState {
    object Idle : RegisterUiState()
    object Loading : RegisterUiState()
    object Success : RegisterUiState()
    data class Error(val message: String) : RegisterUiState()
}

class RegisterViewModel(application: Application) : AndroidViewModel(application) {
    private val appPreferences = (application as BanglaAudiobookApp).appPreferences
    private val userRepository = UserRepository(application, appPreferences)

    val deviceId: String = userRepository.getDeviceId()

    private val _uiState = MutableStateFlow<RegisterUiState>(RegisterUiState.Idle)
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    fun register(
        name: String,
        email: String,
        institute: String,
        address: String,
        phone: String?
    ) {
        if (name.isBlank() || email.isBlank() || institute.isBlank() || address.isBlank()) {
            _uiState.value = RegisterUiState.Error("Please fill in Name, Email, Institute, and Address.")
            return
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches()) {
            _uiState.value = RegisterUiState.Error("Please enter a valid email address.")
            return
        }

        _uiState.value = RegisterUiState.Loading

        viewModelScope.launch {
            val result = userRepository.registerUser(
                name = name,
                email = email,
                institute = institute,
                address = address,
                phone = phone
            )

            result.fold(
                onSuccess = {
                    _uiState.value = RegisterUiState.Success
                },
                onFailure = { error ->
                    _uiState.value = RegisterUiState.Error(error.message ?: "Registration failed")
                }
            )
        }
    }
}
