package mapinterface.keywithhighestvalue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

class KeyWithHighestValueTest {

    @Test
    void testKeyWithHighestValue() {
        HashMap<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 1);

        String result = KeyWithHighestValue.keyWithHighestValue(inputMap);
        assertEquals("B", result);
    }

    @Test
    void testKeyWithHighestValueSingleEntry() {
        HashMap<String, Integer> inputMap = new HashMap<>();
        inputMap.put("X", 100);

        String result = KeyWithHighestValue.keyWithHighestValue(inputMap);
        assertEquals("X", result);
    }

    @Test
    void testKeyWithHighestValueEmptyMap() {
        HashMap<String, Integer> inputMap = new HashMap<>();

        String result = KeyWithHighestValue.keyWithHighestValue(inputMap);
        assertEquals("", result);
    }
}
