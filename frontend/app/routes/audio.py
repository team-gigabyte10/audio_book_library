from fastapi import APIRouter, HTTPException, Query, Response
from typing import Optional
from app.services.job_manager import job_manager
from app.services.tts_service import tts_service

router = APIRouter(prefix="/api/audio", tags=["audio"])


@router.get("/stream")
async def stream_page_audio(
    job_id: str = Query(..., description="Unique Job ID"),
    page: int = Query(1, ge=1, description="Page number"),
    voice: Optional[str] = Query("nabanita", description="Voice ID: nabanita, pradeep, tanishaa, bashkar")
):
    """
    Real-time streaming audio endpoint for instant HTML5 audio playback.
    Fetches clean text for the specified page number, synthesizes Bangla speech,
    and returns an MP3 media stream (audio/mpeg).
    """
    job = job_manager.get_job(job_id)
    if not job:
        raise HTTPException(status_code=404, detail=f"Job '{job_id}' not found.")

    pages = job.get("pages", [])
    target_page = next((p for p in pages if p.get("page_number") == page), None)

    if not target_page:
        raise HTTPException(status_code=404, detail=f"Page {page} not found in job.")

    text_to_speak = target_page.get("cleaned_text") or target_page.get("raw_text") or ""
    if not text_to_speak.strip():
        # Empty page fallback message
        text_to_speak = f"পৃষ্ঠা {page} খালি।"

    mp3_bytes = await tts_service.generate_mp3_bytes(text_to_speak, voice=voice)

    if not mp3_bytes:
        raise HTTPException(status_code=500, detail="Failed to synthesize speech audio.")

    return Response(
        content=mp3_bytes,
        media_type="audio/mpeg",
        headers={
            "Content-Disposition": f'inline; filename="job_{job_id}_page_{page}.mp3"',
            "Cache-Control": "public, max-age=86400",
            "Accept-Ranges": "bytes"
        }
    )
