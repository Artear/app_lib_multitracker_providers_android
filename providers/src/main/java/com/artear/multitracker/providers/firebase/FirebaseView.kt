package com.artear.multitracker.providers.firebase

import android.os.Bundle
import com.artear.multitracker.contract.send.TrackerView

interface FirebaseView : TrackerView {

    val firebaseViewName: String

    val firebaseBundle: Bundle
}