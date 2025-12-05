package org.example

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.*

class NegativeTests : FunSpec({

    test("POST /auth/login con credenciales inválidas devuelve 400") {

        val badLogin = mapOf(
            "username" to "usuario_que_no_existe",
            "password" to "clave_incorrecta"
        )

        val response =
            Given {
                contentType(ContentType.JSON)
                body(badLogin)
            } When {
                post("https://dummyjson.com/auth/login")
            } Then {
                statusCode(400)
            } Extract {
                response()
            }

        response.statusCode shouldBe 400
    }

    test("GET /products/99999999 devuelve 404 para producto inexistente") {

        val response =
            Given {
                contentType(ContentType.JSON)
            } When {
                get("https://dummyjson.com/products/99999999")
            } Then {
                statusCode(404)
            } Extract {
                response()
            }

        response.statusCode shouldBe 404
        response.jsonPath().getString("message") shouldBe "Product with id '99999999' not found"
    }
})
