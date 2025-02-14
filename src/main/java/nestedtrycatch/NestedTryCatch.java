package nestedtrycatch;

public class NestedTryCatch {
    static int division(int array[] , int idx , int divisor){
        try {
            int element = array[idx];
            try {
                return element / divisor;
            }catch (ArithmeticException e){
                throw new ArithmeticException("Cannot Divide by Zero");
            }
        }catch (ArrayIndexOutOfBoundsException o){
            throw new ArrayIndexOutOfBoundsException("Invalid array index");
        }
    }

    public static void main(String[] args) {
        try {
            int [] array = {2,3,4,5,6,7,8,9};
            int idx = 4;
            int divisor = 2;

            System.out.println("Result " + division(array,idx,divisor));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
