/**
 * Utility to extract top-level metadata from Markdown book files
 * (No chapter-by-chapter parsing)
 */

export function extractBookMetadata(rawText, filename = '') {
  if (!rawText) {
    return {
      title: filename.replace(/\.(md|markdown|txt|pdf)$/i, '').replace(/_/g, ' '),
      subtitle: '',
      author: '',
      translator: '',
      tagline: '',
      totalWords: 0,
      estimatedMinutes: 1
    };
  }

  const lines = rawText.split(/\r?\n/);
  
  let title = '';
  let subtitle = '';
  let author = '';
  let translator = '';
  let tagline = '';
  
  const defaultTitle = filename.replace(/\.(md|markdown|txt|pdf)$/i, '').replace(/_/g, ' ');

  // 1. Extract H1 Title (# Title)
  const titleLine = lines.find(line => /^#\s+(.+)/.test(line));
  if (titleLine) {
    title = titleLine.replace(/^#\s+/, '').trim();
  } else {
    title = defaultTitle;
  }

  // 2. Extract Subtitle (*(...) * or _(...)_)
  const subtitleLine = lines.find(line => /^\s*[\*_]\((.+)\)[\*_]\s*$/.test(line) || /^\s*[\*_]([^\*_]+)[\*_]\s*$/.test(line));
  if (subtitleLine) {
    const match = subtitleLine.match(/[\*_]\(?([^\*\_\(\)]+)\)?[\*_]/);
    if (match) subtitle = match[1].trim();
  }

  // 3. Extract Author (**মূল লেখক:**, **Author:**, etc.)
  const authorMatch = rawText.match(/\*\*(?:মূল\s*লেখক|লেখক|Author|Written By)\s*:\*\*\s*([^\n\r]+)/i);
  if (authorMatch) {
    author = authorMatch[1].trim();
  }

  // 4. Extract Translator / Compiler
  const transMatch = rawText.match(/\*\*(?:অনুবাদক\s*ও\s*সংকলক|অনুবাদক|সংকলক|Translator|Compiled By)\s*:\*\*\s*([^\n\r]+)/i);
  if (transMatch) {
    translator = transMatch[1].trim();
  }

  // 5. Extract Tagline / Brief summary sentence
  const taglineMatch = rawText.match(/\n\*\*([^\*:\n]{8,80})\*\*\s*\n/);
  if (taglineMatch && (!authorMatch || !authorMatch[0].includes(taglineMatch[1]))) {
    tagline = taglineMatch[1].trim();
  }

  const totalWords = countWords(rawText);
  const estimatedMinutes = Math.max(1, Math.ceil(totalWords / 140));

  return {
    title: title || defaultTitle,
    subtitle,
    author,
    translator,
    tagline,
    totalWords,
    estimatedMinutes
  };
}

export function countWords(str) {
  if (!str) return 0;
  const words = str.trim().split(/\s+/);
  return words.filter(w => w.length > 0).length;
}

export function generateBookSlug(title) {
  if (!title) return `book-${Date.now()}`;
  const ascii = title
    .toLowerCase()
    .replace(/[^\w\s-]/g, '')
    .trim()
    .replace(/\s+/g, '-');
  return ascii.length > 2 ? `${ascii}-${Date.now().toString().slice(-4)}` : `book-${Date.now()}`;
}

export function formatFileSize(bytes) {
  if (!bytes || bytes === 0) return '0 B';
  const k = 1024;
  const sizes = ['B', 'KB', 'MB', 'GB'];
  const i = Math.floor(Math.log(bytes) / Math.log(k));
  return parseFloat((bytes / Math.pow(k, i)).toFixed(1)) + ' ' + sizes[i];
}
