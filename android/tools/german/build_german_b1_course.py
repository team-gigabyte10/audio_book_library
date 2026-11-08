"""Compiles Level B1 (Units de-b1-01 to de-b1-16) for German Spoken Course."""
import json
import os
import re
import sys

script_dir = os.path.dirname(os.path.abspath(__file__))
generators_dir = os.path.join(script_dir, "generators")
sys.path.insert(0, generators_dir)

import data_b1_u01_u04
import data_b1_u05_u08
import data_b1_u09_u12
import data_b1_u13_u16

IGNORED = re.compile(r"[\s\u200c\u200d,.?!:;'\-—…\"„”«»]")
DIGITS = re.compile(r"\d")

raw_units = [
    ("de-b1-01", "কারণ ও বিপরীতার্থক বাক্য (deshalb, trotzdem, obwohl)", "Kausal- und Konzessivsätze: deshalb, trotzdem, obwohl", data_b1_u01_u04.u01_lessons),
    ("de-b1-02", "কনজুঙ্কটিভ ২: বিনম্র অনুরোধ ও অবাস্তব কল্পনা", "Konjunktiv II: Höfliche Bitten und Wünsche", data_b1_u01_u04.u02_lessons),
    ("de-b1-03", "কর্মবাচ্য বা প্যাসিভ ভয়েস", "Passiv: Vorgangspassiv Präsens und Präteritum", data_b1_u01_u04.u03_lessons),
    ("de-b1-04", "সম্বন্ধসূচক বাক্য বা রিলেティブ ক্লজ", "Relativsätze im Nominativ, Akkusativ, Dativ und Genitiv", data_b1_u01_u04.u04_lessons),
    ("de-b1-05", "প্রাতিষ্ঠানিক ফোন কল ও বার্তা প্রদান", "Telefonieren im Beruf und Nachrichten hinterlassen", data_b1_u05_u08.u05_lessons),
    ("de-b1-06", "ব্যাংকিং, ব্লকড একাউন্ট ও সরকারি চিঠি", "Bankkonto, Sperrkonto und Behördenpost", data_b1_u05_u08.u06_lessons),
    ("de-b1-07", "জার্মানিতে ফ্ল্যাট ও বাসা ভাড়া", "Wohnungssuche, Mietvertrag und Kaution", data_b1_u05_u08.u07_lessons),
    ("de-b1-08", "আউসবিল্ডুং ও চাকরি ইন্টারভিউ প্রস্তুতি", "Vorstellungsgespräch und Ausbildung in Deutschland", data_b1_u05_u08.u08_lessons),
    ("de-b1-09", "সমস্যা, অভিযোগ ও প্রতিকার", "Reklamation, Beschwerde und Frist setzen", data_b1_u09_u12.u09_lessons),
    ("de-b1-10", "পরোক্ষ প্রশ্ন ও বিনম্র অনুসন্ধান", "Indirekte Fragen mit ob und W-Wörtern", data_b1_u09_u12.u10_lessons),
    ("de-b1-11", "ইনফিনিটিভ বাক্য: um... zu, ohne... zu, anstatt... zu", "Infinitivsätze mit um... zu, ohne... zu, anstatt... zu", data_b1_u09_u12.u11_lessons),
    ("de-b1-12", "স্বাস্থ্যবীমা ও জরুরি অবস্থা", "Krankenkasse, Notruf eins eins zwei und Notaufnahme", data_b1_u09_u12.u12_lessons),
    ("de-b1-13", "দ্বৈত সংযোগকারী (Doppelkonnektoren)", "Zweiteilige Konnektoren: sowohl... als auch, weder... noch", data_b1_u13_u16.u13_lessons),
    ("de-b1-14", "জার্মান কর্মসংস্কৃতি ও সামাজিক রীতিনীতি", "Deutsche Alltagskultur & Umgangsformen", data_b1_u13_u16.u14_lessons),
    ("de-b1-15", "গোয়েথে B1 কাঠামোবদ্ধ উপস্থাপনা", "Goethe B1 Präsentation Struktur & Redemittel", data_b1_u13_u16.u15_lessons),
    ("de-b1-16", "গোয়েথে B1 চূড়ান্ত স্পিকিং টেস্ট সিমুলেশন", "Goethe B1 Mündliche Prüfung Simulation", data_b1_u13_u16.u16_lessons),
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
        "level": "B1",
        "target": target.strip(),
        "bn": bn.strip(),
        "bn_pron": bn_pron.strip(),
        "tokens": [{"t": t["t"], "bn": t.get("bn")} for t in tokens],
        "tags": {"cefr": "B1"},
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
        for l_idx, l in enumerate(lessons, 1):
            built_items = []
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
                item = make_item(stem, l_idx, i_idx, tg, bn, bp, tok, gen, spk, itype)
                built_items.append(item)
                total_items += 1

            lesson_dict = {
                "id": f"{stem}-l{l_idx:02d}",
                "order": l_idx,
                "title_bn": l["title_bn"],
                "title_target": l["title_target"],
                "intro_bn": l.get("intro_bn", ""),
                "structure": l.get("structure", []),
                "items": built_items
            }
            built_lessons.append(lesson_dict)
            total_lessons += 1

        part_dict = {
            "id": stem,
            "order": p_idx,
            "level": "B1",
            "title_bn": title_bn,
            "title_target": title_target,
            "lessons": built_lessons
        }
        built_parts.append(part_dict)

    print(f"Total parts: {len(built_parts)}, lessons: {total_lessons}, items: {total_items}")

    # Integrity assertions
    assert len(built_parts) == 16, f"Expected 16 parts, got {len(built_parts)}"
    assert total_lessons == 64, f"Expected 64 lessons, got {total_lessons}"
    assert total_items == 512, f"Expected 512 items, got {total_items}"

    course_data = {
        "schema_version": 1,
        "course": {
            "id": "de-standard-b1",
            "target_lang": "de",
            "base_lang": "bn",
            "title_bn": "জার্মান স্পোকেন কোর্স: লেভেল B1",
            "title_target": "Deutsch: Niveau B1",
            "source": "German-Spoken-Curriculum-Plan.md, roadmap phase 3 (B1)",
            "note": "B1 Intermediate spoken German course covering subordinate clauses, Konjunktiv II, Passiv, Relativsätze, job interviews, healthcare, customer complaints, and Goethe/telc B1 presentation and oral exam simulation.",
            "welcome_text": "জার্মান B1 কোর্সে আপনাকে স্বাগতম! সাবঅর্ডিনেট ক্লজ, প্রাতিষ্ঠানিক যোগাযোগ ও B1 স্পিকিং মডেল টেস্টের অনুশীলন করুন।"
        },
        "ladder_default": [
            {"play": "target", "speed": 0.85},
            {"play": "bn", "speed": 1.15},
            {"play": "target", "speed": 0.95},
            {"play": "target", "speed": 1.05},
            {"pause_ms": 1200}
        ],
        "stats": {
            "lessons": total_lessons,
            "items": total_items
        },
        "parts": built_parts
    }

    out_path = os.path.abspath(os.path.join(script_dir, "../../app/src/main/assets/spoken_german_standard_b1.json"))
    with open(out_path, "w", encoding="utf-8") as f:
        json.dump(course_data, f, ensure_ascii=False, indent=2)
    print(f"Successfully generated {out_path} ({total_items} items in {total_lessons} lessons across {len(built_parts)} parts)")

if __name__ == "__main__":
    main()

