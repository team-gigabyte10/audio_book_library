document.addEventListener('DOMContentLoaded', () => {
    const dropzone = document.getElementById('dropzone');
    const fileInput = document.getElementById('file-input');
    const browseBtn = document.getElementById('browse-btn');
    const filePreview = document.getElementById('file-preview');
    const previewFilename = document.getElementById('preview-filename');
    const previewFilesize = document.getElementById('preview-filesize');
    const removeFileBtn = document.getElementById('remove-file-btn');
    const startUploadBtn = document.getElementById('start-upload-btn');
    const uploadProgressContainer = document.getElementById('upload-progress-container');
    const uploadProgressFill = document.getElementById('upload-progress-fill');
    const uploadProgressText = document.getElementById('upload-progress-text');
    const uploadError = document.getElementById('upload-error');

    let selectedFile = null;

    if (!dropzone) return;

    // Trigger File Dialog
    if (browseBtn) {
        browseBtn.addEventListener('click', (e) => {
            e.stopPropagation();
            fileInput.click();
        });
    }

    dropzone.addEventListener('click', (e) => {
        if (e.target !== browseBtn && !browseBtn.contains(e.target)) {
            fileInput.click();
        }
    });

    // Drag and Drop Events
    ['dragenter', 'dragover', 'dragleave', 'drop'].forEach(eventName => {
        dropzone.addEventListener(eventName, preventDefaults, false);
    });

    function preventDefaults(e) {
        e.preventDefault();
        e.stopPropagation();
    }

    ['dragenter', 'dragover'].forEach(eventName => {
        dropzone.addEventListener(eventName, () => dropzone.classList.add('dragover'), false);
    });

    ['dragleave', 'drop'].forEach(eventName => {
        dropzone.addEventListener(eventName, () => dropzone.classList.remove('dragover'), false);
    });

    dropzone.addEventListener('drop', (e) => {
        const dt = e.dataTransfer;
        const files = dt.files;
        if (files && files.length > 0) {
            handleFileSelect(files[0]);
        }
    });

    fileInput.addEventListener('change', (e) => {
        if (e.target.files && e.target.files.length > 0) {
            handleFileSelect(e.target.files[0]);
        }
    });

    function handleFileSelect(file) {
        uploadError.classList.add('hidden');
        
        // Correct JavaScript method: .endsWith('.pdf')
        if (!file.name.toLowerCase().endsWith('.pdf')) {
            showError('শুধুমাত্র PDF ফাইল (.pdf) আপলোড করা সম্ভব। (PDF files only)');
            return;
        }

        const sizeMB = file.size / (1024 * 1024);
        if (sizeMB > 200) {
            showError(`ফাইল সাইজ ২০০ MB এর চেয়ে বেশি (${sizeMB.toFixed(1)} MB)। অনুগ্রহ করে ছোট PDF দিন।`);
            return;
        }

        selectedFile = file;
        previewFilename.textContent = file.name;
        previewFilesize.textContent = `${sizeMB.toFixed(2)} MB`;

        dropzone.classList.add('hidden');
        filePreview.classList.remove('hidden');
    }

    removeFileBtn.addEventListener('click', () => {
        selectedFile = null;
        fileInput.value = '';
        filePreview.classList.add('hidden');
        dropzone.classList.remove('hidden');
        uploadProgressContainer.classList.add('hidden');
        uploadError.classList.add('hidden');
    });

    startUploadBtn.addEventListener('click', async () => {
        if (!selectedFile) return;

        startUploadBtn.disabled = true;
        removeFileBtn.disabled = true;
        uploadProgressContainer.classList.remove('hidden');

        const formData = new FormData();
        formData.append('file', selectedFile);

        const xhr = new XMLHttpRequest();
        xhr.open('POST', '/api/upload', true);

        xhr.upload.onprogress = (e) => {
            if (e.lengthComputable) {
                const percent = Math.round((e.loaded / e.total) * 100);
                uploadProgressFill.style.width = percent + '%';
                uploadProgressText.textContent = percent + '%';
            }
        };

        xhr.onload = () => {
            if (xhr.status === 200) {
                const resp = JSON.parse(xhr.responseText);
                if (resp.success && resp.redirect_url) {
                    window.location.href = resp.redirect_url;
                }
            } else {
                startUploadBtn.disabled = false;
                removeFileBtn.disabled = false;
                let msg = 'Upload failed';
                try {
                    const errResp = JSON.parse(xhr.responseText);
                    msg = errResp.detail || msg;
                } catch (ex) {}
                showError(msg);
            }
        };

        xhr.onerror = () => {
            startUploadBtn.disabled = false;
            removeFileBtn.disabled = false;
            showError('Network error occurred during PDF upload.');
        };

        xhr.send(formData);
    });

    function showError(msg) {
        uploadError.textContent = msg;
        uploadError.classList.remove('hidden');
    }
});
