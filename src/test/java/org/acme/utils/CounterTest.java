package org.acme.utils;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CounterTest {

    @InjectMocks
    Counter cut;

    @Test
    void noOperationTest(){

        assertEquals(cut.getVal(), 0);
    }


    @Test
    void incrementCounterTest(){

        cut.increment();

        assertEquals(cut.getVal(), 1);
    }



    @Test
    void decrementCounterTest(){

        cut.decrement();

        assertEquals(cut.getVal(), -1);
    }
}