package JavaRegex.advancedproblems.validcreditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidCCTest {
    @Test
    void testValidVisaCard() {
        assertTrue(ValidCC.isValidCC("4112345678901234"));
        assertTrue(ValidCC.isValidCC("4000000000000000"));
    }

    // Test valid MasterCard card numbers
    @Test
    void testValidMasterCard() {
        assertTrue(ValidCC.isValidCC("5123456789012345"));
        assertTrue(ValidCC.isValidCC("5555555555554444"));
    }

    // Test invalid card numbers
    @Test
    void testInvalidCard() {
        assertFalse(ValidCC.isValidCC("6112345678901234")); // Invalid card type
        assertFalse(ValidCC.isValidCC("41123456789012"));   // Too short (less than 16 digits)
        assertFalse(ValidCC.isValidCC("41123456789012345")); // Too long (more than 16 digits)
        assertTrue(ValidCC.isValidCC("5112345678901234")); // Invalid starting digit for MasterCard
        assertFalse(ValidCC.isValidCC("")); // Empty input
    }
}