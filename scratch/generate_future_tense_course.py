import json
import sys

sys.stdout.reconfigure(encoding='utf-8')

DEST_FILE = 'android/app/src/main/assets/spoken_english_future_tense.json'

course_metadata = {
    "id": "en-spoken-future-tense",
    "target_lang": "en",
    "base_lang": "bn",
    "title_bn": "স্পোকেন ইংলিশ: Future Tense (ভবিষ্যৎ কাল)",
    "title_target": "Spoken English: Future Tense Masterclass",
    "source": "Curated Spoken English Curriculum",
    "note": "ভবিষ্যতের অবস্থান ও পরিচয় (Will be), তাৎক্ষণিক সিদ্ধান্ত (Will), পূর্ব পরিকল্পনা (Be going to), ভবিষ্যৎ ঘটমান (Will be + V-ing), মোডাল ও সম্ভাবনা (May/Might/Would like to), পুরাঘটিত ভবিষ্যৎ (Will have + V3), প্যাসিভ, টাং টুইস্টার ও ৬ রূপান্তর ড্রিল।",
    "welcome_text": "স্পোকেন ইংলিশ Future Tense মাস্টারক্লাসে আপনাকে স্বাগতম। ভবিষ্যতের পরিকল্পনা, প্রতিশ্রুতি ও স্বপ্ন সাবলীল ইংরেজিতে প্রকাশ করতে নিয়মিত প্রাক্টিস করুন, ধন্যবাদ।"
}

def make_item(item_id, target, bn, pron_bn, sentence_type="assertive", polarity="affirmative", tense="future_simple", category=None, phoneme_focus=None):
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
# PART 1: Future State, Identity, Contractions & Tongue Twisters (Will be)
# ==============================================================================
p1_l1 = [
    ("fut-p1-l1-001", "I will be very busy tomorrow morning.", "আমি আগামীকাল সকালে খুব ব্যস্ত থাকব।", "আই উইল বি ভেরি বিজি টুমরো মর্নিং।"),
    ("fut-p1-l1-002", "He will be ready in ten minutes.", "সে দশ মিনিটের মধ্যে প্রস্তুত হবে।", "হি উইল বি রেডি ইন টেন মিনিটস।"),
    ("fut-p1-l1-003", "They will be very happy to hear this great news.", "এই দারুণ খবরটি শুনে তারা খুব খুশি হবে।", "দে উইল বি ভেরি হ্যাপি টু হিয়ার দিস গ্রেট নিউজ।"),
    ("fut-p1-l1-004", "She will be a successful software engineer in the future.", "ভবিষ্যতে তিনি একজন সফল সফটওয়্যার ইঞ্জিনিয়ার হবেন।", "শি উইল বি আ সাকসেসফুল সফটওয়্যার ইঞ্জিনিয়ার ইন দ্য ফিউচার।"),
    ("fut-p1-l1-005", "The weather will be sunny and warm this weekend.", "এই সাপ্তাহিক ছুটিতে আবহাওয়া রৌদ্রোজ্জ্বল ও উষ্ণ থাকবে।", "দ্য ওয়েদার উইল বি সানি অ্যান্ড ওয়ার্ম দিস উইকএন্ড।"),
    ("fut-p1-l1-006", "Will you be free tomorrow evening? Yes, I will be free. No, I will be busy.", "আপনি কি আগামীকাল সন্ধ্যায় অবসর থাকবেন? হ্যাঁ, আমি অবসর থাকব। না, আমি ব্যস্ত থাকব।", "উইল ইউ বি ফ্রি টুমরো ইভনিং? ইয়েস, আই উইল বি ফ্রি। নো, আই উইল বি বিজি।"),
    ("fut-p1-l1-007", "Will he be on time for the meeting? Yes, he will be on time. No, he won't.", "তিনি কি মিটিংয়ে সময়মতো উপস্থিত হবেন? হ্যাঁ, তিনি সময়মতো থাকবেন। না, তিনি থাকবেন না।", "উইল হি বি অন টাইম ফর দ্য মিটিং? ইয়েস, হি উইল বি অন টাইম। নো, হি ওন্ট।"),
    ("fut-p1-l1-008", "Where will you be next Friday? I will be in Chittagong.", "আগামী শুক্রবারে আপনি কোথায় থাকবেন? আমি চট্টগ্রামে থাকব।", "হোয়ার উইল ইউ বি নেক্সট ফ্রাইডে? আই উইল বি ইন চিটাগং।")
]

p1_l2 = [
    ("fut-p1-l2-001", "I'll be extremely careful with this sensitive device.", "আমি এই সংবেদনশীল ডিভাইসের ব্যাপারে অত্যন্ত সতর্ক থাকব।", "আইল বি এক্সট্রিমলি কেয়ারফুল উইথ দিস সেনসিটিভ ডিভাইস।"),
    ("fut-p1-l2-002", "She won't be upset about our minor delay.", "আমাদের সামান্য দেরির কারণে তিনি মন খারাপ করবেন না।", "শি ওন্ট বি আপসেট অ্যাবাউট আওয়ার মাইনর ডিলে।"),
    ("fut-p1-l2-003", "We'll be proud of your outstanding achievement.", "আমরা তোমার অসাধারণ সাফল্যে গর্বিত হব।", "উইল বি প্রাউড অব ইয়োর আউটস্ট্যান্ডিং অ্যাচিভমেন্ট।"),
    ("fut-p1-l2-004", "He won't be nervous during the live presentation.", "লাইভ প্রেজেন্টেশনের সময় তিনি নার্ভাস হবেন না।", "হি ওন্ট বি নার্ভাস ডিউরিং দ্য লাইভ প্রেজেন্টেশন।"),
    ("fut-p1-l2-005", "They'll be confident in front of the honorable panel.", "সম্মানিত প্যানেলের সামনে তারা আত্মবিশ্বাসী থাকবে।", "দেইল বি কনফিডেন্ট ইন ফ্রন্ট অব দি অনারেবল প্যানেল।"),
    ("fut-p1-l2-006", "The new smartphone will be available in the local market soon.", "নতুন স্মার্টফোনটি শিগগিরই স্থানীয় বাজারে পাওয়া যাবে।", "দ্য নিউ স্মার্টফোন উইল বি অ্যাভেইলেবল ইন দ্য লোকাল মার্কেট সুন।"),
    ("fut-p1-l2-007", "Won't you be tired after this long international flight? No, I will take rest.", "এই দীর্ঘ আন্তর্জাতিক ফ্লাইটের পর আপনি কি ক্লান্ত হবেন না? না, আমি বিশ্রাম নেব।", "ওন্ট ইউ বি টায়ার্ড আফটার দিস লং ইন্টারন্যাশনাল ফ্লাইট? নো, আই উইল টেক রেস্ট।"),
    ("fut-p1-l2-008", "Why will she be absent tomorrow? Because she has a doctor's appointment.", "আগামীকাল তিনি অনুপস্থিত থাকবেন কেন? কারণ তার ডাক্তারের অ্যাপয়েন্টমেন্ট আছে।", "হোয়াই উইল শি বি অ্যাবসেন্ট টুমরো? বিকজ শি হ্যাজ আ ডক্টরস অ্যাপয়েন্টমেন্ট।")
]

p1_l3_twisters = [
    ("fut-p1-twister-001", "Will William willingly wait for Wendy's warm waffles?", "উইলিয়াম কি আনন্দের সাথে ওয়েন্ডির গরম ওয়াফেলের জন্য অপেক্ষা করবে?", "উইল উইলিয়াম উইলিংলি ওয়েইট ফর ওয়েন্ডিজ ওয়ার্ম ওয়াফেলস?", "/w/ semivowel & will fluency"),
    ("fut-p1-twister-002", "Fred will find fifty fresh fruits for Friday's feast.", "ফ্রেড শুক্রবারের ভোজের জন্য পঞ্চাশটি তাজা ফল সংগ্রহ করবে।", "ফ্রেড উইল ফাইন্ড ফিফটি ফ্রেশ ফ্রুটস ফর ফ্রাইডেইজ ফিস্ট।", "/f/ labiodental & future simple"),
    ("fut-p1-twister-003", "Luke'll like lucky lakes and little lovely lilies.", "লুক সৌভাগ্যবান হ্রদ এবং ছোট সুন্দর লিলি ফুল পছন্দ করবে।", "লুকল লাইক লাকি লেইকস অ্যান্ড লিটল লাভলি লিলিজ।", "/l/ lateral liquid & 'll contraction"),
    ("fut-p1-twister-004", "We won't want winter winds when warm weather waits.", "উষ্ণ আবহাওয়া অপেক্ষা করলে আমরা শীতের বাতাস চাইব না।", "উই ওন্ট ওয়ান্ট উইন্টার উইন্ডস হোয়েন ওয়ার্ম ওয়েদার ওয়েইটস।", "won't vs want contrast"),
    ("fut-p1-twister-005", "She'll surely show seven shiny silver shields.", "তিনি নিশ্চিতভাবে সাতটি চকচকে রূপালী ঢাল প্রদর্শন করবেন।", "শিল শিওরলি শো সেভেন শাইনি সিলভার শিল্ডস।", "/sh/ and /s/ future sibilants")
]

p1_l4_trans = [
    ("fut-p1-trans-001", "I will be a teacher.", "আমি একজন শিক্ষক হব।", "আই উইল বি আ টিচার।", "assertive", "affirmative"),
    ("fut-p1-trans-002", "I will not be a teacher.", "আমি একজন শিক্ষক হব না।", "আই উইল নট বি আ টিচার।", "assertive", "negative"),
    ("fut-p1-trans-003", "Will I be a teacher?", "আমি কি একজন শিক্ষক হব?", "উইল আই বি আ টিচার?", "interrogative", "affirmative"),
    ("fut-p1-trans-004", "Won't I be a teacher?", "আমি কি একজন শিক্ষক হব না?", "ওন্ট আই বি আ টিচার?", "interrogative", "negative"),
    ("fut-p1-trans-005", "Why will I be a teacher?", "আমি কেন একজন শিক্ষক হব?", "হোয়াই উইল আই বি আ টিচার?", "wh_question", "affirmative"),
    ("fut-p1-trans-006", "Why won't I be a teacher?", "আমি কেন একজন শিক্ষক হব না?", "হোয়াই ওন্ট আই বি আ টিচার?", "wh_question", "negative"),
    ("fut-p1-trans-007", "He will be a leader.", "তিনি একজন নেতা হবেন।", "হি উইল বি আ লিডার।", "assertive", "affirmative"),
    ("fut-p1-trans-008", "He will not be a leader.", "তিনি একজন নেতা হবেন না।", "হি উইল নট বি আ লিডার।", "assertive", "negative"),
    ("fut-p1-trans-009", "Will he be a leader?", "তিনি কি একজন নেতা হবেন?", "উইল হি বি আ লিডার?", "interrogative", "affirmative"),
    ("fut-p1-trans-010", "Won't he be a leader?", "তিনি কি একজন নেতা হবেন না?", "ওন্ট হি বি আ লিডার?", "interrogative", "negative"),
    ("fut-p1-trans-011", "Where will he be a leader?", "তিনি কোথায় একজন নেতা হবেন?", "হোয়ার উইল হি বি আ লিডার?", "wh_question", "affirmative"),
    ("fut-p1-trans-012", "Why won't he be a leader?", "তিনি কেন একজন নেতা হবেন না?", "হোয়াই ওন্ট হি বি আ লিডার?", "wh_question", "negative")
]

part1 = {
    "id": "fut-foundations-p1",
    "order": 1,
    "level": "A1",
    "title_bn": "ভবিষ্যতের অবস্থা, পরিচয় ও উচ্চারণ ড্রিল (Future State & Identity)",
    "title_target": "Future State, Identity & Fluency Drills",
    "lessons": [
        {
            "id": "fut-p1-l1",
            "order": 1,
            "title_bn": "ভবিষ্যতে কোনো ব্যক্তি বা বস্তুর অবস্থা (Will be)",
            "title_target": "Future State & Condition: Will be",
            "intro_bn": "ভবিষ্যতে কেউ কেমন থাকবে বা কোনো কিছুর অবস্থা কেমন হবে তা প্রকাশ করতে 'Subject + will be + Adjective/Noun' ব্যবহার করা হয়।",
            "structure": ["Subject + will be + Adjective/Noun", "Will + Subject + be + ...?"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_simple") for x in p1_l1]
        },
        {
            "id": "fut-p1-l2",
            "order": 2,
            "title_bn": "সংক্ষিপ্ত রূপ ও না-বোধক স্পোকেন ড্রিল ('ll be / won't be)",
            "title_target": "Future Contractions: 'll be / won't be",
            "intro_bn": "কথ্য ইংরেজিতে 'I will be' কে 'I'll be' এবং 'will not be' কে সংক্ষেপে 'won't be' বলা হয়। এটি কথ্য ইংরেজিকে অত্যন্ত সাবলীল করে।",
            "structure": ["I'll / She'll / They'll + be + Complement", "Subject + won't be + Complement"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_simple") for x in p1_l2]
        },
        {
            "id": "fut-p1-l3",
            "order": 3,
            "title_bn": "ভবিষ্যৎ কাল টাং টুইস্টার মাস্টারক্লাস (Speed & Agility)",
            "title_target": "Future Tense Tongue Twisters",
            "intro_bn": "ভবিষ্যৎ কালের 'will', 'won't' এবং দ্রুত কথ্য সংকোচনের সঠিক উচ্চারণের জন্য দ্রুত ও স্পষ্টভাবে এই বাক্যগুলো প্রাক্টিস করুন।",
            "structure": ["Tongue Twisters targeting /w/, /l/, /f/ and won't vs want"],
            "items": [make_item(x[0], x[1], x[2], x[3], sentence_type="tongue_twister", category="pronunciation", phoneme_focus=x[4], tense="future_simple") for x in p1_l3_twisters]
        },
        {
            "id": "fut-p1-l4",
            "order": 4,
            "title_bn": "ভবিষ্যতের অবস্থার ৬টি মৌলিক রূপান্তর (6-Pattern Drill)",
            "title_target": "6-Pattern Transformation: Future State",
            "intro_bn": "একটি ভবিষ্যৎ বাক্যকে ৬টি ধরনে রূপান্তর করার অভ্যাস আপনাকে তাৎক্ষণিকভাবে প্রশ্ন ও উত্তর তৈরিতে দক্ষ করে তুলবে।",
            "structure": [
                "1. Affirmative: Subject + will be...",
                "2. Negative: Subject + will not be...",
                "3. Interrogative: Will + Subject + be...?",
                "4. Interro-Neg: Won't + Subject + be...?",
                "5. WH-Question: WH + will + Subject + be...?",
                "6. WH-Negative: WH + won't + Subject + be...?"
            ],
            "items": [make_item(x[0], x[1], x[2], x[3], sentence_type=x[4], polarity=x[5], category="transformation_drill", tense="future_simple") for x in p1_l4_trans]
        }
    ]
}

# ==============================================================================
# PART 2: Future Location & Prepositions + 6-Pattern Transformations
# ==============================================================================
p2_l1 = [
    ("fut-p2-l1-001", "I will be at the head office tomorrow morning.", "আমি আগামীকাল সকালে প্রধান কার্যালয়ে থাকব।", "আই উইল বি অ্যাট দ্য হেড অফিস টুমরো মর্নিং।"),
    ("fut-p2-l1-002", "She will be at home this Sunday afternoon.", "তিনি এই রবিবার বিকেলে বাড়িতে থাকবেন।", "শি উইল বি অ্যাট হোম দিস সানডে আফটারনুন।"),
    ("fut-p2-l1-003", "They will be on the train to Sylhet by noon.", "দুপুরের মধ্যে তারা সিলেটের ট্রেনে থাকবে।", "দে উইল বি অন দ্য ট্রেন টু সিলেট বাই নুন।"),
    ("fut-p2-l1-004", "We will be in the conference hall for the opening speech.", "উদ্বোধনী বক্তৃতার জন্য আমরা সম্মেলন কক্ষে থাকব।", "উই উইল বি ইন দ্য কনফারেন্স হল ফর দি ওপেনিং স্পিচ।"),
    ("fut-p2-l1-005", "He will be with his honorable supervisor at the hospital.", "তিনি হাসপাতালে তার সম্মানিত সুপারিভাইজারের সাথে থাকবেন।", "হি উইল বি উইথ হিজ অনারেবল সুপারভাইজার অ্যাট দ্য হসপিটাল।"),
    ("fut-p2-l1-006", "Will you be at your study desk this evening? Yes, I will be at my desk. No, I won't.", "আপনি কি আজ সন্ধ্যায় আপনার পড়ার টেবিলে থাকবেন? হ্যাঁ, আমি আমার টেবিলে থাকব। না, আমি থাকব না।", "উইল ইউ বি অ্যাট ইয়োর স্টাডি ডেস্ক দিস ইভনিং? ইয়েস, আই উইল বি অ্যাট মাই ডেস্ক। নো, আই ওন্ট।"),
    ("fut-p2-l1-007", "Will they be in Dhaka next month? Yes, they will be in Dhaka. No, they will be abroad.", "তারা কি আগামী মাসে ঢাকায় থাকবেন? হ্যাঁ, তারা ঢাকায় থাকবেন। না, তারা বিদেশে থাকবেন।", "উইল দে বি ইন ঢাকা নেক্সট মান্থ? ইয়েস, দে উইল বি ইন ঢাকা। নো, দে উইল বি অ্যাব্রড।"),
    ("fut-p2-l1-008", "Where will the international summit be held? It will be in Geneva.", "আন্তর্জাতিক শীর্ষ সম্মেলন কোথায় অনুষ্ঠিত হবে? এটি জেনেভায় হবে।", "হোয়ার উইল দি ইন্টারন্যাশনাল সামিট বি হেল্ড? ইট উইল বি ইন জেনেভা।")
]

p2_l2_trans = [
    ("fut-p2-trans-001", "We will be in the office.", "আমরা অফিসে থাকব।", "উই উইল বি ইন দি অফিস।", "assertive", "affirmative"),
    ("fut-p2-trans-002", "We will not be in the office.", "আমরা অফিসে থাকব না।", "উই উইল নট বি ইন দি অফিস।", "assertive", "negative"),
    ("fut-p2-trans-003", "Will we be in the office?", "আমরা কি অফিসে থাকব?", "উইল উই বি ইন দি অফিস?", "interrogative", "affirmative"),
    ("fut-p2-trans-004", "Won't we be in the office?", "আমরা কি অফিসে থাকব না?", "ওন্ট উই বি ইন দি অফিস?", "interrogative", "negative"),
    ("fut-p2-trans-005", "When will we be in the office?", "আমরা কখন অফিসে থাকব?", "হোয়েন উইল উই বি ইন দি অফিস?", "wh_question", "affirmative"),
    ("fut-p2-trans-006", "Why won't we be in the office?", "আমরা কেন অফিসে থাকব না?", "হোয়াই ওন্ট উই বি ইন দি অফিস?", "wh_question", "negative")
]

part2 = {
    "id": "fut-foundations-p2",
    "order": 2,
    "level": "A1",
    "title_bn": "ভবিষ্যতে অবস্থান ও প্রিপজিশনের ৬ রূপান্তর (Future Location & Prepositions)",
    "title_target": "Future Location & Prepositional Drills",
    "lessons": [
        {
            "id": "fut-p2-l5",
            "order": 1,
            "title_bn": "ভবিষ্যতে কোনো স্থানে অবস্থান প্রকাশ (Will be at/in/on/with)",
            "title_target": "Future Location: Will be + Prepositions",
            "intro_bn": "ভবিষ্যতে কেউ কোথাও থাকবে কি না তা প্রকাশ করতে 'Subject + will be + Preposition + Place' ব্যবহার করুন।",
            "structure": ["Subject + will be + at/in/on/with + Place", "Where will + Subject + be...?"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_simple") for x in p2_l1]
        },
        {
            "id": "fut-p2-l6",
            "order": 2,
            "title_bn": "অবস্থানের ৬ রূপান্তর ড্রিল (6-Pattern Drill: Location)",
            "title_target": "6-Pattern Transformation: Future Location",
            "intro_bn": "ভবিষ্যতের অবস্থানবাচক বাক্যকে দ্রুত ৬টি রূপে রূপান্তর করার অনুশীলন।",
            "structure": [
                "1. Affirmative: Subject + will be at/in...",
                "2. Negative: Subject + won't be at/in...",
                "3. Interrogative: Will + Subject + be at/in...?",
                "4. Interro-Neg: Won't + Subject + be at/in...?",
                "5. WH-Question: When/Where will + Subject + be...?",
                "6. WH-Negative: Why won't + Subject + be...?"
            ],
            "items": [make_item(x[0], x[1], x[2], x[3], sentence_type=x[4], polarity=x[5], category="transformation_drill", tense="future_simple") for x in p2_l2_trans]
        }
    ]
}

# ==============================================================================
# PART 3: Future Possession (Will have) + 6-Pattern Transformations
# ==============================================================================
p3_l1 = [
    ("fut-p3-l1-001", "I will have a modern car by the end of this year.", "এই বছরের শেষ নাগাদ আমার একটি আধুনিক গাড়ি থাকবে।", "আই উইল হ্যাভ আ মডার্ন কার বাই দি এন্ড অব দিস ইয়ার।"),
    ("fut-p3-l1-002", "She will have enough time to finish the research paper.", "গবেষণাপত্র শেষ করার জন্য তার যথেষ্ট সময় থাকবে।", "শি উইল হ্যাভ এনাফ টাইম টু ফিনিশ দ্য রিসার্চ পেপার।"),
    ("fut-p3-l1-003", "They will have all the necessary equipment tomorrow.", "আগামীকাল তাদের প্রয়োজনীয় সমস্ত যন্ত্রপাতি থাকবে।", "দে উইল হ্যাভ অল দ্য নেসেসারি ইকুইপমেন্ট টুমরো।"),
    ("fut-p3-l1-004", "We will have full access to the digital audio library.", "ডিজিটাল অডিও লাইব্রেরিতে আমাদের পূর্ণ প্রবেশাধিকার থাকবে।", "উই উইল হ্যাভ ফুল অ্যাক্সেস টু দ্য ডিজিটাল অডিও লাইব্রেরি।"),
    ("fut-p3-l1-005", "He won't have any problem finding the new apartment.", "নতুন অ্যাপার্টমেন্টটি খুঁজে পেতে তার কোনো সমস্যা হবে না।", "হি ওন্ট হ্যাভ এনি প্রবলেম ফাইন্ডিং দ্য নিউ অ্যাপার্টমেন্ট।"),
    ("fut-p3-l1-006", "Will you have enough money for this venture? Yes, I will have enough money. No, I won't have.", "এই উদ্যোগের জন্য আপনার কাছে কি পর্যাপ্ত অর্থ থাকবে? হ্যাঁ, আমার পর্যাপ্ত অর্থ থাকবে। না, আমার থাকবে না।", "উইল ইউ হ্যাভ এনাফ মানি ফর দিস ভেঞ্চার? ইয়েস, আই উইল হ্যাভ এনাফ মানি। নো, আই ওন্ট হ্যাভ।"),
    ("fut-p3-l1-007", "Will they have a holiday next week? Yes, they will have a holiday. No, they won't.", "আগামী সপ্তাহে কি তাদের ছুটি থাকবে? হ্যাঁ, তাদের ছুটি থাকবে। না, থাকবে না।", "উইল দে হ্যাভ আ হলিডে নেক্সট উইক? ইয়েস, দে উইল হ্যাভ আ হলিডে। নো, দে ওন্ট।"),
    ("fut-p3-l1-008", "What will you have for breakfast tomorrow? I will have fresh fruit and oats.", "আগামীকাল সকালের নাস্তায় আপনি কী খাবেন/রাখবেন? আমি তাজা ফল ও ওটস খাব।", "হোয়াট উইল ইউ হ্যাভ ফর ব্রেকফাস্ট টুমরো? আই উইল হ্যাভ ফ্রেশ ফ্রুট অ্যান্ড ওটস।")
]

p3_l2_trans = [
    ("fut-p3-trans-001", "He will have a smartphone.", "তার একটি স্মার্টফোন থাকবে।", "হি উইল হ্যাভ আ স্মার্টফোন।", "assertive", "affirmative"),
    ("fut-p3-trans-002", "He will not have a smartphone.", "তার কোনো স্মার্টফোন থাকবে না।", "হি উইল নট হ্যাভ আ স্মার্টফোন।", "assertive", "negative"),
    ("fut-p3-trans-003", "Will he have a smartphone?", "তার কি একটি স্মার্টফোন থাকবে?", "উইল হি হ্যাভ আ স্মার্টফোন?", "interrogative", "affirmative"),
    ("fut-p3-trans-004", "Won't he have a smartphone?", "তার কি কোনো স্মার্টফোন থাকবে না?", "ওন্ট হি হ্যাভ আ স্মার্টফোন?", "interrogative", "negative"),
    ("fut-p3-trans-005", "Which smartphone will he have?", "তার কোন স্মার্টফোনটি থাকবে?", "হুইচ স্মার্টফোন উইল হি হ্যাভ?", "wh_question", "affirmative"),
    ("fut-p3-trans-006", "Why won't he have a smartphone?", "তার কেন কোনো স্মার্টফোন থাকবে না?", "হোয়াই ওন্ট হি হ্যাভ আ স্মার্টফোন?", "wh_question", "negative")
]

part3 = {
    "id": "fut-foundations-p3",
    "order": 3,
    "level": "A1",
    "title_bn": "ভবিষ্যতের অধিকার ও প্রাপ্তির ৬ রূপান্তর (Future Possession: Will have)",
    "title_target": "Future Possession: Will have Drills",
    "lessons": [
        {
            "id": "fut-p3-l7",
            "order": 1,
            "title_bn": "ভবিষ্যতে কোনো বস্তু বা সুযোগ থাকা (Will have)",
            "title_target": "Future Possession: Will have",
            "intro_bn": "ভবিষ্যতে কারো কাছে কিছু থাকবে বা থাকবে না তা প্রকাশ করতে 'Subject + will have + Object' ব্যবহৃত হয়।",
            "structure": ["Subject + will have + Noun", "Subject + won't have + Noun", "Will + Subject + have + Noun?"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_simple") for x in p3_l1]
        },
        {
            "id": "fut-p3-l8",
            "order": 2,
            "title_bn": "মালিকানার ৬ রূপান্তর ড্রিল (6-Pattern Drill: Possession)",
            "title_target": "6-Pattern Transformation: Future Possession",
            "intro_bn": "ভবিষ্যতে অধিকারবাচক বাক্যকে দ্রুত ৬টি রূপে রূপান্তর করার অনুশীলন।",
            "structure": [
                "1. Affirmative: Subject + will have...",
                "2. Negative: Subject + won't have...",
                "3. Interrogative: Will + Subject + have...?",
                "4. Interro-Neg: Won't + Subject + have...?",
                "5. WH-Question: What/Which will + Subject + have...?",
                "6. WH-Negative: Why won't + Subject + have...?"
            ],
            "items": [make_item(x[0], x[1], x[2], x[3], sentence_type=x[4], polarity=x[5], category="transformation_drill", tense="future_simple") for x in p3_l2_trans]
        }
    ]
}

# ==============================================================================
# PART 4: Future Simple Actions (Will + V1) & Instant Decisions
# ==============================================================================
p4_l1 = [
    ("fut-p4-l1-001", "I will call you as soon as I arrive at the hotel.", "হোটেলে পৌঁছানোর সাথে সাথেই আমি আপনাকে কল করব।", "আই উইল কল ইউ অ্যাজ সুন অ্যাজ আই অ্যারাইভ অ্যাট দ্য হোটেল।"),
    ("fut-p4-l1-002", "She will help us with the English presentation.", "তিনি ইংরেজি প্রেজেন্টেশনে আমাদের সাহায্য করবেন।", "শি উইল হেল্প আস উইথ দি ইংলিশ প্রেজেন্টেশন।"),
    ("fut-p4-l1-003", "They will sign the international agreement tomorrow.", "তারা আগামীকাল আন্তর্জাতিক চুক্তিতে স্বাক্ষর করবেন।", "দে উইল সাইন দি ইন্টারন্যাশনাল অ্যাগ্রিমেন্ট টুমরো।"),
    ("fut-p4-l1-004", "We will start our online live class at eight o'clock.", "আমরা আটটায় আমাদের অনলাইন লাইভ ক্লাস শুরু করব।", "উই উইল স্টার্ট আওয়ার অনলাইন লাইভ ক্লাস অ্যাট এইট ওক্লক।"),
    ("fut-p4-l1-005", "The phone is ringing; I will answer it right now.", "ফোন বাজছে; আমি এখনই এটি রিসিভ করছি/করব।", "দ্য ফোন ইজ রিংয়িং; আই উইল অ্যানসার ইট রাইট নাও।"),
    ("fut-p4-l1-006", "Will you come to our annual function? Yes, I will definitely come. No, I will not come.", "আপনি কি আমাদের বার্ষিক অনুষ্ঠানে আসবেন? হ্যাঁ, আমি অবশ্যই আসব। না, আমি আসব না।", "উইল ইউ কাম টু আওয়ার অ্যানুয়াল ফাংশন? ইয়েস, আই উইল ডেফিনিটলি কাম। নো, আই উইল নট কাম।"),
    ("fut-p4-l1-007", "Will they accept this reasonable proposal? Yes, they will accept. No, they won't.", "তারা কি এই যৌক্তিক প্রস্তাবটি গ্রহণ করবেন? হ্যাঁ, তারা গ্রহণ করবেন। না, করবেন না।", "উইল দে অ্যাকসেপ্ট দিস রিজনেবল প্রপোজাল? ইয়েস, দে উইল অ্যাকসেপ্ট। নো, দে ওন্ট।"),
    ("fut-p4-l1-008", "When will the express train leave the station? It will leave at ten past nine.", "এক্সপ্রেস ট্রেনটি কখন স্টেশন ছাড়বে? এটি নয়টা দশে ছাড়বে।", "হোয়েন উইল দি এক্সপ্রেস ট্রেন লিভ দ্য স্টেশন? ইট উইল লিভ অ্যাট টেন পাস্ট নাইন।")
]

p4_l2 = [
    ("fut-p4-l2-001", "I will carry these heavy bags for you; please don't worry.", "আমি আপনার জন্য এই ভারী ব্যাগগুলো বহন করব; দয়া করে চিন্তা করবেন না।", "আই উইল ক্যারি দিজ হেভি ব্যাগস ফর ইউ; প্লিজ ডোন্ট ওরি।"),
    ("fut-p4-l2-002", "I promise I will never break your trust.", "আমি প্রতিশ্রুতি দিচ্ছি আমি কখনো আপনার বিশ্বাস ভাঙব না।", "আই প্রমিস আই উইল নেভার ব্রেক ইয়োর ট্রাস্ট।"),
    ("fut-p4-l2-003", "He won't disclose any confidential information to outsiders.", "তিনি বাইরের কাউকে কোনো গোপন তথ্য প্রকাশ করবেন না।", "হি ওন্ট ডিসক্লোজ এনি কনফিডেনশিয়াল ইনফরমেশন টু আউটসাইডার্স।"),
    ("fut-p4-l2-004", "We will stand by your family through thick and thin.", "আমরা যেকোনো পরিস্থিতিতে আপনার পরিবারের পাশে দাঁড়াব।", "উই উইল স্ট্যান্ড বাই ইয়োর ফ্যামিলি থ্রু থিক অ্যান্ড থিন।"),
    ("fut-p4-l2-005", "Don't worry about the bill; I'll pay for our dinner tonight.", "বিল নিয়ে চিন্তা করবেন না; আজ রাতে আমাদের ডিনারের খরচ আমি দেব।", "ডোন্ট ওরি অ্যাবাউট দ্য বিল; আইল পে ফর আওয়ার ডিনার টুনাইট।"),
    ("fut-p4-l2-006", "Will you help me solve this complex math problem? Yes, I will gladly help you.", "এই জটিল গণিত সমস্যা সমাধানে আপনি কি আমাকে সাহায্য করবেন? হ্যাঁ, আমি সানন্দে সাহায্য করব।", "উইল ইউ হেল্প মি সলভ দিস কমপ্লেক্স ম্যাথ প্রবলেম? ইয়েস, আই উইল গ্ল্যাডলি হেল্প ইউ।"),
    ("fut-p4-l2-007", "Won't you give him a second chance? No, I will not tolerate this again.", "আপনি কি তাকে দ্বিতীয় সুযোগ দেবেন না? না, আমি আর এটি সহ্য করব না।", "ওন্ট ইউ গিভ হিম আ সেকেন্ড চান্স? নো, আই উইল নট টলারেট দিস এগেইন।"),
    ("fut-p4-l2-008", "How will you handle this unexpected emergency? We will follow the protocol.", "এই অপ্রত্যাশিত জরুরি অবস্থা আপনি কীভাবে সামাল দেবেন? আমরা প্রোটোকল অনুসরণ করব।", "হাউ উইল ইউ হ্যান্ডেল দিস আনেক্সপেক্টেড এমার্জেন্সি? উই উইল ফলো দ্য প্রটোকল।")
]

p4_l3 = [
    ("fut-p4-l3-001", "I'll do it right away.", "আমি এটি এখনই করে ফেলব।", "আইল ডু ইট রাইট অ্যাওয়ে।"),
    ("fut-p4-l3-002", "You'll love this thrilling movie.", "আপনি এই রোমাঞ্চকর সিনেমাটি দারুণ পছন্দ করবেন।", "ইউইল লাভ দিস থ্রিলিং মুভি।"),
    ("fut-p4-l3-003", "He'll join our development team tomorrow.", "তিনি আগামীকাল আমাদের ডেভেলপমেন্ট টিমে যোগ দেবেন।", "হিল জয়েন আওয়ার ডেভেলপমেন্ট টিম টুমরো।"),
    ("fut-p4-l3-004", "She'll prepare a delicious dinner for the guests.", "তিনি মেহমানদের জন্য সুস্বাদু রাতের খাবার তৈরি করবেন।", "শিল প্রিপেয়ার আ ডেলিশাস ডিনার ফর দ্য গেস্টস।"),
    ("fut-p4-l3-005", "It'll take about twenty minutes to reach there.", "সেখানে পৌঁছাতে প্রায় বিশ মিনিট সময় লাগবে।", "ইটল টেক অ্যাবাউট টুয়েন্টি মিনিটস টু রিচ দেয়ার।"),
    ("fut-p4-l3-006", "They'll notify us as soon as the results are out.", "ফলাফল প্রকাশের সাথে সাথে তারা আমাদের জানাবে।", "দেইল নোটিফাই আস অ্যাজ সুন অ্যাজ দ্য রেজাল্টস আর আউট।"),
    ("fut-p4-l3-007", "We'll achieve our targets if we work consistently.", "আমরা যদি ধারাবাহিকভাবে কাজ করি তবে আমাদের লক্ষ্য অর্জন করব।", "উইল অ্যাচিভ আওয়ার টার্গেটস ইফ উই ওয়ার্ক কনসিস্টেন্টলি।"),
    ("fut-p4-l3-008", "Who will lead the technical discussion? Engr. Rahim will lead it.", "প্রযুক্তিগত আলোচনা কে পরিচালনা করবেন? প্রকৌশলী রহিম এটি পরিচালনা করবেন।", "হু উইল লিড দ্য টেকনিক্যাল ডিসকাশন? ইঞ্জিনিয়ার রহিম উইল লিড ইট।")
]

p4_l4 = [
    ("fut-p4-l4-001", "I won't disturb you during your busy study hours.", "আপনার ব্যস্ত পড়ার সময় আমি আপনাকে বিরক্ত করব না।", "আই ওন্ট ডিস্টার্ব ইউ ডিউরিং ইয়োর বিজি স্টাডি আওয়ার্স।"),
    ("fut-p4-l4-002", "She won't repeat this careless mistake again.", "তিনি আর এই অসাবধান ভুল পুনরাবৃত্তি করবেন না।", "শি ওন্ট রিপিট দিস কেয়ারলেস মিসটেক এগেইন।"),
    ("fut-p4-l4-003", "They won't allow visitors after eight o'clock in the evening.", "সন্ধ্যা আটটার পর তারা দর্শনার্থীদের অনুমতি দেবেন না।", "দে ওন্ট অ্যালাউ ভিজিটরস আফটার এইট ওক্লক ইন দি ইভনিং।"),
    ("fut-p4-l4-004", "We won't compromise on the quality of our application.", "আমাদের অ্যাপ্লিকেশনের গুণগত মানে আমরা কোনো আপস করব না।", "উই ওন্ট কম্প্রোমাইজ অন দ্য কোয়ালিটি অব আওয়ার অ্যাপ্লিকেশন।"),
    ("fut-p4-l4-005", "He won't agree to these unfavorable terms.", "তিনি এই প্রতিকূল শর্তে রাজি হবেন না।", "হি ওন্ট অ্যাগ্রি টু দিজ আনফেভারেবল টার্মস।"),
    ("fut-p4-l4-006", "Will you participate in the marathon? Yes, I will participate. No, I won't.", "আপনি কি ম্যারাথনে অংশ নেবেন? হ্যাঁ, আমি অংশ নেব। না, আমি নেব না।", "উইল ইউ পার্টিসিপেট ইন দ্য ম্যারাথন? ইয়েস, আই উইল পার্টিসিপেট। নো, আই ওন্ট।"),
    ("fut-p4-l4-007", "Won't they inform us beforehand? Yes, they will inform us.", "তারা কি আমাদের আগেই অবহিত করবে না? হ্যাঁ, তারা আমাদের অবহিত করবে।", "ওন্ট দে ইনফর্ম আস বিফোরহ্যান্ড? ইয়েস, দে উইল ইনফর্ম আস।"),
    ("fut-p4-l4-008", "Why won't you attend the orientation? Because I have a critical exam.", "আপনি ওরিয়েন্টেশনে উপস্থিত থাকবেন না কেন? কারণ আমার একটি গুরুত্বপূর্ণ পরীক্ষা আছে।", "হোয়াই ওন্ট ইউ অ্যাটেন্ড দি ওরিয়েন্টেশন? বিকজ আই হ্যাভ আ ক্রিটিক্যাল এক্সাম।")
]

p4_l5 = [
    ("fut-p4-l5-001", "What will you order for lunch today?", "আজ দুপুরের খাবারে আপনি কী অর্ডার করবেন?", "হোয়াট উইল ইউ অর্ডার ফর লাঞ্চ টুডে?"),
    ("fut-p4-l5-002", "Where will you stay during your visit to Cox's Bazar?", "কক্সবাজার ভ্রমণের সময় আপনি কোথায় থাকবেন?", "হোয়ার উইল ইউ স্টে ডিউরিং ইয়োর ভিজিট টু কক্সবাজার?"),
    ("fut-p4-l5-003", "When will the new academic semester begin?", "নতুন শিক্ষাবর্ষের সেমিস্টার কখন শুরু হবে?", "হোয়েন উইল দ্য নিউ অ্যাকাডেমিক সেমিস্টার বিগিন?"),
    ("fut-p4-l5-004", "Who will deliver the keynote address at the seminar?", "সেমিনারে মূল প্রবন্ধ কে উপস্থাপন করবেন?", "হু উইল ডেলিভার দ্য কিনোট অ্যাড্রেস অ্যাট দ্য সেমিনার?"),
    ("fut-p4-l5-005", "Which laptop will you purchase for coding?", "প্রোগ্রামিং শেখার জন্য আপনি কোন ল্যাপটপটি কিনবেন?", "হুইচ ল্যাপটপ উইল ইউ পারচেজ ফর কোডিং?"),
    ("fut-p4-l5-006", "Why will you switch to this new software?", "আপনি কেন এই নতুন সফটওয়্যারে পরিবর্তন করবেন?", "হোয়াই উইল ইউ সুইচ টু দিস নিউ সফটওয়্যার?"),
    ("fut-p4-l5-007", "How will you travel to the airport in this heavy rain?", "এই প্রবল বৃষ্টিতে আপনি বিমানবন্দরে কীভাবে যাবেন?", "হাউ উইল ইউ ট্রাভেল টু দি এয়ারপোর্ট ইন দিস হেভি রেইন?"),
    ("fut-p4-l5-008", "How long will the live performance continue?", "লাইভ অনুষ্ঠানটি কতক্ষণ চলবে?", "হাউ লং উইল দ্য লাইভ পারফরম্যান্স কন্টিনিউ?")
]

p4_l6_trans = [
    ("fut-p4-trans-001", "I will write a book.", "আমি একটি বই লিখব।", "আই উইল রাইট আ বুক।", "assertive", "affirmative"),
    ("fut-p4-trans-002", "I will not write a book.", "আমি কোনো বই লিখব না।", "আই উইল নট রাইট আ বুক।", "assertive", "negative"),
    ("fut-p4-trans-003", "Will I write a book?", "আমি কি একটি বই লিখব?", "উইল আই রাইট আ বুক?", "interrogative", "affirmative"),
    ("fut-p4-trans-004", "Won't I write a book?", "আমি কি একটি বই লিখব না?", "ওন্ট আই রাইট আ বুক?", "interrogative", "negative"),
    ("fut-p4-trans-005", "Why will I write a book?", "আমি কেন একটি বই লিখব?", "হোয়াই উইল আই রাইট আ বুক?", "wh_question", "affirmative"),
    ("fut-p4-trans-006", "Why won't I write a book?", "আমি কেন একটি বই লিখব না?", "হোয়াই ওন্ট আই রাইট আ বুক?", "wh_question", "negative")
]

part4 = {
    "id": "fut-foundations-p4",
    "order": 4,
    "level": "A2",
    "title_bn": "সাধারণ ভবিষ্যৎ কাল ও তাৎক্ষণিক সিদ্ধান্ত (Future Simple: Will + V1)",
    "title_target": "Future Simple Actions: Will + V1",
    "lessons": [
        {
            "id": "fut-p4-l9",
            "order": 1,
            "title_bn": "ভবিষ্যতে সাধারণ কাজ ও সিদ্ধান্ত (Will + V1)",
            "title_target": "Future Actions & Decisions: Will + V1",
            "intro_bn": "ভবিষ্যতে কোনো কাজ করার সাধারণ বিবৃতি দিতে 'Subject + will + Verb (Base form)' ব্যবহৃত হয়।",
            "structure": ["Subject + will + V1 + Object", "Will + Subject + V1...?"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_simple") for x in p4_l1]
        },
        {
            "id": "fut-p4-l10",
            "order": 2,
            "title_bn": "প্রতিশ্রুতি, অফার ও তাৎক্ষণিক সাহায্য (Offers & Promises)",
            "title_target": "Offers, Promises & Voluntary Actions",
            "intro_bn": "তৎক্ষণাৎ কাউকে সাহায্য করার প্রস্তাব বা কোনো প্রতিশ্রুতি দিতে Spoken English এ 'will / I'll' অত্যন্ত স্বাভাবিক ও প্রচলিত।",
            "structure": ["I will / I'll + V1 (Offer/Promise)", "Subject + won't + V1"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_simple") for x in p4_l2]
        },
        {
            "id": "fut-p4-l11",
            "order": 3,
            "title_bn": "কথ্য সংকোচন স্পিড ড্রিল ('ll + V1)",
            "title_target": "Spoken Contractions: I'll / You'll / They'll + V1",
            "intro_bn": "নেটিভ স্পিকারদের মতো দ্রুত কথা বলতে I'll, You'll, We'll, He'll, She'll, They'll এর দ্রুত প্রবাহের নিয়মিত অভ্যাস করুন।",
            "structure": ["Subject + 'll + V1 + Object"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_simple") for x in p4_l3]
        },
        {
            "id": "fut-p4-l12",
            "order": 4,
            "title_bn": "না-বোধক ভবিষ্যৎ ও অস্বীকৃতি প্রকাশ (Won't + V1)",
            "title_target": "Negative Future: Won't + V1",
            "intro_bn": "ভবিষ্যতে কোনো কাজ না করা বা অস্বীকৃতি জানাতে 'won't + V1' ব্যবহার করা হয়।",
            "structure": ["Subject + won't + V1 + Object", "Won't + Subject + V1...?"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_simple") for x in p4_l4]
        },
        {
            "id": "fut-p4-l13",
            "order": 5,
            "title_bn": "ভবিষ্যতের ডব্লিউ/এইচ প্রশ্ন ড্রিল (WH-Questions with Will)",
            "title_target": "WH-Questions with Will",
            "intro_bn": "ভবিষ্যতের তথ্য, সময় ও কারণ জানার জন্য What, Where, When, Why, How দিয়ে প্রশ্ন করার বাস্তবমুখী ড্রিল।",
            "structure": ["WH-Word + will + Subject + V1...?"],
            "items": [make_item(x[0], x[1], x[2], x[3], sentence_type="wh_question", tense="future_simple") for x in p4_l5]
        },
        {
            "id": "fut-p4-l14",
            "order": 6,
            "title_bn": "সাধারণ কাজের ৬ রূপান্তর ড্রিল (6-Pattern Drill: Action)",
            "title_target": "6-Pattern Transformation: Future Action",
            "intro_bn": "একটি কাজের বিবৃতিকে ৬টি ধরনে রূপান্তর করে স্পোকেন ফ্লুয়েন্সি অর্জন করুন।",
            "structure": [
                "1. Affirmative: Subject + will + V1...",
                "2. Negative: Subject + will not + V1...",
                "3. Interrogative: Will + Subject + V1...?",
                "4. Interro-Neg: Won't + Subject + V1...?",
                "5. WH-Question: Why will + Subject + V1...?",
                "6. WH-Negative: Why won't + Subject + V1...?"
            ],
            "items": [make_item(x[0], x[1], x[2], x[3], sentence_type=x[4], polarity=x[5], category="transformation_drill", tense="future_simple") for x in p4_l6_trans]
        }
    ]
}

# ==============================================================================
# PART 5: Intentions & Near Future: Be Going To vs Will
# ==============================================================================
p5_l1 = [
    ("fut-p5-l1-001", "I am going to learn Python programming this month.", "আমি এই মাসে পাইথন প্রোগ্রামিং শিখতে যাচ্ছি/পরিকল্পনা করেছি।", "আই অ্যাম গোয়িং টু লার্ন পাইথন প্রোগ্রামিং দিস মান্থ।"),
    ("fut-p5-l1-002", "She is going to start her own technology business soon.", "তিনি শিগগিরই তার নিজস্ব প্রযুক্তি ব্যবসা শুরু করতে যাচ্ছেন।", "শি ইজ গোয়িং টু স্টার্ট হার ওন টেকনোলজি বিজনেস সুন।"),
    ("fut-p5-l1-003", "They are going to buy a new flat in Uttara.", "তারা উত্তরায় একটি নতুন ফ্ল্যাট কিনতে যাচ্ছেন।", "দে আর গোয়িং টু বাই আ নিউ ফ্ল্যাট ইন উত্তরা।"),
    ("fut-p5-l1-004", "Look at those dark clouds; it is going to rain heavily.", "ঐ কালো মেঘগুলোর দিকে তাকান; ভারী বৃষ্টি হতে যাচ্ছে।", "লুক অ্যাট দোজ ডার্ক ক্লাউডস; ইট ইজ গোয়িং টু রেইন হেভিলি।"),
    ("fut-p5-l1-005", "We are going to launch our mobile application next Monday.", "আমরা আগামী সোমবারে আমাদের মোবাইল অ্যাপ চালু করতে যাচ্ছি।", "উই আর গোয়িং টু লঞ্চ আওয়ার মোবাইল অ্যাপ্লিকেশন নেক্সট মান্ডে।"),
    ("fut-p5-l1-006", "Are you going to attend the job fair tomorrow? Yes, I am going to attend. No, I am not.", "আপনি কি আগামীকাল জব ফেয়ারে যাচ্ছেন? হ্যাঁ, আমি যাচ্ছি। না, আমি যাচ্ছি না।", "আর ইউ গোয়িং টু অ্যাটেন্ড দ্য জব ফেয়ার টুমরো? ইয়েস, আই অ্যাম গোয়িং টু অ্যাটেন্ড। নো, আই অ্যাম নট।"),
    ("fut-p5-l1-007", "Is he going to resign from this position? No, he is going to continue.", "তিনি কি এই পদ থেকে পদত্যাগ করতে যাচ্ছেন? না, তিনি চালিয়ে যাবেন।", "ইজ হি গোয়িং টু রিজাইন ফ্রম দিস পজিশন? নো, হি ইজ গোয়িং টু কন্টিনিউ।"),
    ("fut-p5-l1-008", "What are you going to do after completing graduation? I'm going to apply for higher studies.", "গ্র্যাজুয়েশন শেষ করার পর আপনি কী করতে যাচ্ছেন? আমি উচ্চশিক্ষার আবেদন করতে যাচ্ছি।", "হোয়াট আর ইউ গোয়িং টু ডু আফটার কমপ্লিটিং গ্র্যাজুয়েশন? আইম গোয়িং টু অ্যাপ্লাই ফর হায়ার স্টাডিজ।")
]

p5_l2 = [
    ("fut-p5-l2-001", "I will help you right now! (Instant decision)", "আমি এখনই আপনাকে সাহায্য করব! (তাৎক্ষণিক সিদ্ধান্ত)", "আই উইল হেল্প ইউ রাইট নাও!"),
    ("fut-p5-l2-002", "I am going to help him this weekend. (Prior plan)", "আমি এই সাপ্তাহিক ছুটিতে তাকে সাহায্য করার পরিকল্পনা করেছি। (পূর্ব পরিকল্পনা)", "আই অ্যাম গোয়িং টু হেল্প হিম দিস উইকএন্ড।"),
    ("fut-p5-l2-003", "I'm having dinner with the CEO tomorrow evening. (Fixed arrangement)", "আগামীকাল সন্ধ্যায় সিইও-র সাথে আমার ডিনার নির্ধারিত রয়েছে। (পূর্বনির্ধারিত সূচি)", "আইম হ্যাভিং ডিনার উইথ দ্য সিইও টুমরো ইভনিং।"),
    ("fut-p5-l2-004", "The match starts at seven o'clock tomorrow. (Official timetable)", "খেলাটি আগামীকাল সাতটায় শুরু হবে। (অফিসিয়াল সময়সূচি)", "দ্য ম্যাচ স্টার্টস অ্যাট সেভেন ওক্লক টুমরো।"),
    ("fut-p5-l2-005", "I think the national team will win the tournament.", "আমার মনে হয় জাতীয় দল টুর্নামেন্ট জিতবে। (ব্যক্তিগত অনুমান)", "আই থিংক দ্য ন্যাশনাল টিম উইল উইন দ্য টুর্নামেন্ট।"),
    ("fut-p5-l2-006", "Watch out! The baby is going to fall off the chair!", "সাবধান! বাচ্চাটি চেয়ার থেকে পড়ে যেতে চলেছে! (প্রত্যক্ষ লক্ষণ)", "ওয়াচ আউট! দ্য বেবি ইজ গোয়িং টু ফল অফ দ্য চেয়ার!"),
    ("fut-p5-l2-007", "Will you take coffee or tea? I will take coffee, please.", "আপনি কি কফি নেবেন নাকি চা? আমি কফি নেব, প্লিজ।", "উইল ইউ টেক কফি অর টি? আই উইল টেক কফি, প্লিজ।"),
    ("fut-p5-l2-008", "When are you flying to London? I'm flying next Thursday.", "আপনি লন্ডনে কবে যাচ্ছেন? আমি আগামী বৃহস্পতিবার যাচ্ছি।", "হোয়েন আর ইউ ফ্লাইং টু লন্ডন? আইম ফ্লাইং নেক্সট থার্সডে।")
]

p5_l3 = [
    ("fut-p5-l3-001", "I'm gonna practice English every single day.", "আমি প্রতিদিন ইংরেজি প্রাক্টিস করতে যাচ্ছি।", "আইম গনা প্র্যাকটিস ইংলিশ এভরি সিঙ্গেল ডে।"),
    ("fut-p5-l3-002", "She's gonna submit her assignment before midnight.", "তিনি মধ্যরাতের আগেই তার অ্যাসাইনমেন্ট জমা দিতে যাচ্ছেন।", "শীজ গনা সাবমিট হার অ্যাসাইনমেন্ট বিফোর মিডনাইট।"),
    ("fut-p5-l3-003", "They're gonna build a high-tech laboratory here.", "তারা এখানে একটি আধুনিক হাইটেক গবেষণাগার তৈরি করতে যাচ্ছেন।", "দেয়ার গনা বিল্ড আ হাইটেক ল্যাবরেটরি হিয়ার।"),
    ("fut-p5-l3-004", "We're not gonna waste any valuable minutes.", "আমরা কোনো মূল্যবান মুহূর্ত অপচয় করতে যাচ্ছি না।", "উইয়ার নট গনা ওয়েস্ট এনি ভ্যালুয়েবল মিনিটস।"),
    ("fut-p5-l3-005", "He's gonna explain the core concept thoroughly.", "তিনি মূল ধারণাটি পুঙ্খানুপুঙ্খভাবে ব্যাখ্যা করতে যাচ্ছেন।", "হিজ গনা এক্সপ্লেইন দ্য কোর কনসেপ্ট থারোলি।"),
    ("fut-p5-l3-006", "Are you gonna join our spoken club? Yes, absolutely!", "আপনি কি আমাদের স্পোকেন ক্লাবে যোগ দিতে যাচ্ছেন? হ্যাঁ, অবশ্যই!", "আর ইউ গনা জয়েন আওয়ার স্পোকেন ক্লাব? ইয়েস, অ্যাবসলিউটলি!"),
    ("fut-p5-l3-007", "What're you gonna do about this issue? I'll report it.", "এই সমস্যার ব্যাপারে আপনি কী করতে যাচ্ছেন? আমি এটি রিপোর্ট করব।", "হোয়াটার ইউ গনা ডু অ্যাবাউট দিস ইস্যু? আইল রিপোর্ট ইট।"),
    ("fut-p5-l3-008", "Who's gonna manage the project? Farhan is gonna manage it.", "প্রকল্পটি কে পরিচালনা করতে যাচ্ছেন? ফারহান এটি পরিচালনা করতে যাচ্ছেন।", "হুজ গনা ম্যানেজ দ্য প্রজেক্ট? ফারহান ইজ গনা ম্যানেজ ইট।")
]

p5_l4_trans = [
    ("fut-p5-trans-001", "I am going to start a company.", "আমি একটি কোম্পানি শুরু করতে যাচ্ছি।", "আই অ্যাম গোয়িং টু স্টার্ট আ কোম্পানি।", "assertive", "affirmative"),
    ("fut-p5-trans-002", "I am not going to start a company.", "আমি কোনো কোম্পানি শুরু করতে যাচ্ছি না।", "আই অ্যাম নট গোয়িং টু স্টার্ট আ কোম্পানি।", "assertive", "negative"),
    ("fut-p5-trans-003", "Are you going to start a company?", "আপনি কি একটি কোম্পানি শুরু করতে যাচ্ছেন?", "আর ইউ গোয়িং টু স্টার্ট আ কোম্পানি?", "interrogative", "affirmative"),
    ("fut-p5-trans-004", "Aren't you going to start a company?", "আপনি কি একটি কোম্পানি শুরু করতে যাচ্ছেন না?", "আরন্ট ইউ গোয়িং টু স্টার্ট আ কোম্পানি?", "interrogative", "negative"),
    ("fut-p5-trans-005", "Why are you going to start a company?", "আপনি কেন একটি কোম্পানি শুরু করতে যাচ্ছেন?", "হোয়াই আর ইউ গোয়িং টু স্টার্ট আ কোম্পানি?", "wh_question", "affirmative"),
    ("fut-p5-trans-006", "Why aren't you going to start a company?", "আপনি কেন একটি কোম্পানি শুরু করতে যাচ্ছেন না?", "হোয়াই আরন্ট ইউ গোয়িং টু স্টার্ট আ কোম্পানি?", "wh_question", "negative")
]

part5 = {
    "id": "fut-foundations-p5",
    "order": 5,
    "level": "A2",
    "title_bn": "পরিকল্পনা ও উদ্দেশ্য: Will vs Going To (Intentions & Near Future)",
    "title_target": "Future Intentions: Will vs Be Going To",
    "lessons": [
        {
            "id": "fut-p5-l15",
            "order": 1,
            "title_bn": "পূর্ব পরিকল্পনা ও প্রত্যক্ষ লক্ষণ (Be Going To + V1)",
            "title_target": "Prior Plans & Evidence: Be going to",
            "intro_bn": "আগে থেকেই নির্ধারিত পরিকল্পনা বা চোখের সামনের স্পষ্ট লক্ষণ দেখে ভবিষ্যৎ অনুমান করতে 'am/is/are + going to + V1' ব্যবহার করা হয়।",
            "structure": ["Subject + am/is/are + going to + V1", "Am/Is/Are + Subject + going to + V1...?"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_plan") for x in p5_l1]
        },
        {
            "id": "fut-p5-l16",
            "order": 2,
            "title_bn": "স্পোকেন পার্থক্য: Will বনাম Be Going To বনাম Continuous",
            "title_target": "Spoken Distinction: Will vs Going To vs Continuous",
            "intro_bn": "তাৎক্ষণিক সিদ্ধান্ত = Will; পূর্ব পরিকল্পনা = Going To; নির্দিষ্ট দিনক্ষণ সহ অ্যাপয়েন্টমেন্ট = Present Continuous; অফিসিয়াল রুটিন = Simple Present।",
            "structure": ["Will (Instant) vs Going to (Plan) vs Present Continuous (Arrangement)"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_comparison") for x in p5_l2]
        },
        {
            "id": "fut-p5-l17",
            "order": 3,
            "title_bn": "কথ্য স্পিড ড্রিল: Gonna Fluency Mastery",
            "title_target": "Fast Spoken English: Gonna Rhythm",
            "intro_bn": "অনানুষ্ঠানিক স্পোকেন ইংলিশে 'going to' দ্রুত উচ্চারণে 'gonna' /ɡənə/ হয়ে যায়। এটি নেটিভ স্পোকেন ছন্দের অপরিহার্য অংশ।",
            "structure": ["Subject + am/is/are + gonna + V1"],
            "items": [make_item(x[0], x[1], x[2], x[3], category="fluency_gonna", tense="future_plan") for x in p5_l3]
        },
        {
            "id": "fut-p5-l18",
            "order": 4,
            "title_bn": "পরিকল্পনার ৬ রূপান্তর ড্রিল (6-Pattern Drill: Going To)",
            "title_target": "6-Pattern Transformation: Be Going To",
            "intro_bn": "পরিকল্পনা ও সংকল্পবাচক বাক্যকে ৬টি ধরনে রূপান্তরের নিয়মিত স্পোকেন ড্রিল।",
            "structure": [
                "1. Affirmative: Subject + am/is/are going to...",
                "2. Negative: Subject + am/is/are not going to...",
                "3. Interrogative: Am/Is/Are + Subject + going to...?",
                "4. Interro-Neg: Aren't/Isn't + Subject + going to...?",
                "5. WH-Question: Why + am/is/are + Subject + going to...?",
                "6. WH-Negative: Why aren't/isn't + Subject + going to...?"
            ],
            "items": [make_item(x[0], x[1], x[2], x[3], sentence_type=x[4], polarity=x[5], category="transformation_drill", tense="future_plan") for x in p5_l4_trans]
        }
    ]
}

# ==============================================================================
# PART 6: Future Continuous & Polite Inquiries (Will be + V-ing)
# ==============================================================================
p6_l1 = [
    ("fut-p6-l1-001", "This time tomorrow, I will be flying to Bangkok.", "আগামীকাল এই সময়ে আমি ব্যাংককের উদ্দেশ্যে বিমানে উড়তে থাকব।", "দিস টাইম টুমরো, আই উইল বি ফ্লাইং টু ব্যাংকক।"),
    ("fut-p6-l1-002", "At eight o'clock tonight, she will be watching the final match.", "আজ রাত আটটায় তিনি ফাইনাল খেলাটি দেখতে থাকবেন।", "অ্যাট এইট ওক্লক টুনাইট, শি উইল বি ওয়াচিং দ্য ফাইনাল ম্যাচ।"),
    ("fut-p6-l1-003", "They will be working on the database when you arrive tomorrow.", "আপনি আগামীকাল যখন পৌঁছাবেন তারা তখন ডাটাবেজে কাজ করতে থাকবে।", "দে উইল বি ওয়ার্কিং অন দ্য ডাটাবেজ হোয়েন ইউ অ্যারাইভ টুমরো।"),
    ("fut-p6-l1-004", "We will be waiting for your car outside the departure terminal.", "আমরা ডিপার্চার টার্মিনালের বাইরে আপনার গাড়ির জন্য অপেক্ষা করতে থাকব।", "উই উইল বি ওয়েইটিং ফর ইয়োর কার আউটসাইড দ্য ডিপার্চার টার্মিনাল।"),
    ("fut-p6-l1-005", "He will be presenting the annual financial summary all afternoon.", "তিনি পুরো দুপুর জুড়ে বার্ষিক আর্থিক সারসংক্ষেপ উপস্থাপন করতে থাকবেন।", "হি উইল বি প্রেজেন্টিং দি অ্যানুয়াল ফিনান্সিয়াল সামারি অল আফটারনুন।"),
    ("fut-p6-l1-006", "Will you be sleeping when I call you tonight? No, I will be studying.", "আজ রাতে যখন কল করব আপনি কি ঘুমাতে থাকবেন? না, আমি পড়তে থাকব।", "উইল ইউ বি স্লিপিং হোয়েন আই কল ইউ টুনাইট? নো, আই উইল বি স্টাডিয়িং।"),
    ("fut-p6-l1-007", "Will they be staying at the Grand Hotel? Yes, they will be staying there.", "তারা কি গ্র্যান্ড হোটেলে অবস্থান করতে থাকবে? হ্যাঁ, তারা সেখানেই থাকবে।", "উইল দে বি স্টেয়িং অ্যাট দ্য গ্র্যান্ড হোটেল? ইয়েস, দে উইল বি স্টেয়িং দেয়ার।"),
    ("fut-p6-l1-008", "What will you be doing at ten tomorrow morning? I will be attending a lecture.", "আগামীকাল সকাল দশটায় আপনি কী করতে থাকবেন? আমি একটি লেকচারে অংশ নিতে থাকব।", "হোয়াট উইল ইউ বি ডুয়িং অ্যাট টেন টুমরো মর্নিং? আই উইল বি অ্যাটেন্ডিং আ লেকচার।")
]

p6_l2 = [
    ("fut-p6-l2-001", "Will you be using your laptop this afternoon?", "আপনি কি আজ বিকেলে আপনার ল্যাপটপটি ব্যবহার করতে থাকবেন? (বিনম্র প্রশ্ন)", "উইল ইউ বি ইউজিং ইয়োর ল্যাপটপ দিস আফটারনুন?"),
    ("fut-p6-l2-002", "Will you be passing by the pharmacy on your way home?", "বাড়ি ফেরার পথে আপনি কি ফার্মেসির পাশ দিয়ে যাবেন? (অনুরোধের প্রস্তুতি)", "উইল ইউ বি পাসিং বাই দ্য ফার্মেসি অন ইয়োর ওয়ে হোম?"),
    ("fut-p6-l2-003", "Will you be seeing Dr. Hasan tomorrow morning?", "আপনি কি আগামীকাল সকালে ডা. হাসানের সাথে দেখা করতে যাচ্ছেন?", "উইল ইউ বি সিয়িং ডক্টর হাসান টুমরো মর্নিং?"),
    ("fut-p6-l2-004", "Will you be driving to the supermarket tonight?", "আপনি কি আজ রাতে সুপারমার্কেটের দিকে গাড়ি চালিয়ে যাবেন?", "উইল ইউ বি ড্রাইভিং টু দ্য সুপারমার্কেট টুনাইট?"),
    ("fut-p6-l2-005", "No, I won't be needing the car; you can take it.", "না, আমার গাড়িটির প্রয়োজন হবে না; আপনি এটি নিতে পারেন।", "নো, আই ওন্ট বি নিডিং দ্য কার; ইউ ক্যান টেক ইট।"),
    ("fut-p6-l2-006", "Will you be cooking dinner tonight or ordering takeout?", "আপনি কি আজ রাতে রান্না করবেন নাকি খাবার অর্ডার করবেন?", "উইল ইউ বি কুকিং ডিনার টুনাইট অর অর্ডারিং টেকআউট?"),
    ("fut-p6-l2-007", "Won't you be joining us for the celebration? Yes, I will join later.", "আপনি কি উদযাপনে আমাদের সাথে যোগ দিচ্ছেন না? হ্যাঁ, আমি পরে যোগ দেব।", "ওন্ট ইউ বি জয়েনিং আস ফর দ্য সেলিব্রেশন? ইয়েস, আই উইল জয়েন লেটার।"),
    ("fut-p6-l2-008", "Where will you be heading after the meeting finishes?", "মিটিং শেষ হওয়ার পর আপনি কোন দিকে যাবেন?", "হোয়ার উইল ইউ বি হেডিং আফটার দ্য মিটিং ফিনিশেস?")
]

p6_l3_trans = [
    ("fut-p6-trans-001", "I will be reading.", "আমি পড়তে থাকব।", "আই উইল বি রিডিং।", "assertive", "affirmative"),
    ("fut-p6-trans-002", "I will not be reading.", "আমি পড়তে থাকব না।", "আই উইল নট বি রিডিং।", "assertive", "negative"),
    ("fut-p6-trans-003", "Will I be reading?", "আমি কি পড়তে থাকব?", "উইল আই বি রিডিং?", "interrogative", "affirmative"),
    ("fut-p6-trans-004", "Won't I be reading?", "আমি কি পড়তে থাকব না?", "ওন্ট আই বি রিডিং?", "interrogative", "negative"),
    ("fut-p6-trans-005", "What will I be reading?", "আমি কী পড়তে থাকব?", "হোয়াট উইল আই বি রিডিং?", "wh_question", "affirmative"),
    ("fut-p6-trans-006", "Why won't I be reading?", "আমি কেন পড়তে থাকব না?", "হোয়াই ওন্ট আই বি রিডিং?", "wh_question", "negative")
]

part6 = {
    "id": "fut-foundations-p6",
    "order": 6,
    "level": "A2",
    "title_bn": "ভবিষ্যৎ ঘটমান কাল ও শিষ্টাচার (Future Continuous: Will be + V-ing)",
    "title_target": "Future Continuous & Polite Inquiries",
    "lessons": [
        {
            "id": "fut-p6-l19",
            "order": 1,
            "title_bn": "ভবিষ্যতে কোনো নির্দিষ্ট সময়ে ঘটমান কাজ (Will be + V-ing)",
            "title_target": "Actions in Progress at a Future Time",
            "intro_bn": "ভবিষ্যতে কোনো নির্দিষ্ট মুহূর্তে কোনো কাজ চলতে থাকবে বোঝাতে 'Subject + will be + Verb-ing' ব্যবহৃত হয়।",
            "structure": ["Subject + will be + V-ing", "At [time] tomorrow, Subject + will be + V-ing"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_continuous") for x in p6_l1]
        },
        {
            "id": "fut-p6-l20",
            "order": 2,
            "title_bn": "বিনম্র ভবিষ্যৎ অনুসন্ধান (Polite Future Inquiries)",
            "title_target": "Polite Inquiries: Will you be + V-ing?",
            "intro_bn": "কাউকে কোনো অনুরোধ করার আগে তার পরিকল্পনা বিনম্রভাবে জানতে Spoken English এ 'Will you be using/going...?' ব্যবহার অত্যন্ত ভদ্র রীতি।",
            "structure": ["Will you be + V-ing + Object...?"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_continuous") for x in p6_l2]
        },
        {
            "id": "fut-p6-l21",
            "order": 3,
            "title_bn": "ঘটমান ভবিষ্যৎ রূপান্তর ড্রিল (6-Pattern Drill: Continuous)",
            "title_target": "6-Pattern Transformation: Future Continuous",
            "intro_bn": "ঘটমান ভবিষ্যৎ বাক্যকে দ্রুত ৬টি রূপে রূপান্তর করার অনুশীলন।",
            "structure": [
                "1. Affirmative: Subject + will be + V-ing...",
                "2. Negative: Subject + won't be + V-ing...",
                "3. Interrogative: Will + Subject + be + V-ing...?",
                "4. Interro-Neg: Won't + Subject + be + V-ing...?",
                "5. WH-Question: What/Where will + Subject + be + V-ing...?",
                "6. WH-Negative: Why won't + Subject + be + V-ing...?"
            ],
            "items": [make_item(x[0], x[1], x[2], x[3], sentence_type=x[4], polarity=x[5], category="transformation_drill", tense="future_continuous") for x in p6_l3_trans]
        }
    ]
}

# ==============================================================================
# PART 7: Future Modals & Intention: May, Might, Would like to, Hope to, Plan to
# ==============================================================================
p7_l1 = [
    ("fut-p7-l1-001", "It may rain this evening, so take an umbrella.", "আজ সন্ধ্যায় বৃষ্টি হতে পারে, তাই সাথে ছাতা নিন।", "ইট মে রেইন দিস ইভনিং, সো টেক অ্যান আমব্রেলা।"),
    ("fut-p7-l1-002", "She might join our startup team next quarter.", "তিনি আগামী প্রান্তিকে আমাদের স্টার্টআপ টিমে যোগ দিতে পারেন (সম্ভাবনা কম)।", "শি মাইট জয়েন আওয়ার স্টার্টআপ টিম নেক্সট কোয়ার্টার।"),
    ("fut-p7-l1-003", "They may not agree to these revised contract terms.", "তারা হয়তো এই সংশোধিত চুক্তি শর্তে সম্মত নাও হতে পারেন।", "দে মে নট অ্যাগ্রি টু দিজ রিভাইজড কন্ট্রাক্ট টার্মস।"),
    ("fut-p7-l1-004", "We might travel to Cox's Bazar if the weather improves.", "আবহাওয়া ভালো হলে আমরা কক্সবাজারে যেতেও পারি।", "উই মাইট ট্রাভেল টু কক্সবাজার ইফ দ্য ওয়েদার ইমপ্রুভস।"),
    ("fut-p7-l1-005", "He may be able to solve this technical bug today.", "তিনি হয়তো আজই এই কারিগরি ত্রুটিটি সমাধান করতে পারবেন।", "হি মে বি এবল টু সলভ দিস টেকনিক্যাল বাগ টুডে।"),
    ("fut-p7-l1-006", "May I speak with the managing director? Yes, please wait a moment.", "আমি কি ব্যবস্থাপনা পরিচালকের সাথে কথা বলতে পারি? হ্যাঁ, দয়া করে কিছুক্ষণ অপেক্ষা করুন।", "মে আই স্পিক উইথ দ্য ম্যানেজিং ডিরেক্টর? ইয়েস, প্লিজ ওয়েইট আ মোমেন্ট।"),
    ("fut-p7-l1-007", "Might it cause any permanent damage to the machine? No, it is safe.", "এতে কি মেশিনের স্থায়ী কোনো ক্ষতি হতে পারে? না, এটি নিরাপদ।", "মাইট ইট কজ এনি পারমানেন্ট ড্যামেজ টু দ্য মেশিন? নো, ইট ইজ সেফ।"),
    ("fut-p7-l1-008", "Where might we find original spare parts? You might find them in Motijheel.", "আমরা আসল খুচরা যন্ত্রাংশ কোথায় পেতে পারি? আপনি মতিঝিলে পেতে পারেন।", "হোয়ার মাইট উই ফাইন্ড অরিজিনাল স্পেয়ার পার্টস? ইউ মাইট ফাইন্ড দেম ইন মতিঝিল।")
]

p7_l2 = [
    ("fut-p7-l2-001", "I would like to order a cup of cappuccino, please.", "আমি এক কাপ ক্যাপুচিনো অর্ডার করতে চাই, প্লিজ।", "আই উড লাইক টু অর্ডার আ কাপ অব ক্যাপুচিনো, প্লিজ।"),
    ("fut-p7-l2-002", "She hopes to study artificial intelligence in Germany.", "তিনি জার্মানিতে কৃত্রিম বুদ্ধিমত্তা নিয়ে পড়াশোনা করার আশা করেন।", "শি হোপস টু স্টাডি আর্টিফিশিয়াল ইন্টেলিজেন্স ইন জার্মানি।"),
    ("fut-p7-l2-003", "We plan to inaugurate our new software office in June.", "আমরা জুনে আমাদের নতুন সফটওয়্যার অফিস উদ্বোধন করার পরিকল্পনা করছি।", "উই প্ল্যান টু ইনঅগুরেট আওয়ার নিউ সফটওয়্যার অফিস ইন জুন।"),
    ("fut-p7-l2-004", "He intends to complete his master's thesis by December.", "তিনি ডিসেম্বরের মধ্যে তার মাস্টার্স থিসিস সম্পন্ন করতে মনস্থির করেছেন।", "হি ইনটেন্ডস টু কমপ্লিট হিজ মাস্টার্স থিসিস বাই ডিসেম্বর।"),
    ("fut-p7-l2-005", "I expect to receive the official confirmation letter tomorrow.", "আমি আগামীকাল আনুষ্ঠানিক নিশ্চয়তা পত্রটি পাওয়ার প্রত্যাশা করছি।", "আই এক্সপেক্ট টু রিসিভ দি অফিশিয়াল কনফার্মেশন লেটার টুমরো।"),
    ("fut-p7-l2-006", "Would you like to come with us to the international book fair?", "আপনি কি আন্তর্জাতিক বইমেলায় আমাদের সাথে আসতে চান?", "উড ইউ লাইক টু কাম উইথ আস টু দি ইন্টারন্যাশনাল বুক ফেয়ার?"),
    ("fut-p7-l2-007", "Do you plan to stay in this city long-term? No, I plan to move.", "আপনি কি এই শহরে দীর্ঘমেয়াদে থাকার পরিকল্পনা করছেন? না, আমি স্থানান্তরের পরিকল্পনা করছি।", "ডু ইউ প্ল্যান টু স্টে ইন দিস সিটি লং-টার্ম? নো, আই প্ল্যান টু মুভ।"),
    ("fut-p7-l2-008", "What would you like to achieve in the next two years? I'd like to be fluent.", "আগামী দুই বছরে আপনি কী অর্জন করতে চান? আমি ইংরেজিতে সাবলীল হতে চাই।", "হোয়াট উড ইউ লাইক টু অ্যাচিভ ইন দ্য নেক্সট টু ইয়ার্স? আইড লাইক টু বি ফ্লুয়েন্ট।")
]

p7_l3_twisters = [
    ("fut-p7-twister-001", "Many mighty magicians may make marvelous magical moments.", "অনেক শক্তিশালী জাদুকর হয়তো বিস্ময়কর জাদুকরী মুহূর্ত তৈরি করতে পারেন।", "মেনি মাইটি ম্যাজিশিয়ানস মে মেক মারভেলাস ম্যাজিক্যাল মোমেন্টস।", "/m/ nasal & may/might modality"),
    ("fut-p7-twister-002", "Would Walter willingly walk with whimsical white wolves?", "ওয়াল্টার কি আনন্দের সাথে অদ্ভুত সাদা নেকড়েদের সাথে হাঁটতে চাইবেন?", "উড ওয়াল্টার উইলিংলি ওয়াক উইথ হুইমজিক্যাল হোয়াইট উলভস?", "/w/ and 'would like to' fluency"),
    ("fut-p7-twister-003", "Peter planned practical projects praising positive polite people.", "পিটার ইতিবাচক ভদ্র মানুষদের প্রশংসা করে বাস্তবসম্মত প্রকল্পের পরিকল্পনা করেছিলেন।", "পিটার প্ল্যান্ড প্র্যাকটিক্যাল প্রজেক্টস প্রেইজিং পজিটিভ পোলাইট পিপল।", "/p/ plosive & 'plan to' fluency")
]

part7 = {
    "id": "fut-foundations-p7",
    "order": 7,
    "level": "A2",
    "title_bn": "ভবিষ্যতের সম্ভাবনা, ইচ্ছা ও মোডাল টুইস্টার (Future Modals & Wishes)",
    "title_target": "Future Modals, Intentions & Fluency Drills",
    "lessons": [
        {
            "id": "fut-p7-l22",
            "order": 1,
            "title_bn": "ভবিষ্যতের সম্ভাবনা প্রকাশ (May / Might: 50% vs 30%)",
            "title_target": "Future Possibility: May / Might",
            "intro_bn": "ভবিষ্যতে কোনো কাজ নিশ্চিত না হয়ে সম্ভাবনা প্রকাশ করতে 'Subject + may/might + V1' ব্যবহৃত হয়। (May = ৫০% সম্ভাবনা, Might = ৩০% ক্ষীণ সম্ভাবনা)।",
            "structure": ["Subject + may/might + V1", "May I + V1...?"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_modal") for x in p7_l1]
        },
        {
            "id": "fut-p7-l23",
            "order": 2,
            "title_bn": "ভবিষ্যতের ইচ্ছা ও পরিকল্পনা (Would like to / Hope to / Plan to)",
            "title_target": "Wishes & Aspirations: Would like to / Hope to",
            "intro_bn": "ভদ্রভাবে ইচ্ছা প্রকাশ করতে 'Would like to' এবং ভবিষ্যতের আশা ও পরিকল্পনা ব্যক্ত করতে 'Hope to / Plan to / Intend to' Spoken English এ চমৎকার ভূমিকা রাখে।",
            "structure": ["Subject + would like to + V1", "Subject + hope/plan to + V1"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_intent") for x in p7_l2]
        },
        {
            "id": "fut-p7-l24",
            "order": 3,
            "title_bn": "মোডাল ও ইচ্ছা টাং টুইস্টার ড্রিল (Agility Drill)",
            "title_target": "Future Modals Tongue Twisters",
            "intro_bn": "May, Might, Would like to এবং Plan to এর দ্রুত ও স্পষ্ট উচ্চারণের স্পিড ড্রিল।",
            "structure": ["Tongue Twisters targeting /m/, /w/, /p/ with modal verbs"],
            "items": [make_item(x[0], x[1], x[2], x[3], sentence_type="tongue_twister", category="pronunciation", phoneme_focus=x[4], tense="future_modal") for x in p7_l3_twisters]
        }
    ]
}

# ==============================================================================
# PART 8: Future Perfect (Will have + V3) & Deadlines + 6-Pattern Transformations
# ==============================================================================
p8_l1 = [
    ("fut-p8-l1-001", "I will have completed this project by five o'clock tomorrow.", "আগামীকাল পাঁচটার মধ্যে আমি এই প্রকল্পটি সম্পন্ন করে ফেলব।", "আই উইল হ্যাভ কমপ্লিটেড দিস প্রজেক্ট বাই ফাইভ ওক্লক টুমরো।"),
    ("fut-p8-l1-002", "She will have graduated from university by the year 2028.", "২০২৮ সালের মধ্যে তিনি বিশ্ববিদ্যালয় থেকে স্নাতক সম্পন্ন করে ফেলবেন।", "শি উইল হ্যাভ গ্র্যাজুয়েটেড ফ্রম ইউনিভার্সিটি বাই দ্য ইয়ার টুয়েন্টি টুয়েন্টি এইট।"),
    ("fut-p8-l1-003", "They will have built the new bridge before next monsoon.", "আগামী বর্ষার আগেই তারা নতুন সেতুটি নির্মাণ করে ফেলবে।", "দে উইল হ্যাভ বিল্ট দ্য নিউ ব্রিজ বিফোর নেক্সট মনসুন।"),
    ("fut-p8-l1-004", "We will have reached the destination before sunset.", "সূর্যাস্তের আগেই আমরা গন্তব্যে পৌঁছে যাব।", "উই উইল হ্যাভ রিচড দ্য ডেস্টিনেশন বিফোর সানসেট।"),
    ("fut-p8-l1-005", "He will have saved enough funds by the time he retires.", "অবসর নেওয়ার সময় নাগাদ তিনি পর্যাপ্ত অর্থ সঞ্চয় করে ফেলবেন।", "হি উইল হ্যাভ সেইভড এনাফ ফান্ডস বাই দ্য টাইম হি রিটায়ার্স।"),
    ("fut-p8-l1-006", "Will you have finished the report before the manager arrives? Yes, I will have finished it.", "ম্যানেজার আসার আগেই কি আপনি প্রতিবেদনটি শেষ করে ফেলবেন? হ্যাঁ, আমি এটি শেষ করে ফেলব।", "উইল ইউ হ্যাভ ফিনিশড দ্য রিপোর্ট বিফোর দ্য ম্যানেজার অ্যারাইভস? ইয়েস, আই উইল হ্যাভ ফিনিশড ইট।"),
    ("fut-p8-l1-007", "Will they have published the admission circular by next Sunday? Yes, they will have.", "আগামী রবিবারের মধ্যে কি তারা ভর্তির বিজ্ঞপ্তি প্রকাশ করে ফেলবে? হ্যাঁ, তারা প্রকাশ করবে।", "উইল দে হ্যাভ পাবলিশড দি অ্যাডমিশন সার্কুলার বাই নেক্সট সানডে? ইয়েস, দে উইল হ্যাভ।"),
    ("fut-p8-l1-008", "What will you have accomplished by the end of this decade? I will have built my dream career.", "এই দশকের শেষ নাগাদ আপনি কী অর্জন করে ফেলবেন? আমি আমার স্বপ্নের ক্যারিয়ার গড়ে ফেলব।", "হোয়াট উইল ইউ হ্যাভ অ্যাকমপ্লিশড বাই দি এন্ড অব দিস ডেকেড? আই উইল হ্যাভ বিল্ট মাই ড্রিম ক্যারিয়ার।")
]

p8_l2_trans = [
    ("fut-p8-trans-001", "I will have finished the assignment.", "আমি অ্যাসাইনমেন্টটি শেষ করে ফেলব।", "আই উইল হ্যাভ ফিনিশড দি অ্যাসাইনমেন্ট।", "assertive", "affirmative"),
    ("fut-p8-trans-002", "I will not have finished the assignment.", "আমি অ্যাসাইনমেন্টটি শেষ করে ফেলব না।", "আই উইল নট হ্যাভ ফিনিশড দি অ্যাসাইনমেন্ট।", "assertive", "negative"),
    ("fut-p8-trans-003", "Will I have finished the assignment?", "আমি কি অ্যাসাইনমেন্টটি শেষ করে ফেলব?", "উইল আই হ্যাভ ফিনিশড দি অ্যাসাইনমেন্ট?", "interrogative", "affirmative"),
    ("fut-p8-trans-004", "Won't I have finished the assignment?", "আমি কি অ্যাসাইনমেন্টটি শেষ করে ফেলব না?", "ওন্ট আই হ্যাভ ফিনিশড দি অ্যাসাইনমেন্ট?", "interrogative", "negative"),
    ("fut-p8-trans-005", "When will I have finished the assignment?", "আমি কখন অ্যাসাইনমেন্টটি শেষ করে ফেলব?", "হোয়েন উইল আই হ্যাভ ফিনিশড দি অ্যাসাইনমেন্ট?", "wh_question", "affirmative"),
    ("fut-p8-trans-006", "Why won't I have finished the assignment?", "আমি কেন অ্যাসাইনমেন্টটি শেষ করে ফেলব না?", "হোয়াই ওন্ট আই হ্যাভ ফিনিশড দি অ্যাসাইনমেন্ট?", "wh_question", "negative")
]

part8 = {
    "id": "fut-foundations-p8",
    "order": 8,
    "level": "B1",
    "title_bn": "নির্দিষ্ট সময়ের মধ্যে সমাপ্তি ও ৬ রূপান্তর (Future Perfect: Will have + V3)",
    "title_target": "Future Perfect Actions & Deadlines",
    "lessons": [
        {
            "id": "fut-p8-l25",
            "order": 1,
            "title_bn": "ভবিষ্যতে কোনো নির্দিষ্ট সময়ের আগেই সম্পন্ন কাজ (Will have + V3)",
            "title_target": "Future Perfect: Will have + V3",
            "intro_bn": "ভবিষ্যতে কোনো নির্দিষ্ট সময়সীমা (By tomorrow, By 2030, Before...) এর মধ্যে কোনো কাজ শেষ হয়ে থাকবে বোঝাতে 'Subject + will have + V3' ব্যবহৃত হয়।",
            "structure": ["Subject + will have + V3 + by/before [time]", "Will + Subject + have + V3...?"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_perfect") for x in p8_l1]
        },
        {
            "id": "fut-p8-l26",
            "order": 2,
            "title_bn": "পুরাঘটিত ভবিষ্যৎ রূপান্তর ড্রিল (6-Pattern Drill: Future Perfect)",
            "title_target": "6-Pattern Transformation: Future Perfect",
            "intro_bn": "পুরাঘটিত ভবিষ্যৎ বাক্যকে দ্রুত ৬টি রূপে রূপান্তর করার অনুশীলন।",
            "structure": [
                "1. Affirmative: Subject + will have + V3...",
                "2. Negative: Subject + won't have + V3...",
                "3. Interrogative: Will + Subject + have + V3...?",
                "4. Interro-Neg: Won't + Subject + have + V3...?",
                "5. WH-Question: When will + Subject + have + V3...?",
                "6. WH-Negative: Why won't + Subject + have + V3...?"
            ],
            "items": [make_item(x[0], x[1], x[2], x[3], sentence_type=x[4], polarity=x[5], category="transformation_drill", tense="future_perfect") for x in p8_l2_trans]
        }
    ]
}

# ==============================================================================
# PART 9: Future Perfect Continuous (Will have been + V-ing)
# ==============================================================================
p9_l1 = [
    ("fut-p9-l1-001", "By next November, I will have been working in this tech firm for five years.", "আগামী নভেম্বরে এই প্রযুক্তি প্রতিষ্ঠানে আমার কাজ করার পাঁচ বছর পূর্ণ হবে।", "বাই নেক্সট নভেম্বর, আই উইল হ্যাভ বিন ওয়ার্কিং ইন দিস টেক ফার্ম ফর ফাইভ ইয়ার্স।"),
    ("fut-p9-l1-002", "She will have been living in Canada for two decades by next spring.", "আগামী বসন্তে তার কানাডায় বসবাসের বিশ বছর পূর্ণ হবে।", "শি উইল হ্যাভ বিন লিভিং ইন কানাডা ফর টু ডেকেডস বাই নেক্সট স্প্রিং।"),
    ("fut-p9-l1-003", "By midnight, the tireless rescue team will have been searching for twelve continuous hours.", "মধ্যরাত নাগাদ অক্লান্ত উদ্ধারকারী দল একটানা বারো ঘণ্টা ধরে অনুসন্ধান চালাতে থাকবে।", "বাই মিডনাইট, দ্য টায়ারলেস রেসকিউ টিম উইল হ্যাভ বিন সার্চিং ফর টুয়েলভ কন্টিনিউয়াস আওয়ার্স।"),
    ("fut-p9-l1-004", "When he graduates, he will have been studying medicine for six long years.", "তিনি যখন স্নাতক হবেন, তখন তার চিকিৎসাশাস্ত্রে পড়াশোনা করার দীর্ঘ ছয় বছর হবে।", "হোয়েন হি গ্র্যাজুয়েটস, হি উইল হ্যাভ বিন স্টাডিয়িং মেডিসিন ফর সিক্স লং ইয়ার্স।"),
    ("fut-p9-l1-005", "By the end of this tour, we will have been traveling across Asia for three full months.", "এই সফর শেষে আমরা পুরো তিন মাস ধরে এশিয়া জুড়ে ভ্রমণ করতে থাকব।", "বাই দি এন্ড অব দিস ট্যুর, উই উইল হ্যাভ বিন ট্রাভেলিং অ্যাক্রস এশিয়া ফর থ্রি ফুল মান্থস।"),
    ("fut-p9-l1-006", "Will you have been teaching here for ten years next month? Yes, I will have been teaching for a decade.", "আগামী মাসে কি এখানে আপনার শিক্ষকতার দশ বছর পূর্ণ হবে? হ্যাঁ, আমার এক দশক পূর্ণ হবে।", "উইল ইউ হ্যাভ বিন টিচিং হিয়ার ফর টেন ইয়ার্স নেক্সট মান্থ? ইয়েস, আই উইল হ্যাভ বিন টিচিং ফর আ ডেকেড।"),
    ("fut-p9-l1-007", "How long will you have been driving by the time we reach Bogura? About four hours.", "বগুড়া পৌঁছানোর সময় আপনি কতক্ষণ ধরে গাড়ি চালাতে থাকবেন? প্রায় চার ঘণ্টা।", "হাউ লং উইল ইউ হ্যাভ বিন ড্রাইভিং বাই দ্য টাইম উই রিচ বগুড়া? অ্যাবাউট ফোর আওয়ার্স।"),
    ("fut-p9-l1-008", "They won't have been practicing for very long when the mentor arrives.", "পরামর্শদাতা যখন পৌঁছাবেন তারা খুব বেশি সময় ধরে প্রাক্টিস করতে থাকবে না।", "দে ওন্ট হ্যাভ বিন প্র্যাকটিসিং ফর ভেরি লং হোয়েন দ্য মেন্টর অ্যারাইভস।")
]

part9 = {
    "id": "fut-foundations-p9",
    "order": 9,
    "level": "B1",
    "title_bn": "ভবিষ্যৎ পুরাঘটিত ঘটমান কাল (Future Perfect Continuous: Will have been + V-ing)",
    "title_target": "Future Perfect Continuous: Duration Milestones",
    "lessons": [
        {
            "id": "fut-p9-l27",
            "order": 1,
            "title_bn": "ভবিষ্যতে কোনো সময় পর্যন্ত কাজের স্থায়িত্বকাল (Will have been + V-ing)",
            "title_target": "Duration Leading Up to a Future Milestone",
            "intro_bn": "ভবিষ্যতের কোনো নির্দিষ্ট মুহূর্ত পর্যন্ত কোনো কাজ কত সময় ধরে চলতে থাকবে তা বোঝাতে 'Subject + will have been + Verb-ing + for [duration]' ব্যবহৃত হয়।",
            "structure": ["By [time], Subject + will have been + V-ing + for [duration]"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_perfect_continuous") for x in p9_l1]
        }
    ]
}

# ==============================================================================
# PART 10: Future Passive Voice (Will be + V3 / Going to be + V3)
# ==============================================================================
p10_l1 = [
    ("fut-p10-l1-001", "The new bridge will be inaugurated by the honorable Prime Minister next month.", "আগামী মাসে মাননীয় প্রধানমন্ত্রী কর্তৃক নতুন সেতুটি উদ্বোধন করা হবে।", "দ্য নিউ ব্রিজ উইল বি ইনঅগুরেটেড বাই দি অনারেবল প্রাইম মিনিস্টার নেক্সট মান্থ।"),
    ("fut-p10-l1-002", "All pending exam results will be published on the official website tomorrow.", "সমস্ত স্থগিত পরীক্ষার ফলাফল আগামীকাল অফিশিয়াল ওয়েবসাইটে প্রকাশ করা হবে।", "অল পেন্ডিং এক্সাম রেজাল্টস উইল বি পাবলিশড অন দি অফিশিয়াল ওয়েবসাইট টুমরো।"),
    ("fut-p10-l1-003", "The urgent software update will be installed automatically tonight.", "আজ রাতে স্বয়ংক্রিয়ভাবে জরুরি সফটওয়্যার আপডেট ইনস্টল করা হবে।", "দি আর্জেন্ট সফটওয়্যার আপডেট উইল বি ইনস্টলড অটোম্যাটিক্যালি টুনাইট।"),
    ("fut-p10-l1-004", "This old dilapidated building is going to be demolished next week.", "এই পুরানো জরাজীর্ণ ভবনটি আগামী সপ্তাহে ভেঙে ফেলা হতে যাচ্ছে।", "দিস ওল্ড ডিলাপিরেটেড বিল্ডিং ইজ গোয়িং টু বি ডিমলিশড নেক্সট উইক।"),
    ("fut-p10-l1-005", "Delicious dinner will be served to all guests at eight-thirty sharp.", "ঠিক সাড়ে আটটায় সকল অতিথির জন্য সুস্বাদু রাতের খাবার পরিবেশন করা হবে।", "ডেলিশাস ডিনার উইল বি সার্ভড টু অল গেস্টস অ্যাট এইট-থার্টি শার্প।"),
    ("fut-p10-l1-006", "Will the damaged highway be repaired before the rainy season? Yes, it will be repaired.", "বর্ষার আগেই কি ক্ষতিগ্রস্ত মহাসড়কটি মেরামত করা হবে? হ্যাঁ, এটি মেরামত করা হবে।", "উইল দ্য ড্যামেজড হাইওয়ে বি রিপেয়ার্ড বিফোর দ্য রেইনি সিজন? ইয়েস, ইট উইল বি রিপেয়ার্ড।"),
    ("fut-p10-l1-007", "Won't the winners be awarded at the grand ceremony? Yes, they will be awarded.", "বিজয়ীদের কি গ্র্যান্ড অনুষ্ঠানে পুরস্কৃত করা হবে না? হ্যাঁ, পুরস্কৃত করা হবে।", "ওন্ট দ্য উইনার্স বি অ্যাওয়ার্ডেড অ্যাট দ্য গ্র্যান্ড সেরিমনি? ইয়েস, দে উইল বি অ্যাওয়ার্ডেড।"),
    ("fut-p10-l1-008", "Where will the international summit be hosted next year? It will be hosted in Tokyo.", "আগামী বছর আন্তর্জাতিক সম্মেলনটি কোথায় আয়োজন করা হবে? এটি টোকিওতে আয়োজিত হবে।", "হোয়ার উইল দি ইন্টারন্যাশনাল সামিট বি হোস্টের নেক্সট ইয়ার? ইট উইল বি হোস্টের ইন টোকিও।")
]

part10 = {
    "id": "fut-foundations-p10",
    "order": 10,
    "level": "B1",
    "title_bn": "ভবিষ্যতের কর্মবাচ্য (Future Passive Voice: Will be + V3)",
    "title_target": "Future Passive Voice Structures",
    "lessons": [
        {
            "id": "fut-p10-l28",
            "order": 1,
            "title_bn": "ভবিষ্যতে কোনো কাজ সম্পন্ন হওয়া প্রকাশ (Will be + V3)",
            "title_target": "Future Passive: Will be + V3",
            "intro_bn": "ভবিষ্যতে কার দ্বারা কাজটি হচ্ছে তার চেয়ে কাজটি কী হচ্ছে তা গুরুত্বপূর্ণ হলে প্যাসিভ ভয়েস 'Subject + will be + V3' ব্যবহৃত হয়।",
            "structure": ["Object/Subject + will be + V3 + by...", "Will + Subject + be + V3...?"],
            "items": [make_item(x[0], x[1], x[2], x[3], tense="future_passive") for x in p10_l1]
        }
    ]
}

# ==============================================================================
# PART 11: Future Presentations & Goal Setting (Connected Spoken Narratives)
# ==============================================================================
p11_pres1 = [
    ("fut-p11-pres1-001", "Good morning, everyone. Today I'd like to share my schedule and plans for tomorrow.", "শুভ সকাল সবাইকে। আজ আমি আগামীকালের জন্য আমার সময়সূচি ও পরিকল্পনা শেয়ার করতে চাই।", "গুড মর্নিং, এভরিওয়ান। টুডে আইড লাইক টু শেয়ার মাই স্কেডিউল অ্যান্ড প্ল্যানস ফর টুমরো।"),
    ("fut-p11-pres1-002", "I will wake up early at six o'clock and go for a refreshing morning jog.", "আমি সকাল ছয়টায় ঘুম থেকে উঠব এবং সতেজকারী মর্নিং জগে যাব।", "আই উইল ওয়েক আপ আর্লি অ্যাট সিক্স ওক্লক অ্যান্ড গো ফর আ রিফ্রেশিং মর্নিং জগ।"),
    ("fut-p11-pres1-003", "After breakfast, I am going to review my team's project deliverables.", "সকালের নাস্তার পর আমি আমার দলের প্রকল্পের কাজের অগ্রগতি পর্যালোচনা করব।", "আফটার ব্রেকফাস্ট, আই অ্যাম গোয়িং টু রিভিউ মাই টিমস প্রজেক্ট ডেলিভারেবলস।"),
    ("fut-p11-pres1-004", "At two in the afternoon, I will be attending an important strategy meeting with international clients.", "দুপুর দুইটায় আমি আন্তর্জাতিক ক্লায়েন্টদের সাথে একটি গুরুত্বপূর্ণ কৌশলগত মিটিংয়ে অংশ নিতে থাকব।", "অ্যাট টু ইন দি আফটারনুন, আই উইল বি অ্যাটেন্ডিং অ্যান ইম্পরট্যান্ট স্ট্র্যাটেজি মিটিং উইথ ইন্টারন্যাশনাল ক্লায়েন্টস।"),
    ("fut-p11-pres1-005", "By evening, I will have finished all priority tasks and I'll spend quality time with my loving family.", "সন্ধ্যার মধ্যে আমি সব অগ্রাধিকার কাজ শেষ করে ফেলব এবং আমার প্রিয় পরিবারের সাথে চমৎকার সময় কাটাব।", "বাই ইভনিং, আই উইল হ্যাভ ফিনিশড অল প্রায়োরিটি টাস্কস অ্যান্ড আইল স্পেন্ড কোয়ালিটি টাইম উইথ মাই লাভিং ফ্যামিলি।")
]

p11_pres2 = [
    ("fut-p11-pres2-001", "Hello honorable audience, I am excited to present my five-year career vision today.", "হ্যালো সম্মানিত দর্শকবৃন্দ, আজ আমার পাঁচ বছরের ক্যারিয়ার লক্ষ্য ও পরিকল্পনা উপস্থাপন করতে পেরে আমি আনন্দিত।", "হ্যালো অনারেবল অডিয়েন্স, আই অ্যাম এক্সাইটেড টু প্রেজেন্ট মাই ফাইভ-ইয়ার ক্যারিয়ার ভিশন টুডে।"),
    ("fut-p11-pres2-002", "In the next two years, I will master advanced full-stack software development and AI engineering.", "আগামী দুই বছরে আমি উন্নত ফুল-স্ট্যাক সফটওয়্যার ডেভেলপমেন্ট ও এআই ইঞ্জিনিয়ারিংয়ে দক্ষতা অর্জন করব।", "ইন দ্য নেক্সট টু ইয়ার্স, আই উইল মাস্টার অ্যাডভান্সড ফুল-স্ট্যাক সফটওয়্যার ডেভেলপমেন্ট অ্যান্ড এআই ইঞ্জিনিয়ারিং।"),
    ("fut-p11-pres2-003", "I hope to establish an innovative educational technology platform that will empower millions of rural learners.", "আমি একটি উদ্ভাবনী এডুকেশনাল টেকনোলজি প্ল্যাটফর্ম প্রতিষ্ঠা করতে চাই যা লক্ষ লক্ষ গ্রামীণ শিক্ষার্থীকে ক্ষমতায়িত করবে।", "আই হোপ টু এস্টাবলিশ অ্যান ইনোভেটিভ এডুকেশনাল টেকনোলজি প্ল্যাটফর্ম দ্যাট উইল এমপাওয়ার মিলিয়নস অব রুরাল লার্নার্স।"),
    ("fut-p11-pres2-004", "By 2030, our team will have built world-class open educational resources for everyone.", "২০৩০ সালের মধ্যে আমাদের দল সবার জন্য বিশ্বমানের উন্মুক্ত শিক্ষামূলক রিসোর্স তৈরি করে ফেলবে।", "বাই টুয়েন্টি থার্টি, আওয়ার টিম উইল হ্যাভ বিল্ট ওয়ার্ল্ড-ক্লাস ওপেন এডুকেশনাল রিসোর্সেস ফর এভরিওয়ান।"),
    ("fut-p11-pres2-005", "Through hard work, perseverance, and dedication, I believe we will definitely achieve our glorious dream.", "কঠোর পরিশ্রম, অধ্যবসায় এবং নিবেদনের মাধ্যমে আমি বিশ্বাস করি আমরা অবশ্যই আমাদের গৌরবময় স্বপ্ন অর্জন করব।", "থ্রু হার্ড ওয়ার্ক, পারসিভিয়ারেন্স, অ্যান্ড ডেডিকেশন, আই বিলিভ উই উইল ডেফিনিটলি অ্যাচিভ আওয়ার গ্লোরিয়াস ড্রিম।")
]

part11 = {
    "id": "fut-foundations-p11",
    "order": 11,
    "level": "B1",
    "title_bn": "ভবিষ্যতের লক্ষ্য, স্বপ্ন ও উপস্থাপনা (Future Presentations & Goal Setting)",
    "title_target": "Future Presentations & Visionary Speeches",
    "lessons": [
        {
            "id": "fut-p11-l29",
            "order": 1,
            "title_bn": "উপস্থাপনা ১: আগামীকালের রুটিন ও কর্মপরিকল্পনা (My Plans for Tomorrow)",
            "title_target": "Presentation 1: My Schedule & Plans for Tomorrow",
            "intro_bn": "আগামীকালের দৈনন্দিন পরিকল্পনা ধারাবাহিকভাবে বর্ণনা করার সাবলীল স্পোকেন উপস্থাপনা। বিভিন্ন ধরনের ভবিষ্যৎ বাক্য (Will, Going to, Will be doing, Will have done) ব্যবহার করে সাবলীল বক্তব্য তৈরি করুন।",
            "structure": ["Connected Future Narrative with time transitions"],
            "items": [make_item(x[0], x[1], x[2], x[3], sentence_type="presentation", category="presentation_narrative", tense="future_various") for x in p11_pres1]
        },
        {
            "id": "fut-p11-l30",
            "order": 2,
            "title_bn": "উপস্থাপনা ২: আমার ৫ বছরের ক্যারিয়ার ভিশন ও স্বপ্ন (My 5-Year Career Vision)",
            "title_target": "Presentation 2: My 5-Year Career Vision & Dreams",
            "intro_bn": "জীবনের ভবিষ্যৎ স্বপ্ন, উচ্চাকাঙ্ক্ষা ও লক্ষ্য স্পষ্ট ও প্রত্যয়ী ভাষায় প্রকাশ করার অনুপ্রেরণামূলক স্পোকেন প্রেজেন্টেশন।",
            "structure": ["Visionary Presentation with future goals, modals, and milestones"],
            "items": [make_item(x[0], x[1], x[2], x[3], sentence_type="presentation", category="presentation_narrative", tense="future_various") for x in p11_pres2]
        }
    ]
}

# ==============================================================================
# PART 12: Future Interactive Voice Pair Practice (20 Speech Evaluation Items)
# ==============================================================================
p12_pairs = [
    (1, "Will you join us for lunch today?", "আপনি কি আজ আমাদের সাথে দুপুরের খাবারে যোগ দেবেন?", "উইল ইউ জয়েন আস ফর লাঞ্চ টুডে?",
     "Yes, I will gladly join you for lunch.", "No, I have some urgent work to finish."),
    (2, "Will you call me tonight?", "আপনি কি আজ রাতে আমাকে কল করবেন?", "উইল ইউ কল মি টুনাইট?",
     "Yes, I will call you after eight.", "No, I will be very busy tonight."),
    (3, "Are you going to buy that laptop?", "আপনি কি সেই ল্যাপটপটি কিনতে যাচ্ছেন?", "আর ইউ গোয়িং টু বাই দ্যাট ল্যাপটপ?",
     "Yes, I am going to buy it tomorrow.", "No, it is too expensive for me."),
    (4, "Will he attend the meeting tomorrow?", "তিনি কি আগামীকাল মিটিংয়ে উপস্থিত থাকবেন?", "উইল হি অ্যাটেন্ড দ্য মিটিং টুমরো?",
     "Yes, he will attend on time.", "No, he is on casual leave tomorrow."),
    (5, "Will they complete the task by five?", "তারা কি পাঁচটার মধ্যে কাজটি শেষ করবে?", "উইল দে কমপ্লিট দ্য টাস্ক বাই ফাইভ?",
     "Yes, they will easily complete it.", "No, they will need more time."),
    (6, "Are you gonna start exercising regularly?", "আপনি কি নিয়মিত ব্যায়াম শুরু করতে যাচ্ছেন?", "আর ইউ গনা স্টার্ট এক্সারসাইজিং রেগুলারলি?",
     "Yes, I am gonna start from tomorrow.", "No, I don't have enough free time."),
    (7, "Will you be at home this Sunday?", "এই রবিবারে আপনি কি বাড়িতে থাকবেন?", "উইল ইউ বি অ্যাট হোম দিস সানডে?",
     "Yes, I will be at home all day.", "No, I will visit my hometown."),
    (8, "Will she be angry if we are late?", "আমাদের দেরি হলে তিনি কি রাগ করবেন?", "উইল শি বি অ্যাংরি ইফ উই আর লেইট?",
     "Yes, she will definitely be upset.", "No, she is very understanding."),
    (9, "Will you help me clean the room?", "ঘর পরিষ্কার করতে আপনি কি আমাকে সাহায্য করবেন?", "উইল ইউ হেল্প মি ক্লিন দ্য রুম?",
     "Yes, I will gladly help you.", "No, I am feeling a bit sick today."),
    (10, "Will you be working tomorrow morning?", "আগামীকাল সকালে আপনি কি কাজ করতে থাকবেন?", "উইল ইউ বি ওয়ার্কিং টুমরো মর্নিং?",
     "Yes, I will be working in the office.", "No, tomorrow is my official day off."),
    (11, "Will you be using the computer tonight?", "আজ রাতে আপনি কি কম্পিউটার ব্যবহার করতে থাকবেন?", "উইল ইউ বি ইউজিং দ্য কম্পিউটার টুনাইট?",
     "Yes, I will be writing my report.", "No, you can freely use it."),
    (12, "May I borrow your pen for a moment?", "আমি কি আপনার কলমটি এক মুহূর্তের জন্য ধার পেতে পারি?", "মে আই বরো ইয়োর পেন ফর আ মোমেন্ট?",
     "Yes, sure! Here you go.", "No, sorry, this is my only pen."),
    (13, "Might it rain this afternoon?", "আজ বিকেলে কি বৃষ্টি হতে পারে?", "মাইট ইট রেইন দিস আফটারনুন?",
     "Yes, it might rain heavily.", "No, the sky is completely clear."),
    (14, "Would you like a cup of green tea?", "আপনি কি এক কাপ গ্রিন টি নিতে চান?", "উড ইউ লাইক আ কাপ অব গ্রিন টি?",
     "Yes, I'd love a cup of green tea.", "No, thanks, I just had water."),
    (15, "Do you plan to learn spoken English?", "আপনি কি স্পোকেন ইংলিশ শেখার পরিকল্পনা করছেন?", "ডু ইউ প্ল্যান টু লার্ন স্পোকেন ইংলিশ?",
     "Yes, I plan to practice daily.", "No, I am focusing on other skills."),
    (16, "Will you have finished the work by Monday?", "সোমবারের মধ্যে কি আপনি কাজটি শেষ করে ফেলবেন?", "উইল ইউ হ্যাভ ফিনিশড দ্য ওয়ার্ক বাই মান্ডে?",
     "Yes, I will have finished everything.", "No, I won't have finished by then."),
    (17, "Will you have reached Dhaka before dark?", "অন্ধকার হওয়ার আগেই কি আপনি ঢাকায় পৌঁছে যাবেন?", "উইল ইউ হ্যাভ রিচড ঢাকা বিফোর ডার্ক?",
     "Yes, I will have arrived by 5 PM.", "No, the traffic will delay my trip."),
    (18, "Will the result be published tomorrow?", "আগামীকাল কি ফলাফল প্রকাশ করা হবে?", "উইল দ্য রেজাল্ট বি পাবলিশড টুমরো?",
     "Yes, it will be published at noon.", "No, it will be delayed till Friday."),
    (19, "Won't you join the study group?", "আপনি কি স্টাডি গ্রুপে যোগ দেবেন না?", "ওন্ট ইউ জয়েন দ্য স্টাডি গ্রুপ?",
     "Yes, I will definitely join the group.", "No, I prefer studying alone."),
    (20, "Will you be free next Friday?", "আগামী শুক্রবারে আপনি কি ফ্রি থাকবেন?", "উইল ইউ বি ফ্রি নেক্সট ফ্রাইডে?",
     "Yes, I will be completely free.", "No, I will attend a family wedding.")
]

p12_items = []
for idx, q, q_bn, q_pron, yes_a, no_a in p12_pairs:
    tokens = [{"t": w, "bn": ""} for w in q.split()]
    item_obj = {
        "id": f"fut-p12-pair-{idx:03d}",
        "concept_id": f"c-fut-p12-pair-{idx:03d}",
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
            "tense": "future"
        },
        "example": {
            "target": yes_a,
            "bn": no_a
        },
        "status": "reviewed",
        "reviewFlags": ""
    }
    p12_items.append(item_obj)

part12 = {
    "id": "fut-foundations-p12",
    "order": 12,
    "level": "A2",
    "title_bn": "ভবিষ্যৎ কাল ভয়েস পেয়ার প্র্যাকটিস (Future Voice Q&A Practice)",
    "title_target": "Future Tense Interactive Voice Practice",
    "lessons": [
        {
            "id": "fut-p12-l31",
            "order": 1,
            "title_bn": "ভবিষ্যৎ কাল ভয়েস পেয়ার প্র্যাকটিস (Voice Q&A Practice)",
            "title_target": "Future Tense Interactive Voice Practice",
            "intro_bn": "মাইক্রোফোনে ট্যাপ করে ভবিষ্যৎ প্রশ্ন শুনুন এবং সাবলীল ইংরেজিতে উত্তর দিন। হ্যাঁ-বোধক উত্তর 'Yes' দিয়ে এবং না-বোধক উত্তর 'No' দিয়ে শুরু করুন। আমাদের এআই সিস্টেম আপনার উচ্চারণ, স্বরভঙ্গি ও ভবিষ্যৎ রূপ (Will / Won't / Going to) সঠিকতা মূল্যায়ন করবে।",
            "structure": [
                "Question: Will you + V1...? / Are you going to + V1...? / Would you like...?",
                "Yes Answer: Yes, I will + V1... / Yes, I am going to...",
                "No Answer: No, I won't + V1... / No, I am not..."
            ],
            "items": p12_items
        }
    ]
}

all_parts = [part1, part2, part3, part4, part5, part6, part7, part8, part9, part10, part11, part12]

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

print(f"Successfully generated Future Tense Masterclass in {DEST_FILE}!")
print(f"Total parts: {len(all_parts)}")
print(f"Total lessons: {total_lessons}")
print(f"Total items: {total_items}")
