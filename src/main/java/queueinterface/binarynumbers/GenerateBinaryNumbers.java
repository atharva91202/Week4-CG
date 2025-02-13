package queueinterface.binarynumbers;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    public static Queue<String> generateNumbers(int n){
        Queue<String> binaryNumbers = new LinkedList<>();
        Queue<String> temp = new LinkedList<>();
        temp.add("1");

        while(binaryNumbers.size() < n){
            String current = temp.poll();

            binaryNumbers.add(current);
            temp.add(current + "0");
            temp.add(current + "1");
        }
        return binaryNumbers;
    }

    public static void main(String[] args) {
        int n = 5;

        Queue<String> binaryNumbers = generateNumbers(n);
        System.out.println("First " + n + " Binary Numbers :- " + binaryNumbers);
    }
}
