package mapinterface.votingsystem;

public class Main {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Casting votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");

        // Display votes in order
        votingSystem.displayVoteOrder();

        // Display final sorted results
        votingSystem.displayResults();
    }
}