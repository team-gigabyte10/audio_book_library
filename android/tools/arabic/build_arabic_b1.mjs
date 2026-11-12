// Builds app/src/main/assets/spoken_arabic_intermediate_b1.json from units_b1/*.mjs
import fs from "node:fs";
import path from "node:path";
import { fileURLToPath } from "node:url";

import { arabicB1Units1To4 } from "./units_b1/u01_u04.mjs";
import { arabicB1Units5To8 } from "./units_b1/u05_u08.mjs";
import { arabicB1Units9To12 } from "./units_b1/u09_u12.mjs";
import { arabicB1Units13To16 } from "./units_b1/u13_u16.mjs";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const OUT_PATH = path.resolve(
  __dirname,
  "../../app/src/main/assets/spoken_arabic_intermediate_b1.json"
);

const allUnits = [
  ...arabicB1Units1To4,
  ...arabicB1Units5To8,
  ...arabicB1Units9To12,
  ...arabicB1Units13To16,
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
    id: "ar-intermediate-b1",
    target_lang: "ar",
    base_lang: "bn",
    title_bn: "আরবি স্পোকেন: লেভেল B1",
    title_target: "العربية المحكية: المستوى المتوسط B1",
    source: "Arabic-Spoken-Curriculum-Plan.md, Phase 4 (Intermediate B1)",
    note: "Intermediate B1 spoken Arabic covering conditionals, opinions, Ejar contracts, Absher/Govt services, job interviews & Gulf-MSA fluency.",
    welcome_text:
      "আরবি স্পোকেন লেভেল B1-তে স্বাগতম! মতামত, শর্তমূলক বাক্য, আবশের-সরকারি সেবা ও চাকরির ইন্টারভিউয়ের আরবি অনুশীলন করুন।",
  },
  ladder_default: [
    { play: "ar", speed: 0.82 },
    { play: "bn", speed: 1.1 },
    { play: "ar", speed: 0.96 },
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
