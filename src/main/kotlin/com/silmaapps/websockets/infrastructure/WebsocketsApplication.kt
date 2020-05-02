package com.silmaapps.websockets.infrastructure

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication(scanBasePackages = ["com.silmaapps.websockets.infrastructure"])
@EnableScheduling
class WebsocketsApplication

fun main(args: Array<String>) {
	runApplication<WebsocketsApplication>(*args)
}
