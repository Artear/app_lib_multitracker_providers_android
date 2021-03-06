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
package com.artear.multitracker.providers.extensions

import com.artear.multitracker.providers.DailyPrefsKeys
import com.artear.tools.android.preferences.PrefsHelper

fun PrefsHelper.Builder.addDailyMetric() = apply {
    addStringPreference(DailyPrefsKeys.DAILY_METRIC, DailyPrefsKeys.DEFAULT_VALUE_DAILY_METRIC)
}