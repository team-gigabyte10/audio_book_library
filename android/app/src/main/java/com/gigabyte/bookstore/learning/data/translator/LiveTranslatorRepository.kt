package com.gigabyte.bookstore.learning.data.translator

import com.gigabyte.bookstore.learning.data.LearningRepository
import com.gigabyte.bookstore.learning.domain.model.LessonItem
import com.gigabyte.bookstore.learning.domain.model.Token
import com.gigabyte.bookstore.learning.domain.translator.BanglaPronunciationEngine
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
            return@withContext Result.success(ensureBanglaPronunciation(it, language))
        }

        // Tier 2: Firebase AI Gemini educational translation (script + bn_pron + word breakdown + grammar tip).
        val aiResult = translateViaFirebaseAi(cleanInput, language, direction, dialect)
        if (aiResult != null) {
            return@withContext Result.success(ensureBanglaPronunciation(aiResult, language))
        }

        // Tier 3: Resilient HTTP fallback when online (non-regional standard languages).
        if (language != TranslatorLanguage.REGIONAL_BANGLA) {
            val webResult = translateViaHttpFallback(cleanInput, language, direction)
            if (webResult != null) {
                return@withContext Result.success(ensureBanglaPronunciation(webResult, language))
            }
        }

        // Soft fallback: best partial match offline if available.
        findPartialOfflineMatch(cleanInput, language, direction, dialect)?.let {
            return@withContext Result.success(ensureBanglaPronunciation(it, language))
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
                TranslatorLanguage.GERMAN,
                TranslatorLanguage.CHINESE,
                TranslatorLanguage.KOREAN
            )
        ) {
            val vocabItems = runCatching { VocabRepository.getConfigForLanguage(language.key).items }.getOrDefault(emptyList())
            val exactVocab = vocabItems.firstOrNull { vocab ->
                if (reverse) {
                    normalizeForMatch(vocab.singularTarget) == normQuery ||
                        (!vocab.pluralTarget.isNullOrBlank() && normalizeForMatch(vocab.pluralTarget) == normQuery)
                } else {
                    vocab.bnMeaning.split('/', ',').any { part -> normalizeForMatch(part) == normQuery }
                }
            }
            if (exactVocab != null) {
                val matchedPlural = reverse &&
                    !exactVocab.pluralTarget.isNullOrBlank() &&
                    normalizeForMatch(exactVocab.pluralTarget) == normQuery
                val matchedTarget = if (matchedPlural) exactVocab.pluralTarget!! else exactVocab.singularTarget
                val matchedPron = if (matchedPlural) {
                    exactVocab.pluralBnPron ?: exactVocab.singularBnPron
                } else {
                    exactVocab.singularBnPron
                }
                val outText = if (reverse) exactVocab.bnMeaning else matchedTarget
                val secondary = if (matchedPlural) exactVocab.pluralSecondary else exactVocab.singularSecondary
                return TranslationResult(
                    sourceText = query,
                    targetText = outText,
                    banglaPronunciation = matchedPron,
                    romanization = if (reverse) null else secondary,
                    wordBreakdown = listOf(Token(matchedTarget, exactVocab.bnMeaning, matchedPron)),
                    grammarTipBn = exactVocab.noteBn ?: if (exactVocab.pluralTarget != null) {
                        "একবচন: ${exactVocab.singularTarget} (${exactVocab.singularBnPron}) • বহুবচন: ${exactVocab.pluralTarget} (${exactVocab.pluralBnPron.orEmpty()})"
                    } else null,
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
        val first = dbHits.firstOrNull()
        if (first != null) {
            return lessonItemToResult(first, query, language, direction, dialect)
        }

        if (language in listOf(
                TranslatorLanguage.ENGLISH,
                TranslatorLanguage.JAPANESE,
                TranslatorLanguage.URDU,
                TranslatorLanguage.HINDI,
                TranslatorLanguage.GERMAN,
                TranslatorLanguage.CHINESE,
                TranslatorLanguage.KOREAN
            )
        ) {
            val normQuery = normalizeForMatch(query)
            val vocabItems = runCatching { VocabRepository.getConfigForLanguage(language.key).items }.getOrDefault(emptyList())
            val partialVocab = vocabItems.firstOrNull { vocab ->
                if (reverse) {
                    normalizeForMatch(vocab.singularTarget).contains(normQuery) ||
                        normQuery.contains(normalizeForMatch(vocab.singularTarget))
                } else {
                    normalizeForMatch(vocab.bnMeaning).contains(normQuery) ||
                        vocab.bnMeaning.split('/', ',').any { part ->
                            val np = normalizeForMatch(part)
                            np.isNotEmpty() && (np.contains(normQuery) || normQuery.contains(np))
                        }
                }
            }
            if (partialVocab != null) {
                val outText = if (reverse) partialVocab.bnMeaning else partialVocab.singularTarget
                return TranslationResult(
                    sourceText = query,
                    targetText = outText,
                    banglaPronunciation = partialVocab.singularBnPron,
                    romanization = if (reverse) null else partialVocab.singularSecondary,
                    wordBreakdown = listOf(Token(partialVocab.singularTarget, partialVocab.bnMeaning, partialVocab.singularBnPron)),
                    grammarTipBn = partialVocab.noteBn ?: "শব্দভাণ্ডার ভল্ট থেকে পাওয়া কাছাকাছি অনুবাদ।",
                    languageKey = language.key,
                    direction = direction,
                    sourceTier = TranslationSourceTier.OFFLINE_CURRICULUM
                )
            }
        }
        return null
    }

    private fun lessonItemToResult(
        item: LessonItem,
        query: String,
        language: TranslatorLanguage,
        direction: TranslatorDirection,
        dialect: RegionalDialectChoice
    ): TranslationResult {
        val reverse = direction == TranslatorDirection.TARGET_TO_BN
        val pron = item.bnPron?.takeIf { it.isNotBlank() }
            ?: BanglaPronunciationEngine.generate(item.target, language)
        return TranslationResult(
            sourceText = query,
            targetText = if (reverse) item.bn.orEmpty() else item.target,
            banglaPronunciation = pron,
            wordBreakdown = item.tokens.map { tok ->
                tok.copy(bnPron = tok.bnPron ?: BanglaPronunciationEngine.generateWord(tok.text, language))
            },
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
        val url = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=$src&tl=$dst&dt=t&dt=rm&q=$encoded"
        val request = Request.Builder()
            .url(url)
            .header("User-Agent", "Mozilla/5.0")
            .build()
        httpClient.newCall(request).execute().use { resp ->
            if (!resp.isSuccessful) return@runCatching null
            val body = resp.body?.string() ?: return@runCatching null
            val payload = parseGoogleTranslatePayload(body) ?: return@runCatching null
            val foreignText = if (direction == TranslatorDirection.BN_TO_TARGET) payload.translatedText else query
            val romanHint = if (direction == TranslatorDirection.BN_TO_TARGET) payload.targetRomanization else payload.sourceRomanization
            val bnPron = BanglaPronunciationEngine.generate(
                targetText = foreignText,
                language = language,
                romanizationHint = romanHint
            )
            val tokens = if (direction == TranslatorDirection.BN_TO_TARGET) {
                payload.translatedText.split(Regex("\\s+")).filter { it.isNotBlank() }.take(10).map { w ->
                    Token(w, null, BanglaPronunciationEngine.generateWord(w, language))
                }
            } else emptyList()
            TranslationResult(
                sourceText = query,
                targetText = payload.translatedText,
                banglaPronunciation = bnPron,
                romanization = romanHint,
                wordBreakdown = tokens,
                languageKey = language.key,
                direction = direction,
                sourceTier = TranslationSourceTier.WEB_FALLBACK
            )
        }
    }.getOrNull()

    companion object {
        private val PUNCT_STRIP = Regex("[।॥,?!.,:;'\'\"“”\\s]+")

        internal data class WebTranslatePayload(
            val translatedText: String,
            val targetRomanization: String? = null,
            val sourceRomanization: String? = null
        )

        internal fun ensureBanglaPronunciation(
            result: TranslationResult,
            language: TranslatorLanguage = TranslatorLanguage.fromKey(result.languageKey)
        ): TranslationResult {
            val foreignText = if (result.direction == TranslatorDirection.BN_TO_TARGET) {
                result.targetText
            } else {
                result.sourceText
            }
            val filledPron = result.banglaPronunciation?.takeIf { it.isNotBlank() }
                ?: BanglaPronunciationEngine.generate(
                    targetText = foreignText,
                    language = language,
                    romanizationHint = result.romanization
                )
            val enrichedTokens = if (result.wordBreakdown.isEmpty() && result.direction == TranslatorDirection.BN_TO_TARGET) {
                foreignText.split(Regex("\\s+")).filter { it.isNotBlank() }.take(10).map { w ->
                    Token(w, null, BanglaPronunciationEngine.generateWord(w, language))
                }
            } else {
                result.wordBreakdown.map { tok ->
                    if (!tok.bnPron.isNullOrBlank()) tok
                    else tok.copy(bnPron = BanglaPronunciationEngine.generateWord(tok.text, language))
                }
            }
            return result.copy(
                banglaPronunciation = filledPron,
                wordBreakdown = enrichedTokens
            )
        }

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
                  "word_breakdown": [{"t": "target_word", "bn": "short_bangla_meaning", "pron": "bangla_pronunciation_of_word"}],
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
                  "bangla_pronunciation": "accurate phonetic pronunciation of the original foreign input written strictly in Bengali script",
                  "romanization": "",
                  "word_breakdown": [{"t": "source_word", "bn": "bangla_meaning", "pron": "bangla_pronunciation_of_word"}],
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
                    val wp = obj.optString("pron", "").trim().takeIf { it.isNotEmpty() }
                    if (w.isNotEmpty()) tokensList.add(Token(w, m, wp))
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

        internal fun parseGoogleTranslatePayload(rawBody: String): WebTranslatePayload? = runCatching {
            val root = JSONArray(rawBody)
            val segments = root.optJSONArray(0) ?: return@runCatching null
            val translatedSb = StringBuilder()
            val targetRomaSb = StringBuilder()
            val sourceRomaSb = StringBuilder()
            for (i in 0 until segments.length()) {
                val seg = segments.optJSONArray(i) ?: continue
                if (!seg.isNull(0)) {
                    translatedSb.append(seg.optString(0, ""))
                }
                if (!seg.isNull(2)) {
                    val tr = seg.optString(2, "").trim()
                    if (tr.isNotEmpty()) {
                        if (targetRomaSb.isNotEmpty()) targetRomaSb.append(' ')
                        targetRomaSb.append(tr)
                    }
                }
                if (!seg.isNull(3)) {
                    val sr = seg.optString(3, "").trim()
                    if (sr.isNotEmpty()) {
                        if (sourceRomaSb.isNotEmpty()) sourceRomaSb.append(' ')
                        sourceRomaSb.append(sr)
                    }
                }
            }
            val translated = translatedSb.toString().trim().takeIf { it.isNotEmpty() } ?: return@runCatching null
            WebTranslatePayload(
                translatedText = translated,
                targetRomanization = targetRomaSb.toString().trim().takeIf { it.isNotEmpty() },
                sourceRomanization = sourceRomaSb.toString().trim().takeIf { it.isNotEmpty() }
            )
        }.getOrNull()

        internal fun parseGoogleTranslateArrayJson(rawBody: String): String? =
            parseGoogleTranslatePayload(rawBody)?.translatedText
    }
}

