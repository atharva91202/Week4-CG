package serialization;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectSerializationTest {
    private static final String TEST_FILE = "Employee_data.txt";

    @BeforeEach
    void setUp() {
        // Create a sample list of employees before each test
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "Engineering", 75000.0));
        employees.add(new Employee(2, "Jane Smith", "Marketing", 65000.0));

        // Serialize the employees
        ObjectSerialization.serializeEmployees(employees);
    }

    @AfterEach
    void tearDown() {
        // Delete the test file after each test
        File file = new File(TEST_FILE);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testSerialization() {
        // Ensure that the serialized file exists
        File file = new File(TEST_FILE);
        assertTrue(file.exists(), "Serialized file should be created");
        assertTrue(file.length() > 0, "Serialized file should not be empty");
    }

    @Test
    void testDeserialization() {
        // Deserialize the employees
        List<Employee> employees = ObjectSerialization.deserializeEmployees();

        // Verify that deserialized data matches the expected data
        assertNotNull(employees, "Deserialized list should not be null");
        assertEquals(2, employees.size(), "Number of deserialized employees should match");

        // Validate individual employee details (Note: You may need to modify Employee class to have getters)
        Employee emp1 = employees.get(0);
        Employee emp2 = employees.get(1);

        assertNotNull(emp1, "First employee should not be null");
        assertNotNull(emp2, "Second employee should not be null");
    }
}