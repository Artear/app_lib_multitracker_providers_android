package com.artear.providersexample

import android.app.Application
import android.preference.PreferenceManager
import com.artear.multitracker.MultiTracker
import com.artear.multitracker.providers.answers.AnswersTracker
import com.artear.multitracker.providers.comscore.ComsCoreTracker
import com.artear.multitracker.providers.comscore.ComscoreCredentials
import com.artear.multitracker.providers.extensions.addDailyMetric
import com.artear.multitracker.providers.extensions.init
import com.artear.multitracker.providers.extensions.register
import com.artear.multitracker.providers.firebase.FirebaseTracker
import com.artear.tools.android.preferences.PrefsHelper

class App : Application() {

    override fun onCreate() {
        super.onCreate()



        val credentials = object : ComscoreCredentials {
            override val publisherId: String = ""
            override val publisherSecret: String = ""
            override val applicationName: String = ""
            override val persistentLabel: String = ""
        }

        val trackers = setOf(FirebaseTracker(baseContext),
                ComsCoreTracker(baseContext, credentials),
                AnswersTracker(baseContext))

        val pref = PreferenceManager.getDefaultSharedPreferences(this)

        //Event Trackers
        MultiTracker.instance.register(trackers)
        MultiTracker.instance.init(this, PrefsHelper.Builder(pref).addDailyMetric().build())
    }
}