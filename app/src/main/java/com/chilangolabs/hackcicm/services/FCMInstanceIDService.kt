package com.chilangolabs.hackcicm.services

import com.chilangolabs.hackcicm.utils.logd
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

/**
 * @author gorrotowi
 * @since 03/03/18.
 */
class FCMInstanceIDService : FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
        super.onTokenRefresh()
        val refreshedToken = FirebaseInstanceId.getInstance().token
        logd("Refreshed Token $refreshedToken")
        //SendToken to Server
    }

}