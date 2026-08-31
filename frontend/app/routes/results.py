import os
import re
from fastapi import APIRouter, HTTPException, Request
from fastapi.responses import HTMLResponse, JSONResponse
from fastapi.templating import Jinja2Templates

from app.models.schemas import UpdatePageRequest, SearchResponse, SearchMatch
from app.services.job_manager import job_manager

router = APIRouter()
templates = Jinja2Templates(directory=os.path.join("app", "templates"))


@router.get("/results/{job_id}", response_class=HTMLResponse)
async def results_page(request: Request, job_id: str):
    job = job_manager.get_job(job_id)
    if not job:
        raise HTTPException(status_code=404, detail="Job not found")

    return templates.TemplateResponse(
        request=request,
        name="result.html",
        context={
            "job": job,
            "app_name": os.getenv("APP_NAME", "Bangla Book Text Extractor")
        }
    )


@router.get("/api/jobs/{job_id}/pages/{page_num}")
async def get_page_detail(job_id: str, page_num: int):
    job = job_manager.get_job(job_id)
    if not job:
        raise HTTPException(status_code=404, detail="Job not found")

    pages = job.get("pages", [])
    page = next((p for p in pages if p["page_number"] == page_num), None)

    if not page:
        raise HTTPException(status_code=404, detail=f"Page {page_num} not found")

    return JSONResponse(page)


@router.put("/api/jobs/{job_id}/pages/{page_num}")
async def update_page_text(job_id: str, page_num: int, body: UpdatePageRequest):
    success = job_manager.update_page_text(job_id, page_num, body.cleaned_text)
    if not success:
        raise HTTPException(status_code=404, detail=f"Page {page_num} not found or update failed")

    return JSONResponse({"success": True, "page_number": page_num})


@router.post("/api/jobs/{job_id}/search")
async def search_job_text(job_id: str, payload: dict):
    query = payload.get("query", "").strip()
    if not query:
        return JSONResponse({"query": "", "total_matches": 0, "matches": []})

    job = job_manager.get_job(job_id)
    if not job:
        raise HTTPException(status_code=404, detail="Job not found")

    pages = job.get("pages", [])
    matches = []
    total_count = 0

    # Escaped regex query for Bangla search matching
    pattern = re.compile(re.escape(query), re.IGNORECASE)

    for p in sorted(pages, key=lambda x: x["page_number"]):
        text = p.get("cleaned_text") or p.get("raw_text") or ""
        found = pattern.findall(text)
        if found:
            count = len(found)
            total_count += count

            match_obj = pattern.search(text)
            if match_obj:
                start = max(0, match_obj.start() - 40)
                end = min(len(text), match_obj.end() + 40)
                snippet = f"...{text[start:end]}..."
            else:
                snippet = text[:100]

            matches.append({
                "page_number": p["page_number"],
                "match_count": count,
                "snippet": snippet
            })

    return JSONResponse({
        "query": query,
        "total_matches": total_count,
        "matches": matches
    })
