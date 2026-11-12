package com.gigabyte.bookstore.learning.presentation.calendar

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object ArabicCalendarData {

    val CONFIG = CalendarLanguageConfig(
        langCode = "arabic",
        speechLang = SpeechLang.AR,
        titleBn = "আরবি দিন, মাস (ইংরেজি ও হিজরি) ও ঋতু চার্ট",
        subtitleBn = "সপ্তাহের ৭ দিন, ১২টি গ্রেগরিয়ান ও হিজরি মাস, ৪ ঋতু এবং সময়",
        nativeTitle = "الأيام · الشهور · الفصول",
        accentColorHex = 0xFF00695C,
        categories = listOf(
            CalendarCategoryInfo(CalendarCategory.ALL, "সব (৪৮টি)"),
            CalendarCategoryInfo(CalendarCategory.DAYS, "৭ দিন"),
            CalendarCategoryInfo(CalendarCategory.MONTHS, "মাস (২৪টি)"),
            CalendarCategoryInfo(CalendarCategory.SEASONS, "৪ ঋতু"),
            CalendarCategoryInfo(CalendarCategory.TIME, "সময় ও দিনকাল")
        ),
        items = listOf(
            // 7 Days (Sunday = 1 in Arab Gulf calendar!)
            CalendarItem("ar-day-1", CalendarCategory.DAYS, "الأَحَد", "al-aḥad", "রবিবার", "আল-আহাদ", "الأحد", "☀️", "গাল্ফ দেশে সপ্তাহ শুরু হয় রবিবার দিয়ে (১ম দিন)"),
            CalendarItem("ar-day-2", CalendarCategory.DAYS, "الإِثْنَيْن", "al-ithnayn", "সোমবার", "আল-ইসনাইন", "الإثنين", "📅", "সপ্তাহের ২য় কর্মদিবস"),
            CalendarItem("ar-day-3", CalendarCategory.DAYS, "الثُّلَاثَاء", "ath-thulāthā'", "মঙ্গলবার", "আস-সুলাসা", "الثلاثاء", "📅", "সপ্তাহের ৩য় দিন"),
            CalendarItem("ar-day-4", CalendarCategory.DAYS, "الأَرْبِعَاء", "al-arbi'ā'", "বুধবার", "আল-আরবিআ", "الأربعاء", "📅", "সপ্তাহের ৪র্থ দিন"),
            CalendarItem("ar-day-5", CalendarCategory.DAYS, "الخَمِيس", "al-khamīs", "বৃহস্পতিবার", "আল-খামীস", "الخميس", "📅", "সপ্তাহের শেষ কর্মদিবস"),
            CalendarItem("ar-day-6", CalendarCategory.DAYS, "الجُمُعَة", "al-jumu'a", "শুক্রবার (জুমা)", "আল-জুমুআ", "الجمعة", "🕌", "পবিত্র জুমাবার — সাপ্তাহিক ছুটির দিন"),
            CalendarItem("ar-day-7", CalendarCategory.DAYS, "السَّبْت", "as-sabt", "শনিবার", "আস-সাবত", "السبت", "📅", "সাপ্তাহিক ছুটির দিন (KSA/UAE)"),

            // 12 Gregorian Months (used across Gulf/Saudi)
            CalendarItem("ar-mon-1", CalendarCategory.MONTHS, "يَنَايِر", "yanāyir", "জানুয়ারি", "ইয়ানায়ির", "يناير", "❄️", "গ্রেগরিয়ান ১ম মাস"),
            CalendarItem("ar-mon-2", CalendarCategory.MONTHS, "فِبْرَايِر", "fibrāyir", "ফেব্রুয়ারি", "ফিবরায়ির", "فبراير", "❄️", "গ্রেগরিয়ান ২য় মাস"),
            CalendarItem("ar-mon-3", CalendarCategory.MONTHS, "مَارِس", "māris", "মার্চ", "মারিস", "مارس", "🌸", "গ্রেগরিয়ান ৩য় মাস"),
            CalendarItem("ar-mon-4", CalendarCategory.MONTHS, "أَبْرِيل", "abrīl", "এপ্রিল", "আব্রীল", "أبريل", "🌸", "গ্রেগরিয়ান ৪র্থ মাস"),
            CalendarItem("ar-mon-5", CalendarCategory.MONTHS, "مَايُو", "māyū", "মে", "মায়ু", "مايو", "☀️", "গ্রেগরিয়ান ৫ম মাস"),
            CalendarItem("ar-mon-6", CalendarCategory.MONTHS, "يُونْيُو", "yūnyū", "জুন", "ইউন-ইউ", "يونيو", "☀️", "গ্রেগরিয়ান ৬ষ্ঠ মাস"),
            CalendarItem("ar-mon-7", CalendarCategory.MONTHS, "يُولْيُو", "yūlyū", "জুলাই", "ইউলিউ", "يوليو", "🔥", "গ্রেগরিয়ান ৭ম মাস"),
            CalendarItem("ar-mon-8", CalendarCategory.MONTHS, "أَغُسْطُس", "aghusṭus", "আগস্ট", "আগস্তুস", "أغسطس", "🔥", "গ্রেগরিয়ান ৮ম মাস"),
            CalendarItem("ar-mon-9", CalendarCategory.MONTHS, "سِبْتَمْبَر", "sibtambar", "সেপ্টেম্বর", "সিবতামবার", "سبتمبر", "🍂", "গ্রেগরিয়ান ৯ম মাস"),
            CalendarItem("ar-mon-10", CalendarCategory.MONTHS, "أُكْتُوبَر", "uktūbar", "অক্টোবর", "উক্তূবার", "أكتوبر", "🍂", "গ্রেগরিয়ান ১০ম মাস"),
            CalendarItem("ar-mon-11", CalendarCategory.MONTHS, "نُوفَمْبَر", "nūfambar", "নভেম্বর", "নূফাম্বার", "نوفمبر", "🌬️", "গ্রেগরিয়ান ১১তম মাস"),
            CalendarItem("ar-mon-12", CalendarCategory.MONTHS, "دِيسَمْبَر", "dīsambar", "ডিসেম্বর", "দিসাম্বার", "ديسمبر", "❄️", "গ্রেগরিয়ান ১২তম মাস"),

            // 12 Hijri Months
            CalendarItem("ar-hij-1", CalendarCategory.MONTHS, "مُحَرَّم", "muḥarram", "মুহাররম", "মুহাররাম", "محرم", "🌙", "হিজরি ১ম মাস"),
            CalendarItem("ar-hij-2", CalendarCategory.MONTHS, "صَفَر", "ṣafar", "সফর", "সাফার", "صفر", "🌙", "হিজরি ২য় মাস"),
            CalendarItem("ar-hij-3", CalendarCategory.MONTHS, "رَبِيع الأَوَّل", "rabī' al-awwal", "রবিউল আউয়াল", "রাবীউল আউয়াল", "ربيع الأول", "🌙", "হিজরি ৩য় মাস"),
            CalendarItem("ar-hij-4", CalendarCategory.MONTHS, "رَبِيع الثَّانِي", "rabī' ath-thānī", "রবিউস সানি", "রাবীউস সানি", "ربيع الثاني", "🌙", "হিজরি ৪র্থ মাস"),
            CalendarItem("ar-hij-5", CalendarCategory.MONTHS, "جُمَادَى الأُولَى", "jumādā al-ūlā", "জুমাদাল উলা", "জুমাদাল উলা", "جمادى الأولى", "🌙", "হিজরি ৫ম মাস"),
            CalendarItem("ar-hij-6", CalendarCategory.MONTHS, "جُمَادَى الآخِرَة", "jumādā al-ākhira", "জুমাদাল আখিরাহ", "জুমাদাল আখিরাহ", "جمادى الآخرة", "🌙", "হিজরি ৬ষ্ঠ মাস"),
            CalendarItem("ar-hij-7", CalendarCategory.MONTHS, "رَجَب", "rajab", "রজব", "রাজাব", "رجب", "🌙", "হিজরি ৭ম মাস"),
            CalendarItem("ar-hij-8", CalendarCategory.MONTHS, "شَعْبَان", "sha'bān", "শাবান", "শাবান", "شعبان", "🌙", "হিজরি ৮ম মাস"),
            CalendarItem("ar-hij-9", CalendarCategory.MONTHS, "رَمَضَان", "ramaḍān", "রমযান", "রামাদ্বান", "رمضان", "🕌", "হিজরি ৯ম মাস — সিয়াম ও তারাবীহ"),
            CalendarItem("ar-hij-10", CalendarCategory.MONTHS, "شَوَّال", "shawwāl", "শাওয়াল", "শাউওয়াল", "شوال", "🎉", "হিজরি ১০ম মাস — ঈদুল ফিতর"),
            CalendarItem("ar-hij-11", CalendarCategory.MONTHS, "ذُو القَعْدَة", "dhū al-qa'da", "জিলকদ", "যুল-ক্বাদাহ", "ذو القعدة", "🌙", "হিজরি ১১তম মাস"),
            CalendarItem("ar-hij-12", CalendarCategory.MONTHS, "ذُو الحِجَّة", "dhū al-ḥijja", "জিলহজ্জ", "যুল-হিজ্জাহ", "ذو الحجة", "🕋", "হিজরি ১২তম মাস — হজ্জ ও ঈদুল আজহা"),

            // 4 Seasons
            CalendarItem("ar-sea-1", CalendarCategory.SEASONS, "الرَّبِيع", "ar-rabī'", "বসন্তকাল", "আর-রাবী", "الربيع", "🌸", "মনোরম আবহাওয়া"),
            CalendarItem("ar-sea-2", CalendarCategory.SEASONS, "الصَّيْف", "aṣ-ṣayf", "গ্রীষ্মকাল", "আস-সাইফ", "الصيف", "☀️", "গাল্ফ দেশে প্রচণ্ড গরম"),
            CalendarItem("ar-sea-3", CalendarCategory.SEASONS, "الخَرِيف", "al-kharīf", "শরৎকাল", "আল-খারীফ", "الخريف", "🍂", "হালকা বাতাস ও ঠান্ডা শুরু"),
            CalendarItem("ar-sea-4", CalendarCategory.SEASONS, "الشِّتَاء", "ash-shitā'", "শীতকাল", "আশ-শিতা", "الشتاء", "❄️", "মরুভূমিতে রাতে বেশ ঠান্ডা"),

            // Time & Relative Days
            CalendarItem("ar-tim-1", CalendarCategory.TIME, "اليَوْم", "al-yawm", "আজ", "আল-ইয়াওম", "اليوم", "📍", "আজকের দিন"),
            CalendarItem("ar-tim-2", CalendarCategory.TIME, "غَداً / بُكْرَة", "ghadan / bukra", "আগামীকাল", "গদান / বুকরা", "غداً", "➡️", "ফুসহায় غداً এবং গাল্ফে بُكْرَة বলে"),
            CalendarItem("ar-tim-3", CalendarCategory.TIME, "أَمْس", "ams", "গতকাল", "আমস", "أمس", "⬅️", "গতকাল"),
            CalendarItem("ar-tim-4", CalendarCategory.TIME, "الآن / الحِين", "al-ān / al-ḥīn", "এখন", "আল-আন / আল-হীন", "الآن", "⏰", "ফুসহায় الآن এবং গাল্ফে الحين"),
            CalendarItem("ar-tim-5", CalendarCategory.TIME, "صَبَاحاً", "ṣabāḥan", "সকালে", "সাবাহান", "صباحاً", "🌅", "সকাল বেলা"),
            CalendarItem("ar-tim-6", CalendarCategory.TIME, "مَسَاءً", "masā'an", "সন্ধ্যায় / রাতে", "মাসাআন", "مساءً", "🌙", "সন্ধ্যা বা বিকেল পর"),
            CalendarItem("ar-tim-7", CalendarCategory.TIME, "سَاعَة", "sā'a", "ঘণ্টা / ঘড়ি", "সাআহ", "ساعة", "⌚", "সময় ও ঘড়ি উভয়ই"),
            CalendarItem("ar-tim-8", CalendarCategory.TIME, "دَقِيقَة", "daqīqa", "মিনিট", "দাক্বীক্বাহ", "دقيقة", "⏱️", "এক মিনিট = دقيقة واحدة"),
            CalendarItem("ar-tim-9", CalendarCategory.TIME, "أُسْبُوع", "usbū'", "সপ্তাহ", "উসবূ", "أسبوع", "📆", "৭ দিন = أسبوع"),
            CalendarItem("ar-tim-10", CalendarCategory.TIME, "شَهْر", "shahr", "মাস", "শাহর", "شهر", "🗓️", "প্রতি মাসে বেতন = راتب شهري"),
            CalendarItem("ar-tim-11", CalendarCategory.TIME, "سَنَة", "sana", "বছর", "সানাহ", "سنة", "🎉", "১ বছর = سنة واحدة"),
            CalendarItem("ar-tim-12", CalendarCategory.TIME, "إِنْ شَاءَ الله", "in shā'a Allāh", "ইনশাআল্লাহ", "ইন শা আল্লাহ", "إن شاء الله", "🤲", "ভবিষ্যতের যেকোনো কাজের সাথে বলা হয়")
        )
    )
}
