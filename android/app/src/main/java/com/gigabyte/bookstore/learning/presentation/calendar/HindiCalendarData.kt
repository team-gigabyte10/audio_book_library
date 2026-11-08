package com.gigabyte.bookstore.learning.presentation.calendar

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object HindiCalendarData {

    val CONFIG = CalendarLanguageConfig(
        langCode = "hindi",
        speechLang = SpeechLang.HI,
        titleBn = "হিন্দি দিন, মাস ও ঋতু চার্ট",
        subtitleBn = "সপ্তাহের ৭ দিন, ১২ মাস, ঋতু এবং সময় সংক্রান্ত প্রয়োজনীয় শব্দমালা",
        nativeTitle = "दिन, महीने और ऋतुएँ (Din, Mahine aur Rituon)",
        accentColorHex = 0xFFE65100,
        categories = listOf(
            CalendarCategoryInfo(CalendarCategory.ALL, "সব (৩৯টি)"),
            CalendarCategoryInfo(CalendarCategory.DAYS, "৭ দিন"),
            CalendarCategoryInfo(CalendarCategory.MONTHS, "১২ মাস"),
            CalendarCategoryInfo(CalendarCategory.SEASONS, "৬ ঋতু"),
            CalendarCategoryInfo(CalendarCategory.TIME, "সময় ও দিনকাল")
        ),
        items = listOf(
            // 7 Days
            CalendarItem("hi-day-1", CalendarCategory.DAYS, "सोमवार", "Somvaar", "সোমবার", "সোমবার", "सोमवार", "🗓️"),
            CalendarItem("hi-day-2", CalendarCategory.DAYS, "मंगलवार", "Mangalvaar", "মঙ্গলবার", "মঙ্গলবার", "मंगलवार", "🗓️"),
            CalendarItem("hi-day-3", CalendarCategory.DAYS, "बुधवार", "Budhvaar", "বুধবার", "বুধবার", "बुधवार", "🗓️"),
            CalendarItem("hi-day-4", CalendarCategory.DAYS, "गुरुवार", "Guruvaar", "বৃহস্পতিবার", "বৃহস্পতিবার / গুরুবার", "गुरुवार", "🗓️"),
            CalendarItem("hi-day-5", CalendarCategory.DAYS, "शुक्रवार", "Shukravaar", "শুক্রবার", "শুক্রবার", "शुक्रवार", "🗓️"),
            CalendarItem("hi-day-6", CalendarCategory.DAYS, "शनिवार", "Shanivaar", "শনিবার", "শনিবার", "शनिवार", "🗓️"),
            CalendarItem("hi-day-7", CalendarCategory.DAYS, "रविवार", "Ravivaar", "রবিবার", "রবিবার", "रविवार", "☀️"),

            // 12 Months
            CalendarItem("hi-mon-1", CalendarCategory.MONTHS, "जनवरी", "January", "জানুয়ারি", "জানুয়ারি", "जनवरी", "❄️"),
            CalendarItem("hi-mon-2", CalendarCategory.MONTHS, "फ़रवरी", "February", "ফেব্রুয়ারি", "ফেব্রুয়ারি", "फ़रवरी", "❄️"),
            CalendarItem("hi-mon-3", CalendarCategory.MONTHS, "मार्च", "March", "মার্চ", "মার্চ", "मार्च", "🌸"),
            CalendarItem("hi-mon-4", CalendarCategory.MONTHS, "अप्रैल", "April", "এপ্রিল", "এপ্রিল", "अप्रैल", "🌸"),
            CalendarItem("hi-mon-5", CalendarCategory.MONTHS, "मई", "May", "মে", "মে", "मई", "☀️"),
            CalendarItem("hi-mon-6", CalendarCategory.MONTHS, "जून", "June", "জুন", "জুন", "जून", "☀️"),
            CalendarItem("hi-mon-7", CalendarCategory.MONTHS, "जुलाई", "July", "জুলাই", "জুলাই", "जुलाई", "☔"),
            CalendarItem("hi-mon-8", CalendarCategory.MONTHS, "अगस्त", "August", "আগস্ট", "আগস্ট", "अगस्त", "☔"),
            CalendarItem("hi-mon-9", CalendarCategory.MONTHS, "सितम्बर", "September", "সেপ্টেম্বর", "সেপ্টেম্বর", "सितम्बर", "🍂"),
            CalendarItem("hi-mon-10", CalendarCategory.MONTHS, "अक्टूबर", "October", "অক্টোবর", "অক্টোবর", "अक्टूबर", "🍂"),
            CalendarItem("hi-mon-11", CalendarCategory.MONTHS, "नवम्बर", "November", "নভেম্বর", "নভেম্বর", "नवम्बर", "❄️"),
            CalendarItem("hi-mon-12", CalendarCategory.MONTHS, "दिसम्बर", "December", "ডিসেম্বর", "ডিসেম্বর", "दिसम्बर", "❄️"),

            // 6 Seasons
            CalendarItem("hi-sea-1", CalendarCategory.SEASONS, "वसंत ऋतु", "Vasant Ritu", "বসন্তকাল", "বসন্ত ঋতু", "वसंत ऋतु", "🌸", "ফুলের ঋতু"),
            CalendarItem("hi-sea-2", CalendarCategory.SEASONS, "ग्रीष्म ऋतु", "Greeshm Ritu", "গ্রীষ্মকাল", "গ্রীষ্ম ঋতু", "ग्रीष्म ऋतु", "☀️", "গরমের ঋতু"),
            CalendarItem("hi-sea-3", CalendarCategory.SEASONS, "वर्षा ऋतु", "Varsha Ritu", "বর্ষাকাল", "বর্ষা ঋতু", "वर्षा ऋतु", "🌧️", "বৃষ্টির ঋতু"),
            CalendarItem("hi-sea-4", CalendarCategory.SEASONS, "शरद ऋतु", "Sharad Ritu", "শরৎকাল", "শরদ ঋতু", "शरद ऋतु", "🌾", "নির্মল আকাশের ঋতু"),
            CalendarItem("hi-sea-5", CalendarCategory.SEASONS, "हेमंत ऋतु", "Hemant Ritu", "হেমন্তকাল", "হেমন্ত ঋতু", "हेमंत ऋतु", "🍁", "হিমেল বাতাসের ঋতু"),
            CalendarItem("hi-sea-6", CalendarCategory.SEASONS, "शीत ऋतु", "Sheet Ritu", "শীতকাল", "শীত ঋতু", "शीत ऋतु", "⛄", "ঠাণ্ডার ঋতু"),

            // Time & Days
            CalendarItem("hi-time-1", CalendarCategory.TIME, "आज", "Aaj", "আজ", "আজ", "आज", "📅"),
            CalendarItem("hi-time-2", CalendarCategory.TIME, "कल", "Kal (Aane wala)", "আগামীকাল", "কাল (আগামী)", "कल", "⏩"),
            CalendarItem("hi-time-3", CalendarCategory.TIME, "बीता हुआ कल", "Kal (Beeta hua)", "গতকাল", "বিতা হুয়া কাল (গত)", "बीता हुआ कल", "⏪"),
            CalendarItem("hi-time-4", CalendarCategory.TIME, "परसों", "Parson", "পরশু দিন", "পরসোঁ", "परसों", "⏭️"),
            CalendarItem("hi-time-5", CalendarCategory.TIME, "अब", "Ab", "এখন", "আব", "अब", "⏰"),
            CalendarItem("hi-time-6", CalendarCategory.TIME, "सुबह", "Subah", "সকাল", "সুবহ", "सुबह", "🌅"),
            CalendarItem("hi-time-7", CalendarCategory.TIME, "दोपहर", "Dopahar", "দুপুর", "দোপাহের", "दोपहर", "☀️"),
            CalendarItem("hi-time-8", CalendarCategory.TIME, "शाम", "Shaam", "সন্ধ্যা", "শাম", "शाम", "🌇"),
            CalendarItem("hi-time-9", CalendarCategory.TIME, "रात", "Raat", "রাত", "রাত", "रात", "🌙"),
            CalendarItem("hi-time-10", CalendarCategory.TIME, "प्रतिदिन", "Pratidin", "প্রতিদিন", "প্রতিদিন / রোজ", "प्रतिदिन", "🔄"),
            CalendarItem("hi-time-11", CalendarCategory.TIME, "इस सप्ताह", "Is saptaah", "এই সপ্তাহে", "ইস সপ্তাহ", "इस सप्ताह", "📆"),
            CalendarItem("hi-time-12", CalendarCategory.TIME, "अगले सप्ताह", "Agle saptaah", "আগামী সপ্তাহে", "আগলে সপ্তাহ", "अगले सप्ताह", "📅"),
            CalendarItem("hi-time-13", CalendarCategory.TIME, "पिछले सप्ताह", "Pichhle saptaah", "গত সপ্তাহে", "পিছলে সপ্তাহ", "पिछले सप्ताह", "📅"),
            CalendarItem("hi-time-14", CalendarCategory.TIME, "महीना", "Mahina", "মাস", "মাহীনা", "महीना", "🗓️"),
            CalendarItem("hi-time-15", CalendarCategory.TIME, "साल", "Saal", "বছর", "সাল / বর্ষ", "साल", "🎆")
        )
    )
}

