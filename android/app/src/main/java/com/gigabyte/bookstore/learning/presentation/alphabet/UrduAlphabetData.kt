package com.gigabyte.bookstore.learning.presentation.alphabet

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object UrduAlphabetData {

    val CONFIG = LanguageAlphabetConfig(
        langCode = "urdu",
        speechLang = SpeechLang.UR,
        titleBn = "উর্দু বর্ণমালা ও উচ্চারণ চার্ট (حروف تہجی)",
        subtitleBn = "৩৯টি একক হরফ ও ১৪টি দো-চশমী যুক্তধ্বনি · ট্যাপ করলেই অডিও",
        accentColorHex = 0xFF1B5E20,
        categories = listOf(
            AlphabetCategory("all", "সব হরফ", "৫৩টি"),
            AlphabetCategory("mufradat", "একক হরফ (مفردات)", "৩৯টি"),
            AlphabetCategory("murakkabat", "যুক্ত মহাপ্রাণ (مرکبات)", "১৪টি")
        ),
        rows = listOf(
            AlphabetRow(
                id = "ur_row_1",
                titleBn = "আলিফ ও বা-বর্গ (ا · ب · پ · ت · ٹ · ث)",
                subtitleTarget = "Alif to Say",
                categoryId = "mufradat",
                letters = listOf(
                    AlphabetLetter("ur_alif", "ا", "الف", "Alif", "আলিফ", "mufradat", "الف", "انار", "anaar", "ডালিম / বেদানা", "সোজা লম্বা হরফ; শুরুতে 'আ' বা 'অ' স্বরধ্বনি।"),
                    AlphabetLetter("ur_bay", "ب", "بے", "Bay", "বে", "mufradat", "بے", "بلی", "billi", "বিড়াল", "নিচে ১টি নুকতা; স্পষ্ট বাংলা 'ব' ধ্বনি।"),
                    AlphabetLetter("ur_pay", "پ", "پے", "Pay", "পে", "mufradat", "پے", "پانی", "paani", "পানি", "নিচে ৩টি নুকতা; বাংলা 'প' ধ্বনি।"),
                    AlphabetLetter("ur_tey", "ت", "تے", "Tey", "তে", "mufradat", "تے", "تارا", "taara", "তারা / নক্ষত্র", "উপরে ২টি নুকতা; বাংলা দন্ত্য 'ত' ধ্বনি।"),
                    AlphabetLetter("ur_ttey", "ٹ", "ٹے", "Ttey", "টে", "mufradat", "ٹے", "ٹماٹر", "tamaatar", "টমেটো", "মাথায় ছোট তোয়া (ط); বাংলা মূর্ধন্য 'ট' ধ্বনি।"),
                    AlphabetLetter("ur_say", "ث", "ثے", "Say", "সে", "mufradat", "ثے", "ثمر", "samar", "ফল", "উপরে ৩টি নুকতা; নরম 'স' ধ্বনি।")
                )
            ),
            AlphabetRow(
                id = "ur_row_2",
                titleBn = "জীম-বর্গ (ج · چ · ح · خ)",
                subtitleTarget = "Jeem to Khay",
                categoryId = "mufradat",
                letters = listOf(
                    AlphabetLetter("ur_jeem", "ج", "جیم", "Jeem", "জীম", "mufradat", "جیم", "جوتا", "joota", "জুতা", "পেটের মাঝে ১টি নুকতা; বাংলা 'জ' ধ্বনি।"),
                    AlphabetLetter("ur_chay", "چ", "چے", "Chay", "চে", "mufradat", "چے", "چائے", "chaaye", "চা", "পেটের মাঝে ৩টি নুকতা; বাংলা 'চ' ধ্বনি।"),
                    AlphabetLetter("ur_hay", "ح", "بڑی حے", "Bari Hay", "বড় হে", "mufradat", "حے", "حلوہ", "halwa", "হালুয়া", "নুকতাহীন; গলার মাঝখান থেকে নির্গত গভীর 'হ'।"),
                    AlphabetLetter("ur_khay", "خ", "خے", "Khay", "খে", "mufradat", "خے", "خط", "khat", "চিঠি", "উপরে ১টি নুকতা; কণ্ঠনালী থেকে ঘর্ষণসহ 'খ্' ধ্বনি।")
                )
            ),
            AlphabetRow(
                id = "ur_row_3",
                titleBn = "দাল ও রা-বর্গ (د · ڈ · ذ · ر · ڑ · ز · ژ)",
                subtitleTarget = "Daal to Zhay",
                categoryId = "mufradat",
                letters = listOf(
                    AlphabetLetter("ur_daal", "د", "دال", "Daal", "দাল", "mufradat", "دال", "دروازہ", "darwaaza", "দরজা", "বাংলা দন্ত্য 'দ' ধ্বনি।"),
                    AlphabetLetter("ur_ddaal", "ڈ", "ڈال", "Ddaal", "ডাল", "mufradat", "ڈال", "ڈاکٹر", "daaktar", "ডাক্তার", "মাথায় ছোট তোয়া; বাংলা মূর্ধন্য 'ড' ধ্বনি।"),
                    AlphabetLetter("ur_zaal", "ذ", "ذال", "Zaal", "যাল", "mufradat", "ذال", "ذائقہ", "zaa'iqa", "স্বাদ", "উপরে ১টি নুকতা; নরম 'য/জ' ধ্বনি।"),
                    AlphabetLetter("ur_ray", "ر", "رے", "Ray", "রে", "mufradat", "رے", "رات", "raat", "রাত", "সাধারণ বাংলা 'র' ধ্বনি।"),
                    AlphabetLetter("ur_rray", "ڑ", "ڑے", "Rray", "ড়ে", "mufradat", "ڑے", "پہاڑ", "pahaar", "পাহাড়", "মাথায় তোয়া; বাংলা 'ড়' এর মতো জিহ্বা উল্টিয়ে উচ্চারণ।"),
                    AlphabetLetter("ur_zay", "ز", "زے", "Zay", "যে", "mufradat", "زے", "زمین", "zameen", "জমিন / মাটি", "উপরে ১টি নুকতা; মৌমাছির গুঞ্জনের মতো 'য্'।"),
                    AlphabetLetter("ur_zhay", "ژ", "ژے", "Zhay", "ঝে", "mufradat", "ژے", "ٹیلی ویژن", "television", "টেলিভিশন", "উপরে ৩টি নুকতা; ইংরেজি 'Vision' এর s এর মতো 'ঝ'।")
                )
            ),
            AlphabetRow(
                id = "ur_row_4",
                titleBn = "সীন, সোয়াদ ও তোয়া-বর্গ (س · ش · ص · ض · ط · ظ)",
                subtitleTarget = "Seen to Zoye",
                categoryId = "mufradat",
                letters = listOf(
                    AlphabetLetter("ur_seen", "س", "سین", "Seen", "সীন", "mufradat", "سین", "سیب", "saib", "আপেল", "দাঁতের ফাঁক দিয়ে পরিষ্কার 'স' শিসধ্বনি।"),
                    AlphabetLetter("ur_sheen", "ش", "شین", "Sheen", "শীন", "mufradat", "شین", "شیر", "shair", "সিংহ", "উপরে ৩টি নুকতা; বাংলা তালব্য 'শ'।"),
                    AlphabetLetter("ur_swad", "ص", "صاد", "Swad", "সোয়াদ", "mufradat", "صاد", "صبح", "subah", "সকাল", "মুখ সামান্য গোলাকার ও ভারী করে মোটা 'স'।"),
                    AlphabetLetter("ur_zwad", "ض", "ضاد", "Zwad", "যোয়াদ", "mufradat", "ضاد", "ضروری", "zaroori", "জরুরি", "ভারী গলার 'য/জ' ধ্বনি।"),
                    AlphabetLetter("ur_toye", "ط", "طوئے", "Toye", "তোয়া", "mufradat", "طوئے", "طوطا", "tota", "তোতাপাখি", "ভারী দন্ত্য 'ত'।"),
                    AlphabetLetter("ur_zoye", "ظ", "ظوئے", "Zoye", "যোয়া", "mufradat", "ظوئے", "ظلم", "zulm", "অত্যাচার", "ভারী 'য'।")
                )
            ),
            AlphabetRow(
                id = "ur_row_5",
                titleBn = "আইন, কাফ ও লাম-বর্গ (ع · غ · ف · ق · ک · گ · ل)",
                subtitleTarget = "Ain to Laam",
                categoryId = "mufradat",
                letters = listOf(
                    AlphabetLetter("ur_ain", "ع", "عین", "Ain", "আইন", "mufradat", "عین", "عینک", "ainak", "চশমা", "গলার গভীরে চাপ দিয়ে উচ্চারিত ধ্বনি।"),
                    AlphabetLetter("ur_ghain", "غ", "غین", "Ghain", "গাইন", "mufradat", "غین", "غبارہ", "ghubaara", "বেলুন", "কণ্ঠনালীর ঘর্ষণধ্বনি 'গ্গ্'।"),
                    AlphabetLetter("ur_fay", "ف", "فے", "Fay", "ফে", "mufradat", "فے", "پھول", "phool", "ফুল", "দাঁত ও ঠোঁট স্পর্শ করে 'ফ'।"),
                    AlphabetLetter("ur_qaaf", "ق", "قاف", "Qaaf", "ক্বাফ", "mufradat", "قاف", "قلم", "qalam", "কলম", "জিহ্বার গোড়া ও কোমল তালু থেকে কড়া 'ক্ব'।"),
                    AlphabetLetter("ur_kaaf", "ک", "کاف", "Kaaf", "কাফ", "mufradat", "کاف", "کتاب", "kitaab", "বই", "বাংলা স্বাভাবিক 'ক' ধ্বনি।"),
                    AlphabetLetter("ur_gaaf", "گ", "گاف", "Gaaf", "গাফ", "mufradat", "گاف", "گائے", "gaaye", "গরু", "বাংলা 'গ' ধ্বনি।"),
                    AlphabetLetter("ur_laam", "ل", "لام", "Laam", "লাম", "mufradat", "لام", "لڑکا", "larka", "ছেলে", "বাংলা 'ল' ধ্বনি।")
                )
            ),
            AlphabetRow(
                id = "ur_row_6",
                titleBn = "মীম, নূন ও শেষ হরফসমূহ (م · ن · ں · و · ہ · ھ · ء · ی · ے)",
                subtitleTarget = "Meem to Bari Yey",
                categoryId = "mufradat",
                letters = listOf(
                    AlphabetLetter("ur_meem", "م", "میم", "Meem", "মীম", "mufradat", "میم", "مچھلی", "machhli", "মাছ"),
                    AlphabetLetter("ur_noon", "ن", "نون", "Noon", "নূন", "mufradat", "نون", "ناک", "naak", "নাক"),
                    AlphabetLetter("ur_noon_ghunna", "ں", "نون غنہ", "Noon Ghunna", "নূনে গুন্নাহ", "mufradat", "نون غنہ", "ماں", "maan", "মা", "নুকতাহীন নূন; শব্দের শেষে নাসিক্য অনুনাসিক স্বর তৈরি করে।"),
                    AlphabetLetter("ur_wow", "و", "واؤ", "Wow", "ওয়াও", "mufradat", "واؤ", "وقت", "waqt", "সময়", "স্বরবর্ণ হিসেবে 'ও/উ' এবং ব্যঞ্জনবর্ণে 'ওয়া'।"),
                    AlphabetLetter("ur_chhoti_hay", "ہ", "چھوٹی ہ", "Chhoti Hay", "ছোট হে", "mufradat", "چھوٹی ہے", "ہوا", "hawa", "বাতাস"),
                    AlphabetLetter("ur_dochashmi_hay", "ھ", "دو چشمی ھ", "Do-chashmi Hay", "দো-চশমী হে", "mufradat", "دو چشمی ہے", "ہاتھ", "haath", "হাত", "মহাপ্রাণ যুক্তবর্ণ তৈরিতে ব্যবহৃত হয়।"),
                    AlphabetLetter("ur_hamza", "ء", "ہمزہ", "Hamza", "হামযা", "mufradat", "ہمزہ", "چائے", "chaaye", "চা", "দুটি স্বরধ্বনির মাঝে বিরতি বা ঝটকা দিতে বসে।"),
                    AlphabetLetter("ur_chhoti_yey", "ی", "چھوٹی یے", "Chhoti Yey", "ছোট ইয়ে", "mufradat", "چھوٹی یے", "یہ", "yeh", "এই / এটা", "দীর্ঘ 'ঈ' বা 'ই' ধ্বনি।"),
                    AlphabetLetter("ur_bari_yey", "ے", "بڑی یے", "Bari Yey", "বড় ইয়ে", "mufradat", "بڑی یے", "لڑکے", "larkay", "ছেলেরা", "শব্দের শেষে বসে 'এ' কারের রূপ দেয়।")
                )
            ),
            AlphabetRow(
                id = "ur_murakkabat_1",
                titleBn = "দো-চশমী হে যুক্ত মহাপ্রাণ বর্ণ (১: بھ · پھ · تھ · ٹھ · جھ · چھ · دھ)",
                subtitleTarget = "Aspirated Compounds Part 1",
                categoryId = "murakkabat",
                letters = listOf(
                    AlphabetLetter("ur_bha", "بھ", "ب + ھ", "Bha", "ভ", "murakkabat", "بھ", "بھائی", "bhaai", "ভাই", "বাংলা মহাপ্রাণ 'ভ' ধ্বনি।"),
                    AlphabetLetter("ur_pha", "پھ", "پ + ھ", "Pha", "ফ", "murakkabat", "پھ", "پھول", "phool", "ফুল", "বাংলা মহাপ্রাণ 'ফ' ধ্বনি।"),
                    AlphabetLetter("ur_tha", "تھ", "ت + ھ", "Tha", "থ", "murakkabat", "تھ", "تھالی", "thaali", "থালা", "বাংলা মহাপ্রাণ 'থ' ধ্বনি।"),
                    AlphabetLetter("ur_ttha", "ٹھ", "ٹ + ھ", "Ttha", "ঠ", "murakkabat", "ٹھ", "ٹھنڈا", "thanda", "ঠাণ্ডা", "বাংলা মূর্ধন্য মহাপ্রাণ 'ঠ' ধ্বনি।"),
                    AlphabetLetter("ur_jha", "جھ", "ج + ھ", "Jha", "ঝ", "murakkabat", "جھ", "جھنڈا", "jhanda", "পতাকা", "বাংলা মহাপ্রাণ 'ঝ' ধ্বনি।"),
                    AlphabetLetter("ur_chha", "چھ", "چ + ھ", "Chha", "ছ", "murakkabat", "چھ", "چھتری", "chhatri", "ছাতা", "বাংলা মহাপ্রাণ 'ছ' ধ্বনি।"),
                    AlphabetLetter("ur_dha", "دھ", "د + ھ", "Dha", "ধ", "murakkabat", "دھ", "دھوبی", "dhobi", "ধোপা", "বাংলা মহাপ্রাণ 'ধ' ধ্বনি।")
                )
            ),
            AlphabetRow(
                id = "ur_murakkabat_2",
                titleBn = "দো-চশমী হে যুক্ত মহাপ্রাণ বর্ণ (২: ڈھ · رھ · ڑھ · کھ · گھ · لھ · مھ)",
                subtitleTarget = "Aspirated Compounds Part 2",
                categoryId = "murakkabat",
                letters = listOf(
                    AlphabetLetter("ur_ddha", "ڈھ", "ڈ + ھ", "Ddha", "ঢ", "murakkabat", "ڈھ", "ڈھول", "dhool", "ঢোল", "বাংলা মূর্ধন্য মহাপ্রাণ 'ঢ' ধ্বনি।"),
                    AlphabetLetter("ur_rha", "رھ", "ر + ھ", "Rha", "র্হ", "murakkabat", "رھ", "گھبراہٹ", "rha", "কম্পনসহ র-এর মহাপ্রাণ।"),
                    AlphabetLetter("ur_rrha", "ڑھ", "ڑ + ھ", "Rrha", "ঢ়", "murakkabat", "ڑھ", "پڑھنا", "parhna", "পড়া", "বাংলা 'ঢ়' ধ্বনি।"),
                    AlphabetLetter("ur_kha", "کھ", "ک + ھ", "Kha", "খ", "murakkabat", "کھ", "کھانا", "khaana", "খাবার / খাওয়া", "বাংলা মহাপ্রাণ 'খ' ধ্বনি।"),
                    AlphabetLetter("ur_gha", "گھ", "گ + ھ", "Gha", "ঘ", "murakkabat", "گھ", "گھر", "ghar", "বাড়ি / ঘর", "বাংলা মহাপ্রাণ 'ঘ' ধ্বনি।"),
                    AlphabetLetter("ur_lha", "لھ", "ل + ھ", "Lha", "ল্হ", "murakkabat", "لھ", "دولھا", "doolha", "বর (দোলহা)"),
                    AlphabetLetter("ur_mha", "مھ", "م + ھ", "Mha", "ম্হ", "murakkabat", "مھ", "تمہیں", "tumhein", "তোমাকে")
                )
            )
        )
    )
}
