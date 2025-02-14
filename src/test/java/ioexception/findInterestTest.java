package ioexception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class findInterestTest {
    @Test
    void testValidInterestCalculation() {
        double interest = findInterest.calculateInterest(100000, 22.4, 3);
        assertEquals(67200, interest, "Interest calculation is incorrect.");
    }

    @Test
    void testNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           findInterest.calculateInterest(-5000, 5.0, 2);
        });
        assertEquals("Invalid input: Amount and Rate can't be negative", exception.getMessage());
    }

    @Test
    void testNegativeRate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            findInterest.calculateInterest(5000, -5.0, 2);
        });
        assertEquals("Invalid input: Amount and Rate can't be negative", exception.getMessage());
    }

    @Test
    void testZeroRate() {
        double interest = findInterest.calculateInterest(100000, 0, 3);
        assertEquals(0, interest, "Interest should be 0 when rate is 0.");
    }
}
