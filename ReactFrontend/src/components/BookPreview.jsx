import React, { useState } from 'react';
import { 
  FileText, BookOpen, FileCode, UploadCloud, Edit3, 
  Eye, ArrowLeft, Loader2, CheckCircle2, Image 
} from 'lucide-react';
import { marked } from 'marked';
import { formatFileSize } from '../utils/mdParser';

marked.setOptions({
  gfm: true,
  breaks: true
});

export default function BookPreview({ 
  bookData, 
  onCancel, 
  onUpload, 
  isUploading, 
  uploadProgress, 
  uploadStage 
}) {
  const [activeTab, setActiveTab] = useState('summary'); // 'summary' | 'full'

  // Editable metadata
  const [title, setTitle] = useState(bookData.title || '');
  const [subtitle, setSubtitle] = useState(bookData.subtitle || '');
  const [author, setAuthor] = useState(bookData.author || '');
  const [translator, setTranslator] = useState(bookData.translator || '');
  const [tagline, setTagline] = useState(bookData.tagline || '');
  const [category, setCategory] = useState(bookData.category || 'Personal Finance & Business');
  const [language, setLanguage] = useState(bookData.language || 'Bangla');
  const [audioUrl, setAudioUrl] = useState(bookData.audioUrl || '');

  const handleTriggerUpload = () => {
    onUpload({
      ...bookData,
      title,
      subtitle,
      author,
      translator,
      tagline,
      category,
      language,
      audioUrl
    });
  };

  return (
    <div style={{ maxWidth: 1100, margin: '0 auto', display: 'flex', flexDirection: 'column', gap: '1.5rem' }}>
      
      {/* Top Header Bar */}
      <div className="glass-panel" style={{ padding: '1.5rem 2rem', display: 'flex', alignItems: 'center', justifyContent: 'space-between', flexWrap: 'wrap', gap: '1rem' }}>
        <div style={{ display: 'flex', alignItems: 'center', gap: '1rem' }}>
          <button
            onClick={onCancel}
            disabled={isUploading}
            className="btn-secondary"
            style={{ padding: '0.5rem 0.85rem' }}
          >
            <ArrowLeft size={16} /> Back
          </button>

          <div>
            <div style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>
              Ready to Upload to Firebase
            </div>
            <h2 style={{ fontSize: '1.4rem' }}>Review Metadata & Attached Files</h2>
          </div>
        </div>

        {/* Upload Action */}
        <button
          onClick={handleTriggerUpload}
          disabled={isUploading}
          className="btn-primary"
          style={{ minWidth: 230, justifyContent: 'center' }}
        >
          {isUploading ? (
            <>
              <Loader2 size={18} className="animate-spin" style={{ animation: 'spin 1s linear infinite' }} />
              <span>{uploadProgress}% Uploading...</span>
            </>
          ) : (
            <>
              <UploadCloud size={18} />
              <span>Publish to Firebase</span>
            </>
          )}
        </button>
      </div>

      {/* Progress Bar (during upload) */}
      {isUploading && (
        <div className="glass-panel" style={{ padding: '1.25rem', border: '1px solid var(--accent-primary)' }}>
          <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: '0.5rem', fontSize: '0.85rem' }}>
            <span style={{ color: '#a5b4fc', fontWeight: 600 }}>{uploadStage || 'Uploading files...'}</span>
            <span style={{ color: '#f8fafc', fontWeight: 700 }}>{uploadProgress}%</span>
          </div>
          <div style={{ width: '100%', height: 8, background: 'rgba(255,255,255,0.1)', borderRadius: 9999, overflow: 'hidden' }}>
            <div
              style={{
                width: `${uploadProgress}%`,
                height: '100%',
                background: 'var(--accent-gradient)',
                transition: 'width 0.3s ease'
              }}
            />
          </div>
        </div>
      )}

      {/* Attached Files Strip */}
      <div className="glass-panel" style={{ padding: '1.25rem 1.75rem' }}>
        <h4 style={{ fontSize: '0.92rem', textTransform: 'uppercase', letterSpacing: '0.05em', color: 'var(--text-muted)', marginBottom: '0.85rem' }}>
          Files Ready for Firebase Storage
        </h4>

        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(220px, 1fr))', gap: '0.85rem' }}>
          {/* Summary .md */}
          <div style={{
            background: bookData.summaryFile ? 'rgba(99, 102, 241, 0.1)' : 'rgba(255,255,255,0.03)',
            border: bookData.summaryFile ? '1px solid rgba(99, 102, 241, 0.3)' : '1px solid var(--border-subtle)',
            borderRadius: 10,
            padding: '0.75rem 1rem',
            display: 'flex',
            alignItems: 'center',
            gap: '0.75rem'
          }}>
            <FileText size={20} color={bookData.summaryFile ? '#a5b4fc' : '#64748b'} />
            <div>
              <div style={{ fontSize: '0.82rem', fontWeight: 600, color: bookData.summaryFile ? '#f8fafc' : '#64748b' }}>
                Summary Markdown
              </div>
              <div style={{ fontSize: '0.75rem', color: '#94a3b8' }}>
                {bookData.summaryFile ? `${bookData.summaryFile.name} (${formatFileSize(bookData.summaryFile.size)})` : 'Not provided'}
              </div>
            </div>
          </div>

          {/* Full Book .md */}
          <div style={{
            background: bookData.fullBookFile ? 'rgba(168, 85, 247, 0.1)' : 'rgba(255,255,255,0.03)',
            border: bookData.fullBookFile ? '1px solid rgba(168, 85, 247, 0.3)' : '1px solid var(--border-subtle)',
            borderRadius: 10,
            padding: '0.75rem 1rem',
            display: 'flex',
            alignItems: 'center',
            gap: '0.75rem'
          }}>
            <BookOpen size={20} color={bookData.fullBookFile ? '#c084fc' : '#64748b'} />
            <div>
              <div style={{ fontSize: '0.82rem', fontWeight: 600, color: bookData.fullBookFile ? '#f8fafc' : '#64748b' }}>
                Full Book Markdown
              </div>
              <div style={{ fontSize: '0.75rem', color: '#94a3b8' }}>
                {bookData.fullBookFile ? `${bookData.fullBookFile.name} (${formatFileSize(bookData.fullBookFile.size)})` : 'Not provided'}
              </div>
            </div>
          </div>

          {/* PDF Document */}
          <div style={{
            background: bookData.pdfFile ? 'rgba(239, 68, 68, 0.1)' : 'rgba(255,255,255,0.03)',
            border: bookData.pdfFile ? '1px solid rgba(239, 68, 68, 0.3)' : '1px solid var(--border-subtle)',
            borderRadius: 10,
            padding: '0.75rem 1rem',
            display: 'flex',
            alignItems: 'center',
            gap: '0.75rem'
          }}>
            <FileCode size={20} color={bookData.pdfFile ? '#f87171' : '#64748b'} />
            <div>
              <div style={{ fontSize: '0.82rem', fontWeight: 600, color: bookData.pdfFile ? '#f8fafc' : '#64748b' }}>
                PDF Document
              </div>
              <div style={{ fontSize: '0.75rem', color: '#94a3b8' }}>
                {bookData.pdfFile ? `${bookData.pdfFile.name} (${formatFileSize(bookData.pdfFile.size)})` : 'Not provided'}
              </div>
            </div>
          </div>

          {/* Cover */}
          {bookData.coverPreview && (
            <div style={{
              background: 'rgba(16, 185, 129, 0.1)',
              border: '1px solid rgba(16, 185, 129, 0.3)',
              borderRadius: 10,
              padding: '0.75rem 1rem',
              display: 'flex',
              alignItems: 'center',
              gap: '0.75rem'
            }}>
              <img
                src={bookData.coverPreview}
                alt="Cover"
                style={{ width: 28, height: 38, objectFit: 'cover', borderRadius: 4 }}
              />
              <div>
                <div style={{ fontSize: '0.82rem', fontWeight: 600, color: '#f8fafc' }}>
                  Cover Image
                </div>
                <div style={{ fontSize: '0.75rem', color: '#94a3b8' }}>
                  {bookData.coverFile?.name}
                </div>
              </div>
            </div>
          )}
        </div>
      </div>

      {/* Main Grid: Left Metadata, Right Markdown Preview */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(320px, 1fr))', gap: '1.5rem', alignItems: 'start' }}>
        
        {/* Left: Metadata form */}
        <div className="glass-panel" style={{ padding: '1.5rem', display: 'flex', flexDirection: 'column', gap: '1rem' }}>
          <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem', borderBottom: '1px solid var(--border-subtle)', paddingBottom: '0.75rem' }}>
            <Edit3 size={18} color="#818cf8" />
            <h3 style={{ fontSize: '1.1rem' }}>Firestore Metadata Fields</h3>
          </div>

          <div>
            <label className="input-label">Book Title</label>
            <input
              type="text"
              className="input-field"
              value={title}
              onChange={(e) => setTitle(e.target.value)}
              placeholder="e.g. ধনী বাবা গরীব বাবা"
            />
          </div>

          <div>
            <label className="input-label">Subtitle / Description</label>
            <input
              type="text"
              className="input-field"
              value={subtitle}
              onChange={(e) => setSubtitle(e.target.value)}
              placeholder="e.g. বইয়ের পূর্ণাঙ্গ বাংলা সারসংক্ষেপ"
            />
          </div>

          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '0.75rem' }}>
            <div>
              <label className="input-label">Original Author</label>
              <input
                type="text"
                className="input-field"
                value={author}
                onChange={(e) => setAuthor(e.target.value)}
                placeholder="e.g. রবার্ট টি. কিওসাকি"
              />
            </div>
            <div>
              <label className="input-label">Translator / Compiler</label>
              <input
                type="text"
                className="input-field"
                value={translator}
                onChange={(e) => setTranslator(e.target.value)}
                placeholder="e.g. মোঃ আবির আহমেদ"
              />
            </div>
          </div>

          <div>
            <label className="input-label">Tagline / Key Takeaway</label>
            <input
              type="text"
              className="input-field"
              value={tagline}
              onChange={(e) => setTagline(e.target.value)}
              placeholder="e.g. আর্থিক স্বাধীনতার এক অনবদ্য নির্দেশিকা"
            />
          </div>

          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '0.75rem' }}>
            <div>
              <label className="input-label">Category</label>
              <input
                type="text"
                className="input-field"
                value={category}
                onChange={(e) => setCategory(e.target.value)}
              />
            </div>
            <div>
              <label className="input-label">Language</label>
              <input
                type="text"
                className="input-field"
                value={language}
                onChange={(e) => setLanguage(e.target.value)}
              />
            </div>
          </div>

          <div>
            <label className="input-label">Audio Stream Link (MP3)</label>
            <input
              type="url"
              className="input-field"
              value={audioUrl}
              onChange={(e) => setAudioUrl(e.target.value)}
              placeholder="https://domain.com/audio.mp3"
            />
          </div>
        </div>

        {/* Right: Markdown Preview */}
        <div className="glass-panel" style={{ padding: '1.5rem', display: 'flex', flexDirection: 'column', gap: '1rem' }}>
          
          {/* View selector */}
          <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', borderBottom: '1px solid var(--border-subtle)', paddingBottom: '0.75rem' }}>
            <div style={{ display: 'flex', gap: '0.5rem' }}>
              {bookData.summaryText && (
                <button
                  onClick={() => setActiveTab('summary')}
                  className="btn-secondary"
                  style={{
                    padding: '0.4rem 0.8rem',
                    fontSize: '0.82rem',
                    background: activeTab === 'summary' ? 'var(--accent-primary)' : 'transparent',
                    color: activeTab === 'summary' ? '#fff' : 'var(--text-muted)'
                  }}
                >
                  <FileText size={14} /> Summary Preview
                </button>
              )}

              {bookData.fullBookText && (
                <button
                  onClick={() => setActiveTab('full')}
                  className="btn-secondary"
                  style={{
                    padding: '0.4rem 0.8rem',
                    fontSize: '0.82rem',
                    background: activeTab === 'full' ? 'var(--accent-primary)' : 'transparent',
                    color: activeTab === 'full' ? '#fff' : 'var(--text-muted)'
                  }}
                >
                  <BookOpen size={14} /> Full Book Preview
                </button>
              )}
            </div>

            <span style={{ fontSize: '0.78rem', color: '#94a3b8' }}>
              {activeTab === 'summary' ? `${bookData.totalWords || 0} words` : 'Full Content'}
            </span>
          </div>

          {/* Rendered Markdown Preview Area */}
          <div
            className="markdown-preview"
            style={{
              background: 'rgba(15, 23, 42, 0.6)',
              borderRadius: '12px',
              padding: '1.5rem',
              border: '1px solid var(--border-subtle)',
              maxHeight: 520,
              overflowY: 'auto'
            }}
            dangerouslySetInnerHTML={{
              __html: marked.parse(activeTab === 'summary' ? (bookData.summaryText || '') : (bookData.fullBookText || ''))
            }}
          />
        </div>

      </div>

    </div>
  );
}
