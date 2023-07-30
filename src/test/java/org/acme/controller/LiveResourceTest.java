package org.acme.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
class LiveResourceTest {
    @Test
    void testCall() {
        given().when().get("/q/health/live").then().body(containsString("Simple live check"));
    }
}