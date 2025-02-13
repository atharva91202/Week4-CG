package mostFrequentwords;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MostFrequentWordsTest {
    private static final String TEST_FILE_PATH = "test_file.txt";

    // Helper method to create a temporary test file
    private void createTestFile(String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE_PATH))) {
            writer.write(content);
        }
    }

    @Test
    void testFindFrequency_MultipleWords() throws IOException {
        createTestFile("apple banana apple orange banana apple");

        HashMap<String, Integer> wordCount = MostFrequentWords.findFrequency(TEST_FILE_PATH);

        assertEquals(3, wordCount.get("apple"));
        assertEquals(2, wordCount.get("banana"));
        assertEquals(1, wordCount.get("orange"));
    }

    @Test
    void testFindFrequency_WithPunctuation() throws IOException {
        createTestFile("Hello, world! Hello... world? Hello!");

        HashMap<String, Integer> wordCount = MostFrequentWords.findFrequency(TEST_FILE_PATH);

        assertEquals(3, wordCount.get("hello"));
        assertEquals(2, wordCount.get("world"));
    }

    @Test
    void testFindFrequency_CaseInsensitive() throws IOException {
        createTestFile("Java java JAVA JavaScript javascript");

        HashMap<String, Integer> wordCount = MostFrequentWords.findFrequency(TEST_FILE_PATH);

        assertEquals(3, wordCount.get("java"));
        assertEquals(2, wordCount.get("javascript"));
    }

    @Test
    void testFindFrequency_OnlySpecialCharacters() throws IOException {
        createTestFile("!!! $$$ %%% ???");

        HashMap<String, Integer> wordCount = MostFrequentWords.findFrequency(TEST_FILE_PATH);

        assertTrue(wordCount.isEmpty(), "Word count should be empty for non-alphabetic characters.");
    }

    @Test
    void testFindFrequency_RepeatedWords() throws IOException {
        createTestFile("test test test test test");

        HashMap<String, Integer> wordCount = MostFrequentWords.findFrequency(TEST_FILE_PATH);

        assertEquals(5, wordCount.get("test"));
    }

    @Test
    void testFindFrequency_FileNotFound() {
        Exception exception = assertThrows(RuntimeException.class, () ->
                MostFrequentWords.findFrequency("non_existent_file.txt"));

        assertTrue(exception.getMessage().contains("non_existent_file.txt"));
    }
}
