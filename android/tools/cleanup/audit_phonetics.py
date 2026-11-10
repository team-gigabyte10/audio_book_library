#!/usr/bin/env python3
import json
import glob
import re

def audit_all():
    print("=== EXTENDED PHONETICS AUDIT ===")
    
    # 1. German Ja -> জা check, and V -> ভ check
    de_files = sorted(glob.glob("android/app/src/main/assets/spoken_german_*.json"))
    de_issues = []
    for f in de_files:
        with open(f, "r", encoding="utf-8") as fp:
            d = json.load(fp)
        for p in d.get("parts", []):
            for l in p.get("lessons", []):
                for it in l.get("items", []):
                    tgt = it.get("target", "")
                    pron = it.get("bn_pron", "")
                    # Ja check
                    if re.search(r"\bJa\b", tgt) and re.search(r"(^|\s)জা(\s|,|$)", pron):
                        de_issues.append((f, it["id"], tgt, pron, "Ja -> ইয়া"))
                    # Vater check
                    if re.search(r"\bVater\b", tgt, re.I) and re.search(r"ভাটার", pron):
                        de_issues.append((f, it["id"], tgt, pron, "Vater -> ফাটার"))
                    # viel check
                    if re.search(r"\bviel(e|en|er|es)?\b", tgt, re.I) and re.search(r"\bভীল\b", pron):
                        de_issues.append((f, it["id"], tgt, pron, "viel -> ফিল"))
                    # ৎস্সু check -> ৎসু
                    if "ৎস্সু " in pron:
                        de_issues.append((f, it["id"], tgt, pron, "ৎস্সু -> ৎসু"))
    print(f"German issues found: {len(de_issues)}")
    for iss in de_issues[:10]:
        print(f"  {iss[1]} | {iss[2]} --> {iss[3]} (Fix: {iss[4]})")

    # 2. English checks
    en_files = sorted(glob.glob("android/app/src/main/assets/spoken_english_*.json"))
    en_issues = []
    for f in en_files:
        with open(f, "r", encoding="utf-8") as fp:
            d = json.load(fp)
        for p in d.get("parts", []):
            for l in p.get("lessons", []):
                for it in l.get("items", []):
                    tgt = it.get("target", "")
                    pron = it.get("bn_pron", "")
                    if re.search(r"\bWednesday\b", tgt, re.I) and re.search(r"ওয়েডনেসডে", pron):
                        en_issues.append((f, it["id"], tgt, pron, "Wednesday -> ওয়েনসডে"))
                    if re.search(r"\biron\b", tgt, re.I) and re.search(r"আইরন", pron):
                        en_issues.append((f, it["id"], tgt, pron, "iron -> আয়র্ন"))
                    if re.search(r"\bplumber\b", tgt, re.I) and re.search(r"প্লাম্বার", pron):
                        en_issues.append((f, it["id"], tgt, pron, "plumber -> প্লামার"))
                    if re.search(r"\bsubtle\b", tgt, re.I) and re.search(r"সাবটল", pron):
                        en_issues.append((f, it["id"], tgt, pron, "subtle -> সাটল"))
    print(f"\nEnglish issues found: {len(en_issues)}")
    for iss in en_issues[:10]:
        print(f"  {iss[1]} | {iss[2]} --> {iss[3]} (Fix: {iss[4]})")

    # 3. Japanese checks
    jp_files = sorted(glob.glob("android/app/src/main/assets/spoken_japanese_*.json"))
    jp_issues = []
    for f in jp_files:
        with open(f, "r", encoding="utf-8") as fp:
            d = json.load(fp)
        for p in d.get("parts", []):
            for l in p.get("lessons", []):
                for it in l.get("items", []):
                    tgt = it.get("target", "")
                    pron = it.get("bn_pron", "")
                    # Check particle は transliterated as হা instead of ওয়া
                    if re.search(r"[^\w]は[^\w]", tgt) and " হা " in pron:
                        jp_issues.append((f, it["id"], tgt, pron, "は -> ওয়া"))
    print(f"\nJapanese issues found: {len(jp_issues)}")
    for iss in jp_issues[:10]:
        print(f"  {iss[1]} | {iss[2]} --> {iss[3]} (Fix: {iss[4]})")

    return de_issues, en_issues, jp_issues

if __name__ == "__main__":
    audit_all()
