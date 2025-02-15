package JavaRegex.modifystrings.censorbadwords;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class censoringWordsTest {
    @Test
    void testCensorBadWords() {
        String sentence = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");
        String expected = "This is a **** bad example with some **** words.";

        assertEquals(expected, censoringWords.censorWords(badWords,sentence));
    }

    @Test
    void testNoBadWords() {
        String sentence = "This is a good example.";
        List<String> badWords = Arrays.asList("damn", "stupid");
        String expected = "This is a good example.";

        assertEquals(expected, censoringWords.censorWords(badWords,sentence));
    }
    @Test
    void testOneBadWord() {
        String sentence = "This is a damn good example.";
        List<String> badWords = Arrays.asList("damn");
        String expected = "This is a **** good example.";

        assertEquals(expected, censoringWords.censorWords(badWords,sentence));
    }
    @Test
    void testMultipleBadWords() {
        String sentence = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");
        String expected = "This is a **** bad example with some **** words.";

        assertEquals(expected, censoringWords.censorWords(badWords,sentence));
    }
    @Test
    void testCaseInsensitiveCensorship() {
        String sentence = "This is a Damn bad example with some Stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");
        String expected = "This is a **** bad example with some **** words.";
        assertEquals(expected, censoringWords.censorWords(badWords,sentence));
    }
}