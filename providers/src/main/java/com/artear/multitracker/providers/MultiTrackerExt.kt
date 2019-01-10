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

