"""Generates Level A1 Part 1 (Units a1-01 to a1-07) for German Spoken Course."""
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

def pat(target, bn, pron, tokens):
    return {"type": "pattern", "target": target, "bn": bn, "bn_pron": pron, "tokens": tokens}

units = {}

# -------------------------------------------------------------
# Unit a1-01: নিজের পরিচয় ও নাম-ধাম (Sich vorstellen)
# -------------------------------------------------------------
units["a1-01"] = {
    "title_bn": "নিজের পরিচয় ও নাম-ধাম",
    "title_target": "Sich vorstellen: Name & Begrüßung",
    "lessons": [
        {
            "title_bn": "নাম ও কুশল বিনিময় (Wie heißen Sie?)",
            "title_target": "Name und Befinden",
            "intro_bn": "জার্মানিতে আনুষ্ঠানিক পরিচয়ে 'Sie' (আপনি) এবং heißen / sein ক্রিয়াপদ ব্যবহৃত হয়।",
            "structure": ["Frage", "Antwort", "Befinden"],
            "items": [
                s("Wie heißen Sie?", "আপনার নাম কী?", "ভী হাইসেন যী", [{"t": "Wie", "bn": "কী/কেমন"}, {"t": "heißen", "bn": "নাম"}, {"t": "Sie?", "bn": "আপনার"}]),
                s("Ich heiße Hasan.", "আমার নাম হাসান।", "ইখ্ হাইসে হাসান", [{"t": "Ich", "bn": "আমি"}, {"t": "heiße", "bn": "নাম"}, {"t": "Hasan.", "bn": "হাসান"}]),
                s("Wer sind Sie?", "আপনি কে?", "ভেয়ার জিন্ট যী", [{"t": "Wer", "bn": "কে"}, {"t": "sind", "bn": "হন"}, {"t": "Sie?", "bn": "আপনি"}]),
                s("Ich bin Maria.", "আমি মারিয়া।", "ইখ্ বিন মারিয়া", [{"t": "Ich", "bn": "আমি"}, {"t": "bin", "bn": "হই"}, {"t": "Maria.", "bn": "মারিয়া"}]),
                s("Mein Name ist Thomas.", "আমার নাম টমাস।", "মাইন নামে ইস্ত টমাস", [{"t": "Mein", "bn": "আমার"}, {"t": "Name", "bn": "নাম"}, {"t": "ist", "bn": "হয়"}, {"t": "Thomas.", "bn": "টমাস"}]),
                s("Wie geht es Ihnen?", "আপনি কেমন আছেন?", "ভী গেট এস ইনেন", [{"t": "Wie", "bn": "কেমন"}, {"t": "geht", "bn": "যায়"}, {"t": "es", "bn": "এটি"}, {"t": "Ihnen?", "bn": "আপনার"}]),
                s("Danke, gut. Und Ihnen?", "ধন্যবাদ, ভালো। আর আপনি?", "ডাঙ্কে গুট। উন্ট ইনেন", [{"t": "Danke,", "bn": "ধন্যবাদ"}, {"t": "gut.", "bn": "ভালো"}, {"t": "Und", "bn": "এবং"}, {"t": "Ihnen?", "bn": "আপনার"}]),
                s("Sehr gut, danke!", "খুব ভালো, ধন্যবাদ!", "জেয়ার গুট ডাঙ্কে", [{"t": "Sehr", "bn": "খুব"}, {"t": "gut,", "bn": "ভালো"}, {"t": "danke!", "bn": "ধন্যবাদ"}]),
            ]
        },
        {
            "title_bn": "আপনি ও তুমি রূপ (Sie vs. du)",
            "title_target": "Höflichkeitsform & Duzen",
            "intro_bn": "অপরিচিত বা বয়স্কদের সম্মান দিয়ে 'Sie' এবং সহপাঠী বা বন্ধুদের 'du' বলতে হয়। ক্রিয়াপদের শেষাংশও পরিবর্তিত হয় (-en বনাম -st)।",
            "structure": ["Sie-Form", "du-Form", "Vergleich"],
            "items": [
                s("Wie heißt du?", "তোমার নাম কী?", "ভী হাইস্ট দু", [{"t": "Wie", "bn": "কী"}, {"t": "heißt", "bn": "নাম"}, {"t": "du?", "bn": "তোমার"}]),
                s("Ich heiße Lukas.", "আমার নাম লুকাস।", "ইখ্ হাইসে লুকাস", [{"t": "Ich", "bn": "আমার"}, {"t": "heiße", "bn": "নাম"}, {"t": "Lukas.", "bn": "লুকাস"}]),
                s("Wie geht es dir?", "তুমি কেমন আছো?", "ভী গেট এস ডিয়ার", [{"t": "Wie", "bn": "কেমন"}, {"t": "geht", "bn": "যায়"}, {"t": "es", "bn": "এটি"}, {"t": "dir?", "bn": "তোমার"}]),
                s("Es geht mir super.", "আমি দারুণ আছি।", "এস গেট মিয়ার সুপার", [{"t": "Es", "bn": "এটি"}, {"t": "geht", "bn": "যায়"}, {"t": "mir", "bn": "আমার"}, {"t": "super.", "bn": "চমৎকার"}]),
                s("Und wer bist du?", "আর তুমি কে?", "উন্ট ভেয়ার বিস্ট দু", [{"t": "Und", "bn": "আর"}, {"t": "wer", "bn": "কে"}, {"t": "bist", "bn": "হও"}, {"t": "du?", "bn": "তুমি"}]),
                s("Ich bin Anna.", "আমি আনা।", "ইখ্ বিন আনা", [{"t": "Ich", "bn": "আমি"}, {"t": "bin", "bn": "হই"}, {"t": "Anna.", "bn": "আনা"}]),
                s("Freut mich sehr!", "আপনার সাথে পরিচিত হয়ে ভালো লাগলো!", "ফ্রয়ট নিখ্ জেয়ার", [{"t": "Freut", "bn": "আনন্দিত করে"}, {"t": "mich", "bn": "আমাকে"}, {"t": "sehr!", "bn": "খুব"}]),
                s("Angenehm!", "আনন্দিত হলাম!", "আনগেনেহম", [{"t": "Angenehm!", "bn": "আনন্দিত হলাম"}]),
            ]
        },
        {
            "title_bn": "কোথায় থাকেন ও বাসস্থান (wohnen)",
            "title_target": "Wohnort angeben",
            "intro_bn": "বাসস্থান সম্পর্কে জানতে 'Wo' (কোথায়) এবং 'in' (এ/মধ্যে) প্রেপজিশন ব্যবহৃত হয়।",
            "structure": ["Frage (Wo)", "Präposition (in)", "Ort"],
            "items": [
                s("Wo wohnen Sie?", "আপনি কোথায় থাকেন?", "ভো ভোনেন যী", [{"t": "Wo", "bn": "কোথায়"}, {"t": "wohnen", "bn": "থাকেন"}, {"t": "Sie?", "bn": "আপনি"}]),
                s("Ich wohne in Berlin.", "আমি বার্লিনে থাকি।", "ইখ্ ভোনে ইন বের্লিন", [{"t": "Ich", "bn": "আমি"}, {"t": "wohne", "bn": "থাকি"}, {"t": "in", "bn": "এ"}, {"t": "Berlin.", "bn": "বার্লিন"}]),
                s("Wo wohnst du?", "তুমি কোথায় থাকো?", "ভো ভোনস্ট দু", [{"t": "Wo", "bn": "কোথায়"}, {"t": "wohnst", "bn": "থাকো"}, {"t": "du?", "bn": "তুমি"}]),
                s("Ich wohne in Dhaka.", "আমি ঢাকায় থাকি।", "ইখ্ ভোনে ইন ঢাকা", [{"t": "Ich", "bn": "আমি"}, {"t": "wohne", "bn": "থাকি"}, {"t": "in", "bn": "এ"}, {"t": "Dhaka.", "bn": "ঢাকা"}]),
                s("Wohnen Sie auch hier?", "আপনিও কি এখানে থাকেন?", "ভোনেন যী আউখ হিয়ার", [{"t": "Wohnen", "bn": "থাকেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "auch", "bn": "ও"}, {"t": "hier?", "bn": "এখানে"}]),
                s("Nein, ich wohne in Hamburg.", "না, আমি হামবুর্গে থাকি।", "নাইন ইখ্ ভোনে ইন হামবুর্গ", [{"t": "Nein,", "bn": "না"}, {"t": "ich", "bn": "আমি"}, {"t": "wohne", "bn": "থাকি"}, {"t": "in", "bn": "এ"}, {"t": "Hamburg.", "bn": "হামবুর্গ"}]),
                s("Das ist in Deutschland.", "এটা জার্মানিতে।", "ডাস ইস্ত ইন ডয়চলান্ট", [{"t": "Das", "bn": "এটা"}, {"t": "ist", "bn": "হয়"}, {"t": "in", "bn": "এ"}, {"t": "Deutschland.", "bn": "জার্মানি"}]),
                s("Wo liegt das?", "এটা কোথায় অবস্থিত?", "ভো লীখ্ট ডাস", [{"t": "Wo", "bn": "কোথায়"}, {"t": "liegt", "bn": "অবস্থিত"}, {"t": "das?", "bn": "এটা"}]),
            ]
        },
        {
            "title_bn": "পরিচয় পর্বের সম্পূর্ণ বাক্য ও ড্রিল",
            "title_target": "Vorstellung komplett",
            "intro_bn": "নিজের নাম ও শহর একটানা গুছিয়ে বলার স্পোকেন অনুশীলন।",
            "structure": ["Satzgefüge", "Fließendes Sprechen", "Profil"],
            "items": [
                s("Hallo, ich heiße Tariq.", "হ্যালো, আমার নাম তারিক।", "হালো ইখ্ হাইসে তারিক", [{"t": "Hallo,", "bn": "হ্যালো"}, {"t": "ich", "bn": "আমি"}, {"t": "heiße", "bn": "নাম"}, {"t": "Tariq.", "bn": "তারিক"}]),
                s("Ich wohne jetzt in Frankfurt.", "আমি এখন ফ্রাঙ্কফুর্টে থাকি।", "ইখ্ ভোনে ইয়েৎস্ট ইন ফ্রাঙ্কফুর্ট", [{"t": "Ich", "bn": "আমি"}, {"t": "wohne", "bn": "থাকি"}, {"t": "jetzt", "bn": "এখন"}, {"t": "in", "bn": "এ"}, {"t": "Frankfurt.", "bn": "ফ্রাঙ্কফুর্ট"}]),
                s("Das ist meine Freundin Sarah.", "ইনি আমার বান্ধবী সারা।", "ডাস ইস্ত মাইনে ফ্রয়নডিন সারা", [{"t": "Das", "bn": "ইনি"}, {"t": "ist", "bn": "হন"}, {"t": "meine", "bn": "আমার"}, {"t": "Freundin", "bn": "বান্ধবী"}, {"t": "Sarah.", "bn": "সারা"}]),
                s("Sie wohnt in München.", "সে মিউনিখে থাকে।", "যী ভোনট ইন ম্যুনশেন", [{"t": "Sie", "bn": "সে"}, {"t": "wohnt", "bn": "থাকে"}, {"t": "in", "bn": "এ"}, {"t": "München.", "bn": "মিউনিখ"}]),
                s("Wir lernen zusammen Deutsch.", "আমরা একসাথে জার্মান শিখছি।", "ভির লের্নেন ৎসুসামেন ডয়চ", [{"t": "Wir", "bn": "আমরা"}, {"t": "lernen", "bn": "শিখছি"}, {"t": "zusammen", "bn": "একসাথে"}, {"t": "Deutsch.", "bn": "জার্মান"}]),
                s("Deutsch ist sehr interessant.", "জার্মান ভাষা খুবই চমৎকার।", "ডয়চ ইস্ত জেয়ার ইন্টারেসান্ট", [{"t": "Deutsch", "bn": "জার্মান"}, {"t": "ist", "bn": "হয়"}, {"t": "sehr", "bn": "খুব"}, {"t": "interessant.", "bn": "চমৎকার"}]),
                s("Schön, Sie kennenzulernen!", "আপনার সাথে পরিচিত হতে পেরে ভালো লাগলো!", "শোয়ন যী কেনেনৎসুলেয়ার্নেন", [{"t": "Schön,", "bn": "সুন্দর"}, {"t": "Sie", "bn": "আপনাকে"}, {"t": "kennenzulernen!", "bn": "চিনতে পারা"}]),
                s("Auf Wiedersehen, bis bald!", "বিদায়, শীঘ্রই দেখা হবে!", "আউফ ভিডারজেহেন বিস বাল্ট", [{"t": "Auf", "bn": "পুনরায়"}, {"t": "Wiedersehen,", "bn": "দেখা"}, {"t": "bis", "bn": "পর্যন্ত"}, {"t": "bald!", "bn": "শীঘ্রই"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit a1-02: দেশ, ভাষা ও নাগরিকত্ব (Länder & Sprachen)
# -------------------------------------------------------------
units["a1-02"] = {
    "title_bn": "দেশ, ভাষা ও নাগরিকত্ব",
    "title_target": "Länder, Sprachen & Herkunft",
    "lessons": [
        {
            "title_bn": "দেশ ও কোথা থেকে এসেছেন (Woher kommen Sie?)",
            "title_target": "Herkunft erfragen",
            "intro_bn": "উৎস জানতে 'Woher' (কোথা থেকে) এবং 'aus' (থেকে) প্রেপজিশন ব্যবহৃত হয়।",
            "structure": ["Frage (Woher)", "Verb (kommen)", "Herkunftsland"],
            "items": [
                s("Woher kommen Sie?", "আপনি কোথা থেকে এসেছেন?", "ভোহের কমেন যী", [{"t": "Woher", "bn": "কোথা থেকে"}, {"t": "kommen", "bn": "আসেন"}, {"t": "Sie?", "bn": "আপনি"}]),
                s("Ich komme aus Bangladesch.", "আমি বাংলাদেশ থেকে এসেছি।", "ইখ্ কমে আউস বাংলাদেশ", [{"t": "Ich", "bn": "আমি"}, {"t": "komme", "bn": "আসি"}, {"t": "aus", "bn": "থেকে"}, {"t": "Bangladesch.", "bn": "বাংলাদেশ"}]),
                s("Woher kommst du?", "তুমি কোথা থেকে এসেছো?", "ভোহের কমস্ট দু", [{"t": "Woher", "bn": "কোথা থেকে"}, {"t": "kommst", "bn": "এসেছো"}, {"t": "du?", "bn": "তুমি"}]),
                s("Ich komme aus Deutschland.", "আমি জার্মানি থেকে এসেছি।", "ইখ্ কমে আউস ডয়চলান্ট", [{"t": "Ich", "bn": "আমি"}, {"t": "komme", "bn": "আসি"}, {"t": "aus", "bn": "থেকে"}, {"t": "Deutschland.", "bn": "জার্মানি"}]),
                s("Er kommt aus Indien.", "সে ভারত থেকে এসেছে।", "এর কমট আউস ইন্ডিয়েন", [{"t": "Er", "bn": "সে"}, {"t": "kommt", "bn": "আসে"}, {"t": "aus", "bn": "থেকে"}, {"t": "Indien.", "bn": "ভারত"}]),
                s("Sie kommt aus Österreich.", "তিনি অস্ট্রিয়া থেকে এসেছেন।", "যী কমট আউস ওস্টেরাইখ", [{"t": "Sie", "bn": "তিনি"}, {"t": "kommt", "bn": "আসেন"}, {"t": "aus", "bn": "থেকে"}, {"t": "Österreich.", "bn": "অস্ট্রিয়া"}]),
                s("Kommen Sie aus Italien?", "আপনি কি ইতালি থেকে এসেছেন?", "কমেন যী আউস ইতালিয়েন", [{"t": "Kommen", "bn": "আসেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "aus", "bn": "থেকে"}, {"t": "Italien?", "bn": "ইতালি"}]),
                s("Nein, ich komme aus Spanien.", "না, আমি স্পেন থেকে এসেছি।", "নাইন ইখ্ কমে আউস শ্পানিয়েন", [{"t": "Nein,", "bn": "না"}, {"t": "ich", "bn": "আমি"}, {"t": "komme", "bn": "আসি"}, {"t": "aus", "bn": "থেকে"}, {"t": "Spanien.", "bn": "স্পেন"}]),
            ]
        },
        {
            "title_bn": "আর্টিকেলযুক্ত বিশেষ দেশসমূহ",
            "title_target": "Länder mit Artikel",
            "intro_bn": "বেশিরভাগ দেশের আগে আর্টিকেল লাগে না, তবে সুইজারল্যান্ড, তুরস্ক, ইরান বা মার্কিন যুক্তরাষ্ট্রের আগে আর্টিকেল আবশ্যক (aus der Schweiz, aus den USA)।",
            "structure": ["Land", "Artikel", "Dativendung"],
            "items": [
                s("Ich komme aus der Schweiz.", "আমি সুইজারল্যান্ড থেকে এসেছি।", "ইখ্ কমে আউস ডের শ্ভাইৎস", [{"t": "Ich", "bn": "আমি"}, {"t": "komme", "bn": "আসি"}, {"t": "aus", "bn": "থেকে"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Schweiz.", "bn": "সুইজারল্যান্ড"}]),
                s("Er kommt aus der Türkei.", "সে তুরস্ক থেকে এসেছে।", "এর কমট আউস ডের ত্যুর্কাই", [{"t": "Er", "bn": "সে"}, {"t": "kommt", "bn": "আসে"}, {"t": "aus", "bn": "থেকে"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Türkei.", "bn": "তুরস্ক"}]),
                s("Sie kommen aus den USA.", "তারা আমেরিকা থেকে এসেছে।", "যী কমেন আউস ডেন উ এস আ", [{"t": "Sie", "bn": "তারা"}, {"t": "kommen", "bn": "আসে"}, {"t": "aus", "bn": "থেকে"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "USA.", "bn": "আমেরিকা"}]),
                s("Mein Kollege kommt aus dem Iran.", "আমার সহকর্মী ইরান থেকে এসেছেন।", "মাইন কোলেগে কমট আউস ডেম ইরান", [{"t": "Mein", "bn": "আমার"}, {"t": "Kollege", "bn": "সহকর্মী"}, {"t": "kommt", "bn": "আসে"}, {"t": "aus", "bn": "থেকে"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Iran.", "bn": "ইরান"}]),
                s("Wir fliegen in die Schweiz.", "আমরা সুইজারল্যান্ডে যাচ্ছি (বিমানে)।", "ভির ফ্লীগেন ইন ডী শ্ভাইৎস", [{"t": "Wir", "bn": "আমরা"}, {"t": "fliegen", "bn": "উড়ছি"}, {"t": "in", "bn": "তে"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Schweiz.", "bn": "সুইজারল্যান্ড"}]),
                s("Wohnen Sie in der Türkei?", "আপনি কি তুরস্কে থাকেন?", "ভোনেন যী ইন ডের ত্যুর্কাই", [{"t": "Wohnen", "bn": "থাকেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "in", "bn": "এ"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Türkei?", "bn": "তুরস্ক"}]),
                s("Das ist ein schönes Land.", "এটি একটি সুন্দর দেশ।", "ডাস ইস্ত আইন শোয়নেস লান্ট", [{"t": "Das", "bn": "এটি"}, {"t": "ist", "bn": "হয়"}, {"t": "ein", "bn": "একটি"}, {"t": "schönes", "bn": "সুন্দর"}, {"t": "Land.", "bn": "দেশ"}]),
                s("Ich liebe dieses Land.", "আমি এই দেশটিকে ভালোবাসি।", "ইখ্ লীবে ডীসেস লান্ট", [{"t": "Ich", "bn": "আমি"}, {"t": "liebe", "bn": "ভালোবাসি"}, {"t": "dieses", "bn": "এই"}, {"t": "Land.", "bn": "দেশ"}]),
            ]
        },
        {
            "title_bn": "কে কোন ভাষায় কথা বলে (sprechen)",
            "title_target": "Sprachen sprechen",
            "intro_bn": "sprechen ক্রিয়াপদে du ও er/sie-তে ভেতরের 'e' বদলে 'i' হয়ে যায় (du sprichst, er spricht)।",
            "structure": ["Subjekt", "Verbform", "Sprache"],
            "items": [
                s("Welche Sprachen sprechen Sie?", "আপনি কোন কোন ভাষায় কথা বলেন?", "ভেলখে শ্প প্রাখেন শ্প্রেখেন যী", [{"t": "Welche", "bn": "কোন"}, {"t": "Sprachen", "bn": "ভাষায়"}, {"t": "sprechen", "bn": "বলেন"}, {"t": "Sie?", "bn": "আপনি"}]),
                s("Ich spreche Bengalisch und Englisch.", "আমি বাংলা এবং ইংরেজি বলি।", "ইখ্ শ্প্রেখে বেঙ্গালিশ উন্ট এংলিশ", [{"t": "Ich", "bn": "আমি"}, {"t": "spreche", "bn": "বলি"}, {"t": "Bengalisch", "bn": "বাংলা"}, {"t": "und", "bn": "এবং"}, {"t": "Englisch.", "bn": "ইংরেজি"}]),
                s("Sprichst du Deutsch?", "তুমি কি জার্মান বলতে পারো?", "শ্প্রিখস্ট দু ডয়চ", [{"t": "Sprichst", "bn": "বলো"}, {"t": "du", "bn": "তুমি"}, {"t": "Deutsch?", "bn": "জার্মান"}]),
                s("Ja, ich lerne jetzt Deutsch.", "হ্যাঁ, আমি এখন জার্মান শিখছি।", "ইয়া ইখ্ লের্নে ইয়েৎস্ট ডয়চ", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "ich", "bn": "আমি"}, {"t": "lerne", "bn": "শিখছি"}, {"t": "jetzt", "bn": "এখন"}, {"t": "Deutsch.", "bn": "জার্মান"}]),
                s("Er spricht sehr gut Deutsch.", "সে খুব ভালো জার্মান বলে।", "এর শ্প্রিখট জেয়ার গুট ডয়চ", [{"t": "Er", "bn": "সে"}, {"t": "spricht", "bn": "বলে"}, {"t": "sehr", "bn": "খুব"}, {"t": "gut", "bn": "ভালো"}, {"t": "Deutsch.", "bn": "জার্মান"}]),
                s("Ich spreche nur ein bisschen Deutsch.", "আমি কেবল অল্প একটু জার্মান বলি।", "ইখ্ শ্প্রেখে নুর আইন বিসখেন ডয়চ", [{"t": "Ich", "bn": "আমি"}, {"t": "spreche", "bn": "বলি"}, {"t": "nur", "bn": "কেবল"}, {"t": "ein", "bn": "এক"}, {"t": "bisschen", "bn": "একটু"}, {"t": "Deutsch.", "bn": "জার্মান"}]),
                s("Meine Muttersprache ist Bengalisch.", "আমার মাতৃভাষা বাংলা।", "মাইনে মুটারশ্প প্রাখে ইস্ত বেঙ্গালিশ", [{"t": "Meine", "bn": "আমার"}, {"t": "Muttersprache", "bn": "মাতৃভাষা"}, {"t": "ist", "bn": "হয়"}, {"t": "Bengalisch.", "bn": "বাংলা"}]),
                s("Wir sprechen alle Englisch.", "আমরা সবাই ইংরেজি বলি।", "ভির শ্প্রেখেন আলে এংলিশ", [{"t": "Wir", "bn": "আমরা"}, {"t": "sprechen", "bn": "বলি"}, {"t": "alle", "bn": "সবাই"}, {"t": "Englisch.", "bn": "ইংরেজি"}]),
            ]
        },
        {
            "title_bn": "জাতীয়তা ও পরিচিতি (Nationalitäten)",
            "title_target": "Nationalität angeben",
            "intro_bn": "পুরুষ ও নারী জাতীয়তায় সামান্য পার্থক্য থাকে, যেমন: Deutscher বনাম Deutsche।",
            "structure": ["Person", "Kopula", "Nationalität"],
            "items": [
                s("Sind Sie Deutscher?", "আপনি কি জার্মান (পুরুষ)?", "জিন্ট যী ডয়চার", [{"t": "Sind", "bn": "হন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "Deutscher?", "bn": "জার্মান"}]),
                s("Nein, ich bin Bangladescher.", "না, আমি বাংলাদেশি।", "নাইন ইখ্ বিন বাংলাদেশার", [{"t": "Nein,", "bn": "না"}, {"t": "ich", "bn": "আমি"}, {"t": "bin", "bn": "হই"}, {"t": "Bangladescher.", "bn": "বাংলাদেশি"}]),
                s("Meine Kollegin ist Deutsche.", "আমার সহকর্মী জার্মান (নারী)।", "মাইনে কোলেগিন ইস্ত ডয়চে", [{"t": "Meine", "bn": "আমার"}, {"t": "Kollegin", "bn": "সহকর্মী"}, {"t": "ist", "bn": "হন"}, {"t": "Deutsche.", "bn": "জার্মান"}]),
                s("Er ist Franzose.", "সে ফরাসি।", "এর ইস্ত ফ্রানৎসোজে", [{"t": "Er", "bn": "সে"}, {"t": "ist", "bn": "হয়"}, {"t": "Franzose.", "bn": "ফরাসি"}]),
                s("Sie ist Italienerin.", "তিনি ইতালীয় (নারী)।", "যী ইস্ত ইতালিয়েনেরিন", [{"t": "Sie", "bn": "তিনি"}, {"t": "ist", "bn": "হন"}, {"t": "Italienerin.", "bn": "ইতালীয়"}]),
                s("Wir sind internationale Studenten.", "আমরা আন্তর্জাতিক শিক্ষার্থী।", "ভির জিন্ট ইন্টারনাসিওনালে শ্টুডেন্টেন", [{"t": "Wir", "bn": "আমরা"}, {"t": "sind", "bn": "হই"}, {"t": "internationale", "bn": "আন্তর্জাতিক"}, {"t": "Studenten.", "bn": "শিক্ষার্থী"}]),
                s("Berlin ist sehr international.", "বার্লিন খুবই আন্তর্জাতিক শহর।", "বের্লিন ইস্ত জেয়ার ইন্টারনাসিওনাল", [{"t": "Berlin", "bn": "বার্লিন"}, {"t": "ist", "bn": "হয়"}, {"t": "sehr", "bn": "খুব"}, {"t": "international.", "bn": "আন্তর্জাতিক"}]),
                s("Viele Menschen leben hier.", "অনেক মানুষ এখানে বাস করে।", "ফীলে মেনশেন লেবেন হিয়ার", [{"t": "Viele", "bn": "অনেক"}, {"t": "Menschen", "bn": "মানুষ"}, {"t": "leben", "bn": "বাস করে"}, {"t": "hier.", "bn": "এখানে"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit a1-03: পরিবার ও আত্মীয়স্বজন (Familie & Possessivpronomen)
# -------------------------------------------------------------
units["a1-03"] = {
    "title_bn": "পরিবার ও আত্মীয়স্বজন",
    "title_target": "Familie & Possessivpronomen",
    "lessons": [
        {
            "title_bn": "পরিবারের প্রধান সদস্য (Vater, Mutter, Kind)",
            "title_target": "Kernfamilie",
            "intro_bn": "জার্মান ভাষায় বাবা der Vater, মা die Mutter, সন্তান das Kind এবং বাবা-মা die Eltern।",
            "structure": ["Artikel", "Nomen", "Bedeutung"],
            "items": [
                w("der Vater", "বাবা", "ডের ফাটার", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Vater", "bn": "বাবা"}]),
                w("die Mutter", "মা", "ডী মুটার", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Mutter", "bn": "মা"}]),
                w("das Kind", "সন্তান / বাচ্চা", "ডাস কিন্ট", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Kind", "bn": "সন্তান"}]),
                w("die Eltern", "বাবা-মা / পিতা-মাতা", "ডী এলটার্ন", tokens=[{"t": "die", "bn": "টি"}, {"t": "Eltern", "bn": "বাবা-মা"}]),
                w("der Sohn", "ছেলে / পুত্র", "ডের জোন", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Sohn", "bn": "ছেলে"}]),
                w("die Tochter", "মেয়ে / কন্যা", "ডী টখটার", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Tochter", "bn": "মেয়ে"}]),
                w("die Kinder", "সন্তানরা / বাচ্চারা", "ডী কিন্ডার", tokens=[{"t": "die", "bn": "গুলো"}, {"t": "Kinder", "bn": "বাচ্চারা"}]),
                w("die Familie", "পরিবার", "ডী ফামিলিয়ে", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Familie", "bn": "পরিবার"}]),
            ]
        },
        {
            "title_bn": "ভাইবোন ও আত্মীয়স্বজন (Geschwister)",
            "title_target": "Geschwister & Verwandte",
            "intro_bn": "ভাই der Bruder, বোন die Schwester, ভাইবোন একসাথে die Geschwister।",
            "structure": ["Bezeichnung", "Geschlecht", "Verwandtschaft"],
            "items": [
                w("der Bruder", "ভাই", "ডের ব্রুডার", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Bruder", "bn": "ভাই"}]),
                w("die Schwester", "বোন", "ডী শ্ভেস্টার", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Schwester", "bn": "বোন"}]),
                w("die Geschwister", "ভাইবোন", "ডী গেশ্ভিস্টার", tokens=[{"t": "die", "bn": "গুলো"}, {"t": "Geschwister", "bn": "ভাইবোন"}]),
                w("der Großvater", "দাদু / নানা", "ডের গ্রোসফাটার", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Großvater", "bn": "দাদু"}]),
                w("die Großmutter", "দাদি / নানি", "ডী গ্রোসমুটার", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Großmutter", "bn": "দাদি"}]),
                w("der Onkel", "চাচা / মামা / খালু", "ডের অঙ্কেল", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Onkel", "bn": "চাচা"}]),
                w("die Tante", "ফুফু / খালা / চাচি", "ডী টান্টে", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Tante", "bn": "খালা"}]),
                w("der Cousin", "মামাতো/চাচাতো ভাই", "ডের কুজেং", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Cousin", "bn": "ভাই"}]),
            ]
        },
        {
            "title_bn": "আমার ও তোমার সম্বন্ধপদ (mein, dein)",
            "title_target": "Possessivartikel: mein & dein",
            "intro_bn": "পুংলিঙ্গ ও ক্লীবলিঙ্গে mein/dein বসে, আর স্ত্রীলিঙ্গ ও বহুবচনে meine/deine বসে।",
            "structure": ["Possessiv", "Genus", "Beispielsatz"],
            "items": [
                s("Das ist mein Vater.", "ইনি আমার বাবা।", "ডাস ইস্ত মাইন ফাটার", [{"t": "Das", "bn": "ইনি"}, {"t": "ist", "bn": "হন"}, {"t": "mein", "bn": "আমার"}, {"t": "Vater.", "bn": "বাবা"}]),
                s("Das ist meine Mutter.", "ইনি আমার মা।", "ডাস ইস্ত মাইনে মুটার", [{"t": "Das", "bn": "ইনি"}, {"t": "ist", "bn": "হন"}, {"t": "meine", "bn": "আমার"}, {"t": "Mutter.", "bn": "মা"}]),
                s("Ist das dein Bruder?", "ইনি কি তোমার ভাই?", "ইস্ত ডাস ডাইন ব্রুডার", [{"t": "Ist", "bn": "হন"}, {"t": "das", "bn": "ইনি"}, {"t": "dein", "bn": "তোমার"}, {"t": "Bruder?", "bn": "ভাই"}]),
                s("Das ist meine Schwester.", "ইনি আমার বোন।", "ডাস ইস্ত মাইনে শ্ভেস্টার", [{"t": "Das", "bn": "ইনি"}, {"t": "ist", "bn": "হন"}, {"t": "meine", "bn": "আমার"}, {"t": "Schwester.", "bn": "বোন"}]),
                s("Das sind meine Eltern.", "এনারা আমার বাবা-মা।", "ডাস জিন্ট মাইনে এলটার্ন", [{"t": "Das", "bn": "এনারা"}, {"t": "sind", "bn": "হন"}, {"t": "meine", "bn": "আমার"}, {"t": "Eltern.", "bn": "বাবা-মা"}]),
                s("Wie alt ist dein Kind?", "তোমার সন্তানের বয়স কত?", "ভী আল্ট ইস্ত ডাইন কিন্ট", [{"t": "Wie", "bn": "কত"}, {"t": "alt", "bn": "বয়স"}, {"t": "ist", "bn": "হয়"}, {"t": "dein", "bn": "তোমার"}, {"t": "Kind?", "bn": "সন্তানের"}]),
                s("Mein Sohn ist fünf Jahre alt.", "আমার ছেলের বয়স পাঁচ বছর।", "মাইন জোন ইস্ত ফ্যুনফ ইয়াহরে আল্ট", [{"t": "Mein", "bn": "আমার"}, {"t": "Sohn", "bn": "ছেলের"}, {"t": "ist", "bn": "হয়"}, {"t": "fünf", "bn": "পাঁচ"}, {"t": "Jahre", "bn": "বছর"}, {"t": "alt.", "bn": "বয়স"}]),
                s("Meine Familie wohnt in Sylhet.", "আমার পরিবার সিলেটে থাকে।", "মাইনে ফামিলিয়ে ভোনট ইন সিলেট", [{"t": "Meine", "bn": "আমার"}, {"t": "Familie", "bn": "পরিবার"}, {"t": "wohnt", "bn": "থাকে"}, {"t": "in", "bn": "এ"}, {"t": "Sylhet.", "bn": "সিলেট"}]),
            ]
        },
        {
            "title_bn": "বৈবাহিক অবস্থা ও সন্তান (Familienstand)",
            "title_target": "Familienstand & Kinder",
            "intro_bn": "অফিসিয়াল ফর্ম পূরণ বা পরিচয় দিতে বৈবাহিক অবস্থার প্রয়োজনীয় পরিভাষা।",
            "structure": ["Status", "Aussage", "Bedeutung"],
            "items": [
                s("Ich bin ledig.", "আমি অবিবাহিত।", "ইখ্ বিন লেডিখ্", [{"t": "Ich", "bn": "আমি"}, {"t": "bin", "bn": "হই"}, {"t": "ledig.", "bn": "অবিবাহিত"}]),
                s("Sind Sie verheiratet?", "আপনি কি বিবাহিত?", "জিন্ট যী ফেয়ারহাইরাটেট", [{"t": "Sind", "bn": "হন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "verheiratet?", "bn": "বিবাহিত"}]),
                s("Ja, ich bin verheiratet.", "হ্যাঁ, আমি বিবাহিত।", "ইয়া ইখ্ বিন ফেয়ারহাইরাটেট", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "ich", "bn": "আমি"}, {"t": "bin", "bn": "হই"}, {"t": "verheiratet.", "bn": "বিবাহিত"}]),
                s("Haben Sie Kinder?", "আপনার কি সন্তান আছে?", "হাবের্ন যী কিন্ডার", [{"t": "Haben", "bn": "আছে"}, {"t": "Sie", "bn": "আপনার"}, {"t": "Kinder?", "bn": "সন্তান"}]),
                s("Ja, ich habe zwei Kinder.", "হ্যাঁ, আমার দুটি সন্তান আছে।", "ইয়া ইখ্ হাবে ৎস্ভাই কিন্ডার", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "ich", "bn": "আমার"}, {"t": "habe", "bn": "আছে"}, {"t": "zwei", "bn": "দুটি"}, {"t": "Kinder.", "bn": "সন্তান"}]),
                s("Nein, ich habe keine Kinder.", "না, আমার কোনো সন্তান নেই।", "নাইন ইখ্ হাবে কাইনে কিন্ডার", [{"t": "Nein,", "bn": "না"}, {"t": "ich", "bn": "আমার"}, {"t": "habe", "bn": "আছে"}, {"t": "keine", "bn": "কোনো না"}, {"t": "Kinder.", "bn": "সন্তান"}]),
                s("Ich lebe allein.", "আমি একা থাকি।", "ইখ্ লেবে আলাইন", [{"t": "Ich", "bn": "আমি"}, {"t": "lebe", "bn": "বাস করি"}, {"t": "allein.", "bn": "একা"}]),
                s("Er ist geschieden.", "তিনি তালাকপ্রাপ্ত।", "এর ইস্ত গেশীডেন", [{"t": "Er", "bn": "তিনি"}, {"t": "ist", "bn": "হন"}, {"t": "geschieden.", "bn": "তালাকপ্রাপ্ত"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit a1-04: পেশা ও কর্মক্ষেত্র (Berufe & Arbeitsplatz)
# -------------------------------------------------------------
units["a1-04"] = {
    "title_bn": "পেশা ও কর্মক্ষেত্র",
    "title_target": "Berufe & Arbeitswelt",
    "lessons": [
        {
            "title_bn": "পেশার নাম ও লিঙ্গভেদ (-in প্রত্যয়)",
            "title_target": "Männliche & weibliche Berufe",
            "intro_bn": "জার্মানিতে যেকোনো পুরুষ পেশার শেষে '-in' যুক্ত করলেই নারী রূপ তৈরি হয় (der Lehrer -> die Lehrerin)।",
            "structure": ["männlich", "weiblich", "Bedeutung"],
            "items": [
                w("der Lehrer", "শিক্ষক", "ডের লেরার", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Lehrer", "bn": "শিক্ষক"}]),
                w("die Lehrerin", "শিক্ষিকা", "ডী লেরারিন", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Lehrerin", "bn": "শিক্ষিকা"}]),
                w("der Arzt", "ডাক্তার (পুরুষ)", "ডের আর্ৎস্ট", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Arzt", "bn": "ডাক্তার"}]),
                w("die Ärztin", "ডাক্তার (নারী)", "ডী এয়ার্ৎসটিন", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Ärztin", "bn": "ডাক্তার"}]),
                w("der Ingenieur", "প্রকৌশলী (ইঞ্জিনিয়ার)", "ডের ইনশেনিয়োয়ার", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Ingenieur", "bn": "প্রকৌশলী"}]),
                w("die Ingenieurin", "প্রকৌশলী (নারী)", "ডী ইনশেনিয়োরিন", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Ingenieurin", "bn": "প্রকৌশলী"}]),
                w("der Student", "বিশ্ববিদ্যালয়ের ছাত্র", "ডের শ্টুডেন্ট", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Student", "bn": "ছাত্র"}]),
                w("die Studentin", "বিশ্ববিদ্যালয়ের ছাত্রী", "ডী শ্টুডেন্টিন", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Studentin", "bn": "ছাত্রী"}]),
            ]
        },
        {
            "title_bn": "পেশা ও পদবী জিজ্ঞাসা ও উত্তর",
            "title_target": "Beruf erfragen und nennen",
            "intro_bn": "পেশা বলতে ইংরেজিতে 'a' লাগলেও জার্মানে কোনো আর্টিকেল লাগে না: Ich bin Arzt (Ich bin ein Arzt নয়)।",
            "structure": ["Frage", "Berufsangabe", "Präposition als"],
            "items": [
                s("Was sind Sie von Beruf?", "পেশায় আপনি কী করেন?", "ভাস জিন্ট যী ফন বেরুফ", [{"t": "Was", "bn": "কী"}, {"t": "sind", "bn": "হন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "von", "bn": "অনুযায়ী"}, {"t": "Beruf?", "bn": "পেশা"}]),
                s("Ich bin Programmierer.", "আমি প্রোগ্রামার।", "ইখ্ বিন প্রগ্রামিয়ারার", [{"t": "Ich", "bn": "আমি"}, {"t": "bin", "bn": "হই"}, {"t": "Programmierer.", "bn": "প্রোগ্রামার"}]),
                s("Was machst du beruflich?", "তুমি পেশাগতভাবে কী করছো?", "ভাস মাখস্ট দু বেরুফলিখ", [{"t": "Was", "bn": "কী"}, {"t": "machst", "bn": "করো"}, {"t": "du", "bn": "তুমি"}, {"t": "beruflich?", "bn": "পেশাগতভাবে"}]),
                s("Ich arbeite als Verkäufer.", "আমি বিক্রেতা হিসেবে কাজ করি।", "ইখ্ আরবাইতে আলস ফেয়ারকয়ফার", [{"t": "Ich", "bn": "আমি"}, {"t": "arbeite", "bn": "কাজ করি"}, {"t": "als", "bn": "হিসেবে"}, {"t": "Verkäufer.", "bn": "বিক্রেতা"}]),
                s("Ich bin noch Student.", "আমি এখনও ছাত্র।", "ইখ্ বিন নখ শ্টুডেন্ট", [{"t": "Ich", "bn": "আমি"}, {"t": "bin", "bn": "হই"}, {"t": "noch", "bn": "এখনও"}, {"t": "Student.", "bn": "ছাত্র"}]),
                s("Sie arbeitet als Krankenschwester.", "তিনি সেবিকা (নার্স) হিসেবে কাজ করেন।", "যী আরবাইটেট আলস ক্রাঙ্কেনশ্ভেস্টার", [{"t": "Sie", "bn": "তিনি"}, {"t": "arbeitet", "bn": "কাজ করেন"}, {"t": "als", "bn": "হিসেবে"}, {"t": "Krankenschwester.", "bn": "নার্স"}]),
                s("Ich suche eine Arbeit.", "আমি একটি চাকরি খুঁজছি।", "ইখ্ জুখে আইনে আরবাইট", [{"t": "Ich", "bn": "আমি"}, {"t": "suche", "bn": "খুঁজছি"}, {"t": "eine", "bn": "একটি"}, {"t": "Arbeit.", "bn": "কাজ"}]),
                s("Er ist zurzeit arbeitslos.", "তিনি বর্তমানে কর্মহীন / বেকার।", "এর ইস্ত ৎসুরৎসাইট আরবাইটস্লোস", [{"t": "Er", "bn": "তিনি"}, {"t": "ist", "bn": "হন"}, {"t": "zurzeit", "bn": "বর্তমানে"}, {"t": "arbeitslos.", "bn": "বেকার"}]),
            ]
        },
        {
            "title_bn": "কর্মস্থল ও কোম্পানি (bei, in, an)",
            "title_target": "Arbeitsplatz & Arbeitgeber",
            "intro_bn": "কোনো কোম্পানিতে কাজ করতে 'bei' (যেমন bei BMW) এবং প্রতিষ্ঠানে কাজ করতে 'in/an' ব্যবহৃত হয়।",
            "structure": ["Präposition", "Firma/Ort", "Satz"],
            "items": [
                s("Wo arbeiten Sie?", "আপনি কোথায় কাজ করেন?", "ভো আরবাইতেন যী", [{"t": "Wo", "bn": "কোথায়"}, {"t": "arbeiten", "bn": "কাজ করেন"}, {"t": "Sie?", "bn": "আপনি"}]),
                s("Ich arbeite bei Siemens.", "আমি সিমেন্স কোম্পানিতে কাজ করি।", "ইখ্ আরবাইতে বাই যীমেন্স", [{"t": "Ich", "bn": "আমি"}, {"t": "arbeite", "bn": "কাজ করি"}, {"t": "bei", "bn": "এ"}, {"t": "Siemens.", "bn": "সিমেন্স"}]),
                s("Er arbeitet an der Universität.", "তিনি বিশ্ববিদ্যালয়ে কাজ করেন।", "এর আরবাইটেট আন ডের উনিভার্সিটেট", [{"t": "Er", "bn": "তিনি"}, {"t": "arbeitet", "bn": "কাজ করেন"}, {"t": "an", "bn": "এ"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Universität.", "bn": "বিশ্ববিদ্যালয়"}]),
                s("Sie arbeitet im Krankenhaus.", "তিনি হাসপাতালে কাজ করেন।", "যী আরবাইটেট ইম ক্রাঙ্কেনহাউস", [{"t": "Sie", "bn": "তিনি"}, {"t": "arbeitet", "bn": "কাজ করেন"}, {"t": "im", "bn": "এ"}, {"t": "Krankenhaus.", "bn": "হাসপাতাল"}]),
                s("Ich arbeite von zu Hause aus.", "আমি বাসা থেকে কাজ করি (Home Office)।", "ইখ্ আরবাইতে ফন ৎসু হাউজে আউস", [{"t": "Ich", "bn": "আমি"}, {"t": "arbeite", "bn": "কাজ করি"}, {"t": "von", "bn": "থেকে"}, {"t": "zu", "bn": "এ"}, {"t": "Hause", "bn": "বাড়ি"}, {"t": "aus.", "bn": "হতে"}]),
                s("Haben Sie heute Dienst?", "আপনার কি আজ ডিউটি আছে?", "হাবের্ন যী হয়টে ডীনস্ট", [{"t": "Haben", "bn": "আছে"}, {"t": "Sie", "bn": "আপনার"}, {"t": "heute", "bn": "আজ"}, {"t": "Dienst?", "bn": "ডিউটি"}]),
                s("Mein Büro ist sehr modern.", "আমার অফিস খুবই আধুনিক।", "মাইন ব্যুরো ইস্ত জেয়ার মোডার্ন", [{"t": "Mein", "bn": "আমার"}, {"t": "Büro", "bn": "অফিস"}, {"t": "ist", "bn": "হয়"}, {"t": "sehr", "bn": "খুব"}, {"t": "modern.", "bn": "আধুনিক"}]),
                s("Ich fahre mit dem Bus zur Arbeit.", "আমি বাসে করে কাজে যাই।", "ইখ্ ফাহরে মিট ডেম বুস ৎসুর আরবাইট", [{"t": "Ich", "bn": "আমি"}, {"t": "fahre", "bn": "যাই"}, {"t": "mit", "bn": "দিয়ে"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Bus", "bn": "বাস"}, {"t": "zur", "bn": "এ"}, {"t": "Arbeit.", "bn": "কাজ"}]),
            ]
        },
        {
            "title_bn": "কর্মজীবনের দৈনন্দিন অনুভূতি ও কথা",
            "title_target": "Über die Arbeit sprechen",
            "intro_bn": "কাজের চাপ, ভালো লাগা বা ছুটির দিন নিয়ে কথা বলার সাবলীল এক্সপ্রেশন।",
            "structure": ["Gefühl", "Mitteilung", "Alltag"],
            "items": [
                s("Meine Arbeit macht viel Spaß.", "আমার কাজ করতে খুব আনন্দ লাগে।", "মাইনে আরবাইট মাখট ফীল শ্পাস", [{"t": "Meine", "bn": "আমার"}, {"t": "Arbeit", "bn": "কাজ"}, {"t": "macht", "bn": "দেয়"}, {"t": "viel", "bn": "অনেক"}, {"t": "Spaß.", "bn": "আনন্দ"}]),
                s("Ich habe heute viel zu tun.", "আমার আজ অনেক কাজ করার আছে।", "ইখ্ হাবে হয়টে ফীল ৎসু তুন", [{"t": "Ich", "bn": "আমার"}, {"t": "habe", "bn": "আছে"}, {"t": "heute", "bn": "আজ"}, {"t": "viel", "bn": "অনেক"}, {"t": "zu", "bn": "তে"}, {"t": "tun.", "bn": "করা"}]),
                s("Die Kollegen sind sehr nett.", "সহকর্মীরা খুবই চমৎকার/ভদ্র।", "ডী কোলেগেন জিন্ট জেয়ার নেট", [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Kollegen", "bn": "সহকর্মীরা"}, {"t": "sind", "bn": "হন"}, {"t": "sehr", "bn": "খুব"}, {"t": "nett.", "bn": "ভদ্র"}]),
                s("Wann haben Sie Feierabend?", "আপনার অফিস ছুটি কখন হয়?", "ভান হাবের্ন যী ফায়ারআবেন্ট", [{"t": "Wann", "bn": "কখন"}, {"t": "haben", "bn": "আছে"}, {"t": "Sie", "bn": "আপনার"}, {"t": "Feierabend?", "bn": "ছুটি"}]),
                s("Um siebzehn Uhr habe ich Feierabend.", "বিকাল পাঁচটায় আমার ছুটি।", "উম যীপৎসেন উর হাবে ইখ্ ফায়ারআবেন্ট", [{"t": "Um", "bn": "এ"}, {"t": "siebzehn", "bn": "সতেরো"}, {"t": "Uhr", "bn": "টায়"}, {"t": "habe", "bn": "পাই"}, {"t": "ich", "bn": "আমি"}, {"t": "Feierabend.", "bn": "ছুটি"}]),
                s("Ich mache eine Pause.", "আমি একটি বিরতি নিচ্ছি।", "ইখ্ মাখে আইনে পাউজে", [{"t": "Ich", "bn": "আমি"}, {"t": "mache", "bn": "নিচ্ছি"}, {"t": "eine", "bn": "একটি"}, {"t": "Pause.", "bn": "বিরতি"}]),
                s("Trinken wir einen Kaffee?", "চলুন এক কাপ কফি খাই?", "ট্রিঙ্কেন ভির আইনেন কাফে", [{"t": "Trinken", "bn": "পান করি"}, {"t": "wir", "bn": "আমরা"}, {"t": "einen", "bn": "এক"}, {"t": "Kaffee?", "bn": "কফি"}]),
                s("Ja gerne, gute Idee!", "হ্যাঁ সানন্দে, চমৎকার বুদ্ধি!", "ইয়া গেয়ার্নে গুটে ইডে", [{"t": "Ja", "bn": "হ্যাঁ"}, {"t": "gerne,", "bn": "সানন্দে"}, {"t": "gute", "bn": "ভালো"}, {"t": "Idee!", "bn": "বুদ্ধি"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit a1-05: খাবার, পানীয় ও কেনাকাটা (Essen & Einkaufen)
# -------------------------------------------------------------
units["a1-05"] = {
    "title_bn": "খাবার, পানীয় ও কেনাকাটা",
    "title_target": "Essen, Trinken & Einkaufen",
    "lessons": [
        {
            "title_bn": "মুদি কেনাকাটা ও খাবার দ্রব্য (der, die, das)",
            "title_target": "Lebensmittel & Artikel",
            "intro_bn": "প্রতিটি খাদ্য দ্রব্যের লিঙ্গ (Gender) মনে রাখা জরুরি: der Apfel, das Brot, die Milch।",
            "structure": ["Artikel", "Nahrungsmittel", "Bedeutung"],
            "items": [
                w("der Apfel", "আপেল", "ডের আপফেল", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Apfel", "bn": "আপেল"}]),
                w("das Brot", "রুটি", "ডাস ব্রোট", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Brot", "bn": "রুটি"}]),
                w("die Milch", "দুধ", "ডী মিলখ", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Milch", "bn": "দুধ"}]),
                w("der Käse", "পনির / চিজ", "ডের কেজে", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Käse", "bn": "পনির"}]),
                w("das Ei", "ডিম", "ডাস আই", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Ei", "bn": "ডিম"}]),
                w("das Fleisch", "মাংস", "ডাস ফ্লাইশ", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Fleisch", "bn": "মাংস"}]),
                w("der Reis", "চাল / ভাত", "ডের রাইস", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Reis", "bn": "ভাত"}]),
                w("das Gemüse", "শাকসবজি", "ডাস গেম্যূজে", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Gemüse", "bn": "সবজি"}]),
            ]
        },
        {
            "title_bn": "নির্দিষ্ট ও অনির্দিষ্ট আর্টিকেল (der vs. ein)",
            "title_target": "Bestimmter & Unbestimmter Artikel",
            "intro_bn": "পুংলিঙ্গ: der / ein; ক্লীবলিঙ্গ: das / ein; স্ত্রীলিঙ্গ: die / eine।",
            "structure": ["Bestimmt", "Unbestimmt", "Substantiv"],
            "items": [
                s("Das ist ein Apfel.", "এটি একটি আপেল।", "ডাস ইস্ত আইন আপফেল", [{"t": "Das", "bn": "এটি"}, {"t": "ist", "bn": "হয়"}, {"t": "ein", "bn": "একটি"}, {"t": "Apfel.", "bn": "আপেল"}]),
                s("Der Apfel ist rot.", "আপেলটি লাল।", "ডের আপফেল ইস্ত রোট", [{"t": "Der", "bn": "টি"}, {"t": "Apfel", "bn": "আপেল"}, {"t": "ist", "bn": "হয়"}, {"t": "rot.", "bn": "লাল"}]),
                s("Das ist ein Brot.", "এটি একটি রুটি।", "ডাস ইস্ত আইন ব্রোট", [{"t": "Das", "bn": "এটি"}, {"t": "ist", "bn": "হয়"}, {"t": "ein", "bn": "একটি"}, {"t": "Brot.", "bn": "রুটি"}]),
                s("Das Brot ist frisch.", "রুটিটি তাজা।", "ডাস ব্রোট ইস্ত ফ্রিশ", [{"t": "Das", "bn": "টি"}, {"t": "Brot", "bn": "রুটি"}, {"t": "ist", "bn": "হয়"}, {"t": "frisch.", "bn": "তাজা"}]),
                s("Das ist eine Banane.", "এটি একটি কলা।", "ডাস ইস্ত আইনে বানানে", [{"t": "Das", "bn": "এটি"}, {"t": "ist", "bn": "হয়"}, {"t": "eine", "bn": "একটি"}, {"t": "Banane.", "bn": "কলা"}]),
                s("Die Banane ist gelb.", "কলাটি হলুদ।", "ডী বানানে ইস্ত গেল্প", [{"t": "Die", "bn": "টি"}, {"t": "Banane", "bn": "কলা"}, {"t": "ist", "bn": "হয়"}, {"t": "gelb.", "bn": "হলুদ"}]),
                s("Ich brauche ein Ei.", "আমার একটি ডিম দরকার।", "ইখ্ ব্রাউখে আইন আই", [{"t": "Ich", "bn": "আমার"}, {"t": "brauche", "bn": "দরকার"}, {"t": "ein", "bn": "একটি"}, {"t": "Ei.", "bn": "ডিম"}]),
                s("Wir haben keine Eier.", "আমাদের কাছে ডিম নেই।", "ভির হাবের্ন কাইনে আয়ার", [{"t": "Wir", "bn": "আমাদের"}, {"t": "haben", "bn": "কাছে আছে"}, {"t": "keine", "bn": "কোনো না"}, {"t": "Eier.", "bn": "ডিমগুলো"}]),
            ]
        },
        {
            "title_bn": "না-বোধক কেনাকাটা (kein, keine)",
            "title_target": "Negation mit kein/keine",
            "intro_bn": "বিশেষ্য পদের আগে 'না' বোঝাতে kein (পুং/ক্লীব) এবং keine (স্ত্রী/বহুবচন) ব্যবহৃত হয়।",
            "structure": ["Subjekt", "Verb", "Negationsartikel"],
            "items": [
                s("Ich habe keinen Käse.", "আমার কাছে পনির নেই (Akkusativ)।", "ইখ্ হাবে কাইনেন কেজে", [{"t": "Ich", "bn": "আমার"}, {"t": "habe", "bn": "কাছে আছে"}, {"t": "keinen", "bn": "কোনো না"}, {"t": "Käse.", "bn": "পনির"}]),
                s("Wir brauchen kein Brot.", "আমাদের রুটি লাগবে না।", "ভির ব্রাউখেন কাইন ব্রোট", [{"t": "Wir", "bn": "আমাদের"}, {"t": "brauchen", "bn": "প্রয়োজন"}, {"t": "kein", "bn": "কোনো না"}, {"t": "Brot.", "bn": "রুটি"}]),
                s("Ich trinke keine Milch.", "আমি দুধ খাই না।", "ইখ্ ট্রিঙ্কে কাইনে মিলখ", [{"t": "Ich", "bn": "আমি"}, {"t": "trinke", "bn": "পান করি"}, {"t": "keine", "bn": "না"}, {"t": "Milch.", "bn": "দুধ"}]),
                s("Hier gibt es keinen Zucker.", "এখানে চিনি নেই।", "হিয়ার গিপ্ট এস কাইনেন ৎসুক্কার", [{"t": "Hier", "bn": "এখানে"}, {"t": "gibt", "bn": "দেয়"}, {"t": "es", "bn": "এটি"}, {"t": "keinen", "bn": "কোনো না"}, {"t": "Zucker.", "bn": "চিনি"}]),
                s("Haben Sie Äpfel?", "আপনাদের কি আপেল আছে?", "হাবের্ন যী এপফেল", [{"t": "Haben", "bn": "আছে"}, {"t": "Sie", "bn": "আপনাদের"}, {"t": "Äpfel?", "bn": "আপেলগুলো"}]),
                s("Nein, heute haben wir keine Äpfel.", "না, আজ আমাদের আপেল নেই।", "নাইন হয়টে হাবের্ন ভির কাইনে এপফেল", [{"t": "Nein,", "bn": "না"}, {"t": "heute", "bn": "আজ"}, {"t": "haben", "bn": "আছে"}, {"t": "wir", "bn": "আমাদের"}, {"t": "keine", "bn": "কোনো না"}, {"t": "Äpfel.", "bn": "আপেল"}]),
                s("Das ist kein Problem.", "এটা কোনো সমস্যা না।", "ডাস ইস্ত কাইন প্রবলেম", [{"t": "Das", "bn": "এটা"}, {"t": "ist", "bn": "হয়"}, {"t": "kein", "bn": "কোনো না"}, {"t": "Problem.", "bn": "সমস্যা"}]),
                s("Ich esse kein Fleisch.", "আমি মাংস খাই না।", "ইখ্ এসে কাইন ফ্লাইশ", [{"t": "Ich", "bn": "আমি"}, {"t": "esse", "bn": "খাই"}, {"t": "kein", "bn": "না"}, {"t": "Fleisch.", "bn": "মাংস"}]),
            ]
        },
        {
            "title_bn": "সুপারমার্কেটে পরিমাণ ও দরদাম (Was kostet das?)",
            "title_target": "Mengen & Preise im Markt",
            "intro_bn": "বাজারে এক কেজি, এক লিটার চাওয়া ও দাম জানার আবশ্যকীয় স্পোকেন এক্সপ্রেশন।",
            "structure": ["Mengenangabe", "Preisanfrage", "Kauf"],
            "items": [
                s("Was kostet das?", "এটার দাম কত?", "ভাস কস্টেট ডাস", [{"t": "Was", "bn": "কত/কী"}, {"t": "kostet", "bn": "দাম পড়ে"}, {"t": "das?", "bn": "এটার"}]),
                s("Das kostet zwei Euro.", "এটার দাম দুই ইউরো।", "ডাস কস্টেট ৎস্ভাই অয়রো", [{"t": "Das", "bn": "এটার"}, {"t": "kostet", "bn": "দাম পড়ে"}, {"t": "zwei", "bn": "দুই"}, {"t": "Euro.", "bn": "ইউরো"}]),
                s("Ich möchte ein Kilo Äpfel bitte.", "আমাকে দয়া করে এক কেজি আপেল দিন।", "ইখ্ মোয়খ্টে আইন কিলো এপফেল বিটে", [{"t": "Ich", "bn": "আমি"}, {"t": "möchte", "bn": "চাই"}, {"t": "ein", "bn": "এক"}, {"t": "Kilo", "bn": "কেজি"}, {"t": "Äpfel", "bn": "আপেল"}, {"t": "bitte.", "bn": "দয়া করে"}]),
                s("Geben Sie mir einen Liter Milch!", "আমাকে এক লিটার দুধ দিন!", "গেবেন যী মিয়ার আইনেন লিটার মিলখ", [{"t": "Geben", "bn": "দিন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "mir", "bn": "আমাকে"}, {"t": "einen", "bn": "এক"}, {"t": "Liter", "bn": "লিটার"}, {"t": "Milch!", "bn": "দুধ"}]),
                s("Sonst noch etwas?", "আর কিছু লাগবে কি?", "জনস্ট নখ এতভাস", [{"t": "Sonst", "bn": "এছাড়া"}, {"t": "noch", "bn": "আরও"}, {"t": "etwas?", "bn": "কিছু"}]),
                s("Nein danke, das ist alles.", "না ধন্যবাদ, এটুকুই।", "নাইন ডাঙ্কে ডাস ইস্ত আলেস", [{"t": "Nein", "bn": "না"}, {"t": "danke,", "bn": "ধন্যবাদ"}, {"t": "das", "bn": "এটা"}, {"t": "ist", "bn": "হয়"}, {"t": "alles.", "bn": "সব"}]),
                s("Das macht fünf Euro fünfzig.", "সব মিলিয়ে পাঁচ ইউরো পঞ্চাশ সেন্ট।", "ডাস মাখট ফ্যুনফ অয়রো ফ্যুনফৎসিখ", [{"t": "Das", "bn": "এটা"}, {"t": "macht", "bn": "করে"}, {"t": "fünf", "bn": "পাঁচ"}, {"t": "Euro", "bn": "ইউরো"}, {"t": "fünfzig.", "bn": "পঞ্চাশ"}]),
                s("Hier bitte, passend.", "এই নিন, ভাঙতি টাকা।", "হিয়ার বিটে পাসেন্ট", [{"t": "Hier", "bn": "এখানে"}, {"t": "bitte,", "bn": "নিন"}, {"t": "passend.", "bn": "সঠিক পরিমাণ"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit a1-06: রেস্তোরাঁ ও ক্যাফেতে অর্ডার (Im Restaurant)
# -------------------------------------------------------------
units["a1-06"] = {
    "title_bn": "রেস্তোরাঁ ও ক্যাফেতে অর্ডার",
    "title_target": "Im Restaurant & Café",
    "lessons": [
        {
            "title_bn": "মেনু ও খাবার পছন্দ (Ich möchte...)",
            "title_target": "Speisekarte & Bestellung",
            "intro_bn": "ভদ্রভাবে খাবার অর্ডার করতে 'Ich möchte...' (আমি চাই) এবং 'Ich nehme...' (আমি নেব) ব্যবহৃত হয়।",
            "structure": ["Wunschverb", "Gericht", "Höflichkeit"],
            "items": [
                s("Die Speisekarte bitte!", "মেনু কার্ডটি দিন দয়া করে!", "ডী শ্পাইজেকার্টে বিটে", [{"t": "Die", "bn": "টি"}, {"t": "Speisekarte", "bn": "মেনু"}, {"t": "bitte!", "bn": "দয়া করে"}]),
                s("Ich möchte eine Gemüsesuppe.", "আমি একটি সবজির স্যুপ চাই।", "ইখ্ মোয়খ্টে আইনে গেম্যূজেসুপে", [{"t": "Ich", "bn": "আমি"}, {"t": "möchte", "bn": "চাই"}, {"t": "eine", "bn": "একটি"}, {"t": "Gemüsesuppe.", "bn": "সবজির স্যুপ"}]),
                s("Ich nehme einen Salat.", "আমি একটি সালাদ নেব।", "ইখ্ নেমে আইনেন সালাট", [{"t": "Ich", "bn": "আমি"}, {"t": "nehme", "bn": "নিচ্ছি"}, {"t": "einen", "bn": "একটি"}, {"t": "Salat.", "bn": "সালাদ"}]),
                s("Was können Sie empfehlen?", "আপনি কী সুপারিশ করবেন?", "ভাস কোয়ন্নেন যী এম্পফেলেন", [{"t": "Was", "bn": "কী"}, {"t": "können", "bn": "পারেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "empfehlen?", "bn": "সুপারিশ করতে"}]),
                s("Haben Sie vegetarisches Essen?", "আপনাদের কি নিরামিষ খাবার আছে?", "হাবের্ন যী ভেগেটারিশেস এসেন", [{"t": "Haben", "bn": "আছে"}, {"t": "Sie", "bn": "আপনাদের"}, {"t": "vegetarisches", "bn": "নিরামিষ"}, {"t": "Essen?", "bn": "খাবার"}]),
                s("Für mich bitte ein Hähnchen.", "আমার জন্য দয়া করে একটি রোস্ট চিকেন।", "ফ্যুর নিখ্ বিটে আইন হেনখেন", [{"t": "Für", "bn": "জন্য"}, {"t": "mich", "bn": "আমার"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "ein", "bn": "একটি"}, {"t": "Hähnchen.", "bn": "মুরগি"}]),
                s("Sehr gerne, kommt sofort!", "সানন্দে, এক্ষুণি আসছে!", "জেয়ার গেয়ার্নে কমট জফর্ট", [{"t": "Sehr", "bn": "খুব"}, {"t": "gerne,", "bn": "সানন্দে"}, {"t": "kommt", "bn": "আসছে"}, {"t": "sofort!", "bn": "এক্ষুণি"}]),
                s("Guten Appetit!", "খাবার উপভোগ করুন! / শুভ আহার!", "গুটেন আপেটিট", [{"t": "Guten", "bn": "শুভ"}, {"t": "Appetit!", "bn": "ক্ষুধা/আহার"}]),
            ]
        },
        {
            "title_bn": "পানীয় অর্ডার করা (Getränke bestellen)",
            "title_target": "Getränke bestellen",
            "intro_bn": "পানীয়ের ক্ষেত্রে পুংলিঙ্গ আকুজাকটিভ 'einen' রূপ নেয় (einen Tee, einen Kaffee)।",
            "structure": ["Getränk", "Akkusativ", "Bestellung"],
            "items": [
                s("Was möchten Sie trinken?", "আপনি কী পান করতে চান?", "ভাস মোয়খ্টেন যী ট্রিঙ্কেন", [{"t": "Was", "bn": "কী"}, {"t": "möchten", "bn": "চান"}, {"t": "Sie", "bn": "আপনি"}, {"t": "trinken?", "bn": "পান করতে"}]),
                s("Ich möchte einen Kaffee bitte.", "আমি এক কাপ কফি চাই দয়া করে।", "ইখ্ মোয়খ্টে আইনেন কাফে বিটে", [{"t": "Ich", "bn": "আমি"}, {"t": "möchte", "bn": "চাই"}, {"t": "einen", "bn": "এক"}, {"t": "Kaffee", "bn": "কফি"}, {"t": "bitte.", "bn": "দয়া করে"}]),
                s("Ein Mineralwasser bitte.", "একটি মিনারেল ওয়াটার দিন দয়া করে।", "আইন মিনেরালভাসার বিটে", [{"t": "Ein", "bn": "একটি"}, {"t": "Mineralwasser", "bn": "মিনারেল ওয়াটার"}, {"t": "bitte.", "bn": "দয়া করে"}]),
                s("Mit Kohlensäure oder ohne?", "গ্যাসযুক্ত নাকি সাধারণ পানি?", "মিট কোলেনসয়রে ওডার ওনে", [{"t": "Mit", "bn": "সাথে"}, {"t": "Kohlensäure", "bn": "কার্বন/গ্যাস"}, {"t": "oder", "bn": "নাকি"}, {"t": "ohne?", "bn": "ছাড়া"}]),
                s("Ohne Kohlensäure bitte.", "গ্যাস ছাড়া (সাধারণ পানি) দয়া করে।", "ওনে কোলেনসয়রে বিটে", [{"t": "Ohne", "bn": "ছাড়া"}, {"t": "Kohlensäure", "bn": "কার্বন"}, {"t": "bitte.", "bn": "দয়া করে"}]),
                s("Einen schwarzen Tee bitte.", "একটি লাল চা দয়া করে।", "আইনেন শ্ভারৎসেন টে বিটে", [{"t": "Einen", "bn": "একটি"}, {"t": "schwarzen", "bn": "কালো"}, {"t": "Tee", "bn": "চা"}, {"t": "bitte.", "bn": "দয়া করে"}]),
                s("Mit Milch und Zucker?", "দুধ ও চিনি সহ?", "মিট মিলখ উন্ট ৎসুক্কার", [{"t": "Mit", "bn": "সাথে"}, {"t": "Milch", "bn": "দুধ"}, {"t": "und", "bn": "এবং"}, {"t": "Zucker?", "bn": "চিনি"}]),
                s("Nur mit Milch bitte.", "শুধু দুধ দিয়ে দয়া করে।", "নুর মিট মিলখ বিটে", [{"t": "Nur", "bn": "শুধু"}, {"t": "mit", "bn": "দিয়ে"}, {"t": "Milch", "bn": "দুধ"}, {"t": "bitte.", "bn": "দয়া করে"}]),
            ]
        },
        {
            "title_bn": "খাবার কেমন লাগলো ও প্রশংসা (Schmeckt es?)",
            "title_target": "Über das Essen sprechen",
            "intro_bn": "খাবার সুস্বাদু লাগলে 'schmecken' ক্রিয়াপদ ব্যবহৃত হয়: Das schmeckt sehr gut!",
            "structure": ["Verb schmecken", "Bewertung", "Reaktion"],
            "items": [
                s("Schmeckt es Ihnen?", "খাবার কেমন লাগছে আপনাদের?", "শমেকট এস ইনেন", [{"t": "Schmeckt", "bn": "স্বাদ লাগছে"}, {"t": "es", "bn": "এটি"}, {"t": "Ihnen?", "bn": "আপনাদের"}]),
                s("Ja, es schmeckt sehr gut!", "হ্যাঁ, এটা খুবই সুস্বাদু!", "ইয়া এস শমেকট জেয়ার গুট", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "es", "bn": "এটা"}, {"t": "schmeckt", "bn": "স্বাদ লাগছে"}, {"t": "sehr", "bn": "খুব"}, {"t": "gut!", "bn": "ভালো"}]),
                s("Das Essen ist lecker.", "খাবারটি খুবই মজাদার।", "ডাস এসেন ইস্ত লেকার", [{"t": "Das", "bn": "নির্দিষ্ট"}, {"t": "Essen", "bn": "খাবার"}, {"t": "ist", "bn": "হয়"}, {"t": "lecker.", "bn": "সুস্বাদু"}]),
                s("Sind Sie zufrieden?", "আপনারা কি সন্তুষ্ট?", "জিন্ট যী ৎসুফ্রীডেন", [{"t": "Sind", "bn": "হন"}, {"t": "Sie", "bn": "আপনারা"}, {"t": "zufrieden?", "bn": "সন্তুষ্ট"}]),
                s("Alles war wunderbar.", "সবকিছু চমৎকার ছিল।", "আলেস ভার ভুন্ডারবার", [{"t": "Alles", "bn": "সবকিছু"}, {"t": "war", "bn": "ছিল"}, {"t": "wunderbar.", "bn": "চমৎকার"}]),
                s("Möchten Sie noch etwas?", "আর কিছু কি লাগবে আপনাদের?", "মোয়খ্টেন যী নখ এতভাস", [{"t": "Möchten", "bn": "চান"}, {"t": "Sie", "bn": "আপনারা"}, {"t": "noch", "bn": "আরও"}, {"t": "etwas?", "bn": "কিছু"}]),
                s("Nein danke, wir sind satt.", "না ধন্যবাদ, আমাদের পেট ভরে গেছে।", "নাইন ডাঙ্কে ভির জিন্ট জাট", [{"t": "Nein", "bn": "না"}, {"t": "danke,", "bn": "ধন্যবাদ"}, {"t": "wir", "bn": "আমরা"}, {"t": "sind", "bn": "হই"}, {"t": "satt.", "bn": "পরিতৃপ্ত"}]),
                s("Bringen Sie uns die Rechnung!", "আমাদের বিলটি এনে দিন দয়া করে!", "ব্রিঙ্গেন যী উন্স ডী রেখনুং", [{"t": "Bringen", "bn": "এনে দিন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "uns", "bn": "আমাদের"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Rechnung!", "bn": "বিল"}]),
            ]
        },
        {
            "title_bn": "বিল চাওয়া ও পরিশোধ (Zahlen bitte!)",
            "title_target": "Bezahlen & Trinkgeld",
            "intro_bn": "বিল আলাদা দেবে নাকি একসাথে দেবে: 'Zusammen oder getrennt?' জার্মানিতে অত্যন্ত পরিচিত প্রশ্ন।",
            "structure": ["Rechnung", "Zahlweise", "Trinkgeld"],
            "items": [
                s("Wir möchten zahlen bitte.", "আমরা বিল দিতে চাই দয়া করে।", "ভির মোয়খ্টেন ৎসালেন বিটে", [{"t": "Wir", "bn": "আমরা"}, {"t": "möchten", "bn": "চাই"}, {"t": "zahlen", "bn": "পরিশোধ করতে"}, {"t": "bitte.", "bn": "দয়া করে"}]),
                s("Zusammen oder getrennt?", "একসাথে নাকি আলাদা আলাদা?", "ৎসুসামেন ওডার গেট্রেনট", [{"t": "Zusammen", "bn": "একসাথে"}, {"t": "oder", "bn": "নাকি"}, {"t": "getrennt?", "bn": "আলাদা"}]),
                s("Getrennt bitte.", "আলাদা আলাদা দয়া করে।", "গেট্রেনট বিটে", [{"t": "Getrennt", "bn": "আলাদা"}, {"t": "bitte.", "bn": "দয়া করে"}]),
                s("Kann ich mit Karte zahlen?", "আমি কি কার্ড দিয়ে পেমেন্ট করতে পারব?", "কান ইখ্ মিট কার্টে ৎসালেন", [{"t": "Kann", "bn": "পারি"}, {"t": "ich", "bn": "আমি"}, {"t": "mit", "bn": "দিয়ে"}, {"t": "Karte", "bn": "কার্ড"}, {"t": "zahlen?", "bn": "পরিশোধ করতে"}]),
                s("Ja, natürlich geht das.", "হ্যাঁ, অবশ্যই কার্ডে দেওয়া যাবে।", "ইয়া নাত্যুরলিখ গেট ডাস", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "natürlich", "bn": "অবশ্যই"}, {"t": "geht", "bn": "যায়"}, {"t": "das.", "bn": "তা"}]),
                s("Das macht zwanzig Euro.", "মোট বিশ ইউরো হয়েছে।", "ডাস মাখট ৎস্ভানৎসিখ্ অয়রো", [{"t": "Das", "bn": "এটা"}, {"t": "macht", "bn": "হয়"}, {"t": "zwanzig", "bn": "বিশ"}, {"t": "Euro.", "bn": "ইউরো"}]),
                s("Stimmt so, danke!", "ভাঙতি লাগবে না / টিপস রাখুন, ধন্যবাদ!", "শ্টিমট জো ডাঙ্কে", [{"t": "Stimmt", "bn": "ঠিক আছে"}, {"t": "so,", "bn": "এভাবেই"}, {"t": "danke!", "bn": "ধন্যবাদ"}]),
                s("Vielen Dank, schönen Tag noch!", "অনেক ধন্যবাদ, দিনটি শুভ হোক!", "ফিলেন ডাঙ্ক শোয়নেন তাক নখ", [{"t": "Vielen", "bn": "অনেক"}, {"t": "Dank,", "bn": "ধন্যবাদ"}, {"t": "schönen", "bn": "সুন্দর"}, {"t": "Tag", "bn": "দিন"}, {"t": "noch!", "bn": "হোক"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit a1-07: সময়, দিন, মাস ও ঋতু (Uhrzeit & Daten)
# -------------------------------------------------------------
units["a1-07"] = {
    "title_bn": "সময়, দিন, মাস ও ঋতু",
    "title_target": "Uhrzeit, Wochentage & Jahreszeiten",
    "lessons": [
        {
            "title_bn": "ঘড়ির সময়: অফিসিয়াল রূপ (Wie spät ist es?)",
            "title_target": "Offizielle Uhrzeit",
            "intro_bn": "অফিসিয়াল সময় ২৪ ঘণ্টার হিসাবে বলা হয়: Wie spät ist es? -> Es ist vierzehn Uhr dreißig.",
            "structure": ["Frage", "Stunde + Uhr", "Minute"],
            "items": [
                s("Wie spät ist es?", "কয়টা বাজে?", "ভী শ্পেট ইস্ত এস", [{"t": "Wie", "bn": "কেমন"}, {"t": "spät", "bn": "দেরি"}, {"t": "ist", "bn": "হয়"}, {"t": "es?", "bn": "এটি"}]),
                s("Wie viel Uhr ist es?", "কয়টা বাজে?", "ভী ফীল উর ইস্ত এস", [{"t": "Wie", "bn": "কত"}, {"t": "viel", "bn": "বেশি"}, {"t": "Uhr", "bn": "ঘড়ি"}, {"t": "ist", "bn": "হয়"}, {"t": "es?", "bn": "এটি"}]),
                s("Es ist acht Uhr.", "এখন সকাল আটটা বাজে।", "এস ইস্ত আখট উর", [{"t": "Es", "bn": "এটি"}, {"t": "ist", "bn": "হয়"}, {"t": "acht", "bn": "আট"}, {"t": "Uhr.", "bn": "টা"}]),
                s("Es ist zehn Uhr fünfzehn.", "এখন দশটা বেজে পনেরো মিনিট।", "এস ইস্ত ৎসেন উর ফ্যুনফৎসেন", [{"t": "Es", "bn": "এটি"}, {"t": "ist", "bn": "হয়"}, {"t": "zehn", "bn": "দশ"}, {"t": "Uhr", "bn": "টা"}, {"t": "fünfzehn.", "bn": "পনেরো"}]),
                s("Es ist vierzehn Uhr dreißig.", "এখন দুপুর দুটো বেজে ত্রিশ মিনিট।", "এস ইস্ত ফিয়ারৎসেন উর ড্রাইসিখ", [{"t": "Es", "bn": "এটি"}, {"t": "ist", "bn": "হয়"}, {"t": "vierzehn", "bn": "চৌদ্দ"}, {"t": "Uhr", "bn": "টা"}, {"t": "dreißig.", "bn": "তিরিশ"}]),
                s("Der Zug fährt um neun Uhr.", "ট্রেনটি সকাল নয়টায় ছাড়বে।", "ডের ৎসুক ফেয়ার্ট উম নয়ন উর", [{"t": "Der", "bn": "টি"}, {"t": "Zug", "bn": "ট্রেন"}, {"t": "fährt", "bn": "ছাড়ে"}, {"t": "um", "bn": "এ"}, {"t": "neun", "bn": "নয়"}, {"t": "Uhr.", "bn": "টায়"}]),
                s("Um wie viel Uhr beginnt der Kurs?", "কোর্সটি কয়টায় শুরু হয়?", "উম ভী ফীল উর বেগিনট ডের কুর্স", [{"t": "Um", "bn": "এ"}, {"t": "wie", "bn": "কত"}, {"t": "viel", "bn": "বেশি"}, {"t": "Uhr", "bn": "টা"}, {"t": "beginnt", "bn": "শুরু হয়"}, {"t": "der", "bn": "টি"}, {"t": "Kurs?", "bn": "কোর্স"}]),
                s("Der Kurs beginnt um zehn Uhr.", "কোর্সটি দশটায় শুরু হয়।", "ডের কুর্স বেগিনট উম ৎসেন উর", [{"t": "Der", "bn": "টি"}, {"t": "Kurs", "bn": "কোর্স"}, {"t": "beginnt", "bn": "শুরু হয়"}, {"t": "um", "bn": "এ"}, {"t": "zehn", "bn": "দশ"}, {"t": "Uhr.", "bn": "টায়"}]),
            ]
        },
        {
            "title_bn": "ঘরোয়া সময়: halb, Viertel nach ও vor",
            "title_target": "Inoffizielle Uhrzeit",
            "intro_bn": "দৈনন্দিন আড্ডায় সাড়ে বোঝাতে 'halb' (পরবর্তী ঘণ্টার অর্ধেক, যেমন halb drei = আড়াইটা), সোয়া বোঝাতে Viertel nach, এবং পৌনে বোঝাতে Viertel vor ব্যবহৃত হয়।",
            "structure": ["Modell", "Uhrzeit", "Bedeutung"],
            "items": [
                s("Es ist halb drei.", "এখন আড়াইটা বাজে (তিনটার অর্ধেক বাকি)।", "এস ইস্ত হাল্প ড্রাই", [{"t": "Es", "bn": "এটি"}, {"t": "ist", "bn": "হয়"}, {"t": "halb", "bn": "অর্ধেক"}, {"t": "drei.", "bn": "তিনটা"}]),
                s("Es ist Viertel nach vier.", "এখন সোয়া চারটা বাজে (চারটা বেজে পনেরো)।", "এস ইস্ত ফিয়ার্টেল নাখ ফিয়ার", [{"t": "Es", "bn": "এটি"}, {"t": "ist", "bn": "হয়"}, {"t": "Viertel", "bn": "কোয়ার্টার"}, {"t": "nach", "bn": "পরে"}, {"t": "vier.", "bn": "চার"}]),
                s("Es ist Viertel vor fünf.", "এখন পৌনে পাঁচটা বাজে (পাঁচটা বাজতে পনেরো বাকি)।", "এস ইস্ত ফিয়ার্টেল ফোর ফ্যুনফ", [{"t": "Es", "bn": "এটি"}, {"t": "ist", "bn": "হয়"}, {"t": "Viertel", "bn": "কোয়ার্টার"}, {"t": "vor", "bn": "আগে"}, {"t": "fünf.", "bn": "পাঁচ"}]),
                s("Es ist zehn nach acht.", "আটটা বেজে দশ মিনিট।", "এস ইস্ত ৎসেন নাখ আখট", [{"t": "Es", "bn": "এটি"}, {"t": "ist", "bn": "হয়"}, {"t": "zehn", "bn": "দশ"}, {"t": "nach", "bn": "পরে"}, {"t": "acht.", "bn": "আট"}]),
                s("Es ist fünf vor neun.", "নয়টা বাজতে পাঁচ মিনিট বাকি।", "এস ইস্ত ফ্যুনফ ফোর নয়ন", [{"t": "Es", "bn": "এটি"}, {"t": "ist", "bn": "হয়"}, {"t": "fünf", "bn": "পাঁচ"}, {"t": "vor", "bn": "আগে"}, {"t": "neun.", "bn": "নয়"}]),
                s("Hast du kurz Zeit?", "তোমার কি একটু সময় আছে?", "হাস্ট দু কুর্ৎস ৎসাইট", [{"t": "Hast", "bn": "আছে"}, {"t": "du", "bn": "তোমার"}, {"t": "kurz", "bn": "কিছুক্ষণ"}, {"t": "Zeit?", "bn": "সময়"}]),
                s("Ich habe keine Zeit.", "আমার কোনো সময় নেই।", "ইখ্ হাবে কাইনে ৎসাইট", [{"t": "Ich", "bn": "আমার"}, {"t": "habe", "bn": "আছে"}, {"t": "keine", "bn": "কোনো না"}, {"t": "Zeit.", "bn": "সময়"}]),
                s("Wir sehen uns um halb acht.", "আমাদের সাড়ে সাতটায় দেখা হবে।", "ভির জেহেন উন্স উম হাল্প আখট", [{"t": "Wir", "bn": "আমরা"}, {"t": "sehen", "bn": "দেখব"}, {"t": "uns", "bn": "নিজেদের"}, {"t": "um", "bn": "এ"}, {"t": "halb", "bn": "অর্ধেক"}, {"t": "acht.", "bn": "আট"}]),
            ]
        },
        {
            "title_bn": "সপ্তাহের সাত দিন ও সময়সূচি (Wochentage)",
            "title_target": "Die sieben Wochentage",
            "intro_bn": "বারের নামের আগে সর্বদা 'am' বসে: am Montag, am Dienstag, am Wochenende।",
            "structure": ["Wochentag", "Präposition am", "Aktivität"],
            "items": [
                w("der Montag", "সোমবার", "ডের মোনতাক", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Montag", "bn": "সোমবার"}]),
                w("der Dienstag", "মঙ্গলবার", "ডের ডীনসতাক", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Dienstag", "bn": "মঙ্গলবার"}]),
                w("der Mittwoch", "বুধবার", "ডের মিটভখ", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Mittwoch", "bn": "বুধবার"}]),
                w("der Donnerstag", "বৃহস্পতিবার", "ডের ডোনারসতাক", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Donnerstag", "bn": "বৃহস্পতিবার"}]),
                w("der Freitag", "শুক্রবার", "ডের ফ্রাইতাক", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Freitag", "bn": "শুক্রবার"}]),
                w("der Samstag", "শনিবার", "ডের জামসতাক", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Samstag", "bn": "শনিবার"}]),
                w("der Sonntag", "রবিবার", "ডের জোনতাক", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Sonntag", "bn": "রবিবার"}]),
                s("Am Montag arbeite ich nicht.", "সোমবারে আমার কাজ নেই।", "আম মোনতাক আরবাইতে ইখ্ নিখ্ট", [{"t": "Am", "bn": "এ"}, {"t": "Montag", "bn": "সোমবার"}, {"t": "arbeite", "bn": "কাজ করি"}, {"t": "ich", "bn": "আমি"}, {"t": "nicht.", "bn": "না"}]),
            ]
        },
        {
            "title_bn": "বারো মাস ও চার ঋতু (Monate & Jahreszeiten)",
            "title_target": "Monate & Jahreszeiten",
            "intro_bn": "মাস ও ঋতুর নামের আগে সর্বদা 'im' (in dem) বসে: im Januar, im Sommer।",
            "structure": ["Monat/Saison", "Präposition im", "Satz"],
            "items": [
                s("Im Januar ist es sehr kalt.", "জানুয়ারিতে খুব ঠান্ডা পড়ে।", "ইম ইয়ানুয়ার ইস্ত এস জেয়ার কাল্ট", [{"t": "Im", "bn": "এ"}, {"t": "Januar", "bn": "জানুয়ারি"}, {"t": "ist", "bn": "হয়"}, {"t": "es", "bn": "এটি"}, {"t": "sehr", "bn": "খুব"}, {"t": "kalt.", "bn": "ঠান্ডা"}]),
                s("Mein Geburtstag ist im März.", "মার্চ মাসে আমার জন্মদিন।", "মাইন গেবুর্টস্টাক ইস্ত ইম মেয়ার্ৎস", [{"t": "Mein", "bn": "আমার"}, {"t": "Geburtstag", "bn": "জন্মদিন"}, {"t": "ist", "bn": "হয়"}, {"t": "im", "bn": "এ"}, {"t": "März.", "bn": "মার্চ"}]),
                s("Im Sommer haben wir Urlaub.", "গ্রীষ্মকালে আমাদের ছুটি থাকে।", "ইম যোমার হাবের্ন ভির উরলাউপ", [{"t": "Im", "bn": "এ"}, {"t": "Sommer", "bn": "গ্রীষ্ম"}, {"t": "haben", "bn": "থাকে"}, {"t": "wir", "bn": "আমাদের"}, {"t": "Urlaub.", "bn": "ছুটি"}]),
                s("Im Herbst regnet es oft.", "শরৎকালে প্রায়ই বৃষ্টি হয়।", "ইম হেয়ার্বস্ট রেগনেট এস অফ্ট", [{"t": "Im", "bn": "এ"}, {"t": "Herbst", "bn": "শরৎ"}, {"t": "regnet", "bn": "বৃষ্টি হয়"}, {"t": "es", "bn": "এটি"}, {"t": "oft.", "bn": "প্রায়ই"}]),
                s("Im Winter schneit es in den Bergen.", "শীতকালে পাহাড়ে তুষারপাত হয়।", "ইম ভিন্টার শ্নাইট এস ইন ডেন বের্গেন", [{"t": "Im", "bn": "এ"}, {"t": "Winter", "bn": "শীত"}, {"t": "schneit", "bn": "তুষার পড়ে"}, {"t": "es", "bn": "এটি"}, {"t": "in", "bn": "এ"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Bergen.", "bn": "পাহাড়"}]),
                s("Der Frühling ist wunderschön.", "বসন্তকাল ভীষণ সুন্দর।", "ডের ফ্র্যূলিং ইস্ত ভুন্ডারশোয়ন", [{"t": "Der", "bn": "টি"}, {"t": "Frühling", "bn": "বসন্ত"}, {"t": "ist", "bn": "হয়"}, {"t": "wunderschön.", "bn": "ভীষণ সুন্দর"}]),
                s("Wann reist du nach Deutschland?", "তুমি কবে জার্মানি যাবে?", "ভান রাইস্ট দু নাখ ডয়চলান্ট", [{"t": "Wann", "bn": "কখন"}, {"t": "reist", "bn": "ভ্রমণ করবে"}, {"t": "du", "bn": "তুমি"}, {"t": "nach", "bn": "তে"}, {"t": "Deutschland?", "bn": "জার্মানি"}]),
                s("Ich reise im Oktober.", "আমি অক্টোবর মাসে যাব।", "ইখ্ রাইজে ইম অক্টোবর", [{"t": "Ich", "bn": "আমি"}, {"t": "reise", "bn": "ভ্রমণ করব"}, {"t": "im", "bn": "এ"}, {"t": "Oktober.", "bn": "অক্টোবর"}]),
            ]
        }
    ]
}

def main():
    print(f"Writing {len(units)} A1 Part 1 units to {UNITS_DIR}...")
    for uid, data in units.items():
        path = UNITS_DIR / f"{uid}.json"
        path.write_text(json.dumps(data, ensure_ascii=False, indent=2) + "\n", encoding="utf-8")
        total_items = sum(len(l["items"]) for l in data["lessons"])
        print(f"  {uid}.json: {len(data['lessons'])} lessons, {total_items} items")

if __name__ == "__main__":
    main()
