package com.gigabyte.bookstore.learning.presentation.alphabet

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object ArabicAlphabetData {

    val CONFIG = LanguageAlphabetConfig(
        langCode = "arabic",
        speechLang = SpeechLang.AR,
        titleBn = "আরবি বর্ণমালা, মাখরাজ ও হরকত চার্ট",
        subtitleBn = "২৮টি হরফ, কণ্ঠনালীয়-পুরু ধ্বনি ও হরকত · ট্যাপ করলেই আরবি অডিও",
        accentColorHex = 0xFF00695C,
        categories = listOf(
            AlphabetCategory("all", "সবগুলো", "৩৮টি"),
            AlphabetCategory("throat", "কণ্ঠনালীয় (গলা)", "৬টি"),
            AlphabetCategory("emphatic", "পুরু ধ্বনি (তাফখীম)", "৪টি"),
            AlphabetCategory("standard", "সাধারণ বর্ণ", "২০টি"),
            AlphabetCategory("harakat", "হরকত ও চিহ্ন", "৮টি")
        ),
        rows = listOf(
            AlphabetRow(
                id = "ar_throat",
                titleBn = "কণ্ঠনালীয় ধ্বনি (বাংলার চেয়ে ভিন্ন — গলা থেকে উচ্চারণ)",
                subtitleTarget = "أ · هـ · ع · ح · غ · خ",
                categoryId = "throat",
                letters = listOf(
                    AlphabetLetter("ar_alif", "أ / ا", "Alif / Hamza", "أَ", "আ / এ", "throat", "أ", "أَنَا", "anā", "আমি", "হামযাসহ আলিফ পরিষ্কার 'আ/ই/উ' স্বর দেয়; খালি আলিফ টান দেয়।"),
                    AlphabetLetter("ar_ha_small", "هـ", "Ha (হালকা)", "هَ", "হা (বুক থেকে)", "throat", "هـ", "هُوَ", "huwa", "সে (পুরুষ)", "বাংলার সাধারণ 'হ'-এর মতো, একদম গলার নিচ থেকে নরমভাবে।"),
                    AlphabetLetter("ar_ayn", "ع", "'Ayn (আইন)", "عَ", "আ' (গলা চেপে)", "throat", "ع", "عَرَبِيّ", "'arabī", "আরবি", "গলার মাঝখান হালকা চেপে গভীর 'আ/ই/উ' বলুন — ইংরেজি বা বাংলায় নেই।"),
                    AlphabetLetter("ar_ha_big", "ح", "Ha (বড় হা)", "حَ", "হা' (তপ্ত শ্বাস)", "throat", "ح", "حَلَال", "ḥalāl", "হালাল", "কাঁচ পরিষ্কার করার মতো গলার মাঝখান থেকে ঘষে বাতাস বের করে 'হা' বলুন।"),
                    AlphabetLetter("ar_ghayn", "غ", "Ghayn (গাইন)", "غَ", "গ্ব/গ়া (গড়গড়ে)", "throat", "غ", "غُرْفَة", "ghurfa", "রুম / কক্ষ", "গার্গল করার জায়গা থেকে নরম 'গ়' ধ্বনি।"),
                    AlphabetLetter("ar_kha", "خ", "Kha (খ)", "خَ", "খ্ব (ঘর্ষণ)", "throat", "خ", "خَيْر", "khayr", "ভালো / কল্যাণ", "গলার উপরিভাগ থেকে বাতাসের ঘর্ষণে 'খ' উচ্চারণ।")
                )
            ),
            AlphabetRow(
                id = "ar_emphatic",
                titleBn = "পুরু ও ভারী ধ্বনি (জিহ্বার পেছন দিক তুলে মোটা সুর)",
                subtitleTarget = "ص · ض · ط · ظ",
                categoryId = "emphatic",
                letters = listOf(
                    AlphabetLetter("ar_sad", "ص", "Sad (সোয়াদ)", "صَ", "স্ব (মোটা স)", "emphatic", "ص", "صَبَاح", "ṣabāḥ", "সকাল", "সাধারণ س (সিন)-এর চেয়ে মুখ ভরে মোটা ও ভারী করে 'স'।"),
                    AlphabetLetter("ar_dad", "ض", "Dad (দোয়াদ)", "ضَ", "দ্ব (মোটা দ)", "emphatic", "ض", "ضَيْف", "ḍayf", "অতিথি", "জিহ্বার পাশ উপরের দাঁতে লাগিয়ে ভারী 'দ' — আরবির অনন্য অক্ষর।"),
                    AlphabetLetter("ar_ta_heavy", "ط", "Ta (তোয়া)", "طَ", "ত্ব (মোটা ত)", "emphatic", "ط", "طَعَام", "ṭa'ām", "খাবার", "সাধারণ ت (তা)-এর চেয়ে ভারী ও মুখ ভরে 'ত'।"),
                    AlphabetLetter("ar_za_heavy", "ظ", "Za (যোয়া)", "ظَ", "জ্ব/য্ব (মোটা)", "emphatic", "ظ", "ظُهْر", "ẓuhr", "দুপুর / যোহর", "জিহ্বার ডগা দাঁতের মাঝে রেখে ভারী 'য'।")
                )
            ),
            AlphabetRow(
                id = "ar_std_1",
                titleBn = "সাধারণ বর্ণ সারি ১: ঠোঁট ও সামনের দাঁত",
                subtitleTarget = "ب · ت · ث · ج · د · ذ · ر · ز",
                categoryId = "standard",
                letters = listOf(
                    AlphabetLetter("ar_ba", "ب", "Ba", "بَ", "বা", "standard", "ب", "بَيْت", "bayt", "বাড়ি"),
                    AlphabetLetter("ar_ta", "ت", "Ta", "تَ", "তা", "standard", "ت", "تَمْر", "tamr", "খেজুর"),
                    AlphabetLetter("ar_tha", "ث", "Tha", "ثَ", "সা (নরম)", "standard", "ث", "ثَلَاثَة", "thalātha", "তিন", "জিহ্বার ডগা সামনের দাঁতের মাঝে ছুঁয়ে নরম 'থ/স' (ইংরেজি think)।"),
                    AlphabetLetter("ar_jim", "ج", "Jim", "جَ", "জা", "standard", "ج", "جَدِيد", "jadīd", "নতুন"),
                    AlphabetLetter("ar_dal", "د", "Dal", "دَ", "দা", "standard", "د", "دَفْتَر", "daftar", "খাতা"),
                    AlphabetLetter("ar_dhal", "ذ", "Dhal", "ذَ", "যা (নরম)", "standard", "ذ", "ذَهَب", "dhahab", "সোনা", "জিহ্বার ডগা দাঁতের মাঝে রেখে নরম 'য/দ' (ইংরেজি this)।"),
                    AlphabetLetter("ar_ra", "ر", "Ra", "رَ", "রা", "standard", "ر", "رِيَال", "riyāl", "রিয়াল"),
                    AlphabetLetter("ar_zay", "ز", "Zay", "زَ", "যা", "standard", "ز", "زَيْت", "zayt", "তেল")
                )
            ),
            AlphabetRow(
                id = "ar_std_2",
                titleBn = "সাধারণ বর্ণ সারি ২: শিস, তালু ও বিশেষ বর্ণ",
                subtitleTarget = "س · ش · ف · ق · ك · ل · م · ن · و · ي · ة · ء",
                categoryId = "standard",
                letters = listOf(
                    AlphabetLetter("ar_sin", "س", "Sin", "سَ", "সা (পাতলা)", "standard", "س", "سَلَام", "salām", "শান্তি"),
                    AlphabetLetter("ar_shin", "ش", "Shin", "شَ", "শা", "standard", "ش", "شُكْراً", "shukran", "ধন্যবাদ"),
                    AlphabetLetter("ar_fa", "ف", "Fa", "فَ", "ফা", "standard", "ف", "فُنْدُق", "funduq", "হোটেল"),
                    AlphabetLetter("ar_qaf", "ق", "Qaf (ক্বফ)", "قَ", "ক্ব (গভীর ক)", "standard", "ق", "قَلَم", "qalam", "কলম", "জিহ্বার একদম পেছনের অংশ থেকে ভারী 'ক্ব'।"),
                    AlphabetLetter("ar_kaf", "ك", "Kaf", "كَ", "কা (হালকা)", "standard", "ك", "كِتَاب", "kitāb", "বই"),
                    AlphabetLetter("ar_lam", "ل", "Lam", "لَ", "লা", "standard", "ل", "لَيْل", "layl", "রাত"),
                    AlphabetLetter("ar_mim", "م", "Mim", "مَ", "মা", "standard", "م", "مَاء", "mā'", "পানি"),
                    AlphabetLetter("ar_nun", "ن", "Nun", "نَ", "না", "standard", "ن", "نُور", "nūr", "আলো"),
                    AlphabetLetter("ar_waw", "و", "Waw", "وَ", "ওয়া / উ", "standard", "و", "وَقْت", "waqt", "সময়"),
                    AlphabetLetter("ar_ya", "ي", "Ya", "يَ", "ইয়া / ই", "standard", "ي", "يَوْم", "yawm", "দিন"),
                    AlphabetLetter("ar_tamarbuta", "ة", "Ta Marbuta", "ة", "-আ / -আত", "standard", "ة", "سَيَّارَة", "sayyāra", "গাড়ি", "শব্দের শেষে থাকলে 'আ' শোনায়, যুক্ত হলে 'ত' হয়।"),
                    AlphabetLetter("ar_hamza", "ء", "Hamza", "أَ", "আ' (থামা)", "standard", "ء", "مَسَاء", "masā'", "সন্ধ্যা")
                )
            ),
            AlphabetRow(
                id = "ar_harakat",
                titleBn = "হরকত, তানবীন, তাশদীদ ও সুকুন (স্বরচিহ্ন)",
                subtitleTarget = "فَتْحَة · كَسْرَة · ضَمَّة · سُكُون · شَدَّة",
                categoryId = "harakat",
                letters = listOf(
                    AlphabetLetter("ar_fatha", "بَ", "Fatha (জবর)", "بَ", "বা (আ-কার)", "harakat", "َ", "بَاب", "bāb", "দরজা", "বর্ণের উপরে ছোট আড়াআড়ি দাগ — 'আ/অ' ধ্বনি।"),
                    AlphabetLetter("ar_kasra", "بِ", "Kasra (জের)", "بِ", "বি (ই-কার)", "harakat", "ِ", "بِنْت", "bint", "মেয়ে", "বর্ণের নিচে ছোট দাগ — 'ই' ধ্বনি।"),
                    AlphabetLetter("ar_damma", "بُ", "Damma (পেশ)", "بُ", "বু (উ-কার)", "harakat", "ُ", "بُيُوت", "buyūt", "বাড়িগুলো", "বর্ণের উপরে ছোট واو-এর মতো চিহ্ন — 'উ' ধ্বনি।"),
                    AlphabetLetter("ar_sukun", "بْ", "Sukun (জজম)", "أَبْ", "আব্ (হসন্ত)", "harakat", "ْ", "أَبْيَض", "abyaḍ", "সাদা", "বর্ণটি স্বরহীনভাবে থামিয়ে দেয় (বাংলা হসন্তের মতো)।"),
                    AlphabetLetter("ar_shadda", "بَّ", "Shadda (তাশদীদ)", "رَبَّ", "রাব্বা (দ্বিত্ব)", "harakat", "ّ", "سَيَّارَة", "sayyāra", "গাড়ি", "বর্ণটি দুইবার জোর দিয়ে উচ্চারিত হয়।"),
                    AlphabetLetter("ar_tanwin_an", "اً / بً", "Tanwin Fath (-আন)", "شُكْراً", "শুকরান (-আন)", "harakat", "ً", "شُكْراً", "shukran", "ধন্যবাদ", "শব্দের শেষে '-আন' ধ্বনি যোগ করে।"),
                    AlphabetLetter("ar_tanwin_in", "بٍ", "Tanwin Kasr (-ইন)", "يَوْمٍ", "ইয়াওমিন (-ইন)", "harakat", "ٍ", "بَيْتٍ", "baytin", "একটি বাড়ির", "শব্দের শেষে '-ইন' ধ্বনি যোগ করে।"),
                    AlphabetLetter("ar_tanwin_un", "بٌ", "Tanwin Damm (-উন)", "كِتَابٌ", "কিতাবুন (-উন)", "harakat", "ٌ", "كِتَابٌ", "kitābun", "একটি বই", "শব্দের শেষে '-উন' ধ্বনি যোগ করে।")
                )
            )
        )
    )
}
