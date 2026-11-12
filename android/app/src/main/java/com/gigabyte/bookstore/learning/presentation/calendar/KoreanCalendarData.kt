package com.gigabyte.bookstore.learning.presentation.calendar

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object KoreanCalendarData {

    val CONFIG = CalendarLanguageConfig(
        langCode = "korean",
        speechLang = SpeechLang.KO,
        titleBn = "কোরিয়ান দিন, মাস, ঋতু ও ছুটির দিন চার্ট",
        subtitleBn = "৭ দিন (월–일), ১২ মাস (1월–12월), ৪ ঋতু ও দৈনন্দিন সময়",
        nativeTitle = "요일 · 월 · 계절",
        accentColorHex = 0xFF0047A0,
        categories = listOf(
            CalendarCategoryInfo(CalendarCategory.ALL, "সব (৩১টি)"),
            CalendarCategoryInfo(CalendarCategory.DAYS, "৭ দিন"),
            CalendarCategoryInfo(CalendarCategory.MONTHS, "১২ মাস"),
            CalendarCategoryInfo(CalendarCategory.SEASONS, "৪ ঋতু"),
            CalendarCategoryInfo(CalendarCategory.TIME, "সময় ও ছুটি")
        ),
        items = listOf(
            // 7 Days
            CalendarItem("ko-day-1", CalendarCategory.DAYS, "월요일", "woryoil", "সোমবার", "ওরিয়োইল", "월", "📅", "সপ্তাহের ১ম কর্মদিবস (চাঁদের বার)"),
            CalendarItem("ko-day-2", CalendarCategory.DAYS, "화요일", "hwayoil", "মঙ্গলবার", "হোয়াইয়োইল", "화", "🔥", "আগুনের বার"),
            CalendarItem("ko-day-3", CalendarCategory.DAYS, "수요일", "suyoil", "বুধবার", "সুইয়োইল", "수", "💧", "পানির বার"),
            CalendarItem("ko-day-4", CalendarCategory.DAYS, "목요일", "mogyoil", "বৃহস্পতিবার", "মগিয়োইল", "목", "🌳", "গাছের বার"),
            CalendarItem("ko-day-5", CalendarCategory.DAYS, "금요일", "geumyoil", "শুক্রবার", "গুমইয়োইল", "금", "🪙", "সপ্তাহের শেষ কর্মদিবস (불금)"),
            CalendarItem("ko-day-6", CalendarCategory.DAYS, "토요일", "toyoil", "শনিবার", "থোইয়োইল", "토", "🛋️", "সাপ্তাহিক ছুটি (주말)"),
            CalendarItem("ko-day-7", CalendarCategory.DAYS, "일요일", "iryoil", "রবিবার", "ইরিয়োইল", "일", "☀️", "সাপ্তাহিক ছুটি (সূর্যের বার)"),

            // 12 Months
            CalendarItem("ko-mon-1", CalendarCategory.MONTHS, "일월", "irwol", "জানুয়ারি", "ইরওয়ল", "1월", "❄️", "১ম মাস"),
            CalendarItem("ko-mon-2", CalendarCategory.MONTHS, "이월", "iwol", "ফেব্রুয়ারি", "ইওয়ল", "2월", "❄️", "২য় মাস"),
            CalendarItem("ko-mon-3", CalendarCategory.MONTHS, "삼월", "samwol", "মার্চ", "সামওয়ল", "3월", "🌸", "৩য় মাস (বসন্তের শুরু)"),
            CalendarItem("ko-mon-4", CalendarCategory.MONTHS, "사월", "sawol", "এপ্রিল", "সাওয়ল", "4월", "🌸", "৪র্থ মাস (চেরি ব্লসম)"),
            CalendarItem("ko-mon-5", CalendarCategory.MONTHS, "오월", "owol", "মে", "ওওয়ল", "5월", "🌿", "৫ম মাস (পারিবারিক মাস)"),
            CalendarItem("ko-mon-6", CalendarCategory.MONTHS, "유월", "yuwol", "জুন", "ইউওয়ল", "6월", "☀️", "৬ষ্ঠ মাস (육 নয় 유 বলা হয়)"),
            CalendarItem("ko-mon-7", CalendarCategory.MONTHS, "칠월", "chirwol", "জুলাই", "ছিরওয়ল", "7월", "☀️", "৭ম মাস (বর্ষা ও গরম)"),
            CalendarItem("ko-mon-8", CalendarCategory.MONTHS, "팔월", "parwol", "আগস্ট", "ফারওয়ল", "8월", "☀️", "৮ম মাস"),
            CalendarItem("ko-mon-9", CalendarCategory.MONTHS, "구월", "guwol", "সেপ্টেম্বর", "গুওয়ল", "9월", "🍁", "৯ম মাস (শরত শুরু)"),
            CalendarItem("ko-mon-10", CalendarCategory.MONTHS, "시월", "siwol", "অক্টোবর", "শিওয়ল", "10월", "🍁", "১০ম মাস (십 নয় 시 বলা হয়)"),
            CalendarItem("ko-mon-11", CalendarCategory.MONTHS, "십일월", "sibirwol", "নভেম্বর", "শিবিরওয়ল", "11월", "🍂", "১১তম মাস"),
            CalendarItem("ko-mon-12", CalendarCategory.MONTHS, "십이월", "sibiwol", "ডিসেম্বর", "শিবিওয়ল", "12월", "❄️", "১২তম মাস"),

            // 4 Seasons
            CalendarItem("ko-sea-1", CalendarCategory.SEASONS, "봄", "bom", "বসন্তকাল", "বোম", "🌸", "🌸", "মার্চ–মে: চেরি ব্লসমের সুন্দর সময়"),
            CalendarItem("ko-sea-2", CalendarCategory.SEASONS, "여름", "yeoreum", "গ্রীষ্মকাল", "ইয়রুম", "☀️", "☀️", "জুন–আগস্ট: গরম ও বর্ষা"),
            CalendarItem("ko-sea-3", CalendarCategory.SEASONS, "가을", "gaeul", "শরৎকাল", "গাউল", "🍁", "🍁", "সেপ্টেম্বর–নভেম্বর: লাল-হলুদ পাতা"),
            CalendarItem("ko-sea-4", CalendarCategory.SEASONS, "겨울", "gyeoul", "শীতকাল", "গিয়উল", "❄️", "❄️", "ডিসেম্বর–ফেব্রুয়ারি: তুষারপাত"),

            // Relative Time & Korean Holidays
            CalendarItem("ko-time-1", CalendarCategory.TIME, "오늘", "oneul", "আজ", "ওনুল", "今日", "📍", "আজকের দিন"),
            CalendarItem("ko-time-2", CalendarCategory.TIME, "내일", "naeil", "আগামীকাল", "নেইল", "明日", "➡️", "আগামীকাল"),
            CalendarItem("ko-time-3", CalendarCategory.TIME, "어제", "eoje", "গতকাল", "অজে", "昨日", "⬅️", "গতকাল"),
            CalendarItem("ko-time-4", CalendarCategory.TIME, "모레", "more", "পরশু (আগামী)", "মোরে", "+2", "⏩", "আগামী পরশু"),
            CalendarItem("ko-time-5", CalendarCategory.TIME, "주말", "jumal", "সাপ্তাহিক ছুটি", "জুমাল", "토·일", "🎉", "শনি ও রবিবার"),
            CalendarItem("ko-time-6", CalendarCategory.TIME, "평일", "pyeongil", "কর্মদিবস", "ফিয়ংইল", "월–금", "💼", "সোম থেকে শুক্রবার"),
            CalendarItem("ko-time-7", CalendarCategory.TIME, "설날", "seollal", "কোরিয়ান নববর্ষ", "সল্লাল", "음력1.1", "🧧", "চান্দ্র নববর্ষের বড় ছুটি"),
            CalendarItem("ko-time-8", CalendarCategory.TIME, "추석", "chuseok", "নবান্ন উৎসব (ছুসক)", "ছুসক", "음력8.15", "🌕", "কোরিয়ার সবচেয়ে বড় ফসলি ছুটি")
        )
    )
}

