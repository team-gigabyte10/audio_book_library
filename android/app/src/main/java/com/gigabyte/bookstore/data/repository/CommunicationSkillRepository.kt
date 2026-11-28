package com.gigabyte.bookstore.data.repository

import android.content.Context
import com.gigabyte.bookstore.data.models.CommunicationCategory
import com.gigabyte.bookstore.data.models.CommunicationSkill
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.util.concurrent.atomic.AtomicReference

class CommunicationSkillRepository(private val context: Context) {

    private val cachedSkills = AtomicReference<List<CommunicationSkill>?>(null)

    suspend fun getAllSkills(): List<CommunicationSkill> = withContext(Dispatchers.IO) {
        val cached = cachedSkills.get()
        if (cached != null) return@withContext cached

        val list = mutableListOf<CommunicationSkill>()
        try {
            val jsonString = context.assets.open("communication_skills.json").bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(jsonString)
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                list.add(
                    CommunicationSkill(
                        id = obj.optString("id", "comm_$i"),
                        order = obj.optInt("order", i + 1),
                        title = obj.optString("title", ""),
                        category = obj.optString("category", "মানুষের মন জয় করার ভিত্তি"),
                        categorySlug = obj.optString("categorySlug", "foundations"),
                        categoryIcon = obj.optString("categoryIcon", "💖"),
                        ruleQuote = obj.optString("ruleQuote", ""),
                        summary = obj.optString("summary", ""),
                        content = obj.optString("content", ""),
                        actionStep = obj.optString("actionStep", ""),
                        readingMinutes = obj.optInt("readingMinutes", 3)
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        cachedSkills.set(list)
        list
    }

    suspend fun getCategories(): List<CommunicationCategory> = withContext(Dispatchers.IO) {
        val skills = getAllSkills()
        val groups = skills.groupBy { it.categorySlug }
        val categoryOrder = listOf(
            Triple("foundations", "মানুষের মন জয় করার ভিত্তি", "💖"),
            Triple("conversation", "আকর্ষণীয় কথোপকথন ও চার্ম", "🗣️"),
            Triple("persuasion", "মতের অমিল ও মানুষকে বোঝানো", "🤝"),
            Triple("workplace", "কর্মক্ষেত্র ও নেতৃত্ব দক্ষতা", "💼"),
            Triple("relationships", "পারিবারিক ও সামাজিক সম্পর্ক", "🌱"),
            Triple("tough_situations", "উপস্থিত বুদ্ধি ও আত্মমর্যাদা", "🧠")
        )

        categoryOrder.map { (slug, name, icon) ->
            val count = groups[slug]?.size ?: 0
            CommunicationCategory(
                slug = slug,
                name = name,
                icon = icon,
                count = count
            )
        }
    }

    suspend fun getSkillById(id: String): CommunicationSkill? = withContext(Dispatchers.IO) {
        getAllSkills().find { it.id == id }
    }
}
