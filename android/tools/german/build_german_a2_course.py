import json
import os
import sys

script_dir = os.path.dirname(os.path.abspath(__file__))
generators_dir = os.path.join(script_dir, "generators")
sys.path.insert(0, generators_dir)

def main():
    from generate_a2_part1 import parts_p1, make_item
    from generate_a2_part2 import parts_p2

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
            "id": "de-standard-a2",
            "target_lang": "de",
            "base_lang": "bn",
            "title_bn": "জার্মান স্ট্যান্ডার্ড কোর্স: লেভেল A2",
            "title_target": "Deutsch: Niveau A2",
            "source": "German-Spoken-Curriculum-Plan.md, roadmap phase 2 (A2)",
            "note": "A2 Elementary spoken German course focusing on Dativ, Wechselpräpositionen, doctor visits, subordinate clauses (weil, dass, wenn), travel, and Goethe A2 exam prep.",
            "welcome_text": "জার্মান A2 কোর্সে আপনাকে স্বাগতম! ডাটিক, কারণ ও জটিল বাক্য শুনুন এবং জোরে বলুন।"
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

    out_path = os.path.abspath(os.path.join(script_dir, "../../app/src/main/assets/spoken_german_standard_a2.json"))
    with open(out_path, "w", encoding="utf-8") as f:
        json.dump(course_data, f, ensure_ascii=False, indent=2)
    print(f"Successfully generated {out_path} ({total_items} items in {total_lessons} lessons across {len(built_parts)} parts)")

if __name__ == "__main__":
    main()

