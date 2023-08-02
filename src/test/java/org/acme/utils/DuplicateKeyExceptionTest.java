package org.acme.utils;

import com.mongodb.MongoWriteException;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.acme.controller.FruitResource;
import org.acme.model.Fruit;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class DuplicateKeyExceptionTest {

    @Inject
    FruitResource cut;

    @Test
    void test_exception_custom() {

        String name = generateRandomName();

        Fruit fruit = new Fruit(name, "");

        Exception exception = assertThrows(MongoWriteException.class, () -> cut.add(fruit));

        assertTrue(exception.getMessage().contains("duplicate key error"));


    }

    private String generateRandomName() {

        Random r = new Random();

        StringBuilder name = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 9; i++) {

            name.append(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        return name.toString();
    }
}