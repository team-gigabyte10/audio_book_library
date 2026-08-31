import os
import uuid
import fitz
from fastapi import APIRouter, UploadFile, File, HTTPException, Request, Form
from fastapi.responses import JSONResponse
from app.services.job_manager import job_manager

router = APIRouter()

MAX_UPLOAD_SIZE_MB = int(os.getenv("MAX_UPLOAD_SIZE_MB", "200"))
MAX_BYTES = MAX_UPLOAD_SIZE_MB * 1024 * 1024


@router.post("/api/upload")
async def upload_pdf(file: UploadFile = File(...)):
    """
    Validates uploaded PDF document and initializes processing job.
    """
    # 1. Extension Check
    if not file.filename.lower().endswith(".pdf"):
        raise HTTPException(
            status_code=400,
            detail="Invalid file type. Only PDF documents (.pdf) are allowed."
        )

    # Read header magic bytes (%PDF-)
    content = await file.read()
    file_size = len(content)

    # 2. File Size Check
    if file_size > MAX_BYTES:
        raise HTTPException(
            status_code=400,
            detail=f"File exceeds maximum allowed size of {MAX_UPLOAD_SIZE_MB}MB."
        )

    if file_size < 100:
        raise HTTPException(
            status_code=400,
            detail="The uploaded PDF file is empty or invalid."
        )

    # 3. Magic Bytes Check (%PDF-)
    if not content.startswith(b"%PDF-"):
        raise HTTPException(
            status_code=400,
            detail="File content header does not match valid PDF format."
        )

    # 4. Integrity Check via PyMuPDF
    try:
        doc = fitz.open(stream=content, filetype="pdf")
        if doc.is_encrypted:
            doc.close()
            raise HTTPException(
                status_code=400,
                detail="Password-protected PDF files are not supported. Please remove the password and try again."
            )
        if len(doc) == 0:
            doc.close()
            raise HTTPException(
                status_code=400,
                detail="The uploaded PDF document contains 0 pages."
            )
        doc.close()
    except HTTPException:
        raise
    except Exception as e:
        raise HTTPException(
            status_code=400,
            detail=f"Corrupted or invalid PDF file: {str(e)}"
        )

    # 5. Generate Safe Unique Filename & Save
    job_id = str(uuid.uuid4())
    stored_filename = f"{job_id}.pdf"
    stored_filepath = os.path.join("data", "uploads", stored_filename)

    with open(stored_filepath, "wb") as f:
        f.write(content)

    # 6. Initialize Job
    job_data = job_manager.create_job(
        job_id=job_id,
        original_filename=file.filename,
        stored_filepath=stored_filepath,
        file_size=file_size
    )

    return JSONResponse({
        "success": True,
        "job_id": job_id,
        "filename": file.filename,
        "file_size": file_size,
        "redirect_url": f"/processing/{job_id}"
    })
