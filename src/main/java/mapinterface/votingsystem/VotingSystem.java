package mapinterface.votingsystem;

import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteCount = new HashMap<>(); // Stores votes
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>(); // Maintains vote order
    private TreeMap<Integer, List<String>> sortedResults = new TreeMap<>(Collections.reverseOrder()); // Sorts results by votes

    // Cast a vote for a candidate
    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteCount.get(candidate));
    }

    // Display votes in the order they were cast
    public void displayVoteOrder() {
        System.out.println("Votes in order of casting:");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Display final results sorted by votes
    public void displayResults() {
        sortedResults.clear();
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            int votes = entry.getValue();
            String candidate = entry.getKey();

            if (!sortedResults.containsKey(votes)) {
                sortedResults.put(votes, new ArrayList<>());
            }
            sortedResults.get(votes).add(candidate);
        }


        System.out.println("\nFinal Results (Sorted by Votes):");
        for (Map.Entry<Integer, List<String>> entry : sortedResults.entrySet()) {
            for (String candidate : entry.getValue()) {
                System.out.println(candidate + " : " + entry.getKey() + " votes");
            }
        }
    }
}