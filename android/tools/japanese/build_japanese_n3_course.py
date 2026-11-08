# -*- coding: utf-8 -*-
"""Compiles Level N3 (Units jp-n3-01 to jp-n3-16) for Japanese Spoken Course."""
import json
import os
import re
import sys
from pathlib import Path

script_dir = Path(__file__).resolve().parent
generators_dir = script_dir / "generators"
sys.path.insert(0, str(generators_dir))

import data_n3_u01_u04
import data_n3_u05_u08
import data_n3_u09_u12
import data_n3_u13_u16

ASSET_PATH = script_dir.parent.parent / "app" / "src" / "main" / "assets" / "spoken_japanese_standard_n3.json"

KANJI = re.compile(r"[一-鿿々]")
LATIN = re.compile(r"[A-Za-z]")
DIGIT = re.compile(r"[0-9]")
IGNORED = re.compile(r"[\s。、．，,.!！?？「」『』・〜~…ー―\-]+")

raw_units = (
    data_n3_u01_u04.UNITS_N3_U01_U04 +
    data_n3_u05_u08.UNITS_N3_U05_U08 +
    data_n3_u09_u12.UNITS_N3_U09_U12 +
    data_n3_u13_u16.UNITS_N3_U13_U16
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
        "level": "B1",
        "target": target,
        "reading": reading,
        "bn": bn,
        "bn_pron": hint_line(target, reading, bn_pron),
        "tokens": [{"t": t["t"], "bn": t.get("m") or t.get("bn", "")} for t in tokens],
        "tags": {"jlpt": "N3"},
        "status": "ready",
        "review_flags": []
    }
    if gender:
        out["gender"] = gender
    if alt_t:
        alt_hint = hint_line(alt_t, alt_r, alt_p) if alt_p else ""
        out["example"] = {
            "target": alt_t.strip(),
            "bn": alt_hint
        }
    return out

def main():
    print(f"Total raw parts to build: {len(raw_units)}")
    if len(raw_units) != 16:
        raise ValueError(f"Expected 16 units, got {len(raw_units)}")

    parts = []
    lesson_total = 0
    item_total = 0

    for part_order, unit in enumerate(raw_units, start=1):
        part_id = unit["unit_id"]
        lessons = []
        for l_idx, raw_lesson in enumerate(unit["lessons"], start=1):
            lesson_id = f"{part_id}-l{l_idx:02d}"
            raw_items = raw_lesson["items"]
            built_items = []
            for i_idx, itm in enumerate(raw_items, start=1):
                built_items.append(make_item(part_id, l_idx, i_idx, itm))
                item_total += 1

            title_bn = raw_lesson.get("title_bn") or raw_lesson.get("title") or f"লেসন {l_idx}"
            title_target = raw_lesson.get("title_target") or f"Lesson {l_idx}"
            intro_bn = raw_lesson.get("intro_bn")
            structure = raw_lesson.get("structure") or []

            lesson = {
                "id": lesson_id,
                "order": l_idx,
                "title_bn": title_bn,
                "title_target": title_target,
                "intro_bn": intro_bn,
                "structure": structure,
                "items": built_items
            }
            lessons.append(lesson)
            lesson_total += 1

        part = {
            "id": part_id,
            "order": part_order,
            "level": "B1",
            "title_bn": unit.get("title_bn") or unit.get("title"),
            "title_target": unit.get("title_target") or unit.get("subtitle") or f"Unit {part_order:02d}",
            "lessons": lessons
        }
        parts.append(part)

    course = {
        "schema_version": 1,
        "course": {
            "id": "jp-standard-n3",
            "target_lang": "ja",
            "base_lang": "bn",
            "title_bn": "জাপানিজ স্পোকেন কোর্স: লেভেল N3 (Intermediate)",
            "title_target": "Standard Japanese: Intermediate N3",
            "source": "Japanese-Spoken-Curriculum-Plan.md, roadmap phase 3 (N3)",
            "note": "Complete N3 intermediate spoken course covering Habits & Changes, Logic & Duties, Full Keigo System, Telephone Japanese, Workplace Communication, Onomatopoeia, and Real Life Administration."
        },
        "ladder_default": [
            {"play": "target", "speed": 0.8},
            {"play": "bn", "speed": 1.15},
            {"play": "target", "speed": 0.9},
            {"play": "target", "speed": 1.0},
            {"pause_ms": 1200}
        ],
        "stats": {
            "parts": len(parts),
            "lessons": lesson_total,
            "items": item_total
        },
        "parts": parts
    }

    ASSET_PATH.parent.mkdir(parents=True, exist_ok=True)
    with open(ASSET_PATH, "w", encoding="utf-8") as f:
        json.dump(course, f, ensure_ascii=False, indent=2)

    print(f"Successfully compiled {ASSET_PATH}")
    print(f"Parts: {len(parts)}, Lessons: {lesson_total}, Items: {item_total}")

if __name__ == "__main__":
    main()
