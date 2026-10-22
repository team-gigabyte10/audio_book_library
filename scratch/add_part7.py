import json
import sys

sys.stdout.reconfigure(encoding='utf-8')

FILE_PATH = 'android/app/src/main/assets/spoken_english_foundations.json'

data = json.load(open(FILE_PATH, encoding='utf-8'))

# Remove existing Part 7 if any
data['parts'] = [p for p in data['parts'] if p['id'] != 'en-foundations-p7']

lessons_def = [
    {
        "id": "en-foundations-l40",
        "order": 1,
        "title_bn": "এখন কী করছি ও কী চলছে (Affirmative: am/is/are + V-ing)",
        "title_target": "Actions Happening Now (am/is/are + V-ing)",
        "intro_bn": "এই মুহূর্তে কোনো কাজ চলমান বা চলিতেছে বোঝাতে Present Continuous Tense ব্যবহৃত হয়। গঠন: Subject + am / is / are + Verb-ing। যেমন: I am reading, She is writing।",
        "structure": ["Subject + am / is / are + Verb-ing + Extension"],
        "items": [
            ("en-p7-l40-001", "I am reading an interesting book right now.", "আমি এই মুহূর্তে একটি মজার বই পড়ছি।", "আই অ্যাম রিডিং অ্যান ইন্টারেস্টিং বুক রাইট নাও।"),
            ("en-p7-l40-002", "She is writing an email to her manager.", "তিনি তার ম্যানেজারের কাছে একটি ইমেইল লিখছেন।", "শি ইজ রাইটিং অ্যান ইমেইল টু হার ম্যানেজার।"),
            ("en-p7-l40-003", "He is driving his car to the office.", "সে অফিসের দিকে গাড়ি চালিয়ে যাচ্ছে।", "হি ইজ ড্রাইভিং হিজ কার টু দি অফিস।"),
            ("en-p7-l40-004", "They are watching a cricket match on television.", "তারা টেলিভিশনে ক্রিকেট ম্যাচ দেখছে।", "দে আর ওয়াচিং আ ক্রিকেট ম্যাচ অন টেলিভিশন।"),
            ("en-p7-l40-005", "We are learning spoken English together.", "আমরা একসাথে স্পোকেন ইংলিশ শিখছি।", "উই আর লার্নিং স্পোকেন ইংলিশ টুগেদার।"),
            ("en-p7-l40-006", "It is raining heavily outside.", "বাইরে খুব জোরে বৃষ্টি হচ্ছে।", "ইট ইজ রেইনিং হেভিলি আউটসাইড।"),
            ("en-p7-l40-007", "My mother is cooking dinner in the kitchen.", "আমার মা রান্নাঘরে রাতের খাবার রান্না করছেন।", "মাই মাদার ইজ কুকিং ডিনার ইন দ্য কিচেন।"),
            ("en-p7-l40-008", "The train is arriving at the platform.", "ট্রেনটি প্ল্যাটফর্মে প্রবেশ করছে।", "দ্য ট্রেন ইজ অ্যারাইভিং অ্যাট দ্য প্ল্যাটফর্ম।"),
            ("en-p7-l40-009", "The children are playing in the garden.", "বাচ্চারা বাগানে খেলা করছে।", "দ্য চিলড্রেন আর প্লেয়িং ইন দ্য গার্ডেন।"),
            ("en-p7-l40-010", "I am listening to an English podcast.", "আমি একটি ইংরেজি পডকাস্ট শুনছি।", "আই অ্যাম লিসেনিং টু অ্যান ইংলিশ পডকাস্ট।")
        ]
    },
    {
        "id": "en-foundations-l41",
        "order": 2,
        "title_bn": "চলমান না-বোধক বাক্য — 'Isn't' ও 'Aren't' (Negative Continuous)",
        "title_target": "Negative Actions (Isn't & Aren't + V-ing)",
        "intro_bn": "বর্তমানে কোনো কাজ হচ্ছে না বা চলছে না বোঝাতে am not / isn't / aren't + Verb-ing বসে। সংক্ষেপে: is not = isn't, are not = aren't।",
        "structure": [
            "I + am not + Verb-ing",
            "He / She / It + isn't + Verb-ing",
            "We / You / They + aren't + Verb-ing"
        ],
        "items": [
            ("en-p7-l41-001", "I am not wasting my precious time.", "আমি আমার মূল্যবান সময় অপচয় করছি না।", "আই অ্যাম নট ওয়েস্টিং মাই প্রেশাস টাইম।"),
            ("en-p7-l41-002", "He isn't sleeping, he is working.", "সে ঘুমাচ্ছে না, সে কাজ করছে।", "হি ইজন্ট স্লিপিং, হি ইজ ওয়ার্কিং।"),
            ("en-p7-l41-003", "She isn't watching television at this moment.", "তিনি এই মুহূর্তে টেলিভিশন দেখছেন না।", "শি ইজন্ট ওয়াচিং টেলিভিশন অ্যাট দিজ মোমেন্ট।"),
            ("en-p7-l41-004", "They aren't playing in the field today.", "তারা আজ মাঠে খেলছে না।", "দে আরন্ট প্লেয়িং ইন দ্য ফিল্ড টুডে।"),
            ("en-p7-l41-005", "We aren't going outside right now.", "আমরা এই মুহূর্তে বাইরে যাচ্ছি না।", "উই আরন্ট গোয়িং আউটসাইড রাইট নাও।"),
            ("en-p7-l41-006", "It isn't raining anymore outside.", "বাইরে আর বৃষ্টি হচ্ছে না।", "ইট ইজন্ট রেইনিং অ্যানিমোর আউটসাইড।"),
            ("en-p7-l41-007", "I am not joking with you, I am serious.", "আমি আপনার সাথে মজা করছি না, আমি গুরুত্ব সহকারে বলছি।", "আই অ্যাম নট জোকিং উইথ ইউ, আই অ্যাম সিরিয়াস।"),
            ("en-p7-l41-008", "He isn't using his mobile phone.", "সে তার মোবাইল ফোন ব্যবহার করছে না।", "হি ইজন্ট ইউজিং হিজ মোবাইল ফোন।"),
            ("en-p7-l41-009", "The bus isn't moving because of the traffic.", "যানজটের কারণে বাসটি চলছে না।", "দ্য বাস ইজন্ট মুভিং বিকজ অব দ্য ট্রাফিক।"),
            ("en-p7-l41-010", "She isn't attending the class today.", "তিনি আজ ক্লাসে উপস্থিত হচ্ছেন না।", "শি ইজন্ট অ্যাটেন্ডিং দ্য ক্লাস টুডে।")
        ]
    },
    {
        "id": "en-foundations-l42",
        "order": 3,
        "title_bn": "তাৎক্ষণিক প্রশ্নোত্তর ড্রিল — 'Am / Is / Are...?' (Yes/No Q&A)",
        "title_target": "Real-time Q&A Drills (Am / Is / Are + V-ing)",
        "intro_bn": "কেউ বর্তমানে কোনো কাজ করছে কি না তা জানতে Am/Is/Are কে বাক্যের শুরুতে এনে প্রশ্ন করা হয়। হ্যাঁ এবং না উভয় উত্তরের স্পোকেন ড্রিল অনুশীলন করুন।",
        "structure": [
            "Are you + Verb-ing? -> Yes, I am ... / No, I am not ...",
            "Is he / she + Verb-ing? -> Yes, is ... / No, isn't ..."
        ],
        "items": [
            ("en-p7-l42-001", "Are you listening to me? Yes, I am listening to you. No, I am not listening to you.", "আপনি কি আমার কথা শুনছেন? হ্যাঁ, আমি আপনার কথা শুনছি। না, আমি আপনার কথা শুনছি না।", "আর ইউ লিসেনিং টু মি? ইয়েস, আই অ্যাম লিসেনিং টু ইউ। নো, আই অ্যাম নট লিসেনিং টু ইউ।"),
            ("en-p7-l42-002", "Are you waiting for someone? Yes, I am waiting for someone. No, I am not waiting for anyone.", "আপনি কি কারো জন্য অপেক্ষা করছেন? হ্যাঁ, আমি কারো জন্য অপেক্ষা করছি। না, আমি কারো জন্য অপেক্ষা করছি না।", "আর ইউ ওয়েটিং ফর সামওয়ান? ইয়েস, আই অ্যাম ওয়েটিং ফর সামওয়ান। নো, আই অ্যাম নট ওয়েটিং ফর অ্যানিওয়ান।"),
            ("en-p7-l42-003", "Is he working right now? Yes, he is working right now. No, he isn't working right now.", "সে কি এই মুহূর্তে কাজ করছে? হ্যাঁ, সে এই মুহূর্তে কাজ করছে। না, সে এই মুহূর্তে কাজ করছে না।", "ইজ হি ওয়ার্কিং রাইট নাও? ইয়েস, হি ইজ ওয়ার্কিং রাইট নাও। নো, হি ইজন্ট ওয়ার্কিং রাইট নাও।"),
            ("en-p7-l42-004", "Is she cooking in the kitchen? Yes, she is cooking. No, she isn't cooking.", "তিনি কি রান্নাঘরে রান্না করছেন? হ্যাঁ, তিনি রান্না করছেন। না, তিনি রান্না করছেন না।", "ইজ শি কুকিং ইন দ্য কিচেন? ইয়েস, শি ইজ কুকিং। নো, শি ইজন্ট কুকিং।"),
            ("en-p7-l42-005", "Are they coming to the party? Yes, they are coming. No, they aren't coming.", "তারা কি অনুষ্ঠানে আসছে? হ্যাঁ, তারা আসছে। না, তারা আসছে না।", "আর দে কামিং টু দ্য পার্টি? ইয়েস, দে আর কামিং। নো, দে আরন্ট কামিং।"),
            ("en-p7-l42-006", "Is it raining outside? Yes, it is raining outside. No, it isn't raining outside.", "বাইরে কি বৃষ্টি হচ্ছে? হ্যাঁ, বাইরে বৃষ্টি হচ্ছে। না, বাইরে বৃষ্টি হচ্ছে না।", "ইজ ইট রেইনিং আউটসাইড? ইয়েস, ইট ইজ রেইনিং আউটসাইড। নো, ইট ইজন্ট রেইনিং আউটসাইড।"),
            ("en-p7-l42-007", "Are you feeling comfortable here? Yes, I am feeling comfortable. No, I am not feeling comfortable.", "আপনার কি এখানে আরাম লাগছে? হ্যাঁ, আমার আরাম লাগছে। না, আমার আরাম লাগছে না।", "আর ইউ ফিলিং কমফোর্টেবল হিয়ার? ইয়েস, আই অ্যাম ফিলিং কমফোর্টেবল। নো, আই অ্যাম নট ফিলিং কমফোর্টেবল।"),
            ("en-p7-l42-008", "Is your brother studying in his room? Yes, he is studying. No, he isn't studying.", "আপনার ভাই কি তার ঘরে পড়াশোনা করছে? হ্যাঁ, সে পড়াশোনা করছে। না, সে পড়াশোনা করছে না।", "ইজ ইয়োর ব্রাদার স্টাডিইং ইন হিজ রুম? ইয়েস, হি ইজ স্টাডিইং। নো, হি ইজন্ট স্টাডিইং।")
        ]
    },
    {
        "id": "en-foundations-l43",
        "order": 4,
        "title_bn": "চলমান তথ্যমূলক প্রশ্ন — 'What are you doing?' (Wh- Continuous)",
        "title_target": "Wh- Questions in Present Continuous",
        "intro_bn": "কেউ বর্তমানে কী করছে, কোথায় যাচ্ছে বা কার সাথে কথা বলছে তা জানতে Wh-word + am/is/are + Subject + Verb-ing? ব্যবহার করা হয়। দৈনন্দিন ফোন কল ও আড্ডায় এই প্রশ্নগুলো সবচেয়ে বেশি কাজে লাগে।",
        "structure": ["Wh-word (What/Where/Who/Why/How) + am / is / are + Subject + Verb-ing?"],
        "items": [
            ("en-p7-l43-001", "What are you doing right now? I am preparing my office presentation.", "আপনি এই মুহূর্তে কী করছেন? আমি আমার অফিসের প্রেজেন্টেশন তৈরি করছি।", "হোয়াট আর ইউ ডুইং রাইট নাও? আই অ্যাম প্রিপেয়ারিং মাই অফিস প্রেজেন্টেশন।"),
            ("en-p7-l43-002", "Where are you going now? I am going to the supermarket.", "আপনি এখন কোথায় যাচ্ছেন? আমি সুপারমার্কেটে যাচ্ছি।", "হোয়ার আর ইউ গোয়িং নাও? আই অ্যাম গোয়িং টু দ্য সুপারমার্কেট।"),
            ("en-p7-l43-003", "Who are you talking to on the phone? I am talking to my close friend.", "আপনি ফোনে কার সাথে কথা বলছেন? আমি আমার ঘনিষ্ঠ বন্ধুর সাথে কথা বলছি।", "হু আর ইউ টকিং টু অন দ্য ফোন? আই অ্যাম টকিং টু মাই ক্লোজ ফ্রেন্ড।"),
            ("en-p7-l43-004", "Why are you laughing so loudly? I am laughing because of a funny video.", "আপনি এত জোরে হাসছেন কেন? আমি একটি মজার ভিডিও দেখে হাসছি।", "হোয়াই আর ইউ লাফিং সো লাউডলি? আই অ্যাম লাফিং বিকজ অব আ ফানি ভিডিও।"),
            ("en-p7-l43-005", "What is he looking for under the table? He is looking for his car keys.", "সে টেবিলের নিচে কী খুঁজছে? সে তার গাড়ির চাবি খুঁজছে।", "হোয়াট ইজ হি লুকিং ফর আন্ডার দ্য টেবিল? হি ইজ লুকিং ফর হিজ কার কিজ।"),
            ("en-p7-l43-006", "What are they discussing in the meeting? They are discussing the new project proposal.", "তারা মিটিংয়ে কী নিয়ে আলোচনা করছে? তারা নতুন প্রকল্পের প্রস্তাব নিয়ে আলোচনা করছে।", "হোয়াট আর দে ডিসকাসিং ইন দ্য মিটিং? দে আর ডিসকাসিং দ্য নিউ প্রজেক্ট প্রপোজাল।"),
            ("en-p7-l43-007", "How are you feeling right now? I am feeling much better now.", "আপনার এখন কেমন লাগছে? আমার এখন অনেক ভালো লাগছে।", "হাউ আর ইউ ফিলিং রাইট নাও? আই অ্যাম ফিলিং মাচ বেটার নাও।"),
            ("en-p7-l43-008", "Where is she staying in London? She is staying with her elder sister.", "তিনি লন্ডনে কোথায় থাকছেন? তিনি তার বড় বোনের সাথে থাকছেন।", "হোয়ার ইজ শি স্টেয়িং ইন লন্ডন? শি ইজ স্টেয়িং উইথ হার এল্ডার সিস্টার।")
        ]
    }
]

part7_lessons = []
for l in lessons_def:
    lesson_items = []
    for item_id, target, bn, bn_pron in l["items"]:
        words = target.replace("?", "").replace(".", "").replace(",", "").split()
        tokens = [{"t": w, "bn": ""} for w in words]
        
        item_obj = {
            "id": item_id,
            "concept_id": f"c-{item_id}",
            "type": "sentence",
            "level": "A1",
            "target": target,
            "bn": bn,
            "bn_pron": bn_pron,
            "tokens": tokens,
            "status": "reviewed",
            "tags": {
                "sentence_type": "present_continuous",
                "tense": "present_continuous"
            }
        }
        lesson_items.append(item_obj)
        
    lesson_obj = {
        "id": l["id"],
        "order": l["order"],
        "title_bn": l["title_bn"],
        "title_target": l["title_target"],
        "intro_bn": l["intro_bn"],
        "structure": l["structure"],
        "items": lesson_items
    }
    part7_lessons.append(lesson_obj)

part7 = {
    "id": "en-foundations-p7",
    "order": 7,
    "level": "A1",
    "title_bn": "ঘটমান বর্তমান কাল (Present Continuous: am/is/are + ing)",
    "title_target": "Actions Happening Now (Present Continuous)",
    "lessons": part7_lessons
}

data['parts'].append(part7)

# Recalculate stats
total_lessons = sum(len(p['lessons']) for p in data['parts'])
total_items = sum(sum(len(l['items']) for l in p['lessons']) for p in data['parts'])

data['stats'] = {
    "lessons": total_lessons,
    "items": total_items
}

print(f"Total parts: {len(data['parts'])}")
print(f"Total lessons: {total_lessons}")
print(f"Total items: {total_items}")

with open(FILE_PATH, 'w', encoding='utf-8') as f:
    json.dump(data, f, indent=2, ensure_ascii=False)

print("Successfully updated spoken_english_foundations.json with Part 7!")
