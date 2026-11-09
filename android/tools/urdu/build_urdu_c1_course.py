# -*- coding: utf-8 -*-
"""Compiles Level C1 (Units ur-c1-01 to ur-c1-16) for Urdu Spoken Course."""
import json
import os
import re
import sys

script_dir = os.path.dirname(os.path.abspath(__file__))
generators_dir = os.path.join(script_dir, "generators")
sys.path.insert(0, generators_dir)

IGNORED = re.compile(r"[\sـ‌‍۔،؟!?.,:؛\-…\"'()]+")
MARKS = re.compile(r"[ً-ْٰٖ-ٟ]")

def make_item(stem, lesson_no, index, target, target_marked, bn, bn_pron, tokens, gender=None, female_target=None, female_pron=None, speaker=None, item_type="sentence"):
    joined = "".join(t["t"] for t in tokens)
    cleaned_joined = IGNORED.sub("", MARKS.sub("", joined))
    cleaned_target = IGNORED.sub("", MARKS.sub("", target))
    if cleaned_joined != cleaned_target:
        raise ValueError(f"Token mismatch in {stem} l{lesson_no} #{index}: '{cleaned_joined}' != '{cleaned_target}'")

    item_id = f"{stem}-l{lesson_no:02d}-{index:03d}"
    out = {
        "id": item_id,
        "concept_id": f"c-{item_id}",
        "order": index,
        "type": item_type,
        "level": "C1",
        "target": target.strip(),
        "target_marked": target_marked.strip(),
        "bn": bn.strip(),
        "bn_pron": bn_pron.strip(),
        "tokens": [{"t": t["t"], "bn": t.get("bn")} for t in tokens],
        "tags": {"cefr": "C1"},
        "status": "ready",
        "review_flags": []
    }
    if gender:
        out["gender"] = gender
    if speaker:
        out["speaker"] = speaker
    if female_target and female_pron:
        out["example"] = {
            "target": female_target.strip(),
            "bn": female_pron.strip()
        }
    return out

def main():
    from data_c1_u01_u04 import raw_parts as p1
    from data_c1_u05_u08 import raw_parts as p2
    from data_c1_u09_u12 import raw_parts as p3
    from data_c1_u13_u16 import raw_parts as p4

    raw_parts = p1 + p2 + p3 + p4
    print(f"Total raw parts collected: {len(raw_parts)}")

    built_parts = []
    total_lessons = 0
    total_items = 0

    for p_idx, (stem, title_bn, title_target, lessons) in enumerate(raw_parts, 1):
        built_lessons = []
        for l_idx, l in enumerate(lessons, 1):
            built_items = []
            for i_idx, it in enumerate(l["items"], 1):
                if len(it) == 8:
                    tg, tm, bn, bp, tok, gen, ft, fp = it
                    spk, itype = None, "sentence"
                elif len(it) == 10:
                    tg, tm, bn, bp, tok, gen, ft, fp, spk, itype = it
                else:
                    raise ValueError(f"Unexpected tuple length {len(it)} in {stem} l{l_idx} #{i_idx}")
                item = make_item(stem, l_idx, i_idx, tg, tm, bn, bp, tok, gen, ft, fp, spk, itype)
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
            "level": "C1",
            "title_bn": title_bn,
            "title_target": title_target,
            "lessons": built_lessons
        }
        built_parts.append(part_dict)

    print(f"Total parts: {len(built_parts)}, lessons: {total_lessons}, items: {total_items}")

    # Integrity assertions
    assert len(built_parts) == 16, f"Expected 16 parts, got {len(built_parts)}"
    assert total_lessons == 64, f"Expected 64 lessons, got {total_lessons}"
    assert total_items == 512, f"Expected exactly 512 items, got {total_items}"

    course_data = {
        "schema_version": 1,
        "course": {
            "id": "ur-standard-c1",
            "target_lang": "ur",
            "base_lang": "bn",
            "title_bn": "উর্দু স্পোকেন কোর্স: লেভেল C1",
            "title_target": "اردو: درجہ C1 (اعلیٰ مہارت)",
            "source": "Urdu-Spoken-Curriculum-Plan.md, roadmap phase 5 (C1)",
            "note": "C1 Advanced spoken course focusing on idioms, proverbs, rhetoric, humour & wit, classical ghazal, modern poetry, literary prose, public speaking, academic terminology, debate, regional varieties, Urdu-Hindi register shifts, and media interviews."
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

    out_path = os.path.abspath(os.path.join(script_dir, "../../app/src/main/assets/spoken_urdu_standard_c1.json"))
    with open(out_path, "w", encoding="utf-8") as f:
        json.dump(course_data, f, ensure_ascii=False, indent=2)
    print(f"Successfully generated {out_path} ({total_items} items in {total_lessons} lessons across {len(built_parts)} parts)")

if __name__ == "__main__":
    main()

