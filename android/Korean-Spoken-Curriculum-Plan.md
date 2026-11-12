# Spoken Korean Curriculum Plan: Zero to Advanced & EPS-TOPIK / Korea Work & Study Specialist (for Bangla Speakers)

This plan outlines a comprehensive spoken Korean course (**কোরিয়ান স্পোকেন কোর্স: শূন্য থেকে অ্যাডভান্সড ও কোরিয়া প্রবাস**) designed specifically for Bangla speakers. It teaches **Standard Seoul Spoken Korean (표준 한국어)** with natural polite/honorific forms (**해요체 / 하십시오체**) and casual everyday speech (**반말**) so learners can communicate confidently in South Korea for **EPS-TOPIK / factory & shipyard jobs**, **university study (D-2/GKS)**, **travel**, and **business**.

---

## 1. Core Design Principles

1. **Speaking First (말하기 우선):** Every lesson builds active spoken fluency. Hangul (`한국어`) is paired with clean **Bangla phonetic pronunciation (`bn_pron`)** and Romanization (`Revised Romanization`) so learners master natural rhythm, liaison (**연음법칙**), and batchim (**받침**) changes from Day 1.
2. **Leverage What Bangla Already Gives:**
   - **Word Order Match (SOV — Subject + Object + Verb):** Unlike English, Korean and Bangla share the exact **Subject–Object–Verb** sentence order (*আমি ভাত খাই* = `저는 밥을 먹어요` — *আমি · ভাত · খাই*), making sentence construction intuitive for Bangla speakers!
   - **Postpositions Match Particles:** Bangla case endings (*-কে, -তে, -এর, -থেকে*) map directly to Korean particles (`이/가, 을/를, 에/에서, 의, 부터/까지`).
   - **Honorific & Politeness Levels:** Just like Bangla *তুই / তুমি / আপনি*, Korean distinguishes casual (`반말`), polite everyday (`해요체`), and formal (`하십시오체`).
3. **Fix the Hard Points for Bangla Speakers Early:**
   - **Plain vs. Aspirated vs. Tense Consonants (예사소리 / 거센소리 / 된소리):**
     - `ㄱ / ㅋ / ㄲ` (গ-ক / খ / শক্ত ক্ক)
     - `ㄷ / ㅌ / ㄸ` (দ-ত / থ / শক্ত ত্ত)
     - `ㅂ / ㅍ / ㅃ` (ব-প / ফ / শক্ত প্প)
     - `ㅈ / ㅊ / ㅉ` (জ / ছ / শক্ত চ্চ)
     - `ㅅ / ㅆ` (স-শ / শক্ত স্স)
   - **Vowel Distinctions:** `어` (অ) vs `오` (ও), `으` (ঠোঁট গোল না করে ই-উ এর মাঝামাঝি উ) vs `우` (উ), `애 / 에`.
   - **Batchim (받침) & Sound Change Rules (음운 변동):** Teaching why `한국어` sounds like *হানগুগর*, `같이` sounds like *কাছি*, and `감사합니다` sounds like *কামসাহামনিদা* naturally inside spoken drills.
   - **Dual Number Systems:** Sino-Korean (`일, 이, 삼...` for money, minutes, dates, floor, phone) vs. Native Korean (`하나, 둘, 셋...` for age, hours, counting items).
4. **Pure Bangla Phonetic Bridge (`bn_pron`):**
   - Strictly obeys `BnPronScriptPurityTest.kt` (Bangla `0x0980..0x09FF` + ASCII `0x20..0x7E` + `·`).
   - Format: `romanization · বাংলা উচ্চারণ` (e.g., `annyeonghaseyo · আন্নিয়ংহাসেয়ো`).
5. **High-Impact Bangladeshi Learner Contexts:**
   - **কোরিয়া প্রবাস ও EPS-TOPIK (E-9 ভিসা):** কারখানা (공장), নির্মাণ/শিপইয়ার্ড, কৃষি/মৎস্য, ইমিগ্রেশন (출입국관리사무소), ARC কার্ড (외국인등록증), বেতন-ওভারটাইম (월급/잔업/야근), সেফটি নিয়ম ও সুপারভাইজারের সাথে কথা।
   - **উচ্চশিক্ষা ও প্রযুক্তি (D-2 / GKS / IT):** বিশ্ববিদ্যালয় ভর্তি, ডরমিটরি, পার্ট-টাইম জব (알바), ব্যাংক-সিম-হানডা-কাকাওট্যাক্সি ও কোরিয়ান অফিস সংস্কৃতি।
   - **ভ্রমণ, কেনাকাটা ও দৈনন্দিন জীবন:** সিউল মেট্রো/কেটিএক্স, কনভিনিয়েন্স স্টোর (편의점), হালাল খাবার খোঁজা, হাসপাতাল-ফার্মেসি ও ইমারজেন্সি।

---

## 2. Course Architecture (5 Tiers · 2,560 Items)

Each tier follows the proven **16 Parts × 4 Lessons × 8 Items = 512 items/tier** structure:

| Tier / Asset File | Prefix & Level | Items | Focus & Exam Alignment |
|---|---|---|---|
| **Standard Korean (Zero to A1)**<br>`spoken_korean_standard_a1.json` | `ko-std-` (`A0`/`A1`) | 512 (16×4×8) | Stage 0 Hangul & Batchim Bootcamp (Units 1–2) + Greetings, Dual Numbers, Time, Family, Food, Shopping, Subway/Bus, Daily Routine & TOPIK I Level 1 Oral |
| **Elementary Korean (A2)**<br>`spoken_korean_elementary_a2.json` | `ko-a2-` (`A2`) | 512 (16×4×8) | Past/Future Tense, Connectors (`-고, -지만, -서`), Hospital/Pharmacy, Bank & Remittance, Post Office, Restaurant/Halal, Workplace Instructions & TOPIK I Level 2 |
| **Intermediate Fluency (B1)**<br>`spoken_korean_intermediate_b1.json` | `ko-b1-` (`B1`) | 512 (16×4×8) | Honorifics (`-(으)시-`), Indirect Speech, Renting Studio (`원룸` / Jeonse/Wolse), Telecom & Gov24, Job Interviews, Problem Solving & TOPIK II Level 3 |
| **Upper-Intermediate (B2)**<br>`spoken_korean_upper_b2.json` | `ko-b2-` (`B2`) | 512 (16×4×8) | Formal Presentations (`하십시오체`), Debates, Korean Idioms/Proverbs (`속담`), Economy, K-Tech/AI, News/Media & TOPIK II Level 4–5 |
| **Specialist Pro (EPS-TOPIK, Work & Study)**<br>`spoken_korean_specialist_pro.json` | `ko-sp-` (`B2`) | 512 (16×4×8) | EPS-TOPIK Factory/Shipyard/Agriculture Safety & Tools, E-9 Visa/Labor Law/4 Major Insurances, D-2 University & Research, Korea Trade/Tech & Rapid Seoul Slang |

---

## 3. Supporting Study Tools (Matching Flagship Courses)

1. **Korean Hangul & Batchim Sound Chart (`KoreanAlphabetData`, `lang = "korean"`):**
   - 14 Basic Consonants + 5 Double Consonants + 10 Basic Vowels + 11 Compound Vowels + 7 Batchim representative sounds, with `0.75x` / `1.0x` audio playback.
2. **Korean Dual Numbers & Won/Time Chart (`KoreanNumberData`, `lang = "korean"`):**
   - Native Korean (`하나–아흔아홉`), Sino-Korean (`일–억`), counters (`개, 명, 번, 살, 시`), KRW (`원`), and telling time (`시/분`).
3. **Korean Calendar & Seasons Chart (`KoreanCalendarData`, `lang = "korean"`):**
   - Weekdays (`월요일–일요일`), months (`일월–십이월`), 4 seasons (`봄, 여름, 가을, 겨울`), relative days (`오늘, 내일, 어제`), and major holidays (`설날, 추석`).
4. **1,000+ Daily Korean Vocabulary Vault (`KoreanVocabData`, `lang = "korean"`):**
   - 20 categories (`VocabCategory`) covering greetings, verbs, food/halal, factory/tools, safety, office, hospital, transit, and EPS-TOPIK essentials.
5. **Live Bangla ↔ Korean Speech Translator (`TranslatorLanguage.KOREAN`):**
   - Add `TranslatorLanguage.KOREAN` (`ko-KR`) to `LiveTranslatorRepository.kt`, `BanglaPronunciationEngine.kt`, and `StreamingSpeechRecognizer.kt` for real-time Bangla ↔ Korean translation & TTS.

---

## 4. Android Codebase Touchpoints (`ko-` / `SpeechLang.KO`)

1. **`LearningModels.kt`:**
   - Add `KO` to `enum class SpeechLang` (`EN, BN, JA, UR, HI, DE, BD, AR, ZH, KO`).
   - Update `targetLangForId(id)`: map `id.startsWith("ko-") -> SpeechLang.KO`.
2. **`TtsStepEngine.kt`, `MultiLangAudioPlayer.kt` & `LessonQueueBuilder.kt`:**
   - Map `SpeechLang.KO -> Locale.KOREAN` / `"ko-KR"` (`ko`) for TTS locale resolution.
   - Use clean spoken ladder (`0.80f ko -> 1.1f bn -> 0.94f ko -> 1.0f ko`).
3. **`SpeechCheckCard.kt` & `SpeechMatch.kt`:**
   - Map `itemId.startsWith("ko-") -> "ko-KR"`.
   - Normalize Korean whitespace/punctuation and optional particle/number variants in `SpeechMatch.kt` so spoken Hangul matches cleanly.
4. **`EscbJsonParser.kt` & `ContentImporter.kt`:**
   - Map `"ko"` → `SpeechLang.KO` in `EscbJsonParser.kt`.
   - Add `needsKoreanSpokenMigration` (`dao.getPart("ko-std-01") == null`, etc.) and register all 5 JSON assets in `ContentImporter.ASSET_NAMES`.
5. **`HomeScreen.kt`, `LearnHomeScreen.kt`, `CourseSyllabusScreen.kt`, `PaymentScreen.kt` & `PaymentApprovalScreen.kt`:**
   - Add Home showcase card: `"🇰🇷 কোরিয়ান স্পোকেন কোর্স"` (`bundleId = "korean_course"`, `৳১০০`).
   - Add 5 Course Cards in `LearnHomeScreen` (`ko_standard`, `ko_a2`, `ko_b1`, `ko_b2`, `ko_specialist`) + Study Tool pills (Hangul Chart, Dual Numbers, Calendar, Vocab Vault, Live Translator).
   - Add syllabus filters (`ko-std-`, `ko-a2-`, `ko-b1-`, `ko-b2-`, `ko-sp-`) in `CourseSyllabusScreen.kt`.

---

## 5. Execution Roadmap (5 Clean Phases)

| Phase | Scope | Deliverables |
|---|---|---|
| **Phase 1: Engine, Charts, Vocab & Live Translator** | Kotlin plumbing, STT/TTS `ko-KR` & study tools | `SpeechLang.KO`, `ko-` routing, `KoreanAlphabetData`, `KoreanNumberData`, `KoreanCalendarData`, `KoreanVocabData` (1,000+ words), `TranslatorLanguage.KOREAN`, `KoreanSupportTest.kt` |
| **Phase 2: Stage 0 + A1 Standard Course (`512` items)** | Generator, verifier & first asset | `android/tools/korean/build_korean_a1.mjs`, `verify_korean_asset.mjs`, `spoken_korean_standard_a1.json` (16 parts, 64 lessons, 512 items) |
| **Phase 3: UI Showcase, Syllabus & Payment Unlock** | Home card, navigation, syllabus & payment | `HomeScreen.kt` card, `LearnHomeScreen.kt`, `CourseSyllabusScreen.kt`, `PaymentScreen.kt` & `PaymentApprovalScreen.kt` (`"korean_course"`), `ContentImporter.kt` |
| **Phase 4: A2 Elementary & B1 Intermediate (`1,024` items)** | Elementary + Intermediate spoken assets | `spoken_korean_elementary_a2.json` + `spoken_korean_intermediate_b1.json` + UI/Test wiring |
| **Phase 5: B2 Upper-Int & EPS-TOPIK/Korea Specialist Pro (`1,024` items)** | Formal B2 + EPS-TOPIK/Work/Study Specialist track | `spoken_korean_upper_b2.json` + `spoken_korean_specialist_pro.json` + UI/Test wiring |

