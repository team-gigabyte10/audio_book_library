import React from 'react';
import { BookOpen, UploadCloud, Library, Radio } from 'lucide-react';
import { firebaseConfig } from '../firebase/config';

export default function Navbar({ activeTab, setActiveTab, bookCount, onOpenRules }) {
  return (
    <header style={{
      position: 'sticky',
      top: 0,
      zIndex: 50,
      backdropFilter: 'blur(20px)',
      WebkitBackdropFilter: 'blur(20px)',
      background: 'rgba(9, 13, 22, 0.85)',
      borderBottom: '1px solid rgba(255, 255, 255, 0.08)',
      padding: '0.85rem 2rem'
    }}>
      <div style={{
        maxWidth: 1280,
        margin: '0 auto',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'space-between',
        flexWrap: 'wrap',
        gap: '1rem'
      }}>
        {/* Brand */}
        <div style={{ display: 'flex', alignItems: 'center', gap: '0.75rem' }}>
          <div style={{
            width: 42,
            height: 42,
            borderRadius: 12,
            background: 'linear-gradient(135deg, #6366f1, #a855f7)',
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            boxShadow: '0 0 20px rgba(99, 102, 241, 0.4)'
          }}>
            <BookOpen size={22} color="#ffffff" />
          </div>
          <div>
            <div style={{
              fontSize: '1.25rem',
              fontWeight: 800,
              letterSpacing: '-0.02em',
              background: 'linear-gradient(to right, #ffffff, #c7d2fe)',
              WebkitBackgroundClip: 'text',
              WebkitTextFillColor: 'transparent'
            }}>
              AudioBook Studio
            </div>
            <div style={{ fontSize: '0.75rem', color: '#64748b' }}>
              Firebase Markdown Publishing Portal
            </div>
          </div>
        </div>

        {/* Navigation Tabs */}
        <div style={{
          display: 'flex',
          background: 'rgba(255, 255, 255, 0.04)',
          padding: '4px',
          borderRadius: '12px',
          border: '1px solid rgba(255, 255, 255, 0.06)'
        }}>
          <button
            onClick={() => setActiveTab('upload')}
            style={{
              display: 'flex',
              alignItems: 'center',
              gap: '0.5rem',
              padding: '0.5rem 1.1rem',
              borderRadius: '8px',
              border: 'none',
              cursor: 'pointer',
              fontWeight: 600,
              fontSize: '0.88rem',
              transition: 'all 0.2s',
              background: activeTab === 'upload' ? 'var(--accent-primary)' : 'transparent',
              color: activeTab === 'upload' ? '#ffffff' : 'var(--text-muted)'
            }}
          >
            <UploadCloud size={16} />
            Upload & Parse
          </button>

          <button
            onClick={() => setActiveTab('library')}
            style={{
              display: 'flex',
              alignItems: 'center',
              gap: '0.5rem',
              padding: '0.5rem 1.1rem',
              borderRadius: '8px',
              border: 'none',
              cursor: 'pointer',
              fontWeight: 600,
              fontSize: '0.88rem',
              transition: 'all 0.2s',
              background: activeTab === 'library' ? 'var(--accent-primary)' : 'transparent',
              color: activeTab === 'library' ? '#ffffff' : 'var(--text-muted)'
            }}
          >
            <Library size={16} />
            Library
            {typeof bookCount === 'number' && (
              <span style={{
                background: activeTab === 'library' ? 'rgba(255,255,255,0.25)' : 'rgba(255,255,255,0.1)',
                padding: '1px 7px',
                borderRadius: '9999px',
                fontSize: '0.75rem',
                marginLeft: 4
              }}>
                {bookCount}
              </span>
            )}
          </button>
        </div>

        {/* Firebase Connected Status & Rules Trigger */}
        <div style={{ display: 'flex', alignItems: 'center', gap: '0.75rem' }}>
          <button
            onClick={onOpenRules}
            className="btn-secondary"
            style={{
              padding: '0.35rem 0.75rem',
              fontSize: '0.78rem',
              color: '#f87171',
              borderColor: 'rgba(239, 68, 68, 0.3)'
            }}
            title="Setup Firebase Storage & Firestore Rules"
          >
            Fix Rules / Permissions
          </button>

          <div style={{
            display: 'flex',
            alignItems: 'center',
            gap: '0.6rem',
            background: 'rgba(16, 185, 129, 0.1)',
            border: '1px solid rgba(16, 185, 129, 0.25)',
            padding: '0.4rem 0.85rem',
            borderRadius: '9999px',
            fontSize: '0.78rem',
            color: '#6ee7b7'
          }}>
            <span style={{
              width: 8,
              height: 8,
              borderRadius: '50%',
              background: '#10b981',
              boxShadow: '0 0 10px #10b981'
            }} />
            <span>Firebase: <strong>{firebaseConfig.projectId}</strong></span>
          </div>
        </div>
      </div>
    </header>
  );
}
