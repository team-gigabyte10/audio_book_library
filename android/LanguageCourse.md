# LanguageCourse — Android App Plan

A spoken-language learning app for **English, Japanese, Korean, and German**. It focuses on listening to words and sentences, repeating them many times, and getting scored on pronunciation.

---

## 1. Goals

| Goal | What it means for the user |
|---|---|
| Hear it right | Native-quality audio for every word and sentence, at normal and slow speed |
| Say it many times | Loop, shadowing, and "listen → repeat → compare" drills |
| Know if it's right | A pronunciation score per word, with the weak sounds highlighted |
| Remember it | Spaced repetition brings back the words you get wrong |
| Stay motivated | Streaks, daily goals, and progress per language |

**Out of scope for v1:** grammar lessons, writing/handwriting practice, chat with tutors, iOS.

---

## 2. Core Features

### 2.1 Language & Course Selection
- Pick a native (UI) language and one or more target languages: `en-US`, `ja-JP`, `ko-KR`, `de-DE`.
- Choose a level: Beginner (A1), Elementary (A2), Intermediate (B1).
- Courses are organized as **Unit → Lesson → Items** (word / phrase / sentence).

### 2.2 Word Sound Practice (Repeat Mode)
- **Play**: native audio at normal speed.
- **Slow play**: 0.5x / 0.75x speed without changing pitch.
- **Loop**: repeat N times (3 / 5 / 10 / infinite) with an adjustable pause between repeats.
- **Shadowing**: audio plays and the user speaks along at the same time.
- **Listen → Repeat → Compare**: play the native audio, record the user, then play both back to back.
- **Syllable breakdown**: play one part at a time, e.g. `Ent-schul-di-gung`, `こ-ん-に-ち-は`, `안-녕-하-세-요`.
- **Display per language**:
  - English: word + IPA (`/ˈwɔːtər/`)
  - Japanese: kanji + furigana + romaji (toggle), plus pitch-accent marks
  - Korean: Hangul + Revised Romanization (toggle), plus notes on sound changes (e.g. 국물 → [궁물])
  - German: word + IPA, with notes on umlauts (ä, ö, ü), `ch`, and `r`

### 2.3 Pronunciation Test
1. The app shows a word or sentence and plays it (optional in "test" mode).
2. The user taps and holds the mic, then speaks.
3. The app returns:
   - **Overall score** (0–100)
   - **Accuracy** (were the sounds right?)
   - **Fluency** (pace, pauses), for sentences
   - **Completeness** (were any words missed?)
   - **Per-word / per-phoneme colors**: green ≥ 80, yellow 60–79, red < 60
4. Tap a red word to hear the native audio again plus your own recording.
5. Items scored below the threshold go into the **review queue**.

**Test types**
- Quick test: 10 random words from the current lesson
- Lesson test: all items in a lesson; pass at ≥ 70 average to unlock the next lesson
- Minimal pairs: e.g. EN `ship/sheep`, DE `Bär/Beere`, KO `달/딸/탈`, JA `おばさん/おばあさん`

### 2.4 Spaced Repetition (Review)
- Use the **FSRS** algorithm (or SM-2 as a simpler fallback).
- Pronunciation score feeds into the rating: < 60 = Again, 60–79 = Hard, 80–89 = Good, ≥ 90 = Easy.
- Daily review queue shown on the home screen.

### 2.5 Progress & Motivation
- Daily goal (minutes or items), streak counter, XP.
- Per-language dashboard: words learned, average score, weakest sounds.
- "Problem sounds" report, e.g. "Your German `ü` averages 54".

---

## 3. Technical Architecture

### 3.1 Stack
| Layer | Choice | Reason |
|---|---|---|
| Language | **Kotlin** | Standard for modern Android |
| UI | **Jetpack Compose** + Material 3 | Declarative and quick to iterate |
| Architecture | **MVVM + Clean Architecture** (ui / domain / data) | Testable, and the speech engine can be swapped |
| DI | **Hilt** | |
| Local DB | **Room** | Courses, progress, SRS state |
| Settings | **DataStore** | |
| Audio playback | **Media3 ExoPlayer** | Speed control, looping, caching |
| Recording | **AudioRecord** (16 kHz, mono, PCM) | Format the speech engines expect |
| Async | Coroutines + Flow | |
| Background | WorkManager | Content download, reminders |
| Min SDK | 26 (Android 8.0); target the latest SDK | |

### 3.2 Module Layout
```
app/
core/
  audio/          # ExoPlayer wrapper, AudioRecord, waveform
  speech/         # PronunciationEngine interface + implementations
  database/       # Room entities, DAOs
  designsystem/   # Compose theme, components
feature/
  onboarding/
  course/         # unit / lesson browsing
  practice/       # repeat mode, shadowing
  test/           # pronunciation tests
  review/         # SRS queue
  progress/       # stats dashboard
```

### 3.3 Speech Engine (the key decision)

Define one interface so engines can be swapped:

```kotlin
interface PronunciationEngine {
    suspend fun assess(
        audio: ByteArray,          // 16 kHz mono PCM
        referenceText: String,
        locale: Locale             // en-US, ja-JP, ko-KR, de-DE
    ): PronunciationResult
}

data class PronunciationResult(
    val overall: Int,
    val accuracy: Int,
    val fluency: Int?,
    val completeness: Int,
    val words: List<WordScore>     // each with phoneme scores if available
)
```

| Option | Quality | Offline | Cost | Notes |
|---|---|---|---|---|
| **A. Azure AI Speech – Pronunciation Assessment** | ★★★★★ phoneme-level | ❌ | Pay per audio hour (has a free tier) | Supports all 4 locales. **Recommended for v1.** |
| B. Google Cloud Speech-to-Text | ★★★ word-level confidence only | ❌ | Pay per use | No real pronunciation scoring |
| C. Android `SpeechRecognizer` + text compare | ★★ | ✅ on some devices | Free | Fallback only: compare recognized text with target (Levenshtein on kana / Hangul jamo / letters) |
| D. On-device model (wav2vec2 phoneme / Whisper via ONNX or TFLite) | ★★★–★★★★ | ✅ | Free, but large APK and hard work | Phase 3 goal for offline mode |

**Plan:** v1 uses **A** with **C** as the offline fallback. Phase 3 evaluates **D**.

Keep the Azure key on a small backend (e.g. Cloud Function) that issues short-lived tokens. **Never ship the key in the APK.**

### 3.4 Audio Content Source
| Option | Notes |
|---|---|
| **Pre-generated neural TTS** (Azure / Google WaveNet), stored as files | Consistent quality, works offline once downloaded. **Recommended.** |
| Android `TextToSpeech` on the device | Free and offline, but quality and voices vary by device. Use as fallback |
| Native-speaker recordings | Best quality but costly. Use for core beginner words later |
| Open data (Tatoeba sentences CC-BY, Wiktionary audio CC-BY-SA) | Check license and attribution rules per item |

Audio is shipped as **downloadable language packs** (one per language/level) to keep the APK small.

### 3.5 Data Model (Room)
```
Language(code, name, script)
Course(id, languageCode, level, title)
Unit(id, courseId, order, title)
Lesson(id, unitId, order, title)
Item(id, lessonId, type[WORD|PHRASE|SENTENCE], text, reading,
     romanization, ipa, translation, audioPath, slowAudioPath,
     syllables[], pitchAccent?, notes?)
Attempt(id, itemId, timestamp, overall, accuracy, fluency,
        completeness, phonemeJson, recordingPath?)
SrsCard(itemId, stability, difficulty, due, lapses, state)
UserStats(date, languageCode, minutes, itemsPracticed, xp)
```

### 3.6 Permissions & Privacy
- `RECORD_AUDIO`: asked for in context, the first time the user taps the mic.
- `INTERNET`: needed for scoring and content download.
- `POST_NOTIFICATIONS` (Android 13+): only if the user turns on reminders.
- Recordings stay **on the device by default**. Audio sent for scoring is not stored on the server.
- Clear privacy policy, required for the Play Store "Data safety" form.

---

## 4. Screens

1. **Onboarding**: pick languages and level, mic permission explainer, daily goal.
2. **Home**: daily goal ring, streak, "Continue lesson", "Review (N due)", language switcher.
3. **Course map**: units and lessons with lock/complete state.
4. **Lesson / Practice**: item card, play / slow / loop controls, record button, waveform comparison.
5. **Pronunciation test**: prompt, mic, result screen with color-coded words.
6. **Review**: SRS queue using the same practice card.
7. **Progress**: charts per language, problem sounds, history.
8. **Settings**: playback speed, loop count, romaji/romanization toggles, voice gender, reminders, downloads.

---

## 5. Language-Specific Notes

| Language | Main pronunciation challenges | App support |
|---|---|---|
| **English** | th, r/l, v/w, vowel length, word stress | IPA, stress marks, minimal pairs |
| **Japanese** | Pitch accent, long vowels (おばさん vs おばあさん), small っ, ん | Pitch-accent graph, mora-by-mora playback, furigana |
| **Korean** | Plain/tense/aspirated consonants (ㄱ/ㄲ/ㅋ), batchim, sound-change rules | 3-way minimal pairs, sound-change notes, jamo breakdown |
| **German** | ü/ö/ä, ich-/ach-Laut, uvular r, long compound words | Syllable splitting for compounds, IPA, minimal pairs |

---

## 6. Roadmap

### Phase 0: Setup (1 week)
- [ ] Create the project (Kotlin, Compose, Hilt, Room), set up CI (GitHub Actions: build, lint, unit tests)
- [ ] Design system: colors, typography, and fonts with CJK support (Noto Sans JP / KR)
- [ ] Spike: record audio, send it to Azure Pronunciation Assessment for each of the 4 locales, check the scores

### Phase 1: MVP (4–6 weeks)
- [ ] Content pipeline: a CSV/JSON word list → TTS audio generation script → language pack
- [ ] 1 course per language: ~200 beginner words + 50 phrases
- [ ] Practice screen: play, slow, loop, record, compare
- [ ] Pronunciation test with word-level colors
- [ ] Room storage for attempts and progress
- [ ] Token backend for Azure
- [ ] Offline fallback (SpeechRecognizer + text match)

### Phase 2: Retention (3–4 weeks)
- [ ] FSRS review queue
- [ ] Streaks, XP, daily goal, reminders
- [ ] Progress dashboard and problem-sounds report
- [ ] Minimal-pair drills
- [ ] Shadowing mode for sentences

### Phase 3: Depth & Offline (4+ weeks)
- [ ] Phoneme-level feedback UI (tap a sound to see mouth/tongue tips)
- [ ] Japanese pitch-accent visualizer; pitch contour of user vs native
- [ ] On-device scoring model (evaluate wav2vec2 / Whisper with ONNX Runtime Mobile)
- [ ] A2 / B1 content
- [ ] Cloud backup of progress (optional sign-in)

### Phase 4: Launch
- [ ] Closed testing on Play Console (required tester period for new personal accounts)
- [ ] Store listing in all 4 languages, screenshots, privacy policy
- [ ] Crash reporting and analytics (Firebase Crashlytics)
- [ ] Monetization: free core lessons + subscription for unlimited scoring and higher levels (scoring has a per-use cloud cost)

---

## 7. Testing Strategy
- **Unit tests**: SRS scheduling, score → rating mapping, text-match fallback (kana / jamo normalization).
- **Engine contract tests**: a fake `PronunciationEngine` plus recorded audio fixtures per language (good, bad, and silent clips).
- **UI tests**: Compose tests for practice and test flows.
- **Manual QA**: native speakers of each language check audio and scoring fairness. Test on low-end devices and in noisy rooms.
- **Edge cases**: mic denied, no network, silence or too-short recording, Bluetooth headset, interruption by a phone call.

---

## 8. Risks & Mitigations
| Risk | Mitigation |
|---|---|
| Cloud scoring cost grows with users | Daily free limit, cache results, move to on-device model in Phase 3 |
| Scores feel unfair (accents, noise) | Calibrate thresholds per language, noise check before recording, let users see raw phoneme detail |
| Content licensing | Use only self-generated TTS or clearly licensed data; keep an attribution file |
| APK size from audio | Downloadable language packs; Opus/AAC compression |
| Japanese/Korean text rendering | Bundle Noto CJK subsets; test furigana layout early |

---

## 9. Open Decisions
- [ ] Azure vs another provider: confirm after the Phase 0 spike (quality and price for ja/ko).
- [ ] UI languages: English only for v1, or also localize the UI?
- [ ] Sign-in required or optional?
- [ ] Free vs paid feature split.

---

## 10. Next Steps
1. Run the Phase 0 speech spike (record → Azure → score) for all four languages.
2. Write the first 50-word list per language in the content format (§3.5).
3. Build the Practice screen end to end for a single word.
