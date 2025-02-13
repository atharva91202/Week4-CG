package mapinterface.groupemployee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testEmployeeCreation() {
        Employee employee = new Employee("John", "IT");

        assertEquals("John", employee.name);
        assertEquals("IT", employee.departemnt);
    }

    @Test
    void testToString() {
        Employee employee = new Employee("Alice", "HR");

        assertEquals("Alice", employee.toString());
    }
}
