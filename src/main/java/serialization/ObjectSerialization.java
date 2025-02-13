package serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Employee class implementing Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures compatibility during deserialization
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayEmployee() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
    }
}

public class ObjectSerialization {
    private static final String FILE_NAME = "C:\\my doucments\\file\\employeeData.txt"; // Serialized file

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        // Taking user input for employees
        System.out.print("Enter number of employees: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < count; i++) {
            System.out.println("Enter details for Employee " + (i + 1));
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Department: ");
            String department = scanner.nextLine();

            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            employees.add(new Employee(id, name, department, salary));
        }

        // Serialize employee list
        serializeEmployees(employees);

        // Deserialize and display employee data
        deserializeEmployees();

        scanner.close();
    }

    // Method to serialize the list of employees to a file
    public static void serializeEmployees(List<Employee> employees) {
        try (FileOutputStream fos = new FileOutputStream("Employee_data.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(employees);
            System.out.println("Object state is transferred to file");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    // Method to deserialize the list of employees from a file
    public static List<Employee> deserializeEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Employee_data.txt"))) {
            employees = (List<Employee>) in.readObject();
            System.out.println("Deserialized");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

}
