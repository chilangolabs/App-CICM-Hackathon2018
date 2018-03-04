package com.chilangolabs.hackcicm.services

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import com.chilangolabs.hackcicm.R
import com.chilangolabs.hackcicm.activitys.ReportDetailActivity
import com.chilangolabs.hackcicm.utils.loge
import com.chilangolabs.hackcicm.utils.logi
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * @author gorrotowi
 * @since 03/03/18.
 */
class FCMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        loge("From: ${remoteMessage?.from}")

        remoteMessage?.let {
            logi("${it.to}")
            logi("${it.notification?.title}")
            logi("${it.notification?.body}")
        }

        remoteMessage?.data?.let {
            logi("Message: $it")
            sendNotification(remoteMessage)
        }

    }

    private fun sendNotification(messageBody: RemoteMessage) {
        //TODO("Make intent for PushNotification")
        loge(messageBody.data)
        val intent = Intent(this, ReportDetailActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        val pendingIntent = PendingIntent.getActivity(this, System.currentTimeMillis().toInt(), intent, PendingIntent.FLAG_ONE_SHOT)

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val builder = NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setColor(resources.getColor(R.color.background_material_light))
                .setContentTitle(messageBody.notification?.title)
                .setContentText(messageBody.notification?.body)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
        val bigNotification = NotificationCompat.BigTextStyle(builder)
                .bigText(messageBody.notification?.body)
                .build()

        val notifManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notifManager.notify(System.currentTimeMillis().toInt() /* ID of notification */, bigNotification)

    }

}