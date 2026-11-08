# -*- coding: utf-8 -*-
"""Verification of spoken_hindi_standard_b1.json"""
import json
import os
import re
import sys

IGNORED = re.compile(r"[\s\u200c\u200d।॥,?!.,:;'\-—…]")
DEVANAGARI = re.compile(r"[\u0900-\u097F]")
DIGIT = re.compile(r"[0-9]")

asset_path = os.path.abspath(os.path.join(os.path.dirname(__file__), "../../app/src/main/assets/spoken_hindi_standard_b1.json"))
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
    expected_pid = f"hi-b1-{p_idx:02d}"
    if pid != expected_pid:
        errors.append(f"Part order mismatch: got {pid}, expected {expected_pid}")
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
            tgt = item.get("target", "")
            bn = item.get("bn", "")
            pron = item.get("bn_pron", "")
            tokens = item.get("tokens", [])
            if not DEVANAGARI.search(tgt):
                errors.append(f"No Devanagari in {iid}: {tgt}")
            if DIGIT.search(tgt):
                errors.append(f"Digit found in {iid}: {tgt}")
            joined = "".join(t["t"] for t in tokens)
            if IGNORED.sub("", joined) != IGNORED.sub("", tgt):
                errors.append(f"Mismatch in {iid}: '{IGNORED.sub('', joined)}' != '{IGNORED.sub('', tgt)}'")
            if not bn:
                errors.append(f"Missing Bengali in {iid}")
            if not pron:
                errors.append(f"Missing pronunciation in {iid}")

print(f"Total Lessons: {total_lessons} (expected 64)")
print(f"Total Items: {total_items} (expected 512)")
assert total_lessons == 64
assert total_items == 512

if errors:
    print(f"Errors found ({len(errors)}):")
    for e in errors[:10]:
        print(" -", e)
    sys.exit(1)
else:
    print("ALL HINDI B1 VERIFICATIONS PASSED! 100% compliant.")

