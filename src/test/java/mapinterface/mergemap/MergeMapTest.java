package mapinterface.mergemap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

class MergeMapTest {

    @Test
    void testMergeMap() {
        HashMap<String, Integer> inputMap1 = new HashMap<>();
        inputMap1.put("A", 1);
        inputMap1.put("B", 2);

        HashMap<String, Integer> inputMap2 = new HashMap<>();
        inputMap2.put("C", 2);
        inputMap2.put("B", 3);

        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("A", 1);
        expected.put("B", 5); // 2 + 3
        expected.put("C", 2);

        HashMap<String, Integer> result = MergeMap.mergeMap(inputMap1, inputMap2);
        assertEquals(expected, result);
    }

    @Test
    void testMergeMapWithEmptyMap() {
        HashMap<String, Integer> inputMap1 = new HashMap<>();
        inputMap1.put("X", 5);

        HashMap<String, Integer> inputMap2 = new HashMap<>();

        HashMap<String, Integer> result = MergeMap.mergeMap(inputMap1, inputMap2);
        assertEquals(inputMap1, result);
    }

    @Test
    void testMergeMapBothEmpty() {
        HashMap<String, Integer> inputMap1 = new HashMap<>();
        HashMap<String, Integer> inputMap2 = new HashMap<>();

        HashMap<String, Integer> result = MergeMap.mergeMap(inputMap1, inputMap2);
        assertTrue(result.isEmpty());
    }
}
