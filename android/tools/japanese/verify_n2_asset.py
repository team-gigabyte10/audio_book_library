# -*- coding: utf-8 -*-
"""Verification script for spoken_japanese_standard_n2.json."""
import json
import os
import re
import sys

IGNORED = re.compile(r"[\s。、．，,.!！?？「」『』・〜~…ー―\-]+")
KANJI = re.compile(r"[一-鿿々]")
LATIN = re.compile(r"[A-Za-z]")
DIGIT = re.compile(r"[0-9]")

asset_path = os.path.abspath(os.path.join(os.path.dirname(__file__), "../../app/src/main/assets/spoken_japanese_standard_n2.json"))
assert os.path.exists(asset_path), f"File not found: {asset_path}"

with open(asset_path, "r", encoding="utf-8") as f:
    data = json.load(f)

print(f"File size: {os.path.getsize(asset_path):,} bytes")
assert data.get("schema_version") == 1
course = data.get("course", {})
print(f"Course ID: {course.get('id')}")
print(f"Title BN: {course.get('title_bn')}")
print(f"Title Target: {course.get('title_target')}")

parts = data.get("parts", [])
print(f"Parts count: {len(parts)}")
assert len(parts) == 16, f"Expected 16 parts, got {len(parts)}"

total_lessons = 0
total_items = 0
errors = []

for p_idx, part in enumerate(parts, 1):
    pid = part.get("id")
    expected_pid = f"jp-n2-{p_idx:02d}"
    if pid != expected_pid:
        errors.append(f"Part order mismatch: got {pid}, expected {expected_pid}")
    assert part.get("level") == "B2"
    lessons = part.get("lessons", [])
    if len(lessons) != 4:
        errors.append(f"Part {pid} has {len(lessons)} lessons, expected 4")
    total_lessons += len(lessons)
    for l_idx, lesson in enumerate(lessons, 1):
        lid = lesson.get("id")
        items = lesson.get("items", [])
        if len(items) != 8:
            errors.append(f"Lesson {lid} has {len(items)} items, expected 8")
        total_items += len(items)
        for i_idx, item in enumerate(items, 1):
            iid = item.get("id")
            target = item.get("target", "")
            reading = item.get("reading", "")
            bn = item.get("bn", "")
            bn_pron = item.get("bn_pron", "")
            tokens = item.get("tokens", [])

            if not target:
                errors.append(f"Item {iid}: missing target")
            if not bn:
                errors.append(f"Item {iid}: missing bn")
            if not bn_pron:
                errors.append(f"Item {iid}: missing bn_pron")
            if not tokens:
                errors.append(f"Item {iid}: missing tokens")

            if LATIN.search(target):
                errors.append(f"Item {iid}: target contains latin '{target}'")
            if DIGIT.search(target):
                errors.append(f"Item {iid}: target contains digits '{target}'")
            if KANJI.search(target) and not reading:
                errors.append(f"Item {iid}: kanji target without reading '{target}'")

            joined = "".join(t.get("t", "") for t in tokens)
            cj = IGNORED.sub("", joined)
            ct = IGNORED.sub("", target)
            if cj != ct:
                errors.append(f"Item {iid}: token mismatch: '{cj}' != '{ct}'")

print(f"Total Lessons: {total_lessons} (expected 64)")
print(f"Total Items: {total_items} (expected 512)")
assert total_lessons == 64, f"Expected 64 lessons, got {total_lessons}"
assert total_items == 512, f"Expected 512 items, got {total_items}"

if errors:
    print(f"FAILED with {len(errors)} errors:")
    for err in errors[:20]:
        print("  -", err)
    sys.exit(1)

print("ALL JAPANESE N2 VERIFICATIONS PASSED! 100% compliant.")

