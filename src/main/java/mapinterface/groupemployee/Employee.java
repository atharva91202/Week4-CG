package mapinterface.groupemployee;

public class Employee {
    public String name;
    public String departemnt;

    public Employee(String name, String departemnt) {
        this.name = name;
        this.departemnt = departemnt;
    }

    @Override
    public String toString() {
        return name;
    }
}
