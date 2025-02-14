package customexception;

class CustomException extends Exception{
    public CustomException(String message){
        super(message);
    }
}
public class customExceptionExample {
    static void validateAge(int age) throws CustomException{
        if (age<18){
            throw new CustomException("Age must be over 18");
        }
    }
    public static void main(String[] args) {
        try{
            validateAge(15);
        }catch (CustomException e){
            System.out.println("Custom Exception Caught" + e.getMessage());
        }
    }
}
