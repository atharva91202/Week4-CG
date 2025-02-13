package mapinterface.groupemployee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class GroupEmployeeTest {

    @Test
    void testGroupEmployees() {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Ashish", "IT"),
                new Employee("Atharva", "Finance"),
                new Employee("Akriti", "HR"),
                new Employee("Sachin", "Finance")
        ));

        HashMap<String, List<Employee>> expected = new HashMap<>();
        expected.put("IT", Arrays.asList(new Employee("Ashish", "IT")));
        expected.put("Finance", Arrays.asList(
                new Employee("Atharva", "Finance"),
                new Employee("Sachin", "Finance")
        ));
        expected.put("HR", Arrays.asList(new Employee("Akriti", "HR")));

        HashMap<String, List<Employee>> result = GroupEmployee.groupEmployees(employees);

        assertEquals(expected.size(), result.size());
        assertEquals(expected.get("IT").size(), result.get("IT").size());
        assertEquals(expected.get("Finance").size(), result.get("Finance").size());
        assertEquals(expected.get("HR").size(), result.get("HR").size());
    }

    @Test
    void testGroupEmployeesWithEmptyList() {
        List<Employee> employees = new ArrayList<>();

        HashMap<String, List<Employee>> result = GroupEmployee.groupEmployees(employees);

        assertTrue(result.isEmpty());
    }
}
