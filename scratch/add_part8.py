import json
import sys

sys.stdout.reconfigure(encoding='utf-8')

FILE_PATH = 'android/app/src/main/assets/spoken_english_foundations.json'

data = json.load(open(FILE_PATH, encoding='utf-8'))

# Remove existing Part 8 if any
data['parts'] = [p for p in data['parts'] if p['id'] != 'en-foundations-p8']

lessons_def = [
    {
        "id": "en-foundations-l44",
        "order": 1,
        "title_bn": "ইচ্ছা প্রকাশ — 'Want to' ও 'Would like to' (Desires)",
        "title_target": "Expressing Desires (Want to & Would like to)",
        "intro_bn": "নিজের কোনো ইচ্ছা বা পছন্দের কথা প্রকাশ করতে 'want to' অথবা ভদ্রভাবে 'would like to' ব্যবহার করা হয়। গঠন: Subject + want to / wants to + Verb (Base form)।",
        "structure": [
            "I / You / We / They + want to + Verb (V1)",
            "He / She / It + wants to + Verb (V1)",
            "Subject + would like to + Verb (V1)"
        ],
        "items": [
            ("en-p8-l44-001", "I want to speak English fluently with everyone.", "আমি সবার সাথে সাবলীলভাবে ইংরেজি বলতে চাই।", "আই ওয়ান্ট টু স্পিক ইংলিশ ফ্লুয়েন্টলি উইথ এভরিওয়ান।"),
            ("en-p8-l44-002", "I want to learn something useful today.", "আমি আজ দরকারী কিছু শিখতে চাই।", "আই ওয়ান্ট টু লার্ন সামথিং ইউজফুল টুডে।"),
            ("en-p8-l44-003", "He wants to buy a new laptop for work.", "সে কাজের জন্য একটি নতুন ল্যাপটপ কিনতে চায়।", "হি ওয়ান্টস টু বাই আ নিউ ল্যাপটপ ফর ওয়ার্ক।"),
            ("en-p8-l44-004", "She wants to meet our English teacher.", "তিনি আমাদের ইংরেজি শিক্ষকের সাথে দেখা করতে চান।", "শি ওয়ান্টস টু মিট আওয়ার ইংলিশ টিচার।"),
            ("en-p8-l44-005", "I would like to have a cup of hot coffee.", "আমি এক কাপ গরম কফি খেতে চাই।", "আই উড লাইক টু হ্যাভ আ কাপ অব হট কফি।"),
            ("en-p8-l44-006", "We want to visit Cox's Bazar this winter.", "আমরা এই শীতে কক্সবাজার ঘুরতে যেতে চাই।", "উই ওয়ান্ট টু ভিজিট কক্সবাজার দিজ উইন্টার।"),
            ("en-p8-l44-007", "Do you want to join us? Yes, I want to join you. No, I don't want to join.", "আপনি কি আমাদের সাথে যোগ দিতে চান? হ্যাঁ, আমি যোগ দিতে চাই। না, আমি যোগ দিতে চাই না।", "ডু ইউ ওয়ান্ট টু জয়েন আস? ইয়েস, আই ওয়ান্ট টু জয়েন ইউ। নো, আই ডোন্ট ওয়ান্ট টু জয়েন।"),
            ("en-p8-l44-008", "What do you want to eat for dinner? I want to eat fresh vegetables and rice.", "আপনি রাতের খাবারে কী খেতে চান? আমি তাজা শাকসবজি ও ভাত খেতে চাই।", "হোয়াট ডু ইউ ওয়ান্ট টু ইট ফর ডিনার? আই ওয়ান্ট টু ইট ফ্রেশ ভেজিটেবলস অ্যান্ড রাইস।"),
            ("en-p8-l44-009", "They don't want to waste their time.", "তারা তাদের সময় অপচয় করতে চায় না।", "দে ডোন্ট ওয়ান্ট টু ওয়েস্ট দেয়ার টাইম।"),
            ("en-p8-l44-010", "Where do you want to go this evening? I want to go to the open park.", "আপনি আজ সন্ধ্যায় কোথায় যেতে চান? আমি উন্মুক্ত পার্কে যেতে চাই।", "হোয়ার ডু ইউ ওয়ান্ট টু গো দিজ ইভনিং? আই ওয়ান্ট টু গো টু দি ওপেন পার্ক।")
        ]
    },
    {
        "id": "en-foundations-l45",
        "order": 2,
        "title_bn": "প্রয়োজনীয়তা প্রকাশ — 'Need to' (Needs & Essentials)",
        "title_target": "Expressing Needs (Need to & Needs to)",
        "intro_bn": "দৈনন্দিন জীবনে কোনো কিছু করার দরকার বা প্রয়োজনীয়তা বোঝাতে 'need to' ব্যবহার করা হয়। গঠন: Subject + need to / needs to + Verb (Base form)।",
        "structure": [
            "I / You / We / They + need to + Verb (V1)",
            "He / She / Name + needs to + Verb (V1)"
        ],
        "items": [
            ("en-p8-l45-001", "I need to practice spoken English every single day.", "আমার প্রতিদিন স্পোকেন ইংলিশ অনুশীলন করা প্রয়োজন।", "আই নিড টু প্র্যাকটিস স্পোকেন ইংলিশ এভরি সিঙ্গেল ডে।"),
            ("en-p8-l45-002", "I need to wake up early tomorrow morning.", "আগামীকাল সকালে আমার তাড়াতাড়ি ঘুম থেকে ওঠা দরকার।", "আই নিড টু ওয়েক আপ আর্লি টুমরো মর্নিং।"),
            ("en-p8-l45-003", "You need to take good care of your health.", "আপনার নিজের স্বাস্থ্যের ভালো যত্ন নেওয়া প্রয়োজন।", "ইউ নিড টু টেক গুড কেয়ার অব ইয়োর হেলথ।"),
            ("en-p8-l45-004", "He needs to submit his report by two o'clock.", "তার দুপুর দুইটার মধ্যে রিপোর্ট জমা দেওয়া দরকার।", "হি নিডস টু সাবমিট হিজ রিপোর্ট বাই টু ও'ক্লক।"),
            ("en-p8-l45-005", "She needs to buy some medicine from the pharmacy.", "ফার্মেসি থেকে তার কিছু ওষুধ কেনা দরকার।", "শি নিডস টু বাই সাম মেডিসিন ফ্রম দ্য ফার্মেসি।"),
            ("en-p8-l45-006", "We need to finish this project on time.", "আমাদের সময়মতো এই প্রজেক্টটি শেষ করা দরকার।", "উই নিড টু ফিনিশ দিজ প্রজেক্ট অন টাইম।"),
            ("en-p8-l45-007", "Do you need any help from me? Yes, I need your help. No, I don't need any help.", "আপনার কি আমার কোনো সাহায্য দরকার? হ্যাঁ, আমার আপনার সাহায্য প্রয়োজন। না, আমার কোনো সাহায্যের দরকার নেই।", "ডু ইউ নিড অ্যানি হেল্প ফ্রম মি? ইয়েস, আই নিড ইয়োর হেল্প। নো, আই ডোন্ট নিড অ্যানি হেল্প।"),
            ("en-p8-l45-008", "What do you need right now? I need a glass of cold water.", "আপনার এই মুহূর্তে কী প্রয়োজন? আমার এক গ্লাস ঠান্ডা পানি প্রয়োজন।", "হোয়াট ডু ইউ নিড রাইট নাও? আই নিড আ গ্লাস অব কোল্ড ওয়াটার।")
        ]
    },
    {
        "id": "en-foundations-l46",
        "order": 3,
        "title_bn": "নিয়ম ও বাধ্যবাধকতা — 'Have to' ও 'Has to' (Obligations)",
        "title_target": "Daily Obligations (Have to & Has to)",
        "intro_bn": "বাধ্যবাধকতা বা কোনো কাজ অবশ্যই করতে হবে এমন বোঝাতে 'have to' ও 'has to' ব্যবহৃত হয়। যেমন: I have to go (আমাকে যেতে হবে), He has to do it (তাকে এটি করতে হবে)।",
        "structure": [
            "I / You / We / They + have to + Verb (V1)",
            "He / She / Name + has to + Verb (V1)"
        ],
        "items": [
            ("en-p8-l46-001", "I have to leave for office right now.", "আমাকে এখনই অফিসের উদ্দেশ্যে বের হতে হবে।", "আই হ্যাভ টু লিভ ফর অফিস রাইট নাও।"),
            ("en-p8-l46-002", "I have to wake up at five in the morning.", "আমাকে সকাল পাঁচটায় ঘুম থেকে উঠতে হয়।", "আই হ্যাভ টু ওয়েক আপ অ্যাট ফাইভ ইন দ্য মর্নিং।"),
            ("en-p8-l46-003", "He has to attend an urgent meeting with clients.", "তাকে ক্লায়েন্টদের সাথে একটি জরুরি মিটিংয়ে অংশ নিতে হবে।", "হি হ্যাজ টু অ্যাটেন্ড অ্যান আর্জেন্ট মিটিং উইথ ক্লায়েন্টস।"),
            ("en-p8-l46-004", "She has to complete her homework before evening.", "তাকে সন্ধ্যার আগেই তার বাড়ির কাজ শেষ করতে হবে।", "শি হ্যাজ টু কমপ্লিট হার হোমওয়ার্ক বিফোর ইভনিং।"),
            ("en-p8-l46-005", "We have to follow the traffic safety rules.", "আমাদের ট্রাফিক নিরাপত্তা নিয়ম মেনে চলতে হবে।", "উই হ্যাভ টু ফলো দ্য ট্রাফিক সেফটি রুলস।"),
            ("en-p8-l46-006", "They have to pay their utility bills today.", "তাদের আজ ইউটিলিটি বিল পরিশোধ করতে হবে।", "দে হ্যাভ টু পে দেয়ার ইউটিলিটি বিলস টুডে।"),
            ("en-p8-l46-007", "Do you have to work tomorrow? Yes, I have to work tomorrow. No, I don't have to work tomorrow.", "কাল কি আপনাকে কাজ করতে হবে? হ্যাঁ, কাল আমাকে কাজ করতে হবে। না, কাল আমাকে কাজ করতে হবে না।", "ডু ইউ হ্যাভ টু ওয়ার্ক টুমরো? ইয়েস, আই হ্যাভ টু ওয়ার্ক টুমরো। নো, আই ডোন্ট হ্যাভ টু ওয়ার্ক টুমরো।"),
            ("en-p8-l46-008", "What time do you have to reach there? I have to reach there by nine o'clock.", "আপনাকে কয়টার মধ্যে সেখানে পৌঁছাতে হবে? আমাকে নয়টার মধ্যে সেখানে পৌঁছাতে হবে।", "হোয়াট টাইম ডু ইউ হ্যাভ টু রিচ দেয়ার? আই হ্যাভ টু রিচ দেয়ার বাই নাইন ও'ক্লক।")
        ]
    },
    {
        "id": "en-foundations-l47",
        "order": 4,
        "title_bn": "সামর্থ্য ও বিনম্র অনুরোধ — 'Can' ও 'Can I have...?' (Requests)",
        "title_target": "Ability & Polite Requests (Can & May)",
        "intro_bn": "ESCB স্পোকেন রুল ০৫: কারো কাছে ভদ্রভাবে কিছু চাইতে 'Can I have...?' বা 'May I have...?' ব্যবহার করা হয়। সামর্থ্য প্রকাশে 'can' বসে।",
        "structure": [
            "Can I have + Object, please?",
            "Subject + can / cannot + Verb (V1)"
        ],
        "items": [
            ("en-p8-l47-001", "Can I have your contact number, please?", "আমি কি আপনার যোগাযোগের নম্বরটি পেতে পারি?", "ক্যান আই হ্যাভ ইয়োর কন্টাক্ট নম্বর, প্লিজ?"),
            ("en-p8-l47-002", "Can I have a cup of warm tea, please?", "আমি কি এক কাপ গরম চা পেতে পারি?", "ক্যান আই হ্যাভ আ কাপ অব ওয়ার্ম টি, প্লিজ?"),
            ("en-p8-l47-003", "Can I have your attention for a moment, please?", "আমি কি এক মুহূর্তের জন্য আপনাদের দৃষ্টি আকর্ষণ করতে পারি?", "ক্যান আই হ্যাভ ইয়োর অ্যাটেনশন ফর আ মোমেন্ট, প্লিজ?"),
            ("en-p8-l47-004", "Can you help me with this English sentence? Yes, I can help you. No, I cannot help you.", "আপনি কি এই ইংরেজি বাক্যটিতে আমাকে সাহায্য করতে পারেন? হ্যাঁ, আমি সাহায্য করতে পারি। না, আমি সাহায্য করতে পারি না।", "ক্যান ইউ হেল্প মি উইথ দিজ ইংলিশ সেন্টেন্স? ইয়েস, আই ক্যান হেল্প ইউ। নো, আই ক্যানট হেল্প ইউ।"),
            ("en-p8-l47-005", "I can speak English with high confidence.", "আমি পূর্ণ আত্মবিশ্বাসের সাথে ইংরেজি বলতে পারি।", "আই ক্যান স্পিক ইংলিশ উইথ হাই কনফিডেন্স।"),
            ("en-p8-l47-006", "Can you ride a motorcycle? Yes, I can ride a motorcycle. No, I cannot ride a motorcycle.", "আপনি কি মোটরসাইকেল চালাতে পারেন? হ্যাঁ, আমি মোটরসাইকেল চালাতে পারি। না, আমি চালাতে পারি না।", "ক্যান ইউ রাইড আ মোটরসাইকেল? ইয়েস, আই ক্যান রাইড আ মোটরসাইকেল। নো, আই ক্যানট রাইড আ মোটরসাইকেল।"),
            ("en-p8-l47-007", "You can use my computer whenever you need.", "আপনার যখনই প্রয়োজন আপনি আমার কম্পিউটার ব্যবহার করতে পারেন।", "ইউ ক্যান ইউজ মাই কম্পিউটার হোয়েনেভার ইউ নিড।"),
            ("en-p8-l47-008", "May I ask you a simple question? Yes, you may ask.", "আমি কি আপনাকে একটি সহজ প্রশ্ন করতে পারি? হ্যাঁ, আপনি করতে পারেন।", "মে আই আস্ক ইউ আ সিম্পল কোশ্চেন? ইয়েস, ইউ মে আস্ক।")
        ]
    }
]

part8_lessons = []
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
                "sentence_type": "present_modals",
                "tense": "present"
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
    part8_lessons.append(lesson_obj)

part8 = {
    "id": "en-foundations-p8",
    "order": 8,
    "level": "A1",
    "title_bn": "দৈনন্দিন ইচ্ছা, বাধ্যবাধকতা ও মোডাল (Want to, Need to, Have to, Can)",
    "title_target": "Daily Desires & Obligations (Want to, Need to, Have to, Can)",
    "lessons": part8_lessons
}

data['parts'].append(part8)

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

print("Successfully updated spoken_english_foundations.json with Part 8!")
