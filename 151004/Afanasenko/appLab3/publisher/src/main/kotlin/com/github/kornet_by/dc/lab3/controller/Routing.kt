package com.github.kornet_by.dc.lab3.controller

import com.github.kornet_by.dc.lab3.controller.routing.authorsRouting
import com.github.kornet_by.dc.lab3.controller.routing.issuesRouting
import com.github.kornet_by.dc.lab3.controller.routing.messagesRouting
import com.github.kornet_by.dc.lab3.controller.routing.stickersRouting
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
	routing {
		get("/") {
			call.respondText("Hello World!")
		}
		route("/api/v1.0") {
			authorsRouting()
			issuesRouting()
			messagesRouting()
			stickersRouting()
		}
	}
}

suspend fun respond(
	isCorrect: () -> Boolean, onCorrect: suspend () -> Unit, onIncorrect: suspend () -> Unit
) {
	if (isCorrect()) {
		onCorrect()
	} else {
		onIncorrect()
	}
}