package readinglargefile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void readFile(String filepath){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))){
            String line;

            while((line = bufferedReader.readLine()) != null){
                boolean contains = line.toLowerCase().contains("error");

                if(contains){
                    System.out.println(line);
                }
            }

            System.out.println("Read file successfully");
        } catch (IOException e){
            System.out.println("IOException : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filepath = "C:\\my doucments\\file\\100mb-examplefile-com.txt";

        readFile(filepath);
    }
}
