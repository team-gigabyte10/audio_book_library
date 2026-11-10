package com.gigabyte.bookstore.learning

import com.squareup.moshi.Moshi
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class BnPronScriptPurityTest {

    @Suppress("UNCHECKED_CAST")
    @Test
    fun `all course assets must have pure Bengali pronunciation without foreign script leaks`() {
        val assetsDir = File("src/main/assets")
        val jsonFiles = assetsDir.listFiles { _, name -> name.startsWith("spoken_") && name.endsWith(".json") }
            ?: emptyArray()

        assertTrue("Asset json files must exist", jsonFiles.isNotEmpty())

        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(Map::class.java)

        val violations = mutableListOf<String>()

        for (file in jsonFiles) {
            val jsonStr = file.readText(Charsets.UTF_8)
            val root = adapter.fromJson(jsonStr) as? Map<String, Any> ?: continue
            val parts = root["parts"] as? List<Map<String, Any>> ?: continue

            val isJpStd = file.name.contains("japanese_standard_n")
            val isUrStdA1 = file.name == "spoken_urdu_standard_a1.json"

            for (part in parts) {
                val lessons = part["lessons"] as? List<Map<String, Any>> ?: continue
                for (lesson in lessons) {
                    val items = lesson["items"] as? List<Map<String, Any>> ?: continue
                    for (item in items) {
                        val pron = item["bn_pron"] as? String ?: continue
                        val checkStr = if ((isJpStd || isUrStdA1) && pron.contains(" · ")) {
                            pron.substringAfter(" · ")
                        } else {
                            pron
                        }

                        for (ch in checkStr) {
                            val code = ch.code
                            // Bengali range: 0x0980..0x09FF
                            // Dari: 0x09F7
                            // Standard ascii space / punctuation: 0x20..0x7E
                            // Allowed typographical punctuation: 0x200C, 0x200D, 0x2018..0x201D, 0x2013, 0x2014, 0x00B7, 0x2022
                            val isAllowed = (code in 0x0980..0x09FF) ||
                                (code in 0x20..0x7E) ||
                                code == 0x09F7 ||
                                code == 0x200C || code == 0x200D ||
                                (code in 0x2018..0x201D) ||
                                code == 0x2013 || code == 0x2014 ||
                                code == 0x00B7 || code == 0x2022

                            if (!isAllowed) {
                                violations.add("${file.name} item ${item["id"]}: bad char '$ch' (0x${code.toString(16)}) in '$pron'")
                            }
                        }
                    }
                }
            }
        }

        assertTrue(
            "Found ${violations.size} bn_pron script purity violations:\n" + violations.take(15).joinToString("\n"),
            violations.isEmpty()
        )
    }
}

