package runtimeexception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class runtimeExceptionTest {

    public class divideTest{

        @Test
        void testValidDivision() {
            assertEquals(5, runtimeException.divide(10, 2));
            assertEquals(-3, runtimeException.divide(-9, 3));
            assertEquals(0, runtimeException.divide(0, 5)); // 0 divided by anything should be 0
        }

        @Test
        void testDivisionByZero() {
            Exception exception = assertThrows(ArithmeticException.class, () -> runtimeException.divide(10, 0));
            assertEquals("Division by zero !!", exception.getMessage());
        }

    }
}
