package com.gigabyte.bookstore.data.repository

import android.util.Log
import com.gigabyte.bookstore.data.models.AudioBundle
import com.gigabyte.bookstore.data.models.Course
import com.gigabyte.bookstore.data.models.CourseLesson
import com.gigabyte.bookstore.data.models.CourseModule
import com.gigabyte.bookstore.data.models.HeroBanner
import com.gigabyte.bookstore.data.models.RemoteBook
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
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
}
