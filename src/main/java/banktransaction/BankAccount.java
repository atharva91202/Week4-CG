package banktransaction;

public class BankAccount {
    public double balance;

    public BankAccount(double balance){
        this.balance = balance;
    }

    public void withdraw(double withdrawAmount) throws CustomIllegalArgumentException, InsufficientBalanceException{
        if(withdrawAmount < 0){
            throw new CustomIllegalArgumentException("Invalid Amount");
        }

        if(withdrawAmount > balance){
            throw new InsufficientBalanceException("Insufficient balance");
        }

        balance -= withdrawAmount;
        System.out.println("Withdrawal successful, new balance : " + balance);
    }
}
