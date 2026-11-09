# English Standard Course: Unit & Generator Format

Source generator and unit specifications for the Spoken English Curriculum (`android/English-Spoken-Curriculum-Plan.md`).
The build scripts compile structured unit data into production assets:
- `app/src/main/assets/spoken_english_standard_a1.json`
- `app/src/main/assets/spoken_english_standard_a2.json`
- `app/src/main/assets/spoken_english_standard_b1.json`
- `app/src/main/assets/spoken_english_standard_b2.json`
- `app/src/main/assets/spoken_english_specialist_pro.json`

Do not hand-edit the generated assets directly. Author data modules in `android/tools/english/generators/` and run the build script:

```bash
python tools/english/build_english_a1_course.py
python tools/english/verify_a1_asset.py
```

## Structure Per Level
- **16 Units (Parts):** `en-a1-01` through `en-a1-16`
- **4 Lessons per Unit:** e.g., `en-a1-01-l01` through `en-a1-01-l04` (64 lessons per level)
- **8 Items per Lesson:** (512 items per level)

## Item Schema

```python
{
    "type": "sentence",
    "target": "Where do you work?",
    "bn": "আপনি কোথায় কাজ করেন?",
    "bn_pron": "হোয়্যার ডু ইউ ওয়ার্ক?",
    "tokens": [
        {"target": "Where", "bn": "কোথায়"},
        {"target": "do", "bn": "করেন"},
        {"target": "you", "bn": "আপনি"},
        {"target": "work?", "bn": "কাজ?"}
    ]
}
```

### Invariants:
1. **Token Invariant:** `clean(" ".join(t["target"] for t in tokens)) == clean(target)` must hold 100%.
2. **Bengali Pronunciation (`bn_pron`):**
   - Precise Bengali representation of English phonetics with correct stress.
   - V / W distinction: `V` = 'ভ়', `W` = 'ওয়'.
   - S / Sh distinction: `S` = 'স', `Sh` = 'শ'.
   - Th sounds: /θ/ = 'থ়', /ð/ = 'দ়'.
   - Z sound: /z/ = 'জ়'.
   - Reduced forms and sentence stress captured accurately.

