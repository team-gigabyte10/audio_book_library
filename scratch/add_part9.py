import json
import sys

sys.stdout.reconfigure(encoding='utf-8')

FILE_PATH = 'android/app/src/main/assets/spoken_english_foundations.json'

data = json.load(open(FILE_PATH, encoding='utf-8'))

# Remove existing Part 9 if any
data['parts'] = [p for p in data['parts'] if p['id'] != 'en-foundations-p9']

lessons_def = [
    {
        "id": "en-foundations-l48",
        "order": 1,
        "title_bn": "সম্প্রীতিক সমাপ্ত কাজ — 'Have / Has + V3' (Recently Completed Actions)",
        "title_target": "Recently Completed Actions (Have / Has + V3)",
        "intro_bn": "কোনো কাজ এইমাত্র বা সম্প্রতি শেষ হয়েছে কিন্তু তার ফলাফল এখনো বিদ্যমান, এমন বোঝাতে Present Perfect Tense ব্যবহার করা হয়। গঠন: Subject + have/has + V3 (Past Participle form of verb)।",
        "structure": [
            "I / You / We / They + have ('ve) + V3",
            "He / She / It / Name + has ('s) + V3"
        ],
        "items": [
            ("en-p9-l48-001", "I have finished my breakfast.", "আমি আমার সকালের নাস্তা শেষ করেছি।", "আই হ্যাভ ফিনিশড মাই ব্রেকফাস্ট।"),
            ("en-p9-l48-002", "I have completed my assigned task for today.", "আমি আজকের জন্য আমার নির্ধারিত কাজটি সম্পন্ন করেছি।", "আই হ্যাভ কমপ্লিটেড মাই অ্যাসাইন্ড টাস্ক ফর টুডে।"),
            ("en-p9-l48-003", "He has just arrived at the office.", "তিনি এইমাত্র অফিসে পৌঁছেছেন।", "হি হ্যাজ জাস্ট অ্যারাইভড অ্যাট দি অফিস।"),
            ("en-p9-l48-004", "She has left for home a few minutes ago.", "সে কয়েক মিনিট আগে বাড়ির উদ্দেশ্যে রওনা হয়েছে।", "শি হ্যাজ লেফট ফর হোম আ ফিউ মিনিট্স এগো।"),
            ("en-p9-l48-005", "We have already sent the official email to the manager.", "আমরা ইতিমধ্যে ম্যানেজারের কাছে অফিশিয়াল ইমেইল পাঠিয়েছি।", "উই হ্যাভ অলরেডি সেন্ট দি অফিশিয়াল ইমেইল টু দ্য ম্যানেজার।"),
            ("en-p9-l48-006", "They have sold their old car and bought a new one.", "তারা তাদের পুরোনো গাড়ি বিক্রি করে একটি নতুন গাড়ি কিনেছে।", "দে হ্যাভ সোল্ড দেয়ার ওল্ড কার অ্যান্ড বট আ নিউ ওয়ান।"),
            ("en-p9-l48-007", "I have lost my house keys.", "আমি আমার ঘরের চাবি হারিয়ে ফেলেছি।", "আই হ্যাভ লস্ট মাই হাউজ কিজ।"),
            ("en-p9-l48-008", "Have you finished your homework? Yes, I have finished my homework. No, I haven't finished yet.", "তুমি কি তোমার বাড়ির কাজ শেষ করেছ? হ্যাঁ, আমি আমার বাড়ির কাজ শেষ করেছি। না, আমি এখনও শেষ করিনি।", "হ্যাভ ইউ ফিনিশড ইয়োর হোমওয়ার্ক? ইয়েস, আই হ্যাভ ফিনিশড মাই হোমওয়ার্ক। নো, আই হ্যাভন্ট ফিনিশড ইয়েট।"),
            ("en-p9-l48-009", "The express train has just arrived at the central station.", "এক্সপ্রেস ট্রেনটি এইমাত্র সেন্ট্রাল স্টেশনে পৌঁছেছে।", "দি এক্সপ্রেস ট্রেন হ্যাজ জাস্ট অ্যারাইভড অ্যাট দ্য সেন্ট্রাল স্টেশন।")
        ]
    },
    {
        "id": "en-foundations-l49",
        "order": 2,
        "title_bn": "না-বোধক ও 'Yet' এর ব্যবহার — 'Haven't / Hasn't + V3' (Negative Actions)",
        "title_target": "Negative Actions & 'Yet' (Haven't / Hasn't + V3)",
        "intro_bn": "কোনো কাজ এখনো করা হয়নি বা ঘটেনি বোঝাতে 'haven't / hasn't + V3' এবং বাক্যের শেষে 'yet' (এখনও) ব্যবহৃত হয়। গঠন: Subject + have not (haven't) / has not (hasn't) + V3 + yet।",
        "structure": [
            "I / You / We / They + haven't + V3 (+ yet)",
            "He / She / It + hasn't + V3 (+ yet)"
        ],
        "items": [
            ("en-p9-l49-001", "I haven't received your message yet.", "আমি এখনও আপনার বার্তা পাইনি।", "আই হ্যাভন্ট রিসিভড ইয়োর মেসেজ ইয়েট।"),
            ("en-p9-l49-002", "He hasn't eaten lunch yet.", "সে এখনও দুপুরের খাবার খায়নি।", "হি হ্যাজন্ট ইটেন লাঞ্চ ইয়েট।"),
            ("en-p9-l49-003", "She hasn't called me back today.", "সে আজ আমাকে আর ফোন করেনি।", "শি হ্যাজন্ট কল্ড মি ব্যাক টুডে।"),
            ("en-p9-l49-004", "We haven't decided where to go this weekend.", "আমরা এই ছুটির দিনে কোথায় যাব এখনও সিদ্ধান্ত নিইনি।", "উই হ্যাভন্ট ডিসাইডেড হোয়ার টু গো দিজ উইকেন্ড।"),
            ("en-p9-l49-005", "They haven't replied to our important email yet.", "তারা এখনও আমাদের গুরুত্বপূর্ণ ইমেইলের উত্তর দেয়নি।", "দে হ্যাভন্ট রিপ্লাইড টু আওয়ার ইম্পরট্যান্ট ইমেইল ইয়েট।"),
            ("en-p9-l49-006", "I haven't seen him since last Friday.", "গত শুক্রবারের পর থেকে আমি তাকে দেখিনি।", "আই হ্যাভন্ট সিন হিম সিন্স লাস্ট ফ্রাইডে।"),
            ("en-p9-l49-007", "Has he called you yet? Yes, he has called me. No, he hasn't called me yet.", "সে কি তোমাকে ফোন করেছে? হ্যাঁ, সে আমাকে ফোন করেছে। না, সে এখনও আমাকে ফোন করেনি।", "হ্যাজ হি কল্ড ইউ ইয়েট? ইয়েস, হি হ্যাজ কল্ড মি। নো, হি হ্যাজন্ট কল্ড মি ইয়েট।"),
            ("en-p9-l49-008", "I haven't tried this delicious food before.", "আমি আগে কখনো এই সুস্বাদু খাবার খাইনি।", "আই হ্যাভন্ট ট্রাইড দিজ ডেলিশাস ফুড বিফোর।")
        ]
    },
    {
        "id": "en-foundations-l50",
        "order": 3,
        "title_bn": "জীবনের অভিজ্ঞতা জিজ্ঞাসা — 'Have you ever...?' (Life Experiences)",
        "title_target": "Life Experiences (Have you ever + V3...?)",
        "intro_bn": "জীবনে কখনো কোনো কিছু করার বা দেখার অভিজ্ঞতা আছে কি না জানতে 'Have you ever + V3...?' দিয়ে প্রশ্ন করা হয়। উত্তরে 'ever' এর বিপরীত হিসেবে 'never' (কখনো না) ব্যবহৃত হতে পারে।",
        "structure": [
            "Have you ever + V3 (Past Participle)...?",
            "Yes, I have (V3)... / No, I have never (V3)..."
        ],
        "items": [
            ("en-p9-l50-001", "Have you ever been to Cox's Bazar? Yes, I have been there twice. No, I have never been there.", "আপনি কি কখনো কক্সবাজার গিয়েছেন? হ্যাঁ, আমি দুইবার গিয়েছি। না, আমি কখনো যাইনি।", "হ্যাভ ইউ এভার বিন টু কক্সবাজার? ইয়েস, আই হ্যাভ বিন দেয়ার টুয়াইস। নো, আই হ্যাভ নেভার বিন দেয়ার।"),
            ("en-p9-l50-002", "Have you ever eaten Japanese food? Yes, I have eaten sushi. No, I have never tried it.", "আপনি কি কখনো জাপানি খাবার খেয়েছেন? হ্যাঁ, আমি সুশি খেয়েছি। না, আমি কখনো খাইনি।", "হ্যাভ ইউ এভার ইটেন জাপানিজ ফুড? ইয়েস, আই হ্যাভ ইটেন সুশি। নো, আই হ্যাভ নেভার ট্রাইড ইট।"),
            ("en-p9-l50-003", "Have you ever spoken English in front of a large audience?", "আপনি কি কখনো বিশাল জনতার সামনে ইংরেজিতে কথা বলেছেন?", "হ্যাভ ইউ এভার স্পোকেন ইংলিশ ইন ফ্রন্ট অব আ লার্জ অডিয়েন্স?"),
            ("en-p9-l50-004", "Have you seen the new movie yet? Yes, I have already watched it. No, not yet.", "আপনি কি নতুন সিনেমাটি দেখেছেন? হ্যাঁ, আমি ইতিমধ্যে দেখেছি। না, এখনও দেখিনি।", "হ্যাভ ইউ সিন দ্য নিউ মুভি ইয়েট? ইয়েস, আই হ্যাভ অলরেডি ওয়াচড ইট। নো, নট ইয়েট।"),
            ("en-p9-l50-005", "Have you ever travelled abroad alone?", "আপনি কি কখনো একা একা বিদেশ ভ্রমণ করেছেন?", "হ্যাভ ইউ এভার ট্রাভেল্ড অ্যাব্রড অ্যালোন?"),
            ("en-p9-l50-006", "I have never seen such a breathtaking sunset before.", "আমি আগে কখনো এমন চোখজুড়ানো সূর্যাস্ত দেখিনি।", "আই হ্যাভ নেভার সিন সাচ আ ব্রেথটেকিং সানসেট বিফোর।"),
            ("en-p9-l50-007", "Have you finished reading this novel? Yes, I have finished it. No, I haven't finished it yet.", "তুমি কি এই উপন্যাসটি পড়া শেষ করেছ? হ্যাঁ, আমি শেষ করেছি। না, আমি এখনও শেষ করিনি।", "হ্যাভ ইউ ফিনিশড রিডিং দিজ নভেল? ইয়েস, আই হ্যাভ ফিনিশড ইট। নো, আই হ্যাভন্ট ফিনিশড ইট ইয়েট।"),
            ("en-p9-l50-008", "What has happened here? Nothing serious has happened.", "এখানে কী ঘটেছে? গুরুতর কিছু ঘটেনি।", "হোয়াট হ্যাজ হ্যাপেন্ড হেয়ার? নাথিং সিরিয়াস হ্যাজ হ্যাপেন্ড।")
        ]
    },
    {
        "id": "en-foundations-l51",
        "order": 4,
        "title_bn": "সময়কাল প্রকাশ — 'Since' ও 'For' এর ব্যবহার (Present Perfect with Duration)",
        "title_target": "Duration & Time Periods ('Since' & 'For')",
        "intro_bn": "অতীতের কোনো নির্দিষ্ট সময় থেকে (Since) অথবা কতক্ষণ ধরে বা কত বছর ধরে (For) কোনো অবস্থা বিদ্যমান রয়েছে তা প্রকাশে Present Perfect Tense ব্যবহৃত হয়।",
        "structure": [
            "Subject + have/has + lived / worked / known / been + for (সময়ের পরিমাণ, যেমন: for 5 years)",
            "Subject + have/has + lived / worked / known / been + since (নির্দিষ্ট সূচনা বিন্দু, যেমন: since 2020)"
        ],
        "items": [
            ("en-p9-l51-001", "I have lived in Dhaka for five years.", "আমি পাঁচ বছর ধরে ঢাকায় বসবাস করছি।", "আই হ্যাভ লিভড ইন ঢাকা ফর ফাইভ ইয়ার্স।"),
            ("en-p9-l51-002", "She has worked at this company since 2020.", "তিনি ২০২০ সাল থেকে এই কোম্পানিতে কাজ করছেন।", "শি হ্যাজ ওয়ার্কড অ্যাট দিজ কোম্পানি সিন্স টুয়েন্টি-টুয়েন্টি।"),
            ("en-p9-l51-003", "I have known him since our childhood days.", "আমি ছেলেবেলা থেকেই তাকে চিনি।", "আই হ্যাভ নোন হিম সিন্স আওয়ার চাইল্ডহুড ডেইজ।"),
            ("en-p9-l51-004", "How long have you lived in this city? I have lived here for three years.", "আপনি কতদিন ধরে এই শহরে থাকছেন? আমি তিন বছর ধরে এখানে থাকছি।", "হাউ লং হ্যাভ ইউ লিভড ইন দিজ সিটি? আই হ্যাভ লিভড হেয়ার ফর থ্রি ইয়ার্স।"),
            ("en-p9-l51-005", "How long have you practiced English? I have practiced English for two months.", "আপনি কতদিন ধরে ইংরেজি অনুশীলন করছেন? আমি দুই মাস ধরে ইংরেজি অনুশীলন করছি।", "হাউ লং হ্যাভ ইউ প্র্যাকটিসড ইংলিশ? আই হ্যাভ প্র্যাকটিসড ইংলিশ ফর টু মান্থস।"),
            ("en-p9-l51-006", "We have been good friends for more than ten years.", "আমরা দশ বছরেরও বেশি সময় ধরে ভালো বন্ধু।", "উই হ্যাভ বিন গুড ফ্রেন্ডস ফর মোর দ্যান টেন ইয়ার্স।"),
            ("en-p9-l51-007", "It has been raining continuously since early morning.", "সকাল থেকে একটানা বৃষ্টি হচ্ছে।", "ইট হ্যাজ বিন রেইনিং কন্টিনিউয়াসলি সিন্স আর্লি মর্নিং।"),
            ("en-p9-l51-008", "Have you known each other for a long time? Yes, we have known each other for five years.", "আপনারা কি একে অপরকে দীর্ঘদিন ধরে চেনেন? হ্যাঁ, আমরা পাঁচ বছর ধরে একে অপরকে চিনি।", "হ্যাভ ইউ নোন ইচ আদার ফর আ লং টাইম? ইয়েস, উই হ্যাভ নোন ইচ আদার ফর ফাইভ ইয়ার্স।")
        ]
    }
]

part9_lessons = []

for l in lessons_def:
    lesson_items = []
    for idx, (item_id, target, bn, pron_bn) in enumerate(l["items"], start=1):
        item_obj = {
            "id": item_id,
            "order": idx,
            "target": target,
            "bn": bn,
            "pron_bn": pron_bn,
            "ipa": target,
            "status": "reviewed",
            "reviewFlags": "",
            "tags": {
                "sentence_type": "present_perfect",
                "tense": "present_perfect"
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
    part9_lessons.append(lesson_obj)

part9 = {
    "id": "en-foundations-p9",
    "order": 9,
    "level": "A2",
    "title_bn": "পুরাঘটিত বর্তমান কাল — Present Perfect Tense (Have/Has + V3)",
    "title_target": "Present Perfect Tense (Have / Has + V3 & Since / For)",
    "lessons": part9_lessons
}

data['parts'].append(part9)

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

print("Successfully updated spoken_english_foundations.json with Part 9!")
