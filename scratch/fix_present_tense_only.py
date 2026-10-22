import json
import sys

sys.stdout.reconfigure(encoding='utf-8')

FILE_PATH = 'android/app/src/main/assets/spoken_english_foundations.json'
data = json.load(open(FILE_PATH, encoding='utf-8'))

# Filter to keep ONLY Parts 1 to 12 (Present Tense)
present_parts = []
for p in data['parts']:
    part_num = int(p['id'].replace('en-foundations-p', ''))
    if part_num <= 12:
        present_parts.append(p)

data['parts'] = present_parts

total_lessons = sum(len(p['lessons']) for p in present_parts)
total_items = sum(sum(len(l['items']) for l in p['lessons']) for p in present_parts)

data['stats'] = {
    "lessons": total_lessons,
    "items": total_items
}

with open(FILE_PATH, 'w', encoding='utf-8') as f:
    json.dump(data, f, indent=2, ensure_ascii=False)

print(f"Fixed! spoken_english_foundations.json now contains only Present Tense:")
print(f"Total parts: {len(present_parts)}")
print(f"Total lessons: {total_lessons}")
print(f"Total items: {total_items}")
for p in present_parts:
    print(f"Part {p['order']}: {p['title_bn']}")
