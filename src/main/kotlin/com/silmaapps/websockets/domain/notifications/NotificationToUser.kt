package com.silmaapps.websockets.domain.notifications

import java.time.OffsetDateTime

class NotificationToUser(
    val user: String,
    val text: String,
    val time: OffsetDateTime
)
