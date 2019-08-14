package com.artear.multitracker.providers.event

import android.content.Context
import android.content.res.Configuration
import com.artear.multitracker.providers.answers.AnswerEvent
import java.util.*


class DarkEvent(private val context: Context) : AnswerEvent {

    companion object {
        private const val TAG = "THEME"
    }

    override val answerEvent: String
        get() = TAG

    override val answerMap: HashMap<String, String>


    init {
        val darkTheme = HashMap<String, String>()
        val mode: String = when (isDarkTheme()) {
            true -> "NIGHT"
            false -> "LIGHT"
        }
        darkTheme["THEME"] = mode

        this.answerMap = darkTheme
    }

    private fun isDarkTheme(): Boolean {
        val x = context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return x == Configuration.UI_MODE_NIGHT_YES
    }
}


