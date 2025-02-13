package mapinterface.bankingsystem;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankingSystemTest {
    private BankingSystem bankingSystem;

    @BeforeEach
    void setUp() {
        bankingSystem = new BankingSystem();
        bankingSystem.addAccount(101L, 1500.00);
        bankingSystem.addAccount(102L, 3000.00);
        bankingSystem.addAccount(103L, 500.00);
    }

    @Test
    void testDeposit() {
        bankingSystem.deposit(101L, 500.00);
        assertEquals(2000.00, bankingSystem.getBalance(101L));
    }

    @Test
    void testDepositToNonExistingAccount() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        bankingSystem.deposit(999L, 300.00);

        System.setOut(System.out);
        String output = outputStream.toString();
        assertTrue(output.contains("Account not found: 999"));
    }

    @Test
    void testWithdrawalRequest() {
        bankingSystem.requestWithdrawal(101L);
        assertTrue(bankingSystem.hasWithdrawalRequest(101L));
    }

    @Test
    void testProcessWithdrawals() {
        bankingSystem.requestWithdrawal(103L); // 500 balance
        bankingSystem.processWithdrawals();
        assertEquals(400.00, bankingSystem.getBalance(103L));
    }

    @Test
    void testInsufficientFunds() {
        bankingSystem.addAccount(104L, 50.00);
        bankingSystem.requestWithdrawal(104L);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        bankingSystem.processWithdrawals();

        System.setOut(System.out);
        String output = outputStream.toString();
        assertTrue(output.contains("Insufficient balance in account 104"));
    }

    @Test
    void testDisplaySortedAccounts() {
        bankingSystem.deposit(103L, 100.00); // 500 → 600
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        bankingSystem.displaySortedAccounts();

        System.setOut(System.out);
        String output = outputStream.toString();
        assertTrue(output.contains("Account: 103 - Balance: $600.0"));
    }
}
