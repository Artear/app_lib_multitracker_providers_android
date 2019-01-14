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
