package JavaRegex.basicproblems.license;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class LicnesecheckTest {
    // ✅ Test for a valid license number
    @Test
    void testValidLicense() {
        assertTrue(validateLicense("AB1234"), "Valid license should return true.");
    }

    // ❌ Test for license with lowercase letters (invalid)
    @Test
    void testLowerCaseLicense() {
        assertFalse(validateLicense("ab1234"), "License with lowercase letters should return false.");
    }

    // ❌ Test for license with extra characters (invalid)
    @Test
    void testExtraCharacters() {
        assertFalse(validateLicense("ABC1234"), "License with extra characters should return false.");
    }

    // ❌ Test for license with missing numbers (invalid)
    @Test
    void testMissingNumbers() {
        assertFalse(validateLicense("AB12"), "License with less than 4 numbers should return false.");
    }

    // ❌ Test for license with special characters (invalid)
    @Test
    void testSpecialCharacters() {
        assertFalse(validateLicense("AB12@4"), "License with special characters should return false.");
    }

    // ✅ Test for another valid case
    @Test
    void testAnotherValidLicense() {
        assertTrue(validateLicense("XY5678"), "Another valid license should return true.");
    }

    // Helper method to validate license
    private boolean validateLicense(String license) {
        String regex = "^[A-Z]{2}[0-9]{4}$";
        return Pattern.matches(regex, license);
    }
}