package org.acme.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FruitValidationTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    void isFruitValidTest() {

        Fruit fruit = new Fruit();
        fruit.set_id("3");
        fruit.setName("apple");
        fruit.setDescription("Delicious green apple");

        Set<ConstraintViolation<Fruit>> violations = validator.validate(fruit);

        assertTrue(violations.isEmpty());
    }


    @Test
    void hasFruitValidNameTest() {
        Fruit fruit = new Fruit();
        fruit.set_id("3");
        fruit.setName("123 apples");
        fruit.setDescription("Delicious green apple");

        Set<ConstraintViolation<Fruit>> violations = validator.validate(fruit);

        assertFalse(violations.isEmpty());
    }
}