"""Generates Stage 0 (Units s0-01 to s0-10) for German Spoken Course."""
import json
from pathlib import Path

UNITS_DIR = Path(__file__).resolve().parent.parent / "units"
UNITS_DIR.mkdir(parents=True, exist_ok=True)

def w(target, bn, pron, gender=None, tokens=None):
    if tokens is None:
        tokens = [{"t": target, "bn": bn}]
    res = {"type": "word", "target": target, "bn": bn, "bn_pron": pron, "tokens": tokens}
    if gender:
        res["gender"] = gender
    return res

def phr(target, bn, pron, tokens):
    return {"type": "phrase", "target": target, "bn": bn, "bn_pron": pron, "tokens": tokens}

def s(target, bn, pron, tokens):
    return {"type": "sentence", "target": target, "bn": bn, "bn_pron": pron, "tokens": tokens}

def snd(target, bn, pron):
    return {"type": "sound", "target": target, "bn": bn, "bn_pron": pron}

def let(target, bn, pron):
    return {"type": "letter", "target": target, "bn": bn, "bn_pron": pron}

units = {}

# -------------------------------------------------------------
# Unit s0-01: জার্মান বর্ণমালা ও উমলাউট (Alphabet & Umlauts)
# -------------------------------------------------------------
units["s0-01"] = {
    "title_bn": "জার্মান বর্ণমালা ও উমলাউট",
    "title_target": "Deutsches Alphabet & Umlaute",
    "lessons": [
        {
            "title_bn": "মৌলিক স্বরবর্ণ (A, E, I, O, U)",
            "title_target": "Die Grundvokale: A, E, I, O, U",
            "intro_bn": "জার্মান ভাষায় স্বরবর্ণগুলি বাংলায় খুব পরিষ্কারভাবে উচ্চারিত হয়। লক্ষ্য করুন ইংরেজি 'A' (এই)-এর বদলে জার্মানিতে 'আ' বলা হয়।",
            "structure": ["Vokal", "Aussprache", "Beispiel"],
            "items": [
                let("A", "আ (ইংরেজি A)", "আ"),
                w("Abend", "সন্ধ্যা", "আবেন্ট", gender="m", tokens=[{"t": "Abend", "bn": "সন্ধ্যা"}]),
                let("E", "এ (ইংরেজি E)", "এ"),
                w("Essen", "খাবার / খাওয়া", "এসেন", gender="n", tokens=[{"t": "Essen", "bn": "খাবার"}]),
                let("I", "ই (ইংরেজি I)", "ই"),
                w("Igel", "সজারু", "ইগেল", gender="m", tokens=[{"t": "Igel", "bn": "সজারু"}]),
                let("O", "ও (ইংরেজি O)", "ও"),
                w("Opa", "দাদু / নানা", "ওপা", gender="m", tokens=[{"t": "Opa", "bn": "দাদু"}]),
                let("U", "উ (ইংরেজি U)", "উ"),
                w("Uhr", "ঘড়ি", "উর", gender="f", tokens=[{"t": "Uhr", "bn": "ঘড়ি"}]),
            ]
        },
        {
            "title_bn": "উমলাউট ধ্বনি (Ä, Ö, Ü)",
            "title_target": "Die Umlaute: Ä, Ö, Ü",
            "intro_bn": "উমলাউট হলো দুটি ফোটাযুক্ত বিশেষ স্বরবর্ণ। Ä হলো 'এ্য', Ö হলো ঠোঁট গোল করে 'এ' বলা, আর Ü হলো শিস দেওয়ার মতো ঠোঁট গোল করে 'ঈ' বলা।",
            "structure": ["Umlaut", "Klang", "Wortbeispiel"],
            "items": [
                let("Ä", "এ্য (হ্রস্ব বা দীর্ঘ এ্য ধ্বনি)", "এ্য"),
                w("Äpfel", "আপেলগুলো", "এপফেল", tokens=[{"t": "Äpfel", "bn": "আপেলগুলো"}]),
                w("Mädchen", "মেয়ে / বালিকা", "মেডশেন", gender="n", tokens=[{"t": "Mädchen", "bn": "মেয়ে"}]),
                let("Ö", "ঠোঁট গোল করে 'এ' বলা", "ও্য"),
                w("Öl", "তেল", "ওয়েল", gender="n", tokens=[{"t": "Öl", "bn": "তেল"}]),
                w("schön", "সুন্দর", "শোয়ন", tokens=[{"t": "schön", "bn": "সুন্দর"}]),
                let("Ü", "শিস দেওয়ার মতো ঠোঁট গোল করে 'ঈ' বলা", "উ্য"),
                w("über", "উপরে / সম্পর্কে", "উ্যবার", tokens=[{"t": "über", "bn": "উপরে"}]),
                w("Tür", "দরজা", "ত্যুর", gender="f", tokens=[{"t": "Tür", "bn": "দরজা"}]),
            ]
        },
        {
            "title_bn": "এসহ্-সেট (ß) ও দ্বৈত ব্যঞ্জনবর্ণ",
            "title_target": "Eszett (ß) & Doppel-Konsonanten",
            "intro_bn": "ß অক্ষরটিকে বলে Eszett (এসহ্-সেট) বা scharfes S। এটি সর্বদা দীর্ঘ স্বরধ্বনির পরে তীক্ষ্ণ 'স্' উচ্চারণ প্রকাশ করে।",
            "structure": ["Buchstabe", "Phonetik", "Beispiel"],
            "items": [
                let("ß", "এসহ্-সেট (তীক্ষ্ণ স্ ধ্বনি)", "এস-ৎসেট"),
                w("Straße", "রাস্তা", "শ্ট্রাস়ে", gender="f", tokens=[{"t": "Straße", "bn": "রাস্তা"}]),
                w("groß", "বড়", "গ্রোস", tokens=[{"t": "groß", "bn": "বড়"}]),
                w("heißen", "নাম হওয়া", "হাইসেন", tokens=[{"t": "heißen", "bn": "নাম হওয়া"}]),
                w("Kaffee", "কফি", "কাফে", gender="m", tokens=[{"t": "Kaffee", "bn": "কফি"}]),
                w("Wasser", "পানি", "ভাসার", gender="n", tokens=[{"t": "Wasser", "bn": "পানি"}]),
                w("Bitte", "দয়া করে", "বিটে", tokens=[{"t": "Bitte", "bn": "দয়া করে"}]),
                w("Sonne", "সূর্য", "যোনে", gender="f", tokens=[{"t": "Sonne", "bn": "সূর্য"}]),
            ]
        },
        {
            "title_bn": "ব্যঞ্জনবর্ণ পর্ব ১ (B, C, D, F, G, H, J, K, L, M)",
            "title_target": "Konsonanten Teil Eins",
            "intro_bn": "লক্ষ্য করুন জার্মানিতে 'J'-এর উচ্চারণ ইংরেজি 'Y' অর্থাৎ অন্তস্থ 'য়'-এর মতো, যেমন Ja (ইয়া)।",
            "structure": ["Konsonant", "Laut", "Wort"],
            "items": [
                let("B", "বে (ইংরেজি B)", "বে"),
                w("Buch", "বই", "বুখ", gender="n", tokens=[{"t": "Buch", "bn": "বই"}]),
                let("D", "দে (ইংরেজি D)", "দে"),
                w("Danke", "ধন্যবাদ", "ডাঙ্কে", tokens=[{"t": "Danke", "bn": "ধন্যবাদ"}]),
                let("G", "গে (ইংরেজি G)", "গে"),
                w("Gut", "ভালো", "গুট", tokens=[{"t": "Gut", "bn": "ভালো"}]),
                let("J", "ইয়ট (উচ্চারণ অন্তস্থ 'য়')", "ইয়ট"),
                w("Ja", "হ্যাঁ", "ইয়া", tokens=[{"t": "Ja", "bn": "হ্যাঁ"}]),
                let("M", "এম (ইংরেজি M)", "এম"),
                w("Mutter", "মা", "মুটার", gender="f", tokens=[{"t": "Mutter", "bn": "মা"}]),
            ]
        },
        {
            "title_bn": "ব্যঞ্জনবর্ণ পর্ব ২ (N, P, R, S, T, V, W, Z)",
            "title_target": "Konsonanten Teil Zwei",
            "intro_bn": "জার্মানিতে 'V' উচ্চারিত হয় 'ফ' এর মতো (Vogel = ফোগেল), 'W' উচ্চারিত হয় 'ভ' এর মতো (Wasser = ভাসার), এবং 'Z' উচ্চারিত হয় 'ৎস' এর মতো (Zug = ৎসুক)।",
            "structure": ["Konsonant", "Lautregel", "Wort"],
            "items": [
                let("R", "এর (গলার গভীর থেকে বা জিভের আগা দিয়ে 'র')", "এর"),
                w("Reis", "চাল / ভাত", "রাইস", gender="m", tokens=[{"t": "Reis", "bn": "ভাত"}]),
                let("V", "ফাউ (উচ্চারণ 'ফ')", "ফাউ"),
                w("Vater", "বাবা", "ফাটার", gender="m", tokens=[{"t": "Vater", "bn": "বাবা"}]),
                let("W", "ভে (উচ্চারণ 'ভ')", "ভে"),
                w("Wagen", "গাড়ি", "ভাগেন", gender="m", tokens=[{"t": "Wagen", "bn": "গাড়ি"}]),
                let("Z", "ৎসেট (উচ্চারণ 'ৎস')", "ৎসেট"),
                w("Zug", "ট্রেন", "ৎসুক", gender="m", tokens=[{"t": "Zug", "bn": "ট্রেন"}]),
                w("Zimmer", "রুম / ঘর", "ৎসিমার", gender="n", tokens=[{"t": "Zimmer", "bn": "ঘর"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit s0-02: মূল স্বরধ্বনি ও দীর্ঘ/হ্রস্ব স্বর (Vowel Length & Double Vowels)
# -------------------------------------------------------------
units["s0-02"] = {
    "title_bn": "মূল স্বরধ্বনি ও দীর্ঘ/হ্রস্ব স্বর",
    "title_target": "Vokallänge & Doppelvokale",
    "lessons": [
        {
            "title_bn": "দীর্ঘ স্বরধ্বনি (Lange Vokale)",
            "title_target": "Lange Vokale",
            "intro_bn": "একটিমাত্র ব্যঞ্জনবর্ণের আগে স্বরধ্বনি দীর্ঘভাবে উচ্চারিত হয়, অথবা স্বরবর্ণের পর h থাকলে h অনুচ্চারিত থাকে ও স্বরধ্বনি দীর্ঘ হয়।",
            "structure": ["Wort", "Regel", "Bedeutung"],
            "items": [
                w("Tag", "দিন", "তা-ক", gender="m", tokens=[{"t": "Tag", "bn": "দিন"}]),
                w("gut", "ভালো", "গু-ট", tokens=[{"t": "gut", "bn": "ভালো"}]),
                w("rot", "লাল", "রো-ট", tokens=[{"t": "rot", "bn": "লাল"}]),
                w("Zahn", "দাঁত", "ৎসা-ন", gender="m", tokens=[{"t": "Zahn", "bn": "দাঁত"}]),
                w("Uhr", "ঘড়ি / সময়", "উ-র", gender="f", tokens=[{"t": "Uhr", "bn": "ঘড়ি"}]),
                w("Weg", "পথ / রাস্তা", "ভে-ক", gender="m", tokens=[{"t": "Weg", "bn": "পথ"}]),
                w("Name", "নাম", "না-মে", gender="m", tokens=[{"t": "Name", "bn": "নাম"}]),
                w("wohnen", "বাস করা", "ভো-নেন", tokens=[{"t": "wohnen", "bn": "বাস করা"}]),
            ]
        },
        {
            "title_bn": "হ্রস্ব স্বরধ্বনি (Kurze Vokale)",
            "title_target": "Kurze Vokale",
            "intro_bn": "দুটি ব্যঞ্জনবর্ণের আগে স্বরধ্বনি দ্রুত ও হ্রস্বভাবে উচ্চারিত হয়।",
            "structure": ["Wort", "Regel", "Bedeutung"],
            "items": [
                w("Mann", "পুরুষ / স্বামী", "মান", gender="m", tokens=[{"t": "Mann", "bn": "পুরুষ"}]),
                w("Bett", "বিছানা", "বেট", gender="n", tokens=[{"t": "Bett", "bn": "বিছানা"}]),
                w("Kind", "শিশু / বাচ্চা", "কিন্ট", gender="n", tokens=[{"t": "Kind", "bn": "শিশু"}]),
                w("oft", "প্রায়ই", "অফট", tokens=[{"t": "oft", "bn": "প্রায়ই"}]),
                w("Bus", "বাস", "বুস", gender="m", tokens=[{"t": "Bus", "bn": "বাস"}]),
                w("bitte", "অনুগ্রহ করে", "বিটে", tokens=[{"t": "bitte", "bn": "অনুগ্রহ করে"}]),
                w("Teller", "থালা / প্লেট", "টেলার", gender="m", tokens=[{"t": "Teller", "bn": "থালা"}]),
                w("kommen", "আসা", "কমেন", tokens=[{"t": "kommen", "bn": "আসা"}]),
            ]
        },
        {
            "title_bn": "দ্বৈত স্বরবর্ণ (Doppelvokale: aa, ee, oo)",
            "title_target": "Doppelvokale",
            "intro_bn": "একই স্বরবর্ণ পরপর দুবার বসলে সেটি নিশ্চিতভাবে দীর্ঘ স্বরধ্বনি প্রকাশ করে।",
            "structure": ["Doppelvokal", "Wort", "Bedeutung"],
            "items": [
                w("Haar", "চুল", "হা-র", gender="n", tokens=[{"t": "Haar", "bn": "চুল"}]),
                w("Paar", "জোড়া", "পা-র", gender="n", tokens=[{"t": "Paar", "bn": "জোড়া"}]),
                w("See", "হ্রদ / সমুদ্র", "যে-", gender="m", tokens=[{"t": "See", "bn": "হ্রদ"}]),
                w("Tee", "চা", "টে-", gender="m", tokens=[{"t": "Tee", "bn": "চা"}]),
                w("Kaffee", "কফি", "কাফে-", gender="m", tokens=[{"t": "Kaffee", "bn": "কফি"}]),
                w("Boot", "নৌকা", "বো-ট", gender="n", tokens=[{"t": "Boot", "bn": "নৌকা"}]),
                w("Moor", "জলাভূমি", "মো-র", gender="n", tokens=[{"t": "Moor", "bn": "জলাভূমি"}]),
                w("Zoo", "চিড়িয়াখানা", "ৎসো-", gender="m", tokens=[{"t": "Zoo", "bn": "চিড়িয়াখানা"}]),
            ]
        },
        {
            "title_bn": "\"ie\" ধ্বনি: দীর্ঘ ঈ (Langes I)",
            "title_target": "Die Kombination IE",
            "intro_bn": "জার্মান ভাষায় 'ie' সবসময় দীর্ঘ 'ঈ' (ee)-এর মতো উচ্চারিত হয়। এটি কখনোই 'আই' নয়।",
            "structure": ["Wort", "Aussprache", "Bedeutung"],
            "items": [
                w("Bier", "বিয়ার / পানীয়", "বী-র", gender="n", tokens=[{"t": "Bier", "bn": "বিয়ার"}]),
                w("hier", "এখানে", "হী-র", tokens=[{"t": "hier", "bn": "এখানে"}]),
                w("nie", "কখনই না", "নী-", tokens=[{"t": "nie", "bn": "কখনই না"}]),
                w("Tier", "পশু / প্রাণী", "টী-র", gender="n", tokens=[{"t": "Tier", "bn": "প্রাণী"}]),
                w("vier", "চার (সংখ্যা)", "ফী-র", tokens=[{"t": "vier", "bn": "চার"}]),
                w("sieben", "সাত (সংখ্যা)", "যী-বেন", tokens=[{"t": "sieben", "bn": "সাত"}]),
                w("Liebe", "ভালোবাসা", "লী-বে", gender="f", tokens=[{"t": "Liebe", "bn": "ভালোবাসা"}]),
                w("Lied", "গান", "লী-ট", gender="n", tokens=[{"t": "Lied", "bn": "গান"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit s0-03: যৌথ স্বরধ্বনি (Diphthongs: ei, ai, au, eu, äu)
# -------------------------------------------------------------
units["s0-03"] = {
    "title_bn": "যৌথ স্বরধ্বনি",
    "title_target": "Diphthonge: ei, ai, au, eu, äu",
    "lessons": [
        {
            "title_bn": "\"ei\" ও \"ai\": আই ধ্বনি",
            "title_target": "Diphthong EI und AI",
            "intro_bn": "জার্মান 'ei' এবং 'ai' দুটিই বাংলায় 'আই' ধ্বনির মতো উচ্চারিত হয়।",
            "structure": ["Wort", "Phonetik", "Bedeutung"],
            "items": [
                w("mein", "আমার", "মাইন", tokens=[{"t": "mein", "bn": "আমার"}]),
                w("dein", "তোমার", "ডাইন", tokens=[{"t": "dein", "bn": "তোমার"}]),
                w("nein", "না", "নাইন", tokens=[{"t": "nein", "bn": "না"}]),
                w("zwei", "দুই (সংখ্যা)", "ৎস্ভাই", tokens=[{"t": "zwei", "bn": "দুই"}]),
                w("drei", "তিন (সংখ্যা)", "ড্রাই", tokens=[{"t": "drei", "bn": "তিন"}]),
                w("Mai", "মে মাস", "মাই", gender="m", tokens=[{"t": "Mai", "bn": "মে মাস"}]),
                w("frei", "মুক্ত / স্বাধীন / খালি", "ফ্রাই", tokens=[{"t": "frei", "bn": "মুক্ত"}]),
                w("klein", "ছোট", "ক্লাইন", tokens=[{"t": "klein", "bn": "ছোট"}]),
            ]
        },
        {
            "title_bn": "\"au\": আউ ধ্বনি",
            "title_target": "Diphthong AU",
            "intro_bn": "'au' বাংলায় 'আউ' বা ইংরেজি 'house'-এর diphthong-এর মতো উচ্চারিত হয়।",
            "structure": ["Wort", "Phonetik", "Bedeutung"],
            "items": [
                w("Haus", "বাড়ি / ঘর", "হাউস", gender="n", tokens=[{"t": "Haus", "bn": "বাড়ি"}]),
                w("Frau", "মহিলা / স্ত্রী / মিসেস", "ফ্রাউ", gender="f", tokens=[{"t": "Frau", "bn": "মহিলা"}]),
                w("Baum", "গাছ", "বাউম", gender="m", tokens=[{"t": "Baum", "bn": "গাছ"}]),
                w("blau", "নীল", "ব্লাউ", tokens=[{"t": "blau", "bn": "নীল"}]),
                w("grau", "ধূসর", "গ্রাউ", tokens=[{"t": "grau", "bn": "ধূসর"}]),
                w("Auge", "চোখ", "আউগে", gender="n", tokens=[{"t": "Auge", "bn": "চোখ"}]),
                w("Auto", "গাড়ি", "আউটো", gender="n", tokens=[{"t": "Auto", "bn": "গাড়ি"}]),
                w("auch", "ও / এছাড়াও", "আউখ", tokens=[{"t": "auch", "bn": "ও"}]),
            ]
        },
        {
            "title_bn": "\"eu\" ও \"äu\": অয় ধ্বনি",
            "title_target": "Diphthong EU und ÄU",
            "intro_bn": "জার্মান 'eu' এবং 'äu' উভয়ই বাংলায় 'অয়' বা ইংরেজি 'boy'-এর মতো উচ্চারিত হয়।",
            "structure": ["Wort", "Phonetik", "Bedeutung"],
            "items": [
                w("neu", "নতুন", "নয়", tokens=[{"t": "neu", "bn": "নতুন"}]),
                w("Euro", "ইউরো (মুদ্রা)", "অয়রো", gender="m", tokens=[{"t": "Euro", "bn": "ইউরো"}]),
                w("Freund", "বন্ধু", "ফ্রয়ন্ট", gender="m", tokens=[{"t": "Freund", "bn": "বন্ধু"}]),
                w("heute", "আজ", "হয়টে", tokens=[{"t": "heute", "bn": "আজ"}]),
                w("Leute", "মানুষজন", "লয়টে", tokens=[{"t": "Leute", "bn": "মানুষজন"}]),
                w("Häuser", "বাড়িগুলো", "হয়যার", tokens=[{"t": "Häuser", "bn": "বাড়িগুলো"}]),
                w("Bäume", "গাছগুলো", "বয়মে", tokens=[{"t": "Bäume", "bn": "গাছগুলো"}]),
                w("Fräulein", "কুমারী", "ফ্রয়লাইন", gender="n", tokens=[{"t": "Fräulein", "bn": "কুমারী"}]),
            ]
        },
        {
            "title_bn": "যৌথ স্বরধ্বনির তুলনা ও অনুশীলন",
            "title_target": "Diphthong-Gegenüberstellung",
            "intro_bn": "একই শব্দের ভেতর diphthong পরিবর্তনের মাধ্যমে অর্থ ও বহুবচন পরিবর্তনের চমৎকার ড্রিল।",
            "structure": ["Paar", "Kontrast", "Sinn"],
            "items": [
                phr("mein Haus", "আমার বাড়ি", "মাইন হাউস", [{"t": "mein", "bn": "আমার"}, {"t": "Haus", "bn": "বাড়ি"}]),
                phr("zwei Häuser", "দুটি বাড়ি", "ৎস্ভাই হয়যার", [{"t": "zwei", "bn": "দুটি"}, {"t": "Häuser", "bn": "বাড়িগুলো"}]),
                phr("ein Baum", "একটি গাছ", "আইন বাউম", [{"t": "ein", "bn": "একটি"}, {"t": "Baum", "bn": "গাছ"}]),
                phr("drei Bäume", "তিনটি গাছ", "ড্রাই বয়মে", [{"t": "drei", "bn": "তিনটি"}, {"t": "Bäume", "bn": "গাছগুলো"}]),
                phr("neues Auto", "নতুন গাড়ি", "নয়েস আউটো", [{"t": "neues", "bn": "নতুন"}, {"t": "Auto", "bn": "গাড়ি"}]),
                phr("heute frei", "আজ ছুটি / আজ অবসর", "হয়টে ফ্রাই", [{"t": "heute", "bn": "আজ"}, {"t": "frei", "bn": "ছুটি"}]),
                phr("gute Freunde", "ভালো বন্ধুরা", "গুটে ফ্রয়ন্ডে", [{"t": "gute", "bn": "ভালো"}, {"t": "Freunde", "bn": "বন্ধুরা"}]),
                phr("zehn Euro", "দশ ইউরো", "ৎসেন অয়রো", [{"t": "zehn", "bn": "দশ"}, {"t": "Euro", "bn": "ইউরো"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit s0-04: ব্যাঞ্জনবর্ণের বিশেষ উচ্চারণ (Consonant Rules)
# -------------------------------------------------------------
units["s0-04"] = {
    "title_bn": "ব্যাঞ্জনবর্ণের বিশেষ উচ্চারণ",
    "title_target": "Besondere Konsonanten-Regeln",
    "lessons": [
        {
            "title_bn": "\"ch\": নরম ইখ্ ধ্বনি (ich-Laut)",
            "title_target": "Der weiche ich-Laut",
            "intro_bn": "e, i, ä, ö, ü এবং ব্যঞ্জনবর্ণের পরে ch বসলে তালুর সামনের অংশ দিয়ে কোমল 'খ' বা 'শ'-এর মধ্যবর্তী ফিসফিস ধ্বনি হয়।",
            "structure": ["Wort", "Lautumgebung", "Bedeutung"],
            "items": [
                w("ich", "আমি", "ইখ্", tokens=[{"t": "ich", "bn": "আমি"}]),
                w("nicht", "না / নয়", "নিখ্ট", tokens=[{"t": "nicht", "bn": "না"}]),
                w("Milch", "দুধ", "মিলখ্", gender="f", tokens=[{"t": "Milch", "bn": "দুধ"}]),
                w("sprechen", "কথা বলা", "শ্প্রেখেন", tokens=[{"t": "sprechen", "bn": "কথা বলা"}]),
                w("Recht", "অধিকার / আইন", "রেখ্ট", gender="n", tokens=[{"t": "Recht", "bn": "অধিকার"}]),
                w("Licht", "আলো", "লিখ্ট", gender="n", tokens=[{"t": "Licht", "bn": "আলো"}]),
                w("welche", "কোনটি", "ভেলখে", tokens=[{"t": "welche", "bn": "কোনটি"}]),
                w("Küche", "রান্নাঘর", "ক্যুখে", gender="f", tokens=[{"t": "Küche", "bn": "রান্নাঘর"}]),
            ]
        },
        {
            "title_bn": "\"ch\": শক্ত আখ্ ধ্বনি (ach-Laut)",
            "title_target": "Der harte ach-Laut",
            "intro_bn": "a, o, u এবং au-এর পরে ch বসলে গলার গভীর থেকে শক্ত ঘর্ষিত 'খ' (আর্বিক خ) ধ্বনি হয়।",
            "structure": ["Wort", "Lautumgebung", "Bedeutung"],
            "items": [
                w("ach", "আহ্ / ওহ্", "আখ্", tokens=[{"t": "ach", "bn": "আহ্"}]),
                w("Buch", "বই", "বুখ্", gender="n", tokens=[{"t": "Buch", "bn": "বই"}]),
                w("Nacht", "রাত", "নাখ্ট", gender="f", tokens=[{"t": "Nacht", "bn": "রাত"}]),
                w("machen", "করা / তৈরি করা", "মাখেন", tokens=[{"t": "machen", "bn": "করা"}]),
                w("kochen", "রান্না করা", "কখেন", tokens=[{"t": "kochen", "bn": "রান্না করা"}]),
                w("hoch", "উঁচু", "হোখ্", tokens=[{"t": "hoch", "bn": "উঁচু"}]),
                w("Kuchen", "কেক", "কুখেন", gender="m", tokens=[{"t": "Kuchen", "bn": "কেক"}]),
                w("Sprache", "ভাষা", "শ্প প্রাখে", gender="f", tokens=[{"t": "Sprache", "bn": "ভাষা"}]),
            ]
        },
        {
            "title_bn": "\"sch\": তালব্য শ ধ্বনি",
            "title_target": "Die Kombination SCH",
            "intro_bn": "'sch' সর্বদা সুস্পষ্ট বাংলা তালব্য 'শ' বা ইংরেজি 'sh' ধ্বনি প্রকাশ করে।",
            "structure": ["Wort", "Phonetik", "Bedeutung"],
            "items": [
                w("Schule", "স্কুল", "শুলে", gender="f", tokens=[{"t": "Schule", "bn": "স্কুল"}]),
                w("schön", "সুন্দর", "শোয়ন", tokens=[{"t": "schön", "bn": "সুন্দর"}]),
                w("schnell", "দ্রুত", "শনেল", tokens=[{"t": "schnell", "bn": "দ্রুত"}]),
                w("Tasche", "ব্যাগ", "তাশে", gender="f", tokens=[{"t": "Tasche", "bn": "ব্যাগ"}]),
                w("Fisch", "মাছ", "ফিশ", gender="m", tokens=[{"t": "Fisch", "bn": "মাছ"}]),
                w("Tisch", "টেবিল", "টিশ", gender="m", tokens=[{"t": "Tisch", "bn": "টেবিল"}]),
                w("Fleisch", "মাংস", "ফ্লাইশ", gender="n", tokens=[{"t": "Fleisch", "bn": "মাংস"}]),
                w("schlafen", "ঘুমানো", "শ্লাফেন", tokens=[{"t": "schlafen", "bn": "ঘুমানো"}]),
            ]
        },
        {
            "title_bn": "শব্দের শুরুতে \"sp\" ও \"st\"",
            "title_target": "Anlaut SP und ST",
            "intro_bn": "শব্দের শুরুতে sp উচ্চারিত হয় 'শ্প' এবং st উচ্চারিত হয় 'ষ্ট' বা 'শ্ত'।",
            "structure": ["Wort", "Phonetik", "Bedeutung"],
            "items": [
                w("Sport", "খেলাধুলা", "শ্পোর্ট", gender="m", tokens=[{"t": "Sport", "bn": "খেলাধুলা"}]),
                w("sprechen", "কথা বলা", "শ্প্রেখেন", tokens=[{"t": "sprechen", "bn": "কথা বলা"}]),
                w("spät", "দেরি", "শ্পেট", tokens=[{"t": "spät", "bn": "দেরি"}]),
                w("Spanisch", "স্প্যানিশ ভাষা", "শ্পানিশ", gender="n", tokens=[{"t": "Spanisch", "bn": "স্প্যানিশ"}]),
                w("Stadt", "শহর", "শ্টাট", gender="f", tokens=[{"t": "Stadt", "bn": "শহর"}]),
                w("Straße", "রাস্তা", "শ্ট্রাস়ে", gender="f", tokens=[{"t": "Straße", "bn": "রাস্তা"}]),
                w("Stunde", "ঘণ্টা / পিরিয়ড", "শ্টুন্ডে", gender="f", tokens=[{"t": "Stunde", "bn": "ঘণ্টা"}]),
                w("Student", "ছাত্র (বিশ্ববিদ্যালয়)", "শ্টুডেন্ট", gender="m", tokens=[{"t": "Student", "bn": "ছাত্র"}]),
            ]
        },
        {
            "title_bn": "\"pf\" ও \"qu\" ধ্বনি",
            "title_target": "Kombinationen PF und QU",
            "intro_bn": "'pf' হলো প ও ফ একসাথে বিস্ফোরণের মতো উচ্চারণ, আর 'qu' উচ্চারিত হয় 'ক্ভ' (kv) এর মতো।",
            "structure": ["Wort", "Phonetik", "Bedeutung"],
            "items": [
                w("Apfel", "আপেল", "আপফেল", gender="m", tokens=[{"t": "Apfel", "bn": "আপেল"}]),
                w("Pferd", "ঘোড়া", "পফেয়ার্ট", gender="n", tokens=[{"t": "Pferd", "bn": "ঘোড়া"}]),
                w("Pfeffer", "গোলমরিচ", "পফেফার", gender="m", tokens=[{"t": "Pfeffer", "bn": "গোলমরিচ"}]),
                w("Pflanze", "উদ্ভিদ / চারাগাছ", "পফ্লানৎসে", gender="f", tokens=[{"t": "Pflanze", "bn": "চারাগাছ"}]),
                w("Kopf", "মাথা", "কপফ", gender="m", tokens=[{"t": "Kopf", "bn": "মাথা"}]),
                w("Quelle", "উৎস / ঝরনা", "ক্ভেলে", gender="f", tokens=[{"t": "Quelle", "bn": "উৎস"}]),
                w("bequem", "আরামদায়ক", "বেক্ভেম", tokens=[{"t": "bequem", "bn": "আরামদায়ক"}]),
                w("Quittung", "রশিদ / মানি রিসিট", "ক্ভিটুং", gender="f", tokens=[{"t": "Quittung", "bn": "রশিদ"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit s0-05: শব্দের শেষে ধ্বনি পরিবর্তন (Auslautverhärtung)
# -------------------------------------------------------------
units["s0-05"] = {
    "title_bn": "শব্দের শেষে ধ্বনি পরিবর্তন",
    "title_target": "Auslautverhärtung & Endungen",
    "lessons": [
        {
            "title_bn": "শব্দের শেষে \"d\" হয়ে যায় \"t\"",
            "title_target": "Endlaut D wird T",
            "intro_bn": "শব্দের শেষে d থাকলে সেটি শক্ত হয়ে 'ট' বা 'ত'-এর মতো উচ্চারিত হয়।",
            "structure": ["Wort", "Aussprache", "Bedeutung"],
            "items": [
                w("und", "এবং / ও", "উন্ট", tokens=[{"t": "und", "bn": "এবং"}]),
                w("Bad", "গোসলখানা / বাথ", "বাট", gender="n", tokens=[{"t": "Bad", "bn": "গোসলখানা"}]),
                w("Bild", "ছবি", "বিল্ট", gender="n", tokens=[{"t": "Bild", "bn": "ছবি"}]),
                w("Lied", "গান", "লীট", gender="n", tokens=[{"t": "Lied", "bn": "গান"}]),
                w("Hund", "কুকুর", "হুন্ট", gender="m", tokens=[{"t": "Hund", "bn": "কুকুর"}]),
                w("Hand", "হাত", "হান্ট", gender="f", tokens=[{"t": "Hand", "bn": "হাত"}]),
                w("Kind", "শিশু", "কিন্ট", gender="n", tokens=[{"t": "Kind", "bn": "শিশু"}]),
                w("Geld", "টাকা / অর্থ", "গেল্ট", gender="n", tokens=[{"t": "Geld", "bn": "টাকা"}]),
            ]
        },
        {
            "title_bn": "শব্দের শেষে \"b\" হয়ে যায় \"p\"",
            "title_target": "Endlaut B wird P",
            "intro_bn": "শব্দের শেষে বা সিলেবলের শেষে b বসলে তা শক্ত হয়ে 'প'-এর মতো উচ্চারিত হয়।",
            "structure": ["Wort", "Aussprache", "Bedeutung"],
            "items": [
                w("Abend", "সন্ধ্যা", "আবেন্ট", gender="m", tokens=[{"t": "Abend", "bn": "সন্ধ্যা"}]),
                w("gelb", "হলুদ", "গেল্প", tokens=[{"t": "gelb", "bn": "হলুদ"}]),
                w("Urlaub", "ছুটি", "উরলাউপ", gender="m", tokens=[{"t": "Urlaub", "bn": "ছুটি"}]),
                w("Dieb", "চোর", "দীপ", gender="m", tokens=[{"t": "Dieb", "bn": "চোর"}]),
                w("Korb", "ঝুড়ি", "কর্প", gender="m", tokens=[{"t": "Korb", "bn": "ঝুড়ি"}]),
                w("halb", "অর্ধেক", "হাল্প", tokens=[{"t": "halb", "bn": "অর্ধেক"}]),
                w("Kalb", "বাছুর", "কাল্প", gender="n", tokens=[{"t": "Kalb", "bn": "বাছুর"}]),
                w("Klub", "ক্লাব", "ক্লুপ", gender="m", tokens=[{"t": "Klub", "bn": "ক্লাব"}]),
            ]
        },
        {
            "title_bn": "শব্দের শেষে \"g\" হয়ে যায় \"k\"",
            "title_target": "Endlaut G wird K",
            "intro_bn": "শব্দের শেষে g থাকলে তা শক্ত হয়ে 'ক'-এর মতো উচ্চারিত হয়।",
            "structure": ["Wort", "Aussprache", "Bedeutung"],
            "items": [
                w("Tag", "দিন", "তাক", gender="m", tokens=[{"t": "Tag", "bn": "দিন"}]),
                w("Zug", "ট্রেন", "ৎসুক", gender="m", tokens=[{"t": "Zug", "bn": "ট্রেন"}]),
                w("Flug", "ফ্লাইট / বিমান ভ্রমণ", "ফ্লুক", gender="m", tokens=[{"t": "Flug", "bn": "ফ্লাইট"}]),
                w("Weg", "রাস্তা / পথ", "ভেক", gender="m", tokens=[{"t": "Weg", "bn": "পথ"}]),
                w("klug", "চালাক / বুদ্ধিমান", "ক্লুক", tokens=[{"t": "klug", "bn": "বুদ্ধিমান"}]),
                w("Berg", "পাহাড় / পর্বত", "বের্ক", gender="m", tokens=[{"t": "Berg", "bn": "পাহাড়"}]),
                w("Burg", "দুর্গ / কেল্লা", "বুর্ক", gender="f", tokens=[{"t": "Burg", "bn": "দুর্গ"}]),
                w("Sarg", "কফিন", "যার্ক", gender="m", tokens=[{"t": "Sarg", "bn": "কফিন"}]),
            ]
        },
        {
            "title_bn": "শব্দের শেষে \"-ig\" হয়ে যায় \"-ich\"",
            "title_target": "Die Endung -ig",
            "intro_bn": "জার্মান স্ট্যান্ডার্ড উচ্চারণে শব্দের শেষের '-ig' কোমল ইখ্-লাউটের মতো '-ইখ্' বা '-ইশ' উচ্চারিত হয়।",
            "structure": ["Wort", "Aussprache", "Bedeutung"],
            "items": [
                w("richtig", "সঠিক / ঠিক", "রিখ্টিখ্", tokens=[{"t": "richtig", "bn": "সঠিক"}]),
                w("wichtig", "গুরুত্বপূর্ণ", "ভিখ্টিখ্", tokens=[{"t": "wichtig", "bn": "গুরুত্বপূর্ণ"}]),
                w("ruhig", "শান্ত", "রুহিখ্", tokens=[{"t": "ruhig", "bn": "শান্ত"}]),
                w("wenig", "কম / সামান্য", "ভেনিGridখ্", tokens=[{"t": "wenig", "bn": "কম"}]),
                w("fertig", "প্রস্তুত / শেষ", "ফেয়ার্টিখ্", tokens=[{"t": "fertig", "bn": "প্রস্তুত"}]),
                w("lustig", "মজার / হাসিখুশি", "লুস্ টিখ্", tokens=[{"t": "lustig", "bn": "মজার"}]),
                w("traurig", "দুঃখজনক / বিষণ্ণ", "ট্রাউরিখ্", tokens=[{"t": "traurig", "bn": "বিষণ্ণ"}]),
                w("König", "রাজা", "কোয়নিখ্", gender="m", tokens=[{"t": "König", "bn": "রাজা"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit s0-06: স্বরভঙ্গি, শব্দে জোর ও স্বরগ্রাম (Word Stress)
# -------------------------------------------------------------
units["s0-06"] = {
    "title_bn": "স্বরভঙ্গি, শব্দে জোর ও স্বরগ্রাম",
    "title_target": "Wortakzent & Satzmelodie",
    "lessons": [
        {
            "title_bn": "শব্দের মূল অংশে জোর (Stammbetonung)",
            "title_target": "Betonung auf dem Stamm",
            "intro_bn": "জার্মান আদি শব্দে সর্বদা প্রথম সিলেবল বা মূল ধাতুতে স্বাভাবিক জোর (Stress) থাকে।",
            "structure": ["Wort", "Betonung", "Bedeutung"],
            "items": [
                w("Name", "নাম", "না-মে", gender="m", tokens=[{"t": "Name", "bn": "নাম"}]),
                w("Danke", "ধন্যবাদ", "ডা-ঙ্কে", tokens=[{"t": "Danke", "bn": "ধন্যবাদ"}]),
                w("kommen", "আসা", "ক-মেন", tokens=[{"t": "kommen", "bn": "আসা"}]),
                w("wohnen", "বাস করা", "ভো-নেন", tokens=[{"t": "wohnen", "bn": "বাস করা"}]),
                w("lernen", "শেখা", "লের-নেন", tokens=[{"t": "lernen", "bn": "শেখা"}]),
                w("trinken", "পান করা", "ট্রিং-কেন", tokens=[{"t": "trinken", "bn": "পান করা"}]),
                w("arbeiten", "কাজ করা", "আর-বাইতেন", tokens=[{"t": "arbeiten", "bn": "কাজ করা"}]),
                w("hören", "শোনা", "হোয়-রেন", tokens=[{"t": "hören", "bn": "শোনা"}]),
            ]
        },
        {
            "title_bn": "যৌগিক শব্দের প্রথম পদে জোর (Komposita)",
            "title_target": "Akzent bei Komposita",
            "intro_bn": "জার্মানিতে দুটি শব্দ জোড়া লাগলে সর্বদা প্রথম শব্দটিতে প্রধান জোর পড়ে।",
            "structure": ["Kompositum", "Hauptakzent", "Bedeutung"],
            "items": [
                w("Haustür", "বাড়ির দরজা", "হাউস-ত্যুর", gender="f", tokens=[{"t": "Haustür", "bn": "বাড়ির দরজা"}]),
                w("Bahnhof", "রেল স্টেশন", "বান-হোফ", gender="m", tokens=[{"t": "Bahnhof", "bn": "রেল স্টেশন"}]),
                w("Flughafen", "বিমানবন্দর", "ফ্লুক-হাফেন", gender="m", tokens=[{"t": "Flughafen", "bn": "বিমানবন্দর"}]),
                w("Großvater", "দাদু / নানা", "গ্রোস-ফাটার", gender="m", tokens=[{"t": "Großvater", "bn": "দাদু"}]),
                w("Wörterbuch", "অভিধান", "ভোয়ের্টার-বুখ", gender="n", tokens=[{"t": "Wörterbuch", "bn": "অভিধান"}]),
                w("Kopfschmerzen", "মাথাব্যথা", "কপফ-শ্মেরৎসেন", tokens=[{"t": "Kopfschmerzen", "bn": "মাথাব্যথা"}]),
                w("Fahrkarte", "ভ্রমণের টিকিট", "ফার-কার্টে", gender="f", tokens=[{"t": "Fahrkarte", "bn": "টিকিট"}]),
                w("Hauptstadt", "রাজধানী", "হাউপট-শ্টাট", gender="f", tokens=[{"t": "Hauptstadt", "bn": "রাজধানী"}]),
            ]
        },
        {
            "title_bn": "সাধারণ বাক্যের নিম্নগামী সুর (Aussagesatz)",
            "title_target": "Fallende Satzmelodie",
            "intro_bn": "বিবৃতিমূলক বাক্যের শেষে গলার স্বর নিচের দিকে নেমে যায় (Falling Intonation)।",
            "structure": ["Satz", "Intonation", "Bedeutung"],
            "items": [
                s("Ich heiße Paul.", "আমার নাম পল।", "ইখ্ হাইসে পাউল", [{"t": "Ich", "bn": "আমি"}, {"t": "heiße", "bn": "নাম"}, {"t": "Paul.", "bn": "পল"}]),
                s("Das ist gut.", "এটা ভালো।", "ডাস ইস্ত গুট", [{"t": "Das", "bn": "এটা"}, {"t": "ist", "bn": "হয়"}, {"t": "gut.", "bn": "ভালো"}]),
                s("Ich lerne Deutsch.", "আমি জার্মান শিখছি।", "ইখ্ লের্নে ডয়চ", [{"t": "Ich", "bn": "আমি"}, {"t": "lerne", "bn": "শিখছি"}, {"t": "Deutsch.", "bn": "জার্মান"}]),
                s("Er kommt aus Berlin.", "সে বার্লিন থেকে এসেছে।", "এর কম্ট আউস বের্লিন", [{"t": "Er", "bn": "সে"}, {"t": "kommt", "bn": "আসে"}, {"t": "aus", "bn": "থেকে"}, {"t": "Berlin.", "bn": "বার্লিন"}]),
                s("Wir wohnen hier.", "আমরা এখানে থাকি।", "ভির ভোনেন হিয়ার", [{"t": "Wir", "bn": "আমরা"}, {"t": "wohnen", "bn": "থাকি"}, {"t": "hier.", "bn": "এখানে"}]),
                s("Das Wetter ist schön.", "আবহাওয়া সুন্দর।", "ডাস ভেটার ইস্ত শোয়ন", [{"t": "Das", "bn": "টি"}, {"t": "Wetter", "bn": "আবহাওয়া"}, {"t": "ist", "bn": "হয়"}, {"t": "schön.", "bn": "সুন্দর"}]),
                s("Sie trinken Kaffee.", "তারা কফি পান করছে।", "যী ট্রিঙ্কেন কাফে", [{"t": "Sie", "bn": "তারা"}, {"t": "trinken", "bn": "পান করে"}, {"t": "Kaffee.", "bn": "কফি"}]),
                s("Heute ist Montag.", "আজ সোমবার।", "হয়টে ইস্ত মোনতাক", [{"t": "Heute", "bn": "আজ"}, {"t": "ist", "bn": "হয়"}, {"t": "Montag.", "bn": "সোমবার"}]),
            ]
        },
        {
            "title_bn": "প্রশ্নবোধক বাক্যের সুর (Fragesatz)",
            "title_target": "Steigende & Fallende Melodie",
            "intro_bn": "Ja/Nein প্রশ্নে সুর উঁচুতে ওঠে (Rising), আর W-Frage (Wann, Wo, Wer)-তে সুর নিচে নামে।",
            "structure": ["Frage", "Intonation", "Bedeutung"],
            "items": [
                s("Kommen Sie aus Bonn?", "আপনি কি বন থেকে এসেছেন?", "কমেন যী আউস বন", [{"t": "Kommen", "bn": "আসেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "aus", "bn": "থেকে"}, {"t": "Bonn?", "bn": "বন"}]),
                s("Sprechen Sie Deutsch?", "আপনি কি জার্মান বলেন?", "শ্প্রেখেন যী ডয়চ", [{"t": "Sprechen", "bn": "বলেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "Deutsch?", "bn": "জার্মান"}]),
                s("Trinken Sie Tee?", "আপনি কি চা খাবেন?", "ট্রিঙ্কেন যী টে", [{"t": "Trinken", "bn": "পান করেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "Tee?", "bn": "চা"}]),
                s("Ist das frei?", "এটা কি খালি?", "ইস্ত ডাস ফ্রাই", [{"t": "Ist", "bn": "হয়"}, {"t": "das", "bn": "এটা"}, {"t": "frei?", "bn": "খালি"}]),
                s("Wie heißen Sie?", "আপনার নাম কী?", "ভী হাইসেন যী", [{"t": "Wie", "bn": "কেমন/কী"}, {"t": "heißen", "bn": "নাম"}, {"t": "Sie?", "bn": "আপনার"}]),
                s("Wo wohnen Sie?", "আপনি কোথায় থাকেন?", "ভো ভোনেন যী", [{"t": "Wo", "bn": "কোথায়"}, {"t": "wohnen", "bn": "থাকেন"}, {"t": "Sie?", "bn": "আপনি"}]),
                s("Woher kommen Sie?", "আপনি কোথা থেকে এসেছেন?", "ভোহের কমেন যী", [{"t": "Woher", "bn": "কোথা থেকে"}, {"t": "kommen", "bn": "আসেন"}, {"t": "Sie?", "bn": "আপনি"}]),
                s("Was machen Sie?", "আপনি কী করছেন?", "ভাস মাখেন যী", [{"t": "Was", "bn": "কী"}, {"t": "machen", "bn": "করেন"}, {"t": "Sie?", "bn": "আপনি"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit s0-07: জার্মান সংখ্যা গণনা (Zahlen 0 bis 100)
# -------------------------------------------------------------
units["s0-07"] = {
    "title_bn": "জার্মান সংখ্যা গণনা",
    "title_target": "Zahlen von Null bis Hundert",
    "lessons": [
        {
            "title_bn": "সংখ্যা: শূন্য থেকে বারো (null bis zwölf)",
            "title_target": "Null bis Zwölf",
            "intro_bn": "শূন্য থেকে বারো পর্যন্ত সংখ্যাগুলো স্বতন্ত্র মৌলিক শব্দ। এগুলো খুব ভালো করে আয়ত্ত করুন।",
            "structure": ["Zahlwort", "Wert", "Phonetik"],
            "items": [
                w("null", "শূন্য (০)", "নুল"),
                w("eins", "এক (১)", "আইন্স"),
                w("zwei", "দুই (২)", "ৎস্ভাই"),
                w("drei", "তিন (৩)", "ড্রাই"),
                w("vier", "চার (৪)", "ফিয়ার"),
                w("fünf", "পাঁচ (৫)", "ফ্যুনফ"),
                w("sechs", "ছয় (৬)", "জেক্স"),
                w("sieben", "সাত (৭)", "যীবেন"),
                w("acht", "আট (৮)", "আখট"),
                w("neun", "নয় (৯)", "নয়ন"),
                w("zehn", "দশ (১০)", "ৎসেন"),
                w("elf", "এগারো (১১)", "এল্ফ"),
                w("zwölf", "বারো (১২)", "ৎস্ভোয়েলফ"),
            ]
        },
        {
            "title_bn": "সংখ্যা: তেরো থেকে উনিশ (dreizehn bis neunzehn)",
            "title_target": "Dreizehn bis Neunzehn",
            "intro_bn": "তেরো থেকে উনিশ পর্যন্ত মূল সংখ্যার শেষে 'zehn' (দশ) যুক্ত হয়। লক্ষ্য করুন sechzehn ও siebzehn-এ সামান্য সংক্ষিপ্ত রূপ হয়।",
            "structure": ["Zahlwort", "Zusammensetzung", "Wert"],
            "items": [
                w("dreizehn", "তেরো (১৩)", "ড্রাইৎসেন"),
                w("vierzehn", "চৌদ্দ (১৪)", "ফিয়ারৎসেন"),
                w("fünfzehn", "পনেরো (১৫)", "ফ্যুনফৎসেন"),
                w("sechzehn", "ষোলো (১৬)", "জেখৎসেন"),
                w("siebzehn", "সতেরো (১৭)", "যীপৎসেন"),
                w("achtzehn", "আঠারো (১৮)", "আখটৎসেন"),
                w("neunzehn", "উনিশ (১৯)", "নয়নৎসেন"),
                w("zwanzig", "বিশ (২০)", "ৎস্ভানৎসিখ্"),
            ]
        },
        {
            "title_bn": "দশকের সংখ্যা: কুড়ি থেকে নব্বই (zwanzig bis neunzig)",
            "title_target": "Die Zehnerzahlen",
            "intro_bn": "দশকের সংখ্যাগুলোর শেষে '-zig' যুক্ত হয়। ব্যতিক্রম কেবল dreißig (এসহ্-সেট ß দিয়ে গঠিত)।",
            "structure": ["Zehner", "Wert", "Endung"],
            "items": [
                w("zwanzig", "বিশ (২০)", "ৎস্ভানৎসিখ্"),
                w("dreißig", "তিরিশ (৩০)", "ড্রাইসিখ্"),
                w("vierzig", "চল্লিশ (৪০)", "ফিয়ারৎসিখ্"),
                w("fünfzig", "পঞ্চাশ (৫০)", "ফ্যুনফৎসিখ্"),
                w("sechzig", "ষাট (৬০)", "জেখৎসিখ্"),
                w("siebzig", "সত্তর (৭০)", "যীপৎসিখ্"),
                w("achtzig", "আশি (৮০)", "আখটৎসিখ্"),
                w("neunzig", "নব্বই (৯০)", "নয়নৎসিখ্"),
            ]
        },
        {
            "title_bn": "একুশ থেকে উনত্রিশ (উল্টো গণনা নিয়ম)",
            "title_target": "Die Zahlen von 21 bis 29",
            "intro_bn": "জার্মানিতে দুই অঙ্কের সংখ্যা বলার সময় এককের ঘর আগে এবং দশকের ঘর পরে 'und' (এবং) দিয়ে জোড়া লাগে, যেমন: এক এবং বিশ = einundzwanzig।",
            "structure": ["Formel", "Zahl", "Phonetik"],
            "items": [
                w("einundzwanzig", "একুশ (২১)", "আইন-উন্ট-ৎস্ভানৎসিখ্"),
                w("zweiundzwanzig", "বাইশ (২২)", "ৎস্ভাই-উন্ট-ৎস্ভানৎসিখ্"),
                w("dreiundzwanzig", "তেইশ (২৩)", "ড্রাই-উন্ট-ৎস্ভানৎসিখ্"),
                w("vierundzwanzig", "চব্বিশ (২৪)", "ফিয়ার-উন্ট-ৎস্ভানৎসিখ্"),
                w("fünfundzwanzig", "পঁচিশ (২৫)", "ফ্যুনফ-উন্ট-ৎস্ভানৎসিখ্"),
                w("sechsundzwanzig", "ছাব্বিশ (২৬)", "জেক্স-উন্ট-ৎস্ভানৎসিখ্"),
                w("siebenundzwanzig", "সাতাশ (২৭)", "যীবেন-উন্ট-ৎস্ভানৎসিখ্"),
                w("achtundzwanzig", "আঠাশ (২৮)", "আখট-উন্ট-ৎস্ভানৎসিখ্"),
                w("neunundzwanzig", "উনত্রিশ (২৯)", "নয়ন-উন্ট-ৎস্ভানৎসিখ্"),
            ]
        },
        {
            "title_bn": "বড় সংখ্যা ও শতক (dreißig bis hundert)",
            "title_target": "Höhere Zahlen & Hundert",
            "intro_bn": "একই নিয়মে তিরিশ, চল্লিশ বা শতক পর্যন্ত গণনা করা যায়। ১০০ হলো hundert।",
            "structure": ["Zahlwort", "Bedeutung", "Phonetik"],
            "items": [
                w("einunddreißig", "একত্রিশ (৩১)", "আইন-উন্ট-ড্রাইসিখ্"),
                w("fünfunddreißig", "পঁয়ত্রিশ (৩৫)", "ফ্যুনফ-উন্ট-ড্রাইসিখ্"),
                w("zweiundvierzig", "বিয়াল্লিশ (৪২)", "ৎস্ভাই-উন্ট-ফিয়ারৎসিখ্"),
                w("fünfundfünfzig", "পঞ্চান্ন (৫৫)", "ফ্যুনফ-উন্ট-ফ্যুনফৎসিখ্"),
                w("neunundneunzig", "নিরানব্বই (৯৯)", "নয়ন-উন্ট-নয়নৎসিখ্"),
                w("hundert", "একশত (১০০)", "হুন্ডার্ট"),
                w("zweihundert", "দুইশত (২০০)", "ৎস্ভাই-হুন্ডার্ট"),
                w("tausend", "এক হাজার (১০০০)", "তাউজেন্ট"),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit s0-08: বাংলা-জার্মান সমধ্বনি ও ইংরেজি মিল শব্দ
# -------------------------------------------------------------
units["s0-08"] = {
    "title_bn": "বাংলা-জার্মান সমধ্বনি ও ইংরেজি মিল শব্দ",
    "title_target": "Kognaten & Internationale Wörter",
    "lessons": [
        {
            "title_bn": "সরাসরি পরিচিত মৌলিক শব্দ (House, Hand, Finger)",
            "title_target": "Germanische Kognaten",
            "intro_bn": "ইংরেজি ও জার্মান একই ভাষা পরিবারের সদস্য। বহু শব্দের বানান ও অর্থে অবিশ্বাস্য মিল রয়েছে।",
            "structure": ["Deutsch", "Englisch", "Bedeutung"],
            "items": [
                w("Haus", "বাড়ি (house)", "হাউস", gender="n", tokens=[{"t": "Haus", "bn": "বাড়ি"}]),
                w("Hand", "হাত (hand)", "হান্ট", gender="f", tokens=[{"t": "Hand", "bn": "হাত"}]),
                w("Finger", "আঙুল (finger)", "ফিঙ্গার", gender="m", tokens=[{"t": "Finger", "bn": "আঙুল"}]),
                w("Arm", "বাহু / হাত (arm)", "আর্ম", gender="m", tokens=[{"t": "Arm", "bn": "বাহু"}]),
                w("Gras", "ঘাস (grass)", "গ্রাস", gender="n", tokens=[{"t": "Gras", "bn": "ঘাস"}]),
                w("Wind", "বাতাস (wind)", "ভিন্ট", gender="m", tokens=[{"t": "Wind", "bn": "বাতাস"}]),
                w("Sommer", "গ্রীষ্ম (summer)", "যোমার", gender="m", tokens=[{"t": "Sommer", "bn": "গ্রীষ্ম"}]),
                w("Winter", "শীত (winter)", "ভinputencিন্টার", tokens=[{"t": "Winter", "bn": "শীত"}], gender="m"),
            ]
        },
        {
            "title_bn": "খাবার ও পানীয় সংক্রান্ত মিল শব্দ",
            "title_target": "Essen & Trinken Kognaten",
            "intro_bn": "জল, দুধ, রুটি ইত্যাদির জার্মান রূপগুলো ইংরেজি ও অন্যান্য ইন্দো-ইউরোপীয় ভাষার সাথে গভীরভাবে সম্পর্কিত।",
            "structure": ["Wort", "Verwandtes Wort", "Bedeutung"],
            "items": [
                w("Wasser", "পানি (water)", "ভাসার", gender="n", tokens=[{"t": "Wasser", "bn": "পানি"}]),
                w("Milch", "দুধ (milk)", "মিলখ্", gender="f", tokens=[{"t": "Milch", "bn": "দুধ"}]),
                w("Brot", "রুটি (bread)", "ব্রোট", gender="n", tokens=[{"t": "Brot", "bn": "রুটি"}]),
                w("Butter", "মাখন (butter)", "বুটার", gender="f", tokens=[{"t": "Butter", "bn": "মাখন"}]),
                w("Apfel", "আপেল (apple)", "আপফেল", gender="m", tokens=[{"t": "Apfel", "bn": "আপেল"}]),
                w("Salz", "লবণ (salt)", "যাল্ৎস", gender="n", tokens=[{"t": "Salz", "bn": "লবণ"}]),
                w("Pfeffer", "গোলমরিচ (pepper)", "পফেফার", gender="m", tokens=[{"t": "Pfeffer", "bn": "গোলমরিচ"}]),
                w("Fisch", "মাছ (fish)", "ফিশ", gender="m", tokens=[{"t": "Fisch", "bn": "মাছ"}]),
            ]
        },
        {
            "title_bn": "আন্তর্জাতিক পরিচিত শব্দ (Internationalismen)",
            "title_target": "Internationale Wörter",
            "intro_bn": "প্রযুক্তি, পর্যটন ও যোগাযোগ সংক্রান্ত আধুনিক আন্তর্জাতিক শব্দগুলো জার্মানে একইভাবে ব্যবহৃত হয়।",
            "structure": ["Wort", "Bereich", "Bedeutung"],
            "items": [
                w("Hotel", "হোটেল", "হোটেল", gender="n", tokens=[{"t": "Hotel", "bn": "হোটেল"}]),
                w("Computer", "কম্পিউটার", "কম্পিউটার", gender="m", tokens=[{"t": "Computer", "bn": "কম্পিউটার"}]),
                w("Telefon", "টেলিফোন", "টেলিফোন", gender="n", tokens=[{"t": "Telefon", "bn": "টেলিফোন"}]),
                w("Kaffee", "কফি", "কাফে", gender="m", tokens=[{"t": "Kaffee", "bn": "কফি"}]),
                w("Musik", "গান / সঙ্গীত", "মুযীক", gender="f", tokens=[{"t": "Musik", "bn": "সঙ্গীত"}]),
                w("Taxi", "ট্যাক্সি", "ট্যাক্সি", gender="n", tokens=[{"t": "Taxi", "bn": "ট্যাক্সি"}]),
                w("Bus", "বাস", "বুস", gender="m", tokens=[{"t": "Bus", "bn": "বাস"}]),
                w("Restaurant", "রেস্তোরাঁ", "রেস্টোরান্ট", gender="n", tokens=[{"t": "Restaurant", "bn": "রেস্তোরাঁ"}]),
            ]
        },
        {
            "title_bn": "মিথ্যা বন্ধু বা বিভ্রান্তিকর শব্দ (False Friends)",
            "title_target": "Falsche Freunde vermeiden",
            "intro_bn": "সাবধান! কিছু জার্মান শব্দ দেখতে ইংরেজির মতো হলেও অর্থ সম্পূর্ণ আলাদা। যেমন Gift মানে উপহার নয়, বিষ!",
            "structure": ["Wort", "Scheinbedeutung", "Echte Bedeutung"],
            "items": [
                w("Gift", "বিষ (উপহার নয়!)", "গিফ্ট", gender="n", tokens=[{"t": "Gift", "bn": "বিষ"}]),
                w("bald", "শীঘ্রই (ন্যাড়া নয়!)", "বাল্ট", tokens=[{"t": "bald", "bn": "শীঘ্রই"}]),
                w("bekommen", "পাওয়া (হওয়া নয়!)", "বেকমেন", tokens=[{"t": "bekommen", "bn": "পাওয়া"}]),
                w("Chef", "বস / প্রধান কর্মকর্তা (বাবুর্চি নয়!)", "শেফ", gender="m", tokens=[{"t": "Chef", "bn": "বস"}]),
                w("Fabrik", "কারখানা (কাপড় নয়!)", "ফাব্রিক", gender="f", tokens=[{"t": "Fabrik", "bn": "কারখানা"}]),
                w("aktuell", "সাম্প্রতিক / বর্তমান (প্রকৃত নয়!)", "আকতুয়েল", tokens=[{"t": "aktuell", "bn": "বর্তমান"}]),
                w("brav", "ভদ্র / বাধ্য (সাহসী নয়!)", "ব্রাফ", tokens=[{"t": "brav", "bn": "ভদ্র"}]),
                w("Rente", "পেনশন (ভাড়া নয়!)", "রেন্টে", gender="f", tokens=[{"t": "Rente", "bn": "পেনশন"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit s0-09: জরুরি অভিবাদন ও ভদ্রোচিত শব্দ
# -------------------------------------------------------------
units["s0-09"] = {
    "title_bn": "জরুরি অভিবাদন ও ভদ্রোচিত শব্দ",
    "title_target": "Begrüßung & Höflichkeitsformeln",
    "lessons": [
        {
            "title_bn": "দিনের বেলার শুভেচ্ছা (Hallo, Guten Tag)",
            "title_target": "Grüße im Tageslauf",
            "intro_bn": "জার্মানিতে যেকোনো দেখা সাক্ষাতে অভিবাদন জানানো খুব গুরুত্বপূর্ণ একটি সামাজিক শিষ্টাচার।",
            "structure": ["Grußformel", "Tageszeit", "Bedeutung"],
            "items": [
                w("Hallo", "হ্যালো / হাই", "হালো", tokens=[{"t": "Hallo", "bn": "হ্যালো"}]),
                phr("Guten Morgen", "শুভ সকাল", "গুটেন মর্গেন", [{"t": "Guten", "bn": "শুভ"}, {"t": "Morgen", "bn": "সকাল"}]),
                phr("Guten Tag", "শুভ দিন / আসসালামু আলাইকুম", "গুটেন তাক", [{"t": "Guten", "bn": "শুভ"}, {"t": "Tag", "bn": "দিন"}]),
                phr("Guten Abend", "শুভ সন্ধ্যা", "গুটেন আবেন্ট", [{"t": "Guten", "bn": "শুভ"}, {"t": "Abend", "bn": "সন্ধ্যা"}]),
                phr("Grüß Gott", "নমস্কার / শুভ দিন (দক্ষিণ জার্মানি)", "গ্র্যূস গট", [{"t": "Grüß", "bn": "শুভেচ্ছা"}, {"t": "Gott", "bn": "ঈশ্বর"}]),
                phr("Moin Moin", "হ্যালো / শুভ দিন (উত্তর জার্মানি)", "ময়ন ময়ন", [{"t": "Moin", "bn": "শুভ"}, {"t": "Moin", "bn": "দিন"}]),
                phr("Servus", "হ্যালো / বাই (অস্ট্রিয়া ও বাভারিয়া)", "সেরভুস্", [{"t": "Servus", "bn": "হ্যালো"}]),
                s("Herzlich willkommen!", "আন্তরিক স্বাগতম!", "হেয়ার্ৎসলিখ্ ভিলকোমেন", [{"t": "Herzlich", "bn": "আন্তরিক"}, {"t": "willkommen!", "bn": "স্বাগতম"}]),
            ]
        },
        {
            "title_bn": "বিদায় সম্ভাষণ (Auf Wiedersehen, Tschüss)",
            "title_target": "Abschied nehmen",
            "intro_bn": "আনুষ্ঠানিক বিদায়ে Auf Wiedersehen এবং বন্ধুদের মাঝে Tschüss ব্যবহার করা হয়।",
            "structure": ["Formel", "Register", "Bedeutung"],
            "items": [
                phr("Auf Wiedersehen", "আবার দেখা হবে / বিদায় (আনুষ্ঠানিক)", "আউফ ভিডারজেহেন", [{"t": "Auf", "bn": "পুনরায়"}, {"t": "Wiedersehen", "bn": "দেখা হওয়া"}]),
                w("Tschüss", "বিদায় (বন্ধুত্বপূর্ণ)", "ত্যুস", tokens=[{"t": "Tschüss", "bn": "বিদায়"}]),
                phr("Bis bald", "শীঘ্রই দেখা হবে", "বিস বাল্ট", [{"t": "Bis", "bn": "পর্যন্ত"}, {"t": "bald", "bn": "শীঘ্রই"}]),
                phr("Bis später", "পরে দেখা হবে", "বিস শ্পেটার", [{"t": "Bis", "bn": "পর্যন্ত"}, {"t": "später", "bn": "পরে"}]),
                phr("Bis morgen", "কাল দেখা হবে", "বিস মর্গেন", [{"t": "Bis", "bn": "পর্যন্ত"}, {"t": "morgen", "bn": "কাল"}]),
                phr("Gute Nacht", "শুভ রাত্রি", "গুটে নাখ্ট", [{"t": "Gute", "bn": "শুভ"}, {"t": "Nacht", "bn": "রাত্রি"}]),
                phr("Schönes Wochenende", "সাপ্তাহিক ছুটি শুভ হোক", "শোয়নেস ভখেনএন্ডে", [{"t": "Schönes", "bn": "সুন্দর"}, {"t": "Wochenende", "bn": "ছুটি"}]),
                phr("Auf Wiederhören", "ফোনে বিদায় সম্ভাষণ", "আউফ ভিডারহোয়েরেন", [{"t": "Auf", "bn": "পুনরায়"}, {"t": "Wiederhören", "bn": "শোনা"}]),
            ]
        },
        {
            "title_bn": "ধন্যবাদ ও স্বাগতম (Danke, Bitte)",
            "title_target": "Danke & Bitte sagen",
            "intro_bn": "Danke ও Bitte হলো জার্মান ভাষার দুটি সবচেয়ে মধুর ও বহুল ব্যবহৃত শব্দ।",
            "structure": ["Ausdruck", "Intensität", "Bedeutung"],
            "items": [
                w("Danke", "ধন্যবাদ", "ডাঙ্কে", tokens=[{"t": "Danke", "bn": "ধন্যবাদ"}]),
                phr("Danke schön", "অনেক ধন্যবাদ", "ডাঙ্কে শোয়ন", [{"t": "Danke", "bn": "ধন্যবাদ"}, {"t": "schön", "bn": "সুন্দর"}]),
                phr("Vielen Dank", "অসংখ্য ধন্যবাদ", "ফিলেন ডাঙ্ক", [{"t": "Vielen", "bn": "অনেক"}, {"t": "Dank", "bn": "ধন্যবাদ"}]),
                w("Bitte", "দয়া করে / স্বাগতম", "বিটে", tokens=[{"t": "Bitte", "bn": "দয়া করে"}]),
                phr("Bitte schön", "স্বাগতম / এই নিন", "বিটে শোয়ন", [{"t": "Bitte", "bn": "দয়া করে"}, {"t": "schön", "bn": "সুন্দর"}]),
                phr("Gern geschehen", "স্বাচ্ছন্দ্যে করেছি / কোনো ব্যাপার না", "গেয়ার্ন গেশেহেন", [{"t": "Gern", "bn": "খুশিমনে"}, {"t": "geschehen", "bn": "ঘটেছে"}]),
                phr("Keine Ursache", "ধন্যবাদ দিতে হবে না", "কাইনে উরযাখে", [{"t": "Keine", "bn": "কোনো না"}, {"t": "Ursache", "bn": "কারণ"}]),
                phr("Sehr gerne", "খুব আনন্দের সাথে", "জেয়ার গেয়ার্নে", [{"t": "Sehr", "bn": "খুব"}, {"t": "gerne", "bn": "আনন্দের সাথে"}]),
            ]
        },
        {
            "title_bn": "দুঃখ প্রকাশ ও ক্ষমা চাওয়া (Entschuldigung)",
            "title_target": "Sich entschuldigen",
            "intro_bn": "কারো দৃষ্টি আকর্ষণ করতে বা ভুল হলে ক্ষমা চাইতে এই অভিব্যক্তিগুলো কাজে লাগবে।",
            "structure": ["Ausdruck", "Situation", "Bedeutung"],
            "items": [
                w("Entschuldigung", "মাফ করবেন / এক্সকিউজ মি", "এন্টশুলডিগুং", gender="f", tokens=[{"t": "Entschuldigung", "bn": "মাফ করবেন"}]),
                s("Es tut mir leid.", "আমি দুঃখিত।", "এস টুট মিয়ার লাইট", [{"t": "Es", "bn": "এটা"}, {"t": "tut", "bn": "করে"}, {"t": "mir", "bn": "আমার"}, {"t": "leid.", "bn": "কষ্ট"}]),
                phr("Kein Problem", "কোনো সমস্যা নেই", "কাইন প্রবলেম", [{"t": "Kein", "bn": "কোনো না"}, {"t": "Problem", "bn": "সমস্যা"}]),
                s("Macht nichts.", "কিছু মনে করবেন না / অসুবিধা নেই।", "মাখট নিখ্ট", [{"t": "Macht", "bn": "করে"}, {"t": "nichts.", "bn": "কিছু না"}]),
                s("Verzeihung bitte.", "ক্ষমা করবেন দয়া করে।", "ফেয়ারৎসাইহুং বিটে", [{"t": "Verzeihung", "bn": "ক্ষমা"}, {"t": "bitte.", "bn": "দয়া করে"}]),
                s("Das macht nichts.", "তাতে কিছু আসে যায় না।", "ডাস মাখট নিখ্ট", [{"t": "Das", "bn": "তাতে"}, {"t": "macht", "bn": "করে"}, {"t": "nichts.", "bn": "কিছু না"}]),
                phr("Alles gut", "সব ঠিক আছে", "আলেস গুট", [{"t": "Alles", "bn": "সব"}, {"t": "gut", "bn": "ভালো"}]),
                phr("Schade eigentlich", "আসলেই আফসোসের বিষয়", "শাডে আইগেন্টলিখ", [{"t": "Schade", "bn": "আফসোস"}, {"t": "eigentlich", "bn": "আসলে"}]),
            ]
        },
        {
            "title_bn": "হ্যাঁ, না এবং মতামত (Ja, Nein, Doch)",
            "title_target": "Zustimmung & Verneinung",
            "intro_bn": "নেতিবাচক প্রশ্নের উত্তরে হ্যাঁ বলতে বিশেষ শব্দ Doch ব্যবহৃত হয়। যেমন: তুমি কি যাবে না? - Doch! (অবশ্যই যাব!)।",
            "structure": ["Antwortwort", "Bedeutung", "Verwendung"],
            "items": [
                w("Ja", "হ্যাঁ", "ইয়া", tokens=[{"t": "Ja", "bn": "হ্যাঁ"}]),
                w("Nein", "না", "নাইন", tokens=[{"t": "Nein", "bn": "না"}]),
                w("Doch", "হ্যাঁ (নেতিবাচক প্রশ্নের বিপরীতে)", "ডখ", tokens=[{"t": "Doch", "bn": "অবশ্যই হ্যাঁ"}]),
                w("Vielleicht", "সম্ভবত / হয়তো", "ফীলাইখ্ট", tokens=[{"t": "Vielleicht", "bn": "হয়তো"}]),
                w("Natürlich", "অবশ্যই / স্বাভাবিকভাবে", "নাত্যুরলিখ", tokens=[{"t": "Natürlich", "bn": "অবশ্যই"}]),
                w("Genau", "একদম ঠিক / এক্স্যাক্টলি", "গেনাউ", tokens=[{"t": "Genau", "bn": "একদম ঠিক"}]),
                phr("Auf jeden Fall", "যেকোনো মূল্যে / অবশ্যই", "আউফ ইয়েডেন ফাল", [{"t": "Auf", "bn": "উপর"}, {"t": "jeden", "bn": "প্রতিটি"}, {"t": "Fall", "bn": "ঘটনা"}]),
                phr("Auf keinen Fall", "কখনই নয় / কোনো অবস্থাতেই না", "আউফ কাইনেন ফাল", [{"t": "Auf", "bn": "উপর"}, {"t": "keinen", "bn": "কোনো না"}, {"t": "Fall", "bn": "ঘটনা"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit s0-10: ক্লাসরুম ও অ্যাপ ব্যবহারের নির্দেশ
# -------------------------------------------------------------
units["s0-10"] = {
    "title_bn": "ক্লাসরুম ও অ্যাপ ব্যবহারের নির্দেশ",
    "title_target": "Klassenzimmer & App-Anweisungen",
    "lessons": [
        {
            "title_bn": "শোনা ও বলা সংক্রান্ত নির্দেশ (Hören & Sprechen)",
            "title_target": "Hör- & Sprechanweisungen",
            "intro_bn": "স্পোকেন ক্লাসে ও অ্যাপে নির্দেশনা বোঝার মৌলিক শব্দসমূহ।",
            "structure": ["Imperativ", "Aktion", "Bedeutung"],
            "items": [
                s("Hören Sie zu!", "মন দিয়ে শুনুন!", "হোয়েরেন যী ৎসু", [{"t": "Hören", "bn": "শুনুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "zu!", "bn": "মন দিয়ে"}]),
                s("Sprechen Sie nach!", "পিছনে পিছনে বলুন!", "শ্প্রেখেন যী নাখ", [{"t": "Sprechen", "bn": "বলুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "nach!", "bn": "পিছনে"}]),
                s("Wiederholen Sie bitte!", "দয়া করে পুনরাবৃত্তি করুন!", "ভিডাহোলেন যী বিটে", [{"t": "Wiederholen", "bn": "পুনরাবৃত্তি করুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "bitte!", "bn": "দয়া করে"}]),
                s("Sprechen Sie laut!", "জোরে জোরে বলুন!", "শ্প্রেখেন যী লাউট", [{"t": "Sprechen", "bn": "বলুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "laut!", "bn": "উচ্চস্বরে"}]),
                s("Antworten Sie bitte!", "দয়া করে উত্তর দিন!", "আন্টভর্টেন যী বিটে", [{"t": "Antworten", "bn": "উত্তর দিন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "bitte!", "bn": "দয়া করে"}]),
                s("Fragen Sie Ihren Partner!", "আপনার সঙ্গীকে জিজ্ঞাসা করুন!", "ফ্রাগেন যী ইরেন পার্টনার", [{"t": "Fragen", "bn": "জিজ্ঞাসা করুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "Ihren", "bn": "আপনার"}, {"t": "Partner!", "bn": "সঙ্গীকে"}]),
                s("Sprechen Sie langsam!", "ধীরে ধীরে কথা বলুন!", "শ্প্রেখেন যী লাংসাম", [{"t": "Sprechen", "bn": "বলুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "langsam!", "bn": "ধীরে"}]),
                s("Üben Sie täglich!", "প্রতিদিন অনুশীলন করুন!", "উ্যবেন যী টেগলিখ", [{"t": "Üben", "bn": "অনুশীলন করুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "täglich!", "bn": "প্রতিদিন"}]),
            ]
        },
        {
            "title_bn": "পড়া ও লেখা সংক্রান্ত নির্দেশ (Lesen & Schreiben)",
            "title_target": "Lese- & Schreibanweisungen",
            "intro_bn": "পাঠ্যপুস্তক বা পরীক্ষার নির্দেশনায় ব্যবহৃত ক্রিয়াপদ।",
            "structure": ["Anweisung", "Kontext", "Bedeutung"],
            "items": [
                s("Lesen Sie den Text!", "টেক্সটটি পড়ুন!", "লেজেন যী ডেন টেক্সট", [{"t": "Lesen", "bn": "পড়ুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "den", "bn": "টি"}, {"t": "Text!", "bn": "টেক্সট"}]),
                s("Schreiben Sie das Wort!", "শব্দটি লিখুন!", "শ্রাইবেন যী ডাস ভর্ট", [{"t": "Schreiben", "bn": "লিখুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "das", "bn": "টি"}, {"t": "Wort!", "bn": "শব্দ"}]),
                s("Kreuzen Sie an!", "সঠিক ঘরে টিক চিহ্ন দিন!", "ক্রয়ৎসেন যী আন", [{"t": "Kreuzen", "bn": "চিহ্ন দিন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "an!", "bn": "টিক"}]),
                s("Ergänzen Sie die Lücke!", "শূন্যস্থান পূরণ করুন!", "এয়ার্গেনৎসেন যী ডী ল্যুকে", [{"t": "Ergänzen", "bn": "পূরণ করুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "die", "bn": "টি"}, {"t": "Lücke!", "bn": "শূন্যস্থান"}]),
                s("Ordnen Sie zu!", "মিলিয়ে সাজান!", "অর্ডনেন যী ৎসু", [{"t": "Ordnen", "bn": "সাজান"}, {"t": "Sie", "bn": "আপনি"}, {"t": "zu!", "bn": "মিলিয়ে"}]),
                s("Markieren Sie die Verben!", "ক্রিয়াপদগুলো চিহ্নিত করুন!", "মার্কিরেন যী ডী ভার্বেন", [{"t": "Markieren", "bn": "চিহ্নিত করুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "die", "bn": "গুলো"}, {"t": "Verben!", "bn": "ক্রিয়াপদ"}]),
                s("Notieren Sie bitte!", "দয়া করে নোট করুন!", "নোটিরেন যী বিটে", [{"t": "Notieren", "bn": "নোট করুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "bitte!", "bn": "দয়া করে"}]),
                s("Vergleichen Sie zu zweit!", "জোড়ায় জোড়ায় তুলনা করুন!", "ফেয়ারগ্লাইখেন যী ৎসু ৎস্ভাইট", [{"t": "Vergleichen", "bn": "তুলনা করুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "zu", "bn": "এ"}, {"t": "zweit!", "bn": "জোড়ায়"}]),
            ]
        },
        {
            "title_bn": "বুঝতে না পারা ও সাহায্য চাওয়া",
            "title_target": "Verstehen & Hilfe erbitten",
            "intro_bn": "কথা বুঝতে সমস্যা হলে বা ধীরে বলতে অনুরোধ জানানোর প্রয়োজনীয় বাক্য।",
            "structure": ["Satz", "Problem", "Bedeutung"],
            "items": [
                s("Ich verstehe das nicht.", "আমি এটা বুঝতে পারছি না।", "ইখ্ ফেয়ার্শ্টেহে ডাস নিখ্ট", [{"t": "Ich", "bn": "আমি"}, {"t": "verstehe", "bn": "বুঝি"}, {"t": "das", "bn": "এটা"}, {"t": "nicht.", "bn": "না"}]),
                s("Langsamer bitte!", "দয়া করে আরেকটু ধীরে বলুন!", "লাংসামার বিটে", [{"t": "Langsamer", "bn": "আরেকটু ধীরে"}, {"t": "bitte!", "bn": "দয়া করে"}]),
                s("Können Sie das wiederholen?", "আপনি কি এটা আবার বলতে পারবেন?", "কোয়ন্নেন যী ডাস ভিডারহোলেন", [{"t": "Können", "bn": "পারবেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "das", "bn": "এটা"}, {"t": "wiederholen?", "bn": "পুনরাবৃত্তি করতে"}]),
                s("Ich habe eine Frage.", "আমার একটি প্রশ্ন আছে।", "ইখ্ হাবে আইনে ফ্রাগে", [{"t": "Ich", "bn": "আমার"}, {"t": "habe", "bn": "আছে"}, {"t": "eine", "bn": "একটি"}, {"t": "Frage.", "bn": "প্রশ্ন"}]),
                s("Können Sie mir helfen?", "আপনি কি আমাকে সাহায্য করতে পারবেন?", "কোয়ন্নেন যী মিয়ার হেলফেন", [{"t": "Können", "bn": "পারবেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "mir", "bn": "আমাকে"}, {"t": "helfen?", "bn": "সাহায্য করতে"}]),
                s("Was bedeutet das?", "এটার অর্থ কী?", "ভাস বেদয়টেট ডাস", [{"t": "Was", "bn": "কী"}, {"t": "bedeutet", "bn": "অর্থ বহন করে"}, {"t": "das?", "bn": "এটা"}]),
                s("Wie heißt das auf Deutsch?", "এটাকে জার্মানে কী বলে?", "ভী হাইস্ট ডাস আউফ ডয়চ", [{"t": "Wie", "bn": "কী/কেমন"}, {"t": "heißt", "bn": "বলে"}, {"t": "das", "bn": "এটাকে"}, {"t": "auf", "bn": "তে"}, {"t": "Deutsch?", "bn": "জার্মান"}]),
                s("Wie schreibt man das?", "এটা কীভাবে লেখে / বানান কী?", "ভী শ্রাইপ্ট মান ডাস", [{"t": "Wie", "bn": "কীভাবে"}, {"t": "schreibt", "bn": "লেখে"}, {"t": "man", "bn": "লোকে"}, {"t": "das?", "bn": "এটা"}]),
            ]
        },
        {
            "title_bn": "প্রশ্ন করা ও স্পষ্টতা চাওয়া (Wie bitte?)",
            "title_target": "Nachfragen & Klären",
            "intro_bn": "কথা শুনতে না পেলে বা অস্পষ্ট লাগলে বিনীতভাবে আবার শুনতে চাওয়ার কৌশল।",
            "structure": ["Frage", "Absicht", "Bedeutung"],
            "items": [
                s("Wie bitte?", "কী বললেন দয়া করে? / সরি?", "ভী বিটে", [{"t": "Wie", "bn": "কেমন"}, {"t": "bitte?", "bn": "দয়া করে"}]),
                s("Noch einmal bitte!", "আরেকবার দয়া করে!", "নখ আইনমাল বিটে", [{"t": "Noch", "bn": "আরও"}, {"t": "einmal", "bn": "একবার"}, {"t": "bitte!", "bn": "দয়া করে"}]),
                s("Ist das richtig?", "এটা কি সঠিক?", "ইস্ত ডাস রিখ্টিখ", [{"t": "Ist", "bn": "হয়"}, {"t": "das", "bn": "এটা"}, {"t": "richtig?", "bn": "সঠিক"}]),
                s("Haben Sie das verstanden?", "আপনি কি এটা বুঝেছেন?", "হাবের্ন যী ডাস ফেয়ার্শ্টান্ডেন", [{"t": "Haben", "bn": "আছেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "das", "bn": "এটা"}, {"t": "verstanden?", "bn": "বুঝেছেন"}]),
                s("Ja, alles klar.", "হ্যাঁ, সব পরিষ্কার।", "ইয়া আলেস ক্লার", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "alles", "bn": "সব"}, {"t": "klar.", "bn": "পরিষ্কার"}]),
                s("Ich weiß nicht.", "আমি জানি না।", "ইখ্ ভাইস নিখ্ট", [{"t": "Ich", "bn": "আমি"}, {"t": "weiß", "bn": "জানি"}, {"t": "nicht.", "bn": "না"}]),
                s("Keine Ahnung.", "কোনো ধারণা নেই।", "কাইনে আনুং", [{"t": "Keine", "bn": "কোনো না"}, {"t": "Ahnung.", "bn": "ধারণা"}]),
                s("Gute Idee!", "দারুণ বুদ্ধি!", "গুটে ইডে", [{"t": "Gute", "bn": "ভালো"}, {"t": "Idee!", "bn": "বুদ্ধি"}]),
            ]
        },
        {
            "title_bn": "অ্যাপের বোতাম ও ফাংশন (App-Funktionen)",
            "title_target": "App-Bedienung & Knöpfe",
            "intro_bn": "অডিও বুক লাইব্রেরি অ্যাপের লার্নিং ইন্টারফেস পরিচালনায় ব্যবহৃত পরিভাষা।",
            "structure": ["Begriff", "Funktion", "Bedeutung"],
            "items": [
                w("Start", "শুরু করুন", "শ্টার্ট", tokens=[{"t": "Start", "bn": "শুরু"}]),
                w("Pause", "বিরতি / থামুন", "পাউজে", tokens=[{"t": "Pause", "bn": "বিরতি"}]),
                w("Weiter", "পরবর্তী / এগিয়ে যান", "ভাইটার", tokens=[{"t": "Weiter", "bn": "পরবর্তী"}]),
                w("Zurück", "পেছনে / পূর্ববর্তী", "ৎসুরু্যক", tokens=[{"t": "Zurück", "bn": "পেছনে"}]),
                w("Fertig", "সম্পন্ন / শেষ", "ফেয়ার্টিখ্", tokens=[{"t": "Fertig", "bn": "সম্পন্ন"}]),
                w("Wiederholen", "পুনরায় শুনুন", "ভিডাহোলেন", tokens=[{"t": "Wiederholen", "bn": "পুনরায় শুনুন"}]),
                w("Einstellungen", "সেটিংস", "আইনশ্টেলুঙ্গেন", tokens=[{"t": "Einstellungen", "bn": "সেটিংস"}]),
                w("Lektion", "লেসন / পাঠ", "লেকৎসিওন", gender="f", tokens=[{"t": "Lektion", "bn": "পাঠ"}]),
            ]
        }
    ]
}

def main():
    print(f"Writing {len(units)} Stage 0 units to {UNITS_DIR}...")
    for uid, data in units.items():
        path = UNITS_DIR / f"{uid}.json"
        path.write_text(json.dumps(data, ensure_ascii=False, indent=2) + "\n", encoding="utf-8")
        total_items = sum(len(l["items"]) for l in data["lessons"])
        print(f"  {uid}.json: {len(data['lessons'])} lessons, {total_items} items")

if __name__ == "__main__":
    main()

