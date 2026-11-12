#!/usr/bin/env node
import fs from "node:fs";
import path from "node:path";
import { fileURLToPath } from "node:url";

import { hsk2Units1To4 } from "./units_hsk2/u01_u04.mjs";
import { hsk2Units5To8 } from "./units_hsk2/u05_u08.mjs";
import { hsk2Units9To12 } from "./units_hsk2/u09_u12.mjs";
import { hsk2Units13To16 } from "./units_hsk2/u13_u16.mjs";

import { hsk3Units1To4 } from "./units_hsk3/u01_u04.mjs";
import { hsk3Units5To8 } from "./units_hsk3/u05_u08.mjs";
import { hsk3Units9To12 } from "./units_hsk3/u09_u12.mjs";
import { hsk3Units13To16 } from "./units_hsk3/u13_u16.mjs";

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
  idPrefix: "zh-hsk2",
  courseId: "zh-standard-hsk2",
  titleBn: "চাইনিজ (ম্যান্ডারিন) স্পোকেন: HSK 2",
  titleTarget: "汉语口语：HSK 2 进阶",
  source: "Chinese-Spoken-Curriculum-Plan.md, Phase 4 (HSK 2 - A2)",
  note: "Simplified Chinese (zh-CN) with numbered Pinyin and pure Bangla phonetic bridge.",
  welcomeText: "HSK 2 দৈনন্দিন স্পোকেন কোর্সে স্বাগতম! তুলনা, ট্রেন-বিমান ভ্রমণ, ব্যাংক ও অফিসের বাস্তব সংলাপ অনুশীলন করুন।",
  outFileName: "spoken_chinese_standard_hsk2.json",
  partsRaw: [...hsk2Units1To4, ...hsk2Units5To8, ...hsk2Units9To12, ...hsk2Units13To16],
});

buildCourseAsset({
  idPrefix: "zh-hsk3",
  courseId: "zh-standard-hsk3",
  titleBn: "চাইনিজ (ম্যান্ডারিন) স্পোকেন: HSK 3",
  title_target: "汉语口语：HSK 3 流利表达",
  titleTarget: "汉语口语：HSK 3 流利表达",
  source: "Chinese-Spoken-Curriculum-Plan.md, Phase 4 (HSK 3 - B1)",
  note: "Simplified Chinese (zh-CN) with numbered Pinyin and pure Bangla phonetic bridge.",
  welcomeText: "HSK 3 ইন্টারমিডিয়েট ফ্লুয়েন্সি কোর্সে স্বাগতম! 把/被 বাক্যগঠন, ক্যাম্পাস, সিএসসি স্কলারশিপ ও বাস্তব জীবনযাত্রায় সাবলীল হোন।",
  outFileName: "spoken_chinese_standard_hsk3.json",
  partsRaw: [...hsk3Units1To4, ...hsk3Units5To8, ...hsk3Units9To12, ...hsk3Units13To16],
});
