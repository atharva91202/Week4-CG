package customexception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class customExceptionExampleTest {

    @Test
    void testValidAge() {
        assertDoesNotThrow(() -> customExceptionExample.validateAge(20));
    }

    @Test
    void testInvalidAge() {
        Exception exception = assertThrows(CustomException.class, () -> {
            customExceptionExample.validateAge(15);
        });
        assertEquals("Age must be over 18", exception.getMessage());
    }
}