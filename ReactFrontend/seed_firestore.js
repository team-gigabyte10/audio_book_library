import { db } from './src/firebase/config.js';
import { collection, doc, setDoc, serverTimestamp } from 'firebase/firestore';

async function seedFirestoreData() {
  console.log('--- Starting Firestore Data Seeding for Bundles, Courses & Banners ---');

  // 1. HERO BANNERS
  const banners = [
    {
      id: 'banner_spoken_english',
      title: 'কমপ্লিট স্পোকেন ইংলিশ কোর্স',
      subtitle: 'নেটিভ অডিও ও সহজ নিয়মে ফ্লুয়েন্টলি কথা বলুন',
      tag: 'নতুন কোর্স',
      tagColor: '#00897B',
      imageUrl: 'https://images.unsplash.com/photo-1546410531-bb4caa6b424d?w=800&auto=format&fit=crop&q=80',
      actionType: 'course',
      targetId: 'course_spoken_english_mastery',
      order: 1
    },
    {
      id: 'banner_japanese_jlpt',
      title: 'জাপানি ভাষা শিক্ষা - JLPT N5',
      subtitle: 'হিরাগানা, কাতাকানা ও অডিও প্র্যাকটিস সহ ভিসা প্রস্তুতি',
      tag: 'হট কোর্স',
      tagColor: '#E53935',
      imageUrl: 'https://images.unsplash.com/photo-1528164344705-475426879c0d?w=800&auto=format&fit=crop&q=80',
      actionType: 'course',
      targetId: 'course_japanese_n5_mastery',
      order: 2
    },
    {
      id: 'banner_mega_bundle',
      title: 'সেলফ-গ্রোথ মেগা অডিওবুক বান্ডেল',
      subtitle: 'শীর্ষ ৫টি বেস্টসেলার অডিওবুক একসাথে ৬০% ছাড়ে!',
      tag: 'মেগা অফার',
      tagColor: '#FFB300',
      imageUrl: 'https://images.unsplash.com/photo-1512820790803-83ca734da794?w=800&auto=format&fit=crop&q=80',
      actionType: 'bundle',
      targetId: 'bundle_self_growth_mastery',
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

  // 2. AUDIOBOOK BUNDLES
  const bundles = [
    {
      id: 'bundle_self_growth_mastery',
      title: 'সেলফ-গ্রোথ ও মোটিভেশন মেগা বান্ডেল',
      subtitle: 'সাফল্য, অভ্যাস গঠন ও আত্মউন্নয়নের ৫টি বিশ্বসেরা বই',
      description: 'এই বান্ডেলে রয়েছে বিশ্বের শীর্ষস্থানীয় মোটিভেশনাল ও সেলফ-হেল্প বইগুলোর বাংলা অডিওবুক ও সম্পূর্ণ সারসংক্ষেপ। আপনার চিন্তা ও জীবন বদলে দিতে যা অপরিহার্য।',
      coverUrl: 'https://images.unsplash.com/photo-1544716278-ca5e3f4abd8c?w=600&auto=format&fit=crop&q=80',
      bookIds: ['2e7QW7dels4CPEqgJnpQ', 'atomic_habits_bn', '5_sec_rule_bn', 'psychology_money_bn', 'think_grow_rich_bn'],
      bookTitles: [
        'রিচ ড্যাড পুওর ড্যাড (Rich Dad Poor Dad)',
        'অ্যাটমিক হ্যাবিটস (Atomic Habits)',
        'দ্য ৫ সেকেন্ড রুল (The 5 Second Rule)',
        'দ্য সাইকোলজি অব মানি (The Psychology of Money)',
        'থিঙ্ক অ্যান্ড গ্রো রিচ (Think and Grow Rich)'
      ],
      bookCount: 5,
      originalPrice: 1250.0,
      discountedPrice: 499.0,
      savingsPercentage: 60,
      totalDurationHours: 18.5,
      badge: 'বেস্টসেলার বান্ডেল',
      rating: 4.9,
      reviewCount: 380,
      isFeatured: true
    },
    {
      id: 'bundle_wealth_investment',
      title: 'আর্থিক স্বাধীনতা ও বিজনেস অডিও প্যাক',
      subtitle: 'টাকা উপার্জন ও বিনিয়োগের গোপন কৌশল জানুন',
      description: 'ফাইন্যান্সিয়াল ফ্রিডম অর্জনের জন্য শীর্ষ আর্থিক পরামর্শকদের বেস্টসেলার বইগুলোর অডিওবুক সংকলন। প্যাসিভ ইনকাম ও সফল বিজনেস মাইন্ডসেট তৈরির উপায়।',
      coverUrl: 'https://images.unsplash.com/photo-1559526324-4b87b5e36e44?w=600&auto=format&fit=crop&q=80',
      bookIds: ['2e7QW7dels4CPEqgJnpQ', 'millionaire_fastlane_bn', 'psychology_money_bn'],
      bookTitles: [
        'রিচ ড্যাড পুওর ড্যাড (Rich Dad Poor Dad)',
        'দ্য মিলিয়নিয়ার ফাস্টলেন (The Millionaire Fastlane)',
        'দ্য সাইকোলজি অব মানি (The Psychology of Money)'
      ],
      bookCount: 3,
      originalPrice: 750.0,
      discountedPrice: 320.0,
      savingsPercentage: 57,
      totalDurationHours: 11.0,
      badge: 'জনপ্রিয় প্যাক',
      rating: 4.8,
      reviewCount: 210,
      isFeatured: false
    },
    {
      id: 'bundle_productivity_habits',
      title: 'সুপার প্রোডাক্টিভিটি ও টাইম ম্যানেজমেন্ট',
      subtitle: 'আলসেমি দূর করে প্রতিদিনের লক্ষ্য অর্জনের অডিও গাইড',
      description: 'সময় নষ্ট কমানো, ফোকাস বাড়ানো ও দৈনন্দিন অভ্যাসকে ১০০ গুণ শক্তিশালী করার প্রমাণিত বইগুলোর বাংলা অডিওবুক বান্ডেল।',
      coverUrl: 'https://images.unsplash.com/photo-1506784983877-45594efa4cbe?w=600&auto=format&fit=crop&q=80',
      bookIds: ['atomic_habits_bn', '5_sec_rule_bn', 'deep_work_bn'],
      bookTitles: [
        'অ্যাটমিক হ্যাবিটস (Atomic Habits)',
        'দ্য ৫ সেকেন্ড রুল (The 5 Second Rule)',
        'ডিপ ওয়ার্ক (Deep Work)'
      ],
      bookCount: 3,
      originalPrice: 850.0,
      discountedPrice: 349.0,
      savingsPercentage: 59,
      totalDurationHours: 10.5,
      badge: 'হাই প্রোডাক্টিভিটি',
      rating: 4.9,
      reviewCount: 195,
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

  // 3. LANGUAGE COURSES (English & Japanese)
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
      originalPrice: 1500.0,
      discountedPrice: 499.0,
      isFree: false,
      tags: ['Spoken English', 'Fluency', 'Audio Dialogues', 'Native Pronunciation', 'PDF Notes'],
      modules: [
        {
          moduleTitle: 'মডিউল ১: সেলফ ইন্ট্রোডাকশন ও প্রতিদিনের শুভেচ্ছা',
          lessons: [
            { id: 'en_01', title: '১. How to introduce yourself professionally', duration: '12 min', isFree: true },
            { id: 'en_02', title: '২. Daily greetings & polite expressions', duration: '14 min', isFree: true },
            { id: 'en_03', title: '৩. Asking questions correctly in English', duration: '18 min', isFree: false }
          ]
        },
        {
          moduleTitle: 'মডিউল ২: ফ্লুয়েন্ট স্পিকিং ও ফোনে কথোপকথন',
          lessons: [
            { id: 'en_04', title: '৪. Making phone calls & scheduling', duration: '15 min', isFree: false },
            { id: 'en_05', title: '৫. Expressing opinions & agreement/disagreement', duration: '20 min', isFree: false }
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
      originalPrice: 900.0,
      discountedPrice: 350.0,
      isFree: false,
      tags: ['Vocabulary', 'Audio Drills', 'Memory Techniques', 'Pronunciation'],
      modules: [
        {
          moduleTitle: 'মডিউল ১: হাই-ফ্রিকোয়েন্সি শব্দ ও অডিও প্র্যাকটিস',
          lessons: [
            { id: 'en_v01', title: '১. Top 100 most common everyday words', duration: '15 min', isFree: true },
            { id: 'en_v02', title: '২. Work & Office vocabulary with audio', duration: '16 min', isFree: false }
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
      originalPrice: 1800.0,
      discountedPrice: 650.0,
      isFree: false,
      tags: ['IELTS', 'Band 7+', 'Speaking', 'Listening Tests', 'Mock Audio'],
      modules: [
        {
          moduleTitle: 'মডিউল ১: স্পিকিং পার্ট ১ ও ২ মাস্টারক্লাস',
          lessons: [
            { id: 'en_i01', title: '১. How to answer Speaking Part 1 naturally', duration: '20 min', isFree: true },
            { id: 'en_i02', title: '২. Cue Card presentation formula', duration: '22 min', isFree: false }
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
      originalPrice: 2000.0,
      discountedPrice: 599.0,
      isFree: false,
      tags: ['Japanese', 'JLPT N5', 'Hiragana', 'Katakana', 'Kanji', 'Audio Lessons'],
      modules: [
        {
          moduleTitle: 'মডিউল ১: হিরাগানা ও কাতাকানা সঠিক উচ্চারণ ও লেখা',
          lessons: [
            { id: 'jp_01', title: '১. হিরাগানা স্বরবর্ণ (A, I, U, E, O) অডিও উচ্চারণ', duration: '15 min', isFree: true },
            { id: 'jp_02', title: '২. হিরাগানা ব্যঞ্জনবর্ণ ও শব্দ তৈরি', duration: '18 min', isFree: true },
            { id: 'jp_03', title: '৩. কাতাকানা বর্ণমালা ও বিদেশি শব্দের নিয়ম', duration: '20 min', isFree: false }
          ]
        },
        {
          moduleTitle: 'মডিউল ২: দৈনন্দিন অভিবাদন ও মিন্না নো নিহোঙ্গো লেসন ১-৫',
          lessons: [
            { id: 'jp_04', title: '৪. Konnichiwa, Arigato ও প্রতিদিনের অভিবাদন', duration: '15 min', isFree: false },
            { id: 'jp_05', title: '৫. আমি অমুক - Watashi wa... desu প্যাটার্ন', duration: '22 min', isFree: false }
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
      originalPrice: 1200.0,
      discountedPrice: 450.0,
      isFree: false,
      tags: ['Spoken Japanese', 'Conversations', 'Baito phrases', 'Audio Drills'],
      modules: [
        {
          moduleTitle: 'মডিউল ১: দোকান ও রেস্তোরাঁয় অর্ডার করার জাপানি নিয়ম',
          lessons: [
            { id: 'jp_c01', title: '১. কনভিনিয়েন্স স্টোরে (Konbini) কথা বলা', duration: '14 min', isFree: true },
            { id: 'jp_c02', title: '২. রেস্তোরাঁয় খাবারের অর্ডার ও বিল চাওয়া', duration: '16 min', isFree: false }
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
      originalPrice: 2200.0,
      discountedPrice: 699.0,
      isFree: false,
      tags: ['JLPT N4', 'Kanji', 'Grammar', 'Audio Explanation'],
      modules: [
        {
          moduleTitle: 'মডিউল ১: N4 ব্যাকরণ কাঠামো ও জটিল রূপান্তর',
          lessons: [
            { id: 'jp_n4_01', title: '১. তে-ফর্ম (Te-form) এর জটিল ব্যবহার', duration: '20 min', isFree: true },
            { id: 'jp_n4_02', title: '২. সম্ভাবনাময় রূপ (Potential form)', duration: '22 min', isFree: false }
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

  console.log('--- Firestore Seeding Successfully Finished! ---');
}

seedFirestoreData().then(() => {
  console.log('Done!');
  process.exit(0);
}).catch((err) => {
  console.error('Error seeding data:', err);
  process.exit(1);
});
