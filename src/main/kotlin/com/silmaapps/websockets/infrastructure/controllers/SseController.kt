package com.silmaapps.websockets.infrastructure.controllers

import com.silmaapps.websockets.domain.notifications.Notification
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@Controller
class SseController() {

    private val emitters = mutableListOf<SseEmitter>()

    @GetMapping("/serverSendEvents")
    fun serverSendEvents(): String{
        return "sse"
    }

    @GetMapping("/register-server-send-events")
    fun registerServerSendEvents(): SseEmitter{
        val emitter = SseEmitter()
        emitters.add(emitter)
        emitter.onCompletion {
            emitters.remove(emitter)
        }
        return emitter
    }

    @EventListener
    fun onNotification(notification: Notification){
        emitters.forEach {
            it.send(SseEmitter.event().name("serverSendEvents").data(notification))
        }
    }
}
