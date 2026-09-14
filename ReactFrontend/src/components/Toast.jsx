import React from 'react';
import { CheckCircle2, AlertCircle, Info, X } from 'lucide-react';

export default function Toast({ toasts, onDismiss }) {
  if (!toasts || toasts.length === 0) return null;

  return (
    <div className="toast-container">
      {toasts.map((toast) => {
        let Icon = CheckCircle2;
        let borderColor = 'rgba(16, 185, 129, 0.4)';
        let iconColor = '#10b981';

        if (toast.type === 'error') {
          Icon = AlertCircle;
          borderColor = 'rgba(239, 68, 68, 0.4)';
          iconColor = '#ef4444';
        } else if (toast.type === 'info') {
          Icon = Info;
          borderColor = 'rgba(99, 102, 241, 0.4)';
          iconColor = '#6366f1';
        }

        return (
          <div
            key={toast.id}
            className="toast"
            style={{ borderColor }}
          >
            <Icon size={20} color={iconColor} style={{ flexShrink: 0 }} />
            <div style={{ flex: 1, fontSize: '0.9rem' }}>
              {toast.title && <div style={{ fontWeight: 600, marginBottom: 2 }}>{toast.title}</div>}
              <div style={{ color: '#cbd5e1' }}>{toast.message}</div>
            </div>
            <button
              onClick={() => onDismiss(toast.id)}
              style={{
                background: 'transparent',
                border: 'none',
                color: '#64748b',
                cursor: 'pointer',
                display: 'flex',
                alignItems: 'center',
                padding: 4
              }}
            >
              <X size={16} />
            </button>
          </div>
        );
      })}
    </div>
  );
}
