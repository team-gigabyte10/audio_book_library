# -*- coding: utf-8 -*-
"""
Pack 1: Categories 1 to 5 (250 items)
1. FAMILY (50 items)
2. BODY (50 items)
3. FOOD (50 items)
4. FRUITS (50 items)
5. HOME (50 items)

Each tuple:
(id_num, cat, bn,
 en_sg, en_pl, en_pron_sg, en_pron_pl, en_gender,
 de_sg, de_pl, de_art_sg, de_art_pl, de_pron_sg, de_pron_pl, de_gender,
 hi_sg, hi_pl, hi_pron_sg, hi_pron_pl, hi_gender,
 ur_sg, ur_pl, ur_pron_sg, ur_pron_pl, ur_gender,
 ja_sg, ja_pl, ja_pron_sg, ja_pron_pl, ja_sec_sg, ja_sec_pl)
"""

PACK1_ITEMS = []

# Helper to add item
def add_item(num, cat, bn,
             en_sg, en_pl, en_psg, en_ppl, en_g,
             de_sg, de_pl, de_asg, de_apl, de_psg, de_ppl, de_g,
             hi_sg, hi_pl, hi_psg, hi_ppl, hi_g,
             ur_sg, ur_pl, ur_psg, ur_ppl, ur_g,
             ja_sg, ja_pl, ja_psg, ja_ppl, ja_ssg, ja_spl):
    PACK1_ITEMS.append({
        "num": num, "cat": cat, "bn": bn,
        "en": (en_sg, en_pl, en_psg, en_ppl, en_g),
        "de": (de_sg, de_pl, de_asg, de_apl, de_psg, de_ppl, de_g),
        "hi": (hi_sg, hi_pl, hi_psg, hi_ppl, hi_g),
        "ur": (ur_sg, ur_pl, ur_psg, ur_ppl, ur_g),
        "ja": (ja_sg, ja_pl, ja_psg, ja_ppl, ja_ssg, ja_spl)
    })

print("Pack 1 helper loaded.")
