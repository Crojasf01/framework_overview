package org.example

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.response.Response

object ApiClient {

    init {
        RestAssured.baseURI = "https://dummyjson.com"
        RestAssured.useRelaxedHTTPSValidation()
    }

    fun get(path: String): Response =
        RestAssured.given()
            .contentType(ContentType.JSON)
            .log().all()
            .get(path)
            .then()
            .log().all()
            .extract()
            .response()

    fun post(path: String, body: Any): Response =
        RestAssured.given()
            .contentType(ContentType.JSON)
            .body(body)
            .log().all()
            .post(path)
            .then()
            .log().all()
            .extract()
            .response()
}
