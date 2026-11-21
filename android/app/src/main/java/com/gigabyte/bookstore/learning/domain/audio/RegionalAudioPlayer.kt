package com.gigabyte.bookstore.learning.domain.audio

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.PlaybackParams
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume

/**
 * Plays authentic pre-recorded Regional Bengali dialect audio (`MediaPlayer` + pitch-preserving speed control).
 * Looks up bundled offline assets first (`assets/regional_audio/{audioRef}.mp3`),
 * then disk cache (`filesDir/regional_audio/{audioRef}.mp3`), downloading & caching
 * transparently via OkHttp on first playback.
 */
class RegionalAudioPlayer(private val context: Context) {

    private val client = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()

    @Volatile
    private var activePlayer: MediaPlayer? = null

    private fun cacheDir(): File =
        File(context.filesDir, "regional_audio").apply { mkdirs() }

    private fun cacheFile(audioRef: String): File =
        File(cacheDir(), "$audioRef.mp3")

    private fun assetPath(audioRef: String): String =
        "regional_audio/$audioRef.mp3"

    /**
     * Attempts to play authentic native regional recording for [audioRef] at [rate].
     * Returns `true` if authentic regional audio played cleanly; `false` if unavailable.
     */
    suspend fun playItem(audioRef: String, rate: Float): Boolean {
        val assetFd = withContext(Dispatchers.IO) {
            runCatching { context.assets.openFd(assetPath(audioRef)) }.getOrNull()
        }

        if (assetFd != null) {
            return assetFd.use { fd ->
                playFromSource(rate) { player ->
                    player.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
                }
            }
        }

        val cached = ensureCached(audioRef) ?: return false
        return playFromSource(rate) { player ->
            player.setDataSource(cached.absolutePath)
        }
    }

    /** Downloads & caches all regional dialect MP3s for a lesson in the background. */
    suspend fun prefetch(audioRefs: List<String>) = withContext(Dispatchers.IO) {
        for (ref in audioRefs) {
            val hasAsset = runCatching { context.assets.openFd(assetPath(ref)).close(); true }.getOrDefault(false)
            if (!hasAsset) {
                ensureCached(ref)
            }
        }
    }

    private suspend fun ensureCached(audioRef: String): File? = withContext(Dispatchers.IO) {
        val target = cacheFile(audioRef)
        if (target.exists() && target.length() > 512L) return@withContext target

        val url = RegionalAudioCatalog.buildAudioUrl(audioRef)
        val tmp = File(target.parentFile, "$audioRef.mp3.tmp")
        val ok = runCatching {
            val request = Request.Builder().url(url).build()
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) return@use false
                val body = response.body ?: return@use false
                tmp.outputStream().use { out ->
                    body.byteStream().copyTo(out)
                }
                if (tmp.length() > 512L) {
                    tmp.renameTo(target)
                } else {
                    tmp.delete()
                    false
                }
            }
        }.getOrElse {
            tmp.delete()
            false
        }
        if (ok && target.exists()) target else null
    }

    private suspend fun playFromSource(
        rate: Float,
        configureSource: (MediaPlayer) -> Unit
    ): Boolean {
        stop()

        return suspendCancellableCoroutine { continuation ->
            val player = MediaPlayer().apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
            }
            activePlayer = player

            continuation.invokeOnCancellation {
                runCatching {
                    if (player.isPlaying) player.stop()
                    player.release()
                }
                if (activePlayer === player) activePlayer = null
            }

            var resumed = false
            fun safeResume(result: Boolean) {
                if (resumed) return
                resumed = true
                if (activePlayer === player) activePlayer = null
                runCatching { player.release() }
                if (continuation.isActive) continuation.resume(result)
            }

            try {
                configureSource(player)
                player.setOnPreparedListener { mp ->
                    runCatching {
                        val clampedRate = rate.coerceIn(0.5f, 2.0f)
                        val params = mp.playbackParams
                        params.speed = clampedRate
                        params.pitch = 1.0f
                        mp.playbackParams = params
                    }
                    mp.start()
                }
                player.setOnCompletionListener {
                    safeResume(true)
                }
                player.setOnErrorListener { _, _, _ ->
                    safeResume(false)
                    true
                }
                player.prepareAsync()
            } catch (_: Throwable) {
                safeResume(false)
            }
        }
    }

    fun stop() {
        val player = activePlayer ?: return
        activePlayer = null
        runCatching {
            if (player.isPlaying) player.stop()
            player.release()
        }
    }
}
