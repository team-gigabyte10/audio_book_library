import React, { useState } from 'react';
import { ShieldAlert, Copy, Check, ExternalLink, X, Database, HardDrive, AlertTriangle } from 'lucide-react';
import { firebaseConfig } from '../firebase/config';

export default function RulesModal({ isOpen, onClose }) {
  const [copiedStorage, setCopiedStorage] = useState(false);
  const [copiedFirestore, setCopiedFirestore] = useState(false);

  if (!isOpen) return null;

  const firestoreRules = `rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /{document=**} {
      allow read, write: if true;
    }
  }
}`;

  const storageRules = `rules_version = '2';
service firebase.storage {
  match /b/{bucket}/o {
    match /{allPaths=**} {
      allow read, write: if true;
    }
  }
}`;

  const copyToClipboard = (text, type) => {
    navigator.clipboard.writeText(text);
    if (type === 'storage') {
      setCopiedStorage(true);
      setTimeout(() => setCopiedStorage(false), 2000);
    } else {
      setCopiedFirestore(true);
      setTimeout(() => setCopiedFirestore(false), 2000);
    }
  };

  const firestoreConsoleUrl = `https://console.firebase.google.com/project/${firebaseConfig.projectId}/firestore/rules`;
  const storageConsoleUrl = `https://console.firebase.google.com/project/${firebaseConfig.projectId}/storage/rules`;

  return (
    <div style={{
      position: 'fixed',
      top: 0,
      left: 0,
      right: 0,
      bottom: 0,
      background: 'rgba(0, 0, 0, 0.75)',
      backdropFilter: 'blur(8px)',
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center',
      zIndex: 9999,
      padding: '1.5rem'
    }}>
      <div className="glass-panel" style={{
        maxWidth: 720,
        width: '100%',
        maxHeight: '90vh',
        overflowY: 'auto',
        padding: '2rem',
        border: '1px solid rgba(239, 68, 68, 0.4)',
        boxShadow: '0 20px 50px rgba(0, 0, 0, 0.8)'
      }}>
        {/* Header */}
        <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: '1.25rem' }}>
          <div style={{ display: 'flex', alignItems: 'center', gap: '0.75rem' }}>
            <div style={{
              width: 42,
              height: 42,
              borderRadius: 10,
              background: 'rgba(239, 68, 68, 0.2)',
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'center'
            }}>
              <ShieldAlert size={24} color="#ef4444" />
            </div>
            <div>
              <h3 style={{ fontSize: '1.3rem', color: '#f8fafc' }}>Fix Firebase Permissions</h3>
              <p style={{ fontSize: '0.82rem', color: 'var(--text-muted)' }}>
                Resolve <strong>"Missing or insufficient permissions"</strong> in project <strong>{firebaseConfig.projectId}</strong>
              </p>
            </div>
          </div>

          <button
            onClick={onClose}
            style={{
              background: 'transparent',
              border: 'none',
              color: '#94a3b8',
              cursor: 'pointer',
              padding: 4
            }}
          >
            <X size={20} />
          </button>
        </div>

        {/* Notice explanation */}
        <div style={{
          background: 'rgba(239, 68, 68, 0.12)',
          border: '1px solid rgba(239, 68, 68, 0.3)',
          borderRadius: 10,
          padding: '0.85rem 1rem',
          fontSize: '0.85rem',
          color: '#fca5a5',
          marginBottom: '1.25rem',
          display: 'flex',
          gap: '0.6rem'
        }}>
          <AlertTriangle size={18} style={{ flexShrink: 0, marginTop: 2 }} />
          <div>
            <strong>Why this happens:</strong> Newly initialized Cloud Firestore and Storage buckets start in "Production/Locked mode" (<code>allow read, write: if false;</code>). You need to publish the rules below to allow uploads.
          </div>
        </div>

        {/* Step 1: Cloud Firestore Database Rules (Most urgent for "Missing or insufficient permissions") */}
        <div style={{ background: 'rgba(15, 23, 42, 0.8)', padding: '1.25rem', borderRadius: 12, border: '1px solid rgba(16, 185, 129, 0.3)', marginBottom: '1.25rem' }}>
          <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '0.75rem', flexWrap: 'wrap', gap: '0.5rem' }}>
            <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem', fontWeight: 700, color: '#6ee7b7' }}>
              <Database size={17} /> 1. Cloud Firestore Rules (Fixes "Missing or insufficient permissions")
            </div>
            <div style={{ display: 'flex', gap: '0.5rem' }}>
              <button
                onClick={() => copyToClipboard(firestoreRules, 'firestore')}
                className="btn-secondary"
                style={{ padding: '0.35rem 0.65rem', fontSize: '0.78rem' }}
              >
                {copiedFirestore ? <Check size={14} color="#10b981" /> : <Copy size={14} />}
                {copiedFirestore ? 'Copied' : 'Copy Firestore Rule'}
              </button>
              <a
                href={firestoreConsoleUrl}
                target="_blank"
                rel="noopener noreferrer"
                className="btn-primary"
                style={{ padding: '0.35rem 0.75rem', fontSize: '0.78rem', textDecoration: 'none' }}
              >
                Open Firestore Rules <ExternalLink size={13} />
              </a>
            </div>
          </div>

          <pre style={{
            background: 'rgba(9, 13, 22, 0.95)',
            padding: '0.75rem 1rem',
            borderRadius: 8,
            fontSize: '0.82rem',
            color: '#cbd5e1',
            overflowX: 'auto',
            fontFamily: 'Consolas, monospace',
            border: '1px solid rgba(255,255,255,0.06)'
          }}>
            <code>{firestoreRules}</code>
          </pre>
          <div style={{ fontSize: '0.78rem', color: '#94a3b8', marginTop: '0.5rem' }}>
            Click <strong>Open Firestore Rules</strong> &gt; Paste above &gt; Click <strong>Publish</strong>.
          </div>
        </div>

        {/* Step 2: Storage Rules */}
        <div style={{ background: 'rgba(15, 23, 42, 0.8)', padding: '1.25rem', borderRadius: 12, border: '1px solid rgba(99, 102, 241, 0.3)', marginBottom: '1.5rem' }}>
          <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '0.75rem', flexWrap: 'wrap', gap: '0.5rem' }}>
            <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem', fontWeight: 700, color: '#a5b4fc' }}>
              <HardDrive size={17} /> 2. Firebase Storage Rules (Fixes storage/unauthorized)
            </div>
            <div style={{ display: 'flex', gap: '0.5rem' }}>
              <button
                onClick={() => copyToClipboard(storageRules, 'storage')}
                className="btn-secondary"
                style={{ padding: '0.35rem 0.65rem', fontSize: '0.78rem' }}
              >
                {copiedStorage ? <Check size={14} color="#10b981" /> : <Copy size={14} />}
                {copiedStorage ? 'Copied' : 'Copy Storage Rule'}
              </button>
              <a
                href={storageConsoleUrl}
                target="_blank"
                rel="noopener noreferrer"
                className="btn-primary"
                style={{ padding: '0.35rem 0.75rem', fontSize: '0.78rem', textDecoration: 'none' }}
              >
                Open Storage Rules <ExternalLink size={13} />
              </a>
            </div>
          </div>

          <pre style={{
            background: 'rgba(9, 13, 22, 0.95)',
            padding: '0.75rem 1rem',
            borderRadius: 8,
            fontSize: '0.82rem',
            color: '#cbd5e1',
            overflowX: 'auto',
            fontFamily: 'Consolas, monospace',
            border: '1px solid rgba(255,255,255,0.06)'
          }}>
            <code>{storageRules}</code>
          </pre>
        </div>

        {/* Bottom Actions */}
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', flexWrap: 'wrap', gap: '1rem' }}>
          <div style={{ fontSize: '0.8rem', color: '#94a3b8' }}>
            Once published in Firebase Console, uploads will succeed immediately.
          </div>
          <button
            onClick={onClose}
            className="btn-primary"
            style={{ padding: '0.65rem 1.25rem' }}
          >
            I've Published Rules / Done
          </button>
        </div>
      </div>
    </div>
  );
}
