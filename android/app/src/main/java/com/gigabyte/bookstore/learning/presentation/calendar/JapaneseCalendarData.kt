package com.gigabyte.bookstore.learning.presentation.calendar

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object JapaneseCalendarData {

    val CONFIG = CalendarLanguageConfig(
        langCode = "japanese",
        speechLang = SpeechLang.JA,
        titleBn = "জাপানি দিন, মাস ও ঋতু চার্ট",
        subtitleBn = "সপ্তাহের ৭ দিন, ১২ মাস, ঋতু এবং সময় সংক্রান্ত প্রয়োজনীয় শব্দমালা",
        nativeTitle = "曜日・月・季節 (Youbi, Tsuki, Kisetsu)",
        accentColorHex = 0xFFC62828,
        categories = listOf(
            CalendarCategoryInfo(CalendarCategory.ALL, "সব (৩৮টি)"),
            CalendarCategoryInfo(CalendarCategory.DAYS, "৭ দিন"),
            CalendarCategoryInfo(CalendarCategory.MONTHS, "১২ মাস"),
            CalendarCategoryInfo(CalendarCategory.SEASONS, "৪ ঋতু"),
            CalendarCategoryInfo(CalendarCategory.TIME, "সময় ও দিনকাল")
        ),
        items = listOf(
            // 7 Days
            CalendarItem("jp-day-1", CalendarCategory.DAYS, "月曜日", "げつようび", "সোমবার", "গেৎসুয়োওবি", "げつようび", "🌙", "চন্দ্র দিবস (Moon)"),
            CalendarItem("jp-day-2", CalendarCategory.DAYS, "火曜日", "かようび", "মঙ্গলবার", "কায়োওবি", "かようび", "🔥", "অগ্নি দিবস (Fire)"),
            CalendarItem("jp-day-3", CalendarCategory.DAYS, "水曜日", "すいようび", "বুধবার", "সুইয়োওবি", "すいようび", "💧", "জল দিবস (Water)"),
            CalendarItem("jp-day-4", CalendarCategory.DAYS, "木曜日", "もくようび", "বৃহস্পতিবার", "মকুয়োওবি", "もくようび", "🌳", "বৃক্ষ দিবস (Wood)"),
            CalendarItem("jp-day-5", CalendarCategory.DAYS, "金曜日", "きんようび", "শুক্রবার", "কিন্ইয়োওবি", "きんようび", "💰", "স্বর্ণ দিবস (Metal)"),
            CalendarItem("jp-day-6", CalendarCategory.DAYS, "土曜日", "どようび", "শনিবার", "দোয়োওবি", "どようび", "⛰️", "মাটি দিবস (Earth)"),
            CalendarItem("jp-day-7", CalendarCategory.DAYS, "日曜日", "にちようび", "রবিবার", "নিচিয়োওবি", "にちようび", "☀️", "সূর্য দিবস (Sun)"),

            // 12 Months
            CalendarItem("jp-mon-1", CalendarCategory.MONTHS, "1月", "いちがつ", "জানুয়ারি", "ইচিগাৎসু", "いちがつ", "❄️", "প্রথম মাস"),
            CalendarItem("jp-mon-2", CalendarCategory.MONTHS, "2月", "にがつ", "ফেব্রুয়ারি", "নিগাৎসু", "にがつ", "❄️", "দ্বিতীয় মাস"),
            CalendarItem("jp-mon-3", CalendarCategory.MONTHS, "3月", "さんがつ", "মার্চ", "সানগাৎসু", "さんがつ", "🌸", "তৃতীয় মাস"),
            CalendarItem("jp-mon-4", CalendarCategory.MONTHS, "4月", "しがつ", "এপ্রিল", "শিগাৎসু", "しがつ", "🌸", "চতুর্থ মাস (শিগাৎসু)"),
            CalendarItem("jp-mon-5", CalendarCategory.MONTHS, "5月", "ごがつ", "মে", "গোগাৎসু", "ごがつ", "🎏", "পঞ্চম মাস"),
            CalendarItem("jp-mon-6", CalendarCategory.MONTHS, "6月", "ろくがつ", "জুন", "রোকুগাৎসু", "ろくがつ", "☔", "ষষ্ঠ মাস"),
            CalendarItem("jp-mon-7", CalendarCategory.MONTHS, "7月", "しちがつ", "জুলাই", "শিচিগাৎসু", "しちがつ", "🎋", "সপ্তম মাস (শিচিগাৎসু)"),
            CalendarItem("jp-mon-8", CalendarCategory.MONTHS, "8月", "はちがつ", "আগস্ট", "হাচিগাৎসু", "はちがつ", "☀️", "অষ্টম মাস"),
            CalendarItem("jp-mon-9", CalendarCategory.MONTHS, "9月", "くがつ", "সেপ্টেম্বর", "কুগাৎসু", "くがつ", "🎑", "নবম মাস (কুগাৎসু)"),
            CalendarItem("jp-mon-10", CalendarCategory.MONTHS, "10月", "じゅうがつ", "অক্টোবর", "জুগাৎসু", "じゅうがつ", "🍁", "দশম মাস"),
            CalendarItem("jp-mon-11", CalendarCategory.MONTHS, "11月", "じゅういちがつ", "নভেম্বর", "জু-ইচিগাৎসু", "じゅういちがつ", "🍂", "একাদশ মাস"),
            CalendarItem("jp-mon-12", CalendarCategory.MONTHS, "12月", "じゅうにがつ", "ডিসেম্বর", "জু-নিগাৎসু", "じゅうにがつ", "🎄", "দ্বাদশ মাস"),

            // 4 Seasons
            CalendarItem("jp-sea-1", CalendarCategory.SEASONS, "春", "はる", "বসন্তকাল", "হারু", "はる", "🌸", "চেরি ব্লসম ও নতুন সূচনা"),
            CalendarItem("jp-sea-2", CalendarCategory.SEASONS, "夏", "なつ", "গ্রীষ্মকাল", "নাৎসু", "なつ", "🍉", "উৎসব ও রৌদ্রোজ্জ্বল দিন"),
            CalendarItem("jp-sea-3", CalendarCategory.SEASONS, "秋", "あき", "শরৎকাল", "আকি", "あき", "🍁", "লাল পাতা ও ফসল কাটার সময়"),
            CalendarItem("jp-sea-4", CalendarCategory.SEASONS, "冬", "ふゆ", "শীতকাল", "ফুয়ু", "ふゆ", "⛄", "তুষারপাত ও শীতল আবহাওয়া"),

            // Time & Day Words
            CalendarItem("jp-time-1", CalendarCategory.TIME, "今日", "きょう", "আজ", "কিয়োও", "きょう", "📅"),
            CalendarItem("jp-time-2", CalendarCategory.TIME, "明日", "あした", "আগামীকাল", "আশিতা", "あした", "⏩"),
            CalendarItem("jp-time-3", CalendarCategory.TIME, "昨日", "きのう", "গতকাল", "কিনোও", "きのう", "⏪"),
            CalendarItem("jp-time-4", CalendarCategory.TIME, "あさって", "あさって", "পরশু দিন", "আসাৎতে", "あさって", "⏭️"),
            CalendarItem("jp-time-5", CalendarCategory.TIME, "今", "いま", "এখন", "ইমা", "いま", "⏰"),
            CalendarItem("jp-time-6", CalendarCategory.TIME, "朝", "あさ", "সকাল", "আসা", "あさ", "🌅"),
            CalendarItem("jp-time-7", CalendarCategory.TIME, "昼", "ひる", "দুপুর", "হিরু", "ひる", "☀️"),
            CalendarItem("jp-time-8", CalendarCategory.TIME, "夕方", "ゆうがた", "বিকাল / সন্ধ্যা", "ইউউগাতা", "ゆうがた", "🌇"),
            CalendarItem("jp-time-9", CalendarCategory.TIME, "夜", "よる", "রাত", "য়োরু", "よる", "🌙"),
            CalendarItem("jp-time-10", CalendarCategory.TIME, "毎日", "まいにち", "প্রতিদিন", "মাইনিচি", "まいにち", "🔄"),
            CalendarItem("jp-time-11", CalendarCategory.TIME, "今週", "こんしゅう", "এই সপ্তাহ", "কোন্শিউ", "こんしゅう", "📆"),
            CalendarItem("jp-time-12", CalendarCategory.TIME, "来週", "らいしゅう", "আগামী সপ্তাহ", "রাইশিউ", "らいしゅう", "📅"),
            CalendarItem("jp-time-13", CalendarCategory.TIME, "先週", "せんしゅう", "গত সপ্তাহ", "সেন্শিউ", "せんしゅう", "📅"),
            CalendarItem("jp-time-14", CalendarCategory.TIME, "今月", "こんげつ", "এই মাস", "কোন্গেৎসু", "こんげつ", "🗓️"),
            CalendarItem("jp-time-15", CalendarCategory.TIME, "今年", "ことし", "এই বছর", "কোতোশি", "ことし", "🎆")
        )
    )
}

