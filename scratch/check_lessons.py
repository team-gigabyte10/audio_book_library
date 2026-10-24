import json
import sys

sys.stdout.reconfigure(encoding='utf-8')
with open('android/app/src/main/assets/spoken_japanese_foundations.json', encoding='utf-8') as f:
    d = json.load(f)

for p in d['parts']:
    print(f"=== {p['id']}: {p['title_bn']} ===")
    for l in p['lessons']:
        item_count = len(l.get('items', []))
        print(f"  {l['id']}: {l['title_bn']} [{item_count} items]")
