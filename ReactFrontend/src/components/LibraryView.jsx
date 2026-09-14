import React, { useState } from 'react';
import { 
  Search, BookOpen, Clock, FileDown, Trash2, ExternalLink, 
  Headphones, Layers, CheckCircle, RefreshCw, FileText, FileCode, Sparkles 
} from 'lucide-react';

export default function LibraryView({ books, loading, onRefresh, onDeleteBook }) {
  const [searchTerm, setSearchTerm] = useState('');
  const [filterCategory, setFilterCategory] = useState('All');

  const filteredBooks = books.filter(b => {
    const matchesSearch = 
      (b.title || '').toLowerCase().includes(searchTerm.toLowerCase()) ||
      (b.author || '').toLowerCase().includes(searchTerm.toLowerCase()) ||
      (b.translator || '').toLowerCase().includes(searchTerm.toLowerCase());
    const matchesCategory = filterCategory === 'All' || b.category === filterCategory;
    return matchesSearch && matchesCategory;
  });

  const categories = ['All', ...new Set(books.map(b => b.category).filter(Boolean))];

  return (
    <div style={{ maxWidth: 1100, margin: '0 auto', display: 'flex', flexDirection: 'column', gap: '1.5rem' }}>
      
      {/* Header Controls */}
      <div className="glass-panel" style={{ padding: '1.5rem 2rem' }}>
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', flexWrap: 'wrap', gap: '1rem', marginBottom: '1.25rem' }}>
          <div>
            <h2 style={{ fontSize: '1.5rem', marginBottom: '0.25rem' }}>Firebase Book Repository</h2>
            <p style={{ color: 'var(--text-muted)', fontSize: '0.88rem' }}>
              Files securely stored in Firebase Storage with clean links and metadata in Cloud Firestore
            </p>
          </div>

          <button
            onClick={onRefresh}
            disabled={loading}
            className="btn-secondary"
            style={{ fontSize: '0.85rem' }}
          >
            <RefreshCw size={15} className={loading ? 'animate-spin' : ''} style={{ animation: loading ? 'spin 1s linear infinite' : 'none' }} />
            Refresh
          </button>
        </div>

        {/* Search & Category Filter */}
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(220px, 1fr))', gap: '1rem' }}>
          <div style={{ position: 'relative' }}>
            <Search size={16} color="#94a3b8" style={{ position: 'absolute', left: 14, top: '50%', transform: 'translateY(-50%)' }} />
            <input
              type="text"
              className="input-field"
              placeholder="Search by title, author, translator..."
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
              style={{ paddingLeft: '2.5rem' }}
            />
          </div>

          <select
            className="input-field"
            value={filterCategory}
            onChange={(e) => setFilterCategory(e.target.value)}
          >
            {categories.map(cat => (
              <option key={cat} value={cat}>{cat} ({cat === 'All' ? books.length : books.filter(b => b.category === cat).length})</option>
            ))}
          </select>
        </div>
      </div>

      {/* Book List / Cards */}
      {loading ? (
        <div className="glass-panel" style={{ padding: '3rem', textAlign: 'center', color: 'var(--text-muted)' }}>
          <RefreshCw size={32} className="animate-spin" style={{ animation: 'spin 1s linear infinite', margin: '0 auto 1rem', color: 'var(--accent-primary)' }} />
          <div>Retrieving book catalog from Firebase...</div>
        </div>
      ) : filteredBooks.length === 0 ? (
        <div className="glass-panel" style={{ padding: '3.5rem 2rem', textAlign: 'center' }}>
          <BookOpen size={48} color="#6366f1" style={{ opacity: 0.5, margin: '0 auto 1rem' }} />
          <h3 style={{ fontSize: '1.25rem', marginBottom: '0.5rem' }}>No Books Found</h3>
          <p style={{ color: 'var(--text-muted)', fontSize: '0.9rem', maxWidth: 460, margin: '0 auto 1.5rem' }}>
            {searchTerm || filterCategory !== 'All' 
              ? 'No books matched your search query. Try clearing filters.'
              : 'Your Firebase collection is empty. Upload your first Summary .md, Full .md, or PDF file!'}
          </p>
        </div>
      ) : (
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(330px, 1fr))', gap: '1.25rem' }}>
          {filteredBooks.map((book) => (
            <div
              key={book.id}
              className="glass-panel glass-panel-hover"
              style={{
                padding: '1.5rem',
                display: 'flex',
                flexDirection: 'column',
                justifyContent: 'space-between',
                gap: '1rem',
                position: 'relative'
              }}
            >
              <div>
                {/* Header row with badges & cover */}
                <div style={{ display: 'flex', gap: '1rem', alignItems: 'flex-start', marginBottom: '0.85rem' }}>
                  {book.coverUrl && (
                    <img
                      src={book.coverUrl}
                      alt="Cover"
                      style={{
                        width: 50,
                        height: 70,
                        objectFit: 'cover',
                        borderRadius: 6,
                        border: '1px solid var(--border-subtle)',
                        flexShrink: 0
                      }}
                    />
                  )}

                  <div style={{ flex: 1 }}>
                    <div style={{ display: 'flex', gap: '0.4rem', flexWrap: 'wrap', marginBottom: '0.4rem' }}>
                      <span className="badge badge-indigo">{book.category || 'General'}</span>
                      {book.language && <span className="badge badge-emerald">{book.language}</span>}
                    </div>

                    <h3 style={{ fontSize: '1.2rem', color: '#f8fafc', lineHeight: 1.3 }}>
                      {book.title}
                    </h3>
                  </div>
                </div>

                {book.subtitle && (
                  <p style={{ fontSize: '0.83rem', color: '#a5b4fc', marginBottom: '0.5rem', fontStyle: 'italic' }}>
                    {book.subtitle}
                  </p>
                )}

                <div style={{ fontSize: '0.82rem', color: 'var(--text-muted)', marginBottom: '0.75rem' }}>
                  {book.author && <div><strong>Author:</strong> {book.author}</div>}
                  {book.translator && <div><strong>Translator:</strong> {book.translator}</div>}
                </div>

                {book.summarySnippet && (
                  <div style={{
                    fontSize: '0.8rem',
                    color: '#94a3b8',
                    lineHeight: 1.5,
                    marginBottom: '0.85rem',
                    background: 'rgba(255,255,255,0.02)',
                    padding: '0.6rem 0.75rem',
                    borderRadius: 8,
                    border: '1px solid var(--border-subtle)'
                  }}>
                    {book.summarySnippet}...
                  </div>
                )}

                {/* Word count & reading time stats */}
                <div style={{
                  display: 'flex',
                  gap: '1rem',
                  padding: '0.65rem 0',
                  borderTop: '1px solid var(--border-subtle)',
                  borderBottom: '1px solid var(--border-subtle)',
                  fontSize: '0.78rem',
                  color: 'var(--text-muted)'
                }}>
                  {book.totalWords > 0 && (
                    <span>{book.totalWords.toLocaleString()} words</span>
                  )}
                  <span>~{book.estimatedMinutes || 1} min read</span>
                </div>
              </div>

              {/* Action Buttons: Direct Links to Firebase Storage Assets */}
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.65rem', marginTop: '0.5rem' }}>
                <div style={{ display: 'flex', gap: '0.5rem', flexWrap: 'wrap' }}>
                  
                  {/* Summary .md link */}
                  {book.summaryMdUrl && (
                    <a
                      href={book.summaryMdUrl}
                      target="_blank"
                      rel="noopener noreferrer"
                      className="btn-secondary"
                      title="Download Summary Markdown from Firebase Storage"
                      style={{ padding: '0.4rem 0.65rem', fontSize: '0.78rem', color: '#a5b4fc' }}
                    >
                      <FileText size={13} /> Summary .md
                    </a>
                  )}

                  {/* Full Book .md link */}
                  {book.fullBookMdUrl && (
                    <a
                      href={book.fullBookMdUrl}
                      target="_blank"
                      rel="noopener noreferrer"
                      className="btn-secondary"
                      title="Download Full Book Markdown from Firebase Storage"
                      style={{ padding: '0.4rem 0.65rem', fontSize: '0.78rem', color: '#c084fc' }}
                    >
                      <BookOpen size={13} /> Full .md
                    </a>
                  )}

                  {/* PDF Document link */}
                  {book.pdfUrl && (
                    <a
                      href={book.pdfUrl}
                      target="_blank"
                      rel="noopener noreferrer"
                      className="btn-secondary"
                      title="Open or Download PDF from Firebase Storage"
                      style={{ padding: '0.4rem 0.65rem', fontSize: '0.78rem', color: '#f87171' }}
                    >
                      <FileCode size={13} /> PDF
                    </a>
                  )}

                  {/* Audio Stream */}
                  {book.audioUrl && (
                    <a
                      href={book.audioUrl}
                      target="_blank"
                      rel="noopener noreferrer"
                      className="btn-secondary"
                      title="Open Audio Stream"
                      style={{ padding: '0.4rem 0.65rem', fontSize: '0.78rem', color: '#6ee7b7' }}
                    >
                      <Headphones size={13} /> Audio
                    </a>
                  )}
                </div>

                {/* Bottom delete / status row */}
                <div style={{ display: 'flex', justifyContent: 'flex-end', paddingTop: '0.25rem' }}>
                  <button
                    onClick={() => onDeleteBook(book)}
                    className="btn-secondary"
                    title="Delete Book from Firebase"
                    style={{
                      padding: '0.35rem 0.65rem',
                      color: '#ef4444',
                      fontSize: '0.78rem',
                      borderColor: 'rgba(239, 68, 68, 0.2)'
                    }}
                  >
                    <Trash2 size={13} /> Delete
                  </button>
                </div>
              </div>

            </div>
          ))}
        </div>
      )}
    </div>
  );
}
