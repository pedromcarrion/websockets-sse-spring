package com.silmaapps.websockets.infrastructure.streams.consumer

import com.silmaapps.websockets.domain.notifications.NotificationToUser
import java.time.OffsetDateTime

class NotificationToUserEvent(val user: String, val text: String, val time: OffsetDateTime) {

    companion object{
        var jobId = 0
        fun getNextJobId() = ++jobId
    }

    fun toNotificationToUser(): NotificationToUser{
        return NotificationToUser(user, text, time)
    }
}
