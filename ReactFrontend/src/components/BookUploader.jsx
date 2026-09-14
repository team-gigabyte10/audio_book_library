import React, { useState, useRef } from 'react';
import { 
  UploadCloud, FileText, FileCode, BookOpen, FileCheck, 
  Image, Sparkles, Check, Info, Trash2, ArrowRight 
} from 'lucide-react';
import { extractBookMetadata, formatFileSize } from '../utils/mdParser';

export default function BookUploader({ onProceedToReview, onParsedBook, onShowToast }) {
  const [summaryFile, setSummaryFile] = useState(null);
  const [summaryText, setSummaryText] = useState('');
  
  const [fullBookFile, setFullBookFile] = useState(null);
  const [fullBookText, setFullBookText] = useState('');
  
  const [pdfFile, setPdfFile] = useState(null);
  
  const [coverFile, setCoverFile] = useState(null);
  const [coverPreview, setCoverPreview] = useState(null);
  
  const [category, setCategory] = useState('Personal Finance & Business');
  const [language, setLanguage] = useState('Bangla');
  const [audioUrl, setAudioUrl] = useState('');

  const [isDraggingOverall, setIsDraggingOverall] = useState(false);

  // Hidden file inputs
  const summaryInputRef = useRef(null);
  const fullBookInputRef = useRef(null);
  const pdfInputRef = useRef(null);
  const coverInputRef = useRef(null);

  // Smart multi-file distributor
  const handleIncomingFiles = (files) => {
    if (!files || files.length === 0) return;

    let detectedSummary = false;
    let detectedFull = false;
    let detectedPdf = false;
    let detectedCover = false;

    Array.from(files).forEach((file) => {
      const name = file.name.toLowerCase();

      if (name.endsWith('.pdf')) {
        setPdfFile(file);
        detectedPdf = true;
      } else if (name.match(/\.(jpg|jpeg|png|webp)$/)) {
        setCoverFile(file);
        setCoverPreview(URL.createObjectURL(file));
        detectedCover = true;
      } else if (name.endsWith('.md') || name.endsWith('.markdown') || name.endsWith('.txt')) {
        const reader = new FileReader();
        reader.onload = (e) => {
          const content = e.target.result;
          // If filename has 'summary' or if summary isn't set yet, treat as summary
          if (name.includes('summary') || !summaryFile) {
            setSummaryFile(file);
            setSummaryText(content);
          } else {
            setFullBookFile(file);
            setFullBookText(content);
          }
        };
        reader.readAsText(file);
        detectedSummary = true;
      }
    });

    onShowToast({
      type: 'info',
      title: 'Files Processed',
      message: `Attached ${files.length} file(s). Review slots below.`
    });
  };

  const handleIndividualSummary = (file) => {
    if (!file) return;
    setSummaryFile(file);
    const reader = new FileReader();
    reader.onload = (e) => setSummaryText(e.target.result);
    reader.readAsText(file);
  };

  const handleIndividualFullBook = (file) => {
    if (!file) return;
    setFullBookFile(file);
    const reader = new FileReader();
    reader.onload = (e) => setFullBookText(e.target.result);
    reader.readAsText(file);
  };

  const handleIndividualPdf = (file) => {
    if (!file) return;
    if (!file.name.toLowerCase().endsWith('.pdf')) {
      onShowToast({
        type: 'error',
        title: 'Invalid File',
        message: 'Please choose a .pdf document.'
      });
      return;
    }
    setPdfFile(file);
  };

  const handleIndividualCover = (file) => {
    if (!file) return;
    setCoverFile(file);
    setCoverPreview(URL.createObjectURL(file));
  };

  const loadSampleFiles = () => {
    const sampleSummary = `# ধনী বাবা গরীব বাবা
*(বইয়ের পূর্ণাঙ্গ বাংলা সারসংক্ষেপ)*

**মূল লেখক:** রবার্ট টি. কিওসাকি  
**অনুবাদক ও সংকলক:** মোঃ আবির আহমেদ  

**আর্থিক স্বাধীনতার এক অনবদ্য নির্দেশিকা**

---

## ভূমিকা ও সারসংক্ষেপ
রবার্ট কিওসাকির এই বিখ্যাত বইটি দুই বাবার আর্থিক দৃষ্টিভঙ্গির মাধ্যমে ধনী ও দরিদ্র মানসিকতার মৌলিক পার্থক্য তুলে ধরে।
- ধনী বাবা শিখিয়েছেন: অর্থকে নিজের জন্য কাজে লাগাও।
- গরীব বাবা শিখিয়েছেন: একটি নিরাপদ চাকরির জন্য কঠোর পরিশ্রম করো।

পুঁজি বিনিযোগ, সম্পদ বৃদ্ধি ও অর্থনৈতিক সচেতনতার জন্য এটি একটি আন্তর্জাতিক কালজয়ী ক্লাসিক।`;

    const sampleFullBook = `# ধনী বাবা গরীব বাবা (সম্পূর্ণ বই)
**লেখক:** রবার্ট টি. কিওসাকি

[এখানে সম্পূর্ণ বইয়ের বিস্তারিত বাংলা অনুবাদ সংকলিত হয়েছে...]`;

    const summaryBlob = new Blob([sampleSummary], { type: 'text/markdown' });
    const fullBlob = new Blob([sampleFullBook], { type: 'text/markdown' });
    const pdfBlob = new Blob(['%PDF-1.4 sample pdf placeholder'], { type: 'application/pdf' });

    setSummaryFile(new File([summaryBlob], 'Rich_Dad_Poor_Dad_Summary.md', { type: 'text/markdown' }));
    setSummaryText(sampleSummary);

    setFullBookFile(new File([fullBlob], 'Rich_Dad_Poor_Dad_Full_Book.md', { type: 'text/markdown' }));
    setFullBookText(sampleFullBook);

    setPdfFile(new File([pdfBlob], 'Rich_Dad_Poor_Dad_Bangla_Full.pdf', { type: 'application/pdf' }));

    onShowToast({
      type: 'info',
      title: 'Sample Files Loaded',
      message: 'Attached sample Summary.md, Full Book.md, and PDF.'
    });
  };

  const handleProceed = () => {
    if (!summaryFile && !fullBookFile && !pdfFile) {
      onShowToast({
        type: 'error',
        title: 'Missing Files',
        message: 'Please upload at least a Summary .md, Full Book .md, or PDF file.'
      });
      return;
    }

    // Extract metadata from whichever markdown file is available
    const primaryText = summaryText || fullBookText || '';
    const primaryName = summaryFile?.name || fullBookFile?.name || pdfFile?.name || '';
    const extracted = extractBookMetadata(primaryText, primaryName);

    const callback = onProceedToReview || onParsedBook;
    if (callback) {
      callback({
        ...extracted,
        summaryFile,
        summaryText,
        fullBookFile,
        fullBookText,
        pdfFile,
        coverFile,
        coverPreview,
        category,
        language,
        audioUrl
      });
    }
  };

  const hasAnyFile = summaryFile || fullBookFile || pdfFile;

  return (
    <div style={{ maxWidth: 960, margin: '0 auto', display: 'flex', flexDirection: 'column', gap: '1.75rem' }}>
      
      {/* Banner Card */}
      <div className="glass-panel" style={{ padding: '2rem', position: 'relative', overflow: 'hidden' }}>
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', flexWrap: 'wrap', gap: '1rem' }}>
          <div>
            <span className="badge badge-indigo" style={{ marginBottom: '0.75rem' }}>
              <Sparkles size={12} /> Direct Firebase Storage & Firestore Link
            </span>
            <h1 style={{ fontSize: '1.85rem', marginBottom: '0.5rem' }}>
              Upload Book Files (Summary .md, Full .md, PDF)
            </h1>
            <p style={{ color: 'var(--text-muted)', fontSize: '0.92rem', maxWidth: 620, lineHeight: 1.6 }}>
              Upload your <strong>Summary Markdown</strong>, <strong>Full Book Markdown</strong>, and <strong>PDF</strong> files directly into Firebase Storage. Book metadata and secure download links will be stored in Cloud Firestore (no chapter text in the database).
            </p>
          </div>

          <button
            type="button"
            onClick={loadSampleFiles}
            className="btn-secondary"
            style={{ fontSize: '0.85rem' }}
          >
            <Sparkles size={16} color="#a855f7" /> Load Sample Files
          </button>
        </div>
      </div>

      {/* Unified Multi-File Drop Area */}
      <div
        className={`dropzone ${isDraggingOverall ? 'active' : ''}`}
        onDragOver={(e) => { e.preventDefault(); setIsDraggingOverall(true); }}
        onDragLeave={() => setIsDraggingOverall(false)}
        onDrop={(e) => {
          e.preventDefault();
          setIsDraggingOverall(false);
          handleIncomingFiles(e.dataTransfer.files);
        }}
      >
        <div style={{
          width: 60,
          height: 60,
          borderRadius: 16,
          background: 'rgba(99, 102, 241, 0.12)',
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'center',
          margin: '0 auto 1rem',
          border: '1px solid rgba(99, 102, 241, 0.3)'
        }}>
          <UploadCloud size={30} color="#6366f1" />
        </div>

        <h3 style={{ fontSize: '1.25rem', marginBottom: '0.4rem' }}>
          Drag & Drop all book files together here
        </h3>
        <p style={{ color: 'var(--text-muted)', fontSize: '0.88rem', marginBottom: '1.25rem' }}>
          Drop your <strong>.md summary</strong>, <strong>.md full book</strong>, <strong>.pdf</strong>, and <strong>cover image</strong>. The uploader will automatically place each in its dedicated slot.
        </p>

        <div style={{ display: 'flex', justifyContent: 'center', gap: '0.75rem', flexWrap: 'wrap' }}>
          <span style={{ fontSize: '0.8rem', color: '#a5b4fc', background: 'rgba(99, 102, 241, 0.1)', padding: '4px 10px', borderRadius: 6, border: '1px solid rgba(99,102,241,0.2)' }}>
            📝 Summary .md
          </span>
          <span style={{ fontSize: '0.8rem', color: '#c084fc', background: 'rgba(168, 85, 247, 0.1)', padding: '4px 10px', borderRadius: 6, border: '1px solid rgba(168,85,247,0.2)' }}>
            📖 Full Book .md
          </span>
          <span style={{ fontSize: '0.8rem', color: '#f87171', background: 'rgba(239, 68, 68, 0.1)', padding: '4px 10px', borderRadius: 6, border: '1px solid rgba(239,68,68,0.2)' }}>
            📕 PDF Document
          </span>
          <span style={{ fontSize: '0.8rem', color: '#34d399', background: 'rgba(16, 185, 129, 0.1)', padding: '4px 10px', borderRadius: 6, border: '1px solid rgba(16,185,129,0.2)' }}>
            🖼️ Cover Image
          </span>
        </div>
      </div>

      {/* 3 Dedicated File Slots */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(280px, 1fr))', gap: '1.25rem' }}>
        
        {/* Slot 1: Summary Markdown */}
        <div className="glass-panel" style={{ padding: '1.25rem', display: 'flex', flexDirection: 'column', justifyContent: 'space-between', gap: '1rem', border: summaryFile ? '1px solid rgba(99, 102, 241, 0.5)' : '1px solid var(--border-subtle)' }}>
          <div>
            <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: '0.75rem' }}>
              <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem', fontWeight: 700, color: '#a5b4fc' }}>
                <FileText size={18} /> 1. Summary Markdown (.md)
              </div>
              {summaryFile && <Check size={18} color="#10b981" />}
            </div>
            
            <p style={{ fontSize: '0.8rem', color: 'var(--text-muted)', marginBottom: '0.75rem' }}>
              Short summary or chapter notes script in markdown format.
            </p>

            {summaryFile ? (
              <div style={{ background: 'rgba(99, 102, 241, 0.08)', padding: '0.75rem', borderRadius: 8, border: '1px solid rgba(99, 102, 241, 0.2)' }}>
                <div style={{ fontWeight: 600, fontSize: '0.85rem', color: '#f8fafc', wordBreak: 'break-all' }}>
                  {summaryFile.name}
                </div>
                <div style={{ fontSize: '0.75rem', color: '#94a3b8', marginTop: 2 }}>
                  {formatFileSize(summaryFile.size)}
                </div>
              </div>
            ) : (
              <div style={{ padding: '1rem', textAlign: 'center', border: '1px dashed var(--border-subtle)', borderRadius: 8, color: '#64748b', fontSize: '0.82rem' }}>
                No summary file selected
              </div>
            )}
          </div>

          <div style={{ display: 'flex', gap: '0.5rem' }}>
            <input
              type="file"
              ref={summaryInputRef}
              accept=".md,.markdown,.txt"
              style={{ display: 'none' }}
              onChange={(e) => handleIndividualSummary(e.target.files?.[0])}
            />
            <button
              type="button"
              className="btn-secondary"
              style={{ flex: 1, fontSize: '0.82rem', padding: '0.5rem' }}
              onClick={() => summaryInputRef.current?.click()}
            >
              {summaryFile ? 'Change Summary' : 'Select Summary .md'}
            </button>
            {summaryFile && (
              <button
                type="button"
                className="btn-secondary"
                style={{ color: '#ef4444', padding: '0.5rem 0.75rem' }}
                onClick={() => { setSummaryFile(null); setSummaryText(''); }}
              >
                <Trash2 size={14} />
              </button>
            )}
          </div>
        </div>

        {/* Slot 2: Full Book Markdown */}
        <div className="glass-panel" style={{ padding: '1.25rem', display: 'flex', flexDirection: 'column', justifyContent: 'space-between', gap: '1rem', border: fullBookFile ? '1px solid rgba(168, 85, 247, 0.5)' : '1px solid var(--border-subtle)' }}>
          <div>
            <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: '0.75rem' }}>
              <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem', fontWeight: 700, color: '#c084fc' }}>
                <BookOpen size={18} /> 2. Full Book Markdown (.md)
              </div>
              {fullBookFile && <Check size={18} color="#10b981" />}
            </div>
            
            <p style={{ fontSize: '0.8rem', color: 'var(--text-muted)', marginBottom: '0.75rem' }}>
              Optional complete book manuscript or full translation in markdown.
            </p>

            {fullBookFile ? (
              <div style={{ background: 'rgba(168, 85, 247, 0.08)', padding: '0.75rem', borderRadius: 8, border: '1px solid rgba(168, 85, 247, 0.2)' }}>
                <div style={{ fontWeight: 600, fontSize: '0.85rem', color: '#f8fafc', wordBreak: 'break-all' }}>
                  {fullBookFile.name}
                </div>
                <div style={{ fontSize: '0.75rem', color: '#94a3b8', marginTop: 2 }}>
                  {formatFileSize(fullBookFile.size)}
                </div>
              </div>
            ) : (
              <div style={{ padding: '1rem', textAlign: 'center', border: '1px dashed var(--border-subtle)', borderRadius: 8, color: '#64748b', fontSize: '0.82rem' }}>
                No full book file selected
              </div>
            )}
          </div>

          <div style={{ display: 'flex', gap: '0.5rem' }}>
            <input
              type="file"
              ref={fullBookInputRef}
              accept=".md,.markdown,.txt"
              style={{ display: 'none' }}
              onChange={(e) => handleIndividualFullBook(e.target.files?.[0])}
            />
            <button
              type="button"
              className="btn-secondary"
              style={{ flex: 1, fontSize: '0.82rem', padding: '0.5rem' }}
              onClick={() => fullBookInputRef.current?.click()}
            >
              {fullBookFile ? 'Change Full Book' : 'Select Full .md'}
            </button>
            {fullBookFile && (
              <button
                type="button"
                className="btn-secondary"
                style={{ color: '#ef4444', padding: '0.5rem 0.75rem' }}
                onClick={() => { setFullBookFile(null); setFullBookText(''); }}
              >
                <Trash2 size={14} />
              </button>
            )}
          </div>
        </div>

        {/* Slot 3: PDF Document */}
        <div className="glass-panel" style={{ padding: '1.25rem', display: 'flex', flexDirection: 'column', justifyContent: 'space-between', gap: '1rem', border: pdfFile ? '1px solid rgba(239, 68, 68, 0.5)' : '1px solid var(--border-subtle)' }}>
          <div>
            <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: '0.75rem' }}>
              <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem', fontWeight: 700, color: '#f87171' }}>
                <FileCode size={18} /> 3. PDF Book Document (.pdf)
              </div>
              {pdfFile && <Check size={18} color="#10b981" />}
            </div>
            
            <p style={{ fontSize: '0.8rem', color: 'var(--text-muted)', marginBottom: '0.75rem' }}>
              Official PDF version for mobile readers or downloaders.
            </p>

            {pdfFile ? (
              <div style={{ background: 'rgba(239, 68, 68, 0.08)', padding: '0.75rem', borderRadius: 8, border: '1px solid rgba(239, 68, 68, 0.2)' }}>
                <div style={{ fontWeight: 600, fontSize: '0.85rem', color: '#f8fafc', wordBreak: 'break-all' }}>
                  {pdfFile.name}
                </div>
                <div style={{ fontSize: '0.75rem', color: '#94a3b8', marginTop: 2 }}>
                  {formatFileSize(pdfFile.size)}
                </div>
              </div>
            ) : (
              <div style={{ padding: '1rem', textAlign: 'center', border: '1px dashed var(--border-subtle)', borderRadius: 8, color: '#64748b', fontSize: '0.82rem' }}>
                No PDF file selected
              </div>
            )}
          </div>

          <div style={{ display: 'flex', gap: '0.5rem' }}>
            <input
              type="file"
              ref={pdfInputRef}
              accept=".pdf"
              style={{ display: 'none' }}
              onChange={(e) => handleIndividualPdf(e.target.files?.[0])}
            />
            <button
              type="button"
              className="btn-secondary"
              style={{ flex: 1, fontSize: '0.82rem', padding: '0.5rem' }}
              onClick={() => pdfInputRef.current?.click()}
            >
              {pdfFile ? 'Change PDF' : 'Select PDF .pdf'}
            </button>
            {pdfFile && (
              <button
                type="button"
                className="btn-secondary"
                style={{ color: '#ef4444', padding: '0.5rem 0.75rem' }}
                onClick={() => setPdfFile(null)}
              >
                <Trash2 size={14} />
              </button>
            )}
          </div>
        </div>

      </div>

      {/* Book Settings & Metadata Config */}
      <div className="glass-panel" style={{ padding: '1.75rem' }}>
        <h4 style={{ fontSize: '1.05rem', marginBottom: '1.25rem', display: 'flex', alignItems: 'center', gap: '0.5rem' }}>
          <Info size={18} color="#818cf8" /> Book Settings, Cover & Audio Stream
        </h4>

        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(240px, 1fr))', gap: '1.25rem' }}>
          <div>
            <label className="input-label">Language</label>
            <select
              className="input-field"
              value={language}
              onChange={(e) => setLanguage(e.target.value)}
            >
              <option value="Bangla">বাংলা (Bangla)</option>
              <option value="English">English</option>
              <option value="Hindi">Hindi</option>
              <option value="Other">Other</option>
            </select>
          </div>

          <div>
            <label className="input-label">Category</label>
            <select
              className="input-field"
              value={category}
              onChange={(e) => setCategory(e.target.value)}
            >
              <option value="Personal Finance & Business">Personal Finance & Business</option>
              <option value="Self Improvement">Self Improvement</option>
              <option value="Psychology & Mindset">Psychology & Mindset</option>
              <option value="Productivity & Habits">Productivity & Habits</option>
              <option value="Biographies & History">Biographies & History</option>
              <option value="Fiction & Literature">Fiction & Literature</option>
            </select>
          </div>

          <div style={{ gridColumn: '1 / -1' }}>
            <label className="input-label">Audio Stream / MP3 URL (Optional)</label>
            <input
              type="url"
              className="input-field"
              placeholder="https://domain.com/audiobook.mp3"
              value={audioUrl}
              onChange={(e) => setAudioUrl(e.target.value)}
            />
          </div>

          {/* Cover image picker */}
          <div style={{ gridColumn: '1 / -1' }}>
            <label className="input-label">Book Cover Image (Optional)</label>
            <div style={{ display: 'flex', alignItems: 'center', gap: '1.25rem', flexWrap: 'wrap' }}>
              <input
                type="file"
                ref={coverInputRef}
                accept="image/*"
                style={{ display: 'none' }}
                onChange={(e) => handleIndividualCover(e.target.files?.[0])}
              />
              <button
                type="button"
                className="btn-secondary"
                onClick={() => coverInputRef.current?.click()}
              >
                <Image size={16} /> Choose Cover Image
              </button>

              {coverPreview && (
                <div style={{ display: 'flex', alignItems: 'center', gap: '0.75rem' }}>
                  <img
                    src={coverPreview}
                    alt="Cover Preview"
                    style={{ width: 44, height: 58, objectFit: 'cover', borderRadius: 6, border: '1px solid var(--border-accent)' }}
                  />
                  <span style={{ fontSize: '0.85rem', color: '#10b981' }}>
                    <Check size={14} style={{ display: 'inline', verticalAlign: 'middle', marginRight: 4 }} />
                    {coverFile?.name}
                  </span>
                </div>
              )}
            </div>
          </div>
        </div>
      </div>

      {/* Continue to Review / Publish */}
      <div style={{ display: 'flex', justifyContent: 'flex-end' }}>
        <button
          type="button"
          onClick={handleProceed}
          disabled={!hasAnyFile}
          className="btn-primary"
          style={{ padding: '0.85rem 2rem', fontSize: '1rem' }}
        >
          <span>Continue to Review & Upload</span>
          <ArrowRight size={18} />
        </button>
      </div>

    </div>
  );
}
