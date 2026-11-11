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
 * Plays authentic Male Qari Quran Tilawat (`MediaPlayer` + pitch-preserving speed control).
 * Looks up bundled offline assets first (`assets/quran_audio/{reciter}/{surahAyah}.mp3`),
 * then disk cache (`filesDir/quran_audio/{reciter}/{surahAyah}.mp3`), downloading & caching
 * transparently via OkHttp on first playback.
 */
class QuranRecitationPlayer(private val context: Context) {

    private val client = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()

    @Volatile
    private var activePlayer: MediaPlayer? = null

    private fun cacheDir(reciter: QuranReciter): File =
        File(context.filesDir, "quran_audio/${reciter.id}").apply { mkdirs() }

    private fun cacheFile(reciter: QuranReciter, surahAyah: String): File =
        File(cacheDir(reciter), "$surahAyah.mp3")

    private fun assetPath(reciter: QuranReciter, surahAyah: String): String =
        "quran_audio/${reciter.id}/$surahAyah.mp3"

    /**
     * Attempts to play real Male Qari Tilawat for [surahAyah] at [rate].
     * Returns `true` if real Qari audio played cleanly; `false` if unavailable (caller falls back to Male TTS).
     */
    suspend fun playAyah(surahAyah: String, reciter: QuranReciter, rate: Float): Boolean {
        val assetFd = withContext(Dispatchers.IO) {
            runCatching { context.assets.openFd(assetPath(reciter, surahAyah)) }.getOrNull()
        }

        if (assetFd != null) {
            return assetFd.use { fd ->
                playFromSource(rate) { player ->
                    player.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
                }
            }
        }

        val cached = ensureCached(surahAyah, reciter) ?: return false
        return playFromSource(rate) { player ->
            player.setDataSource(cached.absolutePath)
        }
    }

    /** Downloads & caches all Ayah MP3s for a lesson in the background. */
    suspend fun prefetch(surahAyahs: List<String>, reciter: QuranReciter) = withContext(Dispatchers.IO) {
        for (ref in surahAyahs) {
            val hasAsset = runCatching { context.assets.openFd(assetPath(reciter, ref)).close(); true }.getOrDefault(false)
            if (!hasAsset) {
                ensureCached(ref, reciter)
            }
        }
    }

    private suspend fun ensureCached(surahAyah: String, reciter: QuranReciter): File? = withContext(Dispatchers.IO) {
        val target = cacheFile(reciter, surahAyah)
        if (target.exists() && target.length() > 1024L) return@withContext target

        val url = QuranAudioCatalog.buildEveryAyahUrl(reciter, surahAyah)
        val tmp = File(target.parentFile, "$surahAyah.mp3.tmp")
        val ok = runCatching {
            val request = Request.Builder().url(url).build()
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) return@use false
                val body = response.body ?: return@use false
                tmp.outputStream().use { out ->
                    body.byteStream().copyTo(out)
                }
                if (tmp.length() > 1024L) {
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

    private suspend fun playFromSource(rate: Float, configure: (MediaPlayer) -> Unit): Boolean {
        stop()
        val result = withTimeoutOrNull(45_000L) {
            suspendCancellableCoroutine<Boolean> { cont ->
                val player = MediaPlayer()
                activePlayer = player
                var settled = false

                fun finish(success: Boolean) {
                    if (!settled) {
                        settled = true
                        releasePlayer(player)
                        if (cont.isActive) cont.resume(success)
                    }
                }

                runCatching {
                    player.setAudioAttributes(
                        AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_MEDIA)
                            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                            .build()
                    )
                    configure(player)
                    player.setOnPreparedListener { mp ->
                        runCatching {
                            val clamped = rate.coerceIn(0.60f, 1.40f)
                            mp.playbackParams = PlaybackParams().setSpeed(clamped).setPitch(1.0f)
                        }
                        runCatching { mp.start() }.onFailure { finish(false) }
                    }
                    player.setOnCompletionListener { finish(true) }
                    player.setOnErrorListener { _, _, _ ->
                        finish(false)
                        true
                    }
                    cont.invokeOnCancellation { finish(false) }
                    player.prepareAsync()
                }.onFailure {
                    finish(false)
                }
            }
        }
        return result == true
    }

    fun stop() {
        val current = activePlayer
        activePlayer = null
        if (current != null) releasePlayer(current)
    }

    private fun releasePlayer(player: MediaPlayer) {
        if (activePlayer === player) activePlayer = null
        runCatching { if (player.isPlaying) player.stop() }
        runCatching { player.reset() }
        runCatching { player.release() }
    }
}
