# -*- coding: utf-8 -*-
"""
Generates the comprehensive Zero-to-Reading Japanese Master Course:
- Phase 1: 46 Hiragana & Pure Sounds (9 lessons)
- Phase 2: Dakuon, Sokuon, Youon, Chouon & Tongue Twisters (5 lessons)
- Phase 3: Katakana & Foreign Signs/Words (4 lessons)
- Phase 4: Reading Rules, Particles & Pronunciation Flow (4 lessons)
- Phase 5-13: JLPT N5 Conversational Mastery (31 lessons)
Total: 13 Parts, 53 Comprehensive Lessons
Target: android/app/src/main/assets/spoken_japanese_foundations.json
"""
import json
import os
import sys

sys.stdout.reconfigure(encoding='utf-8')

DEST_FILE = 'android/app/src/main/assets/spoken_japanese_foundations.json'

course_metadata = {
    "id": "jp-spoken-foundations",
    "target_lang": "ja",
    "base_lang": "bn",
    "title_bn": "জাপানিজ স্পোকেন: Zero to Reading & Foundations (JLPT N5)",
    "title_target": "Japanese Zero-to-Reading & Foundations Masterclass",
    "source": "Curated from Bengali-Japanese Extended Master Framework",
    "note": "অক্ষর না চেনা সম্পূর্ণ নতুনদের জন্য শূন্য থেকে হিরাগানা ও কাতাকানা, শুদ্ধ উচ্চারণবিধি, দেখে দেখে রিডিং প্র্যাকটিস এবং JLPT N5 মৌলিক স্পোকেন দক্ষতা।",
    "welcome_text": "জাপানিজ জিরো-টু-রিডিং মাস্টারক্লাসে আপনাকে স্বাগতম! প্রতিটি বর্ণ, শব্দ ও বাক্য মন দিয়ে শুনুন এবং অডিওর সাথে সাথে জোরে জোরে মুখে উচ্চারণ করুন।"
}

ladder_default = [
    {"play": "target", "speed": 0.85},
    {"play": "bn", "speed": 1.15},
    {"play": "target", "speed": 0.95},
    {"play": "target", "speed": 1.05},
    {"play": "target", "speed": 1.15, "min_level": "A2"},
    {"pause_ms": 1200}
]

def make_item(item_id, target, target_kana, romaji, bn, bn_pron, tokens_tuples=None, sentence_type="assertive", polarity="affirmative", tense="present_simple", item_type="sentence", level="A1"):
    if tokens_tuples is None:
        tokens = [{"t": target, "romaji": romaji, "kanji": target, "bn": bn}]
    else:
        tokens = [{"t": t[0], "romaji": t[1], "kanji": t[2], "bn": t[3]} for t in tokens_tuples]
    
    tags = {
        "sentence_type": sentence_type,
        "polarity": polarity,
        "tense": tense,
        "jlpt": "N5"
    }
    return {
        "id": item_id,
        "concept_id": f"c-{item_id}",
        "order": 1,
        "type": item_type,
        "level": level,
        "target": target,
        "target_kana": target_kana,
        "romaji": romaji,
        "bn": bn,
        "bn_pron": bn_pron,
        "ipa": romaji,
        "tokens": tokens,
        "status": "reviewed",
        "reviewFlags": "",
        "tags": tags
    }

parts = []

# ==============================================================================
# PART 1: হিরাগানা মৌলিক বর্ণমালা ও স্বরধ্বনি (Hiragana 46 Basic Sounds & Mora Vowels)
# ==============================================================================
p1_lessons = [
    {
        "id": "jp-foundations-l01",
        "order": 1,
        "title_bn": "৫টি মৌলিক স্বরবর্ণ ও মোরা টাইমিং (あ い う え お)",
        "title_target": "5 Pure Japanese Vowels & Mora Timing (A, I, U, E, O)",
        "intro_bn": "জাপানি ভাষায় ৫টি মূল স্বরবর্ণ রয়েছে: あ (a - আ), い (i - ই), う (u - উ), え (e - এ), お (o - ও)। জাপানিজে প্রতিটি অক্ষরের উচ্চারণ সমান সময়কাল (Mora) ধরে স্থিরভাবে করতে হয়।",
        "structure": ["Pure Vowels: あ (a), い (i), う (u), え (e), お (o)"],
        "items": [
            make_item("jp-p1-l1-001", "あ、い、う、え、お", "あ、い、う、え、お", "a, i, u, e, o", "আ, ই, উ, এ, ও (৫টি মৌলিক স্বরধ্বনি)", "আ, ই, উ, এ, ও", [("あ", "a", "あ", "আ"), ("い", "i", "い", "ই"), ("う", "u", "う", "উ"), ("え", "e", "え", "এ"), ("お", "o", "お", "ও")], item_type="syllable_ladder"),
            make_item("jp-p1-l1-002", "あさ (asa)", "あさ", "asa", "সকাল", "আসা", [("あ", "a", "あ", "আ"), ("さ", "sa", "さ", "সা")], item_type="word"),
            make_item("jp-p1-l1-003", "いえ (ie)", "いえ", "ie", "বাড়ি / ঘর", "ইয়ে", [("い", "i", "い", "ই"), ("え", "e", "え", "এ")], item_type="word"),
            make_item("jp-p1-l1-004", "うみ (umi)", "うみ", "umi", "সমুদ্র", "উমি", [("う", "u", "う", "উ"), ("み", "mi", "み", "মি")], item_type="word"),
            make_item("jp-p1-l1-005", "えき (eki)", "えき", "eki", "রেল স্টেশন", "একি", [("え", "e", "え", "এ"), ("き", "ki", "き", "কি")], item_type="word"),
            make_item("jp-p1-l1-006", "おと (oto)", "おと", "oto", "শব্দ / আওয়াজ", "ওতো", [("お", "o", "お", "ও"), ("と", "to", "と", "তো")], item_type="word"),
            make_item("jp-p1-l1-007", "あさ、あめが ふります。", "あさ、あめがふります。", "Asa, ame ga furimasu.", "সকালে বৃষ্টি হয়।", "আসা, আমে গা ফুরিমাসু।", [("あさ", "asa", "朝", "সকাল"), ("あめ", "ame", "雨", "বৃষ্টি"), ("が", "ga", "が", "টি"), ("ふります", "furimasu", "降ります", "পড়ে/হয়")]),
            make_item("jp-p1-l1-008", "いえで うたを うたいます。", "いえでうたをうたいます。", "Ie de uta o utaimasu.", "বাড়িতে গান গাই।", "ইয়ে দে উতা ও উতাইমাসু।", [("いえ", "ie", "家", "বাড়ি"), ("で", "de", "で", "এ"), ("うた", "uta", "歌", "গান"), ("を", "o", "を", "কে"), ("うたいます", "utaimasu", "歌います", "গাই")])
        ]
    },
    {
        "id": "jp-foundations-l02",
        "order": 2,
        "title_bn": "Ka-সারি: K-ধ্বনি ও শব্দ পাঠ (か き く け こ)",
        "title_target": "Ka-Row: Clear K-Sounds & Word Formation (Ka, Ki, Ku, Ke, Ko)",
        "intro_bn": "K-ধ্বনি যুক্ত ৫টি বর্ণ: か (ka), き (ki), く (ku), け (ke), こ (ko)। কণ্ঠনালী থেকে স্পষ্ট ক-ধ্বনি উচ্চারিত হয়।",
        "structure": ["Ka-Row: か (ka), き (ki), く (ku), け (ke), こ (ko)"],
        "items": [
            make_item("jp-p1-l2-001", "か、き、く、け、こ", "か、き、く、け、こ", "ka, ki, ku, ke, ko", "কা, কি, কু, কে, কো (Ka সারি)", "কা, কি, কু, কে, কো", [("か", "ka", "か", "কা"), ("き", "ki", "き", "কি"), ("く", "ku", "く", "কু"), ("け", "ke", "け", "কে"), ("こ", "ko", "こ", "কো")], item_type="syllable_ladder"),
            make_item("jp-p1-l2-002", "かさ (kasa)", "かさ", "kasa", "ছাতা", "কাসা", [("か", "ka", "か", "কা"), ("さ", "sa", "さ", "সা")], item_type="word"),
            make_item("jp-p1-l2-003", "きく (kiku)", "きく", "kiku", "শোনা / গান শোনা", "কিকু", [("き", "ki", "き", "কি"), ("く", "ku", "く", "কু")], item_type="word"),
            make_item("jp-p1-l2-004", "くるま (kuruma)", "くるま", "kuruma", "গাড়ি", "কুরুমা", [("く", "ku", "車", "গাড়ি"), ("る", "ru", "る", "রু"), ("ま", "ma", "ま", "মা")], item_type="word"),
            make_item("jp-p1-l2-005", "けさ (kesa)", "けさ", "kesa", "আজ সকাল", "কেসা", [("け", "ke", "け", "কে"), ("さ", "sa", "さ", "সা")], item_type="word"),
            make_item("jp-p1-l2-006", "こえ (koe)", "こえ", "koe", "গলার আওয়াজ / কণ্ঠস্বর", "কোয়ে", [("こ", "ko", "声", "কণ্ঠ"), ("え", "e", "え", "এ")], item_type="word"),
            make_item("jp-p1-l2-007", "あかい かさを かいます。", "あかいかさをかいます。", "Akai kasa o kaimasu.", "লাল ছাতা কিনি।", "আকাই কাসা ও কাইমাসু।", [("あかい", "akai", "赤い", "লাল"), ("かさ", "kasa", "傘", "ছাতা"), ("を", "o", "を", "কে"), ("かいます", "kaimasu", "買います", "কিনি")])
        ]
    },
    {
        "id": "jp-foundations-l03",
        "order": 3,
        "title_bn": "Sa-সারি ও তালব্য 'し' (さ し す せ そ)",
        "title_target": "Sa-Row & The Palatal 'shi' Sound (Sa, Shi, Su, Se, So)",
        "intro_bn": "さ (sa), し (shi), す (su), せ (se), そ (so)। মনে রাখবেন 'し' কখনোই দাঁতে ঘষা 'সি' নয়, বরং নরম তালব্য 'শি' (ইংরেজি she-এর মতো)।",
        "structure": ["Sa-Row: さ (sa), し (shi - তালব্য শি), す (su), せ (se), そ (so)"],
        "items": [
            make_item("jp-p1-l3-001", "さ、し、す、せ、そ", "さ、し、す、せ、そ", "sa, shi, su, se, so", "সা, শি, সু, সে, সো (Sa সারি; し=শি)", "সা, শি, সু, সে, সো", [("さ", "sa", "さ", "সা"), ("し", "shi", "し", "শি"), ("す", "su", "す", "সু"), ("せ", "se", "せ", "সে"), ("そ", "so", "そ", "সো")], item_type="syllable_ladder"),
            make_item("jp-p1-l3-002", "さけ (sake)", "さけ", "sake", "স্যামন মাছ / জাপানি পানীয়", "সাকে", [("さ", "sa", "さ", "সা"), ("け", "ke", "け", "কে")], item_type="word"),
            make_item("jp-p1-l3-003", "しお (shio)", "しお", "shio", "লবণ", "শিও", [("し", "shi", "塩", "লবণ"), ("お", "o", "お", "ও")], item_type="word"),
            make_item("jp-p1-l3-004", "すし (sushi)", "すし", "sushi", "সুশি (ঐতিহ্যবাহী খাবার)", "সুশি", [("す", "su", "す", "সু"), ("し", "shi", "し", "শি")], item_type="word"),
            make_item("jp-p1-l3-005", "せかい (sekai)", "せかい", "sekai", "পৃথিবী / বিশ্ব", "সেকাই", [("せ", "se", "世", "বিশ্ব"), ("かい", "kai", "界", "জগৎ")], item_type="word"),
            make_item("jp-p1-l3-006", "そこ (soko)", "そこ", "soko", "সেখানে", "সোকো", [("そ", "so", "そ", "সো"), ("こ", "ko", "こ", "কো")], item_type="word"),
            make_item("jp-p1-l3-007", "すしを たべます。", "すしをたべます。", "Sushi o tabemasu.", "সুশি খাই।", "সুশি ও তাবেমাসু।", [("すし", "sushi", "寿司", "সুশি"), ("を", "o", "を", "কে"), ("たべます", "tabemasu", "食べます", "খাই")])
        ]
    },
    {
        "id": "jp-foundations-l04",
        "order": 4,
        "title_bn": "Ta-সারি ও বিশেষ ধ্বনি 'ち chi' ও 'つ tsu' (た ち つ て と)",
        "title_target": "Ta-Row: Focus on 'chi' & The Sibilant 'tsu' (Ta, Chi, Tsu, Te, To)",
        "intro_bn": "た (ta), ち (chi), つ (tsu), て (te), と (to)। 'ち' হলো 'চি' এবং 'つ' হলো দাঁতের গোড়ায় জিভ রেখে হিসহিস শব্দে 'ৎসু' (tsu)। এটি বাঙালি শিক্ষার্থীদের অন্যতম প্রধান শেখার বিষয়।",
        "structure": ["Ta-Row: た (ta), ち (chi), つ (tsu), て (te), と (to)"],
        "items": [
            make_item("jp-p1-l4-001", "た、ち、つ、て、と", "た、ち、つ、て、と", "ta, chi, tsu, te, to", "তা, চি, ৎসু, তে, তো (Ta সারি; ち=চি, つ=ৎসু)", "তা, চি, ৎসু, তে, তো", [("た", "ta", "た", "তা"), ("ち", "chi", "ち", "চি"), ("つ", "tsu", "つ", "ৎসু"), ("て", "te", "て", "তে"), ("と", "to", "と", "তো")], item_type="syllable_ladder"),
            make_item("jp-p1-l4-002", "たまご (tamago)", "たまご", "tamago", "ডিম", "তামাগো", [("た", "ta", "卵", "ডিম"), ("ま", "ma", "ま", "মা"), ("ご", "go", "ご", "গো")], item_type="word"),
            make_item("jp-p1-l4-003", "ちち (chichi)", "ちち", "chichi", "আমার বাবা", "চিচি", [("ち", "chi", "父", "বাবা"), ("ち", "chi", "ち", "চি")], item_type="word"),
            make_item("jp-p1-l4-004", "つき (tsuki)", "つき", "tsuki", "চাঁদ", "ৎসুকি", [("つ", "tsu", "月", "চাঁদ"), ("き", "ki", "き", "কি")], item_type="word"),
            make_item("jp-p1-l4-005", "て (te)", "て", "te", "হাত", "তে", [("て", "te", "手", "হাত")], item_type="word"),
            make_item("jp-p1-l4-006", "とり (tori)", "とり", "tori", "পাখি", "তোরি", [("と", "to", "鳥", "পাখি"), ("り", "ri", "り", "রি")], item_type="word"),
            make_item("jp-p1-l4-007", "つくえで べんきょうします。", "つくえでべんきょうします。", "Tsukue de benkyou shimasu.", "পড়ার টেবিলে পড়াশোনা করি।", "ৎসুকুয়ে দে বেনকিয়োও শিমাসু।", [("つくえ", "tsukue", "机", "পড়ার টেবিল"), ("で", "de", "で", "এ"), ("べんきょうします", "benkyou shimasu", "勉強します", "পড়ি")])
        ]
    },
    {
        "id": "jp-foundations-l05",
        "order": 5,
        "title_bn": "Na-সারি: নাসিক্য ধ্বনি ও শব্দ গঠন (な に ぬ ね の)",
        "title_target": "Na-Row: Pure Nasals & Core Words (Na, Ni, Nu, Ne, No)",
        "intro_bn": "な (na), に (ni), ぬ (nu), ね (ne), の (no)। প্রতিটি অক্ষরের বাঁক ও মোচড় সুন্দরভাবে খেয়াল করুন।",
        "structure": ["Na-Row: な (na), に (ni), ぬ (nu), ね (ne), の (no)"],
        "items": [
            make_item("jp-p1-l5-001", "な、に、ぬ、ね、の", "な、に、ぬ、ね、の", "na, ni, nu, ne, no", "না, নি, নু, নে, নো (Na সারি)", "না, নি, নু, নে, নো", [("な", "na", "な", "না"), ("に", "ni", "に", "নি"), ("ぬ", "nu", "ぬ", "নু"), ("ね", "ne", "ね", "নে"), ("の", "no", "の", "নো")], item_type="syllable_ladder"),
            make_item("jp-p1-l5-002", "なつ (natsu)", "なつ", "natsu", "গ্রীষ্মকাল", "নাৎসু", [("な", "na", "夏", "গ্রীষ্ম"), ("つ", "tsu", "つ", "ৎসু")], item_type="word"),
            make_item("jp-p1-l5-003", "にく (niku)", "にく", "niku", "মাংস", "নিকু", [("に", "ni", "肉", "মাংস"), ("く", "ku", "く", "কু")], item_type="word"),
            make_item("jp-p1-l5-004", "いぬ (inu)", "いぬ", "inu", "কুকুর", "ইনু", [("い", "i", "い", "ই"), ("ぬ", "nu", "犬", "কুকুর")], item_type="word"),
            make_item("jp-p1-l5-005", "ねこ (neko)", "ねこ", "neko", "বিড়াল", "নেকো", [("ね", "ne", "猫", "বিড়াল"), ("こ", "ko", "こ", "কো")], item_type="word"),
            make_item("jp-p1-l5-006", "のみもの (nomimono)", "のみもの", "nomimono", "পানীয়", "নোমিমোনো", [("の", "no", "飲", "পান"), ("み", "mi", "み", "মি"), ("もの", "mono", "物", "জিনিস")], item_type="word"),
            make_item("jp-p1-l5-007", "ねこと いぬが います。", "ねこといぬがいます。", "Neko to inu ga imasu.", "বিড়াল ও কুকুর আছে।", "নেকো তো ইনু গা ইমাসু।", [("ねこ", "neko", "猫", "বিড়াল"), ("と", "to", "と", "ও"), ("いぬ", "inu", "犬", "কুকুর"), ("が", "ga", "が", "টি"), ("います", "imasu", "います", "আছে")])
        ]
    },
    {
        "id": "jp-foundations-l06",
        "order": 6,
        "title_bn": "Ha-সারি ও ফুঁ দেওয়ার মতো দ্ব্যোষ্ঠ 'ふ fu' (は ひ ふ へ ほ)",
        "title_target": "Ha-Row & The Bilabial Fricative 'fu' (Ha, Hi, Fu, He, Ho)",
        "intro_bn": "は (ha), ひ (hi), ふ (fu), へ (he), ほ (ho)। 'ふ' উচ্চারণে দাঁত ও ঠোঁট না লাগিয়ে মোমবাতি নেভানোর মতো হালকা ফুঁ দিয়ে 'ফু' বলতে হয়।",
        "structure": ["Ha-Row: は (ha), ひ (hi), ふ (fu - দ্ব্যোষ্ঠ ফু), へ (he), ほ (ho)"],
        "items": [
            make_item("jp-p1-l6-001", "は、ひ、ふ、へ、ほ", "は、ひ、ふ、へ、ほ", "ha, hi, fu, he, ho", "হা, হি, ফু, হে, হো (Ha সারি; ふ=দ্ব্যোষ্ঠ ফু)", "হা, হি, ফু, হে, হো", [("は", "ha", "は", "হা"), ("ひ", "hi", "ひ", "হি"), ("ふ", "fu", "ふ", "ফু"), ("へ", "he", "へ", "হে"), ("ほ", "ho", "ほ", "হো")], item_type="syllable_ladder"),
            make_item("jp-p1-l6-002", "はな (hana)", "はな", "hana", "ফুল / নাক", "হানা", [("は", "ha", "花", "ফুল"), ("な", "na", "な", "না")], item_type="word"),
            make_item("jp-p1-l6-003", "ひと (hito)", "ひと", "hito", "মানুষ / ব্যক্তি", "হিতো", [("ひ", "hi", "人", "মানুষ"), ("と", "to", "と", "তো")], item_type="word"),
            make_item("jp-p1-l6-004", "ふね (fune)", "ふね", "fune", "নৌকা / জাহাজ", "ফুনে", [("ふ", "fu", "船", "নৌকা"), ("ね", "ne", "ね", "নে")], item_type="word"),
            make_item("jp-p1-l6-005", "へや (heya)", "へや", "heya", "ঘর / রুম", "হেয়া", [("へ", "he", "部", "অংশ"), ("や", "ya", "屋", "কক্ষ")], item_type="word"),
            make_item("jp-p1-l6-006", "ほし (hoshi)", "ほし", "hoshi", "তারা / নক্ষত্র", "হোশি", [("ほ", "ho", "星", "তারা"), ("し", "shi", "し", "শি")], item_type="word"),
            make_item("jp-p1-l6-007", "へやに はなが あります。", "へやにはながあります。", "Heya ni hana ga arimasu.", "ঘরে সুন্দর ফুল আছে।", "হেয়া নি হানা গা আরিমাসু।", [("へや", "heya", "部屋", "ঘর"), ("に", "ni", "に", "এ"), ("はな", "hana", "花", "ফুল"), ("が", "ga", "が", "টি"), ("あります", "arimasu", "あります", "আছে")])
        ]
    },
    {
        "id": "jp-foundations-l07",
        "order": 7,
        "title_bn": "Ma-সারি: M-ধ্বনি ও শব্দ পাঠ (ま み む め も)",
        "title_target": "Ma-Row: Bilabial Nasal Sounds (Ma, Mi, Mu, Me, Mo)",
        "intro_bn": "ま (ma), み (mi), む (mu), め (me), も (mo)। দুই ঠোঁট চেপে নরম ম-ধ্বনি তৈরি হয়।",
        "structure": ["Ma-Row: ま (ma), み (mi), む (mu), め (me), も (mo)"],
        "items": [
            make_item("jp-p1-l7-001", "ま、み、む、め、も", "ま、み、む、め、も", "ma, mi, mu, me, mo", "মা, মি, মু, মে, মো (Ma সারি)", "মা, মি, মু, মে, মো", [("ま", "ma", "ま", "মা"), ("み", "mi", "み", "মি"), ("む", "mu", "む", "মু"), ("め", "me", "め", "মে"), ("も", "mo", "も", "মো")], item_type="syllable_ladder"),
            make_item("jp-p1-l7-002", "まち (machi)", "まち", "machi", "শহর / জনপদ", "মাচি", [("ま", "ma", "町", "শহর"), ("ち", "chi", "ち", "চি")], item_type="word"),
            make_item("jp-p1-l7-003", "みず (mizu)", "みず", "mizu", "পানি / জল", "মিজু", [("み", "mi", "水", "পানি"), ("ず", "zu", "ず", "জু")], item_type="word"),
            make_item("jp-p1-l7-004", "むし (mushi)", "むし", "mushi", "কীটপতঙ্গ / পোকা", "মুশি", [("む", "mu", "虫", "পোকা"), ("し", "shi", "し", "শি")], item_type="word"),
            make_item("jp-p1-l7-005", "め (me)", "め", "me", "চোখ", "মে", [("め", "me", "目", "চোখ")], item_type="word"),
            make_item("jp-p1-l7-006", "もの (mono)", "もの", "mono", "জিনিস / বস্তু", "মোনো", [("も", "mo", "物", "জিনিস"), ("の", "no", "の", "নো")], item_type="word"),
            make_item("jp-p1-l7-007", "まちの みずを のみます。", "まちのみずをのみます。", "Machi no mizu o nomimasu.", "শহরের পানি পান করি।", "মাচি নো মিজু ও নোমিমাসু।", [("まち", "machi", "町", "শহর"), ("の", "no", "の", "এর"), ("みず", "mizu", "水", "পানি"), ("を", "o", "を", "কে"), ("のみます", "nomimasu", "飲みます", "পান করি")])
        ]
    },
    {
        "id": "jp-foundations-l08",
        "order": 8,
        "title_bn": "Ya, Ra, Wa সারি ও জাপানি ফ্ল্যাপ 'R' (や ゆ よ / ら り る れ ろ / わ を)",
        "title_target": "Ya, Ra, Wa Rows & The Japanese Alveolar Flap (R/L Sound)",
        "intro_bn": "や (ya), ゆ (yu), よ (yo), ら (ra), り (ri), る (ru), れ (re), ろ (ro), わ (wa), を (o)। 'ら' সারির অক্ষরগুলোতে জিভের ডগা উপরের তালুতে আলতো এক টোকায় উচ্চারণ করতে হয়—এটি ইংরেজি R বা বাংলা 'র' নয়!",
        "structure": ["Ya: や ゆ よ", "Ra: ら り る れ ろ (Flap)", "Wa: わ を"],
        "items": [
            make_item("jp-p1-l8-001", "や、ゆ、よ", "や、ゆ、よ", "ya, yu, yo", "ইয়া, ইউ, ইয়ো (Ya সারি)", "ইয়া, ইউ, ইয়ো", [("や", "ya", "や", "ইয়া"), ("ゆ", "yu", "ゆ", "ইউ"), ("よ", "yo", "よ", "ইয়ো")], item_type="syllable_ladder"),
            make_item("jp-p1-l8-002", "ら、り、る、れ、ろ", "ら、り、る、れ、ろ", "ra, ri, ru, re, ro", "রা, রি, রু, রে, রো (জিহ্বার ডগায় এক টোকা)", "রা, রি, রু, রে, রো", [("ら", "ra", "ら", "রা"), ("り", "ri", "り", "রি"), ("る", "ru", "る", "রু"), ("れ", "re", "れ", "রে"), ("ろ", "ro", "ろ", "রো")], item_type="syllable_ladder"),
            make_item("jp-p1-l8-003", "わ、を", "わ、を", "wa, o", "ওয়া, ও (Wa সারি)", "ওয়া, ও", [("わ", "wa", "わ", "ওয়া"), ("を", "o", "を", "ও")], item_type="syllable_ladder"),
            make_item("jp-p1-l8-004", "やま (yama)", "やま", "yama", "পাহাড়", "ইয়ামা", [("や", "ya", "山", "পাহাড়"), ("ま", "ma", "ま", "মা")], item_type="word"),
            make_item("jp-p1-l8-005", "ゆめ (yume)", "ゆめ", "yume", "স্বপ্ন", "ইউমে", [("ゆ", "yu", "夢", "স্বপ্ন"), ("め", "me", "め", "মে")], item_type="word"),
            make_item("jp-p1-l8-006", "よる (yoru)", "よる", "yoru", "রাত / রাত্রি", "ইয়োরু", [("よ", "yo", "夜", "রাত"), ("る", "ru", "る", "রু")], item_type="word"),
            make_item("jp-p1-l8-007", "さくら (sakura)", "さくら", "sakura", "চেরি ফুল (জাপানের জাতীয় প্রতীক)", "সাকুরা", [("さ", "sa", "桜", "চেরি ফুল"), ("く", "ku", "く", "কু"), ("ら", "ra", "ら", "রা")], item_type="word"),
            make_item("jp-p1-l8-008", "かわ (kawa)", "かわ", "kawa", "নদী", "কাওয়া", [("か", "ka", "川", "নদী"), ("わ", "wa", "わ", "ওয়া")], item_type="word")
        ]
    },
    {
        "id": "jp-foundations-l09",
        "order": 9,
        "title_bn": "অনুনাসিক মোরা 'ん n' ও হিরাগানা ৪৬টি বর্ণের পূর্ণাঙ্গ রিডিং ড্রিল",
        "title_target": "The Moraic Nasal 'n' (ん) & Full 46 Kana Sight-Reading Drill",
        "intro_bn": "ん (n) একা শব্দ শুরু করে না; পরের বর্ণের ওপর নির্ভর করে এটি m (যেমন: えんぴつ enpitsu), n (যেমন: おんな onna) বা ng (যেমন: ほん hon) ধ্বনি ধারণ করে।",
        "structure": ["Nasal Mora: ん (n/m/ng)", "46 Kana Comprehensive Sight Reading"],
        "items": [
            make_item("jp-p1-l9-001", "ん (n)", "ん", "n", "ন্‌ / ং (অনুনাসিক মোরা ধ্বনি)", "ন্‌", item_type="syllable_ladder"),
            make_item("jp-p1-l9-002", "ほん (hon)", "ほん", "hon", "বই (শেষে ng-এর মতো অনুরণন)", "হোং", [("ほ", "ho", "本", "বই"), ("ん", "n", "ん", "ং")], item_type="word"),
            make_item("jp-p1-l9-003", "えんぴつ (enpitsu)", "えんぴつ", "enpitsu", "পেন্সিল (p-এর আগে m-এর মতো উচ্চারণ)", "এম্পিৎসু", [("えん", "en", "鉛", "সীসা"), ("ぴつ", "pitsu", "筆", "কলম")], item_type="word"),
            make_item("jp-p1-l9-004", "おんな (onna)", "おんな", "onna", "নারী / মহিলা (n-এর আগে খাঁটি n)", "ওন্না", [("おん", "on", "女", "নারী"), ("な", "na", "な", "না")], item_type="word"),
            make_item("jp-p1-l9-005", "しんぶん (shinbun)", "しんぶん", "shinbun", "সংবাদপত্র / খবরের কাগজ", "শিম্বুন", [("しん", "shin", "新", "সংবাদ"), ("ぶん", "bun", "聞", "কাগজ")], item_type="word"),
            make_item("jp-p1-l9-006", "にほん (nihon)", "にほん", "nihon", "জাপান দেশ", "নিহোং", [("に", "ni", "日", "সূর্য"), ("ほん", "hon", "本", "উৎস")], item_type="word"),
            make_item("jp-p1-l9-007", "にほんで ほんを よみます。", "にほんでほんをよみます。", "Nihon de hon o yomimasu.", "জাপানে বসে বই পড়ি।", "নিহোং দে হোং ও ইয়োমিমাসু।", [("にほん", "nihon", "日本", "জাপান"), ("で", "de", "で", "এ"), ("ほん", "hon", "本", "বই"), ("を", "o", "কে", "কে"), ("よみます", "yomimasu", "読みます", "পড়ি")])
        ]
    }
]
parts.append({
    "id": "jp-foundations-p1",
    "order": 1,
    "level": "A1",
    "title_bn": "হিরাগানা মৌলিক বর্ণমালা ও স্বরধ্বনি (Hiragana 46 Basic Sounds & Mora Vowels)",
    "title_target": "Hiragana 46 Basic Sounds & Mora Vowels (A-N Complete Matrix)",
    "lessons": p1_lessons
})

# ==============================================================================
# PART 2: পরিবর্তিত ধ্বনি, দ্বিত্ব ব্যঞ্জন ও যুক্তাক্ষর (Dakuon, Sokuon, Youon & Chouon)
# ==============================================================================
p2_lessons = [
    {
        "id": "jp-foundations-l10",
        "order": 1,
        "title_bn": "ঘোষ ধ্বনি বা ডাকুরন ও হান-ডাকুরন (が, ざ, だ, ば, ぱ)",
        "title_target": "Voiced Sounds (Dakuon ゛) & Semi-Voiced Sounds (Handakuon ゜)",
        "intro_bn": "অক্ষরের ডানে তেনতেন (゛) দিলে গ, জ, দ, ব হয় এবং মারু (゜) দিলে প হয়।",
        "structure": ["が ぎ ぐ げ ご (ga gi gu ge go)", "ざ じ ず ぜ ぞ (za ji zu ze zo)", "だ ぢ づ で ど (da ji zu de do)", "ば び ぶ べ ぼ (ba bi bu be bo)", "ぱ ぴ ぷ ぺ ぽ (pa pi pu pe po)"],
        "items": [
            make_item("jp-p2-l10-001", "が、ぎ、ぐ、げ、ご", "が、ぎ、ぐ、げ、ご", "ga, gi, gu, ge, go", "গা, গি, গু, গে, গো (Ga সারি)", "গা, গি, গু, গে, গো", item_type="syllable_ladder"),
            make_item("jp-p2-l10-002", "ざ、じ、ず、ぜ、ぞ", "ざ、じ、ず、ぜ、ぞ", "za, ji, zu, ze, zo", "জা, জি, জু, জে, জো (Za সারি)", "জা, জি, জু, জে, জো", item_type="syllable_ladder"),
            make_item("jp-p2-l10-003", "だ、ぢ、づ、で、ど", "だ、ぢ、づ、で、ど", "da, ji, zu, de, do", "দা, জি, জু, দে, দো (Da সারি)", "দা, জি, জু, দে, দো", item_type="syllable_ladder"),
            make_item("jp-p2-l10-004", "ば、び、ぶ、べ、ぼ", "ば、び、ぶ、べ、ぼ", "ba, bi, bu, be, bo", "বা, বি, বু, বে, বো (Ba সারি)", "বা, বি, বু, বে, বো", item_type="syllable_ladder"),
            make_item("jp-p2-l10-005", "ぱ、ぴ、ぷ、ぺ、ぽ", "ぱ、ぴ、ぷ、ぺ、ぽ", "pa, pi, pu, pe, po", "পা, পি, পু, পে, পো (Pa সারি)", "পা, পি, পু, পে, পো", item_type="syllable_ladder"),
            make_item("jp-p2-l10-006", "えんぴつ (enpitsu)", "えんぴつ", "enpitsu", "পেনসিল", "এম্পিৎসু", [("えん", "en", "鉛", "সীসা"), ("ぴつ", "pitsu", "筆", "কলম")], item_type="word"),
            make_item("jp-p2-l10-007", "かばん (kaban)", "かばん", "kaban", "ব্যাগ", "কাবাং", [("か", "ka", "か", "কা"), ("ばん", "ban", "ばん", "বাং")], item_type="word"),
            make_item("jp-p2-l10-008", "ごはん (gohan)", "ごはん", "gohan", "ভাত / আহার", "গোহাং", [("ご", "go", "御", "ভদ্র"), ("はん", "han", "飯", "ভাত")], item_type="word"),
            make_item("jp-p2-l10-009", "みどり (midori)", "みどり", "midori", "সবুজ রঙ", "মিদোরি", [("み", "mi", "緑", "সবুজ"), ("どり", "dori", "どり", "দোরি")], item_type="word"),
            make_item("jp-p2-l10-010", "かぜ (kaze)", "かぜ", "kaze", "বাতাস / সর্দি", "কাজে", [("か", "ka", "風", "বাতাস"), ("ぜ", "ze", "ぜ", "জে")], item_type="word")
        ]
    },
    {
        "id": "jp-foundations-l11",
        "order": 2,
        "title_bn": "ছোট 'ৎসু' বা দ্বিত্ব ব্যঞ্জনধ্বনি (Sokuon っ - Double Consonant)",
        "title_target": "The Small Tsu (Sokuon っ) Double Consonants & 1 Mora Pause",
        "intro_bn": "ছোট 'っ' (tsu) নিজে উচ্চারিত হয় না, বরং পরের ব্যঞ্জনধ্বনিকে দ্বিগুণ করে এবং ঠিক ১ মোরা নীরব বিরতি সৃষ্টি করে।",
        "structure": ["Double Consonant: っ + k/s/t/p sound"],
        "items": [
            make_item("jp-p2-l11-001", "きって (kitte)", "きって", "kitte", "ডাকটিকিট (১ মোরা বিরতি সহ)", "কিত্‌তে", [("き", "ki", "切", "কাটা"), ("って", "tte", "手", "টিকিট")], item_type="word"),
            make_item("jp-p2-l11-002", "きて (kite)", "きて", "kite", "আসুন (বিরতিহীন শব্দ)", "কিতে", [("き", "ki", "来", "আসা"), ("て", "te", "て", "তে")], item_type="word"),
            make_item("jp-p2-l11-003", "ざっし (zasshi)", "ざっし", "zasshi", "ম্যাগাজিন", "জাশ্‌শি", [("ざっ", "za", "雑", "বিবিধ"), ("し", "shi", "誌", "পত্র")], item_type="word"),
            make_item("jp-p2-l11-004", "がっこう (gakkou)", "がっこう", "gakkou", "বিদ্যালয় / স্কুল", "গাক্‌কোও", [("がっ", "ga", "学", "শিক্ষা"), ("こう", "kou", "校", "স্কুল")], item_type="word"),
            make_item("jp-p2-l11-005", "ちょっと まって ください。", "ちょっとまってください。", "Chotto matte kudasai.", "একটু অপেক্ষা করুন।", "চোত্তো মাত্তে কুদাসাই।", [("ちょっと", "chotto", "一寸", "একটু"), ("まって", "matte", "待って", "অপেক্ষা করে"), ("ください", "kudasai", "下さい", "দয়া করে")])
        ]
    },
    {
        "id": "jp-foundations-l12",
        "order": 3,
        "title_bn": "যুক্তাক্ষর ধ্বনি (Youon きゃ, しゅ, ちょ, りょ, びょ)",
        "title_target": "Contracted Sounds (Youon) with Small ya, yu, yo",
        "intro_bn": "ই-স্তম্ভের অক্ষরের সাথে ছোট ゃ, ゅ, ょ যুক্ত হয়ে ১ মোরা যুক্তধ্বনি তৈরি করে।",
        "structure": ["i-Column Kana + small ゃ (ya) / ゅ (yu) / ょ (yo)"],
        "items": [
            make_item("jp-p2-l12-001", "きゃ、きゅ、きょ", "きゃ、きゅ、きょ", "kya, kyu, kyo", "ক্যা, কিউ, কিয়ো", "ক্যা, কিউ, কিয়ো", item_type="syllable_ladder"),
            make_item("jp-p2-l12-002", "しゃ、しゅ、しょ", "しゃ、しゅ、しょ", "sha, shu, sho", "শা, শু, শো", "শা, শু, শো", item_type="syllable_ladder"),
            make_item("jp-p2-l12-003", "ちゃ、ちゅ、ちょ", "ちゃ、ちゅ、ちょ", "cha, chu, cho", "চা, চু, চো", "চা, চু, চো", item_type="syllable_ladder"),
            make_item("jp-p2-l12-004", "おちゃ (ocha)", "おちゃ", "ocha", "গ্রিন টি / চা", "ওচা", [("お", "o", "お", "ভদ্র"), ("ちゃ", "cha", "茶", "চা")], item_type="word"),
            make_item("jp-p2-l12-005", "しゃしん (shashin)", "しゃしん", "shashin", "ছবি / ফটোগ্রাফ", "শাশিন", [("しゃ", "sha", "写", "তোলা"), ("しん", "shin", "真", "সত্য")], item_type="word"),
            make_item("jp-p2-l12-006", "じしょ (jisho)", "じしょ", "jisho", "অভিধান (ডিকশনারি)", "জিশো", [("じ", "ji", "辞", "শব্দ"), ("しょ", "sho", "書", "বই")], item_type="word"),
            make_item("jp-p2-l12-007", "きょうしつで べんきょうします。", "きょうしつでべんきょうします。", "Kyoushitsu de benkyou shimasu.", "শ্রেণিকক্ষে পড়াশোনা করি।", "কিয়োওশিতসু দে বেনকিয়োও শিমাসু।", [("きょうしつ", "kyoushitsu", "教室", "ক্লাসরুম"), ("で", "de", "で", "এ"), ("べんきょうします", "benkyou shimasu", "勉強します", "পড়াশোনা করি")])
        ]
    },
    {
        "id": "jp-foundations-l13",
        "order": 4,
        "title_bn": "দীর্ঘ স্বরধ্বনি ও অর্থ পরিবর্তন (Chouon - Long Vowels)",
        "title_target": "Long Vowels (Chouon) & Crucial Meaning Shifts (2 Moras Duration)",
        "intro_bn": "দীর্ঘ স্বর উচ্চারণে পুরো ২ মোরা সময় দিতে হয়। দীর্ঘ না টানলে শব্দের অর্থ বদলে যায়!",
        "structure": ["Long Vowel (2 Moras Duration)"],
        "items": [
            make_item("jp-p2-l13-001", "おばさん (obasan)", "おばさん", "obasan", "খালা / ফুপু / চাচি (সংক্ষিপ্ত স্বর)", "ওবাসাং", item_type="word"),
            make_item("jp-p2-l13-002", "おばあさん (obaasan)", "おばあさん", "obaasan", "দাদি / নানি / বৃদ্ধা (দীর্ঘ স্বর ২ মোরা)", "ওবাআসাং", item_type="word"),
            make_item("jp-p2-l13-003", "おじさん (ojisan)", "おじさん", "ojisan", "চাচা / মামা / খালু", "ওজিসাং", item_type="word"),
            make_item("jp-p2-l13-004", "おじいさん (ojiisan)", "おじいさん", "ojiisan", "দাদা / নানা / বৃদ্ধ", "ওজিইসাং", item_type="word"),
            make_item("jp-p2-l13-005", "ゆき (yuki)", "ゆき", "yuki", "তুষার / বরফ", "ইউকি", item_type="word"),
            make_item("jp-p2-l13-006", "ゆうき (yuuki)", "ゆうき", "yuuki", "সাহস / বীরত্ব", "ইউউকি", item_type="word"),
            make_item("jp-p2-l13-007", "おとうさんは おかあさんと はなします。", "おとうさんはおかあさんとはなします。", "Otousan wa okaasan to hanashimasu.", "বাবা মায়ের সাথে কথা বলেন।", "ওতোওসাং ওয়া ওকাআসাং তো হানাশিমাসু।", [("おとうさん", "otousan", "お父さん", "বাবা"), ("は", "wa", "は", "হলো"), ("おかあさん", "okaasan", "お母さん", "মা"), ("と", "to", "と", "সাথে"), ("はなします", "hanashimasu", "話します", "কথা বলেন")])
        ]
    },
    {
        "id": "jp-foundations-l14",
        "order": 5,
        "title_bn": "৫টি দ্রুত জাপানি টাং টুইস্টার (Hayakuchikotoba - 早口言葉)",
        "title_target": "5 Rapid Japanese Tongue Twisters for Oral Fluency",
        "intro_bn": "উচ্চারণ পরিষ্কার ও জড়তামুক্ত করতে জনপ্রিয় জাপানি টাং টুইস্টারগুলো জোরে জোরে বলুন।",
        "structure": ["Fast Japanese Tongue Twisters (早口言葉)"],
        "items": [
            make_item("jp-p2-l14-001", "なまむぎ なまごめ なまたまご。", "なまむぎなまごめなまたまご。", "Nama mugi nama gome nama tamago.", "কাঁচা গম, কাঁচা চাল, কাঁচা ডিম।", "নামা মুগি নামা গোমে নামা তামাগো।", item_type="tongue_twister"),
            make_item("jp-p2-l14-002", "すももも ももも もものうち。", "すもももももももものうち。", "Sumomo mo momo mo momo no uchi.", "আলুবোখারাও পীচ ফল, পীচ ফলও পীচ পরিবারের অংশ।", "সুমোমো মো মোমো মো মোমো নো উচি।", item_type="tongue_twister"),
            make_item("jp-p2-l14-003", "あかパジャマ、あおパジャマ、きパジャマ。", "あかぱじゃま、あおぱじゃま、きぱじゃま。", "Aka pajama, ao pajama, ki pajama.", "লাল পায়জামা, নীল পায়জামা, হলুদ পায়জামা।", "আকা পাজামা, আও পাজামা, কি পাজামা।", item_type="tongue_twister"),
            make_item("jp-p2-l14-004", "とうきょう とっきょ きょかきょく きょくちょう。", "とうきょうとっきょきょかきょくきょくちょう。", "Toukyou tokkyo kyokakyoku kyokuchou.", "টোকিও পেটেন্ট ব্যুরোর মহাপরিচালক।", "তোকিও তোক্কিও কিওকাকিওকু কিওকুচোও।", item_type="tongue_twister"),
            make_item("jp-p2-l14-005", "となりの きゃくは よく かき くう きゃくだ。", "となりのきゃくはよくかきくうきゃくだ。", "Tonari no kyaku wa yoku kaki kuu kyaku da.", "পাশের ঘরের অতিথি বেশি বেশি পার্সিমন ফল খাওয়া অতিথি।", "তোরারি নো কিয়াকু ওয়া ইয়োকু কাকি কুউ কিয়াকু দা।", item_type="tongue_twister")
        ]
    }
]
parts.append({
    "id": "jp-foundations-p2",
    "order": 2,
    "level": "A1",
    "title_bn": "পরিবর্তিত ধ্বনি ও দ্বিত্ব ব্যঞ্জন (Dakuon, Sokuon, Youon & Chouon)",
    "title_target": "Voiced Sounds, Sokuon, Contracted Sounds & Long Vowels",
    "lessons": p2_lessons
})

# ==============================================================================
# PART 3: কাতাকানা বর্ণমালা ও সাইনবোর্ড দেখে পড়া (Katakana & Foreign Words)
# ==============================================================================
p3_lessons = [
    {
        "id": "jp-foundations-l15",
        "order": 1,
        "title_bn": "কাতাকানা চার্ট ও দীর্ঘ স্বর ড্যাশ (ー Long Dash)",
        "title_target": "Katakana Matrix & The Long Vowel Dash (ー)",
        "intro_bn": "কাতাকানা বিদেশি ভাষা থেকে আসা শব্দ, বিদেশি নাম ও ব্র্যান্ডে ব্যবহৃত হয়। দীর্ঘ স্বরের জন্য 'ー' ড্যাশ বসে।",
        "structure": ["Katakana 46 Sounds + Long Vowel Dash (ー)"],
        "items": [
            make_item("jp-p3-l15-001", "ア、イ、ウ、エ、オ", "ア、イ、ウ、エ、オ", "a, i, u, e, o", "আ, ই, উ, এ, ও (কাতাকানা মৌলিক স্বর)", "আ, ই, উ, এ, ও", item_type="syllable_ladder"),
            make_item("jp-p3-l15-002", "コーヒー (koohii)", "こーひー", "koohii", "কফি (Coffee)", "কোওহিই", item_type="word"),
            make_item("jp-p3-l15-003", "パン (pan)", "ぱん", "pan", "পাউরুটি (Bread)", "পাং", item_type="word"),
            make_item("jp-p3-l15-004", "ホテル (hoteru)", "ほてる", "hoteru", "হোটেল (Hotel)", "হোতেরু", item_type="word"),
            make_item("jp-p3-l15-005", "ノート (nooto)", "のーと", "nooto", "নোটবুক / খাতা (Notebook)", "নোওতো", item_type="word")
        ]
    },
    {
        "id": "jp-foundations-l16",
        "order": 2,
        "title_bn": "টেকনোলজি, যানবাহন ও দৈনন্দিন কাতাকানা",
        "title_target": "Technology, Transport & High-Frequency Katakana",
        "intro_bn": "জাপানে প্রতিদিন ব্যবহৃত প্রয়োজনীয় টেকনোলজি ও যাতায়াতের কাতাকানা শব্দ।",
        "structure": ["Everyday Loanwords in Katakana"],
        "items": [
            make_item("jp-p3-l16-001", "テレビ (terebi)", "てれび", "terebi", "টেলিভিশন (TV)", "তেরেবি", item_type="word"),
            make_item("jp-p3-l16-002", "カメラ (kamera)", "かめら", "kamera", "ক্যামেরা (Camera)", "কামেরাঁ", item_type="word"),
            make_item("jp-p3-l16-003", "バス (basu)", "ばす", "basu", "বাস (Bus)", "বাসু", item_type="word"),
            make_item("jp-p3-l16-004", "タクシー (takushii)", "たくしー", "takushii", "ট্যাক্সি (Taxi)", "তাকুশিই", item_type="word"),
            make_item("jp-p3-l16-005", "パソコン (pasokon)", "ぱそこん", "pasokon", "ব্যক্তিগত কম্পিউটার (PC)", "পাসোকোং", item_type="word"),
            make_item("jp-p3-l16-006", "スマホ (sumaho)", "すまほ", "sumaho", "স্মার্টফোন (Smartphone)", "সুমাফো", item_type="word")
        ]
    },
    {
        "id": "jp-foundations-l17",
        "order": 3,
        "title_bn": "রেস্তোরাঁ, খাবার ও শপিং সাইনবোর্ড রিডিং",
        "title_target": "Restaurant, Food & Shopping Signboard Reading",
        "intro_bn": "দোকান, মেন্যু ও সাইনবোর্ডে থাকা সাধারণ কাতাকানা শব্দ।",
        "structure": ["Public & Store Signs in Katakana"],
        "items": [
            make_item("jp-p3-l17-001", "レストラン (resutoran)", "れすとらん", "resutoran", "রেস্তোরাঁ (Restaurant)", "রেসুতোরাং", item_type="word"),
            make_item("jp-p3-l17-002", "コンビニ (konbini)", "こんびに", "konbini", "২৪ ঘণ্টার কনভেনিয়েন্স স্টোর", "কোম্বিনি", item_type="word"),
            make_item("jp-p3-l17-003", "スーパー (suupaa)", "すーぱー", "suupaa", "সুপারমার্কেট (Supermarket)", "সুউপাহ", item_type="word"),
            make_item("jp-p3-l17-004", "メニュー (menyuu)", "めにゅー", "menyuu", "খাবারের তালিকা (Menu)", "মেনিউউ", item_type="word"),
            make_item("jp-p3-l17-005", "トイレ (toire)", "といれ", "toire", "টয়লেট / ওয়াশরুম", "তোইরে", item_type="word"),
            make_item("jp-p3-l17-006", "エレベーター (erebeetaa)", "えれべーたー", "erebeetaa", "লিফট (Elevator)", "এরেবেওতাহ", item_type="word")
        ]
    },
    {
        "id": "jp-foundations-l18",
        "order": 4,
        "title_bn": "আন্তর্জাতিক দেশ ও শহর নামের কাতাকানা উচ্চারণ",
        "title_target": "Foreign Country & City Names in Katakana",
        "intro_bn": "বিদেশি দেশ ও শহরের নাম জাপানিজে কাতাকানায় যেভাবে লেখা ও বলা হয়।",
        "structure": ["Country in Katakana + から 来ました (kara kimashita)"],
        "items": [
            make_item("jp-p3-l18-001", "バングラデシュ (Banguradeshu)", "ばんぐらでしゅ", "Banguradeshu", "বাংলাদেশ", "বাঙ্গুরাদেশু", item_type="word"),
            make_item("jp-p3-l18-002", "ダッカ (Dakka)", "だっか", "Dakka", "ঢাকা", "দাক্কা", item_type="word"),
            make_item("jp-p3-l18-003", "アメリカ (Amerika)", "あめりか", "Amerika", "আমেরিকা / যুক্তরাষ্ট্র", "আমেরিকা", item_type="word"),
            make_item("jp-p3-l18-004", "ロンドン (Rondon)", "ろんどん", "Rondon", "লন্ডন শহর", "রোন্দোং", item_type="word"),
            make_item("jp-p3-l18-005", "バングラデシュから 来ました。", "ばんぐらでしゅからきました。", "Banguradeshu kara kimashita.", "বাংলাদেশ থেকে এসেছি।", "বাঙ্গুরাদেশু কারা কিমাশিতা।", [("バングラデシュ", "Banguradeshu", "バングラデシュ", "বাংলাদেশ"), ("から", "kara", "から", "থেকে"), ("来ました", "kimashita", "来ました", "এসেছি")])
        ]
    }
]
parts.append({
    "id": "jp-foundations-p3",
    "order": 3,
    "level": "A1",
    "title_bn": "কাতাকানা বর্ণমালা ও সাইনবোর্ড দেখে পড়া (Katakana Words)",
    "title_target": "Katakana Loanwords, Signboards & International Names",
    "lessons": p3_lessons
})

# ==============================================================================
# PART 4: রিডিং রুলস, কণা ও স্বাভাবিক উচ্চারণ প্রবাহ (Reading Rules & Pronunciation Flow)
# ==============================================================================
p4_lessons = [
    {
        "id": "jp-foundations-l19",
        "order": 1,
        "title_bn": "কণার ৩টি বিশেষ উচ্চারণ নিয়ম (は=wa, へ=e, を=o)",
        "title_target": "The 3 Special Particle Readings (ha->wa, he->e, wo->o)",
        "intro_bn": "জাপানি ব্যাকরণে ৩টি কণা বসলে তাদের উচ্চারণ মূল বর্ণের চেয়ে বদলে যায়: は লেখা হলে 'wa' উচ্চারিত হয়, へ লেখা হলে 'e' উচ্চারিত হয়, এবং を লেখা হলে 'o' উচ্চারিত হয়।",
        "structure": ["は = wa (Topic)", "へ = e (Direction)", "を = o (Direct Object)"],
        "items": [
            make_item("jp-p4-l19-001", "わたしは がくせいです。", "わたしわがくせいです。", "Watashi wa gakusei desu.", "আমি শিক্ষার্থী (এখানে 'は' এর উচ্চারণ 'ওয়া')।", "ওয়াতাশি ওয়া গাকুসেই দেস।"),
            make_item("jp-p4-l19-002", "とうきょうへ いきます。", "とうきょうえいきます。", "Toukyou e ikimasu.", "টোকিওতে যাব (এখানে 'へ' এর উচ্চারণ 'এ')।", "তোকিও এ ইকিমাসু।"),
            make_item("jp-p4-l19-003", "おちゃを のみます。", "おちゃをのみます。", "Ocha o nomimasu.", "চা পান করি (এখানে 'を' এর উচ্চারণ 'ও')।", "ওচা ও নোমিমাসু।"),
            make_item("jp-p4-l19-004", "わたしは とうきょうへ いって、おちゃを のみます。", "わたしわとうきょうえいって、おちゃをのみます。", "Watashi wa Toukyou e itte, ocha o nomimasu.", "আমি টোকিও গিয়ে চা পান করব (৩টি কণার সম্মিলিত রিডিং)।", "ওয়াতাশি ওয়া তোকিও এ ইত্তে, ওচা ও নোমিমাসু।")
        ]
    },
    {
        "id": "jp-foundations-l20",
        "order": 2,
        "title_bn": "অঘোষ স্বরধ্বনি ও স্বরভঙ্গ (Devoicing of U and I)",
        "title_target": "Devoicing of Vowels: Desu, Masu, Mashita & Suki",
        "intro_bn": "জাপানিরা বাক্যের শেষে す (su) বা し (shi) এর উ/ই স্বরধ্বনিকে ড্রপ করে বলে। তাই です উচ্চারিত হয় 'দেস্' এবং ます উচ্চারিত হয় 'মস্' হিসেবে।",
        "structure": ["です -> des (দেস্)", "ます -> mas (মস্)", "〜ました -> mashta (মাশ্‌তা)", "好き -> ski (স্কি)"],
        "items": [
            make_item("jp-p4-l20-001", "がくせいです (gakusei desu)", "がくせいです", "gakusei des(u)", "শিক্ষার্থী (উচ্চারণ: গাকুসেই দেস্, 'সু' নয়)", "গাকুসেই দেস্", item_type="word"),
            make_item("jp-p4-l20-002", "たべます (tabemasu)", "たべます", "tabemas(u)", "খাই (উচ্চারণ: তাবেমস্, 'সু' নয়)", "তাবেমস্", item_type="word"),
            make_item("jp-p4-l20-003", "わかりました (wakarimashita)", "わかりました", "wakarimash(i)ta", "বুঝেছি / স্পষ্ট হয়েছে (উচ্চারণ: ওয়াকারিমাশ্‌তা)", "ওয়াকারিমাশ্‌তা", item_type="word"),
            make_item("jp-p4-l20-004", "にほんごが すきです。", "にほんごがすきです。", "Nihongo ga ski des(u).", "জাপানি ভাষা পছন্দ করি (সুকি দেস নয়, স্কি দেস্)।", "নিহঙ্গো গা স্কি দেস্।")
        ]
    },
    {
        "id": "jp-foundations-l21",
        "order": 3,
        "title_bn": "পিচ অ্যাকসেন্ট মিনিমাল পেয়ার্স (Pitch Accent: High vs Low)",
        "title_target": "Pitch-Accent Minimal Pairs (Hashi vs. Hashi, Ame vs. Ame)",
        "intro_bn": "জাপানি ভাষায় পিচ অ্যাকসেন্ট বা স্বরের ওঠানামা রয়েছে। স্বরের উচ্চতা বদলালে শব্দের সম্পূর্ণ অর্থ বদলে যায়!",
        "structure": ["High Pitch (উঁচু স্বর) vs. Low Pitch (নিচু স্বর)"],
        "items": [
            make_item("jp-p4-l21-001", "はし (hashí - দ্বিতীয় মোরা উঁচু)", "はし", "hashí", "চপস্টিক (খাবার কাঠি)", "হাশী", item_type="word"),
            make_item("jp-p4-l21-002", "はし (háshi - প্রথম মোরা উঁচু)", "はし", "háshi", "সেতু / ব্রিজ", "হাঁশি", item_type="word"),
            make_item("jp-p4-l21-003", "あめ (amé - দ্বিতীয় মোরা উঁচু)", "あめ", "amé", "মিষ্টি / ক্যান্ডি", "আমে", item_type="word"),
            make_item("jp-p4-l21-004", "あめ (áme - প্রথম মোরা উঁচু)", "あめ", "áme", "বৃষ্টি", "আঁমে", item_type="word"),
            make_item("jp-p4-l21-005", "はしで ごはんを たべます。", "はしでごはんをたべます。", "Hashi de gohan o tabemasu.", "চপস্টিক দিয়ে খাবার খাই।", "হাশি দে গোহাং ও তাবেমাসু।")
        ]
    },
    {
        "id": "jp-foundations-l22",
        "order": 4,
        "title_bn": "ফুরিগানা দেখে দেখে বাক্য পাঠ ও প্রথম পরিচয় ডায়ালগ",
        "title_target": "Reading Sentences with Furigana & First Meeting Dialogue",
        "intro_bn": "কাঞ্জির মাথার ওপর হিরাগানায় উচ্চারণ লেখা থাকার নাম ফুরিগানা (ふりがな)। এটি দেখে দেখে স্বতঃস্ফূর্ত জাপানি বাক্য পড়ার সেরা ড্রিল।",
        "structure": ["Furigana Reading Practice & First Meeting Dialogue"],
        "items": [
            make_item("jp-p4-l22-001", "はじめまして。わたしは ラヒムです。バングラデシュから 来ました。", "はじめまして。わたしわらひむです。ばんぐらでしゅからきました。", "Hajimemashite. Watashi wa Rahimu desu. Banguradeshu kara kimashita.", "প্রথম পরিচয়। আমি রহিম। বাংলাদেশ থেকে এসেছি।", "হাজিমেমাশিতে। ওয়াতাশি ওয়া রাহিমু দেস। বাঙ্গুরাদেশু কারা কিমাশিতা।", item_type="dialogue"),
            make_item("jp-p4-l22-002", "はじめまして。たなかです。どうぞ よろしく おねがいします。", "はじめまして。たなかです。どうぞよろしくおねがいします。", "Hajimemashite. Tanaka desu. Douzo yoroshiku onegaishimasu.", "পরিচিত হয়ে ভালো লাগল। আমি তানাকা। আপনার সহযোগিতা কামনা করি।", "হাজিমেমাশিতে। তানাকা দেস। দোওজো ইয়োরোশিকু ওনেগাইশিমাসু।", item_type="dialogue"),
            make_item("jp-p4-l22-003", "こちらこそ、よろしく おねがいします。", "こちらこそ、よろしくおねがいします。", "Kochirakoso, yoroshiku onegaishimasu.", "আমার পক্ষ থেকেও আপনার সহযোগিতা কামনা করি।", "কোচিরাকোসো, ইয়োরোশিকু ওনেগাইশিমাসু।", item_type="dialogue")
        ]
    }
]
parts.append({
    "id": "jp-foundations-p4",
    "order": 4,
    "level": "A1",
    "title_bn": "রিডিং রুলস, কণা ও স্বাভাবিক উচ্চারণ প্রবাহ (Reading Rules & Pronunciation Flow)",
    "title_target": "Particle Reading Rules, Devoicing, Pitch-Accent & Furigana Dialogue",
    "lessons": p4_lessons
})

# ==============================================================================
# PART 5: পরিচয়, পেশা ও কপুলা (A は B です / ではありません - Grammar 1–3)
# ==============================================================================
p5_lessons = [
    {
        "id": "jp-foundations-l23",
        "order": 1,
        "title_bn": "আমার পেশা ও পরিচয় — 'わたしは〜です'",
        "title_target": "Personal Identity & Profession (Watashi wa ... desu)",
        "intro_bn": "নিজের পরিচয়, নাম বা পেশা প্রকাশ করতে 'わたしは [নাম/পেশা] です' ব্যবহার করা হয়। は particle এর উচ্চারণ 'ওয়া'।",
        "structure": ["Topic (わたしは) + Profession/Noun + です (desu)"],
        "items": [
            make_item("jp-p5-l23-001", "わたしは 学生です。", "わたしはがくせいです。", "Watashi wa gakusei desu.", "আমি একজন শিক্ষার্থী।", "ওয়াতাশি ওয়া গাকুসেই দেস।", [("わたし", "watashi", "私", "আমি"), ("は", "wa", "は", "হলো"), ("学生", "gakusei", "学生", "শিক্ষার্থী"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p5-l23-002", "わたしは エンジニアです。", "わたしはえんじにあです。", "Watashi wa enjinia desu.", "আমি একজন প্রকৌশলী (ইঞ্জিনিয়ার)।", "ওয়াতাশি ওয়া এনজিনিয়া দেস।", [("わたし", "watashi", "私", "আমি"), ("は", "wa", "は", "হলো"), ("エンジニア", "enjinia", "エンジニア", "প্রকৌশলী"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p5-l23-003", "わたしは 会社員です。", "わたしはかいしゃいんです。", "Watashi wa kaishain desu.", "আমি কোম্পানি কর্মী।", "ওয়াতাশি ওয়া কাইশাইন দেস।", [("わたし", "watashi", "私", "আমি"), ("は", "wa", "は", "হলো"), ("会社員", "kaishain", "会社員", "কোম্পানি কর্মী"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p5-l23-004", "わたしは バングラデシュ人です。", "わたしはばんぐらでしゅじんです。", "Watashi wa Banguradeshu-jin desu.", "আমি বাংলাদেশি।", "ওয়াতাশি ওয়া বাঙ্গুরাদেশু-জিন দেস।", [("わたし", "watashi", "私", "আমি"), ("は", "wa", "は", "হলো"), ("バングラデシュ人", "Banguradeshu-jin", "バングラデシュ人", "বাংলাদেশি"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p5-l23-005", "はじめまして。ラフィです。どうぞ よろしく お願いします。", "はじめまして。らふぃです。どうぞよろしくおねがいします。", "Hajimemashite. Rafi desu. Douzo yoroshiku onegaishimasu.", "প্রথম পরিচয়। আমি রাফি। আপনার সহযোগিতা কামনা করি।", "হাজিমেমাশিতে। রাফি দেস। দোওজো ইয়োরোশিকু ওনেগাইশিমাসু।", [("はじめまして", "hajimemashite", "はじめまして", "প্রথম পরিচয়"), ("ラフィです", "Rafi desu", "ラフィです", "রাফি হই"), ("よろしくお願いします", "yoroshiku onegaishimasu", "よろしくお願いします", "সহযোগিতা কামনা করি")])
        ]
    },
    {
        "id": "jp-foundations-l24",
        "order": 2,
        "title_bn": "অন্যের পরিচয় ও সম্মানসূচক '〜さん' (Others' Identity)",
        "title_target": "Others' Identity & Professions (~san wa ... desu)",
        "intro_bn": "অন্য কারো নাম বা পেশা বলার সময় নামের শেষে সম্মানসূচক 'さん' (san) যুক্ত করতে হয়।",
        "structure": ["Person + さん + は + Profession + です"],
        "items": [
            make_item("jp-p5-l24-001", "田中さんは 日本語の 先生です。", "たなかさんはにほんごのせんせいです。", "Tanaka-san wa nihongo no sensei desu.", "তানাকা বাবু জাপানি ভাষার শিক্ষক।", "তানাকা-সান ওয়া নিহঙ্গো নো সেনসেই দেস।", [("田中さん", "Tanaka-san", "田中さん", "তানাকা বাবু"), ("は", "wa", "は", "হলো"), ("日本語", "nihongo", "日本語", "জাপানি ভাষা"), ("の", "no", "の", "এর"), ("先生", "sensei", "先生", "শিক্ষক"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p5-l24-002", "マリアさんは 医者です。", "まりあさんはいしゃです。", "Maria-san wa isha desu.", "মারিয়া একজন ডাক্তার।", "মারিয়া-সান ওয়া ইশা দেস।", [("マリアさん", "Maria-san", "マリアさん", "মারিয়া"), ("は", "wa", "は", "হলো"), ("医者", "isha", "医者", "ডাক্তার"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p5-l24-003", "あの方は 大学の 教授です。", "あのかたはだいがくのきょうじゅです。", "Ano kata wa daigaku no kyouju desu.", "ওই ভদ্রলোক বিশ্ববিদ্যালয়ের অধ্যাপক।", "আনো কাতা ওয়া দাইগাকু নো কিওওজু দেস।", [("あの方", "ano kata", "あの方", "ওই ভদ্রলোক"), ("は", "wa", "は", "হলো"), ("大学", "daigaku", "大学", "বিশ্ববিদ্যালয়"), ("の", "no", "の", "এর"), ("教授", "kyouju", "教授", "অধ্যাপক"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p5-l24-004", "彼らは 銀行員です。", "かれらはぎんこういんです。", "Karera wa ginkouin desu.", "তারা ব্যাংক কর্মকর্তা।", "কারে-রা ওয়া গিনকোওইন দেস।", [("彼ら", "karera", "彼ら", "তারা"), ("は", "wa", "は", "হলো"), ("銀行員", "ginkouin", "銀行員", "ব্যাংক কর্মী"), ("です", "desu", "です", "হয়")])
        ]
    },
    {
        "id": "jp-foundations-l25",
        "order": 3,
        "title_bn": "না-বোধক পরিচয় — '〜ではありません / じゃありません'",
        "title_target": "Negative Identity (Dewa arimasen / Ja arimasen)",
        "intro_bn": "পরিচয় না-বোধক করতে 'です' এর স্থানে 'ではありません' বা কথ্য ভাষায় 'じゃありません' বসে।",
        "structure": ["Topic + は + Noun + ではありません / じゃありません"],
        "items": [
            make_item("jp-p5-l25-001", "わたしは 先生では ありません。", "わたしわせんせいでわありません。", "Watashi wa sensei dewa arimasen.", "আমি শিক্ষক নই।", "ওয়াতাশি ওয়া সেনসেই দেবা আরিমাসেন।", [("わたし", "watashi", "私", "আমি"), ("は", "wa", "は", "হলো"), ("先生", "sensei", "先生", "শিক্ষক"), ("ではありません", "dewa arimasen", "ではありません", "নই")], polarity="negative"),
            make_item("jp-p5-l25-002", "田中さんは 学生じゃ ありません。", "たなかさんはがくせいじゃありません。", "Tanaka-san wa gakusei ja arimasen.", "তানাকা-সান শিক্ষার্থী নন।", "তানাকা-সান ওয়া গাকুসেই জা আরিমাসেন।", [("田中さん", "Tanaka-san", "田中さん", "তানাকা-সান"), ("は", "wa", "は", "হলো"), ("学生", "gakusei", "学生", "শিক্ষার্থী"), ("じゃありません", "ja arimasen", "じゃありません", "নন")], polarity="negative"),
            make_item("jp-p5-l25-003", "わたしは 日本人では ありません。バングラデシュ人です。", "わたしわにほんじんでわありません。ばんぐらでしゅじんです。", "Watashi wa nihonjin dewa arimasen. Banguradeshu-jin desu.", "আমি জাপানি নই। আমি বাংলাদেশি।", "ওয়াতাশি ওয়া নিহোনজিন দেবা আরিমাসেন। বাঙ্গুরাদেশু-জিন দেস।", [("わたし", "watashi", "私", "আমি"), ("は", "wa", "は", "হলো"), ("日本人", "nihonjin", "日本人", "জাপানি"), ("ではありません", "dewa arimasen", "ではありません", "নই"), ("バングラデシュ人", "Banguradeshu-jin", "バングラデシュ人", "বাংলাদেশি"), ("です", "desu", "です", "হই")], polarity="negative")
        ]
    },
    {
        "id": "jp-foundations-l26",
        "order": 4,
        "title_bn": "৬-রূপান্তর মাস্টার ড্রিল: পেশা ও পরিচয় (6 Transformations)",
        "title_target": "6 Sentence Transformations: Identity (Desu / Dewa arimasen)",
        "intro_bn": "পেশা ও পরিচয় দিয়ে ৬টি রূপে রূপান্তরের স্পোকেন ড্রিল।",
        "structure": ["Affirmative (+)", "Negative (-)", "Question (?)", "Negative Q (-?)", "WH-Q", "Alternative Q"],
        "items": [
            make_item("jp-p5-l26-001", "田中さんは 先生です。", "たなかさんはせんせいです。", "Tanaka-san wa sensei desu.", "১. হ্যাঁ-বোধক: তানাকা বাবু একজন শিক্ষক।", "তানাকা-সান ওয়া সেনসেই দেস।", item_type="drill"),
            make_item("jp-p5-l26-002", "田中さんは 先生では ありません。", "たなかさんはせんせいでわありません。", "Tanaka-san wa sensei dewa arimasen.", "২. না-বোধক: তানাকা বাবু শিক্ষক নন।", "তানাকা-সান ওয়া সেনসেই দেবা আরিমাসেন।", item_type="drill", polarity="negative"),
            make_item("jp-p5-l26-003", "田中さんは 先生ですか。", "たなかさんはせんせいですか。", "Tanaka-san wa sensei desu ka.", "৩. প্রশ্নবোধক: তানাকা বাবু কি শিক্ষক?", "তানাকা-সান ওয়া সেনসেই দেসু কা?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-p5-l26-004", "田中さんは 先生では ありませんか。", "たなかさんはせんせいでわありませんか。", "Tanaka-san wa sensei dewa arimasen ka.", "৪. না-বোধক প্রশ্ন: তানাকা বাবু কি শিক্ষক নন?", "তানাকা-সান ওয়া সেনসেই দেবা আরিমাসেন কা?", item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-p5-l26-005", "だれが 先生ですか。田中さんが 先生です。", "だれがせんせいですか。たなかさんがせんせいです。", "Dare ga sensei desu ka. Tanaka-san ga sensei desu.", "৫. WH-প্রশ্ন: কে শিক্ষক? তানাকা বাবু শিক্ষক।", "দারে গা সেনসেই দেসু কা? তানাকা-সান গা সেনসেই দেস।", item_type="drill", sentence_type="wh_question"),
            make_item("jp-p5-l26-006", "田中さんは 先生ですか、学生ですか。", "たなかさんはせんせいですか、がくせいですか。", "Tanaka-san wa sensei desu ka, gakusei desu ka.", "৬. বিকল্প প্রশ্ন: তানাকা বাবু কি শিক্ষক, নাকি শিক্ষার্থী?", "তানাকা-সান ওয়া সেনসেই দেসু কা, গাকুসেই দেসু কা?", item_type="drill", sentence_type="alternative_question")
        ]
    }
]
parts.append({
    "id": "jp-foundations-p5",
    "order": 5,
    "level": "A1",
    "title_bn": "পরিচয়, পেশা ও কপুলা (Identity & Copula です / ではありません)",
    "title_target": "Personal Identity, Professions & The Copula",
    "lessons": p5_lessons
})

# ==============================================================================
# PART 6: মালিকানা, সম্পর্ক ও 'ও/এছাড়াও' (〜の / 〜も - Grammar 4–5)
# ==============================================================================
p6_lessons = [
    {
        "id": "jp-foundations-l27",
        "order": 1,
        "title_bn": "মালিকানা ও সম্পর্ক — 'N1 の N2' (Possession)",
        "title_target": "Possession & Relationship with Particle 'no'",
        "intro_bn": "মালিকানা, দেশ বা সম্পর্ক বোঝাতে 'এর' অর্থে 'の' (no) বসে।",
        "structure": ["Noun 1 + の + Noun 2"],
        "items": [
            make_item("jp-p6-l27-001", "これは わたしのかばんです。", "これはわたしのかばんです。", "Kore wa watashi no kaban desu.", "এটা আমার ব্যাগ।", "কোরে ওয়া ওয়াতাশি নো কাবেন দেস।", [("これ", "kore", "これ", "এটা"), ("は", "wa", "は", "হলো"), ("わたし", "watashi", "私", "আমার"), ("の", "no", "の", "এর"), ("かばん", "kaban", "鞄", "ব্যাগ"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p6-l27-002", "それは だれの ほんですか。", "それはだれのほんですか。", "Sore wa dare no hon desu ka.", "ওটা কার বই?", "সোরে ওয়া দারে নো হোং দেসু কা?", [("それ", "sore", "それ", "ওটা"), ("は", "wa", "は", "হলো"), ("だれ", "dare", "誰", "কার"), ("の", "no", "の", "এর"), ("ほん", "hon", "本", "বই"), ("ですか", "desu ka", "ですか", "কি?")]),
            make_item("jp-p6-l27-003", "これは にほんの くるまです。", "これはにほんのくるまです。", "Kore wa nihon no kuruma desu.", "এটা জাপানের গাড়ি।", "কোরে ওয়া নিহোন নো কুরুমা দেস।", [("これ", "kore", "これ", "এটা"), ("は", "wa", "は", "হলো"), ("にほん", "nihon", "日本", "জাপান"), ("の", "no", "の", "এর"), ("くるま", "kuruma", "車", "গাড়ি"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p6-l27-004", "たなかさんは とうきょうだいがくの がくせいです。", "たなかさんはとうきょうだいがくのがくせいです。", "Tanaka-san wa Toukyou daigaku no gakusei desu.", "তানাকা বাবু টোকিও বিশ্ববিদ্যালয়ের ছাত্র।", "তানাকা-সান ওয়া তোকিও দাইগাকু নো গাকুসেই দেস।", [("田中さん", "Tanaka-san", "田中さん", "তানাকা-সান"), ("は", "wa", "は", "হলো"), ("東京大学", "Toukyou daigaku", "東京大学", "টোকিও বিশ্ববিদ্যালয়"), ("の", "no", "の", "এর"), ("学生", "gakusei", "学生", "শিক্ষার্থী"), ("です", "desu", "です", "হয়")])
        ]
    },
    {
        "id": "jp-foundations-l28",
        "order": 2,
        "title_bn": "এছাড়াও / ও বোঝাতে — '〜も' (Inclusion Particle 'mo')",
        "title_target": "Inclusion with Particle 'mo' (Also / Too)",
        "intro_bn": "আগের কথার সাথে মিল রেখে 'ও / আমিও' বোঝাতে は এর পরিবর্তে も (mo) বসে।",
        "structure": ["Topic + も + Noun + です"],
        "items": [
            make_item("jp-p6-l28-001", "わたしも がくせいです。", "わたしもがくせいです。", "Watashi mo gakusei desu.", "আমিও একজন শিক্ষার্থী।", "ওয়াতাশি মো গাকুসেই দেস।", [("わたし", "watashi", "私", "আমি"), ("も", "mo", "も", "ও"), ("学生", "gakusei", "学生", "শিক্ষার্থী"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p6-l28-002", "かれも エンジニアです。", "かれもえんじにあです。", "Kare mo enjinia desu.", "সেও একজন প্রকৌশলী।", "কারে মো এনজিনিয়া দেস।", [("かれ", "kare", "彼", "সে"), ("も", "mo", "も", "ও"), ("エンジニア", "enjinia", "エンジニア", "প্রকৌশলী"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p6-l28-003", "これも わたしのかばんです。", "これもわたしのかばんです。", "Kore mo watashi no kaban desu.", "এটাও আমার ব্যাগ।", "কোরে মো ওয়াতাশি নো কাবেন দেস।", [("これ", "kore", "これ", "এটা"), ("も", "mo", "も", "ও"), ("わたし", "watashi", "私", "আমার"), ("の", "no", "の", "এর"), ("かばん", "kaban", "鞄", "ব্যাগ"), ("です", "desu", "です", "হয়")])
        ]
    },
    {
        "id": "jp-foundations-l29",
        "order": 3,
        "title_bn": "পরিবারের সদস্যগণ (Family Members Bank)",
        "title_target": "Family Vocabulary (In-group vs. Out-group)",
        "intro_bn": "জাপানিজে নিজের পরিবার ও অন্যের পরিবার বলার শব্দ আলাদা (যেমন: নিজের বাবা ちち, অন্যের বাবা お父さん)।",
        "structure": ["Family member + は + ..."],
        "items": [
            make_item("jp-p6-l29-001", "ちちは かいしゃいんです。", "ちちはかいしゃいんです。", "Chichi wa kaishain desu.", "আমার বাবা একজন কোম্পানি কর্মী।", "চিচি ওয়া কাইশাইন দেস।", [("父", "chichi", "父", "আমার বাবা"), ("は", "wa", "は", "হলো"), ("会社員", "kaishain", "会社員", "কোম্পানি কর্মী"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p6-l29-002", "ははは しゅふです。", "はははしゅふです。", "Haha wa shufu desu.", "আমার মা একজন গৃহিণী।", "হাহা ওয়া শুফু দেস।", [("母", "haha", "母", "আমার মা"), ("は", "wa", "は", "হলো"), ("主婦", "shufu", "主婦", "গৃহিণী"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p6-l29-003", "あには いしゃです。", "あにはいしゃです。", "Ani wa isha desu.", "আমার বড় ভাই একজন ডাক্তার।", "আনি ওয়া ইশা দেস।", [("兄", "ani", "兄", "আমার বড় ভাই"), ("は", "wa", "は", "হলো"), ("医者", "isha", "医者", "ডাক্তার"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p6-l29-004", "いもうとは だいがくせいです。", "いもうとはだいがくせいです。", "Imouto wa daigakusei desu.", "আমার ছোট বোন বিশ্ববিদ্যালয়ের ছাত্রী।", "ইমোওতো ওয়া দাইগাকুসেই দেস।", [("妹", "imouto", "妹", "আমার ছোট বোন"), ("は", "wa", "は", "হলো"), ("大学生", "daigakusei", "大学生", "বিশ্ববিদ্যালয়ের শিক্ষার্থী"), ("です", "desu", "です", "হয়")])
        ]
    }
]
parts.append({
    "id": "jp-foundations-p6",
    "order": 6,
    "level": "A1",
    "title_bn": "মালিকানা, সম্পর্ক ও 'ও' (Possession & Particle も)",
    "title_target": "Possession, Family & Particle 'mo'",
    "lessons": p6_lessons
})

# ==============================================================================
# PART 7: বস্তু, দাম ও অবস্থান নির্দেশক (Demonstratives & Shopping)
# ==============================================================================
p7_lessons = [
    {
        "id": "jp-foundations-l30",
        "order": 1,
        "title_bn": "বস্তু নির্দেশক — 'これ・それ・あれ・どれ' (This, That, Which)",
        "title_target": "Independent Demonstratives (Kore, Sore, Are, Dore)",
        "intro_bn": "কাছের জিনিস これ (kore - এটা), মধ্যবর্তী それ (sore - ওটা), দূরের あれ (are - ওইটা), এবং প্রশ্নে どれ (dore - কোনটা)।",
        "structure": ["これ / それ / あれ / どれ + は + Noun + ですか"],
        "items": [
            make_item("jp-p7-l30-001", "これは なんですか。", "これはなんですか。", "Kore wa nan desu ka.", "এটা কী?", "কোরে ওয়া নান দেসু কা?", [("これ", "kore", "これ", "এটা"), ("は", "wa", "は", "হলো"), ("何", "nan", "何", "কী"), ("ですか", "desu ka", "ですか", "কি?")]),
            make_item("jp-p7-l30-002", "それは じしょです。", "それはじしょです。", "Sore wa jisho desu.", "ওটা একটি অভিধান (ডিকশনারি)।", "সোরে ওয়া জিশো দেস।", [("それ", "sore", "それ", "ওটা"), ("は", "wa", "は", "হলো"), ("辞書", "jisho", "辞書", "অভিধান"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p7-l30-003", "あれは わたしの くるまです。", "あれはわたしのくるまです。", "Are wa watashi no kuruma desu.", "ওই দূরের জিনিসটি আমার গাড়ি।", "আরে ওয়া ওয়াতাশি নো কুরুমা দেস।", [("あれ", "are", "あれ", "ওইটা"), ("は", "wa", "は", "হলো"), ("わたしの", "watashi no", "私の", "আমার"), ("車", "kuruma", "車", "গাড়ি"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p7-l30-004", "あなたのかばんは どれですか。", "あなたのかばんはどれですか。", "Anata no kaban wa dore desu ka.", "আপনার ব্যাগ কোনটি?", "আনাতা নো কাবেন ওয়া দোরে দেসু কা?", [("あなたの", "anata no", "あなたの", "আপনার"), ("かばん", "kaban", "鞄", "ব্যাগ"), ("は", "wa", "は", "হলো"), ("どれ", "dore", "どれ", "কোনটি"), ("ですか", "desu ka", "ですか", "কি?")])
        ]
    },
    {
        "id": "jp-foundations-l31",
        "order": 2,
        "title_bn": "বিশেষ্য সহ নির্দেশক — 'この・その・あの・どの + Noun'",
        "title_target": "Modified Demonstratives (Kono, Sono, Ano, Dono + Noun)",
        "intro_bn": "বিশেষ্যের আগে বসে এই/সেই/ওই বোঝাতে この (kono), その (sono), あの (ano), どの (dono) ব্যবহৃত হয়।",
        "structure": ["この / その / あの / どの + Noun + は ..."],
        "items": [
            make_item("jp-p7-l31-001", "このほんは おもしろいです。", "このほんはおもしろいです。", "Kono hon wa omoshiroi desu.", "এই বইটি বেশ মজার।", "কোনো হোং ওয়া ওমোশিরোই দেস।", [("この", "kono", "この", "এই"), ("本", "hon", "本", "বই"), ("は", "wa", "は", "হলো"), ("おもしろい", "omoshiroi", "面白い", "মজার"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p7-l31-002", "そのかさは あなたのですか。", "そのかさはあなたのですか。", "Sono kasa wa anata no desu ka.", "ওই ছাতাটি কি আপনার?", "সোনো কাসা ওয়া আনাতা নো দেসু কা?", [("その", "sono", "その", "সেই/ওই"), ("傘", "kasa", "傘", "ছাতা"), ("は", "wa", "は", "হলো"), ("あなたの", "anata no", "あなたの", "আপনার"), ("ですか", "desu ka", "ですか", "কি?")]),
            make_item("jp-p7-l31-003", "あのひとは だれですか。", "あのひとはだれですか。", "Ano hito wa dare desu ka.", "ওই ব্যক্তি কে?", "আনো হিতো ওয়া দারে দেসু কা?", [("あの", "ano", "あの", "ওই"), ("人", "hito", "人", "ব্যক্তি"), ("は", "wa", "は", "হলো"), ("だれ", "dare", "誰", "কে"), ("ですか", "desu ka", "ですか", "কি?")])
        ]
    },
    {
        "id": "jp-foundations-l32",
        "order": 3,
        "title_bn": "স্থান নির্দেশক — 'ここ・そこ・あそこ・どこ' (Locations)",
        "title_target": "Location Demonstratives (Koko, Soko, Asoko, Doko)",
        "intro_bn": "এখানে (ここ), সেখানে (そこ), ওখানে (あそこ), কোথায় (どこ)। ভদ্র রূপ: こちら, そちら, あちら, どちら।",
        "structure": ["Place + は + ここ / そこ / あそこ / どこ + ですか"],
        "items": [
            make_item("jp-p7-l32-001", "トイレは どこですか。", "といれはどこですか。", "Toire wa doko desu ka.", "টয়লেট কোথায়?", "তোইরে ওয়া দোকো দেসু কা?", [("トイレ", "toire", "トイレ", "টয়লেট"), ("は", "wa", "は", "হলো"), ("どこ", "doko", "どこ", "কোথায়"), ("ですか", "desu ka", "ですか", "কি?")]),
            make_item("jp-p7-l32-002", "あそこです。ぎんこうの となりです。", "あそこです。ぎんこうのとなりです。", "Asoko desu. Ginkou no tonari desu.", "ওখানে। ব্যাংকের পাশে।", "আসোকো দেস। গিনকোও নো তোরারি দেস।", [("あそこ", "asoko", "あそこ", "ওখানে"), ("です", "desu", "です", "হয়"), ("銀行", "ginkou", "銀行", "ব্যাংক"), ("の", "no", "の", "এর"), ("となり", "tonari", "隣", "পাশে"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p7-l32-003", "うけつけは こちらです。", "うけつけはこちらです。", "Uketsuke wa kochira desu.", "রিসেপশন এই দিকে।", "উকেৎসুকে ওয়া কোচিরা দেস।", [("受付", "uketsuke", "受付", "রিসেপশন"), ("は", "wa", "は", "হলো"), ("こちら", "kochira", "こちら", "এই দিকে"), ("です", "desu", "です", "হয়")])
        ]
    },
    {
        "id": "jp-foundations-l33",
        "order": 4,
        "title_bn": "মূল্য জিজ্ঞাসা ও কেনাকাটা — 'いくらですか' (Shopping Dialogue)",
        "title_target": "Price Inquiry & Shopping Conversation (Ikura desu ka)",
        "intro_bn": "দোকানে কোনো জিনিসের দাম জানতে '〜は いくらですか' এবং কিনতে '〜を ください' ব্যবহার করা হয়।",
        "structure": ["Noun + は + いくらですか (How much is ...?)", "〜を ください (Please give me ...)"],
        "items": [
            make_item("jp-p7-l33-001", "すみません。このかばんは いくらですか。", "すみません。このかばんはいくらですか。", "Sumimasen. Kono kaban wa ikura desu ka.", "মাফ করবেন। এই ব্যাগটির দাম কত?", "সুমিমাসেন। কোনো কাবেন ওয়া ইকুরা দেসু কা?", [("すみません", "sumimasen", "すみません", "মাফ করবেন"), ("この", "kono", "この", "এই"), ("鞄", "kaban", "鞄", "ব্যাগ"), ("は", "wa", "は", "হলো"), ("いくら", "ikura", "幾ら", "কত দাম"), ("ですか", "desu ka", "ですか", "কি?")]),
            make_item("jp-p7-l33-002", "さんぜんえんです。", "さんぜんえんです。", "Sanzen-en desu.", "তিন হাজার ইয়েন।", "সানজেন-য়েন দেস।", [("三千円", "sanzen-en", "三千円", "৩,০০০ ইয়েন"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p7-l33-003", "じゃ、これを ください。", "じゃ、これをください。", "Ja, kore o kudasai.", "তাহলে আমাকে এটা দিন।", "জা, কোরে ও কুদাসাই।", [("じゃ", "ja", "じゃ", "তাহলে"), ("これ", "kore", "これ", "এটা"), ("を", "o", "কে", "কে"), ("ください", "kudasai", "下さい", "দিন")]),
            make_item("jp-p7-l33-004", "このりんごを みっつ ください。", "このりんごをみっつください。", "Kono ringo o mittsu kudasai.", "আমাকে এই আপেল তিনটি দিন।", "কোনো রিঙ্গো ও মিত্তসু কুদাসাই।", [("この", "kono", "この", "এই"), ("りんご", "ringo", "林檎", "আপেল"), ("を", "o", "কে", "কে"), ("みっつ", "mittsu", "三つ", "তিনটি"), ("ください", "kudasai", "下さい", "দিন")])
        ]
    }
]
parts.append({
    "id": "jp-foundations-p7",
    "order": 7,
    "level": "A1",
    "title_bn": "বস্তু, দাম ও কেনাকাটা (Demonstratives & Shopping)",
    "title_target": "Demonstratives, Directions & Shopping Inquiries",
    "lessons": p7_lessons
})

# ==============================================================================
# PART 8: সংখ্যা, সময়, বার ও কাউন্টার (Numbers, Time, Counters)
# ==============================================================================
p8_lessons = [
    {
        "id": "jp-foundations-l34",
        "order": 1,
        "title_bn": "১ থেকে ১০,০০০ পর্যন্ত সংখ্যা ও টাকা (Numbers & Yen)",
        "title_target": "Numbers 1-10,000 & Money Calculations",
        "intro_bn": "এক থেকে দশ হাজার পর্যন্ত গোনা: 一 (ichi), 十 (juu), 百 (hyaku), 千 (sen), 万 (man) এবং মুদ্রা 円 (en)।",
        "structure": ["Number + 円 (en)"],
        "items": [
            make_item("jp-p8-l34-001", "いち、に、さん、よん、ご、ろく、なな、はち、きゅう、じゅう", "いち、に、さん、よん、ご、ろく、なな、はち、きゅう、じゅう", "ichi, ni, san, yon, go, roku, nana, hachi, kyuu, juu", "১ থেকে ১০ পর্যন্ত সংখ্যা", "ইচি, নি, সান, ইয়োন, গো, রোকু, নানা, হাচি, কিউউ, জিউউ", item_type="syllable_ladder"),
            make_item("jp-p8-l34-002", "ひゃくえん、せんえん、いちまんえん", "ひゃくえん、せんえん、いちまんえん", "hyaku-en, sen-en, ichiman-en", "১০০ ইয়েন, ১,০০০ ইয়েন, ১০,০০০ ইয়েন", "হিয়াকু-য়েন, সেন-য়েন, ইচিমান-য়েন", item_type="syllable_ladder"),
            make_item("jp-p8-l34-003", "ぜんぶで せんごひゃくえんです。", "ぜんぶでせんごひゃくえんです。", "Zenbu de sen gohyaku-en desu.", "সব মিলিয়ে মোট ১,৫০০ ইয়েন।", "জেম্বু দে সেন গোহিয়াকু-য়েন দেস।", [("全部で", "zenbu de", "全部で", "সব মিলিয়ে"), ("千五百円", "sen gohyaku-en", "千五百円", "১,৫০০ ইয়েন"), ("です", "desu", "です", "হয়")])
        ]
    },
    {
        "id": "jp-foundations-l35",
        "order": 2,
        "title_bn": "সময়, মিনিট ও তারিখ (Time, Minutes & Dates)",
        "title_target": "Telling Time, Minutes & Calendar Dates",
        "intro_bn": "সময় বলতে 時 (ji), মিনিট 分 (fun/pun), অর্ধেক 半 (han) এবং তারিখের বিশেষ উচ্চারণ (ついたち, ふつか...)।",
        "structure": ["[Hour] 時 + [Minute] 分 + です"],
        "items": [
            make_item("jp-p8-l35-001", "いま なんじですか。いま しちじはんです。", "いまなんじですか。いましちじはんです。", "Ima nanji desu ka. Ima shichiji-han desu.", "এখন কয়টা বাজে? এখন সাড়ে সাতটা বাজে।", "ইমা নানজি দেসু কা? ইমা শিচিজি-হান দেস।", [("今", "ima", "今", "এখন"), ("何時", "nanji", "何時", "কয়টা"), ("ですか", "desu ka", "ですか", "কি?"), ("七時半", "shichiji-han", "七時半", "৭:৩০"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p8-l35-002", "きょうは なんようびですか。げつようびです。", "きょうはなんようびですか。げつようびです。", "Kyou wa nanyoubi desu ka. Getsuyoubi desu.", "আজ কী বার? আজ সোমবার।", "কিয়োও ওয়া নানইয়োওবি দেসু কা? গেৎসুয়োওবি দেস।", [("今日", "kyou", "今日", "আজ"), ("は", "wa", "は", "হলো"), ("何曜日", "nanyoubi", "何曜日", "কী বার"), ("ですか", "desu ka", "ですか", "কি?"), ("月曜日", "getsuyoubi", "月曜日", "সোমবার"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p8-l35-003", "きょうは しがつみっかです。", "きょうはしがつみっかです。", "Kyou wa shigatsu mikka desu.", "আজ ৩রা এপ্রিল।", "কিয়োও ওয়া শিগাৎসু মিক্কা দেস।", [("今日", "kyou", "今日", "আজ"), ("は", "wa", "は", "হলো"), ("四月", "shigatsu", "四月", "এপ্রিল মাস"), ("三日", "mikka", "三日", "৩ তারিখ"), ("です", "desu", "です", "হয়")])
        ]
    },
    {
        "id": "jp-foundations-l36",
        "order": 3,
        "title_bn": "নিত্যপ্রয়োজনীয় ৫টি কাউন্টার (人, 本, 枚, 台, 冊, つ)",
        "title_target": "Essential Japanese Counters (People, Flat, Long, Machines)",
        "intro_bn": "মানুষ গোনার জন্য 人 (nin), লম্বা বস্তু 本 (hon), পাতলা বস্তু 枚 (mai), মেশিন 台 (dai), বই 冊 (satsu)।",
        "structure": ["Noun + [Number + Counter]"],
        "items": [
            make_item("jp-p8-l36-001", "がくせいが さんにん います。", "がくせいがさんにんいます。", "Gakusei ga sannin imasu.", "তিনজন শিক্ষার্থী আছে।", "গাকুসেই গা সান্নিন ইমাসু।", [("学生", "gakusei", "学生", "শিক্ষার্থী"), ("が", "ga", "が", "টি"), ("三人", "sannin", "三人", "৩ জন"), ("います", "imasu", "います", "আছে")]),
            make_item("jp-p8-l36-002", "ペンが にほん あります。", "ぺんがにほんあります。", "Pen ga nihon arimasu.", "দুটি কলম আছে।", "পেন গা নিহোং আরিমাসু।", [("ペン", "pen", "ペン", "কলম"), ("が", "ga", "が", "টি"), ("二本", "nihon", "二本", "২টি লম্বা বস্তু"), ("あります", "arimasu", "あります", "আছে")]),
            make_item("jp-p8-l36-003", "きっぷが いちまい あります。", "きっぷがいちまいあります。", "Kippu ga ichimai arimasu.", "একটি টিকিট আছে।", "কিপ্পু গা ইচিমাই আরিমাসু।", [("切符", "kippu", "切符", "টিকিট"), ("が", "ga", "が", "টি"), ("一枚", "ichimai", "一枚", "১টি পাতলা কাগজ"), ("あります", "arimasu", "あります", "আছে")]),
            make_item("jp-p8-l36-004", "車が いちだい あります。", "くるまがいちだいあります。", "Kuruma ga ichidai arimasu.", "একটি গাড়ি আছে।", "কুরুমা গা ইচিদাই আরিমাসু।", [("車", "kuruma", "車", "গাড়ি"), ("が", "ga", "が", "টি"), ("一台", "ichidai", "一台", "১টি মেশিন/যান"), ("あります", "arimasu", "あります", "আছে")])
        ]
    }
]
parts.append({
    "id": "jp-foundations-p8",
    "order": 8,
    "level": "A1",
    "title_bn": "সংখ্যা, সময়, বার ও কাউন্টার (Numbers & Counters)",
    "title_target": "Numbers, Time Telling & Essential Counters",
    "lessons": p8_lessons
})

# ==============================================================================
# PART 9: অবস্থান ও অস্তিত্ব (あります বনাম います - Grammar 9–11)
# ==============================================================================
p9_lessons = [
    {
        "id": "jp-foundations-l37",
        "order": 1,
        "title_bn": "নির্জীব বস্তু ও উদ্ভিদের অবস্থান — 'あります' (Inanimate Existence)",
        "title_target": "Inanimate Existence with 'arimasu' (Things & Plants)",
        "intro_bn": "প্রাণহীন জড়বস্তু, গাছপালা বা ধারণার ক্ষেত্রে 'あります' বসে এবং যা আছে তার পরে が বসে।",
        "structure": ["Place に + Inanimate Noun が + あります"],
        "items": [
            make_item("jp-p9-l37-001", "つくえの うえに ほんが あります。", "つくえのうえにほんがあります。", "Tsukue no ue ni hon ga arimasu.", "টেবিলের ওপর বই আছে।", "ৎसुकুয়ে নো উয়ে নি হোং গা আরিমাসু।", [("机", "tsukue", "机", "টেবিল"), ("の", "no", "の", "এর"), ("上", "ue", "上", "ওপর"), ("に", "ni", "に", "এ"), ("本", "hon", "本", "বই"), ("が", "ga", "が", "টি"), ("あります", "arimasu", "あります", "আছে")]),
            make_item("jp-p9-l37-002", "へやの なかに テレビが あります。", "へやのなかにてれびがあります。", "Heya no naka ni terebi ga arimasu.", "ঘরের ভেতরে একটি টেলিভিশন আছে।", "হেয়া নো নাকা নি তেরেবি গা আরিমাসু।", [("部屋", "heya", "部屋", "ঘর"), ("の", "no", "の", "এর"), ("中", "naka", "中", "ভেতরে"), ("に", "ni", "に", "এ"), ("テレビ", "terebi", "テレビ", "টেলিভিশন"), ("が", "ga", "が", "টি"), ("あります", "arimasu", "あります", "আছে")]),
            make_item("jp-p9-l37-003", "きょうは ようじが あります。", "きょうはようじがあります。", "Kyou wa youji ga arimasu.", "আজ আমার কাজ / অ্যাপয়েন্টমেন্ট আছে।", "কিয়োও ওয়া ইয়োওজি গা আরিমাসু।", [("今日", "kyou", "今日", "আজ"), ("は", "wa", "は", "হলো"), ("用事", "youji", "用事", "ব্যক্তিগত কাজ"), ("が", "ga", "が", "টি"), ("あります", "arimasu", "あります", "আছে")])
        ]
    },
    {
        "id": "jp-foundations-l38",
        "order": 2,
        "title_bn": "সজীব প্রাণী ও মানুষের অবস্থান — 'います' (Animate Existence)",
        "title_target": "Animate Existence with 'imasu' (People & Animals)",
        "intro_bn": "মানুষ, পশুপাখি বা জীবন্ত প্রাণীর ক্ষেত্রে 'います' বসে।",
        "structure": ["Place に + Animate Noun が + います"],
        "items": [
            make_item("jp-p9-l38-001", "きょうしつに せんせいが います。", "きょうしつにせんせいがいます。", "Kyoushitsu ni sensei ga imasu.", "শ্রেণিকক্ষে শিক্ষক আছেন।", "কিয়োওশিতসু নি সেনসেই গা ইমাসু।", [("教室", "kyoushitsu", "教室", "শ্রেণিকক্ষ"), ("に", "ni", "に", "এ"), ("先生", "sensei", "先生", "শিক্ষক"), ("が", "ga", "が", "টি"), ("います", "imasu", "います", "আছেন")]),
            make_item("jp-p9-l38-002", "にわに ねこが います。", "にわにねこがいます。", "Niwa ni neko ga imasu.", "বাগানে একটি বিড়াল আছে।", "নিওয়া নি নেকো গা ইমাসু।", [("庭", "niwa", "庭", "বাগান"), ("に", "ni", "に", "এ"), ("猫", "neko", "猫", "বিড়াল"), ("が", "ga", "が", "টি"), ("います", "imasu", "います", "আছে")]),
            make_item("jp-p9-l38-003", "あそこに だれが いますか。", "あそこにだれがいますか。", "Asoko ni dare ga imasu ka.", "ওখানে কে আছে?", "আসোকো নি দারে গা ইমাসু কা?", [("あそこ", "asoko", "あそこ", "ওখানে"), ("に", "ni", "に", "এ"), ("誰", "dare", "誰", "কে"), ("が", "ga", "が", "টি"), ("いますか", "imasu ka", "いますか", "আছে কি?")])
        ]
    },
    {
        "id": "jp-foundations-l39",
        "order": 3,
        "title_bn": "অবস্থান সূচক শব্দ ও প্রিপজিশন (Spatial Prepositions)",
        "title_target": "Positional Words: Ue, Shita, Mae, Ushiro, Naka, Tonari",
        "intro_bn": "ওপর (上), নিচে (下), সামনে (前), পেছনে (後ろ), মাঝে (中), পাশে (となり), কাছে (近く)।",
        "structure": ["Noun + の + [Position] に + あります/います"],
        "items": [
            make_item("jp-p9-l39-001", "えきの まえに ぎんこうが あります。", "えきのまえにぎんこうがあります。", "Eki no mae ni ginkou ga arimasu.", "স্টেশনের সামনে একটি ব্যাংক আছে।", "একি নো মায়ে নি গিনকোও গা আরিমাসু।", [("駅", "eki", "駅", "স্টেশন"), ("の", "no", "の", "এর"), ("前", "mae", "前", "সামনে"), ("に", "ni", "に", "এ"), ("銀行", "ginkou", "銀行", "ব্যাংক"), ("が", "ga", "が", "টি"), ("あります", "arimasu", "あります", "আছে")]),
            make_item("jp-p9-l39-002", "つくえの したに いぬが います。", "つくえのしたにいぬがいます。", "Tsukue no shita ni inu ga imasu.", "টেবিলের নিচে একটি কুকুর আছে।", "ৎसुकুয়ে নো শিতা নি ইনু গা ইমাসু।", [("机", "tsukue", "机", "টেবিল"), ("の", "no", "の", "এর"), ("下", "shita", "下", "নিচে"), ("に", "ni", "に", "এ"), ("犬", "inu", "犬", "কুকুর"), ("が", "ga", "が", "টি"), ("います", "imasu", "います", "আছে")]),
            make_item("jp-p9-l39-003", "ほんやは はなやの となりに あります。", "ほんやははなやのとなりにあります。", "Honya wa hanaya no tonari ni arimasu.", "বইয়ের দোকানটি ফুলের দোকানের পাশে আছে।", "হোন্‌য়া ওয়া হানায়া নো তোরারি নি আরিমাসু।", [("本屋", "honya", "本屋", "বইয়ের দোকান"), ("は", "wa", "は", "হলো"), ("花屋", "hanaya", "花屋", "ফুলের দোকান"), ("の", "no", "の", "এর"), ("隣", "tonari", "隣", "পাশে"), ("に", "ni", "に", "এ"), ("あります", "arimasu", "あります", "আছে")])
        ]
    },
    {
        "id": "jp-foundations-l40",
        "order": 4,
        "title_bn": "৬-রূপান্তর ড্রিল: অস্তিত্ব ও অবস্থান (6 Transformations)",
        "title_target": "6 Sentence Transformations: Existence (Arimasu / Imasu)",
        "intro_bn": "অস্তিত্বের ক্রিয়া দিয়ে ৬টি রূপে রূপান্তরের স্পোকেন ড্রিল।",
        "structure": ["Affirmative (+)", "Negative (-)", "Question (?)", "Negative Q (-?)", "WH-Q", "Alternative Q"],
        "items": [
            make_item("jp-p9-l40-001", "へやに ねこが います。", "へやにねこがいます。", "Heya ni neko ga imasu.", "১. হ্যাঁ-বোধক: ঘরে বিড়াল আছে।", "হেয়া নি নেকো গা ইমাসু।", item_type="drill"),
            make_item("jp-p9-l40-002", "へやに ねこは いません。", "へやにねこわいません。", "Heya ni neko wa imasen.", "২. না-বোধক: ঘরে বিড়াল নেই।", "হেয়া নি নেকো ওয়া ইমাসেন।", item_type="drill", polarity="negative"),
            make_item("jp-p9-l40-003", "へやに ねこが いますか。", "へやにねこがいますか。", "Heya ni neko ga imasu ka.", "৩. প্রশ্নবোধক: ঘরে কি বিড়াল আছে?", "হেয়া নি নেকো গা ইমাসু কা?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-p9-l40-004", "へやに ねこは いませんか。", "へやにねこわいませんか。", "Heya ni neko wa imasen ka.", "৪. না-বোধক প্রশ্ন: ঘরে কি বিড়াল নেই?", "হেয়া নি নেকো ওয়া ইমাসেন কা?", item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-p9-l40-005", "へやに なにが いますか。ねこが います。", "へやになにがいますか。ねこがいます。", "Heya ni nani ga imasu ka. Neko ga imasu.", "৫. WH-প্রশ্ন: ঘরে কী আছে? বিড়াল আছে।", "হেয়া নি নানি গা ইমাসু কা? নেকো গা ইমাসু।", item_type="drill", sentence_type="wh_question"),
            make_item("jp-p9-l40-006", "へやに ねこが いますか、いぬが いますか。", "へやにねこがいますか、いぬがいますか。", "Heya ni neko ga imasu ka, inu ga imasu ka.", "৬. বিকল্প প্রশ্ন: ঘরে কি বিড়াল আছে, নাকি কুকুর আছে?", "হেয়া নি নেকো গা ইমাসু কা, ইনু গা ইমাসু কা?", item_type="drill", sentence_type="alternative_question")
        ]
    }
]
parts.append({
    "id": "jp-foundations-p9",
    "order": 9,
    "level": "A1",
    "title_bn": "অবস্থান ও অস্তিত্ব (Existence: あります বনাম います)",
    "title_target": "Spatial Location & Existence (Arimasu vs. Imasu)",
    "lessons": p9_lessons
})

# ==============================================================================
# PART 10: কাজের ভার্ব ও মৌলিক পার্টিকেল (Action Verbs & Particles - Grammar 12–17)
# ==============================================================================
p10_lessons = [
    {
        "id": "jp-foundations-l41",
        "order": 1,
        "title_bn": "সরাসরি অবজেক্ট ও ক্রিয়াপদ — '〜を' (Object Particle 'o')",
        "title_target": "Direct Object with Particle 'o' & Essential Verbs",
        "intro_bn": "কাজের সরাসরি অবজেক্টের পরে を (উচ্চারণ 'ও') বসে।",
        "structure": ["Object + を + Verb ます"],
        "items": [
            make_item("jp-p10-l41-001", "みずを のみます。", "みずをのみます。", "Mizu o nomimasu.", "পানি পান করি।", "মিজু ও নোমিমাসু।", [("水", "mizu", "水", "পানি"), ("を", "o", "を", "কে"), ("飲みます", "nomimasu", "飲みます", "পান করি")]),
            make_item("jp-p10-l41-002", "ごはんを たべます。", "ごはんをたべます。", "Gohan o tabemasu.", "ভাত খাই।", "গোহাং ও তাবেমাসু।", [("ご飯", "gohan", "ご飯", "ভাত"), ("を", "o", "を", "কে"), ("食べます", "tabemasu", "食べます", "খাই")]),
            make_item("jp-p10-l41-003", "にほんごの ほんを よみます。", "にほんごのほんをよみます。", "Nihongo no hon o yomimasu.", "জাপানি ভাষার বই পড়ি।", "নিহঙ্গো নো হোং ও ইয়োমিমাসু।", [("日本語の", "nihongo no", "日本語の", "জাপানি ভাষার"), ("本", "hon", "本", "বই"), ("を", "o", "কে", "কে"), ("読みます", "yomimasu", "読みます", "পড়ি")]),
            make_item("jp-p10-l41-004", "おんがくを ききます。", "おんがくをききます。", "Ongaku o kikimasu.", "গান শুনি।", "ওনগাকু ও কিকিমাসু।", [("音楽", "ongaku", "音楽", "গান"), ("を", "o", "কে", "কে"), ("聞きます", "kikimasu", "聞きます", "শুনি")])
        ]
    },
    {
        "id": "jp-foundations-l42",
        "order": 2,
        "title_bn": "কাজের স্থান ও মাধ্যম — '〜で' (Action Location & Means)",
        "title_target": "Action Location & Instrumental Means with Particle 'de'",
        "intro_bn": "যে স্থানে কোনো কাজ সংঘটিত হয় এবং যে মাধ্যম দিয়ে কাজ করা হয়, তার পরে で (de) বসে।",
        "structure": ["Place で + Action Verb", "Tool/Vehicle で + Action Verb"],
        "items": [
            make_item("jp-p10-l42-001", "としょかんで べんきょうします。", "としょかんでべんきょうします。", "Toshokan de benkyou shimasu.", "লাইব্রেরিতে পড়াশোনা করি।", "তোশোকাং দে বেনকিয়োও শিমাসু।", [("図書館", "toshokan", "図書館", "লাইব্রেরি"), ("で", "de", "で", "এ"), ("勉強します", "benkyou shimasu", "勉強します", "পড়াশোনা করি")]),
            make_item("jp-p10-l42-002", "レストランで ひるごはんを たべます。", "れすとらんでひるごはんをたべます。", "Resutoran de hirugohan o tabemasu.", "রেস্তোরাঁয় দুপুরের খাবার খাই।", "রেসুতোরাং দে হিরুগোহাং ও তাবেমাসু।", [("レストラン", "resutoran", "レストラン", "রেস্তোরাঁ"), ("で", "de", "で", "এ"), ("昼ご飯", "hirugohan", "昼ご飯", "দুপুরের খাবার"), ("を", "o", "কে", "কে"), ("食べます", "tabemasu", "食べます", "খাই")]),
            make_item("jp-p10-l42-003", "でんしゃで かいしゃへ いきます。", "でんしゃでかいしゃへいきます。", "Densha de kaisha e ikimasu.", "ট্রেনে করে অফিসে যাই।", "দেনশা দে কাইশা এ ইকিমাসু।", [("電車", "densha", "電車", "ট্রেন"), ("で", "de", "で", "দিয়ে"), ("会社", "kaisha", "会社", "কোম্পানি/অফিস"), ("へ", "e", "へ", "দিকে"), ("行きます", "ikimasu", "行きます", "যাই")]),
            make_item("jp-p10-l42-004", "はしで ごはんを たべます。", "はしでごはんをたべます。", "Hashi de gohan o tabemasu.", "চপস্টিক দিয়ে খাবার খাই।", "হাশি দে গোহাং ও তাবেমাসু।", [("箸", "hashi", "箸", "চপস্টিক"), ("で", "de", "で", "দিয়ে"), ("ご飯", "gohan", "ご飯", "খাবার"), ("を", "o", "কে", "কে"), ("食べます", "tabemasu", "食べます", "খাই")])
        ]
    },
    {
        "id": "jp-foundations-l43",
        "order": 3,
        "title_bn": "গন্তব্য ও দিক — '〜へ / 〜に' (Destination & Movement)",
        "title_target": "Movement Verbs & Destination with 'e' / 'ni'",
        "intro_bn": "যাওয়া (行きます), আসা (来ます), ফিরে যাওয়া (帰ります) এর গন্তব্যের পরে へ (উচ্চারণ 'এ') বা に বসে।",
        "structure": ["Destination + へ/に + 行きます / 来ます / 帰ります"],
        "items": [
            make_item("jp-p10-l43-001", "がっこうへ いきます。", "がっこうへいきます。", "Gakkou e ikimasu.", "স্কুলে যাই।", "গাক্‌কোও এ ইকিমাসু।", [("学校", "gakkou", "学校", "স্কুল"), ("へ", "e", "へ", "দিকে"), ("行きます", "ikimasu", "行きます", "যাই")]),
            make_item("jp-p10-l43-002", "きょねん にほんへ きました。", "きょねんにほんへきました。", "Kyonen Nihon e kimashita.", "গত বছর জাপানে এসেছিলাম।", "কিয়োনেন নিহোং এ কিমাশিতা।", [("去年", "kyonen", "去年", "গত বছর"), ("日本", "Nihon", "日本", "জাপান"), ("へ", "e", "へ", "দিকে"), ("来ました", "kimashita", "来ました", "এসেছিলাম")]),
            make_item("jp-p10-l43-003", "ろくじに うちへ かえります。", "ろくじにうちへかえります。", "Rokuji ni uchi e kaerimasu.", "ছয়টায় বাড়ি ফিরি।", "রোকুজি নি উচি এ কাএরিমাসু।", [("六時", "rokuji", "六時", "৬টা"), ("に", "ni", "に", "এ"), ("うち", "uchi", "家", "বাড়ি"), ("へ", "e", "へ", "দিকে"), ("帰ります", "kaerimasu", "帰ります", "ফিরি")])
        ]
    },
    {
        "id": "jp-foundations-l44",
        "order": 4,
        "title_bn": "সময় ও সীমা — 'Time に', '〜から 〜まで'",
        "title_target": "Specific Time 'ni' & Spans 'kara ... made'",
        "intro_bn": "নির্দিষ্ট সময়ে কাজ বোঝাতে に এবং শুরুর ও শেষের সময় বা স্থান বোঝাতে から (থেকে) ও まで (পর্যন্ত) বসে।",
        "structure": ["Time に + Verb", "Point A から + Point B まで"],
        "items": [
            make_item("jp-p10-l44-001", "しちじに おきます。", "しちじにおきます。", "Shichiji ni okimasu.", "সাতটায় ঘুম থেকে উঠি।", "শিচিজি নি ওকিমাসু।", [("七時", "shichiji", "七時", "৭টা"), ("に", "ni", "に", "এ"), ("起きます", "okimasu", "起きます", "উঠি")]),
            make_item("jp-p10-l44-002", "くじから ごじまで はたらきます。", "くじからごじまではたらきます。", "Kuji kara goji made hatarakimasu.", "সকাল ৯টা থেকে বিকাল ৫টা পর্যন্ত কাজ করি।", "কুজি কারা গোজি মাদে হাতারাকিমাসু।", [("九時", "kuji", "九時", "৯টা"), ("から", "kara", "から", "থেকে"), ("五時", "goji", "五時", "৫টা"), ("まで", "made", "まで", "পর্যন্ত"), ("働きます", "hatarakimasu", "働きます", "কাজ করি")]),
            make_item("jp-p10-l44-003", "じゅういちじに ねます。", "じゅういちじにねます。", "Juuichiji ni nemasu.", "রাত এগারোটায় ঘুমাই।", "জিউউইচিজি নি নেমাসু।", [("十一時", "juuichiji", "十一時", "১১টা"), ("に", "ni", "に", "এ"), ("寝ます", "nemasu", "寝ます", "ঘুমাই")]),
            make_item("jp-p10-l44-004", "ともだちと えいがを みます。", "ともだちとえいがをみます。", "Tomodachi to eiga o mimasu.", "বন্ধুর সাথে সিনেমা দেখি।", "তোমোদাচি তো এইগা ও মিমাসু।", [("友達", "tomodachi", "友達", "বন্ধু"), ("と", "to", "と", "সাথে"), ("映画", "eiga", "映画", "চলচ্চিত্র"), ("を", "o", "কে", "কে"), ("見ます", "mimasu", "見ます", "দেখি")])
        ]
    }
]
parts.append({
    "id": "jp-foundations-p10",
    "order": 10,
    "level": "A1",
    "title_bn": "কাজের ক্রিয়া ও মৌলিক পার্টিকেল (Action Verbs & Particles を, で, へ, に)",
    "title_target": "Action Verbs & Core Particles (o, de, e, ni, to, kara, made)",
    "lessons": p10_lessons
})

# ==============================================================================
# PART 11: ভদ্র বর্তমান ক্রিয়া ও আমন্ত্রণ (Polite Verbs & Invitations)
# ==============================================================================
p11_lessons = [
    {
        "id": "jp-foundations-l45",
        "order": 1,
        "title_bn": "ক্রিয়াপদের ৩টি গ্রুপ ও ভদ্র রূপ (Verb Groups & Masu/Masen)",
        "title_target": "The 3 Japanese Verb Groups & Polite Conjugation",
        "intro_bn": "গ্রুপ ১ (গোদন ক্রিয়া), গ্রুপ ২ (ইচিদান ক্রিয়া), অনিয়মিত (する ও くる)। বর্তমান হ্যাঁ-বোধক ます এবং না-বোধক ません।",
        "structure": ["Verb ます (Affirmative)", "Verb ません (Negative)"],
        "items": [
            make_item("jp-p11-l45-001", "まいあさ コーヒーを のみます。", "まいあさこーひーをのみます。", "Maiasa koohii o nomimasu.", "প্রতিদিন সকালে কফি খাই।", "মাইআসা কোওহিই ও নোমিমাসু।", [("毎朝", "maiasa", "毎朝", "প্রতিদিন সকাল"), ("コーヒー", "koohii", "コーヒー", "কফি"), ("を", "o", "কে", "কে"), ("飲みます", "nomimasu", "飲みます", "পান করি")]),
            make_item("jp-p11-l45-002", "あさごはんを たべません。", "あさごはんをたべません。", "Asagohan o tabemasen.", "সকালের নাশতা খাই না।", "আসা গোহাং ও তাবেমাসেন।", [("朝ご飯", "asagohan", "朝ご飯", "সকালের নাশতা"), ("を", "o", "কে", "কে"), ("食べません", "tabemasen", "食べません", "খাই না")], polarity="negative"),
            make_item("jp-p11-l45-003", "にちようびは はたらきません。", "にちようびわはたらきません。", "Nichiyoubi wa hatarakimasen.", "রবিবারে কাজ করি না।", "নিচিয়োওবি ওয়া হাতারাকিমাসেন।", [("日曜日", "nichiyoubi", "日曜日", "রবিবার"), ("は", "wa", "は", "হলো"), ("働きません", "hatarakimasen", "働きません", "কাজ করি না")], polarity="negative")
        ]
    },
    {
        "id": "jp-foundations-l46",
        "order": 2,
        "title_bn": "দৈনন্দিন রুটিন কথন — 'わたしの一日' (Reading 1 Narrative)",
        "title_target": "Daily Routine Monologue (Watashi no Ichinichi)",
        "intro_bn": "সকাল থেকে রাত পর্যন্ত সারাদিনের কাজের ধারাবাহিক স্ব-বর্ণনা।",
        "structure": ["Time に + Action + て + Sequence"],
        "items": [
            make_item("jp-p11-l46-001", "わたしは まいあさ ろくじはんに おきます。", "わたしはまいあさろくじはんにおきます。", "Watashi wa maiasa rokuji-han ni okimasu.", "আমি প্রতিদিন সকাল সাড়ে ছয়টায় ঘুম থেকে উঠি।", "ওয়াতাশি ওয়া মাইআসা রোকুজি-হান নি ওকিমাসু।"),
            make_item("jp-p11-l46-002", "しちじに あさごはんを たべて、はちじに がっこうへ いきます。", "しちじにあさごはんをたべて、はちじにがっこうへいきます。", "Shichiji ni asagohan o tabete, hachiji ni gakkou e ikimasu.", "সাতটায় নাশতা খেয়ে আটটায় স্কুলে যাই।", "শিচিজি নি আসাগোহাং ও তাবেতে, হাচিজি নি গাক্‌কোও এ ইকিমাসু।"),
            make_item("jp-p11-l46-003", "よるは ほんを よんで、じゅういちじに ねます。", "よるはほんをよんで、じゅういちじにねます。", "Yoru wa hon o yonde, juuichiji ni nemasu.", "রাতে বই পড়ে এগারোটায় ঘুমাই।", "ইয়োরু ওয়া হোং ও ইয়োন্দে, জিউউইচিজি নি নেমাসু।")
        ]
    },
    {
        "id": "jp-foundations-l47",
        "order": 3,
        "title_bn": "ভদ্র আমন্ত্রণ ও প্রস্তাব — '〜ませんか / 〜ましょう'",
        "title_target": "Polite Invitations & Suggestions (Masen ka / Mashou)",
        "intro_bn": "একসাথে কোনো কাজ করার ভদ্র আমন্ত্রণ '〜ませんか' এবং উৎসাহব্যঞ্জক প্রস্তাব '〜ましょう' (চলুন করি)।",
        "structure": ["Verbます-stem + ませんか (Shall we...?)", "Verbます-stem + ましょう (Let's...)"],
        "items": [
            make_item("jp-p11-l47-001", "いっしょに コーヒーを のみませんか。", "いっしょにこーひーをのみませんか。", "Issho ni koohii o nomimasen ka.", "একসাথে কফি খাবেন?", "ইশ্শো নি কোওহিই ও নোমিমাসেন কা?", [("いっしょに", "issho ni", "一緒に", "একসাথে"), ("コーヒー", "koohii", "コーヒー", "কফি"), ("を", "o", "কে", "কে"), ("飲みませんか", "nomimasen ka", "飲みませんか", "খাবেন কি?")]),
            make_item("jp-p11-l47-002", "ええ、のみましょう。", "ええ、のみましょう。", "Ee, nomimashou.", "হঁ্যা, চলুন খাই।", "এএ, নোমিমাশোও।", [("ええ", "ee", "ええ", "হঁ্যা"), ("飲みましょう", "nomimashou", "飲みましょう", "চলুন পান করি")]),
            make_item("jp-p11-l47-003", "すこし やすみましょう。", "すこしやすみましょう。", "Sukoshi yasumimashou.", "চলুন একটু বিশ্রাম নিই।", "সুকোশি ইয়াসুমিমাশোও।", [("少し", "sukoshi", "少し", "একটু"), ("休みましょう", "yasumimashou", "休みましょう", "চলুন বিশ্রাম নিই")]),
            make_item("jp-p11-l47-004", "にもつを もちましょうか。", "にもつをもちましょうか。", "Nimotsu o mochimashou ka.", "আমি কি আপনার মালামাল বহন করব?", "নিমোৎসু ও মোচিমাশোও কা?", [("荷物", "nimotsu", "荷物", "লাগেজ/মালামাল"), ("を", "o", "কে", "কে"), ("持ちましょうか", "mochimashou ka", "持ちましょうか", "বহন করব কি?")])
        ]
    }
]
parts.append({
    "id": "jp-foundations-p11",
    "order": 11,
    "level": "A1",
    "title_bn": "দৈনন্দিন রুটিন ও আমন্ত্রণ (Daily Routine & Invitations)",
    "title_target": "Polite Verb Tenses, Daily Routine & Social Invitations",
    "lessons": p11_lessons
})

# ==============================================================================
# PART 12: বিশেষণ ও অনুভূতি (い-Adjectives ও な-Adjectives - Grammar 26–28)
# ==============================================================================
p12_lessons = [
    {
        "id": "jp-foundations-l48",
        "order": 1,
        "title_bn": "い-বিশেষণ: হ্যাঁ-বোধক ও না-বোধক রূপ (i-Adjectives)",
        "title_target": "i-Adjectives: Affirmative & Negative (~kunai desu)",
        "intro_bn": "শেষে い থাকা বিশেষণ। হ্যাঁ-বোধকে সরাসরি です বসে এবং না-বোধকে い উঠে 〜くないです বসে।",
        "structure": ["Affirmative: い-Adj + です", "Negative: [い বাদ] + くないです"],
        "items": [
            make_item("jp-p12-l48-001", "このまちは おおきいです。", "このまちはおおきいです。", "Kono machi wa ookii desu.", "এই শহরটি বড়।", "কোনো মাচি ওয়া ওওকিই দেস।", [("この", "kono", "この", "এই"), ("町", "machi", "町", "শহর"), ("は", "wa", "は", "হলো"), ("大きい", "ookii", "大きい", "বড়"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p12-l48-002", "このほんは たかくないです。やすいです。", "このほんわたかくないです。やすいです。", "Kono hon wa takakunai desu. Yasui desu.", "এই বইটি দামি নয়। সস্তা।", "কোনো হোং ওয়া তাকাকুনাই দেস। ইয়াসুই দেস।", [("この本", "kono hon", "この本", "এই বই"), ("は", "wa", "は", "হলো"), ("高くないです", "takakunai desu", "高くないです", "দামি নয়"), ("安いです", "yasui desu", "安いです", "সস্তা হয়")], polarity="negative"),
            make_item("jp-p12-l48-003", "にほんの たべものは おいしいです。", "にほんのたべものはおいしいです。", "Nihon no tabemono wa oishii desu.", "জাপানি খাবার সুস্বাদু।", "নিহোন নো তাবেমোনো ওয়া ওইশিই দেস।", [("日本の", "Nihon no", "日本の", "জাপানের"), ("食べ物", "tabemono", "食べ物", "খাবার"), ("は", "wa", "は", "হলো"), ("おいしい", "oishii", "美味しい", "সুস্বাদু"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p12-l48-004", "きょうは あつくないです。", "きょうわあつくないです。", "Kyou wa atsukunai desu.", "আজ গরম নয়।", "কিয়োও ওয়া আৎসুকুনাই দেস।", [("今日", "kyou", "今日", "আজ"), ("は", "wa", "は", "হলো"), ("暑くないです", "atsukunai desu", "暑くないです", "গরম নয়")], polarity="negative"),
            make_item("jp-p12-l48-005", "このカメラは いいです。よくないです。", "このかめらわいいです。よくないです。", "Kono kamera wa ii desu. Yokunai desu.", "এই ক্যামেরাটি ভালো। ভালো নয় (অনিয়মিত)।", "কোনো কামেরাঁ ওয়া ইই দেস। ইয়োকুনাই দেস।", item_type="drill")
        ]
    },
    {
        "id": "jp-foundations-l49",
        "order": 2,
        "title_bn": "な-বিশেষণ: বৈশিষ্ট্য ও গুণাগুণ (na-Adjectives)",
        "title_target": "na-Adjectives: Shizuka, Kirei, Genki, Benri",
        "intro_bn": "বিশেষ্যের আগে な বসে (যেমন: 静かな部屋) এবং বাক্য শেষে です ও না-বোধকে じゃありません বসে। きれい দেখতে い হলেও な-বিশেষণ!",
        "structure": ["Noun Modification: な-Adj + な + Noun", "Predicate: な-Adj + です / じゃありません"],
        "items": [
            make_item("jp-p12-l49-001", "ここは しずかな へやです。", "ここはしずかなへやです。", "Koko wa shizuka na heya desu.", "এটি একটি শান্ত ঘর।", "কোকো ওয়া শিজুকা না হেয়া দেস।", [("ここ", "koko", "ここ", "এখানে"), ("は", "wa", "は", "হলো"), ("静かな", "shizuka na", "静かな", "শান্ত"), ("部屋", "heya", "部屋", "ঘর"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p12-l49-002", "このまちは べんりです。", "このまちはべんりです。", "Kono machi wa benri desu.", "এই শহরটি সুবিধাজনক।", "কোনো মাচি ওয়া বেনরি দেস।", [("この", "kono", "この", "এই"), ("町", "machi", "町", "শহর"), ("は", "wa", "は", "হলো"), ("便利", "benri", "便利", "সুবিধাজনক"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p12-l49-003", "きょうは ひまじゃ ありません。", "きょうわひまじゃありません。", "Kyou wa hima ja arimasen.", "আজ আমি অবসর নই (ব্যস্ত)।", "কিয়োও ওয়া হিমা জা আরিমাসেন।", [("今日", "kyou", "今日", "আজ"), ("は", "wa", "は", "হলো"), ("暇じゃありません", "hima ja arimasen", "暇じゃありません", "অবসর নই")], polarity="negative"),
            make_item("jp-p12-l49-004", "マリアさんは とても きれいです。", "まりあさんはとてもきれいです。", "Maria-san wa totemo kirei desu.", "মারিয়া খুবই সুন্দরী।", "মারিয়া-সান ওয়া তোতেমো কিরেই দেস।", [("マリアさん", "Maria-san", "マリアさん", "মারিয়া-সান"), ("は", "wa", "は", "হলো"), ("とても", "totemo", "とても", "খুবই"), ("きれい", "kirei", "綺麗", "সুন্দরী/পরিচ্ছন্ন"), ("です", "desu", "です", "হয়")])
        ]
    },
    {
        "id": "jp-foundations-l50",
        "order": 3,
        "title_bn": "পছন্দ, অপছন্দ ও সামর্থ্য (好き, 嫌い, 上手, 下手 - Grammar 29–32)",
        "title_target": "Preferences, Desires & Abilities (Suki, Hoshii, Dekiru)",
        "intro_bn": "পছন্দ, চাওয়া বা পারদর্শিতার অবজেক্টে を এর পরিবর্তে が বসে (যেমন: 音楽が好きです)।",
        "structure": ["Noun + が + 好きです / 嫌いです", "Noun + が + ほしいです (I want ...)", "Verb辞書形 + ことが できます (I can ...)"],
        "items": [
            make_item("jp-p12-l50-001", "わたしは おんがくが すきです。", "わたしはおんがくがすきです。", "Watashi wa ongaku ga suki desu.", "আমি সঙ্গীত পছন্দ করি।", "ওয়াতাশি ওয়া ওনগাকু গা সুকি দেস।", [("わたし", "watashi", "私", "আমি"), ("は", "wa", "は", "হলো"), ("音楽", "ongaku", "音楽", "গান"), ("が", "ga", "টি", "টি"), ("好きです", "suki desu", "好きです", "পছন্দ করি")]),
            make_item("jp-p12-l50-002", "あたらしい じしょが ほしいです。", "あたらしいじしょがほしいです。", "Atarashii jisho ga hoshii desu.", "আমি একটি নতুন অভিধান চাই।", "আতারাশিই জিশো গা হোশিই দেস।", [("新しい", "atarashii", "新しい", "নতুন"), ("辞書", "jisho", "辞書", "অভিধান"), ("が", "ga", "টি", "টি"), ("ほしいです", "hoshii desu", "欲しいです", "চাই")]),
            make_item("jp-p12-l50-003", "にほんへ いきたいです。", "にほんへいきたいです。", "Nihon e ikitai desu.", "আমি জাপানে যেতে চাই।", "নিহোং এ ইকিতাই দেস।", [("日本", "Nihon", "日本", "জাপান"), ("へ", "e", "へ", "দিকে"), ("行きたいです", "ikitai desu", "行きたいです", "যেতে চাই")]),
            make_item("jp-p12-l50-004", "にほんごを すこし はなすことが できます。", "にほんごをすこしはなすことができます。", "Nihongo o sukoshi hanasu koto ga dekimasu.", "আমি একটু জাপানি বলতে পারি।", "নিহঙ্গো ও সুকোশি হানাসু কোতো গা দেকিমাসু।", [("日本語", "nihongo", "日本語", "জাপানি ভাষা"), ("を", "o", "কে", "কে"), ("少し", "sukoshi", "少し", "অল্প"), ("話すことが", "hanasu koto ga", "話すことが", "বলতে"), ("できます", "dekimasu", "できます", "পারি")])
        ]
    }
]
parts.append({
    "id": "jp-foundations-p12",
    "order": 12,
    "level": "A1",
    "title_bn": "বিশেষণ, পছন্দ ও ইচ্ছা (Adjectives, Preferences & Abilities)",
    "title_target": "i-Adjectives, na-Adjectives, Wants & Potential Ability",
    "lessons": p12_lessons
})

# ==============================================================================
# PART 13: ব্যবহারিক কনভারসেশন ও মিনি-ডায়ালগ (Situational Mini-Dialogues)
# ==============================================================================
p13_lessons = [
    {
        "id": "jp-foundations-l51",
        "order": 1,
        "title_bn": "প্রথম পরিচয় ও সম্ভাষণ (First Meeting: Hajimemashite Dialogue)",
        "title_target": "First Meeting & Self-Introduction Dialogue",
        "intro_bn": "প্রথম পরিচয়ের সম্পূর্ণ বাস্তবমুখী কথোপকথন।",
        "structure": ["A: はじめまして。〜から来ました", "B: はじめまして。〜です"],
        "items": [
            make_item("jp-p13-l51-001", "はじめまして。わたしは ラヒムです。バングラデシュから 来ました。", "はじめまして。わたしわらひむです。ばんぐらでしゅからきました。", "Hajimemashite. Watashi wa Rahimu desu. Banguradeshu kara kimashita.", "প্রথম পরিচয়। আমি রহিম। বাংলাদেশ থেকে এসেছি।", "হাজিমেমাশিতে। ওয়াতাশি ওয়া রাহিমু দেস। বাঙ্গুরাদেশু কারা কিমাশিতা।", item_type="dialogue"),
            make_item("jp-p13-l51-002", "はじめまして。たなかです。どうぞ よろしく おねがいします。", "はじめまして。たなかです。どうぞよろしくおねがいします。", "Hajimemashite. Tanaka desu. Douzo yoroshiku onegaishimasu.", "পরিচিত হয়ে ভালো লাগল। আমি তানাকা। আপনার সহযোগিতা কামনা করি।", "হাজিমেমাশিতে। তানাকা দেস। দোওজো ইয়োরোশিকু ওনেগাইশিমাসু।", item_type="dialogue"),
            make_item("jp-p13-l51-003", "こちらこそ、よろしく おねがいします。", "こちらこそ、よろしくおねがいします。", "Kochirakoso, yoroshiku onegaishimasu.", "আমার পক্ষ থেকেও আপনার সহযোগিতা কামনা করি।", "কোচিরাকোসো, ইয়োরোশিকু ওনেগাইশিমাসু।", item_type="dialogue")
        ]
    },
    {
        "id": "jp-foundations-l52",
        "order": 2,
        "title_bn": "দোকানে কেনাকাটা ও ক্যাশিয়ার (Shopping & Convenience Store)",
        "title_target": "Convenience Store & Shopping Dialogue",
        "intro_bn": "দোকানে গিয়ে জিনিস চাওয়া ও ক্যাশিয়ারের সাথে কথা বলা।",
        "structure": ["客: この〜は いくらですか", "店員: 〜円です"],
        "items": [
            make_item("jp-p13-l52-001", "すみません。このおちゃは いくらですか。", "すみません。このおちゃわいくらですか。", "Sumimasen. Kono ocha wa ikura desu ka.", "মাফ করবেন। এই চা-টির দাম কত?", "সুমিমাসেন। কোনো ওচা ওয়া ইকুরা দেসু কা?", item_type="dialogue"),
            make_item("jp-p13-l52-002", "ひゃくごじゅうえんです。", "ひゃくごじゅうえんです。", "Hyaku gojuu-en desu.", "১৫০ ইয়েন।", "হিয়াকু গোজিউউ-য়েন দেস।", item_type="dialogue"),
            make_item("jp-p13-l52-003", "じゃ、これを にほん ください。", "じゃ、これをにほんください。", "Ja, kore o nihon kudasai.", "তাহলে এটা দুটি দিন।", "জা, কোরে ও নিহোং কুদাসাই।", item_type="dialogue")
        ]
    },
    {
        "id": "jp-foundations-l53",
        "order": 3,
        "title_bn": "স্টেশনে টিকিট ও পথ নির্দেশনা (Station & Navigation Dialogue)",
        "title_target": "Train Station & Navigation Dialogue",
        "intro_bn": "ট্রেন স্টেশনে টিকিট কেনা ও কোন প্ল্যাটফর্মে ট্রেন আসবে তা জানার সংলাপ।",
        "structure": ["A: 〜までの 切符を ください", "B: 〜番線です"],
        "items": [
            make_item("jp-p13-l53-001", "すみません。とうきょうまでの きっぷを いちまい ください。", "すみません。とうきょうまでのきっぷをいちまいください。", "Sumimasen. Toukyou made no kippu o ichimai kudasai.", "মাফ করবেন। টোকিও পর্যন্ত একটি টিকিট দিন।", "সুমিমাসেন। তোকিও মাদে নো কিপ্পু ও ইচিমাই কুদাসাই।", item_type="dialogue"),
            make_item("jp-p13-l53-002", "はい。せんにひゃくえんです。とうきょうゆきは ３ばんせんです。", "はい。せんにひゃくえんです。とうきょうゆきわさんばんせんです。", "Hai. Sen nihyaku-en desu. Toukyou-yuki wa sanbansen desu.", "জি। ১,২০০ ইয়েন। টোকিওগামী ট্রেন ৩ নম্বর প্ল্যাটফর্মে।", "হাই। সেন নিহিয়াকু-য়েন দেস। তোকিও-ইউকি ওয়া সানবানসেন দেস।", item_type="dialogue"),
            make_item("jp-p13-l53-003", "どうも ありがとう ございます。", "どうもありがとうございます。", "Doumo arigatou gozaimasu.", "আপনাকে অনেক ধন্যবাদ।", "দোওমো আরিগাতোও গোজাইমাসু।", item_type="dialogue")
        ]
    }
]
parts.append({
    "id": "jp-foundations-p13",
    "order": 13,
    "level": "A1",
    "title_bn": "ব্যবহারিক মিনি-ডায়ালগ ও সংলাপ (Situational Mini-Dialogues)",
    "title_target": "Situational Mini-Dialogues & Everyday Conversations",
    "lessons": p13_lessons
})

total_lessons = sum(len(p["lessons"]) for p in parts)
total_items = sum(sum(len(l["items"]) for l in p["lessons"]) for p in parts)

course_data = {
    "schema_version": 1,
    "course": course_metadata,
    "ladder_default": ladder_default,
    "stats": {
        "lessons": total_lessons,
        "items": total_items
    },
    "parts": parts
}

with open(DEST_FILE, 'w', encoding='utf-8') as f:
    json.dump(course_data, f, ensure_ascii=False, indent=2)

print(f"Course 1 rebuilt successfully!")
print(f"Saved to: {DEST_FILE}")
print(f"Total Parts: {len(parts)}")
print(f"Total Lessons: {total_lessons}")
print(f"Total Items: {total_items}")
