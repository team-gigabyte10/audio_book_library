// Builds app/src/main/assets/spoken_korean_standard_a1.json from units_a1/*.mjs
import fs from "node:fs";
import path from "node:path";
import { fileURLToPath } from "node:url";

import { koreanA1Units1To4 } from "./units_a1/u01_u04.mjs";
import { koreanA1Units5To8 } from "./units_a1/u05_u08.mjs";
import { koreanA1Units9To12 } from "./units_a1/u09_u12.mjs";
import { koreanA1Units13To16 } from "./units_a1/u13_u16.mjs";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const OUT_PATH = path.resolve(
  __dirname,
  "../../app/src/main/assets/spoken_korean_standard_a1.json"
);

const allUnits = [
  ...koreanA1Units1To4,
  ...koreanA1Units5To8,
  ...koreanA1Units9To12,
  ...koreanA1Units13To16,
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
    id: "ko-standard-a1",
    target_lang: "ko",
    base_lang: "bn",
    title_bn: "কোরিয়ান স্পোকেন: শূন্য থেকে লেভেল A1",
    title_target: "표준 한국어 회화: 입문부터 A1까지",
    source: "Korean-Spoken-Curriculum-Plan.md, Phase 2 (Stage 0 + A1 Standard)",
    note: "Stage 0 Hangul/Batchim Bootcamp + A1 Standard Spoken Korean for Bangla speakers (TOPIK I Level 1 aligned).",
    welcome_text:
      "কোরিয়ান স্পোকেন কোর্সে স্বাগতম! শূন্য থেকে হাঙ্গুল উচ্চারণ, বাচ্ছিম নিয়ম এবং প্রতিদিনের প্রয়োজনীয় কোরিয়ান কথোপকথন শিখুন।",
  },
  ladder_default: [
    { play: "ko", speed: 0.8 },
    { play: "bn", speed: 1.1 },
    { play: "ko", speed: 0.94 },
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
