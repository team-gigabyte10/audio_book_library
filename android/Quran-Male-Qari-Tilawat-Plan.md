# সহজে কুরআন শিক্ষা: Male-Only Qari Voice & Authentic Tilawat Recitation Plan

## 1. Problem Statement & Goals

Currently, **সহজে কুরআন শিক্ষা ও তাজবীদ কোর্স (`qr-*`)** routes `SpeechLang.AR` through the generic `TtsStepEngine`, which causes two UX issues:
1. **Uncontrolled Voice Gender:** `TtsStepEngine.bestOfflineVoice(locale)` picks whichever Arabic/Bangla TTS voice has the highest quality score regardless of gender—often selecting a **female voice** on Android Google TTS (`ar-xa` / `bn-BD`).
2. **Prose TTS Instead of Tilawat:** Standard Arabic TTS reads in fast Modern Standard Arabic prose cadence (`0.90x–1.05x`), ignores *Tartil* melody, swallows *Madd* (2/4/6 harakat) and *Ghunnah*, skips *Waqf* pauses, and clips single Noorani letters (`أ`, `ب`, `بـ`).

### Target Experience
- **100% Male Voice Across Entire Quran Course:**
  - Real **Male Qari** recitation for Quranic Verses / Surahs / Ayahs.
  - Strictly **Male Arabic TTS voice** (and Male Bangla instructor voice preference + pitch fallback) for Noorani Qaida drills and Bangla explanations inside `qr-*` lessons and the Quran welcome greeting.
  - Zero impact on existing English, Japanese, Urdu, Hindi, German, and Regional Bangla courses.
- **Authentic Quran Tilawat Cadence:**
  - **Surahs & Ayahs (Stage 7–8 + Ayah examples):** Play real **Male Qari Tartil/Muallim** audio (e.g., *Sheikh Mahmoud Khalil Al-Husary Muallim* or *Sheikh Mishary Rashid Alafasy*) with `0.75x` / `0.90x` / `1.0x` natural speed playback.
  - **Noorani Qaida Drills (Stage 1–6 Letters, Harakat, Sukun, Tashdeed, Tajweed):** Apply **Quran Prosody Formatting** (letter-name expansion, Uthmani TTS normalization, Waqf pause spacing, slow *Tartil* rates `0.68x–0.82x`, and deep baritone vocal pitch calibration).

---

## 2. Two-Tier Hybrid Audio Architecture

```
PlaybackStep.Speak (itemId, text, lang, rate, preferMale, audioAssetOrUrl)
        │
        ├──► Is `qr-*` Quranic Verse / Surah with mapped MP3 (Asset or Cache)?
        │         │
        │         ├── YES ──► QuranRecitationPlayer (MediaPlayer + PlaybackParams)
        │         │           • Real Male Qari Audio (Al-Husary Muallim / Alafasy)
        │         │           • Preserves natural pitch at 0.75x / 0.90x / 1.0x
        │         │           • Bundled offline core Surahs + OkHttp smart cache
        │         │
        │         └── NO (Noorani Qaida drill / uncached offline fallback / BN explanation)
        │                   │
        │                   ▼
        │             TtsStepEngine + QuranVoiceManager + QuranProsodyFormatter
        │             • Enforces Male Voice selection (`ar` & `bn` when `preferMale=true`)
        │             • Excludes female voices (`isFemaleVoice`)
        │             • Applies `QuranProsodyFormatter` (letter names, Uthmani fixes, Waqf pauses)
        │             • Deep Qari pitch (`0.90f` male voice / `0.76f` fallback pitch compensation)
```

---

## 3. Detailed Implementation Plan (3 Phases)

### Phase 1: Male Voice Enforcement & Tilawat Prosody Engine (TTS Layer)
*Goal: Immediately eliminate female voices across `সহজে কুরআন শিক্ষা` and make Qaida/offline Arabic TTS sound deliberate, clear, and Qari-like.*

1. **Create [`QuranVoiceManager.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/domain/audio/QuranVoiceManager.kt)** *(mirrors [`JapaneseVoiceManager.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/domain/audio/JapaneseVoiceManager.kt))*
   - **`selectMaleArabicVoice(tts)`:**
     - Filters `tts.voices` for Arabic (`ar`) installed voices (`!KEY_FEATURE_NOT_INSTALLED`).
     - Classifies gender using `voice.features` (`gender=male` / `gender=female`), voice name tokens (`male`, `man`, `-m-`, Google TTS Arabic voice codes), and **explicitly blocks female voices**.
     - Scores remaining male candidates by offline availability + neural/wavenet quality (`rateVoiceClarity`).
     - Returns `VoiceSelectionResult(voice, isVerifiedMale)` so the UI/engine knows if a genuine male voice was found or if fallback pitch shift is required.
   - **`selectMaleBanglaVoice(tts)`:**
     - Used *only* when `preferMale = true` (inside `qr-*` lessons and Quran Welcome Greeting) so the Bangla meaning/tajweed explanation is also delivered in a male instructor voice when available.
   - **`getQuranPitch(isVerifiedMale, lang)`:**
     - Arabic verified male voice: `0.90f` (solemn Qari baritone clarity).
     - Arabic unlabeled/fallback voice (no verified male voice installed on OS): `0.76f` (deep male register compensation) + trigger optional in-lesson prompt linking to `openDeviceTtsSettings()`.
     - Bangla instructor inside Quran mode: `0.94f` (male voice) / `0.80f` (fallback).

2. **Create [`QuranProsodyFormatter.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/domain/audio/QuranProsodyFormatter.kt)**
   - **Isolated Letter & Form Naming (Stage 1 & 2):**
     - Maps single Arabic letters (`أ`, `ب`, `ت`, ... `ي`) and Tatweel letter forms (`بـ`, `تـ`, `ـبـ`, `ـب`) to full spoken Noorani letter names (`"أَلِفْ"`, `"بَاءْ"`, `"تَاءْ"`, `"ثَاءْ"`, ..., `"يَاءْ"`) when sent to TTS, while the screen continues displaying `"ب"` / `"بـ"`.
     - Expands multi-letter drill strings like `"أ ب ت ث ج ح خ"` into spaced letter names with micro-pauses (`"أَلِفْ، ... بَاءْ، ... تَاءْ، ..."`) so TTS recites each letter cleanly like an Ustad instead of blurring or clipping them.
   - **Uthmani-to-Standard TTS Normalization:**
     - Translates Uthmani characters that Android TTS frequently misreads *only in the TTS string*:
       - Dagger Alif (`\u0670`, e.g., `الرَّحْمَٰنِ`, `إِلَٰهِ`) ➔ `ا` (`الرَّحْمَانِ`, `إِلَاهِ`) so Madd Tabee'i elongation is pronounced.
       - Alif Wasla (`\u0671`) ➔ `ا`.
       - Maddah/Small High signs that break TTS tokenization cleaned while keeping full Harakat/Sukun/Shaddah intact.
   - **Tilawat Waqf & Cadence Pauses:**
     - Inserts breathing pauses (`، `) at Waqf markers (`ۘ`, `ۚ`, `ۖ`, `ۙ`, `ۗ`), between paired Qaida examples, and at Ayah clauses so TTS pauses with measured *Tartil* rhythm.

3. **Extend [`LearningModels.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/domain/model/LearningModels.kt), [`LessonQueueBuilder.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/domain/ladder/LessonQueueBuilder.kt), & [`LessonViewModel.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/presentation/lesson/LessonViewModel.kt)**
   - Add `itemId: String? = null` and `preferMale: Boolean = false` to `PlaybackStep.Speak` (backward-compatible default values).
   - Add `suspend fun speakStep(step: PlaybackStep.Speak)` to `StepAudioEngine` interface (defaulting to `speak(step.text, step.lang, step.rate)` so existing tests stay green).
   - In `LessonQueueBuilder`: detect Quran items (`item.id.startsWith("qr-")`) and:
     - Pass `preferMale = true` on both `SpeechLang.AR` and `SpeechLang.BN` steps.
     - Use slower Bangla instructor pace (`0.95f` instead of `1.15f`) to match the calm spiritual tone of a Quran lesson.
   - In `LessonViewModel`:
     - When `isQuran` is true, change `speakText(text)` tap-to-listen rate from `1.05f` (fast English speed) to `0.80f` (clear Tilawat speed) and route with `preferMale = true`.
     - Check `arabicMaleVoiceMissing` state flow so `LessonScreen.kt` can inform the user if their Android device only has a female/generic Arabic TTS voice (and offer a 1-tap button to open TTS voice downloads).
   - In [`BanglaTTSManager.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/domain/tts/BanglaTTSManager.kt) & [`LearnHomeViewModel.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/presentation/home/LearnHomeViewModel.kt):
     - Add `preferMaleVoice: Boolean = false` parameter to `speakChunk()` so the Quran Welcome Greeting also uses a Male Bangla voice (or deeper pitch fallback) instead of switching back to the user's female audiobook voice.

---

### Phase 2: Real Male Qari Tilawat Audio Engine (Surahs, Ayahs & Key Drills)
*Goal: Deliver authentic, heart-touching Male Qari Quran Tilawat (`Tartil`) with true Tajweed, Ghunnah, Qalqalah, and Madd for all Surahs, Ayahs, and Dua items.*

1. **Qari Audio Mapping in Content Pipeline ([`build_quran_course.py`](file:///e:/Dev_Nayem/audio_book_library/android/tools/quran/build_quran_course.py) & `data_quran_*.py`)**
   - Add an optional `audio_ref` tag/field inside `tags` for every Quranic Ayah item in [`data_quran_p4_surahs_duas.py`](file:///e:/Dev_Nayem/audio_book_library/android/tools/quran/generators/data_quran_p4_surahs_duas.py) and Ayah examples in `p2`/`p3`:
     - Format: `surah_3digit + ayah_3digit` (e.g., Surah Fatiha 1:1 = `"001001"`, Surah Ikhlas 112:1 = `"112001"`, Surah Falaq 113:1 = `"113001"`, Surah Nas 114:1 = `"114001"`, Kawthar `108001–108003`, Nasr `110001–110003`, Ma'un `107001–107005`, Quraysh `106001–106003`, Fil `105001–105005`, Kafirun `109001, 109002, 109006`).
     - This matches the universal **EveryAyah / AlQuran** 6-digit Ayah ID standard.

2. **Build [`QuranRecitationPlayer.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/domain/audio/QuranRecitationPlayer.kt)** *(Real Audio Playback with Speed Control)*
   - Uses Android `MediaPlayer` + `AudioAttributes` + `PlaybackParams().setSpeed(rate)` inside a suspending coroutine wrapper (`suspendCancellableCoroutine` + timeout guard, clean `stop()`/`release()`).
   - Preserves authentic **Male Qari vocal depth** cleanly at `0.75x` (learner pace), `0.90x` (flowing Tilawat), and `1.0x` (natural Murattal).
   - Supports two Male Qari profiles (configurable in Quran Settings / `AppPreferences`):
     1. **Al-Husary (Muallim — Teacher Mode)** *(Default for Learning)*: Slow, crisp, textbook Tajweed articulation.
     2. **Mishary Rashid Alafasy** *(Melodious Tilawat)*: Classic heartfelt Murattal recitation.

3. **Offline-First Audio Source Strategy (Bundled Core + Smart Cache)**
   - **Bundled Core Assets (`android/app/src/main/assets/quran_audio/`):**
     - Bundle compact MP3/OGG (48–64 kbps mono ≈ ~1.5–2.0 MB total for all ~47 short Ayahs in Units 7 & 8) for Surah Fatiha + the short Surahs so Tilawat works **100% offline out of the box** on first install.
   - **On-Demand OkHttp Disk Cache (`context.filesDir/quran_audio/{qari}/{surahAyah}.mp3`):**
     - If user switches to secondary Qari (*Alafasy*) or taps any Ayah example from Stages 3–6 that isn't bundled locally, `QuranRecitationPlayer` streams & caches the MP3 using the project's existing `OkHttp` dependency (`libs.okhttp`), then falls back gracefully to Male Qari TTS (`TtsStepEngine`) only if both asset and network cache are unavailable.

4. **Hybrid Routing in [`TtsStepEngine.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/domain/audio/TtsStepEngine.kt) & [`EscbJsonParser.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/data/content/EscbJsonParser.kt)**
   - Persist `tags` / `audioRef` cleanly (or map item ID ➔ `surahAyah` lookup table in `QuranAudioCatalog.kt` if zero Room DB schema migration is preferred!).
   - *Design Note (Zero DB Migration Safety):* Keeping the `qr-*` item ID ➔ `surah:ayah` audio asset map in Kotlin (`QuranAudioCatalog.kt`) + bundled assets avoids needing a destructive Room DB schema version bump while keeping `EscbJsonParser` and `ItemEntity` 100% backward compatible!
   - When `SpeechLang.AR` runs in `TtsStepEngine.speakStep()`:
     1. Look up `audioRef` by `itemId` (full verse playback; word tokens continue via Qari-calibrated Male TTS or word audio).
     2. If MP3 exists in `assets/quran_audio/` or local disk cache (or downloadable online), play via `QuranRecitationPlayer` at requested `rate` (`0.75x` / `0.90x`).
     3. Otherwise, run `QuranProsodyFormatter.formatForTilawat()` + speak via `QuranVoiceManager` Male-only TTS.

---

### Phase 3: Curriculum Tuning, Qari UI Controls & Verification
*Goal: Expose clean Qari controls in Lesson Settings and test all paths thoroughly.*

1. **Tune Quran Repetition Ladder ([`build_quran_course.py`](file:///e:/Dev_Nayem/audio_book_library/android/tools/quran/build_quran_course.py))**
   - Update `ladder_default` / Quran cadence in `LessonQueueBuilder`:
     - **Step 1:** Arabic Tilawat (`0.72f` slow clear Tajweed)
     - **Step 2:** Bangla meaning/explanation (`0.95f` calm male instructor pace)
     - **Step 3:** Arabic Tilawat (`0.88f` natural fluent recitation)
     - **Step 4:** Reflection pause (`2000ms`)

2. **UI Additions in [`LessonScreen.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/main/java/com/gigabyte/bookstore/learning/presentation/lesson/LessonScreen.kt) & Settings Sheet**
   - When `viewModel.isQuran`:
     - Show **"কারী (তিলাওয়াতকারী): শেখ মাহমুদ খলিল আল-হুসারী (মুয়াল্লিম) / মিশারি আল-আফাসি (পুরুষ কণ্ঠ)"** selector inside the Lesson Settings bottom sheet (similar to the existing speaker selector for Japanese/Urdu).
     - Show subtle badge **"🎙️ পুরুষ কারী তিলাওয়াত"** on the player card.
     - If device lacks an Arabic Male TTS voice for Qaida lessons (Stages 1–6), show a helpful non-blocking tip: *"উন্নত পুরুষ কণ্ঠের আরবি উচ্চারণের জন্য TTS সেটিংস থেকে Arabic Male ভয়েস নির্বাচন করুন"* with a settings shortcut button.

3. **Automated & Verification Tests**
   - Add unit tests in `QuranVoiceManagerTest.kt` / [`QuranSupportTest.kt`](file:///e:/Dev_Nayem/audio_book_library/android/app/src/test/java/com/gigabyte/bookstore/learning/QuranSupportTest.kt):
     - Verify `QuranVoiceManager` strictly rejects female voices and prioritizes verified male voices.
     - Verify `QuranProsodyFormatter` expands isolated Haroof (`"ب"`, `"بـ"`), converts Uthmani dagger alif (`"الرَّحْمَٰنِ"` ➔ `"الرَّحْمَانِ"`), and inserts Waqf pauses without breaking display text.
     - Verify `QuranAudioCatalog` maps every Surah Ayah item in `qr-p4-u07` and `qr-p4-u08` to valid 6-digit Surah:Ayah keys.
     - Verify `LessonQueueBuilder` marks `preferMale = true` for all `qr-*` steps while leaving `en-*`, `jp-*`, `ur-*`, `hi-*`, `de-*`, `bd-*` unchanged (`preferMale = false`).

---

## 4. Phase Execution Roadmap

| Phase | Scope | Impact on Existing Courses | Offline Support |
| :--- | :--- | :--- | :--- |
| **Phase 1** | `QuranVoiceManager` (Male-only AR & BN in `qr-*`), `QuranProsodyFormatter` (Haroof naming, Uthmani normalization, Waqf pauses), slow *Tartil* speeds | Zero impact (`preferMale` scoped to `qr-*`) | 100% Offline |
| **Phase 2** | `QuranRecitationPlayer` + `QuranAudioCatalog` + Real Male Qari audio (*Al-Husary Muallim* / *Mishary Alafasy*) bundled for Fatiha & 10 Surahs + OkHttp cache | Zero DB schema change | Core Surahs 100% Offline + Online cache for extra Qari/Ayahs |
| **Phase 3** | Qari selector UI in `LessonScreen` settings, Male TTS fallback prompt, ladder speed tuning (`0.72x`/`0.88x`), unit tests | UI scoped to `viewModel.isQuran` | Full test verification |

