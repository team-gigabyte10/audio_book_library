"""Generates Level A2 Part 2 (Units de-a2-09 to de-a2-15) for German Spoken Course."""
import re
import sys
import os

sys.path.insert(0, os.path.dirname(__file__))
from data_u09_u10 import u09_lessons, u10_lessons
from data_u11_u12 import u11_lessons, u12_lessons
from data_u13_u14 import u13_lessons, u14_lessons
from data_u15 import u15_lessons

IGNORED = re.compile(r"[\s\u200c\u200d,.?!:;'\-—…\"„”«»]")
GENDER_LABEL = {"m": "পুং (der)", "f": "স্ত্রী (die)", "n": "ক্লীব (das)"}

def make_item(stem, lesson_no, index, target, bn, bn_pron, tokens, gender=None, speaker=None, item_type="sentence"):
    joined = "".join(t["t"] for t in tokens)
    cleaned_joined = IGNORED.sub("", joined).lower()
    cleaned_target = IGNORED.sub("", target).lower()
    if cleaned_joined != cleaned_target:
        raise ValueError(f"Token mismatch in {stem} l{lesson_no} #{index}: '{cleaned_joined}' != '{cleaned_target}'")

    item_id = f"{stem}-l{lesson_no:02d}-{index:03d}"
    pron_parts = [bn_pron.strip()]
    if gender in GENDER_LABEL:
        pron_parts.append(GENDER_LABEL[gender])
    full_pron = " · ".join(pron_parts)

    out = {
        "id": item_id,
        "concept_id": f"c-{item_id}",
        "order": index,
        "type": item_type,
        "level": "A2",
        "target": target.strip(),
        "bn": bn.strip(),
        "bn_pron": full_pron,
        "tokens": [{"t": t["t"], "bn": t.get("bn")} for t in tokens],
        "tags": {"cefr": "A2"},
        "status": "ready",
        "review_flags": []
    }
    if gender:
        out["gender"] = gender
    if speaker:
        out["speaker"] = speaker
    return out

parts_p2 = [
    ("de-a2-09", "বিশেষণ পদ ও পরিবর্তন", "Adjektivdeklination: bestimmter und unbestimmter Artikel", u09_lessons),
    ("de-a2-10", "অ্যাপয়েন্টমেন্ট ও আমন্ত্রণ নির্ধারণ", "Termine vereinbaren, verschieben und absagen", u10_lessons),
    ("de-a2-11", "অতীতের বর্ণনা: প্রেটেরিটুম রূপ", "Präteritum: war, hatte und Modalverben", u11_lessons),
    ("de-a2-12", "তুলনা ও সেরা নির্ধারণ", "Komparativ und Superlativ: Vergleiche anstellen", u12_lessons),
    ("de-a2-13", "ব্যাংক, পোস্ট অফিস ও নাগরিক সেবা কার্যালয়", "Behörden und Dienstleistungen: Bürgeramt, Bank und Post", u13_lessons),
    ("de-a2-14", "কর্মক্ষেত্র ও সহকর্মীদের সাথে যোগাযোগ", "Berufsalltag und Kommunikation am Arbeitsplatz", u14_lessons),
    ("de-a2-15", "A2 চূড়ান্ত পর্যালোচনা ও গোয়েথে A2 স্পিকিং প্রস্তুতি", "A2 Gesamtwiederholung und Goethe A2 Prüfungsvorbereitung", u15_lessons),
]

# Self-verification
total_items = 0
for stem, title_bn, title_target, lessons in parts_p2:
    for l_idx, l in enumerate(lessons, 1):
        for i_idx, it in enumerate(l["items"], 1):
            if len(it) == 7:
                tg, bn, bp, tok, gen, spk, itype = it
            elif len(it) == 4:
                tg, bn, bp, tok = it
                gen, spk, itype = None, None, "sentence"
            elif len(it) == 5:
                tg, bn, bp, tok, gen = it
                spk, itype = None, "sentence"
            else:
                raise ValueError(f"Unexpected tuple length {len(it)} in {stem} l{l_idx} #{i_idx}")
            make_item(stem, l_idx, i_idx, tg, bn, bp, tok, gen, spk, itype)
            total_items += 1

print(f"German A2 Part 2 loaded and verified with {len(parts_p2)} parts, {sum(len(p[3]) for p in parts_p2)} lessons, and {total_items} items.")
