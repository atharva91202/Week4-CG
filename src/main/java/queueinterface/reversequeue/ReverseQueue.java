package queueinterface.reversequeue;

import java.util.*;

public class ReverseQueue {

    public static <T> Queue<T> reverseQueue(Queue<T> queue){
        int i = 0, j = queue.size()-1;
        Stack<T> stack = new Stack<>();

        while(!queue.isEmpty()){
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()){
            queue.offer(stack.peek());
            stack.pop();
        }

        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10,20,30,40,50));

        // displaying original queue
        System.out.println("Original Queue :-");
        System.out.println(queue);

        // reversing a queue
        Queue<Integer> revesedQueue = reverseQueue(queue);

        // displaying reversed queue
        System.out.println("Reversed Queue :-");
        System.out.println(revesedQueue);
    }
}
