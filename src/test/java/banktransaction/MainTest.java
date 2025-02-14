package banktransaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(100000);
    }

    @Test
    void testWithdraw_ValidAmount() throws CustomIllegalArgumentException, InsufficientBalanceException {
        account.withdraw(11000);
        assertEquals(89000, account.balance);
    }

    @Test
    void testWithdraw_NegativeAmount() {
        Exception exception = assertThrows(CustomIllegalArgumentException.class, () -> account.withdraw(-500));
        assertEquals("Invalid Amount", exception.getMessage());
    }

    @Test
    void testWithdraw_InsufficientBalance() {
        Exception exception = assertThrows(InsufficientBalanceException.class, () -> account.withdraw(150000));
        assertEquals("Insufficient balance", exception.getMessage());
    }
}
