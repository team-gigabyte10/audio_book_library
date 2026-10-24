# -*- coding: utf-8 -*-
"""
Generator script for Course 1: Japanese Spoken Foundations (JLPT N5)
Generates: android/app/src/main/assets/spoken_japanese_foundations.json
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
    "title_bn": "জাপানিজ স্পোকেন: Foundations (JLPT N5 বেসিক টু স্পিকিং)",
    "title_target": "Spoken Japanese: Foundations Masterclass",
    "source": "Curated from N5-N1 Japanese Study Series & Spoken English Framework",
    "note": "জাপানিজ বর্ণমালা ও উচ্চারণ, です/ではありません, দৈনন্দিন কাজ, অবস্থান, বিশেষণ, প্রশ্ন-উত্তর ও ৬-রূপান্তর ড্রিল।",
    "welcome_text": "জাপানিজ স্পোকেন মাস্টারক্লাসে আপনাকে স্বাগতম! প্রতিটি বাক্য মন দিয়ে শুনুন এবং জোরে জোরে বলে শ্যাডোয়িং অনুশীলন করুন।"
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
        # Default simple tokenization
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
# PART 1: বর্ণমালা, উচ্চারণ ও ফ্লুয়েন্সি ড্রিল (Pronunciation, Pitch & Kana)
# ==============================================================================
p1_lessons = [
    {
        "id": "jp-foundations-l01",
        "order": 1,
        "title_bn": "জাপানিজ স্বরবর্ণ ও মৌলিক উচ্চারণ (Vowels あ い う え お)",
        "title_target": "Japanese Vowels & Mora Timing (A, I, U, E, O)",
        "intro_bn": "জাপানিজ ভাষায় ৫টি মূল স্বরবর্ণ রয়েছে: あ (a - আ), い (i - ই), う (u - উ), え (e - এ), お (o - ও)। জাপানিজে প্রতি অক্ষরের উচ্চারণ সমান সময়কাল (Mora) ধরে করতে হয়।",
        "structure": ["Vowel Base Sounds: A - I - U - E - O (আ - ই - উ - এ - ও)"],
        "items": [
            make_item("jp-p1-l1-001", "あさ、あめが ふります。", "あさ、あめがふります。", "Asa, ame ga furimasu.", "সকালে বৃষ্টি হয়।", "আসা, আমে গা ফুরিমাসু।", [("あさ", "asa", "朝", "সকাল"), ("あめ", "ame", "雨", "বৃষ্টি"), ("が", "ga", "が", "টি"), ("ふります", "furimasu", "降ります", "পড়ে/হয়")]),
            make_item("jp-p1-l1-002", "いえで いぬを みます。", "いえでいぬをみます。", "Ie de inu o mimasu.", "বাড়িতে কুকুর দেখি।", "ইয়ে দে ইনু ও মিমাসু।", [("いえ", "ie", "家", "বাড়ি"), ("で", "de", "で", "এ"), ("いぬ", "inu", "犬", "কুকুর"), ("を", "o", "を", "কে"), ("みます", "mimasu", "見ます", "দেখি")]),
            make_item("jp-p1-l1-003", "うみで うたを うたいます。", "うみでうたをうたいます。", "Umi de uta o utaimasu.", "সমুদ্রে গান গাই।", "উমি দে উতা ও উতাইমাসু।", [("うみ", "umi", "海", "সমুদ্র"), ("で", "de", "で", "এ"), ("うた", "uta", "歌", "গান"), ("を", "o", "を", "কে"), ("うたいます", "utaimasu", "歌います", "গাই")]),
            make_item("jp-p1-l1-004", "えきの まえで えを かきます。", "えきのまえでえをかきます。", "Eki no mae de e o kakimasu.", "স্টেশনের সামনে ছবি আঁকি।", "একি নো মায়ে দে এ ও কাকিমাসু।", [("えき", "eki", "駅", "স্টেশন"), ("の", "no", "の", "এর"), ("まえ", "mae", "前", "সামনে"), ("で", "de", "で", "এ"), ("え", "e", "絵", "ছবি"), ("を", "o", "を", "কে"), ("かきます", "kakimasu", "描きます", "আঁকি")]),
            make_item("jp-p1-l1-005", "おんがくを おおきい おとで ききます。", "おんがくをおおきいおとでききます。", "Ongaku o ookii oto de kikimasu.", "গান বড় শব্দে শুনি।", "ওনগাকু ও ওওকিই ওতো দে কিকিমাসু।", [("おんがく", "ongaku", "音楽", "সংগীত"), ("を", "o", "を", "কে"), ("おおきい", "ookii", "大きい", "বড়"), ("おと", "oto", "音", "শব্দ"), ("で", "de", "で", "দিয়ে"), ("ききます", "kikimasu", "聞きます", "শুনি")])
        ]
    },
    {
        "id": "jp-foundations-l02",
        "order": 2,
        "title_bn": "দীর্ঘ স্বর ও দ্বিত্ব ব্যঞ্জনধ্বনি (Long Vowels & Sokuon っ)",
        "title_target": "Long Vowels (Chouon) & Double Consonants (Sokuon)",
        "intro_bn": "দীর্ঘ স্বর (Chouon) উচ্চারণে দ্বিগুণ সময় দিতে হয় (যেমন: おばあさん - নানি বনাম おばさん - খালা)। দ্বিত্ব ব্যঞ্জন (っ small tsu) আসলে এক মোরা থামতে হয় (যেমন: きって kitte - ডাকটিকিট)।",
        "structure": ["Long Vowel (2 Moras) & Double Consonant Pause (っ)"],
        "items": [
            make_item("jp-p1-l2-001", "おとうさんは おかあさんと はなします。", "おとうさんはおかあさんとはなします。", "Otousan wa okaasan to hanashimasu.", "বাবা মায়ের সাথে কথা বলেন। (দীর্ঘ স্বর: おとう / おかあ)", "ওতোওসান ওয়া ওকাআসান তো হানাশিমাসু।", [("おとうさん", "otousan", "お父さん", "বাবা"), ("は", "wa", "は", "হল"), ("おかあさん", "okaasan", "お母さん", "মা"), ("と", "to", "と", "সাথে"), ("はなします", "hanashimasu", "話します", "কথা বলেন")]),
            make_item("jp-p1-l2-002", "きょう、きってを かいました。", "きょう、きってをかいました。", "Kyou, kitte o kaimashita.", "আজ ডাকটিকিট কিনেছি। (দ্বিত্ব ব্যঞ্জন: きって)", "কিয়োও, কিত্তে ও কাইমাশিতা।", [("きょう", "kyou", "今日", "আজ"), ("きって", "kitte", "切手", "ডাকটিকিট"), ("を", "o", "を", "কে"), ("かいました", "kaimashita", "買いました", "কিনেছি")]),
            make_item("jp-p1-l2-003", "ちょっと まって ください。", "ちょっとまってください。", "Chotto matte kudasai.", "একটু অপেক্ষা করুন। (দ্বিত্ব ব্যঞ্জন: ちょっと / まって)", "চোত্তো মাত্তে কুদাসাই।", [("ちょっと", "chotto", "一寸", "একটু"), ("まって", "matte", "待って", "অপেক্ষা করে"), ("ください", "kudasai", "下さい", "দয়া করে")]),
            make_item("jp-p1-l2-004", "がっこうへ いって、ざっしを よみます。", "がっこうへいって、ざっしをよみます。", "Gakkou e itte, zasshi o yomimasu.", "স্কুলে গিয়ে ম্যাগাজিন পড়ি।", "গাক্কোও এ ইত্তে, জাস্শি ও ইয়োমিমাসু।", [("がっこう", "gakkou", "学校", "স্কুল"), ("へ", "e", "へ", "দিকে"), ("いって", "itte", "行って", "গিয়ে"), ("ざっし", "zasshi", "雑誌", "ম্যাগাজিন"), ("を", "o", "を", "কে"), ("よみます", "yomimasu", "読みます", "পড়ি")])
        ]
    },
    {
        "id": "jp-foundations-l03",
        "order": 3,
        "title_bn": "যুক্তাক্ষর ও পরিবর্তিত ধ্বনি (Youon & Dakuten が, ざ, だ, ば, ぱ)",
        "title_target": "Contracted Sounds (Youon) & Voiced Sounds (Dakuten)",
        "intro_bn": "ই-লাইনের অক্ষরের সাথে ছোট ゃ, ゅ, ょ যুক্ত হয়ে যুক্তাক্ষর তৈরি করে (যেমন: きゃ, しゅ, ちょ)। আর দুটি ফোঁটা (゛ Dakuten) বা গোল চিহ্ন (゜ Handakuten) যুক্ত হয়ে ঘোষ ধ্বনি তৈরি করে।",
        "structure": ["Consonant + ya/yu/yo (き + ゃ = kya)", "Tenten (゛) / Maru (゜)"],
        "items": [
            make_item("jp-p1-l3-001", "きょうしつで べんきょうします。", "きょうしつでべんきょうします。", "Kyoushitsu de benkyou shimasu.", "ক্লাসরুমে পড়াশোনা করি।", "কিয়োওশিতসু দে বেনকিওও শিমাসু।", [("きょうしつ", "kyoushitsu", "教室", "ক্লাসরুম"), ("で", "de", "で", "এ"), ("べんきょうします", "benkyou shimasu", "勉強します", "পড়াশোনা করি")]),
            make_item("jp-p1-l3-002", "びょういんの いしゃは しんせつです。", "びょういんのいしゃはしんせつです。", "Byouin no isha wa shinsetsu desu.", "হাসপাতালের ডাক্তার দয়ালু।", "বিয়োওইন নো ইশা ওয়া শিনসেতসু দেস।", [("びょういん", "byouin", "病院", "হাসপাতাল"), ("の", "no", "の", "এর"), ("いしゃ", "isha", "医者", "ডাক্তার"), ("は", "wa", "は", "হল"), ("しんせつです", "shinsetsu desu", "親切です", "দয়ালু")]),
            make_item("jp-p1-l3-003", "じてんしゃで ぎんこうへ いきます。", "じてんしゃでぎんこうへいきます。", "Jitensha de ginkou e ikimasu.", "সাইকেলে করে ব্যাংকে যাই।", "জিতেন্সা দে গিনকোও এ ইকিমাসু।", [("じてんしゃ", "jitensha", "自転車", "সাইকেল"), ("で", "de", "で", "দিয়ে"), ("ぎんこう", "ginkou", "銀行", "ব্যাংক"), ("へ", "e", "へ", "দিকে"), ("いきます", "ikimasu", "行きます", "যাই")])
        ]
    },
    {
        "id": "jp-foundations-l04",
        "order": 4,
        "title_bn": "৫টি জাপানিজ টাং টুইস্টার (Hayakuchikotoba - 早口言葉)",
        "title_target": "5 Japanese Tongue Twisters for Oral Fluency",
        "intro_bn": "জাপানিজ উচ্চারণকে সাবলীল ও নির্ভুল করতে ক্লাসিক্যাল 'হায়াকুচিকোতোবা' বা দ্রুত কথা বলার ড্রিল অত্যন্ত কার্যকরী।",
        "structure": ["Fast Pitch Accent & Articulation Drills (早口言葉)"],
        "items": [
            make_item("jp-p1-twister-001", "なまむぎ なまごめ なまたまご。", "なまむぎなまごめなまたまご。", "Nama mugi nama gome nama tamago.", "কাঁচা গম, কাঁচা চাল, কাঁচা ডিম। (টাং টুইস্টার ১)", "নামা মুগি নামা গোমে নামা তামাগো।", [("なまむぎ", "nama mugi", "生麦", "কাঁচা গম"), ("なまごめ", "nama gome", "生米", "কাঁচা চাল"), ("なまたまご", "nama tamago", "生卵", "কাঁচা ডিম")], item_type="tongue_twister"),
            make_item("jp-p1-twister-002", "すももも ももも もものうち。", "すもももももももものうち。", "Sumomo mo momo mo momo no uchi.", "আলুবোখারাও পীচ ফল, পীচ ফলও পীচ পরিবারের অংশ। (টাং টুইস্টার ২)", "সুমোমো মো মোমো মো মোমো নো উচি।", [("すもも", "sumomo", "李", "আলুবোখারা"), ("も", "mo", "も", "ও"), ("もも", "momo", "桃", "পীচ ফল"), ("も", "mo", "も", "ও"), ("もものうち", "momo no uchi", "桃のうち", "পীচ পরিবারের অন্তর্ভুক্ত")], item_type="tongue_twister"),
            make_item("jp-p1-twister-003", "あかパジャマ、あおパジャマ、きパジャマ。", "あかぱじゃま、あおぱじゃま、きぱじゃま。", "Aka pajama, ao pajama, ki pajama.", "লাল পায়জামা, নীল পায়জামা, হলুদ পায়জামা। (টাং টুইস্টার ৩)", "আকা পাজামা, আও পাজামা, কি পাজামা।", [("あかパジャマ", "aka pajama", "赤パジャマ", "লাল পায়জামা"), ("あおパジャマ", "ao pajama", "青パジャマ", "নীল পায়জামা"), ("きパジャマ", "ki pajama", "黄パジャマ", "হলুদ পায়জামা")], item_type="tongue_twister"),
            make_item("jp-p1-twister-004", "とうきょう とっきょ きょかきょく きょくちょう。", "とうきょうとっきょきょかきょくきょくちょう。", "Toukyou tokkyo kyokakyoku kyokuchou.", "টোকিও পেটেন্ট ব্যুরোর মহাপরিচালক। (টাং টুইস্টার ৪)", "তোকিও তোক্কিও কিওকাকিওকু কিওকুচোও।", [("とうきょう", "toukyou", "東京", "টোকিও"), ("とっきょ", "tokkyo", "特許", "পেটেন্ট"), ("きょかきょく", "kyokakyoku", "許可局", "অনুমতি ব্যুরো"), ("きょくちょう", "kyokuchou", "局長", "ব্যুরো প্রধান")], item_type="tongue_twister"),
            make_item("jp-p1-twister-005", "となりの きゃくは よく かき くう きゃくだ。", "となりのきゃくはよくかきくうきゃくだ。", "Tonari no kyaku wa yoku kaki kuu kyaku da.", "পাশের ঘরের অতিথি বেশি বেশি পার্সিমন ফল খাওয়া অতিথি। (টাং টুইস্টার ৫)", "তোরারি নো কিয়াকু ওয়া ইয়োকু কাকি কুউ কিয়াকু দা।", [("となり", "tonari", "隣", "পাশের"), ("の", "no", "の", "এর"), ("きゃく", "kyaku", "客", "অতিথি"), ("は", "wa", "は", "হল"), ("よく", "yoku", "良く", "বেশি"), ("かき", "kaki", "柿", "পার্সিমন"), ("くう", "kuu", "食う", "খায়"), ("きゃくだ", "kyaku da", "客だ", "অতিথি")], item_type="tongue_twister")
        ]
    }
]
parts.append({
    "id": "jp-foundations-p1",
    "order": 1,
    "level": "A1",
    "title_bn": "বর্ণমালা, উচ্চারণ ও ফ্লুয়েন্সি ড্রিল (Pronunciation, Pitch & Kana)",
    "title_target": "Pronunciation, Pitch, Kana & Fluency Drills",
    "lessons": p1_lessons
})

# ==============================================================================
# PART 2: পেশা, পরিচয় ও জাতীয়তা (Identity & Be-Verbs: です / ではありません)
# ==============================================================================
p2_lessons = [
    {
        "id": "jp-foundations-l05",
        "order": 1,
        "title_bn": "আমার পেশা ও পরিচয় — 'わたしは〜です'",
        "title_target": "My Identity & Profession (Watashi wa ... desu)",
        "intro_bn": "নিজের পরিচয়, নাম বা পেশা প্রকাশ করতে 'わたしは [নাম/পেশা] です' ব্যবহার করা হয়। জাপানিজে 'は' হলো টপিক মার্কার (উচ্চারণ wa) এবং 'です' (desu) বাক্যকে মার্জিত করে।",
        "structure": ["Topic (わたしは) + Profession/Noun + です (desu)"],
        "items": [
            make_item("jp-p2-l5-001", "わたしは がくせいです。", "わたしはがくせいです。", "Watashi wa gakusei desu.", "আমি একজন শিক্ষার্থী।", "ওয়াতাশি ওয়া গাকুসেই দেস।", [("わたし", "watashi", "私", "আমি"), ("は", "wa", "は", "হল"), ("がくせい", "gakusei", "学生", "শিক্ষার্থী"), ("です", "desu", "です", "হই")]),
            make_item("jp-p2-l5-002", "わたしは エンジニアです。", "わたしはえんじにあです。", "Watashi wa enjinia desu.", "আমি একজন প্রকৌশলী (ইঞ্জিনিয়ার)।", "ওয়াতাশি ওয়া এনজিনিয়া দেস।", [("わたし", "watashi", "私", "আমি"), ("は", "wa", "は", "হল"), ("エンジニア", "enjinia", "エンジニア", "প্রকৌশলী"), ("です", "desu", "です", "হই")]),
            make_item("jp-p2-l5-003", "わたしは バングラデシュじんです。", "わたしはばんぐらでしゅじんです。", "Watashi wa Banguradeshu-jin desu.", "আমি বাংলাদেশি।", "ওয়াতাশি ওয়া বাঙ্গুরাদেশু-জিন দেস।", [("わたし", "watashi", "私", "আমি"), ("は", "wa", "は", "হল"), ("バングラデシュじん", "banguradeshu-jin", "バングラデシュ人", "বাংলাদেশি"), ("です", "desu", "です", "হই")]),
            make_item("jp-p2-l5-004", "わたしは かいしゃいんです。", "わたしはかいしゃいんです。", "Watashi wa kaishain desu.", "আমি কোম্পানি কর্মচারী (চাকরিজীবী)।", "ওয়াতাশি ওয়া কাইশাইন দেস।", [("わたし", "watashi", "私", "আমি"), ("は", "wa", "は", "হল"), ("かいしゃいん", "kaishain", "会社員", "চাকরিজীবী"), ("です", "desu", "です", "হই")]),
            make_item("jp-p2-l5-005", "はじめまして。ラヒムです。どうぞ よろしく おねがいします。", "はじめまして。らひむです。どうぞよろしくおねがいします。", "Hajimemashite. Rahimu desu. Douzo yoroshiku onegaishimasu.", "প্রথম পরিচয়। আমি রহিম। পরিচিত হয়ে ভালো লাগল।", "হাজিমেমাশিতে। রাহিমু দেস। দোওজো ইয়োরোশিকু ওনেগাইশিমাসু।", [("はじめまして", "hajimemashite", "初めまして", "প্রথম পরিচয়"), ("ラヒム", "rahimu", "ラヒム", "রহিম"), ("です", "desu", "です", "হই"), ("どうぞ", "douzo", "どうぞ", "অনুগ্রহ করে"), ("よろしく", "yoroshiku", "宜しく", "সদয় আচরণ"), ("おねがいします", "onegaishimasu", "お願いします", "অনুরোধ করছি")])
        ]
    },
    {
        "id": "jp-foundations-l06",
        "order": 2,
        "title_bn": "অন্যের পরিচয় ও পেশা (Others' Identity & Profession)",
        "title_target": "Others' Identity & Professions (~san wa ... desu)",
        "intro_bn": "অন্য কারো নাম বা পেশা বলার সময় নামের শেষে সম্মানসূচক 'さん' (san) যুক্ত করতে হয়। যেমন: 田中さん (তানাকা বাবু)।",
        "structure": ["Person + さん + は + Profession + です"],
        "items": [
            make_item("jp-p2-l6-001", "たなかさんは にほんごの せんせいです。", "たなかさんはにほんごのせんせいです。", "Tanaka-san wa nihongo no sensei desu.", "তানাকা বাবু জাপানি ভাষার শিক্ষক।", "তানাকা-সান ওয়া নিহঙ্গো নো সেনসেই দেস।", [("たなかさん", "tanaka-san", "田中さん", "তানাকা বাবু"), ("は", "wa", "は", "হল"), ("にほんご", "nihongo", "日本語", "জাপানি ভাষা"), ("の", "no", "の", "এর"), ("せんせい", "sensei", "先生", "শিক্ষক"), ("です", "desu", "です", "হন")]),
            make_item("jp-p2-l6-002", "マリアさんは いしゃです。", "まりあさんはいしゃです。", "Maria-san wa isha desu.", "মারিয়া একজন ডাক্তার।", "মারিয়া-সান ওয়া ইশা দেস।", [("マリアさん", "maria-san", "マリアさん", "মারিয়া"), ("は", "wa", "は", "হল"), ("いしゃ", "isha", "医者", "চিকিৎসক"), ("です", "desu", "です", "হন")]),
            make_item("jp-p2-l6-003", "あのかたは だいがくの きょうじゅです。", "あのかたはだいがくのきょうじゅです。", "Ano kata wa daigaku no kyouju desu.", "ওই ভদ্রলোক বিশ্ববিদ্যালয়ের অধ্যাপক।", "আনো কাতা ওয়া দাইগাকু নো কিওওজু দেস।", [("あのかた", "ano kata", "あの方", "ওই শ্রদ্ধেয় ব্যক্তি"), ("は", "wa", "は", "হল"), ("だいがく", "daigaku", "大学", "বিশ্ববিদ্যালয়"), ("の", "no", "の", "এর"), ("きょうじゅ", "kyouju", "教授", "অধ্যাপক"), ("です", "desu", "です", "হন")]),
            make_item("jp-p2-l6-004", "かれらは ぎんこういんです。", "かれらはぎんこういんです。", "Karera wa ginkouin desu.", "তারা ব্যাংক কর্মকর্তা।", "কারে-রা ওয়া গিনকোওইন দেস।", [("かれら", "karera", "彼ら", "তারা"), ("は", "wa", "は", "হল"), ("ぎんこういん", "ginkouin", "銀行員", "ব্যাংক কর্মকর্তা"), ("です", "desu", "です", "হন")])
        ]
    },
    {
        "id": "jp-foundations-l07",
        "order": 3,
        "title_bn": "না-বোধক পরিচয় — '〜ではありません / じゃありません'",
        "title_target": "Negative Identity (Dewa Arimasen / Ja Arimasen)",
        "intro_bn": "কোনো পরিচয় না-বোধক করতে 'です' এর স্থানে 'ではありません' (মার্জিত) বা 'じゃありません' (কথ্য মার্জিত) বসে।",
        "structure": ["Topic + は + Noun + ではありません / じゃありません"],
        "items": [
            make_item("jp-p2-l7-001", "わたしは せんせいでは ありません。", "わたしわせんせいでわありません。", "Watashi wa sensei dewa arimasen.", "আমি শিক্ষক নই।", "ওয়াতাশি ওয়া সেনসেই দেবা আরিমাসেন।", [("わたし", "watashi", "私", "আমি"), ("は", "wa", "は", "হল"), ("せんせい", "sensei", "先生", "শিক্ষক"), ("では ありません", "dewa arimasen", "ではありません", "নই")], polarity="negative"),
            make_item("jp-p2-l7-002", "たなかさんは がくせいじゃ ありません。", "たなかさんはがくせいじゃありません。", "Tanaka-san wa gakusei ja arimasen.", "তানাকা-সান শিক্ষার্থী নন।", "তানাকা-সান ওয়া গাকুসেই জা আরিমাসেন।", [("たなかさん", "tanaka-san", "田中さん", "তানাকা বাবু"), ("は", "wa", "は", "হল"), ("がくせい", "gakusei", "学生", "শিক্ষার্থী"), ("じゃ ありません", "ja arimasen", "じゃありません", "নন")], polarity="negative"),
            make_item("jp-p2-l7-003", "わたしは にほんじんでは ありません。バングラデシュじんです。", "わたしわにほんじんでわありません。ばんぐらでしゅじんです。", "Watashi wa nihonjin dewa arimasen. Banguradeshu-jin desu.", "আমি জাপানি নই। আমি বাংলাদেশি।", "ওয়াতাশি ওয়া নিহোনজিন দেবা আরিমাসেন। বাঙ্গুরাদেশু-জিন দেস।", [("わたし", "watashi", "私", "আমি"), ("は", "wa", "は", "হল"), ("にほんじん", "nihonjin", "日本人", "জাপানি"), ("では ありません", "dewa arimasen", "ではありません", "নই"), ("バングラデシュじん", "banguradeshu-jin", "バングラデシュ人", "বাংলাদেশি"), ("です", "desu", "です", "হই")], polarity="negative")
        ]
    },
    {
        "id": "jp-foundations-l08",
        "order": 4,
        "title_bn": "৬-রূপান্তর ড্রিল: পেশা ও পরিচয় (6 Transformations Drill)",
        "title_target": "6 Sentence Transformations: Identity (Desu / Dewa arimasen)",
        "intro_bn": "একটি মূল বাক্যকে দ্রুত ৬টি রূপে রূপান্তর করার অনুশীলন করুন: হ্যাঁ-বোধক, না-বোধক, প্রশ্নবোধক, না-বোধক প্রশ্ন, WH-প্রশ্ন এবং বিকল্প প্রশ্ন।",
        "structure": [
            "1. Affirmative (+): N は N です",
            "2. Negative (-): N は N ではありません",
            "3. Question (?): N は N ですか",
            "4. Negative Q (-?): N は N ではありませんか",
            "5. WH-Question: だれが N ですか",
            "6. Alternative Q: A ですか、B ですか"
        ],
        "items": [
            make_item("jp-p2-l8-001", "たなかさんは せんせいです。", "たなかさんはせんせいです。", "Tanaka-san wa sensei desu.", "১. হ্যাঁ-বোধক: তানাকা বাবু একজন শিক্ষক।", "তানাকা-সান ওয়া সেনসেই দেস।", [("たなかさん", "tanaka-san", "田中さん", "তানাকা"), ("は", "wa", "は", "হল"), ("せんせい", "sensei", "先生", "শিক্ষক"), ("です", "desu", "です", "হন")], item_type="drill", sentence_type="assertive", polarity="affirmative"),
            make_item("jp-p2-l8-002", "たなかさんは せんせいでは ありません。", "たなかさんはせんせいでわありません。", "Tanaka-san wa sensei dewa arimasen.", "২. না-বোধক: তানাকা বাবু শিক্ষক নন।", "তানাকা-সান ওয়া সেনসেই দেবা আরিমাসেন।", [("たなかさん", "tanaka-san", "田中さん", "তানাকা"), ("は", "wa", "は", "হল"), ("せんせい", "sensei", "先生", "শিক্ষক"), ("では ありません", "dewa arimasen", "ではありません", "নন")], item_type="drill", sentence_type="assertive", polarity="negative"),
            make_item("jp-p2-l8-003", "たなかさんは せんせいですか。", "たなかさんはせんせいですか。", "Tanaka-san wa sensei desu ka.", "৩. প্রশ্নবোধক: তানাকা বাবু কি শিক্ষক?", "তানাকা-সান ওয়া সেনসেই দেসু কা?", [("たなかさん", "tanaka-san", "田中さん", "তানাকা"), ("は", "wa", "は", "হল"), ("せんせい", "sensei", "先生", "শিক্ষক"), ("ですか", "desu ka", "ですか", "কি?")], item_type="drill", sentence_type="interrogative", polarity="affirmative"),
            make_item("jp-p2-l8-004", "たなかさんは せんせいでは ありませんか。", "たなかさんはせんせいでわありませんか。", "Tanaka-san wa sensei dewa arimasen ka.", "৪. না-বোধক প্রশ্ন: তানাকা বাবু কি শিক্ষক নন?", "তানাকা-সান ওয়া সেনসেই দেবা আরিমাসেন কা?", [("たなかさん", "tanaka-san", "田中さん", "তানাকা"), ("は", "wa", "は", "হল"), ("せんせい", "sensei", "先生", "শিক্ষক"), ("では ありませんか", "dewa arimasen ka", "ではありませんか", "নন কি?")], item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-p2-l8-005", "だれが せんせいですか。たなかさんが せんせいです。", "だれがせんせいですか。たなかさんがせんせいです。", "Dare ga sensei desu ka. Tanaka-san ga sensei desu.", "৫. WH-প্রশ্ন: কে শিক্ষক? তানাকা বাবু শিক্ষক।", "দারে গা সেনসেই দেসু কা? তানাকা-সান গা সেনসেই দেস।", [("だれ", "dare", "誰", "কে"), ("が", "ga", "が", "Subject marker"), ("せんせい", "sensei", "先生", "শিক্ষক"), ("ですか", "desu ka", "ですか", "কি?"), ("たなかさん", "tanaka-san", "田中さん", "তানাকা"), ("が", "ga", "が", "Subject"), ("せんせいです", "sensei desu", "先生です", "শিক্ষক")], item_type="drill", sentence_type="wh_question", polarity="affirmative"),
            make_item("jp-p2-l8-006", "たなかさんは せんせいですか、がくせいですか。", "たなかさんはせんせいですか、がくせいですか。", "Tanaka-san wa sensei desu ka, gakusei desu ka.", "৬. বিকল্প প্রশ্ন: তানাকা বাবু কি শিক্ষক, নাকি শিক্ষার্থী?", "তানাকা-সান ওয়া সেনসেই দেসু কা, গাকুসেই দেসু কা?", [("たなかさん", "tanaka-san", "田中さん", "তানাকা"), ("は", "wa", "は", "হল"), ("せんせいですか", "sensei desu ka", "先生ですか", "শিক্ষক কি"), ("がくせいですか", "gakusei desu ka", "学生ですか", "নাকি শিক্ষার্থী?")], item_type="drill", sentence_type="alternative_question", polarity="affirmative")
        ]
    }
]
parts.append({
    "id": "jp-foundations-p2",
    "order": 2,
    "level": "A1",
    "title_bn": "পেশা, পরিচয় ও জাতীয়তা (Identity & Be-Verbs: です / ではありません)",
    "title_target": "Professions & Identity (Desu / Dewa Arimasen)",
    "lessons": p2_lessons
})

# ==============================================================================
# PART 3: বস্তু, দাম ও অবস্থান নির্দেশক (Objects, Demonstratives & Pricing)
# ==============================================================================
p3_lessons = [
    {
        "id": "jp-foundations-l09",
        "order": 1,
        "title_bn": "বস্তু নির্দেশ — 'これ・それ・あれ・どれ' (This, That, Which)",
        "title_target": "Demonstrative Pronouns (Kore, Sore, Are, Dore)",
        "intro_bn": "বক্তার কাছের বস্তু 'これ' (kore - এটি), শ্রোতার কাছের বস্তু 'それ' (sore - ওটি), এবং দুজনের থেকেই দূরবর্তী বস্তু 'あれ' (are - ওইটি)। কোনটি জানতে 'どれ' (dore) ব্যবহৃত হয়।",
        "structure": ["これ / それ / あれ + は + Noun + です", "Question: それは 何ですか (Sore wa nan desu ka)"],
        "items": [
            make_item("jp-p3-l9-001", "これは ほんです。", "これはほんです。", "Kore wa hon desu.", "এটি একটি বই।", "কোরে ওয়া হোন দেস।", [("これ", "kore", "これ", "এটি"), ("は", "wa", "は", "হল"), ("ほん", "hon", "本", "বই"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p3-l9-002", "それは わたしのかばんです。", "それはわたしのかばんです。", "Sore wa watashi no kaban desu.", "ওটি আমার ব্যাগ।", "সোরে ওয়া ওয়াতাশি নো কাবান দেস।", [("それ", "sore", "それ", "ওটি"), ("は", "wa", "は", "হল"), ("わたし", "watashi", "私", "আমি"), ("の", "no", "の", "এর"), ("かばん", "kaban", "鞄", "ব্যাগ"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p3-l9-003", "あれは たなかさんの じどうしゃです。", "あれはたなかさんのじどうしゃです。", "Are wa Tanaka-san no jidousha desu.", "ওইটি তানাকা বাবুর গাড়ি।", "আরে ওয়া তানাকা-সান নো জিদোওশা দেস।", [("あれ", "are", "あれ", "ওইটি"), ("は", "wa", "は", "হল"), ("たなかさん", "tanaka-san", "田中さん", "তানাকা"), ("の", "no", "の", "এর"), ("じどうしゃ", "jidousha", "自動車", "গাড়ি"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p3-l9-004", "それは なんですか。これは にほんの おちゃです。", "それはなんですか。これはにほんのおちゃです。", "Sore wa nan desu ka. Kore wa nihon no ocha desu.", "ওটি কী? এটি জাপানি চা।", "সোরে ওয়া নান দেসু কা? কোরে ওয়া নিহোন নো ওচা দেস।", [("それ", "sore", "それ", "ওটি"), ("は", "wa", "は", "হল"), ("なんですか", "nan desu ka", "何ですか", "কী?"), ("これ", "kore", "これ", "এটি"), ("は", "wa", "は", "হল"), ("にほん", "nihon", "日本", "জাপান"), ("の", "no", "の", "এর"), ("おちゃ", "ocha", "お茶", "চা"), ("です", "desu", "です", "হয়")])
        ]
    },
    {
        "id": "jp-foundations-l10",
        "order": 2,
        "title_bn": "বিশেষ্য সহ নির্দেশক — 'この・その・あの・どの + Noun'",
        "title_target": "Demonstrative Adjectives (Kono, Sono, Ano, Dono + N)",
        "intro_bn": "বিশেষ্যের আগে বসে সরাসরি নির্দেশ করতে この (এই), その (সেই/ওই), あの (ওই দূরবর্তী), どの (কোন) ব্যবহৃত হয়। যেমন: この本 (এই বইটি)।",
        "structure": ["この / その / あの / どの + Noun + は ... です"],
        "items": [
            make_item("jp-p3-l10-001", "この かさは わたしのです。", "このかさはわたしのです。", "Kono kasa wa watashi no desu.", "এই ছাতাটি আমার।", "কোনো কাসা ওয়া ওয়াতাশি নো দেস।", [("この", "kono", "この", "এই"), ("かさ", "kasa", "傘", "ছাতা"), ("は", "wa", "は", "হল"), ("わたし", "watashi", "私", "আমার"), ("の", "no", "の", "টা/এর"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p3-l10-002", "その とけいは にほんせいです。", "そのとけいはにほんせいです。", "Sono tokei wa nihon-sei desu.", "সেই ঘড়িটি জাপানে তৈরি।", "সোনো তোকেই ওয়া নিহোন-সেই দেস।", [("その", "sono", "その", "সেই"), ("とけい", "tokei", "時計", "ঘড়ি"), ("は", "wa", "は", "হল"), ("にほんせい", "nihon-sei", "日本製", "মেড ইন জাপান"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p3-l10-003", "あの ひとは だれですか。さとうさんです。", "あのひとはだれですか。さとうさんです。", "Ano hito wa dare desu ka. Satou-san desu.", "ওই লোকটি কে? উনি সাতো-সান।", "আনো হিতো ওয়া দারে দেসু কা? সাতোও-সান দেস।", [("あの", "ano", "あの", "ওই"), ("ひと", "hito", "人", "ব্যক্তি"), ("は", "wa", "は", "হল"), ("だれですか", "dare desu ka", "誰ですか", "কে?"), ("さとうさん", "satou-san", "佐藤さん", "সাতো-সান"), ("です", "desu", "です", "হন")])
        ]
    },
    {
        "id": "jp-foundations-l11",
        "order": 3,
        "title_bn": "স্থান নির্দেশক — 'ここ・そこ・あそこ・どこ' (Here, There, Where)",
        "title_target": "Place Demonstratives (Koko, Soko, Asoko, Doko)",
        "intro_bn": "স্থান বোঝাতে ここ (এখানে), そこ (সেখানে), あそこ (ওখানে দূরবর্তী) এবং どこ (কোথায়) ব্যবহৃত হয়। ভদ্র ভাষায় こちら, そちら, あちら, どちら বলা হয়।",
        "structure": ["Place/Noun + は + ここ / そこ / あそこ です", "Question: [Noun] は どこですか"],
        "items": [
            make_item("jp-p3-l11-001", "トイレは どこですか。あそこです。", "といれはどこですか。あそこです。", "Toire wa doko desu ka. Asoko desu.", "টয়লেট কোথায়? ওখানে।", "তোইরে ওয়া দোকো দেসু কা? আসোকো দেস।", [("トイレ", "toire", "トイレ", "টয়লেট"), ("は", "wa", "は", "হল"), ("どこですか", "doko desu ka", "どこですか", "কোথায়?"), ("あそこ", "asoko", "あそこ", "ওখানে"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p3-l11-002", "うけつけは ここです。", "うけつけはここです。", "Uketsuke wa koko desu.", "রিসিপশন এখানে।", "উকেতসুকে ওয়া কোকো দেস।", [("うけつけ", "uketsuke", "受付", "রিসিপশন/অভ্যর্থনা"), ("は", "wa", "は", "হল"), ("ここ", "koko", "ここ", "এখানে"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p3-l11-003", "じむしょは にかいです。", "じむしょはにかいです。", "Jimusho wa nikai desu.", "অফিস দোতলায়।", "জিমুশো ওয়া নিকাই দেস।", [("じむしょ", "jimusho", "事務所", "অফিস"), ("は", "wa", "は", "হল"), ("にかい", "nikai", "２階", "দোতলা"), ("です", "desu", "です", "হয়")])
        ]
    },
    {
        "id": "jp-foundations-l12",
        "order": 4,
        "title_bn": "মূল্য জিজ্ঞাসা ও কেনাকাটা — 'いくらですか' (How much is this?)",
        "title_target": "Shopping & Price Inquiry (Ikura desu ka)",
        "intro_bn": "দোকানে কোনো জিনিসের দাম জানতে 'これは いくらですか' (এটি কত টাকা?) বলতে হয়। মুদ্রা হিসেবে 円 (en - ইয়েন) ব্যবহৃত হয়।",
        "structure": ["Noun + は + いくらですか (How much is ...?)", "Price + 円 (en) です"],
        "items": [
            make_item("jp-p3-l12-001", "すみません。この かばんは いくらですか。", "すみません。このかばんはいくらですか。", "Sumimasen. Kono kaban wa ikura desu ka.", "মাফ করবেন। এই ব্যাগটির দাম কত?", "সুমিমাসেন। কোনো কাবান ওয়া ইকুরা দেসু কা?", [("すみません", "sumimasen", "すみません", "মাফ করবেন"), ("この", "kono", "この", "এই"), ("かばん", "kaban", "鞄", "ব্যাগ"), ("は", "wa", "は", "হল"), ("いくらですか", "ikura desu ka", "幾らですか", "কত দাম?")]),
            make_item("jp-p3-l12-002", "それは さんぜん ごひゃくえんです。", "それはさんぜんごひゃくえんです。", "Sore wa sanzen gohyaku-en desu.", "ওটি ৩,৫০০ ইয়েন।", "সোরে ওয়া সানজেন গোহিয়াকু-য়েন দেস।", [("それ", "sore", "それ", "ওটি"), ("は", "wa", "は", "হল"), ("さんぜん ごひゃくえん", "sanzen gohyaku-en", "3,500円", "৩,৫০০ ইয়েন"), ("です", "desu", "です", "হয়")]),
            make_item("jp-p3-l12-003", "じゃ、これを ください。", "じゃ、これをください。", "Ja, kore o kudasai.", "তাহলে এটি আমাকে দিন।", "জা, কোরে ও কুদাসাই।", [("じゃ", "ja", "じゃ", "তাহলে"), ("これ", "kore", "これ", "এটি"), ("を", "o", "を", "কে"), ("ください", "kudasai", "下さい", "দিন/দয়া করে")])
        ]
    },
    {
        "id": "jp-foundations-l13",
        "order": 5,
        "title_bn": "বস্তু পরিচিতির প্রশ্ন-উত্তর ড্রিল (Yes/No Q&A with Corrections)",
        "title_target": "Yes/No Q&A with Affirmation & Correction Drills",
        "intro_bn": "প্রশ্নের জবাবে হ্যাঁ হলে 'はい、そうです' (হ্যাঁ, তাই) এবং না হলে 'いいえ、ちがいます' (না, ভুল) বলে সঠিক তথ্য দিতে হয়।",
        "structure": [
            "Q: これは Noun ですか",
            "A1: はい、そうです (Yes, that's right)",
            "A2: いいえ、ちがいます。[Correct Noun] です (No, it's ...)"
        ],
        "items": [
            make_item("jp-p3-l13-001", "これは じしょですか。はい、そうです。", "これはじしょですか。はい、そうです。", "Kore wa jisho desu ka. Hai, sou desu.", "এটি কি অভিধান? হ্যাঁ, তাই।", "কোরে ওয়া জিশো দেসু কা? হাই, সোও দেস।", [("これ", "kore", "これ", "এটি"), ("は", "wa", "は", "হল"), ("じしょですか", "jisho desu ka", "辞書ですか", "অভিধান কি?"), ("はい", "hai", "はい", "হ্যাঁ"), ("そうです", "sou desu", "そうです", "তাই")]),
            make_item("jp-p3-l13-002", "これは ボールペンですか。いいえ、シャープペンシルです。", "これはぼーるぺんですか。いいえ、しゃーぷぺんしるです。", "Kore wa boorupen desu ka. Iie, shaapu penshiru desu.", "এটি কি বলপয়েন্ট কলম? না, মেকানিক্যাল পেন্সিল।", "কোরে ওয়া বোরুপেন দেসু কা? ইইয়ে, শাপু পেনশিরু দেস।", [("これ", "kore", "これ", "এটি"), ("は", "wa", "は", "হল"), ("ボールペンですか", "boorupen desu ka", "ボールペンですか", "বলপয়েন্ট কি?"), ("いいえ", "iie", "いいえ", "না"), ("シャープペンシルです", "shaapu penshiru desu", "シャープペンシルです", "মেকানিক্যাল পেন্সিল")]),
            make_item("jp-p3-l13-003", "その ノートは ラヒムさんのですか。いいえ、ラヒムさんのじゃ ありません。カマルさんのです。", "そののーとはらひむさんのですか。いいえ、らひむさんのじゃありません。かまるさんのです。", "Sono nooto wa Rahimu-san no desu ka. Iie, Rahimu-san no ja arimasen. Kamaru-san no desu.", "সেই নোটবইটি কি রহিমের? না, রহিমের নয়। কামালের।", "সোনো নোতো ওয়া রাহিমু-সান নো দেসু কা? ইইয়ে, রাহিমু-সান নো জা আরিমাসেন। কামারু-সান নো দেস।", [("その", "sono", "その", "সেই"), ("ノート", "nooto", "ノート", "নোটবই"), ("は", "wa", "は", "হল"), ("ラヒムさんのですか", "rahimu-san no desu ka", "ラヒムさんのですか", "রহিমের কি?"), ("いいえ", "iie", "いいえ", "না"), ("ラヒムさんのじゃありません", "rahimu-san no ja arimasen", "ラヒムさんのじゃありません", "রহিমের নয়"), ("カマルさんのです", "kamaru-san no desu", "カマルさんのです", "কামালের")])
        ]
    }
]
parts.append({
    "id": "jp-foundations-p3",
    "order": 3,
    "level": "A1",
    "title_bn": "বস্তু, দাম ও অবস্থান নির্দেশক (Objects, Demonstratives & Pricing)",
    "title_target": "Daily Objects, Pricing & Location Indicators",
    "lessons": p3_lessons
})

print("Generating parts 4 to 12...")

# We will load and append remaining parts cleanly via python builder functions
