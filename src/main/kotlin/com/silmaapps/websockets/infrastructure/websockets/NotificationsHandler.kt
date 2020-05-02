package com.silmaapps.websockets.infrastructure.websockets

import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

class NotificationsHandler() : TextWebSocketHandler() {

    val sessions = mutableListOf<WebSocketSession>()

    override fun afterConnectionEstablished(session: WebSocketSession) {
        sessions.add(session)
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        sessions.forEach {
            it.sendMessage(message)
        }
    }
}
