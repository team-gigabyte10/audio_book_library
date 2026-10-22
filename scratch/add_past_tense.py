import json
import sys

sys.stdout.reconfigure(encoding='utf-8')

FILE_PATH = 'android/app/src/main/assets/spoken_english_foundations.json'
data = json.load(open(FILE_PATH, encoding='utf-8'))

# Keep parts 1 to 12
data['parts'] = [p for p in data['parts'] if int(p['id'].replace('en-foundations-p', '')) <= 12]

# ==============================================================================
# PART 13: Past Simple (Was/Were & Did/Didn't)
# ==============================================================================
p13_lessons = [
    {
        "id": "en-foundations-l61",
        "order": 1,
        "title_bn": "অতীতের অবস্থা ও পরিচয় — 'Was / Were' (Past States & Identity)",
        "title_target": "Past States & Identity (Was / Were)",
        "intro_bn": "অতীতে কোনো ব্যক্তি বা বস্তুর অবস্থা, পেশা বা অবস্থান কেমন ছিল তা প্রকাশ করতে 'was / were' ব্যবহৃত হয়। গঠন: I / He / She / It + was; We / You / They + were।",
        "structure": [
            "I / He / She / It / Singular + was + Adjective / Noun / Place",
            "We / You / They / Plural + were + Adjective / Noun / Place"
        ],
        "items": [
            ("en-p13-l61-001", "I was very busy yesterday afternoon.", "আমি গতকাল বিকেলে খুব ব্যস্ত ছিলাম।", "আই ওয়াজ ভেরি বিজি ইয়েস্টারডে আফটারনুন।"),
            ("en-p13-l61-002", "He was sick last week and stayed in bed.", "সে গত সপ্তাহে অসুস্থ ছিল এবং বিছানায় বিশ্রাম নিয়েছিল।", "হি ওয়াজ সিক লাস্ট উইক অ্যান্ড સ્ટેইড ইন বেড।"),
            ("en-p13-l61-003", "They were at home yesterday evening.", "তারা গতকাল সন্ধ্যায় বাড়িতে ছিল।", "দে ওয়্যার অ্যাট হোম ইয়েস্টারডে ইভনিং।"),
            ("en-p13-l61-004", "She was a dedicated school teacher before moving abroad.", "বিদেশে যাওয়ার আগে তিনি একজন নিবেদিতপ্রাণ শিক্ষক ছিলেন।", "শি ওয়াজ আ ডেডিকেটেড স্কুল টিচার বিফোর মুভিং অ্যাব্রড।"),
            ("en-p13-l61-005", "The weather was very pleasant and sunny yesterday.", "গতকাল আবহাওয়া খুব মনোরম এবং রৌদ্রোজ্জ্বল ছিল।", "দ্য ওয়েদার ওয়াজ ভেরি প্লেজেন্ট অ্যান্ড সানি ইয়েস্টারডে।"),
            ("en-p13-l61-006", "Were you sick yesterday? Yes, I was sick yesterday. No, I was not sick.", "আপনি কি গতকাল অসুস্থ ছিলেন? হ্যাঁ, আমি গতকাল অসুস্থ ছিলাম। না, আমি অসুস্থ ছিলাম না।", "ওয়্যার ইউ সিক ইয়েস্টারডে? ইয়েস, আই ওয়াজ সিক ইয়েস্টারডে। নো, আই ওয়াজ নট সিক।"),
            ("en-p13-l61-007", "Were they in the office on Sunday? Yes, they were in the office. No, they were not.", "তারা কি রবিবারে অফিসে ছিল? হ্যাঁ, তারা অফিসে ছিল। না, তারা ছিল না।", "ওয়্যার দে ইন দি অফিস অন সানডে? ইয়েস, দে ওয়্যার ইন দি অফিস। নো, দে ওয়্যার নট।"),
            ("en-p13-l61-008", "Where were you yesterday morning? I was at the central library.", "আপনি গতকাল সকালে কোথায় ছিলেন? আমি সেন্ট্রাল লাইব্রেরিতে ছিলাম।", "হোয়ার ওয়্যার ইউ ইয়েস্টারডে মর্নিং? আই ওয়াজ অ্যাট দ্য সেন্ট্রাল লাইব্রেরি।")
        ]
    },
    {
        "id": "en-foundations-l62",
        "order": 2,
        "title_bn": "অতীতের সমাপ্ত কাজ — 'Subject + V2' (Completed Past Actions)",
        "title_target": "Completed Past Actions (Subject + V2)",
        "intro_bn": "অতীতের কোনো নির্দিষ্ট সময়ে শেষ হওয়া কাজ বোঝাতে মূল Verb-এর Past form (V2) ব্যবহৃত হয়। যেমন: went, came, bought, watched, called।",
        "structure": [
            "Subject + V2 (went, saw, played, bought, cooked)",
            "Time markers: yesterday, last night, two days ago, last month"
        ],
        "items": [
            ("en-p13-l62-001", "She went shopping with her sister last Saturday.", "তিনি গত শনিবার তার বোনের সাথে কেনাকাটা করতে গিয়েছিলেন।", "শি ওয়েন্ট শপিং উইথ হার সিস্টার লাস্ট স্যাটারডে।"),
            ("en-p13-l62-002", "We got up early yesterday and went for a long morning walk.", "আমরা গতকাল খুব ভোরে ঘুম থেকে উঠে প্রাতঃভ্রমণে গিয়েছিলাম।", "উই গট আপ আর্লি ইয়েস্টারডে অ্যান্ড ওয়েন্ট ফর আ লং মর্নিং ওয়াক।"),
            ("en-p13-l62-003", "I met my old school friend at the railway station.", "রেলওয়ে স্টেশনে আমার পুরানো স্কুল বন্ধুর সাথে দেখা হয়েছিল।", "আই মেট মাই ওল্ড স্কুল ফ্রেন্ড অ্যাট দ্য রেলওয়ে স্টেশন।"),
            ("en-p13-l62-004", "He bought a brand new smartphone two days ago.", "সে দুই দিন আগে একটি একদম নতুন স্মার্টফোন কিনেছিল।", "হি বট আ ব্র্যান্ড নিউ স্মার্টফোন টু ডেইজ এগো।"),
            ("en-p13-l62-005", "She cooked delicious biryani for all the invited guests.", "তিনি সকল আমন্ত্রিত অতিথিদের জন্য সুস্বাদু বিরিয়ানি রান্না করেছিলেন।", "শি কুক্ট ডেলিশাস বিরিয়ানি ফর অল দি ইনভাইটেড গেস্টস।"),
            ("en-p13-l62-006", "We watched an inspiring documentary last night.", "আমরা গত রাতে একটি অনুপ্রেরণামূলক ডকুমেন্টারি দেখেছি।", "উই ওয়াচড অ্যান ইন্সপায়ারিং ডকুমেন্টারি লাস্ট নাইট।"),
            ("en-p13-l62-007", "They reached the international airport on time yesterday.", "তারা গতকাল সময়মতো আন্তর্জাতিক বিমানবন্দরে পৌঁছেছিল।", "দে রীচড দি ইন্টারন্যাশনাল এয়ারপোর্ট অন টাইম ইয়েস্টারডে।"),
            ("en-p13-l62-008", "I finished reading the entire book in just three days.", "আমি মাত্র তিন দিনে পুরো বইটি পড়া শেষ করেছিলাম।", "আই ফিনিশড রিডিং দি এনটায়ার বুক ইন জাস্ট থ্রি ডেইজ।")
        ]
    },
    {
        "id": "en-foundations-l63",
        "order": 3,
        "title_bn": "অতীতের না-বোধক বাক্য — 'Didn't + V1' (Negative Past Simple)",
        "title_target": "Negative Past Simple (Didn't + V1)",
        "intro_bn": "অতীতে কোনো কাজ করা হয়নি বোঝাতে 'did not' বা সংক্ষেপে 'didn't' এবং এরপরে মূল Verb-এর Base form (V1) বসে। কখনোই didn't-এর পর V2 বসবে না!",
        "structure": [
            "Subject + didn't + Verb (Base form V1)",
            "Note: didn't go (went নয়), didn't see (saw নয়)"
        ],
        "items": [
            ("en-p13-l63-001", "I didn't receive your phone call yesterday.", "আমি গতকাল আপনার ফোন কল পাইনি।", "আই ডিডন্ট রিসিভ ইয়োর ফোন কল ইয়েস্টারডে।"),
            ("en-p13-l63-002", "She didn't go shopping with her friends last month.", "তিনি গত মাসে বন্ধুদের সাথে কেনাকাটা করতে যাননি।", "শি ডিডন্ট গো শপিং উইথ হার ফ্রেন্ডস লাস্ট মান্থ।"),
            ("en-p13-l63-003", "We didn't get up late yesterday morning.", "আমরা গতকাল সকালে দেরিতে উঠিনি।", "উই ডিডন্ট গেট আপ লেইট ইয়েস্টারডে মর্নিং।"),
            ("en-p13-l63-004", "He didn't tell me about the schedule change.", "তিনি সময়সূচি পরিবর্তনের ব্যাপারে আমাকে কিছু জানাননি।", "হি ডিডন্ট টেল মি অ্যাবাউট দ্য শিডিউল চেইঞ্জ।"),
            ("en-p13-l63-005", "They didn't attend the annual general meeting yesterday.", "তারা গতকাল বার্ষিক সাধারণ সভায় উপস্থিত হননি।", "দে ডিডন্ট অ্যাটেন্ড দি অ্যানুয়াল জেনারেল মিটিং ইয়েস্টারডে।"),
            ("en-p13-l63-006", "I didn't understand that complex grammar rule at first.", "আমি প্রথমে সেই জটিল ব্যাকরণ নিয়মটি বুঝতে পারিনি।", "আই ডিডন্ট আন্ডারস্ট্যান্ড দ্যাট কমপ্লেক্স গ্রামার রুল অ্যাট ফার্স্ট।"),
            ("en-p13-l63-007", "She didn't buy that expensive blue dress from the mall.", "সে মল থেকে সেই দামি নীল পোশাকটি কেনেনি।", "শি ডিডন্ট বাই দ্যাট এক্সপেন্সিভ ব্লু ড্রেস ফ্রম দ্য মল।"),
            ("en-p13-l63-008", "We didn't face any trouble on our way back home.", "বাড়ি ফেরার পথে আমরা কোনো সমস্যায় পড়িনি।", "উই ডিডন্ট ফেইস অ্যানি ট্রাবল অন আওয়ার ওয়ে ব্যাক হোম।")
        ]
    },
    {
        "id": "en-foundations-l64",
        "order": 4,
        "title_bn": "অতীতের প্রশ্ন ও প্রশ্নোত্তর — 'Did you + V1...?' (Past Simple Q&A Drills)",
        "title_target": "Past Questions & Answers (Did you + V1...?)",
        "intro_bn": "অতীতে কেউ কোনো কাজ করেছিল কি না জানতে 'Did + Subject + V1...?' দিয়ে প্রশ্ন করা হয়। হ্যাঁ-বোধক উত্তরে V2 এবং না-বোধক উত্তরে didn't + V1 ব্যবহৃত হয়।",
        "structure": [
            "Did + Subject + Verb (V1)...?",
            "Yes, Subject + V2 ... / No, Subject + didn't + V1..."
        ],
        "items": [
            ("en-p13-l64-001", "Did she go shopping last weekend? Yes, she went shopping. No, she didn't go shopping.", "সে কি গত সপ্তাহে কেনাকাটা করতে গিয়েছিল? হ্যাঁ, সে কেনাকাটা করতে গিয়েছিল। না, সে যায়নি।", "ডিড শি গো শপিং লাস্ট উইকেন্ড? ইয়েস, শি ওয়েন্ট শপিং। নো, শি ডিডন্ট গো শপিং।"),
            ("en-p13-l64-002", "Did you get up early yesterday? Yes, I got up early. No, I didn't get up early.", "তুমি কি কাল ভোরে উঠেছিলে? হ্যাঁ, আমি ভোরে উঠেছিলাম। না, আমি ভোরে উঠিনি।", "ডিড ইউ গেট আপ আর্লি ইয়েস্টারডে? ইয়েস, আই গট আপ আর্লি। নো, আই ডিডন্ট গেট আপ আর্লি।"),
            ("en-p13-l64-003", "Did you watch the cricket match yesterday? Yes, I watched the match. No, I didn't watch it.", "তুমি কি গতকাল ক্রিকেট ম্যাচটি দেখেছিলে? হ্যাঁ, আমি ম্যাচটি দেখেছি। না, আমি দেখিনি।", "ডিড ইউ ওয়াচ দ্য ক্রিকেট ম্যাচ ইয়েস্টারডে? ইয়েস, আই ওয়াচড দ্য ম্যাচ। নো, আই ডিডন্ট ওয়াচ ইট।"),
            ("en-p13-l64-004", "Did he call you last night? Yes, he called me. No, he didn't call me.", "সে কি গত রাতে তোমাকে ফোন করেছিল? হ্যাঁ, সে আমাকে ফোন করেছিল। না, সে আমাকে ফোন করেনি।", "ডিড হি কল ইউ লাস্ট নাইট? ইয়েস, হি কল্ড মি। নো, হি ডিডন্ট কল মি।"),
            ("en-p13-l64-005", "Did they enjoy the beach party? Yes, they enjoyed it very much. No, they didn't enjoy it.", "তারা কি সমুদ্র সৈকতের পার্টি উপভোগ করেছিল? হ্যাঁ, তারা খুব উপভোগ করেছিল। না, তারা উপভোগ করেনি।", "ডিড দে এনজয় দ্য বিচ পার্টি? ইয়েস, দে এনজয়েড ইট ভেরি মাচ। নো, দে ডিডন্ট এনজয় ইট।"),
            ("en-p13-l64-006", "Did you sleep well last night? Yes, I slept very well. No, I didn't sleep well.", "গত রাতে আপনার ঘুম ভালো হয়েছিল? হ্যাঁ, আমার খুব ভালো ঘুম হয়েছিল। না, আমার ঘুম ভালো হয়নি।", "ডিড ইউ স্লিপ ওয়েল লাস্ট নাইট? ইয়েস, আই স্লেপ্ট ভেরি ওয়েল। নো, আই ডিডন্ট স্লিপ ওয়েল।"),
            ("en-p13-l64-007", "Did it rain heavily in your area yesterday? Yes, it rained heavily. No, it didn't rain.", "গতকাল কি আপনার এলাকায় ভারী বৃষ্টি হয়েছিল? হ্যাঁ, ভারী বৃষ্টি হয়েছিল। না, বৃষ্টি হয়নি।", "ডিড ইট রেইন হেভিলি ইন ইয়োর এরিয়া ইয়েস্টারডে? ইয়েস, ইট রেইন্ড হেভিলি। নো, ইট ডিডন্ট রেইন।"),
            ("en-p13-l64-008", "Did you find your lost wallet? Yes, I found it under the table. No, I didn't find it yet.", "তুমি কি তোমার হারিয়ে যাওয়া মানিব্যাগ খুঁজে পেয়েছ? হ্যাঁ, আমি টেবিলের নিচে পেয়েছি। না, আমি এখনও খুঁজে পাইনি।", "ডিড ইউ ফাইন্ড ইয়োর লস্ট ওয়ালেট? ইয়েস, আই ফাউন্ড ইট আন্ডার দ্য টেবিল। নো, আই ডিডন্ট ফাইন্ড ইট ইয়েট।")
        ]
    },
    {
        "id": "en-foundations-l65",
        "order": 5,
        "title_bn": "অতীতের তথ্যমূলক প্রশ্ন — 'Wh- Questions with Did' (Seeking Past Info)",
        "title_target": "Wh- Questions in the Past (Where, When, Why, What did you...?)",
        "intro_bn": "অতীতে কী, কখন, কোথায়, কেন, কীভাবে ঘটেছিল তা জানতে Wh-words (What, When, Where, Why, How) এর সাথে 'did + Subject + V1' ব্যবহার করা হয়।",
        "structure": [
            "Wh-word + did + Subject + Verb (V1)...?",
            "Answer: Subject + V2 (Past Form)..."
        ],
        "items": [
            ("en-p13-l65-001", "Where did you go yesterday evening? I went to the shopping mall.", "আপনি গতকাল সন্ধ্যায় কোথায় গিয়েছিলেন? আমি শপিং মলে গিয়েছিলাম।", "হোয়ার ডিড ইউ গো ইয়েস্টারডে ইভনিং? আই ওয়েন্ট টু দ্য শপিং মল।"),
            ("en-p13-l65-002", "What did you buy at the supermarket? I bought fresh fruits and vegetables.", "আপনি সুপারমার্কেটে কী কিনেছিলেন? আমি তাজা ফল ও শাকসবজি কিনেছিলাম।", "হোয়াট ডিড ইউ বাই অ্যাট দ্য সুপারমার্কেট? আই বট ফ্রেশ ফ্রুটস অ্যান্ড ভেজিটেবলস।"),
            ("en-p13-l65-003", "When did they arrive at the venue? They arrived at six in the evening.", "তারা কখন অনুষ্ঠানস্থলে পৌঁছেছিলেন? তারা সন্ধ্যা ছয়টায় পৌঁছেছিলেন।", "হোয়েন ডিড দে অ্যারাইভ অ্যাট দ্য ভেনিউ? দে অ্যারাইভড অ্যাট সিক্স ইন দি ইভনিং।"),
            ("en-p13-l65-004", "Why did you miss the morning bus? Because I got up a little late.", "আপনি সকালের বাস মিস করেছিলেন কেন? কারণ আমি একটু দেরিতে ঘুম থেকে উঠেছিলাম।", "হোয়াই ডিড ইউ মিস দ্য মর্নিং বাস? বিকজ আই গট আপ আ লিটল লেইট।"),
            ("en-p13-l65-005", "How did you learn to speak English so well? I practiced speaking every single day.", "আপনি এত সুন্দর ইংরেজি বলা কীভাবে শিখলেন? আমি প্রতিদিন কথা বলার অনুশীলন করেছি।", "হাউ ডিড ইউ লার্ন টু স্পিক ইংলিশ সো ওয়েল? আই প্র্যাকটিসড স্পিকিং এভরি সিঙ্গেল ডে।"),
            ("en-p13-l65-006", "Who did you meet at the office conference? I met our new marketing director.", "অফিসের সম্মেলনে আপনি কার সাথে দেখা করেছিলেন? আমি আমাদের নতুন মার্কেটিং পরিচালকের সাথে দেখা করেছিলাম।", "হু ডিড ইউ মিট অ্যাট দি অফিস কনফারেন্স? আই মেট আওয়ার নিউ মার্কেটিং ডিরেক্টর।"),
            ("en-p13-l65-007", "What time did you go to bed last night? I went to bed around midnight.", "গত রাতে আপনি কয়টায় ঘুমাতে গিয়েছিলেন? আমি প্রায় মধ্যরাতে ঘুমাতে গিয়েছিলাম।", "হোয়াট টাইম ডিড ইউ গো টু বেড লাস্ট নাইট? আই ওয়েন্ট টু বেড অ্যারাউন্ড মিডনাইট।"),
            ("en-p13-l65-008", "How much did this leather jacket cost? It cost three thousand taka.", "এই চামড়ার জ্যাকেটের দাম কত ছিল? এর দাম ছিল তিন হাজার টাকা।", "হাউ মাচ ডিড দিজ লেদার জ্যাকেট কস্ট? ইট কস্ট থ্রি থাউজেন্ড টাকা।")
        ]
    }
]

# ==============================================================================
# PART 14: Past Continuous & Interrupted Actions (Was/Were + V-ing & When/While)
# ==============================================================================
p14_lessons = [
    {
        "id": "en-foundations-l66",
        "order": 1,
        "title_bn": "অতীতে চলমান কাজ — 'Was / Were + Verb-ING' (Past Continuous)",
        "title_target": "Ongoing Past Actions (Was / Were + Verb-ING)",
        "intro_bn": "অতীতের কোনো নির্দিষ্ট সময়ে কোনো কাজ কিছুক্ষণ ধরে চলছিল বোঝাতে Past Continuous Tense ব্যবহৃত হয়। গঠন: Subject + was/were + Verb-ING।",
        "structure": [
            "I / He / She / It + was + Verb-ING",
            "We / You / They + were + Verb-ING"
        ],
        "items": [
            ("en-p14-l66-001", "She was cooking delicious dinner in the kitchen.", "সে রান্নাঘরে সুস্বাদু রাতের খাবার রান্না করছিল।", "শি ওয়াজ কুকিং ডেলিশাস ডিনার ইন দ্য কিচেন।"),
            ("en-p14-l66-002", "I was reading an interesting storybook at eight pm.", "রাত আটটায় আমি একটি মজার গল্পের বই পড়ছিলাম।", "আই ওয়াজ রিডিং অ্যান ইন্টারেস্টিং স্টোরিবুক অ্যাট এইট পিএম।"),
            ("en-p14-l66-003", "They were playing cricket in the open field all afternoon.", "তারা পুরো বিকেল জুড়ে উন্মুক্ত মাঠে ক্রিকেট খেলছিল।", "দে ওয়্যার প্লেয়িং ক্রিকেট ইন দি ওপেন ফিল্ড অল আফটারনুন।"),
            ("en-p14-l66-004", "He was preparing his final presentation slides last night.", "সে গত রাতে তার চূড়ান্ত প্রেজেন্টেশন স্লাইড তৈরি করছিল।", "হি ওয়াজ প্রিপেয়ারিং হিজ ফাইনাল প্রেজেন্টেশন স্লাইডস লাস্ট নাইট।"),
            ("en-p14-l66-005", "It was raining heavily when we stepped outside.", "আমরা যখন বাইরে পা রেখেছিলাম তখন মুষলধারে বৃষ্টি হচ্ছিল।", "ইট ওয়াজ রেইনিং হেভিলি হোয়েন উই স্টেপড আউটসাইড।"),
            ("en-p14-l66-006", "We were having lunch together at the restaurant.", "আমরা রেস্তোরাঁয় একসাথে দুপুরের খাবার খাচ্ছিলাম।", "উই ওয়্যার হ্যাভিং লাঞ্চ টুগেদার অ্যাট দ্য রেস্টুরেন্ট।"),
            ("en-p14-l66-007", "She was waiting for the city bus at the stoppage.", "সে বাস স্টপেজে শহরের বাসের জন্য অপেক্ষা করছিল।", "শি ওয়াজ ওয়েটিং ফর দ্য সিটি বাস অ্যাট দ্য স্টপেজ।"),
            ("en-p14-l66-008", "The children were sleeping peacefully in their bedroom.", "বাচ্চারা তাদের শোবার ঘরে শান্তভাবে ঘুমাচ্ছিল।", "দ্য চিলড্রেন ওয়্যার স্লিপিং পিসফুলি ইন দেয়ার বেডরুম।")
        ]
    },
    {
        "id": "en-foundations-l67",
        "order": 2,
        "title_bn": "অতীতে চলমান না-বোধক — 'Wasn't / Weren't + Verb-ING' (Negative)",
        "title_target": "Negative Ongoing Past Actions (Wasn't / Weren't + ING)",
        "intro_bn": "অতীতে কোনো নির্দিষ্ট সময়ে কাজ চলছিল না বোঝাতে 'was not' (wasn't) বা 'were not' (weren't) এবং Verb-ING বসে।",
        "structure": [
            "I / He / She / It + wasn't + Verb-ING",
            "We / You / They + weren't + Verb-ING"
        ],
        "items": [
            ("en-p14-l67-001", "She wasn't cooking when I arrived at her house.", "আমি যখন তার বাড়িতে পৌঁছাই তখন সে রান্না করছিল না।", "শি ওয়াজন্ট কুকিং হোয়েন আই অ্যারাইভড অ্যাট হার হাউজ।"),
            ("en-p14-l67-002", "I wasn't sleeping when you called me last night.", "গত রাতে তুমি যখন আমাকে ফোন করেছিলে তখন আমি ঘুমাচ্ছিলাম না।", "আই ওয়াজন্ট স্লিপিং হোয়েন ইউ কল্ড মি লাস্ট নাইট।"),
            ("en-p14-l67-003", "They weren't paying attention to the teacher's lecture.", "তারা শিক্ষকের বক্তব্যের দিকে মনোযোগ দিচ্ছিল না।", "দে ওয়্যারন্ট পেয়িং অ্যাটেনশন টু দ্য টিচার্স লেকচার।"),
            ("en-p14-l67-004", "He wasn't working on his computer yesterday evening.", "গতকাল সন্ধ্যায় সে কম্পিউটারে কাজ করছিল না।", "হি ওয়াজন্ট ওয়ার্কিং অন হিজ কম্পিউটার ইয়েস্টারডে ইভনিং।"),
            ("en-p14-l67-005", "It wasn't raining when we left the office building.", "আমরা যখন অফিস ভবন থেকে বের হই তখন বৃষ্টি হচ্ছিল না।", "ইট ওয়াজন্ট রেইনিং হোয়েন উই লেফট দি অফিস বিল্ডিং।"),
            ("en-p14-l67-006", "We weren't watching television at that exact moment.", "আমরা ঠিক সেই মুহূর্তে টেলিভিশন দেখছিলাম না।", "উই ওয়্যারন্ট ওয়াচিং টেলিভিশন অ্যাট দ্যাট এক্স্যাক্ট মোমেন্ট।"),
            ("en-p14-l67-007", "She wasn't driving the car when the accident occurred.", "দুর্ঘটনা ঘটার সময় সে গাড়ি চালাচ্ছিল না।", "শি ওয়াজন্ট ড্রাইভিং দ্য কার হোয়েন দি অ্যাক্সিডেন্ট অকার্ড।"),
            ("en-p14-l67-008", "They weren't arguing about anything serious.", "তারা গুরুতর কিছু নিয়ে তর্ক করছিল না।", "দে ওয়্যারন্ট আর্গুয়িং অ্যাবাউট অ্যানিথিং সিরিয়াস।")
        ]
    },
    {
        "id": "en-foundations-l68",
        "order": 3,
        "title_bn": "'When' ও 'While' এর ব্যবহার (Interrupted Past Actions)",
        "title_target": "Interrupted Past Actions ('When' & 'While')",
        "intro_bn": "অতীতে একটি কাজ চলাকালে হঠাৎ অন্য একটি কাজ ঘটলে চলমান অংশটি Past Continuous এবং হঠাৎ ঘটা অংশটি Past Simple হয়। 'While' এর পর সাধারণত চলমান এবং 'When' এর পর সাধারণত হঠাৎ ঘটা অংশ বসে।",
        "structure": [
            "Past Continuous + when + Past Simple (I was reading when the phone rang)",
            "While + Past Continuous + Past Simple (While I was walking, I found a wallet)"
        ],
        "items": [
            ("en-p14-l68-001", "I was reading a book when the phone suddenly rang.", "আমি একটি বই পড়ছিলাম যখন হঠাৎ ফোনটি বেজে উঠল।", "আই ওয়াজ রিডিং আ বুক হোয়েন দ্য ফোন সাডেনলি র‍্যাং।"),
            ("en-p14-l68-002", "While I was walking in the park, I found a leather wallet.", "পার্কে হাঁটার সময় আমি একটি চামড়ার মানিব্যাগ পেয়েছিলাম।", "হোয়াইল আই ওয়াজ ওয়াকিং ইন দ্য পার্ক, আই ফাউন্ড আ লেদার ওয়ালেট।"),
            ("en-p14-l68-003", "She was driving to work when her car broke down.", "সে গাড়িতে চড়ে অফিসে যাচ্ছিল যখন তার গাড়িটি বিকল হয়ে পড়েছিল।", "শি ওয়াজ ড্রাইভিং টু ওয়ার্ক হোয়েন হার কার ব্রোক ডাউন।"),
            ("en-p14-l68-004", "While we were having dinner, the electricity went out.", "আমরা যখন রাতের খাবার খাচ্ছিলাম, তখন বিদ্যুৎ চলে গিয়েছিল।", "হোয়াইল উই ওয়্যার হ্যাভিং ডিনার, দি ইলেকট্রিসিটি ওয়েন্ট আউট।"),
            ("en-p14-l68-005", "He was crossing the busy street when he saw his teacher.", "সে ব্যস্ত রাস্তা পার হচ্ছিল যখন সে তার শিক্ষককে দেখতে পেয়েছিল।", "হি ওয়াজ ক্রসিং দ্য বিজি স্ট্রিট হোয়েন হি স হিজ টিচার।"),
            ("en-p14-l68-006", "While she was cooking, she burned her hand slightly.", "রান্না করার সময় সে তার হাত সামান্য পুড়িয়ে ফেলেছিল।", "হোয়াইল শি ওয়াজ কুকিং, শি বার্নড হার হ্যান্ড স্লাইটলি।"),
            ("en-p14-l68-007", "They were watching a football match when the guests arrived.", "তারা ফুটবল ম্যাচ দেখছিল যখন অতিথিরা এসে পৌঁছেছিল।", "দে ওয়্যার ওয়াচিং আ ফুটবল ম্যাচ হোয়েন দ্য গেস্টস অ্যারাইভড।"),
            ("en-p14-l68-008", "What were you doing when the earthquake occurred?", "ভূমিকম্পটি ঘটার সময় আপনি কী করছিলেন?", "হোয়াট ওয়্যার ইউ ডুইং হোয়েন দি আর্থকোয়েক অকার্ড?")
        ]
    },
    {
        "id": "en-foundations-l69",
        "order": 4,
        "title_bn": "অতীতের চলমান প্রশ্নোত্তর — 'Were you doing...?' (Continuous Q&A)",
        "title_target": "Past Continuous Questions & Answers",
        "intro_bn": "অতীতে কেউ কোনো কাজ করছিল কি না জানতে 'Was/Were + Subject + Verb-ING...?' দিয়ে প্রশ্ন করা হয়।",
        "structure": [
            "Was / Were + Subject + Verb-ING...?",
            "What were you doing at (time)...?"
        ],
        "items": [
            ("en-p14-l69-001", "Was she cooking dinner when you came home? Yes, she was cooking. No, she wasn't cooking.", "তুমি বাসায় এলে সে কি রাতের খাবার রান্না করছিল? হ্যাঁ, সে রান্না করছিল। না, সে রান্না করছিল না।", "ওয়াজ শি কুকিং ডিনার হোয়েন ইউ কেইম হোম? ইয়েস, শি ওয়াজ কুকিং। নো, শি ওয়াজন্ট কুকিং।"),
            ("en-p14-l69-002", "Were you sleeping when I called you? Yes, I was sleeping. No, I was not sleeping.", "আমি যখন ফোন করেছিলাম আপনি কি ঘুমাচ্ছিলেন? হ্যাঁ, আমি ঘুমাচ্ছিলাম। না, আমি ঘুমাচ্ছিলাম না।", "ওয়্যার ইউ স্লিপিং হোয়েন আই কল্ড ইউ? ইয়েস, আই ওয়াজ স্লিপিং। নো, আই ওয়াজ নট স্লিপিং।"),
            ("en-p14-l69-003", "What were you doing yesterday at eight pm? I was preparing my office presentation.", "গতকাল রাত আটটায় আপনি কী করছিলেন? আমি আমার অফিসের প্রেজেন্টেশন তৈরি করছিলাম।", "হোয়াট ওয়্যার ইউ ডুইং ইয়েস্টারডে অ্যাট এইট পিএম? আই ওয়াজ প্রিপেয়ারিং মাই অফিস প্রেজেন্টেশন।"),
            ("en-p14-l69-004", "Were they waiting for you at the station? Yes, they were waiting for me.", "তারা কি স্টেশনে আপনার জন্য অপেক্ষা করছিল? হ্যাঁ, তারা আমার জন্য অপেক্ষা করছিল।", "ওয়্যার দে ওয়েটিং ফর ইউ অ্যাট দ্য স্টেশন? ইয়েস, দে ওয়্যার ওয়েটিং ফর মি।"),
            ("en-p14-l69-005", "Where were you going when I saw you yesterday? I was going to the supermarket.", "গতকাল যখন আপনাকে দেখলাম আপনি কোথায় যাচ্ছিলেন? আমি সুপারমার্কেটে যাচ্ছিলাম।", "হোয়ার ওয়্যার ইউ গোয়িং হোয়েন আই স ইউ ইয়েস্টারডে? আই ওয়াজ গোয়িং টু দ্য সুপারমার্কেট।"),
            ("en-p14-l69-006", "Was it raining heavily when you left the house? Yes, it was raining heavily.", "বাড়ি থেকে বের হওয়ার সময় কি মুষলধারে বৃষ্টি হচ্ছিল? হ্যাঁ, মুষলধারে বৃষ্টি হচ্ছিল।", "ওয়াজ ইট রেইনিং হেভিলি হোয়েন ইউ লেফট দ্য হাউজ? ইয়েস, ইট ওয়াজ রেইনিং হেভিলি।"),
            ("en-p14-l69-007", "Who were you talking to on the phone? I was talking to my elder brother.", "ফোনে আপনি কার সাথে কথা বলছিলেন? আমি আমার বড় ভাইয়ের সাথে কথা বলছিলাম।", "হু ওয়্যার ইউ টকিং টু অন দ্য ফোন? আই ওয়াজ টকিং টু মাই এল্ডার ব্রাদার।"),
            ("en-p14-l69-008", "Were you working late at the office yesterday? Yes, I was working until nine pm.", "গতকাল আপনি কি অফিসে দেরিতে কাজ করছিলেন? হ্যাঁ, আমি রাত নয়টা পর্যন্ত কাজ করছিলাম।", "ওয়্যার ইউ ওয়ার্কিং লেইট অ্যাট দি অফিস ইয়েস্টারডে? ইয়েস, আই ওয়াজ ওয়ার্কিং আনটিল নাইন পিএম।")
        ]
    }
]

# ==============================================================================
# PART 15: Past Modals & Habits (Used to, Had to, Wanted to, Could)
# ==============================================================================
p15_lessons = [
    {
        "id": "en-foundations-l70",
        "order": 1,
        "title_bn": "অতীতের অভ্যাস — 'Used to + V1' (Past Habits)",
        "title_target": "Past Habits (Used to + Verb V1)",
        "intro_bn": "অতীতে নিয়মিত কোনো কাজ করা হতো কিন্তু বর্তমানে আর করা হয় না এমন অভ্যাস বোঝাতে 'used to + Verb (V1)' বসে।",
        "structure": [
            "Subject + used to + Verb (Base form V1)",
            "Negative: didn't use to + Verb (V1)"
        ],
        "items": [
            ("en-p15-l70-001", "I used to play cricket every single afternoon in my school days.", "স্কুলজীবনে আমি প্রতিদিন বিকেলে ক্রিকেট খেলতাম।", "আই ইউজড টু প্লে ক্রিকেট এভরি সিঙ্গেল আফটারনুন ইন মাই স্কুল ডেইজ।"),
            ("en-p15-l70-002", "He used to live in Sylhet before moving to Dhaka.", "ঢাকায় আসার আগে তিনি সিলেটে বসবাস করতেন।", "হি ইউজড টু লিভ ইন সিলেট বিফোর মুভিং টু ঢাকা।"),
            ("en-p15-l70-003", "She used to wake up very early in the morning.", "তিনি খুব ভোরে ঘুম থেকে উঠতেন।", "শি ইউজড টু ওয়েক আপ ভেরি আর্লি ইন দ্য মর্নিং।"),
            ("en-p15-l70-004", "We used to swim in the village pond every summer.", "প্রতি গ্রীষ্মে আমরা গ্রামের পুকুরে সাঁতার কাটতাম।", "উই ইউজড টু সুইম ইন দ্য ভিলেজ পন্ড এভরি সামার।"),
            ("en-p15-l70-005", "They used to travel to Cox's Bazar every winter.", "প্রতি শীতে তারা কক্সবাজার ঘুরতে যেত।", "দে ইউজড টু ট্রাভেল টু কক্সবাজার এভরি উইন্টার।"),
            ("en-p15-l70-006", "I didn't use to like vegetables when I was a child.", "ছোটবেলায় আমি শাকসবজি পছন্দ করতাম না।", "আই ডিডন্ট ইউজ টু লাইক ভেজিটেবলস হোয়েন আই ওয়াজ আ চাইল্ড।"),
            ("en-p15-l70-007", "Did you use to practice English regularly? Yes, I used to practice every day.", "আপনি কি নিয়মিত ইংরেজি অনুশীলন করতেন? হ্যাঁ, আমি প্রতিদিন অনুশীলন করতাম।", "ডিড ইউ ইউজ টু প্র্যাকটিস ইংলিশ রেগুলারলি? ইয়েস, আই ইউজড টু প্র্যাকটিস এভরি ডে।"),
            ("en-p15-l70-008", "My grandfather used to walk five kilometers every morning.", "আমার দাদা প্রতিদিন সকালে পাঁচ কিলোমিটার হাঁটতেন।", "মাই গ্র্যান্ডফাদার ইউজড টু ওয়াক ফাইভ কিলোমিটার্স এভরি মর্নিং।")
        ]
    },
    {
        "id": "en-foundations-l71",
        "order": 2,
        "title_bn": "অতীতের বাধ্যবাধকতা — 'Had to + V1' (Past Obligations)",
        "title_target": "Past Obligations (Had to + Verb V1)",
        "intro_bn": "অতীতে কোনো কিছু করতে হয়েছিল বা বাধ্যবাধকতা ছিল বোঝাতে 'have to / has to' এর অতীত রূপ 'had to + Verb (V1)' বসে। না-বোধকে 'didn't have to' বসে।",
        "structure": [
            "Subject + had to + Verb (Base form V1)",
            "Negative: didn't have to + Verb (V1)"
        ],
        "items": [
            ("en-p15-l71-001", "I had to wake up at five in the morning yesterday.", "গতকাল সকালে আমাকে পাঁচটায় ঘুম থেকে উঠতে হয়েছিল।", "আই হ্যাড টু ওয়েক আপ অ্যাট ফাইভ ইন দ্য মর্নিং ইয়েস্টারডে।"),
            ("en-p15-l71-002", "He had to submit his report by noon.", "দুপুরের মধ্যে তাকে তার প্রতিবেদন জমা দিতে হয়েছিল।", "হি হ্যাড টু সাবমিট হিজ রিপোর্ট বাই নুন।"),
            ("en-p15-l71-003", "We had to cancel our family trip due to heavy rain.", "ভারী বৃষ্টির কারণে আমাদের পারিবারিক ভ্রমণ বাতিল করতে হয়েছিল।", "উই হ্যাড টু ক্যানসেল আওয়ার ফ্যামিলি ট্রিপ ডিউ টু হেভি রেইন।"),
            ("en-p15-l71-004", "She had to take medicine three times a day last week.", "গত সপ্তাহে তাকে দিনে তিনবার ওষুধ খেতে হয়েছিল।", "শি হ্যাড টু টেক মেডিসিন থ্রি টাইমস আ ডে লাস্ট উইক।"),
            ("en-p15-l71-005", "They had to wait for two hours at the train station.", "তাদের ট্রেন স্টেশনে দুই ঘণ্টা অপেক্ষা করতে হয়েছিল।", "দে হ্যাড টু ওয়েট ফর টু আওয়ার্স অ্যাট দ্য ট্রেন স্টেশন।"),
            ("en-p15-l71-006", "I didn't have to pay any extra fee for the service.", "এই সেবার জন্য আমাকে কোনো অতিরিক্ত ফি দিতে হয়নি।", "আই ডিডন্ট হ্যাভ টু পে অ্যানি এক্সট্রা ফি ফর দ্য সার্ভিস।"),
            ("en-p15-l71-007", "Did you have to work overtime yesterday? Yes, I had to work late. No, I didn't have to work late.", "গতকাল কি আপনাকে ওভারটাইম কাজ করতে হয়েছিল? হ্যাঁ, আমাকে রাত পর্যন্ত কাজ করতে হয়েছিল। না, করতে হয়নি।", "ডিড ইউ হ্যাভ টু ওয়ার্ক ওভারটাইম ইয়েস্টারডে? ইয়েস, আই হ্যাড টু ওয়ার্ক লেইট। নো, আই ডিডন্ট হ্যাভ টু ওয়ার্ক লেইট।"),
            ("en-p15-l71-008", "Why did you have to leave early? Because I had an urgent appointment.", "আপনাকে তাড়াতাড়ি চলে যেতে হয়েছিল কেন? কারণ আমার জরুরি অ্যাপয়েন্টমেন্ট ছিল।", "হোয়াই ডিড ইউ হ্যাভ টু লিভ আর্লি? বিকজ আই হ্যাড অ্যান আর্জেন্ট অ্যাপয়েন্টমেন্ট।")
        ]
    },
    {
        "id": "en-foundations-l72",
        "order": 3,
        "title_bn": "অতীতের ইচ্ছা ও প্রয়োজন — 'Wanted to' ও 'Needed to'",
        "title_target": "Past Desires & Needs (Wanted to & Needed to)",
        "intro_bn": "অতীতে কিছু করার ইচ্ছা ছিল বোঝাতে 'wanted to' এবং দরকার বা প্রয়োজন ছিল বোঝাতে 'needed to' বসে।",
        "structure": [
            "Subject + wanted to / needed to + Verb (V1)",
            "Negative: didn't want to / didn't need to + Verb (V1)"
        ],
        "items": [
            ("en-p15-l72-001", "I wanted to meet you yesterday, but I was extremely busy.", "আমি গতকাল আপনার সাথে দেখা করতে চেয়েছিলাম, কিন্তু আমি অত্যন্ত ব্যস্ত ছিলাম।", "আই ওয়ান্টেড টু মিট ইউ ইয়েস্টারডে, বাট আই ওয়াজ এক্সট্রিমলি বিজি।"),
            ("en-p15-l72-002", "He wanted to buy that laptop, but it was too expensive.", "সে সেই ল্যাপটপটি কিনতে চেয়েছিল, কিন্তু এটি খুব দামি ছিল।", "হি ওয়ান্টেড টু বাই দ্যাট ল্যাপটপ, বাট ইট ওয়াজ টু এক্সপেন্সিভ।"),
            ("en-p15-l72-003", "I needed to talk to my manager regarding the project.", "প্রজেক্টের ব্যাপারে আমার ম্যানেজারের সাথে কথা বলা প্রয়োজন ছিল।", "আই নিডেড টু টক টু মাই ম্যানেজার রিগার্ডিং দ্য প্রজেক্ট।"),
            ("en-p15-l72-004", "She needed to buy some emergency medicine last night.", "গত রাতে তার কিছু জরুরি ওষুধ কেনা দরকার ছিল।", "শি নিডেড টু বাই সাম ইমার্জেন্সি মেডিসিন লাস্ট নাইট।"),
            ("en-p15-l72-005", "They didn't want to disclose the confidential information.", "তারা গোপনীয় তথ্য প্রকাশ করতে চায়নি।", "দে ডিডন্ট ওয়ান্ট টু ডিসক্লোজ দ্য কনফিডেনশিয়াল ইনফরমেশন।"),
            ("en-p15-l72-006", "We didn't need to hire a taxi because my brother picked us up.", "আমাদের ট্যাক্সি ভাড়া করার প্রয়োজন হয়নি কারণ আমার ভাই আমাদের নিতে এসেছিল।", "উই ডিডন্ট নিড টু হায়ার আ ট্যাক্সি বিকজ মাই ব্রাদার পিক্ট আস আপ।"),
            ("en-p15-l72-007", "What did you want to say to me? I wanted to thank you for your help.", "আপনি আমাকে কী বলতে চেয়েছিলেন? আমি আপনার সাহায্যের জন্য ধন্যবাদ জানাতে চেয়েছিলাম।", "হোয়াট ডিড ইউ ওয়ান্ট টু সে টু মি? আই ওয়ান্টেড টু থ্যাংক ইউ ফর ইয়োর হেল্প।"),
            ("en-p15-l72-008", "Did you need any help yesterday? No, I managed everything myself.", "গতকাল আপনার কি কোনো সাহায্যের দরকার ছিল? না, আমি নিজেই সব সামলে নিয়েছি।", "ডিড ইউ নিড অ্যানি হেল্প ইয়েস্টারডে? নো, আই ম্যানেজড এভরিথিং মাইসেলফ।")
        ]
    },
    {
        "id": "en-foundations-l73",
        "order": 4,
        "title_bn": "অতীতের সামর্থ্য — 'Could / Couldn't' (Past Ability)",
        "title_target": "Past Ability & Inability (Could / Couldn't + V1)",
        "intro_bn": "অতীতে কোনো কাজ করার সামর্থ্য ছিল ('পারতাম') বোঝাতে 'could' এবং পারতাম না বা সম্ভব হয়নি বোঝাতে 'couldn't' বসে।",
        "structure": [
            "Subject + could / couldn't + Verb (Base form V1)",
            "Could you...? (অতীতের সামর্থ্য বা ভদ্র অনুরোধ)"
        ],
        "items": [
            ("en-p15-l73-001", "I could swim very fast when I was younger.", "আমি যখন ছোট ছিলাম তখন খুব দ্রুত সাঁতার কাটতে পারতাম।", "আই কুড সুইম ভেরি ফাস্ট হোয়েন আই ওয়াজ ইয়ঙ্গার।"),
            ("en-p15-l73-002", "She could speak three foreign languages fluently.", "তিনি সাবলীলভাবে তিনটি বিদেশি ভাষায় কথা বলতে পারতেন।", "শি কুড স্পিক থ্রি ফরেন ল্যাঙ্গুয়েজেস ফ্লুয়েন্টলি।"),
            ("en-p15-l73-003", "I couldn't attend the meeting because of a traffic jam.", "ট্রাফিক জ্যামের কারণে আমি সভায় উপস্থিত হতে পারিনি।", "আই কুডন্ট অ্যাটেন্ড দ্য মিটিং বিকজ অব আ ট্রাফিক জ্যাম।"),
            ("en-p15-l73-004", "He couldn't sleep well last night due to loud noise.", "প্রচণ্ড শব্দের কারণে গত রাতে তিনি ভালো ঘুমাতে পারেননি।", "হি কুডন্ট স্লিপ ওয়েল লাস্ট নাইট ডিউ টু লাউড নয়েজ।"),
            ("en-p15-l73-005", "We couldn't find your address easily yesterday.", "গতকাল আমরা সহজেই আপনার ঠিকানা খুঁজে পাইনি।", "উই কুডন্ট ফাইন্ড ইয়োর অ্যাড্রেস ইজিলি ইয়েস্টারডে।"),
            ("en-p15-l73-006", "Could you hear my voice clearly on the call? Yes, I could hear you clearly. No, I couldn't hear you.", "ফোনে কি আপনি আমার কণ্ঠ স্পষ্টভাবে শুনতে পেরেছিলেন? হ্যাঁ, পরিষ্কার শুনতে পেরেছিলাম। না, শুনতে পারিনি।", "কুড ইউ হেয়ার মাই ভয়েস ক্লিয়ারলি অন দ্য কল? ইয়েস, আই কুড হেয়ার ইউ ক্লিয়ারলি। নো, আই কুডন্ট হেয়ার ইউ।"),
            ("en-p15-l73-007", "They couldn't finish the construction work on time.", "তারা সময়মতো নির্মাণ কাজ শেষ করতে পারেনি।", "দে কুডন্ট ফিনিশ দ্য কনস্ট্রাকশন ওয়ার্ক অন টাইম।"),
            ("en-p15-l73-008", "Could you understand what he said in the lecture? Yes, I could understand everything.", "লেকচারে তিনি কী বলেছিলেন তা কি আপনি বুঝতে পেরেছিলেন? হ্যাঁ, আমি সবকিছু বুঝতে পেরেছিলাম।", "কুড ইউ আন্ডারস্ট্যান্ড হোয়াট হি সেইড ইন দ্য লেকচার? ইয়েস, আই কুড আন্ডারস্ট্যান্ড এভরিথিং।")
        ]
    }
]

# ==============================================================================
# PART 16: Past Perfect Tense (Had + V3)
# ==============================================================================
p16_lessons = [
    {
        "id": "en-foundations-l74",
        "order": 1,
        "title_bn": "দুটি অতীত কাজের পূর্ববর্তী কাজ — 'Had + V3' (Past Perfect)",
        "title_target": "Earlier Past Action (Subject + Had + V3)",
        "intro_bn": "অতীতে দুটি কাজ ঘটে থাকলে তাদের মধ্যে অপেক্ষাকৃত পূর্ববর্তী কাজটি Past Perfect (had + V3) এবং পরবর্তী কাজটি Past Simple (V2) হয়।",
        "structure": [
            "Earlier Action: Subject + had + V3 (Past Participle)",
            "Later Action: Subject + V2 (Past Simple)"
        ],
        "items": [
            ("en-p16-l74-001", "She had done her homework before I came to visit her.", "আমি তার সাথে দেখা করতে আসার আগেই সে বাড়ির কাজ শেষ করেছিল।", "শি হ্যাড ডান হার হোমওয়ার্ক বিফোর আই কেইম টু ভিজিট হার।"),
            ("en-p16-l74-002", "The train had already left when we reached the platform.", "আমরা যখন প্ল্যাটফর্মে পৌঁছাই তখন ট্রেনটি ইতিমধ্যেই ছেড়ে গিয়েছিল।", "দ্য ট্রেন হ্যাড অলরেডি লেফট হোয়েন উই রীচড দ্য প্ল্যাটফর্ম।"),
            ("en-p16-l74-003", "I had finished my dinner before eight o'clock yesterday.", "গতকাল রাত আটটার আগেই আমি আমার রাতের খাবার শেষ করেছিলাম।", "আই হ্যাড ফিনিশড মাই ডিনার বিফোর এইট ও'ক্লক ইয়েস্টারডে।"),
            ("en-p16-l74-004", "They had sold their house before moving to another country.", "অন্য দেশে যাওয়ার আগেই তারা তাদের বাড়ি বিক্রি করে দিয়েছিল।", "দে হ্যাড সোল্ড দেয়ার হাউজ বিফোর মুভিং টু অ্যানাদার কান্ট্রি।"),
            ("en-p16-l74-005", "He had already informed the manager before submitting the leave letter.", "ছুটির দরখাস্ত জমা দেওয়ার আগেই তিনি ম্যানেজারকে জানিয়েছিলেন।", "হি হ্যাড অলরেডি ইনফর্মড দ্য ম্যানেজার বিফোর সাবমিটিং দ্য লিভ লেটার।"),
            ("en-p16-l74-006", "We had completed our project before the deadline arrived.", "সময়সীমা আসার আগেই আমরা আমাদের প্রজেক্ট সম্পন্ন করেছিলাম।", "উই হ্যাড কমপ্লিটেড আওয়ার প্রজেক্ট বিফোর দ্য ডেডলাইন অ্যারাইভড।"),
            ("en-p16-l74-007", "Had she done her homework before you arrived? Yes, she had already done it. No, she hadn't done it.", "তুমি আসার আগেই কি সে বাড়ির কাজ শেষ করেছিল? হ্যাঁ, সে আগেই শেষ করেছিল। না, সে করেনি।", "হ্যাড শি ডান হার হোমওয়ার্ক বিফোর ইউ অ্যারাইভড? ইয়েস, শি হ্যাড অলরেডি ডান ইট। নো, শি হ্যাডন্ট ডান ইট।"),
            ("en-p16-l74-008", "The patient had recovered before the specialist doctor arrived.", "বিশেষজ্ঞ চিকিৎসক আসার আগেই রোগী সুস্থ হয়ে উঠেছিল।", "দ্য পেশেন্ট হ্যাড রিকভার্ড বিফোর দ্য স্পেশালিস্ট ডক্টর অ্যারাইভড।")
        ]
    },
    {
        "id": "en-foundations-l75",
        "order": 2,
        "title_bn": "'Before' ও 'After' এর সঠিক ব্যবহার (Rules of Before & After)",
        "title_target": "Using 'Before' & 'After' in Past Perfect",
        "intro_bn": "গোল্ডেন রুল: 'Before' এর পূর্বে Past Perfect (had + V3) বসে এবং 'After' এর পরে Past Perfect (had + V3) বসে।",
        "structure": [
            "Past Perfect + BEFORE + Past Simple",
            "Past Simple + AFTER + Past Perfect"
        ],
        "items": [
            ("en-p16-l75-001", "The movie had started before we entered the hall.", "আমরা হলে প্রবেশের পূর্বেই সিনেমা শুরু হয়ে গিয়েছিল।", "দ্য মুভি হ্যাড স্টার্টেড বিফোর উই এন্টার্ড দ্য হল।"),
            ("en-p16-l75-002", "We entered the cinema hall after the movie had started.", "সিনেমা শুরু হওয়ার পর আমরা সিনেমা হলে প্রবেশ করেছিলাম।", "উই এন্টার্ড দ্য সিনেমা হল আফটার দ্য মুভি হ্যাড স্টার্টেড।"),
            ("en-p16-l75-003", "I had locked all the doors before I went to bed.", "ঘুমাতে যাওয়ার আগেই আমি সব দরজা তালা দিয়েছিলাম।", "আই হ্যাড লকড অল দ্য ডোরস বিফোর আই ওয়েন্ট টু বেড।"),
            ("en-p16-l75-004", "He called me after he had reached the hotel.", "হোটেলে পৌঁছানোর পর সে আমাকে ফোন করেছিল।", "হি কল্ড মি আফটার হি হ্যাড রীচড দ্য হোটেল।"),
            ("en-p16-l75-005", "She had prepared breakfast before everyone woke up.", "সবার ঘুম ভাঙার আগেই সে সকালের নাস্তা তৈরি করেছিল।", "শি হ্যাড প্রিপেয়ার্ড ব্রেকফাস্ট বিফোর এভরিওয়ান ওক আপ।"),
            ("en-p16-l75-006", "They departed after the rain had stopped.", "বৃষ্টি থামার পর তারা রওনা হয়েছিল।", "দে ডিপার্টেড আফটার দ্য রেইন হ্যাড স্টপড।"),
            ("en-p16-l75-007", "I had never seen him before that memorable conference.", "সেই স্মরণীয় সম্মেলনের আগে আমি তাকে কখনো দেখিনি।", "আই হ্যাড নেভার সিন হিম বিফোর দ্যাট মেমোরেবল কনফারেন্স।"),
            ("en-p16-l75-008", "She went home after she had completed her duty.", "দায়িত্ব শেষ করার পর সে বাড়ি গিয়েছিল।", "শি ওয়েন্ট হোম আফটার শি হ্যাড কমপ্লিটেড হার ডিউটি।")
        ]
    },
    {
        "id": "en-foundations-l76",
        "order": 3,
        "title_bn": "'By the time' ও অতীতের অভিজ্ঞতা (Past Perfect with 'By the time')",
        "title_target": "Past Perfect with 'By the time' & Prior Experiences",
        "intro_bn": "অতীতে নির্দিষ্ট সময়ের মধ্যে বা অন্য কোনো ঘটনা ঘটার আগ পর্যন্ত কাজ শেষ হয়েছিল বোঝাতে 'by the time' এবং অভিজ্ঞতা প্রকাশে 'had never / had already' বসে।",
        "structure": [
            "By the time + Past Simple, Subject + had + V3",
            "Subject + had never + V3 + before"
        ],
        "items": [
            ("en-p16-l76-001", "By the time he arrived, the meeting had already ended.", "তিনি পৌঁছানোর আগেই সভা শেষ হয়ে গিয়েছিল।", "বাই দ্য টাইম হি অ্যারাইভড, দ্য মিটিং হ্যাড অলরেডি এন্ডেড।"),
            ("en-p16-l76-002", "By the time the police came, the thieves had fled.", "পুলিশ আসার আগেই চোরেরা পালিয়ে গিয়েছিল।", "বাই দ্য টাইম দ্য পুলিশ কেইম, দ্য থিভস হ্যাড ফ্লেড।"),
            ("en-p16-l76-003", "I had never tasted such authentic cuisine before that trip.", "সেই ভ্রমণের আগে আমি কখনো এমন আসল খাবার খাইনি।", "আই হ্যাড নেভার টেস্টেড সাচ অথেনটিক ক্যুইজিন বিফোর দ্যাট ট্রিপ।"),
            ("en-p16-l76-004", "By the time she called me, I had already fixed the bug.", "তিনি আমাকে ফোন করার আগেই আমি বাগটি ঠিক করে ফেলেছিলাম।", "বাই দ্য টাইম শি কল্ড মি, আই হ্যাড অলরেডি ফিক্সড দ্য বাগ।"),
            ("en-p16-l76-005", "She had never flown in an airplane before last year.", "গত বছরের আগে তিনি কখনো বিমানে ওঠেননি।", "শি হ্যাড নেভার ফ্লোন ইন অ্যান এয়ারপ্লেন বিফোর লাস্ট ইয়ার।"),
            ("en-p16-l76-006", "By midnight, all the invited guests had departed safely.", "মধ্যরাতের মধ্যে সকল আমন্ত্রিত অতিথি নিরাপদে প্রস্থান করেছিলেন।", "বাই মিডনাইট, অল দি ইনভাইটেড গেস্টস হ্যাড ডিপার্টেড সেফলি।"),
            ("en-p16-l76-007", "Had you visited the city before moving there? Yes, I had visited it once.", "সেখানে বসবাসের আগে আপনি কি শহরটি ঘুরে দেখেছিলেন? হ্যাঁ, আমি একবার দেখেছিলাম।", "হ্যাড ইউ ভিজিটেড দ্য সিটি বিফোর মুভিং দেয়ার? ইয়েস, আই হ্যাড ভিজিটেড ইট ওয়ান্স।"),
            ("en-p16-l76-008", "By the time we got the tickets, the show had started.", "আমরা টিকিট পাওয়ার আগেই প্রদর্শনী শুরু হয়ে গিয়েছিল।", "বাই দ্য টাইম উই গট দ্য টিকেটস, দ্য শো হ্যাড স্টার্টেড।")
        ]
    }
]

# ==============================================================================
# PART 17: Past Perfect Continuous (Had been + Verb-ING)
# ==============================================================================
p17_lessons = [
    {
        "id": "en-foundations-l77",
        "order": 1,
        "title_bn": "নির্দিষ্ট সময় ধরে চলা অতীত কাজ — 'Had been + Verb-ING'",
        "title_target": "Ongoing Action Before Past Event (Had been + Verb-ING)",
        "intro_bn": "অতীতে কোনো কাজ বিশেষ কোনো সময়ের পূর্ব হতে আরম্ভ হয়ে সেই সময় পর্যন্ত চলছিল বোঝালে Past Perfect Continuous Tense হয়।",
        "structure": [
            "Subject + had been + Verb-ING + for (2 hours / 3 months)",
            "Subject + had been + Verb-ING + since (morning / Monday)"
        ],
        "items": [
            ("en-p17-l77-001", "She had been cooking in the kitchen for hours when I came home.", "আমি যখন বাড়ি আসি তখন সে কয়েক ঘণ্টা ধরে রান্নাঘরে রান্না করছিল।", "শি হ্যাড বিন কুকিং ইন দ্য কিচেন ফর আওয়ার্স হোয়েন আই কেইম হোম।"),
            ("en-p17-l77-002", "He had been waiting for the bus for forty minutes before it finally arrived.", "বাস আসার আগে সে চল্লিশ মিনিট ধরে অপেক্ষা করছিল।", "হি হ্যাড বিন ওয়েটিং ফর দ্য বাস ফর ফোরটি মিনিট্স বিফোর ইট ফাইনালি অ্যারাইভড।"),
            ("en-p17-l77-003", "They had been working on the software for six months before launching it.", "সফটওয়্যারটি লঞ্চ করার আগে তারা ছয় মাস ধরে এটিতে কাজ করছিল।", "দে হ্যাড বিন ওয়ার্কিং অন দ্য সফটওয়্যার ফর সিক্স মান্থস বিফোর লঞ্চিং ইট।"),
            ("en-p17-l77-004", "It had been raining continuously since morning before the sun broke through.", "সূর্য ওঠার আগে সকাল থেকেই একটানা বৃষ্টি হচ্ছিল।", "ইট হ্যাড বিন রেইনিং কন্টিনিউয়াসলি সিন্স মর্নিং বিফোর দ্য সান ব্রোক থ্রু।"),
            ("en-p17-l77-005", "Had she been cooking for hours when you came home? Yes, she had been cooking. No, she hadn't.", "তুমি বাড়ি এলে সে কি কয়েক ঘণ্টা ধরে রান্না করছিল? হ্যাঁ, সে রান্না করছিল। না, করছিল না।", "হ্যাড শি বিন কুকিং ফর আওয়ার্স হোয়েন ইউ কেইম হোম? ইয়েস, শি হ্যাড বিন কুকিং। নো, শি হ্যাডন্ট।"),
            ("en-p17-l77-006", "I had been living in that apartment for three years before I moved to Dhanmondi.", "ধানমন্ডিতে যাওয়ার আগে আমি তিন বছর ওই অ্যাপার্টমেন্টে থাকছিলাম।", "আই হ্যাড বিন লিভিং ইন দ্যাট অ্যাপার্টমেন্ট ফর থ্রি ইয়ার্স বিফোর আই মুভড টু ধানমন্ডি।"),
            ("en-p17-l77-007", "How long had you been studying before you took the break? I had been studying for three hours.", "বিরতি নেওয়ার আগে আপনি কতক্ষণ ধরে পড়াশোনা করছিলেন? আমি তিন ঘণ্টা ধরে পড়ছিলাম।", "হাউ লং হ্যাড ইউ বিন স্টাডিয়িং বিফোর ইউ টুক দ্য ব্রেক? আই হ্যাড বিন স্টাডিয়িং ফর থ্রি আওয়ার্স।"),
            ("en-p17-l77-008", "His eyes were red because he had been staring at the computer screen all day.", "তার চোখ লাল ছিল কারণ সে সারাদিন কম্পিউটার স্ক্রিনের দিকে তাকিয়ে ছিল।", "হিজ আইজ ওয়্যার রেড বিকজ হি হ্যাড বিন স্টেয়ারিং অ্যাট দ্য কম্পিউটার স্ক্রিন অল ডে।")
        ]
    }
]

# ==============================================================================
# PART 18: Past Passive Voice (Was/Were + V3 & Was/Were being + V3)
# ==============================================================================
p18_lessons = [
    {
        "id": "en-foundations-l78",
        "order": 1,
        "title_bn": "সাধারণ অতীত কর্মবাচ্য — 'Was / Were + V3' (Past Simple Passive)",
        "title_target": "Past Simple Passive (Was / Were + V3)",
        "intro_bn": "অতীতে কর্তা ছাড়া কোনো কাজ কারো দ্বারা সম্পন্ন হয়েছিল বোঝাতে Past Simple Passive বসে। গঠন: Subject + was/were + V3 (Past Participle)।",
        "structure": [
            "Singular Subject + was + V3",
            "Plural Subject + were + V3"
        ],
        "items": [
            ("en-p18-l78-001", "Parents were sent there safely.", "বাবা-মাকে সেখানে নিরাপদে পাঠানো হয়েছিল।", "প্যারেন্টস ওয়্যার সেন্ট দেয়ার সেফলি।"),
            ("en-p18-l78-002", "He was given an honorable award for his outstanding work.", "অসামান্য কাজের জন্য তাকে একটি সম্মানজনক পুরস্কার দেওয়া হয়েছিল।", "হি ওয়াজ গিভেন অ্যান অনারেবল অ্যাওয়ার্ড ফর হিজ আউটস্ট্যান্ডিং ওয়ার্ক।"),
            ("en-p18-l78-003", "The historic bridge was built over fifty years ago.", "ঐতিহাসিক সেতুটি পঞ্চাশ বছরেরও বেশি সময় আগে নির্মিত হয়েছিল।", "দ্য হিস্টোরিক ব্রিজ ওয়াজ বিল্ট ওভার ফিফটি ইয়ার্স এগো।"),
            ("en-p18-l78-004", "The official email was sent to all team members yesterday.", "গতকাল সকল দলের সদস্যকে অফিশিয়াল ইমেইল পাঠানো হয়েছিল।", "দি অফিশিয়াল ইমেইল ওয়াজ সেন্ট টু অল টিম মেম্বার্স ইয়েস্টারডে।"),
            ("en-p18-l78-005", "The stolen laptop was recovered by the local police.", "চুরি যাওয়া ল্যাপটপটি স্থানীয় পুলিশ উদ্ধার করেছিল।", "দ্য স্টোলেন ল্যাপটপ ওয়াজ রিকভার্ড বাই দ্য লোকাল পুলিশ।"),
            ("en-p18-l78-006", "All our questions were answered clearly by the speaker.", "বক্তা আমাদের সকল প্রশ্নের পরিষ্কার উত্তর দিয়েছিলেন।", "অল আওয়ার কোয়েশ্চেনস ওয়্যার অ্যানসার্ড ক্লিয়ারলি বাই দ্য স্পিকার।"),
            ("en-p18-l78-007", "Was the important message delivered on time? Yes, it was delivered on time.", "জরুরি বার্তাটি কি সময়মতো পৌঁছে দেওয়া হয়েছিল? হ্যাঁ, সময়মতো পৌঁছে দেওয়া হয়েছিল।", "ওয়াজ দি ইম্পরট্যান্ট মেসেজ ডেলিভার্ড অন টাইম? ইয়েস, ইট ওয়াজ ডেলিভার্ড অন টাইম।"),
            ("en-p18-l78-008", "Where was this classical song composed? It was composed in Chittagong.", "এই কালজয়ী গানটি কোথায় সুর করা হয়েছিল? এটি চট্টগ্রামে সুর করা হয়েছিল।", "হোয়ার ওয়াজ দিজ ক্লাসিক্যাল সং কম্পোজড? ইট ওয়াজ কম্পোজড ইন চিটাগং।")
        ]
    },
    {
        "id": "en-foundations-l79",
        "order": 2,
        "title_bn": "চলমান অতীত কর্মবাচ্য — 'Was / Were being + V3' (Past Continuous Passive)",
        "title_target": "Past Continuous Passive (Was / Were being + V3)",
        "intro_bn": "অতীতে কোনো কাজ কারো দ্বারা করা হচ্ছিল বোঝাতে Past Continuous Passive বসে। গঠন: Subject + was/were being + V3।",
        "structure": [
            "Singular Subject + was being + V3",
            "Plural Subject + were being + V3"
        ],
        "items": [
            ("en-p18-l79-001", "The damaged car was being repaired at the workshop.", "ওয়ার্কশপে ক্ষতিগ্রস্ত গাড়িটি মেরামত করা হচ্ছিল।", "দ্য ড্যামেজড কার ওয়াজ বিয়িং রিপেয়ার্ড অ্যাট দ্য ওয়ার্কশপ।"),
            ("en-p18-l79-002", "A new highway was being constructed across the district.", "জেলাভিত্তিক একটি নতুন মহাসড়ক নির্মাণ করা হচ্ছিল।", "আ নিউ হাইওয়ে ওয়াজ বিয়িং কনস্ট্রাক্টেড অ্যাক্রস দ্য ডিস্ট্রিক্ট।"),
            ("en-p18-l79-003", "Delicious dinner was being prepared for all the visitors.", "সকল দর্শনার্থীদের জন্য সুস্বাদু রাতের খাবার তৈরি করা হচ্ছিল।", "ডেলিশাস ডিনার ওয়াজ বিয়িং প্রিপেয়ার্ড ফর অল দ্য ভিজিটরস।"),
            ("en-p18-l79-004", "The criminal suspects were being tracked carefully by the cyber police.", "সাইবার পুলিশ সন্দেহভাজন অপরাধীদের অত্যন্ত সতর্কতার সাথে ট্র্যাক করছিল।", "দ্য ক্রিমিনাল সাসপেক্টস ওয়্যার বিয়িং ট্র্যাক্ট কেয়ারফুলি বাই দ্য সাইবার পুলিশ।"),
            ("en-p18-l79-005", "The official documents were being verified by the embassy.", "দূতাবাস কর্তৃক অফিশিয়াল কাগজপত্র যাচাই করা হচ্ছিল।", "দি অফিশিয়াল ডকুমেন্টস ওয়্যার বিয়িং ভেরিফাইড বাই দি অ্যাম্বাসি।"),
            ("en-p18-l79-006", "The old building was being painted white yesterday.", "গতকাল পুরানো ভবনটি সাদা রঙ করা হচ্ছিল।", "দি ওল্ড বিল্ডিং ওয়াজ বিয়িং পেইন্টেড হোয়াইট ইয়েস্টারডে।"),
            ("en-p18-l79-007", "Was the issue being discussed in the board meeting? Yes, it was being discussed actively.", "বোর্ড সভায় কি বিষয়টি নিয়ে আলোচনা করা হচ্ছিল? হ্যাঁ, সক্রিয়ভাবে আলোচনা করা হচ্ছিল।", "ওয়াজ দি ইস্যু বিয়িং ডিসকাসড ইন দ্য বোর্ড মিটিং? ইয়েস, ইট ওয়াজ বিয়িং ডিসকাসড অ্যাক্টিভলি।"),
            ("en-p18-l79-008", "Many trees were being planted along the main road.", "প্রধান সড়কের পাশে অনেক গাছ লাগানো হচ্ছিল।", "মেনি ট্রিজ ওয়্যার বিয়িং প্ল্যান্টেড অ্যালং দ্য মেইন রোড।")
        ]
    }
]

# ==============================================================================
# PART 19: Past Voice Interactive Pair Practice (Voice Q&A)
# ==============================================================================
p19_pairs = [
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

p19_items = []
for idx, (q, yes_a, no_a, q_bn, q_pron) in enumerate(p19_pairs, start=1):
    tokens = [{"t": w, "bn": ""} for w in q.split()]
    item_obj = {
        "id": f"en-p19-pair-{idx:03d}",
        "concept_id": f"c-en-p19-pair-{idx:03d}",
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
    p19_items.append(item_obj)

p19_lesson = {
    "id": "en-foundations-l80",
    "order": 1,
    "title_bn": "অতীত কাল ভয়েস পেয়ার প্র্যাকটিস (Past Voice Q&A Practice)",
    "title_target": "Past Tense Interactive Voice Practice",
    "intro_bn": "মাইক্রোফোনে ট্যাপ করে অতীত প্রশ্ন শুনুন এবং ইংরেজিতে উত্তর দিন। হ্যাঁ-বোধক উত্তর 'Yes' দিয়ে এবং না-বোধক উত্তর 'No' দিয়ে শুরু করুন। আমাদের এআই সিস্টেম আপনার উচ্চারণ ও সঠিক অতীত ফর্ম (V2 / didn't) মূল্যায়ন করবে।",
    "structure": [
        "Question: Did you + V1...? / Were you + V-ing...?",
        "Yes Answer: Yes, I + V2... / Yes, I was + V-ing...",
        "No Answer: No, I didn't + V1... / No, I wasn't + V-ing..."
    ],
    "items": p19_items
}

# ==============================================================================
# Helper function to convert raw lesson defs to full lesson objects
# ==============================================================================
def build_part(part_id, order, level, title_bn, title_target, lessons_raw, tense_tag):
    part_lessons = []
    for l in lessons_raw:
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
                    "sentence_type": tense_tag,
                    "tense": tense_tag
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
        part_lessons.append(lesson_obj)
    return {
        "id": part_id,
        "order": order,
        "level": level,
        "title_bn": title_bn,
        "title_target": title_target,
        "lessons": part_lessons
    }

part13 = build_part("en-foundations-p13", 13, "A2", "সাধারণ অতীত কাল — Past Simple (Was/Were & Did/Didn't)", "Past Simple Tense (Was/Were & Did/Didn't)", p13_lessons, "past_simple")
part14 = build_part("en-foundations-p14", 14, "A2", "অতীত ঘটমান কাল ও বাধাগ্রস্ত কাজ (Past Continuous & When/While)", "Past Continuous & Interrupted Actions", p14_lessons, "past_continuous")
part15 = build_part("en-foundations-p15", 15, "A2", "অতীতের ইচ্ছা, বাধ্যবাধকতা ও অভ্যাস (Used to, Had to, Wanted to, Could)", "Past Modals & Habits (Used to, Had to, Could)", p15_lessons, "past_modals")
part16 = build_part("en-foundations-p16", 16, "B1", "পুরাঘটিত অতীত কাল (Past Perfect Tense: Had + V3)", "Past Perfect Tense (Had + V3 & Before / After)", p16_lessons, "past_perfect")
part17 = build_part("en-foundations-p17", 17, "B1", "পুরাঘটিত ঘটমান অতীত কাল (Past Perfect Continuous Tense)", "Past Perfect Continuous (Had been + Verb-ING)", p17_lessons, "past_perfect_continuous")
part18 = build_part("en-foundations-p18", 18, "B1", "অতীত কালের কর্মবাচ্য (Past Passive Voice: Was/Were + V3)", "Past Passive Voice (Was/Were + V3 & Was/Were being + V3)", p18_lessons, "past_passive")
part19 = {
    "id": "en-foundations-p19",
    "order": 19,
    "level": "A2",
    "title_bn": "অতীত কাল ভয়েস পেয়ার প্র্যাকটিস (Past Voice Q&A Practice)",
    "title_target": "Past Tense Interactive Voice Practice",
    "lessons": [p19_lesson]
}

data['parts'].extend([part13, part14, part15, part16, part17, part18, part19])

# Recalculate stats
total_lessons = sum(len(p['lessons']) for p in data['parts'])
total_items = sum(sum(len(l['items']) for l in p['lessons']) for p in data['parts'])

data['stats'] = {
    "lessons": total_lessons,
    "items": total_items
}

with open(FILE_PATH, 'w', encoding='utf-8') as f:
    json.dump(data, f, indent=2, ensure_ascii=False)

print(f"Successfully added Past Tense! Total parts: {len(data['parts'])}, Total lessons: {total_lessons}, Total items: {total_items}")
