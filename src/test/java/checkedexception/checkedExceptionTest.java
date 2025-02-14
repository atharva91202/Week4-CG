package checkedexception;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class checkedExceptionTest {
    private static final String TEST_FILE = "test_data.txt";

    @Test
    void testFileExists() throws IOException {
        // Create a test file with content
        Files.write(Path.of(TEST_FILE), "Hello, world!".getBytes());

        // Test reading from the file
        assertDoesNotThrow(() -> checkedException.main(new String[]{}));

        // Clean up test file
        new File(TEST_FILE).delete();
    }

    @Test
    void testFileNotFound() {
        assertDoesNotThrow(() -> checkedException.main(new String[]{}));
    }
}
