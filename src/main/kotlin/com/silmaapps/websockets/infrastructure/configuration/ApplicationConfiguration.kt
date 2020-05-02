package com.silmaapps.websockets.infrastructure.configuration

import com.silmaapps.websockets.application.notifications.NotificationService
import com.silmaapps.websockets.infrastructure.websockets.HandShakeHandler
import com.silmaapps.websockets.infrastructure.websockets.NotificationsHandler
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration {

    @Bean
    fun notificationService(eventPublisher: ApplicationEventPublisher):
            NotificationService = NotificationService(eventPublisher)

    @Bean
    fun notificationsHandler() : NotificationsHandler {
        return NotificationsHandler()
    }

    @Bean
    fun handShakeHandler(): HandShakeHandler {
        return HandShakeHandler()
    }
}
