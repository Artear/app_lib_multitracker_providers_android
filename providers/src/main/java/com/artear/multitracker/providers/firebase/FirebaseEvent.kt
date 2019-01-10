package com.artear.multitracker.providers.firebase

import android.os.Bundle
import com.artear.multitracker.contract.send.TrackerEvent

interface FirebaseEvent : TrackerEvent {

    val firebaseEvent: String

    val firebaseBundle: Bundle

    interface FireBaseName

}