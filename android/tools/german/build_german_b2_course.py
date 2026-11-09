"""Compiles Level B2 (Units de-b2-01 to de-b2-16) for German Spoken Course."""
import json
import os
import re
import sys

script_dir = os.path.dirname(os.path.abspath(__file__))
generators_dir = os.path.join(script_dir, "generators")
sys.path.insert(0, generators_dir)

import data_b2_u01_u04
import data_b2_u05_u08
import data_b2_u09_u12
import data_b2_u13_u16

IGNORED = re.compile(r"[\s\u200c\u200d,.?!:;'\-—…\"„”«»]")
DIGITS = re.compile(r"\d")

raw_units = [
    ("de-b2-01", "সূক্ষ্ম মতামত ও অনিশ্চয়তার মাত্রা", "Differenzierte Meinungsäußerung und Nuancen", data_b2_u01_u04.u01_lessons),
    ("de-b2-02", "কর্পোরেট মিটিং ও টিম আলোচনা", "Besprechungen leiten, Wortmeldungen und Konsens", data_b2_u01_u04.u02_lessons),
    ("de-b2-03", "ব্যবসায়িক দরকষাকষি ও গ্রাহক সেবা", "Verhandlungen führen, Konditionen und Kundenbetreuung", data_b2_u01_u04.u03_lessons),
    ("de-b2-04", "ক্লিনিক্যাল নার্সিং ও স্বাস্থ্যসেবা শিফট হ্যান্ডওভার", "Klinische Übergabe, Pflegebericht und Empathie", data_b2_u01_u04.u04_lessons),
    ("de-b2-05", "নমিনালস্টাইল থেকে প্রাঞ্জল কথ্য রূপে রূপান্তর", "Nominalstil entschlüsseln und verbal ausdrücken", data_b2_u05_u08.u05_lessons),
    ("de-b2-06", "যুক্তিতর্কে অ্যাডভান্সড কনজুঙ্কটিভ ২", "Erweiterter Konjunktiv II in Argumentationen", data_b2_u05_u08.u06_lessons),
    ("de-b2-07", "অ্যাডভান্সড প্যাসিভ ও এর বিকল্পসমূহ", "Passiversatzformen: lässt sich, ist zu, man kann", data_b2_u05_u08.u07_lessons),
    ("de-b2-08", "কাঠামোবদ্ধ আনুষ্ঠানিক প্রেজেন্টেশন (B2)", "Strukturierte Fachpräsentationen und Visualisierung", data_b2_u05_u08.u08_lessons),
    ("de-b2-09", "একাডেমিক ও বৈজ্ঞানিক যুক্তিতর্ক", "Wissenschaftliche Diskussion und Kausalitätsketten", data_b2_u09_u12.u09_lessons),
    ("de-b2-10", "কর্মক্ষেত্রের দ্বন্দ্ব ও বিরোধ নিরসন", "Konfliktbewältigung, Diplomatie und Deeskalation", data_b2_u09_u12.u10_lessons),
    ("de-b2-11", "জার্মান গণমাধ্যম, সংবাদ ও সামাজিক প্রবণতা", "Mediensprache, Tagesschau und gesellschaftliche Debatten", data_b2_u09_u12.u11_lessons),
    ("de-b2-12", "স্বাভাবিক কথ্য রূপ ও কথোপকথনের ফিলার্স", "Umgangssprache, Redefluss und Konversationspartikeln", data_b2_u09_u12.u12_lessons),
    ("de-b2-13", "আইটি ও ইঞ্জিনিয়ারিং হাই-স্কিল ইন্টারভিউ (STAR)", "Fachbezogene Bewerbungsgespräche nach der STAR-Methode", data_b2_u13_u16.u13_lessons),
    ("de-b2-14", "জার্মান রসবোধ, ব্যঙ্গ ও সাংস্কৃতিক দ্যোতনা", "Deutscher Humor, Ironie und kulturelle Zwischentöne", data_b2_u13_u16.u14_lessons),
    ("de-b2-15", "আনুষ্ঠানিক কোলোকেশন (Nomen-Verb-Verbindungen)", "Feste Nomen-Verb-Verbindungen im Berufsalltag", data_b2_u13_u16.u15_lessons),
    ("de-b2-16", "গোয়েথে/telc B2 স্পিকিং পরীক্ষা সিমুলেশন", "Goethe und telc B2 Mündliche Prüfung Simulation", data_b2_u13_u16.u16_lessons),
]

def make_item(stem, lesson_no, index, target, bn, bn_pron, tokens, gender=None, speaker=None, item_type="sentence"):
    joined = "".join(t["t"] for t in tokens)
    cleaned_joined = IGNORED.sub("", joined)
    cleaned_target = IGNORED.sub("", target)
    if cleaned_joined != cleaned_target:
        raise ValueError(f"Token mismatch in {stem} l{lesson_no} #{index}: '{cleaned_joined}' != '{cleaned_target}'")
    if DIGITS.search(target):
        raise ValueError(f"Digit found in {stem} l{lesson_no} #{index}: '{target}'")

    item_id = f"{stem}-l{lesson_no:02d}-{index:03d}"
    out = {
        "id": item_id,
        "concept_id": f"c-{item_id}",
        "order": index,
        "type": item_type,
        "level": "B2",
        "target": target.strip(),
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
    return out

def main():
    print(f"Total raw parts to build: {len(raw_units)}")

    built_parts = []
    total_lessons = 0
    total_items = 0

    for p_idx, (stem, title_bn, title_target, lessons) in enumerate(raw_units, 1):
        built_lessons = []
        for l_idx, lesson_dict in enumerate(lessons, 1):
            total_lessons += 1
            lesson_id = f"{stem}-l{l_idx:02d}"
            built_items = []
            for i_idx, item_tuple in enumerate(lesson_dict["items"], 1):
                total_items += 1
                target, bn, bn_pron, tokens = item_tuple[0], item_tuple[1], item_tuple[2], item_tuple[3]
                gender = item_tuple[4] if len(item_tuple) > 4 else None
                speaker = item_tuple[5] if len(item_tuple) > 5 else None
                item_obj = make_item(stem, l_idx, i_idx, target, bn, bn_pron, tokens, gender, speaker)
                built_items.append(item_obj)

            built_lessons.append({
                "id": lesson_id,
                "order": l_idx,
                "title_bn": lesson_dict["title_bn"],
                "title_target": lesson_dict["title_target"],
                "intro_bn": lesson_dict.get("intro_bn", ""),
                "structure": lesson_dict.get("structure", []),
                "items": built_items
            })

        built_parts.append({
            "id": stem,
            "order": p_idx,
            "level": "B2",
            "title_bn": title_bn,
            "title_target": title_target,
            "lessons": built_lessons
        })

    course_data = {
        "schema_version": 1,
        "course": {
            "id": "de-standard-b2",
            "title_bn": "জার্মান স্পোকেন কোর্স: লেভেল B2",
            "title_target": "Spoken German Masterclass: Niveau B2",
            "target_lang": "de",
            "base_lang": "bn",
            "version": "1.0.0"
        },
        "stats": {
            "parts": len(built_parts),
            "lessons": total_lessons,
            "items": total_items
        },
        "parts": built_parts
    }

    out_path = os.path.abspath(os.path.join(script_dir, "../../app/src/main/assets/spoken_german_standard_b2.json"))
    with open(out_path, "w", encoding="utf-8") as f:
        json.dump(course_data, f, ensure_ascii=False, indent=2)

    print(f"Total parts: {len(built_parts)}, lessons: {total_lessons}, items: {total_items}")
    print(f"Successfully generated {out_path}")
    print(f"File size: {os.path.getsize(out_path):,} bytes")

if __name__ == "__main__":
    main()

