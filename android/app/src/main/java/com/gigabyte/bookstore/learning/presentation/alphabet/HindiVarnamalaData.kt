package com.gigabyte.bookstore.learning.presentation.alphabet

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object HindiVarnamalaData {

    val CONFIG = LanguageAlphabetConfig(
        langCode = "hindi",
        speechLang = SpeechLang.HI,
        titleBn = "হিন্দি দেবনাগরী বর্ণমালা চার্ট (वर्णमाला)",
        subtitleBn = "১৩টি স্বরবর্ণ, ৩৩টি ব্যঞ্জনবর্ণ ও বিশেষ নুক্তা ধ্বনি · ট্যাপ করলেই অডিও",
        accentColorHex = 0xFFE65100,
        categories = listOf(
            AlphabetCategory("all", "সব বর্ণ", "৫৭টি"),
            AlphabetCategory("swar", "স্বরবর্ণ (स्वर)", "১৩টি"),
            AlphabetCategory("vyanjan", "ব্যঞ্জনবর্ণ (व्यंजन)", "৩৩টি"),
            AlphabetCategory("sanyukt", "যুক্ত ও নুক্তা", "১১টি")
        ),
        rows = listOf(
            AlphabetRow(
                id = "hi_swar_1",
                titleBn = "স্বরবর্ণ (সারি ১: অ থেকে উ)",
                subtitleTarget = "Swar (अ · आ · इ · ई · उ · ऊ · ऋ)",
                categoryId = "swar",
                letters = listOf(
                    AlphabetLetter("hi_a", "अ", "स्वर", "a", "অ", "swar", "अनार", "अनार", "anaar", "ডালিম / বেদানা", "হ্রস্ব স্বরধ্বনি 'অ'।"),
                    AlphabetLetter("hi_aa", "आ", "स्वर", "aa", "আ", "swar", "आम", "आम", "aam", "আম", "দীর্ঘ ও স্পষ্ট 'আ' ধ্বনি।"),
                    AlphabetLetter("hi_i", "इ", "स्वर", "i", "ই", "swar", "इमली", "इमली", "imli", "তেঁতুল", "হ্রস্ব 'ই'।"),
                    AlphabetLetter("hi_ii", "ई", "स्वर", "ee", "ঈ", "swar", "ईख", "ईख", "eekh", "আখ / ইক্ষু", "দীর্ঘ ও টানা 'ঈ'।"),
                    AlphabetLetter("hi_u", "उ", "स्वर", "u", "উ", "swar", "उल्लू", "उल्लू", "ullu", "পেঁচা", "হ্রস্ব 'উ'।"),
                    AlphabetLetter("hi_uu", "ऊ", "स्वर", "oo", "ঊ", "swar", "ऊन", "ऊन", "oon", "পশম / উল", "দীর্ঘ 'ঊ'।"),
                    AlphabetLetter("hi_ri", "ऋ", "स्वर", "ri", "ঋ", "swar", "ऋषि", "ऋषि", "rishi", "ঋষি / সাধক", "হিন্দিতে 'রি' উচ্চারিত হয়।")
                )
            ),
            AlphabetRow(
                id = "hi_swar_2",
                titleBn = "স্বরবর্ণ (সারি ২: এ থেকে অহ)",
                subtitleTarget = "Swar (ए · ऐ · ओ · औ · अं · अः)",
                categoryId = "swar",
                letters = listOf(
                    AlphabetLetter("hi_e", "ए", "स्वर", "e", "এ", "swar", "एक", "एक", "ek", "এক (১)", "বাংলা 'এ' ধ্বনি।"),
                    AlphabetLetter("hi_ai", "ऐ", "स्वर", "ai", "ঐ", "swar", "ऐनक", "ऐनक", "ainak", "চশমা", "বাংলা 'ঐ' বা 'অ্যায়' ধ্বনি।"),
                    AlphabetLetter("hi_o", "ओ", "स्वर", "o", "ও", "swar", "ओखली", "ओखली", "okhli", "হামানদিস্তা", "মুখ গোল করে 'ও'।"),
                    AlphabetLetter("hi_au", "औ", "स्वर", "au", "ঔ", "swar", "औरत", "औरत", "aurat", "নারী / মহিলা", "বাংলা 'ঔ' বা 'অও' ধ্বনি।"),
                    AlphabetLetter("hi_am", "अं", "अनुस्वार", "am", "অং / অনুস্বার", "swar", "अंगूर", "अंगूर", "angoor", "আঙুর", "নাসিক্য অনুস্বার ধ্বনি।"),
                    AlphabetLetter("hi_ah", "अः", "विसर्ग", "ah", "অহ্ / বিসর্গ", "swar", "अतः", "अतः", "atah", "অতএব", "হালকা হ-এর ঝোঁকযুক্ত বিসর্গ ধ্বনি।")
                )
            ),
            AlphabetRow(
                id = "hi_ka_varga",
                titleBn = "ক-বর্গ (क · ख · ग · घ · ङ)",
                subtitleTarget = "Ka-varga (Velar)",
                categoryId = "vyanjan",
                letters = listOf(
                    AlphabetLetter("hi_ka", "क", "ক", "ka", "ক", "vyanjan", "कमल", "कमल", "kamal", "পদ্মফুল"),
                    AlphabetLetter("hi_kha", "ख", "খ", "kha", "খ", "vyanjan", "खरगोश", "खरगोश", "khargosh", "খরগোশ", "মহাপ্রাণ 'খ'।"),
                    AlphabetLetter("hi_ga", "ग", "গ", "ga", "গ", "vyanjan", "गमला", "गमला", "gamla", "টব"),
                    AlphabetLetter("hi_gha", "घ", "ঘ", "gha", "ঘ", "vyanjan", "घर", "घर", "ghar", "বাড়ি / ঘর", "মহাপ্রাণ 'ঘ'।"),
                    AlphabetLetter("hi_nga", "ङ", "ঙ", "nga", "ঙ", "vyanjan", "गंगा", "गंगा", "ganga", "গঙ্গা", "নাসিক্য 'ঙ' ধ্বনি।")
                )
            ),
            AlphabetRow(
                id = "hi_cha_varga",
                titleBn = "চ-বর্গ (च · छ · ज · झ · ञ)",
                subtitleTarget = "Cha-varga (Palatal)",
                categoryId = "vyanjan",
                letters = listOf(
                    AlphabetLetter("hi_cha", "च", "চ", "cha", "চ", "vyanjan", "चम्मच", "चम्मच", "chammach", "চামচ"),
                    AlphabetLetter("hi_chha", "छ", "ছ", "chha", "ছ", "vyanjan", "छतरी", "छतरी", "chhatri", "ছাতা", "মহাপ্রাণ 'ছ'।"),
                    AlphabetLetter("hi_ja", "ज", "জ", "ja", "জ", "vyanjan", "जहाज", "जहाज", "jahaaz", "জাহাজ"),
                    AlphabetLetter("hi_jha", "झ", "ঝ", "jha", "ঝ", "vyanjan", "झंडा", "झंडा", "jhanda", "পতাকা", "মহাপ্রাণ 'ঝ'।"),
                    AlphabetLetter("hi_nya", "ञ", "ঞ", "nya", "ঞ", "vyanjan", "पंच", "पंच", "panch", "পাঁচ", "নাসিক্য 'ঞ' ধ্বনি।")
                )
            ),
            AlphabetRow(
                id = "hi_ta_retro",
                titleBn = "ট-বর্গ (মূর্ধন্য: ट · ठ · ड · ढ · ण)",
                subtitleTarget = "Tta-varga (Retroflex)",
                categoryId = "vyanjan",
                letters = listOf(
                    AlphabetLetter("hi_tta", "ट", "ট", "ta", "ট", "vyanjan", "टमाटर", "टमाटर", "tamaatar", "টমেটো", "জিহ্বা তালুতে উল্টিয়ে মূর্ধন্য 'ট'।"),
                    AlphabetLetter("hi_ttha", "ठ", "ঠ", "tha", "ঠ", "vyanjan", "ठेला", "ठेला", "thelaa", "ঠেলাগাড়ি", "মহাপ্রাণ 'ঠ'।"),
                    AlphabetLetter("hi_dda", "ड", "ড", "da", "ড", "vyanjan", "डमरू", "डमरू", "damru", "ডমরু"),
                    AlphabetLetter("hi_ddha", "ढ", "ঢ", "dha", "ঢ", "vyanjan", "ढक्कन", "ढक्कन", "dhakkan", "ঢাকনা", "মহাপ্রাণ 'ঢ'।"),
                    AlphabetLetter("hi_nna", "ण", "ণ", "na", "ণ", "vyanjan", "बाण", "बाण", "baan", "তীর / বাণ", "মূর্ধন্য 'ণ'।")
                )
            ),
            AlphabetRow(
                id = "hi_ta_dental",
                titleBn = "ত-বর্গ (দন্ত্য: त · थ · द · ध · न)",
                subtitleTarget = "Ta-varga (Dental)",
                categoryId = "vyanjan",
                letters = listOf(
                    AlphabetLetter("hi_ta", "त", "ত", "ta", "ত", "vyanjan", "तरबूज", "तरबूज", "tarbooz", "তরমুজ", "দাঁতের পেছনে জিহ্বা রেখে দন্ত্য 'ত'।"),
                    AlphabetLetter("hi_tha", "थ", "থ", "tha", "থ", "vyanjan", "थाली", "थाली", "thaali", "থালা", "মহাপ্রাণ 'থ'।"),
                    AlphabetLetter("hi_da", "द", "দ", "da", "দ", "vyanjan", "दवात", "दवात", "dawaat", "দোয়াত"),
                    AlphabetLetter("hi_dha", "ध", "ধ", "dha", "ধ", "vyanjan", "धनुष", "धनुष", "dhanush", "ধনুক", "মহাপ্রাণ 'ধ'।"),
                    AlphabetLetter("hi_na", "न", "ন", "na", "ন", "vyanjan", "नल", "नल", "nal", "পানির কল")
                )
            ),
            AlphabetRow(
                id = "hi_pa_varga",
                titleBn = "প-বর্গ (प · फ · ब · भ · म)",
                subtitleTarget = "Pa-varga (Labial)",
                categoryId = "vyanjan",
                letters = listOf(
                    AlphabetLetter("hi_pa", "प", "প", "pa", "প", "vyanjan", "पतंग", "पतंग", "patang", "ঘুড়ি"),
                    AlphabetLetter("hi_pha", "फ", "ফ", "pha", "ফ", "vyanjan", "फल", "फल", "phal", "ফল", "উভয় ঠোঁট থেকে মহাপ্রাণ 'ফ'।"),
                    AlphabetLetter("hi_ba", "ब", "ব", "ba", "ব", "vyanjan", "बतख", "बतख", "batakh", "হাঁস"),
                    AlphabetLetter("hi_bha", "भ", "ভ", "bha", "ভ", "vyanjan", "भालू", "भालू", "bhaalu", "ভালুক", "মহাপ্রাণ 'ভ'।"),
                    AlphabetLetter("hi_ma", "म", "ম", "ma", "ম", "vyanjan", "मछली", "मछली", "machhli", "মাছ")
                )
            ),
            AlphabetRow(
                id = "hi_antastha_ushma",
                titleBn = "অন্তঃস্থ ও উষ্ম বর্ণ (य · र · ल · व · श · ष · स · ह)",
                subtitleTarget = "Antastha & Ushma",
                categoryId = "vyanjan",
                letters = listOf(
                    AlphabetLetter("hi_ya", "य", "য", "ya", "য / য়", "vyanjan", "यज्ञ", "यज्ञ", "yagya", "যজ্ঞ"),
                    AlphabetLetter("hi_ra", "र", "র", "ra", "র", "vyanjan", "रथ", "रथ", "rath", "রথ"),
                    AlphabetLetter("hi_la", "ल", "ল", "la", "ল", "vyanjan", "लड्डू", "लड्डू", "laddu", "লাড্ডু"),
                    AlphabetLetter("hi_va", "व", "ব/ওয়", "va", "ভ / ওয়", "vyanjan", "वकील", "वकील", "wakeel", "উকিল / আইনজীবী", "ঠোঁট সামান্য গোল করে 'ওয়' বা নরম 'ভ'।"),
                    AlphabetLetter("hi_sha", "श", "শ", "sha", "শ", "vyanjan", "शलजम", "शलजम", "shaljam", "শালগম", "তালব্য 'শ'।"),
                    AlphabetLetter("hi_ssa", "ष", "ষ", "sha", "ষ", "vyanjan", "षट्कोण", "षट्कोण", "shatkon", "ষড়ভুজ", "মূর্ধন্য 'ষ'।"),
                    AlphabetLetter("hi_sa", "स", "স", "sa", "স", "vyanjan", "सपेरा", "सपेरा", "sapera", "সাপুড়ে", "দন্ত্য 'স'।"),
                    AlphabetLetter("hi_ha", "ह", "হ", "ha", "হ", "vyanjan", "हाथी", "हाथी", "haathi", "হাতি")
                )
            ),
            AlphabetRow(
                id = "hi_sanyukt_nukta",
                titleBn = "সংযুক্ত বর্ণ ও নুক্তা ধ্বনি (क्ष · त्र · ज्ञ · श्र · क़ · ख़ · ग़ · ज़ · ड़ · ढ़ · फ़)",
                subtitleTarget = "Sanyukt & Nukta",
                categoryId = "sanyukt",
                letters = listOf(
                    AlphabetLetter("hi_ksha", "क्ष", "ক+ষ", "ksha", "ক্ষ", "sanyukt", "क्षत्रिय", "क्षत्रिय", "kshatriya", "ক্ষত্রিয়"),
                    AlphabetLetter("hi_tra", "त्र", "ত+র", "tra", "ত্র", "sanyukt", "त्रिशूल", "त्रिशूल", "trishool", "ত্রিশূল"),
                    AlphabetLetter("hi_gya", "ज्ञ", "জ+ঞ", "gya", "জ্ঞ", "sanyukt", "ज्ञानी", "ज्ञानी", "gyaani", "জ্ঞানী", "হিন্দিতে 'গিয়াঁ' উচ্চারিত হয়।"),
                    AlphabetLetter("hi_shra", "श्र", "শ+র", "shra", "শ্র", "sanyukt", "श्रमिक", "श्रमिक", "shramik", "শ্রমিক"),
                    AlphabetLetter("hi_qa", "क़", "ক্বাফ", "qa", "ক্ব", "sanyukt", "क़लम", "क़लम", "qalam", "কলম", "কণ্ঠনালীর গভীরে কড়া ক্বাফ।"),
                    AlphabetLetter("hi_khha", "ख़", "খ", "kha", "খ্", "sanyukt", "ख़बर", "ख़बर", "khabar", "সংবাদ / খবর", "ঘর্ষণধ্বনি 'খ্'।"),
                    AlphabetLetter("hi_ghha", "ग़", "গাইন", "gha", "গ্গ্", "sanyukt", "ग़रीब", "ग़रीब", "ghareeb", "দরিদ্র / গরিব"),
                    AlphabetLetter("hi_za", "ज़", "যে", "za", "য্", "sanyukt", "ज़िंदगी", "ज़िंदगी", "zindagi", "জীবন", "মৌমাছির গুঞ্জনের মতো 'য্'।"),
                    AlphabetLetter("hi_rra", "ड़", "ড়", "dda", "ড়", "sanyukt", "पेड़", "पेड़", "ped", "গাছ", "বাংলা 'ড়' ধ্বনি।"),
                    AlphabetLetter("hi_rrha", "ढ़", "ঢ়", "ddha", "ঢ়", "sanyukt", "पढ़ाई", "पढ़ाई", "padhai", "পড়াশোনা", "বাংলা 'ঢ়' ধ্বনি।"),
                    AlphabetLetter("hi_fa", "फ़", "ফে", "fa", "ফ্", "sanyukt", "फ़िल्म", "फ़िल्म", "film", "সিনেমা / ফিল্ম", "দাঁত ও ঠোঁট স্পর্শ করে ইংরেজি 'f'।")
                )
            )
        )
    )
}

