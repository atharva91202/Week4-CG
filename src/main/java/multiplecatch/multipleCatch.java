package multiplecatch;

import java.util.Scanner;

public class multipleCatch {
    static void arrayTraverse(int [] array , int idx){
        try{
            System.out.println("Value at index " + idx + " is " + array[idx]);
        }catch (ArrayIndexOutOfBoundsException e ){
            System.out.println("Invalid Index" + e.getMessage());
        }catch (NullPointerException o){
            System.out.println("Array is not initialised " + o.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements you wanna store");
        int n = sc.nextInt();
        int inputArray []=new int[n];
        System.out.println("Enter the elements of array");
        for (int i =0;i<n;i++){
            inputArray[i] = sc.nextInt();
        }
        System.out.println("Enter target index");
        int idx = sc.nextInt();
        try{
            arrayTraverse(inputArray,idx);
        }catch (ArrayIndexOutOfBoundsException e ){
            System.out.println(e);
        }catch (NullPointerException o){
            System.out.println(o);
        }
        sc.close();
    }
}
