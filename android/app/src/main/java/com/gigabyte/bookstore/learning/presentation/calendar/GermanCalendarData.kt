package com.gigabyte.bookstore.learning.presentation.calendar

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object GermanCalendarData {

    val CONFIG = CalendarLanguageConfig(
        langCode = "german",
        speechLang = SpeechLang.DE,
        titleBn = "জার্মান দিন, মাস ও ঋতু চার্ট",
        subtitleBn = "সপ্তাহের ৭ দিন, ১২ মাস, ঋতু এবং সময় সংক্রান্ত প্রয়োজনীয় শব্দমালা",
        nativeTitle = "Tage, Monate & Jahreszeiten",
        accentColorHex = 0xFF004D40,
        categories = listOf(
            CalendarCategoryInfo(CalendarCategory.ALL, "সব (৩৮টি)"),
            CalendarCategoryInfo(CalendarCategory.DAYS, "৭ দিন"),
            CalendarCategoryInfo(CalendarCategory.MONTHS, "১২ মাস"),
            CalendarCategoryInfo(CalendarCategory.SEASONS, "৪ ঋতু"),
            CalendarCategoryInfo(CalendarCategory.TIME, "সময় ও দিনকাল")
        ),
        items = listOf(
            // 7 Days
            CalendarItem("de-day-1", CalendarCategory.DAYS, "Montag", "der Montag", "সোমবার", "মোন্টাগ", "Montag", "🗓️"),
            CalendarItem("de-day-2", CalendarCategory.DAYS, "Dienstag", "der Dienstag", "মঙ্গলবার", "ডিন্সটাগ", "Dienstag", "🗓️"),
            CalendarItem("de-day-3", CalendarCategory.DAYS, "Mittwoch", "der Mittwoch", "বুধবার", "মিটভখ", "Mittwoch", "🗓️"),
            CalendarItem("de-day-4", CalendarCategory.DAYS, "Donnerstag", "der Donnerstag", "বৃহস্পতিবার", "ডনার্সটাগ", "Donnerstag", "🗓️"),
            CalendarItem("de-day-5", CalendarCategory.DAYS, "Freitag", "der Freitag", "শুক্রবার", "ফ্রাইটাগ", "Freitag", "🗓️"),
            CalendarItem("de-day-6", CalendarCategory.DAYS, "Samstag", "der Samstag", "শনিবার", "যাম্সটাগ", "Samstag", "🗓️"),
            CalendarItem("de-day-7", CalendarCategory.DAYS, "Sonntag", "der Sonntag", "রবিবার", "যন্টাগ", "Sonntag", "☀️"),

            // 12 Months
            CalendarItem("de-mon-1", CalendarCategory.MONTHS, "Januar", "der Januar", "জানুয়ারি", "ইয়ানুয়ার", "Januar", "❄️"),
            CalendarItem("de-mon-2", CalendarCategory.MONTHS, "Februar", "der Februar", "ফেব্রুয়ারি", "ফেব্রুয়ার", "Februar", "❄️"),
            CalendarItem("de-mon-3", CalendarCategory.MONTHS, "März", "der März", "মার্চ", "মের্ৎজ", "März", "🌸"),
            CalendarItem("de-mon-4", CalendarCategory.MONTHS, "April", "der April", "এপ্রিল", "এপ্রিল", "April", "🌸"),
            CalendarItem("de-mon-5", CalendarCategory.MONTHS, "Mai", "der Mai", "মে", "মাই", "Mai", "☀️"),
            CalendarItem("de-mon-6", CalendarCategory.MONTHS, "Juni", "der Juni", "জুন", "ইউনী", "Juni", "☀️"),
            CalendarItem("de-mon-7", CalendarCategory.MONTHS, "Juli", "der Juli", "জুলাই", "ইউলী", "Juli", "☀️"),
            CalendarItem("de-mon-8", CalendarCategory.MONTHS, "August", "der August", "আগস্ট", "আউগুস্ট", "August", "☀️"),
            CalendarItem("de-mon-9", CalendarCategory.MONTHS, "September", "der September", "সেপ্টেম্বর", "যেপ্টেম্বর", "September", "🍂"),
            CalendarItem("de-mon-10", CalendarCategory.MONTHS, "Oktober", "der Oktober", "অক্টোবর", "অক্টোবর", "Oktober", "🍂"),
            CalendarItem("de-mon-11", CalendarCategory.MONTHS, "November", "der November", "নভেম্বর", "নভেম্বর", "November", "❄️"),
            CalendarItem("de-mon-12", CalendarCategory.MONTHS, "Dezember", "der Dezember", "ডিসেম্বর", "ডেৎসেম্বর", "Dezember", "❄️"),

            // 4 Seasons
            CalendarItem("de-sea-1", CalendarCategory.SEASONS, "der Frühling", "Frühling", "বসন্তকাল", "ডের ফ্রুলিং", "der Frühling", "🌸", "ফুলের ঋতু"),
            CalendarItem("de-sea-2", CalendarCategory.SEASONS, "der Sommer", "Sommer", "গ্রীষ্মকাল", "ডের যমার", "der Sommer", "☀️", "রৌদ্রোজ্জ্বল উষ্ণ ঋতু"),
            CalendarItem("de-sea-3", CalendarCategory.SEASONS, "der Herbst", "Herbst", "শরৎকাল", "ডের হের্বস্ট", "der Herbst", "🍁", "পাতা ঝরার রঙিন ঋতু"),
            CalendarItem("de-sea-4", CalendarCategory.SEASONS, "der Winter", "Winter", "শীতকাল", "ডের ভিন্নটার", "der Winter", "⛄", "তুষার ও শীতল ঋতু"),

            // Time & Days
            CalendarItem("de-time-1", CalendarCategory.TIME, "heute", "heute", "আজ", "হয়টে", "heute", "📅"),
            CalendarItem("de-time-2", CalendarCategory.TIME, "morgen", "morgen", "আগামীকাল", "মরগেন", "morgen", "⏩"),
            CalendarItem("de-time-3", CalendarCategory.TIME, "gestern", "gestern", "গতকাল", "গেস্টার্ন", "gestern", "⏪"),
            CalendarItem("de-time-4", CalendarCategory.TIME, "übermorgen", "übermorgen", "পরশু দিন", "উবারমরগেন", "übermorgen", "⏭️"),
            CalendarItem("de-time-5", CalendarCategory.TIME, "jetzt", "jetzt", "এখন", "ইয়েৎস্ট", "jetzt", "⏰"),
            CalendarItem("de-time-6", CalendarCategory.TIME, "der Morgen", "am Morgen", "সকাল", "ডের মরগেন", "der Morgen", "🌅"),
            CalendarItem("de-time-7", CalendarCategory.TIME, "der Mittag", "am Mittag", "দুপুর", "ডের মিট্টাগ", "der Mittag", "☀️"),
            CalendarItem("de-time-8", CalendarCategory.TIME, "der Abend", "am Abend", "সন্ধ্যা", "ডের আবেন্ট", "der Abend", "🌇"),
            CalendarItem("de-time-9", CalendarCategory.TIME, "die Nacht", "in der Nacht", "রাত", "ডি নাখ্ট", "die Nacht", "🌙"),
            CalendarItem("de-time-10", CalendarCategory.TIME, "jeden Tag", "täglich", "প্রতিদিন", "ইয়েডেন টাগ", "jeden Tag", "🔄"),
            CalendarItem("de-time-11", CalendarCategory.TIME, "diese Woche", "diese Woche", "এই সপ্তাহে", "ডিজে ভখে", "diese Woche", "📆"),
            CalendarItem("de-time-12", CalendarCategory.TIME, "nächste Woche", "nächste Woche", "আগামী সপ্তাহে", "নেক্সটে ভখে", "nächste Woche", "📅"),
            CalendarItem("de-time-13", CalendarCategory.TIME, "letzte Woche", "letzte Woche", "গত সপ্তাহে", "লেৎসটে ভখে", "letzte Woche", "📅"),
            CalendarItem("de-time-14", CalendarCategory.TIME, "der Monat", "Monat", "মাস", "ডের মোনাট", "der Monat", "🗓️"),
            CalendarItem("de-time-15", CalendarCategory.TIME, "das Jahr", "Jahr", "বছর", "ডাস ইয়ার", "das Jahr", "🎆")
        )
    )
}

