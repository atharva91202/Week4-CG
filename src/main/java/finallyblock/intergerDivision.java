package finallyblock;

import java.util.InputMismatchException;
import java.util.Scanner;

public class intergerDivision {
    static double division(double a , double b){
        if(b == 0){
            throw new ArithmeticException("Division by zero !!");
        }

        return a/b;
    }

    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter value of a : ");
            if (!sc.hasNextInt()) {
                throw new InputMismatchException("Input mismatch! Please enter an integer.");
            }
            int a = sc.nextInt();

            System.out.print("Enter value of b : ");
            if (!sc.hasNextInt()) {
                throw new InputMismatchException("Input mismatch! Please enter an integer.");
            }
            int b = sc.nextInt();

            System.out.println("Result : " + division(a, b));

        } catch (ArithmeticException e){
            System.out.println("Arithmetic Exception : " + e.getMessage());
        } finally {
            System.out.println("Operation completed !!");
        }
    }
}
