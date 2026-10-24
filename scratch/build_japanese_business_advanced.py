# -*- coding: utf-8 -*-
"""
Builder for Course 4: Advanced Japanese Speaking & Business Keigo (JLPT N3/N2)
Generates: android/app/src/main/assets/spoken_japanese_business_advanced.json
"""
import json
import os
import sys

sys.stdout.reconfigure(encoding='utf-8')

DEST_FILE = 'android/app/src/main/assets/spoken_japanese_business_advanced.json'

course_metadata = {
    "id": "jp-spoken-business-advanced",
    "target_lang": "ja",
    "base_lang": "bn",
    "title_bn": "জাপানিজ স্পোকেন: Business & Keigo (JLPT N3/N2 মার্জিত ভাষা)",
    "title_target": "Spoken Japanese: Business Keigo & Advanced Fluency",
    "source": "Curated from N3-N2 Japanese Study Series & Spoken English Framework",
    "note": "অফিসিয়াল ও বিজনেস কেইগো (尊敬語・謙譲語), টেলিফোন ও মিটিং কমিউনিকেশন, কথোপকথন সচল রাখার কৌশল (相槌), সূক্ষ্ম ভাব প্রকাশ ও জব ইন্টারভিউ প্রশ্নোত্তর।",
    "welcome_text": "জাপানিজ স্পোকেন Business & Keigo ক্লাসে স্বাগতম! জাপানি কর্পোরেট জগতে পেশাদার যোগাযোগ ও মার্জিত বিনম্র ভাষায় কথা বলা শিখুন।"
}

ladder_default = [
    {"play": "target", "speed": 0.85},
    {"play": "bn", "speed": 1.15},
    {"play": "target", "speed": 0.95},
    {"play": "target", "speed": 1.05},
    {"play": "target", "speed": 1.15, "min_level": "A2"},
    {"pause_ms": 1200}
]

def make_item(item_id, target, target_kana, romaji, bn, bn_pron, tokens_tuples=None, sentence_type="assertive", polarity="affirmative", tense="present_simple", item_type="sentence", level="B1"):
    if tokens_tuples is None:
        tokens = [{"t": target, "romaji": romaji, "kanji": target, "bn": bn}]
    else:
        tokens = [{"t": t[0], "romaji": t[1], "kanji": t[2], "bn": t[3]} for t in tokens_tuples]
    
    tags = {
        "sentence_type": sentence_type,
        "polarity": polarity,
        "tense": tense,
        "jlpt": "N3"
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
# PART 1: কেইগো ও বিনম্র ভাষা (Keigo Masterclass: Sonkeigo & Kenjougo)
# ==============================================================================
p1_lessons = [
    {
        "id": "jp-biz-l01",
        "order": 1,
        "title_bn": "উচ্চপদস্থ ব্যক্তির সম্মানার্থে উক্তি — '尊敬語' (Sonkeigo: Respectful Speech)",
        "title_target": "Honorific Respectful Speech (Sonkeigo)",
        "intro_bn": "গ্রাহক, বস বা সম্মানিত ব্যক্তির কাজ প্রকাশে '尊敬語' (Sonkeigo) ব্যবহৃত হয়। যেমন: 行く/来る/いる -> いらっしゃる, 言う -> おっしゃる, 食べる -> 召し上がる।",
        "structure": ["Superior Person + は + 尊敬語 (Sonkeigo Verb)"],
        "items": [
            make_item("jp-biz-p1-l1-001", "しゃちょうは もう おかえりに なられました。", "しゃちょうわもうおかえりになられました。", "Shachou wa mou okaeri ni nararemashita.", "কোম্পানি প্রধান (সিইও) ইতিমধ্যে বাড়ি ফিরে গিয়েছেন।", "শাচোও ওয়া মোও ওকায়েরি নি নারারেমাশিতা।", [("しゃちょう", "shachou", "社長", "সিইও/প্রেসিডেন্ট"), ("は", "wa", "は", "হল"), ("もう", "mou", "もう", "ইতিমধ্যে"), ("おかえりに なられました", "okaeri ni nararemashita", "お帰りになられました", "ফিরে গেছেন (সম্মানসূচক)")]),
            make_item("jp-biz-p1-l1-002", "せんせいは なにと おっしゃいましたか。", "せんせいわないにとおっしゃいましたか。", "Sensei wa nan to osshaimashita ka.", "শিক্ষক কী বলেছিলেন? (বলার সম্মানসূচক রূপ: おっしゃる)", "সেনসেই ওয়া নান তো ওশ্শাইমাশিতা কা?"),
            make_item("jp-biz-p1-l1-003", "どうぞ あたたかい おちゃを めしあがって ください。", "どうぞあたたかいおちゃをめしあがってください。", "Douzo atatakai ocha o meshiagatte kudasai.", "অনুগ্রহ করে গরম চা গ্রহণ করুন/খান। (খাওয়া ও পান করার সম্মানসূচক রূপ)", "দোওজো আতাকেকাই ওচা ও মেশিয়াগাত্তে কুদাসাই।")
        ]
    },
    {
        "id": "jp-biz-l02",
        "order": 2,
        "title_bn": "নিজের কাজ বিনীতভাবে প্রকাশ — '謙譲語' (Kenjougo: Humble Speech)",
        "title_target": "Humble Speech for Oneself (Kenjougo)",
        "intro_bn": "গ্রাহক বা বসের সামনে নিজের বা নিজের দলের কাজকে বিনম্রভাবে ছোট করে প্রকাশ করতে '謙譲語' (Kenjougo) বসে। যেমন: 行く/来る -> 参る (mairu), 言う -> 申す (mousu), する -> 致す (itasu)।",
        "structure": ["わたしは + 謙譲語 (Kenjougo Verb)"],
        "items": [
            make_item("jp-biz-p1-l2-001", "わたしは ラヒムと もうします。", "わたしわらひむともうします。", "Watashi wa Rahimu to moushimasu.", "আমার নাম রহিম। (নিজের নাম বিনম্রভাবে বলার রূপ: 申します)", "ওয়াতাশি ওয়া রাহিমু তো মোওশিমাসু।"),
            make_item("jp-biz-p1-l2-002", "あした １０じに そちらへ まいります。", "あしたじゅうじにそちらえまいります。", "Ashita juuji ni sochira e mairimasu.", "আগামীকাল সকাল ১০টায় আপনাদের ওখানে উপস্থিত হব/যাব। (বিনম্র রূপ: 参ります)", "আশিতা জুউজি নি সোচিরা এ মাইরিমাসু।"),
            make_item("jp-biz-p1-l2-003", "ただいまから プレゼンテーションを いたします。", "ただいまからぷれぜんてーしょんをいたします。", "Tadaima kara purezenteeshon o itashimasu.", "এখন থেকে প্রেজেন্টেশন শুরু করছি। (করার বিনম্র রূপ: いたします)", "তাদাইমা কারা পুরেজেনতেএশোন ও ইতাশিমাসু।"),
            make_item("jp-biz-p1-l2-004", "しりょうを はいけんいたしました。", "しりょうをはいけんいたしました。", "Shiryou o haiken itashimashita.", "নথিপত্রগুলো গভীর মনোযোগের সাথে অবলোকন করেছি। (দেখার বিনম্র রূপ)", "শিরিওও ও হাইকেন ইতাশিমাশিতা।")
        ]
    },
    {
        "id": "jp-biz-l03",
        "order": 3,
        "title_bn": "অত্যন্ত বিনম্র অনুরোধ — '〜て いただけませんでしょうか'",
        "title_target": "Ultra-polite Business Requests (~te itadakemasen deshou ka)",
        "intro_bn": "অফিসে বা ক্লায়েন্টকে অত্যন্ত সম্মান ও বিনম্রতার সাথে অনুরোধ জানাতে '〜て いただけませんでしょうか' বসে।",
        "structure": ["Verb-て + いただけませんでしょうか (Could you kindly please...?)"],
        "items": [
            make_item("jp-biz-p1-l3-001", "もう いちど ごせつめい していただけませんでしょうか。", "もういちどごせつめいしていただけませんでしょうか。", "Mou ichido gosetsumei shite itadakemasen deshou ka.", "অনুগ্রহ করে আরও একবার ব্যাখ্যা করে দেবেন কি?", "মোও ইচিদো গোসেতসুমেই শিতে ইতাদাকেমাসেন দেশোও কা?"),
            make_item("jp-biz-p1-l3-002", "この しりょうを ごらん いただけませんでしょうか。", "このしりょうをごらんいただけませんでしょうか。", "Kono shiryou o goran itadakemasen deshou ka.", "এই নথিপত্রটি কি একবার একটু অনুগ্রহ করে দেখে দেবেন?", "কোনো শিরিওও ও গোরান ইতাদাকেমাসেন দেশোও কা?")
        ]
    }
]
parts.append({
    "id": "jp-business-p1",
    "order": 1,
    "level": "B1",
    "title_bn": "কেইগো ও বিনম্র ভাষা (Keigo Masterclass: Sonkeigo & Kenjougo)",
    "title_target": "Keigo Masterclass: Honorific & Humble Speech",
    "lessons": p1_lessons
})

# ==============================================================================
# PART 2: অফিস ও কর্পোরেট বিজনেস কমিউনিকেশন (Business Scenarios)
# ==============================================================================
p2_lessons = [
    {
        "id": "jp-biz-l04",
        "order": 1,
        "title_bn": "বিজনেস টেলিফোন কথোপকথন (Business Telephone Etiquette)",
        "title_target": "Telephone Communication in Japanese Companies",
        "intro_bn": "জাপানি অফিসে ফোন রিসিভ করার সময় 'お世話になっております' এবং ফোন রাখার সময় '失礼いたします' বলা আবশ্যক।",
        "structure": ["いつも お世話に なっております (Thank you for your continuous support)"],
        "items": [
            make_item("jp-biz-p2-l4-001", "はい、ABCしょうじで ございます。いつも おせわに なって おります。", "はい、えーびーしーしょうじでございます。いつもおせわになっております。", "Hai, Eebiishee shouji de gozaimasu. Itsumo osewa ni natte orimasu.", "হ্যাঁ, এটি এবিসি ট্রেডিং কোম্পানি বলছি। আপনাদের নিরবচ্ছিন্ন সহযোগিতার জন্য ধন্যবাদ।", "হাই, এবিসি শোওজি দে গোজাইমাসু। ইতসুমো ওসেওয়া নি নাত্তে ওরিমাছু।", item_type="dialogue"),
            make_item("jp-biz-p2-l4-002", "たなかぶちょうは いらっしゃいますでしょうか。", "たなかぶちょうわいらっしゃいますでしょうか。", "Tanaka-buchou wa irasshaimasu deshou ka.", "ডিপার্টমেন্ট প্রধান তানাকা বাবু কি আছেন?", "তানাকা-বুচোও ওয়া ইরাশ্শাইমাসু দেশোও কা?", item_type="dialogue"),
            make_item("jp-biz-p2-l4-003", "あいにく たなかは ただいま がいしゅつして おります。", "あいにくたなかわただいまがいしゅつしております。", "Ainiku Tanaka wa tadaima gaishutsu shite orimasu.", "দুঃখজনকভাবে তানাকা বাবু এই মুহূর্তে বাইরে অবস্থান করছেন।", "আইনিকু তানাকা ওয়া তাদাইমা গাইশুতসু শিতে ওরিমাছু।", item_type="dialogue")
        ]
    },
    {
        "id": "jp-biz-l05",
        "order": 2,
        "title_bn": "অফিসে ক্ষমা প্রার্থনা ও বিনম্র দুঃখপ্রকাশ (Corporate Apologies)",
        "title_target": "Formal Corporate Apologies (Taihen Moushiwake Gozaimasen)",
        "intro_bn": "অফিসিয়াল কোনো ত্রুটি বা দেরির ক্ষেত্রে সাধারণ 'Gomen nasai' না বলে '大変 申し訳ございません' বলতে হয়।",
        "structure": ["大変 申し訳ございません (I sincerely apologize)"],
        "items": [
            make_item("jp-biz-p2-l5-001", "へんしんが おそくなり、たいへん もうしわけございません。", "へんしんがおそくなり、たいへんもうしわけございません。", "Henshin ga osokunari, taihen moushiwake gozaimasen.", "উত্তর দিতে বিলম্ব হওয়ায় আমি আন্তরিকভাবে ক্ষমা প্রার্থনা করছি।", "হেনশিন গা ওসোকুনারি, তাইহেন মোওশিওয়াকে গোজাইমাসেন।"),
            make_item("jp-biz-p2-l5-002", "ごめいわくを おかけして、まことに もうしわけございません。", "ごめいわくをおかけして、まことにもうしわけございません。", "Gomeiwaku o okake shite, makoto ni moushiwake gozaimasen.", "আপনাদের অসুবিধায় ফেলার জন্য সত্যিই অত্যন্ত দুঃখ প্রকাশ করছি।", "গোমেইওয়াকু ও ওকেকে শিতে, মাকোতো নি মোওশিওয়াকে গোজাইমাসেন।")
        ]
    }
]
parts.append({
    "id": "jp-business-p2",
    "order": 2,
    "level": "B1",
    "title_bn": "অফিস ও কর্পোরেট বিজনেস কমিউনিকেশন (Business Scenarios)",
    "title_target": "Corporate Communications, Telephone & Apologies",
    "lessons": p2_lessons
})

# ==============================================================================
# PART 3: কথ্য কৌশল ও সূক্ষ্ম অনুভূতি (Aizuchi & Nuances)
# ==============================================================================
p3_lessons = [
    {
        "id": "jp-biz-l06",
        "order": 1,
        "title_bn": "প্রতিক্রিয়া ও কথোপকথন সচল রাখা — '相槌' (Aizuchi: Conversational Responses)",
        "title_target": "Conversational Reactions & Flow (Aizuchi)",
        "intro_bn": "জাপানিজরা অপরপক্ষের কথা শোনার সময় প্রতিনিয়ত ছোট ছোট প্রতিক্রিয়াসূচক শব্দ বলে থাকে, যাকে '相槌' (Aizuchi) বলে। যেমন: なるほど (বুঝেছি), おっしゃる通りです (আপনি ঠিকই বলেছেন)।",
        "structure": ["Conversational Reaction Fillers: なるほど / おっしゃる通りです / 確かに"],
        "items": [
            make_item("jp-biz-p3-l6-001", "なるほど。そのとおりですね。", "なるほど。そのとおりですね。", "Naruhodo. Sono toori desu ne.", "আচ্ছা বুঝেছি! ঠিক তাই, আপনি একদম ঠিক বলেছেন।", "নারুহোদো। সোনো তোওরি দেসু নে।", item_type="dialogue"),
            make_item("jp-biz-p3-l6-002", "おっしゃる とおりで ございます。べんきょうに なります。", "おっしゃるとおりでございます。べんきょうになります。", "Ossharu toori de gozaimasu. Benkyou ni narimasu.", "আপনি যথার্থই বলেছেন। অনেক কিছু শিখতে পারলাম।", "ওশ্শারু তোওরি দে গোজাইমাসু। বেনকিওও নি নারিমাসু।", item_type="dialogue")
        ]
    },
    {
        "id": "jp-biz-l07",
        "order": 2,
        "title_bn": "মনস্তাত্ত্বিক কারণ ও ফলাফল — '〜おかげで' বনাম '〜せいで'",
        "title_target": "Psychological Causality (Okage de [Thanks to] vs Sei de [Due to fault])",
        "intro_bn": "ইতিবাচক ভালো ফলাফলের ক্ষেত্রে কারো অবদানের কৃতজ্ঞতা জানাতে '〜おかげで' (Thanks to) এবং নেতিবাচক বা ক্ষতির ক্ষেত্রে '〜せいで' (Due to fault) বসে।",
        "structure": ["Good Result: Noun の / Verb + おかげで", "Bad Result: Noun の / Verb + せいで"],
        "items": [
            make_item("jp-biz-p3-l7-001", "せんせいの おかげで、JLPTに ごうかくできました。", "せんせいのおかげで、じぇいえるぴーてぃーにごうかくできました。", "Sensei no okage de, JLPT ni goukaku dekimashita.", "শিক্ষকের অনুপ্রেরণা ও অবদানের কারণে JLPT পরীক্ষায় উত্তীর্ণ হতে পেরেছি।", "সেনসেই নো ওকেগে দে, জেএলপিটি নি গোওকাকু দেকিমাশিতা।"),
            make_item("jp-biz-p3-l7-002", "たいふうの せいで、ひこうきが けっこうに なりました。", "たいふうのせいで、ひこうきがけっこうになりました。", "Taifuu no sei de, hikouki ga kekkou ni narimashita.", "টাইফুনের বিপত্তির কারণে ফ্লাইট বাতিল হয়ে গেল।", "তাইফুউ নো সেই দে, হিকোওকি গা কেক্কোও নি নারিমাশিতা।", polarity="negative")
        ]
    },
    {
        "id": "jp-biz-l08",
        "order": 3,
        "title_bn": "বাস্তব জব ইন্টারভিউ প্রশ্নোত্তর প্রস্তুতি (Job Interview Q&A)",
        "title_target": "Japanese Job Interview Simulation & Practice",
        "intro_bn": "জাপানি কোম্পানিতে চাকরি বা পার্ট-টাইম জবের ইন্টারভিউতে ব্যবহৃত মূল প্রশ্ন ও উত্তর।",
        "structure": ["Interviewer Question <-> Formal Humble Response"],
        "items": [
            make_item("jp-biz-p3-l8-001", "しぼうどうきを おしえて いただけますか。にほんの さいせんたん ぎじゅつを まなびたいと おもいました。", "しぼうどうきをおしえていただけますか。にほんのさいせんたんぎじゅつをまなびたいとおもいました。", "Shibou douki o oshiete itadakemasu ka. Nihon no saisentan gijutsu o manabitai to omoimashita.", "আমাদের কোম্পানিতে আবেদনের কারণ জানাতে পারেন কি? জাপানের সর্বাধুনিক প্রযুক্তি শিখতে আগ্রহী হয়ে আবেদন করেছি।", "শিবোও দোওকি ও ওশিয়েতে ইতাদাকেমাসু কা? নিহোন নো সাইসেনতান গিজুতসু ও মানাবিতাই তো ওমোইমাশিতা।", item_type="dialogue"),
            make_item("jp-biz-p3-l8-002", "ごじしんの ながしょは なんですか。あきらめずに どりょくする ことです。", "ごじしんのながしょわなんですか。あきらめずんどりょくすることです。", "Gojishin no chousho wa nan desu ka. Akiramezu ni doryoku suru koto desu.", "আপনার সবচাইতে বড় ইতিবাচক গুণ কোনটি? হাল না ছেড়ে নিরন্তর প্রচেষ্টা চালিয়ে যাওয়া।", "গোজিশিন নো চোওশো ওয়া নান দেসু কা? আকিরমেজ নি দোরিওকু সুরু কোতো দেস।", item_type="dialogue")
        ]
    }
]
parts.append({
    "id": "jp-business-p3",
    "order": 3,
    "level": "B1",
    "title_bn": "কথ্য কৌশল ও সূক্ষ্ম অনুভূতি (Aizuchi, Nuances & Interview)",
    "title_target": "Conversational Fillers, Nuances & Job Interview Practice",
    "lessons": p3_lessons
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

print(f"Course 4 created successfully!")
print(f"Saved to: {DEST_FILE}")
print(f"Total Parts: {len(parts)}")
print(f"Total Lessons: {total_lessons}")
print(f"Total Items: {total_items}")
