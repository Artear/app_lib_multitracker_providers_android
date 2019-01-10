package com.artear.multitracker.providers.comscore

import android.content.Context
import com.artear.multitracker.ContextTracker
import com.artear.multitracker.contract.send.TrackerSend
import com.comscore.Analytics
import com.comscore.PublisherConfiguration
import com.comscore.UsagePropertiesAutoUpdateMode
import timber.log.Timber

class ComsCoreTracker(context: Context, credentials: ComscoreCredentials) : ContextTracker(context) {

    companion object {
        private val LABEL_NS_SITE = "ns_site"
    }

    init {

        val publisher = PublisherConfiguration.Builder()
                .publisherId(credentials.publisherId)
                .publisherSecret(credentials.publisherSecret)
                .applicationName(credentials.applicationName)
                .usagePropertiesAutoUpdateMode(UsagePropertiesAutoUpdateMode.FOREGROUND_ONLY)
                .keepAliveMeasurement(true)
                .build()

        Analytics.getConfiguration().addClient(publisher)
        Analytics.getConfiguration().setPersistentLabel(LABEL_NS_SITE, credentials.persistentLabel)
        Analytics.start(context)
    }

    override fun send(params: TrackerSend) {
        when (params) {
            is ComScoreEvent -> Analytics.notifyViewEvent(params.comScoreMap)
            is ComScoreView -> Analytics.notifyViewEvent(params.comScoreMap)
            else -> Timber.d("The params when call send in comscore tracker %s",
                    "must implements ComScoreEvent or ComScoreView")
        }
    }

    override fun onResume() {
        Analytics.notifyEnterForeground()
    }

    override fun onPause() {
        Analytics.notifyExitForeground()
    }

    override fun onDestroy() {

    }

}