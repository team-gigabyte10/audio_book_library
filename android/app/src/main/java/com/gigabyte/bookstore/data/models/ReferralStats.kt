package com.gigabyte.bookstore.data.models

/**
 * Item representing a friend/user who registered using the affiliate referral code.
 */
data class ReferredUserItem(
    val email: String = "",
    val name: String = "",
    val registeredAt: String = "",
    val isPaid: Boolean = false,
    val unlockedBundles: List<String> = emptyList(),
    val earnedReward: Double = 0.0
)

data class ReferralStats(
    val referralCode: String = "",
    val totalFriendsJoined: Int = 0,
    val paidMembersCount: Int = 0,
    val totalEarned: Double = 0.0,
    val currentBalance: Double = 0.0,
    val rewards: List<ReferralReward> = emptyList(),
    val referredUsers: List<ReferredUserItem> = emptyList()
)
