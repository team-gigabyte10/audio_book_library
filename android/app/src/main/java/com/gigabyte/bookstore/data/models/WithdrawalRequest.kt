package com.gigabyte.bookstore.data.models

data class WithdrawalRequest(
    val id: String = "",
    val email: String = "",
    val name: String = "",
    val method: String = "bKash",
    val accountNumber: String = "",
    val accountType: String = "personal",
    val amount: Double = 0.0,
    val submittedAt: String = "",
    val status: String = "pending",
    val reviewedAt: String = "",
    val rejectionReason: String = ""
)
