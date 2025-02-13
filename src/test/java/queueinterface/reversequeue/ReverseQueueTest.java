package queueinterface.reversequeue;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class ReverseQueueTest {

    @Test
    void testReverseQueueWithIntegers() {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        Queue<Integer> expected = new LinkedList<>(Arrays.asList(5, 4, 3, 2, 1));

        Queue<Integer> result = ReverseQueue.reverseQueue(queue);
        assertEquals(expected, result);
    }

    @Test
    void testReverseQueueWithStrings() {
        Queue<String> queue = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        Queue<String> expected = new LinkedList<>(Arrays.asList("D", "C", "B", "A"));

        Queue<String> result = ReverseQueue.reverseQueue(queue);
        assertEquals(expected, result);
    }

    @Test
    void testReverseQueueWithEmptyQueue() {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> expected = new LinkedList<>();

        Queue<Integer> result = ReverseQueue.reverseQueue(queue);
        assertEquals(expected, result);
    }

    @Test
    void testReverseQueueWithSingleElement() {
        Queue<Integer> queue = new LinkedList<>(Collections.singletonList(10));
        Queue<Integer> expected = new LinkedList<>(Collections.singletonList(10));

        Queue<Integer> result = ReverseQueue.reverseQueue(queue);
        assertEquals(expected, result);
    }
}
