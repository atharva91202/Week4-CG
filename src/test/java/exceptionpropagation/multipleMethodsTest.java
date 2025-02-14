package exceptionpropagation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class multipleMethodsTest {
    @Test
    void testMethod1_ThrowsArithmeticException() {
        Exception exception = assertThrows(ArithmeticException.class, multipleMethods::method1);
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void testMethod2_ThrowsArithmeticException() {
        Exception exception = assertThrows(ArithmeticException.class, multipleMethods::method2);
        assertEquals("/ by zero", exception.getMessage());
    }
}