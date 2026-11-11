"""Shared helpers and canonical 9-region metadata for thematic comparative Regional Bangla."""
import re

REGIONS = [
    ("ctg", "🏔️ চট্টগ্রাম (চাটগাঁইয়া)"),
    ("noa", "🌾 নোয়াখালী (নোয়াখাইল্লা)"),
    ("syl", "🍵 সিলেট (সিলেটি)"),
    ("dhk", "🏙️ ঢাকা (পুরান ঢাকাইয়া)"),
    ("bar", "⛵ বরিশাল (বরিশাইল্লা)"),
    ("raj", "🥭 রাজশাহী (বরেন্দ্রী)"),
    ("rng", "🪕 রংপুর (রংপুরিয়া)"),
    ("khl", "🌿 খুলনা-যশোর"),
    ("mym", "🌊 ময়মনসিংহ"),
]

REGION_MAP = dict(REGIONS)
REGION_ORDER = [r[0] for r in REGIONS]
PUNCT_STRIP = re.compile(r"^[।॥,?!.,:;'\-—…\"“”]+|[।॥,?!.,:;'\-—…\"“”]+$")


def build_tokens(text: str, glossary: dict):
    """Splits a regional sentence cleanly into exact tokens paired with Standard Bangla glosses."""
    words = text.strip().split()
    tokens = []
    for w in words:
        core = PUNCT_STRIP.sub("", w)
        gloss = glossary.get(w) or glossary.get(core) or core
        tokens.append({"t": w, "bn": gloss})
    return tokens


def make_group(concept_slug: str, std_bn: str, glossary: dict, variants: list):
    """Creates a canonical 9-region group sharing one Standard Bangla `concept_id`."""
    found_keys = [v[0] for v in variants]
    if found_keys != REGION_ORDER:
        raise ValueError(f"{concept_slug}: expected regions {REGION_ORDER}, got {found_keys}")
    out = []
    for reg_key, target, bn_pron in variants:
        out.append({
            "concept_id": f"c-bd-{concept_slug}",
            "region": reg_key,
            "speaker": REGION_MAP[reg_key],
            "target": target.strip(),
            "bn": std_bn.strip(),
            "bn_pron": bn_pron.strip().replace("\u0964", "\u09F7"),
            "tokens": build_tokens(target, glossary),
        })
    return out
