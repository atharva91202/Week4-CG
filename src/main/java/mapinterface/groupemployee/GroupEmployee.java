package mapinterface.groupemployee;

import java.util.*;

public class GroupEmployee {
    public static HashMap<String, List<Employee>> groupEmployees(List<Employee> employees){
        HashMap<String, List<Employee>> grouped =  new HashMap<>();

        for(Employee employee : employees){
            if(!grouped.containsKey(employee.departemnt)){      // if current department is not in map
                grouped.put(employee.departemnt, new ArrayList<>());
            }

            grouped.get(employee.departemnt).add(employee);    // adding current employee to department list
        }

        return grouped;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Ashish", "IT");
        Employee employee2 = new Employee("Atharva", "Finance");
        Employee employee3 = new Employee("Akriti", "HR");
        Employee employee4 = new Employee("Sachin", "Finance");

        List<Employee> employees = new ArrayList<>(Arrays.asList(employee1, employee2, employee3, employee4));

        HashMap<String, List<Employee>> departmentWiseList = groupEmployees(employees);

        System.out.println(departmentWiseList);
    }
}
