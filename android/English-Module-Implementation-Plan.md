# English Language Module — Implementation Plan

Source content: `app/src/main/assets/ESCB-Latest-Version.json`
Design references: `Learning-Module-Guideline.md` (primary), `LanguageCourse.md` (pronunciation testing, retention features)

---

## Implementation status (Phase 1)

Code lives in `app/src/main/java/com/gigabyte/bookstore/learning/`. Tests are in `app/src/test/java/com/gigabyte/bookstore/learning/`.

**Built:** streaming importer → `LearningDatabase`, quality gate, ladder queue builder, two-instance `TtsStepEngine`, `LessonPlayer`, Learn home / part / lesson (Listen + Speak modes, word-by-word, settings sheet) / quiz screens, lesson unlock + bundle gate, Home English card → `learn` route, Bangla voice prompt on every app open.

**Decisions for the open questions (§7):**
1. **No locks** (user decision): every lesson in every part is open. There is no purchase gate and no required order. A quiz score of 70% or more only marks a lesson as done.
2. The Home English card opens the new module. The Firestore course sheet is still reachable from banners.
3. All parts with content are open (Parts 1–9). The §6 quality gate still hides flagged items and items without Bangla. Part 0 has no content, so it shows "শীঘ্রই আসছে".
4. Mistake reports are deferred.

**Deviations from this plan:**
- Gaps use coroutine `delay`, not `playSilentUtterance`, because it is cancellable and testable.
- UI strings are inline Bangla, matching the rest of the app, not `strings.xml`.
- Not built yet: the drawer entry, the English voice picker in settings, and mistake reports.

**Not yet verified:** the code was written without a JDK or Android SDK on the authoring machine. It has not been compiled, and the tests have not been run.

## 0. Starting point (what exists today)

### Content file
| Fact | Impact on the plan |
|---|---|
| 10 parts, 1,661 lessons, 13,848 items. Item schema matches Guideline §3 (`id`, `concept_id`, `type`, `level`, `target`, `bn`, `tokens`, `tags`, `audio`, `source`, `status`), plus `example`, `speaker`, `review_flags`, `derived_from` | We can import it directly; no schema redesign needed |
| **Every item is `status: needs_review`** (machine-extracted with OCR) | The app needs a review gate (§6) |
| **Part 0 (Script & Sounds) is empty**. Part 1 is ordered by frequency, not theme | Part 0 needs new authored content. Part 1 needs regrouping (content work, not app work) |
| Parts 1, 3 and 4 have **0 flagged items**. Part 2 has 76 flagged. Parts 5–9 have most of the OCR problems (e.g. P5 has explanation paragraphs in `bn`, P9 has very long answers and 101 items without `bn`) | MVP = Parts 1–4, which is the cleanest data |
| Every item lists `audio` paths (`en/p1/l001/001_s.opus`, …), but **no audio files exist** | **The app uses on-device TTS only, permanently.** The importer ignores the `audio` field and no audio files will ever be shipped or downloaded |
| `ladder_default` is in the file (0.6 → bn → 0.6 → 0.8 → 1.0 → 1.2 [B1+] → pause 1500 ms) | Drive the player from this data instead of hardcoding it |
| `tokens` exist for every item, but token-level `bn` is mostly `null` (except in word lessons) | Word-by-word mode plays only the target text. The Bangla gloss is shown only when present |
| `concept_id` is a hash of the text, so it stays stable. `id` depends on the order of extraction | **Key user progress by `concept_id`** so progress survives content regeneration |
| No `pattern_id` / pattern frames | Skip "Pattern drill" in the MVP |

### App
- Kotlin, Compose with Material 3, Navigation-compose, Room 2.7 via KSP, Moshi (KSP codegen), minSdk 24.
- **No DI framework.** Singletons live in `BanglaAudiobookApp`, and ViewModels are built through `SimpleViewModelFactory`.
- `AudiobookDatabase` uses `fallbackToDestructiveMigration()`. **Learning progress must not go in it**, because the next version bump would wipe it.
- Playback is Android `TextToSpeech` through `BanglaTTSManager`. It is QUEUE_FLUSH with one utterance at a time, and it switches locale with `setCourseLanguage()`. There is no ExoPlayer or MediaSession.
- `AudiobookForegroundService` is hard-wired to `app.player`, so it can't be reused as-is.
- The current "English course" is a Firestore `Course` shown in a bottom sheet. It is gated by `isBundleUnlocked("english_course")`.
- Not present: Media3, WorkManager, mocking library, room-testing.

### Conflicts between the two docs
| Topic | Learning-Module-Guideline | LanguageCourse | Decision |
|---|---|---|---|
| Grammar lessons | Core of the course (Parts 3–5) | Out of scope for v1 | **Follow the Guideline**, because the ESCB content *is* grammar-driven |
| Hierarchy naming | Course → Part → Lesson → Item | Unit → Lesson → Item | Use **Part** (it matches the JSON) |
| Pronunciation scoring | Optional SpeechRecognizer check | Azure Pronunciation Assessment | Phase 3. Start with an on-device SpeechRecognizer text match; Azure later through a token backend |
| SRS | FSRS or SM-2 | FSRS or SM-2 | **SM-2 first** (simple and testable), behind an interface so FSRS can replace it |
| Unlock rule | — | Lesson test ≥ 70 % unlocks the next lesson | Adopt it, using quiz score (pronunciation score once Phase 3 lands) |
| Audio source | Pre-generated cloud neural TTS files; on-device TTS only as fallback | Pre-generated TTS files as downloadable packs | **Neither. On-device Android `TextToSpeech` is the only audio source.** No audio files, packs or downloads. Trade-offs we accept: voice quality varies by phone, slow speed is the TTS rate (not a separate slow recording), and Bangla needs a Bangla voice installed on the device |

---

## 1. Architecture

New feature package `com.gigabyte.bookstore.learning`, kept separate from the audiobook code:

```
learning/
  data/
    content/   ContentImporter (streaming Moshi JsonReader), ContentJson DTOs
    db/        LearningDatabase, entities, DAOs, migrations
    LearningRepository.kt
  domain/
    ladder/    PlaybackStep, LadderConfig, LessonQueueBuilder
    audio/     StepAudioEngine (interface, so the player can be tested with a fake), TtsStepEngine
    player/    LessonPlayer (runs the step queue, exposes StateFlow<LessonPlayerState>)
    quiz/      QuizGenerator, QuizQuestion types
    srs/       Scheduler (interface), Sm2Scheduler
    speech/    SpeechCheck (interface), RecognizerSpeechCheck   [Phase 3]
  presentation/
    home/      LearnHomeScreen (+VM)        continue lesson, review due, streak
    coursemap/ CourseMapScreen (+VM)        parts → lessons, progress/lock
    lesson/    LessonScreen (+VM)           intro → items → build-up → speak → quiz
    quiz/      QuizScreen (+VM)
    review/    ReviewScreen (+VM)
    settings/  LearningSettingsSheet
```

Wiring follows the existing manual pattern: add `val learningDatabase by lazy`, `learningRepository`, and `lessonPlayer` to `BanglaAudiobookApp`, and build ViewModels with `SimpleViewModelFactory`. Don't introduce Hilt only for this module.

### 1.1 Content storage: import JSON into Room on first launch
Use a **separate `LearningDatabase`** (`learning.db`, `exportSchema = true`, real migrations) with two groups of tables:

- **Content tables** (rebuilt whenever the content changes): `parts`, `lessons`, `items`, `content_meta(schema_version, content_hash, imported_at)`.
- **Progress tables** (never wiped): `lesson_progress`, `srs_cards`, `attempts`, `daily_stats`.

The importer streams the 19 MB asset with Moshi `JsonReader`. It must not load the whole tree, which matters on low-RAM phones. It inserts in batches inside one transaction, which takes a few seconds and shows a progress screen. It runs again only when `schema_version` or the asset hash changes.

**Why not `createFromAsset` (the Guideline's suggestion)?** Room validates a prebuilt DB against its own schema hash. Shipping one means building a Python→SQLite pipeline that has to stay in sync with the entities. Importing the JSON uses Moshi, which is already in the project, and keeps the JSON as the single source of truth.

The importer skips the `audio` object entirely; there is no audio column in the database.

Add `androidResources { noCompress += "json" }`? **No.** A compressed asset keeps the APK about 15 MB smaller, and it's read only once.

### 1.2 Entities (sketch)
```kotlin
PartEntity(id, order, level, titleBn, titleTarget, contentNeeded)
LessonEntity(id, partId, order, titleBn, titleTarget, introBn, structureJson, sourceSection, itemCount)
ItemEntity(id, lessonId, order, conceptId, type, level, target, bn, bnPron, romanization,
           tokensJson, sentenceType, polarity, tense, question, wh, pos,     // tags flattened for filtering
           exampleTarget, exampleBn, speaker, source, status, reviewFlags)    // reviewFlags: comma-joined
// indices: items(lessonId, order), items(conceptId), items(tense), items(sentenceType)

LessonProgressEntity(lessonId, state[LOCKED|AVAILABLE|IN_PROGRESS|DONE], bestScore, lastItemIndex, updatedAt)
SrsCardEntity(conceptId PK, ease, intervalDays, reps, lapses, dueAt, lastGrade)
AttemptEntity(id, conceptId, kind[QUIZ|SPEAK], correct, latencyMs, score?, at)
DailyStatsEntity(date PK, minutes, itemsPracticed, xp)
```

### 1.3 Playback: a step queue (Guideline §5)
```kotlin
sealed interface PlaybackStep {
    data class Speak(val text: String, val lang: Lang /* EN | BN */, val rate: Float,
                     val display: ItemDisplay) : PlaybackStep
    data class Pause(val ms: Long) : PlaybackStep
}
```
- `LessonQueueBuilder(items, ladder, userLevel, settings)` → `List<PlaybackStep>`. It is pure Kotlin and fully unit-tested.
  - It reads `ladder_default` from the content (stored in `content_meta`) and overlays the user's overrides.
  - It drops `min_level` steps when the item level is below the minimum (A0 < A1 < A2 < B1 < B2).
  - It skips the `bn` step when `bn` is null or Bangla is turned off.
  - Word-by-word mode plays each token, then cumulative prefixes (`I` → `I eat` → `I eat rice`), then the full ladder.
- `StepAudioEngine` interface with `suspend fun play(step)`. The only real implementation is **`TtsStepEngine`**; the interface exists so `LessonPlayer` can be unit-tested with a fake:
  - Two `TextToSpeech` instances (EN `Locale.US` and BN with the existing fallback chain), so the en↔bn alternation doesn't call `setLanguage` for every step.
  - Rate comes from `setSpeechRate(step.rate)`, so 0.6x is the TTS engine speaking slowly. Pauses use `playSilentUtterance`.
  - It suspends until `UtteranceProgressListener.onDone`, with a timeout guard.
  - **English voice:** on first open, pick the best installed `en-US` voice (prefer `Voice.QUALITY_HIGH`/`VERY_HIGH`, not `isNetworkConnectionRequired`) and let the learner change it in settings. If no English voice is installed, show a one-time prompt to install one (`ACTION_INSTALL_TTS_DATA`).
  - **Bangla voice:** check `isLanguageAvailable(bn-BD)` **every time the app opens** (each cold start of `MainActivity`, once TTS has initialized; not on rotation or when returning from the background). If the voice is missing, show a dialog ("বাংলা ভয়েস ইনস্টল করুন": Install / Not now) at the app root in `AppNavHost`, so it appears whatever screen the app starts on. Install opens `ACTION_INSTALL_TTS_DATA`; when the user returns, check again and enable Bangla speech if the voice is now there. There is no "don't ask again" option. If the user taps "Not now", lessons show the Bangla text and skip the Bangla step until the next app open. Reuse the existing `BanglaTTSManager` voice status (`TTSVoiceStatus`, `TTSStatusBanner`) so the audiobook side and the learning module share one check and one dialog.
  - Recommend Google's "Speech Services" engine in the setup prompt, since it has the best free voices for both `en-US` and `bn-BD` on most phones.
- `LessonPlayer` runs the queue in a coroutine (play / pause / next item / previous item / loop lesson / sleep timer) and exposes `StateFlow<LessonPlayerState>` (current item, step index, display text).
- **Isolation from the audiobook player:** the learning player owns its own TTS instances and stops `app.player` before it starts, so the two never talk over each other.

### 1.4 Spaced repetition
`Scheduler` interface, with `Sm2Scheduler` as the first implementation.
- Grades from the quiz: wrong = Again, correct and slow (above the latency threshold) = Hard, correct = Good, instant = Easy.
- Cards are created when an item is first seen in a lesson, keyed by `conceptId`, so the same concept in P3 and P4 shares one card.

### 1.5 Quiz generation (pure Kotlin, seeded Random for tests)
- **Listen → pick Bangla:** 4 options; distractors come from the same lesson first, then the same part.
- **Bangla → pick sentence.**
- **Arrange words:** built from `tokens`, only for 3–10 tokens.
- **Fill the blank:** hide one content token, never the first token or punctuation.
- Skip items without `bn` for the Bangla-based question types.

---

## 2. Screens and navigation

New `Screen` routes, following the existing `createRoute()` pattern:
```
learn                         LearnHome
learn/parts                   CourseMap
learn/lesson/{lessonId}       Lesson (template steps 1–6)
learn/quiz/{lessonId}         Quiz
learn/review                  Review (due SRS cards through the same ladder)
```
- **Entry points:** the existing English showcase card on Home (`HomeScreen.kt`) opens `learn` instead of the bottom sheet. A drawer item "ইংরেজি শিখুন" also opens it, which needs a new callback threaded through `AppDrawerContent`, `HomeScreen` and `AppNavHost`.
- **Course map:** the parts list shows level badge, `title_bn`, `title_target` and progress. Opening a part shows its lessons. Parts with `content_needed` and no lessons (Part 0) show "শীঘ্রই আসছে".
- **Lesson screen**, following the Guideline's lesson template:
  1. **Intro:** `intro_bn` + `structure` formulas, shown if present.
  2. **Items:** the ladder player, with large target text, Bangla below, tappable tokens (tap = speak token), a speed chip and a play/pause/next bar.
  3. **Build-up:** cumulative token playback for sentences.
  4. *(Pattern drill: skipped, no pattern frames in the data.)*
  5. **Speak:** show the Bangla, leave a gap (learner speaks), then play the answer.
  6. **Quiz:** a score of 70 % or more marks the lesson DONE and unlocks the next one.
  7. **Review:** done from LearnHome ("পুনরাবৃত্তি (N)").
- **Settings sheet**, stored in `AppPreferences` with a `learn_` prefix. The project uses SharedPreferences, so stay consistent:
  - Ladder speeds and repetitions, gap length, Bangla audio on/off, auto-advance, loop lesson, word-by-word default, show-unreviewed toggle (debug/admin only).
- Bangla UI strings go in `strings.xml`, unlike the hardcoded strings in the current service.

---

## 3. Phased delivery

### Phase 1: MVP (Parts 1–4, TTS)
1. **Data layer:** DTOs, `LearningDatabase` + DAOs, `ContentImporter`, `LearningRepository`, and an import progress screen.
   - *Done when:* a fresh install imports all 13,848 items, the second launch skips the import, and a changed asset hash triggers a re-import without losing progress.
2. **Ladder + TTS engine:** `PlaybackStep`, `LessonQueueBuilder`, `TtsStepEngine`, `LessonPlayer`.
   - *Done when:* one lesson plays the full ladder (0.6 / bn / 0.6 / 0.8 / 1.0 + 1.5 s gap) with en/bn alternation and no audiobook interference.
3. **Navigation + CourseMap + Lesson screen** (template steps 1, 2, 3, 5), with entry from Home.
4. **Quiz + lesson unlock + `lesson_progress`**, and "Continue lesson" on LearnHome.
5. **Content gate:** show only Parts 1–4, hide items with `review_flags` (see §6), plus a lesson-level "report a mistake" action (writes to Firestore `content_reports`).
6. **Tests** (§5) green; manual run on a low-end device.

### Phase 2: Retention and background (Parts 5–6)
- `Sm2Scheduler`, `srs_cards`, Review screen, review count on LearnHome.
- Streaks, XP, daily goal (`daily_stats`).
- **Background playback:** extract a `PlaybackController` interface so `AudiobookForegroundService` can drive either `AudiobookPlayer` or `LessonPlayer`. TTS keeps speaking with the screen off as long as that foreground service runs, so Media3/ExoPlayer isn't needed.
- Enable Parts 5–6 after the content review (§6).

### Phase 3: Speaking feedback
- `SpeechCheck` with on-device `SpeechRecognizer` (`en-US`) + normalized Levenshtein text match → score 0–100. Ask for `RECORD_AUDIO` in context the first time the learner taps the mic.
- Per-word coloring by comparing recognized tokens against target tokens (green ≥ 80, yellow 60–79, red < 60).
- Score feeds SRS grading (< 60 Again, 60–79 Hard, 80–89 Good, ≥ 90 Easy).
- Later: Azure Pronunciation Assessment through a token backend (never ship the key in the APK).

### Phase 4: Parts 7–9
- Enable Parts 7–9 after review. In Part 9, show `speaker` labels and split long interview answers into sentences.
- In Part 9 dialogues, use two different installed English voices for the two speakers if the device has more than one.

---

## 4. Content work (parallel track, not app code)
- **Part 0:** author alphabet, phonics and hard sounds (v/w/f/z/th, sh/s) in the same item schema (`type: "letter"`).
- **Part 1:** regroup into themes (pronouns, numbers, family, food, 20–30 core verbs). Pronouns and core verbs come first.
- **Fix the flagged items** (`check_en_ocr` 319, `check_bn_ocr` 48, `missing_bn` 235, `no_bn_in_source` 95), plus the P5 items where `bn` holds a paragraph of explanation instead of a translation.
- **Merge short lessons:** 258 lessons have fewer than 5 items; the Guideline targets 5–10.
- When an item is reviewed, set `status: "reviewed"`. The app gate (§6) reads this field, so no app change is needed as content improves.
- The extractor `tools/extract_escb.py` named in the JSON isn't in this repo. Add it (and a `validate.py`) to version control so the JSON can be regenerated.

## 5. Testing
| Layer | Tests |
|---|---|
| `ContentImporter` | Robolectric + small fixture JSON (2 parts, nulls, `review_flags`, `example`, `speaker`); re-import keeps progress tables. Add `androidx.room:room-testing` |
| `LessonQueueBuilder` | `min_level` filtering, null `bn` skipped, Bangla-off setting, word-by-word prefixes, user overrides |
| `Sm2Scheduler` | Interval growth, lapse reset, grade mapping from latency |
| `QuizGenerator` | Distractors unique and ≠ answer, arrange-words only for 3–10 tokens, deterministic with a seed |
| `LessonPlayer` | Fake `StepAudioEngine`: pause/resume, next/previous, loop, cancellation |
| UI | Compose test for the lesson flow; Roborazzi screenshots for CourseMap and Lesson card (light/dark) |
| Manual | Low-end device, EN or BN voice missing, a non-Google TTS engine (e.g. Samsung), audiobook playing while a lesson starts, screen rotation mid-ladder; listen at 0.6x and 1.0x on 2–3 phones to check that slow TTS is still clear |

## 6. Content-quality gate
Learners memorize mistakes (Guideline §6 step 4), so the app shows an item only if:
`status == "reviewed"` **OR** (`review_flags` is empty **AND** `bn` is not null **AND** the part is in the enabled set).

The enabled set starts as Parts 1–4 (remote-configurable later). A lesson with fewer than 3 visible items is hidden. A debug toggle shows everything for reviewers.

## 7. Open decisions
1. **Monetization:** keep the existing `english_course` bundle gate? Suggested: first lesson of each part free, the rest behind the bundle.
2. **Replace or coexist:** does the new module replace the Firestore English `Course` bottom sheet, or sit next to it?
3. **MVP content:** is showing `needs_review` items from Parts 1–4 acceptable, or should someone review them before release?
4. **Mistake reports:** where should they go (Firestore collection vs email)?
