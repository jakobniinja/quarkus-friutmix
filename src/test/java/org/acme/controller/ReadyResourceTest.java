package org.acme.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
class ReadyResourceTest {

    @Test
    void testCall(){
        given().when().get("/q/health/ready").then().body(containsString("Simple ready check"));
    }
}