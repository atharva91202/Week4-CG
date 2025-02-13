package mapinterface.mapinversion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class InvertMapTest {

    @Test
    void testInvertMap() {
        HashMap<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);
        inputMap.put("D", 2);
        inputMap.put("E", 3);

        HashMap<Integer, ArrayList<String>> expected = new HashMap<>();
        expected.put(1, new ArrayList<>(List.of("A", "C")));
        expected.put(2, new ArrayList<>(List.of("B", "D")));
        expected.put(3, new ArrayList<>(List.of("E")));

        HashMap<Integer, ArrayList<String>> result = InvertMap.invertMap(inputMap);

        assertEquals(expected, result);
    }

    @Test
    void testInvertMapWithEmptyMap() {
        HashMap<String, Integer> inputMap = new HashMap<>();
        HashMap<Integer, ArrayList<String>> result = InvertMap.invertMap(inputMap);

        assertTrue(result.isEmpty());
    }

    @Test
    void testInvertMapWithSingleEntry() {
        HashMap<String, Integer> inputMap = new HashMap<>();
        inputMap.put("X", 5);

        HashMap<Integer, ArrayList<String>> expected = new HashMap<>();
        expected.put(5, new ArrayList<>(List.of("X")));

        HashMap<Integer, ArrayList<String>> result = InvertMap.invertMap(inputMap);

        assertEquals(expected, result);
    }
}
