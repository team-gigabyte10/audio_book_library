#!/usr/bin/env node
import fs from "node:fs";
import path from "node:path";
import { fileURLToPath } from "node:url";

const HERE = path.dirname(fileURLToPath(import.meta.url));
const ASSET_PATH = path.resolve(
  HERE,
  process.argv[2] || "../../app/src/main/assets/spoken_korean_standard_a1.json"
);

if (!fs.existsSync(ASSET_PATH)) {
  console.error(`Missing asset: ${ASSET_PATH}`);
  process.exit(1);
}

const data = JSON.parse(fs.readFileSync(ASSET_PATH, "utf8"));
const errors = [];

const HANGUL = /[\uAC00-\uD7A3\u1100-\u11FF\u3130-\u318F]/;
const ASCII_DIGITS = /\d/;
const BANGLA = /[\u0980-\u09FF]/;
const BRACKETS = /[()（）\[\]]/;
const IGNORED = /[\s\u200c\u200d,.?!:;'\-\u2014\u2026\u201c\u201d\u2018\u2019~·]/g;

function isAllowedBnPronChar(ch) {
  const code = ch.charCodeAt(0);
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
if (data.course?.target_lang !== "ko") errors.push(`course.target_lang must be 'ko'`);
if (data.course?.base_lang !== "bn") errors.push(`course.base_lang must be 'bn'`);

const parts = data.parts || [];
if (parts.length !== 16) errors.push(`Expected 16 parts, got ${parts.length}`);

let lessonsCount = 0;
let itemsCount = 0;
const seenIds = new Set();

const fileName = path.basename(ASSET_PATH).toLowerCase();
const levelArg = (process.argv[3] || "").toUpperCase();

for (let pIdx = 0; pIdx < parts.length; pIdx++) {
  const part = parts[pIdx];
  const expectedLevel = levelArg
    ? levelArg
    : fileName.includes("_a2")
      ? "A2"
      : fileName.includes("_b1")
        ? "B1"
        : fileName.includes("_b2") || fileName.includes("specialist")
          ? "B2"
          : pIdx < 2
            ? "A0"
            : "A1";
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

    for (const item of items) {
      itemsCount++;
      if (seenIds.has(item.id)) errors.push(`Duplicate item id: ${item.id}`);
      seenIds.add(item.id);

      const target = item.target || "";
      if (!HANGUL.test(target)) errors.push(`${item.id}: target has no Hangul chars: '${target}'`);
      if (ASCII_DIGITS.test(target)) errors.push(`${item.id}: target has ASCII digits: '${target}'`);
      if (BANGLA.test(target)) errors.push(`${item.id}: target has Bangla chars: '${target}'`);
      if (BRACKETS.test(target)) errors.push(`${item.id}: target has brackets: '${target}'`);

      if (!item.bn?.trim()) errors.push(`${item.id}: missing bn translation`);
      const bnPron = item.bn_pron || "";
      if (!bnPron.trim()) errors.push(`${item.id}: missing bn_pron`);
      for (const ch of bnPron) {
        if (!isAllowedBnPronChar(ch)) {
          errors.push(`${item.id}: disallowed bn_pron char '${ch}' (U+${ch.charCodeAt(0).toString(16)}) in '${bnPron}'`);
          break;
        }
      }

      if (item.type === "dialogue_line" && item.speaker !== "A" && item.speaker !== "B") {
        errors.push(`${item.id}: dialogue_line missing speaker 'A' or 'B'`);
      }

      const tokens = item.tokens || [];
      if (tokens.length === 0) {
        errors.push(`${item.id}: empty tokens array`);
      } else {
        let joined = "";
        for (const tok of tokens) {
          if (!tok.t?.trim()) errors.push(`${item.id}: empty token.t`);
          if (!tok.bn?.trim()) errors.push(`${item.id}: empty token.bn for '${tok.t}'`);
          joined += tok.t || "";
        }
        const normTarget = target.replace(IGNORED, "");
        const normJoined = joined.replace(IGNORED, "");
        if (normTarget !== normJoined) {
          errors.push(`${item.id}: token mismatch '${normTarget}' != '${normJoined}'`);
        }
      }
    }
  }
}

if (errors.length > 0) {
  console.error(`VERIFICATION FAILED (${errors.length} errors):`);
  for (const err of errors.slice(0, 30)) console.error(`  - ${err}`);
  if (errors.length > 30) console.error(`  ... and ${errors.length - 30} more`);
  process.exit(1);
}

console.log(`VERIFIED CLEANLY: ${parts.length} parts, ${lessonsCount} lessons, ${itemsCount} items in ${path.basename(ASSET_PATH)}.`);

