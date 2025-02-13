package queueinterface.stackusingqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int data){
        queue1.add(data);
    }

    public int pop(){
        if(queue1.isEmpty()){
            System.out.println("Empty Stack !!");
            return -1;
        }

        while (queue1.size() > 1){
            queue2.add(queue1.poll());
        }
        int topElement = queue1.poll();

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    public int top(){
        if(queue1.isEmpty()){
            System.out.println("Empty Stack !!");
            return -1;
        }

        while (queue1.size() > 1){
            queue2.add(queue1.poll());
        }
        int topElement = queue1.peek();
        queue2.add(queue1.poll());

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    public boolean isEmpty(){
        return queue1.isEmpty();
    }

    public void displayStack(){
        System.out.println("Stack elements : " + queue1);
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(1);
        stack.push(13);
        stack.push(15);

        System.out.println(stack.pop());
        stack.push(100);
        stack.push(10);

        stack.displayStack();
    }
}
