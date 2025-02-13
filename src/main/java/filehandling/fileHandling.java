package filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class fileHandling {
    public static void copyFile(String sourcePath ,String destinationPath){
        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath);

        //Checking if source file exist or not
        if (!sourceFile.exists()){
            System.out.println("Error : File Doesn't Exist");
            return;
        }
        try(FileInputStream fis =new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[1024]; //buffer Efficiency
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1){
                fos.write(buffer,0,bytesRead);
            }
            System.out.println("File copied successfully" + destinationPath);
        }catch (IOException e){
            System.out.println("Error occured " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String sourcePath ="C:\\my doucments\\file\\inputFile.txt" ;
        String destinationPath ="C:\\my doucments\\file\\output.txt";
        copyFile(sourcePath,destinationPath);
    }
}
