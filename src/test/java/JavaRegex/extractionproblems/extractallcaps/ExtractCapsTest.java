package JavaRegex.extractionproblems.extractallcaps;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExtractCapsTest {
    // ✅ Test extracting capitalized words
    @Test
    void testExtractCapitalizedWords() {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> expected = Arrays.asList("The", "Eiffel", "Tower", "Paris", "Statue", "Liberty", "New", "York");
        assertEquals(expected, ExtractCaps.extractWords(text));
    }

    // ✅ Test extracting single capitalized word
    @Test
    void testSingleCapitalWord() {
        String text = "Hello";
        List<String> expected = Collections.singletonList("Hello");
        assertEquals(expected, ExtractCaps.extractWords(text));
    }

    // ❌ Test when there are no capitalized words
    @Test
    void testNoCapitalWords() {
        String text = "this is all lowercase.";
        assertTrue(ExtractCaps.extractWords(text).isEmpty());
    }

    // ✅ Test capital words with punctuation
    @Test
    void testCapitalWordsWithPunctuation() {
        String text = "Hello, world! Meet Mr. Smith.";
        List<String> expected = Arrays.asList("Hello", "Meet", "Mr", "Smith");
        assertEquals(expected, ExtractCaps.extractWords(text));
    }
}