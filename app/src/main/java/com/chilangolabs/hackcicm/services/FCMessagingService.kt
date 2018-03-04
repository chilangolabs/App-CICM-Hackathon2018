package com.chilangolabs.hackcicm.services

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

        remoteMessage?.data?.let {
            logi("Message: $it")
            sendNotification(remoteMessage)
        }

    }

    private fun sendNotification(messageBody: RemoteMessage) {
        //TODO("Make intent for PushNotification")
        loge(messageBody.data)
//        val intent = Intent(this, TransferActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
//        val pendingIntent = PendingIntent.getActivity(this, System.currentTimeMillis().toInt(), intent, PendingIntent.FLAG_ONE_SHOT)
//
//        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
//
//        val builder = NotificationCompat.Builder(this)
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setColor(resources.getColor(R.color.background_material_light))
//                .setContentTitle(getString(R.string.app_name))
//                .setContentText(messageBody.data["body"])
//                .setAutoCancel(true)
//                .setSound(defaultSoundUri)
//                .setContentIntent(pendingIntent)
//        val bigNotification = NotificationCompat.BigTextStyle(builder)
//                .bigText(messageBody.data["body"])
//                .build()
//
//        val notifManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        notifManager.notify(System.currentTimeMillis().toInt() /* ID of notification */, bigNotification)

    }

}