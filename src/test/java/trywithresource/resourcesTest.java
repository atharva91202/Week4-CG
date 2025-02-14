package trywithresource;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class resourcesTest {
    @Test
    void testFileReading() throws IOException {
        String testFilePath = "test_info.txt";

        // Create a test file with sample content
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath))) {
            writer.write("Hello, World!\n");
            writer.write("This is a test file.");
        }

        // Capture output using ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call main method
       resources.main(new String[]{});

        // Restore system output
        System.setOut(System.out);

        // Verify output
        String output = outputStream.toString();
        assertTrue(output.contains("Hello, World!"));
        assertTrue(output.contains("This is a test file."));

        // Cleanup - Delete test file
        new File(testFilePath).delete();
    }

    // ✅ Test for non-existent file
    @Test
    void testFileNotFound() {
        String fakePath = "non_existent.txt";

        // Capture error output
        ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(errorStream));

        // Call main method
        resources.main(new String[]{});

        // Restore system output
        System.setOut(System.out);

        // Check if error message is displayed
        assertTrue(errorStream.toString().contains("Error: Unable to read file"));
    }
}