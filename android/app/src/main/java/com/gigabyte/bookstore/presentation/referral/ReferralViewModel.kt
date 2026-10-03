package com.gigabyte.bookstore.presentation.referral

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.data.models.ReferralStats
import com.gigabyte.bookstore.data.models.WithdrawalRequest
import com.gigabyte.bookstore.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class ReferralUiState {
    object Loading : ReferralUiState()
    data class Success(
        val stats: ReferralStats,
        val withdrawals: List<WithdrawalRequest>
    ) : ReferralUiState()
    data class Error(val message: String) : ReferralUiState()
}

class ReferralViewModel(application: Application) : AndroidViewModel(application) {
    private val appPreferences = (application as BanglaAudiobookApp).appPreferences
    private val userRepository = UserRepository(application, appPreferences)

    private val _uiState = MutableStateFlow<ReferralUiState>(ReferralUiState.Loading)
    val uiState: StateFlow<ReferralUiState> = _uiState.asStateFlow()

    private val _isWithdrawing = MutableStateFlow(false)
    val isWithdrawing: StateFlow<Boolean> = _isWithdrawing.asStateFlow()

    private val _actionMessage = MutableStateFlow<String?>(null)
    val actionMessage: StateFlow<String?> = _actionMessage.asStateFlow()

    init {
        loadData()
    }

    fun loadData() {
        val userEmail = appPreferences.userEmail.value
        if (userEmail.isBlank()) {
            _uiState.value = ReferralUiState.Error("Please log in to view referral rewards.")
            return
        }

        viewModelScope.launch {
            _uiState.value = ReferralUiState.Loading
            val statsResult = userRepository.getReferralStats(userEmail)
            val withdrawalsResult = userRepository.getMyWithdrawalRequests()

            if (statsResult.isSuccess) {
                _uiState.value = ReferralUiState.Success(
                    stats = statsResult.getOrThrow(),
                    withdrawals = withdrawalsResult.getOrDefault(emptyList())
                )
            } else {
                _uiState.value = ReferralUiState.Error(
                    statsResult.exceptionOrNull()?.message ?: "Failed to load referral stats"
                )
            }
        }
    }

    fun requestWithdrawal(
        method: String,
        accountNumber: String,
        accountType: String,
        amount: Double
    ) {
        if (accountNumber.isBlank() || accountNumber.length < 11) {
            _actionMessage.value = "অনুগ্রহ করে সঠিক মোবাইল ব্যাংকিং নম্বর দিন।"
            return
        }

        if (amount < 100.0) {
            _actionMessage.value = "সর্বনিম্ন উত্তোলনের পরিমাণ ১০০ টাকা।"
            return
        }

        _isWithdrawing.value = true
        viewModelScope.launch {
            val result = userRepository.submitWithdrawalRequest(
                method = method,
                accountNumber = accountNumber,
                accountType = accountType,
                amount = amount
            )

            _isWithdrawing.value = false
            result.fold(
                onSuccess = {
                    _actionMessage.value = "উত্তোলন অনুরোধ সফল হয়েছে! দ্রুতই আপনার একাউন্টে টাকা পাঠানো হবে।"
                    loadData()
                },
                onFailure = { error ->
                    _actionMessage.value = error.message ?: "উত্তোলন অনুরোধ ব্যর্থ হয়েছে।"
                }
            )
        }
    }

    fun clearActionMessage() {
        _actionMessage.value = null
    }
}
