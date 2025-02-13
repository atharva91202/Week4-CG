package storeandretrivedata;

import java.io.*;

public class StudentDataStream {
    private static final String FILE_NAME = "C:\\my doucments\\file\\student_bin.txt";

    public static void main(String[] args) {
        try {
            // Store student data
            storeStudentData(FILE_NAME, 101, "Alice", 3.8);
            storeStudentData(FILE_NAME, 102, "Bob", 3.6);

            // Retrieve and display student data
            retrieveStudentData(FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void storeStudentData(String fileName, int rollNumber, String name, double gpa) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName, true))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
        }
    }

    public static void retrieveStudentData(String fileName) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        }
    }
}
