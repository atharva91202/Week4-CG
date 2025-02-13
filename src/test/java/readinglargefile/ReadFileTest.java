package readinglargefile;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {
    private final String testFilePath = "C:\\my doucments\\file\\100mb-examplefile-com.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Create test file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath))) {
            writer.write("This is a normal log line.\n");
            writer.write("Warning: Something might be wrong.\n");
            writer.write("Error: A critical failure occurred.\n");
            writer.write("Another error happened here.\n");
        }
    }

    @AfterEach
    void tearDown() {
        // Delete test file after tests
        File file = new File(testFilePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testReadFile_WithErrorMessages() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ReadFile.readFile(testFilePath);

        String output = outputStream.toString();
        assertTrue(output.contains("Error: A critical failure occurred."));
        assertTrue(output.contains("Another error happened here."));
        assertTrue(output.contains("Read file successfully"));
    }

    @Test
    void testReadFile_WithoutErrorMessages() throws IOException {
        // Create a file without "error"
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath))) {
            writer.write("This is a normal log line.\n");
            writer.write("Warning: Something might be wrong.\n");
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ReadFile.readFile(testFilePath);

        String output = outputStream.toString();
        assertFalse(output.contains("error"), "No error messages should be printed.");
        assertTrue(output.contains("Read file successfully"));
    }

    @Test
    void testReadFile_EmptyFile() throws IOException {
        // Create an empty file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath))) {}

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ReadFile.readFile(testFilePath);

        String output = outputStream.toString();
        assertTrue(output.contains("Read file successfully"), "Should indicate successful read.");
    }

    @Test
    void testReadFile_NonExistingFile() {
        String nonExistingFilePath = "E:\\Files\\non_existing.txt";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ReadFile.readFile(nonExistingFilePath);

        String output = outputStream.toString();
        assertTrue(output.contains("IOException"), "Should catch and display IOException.");
    }
}
