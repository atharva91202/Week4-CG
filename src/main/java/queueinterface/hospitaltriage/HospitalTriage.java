package queueinterface.hospitaltriage;

import java.util.PriorityQueue;

class Patient implements Comparable<Patient>{
    public String name;
    public int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient other){
        return Integer.compare(other.severity, this.severity);
    }
}

public class HospitalTriage{
    public static void main(String[] args) {
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>();

        patientQueue.add(new Patient("Tarun", 2));
        patientQueue.add(new Patient("Sam", 4));
        patientQueue.add(new Patient("John", 1));

        while (!patientQueue.isEmpty()){
            System.out.println(patientQueue.poll().name);
        }
    }
}