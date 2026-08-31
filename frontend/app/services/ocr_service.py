import os
import shutil
from typing import Tuple, Optional
import pytesseract
from PIL import Image


class OCRService:
    """
    Interfaces with Tesseract OCR engine for Bangla text recognition (`ben`).
    Includes auto-detection for Windows installation directories & Bengali language pack (`ben.traineddata`).
    """

    COMMON_WINDOWS_PATHS = [
        r"C:\Program Files\Tesseract-OCR\tesseract.exe",
        r"C:\Program Files (x86)\Tesseract-OCR\tesseract.exe",
        os.path.expanduser(r"~\AppData\Local\Programs\Tesseract-OCR\tesseract.exe"),
        os.path.expanduser(r"~\AppData\Local\Tesseract-OCR\tesseract.exe"),
        r"C:\Tesseract-OCR\tesseract.exe"
    ]

    def __init__(self, tesseract_path: Optional[str] = None, lang: str = "ben"):
        self.lang = lang
        self.tesseract_path = tesseract_path or os.getenv("TESSERACT_PATH", "").strip()

        resolved_path = self._resolve_tesseract_path()
        if resolved_path:
            pytesseract.pytesseract.tesseract_cmd = resolved_path
            self.resolved_tesseract_path = resolved_path
        else:
            self.resolved_tesseract_path = ""

    def _resolve_tesseract_path(self) -> Optional[str]:
        """
        Attempts to resolve tesseract executable path from config, system PATH, or common Windows directories.
        """
        # 1. Configured path
        if self.tesseract_path and os.path.exists(self.tesseract_path):
            return self.tesseract_path

        # 2. System PATH via shutil.which
        which_path = shutil.which("tesseract")
        if which_path:
            return which_path

        # 3. Windows Common Paths
        for p in self.COMMON_WINDOWS_PATHS:
            if os.path.exists(p):
                return p

        return None

    def ensure_language_pack(self) -> bool:
        """
        Attempts to ensure that the requested language traineddata (e.g. `ben.traineddata`) is present.
        If missing, attempts to automatically download it from official tessdata_fast repository.
        """
        if not self.resolved_tesseract_path:
            return False

        try:
            available_langs = pytesseract.get_languages(config="")
            if self.lang in available_langs:
                return True
        except Exception:
            pass

        # Locate tessdata target folder
        tessdata_dir = os.environ.get("TESSDATA_PREFIX", "")
        if not tessdata_dir or not os.path.exists(tessdata_dir):
            tessdata_dir = os.path.join(os.path.dirname(self.resolved_tesseract_path), "tessdata")

        # Fallback to local project tessdata if system directory is unwritable
        target_file = os.path.join(tessdata_dir, f"{self.lang}.traineddata")
        if os.path.exists(target_file):
            return True

        # Attempt to auto-download traineddata from GitHub tessdata_fast
        download_url = f"https://raw.githubusercontent.com/tesseract-ocr/tessdata_fast/main/{self.lang}.traineddata"
        try:
            import urllib.request
            os.makedirs(tessdata_dir, exist_ok=True)
            urllib.request.urlretrieve(download_url, target_file)
            return os.path.exists(target_file)
        except Exception:
            # Fallback to local data/tessdata folder in project root
            try:
                local_tessdata = os.path.join("data", "tessdata")
                os.makedirs(local_tessdata, exist_ok=True)
                local_file = os.path.join(local_tessdata, f"{self.lang}.traineddata")
                if not os.path.exists(local_file):
                    import urllib.request
                    urllib.request.urlretrieve(download_url, local_file)
                if os.path.exists(local_file):
                    os.environ["TESSDATA_PREFIX"] = os.path.abspath(local_tessdata)
                    return True
            except Exception:
                pass
        return False

    def check_availability(self) -> Tuple[bool, str]:
        """
        Verifies if Tesseract OCR binary and requested language traineddata (e.g. `ben`) are present.
        Returns (is_available, status_message).
        """
        if not self.resolved_tesseract_path:
            return (
                False,
                "Bangla OCR is unavailable because Tesseract OCR is not installed or not found in system paths. "
                "Please install Tesseract OCR (e.g. via `winget install UB-Mannheim.TesseractOCR` or from https://github.com/UB-Mannheim/tesseract/wiki) "
                "or set TESSERACT_PATH in your .env file."
            )

        # Verify executable version
        try:
            version = pytesseract.get_tesseract_version()
        except Exception as e:
            return (
                False,
                f"Tesseract executable found at '{self.resolved_tesseract_path}' but failed to execute: {str(e)}"
            )

        # Check / auto-fetch language pack
        self.ensure_language_pack()

        try:
            available_langs = pytesseract.get_languages(config="")
            if self.lang not in available_langs:
                tessdata_dir = os.environ.get("TESSDATA_PREFIX") or os.path.join(os.path.dirname(self.resolved_tesseract_path), "tessdata")
                return (
                    False,
                    f"Tesseract OCR (v{version}) is detected at '{self.resolved_tesseract_path}', "
                    f"but Bengali language data ({self.lang}.traineddata) is missing in '{tessdata_dir}'. "
                    f"Please download ben.traineddata and place it in the tessdata directory."
                )
        except Exception:
            pass

        return True, f"Tesseract OCR (v{version}) is available with '{self.lang}' language support."

    def process_image(self, image: Image.Image) -> Tuple[str, int, int, Optional[float]]:
        """
        Performs OCR on a PIL Image object using Bangla language model (`ben`).
        Detects image rotation and applies deskewing if needed.
        Returns (raw_text, char_count, word_count, average_confidence).
        """
        is_avail, msg = self.check_availability()
        if not is_avail:
            raise RuntimeError(msg)

        try:
            # Check orientation via OSD if available
            try:
                osd_data = pytesseract.image_to_osd(image)
                for line in osd_data.split("\n"):
                    if "Rotate:" in line:
                        angle = int(line.split(":")[1].strip())
                        if angle in [90, 180, 270]:
                            image = image.rotate(-angle, expand=True)
                        break
            except Exception:
                pass

            config = f"-l {self.lang} --psm 3 --oem 1"
            
            # Extract detailed image data to compute confidence for recognized words
            data = pytesseract.image_to_data(image, config=config, output_type=pytesseract.Output.DICT)
            
            conf_list = []
            texts = data.get("text", [])
            confs = data.get("conf", [])
            for c, t in zip(confs, texts):
                try:
                    c_val = float(c)
                    if c_val >= 0 and t and t.strip():
                        conf_list.append(c_val)
                except Exception:
                    pass

            avg_confidence = float(sum(conf_list) / len(conf_list)) if conf_list else None

            # Get text string
            raw_text = pytesseract.image_to_string(image, config=config).strip()
            
            char_count = len(raw_text)
            word_count = len(raw_text.split())

            return raw_text, char_count, word_count, avg_confidence

        except Exception as e:
            raise RuntimeError(f"OCR processing failed: {str(e)}")
