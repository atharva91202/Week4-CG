package setinterface.insurancepolicymanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PolicyTest {
    private Policy policy1;
    private Policy policy2;
    private Policy policy3;

    @BeforeEach
    void setUp() {
        policy1 = new Policy(101, "John Doe", new Date(2025, 5, 20), "Health", 5000.0);
        policy2 = new Policy(102, "Jane Doe", new Date(2024, 10, 15), "Auto", 3000.0);
        policy3 = new Policy(101, "John Doe", new Date(2025, 5, 20), "Health", 5000.0); // Same policy number as policy1
    }

    @Test
    void testEqualsAndHashCode() {
        assertEquals(policy1, policy3); // Policies with the same policy number should be equal
        assertNotEquals(policy1, policy2); // Different policy numbers should not be equal
        assertEquals(policy1.hashCode(), policy3.hashCode()); // Hash codes should also match
    }

    @Test
    void testCompareTo() {
        assertTrue(policy2.compareTo(policy1) < 0); // policy2 expires earlier than policy1
        assertTrue(policy1.compareTo(policy2) > 0); // policy1 expires later than policy2
        assertEquals(0, policy1.compareTo(policy3)); // Same expiry date should return 0
    }

    @Test
    void testToString() {
        String expectedOutput = "  Policy Number : 101\n" +
                "  Policy Holder Name : John Doe\n" +
                "  Expiry Date : " + policy1.getExpiryDate() + "\n" +
                "  Coverage Type : Health\n" +
                "  Premium Amount : INR 5000.0\n";
        assertEquals(expectedOutput, policy1.toString());
    }
}
