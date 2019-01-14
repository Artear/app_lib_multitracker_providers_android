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
package com.artear.multitracker.providers

import android.content.Context
import com.artear.multitracker.MultiTracker
import com.artear.multitracker.contract.tracker.Tracker
import com.artear.multitracker.providers.event.ScreenEvent
import com.artear.multitracker.providers.event.StorageEvent
import com.artear.tools.AndroidUtils
import com.artear.tools.preferences.PrefsHelper
import com.artear.tools.preferences.StringPreference
import com.artear.tools.screen.ScreenUtils
import java.text.SimpleDateFormat
import java.util.*

const val YYYY_MM_DD = "yyyyMMdd"

fun MultiTracker.init(context: Context, prefsHelper: PrefsHelper) {
    val dailyMetricPreference = prefsHelper.getStringPreference(DailyPrefsKeys.DAILY_METRIC)

    val todayDate = getTodayFormatted()

    if (needsTodayUpdate(dailyMetricPreference, todayDate)) {
        dailyMetricPreference.set(todayDate)

        send(ScreenEvent(ScreenUtils.getScreenMinWidth(context),
                ScreenUtils.getScreenMaxHeight(context),
                context.resources.displayMetrics))

        send(StorageEvent(AndroidUtils.isInstalledOnSdCard(context)))
    }
}

fun MultiTracker.register(trackers: Set<Tracker>){
    trackers.forEach { register(it) }
}

private fun getTodayFormatted(): String {
    return SimpleDateFormat(YYYY_MM_DD, Locale.ENGLISH).format(Date())
}

private fun needsTodayUpdate(dailyMetricPreference: StringPreference, today: String): Boolean {
    return today != dailyMetricPreference.get() || BuildConfig.DEBUG
}

