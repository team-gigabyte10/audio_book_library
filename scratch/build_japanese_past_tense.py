# -*- coding: utf-8 -*-
"""
Builder for Course 2: Japanese Spoken Past & Experience (JLPT N5/N4)
Generates: android/app/src/main/assets/spoken_japanese_past_tense.json
Curated from 00_Bangla_Japanese_N5_to_N1_Extended_Master_Complete.md
"""
import json
import os
import sys

sys.stdout.reconfigure(encoding='utf-8')

DEST_FILE = 'android/app/src/main/assets/spoken_japanese_past_tense.json'

course_metadata = {
    "id": "jp-spoken-past-tense",
    "target_lang": "ja",
    "base_lang": "bn",
    "title_bn": "জাপানিজ স্পোকেন: Past Tense ও জীবনের অভিজ্ঞতা (N5/N4)",
    "title_target": "Spoken Japanese: Past Tense, Te-Form & Life Experiences",
    "source": "Curated from N5-N4 Extended Master Complete & Spoken Japanese Audio Framework",
    "note": "অতীত অবস্থা (でした/ではありませんでした), বিশেষণের অতীত (〜かった/〜でした), ক্রিয়ার সমাপ্তি (〜ました), তে-ফর্ম সংযোগ (Te-form), ঘটমান অতীত (〜ていました), জীবনের অভিজ্ঞতা (〜たことがあります), উপকার আদান-প্রদান (〜てあげる/くれる/もらう), প্রস্তুতি ও সমাপ্তি (〜ておく/てしまう/てみる), এবং অতীত ৬-রূপান্তর ড্রিল।",
    "welcome_text": "জাপানিজ স্পোকেন Course 2-এ স্বাগতম! অতীতের স্মৃতি, ঘটে যাওয়া ঘটনা, জীবনের অভিজ্ঞতা ও একের পর এক কাজের ধারাবাহিকতা সাবলীলভাবে প্রকাশ করার জন্য প্রস্তুত হন।"
}

ladder_default = [
    {"play": "target", "speed": 0.85},
    {"play": "bn", "speed": 1.15},
    {"play": "target", "speed": 0.95},
    {"play": "target", "speed": 1.05},
    {"play": "target", "speed": 1.15, "min_level": "A2"},
    {"pause_ms": 1200}
]

def make_item(item_id, target, target_kana, romaji, bn, bn_pron, tokens_tuples=None, sentence_type="assertive", polarity="affirmative", tense="past_simple", item_type="sentence", level="A2"):
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
# PART 1: অতীতের অবস্থা, পরিচয় ও বিশেষণের অতীত রূপ (Past State & Identity)
# ==============================================================================
p1_lessons = [
    {
        "id": "jp-past-l01",
        "order": 1,
        "title_bn": "অতীত পরিচয় ও অবস্থা — 'でした / ではありませんでした'",
        "title_target": "Past Identity & Copula (Deshita / Dewa arimasen deshita)",
        "intro_bn": "অতীতে কেউ কী ছিল বা কোনো কিছু কী ছিল তা বোঝাতে 'でした' (deshita - ছিল) এবং না-বোধক করতে 'ではありませんでした / じゃありませんでした' (ছিল না) বসে।",
        "structure": [
            "Affirmative: Noun + でした (ছিল)",
            "Negative: Noun + ではありませんでした / じゃありませんでした (ছিল না)"
        ],
        "items": [
            make_item("jp-past-p1-l1-001", "きのうは 休みでした。", "きのうわやすみでした。", "Kinou wa yasumi deshita.", "গতকাল ছুটি ছিল।", "কিনোও ওয়া ইয়াসুমি দেশিতা।", [("きのう", "kinou", "昨日", "গতকাল"), ("は", "wa", "は", "হল"), ("休み", "yasumi", "休み", "ছুটি"), ("でした", "deshita", "でした", "ছিল")]),
            make_item("jp-past-p1-l1-002", "かれは 去年 大学生でした。", "かれわきょねんだいがくせいでした。", "Kare wa kyonen daigakusei deshita.", "সে গত বছর বিশ্ববিদ্যালয়ের ছাত্র ছিল।", "কারে ওয়া কিওনেন দাইগাকুসেই দেশিতা।", [("かれ", "kare", "彼", "সে"), ("は", "wa", "は", "হল"), ("去年", "kyonen", "去年", "গত বছর"), ("大学生", "daigakusei", "大学生", "বিশ্ববিদ্যালয়ের ছাত্র"), ("でした", "deshita", "でした", "ছিল")]),
            make_item("jp-past-p1-l1-003", "きのうは 月曜日じゃ ありませんでした。日曜日でした。", "きのうわげつようびじゃありませんでした。にちようびでした。", "Kinou wa getsuyoubi ja arimasen deshita. Nichiyoubi deshita.", "গতকাল সোমবার ছিল না। রবিবার ছিল।", "কিনোও ওয়া গেতসুয়োওবি জা আরিমাসেন দেশিতা। নিচিয়োওবি দেশিতা।", [("きのう", "kinou", "昨日", "গতকাল"), ("は", "wa", "は", "হল"), ("月曜日", "getsuyoubi", "月曜日", "সোমবার"), ("じゃ ありませんでした", "ja arimasen deshita", "じゃありませんでした", "ছিল না"), ("日曜日", "nichiyoubi", "日曜日", "রবিবার"), ("でした", "deshita", "でした", "ছিল")], polarity="negative"),
            make_item("jp-past-p1-l1-004", "おとといは 雨でしたか。いいえ、晴れでした。", "おとといわあめでしたか。いいえ、はれでした。", "Ototoi wa ame deshita ka. Iie, hare deshita.", "গত পরশু কি বৃষ্টি ছিল? না, রৌদ্রোজ্জ্বল ছিল।", "ওতোতোই ওয়া আমে দেশিতা কা? ইইয়ে, হারে দেশিতা।", [("おととい", "ototoi", "一昨日", "গত পরশু"), ("は", "wa", "は", "হল"), ("雨でしたか", "ame deshita ka", "雨でしたか", "বৃষ্টি ছিল কি"), ("いいえ", "iie", "いいえ", "না"), ("晴れでした", "hare deshita", "晴れでした", "রোদ ছিল")])
        ]
    },
    {
        "id": "jp-past-l02",
        "order": 2,
        "title_bn": "い-বিশেষণের অতীত রূপ (i-Adjectives: 〜かったです / 〜くなかったです)",
        "title_target": "Past i-Adjectives (~katta desu / ~kunakatta desu)",
        "intro_bn": "i-Adjective এর অতীত রূপ করতে শেষের 'い' উঠে 'かったです' (katta desu) এবং না-বোধক করতে 'くなかったです' (kunakatta desu) বসে।",
        "structure": [
            "Affirmative: Stem + かったです (ছিল)",
            "Negative: Stem + くなかったです (ছিল না)",
            "Irregular (いい): よかったです / よくなかったです"
        ],
        "items": [
            make_item("jp-past-p1-l2-001", "きのうは とても 暑かったです。", "きのうわとてもあつかったです。", "Kinou wa totemo atsukatta desu.", "গতকাল খুব গরম ছিল।", "কিনোও ওয়া তোতেমো আতসুকাত্তা দেশিতা।", [("きのう", "kinou", "昨日", "গতকাল"), ("は", "wa", "は", "হল"), ("とても", "totemo", "とても", "খুব"), ("暑かったです", "atsukatta desu", "暑かったです", "গরম ছিল")]),
            make_item("jp-past-p1-l2-002", "先週の 旅行は 楽しかったです。", "せんしゅうのりょこうわたのしかったです。", "Senshuu no ryokou wa tanoshikatta desu.", "গত সপ্তাহের ভ্রমণ আনন্দদায়ক ছিল।", "সেনশুউ নো রিওকোও ওয়া তানোশিকাত্তা দেশিতা।", [("先週", "senshuu", "先週", "গত সপ্তাহ"), ("の", "no", "の", "এর"), ("旅行", "ryokou", "旅行", "ভ্রমণ"), ("は", "wa", "は", "হল"), ("楽しかったです", "tanoshikatta desu", "楽しかったです", "আনন্দদায়ক ছিল")]),
            make_item("jp-past-p1-l2-003", "きのうの テストは あまり 難しくなかったです。", "きのうのてすとわあまりむずかしくなかったです。", "Kinou no tesuto wa amari muzukashikunakatta desu.", "গতকালের পরীক্ষাটি খুব একটা কঠিন ছিল না।", "কিনোও নো তেসুতো ওয়া আমারি মুজুকাশিকুনাকাত্তা দেশিতা।", [("きのう", "kinou", "昨日", "গতকাল"), ("の", "no", "の", "এর"), ("テスト", "tesuto", "テスト", "পরীক্ষা"), ("は", "wa", "は", "হল"), ("あまり", "amari", "あまり", "তেমন"), ("難しくなかったです", "muzukashikunakatta desu", "難しくなかったです", "কঠিন ছিল না")], polarity="negative"),
            make_item("jp-past-p1-l2-004", "きのうの 映画は 面白かったですか。はい、とても 面白かったです。", "きのうのえいがわおもしろかったですか。はい、とてもおもしろかったです。", "Kinou no eiga wa omoshirokatta desu ka. Hai, totemo omoshirokatta desu.", "গতকালের সিনেমাটি কি মজার ছিল? হ্যাঁ, খুব মজার ছিল।", "কিনোও নো এইগা ওয়া ওমোশিরোকাত্তা দেশিতা কা? হাই, তোতেমো ওমোশিরোকাত্তা দেশিতা।", [("きのう", "kinou", "昨日", "গতকাল"), ("の", "no", "の", "এর"), ("映画", "eiga", "映画", "সিনেমা"), ("は", "wa", "は", "হল"), ("面白かったですか", "omoshirokatta desu ka", "面白かったですか", "মজার ছিল কি"), ("とても", "totemo", "とても", "খুব"), ("面白かったです", "omoshirokatta desu", "面白かったです", "মজার ছিল")])
        ]
    },
    {
        "id": "jp-past-l03",
        "order": 3,
        "title_bn": "な-বিশেষণের অতীত রূপ (na-Adjectives: 〜でした / 〜じゃありませんでした)",
        "title_target": "Past na-Adjectives (~deshita / ~ja arimasen deshita)",
        "intro_bn": "na-Adjective এর অতীত করতে বিশেষণের শেষে 'でした' এবং না-বোধক করতে 'じゃありませんでした' বসে। যেমন: 静かでした (শান্ত ছিল)।",
        "structure": [
            "Affirmative: na-Adjective + でした",
            "Negative: na-Adjective + じゃありませんでした"
        ],
        "items": [
            make_item("jp-past-p1-l3-001", "去年 この町は とても 静かでした。", "きょねんこのまちわとてもしずかでした。", "Kyonen kono machi wa totemo shizuka deshita.", "গত বছর এই শহরটি খুব শান্ত ছিল।", "কিওনেন কোনো মাচি ওয়া তোতেমো শিজুকা দেশিতা।", [("去年", "kyonen", "去年", "গত বছর"), ("この", "kono", "この", "এই"), ("町", "machi", "町", "শহর"), ("は", "wa", "は", "হল"), ("とても", "totemo", "とても", "খুব"), ("静かでした", "shizuka deshita", "静かでした", "শান্ত ছিল")]),
            make_item("jp-past-p1-l3-002", "きのうの パーティーは とても にぎやかでした。", "きのうのぱーてぃーわとてもにぎやかでした。", "Kinou no paatii wa totemo nigiyaka deshita.", "গতকালের পার্টিটি খুব জমজমাট ও মুখরিত ছিল।", "কিনোও নো পাতিই ওয়া তোতেমো নিগিয়াকা দেশিতা।", [("きのう", "kinou", "昨日", "গতকাল"), ("の", "no", "の", "এর"), ("パーティー", "paatii", "パーティー", "পার্টি"), ("は", "wa", "は", "হল"), ("にぎやかでした", "nigiyaka deshita", "賑やかでした", "জমজমাট ছিল")]),
            make_item("jp-past-p1-l3-003", "きのうは ひまじゃ ありませんでした。とても 忙しかったです。", "きのうわひまじゃありませんでした。とてもいそがしかったです。", "Kinou wa hima ja arimasen deshita. Totemo isogashikatta desu.", "গতকাল অবসর ছিল না। খুব ব্যস্ত ছিলাম।", "কিনোও ওয়া হিমা জা আরিমাসেন দেশিতা। তোতেমো ইসোগাশিকাত্তা দেশিতা।", [("きのう", "kinou", "昨日", "গতকাল"), ("は", "wa", "は", "হল"), ("ひまじゃ ありませんでした", "hima ja arimasen deshita", "暇じゃありませんでした", "অবসর ছিল না"), ("とても", "totemo", "とても", "খুব"), ("忙しかったです", "isogashikatta desu", "忙しかったです", "ব্যস্ত ছিল")], polarity="negative")
        ]
    },
    {
        "id": "jp-past-l04",
        "order": 4,
        "title_bn": "অতীতের অবস্থা ও ৬-রূপান্তর ড্রিল (Past State 6 Transformations)",
        "title_target": "6 Sentence Transformations: Past State & Identity",
        "intro_bn": "অতীত অবস্থার দ্রুত রূপান্তর ড্রিল (হ্যাঁ-বোধক, না-বোধক, প্রশ্ন, না-বোধক প্রশ্ন, WH-প্রশ্ন ও বিকল্প প্রশ্ন)।",
        "structure": ["Affirmative (+)", "Negative (-)", "Question (?)", "Negative Q (-?)", "WH-Q", "Alternative Q"],
        "items": [
            make_item("jp-past-p1-l4-001", "きのうの 天気は よかったです。", "きのうのてんきわよかったです。", "Kinou no tenki wa yokatta desu.", "১. হ্যাঁ-বোধক: গতকালের আবহাওয়া ভালো ছিল।", "কিনোও নো তেনকি ওয়া ইয়োকাত্তা দেশিতা।", item_type="drill"),
            make_item("jp-past-p1-l4-002", "きのうの 天気は よくなかったです。", "きのうのてんきわよくなかったです。", "Kinou no tenki wa yokunakatta desu.", "২. না-বোধক: গতকালের আবহাওয়া ভালো ছিল না।", "কিনোও নো তেনকি ওয়া ইয়োকুনাকাত্তা দেশিতা।", item_type="drill", polarity="negative"),
            make_item("jp-past-p1-l4-003", "きのうの 天気は よかったですか。", "きのうのてんきわよかったですか。", "Kinou no tenki wa yokatta desu ka.", "৩. প্রশ্নবোধক: গতকালের আবহাওয়া কি ভালো ছিল?", "কিনোও নো তেনকি ওয়া ইয়োকাত্তা দেশিতা কা?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-past-p1-l4-004", "きのうの 天気は よくありませんでしたか。", "きのうのてんきわよくありませんでしたか。", "Kinou no tenki wa yoku arimasen deshita ka.", "৪. না-বোধক প্রশ্ন: গতকালের আবহাওয়া কি ভালো ছিল না?", "কিনোও নো তেনকি ওয়া ইয়োকু আরিমাসেন দেশিতা কা?", item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-past-p1-l4-005", "きのうの 天気は どうでしたか。雨でした。", "きのうのてんきわどうでしたか。あめでした。", "Kinou no tenki wa dou deshita ka. Ame deshita.", "৫. WH-প্রশ্ন: গতকালের আবহাওয়া কেমন ছিল? বৃষ্টি ছিল।", "কিনোও নো তেনকি ওয়া দোও দেশিতা কা? আমে দেশিতা।", item_type="drill", sentence_type="wh_question"),
            make_item("jp-past-p1-l4-006", "きのうは 暑かったですか、寒かったですか。", "きのうわあつかったですか、さむかったですか。", "Kinou wa atsukatta desu ka, samukatta desu ka.", "৬. বিকল্প প্রশ্ন: গতকাল কি গরম ছিল, নাকি ঠান্ডা ছিল?", "কিনোও ওয়া আতসুকাত্তা দেশিতা কা, সামুকাত্তা দেশিতা কা?", item_type="drill", sentence_type="alternative_question")
        ]
    }
]
parts.append({
    "id": "jp-past-p1",
    "order": 1,
    "level": "A2",
    "title_bn": "অতীতের অবস্থা, পরিচয় ও বিশেষণের অতীত রূপ (Past State & Identity)",
    "title_target": "Past State, Identity & Adjectives (Deshita / Katta desu)",
    "lessons": p1_lessons
})

# ==============================================================================
# PART 2: অতীতের সমাপ্ত কাজ (Past Actions: 〜ました / 〜ませんでした)
# ==============================================================================
p2_lessons = [
    {
        "id": "jp-past-l05",
        "order": 1,
        "title_bn": "অতীতের সমাপ্ত কাজ — 'Verb-ました' (Past Simple Actions)",
        "title_target": "Completed Past Actions (Verb-mashita)",
        "intro_bn": "অতীতে কোনো কাজ করেছি প্রকাশ করতে ক্রিয়াপদের মার্জিত অতীত রূপ '〜ました' (mashita) বসে।",
        "structure": ["Subject + は + Time に + Object を + Verb-ました"],
        "items": [
            make_item("jp-past-p2-l5-001", "わたしは きのう ８時間 寝ました。", "わたしわきのうはちじかんねました。", "Watashi wa kinou hachijikan nemashita.", "আমি গতকাল ৮ ঘণ্টা ঘুমিয়েছি।", "ওয়াতাশি ওয়া কিনোও হাচিজিকান নেমাশিতা।", [("わたし", "watashi", "私", "আমি"), ("は", "wa", "は", "হল"), ("きのう", "kinou", "昨日", "গতকাল"), ("８時間", "hachijikan", "８時間", "৮ ঘণ্টা"), ("寝ました", "nemashita", "寝ました", "ঘুমিয়েছি")]),
            make_item("jp-past-p2-l5-002", "朝 ７時に 朝ご飯を 食べました。", "あさしちじにあさごはんをたべました。", "Asa shichiji ni asagohan o tabemashita.", "সকাল ৭টায় নাস্তা খেয়েছিলাম।", "আসা শিচিজি নি আসাগোহান ও তাবেমাশিতা।", [("朝", "asa", "朝", "সকালে"), ("７時に", "shichiji ni", "７時に", "৭টায়"), ("朝ご飯", "asagohan", "朝ご飯", "সকালের নাস্তা"), ("を食べました", "o tabemashita", "を食べました", "খেয়েছিলাম")]),
            make_item("jp-past-p2-l5-003", "きのう 日本語の 本を 読みました。", "きのうにほんごのほんをよみました。", "Kinou nihongo no hon o yomimashita.", "গতকাল জাপানি বই পড়েছিলাম।", "কিনোও নিহঙ্গো নো হোন ও ইয়োমিমাশিতা।", [("きのう", "kinou", "昨日", "গতকাল"), ("日本語", "nihongo", "日本語", "জাপানি ভাষা"), ("の本", "no hon", "の本", "এর বই"), ("を読みました", "o yomimashita", "を読みました", "পড়েছিলাম")]),
            make_item("jp-past-p2-l5-004", "きのう 友だちと サッカーを しました。", "きのうともだちとさっかーをしました。", "Kinou tomodachi to sakkaa o shimashita.", "গতকাল বন্ধুর সাথে ফুটবল খেলেছি।", "কিনোও তোমোদাচি তো সাক্কাআ ও শিমাশিতা।", [("きのう", "kinou", "昨日", "গতকাল"), ("友だちと", "tomodachi to", "友だちと", "বন্ধুর সাথে"), ("サッカーを", "sakkaa o", "サッカーを", "ফুটবল"), ("しました", "shimashita", "しました", "খেলেছি")])
        ]
    },
    {
        "id": "jp-past-l06",
        "order": 2,
        "title_bn": "অতীত না-বোধক কাজ — 'Verb-ませんでした' (Past Negative Actions)",
        "title_target": "Negative Past Actions (Verb-masendeshita)",
        "intro_bn": "অতীতে কোনো কাজ করিনি প্রকাশ করতে ক্রিয়ার শেষে '〜ませんでした' (masendeshita) বসে।",
        "structure": ["Subject + は + Object を + Verb-ませんでした"],
        "items": [
            make_item("jp-past-p2-l6-001", "けさ 何も 食べませんでした。", "けさなにもたべませんでした。", "Kesa nani mo tabemasendeshita.", "আজ সকালে কিছুই খাইনি।", "কেসা নানি মো তাবেমাসেনদেশিতা।", [("けさ", "kesa", "今朝", "আজ সকালে"), ("何も", "nani mo", "何も", "কিছুই"), ("食べませんでした", "tabemasendeshita", "食べませんでした", "খাইনি")], polarity="negative"),
            make_item("jp-past-p2-l6-002", "きのうは どこへも 行きませんでした。", "きのうわどこえもいきませんでした。", "Kinou wa doko e mo ikimasendeshita.", "গতকাল কোথাও যাইনি।", "কিনোও ওয়া দোকো এ মো ইকিমাসেনদেশিতা।", [("きのうは", "kinou wa", "昨日は", "গতকাল"), ("どこへも", "doko e mo", "どこへも", "কোথাও"), ("行きませんでした", "ikimasendeshita", "行きませんでした", "যাইনি")], polarity="negative"),
            make_item("jp-past-p2-l6-003", "ゆうべ テレビを 見ませんでした。早く 寝ました。", "ゆうべてれびをみませんでした。はやくねました。", "Yuube terebi o mimasendeshita. Hayaku nemashita.", "গত রাতে টিভি দেখিনি। তাড়াতাড়ি ঘুমিয়েছিলাম।", "ইউউবে তেরেবি ও মিমাসেনদেশিতা। হায়াকু নেমাশিতা।", [("ゆうべ", "yuube", "昨夜", "গত রাতে"), ("テレビを", "terebi o", "テレビを", "টিভি"), ("見ませんでした", "mimasendeshita", "見ませんでした", "দেখিনি"), ("早く", "hayaku", "早く", "তাড়াতাড়ি"), ("寝ました", "nemashita", "寝ました", "ঘুমিয়েছিলাম")], polarity="negative")
        ]
    },
    {
        "id": "jp-past-l07",
        "order": 3,
        "title_bn": "অতীত কাজের স্থান ও বাহন (Past Location & Means)",
        "title_target": "Past Location & Vehicle (Place de / Vehicle de)",
        "intro_bn": "অতীতে কোথায় এবং কীভাবে কাজ করেছি তা প্রকাশ করতে 'で' (de) বসে।",
        "structure": ["Vehicle で + Place へ + 行きました", "Place で + Action を + しました"],
        "items": [
            make_item("jp-past-p2-l7-001", "新幹線で 京都へ 行きました。", "しんかんせんできょうとえいきました。", "Shinkansen de Kyouto e ikimashita.", "বুলেট ট্রেনে করে কিয়োটো গিয়েছিলাম।", "শিনকানসেন দে কিওওতো এ ইকিমাশিতা।", [("新幹線で", "shinkansen de", "新幹線で", "বুলেট ট্রেনে"), ("京都へ", "Kyouto e", "京都へ", "কিয়োটোতে"), ("行きました", "ikimashita", "行きました", "গিয়েছিলাম")]),
            make_item("jp-past-p2-l7-002", "デパートで 新しい 靴を 買いました。", "でぱーとであたらしいくつをかいました。", "Depaato de atarashii kutsu o kaimashita.", "ডিপার্টমেন্টাল স্টোরে নতুন জুতো কিনেছিলাম।", "দেপাতো দে আতারাসিই কুৎসু ও কাইমাশিতা।", [("デパートで", "depaato de", "デパートで", "ডিপার্টমেন্টাল স্টোরে"), ("新しい", "atarashii", "新しい", "নতুন"), ("靴を", "kutsu o", "靴を", "জুতো"), ("買いました", "kaimashita", "買いました", "কিনেছিলাম")]),
            make_item("jp-past-p2-l7-003", "喫茶店で コーヒーを 飲みました。", "きっさてんでこーひーをのみました。", "Kissaten de koohii o nomimashita.", "ক্যাফেতে কফি পান করেছিলাম।", "কিস্সাতেন দে কোওহিই ও নোমিমাশিতা।", [("喫茶店で", "kissaten de", "喫茶店で", "ক্যাফেতে"), ("コーヒーを", "koohii o", "コーヒーを", "কফি"), ("飲みました", "nomimashita", "飲みました", "পান করেছিলাম")])
        ]
    },
    {
        "id": "jp-past-l08",
        "order": 4,
        "title_bn": "৬-রূপান্তর ড্রিল: অতীত কাজ (Past Action 6 Transformations)",
        "title_target": "6 Sentence Transformations: Past Actions (Mashita / Masendeshita)",
        "intro_bn": "অতীত কাজ নিয়ে ৬টি রূপের দ্রুত স্পোকেন রূপান্তর ড্রিল।",
        "structure": ["Affirmative (+)", "Negative (-)", "Question (?)", "Negative Q (-?)", "WH-Q", "Alternative Q"],
        "items": [
            make_item("jp-past-p2-l8-001", "きのう 日本語を 勉強しました。", "きのうにほんごをべんきょうしました。", "Kinou nihongo o benkyou shimashita.", "১. হ্যাঁ-বোধক: গতকাল জাপানি ভাষা পড়েছিলাম।", "কিনোও নিহঙ্গো ও বেনকিওও শিমাশিতা।", item_type="drill"),
            make_item("jp-past-p2-l8-002", "きのう 日本語を 勉強しませんでした。", "きのうにほんごをべんきょうしませんでした。", "Kinou nihongo o benkyou shimasendeshita.", "২. না-বোধক: গতকাল জাপানি ভাষা পড়িনি।", "কিনোও নিহঙ্গো ও বেনকিওও শিমাসেনদেশিতা।", item_type="drill", polarity="negative"),
            make_item("jp-past-p2-l8-003", "きのう 日本語を 勉強しましたか。", "きのうにほんごをべんきょうしましたか。", "Kinou nihongo o benkyou shimashita ka.", "৩. প্রশ্নবোধক: গতকাল কি জাপানি ভাষা পড়েছিলেন?", "কিনোও নিহঙ্গো ও বেনকিওও শিমাশিতা কা?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-past-p2-l8-004", "きのう 日本語を 勉強しませんでしたか。", "きのうにほんごをべんきょうしませんでしたか。", "Kinou nihongo o benkyou shimasendeshita ka.", "৪. না-বোধক প্রশ্ন: গতকাল কি জাপানি ভাষা পড়েননি?", "কিনোও নিহঙ্গো ও বেনকিওও শিমাসেনদেশিতা কা?", item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-past-p2-l8-005", "きのう 何を しましたか。日本語を 勉強しました。", "きのうなにをしましたか。にほんごをべんきょうしました。", "Kinou nani o shimashita ka. Nihongo o benkyou shimashita.", "৫. WH-প্রশ্ন: গতকাল কী করেছিলেন? জাপানি ভাষা পড়েছিলাম।", "কিনোও নানি ও শিমাশিতা কা? নিহঙ্গো ও বেনকিওও শিমাশিতা।", item_type="drill", sentence_type="wh_question"),
            make_item("jp-past-p2-l8-006", "きのう 勉強しましたか、遊びましたか。", "きのうべんきょうしましたか、あそびましたか。", "Kinou benkyou shimashita ka, asobimashita ka.", "৬. বিকল্প প্রশ্ন: গতকাল কি পড়েছিলেন, নাকি ঘুরেছিলেন?", "কিনোও বেনকিওও শিমাশিতা কা, আসোবিমাশিতা কা?", item_type="drill", sentence_type="alternative_question")
        ]
    }
]
parts.append({
    "id": "jp-past-p2",
    "order": 2,
    "level": "A2",
    "title_bn": "অতীতের সমাপ্ত কাজ (Past Actions: 〜ました / 〜ませんでした)",
    "title_target": "Completed Past Actions (Mashita / Masendeshita)",
    "lessons": p2_lessons
})

# ==============================================================================
# PART 3: তে-ফর্ম সংযোগ ও ধারাবাহিক ঘটনা (Te-Form Mastery & Sequential Chains)
# ==============================================================================
p3_lessons = [
    {
        "id": "jp-past-l09",
        "order": 1,
        "title_bn": "তে-ফর্মের রূপান্তর সূত্র (Te-Form Conjugation Mastery)",
        "title_target": "Te-Form Conjugation (Group 1, 2, and Irregular Verbs)",
        "intro_bn": "জাপানিজ ক্রিয়ার সংযোগের মূল চাবিকাঠি হলো তে-ফর্ম (Te-form)। গ্রুপ ১ ক্রিয়ার শেষ ধ্বনি অনুসারে পরিবর্তন হয়: う・つ・る -> って, む・ぶ・ぬ -> んで, く -> いて, ぐ -> いで, す -> して। বিশেষ: 行く -> 行って।",
        "structure": [
            "Group 1: う・つ・る → って, む・ぶ・ぬ → んで, く → いて, ぐ → いで, す → して",
            "Group 2: る বাদ দিয়ে + て (食べる → 食べて, 見る → 見て)",
            "Irregular: する → して, 来る (くる) → 来て (きて)"
        ],
        "items": [
            make_item("jp-past-p3-l9-001", "買って、待って、帰って", "かって、まって、かえって", "Katte, matte, kaette", "কিনে, অপেক্ষা করে, বাড়ি ফিরে (う・つ・る → って)", "কাত্তে, মাত্তে, কায়েত্তে", [("買って", "katte", "買って", "কিনে (買う)"), ("待って", "matte", "待って", "অপেক্ষা করে (待つ)"), ("帰って", "kaette", "帰って", "ফিরে (帰る)")]),
            make_item("jp-past-p3-l9-002", "飲んで、呼んで、死んで", "のんで、よんで、しんで", "Nonde, yonde, shinde", "পান করে, ডেকে, মারা গিয়ে (む・ぶ・ぬ → んで)", "নোন্দে, ইয়োন্দে, শিন্দে", [("飲んで", "nonde", "飲んで", "পান করে (飲む)"), ("呼んで", "yonde", "呼んで", "ডেকে (呼ぶ)"), ("死んで", "shinde", "死んで", "মারা গিয়ে (死ぬ)")]),
            make_item("jp-past-p3-l9-003", "書いて、泳いで、話して、行って", "かいて、およいで、はなして、いって", "Kaite, oyoide, hanashite, itte", "লিখে, সাঁতার কেটে, কথা বলে, গিয়ে (く・ぐ・す ও 行く)", "কাইতে, ওয়োওইদে, হানাশিতে, ইত্তে", [("書いて", "kaite", "書いて", "লিখে (書く)"), ("泳いで", "oyoide", "泳いで", "সাঁতার কেটে (泳ぐ)"), ("話して", "hanashite", "話して", "কথা বলে (話す)"), ("行って", "itte", "行って", "গিয়ে (行く)")]),
            make_item("jp-past-p3-l9-004", "食べて、見て、して、来て", "たべて、みて、して、きて", "Tabete, mite, shite, kite", "খেয়ে, দেখে, করে, এসে (গ্রুপ ২ ও অনিয়মিত)", "তাবেতে, মিতে, শিতে, কিতে", [("食べて", "tabete", "食べて", "খেয়ে (食べる)"), ("見て", "mite", "見て", "দেখে (見る)"), ("して", "shite", "して", "করে (する)"), ("来て", "kite", "来て", "এসে (来る)")])
        ]
    },
    {
        "id": "jp-past-l10",
        "order": 2,
        "title_bn": "ধারাবাহিক কাজের শৃঙ্খল (Chaining Actions: 〜て、〜て、〜ました)",
        "title_target": "Chaining Sequential Past Actions (~te, ~te, ~mashita)",
        "intro_bn": "অতীতে একের পর এক একাধিক কাজ সম্পন্ন হলে ক্রিয়াপদগুলোকে তে-ফর্ম (Te-form) দিয়ে যুক্ত করে শেষ ক্রিয়াতে 'ました' বসে।",
        "structure": ["Verb 1-て、Verb 2-て、Verb 3-ました"],
        "items": [
            make_item("jp-past-p3-l10-001", "朝 ６時に 起きて、シャワーを 浴びて、学校へ 行きました。", "あさろくじにおきて、しゃわーをあびて、がっこうえいきました。", "Asa rokuji ni okite, shawaa o abite, gakkou e ikimashita.", "সকালে ৬টায় উঠে, গোসল করে, স্কুলে গিয়েছিলাম।", "আসা রোকুজি নি ওকিতে, শাওয়াআ ও আবিতে, গাক্কোও এ ইকিমাশিতা।", [("朝６時に", "asa rokuji ni", "朝６時に", "সকাল ৬টায়"), ("起きて", "okite", "起きて", "উঠে"), ("シャワーを浴びて", "shawaa o abite", "シャワーを浴びて", "গোসল করে"), ("学校へ行きました", "gakkou e ikimashita", "学校へ行きました", "স্কুলে গিয়েছিলাম")]),
            make_item("jp-past-p3-l10-002", "銀行へ 行って、お金を 下ろして、買い物に 行きました。", "ぎんこうえいって、おかねをおろして、かいものにいきました。", "Ginkou e itte, okane o oroshite, kaimono ni ikimashita.", "ব্যাংকে গিয়ে, টাকা তুলে, কেনাকাটা করতে গিয়েছিলাম।", "গিনকোও এ ইত্তে, ওকানে ও ওরোশিতে, কাইমোনো নি ইকিমাশিতা।", [("銀行へ行って", "ginkou e itte", "銀行へ行って", "ব্যাংকে গিয়ে"), ("お金を下ろして", "okane o oroshite", "お金を下ろして", "টাকা তুলে"), ("買い物に行きました", "kaimono ni ikimashita", "買い物に行きました", "কেনাকাটা করতে গিয়েছিলাম")]),
            make_item("jp-past-p3-l10-003", "図書館で 本を 借りて、家で 読みました。", "としょかんでほんをかりて、いえでよみました。", "Toshokan de hon o karite, ie de yomimashita.", "লাইব্রেরি থেকে বই ধার নিয়ে, বাড়িতে পড়েছিলাম।", "তোশোখান দে হোন ও কারিতে, ইয়ে দে ইয়োমিমাশিতা।", [("図書館で", "toshokan de", "図書館で", "লাইব্রেরিতে"), ("本を借りて", "hon o karite", "本を借りて", "বই ধার নিয়ে"), ("家で", "ie de", "家で", "বাড়িতে"), ("読みました", "yomimashita", "読みました", "পড়েছিলাম")])
        ]
    },
    {
        "id": "jp-past-l11",
        "order": 3,
        "title_bn": "কাজের নির্দিষ্ট ক্রম — '〜てから' ও '〜た後で'",
        "title_target": "Precise Action Order (~te kara / ~ta ato de)",
        "intro_bn": "একটি কাজ সম্পন্ন করার পর অপর কাজটি করা বোঝাতে 'Verb-て から' (A করার পর B) অথবা 'Verb-た 後で' (A সম্পন্ন হওয়ার পর B) বসে।",
        "structure": [
            "Verb 1-て から、Verb 2 (A করে তবেই B)",
            "Verb 1-た 後で、Verb 2 (A করার পরে B)"
        ],
        "items": [
            make_item("jp-past-p3-l11-001", "仕事を 終わってから、友だちに 会いました。", "しごとをおわってから、ともだちにあいました。", "Shigoto o owatte kara, tomodachi ni aimashita.", "কাজ শেষ করার পর বন্ধুর সাথে দেখা করেছিলাম।", "শিগোতো ও ওয়াত্তে কারা, তোমোদাচি নি আইমাশিতা।", [("仕事を", "shigoto o", "仕事を", "কাজ"), ("終わってから", "owatte kara", "終わってから", "শেষ করার পর"), ("友だちに", "tomodachi ni", "友だちに", "বন্ধুর সাথে"), ("会いました", "aimashita", "会いました", "দেখা করেছিলাম")]),
            make_item("jp-past-p3-l11-002", "ご飯を 食べた後で、薬を 飲みました。", "ごはんをたべたあとで、くすりをのみました。", "Gohan o tabeta ato de, kusuri o nomimashita.", "খাওয়ার পরে ওষুধ খেয়েছিলাম।", "গোহান ও তাবেতা আতো দে, কুসুরি ও নোমিমাশিতা।", [("ご飯を", "gohan o", "ご飯を", "ভাত/খাবার"), ("食べた後で", "tabeta ato de", "食べた後で", "খাওয়ার পরে"), ("薬を", "kusuri o", "薬を", "ওষুধ"), ("飲みました", "nomimashita", "飲みました", "খেয়েছিলাম")]),
            make_item("jp-past-p3-l11-003", "日本へ 来てから、ずっと 東京に 住んでいます。", "にほんえきてから、ずっととうきょうにすんでいます。", "Nihon e kite kara, zutto Toukyou ni sunde imasu.", "জাপানে আসার পর থেকে টানা টোকিওতে বসবাস করছি।", "নিহোন এ কিতে কারা, জুত্তো তোকিও নি সুন্দে ইমাসু।", [("日本へ来てから", "Nihon e kite kara", "日本へ来てから", "জাপানে আসার পর থেকে"), ("ずっと", "zutto", "ずっと", "টানা/একটানা"), ("東京に", "Toukyou ni", "東京に", "টোকিওতে"), ("住んでいます", "sunde imasu", "住んでいます", "বসবাস করছি")])
        ]
    }
]
parts.append({
    "id": "jp-past-p3",
    "order": 3,
    "level": "A2",
    "title_bn": "তে-ফর্ম সংযোগ ও ধারাবাহিক ঘটনা (Te-Form Mastery & Sequential Chains)",
    "title_target": "Te-Form Conjugation & Sequence (~te, ~te kara, ~ta ato de)",
    "lessons": p3_lessons
})

# ==============================================================================
# PART 4: অতীত ঘটমান ও কারণ ব্যাখ্যা (Past Continuous & Explaining Reasons)
# ==============================================================================
p4_lessons = [
    {
        "id": "jp-past-l12",
        "order": 1,
        "title_bn": "অতীত ঘটমান কাজ — 'Verb-て いました' (Past Continuous)",
        "title_target": "Past Continuous (Verb-te imashita)",
        "intro_bn": "অতীতে কোনো নির্দিষ্ট সময়ে কোনো কাজ চলছিল বোঝাতে 'Verb-て いました' (করছিলাম) বসে।",
        "structure": ["Subject + は + そのとき + Verb-て いました"],
        "items": [
            make_item("jp-past-p4-l12-001", "そのとき、わたしは ご飯を 食べて いました。", "そのとき、わたしわごはんをたべていました。", "Sono toki, watashi wa gohan o tabete imashita.", "সেই সময় আমি ভাত খাচ্ছিলাম।", "সোনো তোকি, ওয়াতাশি ওয়া গোহান ও তাবেতে ইমাশিতা।", [("そのとき", "sono toki", "その時", "সেই সময়"), ("わたしは", "watashi wa", "私は", "আমি"), ("ご飯を", "gohan o", "ご飯を", "ভাত"), ("食べていました", "tabete imashita", "食べていました", "খাচ্ছিলাম")], tense="past_continuous"),
            make_item("jp-past-p4-l12-002", "きのうの 午後３時に 何を して いましたか。図書館で 本を 読んで いました。", "きのうのごごさんじになにをしていましたか。としょかんでほんをよんでいました。", "Kinou no gogo sanji ni nani o shite imashita ka. Toshokan de hon o yonde imashita.", "গতকাল বিকেল ৩টায় কী করছিলেন? লাইব্রেরিতে বই পড়ছিলাম।", "কিনোও নো গোগো সানজি নি নানি ও শিতে ইমাশিতা কা? তোশোখান দে হোন ও ইয়োন্দে ইমাশিতা।", [("きのうの", "kinou no", "昨日の", "গতকালের"), ("午後３時に", "gogo sanji ni", "午後３時に", "বিকেল ৩টায়"), ("何をしていましたか", "nani o shite imashita ka", "何をしていましたか", "কী করছিলেন"), ("図書館で", "toshokan de", "図書館で", "লাইব্রেরিতে"), ("本を読んでいました", "hon o yonde imashita", "本を読んでいました", "বই পড়ছিলাম")], tense="past_continuous"),
            make_item("jp-past-p4-l12-003", "電話が あったとき、お風呂に 入って いました。", "でんわがあったとき、おふろにはいっていました。", "Denwa ga atta toki, ofuro ni haitte imashita.", "যখন ফোন এসেছিল, তখন গোসল করছিলাম।", "দেনওয়া গা আত্তা তোকি, অফুরো নি হাইত্তে ইমাশিতা।", [("電話があったとき", "denwa ga atta toki", "電話があった時", "ফোন আসার সময়"), ("お風呂に", "ofuro ni", "お風呂に", "গোসলখানায়/বাথটাবে"), ("入っていました", "haitte imashita", "入っていました", "গোসল করছিলাম")], tense="past_continuous")
        ]
    },
    {
        "id": "jp-past-l13",
        "order": 2,
        "title_bn": "অতীত কারণ ব্যাখ্যা — '〜から / 〜ので' (Explaining Reasons)",
        "title_target": "Giving Past Reasons (~kara / ~node)",
        "intro_bn": "অতীতে কোনো ঘটনা ঘটার বা না ঘটার কারণ ব্যাখ্যা করতে বাক্যের মাঝে '〜から' বা '〜ので' (কারণ/বলে) বসে।",
        "structure": ["Reason Sentence + から / ので、Result Sentence (Past)"],
        "items": [
            make_item("jp-past-p4-l13-001", "頭が 痛かったですから、会社を 休みました。", "あたまがいたかったですから、かいしゃをやすみました。", "Atama ga itakatta desu kara, kaisha o yasumimashita.", "মাথা ব্যথা করছিল বলে অফিস থেকে ছুটি নিয়েছিলাম।", "আতামা গা ইতাকাত্তা দেসু কারা, কাইশা ও ইয়াসুমিমাশিতা।", [("頭が痛かったですから", "atama ga itakatta desu kara", "頭が痛かったですから", "মাথা ব্যথা করছিল বলে"), ("会社を", "kaisha o", "会社を", "কোম্পানি/অফিস"), ("休みました", "yasumimashita", "休みました", "ছুটি নিয়েছিলাম")]),
            make_item("jp-past-p4-l13-002", "雨が 降って いましたので、タクシーで 行きました。", "あめがふっていましたので、たくしーでいきました。", "Ame ga futte imashita node, takushii de ikimashita.", "বৃষ্টি পড়ছিল বিধায় ট্যাক্সিতে গিয়েছিলাম।", "আমে গা ফুর্তে ইমাশিতা নোদে, তাকুশিই দে ইকিমাশিতা।", [("雨が降っていましたので", "ame ga futte imashita node", "雨が降っていましたので", "বৃষ্টি পড়ছিল বিধায়"), ("タクシーで", "takushii de", "タクシーで", "ট্যাক্সিতে"), ("行きました", "ikimashita", "行きました", "গিয়েছিলাম")]),
            make_item("jp-past-p4-l13-003", "時間が ありませんでしたから、朝ご飯を 食べませんでした。", "じかんがありませんでしたから、あさごはんをたべませんでした。", "Jikan ga arimasendeshita kara, asagohan o tabemasendeshita.", "সময় ছিল না বলে সকালের নাস্তা করিনি।", "জিকান গা আরিমাসেনদেশিতা কারা, আসাগোহান ও তাবেমাসেনদেশিতা।", [("時間がありませんでしたから", "jikan ga arimasendeshita kara", "時間がありませんでしたから", "সময় ছিল না বলে"), ("朝ご飯を", "asagohan o", "朝ご飯を", "সকালের নাস্তা"), ("食べませんでした", "tabemasendeshita", "食べませんでした", "খাইনি")], polarity="negative")
        ]
    },
    {
        "id": "jp-past-l14",
        "order": 3,
        "title_bn": "একই সাথে দুটি কাজ করা — '〜ながら' (Simultaneous Actions)",
        "title_target": "Simultaneous Actions (Verb-nagara)",
        "intro_bn": "একই সময়ে দুটি কাজ সম্পাদন করা বোঝাতে প্রথম ক্রিয়ার ます-stem এর সাথে 'ながら' বসে (যেমন: গান শুনতে শুনতে পড়াশোনা করা)।",
        "structure": ["Verb 1 (stem) + ながら + Verb 2"],
        "items": [
            make_item("jp-past-p4-l14-001", "音楽を 聞きながら 勉強しました。", "おんがくをききながらべんきょうしました。", "Ongaku o kikinagara benkyou shimashita.", "গান শুনতে শুনতে পড়াশোনা করেছিলাম।", "ওনগাকু ও কিকিনাগারা বেনকিওও শিমাশিতা।", [("音楽を", "ongaku o", "音楽を", "গান"), ("聞きながら", "kikinagara", "聞きながら", "শুনতে শুনতে"), ("勉強しました", "benkyou shimashita", "勉強しました", "পড়াশোনা করেছিলাম")]),
            make_item("jp-past-p4-l14-002", "テレビを 見ながら ご飯を 食べました。", "てれびをみながらごはんをたべました。", "Terebi o minagara gohan o tabemashita.", "টিভি দেখতে দেখতে খাবার খেয়েছিলাম।", "তেরেবি ও মনাগারা গোহান ও তাবেমাশিতা।", [("テレビを", "terebi o", "テレビを", "টিভি"), ("見ながら", "minagara", "見ながら", "দেখতে দেখতে"), ("ご飯を", "gohan o", "ご飯を", "খাবার"), ("食べました", "tabemashita", "食べました", "খেয়েছিলাম")]),
            make_item("jp-past-p4-l14-003", "友だちと コーヒーを 飲みながら 話しました。", "ともだちとこーひーをのみながらはなしました。", "Tomodachi to koohii o nominagara hanashimashita.", "বন্ধুর সাথে কফি খেতে খেতে কথা বলেছিলাম।", "তোমোদাচি তো কোওহিই ও নোমিনাঘারা হানাশিমাশিতা।", [("友だちと", "tomodachi to", "友だちと", "বন্ধুর সাথে"), ("コーヒーを飲みながら", "koohii o nominagara", "コーヒーを飲みながら", "কফি পান করতে করতে"), ("話しました", "hanashimashita", "話しました", "কথা বলেছিলাম")])
        ]
    }
]
parts.append({
    "id": "jp-past-p4",
    "order": 4,
    "level": "A2",
    "title_bn": "অতীত ঘটমান ও কারণ ব্যাখ্যা (Past Continuous & Explaining Reasons)",
    "title_target": "Past Continuous, Reasons & Simultaneous Actions (~te imashita / ~kara / ~nagara)",
    "lessons": p4_lessons
})

# ==============================================================================
# PART 5: জীবনের অভিজ্ঞতা প্রকাশ (Life Experiences: 〜たことがあります)
# ==============================================================================
p5_lessons = [
    {
        "id": "jp-past-l15",
        "order": 1,
        "title_bn": "জীবনের অভিজ্ঞতা জিজ্ঞাসা — '〜たことが ありますか'",
        "title_target": "Asking About Life Experiences (Have you ever...?)",
        "intro_bn": "জীবনে কখনো কোনো কিছু করার অভিজ্ঞতা আছে কি না জানতে ক্রিয়াপদের Ta-form এর সাথে '〜ことがありますか' বসে (Have you ever...?)।",
        "structure": ["Verb (Ta-form) + ことが ありますか (Have you ever done...?)"],
        "items": [
            make_item("jp-past-p5-l15-001", "日本へ 行ったことが ありますか。", "にほんえいったことがありますか。", "Nihon e itta koto ga arimasu ka.", "আপনি কি কখনো জাপানে গিয়েছেন?", "নিহোন এ ইত্তা কোতো গা আরিমাসু কা?", [("日本へ", "Nihon e", "日本へ", "জাপানে"), ("行ったことが", "itta koto ga", "行ったことが", "যাওয়ার বিষয়"), ("ありますか", "arimasu ka", "ありますか", "অভিজ্ঞতা আছে কি")]),
            make_item("jp-past-p5-l15-002", "すしを 食べたことが ありますか。", "すしをたべたことがありますか。", "Sushi o tabeta koto ga arimasu ka.", "আপনি কি কখনো সুশি খেয়েছেন?", "সুশি ও তাবেতা কোতো গা আরিমাসু কা?", [("すしを", "sushi o", "すしを", "সুশি"), ("食べたことが", "tabeta koto ga", "食べたことが", "খাওয়ার অভিজ্ঞতা"), ("ありますか", "arimasu ka", "ありますか", "আছে কি")]),
            make_item("jp-past-p5-l15-003", "富士山に 登ったことが ありますか。", "ふじさんにのぼったことがありますか。", "Fujisan ni nobotta koto ga arimasu ka.", "আপনি কি কখনো ফুজি পাহাড়ে চড়েছেন?", "ফুজি-সান নি নোবোত্তা কোতো গা আরিমাসু কা?", [("富士山に", "Fujisan ni", "富士山に", "ফুজি পর্বতে"), ("登ったことが", "nobotta koto ga", "登ったことが", "আরোহণের অভিজ্ঞতা"), ("ありますか", "arimasu ka", "ありますか", "আছে কি")])
        ]
    },
    {
        "id": "jp-past-l16",
        "order": 2,
        "title_bn": "হ্যাঁ-বোধক ও না-বোধক অভিজ্ঞতা (Affirmative & Negative Experience)",
        "title_target": "Sharing Past Experiences (I have / I have never)",
        "intro_bn": "অভিজ্ঞতা থাকলে '〜たことが あります' (Yes, I have) এবং না থাকলে '一度も〜たことが ありません' (একবারও না) বলতে হয়।",
        "structure": [
            "Affirmative: はい、Verb-たことが あります",
            "Negative: いいえ、一度も Verb-たことが ありません"
        ],
        "items": [
            make_item("jp-past-p5-l16-001", "はい、日本へ 行ったことが あります。二度 行きました。", "はい、にほんえいったことがあります。にどいきました。", "Hai, Nihon e itta koto ga arimasu. Nido ikimashita.", "হ্যাঁ, জাপানে যাওয়ার অভিজ্ঞতা আছে। দুইবার গিয়েছিলাম।", "হাই, নিহোন এ ইত্তা কোতো গা আরিমাসু। নিদো ইকিমাশিতা।", [("はい", "hai", "はい", "হ্যাঁ"), ("日本へ行ったことが", "Nihon e itta koto ga", "日本へ行ったことが", "জাপানে যাওয়ার অভিজ্ঞতা"), ("あります", "arimasu", "あります", "আছে"), ("二度", "nido", "二度", "দুইবার"), ("行きました", "ikimashita", "行きました", "গিয়েছিলাম")]),
            make_item("jp-past-p5-l16-002", "いいえ、一度も 食べたことが ありません。食べて みたいです。", "いいえ、いちどもたべたことがありません。たべてみたいです。", "Iie, ichido mo tabeta koto ga arimasen. Tabete mitai desu.", "না, একবারও খাইনি। খেয়ে দেখতে চাই।", "ইইয়ে, ইচিদো মো তাবেতা কোতো গা আরিমাসেন। তাবেতে মিতাই দেস।", [("いいえ", "iie", "いいえ", "না"), ("一度も", "ichido mo", "一度も", "একবারও"), ("食べたことがありません", "tabeta koto ga arimasen", "食べたことがありません", "খাওয়ার অভিজ্ঞতা নেই"), ("食べてみたいです", "tabete mitai desu", "食べてみたいです", "খেয়ে দেখতে চাই")], polarity="negative"),
            make_item("jp-past-p5-l16-003", "着物を 着て、京都を 歩いたことが あります。", "きものをきて、きょうとをおあるいたことがあります。", "Kimono o kite, Kyouto o aruita koto ga arimasu.", "কিমোনো পরে কিয়োটোতে হাঁটার অভিজ্ঞতা রয়েছে।", "কিমোনো ও কিতে, কিওওতো ও আরুইতা কোতো গা আরিমাসু।", [("着物を着て", "kimono o kite", "着物を着て", "কিমোনো পরিধান করে"), ("京都を", "Kyouto o", "京都を", "কিয়োটোতে"), ("歩いたことが", "aruita koto ga", "歩いたことが", "হাঁটার অভিজ্ঞতা"), ("あります", "arimasu", "あります", "আছে")])
        ]
    },
    {
        "id": "jp-past-l17",
        "order": 3,
        "title_bn": "নানা কাজের নমুনা তালিকা — '〜たり、〜たり しました'",
        "title_target": "Listing Multiple Activities (~tari, ~tari shimashita)",
        "intro_bn": "ছুটির দিনে নানা রকম কাজের উদাহরণ দিতে 'Verb 1-たり、Verb 2-たり しました' বসে (Doing things like A and B)।",
        "structure": ["Verb 1-たり、Verb 2-たり + しました"],
        "items": [
            make_item("jp-past-p5-l17-001", "休みの日は 買い物を したり、映画を 見たり しました。", "やすみのひわかいものをしたり、えいがをみたりしました。", "Yasumi no hi wa kaimono o shitari, eiga o mitari shimashita.", "ছুটির দিনে কেনাকাটা করা, সিনেমা দেখা ইত্যাদি করেছিলাম।", "ইয়াসুমি নো হি ওয়া কাইমোনো ও শিতারি, এইগা ও মিতারি শিমাশিতা।", [("休みの日は", "yasumi no hi wa", "休みの日は", "ছুটির দিনে"), ("買い物をしたり", "kaimono o shitari", "買い物をしたり", "কেনাকাটা করা"), ("映画を見たり", "eiga o mitari", "映画を見たり", "সিনেমা দেখা"), ("しました", "shimashita", "しました", "ইত্যাদি করেছিলাম")]),
            make_item("jp-past-p5-l17-002", "京都で お寺を 見たり、温泉に 入ったり しました。", "きょうとでおてらをみたり、おんせんにはいったりしました。", "Kyouto de otera o mitari, onsen ni haittari shimashita.", "কিয়োটোতে মন্দির পরিদর্শন, উষ্ণ প্রস্রবণে গোসল ইত্যাদি করেছিলাম।", "কিওওতো দে ওতেরা ও মিতারি, ওনসেন নি হাইত্তারি শিমাশিতা।", [("京都で", "Kyouto de", "京都で", "কিয়োটোতে"), ("お寺を見たり", "otera o mitari", "お寺を見たり", "মন্দির দেখা"), ("温泉に入ったり", "onsen ni haittari", "温泉に入ったり", "উষ্ণ প্রস্রবণে গোসল করা"), ("しました", "shimashita", "しました", "ইত্যাদি করেছিলাম")])
        ]
    }
]
parts.append({
    "id": "jp-past-p5",
    "order": 5,
    "level": "A2",
    "title_bn": "জীবনের অভিজ্ঞতা প্রকাশ (Life Experiences: 〜たことがあります)",
    "title_target": "Life Experiences & Representative Activities (~ta koto ga arimasu / ~tari)",
    "lessons": p5_lessons
})

# ==============================================================================
# PART 6: উপকার, প্রস্তুতি, সমাপ্তি ও পরীক্ষা (Favors, Preparation & Completion)
# ==============================================================================
p6_lessons = [
    {
        "id": "jp-past-l18",
        "order": 1,
        "title_bn": "উপকার আদান-প্রদান — '〜てあげました / 〜てくれました / 〜てもらいました'",
        "title_target": "Giving & Receiving Favors (~te agemashita / kuremashita / moraimashita)",
        "intro_bn": "কাউকে উপকার করে দিলে '〜てあげました', অন্য কেউ আমাকে উপকার করে দিলে '〜てくれました', এবং কারও কাছ থেকে উপকার করিয়ে নিলে '〜てもらいました' বসে।",
        "structure": [
            "Person に + Verb-て あげました (আমি অন্যকে করে দিলাম)",
            "Person が + Verb-て くれました (অন্য কেউ আমাকে করে দিল)",
            "Person に + Verb-て もらいました (অন্য কারও কাছ থেকে করিয়ে নিলাম)"
        ],
        "items": [
            make_item("jp-past-p6-l18-001", "妹に 日本語を 教えて あげました。", "いもうとににほんごをおしえてあげました。", "Imouto ni nihongo o oshiete agemashita.", "ছোট বোনকে জাপানি ভাষা শিখিয়ে দিয়েছিলাম।", "ইমোওতো নি নিহঙ্গো ও ওশিয়েতে আগেমাশিতা।", [("妹に", "imouto ni", "妹に", "ছোট বোনকে"), ("日本語を", "nihongo o", "日本語を", "জাপানি ভাষা"), ("教えてあげました", "oshiete agemashita", "教えてあげました", "শিখিয়ে দিয়েছিলাম")]),
            make_item("jp-past-p6-l18-002", "友だちが 引っ越しを 手伝って くれました。", "ともだちがひっこしをてつだってくれました。", "Tomodachi ga hikkoshi o tetsudatte kuremashita.", "বন্ধু আমাকে বাসা বদলের কাজে সাহায্য করেছে।", "তোমোদাচি গা হিক্কোশি ও তেতসুদাত্তে কুরেমাশিতা।", [("友だちが", "tomodachi ga", "友だちが", "বন্ধু"), ("引っ越しを", "hikkoshi o", "引っ越しを", "বাসা বদল"), ("手伝ってくれました", "tetsudatte kuremashita", "手伝ってくれました", "সাহায্য করেছে")]),
            make_item("jp-past-p6-l18-003", "先生に 作文を 直して もらいました。", "せんせいにさくぶんをなおしてもらいました。", "Sensei ni sakubun o naoshite moraimashita.", "শিক্ষকের কাছ থেকে রচনা সংশোধন করিয়ে নিয়েছি।", "সেনসেই নি সাকুবুন ও নাওশিতে মোরাইমাশিতা।", [("先生に", "sensei ni", "先生に", "শিক্ষকের নিকট হতে"), ("作文を", "sakubun o", "作文を", "রচনা"), ("直してもらいました", "naoshite moraimashita", "直してもらいました", "সংশোধন করিয়ে নিয়েছি")])
        ]
    },
    {
        "id": "jp-past-l19",
        "order": 2,
        "title_bn": "সম্পূর্ণ সমাপ্তি ও অনিচ্ছাকৃত ভুল — '〜て しまいました'",
        "title_target": "Completion & Regret (~te shimaimashita)",
        "intro_bn": "কোনো কাজ পুরোপুরি শেষ করে ফেলা অথবা অনিচ্ছাকৃত কোনো অপ্রীতিকর ভুল ঘটে যাওয়া প্রকাশে '〜て しまいました' বসে।",
        "structure": ["Verb-て + しまいました (পুরোপুরি শেষ হলো / ভুলবশত ঘটল)"],
        "items": [
            make_item("jp-past-p6-l19-001", "この 本を 全部 読んで しまいました。", "このほんをぜんぶよんでしまいました。", "Kono hon o zenbu yonde shimaimashita.", "এই বইটি সম্পূর্ণ পড়ে শেষ করে ফেলেছি।", "কোনো হোন ও জেনবু ইয়োন্দে শিমাইমাশিতা।", [("この本を", "kono hon o", "この本を", "এই বইটি"), ("全部", "zenbu", "全部", "সম্পূর্ণ/পুরো"), ("読んでしまいました", "yonde shimaimashita", "読んでしまいました", "পড়ে শেষ করেছি")]),
            make_item("jp-past-p6-l19-002", "電車に 傘を 忘れて しまいました。", "でんしゃにかさをわすれてしまいました。", "Densha ni kasa o wasurete shimaimashita.", "ট্রেনে ছাতা ভুলে ফেলে এসেছি। (অনিচ্ছাকৃত ভুল)", "দেনশা নি কাসা ও ওয়াসুরেতে শিমাইমাশিতা।", [("電車に", "densha ni", "電車に", "ট্রেনে"), ("傘を", "kasa o", "傘を", "ছাতা"), ("忘れてしまいました", "wasurete shimaimashita", "忘れてしまいました", "ভুলে ফেলে এসেছি")]),
            make_item("jp-past-p6-l19-003", "パスポートを なくして しまいました。大変です。", "ぱすぽーとをなくしてしまいました。たいへんです。", "Pasupooto o nakushite shimaimashita. Taihen desu.", "পাসপোর্ট হারিয়ে ফেলেছি। মহাবিপদ!", "পাসুপোওতো ও নাকুশিতে শিমাইমাশিতা। তাইহেন দেস।", [("パスポートを", "pasupooto o", "パスポートを", "পাসপোর্ট"), ("なくしてしまいました", "nakushite shimaimashita", "なくしてしまいました", "হারিয়ে ফেলেছি"), ("大変です", "taihen desu", "大変です", "মহাবিপদ!")])
        ]
    },
    {
        "id": "jp-past-l20",
        "order": 3,
        "title_bn": "পূর্বপ্রস্তুতি ও পরখ করে দেখা — '〜ておきました' ও '〜てみました'",
        "title_target": "Preparation & Trial Actions (~te okimashita / ~te mimashita)",
        "intro_bn": "ভবিষ্যতের সুবিধার জন্য আগে থেকে কিছু প্রস্তুত করে রাখলে '〜ておきました' এবং কোনো কিছু পরখ বা ট্রায়াল করে দেখলে '〜てみました' বসে।",
        "structure": [
            "Verb-て + おきました (আগে থেকে প্রস্তুত করে রেখেছিলাম)",
            "Verb-て + みました (চেষ্টা বা পরখ করে দেখলাম)"
        ],
        "items": [
            make_item("jp-past-p6-l20-001", "旅行の 前に ホテルを 予約して おきました。", "りょこうのまえにほてるをよやくしておきました。", "Ryokou no mae ni hoteru o yoyaku shite okimashita.", "ভ্রমণের আগে হোটেল বুকিং করে রেখেছিলাম।", "রিওকোও নো মায়ে নি হোতেরু ও ইয়োয়াকু শিতে ওকিমাশিতা।", [("旅行の前に", "ryokou no mae ni", "旅行の前に", "ভ্রমণের পূর্বে"), ("ホテルを", "hoteru o", "ホテルを", "হোটেল"), ("予約しておきました", "yoyaku shite okimashita", "予約しておきました", "বুকিং করে রেখেছিলাম")]),
            make_item("jp-past-p6-l20-002", "日本の 納豆を 初めて 食べて みました。", "にほんのなっとうをはじめてたべてみました。", "Nihon no nattou o hajimete tabete mimashita.", "প্রথমবারের মতো জাপানি নাত্তো খেয়ে দেখলাম।", "নিহোন নো নাত্তোও ও হাজিমেতে তাবেতে মিমাশিতা।", [("日本の納豆を", "Nihon no nattou o", "日本の納豆を", "জাপানের নাত্তো"), ("初めて", "hajimete", "初めて", "প্রথমবারের মতো"), ("食べてみました", "tabete mimashita", "食べてみました", "খেয়ে দেখলাম")]),
            make_item("jp-past-p6-l20-003", "会議の 資料を もう コピーして おきました。", "かいぎのしりょうをもうこぴーしておきました。", "Kaigi no shiryou o mou kopii shite okimashita.", "মিটিংয়ের কাগজপত্র আগেই ফটোকপি করে রেখেছি।", "কাইগি নো শিরিওও ও মোও কোপিই শিতে ওকিমাশিতা।", [("会議の資料を", "kaigi no shiryou o", "会議の資料を", "মিটিংয়ের দলিলপত্র"), ("もう", "mou", "もう", "ইতিমধ্যে"), ("コピーしておきました", "kopii shite okimashita", "コピーしておきました", "ফটোকপি করে রেখেছি")])
        ]
    },
    {
        "id": "jp-past-l21",
        "order": 4,
        "title_bn": "অনুমতি ও নিষেধের অতীত অভিজ্ঞতা — '〜てもよかったです / 〜てはいけませんでした'",
        "title_target": "Past Permission & Prohibition (~te mo yokatta desu / ~te wa ikemasen deshita)",
        "intro_bn": "অতীতে কোনো কাজ করার অনুমতি ছিল ('〜てもよかったです') অথবা সম্পূর্ণ নিষেধ ছিল ('〜てはいけませんでした') প্রকাশ করার নিয়ম।",
        "structure": [
            "Verb-て + もよかったです (করার অনুমতি ছিল)",
            "Verb-て + はいけませんでした (করা একেবারেই নিষেধ ছিল)"
        ],
        "items": [
            make_item("jp-past-p6-l21-001", "美術館で 写真を 撮っても よかったです。", "びじゅつかんでしゃしんをとってもよかったです。", "Bijutsukan de shashin o totte mo yokatta desu.", "জাদুঘরে ছবি তোলার অনুমতি ছিল।", "বিজুতসুকান দে শাশিন ও তোত্তে মো ইয়োকাত্তা দেশিতা।", [("美術館で", "bijutsukan de", "美術館で", "শিল্পকলা জাদুঘরে"), ("写真を", "shashin o", "写真を", "ছবি"), ("撮ってもよかったです", "totte mo yokatta desu", "撮ってもよかったです", "তোলা ঠিক ছিল/অনুমোদন ছিল")]),
            make_item("jp-past-p6-l21-002", "試験のとき、辞書を 使っては いけませんでした。", "しけんのとき、じしょをつかってわいけませんでした。", "Shiken no toki, jisho o tsukatte wa ikemasen deshita.", "পরীক্ষার সময় অভিধান ব্যবহার করা সম্পূর্ণ নিষেধ ছিল।", "শিকেন নো তোকি, জিশো ও তসুকাত্তে ওয়া ইকেমাসেন দেশিতা।", [("試験のとき", "shiken no toki", "試験の時", "পরীক্ষার সময়"), ("辞書を", "jisho o", "辞書を", "অভিধান"), ("使ってはいけませんでした", "tsukatte wa ikemasen deshita", "使ってはいけませんでした", "ব্যবহার করা নিষেধ ছিল")], polarity="negative")
        ]
    }
]
parts.append({
    "id": "jp-past-p6",
    "order": 6,
    "level": "A2",
    "title_bn": "উপকার, প্রস্তুতি, সমাপ্তি ও পরীক্ষা (Favors, Preparation & Completion)",
    "title_target": "Favors, Preparation & Completion (~te ageru/kureru/morau, ~te shimau, ~te oku, ~te miru)",
    "lessons": p6_lessons
})

# ==============================================================================
# PART 7: অতীত ইন্টারেক্টিভ সংলাপ ও ৬-রূপান্তর ড্রিল (Dialogues & 6-Way Drill)
# ==============================================================================
p7_lessons = [
    {
        "id": "jp-past-l22",
        "order": 1,
        "title_bn": "গতকালের দৈনন্দিন কাজের সংলাপ (Yesterday's Routine Dialogue)",
        "title_target": "Yesterday's Routine (Interactive Spoken Dialogue)",
        "intro_bn": "গতকাল সারাদিনের কার্যক্রম নিয়ে পারস্পরিক সাবলীল প্রশ্ন ও উত্তরের সংলাপ।",
        "structure": ["Q: きのう 何を しましたか", "A: 朝〜て、昼〜て、夜〜ました"],
        "items": [
            make_item("jp-past-p7-l22-001", "Ａ：きのうの 休日は 何を しましたか。 Ｂ：朝 掃除を して、午後 友だちと 映画を 見に 行きました。", "きのうのきゅうじつわなにをしましたか。あさそうじをして、ごごともだちとえいがをみにいきました。", "A: Kinou no kyuujitsu wa nani o shimashita ka. B: Asa souji o shite, gogo tomodachi to eiga o mi ni ikimashita.", "A: গতকালের ছুটির দিনে কী করেছিলেন? B: সকালে ঘর পরিষ্কার করে, বিকেলে বন্ধুর সাথে সিনেমা দেখতে গিয়েছিলাম।", "এ: কিনোও নো কিউউজিতসু ওয়া নানি ও শিমাশিতা কা? বি: আসা সোওজি ও শিতে, গোগো তোমোদাচি তো এইগা ও মি নি ইকিমাশিতা।", item_type="dialogue"),
            make_item("jp-past-p7-l22-002", "Ａ：映画は 面白かったですか。 Ｂ：はい、とても 面白かったです。感動しました。", "えいがわおもしろかったですか。はい、とてもおもしろかったです。かんどうしました。", "A: Eiga wa omoshirokatta desu ka. B: Hai, totemo omoshirokatta desu. Kandou shimashita.", "A: সিনেমাটি কি উপভোগ্য ছিল? B: হ্যাঁ, ভীষণ উপভোগ্য ছিল। মন ছুঁয়ে গেছে।", "এ: এইগা ওয়া ওমোশিরোকাত্তা দেশিতা কা? বি: হাই, তোতেমো ওমোশিরোকাত্তা দেশিতা। কানদোও শিমাশিতা।", item_type="dialogue")
        ]
    },
    {
        "id": "jp-past-l23",
        "order": 2,
        "title_bn": "ভ্রমণ ও অতীত স্মৃতি কথন (Travel & Life Memory Dialogue)",
        "title_target": "Travel Experience & Memory (Interactive Dialogue)",
        "intro_bn": "জাপানে ভ্রমণ ও অতীতের সুন্দর মুহূর্ত নিয়ে কথোপকথন ড্রিল।",
        "structure": ["Q: どこへ 行きましたか。どうでしたか", "A: 〜へ 行きました。とても〜かったです"],
        "items": [
            make_item("jp-past-p7-l23-001", "Ａ：先週 どこへ 行きましたか。 Ｂ：京都へ 行きました。お寺を 見たり、美味しい 和菓子を 食べたり しました。", "せんしゅうどこえいきましたか。きょうとえいきました。おてらをみたり、おいしいわがしをたべたりしました。", "A: Senshuu doko e ikimashita ka. B: Kyouto e ikimashita. Otera o mitari, oishii wagashi o tabetari shimashita.", "A: গত সপ্তাহে কোথায় গিয়েছিলেন? B: কিয়োটোতে গিয়েছিলাম। মন্দির পরিদর্শন ও সুস্বাদু ঐতিহ্যবাহী মিষ্টি উপভোগ করেছি।", "এ: সেনশুউ দোকো এ ইকিমাশিতা কা? বি: কিওওতো এ ইকিমাশিতা। ওতেরা ও মিতারি, ওইশিই ওয়াগাশি ও তাবেতারি শিমাশিতা।", item_type="dialogue"),
            make_item("jp-past-p7-l23-002", "Ａ：また 行きたいですか。 Ｂ：はい、もう一度 行きたいです。とても 綺麗でしたから。", "またいきたいですか。はい、もういちどいきたいです。とてもきれいでしたから。", "A: Mata ikitai desu ka. B: Hai, mou ichido ikitai desu. Totemo kirei deshita kara.", "A: আবার যেতে চান? B: হ্যাঁ, আরেকবার যেতে চাই। কারণ পরিবেশটি অত্যন্ত মনোরম ছিল।", "এ: মাতা ইকিতাই দেস কা? বি: হাই, মোও ইচিদো ইকিতাই দেস। তোতেমো কিরেয় দেশিতা কারা।", item_type="dialogue")
        ]
    },
    {
        "id": "jp-past-l24",
        "order": 3,
        "title_bn": "অতীত ৬-রূপান্তর চূড়ান্ত মাস্টার ড্রিল (Master 6-Way Oral Transformation)",
        "title_target": "Master 6-Way Transformation Drill: Past Experience & Actions",
        "intro_bn": "অতীত কালের যেকোনো বাক্যকে পলকের মধ্যে ৬টি ভিন্ন রূপে রূপান্তরের চূড়ান্ত প্র্যাকটিস।",
        "structure": [
            "১. হ্যাঁ-বোধক (+): 日本へ 行きました。",
            "২. না-বোধক (-): 日本へ 行きませんでした。",
            "৩. প্রশ্নবোধক (?): 日本へ 行きましたか。",
            "৪. না-বোধক প্রশ্ন (-?): 日本へ 行きませんでしたか。",
            "৫. WH-প্রশ্ন (WH?): いつ 日本へ 行きましたか。",
            "৬. বিকল্প প্রশ্ন (Alt?): 日本へ 行きましたか、韓国へ 行きましたか。"
        ],
        "items": [
            make_item("jp-past-p7-l24-001", "日本へ 行きました。", "にほんえいきました。", "Nihon e ikimashita.", "১. হ্যাঁ-বোধক: জাপানে গিয়েছিলাম।", "নিহোন এ ইকিমাশিতা।", item_type="drill"),
            make_item("jp-past-p7-l24-002", "日本へ 行きませんでした。", "にほんえいきませんでした。", "Nihon e ikimasendeshita.", "২. না-বোধক: জাপানে যাইনি।", "নিহোন এ ইকিমাসেনদেশিতা।", item_type="drill", polarity="negative"),
            make_item("jp-past-p7-l24-003", "日本へ 行きましたか。", "にほんえいきましたか。", "Nihon e ikimashita ka.", "৩. প্রশ্নবোধক: জাপানে গিয়েছিলেন কি?", "নিহোন এ ইকিমাশিতা কা?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-past-p7-l24-004", "日本へ 行きませんでしたか。", "にほんえいきませんでしたか。", "Nihon e ikimasendeshita ka.", "৪. না-বোধক প্রশ্ন: জাপানে কি যাননি?", "নিহোন এ ইকিমাসেনদেশিতা কা?", item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-past-p7-l24-005", "いつ 日本へ 行きましたか。去年 行きました。", "いつにほんえいきましたか。きょねんいきました。", "Itsu Nihon e ikimashita ka. Kyonen ikimashita.", "৫. WH-প্রশ্ন: কবে জাপানে গিয়েছিলেন? গত বছর গিয়েছিলাম।", "ইতসু নিহোন এ ইকিমাশিতা কা? কিওনেন ইকিমাশিতা।", item_type="drill", sentence_type="wh_question"),
            make_item("jp-past-p7-l24-006", "日本へ 行きましたか、韓国へ 行きましたか。", "にほんえいきましたか、かんこくえいきましたか。", "Nihon e ikimashita ka, Kankoku e ikimashita ka.", "৬. বিকল্প প্রশ্ন: জাপানে গিয়েছিলেন, নাকি দক্ষিণ কোরিয়ায় গিয়েছিলেন?", "নিহোন এ ইকিমাশিতা কা, কানকোকু এ ইকিমাশিতা কা?", item_type="drill", sentence_type="alternative_question")
        ]
    }
]
parts.append({
    "id": "jp-past-p7",
    "order": 7,
    "level": "A2",
    "title_bn": "অতীত ইন্টারেক্টিভ সংলাপ ও ৬-রূপান্তর ড্রিল (Dialogues & 6-Way Drill)",
    "title_target": "Interactive Past Dialogues & Master 6-Way Transformation Drill",
    "lessons": p7_lessons
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

print(f"Course 2 successfully built and saved to: {DEST_FILE}")
print(f"Total Parts: {len(parts)}")
print(f"Total Lessons: {total_lessons}")
print(f"Total Items: {total_items}")
