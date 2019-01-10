package com.artear.multitracker.providers.comscore

import com.artear.multitracker.contract.send.TrackerView

interface ComScoreView : TrackerView {

    val comScoreMap: Map<String, String>
}
