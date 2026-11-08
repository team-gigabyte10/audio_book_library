import re
import sys
import os

script_dir = os.path.dirname(os.path.abspath(__file__))
sys.path.insert(0, script_dir)

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

def main():
    assert len(raw_units) == 16, f"Expected 16 units, got {len(raw_units)}"
    total_lessons = 0
    total_items = 0

    for unit_id, title_bn, title_target, lessons in raw_units:
        assert len(lessons) == 4, f"{unit_id} expected 4 lessons, got {len(lessons)}"
        for l_idx, l in enumerate(lessons, 1):
            total_lessons += 1
            items = l["items"]
            assert len(items) == 8, f"{unit_id} l{l_idx} expected 8 items, got {len(items)}"
            for i_idx, it in enumerate(items, 1):
                total_items += 1
                tg = it[0]
                bn = it[1]
                bp = it[2]
                tok = it[3]
                assert not DIGITS.search(tg), f"Digit found in {unit_id} l{l_idx} i{i_idx}: {tg}"
                joined = "".join(t["t"] for t in tok)
                c_joined = IGNORED.sub("", joined)
                c_tg = IGNORED.sub("", tg)
                assert c_joined == c_tg, f"Token mismatch in {unit_id} l{l_idx} i{i_idx}: '{c_joined}' != '{c_tg}'"

    print(f"ALL 16 UNITS VALIDATED SUCCESSFULLY!")
    print(f"Total Units: {len(raw_units)}")
    print(f"Total Lessons: {total_lessons}")
    print(f"Total Items: {total_items}")

if __name__ == "__main__":
    main()
