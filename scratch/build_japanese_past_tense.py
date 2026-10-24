# -*- coding: utf-8 -*-
"""
Builder for Course 2: Japanese Spoken Past & Experience (JLPT N5/N4)
Generates: android/app/src/main/assets/spoken_japanese_past_tense.json
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
    "title_bn": "জাপানিজ স্পোকেন: Past Tense (অতীত কাল ও অভিজ্ঞতা)",
    "title_target": "Spoken Japanese: Past Tense & Life Experience",
    "source": "Curated from N5-N4 Japanese Study Series & Spoken English Framework",
    "note": "অতীতের অবস্থা ও পরিচয় (でした/ではありませんでした), অতীত কাজ (〜ました/〜ませんでした), অতীত ঘটমান (〜ていました), জীবনের অভিজ্ঞতা (〜たことがあります), সম্পূর্ণতা (〜てしまいました), এবং অতীত ৬-রূপান্তর ড্রিল।",
    "welcome_text": "জাপানিজ স্পোকেন Past Tense মাস্টারক্লাসে স্বাগতম! অতীতের স্মৃতি, ঘটে যাওয়া ঘটনা ও জীবনের অভিজ্ঞতা সাবলীল জাপানিজে প্রকাশ করার অনুশীলন শুরু করুন।"
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
        "intro_bn": "অতীতে কেউ কী ছিল বা কোনো কিছু কী ছিল তা বোঝাতে 'でした' (deshita - ছিল) এবং না-বোধক করতে 'ではありませんでした' (ছিল না) বসে।",
        "structure": [
            "Affirmative: Noun + でした (ছিল)",
            "Negative: Noun + ではありませんでした / じゃありませんでした (ছিল না)"
        ],
        "items": [
            make_item("jp-past-p1-l1-001", "きのうは やすみでした。", "きのうわやすみでした。", "Kinou wa yasumi deshita.", "গতকাল ছুটি ছিল।", "কিনোও ওয়া ইয়াসুমি দেশিতা।", [("きのう", "kinou", "昨日", "গতকাল"), ("は", "wa", "は", "হল"), ("やすみ", "yasumi", "休み", "ছুটি"), ("でした", "deshita", "でした", "ছিল")]),
            make_item("jp-past-p1-l1-002", "かれは きょねん だいがくせいでして。", "かれわきょねんだいがくせいでした。", "Kare wa kyonen daigakusei deshita.", "সে গত বছর বিশ্ববিদ্যালয়ের ছাত্র ছিল।", "কারে ওয়া কিওনেন দাইগাকুসেই দেশিতা।", [("かれ", "kare", "彼", "সে"), ("は", "wa", "は", "হল"), ("きょねん", "kyonen", "去年", "গত বছর"), ("だいがくせい", "daigakusei", "大学生", "বিশ্ববিদ্যালয়ের ছাত্র"), ("でした", "deshita", "でした", "ছিল")]),
            make_item("jp-past-p1-l1-003", "きのうは げつようびじゃ ありませんでした。にちようびでした。", "きのうわげつようびじゃありませんでした。にちようびでした。", "Kinou wa getsuyoubi ja arimasen deshita. Nichiyoubi deshita.", "গতকাল সোমবার ছিল না। রবিবার ছিল।", "কিনোও ওয়া গেতসুয়োওবি জা আরিমাসেন দেশিতা। নিচিয়োওবি দেশিতা।", [("きのう", "kinou", "昨日", "গতকাল"), ("は", "wa", "は", "হল"), ("げつようび", "getsuyoubi", "月曜日", "সোমবার"), ("じゃ ありませんでした", "ja arimasen deshita", "じゃありませんでした", "ছিল না"), ("にちようび", "nichiyoubi", "日曜日", "রবিবার"), ("でした", "deshita", "でした", "ছিল")], polarity="negative"),
            make_item("jp-past-p1-l1-004", "おとといは あめでしたか。いいえ、はれでした。", "おとといわあめでしたか。いいえ、はれでした。", "Ototoi wa ame deshita ka. Iie, hare deshita.", "গত পরশু কি বৃষ্টি ছিল? না, রৌদ্রোজ্জ্বল ছিল।", "ওতোতোই ওয়া আমে দেশিতা কা? ইইয়ে, হারে দেশিতা।")
        ]
    },
    {
        "id": "jp-past-l02",
        "order": 2,
        "title_bn": "い-বিশেষণের অতীত রূপ (i-Adjectives: 〜かったです / 〜くなかったです)",
        "title_target": "Past i-Adjectives (~katta desu / ~kunakatta desu)",
        "intro_bn": "i-Adjective এর অতীত রূপ করতে শেষের 'い' উঠে 'かったです' (katta desu) এবং না-বোধক করতে 'くなかったです' (kunakatta desu) বসে। যেমন: あつい (গরম) -> あつかったです (গরম ছিল)।",
        "structure": [
            "Affirmative: Stem + かったです (ছিল)",
            "Negative: Stem + くなかったです (ছিল না)"
        ],
        "items": [
            make_item("jp-past-p1-l2-001", "きのうは とても あつかったです。", "きのうわとてもあつかったです。", "Kinou wa totemo atsukatta desu.", "গতকাল খুব গরম ছিল।", "কিনোও ওয়া তোতেমো আতসুDefault দেশিতা।", [("きのう", "kinou", "昨日", "গতকাল"), ("は", "wa", "は", "হল"), ("とても", "totemo", "とても", "খুব"), ("あつかったです", "atsukatta desu", "暑かったです", "গরম ছিল")]),
            make_item("jp-past-p1-l2-002", "せんしゅうの りょこうは たのしかったです。", "せんしゅうのりょこうわたのしかったです。", "Senshuu no ryokou wa tanoshikatta desu.", "গত সপ্তাহের ভ্রমণ আনন্দদায়ক ছিল।", "সেনশুউ নো রিওকোও ওয়া তানোশিকাত্তা দেশিতা।", [("せんしゅう", "senshuu", "先週", "গত সপ্তাহ"), ("の", "no", "の", "এর"), ("りょこう", "ryokou", "旅行", "ভ্রমণ"), ("は", "wa", "は", "হল"), ("たのしかったです", "tanoshikatta desu", "楽しかったです", "আনন্দদায়ক ছিল")]),
            make_item("jp-past-p1-l2-003", "きのうの テストは あまり むずかしくなかったです。", "きのうのてすとわあまりむずかしくなかったです。", "Kinou no tesuto wa amari muzukashikunakatta desu.", "গতকালের পরীক্ষাটি খুব একটা কঠিন ছিল না।", "কিনোও নো তেসুতো ওয়া আমারি মুজুকাশিকুনাকাত্তা দেশিতা।", [("きのう", "kinou", "昨日", "গতকাল"), ("の", "no", "の", "এর"), ("テスト", "tesuto", "テスト", "পরীক্ষা"), ("は", "wa", "は", "হল"), ("あまり", "amari", "あまり", "তেমন"), ("むずかしくなかったです", "muzukashikunakatta desu", "難しくなかったです", "কঠিন ছিল না")], polarity="negative"),
            make_item("jp-past-p1-l2-004", "きのうの えいがは おもしろかったですか。はい、とても おもしろかったです。", "きのうのえいがわおもしろかったですか。はい、とてもおもしろかったです。", "Kinou no eiga wa omoshirokatta desu ka. Hai, totemo omoshirokatta desu.", "গতকালের সিনেমাটি কি মজার ছিল? হ্যাঁ, খুব মজার ছিল।", "কিনোও নো এইগা ওয়া ওমোশিরোকাত্তা দেশিতা কা? হাই, তোতেমো ওমোশিরোকাত্তা দেশিতা।")
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
            make_item("jp-past-p1-l3-001", "きょねん このまちは とても しずかでした。", "きょねんこのまちわとてもしずかでした。", "Kyonen kono machi wa totemo shizuka deshita.", "গত বছর এই শহরটি খুব শান্ত ছিল।", "কিওনেন কোনো মাচি ওয়া তোতেমো শিজুকা দেশিতা।", [("きょねん", "kyonen", "去年", "গত বছর"), ("この", "kono", "この", "এই"), ("まち", "machi", "町", "শহর"), ("は", "wa", "は", "হল"), ("とても", "totemo", "とても", "খুব"), ("しずかでした", "shizuka deshita", "静かでした", "শান্ত ছিল")]),
            make_item("jp-past-p1-l3-002", "きのうの パーティーは とても にぎやかでした。", "きのうのぱーてぃーわとてもにぎやかでした。", "Kinou no paatii wa totemo nigiyaka deshita.", "গতকালের পার্টিটি খুব জমজমাট ও মুখরিত ছিল।", "কিনোও নো পাতিই ওয়া তোতেমো নিগিয়াকা দেশিতা।", [("きのう", "kinou", "昨日", "গতকাল"), ("の", "no", "の", "এর"), ("パーティー", "paatii", "パーティー", "পার্টি"), ("は", "wa", "は", "হল"), ("にぎやかでした", "nigiyaka deshita", "賑やかでした", "জমজমাট ছিল")]),
            make_item("jp-past-p1-l3-003", "きのうは ひまじゃ ありませんでした。とても いそがしかったです。", "きのうわひまじゃありませんでした。とてもいそがしかったです。", "Kinou wa hima ja arimasen deshita. Totemo isogashikatta desu.", "গতকাল অবসর ছিল না। খুব ব্যস্ত ছিলাম।", "কিনোও ওয়া হিমা জা আরিমাসেন দেশিতা। তোতেমো ইসোগাশিকাত্তা দেশিতা।", polarity="negative")
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
            make_item("jp-past-p1-l4-001", "きのうの てんきは よかったです。", "きのうのてんきわよかったです。", "Kinou no tenki wa yokatta desu.", "১. হ্যাঁ-বোধক: গতকালের আবহাওয়া ভালো ছিল।", "কিনোও নো তেনকি ওয়া ইয়োকাত্তা দেশিতা।", item_type="drill"),
            make_item("jp-past-p1-l4-002", "きのうの てんきは よくなかったです。", "きのうのてんきわよくなかったです。", "Kinou no tenki wa yokunakatta desu.", "২. না-বোধক: গতকালের আবহাওয়া ভালো ছিল না।", "কিনোও নো তেনকি ওয়া ইয়োকুনাকাত্তা দেশিতা।", item_type="drill", polarity="negative"),
            make_item("jp-past-p1-l4-003", "きのうの てんきは よかったですか。", "きのうのてんきわよかったですか。", "Kinou no tenki wa yokatta desu ka.", "৩. প্রশ্নবোধক: গতকালের আবহাওয়া কি ভালো ছিল?", "কিনোও নো তেনকি ওয়া ইয়োকাত্তা দেশিতা কা?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-past-p1-l4-004", "きのうの てんきは よくありませんでしたか。", "きのうのてんきわよくありませんでしたか。", "Kinou no tenki wa yoku arimasen deshita ka.", "৪. না-বোধক প্রশ্ন: গতকালের আবহাওয়া কি ভালো ছিল না?", "কিনোও নো তেনকি ওয়া ইয়োকু আরিমাসেন দেশিতা কা?", item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-past-p1-l4-005", "きのうの てんきは どうでしたか。あめでした。", "きのうのてんきわどうでしたか。あめでした。", "Kinou no tenki wa dou deshita ka. Ame deshita.", "৫. WH-প্রশ্ন: গতকালের আবহাওয়া কেমন ছিল? বৃষ্টি ছিল।", "কিনোও নো তেনকি ওয়া দোও দেশিতা কা? আমে দেশিতা।", item_type="drill", sentence_type="wh_question"),
            make_item("jp-past-p1-l4-006", "きのうは あつかったですか、さむかったですか。", "きのうわあつかったですか、さむかったですか。", "Kinou wa atsukatta desu ka, samukatta desu ka.", "৬. বিকল্প প্রশ্ন: গতকাল কি গরম ছিল, নাকি ঠান্ডা ছিল?", "কিনোও ওয়া আতসুকাত্তা দেশিতা কা, সামুকাত্তা দেশিতা কা?", item_type="drill", sentence_type="alternative_question")
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
            make_item("jp-past-p2-l5-001", "わたしは きのう ８じかん ねました。", "わたしわきのうはちじかんねました。", "Watashi wa kinou hachijikan nemashita.", "আমি গতকাল ৮ ঘণ্টা ঘুমিয়েছি।", "ওয়াতাশি ওয়া কিনোও হাচিজিকান নেমাশিতা।"),
            make_item("jp-past-p2-l5-002", "あさ ７じに あさごはんを たべました。", "あさしちじにあさごはんをたべました。", "Asa shichiji ni asagohan o tabemashita.", "সকাল ৭টায় নাস্তা খেয়েছিলাম।", "আসা শিচিজি নি আসাগোহান ও তাবেমাশিতা।"),
            make_item("jp-past-p2-l5-003", "きのう にほんごの ほんを よみました。", "きのうにほんごのほんをよみました。", "Kinou nihongo no hon o yomimashita.", "গতকাল জাপানি বই পড়েছিলাম।", "কিনোও নিহঙ্গো নো হোন ও ইয়োমিমাশিতা।"),
            make_item("jp-past-p2-l5-004", "きのう ともだちと サッカーを しました。", "きのうともだちとさっかーをしました。", "Kinou tomodachi to sakkaa o shimashita.", "গতকাল বন্ধুর সাথে ফুটবল খেলেছি।", "কিনোও তোমোদাচি তো সাক্কাআ ও শিমাশিতা।")
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
            make_item("jp-past-p2-l6-001", "けさ なにも たべませんでした。", "けさなにもたべませんでした。", "Kesa nani mo tabemasendeshita.", "আজ সকালে কিছুই খাইনি।", "কেসা নানি মো তাবেমাসেনদেশিতা।", polarity="negative"),
            make_item("jp-past-p2-l6-002", "きのうは どこへも いきませんでした。", "きのうわどこえもいきませんでした。", "Kinou wa doko e mo ikimasendeshita.", "গতকাল কোথাও যাইনি।", "কিনোও ওয়া দোকো এ মো ইকিমাসেনদেশিতা।", polarity="negative"),
            make_item("jp-past-p2-l6-003", "ゆうべ テレビを みませんでした。はやく ねました。", "ゆうべてれびをみませんでした。はやくねました。", "Yuube terebi o mimasendeshita. Hayaku nemashita.", "গত রাতে টিভি দেখিনি। তাড়াতাড়ি ঘুমিয়েছিলাম।", "ইউউবে তেরেবি ও মিমাসেনদেশিতা। হায়াকু নেমাশিতা।", polarity="negative")
        ]
    },
    {
        "id": "jp-past-l07",
        "order": 3,
        "title_bn": "অতীত কাজের স্থান ও মাধ্যম (Past Location & Means)",
        "title_target": "Past Location & Vehicle (Place de / Vehicle de)",
        "intro_bn": "অতীতে কোথায় এবং কীভাবে কাজ করেছি তা প্রকাশ করতে 'で' (de) বসে।",
        "structure": ["Vehicle で + Place へ + 行きました", "Place で + Action を + しました"],
        "items": [
            make_item("jp-past-p2-l7-001", "しんかんせんで きょうとへ いきました。", "しんかんせんできょうとえいきました。", "Shinkansen de Kyouto e ikimashita.", "বুলেট ট্রেনে করে কিয়োটো গিয়েছিলাম।", "শিনকানসেন দে কিওওতো এ ইকিমাশিতা।"),
            make_item("jp-past-p2-l7-002", "デパートで あたらしい くつを かいました。", "でぱーとであたらしいくつをかいました。", "Depaato de atarashii kutsu o kaimashita.", "ডিপার্টমেন্টাল স্টোরে নতুন জুতো কিনেছিলাম।", "দেপাতো দে আতারাসিই কুৎসু ও কাইমাশিতা।"),
            make_item("jp-past-p2-l7-003", "きっさてんで コーヒーを のみました。", "きっさてんでこーひーをのみました。", "Kissaten de koohii o nomimashita.", "ক্যাফেতে কফি পান করেছিলাম।", "কিস্সাতেন দে কোওহিই ও নোমিমাশিতা।")
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
            make_item("jp-past-p2-l8-001", "きのう にほんごを べんきょうしました。", "きのうにほんごをべんきょうしました。", "Kinou nihongo o benkyou shimashita.", "১. হ্যাঁ-বোধক: গতকাল জাপানি ভাষা পড়েছিলাম।", "কিনোও নিহঙ্গো ও বেনকিওও শিমাশিতা।", item_type="drill"),
            make_item("jp-past-p2-l8-002", "きのう にほんごを べんきょうしませんでした。", "きのうにほんごをべんきょうしませんでした。", "Kinou nihongo o benkyou shimasendeshita.", "২. না-বোধক: গতকাল জাপানি ভাষা পড়িনি।", "কিনোও নিহঙ্গো ও বেনকিওও শিমাসেনদেশিতা।", item_type="drill", polarity="negative"),
            make_item("jp-past-p2-l8-003", "きのう にほんごを べんきょうしましたか。", "きのうにほんごをべんきょうしましたか。", "Kinou nihongo o benkyou shimashita ka.", "৩. প্রশ্নবোধক: গতকাল কি জাপানি ভাষা পড়েছিলেন?", "কিনোও নিহঙ্গো ও বেনকিওও শিমাশিতা কা?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-past-p2-l8-004", "きのう にほんごを べんきょうしませんでしたか。", "きのうにほんごをべんきょうしませんでしたか。", "Kinou nihongo o benkyou shimasendeshita ka.", "৪. না-বোধক প্রশ্ন: গতকাল কি জাপানি ভাষা পড়েননি?", "কিনোও নিহঙ্গো ও বেনকিওও শিমাসেনদেশিতা কা?", item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-past-p2-l8-005", "きのう なにを しましたか。にほんごを べんきょうしました。", "きのうなにをしましたか。にほんごをべんきょうしました。", "Kinou nani o shimashita ka. Nihongo o benkyou shimashita.", "৫. WH-প্রশ্ন: গতকাল কী করেছিলেন? জাপানি ভাষা পড়েছিলাম।", "কিনোও নানি ও শিমাশিতা কা? নিহঙ্গো ও বেনকিওও শিমাশিতা।", item_type="drill", sentence_type="wh_question"),
            make_item("jp-past-p2-l8-006", "きのう べんきょうしましたか、あそびましたか。", "きのうべんきょうしましたか、あそびましたか。", "Kinou benkyou shimashita ka, asobimashita ka.", "৬. বিকল্প প্রশ্ন: গতকাল কি পড়েছিলেন, নাকি ঘুরেছিলেন?", "কিনোও বেনকিওও শিমাশিতা কা, আসোবিমাশিতা কা?", item_type="drill", sentence_type="alternative_question")
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
# PART 3: অতীত ঘটমান ও কারণ ব্যাখ্যা (Past Continuous & Explaining Reasons)
# ==============================================================================
p3_lessons = [
    {
        "id": "jp-past-l09",
        "order": 1,
        "title_bn": "অতীত ঘটমান কাজ — 'Verb-て いました' (Past Continuous)",
        "title_target": "Past Continuous (Verb-te imashita)",
        "intro_bn": "অতীতে কোনো নির্দিষ্ট সময়ে কোনো কাজ চলছিল বোঝাতে 'Verb-て いました' (করছিলাম) বসে।",
        "structure": ["Subject + は + そのとき + Verb-て いました"],
        "items": [
            make_item("jp-past-p3-l9-001", "そのとき、わたしは ごはんを たべて いました。", "そのとき、わたしわごはんをたべていました。", "Sono toki, watashi wa gohan o tabete imashita.", "সেই সময় আমি ভাত খাচ্ছিলাম।", "সোনো তোকি, ওয়াতাশি ওয়া গোহান ও তাবেতে ইমাশিতা।", tense="past_continuous"),
            make_item("jp-past-p3-l9-002", "きのうの ごご ３じに なにを して いましたか。としょかんで ほんを よんで いました。", "きのうのごごさんじになにをしていましたか。としょかんでほんをよんでいました。", "Kinou no gogo sanji ni nani o shite imashita ka. Toshokan de hon o yonde imashita.", "গতকাল বিকেল ৩টায় কী করছিলেন? লাইব্রেরিতে বই পড়ছিলাম।", "কিনোও নো গোগো সানজি নি নানি ও শিতে ইমাশিতা কা? তোশোখান দে হোন ও ইয়োন্দে ইমাশিতা।", tense="past_continuous"),
            make_item("jp-past-p3-l9-003", "でんわが あったとき、おふろに はいって いました。", "でんわがあったとき、おふろにはいっていました。", "Denwa ga atta toki, ofuro ni haitte imashita.", "যখন ফোন এসেছিল, তখন গোসল করছিলাম।", "দেনওয়া গা আত্তা তোকি, অফুরো নি হাইত্তে ইমাশিতা।", tense="past_continuous")
        ]
    },
    {
        "id": "jp-past-l10",
        "order": 2,
        "title_bn": "অতীত কারণ ব্যাখ্যা — '〜から / 〜ので' (Explaining Reasons)",
        "title_target": "Giving Past Reasons (~kara / ~node)",
        "intro_bn": "অতীতে কোনো ঘটনা ঘটার বা না ঘটার কারণ ব্যাখ্যা করতে বাক্যের মাঝে '〜から' বা '〜ので' (কারণ/বলে) বসে।",
        "structure": ["Reason Sentence + から / ので、Result Sentence (Past)"],
        "items": [
            make_item("jp-past-p3-l10-001", "あたまが いたかったですから、かいしゃを やすみました。", "あたまがいたかったですから、かいしゃをやすみました。", "Atama ga itakatta desu kara, kaisha o yasumimashita.", "মাথা ব্যথা করছিল বলে অফিস থেকে ছুটি নিয়েছিলাম।", "আত閲া গা ইতাকাত্তা দেসু কারা, কাইশা ও ইয়াসুমিমাশিতা।"),
            make_item("jp-past-p3-l10-002", "あめが ふって いましたので、タクシーで いきました。", "あめがふっていましたので、たくしーでいきました。", "Ame ga futte imashita node, takushii de ikimashita.", "বৃষ্টি পড়ছিল বিধায় ট্যাক্সিতে গিয়েছিলাম।", "আমে গা ফdistributionত্তে ইমাশিতা নোদে, তাকুশিই দে ইকিমাশিতা।"),
            make_item("jp-past-p3-l10-003", "じかんが ありませんでしたから、あさごはんを たべませんでした。", "じかんがありませんでしたから、あさごはんをたべませんでした。", "Jikan ga arimasendeshita kara, asagohan o tabemasendeshita.", "সময় ছিল না বলে সকালের নাস্তা করিনি।", "জিকান গা আরিমাসেনদেশিতা কারা, আসাগোহান ও তাবেমাসেনদেশিতা।", polarity="negative")
        ]
    },
    {
        "id": "jp-past-l11",
        "order": 3,
        "title_bn": "ধারাবাহিক অতীত ঘটনা (Sequential Actions: Verb-て、Verb-て、Verb-ました)",
        "title_target": "Chaining Past Actions (~te, ~te, ~mashita)",
        "intro_bn": "অতীতে একের পর এক একাধিক কাজ সম্পন্ন হলে ক্রিয়াপদগুলোকে তে-ফর্ম (Te-form) দিয়ে যুক্ত করে শেষ ক্রিয়াতে 'ました' বসে।",
        "structure": ["Verb 1-て、Verb 2-て、Verb 3-ました"],
        "items": [
            make_item("jp-past-p3-l11-001", "あさ ６じに おきて、シャワーを あびて、がっこうへ いきました。", "あさろくじにおきて、しゃわーをあびて、がっこうえいきました。", "Asa rokuji ni okite, shawaa o abite, gakkou e ikimashita.", "সকালে ৬টায় উঠে, গোসল করে, স্কুলে গিয়েছিলাম।", "আসা রোকুজি নি ওকিতে, শাওয়াআ ও আবিতে, গাক্কোও এ ইকিমাশিতা।"),
            make_item("jp-past-p3-l11-002", "ぎんこうへ いって、おかねを おろして、かいものに いきました。", "ぎんこうえいって、おかねをおろして、かいものにいきました。", "Ginkou e itte, okane o oroshite, kaimono ni ikimashita.", "ব্যাংকে গিয়ে, টাকা তুলে, কেনাকাটা করতে গিয়েছিলাম।", "গিনকোও এ ইত্তে, ওকানে ও ওরোশিতে, কাইমোনো নি ইকিমাশিতা।")
        ]
    }
]
parts.append({
    "id": "jp-past-p3",
    "order": 3,
    "level": "A2",
    "title_bn": "অতীত ঘটমান ও কারণ ব্যাখ্যা (Past Continuous & Explaining Reasons)",
    "title_target": "Past Continuous & Causal Explanations (~te imashita / ~kara)",
    "lessons": p3_lessons
})

# ==============================================================================
# PART 4: জীবনের অভিজ্ঞতা প্রকাশ (Life Experiences: 〜たことがあります)
# ==============================================================================
p4_lessons = [
    {
        "id": "jp-past-l12",
        "order": 1,
        "title_bn": "জীবনের অভিজ্ঞতা জিজ্ঞাসা — '〜たことが ありますか'",
        "title_target": "Asking About Life Experiences (Have you ever...?)",
        "intro_bn": "জীবনে কখনো কোনো কিছু করার অভিজ্ঞতা আছে কি না জানতে ক্রিয়াপদের Ta-form এর সাথে '〜ことがありますか' বসে (Have you ever...?)।",
        "structure": ["Verb (Ta-form) + ことが ありますか (Have you ever done...?)"],
        "items": [
            make_item("jp-past-p4-l12-001", "にほんへ いったことが ありますか。", "にほんえいったことがありますか。", "Nihon e itta koto ga arimasu ka.", "আপনি কি কখনো জাপানে গিয়েছেন?", "নিহোন এ ইত্তা কোতো গা আরিমাসু কা?"),
            make_item("jp-past-p4-l12-002", "すしを たべたことが ありますか。", "すしをたべたことがありますか。", "Sushi o tabeta koto ga arimasu ka.", "আপনি কি কখনো সুশি খেয়েছেন?", "সুশি ও তাবেতা কোতো গা আরিমাসু কা?"),
            make_item("jp-past-p4-l12-003", "ふじさんに のぼったことが ありますか。", "ふじさんにのぼったことがありますか。", "Fuji-san ni nobotta koto ga arimasu ka.", "আপনি কি কখনো ফুজি পাহাড়ে চড়েছেন?", "ফুজি-সান নি নোবোত্তা কোতো গা আরিমাসু কা?")
        ]
    },
    {
        "id": "jp-past-l13",
        "order": 2,
        "title_bn": "হ্যাঁ-বোধক ও না-বোধক অভিজ্ঞতা (Affirmative & Negative Experience)",
        "title_target": "Sharing Past Experiences (I have / I have never)",
        "intro_bn": "অভিজ্ঞতা থাকলে '〜たことが あります' (Yes, I have) এবং না থাকলে 'いちども ありません' (একবারও না) বলতে হয়।",
        "structure": [
            "Affirmative: はい、Verb-たことが あります",
            "Negative: いいえ、いちども Verb-たことが ありません"
        ],
        "items": [
            make_item("jp-past-p4-l13-001", "はい、にほんへ いったことが あります。にど いきました。", "はい、にほんえいったことがあります。にどいきました。", "Hai, Nihon e itta koto ga arimasu. Nido ikimashita.", "হ্যাঁ, জাপানে যাওয়ার অভিজ্ঞতা আছে। দুইবার গিয়েছিলাম।", "হাই, নিহোন এ ইত্তা কোতো গা আরিমাসু। নিদো ইকিমাশিতা।"),
            make_item("jp-past-p4-l13-002", "いいえ、いちども たべたことが ありません。たべて みたいです。", "いいえ、いちどもたべたことがありません。たべてみたいです。", "Iie, ichido mo tabeta koto ga arimasen. Tabete mitai desu.", "না, একবারও খাইনি। খেয়ে দেখতে চাই।", "ইইয়ে, ইচিদো মো তাবেতা কোতো গা আরিমাসেন। তাবেতে মিতাই দেস।", polarity="negative"),
            make_item("jp-past-p4-l13-003", "きもので あるいたことが あります。", "きものであるいたことがあります。", "Kimono de aruita koto ga arimasu.", "কিমোনো পরিধান করে হাঁটার অভিজ্ঞতা রয়েছে।", "কিমোনো দে আরুইতা কোতো গা আরিমাসু।")
        ]
    },
    {
        "id": "jp-past-l14",
        "order": 3,
        "title_bn": "নানা কাজের নমুনা তালিকা — '〜たり、〜たり しました'",
        "title_target": "Listing Multiple Activities (~tari, ~tari shimashita)",
        "intro_bn": "ছুটির দিনে নানা রকম কাজের উদাহরণ দিতে 'Verb 1-たり、Verb 2-たり しました' বসে (Doing things like A and B)।",
        "structure": ["Verb 1-たり、Verb 2-たり + しました"],
        "items": [
            make_item("jp-past-p4-l14-001", "やすみの ひは かいものを したり、えいがを みたり しました。", "やすみのひわかいものをしたり、えいがをみたりしました。", "Yasumi no hi wa kaimono o shitari, eiga o mitari shimashita.", "ছুটির দিনে কেনাকাটা করা, সিনেমা দেখা ইত্যাদি করেছিলাম।", "ইয়াসুমি নো হি ওয়া কাইমোনো ও শিতারি, এইগা ও মিতারি শিমাশিতা।"),
            make_item("jp-past-p4-l14-002", "きょうとで おてらを みたり、おんせんに はいったり しました。", "きょうとでおてらをみたり、おんせんにはいったりしました。", "Kyouto de otera o mitari, onsen ni haittari shimashita.", "কিয়োটোতে মন্দির পরিদর্শন, উষ্ণ প্রস্রবণে গোসল ইত্যাদি করেছিলাম।", "কিওওতো দে ওতেরা ও মিতারি, ওনসেন নি হাইত্তারি শিমাশিতা।")
        ]
    }
]
parts.append({
    "id": "jp-past-p4",
    "order": 4,
    "level": "A2",
    "title_bn": "জীবনের অভিজ্ঞতা প্রকাশ (Life Experiences: 〜たことがあります)",
    "title_target": "Life Experiences & Activity Lists (~ta koto ga arimasu / ~tari)",
    "lessons": p4_lessons
})

# ==============================================================================
# PART 5: কাজ সম্পন্নের অনুভূতি ও অনিচ্ছাকৃত ভুল (Completed Actions: 〜てしまいました)
# ==============================================================================
p5_lessons = [
    {
        "id": "jp-past-l15",
        "order": 1,
        "title_bn": "ইতিমধ্যে সমাপ্ত কাজ — 'もう〜ました' (Already Finished)",
        "title_target": "Recently Completed Actions (Mou Verb-mashita)",
        "intro_bn": "কোনো কাজ ইতিমধ্যে শেষ হয়েছে বোঝাতে 'もう〜ました' (already done) এবং এখনও হয়নি বোঝাতে 'まだです' বসে।",
        "structure": [
            "Q: もう Verb-ましたか",
            "A1: はい、もう Verb-ました (Yes, already done)",
            "A2: いいえ、まだです (No, not yet)"
        ],
        "items": [
            make_item("jp-past-p5-l15-001", "もう ひるごはんを たべましたか。はい、もう たべました。", "もうひるごはんをたべましたか。はい、もうたべました。", "Mou hirugohan o tabemashita ka. Hai, mou tabemashita.", "ইতিমধ্যে দুপুরের খাবার খেয়েছেন কি? হ্যাঁ, খেয়ে নিয়েছি।", "মোও হিরুগোহান ও তাবেমাশিতা কা? হাই, মোও তাবেমাশিতা।"),
            make_item("jp-past-p5-l15-002", "しゅくだいは もう おわりましたか。いいえ、まだです。これから します。", "しゅくだいわもうおわりましたか。いいえ、まだです。これからします。", "Shukudai wa mou owarimashita ka. Iie, mada desu. Kore kara shimasu.", "বাড়ির কাজ কি ইতিমধ্যে শেষ হয়েছে? না, এখনও হয়নি। এখন করব।", "শুকুদ্বাই ওয়া মোও ওয়ারিমাশিতা কা? ইইয়ে, মাদা দেস। কোরে কারা শিমাসু।", polarity="negative")
        ]
    },
    {
        "id": "jp-past-l16",
        "order": 2,
        "title_bn": "সম্পূর্ণ সমাপ্তি ও অনিচ্ছাকৃত ভুল — '〜て しまいました'",
        "title_target": "Completion & Regret (~te shimaimashita)",
        "intro_bn": "কোনো কাজ সম্পূর্ণ শেষ করা বা কোনো অপ্রত্যাশিত ভুল ঘটে যাওয়া প্রকাশে '〜て しまいました' বসে।",
        "structure": ["Verb-て + しまいました (পুরোপুরি শেষ হলো / ভুলবশত ঘটল)"],
        "items": [
            make_item("jp-past-p5-l16-001", "この ほんを ぜんぶ よんで しまいました。", "このほんをぜんぶよんでしまいました。", "Kono hon o zenbu yonde shimaimashita.", "এই বইটি সম্পূর্ণ পড়ে শেষ করে ফেলেছি।", "কোনো হোন ও জেনবু ইয়োন্দে শিমাইমাশিতা।"),
            make_item("jp-past-p5-l16-002", "電車に かさを わすれて しまいました。", "でんしゃにかさをわすれてしまいました。", "Densha ni kasa o wasurete shimaimashita.", "ট্রেনে ছাতা ভুলে ফেলে এসেছি। (অনিচ্ছাকৃত ভুল)", "দেনশা নি কাসা ও ওয়াসুরেতে শিমাইমাশিতা।"),
            make_item("jp-past-p5-l16-003", "パスポートを なくして しまいました。たいへんです。", "ぱすぽーとをなくしてしまいました。たいへんです。", "Pasupooto o nakushite shimaimashita. Taihen desu.", "পাসপোর্ট হারিয়ে ফেলেছি। মহাবিপদ!", "পাসুপোওতো ও নাকুশিতে শিমাইমাশিতা। তাইহেন দেস।")
        ]
    }
]
parts.append({
    "id": "jp-past-p5",
    "order": 5,
    "level": "A2",
    "title_bn": "কাজ সম্পন্নের অনুভূতি ও অনিচ্ছাকৃত ভুল (Completed Actions & Regret)",
    "title_target": "Completed Actions & Regret (Mou ... mashita / ~te shimaimashita)",
    "lessons": p5_lessons
})

# ==============================================================================
# PART 6: অতীত অভ্যাস ও স্মৃতি (Past Habits & Recollections)
# ==============================================================================
p6_lessons = [
    {
        "id": "jp-past-l17",
        "order": 1,
        "title_bn": "অতীতের অভ্যাস ও স্মৃতি — 'よく〜ました' (Past Habits: Used to)",
        "title_target": "Past Habits & Recollection (Yoku Verb-mashita)",
        "intro_bn": "অতীতে নিয়মিত কোনো কাজ করতাম বোঝাতে 'よく〜ました' (Used to do regularly) বসে।",
        "structure": ["こどものとき、よく + Verb-ました"],
        "items": [
            make_item("jp-past-p6-l17-001", "こどものとき、よく かわで およぎました。", "こどものとき、よくかわでおよぎました。", "Kodomo no toki, yoku kawa de oyogimashita.", "ছোটবেলায় নদীতে প্রায়ই সাঁতার কাটতাম।", "কোদোমো নো তোকি, ইয়োকু কাওয়া দে ওয়োগিমাশিতা।"),
            make_item("jp-past-p6-l17-002", "がくせいのとき、まいばん おそくまで べんきょうしました。", "がくせいのとき、まいばんおそくまでべんきょうしました。", "Gakusei no toki, maiban osoku made benkyou shimashita.", "ছাত্রাবস্থায় প্রতি রাতে গভীর রাত পর্যন্ত পড়াশোনা করতাম।", "গাকুসেই নো তোকি, মাইবান ওসোকু মাদে বেনকিওও শিমাশিতা।")
        ]
    },
    {
        "id": "jp-past-l18",
        "order": 2,
        "title_bn": "যখন অতীতে কোনো ঘটনা ঘটেছিল — '〜とき' (When... in the past)",
        "title_target": "Past Time Clauses (~toki)",
        "intro_bn": "অতীতে কোনো নির্দিষ্ট সময়ে কী ঘটেছিল তা প্রকাশ করতে 'Noun の とき' বা 'Verb-た とき' বসে।",
        "structure": ["Past Verb / Noun の + とき、Result Sentence (Past)"],
        "items": [
            make_item("jp-past-p6-l18-001", "にほんへ いったとき、さくらを みました。", "にほんえいったとき、さくらをみました。", "Nihon e itta toki, sakura o mimashita.", "যখন জাপানে গিয়েছিলাম, তখন চেরি ফুল দেখেছিলাম।", "নিহোন এ ইত্তা তোকি, সাকুরা ও মিমাশিতা।"),
            make_item("jp-past-p6-l18-002", "ひまなとき、よく おんがくを ききました。", "ひまなとき、よくおんがくをききました。", "Hima na toki, yoku ongaku o kikimashita.", "অবসর সময়ে প্রায়ই গান শুনতাম।", "হিমা না তোকি, ইয়োকু ওনগাকু ও কিকিমাশিতা।")
        ]
    }
]
parts.append({
    "id": "jp-past-p6",
    "order": 6,
    "level": "A2",
    "title_bn": "অতীত অভ্যাস ও স্মৃতি (Past Habits & Recollections)",
    "title_target": "Past Habits & Time Clauses (Yoku ~mashita / ~toki)",
    "lessons": p6_lessons
})

# ==============================================================================
# PART 7: অতীত ইন্টারেক্টিভ ভয়েস পেয়ার প্র্যাকটিস (Past Voice Q&A)
# ==============================================================================
p7_lessons = [
    {
        "id": "jp-past-l19",
        "order": 1,
        "title_bn": "গতকালের কাজ নিয়ে পেয়ার ড্রিল (Yesterday's Schedule Voice Q&A)",
        "title_target": "Yesterday's Schedule (Pair Practice)",
        "intro_bn": "মাইক্রোফোনে ট্যাপ করে গতকালের কাজ নিয়ে প্রশ্ন শুনুন এবং উত্তর দিন।",
        "structure": ["Q: きのう なにを しましたか", "A: [Action] を しました"],
        "items": [
            make_item("jp-past-p7-l19-001", "きのうは なにを しましたか。いえで にほんごを べんきょうしました。", "きのうわなにをしましたか。いえでにほんごをべんきょうしました。", "Kinou wa nani o shimashita ka. Ie de nihongo o benkyou shimashita.", "গতকাল কী করেছিলেন? বাড়িতে জাপানি ভাষা পড়েছিলাম।", "কিনোও ওয়া নানি ও শিমাশিতা কা? ইয়ে দে নিহঙ্গো ও বেনকিওও শিমাশিতা।", item_type="dialogue"),
            make_item("jp-past-p7-l19-002", "きのうは なんじに ねましたか。１２じに ねました。", "きのうわなんじにねましたか。じゅうにじにねました。", "Kinou wa nanji ni nemashita ka. Juuniji ni nemashita.", "গতকাল কয়টায় ঘুমিয়েছিলেন? ১২টায় ঘুমিয়েছিলাম।", "কিনোও ওয়া নানজি নি নেমাশিতা কা? জুউনিজি নি নেমাশিতা।", item_type="dialogue")
        ]
    },
    {
        "id": "jp-past-l20",
        "order": 2,
        "title_bn": "ভ্রমণ ও অতীত অভিজ্ঞতা পেয়ার ড্রিল (Travel Experience Voice Q&A)",
        "title_target": "Travel Experience (Pair Practice)",
        "intro_bn": "ভ্রমণের অভিজ্ঞতা ও আনন্দ প্রকাশ করে কথোপকথন ড্রিল।",
        "structure": ["Q: どこへ いきましたか", "A: [Place] へ いきました。とても たのしかったです"],
        "items": [
            make_item("jp-past-p7-l20-001", "せんしゅう どこへ いきましたか。うみへ いきました。とても きれいでした。", "せんしゅうどこえいきましたか。うみえいきました。とてもきれいでした。", "Senshuu doko e ikimashita ka. Umi e ikimashita. Totemo kirei deshita.", "গত সপ্তাহে কোথায় গিয়েছিলেন? সমুদ্রে গিয়েছিলাম। খুব সুন্দর ছিল।", "সেনশুউ দোকো এ ইকিমাশিতা কা? উমি এ ইকিমাশিতা। তোতেমো কিরেই দেশিতা।", item_type="dialogue"),
            make_item("jp-past-p7-l20-002", "りょこうは どうでしたか。とても たのしかったです。", "りょこうわどうでしたか。とてもたのしかったです。", "Ryokou wa dou deshita ka. Totemo tanoshikatta desu.", "ভ্রমণ কেমন হয়েছিল? খুব আনন্দদায়ক হয়েছিল।", "রিওকোও ওয়া দোও দেশিতা কা? তোতেমো তানোশিকাত্তা দেশিতা।", item_type="dialogue")
        ]
    }
]
parts.append({
    "id": "jp-past-p7",
    "order": 7,
    "level": "A2",
    "title_bn": "অতীত ইন্টারেক্টিভ ভয়েস পেয়ার প্র্যাকটিস (Past Voice Q&A)",
    "title_target": "Interactive Past Voice Pair Practice (Pair Q&A)",
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

print(f"Course 2 created successfully!")
print(f"Saved to: {DEST_FILE}")
print(f"Total Parts: {len(parts)}")
print(f"Total Lessons: {total_lessons}")
print(f"Total Items: {total_items}")
