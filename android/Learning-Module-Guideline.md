# Learning Module Guideline — Bangla → English / Japanese / Korean / Chinese Spoken Practice (Android + TTS)

This guideline covers three things:

1. **What to teach, in what order:** Parts → Lessons, from beginner to advanced.
2. **How to structure the content:** a data format the app can play, repeat and test.
3. **How to build the app:** the TTS repetition engine, tech stack and content pipeline.


## 1. Core design decisions (read first)

| Decision | Recommendation | Why |
|---|---|---|
| Base language | **Bangla is always the meaning/instruction language.** Every item has `bn` meaning plus a Bangla pronunciation hint (`bn_pron`). | The learner thinks in Bangla. A Bangla pronunciation hint helps learners who cannot read romaji, pinyin or IPA yet. |
| One curriculum, many languages | Build **one master curriculum of "concepts"** (Bangla meaning + intent). Each target language is a separate **course pack** that fills in the concepts. | You write the lesson order once. Japanese, Korean and Chinese reuse it and add only language-specific parts (script, particles, honorifics). |
| Content format | Structured **JSON → prepackaged SQLite (Room)**, not raw markdown in the app. | The app needs to know which word is which, its meaning, speed and tags. Markdown can't carry that. |
| Audio | **Pre-generated neural TTS audio** (cloud) shipped or downloaded per pack. On-device Android TTS is only the fallback. | On-device Bangla, Japanese, Korean and Chinese voices are often missing or low quality on budget phones. Pre-generated audio sounds the same on every device and works offline. |
| Learning method | **Listen → repeat (slow → fast) → meaning → build-up → recall quiz → spaced review.** | Repetition with increasing speed builds recognition first, then fluency. Spaced review moves words into long-term memory. |
| Sentence building | Every sentence pattern is a **frame** with 5 forms: affirmative, negative, yes/no question, WH question, and tense variants. | This matches your goal (Assertive / Interrogative / Affirmative / Negative / WH / Tenses). The app can generate drills from it automatically. |

### Bangla word order

Bangla is **SOV** (subject-object-verb), the same as **Japanese and Korean**:

| Bangla | আমি | ভাত | খাই |
|---|---|---|---|
| Japanese | 私は (watashi wa) | ご飯を (gohan o) | 食べます (tabemasu) |
| Korean | 저는 (jeoneun) | 밥을 (babeul) | 먹어요 (meogeoyo) |
| English | I | eat | rice |
| Chinese | 我 (wǒ) | 吃 (chī) | 饭 (fàn) |

For Japanese and Korean, the word-by-word Bangla gloss lines up one-to-one. Use this: show it as an advantage in the lessons. English and Chinese are **SVO**, so their lessons need a "word order swap" explanation. The ESCB grammar section already explains this in Bangla.

---

## 2. Curriculum: Parts and Lessons (Beginner → Advanced)

Levels: **A0** (absolute beginner) → **A1** → **A2** → **B1** → **B2** (upper intermediate / fluent speaking).
Each Part has 8–20 lessons. Each lesson has **5–10 new items** and takes about 10–15 minutes.

### Part 0 — Script & Sounds (A0)
Teach letters with pronunciation before words.

| Language | Lessons |
|---|---|
| English | A–Z names; letter **sounds** (phonics: a = অ্যা, b = ব…); short/long vowels; difficult sounds for Bangla speakers (v/w/f/z/th, "sh" vs "s"); silent letters; word stress |
| Japanese | Hiragana (46 + dakuten), Katakana, long vowels, small っ/ゃゅょ, pitch basics. *(Kanji are introduced gradually from Part 1, never as a block.)* |
| Korean | Hangul consonants (ㄱ ㄴ ㄷ…), vowels, syllable blocks, batchim (final consonants), sound-change rules |
| Chinese | Pinyin initials/finals, **4 tones + neutral tone** (drill tones heavily), tone pairs, then the first 50 characters/radicals |

Item type: `letter` (character, name, sound, example word, bn_pron). Playback: letter → sound → example word.

### Part 1 — First Words (A0–A1)
Single words grouped by theme: numbers, family, body, food, colors, days and time, common verbs (eat, go, come, see…), pronouns (I/you/he/she/we/they).
Pronouns and 20–30 core verbs come first because every sentence pattern in Parts 3–4 needs them.

### Part 2 — Survival Phrases (A1)
Greetings, thanks and sorry, introducing yourself, yes/no, "I don't understand", asking prices and directions.
Source: ESCB **Common English Expressions** and **Face to Face Communication**.

### Part 3 — Sentence Building (A1–A2), the core of the course
Build each sentence type step by step, always with the Bangla meaning.

| Lesson block | Form | Example (English) | Bangla |
|---|---|---|---|
| 3.1 Assertive – Affirmative | S + V + O | I eat rice. | আমি ভাত খাই। |
| 3.2 Assertive – Negative | S + do not + V + O | I do not eat rice. | আমি ভাত খাই না। |
| 3.3 Interrogative – Yes/No | Do + S + V + O? | Do you eat rice? | তুমি কি ভাত খাও? |
| 3.4 Interrogative – Negative | Don't + S + V + O? | Don't you eat rice? | তুমি কি ভাত খাও না? |
| 3.5 WH Questions | WH + do + S + V? | What do you eat? | তুমি কী খাও? |
| 3.6 Imperative | V + O | Eat rice. / Don't eat rice. | ভাত খাও। / ভাত খেও না। |
| 3.7 Exclamatory | What a…! / How…! | What a beautiful day! | কী সুন্দর দিন! |
| 3.8 "To be" sentences | S + am/is/are + N/Adj | She is a doctor. | সে একজন ডাক্তার। |
| 3.9 There is / there are, have/has | | There is a book. | একটি বই আছে। |

WH order (as in ESCB): What → When → Where → Who → Whom → Which → Whose → Why → How (+ How much / How many / How long).

Each lesson uses a **sentence ladder**, going from short to long sentences:
```
eat → I eat → I eat rice → I eat rice every day → I eat rice with my family every day
খাই → আমি খাই → আমি ভাত খাই → আমি প্রতিদিন ভাত খাই → আমি প্রতিদিন আমার পরিবারের সাথে ভাত খাই
```

### Part 4 — Tenses (A2–B1)
Each tense lesson drills **all 5 forms** (affirmative, negative, yes/no, WH, negative question) with the same verb set.

| English (12 tenses — ESCB order) | Japanese equivalent | Korean equivalent | Chinese equivalent |
|---|---|---|---|
| Present simple | ます / dictionary form | -아요/어요 | V (no change) |
| Present continuous | ～ています | -고 있어요 | 在/正在 + V |
| Present perfect | ～たことがある / もう～た | -아/어 봤어요, 이미… | V + 过 / V + 了 |
| Present perfect continuous | ～ています (+ duration) | -고 있어요 (+ duration) | 一直 + V + 了 |
| Past simple | ～ました / ～た | -았/었어요 | V + 了 |
| Past continuous | ～ていました | -고 있었어요 | 那时在 + V |
| Past perfect / perf. cont. | ～ていました / もう～ていた | -았/었었어요 | 已经 + V + 了 |
| Future simple | ～ます (+ time word) / ～つもり | -(으)ㄹ 거예요 | 会/要/将 + V |
| Future continuous / perfect | ～ているでしょう | -고 있을 거예요 | 将会 + V |

> Rule: **don't force the 12 English tenses onto Japanese, Korean or Chinese.** Use the master curriculum's *meaning* ("I have eaten" = আমি খেয়েছি) and let each language pack express it naturally. The table only shows which lesson each concept falls into.

Language-specific Part 4 add-ons:
- **Japanese:** polite (です/ます) vs plain form, particles は/が/を/に/で, counters.
- **Korean:** speech levels (해요체 first, then 합니다체 and 반말), particles 은/는, 이/가, 을/를.
- **Chinese:** measure words (个/本/只…), 不 vs 没 negation, 吗 / 呢 questions, sentence-final 了.

### Part 5 — Grammar Extensions (B1)
Passive voice, modal verbs (can/could/may/must/should), conditionals (zero/1st/2nd/3rd), comparatives and superlatives, countable vs uncountable nouns, do vs make, possessives, gerund vs infinitive.
Source: ESCB **English Basic Grammar** (p. 6–69) and **Written English Rules** (p. 70–89).

### Part 6 — Spoken Patterns (B1–B2)
Each ESCB **Spoken Rule** becomes one lesson: 1 structure + 5–8 example sentences + Bangla.
Examples: *Having a hard time + V-ing*, *Would you mind + V-ing?*, *It is high time + S + V(past)*, *Besides + V-ing*.
Group them into themes (requests, opinions, obligation, possibility, regret, habits) instead of numeric order 1–300+, and put easier patterns first.

### Part 7 — Vocabulary Expansion (B1–B2)
ESCB **English Vocabulary** (p. 326–557) and **Business Words** (p. 90–108) tables are already in the format *Word | Bangla | Example sentence*. Split them into themed sets of about 10 words per lesson.

### Part 8 — Translation Practice (B1–B2)
ESCB **English to Bangla Translate** (p. 558–933) has thousands of EN↔BN sentence pairs. Use them for:
- **Bangla → speak target** drills (show the Bangla; the learner speaks; the app plays the answer).
- Listening dictation.

### Part 9 — Real Conversations (B2)
Dialogues: shopping, doctor, office, travel, phone calls (from **Face to Face Communication**, p. 984–1078). Then the **Interview Q&A** section (p. 934–983) for job-interview speaking.

### Lesson template (every lesson follows this)
1. **Intro** (Bangla): what you'll learn, plus 1 structure formula.
2. **New items**: for each item, the playback ladder (Section 4) with word-by-word gloss.
3. **Build-up**: the sentence ladder from short to long.
4. **Pattern drill**: change one slot (subject, verb, tense or form). For example, *I eat → He eats → Does he eat? → What does he eat?*
5. **Speak**: show the Bangla, the learner says it aloud, then the app plays the answer. Optionally check with speech recognition.
6. **Quiz**: listen → pick the Bangla meaning; Bangla → pick the sentence; arrange words in order; fill the blank.
7. **Review**: due items from the spaced-repetition queue.

---

## 3. Content data format

### Hierarchy
```
Course (target_lang: en | ja | ko | zh)
 └─ Part (order, level, title_bn, title_target)
     └─ Lesson (order, title_bn, intro_bn, structure)
         └─ Item (letter | word | phrase | sentence | pattern | dialogue_line)
```

### Item schema (JSON)
```json
{
  "id": "ja-p3-l01-003",
  "concept_id": "c-eat-rice-affirm",
  "type": "sentence",
  "level": "A1",
  "target": "私はご飯を食べます。",
  "romanization": "watashi wa gohan o tabemasu",
  "bn": "আমি ভাত খাই।",
  "bn_pron": "ওয়াতাশি ওয়া গোহান ও তাবেমাস",
  "tokens": [
    { "t": "私",     "r": "watashi", "bn": "আমি" },
    { "t": "は",     "r": "wa",      "bn": "(বিষয় চিহ্ন)" },
    { "t": "ご飯",   "r": "gohan",   "bn": "ভাত" },
    { "t": "を",     "r": "o",       "bn": "(কর্ম চিহ্ন)" },
    { "t": "食べます", "r": "tabemasu", "bn": "খাই" }
  ],
  "tags": { "sentence_type": "assertive", "polarity": "affirmative", "tense": "present_simple", "politeness": "polite" },
  "pattern_id": "S-O-V-masu",
  "audio": { "slow": "ja/p3/l01/003_s.opus", "normal": "ja/p3/l01/003_n.opus", "bn": "bn/c-eat-rice-affirm.opus" },
  "source": "ESCB p.12"
}
```

Field rules:
- `concept_id` links the same meaning across languages (EN, JA, KO and ZH items share it). The Bangla audio is generated once per concept.
- `tokens` drive word-by-word playback and the "arrange the words" quiz. For English, split on spaces. For Japanese, Chinese and Korean, use a tokenizer and then fix by hand.
- `tags` let the app filter: *"all WH questions in past tense"*.
- `bn_pron` is optional for advanced levels; learners turn it off once they can read the script.

### Pattern frame (for automatic drill generation)
```json
{
  "pattern_id": "en-present-simple",
  "slots": { "S": ["I","You","He","She","We","They"], "V": ["eat","go","read"], "O": ["rice","to school","a book"] },
  "forms": {
    "affirmative": "{S} {V.s} {O}.",
    "negative":    "{S} {do} not {V} {O}.",
    "yes_no":      "{Do} {S} {V} {O}?",
    "wh":          "What {do} {S} {V}?"
  }
}
```
Generated sentences **must be reviewed by a person**, and in particular the Bangla verb forms (খাই/খাও/খায়/খান). Generate them at authoring time, never on the device.

---

## 4. TTS playback & repetition engine

### The repetition ladder (default; user-adjustable)
For each item:

```
1. target  @ 0.6x   (slow, clear)
2. bn meaning @ 1.0x
3. target  @ 0.6x
4. target  @ 0.8x
5. target  @ 1.0x
6. target  @ 1.2x   (fast, native-like)  ← optional, unlocked at B1+
   pause 1.5 s (learner repeats aloud — "shadowing gap")
```

**Word-by-word mode** (for sentences): play each token as *target → bn*, then build up cumulatively (`I` → `I eat` → `I eat rice`), then run the full sentence through the ladder above.

User settings: repetitions per speed, which speeds to use, gap length, Bangla on/off, auto-advance, loop the lesson, and a sleep timer (for listening in bed).

### Audio strategy
| Option | Quality | Offline | Cost | Use for |
|---|---|---|---|---|
| **Pre-generated cloud neural TTS** (Google Cloud TTS / Azure Neural TTS, both support `bn-BD`, `en-US`, `ja-JP`, `ko-KR`, `zh-CN`) | Excellent, consistent | ✅ | One-time generation cost | **Primary** |
| Android `TextToSpeech` on device | Varies by phone; Bangla voice often missing | ✅ if voice installed | Free | Fallback, user-typed text |
| Human recordings | Best | ✅ | Expensive | Part 0 letters/tones (optional upgrade) |

- **Slow speed:** generate a separate slow file using SSML `<prosody rate="slow">` (around 0.6–0.7). Stretching normal audio to 0.6x with the player sounds robotic.
- **0.8x–1.2x:** use the player's `setPlaybackSpeed()` on the normal file; pitch is preserved.
- **On-device fallback:** `TextToSpeech.setSpeechRate()` and `setLanguage(Locale("bn","BD"))`. Check `isLanguageAvailable()`, and if the voice is missing, open the system install-voice screen (`ACTION_INSTALL_TTS_DATA`).
- **Format:** Opus/OGG at 24–32 kbps mono. 10,000 clips is roughly 100–150 MB, so ship Part 0–2 in the APK and download the other Parts on demand.

### Spaced repetition
Use **FSRS** (or SM-2 if you want something simpler) per item. Grade from the quiz result: wrong = Again, slow correct = Hard, correct = Good, instant = Easy. The **Review** tab plays due items through the same ladder.

---

## 5. Android app architecture

| Layer | Choice |
|---|---|
| Language/UI | Kotlin + Jetpack Compose (Material 3) |
| Content DB | Room, prepackaged with `createFromAsset("content_ja.db")`, one DB per language pack, plus a separate user-progress DB |
| Audio | **Media3 ExoPlayer** + `MediaSessionService` (foreground service, so playback continues with the screen off and works with lock-screen and Bluetooth controls) |
| Fallback TTS | `android.speech.tts.TextToSpeech` |
| Speech check (optional) | `SpeechRecognizer` with the target locale to compare the learner's speech to the sentence |
| Settings | DataStore |
| Pack downloads | WorkManager + checksum validation |
| DI / structure | Hilt; modules `:content`, `:player`, `:srs`, `:feature-lesson`, `:feature-review` |

Main screens: **Home** (choose language, continue lesson, daily goal) → **Course map** (Parts → Lessons with progress) → **Lesson player** (ladder playback, text shows target, romanization, Bangla and word gloss) → **Quiz** → **Review** → **Settings** (speeds, repetitions, show/hide romanization or `bn_pron`).

The player is a **queue of steps**. A step is `(audio source, speed, display text, pause after)`. The lesson builder turns items plus ladder settings into this queue, and ExoPlayer plays it. This keeps the playback logic simple and testable.

---

## 6. Content pipeline: from your MD file to app content

### Step 1 — Finish text extraction
The md file still has **garbled Bangla** in the vocabulary and translation tables (about p. 326 onward), because the PDF's text layer is broken there. Run OCR on those pages as well (Tesseract `ben+eng` is already installed) before extracting.

### Step 2 — Map ESCB sections to Parts

| ESCB section (PDF pages) | Goes to | Item type |
|---|---|---|
| English Basic Grammar — tenses, WH, comparatives, nouns (6–69) | Part 3, 4, 5 | sentence + pattern |
| Written English Rules (70–89) | Part 5 | pattern |
| Business Words (90–108) | Part 7 | word + example |
| English Spoken Rules 1–300+ (109–325) | Part 6 | pattern + sentence |
| English Vocabulary (326–557) | Part 1 (easy words), Part 7 | word + example |
| English to Bangla Translate (558–933) | Part 8 (+ examples for Parts 3–4) | sentence |
| Interview Q&A (934–983) | Part 9 | dialogue |
| Face to Face Communication (984–1078) | Part 2, Part 9 | phrase / dialogue |
| Common English Expressions (1079–1183) | Part 2 | phrase |
| *Not in ESCB:* alphabet/phonics, kana, Hangul, pinyin/tones | Part 0 | **new content needed** |

### Step 3 — Extract to a review sheet
A Python script turns each section into rows in a spreadsheet (CSV / Google Sheets) with these columns:
`part | lesson | order | type | en | bn | tags | source_page | status`
Vocabulary tables are already 3 columns (word | bn | example), so they convert almost directly. Spoken Rules split as `## Structure` → pattern, followed by `- English` + Bangla line pairs. Translation pages are `English sentence + Bangla sentence` pairs and need sentence splitting.

### Step 4 — Human review (the most important step)
Fix OCR errors, check that each Bangla meaning is natural, assign level and tags, and remove duplicates. **Don't skip this step:** learners memorize every error.

### Step 5 — Add Japanese, Korean and Chinese
1. For each reviewed concept (`bn` + `en`), generate the target sentence with an LLM. Prompt: *natural, polite, beginner-level, keep meaning of the Bangla*.
2. Add romanization automatically: `pykakasi` / `cutlet` (Japanese), `pypinyin` with tone marks (Chinese), `korean-romanizer` (Korean).
3. Add tokens: `fugashi`/MeCab (Japanese), `jieba` (Chinese), spacing plus particle split (Korean).
4. Generate `bn_pron` from the romanization using a rule table (e.g. *ka → কা, tsu → ৎসু, shi → শি*), then fix it by hand.
5. **Have a native speaker review** each language at least for Parts 0–4.

### Step 6 — Build and generate
- A script validates the JSON (required fields, unique ids, tokens joining back to the sentence) and builds `content_<lang>.db`.
- A script generates audio: for each item, the slow and normal target files plus the Bangla meaning (once per concept). It hashes the text so unchanged items aren't regenerated.

### Suggested repo layout
```
content/
  master/            concepts.csv (bn + en, reviewed)
  en/ ja/ ko/ zh/    parts/*.json  (per-language items)
  patterns/          pattern frames
tools/
  extract_escb.py    md → review CSV
  translate.py       concepts → ja/ko/zh drafts
  romanize.py, tokenize.py, bn_pron.py
  validate.py, build_db.py, gen_audio.py
app/                 Android project
```

---

## 7. Roadmap

| Phase | Scope | Result |
|---|---|---|
| **1. MVP (English)** | Parts 0–3, about 40 lessons; ladder player; quiz; progress | Usable app with ESCB content; tests the method |
| 2 | English Parts 4–6 + spaced review + background playback | Full English course core |
| 3 | Japanese pack (Parts 0–4) + native review | First non-English language; tests the multi-language model |
| 4 | Korean + Chinese packs | Multi-language |
| 5 | Parts 7–9, speech-recognition check, streaks and daily goals | Advanced learners, retention |

**Start with English.** The ESCB content is English↔Bangla, so you can ship English first with your own material. That proves the lesson format and player before you invest in translating three more languages.

---

## 8. Quality checklist per lesson
- [ ] 5–10 new items; each new word is used again in at least 2 sentences in the same Part
- [ ] Every item has target, Bangla meaning and audio (slow + normal); romanization for JA/KO/ZH
- [ ] Sentence forms cover affirmative, negative, yes/no, WH for the lesson's structure
- [ ] The sentence ladder goes from short to long
- [ ] No unreviewed OCR or machine-translated text
- [ ] Audio checked by ear at 0.6x and 1.0x
