# -*- coding: utf-8 -*-
"""Validation test script for Hindi B2 course units."""
import re
import sys
import os

script_dir = os.path.dirname(os.path.abspath(__file__))
generators_dir = os.path.join(script_dir, "generators")
if generators_dir not in sys.path:
    sys.path.insert(0, generators_dir)

IGNORED = re.compile(r"[\s\u200c\u200d।,?!;:\"'—\-…]")
DEVANAGARI = re.compile(r"[\u0900-\u097F]")

def test_module(module_name, var_name):
    print(f"--- Testing {module_name} ---")
    mod = __import__(module_name)
    raw_units = getattr(mod, var_name)
    print(f"Found {len(raw_units)} units in {module_name}")

    total_lessons = 0
    total_items = 0
    errors = []

    for unit in raw_units:
        stem = unit["unit_id"]
        lessons = unit["lessons"]
        if len(lessons) != 4:
            errors.append(f"Unit {stem} has {len(lessons)} lessons, expected 4")
        for l_idx, l in enumerate(lessons, 1):
            total_lessons += 1
            items = l["items"]
            if len(items) != 8:
                errors.append(f"Lesson {stem}-l{l_idx:02d} has {len(items)} items, expected 8")
            for i_idx, it in enumerate(items, 1):
                total_items += 1
                tg, bn, bp, tok = it[0], it[1], it[2], it[3]

                if not tg or not bn or not bp:
                    errors.append(f"{stem}-l{l_idx:02d} #{i_idx}: empty text field")

                if not DEVANAGARI.search(tg):
                    errors.append(f"{stem}-l{l_idx:02d} #{i_idx}: no Devanagari in '{tg}'")

                joined = "".join(t["t"] for t in tok)
                cleaned_joined = IGNORED.sub("", joined)
                cleaned_target = IGNORED.sub("", tg)

                if cleaned_joined != cleaned_target:
                    errors.append(
                        f"Mismatch in {stem}-l{l_idx:02d} #{i_idx}:\n"
                        f"  Target: '{cleaned_target}'\n"
                        f"  Joined: '{cleaned_joined}'"
                    )

    print(f"Total units: {len(raw_units)}, lessons: {total_lessons}, items: {total_items}")
    if errors:
        print(f"FAILED with {len(errors)} errors:")
        for e in errors[:10]:
            print(f"  - {e}")
        return False
    else:
        print("ALL CHECKS PASSED PERFECTLY!")
        return True

if __name__ == "__main__":
    pairs = [
        ("data_b2_u01_u04", "UNITS_B2_U01_U04"),
        ("data_b2_u09_u12", "UNITS_B2_U09_U12"),
        ("data_b2_u13_u16", "UNITS_B2_U13_U16"),
    ]
    all_ok = True
    for m, v in pairs:
        if not test_module(m, v):
            all_ok = False
    sys.exit(0 if all_ok else 1)

