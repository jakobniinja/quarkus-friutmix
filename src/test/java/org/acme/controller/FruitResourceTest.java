package org.acme.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.acme.model.Fruit;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@QuarkusTest
class FruitResourceTest {
    @Test
    void testGetAll() {
        Response response = given().contentType(ContentType.JSON)
                .when().get("/fruits")
                .then().statusCode(200)
                .extract().response();

        assertThat(response.jsonPath().getList("list").size(), is(greaterThanOrEqualTo(0)));
    }

    @Test
    void testAdd() {

        Map<String, String> map = new HashMap<>();

        map.put("name", "apple");
        map.put("description", "small sour apple");


        Response response = given()
                .contentType(ContentType.JSON)
                .body(map)
                .when().post("/fruits").then()
                .statusCode(200)
                .body("name", hasItem("apple")).extract().response();


        List<Fruit> fruits = response.jsonPath().getList("$");

        assertThat(fruits, not(empty()));
    }

    @Test
    void testRemove() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when().delete("/fruits/1")
                .then().statusCode(200)
                .body("name", not(hasItem("apple"))).extract().response();

        List<Fruit> fruits = response.jsonPath().getList("$");

        assertThat(fruits, empty());

    }

    @Test
    void testRemoveAll() {
        Response response = given().contentType(ContentType.JSON)
                .when().delete("/fruits")
                .then().statusCode(200)
                .body("size()", is(0))
                .body("name", not(hasItem("apple"))).extract().response();

        List<Fruit> fruits = response.jsonPath().getList("$");
        assertThat(fruits, empty());
    }
}