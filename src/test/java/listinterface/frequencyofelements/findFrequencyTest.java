package listinterface.frequencyofelements;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class findFrequencyTest {

    @Test
    void frequency() {
        List<String> input = Arrays.asList("Apple", "Banana", "Apple", "Orange");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Apple", 2);
        expected.put("Banana", 1);
        expected.put("Orange", 1);

        assertEquals(expected, findFrequency.frequency(input));

    }
         @Test
        void testCountFrequencyWithEmptyList(){
            List<String> input2 = new ArrayList<>();
            Map<String, Integer> expected2 = new HashMap<>();
            assertEquals(expected2, findFrequency.frequency(input2));

    }
}