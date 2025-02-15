package JavaRegex.modifystrings.removespaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReplaceSpacesTest {
    @Test
    void testMultipleSpaces() {
        String text = "This   is  an   example   with   multiple    spaces.";
        String expected = "This is an example with multiple spaces.";
        assertEquals(expected, ReplaceSpaces.replaceSpaces(text));
    }
    @Test
    void testLeadingAndTrailingSpaces() {
        String text = "   This is an example with leading and trailing spaces.   ";
        String expected = "This is an example with leading and trailing spaces.";
        assertEquals(expected, ReplaceSpaces.replaceSpaces(text));
    }

    @Test
    void testNoExtraSpaces() {
        String text = "This is an example.";
        String expected = "This is an example.";
        assertEquals(expected, ReplaceSpaces.replaceSpaces(text));
    }

    @Test
    void testEmptyString() {
        String text = "";
        String expected = "";
        assertEquals(expected, ReplaceSpaces.replaceSpaces(text));
    }

    @Test
    void testOnlyMultipleSpaces() {
        String text = "      ";
        String expected = "";
        assertEquals(expected, ReplaceSpaces.replaceSpaces(text));
    }
}