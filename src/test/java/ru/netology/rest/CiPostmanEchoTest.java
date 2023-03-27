package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CiPostmanEchoTest {
    @Test
    void shouldReturnDate() {

        given()
                .baseUri("https://postman-echo.com")
                .body("27.03.2023")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("27.03.2023"))
        ;
    }

    @Test
    void shouldReturnText() {

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("привет")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Привет"))
        ;
    }
}

