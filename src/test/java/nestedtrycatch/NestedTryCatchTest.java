package nestedtrycatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NestedTryCatchTest {
    @Test
    void testDivide_ValidInputs() {
        int[] arr = {2, 6, 7, 4, 9, 8, 1};
        int divisor = 3;
        int index = 4;
        int expected = arr[index] / divisor;

        assertEquals(expected, NestedTryCatch.division(arr ,index , divisor));
    }

    @Test
    void testDivide_DivideByZero() {
        int[] arr = {2, 6, 7, 4, 9, 8, 1};
        int divisor = 0;
        int index = 4;

        Exception exception = assertThrows(ArithmeticException.class, () ->
             NestedTryCatch.division(arr ,index , divisor));

        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void testDivide_InvalidIndex() {
        int[] arr = {2, 6, 7, 4, 9, 8, 1};
        int divisor = 3;
        int index = 10;

        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                        NestedTryCatch.division(arr ,index , divisor));

        assertEquals("Invalid array index", exception.getMessage());
    }
}
