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