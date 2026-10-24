# -*- coding: utf-8 -*-
"""
Builder for Course 3: Japanese Spoken Fluency & Casual Conversation (JLPT N4)
Generates: android/app/src/main/assets/spoken_japanese_casual_fluency.json
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
    "title_bn": "জাপানিজ স্পোকেন: Casual & Fluency (JLPT N4 কথ্য ভাষা)",
    "title_target": "Spoken Japanese: Casual Fluency Masterclass",
    "source": "Curated from N4 Japanese Study Series & Spoken English Framework",
    "note": "বন্ধুমহলের সাধারণ কথ্য রূপ (Plain Form: タ形・辞書形・ナイ形), সামর্থ্য (可能動詞), উপহার ও উপকার আদান-প্রদান (あげる/もらう/くれる), শর্ত (〜たら/〜なら), মতামত (〜と思います), এবং কর্মবাচ্য (受身形)।",
    "welcome_text": "জাপানিজ স্পোকেন Casual Fluency ক্লাসে স্বাগতম! বন্ধুদের সাথে সাবলীল অনানুষ্ঠানিক জাপানিজে কথা বলা ও জটিল ভাব প্রকাশের কৌশল শিখুন।"
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
        "intro_bn": "বন্ধুবান্ধব বা সমবয়সীদের সাথে কথা বলার সময় মার্জিত '〜ます' বাদ দিয়ে ক্রিয়ার ডিকশনারি রূপ (Dictionary Form) ব্যবহৃত হয়। যেমন: 食べます -> 食べる, 行きます -> 行く।",
        "structure": ["Casual / Plain Form: Verb (Dictionary Form)"],
        "items": [
            make_item("jp-cas-p1-l1-001", "あした とうきょうへ いく。", "あしたとうきょうえいく。", "Ashita Toukyou e iku.", "কাল টোকিও যাব। (ইনফরমাল)", "আশিতা তোকিও এ ইকু।", [("あした", "ashita", "明日", "আগামীকাল"), ("とうきょう", "toukyou", "東京", "টোকিও"), ("へ", "e", "へ", "দিকে"), ("いく", "iku", "行く", "যাব (Casual)")]),
            make_item("jp-cas-p1-l1-002", "いまから ごはん たべる。", "いまからごはんたべる。", "Ima kara gohan taberu.", "এখন খাবার খাব।", "ইমা কারা গোহান তাবেরু।", [("いまから", "ima kara", "今から", "এখন থেকে"), ("ごはん", "gohan", "ご飯", "ভাত/খাবার"), ("たべる", "taberu", "食べる", "খাব")]),
            make_item("jp-cas-p1-l1-003", "こんばん えいが みる？ うん、みる。", "こんばんえいがみる？うん、みる。", "Konban eiga miru? Un, miru.", "আজ রাতে সিনেমা দেখবি? হ্যাঁ, দেখব।", "কোনবান এইগা মিরু? উন, মিরু।", [("こんばん", "konban", "今晩", "আজ রাত"), ("えいが", "eiga", "映画", "সিনেমা"), ("みる", "miru", "見る", "দেখবি?"), ("うん", "un", "うん", "হ্যাঁ (Casual)"), ("みる", "miru", "見る", "দেখব")])
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
            make_item("jp-cas-p1-l2-001", "きょうは どこへも いかない。", "きょうわどこえもいかない。", "Kyou wa doko e mo ikanai.", "আজ কোথাও যাব না।", "কিয়োও ওয়া দোকো এ মো ইকনাই।", polarity="negative"),
            make_item("jp-cas-p1-l2-002", "おさけは のまない。", "おさけわのまない。", "Osake wa nomanai.", "মদ খাই না।", "ওসাকে ওয়া নোমানাই।", polarity="negative"),
            make_item("jp-cas-p1-l2-003", "あさごはん たべないの？ うん、たべない。", "あさごはんたべないの？うん、たべない。", "Asagohan tabenai no? Un, tabenai.", "সকালের নাস্তা খাবি না? না, খাব না।", "আসাগোহান তাবেনাই নো? উন, তাবেনাই।", polarity="negative")
        ]
    },
    {
        "id": "jp-cas-l03",
        "order": 3,
        "title_bn": "সাধারণ অতীত প্লেইন রূপ (Casual Past: Ta-Form)",
        "title_target": "Casual Past Affirmative & Negative (Ta-Form / Nakatta)",
        "intro_bn": "বন্ধুমহলে অতীতের কাজ বলতে '〜ました' এর স্থানে '〜た' (Ta-form) এবং না-বোধকে '〜なかった' (nakatta) বসে। যেমন: 行った (গেছিলাম), 食べなかった (খাইনি)।",
        "structure": ["Casual Past: Verb-た / Verb-なかった"],
        "items": [
            make_item("jp-cas-p1-l3-001", "きのう おもしろい えいがを みた。", "きのうおもしろいえいがをみた。", "Kinou omoshiroi eiga o mita.", "গতকাল একটি মজার সিনেমা দেখলাম।", "কিনোও ওমোশিরোই এইগা ও মিতা।", tense="past_simple"),
            make_item("jp-cas-p1-l3-002", "きのうは べんきょうしなかった。", "きのうわべんきょうしなかった。", "Kinou wa benkyou shinakatta.", "গতকাল পড়িনি।", "কিনোও ওয়া বেনকিওও শিনাকাত্তা।", tense="past_simple", polarity="negative"),
            make_item("jp-cas-p1-l3-003", "テスト どうだった？ むずかしかった。", "てすとどうだった？むずかしかった。", "Tesuto dou datta? Muzukashikatta.", "পরীক্ষা কেমন হয়েছিল? কঠিন ছিল।", "তেসুতো দোও দাত্ত কা? মুজুকাশিকাত্তা।", tense="past_simple")
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
            make_item("jp-cas-p1-l4-001", "かれは にほんへ いく。", "かれわにほんえいく。", "Kare wa Nihon e iku.", "১. হ্যাঁ-বোধক: সে জাপানে যাবে।", "কারে ওয়া নিহোন এ ইকু।", item_type="drill"),
            make_item("jp-cas-p1-l4-002", "かれは にほんへ いかない。", "かれわにほんえいかない。", "Kare wa Nihon e ikanai.", "২. না-বোধক: সে জাপানে যাবে না।", "কারে ওয়া নিহোন এ ইকনাই।", item_type="drill", polarity="negative"),
            make_item("jp-cas-p1-l4-003", "かれは にほんへ いく？", "かれわにほんえいく？", "Kare wa Nihon e iku?", "৩. প্রশ্নবোধক: সে কি জাপানে যাবে?", "কারে ওয়া নিহোন এ ইকু?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-cas-p1-l4-004", "かれは にほんへ いかないの？", "かれわにほんえいかないの？", "Kare wa Nihon e ikanai no?", "৪. না-বোধক প্রশ্ন: সে কি জাপানে যাবে না?", "কারে ওয়া নিহোন এ ইকনাই নো?", item_type="drill", sentence_type="negative_interrogative", polarity="negative"),
            make_item("jp-cas-p1-l4-005", "かれは いつ にほんへ いく？ らいげつ いくよ。", "かれわいつにほんえいく？らいげついくよ。", "Kare wa itsu Nihon e iku? Raigetsu iku yo.", "৫. WH-প্রশ্ন: সে কবে জাপান যাবে? আগামী মাসে যাবে।", "কারে ওয়া ইতসু নিহোন এ ইকু? রাইগেতসু ইকু ইয়ো।", item_type="drill", sentence_type="wh_question"),
            make_item("jp-cas-p1-l4-006", "バスで いく？ でんしゃで いく？", "ばすでいく？でんしゃでいく？", "Basu de iku? Densha de iku?", "৬. বিকল্প প্রশ্ন: বাসে যাবি, নাকি ট্রেনে?", "বাসু দে ইকু? দেনশা দে ইকু?", item_type="drill", sentence_type="alternative_question")
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
        "title_bn": "সামর্থ্য প্রকাশ — '可能動詞' ও '〜ことが できます' (Can / Able to)",
        "title_target": "Potential Verbs & Ability (Hanaseru / Koto ga dekiru)",
        "intro_bn": "কোনো কাজ করতে পারি বা আমার সামর্থ্য আছে প্রকাশ করতে ক্রিয়াপদের পোটেনশিয়াল রূপ (可能動詞) অথবা 'Verb-辞書形 + ことが できます' বসে। কর্মের পর 'を' এর বদলে 'が' বসে।",
        "structure": ["Noun + が + Potential Verb-ます / Verb (Dic) + ことが できます"],
        "items": [
            make_item("jp-cas-p2-l5-001", "わたしは にほんごが すこし はなせます。", "わたしわにほんごがすこしはなせます。", "Watashi wa nihongo ga sukoshi hanasemasu.", "আমি কিছুটা জাপানি ভাষায় কথা বলতে পারি।", "ওয়াতাশি ওয়া নিহঙ্গো গা সুকোশি হানাসেমাসু।"),
            make_item("jp-cas-p2-l5-002", "かれは じどうしゃを うんてんする ことが できます。", "かれわじどうしゃをうんてんすることができる。", "Kare wa jidousha o unten suru koto ga dekimasu.", "সে গাড়ি চালাতে পারে।", "কারে ওয়া জিদোওশা ও উনতেন সুরু কোতো গা দেকিমাসু।"),
            make_item("jp-cas-p2-l5-003", "にほんの おんせんで ゆっくり やすむ ことが できます。", "にほんのおんせんでゆっくりやすむことができる。", "Nihon no onsen de yukkuri yasumu koto ga dekimasu.", "জাপানের উষ্ণ প্রস্রবণে শান্তিতে বিশ্রাম নেওয়া যায়।", "নিহোন নো ওনসেন দে ইউক্কুরি ইয়াসুমু কোতো গা দেকিমাসু।")
        ]
    },
    {
        "id": "jp-cas-l06",
        "order": 2,
        "title_bn": "অক্ষমতা ও সীমাবদ্ধতা (Inability: Can't do)",
        "title_target": "Expressing Inability (Hanasenai / Koto ga dekimasen)",
        "intro_bn": "কোনো কাজ করতে পারি না বোঝাতে '〜ません' বা '〜ない' বসে। যেমন: 漢字が 書けません (কাঞ্জি লিখতে পারি না)।",
        "structure": ["Noun + が + Potential Verb-ません"],
        "items": [
            make_item("jp-cas-p2-l6-001", "わたしは かんじが あまり かけません。", "わたしわかんじがあまりかけません。", "Watashi wa kanji ga amari kakemasen.", "আমি খুব একটা কাঞ্জি লিখতে পারি না।", "ওয়াতাশি ওয়া কাঞ্জি গা আমারি কাকেমাসেন।", polarity="negative"),
            make_item("jp-cas-p2-l6-002", "およぐ ことが できません。", "およぐことができません。", "Oyogu koto ga dekimasen.", "সাঁতার কাটতে পারি না।", "ওয়োগু কোতো গা দেকিমাসেন।", polarity="negative")
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
# PART 3: উপহার ও উপকার আদান-প্রদান (Giving & Receiving: あげる / もらう / くれる)
# ==============================================================================
p3_lessons = [
    {
        "id": "jp-cas-l07",
        "order": 1,
        "title_bn": "উপহার ও জিনিস আদান-প্রদান (Giving & Receiving Things)",
        "title_target": "Giving & Receiving Items (Ageru, Morau, Kureru)",
        "intro_bn": "জাপানিজে কাউকে দেওয়া 'あげる' (ageru), কারো কাছ থেকে পাওয়া 'もらう' (morau) এবং অন্য কেউ আমাকে দিলে 'くれる' (kureru) ব্যবহৃত হয়।",
        "structure": [
            "A wa B ni [Item] o agemasu (A gives to B)",
            "A wa B ni/kara [Item] o moraimasu (A receives from B)",
            "Person wa watashi ni [Item] o kuremasu (Someone gives to me)"
        ],
        "items": [
            make_item("jp-cas-p3-l7-001", "わたしは ともだちに たんじょうびプレゼントを あげました。", "わたしわともだちにたんじょうびぷれぜんとをあげました。", "Watashi wa tomodachi ni tanjoubi purezento o agemashita.", "আমি বন্ধুকে জন্মদিনের উপহার দিয়েছিলাম।", "ওয়াতাশি ওয়া তোমোদাচি নি তানজোওবি পুরেজেনতো ও আগেমাশিতা।"),
            make_item("jp-cas-p3-l7-002", "せんせいに べんりな じしょを もらいました。", "せんせいにべんりなじしょをもらいました。", "Sensei ni benri na jisho o moraimashita.", "শিক্ষকের কাছ থেকে একটি উপকারী অভিধান পেয়েছিলাম।", "সেনসেই নি বেনরি না জিশো ও মোরাইমাশিতা।"),
            make_item("jp-cas-p3-l7-003", "たなかさんが わたしに かさを くれました。", "たなかさんがわたしにかさをくれました。", "Tanaka-san ga watashi ni kasa o kuremashita.", "তানাকা বাবু আমাকে ছাতা দিয়েছিলেন।", "তানাকা-সান গা ওয়াতাশি নি কাসা ও কুরেমাশিতা।")
        ]
    },
    {
        "id": "jp-cas-l08",
        "order": 2,
        "title_bn": "উপকার ও কাজের সাহায্য করা (Giving & Receiving Favors: Verb-て あげる/もらう/くれる)",
        "title_target": "Actions of Favor (~te ageru / morau / kureru)",
        "intro_bn": "কারো কোনো কাজ করে দেওয়া বা কারো সাহায্য পাওয়া প্রকাশ করতে ক্রিয়ার তে-ফর্মের সাথে 'あげる', 'もらう', 'くれる' বসে।",
        "structure": ["Verb-て + あげます / もらいます / くれます"],
        "items": [
            make_item("jp-cas-p3-l8-001", "わたしは ともだちに にほんごを おしえて あげました。", "わたしわともだちににほんごをおしえてあげました。", "Watashi wa tomodachi ni nihongo o oshiete agemashita.", "আমি বন্ধুকে জাপানি ভাষা শিখিয়ে দিয়েছিলাম।", "ওয়াতাশি ওয়া তোমোদাচি নি নিহঙ্গো ও ওশিয়েতে আগেমাশিতা।"),
            make_item("jp-cas-p3-l8-002", "ともだちに みちを あんないして もらいました。", "ともだちにみちをあんないしてもらいました。", "Tomodachi ni michi o annai shite moraimashita.", "বন্ধুকে দিয়ে পথ দেখিয়ে নিয়েছিলাম।", "তোমোদাচি নি মিচি ও আন্নাই শিতে মোরাইমাশিতা।"),
            make_item("jp-cas-p3-l8-003", "たなかさんは えきまで くるまで おくって くれました。", "たなかさんわえきまでくるまでおくってくれました。", "Tanaka-san wa eki made kuruma de okutte kuremashita.", "তানাকা বাবু আমাকে স্টেশন পর্যন্ত গাড়িতে পৌঁছে দিয়েছিলেন।", "তানাকা-সান ওয়া একি মাদে কুরুমা দে ওকুত্তে কুরেমাশিতা।")
        ]
    }
]
parts.append({
    "id": "jp-casual-p3",
    "order": 3,
    "level": "A2",
    "title_bn": "উপহার ও উপকার আদান-প্রদান (Giving & Receiving: あげる / もらう / くれる)",
    "title_target": "Giving & Receiving Favors (Ageru, Morau, Kureru)",
    "lessons": p3_lessons
})

# ==============================================================================
# PART 4: শর্ত, অনুমান ও মতামত (Conditionals, Opinions & Suppositions)
# ==============================================================================
p4_lessons = [
    {
        "id": "jp-cas-l09",
        "order": 1,
        "title_bn": "শর্ত ও যদি — '〜たら' (Conditionals: If / When)",
        "title_target": "Conditionals with ~tara (If / Once)",
        "intro_bn": "যদি কোনো কাজ ঘটে বা যখন ঘটবে বোঝাতে Ta-form এর পর 'ら' (tara) বসে। যেমন: 雨が 降ったら (বৃষ্টি হলে)।",
        "structure": ["Verb-たら、Result Sentence"],
        "items": [
            make_item("jp-cas-p4-l9-001", "あした あめが ふったら、うちで やすみます。", "あしたあめがふったら、うちでやすみます。", "Ashita ame ga futtara, uchi de yasumimasu.", "আগামীকাল বৃষ্টি হলে বাড়িতে বিশ্রাম নেব।", "আশিতা আমে গা ফdistributionত্তারা, উচি দে ইয়াসুমিমাসু।"),
            make_item("jp-cas-p4-l9-002", "おかねが あったら、りょこうに いきたいです。", "おかねがあったら、りょこうにいきたいです。", "Okane ga attara, ryokou ni ikitai desu.", "টাকা থাকলে ভ্রমণে যেতে চাই।", "ওকানে গা আত্তারা, রিওকোও নি ইকিতাই দেস।"),
            make_item("jp-cas-p4-l9-003", "じかんが なかったら、タクシーで いきましょう。", "じかんがなかったら、たくしーでいきましょう。", "Jikan ga nakattara, takushii de ikimashou.", "সময় না থাকলে ট্যাক্সিতে যাই চলুন।", "জিকান গা নাকাত্তারা, তাকুশিই দে ইকিমাশোও।")
        ]
    },
    {
        "id": "jp-cas-l10",
        "order": 2,
        "title_bn": "প্রসঙ্গ সাপেক্ষে শর্ত — '〜なら' (If it's the case that...)",
        "title_target": "Contextual Conditionals (~nara)",
        "intro_bn": "শ্রোতার কথার প্রসঙ্গে পরামর্শ দিতে বা শর্ত আরোপ করতে 'Noun + なら' বসে। যেমন: 日本へ 行くなら (জাপানে যাওয়ার কথা হলে)।",
        "structure": ["Noun / Sentence + なら + Recommendation"],
        "items": [
            make_item("jp-cas-p4-l10-001", "にほんへ いくなら、きょうとが おすすめです。", "にほんえいくなら、きょうとがおすすめす。", "Nihon e iku nara, Kyouto ga osusume desu.", "জাপানে যদি যান, তবে কিয়োটো সবচেয়ে উত্তম প্রস্তাবনা।", "নিহোন এ ইকু নারা, কিওওতো গা ওসুসুমে দেস।"),
            make_item("jp-cas-p4-l10-002", "パソコンなら、この みせが いちばん やすいです。", "ぱそこんなら、このみせがいちばんやすいです。", "Pasokon nara, kono mise ga ichiban yasui desu.", "ল্যাপটপের ব্যাপারে হলে এই দোকানটি সবচেয়ে সস্তা।", "পাসোকোন নারা, কোনো মিসে গা ইচিবান ইয়াসুই দেস।")
        ]
    },
    {
        "id": "jp-cas-l11",
        "order": 3,
        "title_bn": "নিজের মতামত প্রকাশ — '〜と 思います' (I think that...)",
        "title_target": "Expressing Thoughts & Opinions (~to omoimasu)",
        "intro_bn": "নিজের মতামত বা ধারণা প্রকাশ করতে প্লেইন ফর্ম বাক্যের শেষে '〜と おもいます' (I think that...) বসে।",
        "structure": ["Plain Form Sentence + と おもいます"],
        "items": [
            make_item("jp-cas-p4-l11-001", "あしたは あめが ふると おもいます。", "あしたわあめがふるとおもいます。", "Ashita wa ame ga furu to omoimasu.", "আমার মনে হয় কাল বৃষ্টি হবে।", "আশিতা ওয়া আমে গা ফুরু তো ওমোইমাসু।"),
            make_item("jp-cas-p4-l11-002", "にほんの ぶっかは たかいと おもいます。", "にほんのぶっかわたかいとおもいます。", "Nihon no bukka wa takai to omoimasu.", "আমার মনে হয় জাপানের জিনিসপত্রের দাম অনেক বেশি।", "নিহোন নো বুক্কা ওয়া তাকাই তো ওমোইমাসু।"),
            make_item("jp-cas-p4-l11-003", "たなかさんは あした こないと おもいます。", "たなかさんわあしたこないとおもいます。", "Tanaka-san wa ashita konai to omoimasu.", "আমার ধারণা তানাকা বাবু কাল আসবেন না।", "তানাকা-সান ওয়া আশিতা কোনাই তো ওমোইমাসু।", polarity="negative")
        ]
    },
    {
        "id": "jp-cas-l12",
        "order": 4,
        "title_bn": "উপদেশ ও পরামর্শ — '〜た ほうが いいです' (Had better / Should)",
        "title_target": "Giving Advice (~ta hou ga ii desu)",
        "intro_bn": "কাউকে কোনো কিছু করার পরামর্শ দিতে 'Verb-た ほうが いいです' (করাই ভালো) এবং না করার পরামর্শে 'Verb-ない ほうが いいです' বসে।",
        "structure": ["Verb-た ほうが いいです (করাই ভালো)", "Verb-ない ほうが いいです (না করাই ভালো)"],
        "items": [
            make_item("jp-cas-p4-l12-001", "はやく びょういんへ いった ほうが いいですよ。", "はやくびょういんえいったほうがいいですよ。", "Hayaku byouin e itta hou ga ii desu yo.", "তাড়াতাড়ি হাসপাতালে যাওয়াই ভালো হবে কিন্তু।", "হায়াকু বিয়োওইন এ ইত্তা হোও গা ইই দেসু ইয়ো।"),
            make_item("jp-cas-p4-l12-002", "あまり むりを しない ほうが いいです。", "あまりむりをしないほうがいいです。", "Amari muri o shinai hou ga ii desu.", "অতিরিক্ত চাপ না নেওয়াই ভালো।", "আমারি মুরি ও শিনাই হোও গা ইই দেস।", polarity="negative")
        ]
    }
]
parts.append({
    "id": "jp-casual-p4",
    "order": 4,
    "level": "A2",
    "title_bn": "শর্ত, অনুমান ও মতামত (Conditionals, Opinions & Advice)",
    "title_target": "Conditionals, Opinions & Advice (~tara, ~to omoimasu, ~hou ga ii)",
    "lessons": p4_lessons
})

# ==============================================================================
# PART 5: কর্মবাচ্য ও প্রযোজক ক্রিয়া (Passive & Causative: 受身形 & 使役形)
# ==============================================================================
p5_lessons = [
    {
        "id": "jp-cas-l13",
        "order": 1,
        "title_bn": "স্পোকেন প্যাসিভ রূপ — '受身形' (Passive Voice: Raremashite)",
        "title_target": "Passive Voice (Ukemikei: ~rareru)",
        "intro_bn": "কর্তা নিজে সরাসরি কাজ না করে অন্য কারো কাজের শিকার হলে প্যাসিভ ভয়েস বসে (যেমন: শিক্ষক আমাকে প্রশংসা করেছিলেন / চোর আমার মানিব্যাগ নিয়েছিল)।",
        "structure": ["Victim は + Agent に + Passive Verb-ました"],
        "items": [
            make_item("jp-cas-p5-l13-001", "わたしは せんせいに ほめられました。", "わたしわせんせいにほめられました。", "Watashi wa sensei ni homeraremashita.", "আমি শিক্ষকের দ্বারা প্রশংসিত হয়েছিলাম। (শিক্ষক আমার প্রশংসা করেছিলেন)", "ওয়াতাশি ওয়া সেনসেই নি হোমেরারেমাশিতা।"),
            make_item("jp-cas-p5-l13-002", "でんしゃの なかで あしを ふまれました。", "でんしゃのなかであしをふまれました。", "Densha no naka de ashi o fumaremashita.", "ট্রেনের ভেতর কেউ আমার পায়ে পাড়া দিয়েছিল।", "দেনশা নো নাকা দে আশি ও ফুমারেমাশিতা।"),
            make_item("jp-cas-p5-l13-003", "あめに ふられて、びしょぬれに なりました。", "あめにふられて、びしょぬれになりました。", "Ame ni furarete, bishonure ni narimashita.", "বৃষ্টির পানিতে ভিজে একাকার হয়ে গেলাম।", "আমে নি ফুরারেতে, বিশোনুরে নি নারিমাশিতা।")
        ]
    },
    {
        "id": "jp-cas-l14",
        "order": 2,
        "title_bn": "অনুমতি চাওয়া প্রযোজক রূপে — '〜させて ください' (Let me do...)",
        "title_target": "Causative Requests (~sasete kudasai)",
        "intro_bn": "আমাকে কোনো কাজ করার অনুমতি দিন বা আমাকে করতে দিন বোঝাতে কজেটিভ রূপের সাথে 'させて ください' বসে।",
        "structure": ["Verb (Causative-te) + ください (Let me please do...)"],
        "items": [
            make_item("jp-cas-p5-l14-001", "きょうは はやく かえらせて ください。", "きょうわはやくかえらせてください。", "Kyou wa hayaku kaerasete kudasai.", "আজ আমাকে একটু তাড়াতাড়ি বাড়ি ফিরতে দিন।", "কিয়োও ওয়া হায়াকু কায়েরাসেতে কুদাসাই।"),
            make_item("jp-cas-p5-l14-002", "わたしに その しごとを やらせて ください。", "わたしにそのしごとをやらせてください。", "Watashi ni sono shigoto o yarasete kudasai.", "আমাকে ওই কাজটি করতে দিন।", "ওয়াতাশি নি সোনো শিগাতো ও ইয়ারাচেতে কুদাসাই।")
        ]
    }
]
parts.append({
    "id": "jp-casual-p5",
    "order": 5,
    "level": "A2",
    "title_bn": "কর্মবাচ্য ও প্রযোজক ক্রিয়া (Passive & Causative: 受身形 & 使役形)",
    "title_target": "Passive Voice & Causative Requests (Ukemikei & Shiekikei)",
    "lessons": p5_lessons
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

print(f"Course 3 created successfully!")
print(f"Saved to: {DEST_FILE}")
print(f"Total Parts: {len(parts)}")
print(f"Total Lessons: {total_lessons}")
print(f"Total Items: {total_items}")
