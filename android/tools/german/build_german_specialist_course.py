"""Compiles Specialist Track (Units de-sp-01 to de-sp-16) for German Spoken Course."""
import json
import os
import re
import sys

script_dir = os.path.dirname(os.path.abspath(__file__))
generators_dir = os.path.join(script_dir, "generators")
sys.path.insert(0, generators_dir)

import data_sp_u01_u04
import data_sp_u05_u08
import data_sp_u09_u12
import data_sp_u13_u16

IGNORED = re.compile(r"[\s\u200c\u200d,.?!:;'\-—…\"„”«»]")
DIGITS = re.compile(r"\d")

raw_units = (
    data_sp_u01_u04.UNITS_SP_U01_U04 +
    data_sp_u05_u08.UNITS_SP_U05_U08 +
    data_sp_u09_u12.UNITS_SP_U09_U12 +
    data_sp_u13_u16.UNITS_SP_U13_U16
)

def make_item(stem, lesson_no, index, target, bn, bn_pron, tokens, gender=None, speaker=None, item_type="sentence"):
    joined = "".join(t["t"] for t in tokens)
    cleaned_joined = IGNORED.sub("", joined)
    cleaned_target = IGNORED.sub("", target)
    if cleaned_joined.lower() != cleaned_target.lower():
        raise ValueError(f"Token mismatch in {stem} l{lesson_no} #{index}: '{cleaned_joined}' != '{cleaned_target}'")
    if DIGITS.search(target):
        raise ValueError(f"Digit found in {stem} l{lesson_no} #{index}: '{target}'")

    item_id = f"{stem}-l{lesson_no:02d}-{index:03d}"
    out = {
        "id": item_id,
        "concept_id": f"c-{item_id}",
        "order": index,
        "type": item_type,
        "level": "Specialist",
        "target": target.strip(),
        "bn": bn.strip(),
        "bn_pron": bn_pron.strip(),
        "tokens": [{"t": t["t"], "bn": t.get("bn")} for t in tokens],
        "tags": {"cefr": "Specialist", "domain": "Healthcare" if int(stem.split('-')[-1]) <= 8 else "HigherEducation"},
        "status": "ready",
        "review_flags": []
    }
    if gender:
        out["gender"] = gender
    if speaker:
        out["speaker"] = speaker
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
                if len(it) == 7:
                    tg, bn, bp, tok, gen, spk, itype = it
                elif len(it) == 4:
                    tg, bn, bp, tok = it
                    gen, spk, itype = None, None, "sentence"
                elif len(it) == 5:
                    tg, bn, bp, tok, gen = it
                    spk, itype = None, "sentence"
                else:
                    raise ValueError(f"Unexpected tuple length {len(it)} in {stem} l{l_idx} #{i_idx}")
                item = make_item(stem, l_idx, i_idx, tg, bn, bp, tok, gen, spk, itype)
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
            "level": "Specialist",
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
            "id": "de-specialist-pro",
            "target_lang": "de",
            "base_lang": "bn",
            "title_bn": "জার্মান স্পেশালিস্ট প্রফেশনাল কোর্স (নার্সিং ও উচ্চশিক্ষা)",
            "title_target": "Deutsch für Fachkräfte: Pflege & Studium",
            "source": "German-Spoken-Curriculum-Plan.md, roadmap phase 4 (Specialist Tracks A & B)",
            "note": "Specialist professional German curriculum covering Track A: Clinical Nursing & Healthcare (Units 01-08) and Track B: German University Admissions, APS, Visa & Master's Defense (Units 09-16).",
            "welcome_text": "জার্মান স্পেশালিস্ট প্রফেশনাল কোর্সে স্বাগতম! জার্মানিতে নার্সিং ক্যারিয়ার ও উচ্চশিক্ষার জন্য প্রয়োজনীয় প্রফেশনাল জার্মান ভাষার সম্পূর্ণ অনুশীলন।"
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

    out_path = os.path.abspath(os.path.join(script_dir, "../../app/src/main/assets/spoken_german_specialist_pro.json"))
    with open(out_path, "w", encoding="utf-8") as f:
        json.dump(course_data, f, ensure_ascii=False, indent=2)
    print(f"Successfully generated {out_path} ({total_items} items in {total_lessons} lessons across {len(built_parts)} parts)")

if __name__ == "__main__":
    main()
