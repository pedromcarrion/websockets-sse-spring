package com.silmaapps.websockets.application.notifications

import com.silmaapps.websockets.domain.notifications.Notification
import org.springframework.context.ApplicationEventPublisher
import org.springframework.messaging.simp.SimpMessagingTemplate

class SendNotifications(
    private val simpMessagingTemplate: SimpMessagingTemplate,
    private val applicationEventPublisher: ApplicationEventPublisher
) {
    fun execute(notification: Notification) {
        simpMessagingTemplate.convertAndSend("/topic/notifications", notification.text)
        applicationEventPublisher.publishEvent(notification)
    }
}
