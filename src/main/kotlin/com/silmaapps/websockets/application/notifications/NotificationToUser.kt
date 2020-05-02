package com.silmaapps.websockets.application.notifications

import java.time.OffsetDateTime

class NotificationToUser(val user: String, val text: String, val time: OffsetDateTime) {

    companion object{
        var jobId = 0
        fun getNextJobId() = ++jobId
    }
}
