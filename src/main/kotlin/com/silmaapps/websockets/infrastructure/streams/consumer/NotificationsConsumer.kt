package com.silmaapps.websockets.infrastructure.streams.consumer

import com.silmaapps.websockets.application.notifications.SendNotifications
import com.silmaapps.websockets.application.notifications.SendNotificationsToUser
import org.springframework.scheduling.annotation.Scheduled
import java.time.OffsetDateTime

class NotificationsConsumer(
    private val sendNotifications: SendNotifications,
    private val sendNotificationsToUser: SendNotificationsToUser
) {

    @Scheduled(fixedRate = 4000, initialDelay = 2000)
    fun publishNotificationsAllUsers(){
        val notificationId = NotificationEvent.getNextNotificationId()
        val notification = NotificationEvent(
            "Notification to all users $notificationId.",
            OffsetDateTime.now()
        )

        sendNotifications.execute(notification.toNotification())
    }

    @Scheduled(fixedRate = 4000, initialDelay = 2000)
    fun publishNotificationsToUser(){
        val userId= "e0a4c76d-4ce7-4071-bd77-d9292ca966d2"
        val notificationId: Int = NotificationEvent.getNextNotificationId()
        val notificationToUser =
            NotificationToUserEvent(
                userId,
                "Notification to user $userId notification --> $notificationId.",
                OffsetDateTime.now()
            )
        sendNotificationsToUser.execute(notificationToUser.toNotificationToUser())
    }
}
