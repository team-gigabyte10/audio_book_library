"""Generates Level A1 Part 2 (Units a1-08 to a1-15) for German Spoken Course."""
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

def dl(speaker, target, bn, pron, tokens):
    return {"type": "dialogue_line", "speaker": speaker, "target": target, "bn": bn, "bn_pron": pron, "tokens": tokens}

units = {}

# -------------------------------------------------------------
# Unit a1-08: দৈনন্দিন রুটিন ও একুশে নিয়ম (Tagesablauf & V2-Stellung)
# -------------------------------------------------------------
units["a1-08"] = {
    "title_bn": "দৈনন্দিন রুটিন ও একুশে নিয়ম",
    "title_target": "Tagesablauf & Verb an Position Zwei",
    "lessons": [
        {
            "title_bn": "দৈনন্দিন সকালের রুটিন (aufstehen, frühstücken)",
            "title_target": "Morgenroutine",
            "intro_bn": "জার্মান সাধারণ বাক্যে প্রধান ক্রিয়াপদ সর্বদা ২ নম্বর স্থানে (Position 2) বসে।",
            "structure": ["Zeit", "Verb (Pos 2)", "Subjekt", "Aktivität"],
            "items": [
                s("Ich stehe um sechs Uhr auf.", "আমি সকাল ছয়টায় ঘুম থেকে উঠি।", "ইখ্ শ্টেহে উম জেক্স উর আউফ", [{"t": "Ich", "bn": "আমি"}, {"t": "stehe", "bn": "উঠি"}, {"t": "um", "bn": "এ"}, {"t": "sechs", "bn": "ছয়"}, {"t": "Uhr", "bn": "টা"}, {"t": "auf.", "bn": "ঘুম থেকে"}]),
                s("Dann dusche ich.", "তারপর আমি গোসল করি।", "ডান ডুশে ইখ্", [{"t": "Dann", "bn": "তারপর"}, {"t": "dusche", "bn": "গোসল করি"}, {"t": "ich.", "bn": "আমি"}]),
                s("Ich frühstücke um sieben Uhr.", "আমি সকাল সাতটায় নাস্তা করি।", "ইখ্ ফ্র্যূশ্ট্যুকে উম যীবেন উর", [{"t": "Ich", "bn": "আমি"}, {"t": "frühstücke", "bn": "নাস্তা করি"}, {"t": "um", "bn": "এ"}, {"t": "sieben", "bn": "সাত"}, {"t": "Uhr.", "bn": "টায়"}]),
                s("Zum Frühstück trinke ich Tee.", "সকালের নাস্তায় আমি চা পান করি।", "ৎসুম ফ্র্যূশ্ট্যক ট্রিঙ্কে ইখ্ টে", [{"t": "Zum", "bn": "এ"}, {"t": "Frühstück", "bn": "নাস্তা"}, {"t": "trinke", "bn": "পান করি"}, {"t": "ich", "bn": "আমি"}, {"t": "Tee.", "bn": "চা"}]),
                s("Ich esse Brot mit Butter.", "আমি মাখন দিয়ে রুটি খাই।", "ইখ্ এসে ব্রোট মিট বুটার", [{"t": "Ich", "bn": "আমি"}, {"t": "esse", "bn": "খাই"}, {"t": "Brot", "bn": "রুটি"}, {"t": "mit", "bn": "দিয়ে"}, {"t": "Butter.", "bn": "মাখন"}]),
                s("Um halb acht gehe ich los.", "সাড়ে সাতটায় আমি রওনা হই।", "উম হাল্প আখট গেহে ইখ্ লোস", [{"t": "Um", "bn": "এ"}, {"t": "halb", "bn": "অর্ধেক"}, {"t": "acht", "bn": "আট"}, {"t": "gehe", "bn": "যাই"}, {"t": "ich", "bn": "আমি"}, {"t": "los.", "bn": "রওনা"}]),
                s("Ich fahre mit der Bahn.", "আমি ট্রেনে করে যাই।", "ইখ্ ফাহরে মিট ডের বান", [{"t": "Ich", "bn": "আমি"}, {"t": "fahre", "bn": "যাই"}, {"t": "mit", "bn": "দিয়ে"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Bahn.", "bn": "ট্রেন"}]),
                s("Um acht Uhr komme ich an.", "আটটায় আমি পৌঁছাই।", "উম আখট উর কমে ইখ্ আন", [{"t": "Um", "bn": "এ"}, {"t": "acht", "bn": "আট"}, {"t": "Uhr", "bn": "টায়"}, {"t": "komme", "bn": "আসি"}, {"t": "ich", "bn": "আমি"}, {"t": "an.", "bn": "পৌঁছানো"}]),
            ]
        },
        {
            "title_bn": "একুশে নিয়ম: শুরুতে সময় বসলে ক্রিয়ার স্থান",
            "title_target": "Inversion: Zeit an Position Eins",
            "intro_bn": "বাক্যের শুরুতে সময় বা স্থান বসালে ক্রিয়াপদ অবশ্যই ২ নম্বরে থাকবে এবং কর্তা চলে যাবে ৩ নম্বরে (একুশে নিয়ম বা ইনভার্সন)।",
            "structure": ["Position 1", "Position 2 (Verb)", "Position 3 (Subjekt)"],
            "items": [
                s("Heute lerne ich Deutsch.", "আজ আমি জার্মান শিখছি।", "হয়টে লের্নে ইখ্ ডয়চ", [{"t": "Heute", "bn": "আজ"}, {"t": "lerne", "bn": "শিখছি"}, {"t": "ich", "bn": "আমি"}, {"t": "Deutsch.", "bn": "জার্মান"}]),
                s("Morgen arbeite ich wieder.", "কাল আমি আবার কাজ করব।", "মর্গেন আরবাইতে ইখ্ ভিডার", [{"t": "Morgen", "bn": "কাল"}, {"t": "arbeite", "bn": "কাজ করব"}, {"t": "ich", "bn": "আমি"}, {"t": "wieder.", "bn": "আবার"}]),
                s("Um zehn Uhr schlafe ich.", "রাত দশটায় আমি ঘুমাই।", "উম ৎসেন উর শ্লাফে ইখ্", [{"t": "Um", "bn": "এ"}, {"t": "zehn", "bn": "দশ"}, {"t": "Uhr", "bn": "টায়"}, {"t": "schlafe", "bn": "ঘুমাই"}, {"t": "ich.", "bn": "আমি"}]),
                s("Am Sonntag koche ich gern.", "রবিবারে আমি সানন্দে রান্না করি।", "আম জোনতাক কখে ইখ্ গেয়ার্ন", [{"t": "Am", "bn": "এ"}, {"t": "Sonntag", "bn": "রবিবার"}, {"t": "koche", "bn": "রান্না করি"}, {"t": "ich", "bn": "আমি"}, {"t": "gern.", "bn": "আনন্দে"}]),
                s("Jeden Tag jogge ich.", "প্রতিদিন আমি জগিং করি।", "ইয়েডেন তাক জগে ইখ্", [{"t": "Jeden", "bn": "প্রতি"}, {"t": "Tag", "bn": "দিন"}, {"t": "jogge", "bn": "জগিং করি"}, {"t": "ich.", "bn": "আমি"}]),
                s("Jetzt verstehe ich den Satz.", "এখন আমি বাক্যটি বুঝতে পারছি।", "ইয়েৎস্ট ফেয়ার্শ্টেহে ইখ্ ডেন জাৎৎস", [{"t": "Jetzt", "bn": "এখন"}, {"t": "verstehe", "bn": "বুঝছি"}, {"t": "ich", "bn": "আমি"}, {"t": "den", "bn": "টি"}, {"t": "Satz.", "bn": "বাক্য"}]),
                s("Manchmal trinke ich Kaffee.", "মাঝে মাঝে আমি কফি খাই।", "মানখমাল ট্রিঙ্কে ইখ্ কাফে", [{"t": "Manchmal", "bn": "মাঝে মাঝে"}, {"t": "trinke", "bn": "পান করি"}, {"t": "ich", "bn": "আমি"}, {"t": "Kaffee.", "bn": "কফি"}]),
                s("Immer mache ich meine Hausaufgaben.", "সবসময় আমি আমার হোমওয়ার্ক করি।", "ইমার মাখে ইখ্ মাইনে হাউসআউফগাবেন", [{"t": "Immer", "bn": "সবসময়"}, {"t": "mache", "bn": "করি"}, {"t": "ich", "bn": "আমি"}, {"t": "meine", "bn": "আমার"}, {"t": "Hausaufgaben.", "bn": "হোমওয়ার্ক"}]),
            ]
        },
        {
            "title_bn": "কর্মক্ষেত্র ও দুপুরের খাবার (Mittagspause)",
            "title_target": "Arbeit & Mittagessen",
            "intro_bn": "দুপুর বারোটা থেকে দুটো পর্যন্ত দুপুরের খাবার ও বিরতির প্রয়োজনীয় বাক্য।",
            "structure": ["Mittag", "Essen", "Pausenzeit"],
            "items": [
                s("Um zwölf Uhr mache ich Mittagspause.", "দুপুর বারোটায় আমি লাঞ্চ বিরতি নিই।", "উম ৎস্ভোয়েলফ উর মাখে ইখ্ মিটাকসপাউজে", [{"t": "Um", "bn": "এ"}, {"t": "zwölf", "bn": "বারো"}, {"t": "Uhr", "bn": "টায়"}, {"t": "mache", "bn": "নিই"}, {"t": "ich", "bn": "আমি"}, {"t": "Mittagspause.", "bn": "লাঞ্চ বিরতি"}]),
                s("Ich esse in der Kantine.", "আমি ক্যান্টিনে খাই।", "ইখ্ এসে ইন ডের কান্টিনে", [{"t": "Ich", "bn": "আমি"}, {"t": "esse", "bn": "খাই"}, {"t": "in", "bn": "এ"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Kantine.", "bn": "ক্যান্টিন"}]),
                s("Das Essen schmeckt gut.", "খাবারটি ভালো স্বাদযুক্ত।", "ডাস এসেন শমেকট গুট", [{"t": "Das", "bn": "টি"}, {"t": "Essen", "bn": "খাবার"}, {"t": "schmeckt", "bn": "স্বাদ দেয়"}, {"t": "gut.", "bn": "ভালো"}]),
                s("Ich esse mit meinen Kollegen.", "আমি আমার সহকর্মীদের সাথে খাই।", "ইখ্ এসে মিট মাইনেন কোলেগেন", [{"t": "Ich", "bn": "আমি"}, {"t": "esse", "bn": "খাই"}, {"t": "mit", "bn": "সাথে"}, {"t": "meinen", "bn": "আমার"}, {"t": "Kollegen.", "bn": "সহকর্মীদের"}]),
                s("Nach der Pause arbeite ich weiter.", "বিরতির পর আমি আবার কাজ করি।", "নাখ ডের পাউজে আরবাইতে ইখ্ ভাইটার", [{"t": "Nach", "bn": "পর"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Pause", "bn": "বিরতি"}, {"t": "arbeite", "bn": "কাজ করি"}, {"t": "ich", "bn": "আমি"}, {"t": "weiter.", "bn": "এগিয়ে"}]),
                s("Ich schreibe viele E-Mails.", "আমি অনেক ইমেইল লিখি।", "ইখ্ শ্রাইবে ফীলে ইমেইলস", [{"t": "Ich", "bn": "আমি"}, {"t": "schreibe", "bn": "লিখি"}, {"t": "viele", "bn": "অনেক"}, {"t": "E-Mails.", "bn": "ইমেইল"}]),
                s("Ich telefoniere mit Kunden.", "আমি গ্রাহকদের সাথে ফোনে কথা বলি।", "ইখ্ টেলিফোনিয়ারে মিট কুন্ডেন", [{"t": "Ich", "bn": "আমি"}, {"t": "telefoniere", "bn": "ফোনে কথা বলি"}, {"t": "mit", "bn": "সাথে"}, {"t": "Kunden.", "bn": "গ্রাহকদের"}]),
                s("Der Arbeitstag ist lang.", "কর্মদিবসটি দীর্ঘ।", "ডের আরবাইটস্টাক ইস্ত লাং", [{"t": "Der", "bn": "টি"}, {"t": "Arbeitstag", "bn": "কর্মদিবস"}, {"t": "ist", "bn": "হয়"}, {"t": "lang.", "bn": "দীর্ঘ"}]),
            ]
        },
        {
            "title_bn": "সন্ধ্যার অবসর ও ঘুম (Abend & Freizeit)",
            "title_target": "Feierabend & Schlafen",
            "intro_bn": "কাজ শেষ হওয়ার পর আড্ডা দেওয়া, টিভি দেখা ও ঘুমানোর রুটিন।",
            "structure": ["Feierabend", "Freizeit", "Nachtruhe"],
            "items": [
                s("Um achtzehn Uhr bin ich zu Hause.", "সন্ধ্যা ছয়টায় আমি বাসায় ফিরি।", "উম আখটৎসেন উর বিন ইখ্ ৎসু হাউজে", [{"t": "Um", "bn": "এ"}, {"t": "achtzehn", "bn": "আঠারো"}, {"t": "Uhr", "bn": "টায়"}, {"t": "bin", "bn": "হই"}, {"t": "ich", "bn": "আমি"}, {"t": "zu", "bn": "এ"}, {"t": "Hause.", "bn": "বাড়ি"}]),
                s("Am Abend koche ich das Abendessen.", "সন্ধ্যায় আমি রাতের খাবার রান্না করি।", "আম আবেন্ট কখে ইখ্ ডাস আবেন্টএসেন", [{"t": "Am", "bn": "এ"}, {"t": "Abend", "bn": "সন্ধ্যা"}, {"t": "koche", "bn": "রান্না করি"}, {"t": "ich", "bn": "আমি"}, {"t": "das", "bn": "টি"}, {"t": "Abendessen.", "bn": "রাতের খাবার"}]),
                s("Ich sehe ein bisschen fern.", "আমি কিছুক্ষণ টিভি দেখি।", "ইখ্ জেহে আইন বিসখেন ফেয়ার্ন", [{"t": "Ich", "bn": "আমি"}, {"t": "sehe", "bn": "দেখি"}, {"t": "ein", "bn": "এক"}, {"t": "bisschen", "bn": "একটু"}, {"t": "fern.", "bn": "টিভি"}]),
                s("Ich lese ein interessantes Buch.", "আমি একটি আকর্ষণীয় বই পড়ি।", "ইখ্ লেজে আইন ইন্টারেসান্টেস বুখ", [{"t": "Ich", "bn": "আমি"}, {"t": "lese", "bn": "পড়ি"}, {"t": "ein", "bn": "একটি"}, {"t": "interessantes", "bn": "আকর্ষণীয়"}, {"t": "Buch.", "bn": "বই"}]),
                s("Ich höre gern Musik.", "আমি গান শুনতে পছন্দ করি।", "ইখ্ হোয়রে গেয়ার্ন মুযীক", [{"t": "Ich", "bn": "আমি"}, {"t": "höre", "bn": "শুনি"}, {"t": "gern", "bn": "আনন্দে"}, {"t": "Musik.", "bn": "গান"}]),
                s("Ich gehe um dreiundzwanzig Uhr ins Bett.", "আমি রাত এগারোটায় বিছানায় যাই।", "ইখ্ গেহে উম ড্রাইউন্টৎস্ভানৎসিখ উর ইন্স বেট", [{"t": "Ich", "bn": "আমি"}, {"t": "gehe", "bn": "যাই"}, {"t": "um", "bn": "এ"}, {"t": "dreiundzwanzig", "bn": "তেইশ"}, {"t": "Uhr", "bn": "টায়"}, {"t": "ins", "bn": "এ"}, {"t": "Bett.", "bn": "বিছানা"}]),
                s("Ich schlafe sehr gut.", "আমি খুব ভালো ঘুমাই।", "ইখ্ শ্লাফে জেয়ার গুট", [{"t": "Ich", "bn": "আমি"}, {"t": "schlafe", "bn": "ঘুমাই"}, {"t": "sehr", "bn": "খুব"}, {"t": "gut.", "bn": "ভালো"}]),
                s("Gute Nacht und schlaf gut!", "শুভ রাত্রি এবং ভালো ঘুম হোক!", "গুটে নাখ্ট উন্ট শ্লাফ গুট", [{"t": "Gute", "bn": "শুভ"}, {"t": "Nacht", "bn": "রাত্রি"}, {"t": "und", "bn": "এবং"}, {"t": "schlaf", "bn": "ঘুমাও"}, {"t": "gut!", "bn": "ভালো"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit a1-09: বিচ্ছিন্নযোগ্য ক্রিয়াপদ (Trennbare Verben)
# -------------------------------------------------------------
units["a1-09"] = {
    "title_bn": "বিচ্ছিন্নযোগ্য ক্রিয়াপদ",
    "title_target": "Trennbare Verben im Alltag",
    "lessons": [
        {
            "title_bn": "উপসর্গ ও আলাদা হওয়ার নিয়ম (an, auf, aus)",
            "title_target": "Präfixe trennen",
            "intro_bn": "বিচ্ছিন্নযোগ্য ক্রিয়াপদের উপসর্গটি (an, auf, aus, mit) বাক্যের একেবারে শেষে চলে যায়: aufstehen -> Ich stehe um sechs Uhr auf.",
            "structure": ["Verb", "Präfix", "Satzende"],
            "items": [
                s("Der Film fängt um acht Uhr an.", "সিনেমাটি আটটায় শুরু হবে (anfangen)।", "ডের ফিল্ম ফেংট উম আখট উর আন", [{"t": "Der", "bn": "টি"}, {"t": "Film", "bn": "সিনেমা"}, {"t": "fängt", "bn": "শুরু হয়"}, {"t": "um", "bn": "এ"}, {"t": "acht", "bn": "আট"}, {"t": "Uhr", "bn": "টায়"}, {"t": "an.", "bn": "উপসর্গ"}]),
                s("Wann hört der Unterricht auf?", "ক্লাস কখন শেষ হয় (aufhören)?", "ভান হোয়ের্ট ডের উন্টাররিশ্ট আউফ", [{"t": "Wann", "bn": "কখন"}, {"t": "hört", "bn": "শেষ হয়"}, {"t": "der", "bn": "টি"}, {"t": "Unterricht", "bn": "ক্লাস"}, {"t": "auf?", "bn": "উপসর্গ"}]),
                s("Der Kurs hört um zwölf Uhr auf.", "কোর্সটি বারোটায় শেষ হয়।", "ডের কুর্স হোয়ের্ট উম ৎস্ভোয়েলফ উর আউফ", [{"t": "Der", "bn": "টি"}, {"t": "Kurs", "bn": "কোর্স"}, {"t": "hört", "bn": "শেষ হয়"}, {"t": "um", "bn": "এ"}, {"t": "zwölf", "bn": "বারো"}, {"t": "Uhr", "bn": "টায়"}, {"t": "auf.", "bn": "উপসর্গ"}]),
                s("Ich ziehe eine Jacke an.", "আমি একটি জ্যাকেট পরছি (anziehen)।", "ইখ্ ৎসীহে আইনে ইয়াক্কে আন", [{"t": "Ich", "bn": "আমি"}, {"t": "ziehe", "bn": "পরছি"}, {"t": "eine", "bn": "একটি"}, {"t": "Jacke", "bn": "জ্যাকেট"}, {"t": "an.", "bn": "উপসর্গ"}]),
                s("Er zieht die Schuhe aus.", "সে জুতো খুলছে (ausziehen)।", "এর ৎসীহট ডী শুহে আউস", [{"t": "Er", "bn": "সে"}, {"t": "zieht", "bn": "খুলছে"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Schuhe", "bn": "জুতো"}, {"t": "aus.", "bn": "উপসর্গ"}]),
                s("Ich steige am Bahnhof ein.", "আমি স্টেশনে ট্রেনে উঠছি (einsteigen)।", "ইখ্ শ্টাইগে আম বানহোফ আইন", [{"t": "Ich", "bn": "আমি"}, {"t": "steige", "bn": "উঠছি"}, {"t": "am", "bn": "এ"}, {"t": "Bahnhof", "bn": "স্টেশন"}, {"t": "ein.", "bn": "উপসর্গ"}]),
                s("Wir steigen hier aus.", "আমরা এখানে নামছি (aussteigen)।", "ভির শ্টাইগেন হিয়ার আউস", [{"t": "Wir", "bn": "আমরা"}, {"t": "steigen", "bn": "নামছি"}, {"t": "hier", "bn": "এখানে"}, {"t": "aus.", "bn": "উপসর্গ"}]),
                s("Sie steigen in Frankfurt um.", "তারা ফ্রাঙ্কফুর্টে ট্রেন বদলাচ্ছে (umsteigen)।", "যী শ্টাইগেন ইন ফ্রাঙ্কফুর্ট উম", [{"t": "Sie", "bn": "তারা"}, {"t": "steigen", "bn": "বদল করছে"}, {"t": "in", "bn": "এ"}, {"t": "Frankfurt", "bn": "ফ্রাঙ্কফুর্ট"}, {"t": "um.", "bn": "উপসর্গ"}]),
            ]
        },
        {
            "title_bn": "কেনাকাটা ও ফোন করা (einkaufen, anrufen)",
            "title_target": "Einkaufen & Anrufen",
            "intro_bn": "einkaufen (কেনাকাটা করা) ও anrufen (ফোন করা) ক্রিয়াপদের স্পোকেন ব্যবহার।",
            "structure": ["Verb (Pos 2)", "Objekt", "Präfix (Ende)"],
            "items": [
                s("Ich kaufe heute im Supermarkt ein.", "আমি আজ সুপারমার্কেটে কেনাকাটা করব।", "ইখ্ কাউফে হয়টে ইম সুপারমার্কট আইন", [{"t": "Ich", "bn": "আমি"}, {"t": "kaufe", "bn": "কিনছি"}, {"t": "heute", "bn": "আজ"}, {"t": "im", "bn": "এ"}, {"t": "Supermarkt", "bn": "মার্কেট"}, {"t": "ein.", "bn": "উপসর্গ"}]),
                s("Kaufst du bitte Milch ein?", "তুমি কি দয়া করে দুধ কিনে আনবে?", "কাউফস্ট দু বিটে মিলখ আইন", [{"t": "Kaufst", "bn": "কিনবে"}, {"t": "du", "bn": "তুমি"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "Milch", "bn": "দুধ"}, {"t": "ein?", "bn": "উপসর্গ"}]),
                s("Ich rufe meine Mutter an.", "আমি আমার মাকে ফোন করছি (anrufen)।", "ইখ্ রুফে মাইনে মুটার আন", [{"t": "Ich", "bn": "আমি"}, {"t": "rufe", "bn": "ডাকছি"}, {"t": "meine", "bn": "আমার"}, {"t": "Mutter", "bn": "মাকে"}, {"t": "an.", "bn": "উপসর্গ"}]),
                s("Rufst du mich später an?", "তুমি কি আমাকে পরে ফোন করবে?", "রুফস্ট দু নিখ্ শ্পেটার আন", [{"t": "Rufst", "bn": "ডাকবে"}, {"t": "du", "bn": "তুমি"}, {"t": "mich", "bn": "আমাকে"}, {"t": "später", "bn": "পরে"}, {"t": "an?", "bn": "উপসর্গ"}]),
                s("Er ruft den Arzt an.", "সে ডাক্তারকে ফোন করছে।", "এর রুফট ডেন আর্ৎস্ট আন", [{"t": "Er", "bn": "সে"}, {"t": "ruft", "bn": "ডাকছে"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Arzt", "bn": "ডাক্তারকে"}, {"t": "an.", "bn": "উপসর্গ"}]),
                s("Wir kaufen für das Fest ein.", "আমরা উৎসবের জন্য কেনাকাটা করছি।", "ভির কাউফেন ফ্যুর ডাস ফেস্ট আইন", [{"t": "Wir", "bn": "আমরা"}, {"t": "kaufen", "bn": "কিনছি"}, {"t": "für", "bn": "জন্য"}, {"t": "das", "bn": "টি"}, {"t": "Fest", "bn": "উৎসব"}, {"t": "ein.", "bn": "উপসর্গ"}]),
                s("Niemand ruft mich an.", "কেউ আমাকে ফোন করে না।", "নীমান্ট রুফট নিখ্ আন", [{"t": "Niemand", "bn": "কেউ না"}, {"t": "ruft", "bn": "ডাকে"}, {"t": "mich", "bn": "আমাকে"}, {"t": "an.", "bn": "উপসর্গ"}]),
                s("Ich rufe gleich zurück.", "আমি এক্ষুণি ব্যাক করছি (কল ব্যাক)।", "ইখ্ রুফে গ্লাইখ ৎসুরু্যক", [{"t": "Ich", "bn": "আমি"}, {"t": "rufe", "bn": "ডাকছি"}, {"t": "gleich", "bn": "এক্ষুণি"}, {"t": "zurück.", "bn": "ফিরে"}]),
            ]
        },
        {
            "title_bn": "আমন্ত্রণ ও সাথে আসা (mitkommen, mitbringen)",
            "title_target": "Mitkommen & Mitbringen",
            "intro_bn": "কারো সাথে কোথাও যাওয়া বা কিছু সাথে নিয়ে আসার জন্য 'mit-' উপসর্গ ব্যবহৃত হয়।",
            "structure": ["Einladung", "mitnehmen", "Reaktion"],
            "items": [
                s("Kommst du heute Abend mit?", "তুমি কি আজ সন্ধ্যায় আমাদের সাথে আসবে?", "কমস্ট দু হয়টে আবেন্ট মিট", [{"t": "Kommst", "bn": "আসবে"}, {"t": "du", "bn": "তুমি"}, {"t": "heute", "bn": "আজ"}, {"t": "Abend", "bn": "সন্ধ্যায়"}, {"t": "mit?", "bn": "সাথে"}]),
                s("Ja, ich komme sehr gern mit.", "হ্যাঁ, আমি খুব আনন্দের সাথে আসব।", "ইয়া ইখ্ কমে জেয়ার গেয়ার্ন মিট", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "ich", "bn": "আমি"}, {"t": "komme", "bn": "আসব"}, {"t": "sehr", "bn": "খুব"}, {"t": "gern", "bn": "আনন্দে"}, {"t": "mit.", "bn": "সাথে"}]),
                s("Wir gehen ins Kino, kommst du mit?", "আমরা সিনেমায় যাচ্ছি, তুমি কি যাবে?", "ভির গেহেন ইন্স কিনো কমস্ট দু মিট", [{"t": "Wir", "bn": "আমরা"}, {"t": "gehen", "bn": "যাচ্ছি"}, {"t": "ins", "bn": "এ"}, {"t": "Kino,", "bn": "সিনেমা"}, {"t": "kommst", "bn": "আসবে"}, {"t": "du", "bn": "তুমি"}, {"t": "mit?", "bn": "সাথে"}]),
                s("Was bringst du zur Party mit?", "তুমি পার্টিতে কী সাথে আনবে (mitbringen)?", "ভাস ব্রিংসট দু ৎসুর পার্টি মিট", [{"t": "Was", "bn": "কী"}, {"t": "bringst", "bn": "আনবে"}, {"t": "du", "bn": "তুমি"}, {"t": "zur", "bn": "তে"}, {"t": "Party", "bn": "পার্টি"}, {"t": "mit?", "bn": "সাথে"}]),
                s("Ich bringe einen Kuchen mit.", "আমি একটি কেক সাথে আনব।", "ইখ্ ব্রিঙ্গে আইনেন কুখেন মিট", [{"t": "Ich", "bn": "আমি"}, {"t": "bringe", "bn": "আনছি"}, {"t": "einen", "bn": "একটি"}, {"t": "Kuchen", "bn": "কেক"}, {"t": "mit.", "bn": "সাথে"}]),
                s("Nimmst du einen Schirm mit?", "তুমি কি সাথে একটি ছাতা নেবে (mitnehmen)?", "নিমস্ট দু আইনেন শির্ম মিট", [{"t": "Nimmst", "bn": "নেবে"}, {"t": "du", "bn": "তুমি"}, {"t": "einen", "bn": "একটি"}, {"t": "Schirm", "bn": "ছাতা"}, {"t": "mit?", "bn": "সাথে"}]),
                s("Ja, es regnet draußen.", "হ্যাঁ, বাইরে বৃষ্টি হচ্ছে।", "ইয়া এস রেগনেট ড্রাউসেন", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "es", "bn": "এটি"}, {"t": "regnet", "bn": "বৃষ্টি হচ্ছে"}, {"t": "draußen.", "bn": "বাইরে"}]),
                s("Danke für die Einladung!", "দাওয়াত বা আমন্ত্রণের জন্য ধন্যবাদ!", "ডাঙ্কে ফ্যুর ডী আইনলাডুং", [{"t": "Danke", "bn": "ধন্যবাদ"}, {"t": "für", "bn": "জন্য"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Einladung!", "bn": "দাওয়াত"}]),
            ]
        },
        {
            "title_bn": "ঘরের কাজে ক্রিয়াপদের বিচ্ছিন্ন রূপ (aufmachen, zumachen)",
            "title_target": "Haushalt & Anweisungen",
            "intro_bn": "জানালা খোলা (aufmachen), বন্ধ করা (zumachen) বা পরিষ্কার করার নির্দেশ।",
            "structure": ["Handlung", "Mitteilung", "Bedeutung"],
            "items": [
                s("Ich mache das Fenster auf.", "আমি জানালাটি খুলে দিচ্ছি।", "ইখ্ মাখে ডাস ফেনস্টার আউফ", [{"t": "Ich", "bn": "আমি"}, {"t": "mache", "bn": "করছি"}, {"t": "das", "bn": "টি"}, {"t": "Fenster", "bn": "জানালা"}, {"t": "auf.", "bn": "উন্মুক্ত"}]),
                s("Bitte machen Sie die Tür zu!", "দয়া করে দরজাটি বন্ধ করুন!", "বিটে মাখেন যী ডী ত্যুর ৎসু", [{"t": "Bitte", "bn": "দয়া করে"}, {"t": "machen", "bn": "করুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "die", "bn": "টি"}, {"t": "Tür", "bn": "দরজা"}, {"t": "zu!", "bn": "বন্ধ"}]),
                s("Er schaltet das Licht an.", "সে বাতি জ্বালাচ্ছে (anschalten)।", "এর শালটেট ডাস লিখ্ট আন", [{"t": "Er", "bn": "সে"}, {"t": "schaltet", "bn": "চালু করছে"}, {"t": "das", "bn": "টি"}, {"t": "Licht", "bn": "বাতি"}, {"t": "an.", "bn": "উপসর্গ"}]),
                s("Schalten Sie bitte das Handy aus!", "দয়া করে মোবাইল ফোন বন্ধ রাখুন!", "শালটেন যী বিটে ডাস হ্যান্ডি আউস", [{"t": "Schalten", "bn": "রাখুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "das", "bn": "টি"}, {"t": "Handy", "bn": "ফোন"}, {"t": "aus!", "bn": "বন্ধ"}]),
                s("Ich räume mein Zimmer auf.", "আমি আমার ঘর গুছিয়ে রাখছি (aufräumen)।", "ইখ্ রয়মে মাইন ৎসিমার আউফ", [{"t": "Ich", "bn": "আমি"}, {"t": "räume", "bn": "গুছাচ্ছি"}, {"t": "mein", "bn": "আমার"}, {"t": "Zimmer", "bn": "ঘর"}, {"t": "auf.", "bn": "উপসর্গ"}]),
                s("Wann räumst du die Küche auf?", "তুমি রান্নাঘর কখন গুছাবে?", "ভান রয়মস্ট দু ডী ক্যুখে আউফ", [{"t": "Wann", "bn": "কখন"}, {"t": "räumst", "bn": "গুছাবে"}, {"t": "du", "bn": "তুমি"}, {"t": "die", "bn": "টি"}, {"t": "Küche", "bn": "রান্নাঘর"}, {"t": "auf?", "bn": "উপসর্গ"}]),
                s("Alles ist sauber und ordentlich.", "সবকিছু পরিষ্কার ও পরিপাটি।", "আলেস ইস্ত জাউবার উন্ট অর্ডেন্টলিখ", [{"t": "Alles", "bn": "সব"}, {"t": "ist", "bn": "হয়"}, {"t": "sauber", "bn": "পরিষ্কার"}, {"t": "und", "bn": "এবং"}, {"t": "ordentlich.", "bn": "পরিপাটি"}]),
                s("Das hast du toll gemacht!", "তুমি এটা দারুণভাবে করেছো!", "ডাস হাস্ট দু টল গেমাখট", [{"t": "Das", "bn": "এটা"}, {"t": "hast", "bn": "আছো"}, {"t": "du", "bn": "তুমি"}, {"t": "toll", "bn": "দারুণ"}, {"t": "gemacht!", "bn": "করেছো"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit a1-10: দিকনির্দেশনা ও শহরে ঘোরাঘুরি (Orientierung in der Stadt)
# -------------------------------------------------------------
units["a1-10"] = {
    "title_bn": "দিকনির্দেশনা ও শহরে ঘোরাঘুরি",
    "title_target": "Orientierung in der Stadt",
    "lessons": [
        {
            "title_bn": "শহরের প্রধান স্থান ও ভবন (Orte in der Stadt)",
            "title_target": "Wichtige Gebäude",
            "intro_bn": "ব্যাংক die Bank, ডাকঘর die Post, স্টেশন der Bahnhof ও ফার্মেসি die Apotheke।",
            "structure": ["Artikel", "Ort", "Bedeutung"],
            "items": [
                w("der Bahnhof", "রেল স্টেশন", "ডের বানহোফ", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Bahnhof", "bn": "স্টেশন"}]),
                w("die Post", "ডাকঘর / পোস্ট অফিস", "ডী পোস্ট", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Post", "bn": "ডাকঘর"}]),
                w("die Bank", "ব্যাংক", "ডী বাঙ্ক", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Bank", "bn": "ব্যাংক"}]),
                w("die Apotheke", "ওষুধের দোকান / ফার্মেসি", "ডী আপোথেকে", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Apotheke", "bn": "ফার্মেসি"}]),
                w("das Hotel", "হোটেল", "ডাস হোটেল", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Hotel", "bn": "হোটেল"}]),
                w("das Museum", "জাদুঘর", "ডাস মুজেউম", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Museum", "bn": "জাদুঘর"}]),
                w("der Park", "পার্ক / উদ্যান", "ডের পার্ক", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Park", "bn": "পার্ক"}]),
                w("die Haltestelle", "বাস বা ট্রাম স্টপ", "ডী হাল্টেশ্টেলে", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Haltestelle", "bn": "স্টপ"}]),
            ]
        },
        {
            "title_bn": "দিক ও রাস্তার নির্দেশনা (links, rechts, geradeaus)",
            "title_target": "Richtungen angeben",
            "intro_bn": "সোজা geradeaus, ডানে nach rechts, এবং বাঁয়ে nach links।",
            "structure": ["Richtung", "Wegbeschreibung", "Bedeutung"],
            "items": [
                s("Gehen Sie geradeaus!", "সোজা এগিয়ে যান!", "গেহেন যী গেরাদেআউস", [{"t": "Gehen", "bn": "যান"}, {"t": "Sie", "bn": "আপনি"}, {"t": "geradeaus!", "bn": "সোজা"}]),
                s("Biegen Sie nach links ab!", "বাঁ দিকে মোড় নিন!", "বীগেন যী নাখ লিংকস আপ", [{"t": "Biegen", "bn": "মোড় নিন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "nach", "bn": "দিকে"}, {"t": "links", "bn": "বাঁ"}, {"t": "ab!", "bn": "ঘোরা"}]),
                s("Biegen Sie nach rechts ab!", "ডান দিকে মোড় নিন!", "বীগেন যী নাখ রিখটস আপ", [{"t": "Biegen", "bn": "মোড় নিন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "nach", "bn": "দিকে"}, {"t": "rechts", "bn": "ডান"}, {"t": "ab!", "bn": "ঘোরা"}]),
                s("An der Kreuzung nach rechts.", "চৌরাস্তায় ডানে যান।", "আন ডের ক্রয়ৎসুং নাখ রিখটস", [{"t": "An", "bn": "এ"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Kreuzung", "bn": "চৌরাস্তা"}, {"t": "nach", "bn": "দিকে"}, {"t": "rechts.", "bn": "ডান"}]),
                s("An der Ampel nach links.", "ট্রাফিক সিগন্যালে বাঁয়ে যান।", "আন ডের আম্পেল নাখ লিংকস", [{"t": "An", "bn": "এ"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Ampel", "bn": "সিগন্যাল"}, {"t": "nach", "bn": "দিকে"}, {"t": "links.", "bn": "বাঁ"}]),
                s("Die zweite Straße links.", "দ্বিতীয় রাস্তায় বাঁয়ে যান।", "ডী ৎস্ভাইটে শ্ট্রাস়ে লিংকস", [{"t": "Die", "bn": "টি"}, {"t": "zweite", "bn": "দ্বিতীয়"}, {"t": "Straße", "bn": "রাস্তা"}, {"t": "links.", "bn": "বাঁয়ে"}]),
                s("Das ist nicht weit von hier.", "এটা এখান থেকে বেশি দূরে নয়।", "ডাস ইস্ত নিখ্ট ভাইট ফন হিয়ার", [{"t": "Das", "bn": "এটা"}, {"t": "ist", "bn": "হয়"}, {"t": "nicht", "bn": "না"}, {"t": "weit", "bn": "দূরে"}, {"t": "von", "bn": "থেকে"}, {"t": "hier.", "bn": "এখানে"}]),
                s("Es dauert fünf Minuten zu Fuß.", "পায়ে হেঁটে পাঁচ মিনিট সময় লাগবে।", "এস ডাউয়ার্ট ফ্যুনফ মিনুটেন ৎসু ফুস", [{"t": "Es", "bn": "এটি"}, {"t": "dauert", "bn": "সময় নেয়"}, {"t": "fünf", "bn": "পাঁচ"}, {"t": "Minuten", "bn": "মিনিট"}, {"t": "zu", "bn": "পায়ে"}, {"t": "Fuß.", "bn": "হেঁটে"}]),
            ]
        },
        {
            "title_bn": "প্রেপজিশন ও ডাটিভ (zu, neben, gegenüber)",
            "title_target": "Präpositionen mit Dativ",
            "intro_bn": "কোথাও যেতে zu + Dativ: zum Bahnhof (zu dem) এবং zur Bank (zu der)।",
            "structure": ["Präposition", "Dativform", "Beispielsatz"],
            "items": [
                s("Wie komme ich zum Bahnhof?", "আমি স্টেশনে কীভাবে যাব?", "ভী কমে ইখ্ ৎসুম বানহোফ", [{"t": "Wie", "bn": "কীভাবে"}, {"t": "komme", "bn": "যাব"}, {"t": "ich", "bn": "আমি"}, {"t": "zum", "bn": "তে"}, {"t": "Bahnhof?", "bn": "স্টেশন"}]),
                s("Wie komme ich zur Post?", "আমি পোস্ট অফিসে কীভাবে যাব?", "ভী কমে ইখ্ ৎসুর পোস্ট", [{"t": "Wie", "bn": "কীভাবে"}, {"t": "komme", "bn": "যাব"}, {"t": "ich", "bn": "আমি"}, {"t": "zur", "bn": "তে"}, {"t": "Post?", "bn": "ডাকঘর"}]),
                s("Die Apotheke ist neben der Bank.", "ফার্মেসিটি ব্যাংকের পাশে।", "ডী আপোথেকে ইস্ত নেবেন ডের বাঙ্ক", [{"t": "Die", "bn": "টি"}, {"t": "Apotheke", "bn": "ফার্মেসি"}, {"t": "ist", "bn": "হয়"}, {"t": "neben", "bn": "পাশে"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Bank.", "bn": "ব্যাংক"}]),
                s("Das Hotel ist gegenüber dem Bahnhof.", "হোটেলটি স্টেশনের উল্টো দিকে।", "ডাস হোটেল ইস্ত গেগেনউ্যবার ডেম বানহোফ", [{"t": "Das", "bn": "টি"}, {"t": "Hotel", "bn": "হোটেল"}, {"t": "ist", "bn": "হয়"}, {"t": "gegenüber", "bn": "বিপরীতে"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Bahnhof.", "bn": "স্টেশন"}]),
                s("Ich bin in der Nähe.", "আমি কাছাকাছি আছি।", "ইখ্ বিন ইন ডের নেহে", [{"t": "Ich", "bn": "আমি"}, {"t": "bin", "bn": "আছি"}, {"t": "in", "bn": "এ"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Nähe.", "bn": "কাছে"}]),
                s("Gibt es hier eine Bank?", "এখানে কাছাকাছি কি কোনো ব্যাংক আছে?", "গিপ্ট এস হিয়ার আইনে বাঙ্ক", [{"t": "Gibt", "bn": "আছে"}, {"t": "es", "bn": "কি"}, {"t": "hier", "bn": "এখানে"}, {"t": "eine", "bn": "একটি"}, {"t": "Bank?", "bn": "ব্যাংক"}]),
                s("Ja, gleich um die Ecke.", "হ্যাঁ, ঠিক মোড় ঘুরলেই।", "ইয়া গ্লাইখ উম ডী একে", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "gleich", "bn": "ঠিক"}, {"t": "um", "bn": "ঘুরে"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Ecke.", "bn": "মোড়"}]),
                s("Vielen Dank für Ihre Hilfe!", "আপনার সাহায্যের জন্য অনেক ধন্যবাদ!", "ফিলেন ডাঙ্ক ফ্যুর ইরে হিলফে", [{"t": "Vielen", "bn": "অনেক"}, {"t": "Dank", "bn": "ধন্যবাদ"}, {"t": "für", "bn": "জন্য"}, {"t": "Ihre", "bn": "আপনার"}, {"t": "Hilfe!", "bn": "সাহায্য"}]),
            ]
        },
        {
            "title_bn": "রাস্তায় পথচারীর সাথে সংলাপ (Rollenspiel)",
            "title_target": "Dialog: Nach dem Weg fragen",
            "intro_bn": "শহরে অচেনা ব্যক্তির কাছে রাস্তা জানতে চাওয়া ও সাহায্য নেওয়ার পূর্ণাঙ্গ স্পোকেন রোল-প্লে।",
            "structure": ["Sprecher A", "Sprecher B", "Orientierung"],
            "items": [
                dl("A", "Entschuldigung, suchen Sie etwas?", "মাফ করবেন, আপনি কি কিছু খুঁজছেন?", "এন্টশুলডিগুং জুখেন যী এতভাস", [{"t": "Entschuldigung,", "bn": "মাফ করবেন"}, {"t": "suchen", "bn": "খুঁজছেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "etwas?", "bn": "কিছু"}]),
                dl("B", "Ja bitte, wo ist hier die Post?", "হ্যাঁ দয়া করে, পোস্ট অফিসটি এখানে কোথায়?", "ইয়া বিটে ভো ইস্ত হিয়ার ডী পোস্ট", [{"t": "Ja", "bn": "হ্যাঁ"}, {"t": "bitte,", "bn": "দয়া করে"}, {"t": "wo", "bn": "কোথায়"}, {"t": "ist", "bn": "হয়"}, {"t": "hier", "bn": "এখানে"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Post?", "bn": "ডাকঘর"}]),
                dl("A", "Gehen Sie geradeaus und dann links.", "সোজা এগিয়ে যান এবং তারপর বাঁয়ে যান।", "গেহেন যী গেরাদেআউস উন্ট ডান লিংকস", [{"t": "Gehen", "bn": "যান"}, {"t": "Sie", "bn": "আপনি"}, {"t": "geradeaus", "bn": "সোজা"}, {"t": "und", "bn": "এবং"}, {"t": "dann", "bn": "তারপর"}, {"t": "links.", "bn": "বাঁয়ে"}]),
                dl("B", "Ist die Post weit weg?", "পোস্ট অফিস কি অনেক দূর?", "ইস্ত ডী পোস্ট ভাইট ভেক", [{"t": "Ist", "bn": "হয়"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Post", "bn": "ডাকঘর"}, {"t": "weit", "bn": "দূর"}, {"t": "weg?", "bn": "দূরে"}]),
                s("Nein, in zwei Minuten sind Sie da.", "না, দুই মিনিটেই আপনি পৌঁছে যাবেন।", "নাইন ইন ৎস্ভাই মিনুটেন জিন্ট যী ডা", [{"t": "Nein,", "bn": "না"}, {"t": "in", "bn": "এ"}, {"t": "zwei", "bn": "দুই"}, {"t": "Minuten", "bn": "মিনিট"}, {"t": "sind", "bn": "হবেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "da.", "bn": "উপস্থিত"}]),
                s("Die Post ist neben der Apotheke.", "পোস্ট অফিসটি ফার্মেসির পাশে।", "ডী পোস্ট ইস্ত নেবেন ডের আপোথেকে", [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Post", "bn": "ডাকঘর"}, {"t": "ist", "bn": "হয়"}, {"t": "neben", "bn": "পাশে"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Apotheke.", "bn": "ফার্মেসি"}]),
                s("Herzlichen Dank für die Auskunft!", "তথ্য জানানোর জন্য আন্তরিক ধন্যবাদ!", "হেয়ার্ৎসলিখেন ডাঙ্ক ফ্যুর ডী আউসকুনফট", [{"t": "Herzlichen", "bn": "আন্তরিক"}, {"t": "Dank", "bn": "ধন্যবাদ"}, {"t": "für", "bn": "জন্য"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Auskunft!", "bn": "তথ্য"}]),
                s("Bitte sehr, gern geschehen!", "আপনাকে স্বাগতম, সানন্দে করেছি!", "বিটে জেয়ার গেয়ার্ন গেশেহেন", [{"t": "Bitte", "bn": "দয়া করে"}, {"t": "sehr,", "bn": "খুব"}, {"t": "gern", "bn": "আনন্দে"}, {"t": "geschehen!", "bn": "ঘটেছে"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit a1-11: বাসা-বাড়ি, আসবাবপত্র ও কক্ষ (Wohnen & Möbel)
# -------------------------------------------------------------
units["a1-11"] = {
    "title_bn": "বাসা-বাড়ি, আসবাবপত্র ও কক্ষ",
    "title_target": "Wohnen, Zimmer & Möbel",
    "lessons": [
        {
            "title_bn": "বাসার কক্ষ ও স্থানসমূহ (Räume im Haus)",
            "title_target": "Die Zimmer",
            "intro_bn": "রান্নাঘর die Küche, বসার ঘর das Wohnzimmer, বাথরুম das Bad, এবং শোবার ঘর das Schlafzimmer।",
            "structure": ["Artikel", "Zimmername", "Bedeutung"],
            "items": [
                w("das Wohnzimmer", "বসার ঘর / লিভিং রুম", "ডাস ভোনৎসিমার", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Wohnzimmer", "bn": "বসার ঘর"}]),
                w("das Schlafzimmer", "শোবার ঘর / বেডরুম", "ডাস শ্লাফৎসিমার", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Schlafzimmer", "bn": "শোবার ঘর"}]),
                w("die Küche", "রান্নাঘর", "ডী ক্যুখে", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Küche", "bn": "রান্নাঘর"}]),
                w("das Bad", "গোসলখানা / বাথরুম", "ডাস বাট", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Bad", "bn": "বাথরুম"}]),
                w("der Balkon", "বারান্দা", "ডের ব্যালকং", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Balkon", "bn": "বারান্দা"}]),
                w("der Flur", "করিডোর / প্রবেশ পথ", "ডের ফ্লুর", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Flur", "bn": "করিডোর"}]),
                w("der Garten", "বাগান", "ডের গার্টেন", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Garten", "bn": "বাগান"}]),
                w("die Wohnung", "অ্যাপার্টমেন্ট / ফ্ল্যাট", "ডী ভোনুং", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Wohnung", "bn": "অ্যাপার্টমেন্ট"}]),
            ]
        },
        {
            "title_bn": "আসবাবপত্র ও জিনিসপত্র (Möbel)",
            "title_target": "Möbelstücke",
            "intro_bn": "টেবিল der Tisch, চেয়ার der Stuhl, আলমারি der Schrank ও খাট das Bett।",
            "structure": ["Artikel", "Möbel", "Bedeutung"],
            "items": [
                w("der Tisch", "টেবিল", "ডের টিশ", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Tisch", "bn": "টেবিল"}]),
                w("der Stuhl", "চেয়ার", "ডের শ্টুল", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Stuhl", "bn": "চেয়ার"}]),
                w("das Bett", "বিছানা / খাট", "ডাস বেট", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Bett", "bn": "বিছানা"}]),
                w("der Schrank", "আলমারি / ওয়ারড্রোব", "ডের শ্রাঙ্ক", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Schrank", "bn": "আলমারি"}]),
                w("das Sofa", "সোফা", "ডাস জোফা", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Sofa", "bn": "সোফা"}]),
                w("die Lampe", "বাতি / ল্যাম্প", "ডী লাম্পে", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Lampe", "bn": "বাতি"}]),
                w("der Kühlschrank", "ফ্রিজ / রেফ্রিজারেটর", "ডের ক্যুলশ্রাঙ্ক", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Kühlschrank", "bn": "ফ্রিজ"}]),
                w("der Herd", "চুলা", "ডের হেয়ার্ট", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Herd", "bn": "চুলা"}]),
            ]
        },
        {
            "title_bn": "আসবাবপত্র কেনা ও আকুজাকটিভ প্র্যাকটিস",
            "title_target": "Akkusativ bei Möbeln",
            "intro_bn": "আকুজাকটিভে der বদলে den / einen হয়: Ich brauche einen Tisch, Wir kaufen einen Schrank।",
            "structure": ["Verb (brauchen/kaufen)", "Akkusativform", "Nomen"],
            "items": [
                s("Ich brauche einen Tisch.", "আমার একটি টেবিল প্রয়োজন।", "ইখ্ ব্রাউখে আইনেন টিশ", [{"t": "Ich", "bn": "আমার"}, {"t": "brauche", "bn": "প্রয়োজন"}, {"t": "einen", "bn": "একটি"}, {"t": "Tisch.", "bn": "টেবিল"}]),
                s("Wir kaufen einen neuen Schrank.", "আমরা একটি নতুন আলমারি কিনছি।", "ভির কাউফেন আইনেন নয়েন শ্রাঙ্ক", [{"t": "Wir", "bn": "আমরা"}, {"t": "kaufen", "bn": "কিনছি"}, {"t": "einen", "bn": "একটি"}, {"t": "neuen", "bn": "নতুন"}, {"t": "Schrank.", "bn": "আলমারি"}]),
                s("Hast du ein bequemes Bett?", "তোমার কি একটি আরামদায়ক বিছানা আছে?", "হাস্ট দু আইন বেক্ভেমেশ বেট", [{"t": "Hast", "bn": "আছে"}, {"t": "du", "bn": "তোমার"}, {"t": "ein", "bn": "একটি"}, {"t": "bequemes", "bn": "আরামদায়ক"}, {"t": "Bett?", "bn": "বিছানা"}]),
                s("Die Küche hat einen Kühlschrank.", "রান্নাঘরে একটি ফ্রিজ আছে।", "ডী ক্যুখে হাট আইনেন ক্যুলশ্রাঙ্ক", [{"t": "Die", "bn": "টি"}, {"t": "Küche", "bn": "রান্নাঘর"}, {"t": "hat", "bn": "আছে"}, {"t": "einen", "bn": "একটি"}, {"t": "Kühlschrank.", "bn": "ফ্রিজ"}]),
                s("Das Sofa ist sehr gemütlich.", "সোফাটি ভীষণ আরামদায়ক।", "ডাস জোফা ইস্ত জেয়ার গেম্যূৎলিখ", [{"t": "Das", "bn": "টি"}, {"t": "Sofa", "bn": "সোফা"}, {"t": "ist", "bn": "হয়"}, {"t": "sehr", "bn": "খুব"}, {"t": "gemütlich.", "bn": "আরামদায়ক"}]),
                s("Das Zimmer ist hell und groß.", "রুমটি আলো ঝলমলে এবং বড়।", "ডাস ৎসিমার ইস্ত হেল উন্ট গ্রোস", [{"t": "Das", "bn": "টি"}, {"t": "Zimmer", "bn": "রুম"}, {"t": "ist", "bn": "হয়"}, {"t": "hell", "bn": "উজ্জ্বল"}, {"t": "und", "bn": "এবং"}, {"t": "groß.", "bn": "বড়"}]),
                s("Die Wohnung gefällt mir gut.", "অ্যাপার্টমেন্টটি আমার খুব পছন্দ হয়েছে।", "ডী ভোনুং গেফেল্ট মিয়ার গুট", [{"t": "Die", "bn": "টি"}, {"t": "Wohnung", "bn": "বাসা"}, {"t": "gefällt", "bn": "পছন্দ হয়"}, {"t": "mir", "bn": "আমার"}, {"t": "gut.", "bn": "ভালো"}]),
                s("Wie hoch ist die Miete?", "বাড়ি ভাড়া কত?", "ভী হোখ ইস্ত ডী মীটে", [{"t": "Wie", "bn": "কত"}, {"t": "hoch", "bn": "উঁচু"}, {"t": "ist", "bn": "হয়"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Miete?", "bn": "ভাড়া"}]),
            ]
        },
        {
            "title_bn": "বাসা খোঁজা ও ভাড়ার সংলাপ (Wohnungsbesichtigung)",
            "title_target": "Dialog: Wohnung mieten",
            "intro_bn": "বাড়িওয়ালা ও ভাড়াটিয়ার কথোপকথনের বাস্তবসম্মত স্পোকেন ড্রিল।",
            "structure": ["Sprecher A", "Sprecher B", "Wohnungssuche"],
            "items": [
                dl("A", "Guten Tag, ist die Wohnung noch frei?", "শুভ দিন, বাসাটি কি এখনও খালি আছে?", "গুটেন তাক ইস্ত ডী ভোনুং নখ ফ্রাই", [{"t": "Guten", "bn": "শুভ"}, {"t": "Tag,", "bn": "দিন"}, {"t": "ist", "bn": "হয়"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Wohnung", "bn": "বাসা"}, {"t": "noch", "bn": "এখনও"}, {"t": "frei?", "bn": "খালি"}]),
                dl("B", "Ja, sie hat drei Zimmer und einen Balkon.", "হ্যাঁ, এতে তিনটি রুম এবং একটি বারান্দা আছে।", "ইয়া যী হাট ড্রাই ৎসিমার উন্ট আইনেন ব্যালকং", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "sie", "bn": "এতে"}, {"t": "hat", "bn": "আছে"}, {"t": "drei", "bn": "তিনটি"}, {"t": "Zimmer", "bn": "রুম"}, {"t": "und", "bn": "এবং"}, {"t": "einen", "bn": "একটি"}, {"t": "Balkon.", "bn": "বারান্দা"}]),
                dl("A", "Wie viel kostet die Warmmiete im Monat?", "মাসে গ্যাস-বিদ্যুৎসহ মোট ভাড়া কত পড়বে?", "ভী ফীল কস্টেট ডী ভার্মমীটে ইম মোনাট", [{"t": "Wie", "bn": "কত"}, {"t": "viel", "bn": "বেশি"}, {"t": "kostet", "bn": "খরচ পড়ে"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Warmmiete", "bn": "সবসহ ভাড়া"}, {"t": "im", "bn": "এ"}, {"t": "Monat?", "bn": "মাস"}]),
                dl("B", "Die Miete beträgt achthundert Euro warm.", "সব মিলিয়ে ভাড়া আটশত ইউরো।", "ডী মীটে বেট্রেখ্ট আখটহুন্ডার্ট অয়রো ভার্ম", [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Miete", "bn": "ভাড়া"}, {"t": "beträgt", "bn": "পরিমাণ দাঁড়ায়"}, {"t": "achthundert", "bn": "আটশত"}, {"t": "Euro", "bn": "ইউরো"}, {"t": "warm.", "bn": "উষ্ণসহ"}]),
                s("Kann ich die Wohnung morgen besichtigen?", "আমি কি কাল বাসাটি দেখতে পারি?", "কান ইখ্ ডী ভোনুং মর্গেন বেজিশ্টিগেন", [{"t": "Kann", "bn": "পারি"}, {"t": "ich", "bn": "আমি"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Wohnung", "bn": "বাসা"}, {"t": "morgen", "bn": "কাল"}, {"t": "besichtigen?", "bn": "পরিদর্শন করতে"}]),
                s("Ja gerne, um fünfzehn Uhr passt es.", "হ্যাঁ সানন্দে, বিকাল তিনটায় সুবিধাজনক সময়।", "ইয়া গেয়ার্নে উম ফ্যুনফৎসেন উর পাসট এস", [{"t": "Ja", "bn": "হ্যাঁ"}, {"t": "gerne,", "bn": "সানন্দে"}, {"t": "um", "bn": "এ"}, {"t": "fünfzehn", "bn": "পনেরো"}, {"t": "Uhr", "bn": "টায়"}, {"t": "passt", "bn": "খাপ খায়"}, {"t": "es.", "bn": "এটি"}]),
                s("Vielen Dank, bis morgen!", "অনেক ধন্যবাদ, কাল দেখা হবে!", "ফিলেন ডাঙ্ক বিস মর্গেন", [{"t": "Vielen", "bn": "অনেক"}, {"t": "Dank,", "bn": "ধন্যবাদ"}, {"t": "bis", "bn": "পর্যন্ত"}, {"t": "morgen!", "bn": "কাল"}]),
                s("Auf Wiedersehen, schönen Tag noch!", "বিদায়, বাকি দিনটি শুভ হোক!", "আউফ ভিডারজেহেন শোয়নেন তাক নখ", [{"t": "Auf", "bn": "পুনরায়"}, {"t": "Wiedersehen,", "bn": "দেখা"}, {"t": "schönen", "bn": "সুন্দর"}, {"t": "Tag", "bn": "দিন"}, {"t": "noch!", "bn": "হোক"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit a1-12: কেনাকাটা, পোশাক ও রঙ (Kleidung & Farben)
# -------------------------------------------------------------
units["a1-12"] = {
    "title_bn": "কেনাকাটা, পোশাক ও রঙ",
    "title_target": "Kleidung, Farben & Gefallen",
    "lessons": [
        {
            "title_bn": "পোশাকের নাম ও লিঙ্গ (Kleidungsstücke)",
            "title_target": "Kleidung",
            "intro_bn": "শার্ট das Hemd, প্যান্ট die Hose, জ্যাকেট die Jacke, এবং কোট der Mantel।",
            "structure": ["Artikel", "Kleidung", "Bedeutung"],
            "items": [
                w("das Hemd", "শার্ট", "ডাস হেম্ট", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Hemd", "bn": "শার্ট"}]),
                w("die Hose", "প্যান্ট", "ডী হোজে", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Hose", "bn": "প্যান্ট"}]),
                w("das Kleid", "মেয়েদের জামা / ড্রেস", "ডাস ক্লাইট", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Kleid", "bn": "জামা"}]),
                w("die Jacke", "জ্যাকেট", "ডী ইয়াক্কে", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Jacke", "bn": "জ্যাকেট"}]),
                w("der Mantel", "কোট / ওভারকোট", "ডের মান্টেল", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Mantel", "bn": "কোট"}]),
                w("die Schuhe", "জুতোজোড়া", "ডী শুহে", tokens=[{"t": "die", "bn": "গুলো"}, {"t": "Schuhe", "bn": "জুতো"}]),
                w("der Pullover", "সোয়েটার / পুলওভার", "ডের পুলোভার", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Pullover", "bn": "সোয়েটার"}]),
                w("das T-Shirt", "টি-শার্ট", "ডাস টী-শেয়ার্ট", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "T-Shirt", "bn": "টি-শার্ট"}]),
            ]
        },
        {
            "title_bn": "রঙের নাম ও বিবরণ (Die Farben)",
            "title_target": "Farben benennen",
            "intro_bn": "লাল rot, নীল blau, সবুজ grün, হলুদ gelb, কালো schwarz, সাদা weiß।",
            "structure": ["Farbe", "Objekt", "Bedeutung"],
            "items": [
                w("rot", "লাল", "রোট", tokens=[{"t": "rot", "bn": "লাল"}]),
                w("blau", "নীল", "ব্লাউ", tokens=[{"t": "blau", "bn": "নীল"}]),
                w("grün", "সবুজ", "গ্র্যূন", tokens=[{"t": "grün", "bn": "সবুজ"}]),
                w("gelb", "হলুদ", "গেল্প", tokens=[{"t": "gelb", "bn": "হলুদ"}]),
                w("schwarz", "কালো", "শ্ভার্ৎস", tokens=[{"t": "schwarz", "bn": "কালো"}]),
                w("weiß", "সাদা", "ভাইস", tokens=[{"t": "weiß", "bn": "সাদা"}]),
                w("grau", "ধূসর", "গ্রাউ", tokens=[{"t": "grau", "bn": "ধূসর"}]),
                w("braun", "বাদামি", "ব্রাউন", tokens=[{"t": "braun", "bn": "বাদামি"}]),
            ]
        },
        {
            "title_bn": "পছন্দ হওয়া ও ফিটিং (gefallen & passen)",
            "title_target": "Gefallen und Passen",
            "intro_bn": "পছন্দ হলে 'gefallen' (Das Hemd gefällt mir) এবং সাইজ ঠিক হলে 'passen' (Die Hose passt gut) বসে।",
            "structure": ["Verb", "Dativpronomen", "Bewertung"],
            "items": [
                s("Wie gefällt Ihnen dieser Mantel?", "এই কোটটি আপনার কেমন লাগছে?", "ভী গেফেল্ট ইনেন ডীজার মান্টেল", [{"t": "Wie", "bn": "কেমন"}, {"t": "gefällt", "bn": "লাগে"}, {"t": "Ihnen", "bn": "আপনার"}, {"t": "dieser", "bn": "এই"}, {"t": "Mantel?", "bn": "কোট"}]),
                s("Der Mantel gefällt mir sehr gut.", "কোটটি আমার খুব পছন্দ হয়েছে।", "ডের মান্টেল গেফেল্ট মিয়ার জেয়ার গুট", [{"t": "Der", "bn": "টি"}, {"t": "Mantel", "bn": "কোট"}, {"t": "gefällt", "bn": "পছন্দ হয়"}, {"t": "mir", "bn": "আমার"}, {"t": "sehr", "bn": "খুব"}, {"t": "gut.", "bn": "ভালো"}]),
                s("Welche Größe haben Sie?", "আপনার সাইজ কত?", "ভেলখে গ্রোয়সে হাবের্ন যী", [{"t": "Welche", "bn": "কোন"}, {"t": "Größe", "bn": "সাইজ"}, {"t": "haben", "bn": "আছে"}, {"t": "Sie?", "bn": "আপনার"}]),
                s("Ich trage Größe vierzig.", "আমি চল্লিশ সাইজ পরি।", "ইখ্ ট্রাগে গ্রোয়সে ফিয়ারৎসিখ", [{"t": "Ich", "bn": "আমি"}, {"t": "trage", "bn": "পরি"}, {"t": "Größe", "bn": "সাইজ"}, {"t": "vierzig.", "bn": "চল্লিশ"}]),
                s("Die Hose passt perfekt.", "প্যান্টটি নিখুঁতভাবে ফিট হয়েছে।", "ডী হোজে পাসট পেরফেক্ট", [{"t": "Die", "bn": "টি"}, {"t": "Hose", "bn": "প্যান্ট"}, {"t": "passt", "bn": "ফিট হয়"}, {"t": "perfekt.", "bn": "নিখুঁত"}]),
                s("Das T-Shirt ist zu klein.", "টি-শার্টটি বেশি ছোট হয়ে গেছে।", "ডাস টী-শেয়ার্ট ইস্ত ৎসু ক্লাইন", [{"t": "Das", "bn": "টি"}, {"t": "T-Shirt", "bn": "টি-শার্ট"}, {"t": "ist", "bn": "হয়"}, {"t": "zu", "bn": "খুব বেশি"}, {"t": "klein.", "bn": "ছোট"}]),
                s("Haben Sie das in Blau?", "এটি কি নীল রঙে আছে?", "হাবের্ন যী ডাস ইন ব্লাউ", [{"t": "Haben", "bn": "আছে"}, {"t": "Sie", "bn": "আপনাদের"}, {"t": "das", "bn": "এটি"}, {"t": "in", "bn": "এ"}, {"t": "Blau?", "bn": "নীল"}]),
                s("Ja, einen Moment bitte.", "হ্যাঁ, একটু অপেক্ষা করুন দয়া করে।", "ইয়া আইনেন মোমেন্ট বিটে", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "einen", "bn": "এক"}, {"t": "Moment", "bn": "মুহূর্ত"}, {"t": "bitte.", "bn": "দয়া করে"}]),
            ]
        },
        {
            "title_bn": "পোশাকের দোকানে কেনার সংলাপ (Im Modegeschäft)",
            "title_target": "Dialog: Kleidung kaufen",
            "intro_bn": "ট্রায়াল রুমে ট্রাই করা ও জামা কেনার কথোপকথন।",
            "structure": ["Sprecher A", "Sprecher B", "Kaufabwicklung"],
            "items": [
                dl("A", "Kann ich Ihnen helfen?", "আমি কি আপনাকে সাহায্য করতে পারি?", "কান ইখ্ ইনেন হেলফেন", [{"t": "Kann", "bn": "পারি"}, {"t": "ich", "bn": "আমি"}, {"t": "Ihnen", "bn": "আপনাকে"}, {"t": "helfen?", "bn": "সাহায্য করতে"}]),
                dl("B", "Ich suche eine schwarze Jacke.", "আমি একটি কালো জ্যাকেট খুঁজছি।", "ইখ্ জুখে আইনে শ্ভারৎসে ইয়াক্কে", [{"t": "Ich", "bn": "আমি"}, {"t": "suche", "bn": "খুঁজছি"}, {"t": "eine", "bn": "একটি"}, {"t": "schwarze", "bn": "কালো"}, {"t": "Jacke.", "bn": "জ্যাকেট"}]),
                dl("A", "Hier ist eine schöne Jacke.", "এই যে একটি সুন্দর জ্যাকেট আছে।", "হিয়ার ইস্ত আইনে শোয়নে ইয়াক্কে", [{"t": "Hier", "bn": "এখানে"}, {"t": "ist", "bn": "হয়"}, {"t": "eine", "bn": "একটি"}, {"t": "schöne", "bn": "সুন্দর"}, {"t": "Jacke.", "bn": "জ্যাকেট"}]),
                dl("B", "Wo ist die Umkleidekabine?", "ট্রায়াল রুমটি কোথায়?", "ভো ইস্ত ডী উমক্লাইডেকাবিনে", [{"t": "Wo", "bn": "কোথায়"}, {"t": "ist", "bn": "হয়"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Umkleidekabine?", "bn": "ট্রায়াল রুম"}]),
                s("Die Kabine ist da hinten rechts.", "ট্রায়াল রুমটি ওই পেছনে ডান দিকে।", "ডী কাবিনে ইস্ত ডা হিন্টেন রিখটস", [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Kabine", "bn": "রুম"}, {"t": "ist", "bn": "হয়"}, {"t": "da", "bn": "ওই"}, {"t": "hinten", "bn": "পেছনে"}, {"t": "rechts.", "bn": "ডানে"}]),
                s("Die Jacke passt mir sehr gut.", "জ্যাকেটটি আমার খুব ভালো ফিট হয়েছে।", "ডী ইয়াক্কে পাসট মিয়ার জেয়ার গুট", [{"t": "Die", "bn": "টি"}, {"t": "Jacke", "bn": "জ্যাকেট"}, {"t": "passt", "bn": "ফিট হয়"}, {"t": "mir", "bn": "আমার"}, {"t": "sehr", "bn": "খুব"}, {"t": "gut.", "bn": "ভালো"}]),
                s("Ich nehme sie gerne.", "আমি এটি নিচ্ছি সানন্দে।", "ইখ্ নেমে যী গেয়ার্নে", [{"t": "Ich", "bn": "আমি"}, {"t": "nehme", "bn": "নিচ্ছি"}, {"t": "sie", "bn": "এটি"}, {"t": "gerne.", "bn": "সানন্দে"}]),
                s("Bezahlen Sie bitte an der Kasse!", "ক্যাশ কাউন্টারে বিল পরিশোধ করুন!", "বেৎসালেন যী বিটে আন ডের কাসে", [{"t": "Bezahlen", "bn": "পরিশোধ করুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "an", "bn": "এ"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Kasse!", "bn": "কাউন্টার"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit a1-13: স্বাস্থ্য, অসুস্থতা ও ডাক্তারের অ্যাপয়েন্টমেন্ট
# -------------------------------------------------------------
units["a1-13"] = {
    "title_bn": "স্বাস্থ্য, অসুস্থতা ও ডাক্তারের অ্যাপয়েন্টমেন্ট",
    "title_target": "Gesundheit & Arzttermin",
    "lessons": [
        {
            "title_bn": "শরীরের বিভিন্ন অঙ্গপ্রত্যঙ্গ (Körperteile)",
            "title_target": "Der menschliche Körper",
            "intro_bn": "মাথা der Kopf, পেট der Bauch, পিঠ der Rücken, চোখ das Auge, কান das Ohr।",
            "structure": ["Artikel", "Körperteil", "Bedeutung"],
            "items": [
                w("der Kopf", "মাথা", "ডের কপফ", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Kopf", "bn": "মাথা"}]),
                w("der Bauch", "পেট", "ডের বাউখ", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Bauch", "bn": "পেট"}]),
                w("der Rücken", "পিঠ", "ডের র্যুকেন", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Rücken", "bn": "পিঠ"}]),
                w("der Hals", "গলা", "ডের হালস", gender="m", tokens=[{"t": "der", "bn": "টি"}, {"t": "Hals", "bn": "গলা"}]),
                w("das Auge", "চোখ", "ডাস আউগে", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Auge", "bn": "চোখ"}]),
                w("das Ohr", "কান", "ডাস ওর", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Ohr", "bn": "কান"}]),
                w("die Hand", "হাত", "ডী হান্ট", gender="f", tokens=[{"t": "die", "bn": "টি"}, {"t": "Hand", "bn": "হাত"}]),
                w("das Bein", "পা", "ডাস বাইন", gender="n", tokens=[{"t": "das", "bn": "টি"}, {"t": "Bein", "bn": "পা"}]),
            ]
        },
        {
            "title_bn": "অসুস্থতা ও ব্যথার কথা প্রকাশ (wehtun)",
            "title_target": "Schmerzen beschreiben",
            "intro_bn": "ব্যথা বোঝাতে 'wehtun' (Mein Kopf tut weh) অথবা 'Kopfschmerzen haben' ব্যবহৃত হয়।",
            "structure": ["Körperteil", "Verb wehtun", "Symptom"],
            "items": [
                s("Mein Kopf tut weh.", "আমার মাথা ব্যথা করছে।", "মাইন কপফ টুট ভেহ", [{"t": "Mein", "bn": "আমার"}, {"t": "Kopf", "bn": "মাথা"}, {"t": "tut", "bn": "করে"}, {"t": "weh.", "bn": "ব্যথা"}]),
                s("Ich habe Kopfschmerzen.", "আমার মাথা ব্যথা হয়েছে।", "ইখ্ হাবে কপফশ্মেরৎসেন", [{"t": "Ich", "bn": "আমার"}, {"t": "habe", "bn": "আছে"}, {"t": "Kopfschmerzen.", "bn": "মাথাব্যথা"}]),
                s("Mein Bauch tut weh.", "আমার পেট ব্যথা করছে।", "মাইন বাউখ টুট ভেহ", [{"t": "Mein", "bn": "আমার"}, {"t": "Bauch", "bn": "পেট"}, {"t": "tut", "bn": "করে"}, {"t": "weh.", "bn": "ব্যথা"}]),
                s("Ich habe hohes Fieber.", "আমার প্রচণ্ড জ্বর এসেছে।", "ইখ্ হাবে হোহেস ফাইবার", [{"t": "Ich", "bn": "আমার"}, {"t": "habe", "bn": "আছে"}, {"t": "hohes", "bn": "উঁচু"}, {"t": "Fieber.", "bn": "জ্বর"}]),
                s("Ich habe starken Husten.", "আমার প্রচণ্ড কাশি হচ্ছে।", "ইখ্ হাবে শ্টার্কেন হুস্টেন", [{"t": "Ich", "bn": "আমার"}, {"t": "habe", "bn": "আছে"}, {"t": "starken", "bn": "শক্তিশালী"}, {"t": "Husten.", "bn": "কাশি"}]),
                s("Ich fühle mich nicht gut.", "আমার শরীর ভালো লাগছে না।", "ইখ্ ফ্যূলে নিখ্ নিখ্ট গুট", [{"t": "Ich", "bn": "আমি"}, {"t": "fühle", "bn": "অনুভব করি"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "nicht", "bn": "না"}, {"t": "gut.", "bn": "ভালো"}]),
                s("Ich bin seit gestern krank.", "আমি গতকাল থেকে অসুস্থ।", "ইখ্ বিন জাইট গেস্টার্ন ক্রাঙ্ক", [{"t": "Ich", "bn": "আমি"}, {"t": "bin", "bn": "হই"}, {"t": "seit", "bn": "থেকে"}, {"t": "gestern", "bn": "গতকাল"}, {"t": "krank.", "bn": "অসুস্থ"}]),
                s("Gute Besserung!", "দ্রুত সুস্থতা কামনা করছি!", "গুটে বেসারুং", [{"t": "Gute", "bn": "ভালো"}, {"t": "Besserung!", "bn": "উন্নতি"}]),
            ]
        },
        {
            "title_bn": "ডাক্তারের পরামর্শ ও ওষুধ (Medikamente)",
            "title_target": "Ärztlicher Rat & Rezept",
            "intro_bn": "মডাল ভার্ব müssen (বাধ্যবাধকতা) এবং sollen (উচিত) ডাক্তারের উপদেশে ব্যবহৃত হয়।",
            "structure": ["Modalverb", "Empfehlung", "Apotheke"],
            "items": [
                s("Sie müssen im Bett bleiben.", "আপনার বিছানায় শুয়ে থাকা দরকার / বিশ্রাম নেওয়া আবশ্যক।", "যী ম্যূসেন ইম বেট ব্লাইবেন", [{"t": "Sie", "bn": "আপনার"}, {"t": "müssen", "bn": "হবে"}, {"t": "im", "bn": "এ"}, {"t": "Bett", "bn": "বিছানা"}, {"t": "bleiben.", "bn": "থাকা"}]),
                s("Trinken Sie viel warmen Tee!", "প্রচুর গরম চা পান করুন!", "ট্রিঙ্কেন যী ফীল ভার্মেন টে", [{"t": "Trinken", "bn": "পান করুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "viel", "bn": "অনেক"}, {"t": "warmen", "bn": "গরম"}, {"t": "Tee!", "bn": "চা"}]),
                s("Nehmen Sie diese Tabletten dreimal täglich!", "এই ওষুধগুলো দিনে তিনবার খাবেন!", "নেমেন যী ডীজে টাবলেটেন ড্রাইমাল টেগলিখ", [{"t": "Nehmen", "bn": "খান"}, {"t": "Sie", "bn": "আপনি"}, {"t": "diese", "bn": "এই"}, {"t": "Tabletten", "bn": "ট্যাবলেট"}, {"t": "dreimal", "bn": "তিনবার"}, {"t": "täglich!", "bn": "প্রতিদিন"}]),
                s("Hier ist Ihr Rezept für die Apotheke.", "ফার্মেসির জন্য এই নিন আপনার প্রেসক্রিপশন।", "হিয়ার ইস্ত ইর রেৎসেপ্ট ফ্যুর ডী আপোথেকে", [{"t": "Hier", "bn": "এখানে"}, {"t": "ist", "bn": "হয়"}, {"t": "Ihr", "bn": "আপনার"}, {"t": "Rezept", "bn": "প্রেসক্রিপশন"}, {"t": "für", "bn": "জন্য"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Apotheke.", "bn": "ফার্মেসি"}]),
                s("Ich brauche ein Schmerzmittel.", "আমার একটি ব্যথানাশক ওষুধ দরকার।", "ইখ্ ব্রাউখে আইন শ্মের্ৎসমিটেল", [{"t": "Ich", "bn": "আমার"}, {"t": "brauche", "bn": "দরকার"}, {"t": "ein", "bn": "একটি"}, {"t": "Schmerzmittel.", "bn": "ব্যথানাশক"}]),
                s("Haben Sie eine Krankenversicherung?", "আপনার কি স্বাস্থ্য বীমা (হেলথ ইন্স্যুরেন্স) আছে?", "হাবের্ন যী আইনে ক্রাঙ্কেনফেয়ার্জিখেরুং", [{"t": "Haben", "bn": "আছে"}, {"t": "Sie", "bn": "আপনার"}, {"t": "eine", "bn": "একটি"}, {"t": "Krankenversicherung?", "bn": "বীমা"}]),
                s("Ja, hier ist meine Versichertenkarte.", "হ্যাঁ, এই নিন আমার হেলথ কার্ড।", "ইয়া হিয়ার ইস্ত মাইনে ফেয়ার্জিখের্টেনকার্টে", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "hier", "bn": "এখানে"}, {"t": "ist", "bn": "হয়"}, {"t": "meine", "bn": "আমার"}, {"t": "Versichertenkarte.", "bn": "বীমা কার্ড"}]),
                s("Ruhen Sie sich gut aus!", "ভালোমতো বিশ্রাম নিন!", "রুহেন যী নিখ্ গুট আউস", [{"t": "Ruhen", "bn": "বিশ্রাম নিন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "sich", "bn": "নিজে"}, {"t": "gut", "bn": "ভালো"}, {"t": "aus!", "bn": "উপসর্গ"}]),
            ]
        },
        {
            "title_bn": "ক্লিনিকে অ্যাপয়েন্টমেন্টের সংলাপ (Beim Arzt)",
            "title_target": "Dialog: Termin vereinbaren",
            "intro_bn": "ডাক্তারের চেম্বারে রিসেপশনিস্টের সাথে অ্যাপয়েন্টমেন্ট ঠিক করার স্পোকেন রোল-প্লে।",
            "structure": ["Sprecher A", "Sprecher B", "Termin"],
            "items": [
                dl("A", "Praxis Doktor Müller, guten Tag!", "ডক্টর মুলারের চেম্বার, শুভ দিন!", "প্রাক্সিস ডক্টর ম্যুলার গুটেন তাক", [{"t": "Praxis", "bn": "চেম্বার"}, {"t": "Doktor", "bn": "ডাক্তার"}, {"t": "Müller,", "bn": "মুলার"}, {"t": "guten", "bn": "শুভ"}, {"t": "Tag!", "bn": "দিন"}]),
                dl("B", "Guten Tag, ich möchte einen Termin vereinbaren.", "শুভ দিন, আমি ডাক্তারের সাথে একটি অ্যাপয়েন্টমেন্ট করতে চাই।", "গুটেন তাক ইখ্ মোয়খ্টে আইনেন টেরমিন ফেয়ারআইনবারেন", [{"t": "Guten", "bn": "শুভ"}, {"t": "Tag,", "bn": "দিন"}, {"t": "ich", "bn": "আমি"}, {"t": "möchte", "bn": "চাই"}, {"t": "einen", "bn": "একটি"}, {"t": "Termin", "bn": "অ্যাপয়েন্টমেন্ট"}, {"t": "vereinbaren.", "bn": "স্থির করতে"}]),
                dl("A", "Haben Sie heute Schmerzen?", "আপনার কি আজ বেশি ব্যথা বা তীব্র সমস্যা আছে?", "হাবের্ন যী হয়টে শ্মেরৎসেন", [{"t": "Haben", "bn": "আছে"}, {"t": "Sie", "bn": "আপনার"}, {"t": "heute", "bn": "আজ"}, {"t": "Schmerzen?", "bn": "ব্যথা"}]),
                dl("B", "Ja, ich habe hohes Fieber und Halsschmerzen.", "হ্যাঁ, আমার প্রচণ্ড জ্বর ও গলাব্যথা রয়েছে।", "ইয়া ইখ্ হাবে হোহেস ফাইবার উন্ট হালসশ্মেরৎসেন", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "ich", "bn": "আমার"}, {"t": "habe", "bn": "আছে"}, {"t": "hohes", "bn": "বেশি"}, {"t": "Fieber", "bn": "জ্বর"}, {"t": "und", "bn": "এবং"}, {"t": "Halsschmerzen.", "bn": "গলাব্যথা"}]),
                s("Kommen Sie bitte heute um elf Uhr vorbei!", "দয়া করে আজ সকাল এগারোটায় চলে আসুন!", "কমেন যী বিটে হয়টে উম এলফ উর ফোরবাই", [{"t": "Kommen", "bn": "আসুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "heute", "bn": "আজ"}, {"t": "um", "bn": "এ"}, {"t": "elf", "bn": "এগারো"}, {"t": "Uhr", "bn": "টায়"}, {"t": "vorbei!", "bn": "দেখা করতে"}]),
                s("Bringen Sie Ihre Versicherungskarte mit!", "আপনার ইন্স্যুরেন্স কার্ড সাথে আনবেন!", "ব্রিঙ্গেন যী ইরে ফেয়ার্জিখেরুংসকার্টে মিট", [{"t": "Bringen", "bn": "আনবেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "Ihre", "bn": "আপনার"}, {"t": "Versicherungskarte", "bn": "বীমা কার্ড"}, {"t": "mit!", "bn": "সাথে"}]),
                s("Vielen Dank, ich komme um elf Uhr.", "অনেক ধন্যবাদ, আমি এগারোটায় আসব।", "ফিলেন ডাঙ্ক ইখ্ কমে উম এলফ উর", [{"t": "Vielen", "bn": "অনেক"}, {"t": "Dank,", "bn": "ধন্যবাদ"}, {"t": "ich", "bn": "আমি"}, {"t": "komme", "bn": "আসব"}, {"t": "um", "bn": "এ"}, {"t": "elf", "bn": "এগারো"}, {"t": "Uhr.", "bn": "টায়"}]),
                s("Gute Besserung und bis gleich!", "দ্রুত সুস্থ হোন এবং একটু পরেই দেখা হচ্ছে!", "গুটে বেসারুং উন্ট বিস গ্লাইখ", [{"t": "Gute", "bn": "ভালো"}, {"t": "Besserung", "bn": "সুস্থতা"}, {"t": "und", "bn": "এবং"}, {"t": "bis", "bn": "পর্যন্ত"}, {"t": "gleich!", "bn": "শীঘ্রই"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit a1-14: অতীত অভিজ্ঞতা ও পারফেক্ট কাল (Perfekt mit haben & sein)
# -------------------------------------------------------------
units["a1-14"] = {
    "title_bn": "অতীত অভিজ্ঞতা ও পারফেক্ট কাল",
    "title_target": "Das Perfekt: haben & sein",
    "lessons": [
        {
            "title_bn": "haben সহ পারফেক্ট কাল (gemacht, gelernt)",
            "title_target": "Perfekt mit haben",
            "intro_bn": "স্পোকেন জার্মানে অতীতের কথা বলতে 'haben' (Position 2) এবং বাক্যের একেবারে শেষে পারফেক্ট রূপ Partizip II (ge-...-t) বসে।",
            "structure": ["haben (Pos 2)", "Satzmitte", "Partizip II (Ende)"],
            "items": [
                s("Was hast du am Wochenende gemacht?", "সাপ্তাহিক ছুটিতে তুমি কী করেছো?", "ভাস হাস্ট দু আম ভখেনএন্ডে গেমাখট", [{"t": "Was", "bn": "কী"}, {"t": "hast", "bn": "আছো"}, {"t": "du", "bn": "তুমি"}, {"t": "am", "bn": "এ"}, {"t": "Wochenende", "bn": "ছুটি"}, {"t": "gemacht?", "bn": "করেছো"}]),
                s("Ich habe viel Deutsch gelernt.", "আমি অনেক জার্মান শিখেছি।", "ইখ্ হাবে ফীল ডয়চ গেলের্নট", [{"t": "Ich", "bn": "আমি"}, {"t": "habe", "bn": "আছি"}, {"t": "viel", "bn": "অনেক"}, {"t": "Deutsch", "bn": "জার্মান"}, {"t": "gelernt.", "bn": "শিখেছি"}]),
                s("Er hat gestern Fußball gespielt.", "সে গতকাল ফুটবল খেলেছে।", "এর হাট গেস্টার্ন ফুসবাল গেশ্পীলট", [{"t": "Er", "bn": "সে"}, {"t": "hat", "bn": "আছে"}, {"t": "gestern", "bn": "গতকাল"}, {"t": "Fußball", "bn": "ফুটবল"}, {"t": "gespielt.", "bn": "খেলেছে"}]),
                s("Wir haben zusammen gekocht.", "আমরা একসাথে রান্না করেছি।", "ভির হাবের্ন ৎসুসামেন গেকখট", [{"t": "Wir", "bn": "আমরা"}, {"t": "haben", "bn": "আছি"}, {"t": "zusammen", "bn": "একসাথে"}, {"t": "gekocht.", "bn": "রান্না করেছি"}]),
                s("Ich habe Musik gehört.", "আমি গান শুনেছি।", "ইখ্ হাবে মুযীক গেহোয়ের্ট", [{"t": "Ich", "bn": "আমি"}, {"t": "habe", "bn": "আছি"}, {"t": "Musik", "bn": "গান"}, {"t": "gehört.", "bn": "শুনেছি"}]),
                s("Hast du deine Hausaufgaben gemacht?", "তুমি কি তোমার হোমওয়ার্ক করেছো?", "হাস্ট দু ডাইনে হাউসআউফগাবেন গেমাখট", [{"t": "Hast", "bn": "আছো"}, {"t": "du", "bn": "তুমি"}, {"t": "deine", "bn": "তোমার"}, {"t": "Hausaufgaben", "bn": "হোমওয়ার্ক"}, {"t": "gemacht?", "bn": "করেছো"}]),
                s("Ja, ich habe alles fertig gemacht.", "হ্যাঁ, আমি সবকিছু শেষ করেছি।", "ইয়া ইখ্ হাবে আলেস ফেয়ার্টিখ গেমাখট", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "ich", "bn": "আমি"}, {"t": "habe", "bn": "আছি"}, {"t": "alles", "bn": "সব"}, {"t": "fertig", "bn": "প্রস্তুত"}, {"t": "gemacht.", "bn": "করেছি"}]),
                s("Wir haben lange telefoniert.", "আমরা অনেকক্ষণ ফোনে কথা বলেছি।", "ভির হাবের্ন লাঙে টেলিফোনিয়ার্ট", [{"t": "Wir", "bn": "আমরা"}, {"t": "haben", "bn": "আছি"}, {"t": "lange", "bn": "অনেকক্ষণ"}, {"t": "telefoniert.", "bn": "ফোনে কথা বলেছি"}]),
            ]
        },
        {
            "title_bn": "sein সহ পারফেক্ট কাল: স্থান পরিবর্তন (gefahren, gegangen)",
            "title_target": "Perfekt mit sein",
            "intro_bn": "এক স্থান থেকে অন্য স্থানে যাওয়া বা অবস্থার পরিবর্তন বোঝালে সহায়ক ক্রিয়া 'sein' বসে (Ich bin gefahren, Wir sind gegangen)।",
            "structure": ["sein (Pos 2)", "Ortsangabe", "Bewegungsverb (Ende)"],
            "items": [
                s("Ich bin nach Berlin gefahren.", "আমি বার্লিনে গিয়েছিলাম (গাড়িতে/ট্রেনে)।", "ইখ্ বিন নাখ বের্লিন গেফারেন", [{"t": "Ich", "bn": "আমি"}, {"t": "bin", "bn": "হই"}, {"t": "nach", "bn": "তে"}, {"t": "Berlin", "bn": "বার্লিন"}, {"t": "gefahren.", "bn": "ভ্রমণ করেছি"}]),
                s("Wann bist du aufgestanden?", "তুমি কখন ঘুম থেকে উঠেছিলে?", "ভান বিস্ট দু আউফগেশ্টান্ডেন", [{"t": "Wann", "bn": "কখন"}, {"t": "bist", "bn": "হও"}, {"t": "du", "bn": "তুমি"}, {"t": "aufgestanden?", "bn": "উঠেছিলে"}]),
                s("Ich bin um sieben Uhr aufgestanden.", "আমি সকাল সাতটায় ঘুম থেকে উঠেছিলাম।", "ইখ্ বিন উম যীবেন উর আউফগেশ্টান্ডেন", [{"t": "Ich", "bn": "আমি"}, {"t": "bin", "bn": "হই"}, {"t": "um", "bn": "এ"}, {"t": "sieben", "bn": "সাত"}, {"t": "Uhr", "bn": "টায়"}, {"t": "aufgestanden.", "bn": "উঠেছি"}]),
                s("Wir sind in den Park gegangen.", "আমরা পার্কে হেঁটে গিয়েছিলাম।", "ভির জিন্ট ইন ডেন পার্ক গেগাঙ্গেন", [{"t": "Wir", "bn": "আমরা"}, {"t": "sind", "bn": "হই"}, {"t": "in", "bn": "এ"}, {"t": "den", "bn": "নির্দিষ্ট"}, {"t": "Park", "bn": "পার্ক"}, {"t": "gegangen.", "bn": "গিয়েছি"}]),
                s("Er ist zu spät gekommen.", "সে অনেক দেরিতে এসেছিল।", "এর ইস্ত ৎসু শ্পেট গেকমেন", [{"t": "Er", "bn": "সে"}, {"t": "ist", "bn": "হয়"}, {"t": "zu", "bn": "খুব"}, {"t": "spät", "bn": "দেরি"}, {"t": "gekommen.", "bn": "এসেছে"}]),
                s("Bist du nach Hause gelaufen?", "তুমি কি দৌড়ে বাসায় গিয়েছিলে?", "বিস্ট দু নাখ হাউজে গেলাউফেন", [{"t": "Bist", "bn": "হও"}, {"t": "du", "bn": "তুমি"}, {"t": "nach", "bn": "তে"}, {"t": "Hause", "bn": "বাড়ি"}, {"t": "gelaufen?", "bn": "দৌড়ে গিয়েছো"}]),
                s("Das Flugzeug ist pünktlich gelandet.", "বিমানটি সময়মতো অবতরণ করেছিল।", "ডাস ফ্লুকৎসয়ক ইস্ত প্যুনকটলিখ গেলান্ডেট", [{"t": "Das", "bn": "টি"}, {"t": "Flugzeug", "bn": "বিমান"}, {"t": "ist", "bn": "হয়"}, {"t": "pünktlich", "bn": "সময়মতো"}, {"t": "gelandet.", "bn": "অবতরণ করেছে"}]),
                s("Wie ist deine Reise gewesen?", "তোমার ভ্রমণ কেমন ছিল (sein-এর পারফেক্ট)?", "ভী ইস্ত ডাইনে রাইজে গেভেজেন", [{"t": "Wie", "bn": "কেমন"}, {"t": "ist", "bn": "হয়"}, {"t": "deine", "bn": "তোমার"}, {"t": "Reise", "bn": "ভ্রমণ"}, {"t": "gewesen?", "bn": "ছিল"}]),
            ]
        },
        {
            "title_bn": "গত ছুটির অভিজ্ঞতা বর্ণনা (Wochenendbericht)",
            "title_target": "Über Vergangenes berichten",
            "intro_bn": "ছুটির গল্প বা অতীতের কোনো দিন একটানা সাবলীলভাবে বলার ড্রিল।",
            "structure": ["Ereignis", "Perfektform", "Erlebnis"],
            "items": [
                s("Am Samstag habe ich Freunde getroffen.", "শনিবার আমি বন্ধুদের সাথে দেখা করেছি।", "আম জামসতাক হাবে ইখ্ ফ্রয়ন্ডে গেট্রফেন", [{"t": "Am", "bn": "এ"}, {"t": "Samstag", "bn": "শনিবার"}, {"t": "habe", "bn": "আছি"}, {"t": "ich", "bn": "আমি"}, {"t": "Freunde", "bn": "বন্ধুদের"}, {"t": "getroffen.", "bn": "দেখা করেছি"}]),
                s("Wir haben Kaffee getrunken und geredet.", "আমরা কফি পান করেছি ও আড্ডা দিয়েছি।", "ভির হাবের্ন কাফে গেট্রুনকেন উন্ট গেরেডেট", [{"t": "Wir", "bn": "আমরা"}, {"t": "haben", "bn": "আছি"}, {"t": "Kaffee", "bn": "কফি"}, {"t": "getrunken", "bn": "পান করেছি"}, {"t": "und", "bn": "এবং"}, {"t": "geredet.", "bn": "কথা বলেছি"}]),
                s("Das Wetter war wirklich schön.", "আবহাওয়া সত্যিই সুন্দর ছিল।", "ডাস ভেটার ভার ভির্কলিখ শোয়ন", [{"t": "Das", "bn": "টি"}, {"t": "Wetter", "bn": "আবহাওয়া"}, {"t": "war", "bn": "ছিল"}, {"t": "wirklich", "bn": "সত্যিই"}, {"t": "schön.", "bn": "সুন্দর"}]),
                s("Am Sonntag bin ich lange im Bett geblieben.", "রবিবার আমি দীর্ঘ সময় বিছানায় শুয়ে ছিলাম।", "আম জোনতাক বিন ইখ্ লাঙে ইম বেট গেব্লীবেন", [{"t": "Am", "bn": "এ"}, {"t": "Sonntag", "bn": "রবিবার"}, {"t": "bin", "bn": "হই"}, {"t": "ich", "bn": "আমি"}, {"t": "lange", "bn": "অনেকক্ষণ"}, {"t": "im", "bn": "এ"}, {"t": "Bett", "bn": "বিছানা"}, {"t": "geblieben.", "bn": "থেকেছি"}]),
                s("Ich habe einen Film auf Deutsch gesehen.", "আমি জার্মানে একটি সিনেমা দেখেছি।", "ইখ্ হাবে আইনেন ফিল্ম আউফ ডয়চ গেজেহেন", [{"t": "Ich", "bn": "আমি"}, {"t": "habe", "bn": "আছি"}, {"t": "einen", "bn": "একটি"}, {"t": "Film", "bn": "সিনেমা"}, {"t": "auf", "bn": "তে"}, {"t": "Deutsch", "bn": "জার্মান"}, {"t": "gesehen.", "bn": "দেখেছি"}]),
                s("Ich habe fast alles verstanden.", "আমি প্রায় সবকিছুই বুঝতে পেরেছি।", "ইখ্ হাবে ফাস্ট আলেস ফেয়ার্শ্টান্ডেন", [{"t": "Ich", "bn": "আমি"}, {"t": "habe", "bn": "আছি"}, {"t": "fast", "bn": "প্রায়"}, {"t": "alles", "bn": "সব"}, {"t": "verstanden.", "bn": "বুঝেছি"}]),
                s("Das war ein tolles Wochenende.", "এটি একটি দারুণ সাপ্তাহিক ছুটি ছিল।", "ডাস ভার আইন টলেস ভখেনএন্ডে", [{"t": "Das", "bn": "এটি"}, {"t": "war", "bn": "ছিল"}, {"t": "ein", "bn": "একটি"}, {"t": "tolles", "bn": "চমৎকার"}, {"t": "Wochenende.", "bn": "ছুটি"}]),
                s("Ich habe mich gut erholt.", "আমি খুব ভালো সতেজতা বা বিশ্রাম পেয়েছি।", "ইখ্ হাবে নিখ্ গুট এয়ারহোল্ট", [{"t": "Ich", "bn": "আমি"}, {"t": "habe", "bn": "আছি"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "gut", "bn": "ভালো"}, {"t": "erholt.", "bn": "বিশ্রাম নিয়েছি"}]),
            ]
        },
        {
            "title_bn": "ছুটির অভিজ্ঞতা বিনিময়ের সংলাপ (Reiseerlebnis)",
            "title_target": "Dialog: Urlaub & Reise",
            "intro_bn": "ছুটি কোথায় কাটিয়েছেন এবং কেমন লাগলো তা নিয়ে পারস্পরিক কথোপকথন।",
            "structure": ["Sprecher A", "Sprecher B", "Urlaub"],
            "items": [
                dl("A", "Hallo Alex, wo bist du im Urlaub gewesen?", "হ্যালো অ্যালেক্স, তুমি ছুটিতে কোথায় গিয়েছিলে?", "হালো আলেকস ভো বিস্ট দু ইম উরলাউপ গেভেজেন", [{"t": "Hallo", "bn": "হ্যালো"}, {"t": "Alex,", "bn": "অ্যালেক্স"}, {"t": "wo", "bn": "কোথায়"}, {"t": "bist", "bn": "হও"}, {"t": "du", "bn": "তুমি"}, {"t": "im", "bn": "এ"}, {"t": "Urlaub", "bn": "ছুটি"}, {"t": "gewesen?", "bn": "ছিলে"}]),
                dl("B", "Ich bin nach München gefahren.", "আমি মিউনিখে গিয়েছিলাম।", "ইখ্ বিন নাখ ম্যুনশেন গেফারেন", [{"t": "Ich", "bn": "আমি"}, {"t": "bin", "bn": "হই"}, {"t": "nach", "bn": "তে"}, {"t": "München", "bn": "মিউনিখ"}, {"t": "gefahren.", "bn": "গিয়েছি"}]),
                dl("A", "Toll! Wie lange bist du dort geblieben?", "দারুণ! তুমি সেখানে কতদিন ছিলে?", "টল ভী লাঙে বিস্ট দু ডর্ট গেব্লীবেন", [{"t": "Toll!", "bn": "দারুণ"}, {"t": "Wie", "bn": "কত"}, {"t": "lange", "bn": "দীর্ঘ"}, {"t": "bist", "bn": "হও"}, {"t": "du", "bn": "তুমি"}, {"t": "dort", "bn": "সেখানে"}, {"t": "geblieben?", "bn": "ছিলে"}]),
                dl("B", "Ich bin eine Woche dort geblieben.", "আমি সেখানে এক সপ্তাহ ছিলাম।", "ইখ্ বিন আইনে ভখে ডর্ট গেব্লীবেন", [{"t": "Ich", "bn": "আমি"}, {"t": "bin", "bn": "হই"}, {"t": "eine", "bn": "এক"}, {"t": "Woche", "bn": "সপ্তাহ"}, {"t": "dort", "bn": "সেখানে"}, {"t": "geblieben.", "bn": "থেকেছি"}]),
                s("Hast du das Schloss Neuschwanstein besucht?", "তুমি কি নয়েইশোয়ানস্টাইন দুর্গ দেখতে গিয়েছিলে?", "হাস্ট দু ডাস শ্লস নয়াশোয়ানস্টাইন বেজুখট", [{"t": "Hast", "bn": "আছো"}, {"t": "du", "bn": "তুমি"}, {"t": "das", "bn": "টি"}, {"t": "Schloss", "bn": "দুর্গ"}, {"t": "Neuschwanstein", "bn": "নয়েইশোয়ানস্টাইন"}, {"t": "besucht?", "bn": "পরিদর্শন করেছো"}]),
                s("Ja, das Schloss war atemberaubend schön.", "হ্যাঁ, দুর্গটি শ্বাসরুদ্ধকর সুন্দর ছিল।", "ইয়া ডাস শ্লস ভার আটেমবেরাউবেন্ট শোয়ন", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "das", "bn": "টি"}, {"t": "Schloss", "bn": "দুর্গ"}, {"t": "war", "bn": "ছিল"}, {"t": "atemberaubend", "bn": "অবিশ্বাস্য"}, {"t": "schön.", "bn": "সুন্দর"}]),
                s("Ich habe viele Fotos gemacht.", "আমি অনেক ছবি তুলেছি।", "ইখ্ হাবে ফীলে ফোটোস গেমাখট", [{"t": "Ich", "bn": "আমি"}, {"t": "habe", "bn": "আছি"}, {"t": "viele", "bn": "অনেক"}, {"t": "Fotos", "bn": "ছবি"}, {"t": "gemacht.", "bn": "তুলেছি"}]),
                s("Ich zeige dir die Fotos morgen.", "আমি কাল তোমাকে ছবিগুলো দেখাব।", "ইখ্ ৎসায়গে ডিয়ার ডী ফোটোস মর্গেন", [{"t": "Ich", "bn": "আমি"}, {"t": "zeige", "bn": "দেখাব"}, {"t": "dir", "bn": "তোমাকে"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Fotos", "bn": "ছবিগুলো"}, {"t": "morgen.", "bn": "কাল"}]),
            ]
        }
    ]
}

# -------------------------------------------------------------
# Unit a1-15: ভ্রমণ, আবহাওয়া ও A1 সমাপনী টেস্ট
# -------------------------------------------------------------
units["a1-15"] = {
    "title_bn": "ভ্রমণ, আবহাওয়া ও A1 সমাপনী টেস্ট",
    "title_target": "Reisen, Wetter & A1-Abschlusstest",
    "lessons": [
        {
            "title_bn": "আবহাওয়া ও তাপমাত্রা (Das Wetter heute)",
            "title_target": "Wetter & Temperatur",
            "intro_bn": "বৃষ্টি হচ্ছে es regnet, রোদ উঠেছে die Sonne scheint, গরম es ist warm, ঠান্ডা es ist kalt।",
            "structure": ["Wetterphänomen", "Temperatur", "Jahreszeit"],
            "items": [
                s("Wie ist das Wetter heute?", "আজকের আবহাওয়া কেমন?", "ভী ইস্ত ডাস ভেটার হয়টে", [{"t": "Wie", "bn": "কেমন"}, {"t": "ist", "bn": "হয়"}, {"t": "das", "bn": "নির্দিষ্ট"}, {"t": "Wetter", "bn": "আবহাওয়া"}, {"t": "heute?", "bn": "আজ"}]),
                s("Die Sonne scheint den ganzen Tag.", "সারাদিন সূর্য কিরণ দিচ্ছে / রোদ উজ্জ্বল।", "ডী জোনে শাইনট ডেন গানৎসেন তাক", [{"t": "Die", "bn": "নির্দিষ্ট"}, {"t": "Sonne", "bn": "সূর্য"}, {"t": "scheint", "bn": "কিরণ দেয়"}, {"t": "den", "bn": "পুরো"}, {"t": "ganzen", "bn": "সারা"}, {"t": "Tag.", "bn": "দিন"}]),
                s("Es ist warm und sonnig.", "আজকের দিনটি উষ্ণ ও রৌদ্রোজ্জ্বল।", "এস ইস্ত ভার্ম উন্ট জনিখ", [{"t": "Es", "bn": "এটি"}, {"t": "ist", "bn": "হয়"}, {"t": "warm", "bn": "উষ্ণ"}, {"t": "und", "bn": "এবং"}, {"t": "sonnig.", "bn": "রৌদ্রোজ্জ্বল"}]),
                s("Heute regnet es leider.", "আজ দুর্ভাগ্যবশত বৃষ্টি হচ্ছে।", "হয়টে রেগনেট এস লাইডার", [{"t": "Heute", "bn": "আজ"}, {"t": "regnet", "bn": "বৃষ্টি হচ্ছে"}, {"t": "es", "bn": "এটি"}, {"t": "leider.", "bn": "দুর্ভাগ্যবশত"}]),
                s("Es hat zwanzig Grad.", "আজকের তাপমাত্রা বিশ ডিগ্রি সেলসিয়াস।", "এস হাট ৎস্ভানৎসিখ গ্রাট", [{"t": "Es", "bn": "এটি"}, {"t": "hat", "bn": "আছে"}, {"t": "zwanzig", "bn": "বিশ"}, {"t": "Grad.", "bn": "ডিগ্রি"}]),
                s("Im Winter ist es sehr windig.", "শীতকালে বেশ বাতাস থাকে।", "ইম ভিন্টার ইস্ত এস জেয়ার ভিনডিখ", [{"t": "Im", "bn": "এ"}, {"t": "Winter", "bn": "শীত"}, {"t": "ist", "bn": "হয়"}, {"t": "es", "bn": "এটি"}, {"t": "sehr", "bn": "খুব"}, {"t": "windig.", "bn": "বাতাসময়"}]),
                s("Morgen wird es wieder schön.", "কাল আবহাওয়া আবার সুন্দর হবে।", "মর্গেন ভির্ট এস ভিডার শোয়ন", [{"t": "Morgen", "bn": "কাল"}, {"t": "wird", "bn": "হবে"}, {"t": "es", "bn": "এটি"}, {"t": "wieder", "bn": "আবার"}, {"t": "schön.", "bn": "সুন্দর"}]),
                s("Vergiss deinen Regenschirm nicht!", "তোমার ছাতাটি নিতে ভুলো না!", "ফেয়ারগিস ডাইনেন রেগেনশির্ম নিখ্ট", [{"t": "Vergiss", "bn": "ভুলো না"}, {"t": "deinen", "bn": "তোমার"}, {"t": "Regenschirm", "bn": "ছাতা"}, {"t": "nicht!", "bn": "না"}]),
            ]
        },
        {
            "title_bn": "গণপরিবহন ও স্টেশন ঘোষণা (Fahrkarten & Bahn)",
            "title_target": "Öffentlicher Verkehr",
            "intro_bn": "ট্রেনের টিকিট কাটা, প্লাটফর্ম ও ট্রেনের বিলম্ব সম্পর্কে ঘোষণার বাক্য।",
            "structure": ["Fahrkarte", "Gleis", "Verspätung"],
            "items": [
                s("Eine Fahrkarte nach Berlin bitte.", "বার্লিনের জন্য একটি টিকিট দিন দয়া করে।", "আইনে ফারকার্টে নাখ বের্লিন বিটে", [{"t": "Eine", "bn": "একটি"}, {"t": "Fahrkarte", "bn": "টিকিট"}, {"t": "nach", "bn": "তে"}, {"t": "Berlin", "bn": "বার্লিন"}, {"t": "bitte.", "bn": "দয়া করে"}]),
                s("Einfach oder hin und zurück?", "ওয়ান-ওয়ে নাকি আসা-যাওয়া (রিটার্ন)?", "আইনফাখ ওডার হিন উন্ট ৎসুরু্যক", [{"t": "Einfach", "bn": "ওয়ান-ওয়ে"}, {"t": "oder", "bn": "নাকি"}, {"t": "hin", "bn": "যাওয়া"}, {"t": "und", "bn": "এবং"}, {"t": "zurück?", "bn": "ফেরা"}]),
                s("Hin und zurück bitte.", "আসা-যাওয়া রিটার্ন টিকিট দিন দয়া করে।", "হিন উন্ট ৎসুরু্যক বিটে", [{"t": "Hin", "bn": "যাওয়া"}, {"t": "und", "bn": "এবং"}, {"t": "zurück", "bn": "ফেরা"}, {"t": "bitte.", "bn": "দয়া করে"}]),
                s("Von welchem Gleis fährt der Zug ab?", "ট্রেনটি কোন প্ল্যাটফর্ম থেকে ছাড়বে?", "ফন ভেলখেম গ্লাইস ফেয়ার্ট ডের ৎসুক আপ", [{"t": "Von", "bn": "থেকে"}, {"t": "welchem", "bn": "কোন"}, {"t": "Gleis", "bn": "প্ল্যাটফর্ম"}, {"t": "fährt", "bn": "ছাড়ে"}, {"t": "der", "bn": "টি"}, {"t": "Zug", "bn": "ট্রেন"}, {"t": "ab?", "bn": "উপসর্গ"}]),
                s("Der Zug fährt von Gleis vier ab.", "ট্রেনটি চার নম্বর প্ল্যাটফর্ম থেকে ছাড়বে।", "ডের ৎসুক ফেয়ার্ট ফন গ্লাইস ফিয়ার আপ", [{"t": "Der", "bn": "টি"}, {"t": "Zug", "bn": "ট্রেন"}, {"t": "fährt", "bn": "ছাড়ে"}, {"t": "von", "bn": "থেকে"}, {"t": "Gleis", "bn": "প্ল্যাটফর্ম"}, {"t": "vier", "bn": "চার"}, {"t": "ab.", "bn": "উপসর্গ"}]),
                s("Der ICE hat zehn Minuten Verspätung.", "আইসিই ট্রেনটির দশ মিনিট বিলম্ব আছে।", "ডের ই সে এ হাট ৎসেন মিনুটেন ফেয়ার্শ্পেটুং", [{"t": "Der", "bn": "টি"}, {"t": "ICE", "bn": "দ্রুতগামী ট্রেন"}, {"t": "hat", "bn": "আছে"}, {"t": "zehn", "bn": "দশ"}, {"t": "Minuten", "bn": "মিনিট"}, {"t": "Verspätung.", "bn": "দেরি"}]),
                s("Vorsicht an der Bahnsteigkante!", "প্ল্যাটফর্মের কিনারা থেকে সাবধানে থাকুন!", "ফোরজিখ্ট আন ডের বানশ্টাইগকান্টে", [{"t": "Vorsicht", "bn": "সাবধান"}, {"t": "an", "bn": "এ"}, {"t": "der", "bn": "নির্দিষ্ট"}, {"t": "Bahnsteigkante!", "bn": "কিনারা"}]),
                s("Gute Reise und auf Wiedersehen!", "ভ্রমণ শুভ হোক এবং আবার দেখা হবে!", "গুটে রাইজে উন্ট আউফ ভিডারজেহেন", [{"t": "Gute", "bn": "শুভ"}, {"t": "Reise", "bn": "ভ্রমণ"}, {"t": "und", "bn": "এবং"}, {"t": "auf", "bn": "পুনরায়"}, {"t": "Wiedersehen!", "bn": "দেখা"}]),
            ]
        },
        {
            "title_bn": "A1 স্পিকিং টেস্ট: প্রশ্ন ও উত্তরের চূড়ান্ত ড্রিল",
            "title_target": "A1-Prüfungstraining Sprechen",
            "intro_bn": "গেয়েটে ইন্সটিটিউট A1 স্পিকিং পরীক্ষার ৩টি অংশের ড্রিল: নিজের পরিচয়, তথ্য চাওয়া ও অনুরোধ করা।",
            "structure": ["Prüfungsteil", "Aufgabe", "Antwort"],
            "items": [
                s("Können Sie Ihren Namen buchstabieren?", "আপনি কি আপনার নামের বানান করতে পারবেন?", "কোয়ন্নেন যী ইরেন নামেন বুখশ্টাবিরেন", [{"t": "Können", "bn": "পারবেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "Ihren", "bn": "আপনার"}, {"t": "Namen", "bn": "নাম"}, {"t": "buchstabieren?", "bn": "বানান করতে"}]),
                s("Ja, mein Name buchstabiert man H-A-S-A-N.", "হ্যাঁ, আমার নাম এইচ-এ-এস-এ-এন।", "ইয়া মাইন নামে বুখশ্টাবিয়ার্ট মান হা আ এস আ এন", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "mein", "bn": "আমার"}, {"t": "Name", "bn": "নাম"}, {"t": "buchstabiert", "bn": "বানান করে"}, {"t": "man", "bn": "লোকে"}, {"t": "H-A-S-A-N.", "bn": "হাসান"}]),
                s("Können Sie Ihre Telefonnummer sagen?", "আপনার ফোন নম্বরটি কি বলতে পারবেন?", "কোয়ন্নেন যী ইরে টেলিফোননুমার জাগেন", [{"t": "Können", "bn": "পারবেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "Ihre", "bn": "আপনার"}, {"t": "Telefonnummer", "bn": "ফোন নম্বর"}, {"t": "sagen?", "bn": "বলতে"}]),
                s("Meine Nummer ist null eins sieben sechs.", "আমার নম্বর শূন্য এক সাত ছয়।", "মাইনে নুমার ইস্ত নুল আইনস যীবেন জেক্স", [{"t": "Meine", "bn": "আমার"}, {"t": "Nummer", "bn": "নম্বর"}, {"t": "ist", "bn": "হয়"}, {"t": "null", "bn": "শূন্য"}, {"t": "eins", "bn": "এক"}, {"t": "sieben", "bn": "সাত"}, {"t": "sechs.", "bn": "ছয়"}]),
                s("Sprechen Sie bitte etwas lauter!", "দয়া করে আরেকটু উচ্চস্বরে কথা বলুন!", "শ্প্রেখেন যী বিটে এতভাস লাউটার", [{"t": "Sprechen", "bn": "বলুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "bitte", "bn": "দয়া করে"}, {"t": "etwas", "bn": "একটু"}, {"t": "lauter!", "bn": "উচ্চস্বরে"}]),
                s("Darf ich hier ein Foto machen?", "আমি কি এখানে একটি ছবি তুলতে পারি?", "ডার্ফ ইখ্ হিয়ার আইন ফোটো মাখেন", [{"t": "Darf", "bn": "অনুমতি আছে"}, {"t": "ich", "bn": "আমার"}, {"t": "hier", "bn": "এখানে"}, {"t": "ein", "bn": "একটি"}, {"t": "Foto", "bn": "ছবি"}, {"t": "machen?", "bn": "তুলতে"}]),
                s("Ja, das ist hier erlaubt.", "হ্যাঁ, এখানে ছবি তোলার অনুমতি আছে।", "ইয়া ডাস ইস্ত হিয়ার এয়ারলাউপট", [{"t": "Ja,", "bn": "হ্যাঁ"}, {"t": "das", "bn": "তা"}, {"t": "ist", "bn": "হয়"}, {"t": "hier", "bn": "এখানে"}, {"t": "erlaubt.", "bn": "অনুমোদিত"}]),
                s("Sie haben die Prüfung bestanden!", "আপনি পরীক্ষায় পাস করেছেন / উত্তীর্ণ হয়েছেন!", "যী হাবের্ন ডী প্যূফুং বেশ্টান্ডেন", [{"t": "Sie", "bn": "আপনি"}, {"t": "haben", "bn": "আছেন"}, {"t": "die", "bn": "নির্দিষ্ট"}, {"t": "Prüfung", "bn": "পরীক্ষা"}, {"t": "bestanden!", "bn": "পাস করেছেন"}]),
            ]
        },
        {
            "title_bn": "সমাপনী মাস্টারক্লাস সংলাপ ও শুভেচ্ছা",
            "title_target": "Abschluss-Dialog & Glückwunsch",
            "intro_bn": "A1 কোর্স সম্পন্ন করার পর শিক্ষার্থী ও শিক্ষকের অভিনন্দন বিনিময় সংলাপ।",
            "structure": ["Sprecher A", "Sprecher B", "Zertifikat"],
            "items": [
                dl("A", "Herzlichen Glückwunsch, Sie sprechen jetzt Deutsch!", "আন্তরিক অভিনন্দন, আপনি এখন জার্মান বলতে পারেন!", "হেয়ার্ৎসলিখেন গ্ল্যুকভুন্শ যী শ্প্রেখেন ইয়েৎস্ট ডয়চ", [{"t": "Herzlichen", "bn": "আন্তরিক"}, {"t": "Glückwunsch,", "bn": "অভিনন্দন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "sprechen", "bn": "বলছেন"}, {"t": "jetzt", "bn": "এখন"}, {"t": "Deutsch!", "bn": "জার্মান"}]),
                dl("B", "Vielen herzlichen Dank für Ihre Hilfe!", "আপনার সাহায্যের জন্য অসংখ্য আন্তরিক ধন্যবাদ!", "ফিলেন হেয়ার্ৎসলিখেন ডাঙ্ক ফ্যুর ইরে হিলফে", [{"t": "Vielen", "bn": "অনেক"}, {"t": "herzlichen", "bn": "আন্তরিক"}, {"t": "Dank", "bn": "ধন্যবাদ"}, {"t": "für", "bn": "জন্য"}, {"t": "Ihre", "bn": "আপনার"}, {"t": "Hilfe!", "bn": "সাহায্য"}]),
                dl("A", "Wie fühlen Sie sich nach dem Kurs?", "কোর্সটি শেষ করে আপনার কেমন লাগছে?", "ভী ফ্যুলেন যী নিখ্ নাখ ডেম কুর্স", [{"t": "Wie", "bn": "কেমন"}, {"t": "fühlen", "bn": "অনুভব করছেন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "sich", "bn": "নিজেকে"}, {"t": "nach", "bn": "পর"}, {"t": "dem", "bn": "নির্দিষ্ট"}, {"t": "Kurs?", "bn": "কোর্স"}]),
                dl("B", "Ich fühle mich sehr sicher beim Sprechen.", "কথা বলার ক্ষেত্রে আমি এখন খুবই আত্মবিশ্বাসী।", "ইখ্ ফ্যূলে নিখ্ জেয়ার জিশার বাইম শ্প্রেখেন", [{"t": "Ich", "bn": "আমি"}, {"t": "fühle", "bn": "অনুভব করি"}, {"t": "mich", "bn": "নিজেকে"}, {"t": "sehr", "bn": "খুব"}, {"t": "sicher", "bn": "আত্মবিশ্বাসী"}, {"t": "beim", "bn": "এ"}, {"t": "Sprechen.", "bn": "বলা"}]),
                s("Üben Sie jeden Tag mit dieser App weiter!", "প্রতিদিন এই অ্যাপের সাথে আরও অনুশীলন চালিয়ে যান!", "উ্যবেন যী ইয়েডেন তাক মিট ডীজার অ্যাপ ভাইটার", [{"t": "Üben", "bn": "অনুশীলন করুন"}, {"t": "Sie", "bn": "আপনি"}, {"t": "jeden", "bn": "প্রতি"}, {"t": "Tag", "bn": "দিন"}, {"t": "mit", "bn": "দিয়ে"}, {"t": "dieser", "bn": "এই"}, {"t": "App", "bn": "অ্যাপ"}, {"t": "weiter!", "bn": "চালিয়ে"}]),
                s("Deutsch lernen macht wirklich großen Spaß.", "জার্মান ভাষা শেখা আসলেই চমৎকার আনন্দের।", "ডয়চ লের্নেন মাখট ভির্কলিখ গ্রোসেন শ্পাস", [{"t": "Deutsch", "bn": "জার্মান"}, {"t": "lernen", "bn": "শেখা"}, {"t": "macht", "bn": "দেয়"}, {"t": "wirklich", "bn": "সত্যিই"}, {"t": "großen", "bn": "অনেক"}, {"t": "Spaß.", "bn": "আনন্দ"}]),
                s("Alles Gute für Ihre Zukunft in Deutschland!", "জার্মানিতে আপনার ভবিষ্যতের জন্য রইলো শুভকামনা!", "আলেস গুটে ফ্যুর ইরে ৎসুকুনফট ইন ডয়চলান্ট", [{"t": "Alles", "bn": "সব"}, {"t": "Gute", "bn": "ভালো"}, {"t": "für", "bn": "জন্য"}, {"t": "Ihre", "bn": "আপনার"}, {"t": "Zukunft", "bn": "ভবিষ্যত"}, {"t": "in", "bn": "তে"}, {"t": "Deutschland!", "bn": "জার্মানি"}]),
                s("Auf Wiedersehen und danke für alles!", "বিদায় এবং সবকিছুর জন্য ধন্যবাদ!", "আউফ ভিডারজেহেন উন্ট ডাঙ্কে ফ্যুর আলেস", [{"t": "Auf", "bn": "পুনরায়"}, {"t": "Wiedersehen", "bn": "দেখা"}, {"t": "und", "bn": "এবং"}, {"t": "danke", "bn": "ধন্যবাদ"}, {"t": "für", "bn": "জন্য"}, {"t": "alles!", "bn": "সবকিছু"}]),
            ]
        }
    ]
}

def main():
    print(f"Writing {len(units)} A1 Part 2 units to {UNITS_DIR}...")
    for uid, data in units.items():
        path = UNITS_DIR / f"{uid}.json"
        path.write_text(json.dumps(data, ensure_ascii=False, indent=2) + "\n", encoding="utf-8")
        total_items = sum(len(l["items"]) for l in data["lessons"])
        print(f"  {uid}.json: {len(data['lessons'])} lessons, {total_items} items")

if __name__ == "__main__":
    main()
