import { db } from './src/firebase/config.js';
import { collection, doc, setDoc, serverTimestamp } from 'firebase/firestore';

async function seedFirestoreData() {
  console.log('--- Starting Firestore Data Seeding for Bundles & Courses (No Price) ---');

  // 1. HERO BANNERS (3 Main Categories: Audio Book Bundles, English Course, Japanese Course)
  const banners = [
    {
      id: 'banner_mega_bundle',
      title: 'সেলফ-গ্রোথ মেগা অডিওবুক বান্ডেল',
      subtitle: 'শীর্ষ ৫টি বিশ্বখ্যাত বেস্টসেলার বই একসাথে বাংলায় শুনুন',
      tag: 'আত্ম উন্নয়নমূলক বই',
      tagColor: '#00695C',
      imageUrl: 'https://images.unsplash.com/photo-1512820790803-83ca734da794?w=800&auto=format&fit=crop&q=80',
      actionType: 'bundle',
      targetId: 'bundle_self_growth_mastery',
      order: 1
    },
    {
      id: 'banner_spoken_english',
      title: 'কমপ্লিট স্পোকেন ইংলিশ কোর্স',
      subtitle: 'নেটিভ অডিও ও সহজ নিয়মে ফ্লুয়েন্টলি কথা বলুন',
      tag: 'ইংরেজি কোর্স',
      tagColor: '#1565C0',
      imageUrl: 'https://images.unsplash.com/photo-1546410531-bb4caa6b424d?w=800&auto=format&fit=crop&q=80',
      actionType: 'course',
      targetId: 'course_spoken_english_mastery',
      order: 2
    },
    {
      id: 'banner_japanese_jlpt',
      title: 'জাপানি ভাষা শিক্ষা - JLPT N5',
      subtitle: 'হিরাগানা, কাতাকানা ও অডিও প্র্যাকটিস সহ ভিসা প্রস্তুতি',
      tag: 'জাপানি কোর্স',
      tagColor: '#C62828',
      imageUrl: 'https://images.unsplash.com/photo-1528164344705-475426879c0d?w=800&auto=format&fit=crop&q=80',
      actionType: 'course',
      targetId: 'course_japanese_n5_mastery',
      order: 3
    }
  ];

  for (const b of banners) {
    await setDoc(doc(db, 'banners', b.id), {
      ...b,
      updatedAt: serverTimestamp()
    });
    console.log(`✓ Saved banner: ${b.title}`);
  }

  // 2. AUDIOBOOK BUNDLES (8 Categories from '113+ আত্ম উন্নয়নমূলক বাংলা বই', No Price Mentions)
  const bundles = [
    {
      id: 'bundle_wealth_finance',
      categoryKey: '01_Wealth_and_Finance',
      title: 'ধনসম্পদ ও আর্থিক স্বাধীনতা',
      subtitle: 'টাকা উপার্জন, ইনভেস্টমেন্ট ও সম্পদ তৈরির বেস্টসেলার বই',
      description: 'আর্থিক সচ্ছলতা ও সম্পদ গড়ে তোলার সেরা বইগুলোর বাংলা অডিওবুক। রিচ ড্যাড পুওর ড্যাড, দ্য সাইকোলজি অব মানি, থিঙ্ক অ্যান্ড গ্রো রিচ সহ অন্যান্য শ্রেষ্ঠ বই।',
      coverUrl: 'https://images.unsplash.com/photo-1559526324-4b87b5e36e44?w=600&auto=format&fit=crop&q=80',
      bookIds: ['2e7QW7dels4CPEqgJnpQ', 'psychology_money_bn', 'think_grow_rich_bn', 'richest_man_babylon_bn'],
      bookTitles: [
        'রিচ ড্যাড পুওর ড্যাড',
        'দ্য সাইকোলজি অব মানি',
        'থিঙ্ক অ্যান্ড গ্রো রিচ',
        'দ্য রিচেস্ট ম্যান ইন ব্যাবিলন',
        '৭ স্ট্র্যাটেজিস ফর ওয়েলথ অ্যান্ড হ্যাপিনেস',
        'ওয়ারেন বাফেট সাকসেস সিক্রেট'
      ],
      bookCount: 8,
      totalDurationHours: 14.0,
      badge: 'ফাইন্যান্স কালেকশন',
      rating: 4.9,
      reviewCount: 320,
      isFeatured: true
    },
    {
      id: 'bundle_habits_productivity',
      categoryKey: '02_Habits_and_Productivity',
      title: 'অভ্যাস গঠন ও প্রোডাক্টিভিটি',
      subtitle: 'আলসেমি দূর করে প্রতিদিনের সর্বোচ্চ ফোকাস ও কার্যক্ষমতা',
      description: 'দৈনন্দিন অভ্যাস বদলে সাফল্য অর্জনের বিখ্যাত অডিওবুক। অ্যাটমিক হ্যাবিটস, ৫ সেকেন্ড রুল, ইট দ্যাট ফ্রগ, ডোপামিন ডিটক্স সহ প্রয়োজনীয় বই।',
      coverUrl: 'https://images.unsplash.com/photo-1506784983877-45594efa4cbe?w=600&auto=format&fit=crop&q=80',
      bookIds: ['atomic_habits_bn', '5_sec_rule_bn', 'eat_that_frog_bn', 'dopamine_detox_bn'],
      bookTitles: [
        'অ্যাটমিক হ্যাবিটস (Atomic Habits)',
        '৫ সেকেন্ড রুল (5 Second Rule)',
        'ডোপামিন ডিটক্স',
        'ইট দ্যাট ফ্রগ (Eat That Frog)',
        '৭ হ্যাবিটস অব হাইলি ইফেক্টিভ পিপল',
        'দ্য মিরাকল মর্নিং'
      ],
      bookCount: 14,
      totalDurationHours: 19.5,
      badge: 'প্রোডাক্টিভিটি',
      rating: 4.9,
      reviewCount: 410,
      isFeatured: true
    },
    {
      id: 'bundle_mindset_psychology',
      categoryKey: '03_Mindset_and_Psychology',
      title: 'মাইন্ডসেট ও মানব মনস্তত্ত্ব',
      subtitle: 'ইতিবাচক মানসিকতা, মন নিয়ন্ত্রণ ও সাবকনশাস মাইন্ডের শক্তি',
      description: 'মনস্তত্ত্ব, মানসিক শান্তি ও আত্মবিশ্বাস বাড়ানোর সেরা অডিওবুক। ৪৮ লজ অব পাওয়ার, দ্য পাওয়ার অব সাবকনশাস মাইন্ড, ইউ ক্যান উইন ইত্যাদি।',
      coverUrl: 'https://images.unsplash.com/photo-1507679799987-c73779587ccf?w=600&auto=format&fit=crop&q=80',
      bookIds: ['48_laws_power_bn', 'subconscious_mind_bn', 'you_can_win_bn', 'magic_thinking_big_bn'],
      bookTitles: [
        '৪৮ লজ অব পাওয়ার (48 Laws of Power)',
        'দ্য পাওয়ার অব ইউর সাবকনশাস মাইন্ড',
        'ডার্ক সাইকোলজি অ্যান্ড সিক্রেটস',
        'তুমিও জিতবে (You Can Win)',
        'দ্য ম্যাজিক অব থিংকিং বিগ',
        'দি সাটল আর্ট অব নট গিভিং আ ফ**'
      ],
      bookCount: 33,
      totalDurationHours: 42.0,
      badge: 'মেগা কালেকশন',
      rating: 4.9,
      reviewCount: 560,
      isFeatured: true
    },
    {
      id: 'bundle_communication_skills',
      categoryKey: '04_Communication_and_Interpersonal',
      title: 'যোগাযোগ ও ব্যক্তিত্ব বিকাশ',
      subtitle: 'বডি ল্যাঙ্গুয়েজ, আকর্ষণীয় ব্যক্তিত্ব ও সাবলীল কথোপকথন',
      description: 'মানুষের সাথে কার্যকর যোগাযোগ তৈরি এবং সবার মন জয় করার বিশ্বখ্যাত কৌশল ও অডিওবুক সংগ্রহ। হাউ টু টক টু এনিওয়ান, বডি ল্যাঙ্গুয়েজ ও বন্ধুলাভের উপায়।',
      coverUrl: 'https://images.unsplash.com/photo-1521791136064-7986c2920216?w=600&auto=format&fit=crop&q=80',
      bookIds: ['how_to_win_friends_bn', 'body_language_bn', 'how_to_talk_bn'],
      bookTitles: [
        'প্রতিপত্তি ও বন্ধুলাভ',
        'বডি ল্যাঙ্গুয়েজ (Body Language)',
        'হাউ টু টক টু এনিওয়ান',
        'বক্তৃতা শিখবেন কীভাবে',
        'না বলতে শিখুন',
        'দ্য আর্ট অব পারসুয়েশন'
      ],
      bookCount: 8,
      totalDurationHours: 12.0,
      badge: 'কমিউনিকেশন',
      rating: 4.8,
      reviewCount: 275,
      isFeatured: false
    },
    {
      id: 'bundle_career_leadership',
      categoryKey: '05_Career_Business_and_Leadership',
      title: 'ক্যারিয়ার, ব্যবসা ও নেতৃত্ব',
      subtitle: 'বিজনেস স্ট্র্যাটেজি, উদ্যোক্তা হওয়া ও সফল লিডারশিপ',
      description: 'ক্যারিয়ারে পদোন্নতি, নতুন স্টার্টআপ তৈরি ও দক্ষ নেতৃত্ব গঠনের বাস্তবমুখী পরামর্শ। জিরো টু ওয়ান, ওয়ান মিনিট ম্যানেজার ও লিডারশিপ ১০১।',
      coverUrl: 'https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?w=600&auto=format&fit=crop&q=80',
      bookIds: ['zero_to_one_bn', 'one_minute_manager_bn', 'leadership_101_bn'],
      bookTitles: [
        'জিরো টু ওয়ান (Zero to One)',
        'দ্যা পারসোনাল MBA',
        'ওয়ান মিনিট ম্যানেজার',
        'আজকের নেতা ও সফল নেতৃত্বের শত কৌশল',
        'লিডারশিপ ১০১',
        'স্টিল লাইক অ্যান আর্টিস্ট'
      ],
      bookCount: 15,
      totalDurationHours: 21.0,
      badge: 'বিজনেস ও ক্যারিয়ার',
      rating: 4.8,
      reviewCount: 230,
      isFeatured: false
    },
    {
      id: 'bundle_philosophy_spiritual',
      categoryKey: '06_Philosophy_and_Spiritual_Quantum',
      title: 'জীবনদর্শন ও আত্মিক শান্তি',
      subtitle: 'ইকিগাই, গভীর ধ্যান ও আত্মিক মানসিক প্রশান্তির নির্দেশিকা',
      description: 'জীবনের অর্থ ও দীর্ঘ সুস্থ জীবনের রহস্য। দ্য মংক হু সোল্ড হিজ ফেরারি, দি সিক্রেট, ইকিগাই ও কোয়ান্টাম প্রশান্তির অমূল্য অডিও সংকলন।',
      coverUrl: 'https://images.unsplash.com/photo-1506126613408-eca07ce68773?w=600&auto=format&fit=crop&q=80',
      bookIds: ['ikigai_bn', 'the_secret_bn', 'monk_sold_ferrari_bn', 'mans_search_meaning_bn'],
      bookTitles: [
        'ইকিগাই (Ikigai)',
        'দি সিক্রেট (The Secret)',
        'দ্য মংক হু সোল্ড হিজ ফেরারি',
        'ম্যানস সার্চ ফর মিনিং',
        'দ্যা আলমানাক অব নাভাল রাভিকান্ত',
        'কোয়ান্টাম চেতনা ও প্রশান্তি'
      ],
      bookCount: 19,
      totalDurationHours: 26.0,
      badge: 'আত্মিক শান্তি',
      rating: 4.9,
      reviewCount: 390,
      isFeatured: false
    },
    {
      id: 'bundle_family_relationships',
      categoryKey: '07_Family_and_Relationships',
      title: 'পারিবারিক সম্পর্ক ও প্যারেন্টিং',
      subtitle: 'সুখী দাম্পত্য, ইতিবাচক সন্তান লালন-পালন ও পারিবারিক বন্ধন',
      description: 'পারিবারিক সুখ-শান্তি বজায় রাখা, মধুর দাম্পত্য সম্পর্ক এবং আধুনিক প্যারেন্টিং টিপসের প্রয়োজনীয় অডিও গাইড।',
      coverUrl: 'https://images.unsplash.com/photo-1491438590914-bc09fcaaf77a?w=600&auto=format&fit=crop&q=80',
      bookIds: ['parenting_tips_bn', 'happy_family_bn'],
      bookTitles: [
        'প্যারেন্টিং বুক ও শত টিপস',
        'বয় vs গার্ল',
        'স্ত্রী যখন বান্ধবী'
      ],
      bookCount: 3,
      totalDurationHours: 6.5,
      badge: 'প্যারেন্টিং ও পরিবার',
      rating: 4.8,
      reviewCount: 140,
      isFeatured: false
    },
    {
      id: 'bundle_biography_literature',
      categoryKey: '08_Biography_and_Literature',
      title: 'অনুপ্রেরণামূলক জীবনী ও সাহিত্য',
      subtitle: 'বিশ্বসেরা ব্যক্তিত্বদের জীবনসংগ্রাম ও কালজয়ী সাহিত্যের রস',
      description: 'বিশ্ববিখ্যাত ১০০ মনীষীর জীবনী, এ পি জে আবদুল কালামের উইংস অব ফায়ার এবং দ্য আলকেমিস্টের মতো হৃদয়ছোঁয়া অডিও সাহিত্যের এক অনন্য সংগ্রহ।',
      coverUrl: 'https://images.unsplash.com/photo-1476275466078-4007374efbbe?w=600&auto=format&fit=crop&q=80',
      bookIds: ['alchemist_bn', 'wings_of_fire_bn', 'top_100_legends_bn'],
      bookTitles: [
        'দ্য আলকেমিস্ট (The Alchemist)',
        'উইংস অব ফায়ার (Wings of Fire)',
        'বিশ্ব শ্রেষ্ঠ ১০০ মানুষের জীবনী',
        'বরণীয় যারা স্মরণীয় যারা',
        'টাইম মেশিন (Time Machine)',
        'ফাইভ পয়েন্ট সামওয়ান'
      ],
      bookCount: 14,
      totalDurationHours: 24.0,
      badge: 'জীবনী ও ক্লাসিক',
      rating: 4.9,
      reviewCount: 310,
      isFeatured: false
    }
  ];

  for (const bundle of bundles) {
    await setDoc(doc(db, 'bundles', bundle.id), {
      ...bundle,
      updatedAt: serverTimestamp()
    });
    console.log(`✓ Saved bundle: ${bundle.title}`);
  }

  // 3. LANGUAGE COURSES (English & Japanese - No Price)
  const courses = [
    // --- ENGLISH COURSES ---
    {
      id: 'course_spoken_english_mastery',
      title: 'কমপ্লিট স্পোকেন ইংলিশ ও ফ্লুয়েন্সি কোর্স',
      subtitle: 'প্রতিদিনের প্রয়োজনীয় ইংরেজি কথোপকথন ও সঠিক উচ্চারণ',
      language: 'English',
      level: 'Beginner to Intermediate',
      instructor: 'Dr. Tanvir Rahman & Native Speakers',
      description: 'ঘরে বসেই সাবলীল ইংরেজিতে কথা বলার পূর্ণাঙ্গ অডিও কোর্স। এতে রয়েছে অফিস, ট্রাভেল, ইন্টারভিউ ও দৈনন্দিন জীবনের শত শত ডায়ালগ, অডিও উচ্চারণ ও বাংলা ব্যাখ্যা।',
      thumbnailUrl: 'https://images.unsplash.com/photo-1546410531-bb4caa6b424d?w=600&auto=format&fit=crop&q=80',
      bannerUrl: 'https://images.unsplash.com/photo-1546410531-bb4caa6b424d?w=1000&auto=format&fit=crop&q=80',
      totalHours: 14.5,
      lessonCount: 30,
      rating: 4.9,
      enrolledCount: 2340,
      tags: ['Spoken English', 'Fluency', 'Audio Dialogues', 'Native Pronunciation', 'PDF Notes'],
      modules: [
        {
          moduleTitle: 'মডিউল ১: সেলফ ইন্ট্রোডাকশন ও প্রতিদিনের শুভেচ্ছা',
          lessons: [
            { id: 'en_01', title: '১. How to introduce yourself professionally', duration: '12 min', isFree: true },
            { id: 'en_02', title: '২. Daily greetings & polite expressions', duration: '14 min', isFree: true },
            { id: 'en_03', title: '৩. Asking questions correctly in English', duration: '18 min', isFree: true }
          ]
        },
        {
          moduleTitle: 'মডিউল ২: ফ্লুয়েন্ট স্পিকিং ও ফোনে কথোপকথন',
          lessons: [
            { id: 'en_04', title: '৪. Making phone calls & scheduling', duration: '15 min', isFree: true },
            { id: 'en_05', title: '৫. Expressing opinions & agreement/disagreement', duration: '20 min', isFree: true }
          ]
        }
      ]
    },
    {
      id: 'course_english_vocabulary_pronunciation',
      title: 'দৈনন্দিন ইংরেজি ১০০০+ ভোকাবুলারি ও উচ্চারণ',
      subtitle: 'অডিও উচ্চারণ ও বাস্তব বাক্যে প্রয়োগ সহ ভোকাবুলারি আয়ত্ত করুন',
      language: 'English',
      level: 'All Levels',
      instructor: 'Farhana Akhter (TESOL Certified)',
      description: 'কঠিন শব্দ সহজে মনে রাখার মেমোরি টেকনিক এবং প্রতিটি শব্দের সঠিক নেটিভ উচ্চারণ। স্পিকিং এবং লিসেনিং স্কিল দ্রুত উন্নত করার জন্য সেরা কোর্স।',
      thumbnailUrl: 'https://images.unsplash.com/photo-1456513080510-7bf3a84b82f8?w=600&auto=format&fit=crop&q=80',
      bannerUrl: 'https://images.unsplash.com/photo-1456513080510-7bf3a84b82f8?w=1000&auto=format&fit=crop&q=80',
      totalHours: 8.0,
      lessonCount: 20,
      rating: 4.8,
      enrolledCount: 1680,
      tags: ['Vocabulary', 'Audio Drills', 'Memory Techniques', 'Pronunciation'],
      modules: [
        {
          moduleTitle: 'মডিউল ১: হাই-ফ্রিকোয়েন্সি শব্দ ও অডিও প্র্যাকটিস',
          lessons: [
            { id: 'en_v01', title: '১. Top 100 most common everyday words', duration: '15 min', isFree: true },
            { id: 'en_v02', title: '২. Work & Office vocabulary with audio', duration: '16 min', isFree: true }
          ]
        }
      ]
    },
    {
      id: 'course_ielts_speaking_listening',
      title: 'আইইএলটিএস স্পিকিং ও লিসেনিং ব্যান্ড ৭+ গাইড',
      subtitle: 'ব্যান্ড ৭+ নিশ্চিত করতে রিয়েল এক্সাম স্যাম্পল ও অডিও অডিশন',
      language: 'English',
      level: 'Intermediate to Advanced',
      instructor: 'Cambridge Certified Trainer',
      description: 'IELTS Speaking Part 1, 2, 3 এর বাস্তব মডেল উত্তর এবং ব্যান্ড ৯ স্কোরারদের অডিও বিশ্লেষণ। লিসেনিং টেস্টে সর্বোচ্চ স্কোর পাওয়ার সিক্রেট স্ট্র্যাটেজি।',
      thumbnailUrl: 'https://images.unsplash.com/photo-1434030216411-0b793f4b4173?w=600&auto=format&fit=crop&q=80',
      bannerUrl: 'https://images.unsplash.com/photo-1434030216411-0b793f4b4173?w=1000&auto=format&fit=crop&q=80',
      totalHours: 12.0,
      lessonCount: 25,
      rating: 4.9,
      enrolledCount: 1950,
      tags: ['IELTS', 'Band 7+', 'Speaking', 'Listening Tests', 'Mock Audio'],
      modules: [
        {
          moduleTitle: 'মডিউল ১: স্পিকিং পার্ট ১ ও ২ মাস্টারক্লাস',
          lessons: [
            { id: 'en_i01', title: '১. How to answer Speaking Part 1 naturally', duration: '20 min', isFree: true },
            { id: 'en_i02', title: '২. Cue Card presentation formula', duration: '22 min', isFree: true }
          ]
        }
      ]
    },

    // --- JAPANESE COURSES ---
    {
      id: 'course_japanese_n5_mastery',
      title: 'জাপানি ভাষা শিক্ষা - JLPT N5 পূর্ণাঙ্গ কোর্স',
      subtitle: 'হিরাগানা, কাতাকানা, প্রাথমিক কাঞ্জি ও অডিও ডায়ালগ',
      language: 'Japanese',
      level: 'JLPT N5 (Beginner)',
      instructor: 'Sensei Masahiro & Rafiqul Islam (N2 Certified)',
      description: 'জাপানে উচ্চশিক্ষা বা চাকরির ভিসার জন্য JLPT N5 পরীক্ষায় শতভাগ পাশের সম্পূর্ণ অডিও ও ভিডিও কোর্স। বাংলা ব্যাখ্যা ও প্রতিটি শব্দের জাপানি অডিও উচ্চারণ।',
      thumbnailUrl: 'https://images.unsplash.com/photo-1528164344705-475426879c0d?w=600&auto=format&fit=crop&q=80',
      bannerUrl: 'https://images.unsplash.com/photo-1528164344705-475426879c0d?w=1000&auto=format&fit=crop&q=80',
      totalHours: 22.0,
      lessonCount: 40,
      rating: 4.9,
      enrolledCount: 3120,
      tags: ['Japanese', 'JLPT N5', 'Hiragana', 'Katakana', 'Kanji', 'Audio Lessons'],
      modules: [
        {
          moduleTitle: 'মডিউল ১: হিরাগানা ও কাতাকানা সঠিক উচ্চারণ ও লেখা',
          lessons: [
            { id: 'jp_01', title: '১. হিরাগানা স্বরবর্ণ (A, I, U, E, O) অডিও উচ্চারণ', duration: '15 min', isFree: true },
            { id: 'jp_02', title: '২. হিরাগানা ব্যঞ্জনবর্ণ ও শব্দ তৈরি', duration: '18 min', isFree: true },
            { id: 'jp_03', title: '৩. কাতাকানা বর্ণমালা ও বিদেশি শব্দের নিয়ম', duration: '20 min', isFree: true }
          ]
        },
        {
          moduleTitle: 'মডিউল ২: দৈনন্দিন অভিবাদন ও মিন্না নো নিহোঙ্গো লেসন ১-৫',
          lessons: [
            { id: 'jp_04', title: '৪. Konnichiwa, Arigato ও প্রতিদিনের অভিবাদন', duration: '15 min', isFree: true },
            { id: 'jp_05', title: '৫. আমি অমুক - Watashi wa... desu প্যাটার্ন', duration: '22 min', isFree: true }
          ]
        }
      ]
    },
    {
      id: 'course_japanese_conversational_tokyo',
      title: 'জাপানি স্পোকেন কনভারসেশন ও ডেলি ডায়ালগ',
      subtitle: 'জাপানে দৈনন্দিন জীবন, শপিং ও কাজের বাস্তব কথোপকথন',
      language: 'Japanese',
      level: 'Conversational',
      instructor: 'Yuki Tanaka & Global Bengali Japan Community',
      description: 'কোনো ব্যাকরণগত জটিলতা ছাড়াই বাস্তব জীবনের জাপানি কথোপকথন শিখুন। কনভিনিয়েন্স স্টোর, ট্রেন স্টেশন, রেস্তোরাঁ ও বাইতো (খণ্ডকালীন কাজ)-এর দরকারি অডিও ডায়ালগ।',
      thumbnailUrl: 'https://images.unsplash.com/photo-1503899036084-c55cdd92da26?w=600&auto=format&fit=crop&q=80',
      bannerUrl: 'https://images.unsplash.com/photo-1503899036084-c55cdd92da26?w=1000&auto=format&fit=crop&q=80',
      totalHours: 10.0,
      lessonCount: 22,
      rating: 4.8,
      enrolledCount: 1450,
      tags: ['Spoken Japanese', 'Conversations', 'Baito phrases', 'Audio Drills'],
      modules: [
        {
          moduleTitle: 'মডিউল ১: দোকান ও রেস্তোরাঁয় অর্ডার করার জাপানি নিয়ম',
          lessons: [
            { id: 'jp_c01', title: '১. কনভিনিয়েন্স স্টোরে (Konbini) কথা বলা', duration: '14 min', isFree: true },
            { id: 'jp_c02', title: '২. রেস্তোরাঁয় খাবারের অর্ডার ও বিল চাওয়া', duration: '16 min', isFree: true }
          ]
        }
      ]
    },
    {
      id: 'course_japanese_n4_grammar_kanji',
      title: 'JLPT N4 ব্যাকরণ ও ১০০টি অপরিহার্য কাঞ্জি',
      subtitle: 'N4 পরীক্ষার পূর্ণ প্রস্তুতি ও দ্রুত কাঞ্জি মনে রাখার উপায়',
      language: 'Japanese',
      level: 'JLPT N4',
      instructor: 'Sensei Masahiro (Senior Instructor)',
      description: 'N5 পাস করার পরের ধাপ। N4 এর প্রয়োজনীয় ব্যাকরণ সূত্র এবং জটিল কাঞ্জি ছবি ও গল্পের মাধ্যমে সহজে মুখস্থ করার এক্সক্লুসিভ টেকনিক।',
      thumbnailUrl: 'https://images.unsplash.com/photo-1534447677768-be436bb09401?w=600&auto=format&fit=crop&q=80',
      bannerUrl: 'https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1000&auto=format&fit=crop&q=80',
      totalHours: 16.0,
      lessonCount: 28,
      rating: 4.9,
      enrolledCount: 1120,
      tags: ['JLPT N4', 'Kanji', 'Grammar', 'Audio Explanation'],
      modules: [
        {
          moduleTitle: 'মডিউল ১: N4 ব্যাকরণ কাঠামো ও জটিল রূপান্তর',
          lessons: [
            { id: 'jp_n4_01', title: '১. তে-ফর্ম (Te-form) এর জটিল ব্যবহার', duration: '20 min', isFree: true },
            { id: 'jp_n4_02', title: '২. সম্ভাবনাময় রূপ (Potential form)', duration: '22 min', isFree: true }
          ]
        }
      ]
    }
  ];

  for (const course of courses) {
    await setDoc(doc(db, 'courses', course.id), {
      ...course,
      updatedAt: serverTimestamp()
    });
    console.log(`✓ Saved course: [${course.language}] ${course.title}`);
  }

  console.log('--- Firestore Seeding Successfully Finished (No Price)! ---');
}

seedFirestoreData().then(() => {
  console.log('Done!');
  process.exit(0);
}).catch((err) => {
  console.error('Error seeding data:', err);
  process.exit(1);
});
