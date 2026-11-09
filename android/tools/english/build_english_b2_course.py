"""Compiles Level B2 (Units en-b2-01 to en-b2-16) for English Spoken Course."""
import json
import os
import re
import sys

script_dir = os.path.dirname(os.path.abspath(__file__))
generators_dir = os.path.join(script_dir, "generators")
sys.path.insert(0, generators_dir)

import data_b2_u01_u04
import data_b2_u05_u08
import data_b2_u09_u12
import data_b2_u13_u16

IGNORED = re.compile(r"[\s\u200c\u200d,.?!:;'\-—…\"„”«»]")
DIGITS = re.compile(r"\d")

raw_units = (
    data_b2_u01_u04.u01_u04_units +
    data_b2_u05_u08.u05_u08_units +
    data_b2_u09_u12.u09_u12_units +
    data_b2_u13_u16.u13_u16_units
)

def make_item(stem, lesson_no, index, target, bn, bn_pron, tokens, speaker=None, item_type="sentence"):
    joined = "".join(t["t"] for t in tokens)
    cleaned_joined = IGNORED.sub("", joined)
    cleaned_target = IGNORED.sub("", target)
    if cleaned_joined != cleaned_target:
        raise ValueError(f"Token mismatch in {stem} l{lesson_no} #{index}:\nTokens: '{cleaned_joined}'\nTarget: '{cleaned_target}'")
    if DIGITS.search(target):
        raise ValueError(f"Digit found in {stem} l{lesson_no} #{index}: '{target}'")

    item_id = f"{stem}-l{lesson_no:02d}-{index:03d}"
    out = {
        "id": item_id,
        "concept_id": f"c-{item_id}",
        "order": index,
        "type": item_type,
        "level": "B2",
        "target": target.strip(),
        "bn": bn.strip(),
        "bn_pron": bn_pron.strip(),
        "tokens": [{"t": t["t"], "bn": t.get("bn")} for t in tokens],
        "tags": {"cefr": "B2"},
        "status": "ready",
        "review_flags": []
    }
    if speaker:
        out["speaker"] = speaker
    return out

def main():
    print(f"Total raw parts to build: {len(raw_units)}")

    built_parts = []
    total_lessons = 0
    total_items = 0

    for p_idx, (stem, title_bn, title_target, lessons) in enumerate(raw_units, 1):
        built_lessons = []
        for l_idx, lesson_dict in enumerate(lessons, 1):
            total_lessons += 1
            lesson_id = f"{stem}-l{l_idx:02d}"
            built_items = []
            for i_idx, item_tuple in enumerate(lesson_dict["items"], 1):
                total_items += 1
                target, bn, bn_pron, tokens = item_tuple[0], item_tuple[1], item_tuple[2], item_tuple[3]
                speaker = item_tuple[4] if len(item_tuple) > 4 else None
                item_obj = make_item(stem, l_idx, i_idx, target, bn, bn_pron, tokens, speaker)
                built_items.append(item_obj)

            built_lessons.append({
                "id": lesson_id,
                "order": l_idx,
                "title_bn": lesson_dict["title_bn"],
                "title_target": lesson_dict["title_target"],
                "intro_bn": lesson_dict.get("intro_bn", ""),
                "structure": lesson_dict.get("structure", []),
                "items": built_items
            })

        built_parts.append({
            "id": stem,
            "order": p_idx,
            "level": "B2",
            "title_bn": title_bn,
            "title_target": title_target,
            "lessons": built_lessons
        })

    print(f"Total parts built: {len(built_parts)}, lessons: {total_lessons}, items: {total_items}")

    assert len(built_parts) == 16, f"Expected 16 parts, got {len(built_parts)}"
    assert total_lessons == 64, f"Expected 64 lessons, got {total_lessons}"
    assert total_items == 512, f"Expected exactly 512 items, got {total_items}"

    course_data = {
        "schema_version": 1,
        "course": {
            "id": "en-standard-b2",
            "target_lang": "en",
            "base_lang": "bn",
            "title_bn": "ইংরেজি স্ট্যান্ডার্ড কোর্স: লেভেল B2",
            "title_target": "English: Level B2 (Corporate & Career Mastery)",
            "source": "English-Spoken-Curriculum-Plan.md, roadmap phase 5 (B2)",
            "note": "B2 Upper-Intermediate Corporate & Career Mastery course focusing on executive elevator pitches, STAR interview method, career trajectory & composure, meeting governance & floor management, email & call follow-ups, business pitching & unit economics, commercial negotiations, constructive feedback sandwich, conflict de-escalation, third & mixed conditionals in retrospectives, diplomatic hedging, corporate idioms, high-stakes Q&A mastery, cross-cultural sensitivity, classical rhetoric & persuasion, and comprehensive CEFR B2 capstone assessment."
        },
        "ladder_default": [
            {"play": "target", "speed": 0.8},
            {"play": "bn", "speed": 1.15},
            {"play": "target", "speed": 0.9},
            {"play": "target", "speed": 1.0},
            {"pause_ms": 1200}
        ],
        "stats": {
            "lessons": total_lessons,
            "items": total_items
        },
        "parts": built_parts
    }

    out_path = os.path.abspath(os.path.join(script_dir, "../../app/src/main/assets/spoken_english_standard_b2.json"))
    with open(out_path, "w", encoding="utf-8") as f:
        json.dump(course_data, f, ensure_ascii=False, indent=2)
    print(f"Successfully generated {out_path} ({total_items} items in {total_lessons} lessons across {len(built_parts)} parts)")

if __name__ == "__main__":
    main()
