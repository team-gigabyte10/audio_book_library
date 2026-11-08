"""Generates Level B2 Part 1 (Units ur-b2-01 to ur-b2-08) for Urdu Spoken Course."""
import re
import os
import sys

script_dir = os.path.dirname(os.path.abspath(__file__))
if script_dir not in sys.path:
    sys.path.insert(0, script_dir)

IGNORED = re.compile(r"[\sـ‌‍۔،؟!?.,:؛\-…\"'()]+")
MARKS = re.compile(r"[ً-ْٰٖ-ٟ]")

def make_item(stem, lesson_no, index, target, target_marked, bn, bn_pron, tokens, gender=None, female_target=None, female_pron=None, speaker=None, item_type="sentence"):
    joined = "".join(t["t"] for t in tokens)
    cleaned_joined = IGNORED.sub("", MARKS.sub("", joined))
    cleaned_target = IGNORED.sub("", MARKS.sub("", target))
    if cleaned_joined != cleaned_target:
        raise ValueError(f"Token mismatch in {stem} l{lesson_no} #{index}: '{cleaned_joined}' != '{cleaned_target}'")

    item_id = f"{stem}-l{lesson_no:02d}-{index:03d}"
    out = {
        "id": item_id,
        "concept_id": f"c-{item_id}",
        "order": index,
        "type": item_type,
        "level": "B2",
        "target": target.strip(),
        "target_marked": target_marked.strip(),
        "bn": bn.strip(),
        "bn_pron": bn_pron.strip(),
        "tokens": [{"t": t["t"], "bn": t.get("bn")} for t in tokens],
        "tags": {"cefr": "B2"},
        "status": "ready",
        "review_flags": []
    }
    if gender:
        out["gender"] = gender
    if speaker:
        out["speaker"] = speaker
    if female_target and female_pron:
        out["example"] = {
            "target": female_target.strip(),
            "bn": female_pron.strip()
        }
    return out

from data_b2_u01_u04 import raw_parts as p1_u01_u04
from data_b2_u05_u08 import raw_parts as p1_u05_u08

parts_p1 = p1_u01_u04 + p1_u05_u08
