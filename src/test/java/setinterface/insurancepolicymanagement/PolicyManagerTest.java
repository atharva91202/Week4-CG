package setinterface.insurancepolicymanagement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;


class PolicyManagerTest {
    private PolicyManager policyManager;
    private Policy policy1, policy2, policy3, duplicatePolicy;

    @BeforeEach
    void setUp() {
        policyManager = new PolicyManager();

        Calendar cal = Calendar.getInstance();

        cal.set(2025, Calendar.JUNE, 15); // Future expiry date
        policy1 = new Policy(101, "Alice", cal.getTime(), "Health", 5000.0);

        cal.set(2024, Calendar.SEPTEMBER, 1); // Past expiry date
        policy2 = new Policy(102, "Bob", cal.getTime(), "Auto", 3000.0);

        cal.set(2024, Calendar.DECEMBER, 5); // Within 30 days
        policy3 = new Policy(103, "Charlie", cal.getTime(), "Life", 4000.0);

        duplicatePolicy = new Policy(101, "Alice", cal.getTime(), "Health", 5000.0); // Same as policy1

        policyManager.addPolicy(policy1);
        policyManager.addPolicy(policy2);
        policyManager.addPolicy(policy3);
        policyManager.addPolicy(duplicatePolicy); // Adding duplicate
    }

    @Test
    void testUniquePolicies() {
        assertEquals(3, policyManager.hashSetPolicies.size(), "Should contain only unique policies");
    }

    @Test
    void testDisplayExpiringPolicies() {
        assertTrue(policyManager.treeSetPolicies.contains(policy3), "Policy3 should be included in expiring policies list");
    }


    @Test
    void testDisplayPoliciesWithCoverageType() {
        // Redirect System.out to capture the printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Call the method that prints the policies
        policyManager.displayPoliciesWithCoverageType("Health");

        // Restore original System.out
        System.setOut(originalOut);

        // Convert output to a string and check for expected policy details
        String output = outputStream.toString();

        assertTrue(output.contains("Policy Number : " + policy1.getPolicyNumber()), "Policy1 should be printed in the output");
        assertFalse(output.contains("Policy Number : " + policy2.getPolicyNumber()), "Policy2 should not be printed in the output");
    }


    @Test
    void testDuplicatePolicies() {
        assertEquals(3, policyManager.hashSetPolicies.size(), "Duplicates should be removed, only unique policies stored");
    }
}