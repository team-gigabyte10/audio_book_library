package com.gigabyte.bookstore.learning.presentation.alphabet

import com.gigabyte.bookstore.learning.domain.model.SpeechLang

object GermanAlphabetData {

    val CONFIG = LanguageAlphabetConfig(
        langCode = "german",
        speechLang = SpeechLang.DE,
        titleBn = "জার্মান বর্ণমালা ও উমলাউত চার্ট (Alphabet)",
        subtitleBn = "২৬টি বর্ণ, ৪টি বিশেষ উমলাউত ও জরুরি ধ্বনিগুচ্ছ · ট্যাপ করলেই অডিও",
        accentColorHex = 0xFF4527A0,
        categories = listOf(
            AlphabetCategory("all", "সব বর্ণ", "৩৮টি"),
            AlphabetCategory("basic", "মূল বর্ণমালা (A-Z)", "২৬টি"),
            AlphabetCategory("umlaute", "উমলাউত ও ß (Umlaute)", "৪টি"),
            AlphabetCategory("diphthongs", "যৌগিক ধ্বনি (Diphthongs)", "৮টি")
        ),
        rows = listOf(
            AlphabetRow(
                id = "de_row_1",
                titleBn = "মূল বর্ণমালা (সারি ১: A - F)",
                subtitleTarget = "A · B · C · D · E · F",
                categoryId = "basic",
                letters = listOf(
                    AlphabetLetter("de_a", "Aa", "A", "aː", "আ", "basic", "A", "Apfel", "ˈapfl̩", "আপেল", "খোলা ও গভীর 'আ' ধ্বনি।"),
                    AlphabetLetter("de_b", "Bb", "B", "beː", "বে", "basic", "Be", "Buch", "buːx", "বই", "জার্মান 'বে'। শব্দের শেষে বসলে 'প' এর মতো শোনায়।"),
                    AlphabetLetter("de_c", "Cc", "C", "tseː", "সে / ৎসে", "basic", "Ce", "Computer", "kɔmˈpjuːtɐ", "কম্পিউটার", "বিদেশি শব্দে 'ক'; জার্মান শব্দে 'ৎস'।"),
                    AlphabetLetter("de_d", "Dd", "D", "deː", "দে", "basic", "De", "Danke", "ˈdaŋkə", "ধন্যবাদ", "শব্দের শেষে বসলে 'ত' এর মতো শোনায়।"),
                    AlphabetLetter("de_e", "Ee", "E", "eː", "এ", "basic", "E", "Elefant", "eleˈfant", "হাতি", "পরিচ্ছন্ন 'এ' ধ্বনি।"),
                    AlphabetLetter("de_f", "Ff", "F", "ɛf", "এফ", "basic", "Ef", "Fisch", "fɪʃ", "মাছ")
                )
            ),
            AlphabetRow(
                id = "de_row_2",
                titleBn = "মূল বর্ণমালা (সারি ২: G - L)",
                subtitleTarget = "G · H · I · J · K · L",
                categoryId = "basic",
                letters = listOf(
                    AlphabetLetter("de_g", "Gg", "G", "ɡeː", "গে", "basic", "Ge", "Garten", "ˈɡaʁtn̩", "বাগান", "শব্দের শেষে বসলে 'ক' বা 'খ' (যেমন Tag, König)।"),
                    AlphabetLetter("de_h", "Hh", "H", "haː", "হা", "basic", "Ha", "Haus", "haʊs", "বাড়ি / ঘর", "শব্দের মাঝে বা ভাওয়েলের পরে থাকলে অনুচ্চারিত থেকে আগের স্বরকে দীর্ঘ করে (Gehen)।"),
                    AlphabetLetter("de_i", "Ii", "I", "iː", "ই", "basic", "I", "Insel", "ˈɪnzl̩", "দ্বীপ"),
                    AlphabetLetter("de_j", "Jj", "J", "jɔt", "ইত (Yot)", "basic", "Jot", "Ja", "jaː", "হ্যাঁ", "জার্মানিতে J সবসময় ইংরেজি Y (ইয়) এর মতো উচ্চারিত হয় (Ja = ইয়া)।"),
                    AlphabetLetter("de_k", "Kk", "K", "kaː", "কা", "basic", "Ka", "Katze", "ˈkat͡sə", "বিড়াল"),
                    AlphabetLetter("de_l", "Ll", "L", "ɛl", "এল", "basic", "El", "Lampe", "ˈlampə", "বাতি")
                )
            ),
            AlphabetRow(
                id = "de_row_3",
                titleBn = "মূল বর্ণমালা (সারি ৩: M - R)",
                subtitleTarget = "M · N · O · P · Q · R",
                categoryId = "basic",
                letters = listOf(
                    AlphabetLetter("de_m", "Mm", "M", "ɛm", "এম", "basic", "Em", "Mond", "moːnt", "চাঁদ"),
                    AlphabetLetter("de_n", "Nn", "N", "ɛn", "এন", "basic", "En", "Nacht", "naxt", "রাত"),
                    AlphabetLetter("de_o", "Oo", "O", "oː", "ও", "basic", "O", "Ohr", "oːɐ̯", "কান", "মুখ গোল করে 'ও'।"),
                    AlphabetLetter("de_p", "Pp", "P", "peː", "পে", "basic", "Pe", "Park", "paʁk", "পার্ক"),
                    AlphabetLetter("de_q", "Qq", "Q", "kuː", "কু", "basic", "Ku", "Quelle", "ˈkvɛlə", "উৎস", "সবসময় 'Qu' আকারে বসে 'ক্ভ' (kv) উচ্চারিত হয়।"),
                    AlphabetLetter("de_r", "Rr", "R", "ɛʁ", "এর", "basic", "Er", "Rot", "ʁoːt", "লাল", "কণ্ঠনালীর গভীরে ঘর্ষণযুক্ত জার্মান 'র'। শব্দের শেষে বসলে হালকা 'আ' শোনায়।")
                )
            ),
            AlphabetRow(
                id = "de_row_4",
                titleBn = "মূল বর্ণমালা (সারি ৪: S - Z)",
                subtitleTarget = "S · T · U · V · W · X · Y · Z",
                categoryId = "basic",
                letters = listOf(
                    AlphabetLetter("de_s", "Ss", "S", "ɛs", "এস / যে", "basic", "Es", "Sonne", "ˈzɔnə", "সূর্য", "স্বরবর্ণের আগে বসলে নরম মৌমাছির মতো 'য' (Sonne = যনে); শেষে বসলে কড়া 'স'।"),
                    AlphabetLetter("de_t", "Tt", "T", "teː", "তে", "basic", "Te", "Tag", "taːk", "দিন", "বাংলা দন্ত্য 'ত'।"),
                    AlphabetLetter("de_u", "Uu", "U", "uː", "উ", "basic", "U", "Uhr", "uːɐ̯", "ঘড়ি"),
                    AlphabetLetter("de_v", "Vv", "V", "faʊ", "ফাউ", "basic", "Vau", "Vater", "ˈfaːtɐ", "বাবা", "খাঁটি জার্মান শব্দে ইংরেজি 'F' (ফ) উচ্চারিত হয় (Vater = ফাটার)।"),
                    AlphabetLetter("de_w", "Ww", "W", "veː", "ভে", "basic", "We", "Wasser", "ˈvasɐ", "পানি", "ইংরেজি 'V' এর মতো দাঁত ও ঠোঁট স্পর্শ করে 'ভ' (Wasser = ভাসা)।"),
                    AlphabetLetter("de_x", "Xx", "X", "ɪks", "ইক্স", "basic", "Ix", "Taxi", "Taxi", "ˈtaksi", "ট্যাক্সি"),
                    AlphabetLetter("de_y", "Yy", "Y", "ˈʏpsilɔn", "ইপসিলন", "basic", "Ypsilon", "System", "zʏsˈteːm", "পদ্ধতি", "ঠোঁট গোল করে 'উ/ই' ধ্বনি।"),
                    AlphabetLetter("de_z", "Zz", "Z", "t͡sɛt", "ৎসেত", "basic", "Zett", "Zug", "t͡suːk", "ট্রেন", "সবসময় 'ৎস' (ts) উচ্চারিত হয় (Zug = ৎসুক)।")
                )
            ),
            AlphabetRow(
                id = "de_umlaute",
                titleBn = "জার্মান বিশেষ উমলাউত ও এসৎসেত (Ä · Ö · Ü · ß)",
                subtitleTarget = "Umlaute & Eszett (Special Characters)",
                categoryId = "umlaute",
                letters = listOf(
                    AlphabetLetter("de_ae", "Ää", "A-Umlaut", "ɛː / ae", "এ / অ্যা", "umlaute", "Ä", "Äpfel", "ˈɛpfl̩", "আপেলসমূহ", "উন্মুক্ত ও দীর্ঘ 'অ্যা/এ' ধ্বনি।"),
                    AlphabetLetter("de_oe", "Öö", "O-Umlaut", "øː / oe", "ও/এ (ঠোঁট গোল)", "umlaute", "Ö", "Öl", "øːl", "তেল", "ঠোঁট গোল করে 'ও' এর ভঙ্গিতে 'এ' বলুন।"),
                    AlphabetLetter("de_ue", "Üü", "U-Umlaut", "yː / ue", "উ/ই (ঠোঁট গোল)", "umlaute", "Ü", "Über", "ˈyːbɐ", "উপরে", "ঠোঁট শিষ দেওয়ার মতো গোল করে 'ই' বলুন।"),
                    AlphabetLetter("de_ss", "ß", "Eszett", "scharfes S", "কড়া স (ss)", "umlaute", "Eszett", "Straße", "ˈʃtʁaːsə", "রাস্তা", "দীর্ঘ স্বরের পরে কড়া 'স' ধ্বনি (সুইজারল্যান্ডে ss লেখা হয়)।")
                )
            ),
            AlphabetRow(
                id = "de_diphthongs",
                titleBn = "প্রয়োজনীয় যৌগিক ধ্বনি ও কম্বিনেশন (Diphthongs & Blends)",
                subtitleTarget = "EI · IE · EU · CH · SCH · SP · ST · TS",
                categoryId = "diphthongs",
                letters = listOf(
                    AlphabetLetter("de_ei", "ei", "Diphthong", "aɪ", "আই", "diphthongs", "ei", "Eis", "aɪs", "আইসক্রিম / বরফ", "স্পষ্ট বাংলা 'আই' ধ্বনি (যেমন Nein = নাইন)।"),
                    AlphabetLetter("de_ie", "ie", "Diphthong", "iː", "দীর্ঘ ঈ", "diphthongs", "ie", "Liebe", "ˈliːbə", "ভালোবাসা", "টানা দীর্ঘ 'ঈ' ধ্বনি (যেমন Sie = জি)।"),
                    AlphabetLetter("de_eu", "eu / äu", "Diphthong", "ɔɪ", "অয় (Oy)", "diphthongs", "eu", "Euro", "ˈɔɪʁoː", "ইউরো", "বাংলা 'অয়' ধ্বনি (যেমন Heute = হয়টে)।"),
                    AlphabetLetter("de_ch", "ch", "Blend", "ç / x", "খ / শ", "diphthongs", "ch", "Buch", "buːx", "বই", "a, o, u এর পর 'খ' (Buch, Nacht); i, e এর পর নরম তালব্য 'শ' (Ich)।"),
                    AlphabetLetter("de_sch", "sch", "Blend", "ʃ", "শ", "diphthongs", "sch", "Schule", "ˈʃuːlə", "স্কুল", "বাংলা কড়া তালব্য 'শ' ধ্বনি।"),
                    AlphabetLetter("de_sp", "sp", "Blend", "ʃp", "শ্প", "diphthongs", "sp", "Sport", "ʃpɔʁt", "খেলাধুলা", "শব্দের শুরুতে 'শ+প' (Sport = শ্পর্ট)।"),
                    AlphabetLetter("de_st", "st", "Blend", "ʃt", "শ্ত", "diphthongs", "st", "Stadt", "ʃtat", "শহর", "শব্দের শুরুতে 'শ+ত' (Stadt = শ্টাট)।"),
                    AlphabetLetter("de_ts", "ts / tz", "Blend", "t͡s", "ৎস", "diphthongs", "ts", "Platz", "plat͡s", "স্থান / চত্বর", "হিস্ ধ্বনিযুক্ত 'ৎস'।")
                )
            )
        )
    )
}
