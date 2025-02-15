package JavaRegex.advancedproblems.domainlanguages;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LanguagesTest {
    @Test
    void testExtractProgrammingLanguages() {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> result = Languages.extractLanguages(text);

        assertEquals(4, result.size());
        assertTrue(result.contains("Java"));
        assertTrue(result.contains("Python"));
        assertTrue(result.contains("JavaScript"));
        assertTrue(result.contains("Go"));
    }

    // Test with a text that doesn't include any programming languages
    @Test
    void testNoProgrammingLanguages() {
        String text = "I love reading books and playing games.";
        List<String> result = Languages.extractLanguages(text);

        assertTrue(result.isEmpty());
    }

    // Test with a text that includes a single programming language
    @Test
    void testSingleProgrammingLanguage() {
        String text = "I love Java!";
        List<String> result = Languages.extractLanguages(text);

        assertEquals(1, result.size());
        assertTrue(result.contains("Java"));
    }

}