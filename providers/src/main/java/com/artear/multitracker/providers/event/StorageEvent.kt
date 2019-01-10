package com.artear.multitracker.providers.event

import com.artear.multitracker.providers.answers.AnswerEvent
import java.util.*

class StorageEvent(installedOnSD: Boolean) : AnswerEvent {

    companion object {
        private const val TAG = "STORAGE"
    }

    override val answerEvent: String
        get() = TAG

    override val answerMap: HashMap<String, String>

    init {
        val storageMap = HashMap<String, String>()
        storageMap["OnSD"] = installedOnSD.toString()
        this.answerMap = storageMap
    }

}