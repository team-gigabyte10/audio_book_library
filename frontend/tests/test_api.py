import os
import fitz
from fastapi.testclient import TestClient
from app.main import app

client = TestClient(app)


def create_dummy_pdf_bytes():
    doc = fitz.open()
    page = doc.new_page()
    page.insert_text(fitz.Point(50, 100), "Chapter 1 - Test Document", fontsize=14)
    page.insert_text(fitz.Point(50, 150), "Bangla text extraction system testing.", fontsize=12)
    pdf_bytes = doc.tobytes()
    doc.close()
    return pdf_bytes


def test_dashboard_route():
    response = client.get("/")
    assert response.status_code == 200
    assert "Bangla Book Text Extractor" in response.text


def test_upload_invalid_file():
    response = client.post(
        "/api/upload",
        files={"file": ("test.txt", b"Hello world", "text/plain")}
    )
    assert response.status_code == 400
    assert "Invalid file type" in response.json()["detail"]


def test_full_upload_and_processing_flow():
    pdf_bytes = create_dummy_pdf_bytes()
    
    # 1. Upload PDF
    upload_res = client.post(
        "/api/upload",
        files={"file": ("Bangla_Book_Test.pdf", pdf_bytes, "application/pdf")}
    )
    assert upload_res.status_code == 200
    job_id = upload_res.json()["job_id"]
    assert job_id is not None

    # 2. Check initial job status
    status_res = client.get(f"/api/jobs/{job_id}/status")
    assert status_res.status_code == 200
    assert status_res.json()["status"] == "UPLOADED"

    # 3. Start processing
    start_res = client.post(f"/api/jobs/{job_id}/start")
    assert start_res.status_code == 200

    # 4. Access processing page
    proc_page_res = client.get(f"/processing/{job_id}")
    assert proc_page_res.status_code == 200

    # 5. Access results page
    results_page_res = client.get(f"/results/{job_id}")
    assert results_page_res.status_code == 200

    # 6. Test Export
    export_res = client.get(f"/export/{job_id}/txt")
    assert export_res.status_code == 200
    assert "Bangla_Book_Test.pdf" in export_res.text
