# -*- coding: utf-8 -*-
"""
Builder for Course 4: Advanced Japanese Speaking & Business Keigo (JLPT N3/N2)
Generates: android/app/src/main/assets/spoken_japanese_business_advanced.json
Curated from 00_Bangla_Japanese_N5_to_N1_Extended_Master_Complete.md
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
    "title_target": "Spoken Japanese: Business Keigo & Advanced Nuance (N3/N2)",
    "source": "Curated from N3-N2 Extended Master Complete & Spoken Japanese Audio Framework",
    "note": "সম্মানসূচক ভাষা (尊敬語: いらっしゃる・おっしゃる), বিনম্র ভাষা (謙譲語: 参る・申す・致す・拝見する), কুশন শব্দ (クッション言葉: 恐れ入りますが), টেলিফোন ও মিটিং আচরণবিধি, সূক্ষ্ম ব্যাকরণ (おかげで・せいで・に基づいて), লিসেনিং কৌশল (相槌: おっしゃる通りです), কর্পোরেট জব ইন্টারভিউ এবং কেইগো রূপান্তর ড্রিল।",
    "welcome_text": "জাপানিজ স্পোকেন Business Keigo ক্লাসে স্বাগতম! জাপানি কর্পোরেট জগত ও মার্জিত পেশাদার পরিবেশে অনর্গল কথা বলার আত্মবিশ্বাস অর্জন করুন।"
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
# PART 1: সম্মানসূচক ভাষা — সনকেইগো (Sonkeigo: Respectful Speech for Superiors)
# ==============================================================================
p1_lessons = [
    {
        "id": "jp-biz-l01",
        "order": 1,
        "title_bn": "বিশেষ সম্মানসূচক ক্রিয়াপদ — '尊敬語' (Special Sonkeigo Verbs)",
        "title_target": "Special Honorific Verbs (Irassharu, Ossharu, Meshiagaru)",
        "intro_bn": "গ্রাহক, ঊর্ধ্বতন কর্মকর্তা বা গুরুজনদের কাজ প্রকাশের জন্য বিশেষ মার্জিত রূপ ব্যবহৃত হয়। যেমন: 行く/来る/いる -> いらっしゃる, 言う -> おっしゃる, 食べる/飲む -> 召し上がる, 見る -> ご覧になる, する -> なさる।",
        "structure": ["Superior Person + は + 尊敬語 (Special Sonkeigo Verb)"],
        "items": [
            make_item("jp-biz-p1-l1-001", "社長は もう お帰りに なられました。", "しゃちょうわもうおかえりになられました。", "Shachou wa mou okaeri ni nararemashita.", "কোম্পানি প্রধান (সিইও) ইতিমধ্যে বাড়ি ফিরে গিয়েছেন।", "শাচোও ওয়া মোও ওকায়েরি নি নারারেমাশিতা।", [("社長は", "shachou wa", "社長は", "কোম্পানি প্রধান"), ("もう", "mou", "もう", "ইতিমধ্যে"), ("お帰りに", "okaeri ni", "お帰りに", "ফিরে"), ("なられました", "nararemashita", "なられました", "গিয়েছেন (সম্মানসূচক)")]),
            make_item("jp-biz-p1-l1-002", "先生は 何と おっしゃいましたか。", "せんせいわないにとおっしゃいましたか。", "Sensei wa nan to osshaimashita ka.", "শিক্ষক মহাশয় কী বলেছিলেন? (বলার সম্মানসূচক রূপ)", "সেনসেই ওয়া নান তো ওশ্শাইমাশিতা কা?", [("先生は", "sensei wa", "先生は", "শিক্ষক"), ("何と", "nan to", "何と", "কী"), ("おっしゃいましたか", "osshaimashita ka", "おっしゃいましたか", "বলেছিলেন কি (সম্মানসূচক)")]),
            make_item("jp-biz-p1-l1-003", "どうぞ 温かい お茶を 召し上がって ください。", "どうぞあたたかいおちゃをめしあがってください。", "Douzo atatakai ocha o meshiagatte kudasai.", "অনুগ্রহ করে গরম চা গ্রহণ করুন। (খাওয়া ও পানের সম্মানসূচক রূপ)", "দোওজো আতাতাকাই ওচা ও মেশিয়াগাত্তে কুদাসাই।", [("どうぞ", "douzo", "どうぞ", "দয়া করে"), ("温かい", "atatakai", "温かい", "গরম"), ("お茶を", "ocha o", "お茶を", "চা"), ("召し上がってください", "meshiagatte kudasai", "召し上がってください", "গ্রহণ করুন/পান করুন")]),
            make_item("jp-biz-p1-l1-004", "この 新しい 資料を ご覧に なりましたか。", "このあたらしいしりょうをごらんになりましたか。", "Kono atarashii shiryou o goran ni narimashita ka.", "এই নতুন নথিপত্রগুলো কি দেখেছেন? (দেখার সম্মানসূচক রূপ)", "কোনো আতারাসিই শিরিওও ও গোরান নি নারিমাশিতা কা?", [("この新しい", "kono atarashii", "この新しい", "এই নতুন"), ("資料を", "shiryou o", "資料を", "নথিপত্র"), ("ご覧になりましたか", "goran ni narimashita ka", "ご覧になりましたか", "দেখেছেন কি")])
        ]
    },
    {
        "id": "jp-biz-l02",
        "order": 2,
        "title_bn": "সাধারণ সম্মানসূচক গঠন — 'お + Verb Stem + になります'",
        "title_target": "Regular Honorific Formula (O + Stem + ni narimasu)",
        "intro_bn": "যেসব ক্রিয়ার বিশেষ সনকেইগো রূপ নেই, সেগুলোকে সম্মানসূচক করতে 'お + Verbます-stem + になります' অথবা অনুরোধে 'お + Verbます-stem + ください' বসে।",
        "structure": [
            "Affirmative: お + Verb-stem + に なります",
            "Request: お + Verb-stem + ください (অনুগ্রহ করে করুন)"
        ],
        "items": [
            make_item("jp-biz-p1-l2-001", "少々 こちらで お待ちに なりますか。", "しょうしょうこちらでおまちになりますか。", "Shoushou kochira de omachi ni narimasu ka.", "অনুগ্রহ করে একটু এখানে অপেক্ষা করবেন কি?", "শোওশোও কোচিরা দে ওমাচি নি নারিমাসু কা?", [("少々", "shoushou", "少々", "সামান্য একটু"), ("こちらで", "kochira de", "こちらで", "এখানে"), ("お待ちになりますか", "omachi ni narimasu ka", "お待ちになりますか", "অপেক্ষা করবেন কি")]),
            make_item("jp-biz-p1-l2-002", "どうぞ こちらに お掛け ください。", "どうぞこちらにおかけください。", "Douzo kochira ni okake kudasai.", "অনুগ্রহ করে এখানে আসন গ্রহণ করুন/বসুন।", "দোওজো কোচিরা নি ওকেকে কুদাসাই।", [("どうぞ", "douzo", "どうぞ", "দয়া করে"), ("こちらに", "kochira ni", "こちらに", "এখানে"), ("お掛けください", "okake kudasai", "お掛けください", "আসন গ্রহণ করুন/বসুন")]),
            make_item("jp-biz-p1-l2-003", "本日の 予定表を お読みに なりましたか。", "ほんじつのよていひょうをおよみになりましたか。", "Honjitsu no yoteihyou o oyomi ni narimashita ka.", "আজকের সময়সূচি কি পড়ে দেখেছেন?", "হোঞ্জিতসু নো ইয়োতেইহিয়োও ও ওয়োমি নি নারিমাশিতা কা?", [("本日の", "honjitsu no", "本日の", "আজকের"), ("予定表を", "yoteihyou o", "予定表を", "সময়সূচি"), ("お読みになりましたか", "oyomi ni narimashita ka", "お読みになりましたか", "পড়েছেন কি")])
        ]
    },
    {
        "id": "jp-biz-l03",
        "order": 3,
        "title_bn": "সম্মানসূচক উপসর্গ ও সুবিধাজনক সময় জিজ্ঞাসা ('お / ご' & ご都合)",
        "title_target": "Polite Prefixes & Inquiring Convenient Timing (Gotsugou)",
        "intro_bn": "জাপানি শব্দের শুরুতে 'お' এবং চীনা কাঞ্জি শব্দের শুরুতে 'ご' বসে। গ্রাহকের সুবিধাজনক সময় জানতে 'ご都合はいかがでしょうか' বলা হয়।",
        "structure": ["ご都合は いかがでしょうか (Is the timing convenient for you?)"],
        "items": [
            make_item("jp-biz-p1-l3-001", "来週の 火曜日の ご都合は いかがでしょうか。", "らいしゅうのかようびのごつごうわいかがでしょうか。", "Raishuu no kayoubi no gotsugou wa ikaga deshou ka.", "আগামী সপ্তাহের মঙ্গলবার আপনার সময় সুবিধা হবে কি?", "রাইশুউ নো কায়োওবি নো গোতসুগোও ওয়া ইকাগা দেশোও কা?", [("来週の火曜日の", "raishuu no kayoubi no", "来週の火曜日の", "আগামী সপ্তাহের মঙ্গলবারের"), ("ご都合は", "gotsugou wa", "ご都合は", "সময় ও সুযোগ"), ("いかがでしょうか", "ikaga deshou ka", "いかがでしょうか", "কেমন হবে")]),
            make_item("jp-biz-p1-l3-002", "内容を ご確認 いただけますでしょうか。", "ないようをごかくにんいただけますでしょうか。", "Naiyou o gokakunin itadakemasu deshou ka.", "বিষয়বস্তুটি কি অনুগ্রহ করে একটু যাচাই করে দেখবেন?", "নাইয়োও ও গোকাকুনিন ইতাদাকেমাসু দেশোও কা?", [("内容を", "naiyou o", "内容を", "বিষয়বস্তু"), ("ご確認いただけますでしょうか", "gokakunin itadakemasu deshou ka", "ご確認いただけますでしょうか", "যাচাই করে দেবেন কি")])
        ]
    }
]
parts.append({
    "id": "jp-business-p1",
    "order": 1,
    "level": "B1",
    "title_bn": "সম্মানসূচক ভাষা — সনকেইগো (Sonkeigo: Respectful Speech)",
    "title_target": "Sonkeigo: Honorific Respectful Speech for Clients & Superiors",
    "lessons": p1_lessons
})

# ==============================================================================
# PART 2: বিনম্র ভাষা — কেনজৌগো (Kenjougo: Humble Speech for Oneself)
# ==============================================================================
p2_lessons = [
    {
        "id": "jp-biz-l04",
        "order": 1,
        "title_bn": "বিশেষ বিনম্র ক্রিয়াপদ — '謙譲語' (Special Kenjougo Verbs)",
        "title_target": "Special Humble Verbs (Mairu, Mousu, Itasu, Haiken)",
        "intro_bn": "গ্রাহক বা ঊর্ধ্বতন ব্যক্তির সামনে নিজের বা নিজ প্রতিষ্ঠানের কাজ বিনম্রভাবে ব্যক্ত করতে কেনজৌগো বসে। যেমন: 行く/来る -> 参る (mairu), 言う -> 申す (mousu), する -> 致す (itasu), 見る -> 拝見する (haiken suru), 食べる/もらう -> いただく (itadaku)।",
        "structure": ["Speaker / In-Group + は + 謙譲語 (Kenjougo Verb)"],
        "items": [
            make_item("jp-biz-p1-l4-001", "わたしは ラヒムと 申します。", "わたしわらひむともうします。", "Watashi wa Rahimu to moushimasu.", "আমার নাম রহিম। (নিজের নাম বিনম্রভাবে বলার রূপ)", "ওয়াতাশি ওয়া রাহিমু তো মোওশিমাসু।", [("わたしは", "watashi wa", "私は", "আমি"), ("ラヒムと", "Rahimu to", "ラヒムと", "রহিম নামে"), ("申します", "moushimasu", "申します", "বিনীতভাবে পরিচিত/বলা")]),
            make_item("jp-biz-p1-l4-002", "明日 午前１０時に そちらへ 参ります。", "あしたごぜんじゅうじにそちらえまいります。", "Ashita gozen juuji ni sochira e mairimasu.", "আগামীকাল সকাল ১০টায় আপনাদের দফতরে উপস্থিত হব।", "আশিতা গোজেন জুউজি নি সোচিরা এ মাইরিমাসু।", [("明日午前１０時に", "ashita gozen juuji ni", "明日午前１０時に", "আগামীকাল সকাল ১০টায়"), ("そちらへ", "sochira e", "そちらへ", "আপনাদের ওখানে"), ("参ります", "mairimasu", "参ります", "উপস্থিত হব/যাব")]),
            make_item("jp-biz-p1-l4-003", "ただいまから プレゼンテーションを いたします。", "ただいまからぷれぜんてーしょんをいたします。", "Tadaima kara purezenteeshon o itashimasu.", "এখন থেকে প্রেজেন্টেশন উপস্থাপন করছি।", "তাদাইমা কারা পুরেজেনতেএশোন ও ইতাশিমাসু।", [("ただいまから", "tadaima kara", "ただ今から", "এখন থেকে"), ("プレゼンテーションを", "purezenteeshon o", "プレゼンテーションを", "প্রেজেন্টেশন"), ("いたします", "itashimasu", "いたします", "সম্পাদন করছি")]),
            make_item("jp-biz-p1-l4-004", "送って いただいた 資料を 拝見いたしました。", "おくっていただいたしりょうをはいけんいたしました。", "Okutte itadaita shiryou o haiken itashimashita.", "আপনার পাঠানো নথিপত্রগুলো গভীর শ্রদ্ধায় পর্যালোচনা করেছি।", "ওকুত্তে ইতাদাইতা শিরিওও ও হাইকেন ইতাশিমাশিতা।", [("送っていただいた", "okutte itadaita", "送っていただいた", "আপনার পাঠানো"), ("資料を", "shiryou o", "資料を", "নথিপত্র"), ("拝見いたしました", "haiken itashimashita", "拝見いたしました", "অবলোকন করেছি")])
        ]
    },
    {
        "id": "jp-biz-l05",
        "order": 2,
        "title_bn": "সাধারণ বিনম্র গঠন — 'お + Verb Stem + いたします'",
        "title_target": "Regular Humble Formula (O + Stem + itashimasu)",
        "intro_bn": "নিজের কোনো কাজের দ্বারা অপরকে সাহায্য বা সেবা প্রদান করতে বিনম্র রূপ: 'お + Verbます-stem + いたします' (যেমন: お持ちいたします = বহন করে দিচ্ছি)।",
        "structure": ["お + Verb-stem + いたします / ご + Noun + いたします"],
        "items": [
            make_item("jp-biz-p1-l5-001", "お荷物を お持ち いたしましょうか。", "おにもつをおもちいたしましょうか。", "Onimotsu o omochi itashimashou ka.", "আপনার মালামাল কি আমি বহন করে দেব?", "ওনিমোতসু ও ওমোচি ইতাশিমাশোও কা?", [("お荷物を", "onimotsu o", "お荷物を", "আপনার মালামাল"), ("お持ちいたしましょうか", "omochi itashimashou ka", "お持ちいたしましょうか", "বহন করে দেব কি")]),
            make_item("jp-biz-p1-l5-002", "詳しい 内容を ご案内 いたします。", "くわしいないようをごあんないいたします。", "Kuwashii naiyou o goannai itashimasu.", "বিস্তারিত বিষয়বস্তু আমি বুঝিয়ে ও প্রদর্শন করে দিচ্ছি।", "কুওয়াশিই নাইয়োও ও গোআন্নাই ইতাশিমাসু।", [("詳しい内容を", "kuwashii naiyou o", "詳しい内容を", "বিস্তারিত বিষয়বস্তু"), ("ご案内いたします", "goannai itashimasu", "ご案内いたします", "পরিদর্শন/ব্যাখ্যা করে দিচ্ছি")]),
            make_item("jp-biz-p1-l5-003", "後ほど メールで ご連絡 いたします。", "のちほどめーるでごれんらくいたします。", "Nochihodo meeru de gorenraku itashimasu.", "কিছুক্ষণ পর ইমেইলের মাধ্যমে যোগাযোগ করে নিচ্ছি।", "নোচিহো দো মেরু দে গোরেনরাকু ইতাশিমাসু।", [("後ほど", "nochihodo", "後ほど", "কিছুক্ষণ পরে"), ("メールで", "meeru de", "メールで", "ইমেইলে"), ("ご連絡いたします", "gorenraku itashimasu", "ご連絡いたします", "যোগাযোগ করব")])
        ]
    },
    {
        "id": "jp-biz-l06",
        "order": 3,
        "title_bn": "নিজ কোম্পানি ও দলীয় পরিচয় — '弊社' ও 'わたくし'",
        "title_target": "In-Group Humility (Heisha vs. Kisha / Watakushi)",
        "intro_bn": "জাপানি ব্যবসায়িক সংস্কৃতিতে নিজের কোম্পানিকে '弊社' (heisha - আমাদের বিনীত প্রতিষ্ঠান) এবং ক্লায়েন্টের কোম্পানিকে '貴社' (kisha) বা '御社' (onsha) বলা নিয়ম।",
        "structure": ["弊社の [Name] と 申します (I am [Name] from our company)"],
        "items": [
            make_item("jp-biz-p1-l6-001", "弊社は 新しい ITソリューションを 提供して おります。", "へいしゃわあたらしいあいてぃーそりゅーしょんをていきょうしております。", "Heisha wa atarashii aiteii soryuushon o teikyou shite orimasu.", "আমাদের প্রতিষ্ঠান সর্বাধুনিক আইটি সলিউশন সেবা প্রদান করে আসছে।", "হেইশা ওয়া আতারাসিই আইতিই সোরিউউশোন ও তেইকিওও শিতে ওরিমাছু।", [("弊社は", "heisha wa", "弊社は", "আমাদের প্রতিষ্ঠান"), ("新しいITソリューションを", "atarashii aiteii soryuushon o", "新しいITソリューションを", "নতুন আইটি সমাধান"), ("提供しております", "teikyou shite orimasu", "提供しております", "প্রদান করে আসছে")]),
            make_item("jp-biz-p1-l6-002", "御社の プロジェクトに ぜひ 参加させて いただきたいです。", "おんしゃのぷろじぇくとにぜひさんかさせていただきたいです。", "Onsha no purojekuto ni zehi sanka sasete itadakitai desu.", "আপনাদের সম্মানিত প্রতিষ্ঠানে প্রকল্পে অংশগ্রহণের সুযোগ পেতে আগ্রহী।", "ওনশা নো পুরোজেকুত নি জেহি সানকা সাসেতে ইতাদাকিতাই দেস।", [("御社の", "onsha no", "御社の", "আপনাদের কোম্পানির"), ("プロジェクトに", "purojekuto ni", "プロジェクトに", "প্রকল্পে"), ("参加させていただきたいです", "sanka sasete itadakitai desu", "参加させていただきたいです", "অংশগ্রহণের সুযোগ চাই")])
        ]
    }
]
parts.append({
    "id": "jp-business-p2",
    "order": 2,
    "level": "B1",
    "title_bn": "বিনম্র ভাষা — কেনজৌগো (Kenjougo: Humble Speech)",
    "title_target": "Kenjougo: Humble Speech for Oneself and In-Group",
    "lessons": p2_lessons
})

# ==============================================================================
# PART 3: অত্যন্ত বিনম্র অনুরোধ ও কুশন শব্দ (Ultra-Polite Requests & Cushion Words)
# ==============================================================================
p3_lessons = [
    {
        "id": "jp-biz-l07",
        "order": 1,
        "title_bn": "সর্বোচ্চ বিনম্র অনুরোধ — '〜て いただけませんでしょうか'",
        "title_target": "Ultra-polite Business Requests (~te itadakemasen deshou ka)",
        "intro_bn": "ক্লায়েন্ট বা প্রধান কর্মকর্তাকে কোনো বিষয়ে অত্যন্ত মার্জিতভাবে অনুরোধ করতে এই রূপটি ব্যবহার করা হয়।",
        "structure": ["Verb-て + いただけませんでしょうか (Could you kindly please...?)"],
        "items": [
            make_item("jp-biz-p1-l7-001", "もう 一度 ご説明 していただけませんでしょうか。", "もういちどごせつめいしていただけませんでしょうか。", "Mou ichido gosetsumei shite itadakemasen deshou ka.", "অনুগ্রহ করে আরও একবার কি বিষয়টি বুঝিয়ে দেবেন?", "মোও ইচিদো গোসেতসুমেই শিতে ইতাদাকেমাসেন দেশোও কা?", [("もう一度", "mou ichido", "もう一度", "আরও একবার"), ("ご説明していただけませんでしょうか", "gosetsumei shite itadakemasen deshou ka", "ご説明していただけませんでしょうか", "ব্যাখ্যা করে দেবেন কি")]),
            make_item("jp-biz-p1-l7-002", "お忙しい ところ 恐れ入りますが、ご確認 いただけますでしょうか。", "おいそがしいところおそれいりますが、ごかくにんいただけますでしょうか。", "Oisogashii tokoro osoreirimasu ga, gokakunin itadakemasu deshou ka.", "ব্যস্ততার মাঝে কষ্ট দিচ্ছি, তবে নথিপত্রটি কি একটু যাচাই করে দেখবেন?", "ওইসোগাশিই তোকোরো ওসোরেইরিমাসু গা, গোকাকুনিন ইতাদাকেমাসু দেশোও কা?", [("お忙しいところ", "oisogashii tokoro", "お忙しいところ", "ব্যস্ততার মুহূর্তে"), ("恐れ入りますが", "osoreirimasu ga", "恐れ入りますが", "ক্ষমা চেয়ে নিচ্ছি তবে"), ("ご確認いただけますでしょうか", "gokakunin itadakemasu deshou ka", "ご確認いただけますでしょうか", "যাচাই করে দেবেন কি")])
        ]
    },
    {
        "id": "jp-biz-l08",
        "order": 2,
        "title_bn": "কুশন শব্দ ও নরম বাক্য সূচনা (Cushion Words: クッション言葉)",
        "title_target": "Cushion Words in Business Japanese (Osoreirimasu ga / Otesuu desu ga)",
        "intro_bn": "সরাসরি অনুরোধ বা প্রশ্ন না করে বাক্যের শুরুতে নরম কুশন শব্দ ব্যবহার জাপানি ভদ্রতার প্রধান অংশ। যেমন: 恐れ入りますが (বিনম্র ক্ষমা চেয়ে বলছি), お手数をおかけしますが (কষ্ট দিচ্ছি বটে কিন্তু)।",
        "structure": ["Cushion Phrase + Request / Inquiry"],
        "items": [
            make_item("jp-biz-p1-l8-001", "恐れ入りますが、お名前を もう 一度 お伺いできますでしょうか。", "おそれいりますが、おなまえをもういちどおうかがいできますでしょうか。", "Osoreirimasu ga, onamae o mou ichido oukagai dekimasu deshou ka.", "বিনীতভাবে জানতে চাইছি, আপনার নামটি কি আরেকবার একটু বলবেন দয়া করে?", "ওসোরেইরিমাসু গা, ওনামায়ে ও মোও ইচিদো ওউকাগাই দেকিমাসু দেশোও কা?", [("恐れ入りますが", "osoreirimasu ga", "恐れ入りますが", "ক্ষমা চেয়ে বলছি"), ("お名前を", "onamae o", "お名前を", "আপনার নাম"), ("もう一度", "mou ichido", "もう一度", "আরও একবার"), ("お伺いできますでしょうか", "oukagai dekimasu deshou ka", "お伺いできますでしょうか", "জিজ্ঞাসা করতে পারি কি")]),
            make_item("jp-biz-p1-l8-002", "お手数をおかけしますが、ご返信を お願い申し上げます。", "おてすうをおかけしますが、ごへんしんをおねがいもうしあげます。", "Otesuu o okake shimasu ga, gohenshin o onegai moushiagemasu.", "আপনাকে শ্রম দিচ্ছি, তবে দয়া করে প্রত্যুত্তর পাঠানোর বিনীত অনুরোধ রইল।", "ওতেসুউ ও ওকেকে শিমাসু গা, গোহেনশিন ও ওনেগাই মোওশিয়াগেমাসু।", [("お手数をおかけしますが", "otesuu o okake shimasu ga", "お手数をおかけしますが", "আপনাকে কষ্ট দিচ্ছি তবে"), ("ご返信を", "gohenshin o", "ご返信を", "উত্তর"), ("お願い申し上げます", "onegai moushiagemasu", "お願い申し上げます", "অনুরোধ জ্ঞাপন করছি")])
        ]
    },
    {
        "id": "jp-biz-l09",
        "order": 3,
        "title_bn": "বিনম্রভাবে প্রস্তাব প্রত্যাখ্যান (Polite Declination: 見送らせていただきます)",
        "title_target": "Politely Declining in Business Contexts",
        "intro_bn": "ব্যবসায় সরাসরি 'না' বলা অশোভন। বিনম্র কৌশলে প্রস্তাব পিছিয়ে দেওয়া বা অমত প্রকাশ করা হয়।",
        "structure": ["あいにくですが / せっかくですが、今回は見送らせていただきます"],
        "items": [
            make_item("jp-biz-p1-l9-001", "あいにくですが、その日は 先約が ございまして。", "あいにくですが、そのひわせんやくがございまして。", "Ainiku desu ga, sono hi wa senyaku ga gozaimashite.", "দুঃখজনক হলেও সত্যি, ওই দিন আগে থেকেই আমার অন্য একটি অ্যাপয়েন্টমেন্ট রয়েছে।", "আইনিকু দেসু গা, সোনো হি ওয়া সেনইয়াকু গা গোজাইমাশিতে।", [("あいにくですが", "ainiku desu ga", "あいにくですが", "দুর্ভাগ্যবশত"), ("その日は", "sono hi wa", "その日は", "ওই দিন"), ("先約がございまして", "senyaku ga gozaimashite", "先約がございまして", "আগের প্রতিশ্রুত কাজ থাকায়")]),
            make_item("jp-biz-p1-l9-002", "大変 申し上げにくいのですが、今回は 見送らせて いただきます。", "たいへんもうしあげにくいのですが、こんかいわみおくらせていただきます。", "Taihen moushiagenikui no desu ga, konkai wa miokurasete itadakimasu.", "বলতে অত্যন্ত কষ্ট হচ্ছে, তবে এবারের মতো বিষয়টি স্থগিত বা ফিরিয়ে দিতে বাধ্য হচ্ছি।", "তাইহেন মোওশিয়াগেনিকুই নো দেসু গা, কোনকাই ওয়া মিওকুরাসেতে ইতাদাকিমাসু।", [("大変申し上げにくいのですが", "taihen moushiagenikui no desu ga", "大変申し上げにくいのですが", "বলতে সত্যিই অনুচিত লাগছে"), ("今回は", "konkai wa", "今回は", "এবারকার মতো"), ("見送らせていただきます", "miokurasete itadakimasu", "見送らせていただきます", "স্থগিত রাখার অনুমতি নিচ্ছি")])
        ]
    }
]
parts.append({
    "id": "jp-business-p3",
    "order": 3,
    "level": "B1",
    "title_bn": "অত্যন্ত বিনম্র অনুরোধ ও কুশন শব্দ (Ultra-Polite Requests & Cushion Words)",
    "title_target": "Ultra-Polite Requests, Cushion Words & Professional Declining",
    "lessons": p3_lessons
})

# ==============================================================================
# PART 4: টেলিফোন ও ইমেইল যোগাযোগ (Telephone & Corporate Discourse)
# ==============================================================================
p4_lessons = [
    {
        "id": "jp-biz-l10",
        "order": 1,
        "title_bn": "টেলিফোন রিসিভ ও সৌজন্য সম্ভাষণ (Business Phone Etiquette)",
        "title_target": "Receiving Calls & Formal Phone Greetings",
        "intro_bn": "জাপানি অফিসে ফোন ধরার সময় 'お世話になっております' এবং পরিচয় প্রদান কর্পোরেট শালীনতার নিয়ম।",
        "structure": ["はい、[Company] で ございます。いつも お世話に なっております"],
        "items": [
            make_item("jp-biz-p1-l10-001", "はい、ABC商事で ございます。いつも お世話に なって おります。", "はい、えーびーしーしょうじでございます。いつもおせわになっております。", "Hai, Eebiishee shouji de gozaimasu. Itsumo osewa ni natte orimasu.", "হ্যাঁ, এটি এবিসি ট্রেডিং কোম্পানি বলছি। আপনাদের নিরবচ্ছিন্ন সহযোগিতার জন্য ধন্যবাদ।", "হাই, এবিসি শোওজি দে গোজাইমাসু। ইতসুমো ওসেওয়া নি নাত্তে ওরিমাছু।", item_type="dialogue"),
            make_item("jp-biz-p1-l10-002", "田中部長は いらっしゃいますでしょうか。", "たなかぶちょうわいらっしゃいますでしょうか。", "Tanaka-buchou wa irasshaimasu deshou ka.", "ডিপার্টমেন্ট প্রধান তানাকা বাবু কি উপস্থিত আছেন?", "তানাকা-বুচোও ওয়া ইরাশ্শাইমাসু দেশোও কা?", item_type="dialogue")
        ]
    },
    {
        "id": "jp-biz-l11",
        "order": 2,
        "title_bn": "অনুপস্থিতি ও কল স্থানান্তর (Call Transfer & Absence Handling)",
        "title_target": "Handling Absences & Transferring Business Calls",
        "intro_bn": "কর্মকর্তা অনুপস্থিত থাকলে বা বাইরে থাকলে তা ক্লায়েন্টকে সম্মান জানিয়ে প্রকাশ করা এবং ফিরতি কলের প্রস্তাব দেওয়া।",
        "structure": ["ただいま 席を 外して おります / 折り返し お電話 差し上げます"],
        "items": [
            make_item("jp-biz-p1-l11-001", "あいにく 田中は ただいま 外出して おります。", "あいにくたなかわただいまがいしゅつしております。", "Ainiku Tanaka wa tadaima gaishutsu shite orimasu.", "দুঃখজনকভাবে তানাকা বাবু এই মুহূর্তে বাইরে অবস্থান করছেন।", "আইনিকু তানাকা ওয়া তাদাইমা গাইশুতসু শিতে ওরিমাছু।", item_type="dialogue"),
            make_item("jp-biz-p1-l11-002", "戻り次第、こちらから 折り返し お電話 差し上げましょうか。", "もどりしだい、こちらからおりかえしおでんわさしあげましょうか。", "Modori shidai, kochira kara orikaeshi odenwa sashiagemashou ka.", "তিনি দফতরে ফেরা মাত্রই আমাদের পক্ষ থেকে কি আপনাকে ফিরতি কল দিতে বলব?", "মোদোরিশিদাই, কোচিরা কারা ওরিকাএশি ওদেনওয়া সাশিয়াগেমাশোও কা?", item_type="dialogue")
        ]
    },
    {
        "id": "jp-biz-l12",
        "order": 3,
        "title_bn": "কর্পোরেট দুঃখপ্রকাশ ও ক্ষমা প্রার্থনা (Formal Corporate Apologies)",
        "title_target": "Corporate Apologies (Taihen Moushiwake Gozaimasen)",
        "intro_bn": "ব্যবসায়িক যোগাযোগে কোনো বিলম্ব বা ত্রুটিতে আন্তরিক দুঃখ প্রকাশে '大変 申し訳ございません' বসে।",
        "structure": ["大変 申し訳ございません (I sincerely apologize)"],
        "items": [
            make_item("jp-biz-p1-l12-001", "返信が 遅くなり、大変 申し訳ございません。", "へんしんがおそくなり、たいへんもうしわけございません。", "Henshin ga osokunari, taihen moushiwake gozaimasen.", "উত্তর দিতে বিলম্ব হওয়ায় আমি আন্তরিকভাবে ক্ষমা প্রার্থনা করছি।", "হেনশিন গা ওসোকুনারি, তাইহেন মোওশিওয়াকে গোজাইমাসেন।"),
            make_item("jp-biz-p1-l12-002", "ご迷惑を おかけして、誠に 申し訳ございません。", "ごめいわくをおかけして、まことにもうしわけございません。", "Gomeiwaku o okake shite, makoto ni moushiwake gozaimasen.", "আপনাদের অসুবিধায় ফেলার জন্য সত্যিই অত্যন্ত দুঃখ প্রকাশ করছি।", "গোমেইওয়াকু ও ওকেকে শিতে, মাকোতো নি মোওশিওয়াকে গোজাইমাসেন।")
        ]
    }
]
parts.append({
    "id": "jp-business-p4",
    "order": 4,
    "level": "B1",
    "title_bn": "টেলিফোন ও ইমেইল যোগাযোগ (Telephone & Corporate Discourse)",
    "title_target": "Business Telephone Etiquette, Call Transfers & Formal Apologies",
    "lessons": p4_lessons
})

# ==============================================================================
# PART 5: উচ্চতর ব্যাকরণ ও মনস্তাত্ত্বিক কারণ (Advanced Nuance: N3/N2 Grammar)
# ==============================================================================
p5_lessons = [
    {
        "id": "jp-biz-l13",
        "order": 1,
        "title_bn": "কৃতজ্ঞতা বনাম দোষারোপ — '〜おかげで' বনাম '〜せいで'",
        "title_target": "Attribution: Okage de (Thanks to) vs. Sei de (Due to fault)",
        "intro_bn": "ইতিবাচক ভালো ফলাফলের ক্ষেত্রে কারো অবদানের প্রতি কৃতজ্ঞতা জানাতে '〜おかげで' এবং নেতিবাচক ক্ষতিতে '〜せいで' বসে।",
        "structure": [
            "Good: Noun の / Verb + おかげで (কারো কৃপায়/সহযোগিতায়)",
            "Bad: Noun の / Verb + せいで (কারো ভুলের কারণে/বিপত্তিতে)"
        ],
        "items": [
            make_item("jp-biz-p1-l13-001", "先生の おかげで、JLPTに 合格できました。", "せんせいのおかげで、じぇいえるぴーてぃーにごうかくできました。", "Sensei no okage de, JLPT ni goukaku dekimashita.", "শিক্ষকের অনুপ্রেরণা ও অবদানের কারণে JLPT পরীক্ষায় উত্তীর্ণ হতে পেরেছি।", "সেনসেই নো ওকেগে দে, জেএলপিটি নি গোওকাকু দেকিমাশিতা।"),
            make_item("jp-biz-p1-l13-002", "台風の せいで、飛行機が 欠航に なりました。", "たいふうのせいで、ひこうきがけっこうになりました。", "Taifuu no sei de, hikouki ga kekkou ni narimashita.", "টাইফুনের বিপত্তির কারণে ফ্লাইট বাতিল হয়ে গেল।", "তাইফুউ নো সেই দে, হিকোওকি গা কেক্কোও নি নারিমাশিতা।", polarity="negative")
        ]
    },
    {
        "id": "jp-biz-l14",
        "order": 2,
        "title_bn": "ভিত্তি ও মূলনীতি — '〜に基づいて' (Based upon / In accordance with)",
        "title_target": "Grammar: ~ni motozuite (Based on facts / data)",
        "intro_bn": "কোনো গবেষণা, চুক্তি বা তথ্যের ভিত্তিতে কোনো কর্ম সম্পাদন করা বোঝাতে '〜に基づいて' (ni motozuite) বসে।",
        "structure": ["Noun + に 基づいて + Action (তথ্য/নীতির ভিত্তিতে)"],
        "items": [
            make_item("jp-biz-p1-l14-001", "最新の データに 基づいて、計画を 立てました。", "さいしんのでーたにもとづいて、けいかくをたてました。", "Saishin no deeta ni motozuite, keikaku o tatemashita.", "সর্বাধুনিক তথ্যের ওপর ভিত্তি করে কর্মপরিকল্পনা প্রণয়ন করেছি।", "সাইশিন নো দেএতা নি মোতোজুইতে, কেইকাকু ও তাতেমাশিতা।"),
            make_item("jp-biz-p1-l14-002", "法律に 基づいて、公正に 処理いたします。", "ほうりつにもとづいて、こうせいにしょりいたします。", "Houritsu ni motozuite, kousei ni shori itashimasu.", "আইন অনুযায়ী যথাযথ ন্যায়পরায়ণতার সাথে নিষ্পত্তি করব।", "হোওরিতসু নি মোতোজুইতে, কোওসেই নি শোরি ইতাশিমাসু।")
        ]
    },
    {
        "id": "jp-biz-l15",
        "order": 3,
        "title_bn": "সুদৃঢ় অনুমান — '〜に 違いない' (Must surely be)",
        "title_target": "Strong Supposition (~ni chigainai: There's no mistake that)",
        "intro_bn": "তথ্যপ্রমাণের ভিত্তিতে কোনো বিষয় নিশ্চিত মনে হলে '〜に 違いない' (কোনো সন্দেহ নেই যে...) বসে।",
        "structure": ["Plain Form + に 違いない (নিশ্চিতভাবেই এটি হবে)"],
        "items": [
            make_item("jp-biz-p1-l15-001", "彼は 毎日 努力して いるから、成功するに 違いない。", "かれわまいにちどりょくしているから、せいこうするにちがいない。", "Kare wa mainichi doryoku shite iru kara, seikou suru ni chigainai.", "সে প্রতিদিন নিরন্তর পরিশ্রম করছে, কাজেই সে সফল হবেই এতে সন্দেহ নেই।", "কারে ওয়া মাইনিচি দোরিওকু শিতে ইরু কারা, সেইকোও সুরু নি চিগাইনাই।"),
            make_item("jp-biz-p1-l15-002", "この 新製品は 市場で 人気が出るに 違いない。", "このしんせいひんわしじょうでにんきがでるにちがいない。", "Kono shinseihin wa shijou de ninki ga deru ni chigainai.", "এই নতুন পণ্যটি বাজারে অত্যন্ত জনপ্রিয়তা পাবে তাতে কোনো সন্দেহ নেই।", "কোনো শিনসেইহিন ওয়া শিজোও দে নিনকি গা দেরু নি চিগাইনাই।")
        ]
    }
]
parts.append({
    "id": "jp-business-p5",
    "order": 5,
    "level": "B1",
    "title_bn": "উচ্চতর ব্যাকরণ ও মনস্তাত্ত্বিক কারণ (Advanced Nuance: N3/N2 Grammar)",
    "title_target": "Advanced Grammar & Nuances (~okage de, ~ni motozuite, ~ni chigainai)",
    "lessons": p5_lessons
})

# ==============================================================================
# PART 6: প্রতিক্রিয়া ও মিটিংয়ে মতবিনিময় (Aizuchi & Meeting Discussions)
# ==============================================================================
p6_lessons = [
    {
        "id": "jp-biz-l16",
        "order": 1,
        "title_bn": "মার্জিত শ্রোতা প্রতিক্রিয়া — '相槌' (Professional Aizuchi)",
        "title_target": "Professional Conversational Fillers (Ossharu toori de gozaimasu)",
        "intro_bn": "পেশাদার পরিবেশে অপরপক্ষের বক্তব্য সমর্থনের মার্জিত ভাষা: 'おっしゃる通りでございます' (আপনি একদম ঠিক বলেছেন), '確かにそうでございます' (নিশ্চয়ই তাই)।",
        "structure": ["Professional Aizuchi Reactions"],
        "items": [
            make_item("jp-biz-p1-l16-001", "おっしゃる 通りで ございます。大変 勉強に なります。", "おっしゃるとおりでございます。たいへんべんきょうになります。", "Ossharu toori de gozaimasu. Taihen benkyou ni narimasu.", "আপনি যথার্থই বলেছেন। অনেক মূল্যবান বিষয় শিখতে পারলাম।", "ওশ্শারু তোওরি দে গোজাইমাসু। তাইহেন বেনকিওও নি নারিমাসু।", item_type="dialogue"),
            make_item("jp-biz-p1-l16-002", "確かに その通りですね。ご指摘 ありがとうございます。", "たしかにそのとおりですね。ごしてきありがとうございます。", "Tashika ni sono toori desu ne. Goshiteki arigatou gozaimasu.", "নিশ্চয়ই বিষয়টি ঠিক তাই। ধরিয়ে দেওয়ার জন্য ধন্যবাদ।", "তাশিকানি সোনো তোওরি দেসু নে। গোশিতেকি আরিগাতোও গোজাইমাসু।", item_type="dialogue")
        ]
    },
    {
        "id": "jp-biz-l17",
        "order": 2,
        "title_bn": "মিটিংয়ে বিনম্র দ্বিমত প্রকাশ (Expressing Disagreement Professionally)",
        "title_target": "Expressing Professional Disagreement in Meetings",
        "intro_bn": "অন্যের মতামতের সরাসরি বিরোধিতা না করে নিজের উদ্বেগ তুলে ধরা।",
        "structure": ["その点につきましては、少し 懸念が ございます"],
        "items": [
            make_item("jp-biz-p1-l17-001", "その 点につきましては、少々 懸念が ございます。", "そのてんにつきましてわ、しょうしょうけねんがございます。", "Sono ten ni tsukimashite wa, shoushou kenen ga gozaimasu.", "ওই বিষয়টিতে আমাদের সামান্য কিছুটা উদ্বেগ বা সংশয় রয়েছে।", "সোনো তেন নি তসুকিমাশিতে ওয়া, শোওশোও কেনেন গা গোজাইমাসু।"),
            make_item("jp-biz-p1-l17-002", "別の 視点からも 検討して みては いかがでしょうか。", "べつのしてんからもけんとうしてみてわいかがでしょうか。", "Betsu no shiten kara mo kentou shite mite wa ikaga deshou ka.", "ভিন্ন একটি দৃষ্টিকোণ থেকেও বিষয়টি পর্যালোচনা করে দেখলে কেমন হয়?", "বেতসু নো শিতেন কারা মো কেনতোও শিতে মিতে ওয়া ইকাগা দেশোও কা?")
        ]
    }
]
parts.append({
    "id": "jp-business-p6",
    "order": 6,
    "level": "B1",
    "title_bn": "প্রতিক্রিয়া ও মিটিংয়ে মতবিনিময় (Aizuchi & Meeting Discussions)",
    "title_target": "Aizuchi Reactions & Constructive Meeting Discussions",
    "lessons": p6_lessons
})

# ==============================================================================
# PART 7: জব ইন্টারভিউ ও কেইগো ৬-রূপান্তর চূড়ান্ত মাস্টার ড্রিল (Interview & Drill)
# ==============================================================================
p7_lessons = [
    {
        "id": "jp-biz-l18",
        "order": 1,
        "title_bn": "বাস্তব জব ইন্টারভিউ: আবেদনের কারণ ও ইতিবাচক গুণ (Interview Simulation)",
        "title_target": "Corporate Job Interview Q&A Simulation",
        "intro_bn": "জাপানি কোম্পানিতে চাকরি বা পেশাদার ইন্টারভিউতে আবেদনের উদ্দেশ্য (志望動機) ও নিজের গুণাবলী (長所) বর্ণনার আদর্শ উত্তর।",
        "structure": ["Interviewer Question <-> Formal Humble Response"],
        "items": [
            make_item("jp-biz-p1-l18-001", "志望動機を お聞かせ いただけますでしょうか。日本の 先端技術を 学び、貴社に 貢献したいと 思いました。", "しぼうどうきをおきかせいただけますでしょうか。にほんのせんたんぎじゅつをまなび、きしゃにこうけんしたいとおもいました。", "Shibou douki o okikase itadakemasu deshou ka. Nihon no sentan gijutsu o manabi, kisha ni kouken shitai to omoimashita.", "আবেদনের কারণ জানাতে পারেন কি? জাপানের সর্বাধুনিক প্রযুক্তি শিখে আপনাদের কোম্পানিতে অবদান রাখতে আগ্রহী হয়েছি।", "শিবোও দোওকি ও ওকিকাসে ইতাদাকেমাসু দেশোও কা? নিহোন নো সেনতান গিজুতসু ও মানাবি, কিশা নি কোওকেন শিতাই তো ওমোইমাশিতা।", item_type="dialogue"),
            make_item("jp-biz-p1-l18-002", "ご自身の 長所は 何ですか。粘り強く 最後まで やり抜く ことです。", "ごじしんのちょうしょわなんですか。ねばりづよくさいごまでやりぬくことです。", "Gojishin no chousho wa nan desu ka. Nebarizuyoku saigo made yarinuku koto desu.", "আপনার ইতিবাচক গুণ কী? শেষ মুহূর্ত পর্যন্ত একাগ্র নিষ্ঠার সাথে কাজ সম্পন্ন করা।", "গোজিশিন নো চোওশো ওয়া নান দেসু কা? নেবারিজুয়োকু সাইগো মাদে ইয়ারিনুকু কোতো দেস।", item_type="dialogue")
        ]
    },
    {
        "id": "jp-biz-l19",
        "order": 2,
        "title_bn": "কেইগো ৬-রূপান্তর চূড়ান্ত মাস্টার ড্রিল (Master 6-Way Keigo Transformation)",
        "title_target": "Master 6-Way Register Transformation (Casual to Humble Keigo)",
        "intro_bn": "একই বক্তব্যকে পরিস্থিতিভেদে সাধারণ কথ্য রূপ থেকে শুরু করে বিনম্র কেইগোতে তাৎক্ষণিক রূপান্তরের স্পোকেন ড্রিল।",
        "structure": [
            "১. সাধারণ কথ্য (Casual): 行く (যাব)",
            "২. মার্জিত সাধারণ (Teinei): 行きます (যাব - ভদ্র)",
            "৩. সম্মানসূচক (Sonkeigo): いらっしゃる / おいでになる (আপনি যাবেন)",
            "৪. বিনম্র (Kenjougo): 参る / 伺う (আমি উপস্থিত হব)",
            "৫. সর্বোচ্চ মার্জিত (Polite Request): お越し いただけますでしょうか",
            "৬. বিনীত প্রতিবেদন (Humble Statement): ただいま 参上いたしました"
        ],
        "items": [
            make_item("jp-biz-p1-l19-001", "明日 そっちへ 行くよ。", "あしたそっちえいくよ。", "Ashita sotchi e iku yo.", "১. ইনফরমাল বন্ধুমহল: কাল তোদের ওখানে যাব।", "আশিতা সোচ্চি এ ইকু ইয়ো।", item_type="drill"),
            make_item("jp-biz-p1-l19-002", "明日 そちらへ 行きます。", "あしたそちらえいきます。", "Ashita sochira e ikimasu.", "২. মার্জিত সাধারণ: কাল আপনাদের ওখানে যাব।", "আশিতা সোচিরা এ ইকিমাসু।", item_type="drill"),
            make_item("jp-biz-p1-l19-003", "明日 社長は そちらへ いらっしゃいますか。", "あしたしゃちょうわそちらえいらっしゃいますか。", "Ashita shachou wa sochira e irasshaimasu ka.", "৩. সনকেইগো সম্মানসূচক: কাল কি সিইও মহোদয় আপনাদের ওখানে যাবেন?", "আশিতা শাচোও ওয়া সোচিরা এ ইরাশ্শাইমাসু কা?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-biz-p1-l19-004", "明日 わたしが そちらへ 参ります。", "あしたわたしがそちらえまいります。", "Ashita watashi ga sochira e mairimasu.", "৪. কেনজৌগো বিনম্র: কাল আমি আপনাদের ওখানে বিনীতভাবে উপস্থিত হব।", "আশিতা ওয়াতাশি গা সোচিরা এ মাইরিমাসু।", item_type="drill"),
            make_item("jp-biz-p1-l19-005", "明日 弊社へ お越し いただけますでしょうか。", "あしたへいしゃえおこしいただけますでしょうか。", "Ashita heisha e okoshi itadakemasu deshou ka.", "৫. সর্বোচ্চ বিনম্র আমন্ত্রণ: কাল কি দয়া করে আমাদের প্রতিষ্ঠানে পদার্পণ করবেন?", "আশিতা হেইশা এ ওকোশি ইতাদাকেমাসু দেশোও কা?", item_type="drill", sentence_type="interrogative"),
            make_item("jp-biz-p1-l19-006", "明日 そちらへ 伺いますか、弊社で お待ちしますか。", "あしたそちらえうかがいますか、へいしゃでおまちしますか。", "Ashita sochira e ukagaimasu ka, heisha de omachishimasu ka.", "৬. বিকল্প প্রশ্ন: কাল কি আমি আপনাদের ওখানে আসব, নাকি আমাদের দফতরে অপেক্ষা করব?", "আশিতা সোচিরা এ উকাগাইমাসু কা, হেইশা দে ওমাচিশিমাসু কা?", item_type="drill", sentence_type="alternative_question")
        ]
    }
]
parts.append({
    "id": "jp-business-p7",
    "order": 7,
    "level": "B1",
    "title_bn": "জব ইন্টারভিউ ও কেইগো ৬-রূপান্তর চূড়ান্ত মাস্টার ড্রিল (Interview & Keigo Drill)",
    "title_target": "Interview Simulation & Master 6-Way Keigo Register Transformation",
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

print(f"Course 4 successfully built and saved to: {DEST_FILE}")
print(f"Total Parts: {len(parts)}")
print(f"Total Lessons: {total_lessons}")
print(f"Total Items: {total_items}")
