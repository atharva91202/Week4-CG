package runtimeexception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class runtimeException {
    static int divide(int a , int b){
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

            System.out.println("Result : " + divide(a, b));

        } catch (InputMismatchException e){
            System.out.println("Input Mismatch Exception : " + e.getMessage());
        } catch (ArithmeticException e){
            System.out.println("Arithmetic Exception : " + e.getMessage());
        }
    }
}
