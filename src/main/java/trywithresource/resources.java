package trywithresource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class resources {
    public static void main(String[] args) {
        String sourcePath = "info.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(sourcePath))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
                reader.close();
            }
        }catch (IOException e){
            System.out.println("File not found " + e.getMessage());
        }
    }
}
