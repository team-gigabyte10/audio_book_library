package com.gigabyte.bookstore.learning.presentation.alphabet

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object KoreanAlphabetData {

    val CONFIG = LanguageAlphabetConfig(
        langCode = "korean",
        speechLang = SpeechLang.KO,
        titleBn = "কোরিয়ান হাঙ্গুল (한글) বর্ণমালা ও বাচ্ছিম চার্ট",
        subtitleBn = "১৪টি মৌলিক ব্যঞ্জন, ৫টি যুগ্ম ব্যঞ্জন, ২১টি স্বরবর্ণ ও বাচ্ছিম (받침) নিয়ম",
        accentColorHex = 0xFF0047A0,
        categories = listOf(
            AlphabetCategory("all", "সবগুলো", "৪৭টি"),
            AlphabetCategory("consonant", "মৌলিক ব্যঞ্জন", "১৪টি"),
            AlphabetCategory("double", "যুগ্ম ব্যঞ্জন", "৫টি"),
            AlphabetCategory("vowel", "মৌলিক স্বরবর্ণ", "১০টি"),
            AlphabetCategory("compound", "যৌগিক স্বরবর্ণ", "১১টি"),
            AlphabetCategory("batchim", "বাচ্ছিম (받침)", "৭টি")
        ),
        rows = listOf(
            AlphabetRow(
                id = "ko_consonants",
                titleBn = "১৪টি মৌলিক ব্যঞ্জনবর্ণ (기본 자음)",
                subtitleTarget = "ㄱ ㄴ ㄷ ㄹ ㅁ ㅂ ㅅ ㅇ ㅈ ㅊ ㅋ ㅌ ㅍ ㅎ",
                categoryId = "consonant",
                letters = listOf(
                    AlphabetLetter("ko_g", "ㄱ", "Giyeok (গ/ক)", "가", "গা / কা", "consonant", "가", "가다", "gada", "যাওয়া", "শব্দের শুরুতে হালকা ক-গ এর মাঝে, স্বরবর্ণের মাঝে পরিষ্কার গ।"),
                    AlphabetLetter("ko_n", "ㄴ", "Nieun (ন)", "나", "না", "consonant", "나", "나라", "nara", "দেশ", "বাংলার 'ন'-এর মতো।"),
                    AlphabetLetter("ko_d", "ㄷ", "Digeut (দ/ত)", "다", "দা / তা", "consonant", "다", "다리", "dari", "পা / সেতু", "শুরুতে হালকা ত-দ, মাঝে পরিষ্কার দ।"),
                    AlphabetLetter("ko_r", "ㄹ", "Rieul (র/ল)", "라", "রা / লা", "consonant", "라", "라면", "ramyeon", "নুডলস", "স্বরবর্ণের মাঝে র, শব্দ শেষে বাচ্ছিম হিসেবে ল।"),
                    AlphabetLetter("ko_m", "ㅁ", "Mieum (ম)", "마", "মা", "consonant", "마", "마음", "maeum", "মন", "বাংলার 'ম'-এর মতো।"),
                    AlphabetLetter("ko_b", "ㅂ", "Bieup (ব/প)", "바", "বা / পা", "consonant", "바", "바다", "bada", "সমুদ্র", "শুরুতে হালকা প-ব, মাঝে পরিষ্কার ব।"),
                    AlphabetLetter("ko_s", "ㅅ", "Siot (স/শ)", "사", "সা / শা", "consonant", "사", "사람", "saram", "মানুষ", "ই/ইয়া-এর আগে 'শ', অন্যত্র হালকা 'স'।"),
                    AlphabetLetter("ko_ng", "ㅇ", "Ieung (নীরব / ং)", "아", "আ / -ং", "consonant", "아", "아이", "ai", "শিশু", "শুরুতে নীরব থাকে, নিচে বাচ্ছিম হলে 'ং' (ng) হয়।"),
                    AlphabetLetter("ko_j", "ㅈ", "Jieut (জ/চ)", "자", "জা / চা", "consonant", "자", "자다", "jada", "ঘুমানো", "শুরুতে হালকা চ-জ, মাঝে পরিষ্কার জ।"),
                    AlphabetLetter("ko_ch", "ㅊ", "Chieut (ছ)", "차", "ছা", "consonant", "차", "차", "cha", "চা / গাড়ি", "বাতাস বের করে স্পষ্ট মহাপ্রাণ 'ছ'।"),
                    AlphabetLetter("ko_k", "ㅋ", "Kieuk (খ)", "카", "খা", "consonant", "카", "카드", "kadeu", "কার্ড", "বাতাস বের করে মহাপ্রাণ 'খ'।"),
                    AlphabetLetter("ko_t", "ㅌ", "Tieut (থ)", "타", "থা", "consonant", "타", "타다", "tada", "চড়া / পোড়া", "বাতাস বের করে মহাপ্রাণ 'থ'।"),
                    AlphabetLetter("ko_p", "ㅍ", "Pieup (ফ)", "파", "ফা", "consonant", "파", "파란색", "paransaek", "নীল রঙ", "দুই ঠোঁট থেকে বাতাস বের করে 'ফ/প্‌হ'।"),
                    AlphabetLetter("ko_h", "ㅎ", "Hieut (হ)", "하", "হা", "consonant", "하", "하늘", "haneul", "আকাশ", "বাংলার 'হ'-এর মতো।")
                )
            ),
            AlphabetRow(
                id = "ko_double",
                titleBn = "৫টি যুগ্ম / শক্ত ব্যঞ্জনবর্ণ (쌍자음)",
                subtitleTarget = "ㄲ ㄸ ㅃ ㅆ ㅉ",
                categoryId = "double",
                letters = listOf(
                    AlphabetLetter("ko_kk", "ㄲ", "Ssang-giyeok", "까", "ক্কা", "double", "까", "까만색", "kkamansaek", "কালো রঙ", "বাতাস ছাড়া শক্ত করে 'ক্ক'।"),
                    AlphabetLetter("ko_tt", "ㄸ", "Ssang-digeut", "따", "ত্তা", "double", "따", "따뜻하다", "ttatteuthada", "উষ্ণ হওয়া", "বাতাস ছাড়া শক্ত করে 'ত্ত'।"),
                    AlphabetLetter("ko_pp", "ㅃ", "Ssang-bieup", "빠", "প্পা", "double", "빠", "빠르다", "ppareuda", "দ্রুত হওয়া", "বাতাস ছাড়া শক্ত করে 'প্প'।"),
                    AlphabetLetter("ko_ss", "ㅆ", "Ssang-siot", "싸", "স্সা", "double", "싸", "싸다", "ssada", "সস্তা হওয়া", "জোর দিয়ে 'স্স'।"),
                    AlphabetLetter("ko_jj", "ㅉ", "Ssang-jieut", "짜", "চ্চা", "double", "짜", "짜다", "jjada", "নোনতা হওয়া", "বাতাস ছাড়া শক্ত করে 'চ্চ'।")
                )
            ),
            AlphabetRow(
                id = "ko_vowels",
                titleBn = "১০টি মৌলিক স্বরবর্ণ (기본 모음)",
                subtitleTarget = "ㅏ ㅑ ㅓ ㅕ ㅗ ㅛ ㅜ ㅠ ㅡ ㅣ",
                categoryId = "vowel",
                letters = listOf(
                    AlphabetLetter("ko_a", "ㅏ", "a (আ)", "아", "আ", "vowel", "아", "아침", "achim", "সকাল", "মুখ খুলে পরিষ্কার 'আ'।"),
                    AlphabetLetter("ko_ya", "ㅑ", "ya (ইয়া)", "야", "ইয়া", "vowel", "야", "야구", "yagu", "বেসবল", "দ্রুত 'ইয়া'।"),
                    AlphabetLetter("ko_eo", "ㅓ", "eo (অ)", "어", "অ", "vowel", "어", "어머니", "eomeoni", "মা", "মুখ গোল না করে ভেতর থেকে 'অ'।"),
                    AlphabetLetter("ko_yeo", "ㅕ", "yeo (ইয়)", "여", "ইয়", "vowel", "여", "여름", "yeoreum", "গ্রীষ্ম", "ই + অ একসাথে 'ইয়'।"),
                    AlphabetLetter("ko_o", "ㅗ", "o (ও)", "오", "ও", "vowel", "오", "오늘", "oneul", "আজ", "ঠোঁট গোল করে পরিষ্কার 'ও'।"),
                    AlphabetLetter("ko_yo", "ㅛ", "yo (ইয়ো)", "요", "ইয়ো", "vowel", "요", "요리", "yori", "রান্না", "ই + ও = 'ইয়ো'।"),
                    AlphabetLetter("ko_u", "ㅜ", "u (উ)", "우", "উ", "vowel", "우", "우유", "uyu", "দুধ", "ঠোঁট গোল করে 'উ'।"),
                    AlphabetLetter("ko_yu", "ㅠ", "yu (ইয়ু)", "유", "ইয়ু", "vowel", "유", "유리", "yuri", "কাঁচ", "ই + উ = 'ইয়ু'।"),
                    AlphabetLetter("ko_eu", "ㅡ", "eu (উ-ই মিশ্র)", "으", "উ (চ্যাপ্টা ঠোঁট)", "vowel", "으", "으뜸", "eutteum", "সেরা", "ঠোঁট গোল না করে হাসির ভঙ্গিতে 'উ'।"),
                    AlphabetLetter("ko_i", "ㅣ", "i (ই)", "이", "ই", "vowel", "이", "이름", "ireum", "নাম", "পরিষ্কার 'ই'।")
                )
            ),
            AlphabetRow(
                id = "ko_compound",
                titleBn = "১১টি যৌগিক স্বরবর্ণ (이중 모음)",
                subtitleTarget = "ㅐ ㅒ ㅔ ㅖ ㅘ ㅙ ㅚ ㅝ ㅞ ㅟ ㅢ",
                categoryId = "compound",
                letters = listOf(
                    AlphabetLetter("ko_ae", "ㅐ", "ae (অ্যা/এ)", "애", "অ্যা / এ", "compound", "애", "개", "gae", "কুকুর", "আধুনিক সিউল উচ্চারণে এ-র কাছাকাছি।"),
                    AlphabetLetter("ko_yae", "ㅒ", "yae (ইয়ে)", "얘", "ইয়ে", "compound", "얘", "얘기", "yaegi", "গল্প/কথা", "ই + অ্যা।"),
                    AlphabetLetter("ko_e", "ㅔ", "e (এ)", "에", "এ", "compound", "에", "네", "ne", "হ্যাঁ", "বাংলার 'এ'-এর মতো।"),
                    AlphabetLetter("ko_ye", "ㅖ", "ye (ইয়ে)", "예", "ইয়ে", "compound", "예", "예쁘다", "yeppeuda", "সুন্দর", "ই + এ = 'ইয়ে'।"),
                    AlphabetLetter("ko_wa", "ㅘ", "wa (ওয়া)", "와", "ওয়া", "compound", "와", "과일", "gwail", "ফল", "ㅗ + ㅏ একসাথে 'ওয়া'।"),
                    AlphabetLetter("ko_wae", "ㅙ", "wae (ওয়ে)", "왜", "ওয়ে", "compound", "왜", "왜", "wae", "কেন", "ㅗ + ㅐ একসাথে 'ওয়ে'।"),
                    AlphabetLetter("ko_oe", "ㅚ", "oe (ওয়ে)", "외", "ওয়ে", "compound", "외", "외국", "oeguk", "বিদেশ", "ㅗ + ㅣ আধুনিক উচ্চারণে 'ওয়ে'।"),
                    AlphabetLetter("ko_wo", "ㅝ", "wo (উও)", "워", "উও / ওয়া", "compound", "워", "추워요", "chuwoyo", "ঠান্ডা লাগছে", "ㅜ + ㅓ একসাথে 'উও'।"),
                    AlphabetLetter("ko_we", "ㅞ", "we (উয়ে)", "웨", "উয়ে", "compound", "웨", "웨딩", "weding", "বিয়ে", "ㅜ + ㅔ একসাথে 'উয়ে'।"),
                    AlphabetLetter("ko_wi", "ㅟ", "wi (উই)", "위", "উই", "compound", "위", "위", "wi", "উপর", "ㅜ + ㅣ একসাথে 'উই'।"),
                    AlphabetLetter("ko_ui", "ㅢ", "ui (উই/এ)", "의", "উই / এ", "compound", "의", "의사", "uisa", "ডাক্তার", "শব্দ শুরুতে 'উই', মাঝে 'ই', সম্বন্ধপদে 'এ'।")
                )
            ),
            AlphabetRow(
                id = "ko_batchim",
                titleBn = "৭টি বাচ্ছিম প্রতিনিধিত্বমূলক ধ্বনি (받침 ৭ 대표음)",
                subtitleTarget = "ㄱ · ㄴ · ㄷ · ㄹ · ㅁ · ㅂ · ㅇ",
                categoryId = "batchim",
                letters = listOf(
                    AlphabetLetter("ko_bat_k", "ㄱ/ㅋ/ㄲ", "অক্ষরশেষে -ক (k)", "악", "-ক", "batchim", "악", "부엌", "bueok", "রান্নাঘর", "নিচে থাকলে ㄱ, ㅋ, ㄲ সবগুলো অসম্পূর্ণ 'ক' হয়।"),
                    AlphabetLetter("ko_bat_n", "ㄴ", "অক্ষরশেষে -ন (n)", "안", "-ন", "batchim", "안", "한국", "hanguk", "কোরিয়া", "নিচে থাকলে 'ন' হয়।"),
                    AlphabetLetter("ko_bat_t", "ㄷ/ㅅ/ㅈ/ㅊ/ㅌ/ㅎ", "অক্ষরশেষে -ত (t)", "앋", "-ত", "batchim", "앋", "꽃", "kkot", "ফুল", "নিচে ㄷ, ㅅ, ㅆ, ㅈ, ㅊ, ㅌ, ㅎ থাকলে অসম্পূর্ণ 'ত' হয়।"),
                    AlphabetLetter("ko_bat_l", "ㄹ", "অক্ষরশেষে -ল (l)", "알", "-ল", "batchim", "알", "물", "mul", "পানি", "নিচে ㄹ থাকলে স্পষ্ট 'ল' হয়।"),
                    AlphabetLetter("ko_bat_m", "ㅁ", "অক্ষরশেষে -ম (m)", "암", "-ম", "batchim", "암", "이름", "ireum", "নাম", "নিচে থাকলে 'ম' হয়।"),
                    AlphabetLetter("ko_bat_p", "ㅂ/ㅍ", "অক্ষরশেষে -প (p)", "압", "-প", "batchim", "압", "집", "jip", "বাড়ি", "নিচে ㅂ, ㅍ থাকলে ঠোঁট বন্ধ হয়ে অসম্পূর্ণ 'প' হয়।"),
                    AlphabetLetter("ko_bat_ng", "ㅇ", "অক্ষরশেষে -ং (ng)", "앙", "-ং", "batchim", "앙", "방", "bang", "রুম", "নিচে ㅇ থাকলে বাংলা 'ং' ধ্বনি হয়।")
                )
            )
        )
    )
}
