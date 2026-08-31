# Build a Python Web App for Bangla PDF Processing & Text Extraction

I want to build a web-based application using **Python** whose first purpose is to upload Bangla PDF books, process them, extract Bangla text accurately, clean the extracted text, detect pages/chapters where possible, and allow the user to review and export the extracted text.

This is the **first module of a future Bangla Audiobook platform**, so the architecture must be modular and extensible for future TTS, audiobook generation, user accounts, and cloud storage.

## 1. Technology Stack

Use:

* Python 3.12+
* FastAPI as the backend/web framework
* Jinja2 templates for the initial web UI
* HTML5
* CSS3
* Vanilla JavaScript
* PyMuPDF (`fitz`) for PDF text extraction
* OCR support for scanned PDFs
* Tesseract OCR with Bangla language support (`ben`)
* Pillow for image processing
* python-multipart for file uploads
* Pydantic for validation
* Uvicorn as the development server

Use a clean modular architecture.

Do NOT use React, Next.js, Flutter, Node.js, or Django for this version.

---

# 2. Main Objective

The application should support two types of Bangla PDFs:

### Type A — Text-based PDF

Example:

PDF
→ Detect selectable text
→ Extract text using PyMuPDF
→ Clean text
→ Display extracted Bangla text

### Type B — Scanned/Image PDF

Example:

PDF
→ Detect that page contains no usable text
→ Render PDF page as high-resolution image
→ Preprocess image
→ Run Bangla OCR using Tesseract (`ben`)
→ Extract Bangla text
→ Clean text
→ Display extracted text

The application should automatically determine whether a PDF page is text-based or scanned.

---

# 3. User Interface

Create a modern, clean dashboard.

Application name:

**Bangla Book Text Extractor**

Subtitle:

**PDF Processing & Bangla Text Extraction**

The UI should be responsive and work well on desktop and tablet.

Use a professional layout.

## Dashboard

Show:

* Application logo/icon
* Application name
* Upload PDF button
* Drag & Drop PDF upload area
* Supported file type: PDF
* Maximum file size indicator
* Recent processing jobs
* Processing status

Example:

```text
┌─────────────────────────────────────────────┐
│ 📖 Bangla Book Text Extractor               │
│ PDF Processing & Bangla Text Extraction     │
├─────────────────────────────────────────────┤
│                                             │
│          Drag & Drop PDF Here               │
│                                             │
│              OR                             │
│                                             │
│          [ Select PDF ]                     │
│                                             │
│          PDF files only                     │
│                                             │
└─────────────────────────────────────────────┘
```

---

# 4. PDF Upload

When the user selects a PDF:

Show:

* File name
* File size
* Number of pages
* Upload progress
* Remove button
* Start Processing button

Example:

```text
Book: Amar_Bangla_Boi.pdf
Size: 24.5 MB
Pages: 312

[ Remove ]    [ Process PDF ]
```

Validate:

* Only `.pdf`
* Maximum configurable file size
* Reject corrupted PDFs
* Reject empty PDFs
* Prevent unsafe filenames
* Generate a unique internal filename

Never trust the uploaded filename.

---

# 5. PDF Analysis

After upload, analyze every page.

For each page determine:

```text
TEXT
IMAGE / SCANNED
MIXED
```

Create a processing report:

```text
Total Pages: 312

Text Pages: 280
Scanned Pages: 25
Mixed Pages: 7
```

The system should process each page using the most appropriate method.

---

# 6. Text Extraction

For text-based pages use PyMuPDF.

Preserve:

* Bangla Unicode characters
* Paragraphs
* Line breaks where meaningful
* Headings
* Basic reading order

Avoid unnecessary character transformations.

Do NOT transliterate Bangla into English.

Example:

Input:

```text
বাংলাদেশ আমার জন্মভূমি।
আমি আমার দেশকে ভালোবাসি।
```

Output must remain:

```text
বাংলাদেশ আমার জন্মভূমি।

আমি আমার দেশকে ভালোবাসি।
```

---

# 7. Bangla OCR

For scanned pages use:

**Tesseract OCR + Bangla language model**

Expected language:

```text
ben
```

Before OCR, preprocess the image.

Implement configurable preprocessing:

1. Render PDF page at approximately 300 DPI
2. Convert to grayscale
3. Denoise
4. Increase contrast
5. Threshold/binarize where appropriate
6. Deskew if possible
7. Crop unnecessary margins where possible
8. OCR using Bangla language model

Make DPI and preprocessing parameters configurable.

Do not permanently modify the original PDF.

---

# 8. OCR Quality

Bangla OCR quality is extremely important because this project will eventually convert the extracted text into Bangla speech.

Implement a text-cleaning pipeline after OCR.

Handle common OCR problems such as:

* Repeated spaces
* Broken words
* Incorrect line breaks
* Empty lines
* Page headers
* Page footers
* Page numbers
* Repeated text
* Unnecessary punctuation
* OCR artifacts

However, NEVER aggressively modify Bangla text.

Keep the original OCR result available.

The system should maintain:

```text
Raw Extracted Text
        ↓
Cleaned Text
```

Allow the user to compare both.

---

# 9. Page-Level Processing

For every page create a result object containing:

```text
page_number
processing_method
raw_text
cleaned_text
character_count
word_count
processing_time
ocr_used
confidence_if_available
```

Example:

```json
{
  "page_number": 15,
  "processing_method": "ocr",
  "raw_text": "...",
  "cleaned_text": "...",
  "character_count": 1240,
  "word_count": 210,
  "ocr_used": true
}
```

---

# 10. Progress Tracking

PDF processing can take a long time.

Do NOT freeze the browser during processing.

Implement background processing.

Show real-time progress:

```text
Processing PDF...

Page 87 / 312

██████████████░░░░░░░░ 28%

Current operation:
Bangla OCR

Estimated remaining:
02:35
```

Use a simple background task/job architecture that can later be replaced by Celery/RQ/BullMQ-like queue infrastructure.

For this first version, avoid unnecessary infrastructure complexity.

---

# 11. Processing Status

Support these statuses:

```text
UPLOADED
ANALYZING
EXTRACTING
OCR_PROCESSING
CLEANING
COMPLETED
FAILED
CANCELLED
```

Display appropriate status badges in the UI.

---

# 12. Chapter Detection

Implement an initial heuristic chapter detector.

Detect patterns such as:

```text
অধ্যায় ১
অধ্যায় ১
অধ্যায়-১
অধ্যায়-১

অধ্যায় ২
অধ্যায় ২
```

Also support common English patterns:

```text
Chapter 1
Chapter 2
CHAPTER 3
```

Do not assume every book follows this format.

Chapter detection should be optional.

Display detected chapters like:

```text
Chapter 1 — পরিচয়
Page 1–18

Chapter 2 — ইতিহাস
Page 19–42
```

Allow manual editing later.

---

# 13. Text Viewer

After processing, show a dedicated result page.

Layout:

```text
┌──────────────────────────────────────────────┐
│ Book Information                             │
├──────────────────────────────────────────────┤
│ Pages: 312                                   │
│ Text Pages: 280                              │
│ OCR Pages: 32                                │
│ Status: Completed                            │
├──────────────────────────────────────────────┤
│                                              │
│ Page Navigation       Extracted Text         │
│                                              │
│ 1                         বাংলাদেশ...         │
│ 2                         আমাদের...           │
│ 3                         বাংলা...            │
│ ...                       ...                 │
│                                              │
└──────────────────────────────────────────────┘
```

Features:

* Page navigation
* Search inside extracted text
* Copy text
* Edit extracted text
* Raw/Cleaned text toggle
* Zoom
* Character count
* Word count

---

# 14. Search

Implement full-text search across extracted text.

Example:

User searches:

```text
বাংলাদেশ
```

Show:

```text
Page 12
Page 35
Page 78
Page 102
```

Highlight matching text.

Search must support Bangla Unicode properly.

---

# 15. Export

Allow exporting processed text in:

### TXT

```text
book.txt
```

### JSON

Include page-level metadata.

### DOCX

Preserve paragraphs and headings where possible.

### CSV

Columns:

```text
page_number
processing_method
text
```

Also provide:

**Download All Text**

button.

---

# 16. Project Structure

Use this structure:

```text
bangla-book-extractor/
│
├── app/
│   ├── main.py
│   │
│   ├── routes/
│   │   ├── upload.py
│   │   ├── processing.py
│   │   ├── results.py
│   │   └── export.py
│   │
│   ├── services/
│   │   ├── pdf_analyzer.py
│   │   ├── pdf_text_extractor.py
│   │   ├── ocr_service.py
│   │   ├── image_preprocessor.py
│   │   ├── text_cleaner.py
│   │   ├── chapter_detector.py
│   │   └── export_service.py
│   │
│   ├── models/
│   │   └── schemas.py
│   │
│   ├── templates/
│   │   ├── base.html
│   │   ├── dashboard.html
│   │   ├── upload.html
│   │   ├── processing.html
│   │   └── result.html
│   │
│   └── static/
│       ├── css/
│       │   └── style.css
│       └── js/
│           ├── upload.js
│           ├── processing.js
│           └── viewer.js
│
├── data/
│   ├── uploads/
│   ├── processed/
│   ├── exports/
│   └── temp/
│
├── tests/
│
├── requirements.txt
├── .env.example
├── .gitignore
├── README.md
└── run.py
```

Keep business logic outside route handlers.

---

# 17. Configuration

Use environment variables.

Create `.env.example`:

```env
APP_NAME=Bangla Book Text Extractor
MAX_UPLOAD_SIZE_MB=200
OCR_LANGUAGE=ben
OCR_DPI=300
TESSERACT_PATH=
```

Never hardcode machine-specific Tesseract paths.

The application should work on Windows and Linux.

If Tesseract is not installed, show a clear error:

```text
Bangla OCR is unavailable.

Please install Tesseract OCR and the Bengali language
data (ben.traineddata).
```

Do not silently fail.

---

# 18. Error Handling

Handle:

* Invalid PDF
* Corrupted PDF
* Password-protected PDF
* Empty PDF
* OCR unavailable
* Missing Bangla OCR model
* Unsupported encoding
* File too large
* Disk space error
* Processing timeout
* Unexpected OCR failure

Display user-friendly error messages.

Log technical details server-side.

---

# 19. Security

Implement:

* File extension validation
* MIME validation
* File size validation
* Safe random filenames
* Path traversal protection
* Secure temporary files
* Cleanup temporary files
* Never execute uploaded files
* Never trust PDF metadata
* Rate limiting can be added later

The application should only process PDF documents.

---

# 20. Performance

Optimize for large books.

Requirements:

* Process page-by-page
* Do not load the entire PDF into memory unnecessarily
* Save intermediate results
* Avoid rendering text-based pages as images
* Use OCR only when necessary
* Allow processing to resume after failure where practical

For example:

```text
Page 1 → completed
Page 2 → completed
Page 3 → OCR
Page 4 → completed
```

If processing stops at page 100, the system should not need to restart from page 1.

---

# 21. Logging

Create structured logs:

```text
INFO  PDF uploaded
INFO  PDF analysis started
INFO  Page 1 extracted using text extraction
INFO  Page 2 detected as scanned
INFO  OCR started for page 2
INFO  Page 2 OCR completed
INFO  Text cleaning completed
INFO  Export completed
ERROR OCR failed for page 47
```

---

# 22. Testing

Create unit tests for:

* PDF type detection
* Text extraction
* OCR service
* Bangla text cleaning
* Chapter detection
* Page processing
* Export
* Invalid PDF handling

Include sample test strings containing:

```text
বাংলা
বাংলাদেশ
শিক্ষা
অধ্যায়
স্বাধীনতা
```

Test Unicode handling carefully.

---

# 23. UI Design Requirements

Use a clean modern interface.

Design principles:

* White/light background
* Professional typography
* Bengali Unicode-friendly font
* Responsive layout
* Clear progress indicators
* Minimal unnecessary animations
* Accessible buttons
* Good spacing
* Mobile/tablet friendly

Use a Bengali-friendly web font such as:

```text
Noto Sans Bengali
```

Load it from a reliable source or provide a local fallback.

---

# 24. Important Architecture Rule

Do NOT implement TTS yet.

The current application is ONLY responsible for:

```text
PDF
 ↓
PDF Analysis
 ↓
Text Extraction / OCR
 ↓
Text Cleaning
 ↓
Chapter Detection
 ↓
Text Review
 ↓
Export
```

However, design the service layer so that later we can add:

```text
Clean Text
 ↓
Bangla TTS
 ↓
MP3
 ↓
Audiobook
```

without rewriting the PDF processing system.

---

# 25. Future Compatibility

Design interfaces/classes so future modules can be plugged in.

For example:

```python
class TextExtractor:
    def extract(self, page):
        pass
```

```python
class OCRService:
    def process(self, image):
        pass
```

```python
class TextCleaner:
    def clean(self, text):
        pass
```

Later we should be able to add:

```python
class TTSService:
    def synthesize(self, text):
        pass
```

without changing the core PDF pipeline.

---

# 26. README

Create a detailed README explaining:

1. Project overview
2. Requirements
3. Python installation
4. Virtual environment setup
5. Tesseract installation
6. Bengali OCR model installation
7. Installation commands
8. Environment variables
9. How to run
10. How PDF processing works
11. Text PDF vs scanned PDF
12. OCR limitations
13. Troubleshooting
14. Project structure
15. Future TTS integration

Include Windows instructions because development will primarily be performed on Windows.

Example:

```bash
python -m venv venv
venv\Scripts\activate
pip install -r requirements.txt
python run.py
```

---

# 27. Development Approach

Do not generate a huge monolithic implementation.

Build the project in logical stages:

### Stage 1

Create project structure and FastAPI application.

### Stage 2

Implement PDF upload and validation.

### Stage 3

Implement PDF page analysis.

### Stage 4

Implement PyMuPDF text extraction.

### Stage 5

Implement Tesseract Bangla OCR.

### Stage 6

Implement OCR image preprocessing.

### Stage 7

Implement Bangla text cleaning.

### Stage 8

Implement chapter detection.

### Stage 9

Implement background processing and progress tracking.

### Stage 10

Implement text viewer.

### Stage 11

Implement TXT/JSON/DOCX/CSV export.

### Stage 12

Add tests and documentation.

After each stage, verify that the application runs before moving to the next stage.

---

# 28. Final Requirement

Before finishing, verify the application with at least:

### Test 1

A normal text-based Bangla PDF.

Expected:

```text
PDF
→ Text extraction
→ Clean Bangla text
```

### Test 2

A scanned Bangla PDF.

Expected:

```text
PDF
→ Image rendering
→ Bangla OCR
→ Clean Bangla text
```

### Test 3

A mixed PDF.

Expected:

```text
Text pages → PyMuPDF
Scanned pages → OCR
```

The final application must clearly show which method was used for each page.

Do not claim OCR accuracy is perfect. Provide the raw OCR output and allow manual correction.

## Most Important Goal

The extracted Bangla text must be **high quality and suitable for future Bangla Text-to-Speech conversion**.

Therefore, prioritize:

**Bangla Unicode correctness → reading order → paragraph preservation → OCR quality → text cleaning → chapter structure.**

Start implementing the application now.
