package com.gigabyte.bookstore.data.repository

import android.content.Context
import com.gigabyte.bookstore.data.models.MotivationalCategory
import com.gigabyte.bookstore.data.models.MotivationalStory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.util.concurrent.atomic.AtomicReference

class MotivationalStoryRepository(private val context: Context) {

    private val cachedStories = AtomicReference<List<MotivationalStory>?>(null)

    suspend fun getAllStories(): List<MotivationalStory> = withContext(Dispatchers.IO) {
        val cached = cachedStories.get()
        if (cached != null) return@withContext cached

        val list = mutableListOf<MotivationalStory>()
        try {
            val jsonString = context.assets.open("motivational_stories_50.json").bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(jsonString)
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                list.add(
                    MotivationalStory(
                        id = obj.optString("id", "ms_$i"),
                        order = obj.optInt("order", i + 1),
                        title = obj.optString("title", "অনুপ্রেরণার গল্প ${i + 1}"),
                        category = obj.optString("category", "ব্যর্থতা জয় ও উদ্ভাবন"),
                        categorySlug = obj.optString("categorySlug", "failure_to_success"),
                        categoryIcon = obj.optString("categoryIcon", "🚀"),
                        content = obj.optString("content", ""),
                        wordCount = obj.optInt("wordCount", 0),
                        readingMinutes = obj.optInt("readingMinutes", 2)
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        cachedStories.set(list)
        list
    }

    suspend fun getCategories(): List<MotivationalCategory> = withContext(Dispatchers.IO) {
        val stories = getAllStories()
        val total = stories.size

        val categoryOrder = listOf(
            Triple("all", "সব গল্প", "🔥"),
            Triple("failure_to_success", "ব্যর্থতা জয় ও উদ্ভাবন", "🚀"),
            Triple("overcoming_odds", "প্রতিবন্ধকতা জয় ও ইচ্ছাশক্তি", "🧗"),
            Triple("never_give_up", "অধ্যবসায় ও সংকল্প", "💪"),
            Triple("poverty_to_pinnacle", "দারিদ্র্য থেকে শীর্ষ শিখরে", "🌟"),
            Triple("heart_touching_lessons", "হৃদয়স্পর্শী জীবনশিক্ষা", "💖")
        )

        categoryOrder.map { (slug, name, icon) ->
            val count = if (slug == "all") total else stories.count { it.categorySlug == slug }
            MotivationalCategory(
                slug = slug,
                name = name,
                icon = icon,
                storyCount = count
            )
        }
    }

    suspend fun getStoryById(id: String): MotivationalStory? = withContext(Dispatchers.IO) {
        getAllStories().find { it.id == id }
    }
}
