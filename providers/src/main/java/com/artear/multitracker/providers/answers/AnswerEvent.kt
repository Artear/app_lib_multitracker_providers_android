package com.artear.multitracker.providers.answers

import com.artear.multitracker.contract.send.TrackerEvent
import java.util.*


interface AnswerEvent : TrackerEvent {

    val answerEvent: String

    val answerMap: HashMap<String, String>
}