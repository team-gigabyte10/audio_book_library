import json
import sys

sys.stdout.reconfigure(encoding='utf-8')

FILE_PATH = 'android/app/src/main/assets/spoken_english_foundations.json'

data = json.load(open(FILE_PATH, encoding='utf-8'))

# Remove existing Part 6 if any
data['parts'] = [p for p in data['parts'] if p['id'] != 'en-foundations-p6']

lessons_def = [
    {
        "id": "en-foundations-l35",
        "order": 1,
        "title_bn": "আমার ও আমাদের দৈনন্দিন কাজ (I, We, You, They + V1)",
        "title_target": "Daily Actions (I, We, You, They + V1)",
        "intro_bn": "সাধারণ বর্তমান কালে I, We, You, They এবং বহুবচন কর্তার সাথে মূল ভার্বের বেস ফর্ম (V1) সরাসরি বসে। প্রতিদিনের অভ্যাস ও কাজের কথা বলতে এই গঠনটি সবচেয়ে বেশি ব্যবহৃত হয়।",
        "structure": ["Subject (I / You / We / They) + Verb (V1) + Extension"],
        "items": [
            ("en-p6-l35-001", "I wake up at six o'clock in the morning.", "আমি সকাল ছয়টায় ঘুম থেকে উঠি।", "আই ওয়েক আপ অ্যাট সিক্স ও'ক্লক ইন দ্য মর্নিং।"),
            ("en-p6-l35-002", "I brush my teeth and wash my face.", "আমি দাঁত মাজি এবং মুখ ধুই।", "আই ব্রাশ মাই টিথ অ্যান্ড ওয়াশ মাই ফেস।"),
            ("en-p6-l35-003", "I have breakfast with my family.", "আমি পরিবারের সাথে সকালের নাস্তা করি।", "আই হ্যাভ ব্রেকফাস্ট উইথ মাই ফ্যামিলি।"),
            ("en-p6-l35-004", "I go to work by bus every day.", "আমি প্রতিদিন বাসে করে কাজে যাই।", "আই গো টু ওয়ার্ক বাই বাস এভরি ডে।"),
            ("en-p6-l35-005", "We live in Dhaka with our parents.", "আমরা আমাদের বাবা-মায়ের সাথে ঢাকায় বাস করি।", "উই লিভ ইন ঢাকা উইথ আওয়ার প্যারেন্টস।"),
            ("en-p6-l35-006", "We drink tea together in the evening.", "আমরা সন্ধ্যায় একসাথে চা পান করি।", "উই ড্রিংক টি টুগেদার ইন দি ইভনিং।"),
            ("en-p6-l35-007", "You speak English very clearly.", "আপনি খুব স্পষ্টভাবে ইংরেজি বলেন।", "ইউ স্পিক ইংলিশ ভেরি ক্লিয়ারলি।"),
            ("en-p6-l35-008", "You help people in need.", "আপনি অভাবী মানুষকে সাহায্য করেন।", "ইউ হেল্প পিপল ইন নিড।"),
            ("en-p6-l35-009", "They play football in the afternoon.", "তারা বিকেলে ফুটবল খেলে।", "দে প্লে ফুটবল ইন দি আফটারনুন।"),
            ("en-p6-l35-010", "They study hard for the examination.", "তারা পরীক্ষার জন্য কঠোর পড়াশোনা করে।", "দে স্টাডি হার্ড ফর দি এক্সামিনেশন।"),
            ("en-p6-l35-011", "I read books before going to sleep.", "আমি ঘুমাতে যাওয়ার আগে বই পড়ি।", "আই রিড বুকস বিফোর গোয়িং টু স্লিপ।"),
            ("en-p6-l35-012", "We love our country very much.", "আমরা আমাদের দেশকে অনেক ভালোবাসি।", "উই লাভ আওয়ার কান্ট্রি ভেরি মাচ।")
        ]
    },
    {
        "id": "en-foundations-l36",
        "order": 2,
        "title_bn": "সে এবং অন্যদের কাজ — 's / es' নিয়ম (He, She, It + Verb-s/es)",
        "title_target": "Third Person Actions (He, She, It + Verb-s/es)",
        "intro_bn": "কর্তা যদি ৩য় পুরুষ একবচন (He, She, It বা যেকোনো একজনের নাম) হয়, তবে সাধারণ বর্তমান কালে ভার্বের শেষে 's' অথবা 'es' যুক্ত হয়। চিরন্তন সত্য বা সময়সূচীর ক্ষেত্রেও এই নিয়ম প্রযোজ্য।",
        "structure": ["Subject (He / She / It / Name) + Verb-(s/es) + Extension"],
        "items": [
            ("en-p6-l36-001", "He works in a private company.", "সে একটি বেসরকারি কোম্পানিতে কাজ করে।", "হি ওয়ার্কস ইন আ প্রাইভেট কোম্পানি।"),
            ("en-p6-l36-002", "He speaks three languages fluently.", "সে সাবলীলভাবে তিনটি ভাষায় কথা বলে।", "হি স্পিকস থ্রি ল্যাঙ্গুয়েজেস ফ্লুয়েন্টলি।"),
            ("en-p6-l36-003", "She teaches English at a high school.", "তিনি একটি হাই স্কুলে ইংরেজি পড়ান।", "শি টিচেস ইংলিশ অ্যাট আ হাই স্কুল।"),
            ("en-p6-l36-004", "She writes emails to her clients.", "তিনি তার গ্রাহকদের ইমেইল লেখেন।", "শি রাইটস ইমেইলস টু হার ক্লায়েন্টস।"),
            ("en-p6-l36-005", "My brother goes to college every day.", "আমার ভাই প্রতিদিন কলেজে যায়।", "মাই ব্রাদার গোজ টু কলেজ এভরি ডে।"),
            ("en-p6-l36-006", "My mother cooks delicious food for us.", "আমার মা আমাদের জন্য সুস্বাদু খাবার রান্না করেন।", "মাই মাদার কুকস ডিলিশাস ফুড ফর আস।"),
            ("en-p6-l36-007", "Rahim plays cricket on the weekend.", "রহিম ছুটির দিনে ক্রিকেট খেলে।", "রহিম প্লেজ ক্রিকেট অন দ্য উইকেন্ড।"),
            ("en-p6-l36-008", "The sun rises in the east.", "সূর্য পূর্ব দিকে ওঠে।", "দ্য সান রাইজেস ইন দি ইস্ট।"),
            ("en-p6-l36-009", "The bus leaves the station at eight o'clock.", "বাসটি আটটায় স্টেশন ছাড়ে।", "দ্য বাস লিভস দ্য স্টেশন অ্যাট এইট ও'ক্লক।"),
            ("en-p6-l36-010", "It rains heavily during the rainy season.", "বর্ষাকালে ভারী বৃষ্টিপাত হয়।", "ইট রেইনস হেভিলি ডিউরিং দ্য রেইনি সিজন।"),
            ("en-p6-l36-011", "She exercises regularly to stay healthy.", "তিনি সুস্থ থাকার জন্য নিয়মিত ব্যায়াম করেন।", "শি এক্সারসাইজেস রেগুলারলি টু স্টে হেলদি।"),
            ("en-p6-l36-012", "He always tells the truth.", "সে সবসময় সত্য কথা বলে।", "হি অলওয়েজ টেলস দ্য ট্রুথ।")
        ]
    },
    {
        "id": "en-foundations-l37",
        "order": 3,
        "title_bn": "না-বোধক বাক্য — 'Don't' ও 'Doesn't' নিয়ম (Negative Sentences)",
        "title_target": "Negative Sentences (Don't & Doesn't)",
        "intro_bn": "সাধারণ বর্তমান কালে না-বোধক বাক্য তৈরি করতে I/We/You/They এর সাথে 'don't' এবং He/She/It/Name এর সাথে 'doesn't' বসে। মনে রাখবেন: doesn't বসলে মূল ভার্বের শেষে আর s/es বসে না।",
        "structure": [
            "I / You / We / They + don't + Verb (Base form)",
            "He / She / It / Name + doesn't + Verb (Base form)"
        ],
        "items": [
            ("en-p6-l37-001", "I don't drink coffee in the morning.", "আমি সকালে কফি পান করি না।", "আই ডোন্ট ড্রিংক কফি ইন দ্য মর্নিং।"),
            ("en-p6-l37-002", "I don't smoke cigarettes.", "আমি সিগারেট খাই না।", "আই ডোন্ট স্মোক সিগারেট্স।"),
            ("en-p6-l37-003", "We don't eat junk food.", "আমরা অপুষ্টিকর খাবার খাই না।", "উই ডোন্ট ইট জাংক ফুড।"),
            ("en-p6-l37-004", "We don't waste our precious time.", "আমরা আমাদের মূল্যবান সময় অপচয় করি না।", "উই ডোন্ট ওয়েস্ট আওয়ার প্রেশাস টাইম।"),
            ("en-p6-l37-005", "You don't make mistakes often.", "আপনি সচরাচর ভুল করেন না।", "ইউ ডোন্ট মেক মিসটেকস অফেন।"),
            ("en-p6-l37-006", "They don't live in this city.", "তারা এই শহরে বাস করে না।", "দে ডোন্ট লিভ ইন দিজ সিটি।"),
            ("en-p6-l37-007", "He doesn't like spicy food.", "সে ঝাল খাবার পছন্দ করে না।", "হি ডাজন্ট লাইক স্পাইসি ফুড।"),
            ("en-p6-l37-008", "He doesn't watch television at night.", "সে রাতে টেলিভিশন দেখে না।", "হি ডাজন্ট ওয়াচ টেলিভিশন অ্যাট নাইট।"),
            ("en-p6-l37-009", "She doesn't drive a car.", "তিনি গাড়ি চালান না।", "শি ডাজন্ট ড্রাইভ আ কার।"),
            ("en-p6-l37-010", "She doesn't tell lies.", "তিনি মিথ্যা কথা বলেন না।", "শি ডাজন্ট টেল লাইজ।"),
            ("en-p6-l37-011", "My friend doesn't wake up early.", "আমার বন্ধু সকালে তাড়াতাড়ি ঘুম থেকে ওঠে না।", "মাই ফ্রেন্ড ডাজন্ট ওয়েক আপ আর্লি।"),
            ("en-p6-l37-012", "It doesn't take much time.", "এতে বেশি সময় লাগে না।", "ইট ডাজন্ট টেক মাচ টাইম।")
        ]
    },
    {
        "id": "en-foundations-l38",
        "order": 4,
        "title_bn": "প্রশ্ন করা ও উত্তর দেওয়া — 'Do / Does' ড্রিল (Do you...? / Does he...?)",
        "title_target": "Questions & Answers (Do / Does Drills)",
        "intro_bn": "প্রশ্ন তৈরি করতে বাক্যের শুরুতে Do অথবা Does বসে। প্রশ্ন শুনে হ্যাঁ-বোধক ও না-বোধক উভয় ধরণের উত্তর দেওয়ার অভ্যাস গড়ে তুলুন।",
        "structure": [
            "Do + you / they + Verb (Base form)? -> Yes, ... / No, don't ...",
            "Does + he / she + Verb (Base form)? -> Yes, ...s/es / No, doesn't ..."
        ],
        "items": [
            ("en-p6-l38-001", "Do you live in this area? Yes, I live in this area. No, I don't live in this area.", "আপনি কি এই এলাকায় থাকেন? হ্যাঁ, আমি এই এলাকায় থাকি। না, আমি এই এলাকায় থাকি না।", "ডু ইউ লিভ ইন দিজ এরিয়া? ইয়েস, আই লিভ ইন দিজ এরিয়া। নো, আই ডোন্ট লিভ ইন দিজ এরিয়া।"),
            ("en-p6-l38-002", "Do you work on the weekend? Yes, I work on the weekend. No, I don't work on the weekend.", "আপনি কি ছুটির দিনে কাজ করেন? হ্যাঁ, আমি ছুটির দিনে কাজ করি। না, আমি ছুটির দিনে কাজ করি না।", "ডু ইউ ওয়ার্ক অন দ্য উইকেন্ড? ইয়েস, আই ওয়ার্ক অন দ্য উইকেন্ড। নো, আই ডোন্ট ওয়ার্ক অন দ্য উইকেন্ড।"),
            ("en-p6-l38-003", "Do you exercise every day? Yes, I exercise every day. No, I don't exercise every day.", "আপনি কি প্রতিদিন ব্যায়াম করেন? হ্যাঁ, আমি প্রতিদিন ব্যায়াম করি। না, আমি প্রতিদিন ব্যায়াম করি না।", "ডু ইউ এক্সারসাইজ এভরি ডে? ইয়েস, আই এক্সারসাইজ এভরি ডে। নো, আই ডোন্ট এক্সারসাইজ এভরি ডে।"),
            ("en-p6-l38-004", "Do you understand English? Yes, I understand English. No, I don't understand English.", "আপনি কি ইংরেজি বুঝতে পারেন? হ্যাঁ, আমি ইংরেজি বুঝি। না, আমি ইংরেজি বুঝি না।", "ডু ইউ আন্ডারস্ট্যান্ড ইংলিশ? ইয়েস, আই আন্ডারস্ট্যান্ড ইংলিশ। নো, আই ডোন্ট আন্ডারস্ট্যান্ড ইংলিশ।"),
            ("en-p6-l38-005", "Do they play cricket here? Yes, they play cricket here. No, they don't play cricket here.", "তারা কি এখানে ক্রিকেট খেলে? হ্যাঁ, তারা এখানে ক্রিকেট খেলে। না, তারা এখানে ক্রিকেট খেলে না।", "ডু দে প্লে ক্রিকেট হিয়ার? ইয়েস, দে প্লে ক্রিকেট হিয়ার। নো, দে ডোন্ট প্লে ক্রিকেট হিয়ার।"),
            ("en-p6-l38-006", "Does he work with you? Yes, he works with me. No, he doesn't work with me.", "সে কি আপনার সাথে কাজ করে? হ্যাঁ, সে আমার সাথে কাজ করে। না, সে আমার সাথে কাজ করে না।", "ডাজ হি ওয়ার্ক উইথ ইউ? ইয়েস, হি ওয়ার্কস উইথ মি। নো, হি ডাজন্ট ওয়ার্ক উইথ মি।"),
            ("en-p6-l38-007", "Does she speak English? Yes, she speaks English. No, she doesn't speak English.", "তিনি কি ইংরেজি বলেন? হ্যাঁ, তিনি ইংরেজি বলেন। না, তিনি ইংরেজি বলেন না।", "ডাজ শি স্পিক ইংলিশ? ইয়েস, শি স্পিকস ইংলিশ। নো, শি ডাজন্ট স্পিক ইংলিশ।"),
            ("en-p6-l38-008", "Does your father drive a car? Yes, he drives a car. No, he doesn't drive a car.", "আপনার বাবা কি গাড়ি চালান? হ্যাঁ, তিনি গাড়ি চালান। না, তিনি গাড়ি চালান না।", "ডাজ ইয়োর ফাদার ড্রাইভ আ কার? ইয়েস, হি ড্রাইভস আ কার। নো, হি ডাজন্ট ড্রাইভ আ কার।"),
            ("en-p6-l38-009", "Does it rain here often? Yes, it rains here often. No, it doesn't rain here often.", "এখানে কি প্রায়ই বৃষ্টি হয়? হ্যাঁ, এখানে প্রায়ই বৃষ্টি হয়। না, এখানে প্রায়ই বৃষ্টি হয় না।", "ডাজ ইট রেইন হিয়ার অফেন? ইয়েস, ইট রেইনস হিয়ার অফেন। নো, ইট ডাজন্ট রেইন হিয়ার অফেন।"),
            ("en-p6-l38-010", "Does Rahim know your name? Yes, he knows my name. No, he doesn't know my name.", "রহিম কি আপনার নাম জানে? হ্যাঁ, সে আমার নাম জানে। না, সে আমার নাম জানে না।", "ডাজ রহিম নো ইয়োর নেম? ইয়েস, হি নোজ মাই নেম। নো, হি ডাজন্ট নো মাই নেম।")
        ]
    },
    {
        "id": "en-foundations-l39",
        "order": 5,
        "title_bn": "Wh-শব্দ দিয়ে তথ্যমূলক প্রশ্ন (What, Where, When, How in Present)",
        "title_target": "Wh- Questions in Present Simple",
        "intro_bn": "কারো কাজ, অবস্থান, সময় বা পদ্ধতি জানতে Wh-word + do/does + Subject + Verb? গঠন ব্যবহার করা হয়। কথোপকথনে তথ্য জানতে এই প্রশ্নগুলো অত্যন্ত জরুরি।",
        "structure": ["Wh-word (What/Where/When/How) + do / does + Subject + Verb (Base form)?"],
        "items": [
            ("en-p6-l39-001", "Where do you work? I work at a software company.", "আপনি কোথায় কাজ করেন? আমি একটি সফটওয়্যার কোম্পানিতে কাজ করি।", "হোয়ার ডু ইউ ওয়ার্ক? আই ওয়ার্ক অ্যাট আ সফটওয়্যার কোম্পানি।"),
            ("en-p6-l39-002", "Where do you live? I live in Dhaka.", "আপনি কোথায় বাস করেন? আমি ঢাকায় বাস করি।", "হোয়ার ডু ইউ লিভ? আই লিভ ইন ঢাকা।"),
            ("en-p6-l39-003", "What do you do in your free time? I read books and listen to music.", "অবসর সময়ে আপনি কী করেন? আমি বই পড়ি এবং গান শুনি।", "হোয়াট ডু ইউ ডু ইন ইয়োর ফ্রি টাইম? আই রিড বুকস অ্যান্ড লিসেন টু মিউজিক।"),
            ("en-p6-l39-004", "What time do you wake up? I usually wake up at six in the morning.", "আপনি কয়টায় ঘুম থেকে ওঠেন? আমি সাধারণত সকাল ছয়টায় ঘুম থেকে উঠি।", "হোয়াট টাইম ডু ইউ ওয়েক আপ? আই ইউজুয়ালি ওয়েক আপ অ্যাট সিক্স ইন দ্য মর্নিং।"),
            ("en-p6-l39-005", "When do you go to bed? I go to bed at eleven at night.", "আপনি কখন ঘুমাতে যান? আমি রাত এগারোটায় ঘুমাতে যাই।", "হোয়েন ডু ইউ গো টু বেড? আই গো টু বেড অ্যাট ইলেভেন অ্যাট নাইট।"),
            ("en-p6-l39-006", "How do you go to office? I go to office by metro rail.", "আপনি কীভাবে অফিসে যান? আমি মেট্রোরেলে করে অফিসে যাই।", "হাউ ডু ইউ গো টু অফিস? আই গো টু অফিস বাই মেট্রো রেল।"),
            ("en-p6-l39-007", "Why do you learn English? I learn English to improve my communication skills.", "আপনি কেন ইংরেজি শেখেন? আমি যোগাযোগের দক্ষতা বাড়াতে ইংরেজি শিখি।", "হোয়াই ডু ইউ লার্ন ইংলিশ? আই লার্ন ইংলিশ টু ইমপ্রুভ মাই কমিউনিকেশন স্কিলস।"),
            ("en-p6-l39-008", "Where does she study? She studies at Dhaka University.", "তিনি কোথায় পড়াশোনা করেন? তিনি ঢাকা বিশ্ববিদ্যালয়ে পড়াশোনা করেন।", "হোয়ার ডাজ শি স্টাডি? শি স্টাডিজ অ্যাট ঢাকা ইউনিভার্সিটি।"),
            ("en-p6-l39-009", "How does he manage his work? He plans his schedule very carefully.", "সে কীভাবে তার কাজ পরিচালনা করে? সে খুব সতর্কতার সাথে তার সময়সূচি তৈরি করে।", "হাউ ডাজ হি ম্যানেজ হিজ ওয়ার্ক? হি প্ল্যানস হিজ স্কেডিউল ভেরি কেয়ারফুলি।"),
            ("en-p6-l39-010", "What does your father do? My father is a businessman.", "আপনার বাবা কী করেন? আমার বাবা একজন ব্যবসায়ী।", "হোয়াট ডাজ ইয়োর ফাদার ডু? মাই ফাদার ইজ আ বিজনেসম্যান।")
        ]
    }
]

part6_lessons = []
for l in lessons_def:
    lesson_items = []
    for item_id, target, bn, bn_pron in l["items"]:
        # Word tokenization
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
                "sentence_type": "present_simple",
                "tense": "present_simple"
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
    part6_lessons.append(lesson_obj)

part6 = {
    "id": "en-foundations-p6",
    "order": 6,
    "level": "A1",
    "title_bn": "দৈনন্দিন কাজ ও সাধারণ বর্তমান কাল (Present Simple: Do/Does)",
    "title_target": "Daily Actions & Present Simple (Do / Does Rules)",
    "lessons": part6_lessons
}

data['parts'].append(part6)

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

print("Successfully updated spoken_english_foundations.json with Part 6!")
