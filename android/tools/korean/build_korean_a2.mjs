// Builds app/src/main/assets/spoken_korean_elementary_a2.json from units_a2/*.mjs
import fs from "node:fs";
import path from "node:path";
import { fileURLToPath } from "node:url";

import { koreanA2Units1To4 } from "./units_a2/u01_u04.mjs";
import { koreanA2Units5To8 } from "./units_a2/u05_u08.mjs";
import { koreanA2Units9To12 } from "./units_a2/u09_u12.mjs";
import { koreanA2Units13To16 } from "./units_a2/u13_u16.mjs";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const OUT_PATH = path.resolve(
  __dirname,
  "../../app/src/main/assets/spoken_korean_elementary_a2.json"
);

const allUnits = [
  ...koreanA2Units1To4,
  ...koreanA2Units5To8,
  ...koreanA2Units9To12,
  ...koreanA2Units13To16,
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
    id: "ko-elementary-a2",
    target_lang: "ko",
    base_lang: "bn",
    title_bn: "কোরিয়ান স্পোকেন: লেভেল A2",
    title_target: "초급 한국어 회화: A2",
    source: "Korean-Spoken-Curriculum-Plan.md, Phase 4 (Elementary A2)",
    note: "Elementary A2 spoken Korean covering past/future tenses, connectors, bank/remittance, hospital, post office, workplace tasks & TOPIK I Level 2.",
    welcome_text:
      "কোরিয়ান স্পোকেন লেভেল A2-তে স্বাগতম! অতীত-ভবিষ্যৎ কাল, ব্যাংক-রেমিট্যান্স, হাসপাতাল, ডাকঘর ও কর্মক্ষেত্রের কথোপকথন অনুশীলন করুন।",
  },
  ladder_default: [
    { play: "ko", speed: 0.82 },
    { play: "bn", speed: 1.1 },
    { play: "ko", speed: 0.96 },
    { play: "ko", speed: 1.0 },
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
