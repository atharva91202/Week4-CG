package mapinterface.wordfrequency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

class WordFrequencyTest {

    private final String TEST_FILE = "test.txt";

    void createTestFile(String content) throws IOException {
        FileWriter writer = new FileWriter(TEST_FILE);
        writer.write(content);
        writer.close();
    }

    @Test
    void testWordFrequency() throws IOException {
        createTestFile("hello world hello");

        HashMap<String, Integer> result = WordFrequency.wordFrequency(TEST_FILE);

        assertEquals(2, result.get("hello"));
        assertEquals(1, result.get("world"));
        assertFalse(result.containsKey("test"));
    }

    @Test
    void testWordFrequencyWithPunctuation() throws IOException {
        createTestFile("Hello, world! Hello.");

        HashMap<String, Integer> result = WordFrequency.wordFrequency(TEST_FILE);

        assertEquals(2, result.get("hello"));
        assertEquals(1, result.get("world"));
    }

    @Test
    void testWordFrequencyWithEmptyFile() throws IOException {
        createTestFile("");

        HashMap<String, Integer> result = WordFrequency.wordFrequency(TEST_FILE);

        assertTrue(result.isEmpty());
    }

    @Test
    void testWordFrequencyWithNumbersAndSymbols() throws IOException {
        createTestFile("123 Hello @world #hello!!");

        HashMap<String, Integer> result = WordFrequency.wordFrequency(TEST_FILE);

        assertEquals(2, result.get("hello"));
        assertEquals(1, result.get("world"));
        assertFalse(result.containsKey("123"));
        assertFalse(result.containsKey("@world"));
    }
}
