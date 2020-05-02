package com.silmaapps.websockets.application.notifications

import org.springframework.context.ApplicationEventPublisher
import org.springframework.scheduling.annotation.Scheduled
import java.time.OffsetDateTime

class NotificationService(
    private val eventPublisher: ApplicationEventPublisher
) {

    @Scheduled(fixedRate = 4000, initialDelay = 2000)
    fun publishNotificationsAllUsers(){
        val notificationId = Notification.getNextNotificationId()
        val notification = Notification(
            "Notification to all users $notificationId.",
            OffsetDateTime.now()
        )
        this.eventPublisher.publishEvent(notification)
    }

    @Scheduled(fixedRate = 4000, initialDelay = 2000)
    fun publishNotificationsToUser(){
        val userId= "e0a4c76d-4ce7-4071-bd77-d9292ca966d2"
        val notificationId: Int = Notification.getNextNotificationId()
        val notificationToUser = NotificationToUser(
            userId,
            "Notification to user $userId notification --> $notificationId.",
            OffsetDateTime.now()
        )
        this.eventPublisher.publishEvent(notificationToUser)
    }
}
