package JavaRegex.basicproblems.username;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsernameTest {

    @Test
    void testValidUsername() {
        assertTrue(validateUsername("user_1234"), "Valid username should return true.");
    }


    @Test
    void testShortUsername() {
        assertFalse(validateUsername("usr"), "Username shorter than 5 characters should return false.");
    }

    @Test
    void testLongUsername() {
        assertFalse(validateUsername("verylongusername123"), "Username longer than 15 characters should return false.");
    }

    @Test
    void testInvalidCharacters() {
        assertFalse(validateUsername("user@name"), "Username with special characters should return false.");
    }


    @Test
    void testAlphanumericUsername() {
        assertTrue(validateUsername("User123"), "Alphanumeric username should return true.");
    }


    @Test
    void testUsernameWithUnderscore() {
        assertTrue(validateUsername("user_name"), "Username with underscore should return true.");
    }

    // Helper method to validate username
    private boolean validateUsername(String username) {
        String regex = "^[a-zA-Z0-9_]{5,15}$";
        return username.matches(regex);
    }
}
