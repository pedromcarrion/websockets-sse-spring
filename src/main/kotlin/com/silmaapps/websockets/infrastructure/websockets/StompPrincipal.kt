package com.silmaapps.websockets.infrastructure.websockets

import java.security.Principal

class StompPrincipal(private val name: String) : Principal {
    override fun getName(): String = name
}
