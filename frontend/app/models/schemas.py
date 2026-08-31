from enum import Enum
from typing import List, Optional, Dict, Any
from pydantic import BaseModel, Field


class ProcessingStatusEnum(str, Enum):
    UPLOADED = "UPLOADED"
    ANALYZING = "ANALYZING"
    EXTRACTING = "EXTRACTING"
    OCR_PROCESSING = "OCR_PROCESSING"
    CLEANING = "CLEANING"
    COMPLETED = "COMPLETED"
    FAILED = "FAILED"
    CANCELLED = "CANCELLED"


class PageType(str, Enum):
    TEXT = "TEXT"
    SCANNED = "SCANNED"
    MIXED = "MIXED"


class PageResult(BaseModel):
    page_number: int
    processing_method: str  # "text_extraction", "ocr", "mixed"
    page_type: PageType = PageType.TEXT
    raw_text: str = ""
    cleaned_text: str = ""
    character_count: int = 0
    word_count: int = 0
    processing_time: float = 0.0
    ocr_used: bool = False
    confidence_if_available: Optional[float] = None
    fallback_used: bool = False
    fallback_reason: Optional[str] = None


class ChapterInfo(BaseModel):
    title: str
    start_page: int
    end_page: int


class JobSummary(BaseModel):
    job_id: str
    filename: str
    original_filename: str
    file_size: int
    total_pages: int = 0
    text_pages: int = 0
    scanned_pages: int = 0
    mixed_pages: int = 0
    status: ProcessingStatusEnum = ProcessingStatusEnum.UPLOADED
    progress_percent: float = 0.0
    processed_pages: int = 0
    current_operation: str = "Uploaded"
    estimated_remaining_seconds: Optional[float] = None
    error_message: Optional[str] = None
    chapters: List[ChapterInfo] = Field(default_factory=list)
    created_at: str
    completed_at: Optional[str] = None
    ocr_available: bool = True
    ocr_message: Optional[str] = None


class UpdatePageRequest(BaseModel):
    cleaned_text: str


class SearchMatch(BaseModel):
    page_number: int
    match_count: int
    snippet: str


class SearchResponse(BaseModel):
    query: str
    total_matches: int
    matches: List[SearchMatch]
