package finallyblock;

import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class intergerDivisionTest {
    @Test
    void testValidDivision() {
        assertEquals(5, intergerDivision.division(10, 2)); // 10 / 2 = 5
        assertEquals(3, intergerDivision.division(15, 5)); // 15 / 5 = 3
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class,
                () -> intergerDivision.division(10, 0));
        assertEquals("Division by zero !!", exception.getMessage());
    }

    @Test
    void testInputMismatch() {
        Exception exception = assertThrows(InputMismatchException.class,
                () -> {
                    throw new InputMismatchException("Input mismatch! Please enter an integer.");
                });
        assertEquals("Input mismatch! Please enter an integer.", exception.getMessage());
    }
}