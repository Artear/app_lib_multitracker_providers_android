package com.artear.multitracker.providers.answers

import android.content.Context
import com.artear.multitracker.ContextTracker
import com.artear.multitracker.contract.send.TrackerSend
import com.crashlytics.android.answers.Answers
import com.crashlytics.android.answers.CustomEvent

class AnswersTracker(context: Context) : ContextTracker(context) {

    override fun send(params: TrackerSend) {

        if (params is AnswerEvent) {
            val customEvent = CustomEvent(params.answerEvent)
            for (key in params.answerMap.keys) {
                customEvent.putCustomAttribute(key, params.answerMap[key])
            }
            Answers.getInstance().logCustom(customEvent)
        }

    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onDestroy() {

    }
}