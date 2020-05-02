package com.silmaapps.websockets.infrastructure.configuration

import com.silmaapps.websockets.infrastructure.websockets.HandShakeHandler
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
class WebSocketBrokerConfig(
    private val handShakeHandler : HandShakeHandler
): WebSocketMessageBrokerConfigurer {

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/notifications")
            .setHandshakeHandler(handShakeHandler)
            .withSockJS()
    }

    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.setApplicationDestinationPrefixes("/app")
            .enableSimpleBroker("/topic", "/queue")
    }
}
