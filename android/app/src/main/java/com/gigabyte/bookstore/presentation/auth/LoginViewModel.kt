package com.gigabyte.bookstore.presentation.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.repository.LoginResult
import com.gigabyte.bookstore.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class LoginUiState {
    object Idle : LoginUiState()
    object Loading : LoginUiState()
    object Success : LoginUiState()
    data class Error(val message: String, val suggestRegister: Boolean = false) : LoginUiState()
}

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val appPreferences = (application as BanglaAudiobookApp).appPreferences
    private val userRepository = UserRepository(application, appPreferences)

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    /** Pre-fills the email of the last account used on this phone, if any. */
    val lastEmail: String = appPreferences.userEmail.value.ifBlank { "nayemislam9@gmail.com" }

    fun login(email: String) {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches()) {
            _uiState.value = LoginUiState.Error("সঠিক ইমেইল ঠিকানা লিখুন। (Please enter a valid email address.)")
            return
        }

        _uiState.value = LoginUiState.Loading
        viewModelScope.launch {
            _uiState.value = when (val result = userRepository.loginWithEmail(email)) {
                is LoginResult.Success -> LoginUiState.Success
                LoginResult.NotFound -> LoginUiState.Error(
                    "এই ইমেইলে কোনো অ্যাকাউন্ট পাওয়া যায়নি। নতুন অ্যাকাউন্ট খুলুন। (No account found for this email.)",
                    suggestRegister = true
                )
                LoginResult.DeviceMismatch -> LoginUiState.Error(
                    "এই অ্যাকাউন্টটি অন্য একটি ফোনে চালু আছে। একটি অ্যাকাউন্ট একটি ফোনেই ব্যবহার করা যায়। " +
                        "ফোন পরিবর্তন করতে আমাদের সাথে যোগাযোগ করুন। (This account is active on another phone.)"
                )
                LoginResult.Offline -> LoginUiState.Error(
                    "ইন্টারনেট সংযোগ নেই। সংযোগ চালু করে আবার চেষ্টা করুন। (No internet connection.)"
                )
                is LoginResult.Error -> LoginUiState.Error("লগইন ব্যর্থ হয়েছে: ${result.message}")
            }
        }
    }
}
