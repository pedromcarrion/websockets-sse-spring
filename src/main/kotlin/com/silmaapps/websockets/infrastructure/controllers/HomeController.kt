package com.silmaapps.websockets.infrastructure.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class HomeController {


    @GetMapping("/{officeId}")
    fun home(@PathVariable officeId: String, model: Model): String{
        model.addAttribute("officeId", officeId)
        return "home"
    }
}
