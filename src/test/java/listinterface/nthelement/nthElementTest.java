package listinterface.nthelement;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class nthElementTest {

    @Test
    void testFindNthFromEnd() {
        LinkedList<String> input = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        assertEquals("D", nthElement.elementFromLast(input, 2));
    }

    @Test
    void testFindNthFromEndFirstElement() {
        LinkedList<String> input = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        assertEquals("A", nthElement.elementFromLast(input, 5));
    }

    @Test
    void testFindNthFromEndOutOfBounds() {
        LinkedList<String> input = new LinkedList<>(Arrays.asList("A", "B", "C"));
        assertNull(nthElement.elementFromLast(input, 4));
    }
}
