package com.gigabyte.bookstore.data.models

data class PaymentRequest(
    val id: String = "",
    val email: String = "",
    val deviceId: String = "",
    val method: String = "",
    val transactionId: String = "",
    val amount: Double = 0.0,
    val submittedAt: String = "",
    val status: String = "pending", // "pending", "approved", "rejected"
    val reviewedAt: String = "",
    val rejectionReason: String = ""
)
