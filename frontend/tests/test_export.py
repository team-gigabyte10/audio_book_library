import os
import json
import pytest
from app.services.export_service import ExportService


def test_export_txt_json_docx_csv(tmp_path):
    export_dir = str(tmp_path / "exports")
    exporter = ExportService(export_dir=export_dir)

    sample_job = {
        "job_id": "test-job-123",
        "original_filename": "Amar_Bangla_Boi.pdf",
        "total_pages": 2,
        "text_pages": 2,
        "scanned_pages": 0,
        "chapters": [
            {"title": "অধ্যায় ১ — পরিচয়", "start_page": 1, "end_page": 2}
        ],
        "pages": [
            {
                "page_number": 1,
                "processing_method": "text_extraction",
                "page_type": "TEXT",
                "raw_text": "বাংলাদেশ আমার জন্মভূমি।",
                "cleaned_text": "বাংলাদেশ আমার জন্মভূমি।",
                "character_count": 23,
                "word_count": 3,
                "ocr_used": False
            },
            {
                "page_number": 2,
                "processing_method": "text_extraction",
                "page_type": "TEXT",
                "raw_text": "আমি আমার দেশকে ভালোবাসি।",
                "cleaned_text": "আমি আমার দেশকে ভালোবাসি।",
                "character_count": 25,
                "word_count": 4,
                "ocr_used": False
            }
        ]
    }

    txt_file = exporter.export_txt(sample_job)
    assert os.path.exists(txt_file)
    with open(txt_file, "r", encoding="utf-8") as f:
        txt_content = f.read()
        assert "Amar_Bangla_Boi.pdf" in txt_content
        assert "বাংলাদেশ আমার জন্মভূমি।" in txt_content

    json_file = exporter.export_json(sample_job)
    assert os.path.exists(json_file)
    with open(json_file, "r", encoding="utf-8") as f:
        data = json.load(f)
        assert data["job_id"] == "test-job-123"

    docx_file = exporter.export_docx(sample_job)
    assert os.path.exists(docx_file)

    csv_file = exporter.export_csv(sample_job)
    assert os.path.exists(csv_file)

    md_file = exporter.export_md(sample_job)
    assert os.path.exists(md_file)
    with open(md_file, "r", encoding="utf-8") as f:
        md_content = f.read()
        assert "# Amar Bangla Boi" in md_content
        assert "## সূচিপত্র" in md_content
        assert "বাংলাদেশ আমার জন্মভূমি।" in md_content

