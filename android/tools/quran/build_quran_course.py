"""Compiles the complete Easy Quran Learning Course into standard ESCB schema_version: 1 JSON."""
import json
import os
import re
import sys
from pathlib import Path

script_dir = os.path.dirname(os.path.abspath(__file__))
generators_dir = os.path.join(script_dir, "generators")
sys.path.insert(0, generators_dir)

import data_quran_p1_letters_harakat
import data_quran_p2_sukun_tashdeed
import data_quran_p3_tajweed_rules
import data_quran_p4_surahs_duas

IGNORED = re.compile(r"[\s\u200c\u200d\u0640।॥,?!.,:;'\-—…\"“”()\[\]]")
ARABIC = re.compile(r"[\u0600-\u06FF]")

raw_units = (
    data_quran_p1_letters_harakat.UNITS_QURAN_P1 +
    data_quran_p2_sukun_tashdeed.UNITS_QURAN_P2 +
    data_quran_p3_tajweed_rules.UNITS_QURAN_P3 +
    data_quran_p4_surahs_duas.UNITS_QURAN_P4
)

def make_item(stem, lesson_no, index, item_data):
    target, bn, bn_pron, tokens = item_data
    target = target.strip()
    joined = "".join(t["t"] for t in tokens)
    cleaned_joined = IGNORED.sub("", joined)
    cleaned_target = IGNORED.sub("", target)

    if cleaned_joined != cleaned_target:
        raise ValueError(f"Token mismatch in {stem} l{lesson_no} #{index}: '{cleaned_joined}' != '{cleaned_target}'")

    if not ARABIC.search(target):
        raise ValueError(f"No Arabic letters in {stem} l{lesson_no} #{index}: '{target}'")

    item_id = f"{stem}-l{lesson_no:02d}-{index:03d}"
    out = {
        "id": item_id,
        "concept_id": f"c-{item_id}",
        "order": index,
        "type": "quran_verse",
        "level": "A1",
        "target": target,
        "bn": bn.strip(),
        "bn_pron": bn_pron.strip().replace('\u0964', '\u09F7'),
        "tokens": [{"t": t["t"], "bn": t.get("bn")} for t in tokens],
        "tags": {"course": "quran_noorani", "unit": stem},
        "status": "ready",
        "review_flags": []
    }
    return out

def build_course():
    parts = []
    total_lessons = 0
    total_items = 0

    for u_idx, u in enumerate(raw_units, start=1):
        stem = u["id"]
        lessons = []
        for l_idx, lesson_def in enumerate(u["lessons"], start=1):
            items = []
            for item_idx, raw_item in enumerate(lesson_def["items"], start=1):
                item = make_item(stem, l_idx, item_idx, raw_item)
                items.append(item)
                total_items += 1

            lesson_id = f"{stem}-l{l_idx:02d}"
            lessons.append({
                "id": lesson_id,
                "order": l_idx,
                "level": "A1",
                "title": lesson_def["title_target"],
                "title_bn": lesson_def["title_bn"],
                "intro_bn": lesson_def.get("intro_bn", ""),
                "structure": lesson_def.get("structure", []),
                "items": items
            })
            total_lessons += 1

        parts.append({
            "id": stem,
            "order": u_idx,
            "level": "A1",
            "title": u["part_title"],
            "title_bn": u["unit_title"],
            "enabled": True,
            "lessons": lessons
        })

    course = {
        "schema_version": 1,
        "course_id": "quran_learning_noorani_complete",
        "title": "সহজে কুরআন শিক্ষা ও তাজবীদ",
        "title_bn": "নূরানী কায়দা থেকে সহীহ তিলাওয়াত ও নামাজের ছোট সূরা",
        "target_lang": "ar",
        "ladder_default": [
            {"play": "ar", "speed": 0.72},
            {"play": "bn", "speed": 0.95},
            {"play": "ar", "speed": 0.88},
            {"pause": 2000}
        ],
        "parts": parts
    }

    out_path = os.path.join(script_dir, "..", "..", "app", "src", "main", "assets", "quran_learning_noorani_complete.json")
    out_path = os.path.abspath(out_path)
    os.makedirs(os.path.dirname(out_path), exist_ok=True)

    with open(out_path, "w", encoding="utf-8") as f:
        json.dump(course, f, ensure_ascii=False, indent=2)

    print(f"Successfully compiled Quran Learning Course:")
    print(f"  Target File: {out_path}")
    print(f"  Total Parts: {len(parts)}")
    print(f"  Total Lessons: {total_lessons}")
    print(f"  Total Items: {total_items}")
    file_size_kb = os.path.getsize(out_path) / 1024
    print(f"  Output Size: {file_size_kb:.1f} KB")

if __name__ == "__main__":
    build_course()

