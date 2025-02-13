package queueinterface.circularbuffer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CircularBufferTest {

    @Test
    void testEnqueueWithoutOverwrite() {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);

        // Expected output: "1 2 3"
        assertEquals("1 2 3", buffer.printBuffer());
    }

    @Test
    void testEnqueueWithOverwrite() {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        buffer.enqueue(4); // Overwrites 1

        // Expected output: "2 3 4"
        assertEquals("2 3 4", buffer.printBuffer());
    }

    @Test
    void testMultipleOverwrites() {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.enqueue(10);
        buffer.enqueue(20);
        buffer.enqueue(30);
        buffer.enqueue(40); // Overwrites 10
        buffer.enqueue(50); // Overwrites 20

        // Expected output: "30 40 50"
        assertEquals("30 40 50", buffer.printBuffer());
    }

    @Test
    void testEmptyBuffer() {
        CircularBuffer buffer = new CircularBuffer(3);

        // Expected output: ""
        assertEquals("", buffer.printBuffer());
    }
}
