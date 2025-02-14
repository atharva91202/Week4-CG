package banktransaction;

public class CustomIllegalArgumentException extends Exception{
    public CustomIllegalArgumentException(String message) {
        super(message);
    }
}
