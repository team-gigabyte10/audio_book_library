# -*- coding: utf-8 -*-
"""Validation test script for Urdu C1 course units."""
import re
import sys
import os

script_dir = os.path.dirname(os.path.abspath(__file__))
generators_dir = os.path.join(script_dir, "generators")
if generators_dir not in sys.path:
    sys.path.insert(0, generators_dir)

IGNORED = re.compile(r"[\sـ‌‍۔،؟!?.,:؛\-…\"'()]+")
MARKS = re.compile(r"[ً-ْٰٖ-ٟ]")

def test_module(module_name):
    print(f"--- Testing {module_name} ---")
    mod = __import__(module_name)
    raw_parts = getattr(mod, "raw_parts")
    print(f"Found {len(raw_parts)} parts in {module_name}")

    total_lessons = 0
    total_items = 0
    errors = []

    for stem, title_bn, title_target, lessons in raw_parts:
        if len(lessons) != 4:
            errors.append(f"Part {stem} has {len(lessons)} lessons, expected 4")
        for l_idx, l in enumerate(lessons, 1):
            total_lessons += 1
            items = l["items"]
            if len(items) != 8:
                errors.append(f"Lesson {stem}-l{l_idx:02d} has {len(items)} items, expected 8")
            for i_idx, it in enumerate(items, 1):
                total_items += 1
                tg, tm, bn, bp, tok = it[0], it[1], it[2], it[3], it[4]

                # verify non-empty strings
                if not tg or not tm or not bn or not bp:
                    errors.append(f"{stem}-l{l_idx:02d} #{i_idx}: empty text field")

                # token matching
                joined = "".join(t["t"] for t in tok)
                cleaned_joined = IGNORED.sub("", MARKS.sub("", joined))
                cleaned_target = IGNORED.sub("", MARKS.sub("", tg))

                if cleaned_joined != cleaned_target:
                    errors.append(
                        f"Mismatch in {stem}-l{l_idx:02d} #{i_idx}:\n"
                        f"  Target: '{cleaned_target}'\n"
                        f"  Joined: '{cleaned_joined}'\n"
                        f"  Original: '{tg}'\n"
                        f"  Tokens: '{joined}'"
                    )

    print(f"Total parts: {len(raw_parts)}, lessons: {total_lessons}, items: {total_items}")
    if errors:
        print(f"FAILED with {len(errors)} errors:")
        for e in errors[:10]:
            print(f"  - {e}")
        if len(errors) > 10:
            print(f"  ... and {len(errors) - 10} more.")
        return False
    else:
        print("ALL CHECKS PASSED PERFECTLY!")
        return True

if __name__ == "__main__":
    modules = ["data_c1_u01_u04"]
    if len(sys.argv) > 1:
        modules = sys.argv[1:]
    all_ok = True
    for m in modules:
        if not test_module(m):
            all_ok = False
    sys.exit(0 if all_ok else 1)
