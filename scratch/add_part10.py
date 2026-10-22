import json
import sys

sys.stdout.reconfigure(encoding='utf-8')

FILE_PATH = 'android/app/src/main/assets/spoken_english_foundations.json'

data = json.load(open(FILE_PATH, encoding='utf-8'))

# Remove existing Part 10 if any
data['parts'] = [p for p in data['parts'] if p['id'] != 'en-foundations-p10']

lessons_def = [
    {
        "id": "en-foundations-l52",
        "order": 1,
        "title_bn": "সাধারণ বর্তমান কর্মবাচ্য — 'is / are + V3' (Present Simple Passive)",
        "title_target": "Present Simple Passive (is / are + V3)",
        "intro_bn": "যখন কর্তা (Subject) নিজে সরাসরি কাজ করে না বরং কর্তার ওপর কাজটি ঘটে, তখন Passive Voice ব্যবহার করা হয়। গঠন: Subject + is / are + V3 (Past Participle form of verb)।",
        "structure": [
            "Singular Subject + is + V3 (Past Participle)",
            "Plural Subject / You + are + V3 (Past Participle)"
        ],
        "items": [
            ("en-p10-l52-001", "English is spoken all over the world.", "সারা বিশ্বে ইংরেজি বলা হয়।", "ইংলিশ ইজ স্পোকেন অল ওভার দ্য ওয়ার্ল্ড।"),
            ("en-p10-l52-002", "Rice is grown in large quantities in Bangladesh.", "বাংলাদেশে প্রচুর পরিমাণে ধান উৎপাদিত হয়।", "রাইস ইজ গ্রোন ইন লার্জ কোয়ান্টিটিস ইন বাংলাদেশ।"),
            ("en-p10-l52-003", "Hot tea is served to all the guests.", "সকল অতিথিকে গরম চা পরিবেশন করা হয়।", "হট টি ইজ সার্ভড টু অল দ্য গেস্টস।"),
            ("en-p10-l52-004", "He is given a handsome monthly salary.", "তাকে ভালো অঙ্কের মাসিক বেতন দেওয়া হয়।", "হি ইজ গিভেন আ হ্যান্ডসাম মান্থলি স্যালারি।"),
            ("en-p10-l52-005", "Official emails are sent every single morning.", "প্রতিদিন সকালে অফিশিয়াল ইমেইল পাঠানো হয়।", "অফিশিয়াল ইমেইলস আর সেন্ট এভরি সিঙ্গেল মর্নিং।"),
            ("en-p10-l52-006", "Original books are sold in this bookstore.", "এই বইয়ের দোকানে আসল বই বিক্রি করা হয়।", "অরিজিনাল বুকস আর সোল্ড ইন দিজ বুকস্টোর।"),
            ("en-p10-l52-007", "Is English spoken here? Yes, English is spoken here. No, English is not spoken here.", "এখানে কি ইংরেজি বলা হয়? হ্যাঁ, এখানে ইংরেজি বলা হয়। না, এখানে ইংরেজি বলা হয় না।", "ইজ ইংলিশ স্পোকেন হেয়ার? ইয়েস, ইংলিশ ইজ স্পোকেন হেয়ার। নো, ইংলিশ ইজ নট স্পোকেন হেয়ার।"),
            ("en-p10-l52-008", "The bright moon is seen clearly in the clear night sky.", "মেঘমুক্ত রাতের আকাশে উজ্জ্বল চাঁদ স্পষ্টভাবে দেখা যায়।", "দ্য ব্রাইট মুন ইজ সিন ক্লিয়ারলি ইন দ্য ক্লিয়ার নাইট স্কাই।")
        ]
    },
    {
        "id": "en-foundations-l53",
        "order": 2,
        "title_bn": "চলমান বর্তমান কর্মবাচ্য — 'is / are being + V3' (Present Continuous Passive)",
        "title_target": "Present Continuous Passive (is / are being + V3)",
        "intro_bn": "বর্তমানে কোনো কাজ কারো দ্বারা করা হচ্ছে বা ঘটছে বোঝাতে Continuous Passive Voice ব্যবহৃত হয়। গঠন: Subject + is being / are being + V3।",
        "structure": [
            "Singular Subject + is being + V3",
            "Plural Subject + are being + V3"
        ],
        "items": [
            ("en-p10-l53-001", "The damaged road is being repaired right now.", "ক্ষতিগ্রস্ত রাস্তাটি এই মুহূর্তে মেরামত করা হচ্ছে।", "দ্য ড্যামেজড রোড ইজ বিয়িং রিপেয়ার্ড রাইট নাও।"),
            ("en-p10-l53-002", "A modern bridge is being built over the river.", "নদীর ওপর একটি আধুনিক সেতু তৈরি করা হচ্ছে।", "আ মডার্ন ব্রিজ ইজ বিয়িং বিল্ট ওভার দ্য রিভার।"),
            ("en-p10-l53-003", "An urgent meeting is being held in the main conference room.", "প্রধান সম্মেলন কক্ষে একটি জরুরি বৈঠক অনুষ্ঠিত হচ্ছে।", "অ্যান আর্জেন্ট মিটিং ইজ বিয়িং হেল্ড ইন দ্য মেইন কনফারেন্স রুম।"),
            ("en-p10-l53-004", "The suspicious activities are being tracked by the cyber security team.", "সন্দেহজনক কার্যক্রম সাইবার নিরাপত্তা দল দ্বারা পর্যবেক্ষণ করা হচ্ছে।", "দ্য সাসপিশাস অ্যাক্টিভিটিস আর বিয়িং ট্র্যাক্ট বাই দ্য সাইবার সিকিউরিটি টিম।"),
            ("en-p10-l53-005", "Delicious dinner is being prepared in the kitchen.", "রান্নাঘরে সুস্বাদু রাতের খাবার তৈরি করা হচ্ছে।", "ডেলিশাস ডিনার ইজ বিয়িং প্রিপেয়ার্ড ইন দ্য কিচেন।"),
            ("en-p10-l53-006", "Our official documents are being verified very carefully.", "আমাদের অফিশিয়াল কাগজপত্র অত্যন্ত সতর্কতার সাথে যাচাই করা হচ্ছে।", "আওয়ার অফিশিয়াল ডকুমেন্টস আর বিয়িং ভেরিফাইড ভেরি কেয়ারফুলি।"),
            ("en-p10-l53-007", "Is the car being washed right now? Yes, it is being washed. No, it is not being washed.", "গাড়িটি কি এখন ধোয়া হচ্ছে? হ্যাঁ, এটি ধোয়া হচ্ছে। না, এটি ধোয়া হচ্ছে না।", "ইজ দ্য কার বিয়িং ওয়াশড রাইট নাও? ইয়েস, ইট ইজ বিয়িং ওয়াশড। নো, ইট ইজ নট বিয়িং ওয়াশড।"),
            ("en-p10-l53-008", "Many new residential buildings are being constructed in this area.", "এই এলাকায় অনেক নতুন আবাসিক ভবন নির্মাণ করা হচ্ছে।", "মেনি নিউ রেসিডেনশিয়াল বিল্ডিংস আর বিয়িং কনস্ট্রাক্টেড ইন দিজ এরিয়া।")
        ]
    },
    {
        "id": "en-foundations-l54",
        "order": 3,
        "title_bn": "দৈনন্দিন প্যাসিভ প্রশ্নোত্তর — 'Is it made / Are you...?' (Passive Q&A Drills)",
        "title_target": "Everyday Passive Questions & Answers",
        "intro_bn": "দৈনন্দিন জীবনে কোনো জিনিস কোথায় তৈরি, সেবা কীভাবে পাওয়া যায় বা নিয়ম কেমন তা জানার জন্য Passive প্রশ্ন ব্যবহৃত হয়।",
        "structure": [
            "Where / How / Is + Subject + V3...?",
            "Are + Plural Subject + V3...?"
        ],
        "items": [
            ("en-p10-l54-001", "Where is this cotton shirt made? It is made in Bangladesh.", "এই সুতি শার্টটি কোথায় তৈরি? এটি বাংলাদেশে তৈরি।", "হোয়ার ইজ দিজ কটন শার্ট মেইড? ইট ইজ মেইড ইন বাংলাদেশ।"),
            ("en-p10-l54-002", "Are credit cards accepted here? Yes, credit cards are accepted here. No, only cash is accepted.", "এখানে কি ক্রেডিট কার্ড গ্রহণ করা হয়? হ্যাঁ, এখানে ক্রেডিট কার্ড নেওয়া হয়। না, শুধু নগদ টাকা নেওয়া হয়।", "আর ক্রেডিট কার্ডস অ্যাকসেপ্টেড হেয়ার? ইয়েস, ক্রেডিট কার্ডস আর অ্যাকসেপ্টেড হেয়ার। নো, অনলি ক্যাশ ইজ অ্যাকসেপ্টেড।"),
            ("en-p10-l54-003", "How is this traditional dish cooked? It is cooked with fresh aromatic spices.", "এই ঐতিহ্যবাহী খাবারটি কীভাবে রান্না করা হয়? এটি তাজা সুগন্ধি মশলা দিয়ে রান্না করা হয়।", "হাউ ইজ দিজ ট্র্যাডিশনাল ডিশ কুক্ট? ইট ইজ কুক্ট উইথ ফ্রেশ অ্যারোম্যাটিক স্পাইসেস।"),
            ("en-p10-l54-004", "Is home delivery included in the price? Yes, free home delivery is included.", "মূল্যের মধ্যে কি হোম ডেলিভারি অন্তর্ভুক্ত? হ্যাঁ, বিনামূল্যে হোম ডেলিভারি অন্তর্ভুক্ত।", "ইজ হোম ডেলিভারি ইনক্লুডেড ইন দ্য প্রাইস? ইয়েস, ফ্রি হোম ডেলিভারি ইনক্লুডেড।"),
            ("en-p10-l54-005", "Are all spoken English classes conducted online? Yes, all classes are conducted live online.", "সকল স্পোকেন ইংলিশ ক্লাস কি অনলাইনে হয়? হ্যাঁ, সব ক্লাস সরাসরি অনলাইনে পরিচালিত হয়।", "আর অল স্পোকেন ইংলিশ ক্লাসেস কনডাক্টেড অনলাইন? ইয়েস, অল ক্লাসেস আর কনডাক্টেড লাইভ অনলাইন।"),
            ("en-p10-l54-006", "When are the daily newspapers delivered? They are delivered early every morning.", "দৈনিক পত্রিকা কখন দেওয়া হয়? প্রতিদিন ভোরে পত্রিকা পৌঁছে দেওয়া হয়।", "হোয়েন আর দ্য ডেইলি নিউজপেপার্স ডেলিভার্ড? দে আর ডেলিভার্ড আর্লি এভরি মর্নিং।"),
            ("en-p10-l54-007", "Who is invited to the award ceremony? All registered members are invited.", "পুরস্কার বিতরণী অনুষ্ঠানে কাকে আমন্ত্রণ জানানো হয়েছে? সকল নিবন্ধিত সদস্যকে আমন্ত্রণ জানানো হয়েছে।", "হু ইজ ইনভাইটেড টু দি অ্যাওয়ার্ড সেরেমনি? অল রেজিস্টার্ড মেম্বার্স আর ইনভাইটেড।"),
            ("en-p10-l54-008", "Is complimentary breakfast provided at this hotel? Yes, breakfast is served from seven am.", "এই হোটেলে কি কমপ্লিমেন্টারি নাস্তা দেওয়া হয়? হ্যাঁ, সকাল সাতটা থেকে নাস্তা পরিবেশন করা হয়।", "ইজ কমপ্লিমেন্টারি ব্রেকফাস্ট প্রোভাইডেড অ্যাট দিজ হোটেল? ইয়েস, ব্রেকফাস্ট ইজ সার্ভড ফ্রম সেভেন এএম।")
        ]
    },
    {
        "id": "en-foundations-l55",
        "order": 4,
        "title_bn": "দাপ্তরিক ও আনুষ্ঠানিক প্যাসিভ বাক্য (Passive in Professional Settings)",
        "title_target": "Passive in Professional & Official Settings",
        "intro_bn": "অফিশিয়াল চিঠি, নোটিশ ও করপোরেট নির্দেশনায় ভদ্রতা ও আনুষ্ঠানিকতা রক্ষায় 'You are requested / required / informed' ইত্যাদি প্যাসিভ বাক্য বহুল ব্যবহৃত হয়।",
        "structure": [
            "Subject + is / are + requested / required / expected to + Verb (V1)",
            "Subject + is / are + strictly prohibited / allowed"
        ],
        "items": [
            ("en-p10-l55-001", "You are cordially invited to attend our annual corporate conference.", "আমাদের বার্ষিক করপোরেট সম্মেলনে অংশ নিতে আপনাকে আন্তরিকভাবে আমন্ত্রণ জানানো হচ্ছে।", "ইউ আর কর্ডিয়ালি ইনভাইটেড টু অ্যাটেন্ড আওয়ার অ্যানুয়াল করপোরেট কনফারেন্স।"),
            ("en-p10-l55-002", "All employees are requested to wear their identity cards at all times.", "সকল কর্মচারীকে সার্বক্ষণিক তাদের পরিচয়পত্র পরিধান করার অনুরোধ করা হচ্ছে।", "অল এমপ্লয়িজ আর রিকোয়েস্টেড টু ওয়্যার দেয়ার আইডেন্টিটি কার্ডস অ্যাট অল টাইমস।"),
            ("en-p10-l55-003", "Mobile phones are not allowed inside the confidential meeting room.", "গোপনীয় সভা কক্ষের ভেতরে মোবাইল ফোন ব্যবহারের অনুমতি নেই।", "মোবাইল ফোনস আর নট অ্যালাউড ইনসাইড দ্য কনফিডেনশিয়াল মিটিং রুম।"),
            ("en-p10-l55-004", "The monthly sales report is submitted on time every month.", "প্রতি মাসে সময়মতো মাসিক বিক্রয় প্রতিবেদন জমা দেওয়া হয়।", "দ্য মান্থলি সেলস রিপোর্ট ইজ সাবমিটেড অন টাইম এভরি মান্থ।"),
            ("en-p10-l55-005", "All passengers are informed that the departure is on schedule.", "সকল যাত্রীকে জানানো যাচ্ছে যে বিমান সঠিক সময়ে ছেড়ে যাবে।", "অল প্যাসেঞ্জার্স আর ইনফর্মড দ্যাট দ্য ডিপার্চার ইজ অন শিডিউল।"),
            ("en-p10-l55-006", "Smoking is strictly prohibited on the entire hospital campus.", "পুরো হাসপাতাল প্রাঙ্গণে ধূমপান সম্পূর্ণ নিষিদ্ধ।", "স্মোকিং ইজ স্ট্রিক্টলি প্রহিবিটেড অন দি এনটায়ার হসপিটাল ক্যাম্পাস।"),
            ("en-p10-l55-007", "You are required to submit a valid photo identification document.", "একটি বৈধ ছবিযুক্ত পরিচয়পত্র জমা দেওয়া আপনার জন্য আবশ্যক।", "ইউ আর রিকোয়ার্ড টু সাবমিট আ ভ্যালিড ফটো আইডেন্টিফিকেশন ডকুমেন্ট।"),
            ("en-p10-l55-008", "The monthly salary is directly deposited into your bank account.", "মাসিক বেতন সরাসরি আপনার ব্যাংক অ্যাকাউন্টে জমা দেওয়া হয়।", "দ্য মান্থলি স্যালারি ইজ ডিরেক্টলি ডিপোজিটেড ইনটু ইয়োর ব্যাংক অ্যাকাউন্ট।")
        ]
    }
]

part10_lessons = []

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
    part10_lessons.append(lesson_obj)

part10 = {
    "id": "en-foundations-p10",
    "order": 10,
    "level": "A2",
    "title_bn": "বর্তমান কালের কর্মবাচ্য (Present Passive Voice — is/are + V3)",
    "title_target": "Present Passive Voice (is/are + V3 & is/are being + V3)",
    "lessons": part10_lessons
}

data['parts'].append(part10)

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

print("Successfully updated spoken_english_foundations.json with Part 10!")
