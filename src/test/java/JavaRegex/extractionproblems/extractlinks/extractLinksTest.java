package JavaRegex.extractionproblems.extractlinks;

import org.junit.jupiter.api.Test;

import javax.lang.model.type.ArrayType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class extractLinksTest {
    @Test
    void testExtractValidLinks() {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> expected = Arrays.asList("https://www.google.com", "http://example.org");
        assertEquals(expected, extractLinks.extraction(text));
    }

    @Test
    void testNoLinks() {
        String text = "This text has no URLs.";
        assertTrue(extractLinks.extraction(text).isEmpty());
    }

    @Test
    void testSingleLink() {
        String text = "My website is https://myportfolio.com.";
        List<String> expected = Collections.singletonList("https://myportfolio.com");
        assertEquals(expected, extractLinks.extraction(text));
    }

    @Test
    void testMultipleLinks() {
        String text = "Check out https://github.com, http://example.net, and https://openai.com.";
        List<String> expected = Arrays.asList("https://github.com", "http://example.net", "https://openai.com");
        assertEquals(expected, extractLinks.extraction(text));
    }

    @Test
    void testInvalidLinks() {
        String text = "Invalid links: www.google, htp://wrong.url, example.com";
        assertTrue(extractLinks.extraction(text).isEmpty());
    }
}
