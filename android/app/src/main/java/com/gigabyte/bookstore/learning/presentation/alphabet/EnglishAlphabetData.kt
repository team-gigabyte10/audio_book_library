package com.gigabyte.bookstore.learning.presentation.alphabet

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object EnglishAlphabetData {

    val CONFIG = LanguageAlphabetConfig(
        langCode = "english",
        speechLang = SpeechLang.EN,
        titleBn = "ইংরেজি বর্ণমালা ও ফোনেটিক্স চার্ট",
        subtitleBn = "২৬টি বর্ণ ও প্রয়োজনীয় ফোনেটিক ব্লেন্ডস · ট্যাপ করলেই অডিও",
        accentColorHex = 0xFF1565C0,
        categories = listOf(
            AlphabetCategory("all", "সব ধ্বনি", "৩৪টি"),
            AlphabetCategory("vowels", "স্বরবর্ণ (Vowels)", "৫টি"),
            AlphabetCategory("consonants", "ব্যঞ্জনবর্ণ (Consonants)", "২১টি"),
            AlphabetCategory("digraphs", "যুক্তধ্বনি (Digraphs)", "৮টি")
        ),
        rows = listOf(
            AlphabetRow(
                id = "vowels",
                titleBn = "স্বরবর্ণ (Vowels - ৫টি)",
                subtitleTarget = "A · E · I · O · U",
                categoryId = "vowels",
                letters = listOf(
                    AlphabetLetter("en_a", "Aa", "A", "ei / æ", "এই / অ্যা", "vowels", "A", "Apple", "æp.əl", "আপেল", "হ্রস্ব ও উন্মুক্ত 'অ্যা' অথবা দীর্ঘ 'এই' ধ্বনি।"),
                    AlphabetLetter("en_e", "Ee", "E", "iː / e", "ঈ / এ", "vowels", "E", "Elephant", "el.ɪ.fənt", "হাতি", "ইংরেজি শব্দের শুরুতে নরম 'এ' বা দ্বিত্ব হলে দীর্ঘ 'ঈ'।"),
                    AlphabetLetter("en_i", "Ii", "I", "aɪ / ɪ", "আই / ই", "vowels", "I", "Ice", "aɪs", "বরফ", "স্পষ্ট 'আই' অথবা শব্দের মাঝে ছোট 'ই'।"),
                    AlphabetLetter("en_o", "Oo", "O", "oʊ / ɒ", "ওউ / অ", "vowels", "O", "Orange", "ɒr.ɪndʒ", "কমলালেবু", "মুখ সামান্য গোলাকার করে 'ওউ' বা 'অ' ধ্বনি।"),
                    AlphabetLetter("en_u", "Uu", "U", "juː / ʌ", "ইউ / আ", "vowels", "U", "Umbrella", "ʌmˈbrel.ə", "ছাতা", "শব্দের শুরুতে 'আ' (যেমন Umbrella) অথবা 'ইউ' (University)।")
                )
            ),
            AlphabetRow(
                id = "consonants_1",
                titleBn = "ব্যঞ্জনবর্ণ (সারি ১: B - F)",
                subtitleTarget = "B · C · D · F",
                categoryId = "consonants",
                letters = listOf(
                    AlphabetLetter("en_b", "Bb", "B", "biː", "বি", "consonants", "B", "Book", "bʊk", "বই"),
                    AlphabetLetter("en_c", "Cc", "C", "siː / k", "সি / ক", "consonants", "C", "Cat", "kæt", "বিড়াল", "e, i, y এর আগে 'স' (City, Cell); অন্য সব জায়গায় 'ক' (Cat, Cup)।"),
                    AlphabetLetter("en_d", "Dd", "D", "diː", "ডি", "consonants", "D", "Door", "dɔːr", "দরজা"),
                    AlphabetLetter("en_f", "Ff", "F", "ef", "এফ", "consonants", "F", "Fish", "fɪʃ", "মাছ", "উপরের দাঁত নিচের ঠোঁটে লাগিয়ে বাতাস ছেড়ে 'এফ'।")
                )
            ),
            AlphabetRow(
                id = "consonants_2",
                titleBn = "ব্যঞ্জনবর্ণ (সারি ২: G - K)",
                subtitleTarget = "G · H · J · K",
                categoryId = "consonants",
                letters = listOf(
                    AlphabetLetter("en_g", "Gg", "G", "dʒiː / ɡ", "জি / গ", "consonants", "G", "Goat", "ɡoʊt", "ছাগল", "সাধারণত 'গ' (Good, Go); e, i এর আগে প্রায়ই 'জ' (Giant, Gem)।"),
                    AlphabetLetter("en_h", "Hh", "H", "eɪtʃ", "এইচ", "consonants", "H", "Home", "hoʊm", "বাড়ি / ঘর", "গলা থেকে নির্গত পরিচ্ছন্ন 'হ' ধ্বনি।"),
                    AlphabetLetter("en_j", "Jj", "J", "dʒeɪ", "জে", "consonants", "J", "Juice", "dʒuːs", "ফলের রস"),
                    AlphabetLetter("en_k", "Kk", "K", "keɪ", "কে", "consonants", "K", "Kite", "kaɪt", "ঘুড়ি")
                )
            ),
            AlphabetRow(
                id = "consonants_3",
                titleBn = "ব্যঞ্জনবর্ণ (সারি ৩: L - P)",
                subtitleTarget = "L · M · N · P",
                categoryId = "consonants",
                letters = listOf(
                    AlphabetLetter("en_l", "Ll", "L", "el", "এল", "consonants", "L", "Lion", "laɪ.ən", "সিংহ", "জিহ্বার ডগা উপরের মাড়িতে স্পর্শ করে 'ল'।"),
                    AlphabetLetter("en_m", "Mm", "M", "em", "এম", "consonants", "M", "Moon", "muːn", "চাঁদ", "উভয় ঠোঁট বন্ধ করে নাসিক্য 'ম'।"),
                    AlphabetLetter("en_n", "Nn", "N", "en", "এন", "consonants", "N", "Night", "naɪt", "রাত"),
                    AlphabetLetter("en_p", "Pp", "P", "piː", "পি", "consonants", "P", "Pen", "pen", "কলম", "উভয় ঠোঁট থেকে বাতাস ছেড়ে সামান্য মহাপ্রাণ 'প'।")
                )
            ),
            AlphabetRow(
                id = "consonants_4",
                titleBn = "ব্যঞ্জনবর্ণ (সারি ৪: Q - T)",
                subtitleTarget = "Q · R · S · T",
                categoryId = "consonants",
                letters = listOf(
                    AlphabetLetter("en_q", "Qq", "Q", "kjuː", "কিউ", "consonants", "Q", "Queen", "kwiːn", "রানী", "সবসময় 'u' এর সাথে বসে 'কোয়া' বা 'কু' ধ্বনি তৈরি করে।"),
                    AlphabetLetter("en_r", "Rr", "R", "ɑːr", "আর", "consonants", "R", "Rose", "roʊz", "গোলাপ", "জিহ্বা তালুতে স্পর্শ না করে বাঁকিয়ে ইংরেজি 'r' বলুন।"),
                    AlphabetLetter("en_s", "Ss", "S", "es", "এস", "consonants", "S", "Sun", "sʌn", "সূর্য", "দাঁতের ফাঁক দিয়ে পরিষ্কার শিসধ্বনি 'স'।"),
                    AlphabetLetter("en_t", "Tt", "T", "tiː", "টি", "consonants", "T", "Tree", "triː", "গাছ", "বাংলা 'ট' ও 'ত' এর মাঝামাঝি আলভিওলার 'টি'।")
                )
            ),
            AlphabetRow(
                id = "consonants_5",
                titleBn = "ব্যঞ্জনবর্ণ (সারি ৫: V - Z)",
                subtitleTarget = "V · W · X · Y · Z",
                categoryId = "consonants",
                letters = listOf(
                    AlphabetLetter("en_v", "Vv", "V", "viː", "ভি", "consonants", "V", "Van", "væn", "ভ্যানগাড়ি", "উপরের দাঁত নিচের ঠোঁটে লাগিয়ে কম্পনসহ 'ভ'।"),
                    AlphabetLetter("en_w", "Ww", "W", "ˈdʌb.əl.juː", "ডাবল-ইউ", "consonants", "W", "Water", "wɔː.tər", "পানি", "ঠোঁট গোল করে 'ওয়া' ধ্বনি (দাঁতে ঠোঁট লাগাবেন না)।"),
                    AlphabetLetter("en_x", "Xx", "X", "eks", "এক্স", "consonants", "X", "Box", "bɒks", "বাক্স", "সাধারণত 'ক+স' (ক্স) উচ্চারিত হয়।"),
                    AlphabetLetter("en_y", "Yy", "Y", "waɪ", "ওয়াই", "consonants", "Y", "Yellow", "jel.oʊ", "হলুদ", "শব্দের শুরুতে 'ই/ইয়া'; শেষে ভাওয়েল হিসেবে 'ই'।"),
                    AlphabetLetter("en_z", "Zz", "Z", "zed / ziː", "যেড / যি", "consonants", "Z", "Zebra", "zeb.rə", "জেব্রা", "গলার ভেতর কম্পনসহ মৌমাছির গুঞ্জনের মতো 'য্'।")
                )
            ),
            AlphabetRow(
                id = "digraphs",
                titleBn = "প্রয়োজনীয় যুক্তধ্বনি (Digraphs & Blends)",
                subtitleTarget = "CH · SH · TH · PH · WH · CK · NG · QU",
                categoryId = "digraphs",
                letters = listOf(
                    AlphabetLetter("en_ch", "Ch", "ch", "tʃ", "চ", "digraphs", "ch", "Chair", "tʃeər", "চেয়ার", "বাংলা স্পষ্ট 'চ' ধ্বনি।"),
                    AlphabetLetter("en_sh", "Sh", "sh", "ʃ", "শ", "digraphs", "sh", "Ship", "ʃɪp", "জাহাজ", "তালব্য নরম 'শ' ধ্বনি।"),
                    AlphabetLetter("en_th", "Th", "th", "θ / ð", "থ / দ", "digraphs", "th", "Thank", "θæŋk", "ধন্যবাদ", "জিহ্বার ডগা দুই পাটি দাঁতের মাঝে রেখে 'থ' (Think) বা 'দ' (This)।"),
                    AlphabetLetter("en_ph", "Ph", "ph", "f", "ফ", "digraphs", "ph", "Phone", "foʊn", "ফোন", "'f' এর মতো দাঁত ও ঠোঁট স্পর্শ করে 'ফ'।"),
                    AlphabetLetter("en_wh", "Wh", "wh", "w", "ওয়", "digraphs", "wh", "White", "waɪt", "সাদা"),
                    AlphabetLetter("en_ck", "Ck", "ck", "k", "ক", "digraphs", "ck", "Duck", "dʌk", "হাঁস", "শব্দের শেষে দৃঢ় 'ক' ধ্বনি।"),
                    AlphabetLetter("en_ng", "Ng", "ng", "ŋ", "ঙ / ং", "digraphs", "ng", "Song", "sɒŋ", "গান", "বাংলা অনুস্বর বা 'ঙ' ধ্বনি।"),
                    AlphabetLetter("en_qu", "Qu", "qu", "kw", "কোয়া", "digraphs", "qu", "Quick", "kwɪk", "দ্রুত")
                )
            )
        )
    )
}

