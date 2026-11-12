#!/usr/bin/env node
import fs from "node:fs";
import path from "node:path";
import { fileURLToPath } from "node:url";

import { hsk4Units1To4 } from "./units_hsk4/u01_u04.mjs";
import { hsk4Units5To8 } from "./units_hsk4/u05_u08.mjs";
import { hsk4Units9To12 } from "./units_hsk4/u09_u12.mjs";
import { hsk4Units13To16 } from "./units_hsk4/u13_u16.mjs";

import { specialistUnits1To4 } from "./units_specialist/u01_u04.mjs";
import { specialistUnits5To8 } from "./units_specialist/u05_u08.mjs";
import { specialistUnits9To12 } from "./units_specialist/u09_u12.mjs";
import { specialistUnits13To16 } from "./units_specialist/u13_u16.mjs";

const HERE = path.dirname(fileURLToPath(import.meta.url));
const ASSETS_DIR = path.resolve(HERE, "../../app/src/main/assets");

function buildCourseAsset({
  idPrefix,
  courseId,
  titleBn,
  titleTarget,
  source,
  note,
  welcomeText,
  outFileName,
  partsRaw,
}) {
  let totalLessons = 0;
  let totalItems = 0;

  const builtParts = partsRaw.map((part, pIdx) => {
    const expectedPartId = `${idPrefix}-${String(pIdx + 1).padStart(2, "0")}`;
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
      id: courseId,
      target_lang: "zh",
      base_lang: "bn",
      title_bn: titleBn,
      title_target: titleTarget,
      source,
      note,
      welcome_text: welcomeText,
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

  const outPath = path.join(ASSETS_DIR, outFileName);
  if (!process.argv.includes("--check")) {
    fs.mkdirSync(path.dirname(outPath), { recursive: true });
    fs.writeFileSync(outPath, JSON.stringify(asset, null, 2) + "\n", "utf8");
    console.log(`Generated ${outPath}`);
  }
  console.log(`${outFileName}: Built ${builtParts.length} parts, ${totalLessons} lessons, ${totalItems} items.`);
}

buildCourseAsset({
  idPrefix: "zh-hsk4",
  courseId: "zh-standard-hsk4",
  titleBn: "চাইনিজ (ম্যান্ডারিন) স্পোকেন: HSK 4",
  titleTarget: "汉语口语：HSK 4 高阶",
  source: "Chinese-Spoken-Curriculum-Plan.md, Phase 5 (HSK 4 - B2)",
  note: "Simplified Chinese (zh-CN) with numbered Pinyin and pure Bangla phonetic bridge.",
  welcomeText: "HSK 4 আপার-ইন্টারমিডিয়েট কোর্সে স্বাগতম! প্রবাদ-বাগধারা, বিতর্ক, অর্থনীতি, প্রযুক্তি ও আনুষ্ঠানিক উপস্থাপনায় দক্ষ হোন।",
  outFileName: "spoken_chinese_standard_hsk4.json",
  partsRaw: [...hsk4Units1To4, ...hsk4Units5To8, ...hsk4Units9To12, ...hsk4Units13To16],
});

buildCourseAsset({
  idPrefix: "zh-sp",
  courseId: "zh-specialist-pro",
  titleBn: "চাইনিজ স্পেশালিস্ট প্রো: ট্রেড, ইঞ্জিনিয়ারিং ও সিএসসি",
  titleTarget: "汉语专业精英：外贸、工程与留学",
  source: "Chinese-Spoken-Curriculum-Plan.md, Phase 5 (Specialist Pro - B2)",
  note: "Simplified Chinese (zh-CN) with numbered Pinyin and pure Bangla phonetic bridge.",
  welcomeText: "স্পেশালিস্ট প্রো কোর্সে স্বাগতম! ক্যান্টন ফেয়ার, ইয়িউ মার্কেট, L/C-শিপিং, ইঞ্জিনিয়ারিং সাইট ও সিএসসি স্কলারশিপের বাস্তব সংলাপ শিখুন।",
  outFileName: "spoken_chinese_specialist_pro.json",
  partsRaw: [...specialistUnits1To4, ...specialistUnits5To8, ...specialistUnits9To12, ...specialistUnits13To16],
});

