import pytest
from fastapi.testclient import TestClient
from app.main import app
from app.services.tts_service import TTSService, tts_service
from app.services.job_manager import job_manager

client = TestClient(app)


def test_tts_voice_resolution():
    assert tts_service.resolve_voice("nabanita") == "bn-BD-NabanitaNeural"
    assert tts_service.resolve_voice("pradeep") == "bn-BD-PradeepNeural"
    assert tts_service.resolve_voice("tanishaa") == "bn-IN-TanishaaNeural"
    assert tts_service.resolve_voice("bashkar") == "bn-IN-BashkarNeural"
    assert tts_service.resolve_voice("unknown_voice") == "bn-BD-NabanitaNeural"


def test_generate_mp3_bytes_fallback():
    import asyncio
    text = "বাংলাদেশ একটি সুন্দর দেশ।"
    mp3_bytes = asyncio.run(tts_service.generate_mp3_bytes(text, voice="nabanita"))
    assert isinstance(mp3_bytes, bytes)
    assert len(mp3_bytes) > 0


def test_audio_stream_api_endpoint(tmp_path):
    # Create test dummy job
    job = job_manager.create_job("tts_test_job_1", "sample.pdf", "sample.pdf", 1000)
    job["pages"] = [
        {
            "page_number": 1,
            "processing_method": "text_extraction",
            "cleaned_text": "ধনী বাবা গরীব বাবা বইয়ের বাংলা সারসংক্ষেপ।"
        }
    ]

    response = client.get("/api/audio/stream?job_id=tts_test_job_1&page=1&voice=nabanita")
    assert response.status_code == 200
    assert response.headers["content-type"] == "audio/mpeg"
    assert len(response.content) > 100
