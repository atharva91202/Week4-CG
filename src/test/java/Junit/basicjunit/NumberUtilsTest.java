package Junit.basicjunit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    @Test
    void testEvenNumbers() {
        assertTrue(NumberUtils.isEven(2), "2 should be even");
        assertTrue(NumberUtils.isEven(4), "4 should be even");
        assertTrue(NumberUtils.isEven(6), "6 should be even");
        assertTrue(NumberUtils.isEven(0), "0 should be even");
        assertTrue(NumberUtils.isEven(-8), "-8 should be even");
    }

    @Test
    void testOddNumbers() {
        assertFalse(NumberUtils.isEven(1), "1 should be odd");
        assertFalse(NumberUtils.isEven(7), "7 should be odd");
        assertFalse(NumberUtils.isEven(9), "9 should be odd");
        assertFalse(NumberUtils.isEven(-3), "-3 should be odd");
    }
}
