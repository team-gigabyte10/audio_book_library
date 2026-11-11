package com.gigabyte.bookstore.learning.data.translator

import com.gigabyte.bookstore.learning.data.LearningRepository
import com.gigabyte.bookstore.learning.domain.model.LessonItem
import com.gigabyte.bookstore.learning.domain.model.Token
import com.gigabyte.bookstore.learning.domain.translator.RegionalDialectChoice
import com.gigabyte.bookstore.learning.domain.translator.TranslationResult
import com.gigabyte.bookstore.learning.domain.translator.TranslationSourceTier
import com.gigabyte.bookstore.learning.domain.translator.TranslatorDirection
import com.gigabyte.bookstore.learning.domain.translator.TranslatorLanguage
import com.gigabyte.bookstore.learning.presentation.vocab.VocabRepository
import com.google.firebase.Firebase
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject
import java.net.URLEncoder
import java.util.concurrent.TimeUnit

class LiveTranslatorRepository(
    private val learningRepository: LearningRepository
) {
    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()

    suspend fun translate(
        inputText: String,
        language: TranslatorLanguage,
        direction: TranslatorDirection = TranslatorDirection.BN_TO_TARGET,
        dialect: RegionalDialectChoice = RegionalDialectChoice.CTG
    ): Result<TranslationResult> = withContext(Dispatchers.IO) {
        val cleanInput = inputText.trim()
        if (cleanInput.isEmpty()) {
            return@withContext Result.failure(IllegalArgumentException("অনুবাদ করার জন্য কিছু বলুন বা লিখুন।"))
        }

        // Tier 1: Exact / near-exact match from local Room DB & VocabVault (0ms, 100% offline).
        findExactOfflineMatch(cleanInput, language, direction, dialect)?.let {
            return@withContext Result.success(it)
        }

        // Tier 2: Firebase AI Gemini educational translation (script + bn_pron + word breakdown + grammar tip).
        val aiResult = translateViaFirebaseAi(cleanInput, language, direction, dialect)
        if (aiResult != null) {
            return@withContext Result.success(aiResult)
        }

        // Tier 3: Resilient HTTP fallback when online (non-regional standard languages).
        if (language != TranslatorLanguage.REGIONAL_BANGLA) {
            val webResult = translateViaHttpFallback(cleanInput, language, direction)
            if (webResult != null) {
                return@withContext Result.success(webResult)
            }
        }

        // Soft fallback: best partial match offline if available.
        findPartialOfflineMatch(cleanInput, language, direction, dialect)?.let {
            return@withContext Result.success(it)
        }

        Result.failure(
            IllegalStateException("অনলাইন অনুবাদের জন্য ইন্টারনেট সংযোগ চালু করুন। অফলাইনে কোর্সের পরিচিত শব্দ ও বাক্যগুলো অনুবাদ করা যায়।")
        )
    }

    private suspend fun findExactOfflineMatch(
        query: String,
        language: TranslatorLanguage,
        direction: TranslatorDirection,
        dialect: RegionalDialectChoice
    ): TranslationResult? {
        val normQuery = normalizeForMatch(query)
        val reverse = direction == TranslatorDirection.TARGET_TO_BN
        val speakerQuery = if (!reverse && language == TranslatorLanguage.REGIONAL_BANGLA) dialect.speakerQuery else null

        val dbHits = learningRepository.searchOfflineTranslations(
            idPrefix = language.itemIdPrefix,
            query = query,
            reverseTargetToBn = reverse,
            speakerQuery = speakerQuery
        )

        val exactDb = dbHits.firstOrNull { item ->
            val candidate = if (reverse) item.target else item.bn.orEmpty()
            normalizeForMatch(candidate) == normQuery
        }
        if (exactDb != null) {
            return lessonItemToResult(exactDb, query, language, direction, dialect)
        }

        // Check in-memory VocabVault (1000+ words per course) when not Arabic/Regional.
        if (language in listOf(
                TranslatorLanguage.ENGLISH,
                TranslatorLanguage.JAPANESE,
                TranslatorLanguage.URDU,
                TranslatorLanguage.HINDI,
                TranslatorLanguage.GERMAN
            )
        ) {
            val vocabItems = runCatching { VocabRepository.getConfigForLanguage(language.key).items }.getOrDefault(emptyList())
            val exactVocab = vocabItems.firstOrNull { vocab ->
                if (reverse) {
                    normalizeForMatch(vocab.singularTarget) == normQuery
                } else {
                    vocab.bnMeaning.split('/', ',').any { part -> normalizeForMatch(part) == normQuery }
                }
            }
            if (exactVocab != null) {
                val outText = if (reverse) exactVocab.bnMeaning else exactVocab.singularTarget
                val bnPron = if (reverse) null else exactVocab.singularBnPron
                val targetWord = exactVocab.singularTarget
                return TranslationResult(
                    sourceText = query,
                    targetText = outText,
                    banglaPronunciation = bnPron,
                    romanization = if (reverse) null else exactVocab.singularSecondary,
                    wordBreakdown = listOf(Token(targetWord, exactVocab.bnMeaning)),
                    grammarTipBn = exactVocab.noteBn,
                    languageKey = language.key,
                    direction = direction,
                    sourceTier = TranslationSourceTier.OFFLINE_CURRICULUM
                )
            }
        }

        return null
    }

    private suspend fun findPartialOfflineMatch(
        query: String,
        language: TranslatorLanguage,
        direction: TranslatorDirection,
        dialect: RegionalDialectChoice
    ): TranslationResult? {
        val reverse = direction == TranslatorDirection.TARGET_TO_BN
        val speakerQuery = if (!reverse && language == TranslatorLanguage.REGIONAL_BANGLA) dialect.speakerQuery else null
        val dbHits = learningRepository.searchOfflineTranslations(
            idPrefix = language.itemIdPrefix,
            query = query,
            reverseTargetToBn = reverse,
            speakerQuery = speakerQuery
        )
        val first = dbHits.firstOrNull() ?: return null
        return lessonItemToResult(first, query, language, direction, dialect)
    }

    private fun lessonItemToResult(
        item: LessonItem,
        query: String,
        language: TranslatorLanguage,
        direction: TranslatorDirection,
        dialect: RegionalDialectChoice
    ): TranslationResult {
        val reverse = direction == TranslatorDirection.TARGET_TO_BN
        return TranslationResult(
            sourceText = query,
            targetText = if (reverse) item.bn.orEmpty() else item.target,
            banglaPronunciation = if (reverse) null else item.bnPron,
            wordBreakdown = item.tokens,
            grammarTipBn = if (reverse) "মূল বাক্য: ${item.target}" else "কোর্স কারিকুলাম থেকে নেওয়া সঠিক অনুবাদ।",
            languageKey = language.key,
            dialectKey = if (language == TranslatorLanguage.REGIONAL_BANGLA) dialect.key else null,
            direction = direction,
            sourceTier = TranslationSourceTier.OFFLINE_CURRICULUM
        )
    }

    private suspend fun translateViaFirebaseAi(
        query: String,
        language: TranslatorLanguage,
        direction: TranslatorDirection,
        dialect: RegionalDialectChoice
    ): TranslationResult? = runCatching {
        val model = Firebase.ai(backend = GenerativeBackend.googleAI())
            .generativeModel("gemini-2.5-flash")

        val prompt = buildAiPrompt(query, language, direction, dialect)
        val response = model.generateContent(prompt)
        val rawText = response.text ?: return@runCatching null
        parseAiTranslationJson(
            rawResponse = rawText,
            sourceText = query,
            language = language,
            direction = direction,
            dialect = dialect
        )
    }.getOrNull()

    private fun translateViaHttpFallback(
        query: String,
        language: TranslatorLanguage,
        direction: TranslatorDirection
    ): TranslationResult? = runCatching {
        val src = if (direction == TranslatorDirection.BN_TO_TARGET) "bn" else language.isoCode
        val dst = if (direction == TranslatorDirection.BN_TO_TARGET) language.isoCode else "bn"
        val encoded = URLEncoder.encode(query, "UTF-8")
        val url = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=$src&tl=$dst&dt=t&q=$encoded"
        val request = Request.Builder()
            .url(url)
            .header("User-Agent", "Mozilla/5.0")
            .build()
        httpClient.newCall(request).execute().use { resp ->
            if (!resp.isSuccessful) return@runCatching null
            val body = resp.body?.string() ?: return@runCatching null
            val translated = parseGoogleTranslateArrayJson(body) ?: return@runCatching null
            TranslationResult(
                sourceText = query,
                targetText = translated,
                wordBreakdown = if (direction == TranslatorDirection.BN_TO_TARGET) {
                    translated.split(Regex("\\s+")).filter { it.isNotBlank() }.take(10).map { Token(it, null) }
                } else emptyList(),
                languageKey = language.key,
                direction = direction,
                sourceTier = TranslationSourceTier.WEB_FALLBACK
            )
        }
    }.getOrNull()

    companion object {
        private val PUNCT_STRIP = Regex("[।॥,?!.,:;'\'\"“”\\s]+")

        internal fun normalizeForMatch(text: String): String =
            PUNCT_STRIP.replace(text.trim().lowercase(), "")

        internal fun buildAiPrompt(
            query: String,
            language: TranslatorLanguage,
            direction: TranslatorDirection,
            dialect: RegionalDialectChoice
        ): String {
            val targetLabel = if (language == TranslatorLanguage.REGIONAL_BANGLA) {
                "Bangladeshi Regional Dialect: ${dialect.labelBn} (written clearly in Bengali script using authentic local dialect words and tone)"
            } else {
                "${language.nativeName} (${language.titleBn})"
            }

            return if (direction == TranslatorDirection.BN_TO_TARGET) {
                """
                You are an expert Bangladeshi language tutor. Translate this Bangla sentence naturally into spoken $targetLabel.
                Input (Bangla): "$query"

                Return ONLY a valid JSON object with NO markdown fences and exact keys:
                {
                  "translated_text": "natural spoken sentence in target script",
                  "bangla_pronunciation": "accurate phonetic pronunciation written strictly in Bengali script for a Bengali learner",
                  "romanization": "optional Romaji or transliteration, empty string if not needed",
                  "word_breakdown": [{"t": "target_word", "bn": "short_bangla_meaning"}],
                  "grammar_tip_bn": "one helpful sentence in Bangla explaining politeness, tone, or usage"
                }
                """.trimIndent()
            } else {
                """
                You are an expert Bangladeshi language tutor. Translate this spoken $targetLabel phrase naturally into clear Standard Bangla.
                Input: "$query"

                Return ONLY a valid JSON object with NO markdown fences and exact keys:
                {
                  "translated_text": "natural Standard Bangla meaning",
                  "bangla_pronunciation": "",
                  "romanization": "",
                  "word_breakdown": [{"t": "source_word", "bn": "bangla_meaning"}],
                  "grammar_tip_bn": "one helpful sentence in Bangla about context or reply suggestion"
                }
                """.trimIndent()
            }
        }

        internal fun parseAiTranslationJson(
            rawResponse: String,
            sourceText: String,
            language: TranslatorLanguage,
            direction: TranslatorDirection,
            dialect: RegionalDialectChoice
        ): TranslationResult? = runCatching {
            val cleaned = rawResponse.trim()
                .removePrefix("```json")
                .removePrefix("```JSON")
                .removePrefix("```")
                .removeSuffix("```")
                .trim()
            val startIdx = cleaned.indexOf('{')
            val endIdx = cleaned.lastIndexOf('}')
            if (startIdx < 0 || endIdx <= startIdx) return@runCatching null

            val jsonObj = JSONObject(cleaned.substring(startIdx, endIdx + 1))
            val translated = jsonObj.optString("translated_text", "").trim()
            if (translated.isEmpty()) return@runCatching null

            val bnPron = jsonObj.optString("bangla_pronunciation", "").trim()
                .replace('\u0964', '\u09F7')
                .takeIf { it.isNotEmpty() }
            val roman = jsonObj.optString("romanization", "").trim().takeIf { it.isNotEmpty() }
            val tip = jsonObj.optString("grammar_tip_bn", "").trim().takeIf { it.isNotEmpty() }

            val tokensList = mutableListOf<Token>()
            val arr = jsonObj.optJSONArray("word_breakdown")
            if (arr != null) {
                for (i in 0 until arr.length()) {
                    val obj = arr.optJSONObject(i) ?: continue
                    val w = obj.optString("t", "").trim()
                    val m = obj.optString("bn", "").trim().takeIf { it.isNotEmpty() }
                    if (w.isNotEmpty()) tokensList.add(Token(w, m))
                }
            }

            TranslationResult(
                sourceText = sourceText,
                targetText = translated,
                banglaPronunciation = bnPron,
                romanization = roman,
                wordBreakdown = tokensList,
                grammarTipBn = tip,
                languageKey = language.key,
                dialectKey = if (language == TranslatorLanguage.REGIONAL_BANGLA) dialect.key else null,
                direction = direction,
                sourceTier = TranslationSourceTier.AI_TUTOR
            )
        }.getOrNull()

        internal fun parseGoogleTranslateArrayJson(rawBody: String): String? = runCatching {
            val root = JSONArray(rawBody)
            val segments = root.optJSONArray(0) ?: return@runCatching null
            val sb = StringBuilder()
            for (i in 0 until segments.length()) {
                val seg = segments.optJSONArray(i) ?: continue
                val text = seg.optString(0, "")
                sb.append(text)
            }
            sb.toString().trim().takeIf { it.isNotEmpty() }
        }.getOrNull()
    }
}

