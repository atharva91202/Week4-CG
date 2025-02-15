package JavaRegex.advancedproblems.currency;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExtractCurrencyTest {
    @Test
    void testExtractCurrencyValues() {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> result = ExtractCurrency.extraction(text);

        assertEquals(2, result.size());
        assertTrue(result.contains("$45.99"));
        assertTrue(result.contains("10.50"));
    }

    // Test with a text that doesn't include any currency values
    @Test
    void testNoCurrencyValues() {
        String text = "There is no price listed here.";
        List<String> result = ExtractCurrency.extraction(text);

        assertTrue(result.isEmpty());
    }

    // Test with a text that includes only one currency value
    @Test
    void testSingleCurrencyValue() {
        String text = "The price is $99.";
        List<String> result = ExtractCurrency.extraction(text);

        assertEquals(1, result.size());
        assertTrue(result.contains("$99"));
    }

    // Test with a text that includes multiple currency values
    @Test
    void testMultipleCurrencyValues() {
        String text = "The price is $99.99, the discount is $50.50, and the total is $150.00.";
        List<String> result = ExtractCurrency.extraction(text);

        assertEquals(3, result.size());
        assertTrue(result.contains("$99.99"));
        assertTrue(result.contains("$50.50"));
        assertTrue(result.contains("$150.00"));
    }
}