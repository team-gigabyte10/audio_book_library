# AudioBook Studio - React & Firebase Markdown Panel

A web portal for parsing, reviewing, and uploading audio book markdown files (`book.md`) directly into Google Firebase.

## Features
- **Drag & Drop Markdown Upload**: Upload any `.md` or `.markdown` audio book summary.
- **Smart Parser**: Automatically parses book title, author, subtitle, translator, and sections into structured chapters.
- **Side-by-Side Reviewer**: View rendered markdown chapters, word count stats, and raw markdown before uploading.
- **Firebase Dual Storage**:
  - **Firebase Cloud Storage**: Stores the raw `.md` file and optional cover image.
  - **Cloud Firestore**: Stores structured book metadata, chapter documents, and download links.
  - **Realtime Database**: Optional sync for real-time mobile app listeners.
- **Book Library**: Browse, search, filter, download raw `.md`, and manage uploaded books.

## Getting Started

```bash
# 1. Install dependencies
npm install

# 2. Start local development server
npm run dev

# 3. Build for production
npm run build
```

## Firebase Project Configuration
Configuration is loaded from `src/firebase/config.js` pointing to project `book-store-bec15`.
Make sure Firebase Storage and Firestore rules allow read/write or user authentication as needed.
