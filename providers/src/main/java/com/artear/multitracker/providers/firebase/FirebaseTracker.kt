package com.artear.multitracker.providers.firebase

import android.content.Context
import com.artear.multitracker.ContextTracker
import com.artear.multitracker.contract.send.TrackerSend
import com.google.firebase.analytics.FirebaseAnalytics
import timber.log.Timber

class FirebaseTracker(context: Context) : ContextTracker(context) {

    private val mFireBaseAnalytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(context)

    override fun send(params: TrackerSend) {
        when (params) {
            is FirebaseEvent -> mFireBaseAnalytics.logEvent(params.firebaseEvent, params.firebaseBundle)
            is FirebaseView -> mFireBaseAnalytics.logEvent(params.firebaseViewName, params.firebaseBundle)
            else -> Timber.d("The params when call send in firebase tracker %s",
                    "must implements FirebaseEvent or FirebaseView")
        }
    }

    override fun onResume() {}

    override fun onPause() {}

    override fun onDestroy() {

    }


}
