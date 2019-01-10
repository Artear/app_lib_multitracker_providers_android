package com.artear.multitracker.providers

import com.artear.tools.preferences.PrefsHelper

fun PrefsHelper.Builder.addDailyMetric() : PrefsHelper.Builder{
    addStringPreference(DailyPrefsKeys.DAILY_METRIC, DailyPrefsKeys.DEFAULT_VALUE_DAILY_METRIC)
    return this
}