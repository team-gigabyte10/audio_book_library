import json
import sys

sys.stdout.reconfigure(encoding='utf-8')

DEST_FILE = 'android/app/src/main/assets/spoken_english_past_tense.json'

course_metadata = {
    "id": "en-spoken-past-tense",
    "target_lang": "en",
    "base_lang": "bn",
    "title_bn": "স্পোকেন ইংলিশ: Past Tense (অতীত কাল)",
    "title_target": "Spoken English: Past Tense Masterclass",
    "source": "Curated Spoken English Curriculum",
    "note": "অতীত কালের Be-Verbs (was/were), সাধারণ কাজ (Did/Didn't), অতীত ঘটমান (was/were + ing), মোডাল (used to/had to/could), পুরাঘটিত অতীত (had + V3), প্যাসিভ, টাং টুইস্টার ও ৬ রূপান্তর ড্রিল।",
    "welcome_text": "স্পোকেন ইংলিশ Past Tense মাস্টারক্লাসে আপনাকে স্বাগতম। অতীতের ঘটনা সাবলীলভাবে প্রকাশ করতে বেশি বেশি প্রাক্টিস করুন, ধন্যবাদ।"
}

# ==============================================================================
# Helper to build a standard lesson item
# ==============================================================================
def make_item(item_id, target, bn, pron_bn, sentence_type="assertive", polarity="affirmative", tense="past_simple", category=None, phoneme_focus=None):
    tokens = [{"t": w, "bn": ""} for w in target.split()]
    tags = {
        "sentence_type": sentence_type,
        "polarity": polarity,
        "tense": tense
    }
    if category:
        tags["category"] = category
    if phoneme_focus:
        tags["phoneme_focus"] = phoneme_focus
        tags["drill_type"] = "pronunciation"

    return {
        "id": item_id,
        "concept_id": f"c-{item_id}",
        "order": 1,
        "type": "sentence",
        "level": "A2",
        "target": target,
        "bn": bn,
        "bn_pron": pron_bn,
        "tokens": tokens,
        "ipa": target,
        "status": "reviewed",
        "reviewFlags": "",
        "tags": tags
    }

# ==============================================================================
# MODULE 1: Past State, Identity, Tongue Twisters & 6-Pattern Transformation
# ==============================================================================
m1_l1_items = [
    ("past-m1-l1-001", "I was a junior programmer in that company.", "আমি সেই কোম্পানিতে একজন জুনিয়র প্রোগ্রামার ছিলাম।", "আই ওয়াজ আ জুনিয়র প্রোগ্রামার ইন দ্যাট কোম্পানি।"),
    ("past-m1-l1-002", "He was a dedicated school teacher for twenty years.", "তিনি বিশ বছর ধরে একজন নিবেদিতপ্রাণ শিক্ষক ছিলেন।", "হি ওয়াজ আ ডেডিকেটেড স্কুল টিচার ফর টুয়েন্টি ইয়ার্স।"),
    ("past-m1-l1-003", "She was a brilliant medical student.", "তিনি একজন মেধাবী মেডিকেল শিক্ষার্থী ছিলেন।", "শি ওয়াজ আ ব্রিলিয়ান্ট মেডিকেল স্টুডেন্ট।"),
    ("past-m1-l1-004", "They were great business partners in the past.", "অতীতে তারা দারুণ ব্যবসায়িক অংশীদার ছিল।", "দে ওয়্যার গ্রেট বিজনেস পার্টনার্স ইন দ্য পাস্ট।"),
    ("past-m1-l1-005", "We were close neighbors in Sylhet city.", "আমরা সিলেট শহরে ঘনিষ্ঠ প্রতিবেশী ছিলাম।", "উই ওয়্যার ক্লোজ নেইবার্স ইন সিলেট সিটি।"),
    ("past-m1-l1-006", "My father was a government service holder.", "আমার বাবা একজন সরকারি চাকরিজীবী ছিলেন।", "মাই ফাদার ওয়াজ আ গভর্নমেন্ট সার্ভিস হোল্ডার।")
]

m1_l2_items = [
    ("past-m1-l2-001", "I was very tired after the long journey.", "দীর্ঘ ভ্রমণের পর আমি খুব ক্লান্ত ছিলাম।", "আই ওয়াজ ভেরি টায়ার্ড আফটার দ্য লং জার্নি।"),
    ("past-m1-l2-002", "She was extremely happy with her examination results.", "পরীক্ষার ফলাফলে সে অত্যন্ত খুশি ছিল।", "শি ওয়াজ এক্সট্রিমলি হ্যাপি উইথ হার এক্সামিনেশন রেজাল্টস।"),
    ("past-m1-l2-003", "He was sick last week and stayed in bed.", "সে গত সপ্তাহে অসুস্থ ছিল এবং বিছানায় ছিল।", "হি ওয়াজ সিক লাস্ট উইক অ্যান্ড સ્ટેইড ইন বেড।"),
    ("past-m1-l2-004", "They were very proud of our teamwork.", "তারা আমাদের দলগত কাজে অত্যন্ত গর্বিত ছিল।", "দে ওয়্যার ভেরি প্রাউড অব আওয়ার টিমওয়ার্ক।"),
    ("past-m1-l2-005", "The weather was pleasantly cool yesterday evening.", "গতকাল সন্ধ্যায় আবহাওয়া মনোরম ঠান্ডা ছিল।", "দ্য ওয়েদার ওয়াজ প্লেজেন্টলি কুল ইয়েস্টারডে ইভনিং।"),
    ("past-m1-l2-006", "Were you nervous during the interview? Yes, I was quite nervous.", "সাক্ষাৎকারের সময় আপনি কি নার্ভাস ছিলেন? হ্যাঁ, আমি বেশ নার্ভাস ছিলাম।", "ওয়্যার ইউ নার্ভাস ডিউরিং দি ইন্টারভিউ? ইয়েস, আই ওয়াজ কোয়াইট নার্ভাস।")
]

m1_l3_twisters = [
    ("past-m1-twister-001", "Betty Botter bought some butter, but the butter was bitter.", "বেটি বটার কিছু মাখন কিনেছিল, কিন্তু মাখনটি ছিল তিতকুটে।", "বেটি বটার বট সাম বাটার, বাট দ্য বাটার ওয়াজ বিটার।", "/b/ & /t/ plosives"),
    ("past-m1-twister-002", "I thought a thought, but the thought I thought wasn't the thought I thought I thought.", "আমি একটি ভাবনা ভেবেছিলাম, কিন্তু যে ভাবনাটি ভেবেছিলাম তা সেই ভাবনা ছিল না যা ভেবেছিলাম।", "আই থট আ থট, বাট দ্য থট আই থট ওয়াজন্ট দ্য থট আই থট আই থট।", "/th/ dental fricative"),
    ("past-m1-twister-003", "Six slippery snails slid slowly seaward yesterday.", "ছয়টি পিচ্ছিল শামুক গতকাল ধীরে ধীরে সমুদ্রের দিকে পিছলে গেল।", "সিক্স স্লিপারি স্নেইলস স্লিড স্লোলি সিওয়ার্ড ইয়েস্টারডে।", "/s/ and /sl/ past blends"),
    ("past-m1-twister-004", "A loyal warrior fought fiercely for his fallen king.", "একজন বিশ্বস্ত যোদ্ধা তার প্রয়াত রাজার জন্য বীরত্বের সাথে যুদ্ধ করেছিল।", "আ লয়াল ওয়ারিয়র ফট ফিয়ার্সলি ফর হিজ ফলেন কিং।", "/f/ and past fought"),
    ("past-m1-twister-005", "Whether the weather was warm or whether the weather was cold.", "আবহাওয়া উষ্ণ ছিল নাকি আবহাওয়া ঠান্ডা ছিল।", "ওয়েদার দ্য ওয়েদার ওয়াজ ওয়ার্ম অর ওয়েদার দ্য ওয়েদার ওয়াজ কোল্ড।", "/w/ and was/were")
]

m1_l4_trans = [
    ("past-m1-trans-001", "I was a leader.", "আমি একজন নেতা ছিলাম।", "আই ওয়াজ আ লিডার।", "assertive", "affirmative"),
    ("past-m1-trans-002", "I was not a leader.", "আমি একজন নেতা ছিলাম না।", "আই ওয়াজ নট আ লিডার।", "assertive", "negative"),
    ("past-m1-trans-003", "Was I a leader?", "আমি কি একজন নেতা ছিলাম?", "ওয়াজ আই আ লিডার?", "interrogative", "affirmative"),
    ("past-m1-trans-004", "Wasn't I a leader?", "আমি কি একজন নেতা ছিলাম না?", "ওয়াজন্ট আই আ লিডার?", "interrogative", "negative"),
    ("past-m1-trans-005", "Why was I a leader?", "আমি কেন একজন নেতা ছিলাম?", "হোয়াই ওয়াজ আই আ লিডার?", "wh_question", "affirmative"),
    ("past-m1-trans-006", "Why wasn't I a leader?", "আমি কেন একজন নেতা ছিলাম না?", "হোয়াই ওয়াজন্ট আই আ লিডার?", "wh_question", "negative"),

    ("past-m1-trans-007", "He was a doctor.", "তিনি একজন ডাক্তার ছিলেন।", "হি ওয়াজ আ ডক্টর।", "assertive", "affirmative"),
    ("past-m1-trans-008", "He was not a doctor.", "তিনি একজন ডাক্তার ছিলেন না।", "হি ওয়াজ নট আ ডক্টর।", "assertive", "negative"),
    ("past-m1-trans-009", "Was he a doctor?", "তিনি কি একজন ডাক্তার ছিলেন?", "ওয়াজ হি আ ডক্টর?", "interrogative", "affirmative"),
    ("past-m1-trans-010", "Wasn't he a doctor?", "তিনি কি একজন ডাক্তার ছিলেন না?", "ওয়াজন্ট হি আ ডক্টর?", "interrogative", "negative"),
    ("past-m1-trans-011", "Where was he a doctor?", "তিনি কোথায় ডাক্তার ছিলেন?", "হোয়ার ওয়াজ হি আ ডক্টর?", "wh_question", "affirmative"),
    ("past-m1-trans-012", "Why wasn't he a doctor?", "তিনি কেন ডাক্তার ছিলেন না?", "হোয়াই ওয়াজন্ট হি আ ডক্টর?", "wh_question", "negative")
]

# Build Part 1
p1_lessons = [
    {
        "id": "past-p1-l01",
        "order": 1,
        "title_bn": "পেশা ও পরিচয় — 'Was / Were' (Past Identity)",
        "title_target": "Past Identity & Professions (Was / Were)",
        "intro_bn": "অতীতে কারো পেশা বা পরিচয় কী ছিল তা প্রকাশ করতে 'was / were' ব্যবহৃত হয়। (I/He/She/It এর সাথে was এবং We/You/They এর সাথে were)।",
        "structure": ["Subject + was / were + a/an + Profession / Identity"],
        "items": [make_item(i[0], i[1], i[2], i[3]) for i in m1_l1_items]
    },
    {
        "id": "past-p1-l02",
        "order": 2,
        "title_bn": "ব্যক্তিত্ব ও অনুভূতি (Past Feelings & States)",
        "title_target": "Past Feelings & States (Was / Were + Adjective)",
        "intro_bn": "অতীতে কারো মানসিক অবস্থা, অনুভূতি বা গুণ কেমন ছিল তা প্রকাশ করতে 'was / were + Adjective' বসে।",
        "structure": ["Subject + was / were + Adjective"],
        "items": [make_item(i[0], i[1], i[2], i[3]) for i in m1_l2_items]
    },
    {
        "id": "past-p1-l03",
        "order": 3,
        "badge": "Very Important for Spoken English",
        "badge_bn": "স্পোকেন ইংলিশের জন্য অতি গুরুত্বপূর্ণ",
        "title_bn": "উচ্চারণ ও জড়তা দূরীকরণে ৫টি অতীত টাং টুইস্টার",
        "title_target": "5 Past Tongue Twisters for Pronunciation",
        "intro_bn": "অতীত কালের অনর্গল উচ্চারণের জন্য এই ৫টি টাং টুইস্টার প্রথমে ধীরে, তারপর স্বাভাবিক গতিতে এবং সবশেষে দ্রুত ৩ বার অনুশীলন করুন।",
        "structure": ["Read Slowly for Clear Pronunciation", "Repeat at Natural Pace", "Speed Up 3 Times Without Pausing"],
        "items": [make_item(i[0], i[1], i[2], i[3], category="tongue_twister", phoneme_focus=i[4]) for i in m1_l3_twisters]
    },
    {
        "id": "past-p1-l04",
        "order": 4,
        "badge": "Very Important for Spoken English",
        "badge_bn": "স্পোকেন ইংলিশের জন্য অতি গুরুত্বপূর্ণ",
        "title_bn": "বাক্যের ৬ রূপ: পরিচয় ও অবস্থা (অতি গুরুত্বপূর্ণ)",
        "title_target": "6 Sentence Forms: Past Identity (Very Important)",
        "intro_bn": "যেকোনো অতীত বাক্যকে অনর্গল রূপান্তর করতে ৬টি ধরনে (Affirmative, Negative, Interrogative, Interro-Neg, WH, WH-Neg) দ্রুত মুখে অনুশীলন করুন।",
        "structure": [
            "1. Affirmative: S + was/were + Noun",
            "2. Negative: S + was/were + not + Noun",
            "3. Interrogative: Was/Were + S + Noun?",
            "4. Interro-Neg: Wasn't/Weren't + S + Noun?",
            "5. WH-Question: Why + was/were + S + Noun?",
            "6. WH-Negative: Why + wasn't/weren't + S + Noun?"
        ],
        "items": [make_item(i[0], i[1], i[2], i[3], sentence_type=i[4], polarity=i[5]) for i in m1_l4_trans]
    }
]

part1 = {
    "id": "past-foundations-p1",
    "order": 1,
    "level": "A1",
    "title_bn": "অতীতের অবস্থা, পরিচয় ও উচ্চারণ ড্রিল (Past State & Identity)",
    "title_target": "Past State, Identity & Tongue Twisters",
    "lessons": p1_lessons
}

# ==============================================================================
# MODULE 2: Past Location & 6-Type Transformation
# ==============================================================================
m2_l5_items = [
    ("past-m2-l5-001", "I was at the office yesterday morning.", "আমি গতকাল সকালে অফিসে ছিলাম।", "আই ওয়াজ অ্যাট দি অফিস ইয়েস্টারডে মর্নিং।"),
    ("past-m2-l5-002", "She was in the hospital last Sunday.", "গত রবিবারে সে হাসপাতালে ছিল।", "শি ওয়াজ ইন দ্য হসপিটাল লাস্ট সানডে।"),
    ("past-m2-l5-003", "They were at the international airport on time.", "তারা সময়মতো আন্তর্জাতিক বিমানবন্দরে ছিল।", "দে ওয়্যার অ্যাট দি ইন্টারন্যাশনাল এয়ারপোর্ট অন টাইম।"),
    ("past-m2-l5-004", "The documents were on the manager's desk.", "কাগজপত্রগুলো ম্যানেজারের ডেস্কে ছিল।", "দ্য ডকুমেন্টস ওয়্যার অন দ্য ম্যানেজার্স ডেস্ক।"),
    ("past-m2-l5-005", "We were in Cox's Bazar during the winter vacation.", "শীতকালীন ছুটিতে আমরা কক্সবাজারে ছিলাম।", "উই ওয়্যার ইন কক্সবাজার ডিউরিং দ্য উইন্টার ভ্যাকেশন।"),
    ("past-m2-l5-006", "He was at home when the rain started.", "বৃষ্টি শুরু হওয়ার সময় সে বাড়িতে ছিল।", "হি ওয়াজ অ্যাট হোম হোয়েন দ্য রেইন স্টার্টেড।")
]

m2_l6_trans = [
    ("past-m2-trans-001", "She was at work.", "সে কাজে ছিল।", "শি ওয়াজ অ্যাট ওয়ার্ক।", "assertive", "affirmative"),
    ("past-m2-trans-002", "She was not at work.", "সে কাজে ছিল না।", "শি ওয়াজ নট অ্যাট ওয়ার্ক।", "assertive", "negative"),
    ("past-m2-trans-003", "Was she at work?", "সে কি কাজে ছিল?", "ওয়াজ শি অ্যাট ওয়ার্ক?", "interrogative", "affirmative"),
    ("past-m2-trans-004", "Wasn't she at work?", "সে কি কাজে ছিল না?", "ওয়াজন্ট শি অ্যাট ওয়ার্ক?", "interrogative", "negative"),
    ("past-m2-trans-005", "Where was she yesterday?", "সে গতকাল কোথায় ছিল?", "হোয়ার ওয়াজ শি ইয়েস্টারডে?", "wh_question", "affirmative"),
    ("past-m2-trans-006", "Why wasn't she at work?", "সে কাজে ছিল না কেন?", "হোয়াই ওয়াজন্ট শি অ্যাট ওয়ার্ক?", "wh_question", "negative")
]

part2 = {
    "id": "past-foundations-p2",
    "order": 2,
    "level": "A1",
    "title_bn": "অতীতের অবস্থান ও স্থানসূচক ৬ রূপান্তর (Past Location & Prepositions)",
    "title_target": "Past Location & 6-Type Preposition Transformations",
    "lessons": [
        {
            "id": "past-p2-l05",
            "order": 1,
            "title_bn": "অতীতের অবস্থান ও প্রিপজিশন (Past Location & Prepositions)",
            "title_target": "Past Location (was/were at, in, on)",
            "intro_bn": "অতীতে কেউ কোথায় বা কোন অবস্থানে ছিল তা প্রকাশ করতে 'was / were + Preposition + Place' বসে।",
            "structure": ["Subject + was / were + at / in / on + Place"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in m2_l5_items]
        },
        {
            "id": "past-p2-l06",
            "order": 2,
            "badge": "Very Important for Spoken English",
            "badge_bn": "স্পোকেন ইংলিশের জন্য অতি গুরুত্বপূর্ণ",
            "title_bn": "স্থানসূচক বাক্যের ৬ রূপান্তর ড্রিল (Location 6-Pattern)",
            "title_target": "6-Type Location Transformations Drill",
            "intro_bn": "অতীতের স্থান ও অবস্থান বোঝাতে একটি বাক্যকে ৬টি ধরনে রূপান্তরের স্পোকেন ড্রিল।",
            "structure": [
                "1. S + was/were + Prep + Place",
                "2. S + wasn't/weren't + Prep + Place",
                "3. Was/Were + S + Prep + Place?",
                "4. Wasn't/Weren't + S + Prep + Place?",
                "5. Where + was/were + S?",
                "6. Why wasn't/weren't + S + Prep + Place?"
            ],
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type=i[4], polarity=i[5]) for i in m2_l6_trans]
        }
    ]
}

# ==============================================================================
# MODULE 3: Past Possession (Had) & 6-Type Transformation
# ==============================================================================
m3_l7_items = [
    ("past-m3-l7-001", "I had a blue bicycle in my school days.", "স্কুলজীবনে আমার একটি নীল সাইকেল ছিল।", "আই হ্যাড আ ব্লু বাইসাইকেল ইন মাই স্কুল ডেইজ।"),
    ("past-m3-l7-002", "He had a lot of valuable experience in teaching.", "শিক্ষকতায় তার প্রচুর মূল্যবান অভিজ্ঞতা ছিল।", "হি হ্যাড আ লট অব ভ্যালুয়েবল এক্সপেরিয়েন্স ইন টিচিং।"),
    ("past-m3-l7-003", "We had enough time to prepare for the presentation.", "উপস্থাপনার প্রস্তুতির জন্য আমাদের পর্যাপ্ত সময় ছিল।", "উই হ্যাড এনাফ টাইম টু প্রিপেয়ার ফর দ্য প্রেজেন্টেশন।"),
    ("past-m3-l7-004", "She had a severe headache yesterday afternoon.", "গতকাল বিকেলে তার তীব্র মাথা ব্যথা ছিল।", "শি হ্যাড আ সিভিয়ার হেডেক ইয়েস্টারডে আফটারনুন।"),
    ("past-m3-l7-005", "They had a beautiful garden beside their village house.", "তাদের গ্রামের বাড়ির পাশে একটি সুন্দর বাগান ছিল।", "দে হ্যাড আ বিউটিফুল গার্ডেন বিসাইড দেয়ার ভিলেজ হাউজ।"),
    ("past-m3-l7-006", "Did you have any problems yesterday? No, I had no problem.", "গতকাল আপনার কি কোনো সমস্যা ছিল? না, আমার কোনো সমস্যা ছিল না।", "ডিড ইউ হ্যাভ অ্যানি প্রবলেমস ইয়েস্টারডে? নো, আই হ্যাড নো প্রবলেম।")
]

m3_l8_trans = [
    ("past-m3-trans-001", "I had a car.", "আমার একটি গাড়ি ছিল।", "আই হ্যাড আ কার।", "assertive", "affirmative"),
    ("past-m3-trans-002", "I didn't have a car.", "আমার কোনো গাড়ি ছিল না।", "আই ডিডন্ট হ্যাভ আ কার।", "assertive", "negative"),
    ("past-m3-trans-003", "Did you have a car?", "আপনার কি একটি গাড়ি ছিল?", "ডিড ইউ হ্যাভ আ কার?", "interrogative", "affirmative"),
    ("past-m3-trans-004", "Didn't you have a car?", "আপনার কি গাড়ি ছিল না?", "ডিডন্ট ইউ হ্যাভ আ কার?", "interrogative", "negative"),
    ("past-m3-trans-005", "What did you have?", "আপনার কী ছিল?", "হোয়াট ডিড ইউ হ্যাভ?", "wh_question", "affirmative"),
    ("past-m3-trans-006", "Why didn't you have a car?", "আপনার গাড়ি ছিল না কেন?", "হোয়াই ডিডন্ট ইউ হ্যাভ আ কার?", "wh_question", "negative")
]

part3 = {
    "id": "past-foundations-p3",
    "order": 3,
    "level": "A1",
    "title_bn": "অতীতের অধিকার ও মালিকানার ৬ রূপান্তর (Past Possession: Had)",
    "title_target": "Past Possession & 6-Type Had Transformations",
    "lessons": [
        {
            "id": "past-p3-l07",
            "order": 1,
            "title_bn": "অতীতের অধিকার ও মালিকানা — 'Had' (Past Possession)",
            "title_target": "Past Possession & Ownership (Had)",
            "intro_bn": "অতীতে নিজের বা অন্যের কোনো জিনিস থাকা বা অধিকার প্রকাশ করতে 'had' ব্যবহার করা হয়।",
            "structure": ["Subject + had + Object / Noun"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in m3_l7_items]
        },
        {
            "id": "past-p3-l08",
            "order": 2,
            "badge": "Very Important for Spoken English",
            "badge_bn": "স্পোকেন ইংলিশের জন্য অতি গুরুত্বপূর্ণ",
            "title_bn": "মালিকানা প্রকাশের ৬ রূপান্তর ড্রিল (Possession 6-Pattern with Did)",
            "title_target": "6-Type Possession Transformations (Had & Did)",
            "intro_bn": "মালিকানা বা কোনো কিছু থাকার ৬টি রূপের রূপান্তর স্পোকেন ড্রিল: Affirmative, Negative, Interrogative, Intro-Negative, WH-Question ও WH-Negative।",
            "structure": [
                "1. S + had + Object",
                "2. S + didn't have + Object",
                "3. Did + S + have + Object?",
                "4. Didn't + S + have + Object?",
                "5. What did + S + have?",
                "6. Why didn't + S + have + Object?"
            ],
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type=i[4], polarity=i[5]) for i in m3_l8_trans]
        }
    ]
}

# ==============================================================================
# MODULE 4: Past Simple, '-ed' Pronunciation, 6-Pattern & WH-Drill
# ==============================================================================
m4_l9_ed_rules = [
    ("past-m4-ed-001", "I walked five kilometers yesterday.", "আমি গতকাল পাঁচ কিলোমিটার হেঁটেছিলাম। (উচ্চারণ: ওয়াক্ট - /t/ ধ্বনি)", "আই ওয়াক্ট ফাইভ কিলোমিটার্স ইয়েস্টারডে।", "pronunciation_rule", "/t/ sound: -ed after voiceless p, k, s, sh, ch"),
    ("past-m4-ed-002", "She watched the entire documentary.", "সে পুরো ডকুমেন্টারিটি দেখেছিল। (উচ্চারণ: ওয়াচ্ট - /t/ ধ্বনি)", "শি ওয়াচ্ট দি এনটায়ার ডকুমেন্টারি।", "pronunciation_rule", "/t/ sound"),
    ("past-m4-ed-003", "We played cricket all afternoon.", "আমরা পুরো বিকেল ক্রিকেট খেলেছিলাম। (উচ্চারণ: প্লেয়্ড - /d/ ধ্বনি)", "উই প্লেয়্ড ক্রিকেট অল আফটারনুন।", "pronunciation_rule", "/d/ sound: -ed after voiced sounds"),
    ("past-m4-ed-004", "He lived in London for two years.", "তিনি লন্ডনে দুই বছর বসবাস করেছিলেন। (উচ্চারণ: লিভ্ড - /d/ ধ্বনি)", "হি লিভ্ড ইন লন্ডন ফর টু ইয়ার্স।", "pronunciation_rule", "/d/ sound"),
    ("past-m4-ed-005", "I wanted to learn fluent English.", "আমি সাবলীল ইংরেজি শিখতে চেয়েছিলাম। (উচ্চারণ: ওয়ান্টেড - /ɪd/ ধ্বনি)", "আই ওয়ান্টেড টু লার্ন ফ্লুয়েন্ট ইংলিশ।", "pronunciation_rule", "/ɪd/ sound: -ed after t or d"),
    ("past-m4-ed-006", "They needed immediate medical assistance.", "তাদের অবিলম্বে চিকিৎসা সহায়তার প্রয়োজন ছিল। (উচ্চারণ: নিডেড - /ɪd/ ধ্বনি)", "দে নিডেড ইমিডিয়েট মেডিকেল অ্যাসিস্ট্যান্স।", "pronunciation_rule", "/ɪd/ sound")
]

m4_l10_actions = [
    ("past-m4-l10-001", "She went shopping with her sister last Saturday.", "তিনি গত শনিবার তার বোনের সাথে কেনাকাটা করতে গিয়েছিলেন।", "শি ওয়েন্ট শপিং উইথ হার সিস্টার লাস্ট স্যাটারডে।"),
    ("past-m4-l10-002", "We got up early yesterday and went for a long walk.", "আমরা গতকাল খুব ভোরে ঘুম থেকে উঠে দীর্ঘ ভ্রমণে গিয়েছিলাম।", "উই গট আপ আর্লি ইয়েস্টারডে অ্যান্ড ওয়েন্ট ফর আ লং ওয়াক।"),
    ("past-m4-l10-003", "I met my old school friend at the railway station.", "রেলওয়ে স্টেশনে আমার পুরানো স্কুল বন্ধুর সাথে দেখা হয়েছিল।", "আই মেট মাই ওল্ড স্কুল ফ্রেন্ড অ্যাট দ্য রেলওয়ে স্টেশন।"),
    ("past-m4-l10-004", "He bought a brand new smartphone two days ago.", "সে দুই দিন আগে একটি একদম নতুন স্মার্টফোন কিনেছিল।", "হি বট আ ব্র্যান্ড নিউ স্মার্টফোন টু ডেইজ এগো।"),
    ("past-m4-l10-005", "She cooked delicious biryani for all the guests.", "তিনি সকল অতিথিদের জন্য সুস্বাদু বিরিয়ানি রান্না করেছিলেন।", "শি কুক্ট ডেলিশাস বিরিয়ানি ফর অল দ্য গেস্টস।"),
    ("past-m4-l10-006", "They arrived at the international airport on time.", "তারা সময়মতো আন্তর্জাতিক বিমানবন্দরে পৌঁছেছিল।", "দে অ্যারাইভড অ্যাট দি ইন্টারন্যাশনাল এয়ারপোর্ট অন টাইম।")
]

m4_l11_negatives = [
    ("past-m4-l11-001", "I didn't receive your phone call yesterday.", "আমি গতকাল আপনার ফোন কল পাইনি।", "আই ডিডন্ট রিসিভ ইয়োর ফোন কল ইয়েস্টারডে।"),
    ("past-m4-l11-002", "She didn't go shopping with her friends last month.", "তিনি গত মাসে বন্ধুদের সাথে কেনাকাটা করতে যাননি।", "শি ডিডন্ট গো শপিং উইথ হার ফ্রেন্ডস লাস্ট মান্থ।"),
    ("past-m4-l11-003", "We didn't get up late yesterday morning.", "আমরা গতকাল সকালে দেরিতে উঠিনি।", "উই ডিডন্ট গেট আপ লেইট ইয়েস্টারডে মর্নিং।"),
    ("past-m4-l11-004", "He didn't tell me about the schedule change.", "তিনি সময়সূচি পরিবর্তনের ব্যাপারে আমাকে কিছু জানাননি।", "হি ডিডন্ট টেল মি অ্যাবাউট দ্য শিডিউল চেইঞ্জ।"),
    ("past-m4-l11-005", "They didn't attend the annual general meeting.", "তারা বার্ষিক সাধারণ সভায় উপস্থিত হননি।", "দে ডিডন্ট অ্যাটেন্ড দি অ্যানুয়াল জেনারেল মিটিং।"),
    ("past-m4-l11-006", "We didn't face any trouble on our way back home.", "বাড়ি ফেরার পথে আমরা কোনো সমস্যায় পড়িনি।", "উই ডিডন্ট ফেইস অ্যানি ট্রাবল অন আওয়ার ওয়ে ব্যাক হোম।")
]

m4_l12_trans = [
    ("past-m4-trans-001", "She cooked dinner.", "সে রাতের খাবার রান্না করেছিল।", "শি কুক্ট ডিনার।", "assertive", "affirmative"),
    ("past-m4-trans-002", "She didn't cook dinner.", "সে রাতের খাবার রান্না করেনি।", "শি ডিডন্ট কুক ডিনার।", "assertive", "negative"),
    ("past-m4-trans-003", "Did she cook dinner?", "সে কি রাতের খাবার রান্না করেছিল?", "ডিড শি কুক ডিনার?", "interrogative", "affirmative"),
    ("past-m4-trans-004", "Didn't she cook dinner?", "সে কি রাতের খাবার রান্না করেনি?", "ডিডন্ট শি কুক ডিনার?", "interrogative", "negative"),
    ("past-m4-trans-005", "Why did she cook dinner?", "সে কেন রাতের খাবার রান্না করেছিল?", "হোয়াই ডিড শি কুক ডিনার?", "wh_question", "affirmative"),
    ("past-m4-trans-006", "Why didn't she cook dinner?", "সে কেন রাতের খাবার রান্না করেনি?", "হোয়াই ডিডন্ট শি কুক ডিনার?", "wh_question", "negative")
]

m4_l13_wh_drills = [
    ("past-m4-wh-001", "Where did you go yesterday evening? I went to the shopping mall.", "আপনি গতকাল সন্ধ্যায় কোথায় গিয়েছিলেন? আমি শপিং মলে গিয়েছিলাম।", "হোয়ার ডিড ইউ গো ইয়েস্টারডে ইভনিং? আই ওয়েন্ট টু দ্য শপিং মল।"),
    ("past-m4-wh-002", "What did you buy at the supermarket? I bought fresh fruits and vegetables.", "আপনি সুপারমার্কেটে কী কিনেছিলেন? আমি তাজা ফল ও শাকসবজি কিনেছিলাম।", "হোয়াট ডিড ইউ বাই অ্যাট দ্য সুপারমার্কেট? আই বট ফ্রেশ ফ্রুটস অ্যান্ড ভেজিটেবলস।"),
    ("past-m4-wh-003", "When did they arrive at the venue? They arrived at six in the evening.", "তারা কখন অনুষ্ঠানস্থলে পৌঁছেছিলেন? তারা সন্ধ্যা ছয়টায় পৌঁছেছিলেন।", "হোয়েন ডিড দে অ্যারাইভ অ্যাট দ্য ভেনিউ? দে অ্যারাইভড অ্যাট সিক্স ইন দি ইভনিং।"),
    ("past-m4-wh-004", "Why did you miss the morning bus? Because I got up a little late.", "আপনি সকালের বাস মিস করেছিলেন কেন? কারণ আমি একটু দেরিতে ঘুম থেকে উঠেছিলাম।", "হোয়াই ডিড ইউ মিস দ্য মর্নিং বাস? বিকজ আই গট আপ আ লিটল লেইট।"),
    ("past-m4-wh-005", "How did you learn to speak English so well? I practiced speaking every single day.", "আপনি এত সুন্দর ইংরেজি বলা কীভাবে শিখলেন? আমি প্রতিদিন কথা বলার অনুশীলন করেছি।", "হাউ ডিড ইউ লার্ন টু স্পিক ইংলিশ সো ওয়েল? আই প্র্যাকটিসড স্পিকিং এভরি সিঙ্গেল ডে।"),
    ("past-m4-wh-006", "Who did you meet at the office conference? I met our new marketing director.", "অফিসের সম্মেলনে আপনি কার সাথে দেখা করেছিলেন? আমি আমাদের নতুন পরিচালকের সাথে দেখা করেছিলাম।", "হু ডিড ইউ মিট অ্যাট দি অফিস কনফারেন্স? আই মেট আওয়ার নিউ ডিরেক্টর।"),
    ("past-m4-wh-007", "How much did this leather jacket cost? It cost three thousand taka.", "এই চামড়ার জ্যাকেটের দাম কত ছিল? এর দাম ছিল তিন হাজার টাকা।", "হাউ মাচ ডিড দিজ লেদার জ্যাকেট কস্ট? ইট কস্ট থ্রি থাউজেন্ড টাকা।"),
    ("past-m4-wh-008", "What time did you go to bed last night? I went to bed around midnight.", "গত রাতে আপনি কয়টায় ঘুমাতে গিয়েছিলেন? আমি প্রায় মধ্যরাতে ঘুমাতে গিয়েছিলাম।", "হোয়াট টাইম ডিড ইউ গো টু বেড লাস্ট নাইট? আই ওয়েন্ট টু বেড অ্যারাউন্ড মিডনাইট।")
]

part4 = {
    "id": "past-foundations-p4",
    "order": 4,
    "level": "A2",
    "title_bn": "সাধারণ অতীত কাল ও '-ed' উচ্চারণ মাস্টারক্লাস (Past Simple & Pronunciation)",
    "title_target": "Past Simple Actions, '-ed' Rules & WH-Questions",
    "lessons": [
        {
            "id": "past-p4-l09",
            "order": 1,
            "badge": "Secret Pronunciation Rule",
            "badge_bn": "উচ্চারণের জাদুকরী নিয়ম",
            "title_bn": "স্পোকেন সিক্রেট: '-ed' উচ্চারণের ৩টি নিয়ম (/t/, /d/, /ɪd/)",
            "title_target": "3 Rules of '-ed' Pronunciation in Past Tense",
            "intro_bn": "Past Tense-এ সবচেয়ে বেশি ভুল হয় '-ed' উচ্চারণে। ১) p, k, s, sh, ch এর পর '-ed' উচ্চারিত হয় /t/ (walked -> ওয়াক্ট); ২) ভয়েসড ধ্বনির পর /d/ (played -> প্লেয়্ড); ৩) t ও d এর পর /ɪd/ (wanted -> ওয়ান্টেড)।",
            "structure": ["Verb + -ed -> /t/ or /d/ or /ɪd/"],
            "items": [make_item(i[0], i[1], i[2], i[3], category=i[4], phoneme_focus=i[5]) for i in m4_l9_ed_rules]
        },
        {
            "id": "past-p4-l10",
            "order": 2,
            "title_bn": "অতীতের সমাপ্ত কাজ — 'Subject + V2' (Affirmative Past Simple)",
            "title_target": "Completed Past Actions (Subject + V2)",
            "intro_bn": "অতীতের কোনো নির্দিষ্ট সময়ে শেষ হওয়া কাজ বোঝাতে মূল Verb-এর Past form (V2) ব্যবহৃত হয়।",
            "structure": ["Subject + V2 (went, bought, cooked, arrived) + Time Expression"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in m4_l10_actions]
        },
        {
            "id": "past-p4-l11",
            "order": 3,
            "title_bn": "অতীতের না-বোধক বাক্য — 'Didn't + V1' (Negative Past Simple)",
            "title_target": "Negative Past Simple (Didn't + V1)",
            "intro_bn": "অতীতে কোনো কাজ করা হয়নি বোঝাতে 'did not' বা 'didn't' এবং এরপরে মূল Verb-এর Base form (V1) বসে। কখনোই didn't-এর পর V2 বসবে না!",
            "structure": ["Subject + didn't + Verb (Base form V1)"],
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type="assertive", polarity="negative") for i in m4_l11_negatives]
        },
        {
            "id": "past-p4-l12",
            "order": 4,
            "badge": "Very Important for Spoken English",
            "badge_bn": "স্পোকেন ইংলিশের জন্য অতি গুরুত্বপূর্ণ",
            "title_bn": "সাধারণ কাজের ৬ রূপান্তর ড্রিল (Action 6-Pattern Transformation)",
            "title_target": "6-Type Action Transformations Drill (Past Simple)",
            "intro_bn": "অতীতের কাজের ৬টি রূপান্তর দ্রুত মুখে উচ্চারণ করার অভ্যাস করুন: Affirmative, Negative, Interrogative, Intro-Negative, WH-Question ও WH-Negative।",
            "structure": [
                "1. S + V2 (She cooked)",
                "2. S + didn't + V1 (She didn't cook)",
                "3. Did + S + V1? (Did she cook?)",
                "4. Didn't + S + V1? (Didn't she cook?)",
                "5. Why did + S + V1? (Why did she cook?)",
                "6. Why didn't + S + V1? (Why didn't she cook?)"
            ],
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type=i[4], polarity=i[5]) for i in m4_l12_trans]
        },
        {
            "id": "past-p4-l13",
            "order": 5,
            "title_bn": "ডব্লিউএইচ অতীত প্রশ্নমালা ড্রিল (Past WH-Questions Drill)",
            "title_target": "Wh- Questions in the Past (Where, When, Why, How)",
            "intro_bn": "অতীতে কী, কখন, কোথায়, কেন, কীভাবে ঘটেছিল তা জানতে Wh-words (What, When, Where, Why, How) এর সাথে 'did + Subject + V1' ব্যবহার করা হয়।",
            "structure": ["Wh-word + did + Subject + Verb (V1)...? -> Subject + V2..."],
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type="wh_question") for i in m4_l13_wh_drills]
        }
    ]
}

# ==============================================================================
# MODULE 5: Past Continuous & Interrupted Actions (When / While)
# ==============================================================================
m5_l14_items = [
    ("past-m5-l14-001", "She was cooking delicious dinner in the kitchen.", "সে রান্নাঘরে সুস্বাদু রাতের খাবার রান্না করছিল।", "শি ওয়াজ কুকিং ডেলিশাস ডিনার ইন দ্য কিচেন।"),
    ("past-m5-l14-002", "I was reading an interesting storybook at eight pm.", "রাত আটটায় আমি একটি মজার গল্পের বই পড়ছিলাম।", "আই ওয়াজ রিডিং অ্যান ইন্টারেস্টিং স্টোরিবুক অ্যাট এইট পিএম।"),
    ("past-m5-l14-003", "They were playing cricket in the open field all afternoon.", "তারা পুরো বিকেল জুড়ে উন্মুক্ত মাঠে ক্রিকেট খেলছিল।", "দে ওয়্যার প্লেয়িং ক্রিকেট ইন দি ওপেন ফিল্ড অল আফটারনুন।"),
    ("past-m5-l14-004", "He was preparing his final presentation slides last night.", "সে গত রাতে তার চূড়ান্ত প্রেজেন্টেশন স্লাইড তৈরি করছিল।", "হি ওয়াজ প্রিপেয়ারিং হিজ ফাইনাল প্রেজেন্টেশন স্লাইডস লাস্ট নাইট।"),
    ("past-m5-l14-005", "It was raining heavily when we stepped outside.", "আমরা যখন বাইরে পা রেখেছিলাম তখন মুষলধারে বৃষ্টি হচ্ছিল।", "ইট ওয়াজ রেইনিং হেভিলি হোয়েন উই স্টেপড আউটসাইড।"),
    ("past-m5-l14-006", "We were having lunch together at the restaurant.", "আমরা রেস্তোরাঁয় একসাথে দুপুরের খাবার খাচ্ছিলাম।", "উই ওয়্যার হ্যাভিং লাঞ্চ টুগেদার অ্যাট দ্য রেস্টুরেন্ট।")
]

m5_l15_items = [
    ("past-m5-l15-001", "I was reading a book when the phone suddenly rang.", "আমি একটি বই পড়ছিলাম যখন হঠাৎ ফোনটি বেজে উঠল।", "আই ওয়াজ রিডিং আ বুক হোয়েন দ্য ফোন সাডেনলি র‍্যাং।"),
    ("past-m5-l15-002", "While I was walking in the park, I found a leather wallet.", "পার্কে হাঁটার সময় আমি একটি চামড়ার মানিব্যাগ পেয়েছিলাম।", "হোয়াইল আই ওয়াজ ওয়াকিং ইন দ্য পার্ক, আই ফাউন্ড আ লেদার ওয়ালেট।"),
    ("past-m5-l15-003", "She was driving to work when her car broke down.", "সে গাড়িতে চড়ে অফিসে যাচ্ছিল যখন তার গাড়িটি বিকল হয়ে পড়েছিল।", "শি ওয়াজ ড্রাইভিং টু ওয়ার্ক হোয়েন হার কার ব্রোক ডাউন।"),
    ("past-m5-l15-004", "While we were having dinner, the electricity went out.", "আমরা যখন রাতের খাবার খাচ্ছিলাম, তখন বিদ্যুৎ চলে গিয়েছিল।", "হোয়াইল উই ওয়্যার হ্যাভিং ডিনার, দি ইলেকট্রিসিটি ওয়েন্ট আউট।"),
    ("past-m5-l15-005", "He was crossing the busy street when he saw his teacher.", "সে ব্যস্ত রাস্তা পার হচ্ছিল যখন সে তার শিক্ষককে দেখতে পেয়েছিল।", "হি ওয়াজ ক্রসিং দ্য বিজি স্ট্রিট হোয়েন হি স হিজ টিচার।"),
    ("past-m5-l15-006", "They were watching a football match when the guests arrived.", "তারা ফুটবল ম্যাচ দেখছিল যখন অতিথিরা এসে পৌঁছেছিল।", "দে ওয়্যার ওয়াচিং আ ফুটবল ম্যাচ হোয়েন দ্য গেস্টস অ্যারাইভড।")
]

m5_l16_trans = [
    ("past-m5-trans-001", "He was writing an email.", "সে একটি ইমেইল লিখছিল।", "হি ওয়াজ রাইটিং অ্যান ইমেইল।", "assertive", "affirmative"),
    ("past-m5-trans-002", "He wasn't writing an email.", "সে ইমেইল লিখছিল না।", "হি ওয়াজন্ট রাইটিং অ্যান ইমেইল।", "assertive", "negative"),
    ("past-m5-trans-003", "Was he writing an email?", "সে কি ইমেইল লিখছিল?", "ওয়াজ হি রাইটিং অ্যান ইমেইল?", "interrogative", "affirmative"),
    ("past-m5-trans-004", "Wasn't he writing an email?", "সে কি ইমেইল লিখছিল না?", "ওয়াজন্ট হি রাইটিং অ্যান ইমেইল?", "interrogative", "negative"),
    ("past-m5-trans-005", "What was he writing?", "সে কী লিখছিল?", "হোয়াট ওয়াজ হি রাইটিং?", "wh_question", "affirmative"),
    ("past-m5-trans-006", "Why wasn't he writing?", "সে কেন লিখছিল না?", "হোয়াই ওয়াজন্ট হি রাইটিং?", "wh_question", "negative")
]

part5 = {
    "id": "past-foundations-p5",
    "order": 5,
    "level": "A2",
    "title_bn": "অতীত ঘটমান কাল ও ৬ রূপান্তর (Past Continuous & When/While)",
    "title_target": "Past Continuous & 6-Type Interrupted Transformations",
    "lessons": [
        {
            "id": "past-p5-l14",
            "order": 1,
            "title_bn": "অতীতে চলমান কাজ — 'Was / Were + Verb-ING'",
            "title_target": "Ongoing Past Actions (Was / Were + Verb-ING)",
            "intro_bn": "অতীতের কোনো নির্দিষ্ট সময়ে কোনো কাজ কিছুক্ষণ ধরে চলছিল বোঝাতে Past Continuous Tense ব্যবহৃত হয়।",
            "structure": ["Subject + was / were + Verb-ING"],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_continuous") for i in m5_l14_items]
        },
        {
            "id": "past-p5-l15",
            "order": 2,
            "title_bn": "'When' ও 'While' এর জাদুকরী সংযোগ (Interrupted Actions)",
            "title_target": "Interrupted Past Actions ('When' & 'While')",
            "intro_bn": "অতীতে একটি কাজ চলাকালে হঠাৎ অন্য একটি কাজ ঘটলে চলমান অংশটি Past Continuous এবং হঠাৎ ঘটা অংশটি Past Simple হয়।",
            "structure": [
                "Past Continuous + when + Past Simple",
                "While + Past Continuous + Past Simple"
            ],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_continuous") for i in m5_l15_items]
        },
        {
            "id": "past-p5-l16",
            "order": 3,
            "badge": "Very Important for Spoken English",
            "badge_bn": "স্পোকেন ইংলিশের জন্য অতি গুরুত্বপূর্ণ",
            "title_bn": "অতীত ঘটমান বাক্যের ৬ রূপান্তর ড্রিল (Continuous 6-Pattern)",
            "title_target": "6-Type Past Continuous Transformations Drill",
            "intro_bn": "অতীত ঘটমান বাক্যের ৬টি রূপ দ্রুত মুখে উচ্চারণ করার অভ্যাস করুন।",
            "structure": [
                "1. S + was/were + Verb-ING",
                "2. S + wasn't/weren't + Verb-ING",
                "3. Was/Were + S + Verb-ING?",
                "4. Wasn't/Weren't + S + Verb-ING?",
                "5. What was/were + S + doing?",
                "6. Why wasn't/weren't + S + Verb-ING?"
            ],
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type=i[4], polarity=i[5], tense="past_continuous") for i in m5_l16_trans]
        }
    ]
}

# ==============================================================================
# MODULE 6: Past Modals, Habits & Modal Tongue Twisters
# ==============================================================================
m6_l17_items = [
    ("past-m6-l17-001", "I used to play cricket every single afternoon in my school days.", "স্কুলজীবনে আমি প্রতিদিন বিকেলে ক্রিকেট খেলতাম।", "আই ইউজড টু প্লে ক্রিকেট এভরি সিঙ্গেল আফটারনুন ইন মাই স্কুল ডেইজ।"),
    ("past-m6-l17-002", "He used to live in Sylhet before moving to Dhaka.", "ঢাকায় আসার আগে তিনি সিলেটে বসবাস করতেন।", "হি ইউজড টু লিভ ইন সিলেট বিফোর মুভিং টু ঢাকা।"),
    ("past-m6-l17-003", "She used to wake up very early in the morning.", "তিনি খুব ভোরে ঘুম থেকে উঠতেন।", "শি ইউজড টু ওয়েক আপ ভেরি আর্লি ইন দ্য মর্নিং।"),
    ("past-m6-l17-004", "We used to swim in the village pond every summer.", "প্রতি গ্রীষ্মে আমরা গ্রামের পুকুরে সাঁতার কাটতাম।", "উই ইউজড টু সুইম ইন দ্য ভিলেজ পন্ড এভরি সামার।"),
    ("past-m6-l17-005", "I didn't use to like vegetables when I was a child.", "ছোটবেলায় আমি শাকসবজি পছন্দ করতাম না।", "আই ডিডন্ট ইউজ টু লাইক ভেজিটেবলস হোয়েন আই ওয়াজ আ চাইল্ড।"),
    ("past-m6-l17-006", "Did you use to practice English regularly? Yes, I used to practice every day.", "আপনি কি নিয়মিত ইংরেজি অনুশীলন করতেন? হ্যাঁ, আমি প্রতিদিন অনুশীলন করতাম।", "ডিড ইউ ইউজ টু প্র্যাকটিস ইংলিশ রেগুলারলি? ইয়েস, আই ইউজড টু প্র্যাকটিস এভরি ডে।")
]

m6_l18_had_to = [
    ("past-m6-l18-001", "I had to wake up at five in the morning yesterday.", "গতকাল সকালে আমাকে পাঁচটায় ঘুম থেকে উঠতে হয়েছিল।", "আই হ্যাড টু ওয়েক আপ অ্যাট ফাইভ ইন দ্য মর্নিং ইয়েস্টারডে।"),
    ("past-m6-l18-002", "He had to submit his report by noon.", "দুপুরের মধ্যে তাকে তার প্রতিবেদন জমা দিতে হয়েছিল।", "হি হ্যাড টু সাবমিট হিজ রিপোর্ট বাই নুন।"),
    ("past-m6-l18-003", "We had to cancel our family trip due to heavy rain.", "ভারী বৃষ্টির কারণে আমাদের পারিবারিক ভ্রমণ বাতিল করতে হয়েছিল।", "উই হ্যাড টু ক্যানসেল আওয়ার ফ্যামিলি ট্রিপ ডিউ টু হেভি রেইন।"),
    ("past-m6-l18-004", "I didn't have to pay any extra fee for the service.", "এই সেবার জন্য আমাকে কোনো অতিরিক্ত ফি দিতে হয়নি।", "আই ডিডন্ট হ্যাভ টু পে অ্যানি এক্সট্রা ফি ফর দ্য সার্ভিস।"),
    ("past-m6-l18-005", "Did you have to work overtime yesterday? Yes, I had to work late.", "গতকাল কি আপনাকে ওভারটাইম কাজ করতে হয়েছিল? হ্যাঁ, আমাকে রাত পর্যন্ত কাজ করতে হয়েছিল।", "ডিড ইউ হ্যাভ টু ওয়ার্ক ওভারটাইম ইয়েস্টারডে? ইয়েস, আই হ্যাড টু ওয়ার্ক লেইট।"),
    ("past-m6-l18-006", "Why did you have to leave early? Because I had an urgent appointment.", "আপনাকে তাড়াতাড়ি চলে যেতে হয়েছিল কেন? কারণ আমার জরুরি অ্যাপয়েন্টমেন্ট ছিল।", "হোয়াই ডিড ইউ হ্যাভ টু লিভ আর্লি? বিকজ আই হ্যাড অ্যান আর্জেন্ট অ্যাপয়েন্টমেন্ট।")
]

m6_l19_wants = [
    ("past-m6-l19-001", "I wanted to meet you yesterday, but I was busy.", "আমি গতকাল আপনার সাথে দেখা করতে চেয়েছিলাম, কিন্তু ব্যস্ত ছিলাম।", "আই ওয়ান্টেড টু মিট ইউ ইয়েস্টারডে, বাট আই ওয়াজ বিজি।"),
    ("past-m6-l19-002", "He wanted to buy that laptop, but it was too expensive.", "সে সেই ল্যাপটপটি কিনতে চেয়েছিল, কিন্তু এটি খুব দামি ছিল।", "হি ওয়ান্টেড টু বাই দ্যাট ল্যাপটপ, বাট ইট ওয়াজ টু এক্সপেন্সিভ।"),
    ("past-m6-l19-003", "I needed to talk to my manager regarding the project.", "প্রজেক্টের ব্যাপারে আমার ম্যানেজারের সাথে কথা বলা প্রয়োজন ছিল।", "আই নিডেড টু টক টু মাই ম্যানেজার রিগার্ডিং দ্য প্রজেক্ট।"),
    ("past-m6-l19-004", "She needed to buy some emergency medicine last night.", "গত রাতে তার কিছু জরুরি ওষুধ কেনা দরকার ছিল।", "শি নিডেড টু বাই সাম ইমার্জেন্সি মেডিসিন লাস্ট নাইট।"),
    ("past-m6-l19-005", "They didn't want to disclose the confidential information.", "তারা গোপনীয় তথ্য প্রকাশ করতে চায়নি।", "দে ডিডন্ট ওয়ান্ট টু ডিসক্লোজ দ্য কনফিডেনশিয়াল ইনফরমেশন।"),
    ("past-m6-l19-006", "Did you need any help yesterday? No, I managed everything myself.", "গতকাল আপনার কি কোনো সাহায্যের দরকার ছিল? না, আমি নিজেই সব সামলে নিয়েছি।", "ডিড ইউ নিড অ্যানি হেল্প ইয়েস্টারডে? নো, আই ম্যানেজড এভরিথিং মাইসেলফ।")
]

m6_l20_could = [
    ("past-m6-l20-001", "I could swim very fast when I was younger.", "আমি যখন ছোট ছিলাম তখন খুব দ্রুত সাঁতার কাটতে পারতাম।", "আই কুড সুইম ভেরি ফাস্ট হোয়েন আই ওয়াজ ইয়ঙ্গার।"),
    ("past-m6-l20-002", "She could speak three foreign languages fluently.", "তিনি সাবলীলভাবে তিনটি বিদেশি ভাষায় কথা বলতে পারতেন।", "শি কুড স্পিক থ্রি ফরেন ল্যাঙ্গুয়েজেস ফ্লুয়েন্টলি।"),
    ("past-m6-l20-003", "I couldn't attend the meeting because of a traffic jam.", "ট্রাফিক জ্যামের কারণে আমি সভায় উপস্থিত হতে পারিনি।", "আই কুডন্ট অ্যাটেন্ড দ্য মিটিং বিকজ অব আ ট্রাফিক জ্যাম।"),
    ("past-m6-l20-004", "He couldn't sleep well last night due to loud noise.", "প্রচণ্ড শব্দের কারণে গত রাতে তিনি ভালো ঘুমাতে পারেননি।", "হি কুডন্ট স্লিপ ওয়েল লাস্ট নাইট ডিউ টু লাউড নয়েজ।"),
    ("past-m6-l20-005", "Could you hear my voice clearly on the call? Yes, I could hear you clearly.", "ফোনে কি আপনি আমার কণ্ঠ স্পষ্টভাবে শুনতে পেরেছিলেন? হ্যাঁ, পরিষ্কার শুনতে পেরেছিলাম।", "কুড ইউ হেয়ার মাই ভয়েস ক্লিয়ারলি অন দ্য কল? ইয়েস, আই কুড হেয়ার ইউ ক্লিয়ারলি।"),
    ("past-m6-l20-006", "Could you understand what he said in the lecture? Yes, I could understand everything.", "লেকচারে তিনি কী বলেছিলেন তা কি আপনি বুঝতে পেরেছিলেন? হ্যাঁ, বুঝতে পেরেছিলাম।", "কুড ইউ আন্ডারস্ট্যান্ড হোয়াট হি সেইড ইন দ্য লেকচার? ইয়েস, আই কুড আন্ডারস্ট্যান্ড এভরিথিং।")
]

m6_l21_twisters = [
    ("past-m6-twister-001", "How much wood would a woodchuck chuck if a woodchuck could chuck wood?", "যদি উডচাক কাঠ ফেলতে পারত, তবে সে কতটা কাঠ ফেলত?", "হাউ মাচ উড উড আ উডচাক চাক ইফ আ উডচাক কুড চাক উড?", "/w/ and modal could/would"),
    ("past-m6-twister-002", "Peter Piper picked a peck of pickled peppers that he needed.", "পিটার পাইপার এক খাঁচি আচারযুক্ত মরিচ তুলেছিল যা তার প্রয়োজন ছিল।", "পিটার পাইপার পিক্ট আ পেক অব পিকল্ড পেপার্স দ্যাট হি নিডেড।", "/p/ and past needed"),
    ("past-m6-twister-003", "I wish I could wish the wish that you wished yesterday.", "আমি যদি সেই ইচ্ছাটি করতে পারতাম যা আপনি গতকাল করেছিলেন।", "আই উইশ আই কুড উইশ দ্য উইশ দ্যাট ইউ উইশড ইয়েস্টারডে।", "/w/ and past wished")
]

part6 = {
    "id": "past-foundations-p6",
    "order": 6,
    "level": "A2",
    "title_bn": "অতীতের ইচ্ছা, সামর্থ্য, অভ্যাস ও মোডাল টাং টুইস্টার",
    "title_target": "Past Modals, Habits & Pronunciation Twisters",
    "lessons": [
        {
            "id": "past-p6-l17",
            "order": 1,
            "title_bn": "অতীতের নিয়মিত অভ্যাস — 'Used to + V1'",
            "title_target": "Past Habits (Used to + Verb V1)",
            "intro_bn": "অতীতে নিয়মিত কোনো কাজ করা হতো কিন্তু বর্তমানে আর করা হয় না এমন অভ্যাস বোঝাতে 'used to + Verb (V1)' বসে।",
            "structure": ["Subject + used to + Verb (Base form V1)"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in m6_l17_items]
        },
        {
            "id": "past-p6-l18",
            "order": 2,
            "title_bn": "অতীতের বাধ্যবাধকতা — 'Had to + V1'",
            "title_target": "Past Obligations (Had to + Verb V1)",
            "intro_bn": "অতীতে কোনো কিছু করতে হয়েছিল বা বাধ্যবাধকতা ছিল বোঝাতে 'had to + Verb (V1)' বসে। না-বোধকে 'didn't have to' বসে।",
            "structure": ["Subject + had to + Verb (V1) / didn't have to + V1"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in m6_l18_had_to]
        },
        {
            "id": "past-p6-l19",
            "order": 3,
            "title_bn": "অতীতের ইচ্ছা ও প্রয়োজন — 'Wanted to' ও 'Needed to'",
            "title_target": "Past Desires & Needs (Wanted to & Needed to)",
            "intro_bn": "অতীতে কিছু করার ইচ্ছা ছিল বোঝাতে 'wanted to' এবং দরকার বা প্রয়োজন ছিল বোঝাতে 'needed to' বসে।",
            "structure": ["Subject + wanted to / needed to + Verb (V1)"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in m6_l19_wants]
        },
        {
            "id": "past-p6-l20",
            "order": 4,
            "title_bn": "অতীতের সামর্থ্য — 'Could / Couldn't'",
            "title_target": "Past Ability (Could / Couldn't + V1)",
            "intro_bn": "অতীতে কোনো কাজ করার সামর্থ্য ছিল ('পারতাম') বোঝাতে 'could' এবং পারতাম না বোঝাতে 'couldn't' বসে।",
            "structure": ["Subject + could / couldn't + Verb (V1)"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in m6_l20_could]
        },
        {
            "id": "past-p6-l21",
            "order": 5,
            "badge": "Very Important for Spoken English",
            "badge_bn": "স্পোকেন ইংলিশের জন্য অতি গুরুত্বপূর্ণ",
            "title_bn": "মোডাল ও অতীতের ৩টি টাং টুইস্টার ড্রিল",
            "title_target": "Modal Tongue Twisters for Fluency",
            "intro_bn": "মোডাল ও অতীতের ক্রিয়াপদ মুখে দ্রুত আনার জন্য এই ৩টি টাং টুইস্টার স্পিড ড্রিল করুন।",
            "structure": ["Slow Pace -> Normal Pace -> 3 Times Fast"],
            "items": [make_item(i[0], i[1], i[2], i[3], category="tongue_twister", phoneme_focus=i[4]) for i in m6_l21_twisters]
        }
    ]
}

# ==============================================================================
# MODULE 7: Past Perfect Tense & 6-Pattern Transformation
# ==============================================================================
m7_l22_items = [
    ("past-m7-l22-001", "She had done her homework before I came to visit her.", "আমি তার সাথে দেখা করতে আসার আগেই সে বাড়ির কাজ শেষ করেছিল।", "শি হ্যাড ডান হার হোমওয়ার্ক বিফোর আই কেইম টু ভিজিট হার।"),
    ("past-m7-l22-002", "The train had already left when we reached the platform.", "আমরা যখন প্ল্যাটফর্মে পৌঁছাই তখন ট্রেনটি ইতিমধ্যেই ছেড়ে গিয়েছিল।", "দ্য ট্রেন হ্যাড অলরেডি লেফট হোয়েন উই রীচড দ্য প্ল্যাটফর্ম।"),
    ("past-m7-l22-003", "I had finished my dinner before eight o'clock yesterday.", "গতকাল রাত আটটার আগেই আমি আমার রাতের খাবার শেষ করেছিলাম।", "আই হ্যাড ফিনিশড মাই ডিনার বিফোর এইট ও'ক্লক ইয়েস্টারডে।"),
    ("past-m7-l22-004", "They had sold their house before moving to another country.", "অন্য দেশে যাওয়ার আগেই তারা তাদের বাড়ি বিক্রি করে দিয়েছিল।", "দে হ্যাড সোল্ড দেয়ার হাউজ বিফোর মুভিং টু অ্যানাদার কান্ট্রি।"),
    ("past-m7-l22-005", "He had already informed the manager before submitting the leave letter.", "ছুটির দরখাস্ত জমা দেওয়ার আগেই তিনি ম্যানেজারকে জানিয়েছিলেন।", "হি হ্যাড অলরেডি ইনফর্মড দ্য ম্যানেজার বিফোর সাবমিটিং দ্য লিভ লেটার।"),
    ("past-m7-l22-006", "We had completed our project before the deadline arrived.", "সময়সীমা আসার আগেই আমরা আমাদের প্রজেক্ট সম্পন্ন করেছিলাম।", "উই হ্যাড কমপ্লিটেড আওয়ার প্রজেক্ট বিফোর দ্য ডেডলাইন অ্যারাইভড।")
]

m7_l23_items = [
    ("past-m7-l23-001", "The movie had started before we entered the hall.", "আমরা হলে প্রবেশের পূর্বেই সিনেমা শুরু হয়ে গিয়েছিল।", "দ্য মুভি হ্যাড স্টার্টেড বিফোর উই এন্টার্ড দ্য হল।"),
    ("past-m7-l23-002", "We entered the cinema hall after the movie had started.", "সিনেমা শুরু হওয়ার পর আমরা সিনেমা হলে প্রবেশ করেছিলাম।", "উই এন্টার্ড দ্য সিনেমা হল আফটার দ্য মুভি হ্যাড স্টার্টেড।"),
    ("past-m7-l23-003", "By the time he arrived, the meeting had already ended.", "তিনি পৌঁছানোর আগেই সভা শেষ হয়ে গিয়েছিল।", "বাই দ্য টাইম হি অ্যারাইভড, দ্য মিটিং হ্যাড অলরেডি এন্ডেড।"),
    ("past-m7-l23-004", "By the time the police came, the thieves had fled.", "পুলিশ আসার আগেই চোরেরা পালিয়ে গিয়েছিল।", "বাই দ্য টাইম দ্য পুলিশ কেইম, দ্য থিভস হ্যাড ফ্লেড।"),
    ("past-m7-l23-005", "I had never tasted such authentic cuisine before that trip.", "সেই ভ্রমণের আগে আমি কখনো এমন আসল খাবার খাইনি।", "আই হ্যাড নেভার টেস্টেড সাচ অথেনটিক ক্যুইজিন বিফোর দ্যাট ট্রিপ।"),
    ("past-m7-l23-006", "By midnight, all the invited guests had departed safely.", "মধ্যরাতের মধ্যে সকল আমন্ত্রিত অতিথি নিরাপদে প্রস্থান করেছিলেন।", "বাই মিডনাইট, অল দি ইনভাইটেড গেস্টস হ্যাড ডিপার্টেড সেফলি।")
]

m7_l24_trans = [
    ("past-m7-trans-001", "She had finished before noon.", "দুপুরের আগেই সে শেষ করেছিল।", "শি হ্যাড ফিনিশড বিফোর নুন।", "assertive", "affirmative"),
    ("past-m7-trans-002", "She hadn't finished before noon.", "দুপুরের আগে সে শেষ করেনি।", "শি হ্যাডন্ট ফিনিশড বিফোর নুন।", "assertive", "negative"),
    ("past-m7-trans-003", "Had she finished before noon?", "সে কি দুপুরের আগে শেষ করেছিল?", "হ্যাড শি ফিনিশড বিফোর নুন?", "interrogative", "affirmative"),
    ("past-m7-trans-004", "Hadn't she finished before noon?", "সে কি দুপুরের আগে শেষ করেনি?", "হ্যাডন্ট শি ফিনিশড বিফোর নুন?", "interrogative", "negative"),
    ("past-m7-trans-005", "What had she finished before noon?", "দুপুরের আগে সে কী শেষ করেছিল?", "হোয়াট হ্যাড শি ফিনিশড বিফোর নুন?", "wh_question", "affirmative"),
    ("past-m7-trans-006", "Why hadn't she finished before noon?", "দুপুরের আগে কেন সে শেষ করেনি?", "হোয়াই হ্যাডন্ট শি ফিনিশড বিফোর নুন?", "wh_question", "negative")
]

part7 = {
    "id": "past-foundations-p7",
    "order": 7,
    "level": "B1",
    "title_bn": "পুরাঘটিত অতীত কাল ও ৬ রূপান্তর (Past Perfect: Had + V3)",
    "title_target": "Past Perfect & 6-Type Before/After Transformations",
    "lessons": [
        {
            "id": "past-p7-l22",
            "order": 1,
            "title_bn": "দুটি অতীত কাজের পূর্ববর্তী কাজ — 'Had + V3'",
            "title_target": "Earlier Past Action (Subject + Had + V3)",
            "intro_bn": "অতীতে দুটি কাজ ঘটে থাকলে তাদের মধ্যে অপেক্ষাকৃত পূর্ববর্তী কাজটি Past Perfect (had + V3) এবং পরবর্তী কাজটি Past Simple (V2) হয়।",
            "structure": ["Earlier Action: Subject + had + V3"],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_perfect") for i in m7_l22_items]
        },
        {
            "id": "past-p7-l23",
            "order": 2,
            "title_bn": "'Before', 'After' ও 'By the time' এর গোল্ডেন রুলস",
            "title_target": "Rules of 'Before', 'After' & 'By the time'",
            "intro_bn": "গোল্ডেন রুল: Before এর পূর্বে এবং After এর পরে Past Perfect (had + V3) বসে।",
            "structure": [
                "Past Perfect + BEFORE + Past Simple",
                "Past Simple + AFTER + Past Perfect",
                "By the time + Past Simple, S + had + V3"
            ],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_perfect") for i in m7_l23_items]
        },
        {
            "id": "past-p7-l24",
            "order": 3,
            "badge": "Very Important for Spoken English",
            "badge_bn": "স্পোকেন ইংলিশের জন্য অতি গুরুত্বপূর্ণ",
            "title_bn": "পুরাঘটিত রূপের ৬ রূপান্তর ড্রিল (Past Perfect 6-Pattern)",
            "title_target": "6-Type Past Perfect Transformations Drill",
            "intro_bn": "পুরাঘটিত অতীত বাক্যের ৬টি রূপ দ্রুত মুখে উচ্চারণ করার অভ্যাস করুন।",
            "structure": [
                "1. S + had + V3",
                "2. S + hadn't + V3",
                "3. Had + S + V3?",
                "4. Hadn't + S + V3?",
                "5. What had + S + V3?",
                "6. Why hadn't + S + V3?"
            ],
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type=i[4], polarity=i[5], tense="past_perfect") for i in m7_l24_trans]
        }
    ]
}

# ==============================================================================
# MODULE 8: Past Perfect Continuous (Had been + Verb-ING)
# ==============================================================================
m8_l25_items = [
    ("past-m8-l25-001", "She had been cooking in the kitchen for hours when I came home.", "আমি যখন বাড়ি আসি তখন সে কয়েক ঘণ্টা ধরে রান্নাঘরে রান্না করছিল।", "শি হ্যাড বিন কুকিং ইন দ্য কিচেন ফর আওয়ার্স হোয়েন আই কেইম হোম।"),
    ("past-m8-l25-002", "He had been waiting for the bus for forty minutes before it finally arrived.", "বাস আসার আগে সে চল্লিশ মিনিট ধরে অপেক্ষা করছিল।", "হি হ্যাড বিন ওয়েটিং ফর দ্য বাস ফর ফোরটি মিনিট্স বিফোর ইট ফাইনালি অ্যারাইভড।"),
    ("past-m8-l25-003", "They had been working on the software for six months before launching it.", "সফটওয়্যারটি লঞ্চ করার আগে তারা ছয় মাস ধরে এটিতে কাজ করছিল।", "দে হ্যাড বিন ওয়ার্কিং অন দ্য সফটওয়্যার ফর সিক্স মান্থস বিফোর লঞ্চিং ইট।"),
    ("past-m8-l25-004", "It had been raining continuously since morning before the sun broke through.", "সূর্য ওঠার আগে সকাল থেকেই একটানা বৃষ্টি হচ্ছিল।", "ইট হ্যাড বিন রেইনিং কন্টিনিউয়াসলি সিন্স মর্নিং বিফোর দ্য সান ব্রোক থ্রু।"),
    ("past-m8-l25-005", "I had been living in that apartment for three years before I moved to Dhanmondi.", "ধানমন্ডিতে যাওয়ার আগে আমি তিন বছর ওই অ্যাপার্টমেন্টে থাকছিলাম।", "আই হ্যাড বিন লিভিং ইন দ্যাট অ্যাপার্টমেন্ট ফর থ্রি ইয়ার্স বিফোর আই মুভড টু ধানমন্ডি।"),
    ("past-m8-l25-006", "How long had you been studying before taking the break? I had been studying for three hours.", "বিরতি নেওয়ার আগে আপনি কতক্ষণ ধরে পড়ছিলেন? আমি তিন ঘণ্টা ধরে পড়ছিলাম।", "হাউ লং হ্যাড ইউ বিন স্টাডিয়িং বিফোর টেকিং দ্য ব্রেক? আই হ্যাড বিন স্টাডিয়িং ফর থ্রি আওয়ার্স।")
]

m8_l26_items = [
    ("past-m8-l26-001", "His eyes were red because he had been staring at the screen all day.", "তার চোখ লাল ছিল কারণ সে সারাদিন স্ক্রিনের দিকে তাকিয়ে ছিল।", "হিজ আইজ ওয়্যার রেড বিকজ হি হ্যাড বিন স্টেয়ারিং অ্যাট দ্য স্ক্রিন অল ডে।"),
    ("past-m8-l26-002", "She was out of breath because she had been running fast.", "সে হাঁপাচ্ছিল কারণ সে দ্রুত দৌড়াচ্ছিল।", "শি ওয়াজ আউট অব ব্রেথ বিকজ শি হ্যাড বিন রানিং ফাস্ট।"),
    ("past-m8-l26-003", "The ground was completely wet because it had been raining heavily.", "মাটি পুরোপুরি ভেজা ছিল কারণ ভারী বৃষ্টি হচ্ছিল।", "দ্য গ্রাউন্ড ওয়াজ কমপ্লিটলি ওয়েট বিকজ ইট হ্যাড বিন রেইনিং হেভিলি।"),
    ("past-m8-l26-004", "They were exhausted because they had been travelling since morning.", "তারা ক্লান্ত ছিল কারণ তারা সকাল থেকে ভ্রমণ করছিল।", "দে ওয়্যার এক্সহস্টেড বিকজ দে হ্যাড বিন ট্রাভেলিং সিন্স মর্নিং।")
]

part8 = {
    "id": "past-foundations-p8",
    "order": 8,
    "level": "B1",
    "title_bn": "পুরাঘটিত ঘটমান অতীত কাল (Past Perfect Continuous Tense)",
    "title_target": "Past Perfect Continuous (Had been + Verb-ING)",
    "lessons": [
        {
            "id": "past-p8-l25",
            "order": 1,
            "title_bn": "নির্দিষ্ট সময় ধরে চলা অতীত কাজ — 'Had been + Verb-ING'",
            "title_target": "Duration Before Past Event (Had been + Verb-ING)",
            "intro_bn": "অতীতে কোনো কাজ বিশেষ কোনো সময়ের পূর্ব হতে আরম্ভ হয়ে সেই সময় পর্যন্ত চলছিল বোঝালে Past Perfect Continuous Tense হয়।",
            "structure": ["Subject + had been + Verb-ING + for / since"],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_perfect_continuous") for i in m8_l25_items]
        },
        {
            "id": "past-p8-l26",
            "order": 2,
            "title_bn": "অতীত কারণ ও ফলাফল বিশ্লেষণ (Past Cause & Effect)",
            "title_target": "Past Cause & Effect Analysis",
            "intro_bn": "অতীতে কোনো শারীরিক অবস্থা বা ফলাফলের কারণ দীর্ঘস্থায়ী কোনো কাজের ফল হিসেবে প্রকাশ করতে Past Perfect Continuous বসে।",
            "structure": ["Past Simple (State) + because + S + had been + Verb-ING"],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_perfect_continuous") for i in m8_l26_items]
        }
    ]
}

# ==============================================================================
# MODULE 9: Past Passive Voice
# ==============================================================================
m9_l27_items = [
    ("past-m9-l27-001", "Parents were sent there safely.", "বাবা-মাকে সেখানে নিরাপদে পাঠানো হয়েছিল।", "প্যারেন্টস ওয়্যার সেন্ট দেয়ার সেফলি।"),
    ("past-m9-l27-002", "He was given an honorable award for his outstanding work.", "অসামান্য কাজের জন্য তাকে একটি সম্মানজনক পুরস্কার দেওয়া হয়েছিল।", "হি ওয়াজ গিভেন অ্যান অনারেবল অ্যাওয়ার্ড ফর হিজ আউটস্ট্যান্ডিং ওয়ার্ক।"),
    ("past-m9-l27-003", "The historic bridge was built over fifty years ago.", "ঐতিহাসিক সেতুটি পঞ্চাশ বছরেরও বেশি সময় আগে নির্মিত হয়েছিল।", "দ্য হিস্টোরিক ব্রিজ ওয়াজ বিল্ট ওভার ফিফটি ইয়ার্স এগো।"),
    ("past-m9-l27-004", "The official email was sent to all team members yesterday.", "গতকাল সকল দলের সদস্যকে অফিশিয়াল ইমেইল পাঠানো হয়েছিল।", "দি অফিশিয়াল ইমেইল ওয়াজ সেন্ট টু অল টিম মেম্বার্স ইয়েস্টারডে।"),
    ("past-m9-l27-005", "The stolen laptop was recovered by the local police.", "চুরি যাওয়া ল্যাপটপটি স্থানীয় পুলিশ উদ্ধার করেছিল।", "দ্য স্টোলেন ল্যাপটপ ওয়াজ রিকভার্ড বাই দ্য লোকাল পুলিশ।"),
    ("past-m9-l27-006", "All our questions were answered clearly by the speaker.", "বক্তা আমাদের সকল প্রশ্নের পরিষ্কার উত্তর দিয়েছিলেন।", "অল আওয়ার কোয়েশ্চেনস ওয়্যার অ্যানসার্ড ক্লিয়ারলি বাই দ্য স্পিকার।")
]

m9_l28_items = [
    ("past-m9-l28-001", "The damaged car was being repaired at the workshop.", "ওয়ার্কশপে ক্ষতিগ্রস্ত গাড়িটি মেরামত করা হচ্ছিল।", "দ্য ড্যামেজড কার ওয়াজ বিয়িং রিপেয়ার্ড অ্যাট দ্য ওয়ার্কশপ।"),
    ("past-m9-l28-002", "A new highway was being constructed across the district.", "জেলাভিত্তিক একটি নতুন মহাসড়ক নির্মাণ করা হচ্ছিল।", "আ নিউ হাইওয়ে ওয়াজ বিয়িং কনস্ট্রাক্টেড অ্যাক্রস দ্য ডিস্ট্রিক্ট।"),
    ("past-m9-l28-003", "Delicious dinner was being prepared for all the visitors.", "সকল দর্শনার্থীদের জন্য সুস্বাদু রাতের খাবার তৈরি করা হচ্ছিল।", "ডেলিশাস ডিনার ওয়াজ বিয়িং প্রিপেয়ার্ড ফর অল দ্য ভিজিটরস।"),
    ("past-m9-l28-004", "The criminal suspects were being tracked carefully by the cyber police.", "সাইবার পুলিশ সন্দেহভাজন অপরাধীদের অত্যন্ত সতর্কতার সাথে ট্র্যাক করছিল।", "দ্য ক্রিমিনাল সাসপেক্টস ওয়্যার বিয়িং ট্র্যাক্ট কেয়ারফুলি বাই দ্য সাইবার পুলিশ।"),
    ("past-m9-l28-005", "The official documents were being verified by the embassy.", "দূতাবাস কর্তৃক অফিশিয়াল কাগজপত্র যাচাই করা হচ্ছিল।", "দি অফিশিয়াল ডকুমেন্টস ওয়্যার বিয়িং ভেরিফাইড বাই দি অ্যাম্বাসি।"),
    ("past-m9-l28-006", "Was the issue being discussed in the board meeting? Yes, it was being discussed actively.", "বোর্ড সভায় কি বিষয়টি নিয়ে আলোচনা করা হচ্ছিল? হ্যাঁ, সক্রিয়ভাবে আলোচনা করা হচ্ছিল।", "ওয়াজ দি ইস্যু বিয়িং ডিসকাসড ইন দ্য বোর্ড মিটিং? ইয়েস, ইট ওয়াজ বিয়িং ডিসকাসড অ্যাক্টিভলি।")
]

part9 = {
    "id": "past-foundations-p9",
    "order": 9,
    "level": "B1",
    "title_bn": "অতীত কালের কর্মবাচ্য (Past Passive Voice: Was/Were + V3)",
    "title_target": "Past Passive Voice (Was/Were + V3 & Was/Were being + V3)",
    "lessons": [
        {
            "id": "past-p9-l27",
            "order": 1,
            "title_bn": "সাধারণ অতীত কর্মবাচ্য — 'Was / Were + V3'",
            "title_target": "Past Simple Passive (Was / Were + V3)",
            "intro_bn": "অতীতে কর্তা ছাড়া কোনো কাজ কারো দ্বারা সম্পন্ন হয়েছিল বোঝাতে Past Simple Passive বসে।",
            "structure": ["Subject + was / were + V3 (Past Participle)"],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_passive") for i in m9_l27_items]
        },
        {
            "id": "past-p9-l28",
            "order": 2,
            "title_bn": "চলমান অতীত কর্মবাচ্য — 'Was / Were being + V3'",
            "title_target": "Past Continuous Passive (Was / Were being + V3)",
            "intro_bn": "অতীতে কোনো কাজ কারো দ্বারা করা হচ্ছিল বোঝাতে Past Continuous Passive বসে।",
            "structure": ["Subject + was / were being + V3"],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_passive") for i in m9_l28_items]
        }
    ]
}

# ==============================================================================
# MODULE 10: Mini Past Presentations & Storytelling
# ==============================================================================
m10_l29_presentation = [
    ("past-m10-pres-001", "I spent my memorable childhood in a quiet village in Sylhet.", "আমি আমার স্মরণীয় শৈশব সিলেটের একটি শান্ত গ্রামে কাটিয়েছিলাম।", "আই স্পেন্ট মাই মেমোরেবল চাইল্ডহুড ইন আ কোয়ায়েট ভিলেজ ইন সিলেট।"),
    ("past-m10-pres-002", "We used to swim in the local river every single afternoon.", "আমরা প্রতিদিন বিকেলে স্থানীয় নদীতে সাঁতার কাটতাম।", "উই ইউজড টু সুইম ইন দ্য লোকাল রিভার এভরি সিঙ্গেল আফটারনুন।"),
    ("past-m10-pres-003", "My grandfather was a wise person and told us inspiring stories.", "আমার দাদা একজন জ্ঞানী ব্যক্তি ছিলেন এবং আমাদের অনুপ্রেরণামূলক গল্প বলতেন।", "মাই গ্র্যান্ডফাদার ওয়াজ আ ওয়াইজ পারসন অ্যান্ড টোল্ড আস ইন্সপায়ারিং স্টোরিজ।"),
    ("past-m10-pres-004", "We didn't have any smartphones, but we were genuinely happy.", "আমাদের কোনো স্মার্টফোন ছিল না, কিন্তু আমরা সত্যিই সুখী ছিলাম।", "উই ডিডন্ট হ্যাভ অ্যানি স্মার্টফোনস, বাট উই ওয়্যার জেনুইনলি হ্যাপি।"),
    ("past-m10-pres-005", "Those days taught me the real value of family and friendship.", "সেই দিনগুলো আমাকে পরিবার এবং বন্ধুত্বের আসল মূল্য শিখিয়েছিল।", "দোজ ডেইজ টট মি দ্য রিয়েল ভ্যালু অব ফ্যামিলি অ্যান্ড ফ্রেন্ডশিপ।")
]

m10_l30_presentation = [
    ("past-m10-pres-006", "Last winter, I visited Cox's Bazar with my family members.", "গত শীতে আমি আমার পরিবারের সদস্যদের সাথে কক্সবাজার ভ্রমণ করেছিলাম।", "লাস্ট উইন্টার, আই ভিজিটেড কক্সবাজার উইথ মাই ফ্যামিলি মেম্বার্স।"),
    ("past-m10-pres-007", "We stayed at a beautiful resort right beside the beach.", "আমরা সমুদ্র সৈকতের ঠিক পাশেই একটি সুন্দর রিসোর্টে ছিলাম।", "উই સ્ટેইড অ্যাট আ বিউটিফুল রিসোর্ট রাইট বিসাইড দ্য বিচ।"),
    ("past-m10-pres-008", "While we were walking on the sand, we watched a magnificent sunset.", "আমরা যখন বালির ওপর হাঁটছিলাম, তখন আমরা একটি চমৎকার সূর্যাস্ত দেখেছিলাম।", "হোয়াইল উই ওয়্যার ওয়াকিং অন দ্য স্যান্ড, উই ওয়াচড আ ম্যাগনিফিসেন্ট সানসেট।"),
    ("past-m10-pres-009", "We also tasted fresh delicious seafood at a local eatery.", "আমরা একটি স্থানীয় রেস্তোরাঁয় তাজা সুস্বাদু সামুদ্রিক খাবারও খেয়েছিলাম।", "উই অলসো টেস্টেড ফ্রেশ ডেলিশাস সিফুড অ্যাট আ লোকাল ইটারি।"),
    ("past-m10-pres-010", "That journey was one of the most unforgettable trips of my life.", "সেই ভ্রমণটি আমার জীবনের সবচেয়ে অবিস্মরণীয় ভ্রমণের একটি ছিল।", "দ্যাট জার্নি ওয়াজ ওয়ান অব দ্য মোস্ট আনফরগেটেবল ট্রিপস অব মাই লাইফ।")
]

part10 = {
    "id": "past-foundations-p10",
    "order": 10,
    "level": "A2",
    "title_bn": "অতীতের গল্প বলা ও উপস্থাপনা (Mini Past Presentations)",
    "title_target": "Storytelling & Mini Past Presentations",
    "lessons": [
        {
            "id": "past-p10-l29",
            "order": 1,
            "badge": "Fluency Presentation",
            "badge_bn": "ফ্লুয়েন্সি প্রেজেন্টেশন",
            "title_bn": "উপস্থাপনা ১: 'My Memorable Childhood' (আমার স্মরণীয় শৈশব)",
            "title_target": "Presentation 1: My Memorable Childhood",
            "intro_bn": "শৈশবের স্মৃতি একটানা ৫ লাইনে সাবলীলভাবে বলার স্পোকেন অনুশীলন।",
            "structure": ["Past Simple (V2) + Used to + Was/Were"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in m10_l29_presentation]
        },
        {
            "id": "past-p10-l30",
            "order": 2,
            "badge": "Fluency Presentation",
            "badge_bn": "ফ্লুয়েন্সি প্রেজেন্টেশন",
            "title_bn": "উপস্থাপনা ২: 'How I Spent My Last Holiday' (গত ছুটি যেভাবে কাটিয়েছিলাম)",
            "title_target": "Presentation 2: How I Spent My Last Holiday",
            "intro_bn": "ভ্রমণের অভিজ্ঞতা ও আনন্দময় স্মৃতি ইংরেজিতে ধারাবাহিকভাবে বলার অনুশীলন।",
            "structure": ["V2 + When / While + Was/Were"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in m10_l30_presentation]
        }
    ]
}

# ==============================================================================
# MODULE 11: Past Voice Interactive Pair Practice (Voice Q&A)
# ==============================================================================
p11_pairs = [
    (
        "Did you lock the front door before leaving?",
        "Yes, I locked the front door.",
        "No, I didn't lock the front door.",
        "বের হওয়ার আগে কি সদর দরজা তালা দিয়েছিলে?",
        "ডিড ইউ লক দ্য ফ্রন্ট ডোর বিফোর লিভিং?"
    ),
    (
        "Were you sleeping when I called you last night?",
        "Yes, I was sleeping when you called.",
        "No, I wasn't sleeping when you called.",
        "গত রাতে যখন ফোন করেছিলাম আপনি কি ঘুমাচ্ছিলেন?",
        "ওয়্যার ইউ স্লিপিং হোয়েন আই কল্ড ইউ লাস্ট নাইট?"
    ),
    (
        "Did you finish your assigned task yesterday?",
        "Yes, I finished my task yesterday.",
        "No, I didn't finish my task yesterday.",
        "গতকাল কি তোমার নির্ধারিত কাজ শেষ করেছিলে?",
        "ডিড ইউ ফিনিশ ইয়োর অ্যাসাইন্ড টাস্ক ইয়েস্টারডে?"
    ),
    (
        "Did you have to work late at the office yesterday?",
        "Yes, I had to work late yesterday.",
        "No, I didn't have to work late.",
        "গতকাল কি অফিসে আপনাকে রাত পর্যন্ত কাজ করতে হয়েছিল?",
        "ডিড ইউ হ্যাভ টু ওয়ার্ক লেইট অ্যাট দি অফিস ইয়েস্টারডে?"
    ),
    (
        "Could you hear my voice clearly on the phone call?",
        "Yes, I could hear your voice clearly.",
        "No, I couldn't hear your voice clearly.",
        "ফোনে কি আমার কণ্ঠ স্পষ্টভাবে শুনতে পেরেছিলেন?",
        "কুড ইউ হেয়ার মাই ভয়েস ক্লিয়ারলি অন দ্য ফোন কল?"
    ),
    (
        "Did she go shopping with her friends last weekend?",
        "Yes, she went shopping with her friends.",
        "No, she didn't go shopping last weekend.",
        "গত সপ্তাহে সে কি বন্ধুদের সাথে কেনাকাটা করতে গিয়েছিল?",
        "ডিড শি গো শপিং উইথ হার ফ্রেন্ডস লাস্ট উইকেন্ড?"
    ),
    (
        "Were they waiting for you at the railway station?",
        "Yes, they were waiting for me at the station.",
        "No, they weren't waiting for me.",
        "তারা কি রেলওয়ে স্টেশনে আপনার জন্য অপেক্ষা করছিল?",
        "ওয়্যার দে ওয়েটিং ফর ইউ অ্যাট দ্য রেলওয়ে স্টেশন?"
    ),
    (
        "Did you watch the cricket match last night?",
        "Yes, I watched the cricket match last night.",
        "No, I didn't watch the cricket match.",
        "গত রাতে কি ক্রিকেট ম্যাচটি দেখেছিলে?",
        "ডিড ইউ ওয়াচ দ্য ক্রিকেট ম্যাচ লাস্ট নাইট?"
    ),
    (
        "Did you get up early yesterday morning?",
        "Yes, I got up early yesterday morning.",
        "No, I didn't get up early yesterday.",
        "গতকাল সকালে কি আপনি ভোরে উঠেছিলেন?",
        "ডিড ইউ গেট আপ আর্লি ইয়েস্টারডে মর্নিং?"
    ),
    (
        "Did you meet your old school friend yesterday?",
        "Yes, I met my old school friend yesterday.",
        "No, I didn't meet my old friend.",
        "গতকাল কি আপনার পুরানো স্কুল বন্ধুর সাথে দেখা হয়েছিল?",
        "ডিড ইউ মিট ইয়োর ওল্ড স্কুল ফ্রেন্ড ইয়েস্টারডে?"
    ),
    (
        "Had the train already left before you reached the station?",
        "Yes, the train had already left.",
        "No, the train had not left yet.",
        "স্টেশনে পৌঁছানোর আগেই কি ট্রেনটি চলে গিয়েছিল?",
        "হ্যাড দ্য ট্রেন অলরেডি লেফট বিফোর ইউ রীচড দ্য স্টেশন?"
    ),
    (
        "Did you use to play cricket in your childhood?",
        "Yes, I used to play cricket in my childhood.",
        "No, I didn't use to play cricket.",
        "ছোটবেলায় কি তুমি ক্রিকেট খেলতে?",
        "ডিড ইউ ইউজ টু প্লে ক্রিকেট ইন ইয়োর চাইল্ডহুড?"
    ),
    (
        "Did you buy that new smartphone two days ago?",
        "Yes, I bought that new smartphone.",
        "No, I didn't buy that smartphone.",
        "দুই দিন আগে কি তুমি সেই নতুন স্মার্টফোনটি কিনেছিলে?",
        "ডিড ইউ বাই দ্যাট নিউ স্মার্টফোন টু ডেইজ এগো?"
    ),
    (
        "Was it raining heavily when you left the house?",
        "Yes, it was raining heavily.",
        "No, it was not raining heavily.",
        "বাড়ি থেকে বের হওয়ার সময় কি মুষলধারে বৃষ্টি হচ্ছিল?",
        "ওয়াজ ইট রেইনিং হেভিলি হোয়েন ইউ লেফট দ্য হাউজ?"
    ),
    (
        "Did you receive my official email yesterday afternoon?",
        "Yes, I received your email yesterday.",
        "No, I didn't receive your email yesterday.",
        "গতকাল বিকেলে কি আপনি আমার অফিশিয়াল ইমেইল পেয়েছিলেন?",
        "ডিড ইউ রিসিভ মাই অফিশিয়াল ইমেইল ইয়েস্টারডে আফটারনুন?"
    ),
    (
        "Could you solve that difficult math problem easily?",
        "Yes, I could solve it easily.",
        "No, I couldn't solve it easily.",
        "তুমি কি সেই কঠিন গণিত সমস্যাটি সহজে সমাধান করতে পেরেছিলে?",
        "কুড ইউ সলভ দ্যাট ডিফিকাল্ট ম্যাথ প্রবলেম ইজিলি?"
    ),
    (
        "Did you need any extra help during the exam?",
        "Yes, I needed some extra help.",
        "No, I didn't need any help.",
        "পরীক্ষার সময় আপনার কি বাড়তি সাহায্যের প্রয়োজন ছিল?",
        "ডিড ইউ নিড অ্যানি এক্সট্রা হেল্প ডিউরিং দি এক্সাম?"
    ),
    (
        "Were you cooking dinner when the guests arrived?",
        "Yes, I was cooking dinner when they arrived.",
        "No, I wasn't cooking dinner when they arrived.",
        "অতিথিরা পৌঁছালে তুমি কি রাতের খাবার রান্না করছিলে?",
        "ওয়্যার ইউ কুকিং ডিনার হোয়েন দ্য গেস্টস অ্যারাইভড?"
    ),
    (
        "Did you sleep well throughout the night?",
        "Yes, I slept very well throughout the night.",
        "No, I didn't sleep well last night.",
        "সারারাত কি আপনার ভালো ঘুম হয়েছিল?",
        "ডিড ইউ স্লিপ ওয়েল থ্রুআউট দ্য নাইট?"
    ),
    (
        "Did you find your lost car keys under the table?",
        "Yes, I found my car keys under the table.",
        "No, I didn't find my keys under the table.",
        "টেবিলের নিচে কি তোমার হারিয়ে যাওয়া গাড়ির চাবি খুঁজে পেয়েছিলে?",
        "ডিড ইউ ফাইন্ড ইয়োর লস্ট কার কিজ আন্ডার দ্য টেবিল?"
    )
]

p11_items = []
for idx, (q, yes_a, no_a, q_bn, q_pron) in enumerate(p11_pairs, start=1):
    tokens = [{"t": w, "bn": ""} for w in q.split()]
    item_obj = {
        "id": f"past-p11-pair-{idx:03d}",
        "concept_id": f"c-past-p11-pair-{idx:03d}",
        "order": idx,
        "type": "sentence",
        "level": "A2",
        "target": q,
        "bn": q_bn,
        "bn_pron": q_pron,
        "tokens": tokens,
        "speaker": "pair_practice",
        "tags": {
            "sentence_type": "pair_practice",
            "practice_type": "voice_qa",
            "tense": "past"
        },
        "example": {
            "target": yes_a,
            "bn": no_a
        },
        "status": "reviewed",
        "reviewFlags": ""
    }
    p11_items.append(item_obj)

part11 = {
    "id": "past-foundations-p11",
    "order": 11,
    "level": "A2",
    "title_bn": "অতীত কাল ভয়েস পেয়ার প্র্যাকটিস (Past Voice Q&A Practice)",
    "title_target": "Past Tense Interactive Voice Practice",
    "lessons": [
        {
            "id": "past-p11-l31",
            "order": 1,
            "title_bn": "অতীত কাল ভয়েস পেয়ার প্র্যাকটিস (Voice Q&A Practice)",
            "title_target": "Past Tense Interactive Voice Practice",
            "intro_bn": "মাইক্রোফোনে ট্যাপ করে অতীত প্রশ্ন শুনুন এবং ইংরেজিতে উত্তর দিন। হ্যাঁ-বোধক উত্তর 'Yes' দিয়ে এবং না-বোধক উত্তর 'No' দিয়ে শুরু করুন। আমাদের এআই সিস্টেম আপনার উচ্চারণ ও সঠিক অতীত ফর্ম (V2 / didn't) মূল্যায়ন করবে।",
            "structure": [
                "Question: Did you + V1...? / Were you + V-ing...?",
                "Yes Answer: Yes, I + V2... / Yes, I was + V-ing...",
                "No Answer: No, I didn't + V1... / No, I wasn't + V-ing..."
            ],
            "items": p11_items
        }
    ]
}

all_parts = [part1, part2, part3, part4, part5, part6, part7, part8, part9, part10, part11]

total_lessons = sum(len(p['lessons']) for p in all_parts)
total_items = sum(sum(len(l['items']) for l in p['lessons']) for p in all_parts)

final_data = {
    "schema_version": 1,
    "course": course_metadata,
    "stats": {
        "lessons": total_lessons,
        "items": total_items
    },
    "parts": all_parts
}

with open(DEST_FILE, 'w', encoding='utf-8') as f:
    json.dump(final_data, f, indent=2, ensure_ascii=False)

print(f"Successfully generated Past Tense course in {DEST_FILE}!")
print(f"Total parts: {len(all_parts)}")
print(f"Total lessons: {total_lessons}")
print(f"Total items: {total_items}")
