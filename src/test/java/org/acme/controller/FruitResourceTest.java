package org.acme.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class FruitResourceTest {


    @Inject
    FruitResource cut;


    @Test
    void testGetAll() {


        given().contentType(ContentType.JSON)
          .when().get("/fruits")
          .then().statusCode(200)
          .body("size()", is(1))
          .body("name", hasItem("Pomegranate"));
    }

}