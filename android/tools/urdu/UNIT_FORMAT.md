# Urdu standard course: unit file format

Source files for the course "Zero to A1" (Phase 1 of `Urdu-Spoken-Curriculum-Plan.md`).
The build script `build_urdu_course.py` reads every file in `units/`, checks it,
and writes `app/src/main/assets/spoken_urdu_standard_a1.json`.

Do not edit the asset by hand. Edit a unit file, then run:

```
python tools/urdu/build_urdu_course.py          # check + build
python tools/urdu/build_urdu_course.py --check  # check only
```

## File names

One file per unit:

- Stage 0: `units/s0-01.json` … `units/s0-10.json` (plan units 0.1 … 0.10)
- A1: `units/a1-01.json` … `units/a1-15.json` (plan units 1.1 … 1.15)

The script makes all IDs from the file name and the order. Do not write IDs.

## Unit file

```json
{
  "unit": "1.7",
  "title_bn": "প্রতিদিনের কাজ",
  "title_target": "روزمرہ کے کام",
  "lessons": [
    {
      "title_bn": "আমি প্রতিদিন উঠি: اٹھتا ہوں",
      "title_target": "Present habitual",
      "intro_bn": "Short Bangla explanation for the learner (2–4 sentences).",
      "structure": ["میں … تا ہوں۔ · আমি … করি (পুরুষ)", "میں … تی ہوں۔ · আমি … করি (নারী)"],
      "items": [ ... ]
    }
  ]
}
```

## Item

```json
{
  "type": "sentence",
  "target": "میں روز سات بجے اٹھتا ہوں۔",
  "target_marked": "مَیں روز سات بَجے اُٹھتا ہُوں۔",
  "bn": "আমি প্রতিদিন সাতটায় উঠি।",
  "bn_pron": "ম্যাঁয় রোজ় সাত বজে উঠতা হুঁ",
  "variant_f": "میں روز سات بجے اٹھتی ہوں۔",
  "variant_f_pron": "ম্যাঁয় রোজ় সাত বজে উঠতি হুঁ",
  "gender": "m",
  "tokens": [
    {"t": "میں", "bn": "আমি"},
    {"t": "روز", "bn": "রোজ, প্রতিদিন"},
    {"t": "سات بجے", "bn": "সাতটায়"},
    {"t": "اٹھتا", "bn": "উঠি (পুং)"},
    {"t": "ہوں", "bn": "হুঁ · আছি / করি (আমি)"}
  ],
  "speaker": "A"
}
```

| Field | Required | Rule |
|---|---|---|
| `type` | yes | `sound`, `letter`, `word`, `phrase`, `sentence`, `dialogue_line`, `pattern` |
| `target` | yes | Urdu script, as a native writes it, **without vowel marks** (زبر زیر پیش). No Latin letters, no Bangla letters, no brackets. The phone voice reads this text. Punctuation: `۔` `،` `؟` `!`. |
| `target_marked` | Stage 0 and A1: yes for `word`, `phrase`, `sentence`, `dialogue_line`, `pattern` | The same text with full vowel marks (plan decision 11.2). With the marks removed it must equal `target`. For `letter`/`sound` items it is optional. |
| `bn` | yes | A natural Bangla meaning. The Bangla voice reads it, so keep it short and clean. For a letter, a short note such as `"বে · ব ধ্বনি"`. |
| `bn_pron` | yes | The Urdu sound in Bangla script (decision 11.1). Use dot letters for new sounds: ق = ক়, خ = খ়, غ = গ়, ز ذ ض ظ = জ়, ف = ফ়, ژ = ঝ়. ں = ঁ (ম্যাঁয়, হাঁ). ہے = হ্যায়. The short "a" is written অ but means a flat "a" (ক়লম). |
| `variant_f` | when a first-person or second-person verb/adjective changes for a female speaker | The female version of `target` (decision 11.5). Leave it out when the sentence does not change. |
| `variant_f_pron` | with `variant_f` | `bn_pron` of the female version. |
| `gender` | for a noun `word` item | `m` or `f`. |
| `tokens` | yes for `word`, `phrase`, `sentence`, `dialogue_line`, `pattern` | Pieces of `target` in order (no marks). Joined together without spaces and punctuation they must equal `target` without spaces and punctuation. `bn` is a short Bangla gloss; for a postposition, a note such as `"کا · -র (পুং)"`. |
| `speaker` | `dialogue_line` only | `"A"` or `"B"`. |

The script builds the visible hint line:

- `target_marked · bn_pron` (when `target_marked` is present), else `bn_pron`
- plus ` · পুং` / ` · স্ত্রী` for a noun with `gender`

The female version is stored in the item's example slot. The app plays it instead of `target` when the learner chooses a female speaker. So **do not use an `example` field** in Urdu units.

## Content rules

1. Follow the plan: `Urdu-Spoken-Curriculum-Plan.md`, section 3 (the unit row and its notes), section 4 (lesson template) and section 5 (hard points).
2. Stage 0: only letters the learner has met by that lesson. Use shared Bangla–Urdu words first (کتاب, دوست, بازار).
3. Standard Urdu (Karachi/Lahore educated speech), polite آپ by default. Use تم only where a unit teaches it.
4. Every A1 lesson has, in this order:
   1. 2–3 `word` items (new vocabulary, nouns with `gender`),
   2. 2–4 `sentence` items (the new pattern),
   3. a 5–6 item `pattern` set: the drill of one lesson sentence. A1 does not teach the past (it starts in A2), so the A1 drill is:
      1. affirmative,
      2. negative (نہیں),
      3. question (کیا … ؟),
      4. the same sentence with آپ (respect form),
      5. the same sentence with تم (friendly form),
      6. from unit 1.14 only: the future (گا / گی).
      The female version is not a separate item: put it in `variant_f` of each pattern item that changes.
   4. from unit 1.10: 4 `dialogue_line` items (A/B role-play).
5. A Stage 0 letter lesson follows the sound practice loop: `letter` items for the new letters, then practice `word` items, then a near-sound contrast item where the plan names one.
6. 6–14 items per lesson.
7. Use Bangladeshi names and places (رحیم, کریم, فاطمہ, ڈھاکہ, چٹاگانگ, بنگلہ دیش) and real life of a Bangladeshi learner (work in the Gulf, study, shop, family).
8. Every item is a draft. A native Urdu reviewer and a Bangla reviewer must check it before release (plan section 8).
