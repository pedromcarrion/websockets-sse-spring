package com.silmaapps.websockets.infrastructure.configuration

import com.silmaapps.websockets.application.notifications.SendNotifications
import com.silmaapps.websockets.application.notifications.SendNotificationsToUser
import com.silmaapps.websockets.infrastructure.streams.consumer.NotificationsConsumer
import com.silmaapps.websockets.infrastructure.websockets.HandShakeHandler
import com.silmaapps.websockets.infrastructure.websockets.NotificationsHandler
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.SimpMessagingTemplate

@Configuration
class ApplicationConfiguration {

    @Bean
    fun sendNotifications(simpMessagingTemplate: SimpMessagingTemplate, applicationEventPublisher: ApplicationEventPublisher):
            SendNotifications = SendNotifications(simpMessagingTemplate, applicationEventPublisher)

    @Bean
    fun sendNotificationsToUser(simpMessagingTemplate: SimpMessagingTemplate):
            SendNotificationsToUser = SendNotificationsToUser(simpMessagingTemplate)
    @Bean
    fun notificationService(sendNotifications: SendNotifications, sendNotificationsToUser: SendNotificationsToUser):
            NotificationsConsumer =
        NotificationsConsumer(sendNotifications, sendNotificationsToUser)

    @Bean
    fun notificationsHandler() : NotificationsHandler {
        return NotificationsHandler()
    }

    @Bean
    fun handShakeHandler(): HandShakeHandler {
        return HandShakeHandler()
    }
}
