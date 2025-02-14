package banktransaction;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100000);

        try {
            account.withdraw(11000);
        } catch (CustomIllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
