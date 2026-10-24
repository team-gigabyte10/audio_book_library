# -*- coding: utf-8 -*-
"""
Builder for Course 1: Japanese Spoken Foundations (JLPT N5)
Creates android/app/src/main/assets/spoken_japanese_foundations.json
Complete 12 Parts, 60 Lessons, ~750 Items.
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

# -------------------------------------------------------------
# Part 1: Pronunciation & Fluency Drills
# -------------------------------------------------------------
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
        "intro_bn": "দীর্ঘ স্বর (Chouon) উচ্চারণে দ্বিগুণ সময় দিতে হয়। দ্বিত্ব ব্যঞ্জন (っ small tsu) আসলে এক মোরা থামতে হয় (যেমন: きって kitte - ডাকটিকিট)।",
        "structure": ["Long Vowel (2 Moras) & Double Consonant Pause (っ)"],
        "items": [
            make_item("jp-p1-l2-001", "おとうさんは おかあさんと はなします。", "おとうさんはおかあさんとはなします。", "Otousan wa okaasan to hanashimasu.", "বাবা মায়ের সাথে কথা বলেন।", "ওতোওসান ওয়া ওকাআসান তো হানাশিমাসু।", [("おとうさん", "otousan", "お父さん", "বাবা"), ("は", "wa", "は", "হল"), ("おかあさん", "okaasan", "お母さん", "মা"), ("と", "to", "と", "সাথে"), ("はなします", "hanashimasu", "話します", "কথা বলেন")]),
            make_item("jp-p1-l2-002", "きょう、きってを かいました。", "きょう、きってをかいました。", "Kyou, kitte o kaimashita.", "আজ ডাকটিকিট কিনেছি।", "কিয়োও, কিত্তে ও কাইমাশিতা।", [("きょう", "kyou", "今日", "আজ"), ("きって", "kitte", "切手", "ডাকটিকিট"), ("を", "o", "を", "কে"), ("かいました", "kaimashita", "買いました", "কিনেছি")]),
            make_item("jp-p1-l2-003", "ちょっと まって ください。", "ちょっとまってください。", "Chotto matte kudasai.", "একটু অপেক্ষা করুন।", "চোত্তো মাত্তে কুদাসাই।", [("ちょっと", "chotto", "一寸", "একটু"), ("まって", "matte", "待って", "অপেক্ষা করে"), ("ください", "kudasai", "下さい", "দয়া করে")]),
            make_item("jp-p1-l2-004", "がっこうへ いって、ざっしを よみます。", "がっこうへいって、ざっしをよみます。", "Gakkou e itte, zasshi o yomimasu.", "স্কুলে গিয়ে ম্যাগাজিন পড়ি।", "গাক্কোও এ ইত্তে, জাস্শি ও ইয়োমিমাসু।", [("がっこう", "gakkou", "学校", "স্কুল"), ("へ", "e", "へ", "দিকে"), ("いって", "itte", "行って", "গিয়ে"), ("ざっし", "zasshi", "雑誌", "ম্যাগাজিন"), ("を", "o", "を", "কে"), ("よみます", "yomimasu", "読みます", "পড়ি")])
        ]
    },
    {
        "id": "jp-foundations-l03",
        "order": 3,
        "title_bn": "যুক্তাক্ষর ও পরিবর্তিত ধ্বনি (Youon & Dakuten が, ざ, だ, ば, ぱ)",
        "title_target": "Contracted Sounds (Youon) & Voiced Sounds (Dakuten)",
        "intro_bn": "যুক্তাক্ষর (যেমন: きゃ, しゅ, ちょ) এবং তেনতেন/মারু যোগে ঘোষ ধ্বনির উচ্চারণ।",
        "structure": ["Consonant + ya/yu/yo", "Voiced Consonant (Dakuten)"],
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
        "intro_bn": "জাপানিজ উচ্চারণকে সাবলীল ও জড়তামুক্ত করতে জনপ্রিয় টাং টুইস্টারগুলো বারবার দ্রুত বলুন।",
        "structure": ["Fast Pitch Accent & Articulation Drills (早口言葉)"],
        "items": [
            make_item("jp-p1-twister-001", "なまむぎ なまごめ なまたまご。", "なまむぎなまごめなまたまご。", "Nama mugi nama gome nama tamago.", "কাঁচা গম, কাঁচা চাল, কাঁচা ডিম।", "নামা মুগি নামা গোমে নামা তামাগো।", item_type="tongue_twister"),
            make_item("jp-p1-twister-002", "すももも ももも もものうち。", "すもももももももものうち。", "Sumomo mo momo mo momo no uchi.", "আলুবোখারাও পীচ ফল, পীচ ফলও পীচ পরিবারের অংশ।", "সুমোমো মো মোমো মো মোমো নো উচি।", item_type="tongue_twister"),
            make_item("jp-p1-twister-003", "あかパジャマ、あおパジャマ、きパジャマ。", "あかぱじゃま、あおぱじゃま、きぱじゃま。", "Aka pajama, ao pajama, ki pajama.", "লাল পায়জামা, নীল পায়জামা, হলুদ পায়জামা।", "আকা পাজামা, আও পাজামা, কি পাজামা।", item_type="tongue_twister"),
            make_item("jp-p1-twister-004", "とうきょう とっきょ きょかきょく きょくちょう。", "とうきょうとっきょきょかきょくきょくちょう。", "Toukyou tokkyo kyokakyoku kyokuchou.", "টোকিও পেটেন্ট ব্যুরোর মহাপরিচালক।", "তোকিও তোক্কিও কিওকাকিওকু কিওকুচোও।", item_type="tongue_twister"),
            make_item("jp-p1-twister-005", "となりの きゃくは よく かき くう きゃくだ。", "となりのきゃくはよくかきくうきゃくだ。", "Tonari no kyaku wa yoku kaki kuu kyaku da.", "পাশের ঘরের অতিথি বেশি বেশি পার্সিমন ফল খাওয়া অতিথি।", "তোরারি নো কিয়াকু ওয়া ইয়োকু কাকি কুউ কিয়াকু দা।", item_type="tongue_twister")
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

# -------------------------------------------------------------
# Part 2: Identity & Copula (です / ではありません)
# -------------------------------------------------------------
p2_lessons = [
    {
        "id": "jp-foundations-l05",
        "order": 1,
        "title_bn": "আমার পেশা ও পরিচয় — 'わたしは〜です'",
        "title_target": "My Identity & Profession (Watashi wa ... desu)",
        "intro_bn": "নিজের পরিচয়, নাম বা পেশা প্রকাশ করতে 'わたしは [নাম/পেশা] です' ব্যবহার করা হয়।",
        "structure": ["Topic (わたしは) + Profession/Noun + です (desu)"],
        "items": [
            make_item("jp-p2-l5-001", "わたしは がくせいです。", "わたしはがくせいです。", "Watashi wa gakusei desu.", "আমি একজন শিক্ষার্থী।", "ওয়াতাশি ওয়া গাকুসেই দেস।"),
            make_item("jp-p2-l5-002", "わたしは エンジニアです。", "わたしはえんじにあです。", "Watashi wa enjinia desu.", "আমি একজন প্রকৌশলী (ইঞ্জিনিয়ার)।", "ওয়াতাশি ওয়া এনজিনিয়া দেস।"),
            make_item("jp-p2-l5-003", "わたしは バングラデシュじんです。", "わたしはばんぐらでしゅじんです。", "Watashi wa Banguradeshu-jin desu.", "আমি বাংলাদেশি।", "ওয়াতাশি ওয়া বাঙ্গুরাদেশু-জিন দেস।"),
            make_item("jp-p2-l5-004", "わたしは かいしゃいんです。", "わたしはかいしゃいんです。", "Watashi wa kaishain desu.", "আমি কোম্পানি কর্মচারী।", "ওয়াতাশি ওয়া কাইশাইন দেস।"),
            make_item("jp-p2-l5-005", "はじめまして。ラヒムです。どうぞ よろしく おねがいします。", "はじめまして。らひむです。どうぞよろしくおねがいします。", "Hajimemashite. Rahimu desu. Douzo yoroshiku onegaishimasu.", "প্রথম পরিচয়। আমি রহিম। পরিচিত হয়ে ভালো লাগল।", "হাজিমেমাশিতে। রাহিমু দেস। দোওজো ইয়োরোশিকু ওনেগাইশিমাসু।")
        ]
    },
    {
        "id": "jp-foundations-l06",
        "order": 2,
        "title_bn": "অন্যের পরিচয় ও পেশা (Others' Identity & Profession)",
        "title_target": "Others' Identity & Professions (~san wa ... desu)",
        "intro_bn": "অন্য কারো নাম বা পেশা বলার সময় নামের শেষে সম্মানসূচক 'さん' (san) যুক্ত করতে হয়।",
        "structure": ["Person + さん + は + Profession + です"],
        "items": [
            make_item("jp-p2-l6-001", "たなかさんは にほんごの せんせいです。", "たなかさんはにほんごのせんせいです。", "Tanaka-san wa nihongo no sensei desu.", "তানাকা বাবু জাপানি ভাষার শিক্ষক।", "তানাকা-সান ওয়া নিহঙ্গো নো সেনসেই দেস।"),
            make_item("jp-p2-l6-002", "マリアさんは いしゃです。", "まりあさんはいしゃです。", "Maria-san wa isha desu.", "মারিয়া একজন ডাক্তার।", "মারিয়া-সান ওয়া ইশা দেস।"),
            make_item("jp-p2-l6-003", "あのかたは だいがくの きょうじゅです。", "あのかたはだいがくのきょうじゅです。", "Ano kata wa daigaku no kyouju desu.", "ওই ভদ্রলোক বিশ্ববিদ্যালয়ের অধ্যাপক।", "আনো কাতা ওয়া দাইগাকু নো কিওওজু দেস।"),
            make_item("jp-p2-l6-004", "かれらは ぎんこういんです。", "かれらはぎんこういんです。", "Karera wa ginkouin desu.", "তারা ব্যাংক কর্মকর্তা।", "কারে-রা ওয়া গিনকোওইন দেস।")
        ]
    },
    {
        "id": "jp-foundations-l07",
        "order": 3,
        "title_bn": "না-বোধক পরিচয় — '〜ではありません / じゃありません'",
        "title_target": "Negative Identity (Dewa Arimasen / Ja Arimasen)",
        "intro_bn": "কোনো পরিচয় না-বোধক করতে 'です' এর স্থানে 'ではありません' বা 'じゃありません' বসে।",
        "structure": ["Topic + は + Noun + ではありません / じゃありません"],
        "items": [
            make_item("jp-p2-l7-001", "わたしは せんせいでは ありません。", "わたしわせんセいでわありません。", "Watashi wa sensei dewa arimasen.", "আমি শিক্ষক নই।", "ওয়াতাশি ওয়া সেনসেই দেবা আরিমাসেন।", polarity="negative"),
            make_item("jp-p2-l7-002", "たなかさんは がくせいじゃ ありません。", "たなかさんはがくせいじゃありません。", "Tanaka-san wa gakusei ja arimasen.", "তানাকা-সান শিক্ষার্থী নন।", "তানাকা-সান ওয়া গাকুসেই জা আরিমাসেন।", polarity="negative"),
            make_item("jp-p2-l7-003", "わたしは にほんじんでは ありません。バングラデシュじんです。", "わたしわにほんじんでわありません。ばんぐらでしゅじんです。", "Watashi wa nihonjin dewa arimasen. Banguradeshu-jin desu.", "আমি জাপানি নই। আমি বাংলাদেশি।", "ওয়াতাশি ওয়া নিহোনজিন দেবা আরিমাসেন। বাঙ্গুরাদেশু-জিন দেস।", polarity="negative")
        ]
    },
    {
        "id": "jp-foundations-l08",
        "order": 4,
        "title_bn": "৬-রূপান্তর ড্রিল: পেশা ও পরিচয় (6 Transformations Drill)",
        "title_target": "6 Sentence Transformations: Identity (Desu / Dewa arimasen)",
        "intro_bn": "পেশা ও পরিচয় দিয়ে ৬টি রূপে রূপান্তরের স্পোকেন ড্রিল।",
        "structure": ["Affirmative (+)", "Negative (-)", "Question (?)", "Negative Q (-?)", "WH-Q", "Alternative Q"],
        "items": [
            make_item("jp-p2-l8-001", "たなかさんは せんせいです。", "たなかさんはせんせいです。", "Tanaka-san wa sensei desu.", "১. হ্যাঁ-বোধক: তানাকা বাবু একজন শিক্ষক।", "তানাকা-সান ওয়া সেনসেই দেস।", item_type="drill"),
            make_item("jp-p2-l8-002", "たなかさんは せんせいでは ありません。", "たなかさんはせんセいでわありません。", "Tanaka-san wa sensei dewa arimasen.", "২. না-বোধক: তানাকা বাবু শিক্ষক নন।", "তানাকা-সান ওয়া সেনসেই দেবা আরিমাসেন।", item_type="drill", polarity="negative"),
            make_item("jp-p2-l8-003", "たなかさんは せんせいですか。", "たなかさんはせんせいですか。", "Tanaka-san wa sensei desu ka.", "৩. প্রশ্নবোধক: তানাকা বাবু কি শিক্ষক?", "তানাকা-সান ওয়া সেনসেই দেসু কা?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-p2-l8-004", "たなかさんは せんせいでは ありませんか。", "たなかさんはせんセいでわありませんか。", "Tanaka-san wa sensei dewa arimasen ka.", "৪. না-বোধক প্রশ্ন: তানাকা বাবু কি শিক্ষক নন?", "তানাকা-সান ওয়া সেনসেই দেবা আরিমাসেন কা?", item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-p2-l8-005", "だれが せんせいですか。たなかさんが せんせいです。", "だれがせんせいですか。たなかさんがせんせいです。", "Dare ga sensei desu ka. Tanaka-san ga sensei desu.", "৫. WH-প্রশ্ন: কে শিক্ষক? তানাকা বাবু শিক্ষক।", "দারে গা সেনসেই দেসু কা? তানাকা-সান গা সেনসেই দেস।", item_type="drill", sentence_type="wh_question"),
            make_item("jp-p2-l8-006", "たなかさんは せんせいですか、がくせいですか。", "たなかさんはせんせいですか、がくせいですか。", "Tanaka-san wa sensei desu ka, gakusei desu ka.", "৬. বিকল্প প্রশ্ন: তানাকা বাবু কি শিক্ষক, নাকি শিক্ষার্থী?", "তানাকা-সান ওয়া সেনসেই দেসু কা, গাকুসেই দেসু কা?", item_type="drill", sentence_type="alternative_question")
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

# -------------------------------------------------------------
# Part 3: Objects, Demonstratives & Pricing
# -------------------------------------------------------------
p3_lessons = [
    {
        "id": "jp-foundations-l09",
        "order": 1,
        "title_bn": "বস্তু নির্দেশ — 'これ・それ・あれ・どれ' (This, That, Which)",
        "title_target": "Demonstrative Pronouns (Kore, Sore, Are, Dore)",
        "intro_bn": "কাছের বস্তু これ, শ্রোতার কাছের বস্তু それ, দূরবর্তী あれ এবং কোনটি বোঝাতে どれ।",
        "structure": ["これ / それ / あれ + は + Noun + です"],
        "items": [
            make_item("jp-p3-l9-001", "これは ほんです。", "これはほんです。", "Kore wa hon desu.", "এটি একটি বই।", "কোরে ওয়া হোন দেস।"),
            make_item("jp-p3-l9-002", "それは わたしのかばんです。", "それはわたしのかばんです。", "Sore wa watashi no kaban desu.", "ওটি আমার ব্যাগ।", "সোরে ওয়া ওয়াতাশি নো কাবান দেস।"),
            make_item("jp-p3-l9-003", "あれは たなかさんの じどうしゃです。", "あれはたなかさんのじどうしゃです。", "Are wa Tanaka-san no jidousha desu.", "ওইটি তানাকা বাবুর গাড়ি।", "আরে ওয়া তানাকা-সান নো জিদোওশা দেস।"),
            make_item("jp-p3-l9-004", "それは なんですか。これは にほんの おちゃです。", "それはなんですか。これはにほんのおちゃです。", "Sore wa nan desu ka. Kore wa nihon no ocha desu.", "ওটি কী? এটি জাপানি চা।", "সোরে ওয়া নান দেসু কা? কোরে ওয়া নিহোন নো ওচা দেস।")
        ]
    },
    {
        "id": "jp-foundations-l10",
        "order": 2,
        "title_bn": "বিশেষ্য সহ নির্দেশক — 'この・その・あの・どの + Noun'",
        "title_target": "Demonstrative Adjectives (Kono, Sono, Ano, Dono + N)",
        "intro_bn": "বিশেষ্যের আগে বসে সরাসরি নির্দেশ করতে この (এই), その (সেই), あの (ওই), どの (কোন) ব্যবহৃত হয়।",
        "structure": ["この / その / あの / どの + Noun + は ... です"],
        "items": [
            make_item("jp-p3-l10-001", "この かさは わたしのです。", "このかさはわたしのです。", "Kono kasa wa watashi no desu.", "এই ছাতাটি আমার।", "কোনো কাসা ওয়া ওয়াতাশি নো দেস।"),
            make_item("jp-p3-l10-002", "その とけいは にほんせいです。", "そのとけいはにほんせいです。", "Sono tokei wa nihon-sei desu.", "সেই ঘড়িটি জাপানে তৈরি।", "সোনো তোকেই ওয়া নিহোন-সেই দেস।"),
            make_item("jp-p3-l10-003", "あの ひとは だれですか。さとうさんです。", "あのひとはだれですか。さとうさんです。", "Ano hito wa dare desu ka. Satou-san desu.", "ওই লোকটি কে? উনি সাতো-সান।", "আনো হিতো ওয়া দারে দেসু কা? সাতোও-সান দেস।")
        ]
    },
    {
        "id": "jp-foundations-l11",
        "order": 3,
        "title_bn": "স্থান নির্দেশক — 'ここ・そこ・あそこ・どこ' (Here, There, Where)",
        "title_target": "Place Demonstratives (Koko, Soko, Asoko, Doko)",
        "intro_bn": "স্থান নির্দেশ করতে ここ (এখানে), そこ (সেখানে), あそこ (ওখানে) ও どこ (কোথায়)।",
        "structure": ["Noun + は + ここ / そこ / あそこ です"],
        "items": [
            make_item("jp-p3-l11-001", "トイレは どこですか。あそこです。", "といれはどこですか。あそこです。", "Toire wa doko desu ka. Asoko desu.", "টয়লেট কোথায়? ওখানে।", "তোইরে ওয়া দোকো দেসু কা? আসোকো দেস।"),
            make_item("jp-p3-l11-002", "うけつけは ここです。", "うけつけはここです。", "Uketsuke wa koko desu.", "রিসিপশন এখানে।", "উকেতসুকে ওয়া কোকো দেস।"),
            make_item("jp-p3-l11-003", "じむしょは にかいです。", "じむしょはにかいです。", "Jimusho wa nikai desu.", "অফিস দোতলায়।", "জিমুশো ওয়া নিকাই দেস।")
        ]
    },
    {
        "id": "jp-foundations-l12",
        "order": 4,
        "title_bn": "মূল্য জিজ্ঞাসা ও কেনাকাটা — 'いくらですか' (How much is this?)",
        "title_target": "Shopping & Price Inquiry (Ikura desu ka)",
        "intro_bn": "দোকানে কোনো জিনিসের দাম জানতে 'これは いくらですか' বলতে হয়।",
        "structure": ["Noun + は + いくらですか", "Price + 円 (en) です"],
        "items": [
            make_item("jp-p3-l12-001", "すみません。この かばんは いくらですか。", "すみません。このかばんはいくらですか。", "Sumimasen. Kono kaban wa ikura desu ka.", "মাফ করবেন। এই ব্যাগটির দাম কত?", "সুমিমাসেন। কোনো কাবান ওয়া ইকুরা দেসু কা?"),
            make_item("jp-p3-l12-002", "それは さんぜん ごひゃくえんです。", "それはさんぜんごひゃくえんです。", "Sore wa sanzen gohyaku-en desu.", "ওটি ৩,৫০০ ইয়েন।", "সোরে ওয়া সানজেন গোহিয়াকু-য়েন দেস।"),
            make_item("jp-p3-l12-003", "じゃ、これを ください。", "じゃ、これをください。", "Ja, kore o kudasai.", "তাহলে এটি আমাকে দিন।", "জা, কোরে ও কুদাসাই।")
        ]
    },
    {
        "id": "jp-foundations-l13",
        "order": 5,
        "title_bn": "বস্তু পরিচিতির প্রশ্ন-উত্তর ড্রিল (Yes/No Q&A with Corrections)",
        "title_target": "Yes/No Q&A with Affirmation & Correction Drills",
        "intro_bn": "প্রশ্নের জবাবে হ্যাঁ হলে 'はい、そうです' এবং না হলে 'いいえ、ちがいます' বলে সঠিক তথ্য দেওয়া।",
        "structure": ["Q: これは Noun ですか", "A: はい、そうです / いいえ、ちがいます"],
        "items": [
            make_item("jp-p3-l13-001", "これは じしょですか。はい、そうです。", "これはじしょですか。はい、そうです。", "Kore wa jisho desu ka. Hai, sou desu.", "এটি কি অভিধান? হ্যাঁ, তাই।", "কোরে ওয়া জিশো দেসু কা? হাই, সোও দেস।"),
            make_item("jp-p3-l13-002", "これは ボールペンですか。いいえ、シャープペンシルです。", "これはぼーるぺんですか。いいえ、しゃーぷぺんしるです。", "Kore wa boorupen desu ka. Iie, shaapu penshiru desu.", "এটি কি বলপয়েন্ট কলম? না, মেকানিক্যাল পেন্সিল।", "কোরে ওয়া বোরুপেন দেসু কা? ইইয়ে, শাপু পেনশিরু দেস।"),
            make_item("jp-p3-l13-003", "その ノートは ラヒムさんのですか。いいえ、ラヒムさんのじゃ ありません。カマルさんのです。", "そののーとはらひむさんのですか。いいえ、らひむさんのじゃありません。かまるさんのです。", "Sono nooto wa Rahimu-san no desu ka. Iie, Rahimu-san no ja arimasen. Kamaru-san no desu.", "সেই নোটবইটি কি রহিমের? না, রহিমের নয়। কামালের।", "সোনো নোতো ওয়া রাহিমু-সান নো দেসু কা? ইইয়ে, রাহিমু-সান নো জা আরিমাসেন। কামারু-সান নো দেস।")
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

# -------------------------------------------------------------
# Part 4: Adjectives (い-Adjectives & な-Adjectives)
# -------------------------------------------------------------
p4_lessons = [
    {
        "id": "jp-foundations-l14",
        "order": 1,
        "title_bn": "い-বিশেষণ দিয়ে অবস্থা ও গুণ (i-Adjectives: Present Affirmative)",
        "title_target": "Expressing State with i-Adjectives (Oishii, Takai, Samui)",
        "intro_bn": "জাপানিজে 'い' দিয়ে শেষ হওয়া বিশেষণকে i-Adjective বলে। বর্তমান কালের মার্জিত রূপ তৈরিতে শেষে শুধু 'です' বসে।",
        "structure": ["Noun + は + i-Adjective (〜い) + です"],
        "items": [
            make_item("jp-p4-l14-001", "この りんごは とても おいしいです。", "このりんごはとてもおいしいです。", "Kono ringo wa totemo oishii desu.", "এই আপেলটি খুব সুস্বাদু।", "কোনো রিংগো ওয়া তোতেমো ওইশিই দেস।"),
            make_item("jp-p4-l14-002", "きょうは てんきが いいですが、すこし さむいです。", "きょうはてんきがいいですが、すこしさむいです。", "Kyou wa tenki ga ii desu ga, sukoshi samui desu.", "আজ আবহাওয়া ভালো, কিন্তু একটু ঠান্ডা।", "কিয়োও ওয়া তেনকি গা ইই দেসু গা, সুকোশি সামুই দেস।"),
            make_item("jp-p4-l14-003", "この カメラは たかいです。", "このかめらはたかいです。", "Kono kamera wa takai desu.", "এই ক্যামেরাটি দামি।", "কোনো কামেরা ওয়া তাকাই দেস।"),
            make_item("jp-p4-l14-004", "にほんごの べんきょうは おもしろいです。", "にほんごのべんきょうはおもしろいです。", "Nihongo no benkyou wa omoshiroi desu.", "জাপানি ভাষা শেখা আনন্দদায়ক/মজার।", "নিহঙ্গো নো বেনকিওও ওয়া ওমোশিরোই দেস।")
        ]
    },
    {
        "id": "jp-foundations-l15",
        "order": 2,
        "title_bn": "い-বিশেষণের না-বোধক রূপ (i-Adjectives: Negative 〜くないです)",
        "title_target": "Negative i-Adjectives (~kunai desu)",
        "intro_bn": "i-Adjective না-বোধক করতে শেষের 'い' উঠে 'くないです' (kunai desu) বসে। যেমন: おいしい -> おいしくないです।",
        "structure": ["Noun + は + Adjective Stem + くないです"],
        "items": [
            make_item("jp-p4-l15-001", "この りょうりは あまり おいしくないです。", "このりょうりはあまりおいしくないです。", "Kono ryouri wa amari oishikunai desu.", "এই খাবারটি তেমন সুস্বাদু নয়।", "কোনো রিওওরি ওয়া আমারি ওইশিকুনাই দেস।", polarity="negative"),
            make_item("jp-p4-l15-002", "この とけいは たかくないです。とても やすいです。", "このとけいはたかくないです。とてもやすいです。", "Kono tokei wa takakunai desu. Totemo yasui desu.", "এই ঘড়িটি দামি নয়। খুব সস্তা।", "কোনো তোকেই ওয়া তাকাকুনাই দেস। তোতেমো ইয়াসুই দেস।", polarity="negative"),
            make_item("jp-p4-l15-003", "きょうは さむくないです。あたたかいです。", "きょうわさむくないです。あたたかいです。", "Kyou wa samukunai desu. Atatakai desu.", "আজ ঠান্ডা নয়। আরামদায়ক উষ্ণ।", "কিয়োও ওয়া সামুকুনাই দেস। আতাকেকাই দেস।", polarity="negative")
        ]
    },
    {
        "id": "jp-foundations-l16",
        "order": 3,
        "title_bn": "な-বিশেষণ দিয়ে গুণাগুণ (na-Adjectives: Present Affirmative)",
        "title_target": "Describing Qualities with na-Adjectives (Shizuka, Kirei, Genki)",
        "intro_bn": "যেসব বিশেষণ সরাসরি বিশেষ্যের পূর্বে বসলে 'な' গ্রহণ করে, তাদের na-Adjective বলে। বাক্যের শেষে বসলে '〜です' বসে।",
        "structure": ["Noun + は + na-Adjective + です"],
        "items": [
            make_item("jp-p4-l16-001", "この まちは とても しずかです。", "このまちはとてもしずかです。", "Kono machi wa totemo shizuka desu.", "এই শহরটি খুব শান্ত।", "কোনো মাচি ওয়া তোতেমো শিজুকা দেস।"),
            make_item("jp-p4-l16-002", "さくらのはなは とても きれいです。", "さくらのはなはとてもきれいです。", "Sakura no hana wa totemo kirei desu.", "চেরি ফুল খুব সুন্দর।", "সাকুরা নো হানা ওয়া তোতেমো কিরেই দেস।"),
            make_item("jp-p4-l16-003", "たなかさんは いつも げんきです。", "たなかさんはいつもげんきです。", "Tanaka-san wa itsumo genki desu.", "তানাকা বাবু সবসময় চনমনে ও সুস্থ।", "তানাকা-সান ওয়া ইতসুমো গেনকি দেস।"),
            make_item("jp-p4-l16-004", "ふじさんは にほんで ゆうめいです。", "ふじさんはにほんでゆうめいです。", "Fuji-san wa nihon de yuumei desu.", "ফুজি পর্বত জাপানে বিখ্যাত।", "ফুজি-সান ওয়া নিহোন দে ইউউমেই দেস।")
        ]
    },
    {
        "id": "jp-foundations-l17",
        "order": 4,
        "title_bn": "な-বিশেষণের না-বোধক রূপ (na-Adjectives: Negative 〜じゃありません)",
        "title_target": "Negative na-Adjectives (~dewa / ja arimasen)",
        "intro_bn": "na-Adjective না-বোধক করতে বিশেষণের পরে 'ではありません' বা 'じゃありません' বসে।",
        "structure": ["Noun + は + na-Adjective + じゃありません"],
        "items": [
            make_item("jp-p4-l17-001", "この へやは しずかじゃ ありません。", "このへやはしずかじゃありません。", "Kono heya wa shizuka ja arimasen.", "এই ঘরটি শান্ত নয় (কোলাহলপূর্ণ)।", "কোনো হেয়া ওয়া শিজুকা জা আরিমাসেন।", polarity="negative"),
            make_item("jp-p4-l17-002", "この まちは あまり にぎやかでは ありません。", "このまちはあまりにぎやかでわありません。", "Kono machi wa amari nigiyaka dewa arimasen.", "এই শহরটি খুব একটা ব্যস্ত বা মুখরিত নয়।", "কোনো মাচি ওয়া আমারি নিগিয়াকা দেবা আরিমাসেন।", polarity="negative"),
            make_item("jp-p4-l17-003", "あしたは ひまじゃ ありません。とても いそがしいです。", "あしたはひまじゃありません。とてもいそがしいです。", "Ashita wa hima ja arimasen. Totemo isogashii desu.", "আগামীকাল অবসর নেই। খুব ব্যস্ত।", "আশিতা ওয়া হিমা জা আরিমাসেন। তোতেমো ইসোগাশিই দেস।", polarity="negative")
        ]
    },
    {
        "id": "jp-foundations-l18",
        "order": 5,
        "title_bn": "৬-রূপান্তর ড্রিল: বিশেষণ ও অনুভূতি (6 Transformations: Adjectives)",
        "title_target": "6 Sentence Transformations: Adjectives & States",
        "intro_bn": "বিশেষণ দিয়ে ৬টি রূপে রূপান্তর করার স্পোকেন ড্রিল।",
        "structure": ["Affirmative (+)", "Negative (-)", "Question (?)", "Negative Q (-?)", "WH-Q", "Alternative Q"],
        "items": [
            make_item("jp-p4-l18-001", "この おちゃは おいしいです。", "このおちゃはおいしいです。", "Kono ocha wa oishii desu.", "১. হ্যাঁ-বোধক: এই চা-টি সুস্বাদু।", "কোনো ওচা ওয়া ওইশিই দেস।", item_type="drill"),
            make_item("jp-p4-l18-002", "この おちゃは おいしくないです。", "このおちゃはおいしくないです。", "Kono ocha wa oishikunai desu.", "২. না-বোধক: এই চা-টি সুস্বাদু নয়।", "কোনো ওচা ওয়া ওইশিকুনাই দেস।", item_type="drill", polarity="negative"),
            make_item("jp-p4-l18-003", "この おちゃは おいしいですか。", "このおちゃはおいしいですか。", "Kono ocha wa oishii desu ka.", "৩. প্রশ্নবোধক: এই চা-টি কি সুস্বাদু?", "কোনো ওচা ওয়া ওইশিই দেসু কা?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-p4-l18-004", "この おちゃは おいしくありませんか。", "このおちゃはおいしくありませんか。", "Kono ocha wa oishiku arimasen ka.", "৪. না-বোধক প্রশ্ন: এই চা-টি কি সুস্বাদু নয়?", "কোনো ওচা ওয়া ওইশিকু আরিমাসেন কা?", item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-p4-l18-005", "この おちゃの あじは どうですか。とても おいしいです。", "このおちゃのあじはどうですか。とてもおいしいです。", "Kono ocha no aji wa dou desu ka. Totemo oishii desu.", "৫. WH-প্রশ্ন: এই চায়ের স্বাদ কেমন? খুব সুস্বাদু।", "কোনো ওচা নো আজি ওয়া দোও দেসু কা? তোতেমো ওইশিই দেস।", item_type="drill", sentence_type="wh_question"),
            make_item("jp-p4-l18-006", "この おちゃは あついですか、つめたいですか。", "このおちゃはあついですか、つめたいですか。", "Kono ocha wa atsui desu ka, tsumetai desu ka.", "৬. বিকল্প প্রশ্ন: এই চা-টি কি গরম, নাকি ঠান্ডা?", "কোনো ওচা ওয়া আতসুই দেসু কা, সুমেতাই দেসু কা?", item_type="drill", sentence_type="alternative_question")
        ]
    }
]
parts.append({
    "id": "jp-foundations-p4",
    "order": 4,
    "level": "A1",
    "title_bn": "বৈশিষ্ট্য, অনুভূতি ও অবস্থা (い-Adjectives ও な-Adjectives)",
    "title_target": "Personality, Feelings & Adjectives (i- & na-)",
    "lessons": p4_lessons
})

# -------------------------------------------------------------
# Part 5: Location & Existence (あります / います)
# -------------------------------------------------------------
p5_lessons = [
    {
        "id": "jp-foundations-l19",
        "order": 1,
        "title_bn": "নির্জীব বস্তু ও উদ্ভিদের অবস্থান (Inanimate: あります)",
        "title_target": "Existence of Inanimate Objects (Place ni Noun ga arimasu)",
        "intro_bn": "নির্জীব বস্তু, বই, গাড়ি, বাড়ি বা উদ্ভিদের অবস্থান বোঝাতে 'あります' (arimasu) বসে। স্থান বোঝাতে 'に' পার্টিকেল বসে।",
        "structure": ["Place に + Inanimate Noun が + あります"],
        "items": [
            make_item("jp-p5-l19-001", "つくえの うえに ほんが あります。", "つくえのうえにほんがあります。", "Tsukue no ue ni hon ga arimasu.", "টেবিলের ওপর বই আছে।", "সুকুয়ে নো উয়ে নি হোন গা আরিমাসু।"),
            make_item("jp-p5-l19-002", "へやの なかに テレビが あります。", "へやのなかにてれびがあります。", "Heya no naka ni terebi ga arimasu.", "ঘরের ভেতরে টেলিভিশন আছে।", "হেয়া নো নাকা নি তেরেবি গা আরিমাসু।"),
            make_item("jp-p5-l19-003", "えきの まえに ポストが あります。", "えきのまえにぽすとがあります。", "Eki no mae ni posuto ga arimasu.", "স্টেশনের সামনে ডাকবাক্স আছে।", "একি নো মায়ে নি পোসুতো গা আরিমাসু।"),
            make_item("jp-p5-l19-004", "れいぞうこの なかに なにも ありません。", "れいぞうこのなかになにもありません。", "Reizouko no naka ni nani mo arimasen.", "ফ্রিজের ভেতর কিছুই নেই।", "রেইজোওকো নো নাকা নি নানি মো আরিমাসেন।", polarity="negative")
        ]
    },
    {
        "id": "jp-foundations-l20",
        "order": 2,
        "title_bn": "সজীব প্রাণী ও মানুষের অবস্থান (Animate: います)",
        "title_target": "Existence of Living Beings (Place ni Person/Animal ga imasu)",
        "intro_bn": "মানুষ ও জীবজন্তুর অস্তিত্ব প্রকাশ করতে 'います' (imasu) ব্যবহৃত হয়। না-বোধক রূপ 'いません' (imasen)।",
        "structure": ["Place に + Living Being が + います"],
        "items": [
            make_item("jp-p5-l20-001", "きょうしつに たなかせんせいが います。", "きょうしつにたなかせんせいがいます。", "Kyoushitsu ni Tanaka-sensei ga imasu.", "ক্লাসরুমে তানাকা শিক্ষক আছেন।", "কিয়োওশিতসু নি তানাকা-সেনসেই গা ইমাসু।"),
            make_item("jp-p5-l20-002", "にわに かわいい ねこが います。", "にわにかわいいねこがいます。", "Niwa ni kawaii neko ga imasu.", "বাগানে একটি সুন্দর বিড়াল আছে।", "নিওয়া নি কাওয়াইই নেকো গা ইমাসু।"),
            make_item("jp-p5-l20-003", "じむしょに だれが いますか。だれも いません。", "じむしょにだれがいますか。だれもいません。", "Jimusho ni dare ga imasu ka. Dare mo imasen.", "অফিসে কে আছে? কেউ নেই।", "জিমুশো নি দারে গা ইমাসু কা? দারে মো ইমাসেন।", polarity="negative")
        ]
    },
    {
        "id": "jp-foundations-l21",
        "order": 3,
        "title_bn": "মালিকানা ও অধিকার বোঝাতে অস্তিত্বের ব্যবহার (Possession)",
        "title_target": "Possession & Relationships (Watashi wa ... ga arimasu / imasu)",
        "intro_bn": "নিজের কাছে কোনো গাড়ি, টাকা বা সময় আছে বোঝাতে 'あります', এবং ভাইবোন বা সন্তান আছে বোঝাতে 'います' ব্যবহৃত হয়।",
        "structure": ["わたしは + Noun が + あります / います"],
        "items": [
            make_item("jp-p5-l21-001", "わたしは くるまが あります。", "わたしはくるまがあります。", "Watashi wa kuruma ga arimasu.", "আমার একটি গাড়ি আছে।", "ওয়াতাশি ওয়া কুরুমা গা আরিমাসু।"),
            make_item("jp-p5-l21-002", "きょうは じかんが ありません。", "きょうはじかんがありません。", "Kyou wa jikan ga arimasen.", "আজ আমার সময় নেই।", "কিয়োও ওয়া জিকান গা আরিমাসেন।", polarity="negative"),
            make_item("jp-p5-l21-003", "わたしは きょうだいが ふたり います。", "わたしはきょうだいがふたりいます。", "Watashi wa kyoudai ga futari imasu.", "আমার দুইজন ভাইবোন আছে।", "ওয়াতাশি ওয়া কিওওদাই গা ফুতPopup ইমাসু।")
        ]
    },
    {
        "id": "jp-foundations-l22",
        "order": 4,
        "title_bn": "অবস্থান ও প্রিপজিশন (Prepositions: 上, 下, 前, 後ろ, 中, 隣)",
        "title_target": "Spatial Prepositions (Ue, Shita, Mae, Ushiro, Naka, Tonari)",
        "intro_bn": "স্থান নির্দেশক শব্দ: 上 (উয়ে - ওপরে), 下 (শিতা - নিচে), 前 (মায়ে - সামনে), 後ろ (উশিরো - পেছনে), 中 (নাকা - ভেতরে), 隣 (তোরারি - পাশে)।",
        "structure": ["Noun 1 の + Preposition + に + Noun 2 が あります / います"],
        "items": [
            make_item("jp-p5-l22-001", "いぬは つくえの したに います。", "いぬはつくえのしたにいます。", "Inu wa tsukue no shita ni imasu.", "কুকুরটি টেবিলের নিচে আছে।", "ইনু ওয়া সুকুয়ে নো শিতা নি ইমাসু।"),
            make_item("jp-p5-l22-002", "ぎんこうは びょういんの となりに あります。", "ぎんこうはびょういんのとなりにあります。", "Ginkou wa byouin no tonari ni arimasu.", "ব্যাংকটি হাসপাতালের পাশে অবস্থিত।", "গিনকোও ওয়া বিয়োওইন নো তোরারি নি আরিমাসু।"),
            make_item("jp-p5-l22-003", "くるまの うしろに こどもが います。", "くるまのうしろにこどもがいます。", "Kuruma no ushiro ni kodomo ga imasu.", "গাড়ির পেছনে একটি শিশু আছে।", "কুরুমা নো উশিরো নি কোদোমো গা ইমাসু।")
        ]
    },
    {
        "id": "jp-foundations-l23",
        "order": 5,
        "title_bn": "৬-রূপান্তর ড্রিল: অস্তিত্ব ও অবস্থান (6 Transformations: Existence)",
        "title_target": "6 Sentence Transformations: Existence (Arimasu / Imasu)",
        "intro_bn": "অস্তিত্ব প্রকাশ দিয়ে ৬টি রূপে রূপান্তরের স্পোকেন ড্রিল।",
        "structure": ["Affirmative (+)", "Negative (-)", "Question (?)", "Negative Q (-?)", "WH-Q", "Alternative Q"],
        "items": [
            make_item("jp-p5-l23-001", "へやに ねこが います。", "へやにねこがいます。", "Heya ni neko ga imasu.", "১. হ্যাঁ-বোধক: ঘরে বিড়াল আছে।", "হেয়া নি নেকো গা ইমাসু।", item_type="drill"),
            make_item("jp-p5-l23-002", "へやに ねこは いません。", "へやにねこわいません。", "Heya ni neko wa imasen.", "২. না-বোধক: ঘরে বিড়াল নেই।", "হেয়া নি নেকো ওয়া ইমাসেন।", item_type="drill", polarity="negative"),
            make_item("jp-p5-l23-003", "へやに ねこが いますか。", "へやにねこがいますか。", "Heya ni neko ga imasu ka.", "৩. প্রশ্নবোধক: ঘরে কি বিড়াল আছে?", "হেয়া নি নেকো গা ইমাসু কা?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-p5-l23-004", "へやに ねこは いませんか。", "へやにねこわいませんか。", "Heya ni neko wa imasen ka.", "৪. না-বোধক প্রশ্ন: ঘরে কি বিড়াল নেই?", "হেয়া নি নেকো ওয়া ইমাসেন কা?", item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-p5-l23-005", "へやに なにが いますか。ねこが います。", "へやになにがいますか。ねこがいます。", "Heya ni nani ga imasu ka. Neko ga imasu.", "৫. WH-প্রশ্ন: ঘরে কী আছে? বিড়াল আছে।", "হেয়া নি নানি গা ইমাসু কা? নেকো গা ইমাসু।", item_type="drill", sentence_type="wh_question"),
            make_item("jp-p5-l23-006", "へやに いるのは ねこですか、いぬですか。", "へやにいるのわねこですか、いぬですか。", "Heya ni iru no wa neko desu ka, inu desu ka.", "৬. বিকল্প প্রশ্ন: ঘরে কি বিড়াল আছে, নাকি কুকুর?", "হেয়া নি ইরু নো ওয়া নেকো দেসু কা, ইনু দেসু কা?", item_type="drill", sentence_type="alternative_question")
        ]
    }
]
parts.append({
    "id": "jp-foundations-p5",
    "order": 5,
    "level": "A1",
    "title_bn": "অবস্থান ও অস্তিত্ব (あります বনাম います)",
    "title_target": "Location, Existence & Prepositions (Arimasu / Imasu)",
    "lessons": p5_lessons
})

# -------------------------------------------------------------
# Part 6: Daily Habits & Routines (〜ます / 〜ません)
# -------------------------------------------------------------
p6_lessons = [
    {
        "id": "jp-foundations-l24",
        "order": 1,
        "title_bn": "দৈনন্দিন রুটিন ও সময় (Time に Verb ます: ７時に起きます)",
        "title_target": "Daily Routines & Specific Time (Time ni Verb-masu)",
        "intro_bn": "নির্দিষ্ট সময়ে কোনো কাজ করি বোঝাতে সময়ের পর 'に' (ni) বসে এবং ক্রিয়াপদের মার্জিত বর্তমান রূপ '〜ます' (masu) বসে।",
        "structure": ["Time に + Verb-ます (Everyday Habitual Actions)"],
        "items": [
            make_item("jp-p6-l24-001", "わたしは まいにち あさ ６じに おきます。", "わたしはまいにちあさろくじにおきます。", "Watashi wa mainichi asa rokuji ni okimasu.", "আমি প্রতিদিন সকাল ৬টায় ঘুম থেকে উঠি।", "ওয়াতাশি ওয়া মাইনিচি আসা রোকুজি নি ওকিমাসু।"),
            make_item("jp-p6-l24-002", "よる １１じに ねます。", "よるじゅういちじにねます。", "Yoru juuichiji ni nemasu.", "রাতে ১১টায় ঘুমাই।", "ইয়োরু জুউইচিজি নি নেমাসু।"),
            make_item("jp-p6-l24-003", "なんじに あさごはんを たべますか。７じはんに たべます。", "なんじにあさごはんをたべますか。しちじはんにはたべます。", "Nanji ni asagohan o tabemasu ka. Shichiji han ni tabemasu.", "কয়টায় সকালের নাস্তা খান? সাড়ে ৭টায় খাই।", "নানজি নি আসাগোহান ও তাবেমাসু কা? শিচিজি হান নি তাবেমাসু।")
        ]
    },
    {
        "id": "jp-foundations-l25",
        "order": 2,
        "title_bn": "গন্তব্য ও যাতায়াত (Place へ/に 行きます / 来ます / 帰ります)",
        "title_target": "Movement & Direction (Ikimasu, Kimasu, Kaerimasu)",
        "intro_bn": "কোথাও যাওয়া, আসা বা বাড়ি ফেরার ক্ষেত্রে গন্তব্যের পর 'へ' (উচ্চারণ e) বা 'に' (ni) বসে।",
        "structure": ["Place へ / に + いきます (যাই) / きます (আসি) / かえります (ফিরি)"],
        "items": [
            make_item("jp-p6-l25-001", "わたしは がっこうへ いきます。", "わたしはがっこうえいきます。", "Watashi wa gakkou e ikimasu.", "আমি স্কুলে যাই।", "ওয়াতাশি ওয়া গাক্কোও এ ইকিমাসু।"),
            make_item("jp-p6-l25-002", "まいあさ ９じに かいしゃへ きます。", "まいあさくじにかいしゃえきます。", "Maiasa kuji ni kaisha e kimasu.", "প্রতিদিন সকাল ৯টায় অফিসে আসি।", "মাইয়াসা কুজি নি কাইশা এ কিমাসু।"),
            make_item("jp-p6-l25-003", "ゆうがた ６じに うちへ かえります。", "ゆうがたろくじにうちえかえります。", "Yuugata rokuji ni uchi e kaerimasu.", "সন্ধ্যা ৬টায় বাড়ি ফিরি।", "ইউউগাতা রোকুজি নি উচি এ কায়েরিমাসু।")
        ]
    },
    {
        "id": "jp-foundations-l26",
        "order": 3,
        "title_bn": "সরাসরি কর্ম ও ক্রিয়াপদ (Object を 食べます / 飲みます / 読みます)",
        "title_target": "Transitive Verbs & Direct Object Particle を (o)",
        "intro_bn": "যে বস্তুর ওপর কাজটি সম্পন্ন হয় (Direct Object), তার শেষে 'を' (উচ্চারণ o) বসে।",
        "structure": ["Object + を + Verb-ます"],
        "items": [
            make_item("jp-p6-l26-001", "あさごはんを たべます。", "あさごはんをたべます。", "Asagohan o tabemasu.", "সকালের নাস্তা খাই।", "আসাগোহান ও তাবেমাসু।"),
            make_item("jp-p6-l26-002", "みずを のみます。", "みずをのみます。", "Mizu o nomimasu.", "পানি পান করি।", "মিজু ও নোমিমাসু।"),
            make_item("jp-p6-l26-003", "にほんごの ほんを よみます。", "にほんごのほんをよみます。", "Nihongo no hon o yomimasu.", "জাপানি বই পড়ি।", "নিহঙ্গো নো হোন ও ইয়োমিমাসু।"),
            make_item("jp-p6-l26-004", "ともだちに てがみを かきます。", "ともだちにてがみをかきます。", "Tomodachi ni tegami o kakimasu.", "বন্ধুকে চিঠি লিখি।", "তোমোদাচি নি তেগামি ও কাকিমাসু।")
        ]
    },
    {
        "id": "jp-foundations-l27",
        "order": 4,
        "title_bn": "কাজের স্থান ও মাধ্যম (Place で Verb & Tool で Verb)",
        "title_target": "Location of Action & Means/Tools (Particle で - de)",
        "intro_bn": "যে স্থানে কাজটি ঘটে এবং যে মাধ্যমে কাজটি করা হয় (বাস, ট্রেন, কলম), উভয়ের পরে 'で' (de) বসে।",
        "structure": ["Place で + Action Verb / Vehicle/Tool で + Action Verb"],
        "items": [
            make_item("jp-p6-l27-001", "レストランで ひるごはんを たべます。", "れすとらんでひるごはんをたべます。", "Resutoran de hirugohan o tabemasu.", "রেস্তোরাঁয় দুপুরের খাবার খাই।", "রেসুতোরান দে হিরুগোহান ও তাবেমাসু।"),
            make_item("jp-p6-l27-002", "バスで だいがくへ いきます。", "ばすでだいがくえいきます。", "Basu de daigaku e ikimasu.", "বাসে করে বিশ্ববিদ্যালয়ে যাই।", "বাসু দে দাইগাকু এ ইকিমাসু।"),
            make_item("jp-p6-l27-003", "はしで ごはんを たべます。", "はしでごはんをたべます。", "Hashi de gohan o tabemasu.", "চপস্টিক দিয়ে ভাত খাই।", "হাশি দে গোহান ও তাবেমাসু।"),
            make_item("jp-p6-l27-004", "にほんごで レポートを かきます。", "にほんごでれぽーとをかきます。", "Nihongo de repooto o kakimasu.", "জাপানি ভাষায় রিপোর্ট লিখি।", "নিহঙ্গো দে রেপোওতো ও কাকিমাসু।")
        ]
    },
    {
        "id": "jp-foundations-l28",
        "order": 5,
        "title_bn": "অভ্যাসের না-বোধক রূপ (Habitual Negative: 〜ません)",
        "title_target": "Habitual Negative (Verb-masen)",
        "intro_bn": "সাধারণত কোনো কাজ করি না বোঝাতে ক্রিয়ার শেষে '〜ません' (masen) বসে।",
        "structure": ["Subject + は + Object + を + Verb-ません"],
        "items": [
            make_item("jp-p6-l28-001", "わたしは おさけを のみません。", "わたしはおさけをのみません。", "Watashi wa osake o nomimasen.", "আমি মদ পান করি না।", "ওয়াতাশি ওয়া ওসাকে ও নোমিমাসেন।", polarity="negative"),
            make_item("jp-p6-l28-002", "あさ、コーヒーを のみません。おちゃを のみます。", "あさ、こーひーをのみません。おちゃをのみます。", "Asa, koohii o nomimasen. Ocha o nomimasu.", "সকালে কফি পান করি না। চা পান করি।", "আসা, কোওহিই ও নোমিমাসেন। ওচা ও নোমিমাসু।", polarity="negative"),
            make_item("jp-p6-l28-003", "タバコを すいません。", "たばこをすいません。", "Tabako o suimasen.", "ধূমপান করি না।", "তাবাকো ও সুইমাসেন।", polarity="negative")
        ]
    },
    {
        "id": "jp-foundations-l29",
        "order": 6,
        "title_bn": "আমন্ত্রণ ও প্রস্তাব (Invitations: 〜ませんか / 〜ましょう)",
        "title_target": "Invitations & Suggestions (~masen ka / ~mashou)",
        "intro_bn": "কাউকে ভদ্রভাবে আমন্ত্রণ জানাতে '〜ませんか' (Why don't we...?) এবং একসাথে করতে '〜ましょう' (Let's...) বসে।",
        "structure": ["Verb-ませんか (Shall we / Would you like to...?)", "Verb-ましょう (Let's do...!)"],
        "items": [
            make_item("jp-p6-l29-001", "いっしょに おちゃを のみませんか。ええ、のみましょう。", "いっしょにおちゃをのみませんか。ええ、のみましょう。", "Issho ni ocha o nomimasen ka. Ee, nomimashou.", "একসাথে চা খাবেন কি? হ্যাঁ, চলুন খাই।", "ইশ্শো নি ওচা ও নোমিমাসেন কা? এয়ে, নোমিমাশোও।"),
            make_item("jp-p6-l29-002", "こんばん えいがを みませんか。いいですね。みましょう。", "こんばんえいがをみませんか。いいですね。みましょう。", "Konban eiga o mimasen ka. Ii desu ne. Mimashou.", "আজ রাতে সিনেমা দেখবেন নাকি? দারুণ হবে, চলুন দেখি।", "কোনবান এইগা ও মিমাসেন কা? ইই দেসু নে। মিমাশোও।"),
            make_item("jp-p6-l29-003", "ちょっと やすみましょう。", "ちょっとやすみましょう。", "Chotto yasumimashou.", "চলুন একটু বিশ্রাম নিই।", "চোত্তো ইয়াসুমিমাশোও।")
        ]
    }
]
parts.append({
    "id": "jp-foundations-p6",
    "order": 6,
    "level": "A1",
    "title_bn": "দৈনন্দিন অভ্যাস ও সাধারণ কাজ (〜ます / 〜ません - Present Simple)",
    "title_target": "Daily Actions, Routines & Habits (Verb-masu / masen)",
    "lessons": p6_lessons
})

# -------------------------------------------------------------
# Part 7: 6-Sentence Action Transformations Drills
# -------------------------------------------------------------
p7_lessons = [
    {
        "id": "jp-foundations-l30",
        "order": 1,
        "title_bn": "৬-রূপান্তর ড্রিল: খাওয়া ও পান করা (食べます / 飲みます)",
        "title_target": "6 Transformations: Eating & Drinking (Tabemasu / Nomimasu)",
        "intro_bn": "দৈনন্দিন আহার সংক্রান্ত ক্রিয়াপদের ৬টি স্পোকেন রূপান্তর ড্রিল।",
        "structure": ["Affirmative (+)", "Negative (-)", "Question (?)", "Negative Q (-?)", "WH-Q", "Alternative Q"],
        "items": [
            make_item("jp-p7-l30-001", "ラヒムさんは あさごはんを たべます。", "らひむさんはあさごはんをたべます。", "Rahimu-san wa asagohan o tabemasu.", "১. হ্যাঁ-বোধক: রহিম সকালের নাস্তা খায়।", "রাহিমু-সান ওয়া আসাগোহান ও তাবেমাসু।", item_type="drill"),
            make_item("jp-p7-l30-002", "ラヒムさんは あさごはんを たべません。", "らひむさんはあさごはんをたべません。", "Rahimu-san wa asagohan o tabemasen.", "২. না-বোধক: রহিম সকালের নাস্তা খায় না।", "রাহিমু-সান ওয়া আসাগোহান ও তাবেমাসেন।", item_type="drill", polarity="negative"),
            make_item("jp-p7-l30-003", "ラヒムさんは あさごはんを たべますか。", "らひむさんはあさごはんをたべますか。", "Rahimu-san wa asagohan o tabemasu ka.", "৩. প্রশ্নবোধক: রহিম কি সকালের নাস্তা খায়?", "রাহিমু-সান ওয়া আসাগোহান ও তাবেমাসু কা?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-p7-l30-004", "ラヒムさんは あさごはんを たべませんか。", "らひむさんはあさごはんをたべませんか。", "Rahimu-san wa asagohan o tabemasen ka.", "৪. না-বোধক প্রশ্ন: রহিম কি সকালের নাস্তা খায় না?", "রাহিমু-সান ওয়া আসাগোহান ও তাবেমাসেন কা?", item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-p7-l30-005", "ラヒムさんは あさごはんに なにを たべますか。パンを たべます。", "らひむさんはあさごはんになにをたべますか。ぱんをたべます。", "Rahimu-san wa asagohan ni nani o tabemasu ka. Pan o tabemasu.", "৫. WH-প্রশ্ন: রহিম নাস্তায় কী খায়? রুটি খায়।", "রাহিমু-সান ওয়া আসাগোহান নি নানি ও তাবেমাসু কা? পান ও তাবেমাসু।", item_type="drill", sentence_type="wh_question"),
            make_item("jp-p7-l30-006", "パンを たべますか、ごはんを たべますか。", "ぱんをたべますか、ごはんをたべますか。", "Pan o tabemasu ka, gohan o tabemasu ka.", "৬. বিকল্প প্রশ্ন: রুটি খাবেন, নাকি ভাত খাবেন?", "পান ও তাবেমাসু কা, গোহান ও তাবেমাসু কা?", item_type="drill", sentence_type="alternative_question")
        ]
    },
    {
        "id": "jp-foundations-l31",
        "order": 2,
        "title_bn": "৬-রূপান্তর ড্রিল: যাওয়া ও আসা (行きます / 来ます)",
        "title_target": "6 Transformations: Movement (Ikimasu / Kimasu)",
        "intro_bn": "যাতায়াত ও গন্তব্য সংক্রান্ত ক্রিয়াপদের ৬টি স্পোকেন রূপান্তর ড্রিল।",
        "structure": ["Affirmative (+)", "Negative (-)", "Question (?)", "Negative Q (-?)", "WH-Q", "Alternative Q"],
        "items": [
            make_item("jp-p7-l31-001", "たなかさんは とうきょうへ いきます。", "たなかさんはとうきょうえいきます。", "Tanaka-san wa Toukyou e ikimasu.", "১. হ্যাঁ-বোধক: তানাকা বাবু টোকিও যান।", "তানাকা-সান ওয়া তোকিও এ ইকিমাসু।", item_type="drill"),
            make_item("jp-p7-l31-002", "たなかさんは とうきょうへ いきません。", "たなかさんはとうきょうえいきません。", "Tanaka-san wa Toukyou e ikimasen.", "২. না-বোধক: তানাকা বাবু টোকিও যান না।", "তানাকা-সান ওয়া তোকিও এ ইকিমাসেন।", item_type="drill", polarity="negative"),
            make_item("jp-p7-l31-003", "たなかさんは とうきょうへ いきますか。", "たなかさんはとうきょうえいきますか。", "Tanaka-san wa Toukyou e ikimasu ka.", "৩. প্রশ্নবোধক: তানাকা বাবু কি টোকিও যান?", "তানাকা-সান ওয়া তোকিও এ ইকিমাসু কা?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-p7-l31-004", "たなかさんは とうきょうへ いきませんか。", "たなかさんはとうきょうえいきませんか。", "Tanaka-san wa Toukyou e ikimasen ka.", "৪. না-বোধক প্রশ্ন: তানাকা বাবু কি টোকিও যান না?", "তানাকা-সান ওয়া তোকিও এ ইকিমাসেন কা?", item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-p7-l31-005", "たなかさんは どこへ いきますか。とうきょうへ いきます。", "たなかさんはどこえいきますか。とうきょうえいきます。", "Tanaka-san wa doko e ikimasu ka. Toukyou e ikimasu.", "৫. WH-প্রশ্ন: তানাকা বাবু কোথায় যান? টোকিও যান।", "তানাকা-সান ওয়া দোকো এ ইকিমাসু কা? তোকিও এ ইকিমাসু।", item_type="drill", sentence_type="wh_question"),
            make_item("jp-p7-l31-006", "でんしゃで いきますか、バスで いきますか。", "でんしゃでいきますか、ばすでいきますか。", "Densha de ikimasu ka, basu de ikimasu ka.", "৬. বিকল্প প্রশ্ন: ট্রেনে যাবেন, নাকি বাসে?", "দেনশা দে ইকিমাসু কা, বাসু দে ইকিমাসু কা?", item_type="drill", sentence_type="alternative_question")
        ]
    },
    {
        "id": "jp-foundations-l32",
        "order": 3,
        "title_bn": "৬-রূপান্তর ড্রিল: অধ্যয়ন ও কাজ (勉強します / 働きます)",
        "title_target": "6 Transformations: Study & Work (Benkyou shimasu / Hatarakimasu)",
        "intro_bn": "পড়াশোনা ও কর্মসংক্রান্ত ক্রিয়াপদের ৬টি স্পোকেন রূপান্তর ড্রিল।",
        "structure": ["Affirmative (+)", "Negative (-)", "Question (?)", "Negative Q (-?)", "WH-Q", "Alternative Q"],
        "items": [
            make_item("jp-p7-l32-001", "マリアさんは にほんごを べんきょうします。", "まりあさんはにほんごをべんきょうします。", "Maria-san wa nihongo o benkyou shimasu.", "১. হ্যাঁ-বোধক: মারিয়া জাপানি ভাষা শেখে।", "মারিয়া-সান ওয়া নিহঙ্গো ও বেনকিওও শিমাসু।", item_type="drill"),
            make_item("jp-p7-l32-002", "マリアさんは にほんごを べんきょうしません。", "まりあさんはにほんごをべんきょうしません。", "Maria-san wa nihongo o benkyou shimasen.", "২. না-বোধক: মারিয়া জাপানি ভাষা শেখে না।", "মারিয়া-সান ওয়া নিহঙ্গো ও বেনকিওও শিমাসেন।", item_type="drill", polarity="negative"),
            make_item("jp-p7-l32-003", "マリアさんは にほんごを べんきょうしますか。", "まりあさんはにほんごをべんきょうしますか。", "Maria-san wa nihongo o benkyou shimasu ka.", "৩. প্রশ্নবোধক: মারিয়া কি জাপানি ভাষা শেখে?", "মারিয়া-সান ওয়া নিহঙ্গো ও বেনকিওও শিমাসু কা?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-p7-l32-004", "マリアさんは にほんごを べんきょうしませんか。", "まりあさんはにほんごをべんきょうしませんか。", "Maria-san wa nihongo o benkyou shimasen ka.", "৪. না-বোধক প্রশ্ন: মারিয়া কি জাপানি ভাষা শেখে না?", "মারিয়া-সান ওয়া নিহঙ্গো ও বেনকিওও শিমাসেন কা?", item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-p7-l32-005", "マリアさんは どこで べんきょうしますか。としょかんで べんきょうします。", "まりあさんはどこでべんきょうしますか。としょかんでべんきょうします。", "Maria-san wa doko de benkyou shimasu ka. Toshokan de benkyou shimasu.", "৫. WH-প্রশ্ন: মারিয়া কোথায় পড়াশোনা করে? লাইব্রেরিতে করে।", "মারিয়া-সান ওয়া দোকো দে বেনকিওও শিমাসু কা? তোশোখান দে বেনকিওও শিমাসু।", item_type="drill", sentence_type="wh_question"),
            make_item("jp-p7-l32-006", "にほんごを べんきょうしますか、えいごを べんきょうしますか。", "にほんごをべんきょうしますか、えいごをべんきょうしますか。", "Nihongo o benkyou shimasu ka, eigo o benkyou shimasu ka.", "৬. বিকল্প প্রশ্ন: জাপানি ভাষা পড়েন, নাকি ইংরেজি পড়েন?", "নিহঙ্গো ও বেনকিওও শিমাসু কা, এইগো ও বেনকিওও শিমাসু কা?", item_type="drill", sentence_type="alternative_question")
        ]
    }
]
parts.append({
    "id": "jp-foundations-p7",
    "order": 7,
    "level": "A1",
    "title_bn": "৬-রূপান্তর মাস্টার স্পোকেন ড্রিল (6 Sentence Transformations: Action Verbs)",
    "title_target": "6-Sentence Transformation Drills (Action Verbs)",
    "lessons": p7_lessons
})

# -------------------------------------------------------------
# Part 8: 10 Essential WH-Questions & Answers
# -------------------------------------------------------------
wh_qa_list = [
    ("jp-foundations-l33", 1, "কী? — '何' (Nan / Nani Q&A)", "What? (Nan / Nani)", "সবার আগে কোনো বস্তু বা কাজের নাম জানতে 何 (nan/nani) দিয়ে প্রশ্ন করা হয়।",
     [make_item("jp-p8-l33-001", "これは なんですか。これは にほんの おちゃです。", "これはなんですか。これはにほんのおちゃです。", "Kore wa nan desu ka. Kore wa nihon no ocha desu.", "এটি কী? এটি জাপানি চা।", "কোরে ওয়া নান দেসু কা? কোরে ওয়া নিহোন নো ওচা দেস।"),
      make_item("jp-p8-l33-002", "なにを のみますか。みずを のみます。", "なにをのみますか。みずをのみます。", "Nani o nomimasu ka. Mizu o nomimasu.", "কী পান করবেন? পানি পান করব।", "নানি ও নোমিমাসু কা? মিজু ও নোমিমাসু।")]),

    ("jp-foundations-l34", 2, "কে / কার? — '誰 / 誰の' (Dare / Dare no Q&A)", "Who / Whose? (Dare / Dare no)", "ব্যক্তি জানতে 誰 (dare) এবং মালিকানা জানতে 誰の (dare no) বসে।",
     [make_item("jp-p8-l34-001", "あのかたは だれですか。たなかせんせいです。", "あのかたわだれですか。たなかせんせいです。", "Ano kata wa dare desu ka. Tanaka-sensei desu.", "ওই ভদ্রলোক কে? তানাকা শিক্ষক।", "আনো কাতা ওয়া দারে দেসু কা? তানাকা-সেনসেই দেস।"),
      make_item("jp-p8-l34-002", "これは だれの かばんですか。わたしのです。", "これはだれのかばんですか。わたしのです。", "Kore wa dare no kaban desu ka. Watashi no desu.", "এটি কার ব্যাগ? আমার ব্যাগ।", "কোরে ওয়া দারে নো কাবান দেসু কা? ওয়াতাশি নো দেস।")]),

    ("jp-foundations-l35", 3, "কোথায়? — 'どこ' (Doko Q&A)", "Where? (Doko)", "স্থান বা অবস্থান জানতে どこ (doko) বসে।",
     [make_item("jp-p8-l35-001", "えきは どこですか。あそこです。", "えきはどこですか。あそこです。", "Eki wa doko desu ka. Asoko desu.", "স্টেশন কোথায়? ওখানে।", "একি ওয়া দোকো দেসু কা? আসোকো দেস।"),
      make_item("jp-p8-l35-002", "どこで ひるごはんを たべますか。しょくどうで たべます。", "どこでひるごはんをたべますか。しょくどうでたべます。", "Doko de hirugohan o tabemasu ka. Shokudou de tabemasu.", "কোথায় দুপুরের খাবার খাবেন? ক্যাফেটেরিয়ায় খাব।", "দোকো দে হিরুগোহান ও তাবেমাসু কা? শোকুদোও দে তাবেমাসু।")]),

    ("jp-foundations-l36", 4, "কখন? — 'いつ' (Itsu Q&A)", "When? (Itsu)", "সময় বা দিনক্ষণ জানতে いつ (itsu) ব্যবহৃত হয়। এর পর に বসে না।",
     [make_item("jp-p8-l36-001", "いつ にほんへ いきますか。らいげつ いきます。", "いつにほんえいきますか。らいげついきます。", "Itsu nihon e ikimasu ka. Raigetsu ikimasu.", "কখন জাপান যাবেন? আগামী মাসে যাব।", "ইতসু নিহোন এ ইকিমাসু কা? রাইগেতসু ইকিমাসু।"),
      make_item("jp-p8-l36-002", "たんじょうびは いつですか。５がつ １０にちです。", "たんじょうびはいつですか。ごがつとおかです。", "Tanjoubi wa itsu desu ka. Gogatsu tooka desu.", "জন্মদিন কবে? ১০ই মে।", "তানজোওবি ওয়া ইতসু দেসু কা? গোগাতসু তোওকা দেস।")]),

    ("jp-foundations-l37", 5, "কেন? — 'なぜ / どうして' (Naze / Doushite Q&A)", "Why? (Naze / Doushite)", "কারণ জানতে なぜ বা どうして বসে, উত্তরের শেষে 〜から (kara - কারণ) বসে।",
     [make_item("jp-p8-l37-001", "どうして にほんごを べんきょうしますか。にほんへ いきますから。", "どうしてにほんごをべんきょうしますか。にほんえいきますから。", "Doushite nihongo o benkyou shimasu ka. Nihon e ikimasu kara.", "কেন জাপানি ভাষা শিখছেন? কারণ জাপানে যাব।", "দোওশিতে নিহঙ্গো ও বেনকিওও শিমাসু কা? নিহোন এ ইকিমাসু কারা।")]),

    ("jp-foundations-l38", 6, "কীভাবে / কেমন? — 'どう / どうやって' (Dou / Dou yatte Q&A)", "How / By what means? (Dou / Dou yatte)", "কেমন জানতে どう এবং যাতায়াতের মাধ্যম জানতে どうやって বসে।",
     [make_item("jp-p8-l38-001", "にほんの せいかつは どうですか。とても おもしろいです。", "にほんのせいかつはどうですか。とてもおもしろいです。", "Nihon no seikatsu wa dou desu ka. Totemo omoshiroi desu.", "জাপানের জীবনযাত্রা কেমন? খুব মজার।", "নিহোন নো সেইকাতসু ওয়া দোও দেসু কা? তোতেমো ওমোশিরোই দেস।"),
      make_item("jp-p8-l38-002", "えきまで どうやって いきますか。あるいて いきます。", "えきまでどうやっていきますか。あるいていきます。", "Eki made dou yatte ikimasu ka. Aruite ikimasu.", "স্টেশন পর্যন্ত কীভাবে যান? হেঁটে যাই।", "একি মাদে দোও ইয়াত্তে ইকিমাসু কা? আরুইতে ইকিমাসু।")]),

    ("jp-foundations-l39", 7, "কতটি? — 'いくつ' (Ikutsu / Quantity Counters)", "How Many? (Ikutsu & General Counters)", "সাধারণ বস্তুর সংখ্যা জানতে いくつ এবং ひとつ, ふたつ... বসে।",
     [make_item("jp-p8-l39-001", "りんごが いくつ ありますか。みっつ あります。", "りんごがいくつありますか。みっつあります。", "Ringo ga ikutsu arimasu ka. Mittsu arimasu.", "আপেল কয়টি আছে? তিনটি আছে।", "রিংগো গা ইকুৎসু আরিমাসু কা? মিত্তসু আরিমাসু।")]),

    ("jp-foundations-l40", 8, "কতজন? — '何人' (Nannin / People Counters)", "How Many People? (Nannin)", "মানুষের সংখ্যা জানতে 何人 (nannin) বসে। একজন ひとり, দুইজন ふたり।",
     [make_item("jp-p8-l40-001", "ごかぞくは なんにんですか。４にんです。", "ごかぞくはなんにんですか。よにんです。", "Gokazoku wa nannin desu ka. Yonin desu.", "আপনার পরিবারে কতজন সদস্য? ৪ জন।", "গোকাজোকু ওয়া নাননিন দেসু কা? ইয়োনিন দেস।")]),

    ("jp-foundations-l41", 9, "কত টাকা? — 'いくら' (Ikura / Price Q&A)", "How Much Money? (Ikura)", "দাম বা মোট মূল্য জানতে いくら বসে।",
     [make_item("jp-p8-l41-001", "ぜんぶで いくらですか。２せん５ひゃくえんです。", "ぜんぶでいくらですか。にせんごひゃくえんです。", "Zenbu de ikura desu ka. Nisen gohyaku-en desu.", "সব মিলিয়ে কত টাকা? ২,৫০০ ইয়েন।", "জেনবু দে ইকুরা দেসু কা? নিসেন গোহিয়াকু-য়েন দেস।")]),

    ("jp-foundations-l42", 10, "কোন দিন / কত তারিখ? — '何曜日 / 何日' (Day & Date Q&A)", "Which Day & Date? (Nanyoubi / Nannichi)", "সপ্তাহের বার ও তারিখ জানতে 何曜日 ও 何日 বসে।",
     [make_item("jp-p8-l42-001", "きょうは なんようびですか。きんようびです。", "きょうはなんようびですか。きんようびです。", "Kyou wa nanyoubi desu ka. Kinyoubi desu.", "আজ কী বার? শুক্রবার।", "কিয়োও ওয়া নানয়োওবি দেসু কা? কিনয়োওবি দেস।"),
      make_item("jp-p8-l42-002", "きょうは なんにちですか。１５にちです。", "きょうはなんにちですか。じゅうごにちです。", "Kyou wa nannichi desu ka. Juugonichi desu.", "আজ কত তারিখ? ১৫ তারিখ।", "কিয়োও ওয়া নাননিচি দেসু কা? জুউগোনিচি দেস।")])
]

p8_lessons = []
for l_id, l_order, l_title_bn, l_title_target, l_intro, l_items in wh_qa_list:
    p8_lessons.append({
        "id": l_id,
        "order": l_order,
        "title_bn": l_title_bn,
        "title_target": l_title_target,
        "intro_bn": l_intro,
        "structure": ["WH-Word + ですか / ますか"],
        "items": l_items
    })

parts.append({
    "id": "jp-foundations-p8",
    "order": 8,
    "level": "A1",
    "title_bn": "প্রয়োজনীয় ১০টি WH-প্রশ্ন ও উত্তর ড্রিল (10 Essential WH-Questions)",
    "title_target": "10 Essential WH-Questions & Answers",
    "lessons": p8_lessons
})

# -------------------------------------------------------------
# Part 9: Continuous Actions & State (〜ています)
# -------------------------------------------------------------
p9_lessons = [
    {
        "id": "jp-foundations-l43",
        "order": 1,
        "title_bn": "বর্তমানে চলতে থাকা কাজ (Present Continuous: Verb-て います)",
        "title_target": "Actions Happening Now (Verb-te imasu)",
        "intro_bn": "বর্তমানে কোনো কাজ এই মুহূর্তে চলছে বোঝাতে ক্রিয়ার তে-ফর্মের (Te-form) সাথে 'います' বসে।",
        "structure": ["Subject + は + いま + Object + を + Verb-て います"],
        "items": [
            make_item("jp-p9-l43-001", "わたしは いま ごはんを たべて います。", "わたしわいまごはんをたべています。", "Watashi wa ima gohan o tabete imasu.", "আমি এখন ভাত খাচ্ছি।", "ওয়াতাশি ওয়া ইমা গোহান ও তাবেতে ইমাসু।"),
            make_item("jp-p9-l43-002", "たなかさんは でんわを かけて います。", "たなかさんはでんわをかけています。", "Tanaka-san wa denwa o kakete imasu.", "তানাকা বাবু ফোনে কথা বলছেন।", "তানাকা-সান ওয়া দেনওয়া ও কাকেতে ইমাসু।"),
            make_item("jp-p9-l43-003", "そとで あめが ふって います。", "そとであめがふっています。", "Soto de ame ga futte imasu.", "বাইরে বৃষ্টি পড়ছে।", "সোতো দে আমে গা ফdistributionত্তে ইমাসু।")
        ]
    },
    {
        "id": "jp-foundations-l44",
        "order": 2,
        "title_bn": "না-বোধক ঘটমান কাজ (Negative Continuous: Verb-て いません)",
        "title_target": "Negative Continuous Actions (Verb-te imasen)",
        "intro_bn": "এই মুহূর্তে কোনো কাজ করছি না বোঝাতে 'Verb-て いません' বসে।",
        "structure": ["Subject + は + いま + Verb-て いません"],
        "items": [
            make_item("jp-p9-l44-001", "いま テレビを みて いません。べんきょうして います。", "いまてれびをみていません。べんきょうしています。", "Ima terebi o mite imasen. Benkyou shite imasu.", "এখন টিভি দেখছি না। পড়াশোনা করছি।", "ইমা তেরেবি ও মিতে ইমাসেন। বেনকিওও শিতে ইমাসু।", polarity="negative"),
            make_item("jp-p9-l44-002", "あめは ふって いません。", "あめはふっていません。", "Ame wa futte imasen.", "বৃষ্টি পড়ছে না।", "আমে ওয়া ফdistributionত্তে ইমাসেন।", polarity="negative")
        ]
    },
    {
        "id": "jp-foundations-l45",
        "order": 3,
        "title_bn": "স্থায়িত্ব ও বর্তমান অবস্থা (Living, Knowing & Marital State)",
        "title_target": "Continuous States (Sunde imasu, Shitte imasu)",
        "intro_bn": "কোথাও বসবাস করা (住んでいます) বা কাউকে চেনা/জানা (知っています) অতীতে ঘটে এখনও বিদ্যমান অবস্থা বোঝায়।",
        "structure": ["Place に + すんで います (বাস করি)", "Person を + しって います (চিনি)"],
        "items": [
            make_item("jp-p9-l45-001", "わたしは ダッカに すんで います。", "わたしわだっかにすんでいます。", "Watashi wa Dakka ni sunde imasu.", "আমি ঢাকায় বসবাস করি।", "ওয়াতাশি ওয়া ধাক্কা নি সুন্দে ইমাসু।"),
            make_item("jp-p9-l45-002", "あの ひとを しって いますか。はい、しって います。", "あのひとをしっていますか。はい、しっています。", "Ano hito o shitte imasu ka. Hai, shitte imasu.", "ওই লোকটিকে চেনেন কি? হ্যাঁ, চিনি।", "আনো হিতো ও শিত্তে ইমাসু কা? হাই, শিত্তে ইমাসু।"),
            make_item("jp-p9-l45-003", "いいえ、しりません。", "いいえ、しりません。", "Iie, shirimasen.", "না, চিনি না / জানি না। (মনে রাখবেন: '知っていません' হয় না, '知りません' হয়)", "ইইয়ে, শিরিমাসেন।", polarity="negative")
        ]
    },
    {
        "id": "jp-foundations-l46",
        "order": 4,
        "title_bn": "পেশাগত কাজ চলা ও কর্মসংস্থান (Working at a Company)",
        "title_target": "Employment & Long-term Actions (Hatarraite imasu)",
        "intro_bn": "কোনো প্রতিষ্ঠানে চাকরি বা পেশায় নিয়োজিত থাকা প্রকাশে '〜で はたらいて います' বসে।",
        "structure": ["Company で + はたらいて います"],
        "items": [
            make_item("jp-p9-l46-001", "わたしは ITきぎょうで はたらいて います。", "わたしわあいてぃーきぎょうではたらいています。", "Watashi wa aitee kigyou de hataraite imasu.", "আমি একটি আইটি কোম্পানিতে কাজ করছি।", "ওয়াতাশি ওয়া আইটি কিগিওও দে হাতারাইতে ইমাসু।"),
            make_item("jp-p9-l46-002", "ちちは ぎんこうで つとめて います。", "ちちはぎんこうでつとめています。", "Chichi wa ginkou de tsutomete imasu.", "বাবা ব্যাংকে চাকরি করছেন।", "চিচি ওয়া গিনকোও দে সুতোমেতে ইমাসু।")
        ]
    }
]
parts.append({
    "id": "jp-foundations-p9",
    "order": 9,
    "level": "A1",
    "title_bn": "ঘটমান কাজ ও বর্তমান অবস্থা (〜ています - Present Continuous)",
    "title_target": "Present Continuous & Continuous States (~te imasu)",
    "lessons": p9_lessons
})

# -------------------------------------------------------------
# Part 10: Wants, Requests, Permissions & Obligations
# -------------------------------------------------------------
p10_lessons = [
    {
        "id": "jp-foundations-l47",
        "order": 1,
        "title_bn": "ইচ্ছা প্রকাশ — '〜たいです / 〜たくないです' (Desires)",
        "title_target": "Expressing Wants & Desires (~tai desu / ~takunai desu)",
        "intro_bn": "নিজের কোনো কিছু করার ইচ্ছা প্রকাশ করতে 'Verb-মাসু' এর মাসু উঠিয়ে '〜たいです' (চাই) এবং না চাইলে '〜たくないです' বসে।",
        "structure": ["Verb Stem + たいです (করতে চাই)", "Verb Stem + たくないです (করতে চাই না)"],
        "items": [
            make_item("jp-p10-l47-001", "わたしは にほんへ いきたいです。", "わたしわにほんえいきたいです。", "Watashi wa Nihon e ikitai desu.", "আমি জাপান যেতে চাই।", "ওয়াতাশি ওয়া নিহোন এ ইকিতাই দেস।"),
            make_item("jp-p10-l47-002", "にほんの すしを たべたいです。", "にほんのすしをたべたいです。", "Nihon no sushi o tabetai desu.", "জাপানি সুশি খেতে চাই।", "নিহোন নো সুশি ও তাবেতাই দেস।"),
            make_item("jp-p10-l47-003", "きょうは どこへも いきたくないです。うちで やすみたいです。", "きょうわどこえもいきたくないです。うちでやすみたいです。", "Kyou wa doko e mo ikitakunai desu. Uchi de yasumitai desu.", "আজ কোথাও যেতে চাই না। বাড়িতে বিশ্রাম নিতে চাই।", "কিয়োও ওয়া দোকো এ মো ইকিতাকুনাই দেস। উচি দে ইয়াসুমিতাই দেস।", polarity="negative")
        ]
    },
    {
        "id": "jp-foundations-l48",
        "order": 2,
        "title_bn": "পরিকল্পনা ও অন্যের সাথে চাওয়া (〜たいと思います)",
        "title_target": "Intentions & Moderate Desires (~tai to omoimasu)",
        "intro_bn": "মার্জিতভাবে নিজের ইচ্ছার কথা জানাতে '〜たいと おもいます' (ভাবছি যে করব) বলা হয়।",
        "structure": ["Verb-たい + と おもいます"],
        "items": [
            make_item("jp-p10-l48-001", "らいねん だいがくで べんきょうしたいと おもいます。", "らいねんだいがくでべんきょうしたいとおもいます。", "Rainen daigaku de benkyou shitai to omoimasu.", "আগামী বছর বিশ্ববিদ্যালয়ে পড়তে চাই বলে ভাবছি।", "রাইনেন দাইগাকু দে বেনকিওও শিতাই তো ওমোইমাসু।")
        ]
    },
    {
        "id": "jp-foundations-l49",
        "order": 3,
        "title_bn": "ভদ্র অনুরোধ — 'Verb-て ください' (Please do...)",
        "title_target": "Polite Requests (Verb-te kudasai)",
        "intro_bn": "কাউকে কোনো কিছু করার অনুরোধ করতে ক্রিয়ার তে-ফর্মের পর 'ください' (kudasai) বসে।",
        "structure": ["Verb-て + ください (অনুগ্রহ করে করুন)"],
        "items": [
            make_item("jp-p10-l49-001", "ここに なまえを かいて ください。", "ここになまえをかいてください。", "Koko ni namae o kaite kudasai.", "এখানে অনুগ্রহ করে নাম লিখুন।", "কোকো নি নামায়ে ও কাইতে কুদাসাই।"),
            make_item("jp-p10-l49-002", "もう いちど いって ください。", "もういちどいってください。", "Mou ichido itte kudasai.", "অনুগ্রহ করে আরও একবার বলুন।", "মোও ইচিদো ইত্তে কুদাসাই।"),
            make_item("jp-p10-l49-003", "どうぞ すわって ください。", "どうぞすわってください。", "Douzo suwatte kudasai.", "অনুগ্রহ করে বসুন।", "দোওজো সুওয়াত্তে কুদাসাই।")
        ]
    },
    {
        "id": "jp-foundations-l50",
        "order": 4,
        "title_bn": "অনুমতি চাওয়া ও প্রদান (Permission: Verb-ても いいですか)",
        "title_target": "Asking & Giving Permission (~te mo ii desu ka)",
        "intro_bn": "কোনো কাজ করার অনুমতি চাইতে '〜ても いいですか' (করতে পারি কি?) এবং অনুমতি দিতে 'いいですよ' বলতে হয়।",
        "structure": ["Verb-て + も いいですか (May I...?)", "はい、いいですよ (Yes, you may)"],
        "items": [
            make_item("jp-p10-l50-001", "しゃしんを とっても いいですか。はい、いいですよ。", "しゃしんをとってもいいですか。はい、いいですよ。", "Shashin o totte mo ii desu ka. Hai, ii desu yo.", "ছবি তুলতে পারি কি? হ্যাঁ, তুলতে পারেন।", "শাশিন ও তোত্তে মো ইই দেসু কা? হাই, ইই দেসু ইয়ো।"),
            make_item("jp-p10-l50-002", "ここに はいっても いいですか。", "ここにはいってもいいですか。", "Koko ni haitte mo ii desu ka.", "এখানে প্রবেশ করতে পারি কি?", "কোকো নি হাইত্তে মো ইই দেসু কা?")
        ]
    },
    {
        "id": "jp-foundations-l51",
        "order": 5,
        "title_bn": "নিষেধাজ্ঞা — 'Verb-ては いけません' (Prohibition: Must not)",
        "title_target": "Prohibition (~te wa ikemasen)",
        "intro_bn": "কোনো কাজ করা কঠোরভাবে নিষেধ বোঝাতে '〜ては いけません' বসে।",
        "structure": ["Verb-て + は いけません (করা যাবে না/নিষেধ)"],
        "items": [
            make_item("jp-p10-l51-001", "ここで タバコを すっては いけません。", "ここでたばこをすってはいけません。", "Koko de tabako o sutte wa ikemasen.", "এখানে ধূমপান করা নিষেধ।", "কোকো দে তাবাকো ও সুত্তে ওয়া ইকেমাসেন।", polarity="negative"),
            make_item("jp-p10-l51-002", "びじゅつかんで しゃしんを とっては いけません。", "びじゅつかんでしゃしんをとってはいけません。", "Bijutsukan de shashin o totte wa ikemasen.", "আর্ট গ্যালারিতে ছবি তোলা নিষেধ।", "বিজুতসুকান দে শাশিন ও তোত্তে ওয়া ইকেমাসেন।", polarity="negative")
        ]
    },
    {
        "id": "jp-foundations-l52",
        "order": 6,
        "title_bn": "বাধ্যবাধকতা — '〜なければ なりません' (Obligation: Must / Have to)",
        "title_target": "Obligation & Necessity (~nakereba narimasen)",
        "intro_bn": "কোনো কাজ করতেই হবে বা বাধ্যবাধকতা বোঝাতে 'নাই-ফর্মের' নাই উঠিয়ে '〜なければ なりません' বসে।",
        "structure": ["Verb-なければ + なりません (করতেই হবে)"],
        "items": [
            make_item("jp-p10-l52-001", "くすりを のまなければ なりません。", "くすりをのまなければなりません。", "Kusuri o nomanakereba narimasen.", "ওষুধ খেতেই হবে।", "কুসুরি ও নোমানাকেরোবা নারিমাসেন।"),
            make_item("jp-p10-l52-002", "あした びょういんへ いかなければ なりません。", "あしたびょういんえいかなければなりません。", "Ashita byouin e ikanakereba narimasen.", "আগামীকাল হাসপাতালে যেতেই হবে।", "আশিতা বিয়োওইন এ ইকানাখেরেবা নারিমাসেন।")
        ]
    },
    {
        "id": "jp-foundations-l53",
        "order": 7,
        "title_bn": "বাধ্যবাধকতা নেই — '〜なくても いいです' (No need to)",
        "title_target": "Lack of Obligation (~nakute mo ii desu)",
        "intro_bn": "কোনো কাজ না করলেও চলবে বোঝাতে '〜なくても いいです' বসে।",
        "structure": ["Verb-なくても + いいです (না করলেও চলবে)"],
        "items": [
            make_item("jp-p10-l53-001", "あしたは がっこうへ こなくても いいです。", "あしたはがっこうえこなくてもいいです。", "Ashita wa gakkou e konakute mo ii desu.", "আগামীকাল স্কুলে না আসলেও চলবে (ছুটি)।", "আশিতা ওয়া গাক্কোও এ কোনাকুতে মো ইই দেস।")
        ]
    }
]
parts.append({
    "id": "jp-foundations-p10",
    "order": 10,
    "level": "A1",
    "title_bn": "ইচ্ছা, অনুরোধ, অনুমতি ও বাধ্যবাধকতা (Wants, Modals & Rules)",
    "title_target": "Desires, Requests, Permissions & Obligations",
    "lessons": p10_lessons
})

# -------------------------------------------------------------
# Part 11: Interactive Voice Pair Practice (Voice Q&A)
# -------------------------------------------------------------
p11_lessons = [
    {
        "id": "jp-foundations-l54",
        "order": 1,
        "title_bn": "বাসস্থান ও শহর নিয়ে পেয়ার ড্রিল (Living & Hometown Voice Q&A)",
        "title_target": "Hometown & Residence (Pair Voice Practice)",
        "intro_bn": "মাইক্রোফোনে ট্যাপ করে প্রশ্ন শুনে জাপানিজে উত্তর দিন।",
        "structure": ["Q: どこに すんでいますか", "A: [Place] に すんでいます"],
        "items": [
            make_item("jp-p11-l54-001", "おすまいは どちらですか。ダッカに すんでいます。", "おすまいわどちらですか。だっかにすんでいます。", "Osumai wa dochira desu ka. Dakka ni sunde imasu.", "আপনার বাসস্থান কোথায়? ঢাকায় বসবাস করি।", "ওসুমাই ওয়া দোচিরা দেসু কা? ধাক্কা নি সুন্দে ইমাসু।", item_type="dialogue"),
            make_item("jp-p11-l54-002", "ふるさとは どんな まちですか。しずかで きれいな まちです。", "ふるさとわどんなまちですか。しずかできれいなまちです。", "Furusato wa donna machi desu ka. Shizuka de kirei na machi desu.", "আপনার নিজের শহর কেমন? শান্ত ও সুন্দর শহর।", "ফুরুসাতো ওয়া দোন্না মাচি দেসু কা? শিজুকা দে কিরেই না মাচি দেস।", item_type="dialogue")
        ]
    },
    {
        "id": "jp-foundations-l55",
        "order": 2,
        "title_bn": "শখ ও প্রতিদিনের রুটিন নিয়ে পেয়ার ড্রিল (Hobbies & Routines)",
        "title_target": "Hobbies & Routines (Pair Voice Practice)",
        "intro_bn": "শখ ও অভ্যাস নিয়ে পারস্পরিক কথোপকথন ড্রিল।",
        "structure": ["Q: しゅみは なんですか", "A: [Hobby] です"],
        "items": [
            make_item("jp-p11-l55-001", "しゅみは なんですか。おんがくを きくことです。", "しゅみわなんですか。おんがくをきくことです。", "Shumi wa nan desu ka. Ongaku o kiku koto desu.", "আপনার শখ কী? গান শোনা।", "শুমি ওয়া নান দেসু কা? ওনগাকু ও কিকু কোতো দেস।", item_type="dialogue"),
            make_item("jp-p11-l55-002", "まいにち なにを しますか。にほんごを べんきょうします。", "まいにちなにをしますか。にほんごをべんきょうします。", "Mainichi nani o shimasu ka. Nihongo o benkyou shimasu.", "প্রতিদিন কী করেন? জাপানি ভাষা শিখি।", "মাইনিচি নানি ও শিমাসু কা? নিহঙ্গো ও বেনকিওও শিমাসু।", item_type="dialogue")
        ]
    },
    {
        "id": "jp-foundations-l56",
        "order": 3,
        "title_bn": "রেস্তোরাঁ ও পছন্দের খাবার (Food & Dining Voice Q&A)",
        "title_target": "Dining & Preferences (Pair Voice Practice)",
        "intro_bn": "খাবারের পছন্দ ও অর্ডার নিয়ে প্রশ্ন-উত্তর অনুশীলন।",
        "structure": ["Q: なにが すきですか", "A: [Food] が すきです"],
        "items": [
            make_item("jp-p11-l56-001", "どんな たべものが すきですか。かれーが すきです。", "どんなたべものがすきですか。かれーがすきです。", "Donna tabemono ga suki desu ka. Karee ga suki desu.", "কেমন খাবার আপনার পছন্দ? কারি পছন্দ।", "দোন্না তাবেমোনো গা সুকি দেসু কা? কারেএ গা সুকি দেস।", item_type="dialogue"),
            make_item("jp-p11-l56-002", "にほんの りょうりは たかいですか。いいえ、あまり たかくないです。", "にほんのりょうりわたかいですか。いいえ、あまりたかくないです。", "Nihon no ryouri wa takai desu ka. Iie, amari takakunai desu.", "জাপানি খাবার কি দামি? না, তেমন দামি নয়।", "নিহোন নো রিওওরি ওয়া তাকাই দেসু কা? ইইয়ে, আমারি তাকাকুনাই দেস।", item_type="dialogue")
        ]
    },
    {
        "id": "jp-foundations-l57",
        "order": 4,
        "title_bn": "যাতায়াত ও সময় (Travel & Directions Voice Q&A)",
        "title_target": "Transportation & Directions (Pair Voice Practice)",
        "intro_bn": "যাতায়াত সংক্রান্ত প্রশ্ন-উত্তর ড্রিল।",
        "structure": ["Q: どうやって きましたか", "A: [Vehicle] で きました"],
        "items": [
            make_item("jp-p11-l57-001", "ここまで どうやって きましたか。ちかてつで きました。", "ここまでどうやってきましたか。ちかてつできました。", "Koko made dou yatte kimashita ka. Chikatetsu de kimashita.", "এখানে কীভাবে এসেছেন? সাবওয়ে/মেট্রোতে এসেছি।", "কোকো মাদে দোও ইয়াত্তে কিমাশিতা কা? চকাতেৎসু দে কিমাশিতা।", item_type="dialogue"),
            make_item("jp-p11-l57-002", "どのくらい かかりましたか。３０ぷん かかりました。", "どのくらいかかりましたか。さんじっぷんかかりました。", "Dono kurai kakarimashita ka. Sanjippun kakarimashita.", "কতক্ষণ সময় লেগেছে? ৩০ মিনিট লেগেছে।", "দোনো কুরাই কাকারিমাশিতা কা? সানজিপ্পুন কাকারিমাশিতা।", item_type="dialogue")
        ]
    }
]
parts.append({
    "id": "jp-foundations-p11",
    "order": 11,
    "level": "A1",
    "title_bn": "ইন্টারেক্টিভ ভয়েস পেয়ার প্র্যাকটিস (Voice Q&A Practice)",
    "title_target": "Interactive Voice Pair Practice (Pair Q&A)",
    "lessons": p11_lessons
})

# -------------------------------------------------------------
# Part 12: Real-life Situational Mini-Dialogues
# -------------------------------------------------------------
p12_lessons = [
    {
        "id": "jp-foundations-l58",
        "order": 1,
        "title_bn": "প্রথম পরিচয় ও সম্ভাষণ (First Meeting: Hajimemashite Dialogue)",
        "title_target": "Greetings & Self Introduction Dialogue",
        "intro_bn": "জাপানিজে কারও সাথে প্রথম সাক্ষাতে অত্যন্ত মার্জিতভাবে অভিবাদন জানানোর পূর্ণাঙ্গ সংলাপ।",
        "structure": ["A: はじめまして ... よろしくお願いします", "B: こちらこそ よろしくお願いします"],
        "items": [
            make_item("jp-p12-l58-001", "はじめまして。わたしは ラヒムです。バングラデシュから きました。", "はじめまして。わたしわらひむです。ばんぐらでしゅからきました。", "Hajimemashite. Watashi wa Rahimu desu. Banguradeshu kara kimashita.", "প্রথম পরিচয়। আমি রহিম। বাংলাদেশ থেকে এসেছি।", "হাজিমেমাশিতে। ওয়াতাশি ওয়া রাহিমু দেস। বাঙ্গুরাদেশু কারা কিমাশিতা।", item_type="dialogue"),
            make_item("jp-p12-l58-002", "はじめまして。さとうです。どうぞ よろしく おねがいします。", "はじめまして。さとうです。どうぞよろしくおねがいします。", "Hajimemashite. Satou desu. Douzo yoroshiku onegaishimasu.", "প্রথম পরিচয়। আমি সাতো। পরিচিত হয়ে অত্যন্ত আনন্দিত হলাম।", "হাজিমেমাশিতে। সাতোও দেস। দোওজো ইয়োরোশিকু ওনেগাইশিমাসু।", item_type="dialogue"),
            make_item("jp-p12-l58-003", "こちらこそ、よろしく おねがいします。", "こちらこそ、よろしくおねがいします。", "Kochira koso, yoroshiku onegaishimasu.", "আমার পক্ষ থেকেও আপনার সাথে পরিচিত হতে পেরে আনন্দিত হলাম।", "কোচিরা কোসো, ইয়োরোশিকু ওনেগাইশিমাসু।", item_type="dialogue")
        ]
    },
    {
        "id": "jp-foundations-l59",
        "order": 2,
        "title_bn": "দোকানে কেনাকাটা ও ক্যাশিয়ার (Convenience Store / Supermarket)",
        "title_target": "Convenience Store & Shopping Dialogue",
        "intro_bn": "কনভিনিয়েন্স স্টোর বা সুপারমার্কেটে জিনিস কেনা ও ক্যাশিয়ারের সাথে কথোপকথন।",
        "structure": ["A: すみません、〜を ください", "Clerk: 〜円になります"],
        "items": [
            make_item("jp-p12-l59-001", "いらっしゃいませ。おべんとうを あたためますか。", "いらっしゃいませ。おべんとうをあたためますか。", "Irasshaimase. Obentou o atatamemasu ka.", "স্বাগতম! লাঞ্চ বক্সটি কি গরম করে দেব?", "ইরাশশাইমাসে। ওবেনতোও ও আতাতামেমাশু কা?", item_type="dialogue"),
            make_item("jp-p12-l59-002", "はい、おねがいします。ふくろも いちまい ください。", "はい、おねがいします。ふくろもいちまいください。", "Hai, onegaishimasu. Fukuro mo ichimai kudasai.", "হ্যাঁ, অনুগ্রহ করে দিন। একটা ব্যাগও দিন।", "হাই, ওনেগাইশিমাসু। ফুকুরো মো ইচিমাই কুদাসাই।", item_type="dialogue"),
            make_item("jp-p12-l59-003", "ぜんぶで ６５０えんに なります。", "ぜんぶでろっぴゃくごじゅうえんになります。", "Zenbu de roppyaku gojuu-en ni narimasu.", "সব মিলিয়ে ৬৫০ ইয়েন হয়েছে।", "জেনবু দে রোপ্পিয়াকু গোজুউ-য়েন নি নারিমাসু।", item_type="dialogue")
        ]
    },
    {
        "id": "jp-foundations-l60",
        "order": 3,
        "title_bn": "স্টেশনে টিকিট ও পথ নির্দেশনা (Station & Navigation Dialogue)",
        "title_target": "Train Station & Navigation Dialogue",
        "intro_bn": "ট্রেন স্টেশনে টিকিট কেনা ও কোন প্ল্যাটফর্মে ট্রেন আসবে তা জানার সংলাপ।",
        "structure": ["A: 〜までの 切符を ください", "B: 〜番線です"],
        "items": [
            make_item("jp-p12-l60-001", "すみません。とうきょうまでの きっぷを いちまい ください。", "すみません。とうきょうまでのきっぷをいちまいください。", "Sumimasen. Toukyou made no kippu o ichimai kudasai.", "মাফ করবেন। টোকিও পর্যন্ত একটি টিকিট দিন।", "সুমিমাসেন। তোকিও মাদে নো কিপ্পু ও ইচিমাই কুদাসাই।", item_type="dialogue"),
            make_item("jp-p12-l60-002", "はい。せんにひゃくえんです。とうきょうゆきは ３ばんせんです。", "はい。せんにひゃくえんです。とうきょうゆきはさんばんせんです。", "Hai. Sen nihyaku-en desu. Toukyou-yuki wa sanbansen desu.", "জি। ১,২০০ ইয়েন। টোকিওগামী ট্রেন ৩ নম্বর প্ল্যাটফর্মে।", "হাই। সেন নিহিয়াকু-য়েন দেস। তোকিও-ইউকি ওয়া সানবানসেন দেস।", item_type="dialogue"),
            make_item("jp-p12-l60-003", "どうも ありがとう ございます。", "どうもありがとうございます。", "Doumo arigatou gozaimasu.", "আপনাকে অনেক ধন্যবাদ।", "দোওমো আরিগাতোও গোজাইমাসু।", item_type="dialogue")
        ]
    }
]
parts.append({
    "id": "jp-foundations-p12",
    "order": 12,
    "level": "A1",
    "title_bn": "ব্যবহারিক কনভারসেশন ও মিনি-ডায়ালগ (Situational Mini-Dialogues)",
    "title_target": "Practical Situational Mini-Dialogues (Roleplay)",
    "lessons": p12_lessons
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

print(f"Course 1 created successfully!")
print(f"Saved to: {DEST_FILE}")
print(f"Total Parts: {len(parts)}")
print(f"Total Lessons: {total_lessons}")
print(f"Total Items: {total_items}")
