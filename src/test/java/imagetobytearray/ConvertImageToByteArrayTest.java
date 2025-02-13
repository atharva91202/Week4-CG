package imagetobytearray;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;
public class ConvertImageToByteArrayTest {
    private static final String SOURCE_IMAGE = "test_image.jpg"; // Replace with actual test image path
    private static final String DEST_IMAGE = "test_copy.jpg";

    @BeforeEach
    void setUp() throws IOException {
        // Create a test image file
        File file = new File(SOURCE_IMAGE);
        if (!file.exists()) {
            Files.write(file.toPath(), new byte[1024]); // Create a 1KB dummy image
        }
    }

    @AfterEach
    void tearDown() {
        // Cleanup test files
        new File(SOURCE_IMAGE).delete();
        new File(DEST_IMAGE).delete();
    }

    @Test
    void testImageToByteArray() throws IOException {
        byte[] imageData = ConvertImageToByteArray.imageToByteArray(SOURCE_IMAGE);
        assertNotNull(imageData, "Byte array should not be null");
        assertTrue(imageData.length > 0, "Byte array should not be empty");
    }

    @Test
    void testByteArrayToImage() throws IOException {
        byte[] imageData = ConvertImageToByteArray.imageToByteArray(SOURCE_IMAGE);
        ConvertImageToByteArray.byteArrayToImage(imageData, DEST_IMAGE);

        File outputFile = new File(DEST_IMAGE);
        assertTrue(outputFile.exists(), "Output image file should be created");
        assertEquals(new File(SOURCE_IMAGE).length(), outputFile.length(), "File sizes should match");
    }
}