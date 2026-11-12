#!/usr/bin/env node
import fs from "node:fs";
import path from "node:path";
import { fileURLToPath } from "node:url";

const HERE = path.dirname(fileURLToPath(import.meta.url));
const ASSET_PATH = path.resolve(
  HERE,
  process.argv[2] || "../../app/src/main/assets/spoken_chinese_standard_hsk1.json"
);

if (!fs.existsSync(ASSET_PATH)) {
  console.error(`Missing asset: ${ASSET_PATH}`);
  process.exit(1);
}

const data = JSON.parse(fs.readFileSync(ASSET_PATH, "utf8"));
const errors = [];

const HANZI = /[\u4E00-\u9FFF]/;
const ASCII_DIGITS = /\d/;
const BANGLA = /[\u0980-\u09FF]/;
const BRACKETS = /[()（）\[\]]/;
const IGNORED = /[\s\u200c\u200d,.?!:;'\-\u2014\u2026\u201c\u201d\u2018\u2019\u00ab\u00bb\uff0c\u3002\uff1f\uff01\u3001\uff1b\uff1a\uff08\uff09\u300a\u300b]/g;

function isAllowedBnPronChar(ch) {
  const code = ch.codePointAt(0);
  return (
    (code >= 0x0980 && code <= 0x09ff) ||
    (code >= 0x20 && code <= 0x7e) ||
    code === 0x09f7 ||
    code === 0x200c ||
    code === 0x200d ||
    (code >= 0x2018 && code <= 0x201d) ||
    code === 0x2013 ||
    code === 0x2014 ||
    code === 0x00b7 ||
    code === 0x2022
  );
}

if (data.schema_version !== 1) errors.push(`schema_version must be 1, got ${data.schema_version}`);
if (data.course?.target_lang !== "zh") errors.push(`course.target_lang must be 'zh'`);
if (data.course?.base_lang !== "bn") errors.push(`course.base_lang must be 'bn'`);

const parts = data.parts || [];
if (parts.length !== 16) errors.push(`Expected 16 parts, got ${parts.length}`);

let lessonsCount = 0;
let itemsCount = 0;
const seenIds = new Set();

for (let pIdx = 0; pIdx < parts.length; pIdx++) {
  const part = parts[pIdx];
  const expectedLevel = pIdx < 2 ? "A0" : "A1";
  if (part.level !== expectedLevel) {
    errors.push(`${part.id}: expected level ${expectedLevel}, got ${part.level}`);
  }
  const lessons = part.lessons || [];
  if (lessons.length !== 4) errors.push(`${part.id}: expected 4 lessons, got ${lessons.length}`);

  for (let lIdx = 0; lIdx < lessons.length; lIdx++) {
    lessonsCount++;
    const lesson = lessons[lIdx];
    if (!lesson.title_bn?.trim() || !lesson.title_target?.trim()) {
      errors.push(`${lesson.id}: missing title_bn or title_target`);
    }
    const items = lesson.items || [];
    if (items.length !== 8) errors.push(`${lesson.id}: expected 8 items, got ${items.length}`);

    for (let iIdx = 0; iIdx < items.length; iIdx++) {
      itemsCount++;
      const it = items[iIdx];
      if (seenIds.has(it.id)) errors.push(`Duplicate id: ${it.id}`);
      seenIds.add(it.id);

      const tgt = (it.target || "").trim();
      if (!tgt || !HANZI.test(tgt)) errors.push(`${it.id}: target missing Hanzi ('${tgt}')`);
      if (ASCII_DIGITS.test(tgt)) errors.push(`${it.id}: ASCII digits inside target ('${tgt}')`);
      if (BANGLA.test(tgt) || BRACKETS.test(tgt)) {
        errors.push(`${it.id}: Bangla/brackets inside target ('${tgt}')`);
      }
      if (!it.bn?.trim()) errors.push(`${it.id}: bn is empty`);
      if (!it.bn_pron?.trim()) {
        errors.push(`${it.id}: bn_pron is empty`);
      } else {
        for (const ch of it.bn_pron) {
          if (!isAllowedBnPronChar(ch)) {
            errors.push(`${it.id}: disallowed bn_pron char '${ch}' (U+${ch.codePointAt(0).toString(16)}) in '${it.bn_pron}'`);
          }
        }
      }

      if (it.type === "dialogue_line" && !["A", "B"].includes(it.speaker)) {
        errors.push(`${it.id}: dialogue_line missing speaker A/B`);
      }

      const tokens = it.tokens || [];
      if (tokens.length === 0) {
        errors.push(`${it.id}: tokens array is empty`);
      } else {
        const joined = tokens.map((x) => x.t || "").join("");
        const normJoined = joined.replace(IGNORED, "");
        const normTarget = tgt.replace(IGNORED, "");
        if (normJoined !== normTarget) {
          errors.push(`${it.id}: token mismatch '${normJoined}' != '${normTarget}'`);
        }
      }
    }
  }
}

if (data.stats?.lessons !== lessonsCount || data.stats?.items !== itemsCount) {
  errors.push(`stats mismatch: stats=${JSON.stringify(data.stats)}, actual=${lessonsCount}/${itemsCount}`);
}

if (errors.length > 0) {
  console.error(`VERIFICATION FAILED (${errors.length} errors):`);
  for (const e of errors.slice(0, 150)) console.error("  -", e);
  process.exit(1);
}

console.log(`VERIFIED CLEANLY: ${parts.length} parts, ${lessonsCount} lessons, ${itemsCount} items in ${path.basename(ASSET_PATH)}.`);
