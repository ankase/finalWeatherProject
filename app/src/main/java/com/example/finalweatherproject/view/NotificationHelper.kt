package com.example.finalweatherproject.view


import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.finalweatherproject.R
import com.example.finalweatherproject.entity.ForecastEntity
import com.example.finalweatherproject.view.MainActivity
import java.util.*

object NotificationHelper {
    val mIntent = Intent(context, MainActivity::class.java)

    val pendingIntent =
        PendingIntent.getActivity(context, 0, mIntent, PendingIntent.FLAG_UPDATE_CURRENT)

    fun createNotification(context: Context, forecast:ForecastEntity) {
        val builder = NotificationCompat.Builder(context!!, NotificationConstants.CHANNEL_ID).apply {
            setSmallIcon(R.drawable.ic_baseline_bubble_chart_24)
            setContentTitle("Погода сегодня")
            setContentText(forecast.city)
            priority = NotificationCompat.PRIORITY_DEFAULT
            setContentIntent(pendingIntent)
            setAutoCancel(true)
        }

        val notificationManager = NotificationManagerCompat.from(context)



    }
}