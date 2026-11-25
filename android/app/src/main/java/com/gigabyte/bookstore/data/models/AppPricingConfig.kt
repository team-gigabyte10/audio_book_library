package com.gigabyte.bookstore.data.models

/**
 * Backend-controlled pricing and referral configuration.
 * Synced in real-time from Firebase Firestore (`settings/pricing`).
 */
data class AppPricingConfig(
    val megaBundlePrice: Double = 300.0,
    val singleCoursePrice: Double = 100.0,
    val bundleReferralBonus: Double = 40.0,
    val singleReferralBonus: Double = 20.0,
    val minWithdrawalAmount: Double = 100.0,
    val packagePrices: Map<String, Double> = emptyMap(),
    val referralMessageTemplate: String = "",
    val playStoreAppTitle: String = DEFAULT_PLAY_STORE_TITLE,
    val playStoreAppUrl: String = DEFAULT_PLAY_STORE_URL,
    val minRequiredVersionCode: Int = 1,
    val latestVersionCode: Int = 1,
    val latestVersionName: String = "1.5",
    val isForceUpdateRequired: Boolean = false,
    val updateTitle: String = DEFAULT_UPDATE_TITLE,
    val updateMessage: String = DEFAULT_UPDATE_MESSAGE,
    val updateFeatures: List<String> = DEFAULT_UPDATE_FEATURES,
    val updatedAt: String = "",
    val updatedBy: String = ""
) {
    companion object {
        const val DEFAULT_PLAY_STORE_TITLE = "বাংলা অডিওবুক ও স্পোকেন কোর্স - Apps on Google Play"
        const val DEFAULT_PLAY_STORE_URL = "https://play.google.com/store/apps/details?id=com.gigabyte.bookstore"
        const val DEFAULT_UPDATE_TITLE = "নতুন আপডেট চলে এসেছে! 🚀"
        const val DEFAULT_UPDATE_MESSAGE = "আপনার অ্যাপের অভিজ্ঞতা আরও দ্রুত ও আকর্ষণীয় করতে গুরুত্বপূর্ণ ফিচার এবং পারফরম্যান্স অপটিমাইজেশন যুক্ত করা হয়েছে। চালিয়ে যেতে অনুগ্রহ করে আপডেট করে নিন।"
        val DEFAULT_UPDATE_FEATURES = listOf(
            "নতুন আকর্ষণীয় রঙিন ডিজাইন ও দ্রুততর অ্যাপ লোডিং",
            "ইন্টারঅ্যাক্টিভ স্পোকেন ও লেসন কমপ্লিশন ট্র্যাকিং",
            "অডিও প্লেয়ার পারফরম্যান্স ও মেমরি অপটিমাইজেশন",
            "নিরাপত্তা বৃদ্ধি ও নিয়মিত বাগ ফিক্স"
        )

        val DEFAULT_REFERRAL_MESSAGE_TEMPLATE = """
            আসসালামু আলাইকুম! 🌿

            বই পড়ার আনন্দ এবং নতুন ভাষা শেখার সহজ সুযোগ নিয়ে এলো—
            📖 বাংলা অডিওবুক ও স্পোকেন কোর্স অ্যাপ

            ✨ অ্যাপটির বিশেষ সুবিধাসমূহ:
            • জনপ্রিয় শত শত দেশি-বিদেশি বইয়ের স্পষ্ট বাংলা অডিওবুক ও সম্পূর্ণ পাঠ
            • ইংরেজি, আরবি, জাপানিজ, কোরিয়ান, জার্মানসহ বিভিন্ন ভাষার স্পোকেন কোর্স
            • নির্ভুল উচ্চারণ শেখার আধুনিক সুবিধা ও এআই ট্রান্সলেটর

            🎁 রেজিস্ট্রেশনের সময় আমার রেফার কোডটি ব্যবহার করতে পারেন:
            👉 রেফারেল কোড: {code}

            📲 গুগল প্লে স্টোর থেকে অ্যাপটি ডাউনলোড করার লিঙ্ক:
            {appTitle}
            {appLink}

            আজই যুক্ত হয়ে সহজে নিজের জ্ঞান ও ভাষাগত দক্ষতা বৃদ্ধি করুন। ধন্যবাদ! 🤝
        """.trimIndent()
    }

    /**
     * Resolves the referral invitation message, replacing placeholders with real values.
     * If referralMessageTemplate is blank in backend, falls back to the default polite message template.
     * Placeholders supported: {code}, {referralCode}, {appLink}, {playStoreUrl}, {appTitle},
     * {singleBonus}, {bundleBonus}, {singlePrice}, {bundlePrice}.
     */
    fun formatReferralMessage(referralCode: String): String {
        val template = if (referralMessageTemplate.isNotBlank()) referralMessageTemplate else DEFAULT_REFERRAL_MESSAGE_TEMPLATE
        val title = if (playStoreAppTitle.isNotBlank()) playStoreAppTitle else DEFAULT_PLAY_STORE_TITLE
        val url = if (playStoreAppUrl.isNotBlank()) playStoreAppUrl else DEFAULT_PLAY_STORE_URL

        return template
            .replace(" / নমস্কার", "")
            .replace("/ নমস্কার", "")
            .replace("/নমস্কার", "")
            .replace("নমস্কার", "")
            .replace("{code}", referralCode)
            .replace("{referralCode}", referralCode)
            .replace("{appLink}", url)
            .replace("{playStoreUrl}", url)
            .replace("{appTitle}", title)
            .replace("{singleBonus}", singleReferralBonus.toInt().toString())
            .replace("{bundleBonus}", bundleReferralBonus.toInt().toString())
            .replace("{singlePrice}", singleCoursePrice.toInt().toString())
            .replace("{bundlePrice}", megaBundlePrice.toInt().toString())
    }

    /**
     * Resolves the price for a specific package ID or falls back to singleCoursePrice / megaBundlePrice.
     */
    fun getPackagePrice(packageId: String): Double {
        return packagePrices[packageId] ?: when (packageId) {
            "mega_bundle" -> megaBundlePrice
            else -> singleCoursePrice
        }
    }

    /**
     * Calculates the referral bonus for a referrer when a referred user buys a package.
     * Bundle purchases (mega_bundle or amount >= megaBundlePrice) reward bundleReferralBonus (৳40),
     * while single course purchases reward singleReferralBonus (৳20).
     */
    fun getReferralBonus(packageId: String, amount: Double): Double {
        return if (packageId.equals("mega_bundle", ignoreCase = true) || amount >= megaBundlePrice) {
            bundleReferralBonus
        } else {
            singleReferralBonus
        }
    }
}
