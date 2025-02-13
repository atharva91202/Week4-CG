package queueinterface.stackusingqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackUsingQueueTest {

    @Test
    void testPushAndPop() {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(5);
        stack.push(10);
        stack.push(15);

        assertEquals(15, stack.pop());
        assertEquals(10, stack.pop());
        assertEquals(5, stack.pop());
    }

    @Test
    void testPopFromEmptyStack() {
        StackUsingQueue stack = new StackUsingQueue();
        assertEquals(-1, stack.pop());
    }

    @Test
    void testTopElement() {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(7);
        stack.push(3);
        stack.push(9);

        assertEquals(9, stack.top()); // Top element should be 9
        assertEquals(9, stack.pop()); // Popping should return 9
        assertEquals(3, stack.top()); // Now, top should be 3
    }

    @Test
    void testIsEmpty() {
        StackUsingQueue stack = new StackUsingQueue();
        assertTrue(stack.isEmpty());

        stack.push(42);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }
}
