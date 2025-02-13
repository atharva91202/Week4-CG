package mapinterface.votingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class VotingSystemTest {
    private VotingSystem votingSystem;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        votingSystem = new VotingSystem();
        System.setOut(new PrintStream(outputStream)); // Redirect System.out to capture output

        // Casting votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
    }

    @Test
    void testVoteOrder() {
        votingSystem.displayVoteOrder();
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Alice : 3"));
        assertTrue(output.contains("Bob : 2"));
        assertTrue(output.contains("Charlie : 1"));
    }

    @Test
    void testSortedResults() {
        votingSystem.displayResults();
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Alice : 3 votes"));
        assertTrue(output.contains("Bob : 2 votes"));
        assertTrue(output.contains("Charlie : 1 votes"));
    }
}
