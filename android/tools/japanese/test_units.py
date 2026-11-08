# -*- coding: utf-8 -*-
import sys, os, re

sys.path.insert(0, os.path.join(os.path.dirname(__file__), "generators"))
from data_n4_u01_u05 import UNITS_N4_U01_U05
from data_n4_u06_u10 import UNITS_N4_U06_U10
from data_n4_u11_u15 import UNITS_N4_U11_U15

KANJI = re.compile(r"[一-鿿々]")
LATIN = re.compile(r"[A-Za-z]")
DIGIT = re.compile(r"[0-9]")
IGNORED = re.compile(r"[\s。、．，,.!！?？「」『』・〜~…ー―\-]+")

def test_units(units, label):
    errors = 0
    total = 0
    for u in units:
        assert len(u['lessons']) == 4, f"{u['unit_id']} has {len(u['lessons'])} lessons"
        for l_idx, l in enumerate(u['lessons']):
            assert len(l['items']) == 8, f"{u['unit_id']} lesson {l_idx} has {len(l['items'])} items"
            for i_idx, item in enumerate(l['items']):
                total += 1
                target, reading, bn, pron, tokens, gf, alt_t, alt_r, alt_p = item
                clean_target = IGNORED.sub("", target)
                tok_str = "".join(tok['t'] for tok in tokens)
                clean_tok = IGNORED.sub("", tok_str)
                if clean_target != clean_tok:
                    print(f"MISMATCH in {u['unit_id']} L{l_idx+1} I{i_idx+1}:")
                    print(f"  Target: {target}")
                    print(f"  Tokens: {tok_str}")
                    errors += 1
                if LATIN.search(target):
                    print(f"LATIN in {u['unit_id']} L{l_idx+1} I{i_idx+1}: {target}")
                    errors += 1
                if DIGIT.search(target):
                    print(f"DIGIT in {u['unit_id']} L{l_idx+1} I{i_idx+1}: {target}")
                    errors += 1
                if KANJI.search(target) and not reading:
                    print(f"MISSING READING in {u['unit_id']} L{l_idx+1} I{i_idx+1}: {target}")
                    errors += 1
                if not bn:
                    print(f"MISSING BN in {u['unit_id']} L{l_idx+1} I{i_idx+1}")
                    errors += 1
                if not pron:
                    print(f"MISSING PRON in {u['unit_id']} L{l_idx+1} I{i_idx+1}")
                    errors += 1
    print(f"[{label}] Tested {total} items. Errors: {errors}")
    return errors

if __name__ == "__main__":
    errs = 0
    errs += test_units(UNITS_N4_U01_U05, "U01-U05")
    errs += test_units(UNITS_N4_U06_U10, "U06-U10")
    errs += test_units(UNITS_N4_U11_U15, "U11-U15")
    if errs > 0:
        sys.exit(1)
    print("All validated successfully!")
