package com.gigabyte.bookstore.data.repository

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import com.gigabyte.bookstore.data.models.PaymentRequest
import com.gigabyte.bookstore.data.models.User
import com.gigabyte.bookstore.data.preferences.AppPreferences
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

sealed class VerificationResult {
    data class Success(val user: User) : VerificationResult()
    data class DeviceMismatch(val expectedDeviceId: String) : VerificationResult()
    object UserNotFound : VerificationResult()
    data class Offline(val cachedUser: User) : VerificationResult()
    data class Error(val message: String) : VerificationResult()
}

class UserRepository(
    private val context: Context,
    private val appPreferences: AppPreferences
) {
    private val firestore: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }

    @SuppressLint("HardwareIds")
    fun getDeviceId(): String {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID) ?: "unknown_device"
    }

    suspend fun registerUser(
        name: String,
        email: String,
        institute: String,
        address: String,
        phone: String?
    ): Result<User> = withContext(Dispatchers.IO) {
        try {
            val normalizedEmail = email.trim().lowercase()
            val deviceId = getDeviceId()
            val currentDate = User.getCurrentFormattedDate()

            val userDocRef = firestore.collection("users").document(normalizedEmail)
            val snapshot = userDocRef.get().await()

            if (snapshot.exists()) {
                val existingDeviceId = snapshot.getString("deviceId") ?: ""
                if (existingDeviceId.isNotBlank() && existingDeviceId != deviceId) {
                    return@withContext Result.failure(
                        Exception("Email is already registered on another device (ID: $existingDeviceId)")
                    )
                }
            }

            val userMap = hashMapOf<String, Any>(
                "name" to name.trim(),
                "email" to normalizedEmail,
                "institute" to institute.trim(),
                "address" to address.trim(),
                "phone" to (phone?.trim() ?: ""),
                "deviceId" to deviceId,
                "status" to "trial", // Default trial status
                "balance" to 0.0,
                "createdAt" to currentDate,
                "lastLoginAt" to currentDate
            )

            userDocRef.set(userMap).await()

            val user = User(
                name = name.trim(),
                email = normalizedEmail,
                institute = institute.trim(),
                address = address.trim(),
                phone = phone?.trim(),
                deviceId = deviceId,
                status = "trial",
                balance = 0.0,
                createdAt = currentDate,
                lastLoginAt = currentDate
            )

            // Save to local preferences for offline use
            appPreferences.saveUserSession(
                name = user.name,
                email = user.email,
                institute = user.institute,
                address = user.address,
                phone = user.phone,
                deviceId = user.deviceId,
                status = user.status,
                balance = user.balance,
                createdAt = user.createdAt,
                lastLoginAt = user.lastLoginAt
            )

            Result.success(user)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    suspend fun verifyLoginAndDevice(): VerificationResult = withContext(Dispatchers.IO) {
        val storedEmail = appPreferences.userEmail.value
        val currentDeviceId = getDeviceId()

        if (storedEmail.isBlank()) {
            return@withContext VerificationResult.UserNotFound
        }

        // If device is offline, immediately return locally saved user session
        if (!com.gigabyte.bookstore.data.util.NetworkUtils.isOnline(context)) {
            val cached = User(
                name = appPreferences.userName.value,
                email = storedEmail,
                deviceId = currentDeviceId,
                status = appPreferences.userStatus.value,
                balance = appPreferences.userBalance.value,
                lastLoginAt = User.getCurrentFormattedDate()
            )
            return@withContext VerificationResult.Offline(cached)
        }

        try {
            val snapshot = firestore.collection("users").document(storedEmail).get().await()


            if (!snapshot.exists()) {
                return@withContext VerificationResult.UserNotFound
            }

            val registeredDeviceId = snapshot.getString("deviceId") ?: ""
            if (registeredDeviceId.isNotBlank() && registeredDeviceId != currentDeviceId) {
                return@withContext VerificationResult.DeviceMismatch(registeredDeviceId)
            }

            val name = snapshot.getString("name") ?: appPreferences.userName.value
            val status = snapshot.getString("status") ?: "trial"
            val balance = snapshot.getDouble("balance") ?: 0.0
            val createdAt = snapshot.getString("createdAt") ?: ""
            val currentDate = User.getCurrentFormattedDate()

            // Update lastLoginAt in Firestore
            try {
                firestore.collection("users").document(storedEmail)
                    .update("lastLoginAt", currentDate)
                    .await()
            } catch (e: Exception) {
                // Non-critical
            }

            // Refresh local session with latest status and balance
            appPreferences.updateUserStatus(status, balance, currentDate)

            val verifiedUser = User(
                name = name,
                email = storedEmail,
                institute = snapshot.getString("institute") ?: "",
                address = snapshot.getString("address") ?: "",
                phone = snapshot.getString("phone"),
                deviceId = currentDeviceId,
                status = status,
                balance = balance,
                createdAt = createdAt,
                lastLoginAt = currentDate
            )

            VerificationResult.Success(verifiedUser)
        } catch (e: Exception) {
            // Network failure or offline: load from local session!
            if (appPreferences.isLoggedIn.value) {
                val cached = User(
                    name = appPreferences.userName.value,
                    email = storedEmail,
                    deviceId = currentDeviceId,
                    status = appPreferences.userStatus.value,
                    balance = appPreferences.userBalance.value,
                    lastLoginAt = User.getCurrentFormattedDate()
                )
                VerificationResult.Offline(cached)
            } else {
                VerificationResult.Error(e.message ?: "Authentication check failed")
            }
        }
    }

    suspend fun updateUserProfile(
        name: String,
        institute: String,
        address: String,
        phone: String?
    ): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val email = appPreferences.userEmail.value
            if (email.isBlank()) return@withContext Result.failure(Exception("Not logged in"))

            // Update local preferences immediately
            appPreferences.updateProfile(name.trim(), institute.trim(), address.trim(), phone?.trim())

            // Sync to Firestore if online
            if (com.gigabyte.bookstore.data.util.NetworkUtils.isOnline(context)) {
                val updates = hashMapOf<String, Any>(
                    "name" to name.trim(),
                    "institute" to institute.trim(),
                    "address" to address.trim(),
                    "phone" to (phone?.trim() ?: "")
                )
                firestore.collection("users").document(email).update(updates).await()
            }

            Result.success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    suspend fun submitPaymentRequest(
        method: String,
        transactionId: String,
        amount: Double
    ): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val email = appPreferences.userEmail.value
            val deviceId = getDeviceId()
            val paymentData = hashMapOf(
                "email" to email,
                "deviceId" to deviceId,
                "method" to method,
                "transactionId" to transactionId.trim(),
                "amount" to amount,
                "submittedAt" to User.getCurrentFormattedDate(),
                "status" to "pending"
            )

            firestore.collection("payment_requests").add(paymentData).await()
            Result.success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    suspend fun getAllPaymentRequests(): Result<List<PaymentRequest>> = withContext(Dispatchers.IO) {
        try {
            val snapshot = firestore.collection("payment_requests")
                .get()
                .await()
            val list = snapshot.documents.mapNotNull { doc ->
                val id = doc.id
                val email = doc.getString("email") ?: ""
                val deviceId = doc.getString("deviceId") ?: ""
                val method = doc.getString("method") ?: ""
                val transactionId = doc.getString("transactionId") ?: ""
                val amount = doc.getDouble("amount") ?: 0.0
                val submittedAt = doc.getString("submittedAt") ?: ""
                val status = doc.getString("status") ?: "pending"
                val reviewedAt = doc.getString("reviewedAt") ?: ""
                val rejectionReason = doc.getString("rejectionReason") ?: ""
                PaymentRequest(
                    id = id,
                    email = email,
                    deviceId = deviceId,
                    method = method,
                    transactionId = transactionId,
                    amount = amount,
                    submittedAt = submittedAt,
                    status = status,
                    reviewedAt = reviewedAt,
                    rejectionReason = rejectionReason
                )
            }.sortedByDescending { it.submittedAt }
            Result.success(list)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    suspend fun approvePaymentRequest(
        requestId: String,
        userEmail: String,
        amount: Double
    ): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val currentDate = User.getCurrentFormattedDate()
            val normalizedEmail = userEmail.trim().lowercase()

            // 1. Update payment request status to approved
            firestore.collection("payment_requests").document(requestId)
                .update(
                    mapOf(
                        "status" to "approved",
                        "reviewedAt" to currentDate
                    )
                ).await()

            // 2. Update user status to paid and update balance
            val userRef = firestore.collection("users").document(normalizedEmail)
            val userSnap = userRef.get().await()

            var newBalance = amount
            if (userSnap.exists()) {
                val currentBalance = userSnap.getDouble("balance") ?: 0.0
                newBalance = currentBalance + amount
                userRef.update(
                    mapOf(
                        "status" to "paid",
                        "balance" to newBalance,
                        "lastLoginAt" to currentDate
                    )
                ).await()
            } else {
                val userMap = hashMapOf<String, Any>(
                    "email" to normalizedEmail,
                    "status" to "paid",
                    "balance" to amount,
                    "createdAt" to currentDate,
                    "lastLoginAt" to currentDate
                )
                userRef.set(userMap).await()
            }

            // If the currently logged-in user matches the approved request, update local state immediately
            if (appPreferences.userEmail.value.equals(normalizedEmail, ignoreCase = true)) {
                appPreferences.updateUserStatus("paid", newBalance, currentDate)
            }

            Result.success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    suspend fun rejectPaymentRequest(
        requestId: String,
        reason: String = ""
    ): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val currentDate = User.getCurrentFormattedDate()
            firestore.collection("payment_requests").document(requestId)
                .update(
                    mapOf(
                        "status" to "rejected",
                        "reviewedAt" to currentDate,
                        "rejectionReason" to reason.trim()
                    )
                ).await()
            Result.success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}

