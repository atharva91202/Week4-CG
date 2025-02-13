package userinput;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class consoleInput {
    public static void main(String[] args) {

    String fileName = "C:\\my doucments\\file\\user_input.txt";
    try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    FileWriter writer = new FileWriter(fileName,true))
    {
        //Taking user input
        System.out.println("Enter Your Name");
        String name = reader.readLine();

        System.out.println("Enter Your age");
        String age = reader.readLine();

        System.out.println("Domain language");
        String language = reader.readLine();

        //Writing on the file
        writer.write("Name " + name + "\n");
        writer.write("Age " + age + "\n");
        writer.write("Domain Language  " + language + "\n");
        writer.write("------------------------------");

        System.out.println("Data Saved in file Successfully " + fileName);
    }catch (IOException e){
        System.out.println("Error :" + e.getMessage());
    }
  }
}