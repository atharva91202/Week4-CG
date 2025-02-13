package mapinterface.insurancepolicymanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PolicyManagerTest {
    private PolicyManager policyManager;
    private Policy policy1, policy2, policy3, policy4;

    @BeforeEach
    void setUp() {
        policyManager = new PolicyManager();

        Calendar calendar = Calendar.getInstance();

        // Policy 1 - Expiring in 10 days
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        Date expiry1 = calendar.getTime();
        policy1 = new Policy(101, "Alice", expiry1, "Health", 5000.0);

        // Policy 2 - Expiring in 25 days
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 25);
        Date expiry2 = calendar.getTime();
        policy2 = new Policy(102, "Bob", expiry2, "Auto", 3000.0);

        // Policy 3 - Expired (30 days ago)
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -30);
        Date expiry3 = calendar.getTime();
        policy3 = new Policy(103, "Charlie", expiry3, "Life", 7000.0);

        // Policy 4 - Expiring in 40 days
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 40);
        Date expiry4 = calendar.getTime();
        policy4 = new Policy(104, "Alice", expiry4, "Home", 9000.0);

        policyManager.addPolicy(policy1);
        policyManager.addPolicy(policy2);
        policyManager.addPolicy(policy3);
        policyManager.addPolicy(policy4);
    }

    @Test
    void testAddAndGetPolicy() {
        Policy retrievedPolicy = policyManager.getPolicy(101);
        assertNotNull(retrievedPolicy);
        assertEquals("Alice", retrievedPolicy.getPolicyHolderName());
    }

    @Test
    void testGetExpiringPolicies() {
        List<Policy> expiringPolicies = policyManager.getExpiringPolicies();
        assertTrue(expiringPolicies.contains(policy1));
        assertTrue(expiringPolicies.contains(policy2));
        assertFalse(expiringPolicies.contains(policy3));
        assertFalse(expiringPolicies.contains(policy4));
    }

    @Test
    void testGetPoliciesByHolder() {
        List<Policy> alicePolicies = policyManager.getPoliciesByHolder("Alice");
        assertEquals(2, alicePolicies.size());
        assertTrue(alicePolicies.contains(policy1));
        assertTrue(alicePolicies.contains(policy4));
    }

    @Test
    void testRemoveExpiredPolicies() {
        policyManager.removeExpiredPolicies();
        assertNull(policyManager.getPolicy(103)); // Policy 3 should be removed
    }

    @Test
    void testDisplayAllPolicies() {
        policyManager.displayAllPolicies(); // Should print all policies in insertion order
    }
}
