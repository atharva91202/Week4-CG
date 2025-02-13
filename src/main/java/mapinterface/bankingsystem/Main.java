package mapinterface.bankingsystem;

public class Main {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Adding accounts
        bank.addAccount(101L, 1500.00);
        bank.addAccount(102L, 3000.00);
        bank.addAccount(103L, 500.00);
        bank.addAccount(104L, 7000.00);
        bank.addAccount(105L, 2000.00);

        // Depositing money
        bank.deposit(101L, 500.00);
        bank.deposit(103L, 300.00);

        // Requesting withdrawals
        bank.requestWithdrawal(101L);
        bank.requestWithdrawal(103L);
        bank.requestWithdrawal(105L);

        // Display sorted accounts
        bank.displaySortedAccounts();

        // Processing withdrawals
        bank.processWithdrawals();

        // Display sorted accounts after withdrawals
        bank.displaySortedAccounts();
    }
}