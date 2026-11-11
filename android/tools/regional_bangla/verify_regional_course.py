"""Verifies schema, token integrity, script purity, and 9-region concept completeness of spoken_bangla_regional_divisions.json."""
import json
import os
import re
import sys
from collections import defaultdict

IGNORED = re.compile(r"[\s\u200c\u200d।॥,?!.,:;'\-—…\"“”]")
FOREIGN_LEAK = re.compile(r"[\u0900-\u0963\u0965-\u097F\u0A80-\u0AFF\u0600-\u06FF\u30A0-\u30FF\u3040-\u309F]")
EXPECTED_REGIONS = ["ctg", "noa", "syl", "dhk", "bar", "raj", "rng", "khl", "mym"]


def verify():
    script_dir = os.path.dirname(os.path.abspath(__file__))
    json_path = os.path.abspath(
        os.path.join(script_dir, "..", "..", "app", "src", "main", "assets", "spoken_bangla_regional_divisions.json")
    )

    if not os.path.exists(json_path):
        print(f"ERROR: File not found: {json_path}")
        sys.exit(1)

    with open(json_path, "r", encoding="utf-8") as f:
        data = json.load(f)

    assert data.get("schema_version") == 1, "schema_version must be 1"
    assert data.get("course_id") == "spoken_bangla_regional_divisions"
    assert data.get("target_lang") == "bd"

    parts = data.get("parts", [])
    assert len(parts) == 8, f"Expected 8 thematic parts, got {len(parts)}"

    total_lessons = 0
    total_items = 0
    concept_regions = defaultdict(list)
    concept_bn = {}

    for part in parts:
        assert part.get("id", "").startswith("bd-thm-"), f"Unexpected part id: {part.get('id')}"
        assert part.get("title") and part.get("title_bn")
        lessons = part.get("lessons", [])
        assert len(lessons) == 4, f"Expected 4 lessons in {part['id']}, got {len(lessons)}"

        for lesson in lessons:
            total_lessons += 1
            assert lesson.get("id", "").startswith("bd-thm-")
            assert lesson.get("title") and lesson.get("title_bn")
            items = lesson.get("items", [])
            assert len(items) == 18, f"Expected 18 comparative items in {lesson['id']}, got {len(items)}"

            for item in items:
                total_items += 1
                assert "id" in item
                assert item.get("target")
                assert item.get("bn")
                assert item.get("bn_pron")
                assert item.get("speaker"), f"Missing region speaker badge in {item['id']}"
                assert item.get("concept_id"), f"Missing concept_id in {item['id']}"
                tokens = item.get("tokens", [])
                assert len(tokens) > 0

                joined_tokens = "".join(t["t"] for t in tokens)
                clean_target = IGNORED.sub("", item["target"])
                clean_tokens = IGNORED.sub("", joined_tokens)
                assert clean_target == clean_tokens, f"Token mismatch in {item['id']}: '{clean_target}' vs '{clean_tokens}'"

                leak = FOREIGN_LEAK.search(item["bn_pron"])
                assert not leak, f"Foreign script leak in bn_pron of {item['id']}: {leak.group()}"

                cid = item["concept_id"]
                region = item.get("tags", {}).get("region")
                concept_regions[cid].append(region)
                if cid in concept_bn:
                    assert concept_bn[cid] == item["bn"], f"Inconsistent bn for {cid}"
                concept_bn[cid] = item["bn"]

    for cid, regions in concept_regions.items():
        assert regions == EXPECTED_REGIONS, f"Concept {cid} has mismatched regions: {regions}"

    print("COMPARATIVE REGIONAL BANGLA VERIFICATION SUCCESSFUL:")
    print(f"  Asset File: {json_path}")
    print(f"  Total Parts (Thematic): {len(parts)}")
    print(f"  Total Lessons: {total_lessons}")
    print(f"  Total Concept Sentences: {len(concept_regions)} (9 regions each)")
    print(f"  Total Items: {total_items}")
    print("  Token Integrity: 100% Passed")
    print("  Script Purity: 100% Passed")
    print("  9-Region Parity per Sentence: 100% Passed")


if __name__ == "__main__":
    verify()
