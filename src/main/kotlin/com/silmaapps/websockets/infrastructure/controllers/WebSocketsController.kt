package com.silmaapps.websockets.infrastructure.controllers

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.security.Principal

@Controller
class WebSocketsController{
    @GetMapping("/{officeId}")
    fun home(@PathVariable officeId: String, model: Model): String {
        model.addAttribute("officeId", officeId)
        return "home"
    }

    @MessageMapping("/notifications")
    fun notifications(question: String, principal: Principal): String {
        return question.toUpperCase() + " by " + principal.name
    }
}
