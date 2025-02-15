package JavaRegex.basicproblems.hexcolour;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class HexcolourTest {
    private static final String HEX_COLOR_PATTERN = "^#([A-Fa-f0-9]{6})$";

    // Method to validate hex color
    private boolean isValidHexColor(String colorCode) {
        return Pattern.matches(HEX_COLOR_PATTERN, colorCode);
    }

    // ✅ Test for a valid uppercase hex color
    @Test
    void testValidUppercaseHex() {
        assertTrue(isValidHexColor("#FFA500"), "Valid uppercase hex should return true.");
    }

    // ✅ Test for a valid lowercase hex color
    @Test
    void testValidLowercaseHex() {
        assertTrue(isValidHexColor("#ff4500"), "Valid lowercase hex should return true.");
    }

    // ❌ Test for a too short hex color
    @Test
    void testTooShortHex() {
        assertFalse(isValidHexColor("#123"), "Hex code too short should return false.");
    }

    // ❌ Test for missing # symbol
    @Test
    void testMissingHash() {
        assertFalse(isValidHexColor("FFA500"), "Hex code without # should return false.");
    }

    // ❌ Test for invalid characters (non-hex values)
    @Test
    void testInvalidCharacters() {
        assertFalse(isValidHexColor("#ZZZ123"), "Hex code with invalid characters should return false.");
    }

    // ❌ Test for more than 6 characters
    @Test
    void testTooLongHex() {
        assertFalse(isValidHexColor("#FFA5001"), "Hex code with more than 6 characters should return false.");
    }
}