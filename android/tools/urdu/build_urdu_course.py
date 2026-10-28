"""Builds the Urdu standard course (Zero to A1) asset from tools/urdu/units/*.json.

Usage:
    python tools/urdu/build_urdu_course.py          # check, then write the asset
    python tools/urdu/build_urdu_course.py --check  # check only

See UNIT_FORMAT.md for the unit file format.
"""
import json
import re
import sys
from pathlib import Path

HERE = Path(__file__).resolve().parent
UNITS_DIR = HERE / "units"
ASSET = HERE.parent.parent / "app" / "src" / "main" / "assets" / "spoken_urdu_standard_a1.json"

ID_PREFIX = "ur-std-"
TYPES = {"sound", "letter", "word", "phrase", "sentence", "dialogue_line", "pattern"}
NEEDS_TOKENS = {"word", "phrase", "sentence", "dialogue_line", "pattern"}
GENDER_LABEL = {"m": "পুং", "f": "স্ত্রী"}
MIN_ITEMS, MAX_ITEMS = 6, 14

ARABIC = re.compile(r"[؀-ۿ]")
LATIN = re.compile(r"[A-Za-z]")
BANGLA = re.compile(r"[ঀ-৿]")
BRACKETS = re.compile(r"[()（）\[\]]")
# Vowel marks (harakat), tanwin, shadda, sukun, superscript alef.
MARKS = re.compile(r"[ً-ْٰٖ-ٟ]")
# Spaces, tatweel, zero-width joiners and punctuation are ignored when tokens are compared with the target.
IGNORED = re.compile(r"[\sـ‌‍۔،؟!?.,:؛\-…]")


def unit_order(stem):
    stage, number = stem.split("-")
    return (0 if stage == "s0" else 1, int(number))


def check_text(where, label, text, errors):
    if not ARABIC.search(text):
        errors.append(f"{where}: {label} '{text}' has no Urdu letters")
    if LATIN.search(text) or BANGLA.search(text) or BRACKETS.search(text):
        errors.append(f"{where}: {label} '{text}' has Latin/Bangla letters or brackets (the voice reads them)")


def check_item(where, item, errors):
    kind = item.get("type")
    target = (item.get("target") or "").strip()
    if kind not in TYPES:
        errors.append(f"{where}: type '{kind}' is not one of {sorted(TYPES)}")
    if not target:
        errors.append(f"{where}: target is empty")
        return
    check_text(where, "target", target, errors)
    if MARKS.search(target):
        errors.append(f"{where}: target '{target}' has vowel marks; put them in target_marked")
    if "example" in item:
        errors.append(f"{where}: do not use 'example' in Urdu units (the slot holds variant_f)")
    for field in ("bn", "bn_pron"):
        if not (item.get(field) or "").strip():
            errors.append(f"{where}: {field} is empty")

    marked = (item.get("target_marked") or "").strip()
    if kind in NEEDS_TOKENS and not marked:
        errors.append(f"{where}: type '{kind}' needs target_marked (decision 11.2)")
    if marked and MARKS.sub("", marked).strip() != target:
        errors.append(f"{where}: target_marked without marks '{MARKS.sub('', marked)}' is not target '{target}'")

    variant = (item.get("variant_f") or "").strip()
    if variant:
        check_text(where, "variant_f", variant, errors)
        if variant == target:
            errors.append(f"{where}: variant_f is the same as target; leave it out")
        if not (item.get("variant_f_pron") or "").strip():
            errors.append(f"{where}: variant_f needs variant_f_pron")
    if item.get("gender") not in (None, "m", "f"):
        errors.append(f"{where}: gender must be 'm' or 'f'")
    if kind == "dialogue_line" and item.get("speaker") not in ("A", "B"):
        errors.append(f"{where}: dialogue_line needs speaker A or B")

    tokens = item.get("tokens") or []
    if kind in NEEDS_TOKENS and not tokens:
        errors.append(f"{where}: type '{kind}' needs tokens")
    if tokens:
        joined = "".join(t.get("t", "") for t in tokens)
        if IGNORED.sub("", MARKS.sub("", joined)) != IGNORED.sub("", target):
            errors.append(f"{where}: tokens '{joined}' do not match target '{target}'")
        for t in tokens:
            if not (t.get("t") or "").strip():
                errors.append(f"{where}: a token has no text")


def hint_line(item):
    parts = []
    marked = (item.get("target_marked") or "").strip()
    if marked and marked != item["target"].strip():
        parts.append(marked)
    parts.append(item["bn_pron"].strip())
    if item.get("gender") in GENDER_LABEL:
        parts.append(GENDER_LABEL[item["gender"]])
    return " · ".join(parts)


def build_item(stem, lesson_no, index, item):
    item_id = f"{ID_PREFIX}{stem}-l{lesson_no:02d}-{index:03d}"
    level = "A0" if stem.startswith("s0-") else "A1"
    out = {
        "id": item_id,
        "concept_id": f"c-{item_id}",
        "order": index,
        "type": item["type"],
        "level": level,
        "target": item["target"].strip(),
        "bn": item["bn"].strip(),
        "bn_pron": hint_line(item),
        "tokens": [{"t": t["t"], "bn": t.get("bn")} for t in item.get("tokens") or []],
        "tags": {"cefr": "PRE" if level == "A0" else "A1"},
        "status": "needs_review",
        "review_flags": [],
    }
    if item.get("target_marked"):
        out["target_marked"] = item["target_marked"].strip()
    if item.get("gender"):
        out["gender"] = item["gender"]
    if item.get("speaker"):
        out["speaker"] = item["speaker"]
    if item.get("variant_f"):
        # The app reads the female version from the example slot (decision 11.5).
        out["example"] = {"target": item["variant_f"].strip(), "bn": item["variant_f_pron"].strip()}
    return out


def main():
    check_only = "--check" in sys.argv
    files = sorted(UNITS_DIR.glob("*.json"), key=lambda p: unit_order(p.stem))
    if not files:
        sys.exit(f"No unit files in {UNITS_DIR}")

    errors = []
    parts = []
    for order, path in enumerate(files, start=1):
        stem = path.stem
        try:
            unit = json.loads(path.read_text(encoding="utf-8"))
        except json.JSONDecodeError as e:
            errors.append(f"{stem}: bad JSON: {e}")
            continue
        lessons = []
        for lesson_no, lesson in enumerate(unit.get("lessons") or [], start=1):
            items = lesson.get("items") or []
            if not MIN_ITEMS <= len(items) <= MAX_ITEMS:
                errors.append(f"{stem} lesson {lesson_no}: has {len(items)} items, needs {MIN_ITEMS}-{MAX_ITEMS}")
            for index, item in enumerate(items, start=1):
                check_item(f"{stem} l{lesson_no:02d} #{index}", item, errors)
            if not (lesson.get("title_bn") or "").strip():
                errors.append(f"{stem} lesson {lesson_no}: title_bn is empty")
            lessons.append((lesson_no, lesson, items))
        if not lessons:
            errors.append(f"{stem}: has no lessons")
        parts.append((order, stem, unit, lessons))

    if errors:
        print(f"{len(errors)} problem(s):")
        for e in errors:
            print("  " + e)
        sys.exit(1)

    lesson_total = sum(len(p[3]) for p in parts)
    item_total = sum(len(l[2]) for p in parts for l in p[3])
    print(f"OK: {len(parts)} units, {lesson_total} lessons, {item_total} items")
    if check_only:
        return

    course = {
        "schema_version": 1,
        "course": {
            "id": "ur-standard-zero-a1",
            "target_lang": "ur",
            "base_lang": "bn",
            "title_bn": "উর্দু স্ট্যান্ডার্ড কোর্স: শূন্য থেকে A1",
            "title_target": "اردو: صفر سے A1",
            "source": "Urdu-Spoken-Curriculum-Plan.md, roadmap phase 1 (Stage 0 + A1)",
            "note": "Draft content. A native Urdu reviewer and a Bangla reviewer must check every item before release.",
        },
        "ladder_default": [
            {"play": "target", "speed": 0.8},
            {"play": "bn", "speed": 1.15},
            {"play": "target", "speed": 0.9},
            {"play": "target", "speed": 1.0},
            {"pause_ms": 1200},
        ],
        "stats": {"lessons": lesson_total, "items": item_total},
        "parts": [
            {
                "id": f"{ID_PREFIX}{stem}",
                "order": order,
                "level": "A0" if stem.startswith("s0-") else "A1",
                "title_bn": unit.get("title_bn"),
                "title_target": unit.get("title_target"),
                "lessons": [
                    {
                        "id": f"{ID_PREFIX}{stem}-l{lesson_no:02d}",
                        "order": lesson_no,
                        "title_bn": lesson.get("title_bn"),
                        "title_target": lesson.get("title_target"),
                        "intro_bn": lesson.get("intro_bn"),
                        "structure": lesson.get("structure") or [],
                        "items": [build_item(stem, lesson_no, i, it) for i, it in enumerate(items, start=1)],
                    }
                    for lesson_no, lesson, items in lessons
                ],
            }
            for order, stem, unit, lessons in parts
        ],
    }
    ASSET.write_text(json.dumps(course, ensure_ascii=False, indent=1) + "\n", encoding="utf-8")
    print(f"Wrote {ASSET}")


if __name__ == "__main__":
    main()
