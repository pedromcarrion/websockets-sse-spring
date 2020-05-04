package com.silmaapps.websockets.infrastructure.streams.consumer

import com.silmaapps.websockets.domain.notifications.Notification
import java.time.OffsetDateTime

class NotificationEvent(val text: String, val time: OffsetDateTime) {

    companion object{
        var jobId = 0
        fun getNextNotificationId() = ++jobId
    }

    fun toNotification(): Notification{
        return Notification(text, time)
    }
}

