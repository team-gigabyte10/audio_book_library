# Hindi standard course: unit file format

Source files for the course "Zero to A1" (Phase 1 of `Hindi-Spoken-Curriculum-Plan.md`).
The build script `build_hindi_course.py` reads every file in `units/`, checks it,
and writes `app/src/main/assets/spoken_hindi_standard_a1.json`.

Do not edit the asset by hand. Edit a unit file, then run:

```
python tools/hindi/build_hindi_course.py          # check + build
python tools/hindi/build_hindi_course.py --check  # check only
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
  "title_target": "रोज़मर्रा के काम",
  "lessons": [
    {
      "title_bn": "আমি প্রতিদিন উঠি: उठता / उठती हूँ",
      "title_target": "उठता हूँ",
      "intro_bn": "Short Bangla explanation for the learner (2–4 sentences).",
      "structure": ["मैं … ता हूँ। · আমি … করি (পুরুষ)", "मैं … ती हूँ। · আমি … করি (নারী)"],
      "items": [ ... ]
    }
  ]
}
```

## Item

```json
{
  "type": "sentence",
  "target": "मैं रोज़ सात बजे उठता हूँ।",
  "bn": "আমি প্রতিদিন সাতটায় উঠি।",
  "bn_pron": "ম্যাঁয় রোজ় সাত বজে উঠতা হুঁ",
  "variant_f": "मैं रोज़ सात बजे उठती हूँ।",
  "variant_f_pron": "ম্যাঁয় রোজ় সাত বজে উঠতী হুঁ",
  "gender": "m",
  "tokens": [
    {"t": "मैं", "bn": "আমি"},
    {"t": "रोज़", "bn": "রোজ, প্রতিদিন"},
    {"t": "सात बजे", "bn": "সাতটায়"},
    {"t": "उठता", "bn": "উঠি (পুং)"},
    {"t": "हूँ", "bn": "হুঁ · আছি / করি (আমি)"}
  ],
  "speaker": "A"
}
```

| Field | Required | Rule |
|---|---|---|
| `type` | yes | `sound`, `letter`, `word`, `phrase`, `sentence`, `dialogue_line`, `pattern` |
| `target` | yes | Devanagari script, as a native writes it. No Latin letters, no Bangla letters, no brackets. The phone voice (`hi-IN`) reads this text. Punctuation: `।` `,` `?` `!`. |
| `bn` | yes | A natural Bangla meaning. The Bangla voice reads it, so keep it short and clean. For a letter, a short note such as `"ক · ক ধ্বনি (অল্পপ্রাণ)"`. |
| `bn_pron` | yes | The Hindi sound in Bangla script (decision 11.1), reflecting schwa deletion (e.g. `कमल` = `কমল`, `कमरा` = `কম্‌রা`). Use dot letters for nuqta sounds: क़ = ক়, ख़ = খ়, ग़ = গ়, ज़ = জ়, फ़ = ফ়. चंद्रबिंदु/अनुस्वार = ঁ (ম্যাঁয়, হাঁ, হুঁ). है = হ্যায়, हैं = হ্যাঁয়. |
| `variant_f` | when a first-person or second-person verb/adjective changes for a female speaker/listener | The female version of `target` (decision 11.3). Leave it out when the sentence does not change. |
| `variant_f_pron` | with `variant_f` | `bn_pron` of the female version. |
| `gender` | for a noun `word` item | `m` or `f`. |
| `tokens` | yes for `word`, `phrase`, `sentence`, `dialogue_line`, `pattern` | Pieces of `target` in order. Joined together without spaces and punctuation they must equal `target` without spaces and punctuation. `bn` is a short Bangla gloss; for a postposition, a note such as `"का · -র (পুং)"`. |
| `speaker` | `dialogue_line` only | `"A"` or `"B"`. |

The script builds the visible hint line:

- `bn_pron`
- plus ` · পুং` / ` · স্ত্রী` for a noun with `gender`

The female version is stored in the item's example slot. The app plays it instead of `target` when the learner chooses a female speaker. So **do not use an `example` field** in Hindi units.

## Content rules

1. Follow the plan: `Hindi-Spoken-Curriculum-Plan.md`, section 3 (the unit row and its notes), section 4 (lesson template) and section 5 (hard points).
2. Stage 0: build systematically from vowels and matras to consonant vargas, conjuncts, nuqta, shared words/false friends, and survival phrases.
3. Standard spoken Hindi, polite `आप` by default. Use `तुम` and `तू` where a unit teaches or drills them.
4. Every A1 lesson has, in this order:
   1. 2–3 `word` items (new vocabulary, nouns with `gender`),
   2. 2–4 `sentence` items (the new pattern),
   3. a 5–6 item `pattern` set: the drill of one lesson sentence (affirmative, negative `नहीं`, question `क्या … ?`, respect form with `आप`, friendly form with `तुम`, and from unit 1.14 the future `गा / गी`). Put the female version in `variant_f` of each pattern item that changes.
   4. from unit 1.10: 4 `dialogue_line` items (A/B role-play).
5. 6–14 items per lesson.
6. Use Bangladeshi and South Asian names and places (`रहीम, करीम, फ़ातिमा, राहुल, प्रिया, ढाका, चटगाँव, कोलकाता, दिल्ली, बांग्लादेश, भारत`) and real life of a Bangladeshi learner (travel, hospitals, shopping, business, family).
7. Every item is a draft (`needs_review`). A native Hindi reviewer and a Bangla reviewer must check it before release (plan section 8).

