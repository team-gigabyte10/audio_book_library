from fastapi import APIRouter, HTTPException, Request
from fastapi.responses import HTMLResponse, JSONResponse
from fastapi.templating import Jinja2Templates
import os

from app.services.job_manager import job_manager

router = APIRouter()
templates = Jinja2Templates(directory=os.path.join("app", "templates"))


@router.get("/processing/{job_id}", response_class=HTMLResponse)
async def processing_page(request: Request, job_id: str):
    job = job_manager.get_job(job_id)
    if not job:
        raise HTTPException(status_code=404, detail="Job not found")

    return templates.TemplateResponse(
        request=request,
        name="processing.html",
        context={
            "job": job,
            "app_name": os.getenv("APP_NAME", "Bangla Book Text Extractor")
        }
    )


@router.post("/api/jobs/{job_id}/start")
async def start_job(job_id: str):
    job = job_manager.get_job(job_id)
    if not job:
        raise HTTPException(status_code=404, detail="Job not found")

    if job.get("status") in ["UPLOADED"]:
        job_manager.start_processing(job_id)

    return JSONResponse({"success": True, "job_id": job_id})


@router.get("/api/jobs/{job_id}/status")
async def get_job_status(job_id: str):
    job = job_manager.get_job(job_id)
    if not job:
        raise HTTPException(status_code=404, detail="Job not found")

    return JSONResponse({
        "job_id": job["job_id"],
        "filename": job["original_filename"],
        "status": job["status"],
        "progress_percent": job["progress_percent"],
        "processed_pages": job["processed_pages"],
        "total_pages": job["total_pages"],
        "text_pages": job["text_pages"],
        "scanned_pages": job["scanned_pages"],
        "mixed_pages": job["mixed_pages"],
        "current_operation": job["current_operation"],
        "estimated_remaining_seconds": job["estimated_remaining_seconds"],
        "error_message": job.get("error_message"),
        "ocr_available": job.get("ocr_available", True),
        "ocr_message": job.get("ocr_message")
    })


@router.post("/api/jobs/{job_id}/cancel")
async def cancel_job(job_id: str):
    success = job_manager.cancel_job(job_id)
    if not success:
        raise HTTPException(status_code=404, detail="Job not found")

    return JSONResponse({"success": True, "message": "Job cancellation requested"})
