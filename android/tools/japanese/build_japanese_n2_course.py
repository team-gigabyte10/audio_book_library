# -*- coding: utf-8 -*-
"""Compiles Level N2 (Units jp-n2-01 to jp-n2-16) for Japanese Spoken Course."""
import json
import os
import re
import sys
from pathlib import Path

script_dir = Path(__file__).resolve().parent
generators_dir = script_dir / "generators"
sys.path.insert(0, str(generators_dir))

import data_n2_u01_u04
import data_n2_u05_u08
import data_n2_u09_u12
import data_n2_u13_u16

ASSET_PATH = script_dir.parent.parent / "app" / "src" / "main" / "assets" / "spoken_japanese_standard_n2.json"

KANJI = re.compile(r"[一-鿿々]")
LATIN = re.compile(r"[A-Za-z]")
DIGIT = re.compile(r"[0-9]")
IGNORED = re.compile(r"[\s。、．，,.!！?？「」『』・〜~…ー―\-]+")

raw_units = (
    data_n2_u01_u04.UNITS_N2_U01_U04 +
    data_n2_u05_u08.UNITS_N2_U05_U08 +
    data_n2_u09_u12.UNITS_N2_U09_U12 +
    data_n2_u13_u16.UNITS_N2_U13_U16
)

def hint_line(target, reading, pron):
    pron = pron.strip()
    reading = (reading or "").strip()
    if reading and KANJI.search(target):
        return f"{reading} · {pron}"
    return pron

def make_item(part_id, lesson_no, index, item_data):
    target, reading, bn, bn_pron, tokens, gender, alt_t, alt_r, alt_p = item_data
    target = target.strip()
    reading = (reading or "").strip()
    bn = bn.strip()
    bn_pron = bn_pron.strip()

    joined = "".join(t["t"] for t in tokens)
    clean_joined = IGNORED.sub("", joined)
    clean_target = IGNORED.sub("", target)

    if clean_joined != clean_target:
        raise ValueError(f"Token mismatch in {part_id} l{lesson_no} #{index}:\n  '{clean_joined}' !=\n  '{clean_target}'")

    if LATIN.search(target):
        raise ValueError(f"Latin characters in {part_id} l{lesson_no} #{index}: '{target}'")
    if DIGIT.search(target):
        raise ValueError(f"ASCII digits in {part_id} l{lesson_no} #{index}: '{target}'")
    if KANJI.search(target) and not reading:
        raise ValueError(f"Kanji without reading in {part_id} l{lesson_no} #{index}: '{target}'")

    item_id = f"{part_id}-l{lesson_no:02d}-{index:03d}"
    out = {
        "id": item_id,
        "concept_id": f"c-{item_id}",
        "order": index,
        "type": "sentence",
        "level": "B2",
        "target": target,
        "reading": reading,
        "bn": bn,
        "bn_pron": hint_line(target, reading, bn_pron),
        "tokens": [{"t": t["t"], "bn": t.get("m") or t.get("bn", "")} for t in tokens],
        "tags": {"jlpt": "N2"},
        "status": "ready",
        "review_flags": []
    }
    if gender:
        out["gender"] = gender
    if alt_t:
        out["alt_target"] = alt_t
        out["alt_reading"] = alt_r
        out["alt_bn_pron"] = hint_line(alt_t, alt_r, alt_p)
    return out

def main():
    print(f"Total raw parts to build: {len(raw_units)}")
    built_parts = []
    total_lessons = 0
    total_items = 0

    for p_idx, unit in enumerate(raw_units, 1):
        unit_id = unit["unit_id"]
        title_bn = unit.get("title_bn") or unit.get("title")
        title_target = unit.get("title_target") or unit.get("subtitle")
        lessons = unit["lessons"]

        built_lessons = []
        for l_idx, lesson in enumerate(lessons, 1):
            total_lessons += 1
            lesson_id = f"{unit_id}-l{l_idx:02d}"
            built_items = []
            for i_idx, item_data in enumerate(lesson["items"], 1):
                total_items += 1
                built_items.append(make_item(unit_id, l_idx, i_idx, item_data))

            built_lessons.append({
                "id": lesson_id,
                "order": l_idx,
                "title_bn": lesson.get("title_bn") or lesson.get("title"),
                "title_target": lesson.get("title_target") or f"Lesson {l_idx}",
                "intro_bn": lesson.get("intro_bn", ""),
                "structure": lesson.get("structure", []),
                "items": built_items
            })

        built_parts.append({
            "id": unit_id,
            "order": p_idx,
            "level": "B2",
            "title_bn": title_bn,
            "title_target": title_target,
            "lessons": built_lessons
        })

    course_data = {
        "schema_version": 1,
        "course": {
            "id": "jp-standard-n2",
            "title_bn": "জাপানিজ স্পোকেন কোর্স: লেভেল JLPT N2",
            "title_target": "日本語スピーキングマスタークラス：上級中等 N2",
            "target_lang": "ja",
            "base_lang": "bn",
            "version": "1.0.0"
        },
        "stats": {
            "parts": len(built_parts),
            "lessons": total_lessons,
            "items": total_items
        },
        "parts": built_parts
    }

    with open(ASSET_PATH, "w", encoding="utf-8") as f:
        json.dump(course_data, f, ensure_ascii=False, indent=2)

    print(f"Total parts: {len(built_parts)}, lessons: {total_lessons}, items: {total_items}")
    print(f"Successfully generated {ASSET_PATH}")
    print(f"File size: {os.path.getsize(ASSET_PATH):,} bytes")

if __name__ == "__main__":
    main()
