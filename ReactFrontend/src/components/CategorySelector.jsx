import React from 'react';
import { BANGLA_BOOK_CATEGORIES, DEFAULT_CATEGORY } from '../constants/categories';
import { Tag } from 'lucide-react';

export default function CategorySelector({ value, onChange, label = 'Category (ক্যাটাগরি)' }) {
  const selectedValue = value && BANGLA_BOOK_CATEGORIES.includes(value) ? value : DEFAULT_CATEGORY;

  return (
    <div>
      <label className="input-label" style={{ display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
        <Tag size={13} color="#818cf8" />
        <span>{label}</span>
      </label>
      <select
        className="input-field"
        value={selectedValue}
        onChange={(e) => onChange(e.target.value)}
        style={{ cursor: 'pointer' }}
      >
        {BANGLA_BOOK_CATEGORIES.map((cat) => (
          <option key={cat} value={cat}>
            {cat}
          </option>
        ))}
      </select>
    </div>
  );
}
