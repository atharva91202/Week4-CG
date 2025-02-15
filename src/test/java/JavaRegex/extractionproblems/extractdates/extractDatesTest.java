package JavaRegex.extractionproblems.extractdates;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class extractDatesTest {
    // ✅ Test extracting valid dates
    @Test
    void testExtractValidDates() {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> expected = Arrays.asList("12/05/2023", "15/08/2024", "29/02/2020");
        assertEquals(expected, extractDates.extraction(text));
    }

    // ❌ Test case with no dates
    @Test
    void testNoDates() {
        String text = "There are no dates in this sentence.";
        assertTrue(extractDates.extraction(text).isEmpty());
    }

    // ✅ Test extracting a single date
    @Test
    void testSingleDate() {
        String text = "My birthday is on 07/11/1995.";
        List<String> expected = Collections.singletonList("07/11/1995");
        assertEquals(expected, extractDates.extraction(text));
    }

    // ✅ Test with different valid dates
    @Test
    void testDifferentDateFormats() {
        String text = "Dates: 01/01/2000, 31/12/1999, 23/06/2021.";
        List<String> expected = Arrays.asList("01/01/2000", "31/12/1999", "23/06/2021");
        assertEquals(expected, extractDates.extraction(text));
    }

    // ❌ Test invalid dates (should not be extracted)
    @Test
    void testInvalidDates() {
        String text = "Invalid dates: 32/01/2022, 00/12/2023, 15/13/2024.";
        assertTrue(extractDates.extraction(text).isEmpty());
    }
}