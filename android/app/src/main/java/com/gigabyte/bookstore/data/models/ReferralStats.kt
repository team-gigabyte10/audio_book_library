package com.gigabyte.bookstore.data.models

data class ReferralStats(
    val referralCode: String = "",
    val totalFriendsJoined: Int = 0,
    val paidMembersCount: Int = 0,
    val totalEarned: Double = 0.0,
    val currentBalance: Double = 0.0,
    val rewards: List<ReferralReward> = emptyList()
)
