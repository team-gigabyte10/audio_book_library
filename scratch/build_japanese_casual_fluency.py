# -*- coding: utf-8 -*-
"""
Builder for Course 3: Japanese Spoken Fluency & Casual Conversation (JLPT N4)
Generates: android/app/src/main/assets/spoken_japanese_casual_fluency.json
Curated from 00_Bangla_Japanese_N5_to_N1_Extended_Master_Complete.md
"""
import json
import os
import sys

sys.stdout.reconfigure(encoding='utf-8')

DEST_FILE = 'android/app/src/main/assets/spoken_japanese_casual_fluency.json'

course_metadata = {
    "id": "jp-spoken-casual-fluency",
    "target_lang": "ja",
    "base_lang": "bn",
    "title_bn": "জাপানিজ স্পোকেন: Casual Fluency (JLPT N4 কথ্য ভাষা)",
    "title_target": "Spoken Japanese: Casual Fluency & Plain Forms (JLPT N4)",
    "source": "Curated from N4 Extended Master Complete & Spoken Japanese Audio Framework",
    "note": "বন্ধুমহলের সাধারণ কথ্য রূপ (Plain Form: 辞書形・ナイ形・タ形), সামর্থ্য (可能動詞: 話せる/できる), ৪টি শর্তের ব্যবহার (たら/なら/ば/と), ইচ্ছা ও ভবিষ্যৎ পরিকল্পনা (〜つもり/〜予定/〜ことにする), মতামত ও উদ্ধৃতি (〜と思う/〜と言う), উপদেশ (〜たほうがいい), কর্মবাচ্য ও প্রযোজক ক্রিয়া (受身形・使役形), এবং ৬-রূপান্তর ড্রিল।",
    "welcome_text": "জাপানিজ স্পোকেন Casual Fluency ক্লাসে স্বাগতম! বন্ধুদের সাথে সাবলীল অনানুষ্ঠানিক জাপানিজে কথা বলা এবং জটিল মনোভাব প্রকাশের কৌশল রপ্ত করুন।"
}

ladder_default = [
    {"play": "target", "speed": 0.85},
    {"play": "bn", "speed": 1.15},
    {"play": "target", "speed": 0.95},
    {"play": "target", "speed": 1.05},
    {"play": "target", "speed": 1.15, "min_level": "A2"},
    {"pause_ms": 1200}
]

def make_item(item_id, target, target_kana, romaji, bn, bn_pron, tokens_tuples=None, sentence_type="assertive", polarity="affirmative", tense="present_simple", item_type="sentence", level="A2"):
    if tokens_tuples is None:
        tokens = [{"t": target, "romaji": romaji, "kanji": target, "bn": bn}]
    else:
        tokens = [{"t": t[0], "romaji": t[1], "kanji": t[2], "bn": t[3]} for t in tokens_tuples]
    
    tags = {
        "sentence_type": sentence_type,
        "polarity": polarity,
        "tense": tense,
        "jlpt": "N4"
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
# PART 1: প্লেইন ফর্ম ও বন্ধুমহলের ভাষা (Casual / Plain Japanese Speaking)
# ==============================================================================
p1_lessons = [
    {
        "id": "jp-cas-l01",
        "order": 1,
        "title_bn": "সাধারণ বর্তমান ও ভবিষ্যৎ প্লেইন রূপ (Dictionary Form)",
        "title_target": "Casual Present Affirmative (Dictionary Form)",
        "intro_bn": "বন্ধুবান্ধব বা সমবয়সীদের সাথে কথা বলার সময় মার্জিত '〜ます' বাদ দিয়ে ক্রিয়ার মূল ডিকশনারি রূপ (Dictionary Form) ব্যবহৃত হয়। যেমন: 食べます -> 食べる, 行きます -> 行く।",
        "structure": ["Casual / Plain Form: Verb (Dictionary Form)"],
        "items": [
            make_item("jp-cas-p1-l1-001", "明日 東京へ 行く。", "あしたとうきょうえいく。", "Ashita Toukyou e iku.", "কাল টোকিও যাব। (ইনফরমাল)", "আশিতা তোকিও এ ইকু।", [("明日", "ashita", "明日", "আগামীকাল"), ("東京へ", "Toukyou e", "東京へ", "টোকিওর দিকে"), ("行く", "iku", "行く", "যাব")]),
            make_item("jp-cas-p1-l1-002", "今から ご飯 食べる。", "いまからごはんたべる。", "Ima kara gohan taberu.", "এখন খাবার খাব।", "ইমা কারা গোহান তাবেরু।", [("今から", "ima kara", "今から", "এখন থেকে"), ("ご飯", "gohan", "ご飯", "খাবার"), ("食べる", "taberu", "食べる", "খাব")]),
            make_item("jp-cas-p1-l1-003", "今晩 映画 見る？ うん、見る。", "こんばんえいがみる？うん、みる。", "Konban eiga miru? Un, miru.", "আজ রাতে সিনেমা দেখবি? হ্যাঁ, দেখব।", "কোনবান এইগা মিরু? উন, মিরু।", [("今晩", "konban", "今晩", "আজ রাত"), ("映画見る？", "eiga miru?", "映画見る？", "সিনেমা দেখবি?"), ("うん", "un", "うん", "হ্যাঁ (Casual)"), ("見る", "miru", "見る", "দেখব")])
        ]
    },
    {
        "id": "jp-cas-l02",
        "order": 2,
        "title_bn": "সাধারণ না-বোধক প্লেইন রূপ (Casual Negative: Nai-Form)",
        "title_target": "Casual Negative (~nai form)",
        "intro_bn": "অনানুষ্ঠানিক না-বোধক বাক্যে '〜ません' এর স্থানে '〜ない' (Nai-Form) বসে। যেমন: 飲まない (পান করব না), 行かない (যাব না)।",
        "structure": ["Casual Negative: Verb (Nai-Form)"],
        "items": [
            make_item("jp-cas-p1-l2-001", "今日は どこへも 行かない。", "きょうわどこえもいかない。", "Kyou wa doko e mo ikanai.", "আজ কোথাও যাব না।", "কিওও ওয়া দোকো এ মো ইকনাই।", [("今日は", "kyou wa", "今日は", "আজ"), ("どこへも", "doko e mo", "どこへも", "কোথাও"), ("行かない", "ikanai", "行かない", "যাব না")], polarity="negative"),
            make_item("jp-cas-p1-l2-002", "お酒は 飲まない。", "おさけわのまない。", "Osake wa nomanai.", "মদ খাই না।", "ওসাকে ওয়া নোমানাই।", [("お酒は", "osake wa", "お酒は", "মদ"), ("飲まない", "nomanai", "飲まない", "পান করি না")], polarity="negative"),
            make_item("jp-cas-p1-l2-003", "朝ご飯 食べないの？ うん、食べない。", "あさはんたべないの？うん、たべない。", "Asagohan tabenai no? Un, tabenai.", "সকালের নাস্তা খাবি না? না, খাব না।", "আসাগোহান তাবেনাই নো? উন, তাবেনাই।", [("朝ご飯", "asagohan", "朝ご飯", "নাস্তা"), ("食べないの？", "tabenai no?", "食べないの？", "খাবি না?"), ("うん", "un", "うん", "হ্যাঁ/না (Casual)"), ("食べない", "tabenai", "食べない", "খাব না")], polarity="negative")
        ]
    },
    {
        "id": "jp-cas-l03",
        "order": 3,
        "title_bn": "সাধারণ অতীত প্লেইন রূপ (Casual Past: Ta-Form & Nakatta)",
        "title_target": "Casual Past Affirmative & Negative (Ta-Form / Nakatta)",
        "intro_bn": "বন্ধুমহলে অতীতের কাজ বলতে '〜ました' এর স্থানে '〜た' (Ta-form) এবং না-বোধকে '〜なかった' (nakatta) বসে।",
        "structure": ["Casual Past: Verb-た / Verb-なかった"],
        "items": [
            make_item("jp-cas-p1-l3-001", "きのう 面白い 映画を 見た。", "きのうおもしろいえいがをみた。", "Kinou omoshiroi eiga o mita.", "গতকাল একটি মজার সিনেমা দেখলাম।", "কিনোও ওমোশিরোই এইগা ও মিতা।", [("きのう", "kinou", "昨日", "গতকাল"), ("面白い", "omoshiroi", "面白い", "মজার"), ("映画を", "eiga o", "映画を", "সিনেমা"), ("見た", "mita", "見た", "দেখলাম")], tense="past_simple"),
            make_item("jp-cas-p1-l3-002", "きのうは 勉強しなかった。", "きのうわべんきょうしなかった。", "Kinou wa benkyou shinakatta.", "গতকাল পড়িনি।", "কিনোও ওয়া বেনকিওও শিনাকাত্তা।", [("きのうは", "kinou wa", "昨日は", "গতকাল"), ("勉強しなかった", "benkyou shinakatta", "勉強しなかった", "পড়িনি")], tense="past_simple", polarity="negative"),
            make_item("jp-cas-p1-l3-003", "テスト どうだった？ 難しかった。", "てすとどうだった？むずかしかった。", "Tesuto dou datta? Muzukashikatta.", "পরীক্ষা কেমন হয়েছিল? কঠিন ছিল।", "তেসুতো দোও দাত্ত কা? মুজুকাশিকাত্তা।", [("テスト", "tesuto", "テスト", "পরীক্ষা"), ("どうだった？", "dou datta?", "どうだった？", "কেমন ছিল?"), ("難しかった", "muzukashikatta", "難しかった", "কঠিন ছিল")], tense="past_simple")
        ]
    },
    {
        "id": "jp-cas-l04",
        "order": 4,
        "title_bn": "বন্ধুমহলে কথপোকথন ও ৬-রূপান্তর ড্রিল (Plain Form 6 Transformations)",
        "title_target": "6 Sentence Transformations: Casual / Plain Form",
        "intro_bn": "অনানুষ্ঠানিক ভাষার ৬টি দ্রুত রূপান্তর ড্রিল (কথোপকথনে প্রশ্নচিহ্নের স্বর উঁচু হয়, 'か' সাধারণত বাদ পড়ে)।",
        "structure": ["Plain Affirmative", "Plain Negative", "Plain Question (?)", "Negative Q (-?)", "WH-Q", "Alternative Q"],
        "items": [
            make_item("jp-cas-p1-l4-001", "彼は 日本へ 行く。", "かれわにほんえいく。", "Kare wa Nihon e iku.", "১. হ্যাঁ-বোধক: সে জাপানে যাবে।", "কারে ওয়া নিহোন এ ইকু।", item_type="drill"),
            make_item("jp-cas-p1-l4-002", "彼は 日本へ 行かない。", "かれわにほんえいかない。", "Kare wa Nihon e ikanai.", "২. না-বোধক: সে জাপানে যাবে না।", "কারে ওয়া নিহোন এ ইকনাই।", item_type="drill", polarity="negative"),
            make_item("jp-cas-p1-l4-003", "彼は 日本へ 行く？", "かれわにほんえいく？", "Kare wa Nihon e iku?", "৩. প্রশ্নবোধক: সে কি জাপানে যাবে?", "কারে ওয়া নিহোন এ ইকু?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-cas-p1-l4-004", "彼は 日本へ 行かないの？", "かれわにほんえいかないの？", "Kare wa Nihon e ikanai no?", "৪. না-বোধক প্রশ্ন: সে কি জাপানে যাবে না?", "কারে ওয়া নিহোন এ ইকনাই নো?", item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-cas-p1-l4-005", "彼は いつ 日本へ 行く？ 来月 行くよ。", "かれわいつにほんえいく？らいげついくよ。", "Kare wa itsu Nihon e iku? Raigetsu iku yo.", "৫. WH-প্রশ্ন: সে কবে জাপান যাবে? আগামী মাসে যাবে।", "কারে ওয়া ইতসু নিহোন এ ইকু? রাইগেতসু ইকু ইয়ো।", item_type="drill", sentence_type="wh_question"),
            make_item("jp-cas-p1-l4-006", "バスで 行く？ 電車で 行く？", "ばすでいく？でんしゃでいく？", "Basu de iku? Densha de iku?", "৬. বিকল্প প্রশ্ন: বাসে যাবি, নাকি ট্রেনে?", "বাসু দে ইকু? দেনশা দে ইকু?", item_type="drill", sentence_type="alternative_question")
        ]
    }
]
parts.append({
    "id": "jp-casual-p1",
    "order": 1,
    "level": "A2",
    "title_bn": "প্লেইন ফর্ম ও বন্ধুমহলের ভাষা (Casual / Plain Japanese Speaking)",
    "title_target": "Casual & Plain Form Speaking (Dictionary, Nai, Ta)",
    "lessons": p1_lessons
})

# ==============================================================================
# PART 2: সামর্থ্য ও সম্ভাবনা (Potential Form: 可能動詞 & 〜ことができる)
# ==============================================================================
p2_lessons = [
    {
        "id": "jp-cas-l05",
        "order": 1,
        "title_bn": "সামর্থ্য ক্রিয়ার গঠন — '可能動詞' (Potential Verb Formation)",
        "title_target": "Potential Verb Conjugation (Group 1, 2, and 3)",
        "intro_bn": "কোনো কাজ করতে পারা বোঝাতে পোটেনশিয়াল ভার্ব বসে। গ্রুপ ১: u-ধ্বনি -> eる (話す -> 話せる, 飲む -> 飲める)। গ্রুপ ২: る -> られる (食べる -> 食べられる)। গ্রুপ ৩: する -> できる, 来る -> 来られる।",
        "structure": [
            "Group 1: u → eru (話す → 話せる, 買う → 買える)",
            "Group 2: ru → rareru (食べる → 食べられる, 見る → 見られる)",
            "Group 3: する → できる, くる → こられる"
        ],
        "items": [
            make_item("jp-cas-p2-l5-001", "わたしは 日本語が 少し 話せます。", "わたしわにほんごがすこしはなせます。", "Watashi wa nihongo ga sukoshi hanasemasu.", "আমি কিছুটা জাপানি ভাষায় কথা বলতে পারি।", "ওয়াতাশি ওয়া নিহঙ্গো গা সুকোশি হানাসেমাসু।", [("わたしは", "watashi wa", "私は", "আমি"), ("日本語が", "nihongo ga", "日本語が", "জাপানি ভাষা"), ("少し", "sukoshi", "少し", "একটু/কিছুটা"), ("話せます", "hanasemasu", "話せます", "কথা বলতে পারি")]),
            make_item("jp-cas-p2-l5-002", "生魚が 食べられますか。はい、食べられます。", "なまざかながたべられますか。はい、たべられます。", "Namazakana ga taberaremasu ka. Hai, taberaremasu.", "কাঁচা মাছ খেতে পারেন? হ্যাঁ, পারি।", "নামাজাকানা গা তাবেরারেমাসু কা? হাই, তাবেরারেমাসু।", [("生魚が", "namazakana ga", "生魚が", "কাঁচা মাছ"), ("食べられますか", "taberaremasu ka", "食べられますか", "খেতে পারেন কি"), ("はい", "hai", "はい", "হ্যাঁ"), ("食べられます", "taberaremasu", "食べられます", "খেতে পারি")]),
            make_item("jp-cas-p2-l5-003", "あした パーティーに 来られますか。", "あしたぱーてぃーにこられますか。", "Ashita paatii ni koraremasu ka.", "কাল পার্টিতে আসতে পারবেন কি?", "আশিতা পাতিই নি কোরোরেমাসু কা?", [("あした", "ashita", "明日", "আগামীকাল"), ("パーティーに", "paatii ni", "パーティーに", "পার্টিতে"), ("来られますか", "koraremasu ka", "来られますか", "আসতে পারবেন কি")])
        ]
    },
    {
        "id": "jp-cas-l06",
        "order": 2,
        "title_bn": "অক্ষমতা ও সীমাবদ্ধতা (Expressing Inability)",
        "title_target": "Expressing Inability (Hanasenai / Koto ga dekimasen)",
        "intro_bn": "কোনো কাজ করতে অক্ষম হলে পোটেনশিয়াল ভার্বকে না-বোধক করতে হয়: 話せない (বলতে পারি না), 泳げない (সাঁতার কাটতে পারি না)।",
        "structure": ["Noun + が + Potential Verb-ません / ない"],
        "items": [
            make_item("jp-cas-p2-l6-001", "わたしは 漢字が あまり 書けません。", "わたしわかんじがあまりかけません。", "Watashi wa kanji ga amari kakemasen.", "আমি খুব একটা কাঞ্জি লিখতে পারি না।", "ওয়াতাশি ওয়া কাঞ্জি গা আমারি কাকেমাসেন।", [("わたしは", "watashi wa", "私は", "আমি"), ("漢字が", "kanji ga", "漢字が", "কাঞ্জি"), ("あまり", "amari", "あまり", "তেমন একটা"), ("書けません", "kakemasen", "書けません", "লিখতে পারি না")], polarity="negative"),
            make_item("jp-cas-p2-l6-002", "泳ぐ ことが できません。", "およぐことができません。", "Oyogu koto ga dekimasen.", "সাঁতার কাটতে পারি না।", "ওয়োগু কোতো গা দেকিমাসেন।", [("泳ぐことが", "oyogu koto ga", "泳ぐことが", "সাঁতার কাটার সক্ষমতা"), ("できません", "dekimasen", "できません", "পারি না")], polarity="negative")
        ]
    },
    {
        "id": "jp-cas-l07",
        "order": 3,
        "title_bn": "পরিস্থিতিগত সুবিধা ও উপলভ্যতা (Circumstantial Possibility)",
        "title_target": "Circumstantial Possibility (Where one can do X)",
        "intro_bn": "কোনো নির্দিষ্ট স্থানে কোনো সেবা পাওয়া যায় বা সুবিধা ভোগ করা যায় বোঝাতে পোটেনশিয়াল রূপ বসে।",
        "structure": ["Place で + Noun が + Potential Verb"],
        "items": [
            make_item("jp-cas-p2-l7-001", "この カフェで 無料の Wi-Fiが 使えます。", "このかふぇでむりょうのわいふぁいがつかえます。", "Kono kafe de muryou no waifai ga tsukaemasu.", "এই ক্যাফেতে ফ্রি ওয়াইফাই ব্যবহার করা যায়।", "কোনো কাফে দে মুরিয়োও নো ওয়াইফাই গা তসুকায়েমাসু।", [("このカフェで", "kono kafe de", "このカフェで", "এই ক্যাফেতে"), ("無料のWi-Fiが", "muryou no waifai ga", "無料のWi-Fiが", "বিনামূল্যে ওয়াইফাই"), ("使えます", "tsukaemasu", "使えます", "ব্যবহার করা যায়")]),
            make_item("jp-cas-p2-l7-002", "駅の 前の コンビニで 切符が 買えます。", "えきのまえのこんびにできっぷがかえます。", "Eki no mae no konbini de kippu ga kaemasu.", "স্টেশনের সামনের কনভেনিয়েন্স স্টোরে টিকিট কেনা যায়।", "একি নো মায়ে নো কোনবিনি দে কিপ্পু গা কায়েমাশু।", [("駅の前の", "eki no mae no", "駅の前の", "স্টেশনের সামনের"), ("コンビニで", "konbini de", "コンビニで", "কনভেনিয়েন্স স্টোরে"), ("切符が", "kippu ga", "切符が", "টিকিট"), ("買えます", "kaemasu", "買えます", "কেনা যায়")])
        ]
    }
]
parts.append({
    "id": "jp-casual-p2",
    "order": 2,
    "level": "A2",
    "title_bn": "সামর্থ্য ও সম্ভাবনা (Potential Form: 可能動詞 & 〜ことができる)",
    "title_target": "Potential & Ability (Kanou Doushi / Koto ga dekiru)",
    "lessons": p2_lessons
})

# ==============================================================================
# PART 3: জাপানিজের ৪টি শর্তের নিয়ম (The 4 Japanese Conditionals: たら・なら・ば・と)
# ==============================================================================
p3_lessons = [
    {
        "id": "jp-cas-l08",
        "order": 1,
        "title_bn": "শর্ত ও সময় — '〜たら' (General Conditional: If / Once)",
        "title_target": "Conditionals with ~tara (If / Once)",
        "intro_bn": "দৈনন্দিন স্পোকেন জাপানিজে সবচেয়ে বেশি ব্যবহৃত শর্ত হলো '〜たら'। যদি কোনো ঘটনা ঘটে বা ঘটার পর কিছু করব বোঝাতে এটি বসে।",
        "structure": ["Verb-たら、Result Sentence"],
        "items": [
            make_item("jp-cas-p3-l8-001", "明日 雨が 降ったら、うちで 休みます。", "あしたあめがふったら、うちでやすみます。", "Ashita ame ga futtara, uchi de yasumimasu.", "আগামীকাল বৃষ্টি হলে বাড়িতে বিশ্রাম নেব।", "আশিতা আমে গা ফুত্তারা, উচি দে ইয়াসুমিমাসু।", [("明日", "ashita", "明日", "আগামীকাল"), ("雨が降ったら", "ame ga futtara", "雨が降ったら", "বৃষ্টি হলে"), ("うちで", "uchi de", "うちで", "বাড়িতে"), ("休みます", "yasumimasu", "休みます", "বিশ্রাম নেব")]),
            make_item("jp-cas-p3-l8-002", "駅に 着いたら、電話して ください。", "えきについたら、でんわしてください。", "Eki ni tsuitara, denwa shite kudasai.", "স্টেশনে পৌঁছালে ফোন করবেন দয়া করে।", "একি নি তসুইতারা, দেনওয়া শিতে কুদাসাই।", [("駅に着いたら", "eki ni tsuitara", "駅に着いたら", "স্টেশনে পৌঁছালে"), ("電話してください", "denwa shite kudasai", "電話してください", "ফোন করবেন দয়া করে")]),
            make_item("jp-cas-p3-l8-003", "お金が あったら、世界旅行に 行きたいです。", "おかねがあったら、せかいりょこうにいきたいです。", "Okane ga attara, sekai ryokou ni ikitai desu.", "টাকা থাকলে বিশ্বভ্রমণে যেতে চাই।", "ওকানে গা আত্তারা, সেকাই রিওকোও নি ইকিতাই দেস।", [("お金があったら", "okane ga attara", "お金があったら", "টাকা থাকলে"), ("世界旅行に", "sekai ryokou ni", "世界旅行に", "বিশ্বভ্রমণে"), ("行きたいです", "ikitai desu", "行きたいです", "যেতে চাই")])
        ]
    },
    {
        "id": "jp-cas-l09",
        "order": 2,
        "title_bn": "প্রসঙ্গ সাপেক্ষে পরামর্শ — '〜なら' (Contextual Conditional)",
        "title_target": "Contextual Conditionals (~nara: In that case...)",
        "intro_bn": "অন্যের কথার সূত্র ধরে কোনো বিষয়ে পরামর্শ বা মতামত দিতে 'Noun / Sentence + なら' বসে।",
        "structure": ["Topic / Idea + なら + Recommendation"],
        "items": [
            make_item("jp-cas-p3-l9-001", "日本へ 行くなら、京都が おすすめです。", "にほんえいくなら、きょうとがおすすめす。", "Nihon e iku nara, Kyouto ga osusume desu.", "জাপানে যদি যান, তবে কিয়োটো সবচেয়ে উত্তম প্রস্তাবনা।", "নিহোন এ ইকু নারা, কিওওতো গা ওসুসুমে দেস।", [("日本へ行くなら", "Nihon e iku nara", "日本へ行くなら", "জাপানে যদি যান"), ("京都が", "Kyouto ga", "京都が", "কিয়োটো"), ("おすすめです", "osusume desu", "おすすめです", "উত্তম প্রস্তাব")]),
            make_item("jp-cas-p3-l9-002", "パソコンなら、秋葉原の 店が 安いですよ。", "ぱそこんなら、あきはばらのみせやすいですよ。", "Pasokon nara, Akihabara no mise ga yasui desu yo.", "কম্পিউটারের ব্যাপার হলে আকিহাবারার দোকানগুলো সস্তা।", "পাসোকোন নারা, আকিহাবারা নো মিসে গা ইয়াসুই দেসু ইয়ো।", [("パソコンなら", "pasokon nara", "パソコンなら", "কম্পিউটারের কথা বললে"), ("秋葉原の店が", "Akihabara no mise ga", "秋葉原の店が", "আকিহাবারার দোকান"), ("安いです", "yasui desu", "安いです", "সস্তা")])
        ]
    },
    {
        "id": "jp-cas-l10",
        "order": 3,
        "title_bn": "যৌক্তিক শর্ত — '〜ば' (Hypothetical Conditional)",
        "title_target": "Hypothetical Conditional (~ba form)",
        "intro_bn": "যদি যৌক্তিক বা কাল্পনিক শর্ত পূরণ হয় তবে ফলাফল ঘটবে: ক্রিয়ার e-ধ্বনি + ば (安ければ = যদি সস্তা হয়; 行けば = যদি যাই)।",
        "structure": ["Verb (ba-form) / い-Adj (kereba)、Result"],
        "items": [
            make_item("jp-cas-p3-l10-001", "安ければ、たくさん 買います。", "やすければ、たくさんかいます。", "Yasukereba, takusan kaimasu.", "যদি সস্তা হয়, তবে অনেক কিনব।", "ইয়াসুকেরোবা, তাকুসান কাইমাসু।", [("安ければ", "yasukereba", "安ければ", "সস্তা হলে"), ("たくさん", "takusan", "たくさん", "অনেক"), ("買います", "kaimasu", "買います", "কিনব")]),
            make_item("jp-cas-p3-l10-002", "毎日 練習すれば、上手に なりますよ。", "まいにちれんしゅうすれば、じょうずになりますよ。", "Mainichi renshuu sureba, jouzu ni narimasu yo.", "প্রতিদিন অনুশীলন করলে পারদর্শী হয়ে উঠবেন।", "মাইনিচি রেনশুউ সুরেবা, জোওজু নি নারিমাসু ইয়ো।", [("毎日", "mainichi", "毎日", "প্রতিদিন"), ("練習すれば", "renshuu sureba", "練習すれば", "অনুশীলন করলে"), ("上手に", "jouzu ni", "上手に", "দক্ষ/পারদর্শী"), ("なります", "narimasu", "なります", "হয়ে উঠবেন")])
        ]
    },
    {
        "id": "jp-cas-l11",
        "order": 4,
        "title_bn": "অনিবার্য প্রাকৃতিক ফলাফল — '〜と' (Natural Inevitability)",
        "title_target": "Natural & Inevitable Consequence (~to)",
        "intro_bn": "কোনো কাজ করলে প্রাকৃতিকভাবে বা স্বয়ংক্রিয়ভাবে নিশ্চিত ফল ঘটে (যেমন: এই বোতাম চাপলে দরজা খোলে, বসন্ত এলে ফুল ফোটে)।",
        "structure": ["Verb (Dic) + と、Natural Result"],
        "items": [
            make_item("jp-cas-p3-l11-001", "この ボタンを 押すと、おつりが 出ます。", "このぼたんをおすと、おつりがでます。", "Kono botan o osu to, otsuri ga demasu.", "এই বোতামটি চাপলেই অবশিষ্ট ভাঙতি টাকা বের হবে।", "কোনো বোতান ও ওসু তো, ওতসুরি গা দেমাসু।", [("このボタンを", "kono botan o", "このボタンを", "এই বোতামটি"), ("押すと", "osu to", "押すと", "চাপলেই"), ("おつりが", "otsuri ga", "おつりが", "ভাঙতি টাকা"), ("出ます", "demasu", "出ます", "বের হয়")]),
            make_item("jp-cas-p3-l11-002", "春に なると、桜が 咲きます。", "はるになると、さくらがさきます。", "Haru ni naru to, sakura ga sakimasu.", "বসন্ত এলেই চেরি ফুল ফোটে।", "হারু নি নারু তো, সাকুরা গা সাকিমাসু।", [("春になると", "haru ni naru to", "春になると", "বসন্ত এলেই"), ("桜が", "sakura ga", "桜が", "চেরি ফুল"), ("咲きます", "sakimasu", "咲きます", "ফোটে")])
        ]
    }
]
parts.append({
    "id": "jp-casual-p3",
    "order": 3,
    "level": "A2",
    "title_bn": "জাপানিজের ৪টি শর্তের নিয়ম (The 4 Japanese Conditionals: たら・なら・ば・と)",
    "title_target": "The 4 Conditionals (~tara, ~nara, ~ba, ~to)",
    "lessons": p3_lessons
})

# ==============================================================================
# PART 4: ইচ্ছা, সিদ্ধান্ত ও ভবিষ্যৎ পরিকল্পনা (Intentions, Decisions & Future Plans)
# ==============================================================================
p4_lessons = [
    {
        "id": "jp-cas-l12",
        "order": 1,
        "title_bn": "প্রস্তাব ও ইচ্ছা — '意向形' (Volitional Form: 行こう / 食べよう)",
        "title_target": "Volitional Form (Let's do...)",
        "intro_bn": "বন্ধুমহলে 'চলুন এটা করি' বলতে 〜ましょう এর ইনফরমাল রূপ হলো ভলিশনাল ফর্ম (Volitional Form)। যেমন: 行こう (চল যাই), 食べよう (চল খাই)।",
        "structure": ["Group 1: o-sound + う (行こう), Group 2: よう (食べよう), する → しよう"],
        "items": [
            make_item("jp-cas-p4-l12-001", "いっしょに コーヒーを 飲もう。", "いっしょにこーひーをのもう。", "Issho ni koohii o nomou.", "একসাথে কফি খাই চল।", "ইশশো নি কোওহিই ও নোমোও।", [("いっしょに", "issho ni", "一緒に", "একসাথে"), ("コーヒーを", "koohii o", "コーヒーを", "কফি"), ("飲もう", "nomou", "飲もう", "পান করি চল")]),
            make_item("jp-cas-p4-l12-002", "週末 海へ 行こうと 思っています。", "しゅうまつうみえいこうとおもっています。", "Shuumatsu umi e ikou to omotte imasu.", "সাপ্তাহিক ছুটিতে সমুদ্রে যাব বলে ভাবছি।", "শুউমাতসু উমি এ ইকোও তো ওমোত্তে ইমাসু।", [("週末", "shuumatsu", "週末", "সাপ্তাহিক ছুটি"), ("海へ行こうと", "umi e ikou to", "海へ行こうと", "সমুদ্রে যাব বলে"), ("思っています", "omotte imasu", "思っています", "ভাবছি")])
        ]
    },
    {
        "id": "jp-cas-l13",
        "order": 2,
        "title_bn": "দৃঢ় ইচ্ছা ও পরিকল্পনা — '〜つもりです' (Intention: Plan to)",
        "title_target": "Strong Personal Intention (~tsumori desu)",
        "intro_bn": "কোনো কাজ করার ব্যক্তিগত দৃঢ় ইচ্ছা থাকলে 'Verb-辞書形 + つもりです' এবং না করার ইচ্ছা থাকলে 'Verb-ない + つもりです' বসে।",
        "structure": ["Verb (Dic / Nai) + つもりです (করার ইচ্ছে আছে / নেই)"],
        "items": [
            make_item("jp-cas-p4-l13-001", "来年 日本へ 留学する つもりです。", "らいねんにほんえりゅうがくするつもりです。", "Rainen Nihon e ryuugaku suru tsumori desu.", "আগামী বছর জাপানে উচ্চশিক্ষায় যাওয়ার ইচ্ছে আছে।", "রাইনেন নিহোন এ রিউউগাকু সুরু তসুমোরি দেস।", [("来年", "rainen", "来年", "আগামী বছর"), ("日本へ", "Nihon e", "日本へ", "জাপানে"), ("留学する", "ryuugaku suru", "留学する", "উচ্চশিক্ষায় পড়াশোনা"), ("つもりです", "tsumori desu", "つもりです", "ইচ্ছা আছে")]),
            make_item("jp-cas-p4-l13-002", "今日は お酒を 飲まない つもりです。", "きょうわおさけをのまないつもりです。", "Kyou wa osake o nomanai tsumori desu.", "আজ মদ না খাওয়ার সংকল্প করেছি।", "কিওও ওয়া ওসাকে ও নোমানাই তসুমোরি দেস।", [("今日は", "kyou wa", "今日は", "আজ"), ("お酒を", "osake o", "お酒を", "মদ"), ("飲まないつもりです", "nomanai tsumori desu", "飲まないつもりです", "না খাওয়ার ইচ্ছে")], polarity="negative")
        ]
    },
    {
        "id": "jp-cas-l14",
        "order": 3,
        "title_bn": "নির্ধারিত সূচি ও সময়সূচি — '〜予定です' (Scheduled Plan)",
        "title_target": "Scheduled Events & Itineraries (~yotei desu)",
        "intro_bn": "নিজের একক সিদ্ধান্তের চেয়ে আনুষ্ঠানিক সময়সূচি বা প্রাতিষ্ঠানিক সূচি বোঝাতে '〜予定です' ব্যবহৃত হয়।",
        "structure": ["Verb (Dic) / Noun の + 予定です"],
        "items": [
            make_item("jp-cas-p4-l14-001", "会議は 午後３時に 始まる 予定です。", "かいぎわごごさんじにはじまるよていです。", "Kaigi wa gogo sanji ni hajimaru yotei desu.", "মিটিং বিকেল ৩টায় শুরু হওয়ার কথা রয়েছে।", "কাইগি ওয়া গোগো সানজি নি হাজিমারু ইয়োতেই দেস।", [("会議は", "kaigi wa", "会議は", "সভা/মিটিং"), ("午後３時に", "gogo sanji ni", "午後３時に", "বিকেল ৩টায়"), ("始まる予定です", "hajimaru yotei desu", "始まる予定です", "শুরু হওয়ার সূচি আছে")]),
            make_item("jp-cas-p4-l14-002", "来週 出張の 予定です。", "らいしゅうしゅっちょうのよていです。", "Raishuu shutchou no yotei desu.", "আগামী সপ্তাহে ব্যবসায়িক সফরের সূচি রয়েছে।", "রাইশুউ শুচ্চোও নো ইয়োতেই দেস।", [("来週", "raishuu", "来週", "আগামী সপ্তাহ"), ("出張の", "shutchou no", "出張の", "অফিসিয়াল ট্যুর"), ("予定です", "yotei desu", "予定です", "পরিকল্পনা আছে")])
        ]
    },
    {
        "id": "jp-cas-l15",
        "order": 4,
        "title_bn": "সিদ্ধান্ত গ্রহণ — '〜ことにする' ও '〜ことになる' (Making Decisions)",
        "title_target": "Decisions (~koto ni suru / ~koto ni naru)",
        "intro_bn": "নিজে সচেতন সিদ্ধান্ত নিলে '〜ことにしました' এবং কর্তৃপক্ষ বা পরিস্থিতির নিয়মে সিদ্ধান্ত হলে '〜ことになりました' বসে।",
        "structure": [
            "Verb (Dic) + ことにしました (নিজে সিদ্ধান্ত নিলাম)",
            "Verb (Dic) + ことになりました (নিয়ম বা পরিস্থিতির কারণে সিদ্ধান্ত হলো)"
        ],
        "items": [
            make_item("jp-cas-p4-l15-001", "健康の ために、毎日 運動する ことに しました。", "けんこうのために、まいにちうんどうすることにしました。", "Kenkou no tame ni, mainichi undou suru koto ni shimashita.", "স্বাস্থ্যের জন্য প্রতিদিন ব্যায়াম করার সিদ্ধান্ত নিয়েছি।", "কেনকোও নো তামে নি, মাইনিচি উনদোও সুরু কোতো নি শিমাশিতা।", [("健康のために", "kenkou no tame ni", "健康のために", "স্বাস্থ্যের জন্য"), ("毎日", "mainichi", "毎日", "প্রতিদিন"), ("運動することにしました", "undou suru koto ni shimashita", "運動することにしました", "ব্যায়াম করার সিদ্ধান্ত নিয়েছি")]),
            make_item("jp-cas-p4-l15-002", "来月から 大阪へ 転勤する ことに なりました。", "らいげつからおおさかえてんきんすることになりました。", "Raigetsu kara Oosaka e tenkin suru koto ni narimashita.", "আগামী মাস থেকে ওসাকায় বদলি হওয়ার সিদ্ধান্ত হয়েছে (অফিসের নিয়মে)।", "রাইগেতসু কারা ওওসাকা এ তেনকিন সুরু কোতো নি নারিমাশিতা।", [("来月から", "raigetsu kara", "来月から", "আগামী মাস থেকে"), ("大阪へ", "Oosaka e", "大阪へ", "ওসাকায়"), ("転勤することになりました", "tenkin suru koto ni narimashita", "転勤することになりました", "বদলি হওয়ার সিদ্ধান্ত হয়েছে")])
        ]
    }
]
parts.append({
    "id": "jp-casual-p4",
    "order": 4,
    "level": "A2",
    "title_bn": "ইচ্ছা, সিদ্ধান্ত ও ভবিষ্যৎ পরিকল্পনা (Intentions, Decisions & Future Plans)",
    "title_target": "Intentions & Decisions (~tsumori, ~yotei, ~koto ni suru)",
    "lessons": p4_lessons
})

# ==============================================================================
# PART 5: মতামত, উদ্ধৃতি ও উপদেশ (Opinions, Quotes & Advice: 〜と思う・〜と言う)
# ==============================================================================
p5_lessons = [
    {
        "id": "jp-cas-l16",
        "order": 1,
        "title_bn": "নিজের মতামত প্রকাশ — '〜と 思います' (I think that...)",
        "title_target": "Expressing Thoughts & Opinions (~to omoimasu)",
        "intro_bn": "নিজের অভিমত বা অনুমান প্রকাশ করতে প্লেইন ফর্ম বাক্যের শেষে '〜と 思います' (I think that...) বসে।",
        "structure": ["Plain Form Sentence + と 思います"],
        "items": [
            make_item("jp-cas-p5-l16-001", "明日は 雨が 降ると 思います。", "あしたわあめがふるとおもいます。", "Ashita wa ame ga furu to omoimasu.", "আমার মনে হয় কাল বৃষ্টি হবে।", "আশিতা ওয়া আমে গা ফুরু তো ওমোইমাসু।", [("明日は", "ashita wa", "明日は", "আগামীকাল"), ("雨が降ると", "ame ga furu to", "雨が降ると", "বৃষ্টি হবে বলে"), ("思います", "omoimasu", "思います", "মনে করি")]),
            make_item("jp-cas-p5-l16-002", "日本の 物価は 高いと 思います。", "にほんのぶっかわたかいとおもいます。", "Nihon no bukka wa takai to omoimasu.", "আমার মনে হয় জাপানের জিনিসপত্রের দাম অনেক বেশি।", "নিহোন নো বুক্কা ওয়া তাকাই তো ওমোইমাসু।", [("日本の物価は", "Nihon no bukka wa", "日本の物価は", "জাপানের দ্রব্যমূল্য"), ("高いと", "takai to", "高いと", "বেশি বলে"), ("思います", "omoimasu", "思います", "মনে করি")]),
            make_item("jp-cas-p5-l16-003", "田中さんは 明日 来ないと 思います。", "たなかさんわあしたこないとおもいます。", "Tanaka-san wa ashita konai to omoimasu.", "আমার ধারণা তানাকা বাবু কাল আসবেন না।", "তানাকা-সান ওয়া আশিতা কোনাই তো ওমোইমাসু।", [("田中さんは", "Tanaka-san wa", "田中さんは", "তানাকা বাবু"), ("明日", "ashita", "明日", "কাল"), ("来ないと", "konai to", "来ないと", "আসবেন না বলে"), ("思います", "omoimasu", "思います", "মনে হয়")], polarity="negative")
        ]
    },
    {
        "id": "jp-cas-l17",
        "order": 2,
        "title_bn": "উদ্ধৃতি ও বক্তব্য প্রকাশ — '〜と 言いました' (Direct & Indirect Quotations)",
        "title_target": "Quotation & Hearsay (~to iimashita)",
        "intro_bn": "অন্য কারো কথা সরাসরি বা পরোক্ষভাবে উল্লেখ করতে উদ্ধৃতির পর '〜と 言いました' (বলেছিলেন) বসে।",
        "structure": ["Quote (Plain / Polite) + と 言いました"],
        "items": [
            make_item("jp-cas-p5-l17-001", "先生は「宿題を して ください」と 言いました。", "せんせいわ「しゅくだいをしてください」といいました。", "Sensei wa \"shukudai o shite kudasai\" to iimashita.", "শিক্ষক বলেছিলেন, \"হোমওয়ার্ক করুন দয়া করে।\"", "সেনসেই ওয়া শুকুদাই ও শিতে কুদাসাই তো ইইমাশিতা।", [("先生は", "sensei wa", "先生は", "শিক্ষক"), ("宿題をしてくだいと", "shukudai o shite kudasai to", "宿題をしてくださいと", "হোমওয়ার্ক করুন বলে"), ("言いました", "iimashita", "言いました", "বলেছিলেন")]),
            make_item("jp-cas-p5-l17-002", "彼は あした 来られないと 言っていました。", "かれわあしたこられないといっていました。", "Kare wa ashita korarenai to itte imashita.", "সে বলছিল যে কাল নাকি আসতে পারবে না।", "কারে ওয়া আশিতা কোরোরেলাই তো ইত্তে ইমাশিতা।", [("彼は", "kare wa", "彼は", "সে"), ("あした来られないと", "ashita korarenai to", "明日来られないと", "কাল আসতে পারবে না বলে"), ("言っていました", "itte imashita", "言っていました", "বলছিল")])
        ]
    },
    {
        "id": "jp-cas-l18",
        "order": 3,
        "title_bn": "উপদেশ ও পরামর্শ — '〜た ほうが いいです' (Giving Advice)",
        "title_target": "Giving Advice (~ta hou ga ii desu)",
        "intro_bn": "কাউকে কোনো কিছু করার পরামর্শ দিতে 'Verb-た ほうが いいです' (করাই ভালো) এবং না করার পরামর্শে 'Verb-ない ほうが いいです' বসে।",
        "structure": ["Verb-た ほうが いいです (করাই ভালো)", "Verb-ない ほうが いいです (না করাই ভালো)"],
        "items": [
            make_item("jp-cas-p5-l18-001", "早く 病院へ 行った ほうが いいですよ。", "はやくびょういんえいったほうがいいですよ。", "Hayaku byouin e itta hou ga ii desu yo.", "তাড়াতাড়ি হাসপাতালে যাওয়াই ভালো হবে কিন্তু।", "হায়াকু বিয়োওইন এ ইত্তা হোও গা ইই দেসু ইয়ো।", [("早く", "hayaku", "早く", "তাড়াতাড়ি"), ("病院へ行ったほうが", "byouin e itta hou ga", "病院へ行ったほうが", "হাসপাতালে যাওয়াই"), ("いいですよ", "ii desu yo", "いいですよ", "ভালো হবে কিন্তু")]),
            make_item("jp-cas-p5-l18-002", "あまり 無理を しない ほうが いいです。", "あまりむりをしないほうがいいです。", "Amari muri o shinai hou ga ii desu.", "অতিরিক্ত চাপ না নেওয়াই ভালো।", "আমারি মুরি ও শিনাই হোও গা ইই দেস।", [("あまり", "amari", "あまり", "বেশি"), ("無理をしないほうが", "muri o shinai hou ga", "無理をしないほうが", "অতিরিক্ত চাপ না নেওয়াই"), ("いいです", "ii desu", "いいです", "উত্তম")], polarity="negative")
        ]
    }
]
parts.append({
    "id": "jp-casual-p5",
    "order": 5,
    "level": "A2",
    "title_bn": "মতামত, উদ্ধৃতি ও উপদেশ (Opinions, Quotes & Advice: 〜と思う・〜と言う)",
    "title_target": "Opinions, Quotes & Advice (~to omoimasu, ~to iimashita, ~hou ga ii)",
    "lessons": p5_lessons
})

# ==============================================================================
# PART 6: কর্মবাচ্য, প্রযোজক ক্রিয়া ও কথ্য সংলাপ (Passive, Causative & Dialogues)
# ==============================================================================
p6_lessons = [
    {
        "id": "jp-cas-l19",
        "order": 1,
        "title_bn": "কর্মবাচ্য রূপ — '受身形' (Passive Voice: ~rareru)",
        "title_target": "Passive Voice (Ukemikei)",
        "intro_bn": "অন্য কারো কাজের শিকার হলে প্যাসিভ ভয়েস বসে (যেমন: শিক্ষক আমাকে প্রশংসা করেছিলেন, বৃষ্টিতে ভিজেছিলাম)।",
        "structure": ["Victim は + Agent に + Passive Verb-ました"],
        "items": [
            make_item("jp-cas-p6-l19-001", "わたしは 先生に 褒められました。", "わたしわせんせいにほめられました。", "Watashi wa sensei ni homeraremashita.", "আমি শিক্ষকের দ্বারা প্রশংসিত হয়েছিলাম।", "ওয়াতাশি ওয়া সেনসেই নি হোমেরারেমাশিতা।", [("わたしは", "watashi wa", "私は", "আমি"), ("先生に", "sensei ni", "先生に", "শিক্ষকের নিকট"), ("褒められました", "homeraremashita", "褒められました", "প্রশংসিত হয়েছি")]),
            make_item("jp-cas-p6-l19-002", "電車の中で 足を 踏まれました。", "でんしゃのなかであしをふまれました。", "Densha no naka de ashi o fumaremashita.", "ট্রেনের ভেতর কেউ আমার পায়ে পাড়া দিয়েছিল।", "দেনশা নো নাকা দে আশি ও ফুমারেমাশিতা।", [("電車の中で", "densha no naka de", "電車の中で", "ট্রেনের মধ্যে"), ("足を", "ashi o", "足を", "পায়ে"), ("踏まれました", "fumaremashita", "踏まれました", "পাড়া খেয়েছি")]),
            make_item("jp-cas-p6-l19-003", "雨に 降られて、濡れて しまいました。", "あめにふられて、ぬれてしまいました。", "Ame ni furarete, nurete shimaimashita.", "বৃষ্টিতে ভিজে একাকার হয়ে গিয়েছি।", "আমে নি ফুরারেতে, নুরেতে শিমাইমাশিতা।", [("雨に降られて", "ame ni furarete", "雨に降られて", "বৃষ্টিতে ভিজে"), ("濡れてしまいました", "nurete shimaimashita", "濡れてしまいました", "ভিজে শেষ হয়েছি")])
        ]
    },
    {
        "id": "jp-cas-l20",
        "order": 2,
        "title_bn": "অনুমতি চাওয়া প্রযোজক রূপে — '〜させて ください' (Causative Requests)",
        "title_target": "Causative Requests (~sasete kudasai)",
        "intro_bn": "আমাকে কোনো কাজ করার অনুমতি দিন বা আমাকে করতে দিন বোঝাতে কজেটিভ রূপের সাথে 'させて ください' বসে।",
        "structure": ["Verb (Causative-te) + ください (Let me please do...)"],
        "items": [
            make_item("jp-cas-p6-l20-001", "今日は 早く 帰らせて ください。", "きょうわはやくかえらせてください。", "Kyou wa hayaku kaerasete kudasai.", "আজ আমাকে একটু তাড়াতাড়ি বাড়ি ফিরতে দিন।", "কিওও ওয়া হায়াকু কায়েরাসেতে কুদাসাই।", [("今日は", "kyou wa", "今日は", "আজ"), ("早く", "hayaku", "早く", "তাড়াতাড়ি"), ("帰らせてください", "kaerasete kudasai", "帰らせてください", "ফিরতে দিন")]),
            make_item("jp-cas-p6-l20-002", "わたしに その 仕事を やらせて ください。", "わたしにそのしごとをやらせてください。", "Watashi ni sono shigoto o yarasete kudasai.", "আমাকে ওই কাজটি করতে দিন।", "ওয়াতাশি নি সোনো শিগাতো ও ইয়ারাচেতে কুদাসাই।", [("わたしに", "watashi ni", "私に", "আমাকে"), ("その仕事を", "sono shigoto o", "その仕事を", "ওই কাজটি"), ("やらせてください", "yarasete kudasai", "やらせてください", "করতে দিন")])
        ]
    },
    {
        "id": "jp-cas-l21",
        "order": 3,
        "title_bn": "বন্ধুমহলে সপ্তাহান্তের পরিকল্পনা সংলাপ (Weekend Casual Dialogue)",
        "title_target": "Casual Weekend Chat (Interactive Dialogue)",
        "intro_bn": "বন্ধুদের মধ্যে অনানুষ্ঠানিক কথোপকথনের বাস্তব নমুনা।",
        "structure": ["Casual Peer Dialogue between Friends"],
        "items": [
            make_item("jp-cas-p6-l21-001", "Ａ：今週末 何か 予定 ある？ Ｂ：ううん、特に ないよ。どうして？", "こんしゅうまつなにかよていある？ううん、とくにないよ。どうして？", "A: Konshuumatsu nanika yotei aru? B: Uun, tokuni nai yo. Doushite?", "A: এই সাপ্তাহিক ছুটিতে কোনো পরিকল্পনা আছে কি তোর? B: না রে, তেমন কিছু নেই। কেন বল তো?", "এ: কোনশুউমাতসু নানিকা ইয়োতেই আরু? বি: উউউন, তোকুনি নাই ইয়ো। দোওশিতে?", item_type="dialogue"),
            make_item("jp-cas-p6-l21-002", "Ａ：新しい ラーメン屋 行かない？ Ｂ：いいね！ぜひ 行こう！", "あたらしいらーめんやいかない？いいね！ぜひいこう！", "A: Atarashii raamen-ya ikanai? B: Ii ne! Zehi ikou!", "A: নতুন রামেন দোকানে যাবি নাকি? B: দারুণ তো! চল অবশ্যই যাব!", "এ: আতারাসিই রাআমেন-ইয়া ইকনাই? বি: ইই নে! জেহি ইকোও!", item_type="dialogue")
        ]
    },
    {
        "id": "jp-cas-l22",
        "order": 4,
        "title_bn": "স্পোকেন ফ্লুয়েন্সি ৬-রূপান্তর মাস্টার ড্রিল (Casual Fluency 6 Transformations)",
        "title_target": "Master 6-Way Oral Transformation: Potential & Fluency",
        "intro_bn": "সামর্থ্য ও ইনফরমাল কথোপকথনের দ্রুত ৬-রূপান্তর ড্রিল।",
        "structure": [
            "১. হ্যাঁ-বোধক (+): 日本語が 話せる。",
            "২. না-বোধক (-): 日本語が 話せない。",
            "৩. প্রশ্নবোধক (?): 日本語が 話せる？",
            "৪. না-বোধক প্রশ্ন (-?): 日本語が 話せないの？",
            "৫. WH-প্রশ্ন (WH?): どのくらい 日本語が 話せる？",
            "৬. বিকল্প প্রশ্ন (Alt?): 日本語が 話せる？ 英語が 話せる？"
        ],
        "items": [
            make_item("jp-cas-p6-l22-001", "日本語が 話せる。", "にほんごがはなせる。", "Nihongo ga hanaseru.", "১. হ্যাঁ-বোধক: জাপানি ভাষা বলতে পারি।", "নিহঙ্গো গা হানাসেরু।", item_type="drill"),
            make_item("jp-cas-p6-l22-002", "日本語が 話せない。", "にほんごがはなせない。", "Nihongo ga hanasenai.", "২. না-বোধক: জাপানি ভাষা বলতে পারি না।", "নিহঙ্গো গা হানাসেনাই।", item_type="drill", polarity="negative"),
            make_item("jp-cas-p6-l22-003", "日本語が 話せる？", "にほんごがはなせる？", "Nihongo ga hanaseru?", "৩. প্রশ্নবোধক: জাপানি ভাষা বলতে পারিস?", "নিহঙ্গো গা হানাসেরু?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-cas-p6-l22-004", "日本語が 話せないの？", "にほんごがはなせないの？", "Nihongo ga hanasenai no?", "৪. না-বোধক প্রশ্ন: জাপানি ভাষা বলতে পারিস না?", "নিহঙ্গো গা হানাসেনাই নো?", item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-cas-p6-l22-005", "どのくらい 日本語が 話せる？ 少し 話せるよ。", "どのくらいにほんごがはなせる？すこしはなせるよ。", "Dono kurai nihongo ga hanaseru? Sukoshi hanaseru yo.", "৫. WH-প্রশ্ন: কতটা জাপানি বলতে পারিস? একটু পারি।", "দোনো কুরাই নিহঙ্গো গা হানাসেরু? সুকোশি হানাসেরু ইয়ো।", item_type="drill", sentence_type="wh_question"),
            make_item("jp-cas-p6-l22-006", "日本語が 話せる？ 英語が 話せる？", "にほんごがはなせる？えいごがはなせる？", "Nihongo ga hanaseru? Eigo ga hanaseru?", "৬. বিকল্প প্রশ্ন: জাপানি বলতে পারিস, নাকি ইংরেজি?", "নিহঙ্গো গা হানাসেরু? এইগো গা হানাসেরু?", item_type="drill", sentence_type="alternative_question")
        ]
    }
]
parts.append({
    "id": "jp-casual-p6",
    "order": 6,
    "level": "A2",
    "title_bn": "কর্মবাচ্য, প্রযোজক ক্রিয়া ও কথ্য সংলাপ (Passive, Causative & Dialogues)",
    "title_target": "Passive, Causative Requests & Master 6-Way Fluency Drill",
    "lessons": p6_lessons
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

print(f"Course 3 successfully built and saved to: {DEST_FILE}")
print(f"Total Parts: {len(parts)}")
print(f"Total Lessons: {total_lessons}")
print(f"Total Items: {total_items}")
