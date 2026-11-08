# -*- coding: utf-8 -*-
"""Verification script for spoken_japanese_standard_n4.json."""
import json
import os
import re
import sys

IGNORED = re.compile(r"[\s。、．，,.!！?？「」『』・〜~…ー―\-]+")
KANJI = re.compile(r"[一-鿿々]")
LATIN = re.compile(r"[A-Za-z]")
DIGIT = re.compile(r"[0-9]")

asset_path = os.path.abspath(os.path.join(os.path.dirname(__file__), "../../app/src/main/assets/spoken_japanese_standard_n4.json"))
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
assert len(parts) == 15, f"Expected 15 parts, got {len(parts)}"

total_lessons = 0
total_items = 0
errors = []

for p_idx, part in enumerate(parts, 1):
    pid = part.get("id")
    expected_pid = f"jp-n4-{p_idx:02d}"
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
            reading = item.get("reading", "")
            tokens = item.get("tokens", [])
            if LATIN.search(tgt):
                errors.append(f"Latin letter found in {iid}: {tgt}")
            if DIGIT.search(tgt):
                errors.append(f"Digit found in {iid}: {tgt}")
            if KANJI.search(tgt) and not reading:
                errors.append(f"Kanji without reading in {iid}: {tgt}")
            joined = "".join(t["t"] for t in tokens)
            if IGNORED.sub("", joined) != IGNORED.sub("", tgt):
                errors.append(f"Mismatch in {iid}: '{IGNORED.sub('', joined)}' != '{IGNORED.sub('', tgt)}'")
            if not bn:
                errors.append(f"Missing Bengali in {iid}")
            if not pron:
                errors.append(f"Missing pronunciation in {iid}")

print(f"Total Lessons: {total_lessons} (expected 60)")
print(f"Total Items: {total_items} (expected 480)")
assert total_lessons == 60
assert total_items == 480

if errors:
    print(f"FAILED with {len(errors)} errors:")
    for e in errors[:20]:
        print(" ", e)
    sys.exit(1)
else:
    print("ALL 480 ITEMS AND 15 PARTS VALIDATED PERFECTLY! 100% CLEAN!")
