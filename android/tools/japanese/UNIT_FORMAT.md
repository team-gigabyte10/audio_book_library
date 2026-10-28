# Japanese standard course: unit file format

Source files for the course "Zero to N5" (Phase 1 of `Japanese-Spoken-Curriculum-Plan.md`).
The build script `build_standard_course.py` reads every file in `units/`, checks it,
and writes `app/src/main/assets/spoken_japanese_standard_n5.json`.

Do not edit the asset by hand. Edit a unit file, then run:

```
python tools/japanese/build_standard_course.py          # check + build
python tools/japanese/build_standard_course.py --check  # check only
```

## File names

One file per unit:

- Stage 0: `units/s0-01.json` … `units/s0-10.json` (plan units 0.1 … 0.10)
- N5: `units/n5-01.json` … `units/n5-15.json` (plan units 5.1 … 5.15)

The script makes all IDs from the file name and the order. Do not write IDs.

## Unit file

```json
{
  "unit": "0.2",
  "title_bn": "হিরাগানা あ・か・さ・た・な সারি",
  "title_target": "Hiragana rows a, ka, sa, ta, na",
  "lessons": [
    {
      "title_bn": "あ সারি: あ い う え お",
      "title_target": "The a row",
      "intro_bn": "Short Bangla explanation for the learner (2–4 sentences).",
      "structure": ["あ a · আ", "い i · ই"],
      "items": [ ... ]
    }
  ]
}
```

## Item

```json
{
  "type": "word",
  "target": "ねこ",
  "reading": "ねこ",
  "romaji": "neko",
  "bn": "বিড়াল",
  "bn_pron": "নেকো",
  "tokens": [{"t": "ね", "bn": "নে"}, {"t": "こ", "bn": "কো"}],
  "speaker": "A",
  "example": {"target": "ねこが います。", "bn": "একটি বিড়াল আছে।"}
}
```

| Field | Required | Rule |
|---|---|---|
| `type` | yes | `sound`, `kana`, `word`, `phrase`, `sentence`, `dialogue_line`, `pattern` |
| `target` | yes | Japanese only, as a native writes it. **No romaji, no Latin letters, no brackets.** The phone voice reads this text aloud. Use `。` `、` `？` for punctuation. |
| `reading` | if `target` has kanji | The full reading in hiragana/katakana. |
| `romaji` | Stage 0: yes. N5: optional | Hepburn romaji (`shi`, `chi`, `tsu`, `fu`, `ō` → write `ou`/`oo` as kana spells it). |
| `bn` | yes | A natural Bangla meaning. The Bangla voice reads it aloud, so keep it short and clean. For a sound item, give a short Bangla note, for example `"কা ধ্বনি"`. |
| `bn_pron` | yes | The Japanese sound in Bangla script, for example `নেকো`. Use the plan's notes: た/だ = ত/দ, す = স (not শ), ず = জ়, つ = ৎসু, ふ = ফু (soft), ら = র (one tap), long vowel = ‑আ/‑ঈ/‑উ, small っ = a double consonant (きって = কিত্তে). |
| `tokens` | yes for `word`, `phrase`, `sentence`, `dialogue_line`, `pattern` | Each `t` is a piece of `target`, in order. Joined together (without spaces and punctuation) they must equal `target` without spaces and punctuation. `bn` is the gloss: for a kana piece its Bangla sound, for a word its meaning, for a particle a short note, for example `"は · বিষয় চিহ্ন"`. |
| `speaker` | `dialogue_line` only | `"A"` or `"B"`. |
| `example` | optional | One short example sentence that uses the item. |

The script builds the visible hint line from these fields (plan section 11.1 and 11.2):

- Units 0.1–0.3: `romaji · bn_pron`
- Units 0.4–0.10: `bn_pron`
- N5: `reading · bn_pron` when the target has kanji, else `bn_pron`

## Content rules

1. Follow the plan: `Japanese-Spoken-Curriculum-Plan.md`, section 3 (the unit row and its notes) and section 4 (lesson template).
2. Use only kana that the learner has met. Stage 0 has no kanji. N5 uses N5 kanji only.
3. Polite style (です・ます) in N5, except where a unit teaches something else.
4. Every N5 lesson has, in this order:
   1. 2–3 `word` items (new vocabulary),
   2. 3–5 `sentence` items (the new pattern),
   3. a 4–5 item `pattern` set: the 6-way drill of one lesson sentence: polite affirmative, polite negative, polite past, polite past negative, question (plain form starts in N4, so skip it),
   4. from unit 5.10: 4–6 `dialogue_line` items (A/B role-play).
5. A Stage 0 letter lesson follows the sound practice loop: `sound`/`kana` items for the new letters, then 5 practice `word` items, then a near-sound contrast item where the plan names one.
6. 6–12 items per lesson.
7. Use Bangladeshi names and places where a name is needed (ラヒム, カリム, ダッカ, チッタゴン).
8. Every item is a draft. A native Japanese reviewer and a Bangla reviewer must check it before release (plan section 8).
