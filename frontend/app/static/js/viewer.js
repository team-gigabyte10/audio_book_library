let currentPage = 1;
let currentZoom = 1.15;
let isRawMode = false;
let pagesMap = {};

document.addEventListener('DOMContentLoaded', () => {
    if (typeof PAGES_DATA === 'undefined') return;

    // Index pages by page number
    PAGES_DATA.forEach(p => {
        pagesMap[p.page_number] = p;
    });

    renderPage(1);

    // Setup Search Event Handlers
    const searchBtn = document.getElementById('search-btn');
    const searchInput = document.getElementById('search-input');

    if (searchBtn && searchInput) {
        searchBtn.addEventListener('click', performSearch);
        searchInput.addEventListener('keypress', (e) => {
            if (e.key === 'Enter') performSearch();
        });
    }
});

function renderPage(pageNum) {
    if (pageNum < 1 || pageNum > TOTAL_PAGES) return;
    currentPage = parseInt(pageNum);

    const pageData = pagesMap[currentPage] || {
        page_number: currentPage,
        processing_method: 'N/A',
        raw_text: '',
        cleaned_text: 'No text extracted for this page.'
    };

    // Update Dropdown & Label
    const pageSelect = document.getElementById('page-select');
    if (pageSelect) pageSelect.value = currentPage;

    const pageLabel = document.getElementById('current-page-label');
    if (pageLabel) pageLabel.textContent = `Page ${currentPage} of ${TOTAL_PAGES}`;

    // Update Metrics
    const methodTag = document.getElementById('method-tag');
    const charCountTag = document.getElementById('char-count-tag');
    const wordCountTag = document.getElementById('word-count-tag');
    const confTag = document.getElementById('confidence-tag');

    const textToDisplay = isRawMode ? (pageData.raw_text || '') : (pageData.cleaned_text || '');

    if (methodTag) {
        let rawMethod = (pageData.processing_method || 'text_extraction').toLowerCase();
        let isFallback = pageData.fallback_used || rawMethod.includes('fallback');

        if (rawMethod === 'ocr' && !isFallback) {
            methodTag.innerHTML = `<i class="fa-solid fa-eye"></i> Method: <strong>OCR (Bangla)</strong>`;
            methodTag.title = 'Bangla text recognized via Tesseract OCR';
            methodTag.className = 'metric-tag badge-ocr';
        } else if (isFallback) {
            let reasonText = (pageData.fallback_reason === 'ocr_failed') ? 'OCR Error' : 'OCR Unavailable';
            methodTag.innerHTML = `<i class="fa-solid fa-triangle-exclamation"></i> Method: <strong>Text Extraction</strong> <small style="font-weight:normal; opacity:0.85;">(Fallback: ${reasonText})</small>`;
            methodTag.title = 'Fallback to vector text extraction because Tesseract OCR engine was unavailable or failed';
            methodTag.className = 'metric-tag badge-warning';
        } else {
            methodTag.innerHTML = `<i class="fa-solid fa-file-lines"></i> Method: <strong>Text Extraction</strong>`;
            methodTag.title = 'Extracted directly from PDF text layer';
            methodTag.className = 'metric-tag badge-info';
        }
    }
    if (charCountTag) charCountTag.textContent = `Chars: ${pageData.character_count || textToDisplay.length}`;
    if (wordCountTag) wordCountTag.textContent = `Words: ${pageData.word_count || textToDisplay.split(/\s+/).filter(Boolean).length}`;

    if (pageData.confidence_if_available !== null && pageData.confidence_if_available !== undefined) {
        confTag.textContent = `OCR Conf: ${Math.round(pageData.confidence_if_available)}%`;
        confTag.classList.remove('hidden');
    } else {
        confTag.classList.add('hidden');
    }

    // Display Text Content
    const displayBox = document.getElementById('text-display-box');
    if (displayBox) {
        displayBox.style.fontSize = `${currentZoom}rem`;
        displayBox.textContent = textToDisplay || '(ফাঁকা পৃষ্ঠা / Empty Page)';
        displayBox.scrollTop = 0;
        displayBox.classList.remove('hidden');
    }

    // Highlight Active Chapter in Sidebar
    document.querySelectorAll('.chapter-item').forEach(item => {
        const start = parseInt(item.getAttribute('data-start') || '0');
        const end = parseInt(item.getAttribute('data-end') || '0');
        if (currentPage >= start && currentPage <= end) {
            item.classList.add('active');
        } else {
            item.classList.remove('active');
        }
    });

    // Update Prev/Next button states
    const prevBtn = document.getElementById('prev-page-btn');
    const nextBtn = document.getElementById('next-page-btn');
    if (prevBtn) prevBtn.disabled = (currentPage <= 1);
    if (nextBtn) nextBtn.disabled = (currentPage >= TOTAL_PAGES);

    // Hide editor if active
    cancelEditMode();
}

function prevPage() {
    if (currentPage > 1) renderPage(currentPage - 1);
}

function nextPage() {
    if (currentPage < TOTAL_PAGES) renderPage(currentPage + 1);
}

function jumpToPage(pageNum) {
    const pageInt = parseInt(pageNum);
    if (!isNaN(pageInt)) {
        renderPage(pageInt);
    }
}

function toggleRawText(checked) {
    isRawMode = checked;
    renderPage(currentPage);
}

function adjustZoom(delta) {
    if (delta > 0 && currentZoom < 2.0) {
        currentZoom += 0.15;
    } else if (delta < 0 && currentZoom > 0.8) {
        currentZoom -= 0.15;
    }
    const displayBox = document.getElementById('text-display-box');
    displayBox.style.fontSize = `${currentZoom}rem`;
}

function copyCurrentPageText() {
    const pageData = pagesMap[currentPage];
    const text = isRawMode ? (pageData.raw_text || '') : (pageData.cleaned_text || '');
    navigator.clipboard.writeText(text).then(() => {
        alert(`Page ${currentPage} text copied to clipboard!`);
    });
}

function enableEditMode() {
    const pageData = pagesMap[currentPage];
    const text = pageData ? (pageData.cleaned_text || '') : '';

    const textarea = document.getElementById('page-edit-textarea');
    textarea.value = text;

    document.getElementById('text-display-box').classList.add('hidden');
    document.getElementById('text-editor-box').classList.remove('hidden');
}

function cancelEditMode() {
    document.getElementById('text-editor-box').classList.add('hidden');
    document.getElementById('text-display-box').classList.remove('hidden');
}

async function saveEditedText() {
    const textarea = document.getElementById('page-edit-textarea');
    const newText = textarea.value;

    try {
        const res = await fetch(`/api/jobs/${JOB_ID}/pages/${currentPage}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ cleaned_text: newText })
        });

        if (res.ok) {
            if (pagesMap[currentPage]) {
                pagesMap[currentPage].cleaned_text = newText;
                pagesMap[currentPage].character_count = newText.length;
                pagesMap[currentPage].word_count = newText.split(/\s+/).filter(Boolean).length;
            }
            renderPage(currentPage);
            alert(`Page ${currentPage} text saved successfully!`);
        } else {
            alert('Failed to save page edit.');
        }
    } catch (e) {
        alert('Network error while saving edit.');
    }
}

async function performSearch() {
    const searchInput = document.getElementById('search-input');
    const query = searchInput.value.trim();
    const infoBox = document.getElementById('search-results-info');

    if (!query) {
        infoBox.classList.add('hidden');
        return;
    }

    infoBox.innerHTML = '<i class="fa-solid fa-spinner fa-spin"></i> Searching...';
    infoBox.classList.remove('hidden');

    try {
        const res = await fetch(`/api/jobs/${JOB_ID}/search`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ query: query })
        });

        const data = await res.json();

        if (data.matches && data.matches.length > 0) {
            let html = `<strong>${data.total_matches} match(es) found in ${data.matches.length} page(s):</strong><ul style="list-style:none; padding:0; margin-top:8px;">`;
            data.matches.forEach(m => {
                html += `<li style="padding:6px 0; border-bottom:1px solid #e2e8f0; cursor:pointer;" onclick="jumpToPage(${m.page_number})">
                    <strong>Page ${m.page_number} (${m.match_count}x):</strong> <span class="bangla-text" style="font-size:0.85rem; color:#475569;">${m.snippet}</span>
                </li>`;
            });
            html += '</ul>';
            infoBox.innerHTML = html;
        } else {
            infoBox.innerHTML = `<span style="color:#ef4444;">No matches found for "${query}".</span>`;
        }
    } catch (e) {
        infoBox.innerHTML = '<span style="color:#ef4444;">Search request failed.</span>';
    }
}

/* ==========================================================================
   REAL-TIME BANGLA AUDIOBOOK PLAYER ENGINE
   ========================================================================== */
let audioElement = new Audio();
let isPlayingAudio = false;
let audioCurrentPage = null;

// Initialize Audio Event Listeners
audioElement.addEventListener('play', () => {
    isPlayingAudio = true;
    updateAudioUI(true, 'অনলাইনে চালিত হচ্ছে (Playing...)');
});

audioElement.addEventListener('pause', () => {
    isPlayingAudio = false;
    updateAudioUI(false, 'পজ করা হয়েছে (Paused)');
});

audioElement.addEventListener('timeupdate', () => {
    const cur = audioElement.currentTime || 0;
    const dur = audioElement.duration || 0;

    const curLabel = document.getElementById('audio-time-current');
    const durLabel = document.getElementById('audio-time-duration');
    const progressBar = document.getElementById('audio-progress-bar');

    if (curLabel) curLabel.textContent = formatTime(cur);
    if (durLabel && !isNaN(dur) && dur > 0) durLabel.textContent = formatTime(dur);

    if (progressBar && !isNaN(dur) && dur > 0) {
        progressBar.value = Math.round((cur / dur) * 100);
    }
});

audioElement.addEventListener('ended', () => {
    isPlayingAudio = false;
    updateAudioUI(false, 'পৃষ্ঠা শেষ (Finished)');

    const autoAdvance = document.getElementById('auto-advance-audio');
    if (autoAdvance && autoAdvance.checked && currentPage < TOTAL_PAGES) {
        jumpToPage(currentPage + 1);
        setTimeout(() => {
            playAudioForCurrentPage();
        }, 500);
    }
});

audioElement.addEventListener('error', (e) => {
    isPlayingAudio = false;
    updateAudioUI(false, 'অডিও লোড করতে সমস্যা হয়েছে (Audio error)');
});

function formatTime(seconds) {
    const mins = Math.floor(seconds / 60);
    const secs = Math.floor(seconds % 60);
    return `${mins < 10 ? '0' : ''}${mins}:${secs < 10 ? '0' : ''}${secs}`;
}

function updateAudioUI(playing, statusText) {
    const icon = document.getElementById('audio-play-icon');
    const btn = document.getElementById('audio-play-btn');
    const status = document.getElementById('audio-player-status');

    if (icon) icon.className = playing ? 'fa-solid fa-pause' : 'fa-solid fa-play';
    if (btn) btn.style.background = playing ? '#ef4444' : '#3b82f6';
    if (status) status.textContent = statusText || (playing ? 'চালু আছে' : 'পজ');
}

function getSelectedVoice() {
    const select = document.getElementById('voice-select');
    return select ? select.value : 'nabanita';
}

function getSelectedSpeed() {
    const select = document.getElementById('speed-select');
    return select ? parseFloat(select.value) : 1.0;
}

function playAudioForCurrentPage() {
    const voice = getSelectedVoice();
    const speed = getSelectedSpeed();
    const streamUrl = `/api/audio/stream?job_id=${JOB_ID}&page=${currentPage}&voice=${voice}`;

    audioCurrentPage = currentPage;
    updateAudioUI(false, 'অডিও লোড হচ্ছে (Streaming audio...)');

    audioElement.src = streamUrl;
    audioElement.playbackRate = speed;
    audioElement.play().catch(err => {
        updateAudioUI(false, 'প্লে করা সম্ভব হয়নি');
    });
}

function toggleAudioPlay() {
    if (isPlayingAudio && audioCurrentPage === currentPage) {
        audioElement.pause();
    } else if (!isPlayingAudio && audioCurrentPage === currentPage && audioElement.src) {
        audioElement.play();
    } else {
        playAudioForCurrentPage();
    }
}

function onVoiceChanged() {
    if (isPlayingAudio || audioCurrentPage === currentPage) {
        playAudioForCurrentPage();
    }
}

function onSpeedChanged(speedVal) {
    const speed = parseFloat(speedVal);
    audioElement.playbackRate = speed;
}

function onAudioSeek(percent) {
    if (audioElement.duration && !isNaN(audioElement.duration)) {
        const seekTime = (parseFloat(percent) / 100) * audioElement.duration;
        audioElement.currentTime = seekTime;
    }
}
