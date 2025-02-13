package queueinterface.binarynumbers;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GenerateBinaryNumbersTest {

    @Test
    void testGenerateNumbersWithFiveElements() {
        int n = 5;
        Queue<String> expected = new LinkedList<>(Arrays.asList("1", "10", "11", "100", "101"));

        Queue<String> result = GenerateBinaryNumbers.generateNumbers(n);
        assertEquals(expected, result);
    }

    @Test
    void testGenerateNumbersWithOneElement() {
        int n = 1;
        Queue<String> expected = new LinkedList<>(Collections.singletonList("1"));

        Queue<String> result = GenerateBinaryNumbers.generateNumbers(n);
        assertEquals(expected, result);
    }

    @Test
    void testGenerateNumbersWithZeroElements() {
        int n = 0;
        Queue<String> expected = new LinkedList<>();

        Queue<String> result = GenerateBinaryNumbers.generateNumbers(n);
        assertEquals(expected, result);
    }

    @Test
    void testGenerateNumbersWithTenElements() {
        int n = 10;
        Queue<String> expected = new LinkedList<>(Arrays.asList("1", "10", "11", "100", "101", "110", "111", "1000", "1001", "1010"));

        Queue<String> result = GenerateBinaryNumbers.generateNumbers(n);
        assertEquals(expected, result);
    }
}
