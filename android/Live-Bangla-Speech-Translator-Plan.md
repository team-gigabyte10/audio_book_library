# লাইভ বাংলা স্পিচ-টু-টেক্সট ও বহুভাষিক অনুবাদক (Live Bangla-to-Others Speech Translator Plan)

## 1. Vision & Learning Value

Learners across the app's language courses (**English, Japanese, Urdu, Hindi, German, Arabic/Quran, and Bangladeshi Regional Spoken Dialects**) need to say real-world sentences in **Bangla** out loud and instantly see & hear how to say them naturally in the target language—complete with **Bangla phonetic pronunciation (`বাংলা উচ্চারণ ব্রিজ`)**, **word-by-word breakdown**, **native script audio**, and **two-way conversation reply**.

### Already Available Assets in Project (Zero Extra Heavy SDKs Needed!)
- `implementation(libs.firebase.ai)` (`firebase-bom:34.17.0`) is already in [`build.gradle.kts`](file:///e:/Dev_Nayem/audio_book_library/android/app/build.gradle.kts)
- `android.permission.RECORD_AUDIO` & `android.permission.INTERNET` are already declared in [`AndroidManifest.xml`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/AndroidManifest.xml)
- Android `SpeechRecognizer` patterns exist in [`SpeechCheckCard.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/presentation/lesson/SpeechCheckCard.kt) & [`PairPracticeVoiceCard.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/presentation/lesson/PairPracticeVoiceCard.kt)
- Multi-language TTS & voice management exist in [`TtsStepEngine.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/domain/audio/TtsStepEngine.kt) (`EN`, `JA`, `UR`, `HI`, `DE`, `AR`, `BD`, `BN`)
- `OkHttp` & `Moshi` are already bundled for resilient fallback & JSON parsing.

---

## 2. Supported Languages & Modes

| Course Key | Language Name (BN) | Target Locale (STT / TTS) | Script & Special Rendering |
| :--- | :--- | :--- | :--- |
| `english` | ইংরেজি (English) | `en-US` / `SpeechLang.EN` | Latin + Bangla phonetic bridge |
| `japanese` | জাপানি (Japanese) | `ja-JP` / `SpeechLang.JA` | Kanji/Kana + Furigana/Romaji + Bangla pron + `JapaneseVoiceManager` |
| `urdu` | উর্দু (Urdu) | `ur-PK` / `SpeechLang.UR` | Nastaliq RTL (`urduTextStyle`) + Bangla pron |
| `hindi` | হিন্দি (Hindi) | `hi-IN` / `SpeechLang.HI` | Devanagari + Bangla pron |
| `german` | জার্মান (German) | `de-DE` / `SpeechLang.DE` | German Latin + Bangla pron |
| `arabic` | আরবি (Arabic) | `ar-SA` / `SpeechLang.AR` | Arabic RTL (`quranTextStyle`) + Male Voice via `QuranVoiceManager` |
| `regional` | আঞ্চলিক বাংলা (৯ অঞ্চল) | `bn-BD` / `SpeechLang.BD` | Choice of Chatgaiya, Noakhali, Sylhet, Old Dhaka, Barishal, Rajshahi, Rangpur, Khulna, Mymensingh |

### Two Translation Directions
1. **বাংলা ➔ বিদেশি ভাষা (Primary Learning Mode):** Speak in Bangla (`bn-BD`) or type Bangla ➔ see & hear translated sentence + Bangla pronunciation + word breakdown.
2. **বিদেশি ভাষা ➔ বাংলা (Reverse Two-Way Conversation Mode):** Tap the partner's mic in `en-US`/`ja-JP`/`ur-PK`/`hi-IN`/`de-DE`/`ar-SA` ➔ hear & read instant Bangla translation during live real-world conversations!

---

## 3. System Architecture (Streaming STT + 3-Tier Hybrid Translation)

```
┌─────────────────────────────────────────────────────────────┐
│  1. Live Speech Input (StreamingSpeechRecognizer.kt)        │
│     • Android SpeechRecognizer (EXTRA_PARTIAL_RESULTS=true) │
│     • Streams real-time Bangla transcript (`bn-BD`) as spoken│
│     • Emits RMS audio level (0f..1f) for live wave UI       │
│     • Falls back cleanly to Bangla/target keyboard input    │
└──────────────────────────┬──────────────────────────────────┘
                           ▼
┌─────────────────────────────────────────────────────────────┐
│  2. 3-Tier Hybrid Translator (LiveTranslatorRepository.kt)  │
│                                                             │
│  [Tier 1] Offline Room DB & VocabVault Match (0ms, Offline) │
│     • Exact / substring Bangla match in `LearningDao`       │
│     • Returns curated `target`, `bn_pron`, & word `tokens`  │
│                                                             │
│  [Tier 2] Educational AI Translation (`Firebase.ai` Gemini) │
│     • Structured JSON response:                             │
│       - `translatedText` (natural spoken phrasing)          │
│       - `banglaPronunciation` (শুদ্ধ বাংলা উচ্চারণ ব্রিজ)  │
│       - `romanization` (Romaji / IPA / reading aid)         │
│       - `wordBreakdown` ([{word, meaningBn}])               │
│       - `grammarTipBn` (১ লাইনে শিষ্টাচার/ব্যাকরণ টিপস)    │
│                                                             │
│  [Tier 3] Resilient HTTP Fallback (`OkHttp`)                │
│     • If Firebase AI quota/config unavailable online,       │
│       translates text via public HTTPS translation endpoint │
│       and surfaces clean Bangla & target output             │
└──────────────────────────┬──────────────────────────────────┘
                           ▼
┌─────────────────────────────────────────────────────────────┐
│  3. Audio Playback & History                                │
│     • Reuses `BanglaAudiobookApp.lessonAudio` (TtsStepEngine)│
│     • Play Normal (1.0x) / Slow (0.72x) / Tap-a-word audio  │
│     • Auto-speak toggle & local recent history (40 items)   │
└─────────────────────────────────────────────────────────────┘
```

---

## 4. Detailed Phase Breakdown

### Phase 1: Streaming Speech-to-Text & 3-Tier Translation Engine
1. **`TranslatorModels.kt` (`learning/domain/translator/TranslatorModels.kt`):**
   - `TranslatorLanguage` enum (`ENGLISH`, `JAPANESE`, `URDU`, `HINDI`, `GERMAN`, `ARABIC`, `REGIONAL_BANGLA`) mapping route keys, flags, `SpeechLang`, `sttLocaleTag` (`"bn-BD"` / `"ja-JP"` / etc.), and RTL/font metadata.
   - `TranslatorDirection` (`BN_TO_TARGET`, `TARGET_TO_BN`).
   - `TranslationResult`: `sourceText`, `targetText`, `banglaPronunciation`, `romanization`, `wordBreakdown: List<Token>`, `grammarTipBn`, `sourceTier` (`OFFLINE_CURRICULUM`, `AI_TUTOR`, `WEB_FALLBACK`), `timestampMs`.
2. **`StreamingSpeechRecognizer.kt` (`learning/domain/translator/StreamingSpeechRecognizer.kt`):**
   - Lifecycle-safe Flow/callback wrapper around Android `SpeechRecognizer`.
   - Configures `EXTRA_PARTIAL_RESULTS = true`, `EXTRA_LANGUAGE = localeTag`, `EXTRA_MAX_RESULTS = 3`.
   - Emits `SpeechState` (`Idle`, `Listening(partialText, rmsDb)`, `Result(finalText)`, `Error(messageBn, canRetry)`).
   - Automatic `destroy()` cleanup to avoid mic resource leaks across screen navigation.
3. **`LearningDao.kt` Enhancement (Zero Schema Change):**
   - Add read-only query `findByBanglaMatch(idPrefix: String, query: String, limit: Int = 5): List<ItemEntity>` so offline learners get instant curriculum-grade translations & `bn_pron`.
4. **`LiveTranslatorRepository.kt` (`learning/data/translator/LiveTranslatorRepository.kt`):**
   - Implements the 3-tier pipeline (`Offline Curriculum/Vocab` ➔ `Firebase.ai` Gemini 2.5 Flash JSON response ➔ `OkHttp` public translate fallback).
   - Pure JSON parser helper (`parseAiTranslationJson(rawJson)`) extractable & unit-testable without network calls!
   - Handles regional dialects cleanly (allowing user to pick which of the 9 Bangladeshi regions to translate Standard Bangla into, first querying `bd-thm-*` Room items before AI dialect translation).

### Phase 2: ViewModel, Preferences History & Unit Tests
1. **`AppPreferences.kt`:**
   - Persist `learnTranslatorHistoryJson` (up to 40 recent `TranslationResult` entries as compact JSON) and `learnTranslatorAutoSpeak` (`Boolean = true`), `learnTranslatorLastLang` (`String = "english"`).
2. **`LiveTranslatorViewModel.kt` (`learning/presentation/translator/LiveTranslatorViewModel.kt`):**
   - Manages:
     - Selected `TranslatorLanguage`, optional `RegionalDialect` (when `regional` is chosen), `TranslatorDirection` (`BN ➔ Target` or `Target ➔ BN`).
     - Live input text + `StreamingSpeechRecognizer` integration (auto-translates once final speech result arrives!).
     - Loading/result/error state + offline fallback messaging + local similar phrase suggestions if completely offline.
     - Audio playback via `app.lessonAudio` (`TtsStepEngine`): `speakResult(slow = false/true)` and `speakWord(word)`.
     - Recent history list (tap to reload/replay, clear/delete).
3. **Unit Tests (`LiveTranslatorTest.kt`):**
   - Test `TranslatorLanguage` routing & `SpeechLang` / locale tag mapping for all 7 courses.
   - Test `parseAiTranslationJson` with fenced/unfenced JSON outputs, missing optional fields, and malformed fallback safety.
   - Test `LiveTranslatorRepository` offline curriculum match ranking & `AppPreferences` history cap.

### Phase 3: Interactive Live Translator UI & Course Entry Points
1. **`LiveTranslatorScreen.kt` (`learning/presentation/translator/LiveTranslatorScreen.kt`):**
   - **Language & Direction Header:** Scrollable course chips (`🇬🇧 ইংরেজি`, `🇯🇵 জাপানি`, `🇵🇰 উর্দু`, `🇮🇳 হিন্দি`, `🇩🇪 জার্মান`, `🕌 আরবি`, `🇧🇩 আঞ্চলিক বাংলা`) + Swap direction button (`বাংলা ➔ জাপানি` ↔ `জাপানি ➔ বাংলা`).
   - **Live Speech Input Card:**
     - Bangla/source `OutlinedTextField` showing real-time partial speech words while talking + Clear & Paste actions.
     - Animated **Microphone Button + Voice Wave Bars** driven by live `rmsDb`, with concise status indicator (`"শুনছি... বাংলায় বলুন"`).
     - Sample quick-phrase chips tailored to each course (e.g., *"ভাই, এর দাম কত?"*, *"রাস্তাটা কোন দিকে?"*, *"একটু পানি দিন"*).
   - **Rich Translation Result Card:**
     - Native script output (styled with `urduTextStyle` for Urdu, `quranTextStyle` for Arabic RTL).
     - Prominent **বাংলা উচ্চারণ ব্রিজ** box (`bn_pron`) + Romanization.
     - Play Normal (`1.0x`), Slow (`0.72x`), Copy, and Auto-Speak controls.
     - Tappable **`শব্দে শব্দে অর্থ`** (`FlowRow` chips where tapping speaks individual foreign words).
     - **`ব্যাকরণ ও শিষ্টাচার টিপস`** banner explaining politeness/context in Bangla.
     - Source badge (`📚 কোর্স অফলাইন`, `✨ AI শিক্ষক`, or `🌐 লাইভ অনুবাদ`).
   - **Recent History Section:** Clean compact cards for one-tap replay.
2. **Navigation & Course Integration:**
   - Add `Screen.LiveTranslator` (`"learn/translator?lang={lang}"`) in [`Screen.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/presentation/navigation/Screen.kt) & [`AppNavHost.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/presentation/navigation/AppNavHost.kt).
   - Add **Quick Access Entry Points**:
     - [`HomeScreen.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/presentation/home/HomeScreen.kt): Compact showcase banner / top-bar translate button (`"🎙️ লাইভ বাংলা অনুবাদক"`).
     - [`LearnHomeScreen.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/presentation/home/LearnHomeScreen.kt): Course-specific card (`"🎙️ লাইভ অনুবাদক (বাংলা ➔ ইংরেজি/জাপানি/উর্দু/...)"`) pre-selecting that course's language.
     - [`CourseSyllabusScreen.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/presentation/syllabus/CourseSyllabusScreen.kt) & [`LessonScreen.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/presentation/lesson/LessonScreen.kt): Top app bar translate icon opening `LiveTranslator` pre-selected for the active lesson's language.

---

## 5. Implementation Summary & Safety Guarantees
- **Zero Room DB Migration:** Reuses existing `ItemEntity` read queries and stores recent translation history in `AppPreferences`.
- **Zero Impact on Paid Locks / Existing Lessons:** Translator enhances all 7 language courses seamlessly; offline curriculum lookup also respects unlocked/bundled content cleanly.
- **Resilient Offline/Online Behavior:** Always tries instant offline course match first, upgrades to `Firebase.ai` rich educational translation when online, and gracefully falls back to `OkHttp` or friendly offline guidance.
