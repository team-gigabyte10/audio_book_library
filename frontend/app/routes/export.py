import os
from fastapi import APIRouter, HTTPException
from fastapi.responses import FileResponse

from app.services.job_manager import job_manager
from app.services.export_service import ExportService

router = APIRouter()
export_service = ExportService(export_dir=os.path.join("data", "exports"))


@router.get("/export/{job_id}/{fmt}")
async def export_file(job_id: str, fmt: str):
    """
    Triggers export of job data into requested file format (txt, json, docx, csv).
    """
    job = job_manager.get_job(job_id)
    if not job:
        raise HTTPException(status_code=404, detail="Job not found")

    fmt = fmt.lower()

    if fmt == "txt":
        file_path = export_service.export_txt(job)
        media_type = "text/plain"
        filename = f"{job['original_filename']}_extracted.txt"
    elif fmt == "json":
        file_path = export_service.export_json(job)
        media_type = "application/json"
        filename = f"{job['original_filename']}_metadata.json"
    elif fmt == "docx":
        file_path = export_service.export_docx(job)
        media_type = "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
        filename = f"{job['original_filename']}_extracted.docx"
    elif fmt == "csv":
        file_path = export_service.export_csv(job)
        media_type = "text/csv"
        filename = f"{job['original_filename']}_extracted.csv"
    elif fmt == "md":
        file_path = export_service.export_md(job)
        media_type = "text/markdown"
        filename = f"{job['original_filename']}_extracted.md"
    else:
        raise HTTPException(status_code=400, detail=f"Unsupported format '{fmt}'. Supported: txt, md, docx, json, csv")

    return FileResponse(
        path=file_path,
        media_type=media_type,
        filename=filename
    )
