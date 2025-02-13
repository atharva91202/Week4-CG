package setinterface.insurancepolicymanagement;

import java.util.*;

public class PolicyManager {
    public Set<Policy> hashSetPolicies = new HashSet<>();
    public Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    public Set<Policy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(Policy policy){
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayUniquePolicies(){
        System.out.println("Displaying unique policies :- ");
        for(Policy policy : hashSetPolicies){
            System.out.println(policy);
        }
    }

    public void displayExpiringPolicies(){
        System.out.println("Displaying policies expiring within 30 days");
        Date today = new Date();        // fetching today's date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, 30); // storing date 30 days later
        Date thirtyDaysLater = calendar.getTime();

        for(Policy policy : treeSetPolicies){   // determining policies expiring in 30 days
            if(policy.getExpiryDate().before(thirtyDaysLater)){
                System.out.println(policy);
            }
        }
    }

    public void displayPoliciesWithCoverageType(String type){
        System.out.println("Policies with coverage type " + type);
        for(Policy policy : hashSetPolicies){
            if(policy.getCoverageType().equalsIgnoreCase(type)){
                System.out.println(policy);
            }
        }
    }

    public void displayDuplicatePolicies(){
        boolean found = false;
        System.out.println("Displaying duplicate policies :- ");
        HashMap<Integer, Integer> policies = new HashMap<>();


        // storing policy numbers in a map
        for(Policy policy : hashSetPolicies){
            policies.put(policy.getPolicyNumber(), policies.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }

        // findind duplicate policies
        for(Map.Entry<Integer, Integer> policyNumber : policies.entrySet()){
            if(policyNumber.getValue() > 1){
                found = true;
                System.out.println(policyNumber);
            }
        }

        if(!found){
            System.out.println("No duplicate policies found !!\n");
        }
    }
}
