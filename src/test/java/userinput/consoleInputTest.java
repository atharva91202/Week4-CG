package userinput;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class consoleInputTest {
    @Test
    void testUserInputToFile() throws IOException {
        String testInput = "John\n28\nC++\n";
        System.setIn(new ByteArrayInputStream(testInput.getBytes())); // Mock user input

        // Redirect console output (optional)
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        consoleInput.main(null);

        // Verify file content
        File file = new File("C:\\my doucments\\file\\user_input.txt");
        assertTrue(file.exists());

        // Read file and verify content
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        }

        assertTrue(fileContent.toString().contains("Name: John"));
        assertTrue(fileContent.toString().contains("Age: 28"));
        assertTrue(fileContent.toString().contains("Favorite Language: C++"));

        // Cleanup
        file.delete();
    }
}
