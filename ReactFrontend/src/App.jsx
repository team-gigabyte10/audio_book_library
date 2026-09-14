import React, { useState, useEffect } from 'react';
import Navbar from './components/Navbar';
import BookUploader from './components/BookUploader';
import BookPreview from './components/BookPreview';
import LibraryView from './components/LibraryView';
import RulesModal from './components/RulesModal';
import Toast from './components/Toast';
import { generateBookSlug } from './utils/mdParser';
import { db, storage, rtdb, auth } from './firebase/config';
import { signInAnonymously } from 'firebase/auth';
import { 
  collection, getDocs, addDoc, doc, deleteDoc, 
  query, orderBy, serverTimestamp 
} from 'firebase/firestore';
import { 
  ref as storageRef, uploadBytesResumable, 
  getDownloadURL, deleteObject 
} from 'firebase/storage';
import { ref as dbRef, set as rtdbSet, remove as rtdbRemove } from 'firebase/database';
import confetti from 'canvas-confetti';

export default function App() {
  const [activeTab, setActiveTab] = useState('upload'); // 'upload' | 'library'
  const [parsedBook, setParsedBook] = useState(null);
  const [books, setBooks] = useState([]);
  const [loadingBooks, setLoadingBooks] = useState(false);
  const [showRulesModal, setShowRulesModal] = useState(false);


  // Uploading status
  const [isUploading, setIsUploading] = useState(false);
  const [uploadProgress, setUploadProgress] = useState(0);
  const [uploadStage, setUploadStage] = useState('');

  // Toasts
  const [toasts, setToasts] = useState([]);

  const addToast = ({ type = 'info', title = '', message = '' }) => {
    const id = Date.now().toString();
    setToasts(prev => [...prev, { id, type, title, message }]);
    setTimeout(() => {
      removeToast(id);
    }, 5000);
  };

  const removeToast = (id) => {
    setToasts(prev => prev.filter(t => t.id !== id));
  };

  // Fetch books from Firestore
  const fetchBooks = async () => {
    setLoadingBooks(true);
    let items = [];
    try {
      const q = query(collection(db, 'books'), orderBy('createdAt', 'desc'));
      const querySnapshot = await getDocs(q);
      querySnapshot.forEach((d) => {
        items.push({ id: d.id, ...d.data() });
      });
    } catch (err) {
      console.warn('Firestore fetch error or restricted rules:', err);
    }

    // Merge with any offline cached books so user never loses work
    try {
      const local = JSON.parse(localStorage.getItem('audio_books_cache') || '[]');
      const existingIds = new Set(items.map(b => b.id));
      const newFromLocal = local.filter(b => !existingIds.has(b.id));
      items = [...items, ...newFromLocal];
    } catch (e) {
      // ignore
    }

    setBooks(items);
    setLoadingBooks(false);
  };

  useEffect(() => {
    // Attempt anonymous sign-in so request.auth is populated if project rules require it
    signInAnonymously(auth).catch((err) => {
      console.log('Anonymous sign-in note:', err.message);
    });
    fetchBooks();
  }, []);

  // Handle uploading files (Summary .md, Full .md, PDF) to Firebase
  const handleUploadBook = async (finalBookData) => {
    setIsUploading(true);
    setUploadProgress(5);
    setUploadStage('Preparing files for Firebase Storage...');

    try {
      const slug = generateBookSlug(finalBookData.title);
      const timestamp = new Date().toISOString();

      let summaryMdUrl = '';
      let summaryMdPath = '';
      let fullBookMdUrl = '';
      let fullBookMdPath = '';
      let pdfUrl = '';
      let pdfPath = '';
      let coverUrl = '';
      let coverPath = '';

      const uploadHelper = async (file, path, contentType) => {
        const fileRef = storageRef(storage, path);
        const task = uploadBytesResumable(fileRef, file, contentType ? { contentType } : undefined);
        return new Promise((resolve, reject) => {
          task.on(
            'state_changed',
            null,
            (error) => reject(error),
            async () => {
              const url = await getDownloadURL(task.snapshot.ref);
              resolve(url);
            }
          );
        });
      };

      // 1. Upload Summary Markdown to Storage
      if (finalBookData.summaryFile) {
        setUploadStage('Uploading Summary Markdown to Firebase Storage...');
        setUploadProgress(20);
        summaryMdPath = `books/${slug}/${finalBookData.summaryFile.name}`;
        try {
          summaryMdUrl = await uploadHelper(finalBookData.summaryFile, summaryMdPath, 'text/markdown');
        } catch (err) {
          console.warn('Summary storage upload error:', err);
          if (err.code === 'storage/unauthorized' || err.message?.toLowerCase().includes('unauthorized')) {
            setShowRulesModal(true);
          }
          throw err;
        }
      }

      // 2. Upload Full Book Markdown to Storage
      if (finalBookData.fullBookFile) {
        setUploadStage('Uploading Full Book Markdown to Firebase Storage...');
        setUploadProgress(45);
        fullBookMdPath = `books/${slug}/${finalBookData.fullBookFile.name}`;
        try {
          fullBookMdUrl = await uploadHelper(finalBookData.fullBookFile, fullBookMdPath, 'text/markdown');
        } catch (err) {
          console.warn('Full book storage upload error:', err);
          throw err;
        }
      }

      // 3. Upload PDF Document to Storage
      if (finalBookData.pdfFile) {
        setUploadStage('Uploading PDF Document to Firebase Storage...');
        setUploadProgress(70);
        pdfPath = `books/${slug}/${finalBookData.pdfFile.name}`;
        try {
          pdfUrl = await uploadHelper(finalBookData.pdfFile, pdfPath, 'application/pdf');
        } catch (err) {
          console.warn('PDF storage upload error:', err);
          throw err;
        }
      }

      // 4. Upload Cover Image (if provided)
      if (finalBookData.coverFile) {
        setUploadStage('Uploading Cover Image...');
        coverPath = `covers/${slug}/${finalBookData.coverFile.name}`;
        try {
          coverUrl = await uploadHelper(finalBookData.coverFile, coverPath);
        } catch (err) {
          console.warn('Cover upload skipped:', err);
        }
      }

      setUploadProgress(85);
      setUploadStage('Saving book metadata & storage links in Firestore...');

      // 5. Lightweight Firestore record (NO chapters array or full text)
      const bookDocData = {
        title: finalBookData.title || 'Untitled Book',
        subtitle: finalBookData.subtitle || '',
        author: finalBookData.author || 'Unknown',
        translator: finalBookData.translator || '',
        tagline: finalBookData.tagline || '',
        category: finalBookData.category || 'General',
        language: finalBookData.language || 'Bangla',
        audioUrl: finalBookData.audioUrl || '',

        // Direct Firebase Storage Download URLs & Paths
        summaryMdUrl: summaryMdUrl || '',
        summaryMdPath: summaryMdPath || '',
        summaryFilename: finalBookData.summaryFile?.name || '',

        fullBookMdUrl: fullBookMdUrl || '',
        fullBookMdPath: fullBookMdPath || '',
        fullBookFilename: finalBookData.fullBookFile?.name || '',

        pdfUrl: pdfUrl || '',
        pdfPath: pdfPath || '',
        pdfFilename: finalBookData.pdfFile?.name || '',

        coverUrl: coverUrl || '',
        coverPath: coverPath || '',

        // Brief snippet for cards (first 280 chars)
        summarySnippet: (finalBookData.summaryText || '').slice(0, 280),
        totalWords: finalBookData.totalWords || 0,
        estimatedMinutes: finalBookData.estimatedMinutes || 1,

        hasSummary: !!summaryMdUrl,
        hasFullBook: !!fullBookMdUrl,
        hasPdf: !!pdfUrl,

        slug: slug,
        createdAt: serverTimestamp(),
        publishedAtIso: timestamp
      };

      let savedTarget = 'Firestore';
      let docId = `book_${Date.now()}`;

      try {
        const docRef = await addDoc(collection(db, 'books'), bookDocData);
        docId = docRef.id;
      } catch (firestoreError) {
        console.warn('Firestore write error:', firestoreError);
        if (
          firestoreError.code === 'permission-denied' ||
          firestoreError.message?.toLowerCase().includes('permissions')
        ) {
          setShowRulesModal(true);
          // Realtime Database fallback
          try {
            await rtdbSet(dbRef(rtdb, `books/${docId}`), {
              ...bookDocData,
              id: docId,
              createdAt: timestamp
            });
            savedTarget = 'Realtime Database';
          } catch (rtdbErr) {
            const localCache = JSON.parse(localStorage.getItem('audio_books_cache') || '[]');
            localCache.unshift({
              ...bookDocData,
              id: docId,
              createdAt: timestamp,
              isOfflineSaved: true
            });
            localStorage.setItem('audio_books_cache', JSON.stringify(localCache));
            savedTarget = 'Local Storage (Pending Rules)';
          }
        } else {
          throw firestoreError;
        }
      }

      // Also sync to Realtime DB if Firestore succeeded
      if (savedTarget === 'Firestore') {
        try {
          await rtdbSet(dbRef(rtdb, `books/${docId}`), {
            ...bookDocData,
            id: docId,
            createdAt: timestamp
          });
        } catch (rtdbErr) {
          // ignore
        }
      }

      setUploadProgress(100);
      setUploadStage('Upload Complete!');

      confetti({
        particleCount: 80,
        spread: 70,
        origin: { y: 0.6 }
      });

      addToast({
        type: 'info',
        title: 'Book Published to Firebase!',
        message: `"${finalBookData.title}" files uploaded to Storage and linked in Firestore.`
      });

      setParsedBook(null);
      await fetchBooks();
      setActiveTab('library');

    } catch (error) {
      console.error('Failed to upload book:', error);
      if (
        error.code === 'storage/unauthorized' ||
        error.code === 'permission-denied' ||
        error.message?.toLowerCase().includes('permissions') ||
        error.message?.toLowerCase().includes('unauthorized')
      ) {
        setShowRulesModal(true);
      }
      addToast({
        type: 'error',
        title: 'Upload Failed',
        message: error.message || 'Firebase error. Please ensure rules allow access.'
      });
    } finally {
      setIsUploading(false);
    }
  };

  // Delete book from Firestore & Firebase Storage
  const handleDeleteBook = async (book) => {
    if (!window.confirm(`Are you sure you want to delete "${book.title}" from Firebase?`)) {
      return;
    }

    try {
      // 1. Delete Firestore Document
      await deleteDoc(doc(db, 'books', book.id));

      // 2. Delete Realtime DB entry
      try {
        await rtdbRemove(dbRef(rtdb, `books/${book.id}`));
      } catch (e) {
        // ignore
      }

      // 3. Delete files from Firebase Storage
      const pathsToDelete = [book.summaryMdPath, book.fullBookMdPath, book.pdfPath, book.coverPath].filter(Boolean);
      for (const p of pathsToDelete) {
        try {
          await deleteObject(storageRef(storage, p));
        } catch (storageErr) {
          console.warn('Could not delete storage file:', p, storageErr);
        }
      }

      // 4. Remove from offline cache if present
      try {
        const local = JSON.parse(localStorage.getItem('audio_books_cache') || '[]');
        const updated = local.filter(b => b.id !== book.id);
        localStorage.setItem('audio_books_cache', JSON.stringify(updated));
      } catch (e) {
        // ignore
      }

      setBooks(prev => prev.filter(b => b.id !== book.id));
      addToast({
        type: 'info',
        title: 'Book Deleted',
        message: 'The book record and associated files were removed from Firebase.'
      });
    } catch (err) {
      console.error('Delete error:', err);
      addToast({
        type: 'error',
        title: 'Delete Failed',
        message: err.message
      });
    }
  };

  return (
    <div style={{ minHeight: '100vh', display: 'flex', flexDirection: 'column' }}>
      {/* Toast Notifications */}
      <Toast toasts={toasts} onDismiss={removeToast} />

      {/* Rules & Permissions Helper Modal */}
      <RulesModal
        isOpen={showRulesModal}
        onClose={() => setShowRulesModal(false)}
      />

      {/* Top Navbar */}
      <Navbar
        activeTab={activeTab}
        setActiveTab={setActiveTab}
        bookCount={books.length}
        onOpenRules={() => setShowRulesModal(true)}
      />

      {/* Main Content Area */}
      <main style={{ flex: 1, padding: '2rem 1.5rem' }}>
        {activeTab === 'upload' ? (
          parsedBook ? (
            <BookPreview
              bookData={parsedBook}
              onCancel={() => setParsedBook(null)}
              onUpload={handleUploadBook}
              isUploading={isUploading}
              uploadProgress={uploadProgress}
              uploadStage={uploadStage}
            />
          ) : (
            <BookUploader
              onParsedBook={setParsedBook}
              onShowToast={addToast}
            />
          )
        ) : (
          <LibraryView
            books={books}
            loading={loadingBooks}
            onRefresh={fetchBooks}
            onDeleteBook={handleDeleteBook}
          />
        )}
      </main>

      {/* Footer */}
      <footer style={{
        padding: '1.5rem',
        textAlign: 'center',
        borderTop: '1px solid rgba(255, 255, 255, 0.06)',
        color: '#64748b',
        fontSize: '0.82rem'
      }}>
        <div>AudioBook Studio &bull; Firebase Markdown Uploader &bull; Connected to project <strong>book-store-bec15</strong></div>
      </footer>
    </div>
  );
}
