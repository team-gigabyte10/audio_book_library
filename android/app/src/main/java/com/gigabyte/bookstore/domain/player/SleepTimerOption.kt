package com.gigabyte.bookstore.domain.player

enum class SleepTimerOption(val titleBn: String, val minutes: Int?) {
    OFF("বন্ধ", null),
    MIN_15("১৫ মিনিট", 15),
    MIN_30("৩০ মিনিট", 30),
    MIN_45("৪৫ মিনিট", 45),
    MIN_60("৬০ মিনিট", 60),
    END_OF_CHAPTER("অধ্যায় শেষে", -1)
}
