package exceptionpropagation;

public class multipleMethods {
    static void method1(){
        int c =10/0;
    }
    static void method2(){
        method1();
    }

    public static void main(String[] args) {
        try {
            method2();
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
            System.out.println("Handled Exception in main");
        }
    }
}
