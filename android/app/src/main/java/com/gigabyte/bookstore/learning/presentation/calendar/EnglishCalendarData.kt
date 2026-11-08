package com.gigabyte.bookstore.learning.presentation.calendar

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object EnglishCalendarData {

    val CONFIG = CalendarLanguageConfig(
        langCode = "english",
        speechLang = SpeechLang.EN,
        titleBn = "ইংরেজি দিন, মাস ও ঋতু চার্ট",
        subtitleBn = "সপ্তাহের ৭ দিন, ১২ মাস, ঋতু এবং সময় সংক্রান্ত প্রয়োজনীয় শব্দমালা",
        nativeTitle = "Days, Months & Seasons",
        accentColorHex = 0xFF1565C0,
        categories = listOf(
            CalendarCategoryInfo(CalendarCategory.ALL, "সব (৪০টি)"),
            CalendarCategoryInfo(CalendarCategory.DAYS, "৭ দিন"),
            CalendarCategoryInfo(CalendarCategory.MONTHS, "১২ মাস"),
            CalendarCategoryInfo(CalendarCategory.SEASONS, "৬ ঋতু"),
            CalendarCategoryInfo(CalendarCategory.TIME, "সময় ও দিনকাল")
        ),
        items = listOf(
            // 7 Days
            CalendarItem("en-day-1", CalendarCategory.DAYS, "Monday", "Mon", "সোমবার", "মানডে", "Monday", "🗓️"),
            CalendarItem("en-day-2", CalendarCategory.DAYS, "Tuesday", "Tue", "মঙ্গলবার", "টিউজডে", "Tuesday", "🗓️"),
            CalendarItem("en-day-3", CalendarCategory.DAYS, "Wednesday", "Wed", "বুধবার", "ওয়েন্জডে", "Wednesday", "🗓️"),
            CalendarItem("en-day-4", CalendarCategory.DAYS, "Thursday", "Thu", "বৃহস্পতিবার", "থার্সডে", "Thursday", "🗓️"),
            CalendarItem("en-day-5", CalendarCategory.DAYS, "Friday", "Fri", "শুক্রবার", "ফ্রাইডে", "Friday", "🗓️"),
            CalendarItem("en-day-6", CalendarCategory.DAYS, "Saturday", "Sat", "শনিবার", "স্যাটারডে", "Saturday", "🗓️"),
            CalendarItem("en-day-7", CalendarCategory.DAYS, "Sunday", "Sun", "রবিবার", "সানডে", "Sunday", "☀️"),

            // 12 Months
            CalendarItem("en-mon-1", CalendarCategory.MONTHS, "January", "Jan", "জানুয়ারি", "জানুয়ারি", "January", "❄️"),
            CalendarItem("en-mon-2", CalendarCategory.MONTHS, "February", "Feb", "ফেব্রুয়ারি", "ফেব্রুয়ারি", "February", "❄️"),
            CalendarItem("en-mon-3", CalendarCategory.MONTHS, "March", "Mar", "মার্চ", "মার্চ", "March", "🌸"),
            CalendarItem("en-mon-4", CalendarCategory.MONTHS, "April", "Apr", "এপ্রিল", "এপ্রিল", "April", "🌸"),
            CalendarItem("en-mon-5", CalendarCategory.MONTHS, "May", "May", "মে", "মে", "May", "☀️"),
            CalendarItem("en-mon-6", CalendarCategory.MONTHS, "June", "Jun", "জুন", "জুন", "June", "☀️"),
            CalendarItem("en-mon-7", CalendarCategory.MONTHS, "July", "Jul", "জুলাই", "জুলাই", "July", "☀️"),
            CalendarItem("en-mon-8", CalendarCategory.MONTHS, "August", "Aug", "আগস্ট", "অগাস্ট", "August", "☀️"),
            CalendarItem("en-mon-9", CalendarCategory.MONTHS, "September", "Sep", "সেপ্টেম্বর", "সেপ্টেম্বর", "September", "🍂"),
            CalendarItem("en-mon-10", CalendarCategory.MONTHS, "October", "Oct", "অক্টোবর", "অক্টোবর", "October", "🍂"),
            CalendarItem("en-mon-11", CalendarCategory.MONTHS, "November", "Nov", "নভেম্বর", "নভেম্বর", "November", "❄️"),
            CalendarItem("en-mon-12", CalendarCategory.MONTHS, "December", "Dec", "ডিসেম্বর", "ডিসেম্বর", "December", "🎄"),

            // 6 Seasons
            CalendarItem("en-sea-1", CalendarCategory.SEASONS, "Spring", "Spring Season", "বসন্তকাল", "স্প্রিং", "Spring", "🌸", "ফুলের ঋতু"),
            CalendarItem("en-sea-2", CalendarCategory.SEASONS, "Summer", "Summer Season", "গ্রীষ্মকাল", "সামার", "Summer", "☀️", "রৌদ্রোজ্জ্বল উষ্ণ ঋতু"),
            CalendarItem("en-sea-3", CalendarCategory.SEASONS, "Rainy Season", "Monsoon", "বর্ষাকাল", "রেইনি সিজন / মনসুন", "Rainy Season", "🌧️", "বৃষ্টির ঋতু"),
            CalendarItem("en-sea-4", CalendarCategory.SEASONS, "Autumn", "Fall", "শরৎকাল", "অটাম / ফল", "Autumn", "🌾", "নির্মল ও সোনালী ঋতু"),
            CalendarItem("en-sea-5", CalendarCategory.SEASONS, "Late Autumn", "Pre-winter", "হেমন্তকাল", "লেইট অটাম", "Late Autumn", "🍁", "শীতের আগমনী ঋতু"),
            CalendarItem("en-sea-6", CalendarCategory.SEASONS, "Winter", "Winter Season", "শীতকাল", "উইন্টার", "Winter", "⛄", "তুষার ও শীতল ঋতু"),

            // Time & Days
            CalendarItem("en-time-1", CalendarCategory.TIME, "Today", "Today", "আজ", "টুডে", "Today", "📅"),
            CalendarItem("en-time-2", CalendarCategory.TIME, "Tomorrow", "Tomorrow", "আগামীকাল", "টুমরো", "Tomorrow", "⏩"),
            CalendarItem("en-time-3", CalendarCategory.TIME, "Yesterday", "Yesterday", "গতকাল", "ইয়েস্টারডে", "Yesterday", "⏪"),
            CalendarItem("en-time-4", CalendarCategory.TIME, "Day after tomorrow", "Day after tomorrow", "পরশু দিন", "ডে আফটার টুমরো", "Day after tomorrow", "⏭️"),
            CalendarItem("en-time-5", CalendarCategory.TIME, "Now", "Now", "এখন", "নাউ", "Now", "⏰"),
            CalendarItem("en-time-6", CalendarCategory.TIME, "Morning", "Morning", "সকাল", "মর্নিং", "Morning", "🌅"),
            CalendarItem("en-time-7", CalendarCategory.TIME, "Noon", "Midday", "দুপুর", "নুন", "Noon", "☀️"),
            CalendarItem("en-time-8", CalendarCategory.TIME, "Afternoon", "Afternoon", "বিকাল", "আফটারনুন", "Afternoon", "🌇"),
            CalendarItem("en-time-9", CalendarCategory.TIME, "Evening", "Evening", "সন্ধ্যা", "ইভনিং", "Evening", "🌆"),
            CalendarItem("en-time-10", CalendarCategory.TIME, "Night", "Night", "রাত", "নাইট", "Night", "🌙"),
            CalendarItem("en-time-11", CalendarCategory.TIME, "Every day", "Daily", "প্রতিদিন", "এভরি ডে", "Every day", "🔄"),
            CalendarItem("en-time-12", CalendarCategory.TIME, "This week", "This week", "এই সপ্তাহে", "দিস উইক", "This week", "📆"),
            CalendarItem("en-time-13", CalendarCategory.TIME, "Next week", "Next week", "আগামী সপ্তাহে", "নেক্সট উইক", "Next week", "📅"),
            CalendarItem("en-time-14", CalendarCategory.TIME, "Last week", "Last week", "গত সপ্তাহে", "লাস্ট উইক", "Last week", "📅"),
            CalendarItem("en-time-15", CalendarCategory.TIME, "Month", "Month", "মাস", "মান্থ", "Month", "🗓️"),
            CalendarItem("en-time-16", CalendarCategory.TIME, "Year", "Year", "বছর", "ইয়ার", "Year", "🎆")
        )
    )
}

