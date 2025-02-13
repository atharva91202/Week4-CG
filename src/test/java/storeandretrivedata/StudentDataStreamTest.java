package storeandretrivedata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDataStreamTest {
    private static final String TEST_FILE = "test_student_data.bin";

    @Test
    void testStoreAndRetrieveStudentData() {
        assertDoesNotThrow(() -> {
            StudentDataStream.storeStudentData(TEST_FILE, 103, "Charlie", 3.9);
            StudentDataStream.retrieveStudentData(TEST_FILE);
        });
    }
}