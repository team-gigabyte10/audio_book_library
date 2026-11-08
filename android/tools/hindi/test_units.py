# -*- coding: utf-8 -*-
import sys, os, re

sys.path.insert(0, os.path.join(os.path.dirname(__file__), "generators"))
from data_b1_u01_u04 import UNITS_B1_U01_U04
from data_b1_u05_u08 import UNITS_B1_U05_U08
from data_b1_u09_u12 import UNITS_B1_U09_U12
from data_b1_u13_u16 import UNITS_B1_U13_U16

IGNORED = re.compile(r"[\s।,?!;:\"'—\-]+")

def test_units(units, label):
    errors = 0
    total = 0
    digit_re = re.compile(r'[0-9]')
    allowed_target_re = re.compile(r"^[\u0900-\u097F\s।,?!;:\"'—\-\(\)]+$")

    for u in units:
        assert len(u['lessons']) == 4, f"{u['unit_id']} has {len(u['lessons'])} lessons"
        for l_idx, l in enumerate(u['lessons']):
            assert len(l['items']) == 8, f"{u['unit_id']} lesson {l_idx} has {len(l['items'])} items"
            for i_idx, item in enumerate(l['items']):
                total += 1
                target, bn, pron, tokens, gf, alt_t, alt_p = item
                clean_target = IGNORED.sub("", target)
                tok_str = "".join(tok['t'] for tok in tokens)
                clean_tok = IGNORED.sub("", tok_str)
                if clean_target != clean_tok:
                    print(f"MISMATCH in {u['unit_id']} L{l_idx+1} I{i_idx+1}:")
                    print(f"  Target: {target}")
                    print(f"  Tokens: {tok_str}")
                    errors += 1
                if digit_re.search(target):
                    print(f"DIGIT in {u['unit_id']} L{l_idx+1} I{i_idx+1}: {target}")
                    errors += 1
                if not allowed_target_re.match(target):
                    bad = [c for c in target if not allowed_target_re.match(c)]
                    print(f"NON-DEV in {u['unit_id']} L{l_idx+1} I{i_idx+1}: {target} -> Bad: {bad}")
                    errors += 1
                if alt_t:
                    if digit_re.search(alt_t):
                        print(f"DIGIT in alt_t {u['unit_id']} L{l_idx+1} I{i_idx+1}: {alt_t}")
                        errors += 1
                    if not allowed_target_re.match(alt_t):
                        bad = [c for c in alt_t if not allowed_target_re.match(c)]
                        print(f"NON-DEV in alt_t {u['unit_id']} L{l_idx+1} I{i_idx+1}: {alt_t} -> Bad: {bad}")
                        errors += 1
    print(f"[{label}] Tested {total} items. Errors: {errors}")
    return errors

if __name__ == "__main__":
    errs = 0
    errs += test_units(UNITS_B1_U01_U04, "U01-U04")
    errs += test_units(UNITS_B1_U05_U08, "U05-U08")
    errs += test_units(UNITS_B1_U09_U12, "U09-U12")
    errs += test_units(UNITS_B1_U13_U16, "U13-U16")
    if errs > 0:
        sys.exit(1)
    print("All validated successfully!")
