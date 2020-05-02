package com.silmaapps.websockets.application.notifications

import java.time.OffsetDateTime

class Notification(val text: String, val time: OffsetDateTime) {

    companion object{
        var jobId = 0
        fun getNextNotificationId() = ++jobId
    }
}
