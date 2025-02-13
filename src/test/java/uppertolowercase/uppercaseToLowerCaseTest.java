package uppertolowercase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
public class uppercaseToLowerCaseTest {
    private static final String TEST_INPUT_FILE = "test_input.txt";
    private static final String TEST_OUTPUT_FILE = "test_output.txt";

    @BeforeEach
    void setUp() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_INPUT_FILE))) {
            writer.write("HELLO WORLD\nJAVA TESTING\nSTREAM API");
        }
    }

    @AfterEach
    void tearDown() {
        new File(TEST_INPUT_FILE).delete();
        new File(TEST_OUTPUT_FILE).delete();
    }

    @Test
    void testConvertUppercaseToLowercase() throws IOException {
        uppercaseToLowerCase.convertUppercaseToLowercase(TEST_INPUT_FILE, TEST_OUTPUT_FILE);

        File outputFile = new File(TEST_OUTPUT_FILE);
        assertTrue(outputFile.exists(), "Output file should be created");

        try (BufferedReader reader = new BufferedReader(new FileReader(TEST_OUTPUT_FILE))) {
            assertEquals("hello world", reader.readLine());
            assertEquals("java testing", reader.readLine());
            assertEquals("stream api", reader.readLine());
        }
    }
}