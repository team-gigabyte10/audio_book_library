#!/usr/bin/env python3
"""
Applies multi-language phonetic normalization to align written Bengali transliterations
with standard Text-to-Speech audio output:
1. German: Normalizes heavy/unnatural 'ৎস্স' ligatures to standard 'ৎস' (e.g., ৎস্সু -> ৎসু, ৎস্সাইট -> ৎসাইট).
2. English: Fixes silent letters (e.g., ওয়েডনেসডে -> ওয়েনসডে in en-b2-05-l03-003).
"""

import json
import glob
import os

def normalize_german():
    de_files = sorted(glob.glob("android/app/src/main/assets/spoken_german_*.json"))
    modified_total = 0
    for file_path in de_files:
        with open(file_path, "r", encoding="utf-8") as f:
            data = json.load(f)
        
        file_mod = 0
        for part in data.get("parts", []):
            for lesson in part.get("lessons", []):
                for item in lesson.get("items", []):
                    pron = item.get("bn_pron")
                    if pron and "ৎস্স" in pron:
                        item["bn_pron"] = pron.replace("ৎস্স", "ৎস")
                        file_mod += 1
        
        if file_mod > 0:
            with open(file_path, "w", encoding="utf-8") as f:
                json.dump(data, f, ensure_ascii=False, indent=2)
                f.write("\n")
            print(f"Normalized {file_mod} items in {os.path.basename(file_path)}")
            modified_total += file_mod
            
    print(f"Total German items normalized: {modified_total}\n")

def normalize_english():
    b2_file = os.path.join("android", "app", "src", "main", "assets", "spoken_english_standard_b2.json")
    with open(b2_file, "r", encoding="utf-8") as f:
        data = json.load(f)
    
    b2_mod = 0
    for part in data.get("parts", []):
        for lesson in part.get("lessons", []):
            for item in lesson.get("items", []):
                if item.get("id") == "en-b2-05-l03-003":
                    pron = item.get("bn_pron", "")
                    if "ওয়েডনেসডে" in pron:
                        item["bn_pron"] = pron.replace("ওয়েডনেসডে", "ওয়েনসডে")
                        b2_mod += 1
                        
    if b2_mod > 0:
        with open(b2_file, "w", encoding="utf-8") as f:
            json.dump(data, f, ensure_ascii=False, indent=2)
            f.write("\n")
        print(f"Normalized {b2_mod} items in spoken_english_standard_b2.json\n")

def main():
    normalize_german()
    normalize_english()

if __name__ == "__main__":
    main()
