package org.acme.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ErrorMessageTest {

    @InjectMocks
    ErrorMessage cut;

    @Test
    void setMessage() {
        cut.setMessage("some crazzy message thrown by the server");

        assertNotNull(cut.getMessage());
    }

    @Test
    void setMessageNoArgs() {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage("some crazzy message thrown by the server");

        assertNotNull(errorMessage.getMessage());
    }
}