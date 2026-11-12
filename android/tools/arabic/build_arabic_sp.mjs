// Builds app/src/main/assets/spoken_arabic_specialist_pro.json from units_sp/*.mjs
import fs from "node:fs";
import path from "node:path";
import { fileURLToPath } from "node:url";

import { arabicSpUnits1To4 } from "./units_sp/u01_u04.mjs";
import { arabicSpUnits5To8 } from "./units_sp/u05_u08.mjs";
import { arabicSpUnits9To12 } from "./units_sp/u09_u12.mjs";
import { arabicSpUnits13To16 } from "./units_sp/u13_u16.mjs";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const OUT_PATH = path.resolve(
  __dirname,
  "../../app/src/main/assets/spoken_arabic_specialist_pro.json"
);

const allUnits = [
  ...arabicSpUnits1To4,
  ...arabicSpUnits5To8,
  ...arabicSpUnits9To12,
  ...arabicSpUnits13To16,
];

let totalLessons = 0;
let totalItems = 0;

const parts = allUnits.map((unit) => {
  const lessons = unit.lessons.map((lesson) => {
    totalLessons += 1;
    const items = lesson.items.map((raw, idx) => {
      totalItems += 1;
      const itemOrder = idx + 1;
      const itemId = `${lesson.id}-${String(itemOrder).padStart(3, "0")}`;
      const built = {
        id: itemId,
        concept_id: `c-${itemId}`,
        order: itemOrder,
        type: raw.type,
        level: raw.level,
        target: raw.target,
        bn: raw.bn,
        bn_pron: raw.bn_pron,
        tokens: raw.tokens,
        tags: { cefr: raw.level },
        status: "verified",
        review_flags: [],
      };
      if (raw.speaker) {
        built.speaker = raw.speaker;
      }
      return built;
    });

    return {
      id: lesson.id,
      order: lesson.order,
      title_bn: lesson.title_bn,
      title_target: lesson.title_target,
      intro_bn: lesson.intro_bn,
      structure: lesson.structure,
      items,
    };
  });

  return {
    id: unit.id,
    order: unit.order,
    level: unit.level,
    title_bn: unit.title_bn,
    title_target: unit.title_target,
    lessons,
  };
});

const payload = {
  schema_version: 1,
  course: {
    id: "ar-specialist-pro",
    target_lang: "ar",
    base_lang: "bn",
    title_bn: "আরবি স্পোকেন: স্পেশালিস্ট প্রো",
    title_target: "العربية التخصصية: الحج والخليج والتجارة",
    source: "Arabic-Spoken-Curriculum-Plan.md, Phase 5 (Specialist Pro: Gulf, Hajj & Trade)",
    note: "Specialist Pro spoken Arabic for Gulf expats, Hajj/Umrah guides, import/export, banking L/C, engineering, legal courts, and rapid Gulf slang.",
    welcome_text:
      "আরবি স্পেশালিস্ট প্রো কোর্সে স্বাগতম! হজ্জ ও উমরাহ গাইডিং, গাল্ফ প্রবাসী জীবন, দুবাই-রিয়াদ ব্যবসা, আদালত-থানা ও দ্রুত কথোপকথন আয়ত্ত করুন।",
  },
  ladder_default: [
    { play: "ar", speed: 0.84 },
    { play: "bn", speed: 1.1 },
    { play: "ar", speed: 0.98 },
    { play: "ar", speed: 1.0 },
    { pause_ms: 1200 },
  ],
  stats: {
    parts: parts.length,
    lessons: totalLessons,
    items: totalItems,
  },
  parts,
};

fs.mkdirSync(path.dirname(OUT_PATH), { recursive: true });
fs.writeFileSync(OUT_PATH, JSON.stringify(payload, null, 2) + "\n", "utf8");
console.log(
  `Built ${OUT_PATH}: ${parts.length} parts, ${totalLessons} lessons, ${totalItems} items.`
);
