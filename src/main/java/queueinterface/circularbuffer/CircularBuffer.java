package queueinterface.circularbuffer;

public class CircularBuffer {
    private int[] buffer;
    private int front, rear, size, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int x) {
        rear = (rear + 1) % capacity;
        buffer[rear] = x;
        if (size < capacity) {
            size++;
        } else {
            front = (front + 1) % capacity; // Overwrite oldest
        }
    }

    public String printBuffer() {
        StringBuilder result = new StringBuilder();
        int index = front;
        for (int i = 0; i < size; i++) {
            result.append(buffer[index]).append(" ");
            index = (index + 1) % capacity;
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        CircularBuffer circularBuffer = new CircularBuffer(3);
        circularBuffer.enqueue(1);
        circularBuffer.enqueue(2);
        circularBuffer.enqueue(3);
        System.out.println(circularBuffer.printBuffer()); // Output: 1 2 3
        circularBuffer.enqueue(4);
        System.out.println(circularBuffer.printBuffer()); // Output: 2 3 4
    }
}
