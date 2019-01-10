package com.artear.multitracker.providers.event

import android.util.DisplayMetrics
import com.artear.multitracker.providers.answers.AnswerEvent
import java.util.*


class ScreenEvent(width: Int, height: Int, displayMetrics: DisplayMetrics) : AnswerEvent {

    companion object {
        private const val TAG = "SCREEN"
    }

    override val answerEvent: String
        get() = TAG

    override val answerMap: HashMap<String, String>

    init {
        val notificationMap = HashMap<String, String>()
        notificationMap["MIN_WIDTH"] = width.toString()
        notificationMap["MAX_HEIGHT"] = height.toString()

        val aspect = width.toString() + "x" + height.toString()
        notificationMap["ASPECT"] = aspect
        notificationMap["DPI"] = displayMetrics.densityDpi.toString()
        notificationMap["DENSITY"] = (displayMetrics.densityDpi / 160).toString() + "x"
        this.answerMap = notificationMap
    }


}
