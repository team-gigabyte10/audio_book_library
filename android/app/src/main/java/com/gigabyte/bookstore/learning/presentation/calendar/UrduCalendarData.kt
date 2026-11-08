package com.gigabyte.bookstore.learning.presentation.calendar

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object UrduCalendarData {

    val CONFIG = CalendarLanguageConfig(
        langCode = "urdu",
        speechLang = SpeechLang.UR,
        titleBn = "উর্দু দিন, মাস ও ঋতু চার্ট",
        subtitleBn = "সপ্তাহের ৭ দিন, ১২ মাস, ঋতু এবং সময় সংক্রান্ত প্রয়োজনীয় শব্দমালা",
        nativeTitle = "دن، مہینے اور موسم (Din, Mahine aur Mausam)",
        accentColorHex = 0xFF1B5E20,
        categories = listOf(
            CalendarCategoryInfo(CalendarCategory.ALL, "সব (৩৮টি)"),
            CalendarCategoryInfo(CalendarCategory.DAYS, "৭ দিন"),
            CalendarCategoryInfo(CalendarCategory.MONTHS, "১২ মাস"),
            CalendarCategoryInfo(CalendarCategory.SEASONS, "৫ ঋতু"),
            CalendarCategoryInfo(CalendarCategory.TIME, "সময় ও দিনকাল")
        ),
        items = listOf(
            // 7 Days
            CalendarItem("ur-day-1", CalendarCategory.DAYS, "پیر", "Peer", "সোমবার", "পীর", "پیر", "🗓️"),
            CalendarItem("ur-day-2", CalendarCategory.DAYS, "منگل", "Mangal", "মঙ্গলবার", "মঙ্গল", "منگل", "🗓️"),
            CalendarItem("ur-day-3", CalendarCategory.DAYS, "بدھ", "Budh", "বুধবার", "বুধ", "بدھ", "🗓️"),
            CalendarItem("ur-day-4", CalendarCategory.DAYS, "جمعرات", "Jumerat", "বৃহস্পতিবার", "জুমেরাত", "جمعرات", "🗓️"),
            CalendarItem("ur-day-5", CalendarCategory.DAYS, "جمعہ", "Jummah", "শুক্রবার", "জুমাহ", "جمعہ", "🕌"),
            CalendarItem("ur-day-6", CalendarCategory.DAYS, "ہفتہ", "Hafta", "শনিবার", "হাফতা", "ہفتہ", "🗓️"),
            CalendarItem("ur-day-7", CalendarCategory.DAYS, "اتوار", "Itwar", "রবিবার", "ইতওয়ার", "اتوار", "☀️"),

            // 12 Months
            CalendarItem("ur-mon-1", CalendarCategory.MONTHS, "جنوری", "January", "জানুয়ারি", "জানুয়ারি", "جنوری", "❄️"),
            CalendarItem("ur-mon-2", CalendarCategory.MONTHS, "فروری", "February", "ফেব্রুয়ারি", "ফেব্রুয়ারি", "فروری", "❄️"),
            CalendarItem("ur-mon-3", CalendarCategory.MONTHS, "مارچ", "March", "মার্চ", "মার্চ", "مارچ", "🌸"),
            CalendarItem("ur-mon-4", CalendarCategory.MONTHS, "اپریل", "April", "এপ্রিল", "এপ্রিল", "اپریل", "🌸"),
            CalendarItem("ur-mon-5", CalendarCategory.MONTHS, "مئی", "May", "মে", "মে", "مئی", "☀️"),
            CalendarItem("ur-mon-6", CalendarCategory.MONTHS, "جون", "June", "জুন", "জুন", "جون", "☀️"),
            CalendarItem("ur-mon-7", CalendarCategory.MONTHS, "جولائی", "July", "জুলাই", "জুলাই", "جولائی", "☔"),
            CalendarItem("ur-mon-8", CalendarCategory.MONTHS, "اگست", "August", "আগস্ট", "আগস্ট", "اگست", "☔"),
            CalendarItem("ur-mon-9", CalendarCategory.MONTHS, "ستمبر", "September", "সেপ্টেম্বর", "সেপ্টেম্বর", "ستمبر", "🍂"),
            CalendarItem("ur-mon-10", CalendarCategory.MONTHS, "اکتوبر", "October", "অক্টোবর", "অক্টোবর", "اکتوبر", "🍂"),
            CalendarItem("ur-mon-11", CalendarCategory.MONTHS, "نومبر", "November", "নভেম্বর", "নভেম্বর", "نومبر", "❄️"),
            CalendarItem("ur-mon-12", CalendarCategory.MONTHS, "دسمبر", "December", "ডিসেম্বর", "ডিসেম্বর", "دسمبر", "❄️"),

            // 5 Seasons
            CalendarItem("ur-sea-1", CalendarCategory.SEASONS, "موسمِ بہار", "Mausam-e-Bahar", "বসন্তকাল", "মৌসম-এ-বাহার", "موسم بہار", "🌸", "ফুলের মৌসুম"),
            CalendarItem("ur-sea-2", CalendarCategory.SEASONS, "موسمِ گرما", "Mausam-e-Garma", "গ্রীষ্মকাল", "মৌসম-এ-গার্মা", "موسم گرما", "☀️", "গরমের মৌসুম"),
            CalendarItem("ur-sea-3", CalendarCategory.SEASONS, "موسمِ برسات", "Mausam-e-Barsat", "বর্ষাকাল", "মৌসম-এ-বারসাত", "موسم برسات", "🌧️", "বৃষ্টির মৌসুম"),
            CalendarItem("ur-sea-4", CalendarCategory.SEASONS, "موسمِ خزاں", "Mausam-e-Khizan", "শরৎকাল", "মৌসম-এ-খিজাঁ", "موسم خزاں", "🍁", "পাতা ঝরার মৌসুম"),
            CalendarItem("ur-sea-5", CalendarCategory.SEASONS, "موسمِ سرما", "Mausam-e-Sarma", "শীতকাল", "মৌসম-এ-সার্মা", "موسم سرما", "⛄", "ঠাণ্ডার মৌসুম"),

            // Time & Days
            CalendarItem("ur-time-1", CalendarCategory.TIME, "آج", "Aaj", "আজ", "আজ", "آج", "📅"),
            CalendarItem("ur-time-2", CalendarCategory.TIME, "کل", "Kal (Aane wala)", "আগামীকাল", "কাল (আগামী)", "کل", "⏩"),
            CalendarItem("ur-time-3", CalendarCategory.TIME, "گزشتہ کل", "Kal (Guzra hua)", "গতকাল", "গুজাশতা কাল (গত)", "گزشتہ کل", "⏪"),
            CalendarItem("ur-time-4", CalendarCategory.TIME, "پرسوں", "Parson", "পরশু দিন", "পরসোঁ", "پرسوں", "⏭️"),
            CalendarItem("ur-time-5", CalendarCategory.TIME, "اب", "Ab", "এখন", "আব", "اب", "⏰"),
            CalendarItem("ur-time-6", CalendarCategory.TIME, "صبح", "Subah", "সকাল", "সুবহ", "صبح", "🌅"),
            CalendarItem("ur-time-7", CalendarCategory.TIME, "دوپہر", "Dopahar", "দুপুর", "দোপাহের", "دوپہر", "☀️"),
            CalendarItem("ur-time-8", CalendarCategory.TIME, "شام", "Shaam", "সন্ধ্যা", "শাম", "شام", "🌇"),
            CalendarItem("ur-time-9", CalendarCategory.TIME, "رات", "Raat", "রাত", "রাত", "رات", "🌙"),
            CalendarItem("ur-time-10", CalendarCategory.TIME, "روزانہ", "Rozana", "প্রতিদিন", "রোযানা", "روزانہ", "🔄"),
            CalendarItem("ur-time-11", CalendarCategory.TIME, "اس ہفتے", "Is hafte", "এই সপ্তাহে", "ইস হাফতে", "اس ہفتے", "📆"),
            CalendarItem("ur-time-12", CalendarCategory.TIME, "اگلے ہفتے", "Agle hafte", "আগামী সপ্তাহে", "আগলে হাফতে", "اگلے ہفتے", "📅"),
            CalendarItem("ur-time-13", CalendarCategory.TIME, "پچھلے ہفتے", "Pichhle hafte", "গত সপ্তাহে", "পিছলে হাফতে", "پچھلے ہفتے", "📅"),
            CalendarItem("ur-time-14", CalendarCategory.TIME, "مہینہ", "Mahina", "মাস", "মাহীনা", "مہینہ", "🗓️"),
            CalendarItem("ur-time-15", CalendarCategory.TIME, "سال", "Saal", "বছর", "সাল", "سال", "🎆")
        )
    )
}

