package mapinterface.insurancepolicymanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PolicyManager policyManager = new PolicyManager();

        // Date formatter
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            // Creating policies
            Policy policy1 = new Policy(101, "Alice Johnson", dateFormat.parse("15-02-2025"), "Health", 5000.00);
            Policy policy2 = new Policy(102, "Bob Smith", dateFormat.parse("10-03-2024"), "Car", 12000.50);
            Policy policy3 = new Policy(103, "Charlie Brown", dateFormat.parse("05-03-2024"), "Home", 8000.75);
            Policy policy4 = new Policy(104, "David Williams", dateFormat.parse("20-02-2025"), "Life", 15000.25);

            // Adding policies
            policyManager.addPolicy(policy1);
            policyManager.addPolicy(policy2);
            policyManager.addPolicy(policy3);
            policyManager.addPolicy(policy4);

            // Display all policies
            System.out.println("All Policies:");
            policyManager.displayAllPolicies();

            // Retrieve a policy
            System.out.println("Retrieved Policy:");
            System.out.println(policyManager.getPolicy(102));

            // Get policies expiring in the next 30 days
            System.out.println("Policies Expiring Soon:");
            List<Policy> expiringPolicies = policyManager.getExpiringPolicies();
            for (Policy policy : expiringPolicies) {
                System.out.println(policy);
            }

            // Get policies by policyholder name
            System.out.println("Policies for Bob Smith:");
            List<Policy> bobPolicies = policyManager.getPoliciesByHolder("Bob Smith");
            for (Policy policy : bobPolicies) {
                System.out.println(policy);
            }

            // Remove expired policies
            policyManager.removeExpiredPolicies();
            System.out.println("Policies after removing expired ones:");
            policyManager.displayAllPolicies();

        } catch (ParseException e) {
            System.out.println("Error parsing dates: " + e.getMessage());
        }
    }
}
