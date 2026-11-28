package com.gigabyte.bookstore.data.repository

import android.util.Log
import com.gigabyte.bookstore.data.models.AppNotice
import com.gigabyte.bookstore.data.models.AudioBundle
import com.gigabyte.bookstore.data.models.Course
import com.gigabyte.bookstore.data.models.CourseLesson
import com.gigabyte.bookstore.data.models.CourseModule
import com.gigabyte.bookstore.data.models.HeroBanner
import com.gigabyte.bookstore.data.models.RemoteBook
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class HomeRepository(
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
) {
    companion object {
        private const val TAG = "HomeRepository"
    }

    suspend fun getBanners(): List<HeroBanner> = withContext(Dispatchers.IO) {
        try {
            val snapshot = firestore.collection("banners").get().await()
            val list = snapshot.documents.mapNotNull { doc ->
                HeroBanner(
                    id = doc.id,
                    title = doc.getString("title") ?: "",
                    subtitle = doc.getString("subtitle") ?: "",
                    tag = doc.getString("tag") ?: "",
                    tagColor = doc.getString("tagColor"),
                    imageUrl = doc.getString("imageUrl") ?: "",
                    actionType = doc.getString("actionType") ?: "",
                    targetId = doc.getString("targetId") ?: "",
                    order = doc.getLong("order")?.toInt() ?: 0
                )
            }.sortedBy { it.order }
            list
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching banners from Firestore: ${e.message}", e)
            emptyList()
        }
    }

    suspend fun getAudioBundles(): List<AudioBundle> = withContext(Dispatchers.IO) {
        try {
            val snapshot = firestore.collection("bundles").get().await()
            val list = snapshot.documents.mapNotNull { doc ->
                val rawBookIds = (doc.get("bookIds") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()
                val rawBookTitles = (doc.get("bookTitles") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()

                AudioBundle(
                    id = doc.id,
                    title = doc.getString("title") ?: "",
                    subtitle = doc.getString("subtitle"),
                    description = doc.getString("description"),
                    coverUrl = doc.getString("coverUrl"),
                    bookIds = rawBookIds,
                    bookTitles = rawBookTitles,
                    bookCount = doc.getLong("bookCount")?.toInt() ?: rawBookTitles.size,
                    originalPrice = doc.getDouble("originalPrice") ?: (doc.getLong("originalPrice")?.toDouble() ?: 0.0),
                    discountedPrice = doc.getDouble("discountedPrice") ?: (doc.getLong("discountedPrice")?.toDouble() ?: 0.0),
                    savingsPercentage = doc.getLong("savingsPercentage")?.toInt() ?: 0,
                    totalDurationHours = doc.getDouble("totalDurationHours") ?: (doc.getLong("totalDurationHours")?.toDouble() ?: 0.0),
                    badge = doc.getString("badge") ?: "বান্ডেল অফার",
                    rating = doc.getDouble("rating") ?: 5.0,
                    reviewCount = doc.getLong("reviewCount")?.toInt() ?: 0,
                    isFeatured = doc.getBoolean("isFeatured") ?: false
                )
            }
            list
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching bundles from Firestore: ${e.message}", e)
            emptyList()
        }
    }

    suspend fun getCourses(language: String? = null): List<Course> = withContext(Dispatchers.IO) {
        try {
            val query = if (language != null) {
                firestore.collection("courses").whereEqualTo("language", language)
            } else {
                firestore.collection("courses")
            }
            val snapshot = query.get().await()
            val list = snapshot.documents.mapNotNull { doc ->
                val rawTags = (doc.get("tags") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()
                val rawModules = (doc.get("modules") as? List<*>)?.filterIsInstance<Map<String, Any>>() ?: emptyList()

                val modules = rawModules.map { modMap ->
                    val modTitle = modMap["moduleTitle"] as? String ?: ""
                    val rawLessons = (modMap["lessons"] as? List<*>)?.filterIsInstance<Map<String, Any>>() ?: emptyList()
                    val lessons = rawLessons.map { lMap ->
                        CourseLesson(
                            id = lMap["id"] as? String ?: "",
                            title = lMap["title"] as? String ?: "",
                            duration = lMap["duration"] as? String ?: "",
                            content = lMap["content"] as? String ?: "",
                            mdPath = lMap["mdPath"] as? String,
                            audioUrl = lMap["audioUrl"] as? String,
                            pdfUrl = lMap["pdfUrl"] as? String,
                            isFree = lMap["isFree"] as? Boolean ?: false
                        )
                    }
                    CourseModule(moduleTitle = modTitle, lessons = lessons)
                }

                Course(
                    id = doc.id,
                    title = doc.getString("title") ?: "",
                    subtitle = doc.getString("subtitle"),
                    language = doc.getString("language") ?: "English",
                    level = doc.getString("level") ?: "Beginner",
                    instructor = doc.getString("instructor"),
                    description = doc.getString("description"),
                    thumbnailUrl = doc.getString("thumbnailUrl"),
                    bannerUrl = doc.getString("bannerUrl"),
                    totalHours = doc.getDouble("totalHours") ?: (doc.getLong("totalHours")?.toDouble() ?: 0.0),
                    lessonCount = doc.getLong("lessonCount")?.toInt() ?: 0,
                    rating = doc.getDouble("rating") ?: 5.0,
                    enrolledCount = doc.getLong("enrolledCount")?.toInt() ?: 0,
                    originalPrice = doc.getDouble("originalPrice") ?: (doc.getLong("originalPrice")?.toDouble() ?: 0.0),
                    discountedPrice = doc.getDouble("discountedPrice") ?: (doc.getLong("discountedPrice")?.toDouble() ?: 0.0),
                    isFree = doc.getBoolean("isFree") ?: false,
                    tags = rawTags,
                    modules = modules
                )
            }
            list
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching courses from Firestore: ${e.message}", e)
            emptyList()
        }
    }

    suspend fun getTrendingBooks(): List<RemoteBook> = withContext(Dispatchers.IO) {
        try {
            val snapshot = firestore.collection("books").limit(10).get().await()
            snapshot.documents.mapNotNull { doc ->
                RemoteBook(
                    id = doc.id,
                    title = doc.getString("title") ?: "Untitled",
                    subtitle = doc.getString("subtitle"),
                    author = doc.getString("author"),
                    translator = doc.getString("translator"),
                    tagline = doc.getString("tagline"),
                    category = doc.getString("category") ?: "General",
                    language = doc.getString("language") ?: "Bangla",
                    audioUrl = doc.getString("audioUrl"),
                    summaryMdUrl = doc.getString("summaryMdUrl"),
                    summaryMdPath = doc.getString("summaryMdPath"),
                    summaryFilename = doc.getString("summaryFilename"),
                    fullBookMdUrl = doc.getString("fullBookMdUrl"),
                    fullBookMdPath = doc.getString("fullBookMdPath"),
                    fullBookFilename = doc.getString("fullBookFilename"),
                    pdfUrl = doc.getString("pdfUrl"),
                    pdfPath = doc.getString("pdfPath"),
                    pdfFilename = doc.getString("pdfFilename"),
                    coverUrl = doc.getString("coverUrl"),
                    coverPath = doc.getString("coverPath"),
                    summarySnippet = doc.getString("summarySnippet"),
                    totalWords = doc.getLong("totalWords")?.toInt() ?: 0,
                    estimatedMinutes = doc.getLong("estimatedMinutes")?.toInt() ?: 1,
                    hasSummary = doc.getBoolean("hasSummary") ?: false,
                    hasFullBook = doc.getBoolean("hasFullBook") ?: false,
                    hasPdf = doc.getBoolean("hasPdf") ?: false,
                    slug = doc.getString("slug")
                )
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching trending books from Firestore: ${e.message}", e)
            emptyList()
        }
    }

    suspend fun getAllBooks(): List<RemoteBook> = withContext(Dispatchers.IO) {
        try {
            val snapshot = firestore.collection("books").get().await()
            snapshot.documents.mapNotNull { doc ->
                val rawPdfUrl = doc.getString("pdfUrl")
                val rawPdfDriveUrl = doc.getString("pdfDriveUrl")
                val effectivePdfUrl = rawPdfUrl?.takeIf { it.isNotBlank() } ?: rawPdfDriveUrl?.takeIf { it.isNotBlank() }

                RemoteBook(
                    id = doc.id,
                    title = doc.getString("title") ?: "Untitled",
                    subtitle = doc.getString("subtitle"),
                    author = doc.getString("author"),
                    translator = doc.getString("translator"),
                    tagline = doc.getString("tagline"),
                    category = doc.getString("category") ?: "আত্মউন্নয়ন",
                    language = doc.getString("language") ?: "Bangla",
                    audioUrl = doc.getString("audioUrl"),
                    summaryMdUrl = doc.getString("summaryMdUrl"),
                    summaryMdPath = doc.getString("summaryMdPath"),
                    summaryFilename = doc.getString("summaryFilename"),
                    fullBookMdUrl = doc.getString("fullBookMdUrl"),
                    fullBookMdPath = doc.getString("fullBookMdPath"),
                    fullBookFilename = doc.getString("fullBookFilename"),
                    pdfUrl = effectivePdfUrl,
                    pdfDriveUrl = rawPdfDriveUrl,
                    pdfPath = doc.getString("pdfPath"),
                    pdfFilename = doc.getString("pdfFilename"),
                    coverUrl = doc.getString("coverUrl"),
                    coverPath = doc.getString("coverPath"),
                    summarySnippet = doc.getString("summarySnippet"),
                    totalWords = doc.getLong("totalWords")?.toInt() ?: 0,
                    estimatedMinutes = doc.getLong("estimatedMinutes")?.toInt() ?: 1,
                    hasSummary = doc.getBoolean("hasSummary") ?: (!doc.getString("summaryMdUrl").isNullOrBlank() || !doc.getString("summaryMdPath").isNullOrBlank()),
                    hasFullBook = doc.getBoolean("hasFullBook") ?: (!doc.getString("fullBookMdUrl").isNullOrBlank() || !doc.getString("fullBookMdPath").isNullOrBlank()),
                    hasPdf = doc.getBoolean("hasPdf") ?: (!effectivePdfUrl.isNullOrBlank() || !doc.getString("pdfPath").isNullOrBlank()),
                    slug = doc.getString("slug"),
                    publishedAtIso = doc.getString("publishedAtIso")
                )
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching all books from Firestore: ${e.message}", e)
            emptyList()
        }
    }

    fun listenToAudioBundles(): Flow<List<AudioBundle>> = callbackFlow {
        val listenerRegistration = firestore.collection("bundles")
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Log.e(TAG, "Error listening to bundles: ${error.message}", error)
                    return@addSnapshotListener
                }
                if (snapshot != null) {
                    val list = snapshot.documents.mapNotNull { doc ->
                        val rawBookIds = (doc.get("bookIds") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()
                        val rawBookTitles = (doc.get("bookTitles") as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()

                        AudioBundle(
                            id = doc.id,
                            title = doc.getString("title") ?: "",
                            subtitle = doc.getString("subtitle"),
                            description = doc.getString("description"),
                            coverUrl = doc.getString("coverUrl"),
                            bookIds = rawBookIds,
                            bookTitles = rawBookTitles,
                            bookCount = doc.getLong("bookCount")?.toInt() ?: rawBookTitles.size,
                            originalPrice = doc.getDouble("originalPrice") ?: (doc.getLong("originalPrice")?.toDouble() ?: 0.0),
                            discountedPrice = doc.getDouble("discountedPrice") ?: (doc.getLong("discountedPrice")?.toDouble() ?: 0.0),
                            savingsPercentage = doc.getLong("savingsPercentage")?.toInt() ?: 0,
                            totalDurationHours = doc.getDouble("totalDurationHours") ?: (doc.getLong("totalDurationHours")?.toDouble() ?: 0.0),
                            badge = doc.getString("badge") ?: "বান্ডেল অফার",
                            rating = doc.getDouble("rating") ?: 5.0,
                            reviewCount = doc.getLong("reviewCount")?.toInt() ?: 0,
                            isFeatured = doc.getBoolean("isFeatured") ?: false
                        )
                    }
                    trySend(list)
                }
            }
        awaitClose { listenerRegistration.remove() }
    }

    fun listenToAllBooks(): Flow<List<RemoteBook>> = callbackFlow {
        val listenerRegistration = firestore.collection("books")
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Log.e(TAG, "Error listening to all books: ${error.message}", error)
                    return@addSnapshotListener
                }
                if (snapshot != null) {
                    val list = snapshot.documents.mapNotNull { doc ->
                        val rawPdfUrl = doc.getString("pdfUrl")
                        val rawPdfDriveUrl = doc.getString("pdfDriveUrl")
                        val effectivePdfUrl = rawPdfUrl?.takeIf { it.isNotBlank() } ?: rawPdfDriveUrl?.takeIf { it.isNotBlank() }

                        RemoteBook(
                            id = doc.id,
                            title = doc.getString("title") ?: "Untitled",
                            subtitle = doc.getString("subtitle"),
                            author = doc.getString("author"),
                            translator = doc.getString("translator"),
                            tagline = doc.getString("tagline"),
                            category = doc.getString("category") ?: "আত্মউন্নয়ন",
                            language = doc.getString("language") ?: "Bangla",
                            audioUrl = doc.getString("audioUrl"),
                            summaryMdUrl = doc.getString("summaryMdUrl"),
                            summaryMdPath = doc.getString("summaryMdPath"),
                            summaryFilename = doc.getString("summaryFilename"),
                            fullBookMdUrl = doc.getString("fullBookMdUrl"),
                            fullBookMdPath = doc.getString("fullBookMdPath"),
                            fullBookFilename = doc.getString("fullBookFilename"),
                            pdfUrl = effectivePdfUrl,
                            pdfDriveUrl = rawPdfDriveUrl,
                            pdfPath = doc.getString("pdfPath"),
                            pdfFilename = doc.getString("pdfFilename"),
                            coverUrl = doc.getString("coverUrl"),
                            coverPath = doc.getString("coverPath"),
                            summarySnippet = doc.getString("summarySnippet"),
                            totalWords = doc.getLong("totalWords")?.toInt() ?: 0,
                            estimatedMinutes = doc.getLong("estimatedMinutes")?.toInt() ?: 1,
                            hasSummary = doc.getBoolean("hasSummary") ?: (!doc.getString("summaryMdUrl").isNullOrBlank() || !doc.getString("summaryMdPath").isNullOrBlank()),
                            hasFullBook = doc.getBoolean("hasFullBook") ?: (!doc.getString("fullBookMdUrl").isNullOrBlank() || !doc.getString("fullBookMdPath").isNullOrBlank()),
                            hasPdf = doc.getBoolean("hasPdf") ?: (!effectivePdfUrl.isNullOrBlank() || !doc.getString("pdfPath").isNullOrBlank()),
                            slug = doc.getString("slug"),
                            publishedAtIso = doc.getString("publishedAtIso")
                        )
                    }
                    trySend(list)
                }
            }
        awaitClose { listenerRegistration.remove() }
    }

    /**
     * Real-time flow of the latest active notice to display on the home screen.
     */
    fun getActiveNoticeFlow(): Flow<AppNotice?> = callbackFlow {
        val listenerRegistration = firestore.collection("notices")
            .whereEqualTo("isActive", true)
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Log.w(TAG, "Notice listener error: ${error.message}")
                    trySend(null)
                    return@addSnapshotListener
                }

                if (snapshot == null || snapshot.isEmpty) {
                    trySend(null)
                    return@addSnapshotListener
                }

                val notices = snapshot.documents.mapNotNull { doc ->
                    AppNotice(
                        id = doc.id,
                        title = doc.getString("title") ?: "",
                        message = doc.getString("message") ?: "",
                        isActive = doc.getBoolean("isActive") ?: true,
                        priority = doc.getLong("priority")?.toInt() ?: 1,
                        actionUrl = doc.getString("actionUrl"),
                        createdAt = doc.getLong("createdAt") ?: System.currentTimeMillis(),
                        authorEmail = doc.getString("authorEmail")
                    )
                }.sortedWith(compareByDescending<AppNotice> { it.priority }.thenByDescending { it.createdAt })

                trySend(notices.firstOrNull())
            }
        awaitClose { listenerRegistration.remove() }
    }

    /**
     * Retrieve all notices (active & inactive) for admin management.
     */
    suspend fun getAllNotices(): List<AppNotice> = withContext(Dispatchers.IO) {
        try {
            val snapshot = firestore.collection("notices").get().await()
            snapshot.documents.mapNotNull { doc ->
                AppNotice(
                    id = doc.id,
                    title = doc.getString("title") ?: "",
                    message = doc.getString("message") ?: "",
                    isActive = doc.getBoolean("isActive") ?: true,
                    priority = doc.getLong("priority")?.toInt() ?: 1,
                    actionUrl = doc.getString("actionUrl"),
                    createdAt = doc.getLong("createdAt") ?: System.currentTimeMillis(),
                    authorEmail = doc.getString("authorEmail")
                )
            }.sortedByDescending { it.createdAt }
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching all notices: ${e.message}", e)
            emptyList()
        }
    }

    /**
     * Post a new notice or update an existing one.
     */
    suspend fun postNotice(notice: AppNotice): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val docRef = if (notice.id.isBlank()) {
                firestore.collection("notices").document()
            } else {
                firestore.collection("notices").document(notice.id)
            }

            val data = hashMapOf(
                "title" to notice.title,
                "message" to notice.message,
                "isActive" to notice.isActive,
                "priority" to notice.priority,
                "actionUrl" to notice.actionUrl,
                "createdAt" to if (notice.createdAt > 0) notice.createdAt else System.currentTimeMillis(),
                "authorEmail" to notice.authorEmail
            )

            docRef.set(data).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Log.e(TAG, "Error posting notice: ${e.message}", e)
            Result.failure(e)
        }
    }

    /**
     * Toggle the active status of a notice.
     */
    suspend fun updateNoticeStatus(id: String, isActive: Boolean): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            firestore.collection("notices").document(id)
                .update("isActive", isActive)
                .await()
            Result.success(Unit)
        } catch (e: Exception) {
            Log.e(TAG, "Error updating notice status: ${e.message}", e)
            Result.failure(e)
        }
    }

    /**
     * Delete a notice.
     */
    suspend fun deleteNotice(id: String): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            firestore.collection("notices").document(id)
                .delete()
                .await()
            Result.success(Unit)
        } catch (e: Exception) {
            Log.e(TAG, "Error deleting notice: ${e.message}", e)
            Result.failure(e)
        }
    }
}

