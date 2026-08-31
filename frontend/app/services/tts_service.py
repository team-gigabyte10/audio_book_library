import os
import hashlib
import io
import asyncio
from typing import Optional, AsyncGenerator
import edge_tts
from gtts import gTTS


class TTSService:
    """
    High-performance Text-to-Speech (TTS) service for real-time Bangla audiobook audio synthesis.
    Uses Microsoft Edge Neural voices (bn-BD-NabanitaNeural, bn-BD-PradeepNeural, etc.) with gTTS fallback.
    Implements audio caching for instant zero-latency re-play.
    """

    VOICES = {
        "nabanita": "bn-BD-NabanitaNeural",   # Female Bangla (Bangladesh)
        "pradeep": "bn-BD-PradeepNeural",     # Male Bangla (Bangladesh)
        "tanishaa": "bn-IN-TanishaaNeural",   # Female Bangla (India)
        "bashkar": "bn-IN-BashkarNeural"      # Male Bangla (India)
    }

    DEFAULT_VOICE = "bn-BD-NabanitaNeural"

    def __init__(self, cache_dir: str = "data/cache/audio"):
        self.cache_dir = cache_dir
        os.makedirs(self.cache_dir, exist_ok=True)

    def _get_cache_key(self, text: str, voice: str) -> str:
        content = f"{voice}:{text.strip()}"
        return hashlib.md5(content.encode("utf-8")).hexdigest()

    def get_cached_audio_path(self, text: str, voice: str) -> Optional[str]:
        cache_key = self._get_cache_key(text, voice)
        cache_path = os.path.join(self.cache_dir, f"{cache_key}.mp3")
        if os.path.exists(cache_path) and os.path.getsize(cache_path) > 0:
            return cache_path
        return None

    def resolve_voice(self, voice_input: str) -> str:
        if not voice_input:
            return self.DEFAULT_VOICE
        voice_clean = voice_input.lower().strip()
        if voice_clean in self.VOICES:
            return self.VOICES[voice_clean]
        if "nabanita" in voice_clean or "female" in voice_clean:
            return self.VOICES["nabanita"]
        if "pradeep" in voice_clean or "male" in voice_clean:
            return self.VOICES["pradeep"]
        return voice_input if voice_input in self.VOICES.values() else self.DEFAULT_VOICE

    async def generate_mp3_bytes(self, text: str, voice: str = "bn-BD-NabanitaNeural") -> bytes:
        """
        Synthesizes MP3 audio bytes for given text using edge-tts with gTTS fallback.
        Checks disk cache first.
        """
        if not text or not text.strip():
            return b""

        text_clean = text.strip()
        voice_id = self.resolve_voice(voice)

        cached_path = self.get_cached_audio_path(text_clean, voice_id)
        if cached_path:
            with open(cached_path, "rb") as f:
                return f.read()

        cache_key = self._get_cache_key(text_clean, voice_id)
        cache_path = os.path.join(self.cache_dir, f"{cache_key}.mp3")

        # Attempt 1: edge-tts (Neural Voice)
        try:
            communicate = edge_tts.Communicate(text_clean, voice_id)
            audio_buffer = io.BytesIO()

            async for chunk in communicate.stream():
                if chunk["type"] == "audio":
                    audio_buffer.write(chunk["data"])

            mp3_bytes = audio_buffer.getvalue()
            if mp3_bytes and len(mp3_bytes) > 500:
                with open(cache_path, "wb") as f:
                    f.write(mp3_bytes)
                return mp3_bytes
        except Exception:
            pass

        # Attempt 2: gTTS (Google TTS Fallback)
        try:
            loop = asyncio.get_event_loop()
            def _gtts_fetch():
                tts = gTTS(text=text_clean, lang="bn")
                fp = io.BytesIO()
                tts.write_to_fp(fp)
                return fp.getvalue()

            mp3_bytes = await loop.run_in_executor(None, _gtts_fetch)
            if mp3_bytes:
                with open(cache_path, "wb") as f:
                    f.write(mp3_bytes)
                return mp3_bytes
        except Exception:
            pass

        return b""


# Global singleton instance
tts_service = TTSService()
