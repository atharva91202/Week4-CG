package JavaRegex.advancedproblems.validip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPValidatorTest {
    // Test valid IP addresses
    @Test
    void testValidIP() {
        assertTrue(IPValidator.isValidIP("192.168.1.1"));
        assertTrue(IPValidator.isValidIP("0.0.0.0"));
        assertTrue(IPValidator.isValidIP("255.255.255.255"));
    }

    // Test invalid IP addresses
    @Test
    void testInvalidIP() {
        assertFalse(IPValidator.isValidIP("256.168.1.1")); // Invalid octet > 255
        assertFalse(IPValidator.isValidIP("192.168.1"));    // Incomplete IP address
        assertTrue(IPValidator.isValidIP("192.168.1.01")); // Leading zero in last octet
        assertFalse(IPValidator.isValidIP("abc.def.ghi.jkl")); // Non-numeric characters
    }
}