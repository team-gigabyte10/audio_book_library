import json
import os
import re

json_path = os.path.abspath(os.path.join(os.path.dirname(__file__), "../../app/src/main/assets/spoken_german_standard_b1.json"))
assert os.path.exists(json_path), f"Asset does not exist: {json_path}"

with open(json_path, encoding="utf-8") as f:
    data = json.load(f)

assert data["schema_version"] == 1
assert data["course"]["id"] == "de-standard-b1"
assert data["course"]["target_lang"] == "de"
assert data["course"]["base_lang"] == "bn"
assert data["stats"]["lessons"] == 64
assert data["stats"]["items"] == 512

parts = data["parts"]
assert len(parts) == 16, f"Expected 16 parts, got {len(parts)}"

IGNORED = re.compile(r"[\s\u200c\u200d,.?!:;'\-—…\"„”«»]")
DIGITS = re.compile(r"\d")

total_lessons = 0
total_items = 0

for p_idx, part in enumerate(parts, 1):
    expected_part_id = f"de-b1-{p_idx:02d}"
    assert part["id"] == expected_part_id
    assert part["level"] == "B1"
    assert part["title_bn"].strip()
    assert part["title_target"].strip()
    assert len(part["lessons"]) == 4
    for l_idx, lesson in enumerate(part["lessons"], 1):
        total_lessons += 1
        expected_lesson_id = f"{expected_part_id}-l{l_idx:02d}"
        assert lesson["id"] == expected_lesson_id
        assert lesson["title_bn"].strip()
        assert lesson["title_target"].strip()
        assert len(lesson["items"]) == 8
        for i_idx, item in enumerate(lesson["items"], 1):
            total_items += 1
            expected_item_id = f"{expected_lesson_id}-{i_idx:03d}"
            assert item["id"] == expected_item_id
            assert item["level"] == "B1"
            assert item["target"].strip()
            assert item["bn"].strip()
            assert item["bn_pron"].strip()
            assert not DIGITS.search(item["target"]), f"Digit in {expected_item_id}: {item['target']}"
            
            # token validation
            tok_text = "".join(t["t"] for t in item["tokens"])
            assert IGNORED.sub("", tok_text) == IGNORED.sub("", item["target"]), f"Token mismatch in {expected_item_id}"

assert total_lessons == 64
assert total_items == 512
print(f"B1 ASSET VERIFIED SUCCESSFULLY!")
print(f"Parts: {len(parts)}, Lessons: {total_lessons}, Items: {total_items}")
