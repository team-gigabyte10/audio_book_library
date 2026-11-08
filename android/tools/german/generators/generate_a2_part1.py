"""Generates Level A2 Part 1 (Units de-a2-01 to de-a2-08) for German Spoken Course."""
import re

IGNORED = re.compile(r"[\s\u200c\u200d,.?!:;'\-—…\"„”«»]")

def make_item(stem, lesson_no, index, target, bn, bn_pron, tokens, gender=None, speaker=None, item_type="sentence"):
    # Validate token matching
    joined = "".join(t["t"] for t in tokens)
    cleaned_joined = IGNORED.sub("", joined)
    cleaned_target = IGNORED.sub("", target)
    if cleaned_joined != cleaned_target:
        raise ValueError(f"Token mismatch in {stem} l{lesson_no} #{index}: '{cleaned_joined}' != '{cleaned_target}'")

    item_id = f"{stem}-l{lesson_no:02d}-{index:03d}"
    out = {
        "id": item_id,
        "concept_id": f"c-{item_id}",
        "order": index,
        "type": item_type,
        "level": "A2",
        "target": target.strip(),
        "bn": bn.strip(),
        "bn_pron": bn_pron.strip(),
        "tokens": [{"t": t["t"], "bn": t.get("bn")} for t in tokens],
        "tags": {"cefr": "A2"},
        "status": "ready",
        "review_flags": []
    }
    if gender:
        out["gender"] = gender
    if speaker:
        out["speaker"] = speaker
    return out

parts_p1 = []

# =========================================================================
# Unit de-a2-01: অপ্রত্যক্ষ কর্ম: ডাটিক কেস (The Dativ Case)
# =========================================================================
p1_lessons = [
    {
        "title_bn": "ডাটিক প্রোনাউন (mir, dir, ihm, ihr, uns, Ihnen)",
        "title_target": "Dativpronomen: mir, dir, ihm, ihr, uns, Ihnen",
        "intro_bn": "জার্মান ডাটিক কেসে ব্যক্তিবচক সর্বনামগুলো পরিবর্তিত হয়: mir (আমাকে), dir (তোমাকে), ihm (তাকে-পুং/ক্লীব), ihr (তাকে-স্ত্রী), uns (আমাদের), Ihnen (আপনাকে)।",
        "structure": ["Subjekt", "Verb", "Dativobjekt"],
        "items": [
            ("Wie geht es dir?", "তোমার কেমন চলছে?", "ভী গেট এস ডিয়ার",
             [{"t": "Wie", "bn": "কেমন"}, {"t": "geht", "bn": "যায়/চলছে"}, {"t": "es", "bn": "এটি"}, {"t": "dir?", "bn": "তোমার"}]),
            ("Es geht mir sehr gut, danke.", "আমার খুব ভালো চলছে, ধন্যবাদ।", "এস গেট মিয়ার জেয়ার গুট ডাঙ্কে",
             [{"t": "Es", "bn": "এটি"}, {"t": "geht", "bn": "যায়/চলছে"}, {"t": "mir", "bn": "আমার"}, {"t": "sehr", "bn": "খুব"}, {"t": "gut,", "bn": "ভালো"}, {"t": "danke.", "bn": "ধন্যবাদ"}]),
            ("Wie geht es Ihnen, Herr Müller?", "আপনার কেমন চলছে, মিস্টার ম্যুলার?", "ভী গেট এস ইনেন হেয়ার ম্যুলার",
             [{"t": "Wie", "bn": "কেমন"}, {"t": "geht", "bn": "যায়/চলছে"}, {"t": "es", "bn": "এটি"}, {"t": "Ihnen,", "bn": "আপনার"}, {"t": "Herr", "bn": "মিস্টার"}, {"t": "Müller?", "bn": "ম্যুলার"}]),
            ("Ich danke Ihnen von Herzen.", "আমি আপনাকে আন্তরিকভাবে ধন্যবাদ জানাই।", "ইখ্ ডাঙ্কে ইনেন ফন হেয়ারৎসেন",
             [{"t": "Ich", "bn": "আমি"}, {"t": "danke", "bn": "ধন্যবাদ জানাই"}, {"t": "Ihnen", "bn": "আপনাকে"}, {"t": "von", "bn": "থেকে"}, {"t": "Herzen.", "bn": "হৃদয়"}]),
            ("Kannst du mir bitte helfen?", "তুমি কি দয়া করে আমাকে সাহায্য করতে পারো?", "কান্স্ট দু মিয়ার বিটে হেলফেন",
             [{"t": "Kannst", "bn": "পারো কি"}, {"t": "du", "bn": "তুমি"}, {"t": "mir", "bn": "আমাকে"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "helfen?", "bn": "সাহায্য করতে"}]),
            ("Ich gebe ihm das Buch.", "আমি তাকে বইটি দিচ্ছি।", "ইখ্ গেবে ইম ডাস বুখ",
             [{"t": "Ich", "bn": "আমি"}, {"t": "gebe", "bn": "দিচ্ছি"}, {"t": "ihm", "bn": "তাকে"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Buch.", "bn": "বই"}]),
            ("Wir schenken ihr Blumen.", "আমরা তাকে ফুল উপহার দিচ্ছি।", "ভির শেঙ্কেন ইয়ার ব্লুমেন",
             [{"t": "Wir", "bn": "আমরা"}, {"t": "schenken", "bn": "উপহার দিচ্ছি"}, {"t": "ihr", "bn": "তাকে"}, {"t": "Blumen.", "bn": "ফুলগুলো"}]),
            ("Das schmeckt uns wirklich lecker.", "এটা আমাদের সত্যিই সুস্বাদু লাগছে।", "ডাস শমেকট উন্স ভির্ক্লিখ লেকার",
             [{"t": "Das", "bn": "এটি"}, {"t": "schmeckt", "bn": "স্বাদ দেয়"}, {"t": "uns", "bn": "আমাদের"}, {"t": "wirklich", "bn": "সত্যিই"}, {"t": "lecker.", "bn": "সুস্বাদু"}]),
        ]
    },
    {
        "title_bn": "আর্টিকেলের ডাটিক রূপ (dem Mann, der Frau, dem Kind, den Kindern)",
        "title_target": "Artikel im Dativ: dem, der, den",
        "intro_bn": "ডাটিক কেসে নির্দিষ্ট আর্টিকেল পরিবর্তিত হয়: der -> dem, die -> der, das -> dem, এবং বহুবচনে die -> den (সাথে বিশেষ্যের শেষে সাধারণত -n যোগ হয়)।",
        "structure": ["Subjekt", "Verb", "Dativ (Artikel + Nomen)"],
        "items": [
            ("Ich helfe dem Mann.", "আমি লোকটিকে সাহায্য করছি।", "ইখ্ হেলফে ডেম মান",
             [{"t": "Ich", "bn": "আমি"}, {"t": "helfe", "bn": "সাহায্য করছি"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Mann.", "bn": "লোকটিকে"}]),
            ("Er antwortet der Frau höflich.", "সে ভদ্রমহিলাকে ভদ্রভাবে উত্তর দিচ্ছে।", "এয়ার আনটভোরটেট ডের ফ্রাউ হোয়ফ্লিখ",
             [{"t": "Er", "bn": "সে"}, {"t": "antwortet", "bn": "উত্তর দিচ্ছে"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Frau", "bn": "ভদ্রমহিলাকে"}, {"t": "höflich.", "bn": "ভদ্রভাবে"}]),
            ("Die Mutter gibt dem Kind einen Apfel.", "মা শিশুটিকে একটি আপেল দিচ্ছেন।", "ডি মুটার গিব্ট ডেম কিন্ট আইনেন আপফেল",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Mutter", "bn": "মা"}, {"t": "gibt", "bn": "দিচ্ছেন"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Kind", "bn": "শিশুটিকে"}, {"t": "einen", "bn": "একটি"}, {"t": "Apfel.", "bn": "আপেল"}]),
            ("Wir helfen den Kindern bei den Hausaufgaben.", "আমরা শিশুদের হোমওয়ার্কে সাহায্য করছি।", "ভির হেলফেন ডেন কিন্ডার্ন বাই ডেন হাউসআউফগাবেন",
             [{"t": "Wir", "bn": "আমরা"}, {"t": "helfen", "bn": "সাহায্য করছি"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Kindern", "bn": "শিশুদেরকে"}, {"t": "bei", "bn": "এ"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Hausaufgaben.", "bn": "হোমওয়ার্ক"}]),
            ("Ich gebe einem Freund einen Rat.", "আমি একজন বন্ধুকে একটি পরামর্শ দিচ্ছি।", "ইখ্ গেবে আইনেন ফ্রয়ন্ট আইনেন রাট",
             [{"t": "Ich", "bn": "আমি"}, {"t": "gebe", "bn": "দিচ্ছি"}, {"t": "einem", "bn": "একজন"}, {"t": "Freund", "bn": "বন্ধুকে"}, {"t": "einen", "bn": "একটি"}, {"t": "Rat.", "bn": "পরামর্শ"}]),
            ("Er schenkt einer Kollegin Schokolade.", "সে একজন সহকর্মীকে চকলেট উপহার দিচ্ছে।", "এয়ার শেঙ্কট আইনেয়ার কোলেগিন শকোলাডে",
             [{"t": "Er", "bn": "সে"}, {"t": "schenkt", "bn": "উপহার দিচ্ছে"}, {"t": "einer", "bn": "একজন"}, {"t": "Kollegin", "bn": "সহকর্মীকে"}, {"t": "Schokolade.", "bn": "চকলেট"}]),
            ("Das Spielzeug gehört keinem Kind.", "খেলনাটি কোনো শিশুর নয়।", "ডাস শ্পীলৎসয়গ গেহোয়র্ট কাইনেন কিন্ট",
             [{"t": "Das", "bn": "নির্দিষ্ট"}, {"t": "Spielzeug", "bn": "খেলনাটি"}, {"t": "gehört", "bn": "মালিকানাধীন"}, {"t": "keinem", "bn": "কোনো না"}, {"t": "Kind.", "bn": "শিশুর"}]),
            ("Sie spricht mit den Gästen.", "তিনি অতিথিদের সাথে কথা বলছেন।", "যী শ্প্রিখ্ট মিট ডেন গেস্টেন",
             [{"t": "Sie", "bn": "তিনি"}, {"t": "spricht", "bn": "কথা বলছেন"}, {"t": "mit", "bn": "সাথে"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Gästen.", "bn": "অতিথিদের"}]),
        ]
    },
    {
        "title_bn": "ডাটিক ভার্ব (gefallen, gehören, danken, helfen, schmecken)",
        "title_target": "Dativ-Verben im Alltag",
        "intro_bn": "জার্মান ভাষায় কিছু নির্দিষ্ট ক্রিয়াপদের পর সর্বদা ডাটিক অবজেক্ট বসে: gefallen (পছন্দ হওয়া), gehören (অধিকারভুক্ত হওয়া), danken (ধন্যবাদ জানানো), helfen (সাহায্য করা), schmecken (স্বাদ লাগা)।",
        "structure": ["Subjekt", "Dativ-Verb", "Dativobjekt"],
        "items": [
            ("Das Hemd gefällt mir sehr.", "শার্টটি আমার খুব পছন্দ হয়েছে।", "ডাস হেম্ট গেফেল্ট মিয়ার জেয়ার",
             [{"t": "Das", "bn": "নির্দিষ্ট"}, {"t": "Hemd", "bn": "শার্টটি"}, {"t": "gefällt", "bn": "পছন্দ হয়"}, {"t": "mir", "bn": "আমার"}, {"t": "sehr.", "bn": "খুব"}]),
            ("Gehört diese Tasche dir?", "এই ব্যাগটি কি তোমার?", "গেহোয়র্ট ডীজে টাশে ডিয়ার",
             [{"t": "Gehört", "bn": "মালিকানাধীন কি"}, {"t": "diese", "bn": "এই"}, {"t": "Tasche", "bn": "ব্যাগ"}, {"t": "dir?", "bn": "তোমার"}]),
            ("Die Suppe schmeckt den Gästen gut.", "স্যুপটি অতিথিদের খুব সুস্বাদু লাগছে।", "ডি জুপে শমেকট ডেন গেস্টেন গুট",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Suppe", "bn": "স্যুপ"}, {"t": "schmeckt", "bn": "স্বাদ লাগছে"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Gästen", "bn": "অতিথিদের"}, {"t": "gut.", "bn": "ভালো"}]),
            ("Ich danke dir für deine Hilfe.", "তোমার সাহায্যের জন্য তোমাকে ধন্যবাদ জানাই।", "ইখ্ ডাঙ্কে ডিয়ার ফ্যুর ডাইনে হিলফে",
             [{"t": "Ich", "bn": "আমি"}, {"t": "danke", "bn": "ধন্যবাদ জানাই"}, {"t": "dir", "bn": "তোমাকে"}, {"t": "für", "bn": "জন্য"}, {"t": "deine", "bn": "তোমার"}, {"t": "Hilfe.", "bn": "সাহায্য"}]),
            ("Diese Hose passt mir leider nicht.", "এই প্যান্টটি দুর্ভাগ্যবশত আমার মাপমতো হচ্ছে না।", "ডীজে হোজে পাস্ট মিয়ার লাইডার নিখ্ট",
             [{"t": "Diese", "bn": "এই"}, {"t": "Hose", "bn": "প্যান্ট"}, {"t": "passt", "bn": "মাপে হয়"}, {"t": "mir", "bn": "আমার"}, {"t": "leider", "bn": "দুর্ভাগ্যবশত"}, {"t": "nicht.", "bn": "না"}]),
            ("Der Lehrer hilft dem Schüler.", "শিক্ষক ছাত্রটিকে সাহায্য করছেন।", "ডের লেহেরার হেলফ্ট ডেম শ্যুলার",
             [{"t": "Der", "bn": "নির্দিষ্ট"}, {"t": "Lehrer", "bn": "শিক্ষক"}, {"t": "hilft", "bn": "সাহায্য করছেন"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Schüler.", "bn": "ছাত্রটিকে"}]),
            ("Wem gehört dieses Auto?", "এই গাড়িটি কার?", "ভেম গেহোয়র্ট ডীজেস আউটো",
             [{"t": "Wem", "bn": "কার"}, {"t": "gehört", "bn": "মালিকানাধীন"}, {"t": "dieses", "bn": "এই"}, {"t": "Auto?", "bn": "গাড়ি"}]),
            ("Die Farbe gefällt ihr überhaupt nicht.", "রংটি তার একেবারেই পছন্দ হচ্ছে না।", "ডি ফার্বে গেফেল্ট ইয়ার উবারহাউপ্ট নিখ্ট",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Farbe", "bn": "রংটি"}, {"t": "gefällt", "bn": "পছন্দ হয়"}, {"t": "ihr", "bn": "তার"}, {"t": "überhaupt", "bn": "একেবারেই"}, {"t": "nicht.", "bn": "না"}]),
        ]
    },
    {
        "title_bn": "কথোপকথন: দোকানে সাহায্য চাওয়া ও কেনাকাটা",
        "title_target": "Gespräch im Geschäft: Einkaufen und Beraten",
        "intro_bn": "দোকানে কেনাকাটা ও সেলস সহকারীর সাথে পরামর্শে ডাটিক প্রয়োগের স্পোকেন কথোপকথন।",
        "structure": ["Kunde", "Verkäufer", "Dativ-Wendungen"],
        "items": [
            ("Guten Tag, kann ich Ihnen helfen?", "শুভ দিন, আমি কি আপনাকে সাহায্য করতে পারি?", "গুটেন তাক কান ইখ্ ইনেন হেলফেন",
             [{"t": "Guten", "bn": "শুভ"}, {"t": "Tag,", "bn": "দিন"}, {"t": "kann", "bn": "পারি কি"}, {"t": "ich", "bn": "আমি"}, {"t": "Ihnen", "bn": "আপনাকে"}, {"t": "helfen?", "bn": "সাহায্য করতে"}],
             None, "A", "dialogue_line"),
            ("Ja bitte, ich suche eine warme Jacke.", "হ্যাঁ দয়া করে, আমি একটি গরম জ্যাকেট খুঁজছি।", "ইয়া বিটে ইখ্ জুখে আইনে ভার্মে ইয়াকে",
             [{"t": "Ja", "bn": "হ্যাঁ"}, {"t": "bitte,", "bn": "দয়া করে"}, {"t": "ich", "bn": "আমি"}, {"t": "suche", "bn": "খুঁজছি"}, {"t": "eine", "bn": "একটি"}, {"t": "warme", "bn": "গরম"}, {"t": "Jacke.", "bn": "জ্যাকেট"}],
             None, "B", "dialogue_line"),
            ("Wie gefällt Ihnen diese blaue Jacke hier?", "এখানে এই নীল জ্যাকেটটি আপনার কেমন লাগছে?", "ভী গেফেল্ট ইনেন ডীজে ব্লাউয়ে ইয়াকে হিয়ার",
             [{"t": "Wie", "bn": "কেমন"}, {"t": "gefällt", "bn": "পছন্দ হয়"}, {"t": "Ihnen", "bn": "আপনার"}, {"t": "diese", "bn": "এই"}, {"t": "blaue", "bn": "নীল"}, {"t": "Jacke", "bn": "জ্যাকেট"}, {"t": "hier?", "bn": "এখানে"}],
             None, "A", "dialogue_line"),
            ("Die gefällt mir gut, aber sie ist zu groß.", "এটা আমার পছন্দ হয়েছে, তবে এটা অতিরিক্ত বড়।", "ডি গেফেল্ট মিয়ার গুট আবার যী ইস্ত ৎসু গ্রোস",
             [{"t": "Die", "bn": "এটা"}, {"t": "gefällt", "bn": "পছন্দ হয়"}, {"t": "mir", "bn": "আমার"}, {"t": "gut,", "bn": "ভালো"}, {"t": "aber", "bn": "কিন্তু"}, {"t": "sie", "bn": "এটি"}, {"t": "ist", "bn": "হয়"}, {"t": "zu", "bn": "অতিরিক্ত"}, {"t": "groß.", "bn": "বড়"}],
             None, "B", "dialogue_line"),
            ("Ich bringe Ihnen gerne eine kleinere Größe.", "আমি সানন্দে আপনার জন্য আরও একটি ছোট সাইজ আনছি।", "ইখ্ ব্রিঙে ইনেন গের্নে আইনে ক্লাইনেরে গ্রোয়েসে",
             [{"t": "Ich", "bn": "আমি"}, {"t": "bringe", "bn": "আনছি"}, {"t": "Ihnen", "bn": "আপনার জন্য"}, {"t": "gerne", "bn": "সানন্দে"}, {"t": "eine", "bn": "একটি"}, {"t": "kleinere", "bn": "আরও ছোট"}, {"t": "Größe.", "bn": "সাইজ"}],
             None, "A", "dialogue_line"),
            ("Vielen Dank, die passt mir perfekt!", "অনেক ধন্যবাদ, এটা আমার একদম নিখুঁত মাপে হয়েছে!", "ফীলেন ডাঙ্ক ডি পাস্ট মিয়ার পেয়ারফেক্ট",
             [{"t": "Vielen", "bn": "অনেক"}, {"t": "Dank,", "bn": "ধন্যবাদ"}, {"t": "die", "bn": "এটা"}, {"t": "passt", "bn": "মাপে হয়"}, {"t": "mir", "bn": "আমার"}, {"t": "perfekt!", "bn": "নিখুঁত"}],
             None, "B", "dialogue_line"),
            ("Sie steht Ihnen wirklich ausgezeichnet.", "এটি আপনাকে সত্যিই চমৎকার মানিয়েছে।", "যী শ্টেহ্ট ইনেন ভির্ক্লিখ আউসগেৎসায়খনেট",
             [{"t": "Sie", "bn": "এটি"}, {"t": "steht", "bn": "মানিয়েছে"}, {"t": "Ihnen", "bn": "আপনাকে"}, {"t": "wirklich", "bn": "সত্যিই"}, {"t": "ausgezeichnet.", "bn": "চমৎকার"}],
             None, "A", "dialogue_line"),
            ("Super, ich nehme sie sofort.", "দারুণ, আমি এটি এখনই নিচ্ছি।", "সুপার ইখ্ নেমে যী জোফোর্ট",
             [{"t": "Super,", "bn": "দারুণ"}, {"t": "ich", "bn": "আমি"}, {"t": "nehme", "bn": "নিচ্ছি"}, {"t": "sie", "bn": "এটি"}, {"t": "sofort.", "bn": "এখনই"}],
             None, "B", "dialogue_line"),
        ]
    }
]
parts_p1.append(("de-a2-01", "অপ্রত্যক্ষ কর্ম: ডাটিক কেস", "Der Dativ: dem, der, den + Pronomen", p1_lessons))

# =========================================================================
# Unit de-a2-02: উভমুখী অব্যয়: গতি বনাম স্থির অবস্থান (Wechselpräpositionen)
# =========================================================================
p2_lessons = [
    {
        "title_bn": "গতি ও দিক নির্দেশ (Wohin? + Akkusativ: stellen, legen, setzen)",
        "title_target": "Richtung & Bewegung: Wohin? + Akkusativ",
        "intro_bn": "গতি বা স্থান পরিবর্তন বোঝালে উভমুখী অব্যয়গুলোর (an, auf, in, neben, etc.) পর Akkusativ হয়। ক্রিয়াপদ: stellen (খাড়া করে রাখা), legen (শুয়ে/সমতল করে রাখা), setzen (বসানো)।",
        "structure": ["Subjekt", "Verb (Akk)", "Objekt", "Präposition + Akkusativ"],
        "items": [
            ("Ich stelle die Vase auf den Tisch.", "আমি ফুলদানিটি টেবিলের উপর রাখছি।", "ইখ্ শ্টেলে ডি ভাজে আউফ ডেন রটিশ",
             [{"t": "Ich", "bn": "আমি"}, {"t": "stelle", "bn": "রাখছি"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Vase", "bn": "ফুলদানিটি"}, {"t": "auf", "bn": "উপর"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Tisch.", "bn": "টেবিল"}]),
            ("Wohin legst du das Buch?", "তুমি বইটি কোথায় রাখছো?", "ভোহিন লেগ্স্ট দু ডাস বুখ",
             [{"t": "Wohin", "bn": "কোথায়"}, {"t": "legst", "bn": "রাখছো"}, {"t": "du", "bn": "তুমি"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Buch?", "bn": "বই"}]),
            ("Ich lege das Buch auf das Sofa.", "আমি বইটি সোফার উপর রাখছি।", "ইখ্ লেগে ডাস বুখ আউফ ডাস জোফা",
             [{"t": "Ich", "bn": "আমি"}, {"t": "lege", "bn": "রাখছি"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Buch", "bn": "বই"}, {"t": "auf", "bn": "উপর"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Sofa.", "bn": "সোফা"}]),
            ("Er setzt das Kind auf den Stuhl.", "সে শিশুটিকে চেয়ারের উপর বসাচ্ছে।", "এয়ার জেৎস্ট ডাস কিন্ট আউফ ডেন শ্টূল",
             [{"t": "Er", "bn": "সে"}, {"t": "setzt", "bn": "বসাচ্ছে"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Kind", "bn": "শিশুটিকে"}, {"t": "auf", "bn": "উপর"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Stuhl.", "bn": "চেয়ার"}]),
            ("Wir hängen das Bild an die Wand.", "আমরা ছবিটি দেয়ালে ঝোলাচ্ছি।", "ভির হেঙেন ডাস বিল্ট আন ডি ভান্ট",
             [{"t": "Wir", "bn": "আমরা"}, {"t": "hängen", "bn": "ঝোলাচ্ছি"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Bild", "bn": "ছবিটি"}, {"t": "an", "bn": "এ"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Wand.", "bn": "দেয়াল"}]),
            ("Sie stellt die Milch in den Kühlschrank.", "তিনি দুধ ফ্রিজের ভেতর রাখছেন।", "যী শ্টেল্ট ডি মিল্খ ইন ডেন ক্যুলশ প্রাঙ্ক",
             [{"t": "Sie", "bn": "তিনি"}, {"t": "stellt", "bn": "রাখছেন"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Milch", "bn": "দুধ"}, {"t": "in", "bn": "ভেতর"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Kühlschrank.", "bn": "ফ্রিজ"}]),
            ("Ich stecke den Schlüssel in die Tasche.", "আমি চাবিটি ব্যাগে ঢোকাচ্ছি।", "ইখ্ শ্টেকে ডেন শ্ল্যুসেল ইন ডি টাশে",
             [{"t": "Ich", "bn": "আমি"}, {"t": "stecke", "bn": "ঢোকাচ্ছি"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Schlüssel", "bn": "চাবিটি"}, {"t": "in", "bn": "ভেতর"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Tasche.", "bn": "ব্যাগ"}]),
            ("Leg die Decke bitte über das Bett.", "কম্বলটি দয়া করে বিছানার উপর রাখো।", "লেক ডি ডেকে বিটে উবার ডাস বেট",
             [{"t": "Leg", "bn": "রাখো"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Decke", "bn": "কম্বল"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "über", "bn": "উপর"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Bett.", "bn": "বিছানা"}]),
        ]
    },
    {
        "title_bn": "স্থির অবস্থান (Wo? + Dativ: stehen, liegen, sitzen)",
        "title_target": "Ruhe & Position: Wo? + Dativ",
        "intro_bn": "স্থির অবস্থান বা অবস্থান নির্দেশ করতে উভমুখী অব্যয়ের পর সর্বদা Dativ হয়। ক্রিয়াপদ: stehen (দাঁড়িয়ে থাকা), liegen (শোয়ানো অবস্থায় থাকা), sitzen (বসে থাকা)।",
        "structure": ["Subjekt", "Verb (Dativ)", "Präposition + Dativ"],
        "items": [
            ("Die Vase steht auf dem Tisch.", "ফুলদানিটি টেবিলের উপর আছে।", "ডি ভাজে শ্টেহ্ট আউফ ডেম রটিশ",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Vase", "bn": "ফুলদানিটি"}, {"t": "steht", "bn": "দাঁড়িয়ে আছে"}, {"t": "auf", "bn": "উপর"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Tisch.", "bn": "টেবিল"}]),
            ("Wo liegt mein Handy?", "আমার মোবাইল ফোনটি কোথায় পড়ে আছে?", "ভো লীখ্ট মাইন হ্যান্ডি",
             [{"t": "Wo", "bn": "কোথায়"}, {"t": "liegt", "bn": "পড়ে আছে"}, {"t": "mein", "bn": "আমার"}, {"t": "Handy?", "bn": "মোবাইল ফোন"}]),
            ("Dein Handy liegt auf dem Sofa.", "তোমার মোবাইল ফোনটি সোফার উপর আছে।", "ডাইন হ্যান্ডি লীখ্ট আউফ ডেম জোফা",
             [{"t": "Dein", "bn": "তোমার"}, {"t": "Handy", "bn": "মোবাইল ফোন"}, {"t": "liegt", "bn": "পড়ে আছে"}, {"t": "auf", "bn": "উপর"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Sofa.", "bn": "সোফা"}]),
            ("Das Kind sitzt auf dem Stuhl.", "শিশুটিকে চেয়ারের উপর বসে আছে।", "ডাস কিন্ট জিৎস্ট আউফ ডেম শ্টূল",
             [{"t": "Das", "bn": "নির্দিষ্ট"}, {"t": "Kind", "bn": "শিশুটিকে"}, {"t": "sitzt", "bn": "বসে আছে"}, {"t": "auf", "bn": "উপর"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Stuhl.", "bn": "চেয়ার"}]),
            ("Das Bild hängt an der Wand.", "ছবিটি দেয়ালে ঝুলছে।", "ডাস বিল্ট হেংট আন ডের ভান্ট",
             [{"t": "Das", "bn": "নির্দিষ্ট"}, {"t": "Bild", "bn": "ছবিটি"}, {"t": "hängt", "bn": "ঝুলছে"}, {"t": "an", "bn": "এ"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Wand.", "bn": "দেয়াল"}]),
            ("Die Milch steht im Kühlschrank.", "দুধ ফ্রিজে রাখা আছে।", "ডি মিল্খ শ্টেহ্ট ইম ক্যুলশ প্রাঙ্ক",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Milch", "bn": "দুধ"}, {"t": "steht", "bn": "রাখা আছে"}, {"t": "im", "bn": "ভেতরে"}, {"t": "Kühlschrank.", "bn": "ফ্রিজ"}]),
            ("Der Schlüssel steckt in der Tür.", "চাবিটি দরজায় আটকানো আছে।", "ডের শ্ল্যুসেল শ্টেক্ট ইন ডের ত্যুর",
             [{"t": "Der", "bn": "নির্দিষ্ট"}, {"t": "Schlüssel", "bn": "চাবিটি"}, {"t": "steckt", "bn": "আটকানো আছে"}, {"t": "in", "bn": "এ"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Tür.", "bn": "দরজা"}]),
            ("Die Katze schläft unter dem Bett.", "বিড়ালটি খাটের নিচে ঘুমাচ্ছে।", "ডি কাৎসে শ্লেফট উন্টার ডেম বেট",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Katze", "bn": "বিড়ালটি"}, {"t": "schläft", "bn": "ঘুমাচ্ছে"}, {"t": "unter", "bn": "নিচে"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Bett.", "bn": "খাট"}]),
        ]
    },
    {
        "title_bn": "ঘরের আসবাব সাজানো ও সঠিক স্থান নির্ধারণ",
        "title_target": "Möbel und Räume einrichten",
        "intro_bn": "বাসার আসবাবপত্র সাজানো এবং সঠিক অবস্থান ব্যাখ্যা করতে neben (পাশে), zwischen (মাঝে), vor (সামনে), hinter (পেছনে) ইত্যাদি অব্যয়ের ব্যবহার।",
        "structure": ["Nomen (Möbel)", "Präposition", "Ort", "Zustand"],
        "items": [
            ("Der Schreibtisch steht neben dem Fenster.", "পড়ার টেবিলটি জানালার পাশে দাঁড়িয়ে আছে।", "ডের শ্রাইবটিশ শ্টেহ্ট নেবেন ডেম ফেন্সটার",
             [{"t": "Der", "bn": "নির্দিষ্ট"}, {"t": "Schreibtisch", "bn": "পড়ার টেবিল"}, {"t": "steht", "bn": "আছে"}, {"t": "neben", "bn": "পাশে"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Fenster.", "bn": "জানালা"}]),
            ("Ich stelle die Lampe neben das Bett.", "আমি বাতিটি বিছানার পাশে রাখছি।", "ইখ্ শ্টেলে ডি লাম্পে নেবেন ডাস বেট",
             [{"t": "Ich", "bn": "আমি"}, {"t": "stelle", "bn": "রাখছি"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Lampe", "bn": "বাতি"}, {"t": "neben", "bn": "পাশে"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Bett.", "bn": "বিছানা"}]),
            ("Der Teppich liegt vor dem Schrank.", "কার্পেটটি আলমারির সামনে বিছানো আছে।", "ডের টেপিখ লীখ্ট ফোর ডেম শ্রাঙ্ক",
             [{"t": "Der", "bn": "নির্দিষ্ট"}, {"t": "Teppich", "bn": "কার্পেটটি"}, {"t": "liegt", "bn": "বিছানো আছে"}, {"t": "vor", "bn": "সামনে"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Schrank.", "bn": "আলমারি"}]),
            ("Wir stellen den Mülleimer hinter die Tür.", "আমরা ময়লার ঝুড়িটি দরজার পেছনে রাখছি।", "ভির শ্টেলেন ডেন ম্যুলআইমার হিন্টার ডি ত্যুর",
             [{"t": "Wir", "bn": "আমরা"}, {"t": "stellen", "bn": "রাখছি"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Mülleimer", "bn": "ময়লার ঝুড়ি"}, {"t": "hinter", "bn": "পেছনে"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Tür.", "bn": "দরজা"}]),
            ("Das Regal steht zwischen den beiden Fenstern.", "তাকটি দুটি জানালার মাঝে অবস্থিত।", "ডাস রেগাল শ্টেহ্ট ৎস্ভিশেন ডেন বায়ডেন ফেন্সটার্ন",
             [{"t": "Das", "bn": "নির্দিষ্ট"}, {"t": "Regal", "bn": "তাকটি"}, {"t": "steht", "bn": "অবস্থিত"}, {"t": "zwischen", "bn": "মাঝে"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "beiden", "bn": "উভয়"}, {"t": "Fenstern.", "bn": "জানালা"}]),
            ("Häng den Spiegel über das Waschbecken.", "আয়নাটি বেসিনের উপরে ঝোলাও।", "হেং ডেন শ্পীগেল উবার ডাস ভাশবেকেন",
             [{"t": "Häng", "bn": "ঝোলাও"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Spiegel", "bn": "আয়নাটি"}, {"t": "über", "bn": "উপরে"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Waschbecken.", "bn": "বেসিন"}]),
            ("Die Schuhe stehen unter der Bank.", "জুতোজোড়া বেঞ্চের নিচে রাখা আছে।", "ডি শুহে শ্টেহেন উন্টার ডের বাঙ্ক",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Schuhe", "bn": "জুতোজোড়া"}, {"t": "stehen", "bn": "রাখা আছে"}, {"t": "unter", "bn": "নিচে"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Bank.", "bn": "বেঞ্চ"}]),
            ("Wir räumen das Wohnzimmer gemeinsam auf.", "আমরা একসাথে বসার ঘরটি গুছাচ্ছি।", "ভির রয়মেন ডাস ভোনৎসীমার গেমাইনজাম আউফ",
             [{"t": "Wir", "bn": "আমরা"}, {"t": "räumen", "bn": "গুছাচ্ছি"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Wohnzimmer", "bn": "বসার ঘর"}, {"t": "gemeinsam", "bn": "একসাথে"}, {"t": "auf.", "bn": "পরিষ্কার"}]),
        ]
    },
    {
        "title_bn": "কথোপকথন: নতুন বাসায় জিনিসপত্র গোছানো",
        "title_target": "Gespräch: Einzug in die neue Wohnung",
        "intro_bn": "নতুন বাসায় ওঠার পর জিনিসপত্র ও আসবাব গোছানো নিয়ে স্পোকেন কথোপকথন।",
        "structure": ["Frage (Wohin / Wo)", "Antwort (Akk / Dat)", "Ortsangabe"],
        "items": [
            ("Wohin stellen wir dieses schwere Sofa?", "আমরা এই ভারী সোফাটি কোথায় রাখব?", "ভোহিন শ্টেলেন ভির ডীজেস শভেরে জোফা",
             [{"t": "Wohin", "bn": "কোথায়"}, {"t": "stellen", "bn": "রাখব"}, {"t": "wir", "bn": "আমরা"}, {"t": "dieses", "bn": "এই"}, {"t": "schwere", "bn": "ভারী"}, {"t": "Sofa?", "bn": "সোফা"}],
             None, "A", "dialogue_line"),
            ("Stellen wir es bitte an die Wand neben das Fenster.", "চলো এটা জানালার পাশে দেয়াল ঘেঁষে রাখি।", "শ্টেলেন ভির এস বিটে আন ডি ভান্ট নেবেন ডাস ফেন্সটার",
             [{"t": "Stellen", "bn": "রাখি"}, {"t": "wir", "bn": "আমরা"}, {"t": "es", "bn": "এটি"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "an", "bn": "ঘেঁষে"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Wand", "bn": "দেয়াল"}, {"t": "neben", "bn": "পাশে"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Fenster.", "bn": "জানালা"}],
             None, "B", "dialogue_line"),
            ("Und wo soll der Fernseher stehen?", "আর টেলিভিশনটি কোথায় থাকবে?", "উন্ট ভো জল ডের ফেয়ার্নজেহের শ্টেহেন",
             [{"t": "Und", "bn": "আর"}, {"t": "wo", "bn": "কোথায়"}, {"t": "soll", "bn": "উচিত"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Fernseher", "bn": "টেলিভিশন"}, {"t": "stehen?", "bn": "থাকা"}],
             None, "A", "dialogue_line"),
            ("Der Fernseher kommt auf den kleinen Tisch dort.", "টেলিভিশনটি ওখানে ছোট টেবিলের উপর বসবে।", "ডের ফেয়ার্নজেহের কমট আউফ ডেন ক্লাইনেন রটিশ ডোর্ট",
             [{"t": "Der", "bn": "নির্দিষ্ট"}, {"t": "Fernseher", "bn": "টেলিভিশন"}, {"t": "kommt", "bn": "বসবে"}, {"t": "auf", "bn": "উপর"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "kleinen", "bn": "ছোট"}, {"t": "Tisch", "bn": "টেবিল"}, {"t": "dort.", "bn": "ওখানে"}],
             None, "B", "dialogue_line"),
            ("Wohin kommen die vielen Bücher?", "এত বইগুলো কোথায় রাখা হবে?", "ভোহিন কমেন ডি ফীলেন ব্যুখার",
             [{"t": "Wohin", "bn": "কোথায়"}, {"t": "kommen", "bn": "যাবে"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "vielen", "bn": "অনেক"}, {"t": "Bücher?", "bn": "বইগুলো"}],
             None, "A", "dialogue_line"),
            ("Stell die Bücher bitte in das Regal.", "বইগুলো দয়া করে বইয়ের তাকে রাখো।", "শ্টেল ডি ব্যুখার বিটে ইন ডাস রেগাল",
             [{"t": "Stell", "bn": "রাখো"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Bücher", "bn": "বইগুলো"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "in", "bn": "ভেতর"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Regal.", "bn": "তাক"}],
             None, "B", "dialogue_line"),
            ("Liegen die Schlüssel noch in der Kiste?", "চাবিগুলো কি এখনো বাক্সের মধ্যে পড়ে আছে?", "লীখেন ডি শ্ল্যুসেল নখ ইন ডের কিস্টে",
             [{"t": "Liegen", "bn": "পড়ে আছে কি"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Schlüssel", "bn": "চাবিগুলো"}, {"t": "noch", "bn": "এখনো"}, {"t": "in", "bn": "ভেতর"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Kiste?", "bn": "বাক্স"}],
             None, "A", "dialogue_line"),
            ("Nein, sie liegen schon auf dem Küchentisch.", "না, সেগুলো ইতোমধ্যে রান্নাঘরের টেবিলের উপর আছে।", "নাইন যী লীখেন শোন আউফ ডেম ক্যুশেনটিশ",
             [{"t": "Nein,", "bn": "না"}, {"t": "sie", "bn": "সেগুলো"}, {"t": "liegen", "bn": "আছে"}, {"t": "schon", "bn": "ইতোমধ্যে"}, {"t": "auf", "bn": "উপর"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Küchentisch.", "bn": "রান্নাঘরের টেবিল"}],
             None, "B", "dialogue_line"),
        ]
    }
]
parts_p1.append(("de-a2-02", "উভমুখী অব্যয়: গতি বনাম স্থির অবস্থান", "Wechselpräpositionen: Wohin (Akkusativ) vs. Wo (Dativ)", p2_lessons))

# =========================================================================
# Unit de-a2-03: ডাক্তার ও ফার্মেসিতে (Beim Arzt & in der Apotheke)
# =========================================================================
p3_lessons = [
    {
        "title_bn": "শরীরের অঙ্গ ও অসুস্থতার লক্ষণ (Mein Kopf tut weh, ich habe Fieber)",
        "title_target": "Körperteile und Symptome: Wehtun & Fieber",
        "intro_bn": "অসুস্থতা প্রকাশ করতে 'wehtun' (ব্যথা করা) এবং 'haben' (থাকা) ব্যবহৃত হয়: Der Kopf tut weh, ich habe Fieber / Schmerzen.",
        "structure": ["Körperteil", "tut weh", "Symptom"],
        "items": [
            ("Mein Kopf tut sehr weh.", "আমার মাথা খুব ব্যথা করছে।", "মাইন কপফ টুট জেয়ার ভেহ",
             [{"t": "Mein", "bn": "আমার"}, {"t": "Kopf", "bn": "মাথা"}, {"t": "tut", "bn": "করছে"}, {"t": "sehr", "bn": "খুব"}, {"t": "weh.", "bn": "ব্যথা"}]),
            ("Ich habe seit gestern hohes Fieber.", "আমার গতকাল থেকে তীব্র জ্বর হয়েছে।", "ইখ্ হাবে জাইট গেস্টের্ন হোহেস ফীবার",
             [{"t": "Ich", "bn": "আমার"}, {"t": "habe", "bn": "আছে"}, {"t": "seit", "bn": "থেকে"}, {"t": "gestern", "bn": "গতকাল"}, {"t": "hohes", "bn": "উচ্চ"}, {"t": "Fieber.", "bn": "জ্বর"}]),
            ("Ihr Hals tut weh und sie hustet.", "তার গলা ব্যথা করছে এবং সে কাশছে।", "ইয়ার হাল্স টুট ভেহ উন্ট যী হুস্টেট",
             [{"t": "Ihr", "bn": "তার"}, {"t": "Hals", "bn": "গলা"}, {"t": "tut", "bn": "করছে"}, {"t": "weh", "bn": "ব্যথা"}, {"t": "und", "bn": "এবং"}, {"t": "sie", "bn": "সে"}, {"t": "hustet.", "bn": "কাশছে"}]),
            ("Mein Bauch tut nach dem Essen weh.", "খাওয়ার পর আমার পেট ব্যথা করে।", "মাইন বাউখ টুট নাখ ডেম এসেন ভেহ",
             [{"t": "Mein", "bn": "আমার"}, {"t": "Bauch", "bn": "পেট"}, {"t": "tut", "bn": "করে"}, {"t": "nach", "bn": "পর"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Essen", "bn": "খাবার"}, {"t": "weh.", "bn": "ব্যথা"}]),
            ("Er hat starke Rückenschmerzen.", "তার পিঠে প্রচণ্ড ব্যথা রয়েছে।", "এয়ার হাট শ্টার্কে র্যুকেনশমেরৎসেন",
             [{"t": "Er", "bn": "তার"}, {"t": "hat", "bn": "আছে"}, {"t": "starke", "bn": "প্রচণ্ড"}, {"t": "Rückenschmerzen.", "bn": "পিঠে ব্যথা"}]),
            ("Mir ist seit heute Morgen schwindelig.", "আজ সকাল থেকে আমার মাথা ঘুরছে।", "মিয়ার ইস্ত জাইট হয়টে মর্গেন শ্ভিন্ডেলিখ",
             [{"t": "Mir", "bn": "আমার"}, {"t": "ist", "bn": "হয়"}, {"t": "seit", "bn": "থেকে"}, {"t": "heute", "bn": "আজ"}, {"t": "Morgen", "bn": "সকাল"}, {"t": "schwindelig.", "bn": "মাথা ঘোরা"}]),
            ("Ich habe Schnupfen und Halsschmerzen.", "আমার সর্দি এবং গলা ব্যথা আছে।", "ইখ্ হাবে শ্নুপফেন উন্ট হাল্সশমেরৎসেন",
             [{"t": "Ich", "bn": "আমার"}, {"t": "habe", "bn": "আছে"}, {"t": "Schnupfen", "bn": "সর্দি"}, {"t": "und", "bn": "এবং"}, {"t": "Halsschmerzen.", "bn": "গলা ব্যথা"}]),
            ("Mein rechtes Bein tut beim Gehen weh.", "হাঁটার সময় আমার ডান পা ব্যথা করছে।", "মাইন রেশ্টেস বাইন টুট বাইম গেহেন ভেহ",
             [{"t": "Mein", "bn": "আমার"}, {"t": "rechtes", "bn": "ডান"}, {"t": "Bein", "bn": "পা"}, {"t": "tut", "bn": "করছে"}, {"t": "beim", "bn": "সময়"}, {"t": "Gehen", "bn": "হাঁটা"}, {"t": "weh.", "bn": "ব্যথা"}]),
        ]
    },
    {
        "title_bn": "ফার্মেসি ও ওষুধের প্রেসক্রিপশন (Nehmen Sie diese Tabletten)",
        "title_target": "In der Apotheke: Medikamente und Einnahme",
        "intro_bn": "ফার্মেসিতে ওষুধ চাওয়া এবং খাওয়ার নিয়মাবলী বোঝার প্রয়োজনীয় স্পোকেন বাক্য।",
        "structure": ["Medikament", "Dosierung", "Einnahmevorschrift"],
        "items": [
            ("Ich brauche etwas gegen Kopfschmerzen.", "মাথাব্যথার জন্য আমার কিছু ওষুধ দরকার।", "ইখ্ ব্রাউখে এটভাস গেগেন কপফশমেরৎসেন",
             [{"t": "Ich", "bn": "আমার"}, {"t": "brauche", "bn": "দরকার"}, {"t": "etwas", "bn": "কিছু"}, {"t": "gegen", "bn": "বিরুদ্ধে"}, {"t": "Kopfschmerzen.", "bn": "মাথাব্যথা"}]),
            ("Haben Sie ein Rezept vom Arzt?", "ডাক্তারের কোনো প্রেসক্রিপশন কি আপনার কাছে আছে?", "হাবন যী আইন রেৎসেপ্ট ফম আর্টস্ট",
             [{"t": "Haben", "bn": "আছে কি"}, {"t": "Sie", "bn": "আপনার"}, {"t": "ein", "bn": "একটি"}, {"t": "Rezept", "bn": "প্রেসক্রিপশন"}, {"t": "vom", "bn": "থেকে"}, {"t": "Arzt?", "bn": "ডাক্তার"}]),
            ("Nehmen Sie diese Tabletten dreimal täglich.", "এই ট্যাবলেটগুলো দিনে তিনবার সেবন করুন।", "নেমেন যী ডীজে টাবলেতেন ড্রাইমাল টেগ্লিখ",
             [{"t": "Nehmen", "bn": "সেবন করুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "diese", "bn": "এই"}, {"t": "Tabletten", "bn": "ট্যাবলেটগুলো"}, {"t": "dreimal", "bn": "তিনবার"}, {"t": "täglich.", "bn": "প্রতিদিন"}]),
            ("Trinken Sie viel Wasser dazu.", "এর সাথে প্রচুর পানি পান করুন।", "ট্রিঙ্কেন যী ফীল ভাসার ডাৎসু",
             [{"t": "Trinken", "bn": "পান করুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "viel", "bn": "প্রচুর"}, {"t": "Wasser", "bn": "দুধ/পানি"}, {"t": "dazu.", "bn": "এর সাথে"}]),
            ("Diese Tropfen nehmen Sie vor dem Schlafen.", "ঘুমানোর আগে আপনি এই ড্রপগুলো নেবেন।", "ডীজে ট্রপফেন নেমেন যী ফোর ডেম শ্লাফেন",
             [{"t": "Diese", "bn": "এই"}, {"t": "Tropfen", "bn": "ড্রপগুলো"}, {"t": "nehmen", "bn": "নেবেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "vor", "bn": "পূর্বে"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Schlafen.", "bn": "ঘুমানো"}]),
            ("Gibt es Nebenwirkungen bei diesem Medikament?", "এই ওষুধের কি কোনো পার্শ্বপ্রতিক্রিয়া আছে?", "গিব্ট এস নেবেনভির্কুঙেন বাই ডীজেম মেডিকামেন্ট",
             [{"t": "Gibt", "bn": "আছে"}, {"t": "es", "bn": "কি"}, {"t": "Nebenwirkungen", "bn": "পার্শ্বপ্রতিক্রিয়া"}, {"t": "bei", "bn": "ক্ষেত্রে"}, {"t": "diesem", "bn": "এই"}, {"t": "Medikament?", "bn": "ওষুধ"}]),
            ("Dieses Schmerzmittel ist rezeptfrei.", "এই ব্যথানাশকটি প্রেসক্রিপশন ছাড়াই পাওয়া যায়।", "ডীজেস শমের্ৎসমিটেল ইস্ত রেৎসেপ্টফ্রাই",
             [{"t": "Dieses", "bn": "এই"}, {"t": "Schmerzmittel", "bn": "ব্যথানাশক"}, {"t": "ist", "bn": "হয়"}, {"t": "rezeptfrei.", "bn": "প্রেসক্রিপশনমুক্ত"}]),
            ("Gute Besserung und erholen Sie sich gut!", "দ্রুত সুস্থ হয়ে উঠুন এবং ভালো বিশ্রাম নিন!", "গুটে বেসেরুং উন্ট এয়ারহোলেন যী জিখ গুট",
             [{"t": "Gute", "bn": "ভালো"}, {"t": "Besserung", "bn": "সুস্থতা"}, {"t": "und", "bn": "এবং"}, {"t": "erholen", "bn": "বিশ্রাম নিন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "sich", "bn": "নিজেকে"}, {"t": "gut!", "bn": "ভালো"}]),
        ]
    },
    {
        "title_bn": "ডাক্তারের অ্যাপয়েন্টমেন্ট ও অসুস্থতার সনদ (Krankschreibung)",
        "title_target": "Arzttermin und Krankschreibung",
        "intro_bn": "ডাক্তারের অ্যাপয়েন্টমেন্ট (Termin) নির্ধারণ করা, বিমা কার্ড দেখানো এবং অফিস বা বিশ্ববিদ্যালয়ের জন্য অসুস্থতার ছুটির সনদ (AU-Bescheinigung / Krankschreibung) নেওয়া।",
        "structure": ["Terminvereinbarung", "Praxis", "Arbeitsunfähigkeit"],
        "items": [
            ("Ich möchte bitte einen Termin vereinbaren.", "আমি দয়া করে ডাক্তারের একটি অ্যাপয়েন্টমেন্ট নিতে চাই।", "ইখ্ মোয়খটে বিটে আইনেন টের্মিন ফেয়ারআইনবারেন",
             [{"t": "Ich", "bn": "আমি"}, {"t": "möchte", "bn": "চাই"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "einen", "bn": "একটি"}, {"t": "Termin", "bn": "অ্যাপয়েন্টমেন্ট"}, {"t": "vereinbaren.", "bn": "নির্ধারণ করতে"}]),
            ("Haben Sie heute noch einen Termin frei?", "আজকে কি আপনার কোনো অ্যাপয়েন্টমেন্ট খালি আছে?", "হাবন যী হয়টে নখ আইনেন টের্মিন ফ্রাই",
             [{"t": "Haben", "bn": "আছে কি"}, {"t": "Sie", "bn": "আপনার"}, {"t": "heute", "bn": "আজ"}, {"t": "noch", "bn": "আরও"}, {"t": "einen", "bn": "একটি"}, {"t": "Termin", "bn": "অ্যাপয়েন্টমেন্ট"}, {"t": "frei?", "bn": "খালি"}]),
            ("Bringen Sie bitte Ihre Versichertenkarte mit.", "দয়া করে আপনার হেলথ ইন্স্যুরেন্স কার্ড সাথে নিয়ে আসুন।", "ব্রিঙেন যী বিটে ইয়াহরে ফেয়ারজিখের্টেনকার্টে মিট",
             [{"t": "Bringen", "bn": "আনুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "Ihre", "bn": "আপনার"}, {"t": "Versichertenkarte", "bn": "ইন্স্যুরেন্স কার্ড"}, {"t": "mit.", "bn": "সাথে"}]),
            ("Nehmen Sie bitte im Wartezimmer Platz.", "দয়া করে ওয়েটিং রুমে বসুন।", "নেমেন যী বিটে ইম ভার্তেৎসীমার প্লাৎস",
             [{"t": "Nehmen", "bn": "নিন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "im", "bn": "এ"}, {"t": "Wartezimmer", "bn": "ওয়েটিং রুম"}, {"t": "Platz.", "bn": "আসন"}]),
            ("Der Arzt untersucht Sie gleich.", "ডাক্তার এখনই আপনাকে পরীক্ষা করবেন।", "ডের আর্টস্ট উন্টারজুর্খট যী গ্লাইখ",
             [{"t": "Der", "bn": "নির্দিষ্ট"}, {"t": "Arzt", "bn": "ডাক্তার"}, {"t": "untersucht", "bn": "পরীক্ষা করবেন"}, {"t": "Sie", "bn": "আপনাকে"}, {"t": "gleich.", "bn": "এখনই"}]),
            ("Ich brauche eine Krankschreibung für den Arbeitgeber.", "নিয়োগকর্তার জন্য আমার একটি অসুস্থতার সনদ প্রয়োজন।", "ইখ্ ব্রাউখে আইনে প্রাঙ্কশ্রাইবুং ফ্যুর ডেন আরবাইটগেবার",
             [{"t": "Ich", "bn": "আমার"}, {"t": "brauche", "bn": "প্রয়োজন"}, {"t": "eine", "bn": "একটি"}, {"t": "Krankschreibung", "bn": "অসুস্থতার সনদ"}, {"t": "für", "bn": "জন্য"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Arbeitgeber.", "bn": "নিয়োগকর্তা"}]),
            ("Ich schreibe Sie für drei Tage krank.", "আমি আপনাকে তিন দিনের জন্য অসুস্থতার ছুটি লিখে দিচ্ছি।", "ইখ্ শ্রাইবে যী ফ্যুর ড্রাই টাগে ক্রাঙ্ক",
             [{"t": "Ich", "bn": "আমি"}, {"t": "schreibe", "bn": "লিখে দিচ্ছি"}, {"t": "Sie", "bn": "আপনাকে"}, {"t": "für", "bn": "জন্য"}, {"t": "drei", "bn": "তিন"}, {"t": "Tage", "bn": "দিন"}, {"t": "krank.", "bn": "অসুস্থ"}]),
            ("Bleiben Sie im Bett und ruhen Sie sich aus.", "বিছানায় থাকুন এবং পুরোপুরি বিশ্রাম নিন।", "ব্লাইবেন যী ইম বেট উন্ট রুহেন যী জিখ আউস",
             [{"t": "Bleiben", "bn": "থাকুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "im", "bn": "এ"}, {"t": "Bett", "bn": "বিছানা"}, {"t": "und", "bn": "এবং"}, {"t": "ruhen", "bn": "বিশ্রাম নিন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "sich", "bn": "নিজেকে"}, {"t": "aus.", "bn": "পরিপূর্ণ"}]),
        ]
    },
    {
        "title_bn": "কথোপকথন: ডাক্তারের চেম্বারে পরামর্শ",
        "title_target": "Gespräch beim Arzt: Untersuchung und Diagnose",
        "intro_bn": "ডাক্তারের সাথে রোগীর মুখোমুখি শারীরিক সমস্যার আলোচনা ও প্রেসক্রিপশন নেওয়ার কথোপকথন।",
        "structure": ["Arzt", "Patient", "Diagnose & Rezept"],
        "items": [
            ("Guten Tag, was fehlt Ihnen denn?", "শুভ দিন, আপনার কী সমস্যা হয়েছে?", "গুটেন তাক ভাস ফেল্ট ইনেন ডেন",
             [{"t": "Guten", "bn": "শুভ"}, {"t": "Tag,", "bn": "দিন"}, {"t": "was", "bn": "কী"}, {"t": "fehlt", "bn": "সমস্যা"}, {"t": "Ihnen", "bn": "আপনার"}, {"t": "denn?", "bn": "আসলে"}],
             None, "A", "dialogue_line"),
            ("Ich habe seit drei Tagen starke Halsschmerzen und Fieber.", "আমার তিন দিন ধরে প্রচণ্ড গলা ব্যথা এবং জ্বর।", "ইখ্ হাবে জাইট ড্রাই টাগেন শ্টার্কে হাল্সশমেরৎসেন উন্ট ফীবার",
             [{"t": "Ich", "bn": "আমার"}, {"t": "habe", "bn": "আছে"}, {"t": "seit", "bn": "ধরে"}, {"t": "drei", "bn": "তিন"}, {"t": "Tagen", "bn": "দিন"}, {"t": "starke", "bn": "তীব্র"}, {"t": "Halsschmerzen", "bn": "গলা ব্যথা"}, {"t": "und", "bn": "এবং"}, {"t": "Fieber.", "bn": "জ্বর"}],
             None, "B", "dialogue_line"),
            ("Machen Sie bitte den Mund auf und sagen Sie Ah.", "দয়া করে মুখটি খুলুন এবং বলুন আ।", "মাখেন যী বিটে ডেন মুন্ট আউফ উন্ট জাগেন যী আ",
             [{"t": "Machen", "bn": "করুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Mund", "bn": "মুখ"}, {"t": "auf", "bn": "খোলা"}, {"t": "und", "bn": "এবং"}, {"t": "sagen", "bn": "বলুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "Ah.", "bn": "আ"}],
             None, "A", "dialogue_line"),
            ("Tut es weh, wenn Sie hier drücken?", "এখানে চাপ দিলে কি ব্যথা লাগছে?", "টুট এস ভেহ ভেন যী হিয়ার ড্র্যুকেন",
             [{"t": "Tut", "bn": "করছে"}, {"t": "es", "bn": "এটি"}, {"t": "weh,", "bn": "ব্যথা"}, {"t": "wenn", "bn": "যদি"}, {"t": "Sie", "bn": "আপনি"}, {"t": "hier", "bn": "এখানে"}, {"t": "drücken?", "bn": "চাপ দেন"}],
             None, "B", "dialogue_line"),
            ("Ihr Hals ist rot, Sie haben eine Entzündung.", "আপনার গলা লাল হয়ে আছে, আপনার ইনফেকশন হয়েছে।", "ইয়ার হাল্স ইস্ত রোট যী হাবন আইনে এন্টৎসিন্দুং",
             [{"t": "Ihr", "bn": "আপনার"}, {"t": "Hals", "bn": "গলা"}, {"t": "ist", "bn": "হয়"}, {"t": "rot,", "bn": "লাল"}, {"t": "Sie", "bn": "আপনার"}, {"t": "haben", "bn": "আছে"}, {"t": "eine", "bn": "একটি"}, {"t": "Entzündung.", "bn": "ইনফেকশন"}],
             None, "A", "dialogue_line"),
            ("Muss ich Antibiotika einnehmen?", "আমাকে কি অ্যান্টিবায়োটিক খেতে হবে?", "মুস ইখ্ অ্যান্টিবায়োটিকা আইননেমেন",
             [{"t": "Muss", "bn": "হবে কি"}, {"t": "ich", "bn": "আমার"}, {"t": "Antibiotika", "bn": "অ্যান্টিবায়োটিক"}, {"t": "einnehmen?", "bn": "সেবন করতে"}],
             None, "B", "dialogue_line"),
            ("Nein, trinken Sie viel Tee und nehmen Sie diese Tabletten.", "না, প্রচুর চা পান করুন এবং এই ট্যাবলেটগুলো খান।", "নাইন ট্রিঙ্কেন যী ফীল টে উন্ট নেমেন যী ডীজে টাবলেতেন",
             [{"t": "Nein,", "bn": "না"}, {"t": "trinken", "bn": "পান করুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "viel", "bn": "প্রচুর"}, {"t": "Tee", "bn": "চা"}, {"t": "und", "bn": "এবং"}, {"t": "nehmen", "bn": "খান"}, {"t": "Sie", "bn": "আপনি"}, {"t": "diese", "bn": "এই"}, {"t": "Tabletten.", "bn": "ট্যাবলেটগুলো"}],
             None, "A", "dialogue_line"),
            ("Vielen Dank, Herr Doktor, ich werde mich ausruhen.", "অনেক ধন্যবাদ ডাক্তারবাবু, আমি বিশ্রাম নেব।", "ফীলেন ডাঙ্ক হেয়ার ডক্টর ইখ্ ভের্ডে নিখ্ আউসরুহেন",
             [{"t": "Vielen", "bn": "অনেক"}, {"t": "Dank,", "bn": "ধন্যবাদ"}, {"t": "Herr", "bn": "মিস্টার"}, {"t": "Doktor,", "bn": "ডাক্তার"}, {"t": "ich", "bn": "আমি"}, {"t": "werde", "bn": "নেব"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "ausruhen.", "bn": "বিশ্রাম"}],
             None, "B", "dialogue_line"),
        ]
    }
]
parts_p1.append(("de-a2-03", "ডাক্তার ও ফার্মেসিতে", "Beim Arzt & in der Apotheke", p3_lessons))

# =========================================================================
# Unit de-a2-04: মোডাল ভার্ব: অনুমতি, পরামর্শ ও ইচ্ছা (Modalverben)
# =========================================================================
p4_lessons = [
    {
        "title_bn": "নিয়ম ও অনুমতি (Hier darf man nicht rauchen)",
        "title_target": "Regeln und Verbote: dürfen und man darf nicht",
        "intro_bn": "dürfen (অনুমতি থাকা) এবং nicht dürfen (নিষেধাজ্ঞা): সরকারি স্থান, হাসপাতাল ও রাস্তায় বিভিন্ন নিয়মাবলী প্রকাশের গঠন।",
        "structure": ["Position 1", "darf / dürfen", "man / Subjekt", "Infinitiv am Ende"],
        "items": [
            ("Hier darf man nicht rauchen.", "এখানে ধূমপান করার অনুমতি নেই।", "হিয়ার ডার্ফ মান নিখ্ট রাউখেন",
             [{"t": "Hier", "bn": "এখানে"}, {"t": "darf", "bn": "অনুমতি"}, {"t": "man", "bn": "কারো"}, {"t": "nicht", "bn": "নেই"}, {"t": "rauchen.", "bn": "ধূমপান করার"}]),
            ("Darf ich hier mein Auto parken?", "আমি কি এখানে আমার গাড়ি পার্ক করতে পারি?", "ডার্ফ ইখ্ হিয়ার মাইন আউটো পার্কেন",
             [{"t": "Darf", "bn": "পারি কি"}, {"t": "ich", "bn": "আমি"}, {"t": "hier", "bn": "এখানে"}, {"t": "mein", "bn": "আমার"}, {"t": "Auto", "bn": "গাড়ি"}, {"t": "parken?", "bn": "পার্ক করতে"}]),
            ("Im Museum darf man keine Fotos machen.", "জাদুঘরে ছবি তোলার অনুমতি নেই।", "ইম মুজেউম ডার্ফ মান কাইনে ফোটোস মাখেন",
             [{"t": "Im", "bn": "মধ্যে"}, {"t": "Museum", "bn": "জাদুঘর"}, {"t": "darf", "bn": "অনুমতি"}, {"t": "man", "bn": "কারো"}, {"t": "keine", "bn": "কোনো না"}, {"t": "Fotos", "bn": "ছবি"}, {"t": "machen.", "bn": "তোলার"}]),
            ("Dürfen die Kinder heute länger draußen spielen?", "শিশুরা কি আজ বাইরে বেশি সময় খেলতে পারবে?", "ড্যুরফেন ডি কিন্ডার হয়টে লেঙার ড্রাউসেন শ্পীলেন",
             [{"t": "Dürfen", "bn": "পারবে কি"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Kinder", "bn": "শিশুরা"}, {"t": "heute", "bn": "আজ"}, {"t": "länger", "bn": "বেশি সময়"}, {"t": "draußen", "bn": "বাইরে"}, {"t": "spielen?", "bn": "খেলতে"}]),
            ("Man darf bei Rot nicht über die Straße gehen.", "লাল বাতি জ্বলা অবস্থায় রাস্তা পার হওয়া নিষেধ।", "মান ডার্ফ বাই রোট নিখ্ট উবার ডি শ্ট্রাসে গেহেন",
             [{"t": "Man", "bn": "কারো"}, {"t": "darf", "bn": "অনুমতি"}, {"t": "bei", "bn": "ক্ষেত্রে"}, {"t": "Rot", "bn": "লাল বাতি"}, {"t": "nicht", "bn": "নেই"}, {"t": "über", "bn": "পার হয়ে"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Straße", "bn": "রাস্তা"}, {"t": "gehen.", "bn": "যাওয়ার"}]),
            ("Darf ich Sie kurz etwas fragen?", "আমি কি আপনাকে সংক্ষেপে কিছু জিজ্ঞেস করতে পারি?", "ডার্ফ ইখ্ যী কুর্ৎস এটভাস ফ্রাগেন",
             [{"t": "Darf", "bn": "পারি কি"}, {"t": "ich", "bn": "আমি"}, {"t": "Sie", "bn": "আপনাকে"}, {"t": "kurz", "bn": "সংক্ষেপে"}, {"t": "etwas", "bn": "কিছু"}, {"t": "fragen?", "bn": "জিজ্ঞেস করতে"}]),
            ("Hier darf man nur mit Erlaubnis eintreten.", "এখানে কেবল অনুমতি নিয়েই প্রবেশ করা যাবে।", "হিয়ার ডার্ফ মান নুর মিট এয়ারলাউবনিস আইনট্রেটেন",
             [{"t": "Hier", "bn": "এখানে"}, {"t": "darf", "bn": "অনুমতি"}, {"t": "man", "bn": "কারো"}, {"t": "nur", "bn": "কেবল"}, {"t": "mit", "bn": "নিয়ে"}, {"t": "Erlaubnis", "bn": "অনুমতি"}, {"t": "eintreten.", "bn": "প্রবেশ করা"}]),
            ("Sie dürfen nach der Kontrolle weitergehen.", "চেকিংয়ের পর আপনি সামনে এগিয়ে যেতে পারেন।", "যী ড্যুরফেন নাখ ডের কন্ট্রোলে ভাইটারগেহেন",
             [{"t": "Sie", "bn": "আপনি"}, {"t": "dürfen", "bn": "পারেন"}, {"t": "nach", "bn": "পর"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Kontrolle", "bn": "চেকিং"}, {"t": "weitergehen.", "bn": "এগিয়ে যেতে"}]),
        ]
    },
    {
        "title_bn": "পরামর্শ ও ডাক্তারের নির্দেশ (Der Arzt sagt, ich soll mich ausruhen)",
        "title_target": "Ratschläge und Anweisungen: sollen",
        "intro_bn": "sollen (উচিত / করার নির্দেশ থাকা): অন্যের আদেশ বা ডাক্তারের পরামর্শ অন্যের কাছে তুলে ধরতে sollen ব্যবহৃত হয়।",
        "structure": ["Subjekt", "soll / sollen", "Mittelfeld", "Infinitiv am Ende"],
        "items": [
            ("Der Arzt sagt, ich soll viel Wasser trinken.", "ডাক্তার বলেছেন আমার প্রচুর পানি পান করা উচিত।", "ডের আর্টস্ট জাগ্ট ইখ্ জল ফীল ভাসার ট্রিঙ্কেন",
             [{"t": "Der", "bn": "নির্দিষ্ট"}, {"t": "Arzt", "bn": "ডাক্তার"}, {"t": "sagt,", "bn": "বলেছেন"}, {"t": "ich", "bn": "আমার"}, {"t": "soll", "bn": "উচিত"}, {"t": "viel", "bn": "প্রচুর"}, {"t": "Wasser", "bn": "পানি"}, {"t": "trinken.", "bn": "পান করা"}]),
            ("Was soll ich jetzt tun?", "আমার এখন কী করা উচিত?", "ভাস জল ইখ্ ইয়েৎস্ট টুন",
             [{"t": "Was", "bn": "কী"}, {"t": "soll", "bn": "উচিত"}, {"t": "ich", "bn": "আমার"}, {"t": "jetzt", "bn": "এখন"}, {"t": "tun?", "bn": "করা"}]),
            ("Du sollst die Medikamente regelmäßig einnehmen.", "তোমার ওষুধগুলো নিয়মিত সেবন করা উচিত।", "দু জল্স্ট ডি মেডিকামেন্টে রেগেলমেসিখ আইননেমেন",
             [{"t": "Du", "bn": "তোমার"}, {"t": "sollst", "bn": "উচিত"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Medikamente", "bn": "ওষুধগুলো"}, {"t": "regelmäßig", "bn": "নিয়মিত"}, {"t": "einnehmen.", "bn": "সেবন করা"}]),
            ("Wir sollen pünktlich im Büro sein.", "আমাদের সময়মতো অফিসে উপস্থিত থাকা উচিত।", "ভির জলন প্যুঙ্কট্লিখ ইম ব্যুরোザইন",
             [{"t": "Wir", "bn": "আমাদের"}, {"t": "sollen", "bn": "উচিত"}, {"t": "pünktlich", "bn": "সময়মতো"}, {"t": "im", "bn": "এ"}, {"t": "Büro", "bn": "অফিস"}, {"t": "sein.", "bn": "থাকা"}]),
            ("Soll ich das Fenster aufmachen?", "আমি কি জানালাটি খুলে দেব?", "জল ইখ্ ডাস ফেন্সটার আউফমাখেন",
             [{"t": "Soll", "bn": "উচিত কি"}, {"t": "ich", "bn": "আমার"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Fenster", "bn": "জানালা"}, {"t": "aufmachen?", "bn": "খুলে দেওয়া"}]),
            ("Er soll sich ein paar Tage ausruhen.", "তার কয়েক দিন বিশ্রাম নেওয়া উচিত।", "এয়ার জল জিখ আইন পার টাগে আউসরুহেন",
             [{"t": "Er", "bn": "তার"}, {"t": "soll", "bn": "উচিত"}, {"t": "sich", "bn": "নিজেকে"}, {"t": "ein", "bn": "একটি"}, {"t": "paar", "bn": "কয়েক"}, {"t": "Tage", "bn": "দিন"}, {"t": "ausruhen.", "bn": "বিশ্রাম নেওয়া"}]),
            ("Sie sollen mit dem Chef sprechen.", "আপনার বসের সাথে কথা বলা উচিত।", "যী জলন মিট ডেম শেফ শ্প্রেশেন",
             [{"t": "Sie", "bn": "আপনার"}, {"t": "sollen", "bn": "উচিত"}, {"t": "mit", "bn": "সাথে"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Chef", "bn": "বস"}, {"t": "sprechen.", "bn": "কথা বলা"}]),
            ("Kinder sollen nicht so spät ins Bett gehen.", "বাচ্চাদের এত দেরিতে ঘুমাতে যাওয়া উচিত নয়।", "কিন্ডার জলন নিখ্ট জো শ্পেট ইনস বেট গেহেন",
             [{"t": "Kinder", "bn": "বাচ্চাদের"}, {"t": "sollen", "bn": "উচিত"}, {"t": "nicht", "bn": "নয়"}, {"t": "so", "bn": "এত"}, {"t": "spät", "bn": "দেরিতে"}, {"t": "ins", "bn": "এ"}, {"t": "Bett", "bn": "বিছানা"}, {"t": "gehen.", "bn": "যাওয়া"}]),
        ]
    },
    {
        "title_bn": "ভদ্রভাবে ইচ্ছা ও অনুরোধ প্রকাশ (Ich möchte bitte einen Termin)",
        "title_target": "Höfliche Bitten und Wünsche: möchten",
        "intro_bn": "রেস্তোরাঁ, দোকান বা অফিশিয়াল কাজে কোনো কিছু ভদ্রভাবে চাওয়া বা অনুরোধ করতে möchten ব্যবহার করা হয়।",
        "structure": ["Subjekt", "möchte / möchten", "Wunsch / Bitte", "Infinitiv"],
        "items": [
            ("Ich möchte bitte einen Kaffee trinken.", "আমি দয়া করে এক কাপ কফি পান করতে চাই।", "ইখ্ মোয়খটে বিটে আইনেন কাফে ট্রিঙ্কেন",
             [{"t": "Ich", "bn": "আমি"}, {"t": "möchte", "bn": "চাই"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "einen", "bn": "একটি"}, {"t": "Kaffee", "bn": "কফি"}, {"t": "trinken.", "bn": "পান করতে"}]),
            ("Was möchten Sie gerne bestellen?", "আপনি কী অর্ডার করতে চান?", "ভাস মোয়খটেন যী গের্নে বেশ্টেলেন",
             [{"t": "Was", "bn": "কী"}, {"t": "möchten", "bn": "চান"}, {"t": "Sie", "bn": "আপনি"}, {"t": "gerne", "bn": "সানন্দে"}, {"t": "bestellen?", "bn": "অর্ডার করতে"}]),
            ("Wir möchten diesen Monat nach Köln reisen.", "আমরা এই মাসে কোলন ভ্রমণ করতে চাই।", "ভির মোয়খটেন ডীজেন মোনাট নাখ কোলন রাইজেন",
             [{"t": "Wir", "bn": "আমরা"}, {"t": "möchten", "bn": "চাই"}, {"t": "diesen", "bn": "এই"}, {"t": "Monat", "bn": "মাস"}, {"t": "nach", "bn": "এ"}, {"t": "Köln", "bn": "কোলন"}, {"t": "reisen.", "bn": "ভ্রমণ করতে"}]),
            ("Möchtest du mit mir ins Kino kommen?", "তুমি কি আমার সাথে সিনেমা দেখতে আসতে চাও?", "মোয়খটেস্ট দু মিট মিয়ার ইনস কিনো কমেন",
             [{"t": "Möchtest", "bn": "চাও কি"}, {"t": "du", "bn": "তুমি"}, {"t": "mit", "bn": "সাথে"}, {"t": "mir", "bn": "আমার"}, {"t": "ins", "bn": "এ"}, {"t": "Kino", "bn": "সিনেমা"}, {"t": "kommen?", "bn": "আসতে"}]),
            ("Ich möchte bitte die Rechnung haben.", "আমি দয়া করে বিলটি পেতে চাই।", "ইখ্ মোয়খটে বিটে ডি রেশনুং হাবন",
             [{"t": "Ich", "bn": "আমি"}, {"t": "möchte", "bn": "চাই"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Rechnung", "bn": "বিল"}, {"t": "haben.", "bn": "পেতে"}]),
            ("Er möchte eine neue Wohnung mieten.", "সে একটি নতুন ফ্ল্যাট ভাড়া নিতে চায়।", "এয়ার মোয়খটে আইনে নয়ে ভোনুং মীটেন",
             [{"t": "Er", "bn": "সে"}, {"t": "möchte", "bn": "চায়"}, {"t": "eine", "bn": "একটি"}, {"t": "neue", "bn": "নতুন"}, {"t": "Wohnung", "bn": "ফ্ল্যাট"}, {"t": "mieten.", "bn": "ভাড়া নিতে"}]),
            ("Möchten Sie lieber Tee oder Kaffee?", "আপনি কি চা পছন্দ করবেন নাকি কফি?", "মোয়খটেন যী লীবার টে ওডার কাফে",
             [{"t": "Möchten", "bn": "চান কি"}, {"t": "Sie", "bn": "আপনি"}, {"t": "lieber", "bn": "অধিকতর পছন্দ"}, {"t": "Tee", "bn": "চা"}, {"t": "oder", "bn": "নাকি"}, {"t": "Kaffee?", "bn": "কফি"}]),
            ("Ich möchte mich für den Deutschkurs anmelden.", "আমি জার্মান ভাষা কোর্সের জন্য রেজিস্ট্রেশন করতে চাই।", "ইখ্ মোয়খটে নিখ্ ফ্যুর ডেন ডয়চকুরস আনমেলডেন",
             [{"t": "Ich", "bn": "আমি"}, {"t": "möchte", "bn": "চাই"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "für", "bn": "জন্য"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Deutschkurs", "bn": "জার্মান কোর্স"}, {"t": "anmelden.", "bn": "নিবন্ধন করতে"}]),
        ]
    },
    {
        "title_bn": "কথোপকথন: ক্লিনিক ও হাসপাতালে ভিজিটের নিয়মাবলী",
        "title_target": "Gespräch: Besuchsregeln in der Klinik",
        "intro_bn": "হাসপাতালে রোগী দেখতে যাওয়া ও নিয়মাবলী নিয়ে অভ্যর্থনা ডেস্কের সাথে স্পোকেন কথোপকথন।",
        "structure": ["Besucher", "Empfang", "Modalverben"],
        "items": [
            ("Guten Tag, darf ich bitte meinen Freund besuchen?", "শুভ দিন, আমি কি দয়া করে আমার বন্ধুর সাথে দেখা করতে পারি?", "গুটেন তাক ডার্ফ ইখ্ বিটে মাইনেন ফ্রয়ন্ট বেজুখেন",
             [{"t": "Guten", "bn": "শুভ"}, {"t": "Tag,", "bn": "দিন"}, {"t": "darf", "bn": "পারি কি"}, {"t": "ich", "bn": "আমি"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "meinen", "bn": "আমার"}, {"t": "Freund", "bn": "বন্ধু"}, {"t": "besuchen?", "bn": "দেখা করতে"}],
             None, "A", "dialogue_line"),
            ("Ja, aber die Besuchszeit endet um achtzehn Uhr.", "হ্যাঁ, তবে পরিদর্শনের সময় সন্ধ্যা ছয়টায় শেষ হয়।", "ইয়া আবার ডি বেজুখসৎসাইট এনডেট উম আখটৎসেন উর",
             [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "aber", "bn": "কিন্তু"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Besuchszeit", "bn": "পরিদর্শনের সময়"}, {"t": "endet", "bn": "শেষ হয়"}, {"t": "um", "bn": "টায়"}, {"t": "achtzehn", "bn": "আঠারো"}, {"t": "Uhr.", "bn": "ঘড়ি"}],
             None, "B", "dialogue_line"),
            ("Darf ich ihm diese Blumen mitbringen?", "আমি কি তার জন্য এই ফুলগুলো নিয়ে যেতে পারি?", "ডার্ফ ইখ্ ইম ডীজে ব্লুমেন মিটব্রিঙেন",
             [{"t": "Darf", "bn": "পারি কি"}, {"t": "ich", "bn": "আমি"}, {"t": "ihm", "bn": "তার জন্য"}, {"t": "diese", "bn": "এই"}, {"t": "Blumen", "bn": "ফুলগুলো"}, {"t": "mitbringen?", "bn": "নিয়ে আসতে"}],
             None, "A", "dialogue_line"),
            ("Blumen sind erlaubt, aber Sie dürfen keine Topfpflanzen mitnehmen.", "ফুল অনুমোদিত, কিন্তু টবের গাছ নেওয়া নিষেধ।", "ব্লুমেন জিন্ট এয়ারলাউবট আবার যী ড্যুরফেন কাইনে টপফপফ্লানৎসেন মিটনেমেন",
             [{"t": "Blumen", "bn": "ফুলগুলো"}, {"t": "sind", "bn": "হয়"}, {"t": "erlaubt,", "bn": "অনুমোদিত"}, {"t": "aber", "bn": "কিন্তু"}, {"t": "Sie", "bn": "আপনি"}, {"t": "dürfen", "bn": "অনুমতি"}, {"t": "keine", "bn": "কোনো না"}, {"t": "Topfpflanzen", "bn": "টবের গাছ"}, {"t": "mitnehmen.", "bn": "নিয়ে যাওয়ার"}],
             None, "B", "dialogue_line"),
            ("Verstehe, und auf welcher Station liegt er?", "বুঝতে পেরেছি, আর তিনি কোন ওয়ার্ডে আছেন?", "ফেয়ার্শ্টেহে উন্ট আউফ ভেলশের শ্টাৎসিয়ন লীখ্ট এয়ার",
             [{"t": "Verstehe,", "bn": "বুঝতে পেরেছি"}, {"t": "und", "bn": "আর"}, {"t": "auf", "bn": "এ"}, {"t": "welcher", "bn": "কোন"}, {"t": "Station", "bn": "ওয়ার্ড"}, {"t": "liegt", "bn": "আছেন"}, {"t": "er?", "bn": "তিনি"}],
             None, "A", "dialogue_line"),
            ("Er liegt im zweiten Stock auf Station B.", "তিনি তিন তলায় বি ওয়ার্ডে আছেন।", "এয়ার লীখ্ট ইম ৎস্ভাইটেন শ্টক আউফ শ্টাৎসিয়ন বে",
             [{"t": "Er", "bn": "তিনি"}, {"t": "liegt", "bn": "আছেন"}, {"t": "im", "bn": "এ"}, {"t": "zweiten", "bn": "দ্বিতীয়"}, {"t": "Stock", "bn": "তলা"}, {"t": "auf", "bn": "এ"}, {"t": "Station", "bn": "ওয়ার্ড"}, {"t": "B.", "bn": "বি"}],
             None, "B", "dialogue_line"),
            ("Soll ich vorher meine Hände desinfizieren?", "আমার কি আগে হাত জীবাণুমুক্ত করা উচিত?", "জল ইখ্ ফোরহের মাইনে হেন্দে ডেজিনফিৎসীরেন",
             [{"t": "Soll", "bn": "উচিত কি"}, {"t": "ich", "bn": "আমার"}, {"t": "vorher", "bn": "পূর্বে"}, {"t": "meine", "bn": "আমার"}, {"t": "Hände", "bn": "হাত"}, {"t": "desinfizieren?", "bn": "জীবাণুমুক্ত করা"}],
             None, "A", "dialogue_line"),
            ("Ja bitte, das müssen alle Besucher tun.", "হ্যাঁ দয়া করে, এটা সব দর্শনার্থীদের করতেই হবে।", "ইয়া বিটে ডাস ম্যূসেন আলে বেজুখার টুন",
             [{"t": "Ja", "bn": "হ্যাঁ"}, {"t": "bitte,", "bn": "দয়া করে"}, {"t": "das", "bn": "এটা"}, {"t": "müssen", "bn": "হবে"}, {"t": "alle", "bn": "সব"}, {"t": "Besucher", "bn": "দর্শনার্থী"}, {"t": "tun.", "bn": "করা"}],
             None, "B", "dialogue_line"),
        ]
    }
]
parts_p1.append(("de-a2-04", "মোডাল ভার্ব: অনুমতি, পরামর্শ ও ইচ্ছা", "Modalverben: dürfen, sollen, möchten", p4_lessons))

# =========================================================================
# Unit de-a2-05: আশ্রিত খণ্ডবাক্য: কারণ ও শর্ত (Nebensätze: weil, dass, wenn)
# =========================================================================
p5_lessons = [
    {
        "title_bn": "কারণ ব্যাখ্যা: weil (Ich lerne Deutsch, weil...)",
        "title_target": "Kausalsätze mit weil: Verb am Ende",
        "intro_bn": "weil (কারণ) দ্বারা যুক্ত আশ্রিত বাক্যে প্রধান ক্রিয়াপদটি বাক্যের একেবারে শেষে (Verb am Ende) চলে যায়।",
        "structure": ["Hauptsatz,", "weil + Subjekt", "Mittelfeld", "konjugiertes Verb"],
        "items": [
            ("Ich lerne Deutsch, weil ich in Deutschland studieren möchte.", "আমি জার্মান শিখছি, কারণ আমি জার্মানিতে পড়াশোনা করতে চাই।", "ইখ্ লের্নে ডয়চ ভাইল ইখ্ ইন ডয়চলান্ট শ্টুডীরেন মোয়খটে",
             [{"t": "Ich", "bn": "আমি"}, {"t": "lerne", "bn": "শিখছি"}, {"t": "Deutsch,", "bn": "জার্মান"}, {"t": "weil", "bn": "কারণ"}, {"t": "ich", "bn": "আমি"}, {"t": "in", "bn": "এ"}, {"t": "Deutschland", "bn": "জার্মানি"}, {"t": "studieren", "bn": "পড়াশোনা করতে"}, {"t": "möchte.", "bn": "চাই"}]),
            ("Er kommt heute nicht, weil er krank ist.", "সে আজ আসছে না, কারণ সে অসুস্থ।", "এয়ার কমট হয়টে নিখ্ট ভাইল এয়ার ক্রাঙ্ক ইস্ত",
             [{"t": "Er", "bn": "সে"}, {"t": "kommt", "bn": "আসছে"}, {"t": "heute", "bn": "আজ"}, {"t": "nicht,", "bn": "না"}, {"t": "weil", "bn": "কারণ"}, {"t": "er", "bn": "সে"}, {"t": "krank", "bn": "অসুস্থ"}, {"t": "ist.", "bn": "হয়"}]),
            ("Wir beeilen uns, weil der Zug bald abfährt.", "আমরা তাড়াহুড়ো করছি, কারণ ট্রেনটি শীঘ্রই ছেড়ে যাবে।", "ভির বেআইলেন উন্স ভাইল ডের ৎসুক বাল্ট আবফেয়ার্ট",
             [{"t": "Wir", "bn": "আমরা"}, {"t": "beeilen", "bn": "তাড়াহুড়ো করছি"}, {"t": "uns,", "bn": "নিজেদের"}, {"t": "weil", "bn": "কারণ"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Zug", "bn": "ট্রেন"}, {"t": "bald", "bn": "শীঘ্রই"}, {"t": "abfährt.", "bn": "ছেড়ে যাবে"}]),
            ("Sie bleibt zu Hause, weil es draußen stark regnet.", "সে বাড়িতে থাকছে, কারণ বাইরে প্রচণ্ড বৃষ্টি হচ্ছে।", "যী ব্লাইবট ৎসু হাউজে ভাইল এস ড্রাউসেন শ্টার্ক রেগনেট",
             [{"t": "Sie", "bn": "সে"}, {"t": "bleibt", "bn": "থাকছে"}, {"t": "zu", "bn": "এ"}, {"t": "Hause,", "bn": "বাড়ি"}, {"t": "weil", "bn": "কারণ"}, {"t": "es", "bn": "এটি"}, {"t": "draußen", "bn": "বাইরে"}, {"t": "stark", "bn": "তীব্র"}, {"t": "regnet.", "bn": "বৃষ্টি হয়"}]),
            ("Ich trinke Kaffee, weil ich sehr müde bin.", "আমি কফি খাচ্ছি, কারণ আমি খুব ক্লান্ত।", "ইখ্ ট্রিঙ্কে কাফে ভাইল ইখ্ জেয়ার ম্যুডে বিন",
             [{"t": "Ich", "bn": "আমি"}, {"t": "trinke", "bn": "খাচ্ছি"}, {"t": "Kaffee,", "bn": "কফি"}, {"t": "weil", "bn": "কারণ"}, {"t": "ich", "bn": "আমি"}, {"t": "sehr", "bn": "খুব"}, {"t": "müde", "bn": "ক্লান্ত"}, {"t": "bin.", "bn": "হই"}]),
            ("Er spart Geld, weil er ein Auto kaufen will.", "সে টাকা জমাচ্ছে, কারণ সে একটি গাড়ি কিনতে চায়।", "এয়ার শ্পার্ট গেল্ট ভাইল এয়ার আইন আউটো কাউফেন ভিল",
             [{"t": "Er", "bn": "সে"}, {"t": "spart", "bn": "জমাচ্ছে"}, {"t": "Geld,", "bn": "টাকা"}, {"t": "weil", "bn": "কারণ"}, {"t": "er", "bn": "সে"}, {"t": "ein", "bn": "একটি"}, {"t": "Auto", "bn": "গাড়ি"}, {"t": "kaufen", "bn": "কিনতে"}, {"t": "will.", "bn": "চায়"}]),
            ("Wir freuen uns, weil wir die Prüfung bestanden haben.", "আমরা আনন্দিত, কারণ আমরা পরীক্ষায় উত্তীর্ণ হয়েছি।", "ভির ফ্রয়েন উন্স ভাইল ভির ডি প্যুরফুং বেশ্টানডেন হাবন",
             [{"t": "Wir", "bn": "আমরা"}, {"t": "freuen", "bn": "আনন্দিত হচ্ছি"}, {"t": "uns,", "bn": "নিজেদের"}, {"t": "weil", "bn": "কারণ"}, {"t": "wir", "bn": "আমরা"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Prüfung", "bn": "পরীক্ষা"}, {"t": "bestanden", "bn": "উত্তীর্ণ"}, {"t": "haben.", "bn": "হয়েছি"}]),
            ("Sie isst keinen Fisch, weil sie allergisch ist.", "সে মাছ খায় না, কারণ তার অ্যালার্জি আছে।", "যী ইস্ট কাইনেন ফিশ ভাইল যী এলার্গিশ ইস্ত",
             [{"t": "Sie", "bn": "সে"}, {"t": "isst", "bn": "খায়"}, {"t": "keinen", "bn": "কোনো না"}, {"t": "Fisch,", "bn": "মাছ"}, {"t": "weil", "bn": "কারণ"}, {"t": "sie", "bn": "সে"}, {"t": "allergisch", "bn": "অ্যালার্জিক"}, {"t": "ist.", "bn": "হয়"}]),
        ]
    },
    {
        "title_bn": "মতামত ও বিশ্বাস: dass (Ich glaube, dass es morgen regnet)",
        "title_target": "Objektsätze mit dass: Meinung und Wissen",
        "intro_bn": "dass (যে): মতামত, বিশ্বাস বা অন্যের কথা প্রকাশের আশ্রিত বাক্যেও ক্রিয়াপদ শেষে বসে: Ich glaube / weiß / finde, dass...",
        "structure": ["Hauptsatz,", "dass + Subjekt", "Mittelfeld", "Verb am Ende"],
        "items": [
            ("Ich glaube, dass es morgen regnet.", "আমার মনে হয় কাল বৃষ্টি হবে।", "ইখ্ গ্লাউবে ডাস এস মর্গেন রেগনেট",
             [{"t": "Ich", "bn": "আমি"}, {"t": "glaube,", "bn": "বিশ্বাস করি"}, {"t": "dass", "bn": "যে"}, {"t": "es", "bn": "এটি"}, {"t": "morgen", "bn": "কাল"}, {"t": "regnet.", "bn": "বৃষ্টি হবে"}]),
            ("Der Arzt sagt, dass du mehr schlafen sollst.", "ডাক্তার বলেছেন যে তোমার বেশি ঘুমানো উচিত।", "ডের আর্টস্ট জাগ্ট ডাস দু মেয়ার শ্লাফেন জল্স্ট",
             [{"t": "Der", "bn": "নির্দিষ্ট"}, {"t": "Arzt", "bn": "ডাক্তার"}, {"t": "sagt,", "bn": "বলেছেন"}, {"t": "dass", "bn": "যে"}, {"t": "du", "bn": "তোমার"}, {"t": "mehr", "bn": "বেশি"}, {"t": "schlafen", "bn": "ঘুমানো"}, {"t": "sollst.", "bn": "উচিত"}]),
            ("Ich weiß genau, dass er die Wahrheit sagt.", "আমি নিশ্চিতভাবে জানি যে সে সত্যি কথা বলছে।", "ইখ্ ভাইস গেনাউ ডাস এয়ার ডি ভারহাইট জাগ্ট",
             [{"t": "Ich", "bn": "আমি"}, {"t": "weiß", "bn": "জানি"}, {"t": "genau,", "bn": "নিশ্চিতভাবে"}, {"t": "dass", "bn": "যে"}, {"t": "er", "bn": "সে"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Wahrheit", "bn": "সত্য"}, {"t": "sagt.", "bn": "বলছে"}]),
            ("Wir hoffen, dass ihr uns bald besucht.", "আমরা আশা করছি যে তোমরা শীঘ্রই আমাদের দেখতে আসবে।", "ভির হফেন ডাস ইয়ার উন্স বাল্ট বেজুখট",
             [{"t": "Wir", "bn": "আমরা"}, {"t": "hoffen,", "bn": "আশা করছি"}, {"t": "dass", "bn": "যে"}, {"t": "ihr", "bn": "তোমরা"}, {"t": "uns", "bn": "আমাদের"}, {"t": "bald", "bn": "শীঘ্রই"}, {"t": "besucht.", "bn": "দেখতে আসবে"}]),
            ("Es ist wichtig, dass alle pünktlich ankommen.", "এটা জরুরি যে সবাই সময়মতো পৌঁছাবে।", "এস ইস্ত ভিখটিখ ডাস আলে প্যুঙ্কট্লিখ আনকমেন",
             [{"t": "Es", "bn": "এটা"}, {"t": "ist", "bn": "হয়"}, {"t": "wichtig,", "bn": "জরুরি"}, {"t": "dass", "bn": "যে"}, {"t": "alle", "bn": "সবাই"}, {"t": "pünktlich", "bn": "সময়মতো"}, {"t": "ankommen.", "bn": "পৌঁছাবে"}]),
            ("Ich finde, dass Deutsch eine schöne Sprache ist.", "আমার মনে হয় জার্মান একটি সুন্দর ভাষা।", "ইখ্ ফিন্ডে ডাস ডয়চ আইনে শোয়নে শ্প্রাখে ইস্ত",
             [{"t": "Ich", "bn": "আমি"}, {"t": "finde,", "bn": "মনে করি"}, {"t": "dass", "bn": "যে"}, {"t": "Deutsch", "bn": "জার্মান"}, {"t": "eine", "bn": "একটি"}, {"t": "schöne", "bn": "সুন্দর"}, {"t": "Sprache", "bn": "ভাষা"}, {"t": "ist.", "bn": "হয়"}]),
            ("Sie hat erzählt, dass sie nach Berlin umzieht.", "সে জানিয়েছে যে সে বার্লিনে স্থানান্তরিত হচ্ছে।", "যী হাট এয়ারৎসেল্ট ডাস যী নাখ বের্লিন উমৎসীয়ট",
             [{"t": "Sie", "bn": "সে"}, {"t": "hat", "bn": "আছে"}, {"t": "erzählt,", "bn": "জানিয়েছে"}, {"t": "dass", "bn": "যে"}, {"t": "sie", "bn": "সে"}, {"t": "nach", "bn": "এ"}, {"t": "Berlin", "bn": "বার্লিন"}, {"t": "umzieht.", "bn": "স্থানান্তরিত হচ্ছে"}]),
            ("Ich freue mich, dass du heute Zeit hast.", "আমি আনন্দিত যে আজ তোমার সময় হয়েছে।", "ইখ্ ফ্রয়ে নিখ্ ডাস দু হয়টে ৎসাইট হাস্ট",
             [{"t": "Ich", "bn": "আমি"}, {"t": "freue", "bn": "আনন্দিত হচ্ছি"}, {"t": "mich,", "bn": "নিজেকে"}, {"t": "dass", "bn": "যে"}, {"t": "du", "bn": "তোমার"}, {"t": "heute", "bn": "আজ"}, {"t": "Zeit", "bn": "সময়"}, {"t": "hast.", "bn": "আছে"}]),
        ]
    },
    {
        "title_bn": "শর্তসাপেক্ষ বাক্য: wenn (Wenn ich Zeit habe, rufe ich dich an)",
        "title_target": "Konditionalsätze mit wenn: Bedingungen",
        "intro_bn": "wenn (যদি / যখন): শর্ত বা সময় নির্দেশ করতে wenn ব্যবহৃত হয়। বাক্যের শুরুতে wenn থাকলে আশ্রিত বাক্যের শেষে ক্রিয়াপদ বসে এবং প্রধান বাক্যে ক্রিয়াপদ শুরুতে চলে আসে।",
        "structure": ["Wenn + Subjekt + ... + Verb,", "Verb + Subjekt + Mittelfeld"],
        "items": [
            ("Wenn ich Zeit habe, rufe ich dich an.", "সময় পেলে আমি তোমাকে ফোন করব।", "ভেন ইখ্ ৎসাইট হাবে রুফে ইখ্ ডিখ আন",
             [{"t": "Wenn", "bn": "যদি"}, {"t": "ich", "bn": "আমার"}, {"t": "Zeit", "bn": "সময়"}, {"t": "habe,", "bn": "থাকে"}, {"t": "rufe", "bn": "কল করি"}, {"t": "ich", "bn": "আমি"}, {"t": "dich", "bn": "তোমাকে"}, {"t": "an.", "bn": "ফোন"}]),
            ("Wenn das Wetter schön ist, gehen wir spazieren.", "আবহাওয়া ভালো থাকলে আমরা হাঁটতে বের হব।", "ভেন ডাস ভেটার শোয়ন ইস্ত গেহেন ভির শ্পাৎসীরেন",
             [{"t": "Wenn", "bn": "যদি"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Wetter", "bn": "আবহাওয়া"}, {"t": "schön", "bn": "সুন্দর"}, {"t": "ist,", "bn": "হয়"}, {"t": "gehen", "bn": "যাই"}, {"t": "wir", "bn": "আমরা"}, {"t": "spazieren.", "bn": "হাঁটতে"}]),
            ("Ruf mich bitte an, wenn du am Bahnhof ankommst.", "দয়া করে আমাকে ফোন দিও যখন তুমি রেলস্টেশনে পৌঁছাবে।", "রুফ নিখ্ বিটে আন ভেন দু আম বানহোফ আনকম্স্ট",
             [{"t": "Ruf", "bn": "কল করো"}, {"t": "mich", "bn": "আমাকে"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "an,", "bn": "ফোন"}, {"t": "wenn", "bn": "যখন"}, {"t": "du", "bn": "তুমি"}, {"t": "am", "bn": "এ"}, {"t": "Bahnhof", "bn": "রেলস্টেশন"}, {"t": "ankommst.", "bn": "পৌঁছাবে"}]),
            ("Wenn du Kopfschmerzen hast, nimm eine Tablette.", "যদি তোমার মাথাব্যথা থাকে, তবে একটি ওষুধ খাও।", "ভেন দু কপফশমেরৎসেন হাস্ট নিম আইনে টাবলেটে",
             [{"t": "Wenn", "bn": "যদি"}, {"t": "du", "bn": "তোমার"}, {"t": "Kopfschmerzen", "bn": "মাথাব্যথা"}, {"t": "hast,", "bn": "থাকে"}, {"t": "nimm", "bn": "খাও"}, {"t": "eine", "bn": "একটি"}, {"t": "Tablette.", "bn": "ওষুধ"}]),
            ("Wir fahren ans Meer, wenn der Sommer beginnt.", "গ্রীষ্ম শুরু হলে আমরা সমুদ্রসৈকতে যাব।", "ভির ফাহরেন আনস মেয়ার ভেন ডের জোমার বেগিন্ট",
             [{"t": "Wir", "bn": "আমরা"}, {"t": "fahren", "bn": "যাব"}, {"t": "ans", "bn": "এ"}, {"t": "Meer,", "bn": "সমুদ্র"}, {"t": "wenn", "bn": "যখন"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Sommer", "bn": "গ্রীষ্ম"}, {"t": "beginnt.", "bn": "শুরু হয়"}]),
            ("Wenn man viel übt, lernt man schnell.", "অনেক অনুশীলন করলে দ্রুত শেখা যায়।", "ভেন মান ফীল উব্ট লের্নট মান শ্নেল",
             [{"t": "Wenn", "bn": "যদি"}, {"t": "man", "bn": "কেউ"}, {"t": "viel", "bn": "অনেক"}, {"t": "übt,", "bn": "অনুশীলন করে"}, {"t": "lernt", "bn": "শেখে"}, {"t": "man", "bn": "কেউ"}, {"t": "schnell.", "bn": "দ্রুত"}]),
            ("Ich helfe dir gern, wenn du Fragen hast.", "যদি তোমার প্রশ্ন থাকে, আমি সানন্দে তোমাকে সাহায্য করব।", "ইখ্ হেলফে ডিয়ার গের্ন ভেন দু ফ্রাগেন হাস্ট",
             [{"t": "Ich", "bn": "আমি"}, {"t": "helfe", "bn": "সাহায্য করব"}, {"t": "dir", "bn": "তোমাকে"}, {"t": "gern,", "bn": "সানন্দে"}, {"t": "wenn", "bn": "যদি"}, {"t": "du", "bn": "তোমার"}, {"t": "Fragen", "bn": "প্রশ্ন"}, {"t": "hast.", "bn": "থাকে"}]),
            ("Wenn es morgen schneit, bleiben wir zu Hause.", "কাল যদি বরফ পড়ে, আমরা বাড়িতেই থাকব।", "ভেন এস মর্গেন শ্নাইট ব্লাইবেন ভির ৎসু হাউজে",
             [{"t": "Wenn", "bn": "যদি"}, {"t": "es", "bn": "এটি"}, {"t": "morgen", "bn": "কাল"}, {"t": "schneit,", "bn": "বরফ পড়ে"}, {"t": "bleiben", "bn": "থাকব"}, {"t": "wir", "bn": "আমরা"}, {"t": "zu", "bn": "এ"}, {"t": "Hause.", "bn": "বাড়ি"}]),
        ]
    },
    {
        "title_bn": "কথোপকথন: জার্মানি যাওয়ার পরিকল্পনা ও কারণ আলোচনা",
        "title_target": "Gespräch: Pläne und Gründe für Deutschland",
        "intro_bn": "জার্মানিতে উচ্চশিক্ষা ও ভবিষ্যৎ পরিকল্পনা নিয়ে weil, dass এবং wenn সংযোগে দুই বন্ধুর স্পোকেন কথোপকথন।",
        "structure": ["Frage nach Gründen", "Nebensatz (weil / dass / wenn)", "Reiseplan"],
        "items": [
            ("Warum möchtest du eigentlich nach Deutschland gehen?", "তুমি আসলে কেন জার্মানিতে যেতে চাও?", "ভারুম মোয়খটেস্ট দু আইগেন্ট্লিখ নাখ ডয়চলান্ট গেহেন",
             [{"t": "Warum", "bn": "কেন"}, {"t": "möchtest", "bn": "চাও"}, {"t": "du", "bn": "তুমি"}, {"t": "eigentlich", "bn": "আসলে"}, {"t": "nach", "bn": "এ"}, {"t": "Deutschland", "bn": "জার্মানি"}, {"t": "gehen?", "bn": "যেতে"}],
             None, "A", "dialogue_line"),
            ("Ich möchte dort studieren, weil die Universitäten sehr gut sind.", "আমি সেখানে পড়তে চাই, কারণ বিশ্ববিদ্যালয়গুলো খুবই ভালো।", "ইখ্ মোয়খটে ডোর্ট শ্টুডীরেন ভাইল ডি ইউনিভের্জিটেটেন জেয়ার গুট জিন্ট",
             [{"t": "Ich", "bn": "আমি"}, {"t": "möchte", "bn": "চাই"}, {"t": "dort", "bn": "সেখানে"}, {"t": "studieren,", "bn": "পড়াশোনা করতে"}, {"t": "weil", "bn": "কারণ"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Universitäten", "bn": "বিশ্ববিদ্যালয়গুলো"}, {"t": "sehr", "bn": "খুব"}, {"t": "gut", "bn": "ভালো"}, {"t": "sind.", "bn": "হয়"}],
             None, "B", "dialogue_line"),
            ("Ich habe gehört, dass man dafür sehr gute Deutschkenntnisse braucht.", "আমি শুনেছি যে এর জন্য খুব ভালো জার্মান ভাষার দক্ষতা প্রয়োজন।", "ইখ্ হাবে গেহোয়র্ট ডাস মান ডাফ্যুর জেয়ার গুটে ডয়চকেন্তনিসে ব্রাউখ্ট",
             [{"t": "Ich", "bn": "আমি"}, {"t": "habe", "bn": "আছে"}, {"t": "gehört,", "bn": "শুনেছি"}, {"t": "dass", "bn": "যে"}, {"t": "man", "bn": "কারো"}, {"t": "dafür", "bn": "এর জন্য"}, {"t": "sehr", "bn": "খুব"}, {"t": "gute", "bn": "ভালো"}, {"t": "Deutschkenntnisse", "bn": "জার্মান দক্ষতা"}, {"t": "braucht.", "bn": "প্রয়োজন"}],
             None, "A", "dialogue_line"),
            ("Ja, deshalb lerne ich fleißig, weil ich die Prüfung bald machen will.", "হ্যাঁ, সেজন্যই আমি মন দিয়ে শিখছি, কারণ আমি শীঘ্রই পরীক্ষাটি দিতে চাই।", "ইয়া ডেসহাল্ব লের্নে ইখ্ ফ্লাইসিখ ভাইল ইখ্ ডি প্যুরফুং বাল্ট মাখেন ভিল",
             [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "deshalb", "bn": "সেজন্য"}, {"t": "lerne", "bn": "শিখছি"}, {"t": "ich", "bn": "আমি"}, {"t": "fleißig,", "bn": "মন দিয়ে"}, {"t": "weil", "bn": "কারণ"}, {"t": "ich", "bn": "আমি"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Prüfung", "bn": "পরীক্ষা"}, {"t": "bald", "bn": "শীঘ্রই"}, {"t": "machen", "bn": "দিতে"}, {"t": "will.", "bn": "চাই"}],
             None, "B", "dialogue_line"),
            ("Was machst du, wenn du in Frankfurt ankommst?", "ফ্রাঙ্কফুর্টে পৌঁছালে তুমি কী করবে?", "ভাস মাখ্স্ট দু ভেন দু ইন ফ্রাঙ্কফুর্ট আনকম্স্ট",
             [{"t": "Was", "bn": "কী"}, {"t": "machst", "bn": "করবে"}, {"t": "du,", "bn": "তুমি"}, {"t": "wenn", "bn": "যখন"}, {"t": "du", "bn": "তুমি"}, {"t": "in", "bn": "এ"}, {"t": "Frankfurt", "bn": "ফ্রাঙ্কফুর্ট"}, {"t": "ankommst?", "bn": "পৌঁছাবে"}],
             None, "A", "dialogue_line"),
            ("Wenn ich dort lande, holt mein Onkel mich vom Flughafen ab.", "আমি সেখানে নামলে আমার মামা আমাকে বিমানবন্দর থেকে নিয়ে আসবেন।", "ভেন ইখ্ ডোর্ট লান্ডে হোল্ট মাইন অংকেল নিখ্ ফম ফ্লুগহাফেন আব",
             [{"t": "Wenn", "bn": "যখন"}, {"t": "ich", "bn": "আমি"}, {"t": "dort", "bn": "সেখানে"}, {"t": "lande,", "bn": "অবতরণ করব"}, {"t": "holt", "bn": "নিয়ে আসবেন"}, {"t": "mein", "bn": "আমার"}, {"t": "Onkel", "bn": "মামা"}, {"t": "mich", "bn": "আমাকে"}, {"t": "vom", "bn": "থেকে"}, {"t": "Flughafen", "bn": "বিমানবন্দর"}, {"t": "ab.", "bn": "তুলে"}],
             None, "B", "dialogue_line"),
            ("Ich wünsche dir viel Erfolg, dass alles klappt!", "আমি তোমার সাফল্য কামনা করি, যেন সব ঠিকঠাক হয়!", "ইখ্ ভ্যুনশে ডিয়ার ফীল এয়ারফোক ডাস আলেস ক্লাপ্ট",
             [{"t": "Ich", "bn": "আমি"}, {"t": "wünsche", "bn": "কামনা করি"}, {"t": "dir", "bn": "তোমার"}, {"t": "viel", "bn": "অনেক"}, {"t": "Erfolg,", "bn": "সাফল্য"}, {"t": "dass", "bn": "যেন"}, {"t": "alles", "bn": "সব"}, {"t": "klappt!", "bn": "ঠিকঠাক হয়"}],
             None, "A", "dialogue_line"),
            ("Vielen Dank, ich freue mich schon sehr auf die Reise.", "অনেক ধন্যবাদ, আমি ইতোমধ্যে এই যাত্রার জন্য অত্যন্ত আনন্দিত।", "ফীলেন ডাঙ্ক ইখ্ ফ্রয়ে নিখ্ শোন জেয়ার আউফ ডি রাইজে",
             [{"t": "Vielen", "bn": "অনেক"}, {"t": "Dank,", "bn": "ধন্যবাদ"}, {"t": "ich", "bn": "আমি"}, {"t": "freue", "bn": "আনন্দিত হচ্ছি"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "schon", "bn": "ইতোমধ্যে"}, {"t": "sehr", "bn": "খুব"}, {"t": "auf", "bn": "জন্য"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Reise.", "bn": "ভ্রমণ"}],
             None, "B", "dialogue_line"),
        ]
    }
]
parts_p1.append(("de-a2-05", "আশ্রিত খণ্ডবাক্য: কারণ ও শর্ত", "Nebensätze: weil, dass, wenn", p5_lessons))

# =========================================================================
# Unit de-a2-06: ভ্রমণ ও ডয়চে বান ট্রেন সার্ভিস (Reisen & Deutsche Bahn)
# =========================================================================
p6_lessons = [
    {
        "title_bn": "ট্রেনের টিকিট কাটা (Einfache Fahrt oder Hin- und Rückfahrt?)",
        "title_target": "Fahrkartenkauf am Schalter und Automaten",
        "intro_bn": "জার্মানিতে ট্রেনের টিকিট কাটা, সিট বুকিং ও ডিসকাউন্ট কার্ড (BahnCard) সম্পর্কিত স্পোকেন কথোপকথন।",
        "structure": ["Fahrtziel", "Fahrkartenart", "Preis & Reservierung"],
        "items": [
            ("Ich möchte eine Fahrkarte nach München kaufen.", "আমি মিউনিখের একটি ট্রেনের টিকিট কিনতে চাই।", "ইখ্ মোয়খটে আইনে ফাহরকার্টে নাখ ম্যুনশেন কাউফেন",
             [{"t": "Ich", "bn": "আমি"}, {"t": "möchte", "bn": "চাই"}, {"t": "eine", "bn": "একটি"}, {"t": "Fahrkarte", "bn": "টিকিট"}, {"t": "nach", "bn": "এ"}, {"t": "München", "bn": "মিউনিখ"}, {"t": "kaufen.", "bn": "কিনতে"}]),
            ("Einfache Fahrt oder Hin- und Rückfahrt?", "একমুখী যাত্রা নাকি যাওয়া-আসার টিকিট?", "আইনফাখে ফাহর্ট ওডার হিন উন্ট র্যুকফাহর্ট",
             [{"t": "Einfache", "bn": "একমুখী"}, {"t": "Fahrt", "bn": "যাত্রা"}, {"t": "oder", "bn": "নাকি"}, {"t": "Hin-", "bn": "যাওয়া"}, {"t": "und", "bn": "এবং"}, {"t": "Rückfahrt?", "bn": "আসা"}]),
            ("Ich brauche bitte nur eine einfache Fahrt.", "আমার দয়া করে কেবল একমুখী যাত্রার টিকিট লাগবে।", "ইখ্ ব্রাউখে বিটে নুর আইনে আইনফাখে ফাহর্ট",
             [{"t": "Ich", "bn": "আমার"}, {"t": "brauche", "bn": "দরকার"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "nur", "bn": "কেবল"}, {"t": "eine", "bn": "একটি"}, {"t": "einfache", "bn": "একমুখী"}, {"t": "Fahrt.", "bn": "যাত্রা"}]),
            ("Haben Sie eine BahnCard?", "আপনার কি কোনো বানকার্ড আছে?", "হাবন যী আইনে বানকার্ট",
             [{"t": "Haben", "bn": "আছে কি"}, {"t": "Sie", "bn": "আপনার"}, {"t": "eine", "bn": "একটি"}, {"t": "BahnCard?", "bn": "বানকার্ড"}]),
            ("Nein, ich habe leider keine BahnCard.", "না, দুর্ভাগ্যবশত আমার কোনো বানকার্ড নেই।", "নাইন ইখ্ হাবে লাইডার কাইনে বানকার্ট",
             [{"t": "Nein,", "bn": "না"}, {"t": "ich", "bn": "আমার"}, {"t": "habe", "bn": "আছে"}, {"t": "leider", "bn": "দুর্ভাগ্যবশত"}, {"t": "keine", "bn": "কোনো না"}, {"t": "BahnCard.", "bn": "বানকার্ড"}]),
            ("Möchten Sie einen Sitzplatz reservieren?", "আপনি কি একটি সিট রিজার্ভ করতে চান?", "মোয়খটেন যী আইনেন জিৎসপ্লাৎস রেজালভিয়ারেন",
             [{"t": "Möchten", "bn": "চান কি"}, {"t": "Sie", "bn": "আপনি"}, {"t": "einen", "bn": "একটি"}, {"t": "Sitzplatz", "bn": "আসন"}, {"t": "reservieren?", "bn": "সংরক্ষণ করতে"}]),
            ("Ja bitte, einen Fensterplatz im Großraumwagen.", "হ্যাঁ দয়া করে, ওপেন কোচে জানালার পাশের একটি সিট।", "ইয়া বিটে আইনেন ফেন্সটারপ্লাৎস ইম গ্রোসরাউমভাগেন",
             [{"t": "Ja", "bn": "হ্যাঁ"}, {"t": "bitte,", "bn": "দয়া করে"}, {"t": "einen", "bn": "একটি"}, {"t": "Fensterplatz", "bn": "জানালার আসন"}, {"t": "im", "bn": "এ"}, {"t": "Großraumwagen.", "bn": "ওপেন কোচ"}]),
            ("Die Fahrkarte kostet vierzig Euro.", "টিকিটটির দাম চল্লিশ ইউরো।", "ডি ফাহরকার্টে কস্টেট ফিয়ারৎসিশ অয়রো",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Fahrkarte", "bn": "টিকিট"}, {"t": "kostet", "bn": "দাম"}, {"t": "vierzig", "bn": "চল্লিশ"}, {"t": "Euro.", "bn": "ইউরো"}]),
        ]
    },
    {
        "title_bn": "প্ল্যাটফর্ম ও ট্রেনের বিলম্ব ঘোষণা (Gleis vier, zehn Minuten Verspätung)",
        "title_target": "Ansagen am Bahnsteig: Gleis und Verspätung",
        "intro_bn": "রেলস্টেশনের লাউডস্পিকার ঘোষণা, প্ল্যাটফর্ম নম্বর (Gleis) এবং ট্রেনের দেরি (Verspätung) সংক্রান্ত জরুরি ঘোষণা।",
        "structure": ["Gleisangabe", "Zugtyp & Ziel", "Verspätungsgrund"],
        "items": [
            ("Der Intercity nach Hamburg fährt von Gleis vier ab.", "হামবুর্গগামী ইন্টারসিটি ট্রেন চার নম্বর প্ল্যাটফর্ম থেকে ছাড়বে।", "ডের ইন্টারসিটি নাখ হামবুর্গ ফেয়ার্ট ফন গ্লাইস ফিয়ার আব",
             [{"t": "Der", "bn": "নির্দিষ্ট"}, {"t": "Intercity", "bn": "ইন্টারসিটি ট্রেন"}, {"t": "nach", "bn": "এ"}, {"t": "Hamburg", "bn": "হামবুর্গ"}, {"t": "fährt", "bn": "ছাড়বে"}, {"t": "von", "bn": "থেকে"}, {"t": "Gleis", "bn": "প্ল্যাটফর্ম"}, {"t": "vier", "bn": "চার"}, {"t": "ab.", "bn": "ছেড়ে যাওয়া"}]),
            ("Achtung an Gleis zwei, der Zug fährt ein.", "দুই নম্বর প্ল্যাটফর্মের যাত্রীরা সতর্ক হোন, ট্রেনটি প্রবেশ করছে।", "আখটুং আন গ্লাইস ৎস্ভাই ডের ৎসুক ফেয়ার্ট আইন",
             [{"t": "Achtung", "bn": "সতর্কতা"}, {"t": "an", "bn": "এ"}, {"t": "Gleis", "bn": "প্ল্যাটফর্ম"}, {"t": "zwei,", "bn": "দুই"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Zug", "bn": "ট্রেন"}, {"t": "fährt", "bn": "প্রবেশ করছে"}, {"t": "ein.", "bn": "ভেতরে"}]),
            ("Der Zug hat heute etwa zehn Minuten Verspätung.", "ট্রেনটির আজ প্রায় দশ মিনিট বিলম্ব রয়েছে।", "ডের ৎসুক হাট হয়টে এটভা ৎসেন মিনুটেন ফেয়ার্শ্পেটুং",
             [{"t": "Der", "bn": "নির্দিষ্ট"}, {"t": "Zug", "bn": "ট্রেন"}, {"t": "hat", "bn": "আছে"}, {"t": "heute", "bn": "আজ"}, {"t": "etwa", "bn": "প্রায়"}, {"t": "zehn", "bn": "দশ"}, {"t": "Minuten", "bn": "মিনিট"}, {"t": "Verspätung.", "bn": "বিলম্ব"}]),
            ("Auf welchem Gleis fährt unser Zug ab?", "আমাদের ট্রেনটি কোন প্ল্যাটফর্ম থেকে ছাড়বে?", "আউফ ভেলশেম গ্লাইস ফেয়ার্ট উনজের ৎসুক আব",
             [{"t": "Auf", "bn": "এ"}, {"t": "welchem", "bn": "কোন"}, {"t": "Gleis", "bn": "প্ল্যাটফর্ম"}, {"t": "fährt", "bn": "ছাড়বে"}, {"t": "unser", "bn": "আমাদের"}, {"t": "Zug", "bn": "ট্রেন"}, {"t": "ab?", "bn": "ছেড়ে"}]),
            ("Der ICE fällt heute leider aus.", "আইসিই ট্রেনটি আজ দুর্ভাগ্যবশত বাতিল করা হয়েছে।", "ডের ইৎসেএ ফেল্ট হয়টে লাইডার আউস",
             [{"t": "Der", "bn": "নির্দিষ্ট"}, {"t": "ICE", "bn": "আইসিই ট্রেন"}, {"t": "fällt", "bn": "বাতিল"}, {"t": "heute", "bn": "আজ"}, {"t": "leider", "bn": "দুর্ভাগ্যবশত"}, {"t": "aus.", "bn": "হওয়া"}]),
            ("Bitte achten Sie auf die Lautsprecherdurchsagen.", "দয়া করে লাউডস্পিকারের ঘোষণার প্রতি খেয়াল রাখুন।", "বিটে আখটেন যী আউফ ডি লাউটশ্প্রেশারডুর্খজাগেন",
             [{"t": "Bitte", "bn": "দয়া করে"}, {"t": "achten", "bn": "খেয়াল রাখুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "auf", "bn": "প্রতি"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Lautsprecherdurchsagen.", "bn": "মাইকের ঘোষণাগুলো"}]),
            ("Die Türen schließen automatisch, bitte zurückbleiben.", "দরজা স্বয়ংক্রিয়ভাবে বন্ধ হচ্ছে, দয়া করে দূরে থাকুন।", "ডি ত্যুরেন শ্লীসেন আউটোমাটিশ বিটে ৎসুর্যুকব্লাইবেন",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Türen", "bn": "দরজাগুলো"}, {"t": "schließen", "bn": "বন্ধ হয়"}, {"t": "automatisch,", "bn": "স্বয়ংক্রিয়ভাবে"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "zurückbleiben.", "bn": "পিছনে থাকা"}]),
            ("Wir erreichen in wenigen Minuten den Hauptbahnhof.", "আমরা কয়েক মিনিটের মধ্যেই প্রধান রেলস্টেশনে পৌঁছাব।", "ভির এয়াররাইশেন ইন ভেনিগেন মিনুটেন ডেন হাউপ্টবানহোফ",
             [{"t": "Wir", "bn": "আমরা"}, {"t": "erreichen", "bn": "পৌঁছাব"}, {"t": "in", "bn": "মধ্যে"}, {"t": "wenigen", "bn": "কয়েক"}, {"t": "Minuten", "bn": "মিনিট"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Hauptbahnhof.", "bn": "প্রধান রেলস্টেশন"}]),
        ]
    },
    {
        "title_bn": "ট্রেন বদল ও গন্তব্যে পৌঁছানো (Umsteigen in Frankfurt)",
        "title_target": "Umsteigen und Anschlusszug",
        "intro_bn": "ট্রেন পরিবর্তন (umsteigen), কানেক্টিং ট্রেন (Anschlusszug) এবং গন্তব্যে পৌঁছানোর স্পোকেন প্র্যাকটিস।",
        "structure": ["Umsteigebahnhof", "Anschluss", "Weiterfahrt"],
        "items": [
            ("Müssen wir auf der Reise umsteigen?", "আমাদের কি যাত্রাপথে ট্রেন বদলাতে হবে?", "ম্যূসেন ভির আউফ ডের রাইজে উমশ্টাইগেন",
             [{"t": "Müssen", "bn": "হবে কি"}, {"t": "wir", "bn": "আমাদের"}, {"t": "auf", "bn": "এ"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Reise", "bn": "যাত্রা"}, {"t": "umsteigen?", "bn": "ট্রেন বদলানো"}]),
            ("Sie müssen in Frankfurt am Main umsteigen.", "আপনাকে ফ্রাঙ্কফুর্ট আম মেইনে ট্রেন পরিবর্তন করতে হবে।", "যী ম্যূসেন ইন ফ্রাঙ্কফুর্ট আম মাইন উমশ্টাইগেন",
             [{"t": "Sie", "bn": "আপনাকে"}, {"t": "müssen", "bn": "হবে"}, {"t": "in", "bn": "এ"}, {"t": "Frankfurt", "bn": "ফ্রাঙ্কফুর্ট"}, {"t": "am", "bn": "আম"}, {"t": "Main", "bn": "মাইন"}, {"t": "umsteigen.", "bn": "ট্রেন পরিবর্তন করতে"}]),
            ("Wie viel Zeit habe ich zum Umsteigen?", "ট্রেন বদলানোর জন্য আমার কতটুকু সময় আছে?", "ভী ফীল ৎসাইট হাবে ইখ্ ৎসুম উমশ্টাইগেন",
             [{"t": "Wie", "bn": "কত"}, {"t": "viel", "bn": "টুকু"}, {"t": "Zeit", "bn": "সময়"}, {"t": "habe", "bn": "আছে"}, {"t": "ich", "bn": "আমার"}, {"t": "zum", "bn": "জন্য"}, {"t": "Umsteigen?", "bn": "ট্রেন বদল"}]),
            ("Sie haben fünfzehn Minuten Zeit für den Anschluss.", "সংযোগকারী ট্রেনের জন্য আপনার কাছে পনেরো মিনিট সময় আছে।", "যী হাবন ফ্যুনফৎসেন মিনুটেন ৎসাইট ফ্যুর ডেন আনশ্লুস",
             [{"t": "Sie", "bn": "আপনার"}, {"t": "haben", "bn": "আছে"}, {"t": "fünfzehn", "bn": "পনেরো"}, {"t": "Minuten", "bn": "মিনিট"}, {"t": "Zeit", "bn": "সময়"}, {"t": "für", "bn": "জন্য"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Anschluss.", "bn": "সংযোগ"}]),
            ("Ich habe leider meinen Anschlusszug verpasst.", "দুর্ভাগ্যবশত আমি আমার সংযোগকারী ট্রেনটি মিস করেছি।", "ইখ্ হাবে লাইডার মাইনেন আনশ্লুসৎসুক ফেয়ার্পাস্ট",
             [{"t": "Ich", "bn": "আমি"}, {"t": "habe", "bn": "ফেলেছি"}, {"t": "leider", "bn": "দুর্ভাগ্যবশত"}, {"t": "meinen", "bn": "আমার"}, {"t": "Anschlusszug", "bn": "সংযোগকারী ট্রেন"}, {"t": "verpasst.", "bn": "মিস"}]),
            ("Wann kommt der nächste Zug nach Köln?", "কোলনের পরবর্তী ট্রেন কখন আসবে?", "ভান কমট ডের নেখস্টে ৎসুক নাখ কোলন",
             [{"t": "Wann", "bn": "কখন"}, {"t": "kommt", "bn": "আসবে"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "nächste", "bn": "পরবর্তী"}, {"t": "Zug", "bn": "ট্রেন"}, {"t": "nach", "bn": "এ"}, {"t": "Köln?", "bn": "কোলন"}]),
            ("Ihr Anschlusszug wartet auf Gleis sieben.", "আপনার সংযোগকারী ট্রেনটি সাত নম্বর প্ল্যাটফর্মে অপেক্ষা করছে।", "ইয়ার আনশ্লুসৎসুক ভার্টেট আউফ গ্লাইস যীবেন",
             [{"t": "Ihr", "bn": "আপনার"}, {"t": "Anschlusszug", "bn": "সংযোগকারী ট্রেন"}, {"t": "wartet", "bn": "অপেক্ষা করছে"}, {"t": "auf", "bn": "এ"}, {"t": "Gleis", "bn": "প্ল্যাটফর্ম"}, {"t": "sieben.", "bn": "সাত"}]),
            ("Gute Reise und eine angenehme Fahrt!", "আপনার ভ্রমণ শুভ ও আরামদায়ক হোক!", "গুটে রাইজে উন্ট আইনে আনগেনেহমে ফাহর্ট",
             [{"t": "Gute", "bn": "শুভ"}, {"t": "Reise", "bn": "ভ্রমণ"}, {"t": "und", "bn": "এবং"}, {"t": "eine", "bn": "একটি"}, {"t": "angenehme", "bn": "আরামদায়ক"}, {"t": "Fahrt!", "bn": "যাত্রা"}]),
        ]
    },
    {
        "title_bn": "কথোপকথন: রেলস্টেশনের তথ্য ও টিকিট কাউন্টারে",
        "title_target": "Gespräch am DB-Reisezentrum: Verbindung & Ticket",
        "intro_bn": "ডয়চে বান ইনফরমেশন বা টিকিট সেন্টারে ট্রেনের সময়সূচি, সংযোগ ও টিকিট কেনার স্পোকেন কথোপকথন।",
        "structure": ["Reisender", "Bahnbeamter", "Verbindungsauskunft"],
        "items": [
            ("Guten Tag, wie komme ich am schnellsten nach Berlin?", "শুভ দিন, আমি কীভাবে সবচেয়ে দ্রুত বার্লিন যেতে পারি?", "গুটেন তাক ভী কমে ইখ্ আম শ্নেলস্টেন নাখ বের্লিন",
             [{"t": "Guten", "bn": "শুভ"}, {"t": "Tag,", "bn": "দিন"}, {"t": "wie", "bn": "কীভাবে"}, {"t": "komme", "bn": "যাব"}, {"t": "ich", "bn": "আমি"}, {"t": "am", "bn": "সবচেয়ে"}, {"t": "schnellsten", "bn": "দ্রুত"}, {"t": "nach", "bn": "এ"}, {"t": "Berlin?", "bn": "বার্লিন"}],
             None, "A", "dialogue_line"),
            ("Der schnellste ICE fährt um vierzehn Uhr ab.", "সবচেয়ে দ্রুতগামী আইসিই ট্রেনটি দুপুর দুটোয় ছাড়বে।", "ডের শ্নেলস্টে ইৎসেএ ফেয়ার্ট উম ফিয়ারৎসেন উর আব",
             [{"t": "Der", "bn": "নির্দিষ্ট"}, {"t": "schnellste", "bn": "সবচেয়ে দ্রুতগামী"}, {"t": "ICE", "bn": "আইসিই"}, {"t": "fährt", "bn": "ছাড়বে"}, {"t": "um", "bn": "টায়"}, {"t": "vierzehn", "bn": "চৌদ্দ"}, {"t": "Uhr", "bn": "ঘড়ি"}, {"t": "ab.", "bn": "ছেড়ে"}],
             None, "B", "dialogue_line"),
            ("Muss ich bei dieser Verbindung irgendwo umsteigen?", "এই যাত্রায় কি আমাকে কোথাও ট্রেন পরিবর্তন করতে হবে?", "মুস ইখ্ বাই ডীজার ফেয়ারবিন্ডুং ইরগেন্টভো উমশ্টাইগেন",
             [{"t": "Muss", "bn": "হবে কি"}, {"t": "ich", "bn": "আমাকে"}, {"t": "bei", "bn": "ক্ষেত্রে"}, {"t": "dieser", "bn": "এই"}, {"t": "Verbindung", "bn": "সংযোগ"}, {"t": "irgendwo", "bn": "কোথাও"}, {"t": "umsteigen?", "bn": "ট্রেন বদলাতে"}],
             None, "A", "dialogue_line"),
            ("Nein, das ist eine direkte Verbindung ohne Umsteigen.", "না, এটি কোনো পরিবর্তন ছাড়া সরাসরি ট্রেন সংযোগ।", "নাইন ডাস ইস্ত আইনে ডিরেক্টে ফেয়ারবিন্ডুং ওনে উমশ্টাইগেন",
             [{"t": "Nein,", "bn": "না"}, {"t": "das", "bn": "এটি"}, {"t": "ist", "bn": "হয়"}, {"t": "eine", "bn": "একটি"}, {"t": "direkte", "bn": "সরাসরি"}, {"t": "Verbindung", "bn": "সংযোগ"}, {"t": "ohne", "bn": "ছাড়া"}, {"t": "Umsteigen.", "bn": "বদল"}],
             None, "B", "dialogue_line"),
            ("Sehr gut, und wie viel kostet die Hin- und Rückfahrt?", "খুব ভালো, এবং যাওয়া-আসার টিকিটের দাম কত?", "জেয়ার গুট উন্ট ভী ফীল কস্টেট ডি হিন উন্ট র্যুকফাহর্ট",
             [{"t": "Sehr", "bn": "খুব"}, {"t": "gut,", "bn": "ভালো"}, {"t": "und", "bn": "আর"}, {"t": "wie", "bn": "কত"}, {"t": "viel", "bn": "টুকু"}, {"t": "kostet", "bn": "দাম"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Hin-", "bn": "যাওয়া"}, {"t": "und", "bn": "এবং"}, {"t": "Rückfahrt?", "bn": "আসা"}],
             None, "A", "dialogue_line"),
            ("Mit Platzreservierung kostet das Ticket achtzig Euro.", "আসন সংরক্ষণসহ টিকিটটির দাম আশি ইউরো।", "মিট প্লাৎসরেজারভিয়ারুং কস্টেট ডাস টিকেট আখৎসিশ অয়রো",
             [{"t": "Mit", "bn": "সহ"}, {"t": "Platzreservierung", "bn": "সিট রিজার্ভেশন"}, {"t": "kostet", "bn": "দাম"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Ticket", "bn": "টিকিট"}, {"t": "achtzig", "bn": "আশি"}, {"t": "Euro.", "bn": "ইউরো"}],
             None, "B", "dialogue_line"),
            ("Kann ich hier mit Karte bezahlen?", "আমি কি এখানে কার্ড দিয়ে পেমেন্ট করতে পারি?", "কান ইখ্ হিয়ার মিট কার্টে বেৎসালন",
             [{"t": "Kann", "bn": "পারি কি"}, {"t": "ich", "bn": "আমি"}, {"t": "hier", "bn": "এখানে"}, {"t": "mit", "bn": "দিয়ে"}, {"t": "Karte", "bn": "কার্ড"}, {"t": "bezahlen?", "bn": "পেমেন্ট করতে"}],
             None, "A", "dialogue_line"),
            ("Selbstverständlich, stecken Sie Ihre Karte einfach hier ein.", "অবশ্যই, আপনার কার্ডটি শুধু এখানে প্রবেশ করান।", "জেল্বস্টফেয়ার্শ্টেন্ডলিখ শ্টেকেন যী ইয়াহরে কার্টে আইনফাখ হিয়ার আইন",
             [{"t": "Selbstverständlich,", "bn": "অবশ্যই"}, {"t": "stecken", "bn": "প্রবেশ করান"}, {"t": "Sie", "bn": "আপনি"}, {"t": "Ihre", "bn": "আপনার"}, {"t": "Karte", "bn": "কার্ড"}, {"t": "einfach", "bn": "সহজভাবে"}, {"t": "hier", "bn": "এখানে"}, {"t": "ein.", "bn": "ভেতরে"}],
             None, "B", "dialogue_line"),
        ]
    }
]
parts_p1.append(("de-a2-06", "ভ্রমণ ও ডয়চে বান ট্রেন সার্ভিস", "Reisen & Deutsche Bahn", p6_lessons))

# =========================================================================
# Unit de-a2-07: বাসা খোঁজা ও ডব্লিউজি ফ্ল্যাটশেয়ার (Wohnungssuche & WG-Leben)
# =========================================================================
p7_lessons = [
    {
        "title_bn": "বাসা খোঁজা ও বাড়িওয়ালার সাথে যোগাযোগ (Ich interessiere mich für das Zimmer)",
        "title_target": "Wohnungssuche: Kontaktaufnahme",
        "intro_bn": "বাসা খোঁজা, বিজ্ঞাপন দেখে বাড়িওয়ালা বা ডব্লিউজি-র সাথে যোগাযোগ করার প্রয়োজনীয় স্পোকেন বাক্য।",
        "structure": ["Interesse", "Zimmer / Wohnung", "Lage & Zustand"],
        "items": [
            ("Ich interessiere mich sehr für das freie Zimmer.", "আমি খালি রুমটির ব্যাপারে অত্যন্ত আগ্রহী।", "ইখ্ ইন্টারেসিয়ারে নিখ্ জেয়ার ফ্যুর ডাস ফ্রাইয়ে ৎসীমার",
             [{"t": "Ich", "bn": "আমি"}, {"t": "interessiere", "bn": "আগ্রহ প্রকাশ করছি"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "sehr", "bn": "খুব"}, {"t": "für", "bn": "জন্য"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "freie", "bn": "খালি"}, {"t": "Zimmer.", "bn": "রুম"}]),
            ("Ist die Wohnung ab sofort bezugsfrei?", "ফ্ল্যাটটি কি অবিলম্বে ওঠার উপযোগী?", "ইস্ত ডি ভোনুং আব জোফোর্ট বেৎসুকসফ্রাই",
             [{"t": "Ist", "bn": "হয় কি"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Wohnung", "bn": "ফ্ল্যাট"}, {"t": "ab", "bn": "থেকে"}, {"t": "sofort", "bn": "অবিলম্বে"}, {"t": "bezugsfrei?", "bn": "ওঠার উপযোগী"}]),
            ("Die Wohnung hat zwei Zimmer und einen Balkon.", "ফ্ল্যাটটিতে দুটি কক্ষ এবং একটি বারান্দা রয়েছে।", "ডি ভোনুং হাট ৎস্ভাই ৎসীমার উন্ট আইনেন ব্যালকং",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Wohnung", "bn": "ফ্ল্যাট"}, {"t": "hat", "bn": "আছে"}, {"t": "zwei", "bn": "দুই"}, {"t": "Zimmer", "bn": "রুম"}, {"t": "und", "bn": "এবং"}, {"t": "einen", "bn": "একটি"}, {"t": "Balkon.", "bn": "বারান্দা"}]),
            ("Ich suche eine kleine Wohnung im Zentrum.", "আমি শহরের কেন্দ্রে একটি ছোট ফ্ল্যাট খুঁজছি।", "ইখ্ জুখে আইনে ক্লাইনে ভোনুং ইম ৎসেনট্রুম",
             [{"t": "Ich", "bn": "আমি"}, {"t": "suche", "bn": "খুঁজছি"}, {"t": "eine", "bn": "একটি"}, {"t": "kleine", "bn": "ছোট"}, {"t": "Wohnung", "bn": "ফ্ল্যাট"}, {"t": "im", "bn": "এ"}, {"t": "Zentrum.", "bn": "কেন্দ্রস্থল"}]),
            ("Ich bin Student und wohne gerne in einer WG.", "আমি একজন ছাত্র এবং একটি শেয়ার্ড ফ্ল্যাটে থাকতে পছন্দ করি।", "ইখ্ বিন শ্টুডেন্ট উন্ট ভোনে গের্নে ইন আইনেয়ার ভেগে",
             [{"t": "Ich", "bn": "আমি"}, {"t": "bin", "bn": "হই"}, {"t": "Student", "bn": "ছাত্র"}, {"t": "und", "bn": "এবং"}, {"t": "wohne", "bn": "থাকি"}, {"t": "gerne", "bn": "সানন্দে"}, {"t": "in", "bn": "এ"}, {"t": "einer", "bn": "একটি"}, {"t": "WG.", "bn": "শেয়ার্ড ফ্ল্যাট"}]),
            ("Wie viele Personen wohnen in der Wohngemeinschaft?", "শেয়ার্ড ফ্ল্যাটটিতে কতজন ব্যক্তি বাস করেন?", "ভী ফীলে পেয়ারজোনেন ভোনেন ইন ডের ভোনগেমাইনশাফট",
             [{"t": "Wie", "bn": "কত"}, {"t": "viele", "bn": "জন"}, {"t": "Personen", "bn": "ব্যক্তি"}, {"t": "wohnen", "bn": "থাকেন"}, {"t": "in", "bn": "এ"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Wohngemeinschaft?", "bn": "শেয়ার্ড অ্যাপার্টমেন্ট"}]),
            ("Die Lage ist ruhig und sehr verkehrsgünstig.", "অবস্থানটি শান্ত এবং যোগাযোগ ব্যবস্থা অত্যন্ত সুবিধাজনক।", "ডি লাগো ইস্ত রুহিষ উন্ট জেয়ার ফেয়ারকেহর্সগ্যুনস্টিখ",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Lage", "bn": "অবস্থান"}, {"t": "ist", "bn": "হয়"}, {"t": "ruhig", "bn": "শান্ত"}, {"t": "und", "bn": "এবং"}, {"t": "sehr", "bn": "খুব"}, {"t": "verkehrsgünstig.", "bn": "সুবিধাজনক যোগাযোগ"}]),
            ("Ich möchte mich kurz bei Ihnen bewerben.", "আমি সংক্ষেপে আপনার কাছে আবেদন করতে চাই।", "ইখ্ মোয়খটে নিখ্ কুর্ৎস বাই ইনেন বেভের্বেন",
             [{"t": "Ich", "bn": "আমি"}, {"t": "möchte", "bn": "চাই"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "kurz", "bn": "সংক্ষেপে"}, {"t": "bei", "bn": "কাছে"}, {"t": "Ihnen", "bn": "আপনার"}, {"t": "bewerben.", "bn": "আবেদন করতে"}]),
        ]
    },
    {
        "title_bn": "বাড়িভাড়া, ডিপোজিট ও বিল (Warmmiete, Kaltmiete, Kaution)",
        "title_target": "Kosten: Miete, Nebenkosten und Kaution",
        "intro_bn": "জার্মানিতে বাসা ভাড়ার হিসাব: Kaltmiete (কোল্ড রেন্ট), Nebenkosten (ইউটিলিটি বিল), Warmmiete (মোট ভাড়া) ও Kaution (ডিপোজিট)।",
        "structure": ["Mietbegriff", "Zahlenangabe", "Zahlungsbedingungen"],
        "items": [
            ("Wie hoch ist die monatliche Kaltmiete?", "মাসিক মূল ভাড়া কোল্ড রেন্ট কত?", "ভী হোহ ইস্ত ডি মোনাটলিখো কাল্টমীটে",
             [{"t": "Wie", "bn": "কত"}, {"t": "hoch", "bn": "উচ্চ"}, {"t": "ist", "bn": "হয়"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "monatliche", "bn": "মাসিক"}, {"t": "Kaltmiete?", "bn": "মূল ভাড়া"}]),
            ("Die Kaltmiete beträgt vierhundert Euro im Monat.", "মূল ভাড়া মাসে চারশত ইউরো।", "ডি কাল্টমীটে বেট্রেকূট ফিয়ারহুন্ডার্ট অয়রো ইম মোনাট",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Kaltmiete", "bn": "মূল ভাড়া"}, {"t": "beträgt", "bn": "পরিমাণ হয়"}, {"t": "vierhundert", "bn": "চারশত"}, {"t": "Euro", "bn": "ইউরো"}, {"t": "im", "bn": "এ"}, {"t": "Monat.", "bn": "মাস"}]),
            ("Die Nebenkosten betragen einhundert Euro.", "ইউটিলিটি খরচ একশত ইউরো।", "ডি নেবেনকস্টেন বেট্রেগেন আইনহুন্ডার্ট অয়রো",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Nebenkosten", "bn": "ইউটিলিটি বিল"}, {"t": "betragen", "bn": "পরিমাণ হয়"}, {"t": "einhundert", "bn": "একশত"}, {"t": "Euro.", "bn": "ইউরো"}]),
            ("Die Warmmiete beträgt also fünfhundert Euro.", "মোট উষ্ণ ভাড়া তাহলে পাঁচশত ইউরো।", "ডি ভার্মমীটে বেট্রেকূট আলজো ফ্যুনফহুন্ডার্ট অয়রো",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Warmmiete", "bn": "মোট ভাড়া"}, {"t": "beträgt", "bn": "পরিমাণ হয়"}, {"t": "also", "bn": "তাহলে"}, {"t": "fünfhundert", "bn": "পাঁচশত"}, {"t": "Euro.", "bn": "ইউরো"}]),
            ("Sind Strom und Heizung in den Kosten enthalten?", "বিদ্যুৎ ও হিটিংয়ের বিল কি এই খরচে অন্তর্ভুক্ত?", "জিন্ট শ্ট্রোম উন্ট হাইৎসুং ইন ডেন কস্টেন এন্টহালটেন",
             [{"t": "Sind", "bn": "হয় কি"}, {"t": "Strom", "bn": "বিদ্যুৎ"}, {"t": "und", "bn": "এবং"}, {"t": "Heizung", "bn": "হিটিং"}, {"t": "in", "bn": "এ"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Kosten", "bn": "খরচগুলো"}, {"t": "enthalten?", "bn": "অন্তর্ভুক্ত"}]),
            ("Die Kaution beträgt drei Monatsmieten.", "সিকিউরিটি ডিপোজিট হলো তিন মাসের মূল ভাড়া।", "ডি কাউৎসিয়ন বেট্রেকূট ড্রাই মোনাটস্মীটেন",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Kaution", "bn": "ডিপোজিট"}, {"t": "beträgt", "bn": "পরিমাণ হয়"}, {"t": "drei", "bn": "তিন"}, {"t": "Monatsmieten.", "bn": "মাসের ভাড়া"}]),
            ("Sie bekommen die Kaution beim Auszug zurück.", "বাসা ছাড়ার সময় আপনি ডিপোজিটের টাকা ফেরত পাবেন।", "যী বেকমেন ডি কাউৎসিয়ন বাইম আউসৎসুক ৎসুর্যুক",
             [{"t": "Sie", "bn": "আপনি"}, {"t": "bekommen", "bn": "পাবেন"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Kaution", "bn": "ডিপোজিট"}, {"t": "beim", "bn": "সময়"}, {"t": "Auszug", "bn": "বাসা ছাড়া"}, {"t": "zurück.", "bn": "ফেরত"}]),
            ("Der Mietvertrag wird morgen unterschrieben.", "ভাড়া চুক্তিটি আগামীকাল স্বাক্ষরিত হবে।", "ডের মীটফেয়ার্ট্রাক ভির্ট মর্গেন উন্টারশ্রীবেন",
             [{"t": "Der", "bn": "নির্দিষ্ট"}, {"t": "Mietvertrag", "bn": "ভাড়া চুক্তি"}, {"t": "wird", "bn": "হবে"}, {"t": "morgen", "bn": "কাল"}, {"t": "unterschrieben.", "bn": "স্বাক্ষরিত"}]),
        ]
    },
    {
        "title_bn": "ফ্ল্যাট দেখার অ্যাপয়েন্টমেন্ট (Besichtigungstermin)",
        "title_target": "Besichtigungstermin und Wohnungsdetails",
        "intro_bn": "ফ্ল্যাট সরাসরি দেখতে যাওয়া (Besichtigung), লিফট, রান্নাঘর ও আশপাশের পরিবেশ নিয়ে কথা বলার বাক্য।",
        "structure": ["Termin", "Ausstattung", "Hausregeln"],
        "items": [
            ("Können wir einen Besichtigungstermin vereinbaren?", "আমরা কি ফ্ল্যাট দেখার একটি অ্যাপয়েন্টমেন্ট ঠিক করতে পারি?", "কোয়ন্নেন ভির আইনেন বেজিশটিগুংসটের্মিন ফেয়ারআইনবারেন",
             [{"t": "Können", "bn": "পারি কি"}, {"t": "wir", "bn": "আমরা"}, {"t": "einen", "bn": "একটি"}, {"t": "Besichtigungstermin", "bn": "পরিদর্শন অ্যাপয়েন্টমেন্ট"}, {"t": "vereinbaren?", "bn": "ঠিক করতে"}]),
            ("Passt es Ihnen am kommenden Samstag?", "আগামী শনিবার কি আপনার জন্য সুবিধাজনক?", "পাস্ট এস ইনেন আম কমেনডেন জাম্স্টাক",
             [{"t": "Passt", "bn": "উপযুক্ত হয় কি"}, {"t": "es", "bn": "এটি"}, {"t": "Ihnen", "bn": "আপনার"}, {"t": "am", "bn": "এ"}, {"t": "kommenden", "bn": "আসন্ন"}, {"t": "Samstag?", "bn": "শনিবার"}]),
            ("Die Wohnung ist hell und liegt im dritten Stock.", "ফ্ল্যাটটি আলোঝলমলে এবং চার তলায় অবস্থিত।", "ডি ভোনুং ইস্ত হেল উন্ট লীখ্ট ইম ড্রিটেন শ্টক",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Wohnung", "bn": "ফ্ল্যাট"}, {"t": "ist", "bn": "হয়"}, {"t": "hell", "bn": "উজ্জ্বল"}, {"t": "und", "bn": "এবং"}, {"t": "liegt", "bn": "অবস্থিত"}, {"t": "im", "bn": "এ"}, {"t": "dritten", "bn": "তৃতীয়"}, {"t": "Stock.", "bn": "তলা"}]),
            ("Gibt es einen Aufzug im Gebäude?", "ভবনটিতে কি কোনো লিফট আছে?", "গিব্ট এস আইনেন আউফৎসুক ইম গেবয়ডে",
             [{"t": "Gibt", "bn": "আছে"}, {"t": "es", "bn": "কি"}, {"t": "einen", "bn": "একটি"}, {"t": "Aufzug", "bn": "লিফট"}, {"t": "im", "bn": "এ"}, {"t": "Gebäude?", "bn": "ভবন"}]),
            ("Die Küche ist bereits komplett eingerichtet.", "রান্নাঘরটি ইতোমধ্যে সম্পূর্ণ সুসজ্জিত।", "ডি ক্যুশে ইস্ত বেরাইটস কমপ্লিট আইনগেরিশটেট",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Küche", "bn": "রান্নাঘর"}, {"t": "ist", "bn": "হয়"}, {"t": "bereits", "bn": "ইতোমধ্যে"}, {"t": "komplett", "bn": "সম্পূর্ণ"}, {"t": "eingerichtet.", "bn": "সুসজ্জিত"}]),
            ("Haustiere sind hier leider nicht erlaubt.", "এখানে পোষা প্রাণী রাখা দুর্ভাগ্যবশত অনুমোদিত নয়।", "হাউসতীয়রে জিন্ট হিয়ার লাইডার নিখ্ট এয়ারলাউবট",
             [{"t": "Haustiere", "bn": "পোষা প্রাণী"}, {"t": "sind", "bn": "হয়"}, {"t": "hier", "bn": "এখানে"}, {"t": "leider", "bn": "দুর্ভাগ্যবশত"}, {"t": "nicht", "bn": "না"}, {"t": "erlaubt.", "bn": "অনুমোদিত"}]),
            ("Die Nachbarn im Haus sind sehr freundlich.", "বাড়ির প্রতিবেশীরা অত্যন্ত বন্ধুত্বপূর্ণ।", "ডি নাখবার্ন ইম হাউস জিন্ট জেয়ার ফ্রয়নডলিখ",
             [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Nachbarn", "bn": "প্রতিবেশীরা"}, {"t": "im", "bn": "এ"}, {"t": "Haus", "bn": "বাড়ি"}, {"t": "sind", "bn": "হয়"}, {"t": "sehr", "bn": "খুব"}, {"t": "freundlich.", "bn": "বন্ধুত্বপূর্ণ"}]),
            ("Ich möchte die Wohnung gerne mieten.", "আমি আনন্দের সাথে ফ্ল্যাটটি ভাড়া নিতে চাই।", "ইখ্ মোয়খটে ডি ভোনুং গের্নে মীটেন",
             [{"t": "Ich", "bn": "আমি"}, {"t": "möchte", "bn": "চাই"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Wohnung", "bn": "ফ্ল্যাট"}, {"t": "gerne", "bn": "সানন্দে"}, {"t": "mieten.", "bn": "ভাড়া নিতে"}]),
        ]
    },
    {
        "title_bn": "কথোপকথন: ডব্লিউজি ফ্ল্যাটে রুমমেটদের সাথে সাক্ষাৎকার",
        "title_target": "Gespräch: Das WG-Casting",
        "intro_bn": "জার্মানিতে বহুল প্রচলিত ডব্লিউজি কাস্টিং (WG-Casting): ফ্ল্যাটমেটদের সাথে সাক্ষাৎকার ও জীবনযাপন নিয়ে আলোচনা।",
        "structure": ["Mitbewohner", "Bewerber", "WG-Alltag & Putzplan"],
        "items": [
            ("Hallo, herzlich willkommen in unserer Dreier-WG!", "হ্যালো, আমাদের তিনজনের শেয়ার্ড ফ্ল্যাটে তোমাকে আন্তরিক স্বাগতম!", "হালো হেয়ারৎসলিখ ভিলকমেন ইন উনজেরার ড্রায়ার ভেগে",
             [{"t": "Hallo,", "bn": "হ্যালো"}, {"t": "herzlich", "bn": "আন্তরিক"}, {"t": "willkommen", "bn": "স্বাগতম"}, {"t": "in", "bn": "এ"}, {"t": "unserer", "bn": "আমাদের"}, {"t": "Dreier-WG!", "bn": "তিনজনের ফ্ল্যাটশেয়ার"}],
             None, "A", "dialogue_line"),
            ("Hallo, vielen Dank für die Einladung zur Besichtigung.", "হ্যালো, ফ্ল্যাট পরিদর্শনে আমন্ত্রণ জানানোর জন্য অনেক ধন্যবাদ।", "হালো ফীলেন ডাঙ্ক ফ্যুর ডি আইনলাডুং ৎসুর বেজিশটিগুং",
             [{"t": "Hallo,", "bn": "হ্যালো"}, {"t": "vielen", "bn": "অনেক"}, {"t": "Dank", "bn": "ধন্যবাদ"}, {"t": "für", "bn": "জন্য"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Einladung", "bn": "আমন্ত্রণ"}, {"t": "zur", "bn": "এ"}, {"t": "Besichtigung.", "bn": "পরিদর্শন"}],
             None, "B", "dialogue_line"),
            ("Erzähl mal, was machst du so beruflich oder im Studium?", "একটু বলো, তুমি পেশাগতভাবে বা পড়াশোনায় কী করছ?", "এয়ারৎসেল মাল ভাস মাখ্স্ট দু জো বেরুফলিখ ওডার ইম শ্টুডিয়াম",
             [{"t": "Erzähl", "bn": "বলো"}, {"t": "mal,", "bn": "একটু"}, {"t": "was", "bn": "কী"}, {"t": "machst", "bn": "করছ"}, {"t": "du", "bn": "তুমি"}, {"t": "so", "bn": "এমন"}, {"t": "beruflich", "bn": "পেশাগতভাবে"}, {"t": "oder", "bn": "নাকি"}, {"t": "im", "bn": "এ"}, {"t": "Studium?", "bn": "পড়াশোনা"}],
             None, "A", "dialogue_line"),
            ("Ich studiere Informatik im zweiten Semester an der Universität.", "আমি বিশ্ববিদ্যালয়ে কম্পিউটার সায়েন্সে দ্বিতীয় সেমিস্টারে পড়ছি।", "ইখ্ শ্টুডীয়ারে ইনফোরমাটিক ইম ৎস্ভাইটেন জেমেস্টার আন ডের ইউনিভের্জিটেট",
             [{"t": "Ich", "bn": "আমি"}, {"t": "studiere", "bn": "পড়ছি"}, {"t": "Informatik", "bn": "কম্পিউটার সায়েন্স"}, {"t": "im", "bn": "এ"}, {"t": "zweiten", "bn": "দ্বিতীয়"}, {"t": "Semester", "bn": "সেমিস্টার"}, {"t": "an", "bn": "এ"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Universität.", "bn": "বিশ্ববিদ্যালয়"}],
             None, "B", "dialogue_line"),
            ("Wie sieht es bei dir mit Kochen und Putzen aus?", "রান্নাবান্না ও পরিষ্কার-পরিচ্ছন্নতার ক্ষেত্রে তোমার অভ্যাস কেমন?", "ভী জীত এস বাই ডিয়ার মিট কখেন উন্ট পুৎসেন আউস",
             [{"t": "Wie", "bn": "কেমন"}, {"t": "sieht", "bn": "দেখা যায়"}, {"t": "es", "bn": "এটি"}, {"t": "bei", "bn": "কাছে"}, {"t": "dir", "bn": "তোমার"}, {"t": "mit", "bn": "নিয়ে"}, {"t": "Kochen", "bn": "রান্না"}, {"t": "und", "bn": "এবং"}, {"t": "Putzen", "bn": "পরিষ্কার"}, {"t": "aus?", "bn": "অবস্থা"}],
             None, "A", "dialogue_line"),
            ("Ich koche gerne am Wochenende und halte immer Ordnung.", "আমি উইকএন্ডে রান্না করতে ভালোবাসি এবং সবসময় সবকিছু পরিপাটি রাখি।", "ইখ্ কখে গের্নে আম ভখেনএন্ডে উন্ট হাল্টে ইমার অর্ডনুং",
             [{"t": "Ich", "bn": "আমি"}, {"t": "koche", "bn": "রান্না করি"}, {"t": "gerne", "bn": "সানন্দে"}, {"t": "am", "bn": "এ"}, {"t": "Wochenende", "bn": "উইকএন্ড"}, {"t": "und", "bn": "এবং"}, {"t": "halte", "bn": "রাখি"}, {"t": "immer", "bn": "সবসময়"}, {"t": "Ordnung.", "bn": "শৃঙ্খলা"}],
             None, "B", "dialogue_line"),
            ("Das klingt super, wir haben nämlich einen festen Putzplan.", "এটা দারুণ শোনাচ্ছে, আমাদের আসলে একটি নির্দিষ্ট পরিষ্কারের রুটিন আছে।", "ডাস ক্লিঙ্কট সুপার ভির হাবন নেমলিখ আইনেন ফিস্টেন পুৎসপ্লান",
             [{"t": "Das", "bn": "এটা"}, {"t": "klingt", "bn": "শোনাচ্ছে"}, {"t": "super,", "bn": "দারুণ"}, {"t": "wir", "bn": "আমাদের"}, {"t": "haben", "bn": "আছে"}, {"t": "nämlich", "bn": "আসলে"}, {"t": "einen", "bn": "একটি"}, {"t": "festen", "bn": "নির্দিষ্ট"}, {"t": "Putzplan.", "bn": "ক্লিনিং রুটিন"}],
             None, "A", "dialogue_line"),
            ("Perfekt, ein Putzplan ist mir auch sehr wichtig.", "পারফেক্ট, পরিষ্কারের রুটিন আমার কাছেও খুব গুরুত্বপূর্ণ।", "পেয়ারফেক্ট আইন পুৎসপ্লান ইস্ত মিয়ার আউখ জেয়ার ভিখটিখ",
             [{"t": "Perfekt,", "bn": "পারফেক্ট"}, {"t": "ein", "bn": "একটি"}, {"t": "Putzplan", "bn": "ক্লিনিং রুটিন"}, {"t": "ist", "bn": "হয়"}, {"t": "mir", "bn": "আমার"}, {"t": "auch", "bn": "ও"}, {"t": "sehr", "bn": "খুব"}, {"t": "wichtig.", "bn": "গুরুত্বপূর্ণ"}],
             None, "B", "dialogue_line"),
        ]
    }
]
parts_p1.append(("de-a2-07", "বাসা খোঁজা ও ডব্লিউজি ফ্ল্যাটশেয়ার", "Wohnungssuche & WG-Leben", p7_lessons))

# =========================================================================
# Unit de-a2-08: প্রতিবর্ত ক্রিয়া বা আত্মবাচক ক্রিয়া (Reflexive Verben)
# =========================================================================
p8_lessons = [
    {
        "title_bn": "নিজের যত্ন ও দৈনিক অভ্যাস (sich anziehen, sich waschen)",
        "title_target": "Körperpflege und Alltagsroutine: Reflexivpronomen",
        "intro_bn": "প্রতিবর্ত ক্রিয়া বা রিফ্লেক্সিভ ভার্বে কর্তা ও কর্ম একই ব্যক্তি: sich waschen (ধোয়া), sich anziehen (পোশাক পরা), sich kämmen (চুল আঁচড়ানো), sich beeilen (তাড়াহুড়ো করা)।",
        "structure": ["Subjekt", "Verb", "Reflexivpronomen (mich / dich / sich)", "Objekt"],
        "items": [
            ("Ich ziehe mich jeden Morgen schnell an.", "আমি প্রতি সকালে দ্রুত জামাকাপড় পরি।", "ইখ্ ৎসীয়ে নিখ্ ইয়েডেন মর্গেন শ্নেল আন",
             [{"t": "Ich", "bn": "আমি"}, {"t": "ziehe", "bn": "পরি"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "jeden", "bn": "প্রতি"}, {"t": "Morgen", "bn": "সকাল"}, {"t": "schnell", "bn": "দ্রুত"}, {"t": "an.", "bn": "পোশাক"}]),
            ("Zieh dich bitte warm an, es ist kalt draußen.", "দয়া করে গরম জামাকাপড় পরো, বাইরে ঠান্ডা।", "ৎসীয় ডিখ বিটে ভার্ম আন এস ইস্ত কাল্ট ড্রাউসেন",
             [{"t": "Zieh", "bn": "পরো"}, {"t": "dich", "bn": "তোমাকে"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "warm", "bn": "উষ্ণ"}, {"t": "an,", "bn": "পোশাক"}, {"t": "es", "bn": "এটি"}, {"t": "ist", "bn": "হয়"}, {"t": "kalt", "bn": "ঠান্ডা"}, {"t": "draußen.", "bn": "বাইরে"}]),
            ("Er wäscht sich vor dem Frühstück das Gesicht.", "সে নাস্তার আগে মুখ ধুয়ে নেয়।", "এয়ার ভেশ্ট জিখ ফোর ডেম ফ্র্যূশ্ট্যক ডাস গেজিশ্ট",
             [{"t": "Er", "bn": "সে"}, {"t": "wäscht", "bn": "ধোয়"}, {"t": "sich", "bn": "নিজের"}, {"t": "vor", "bn": "পূর্বে"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Frühstück", "bn": "নাস্তা"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Gesicht.", "bn": "মুখ"}]),
            ("Wir müssen uns beeilen, der Bus kommt gleich.", "আমাদের তাড়াহুড়ো করতে হবে, বাস এখনই চলে আসবে।", "ভির ম্যূসেন উন্স বেআইলেন ডের বুস কমট গ্লাইখ",
             [{"t": "Wir", "bn": "আমাদের"}, {"t": "müssen", "bn": "হবে"}, {"t": "uns", "bn": "নিজেদের"}, {"t": "beeilen,", "bn": "তাড়াহুড়ো করা"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Bus", "bn": "বাস"}, {"t": "kommt", "bn": "আসছে"}, {"t": "gleich.", "bn": "এখনই"}]),
            ("Sie kämmt sich vor dem Spiegel die Haare.", "সে আয়নার সামনে চুল আঁচড়াচ্ছে।", "যী কেম্ট জিখ ফোর ডেম শ্পীগেল ডি হারে",
             [{"t": "Sie", "bn": "সে"}, {"t": "kämmt", "bn": "আঁচড়াচ্ছে"}, {"t": "sich", "bn": "নিজের"}, {"t": "vor", "bn": "সামনে"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Spiegel", "bn": "আয়না"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Haare.", "bn": "চুল"}]),
            ("Setzen Sie sich bitte auf diesen bequemen Stuhl.", "দয়া করে এই আরামদায়ক চেয়ারে বসুন।", "জেৎসেন যী জিখ বিটে আউফ ডীজেন বেকভেমেন শ্টূল",
             [{"t": "Setzen", "bn": "বসুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "sich", "bn": "নিজেকে"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "auf", "bn": "উপর"}, {"t": "diesen", "bn": "এই"}, {"t": "bequemen", "bn": "আরামদায়ক"}, {"t": "Stuhl.", "bn": "চেয়ার"}]),
            ("Ich dusche mich jeden Abend vor dem Schlafen.", "আমি প্রতি সন্ধ্যায় ঘুমানোর আগে গোসল করি।", "ইখ্ ডুশে নিখ্ ইয়েডেন আবেন্ট ফোর ডেম শ্লাফেন",
             [{"t": "Ich", "bn": "আমি"}, {"t": "dusche", "bn": "গোসল করি"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "jeden", "bn": "প্রতি"}, {"t": "Abend", "bn": "সন্ধ্যা"}, {"t": "vor", "bn": "পূর্বে"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Schlafen.", "bn": "ঘুমানো"}]),
            ("Putz dir bitte vor dem Schlafengehen die Zähne.", "ঘুমাতে যাওয়ার আগে দয়া করে দাঁত ব্রাশ করে নাও।", "পুৎস ডিয়ার বিটে ফোর ডেম শ্লাফেনগেহেন ডি ৎসেনে",
             [{"t": "Putz", "bn": "ব্রাশ করো"}, {"t": "dir", "bn": "তোমার"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "vor", "bn": "পূর্বে"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Schlafengehen", "bn": "ঘুমাতে যাওয়া"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Zähne.", "bn": "দাঁত"}]),
        ]
    },
    {
        "title_bn": "অনুভূতি ও আগ্রহ (sich freuen auf/über, sich interessieren für)",
        "title_target": "Gefühle und Interessen mit Präpositionen",
        "intro_bn": "নির্দিষ্ট অব্যয়যুক্ত প্রতিবর্ত ক্রিয়া: sich freuen auf (ভবিষ্যতের কিছুর জন্য আনন্দিত হওয়া), sich freuen über (বর্তমান প্রাপ্তির জন্য আনন্দিত হওয়া), sich interessieren für (কোনো বিষয়ে আগ্রহী হওয়া)।",
        "structure": ["Subjekt", "Verb + Reflexivpronomen", "Präposition", "Nomen"],
        "items": [
            ("Ich freue mich sehr auf das Wochenende.", "আমি ছুটির দিনের জন্য খুব আগ্রহ নিয়ে অপেক্ষা করছি।", "ইখ্ ফ্রয়ে নিখ্ জেয়ার আউফ ডাস ভখেনএন্ডে",
             [{"t": "Ich", "bn": "আমি"}, {"t": "freue", "bn": "আনন্দিত হচ্ছি"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "sehr", "bn": "খুব"}, {"t": "auf", "bn": "জন্য"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Wochenende.", "bn": "উইকএন্ড"}]),
            ("Wir freuen uns über das schöne Geschenk.", "আমরা সুন্দর উপহারটি পেয়ে আনন্দিত।", "ভির ফ্রয়েন উন্স উবার ডাস শোয়নে গেশেঙ্ক",
             [{"t": "Wir", "bn": "আমরা"}, {"t": "freuen", "bn": "আনন্দিত হচ্ছি"}, {"t": "uns", "bn": "নিজেদের"}, {"t": "über", "bn": "পেয়ে"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "schöne", "bn": "সুন্দর"}, {"t": "Geschenk.", "bn": "উপহার"}]),
            ("Interessierst du dich für moderne Kunst?", "তুমি কি আধুনিক শিল্পকলার ব্যাপারে আগ্রহী?", "ইন্টারেসীয়ার্স্ট দু ডিখ ফ্যুর মোডের্নে কুন্স্ট",
             [{"t": "Interessierst", "bn": "আগ্রহী কি"}, {"t": "du", "bn": "তুমি"}, {"t": "dich", "bn": "নিজেকে"}, {"t": "für", "bn": "জন্য"}, {"t": "moderne", "bn": "আধুনিক"}, {"t": "Kunst?", "bn": "শিল্পকলা"}]),
            ("Er interessiert sich sehr für deutsche Kultur.", "সে জার্মান সংস্কৃতির ব্যাপারে খুব আগ্রহী।", "এয়ার ইন্টারেসীয়ার্ট জিখ জেয়ার ফ্যুর ডয়চে কুলতুর",
             [{"t": "Er", "bn": "সে"}, {"t": "interessiert", "bn": "আগ্রহী হয়"}, {"t": "sich", "bn": "নিজেকে"}, {"t": "sehr", "bn": "খুব"}, {"t": "für", "bn": "জন্য"}, {"t": "deutsche", "bn": "জার্মান"}, {"t": "Kultur.", "bn": "সংস্কৃতি"}]),
            ("Ärgerst du dich über die Verspätung des Zuges?", "ট্রেনের দেরির কারণে কি তোমার রাগ হচ্ছে?", "এয়ারগার্স্ট দু ডিখ উবার ডি ফেয়ার্শ্পেটুং ডেস ৎসুগেস",
             [{"t": "Ärgerst", "bn": "রাগ করছ কি"}, {"t": "du", "bn": "তুমি"}, {"t": "dich", "bn": "নিজেকে"}, {"t": "über", "bn": "নিয়ে"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Verspätung", "bn": "বিলম্ব"}, {"t": "des", "bn": "এর"}, {"t": "Zuges?", "bn": "ট্রেন"}]),
            ("Ich erinnere mich gerne an unsere Reise.", "আমি সানন্দে আমাদের ভ্রমণের কথা মনে করি।", "ইখ্ এয়ারইনেরে নিখ্ গের্নে আন উনজেরে রাইজে",
             [{"t": "Ich", "bn": "আমি"}, {"t": "erinnere", "bn": "স্মরণ করি"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "gerne", "bn": "সানন্দে"}, {"t": "an", "bn": "কথা"}, {"t": "unsere", "bn": "আমাদের"}, {"t": "Reise.", "bn": "ভ্রমণ"}]),
            ("Sie bedankt sich für die herzliche Gastfreundschaft.", "তিনি আন্তরিক আতিথেয়তার জন্য ধন্যবাদ জানাচ্ছেন।", "যী বেডাঙ্কট জিখ ফ্যুর ডি হেয়ারৎসলিখো গাস্টফ্রয়নডশাফট",
             [{"t": "Sie", "bn": "তিনি"}, {"t": "bedankt", "bn": "ধন্যবাদ জানাচ্ছেন"}, {"t": "sich", "bn": "নিজেকে"}, {"t": "für", "bn": "জন্য"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "herzliche", "bn": "আন্তরিক"}, {"t": "Gastfreundschaft.", "bn": "আতিথেয়তা"}]),
            ("Wir langweilen uns hier überhaupt nicht.", "আমাদের এখানে একেবারেই বিরক্ত লাগছে না।", "ভির লাঙভাইলেন উন্স হিয়ার উবারহাউপ্ট নিখ্ট",
             [{"t": "Wir", "bn": "আমরা"}, {"t": "langweilen", "bn": "বিরক্ত হচ্ছি"}, {"t": "uns", "bn": "নিজেদের"}, {"t": "hier", "bn": "এখানে"}, {"t": "überhaupt", "bn": "একেবারেই"}, {"t": "nicht.", "bn": "না"}]),
        ]
    },
    {
        "title_bn": "শারীরিক অবস্থা (sich fühlen, sich erkälten)",
        "title_target": "Befinden und Zustand: sich fühlen und sich erholen",
        "intro_bn": "শারীরিক অনুভূতি ও স্বাস্থ্যের অবস্থা নির্দেশক প্রতিবর্ত ক্রিয়া: sich fühlen (অনুভব করা), sich erkälten (ঠান্ডা লাগা), sich erholen (সুস্থ হওয়া বা বিশ্রাম নেওয়া)।",
        "structure": ["Subjekt", "Reflexivverb", "Befindlichkeit"],
        "items": [
            ("Wie fühlen Sie sich heute?", "আজ আপনার কেমন লাগছে?", "ভী ফ্যুলেন যী জিখ হয়টে",
             [{"t": "Wie", "bn": "কেমন"}, {"t": "fühlen", "bn": "অনুভব করছেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "sich", "bn": "নিজেকে"}, {"t": "heute?", "bn": "আজ"}]),
            ("Ich fühle mich heute schon viel besser.", "আজ আমার আগের চেয়ে অনেক ভালো লাগছে।", "ইখ্ ফ্যুলে নিখ্ হয়টে শোন ফীল বেসার",
             [{"t": "Ich", "bn": "আমি"}, {"t": "fühle", "bn": "অনুভব করছি"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "heute", "bn": "আজ"}, {"t": "schon", "bn": "ইতোমধ্যে"}, {"t": "viel", "bn": "অনেক"}, {"t": "besser.", "bn": "ভালো"}]),
            ("Zieh eine Jacke an, sonst erkältest du dich.", "জ্যাকেট পরে নাও, তা না হলে তোমার ঠান্ডা লেগে যাবে।", "ৎসীয় আইনে ইয়াকে আন জন্স্ট এয়ারকেল্টেস্ট দু ডিখ",
             [{"t": "Zieh", "bn": "পরো"}, {"t": "eine", "bn": "একটি"}, {"t": "Jacke", "bn": "জ্যাকেট"}, {"t": "an,", "bn": "পোশাক"}, {"t": "sonst", "bn": "নইলে"}, {"t": "erkältest", "bn": "ঠান্ডা লাগবে"}, {"t": "du", "bn": "তোমার"}, {"t": "dich.", "bn": "নিজেকে"}]),
            ("Er hat sich beim Sport am Knie verletzt.", "খেলাধুলার সময় তার হাঁটুতে আঘাত লেগেছে।", "এয়ার হাট জিখ বাইম শ্পোর্ট আম ক্নী ফেয়ার্লেৎস্ট",
             [{"t": "Er", "bn": "সে"}, {"t": "hat", "bn": "আছে"}, {"t": "sich", "bn": "নিজেকে"}, {"t": "beim", "bn": "সময়"}, {"t": "Sport", "bn": "খেলাধুলা"}, {"t": "am", "bn": "এ"}, {"t": "Knie", "bn": "হাঁটু"}, {"t": "verletzt.", "bn": "আঘাতপ্রাপ্ত"}]),
            ("Ich muss mich für eine halbe Stunde hinlegen.", "আমার আধঘণ্টার জন্য একটু শুয়ে বিশ্রাম নেওয়া দরকার।", "ইখ্ মুস নিখ্ ফ্যুর আইনে হাল্বে শ্টুন্ডে হিনলেগেন",
             [{"t": "Ich", "bn": "আমার"}, {"t": "muss", "bn": "হবে"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "für", "bn": "জন্য"}, {"t": "eine", "bn": "এক"}, {"t": "halbe", "bn": "অর্ধ"}, {"t": "Stunde", "bn": "ঘণ্টা"}, {"t": "hinlegen.", "bn": "শুয়ে বিশ্রাম নেওয়া"}]),
            ("Erhol dich gut am freien Wochenende!", "ছুটির দিনে ভালোমতো বিশ্রাম নাও ও নিজেকে সতেজ করো!", "এয়ারহোল ডিখ গুট আম ফ্রাইইয়েন ভখেনএন্ডে",
             [{"t": "Erhol", "bn": "সতেজ করো"}, {"t": "dich", "bn": "নিজেকে"}, {"t": "gut", "bn": "ভালো"}, {"t": "am", "bn": "এ"}, {"t": "freien", "bn": "ছুটির"}, {"t": "Wochenende!", "bn": "উইকএন্ড"}]),
            ("Fühlst du dich fit für den Ausflug?", "ভ্রমণে যাওয়ার জন্য কি তুমি নিজেকে সুস্থ অনুভব করছো?", "ফ্যুল্স্ট দু ডিখ ফিট ফ্যুর ডেন আউসফ্লুক",
             [{"t": "Fühlst", "bn": "অনুভব করছ কি"}, {"t": "du", "bn": "তুমি"}, {"t": "dich", "bn": "নিজেকে"}, {"t": "fit", "bn": "সুস্থ"}, {"t": "für", "bn": "জন্য"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Ausflug?", "bn": "ভ্রমণ"}]),
            ("Sie entspannt sich abends gerne mit Musik.", "তিনি সন্ধ্যায় সঙ্গীত শুনে মনের প্রশান্তি উপভোগ করেন।", "যী এন্টশ্পান্ট জিখ আবেন্টস্ গের্নে মিট মুজীক",
             [{"t": "Sie", "bn": "তিনি"}, {"t": "entspannt", "bn": "প্রশান্তি উপভোগ করেন"}, {"t": "sich", "bn": "নিজেকে"}, {"t": "abends", "bn": "সন্ধ্যায়"}, {"t": "gerne", "bn": "সানন্দে"}, {"t": "mit", "bn": "দিয়ে"}, {"t": "Musik.", "bn": "সঙ্গীত"}]),
        ]
    },
    {
        "title_bn": "কথোপকথন: উইকএন্ডের প্রস্তুতি ও শখ",
        "title_target": "Gespräch: Wochenendpläne und Hobbys",
        "intro_bn": "উইকএন্ডের পরিকল্পনা, প্রকৃতিতে হাইকিং ও অবসর যাপন নিয়ে প্রতিবর্ত ক্রিয়ায় দুই বন্ধুর স্পোকেন কথোপকথন।",
        "structure": ["Wochenende", "Hobbys", "Reflexivverben im Dialog"],
        "items": [
            ("Freust du dich auch so sehr auf das Wochenende?", "তুমিও কি ছুটির দিনের জন্য এমন অধীর অপেক্ষায় আছো?", "ফ্রয়্স্ট দু ডিখ আউখ জো জেয়ার আউফ ডাস ভখেনএন্ডে",
             [{"t": "Freust", "bn": "আনন্দিত কি"}, {"t": "du", "bn": "তুমি"}, {"t": "dich", "bn": "নিজেকে"}, {"t": "auch", "bn": "ও"}, {"t": "so", "bn": "এত"}, {"t": "sehr", "bn": "বেশি"}, {"t": "auf", "bn": "জন্য"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Wochenende?", "bn": "উইকএন্ড"}],
             None, "A", "dialogue_line"),
            ("Ja total, ich muss mich nach der harten Arbeitswoche ausruhen.", "হ্যাঁ একেবারেই, কঠিন কর্মসপ্তাহের পর আমার বিশ্রাম নেওয়া দরকার।", "ইয়া টোটাল ইখ্ মুস নিখ্ নাখ ডের হার্টেন আরবাইটসভখে আউসরুহেন",
             [{"t": "Ja", "bn": "হ্যাঁ"}, {"t": "total,", "bn": "একেবারেই"}, {"t": "ich", "bn": "আমার"}, {"t": "muss", "bn": "হবে"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "nach", "bn": "পর"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "harten", "bn": "কঠিন"}, {"t": "Arbeitswoche", "bn": "কাজের সপ্তাহ"}, {"t": "ausruhen.", "bn": "বিশ্রাম নেওয়া"}],
             None, "B", "dialogue_line"),
            ("Worauf freust du dich am meisten?", "কোন বিষয়ের জন্য তুমি সবচেয়ে বেশি আগ্রহী?", "ভোরাউফ ফ্রয়্স্ট দু ডিখ আম মাইস্টেন",
             [{"t": "Worauf", "bn": "কিসের জন্য"}, {"t": "freust", "bn": "আনন্দিত"}, {"t": "du", "bn": "তুমি"}, {"t": "dich", "bn": "নিজেকে"}, {"t": "am", "bn": "সবচেয়ে"}, {"t": "meisten?", "bn": "বেশি"}],
             None, "A", "dialogue_line"),
            ("Ich treffe mich am Samstag mit alten Schulfreunden.", "আমি শনিবার স্কুলের পুরনো বন্ধুদের সাথে দেখা করব।", "ইখ্ ট্রেফে নিখ্ আম জাম্স্টাক মিট আল্টেন শূলফ্রয়নডেন",
             [{"t": "Ich", "bn": "আমি"}, {"t": "treffe", "bn": "দেখা করব"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "am", "bn": "এ"}, {"t": "Samstag", "bn": "শনিবার"}, {"t": "mit", "bn": "সাথে"}, {"t": "alten", "bn": "পুরনো"}, {"t": "Schulfreunden.", "bn": "স্কুল বন্ধুরা"}],
             None, "B", "dialogue_line"),
            ("Schön, geht ihr zusammen wandern oder ins Café?", "সুন্দর, তোমরা কি একসাথে হাঁটাহাঁটি করতে যাবে নাকি ক্যাফেতে?", "শোয়ন গেহ্ট ইয়ার ৎসুসামেন ভান্ডার্ন ওডার ইনস কাফে",
             [{"t": "Schön,", "bn": "সুন্দর"}, {"t": "geht", "bn": "যাচ্ছ"}, {"t": "ihr", "bn": "তোমরা"}, {"t": "zusammen", "bn": "একসাথে"}, {"t": "wandern", "bn": "হাঁটাহাঁটি"}, {"t": "oder", "bn": "নাকি"}, {"t": "ins", "bn": "এ"}, {"t": "Café?", "bn": "ক্যাফে"}],
             None, "A", "dialogue_line"),
            ("Wir interessieren uns für Natur und wollen im Wald wandern.", "আমরা প্রকৃতি পছন্দ করি এবং বনে হাইকিং করতে চাই।", "ভির ইন্টারেসীয়ারেন উন্স ফ্যুর নাটুর উন্ট ভলেন ইম ভাল্ট ভান্ডার্ন",
             [{"t": "Wir", "bn": "আমরা"}, {"t": "interessieren", "bn": "আগ্রহী হচ্ছি"}, {"t": "uns", "bn": "নিজেদের"}, {"t": "für", "bn": "জন্য"}, {"t": "Natur", "bn": "প্রকৃতি"}, {"t": "und", "bn": "এবং"}, {"t": "wollen", "bn": "চাই"}, {"t": "im", "bn": "এ"}, {"t": "Wald", "bn": "বন"}, {"t": "wandern.", "bn": "হাইকিং করতে"}],
             None, "B", "dialogue_line"),
            ("Vergiss nicht, dich warm anzuziehen, es wird windig.", "গরম জামাকাপড় পরতে ভুলে যেও না, বাতাস বইবে।", "ফেয়ার্গিস নিখ্ট ডিখ ভার্ম আনৎসুৎসীয়েন এস ভির্ট ভিন্ডিখ",
             [{"t": "Vergiss", "bn": "ভুলে যেও"}, {"t": "nicht,", "bn": "না"}, {"t": "dich", "bn": "তোমাকে"}, {"t": "warm", "bn": "গরম"}, {"t": "anzuziehen,", "bn": "পোশাক পরতে"}, {"t": "es", "bn": "এটি"}, {"t": "wird", "bn": "হবে"}, {"t": "windig.", "bn": "বাতাসযুক্ত"}],
             None, "A", "dialogue_line"),
            ("Keine Sorge, ich bereite mich gut auf den Ausflug vor.", "চিন্তা করো না, আমি ভ্রমণের জন্য ভালো প্রস্তুতি নিচ্ছি।", "কাইনে জর্গে ইখ্ বেরাইটে নিখ্ গুট আউফ ডেন আউসফ্লুক ফোর",
             [{"t": "Keine", "bn": "কোনো না"}, {"t": "Sorge,", "bn": "চিন্তা"}, {"t": "ich", "bn": "আমি"}, {"t": "bereite", "bn": "প্রস্তুত করছি"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "gut", "bn": "ভালোভাবে"}, {"t": "auf", "bn": "জন্য"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Ausflug", "bn": "ভ্রমণ"}, {"t": "vor.", "bn": "প্রস্তুতি"}],
             None, "B", "dialogue_line"),
        ]
    }
]
parts_p1.append(("de-a2-08", "প্রতিবর্ত ক্রিয়া বা আত্মবাচক ক্রিয়া", "Reflexive Verben: Sich-Verben", p8_lessons))

print(f"German A2 Part 1 loaded with {len(parts_p1)} parts and {sum(len(p[3]) for p in parts_p1)} lessons.")
