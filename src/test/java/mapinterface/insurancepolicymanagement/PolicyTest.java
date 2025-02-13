package mapinterface.insurancepolicymanagement;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PolicyTest {

    @Test
    void testPolicyCreation() {
        Date expiryDate = new Date();
        Policy policy = new Policy(101, "John Doe", expiryDate, "Health", 5000.0);

        assertEquals(101, policy.getPolicyNumber());
        assertEquals("John Doe", policy.getPolicyHolderName());
        assertEquals(expiryDate, policy.getExpiryDate());
        assertEquals("Health", policy.getCoverageType());
        assertEquals(5000.0, policy.getPremiumAmount());
    }

    @Test
    void testCompareTo() {
        Date expiryDate1 = new Date(System.currentTimeMillis() + 100000);
        Date expiryDate2 = new Date(System.currentTimeMillis() + 200000);

        Policy policy1 = new Policy(101, "Alice", expiryDate1, "Auto", 3000.0);
        Policy policy2 = new Policy(102, "Bob", expiryDate2, "Home", 4000.0);

        assertTrue(policy1.compareTo(policy2) < 0);
        assertTrue(policy2.compareTo(policy1) > 0);
    }

    @Test
    void testEqualsAndHashCode() {
        Date expiryDate = new Date();
        Policy policy1 = new Policy(101, "John Doe", expiryDate, "Health", 5000.0);
        Policy policy2 = new Policy(101, "Jane Doe", expiryDate, "Life", 6000.0);
        Policy policy3 = new Policy(102, "Alice", expiryDate, "Auto", 3000.0);

        assertEquals(policy1, policy2);
        assertNotEquals(policy1, policy3);
        assertEquals(policy1.hashCode(), policy2.hashCode());
        assertNotEquals(policy1.hashCode(), policy3.hashCode());
    }

    @Test
    void testToString() {
        Date expiryDate = new Date();
        Policy policy = new Policy(101, "John Doe", expiryDate, "Health", 5000.0);

        String expected = "  Policy Number : 101\n" +
                "  Policy Holder Name : John Doe\n" +
                "  Expiry Date : " + expiryDate + "\n" +
                "  Coverage Type : Health\n" +
                "  Premium Amount : INR 5000.0\n";

        assertEquals(expected, policy.toString());
    }
}
