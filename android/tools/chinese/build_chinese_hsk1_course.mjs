#!/usr/bin/env node
import fs from "node:fs";
import path from "node:path";
import { fileURLToPath } from "node:url";
import { units1To4 } from "./units_hsk1/u01_u04.mjs";
import { units5To8 } from "./units_hsk1/u05_u08.mjs";
import { units9To12 } from "./units_hsk1/u09_u12.mjs";
import { units13To16 } from "./units_hsk1/u13_u16.mjs";

const HERE = path.dirname(fileURLToPath(import.meta.url));
const OUT_PATH = path.resolve(HERE, "../../app/src/main/assets/spoken_chinese_standard_hsk1.json");

const partsRaw = [...units1To4, ...units5To8, ...units9To12, ...units13To16];

let totalLessons = 0;
let totalItems = 0;

const builtParts = partsRaw.map((part, pIdx) => {
  const expectedPartId = `zh-hsk1-${String(pIdx + 1).padStart(2, "0")}`;
  if (part.id !== expectedPartId) {
    throw new Error(`Part order mismatch: expected ${expectedPartId}, got ${part.id}`);
  }
  const lessons = part.lessons.map((lesson, lIdx) => {
    totalLessons += 1;
    const expectedLessonId = `${part.id}-l${String(lIdx + 1).padStart(2, "0")}`;
    if (lesson.id !== expectedLessonId) {
      throw new Error(`Lesson order mismatch: expected ${expectedLessonId}, got ${lesson.id}`);
    }
    const items = lesson.items.map((raw, iIdx) => {
      totalItems += 1;
      const itemId = `${lesson.id}-${String(iIdx + 1).padStart(3, "0")}`;
      const built = {
        id: itemId,
        concept_id: `c-${itemId}`,
        order: iIdx + 1,
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
      if (raw.speaker) built.speaker = raw.speaker;
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
    id: part.id,
    order: part.order,
    level: part.level,
    title_bn: part.title_bn,
    title_target: part.title_target,
    lessons,
  };
});

const asset = {
  schema_version: 1,
  course: {
    id: "zh-standard-zero-hsk1",
    target_lang: "zh",
    base_lang: "bn",
    title_bn: "চাইনিজ (ম্যান্ডারিন) স্পোকেন: শূন্য থেকে HSK 1",
    title_target: "汉语口语：零基础到 HSK 1",
    source: "Chinese-Spoken-Curriculum-Plan.md, Phase 2 (Stage 0 + HSK 1)",
    note: "Simplified Chinese (zh-CN) with numbered Pinyin and pure Bangla phonetic bridge.",
    welcome_text: "চাইনিজ ম্যান্ডারিন স্পোকেন কোর্সে স্বাগতম! প্রতিটি সুর ও বাক্য মন দিয়ে শুনুন এবং জোরে বলুন।",
  },
  ladder_default: [
    { play: "zh", speed: 0.78 },
    { play: "bn", speed: 1.1 },
    { play: "zh", speed: 0.92 },
    { play: "zh", speed: 1.0 },
    { pause_ms: 1200 },
  ],
  stats: {
    lessons: totalLessons,
    items: totalItems,
  },
  parts: builtParts,
};

if (!process.argv.includes("--check")) {
  fs.mkdirSync(path.dirname(OUT_PATH), { recursive: true });
  fs.writeFileSync(OUT_PATH, JSON.stringify(asset, null, 2) + "\n", "utf8");
  console.log(`Generated ${OUT_PATH}`);
}
console.log(`Built ${builtParts.length} parts, ${totalLessons} lessons, ${totalItems} items.`);

