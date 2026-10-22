import json
import sys

sys.stdout.reconfigure(encoding='utf-8')

FILE_PATH = 'android/app/src/main/assets/spoken_english_foundations.json'
data = json.load(open(FILE_PATH, encoding='utf-8'))

# Keep parts 1 through 9
existing_parts = {p['id']: p for p in data['parts']}

base_parts = [p for p in data['parts'] if p['id'] in [f'en-foundations-p{i}' for i in range(1, 10)]]

# -------------------------------------------------------------
# PART 10: Present Perfect Continuous Tense (have/has + been + V-ing)
# -------------------------------------------------------------
p10_lessons_def = [
    {
        "id": "en-foundations-l52",
        "order": 1,
        "title_bn": "নির্দিষ্ট সময় ধরে চলা কাজ — 'For' এর ব্যবহার (Duration with For)",
        "title_target": "Duration with 'For' (Have / Has been + Verb-ING)",
        "intro_bn": "কোনো কাজ পূর্বে শুরু হয়ে নির্দিষ্ট সময় বা ঘণ্টা ধরে এখনও চলছে বোঝাতে 'have/has + been + Verb-ING' এবং সময়ের ব্যাপ্তির পূর্বে 'for' বসে। যেমন: for 2 hours, for 3 days।",
        "structure": [
            "I / You / We / They + have been + Verb-ING + for (2 hours / 3 days)",
            "He / She / It / Name + has been + Verb-ING + for (2 hours / 3 days)"
        ],
        "items": [
            ("en-p10-l52-001", "I have been waiting here for two hours.", "আমি এখানে দুই ঘণ্টা ধরে অপেক্ষা করছি।", "আই হ্যাভ বিন ওয়েটিং হেয়ার ফর টু আওয়ার্স।"),
            ("en-p10-l52-002", "He has been working at this software company for three years.", "সে তিন বছর ধরে এই সফটওয়্যার কোম্পানিতে কাজ করছে।", "হি হ্যাজ বিন ওয়ার্কিং অ্যাট দিজ সফটওয়্যার কোম্পানি ফর থ্রি ইয়ার্স।"),
            ("en-p10-l52-003", "She has been studying English for six months.", "তিনি ছয় মাস ধরে ইংরেজি শিখছেন।", "শি হ্যাজ বিন স্টাডিয়িং ইংলিশ ফর সিক্স মান্থস।"),
            ("en-p10-l52-004", "They have been playing football for an hour in the field.", "তারা মাঠে এক ঘণ্টা ধরে ফুটবল খেলছে।", "দে হ্যাভ বিন প্লেয়িং ফুটবল ফর অ্যান আওয়ার ইন দ্য ফিল্ড।"),
            ("en-p10-l52-005", "It has been raining continuously for four hours.", "চার ঘণ্টা ধরে একটানা বৃষ্টি হচ্ছে।", "ইট হ্যাজ বিন রেইনিং কন্টিনিউয়াসলি ফর ফোর আওয়ার্স।"),
            ("en-p10-l52-006", "We have been living in this neighborhood for five years.", "আমরা পাঁচ বছর ধরে এই এলাকায় বসবাস করছি।", "উই হ্যাভ বিন লিভিং ইন দিজ নেইবারহুড ফর ফাইভ ইয়ার্স।"),
            ("en-p10-l52-007", "He hasn't been feeling well for the past two days.", "বিগত দুই দিন ধরে তার শরীর ভালো লাগছে না।", "হি হ্যাজন্ট বিন ফিলিং ওয়েল ফর দ্য পাস্ট টু ডেইজ।"),
            ("en-p10-l52-008", "I have been reading this informative book for two hours.", "আমি দুই ঘণ্টা ধরে এই তথ্যবহুল বইটি পড়ছি।", "আই হ্যাভ বিন রিডিং দিজ ইনফরম্যাটিভ বুক ফর টু আওয়ার্স।")
        ]
    },
    {
        "id": "en-foundations-l53",
        "order": 2,
        "title_bn": "শুরুর বিন্দু থেকে চলা কাজ — 'Since' এর ব্যবহার (Starting Point with Since)",
        "title_target": "Starting Point with 'Since' (Have / Has been + Verb-ING)",
        "intro_bn": "অতীতের কোনো নির্দিষ্ট দিন, সাল বা সময় থেকে কাজ শুরু হয়ে এখনও চলছে বোঝাতে 'since' বসে। যেমন: since morning, since Monday, since 2021।",
        "structure": [
            "Subject + have / has + been + Verb-ING + since (morning / yesterday / 2020)",
            "Negative: haven't / hasn't + been + Verb-ING + since..."
        ],
        "items": [
            ("en-p10-l53-001", "It has been raining heavily since early morning.", "সকাল থেকেই মুষলধারে বৃষ্টি হচ্ছে।", "ইট হ্যাজ বিন রেইনিং হেভিলি সিন্স আর্লি মর্নিং।"),
            ("en-p10-l53-002", "She has been cooking in the kitchen since noon.", "সে দুপুর থেকেই রান্নাঘরে রান্না করছে।", "শি হ্যাজ বিন কুকিং ইন দ্য কিচেন সিন্স নুন।"),
            ("en-p10-l53-003", "I have been preparing for this exam since last month.", "আমি গত মাস থেকে এই পরীক্ষার প্রস্তুতি নিচ্ছি।", "আই হ্যাভ বিন প্রিপেয়ারিং ফর দিজ এক্সাম সিন্স লাস্ট মান্থ।"),
            ("en-p10-l53-004", "They have been living here since 2018.", "তারা ২০১৮ সাল থেকে এখানে বসবাস করছে।", "দে হ্যাভ বিন লিভিং হেয়ার সিন্স টুয়েন্টি এইটিন।"),
            ("en-p10-l53-005", "He has been practicing spoken English since yesterday.", "তিনি গতকাল থেকে স্পোকেন ইংলিশ অনুশীলন করছেন।", "হি হ্যাজ বিন প্র্যাকটিসড স্পোকেন ইংলিশ সিন্স ইয়েস্টারডে।"),
            ("en-p10-l53-006", "We have been planning this family trip since January.", "আমরা জানুয়ারি মাস থেকে এই পারিবারিক ভ্রমণের পরিকল্পনা করছি।", "উই হ্যাভ বিন প্ল্যানিং দিজ ফ্যামিলি ট্রিপ সিন্স জানুয়ারি।"),
            ("en-p10-l53-007", "She hasn't been taking her medicine properly since Friday.", "শুক্রবার থেকে সে নিয়মিত ওষুধ খাচ্ছে না।", "শি হ্যাজন্ট বিন টেকিং হার মেডিসিন প্রপারলি সিন্স ফ্রাইডে।"),
            ("en-p10-l53-008", "The baby has been sleeping peacefully since nine o'clock.", "শিশুটির নয়টা থেকে শান্তভাবে ঘুমাচ্ছে।", "দ্য বেবি হ্যাজ বিন স্লিপিং পিসফুলি সিন্স নাইন ও'ক্লক।")
        ]
    },
    {
        "id": "en-foundations-l54",
        "order": 3,
        "title_bn": "সময়কাল জিজ্ঞাসা — 'How long have you been...?' (Duration Questions)",
        "title_target": "Duration Questions (How long have you been + Verb-ING...?)",
        "intro_bn": "কেউ কতক্ষণ বা কতদিন ধরে কোনো কাজ করছে তা জানতে 'How long have you been + Verb-ING...?' দিয়ে প্রশ্ন করা হয়।",
        "structure": [
            "How long + have / has + Subject + been + Verb-ING...?",
            "Answer: Subject + have/has been + Verb-ING + for/since..."
        ],
        "items": [
            ("en-p10-l54-001", "How long have you been waiting here? I have been waiting for thirty minutes.", "আপনি কতক্ষণ ধরে এখানে অপেক্ষা করছেন? আমি ত্রিশ মিনিট ধরে অপেক্ষা করছি।", "হাউ লং হ্যাভ ইউ বিন ওয়েটিং হেয়ার? আই হ্যাভ বিন ওয়েটিং ফর থার্টি মিনিট্স।"),
            ("en-p10-l54-002", "How long has he been working on this project? He has been working on it for two weeks.", "তিনি কতদিন ধরে এই প্রজেক্টে কাজ করছেন? তিনি দুই সপ্তাহ ধরে এতে কাজ করছেন।", "হাউ লং হ্যাজ হি বিন ওয়ার্কিং অন দিজ প্রজেক্ট? হি হ্যাজ বিন ওয়ার্কিং অন ইট ফর টু উইকস।"),
            ("en-p10-l54-003", "How long have you been learning English? I have been learning English for three months.", "আপনি কতদিন ধরে ইংরেজি শিখছেন? আমি তিন মাস ধরে ইংরেজি শিখছি।", "হাউ লং হ্যাভ ইউ বিন লার্নিং ইংলিশ? আই হ্যাভ বিন লার্নিং ইংলিশ ফর থ্রি মান্থস।"),
            ("en-p10-l54-004", "How long has it been raining? It has been raining since early morning.", "কতক্ষণ ধরে বৃষ্টি হচ্ছে? সকাল থেকে বৃষ্টি হচ্ছে।", "হাউ লং হ্যাজ ইট বিন রেইনিং? ইট হ্যাজ বিন রেইনিং সিন্স আর্লি মর্নিং।"),
            ("en-p10-l54-005", "Has he been waiting here for two hours? Yes, he has been waiting for two hours. No, he hasn't been waiting that long.", "সে কি এখানে দুই ঘণ্টা ধরে অপেক্ষা করছে? হ্যাঁ, সে দুই ঘণ্টা ধরে অপেক্ষা করছে। না, সে এতক্ষণ ধরে অপেক্ষা করছে না।", "হ্যাজ হি বিন ওয়েটিং হেয়ার ফর টু আওয়ার্স? ইয়েস, হি হ্যাজ বিন ওয়েটিং ফর টু আওয়ার্স। নো, হি হ্যাজন্ট বিন ওয়েটিং দ্যাট লং।"),
            ("en-p10-l54-006", "Have you been practicing regularly? Yes, I have been practicing every single day.", "আপনি কি নিয়মিত অনুশীলন করছেন? হ্যাঁ, আমি প্রতিদিন অনুশীলন করছি।", "হ্যাভ ইউ বিন প্র্যাকটিসিং রেগুলারলি? ইয়েস, আই হ্যাভ বিন প্র্যাকটিসিং এভরি সিঙ্গেল ডে।"),
            ("en-p10-l54-007", "How long have they been discussing this issue? They have been discussing it for one hour.", "তারা কতক্ষণ ধরে এই বিষয়টি আলোচনা করছেন? তারা এক ঘণ্টা ধরে আলোচনা করছেন।", "হাউ লং হ্যাভ দে বিন ডিসকাসিং দিজ ইস্যু? দে হ্যাভ বিন ডিসকাসিং ইট ফর ওয়ান আওয়ার।"),
            ("en-p10-l54-008", "What have you been doing since morning? I have been completing my office assignments.", "সকাল থেকে আপনি কী করছেন? আমি আমার অফিসের দায়িত্বসমূহ সম্পন্ন করছি।", "হোয়াট হ্যাভ ইউ বিন ডুইং সিন্স মর্নিং? আই হ্যাভ বিন কমপ্লিটিং মাই অফিস অ্যাসাইনমেন্টস।")
        ]
    },
    {
        "id": "en-foundations-l55",
        "order": 4,
        "title_bn": "পার্থক্য নিরূপণ — Continuous বনাম Perfect Continuous (Comparison)",
        "title_target": "Present Continuous vs Present Perfect Continuous",
        "intro_bn": "শুধুমাত্র বর্তমানে কাজ চলছে বোঝালে Present Continuous (am/is/are + ING) বসে। কিন্তু কাজটি কতক্ষণ বা কখন থেকে চলছে (সময়কাল) উল্লেখ থাকলে অবশ্যই Present Perfect Continuous (have/has been + ING) বসবে।",
        "structure": [
            "Now only: I am waiting (এখন আমি অপেক্ষা করছি)",
            "With time: I have been waiting for 20 minutes (২০ মিনিট ধরে অপেক্ষা করছি)"
        ],
        "items": [
            ("en-p10-l55-001", "She is cooking right now. She has been cooking for two hours.", "সে এখন রান্না করছে। সে দুই ঘণ্টা ধরে রান্না করছে।", "শি ইজ কুকিং রাইট নাও। শি হ্যাজ বিন কুকিং ফর টু আওয়ার্স।"),
            ("en-p10-l55-002", "It is raining now. It has been raining since early morning.", "এখন বৃষ্টি হচ্ছে। সকাল থেকে বৃষ্টি হচ্ছে।", "ইট ইজ রেইনিং নাও। ইট হ্যাজ বিন রেইনিং সিন্স আর্লি মর্নিং।"),
            ("en-p10-l55-003", "I am studying now. I have been studying English for six months.", "আমি এখন পড়াশোনা করছি। আমি ছয় মাস ধরে ইংরেজি শিখছি।", "আই অ্যাম স্টাডিয়িং নাও। আই হ্যাভ বিন স্টাডিয়িং ইংলিশ ফর সিক্স মান্থস।"),
            ("en-p10-l55-004", "They are playing cricket. They have been playing for over an hour.", "তারা ক্রিকেট খেলছে। তারা এক ঘণ্টারও বেশি সময় ধরে খেলছে।", "দে আর প্লেয়িং ক্রিকেট। দে হ্যাভ বিন প্লেয়িং ফর ওভার অ্যান আওয়ার।"),
            ("en-p10-l55-005", "He is working today. He has been working at this company since 2021.", "তিনি আজ কাজ করছেন। তিনি ২০২১ সাল থেকে এই কোম্পানিতে কাজ করছেন।", "হি ইজ ওয়ার্কিং টুডে। হি হ্যাজ বিন ওয়ার্কিং অ্যাট দিজ কোম্পানি সিন্স টুয়েন্টি-টুয়েন্টি-ওয়ান।"),
            ("en-p10-l55-006", "We are discussing the matter. We have been discussing it since morning.", "আমরা বিষয়টি নিয়ে আলোচনা করছি। আমরা সকাল থেকে এটি নিয়ে আলোচনা করছি।", "উই আর ডিসকাসিং দ্য ম্যাটার। উই হ্যাভ বিন ডিসকাসিং ইট সিন্স মর্নিং।"),
            ("en-p10-l55-007", "Why are your eyes red? Because I have been working on the screen for five hours.", "আপনার চোখ লাল কেন? কারণ আমি পাঁচ ঘণ্টা ধরে স্ক্রিনে কাজ করছি।", "হোয়াই আর ইয়োর আইজ রেড? বিকজ আই হ্যাভ বিন ওয়ার্কিং অন দ্য স্ক্রিন ফর ফাইভ আওয়ার্স।"),
            ("en-p10-l55-008", "Are you tired? Yes, I have been cleaning the whole house all afternoon.", "আপনি কি ক্লান্ত? হ্যাঁ, আমি পুরো বিকেল ধরে পুরো বাড়ি পরিষ্কার করছি।", "আর ইউ টায়ার্ড? ইয়েস, আই হ্যাভ বিন ক্লিনিং দ্য হোল হাউজ অল আফটারনুন।")
        ]
    }
]

part10_lessons = []
for l in p10_lessons_def:
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
                "sentence_type": "present_perfect_continuous",
                "tense": "present_perfect_continuous"
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
    part10_lessons.append(lesson_obj)

part10 = {
    "id": "en-foundations-p10",
    "order": 10,
    "level": "A2",
    "title_bn": "পুরাঘটিত ঘটমান বর্তমান কাল (Present Perfect Continuous Tense)",
    "title_target": "Present Perfect Continuous (Have / Has been + Verb-ING)",
    "lessons": part10_lessons
}

# -------------------------------------------------------------
# PART 11: Present Perfect Interactive Pair Practice (Voice Q&A)
# -------------------------------------------------------------
p11_pairs = [
    (
        "Have you finished your homework?",
        "Yes, I have finished my homework.",
        "No, I haven't finished my homework yet.",
        "তুমি কি তোমার বাড়ির কাজ শেষ করেছ?",
        "হ্যাভ ইউ ফিনিশড ইয়োর হোমওয়ার্ক?"
    ),
    (
        "Have you taken your morning medicine?",
        "Yes, I have taken my medicine.",
        "No, I haven't taken my medicine yet.",
        "আপনি কি আপনার সকালের ওষুধ খেয়েছেন?",
        "হ্যাভ ইউ টেকেন ইয়োর মর্নিং মেডিসিন?"
    ),
    (
        "Have you ever been to Cox's Bazar?",
        "Yes, I have been to Cox's Bazar twice.",
        "No, I have never been to Cox's Bazar.",
        "আপনি কি কখনো কক্সবাজার গিয়েছেন?",
        "হ্যাভ ইউ এভার বিন টু কক্সবাজার?"
    ),
    (
        "Have you eaten your lunch yet?",
        "Yes, I have already eaten my lunch.",
        "No, I haven't eaten my lunch yet.",
        "আপনি কি দুপুরের খাবার খেয়েছেন?",
        "হ্যাভ ইউ ইটেন ইয়োর লাঞ্চ ইয়েট?"
    ),
    (
        "Have you seen my car keys?",
        "Yes, I have seen your keys on the table.",
        "No, I haven't seen your keys anywhere.",
        "তুমি কি আমার গাড়ির চাবি দেখেছ?",
        "হ্যাভ ইউ সিন মাই কার কিজ?"
    ),
    (
        "Have you received my official email?",
        "Yes, I have received your email.",
        "No, I haven't received your email yet.",
        "আপনি কি আমার অফিশিয়াল ইমেইল পেয়েছেন?",
        "হ্যাভ ইউ রিসিভড মাই অফিশিয়াল ইমেইল?"
    ),
    (
        "Have you ever eaten Japanese sushi?",
        "Yes, I have eaten Japanese sushi before.",
        "No, I have never tried Japanese sushi.",
        "আপনি কি কখনো জাপানি সুশি খেয়েছেন?",
        "হ্যাভ ইউ এভার ইটেন জাপানিজ সুশি?"
    ),
    (
        "Have you spoken with your team manager today?",
        "Yes, I have spoken with my manager today.",
        "No, I haven't spoken with my manager yet.",
        "আপনি কি আজ আপনার টিম ম্যানেজারের সাথে কথা বলেছেন?",
        "হ্যাভ ইউ স্পোকেন উইথ ইয়োর টিম ম্যানেজার টুডে?"
    ),
    (
        "Have you locked the front door properly?",
        "Yes, I have locked the front door.",
        "No, I haven't locked the front door yet.",
        "তুমি কি সদর দরজাটি ঠিকমতো তালা দিয়েছ?",
        "হ্যাভ ইউ লকড দ্য ফ্রন্ট ডোর প্রপারলি?"
    ),
    (
        "Have you ever travelled abroad by plane?",
        "Yes, I have travelled abroad by plane.",
        "No, I have never travelled abroad by plane.",
        "আপনি কি কখনো বিমানে করে বিদেশ ভ্রমণ করেছেন?",
        "হ্যাভ ইউ এভার ট্রাভেল্ড অ্যাব্রড বাই প্লেন?"
    ),
    (
        "Have you watched the new English movie yet?",
        "Yes, I have already watched the movie.",
        "No, I haven't watched the movie yet.",
        "তুমি কি নতুন ইংরেজি সিনেমাটি দেখেছ?",
        "হ্যাভ ইউ ওয়াচড দ্য নিউ ইংলিশ মুভি ইয়েট?"
    ),
    (
        "Have you cleaned your bedroom today?",
        "Yes, I have cleaned my bedroom today.",
        "No, I haven't cleaned my bedroom yet.",
        "তুমি কি আজ তোমার শোবার ঘর পরিষ্কার করেছ?",
        "হ্যাভ ইউ ক্লিন্ড ইয়োর বেডরুম টুডে?"
    ),
    (
        "Have you practiced your spoken English lesson?",
        "Yes, I have practiced my spoken English lesson.",
        "No, I haven't practiced my lesson yet.",
        "আপনি কি আপনার স্পোকেন ইংলিশ লেসন অনুশীলন করেছেন?",
        "হ্যাভ ইউ প্র্যাকটিসড ইয়োর স্পোকেন ইংলিশ লেসন?"
    ),
    (
        "Have you heard the breaking news?",
        "Yes, I have heard the breaking news.",
        "No, I haven't heard the news yet.",
        "তুমি কি ব্রেকিং নিউজ শুনেছ?",
        "হ্যাভ ইউ হার্ড দ্য ব্রেকিং নিউজ?"
    ),
    (
        "Have you decided where to spend the vacation?",
        "Yes, I have decided where to spend it.",
        "No, I haven't decided where to spend it yet.",
        "ছুটি কোথায় কাটাবেন তা কি সিদ্ধান্ত নিয়েছেন?",
        "হ্যাভ ইউ ডিসাইডেড হোয়ার টু স্পেন্ড দ্য ভ্যাকেশন?"
    ),
    (
        "Have you lived in this city for a long time?",
        "Yes, I have lived here for five years.",
        "No, I have only lived here for a few months.",
        "আপনি কি দীর্ঘদিন ধরে এই শহরে বসবাস করছেন?",
        "হ্যাভ ইউ লিভড ইন দিজ সিটি ফর আ লং টাইম?"
    ),
    (
        "Have you ever met a famous personality?",
        "Yes, I have met a famous personality before.",
        "No, I have never met any famous personality.",
        "আপনি কি কখনো কোনো বিখ্যাত ব্যক্তিত্বের সাথে দেখা করেছেন?",
        "হ্যাভ ইউ এভার মেট আ ফেমাস পারসোনালিটি?"
    ),
    (
        "Have you charged your mobile phone battery?",
        "Yes, I have charged my phone battery.",
        "No, I haven't charged my phone battery yet.",
        "তুমি কি তোমার মোবাইল ফোনের ব্যাটারি চার্জ দিয়েছ?",
        "হ্যাভ ইউ চার্জড ইয়োর মোবাইল ফোন ব্যাটারি?"
    ),
    (
        "Have you been waiting here for a long time?",
        "Yes, I have been waiting for thirty minutes.",
        "No, I haven't been waiting that long.",
        "আপনি কি এখানে অনেকক্ষণ ধরে অপেক্ষা করছেন?",
        "হ্যাভ ইউ বিন ওয়েটিং হেয়ার ফর আ লং টাইম?"
    ),
    (
        "Have you paid the monthly electricity bill?",
        "Yes, I have paid the electricity bill.",
        "No, I haven't paid the electricity bill yet.",
        "আপনি কি মাসিক বিদ্যুৎ বিল পরিশোধ করেছেন?",
        "হ্যাভ ইউ পেইড দ্য মান্থলি ইলেকট্রিসিটি বিল?"
    )
]

p11_items = []
for idx, (q, yes_a, no_a, q_bn, q_pron) in enumerate(p11_pairs, start=1):
    tokens = [{"t": w, "bn": ""} for w in q.split()]
    item_obj = {
        "id": f"en-p11-pair-{idx:03d}",
        "concept_id": f"c-en-p11-pair-{idx:03d}",
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
            "tense": "present_perfect"
        },
        "example": {
            "target": yes_a,
            "bn": no_a
        },
        "status": "reviewed",
        "reviewFlags": ""
    }
    p11_items.append(item_obj)

p11_lesson = {
    "id": "en-foundations-l56",
    "order": 1,
    "title_bn": "প্রেজেন্ট পারফেক্ট ভয়েস পেয়ার প্র্যাকটিস (Voice Q&A Practice)",
    "title_target": "Present Perfect Interactive Voice Practice",
    "intro_bn": "মাইক্রোফোনে ট্যাপ করে প্রশ্ন শুনুন এবং ইংরেজিতে উত্তর দিন। হ্যাঁ-বোধক উত্তর 'Yes' দিয়ে এবং না-বোধক উত্তর 'No' দিয়ে শুরু করুন। আমাদের এআই সিস্টেম আপনার উচ্চারণ ও ব্যাকরণ মূল্যায়ন করবে।",
    "structure": [
        "Question: Have you + V3...?",
        "Yes Answer: Yes, I have + V3...",
        "No Answer: No, I haven't + V3 + yet..."
    ],
    "items": p11_items
}

part11 = {
    "id": "en-foundations-p11",
    "order": 11,
    "level": "A2",
    "title_bn": "প্রেজেন্ট পারফেক্ট ভয়েস পেয়ার প্র্যাকটিস (Voice Q&A Practice)",
    "title_target": "Present Perfect Voice Interactive Pair Practice",
    "lessons": [p11_lesson]
}

# -------------------------------------------------------------
# PART 12: Present Passive Voice (is/are + V3 & is/are being + V3)
# -------------------------------------------------------------
# Retrieve the passive lessons from previous part10 if existed, or define fresh
p12_lessons_def = [
    {
        "id": "en-foundations-l57",
        "order": 1,
        "title_bn": "সাধারণ বর্তমান কর্মবাচ্য — 'is / are + V3' (Present Simple Passive)",
        "title_target": "Present Simple Passive (is / are + V3)",
        "intro_bn": "যখন কর্তা (Subject) নিজে সরাসরি কাজ করে না বরং কর্তার ওপর কাজটি ঘটে, তখন Passive Voice ব্যবহার করা হয়। গঠন: Subject + is / are + V3 (Past Participle form of verb)।",
        "structure": [
            "Singular Subject + is + V3 (Past Participle)",
            "Plural Subject / You + are + V3 (Past Participle)"
        ],
        "items": [
            ("en-p12-l57-001", "English is spoken all over the world.", "সারা বিশ্বে ইংরেজি বলা হয়।", "ইংলিশ ইজ স্পোকেন অল ওভার দ্য ওয়ার্ল্ড।"),
            ("en-p12-l57-002", "Rice is grown in large quantities in Bangladesh.", "বাংলাদেশে প্রচুর পরিমাণে ধান উৎপাদিত হয়।", "রাইস ইজ গ্রোন ইন লার্জ কোয়ান্টিটিস ইন বাংলাদেশ।"),
            ("en-p12-l57-003", "Hot tea is served to all the guests.", "সকল অতিথিকে গরম চা পরিবেশন করা হয়।", "হট টি ইজ সার্ভড টু অল দ্য গেস্টস।"),
            ("en-p12-l57-004", "He is given a handsome monthly salary.", "তাকে ভালো অঙ্কের মাসিক বেতন দেওয়া হয়।", "হি ইজ গিভেন আ হ্যান্ডসাম মান্থলি স্যালারি।"),
            ("en-p12-l57-005", "Official emails are sent every single morning.", "প্রতিদিন সকালে অফিশিয়াল ইমেইল পাঠানো হয়।", "অফিশিয়াল ইমেইলস আর সেন্ট এভরি সিঙ্গেল মর্নিং।"),
            ("en-p12-l57-006", "Original books are sold in this bookstore.", "এই বইয়ের দোকানে আসল বই বিক্রি করা হয়।", "অরিজিনাল বুকস আর সোল্ড ইন দিজ বুকস্টোর।"),
            ("en-p12-l57-007", "Is English spoken here? Yes, English is spoken here. No, English is not spoken here.", "এখানে কি ইংরেজি বলা হয়? হ্যাঁ, এখানে ইংরেজি বলা হয়। না, এখানে ইংরেজি বলা হয় না।", "ইজ ইংলিশ স্পোকেন হেয়ার? ইয়েস, ইংলিশ ইজ স্পোকেন হেয়ার। নো, ইংলিশ ইজ নট স্পোকেন হেয়ার।"),
            ("en-p12-l57-008", "The bright moon is seen clearly in the clear night sky.", "মেঘমুক্ত রাতের আকাশে উজ্জ্বল চাঁদ স্পষ্টভাবে দেখা যায়।", "দ্য ব্রাইট মুন ইজ সিন ক্লিয়ারলি ইন দ্য ক্লিয়ার নাইট স্কাই।")
        ]
    },
    {
        "id": "en-foundations-l58",
        "order": 2,
        "title_bn": "চলমান বর্তমান কর্মবাচ্য — 'is / are being + V3' (Present Continuous Passive)",
        "title_target": "Present Continuous Passive (is / are being + V3)",
        "intro_bn": "বর্তমানে কোনো কাজ কারো দ্বারা করা হচ্ছে বা ঘটছে বোঝাতে Continuous Passive Voice ব্যবহৃত হয়। গঠন: Subject + is being / are being + V3।",
        "structure": [
            "Singular Subject + is being + V3",
            "Plural Subject + are being + V3"
        ],
        "items": [
            ("en-p12-l58-001", "The damaged road is being repaired right now.", "ক্ষতিগ্রস্ত রাস্তাটি এই মুহূর্তে মেরামত করা হচ্ছে।", "দ্য ড্যামেজড রোড ইজ বিয়িং রিপেয়ার্ড রাইট নাও।"),
            ("en-p12-l58-002", "A modern bridge is being built over the river.", "নদীর ওপর একটি আধুনিক সেতু তৈরি করা হচ্ছে।", "আ মডার্ন ব্রিজ ইজ বিয়িং বিল্ট ওভার দ্য রিভার।"),
            ("en-p12-l58-003", "An urgent meeting is being held in the main conference room.", "প্রধান সম্মেলন কক্ষে একটি জরুরি বৈঠক অনুষ্ঠিত হচ্ছে।", "অ্যান আর্জেন্ট মিটিং ইজ বিয়িং হেল্ড ইন দ্য মেইন কনফারেন্স রুম।"),
            ("en-p12-l58-004", "The suspicious activities are being tracked by the cyber security team.", "সন্দেহজনক কার্যক্রম সাইবার নিরাপত্তা দল দ্বারা পর্যবেক্ষণ করা হচ্ছে।", "দ্য সাসপিশাস অ্যাক্টিভিটিস আর বিয়িং ট্র্যাক্ট বাই দ্য সাইবার সিকিউরিটি টিম।"),
            ("en-p12-l58-005", "Delicious dinner is being prepared in the kitchen.", "রান্নাঘরে সুস্বাদু রাতের খাবার তৈরি করা হচ্ছে।", "ডেলিশাস ডিনার ইজ বিয়িং প্রিপেয়ার্ড ইন দ্য কিচেন।"),
            ("en-p12-l58-006", "Our official documents are being verified very carefully.", "আমাদের অফিশিয়াল কাগজপত্র অত্যন্ত সতর্কতার সাথে যাচাই করা হচ্ছে।", "আওয়ার অফিশিয়াল ডকুমেন্টস আর বিয়িং ভেরিফাইড ভেরি কেয়ারফুলি।"),
            ("en-p12-l58-007", "Is the car being washed right now? Yes, it is being washed. No, it is not being washed.", "গাড়িটি কি এখন ধোয়া হচ্ছে? হ্যাঁ, এটি ধোয়া হচ্ছে। না, এটি ধোয়া হচ্ছে না।", "ইজ দ্য কার বিয়িং ওয়াশড রাইট নাও? ইয়েস, ইট ইজ বিয়িং ওয়াশড। নো, ইট ইজ নট বিয়িং ওয়াশড।"),
            ("en-p12-l58-008", "Many new residential buildings are being constructed in this area.", "এই এলাকায় অনেক নতুন আবাসিক ভবন নির্মাণ করা হচ্ছে।", "মেনি নিউ রেসিডেনশিয়াল বিল্ডিংস আর বিয়িং কনস্ট্রাক্টেড ইন দিজ এরিয়া।")
        ]
    },
    {
        "id": "en-foundations-l59",
        "order": 3,
        "title_bn": "দৈনন্দিন প্যাসিভ প্রশ্নোত্তর — 'Is it made / Are you...?' (Passive Q&A Drills)",
        "title_target": "Everyday Passive Questions & Answers",
        "intro_bn": "দৈনন্দিন জীবনে কোনো জিনিস কোথায় তৈরি, সেবা কীভাবে পাওয়া যায় বা নিয়ম কেমন তা জানার জন্য Passive প্রশ্ন ব্যবহৃত হয়।",
        "structure": [
            "Where / How / Is + Subject + V3...?",
            "Are + Plural Subject + V3...?"
        ],
        "items": [
            ("en-p12-l59-001", "Where is this cotton shirt made? It is made in Bangladesh.", "এই সুতি শার্টটি কোথায় তৈরি? এটি বাংলাদেশে তৈরি।", "হোয়ার ইজ দিজ কটন শার্ট মেইড? ইট ইজ মেইড ইন বাংলাদেশ।"),
            ("en-p12-l59-002", "Are credit cards accepted here? Yes, credit cards are accepted here. No, only cash is accepted.", "এখানে কি ক্রেডিট কার্ড গ্রহণ করা হয়? হ্যাঁ, এখানে ক্রেডিট কার্ড নেওয়া হয়। না, শুধু নগদ টাকা নেওয়া হয়।", "আর ক্রেডিট কার্ডস অ্যাকসেপ্টেড হেয়ার? ইয়েস, ক্রেডিট কার্ডস আর অ্যাকসেপ্টেড হেয়ার। নো, অনলি ক্যাশ ইজ অ্যাকসেপ্টেড।"),
            ("en-p12-l59-003", "How is this traditional dish cooked? It is cooked with fresh aromatic spices.", "এই ঐতিহ্যবাহী খাবারটি কীভাবে রান্না করা হয়? এটি তাজা সুগন্ধি মশলা দিয়ে রান্না করা হয়।", "হাউ ইজ দিজ ট্র্যাডিশনাল ডিশ কুক্ট? ইট ইজ কুক্ট উইথ ফ্রেশ অ্যারোম্যাটিক স্পাইসেস।"),
            ("en-p12-l59-004", "Is home delivery included in the price? Yes, free home delivery is included.", "মূল্যের মধ্যে কি হোম ডেলিভারি অন্তর্ভুক্ত? হ্যাঁ, বিনামূল্যে হোম ডেলিভারি অন্তর্ভুক্ত।", "ইজ হোম ডেলিভারি ইনক্লুডেড ইন দ্য প্রাইস? ইয়েস, ফ্রি হোম ডেলিভারি ইনক্লুডেড।"),
            ("en-p12-l59-005", "Are all spoken English classes conducted online? Yes, all classes are conducted live online.", "সকল স্পোকেন ইংলিশ ক্লাস কি অনলাইনে হয়? হ্যাঁ, সব ক্লাস সরাসরি অনলাইনে পরিচালিত হয়।", "আর অল স্পোকেন ইংলিশ ক্লাসেস কনডাক্টেড অনলাইন? ইয়েস, অল ক্লাসেস আর কনডাক্টেড লাইভ অনলাইন।"),
            ("en-p12-l59-006", "When are the daily newspapers delivered? They are delivered early every morning.", "দৈনিক পত্রিকা কখন দেওয়া হয়? প্রতিদিন ভোরে পত্রিকা পৌঁছে দেওয়া হয়।", "হোয়েন আর দ্য ডেইলি নিউজপেপার্স ডেলিভার্ড? দে আর ডেলিভার্ড আর্লি এভরি মর্নিং।"),
            ("en-p12-l59-007", "Who is invited to the award ceremony? All registered members are invited.", "পুরস্কার বিতরণী অনুষ্ঠানে কাকে আমন্ত্রণ জানানো হয়েছে? সকল নিবন্ধিত সদস্যকে আমন্ত্রণ জানানো হয়েছে।", "হু ইজ ইনভাইটেড টু দি অ্যাওয়ার্ড সেরেমনি? অল রেজিস্টার্ড মেম্বার্স আর ইনভাইটেড।"),
            ("en-p12-l59-008", "Is complimentary breakfast provided at this hotel? Yes, breakfast is served from seven am.", "এই হোটেলে কি কমপ্লিমেন্টারি নাস্তা দেওয়া হয়? হ্যাঁ, সকাল সাতটা থেকে নাস্তা পরিবেশন করা হয়।", "ইজ কমপ্লিমেন্টারি ব্রেকফাস্ট প্রোভাইডেড অ্যাট দিজ হোটেল? ইয়েস, ব্রেকফাস্ট ইজ সার্ভড ফ্রম সেভেন এএম।")
        ]
    },
    {
        "id": "en-foundations-l60",
        "order": 4,
        "title_bn": "দাপ্তরিক ও আনুষ্ঠানিক প্যাসিভ বাক্য (Passive in Professional Settings)",
        "title_target": "Passive in Professional & Official Settings",
        "intro_bn": "অফিশিয়াল চিঠি, নোটিশ ও করপোরেট নির্দেশনায় ভদ্রতা ও আনুষ্ঠানিকতা রক্ষায় 'You are requested / required / informed' ইত্যাদি প্যাসিভ বাক্য বহুল ব্যবহৃত হয়।",
        "structure": [
            "Subject + is / are + requested / required / expected to + Verb (V1)",
            "Subject + is / are + strictly prohibited / allowed"
        ],
        "items": [
            ("en-p12-l60-001", "You are cordially invited to attend our annual corporate conference.", "আমাদের বার্ষিক করপোরেট সম্মেলনে অংশ নিতে আপনাকে আন্তরিকভাবে আমন্ত্রণ জানানো হচ্ছে।", "ইউ আর কর্ডিয়ালি ইনভাইটেড টু অ্যাটেন্ড আওয়ার অ্যানুয়াল করপোরেট কনফারেন্স।"),
            ("en-p12-l60-002", "All employees are requested to wear their identity cards at all times.", "সকল কর্মচারীকে সার্বক্ষণিক তাদের পরিচয়পত্র পরিধান করার অনুরোধ করা হচ্ছে।", "অল এমপ্লয়িজ আর রিকোয়েস্টেড টু ওয়্যার দেয়ার আইডেন্টিটি কার্ডস অ্যাট অল টাইমস।"),
            ("en-p12-l60-003", "Mobile phones are not allowed inside the confidential meeting room.", "গোপনীয় সভা কক্ষের ভেতরে মোবাইল ফোন ব্যবহারের অনুমতি নেই।", "মোবাইল ফোনস আর নট অ্যালাউড ইনসাইড দ্য কনফিডেনশিয়াল মিটিং রুম।"),
            ("en-p12-l60-004", "The monthly sales report is submitted on time every month.", "প্রতি মাসে সময়মতো মাসিক বিক্রয় প্রতিবেদন জমা দেওয়া হয়।", "দ্য মান্থলি সেলস রিপোর্ট ইজ সাবমিটেড অন টাইম এভরি মান্থ।"),
            ("en-p12-l60-005", "All passengers are informed that the departure is on schedule.", "সকল যাত্রীকে জানানো যাচ্ছে যে বিমান সঠিক সময়ে ছেড়ে যাবে।", "অল প্যাসেঞ্জার্স আর ইনফর্মড দ্যাট দ্য ডিপার্চার ইজ অন শিডিউল।"),
            ("en-p12-l60-006", "Smoking is strictly prohibited on the entire hospital campus.", "পুরো হাসপাতাল প্রাঙ্গণে ধূমপান সম্পূর্ণ নিষিদ্ধ।", "স্মোকিং ইজ স্ট্রিক্টলি প্রহিবিটেড অন দি এনটায়ার হসপিটাল ক্যাম্পাস।"),
            ("en-p12-l60-007", "You are required to submit a valid photo identification document.", "একটি বৈধ ছবিযুক্ত পরিচয়পত্র জমা দেওয়া আপনার জন্য আবশ্যক।", "ইউ আর রিকোয়ার্ড টু সাবমিট আ ভ্যালিড ফটো আইডেন্টিফিকেশন ডকুমেন্ট।"),
            ("en-p12-l60-008", "The monthly salary is directly deposited into your bank account.", "মাসিক বেতন সরাসরি আপনার ব্যাংক অ্যাকাউন্টে জমা দেওয়া হয়।", "দ্য মান্থলি স্যালারি ইজ ডিরেক্টলি ডিপোজিটেড ইনটু ইয়োর ব্যাংক অ্যাকাউন্ট।")
        ]
    }
]

part12_lessons = []
for l in p12_lessons_def:
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
                "sentence_type": "present_passive",
                "tense": "present_passive"
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
    part12_lessons.append(lesson_obj)

part12 = {
    "id": "en-foundations-p12",
    "order": 12,
    "level": "A2",
    "title_bn": "বর্তমান কালের কর্মবাচ্য (Present Passive Voice — is/are + V3)",
    "title_target": "Present Passive Voice (is/are + V3 & is/are being + V3)",
    "lessons": part12_lessons
}

# Assemble all parts 1 to 12
all_parts = base_parts + [part10, part11, part12]
data['parts'] = all_parts

# Recalculate stats
total_lessons = sum(len(p['lessons']) for p in all_parts)
total_items = sum(sum(len(l['items']) for l in p['lessons']) for p in all_parts)

data['stats'] = {
    "lessons": total_lessons,
    "items": total_items
}

with open(FILE_PATH, 'w', encoding='utf-8') as f:
    json.dump(data, f, indent=2, ensure_ascii=False)

print(f"Successfully updated! Total parts: {len(all_parts)}, Total lessons: {total_lessons}, Total items: {total_items}")
