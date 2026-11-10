"""Verifies integrity, schema compliance, token accuracy, and script purity of spoken_bangla_regional_divisions.json."""
import json
import os
import re
import sys

IGNORED = re.compile(r"[\s\u200c\u200d।॥,?!.,:;'\-—…\"“”]")
FOREIGN_LEAK = re.compile(r"[\u0900-\u0963\u0965-\u097F\u0A80-\u0AFF\u0600-\u06FF\u30A0-\u30FF\u3040-\u309F]")

def verify():
    script_dir = os.path.dirname(os.path.abspath(__file__))
    json_path = os.path.abspath(os.path.join(script_dir, "..", "..", "app", "src", "main", "assets", "spoken_bangla_regional_divisions.json"))

    if not os.path.exists(json_path):
        print(f"ERROR: File not found: {json_path}")
        sys.exit(1)

    with open(json_path, "r", encoding="utf-8") as f:
        data = json.load(f)

    assert data.get("schema_version") == 1, "schema_version must be 1"
    assert data.get("course_id") == "spoken_bangla_regional_divisions"
    assert data.get("target_lang") == "bd"

    parts = data.get("parts", [])
    assert len(parts) > 0, "Parts list must not be empty"

    total_lessons = 0
    total_items = 0

    for part_idx, part in enumerate(parts):
        assert "id" in part and part["id"].startswith("bd-")
        assert "title" in part and part["title"]
        assert "title_bn" in part and part["title_bn"]
        lessons = part.get("lessons", [])
        assert len(lessons) > 0

        for lesson in lessons:
            total_lessons += 1
            assert "id" in lesson and lesson["id"].startswith("bd-")
            assert "title" in lesson and lesson["title"]
            assert "title_bn" in lesson and lesson["title_bn"]
            items = lesson.get("items", [])
            assert len(items) > 0

            for item_idx, item in enumerate(items):
                total_items += 1
                assert "id" in item
                assert "target" in item and item["target"]
                assert "bn" in item and item["bn"]
                assert "bn_pron" in item and item["bn_pron"]
                assert "tokens" in item and len(item["tokens"]) > 0

                # Verify token match
                joined_tokens = "".join(t["t"] for t in item["tokens"])
                clean_target = IGNORED.sub("", item["target"])
                clean_tokens = IGNORED.sub("", joined_tokens)
                assert clean_target == clean_tokens, f"Token mismatch in {item['id']}: '{clean_target}' vs '{clean_tokens}'"

                # Check script purity
                leak = FOREIGN_LEAK.search(item["bn_pron"])
                assert not leak, f"Foreign script leak in bn_pron of {item['id']}: {leak.group()}"

    print(f"VERIFICATION SUCCESSFUL:")
    print(f"  Asset File: {json_path}")
    print(f"  Total Parts (Divisions): {len(parts)}")
    print(f"  Total Lessons: {total_lessons}")
    print(f"  Total Items (Sentences): {total_items}")
    print(f"  Token Integrity: 100% Passed")
    print(f"  Script Purity: 100% Passed (Zero foreign script leaks)")

if __name__ == "__main__":
    verify()
