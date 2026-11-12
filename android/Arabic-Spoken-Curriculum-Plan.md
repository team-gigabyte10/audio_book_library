# Spoken Arabic Curriculum Plan: Zero to Advanced & Gulf/Hajj Specialist (for Bangla Speakers)

This plan outlines a comprehensive spoken Arabic course (**আরবি স্পোকেন কোর্স: শূন্য থেকে অ্যাডভান্সড ও গাল্ফ প্রবাস**) designed specifically for Bangla speakers. It is completely separate from the existing **Quran Learning & Tajweed** course (`qr-`, `quran_course`), focusing on **Modern Standard Arabic (فصحى / MSA)** for universal clarity plus **Gulf/Saudi Spoken Arabic (خليجي / সৌদি ও গাল্ফ কথ্য আরবি)** for real-life communication in Saudi Arabia, UAE, Qatar, Kuwait, Oman, and Bahrain.

---

## 1. Core Design Principles

1. **Speaking First (التحدث أولاً):** Every lesson builds active spoken fluency. Arabic script (`العربية`) is presented with full **Harakat / Tashkeel (হরকত / জবর-জের-পেশ)** in Stage 0 and A1 so learners never guess vowel sounds, gradually transitioning to natural unvowelled everyday text in B2/Specialist while keeping audio & Bangla phonetic bridges (`bn_pron`).
2. **Leverage What Bangla Already Gives:**
   - **Shared Vocabulary Goldmine:** Bangla already contains thousands of Arabic loanwords (*কিতাব/كتاب, কলম/قلم, ওয়াক্ত/وقت, খবর/خبر, হিসাব/حساب, দুনিয়া/دنيا, হক/حق, শুকরিয়া/شكر, সালাম/سلام, ইনশাআল্লাহ/إن شاء الله, মাশাআল্লাহ/ما شاء الله*). Stage 0 & A1 actively unlock these cognates for instant confidence.
   - **Gender & Respect:** Arabic distinguishes masculine (*أنتَ / أنتَ*) vs feminine (*أنتِ*) and polite forms (*حضرتك / لو سمحت*).
3. **Fix the Hard Points for Bangla Speakers Early:**
   - **Throat & Emphatic Consonants (حروف الحلق والتفخيم):**
     - `ع` (আইন) vs `أ` (আলিফ)
     - `ح` (বড় হা — গলার ভেতর থেকে শ্বাস) vs `هـ` (ছোট হা)
     - `خ` (খ — গলার ঘর্ষণ) vs Bangla খ
     - `ق` (ক্বফ — গভীর কণ্ঠনালীয় ক) vs `ك` (কাফ)
     - Emphatic pairs: `ص / س`, `ض / د`, `ط / ت`, `ظ / ذ / ز`
   - **Sun & Moon Letters (الحروف الشمسية والقمرية):** Explaining why `الشمس` sounds like *আশ-শামস* (not *আল-শামস*) while `القمر` sounds like *আল-ক্বামার*.
   - **Verb Conjugation & Root System (الجذر الثلاثي):** Teaching the 3-letter root pattern (`ك-ت-ب`, `ع-م-ل`, `ذ-ه-ب`) intuitively through spoken drills rather than dry grammar tables.
4. **Pure Bangla Phonetic Bridge (`bn_pron`):**
   - Strictly obeys `BnPronScriptPurityTest.kt` (Bangla `0x0980..0x09FF` + ASCII `0x20..0x7E` + `·`).
   - Format: `transliteration · বাংলা উচ্চারণ` (e.g., `as-salaamu 'alaykum · আস-সালামু আলাইকুম`).
5. **High-Impact Bangladeshi Learner Contexts:**
   - **গাল্ফ ও সৌদি প্রবাস (KSA, UAE, Qatar, Kuwait, Oman):** ইকামা (إقامة), কফিল/ম্যানেজার (كفيل / مدير), বেতন-ওভারটাইম (راتب / إضافي), ড্রাইভিং, কনস্ট্রাকশন/ইলেকট্রিক্যাল/হাসপাতাল কাজ, বাসা ভাড়া ও পুলিশ চেকপোস্ট।
   - **হজ্জ ও ওমরাহ (Hajj & Umrah):** মক্কা-মদিনা যাতায়াত, ইহরাম, মসজিদুল হারাম দিকনির্দেশনা, হোটেল, জমজম, হারামাইন হাই-স্পিড ট্রেন ও জরুরি সহায়তা।
   - **ব্যবসা, প্রফেশনাল ও বিশ্ববিদ্যালয়:** দুবাই/রিয়াদ বিজনেস, ইমপোর্ট-এক্সপোর্ট, ইসলামী ও আরবি বিশ্ববিদ্যালয় (আল-আজহার/মদিনা/রিয়াদ) ও দোভাষী।
6. **Strict Isolation from Quran Learning (`qr-`):**
   - Spoken Arabic uses `ar-` item IDs (`ar-std-`, `ar-a2-`, `ar-b1-`, `ar-b2-`, `ar-sp-`) and NEVER triggers `QuranProsodyFormatter` (Tilawat pause rules).

---

## 2. Course Architecture (5 Tiers · 2,560+ Items)

Each tier follows the proven **16 Parts × 4 Lessons × 8 Items = 512 items/tier** structure:

| Tier / Asset File | Prefix & Level | Items | Focus & Exam Alignment |
|---|---|---|---|
| **Standard Arabic (Zero to A1)**<br>`spoken_arabic_standard_a1.json` | `ar-std-` (`A0`/`A1`) | 512 (16×4×8) | Stage 0 Makharij & Harakat Bootcamp (Units 1–2) + Greetings, Numbers, Time, Family, Food, Shopping, Transport, Daily Routine & A1 Oral Review |
| **Elementary Arabic (A2)**<br>`spoken_arabic_elementary_a2.json` | `ar-a2-` (`A2`) | 512 (16×4×8) | Past & Future Tense, Comparisons, Hospital/Clinic, Bank & Remittance, Hotel, Airport, Workplace Tasks, Gulf Everyday Phrases |
| **Intermediate Fluency (B1)**<br>`spoken_arabic_intermediate_b1.json` | `ar-b1-` (`B1`) | 512 (16×4×8) | Conditionals, Opinions, Storytelling, Renting Flat, Telecom/Govt Services (Absher/Baladiya), Job Interviews & Media |
| **Upper-Intermediate (B2)**<br>`spoken_arabic_upper_b2.json` | `ar-b2-` (`B2`) | 512 (16×4×8) | Formal Arabic (Fusha), Debates, Arabic Proverbs (`أمثال`), Economy, Tech, Academic Study & Presentations |
| **Specialist Pro (Gulf, Hajj & Trade)**<br>`spoken_arabic_specialist_pro.json` | `ar-sp-` (`B2`) | 512 (16×4×8) | Hajj & Umrah Complete Guide, Saudi/UAE Work & Driving/Site Terms, Dubai/Riyadh Trade & Contracts, Hospital/Caregiving & Interpreting |

---

## 3. Supporting Study Tools (Matching Flagship Courses)

1. **Arabic Alphabet & Makharij Sound Chart (`ArabicAlphabetData`, `lang = "arabic"`):**
   - 28 letters + Hamza + Ta Marbuta (`ة`) + Harakat (`َ ِ ُ ً ٍ ٌ ْ ّ`), grouped by articulation point (থ্রোট/এমফ্যাটিক/স্ট্যান্ডার্ড) with `0.75x` / `1.0x` audio playback.
2. **Arabic Numbers & Riyal/Dirham Chart (`ArabicNumberData`, `lang = "arabic"`):**
   - Eastern/Western Arabic numerals (`٠–٩` / `0–9`), `١` to `١,٠٠٠,٠٠০`, Riyal/Dirham counting, and telling time (`الساعة`).
3. **Arabic Calendar & Islamic Months Chart (`ArabicCalendarData`, `lang = "arabic"`):**
   - Weekdays (`الأحد–السبت`), Gregorian & Hijri months (`محرم–ذو الحجة`), seasons, and relative days (`اليوم, غداً, أمس`).
4. **1,000+ Daily Arabic Vocabulary Vault (`ArabicVocabData`, `lang = "arabic"`):**
   - 20 categories (`VocabCategory`) with vowelled Arabic + transliteration + Bangla phonetic pronunciation + Bangla meaning.
5. **Live Bangla ↔ Arabic Speech Translator (`TranslatorLanguage.ARABIC`):**
   - Already active in `LiveTranslatorScreen`; enhance `BanglaPronunciationEngine.kt` with any new Gulf/Hajj dictionary entries if needed.

---

## 4. Android Codebase Touchpoints (`ar-` Isolation & `qr-` Safety)

1. **`LearningModels.kt`:**
   - Update `targetLangForId(id)`: map `id.startsWith("qr-") || id.startsWith("ar-") -> SpeechLang.AR`.
2. **`TtsStepEngine.kt`, `MultiLangAudioPlayer.kt` & `LessonQueueBuilder.kt`:**
   - **Critical Fix:** Change `lang == SpeechLang.AR -> QuranProsodyFormatter.formatForTilawat(text)` and `val isQuran = item.id.startsWith("qr-") || targetLang == SpeechLang.AR` so `QuranProsodyFormatter` & Quran ladder rules ONLY apply to `qr-` IDs, NOT to Spoken Arabic (`ar-`)!
   - Keep `ar-SA` / `ar` locale resolution and male voice preference (`preferMale`) clean for spoken Arabic (`0.80f -> 1.1f bn -> 0.94f -> 1.0f`).
3. **`SpeechCheckCard.kt` & `SpeechMatch.kt`:**
   - Map `itemId.startsWith("ar-") -> "ar-SA"`.
   - Normalize Arabic diacritics/Tashkeel (`\u064B-\u065F`, `\u0670`), Alif variants (`أ إ آ -> ا`), and Ta Marbuta (`ة -> ه`) in `SpeechMatch.kt` so learners speaking natural Arabic match cleanly even when STT omits Harakat.
4. **`EscbJsonParser.kt` & `ContentImporter.kt`:**
   - `EscbJsonParser` already maps `"ar"` → `SpeechLang.AR`.
   - Add `needsArabicSpokenMigration` (`dao.getPart("ar-std-01") == null`, etc.) and register all 5 JSON assets in `ContentImporter.ASSET_NAMES`.
5. **`HomeScreen.kt`, `LearnHomeScreen.kt`, `CourseSyllabusScreen.kt`, `PaymentScreen.kt` & `PaymentApprovalScreen.kt`:**
   - Add Home showcase card: `"🇸🇦 আরবি স্পোকেন কোর্স"` (`bundleId = "arabic_course"`, `৳১০০`, separate from `"quran_course"`).
   - Add 5 Course Cards in `LearnHomeScreen` (`ar_standard`, `ar_a2`, `ar_b1`, `ar_b2`, `ar_specialist`) + Study Tool pills (Arabic Alphabet, Numbers, Calendar, Vocab Vault, Live Translator).
   - Add syllabus filters (`ar-std-`, `ar-a2-`, `ar-b1-`, `ar-b2-`, `ar-sp-`) in `CourseSyllabusScreen.kt`.

---

## 5. Execution Roadmap (5 Clean Phases)

| Phase | Scope | Deliverables |
|---|---|---|
| **Phase 1: Engine, `qr-` Isolation, Charts & Vocab** | Kotlin plumbing, STT normalization & study tools | `ar-` routing, `QuranProsodyFormatter` `qr-`-only isolation, `ArabicAlphabetData`, `ArabicNumberData`, `ArabicCalendarData`, `ArabicVocabData` (1,000+ words), `ArabicSupportTest.kt` |
| **Phase 2: Stage 0 + A1 Standard Course (`512` items)** | Generator, verifier & first asset | `android/tools/arabic/build_arabic_a1.mjs`, `verify_arabic_asset.mjs`, `spoken_arabic_standard_a1.json` (16 parts, 64 lessons, 512 items) |
| **Phase 3: UI Showcase, Syllabus & Payment Unlock** | Home card, navigation, syllabus & payment | `HomeScreen.kt` card, `LearnHomeScreen.kt`, `CourseSyllabusScreen.kt`, `PaymentScreen.kt` & `PaymentApprovalScreen.kt` (`"arabic_course"`), `ContentImporter.kt` |
| **Phase 4: A2 Elementary & B1 Intermediate (`1,024` items)** | Elementary + Intermediate spoken assets | `spoken_arabic_elementary_a2.json` + `spoken_arabic_intermediate_b1.json` + UI/Test wiring |
| **Phase 5: B2 Upper-Int & Gulf/Hajj Specialist Pro (`1,024` items)** | Fusha B2 + KSA/UAE/Hajj/Trade Specialist track | `spoken_arabic_upper_b2.json` + `spoken_arabic_specialist_pro.json` + UI/Test wiring |

