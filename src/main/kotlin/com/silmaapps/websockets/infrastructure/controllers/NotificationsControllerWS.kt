package com.silmaapps.websockets.infrastructure.controllers

import com.silmaapps.websockets.application.notifications.Notification
import com.silmaapps.websockets.application.notifications.NotificationToUser
import org.springframework.context.event.EventListener
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller
import java.security.Principal

@Controller
class NotificationsControllerWS(private val simpMessagingTemplate: SimpMessagingTemplate) {

    @MessageMapping("/notifications")
    fun notifications(question: String, principal: Principal) : String{
        return question.toUpperCase() + " by " + principal.name
    }

    @EventListener
    fun onNotification(notification: Notification) {
        simpMessagingTemplate.convertAndSend("/topic/notifications", notification.text)
    }

    @EventListener
    fun onNotificationToUser(notificationToUser: NotificationToUser) {
        simpMessagingTemplate.convertAndSend("/queue/${notificationToUser.user}", notificationToUser.text)
    }
}
