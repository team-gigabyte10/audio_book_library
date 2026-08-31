document.addEventListener('DOMContentLoaded', () => {
    if (typeof JOB_ID === 'undefined') return;

    const statusBadge = document.getElementById('status-badge');
    const totalPagesVal = document.getElementById('total-pages-val');
    const textPagesVal = document.getElementById('text-pages-val');
    const scannedPagesVal = document.getElementById('scanned-pages-val');
    const mixedPagesVal = document.getElementById('mixed-pages-val');
    const pageCounterText = document.getElementById('page-counter-text');
    const progressPercentText = document.getElementById('progress-percent-text');
    const processingProgressFill = document.getElementById('processing-progress-fill');
    const currentOperationText = document.getElementById('current-operation-text');
    const etaText = document.getElementById('eta-text');
    const errorContainer = document.getElementById('error-container');
    const errorMessageText = document.getElementById('error-message-text');
    const cancelBtn = document.getElementById('cancel-btn');
    const viewResultBtn = document.getElementById('view-result-btn');

    let pollInterval = null;

    // Trigger processing start request
    fetch(`/api/jobs/${JOB_ID}/start`, { method: 'POST' })
        .then(res => res.json())
        .then(() => startPolling())
        .catch(() => startPolling());

    function startPolling() {
        pollStatus();
        pollInterval = setInterval(pollStatus, 1500);
    }

    async function pollStatus() {
        try {
            const res = await fetch(`/api/jobs/${JOB_ID}/status`);
            if (!res.ok) return;

            const data = await res.json();
            updateUI(data);

            if (data.status === 'COMPLETED') {
                clearInterval(pollInterval);
                setTimeout(() => {
                    window.location.href = `/results/${JOB_ID}`;
                }, 800);
            } else if (data.status === 'FAILED' || data.status === 'CANCELLED') {
                clearInterval(pollInterval);
            }
        } catch (e) {
            console.error("Polling error:", e);
        }
    }

    function updateUI(data) {
        // Status Badge
        statusBadge.textContent = data.status;
        statusBadge.className = `status-badge status-${data.status.toLowerCase()}`;

        // Page Counts
        totalPagesVal.textContent = data.total_pages || '—';
        textPagesVal.textContent = data.text_pages || 0;
        scannedPagesVal.textContent = data.scanned_pages || 0;
        mixedPagesVal.textContent = data.mixed_pages || 0;

        // Progress Fill & Percent
        const percent = data.progress_percent || 0;
        processingProgressFill.style.width = percent + '%';
        progressPercentText.textContent = percent.toFixed(1) + '%';
        pageCounterText.textContent = `Processing Page ${data.processed_pages} / ${data.total_pages || '?'}`;

        // Operation text
        currentOperationText.textContent = data.current_operation || 'Processing...';

        // ETA
        if (data.estimated_remaining_seconds !== null && data.estimated_remaining_seconds > 0) {
            const mins = Math.floor(data.estimated_remaining_seconds / 60);
            const secs = Math.floor(data.estimated_remaining_seconds % 60);
            etaText.textContent = `${mins} মি ${secs} সে`;
        } else if (data.status === 'COMPLETED') {
            etaText.textContent = 'সম্পন্ন (Completed)';
        } else {
            etaText.textContent = 'হিসাব করা হচ্ছে...';
        }

        // View result button visibility
        if (data.status === 'COMPLETED') {
            cancelBtn.classList.add('hidden');
            viewResultBtn.classList.remove('hidden');
        }

        // Error display
        if (data.status === 'FAILED') {
            errorContainer.classList.remove('hidden');
            errorMessageText.textContent = data.error_message || 'An unexpected error occurred during processing.';
            cancelBtn.classList.add('hidden');
        }
    }

    window.cancelProcessing = function(jobId) {
        if (!confirm('আপনি কি নিশ্চিত যে প্রসেসিং বাতিল করতে চান? (Are you sure you want to cancel?)')) return;

        fetch(`/api/jobs/${jobId}/cancel`, { method: 'POST' })
            .then(res => res.json())
            .then(() => pollStatus());
    };
});
