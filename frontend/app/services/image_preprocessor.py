import fitz  # PyMuPDF
from PIL import Image, ImageEnhance, ImageOps, ImageFilter
import io
from typing import Optional


class ImagePreprocessor:
    """
    Renders PDF pages as high-resolution images and applies image preprocessing
    (grayscale, contrast enhancement, denoising, margin trimming) to optimize Bangla OCR.
    """

    def __init__(self, dpi: int = 300):
        self.dpi = dpi

    def render_page_to_image(self, pdf_path: str, page_number: int) -> Image.Image:
        """
        Renders a PDF page as a high-DPI PIL Image.
        """
        doc = fitz.open(pdf_path)
        page_idx = page_number - 1

        if page_idx < 0 or page_idx >= len(doc):
            doc.close()
            raise ValueError(f"Page {page_number} is out of bounds [1, {len(doc)}]")

        page = doc[page_idx]

        # Calculate zoom matrix for requested DPI (72 DPI is 1.0 zoom)
        zoom = self.dpi / 72.0
        mat = fitz.Matrix(zoom, zoom)

        pix = page.get_pixmap(matrix=mat, alpha=False)
        image_bytes = pix.tobytes("png")
        doc.close()

        img = Image.open(io.BytesIO(image_bytes))
        return img

    def preprocess_image(
        self,
        img: Image.Image,
        enhance_contrast: bool = True,
        denoise: bool = True,
        binarize: bool = False
    ) -> Image.Image:
        """
        Preprocesses a PIL Image for Tesseract Bangla OCR.
        """
        # Convert to Grayscale
        if img.mode != "L":
            img = img.convert("L")

        # Soft Denoise (avoid heavy median filter that erases Bangla nuktas and matras)
        if denoise:
            # Gentle box blur or bilateral-like smoothing instead of median filter
            img = img.filter(ImageFilter.SMOOTH)

        # Moderate Contrast & Sharpness Enhancement
        if enhance_contrast:
            enhancer = ImageEnhance.Contrast(img)
            img = enhancer.enhance(1.3)
            
            sharpener = ImageEnhance.Sharpness(img)
            img = sharpener.enhance(1.2)

        # Optional thresholding/binarization
        if binarize:
            # Otsu thresholding fallback via simple middle threshold
            threshold = 180
            img = img.point(lambda p: 255 if p > threshold else 0)

        # Autocrop white borders/margins
        try:
            bbox = ImageOps.invert(img).getbbox()
            if bbox:
                # Add small padding around cropped content
                padding = 10
                width, height = img.size
                left = max(0, bbox[0] - padding)
                top = max(0, bbox[1] - padding)
                right = min(width, bbox[2] + padding)
                bottom = min(height, bbox[3] + padding)
                img = img.crop((left, top, right, bottom))
        except Exception:
            pass

        return img
