"""Builds the Japanese standard course (Zero to N5) asset from tools/japanese/units/*.json.

Usage:
    python tools/japanese/build_standard_course.py          # check, then write the asset
    python tools/japanese/build_standard_course.py --check  # check only

See UNIT_FORMAT.md for the unit file format.
"""
import json
import re
import sys
from pathlib import Path

HERE = Path(__file__).resolve().parent
UNITS_DIR = HERE / "units"
ASSET = HERE.parent.parent / "app" / "src" / "main" / "assets" / "spoken_japanese_standard_n5.json"

ID_PREFIX = "jp-std-"
TYPES = {"sound", "kana", "word", "phrase", "sentence", "dialogue_line", "pattern"}
NEEDS_TOKENS = {"word", "phrase", "sentence", "dialogue_line", "pattern"}
# Romaji is shown by default only in units 0.1-0.3 (plan section 11.1).
ROMAJI_UNITS = {"s0-01", "s0-02", "s0-03"}

KANJI = re.compile(r"[一-鿿々]")
LATIN = re.compile(r"[A-Za-z]")
BRACKETS = re.compile(r"[()（）\[\]]")
# Spaces and punctuation are ignored when tokens are compared with the target.
IGNORED = re.compile(r"[\s。、．，,.!！?？「」『』・〜~…ー―\-]")
# The long-vowel mark is a real sound in katakana words, so keep it inside tokens.
IGNORED_KEEP_CHOON = re.compile(r"[\s。、．，,.!！?？「」『』・〜~…―\-]")


def unit_order(stem):
    stage, number = stem.split("-")
    return (0 if stage == "s0" else 1, int(number))


def check_item(where, item, errors):
    kind = item.get("type")
    target = (item.get("target") or "").strip()
    if kind not in TYPES:
        errors.append(f"{where}: type '{kind}' is not one of {sorted(TYPES)}")
    if not target:
        errors.append(f"{where}: target is empty")
    if LATIN.search(target) or BRACKETS.search(target):
        errors.append(f"{where}: target '{target}' has Latin letters or brackets (the voice reads them)")
    if not (item.get("bn") or "").strip():
        errors.append(f"{where}: bn is empty")
    if not (item.get("bn_pron") or "").strip():
        errors.append(f"{where}: bn_pron is empty")
    if KANJI.search(target) and not (item.get("reading") or "").strip():
        errors.append(f"{where}: target '{target}' has kanji but no reading")
    if where.startswith("s0-"):
        if KANJI.search(target):
            errors.append(f"{where}: Stage 0 must not use kanji ('{target}')")
        if not (item.get("romaji") or "").strip():
            errors.append(f"{where}: Stage 0 item needs romaji")
    if kind == "dialogue_line" and item.get("speaker") not in ("A", "B"):
        errors.append(f"{where}: dialogue_line needs speaker A or B")

    tokens = item.get("tokens") or []
    if kind in NEEDS_TOKENS and not tokens:
        errors.append(f"{where}: type '{kind}' needs tokens")
    if tokens:
        joined = "".join(t.get("t", "") for t in tokens)
        if IGNORED_KEEP_CHOON.sub("", joined) != IGNORED_KEEP_CHOON.sub("", target) and \
                IGNORED.sub("", joined) != IGNORED.sub("", target):
            errors.append(f"{where}: tokens '{joined}' do not match target '{target}'")
        for t in tokens:
            if not (t.get("t") or "").strip():
                errors.append(f"{where}: a token has no text")


def hint_line(stem, item):
    pron = item["bn_pron"].strip()
    if stem in ROMAJI_UNITS and item.get("romaji"):
        return f"{item['romaji'].strip()} · {pron}"
    reading = (item.get("reading") or "").strip()
    if stem.startswith("n5-") and reading and KANJI.search(item["target"]):
        return f"{reading} · {pron}"
    return pron


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
        "bn_pron": hint_line(stem, item),
        "tokens": [{"t": t["t"], "bn": t.get("bn")} for t in item.get("tokens") or []],
        "tags": {"jlpt": "PRE" if level == "A0" else "N5"},
        "status": "needs_review",
        "review_flags": [],
    }
    if item.get("romaji"):
        out["romaji"] = item["romaji"].strip()
    if item.get("reading"):
        out["reading"] = item["reading"].strip()
    if item.get("speaker"):
        out["speaker"] = item["speaker"]
    example = item.get("example")
    if example and example.get("target"):
        out["example"] = {"target": example["target"].strip(), "bn": (example.get("bn") or "").strip() or None}
    return out


def main():
    check_only = "--check" in sys.argv
    files = sorted(UNITS_DIR.glob("*.json"), key=lambda p: unit_order(p.stem))
    if not files:
        sys.exit(f"No unit files in {UNITS_DIR}")

    errors = []
    parts = []
    lesson_total = 0
    item_total = 0
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
            if not 6 <= len(items) <= 12:
                errors.append(f"{stem} lesson {lesson_no}: has {len(items)} items, needs 6-12")
            for index, item in enumerate(items, start=1):
                check_item(f"{stem} l{lesson_no:02d} #{index}", item, errors)
            if not (lesson.get("title_bn") or "").strip():
                errors.append(f"{stem} lesson {lesson_no}: title_bn is empty")
            lessons.append({
                "id": f"{ID_PREFIX}{stem}-l{lesson_no:02d}",
                "order": lesson_no,
                "title_bn": lesson.get("title_bn"),
                "title_target": lesson.get("title_target"),
                "intro_bn": lesson.get("intro_bn"),
                "structure": lesson.get("structure") or [],
                "items": [],
                "_raw": items,
            })
        if not lessons:
            errors.append(f"{stem}: has no lessons")
        parts.append({
            "id": f"{ID_PREFIX}{stem}",
            "order": order,
            "level": "A0" if stem.startswith("s0-") else "A1",
            "title_bn": unit.get("title_bn"),
            "title_target": unit.get("title_target"),
            "lessons": lessons,
            "_stem": stem,
        })

    if errors:
        print(f"{len(errors)} problem(s):")
        for e in errors:
            print("  " + e)
        sys.exit(1)

    for part in parts:
        stem = part.pop("_stem")
        for lesson in part["lessons"]:
            raw = lesson.pop("_raw")
            lesson["items"] = [build_item(stem, lesson["order"], i, it) for i, it in enumerate(raw, start=1)]
            lesson_total += 1
            item_total += len(raw)

    print(f"OK: {len(parts)} units, {lesson_total} lessons, {item_total} items")
    if check_only:
        return

    course = {
        "schema_version": 1,
        "course": {
            "id": "jp-standard-zero-n5",
            "target_lang": "ja",
            "base_lang": "bn",
            "title_bn": "জাপানিজ স্ট্যান্ডার্ড কোর্স: শূন্য থেকে N5",
            "title_target": "Standard Japanese: Zero to N5",
            "source": "Japanese-Spoken-Curriculum-Plan.md, roadmap phase 1 (Stage 0 + N5)",
            "note": "Draft content. A native Japanese reviewer and a Bangla reviewer must check every item before release.",
        },
        "ladder_default": [
            {"play": "target", "speed": 0.8},
            {"play": "bn", "speed": 1.15},
            {"play": "target", "speed": 0.9},
            {"play": "target", "speed": 1.0},
            {"pause_ms": 1200},
        ],
        "stats": {"lessons": lesson_total, "items": item_total},
        "parts": parts,
    }
    ASSET.write_text(json.dumps(course, ensure_ascii=False, indent=1) + "\n", encoding="utf-8")
    print(f"Wrote {ASSET}")


if __name__ == "__main__":
    main()
