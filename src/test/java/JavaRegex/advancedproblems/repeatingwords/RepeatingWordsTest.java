package JavaRegex.advancedproblems.repeatingwords;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RepeatingWordsTest {

    @Test
    void testNoRepeatingWords() {
        String sentence = "No repeated words here.";

        // Capture the system output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Call the method to test
        RepeatingWords.findRepeatingWords(sentence);

        // Get the output and check if no words are repeated
        String output = outputStream.toString().trim();

        assertEquals("Repeating words:", output);
    }

    @Test
    void testEmptySentence() {
        String sentence = "";

        // Capture the system output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Call the method to test
        RepeatingWords.findRepeatingWords(sentence);

        // Get the output and check if no words are repeated
        String output = outputStream.toString().trim();

        assertEquals("Repeating words:", output);
    }
}