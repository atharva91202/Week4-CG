package mapinterface.insurancepolicymanagement;

import java.util.*;

public class PolicyManager {
    private Map<Integer, Policy> policyMap = new HashMap<>(); // Stores policies with unique IDs
    private Map<Integer, Policy> orderedPolicyMap = new LinkedHashMap<>(); // Maintains insertion order
    private TreeMap<Date, List<Policy>> sortedByExpiryDate = new TreeMap<>(); // Stores policies sorted by expiry date

    // Add a new policy
    public void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedByExpiryDate.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    // Retrieve policy by policy number
    public Policy getPolicy(Integer policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List all policies expiring within the next 30 days (excluding expired ones)
    public List<Policy> getExpiringPolicies() {
        List<Policy> expiringPolicies = new ArrayList<>();
        Date today = new Date();

        // Calculate the cutoff date (30 days from today)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date cutoffDate = calendar.getTime();

        // Naive iteration to filter policies expiring in the next 30 days (excluding expired ones)
        for (Map.Entry<Date, List<Policy>> entry : sortedByExpiryDate.entrySet()) {
            Date expiryDate = entry.getKey();
            if (expiryDate.after(today) && expiryDate.before(cutoffDate)) { // Only future expirations within 30 days
                expiringPolicies.addAll(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    // List policies by policyholder name
    public List<Policy> getPoliciesByHolder(String policyHolderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(policyHolderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        Date today = new Date();
        Iterator<Map.Entry<Date, List<Policy>>> iterator = sortedByExpiryDate.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Date, List<Policy>> entry = iterator.next();
            if (entry.getKey().before(today)) {
                for (Policy policy : entry.getValue()) {
                    policyMap.remove(policy.getPolicyNumber());
                    orderedPolicyMap.remove(policy.getPolicyNumber());
                }
                iterator.remove();
            }
        }
    }

    // List all policies in order of insertion
    public void displayAllPolicies() {
        for (Policy policy : orderedPolicyMap.values()) {
            System.out.println(policy);
        }
    }
}
