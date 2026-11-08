"""Comprehensive verification of spoken_german_specialist_pro.json"""
import json
import os
import re

IGNORED = re.compile(r"[\s\u200c\u200d,.?!:;'\-—…\"„”«»]")
DIGITS = re.compile(r"\d")

asset_path = os.path.abspath("android/app/src/main/assets/spoken_german_specialist_pro.json")
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
    expected_pid = f"de-sp-{p_idx:02d}"
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
            if DIGITS.search(tgt):
                errors.append(f"Digit in {iid}: {tgt}")
            joined = "".join(t["t"] for t in tokens)
            if IGNORED.sub("", joined).lower() != IGNORED.sub("", tgt).lower():
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
    print("ALL VERIFICATIONS PASSED! 100% compliant with zero digits and exact token alignment.")
