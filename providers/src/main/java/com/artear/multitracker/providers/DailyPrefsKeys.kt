package com.artear.multitracker.providers

import android.support.annotation.StringDef

object DailyPrefsKeys {

    const val DEFAULT_VALUE_DAILY_METRIC = ""
    const val DAILY_METRIC = "daily_metric"

    @StringDef(DAILY_METRIC)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Values
}