// Builds app/src/main/assets/spoken_korean_specialist_pro.json from units_sp/*.mjs
import fs from "node:fs";
import path from "node:path";
import { fileURLToPath } from "node:url";

import { koreanSpUnits1To4 } from "./units_sp/u01_u04.mjs";
import { koreanSpUnits5To8 } from "./units_sp/u05_u08.mjs";
import { koreanSpUnits9To12 } from "./units_sp/u09_u12.mjs";
import { koreanSpUnits13To16 } from "./units_sp/u13_u16.mjs";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const OUT_PATH = path.resolve(
  __dirname,
  "../../app/src/main/assets/spoken_korean_specialist_pro.json"
);

const allUnits = [
  ...koreanSpUnits1To4,
  ...koreanSpUnits5To8,
  ...koreanSpUnits9To12,
  ...koreanSpUnits13To16,
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
    id: "ko-specialist-pro",
    target_lang: "ko",
    base_lang: "bn",
    title_bn: "স্পেশালিস্ট প্রো: EPS-TOPIK, চাকরি ও উচ্চশিক্ষা",
    title_target: "한국 취업·유학·EPS-TOPIK 스페셜리스트",
    source: "Korean-Spoken-Curriculum-Plan.md, Phase 5 (Specialist Pro)",
    note: "Specialist Pro spoken Korean for EPS-TOPIK factory/shipyard/agriculture safety, E-9 visa & labor law, D-2 university study, Korea-Bangladesh trade & rapid everyday Korean.",
    welcome_text:
      "কোরিয়ান স্পেশালিস্ট প্রো কোর্সে স্বাগতম! EPS-TOPIK কারখানা ও নিরাপত্তা, E-9 ভিসা ও শ্রম আইন, D-2 বিশ্ববিদ্যালয় ও দ্রুত দৈনন্দিন কোরিয়ান শিখুন।",
  },
  ladder_default: [
    { play: "ko", speed: 0.84 },
    { play: "bn", speed: 1.1 },
    { play: "ko", speed: 0.98 },
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
