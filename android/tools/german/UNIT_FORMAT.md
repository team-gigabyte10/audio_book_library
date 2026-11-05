# German standard course: unit file format

Source files for the course "Zero to A1" (Phase 1 of `German-Spoken-Curriculum-Plan.md`).
The build script `build_german_course.py` reads every file in `units/`, checks it,
and writes `app/src/main/assets/spoken_german_standard_a1.json`.

Do not edit the asset by hand. Edit a unit file, then run:

```
python tools/german/build_german_course.py          # check + build
python tools/german/build_german_course.py --check  # check only
```

## File names

One file per unit:

- Stage 0: `units/s0-01.json` … `units/s0-10.json` (plan units 0.1 … 0.10)
- A1: `units/a1-01.json` … `units/a1-15.json` (plan units 1.1 … 1.15)

The script makes all IDs from the file name and the order. Do not write IDs.

## Unit file

```json
{
  "unit": "1.1",
  "title_bn": "প্রথম পরিচয় ও অভিবাদন",
  "title_target": "Begrüßung und Kennenlernen",
  "lessons": [
    {
      "title_bn": "আমার নাম ও পরিচয়: Ich heiße...",
      "title_target": "Sich vorstellen",
      "intro_bn": "জার্মান ভাষায় নিজের পরিচয় দিতে 'Ich heiße...' (আমার নাম...) বা 'Ich bin...' (আমি হই...) ব্যবহার করা হয়।",
      "structure": ["Ich heiße [Name]. · আমার নাম [নাম]।", "Ich komme aus Bangladesch. · আমি বাংলাদেশ থেকে এসেছি।"],
      "items": [ ... ]
    }
  ]
}
```

## Item

```json
{
  "type": "sentence",
  "target": "Ich lerne jeden Tag Deutsch.",
  "bn": "আমি প্রতিদিন জার্মান ভাষা শিখছি।",
  "bn_pron": "ইশ ল্যার্নে ইয়েদেন টাগ ডয়চ।",
  "tokens": [
    {"t": "Ich", "bn": "আমি"},
    {"t": "lerne", "bn": "শিখছি"},
    {"t": "jeden Tag", "bn": "প্রতিদিন"},
    {"t": "Deutsch", "bn": "জার্মান ভাষা"}
  ]
}
```

| Field | Required | Rule |
|---|---|---|
| `type` | yes | `sound`, `letter`, `word`, `phrase`, `sentence`, `dialogue_line`, `pattern` |
| `target` | yes | Standard German orthography (Latin alphabet + `ä, ö, ü, Ä, Ö, Ü, ß`), proper German noun capitalization, and punctuation (`. , ? ! -`). No ASCII digits (write *eins, zwei, drei*). No Bangla or brackets in `target`. |
| `bn` | yes | Natural Bengali meaning. |
| `bn_pron` | yes | Bengali phonetic pronunciation hint capturing German sounds, umlauts, and vocalic `-er` endings. |
| `gender` | for noun `word` items | `"m"` (*der*), `"f"` (*die*), or `"n"` (*das*). |
| `tokens` | yes for `word`, `phrase`, `sentence`, `dialogue_line`, `pattern` | Pieces of `target` in order. Joined together without spaces and punctuation they must equal `target` without spaces and punctuation. `bn` is a short Bengali gloss. |
| `speaker` | `dialogue_line` only | `"A"` or `"B"`. |

The script builds the visible hint line:
- `bn_pron`
- plus ` · পুং (der)` / ` · স্ত্রী (die)` / ` · ক্লীব (das)` for a noun with `gender`

## Content rules

1. Follow the plan: `German-Spoken-Curriculum-Plan.md`, section 3 (unit sequence), section 4 (lesson template), and section 5 (contrast points).
2. Standard Hochdeutsch (standard German pronunciation as spoken in Germany).
3. Stage 0: 10 units, 45 lessons covering sounds, umlauts, diphthongs, numbers, greetings, and *Sie / du* etiquette.
4. Level A1: 15 units, 60 lessons aligned with Goethe Start Deutsch 1.
5. 6–14 items per lesson (aim for 8–12 items).
6. Every item is a draft (`needs_review`). A native German reviewer and a Bengali reviewer must check it before release.

