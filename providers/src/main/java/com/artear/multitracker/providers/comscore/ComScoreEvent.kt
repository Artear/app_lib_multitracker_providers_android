package com.artear.multitracker.providers.comscore

import com.artear.multitracker.contract.send.TrackerEvent

interface ComScoreEvent : TrackerEvent {

    val comScoreMap: Map<String, String>

}
