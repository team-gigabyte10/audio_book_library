# -*- coding: utf-8 -*-
"""Compiles Level B1 (Units hi-b1-01 to hi-b1-16) for Hindi Spoken Course."""
import json
import os
import re
import sys

script_dir = os.path.dirname(os.path.abspath(__file__))
generators_dir = os.path.join(script_dir, "generators")
sys.path.insert(0, generators_dir)

import data_b1_u01_u04
import data_b1_u05_u08
import data_b1_u09_u12
import data_b1_u13_u16

IGNORED = re.compile(r"[\s\u200c\u200d।,?!;:\"'—\-…]")
DEVANAGARI = re.compile(r"[\u0900-\u097F]")

raw_units = (
    data_b1_u01_u04.UNITS_B1_U01_U04 +
    data_b1_u05_u08.UNITS_B1_U05_U08 +
    data_b1_u09_u12.UNITS_B1_U09_U12 +
    data_b1_u13_u16.UNITS_B1_U13_U16
)

def make_item(stem, lesson_no, index, item_data):
    if len(item_data) == 4:
        target, bn, bn_pron, tokens = item_data
        gender, variant_f, variant_f_pron, speaker, item_type = None, None, None, None, "sentence"
    elif len(item_data) == 5:
        target, bn, bn_pron, tokens, gender = item_data
        variant_f, variant_f_pron, speaker, item_type = None, None, None, "sentence"
    elif len(item_data) == 7:
        target, bn, bn_pron, tokens, gender, variant_f, variant_f_pron = item_data
        speaker, item_type = None, "sentence"
    elif len(item_data) == 9:
        target, bn, bn_pron, tokens, gender, variant_f, variant_f_pron, speaker, item_type = item_data
    else:
        raise ValueError(f"Unexpected tuple length {len(item_data)} in {stem} l{lesson_no} #{index}")

    target = target.strip()
    joined = "".join(t["t"] for t in tokens)
    cleaned_joined = IGNORED.sub("", joined)
    cleaned_target = IGNORED.sub("", target)

    if cleaned_joined != cleaned_target:
        raise ValueError(f"Token mismatch in {stem} l{lesson_no} #{index}: '{cleaned_joined}' != '{cleaned_target}'")

    if not DEVANAGARI.search(target):
        raise ValueError(f"No Devanagari letters in {stem} l{lesson_no} #{index}: '{target}'")

    item_id = f"{stem}-l{lesson_no:02d}-{index:03d}"
    out = {
        "id": item_id,
        "concept_id": f"c-{item_id}",
        "order": index,
        "type": item_type,
        "level": "B1",
        "target": target,
        "bn": bn.strip(),
        "bn_pron": bn_pron.strip(),
        "tokens": [{"t": t["t"], "bn": t.get("bn")} for t in tokens],
        "tags": {"cefr": "B1"},
        "status": "ready",
        "review_flags": []
    }
    if gender:
        out["gender"] = gender
    if speaker:
        out["speaker"] = speaker
    if variant_f:
        out["example"] = {
            "target": variant_f.strip(),
            "bn": variant_f_pron.strip() if variant_f_pron else ""
        }
    return out

def main():
    print(f"Total raw parts to build: {len(raw_units)}")

    built_parts = []
    total_lessons = 0
    total_items = 0

    for p_idx, unit in enumerate(raw_units, 1):
        stem = unit["unit_id"]
        title_bn = unit["title_bn"]
        title_target = unit["title_target"]
        lessons = unit["lessons"]

        built_lessons = []
        for l_idx, l in enumerate(lessons, 1):
            built_items = []
            for i_idx, it in enumerate(l["items"], 1):
                item = make_item(stem, l_idx, i_idx, it)
                built_items.append(item)
                total_items += 1

            lesson_dict = {
                "id": f"{stem}-l{l_idx:02d}",
                "order": l_idx,
                "title_bn": l["title_bn"],
                "title_target": l["title_target"],
                "intro_bn": l.get("intro_bn", ""),
                "structure": l.get("structure", []),
                "items": built_items
            }
            built_lessons.append(lesson_dict)
            total_lessons += 1

        part_dict = {
            "id": stem,
            "order": p_idx,
            "level": "B1",
            "title_bn": title_bn,
            "title_target": title_target,
            "lessons": built_lessons
        }
        built_parts.append(part_dict)

    print(f"Total parts: {len(built_parts)}, lessons: {total_lessons}, items: {total_items}")

    # Integrity assertions
    assert len(built_parts) == 16, f"Expected 16 parts, got {len(built_parts)}"
    assert total_lessons == 64, f"Expected 64 lessons, got {total_lessons}"
    assert total_items == 512, f"Expected 512 items, got {total_items}"

    course_data = {
        "schema_version": 1,
        "course": {
            "id": "hi-standard-b1",
            "target_lang": "hi",
            "base_lang": "bn",
            "title_bn": "হিন্দি স্পোকেন কোর্স: লেভেল B1",
            "title_target": "हिंदी: स्तर B1 (मध्यवर्ती)",
            "source": "Hindi-Spoken-Curriculum-Plan.md, roadmap phase 3 (B1)",
            "note": "B1 Intermediate Hindi spoken course covering conditionals, relative-correlatives, passive voice, reported speech, causatives, subjunctive, idioms, storytelling, customer complaints, official phone Hindi, and contemporary news.",
            "welcome_text": "হিন্দি B1 কোর্সে স্বাগতম! বাস্তব ও অবাস্তব শর্ত, পরোক্ষ উক্তি, কর্মবাচ্য, প্রযোজক ক্রিয়া, বাগধারা ও প্রাতিষ্ঠানিক কথোপকথন শিখুন।"
        },
        "ladder_default": [
            {"play": "target", "speed": 0.85},
            {"play": "bn", "speed": 1.15},
            {"play": "target", "speed": 0.95},
            {"play": "target", "speed": 1.05},
            {"pause_ms": 1200}
        ],
        "stats": {
            "lessons": total_lessons,
            "items": total_items
        },
        "parts": built_parts
    }

    out_path = os.path.abspath(os.path.join(script_dir, "../../app/src/main/assets/spoken_hindi_standard_b1.json"))
    with open(out_path, "w", encoding="utf-8") as f:
        json.dump(course_data, f, ensure_ascii=False, indent=2)
    print(f"Successfully generated {out_path} ({total_items} items in {total_lessons} lessons across {len(built_parts)} parts)")

if __name__ == "__main__":
    main()
