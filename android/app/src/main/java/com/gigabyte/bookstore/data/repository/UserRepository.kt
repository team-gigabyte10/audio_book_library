package com.gigabyte.bookstore.data.repository

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import com.gigabyte.bookstore.data.models.PaymentRequest
import com.gigabyte.bookstore.data.models.ReferralReward
import com.gigabyte.bookstore.data.models.ReferralStats
import com.gigabyte.bookstore.data.models.User
import com.gigabyte.bookstore.data.models.WithdrawalRequest
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
        phone: String?,
        referralCodeInput: String? = null
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

            // Referral code verification
            var referredBy: String? = null
            val inputCode = referralCodeInput?.trim()?.uppercase()
            if (!inputCode.isNullOrBlank()) {
                val refQuery = firestore.collection("users")
                    .whereEqualTo("referralCode", inputCode)
                    .get()
                    .await()
                if (!refQuery.isEmpty) {
                    val refDoc = refQuery.documents.first()
                    val refEmail = refDoc.getString("email") ?: refDoc.id
                    if (!refEmail.equals(normalizedEmail, ignoreCase = true)) {
                        referredBy = refDoc.getString("referralCode") ?: refEmail
                    }
                }
            }

            val myReferralCode = User.generateReferralCode(name)

            val userMap = hashMapOf<String, Any>(
                "name" to name.trim(),
                "email" to normalizedEmail,
                "institute" to institute.trim(),
                "address" to address.trim(),
                "phone" to (phone?.trim() ?: ""),
                "deviceId" to deviceId,
                "status" to "trial", // Default trial status
                "balance" to 0.0,
                "referralCode" to myReferralCode,
                "referredBy" to (referredBy ?: ""),
                "referralRewardPaid" to false,
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
                referralCode = myReferralCode,
                referredBy = referredBy,
                referralRewardPaid = false,
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
                referralCode = user.referralCode,
                referredBy = user.referredBy,
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
                referralCode = appPreferences.referralCode.value,
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
            var referralCode = snapshot.getString("referralCode") ?: ""
            val referredBy = snapshot.getString("referredBy")
            val referralRewardPaid = snapshot.getBoolean("referralRewardPaid") ?: false
            val createdAt = snapshot.getString("createdAt") ?: ""
            val currentDate = User.getCurrentFormattedDate()

            // If user doesn't have a referral code yet, auto-generate & store it
            if (referralCode.isBlank()) {
                referralCode = User.generateReferralCode(name)
                try {
                    firestore.collection("users").document(storedEmail)
                        .update("referralCode", referralCode)
                        .await()
                } catch (e: Exception) {
                    // Non-critical
                }
            }

            // Update lastLoginAt in Firestore
            try {
                firestore.collection("users").document(storedEmail)
                    .update("lastLoginAt", currentDate)
                    .await()
            } catch (e: Exception) {
                // Non-critical
            }

            val rawBundles = (snapshot.get("unlockedBundles") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()
            val bundlesSet = rawBundles.toMutableSet()
            if (status.equals("paid", ignoreCase = true) && bundlesSet.isEmpty()) {
                bundlesSet.add("audiobook_bundle")
            }
            appPreferences.setUnlockedBundles(bundlesSet)

            // Refresh local session with latest status, balance, and referral code
            appPreferences.updateUserStatus(status, balance, currentDate)
            appPreferences.updateReferralCode(referralCode)

            val verifiedUser = User(
                name = name,
                email = storedEmail,
                institute = snapshot.getString("institute") ?: "",
                address = snapshot.getString("address") ?: "",
                phone = snapshot.getString("phone"),
                deviceId = currentDeviceId,
                status = status,
                balance = balance,
                referralCode = referralCode,
                referredBy = referredBy,
                referralRewardPaid = referralRewardPaid,
                unlockedBundles = bundlesSet.toList(),
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
                    referralCode = appPreferences.referralCode.value,
                    unlockedBundles = appPreferences.getUnlockedBundles().toList(),
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
        amount: Double,
        packageType: String = "audiobook_bundle"
    ): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val email = appPreferences.userEmail.value.trim().lowercase()
            val deviceId = getDeviceId()
            val normalizedTrx = transactionId.trim().replace("\\s+".toRegex(), "").uppercase()

            if (normalizedTrx.length < 4) {
                return@withContext Result.failure(Exception("অনুগ্রহ করে একটি সঠিক ও পূর্ণাঙ্গ Transaction ID প্রদান করুন।"))
            }

            // Check duplicate TrxID across all payment_requests in Firestore
            val existingDocs = firestore.collection("payment_requests")
                .whereEqualTo("transactionId", normalizedTrx)
                .get()
                .await()

            if (!existingDocs.isEmpty) {
                // 1. Check if already approved
                val isAlreadyApproved = existingDocs.documents.any {
                    it.getString("status").equals("approved", ignoreCase = true)
                }
                if (isAlreadyApproved) {
                    return@withContext Result.failure(
                        Exception("এই Transaction ID ($normalizedTrx) ইতিমধ্যে অনুমোদিত ও ব্যবহৃত হয়েছে। একটি ট্রানজেকশন একাধিকবার ব্যবহার করা যাবে না।")
                    )
                }

                // 2. Check if currently pending by another user or same user
                val pendingDoc = existingDocs.documents.firstOrNull {
                    it.getString("status").equals("pending", ignoreCase = true)
                }
                if (pendingDoc != null) {
                    val pendingEmail = pendingDoc.getString("email")?.trim()?.lowercase() ?: ""
                    if (pendingEmail == email) {
                        return@withContext Result.failure(
                            Exception("আপনি ইতিমধ্যে এই Transaction ID ($normalizedTrx) দিয়ে অনুরোধ জমা দিয়েছেন, যা বর্তমানে যাচাইাধীন রয়েছে।")
                        )
                    } else {
                        return@withContext Result.failure(
                            Exception("এই Transaction ID ($normalizedTrx) অন্য একজন ব্যবহারকারী ইতিমধ্যে সাবমিট করেছেন। একই ট্রানজেকশন আইডি একাধিক অ্যাকাউন্টে গ্রহণযোগ্য নয়।")
                        )
                    }
                }
            }

            val paymentData = hashMapOf(
                "email" to email,
                "deviceId" to deviceId,
                "method" to method,
                "transactionId" to normalizedTrx,
                "amount" to amount,
                "packageType" to packageType,
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
                val packageType = doc.getString("packageType") ?: "audiobook_bundle"
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
                    packageType = packageType,
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

            // 1. Fetch packageType and transactionId from the payment request
            val reqRef = firestore.collection("payment_requests").document(requestId)
            val reqSnap = reqRef.get().await()
            val packageType = reqSnap.getString("packageType") ?: "audiobook_bundle"
            val trxId = reqSnap.getString("transactionId")?.trim()?.replace("\\s+".toRegex(), "")?.uppercase() ?: ""

            // Extra safety: Check if this transactionId was already approved in another document
            if (trxId.isNotBlank()) {
                val duplicateApprovedQuery = firestore.collection("payment_requests")
                    .whereEqualTo("transactionId", trxId)
                    .whereEqualTo("status", "approved")
                    .get()
                    .await()
                val otherApproved = duplicateApprovedQuery.documents.filter { it.id != requestId }
                if (otherApproved.isNotEmpty()) {
                    val otherOwner = otherApproved.first().getString("email") ?: "অন্য ইউজার"
                    return@withContext Result.failure(
                        Exception("প্রতারণা সতর্কতা: এই Transaction ID ($trxId) ইতিমধ্যে $otherOwner এর অ্যাকাউন্টে অনুমোদিত হয়েছে! ডুপ্লিকেট অনুমোদন বাতিল করা হয়েছে।")
                    )
                }
            }

            // Update payment request status to approved
            reqRef.update(
                mapOf(
                    "status" to "approved",
                    "reviewedAt" to currentDate
                )
            ).await()

            // 2. Update user status to paid and update balance & unlocked bundles
            val userRef = firestore.collection("users").document(normalizedEmail)
            val userSnap = userRef.get().await()

            val rawBundles = (userSnap.get("unlockedBundles") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()
            val updatedBundles = rawBundles.toMutableSet()
            if (packageType == "mega_bundle") {
                updatedBundles.addAll(listOf("audiobook_bundle", "english_course", "japanese_course", "mega_bundle"))
            } else {
                updatedBundles.add(packageType)
            }

            var newBalance = amount
            if (userSnap.exists()) {
                val currentBalance = userSnap.getDouble("balance") ?: 0.0
                newBalance = currentBalance + amount
                userRef.update(
                    mapOf(
                        "status" to "paid",
                        "balance" to newBalance,
                        "unlockedBundles" to updatedBundles.toList(),
                        "lastLoginAt" to currentDate
                    )
                ).await()
            } else {
                val userMap = hashMapOf<String, Any>(
                    "email" to normalizedEmail,
                    "status" to "paid",
                    "balance" to amount,
                    "unlockedBundles" to updatedBundles.toList(),
                    "createdAt" to currentDate,
                    "lastLoginAt" to currentDate
                )
                userRef.set(userMap).await()
            }

            // If the currently logged-in user matches the approved request, update local state immediately
            if (appPreferences.userEmail.value.equals(normalizedEmail, ignoreCase = true)) {
                appPreferences.updateUserStatus("paid", newBalance, currentDate)
                appPreferences.setUnlockedBundles(updatedBundles)
            }

            // Check and process referral bonus if this user was referred by someone
            val referredBy = userSnap.getString("referredBy") ?: ""
            val referralRewardPaid = userSnap.getBoolean("referralRewardPaid") ?: false

            if (referredBy.isNotBlank() && !referralRewardPaid) {
                try {
                    // Try looking up referrer by email or by referralCode
                    var referrerDoc = firestore.collection("users").document(referredBy.lowercase()).get().await()
                    if (!referrerDoc.exists()) {
                        val q = firestore.collection("users").whereEqualTo("referralCode", referredBy.uppercase()).get().await()
                        if (!q.isEmpty) {
                            referrerDoc = q.documents.first()
                        }
                    }

                    if (referrerDoc.exists()) {
                        val refEmail = referrerDoc.getString("email") ?: referrerDoc.id
                        val refCurrentBal = referrerDoc.getDouble("balance") ?: 0.0
                        val updatedRefBal = refCurrentBal + 20.0

                        // Credit ৳20 to referrer's balance
                        referrerDoc.reference.update("balance", updatedRefBal).await()

                        // Mark this referred user as rewarded so they don't trigger multiple bonuses
                        userRef.update("referralRewardPaid", true).await()

                        // Log in referral_rewards collection
                        val rewardMap = hashMapOf(
                            "referrerEmail" to refEmail,
                            "referrerCode" to (referrerDoc.getString("referralCode") ?: ""),
                            "refereeEmail" to normalizedEmail,
                            "refereeName" to (userSnap.getString("name") ?: ""),
                            "amount" to 20.0,
                            "paidAt" to currentDate,
                            "status" to "rewarded"
                        )
                        firestore.collection("referral_rewards").add(rewardMap).await()

                        // If the currently logged in user is the referrer, update their live balance
                        if (appPreferences.userEmail.value.equals(refEmail, ignoreCase = true)) {
                            appPreferences.updateUserStatus(appPreferences.userStatus.value, updatedRefBal, currentDate)
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
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

    suspend fun getReferralStats(userEmail: String): Result<ReferralStats> = withContext(Dispatchers.IO) {
        try {
            val normalizedEmail = userEmail.trim().lowercase()
            val userDoc = firestore.collection("users").document(normalizedEmail).get().await()
            val myReferralCode = userDoc.getString("referralCode") ?: appPreferences.referralCode.value
            val currentBalance = userDoc.getDouble("balance") ?: appPreferences.userBalance.value

            // 1. Get all referral rewards credited to this user
            val rewardsSnap = firestore.collection("referral_rewards")
                .whereEqualTo("referrerEmail", normalizedEmail)
                .get()
                .await()

            val rewards = rewardsSnap.documents.map { doc ->
                ReferralReward(
                    id = doc.id,
                    referrerEmail = doc.getString("referrerEmail") ?: "",
                    refereeEmail = doc.getString("refereeEmail") ?: "",
                    refereeName = doc.getString("refereeName") ?: "",
                    amount = doc.getDouble("amount") ?: 20.0,
                    paidAt = doc.getString("paidAt") ?: "",
                    status = doc.getString("status") ?: "rewarded"
                )
            }.sortedByDescending { it.paidAt }

            val paidCount = rewards.size
            val totalEarned = rewards.sumOf { it.amount }

            // 2. Count total registered friends (by referral code)
            var totalFriends = 0
            if (myReferralCode.isNotBlank()) {
                val byCodeSnap = firestore.collection("users")
                    .whereEqualTo("referredBy", myReferralCode)
                    .get()
                    .await()
                totalFriends = byCodeSnap.size()
            }
            if (totalFriends < paidCount) {
                totalFriends = paidCount
            }

            Result.success(
                ReferralStats(
                    referralCode = myReferralCode,
                    totalFriendsJoined = totalFriends,
                    paidMembersCount = paidCount,
                    totalEarned = totalEarned,
                    currentBalance = currentBalance,
                    rewards = rewards
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    suspend fun submitWithdrawalRequest(
        method: String,
        accountNumber: String,
        accountType: String,
        amount: Double
    ): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val email = appPreferences.userEmail.value.trim().lowercase()
            if (email.isBlank()) return@withContext Result.failure(Exception("Not logged in"))
            if (amount < 100.0) return@withContext Result.failure(Exception("Minimum withdrawal is 100 TK"))

            val userRef = firestore.collection("users").document(email)
            val userSnap = userRef.get().await()
            val currentBal = userSnap.getDouble("balance") ?: 0.0

            if (currentBal < amount) {
                return@withContext Result.failure(Exception("Insufficient balance (Current: ৳$currentBal)"))
            }

            val newBal = currentBal - amount
            userRef.update("balance", newBal).await()
            appPreferences.updateUserStatus(appPreferences.userStatus.value, newBal, User.getCurrentFormattedDate())

            val withdrawalData = hashMapOf(
                "email" to email,
                "name" to appPreferences.userName.value,
                "method" to method,
                "accountNumber" to accountNumber.trim(),
                "accountType" to accountType,
                "amount" to amount,
                "submittedAt" to User.getCurrentFormattedDate(),
                "status" to "pending",
                "reviewedAt" to "",
                "rejectionReason" to ""
            )

            firestore.collection("withdrawal_requests").add(withdrawalData).await()
            Result.success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    suspend fun getMyWithdrawalRequests(): Result<List<WithdrawalRequest>> = withContext(Dispatchers.IO) {
        try {
            val email = appPreferences.userEmail.value.trim().lowercase()
            val snap = firestore.collection("withdrawal_requests")
                .whereEqualTo("email", email)
                .get()
                .await()

            val list = snap.documents.map { doc ->
                WithdrawalRequest(
                    id = doc.id,
                    email = doc.getString("email") ?: "",
                    name = doc.getString("name") ?: "",
                    method = doc.getString("method") ?: "bKash",
                    accountNumber = doc.getString("accountNumber") ?: "",
                    accountType = doc.getString("accountType") ?: "personal",
                    amount = doc.getDouble("amount") ?: 0.0,
                    submittedAt = doc.getString("submittedAt") ?: "",
                    status = doc.getString("status") ?: "pending",
                    reviewedAt = doc.getString("reviewedAt") ?: "",
                    rejectionReason = doc.getString("rejectionReason") ?: ""
                )
            }.sortedByDescending { it.submittedAt }
            Result.success(list)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}

