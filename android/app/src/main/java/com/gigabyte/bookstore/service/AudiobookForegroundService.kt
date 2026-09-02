package com.gigabyte.bookstore.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.gigabyte.bookstore.BanglaAudiobookApp
import com.gigabyte.bookstore.MainActivity

import android.content.pm.ServiceInfo

class AudiobookForegroundService : Service() {

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.action

        val app = application as? BanglaAudiobookApp
        val player = app?.player

        when (action) {
            ACTION_PLAY_PAUSE -> {
                player?.togglePlayPause()
            }
            ACTION_PREVIOUS -> {
                player?.previousChapter()
            }
            ACTION_NEXT -> {
                player?.nextChapter()
            }
            ACTION_STOP -> {
                player?.pause()
                stopForeground(STOP_FOREGROUND_REMOVE)
                stopSelf()
                return START_NOT_STICKY
            }
            ACTION_UPDATE, null -> {
                // Just update notification
            }
        }

        val title = intent?.getStringExtra("TITLE")
            ?: player?.playbackState?.value?.bookTitle
            ?: "বাংলা অডিওবুক"
        val chapter = intent?.getStringExtra("CHAPTER")
            ?: player?.playbackState?.value?.chapterTitle
            ?: "অধ্যায়"
        val isPlaying = intent?.getBooleanExtra("IS_PLAYING", player?.playbackState?.value?.isPlaying ?: false)
            ?: false

        val notification = buildNotification(title, chapter, isPlaying)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            startForeground(
                NOTIFICATION_ID,
                notification,
                ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK
            )
        } else {
            startForeground(NOTIFICATION_ID, notification)
        }

        return START_STICKY
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
        val app = application as? BanglaAudiobookApp
        val isPlaying = app?.player?.playbackState?.value?.isPlaying ?: false
        if (!isPlaying) {
            stopForeground(STOP_FOREGROUND_REMOVE)
            stopSelf()
        }
    }

    private fun buildNotification(title: String, chapter: String, isPlaying: Boolean): Notification {
        val openAppIntent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        val openAppPendingIntent = PendingIntent.getActivity(
            this, 0, openAppIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val prevIntent = Intent(this, AudiobookForegroundService::class.java).apply {
            action = ACTION_PREVIOUS
        }
        val prevPendingIntent = PendingIntent.getService(
            this, 1, prevIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val playPauseIntent = Intent(this, AudiobookForegroundService::class.java).apply {
            action = ACTION_PLAY_PAUSE
        }
        val playPausePendingIntent = PendingIntent.getService(
            this, 2, playPauseIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val nextIntent = Intent(this, AudiobookForegroundService::class.java).apply {
            action = ACTION_NEXT
        }
        val nextPendingIntent = PendingIntent.getService(
            this, 3, nextIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val stopIntent = Intent(this, AudiobookForegroundService::class.java).apply {
            action = ACTION_STOP
        }
        val stopPendingIntent = PendingIntent.getService(
            this, 4, stopIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val playPauseIcon = if (isPlaying) {
            android.R.drawable.ic_media_pause
        } else {
            android.R.drawable.ic_media_play
        }
        val playPauseTitle = if (isPlaying) "বিরতি" else "শুনুন"

        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(chapter)
            .setSubText("বাংলা অডিওবুক")
            .setSmallIcon(android.R.drawable.ic_media_play)
            .setContentIntent(openAppPendingIntent)
            .setDeleteIntent(stopPendingIntent)
            .setOngoing(isPlaying)
            .setOnlyAlertOnce(true)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .addAction(android.R.drawable.ic_media_previous, "আগেরটি", prevPendingIntent)
            .addAction(playPauseIcon, playPauseTitle, playPausePendingIntent)
            .addAction(android.R.drawable.ic_media_next, "পরেরটি", nextPendingIntent)
            .addAction(android.R.drawable.ic_delete, "✕ বন্ধ", stopPendingIntent)
            .build()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Bangla Audiobook Playback",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "বাংলা অডিওবুক প্লেয়ার নোটিফিকেশন"
                setShowBadge(false)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

    companion object {
        const val NOTIFICATION_ID = 1001
        const val CHANNEL_ID = "bangla_audiobook_channel"

        const val ACTION_PLAY_PAUSE = "com.gigabyte.bookstore.ACTION_PLAY_PAUSE"
        const val ACTION_PREVIOUS = "com.gigabyte.bookstore.ACTION_PREVIOUS"
        const val ACTION_NEXT = "com.gigabyte.bookstore.ACTION_NEXT"
        const val ACTION_STOP = "com.gigabyte.bookstore.ACTION_STOP"
        const val ACTION_UPDATE = "com.gigabyte.bookstore.ACTION_UPDATE"
    }
}
