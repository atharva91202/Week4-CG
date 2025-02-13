package bufferedstreams;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class bufferedStreamsTest {

    @Test
    void testBufferedFileCopy() throws IOException {
        String sourceFile = "testSource.txt";
        String destinationFile = "testBufferedCopy.txt";

        // Create a sample file
        try (FileWriter writer = new FileWriter(sourceFile)) {
            for (int i = 0; i < 10000; i++) {
                writer.write("Sample line " + i + "\n");
            }
        }

        // Copy file using buffered method
        bufferedStreams.bufferCopy(sourceFile, destinationFile);

        // Check if file exists and has content
        assertTrue(new File(destinationFile).exists());
        assertTrue(new File(destinationFile).length() > 0);

        // Cleanup
        new File(sourceFile).delete();
        new File(destinationFile).delete();
    }
}