package org.acme.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
class HiResourceTest {

    @Test
    void testHello() {
        given()
                .when().get("/test")
                .then().statusCode(200).body(containsString("hi from duke -"));
    }
}