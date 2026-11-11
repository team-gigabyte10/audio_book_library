# বিভাগীয় আঞ্চলিক ভাষা স্পোকেন কোর্স: Sentence-by-Sentence Multi-Region Rearrangement Plan

## 1. Objective & Problem Statement

Currently, **বিভাগীয় আঞ্চলিক ভাষা স্পোকেন কোর্স (`bd-*`)** in [`spoken_bangla_regional_divisions.json`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/assets/spoken_bangla_regional_divisions.json) is organized in **regional silos** (`Part 1 = Chattogram`, `Part 4 = Sylhet`, `Part 5 = Dhaka`, etc.), where each region covers different unrelated sentences.

As a result, a learner cannot easily compare how **the exact same daily sentence** (e.g., *"আপনি কেমন আছেন?"*, *"ভাত খেয়েছেন?"*, *"এর দাম কত?"*) is spoken across all regions of Bangladesh together.

### Target Experience
Rearrange the entire course so **every Standard Bangla sentence brings all regional dialects together side-by-side**:
- Organized into **Thematic Real-Life Situations** (Greetings, Family, Food & Hospitality, Market, Travel, Emotions, Daily Work, Cultural Proverbs).
- Inside every lesson, each core sentence (`concept_id`) groups **all 9 authentic regional versions together** in a consistent order, playable sequentially in one unified comparative audio flow and viewable side-by-side inside a comparison card.

---

## 2. Canonical 9-Region Dialect Roster

Every shared Standard Bangla sentence will include all 9 major regional varieties across the 8 divisions (keeping Chattogram's two distinct major dialects — **Chatgaiya** and **Noakhali** — alongside the other 7 divisions):

| Order | Region Key (`region`) | Display Badge (`speaker`) | Characteristic Speech Feature |
| :---: | :--- | :--- | :--- |
| 1 | `ctg` | `🏔️ চট্টগ্রাম (চাটগাঁইয়া)` | `আঁই / অন / গম আছি / হঁদে / গরন` |
| 2 | `noa` | `🌾 নোয়াখালী (নোয়াখাইল্লা)` | `আঁই / আন্নে / বেবাক / হানি / কনে` ('প' ➔ 'হ') |
| 3 | `syl` | `🍵 সিলেট (সিলেটি)` | `আমি / আফনে / ভালা আছইন নি / কিতা / ফুয়া` |
| 4 | `dhk` | `🏙️ ঢাকা (পুরান ঢাকাইয়া)` | `ভাইজান / কেমুন আছেন / কই থাকেন / আরে মিয়া` |
| 5 | `bar` | `⛵ বরিশাল (বরিশাইল্লা)` | `মোরা / আপনে / মনু / কি হরেন / হেইয়া` |
| 6 | `raj` | `🥭 রাজশাহী (বরেন্দ্রী)` | `হামি / আপনে / লেন / কোথে / বাহে` |
| 7 | `rng` | `🪕 রংপুর (রংপুরিয়া)` | `বাহে / মুই / কেমন আচেন / কোনঠে` |
| 8 | `khl` | `🌿 খুলনা-যশোর` | `আপনি / কেমন আছেন ভাই / কোথায় যাচ্ছেন / চুইঝাল` |
| 9 | `mym` | `🌊 ময়মনসিংহ` | `আফনে / কই থাহেন / কিবা কইরা / ছ্যামড়া` |

---

## 3. Rearranged Thematic Curriculum (8 Parts × 4 Lessons = 32 Comparative Lessons)

Instead of 10 division-siloed parts, the course is reorganized into **8 Thematic Conversational Parts** (`bd-thm-01` .. `bd-thm-08`). Each lesson focuses on **2 shared core sentences** across all 9 regions (**18 comparative items per lesson**, or **36 sentences × 9 regions = 324+ aligned items**, plus proverbs):

1. **Part 1 (`bd-thm-01`): কুশল বিনিময় ও পরিচিতি (Greetings & Identity)**
   - Lesson 1: আপনি কেমন আছেন? / আমি আলহামদুলিল্লাহ ভালো আছি
   - Lesson 2: আপনার বাড়ি কোথায়? / আপনার নাম কী ও কী কাজ করেন?
   - Lesson 3: অনেক দিন পর দেখা হলো / আজ আমার মন ভালো নেই
   - Lesson 4: একটু বসুন, চা খেয়ে যান / বাড়ির সবাই ভালো আছে তো?

2. **Part 2 (`bd-thm-02`): পরিবার, সন্তান ও আত্মীয়তা (Family & Kinship)**
   - Lesson 1: বাবা-মা বাড়িতে আছেন কি? / আপনার ছেলে/মেয়ে কোথায় গেছে?
   - Lesson 2: সে সকালে স্কুলে গেছে / বাচ্চারা বাইরে খেলাধুলা করছে
   - Lesson 3: বড়দের কথা শুনতে হয় / আমার সাথে মিথ্যা বলবেন না
   - Lesson 4: ভাই-বোন সবাই একসাথে আছি / গ্রামে ঈদ করতে যাব

3. **Part 3 (`bd-thm-03`): খাবার, মেহমানদারি ও আতিথেয়তা (Food & Hospitality)**
   - Lesson 1: সকালে ভাত খেয়েছেন তো? / আমি এখন ভাত খাব না
   - Lesson 2: একটু ঠান্ডা পানি দিন তো ভাই / চা বানিয়ে আনছি
   - Lesson 3: আজ আপনার জন্য মাংস/মাছ রান্না করব / খাবারটা খুব সুস্বাদু হয়েছে
   - Lesson 4: আমাদের বাড়িতে মেহমান হয়ে আসবেন / পেট ভরে খেয়ে নিন

4. **Part 4 (`bd-thm-04`): হাট-বাজার ও দরদাম (Market & Bargaining)**
   - Lesson 1: ভাই, এর দাম কত রাখবেন? / এত দাম কেন, একটু কমান না
   - Lesson 2: আজকে তাজা মাছ ও শাকসবজি আছে? / ভালো জিনিসটা বেছে দিন
   - Lesson 3: এক কেজি ওজন করে দিন / আমার কাছে খুচরা টাকা নেই
   - Lesson 4: টাকাটা গুনে নিন / আগামীকাল আবার বাজারে আসব

5. **Part 5 (`bd-thm-05`): যাতায়াত, রাস্তা ও সময় (Travel & Directions)**
   - Lesson 1: বাজারে বা স্টেশনে কীভাবে যাব? / এখান থেকে যেতে কতক্ষণ লাগবে?
   - Lesson 2: রিকশা/অটো ভাড়া কত নেবেন? / ভাই, একটু সামনে গিয়ে থামুন
   - Lesson 3: রাস্তায় আজ প্রচণ্ড জ্যাম ও ভিড় / তাড়াতাড়ি চলুন, দেরি হয়ে যাচ্ছে
   - Lesson 4: আমি রাস্তাটা চিনতে পারছি না / ডান দিকে মোড় নিয়ে সোজা যান

6. **Part 6 (`bd-thm-06`): অনুভূতি, অনুরোধ ও দৈনন্দিন আড্ডা (Emotions & Everyday Talk)**
   - Lesson 1: কেন এত দেরি করলেন? / আমাকে একটু সাহায্য করুন
   - Lesson 2: রাগ করবেন না, আমার কথাটা শুনুন / চিন্তা করবেন না, সব ঠিক হয়ে যাবে
   - Lesson 3: এই কাজটা এখনই শেষ করতে হবে / আমার এখন খুব ব্যস্ততা যাচ্ছে
   - Lesson 4: কথাটা কাউকে বলবেন না / সত্যি কথা বলতে আমার খুব ভালো লাগল

7. **Part 7 (`bd-thm-07`): আবহাওয়া, কৃষি, প্রবাস ও কাজ (Weather, Work & Daily Life)**
   - Lesson 1: আজকে বাইরে খুব রোদ ও গরম / মনে হচ্ছে বৃষ্টি নামবে
   - Lesson 2: সকাল থেকে একটানা কাজ করছি / এখন একটু বিশ্রাম নেব
   - Lesson 3: সন্ধ্যার আগেই বাড়ি ফিরে আসব / রাতে তাড়াতাড়ি ঘুমাতে হবে
   - Lesson 4: বিদেশ থেকে ভাই ফোন করেছে / দেশে ফিরলে দেখা হবে ইনশাআল্লাহ

8. **Part 8 (`bd-thm-08`): প্রবাদ-প্রবচন, বাগধারা ও আঞ্চলিক মেজাজ (Regional Proverbs & Gems)**
   - Lesson 1: পরিশ্রম ও ধৈর্যের আঞ্চলিক প্রবাদ (৯ অঞ্চল)
   - Lesson 2: বুদ্ধিমত্তা ও সতর্কতার প্রবাদ (৯ অঞ্চল)
   - Lesson 3: ভালোবাসা, বন্ধুত্ব ও আতিথেয়তার ঐতিহ্যবাহী কথা (৯ অঞ্চল)
   - Lesson 4: মজার কথ্য বুলি ও ঐতিহ্যবাহী লোকবচন (৯ অঞ্চল)

---

## 4. Technical Architecture (Zero Room DB Migration Required!)

The existing Room schema (`ItemEntity` in [`LearningEntities.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/data/db/LearningEntities.kt) & [`EscbJsonParser.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/data/content/EscbJsonParser.kt)) **already contains** the exact fields we need without bumping DB version:

- **`conceptId`** (already indexed in `ItemEntity`): Shared across all 9 regional variants of the *same* Standard Bangla sentence!
  - Example: `"c-bd-how-are-you"` links all 9 variants (`bd-thm-01-l01-001` through `bd-thm-01-l01-009`).
- **`speaker`**: Stores the Region Label Badge (`"🏔️ চট্টগ্রাম (চাটগাঁইয়া)"`, `"🌾 নোয়াখালী"`, `"🍵 সিলেট"`, etc.).
- **`bn`**: Shared Standard Bangla meaning (`"আপনি কেমন আছেন?"`).
- **`target`**: Regional spoken script (`"অন কেমন আছন?"`).
- **`bnPron`**: Clear phonetic guide for learners from other regions (`"অন্ কেমন্ আছন্?"`).
- **`tokens`**: Word-by-word regional-to-Standard-Bangla glosses (`t("অন", "আপনি")`, `t("গম", "ভালো")`).

---

## 5. Audio & Lesson Player Behavior

### Comparative Audio Flow ([`LessonQueueBuilder.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/domain/ladder/LessonQueueBuilder.kt))
Repeating *"আপনি কেমন আছেন?"* in Standard Bangla 9 consecutive times after every single dialect becomes repetitive when listening continuously. Instead, for grouped `bd-*` items sharing a `conceptId`:
1. **First item of a `conceptId` group:**
   - Plays Standard Bangla prompt (`bn`: `"আপনি কেমন আছেন?"`) ➔ plays Region 1 dialect (`"চট্টগ্রাম: অন কেমন আছন?"` or directly the dialect phrase with clear pacing).
2. **Items 2..9 of the SAME `conceptId` group:**
   - Plays a brief pause (`400ms`), then speaks the next regional speech directly (e.g., `"আন্নে কেমন আছেন?"` ➔ `"আফনে ভালা আছইন নি?"` ➔ `"কেমুন আছেন ভাইজান?"` ...), optionally skipping the repeated Standard Bangla translation unless the learner toggles `"প্রতিবার প্রমিত অর্থ শুনুন"` ON!
3. **Between different `conceptId` groups:**
   - Plays the full reflection gap (`1500ms`) and introduces the next sentence with its Standard Bangla prompt.

---

## 6. Side-by-Side Comparison UI ([`LessonScreen.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/presentation/lesson/LessonScreen.kt))

When `viewModel.isRegionalBangla` is true:
1. **Shared Sentence Master Header (Top of Card):**
   - Displays **`"প্রমিত বাংলা: আপনি কেমন আছেন?"`** prominently inside an emerald banner with a group progress pill (e.g. **`বাক্য ১/২ · অঞ্চল ৩/৯`**).
2. **Active Dialect Spotlight:**
   - Highlights the currently playing region badge (`item.speaker`), large regional text (`item.target`), pronunciation hint (`item.bnPron`), and tap-to-hear word tokens.
3. **"সকল অঞ্চলে একই বাক্য (৯টি অঞ্চল পাশাপাশি)" Comparison Panel:**
   - Lists all items in `content.items` sharing the same `conceptId` right inside a compact, clean card below the main spotlight:
     - Shows each region's pill (`চট্টগ্রাম`, `নোয়াখালী`, `সিলেট`, `ঢাকা`, `বরিশাল`, `রাজশাহী`, `রংপুর`, `খুলনা`, `ময়মনসিংহ`) alongside its regional sentence (`"অন কেমন আছন?"`, `"আন্নে কেমন আছেন?"`, etc.).
     - The currently playing region row is highlighted with an active green border + equalizer/speaker icon.
     - **Interactive Tap:** Tapping any region row speaks that region's sentence immediately AND optionally jumps playback to that region!

---

## 7. Implementation Roadmap (3 Phases)

| Phase | Scope | Files Involved |
| :--- | :--- | :--- |
| **Phase 1: Content & Generator Rearrangement** | Rewrite generators into 8 thematic parallel files (`p1_greetings_family.py`, `p2_food_market.py`, `p3_travel_emotions.py`, `p4_weather_proverbs.py`); ensure every `concept_id` covers all 9 regions cleanly; update `build_regional_bangla_course.py`, `verify_regional_course.py`, and recompile `spoken_bangla_regional_divisions.json`. | `android/tools/regional_bangla/...`, `android/app/src/main/assets/spoken_bangla_regional_divisions.json` |
| **Phase 2: Comparative Queue & DB Migration** | Update `LessonQueueBuilder.kt` for grouped `conceptId` playback (avoiding redundant BN repeats across 9 dialects of the same sentence); update `ContentImporter.kt` (`needsRegionalBanglaMigration` checking `bd-thm-01` & `bd-thm-08` so existing installs auto-migrate cleanly). | `LessonQueueBuilder.kt`, `ContentImporter.kt`, `LessonViewModel.kt` |
| **Phase 3: Side-by-Side Comparison UI, Syllabus & Tests** | Add the `"সকল অঞ্চলে একই বাক্য"` 9-region comparison list & active-region highlighting to `LessonScreen.kt`; update `CourseSyllabusScreen.kt` / `LearnHomeScreen.kt` / `HomeScreen.kt` descriptions & stats; add unit tests in `RegionalBanglaSupportTest.kt` verifying all `conceptId`s contain all 9 regions and comparative queue generation works cleanly. | `LessonScreen.kt`, `CourseSyllabusScreen.kt`, `LearnHomeScreen.kt`, `HomeScreen.kt`, `RegionalBanglaSupportTest.kt` |

