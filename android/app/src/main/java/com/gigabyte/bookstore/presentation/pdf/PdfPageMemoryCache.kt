package com.gigabyte.bookstore.presentation.pdf

import android.graphics.Bitmap
import android.util.LruCache
import java.util.concurrent.ConcurrentHashMap

/**
 * Thread-safe bounded LRU memory cache for rendered PDF pages.
 * Prevents OutOfMemoryError by limiting in-memory bitmaps and recycling evicted bitmaps.
 */
class PdfPageMemoryCache(
    maxMemoryKb: Int = ((Runtime.getRuntime().maxMemory() / 1024) / 8).toInt().coerceIn(16 * 1024, 48 * 1024)
) {
    private val bitmapCache = object : LruCache<Int, Bitmap>(maxMemoryKb) {
        override fun sizeOf(key: Int, value: Bitmap): Int {
            return (value.byteCount / 1024).coerceAtLeast(1)
        }

        override fun entryRemoved(evicted: Boolean, key: Int, oldValue: Bitmap, newValue: Bitmap?) {
            super.entryRemoved(evicted, key, oldValue, newValue)
            // Recycle bitmap only if it was evicted by cache capacity and not replaced by itself
            if (evicted && oldValue != newValue && !oldValue.isRecycled) {
                oldValue.recycle()
            }
        }
    }

    private val aspectRatios = ConcurrentHashMap<Int, Float>()

    fun get(pageIndex: Int): Bitmap? {
        synchronized(bitmapCache) {
            val bmp = bitmapCache.get(pageIndex)
            return if (bmp != null && !bmp.isRecycled) bmp else null
        }
    }

    fun put(pageIndex: Int, bitmap: Bitmap) {
        if (!bitmap.isRecycled) {
            synchronized(bitmapCache) {
                bitmapCache.put(pageIndex, bitmap)
            }
        }
    }

    fun getAspectRatio(pageIndex: Int): Float? {
        return aspectRatios[pageIndex]
    }

    fun setAspectRatio(pageIndex: Int, ratio: Float) {
        aspectRatios[pageIndex] = ratio
    }

    fun clear() {
        synchronized(bitmapCache) {
            bitmapCache.evictAll()
        }
        aspectRatios.clear()
    }
}
