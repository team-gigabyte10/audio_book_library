package com.gigabyte.bookstore.learning.presentation.calendar

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object ChineseCalendarData {

    val CONFIG = CalendarLanguageConfig(
        langCode = "chinese",
        speechLang = SpeechLang.ZH,
        titleBn = "চাইনিজ দিন, মাস ও ঋতু চার্ট",
        subtitleBn = "সপ্তাহের ৭ দিন (星期), ১২ মাস (月), ঋতু এবং সময় সংক্রান্ত প্রয়োজনীয় শব্দ",
        nativeTitle = "星期 · 月份 · 季节 (Xīngqī · Yuèfèn · Jìjié)",
        accentColorHex = 0xFFD32F2F,
        categories = listOf(
            CalendarCategoryInfo(CalendarCategory.ALL, "সব (৩৮টি)"),
            CalendarCategoryInfo(CalendarCategory.DAYS, "৭ দিন"),
            CalendarCategoryInfo(CalendarCategory.MONTHS, "১২ মাস"),
            CalendarCategoryInfo(CalendarCategory.SEASONS, "৪ ঋতু"),
            CalendarCategoryInfo(CalendarCategory.TIME, "সময় ও দিনকাল")
        ),
        items = listOf(
            // 7 Days
            CalendarItem("zh-day-1", CalendarCategory.DAYS, "星期一", "xīngqīyī", "সোমবার", "সিংছি-ই", "星期一", "📅", "সপ্তাহের ১ম দিন (সোমবার = ১)"),
            CalendarItem("zh-day-2", CalendarCategory.DAYS, "星期二", "xīngqī'èr", "মঙ্গলবার", "সিংছি-আর", "星期二", "📅", "সপ্তাহের ২য় দিন"),
            CalendarItem("zh-day-3", CalendarCategory.DAYS, "星期三", "xīngqīsān", "বুধবার", "সিংছি-সান্", "星期三", "📅", "সপ্তাহের ৩য় দিন"),
            CalendarItem("zh-day-4", CalendarCategory.DAYS, "星期四", "xīngqīsì", "বৃহস্পতিবার", "সিংছি-স্যু", "星期四", "📅", "সপ্তাহের ৪র্থ দিন"),
            CalendarItem("zh-day-5", CalendarCategory.DAYS, "星期五", "xīngqīwǔ", "শুক্রবার", "সিংছি-উ", "星期五", "🕌", "সপ্তাহের ৫ম দিন (জুমার দিন)"),
            CalendarItem("zh-day-6", CalendarCategory.DAYS, "星期六", "xīngqīliù", "শনিবার", "সিংছি-লিউ", "星期六", "📅", "সপ্তাহের ৬ষ্ঠ দিন"),
            CalendarItem("zh-day-7", CalendarCategory.DAYS, "星期天 / 星期日", "xīngqītiān", "রবিবার", "সিংছি-থিয়ান্", "星期天", "☀️", "সপ্তাহের শেষ দিন (ছয় নয়, 'থিয়ান/রি' বলে)"),

            // 12 Months
            CalendarItem("zh-mon-1", CalendarCategory.MONTHS, "一月", "yīyuè", "জানুয়ারি", "ই-ইয়ুয়ে", "一月", "❄️", "১ম মাস (১ + মাস)"),
            CalendarItem("zh-mon-2", CalendarCategory.MONTHS, "二月", "èryuè", "ফেব্রুয়ারি", "আর-ইয়ুয়ে", "二月", "❄️", "২য় মাস"),
            CalendarItem("zh-mon-3", CalendarCategory.MONTHS, "三月", "sānyuè", "মার্চ", "সান্-ইয়ুয়ে", "三月", "🌸", "৩য় মাস"),
            CalendarItem("zh-mon-4", CalendarCategory.MONTHS, "四月", "sìyuè", "এপ্রিল", "স্যু-ইয়ুয়ে", "四月", "🌸", "৪র্থ মাস"),
            CalendarItem("zh-mon-5", CalendarCategory.MONTHS, "五月", "wǔyuè", "মে", "উ-ইয়ুয়ে", "五月", "🌿", "৫ম মাস"),
            CalendarItem("zh-mon-6", CalendarCategory.MONTHS, "六月", "liùyuè", "জুন", "লিউ-ইয়ুয়ে", "六月", "☔", "৬ষ্ঠ মাস"),
            CalendarItem("zh-mon-7", CalendarCategory.MONTHS, "七月", "qīyuè", "জুলাই", "ছি-ইয়ুয়ে", "七月", "☀️", "৭ম মাস"),
            CalendarItem("zh-mon-8", CalendarCategory.MONTHS, "八月", "bāyuè", "আগস্ট", "পা-ইয়ুয়ে", "八月", "☀️", "৮ম মাস"),
            CalendarItem("zh-mon-9", CalendarCategory.MONTHS, "九月", "jiǔyuè", "সেপ্টেম্বর", "চিউ-ইয়ুয়ে", "九月", "🍂", "৯ম মাস"),
            CalendarItem("zh-mon-10", CalendarCategory.MONTHS, "十月", "shíyuè", "অক্টোবর", "শি-ইয়ুয়ে", "十月", "🍁", "১০ম মাস"),
            CalendarItem("zh-mon-11", CalendarCategory.MONTHS, "十一月", "shíyīyuè", "নভেম্বর", "শি-ই-ইয়ুয়ে", "十一月", "🍂", "১১শ মাস"),
            CalendarItem("zh-mon-12", CalendarCategory.MONTHS, "十二月", "shí'èryuè", "ডিসেম্বর", "শি-আর-ইয়ুয়ে", "十二月", "🎄", "১২শ মাস"),

            // 4 Seasons
            CalendarItem("zh-sea-1", CalendarCategory.SEASONS, "春天", "chūntiān", "বসন্তকাল", "ছুন্-থিয়ান্", "春天", "🌸"),
            CalendarItem("zh-sea-2", CalendarCategory.SEASONS, "夏天", "xiàtiān", "গ্রীষ্মকাল", "সিয়া-থিয়ান্", "夏天", "☀️"),
            CalendarItem("zh-sea-3", CalendarCategory.SEASONS, "秋天", "qiūtiān", "শরৎকাল", "ছিউ-থিয়ান্", "秋天", "🍁"),
            CalendarItem("zh-sea-4", CalendarCategory.SEASONS, "冬天", "dōngtiān", "শীতকাল", "তোং-থিয়ান্", "冬天", "❄️"),

            // Time & Everyday Expressions
            CalendarItem("zh-time-1", CalendarCategory.TIME, "今天", "jīntiān", "আজ", "চিন্-থিয়ান্", "今天", "📆"),
            CalendarItem("zh-time-2", CalendarCategory.TIME, "明天", "míngtiān", "আগামীকাল", "মিং-থিয়ান্", "明天", "⏭️"),
            CalendarItem("zh-time-3", CalendarCategory.TIME, "昨天", "zuótiān", "গতকাল", "জুও-থিয়ান্", "昨天", "⏮️"),
            CalendarItem("zh-time-4", CalendarCategory.TIME, "现在", "xiànzài", "এখন", "সিয়ান্-দ্জাই", "现在", "⏰"),
            CalendarItem("zh-time-5", CalendarCategory.TIME, "早上", "zǎoshang", "সকাল", "দ্জাও-শাং", "早上", "🌅"),
            CalendarItem("zh-time-6", CalendarCategory.TIME, "中午", "zhōngwǔ", "দুপুর", "চোং-উ", "中午", "☀️"),
            CalendarItem("zh-time-7", CalendarCategory.TIME, "下午", "xiàwǔ", "বিকেল", "সিয়া-উ", "下午", "🌇"),
            CalendarItem("zh-time-8", CalendarCategory.TIME, "晚上", "wǎnshang", "সন্ধ্যা / রাত", "ওয়ান্-শাং", "晚上", "🌙"),
            CalendarItem("zh-time-9", CalendarCategory.TIME, "年", "nián", "বছর", "নিয়ান্", "年", "🗓️"),
            CalendarItem("zh-time-10", CalendarCategory.TIME, "月", "yuè", "মাস", "ইয়ুয়ে", "月", "🌙"),
            CalendarItem("zh-time-11", CalendarCategory.TIME, "天 / 日", "tiān / rì", "দিন", "থিয়ান্", "天", "📆"),
            CalendarItem("zh-time-12", CalendarCategory.TIME, "星期", "xīngqī", "সপ্তাহ", "সিংছি", "星期", "📆"),
            CalendarItem("zh-time-13", CalendarCategory.TIME, "小时", "xiǎoshí", "ঘণ্টা", "সিয়াওশি", "小时", "⌛"),
            CalendarItem("zh-time-14", CalendarCategory.TIME, "分钟", "fēnzhōng", "মিনিট", "ফেন্-চোং", "分钟", "⏱️"),
            CalendarItem("zh-time-15", CalendarCategory.TIME, "几点了？", "jǐ diǎn le?", "কয়টা বাজে?", "চি তিয়ান্ ল্য?", "几点了？", "🕰️")
        )
    )
}

