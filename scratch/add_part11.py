import json
import sys

sys.stdout.reconfigure(encoding='utf-8')

FILE_PATH = 'android/app/src/main/assets/spoken_english_foundations.json'

data = json.load(open(FILE_PATH, encoding='utf-8'))

# Remove existing Part 11 if any
data['parts'] = [p for p in data['parts'] if p['id'] != 'en-foundations-p11']

lessons_def = [
    {
        "id": "en-foundations-l56",
        "order": 1,
        "title_bn": "অতীতের অবস্থা ও পরিচয় — 'Was / Were' (Past States & Identity)",
        "title_target": "Past States & Identity (Was / Were)",
        "intro_bn": "অতীতে কোনো ব্যক্তি বা বস্তুর অবস্থা, পেশা বা অবস্থান কেমন ছিল তা প্রকাশ করতে 'was / were' ব্যবহৃত হয়। গঠন: I / He / She / It + was; We / You / They + were।",
        "structure": [
            "I / He / She / It / Singular + was + Adjective / Noun / Place",
            "We / You / They / Plural + were + Adjective / Noun / Place"
        ],
        "items": [
            ("en-p11-l56-001", "I was very busy yesterday afternoon.", "আমি গতকাল বিকেলে খুব ব্যস্ত ছিলাম।", "আই ওয়াজ ভেরি বিজি ইয়েস্টারডে আফটারনুন।"),
            ("en-p11-l56-002", "He was sick last week and stayed in bed.", "সে গত সপ্তাহে অসুস্থ ছিল এবং বিছানায় বিশ্রাম নিয়েছিল।", "হি ওয়াজ সিক লাস্ট উইক অ্যান্ড સ્ટેইড ইন বেড।"),
            ("en-p11-l56-003", "They were at home yesterday evening.", "তারা গতকাল সন্ধ্যায় বাড়িতে ছিল।", "দে ওয়্যার অ্যাট হোম ইয়েস্টারডে ইভনিং।"),
            ("en-p11-l56-004", "She was a dedicated high school teacher before moving abroad.", "বিদেশে যাওয়ার আগে তিনি একজন নিবেদিতপ্রাণ উচ্চ বিদ্যালয়ের শিক্ষক ছিলেন।", "শি ওয়াজ আ ডেডিকেটেড হাই স্কুল টিচার বিফোর মুভিং অ্যাব্রড।"),
            ("en-p11-l56-005", "The weather was very pleasant and sunny yesterday.", "গতকাল আবহাওয়া খুব মনোরম এবং রৌদ্রোজ্জ্বল ছিল।", "দ্য ওয়েদার ওয়াজ ভেরি প্লেজেন্ট অ্যান্ড সানি ইয়েস্টারডে।"),
            ("en-p11-l56-006", "Were you sick yesterday? Yes, I was sick yesterday. No, I was not sick.", "আপনি কি গতকাল অসুস্থ ছিলেন? হ্যাঁ, আমি গতকাল অসুস্থ ছিলাম। না, আমি অসুস্থ ছিলাম না।", "ওয়্যার ইউ সিক ইয়েস্টারডে? ইয়েস, আই ওয়াজ সিক ইয়েস্টারডে। নো, আই ওয়াজ নট সিক।"),
            ("en-p11-l56-007", "Were they in the office on Sunday? Yes, they were in the office. No, they were not.", "তারা কি রবিবারে অফিসে ছিল? হ্যাঁ, তারা অফিসে ছিল। না, তারা ছিল না।", "ওয়্যার দে ইন দি অফিস অন সানডে? ইয়েস, দে ওয়্যার ইন দি অফিস। নো, দে ওয়্যার নট।"),
            ("en-p11-l56-008", "Where were you yesterday morning? I was at the central library.", "আপনি গতকাল সকালে কোথায় ছিলেন? আমি সেন্ট্রাল লাইব্রেরিতে ছিলাম।", "হোয়ার ওয়্যার ইউ ইয়েস্টারডে মর্নিং? আই ওয়াজ অ্যাট দ্য সেন্ট্রাল লাইব্রেরি।")
        ]
    },
    {
        "id": "en-foundations-l57",
        "order": 2,
        "title_bn": "অতীতের সমাপ্ত কাজ — 'Subject + V2' (Affirmative Past Simple)",
        "title_target": "Completed Past Actions (Subject + V2)",
        "intro_bn": "অতীতের কোনো নির্দিষ্ট সময়ে শেষ হওয়া কাজ বোঝাতে মূল Verb-এর Past form (V2) ব্যবহৃত হয়। যেমন: went, came, bought, watched, called।",
        "structure": [
            "Subject + V2 (went, saw, played, bought, cooked)",
            "Time markers: yesterday, last night, two days ago, last month"
        ],
        "items": [
            ("en-p11-l57-001", "She went shopping with her sister last Saturday.", "তিনি গত শনিবার তার বোনের সাথে কেনাকাটা করতে গিয়েছিলেন।", "শি ওয়েন্ট শপিং উইথ হার সিস্টার লাস্ট স্যাটারডে।"),
            ("en-p11-l57-002", "We got up early yesterday and went for a long morning walk.", "আমরা গতকাল খুব ভোরে ঘুম থেকে উঠে দীর্ঘ প্রাতঃভ্রমণে গিয়েছিলাম।", "উই গট আপ আর্লি ইয়েস্টারডে অ্যান্ড ওয়েন্ট ফর আ লং মর্নিং ওয়াক।"),
            ("en-p11-l57-003", "I met my old school friend at the railway station.", "রেলওয়ে স্টেশনে আমার পুরানো স্কুল বন্ধুর সাথে দেখা হয়েছিল।", "আই মেট মাই ওল্ড স্কুল ফ্রেন্ড অ্যাট দ্য রেলওয়ে স্টেশন।"),
            ("en-p11-l57-004", "He bought a brand new smartphone two days ago.", "সে দুই দিন আগে একটি একদম নতুন স্মার্টফোন কিনেছিল।", "হি বট আ ব্র্যান্ড নিউ স্মার্টফোন টু ডেইজ এগো।"),
            ("en-p11-l57-005", "She cooked delicious biryani for all the invited guests.", "তিনি সকল আমন্ত্রিত অতিথিদের জন্য সুস্বাদু বিরিয়ানি রান্না করেছিলেন।", "শি কুক্ট ডেলিশাস বিরিয়ানি ফর অল দি ইনভাইটেড গেস্টস।"),
            ("en-p11-l57-006", "We watched an inspiring documentary last night.", "আমরা গত রাতে একটি অনুপ্রেরণামূলক ডকুমেন্টারি দেখেছি।", "উই ওয়াচড অ্যান ইন্সপায়ারিং ডকুমেন্টারি লাস্ট নাইট।"),
            ("en-p11-l57-007", "They reached the international airport on time yesterday.", "তারা গতকাল সময়মতো আন্তর্জাতিক বিমানবন্দরে পৌঁছেছিল।", "দে রীচড দি ইন্টারন্যাশনাল এয়ারপোর্ট অন টাইম ইয়েস্টারডে।"),
            ("en-p11-l57-008", "I finished reading the entire book in just three days.", "আমি মাত্র তিন দিনে পুরো বইটি পড়া শেষ করেছিলাম।", "আই ফিনিশড রিডিং দি এনটায়ার বুক ইন জাস্ট থ্রি ডেইজ।")
        ]
    },
    {
        "id": "en-foundations-l58",
        "order": 3,
        "title_bn": "অতীতের না-বোধক বাক্য — 'Didn't + V1' (Negative Past Simple)",
        "title_target": "Negative Past Simple (Didn't + V1)",
        "intro_bn": "অতীতে কোনো কাজ করা হয়নি বোঝাতে 'did not' বা সংক্ষেপে 'didn't' এবং এরপরে মূল Verb-এর Base form (V1) বসে। কখনোই didn't-এর পর V2 বসবে না!",
        "structure": [
            "Subject + didn't + Verb (Base form V1)",
            "Note: didn't go (went নয়), didn't see (saw নয়)"
        ],
        "items": [
            ("en-p11-l58-001", "I didn't receive your phone call yesterday.", "আমি গতকাল আপনার ফোন কল পাইনি।", "আই ডিডন্ট রিসিভ ইয়োর ফোন কল ইয়েস্টারডে।"),
            ("en-p11-l58-002", "She didn't go shopping with her friends last month.", "তিনি গত মাসে বন্ধুদের সাথে কেনাকাটা করতে যাননি।", "শি ডিডন্ট গো শপিং উইথ হার ফ্রেন্ডস লাস্ট মান্থ।"),
            ("en-p11-l58-003", "We didn't get up late yesterday morning.", "আমরা গতকাল সকালে দেরিতে উঠিনি।", "উই ডিডন্ট গেট আপ লেইট ইয়েস্টারডে মর্নিং।"),
            ("en-p11-l58-004", "He didn't tell me about the schedule change.", "তিনি সময়সূচি পরিবর্তনের ব্যাপারে আমাকে কিছু জানাননি।", "হি ডিডন্ট টেল মি অ্যাবাউট দ্য শিডিউল চেইঞ্জ।"),
            ("en-p11-l58-005", "They didn't attend the annual general meeting yesterday.", "তারা গতকাল বার্ষিক সাধারণ সভায় উপস্থিত হননি।", "দে ডিডন্ট অ্যাটেন্ড দি অ্যানুয়াল জেনারেল মিটিং ইয়েস্টারডে।"),
            ("en-p11-l58-006", "I didn't understand that complex grammar rule at first.", "আমি প্রথমে সেই জটিল ব্যাকরণ নিয়মটি বুঝতে পারিনি।", "আই ডিডন্ট আন্ডারস্ট্যান্ড দ্যাট কমপ্লেক্স গ্রামার রুল অ্যাট ফার্স্ট।"),
            ("en-p11-l58-007", "She didn't buy that expensive blue dress from the mall.", "সে মল থেকে সেই দামি নীল পোশাকটি কেনেনি।", "শি ডিডন্ট বাই দ্যাট এক্সপেন্সিভ ব্লু ড্রেস ফ্রম দ্য মল।"),
            ("en-p11-l58-008", "We didn't face any trouble on our way back home.", "বাড়ি ফেরার পথে আমরা কোনো সমস্যায় পড়িনি।", "উই ডিডন্ট ফেইস অ্যানি ট্রাবল অন আওয়ার ওয়ে ব্যাক হোম।")
        ]
    },
    {
        "id": "en-foundations-l59",
        "order": 4,
        "title_bn": "অতীতের প্রশ্ন ও প্রশ্নোত্তর — 'Did you + V1...?' (Past Simple Q&A Drills)",
        "title_target": "Past Questions & Answers (Did you + V1...?)",
        "intro_bn": "অতীতে কেউ কোনো কাজ করেছিল কি না জানতে 'Did + Subject + V1...?' দিয়ে প্রশ্ন করা হয়। হ্যাঁ-বোধক উত্তরে V2 এবং না-বোধক উত্তরে didn't + V1 ব্যবহৃত হয়।",
        "structure": [
            "Did + Subject + Verb (V1)...?",
            "Yes, Subject + V2 ... / No, Subject + didn't + V1..."
        ],
        "items": [
            ("en-p11-l59-001", "Did she go shopping last weekend? Yes, she went shopping. No, she didn't go shopping.", "সে কি গত সপ্তাহে কেনাকাটা করতে গিয়েছিল? হ্যাঁ, সে কেনাকাটা করতে গিয়েছিল। না, সে যায়নি।", "ডিড শি গো শপিং লাস্ট উইকেন্ড? ইয়েস, শি ওয়েন্ট শপিং। নো, শি ডিডন্ট গো শপিং।"),
            ("en-p11-l59-002", "Did you get up early yesterday? Yes, I got up early. No, I didn't get up early.", "তুমি কি কাল ভোরে উঠেছিলে? হ্যাঁ, আমি ভোরে উঠেছিলাম। না, আমি ভোরে উঠিনি।", "ডিড ইউ গেট আপ আর্লি ইয়েস্টারডে? ইয়েস, আই গট আপ আর্লি। নো, আই ডিডন্ট গেট আপ আর্লি।"),
            ("en-p11-l59-003", "Did you watch the cricket match yesterday? Yes, I watched the match. No, I didn't watch it.", "তুমি কি গতকাল ক্রিকেট ম্যাচটি দেখেছিলে? হ্যাঁ, আমি ম্যাচটি দেখেছি। না, আমি দেখিনি।", "ডিড ইউ ওয়াচ দ্য ক্রিকেট ম্যাচ ইয়েস্টারডে? ইয়েস, আই ওয়াচড দ্য ম্যাচ। নো, আই ডিডন্ট ওয়াচ ইট।"),
            ("en-p11-l59-004", "Did he call you last night? Yes, he called me. No, he didn't call me.", "সে কি গত রাতে তোমাকে ফোন করেছিল? হ্যাঁ, সে আমাকে ফোন করেছিল। না, সে আমাকে ফোন করেনি।", "ডিড হি কল ইউ লাস্ট নাইট? ইয়েস, হি কল্ড মি। নো, হি ডিডন্ট কল মি।"),
            ("en-p11-l59-005", "Did they enjoy the beach party? Yes, they enjoyed it very much. No, they didn't enjoy it.", "তারা কি সমুদ্র সৈকতের পার্টি উপভোগ করেছিল? হ্যাঁ, তারা খুব উপভোগ করেছিল। না, তারা উপভোগ করেনি।", "ডিড দে এনজয় দ্য বিচ পার্টি? ইয়েস, দে এনজয়েড ইট ভেরি মাচ। নো, দে ডিডন্ট এনজয় ইট।"),
            ("en-p11-l59-006", "Did you sleep well last night? Yes, I slept very well. No, I didn't sleep well.", "গত রাতে আপনার ঘুম ভালো হয়েছিল? হ্যাঁ, আমার খুব ভালো ঘুম হয়েছিল। না, আমার ঘুম ভালো হয়নি।", "ডিড ইউ স্লিপ ওয়েল লাস্ট নাইট? ইয়েস, আই স্লেপ্ট ভেরি ওয়েল। নো, আই ডিডন্ট স্লিপ ওয়েল।"),
            ("en-p11-l59-007", "Did it rain heavily in your area yesterday? Yes, it rained heavily. No, it didn't rain.", "গতকাল কি আপনার এলাকায় ভারী বৃষ্টি হয়েছিল? হ্যাঁ, ভারী বৃষ্টি হয়েছিল। না, বৃষ্টি হয়নি।", "ডিড ইট রেইন হেভিলি ইন ইয়োর এরিয়া ইয়েস্টারডে? ইয়েস, ইট রেইন্ড হেভিলি। নো, ইট ডিডন্ট রেইন।"),
            ("en-p11-l59-008", "Did you find your lost wallet? Yes, I found it under the table. No, I didn't find it yet.", "তুমি কি তোমার হারিয়ে যাওয়া মানিব্যাগ খুঁজে পেয়েছ? হ্যাঁ, আমি টেবিলের নিচে পেয়েছি। না, আমি এখনও খুঁজে পাইনি।", "ডিড ইউ ফাইন্ড ইয়োর লস্ট ওয়ালেট? ইয়েস, আই ফাউন্ড ইট আন্ডার দ্য টেবিল। নো, আই ডিডন্ট ফাইন্ড ইট ইয়েট।")
        ]
    },
    {
        "id": "en-foundations-l60",
        "order": 5,
        "title_bn": "অতীতের তথ্যমূলক প্রশ্ন — 'Wh- Questions with Did' (Seeking Past Info)",
        "title_target": "Wh- Questions in the Past (Where, When, Why, What did you...?)",
        "intro_bn": "অতীতে কী, কখন, কোথায়, কেন, কীভাবে ঘটেছিল তা জানতে Wh-words (What, When, Where, Why, How) এর সাথে 'did + Subject + V1' ব্যবহার করা হয়।",
        "structure": [
            "Wh-word + did + Subject + Verb (V1)...?",
            "Answer: Subject + V2 (Past Form)..."
        ],
        "items": [
            ("en-p11-l60-001", "Where did you go yesterday evening? I went to the shopping mall.", "আপনি গতকাল সন্ধ্যায় কোথায় গিয়েছিলেন? আমি শপিং মলে গিয়েছিলাম।", "হোয়ার ডিড ইউ গো ইয়েস্টারডে ইভনিং? আই ওয়েন্ট টু দ্য শপিং মল।"),
            ("en-p11-l60-002", "What did you buy at the supermarket? I bought fresh fruits and vegetables.", "আপনি সুপারমার্কেটে কী কিনেছিলেন? আমি তাজা ফল ও শাকসবজি কিনেছিলাম।", "হোয়াট ডিড ইউ বাই অ্যাট দ্য সুপারমার্কেট? আই বট ফ্রেশ ফ্রুটস অ্যান্ড ভেজিটেবলস।"),
            ("en-p11-l60-003", "When did they arrive at the venue? They arrived at six in the evening.", "তারা কখন অনুষ্ঠানস্থলে পৌঁছেছিলেন? তারা সন্ধ্যা ছয়টায় পৌঁছেছিলেন।", "হোয়েন ডিড দে অ্যারাইভ অ্যাট দ্য ভেনিউ? দে অ্যারাইভড অ্যাট সিক্স ইন দি ইভনিং।"),
            ("en-p11-l60-004", "Why did you miss the morning bus? Because I got up a little late.", "আপনি সকালের বাস মিস করেছিলেন কেন? কারণ আমি একটু দেরিতে ঘুম থেকে উঠেছিলাম।", "হোয়াই ডিড ইউ মিস দ্য মর্নিং বাস? বিকজ আই গট আপ আ লিটল লেইট।"),
            ("en-p11-l60-005", "How did you learn to speak English so well? I practiced speaking every single day.", "আপনি এত সুন্দর ইংরেজি বলা কীভাবে শিখলেন? আমি প্রতিদিন কথা বলার অনুশীলন করেছি।", "হাউ ডিড ইউ লার্ন টু স্পিক ইংলিশ সো ওয়েল? আই প্র্যাকটিসড স্পিকিং এভরি সিঙ্গেল ডে।"),
            ("en-p11-l60-006", "Who did you meet at the office conference? I met our new marketing director.", "অফিসের সম্মেলনে আপনি কার সাথে দেখা করেছিলেন? আমি আমাদের নতুন মার্কেটিং পরিচালকের সাথে দেখা করেছিলাম।", "হু ডিড ইউ মিট অ্যাট দি অফিস কনফারেন্স? আই মেট আওয়ার নিউ মার্কেটিং ডিরেক্টর।"),
            ("en-p11-l60-007", "What time did you go to bed last night? I went to bed around midnight.", "গত রাতে আপনি কয়টায় ঘুমাতে গিয়েছিলেন? আমি প্রায় মধ্যরাতে ঘুমাতে গিয়েছিলাম।", "হোয়াট টাইম ডিড ইউ গো টু বেড লাস্ট নাইট? আই ওয়েন্ট টু বেড অ্যারাউন্ড মিডনাইট।"),
            ("en-p11-l60-008", "How much did this leather jacket cost? It cost three thousand taka.", "এই চামড়ার জ্যাকেটের দাম কত ছিল? এর দাম ছিল তিন হাজার টাকা।", "হাউ মাচ ডিড দিজ লেদার জ্যাকেট কস্ট? ইট কস্ট থ্রি থাউজেন্ড টাকা।")
        ]
    }
]

part11_lessons = []

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
                "sentence_type": "past_simple",
                "tense": "past"
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
    part11_lessons.append(lesson_obj)

part11 = {
    "id": "en-foundations-p11",
    "order": 11,
    "level": "A2",
    "title_bn": "সাধারণ অতীত কাল — Past Simple (Was/Were & Did/Didn't)",
    "title_target": "Past Simple Tense (Was/Were & Did/Didn't with V2)",
    "lessons": part11_lessons
}

data['parts'].append(part11)

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

print("Successfully updated spoken_english_foundations.json with Part 11!")
