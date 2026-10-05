import React, { useState } from 'react';
import { 
  GraduationCap, Search, RefreshCw, BookOpen, Clock, 
  Star, Users, ChevronDown, ChevronUp, PlayCircle, FileText, ExternalLink 
} from 'lucide-react';

export default function CoursesView({ courses, loading, onRefresh }) {
  const [filterLang, setFilterLang] = useState('All');
  const [searchQuery, setSearchQuery] = useState('');
  const [expandedCourseId, setExpandedCourseId] = useState(null);

  const filteredCourses = courses.filter((course) => {
    const matchesLang = filterLang === 'All' || 
      (filterLang === 'English' && course.language?.toLowerCase() === 'english') ||
      (filterLang === 'Japanese' && course.language?.toLowerCase() === 'japanese');
    
    const matchesSearch = !searchQuery.trim() || 
      course.title?.toLowerCase().includes(searchQuery.toLowerCase()) ||
      course.subtitle?.toLowerCase().includes(searchQuery.toLowerCase()) ||
      course.instructor?.toLowerCase().includes(searchQuery.toLowerCase()) ||
      (course.tags && course.tags.some(t => t.toLowerCase().includes(searchQuery.toLowerCase())));

    return matchesLang && matchesSearch;
  });

  const toggleExpand = (id) => {
    setExpandedCourseId(prev => prev === id ? null : id);
  };

  return (
    <div style={{ maxWidth: 1200, margin: '0 auto', display: 'flex', flexDirection: 'column', gap: '1.5rem' }}>
      {/* Header Panel */}
      <div className="glass-panel" style={{ padding: '1.5rem 2rem', display: 'flex', alignItems: 'center', justifyContent: 'space-between', flexWrap: 'wrap', gap: '1rem' }}>
        <div>
          <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem', marginBottom: '0.25rem' }}>
            <div style={{
              width: 32,
              height: 32,
              borderRadius: 8,
              background: 'linear-gradient(135deg, #10b981, #059669)',
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'center',
              boxShadow: '0 0 14px rgba(16, 185, 129, 0.4)'
            }}>
              <GraduationCap size={18} color="#ffffff" />
            </div>
            <h2 style={{ fontSize: '1.4rem' }}>ল্যাঙ্গুয়েজ ও স্কিল কোর্স</h2>
          </div>
          <p style={{ color: 'var(--text-muted)', fontSize: '0.85rem' }}>
            Android অ্যাপ ও ফায়ারবেস কোর্সেস ডেটাবেজের সাথে সিঙ্ক করা ল্যাঙ্গুয়েজ অডিও লেসন
          </p>
        </div>

        <div style={{ display: 'flex', alignItems: 'center', gap: '0.75rem', flexWrap: 'wrap' }}>
          <button
            onClick={onRefresh}
            className="btn-secondary"
            disabled={loading}
            style={{ padding: '0.5rem 0.85rem', fontSize: '0.85rem' }}
          >
            <RefreshCw size={14} className={loading ? 'animate-spin' : ''} style={loading ? { animation: 'spin 1s linear infinite' } : {}} />
            <span>Refresh Courses</span>
          </button>
        </div>
      </div>

      {/* Filter and Search Bar */}
      <div className="glass-panel" style={{ padding: '1rem 1.5rem', display: 'flex', alignItems: 'center', justifyContent: 'space-between', flexWrap: 'wrap', gap: '1rem' }}>
        {/* Language Filter Pills */}
        <div style={{ display: 'flex', gap: '0.5rem' }}>
          {['All', 'English', 'Japanese'].map((lang) => (
            <button
              key={lang}
              onClick={() => setFilterLang(lang)}
              style={{
                padding: '0.45rem 1rem',
                borderRadius: '8px',
                border: 'none',
                cursor: 'pointer',
                fontWeight: 600,
                fontSize: '0.82rem',
                background: filterLang === lang ? 'var(--accent-primary)' : 'rgba(255,255,255,0.05)',
                color: filterLang === lang ? '#ffffff' : 'var(--text-muted)',
                transition: 'all 0.2s ease'
              }}
            >
              {lang === 'All' ? 'সব কোর্স' : lang === 'English' ? '🇬🇧 English Courses' : '🇯🇵 Japanese Courses'}
            </button>
          ))}
        </div>

        {/* Search */}
        <div style={{ position: 'relative', width: 280 }}>
          <Search size={15} color="#94a3b8" style={{ position: 'absolute', left: 10, top: '50%', transform: 'translateY(-50%)' }} />
          <input
            type="text"
            className="input-field"
            style={{ paddingLeft: '2rem', fontSize: '0.85rem' }}
            placeholder="কোর্স বা শিক্ষকের নাম দিয়ে খুঁজুন..."
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)}
          />
        </div>
      </div>

      {/* Course List / Grid */}
      {loading ? (
        <div className="glass-panel" style={{ padding: '3.5rem', textAlign: 'center', color: 'var(--text-muted)' }}>
          <RefreshCw size={36} className="animate-spin" style={{ animation: 'spin 1s linear infinite', margin: '0 auto 1rem', color: '#10b981' }} />
          <div>Firestore থেকে ল্যাঙ্গুয়েজ কোর্স তালিকা লোড হচ্ছে...</div>
        </div>
      ) : filteredCourses.length === 0 ? (
        <div className="glass-panel" style={{ padding: '3.5rem 2rem', textAlign: 'center' }}>
          <GraduationCap size={48} color="#10b981" style={{ opacity: 0.5, margin: '0 auto 1rem' }} />
          <h3 style={{ fontSize: '1.25rem', marginBottom: '0.5rem' }}>কোনো কোর্স পাওয়া যায়নি</h3>
          <p style={{ color: 'var(--text-muted)', fontSize: '0.88rem', maxWidth: 440, margin: '0 auto' }}>
            {searchQuery 
              ? 'সার্চের সাথে মিলে এমন কোনো কোর্স পাওয়া যায়নি। সার্চ কিওয়ার্ড পরিবর্তন করুন।' 
              : 'ফায়ারবেসের `courses` কালেকশন লোড করুন অথবা seed_firestore.js দিয়ে কোর্স যোগ করুন।'}
          </p>
        </div>
      ) : (
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(360px, 1fr))', gap: '1.5rem' }}>
          {filteredCourses.map((course) => {
            const isExpanded = expandedCourseId === course.id;
            const isJapanese = course.language?.toLowerCase() === 'japanese';

            return (
              <div
                key={course.id}
                className="glass-panel glass-panel-hover"
                style={{
                  padding: '1.5rem',
                  display: 'flex',
                  flexDirection: 'column',
                  justifyContent: 'space-between',
                  gap: '1rem',
                  border: isJapanese ? '1px solid rgba(239, 68, 68, 0.25)' : '1px solid rgba(59, 130, 246, 0.25)'
                }}
              >
                <div>
                  {/* Thumbnail / Header */}
                  {course.thumbnailUrl && (
                    <div style={{ width: '100%', height: 160, borderRadius: 8, overflow: 'hidden', marginBottom: '1rem', position: 'relative' }}>
                      <img
                        src={course.thumbnailUrl}
                        alt={course.title}
                        style={{ width: '100%', height: '100%', objectFit: 'cover' }}
                      />
                      <span style={{
                        position: 'absolute',
                        top: 10,
                        right: 10,
                        padding: '3px 10px',
                        borderRadius: 9999,
                        fontSize: '0.75rem',
                        fontWeight: 700,
                        background: isJapanese ? 'rgba(220, 38, 38, 0.85)' : 'rgba(37, 99, 235, 0.85)',
                        color: '#ffffff',
                        backdropFilter: 'blur(8px)'
                      }}>
                        {isJapanese ? '🇯🇵 Japanese' : '🇬🇧 English'}
                      </span>
                    </div>
                  )}

                  {/* Level & Instructor */}
                  <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '0.4rem' }}>
                    <span className="badge badge-indigo" style={{ fontSize: '0.72rem' }}>
                      {course.level || 'Beginner to Advanced'}
                    </span>
                    {course.instructor && (
                      <span style={{ fontSize: '0.75rem', color: '#94a3b8' }}>
                        শিক্ষক: <strong>{course.instructor}</strong>
                      </span>
                    )}
                  </div>

                  {/* Title & Subtitle */}
                  <h3 style={{ fontSize: '1.2rem', color: '#f8fafc', lineHeight: 1.3, marginBottom: '0.35rem' }}>
                    {course.title}
                  </h3>

                  {course.subtitle && (
                    <p style={{ fontSize: '0.82rem', color: '#a5b4fc', marginBottom: '0.65rem', fontStyle: 'italic' }}>
                      {course.subtitle}
                    </p>
                  )}

                  {course.description && (
                    <p style={{ fontSize: '0.78rem', color: '#94a3b8', lineHeight: 1.5, marginBottom: '0.75rem' }}>
                      {course.description.slice(0, 160)}...
                    </p>
                  )}

                  {/* Stats Bar */}
                  <div style={{
                    display: 'flex',
                    alignItems: 'center',
                    justifyContent: 'space-between',
                    padding: '0.6rem 0',
                    borderTop: '1px solid var(--border-subtle)',
                    borderBottom: '1px solid var(--border-subtle)',
                    fontSize: '0.75rem',
                    color: 'var(--text-muted)'
                  }}>
                    <span style={{ display: 'flex', alignItems: 'center', gap: '0.25rem' }}>
                      <Clock size={13} color="#818cf8" />
                      {course.totalHours ? `${course.totalHours} hrs` : `${course.lessonCount || 0} Lessons`}
                    </span>
                    <span style={{ display: 'flex', alignItems: 'center', gap: '0.25rem' }}>
                      <Star size={13} color="#fbbf24" fill="#fbbf24" />
                      {course.rating || '4.9'}
                    </span>
                    <span style={{ display: 'flex', alignItems: 'center', gap: '0.25rem' }}>
                      <Users size={13} color="#34d399" />
                      {course.enrolledCount ? `${course.enrolledCount.toLocaleString()} enrolled` : 'Active'}
                    </span>
                  </div>

                  {/* Tags */}
                  {course.tags && course.tags.length > 0 && (
                    <div style={{ display: 'flex', flexWrap: 'wrap', gap: '0.35rem', marginTop: '0.75rem' }}>
                      {course.tags.map((t, idx) => (
                        <span
                          key={idx}
                          style={{
                            fontSize: '0.7rem',
                            padding: '2px 8px',
                            borderRadius: 6,
                            background: 'rgba(255, 255, 255, 0.04)',
                            color: '#94a3b8',
                            border: '1px solid rgba(255, 255, 255, 0.06)'
                          }}
                        >
                          #{t}
                        </span>
                      ))}
                    </div>
                  )}

                  {/* Modules & Lessons Drawer */}
                  {course.modules && course.modules.length > 0 && (
                    <div style={{ marginTop: '0.85rem' }}>
                      <button
                        onClick={() => toggleExpand(course.id)}
                        className="btn-secondary"
                        style={{
                          width: '100%',
                          justifyContent: 'space-between',
                          padding: '0.45rem 0.75rem',
                          fontSize: '0.78rem'
                        }}
                      >
                        <span>
                          পাঠ্যক্রম দেখুন ({course.modules.length} টি মডিউল)
                        </span>
                        {isExpanded ? <ChevronUp size={14} /> : <ChevronDown size={14} />}
                      </button>

                      {isExpanded && (
                        <div style={{
                          marginTop: '0.65rem',
                          display: 'flex',
                          flexDirection: 'column',
                          gap: '0.5rem',
                          background: 'rgba(0, 0, 0, 0.2)',
                          padding: '0.75rem',
                          borderRadius: 8,
                          border: '1px solid var(--border-subtle)',
                          maxHeight: 280,
                          overflowY: 'auto'
                        }}>
                          {course.modules.map((mod, mIdx) => (
                            <div key={mIdx}>
                              <div style={{ fontSize: '0.78rem', fontWeight: 700, color: '#f8fafc', marginBottom: '0.35rem' }}>
                                {mod.moduleTitle}
                              </div>
                              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.3rem', paddingLeft: '0.5rem' }}>
                                {mod.lessons?.map((les, lIdx) => (
                                  <div
                                    key={lIdx}
                                    style={{
                                      display: 'flex',
                                      alignItems: 'center',
                                      justifyContent: 'space-between',
                                      fontSize: '0.74rem',
                                      color: '#cbd5e1',
                                      padding: '0.25rem 0',
                                      borderBottom: '1px dashed rgba(255,255,255,0.06)'
                                    }}
                                  >
                                    <div style={{ display: 'flex', alignItems: 'center', gap: '0.4rem', flex: 1, minWidth: 0 }}>
                                      <PlayCircle size={12} color="#10b981" />
                                      <span style={{ textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap' }}>
                                        {les.title}
                                      </span>
                                    </div>
                                    <div style={{ display: 'flex', alignItems: 'center', gap: '0.4rem', flexShrink: 0 }}>
                                      {les.duration && (
                                        <span style={{ color: '#64748b', fontSize: '0.7rem' }}>
                                          {les.duration}
                                        </span>
                                      )}
                                      {les.audioUrl && (
                                        <a
                                          href={les.audioUrl}
                                          target="_blank"
                                          rel="noopener noreferrer"
                                          style={{ color: '#38bdf8' }}
                                          title="Play Audio Lesson"
                                        >
                                          <PlayCircle size={13} />
                                        </a>
                                      )}
                                      {les.pdfUrl && (
                                        <a
                                          href={les.pdfUrl}
                                          target="_blank"
                                          rel="noopener noreferrer"
                                          style={{ color: '#f87171' }}
                                          title="Open PDF Lesson Notes"
                                        >
                                          <FileText size={13} />
                                        </a>
                                      )}
                                    </div>
                                  </div>
                                ))}
                              </div>
                            </div>
                          ))}
                        </div>
                      )}
                    </div>
                  )}
                </div>
              </div>
            );
          })}
        </div>
      )}
    </div>
  );
}
