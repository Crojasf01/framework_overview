package org.example

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class GetUserTest : FunSpec({
    test("GET /users/2 returns correct user") {
        val res = ApiClient.get("https://dummyjson.com/products/1")
        res.statusCode shouldBe 200

    }
})
