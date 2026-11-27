package com.gigabyte.bookstore.data.repository

import android.content.Context
import com.gigabyte.bookstore.data.models.HashirGolpoCategory
import com.gigabyte.bookstore.data.models.HashirGolpoStory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.util.concurrent.atomic.AtomicReference

class HashirGolpoRepository(private val context: Context) {

    private val cachedStories = AtomicReference<List<HashirGolpoStory>?>(null)

    suspend fun getAllStories(): List<HashirGolpoStory> = withContext(Dispatchers.IO) {
        val cached = cachedStories.get()
        if (cached != null) return@withContext cached

        val list = mutableListOf<HashirGolpoStory>()
        try {
            val jsonString = context.assets.open("hashir_golpo_50.json").bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(jsonString)
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                list.add(
                    HashirGolpoStory(
                        id = obj.optString("id", "hg_$i"),
                        order = obj.optInt("order", i + 1),
                        title = obj.optString("title", "গল্প ${i + 1}"),
                        category = obj.optString("category", "লোকজ হাস্যরস"),
                        categorySlug = obj.optString("categorySlug", "folklore_humor"),
                        categoryIcon = obj.optString("categoryIcon", "😂"),
                        content = obj.optString("content", ""),
                        wordCount = obj.optInt("wordCount", 0),
                        readingMinutes = obj.optInt("readingMinutes", 1)
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        cachedStories.set(list)
        list
    }

    suspend fun getCategories(): List<HashirGolpoCategory> = withContext(Dispatchers.IO) {
        val stories = getAllStories()
        val total = stories.size

        val categoryOrder = listOf(
            Triple("all", "সব গল্প", "😂"),
            Triple("gopal_bhar", "গোপাল ভাঁড়", "👑"),
            Triple("mullah_nasruddin", "মোল্লা নাসিরুদ্দীন", "👳"),
            Triple("birbal_akbar", "বীরবল ও আকবর", "🏛️"),
            Triple("boltu_humor", "বল্টু ও কৌতুক", "🎒"),
            Triple("folklore_humor", "লোকজ হাস্যরস", "🌾")
        )

        categoryOrder.map { (slug, name, icon) ->
            val count = if (slug == "all") total else stories.count { it.categorySlug == slug }
            HashirGolpoCategory(
                slug = slug,
                name = name,
                icon = icon,
                storyCount = count
            )
        }
    }

    suspend fun getStoryById(id: String): HashirGolpoStory? = withContext(Dispatchers.IO) {
        getAllStories().find { it.id == id }
    }
}
