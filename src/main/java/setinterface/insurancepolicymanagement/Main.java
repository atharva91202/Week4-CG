package setinterface.insurancepolicymanagement;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        // Creating Calendar instances to set expiry dates
        Calendar cal = Calendar.getInstance();

        cal.set(2025, Calendar.MARCH, 20);
        Date expiry1 = cal.getTime();

        cal.set(2025, Calendar.APRIL, 10);
        Date expiry2 = cal.getTime();

        cal.set(2025, Calendar.FEBRUARY, 25);
        Date expiry3 = cal.getTime();

        cal.set(2025, Calendar.MARCH, 5);
        Date expiry4 = cal.getTime();

        cal.set(2025, Calendar.FEBRUARY, 28);
        Date expiry5 = cal.getTime();


        Policy policy1 = new Policy(1, "Alice", expiry1, "Health", 1200.00);
        Policy policy2 = new Policy(2, "Bob", expiry2, "Auto", 800.00);
        Policy policy3 = new Policy(3, "Charlie", expiry3, "Home", 1500.00);
        Policy policy4 = new Policy(4, "Alice", expiry4, "Health", 1300.00);
        Policy policy5 = new Policy(1, "Alice", expiry5, "Health", 1200.00);

        // Adding policies with Date objects
        manager.addPolicy(policy1);
        manager.addPolicy(policy2);
        manager.addPolicy(policy3);
        manager.addPolicy(policy4);
        manager.addPolicy(policy5); // Duplicate

        // Display all policies
        manager.displayUniquePolicies();

        // Display expiring soon
        manager.displayDuplicatePolicies();

        // displaying policies expiriring soon
        manager.displayExpiringPolicies();

        // displaying policies with given coverage type
        manager.displayPoliciesWithCoverageType("Auto");


        // Performance comparison
        System.out.println("\nPerformance Comparison:");
        long start, end;

        // HashSet Performance
        start = System.nanoTime();
        manager.hashSetPolicies.contains(policy2);
        end = System.nanoTime();
        System.out.println("HashSet Lookup Time: " + (end - start) + " ns");

        // LinkedHashSet Performance
        start = System.nanoTime();
        manager.linkedHashSetPolicies.contains(policy2);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Lookup Time: " + (end - start) + " ns");

        // TreeSet Performance
        start = System.nanoTime();
        manager.treeSetPolicies.contains(policy2);
        end = System.nanoTime();
        System.out.println("TreeSet Lookup Time: " + (end - start) + " ns");
    }
}