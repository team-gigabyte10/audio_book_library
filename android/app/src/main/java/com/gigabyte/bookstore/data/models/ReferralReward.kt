package com.gigabyte.bookstore.data.models

data class ReferralReward(
    val id: String = "",
    val referrerEmail: String = "",
    val refereeEmail: String = "",
    val refereeName: String = "",
    val amount: Double = 20.0,
    val paidAt: String = "",
    val status: String = "rewarded"
)
