package org.acme.utils;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ValidationExceptionTest {

    @Test
    public void toResponseAction() {
        String fruit = "{\"name\":\"3 apples\",\"description\":\"a fruit that grow on trees\"}";

        given().
                contentType(ContentType.JSON).
                body(fruit).
                when().
                post("/fruits").
                then().statusCode(400);
    }

    @Test
    public void toResponseOk() {
        String fruit = "{\"name\":\"apple\",\"description\":\"a fruit that grow on trees\"}";

        given().
                contentType(ContentType.JSON).
                body(fruit).
                when().
                post("/fruits").
                then().statusCode(200);
    }
}
