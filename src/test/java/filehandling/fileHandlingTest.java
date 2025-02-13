package filehandling;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class fileHandlingTest {

    @Test
    void testFileCopySuccess() throws IOException {
        String sourceFile = "testSource.txt";
        String destinationFile = "testCopy.txt";

        // Create a test source file
        try (FileWriter writer = new FileWriter(sourceFile)) {
            writer.write("Hello, World!");
        }

        // Copy file
        fileHandling.copyFile(sourceFile, destinationFile);

        // Verify content
        assertTrue(new File(destinationFile).exists());

        // Read content from copied file
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(destinationFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }

        assertEquals("Hello, World!", content.toString());

        // Cleanup
        new File(sourceFile).delete();
        new File(destinationFile).delete();
    }


    }
