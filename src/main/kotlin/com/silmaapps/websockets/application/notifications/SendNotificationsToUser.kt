package com.silmaapps.websockets.application.notifications

import com.silmaapps.websockets.domain.notifications.NotificationToUser
import org.springframework.messaging.simp.SimpMessagingTemplate

class SendNotificationsToUser(
    private val simpMessagingTemplate: SimpMessagingTemplate
) {
    fun execute(notificationToUser: NotificationToUser) {
        simpMessagingTemplate.convertAndSend("/queue/${notificationToUser.user}", notificationToUser.text)
    }
}
