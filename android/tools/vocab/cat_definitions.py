# -*- coding: utf-8 -*-
"""
Helper for generating 1,000 vocabulary words across 5 languages.
"""

def make_vocab_item(id_str, cat_enum, sg_target, sg_pron, pl_target=None, pl_pron=None, sg_sec=None, pl_sec=None, bn_meaning="", gender="NONE", de_art_sg=None, de_art_pl=None, note=None):
    lines = []
    lines.append("        VocabItem(")
    lines.append(f'            id = "{id_str}",')
    lines.append(f"            category = VocabCategory.{cat_enum},")
    lines.append(f'            singularTarget = "{sg_target}",')
    lines.append(f'            singularBnPron = "{sg_pron}",')
    if sg_sec:
        lines.append(f'            singularSecondary = "{sg_sec}",')
    if pl_target:
        lines.append(f'            pluralTarget = "{pl_target}",')
    if pl_pron:
        lines.append(f'            pluralBnPron = "{pl_pron}",')
    if pl_sec:
        lines.append(f'            pluralSecondary = "{pl_sec}",')
    lines.append(f'            bnMeaning = "{bn_meaning}",')
    lines.append(f"            gender = GrammaticalGender.{gender},")
    if de_art_sg:
        lines.append(f'            germanArticleSingular = "{de_art_sg}",')
    if de_art_pl:
        lines.append(f'            germanArticlePlural = "{de_art_pl}",')
    if note:
        lines.append(f'            noteBn = "{note}"')
    else:
        # remove trailing comma on previous line if needed, or leave clean
        pass
    lines.append("        ),")
    return "\n".join(lines)
