import json
import os
import sys

script_dir = os.path.dirname(os.path.abspath(__file__))
generators_dir = os.path.join(script_dir, "generators")
sys.path.insert(0, generators_dir)

from generate_a2_p1 import parts_p1, make_item
from generate_a2_p2 import parts_p2

def main():
    raw_parts = parts_p1 + parts_p2
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
            "level": "A2",
            "title_bn": title_bn,
            "title_target": title_target,
            "lessons": built_lessons
        }
        built_parts.append(part_dict)

    print(f"Total parts: {len(built_parts)}, lessons: {total_lessons}, items: {total_items}")

    # Integrity assertions
    assert len(built_parts) == 15, f"Expected 15 parts, got {len(built_parts)}"
    assert total_lessons == 60, f"Expected 60 lessons, got {total_lessons}"
    assert total_items >= 480, f"Expected at least 480 items, got {total_items}"

    course_data = {
        "schema_version": 1,
        "course": {
            "id": "ur-standard-a2",
            "target_lang": "ur",
            "base_lang": "bn",
            "title_bn": "উর্দু স্ট্যান্ডার্ড কোর্স: লেভেল A2",
            "title_target": "اردو: درجہ A2",
            "source": "Urdu-Spoken-Curriculum-Plan.md, roadmap phase 2 (A2)",
            "note": "A2 Elementary course focusing on past tenses, the ne-marker, compound verbs, and workplace communication."
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

    out_path = os.path.abspath(os.path.join(script_dir, "../../app/src/main/assets/spoken_urdu_standard_a2.json"))
    with open(out_path, "w", encoding="utf-8") as f:
        json.dump(course_data, f, ensure_ascii=False, indent=2)
    print(f"Successfully generated {out_path} ({total_items} items in {total_lessons} lessons across {len(built_parts)} parts)")

if __name__ == "__main__":
    main()
