package com.gigabyte.bookstore.learning.presentation.kana

object KanaData {

    // ==========================================
    // 1. GOJŪON (মূল ৪৬টি বর্ণমালা)
    // ==========================================

    private val ROW_A = KanaRow(
        id = "a",
        nameBn = "স্বরধ্বনি (A-সারি)",
        nameTarget = "A-row (あ・ア)",
        category = KanaCategory.GOJUON,
        letters = listOf(
            KanaLetter("a", "あ", "ア", "a", "আ", "a", KanaCategory.GOJUON, "あさ", "朝", "asa", "সকাল", "পরিষ্কার ও উন্মুক্ত 'আ' ধ্বনি।"),
            KanaLetter("i", "い", "イ", "i", "ই", "a", KanaCategory.GOJUON, "いぬ", "犬", "inu", "কুকুর", "ছোট ও পরিচ্ছন্ন 'ই' ধ্বনি।"),
            KanaLetter("u", "う", "ウ", "u", "উ", "a", KanaCategory.GOJUON, "うみ", "海", "umi", "সমুদ্র", "ঠোঁট গোল করবেন না; চ্যাপ্টা রেখে নরম 'উ' বলুন।"),
            KanaLetter("e", "え", "エ", "e", "এ", "a", KanaCategory.GOJUON, "えき", "駅", "eki", "স্টেশন", "স্পষ্ট বাংলা 'এ' ধ্বনি।"),
            KanaLetter("o", "お", "オ", "o", "ও", "a", KanaCategory.GOJUON, "おかね", "お金", "okane", "টাকা / অর্থ", "মুখ গোল করে 'ও' ধ্বনি।")
        )
    )

    private val ROW_KA = KanaRow(
        id = "ka",
        nameBn = "Ka-সারি (ক)",
        nameTarget = "Ka-row (か・カ)",
        category = KanaCategory.GOJUON,
        letters = listOf(
            KanaLetter("ka", "か", "カ", "ka", "কা", "ka", KanaCategory.GOJUON, "かさ", "傘", "kasa", "ছাতা"),
            KanaLetter("ki", "き", "キ", "ki", "কি", "ka", KanaCategory.GOJUON, "き", "木", "ki", "গাছ"),
            KanaLetter("ku", "く", "ク", "ku", "কু", "ka", KanaCategory.GOJUON, "くるま", "車", "kuruma", "গাড়ি", "ঠোঁট গোল না করে 'কু' বলুন।"),
            KanaLetter("ke", "け", "ケ", "ke", "কে", "ka", KanaCategory.GOJUON, "けいたい", "携帯", "keitai", "মোবাইল ফোন"),
            KanaLetter("ko", "こ", "コ", "ko", "কো", "ka", KanaCategory.GOJUON, "こえ", "声", "koe", "কণ্ঠস্বর")
        )
    )

    private val ROW_SA = KanaRow(
        id = "sa",
        nameBn = "Sa-সারি (স/শ)",
        nameTarget = "Sa-row (さ・サ)",
        category = KanaCategory.GOJUON,
        letters = listOf(
            KanaLetter("sa", "さ", "サ", "sa", "সা", "sa", KanaCategory.GOJUON, "さかな", "魚", "sakana", "মাছ"),
            KanaLetter("shi", "し", "シ", "shi", "শি", "sa", KanaCategory.GOJUON, "しろ", "白", "shiro", "সাদা", "তালব্য 'শি' (si নয়, নরম 'shi')।"),
            KanaLetter("su", "す", "ス", "su", "সু", "sa", KanaCategory.GOJUON, "すし", "寿司", "sushi", "সুশি"),
            KanaLetter("se", "せ", "セ", "se", "সে", "sa", KanaCategory.GOJUON, "せんせい", "先生", "sensei", "শিক্ষক"),
            KanaLetter("so", "そ", "ソ", "so", "সো", "sa", KanaCategory.GOJUON, "そら", "空", "sora", "আকাশ")
        )
    )

    private val ROW_TA = KanaRow(
        id = "ta",
        nameBn = "Ta-সারি (ত/চ/ৎস)",
        nameTarget = "Ta-row (た・タ)",
        category = KanaCategory.GOJUON,
        letters = listOf(
            KanaLetter("ta", "た", "タ", "ta", "তা", "ta", KanaCategory.GOJUON, "たまご", "卵", "tamago", "ডিম"),
            KanaLetter("chi", "ち", "チ", "chi", "চি", "ta", KanaCategory.GOJUON, "ちかてつ", "地下鉄", "chikatetsu", "পাতালরেল", "'তি' নয়, স্পষ্ট বাংলা 'চি'।"),
            KanaLetter("tsu", "つ", "ツ", "tsu", "ৎসু", "ta", KanaCategory.GOJUON, "つき", "月", "tsuki", "চাঁদ", "'ত' ও 'স' এর মিশ্রিত হিস্ ধ্বনি (Cats এর ts)।"),
            KanaLetter("te", "て", "テ", "te", "তে", "ta", KanaCategory.GOJUON, "て", "手", "te", "হাত"),
            KanaLetter("to", "と", "ト", "to", "তো", "ta", KanaCategory.GOJUON, "ともだち", "友達", "tomodachi", "বন্ধু")
        )
    )

    private val ROW_NA = KanaRow(
        id = "na",
        nameBn = "Na-সারি (ন)",
        nameTarget = "Na-row (な・ナ)",
        category = KanaCategory.GOJUON,
        letters = listOf(
            KanaLetter("na", "な", "ナ", "na", "না", "na", KanaCategory.GOJUON, "なつ", "夏", "natsu", "গ্রীষ্মকাল"),
            KanaLetter("ni", "に", "ニ", "ni", "নি", "na", KanaCategory.GOJUON, "にく", "肉", "niku", "মাংস"),
            KanaLetter("nu", "ぬ", "ヌ", "nu", "নু", "na", KanaCategory.GOJUON, "ぬいぐるみ", null, "nuigurumi", "পুতুল"),
            KanaLetter("ne", "ね", "ネ", "ne", "নে", "na", KanaCategory.GOJUON, "ねこ", "猫", "neko", "বিড়াল"),
            KanaLetter("no", "の", "ノ", "no", "নো", "na", KanaCategory.GOJUON, "のみもの", "飲み物", "nomimono", "পানীয়")
        )
    )

    private val ROW_HA = KanaRow(
        id = "ha",
        nameBn = "Ha-সারি (হ/ফ)",
        nameTarget = "Ha-row (は・ハ)",
        category = KanaCategory.GOJUON,
        letters = listOf(
            KanaLetter("ha", "は", "ハ", "ha", "হা", "ha", KanaCategory.GOJUON, "はな", "花", "hana", "ফুল / নাক", "পার্টিকেল হিসেবে বসলে 'ওয়া' উচ্চারিত হয়।"),
            KanaLetter("hi", "ひ", "ヒ", "hi", "হি", "ha", KanaCategory.GOJUON, "ひと", "人", "hito", "মানুষ"),
            KanaLetter("fu", "ふ", "フ", "fu", "ফু", "ha", KanaCategory.GOJUON, "ふね", "船", "fune", "নৌকা / জাহাজ", "দাঁতে ঠোঁট না লাগিয়ে মোমবাতি নেভানোর মতো ফুঁ দিয়ে 'ফু' বলুন।"),
            KanaLetter("he", "へ", "ヘ", "he", "হে", "ha", KanaCategory.GOJUON, "へや", "部屋", "heya", "ঘর / রুম", "দিকনির্দেশক পার্টিকেল হলে 'এ' উচ্চারিত হয়।"),
            KanaLetter("ho", "ほ", "ホ", "ho", "হো", "ha", KanaCategory.GOJUON, "ほん", "本", "hon", "বই")
        )
    )

    private val ROW_MA = KanaRow(
        id = "ma",
        nameBn = "Ma-সারি (ম)",
        nameTarget = "Ma-row (ま・マ)",
        category = KanaCategory.GOJUON,
        letters = listOf(
            KanaLetter("ma", "ま", "マ", "ma", "মা", "ma", KanaCategory.GOJUON, "まど", "窓", "mado", "জানালা"),
            KanaLetter("mi", "み", "ミ", "mi", "মি", "ma", KanaCategory.GOJUON, "みず", "水", "mizu", "পানি"),
            KanaLetter("mu", "む", "ム", "mu", "মু", "ma", KanaCategory.GOJUON, "むし", "虫", "mushi", "পোকামাকড়"),
            KanaLetter("me", "め", "メ", "me", "মে", "ma", KanaCategory.GOJUON, "め", "目", "me", "চোখ"),
            KanaLetter("mo", "も", "モ", "mo", "মো", "ma", KanaCategory.GOJUON, "もり", "森", "mori", "বন / জঙ্গল")
        )
    )

    private val ROW_YA = KanaRow(
        id = "ya",
        nameBn = "Ya-সারি (ইয়া)",
        nameTarget = "Ya-row (や・ヤ)",
        category = KanaCategory.GOJUON,
        letters = listOf(
            KanaLetter("ya", "や", "ヤ", "ya", "ইয়া", "ya", KanaCategory.GOJUON, "やま", "山", "yama", "পাহাড়"),
            null,
            KanaLetter("yu", "ゆ", "ユ", "yu", "ইউ", "ya", KanaCategory.GOJUON, "ゆき", "雪", "yuki", "বরফ"),
            null,
            KanaLetter("yo", "よ", "ヨ", "yo", "ইয়ো", "ya", KanaCategory.GOJUON, "よる", "夜", "yoru", "রাত")
        )
    )

    private val ROW_RA = KanaRow(
        id = "ra",
        nameBn = "Ra-সারি (র/ল এর মাঝামাঝি ফ্ল্যাপ)",
        nameTarget = "Ra-row (ら・ラ)",
        category = KanaCategory.GOJUON,
        letters = listOf(
            KanaLetter("ra", "ら", "ラ", "ra", "রা", "ra", KanaCategory.GOJUON, "さくら", "桜", "sakura", "চেরি ফুল", "জিহ্বার ডগা দিয়ে সামান্য স্পর্শ করে 'র' ও 'ল' এর মাঝামাঝি ধ্বনি।"),
            KanaLetter("ri", "り", "リ", "ri", "রি", "ra", KanaCategory.GOJUON, "りんご", "林檎", "ringo", "আপেল"),
            KanaLetter("ru", "る", "ル", "ru", "রু", "ra", KanaCategory.GOJUON, "よる", "夜", "yoru", "রাত"),
            KanaLetter("re", "れ", "レ", "re", "রে", "ra", KanaCategory.GOJUON, "れきし", "歴史", "rekishi", "ইতিহাস"),
            KanaLetter("ro", "ろ", "ロ", "ro", "রো", "ra", KanaCategory.GOJUON, "ろうか", "廊下", "rouka", "বারান্দা")
        )
    )

    private val ROW_WA = KanaRow(
        id = "wa",
        nameBn = "Wa-সারি ও নাসিক্য N",
        nameTarget = "Wa-row & N (わ・ワ・ん)",
        category = KanaCategory.GOJUON,
        letters = listOf(
            KanaLetter("wa", "わ", "ワ", "wa", "ওয়া", "wa", KanaCategory.GOJUON, "わたし", "私", "watashi", "আমি"),
            null,
            null,
            null,
            KanaLetter("wo", "を", "ヲ", "o / wo", "ও", "wa", KanaCategory.GOJUON, "ほんをよむ", "本を読む", "hon o yomu", "বই পড়া (অবজেক্ট মার্কার)")
        )
    )

    private val ROW_N = KanaRow(
        id = "n",
        nameBn = "নাসিক্য বর্ণ (N)",
        nameTarget = "N (ん・ン)",
        category = KanaCategory.GOJUON,
        letters = listOf(
            KanaLetter("n", "ん", "ン", "n", "ং / ন্", "n", KanaCategory.GOJUON, "にほん", "日本", "nihon", "জাপান", "পরবর্তী বর্ণের উপর নির্ভর করে 'ন', 'ম' বা 'অনুস্বার' এর মতো শোনায়।"),
            null, null, null, null
        )
    )

    // ==========================================
    // 2. DAKUON & HANDAKUON (ভয়েসড ২৫টি বর্ণমালা)
    // ==========================================

    private val ROW_GA = KanaRow(
        id = "ga",
        nameBn = "Ga-সারি (গ - তেন-তেন ゛)",
        nameTarget = "Ga-row (が・ガ)",
        category = KanaCategory.DAKUTEN,
        letters = listOf(
            KanaLetter("ga", "が", "ガ", "ga", "গা", "ga", KanaCategory.DAKUTEN, "がくせい", "学生", "gakusei", "শিক্ষার্থী"),
            KanaLetter("gi", "ぎ", "ギ", "gi", "গি", "ga", KanaCategory.DAKUTEN, "ぎんこう", "銀行", "ginkou", "ব্যাংক"),
            KanaLetter("gu", "ぐ", "グ", "gu", "গু", "ga", KanaCategory.DAKUTEN, "ぐらい", null, "gurai", "প্রায় / কাছাকাছি"),
            KanaLetter("ge", "げ", "ゲ", "ge", "গে", "ga", KanaCategory.DAKUTEN, "げんき", "元気", "genki", "সুস্থ / ভালো"),
            KanaLetter("go", "ご", "ゴ", "go", "গো", "ga", KanaCategory.DAKUTEN, "ごはん", "ご飯", "gohan", "ভাত / খাবার")
        )
    )

    private val ROW_ZA = KanaRow(
        id = "za",
        nameBn = "Za-সারি (য/জ - তেন-তেন ゛)",
        nameTarget = "Za-row (ざ・ザ)",
        category = KanaCategory.DAKUTEN,
        letters = listOf(
            KanaLetter("za", "ざ", "ザ", "za", "যা", "za", KanaCategory.DAKUTEN, "ざっし", "雑誌", "zasshi", "ম্যাগাজিন"),
            KanaLetter("ji", "じ", "ジ", "ji", "জি", "za", KanaCategory.DAKUTEN, "じかん", "時間", "jikan", "সময়", "ইংরেজি 'j' এর মতো নরম 'জি'।"),
            KanaLetter("zu", "ず", "ズ", "zu", "যু", "za", KanaCategory.DAKUTEN, "ちず", "地図", "chizu", "মানচিত্র"),
            KanaLetter("ze", "ぜ", "ゼ", "ze", "যে", "za", KanaCategory.DAKUTEN, "ぜんぶ", "全部", "zenbu", "সব / সম্পূর্ণ"),
            KanaLetter("zo", "ぞ", "ゾ", "zo", "যো", "za", KanaCategory.DAKUTEN, "かぞく", "家族", "kazoku", "পরিবার")
        )
    )

    private val ROW_DA = KanaRow(
        id = "da",
        nameBn = "Da-সারি (দ/জ - তেন-তেন ゛)",
        nameTarget = "Da-row (だ・ダ)",
        category = KanaCategory.DAKUTEN,
        letters = listOf(
            KanaLetter("da", "だ", "ダ", "da", "দা", "da", KanaCategory.DAKUTEN, "だいがく", "大学", "daigaku", "বিশ্ববিদ্যালয়"),
            KanaLetter("dji", "ぢ", "ヂ", "ji", "জি", "da", KanaCategory.DAKUTEN, "はなぢ", "鼻血", "hanaji", "নাক দিয়ে রক্ত পড়া", "উচ্চারণে じ (ji) এর মতোই।"),
            KanaLetter("dzu", "づ", "ヅ", "zu", "যু", "da", KanaCategory.DAKUTEN, "つづく", "続く", "tsuzuku", "অব্যাহত থাকা", "উচ্চারণে ず (zu) এর মতোই।"),
            KanaLetter("de", "で", "デ", "de", "দে", "da", KanaCategory.DAKUTEN, "でんしゃ", "電車", "densha", "ট্রেন"),
            KanaLetter("do", "ど", "ド", "do", "দো", "da", KanaCategory.DAKUTEN, "どこ", null, "doko", "কোথায়")
        )
    )

    private val ROW_BA = KanaRow(
        id = "ba",
        nameBn = "Ba-সারি (ব - তেন-তেন ゛)",
        nameTarget = "Ba-row (ば・バ)",
        category = KanaCategory.DAKUTEN,
        letters = listOf(
            KanaLetter("ba", "ば", "バ", "ba", "বা", "ba", KanaCategory.DAKUTEN, "ばんごう", "番号", "bangou", "নম্বর"),
            KanaLetter("bi", "び", "ビ", "bi", "বি", "ba", KanaCategory.DAKUTEN, "びょういん", "病院", "byouin", "হাসপাতাল"),
            KanaLetter("bu", "ぶ", "ブ", "bu", "বু", "ba", KanaCategory.DAKUTEN, "ぶたにく", "豚肉", "butaniku", "শূকরের মাংস"),
            KanaLetter("be", "べ", "ベ", "be", "বে", "ba", KanaCategory.DAKUTEN, "べんきょう", "勉強", "benkyou", "পড়াশোনা"),
            KanaLetter("bo", "ぼ", "ボ", "bo", "বো", "ba", KanaCategory.DAKUTEN, "ぼうし", "帽子", "boushi", "টুপি")
        )
    )

    private val ROW_PA = KanaRow(
        id = "pa",
        nameBn = "Pa-সারি (প - মারু ゜)",
        nameTarget = "Pa-row (ぱ・パ)",
        category = KanaCategory.DAKUTEN,
        letters = listOf(
            KanaLetter("pa", "ぱ", "パ", "pa", "পা", "pa", KanaCategory.DAKUTEN, "パン", null, "pan", "পাউরুটি"),
            KanaLetter("pi", "ぴ", "ピ", "pi", "পি", "pa", KanaCategory.DAKUTEN, "ピアノ", null, "piano", "পিয়ানো"),
            KanaLetter("pu", "ぷ", "プ", "pu", "পু", "pa", KanaCategory.DAKUTEN, "プール", null, "puuru", "সুইমিং পুল"),
            KanaLetter("pe", "ぺ", "ペ", "pe", "পে", "pa", KanaCategory.DAKUTEN, "ペン", null, "pen", "কলম"),
            KanaLetter("po", "ぽ", "ポ", "po", "পো", "pa", KanaCategory.DAKUTEN, "ポスト", null, "posuto", "পোস্টবক্স")
        )
    )

    // ==========================================
    // 3. YŌON (যুক্তধ্বনি ৩৩টি - ছোট ゃ・ゅ・ょ)
    // ==========================================

    private val ROW_KYA = KanaRow(
        id = "kya",
        nameBn = "Kya-সারি (ক্যা)",
        nameTarget = "Kya / Kyu / Kyo (きゃ・キャ)",
        category = KanaCategory.YOON,
        letters = listOf(
            KanaLetter("kya", "きゃ", "キャ", "kya", "ক্যা", "kya", KanaCategory.YOON, "きゃく", "客", "kyaku", "অতিথি / কাস্টমার"),
            KanaLetter("kyu", "きゅ", "キュ", "kyu", "কিউ", "kya", KanaCategory.YOON, "きゅう", "九", "kyuu", "নয় (৯)"),
            KanaLetter("kyo", "きょ", "キョ", "kyo", "ক্যো", "kya", KanaCategory.YOON, "きょう", "今日", "kyou", "আজ")
        )
    )

    private val ROW_SHA = KanaRow(
        id = "sha",
        nameBn = "Sha-সারি (শা)",
        nameTarget = "Sha / Shu / Sho (しゃ・シャ)",
        category = KanaCategory.YOON,
        letters = listOf(
            KanaLetter("sha", "しゃ", "シャ", "sha", "শা", "sha", KanaCategory.YOON, "しゃしん", "写真", "shashin", "ছবি"),
            KanaLetter("shu", "しゅ", "シュ", "shu", "শু", "sha", KanaCategory.YOON, "しゅくだい", "宿題", "shukudai", "বাড়ির কাজ (হোমওয়ার্ক)"),
            KanaLetter("sho", "しょ", "ショ", "sho", "শো", "sha", KanaCategory.YOON, "しょくどう", "食堂", "shokudou", "ডাইনিং / ক্যান্টিন")
        )
    )

    private val ROW_CHA = KanaRow(
        id = "cha",
        nameBn = "Cha-সারি (চা)",
        nameTarget = "Cha / Chu / Cho (ちゃ・チャ)",
        category = KanaCategory.YOON,
        letters = listOf(
            KanaLetter("cha", "ちゃ", "チャ", "cha", "চা", "cha", KanaCategory.YOON, "おちゃ", "お茶", "ocha", "গ্রিন টি / চা"),
            KanaLetter("chu", "ちゅ", "チュ", "chu", "চু", "cha", KanaCategory.YOON, "ちゅうごく", "中国", "chuugoku", "চীন"),
            KanaLetter("cho", "ちょ", "チョ", "cho", "চো", "cha", KanaCategory.YOON, "ちょっと", null, "chotto", "একটু / সামান্য")
        )
    )

    private val ROW_NYA = KanaRow(
        id = "nya",
        nameBn = "Nya-সারি (নিয়া)",
        nameTarget = "Nya / Nyu / Nyo (にゃ・ニャ)",
        category = KanaCategory.YOON,
        letters = listOf(
            KanaLetter("nya", "にゃ", "ニャ", "nya", "নিয়া", "nya", KanaCategory.YOON, "にゃー", null, "nyaa", "বিড়ালের ডাক (মিউ)"),
            KanaLetter("nyu", "にゅ", "ニュ", "nyu", "নিউ", "nya", KanaCategory.YOON, "ぎゅうにゅう", "牛乳", "gyuunyuu", "দুধ"),
            KanaLetter("nyo", "にょ", "ニョ", "nyo", "নিয়ো", "nya", KanaCategory.YOON, "にょうぼう", "女房", "nyoubou", "স্ত্রী / পত্নী")
        )
    )

    private val ROW_HYA = KanaRow(
        id = "hya",
        nameBn = "Hya-সারি (হিয়া)",
        nameTarget = "Hya / Hyu / Hyo (ひゃ・ヒャ)",
        category = KanaCategory.YOON,
        letters = listOf(
            KanaLetter("hya", "ひゃ", "ヒャ", "hya", "হিয়া", "hya", KanaCategory.YOON, "ひゃく", "百", "hyaku", "একশত (১০০)"),
            KanaLetter("hyu", "ひゅ", "ヒュ", "hyu", "হিউ", "hya", KanaCategory.YOON, "ひゅう", null, "hyuu", "বাতাসের শিষ"),
            KanaLetter("hyo", "ひょ", "ヒョ", "hyo", "হিয়ো", "hya", KanaCategory.YOON, "ひょう", "表", "hyou", "তালিকা / চার্ট")
        )
    )

    private val ROW_MYA = KanaRow(
        id = "mya",
        nameBn = "Mya-সারি (মিয়া)",
        nameTarget = "Mya / Myu / Myo (みゃ・ミャ)",
        category = KanaCategory.YOON,
        letters = listOf(
            KanaLetter("mya", "みゃ", "ミャ", "mya", "মিয়া", "mya", KanaCategory.YOON, "みゃく", "脈", "myaku", "নাড়ির স্পন্দন"),
            KanaLetter("myu", "みゅ", "ミュ", "myu", "মিউ", "mya", KanaCategory.YOON, "ミュージアム", null, "myuujiamu", "জাদুঘর"),
            KanaLetter("myo", "みょ", "ミョ", "myo", "মিয়ো", "mya", KanaCategory.YOON, "みょうじ", "苗字", "myouji", "পারিবারিক পদবি")
        )
    )

    private val ROW_RYA = KanaRow(
        id = "rya",
        nameBn = "Rya-সারি (রিয়া)",
        nameTarget = "Rya / Ryu / Ryo (りゃ・リャ)",
        category = KanaCategory.YOON,
        letters = listOf(
            KanaLetter("rya", "りゃ", "リャ", "rya", "রিয়া", "rya", KanaCategory.YOON, "りゃく", "略", "ryaku", "সংক্ষিপ্ত রূপ"),
            KanaLetter("ryu", "りゅ", "リュ", "ryu", "রিউ", "rya", KanaCategory.YOON, "りゅうがく", "留学", "ryuugaku", "বিদেশে উচ্চশিক্ষা"),
            KanaLetter("ryo", "りょ", "リョ", "ryo", "রিয়ো", "rya", KanaCategory.YOON, "りょこう", "旅行", "ryokou", "ভ্রমণ")
        )
    )

    private val ROW_GYA = KanaRow(
        id = "gya",
        nameBn = "Gya-সারি (গ্যা)",
        nameTarget = "Gya / Gyu / Gyo (ぎゃ・ギャ)",
        category = KanaCategory.YOON,
        letters = listOf(
            KanaLetter("gya", "ぎゃ", "ギャ", "gya", "গ্যা", "gya", KanaCategory.YOON, "ギャグ", null, "gyagu", "কৌতুক / গ্যাগ"),
            KanaLetter("gyu", "ぎゅ", "ギュ", "gyu", "গিউ", "gya", KanaCategory.YOON, "ぎゅうにく", "牛肉", "gyuuniku", "গরুর মাংস"),
            KanaLetter("gyo", "ぎょ", "ギョ", "gyo", "গ্যো", "gya", KanaCategory.YOON, "ぎょうざ", "餃子", "gyouza", "গিয়োজা (ডাম্পলিং)")
        )
    )

    private val ROW_JA = KanaRow(
        id = "ja",
        nameBn = "Ja-সারি (জা)",
        nameTarget = "Ja / Ju / Jo (じゃ・ジャ)",
        category = KanaCategory.YOON,
        letters = listOf(
            KanaLetter("ja", "じゃ", "ジャ", "ja", "জা", "ja", KanaCategory.YOON, "じゃま", "邪魔", "jama", "বাধা / ডিস্টার্ব"),
            KanaLetter("ju", "じゅ", "ジュ", "ju", "জু", "ja", KanaCategory.YOON, "じゅぎょう", "授業", "jugyou", "ক্লাস / পাঠদান"),
            KanaLetter("jo", "じょ", "ジョ", "jo", "জো", "ja", KanaCategory.YOON, "じょせい", "女性", "josei", "নারী / ভদ্রমহিলা")
        )
    )

    private val ROW_BYA = KanaRow(
        id = "bya",
        nameBn = "Bya-সারি (ব্যা)",
        nameTarget = "Bya / Byu / Byo (びゃ・ビャ)",
        category = KanaCategory.YOON,
        letters = listOf(
            KanaLetter("bya", "びゃ", "ビャ", "bya", "ব্যা", "bya", KanaCategory.YOON, "びゃくえ", "白会", "byakue", "শ্বেতবস্ত্র"),
            KanaLetter("byu", "びゅ", "ビュ", "byu", "বিউ", "bya", KanaCategory.YOON, "びゅうびゅう", null, "byuubyuu", "ঝড়ের শব্দ"),
            KanaLetter("byo", "びょ", "ビョ", "byo", "ব্যো", "bya", KanaCategory.YOON, "びょういん", "病院", "byouin", "হাসপাতাল")
        )
    )

    private val ROW_PYA = KanaRow(
        id = "pya",
        nameBn = "Pya-সারি (প্যা)",
        nameTarget = "Pya / Pyu / Pyo (ぴゃ・ピャ)",
        category = KanaCategory.YOON,
        letters = listOf(
            KanaLetter("pya", "ぴゃ", "ピャ", "pya", "প্যা", "pya", KanaCategory.YOON, "ピャー", null, "pyaa", "তীক্ষ্ণ ডাক"),
            KanaLetter("pyu", "ぴゅ", "ピュ", "pyu", "পিউ", "pya", KanaCategory.YOON, "ぴゅー", null, "pyuu", "হুইসল / বাতাসের বাঁশি"),
            KanaLetter("pyo", "ぴょ", "ピョ", "pyo", "প্যো", "pya", KanaCategory.YOON, "ぴょんぴょん", null, "pyonpyon", "লাফালাফি করা")
        )
    )

    val GOJUON_ROWS: List<KanaRow> = listOf(
        ROW_A, ROW_KA, ROW_SA, ROW_TA, ROW_NA,
        ROW_HA, ROW_MA, ROW_YA, ROW_RA, ROW_WA, ROW_N
    )

    val DAKUTEN_ROWS: List<KanaRow> = listOf(
        ROW_GA, ROW_ZA, ROW_DA, ROW_BA, ROW_PA
    )

    val YOON_ROWS: List<KanaRow> = listOf(
        ROW_KYA, ROW_SHA, ROW_CHA, ROW_NYA, ROW_HYA,
        ROW_MYA, ROW_RYA, ROW_GYA, ROW_JA, ROW_BYA, ROW_PYA
    )

    val ALL_ROWS: List<KanaRow> = GOJUON_ROWS + DAKUTEN_ROWS + YOON_ROWS

    /** Flattened list of all valid letters (no null grid cells). Total: 46 + 25 + 33 = 104. */
    val ALL_LETTERS: List<KanaLetter> = ALL_ROWS.flatMap { it.letters.filterNotNull() }

    fun findLetterById(id: String): KanaLetter? = ALL_LETTERS.firstOrNull { it.id == id }
}

