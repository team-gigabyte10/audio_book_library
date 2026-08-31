import os
from fastapi import FastAPI, Request
from fastapi.staticfiles import StaticFiles
from fastapi.templating import Jinja2Templates
from fastapi.responses import HTMLResponse, JSONResponse

from app.routes import upload, processing, results, export, audio
from app.services.job_manager import job_manager
from app.services.ocr_service import OCRService

app = FastAPI(
    title=os.getenv("APP_NAME", "Bangla Book Text Extractor"),
    description="PDF Processing & Bangla Text Extraction Module for Bangla Audiobook Platform",
    version="1.0.0"
)

# Static and Templates
app.mount("/static", StaticFiles(directory=os.path.join("app", "static")), name="static")
templates = Jinja2Templates(directory=os.path.join("app", "templates"))

# Routers
app.include_router(upload.router)
app.include_router(processing.router)
app.include_router(results.router)
app.include_router(export.router)
app.include_router(audio.router)


@app.get("/", response_class=HTMLResponse)
async def dashboard(request: Request):
    """
    Main application dashboard route.
    """
    ocr_service = OCRService()
    ocr_avail, ocr_msg = ocr_service.check_availability()
    recent_jobs = job_manager.list_jobs(limit=10)

    return templates.TemplateResponse(
        request=request,
        name="dashboard.html",
        context={
            "app_name": os.getenv("APP_NAME", "Bangla Book Text Extractor"),
            "max_size_mb": os.getenv("MAX_UPLOAD_SIZE_MB", "200"),
            "ocr_available": ocr_avail,
            "ocr_message": ocr_msg,
            "tesseract_path": ocr_service.resolved_tesseract_path,
            "recent_jobs": recent_jobs
        }
    )


@app.get("/api/ocr/status")
async def get_ocr_status():
    """
    API endpoint returning live OCR engine diagnostic status.
    """
    ocr_service = OCRService()
    ocr_avail, ocr_msg = ocr_service.check_availability()
    return JSONResponse({
        "ocr_available": ocr_avail,
        "message": ocr_msg,
        "tesseract_path": ocr_service.resolved_tesseract_path,
        "language": ocr_service.lang
    })


@app.get("/api/jobs/recent")
async def get_recent_jobs():
    """
    API endpoint returning recent jobs list.
    """
    return JSONResponse(job_manager.list_jobs(limit=10))
