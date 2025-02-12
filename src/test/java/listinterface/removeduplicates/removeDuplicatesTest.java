package listinterface.removeduplicates;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class removeDuplicatesTest {

    @Test
    void testRemoveDuplicates() {
        List<Integer> input = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> expected = Arrays.asList(3, 1, 2, 4);
        assertEquals(expected, removeDuplicates.duplicates(input));
    }

    @Test
    void testRemoveDuplicatesWithNoDuplicates() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        assertEquals(input, removeDuplicates.duplicates(input));
    }

    @Test
    void testRemoveDuplicatesWithEmptyList() {
        List<Integer> input = Arrays.asList();
        List<Integer> expected = Arrays.asList();
        assertEquals(expected, removeDuplicates.duplicates(input));
    }
}