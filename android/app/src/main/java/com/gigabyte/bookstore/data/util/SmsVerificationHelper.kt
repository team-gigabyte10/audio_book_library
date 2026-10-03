package com.gigabyte.bookstore.data.util

import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.abs

data class SmsVerificationResult(
    val isFound: Boolean,
    val sender: String = "",
    val body: String = "",
    val date: String = "",
    val extractedAmount: Double? = null,
    val expectedAmount: Double = 0.0,
    val isAmountMatching: Boolean? = null,
    val errorMessage: String? = null
)

object SmsVerificationHelper {

    fun hasSmsPermission(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            android.Manifest.permission.READ_SMS
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun verifyTransaction(
        context: Context,
        transactionId: String,
        expectedAmount: Double
    ): SmsVerificationResult {
        val cleanTrx = transactionId.trim()
        if (cleanTrx.isBlank()) {
            return SmsVerificationResult(
                isFound = false,
                expectedAmount = expectedAmount,
                errorMessage = "ট্রানজেকশন আইডি খালি।"
            )
        }

        if (!hasSmsPermission(context)) {
            return SmsVerificationResult(
                isFound = false,
                expectedAmount = expectedAmount,
                errorMessage = "এসএমএস পড়ার পারমিশন দেওয়া নেই।"
            )
        }

        return try {
            val inboxUri = Uri.parse("content://sms/inbox")
            val projection = arrayOf("_id", "address", "body", "date")
            // Fetch recent 150 inbox messages to search reliably
            val sortOrder = "date DESC LIMIT 150"

            val cursor = context.contentResolver.query(
                inboxUri,
                projection,
                null,
                null,
                sortOrder
            )

            var matchedResult: SmsVerificationResult? = null

            cursor?.use { c ->
                val addressIdx = c.getColumnIndexOrThrow("address")
                val bodyIdx = c.getColumnIndexOrThrow("body")
                val dateIdx = c.getColumnIndexOrThrow("date")

                while (c.moveToNext()) {
                    val body = c.getString(bodyIdx) ?: ""
                    val address = c.getString(addressIdx) ?: ""
                    val dateMillis = c.getLong(dateIdx)

                    // Case-insensitive match for the transaction ID
                    if (body.contains(cleanTrx, ignoreCase = true)) {
                        val formattedDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                            .format(Date(dateMillis))

                        val extractedAmount = parseAmountFromSms(body)
                        val amountMatches = if (extractedAmount != null) {
                            abs(extractedAmount - expectedAmount) < 0.5
                        } else null

                        matchedResult = SmsVerificationResult(
                            isFound = true,
                            sender = address,
                            body = body,
                            date = formattedDate,
                            extractedAmount = extractedAmount,
                            expectedAmount = expectedAmount,
                            isAmountMatching = amountMatches
                        )
                        break
                    }
                }
            }

            matchedResult ?: SmsVerificationResult(
                isFound = false,
                expectedAmount = expectedAmount,
                errorMessage = "ইনবক্সে '$cleanTrx' ট্রানজেকশন আইডি সম্বলিত কোনো এসএমএস পাওয়া যায়নি।"
            )
        } catch (e: Exception) {
            e.printStackTrace()
            SmsVerificationResult(
                isFound = false,
                expectedAmount = expectedAmount,
                errorMessage = "এসএমএস পড়তে ত্রুটি হয়েছে: ${e.localizedMessage}"
            )
        }
    }

    /**
     * Extracts received amount from typical Bangladeshi MFS SMS formats:
     * - bKash: "You have received Tk 100.00 from ... TrxID ..."
     * - Nagad: "Received Tk 100.00 from ... TxnID: ..."
     * - Rocket: "Cash In received Tk 100.00 from ... TxnId: ..."
     */
    private fun parseAmountFromSms(body: String): Double? {
        // Pattern 1: (?:received|cash in|Tk|Tk\.|BDT)\s*(?:Tk|Tk\.|BDT)?\s*([0-9,]+(?:\.[0-9]{1,2})?)
        val regexPatterns = listOf(
            Regex("""(?:received|Cash In received|Payment received)\s+(?:Tk|Tk\.|BDT)?\s*([0-9,]+(?:\.[0-9]{1,2})?)""", RegexOption.IGNORE_CASE),
            Regex("""(?:Tk|Tk\.|BDT)\s*([0-9,]+(?:\.[0-9]{1,2})?)""", RegexOption.IGNORE_CASE)
        )

        for (pattern in regexPatterns) {
            val match = pattern.find(body)
            if (match != null) {
                val rawAmountStr = match.groupValues[1].replace(",", "")
                val parsed = rawAmountStr.toDoubleOrNull()
                if (parsed != null && parsed > 0) {
                    return parsed
                }
            }
        }
        return null
    }
}
