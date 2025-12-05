package org.example

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LoginTest : FunSpec({

    test("POST /auth/login returns token") {

        val body = mapOf(
            "username" to "emilys",
            "password" to "emilyspass"
        )

        val response = ApiClient.post("/auth/login", body)

        println("RESPONSE = " + response.body.asString())

        response.statusCode shouldBe 200

        val token = response.jsonPath().getString("accessToken")

        token.isNullOrBlank() shouldBe false
    }

})
