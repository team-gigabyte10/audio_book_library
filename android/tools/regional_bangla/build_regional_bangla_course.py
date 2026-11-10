"""Compiles all 8 Bangladeshi Division Regional Spoken Courses into standard ESCB schema_version: 1 JSON."""
import json
import os
import re
import sys
from pathlib import Path

script_dir = os.path.dirname(os.path.abspath(__file__))
generators_dir = os.path.join(script_dir, "generators")
sys.path.insert(0, generators_dir)

import data_ctg_syl_u01_u10
import data_dhk_bar_u11_u20
import data_raj_rng_u21_u30
import data_khl_mym_u31_u40

IGNORED = re.compile(r"[\s\u200c\u200d।॥,?!.,:;'\-—…\"“”]")
BENGALI = re.compile(r"[\u0980-\u09FF]")

raw_units = (
    data_ctg_syl_u01_u10.UNITS_CTG_SYL_U01_U10 +
    data_dhk_bar_u11_u20.UNITS_DHK_BAR_U11_U20 +
    data_raj_rng_u21_u30.UNITS_RAJ_RNG_U21_U30 +
    data_khl_mym_u31_u40.UNITS_KHL_MYM_U31_U40
)

def make_item(stem, lesson_no, index, item_data):
    target, bn, bn_pron, tokens = item_data
    target = target.strip()
    joined = "".join(t["t"] for t in tokens)
    cleaned_joined = IGNORED.sub("", joined)
    cleaned_target = IGNORED.sub("", target)

    if cleaned_joined != cleaned_target:
        raise ValueError(f"Token mismatch in {stem} l{lesson_no} #{index}: '{cleaned_joined}' != '{cleaned_target}'")

    if not BENGALI.search(target):
        raise ValueError(f"No Bengali letters in {stem} l{lesson_no} #{index}: '{target}'")

    item_id = f"{stem}-l{lesson_no:02d}-{index:03d}"
    out = {
        "id": item_id,
        "concept_id": f"c-{item_id}",
        "order": index,
        "type": "sentence",
        "level": "A1",
        "target": target,
        "bn": bn.strip(),
        "bn_pron": bn_pron.strip().replace('\u0964', '\u09F7'),
        "tokens": [{"t": t["t"], "bn": t.get("bn")} for t in tokens],
        "tags": {"division": stem, "category": "regional_spoken"},
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
        "course_id": "spoken_bangla_regional_divisions",
        "title": "বাংলাদেশের বিভাগীয় আঞ্চলিক ভাষা",
        "title_bn": "৮টি বিভাগীয় আঞ্চলিক কথ্য ভাষা ও উপভাষা স্পোকেন কোর্স",
        "target_lang": "bd",
        "ladder_default": [
            {"play": "bd", "speed": 0.85},
            {"play": "bn", "speed": 1.0},
            {"play": "bd", "speed": 0.95},
            {"play": "bd", "speed": 1.1},
            {"pause": 1500}
        ],
        "parts": parts
    }

    out_path = os.path.join(script_dir, "..", "..", "app", "src", "main", "assets", "spoken_bangla_regional_divisions.json")
    out_path = os.path.abspath(out_path)
    os.makedirs(os.path.dirname(out_path), exist_ok=True)

    with open(out_path, "w", encoding="utf-8") as f:
        json.dump(course, f, ensure_ascii=False, indent=2)

    print(f"Successfully compiled Regional Spoken Course:")
    print(f"  Target File: {out_path}")
    print(f"  Total Parts / Units: {len(parts)}")
    print(f"  Total Lessons: {total_lessons}")
    print(f"  Total Items: {total_items}")
    file_size_kb = os.path.getsize(out_path) / 1024
    print(f"  Output Size: {file_size_kb:.1f} KB")

if __name__ == "__main__":
    build_course()
