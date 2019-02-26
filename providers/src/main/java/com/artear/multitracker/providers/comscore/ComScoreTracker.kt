/*
 * Copyright 2019 Artear S.A.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.artear.multitracker.providers.comscore

import android.content.Context
import com.artear.multitracker.ContextTracker
import com.artear.multitracker.contract.send.TrackerSend
import com.artear.tools.android.log.logD
import com.comscore.Analytics
import com.comscore.PublisherConfiguration
import com.comscore.UsagePropertiesAutoUpdateMode

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
            else -> logD {
                "The params when call send in comscore tracker " +
                        "must implements ComScoreEvent or ComScoreView"
            }
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