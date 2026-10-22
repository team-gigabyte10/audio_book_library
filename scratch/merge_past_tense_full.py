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
# PART 1: Past Identity, Feelings, Tongue Twisters & 6-Pattern Transformations
# ==============================================================================
p1_l1 = [
    ("past-p1-l1-001", "I was very busy yesterday afternoon.", "আমি গতকাল বিকেলে খুব ব্যস্ত ছিলাম।", "আই ওয়াজ ভেরি বিজি ইয়েস্টারডে আফটারনুন।"),
    ("past-p1-l1-002", "He was sick last week and stayed in bed.", "সে গত সপ্তাহে অসুস্থ ছিল এবং বিছানায় বিশ্রাম নিয়েছিল।", "হি ওয়াজ সিক লাস্ট উইক অ্যান্ড સ્ટેইড ইন বেড।"),
    ("past-p1-l1-003", "They were at home yesterday evening.", "তারা গতকাল সন্ধ্যায় বাড়িতে ছিল।", "দে ওয়্যার অ্যাট হোম ইয়েস্টারডে ইভনিং।"),
    ("past-p1-l1-004", "She was a dedicated school teacher before moving abroad.", "বিদেশে যাওয়ার আগে তিনি একজন নিবেদিতপ্রাণ শিক্ষক ছিলেন।", "শি ওয়াজ আ ডেডিকেটেড স্কুল টিচার বিফোর মুভিং অ্যাব্রড।"),
    ("past-p1-l1-005", "The weather was very pleasant and sunny yesterday.", "গতকাল আবহাওয়া খুব মনোরম এবং রৌদ্রোজ্জ্বল ছিল।", "দ্য ওয়েদার ওয়াজ ভেরি প্লেজেন্ট অ্যান্ড সানি ইয়েস্টারডে।"),
    ("past-p1-l1-006", "Were you sick yesterday? Yes, I was sick yesterday. No, I was not sick.", "আপনি কি গতকাল অসুস্থ ছিলেন? হ্যাঁ, আমি গতকাল অসুস্থ ছিলাম। না, আমি অসুস্থ ছিলাম না।", "ওয়্যার ইউ সিক ইয়েস্টারডে? ইয়েস, আই ওয়াজ সিক ইয়েস্টারডে। নো, আই ওয়াজ নট সিক।"),
    ("past-p1-l1-007", "Were they in the office on Sunday? Yes, they were in the office. No, they were not.", "তারা কি রবিবারে অফিসে ছিল? হ্যাঁ, তারা অফিসে ছিল। না, তারা ছিল না।", "ওয়্যার দে ইন দি অফিস অন সানডে? ইয়েস, দে ওয়্যার ইন দি অফিস। নো, দে ওয়্যার নট।"),
    ("past-p1-l1-008", "Where were you yesterday morning? I was at the central library.", "আপনি গতকাল সকালে কোথায় ছিলেন? আমি সেন্ট্রাল লাইব্রেরিতে ছিলাম।", "হোয়ার ওয়্যার ইউ ইয়েস্টারডে মর্নিং? আই ওয়াজ অ্যাট দ্য সেন্ট্রাল লাইব্রেরি।")
]

p1_l2 = [
    ("past-p1-l2-001", "I was very tired after the long journey.", "দীর্ঘ ভ্রমণের পর আমি খুব ক্লান্ত ছিলাম।", "আই ওয়াজ ভেরি টায়ার্ড আফটার দ্য লং জার্নি।"),
    ("past-p1-l2-002", "She was extremely happy with her examination results.", "পরীক্ষার ফলাফলে সে অত্যন্ত খুশি ছিল।", "শি ওয়াজ এক্সট্রিমলি হ্যাপি উইথ হার এক্সামিনেশন রেজাল্টস।"),
    ("past-p1-l2-003", "They were very proud of our teamwork.", "তারা আমাদের দলগত কাজে অত্যন্ত গর্বিত ছিল।", "দে ওয়্যার ভেরি প্রাউড অব আওয়ার টিমওয়ার্ক।"),
    ("past-p1-l2-004", "He was quite nervous before the interview started.", "সাক্ষাৎকার শুরুর আগে তিনি বেশ নার্ভাস ছিলেন।", "হি ওয়াজ কোয়াইট নার্ভাস বিফোর দি ইন্টারভিউ স্টার্টেড।"),
    ("past-p1-l2-005", "We were delighted to meet our old friends again.", "পুরানো বন্ধুদের সাথে আবার দেখা হয়ে আমরা আনন্দিত ছিলাম।", "উই ওয়্যার ডিলাইটেড টু মিট আওয়ার ওল্ড ফ্রেন্ডস এগেইন।"),
    ("past-p1-l2-006", "The customer was very satisfied with our fast service.", "গ্রাহক আমাদের দ্রুত সেবায় অত্যন্ত সন্তুষ্ট ছিলেন।", "দ্য কাস্টমার ওয়াজ ভেরি স্যাটিসফাইড উইথ আওয়ার ফাস্ট সার্ভিস।"),
    ("past-p1-l2-007", "Were you upset about the news? No, I was calm and patient.", "সংবাদটিতে আপনি কি মন খারাপ করেছিলেন? না, আমি শান্ত ও ধৈর্যশীল ছিলাম।", "ওয়্যার ইউ আপসেট অ্যাবাউট দ্য নিউজ? নো, আই ওয়াজ কাম অ্যান্ড পেশেন্ট।"),
    ("past-p1-l2-008", "Why were you late yesterday? Because the traffic was terrible.", "গতকাল আপনার দেরি হয়েছিল কেন? কারণ ট্রাফিক খুব খারাপ ছিল।", "হোয়াই ওয়্যার ইউ লেইট ইয়েস্টারডে? বিকজ দ্য ট্রাফিক ওয়াজ টেরিবল।")
]

p1_l3_twisters = [
    ("past-p1-twister-001", "Betty Botter bought some butter, but the butter was bitter.", "বেটি বটার কিছু মাখন কিনেছিল, কিন্তু মাখনটি ছিল তিতকুটে।", "বেটি বটার বট সাম বাটার, বাট দ্য বাটার ওয়াজ বিটার।", "/b/ & /t/ plosives"),
    ("past-p1-twister-002", "I thought a thought, but the thought I thought wasn't the thought I thought I thought.", "আমি একটি ভাবনা ভেবেছিলাম, কিন্তু যে ভাবনাটি ভেবেছিলাম তা সেই ভাবনা ছিল না যা ভেবেছিলাম।", "আই থট আ থট, বাট দ্য থট আই থট ওয়াজন্ট দ্য থট আই থট আই থট।", "/th/ dental fricative"),
    ("past-p1-twister-003", "Six slippery snails slid slowly seaward yesterday.", "ছয়টি পিচ্ছিল শামুক গতকাল ধীরে ধীরে সমুদ্রের দিকে পিছলে গেল।", "সিক্স স্লিপারি স্নেইলস স্লিড স্লোলি সিওয়ার্ড ইয়েস্টারডে।", "/s/ and /sl/ past blends"),
    ("past-p1-twister-004", "A loyal warrior fought fiercely for his fallen king.", "একজন বিশ্বস্ত যোদ্ধা তার প্রয়াত রাজার জন্য বীরত্বের সাথে যুদ্ধ করেছিল।", "আ লয়াল ওয়ারিয়র ফট ফিয়ার্সলি ফর হিজ ফলেন কিং।", "/f/ and past fought"),
    ("past-p1-twister-005", "Whether the weather was warm or whether the weather was cold.", "আবহাওয়া উষ্ণ ছিল নাকি আবহাওয়া ঠান্ডা ছিল।", "ওয়েদার দ্য ওয়েদার ওয়াজ ওয়ার্ম অর ওয়েদার দ্য ওয়েদার ওয়াজ কোল্ড।", "/w/ and was/were")
]

p1_l4_trans = [
    ("past-p1-trans-001", "I was a leader.", "আমি একজন নেতা ছিলাম।", "আই ওয়াজ আ লিডার।", "assertive", "affirmative"),
    ("past-p1-trans-002", "I was not a leader.", "আমি একজন নেতা ছিলাম না।", "আই ওয়াজ নট আ লিডার।", "assertive", "negative"),
    ("past-p1-trans-003", "Was I a leader?", "আমি কি একজন নেতা ছিলাম?", "ওয়াজ আই আ লিডার?", "interrogative", "affirmative"),
    ("past-p1-trans-004", "Wasn't I a leader?", "আমি কি একজন নেতা ছিলাম না?", "ওয়াজন্ট আই আ লিডার?", "interrogative", "negative"),
    ("past-p1-trans-005", "Why was I a leader?", "আমি কেন একজন নেতা ছিলাম?", "হোয়াই ওয়াজ আই আ লিডার?", "wh_question", "affirmative"),
    ("past-p1-trans-006", "Why wasn't I a leader?", "আমি কেন একজন নেতা ছিলাম না?", "হোয়াই ওয়াজন্ট আই আ লিডার?", "wh_question", "negative"),
    ("past-p1-trans-007", "He was a doctor.", "তিনি একজন ডাক্তার ছিলেন।", "হি ওয়াজ আ ডক্টর।", "assertive", "affirmative"),
    ("past-p1-trans-008", "He was not a doctor.", "তিনি একজন ডাক্তার ছিলেন না।", "হি ওয়াজ নট আ ডক্টর।", "assertive", "negative"),
    ("past-p1-trans-009", "Was he a doctor?", "তিনি কি একজন ডাক্তার ছিলেন?", "ওয়াজ হি আ ডক্টর?", "interrogative", "affirmative"),
    ("past-p1-trans-010", "Wasn't he a doctor?", "তিনি কি একজন ডাক্তার ছিলেন না?", "ওয়াজন্ট হি আ ডক্টর?", "interrogative", "negative"),
    ("past-p1-trans-011", "Where was he a doctor?", "তিনি কোথায় ডাক্তার ছিলেন?", "হোয়ার ওয়াজ হি আ ডক্টর?", "wh_question", "affirmative"),
    ("past-p1-trans-012", "Why wasn't he a doctor?", "তিনি কেন ডাক্তার ছিলেন না?", "হোয়াই ওয়াজন্ট হি আ ডক্টর?", "wh_question", "negative")
]

part1 = {
    "id": "past-foundations-p1",
    "order": 1,
    "level": "A1",
    "title_bn": "অতীতের অবস্থা, পরিচয় ও উচ্চারণ ড্রিল (Past State & Identity)",
    "title_target": "Past State, Identity & Tongue Twisters",
    "lessons": [
        {
            "id": "past-p1-l01",
            "order": 1,
            "title_bn": "পেশা ও পরিচয় — 'Was / Were' (Past Identity)",
            "title_target": "Past Identity & Professions (Was / Were)",
            "intro_bn": "অতীতে কারো পেশা বা পরিচয় কী ছিল তা প্রকাশ করতে 'was / were' ব্যবহৃত হয়। (I/He/She/It এর সাথে was এবং We/You/They এর সাথে were)।",
            "structure": ["Subject + was / were + a/an + Profession / Identity"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in p1_l1]
        },
        {
            "id": "past-p1-l02",
            "order": 2,
            "title_bn": "অনুভূতি ও বৈশিষ্ট্য (Past Feelings & States)",
            "title_target": "Past Feelings & States (Was / Were + Adjective)",
            "intro_bn": "অতীতে কারো মানসিক অবস্থা, অনুভূতি বা বৈশিষ্ট্য প্রকাশ করতে 'was / were + Adjective' বসে।",
            "structure": ["Subject + was / were + Adjective"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in p1_l2]
        },
        {
            "id": "past-p1-l03",
            "order": 3,
            "badge": "Very Important for Spoken English",
            "badge_bn": "স্পোকেন ইংলিশের জন্য অতি গুরুত্বপূর্ণ",
            "title_bn": "জিহ্বার জড়তা দূরীকরণে ৫টি অতীত টাং টুইস্টার",
            "title_target": "5 Past Tongue Twisters for Clear Pronunciation",
            "intro_bn": "অতীত কালের উচ্চারণের জড়তা দূর করার জন্য এই ৫টি টাং টুইস্টার প্রথমে ধীরে, তারপর স্বাভাবিক গতিতে এবং সবশেষে দ্রুত ৩ বার অনুশীলন করুন।",
            "structure": ["Read Slowly -> Natural Pace -> Speed Up 3 Times"],
            "items": [make_item(i[0], i[1], i[2], i[3], category="tongue_twister", phoneme_focus=i[4]) for i in p1_l3_twisters]
        },
        {
            "id": "past-p1-l04",
            "order": 4,
            "badge": "Very Important for Spoken English",
            "badge_bn": "স্পোকেন ইংলিশের জন্য অতি গুরুত্বপূর্ণ",
            "title_bn": "বাক্যের ৬ রূপান্তর: পরিচয় ও অবস্থা (অতি গুরুত্বপূর্ণ)",
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
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type=i[4], polarity=i[5]) for i in p1_l4_trans]
        }
    ]
}

# ==============================================================================
# PART 2: Past Location & Preposition Transformations
# ==============================================================================
p2_l5 = [
    ("past-p2-l5-001", "I was at the office yesterday morning.", "আমি গতকাল সকালে অফিসে ছিলাম।", "আই ওয়াজ অ্যাট দি অফিস ইয়েস্টারডে মর্নিং।"),
    ("past-p2-l5-002", "She was in the hospital last Sunday.", "গত রবিবারে সে হাসপাতালে ছিল।", "শি ওয়াজ ইন দ্য হসপিটাল লাস্ট সানডে।"),
    ("past-p2-l5-003", "They were at the international airport on time.", "তারা সময়মতো আন্তর্জাতিক বিমানবন্দরে ছিল।", "দে ওয়্যার অ্যাট দি ইন্টারন্যাশনাল এয়ারপোর্ট অন টাইম।"),
    ("past-p2-l5-004", "The official documents were on the manager's desk.", "কাগজপত্রগুলো ম্যানেজারের ডেস্কে ছিল।", "দি অফিশিয়াল ডকুমেন্টস ওয়্যার অন দ্য ম্যানেজার্স ডেস্ক।"),
    ("past-p2-l5-005", "We were in Cox's Bazar during the winter vacation.", "শীতকালীন ছুটিতে আমরা কক্সবাজারে ছিলাম।", "উই ওয়্যার ইন কক্সবাজার ডিউরিং দ্য উইন্টার ভ্যাকেশন।"),
    ("past-p2-l5-006", "He was at home when the heavy rain started.", "ভারী বৃষ্টি শুরু হওয়ার সময় সে বাড়িতে ছিল।", "হি ওয়াজ অ্যাট হোম হোয়েন দ্য হেভি রেইন স্টার্টেড।"),
    ("past-p2-l5-007", "Were you at the railway station yesterday? Yes, I was there.", "গতকাল আপনি কি রেলস্টেশনে ছিলেন? হ্যাঁ, আমি সেখানে ছিলাম।", "ওয়্যার ইউ অ্যাট দ্য রেলওয়ে স্টেশন ইয়েস্টারডে? ইয়েস, আই ওয়াজ দেয়ার।"),
    ("past-p2-l5-008", "Where were you last Friday evening? I was at my friend's house.", "গত শুক্রবার সন্ধ্যায় আপনি কোথায় ছিলেন? আমি আমার বন্ধুর বাড়িতে ছিলাম।", "হোয়ার ওয়্যার ইউ লাস্ট ফ্রাইডে ইভনিং? আই ওয়াজ অ্যাট মাই ফ্রেন্ডস হাউজ।")
]

p2_l6_trans = [
    ("past-p2-trans-001", "She was at work.", "সে কাজে ছিল।", "শি ওয়াজ অ্যাট ওয়ার্ক।", "assertive", "affirmative"),
    ("past-p2-trans-002", "She was not at work.", "সে কাজে ছিল না।", "শি ওয়াজ নট অ্যাট ওয়ার্ক।", "assertive", "negative"),
    ("past-p2-trans-003", "Was she at work?", "সে কি কাজে ছিল?", "ওয়াজ শি অ্যাট ওয়ার্ক?", "interrogative", "affirmative"),
    ("past-p2-trans-004", "Wasn't she at work?", "সে কি কাজে ছিল না?", "ওয়াজন্ট শি অ্যাট ওয়ার্ক?", "interrogative", "negative"),
    ("past-p2-trans-005", "Where was she yesterday?", "সে গতকাল কোথায় ছিল?", "হোয়ার ওয়াজ শি ইয়েস্টারডে?", "wh_question", "affirmative"),
    ("past-p2-trans-006", "Why wasn't she at work?", "সে কাজে ছিল না কেন?", "হোয়াই ওয়াজন্ট শি অ্যাট ওয়ার্ক?", "wh_question", "negative")
]

part2 = {
    "id": "past-foundations-p2",
    "order": 2,
    "level": "A1",
    "title_bn": "অতীতের অবস্থান ও প্রিপজিশনের ৬ রূপান্তর (Past Location & Prepositions)",
    "title_target": "Past Location & 6-Type Preposition Transformations",
    "lessons": [
        {
            "id": "past-p2-l05",
            "order": 1,
            "title_bn": "অতীতের অবস্থান ও প্রিপজিশন (Past Location & Prepositions)",
            "title_target": "Past Location (was/were at, in, on, under)",
            "intro_bn": "অতীতে কেউ কোথায় বা কোন অবস্থানে ছিল তা প্রকাশ করতে 'was / were + Preposition + Place' বসে।",
            "structure": ["Subject + was / were + at / in / on + Place"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in p2_l5]
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
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type=i[4], polarity=i[5]) for i in p2_l6_trans]
        }
    ]
}

# ==============================================================================
# PART 3: Past Possession (Had) & 6-Pattern Transformations
# ==============================================================================
p3_l7 = [
    ("past-p3-l7-001", "I had a blue bicycle in my school days.", "স্কুলজীবনে আমার একটি নীল সাইকেল ছিল।", "আই হ্যাড আ ব্লু বাইসাইকেল ইন মাই স্কুল ডেইজ।"),
    ("past-p3-l7-002", "He had a lot of valuable experience in software development.", "সফটওয়্যার তৈরিতে তার প্রচুর মূল্যবান অভিজ্ঞতা ছিল।", "হি হ্যাড আ লট অব ভ্যালুয়েবল এক্সপেরিয়েন্স ইন সফটওয়্যার ডেভেলপমেন্ট।"),
    ("past-p3-l7-003", "We had enough time to prepare for the final presentation.", "চূড়ান্ত উপস্থাপনার প্রস্তুতির জন্য আমাদের পর্যাপ্ত সময় ছিল।", "উই হ্যাড এনাফ টাইম টু প্রিপেয়ার ফর দ্য ফাইনাল প্রেজেন্টেশন।"),
    ("past-p3-l7-004", "She had a severe headache yesterday afternoon.", "গতকাল বিকেলে তার তীব্র মাথা ব্যথা ছিল।", "শি হ্যাড আ সিভিয়ার হেডেক ইয়েস্টারডে আফটারনুন।"),
    ("past-p3-l7-005", "They had a beautiful garden beside their village house.", "তাদের গ্রামের বাড়ির পাশে একটি সুন্দর বাগান ছিল।", "দে হ্যাড আ বিউটিফুল গার্ডেন বিসাইড দেয়ার ভিলেজ হাউজ।"),
    ("past-p3-l7-006", "Did you have any problems yesterday? No, I had no problem.", "গতকাল আপনার কি কোনো সমস্যা ছিল? না, আমার কোনো সমস্যা ছিল না।", "ডিড ইউ হ্যাভ অ্যানি প্রবলেমস ইয়েস্টারডে? নো, আই হ্যাড নো প্রবলেম।"),
    ("past-p3-l7-007", "I had an important business meeting at two pm.", "দুপুর দুইটায় আমার একটি গুরুত্বপূর্ণ ব্যবসায়িক সভা ছিল।", "আই হ্যাড অ্যান ইম্পরট্যান্ট বিজনেস মিটিং অ্যাট টু পিএম।"),
    ("past-p3-l7-008", "She had complete confidence in her team members.", "তার দলের সদস্যদের প্রতি তার পূর্ণ আস্থা ছিল।", "শি হ্যাড কমপ্লিট কনফিডেন্স ইন হার টিম মেম্বার্স।")
]

p3_l8_trans = [
    ("past-p3-trans-001", "I had a car.", "আমার একটি গাড়ি ছিল।", "আই হ্যাড আ কার।", "assertive", "affirmative"),
    ("past-p3-trans-002", "I didn't have a car.", "আমার কোনো গাড়ি ছিল না।", "আই ডিডন্ট হ্যাভ আ কার।", "assertive", "negative"),
    ("past-p3-trans-003", "Did you have a car?", "আপনার কি একটি গাড়ি ছিল?", "ডিড ইউ হ্যাভ আ কার?", "interrogative", "affirmative"),
    ("past-p3-trans-004", "Didn't you have a car?", "আপনার কি গাড়ি ছিল না?", "ডিডন্ট ইউ হ্যাভ আ কার?", "interrogative", "negative"),
    ("past-p3-trans-005", "What did you have?", "আপনার কী ছিল?", "হোয়াট ডিড ইউ হ্যাভ?", "wh_question", "affirmative"),
    ("past-p3-trans-006", "Why didn't you have a car?", "আপনার গাড়ি ছিল না কেন?", "হোয়াই ডিডন্ট ইউ হ্যাভ আ কার?", "wh_question", "negative")
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
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in p3_l7]
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
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type=i[4], polarity=i[5]) for i in p3_l8_trans]
        }
    ]
}

# ==============================================================================
# PART 4: Past Simple Actions, '-ed' Pronunciation Rules, 6-Pattern & WH-Drill
# ==============================================================================
p4_l9_ed = [
    ("past-p4-ed-001", "I walked five kilometers yesterday.", "আমি গতকাল পাঁচ কিলোমিটার হেঁটেছিলাম। (উচ্চারণ: ওয়াক্ট - /t/ ধ্বনি)", "আই ওয়াক্ট ফাইভ কিলোমিটার্স ইয়েস্টারডে।", "pronunciation_rule", "/t/ sound: -ed after voiceless p, k, s, sh, ch"),
    ("past-p4-ed-002", "She watched the entire documentary.", "সে পুরো ডকুমেন্টারিটি দেখেছিল। (উচ্চারণ: ওয়াচ্ট - /t/ ধ্বনি)", "শি ওয়াচ্ট দি এনটায়ার ডকুমেন্টারি।", "pronunciation_rule", "/t/ sound"),
    ("past-p4-ed-003", "We played cricket all afternoon.", "আমরা পুরো বিকেল ক্রিকেট খেলেছিলাম। (উচ্চারণ: প্লেয়্ড - /d/ ধ্বনি)", "উই প্লেয়্ড ক্রিকেট অল আফটারনুন।", "pronunciation_rule", "/d/ sound: -ed after voiced sounds"),
    ("past-p4-ed-004", "He lived in London for two years.", "তিনি লন্ডনে দুই বছর বসবাস করেছিলেন। (উচ্চারণ: লিভ্ড - /d/ ধ্বনি)", "হি লিভ্ড ইন লন্ডন ফর টু ইয়ার্স।", "pronunciation_rule", "/d/ sound"),
    ("past-p4-ed-005", "I wanted to learn fluent English.", "আমি সাবলীল ইংরেজি শিখতে চেয়েছিলাম। (উচ্চারণ: ওয়ান্টেড - /ɪd/ ধ্বনি)", "আই ওয়ান্টেড টু লার্ন ফ্লুয়েন্ট ইংলিশ।", "pronunciation_rule", "/ɪd/ sound: -ed after t or d"),
    ("past-p4-ed-006", "They needed immediate medical assistance.", "তাদের অবিলম্বে চিকিৎসা সহায়তার প্রয়োজন ছিল। (উচ্চারণ: নিডেড - /ɪd/ ধ্বনি)", "দে নিডেড ইমিডিয়েট মেডিকেল অ্যাসিস্ট্যান্স।", "pronunciation_rule", "/ɪd/ sound")
]

p4_l10_v2 = [
    ("past-p4-l10-001", "She went shopping with her sister last Saturday.", "তিনি গত শনিবার তার বোনের সাথে কেনাকাটা করতে গিয়েছিলেন।", "শি ওয়েন্ট শপিং উইথ হার সিস্টার লাস্ট স্যাটারডে।"),
    ("past-p4-l10-002", "We got up early yesterday and went for a long morning walk.", "আমরা গতকাল খুব ভোরে ঘুম থেকে উঠে দীর্ঘ প্রাতঃভ্রমণে গিয়েছিলাম।", "উই গট আপ আর্লি ইয়েস্টারডে অ্যান্ড ওয়েন্ট ফর আ লং মর্নিং ওয়াক।"),
    ("past-p4-l10-003", "I met my old school friend at the railway station.", "রেলওয়ে স্টেশনে আমার পুরানো স্কুল বন্ধুর সাথে দেখা হয়েছিল।", "আই মেট মাই ওল্ড স্কুল ফ্রেন্ড অ্যাট দ্য রেলওয়ে স্টেশন।"),
    ("past-p4-l10-004", "He bought a brand new smartphone two days ago.", "সে দুই দিন আগে একটি একদম নতুন স্মার্টফোন কিনেছিল।", "হি বট আ ব্র্যান্ড নিউ স্মার্টফোন টু ডেইজ এগো।"),
    ("past-p4-l10-005", "She cooked delicious biryani for all the invited guests.", "তিনি সকল আমন্ত্রিত অতিথিদের জন্য সুস্বাদু বিরিয়ানি রান্না করেছিলেন।", "শি কুক্ট ডেলিশাস বিরিয়ানি ফর অল দি ইনভাইটেড গেস্টস।"),
    ("past-p4-l10-006", "We watched an inspiring documentary last night.", "আমরা গত রাতে একটি অনুপ্রেরণামূলক ডকুমেন্টারি দেখেছি।", "উই ওয়াচড অ্যান ইন্সপায়ারিং ডকুমেন্টারি লাস্ট নাইট।"),
    ("past-p4-l10-007", "They reached the international airport on time yesterday.", "তারা গতকাল সময়মতো আন্তর্জাতিক বিমানবন্দরে পৌঁছেছিল।", "দে রীচড দি ইন্টারন্যাশনাল এয়ারপোর্ট অন টাইম ইয়েস্টারডে।"),
    ("past-p4-l10-008", "I finished reading the entire book in just three days.", "আমি মাত্র তিন দিনে পুরো বইটি পড়া শেষ করেছিলাম।", "আই ফিনিশড রিডিং দি এনটায়ার বুক ইন জাস্ট থ্রি ডেইজ।")
]

p4_l11_didnt = [
    ("past-p4-l11-001", "I didn't receive your phone call yesterday.", "আমি গতকাল আপনার ফোন কল পাইনি।", "আই ডিডন্ট রিসিভ ইয়োর ফোন কল ইয়েস্টারডে।"),
    ("past-p4-l11-002", "She didn't go shopping with her friends last month.", "তিনি গত মাসে বন্ধুদের সাথে কেনাকাটা করতে যাননি।", "শি ডিডন্ট গো শপিং উইথ হার ফ্রেন্ডস লাস্ট মান্থ।"),
    ("past-p4-l11-003", "We didn't get up late yesterday morning.", "আমরা গতকাল সকালে দেরিতে উঠিনি।", "উই ডিডন্ট গেট আপ লেইট ইয়েস্টারডে মর্নিং।"),
    ("past-p4-l11-004", "He didn't tell me about the schedule change.", "তিনি সময়সূচি পরিবর্তনের ব্যাপারে আমাকে কিছু জানাননি।", "হি ডিডন্ট টেল মি অ্যাবাউট দ্য শিডিউল চেইঞ্জ।"),
    ("past-p4-l11-005", "They didn't attend the annual general meeting yesterday.", "তারা গতকাল বার্ষিক সাধারণ সভায় উপস্থিত হননি।", "দে ডিডন্ট অ্যাটেন্ড দি অ্যানুয়াল জেনারেল মিটিং ইয়েস্টারডে।"),
    ("past-p4-l11-006", "I didn't understand that complex grammar rule at first.", "আমি প্রথমে সেই জটিল ব্যাকরণ নিয়মটি বুঝতে পারিনি।", "আই ডিডন্ট আন্ডারস্ট্যান্ড দ্যাট কমপ্লেক্স গ্রামার রুল অ্যাট ফার্স্ট।"),
    ("past-p4-l11-007", "She didn't buy that expensive blue dress from the mall.", "সে মল থেকে সেই দামি নীল পোশাকটি কেনেনি।", "শি ডিডন্ট বাই দ্যাট এক্সপেন্সিভ ব্লু ড্রেস ফ্রম দ্য মল।"),
    ("past-p4-l11-008", "We didn't face any trouble on our way back home.", "বাড়ি ফেরার পথে আমরা কোনো সমস্যায় পড়িনি।", "উই ডিডন্ট ফেইস অ্যানি ট্রাবল অন আওয়ার ওয়ে ব্যাক হোম।")
]

p4_l12_trans = [
    ("past-p4-trans-001", "She cooked dinner.", "সে রাতের খাবার রান্না করেছিল।", "শি কুক্ট ডিনার।", "assertive", "affirmative"),
    ("past-p4-trans-002", "She didn't cook dinner.", "সে রাতের খাবার রান্না করেনি।", "শি ডিডন্ট কুক ডিনার।", "assertive", "negative"),
    ("past-p4-trans-003", "Did she cook dinner?", "সে কি রাতের খাবার রান্না করেছিল?", "ডিড শি কুক ডিনার?", "interrogative", "affirmative"),
    ("past-p4-trans-004", "Didn't she cook dinner?", "সে কি রাতের খাবার রান্না করেনি?", "ডিডন্ট শি কুক ডিনার?", "interrogative", "negative"),
    ("past-p4-trans-005", "Why did she cook dinner?", "সে কেন রাতের খাবার রান্না করেছিল?", "হোয়াই ডিড শি কুক ডিনার?", "wh_question", "affirmative"),
    ("past-p4-trans-006", "Why didn't she cook dinner?", "সে কেন রাতের খাবার রান্না করেনি?", "হোয়াই ডিডন্ট শি কুক ডিনার?", "wh_question", "negative")
]

p4_l13_qa = [
    ("past-p4-qa-001", "Did she go shopping last weekend? Yes, she went shopping. No, she didn't go shopping.", "সে কি গত সপ্তাহে কেনাকাটা করতে গিয়েছিল? হ্যাঁ, সে কেনাকাটা করতে গিয়েছিল। না, সে যায়নি।", "ডিড শি গো শপিং লাস্ট উইকেন্ড? ইয়েস, শি ওয়েন্ট শপিং। নো, শি ডিডন্ট গো শপিং।"),
    ("past-p4-qa-002", "Did you get up early yesterday? Yes, I got up early. No, I didn't get up early.", "তুমি কি কাল ভোরে উঠেছিলে? হ্যাঁ, আমি ভোরে উঠেছিলাম। না, আমি ভোরে উঠিনি।", "ডিড ইউ গেট আপ আর্লি ইয়েস্টারডে? ইয়েস, আই গট আপ আর্লি। নো, আই ডিডন্ট গেট আপ আর্লি।"),
    ("past-p4-qa-003", "Did you watch the cricket match yesterday? Yes, I watched the match. No, I didn't watch it.", "তুমি কি গতকাল ক্রিকেট ম্যাচটি দেখেছিলে? হ্যাঁ, আমি ম্যাচটি দেখেছি। না, আমি দেখিনি।", "ডিড ইউ ওয়াচ দ্য ক্রিকেট ম্যাচ ইয়েস্টারডে? ইয়েস, আই ওয়াচড দ্য ম্যাচ। নো, আই ডিডন্ট ওয়াচ ইট।"),
    ("past-p4-qa-004", "Did he call you last night? Yes, he called me. No, he didn't call me.", "সে কি গত রাতে তোমাকে ফোন করেছিল? হ্যাঁ, সে আমাকে ফোন করেছিল। না, সে আমাকে ফোন করেনি।", "ডিড হি কল ইউ লাস্ট নাইট? ইয়েস, হি কল্ড মি। নো, হি ডিডন্ট কল মি।"),
    ("past-p4-qa-005", "Did they enjoy the beach party? Yes, they enjoyed it very much. No, they didn't enjoy it.", "তারা কি সমুদ্র সৈকতের পার্টি উপভোগ করেছিল? হ্যাঁ, তারা খুব উপভোগ করেছিল। না, তারা উপভোগ করেনি।", "ডিড দে এনজয় দ্য বিচ পার্টি? ইয়েস, দে এনজয়েড ইট ভেরি মাচ। নো, দে ডিডন্ট এনজয় ইট।"),
    ("past-p4-qa-006", "Did you sleep well last night? Yes, I slept very well. No, I didn't sleep well.", "গত রাতে আপনার ঘুম ভালো হয়েছিল? হ্যাঁ, আমার খুব ভালো ঘুম হয়েছিল। না, আমার ঘুম ভালো হয়নি।", "ডিড ইউ স্লিপ ওয়েল লাস্ট নাইট? ইয়েস, আই স্লেপ্ট ভেরি ওয়েল। নো, আই ডিডন্ট স্লিপ ওয়েল।"),
    ("past-p4-qa-007", "Did it rain heavily in your area yesterday? Yes, it rained heavily. No, it didn't rain.", "গতকাল কি আপনার এলাকায় ভারী বৃষ্টি হয়েছিল? হ্যাঁ, ভারী বৃষ্টি হয়েছিল। না, বৃষ্টি হয়নি।", "ডিড ইট রেইন হেভিলি ইন ইয়োর এরিয়া ইয়েস্টারডে? ইয়েস, ইট রেইন্ড হেভিলি। নো, ইট ডিডন্ট রেইন।"),
    ("past-p4-qa-008", "Did you find your lost wallet? Yes, I found it under the table. No, I didn't find it yet.", "তুমি কি তোমার হারিয়ে যাওয়া মানিব্যাগ খুঁজে পেয়েছ? হ্যাঁ, আমি টেবিলের নিচে পেয়েছি। না, আমি এখনও খুঁজে পাইনি।", "ডিড ইউ ফাইন্ড ইয়োর লস্ট ওয়ালেট? ইয়েস, আই ফাউন্ড ইট আন্ডার দ্য টেবিল। নো, আই ডিডন্ট ফাইন্ড ইট ইয়েট।")
]

p4_l14_wh = [
    ("past-p4-wh-001", "Where did you go yesterday evening? I went to the shopping mall.", "আপনি গতকাল সন্ধ্যায় কোথায় গিয়েছিলেন? আমি শপিং মলে গিয়েছিলাম।", "হোয়ার ডিড ইউ গো ইয়েস্টারডে ইভনিং? আই ওয়েন্ট টু দ্য শপিং মল।"),
    ("past-p4-wh-002", "What did you buy at the supermarket? I bought fresh fruits and vegetables.", "আপনি সুপারমার্কেটে কী কিনেছিলেন? আমি তাজা ফল ও শাকসবজি কিনেছিলাম।", "হোয়াট ডিড ইউ বাই অ্যাট দ্য সুপারমার্কেট? আই বট ফ্রেশ ফ্রুটস অ্যান্ড ভেজিটেবলস।"),
    ("past-p4-wh-003", "When did they arrive at the venue? They arrived at six in the evening.", "তারা কখন অনুষ্ঠানস্থলে পৌঁছেছিলেন? তারা সন্ধ্যা ছয়টায় পৌঁছেছিলেন।", "হোয়েন ডিড দে অ্যারাইভ অ্যাট দ্য ভেনিউ? দে অ্যারাইভড অ্যাট সিক্স ইন দি ইভনিং।"),
    ("past-p4-wh-004", "Why did you miss the morning bus? Because I got up a little late.", "আপনি সকালের বাস মিস করেছিলেন কেন? কারণ আমি একটু দেরিতে ঘুম থেকে উঠেছিলাম।", "হোয়াই ডিড ইউ মিস দ্য মর্নিং বাস? বিকজ আই গট আপ আ লিটল লেইট।"),
    ("past-p4-wh-005", "How did you learn to speak English so well? I practiced speaking every single day.", "আপনি এত সুন্দর ইংরেজি বলা কীভাবে শিখলেন? আমি প্রতিদিন কথা বলার অনুশীলন করেছি।", "হাউ ডিড ইউ লার্ন টু স্পিক ইংলিশ সো ওয়েল? আই প্র্যাকটিসড স্পিকিং এভরি সিঙ্গেল ডে।"),
    ("past-p4-wh-006", "Who did you meet at the office conference? I met our new marketing director.", "অফিসের সম্মেলনে আপনি কার সাথে দেখা করেছিলেন? আমি আমাদের নতুন পরিচালকের সাথে দেখা করেছিলাম।", "হু ডিড ইউ মিট অ্যাট দি অফিস কনফারেন্স? আই মেট আওয়ার নিউ ডিরেক্টর।"),
    ("past-p4-wh-007", "What time did you go to bed last night? I went to bed around midnight.", "গত রাতে আপনি কয়টায় ঘুমাতে গিয়েছিলেন? আমি প্রায় মধ্যরাতে ঘুমাতে গিয়েছিলাম।", "হোয়াট টাইম ডিড ইউ গো টু বেড লাস্ট নাইট? আই ওয়েন্ট টু বেড অ্যারাউন্ড মিডনাইট।"),
    ("past-p4-wh-008", "How much did this leather jacket cost? It cost three thousand taka.", "এই চামড়ার জ্যাকেটের দাম কত ছিল? এর দাম ছিল তিন হাজার টাকা।", "হাউ মাচ ডিড দিজ লেদার জ্যাকেট কস্ট? ইট কস্ট থ্রি থাউজেন্ড টাকা।")
]

part4 = {
    "id": "past-foundations-p4",
    "order": 4,
    "level": "A2",
    "title_bn": "সাধারণ অতীত কাল ও '-ed' উচ্চারণ মাস্টারক্লাস (Past Simple Actions)",
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
            "items": [make_item(i[0], i[1], i[2], i[3], category=i[4], phoneme_focus=i[5]) for i in p4_l9_ed]
        },
        {
            "id": "past-p4-l10",
            "order": 2,
            "title_bn": "অতীতের সমাপ্ত কাজ — 'Subject + V2' (Affirmative Past Simple)",
            "title_target": "Completed Past Actions (Subject + V2)",
            "intro_bn": "অতীতের কোনো নির্দিষ্ট সময়ে শেষ হওয়া কাজ বোঝাতে মূল Verb-এর Past form (V2) ব্যবহৃত হয়।",
            "structure": ["Subject + V2 (went, bought, cooked, arrived) + Time Expression"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in p4_l10_v2]
        },
        {
            "id": "past-p4-l11",
            "order": 3,
            "title_bn": "অতীতের না-বোধক বাক্য — 'Didn't + V1' (Negative Past Simple)",
            "title_target": "Negative Past Simple (Didn't + V1)",
            "intro_bn": "অতীতে কোনো কাজ করা হয়নি বোঝাতে 'did not' বা 'didn't' এবং এরপরে মূল Verb-এর Base form (V1) বসে। কখনোই didn't-এর পর V2 বসবে না!",
            "structure": ["Subject + didn't + Verb (Base form V1)"],
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type="assertive", polarity="negative") for i in p4_l11_didnt]
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
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type=i[4], polarity=i[5]) for i in p4_l12_trans]
        },
        {
            "id": "past-p4-l13",
            "order": 5,
            "title_bn": "সাধারণ প্রশ্নোত্তর — 'Did you + V1...?' (Past Simple Q&A Drills)",
            "title_target": "Past Questions & Answers (Did you + V1...?)",
            "intro_bn": "অতীতে কেউ কোনো কাজ করেছিল কি না জানতে 'Did + Subject + V1...?' দিয়ে প্রশ্ন করা হয়। হ্যাঁ-বোধক উত্তরে V2 এবং না-বোধক উত্তরে didn't + V1 ব্যবহৃত হয়।",
            "structure": ["Did + Subject + V1...? -> Yes, S + V2 / No, S + didn't + V1"],
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type="qa") for i in p4_l13_qa]
        },
        {
            "id": "past-p4-l14",
            "order": 6,
            "title_bn": "ডব্লিউএইচ অতীত প্রশ্নমালা ড্রিল (Past WH-Questions Drill)",
            "title_target": "Wh- Questions in the Past (Where, When, Why, How did you...)",
            "intro_bn": "অতীতে কী, কখন, কোথায়, কেন, কীভাবে ঘটেছিল তা জানতে Wh-words (What, When, Where, Why, How) এর সাথে 'did + Subject + V1' ব্যবহার করা হয়।",
            "structure": ["Wh-word + did + Subject + Verb (V1)...? -> Subject + V2..."],
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type="wh_question") for i in p4_l14_wh]
        }
    ]
}

# ==============================================================================
# PART 5: Past Continuous & Interrupted Actions (When / While)
# ==============================================================================
p5_l15 = [
    ("past-p5-l15-001", "She was cooking delicious dinner in the kitchen.", "সে রান্নাঘরে সুস্বাদু রাতের খাবার রান্না করছিল।", "শি ওয়াজ কুকিং ডেলিশাস ডিনার ইন দ্য কিচেন।"),
    ("past-p5-l15-002", "I was reading an interesting storybook at eight pm.", "রাত আটটায় আমি একটি মজার গল্পের বই পড়ছিলাম।", "আই ওয়াজ রিডিং অ্যান ইন্টারেস্টিং স্টোরিবুক অ্যাট এইট পিএম।"),
    ("past-p5-l15-003", "They were playing cricket in the open field all afternoon.", "তারা পুরো বিকেল জুড়ে উন্মুক্ত মাঠে ক্রিকেট খেলছিল।", "দে ওয়্যার প্লেয়িং ক্রিকেট ইন দি ওপেন ফিল্ড অল আফটারনুন।"),
    ("past-p5-l15-004", "He was preparing his final presentation slides last night.", "সে গত রাতে তার চূড়ান্ত প্রেজেন্টেশন স্লাইড তৈরি করছিল।", "হি ওয়াজ প্রিপেয়ারিং হিজ ফাইনাল প্রেজেন্টেশন স্লাইডস লাস্ট নাইট।"),
    ("past-p5-l15-005", "It was raining heavily when we stepped outside.", "আমরা যখন বাইরে পা রেখেছিলাম তখন মুষলধারে বৃষ্টি হচ্ছিল।", "ইট ওয়াজ রেইনিং হেভিলি হোয়েন উই স্টেপড আউটসাইড।"),
    ("past-p5-l15-006", "We were having lunch together at the restaurant.", "আমরা রেস্তোরাঁয় একসাথে দুপুরের খাবার খাচ্ছিলাম।", "উই ওয়্যার হ্যাভিং লাঞ্চ টুগেদার অ্যাট দ্য রেস্টুরেন্ট।"),
    ("past-p5-l15-007", "She was waiting for the city bus at the stoppage.", "সে বাস স্টপেজে শহরের বাসের জন্য অপেক্ষা করছিল।", "শি ওয়াজ ওয়েটিং ফর দ্য সিটি বাস অ্যাট দ্য স্টপেজ।"),
    ("past-p5-l15-008", "The children were sleeping peacefully in their bedroom.", "বাচ্চারা তাদের শোবার ঘরে শান্তভাবে ঘুমাচ্ছিল।", "দ্য চিলড্রেন ওয়্যার স্লিপিং পিসফুলি ইন দেয়ার বেডরুম।")
]

p5_l16 = [
    ("past-p5-l16-001", "She wasn't cooking when I arrived at her house.", "আমি যখন তার বাড়িতে পৌঁছাই তখন সে রান্না করছিল না।", "শি ওয়াজন্ট কুকিং হোয়েন আই অ্যারাইভড অ্যাট হার হাউজ।"),
    ("past-p5-l16-002", "I wasn't sleeping when you called me last night.", "গত রাতে তুমি যখন আমাকে ফোন করেছিলে তখন আমি ঘুমাচ্ছিলাম না।", "আই ওয়াজন্ট স্লিপিং হোয়েন ইউ কল্ড মি লাস্ট নাইট।"),
    ("past-p5-l16-003", "They weren't paying attention to the teacher's lecture.", "তারা শিক্ষকের বক্তব্যের দিকে মনোযোগ দিচ্ছিল না।", "দে ওয়্যারন্ট পেয়িং অ্যাটেনশন টু দ্য টিচার্স লেকচার।"),
    ("past-p5-l16-004", "He wasn't working on his computer yesterday evening.", "গতকাল সন্ধ্যায় সে কম্পিউটারে কাজ করছিল না।", "হি ওয়াজন্ট ওয়ার্কিং অন হিজ কম্পিউটার ইয়েস্টারডে ইভনিং।"),
    ("past-p5-l16-005", "It wasn't raining when we left the office building.", "আমরা যখন অফিস ভবন থেকে বের হই তখন বৃষ্টি হচ্ছিল না।", "ইট ওয়াজন্ট রেইনিং হোয়েন উই লেফট দি অফিস বিল্ডিং।"),
    ("past-p5-l16-006", "We weren't watching television at that exact moment.", "আমরা ঠিক সেই মুহূর্তে টেলিভিশন দেখছিলাম না।", "উই ওয়্যারন্ট ওয়াচিং টেলিভিশন অ্যাট দ্যাট এক্স্যাক্ট মোমেন্ট।"),
    ("past-p5-l16-007", "She wasn't driving the car when the accident occurred.", "দুর্ঘটনা ঘটার সময় সে গাড়ি চালাচ্ছিল না।", "শি ওয়াজন্ট ড্রাইভিং দ্য কার হোয়েন দি অ্যাক্সিডেন্ট অকার্ড।"),
    ("past-p5-l16-008", "They weren't arguing about anything serious.", "তারা গুরুতর কিছু নিয়ে তর্ক করছিল না।", "দে ওয়্যারন্ট আর্গুয়িং অ্যাবাউট অ্যানিথিং সিরিয়াস।")
]

p5_l17_when_while = [
    ("past-p5-l17-001", "I was reading a book when the phone suddenly rang.", "আমি একটি বই পড়ছিলাম যখন হঠাৎ ফোনটি বেজে উঠল।", "আই ওয়াজ রিডিং আ বুক হোয়েন দ্য ফোন সাডেনলি র‍্যাং।"),
    ("past-p5-l17-002", "While I was walking in the park, I found a leather wallet.", "পার্কে হাঁটার সময় আমি একটি চামড়ার মানিব্যাগ পেয়েছিলাম।", "হোয়াইল আই ওয়াজ ওয়াকিং ইন দ্য পার্ক, আই ফাউন্ড আ লেদার ওয়ালেট।"),
    ("past-p5-l17-003", "She was driving to work when her car broke down.", "সে গাড়িতে চড়ে অফিসে যাচ্ছিল যখন তার গাড়িটি বিকল হয়ে পড়েছিল।", "শি ওয়াজ ড্রাইভিং টু ওয়ার্ক হোয়েন হার কার ব্রোক ডাউন।"),
    ("past-p5-l17-004", "While we were having dinner, the electricity went out.", "আমরা যখন রাতের খাবার খাচ্ছিলাম, তখন বিদ্যুৎ চলে গিয়েছিল।", "হোয়াইল উই ওয়্যার হ্যাভিং ডিনার, দি ইলেকট্রিসিটি ওয়েন্ট আউট।"),
    ("past-p5-l17-005", "He was crossing the busy street when he saw his teacher.", "সে ব্যস্ত রাস্তা পার হচ্ছিল যখন সে তার শিক্ষককে দেখতে পেয়েছিল।", "হি ওয়াজ ক্রসিং দ্য বিজি স্ট্রিট হোয়েন হি স হিজ টিচার।"),
    ("past-p5-l17-006", "While she was cooking, she burned her hand slightly.", "রান্না করার সময় সে তার হাত সামান্য পুড়িয়ে ফেলেছিল।", "হোয়াইল শি ওয়াজ কুকিং, শি বার্নড হার হ্যান্ড স্লাইটলি।"),
    ("past-p5-l17-007", "They were watching a football match when the guests arrived.", "তারা ফুটবল ম্যাচ দেখছিল যখন অতিথিরা এসে পৌঁছেছিল।", "দে ওয়্যার ওয়াচিং আ ফুটবল ম্যাচ হোয়েন দ্য গেস্টস অ্যারাইভড।"),
    ("past-p5-l17-008", "What were you doing when the earthquake occurred?", "ভূমিকম্পটি ঘটার সময় আপনি কী করছিলেন?", "হোয়াট ওয়্যার ইউ ডুইং হোয়েন দি আর্থকোয়েক অকার্ড?")
]

p5_l18_trans = [
    ("past-p5-trans-001", "He was writing an email.", "সে একটি ইমেইল লিখছিল।", "হি ওয়াজ রাইটিং অ্যান ইমেইল।", "assertive", "affirmative"),
    ("past-p5-trans-002", "He wasn't writing an email.", "সে ইমেইল লিখছিল না।", "হি ওয়াজন্ট রাইটিং অ্যান ইমেইল।", "assertive", "negative"),
    ("past-p5-trans-003", "Was he writing an email?", "সে কি ইমেইল লিখছিল?", "ওয়াজ হি রাইটিং অ্যান ইমেইল?", "interrogative", "affirmative"),
    ("past-p5-trans-004", "Wasn't he writing an email?", "সে কি ইমেইল লিখছিল না?", "ওয়াজন্ট হি রাইটিং অ্যান ইমেইল?", "interrogative", "negative"),
    ("past-p5-trans-005", "What was he writing?", "সে কী লিখছিল?", "হোয়াট ওয়াজ হি রাইটিং?", "wh_question", "affirmative"),
    ("past-p5-trans-006", "Why wasn't he writing?", "সে কেন লিখছিল না?", "হোয়াই ওয়াজন্ট হি রাইটিং?", "wh_question", "negative")
]

p5_l19_qa = [
    ("past-p5-qa-001", "Was she cooking dinner when you came home? Yes, she was cooking. No, she wasn't cooking.", "তুমি বাসায় এলে সে কি রাতের খাবার রান্না করছিল? হ্যাঁ, সে রান্না করছিল। না, সে রান্না করছিল না।", "ওয়াজ শি কুকিং ডিনার হোয়েন ইউ কেইম হোম? ইয়েস, শি ওয়াজ কুকিং। নো, শি ওয়াজন্ট কুকিং।"),
    ("past-p5-qa-002", "Were you sleeping when I called you? Yes, I was sleeping. No, I was not sleeping.", "আমি যখন ফোন করেছিলাম আপনি কি ঘুমাচ্ছিলেন? হ্যাঁ, আমি ঘুমাচ্ছিলাম। না, আমি ঘুমাচ্ছিলাম না।", "ওয়্যার ইউ স্লিপিং হোয়েন আই কল্ড ইউ? ইয়েস, আই ওয়াজ স্লিপিং। নো, আই ওয়াজ নট স্লিপিং।"),
    ("past-p5-qa-003", "What were you doing yesterday at eight pm? I was preparing my office presentation.", "গতকাল রাত আটটায় আপনি কী করছিলেন? আমি আমার অফিসের প্রেজেন্টেশন তৈরি করছিলাম।", "হোয়াট ওয়্যার ইউ ডুইং ইয়েস্টারডে অ্যাট এইট পিএম? আই ওয়াজ প্রিপেয়ারিং মাই অফিস প্রেজেন্টেশন।"),
    ("past-p5-qa-004", "Were they waiting for you at the station? Yes, they were waiting for me.", "তারা কি স্টেশনে আপনার জন্য অপেক্ষা করছিল? হ্যাঁ, তারা আমার জন্য অপেক্ষা করছিল।", "ওয়্যার দে ওয়েটিং ফর ইউ অ্যাট দ্য স্টেশন? ইয়েস, দে ওয়্যার ওয়েটিং ফর মি।"),
    ("past-p5-qa-005", "Where were you going when I saw you yesterday? I was going to the supermarket.", "গতকাল যখন আপনাকে দেখলাম আপনি কোথায় যাচ্ছিলেন? আমি সুপারমার্কেটে যাচ্ছিলাম।", "হোয়ার ওয়্যার ইউ গোয়িং হোয়েন আই স ইউ ইয়েস্টারডে? আই ওয়াজ গোয়িং টু দ্য সুপারমার্কেট।"),
    ("past-p5-qa-006", "Was it raining heavily when you left the house? Yes, it was raining heavily.", "বাড়ি থেকে বের হওয়ার সময় কি মুষলধারে বৃষ্টি হচ্ছিল? হ্যাঁ, মুষলধারে বৃষ্টি হচ্ছিল।", "ওয়াজ ইট রেইনিং হেভিলি হোয়েন ইউ লেফট দ্য হাউজ? ইয়েস, ইট ওয়াজ রেইনিং হেভিলি।"),
    ("past-p5-qa-007", "Who were you talking to on the phone? I was talking to my elder brother.", "ফোনে আপনি কার সাথে কথা বলছিলেন? আমি আমার বড় ভাইয়ের সাথে কথা বলছিলাম।", "হু ওয়্যার ইউ টকিং টু অন দ্য ফোন? আই ওয়াজ টকিং টু মাই এল্ডার ব্রাদার।"),
    ("past-p5-qa-008", "Were you working late at the office yesterday? Yes, I was working until nine pm.", "গতকাল আপনি কি অফিসে দেরিতে কাজ করছিলেন? হ্যাঁ, আমি রাত নয়টা পর্যন্ত কাজ করছিলাম।", "ওয়্যার ইউ ওয়ার্কিং লেইট অ্যাট দি অফিস ইয়েস্টারডে? ইয়েস, আই ওয়াজ ওয়ার্কিং আনটিল নাইন পিএম।")
]

part5 = {
    "id": "past-foundations-p5",
    "order": 5,
    "level": "A2",
    "title_bn": "অতীত ঘটমান কাল ও বাধাগ্রস্ত কাজ (Past Continuous & When/While)",
    "title_target": "Past Continuous & 6-Type Interrupted Transformations",
    "lessons": [
        {
            "id": "past-p5-l15",
            "order": 1,
            "title_bn": "অতীতে চলমান কাজ — 'Was / Were + Verb-ING'",
            "title_target": "Ongoing Past Actions (Was / Were + Verb-ING)",
            "intro_bn": "অতীতের কোনো নির্দিষ্ট সময়ে কোনো কাজ কিছুক্ষণ ধরে চলছিল বোঝাতে Past Continuous Tense ব্যবহৃত হয়।",
            "structure": ["Subject + was / were + Verb-ING"],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_continuous") for i in p5_l15]
        },
        {
            "id": "past-p5-l16",
            "order": 2,
            "title_bn": "চলমান না-বোধক — 'Wasn't / Weren't + Verb-ING'",
            "title_target": "Negative Ongoing Past Actions",
            "intro_bn": "অতীতে কোনো নির্দিষ্ট সময়ে কাজ চলছিল না বোঝাতে 'was not' (wasn't) বা 'were not' (weren't) এবং Verb-ING বসে।",
            "structure": ["Subject + wasn't / weren't + Verb-ING"],
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type="assertive", polarity="negative", tense="past_continuous") for i in p5_l16]
        },
        {
            "id": "past-p5-l17",
            "order": 3,
            "title_bn": "'When' ও 'While' এর জাদুকরী সংযোগ (Interrupted Actions)",
            "title_target": "Interrupted Past Actions ('When' & 'While')",
            "intro_bn": "অতীতে একটি কাজ চলাকালে হঠাৎ অন্য একটি কাজ ঘটলে চলমান অংশটি Past Continuous এবং হঠাৎ ঘটা অংশটি Past Simple হয়।",
            "structure": [
                "Past Continuous + when + Past Simple",
                "While + Past Continuous + Past Simple"
            ],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_continuous") for i in p5_l17_when_while]
        },
        {
            "id": "past-p5-l18",
            "order": 4,
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
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type=i[4], polarity=i[5], tense="past_continuous") for i in p5_l18_trans]
        },
        {
            "id": "past-p5-l19",
            "order": 5,
            "title_bn": "অতীতের চলমান প্রশ্নোত্তর — 'Were you doing...?' (Continuous Q&A)",
            "title_target": "Past Continuous Questions & Answers",
            "intro_bn": "অতীতে কেউ কোনো কাজ করছিল কি না জানতে 'Was/Were + Subject + Verb-ING...?' দিয়ে প্রশ্ন করা হয়।",
            "structure": ["Was / Were + Subject + Verb-ING...?"],
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type="qa", tense="past_continuous") for i in p5_l19_qa]
        }
    ]
}

# ==============================================================================
# PART 6: Past Modals, Habits & Modal Tongue Twisters
# ==============================================================================
p6_l20_used_to = [
    ("past-p6-l20-001", "I used to play cricket every single afternoon in my school days.", "স্কুলজীবনে আমি প্রতিদিন বিকেলে ক্রিকেট খেলতাম।", "আই ইউজড টু প্লে ক্রিকেট এভরি সিঙ্গেল আফটারনুন ইন মাই স্কুল ডেইজ।"),
    ("past-p6-l20-002", "He used to live in Sylhet before moving to Dhaka.", "ঢাকায় আসার আগে তিনি সিলেটে বসবাস করতেন।", "হি ইউজড টু লিভ ইন সিলেট বিফোর মুভিং টু ঢাকা।"),
    ("past-p6-l20-003", "She used to wake up very early in the morning.", "তিনি খুব ভোরে ঘুম থেকে উঠতেন।", "শি ইউজড টু ওয়েক আপ ভেরি আর্লি ইন দ্য মর্নিং।"),
    ("past-p6-l20-004", "We used to swim in the village pond every summer.", "প্রতি গ্রীষ্মে আমরা গ্রামের পুকুরে সাঁতার কাটতাম।", "উই ইউজড টু সুইম ইন দ্য ভিলেজ পন্ড এভরি সামার।"),
    ("past-p6-l20-005", "They used to travel to Cox's Bazar every winter.", "প্রতি শীতে তারা কক্সবাজার ঘুরতে যেত।", "দে ইউজড টু ট্রাভেল টু কক্সবাজার এভরি উইন্টার।"),
    ("past-p6-l20-006", "I didn't use to like vegetables when I was a child.", "ছোটবেলায় আমি শাকসবজি পছন্দ করতাম না।", "আই ডিডন্ট ইউজ টু লাইক ভেজিটেবলস হোয়েন আই ওয়াজ আ চাইল্ড।"),
    ("past-p6-l20-007", "Did you use to practice English regularly? Yes, I used to practice every day.", "আপনি কি নিয়মিত ইংরেজি অনুশীলন করতেন? হ্যাঁ, আমি প্রতিদিন অনুশীলন করতাম।", "ডিড ইউ ইউজ টু প্র্যাকটিস ইংলিশ রেগুলারলি? ইয়েস, আই ইউজড টু প্র্যাকটিস এভরি ডে।"),
    ("past-p6-l20-008", "My grandfather used to walk five kilometers every morning.", "আমার দাদা প্রতিদিন সকালে পাঁচ কিলোমিটার হাঁটতেন।", "মাই গ্র্যান্ডফাদার ইউজড টু ওয়াক ফাইভ কিলোমিটার্স এভরি মর্নিং।")
]

p6_l21_had_to = [
    ("past-p6-l21-001", "I had to wake up at five in the morning yesterday.", "গতকাল সকালে আমাকে পাঁচটায় ঘুম থেকে উঠতে হয়েছিল।", "আই হ্যাড টু ওয়েক আপ অ্যাট ফাইভ ইন দ্য মর্নিং ইয়েস্টারডে।"),
    ("past-p6-l21-002", "He had to submit his report by noon.", "দুপুরের মধ্যে তাকে তার প্রতিবেদন জমা দিতে হয়েছিল।", "হি হ্যাড টু সাবমিট হিজ রিপোর্ট বাই নুন।"),
    ("past-p6-l21-003", "We had to cancel our family trip due to heavy rain.", "ভারী বৃষ্টির কারণে আমাদের পারিবারিক ভ্রমণ বাতিল করতে হয়েছিল।", "উই হ্যাড টু ক্যানসেল আওয়ার ফ্যামিলি ট্রিপ ডিউ টু হেভি রেইন।"),
    ("past-p6-l21-004", "She had to take medicine three times a day last week.", "গত সপ্তাহে তাকে দিনে তিনবার ওষুধ খেতে হয়েছিল।", "শি হ্যাড টু টেক মেডিসিন থ্রি টাইমস আ ডে লাস্ট উইক।"),
    ("past-p6-l21-005", "They had to wait for two hours at the train station.", "তাদের ট্রেন স্টেশনে দুই ঘণ্টা অপেক্ষা করতে হয়েছিল।", "দে হ্যাড টু ওয়েট ফর টু আওয়ার্স অ্যাট দ্য ট্রেন স্টেশন।"),
    ("past-p6-l21-006", "I didn't have to pay any extra fee for the service.", "এই সেবার জন্য আমাকে কোনো অতিরিক্ত ফি দিতে হয়নি।", "আই ডিডন্ট হ্যাভ টু পে অ্যানি এক্সট্রা ফি ফর দ্য সার্ভিস।"),
    ("past-p6-l21-007", "Did you have to work overtime yesterday? Yes, I had to work late. No, I didn't have to work late.", "গতকাল কি আপনাকে ওভারটাইম কাজ করতে হয়েছিল? হ্যাঁ, আমাকে রাত পর্যন্ত কাজ করতে হয়েছিল। না, করতে হয়নি।", "ডিড ইউ হ্যাভ টু ওয়ার্ক ওভারটাইম ইয়েস্টারডে? ইয়েস, আই হ্যাড টু ওয়ার্ক লেইট। নো, আই ডিডন্ট হ্যাভ টু ওয়ার্ক লেইট।"),
    ("past-p6-l21-008", "Why did you have to leave early? Because I had an urgent appointment.", "আপনাকে তাড়াতাড়ি চলে যেতে হয়েছিল কেন? কারণ আমার জরুরি অ্যাপয়েন্টমেন্ট ছিল।", "হোয়াই ডিড ইউ হ্যাভ টু লিভ আর্লি? বিকজ আই হ্যাড অ্যান আর্জেন্ট অ্যাপয়েন্টমেন্ট।")
]

p6_l22_wanted = [
    ("past-p6-l22-001", "I wanted to meet you yesterday, but I was extremely busy.", "আমি গতকাল আপনার সাথে দেখা করতে চেয়েছিলাম, কিন্তু আমি অত্যন্ত ব্যস্ত ছিলাম।", "আই ওয়ান্টেড টু মিট ইউ ইয়েস্টারডে, বাট আই ওয়াজ এক্সট্রিমলি বিজি।"),
    ("past-p6-l22-002", "He wanted to buy that laptop, but it was too expensive.", "সে সেই ল্যাপটপটি কিনতে চেয়েছিল, কিন্তু এটি খুব দামি ছিল।", "হি ওয়ান্টেড টু বাই দ্যাট ল্যাপটপ, বাট ইট ওয়াজ টু এক্সপেন্সিভ।"),
    ("past-p6-l22-003", "I needed to talk to my manager regarding the project.", "প্রজেক্টের ব্যাপারে আমার ম্যানেজারের সাথে কথা বলা প্রয়োজন ছিল।", "আই নিডেড টু টক টু মাই ম্যানেজার রিগার্ডিং দ্য প্রজেক্ট।"),
    ("past-p6-l22-004", "She needed to buy some emergency medicine last night.", "গত রাতে তার কিছু জরুরি ওষুধ কেনা দরকার ছিল।", "শি নিডেড টু বাই সাম ইমার্জেন্সি মেডিসিন লাস্ট নাইট।"),
    ("past-p6-l22-005", "They didn't want to disclose the confidential information.", "তারা গোপনীয় তথ্য প্রকাশ করতে চায়নি।", "দে ডিডন্ট ওয়ান্ট টু ডিসক্লোজ দ্য কনফিডেনশিয়াল ইনফরমেশন।"),
    ("past-p6-l22-006", "We didn't need to hire a taxi because my brother picked us up.", "আমাদের ট্যাক্সি ভাড়া করার প্রয়োজন হয়নি কারণ আমার ভাই আমাদের নিতে এসেছিল।", "উই ডিডন্ট নিড টু হায়ার আ ট্যাক্সি বিকজ মাই ব্রাদার পিক্ট আস আপ।"),
    ("past-p6-l22-007", "What did you want to say to me? I wanted to thank you for your help.", "আপনি আমাকে কী বলতে চেয়েছিলেন? আমি আপনার সাহায্যের জন্য ধন্যবাদ জানাতে চেয়েছিলাম।", "হোয়াট ডিড ইউ ওয়ান্ট টু সে টু মি? আই ওয়ান্টেড টু থ্যাংক ইউ ফর ইয়োর হেল্প।"),
    ("past-p6-l22-008", "Did you need any help yesterday? No, I managed everything myself.", "গতকাল আপনার কি কোনো সাহায্যের দরকার ছিল? না, আমি নিজেই সব সামলে নিয়েছি।", "ডিড ইউ নিড অ্যানি হেল্প ইয়েস্টারডে? নো, আই ম্যানেজড এভরিথিং মাইসেলফ।")
]

p6_l23_could = [
    ("past-p6-l23-001", "I could swim very fast when I was younger.", "আমি যখন ছোট ছিলাম তখন খুব দ্রুত সাঁতার কাটতে পারতাম।", "আই কুড সুইম ভেরি ফাস্ট হোয়েন আই ওয়াজ ইয়ঙ্গার।"),
    ("past-p6-l23-002", "She could speak three foreign languages fluently.", "তিনি সাবলীলভাবে তিনটি বিদেশি ভাষায় কথা বলতে পারতেন।", "শি কুড স্পিক থ্রি ফরেন ল্যাঙ্গুয়েজেস ফ্লুয়েন্টলি।"),
    ("past-p6-l23-003", "I couldn't attend the meeting because of a traffic jam.", "ট্রাফিক জ্যামের কারণে আমি সভায় উপস্থিত হতে পারিনি।", "আই কুডন্ট অ্যাটেন্ড দ্য মিটিং বিকজ অব আ ট্রাফিক জ্যাম।"),
    ("past-p6-l23-004", "He couldn't sleep well last night due to loud noise.", "প্রচণ্ড শব্দের কারণে গত রাতে তিনি ভালো ঘুমাতে পারেননি।", "হি কুডন্ট স্লিপ ওয়েল লাস্ট নাইট ডিউ টু লাউড নয়েজ।"),
    ("past-p6-l23-005", "We couldn't find your address easily yesterday.", "গতকাল আমরা সহজেই আপনার ঠিকানা খুঁজে পাইনি।", "উই কুডন্ট ফাইন্ড ইয়োর অ্যাড্রেস ইজিলি ইয়েস্টারডে।"),
    ("past-p6-l23-006", "Could you hear my voice clearly on the call? Yes, I could hear you clearly. No, I couldn't hear you.", "ফোনে কি আপনি আমার কণ্ঠ স্পষ্টভাবে শুনতে পেরেছিলেন? হ্যাঁ, পরিষ্কার শুনতে পেরেছিলাম। না, শুনতে পারিনি।", "কুড ইউ হেয়ার মাই ভয়েস ক্লিয়ারলি অন দ্য কল? ইয়েস, আই কুড হেয়ার ইউ ক্লিয়ারলি। নো, আই কুডন্ট হেয়ার ইউ।"),
    ("past-p6-l23-007", "They couldn't finish the construction work on time.", "তারা সময়মতো নির্মাণ কাজ শেষ করতে পারেনি।", "দে কুডন্ট ফিনিশ দ্য কনস্ট্রাকশন ওয়ার্ক অন টাইম।"),
    ("past-p6-l23-008", "Could you understand what he said in the lecture? Yes, I could understand everything.", "লেকচারে তিনি কী বলেছিলেন তা কি আপনি বুঝতে পেরেছিলেন? হ্যাঁ, আমি সবকিছু বুঝতে পেরেছিলাম।", "কুড ইউ আন্ডারস্ট্যান্ড হোয়াট হি সেইড ইন দ্য লেকচার? ইয়েস, আই কুড আন্ডারস্ট্যান্ড এভরিথিং।")
]

p6_l24_twisters = [
    ("past-p6-twister-001", "How much wood would a woodchuck chuck if a woodchuck could chuck wood?", "যদি উডচাক কাঠ ফেলতে পারত, তবে সে কতটা কাঠ ফেলত?", "হাউ মাচ উড উড আ উডচাক চাক ইফ আ উডচাক কুড চাক উড?", "/w/ and modal could/would"),
    ("past-p6-twister-002", "Peter Piper picked a peck of pickled peppers that he needed.", "পিটার পাইপার এক খাঁচি আচারযুক্ত মরিচ তুলেছিল যা তার প্রয়োজন ছিল।", "পিটার পাইপার পিক্ট আ পেক অব পিকল্ড পেপার্স দ্যাট হি নিডেড।", "/p/ and past needed"),
    ("past-p6-twister-003", "I wish I could wish the wish that you wished yesterday.", "আমি যদি সেই ইচ্ছাটি করতে পারতাম যা আপনি গতকাল করেছিলেন।", "আই উইশ আই কুড উইশ দ্য উইশ দ্যাট ইউ উইশড ইয়েস্টারডে।", "/w/ and past wished")
]

part6 = {
    "id": "past-foundations-p6",
    "order": 6,
    "level": "A2",
    "title_bn": "অতীতের ইচ্ছা, সামর্থ্য, অভ্যাস ও মোডাল টাং টুইস্টার",
    "title_target": "Past Modals, Habits & Pronunciation Twisters",
    "lessons": [
        {
            "id": "past-p6-l20",
            "order": 1,
            "title_bn": "অতীতের নিয়মিত অভ্যাস — 'Used to + V1'",
            "title_target": "Past Habits (Used to + Verb V1)",
            "intro_bn": "অতীতে নিয়মিত কোনো কাজ করা হতো কিন্তু বর্তমানে আর করা হয় না এমন অভ্যাস বোঝাতে 'used to + Verb (V1)' বসে।",
            "structure": ["Subject + used to + Verb (Base form V1)"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in p6_l20_used_to]
        },
        {
            "id": "past-p6-l21",
            "order": 2,
            "title_bn": "অতীতের বাধ্যবাধকতা — 'Had to + V1'",
            "title_target": "Past Obligations (Had to + Verb V1)",
            "intro_bn": "অতীতে কোনো কিছু করতে হয়েছিল বা বাধ্যবাধকতা ছিল বোঝাতে 'had to + Verb (V1)' বসে। না-বোধকে 'didn't have to' বসে।",
            "structure": ["Subject + had to + Verb (V1) / didn't have to + V1"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in p6_l21_had_to]
        },
        {
            "id": "past-p6-l22",
            "order": 3,
            "title_bn": "অতীতের ইচ্ছা ও প্রয়োজন — 'Wanted to' ও 'Needed to'",
            "title_target": "Past Desires & Needs (Wanted to & Needed to)",
            "intro_bn": "অতীতে কিছু করার ইচ্ছা ছিল বোঝাতে 'wanted to' এবং দরকার বা প্রয়োজন ছিল বোঝাতে 'needed to' বসে।",
            "structure": ["Subject + wanted to / needed to + Verb (V1)"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in p6_l22_wanted]
        },
        {
            "id": "past-p6-l23",
            "order": 4,
            "title_bn": "অতীতের সামর্থ্য — 'Could / Couldn't'",
            "title_target": "Past Ability (Could / Couldn't + V1)",
            "intro_bn": "অতীতে কোনো কাজ করার সামর্থ্য ছিল ('পারতাম') বোঝাতে 'could' এবং পারতাম না বোঝাতে 'couldn't' বসে।",
            "structure": ["Subject + could / couldn't + Verb (V1)"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in p6_l23_could]
        },
        {
            "id": "past-p6-l24",
            "order": 5,
            "badge": "Very Important for Spoken English",
            "badge_bn": "স্পোকেন ইংলিশের জন্য অতি গুরুত্বপূর্ণ",
            "title_bn": "মোডাল ও অতীতের ৩টি টাং টুইস্টার ড্রিল",
            "title_target": "Modal Tongue Twisters for Fluency",
            "intro_bn": "মোডাল ও অতীতের ক্রিয়াপদ মুখে দ্রুত আনার জন্য এই ৩টি টাং টুইস্টার স্পিড ড্রিল করুন।",
            "structure": ["Slow Pace -> Natural Pace -> 3 Times Fast"],
            "items": [make_item(i[0], i[1], i[2], i[3], category="tongue_twister", phoneme_focus=i[4]) for i in p6_l24_twisters]
        }
    ]
}

# ==============================================================================
# PART 7: Past Perfect Tense & 6-Pattern Transformation
# ==============================================================================
p7_l25 = [
    ("past-p7-l25-001", "She had done her homework before I came to visit her.", "আমি তার সাথে দেখা করতে আসার আগেই সে বাড়ির কাজ শেষ করেছিল।", "শি হ্যাড ডান হার হোমওয়ার্ক বিফোর আই কেইম টু ভিজিট হার।"),
    ("past-p7-l25-002", "The train had already left when we reached the platform.", "আমরা যখন প্ল্যাটফর্মে পৌঁছাই তখন ট্রেনটি ইতিমধ্যেই ছেড়ে গিয়েছিল।", "দ্য ট্রেন হ্যাড অলরেডি লেফট হোয়েন উই রীচড দ্য প্ল্যাটফর্ম।"),
    ("past-p7-l25-003", "I had finished my dinner before eight o'clock yesterday.", "গতকাল রাত আটটার আগেই আমি আমার রাতের খাবার শেষ করেছিলাম।", "আই হ্যাড ফিনিশড মাই ডিনার বিফোর এইট ও'ক্লক ইয়েস্টারডে।"),
    ("past-p7-l25-004", "They had sold their house before moving to another country.", "অন্য দেশে যাওয়ার আগেই তারা তাদের বাড়ি বিক্রি করে দিয়েছিল।", "দে হ্যাড সোল্ড দেয়ার হাউজ বিফোর মুভিং টু অ্যানাদার কান্ট্রি।"),
    ("past-p7-l25-005", "He had already informed the manager before submitting the leave letter.", "ছুটির দরখাস্ত জমা দেওয়ার আগেই তিনি ম্যানেজারকে জানিয়েছিলেন।", "হি হ্যাড অলরেডি ইনফর্মড দ্য ম্যানেজার বিফোর সাবমিটিং দ্য লিভ লেটার।"),
    ("past-p7-l25-006", "We had completed our project before the deadline arrived.", "সময়সীমা আসার আগেই আমরা আমাদের প্রজেক্ট সম্পন্ন করেছিলাম।", "উই হ্যাড কমপ্লিটেড আওয়ার প্রজেক্ট বিফোর দ্য ডেডলাইন অ্যারাইভড।"),
    ("past-p7-l25-007", "Had she done her homework before you arrived? Yes, she had already done it. No, she hadn't done it.", "তুমি আসার আগেই কি সে বাড়ির কাজ শেষ করেছিল? হ্যাঁ, সে আগেই শেষ করেছিল। না, সে করেনি।", "হ্যাড শি ডান হার হোমওয়ার্ক বিফোর ইউ অ্যারাইভড? ইয়েস, শি হ্যাড অলরেডি ডান ইট। নো, শি হ্যাডন্ট ডান ইট।"),
    ("past-p7-l25-008", "The patient had recovered before the specialist doctor arrived.", "বিশেষজ্ঞ চিকিৎসক আসার আগেই রোগী সুস্থ হয়ে উঠেছিল।", "দ্য পেশেন্ট হ্যাড রিকভার্ড বিফোর দ্য স্পেশালিস্ট ডক্টর অ্যারাইভড।")
]

p7_l26 = [
    ("past-p7-l26-001", "The movie had started before we entered the hall.", "আমরা হলে প্রবেশের পূর্বেই সিনেমা শুরু হয়ে গিয়েছিল।", "দ্য মুভি হ্যাড স্টার্টেড বিফোর উই এন্টার্ড দ্য হল।"),
    ("past-p7-l26-002", "We entered the cinema hall after the movie had started.", "সিনেমা শুরু হওয়ার পর আমরা সিনেমা হলে প্রবেশ করেছিলাম।", "উই এন্টার্ড দ্য সিনেমা হল আফটার দ্য মুভি হ্যাড স্টার্টেড।"),
    ("past-p7-l26-003", "I had locked all the doors before I went to bed.", "ঘুমাতে যাওয়ার আগেই আমি সব দরজা তালা দিয়েছিলাম।", "আই হ্যাড লকড অল দ্য ডোরস বিফোর আই ওয়েন্ট টু বেড।"),
    ("past-p7-l26-004", "He called me after he had reached the hotel.", "হোটেলে পৌঁছানোর পর সে আমাকে ফোন করেছিল।", "হি কল্ড মি আফটার হি হ্যাড রীচড দ্য হোটেল।"),
    ("past-p7-l26-005", "She had prepared breakfast before everyone woke up.", "সবার ঘুম ভাঙার আগেই সে সকালের নাস্তা তৈরি করেছিল।", "শি হ্যাড প্রিপেয়ার্ড ব্রেকফাস্ট বিফোর এভরিওয়ান ওক আপ।"),
    ("past-p7-l26-006", "They departed after the rain had stopped.", "বৃষ্টি থামার পর তারা রওনা হয়েছিল।", "দে ডিপার্টেড আফটার দ্য রেইন হ্যাড স্টপড।"),
    ("past-p7-l26-007", "I had never seen him before that memorable conference.", "সেই স্মরণীয় সম্মেলনের আগে আমি তাকে কখনো দেখিনি।", "আই হ্যাড নেভার সিন হিম বিফোর দ্যাট মেমোরেবল কনফারেন্স।"),
    ("past-p7-l26-008", "She went home after she had completed her duty.", "দায়িত্ব শেষ করার পর সে বাড়ি গিয়েছিল।", "শি ওয়েন্ট হোম আফটার শি হ্যাড কমপ্লিটেড হার ডিউটি।")
]

p7_l27 = [
    ("past-p7-l27-001", "By the time he arrived, the meeting had already ended.", "তিনি পৌঁছানোর আগেই সভা শেষ হয়ে গিয়েছিল।", "বাই দ্য টাইম হি অ্যারাইভড, দ্য মিটিং হ্যাড অলরেডি এন্ডেড।"),
    ("past-p7-l27-002", "By the time the police came, the thieves had fled.", "পুলিশ আসার আগেই চোরেরা পালিয়ে গিয়েছিল।", "বাই দ্য টাইম দ্য পুলিশ কেইম, দ্য থিভস হ্যাড ফ্লেড।"),
    ("past-p7-l27-003", "I had never tasted such authentic cuisine before that trip.", "সেই ভ্রমণের আগে আমি কখনো এমন আসল খাবার খাইনি।", "আই হ্যাড নেভার টেস্টেড সাচ অথেনটিক ক্যুইজিন বিফোর দ্যাট ট্রিপ।"),
    ("past-p7-l27-004", "By the time she called me, I had already fixed the bug.", "তিনি আমাকে ফোন করার আগেই আমি বাগটি ঠিক করে ফেলেছিলাম।", "বাই দ্য টাইম শি কল্ড মি, আই হ্যাড অলরেডি ফিক্সড দ্য বাগ।"),
    ("past-p7-l27-005", "She had never flown in an airplane before last year.", "গত বছরের আগে তিনি কখনো বিমানে ওঠেননি।", "শি হ্যাড নেভার ফ্লোন ইন অ্যান এয়ারপ্লেন বিফোর লাস্ট ইয়ার।"),
    ("past-p7-l27-006", "By midnight, all the invited guests had departed safely.", "মধ্যরাতের মধ্যে সকল আমন্ত্রিত অতিথি নিরাপদে প্রস্থান করেছিলেন।", "বাই মিডনাইট, অল দি ইনভাইটেড গেস্টস হ্যাড ডিপার্টেড সেফলি।"),
    ("past-p7-l27-007", "Had you visited the city before moving there? Yes, I had visited it once.", "সেখানে বসবাসের আগে আপনি কি শহরটি ঘুরে দেখেছিলেন? হ্যাঁ, আমি একবার দেখেছিলাম।", "হ্যাড ইউ ভিজিটেড দ্য সিটি বিফোর মুভিং দেয়ার? ইয়েস, আই হ্যাড ভিজিটেড ইট ওয়ান্স।"),
    ("past-p7-l27-008", "By the time we got the tickets, the show had started.", "আমরা টিকিট পাওয়ার আগেই প্রদর্শনী শুরু হয়ে গিয়েছিল।", "বাই দ্য টাইম উই গট দ্য টিকেটস, দ্য শো হ্যাড স্টার্টেড।")
]

p7_l28_trans = [
    ("past-p7-trans-001", "She had finished before noon.", "দুপুরের আগেই সে শেষ করেছিল।", "শি হ্যাড ফিনিশড বিফোর নুন।", "assertive", "affirmative"),
    ("past-p7-trans-002", "She hadn't finished before noon.", "দুপুরের আগে সে শেষ করেনি।", "শি হ্যাডন্ট ফিনিশড বিফোর নুন।", "assertive", "negative"),
    ("past-p7-trans-003", "Had she finished before noon?", "সে কি দুপুরের আগে শেষ করেছিল?", "হ্যাড শি ফিনিশড বিফোর নুন?", "interrogative", "affirmative"),
    ("past-p7-trans-004", "Hadn't she finished before noon?", "সে কি দুপুরের আগে শেষ করেনি?", "হ্যাডন্ট শি ফিনিশড বিফোর নুন?", "interrogative", "negative"),
    ("past-p7-trans-005", "What had she finished before noon?", "দুপুরের আগে সে কী শেষ করেছিল?", "হোয়াট হ্যাড শি ফিনিশড বিফোর নুন?", "wh_question", "affirmative"),
    ("past-p7-trans-006", "Why hadn't she finished before noon?", "দুপুরের আগে কেন সে শেষ করেনি?", "হোয়াই হ্যাডন্ট শি ফিনিশড বিফোর নুন?", "wh_question", "negative")
]

part7 = {
    "id": "past-foundations-p7",
    "order": 7,
    "level": "B1",
    "title_bn": "পুরাঘটিত অতীত কাল ও ৬ রূপান্তর (Past Perfect: Had + V3)",
    "title_target": "Past Perfect & 6-Type Before/After Transformations",
    "lessons": [
        {
            "id": "past-p7-l25",
            "order": 1,
            "title_bn": "দুটি অতীত কাজের পূর্ববর্তী কাজ — 'Had + V3'",
            "title_target": "Earlier Past Action (Subject + Had + V3)",
            "intro_bn": "অতীতে দুটি কাজ ঘটে থাকলে তাদের মধ্যে অপেক্ষাকৃত পূর্ববর্তী কাজটি Past Perfect (had + V3) এবং পরবর্তী কাজটি Past Simple (V2) হয়।",
            "structure": ["Earlier Action: Subject + had + V3"],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_perfect") for i in p7_l25]
        },
        {
            "id": "past-p7-l26",
            "order": 2,
            "title_bn": "'Before' ও 'After' এর গোল্ডেন রুলস",
            "title_target": "Rules of 'Before' & 'After'",
            "intro_bn": "গোল্ডেন রুল: Before এর পূর্বে এবং After এর পরে Past Perfect (had + V3) বসে।",
            "structure": [
                "Past Perfect + BEFORE + Past Simple",
                "Past Simple + AFTER + Past Perfect"
            ],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_perfect") for i in p7_l26]
        },
        {
            "id": "past-p7-l27",
            "order": 3,
            "title_bn": "'By the time' ও অতীতের অভিজ্ঞতা (Past Perfect)",
            "title_target": "Past Perfect with 'By the time' & Prior Experiences",
            "intro_bn": "অতীতে নির্দিষ্ট সময়ের মধ্যে কাজ শেষ হয়েছিল বোঝাতে 'by the time' এবং অভিজ্ঞতা প্রকাশে 'had never / had already' বসে।",
            "structure": ["By the time + Past Simple, S + had + V3"],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_perfect") for i in p7_l27]
        },
        {
            "id": "past-p7-l28",
            "order": 4,
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
            "items": [make_item(i[0], i[1], i[2], i[3], sentence_type=i[4], polarity=i[5], tense="past_perfect") for i in p7_l28_trans]
        }
    ]
}

# ==============================================================================
# PART 8: Past Perfect Continuous (Had been + Verb-ING)
# ==============================================================================
p8_l29 = [
    ("past-p8-l29-001", "She had been cooking in the kitchen for hours when I came home.", "আমি যখন বাড়ি আসি তখন সে কয়েক ঘণ্টা ধরে রান্নাঘরে রান্না করছিল।", "শি হ্যাড বিন কুকিং ইন দ্য কিচেন ফর আওয়ার্স হোয়েন আই কেইম হোম।"),
    ("past-p8-l29-002", "He had been waiting for the bus for forty minutes before it finally arrived.", "বাস আসার আগে সে চল্লিশ মিনিট ধরে অপেক্ষা করছিল।", "হি হ্যাড বিন ওয়েটিং ফর দ্য বাস ফর ফোরটি মিনিট্স বিফোর ইট ফাইনালি অ্যারাইভড।"),
    ("past-p8-l29-003", "They had been working on the software for six months before launching it.", "সফটওয়্যারটি লঞ্চ করার আগে তারা ছয় মাস ধরে এটিতে কাজ করছিল।", "দে হ্যাড বিন ওয়ার্কিং অন দ্য সফটওয়্যার ফর সিক্স মান্থস বিফোর লঞ্চিং ইট।"),
    ("past-p8-l29-004", "It had been raining continuously since morning before the sun broke through.", "সূর্য ওঠার আগে সকাল থেকেই একটানা বৃষ্টি হচ্ছিল।", "ইট হ্যাড বিন রেইনিং কন্টিনিউয়াসলি সিন্স মর্নিং বিফোর দ্য সান ব্রোক থ্রু।"),
    ("past-p8-l29-005", "Had she been cooking for hours when you came home? Yes, she had been cooking. No, she hadn't.", "তুমি বাড়ি এলে সে কি কয়েক ঘণ্টা ধরে রান্না করছিল? হ্যাঁ, সে রান্না করছিল। না, করছিল না।", "হ্যাড শি বিন কুকিং ফর আওয়ার্স হোয়েন ইউ কেইম হোম? ইয়েস, শি হ্যাড বিন কুকিং। নো, শি হ্যাডন্ট।"),
    ("past-p8-l29-006", "I had been living in that apartment for three years before I moved to Dhanmondi.", "ধানমন্ডিতে যাওয়ার আগে আমি তিন বছর ওই অ্যাপার্টমেন্টে থাকছিলাম।", "আই হ্যাড বিন লিভিং ইন দ্যাট অ্যাপার্টমেন্ট ফর থ্রি ইয়ার্স বিফোর আই মুভড টু ধানমন্ডি।"),
    ("past-p8-l29-007", "How long had you been studying before taking the break? I had been studying for three hours.", "বিরতি নেওয়ার আগে আপনি কতক্ষণ ধরে পড়ছিলেন? আমি তিন ঘণ্টা ধরে পড়ছিলাম।", "হাউ লং হ্যাড ইউ বিন স্টাডিয়িং বিফোর টেকিং দ্য ব্রেক? আই হ্যাড বিন স্টাডিয়িং ফর থ্রি আওয়ার্স।"),
    ("past-p8-l29-008", "His eyes were red because he had been staring at the computer screen all day.", "তার চোখ লাল ছিল কারণ সে সারাদিন কম্পিউটার স্ক্রিনের দিকে তাকিয়ে ছিল।", "হিজ আইজ ওয়্যার রেড বিকজ হি হ্যাড বিন স্টেয়ারিং অ্যাট দ্য কম্পিউটার স্ক্রিন অল ডে।")
]

p8_l30 = [
    ("past-p8-l30-001", "She was out of breath because she had been running fast.", "সে হাঁপাচ্ছিল কারণ সে দ্রুত দৌড়াচ্ছিল।", "শি ওয়াজ আউট অব ব্রেথ বিকজ শি হ্যাড বিন রানিং ফাস্ট।"),
    ("past-p8-l30-002", "The ground was completely wet because it had been raining heavily.", "মাটি পুরোপুরি ভেজা ছিল কারণ ভারী বৃষ্টি হচ্ছিল।", "দ্য গ্রাউন্ড ওয়াজ কমপ্লিটলি ওয়েট বিকজ ইট হ্যাড বিন রেইনিং হেভিলি।"),
    ("past-p8-l30-003", "They were exhausted because they had been travelling since morning.", "তারা ক্লান্ত ছিল কারণ তারা সকাল থেকে ভ্রমণ করছিল।", "দে ওয়্যার এক্সহস্টেড বিকজ দে হ্যাড বিন ট্রাভেলিং সিন্স মর্নিং।"),
    ("past-p8-l30-004", "He failed the test because he hadn't been attending classes regularly.", "সে পরীক্ষায় অকৃতকার্য হয়েছিল কারণ সে নিয়মিত ক্লাসে উপস্থিত হচ্ছিল না।", "হি ফেইল্ড দ্য টেস্ট বিকজ হি হ্যাডন্ট বিন অ্যাটেন্ডিং ক্লাসেস রেগুলারলি।")
]

part8 = {
    "id": "past-foundations-p8",
    "order": 8,
    "level": "B1",
    "title_bn": "পুরাঘটিত ঘটমান অতীত কাল (Past Perfect Continuous Tense)",
    "title_target": "Past Perfect Continuous (Had been + Verb-ING)",
    "lessons": [
        {
            "id": "past-p8-l29",
            "order": 1,
            "title_bn": "নির্দিষ্ট সময় ধরে চলা অতীত কাজ — 'Had been + Verb-ING'",
            "title_target": "Duration Before Past Event (Had been + Verb-ING)",
            "intro_bn": "অতীতে কোনো কাজ বিশেষ কোনো সময়ের পূর্ব হতে আরম্ভ হয়ে সেই সময় পর্যন্ত চলছিল বোঝালে Past Perfect Continuous Tense হয়।",
            "structure": ["Subject + had been + Verb-ING + for / since"],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_perfect_continuous") for i in p8_l29]
        },
        {
            "id": "past-p8-l30",
            "order": 2,
            "title_bn": "অতীত কারণ ও ফলাফল বিশ্লেষণ (Past Cause & Effect)",
            "title_target": "Past Cause & Effect Analysis",
            "intro_bn": "অতীতে কোনো শারীরিক অবস্থা বা ফলাফলের কারণ দীর্ঘস্থায়ী কোনো কাজের ফল হিসেবে প্রকাশ করতে Past Perfect Continuous বসে।",
            "structure": ["Past Simple (State) + because + S + had been + Verb-ING"],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_perfect_continuous") for i in p8_l30]
        }
    ]
}

# ==============================================================================
# PART 9: Past Passive Voice
# ==============================================================================
p9_l31 = [
    ("past-p9-l31-001", "Parents were sent there safely.", "বাবা-মাকে সেখানে নিরাপদে পাঠানো হয়েছিল।", "প্যারেন্টস ওয়্যার সেন্ট দেয়ার সেফলি।"),
    ("past-p9-l31-002", "He was given an honorable award for his outstanding work.", "অসামান্য কাজের জন্য তাকে একটি সম্মানজনক পুরস্কার দেওয়া হয়েছিল।", "হি ওয়াজ গিভেন অ্যান অনারেবল অ্যাওয়ার্ড ফর হিজ আউটস্ট্যান্ডিং ওয়ার্ক।"),
    ("past-p9-l31-003", "The historic bridge was built over fifty years ago.", "ঐতিহাসিক সেতুটি পঞ্চাশ বছরেরও বেশি সময় আগে নির্মিত হয়েছিল।", "দ্য হিস্টোরিক ব্রিজ ওয়াজ বিল্ট ওভার ফিফটি ইয়ার্স এগো।"),
    ("past-p9-l31-004", "The official email was sent to all team members yesterday.", "গতকাল সকল দলের সদস্যকে অফিশিয়াল ইমেইল পাঠানো হয়েছিল।", "দি অফিশিয়াল ইমেইল ওয়াজ সেন্ট টু অল টিম মেম্বার্স ইয়েস্টারডে।"),
    ("past-p9-l31-005", "The stolen laptop was recovered by the local police.", "চুরি যাওয়া ল্যাপটপটি স্থানীয় পুলিশ উদ্ধার করেছিল।", "দ্য স্টোলেন ল্যাপটপ ওয়াজ রিকভার্ড বাই দ্য লোকাল পুলিশ।"),
    ("past-p9-l31-006", "All our questions were answered clearly by the speaker.", "বক্তা আমাদের সকল প্রশ্নের পরিষ্কার উত্তর দিয়েছিলেন।", "অল আওয়ার কোয়েশ্চেনস ওয়্যার অ্যানসার্ড ক্লিয়ারলি বাই দ্য স্পিকার।"),
    ("past-p9-l31-007", "Was the important message delivered on time? Yes, it was delivered on time.", "জরুরি বার্তাটি কি সময়মতো পৌঁছে দেওয়া হয়েছিল? হ্যাঁ, সময়মতো পৌঁছে দেওয়া হয়েছিল।", "ওয়াজ দি ইম্পরট্যান্ট মেসেজ ডেলিভার্ড অন টাইম? ইয়েস, ইট ওয়াজ ডেলিভার্ড অন টাইম।"),
    ("past-p9-l31-008", "Where was this classical song composed? It was composed in Chittagong.", "এই কালজয়ী গানটি কোথায় সুর করা হয়েছিল? এটি চট্টগ্রামে সুর করা হয়েছিল।", "হোয়ার ওয়াজ দিজ ক্লাসিক্যাল সং কম্পোজড? ইট ওয়াজ কম্পোজড ইন চিটাগং।")
]

p9_l32 = [
    ("past-p9-l32-001", "The damaged car was being repaired at the workshop.", "ওয়ার্কশপে ক্ষতিগ্রস্ত গাড়িটি মেরামত করা হচ্ছিল।", "দ্য ড্যামেজড কার ওয়াজ বিয়িং রিপেয়ার্ড অ্যাট দ্য ওয়ার্কশপ।"),
    ("past-p9-l32-002", "A new highway was being constructed across the district.", "জেলাভিত্তিক একটি নতুন মহাসড়ক নির্মাণ করা হচ্ছিল।", "আ নিউ হাইওয়ে ওয়াজ বিয়িং কনস্ট্রাক্টেড অ্যাক্রস দ্য ডিস্ট্রিক্ট।"),
    ("past-p9-l32-003", "Delicious dinner was being prepared for all the visitors.", "সকল দর্শনার্থীদের জন্য সুস্বাদু রাতের খাবার তৈরি করা হচ্ছিল।", "ডেলিশাস ডিনার ওয়াজ বিয়িং প্রিপেয়ার্ড ফর অল দ্য ভিজিটরস।"),
    ("past-p9-l32-004", "The criminal suspects were being tracked carefully by the cyber police.", "সাইবার পুলিশ সন্দেহভাজন অপরাধীদের অত্যন্ত সতর্কতার সাথে ট্র্যাক করছিল।", "দ্য ক্রিমিনাল সাসপেক্টস ওয়্যার বিয়িং ট্র্যাক্ট কেয়ারফুলি বাই দ্য সাইবার পুলিশ।"),
    ("past-p9-l32-005", "The official documents were being verified by the embassy.", "দূতাবাস কর্তৃক অফিশিয়াল কাগজপত্র যাচাই করা হচ্ছিল।", "দি অফিশিয়াল ডকুমেন্টস ওয়্যার বিয়িং ভেরিফাইড বাই দি অ্যাম্বাসি।"),
    ("past-p9-l32-006", "The old building was being painted white yesterday.", "গতকাল পুরানো ভবনটি সাদা রঙ করা হচ্ছিল।", "দি ওল্ড বিল্ডিং ওয়াজ বিয়িং পেইন্টেড হোয়াইট ইয়েস্টারডে।"),
    ("past-p9-l32-007", "Was the issue being discussed in the board meeting? Yes, it was being discussed actively.", "বোর্ড সভায় কি বিষয়টি নিয়ে আলোচনা করা হচ্ছিল? হ্যাঁ, সক্রিয়ভাবে আলোচনা করা হচ্ছিল।", "ওয়াজ দি ইস্যু বিয়িং ডিসকাসড ইন দ্য বোর্ড মিটিং? ইয়েস, ইট ওয়াজ বিয়িং ডিসকাসড অ্যাক্টিভলি।"),
    ("past-p9-l32-008", "Many trees were being planted along the main road.", "প্রধান সড়কের পাশে অনেক গাছ লাগানো হচ্ছিল।", "মেনি ট্রিজ ওয়্যার বিয়িং প্ল্যান্টেড অ্যালং দ্য মেইন রোড।")
]

part9 = {
    "id": "past-foundations-p9",
    "order": 9,
    "level": "B1",
    "title_bn": "অতীত কালের কর্মবাচ্য (Past Passive Voice: Was/Were + V3)",
    "title_target": "Past Passive Voice (Was/Were + V3 & Was/Were being + V3)",
    "lessons": [
        {
            "id": "past-p9-l31",
            "order": 1,
            "title_bn": "সাধারণ অতীত কর্মবাচ্য — 'Was / Were + V3'",
            "title_target": "Past Simple Passive (Was / Were + V3)",
            "intro_bn": "অতীতে কর্তা ছাড়া কোনো কাজ কারো দ্বারা সম্পন্ন হয়েছিল বোঝাতে Past Simple Passive বসে।",
            "structure": ["Subject + was / were + V3 (Past Participle)"],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_passive") for i in p9_l31]
        },
        {
            "id": "past-p9-l32",
            "order": 2,
            "title_bn": "চলমান অতীত কর্মবাচ্য — 'Was / Were being + V3'",
            "title_target": "Past Continuous Passive (Was / Were being + V3)",
            "intro_bn": "অতীতে কোনো কাজ কারো দ্বারা করা হচ্ছিল বোঝাতে Past Continuous Passive বসে।",
            "structure": ["Subject + was / were being + V3"],
            "items": [make_item(i[0], i[1], i[2], i[3], tense="past_passive") for i in p9_l32]
        }
    ]
}

# ==============================================================================
# PART 10: Mini Past Presentations & Storytelling
# ==============================================================================
p10_l33_pres = [
    ("past-p10-pres-001", "I spent my memorable childhood in a quiet village in Sylhet.", "আমি আমার স্মরণীয় শৈশব সিলেটের একটি শান্ত গ্রামে কাটিয়েছিলাম।", "আই স্পেন্ট মাই মেমোরেবল চাইল্ডহুড ইন আ কোয়ায়েট ভিলেজ ইন সিলেট।"),
    ("past-p10-pres-002", "We used to swim in the local river every single afternoon.", "আমরা প্রতিদিন বিকেলে স্থানীয় নদীতে সাঁতার কাটতাম।", "উই ইউজড টু সুইম ইন দ্য লোকাল রিভার এভরি সিঙ্গেল আফটারনুন।"),
    ("past-p10-pres-003", "My grandfather was a wise person and told us inspiring stories.", "আমার দাদা একজন জ্ঞানী ব্যক্তি ছিলেন এবং আমাদের অনুপ্রেরণামূলক গল্প বলতেন।", "মাই গ্র্যান্ডফাদার ওয়াজ আ ওয়াইজ পারসন অ্যান্ড টোল্ড আস ইন্সপায়ারিং স্টোরিজ।"),
    ("past-p10-pres-004", "We didn't have any smartphones, but we were genuinely happy.", "আমাদের কোনো স্মার্টফোন ছিল না, কিন্তু আমরা সত্যিই সুখী ছিলাম।", "উই ডিডন্ট হ্যাভ অ্যানি স্মার্টফোনস, বাট উই ওয়্যার জেনুইনলি হ্যাপি।"),
    ("past-p10-pres-005", "Those days taught me the real value of family and friendship.", "সেই দিনগুলো আমাকে পরিবার এবং বন্ধুত্বের আসল মূল্য শিখিয়েছিল।", "দোজ ডেইজ টট মি দ্য রিয়েল ভ্যালু অব ফ্যামিলি অ্যান্ড ফ্রেন্ডশিপ।")
]

p10_l34_pres = [
    ("past-p10-pres-006", "Last winter, I visited Cox's Bazar with my family members.", "গত শীতে আমি আমার পরিবারের সদস্যদের সাথে কক্সবাজার ভ্রমণ করেছিলাম।", "লাস্ট উইন্টার, আই ভিজিটেড কক্সবাজার উইথ মাই ফ্যামিলি মেম্বার্স।"),
    ("past-p10-pres-007", "We stayed at a beautiful resort right beside the beach.", "আমরা সমুদ্র সৈকতের ঠিক পাশেই একটি সুন্দর রিসোর্টে ছিলাম।", "উই સ્ટેইড অ্যাট আ বিউটিফুল রিসোর্ট রাইট বিসাইড দ্য বিচ।"),
    ("past-p10-pres-008", "While we were walking on the sand, we watched a magnificent sunset.", "আমরা যখন বালির ওপর হাঁটছিলাম, তখন আমরা একটি চমৎকার সূর্যাস্ত দেখেছিলাম।", "হোয়াইল উই ওয়্যার ওয়াকিং অন দ্য স্যান্ড, উই ওয়াচড আ ম্যাগনিফিসেন্ট সানসেট।"),
    ("past-p10-pres-009", "We also tasted fresh delicious seafood at a local eatery.", "আমরা একটি স্থানীয় রেস্তোরাঁয় তাজা সুস্বাদু সামুদ্রিক খাবারও খেয়েছিলাম।", "উই অলসো টেস্টেড ফ্রেশ ডেলিশাস সিফুড অ্যাট আ লোকাল ইটারি।"),
    ("past-p10-pres-010", "That journey was one of the most unforgettable trips of my life.", "সেই ভ্রমণটি আমার জীবনের সবচেয়ে অবিস্মরণীয় ভ্রমণের একটি ছিল।", "দ্যাট জার্নি ওয়াজ ওয়ান অব দ্য মোস্ট আনফরগেটেবল ট্রিপস অব মাই লাইফ।")
]

part10 = {
    "id": "past-foundations-p10",
    "order": 10,
    "level": "A2",
    "title_bn": "অতীতের গল্প বলা ও উপস্থাপনা (Mini Past Presentations)",
    "title_target": "Storytelling & Mini Past Presentations",
    "lessons": [
        {
            "id": "past-p10-l33",
            "order": 1,
            "badge": "Fluency Presentation",
            "badge_bn": "ফ্লুয়েন্সি প্রেজেন্টেশন",
            "title_bn": "উপস্থাপনা ১: 'My Memorable Childhood' (আমার স্মরণীয় শৈশব)",
            "title_target": "Presentation 1: My Memorable Childhood",
            "intro_bn": "শৈশবের স্মৃতি একটানা ৫ লাইনে সাবলীলভাবে বলার স্পোকেন অনুশীলন।",
            "structure": ["Past Simple (V2) + Used to + Was/Were"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in p10_l33_pres]
        },
        {
            "id": "past-p10-l34",
            "order": 2,
            "badge": "Fluency Presentation",
            "badge_bn": "ফ্লুয়েন্সি প্রেজেন্টেশন",
            "title_bn": "উপস্থাপনা ২: 'How I Spent My Last Holiday' (গত ছুটি যেভাবে কাটিয়েছিলাম)",
            "title_target": "Presentation 2: How I Spent My Last Holiday",
            "intro_bn": "ভ্রমণের অভিজ্ঞতা ও আনন্দময় স্মৃতি ইংরেজিতে ধারাবাহিকভাবে বলার অনুশীলন।",
            "structure": ["V2 + When / While + Was/Were"],
            "items": [make_item(i[0], i[1], i[2], i[3]) for i in p10_l34_pres]
        }
    ]
}

# ==============================================================================
# PART 11: Past Voice Interactive Pair Practice (Voice Q&A)
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
        "ডিড ইউ ওয়াচ দ্য cricket ম্যাচ লাস্ট নাইট?"
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
            "id": "past-p11-l35",
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

print(f"Successfully merged all past tense items into {DEST_FILE}!")
print(f"Total parts: {len(all_parts)}")
print(f"Total lessons: {total_lessons}")
print(f"Total items: {total_items}")
