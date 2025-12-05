package org.example

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.*

class UserApiTest : FunSpec({

    beforeSpec {
        RestAssured.baseURI = "https://dummyjson.com"
    }

    test("GET /users/1 returns correct user") {
        val response =
            Given {
                contentType(ContentType.JSON)
            } When {
                get("/users/1")
            } Then {
                statusCode(200)
            } Extract {
                response()
            }

        response.jsonPath().getString("firstName") shouldBe "Emily"
    }
})
