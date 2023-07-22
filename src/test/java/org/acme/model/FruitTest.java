package org.acme.model;

import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FruitTest {

    @InjectMocks
    Fruit cut;

    @BeforeEach
    void setUp() {

        cut = new Fruit();
    }

    @Test
    void get_id() {
        cut.set_id("1");

        assertNotNull(cut.get_id());
    }


    @Test
    void getName() {

        cut.setName("Orange");

        assertNotNull(cut.getName());
    }


    @Test
    void getDescription() {

        cut.setDescription("Shiny orange fruit");

        assertNotNull(cut.getDescription());
    }

    @Test
    void testTwoArgs() {

        cut = new Fruit("apple", "sour yellow apple");

        assertNotNull(cut);
    }


    @Test
    void testEquals() {

        assertTrue(cut.equals(new Fruit()));
    }


    @Test
    void testNotEquals() {

        assertFalse(cut.equals("I'm Fire"));
    }

    @Test
    void testHashCode() {

        assertEquals(31, cut.hashCode());

    }


    @Test
    void test() {
        String name = "     ";

        assertTrue(name.isBlank());

    }


    @Test
    void testValidation() {
        Fruit fruit = new Fruit("123", "numbers");

        assertEquals(null, fruit.getName());

    }
}