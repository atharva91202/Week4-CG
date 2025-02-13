package queueinterface.hospitaltriage;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HospitalTriageTest {

    @Test
    void testPatientPriorityOrder() {
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>();
        patientQueue.add(new Patient("Tarun", 2));
        patientQueue.add(new Patient("Sam", 4));
        patientQueue.add(new Patient("John", 1));

        List<String> expectedOrder = Arrays.asList("Sam", "Tarun", "John");
        List<String> actualOrder = new ArrayList<>();

        while (!patientQueue.isEmpty()) {
            actualOrder.add(patientQueue.poll().name);
        }

        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    void testSinglePatient() {
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>();
        patientQueue.add(new Patient("Alice", 3));

        assertEquals("Alice", patientQueue.poll().name);
        assertTrue(patientQueue.isEmpty());
    }

    @Test
    void testEmptyQueue() {
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>();
        assertNull(patientQueue.poll());
    }

    @Test
    void testSameSeverityOrder() {
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>();
        patientQueue.add(new Patient("Alice", 3));
        patientQueue.add(new Patient("Bob", 3));
        patientQueue.add(new Patient("Charlie", 3));

        List<String> patients = new ArrayList<>();
        while (!patientQueue.isEmpty()) {
            patients.add(patientQueue.poll().name);
        }

        assertTrue(patients.containsAll(Arrays.asList("Alice", "Bob", "Charlie")));
    }
}
