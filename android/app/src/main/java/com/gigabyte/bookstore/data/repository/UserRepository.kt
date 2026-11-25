package com.gigabyte.bookstore.data.repository

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import com.gigabyte.bookstore.data.models.AppPricingConfig
import com.gigabyte.bookstore.data.models.CourseUnlockPolicy
import com.google.firebase.firestore.ListenerRegistration
import com.gigabyte.bookstore.data.models.PaymentRequest
import com.gigabyte.bookstore.data.models.RecipientValidationResult
import com.gigabyte.bookstore.data.models.ReferralReward
import com.gigabyte.bookstore.data.models.ReferredUserItem
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

sealed class LoginResult {
    data class Success(val user: User) : LoginResult()
    object NotFound : LoginResult()
    object DeviceMismatch : LoginResult()
    object Offline : LoginResult()
    data class Error(val message: String) : LoginResult()
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
        institute: String = "",
        address: String = "",
        phone: String? = null,
        referralCodeInput: String? = null
    ): Result<User> = withContext(Dispatchers.IO) {
        try {
            val normalizedEmail = email.trim().lowercase()
            val deviceId = getDeviceId()
            val currentDate = User.getCurrentFormattedDate()

            val userDocRef = firestore.collection("users").document(normalizedEmail)
            val snapshot = userDocRef.get().await()

            // Never overwrite an existing account: that would reset status, balance and unlocked bundles.
            if (snapshot.exists()) {
                return@withContext Result.failure(
                    Exception("এই ইমেইলে আগে থেকেই অ্যাকাউন্ট আছে। অনুগ্রহ করে লগইন করুন। (Account already exists — please log in.)")
                )
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

    /**
     * Logs in with email + this phone's device ID (ANDROID_ID). The device ID is read here,
     * never typed or shown to the user. Accounts have no password.
     * - Account's deviceId matches this phone → success.
     * - Account's deviceId is a different phone → DeviceMismatch (one phone per account).
     * - Account has no deviceId yet (e.g. reset by an admin) → bound to this phone.
     */
    suspend fun loginWithEmail(email: String): LoginResult = withContext(Dispatchers.IO) {
        if (!com.gigabyte.bookstore.data.util.NetworkUtils.isOnline(context)) {
            return@withContext LoginResult.Offline
        }
        try {
            val normalizedEmail = email.trim().lowercase()
            val userDocRef = firestore.collection("users").document(normalizedEmail)
            val snapshot = userDocRef.get().await()
            if (!snapshot.exists()) {
                return@withContext LoginResult.NotFound
            }

            val deviceId = getDeviceId()
            val registeredDeviceId = snapshot.getString("deviceId") ?: ""
            if (registeredDeviceId.isNotBlank() && registeredDeviceId != deviceId) {
                return@withContext LoginResult.DeviceMismatch
            }

            val name = snapshot.getString("name") ?: ""
            val status = snapshot.getString("status") ?: "trial"
            val balance = snapshot.getDouble("balance") ?: 0.0
            var referralCode = snapshot.getString("referralCode") ?: ""
            val currentDate = User.getCurrentFormattedDate()

            val updates = hashMapOf<String, Any>("lastLoginAt" to currentDate, "deviceId" to deviceId)
            if (referralCode.isBlank()) {
                referralCode = User.generateReferralCode(name)
                updates["referralCode"] = referralCode
            }
            try {
                userDocRef.update(updates).await()
            } catch (e: Exception) {
                // Non-critical: the session below still works
            }

            val rawBundles = (snapshot.get("unlockedBundles") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()
            val rawCourses = (snapshot.get("assignedCourses") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()
            val bundlesSet = rawBundles.map { com.gigabyte.bookstore.data.preferences.AppPreferences.normalizeBundleId(it) }.toMutableSet()
            bundlesSet.addAll(rawCourses.map { com.gigabyte.bookstore.data.preferences.AppPreferences.normalizeBundleId(it) })
            if (status.equals("paid", ignoreCase = true) && bundlesSet.isEmpty()) {
                bundlesSet.add("audiobook_bundle")
            }

            val isAdmin = isUserAdmin(snapshot, normalizedEmail)
            appPreferences.setIsAdmin(isAdmin)
            val walletPin = snapshot.getString("walletPin") ?: ""

            val user = User(
                name = name,
                email = normalizedEmail,
                institute = snapshot.getString("institute") ?: "",
                address = snapshot.getString("address") ?: "",
                phone = snapshot.getString("phone"),
                deviceId = deviceId,
                status = status,
                balance = balance,
                referralCode = referralCode,
                referredBy = snapshot.getString("referredBy"),
                referralRewardPaid = snapshot.getBoolean("referralRewardPaid") ?: false,
                unlockedBundles = bundlesSet.toList(),
                role = snapshot.getString("role") ?: if (isAdmin) "admin" else "customer",
                isAdmin = isAdmin,
                walletPin = walletPin,
                createdAt = snapshot.getString("createdAt") ?: "",
                lastLoginAt = currentDate
            )

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
                walletPin = user.walletPin,
                createdAt = user.createdAt,
                lastLoginAt = user.lastLoginAt
            )
            appPreferences.setUnlockedBundles(bundlesSet)

            LoginResult.Success(user)
        } catch (e: Exception) {
            e.printStackTrace()
            LoginResult.Error(e.message ?: "Login failed")
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
            val rawCourses = (snapshot.get("assignedCourses") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()
            val bundlesSet = rawBundles.map { com.gigabyte.bookstore.data.preferences.AppPreferences.normalizeBundleId(it) }.toMutableSet()
            bundlesSet.addAll(rawCourses.map { com.gigabyte.bookstore.data.preferences.AppPreferences.normalizeBundleId(it) })
            if (status.equals("paid", ignoreCase = true) && bundlesSet.isEmpty()) {
                bundlesSet.add("audiobook_bundle")
            }
            appPreferences.setUnlockedBundles(bundlesSet)

            // Refresh local session with latest status, balance, and referral code
            appPreferences.updateUserStatus(status, balance, currentDate)
            appPreferences.updateReferralCode(referralCode)
            val walletPin = snapshot.getString("walletPin") ?: ""
            if (walletPin.isNotBlank()) {
                appPreferences.saveWalletPin(walletPin)
            }

            val isAdmin = isUserAdmin(snapshot, storedEmail)
            appPreferences.setIsAdmin(isAdmin)

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
                role = snapshot.getString("role") ?: if (isAdmin) "admin" else "customer",
                isAdmin = isAdmin,
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

    suspend fun deleteUserAccount(): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val email = appPreferences.userEmail.value.trim().lowercase()
            if (email.isNotBlank()) {
                firestore.collection("users").document(email).delete().await()
            }
            appPreferences.clearUserSession()
            Result.success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            appPreferences.clearUserSession()
            Result.success(Unit)
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
            val rawCourses = (userSnap.get("assignedCourses") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()
            val updatedBundles = rawBundles.map { com.gigabyte.bookstore.data.preferences.AppPreferences.normalizeBundleId(it) }.toMutableSet()
            updatedBundles.addAll(rawCourses.map { com.gigabyte.bookstore.data.preferences.AppPreferences.normalizeBundleId(it) })

            val normalizedPackage = com.gigabyte.bookstore.data.preferences.AppPreferences.normalizeBundleId(packageType)
            if (normalizedPackage == "mega_bundle") {
                updatedBundles.addAll(listOf(
                    "audiobook_bundle", "english_course", "japanese_course",
                    "chinese_course", "german_course", "arabic_course",
                    "korean_course", "urdu_course", "hindi_course",
                    "quran_course", "regional_course", "mega_bundle"
                ))
            } else {
                updatedBundles.add(normalizedPackage)
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
                        val rewardAmount = appPreferences.getPricingConfig().getReferralBonus(packageType, amount)
                        val updatedRefBal = refCurrentBal + rewardAmount

                        // Credit referral bonus to referrer's balance
                        referrerDoc.reference.update("balance", updatedRefBal).await()

                        // Mark this referred user as rewarded so they don't trigger multiple bonuses
                        userRef.update("referralRewardPaid", true).await()

                        // Log in referral_rewards collection
                        val rewardMap = hashMapOf(
                            "referrerEmail" to refEmail,
                            "referrerCode" to (referrerDoc.getString("referralCode") ?: ""),
                            "refereeEmail" to normalizedEmail,
                            "refereeName" to (userSnap.getString("name") ?: ""),
                            "amount" to rewardAmount,
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

            // 2. Fetch list of friends who registered using this user's referral code
            val referredUsers = if (myReferralCode.isNotBlank()) {
                val byCodeSnap = firestore.collection("users")
                    .whereEqualTo("referredBy", myReferralCode)
                    .get()
                    .await()
                byCodeSnap.documents.map { d ->
                    val email = d.getString("email") ?: d.id
                    val maskedEmail = if (email.contains("@")) {
                        val parts = email.split("@")
                        val prefix = parts[0]
                        val maskedPrefix = if (prefix.length > 3) prefix.take(3) + "***" else prefix.take(1) + "***"
                        "$maskedPrefix@${parts[1]}"
                    } else email
                    val status = d.getString("status") ?: "trial"
                    val bundles = (d.get("unlockedBundles") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()
                    val isPaid = status.equals("paid", ignoreCase = true) || status.equals("active", ignoreCase = true) || bundles.isNotEmpty()
                    val userReward = rewards.filter { it.refereeEmail.equals(email, ignoreCase = true) }.sumOf { it.amount }
                    ReferredUserItem(
                        email = maskedEmail,
                        name = d.getString("name") ?: "ব্যবহারকারী",
                        registeredAt = d.getString("createdAt") ?: "",
                        isPaid = isPaid,
                        unlockedBundles = bundles,
                        earnedReward = if (userReward > 0.0) userReward else if (isPaid) 20.0 else 0.0
                    )
                }.sortedByDescending { it.registeredAt }
            } else emptyList()

            var totalFriends = referredUsers.size
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
                    rewards = rewards,
                    referredUsers = referredUsers
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
            if (email.isBlank()) return@withContext Result.failure(Exception("অনুগ্রহ করে প্রথমে লগইন করুন"))
            if (amount < 100.0) return@withContext Result.failure(Exception("সর্বনিম্ন উত্তোলনের পরিমাণ ৳ ১০০.০০"))

            val userRef = firestore.collection("users").document(email)
            val userSnap = userRef.get().await()
            val currentBal = userSnap.getDouble("balance") ?: 0.0

            if (currentBal < amount) {
                return@withContext Result.failure(Exception("পর্যাপ্ত ব্যালেন্স নেই (বর্তমান ব্যালেন্স: ৳$currentBal)"))
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

    /**
     * Instantly purchases and unlocks a course using the user's earned affiliate wallet balance.
     */
    suspend fun purchaseCourseWithWalletBalance(
        packageType: String,
        amount: Double
    ): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val email = appPreferences.userEmail.value.trim().lowercase()
            if (email.isBlank()) return@withContext Result.failure(Exception("অনুগ্রহ করে প্রথমে লগইন করুন"))

            val userRef = firestore.collection("users").document(email)
            val userSnap = userRef.get().await()
            val currentBal = userSnap.getDouble("balance") ?: appPreferences.userBalance.value

            if (currentBal < amount) {
                return@withContext Result.failure(Exception("পর্যাপ্ত ওয়ালেট ব্যালেন্স নেই (বর্তমান: ৳ $currentBal)"))
            }

            val newBal = currentBal - amount
            val currentDate = User.getCurrentFormattedDate()
            val normalizedPackage = packageType.trim().lowercase()

            val existingBundles = (userSnap.get("unlockedBundles") as? List<*>)
                ?.mapNotNull { it?.toString() }
                ?.toMutableSet()
                ?: appPreferences.unlockedBundles.value.toMutableSet()

            if (normalizedPackage == "mega_bundle") {
                existingBundles.addAll(listOf(
                    "audiobook_bundle", "english_course", "japanese_course",
                    "chinese_course", "german_course", "arabic_course",
                    "korean_course", "urdu_course", "hindi_course",
                    "quran_course", "regional_course", "mega_bundle"
                ))
            } else {
                existingBundles.add(normalizedPackage)
            }

            userRef.update(
                mapOf(
                    "status" to "paid",
                    "balance" to newBal,
                    "unlockedBundles" to existingBundles.toList(),
                    "lastLoginAt" to currentDate
                )
            ).await()

            // Record as auto-approved wallet payment
            val paymentData = hashMapOf(
                "email" to email,
                "name" to (userSnap.getString("name") ?: appPreferences.userName.value),
                "phone" to (userSnap.getString("phone") ?: ""),
                "paymentMethod" to "WalletBalance",
                "trxId" to "WALLET-" + System.currentTimeMillis(),
                "packageType" to packageType,
                "amount" to amount,
                "status" to "approved",
                "submittedAt" to currentDate,
                "reviewedAt" to currentDate,
                "autoApproved" to true
            )
            firestore.collection("payment_requests").add(paymentData).await()

            // Immediately update local preferences state
            appPreferences.updateUserStatus("paid", newBal, currentDate)
            appPreferences.setUnlockedBundles(existingBundles)

            // Reward referrer if applicable
            val referredBy = userSnap.getString("referredBy") ?: ""
            val referralRewardPaid = userSnap.getBoolean("referralRewardPaid") ?: false

            if (referredBy.isNotBlank() && !referralRewardPaid) {
                try {
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
                        val rewardAmount = appPreferences.getPricingConfig().getReferralBonus(packageType, amount)
                        val updatedRefBal = refCurrentBal + rewardAmount

                        referrerDoc.reference.update("balance", updatedRefBal).await()
                        userRef.update("referralRewardPaid", true).await()

                        val rewardMap = hashMapOf(
                            "referrerEmail" to refEmail,
                            "referrerCode" to (referrerDoc.getString("referralCode") ?: ""),
                            "refereeEmail" to email,
                            "refereeName" to (userSnap.getString("name") ?: appPreferences.userName.value),
                            "amount" to rewardAmount,
                            "paidAt" to currentDate,
                            "status" to "rewarded"
                        )
                        firestore.collection("referral_rewards").add(rewardMap).await()

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

    /**
     * Sets or updates user's 4-digit Wallet Transaction PIN (stored as normal text).
     */
    suspend fun setWalletPin(pin: String): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val email = appPreferences.userEmail.value.trim().lowercase()
            if (email.isBlank()) return@withContext Result.failure(Exception("অনুগ্রহ করে প্রথমে লগইন করুন"))
            val cleanPin = pin.trim()
            if (cleanPin.length != 4 || !cleanPin.all { it.isDigit() }) {
                return@withContext Result.failure(Exception("ওয়ালেট পিন অবশ্যই ৪ ডিজিটের সংখ্যা হতে হবে"))
            }

            firestore.collection("users").document(email)
                .update("walletPin", cleanPin)
                .await()

            appPreferences.saveWalletPin(cleanPin)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Verifies if a recipient email exists in Firestore and whether they already own the target course/bundle.
     */
    suspend fun verifyRecipientUser(recipientEmail: String, packageId: String): Result<RecipientValidationResult> = withContext(Dispatchers.IO) {
        try {
            val myEmail = appPreferences.userEmail.value.trim().lowercase()
            val target = recipientEmail.trim().lowercase()
            if (target.isBlank() || !android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()) {
                return@withContext Result.failure(Exception("অনুগ্রহ করে সঠিক ইমেইল অ্যাড্রেস লিখুন"))
            }
            if (target == myEmail) {
                return@withContext Result.failure(Exception("নিজের জন্য কোর্স কিনতে 'নিজের জন্য কিনুন' অপশন ব্যবহার করুন"))
            }

            val doc = firestore.collection("users").document(target).get().await()
            if (!doc.exists()) {
                return@withContext Result.failure(Exception("এই ইমেইলে ($target) কোনো অ্যাকাউন্ট পাওয়া যায়নি। প্রাপককে প্রথমে অ্যাপে ফ্রি অ্যাকাউন্ট খুলতে বলুন।"))
            }

            val recipientName = doc.getString("name") ?: target
            val rawBundles = (doc.get("unlockedBundles") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()
            val rawCourses = (doc.get("assignedCourses") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()
            val bundlesSet = rawBundles.map { AppPreferences.normalizeBundleId(it) }.toMutableSet()
            bundlesSet.addAll(rawCourses.map { AppPreferences.normalizeBundleId(it) })

            val normalizedPackage = AppPreferences.normalizeBundleId(packageId)
            val alreadyUnlocked = bundlesSet.contains("mega_bundle") || bundlesSet.contains(normalizedPackage)

            val result = RecipientValidationResult(
                email = target,
                name = recipientName,
                isAlreadyUnlocked = alreadyUnlocked,
                unlockedBundles = bundlesSet.toList(),
                message = if (alreadyUnlocked) "প্রাপকের অ্যাকাউন্টে এই কোর্সটি ইতোমধ্যে আনলক করা আছে!" else "প্রাপক যাচাই সম্পন্ন হয়েছে।"
            )
            Result.success(result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Purchases a course or mega bundle for another user using the buyer's referral wallet balance.
     * Protected by 4-digit plaintext Wallet PIN and executed via an atomic Firestore transaction.
     * Awards the buyer the 20 Taka referral bonus on every successful referral.
     */
    suspend fun purchaseCourseForOtherUser(
        recipientEmail: String,
        packageType: String,
        amount: Double,
        enteredPin: String
    ): Result<Double> = withContext(Dispatchers.IO) {
        try {
            val buyerEmail = appPreferences.userEmail.value.trim().lowercase()
            val targetEmail = recipientEmail.trim().lowercase()
            val cleanPin = enteredPin.trim()

            if (buyerEmail.isBlank()) return@withContext Result.failure(Exception("অনুগ্রহ করে প্রথমে লগইন করুন"))
            if (targetEmail.isBlank()) return@withContext Result.failure(Exception("প্রাপকের ইমেইল উল্লেখ করুন"))
            if (targetEmail == buyerEmail) return@withContext Result.failure(Exception("নিজের জন্য কিনতে 'নিজের জন্য কিনুন' অপশন ব্যবহার করুন"))

            val storedPin = appPreferences.getWalletPin().trim()
            if (storedPin.isBlank()) {
                return@withContext Result.failure(Exception("প্রথমে আপনার ৪-ডিজিটের ওয়ালেট পিন সেট করুন"))
            }
            if (cleanPin != storedPin) {
                return@withContext Result.failure(Exception("ভুল ওয়ালেট পিন! আপনার ব্যালেন্স সুরক্ষায় লেনদেন বাতিল করা হয়েছে।"))
            }

            val buyerRef = firestore.collection("users").document(buyerEmail)
            val recipientRef = firestore.collection("users").document(targetEmail)
            val currentDate = User.getCurrentFormattedDate()
            val normalizedPackage = AppPreferences.normalizeBundleId(packageType)
            val rewardAmount = appPreferences.getPricingConfig().getReferralBonus(packageType, amount)

            var updatedBuyerBal = 0.0
            var recipientName = targetEmail
            var recipientReferredBy = ""
            var recipientReferralRewardPaid = false
            var buyerRefCode = appPreferences.referralCode.value

            firestore.runTransaction { transaction ->
                val buyerSnap = transaction.get(buyerRef)
                val recipientSnap = transaction.get(recipientRef)

                if (!buyerSnap.exists()) {
                    throw Exception("ক্রেতার অ্যাকাউন্ট পাওয়া যায়নি")
                }
                if (!recipientSnap.exists()) {
                    throw Exception("প্রাপকের অ্যাকাউন্ট পাওয়া যায়নি")
                }

                val firestorePin = buyerSnap.getString("walletPin") ?: storedPin
                if (cleanPin != firestorePin) {
                    throw Exception("ভুল ওয়ালেট পিন! লেনদেন বাতিল করা হয়েছে।")
                }

                val currentBuyerBal = buyerSnap.getDouble("balance") ?: 0.0
                if (currentBuyerBal < amount) {
                    throw Exception("পর্যাপ্ত ওয়ালেট ব্যালেন্স নেই (বর্তমান: ৳ ${"%.2f".format(currentBuyerBal)})")
                }

                buyerRefCode = buyerSnap.getString("referralCode") ?: appPreferences.referralCode.value
                recipientName = recipientSnap.getString("name") ?: targetEmail
                recipientReferredBy = recipientSnap.getString("referredBy") ?: ""
                recipientReferralRewardPaid = recipientSnap.getBoolean("referralRewardPaid") ?: false

                val rawBundles = (recipientSnap.get("unlockedBundles") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()
                val rawCourses = (recipientSnap.get("assignedCourses") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()
                val targetBundles = rawBundles.map { AppPreferences.normalizeBundleId(it) }.toMutableSet()
                targetBundles.addAll(rawCourses.map { AppPreferences.normalizeBundleId(it) })

                if (targetBundles.contains("mega_bundle") || targetBundles.contains(normalizedPackage)) {
                    throw Exception("প্রাপকের অ্যাকাউন্টে এই কোর্সটি ইতোমধ্যে আনলক করা আছে!")
                }

                if (normalizedPackage == "mega_bundle") {
                    targetBundles.addAll(listOf(
                        "audiobook_bundle", "english_course", "japanese_course",
                        "chinese_course", "german_course", "arabic_course",
                        "korean_course", "urdu_course", "hindi_course",
                        "quran_course", "regional_course", "mega_bundle"
                    ))
                } else {
                    targetBundles.add(normalizedPackage)
                }

                // Deduct package price and add the 20 Taka referral bonus to buyer's balance
                updatedBuyerBal = currentBuyerBal - amount + rewardAmount
                transaction.update(buyerRef, mapOf(
                    "balance" to updatedBuyerBal,
                    "lastLoginAt" to currentDate
                ))

                val recipientUpdates = mutableMapOf<String, Any>(
                    "status" to "paid",
                    "unlockedBundles" to targetBundles.toList(),
                    "referralRewardPaid" to true,
                    "lastLoginAt" to currentDate
                )
                if (recipientReferredBy.isBlank()) {
                    recipientUpdates["referredBy"] = buyerRefCode.ifBlank { buyerEmail }
                }
                transaction.update(recipientRef, recipientUpdates)
            }.await()

            // Record transaction in payment_requests
            val paymentData = hashMapOf(
                "email" to buyerEmail,
                "name" to appPreferences.userName.value,
                "phone" to (appPreferences.userPhone.value),
                "recipientEmail" to targetEmail,
                "recipientName" to recipientName,
                "paymentMethod" to "WalletGift",
                "trxId" to "GIFT-" + System.currentTimeMillis(),
                "packageType" to packageType,
                "amount" to amount,
                "status" to "approved",
                "submittedAt" to currentDate,
                "reviewedAt" to currentDate,
                "autoApproved" to true,
                "isGift" to true
            )
            firestore.collection("payment_requests").add(paymentData).await()

            // Record the 20 Taka reward in referral_rewards collection
            val rewardMap = hashMapOf(
                "referrerEmail" to buyerEmail,
                "referrerCode" to buyerRefCode,
                "refereeEmail" to targetEmail,
                "refereeName" to recipientName,
                "amount" to rewardAmount,
                "paidAt" to currentDate,
                "status" to "rewarded"
            )
            firestore.collection("referral_rewards").add(rewardMap).await()

            // Update buyer's local balance immediately with the referral bonus included
            appPreferences.updateUserStatus(appPreferences.userStatus.value, updatedBuyerBal, currentDate)

            Result.success(rewardAmount)
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

    /**
     * Allows an admin to update a user's role, status, and unlocked course bundles in Firebase Firestore.
     */
    suspend fun adminUpdateUserRoleAndCourses(
        targetUserEmail: String,
        role: String? = null,
        status: String? = null,
        bundlesToAdd: List<String> = emptyList(),
        bundlesToRemove: List<String> = emptyList()
    ): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val normalizedEmail = targetUserEmail.trim().lowercase()
            val userRef = firestore.collection("users").document(normalizedEmail)
            val userSnap = userRef.get().await()
            if (!userSnap.exists()) {
                return@withContext Result.failure(Exception("ইউজার পাওয়া যায়নি ($normalizedEmail)"))
            }

            val rawBundles = (userSnap.get("unlockedBundles") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()
            val currentBundles = rawBundles.map { com.gigabyte.bookstore.data.preferences.AppPreferences.normalizeBundleId(it) }.toMutableSet()

            bundlesToAdd.forEach { currentBundles.add(com.gigabyte.bookstore.data.preferences.AppPreferences.normalizeBundleId(it)) }
            bundlesToRemove.forEach { currentBundles.remove(com.gigabyte.bookstore.data.preferences.AppPreferences.normalizeBundleId(it)) }

            val updates = mutableMapOf<String, Any>(
                "unlockedBundles" to currentBundles.toList()
            )
            role?.let {
                updates["role"] = it
                if (it.equals("admin", ignoreCase = true)) {
                    updates["isAdmin"] = true
                }
            }
            status?.let { updates["status"] = it }

            userRef.update(updates).await()

            // If the updated user is the currently logged-in user, refresh locally
            if (appPreferences.userEmail.value.equals(normalizedEmail, ignoreCase = true)) {
                appPreferences.setUnlockedBundles(currentBundles)
                status?.let {
                    appPreferences.updateUserStatus(it, appPreferences.userBalance.value, User.getCurrentFormattedDate())
                }
                role?.let {
                    appPreferences.setIsAdmin(it.equals("admin", ignoreCase = true))
                }
            }

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Checks if a user has admin privileges based on Firestore document data or known admin emails.
     */
    fun isUserAdmin(snapshot: com.google.firebase.firestore.DocumentSnapshot, email: String): Boolean {
        val role = snapshot.getString("role") ?: ""
        val isAdminFlag = snapshot.getBoolean("isAdmin") ?: false
        val status = snapshot.getString("status") ?: ""
        val cleanEmail = email.trim().lowercase()
        return isAdminFlag ||
                role.equals("admin", ignoreCase = true) ||
                status.equals("admin", ignoreCase = true) ||
                cleanEmail == "teamgigabyte10@gmail.com"
    }

    data class PaymentNumbersConfig(
        val numbers: Map<String, String> = mapOf(
            "bKash" to "01700-000000",
            "Nagad" to "01800-000000",
            "Rocket" to "01900-000000"
        ),
        val types: Map<String, String> = mapOf(
            "bKash" to "Personal",
            "Nagad" to "Personal",
            "Rocket" to "Personal"
        )
    )

    /**
     * Dynamically fetches active payment numbers and account types from Firebase Firestore (settings/payment or payment_settings/numbers).
     */
    suspend fun getPaymentNumbers(): PaymentNumbersConfig = withContext(Dispatchers.IO) {
        val defaultNumbers = mutableMapOf(
            "bKash" to "01700-000000",
            "Nagad" to "01800-000000",
            "Rocket" to "01900-000000"
        )
        val defaultTypes = mutableMapOf(
            "bKash" to "Personal",
            "Nagad" to "Personal",
            "Rocket" to "Personal"
        )

        try {
            // Primary path: settings/payment
            var doc = firestore.collection("settings").document("payment").get().await()
            if (!doc.exists()) {
                // Secondary fallback path: payment_settings/numbers
                doc = firestore.collection("payment_settings").document("numbers").get().await()
            }

            if (doc.exists()) {
                val bkash = doc.getString("bkash") ?: doc.getString("bKash")
                val nagad = doc.getString("nagad") ?: doc.getString("Nagad")
                val rocket = doc.getString("rocket") ?: doc.getString("Rocket")

                if (!bkash.isNullOrBlank()) defaultNumbers["bKash"] = bkash.trim()
                if (!nagad.isNullOrBlank()) defaultNumbers["Nagad"] = nagad.trim()
                if (!rocket.isNullOrBlank()) defaultNumbers["Rocket"] = rocket.trim()

                val bkashType = doc.getString("bkashType") ?: doc.getString("bKashType")
                val nagadType = doc.getString("nagadType") ?: doc.getString("NagadType")
                val rocketType = doc.getString("rocketType") ?: doc.getString("RocketType")

                if (!bkashType.isNullOrBlank()) defaultTypes["bKash"] = bkashType.trim()
                if (!nagadType.isNullOrBlank()) defaultTypes["Nagad"] = nagadType.trim()
                if (!rocketType.isNullOrBlank()) defaultTypes["Rocket"] = rocketType.trim()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        PaymentNumbersConfig(numbers = defaultNumbers, types = defaultTypes)
    }

    private var policyListenerRegistration: ListenerRegistration? = null
    private var pricingListenerRegistration: ListenerRegistration? = null

    /**
     * Real-time listener for Backend-controlled Pricing & Referral Bonus Config from Firestore (settings/pricing).
     */
    fun listenAppPricingConfig() {
        if (pricingListenerRegistration != null) return
        try {
            val docRef = firestore.collection("settings").document("pricing")
            pricingListenerRegistration = docRef.addSnapshotListener { snapshot, error ->
                if (error != null) {
                    android.util.Log.w("UserRepository", "Error listening to settings/pricing", error)
                    return@addSnapshotListener
                }
                if (snapshot != null && snapshot.exists()) {
                    val megaBundlePrice = snapshot.getDouble("megaBundlePrice") ?: 300.0
                    val singleCoursePrice = snapshot.getDouble("singleCoursePrice") ?: 100.0
                    val bundleReferralBonus = snapshot.getDouble("bundleReferralBonus") ?: 40.0
                    val singleReferralBonus = snapshot.getDouble("singleReferralBonus") ?: 20.0
                    val minWithdrawalAmount = snapshot.getDouble("minWithdrawalAmount") ?: 100.0
                    val packagePricesRaw = snapshot.get("packagePrices") as? Map<*, *>
                    val packagePrices = packagePricesRaw?.mapNotNull { (k, v) ->
                        val key = k?.toString() ?: return@mapNotNull null
                        val value = (v as? Number)?.toDouble() ?: return@mapNotNull null
                        key to value
                    }?.toMap() ?: emptyMap()

                    val config = AppPricingConfig(
                        megaBundlePrice = megaBundlePrice,
                        singleCoursePrice = singleCoursePrice,
                        bundleReferralBonus = bundleReferralBonus,
                        singleReferralBonus = singleReferralBonus,
                        minWithdrawalAmount = minWithdrawalAmount,
                        packagePrices = packagePrices,
                        referralMessageTemplate = snapshot.getString("referralMessageTemplate") ?: "",
                        playStoreAppTitle = snapshot.getString("playStoreAppTitle") ?: AppPricingConfig.DEFAULT_PLAY_STORE_TITLE,
                        playStoreAppUrl = snapshot.getString("playStoreAppUrl") ?: AppPricingConfig.DEFAULT_PLAY_STORE_URL,
                        minRequiredVersionCode = snapshot.getLong("minRequiredVersionCode")?.toInt() ?: 1,
                        latestVersionCode = snapshot.getLong("latestVersionCode")?.toInt() ?: 1,
                        latestVersionName = snapshot.getString("latestVersionName") ?: "1.5",
                        isForceUpdateRequired = snapshot.getBoolean("isForceUpdateRequired") ?: snapshot.getBoolean("forceUpdate") ?: false,
                        updateTitle = snapshot.getString("updateTitle") ?: AppPricingConfig.DEFAULT_UPDATE_TITLE,
                        updateMessage = snapshot.getString("updateMessage") ?: AppPricingConfig.DEFAULT_UPDATE_MESSAGE,
                        updateFeatures = (snapshot.get("updateFeatures") as? List<*>)?.mapNotNull { it?.toString() } ?: AppPricingConfig.DEFAULT_UPDATE_FEATURES,
                        updatedAt = snapshot.getString("updatedAt") ?: "",
                        updatedBy = snapshot.getString("updatedBy") ?: ""
                    )
                    appPreferences.savePricingConfig(config)
                }
            }
        } catch (e: Exception) {
            android.util.Log.e("UserRepository", "Failed to attach settings/pricing listener", e)
        }
    }

    fun stopListeningAppPricingConfig() {
        pricingListenerRegistration?.remove()
        pricingListenerRegistration = null
    }

    /**
     * Fetches current Pricing Config from Firebase Firestore (settings/pricing).
     */
    suspend fun fetchAppPricingConfig(): AppPricingConfig = withContext(Dispatchers.IO) {
        try {
            val doc = firestore.collection("settings").document("pricing").get().await()
            if (doc.exists()) {
                val megaBundlePrice = doc.getDouble("megaBundlePrice") ?: 300.0
                val singleCoursePrice = doc.getDouble("singleCoursePrice") ?: 100.0
                val bundleReferralBonus = doc.getDouble("bundleReferralBonus") ?: 40.0
                val singleReferralBonus = doc.getDouble("singleReferralBonus") ?: 20.0
                val minWithdrawalAmount = doc.getDouble("minWithdrawalAmount") ?: 100.0
                val packagePricesRaw = doc.get("packagePrices") as? Map<*, *>
                val packagePrices = packagePricesRaw?.mapNotNull { (k, v) ->
                    val key = k?.toString() ?: return@mapNotNull null
                    val value = (v as? Number)?.toDouble() ?: return@mapNotNull null
                    key to value
                }?.toMap() ?: emptyMap()

                val config = AppPricingConfig(
                    megaBundlePrice = megaBundlePrice,
                    singleCoursePrice = singleCoursePrice,
                    bundleReferralBonus = bundleReferralBonus,
                    singleReferralBonus = singleReferralBonus,
                    minWithdrawalAmount = minWithdrawalAmount,
                    packagePrices = packagePrices,
                    referralMessageTemplate = doc.getString("referralMessageTemplate") ?: "",
                    playStoreAppTitle = doc.getString("playStoreAppTitle") ?: AppPricingConfig.DEFAULT_PLAY_STORE_TITLE,
                    playStoreAppUrl = doc.getString("playStoreAppUrl") ?: AppPricingConfig.DEFAULT_PLAY_STORE_URL,
                    minRequiredVersionCode = doc.getLong("minRequiredVersionCode")?.toInt() ?: 1,
                    latestVersionCode = doc.getLong("latestVersionCode")?.toInt() ?: 1,
                    latestVersionName = doc.getString("latestVersionName") ?: "1.5",
                    isForceUpdateRequired = doc.getBoolean("isForceUpdateRequired") ?: doc.getBoolean("forceUpdate") ?: false,
                    updateTitle = doc.getString("updateTitle") ?: AppPricingConfig.DEFAULT_UPDATE_TITLE,
                    updateMessage = doc.getString("updateMessage") ?: AppPricingConfig.DEFAULT_UPDATE_MESSAGE,
                    updateFeatures = (doc.get("updateFeatures") as? List<*>)?.mapNotNull { it?.toString() } ?: AppPricingConfig.DEFAULT_UPDATE_FEATURES,
                    updatedAt = doc.getString("updatedAt") ?: "",
                    updatedBy = doc.getString("updatedBy") ?: ""
                )
                appPreferences.savePricingConfig(config)
                return@withContext config
            }
        } catch (e: Exception) {
            android.util.Log.e("UserRepository", "fetchAppPricingConfig error", e)
        }
        return@withContext appPreferences.getPricingConfig()
    }

    /**
     * Updates Pricing Config in Firebase Firestore (settings/pricing).
     * Admin only.
     */
    suspend fun updateAppPricingConfig(
        config: AppPricingConfig,
        adminEmail: String = ""
    ): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val currentDate = User.getCurrentFormattedDate()
            val data = mapOf(
                "megaBundlePrice" to config.megaBundlePrice,
                "singleCoursePrice" to config.singleCoursePrice,
                "bundleReferralBonus" to config.bundleReferralBonus,
                "singleReferralBonus" to config.singleReferralBonus,
                "minWithdrawalAmount" to config.minWithdrawalAmount,
                "packagePrices" to config.packagePrices,
                "referralMessageTemplate" to config.referralMessageTemplate,
                "playStoreAppTitle" to config.playStoreAppTitle,
                "playStoreAppUrl" to config.playStoreAppUrl,
                "updatedAt" to currentDate,
                "updatedBy" to adminEmail.trim().lowercase()
            )
            firestore.collection("settings").document("pricing").set(data).await()
            val updated = config.copy(updatedAt = currentDate, updatedBy = adminEmail)
            appPreferences.savePricingConfig(updated)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Starts listening to real-time changes of the Course Unlock Policy from Firebase Firestore (settings/course_config).
     * Automatically keeps AppPreferences in sync.
     */
    fun listenCourseUnlockPolicy() {
        if (policyListenerRegistration != null) return
        try {
            val docRef = firestore.collection("settings").document("course_config")
            policyListenerRegistration = docRef.addSnapshotListener { snapshot, error ->
                if (error != null) {
                    android.util.Log.w("UserRepository", "Error listening to course_config", error)
                    return@addSnapshotListener
                }
                if (snapshot != null && snapshot.exists()) {
                    val mode = snapshot.getString("unlockMode") ?: CourseUnlockPolicy.MODE_AD_AND_PAID
                    val allowAds = snapshot.getBoolean("allowRewardedAdUnlock") ?: true
                    val hours = snapshot.getLong("rewardUnlockHours")?.toInt() ?: 24
                    val freeParts = snapshot.getLong("freePreviewPartCount")?.toInt() ?: 1
                    val policy = CourseUnlockPolicy(
                        unlockMode = mode,
                        allowRewardedAdUnlock = allowAds,
                        rewardUnlockHours = hours,
                        freePreviewPartCount = freeParts,
                        updatedAt = snapshot.getString("updatedAt") ?: "",
                        updatedBy = snapshot.getString("updatedBy") ?: ""
                    )
                    appPreferences.saveCourseUnlockPolicy(policy)
                }
            }
        } catch (e: Exception) {
            android.util.Log.e("UserRepository", "Failed to attach course_config listener", e)
        }
    }

    fun stopListeningCourseUnlockPolicy() {
        policyListenerRegistration?.remove()
        policyListenerRegistration = null
    }

    /**
     * Fetches current Course Unlock Policy from Firebase Firestore (settings/course_config).
     */
    suspend fun fetchCourseUnlockPolicy(): CourseUnlockPolicy = withContext(Dispatchers.IO) {
        try {
            val doc = firestore.collection("settings").document("course_config").get().await()
            if (doc.exists()) {
                val mode = doc.getString("unlockMode") ?: CourseUnlockPolicy.MODE_AD_AND_PAID
                val allowAds = doc.getBoolean("allowRewardedAdUnlock") ?: true
                val hours = doc.getLong("rewardUnlockHours")?.toInt() ?: 24
                val freeParts = doc.getLong("freePreviewPartCount")?.toInt() ?: 1
                val policy = CourseUnlockPolicy(
                    unlockMode = mode,
                    allowRewardedAdUnlock = allowAds,
                    rewardUnlockHours = hours,
                    freePreviewPartCount = freeParts,
                    updatedAt = doc.getString("updatedAt") ?: "",
                    updatedBy = doc.getString("updatedBy") ?: ""
                )
                appPreferences.saveCourseUnlockPolicy(policy)
                return@withContext policy
            }
        } catch (e: Exception) {
            android.util.Log.e("UserRepository", "fetchCourseUnlockPolicy error", e)
        }
        return@withContext appPreferences.getCourseUnlockPolicy()
    }

    /**
     * Updates the Course Unlock Policy in Firebase Firestore (settings/course_config).
     * Admin only.
     */
    suspend fun updateCourseUnlockPolicy(
        unlockMode: String,
        allowRewardedAdUnlock: Boolean,
        rewardUnlockHours: Int = 24,
        adminEmail: String = ""
    ): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val currentDate = User.getCurrentFormattedDate()
            val data = mapOf(
                "unlockMode" to unlockMode,
                "allowRewardedAdUnlock" to allowRewardedAdUnlock,
                "rewardUnlockHours" to rewardUnlockHours,
                "updatedAt" to currentDate,
                "updatedBy" to adminEmail.trim().lowercase()
            )
            firestore.collection("settings").document("course_config").set(data).await()

            val policy = CourseUnlockPolicy(
                unlockMode = unlockMode,
                allowRewardedAdUnlock = allowRewardedAdUnlock,
                rewardUnlockHours = rewardUnlockHours,
                updatedAt = currentDate,
                updatedBy = adminEmail
            )
            appPreferences.saveCourseUnlockPolicy(policy)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Looks up an account's registered email using their phone number.
     * Sanitizes phone input (removing spaces, dashes, +88) and matches against Firestore users.
     */
    suspend fun findEmailByPhone(phone: String): Result<String> = withContext(Dispatchers.IO) {
        try {
            val cleanEntered = phone.trim().replace("+88", "").replace(" ", "").replace("-", "")
            if (cleanEntered.length < 10) {
                return@withContext Result.failure(Exception("অনুগ্রহ করে সঠিক ফোন নম্বর দিন (ন্যূনতম ১০ বা ১১ ডিজিট)"))
            }

            val querySnapshot = firestore.collection("users").get().await()
            for (doc in querySnapshot.documents) {
                val registeredPhone = doc.getString("phone")?.trim() ?: ""
                val cleanRegistered = registeredPhone.replace("+88", "").replace(" ", "").replace("-", "")
                if (cleanRegistered.isNotBlank() && (cleanRegistered == cleanEntered || cleanRegistered.endsWith(cleanEntered) || cleanEntered.endsWith(cleanRegistered))) {
                    val email = doc.getString("email") ?: doc.id
                    return@withContext Result.success(email)
                }
            }
            Result.failure(Exception("এই ফোন নম্বরে কোনো রেজিস্টার্ড অ্যাকাউন্ট পাওয়া যায়নি"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Resets the 4-digit Wallet PIN after verifying the registered phone number of the current user.
     */
    suspend fun resetWalletPin(phone: String, newPin: String): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val email = appPreferences.userEmail.value.trim().lowercase()
            if (email.isBlank()) return@withContext Result.failure(Exception("অনুগ্রহ করে প্রথমে লগইন করুন"))

            val cleanPin = newPin.trim()
            if (cleanPin.length != 4 || !cleanPin.all { it.isDigit() }) {
                return@withContext Result.failure(Exception("নতুন ওয়ালেট পিন অবশ্যই ৪ ডিজিটের সংখ্যা হতে হবে"))
            }

            val userDoc = firestore.collection("users").document(email).get().await()
            if (!userDoc.exists()) {
                return@withContext Result.failure(Exception("ব্যবহারকারীর প্রোফাইল পাওয়া যায়নি"))
            }

            val registeredPhone = userDoc.getString("phone")?.trim() ?: ""
            val cleanEntered = phone.trim().replace("+88", "").replace(" ", "").replace("-", "")
            val cleanRegistered = registeredPhone.replace("+88", "").replace(" ", "").replace("-", "")

            if (cleanRegistered.isBlank() || (cleanRegistered != cleanEntered && !cleanRegistered.endsWith(cleanEntered) && !cleanEntered.endsWith(cleanRegistered))) {
                return@withContext Result.failure(Exception("প্রদত্ত ফোন নম্বরটি আপনার অ্যাকাউন্টের সাথে মিলছে না"))
            }

            firestore.collection("users").document(email)
                .update("walletPin", cleanPin)
                .await()

            appPreferences.saveWalletPin(cleanPin)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
