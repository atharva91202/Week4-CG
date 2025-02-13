package bufferedstreams;

import java.io.*;

public class bufferedStreams {
    private static final int Buffer_Size = 4096;
    public static void bufferCopy(String sourcePath , String destinationPath){
        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath);

        if (!sourceFile.exists()){
            System.out.println("Error Source file doesn't exist");
             return;
        }
        long start = System.nanoTime();
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {
            byte[] buffer = new byte[Buffer_Size];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            long endTime = System.nanoTime();
            System.out.println("Buffered Copy Time: " + (endTime - start) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String sourceFile = "C:\\my doucments\\file\\100mb-examplefile-com.txt";  // Change with actual large file path
        String bufferedDestFile = "C:\\my doucments\\file\\output.txt";
        String unbufferedDestFile = "C:\\my doucments\\file\\unbuffered.txt";

        System.out.println("Copying using Buffered Streams...");
        bufferCopy(sourceFile, bufferedDestFile);

        System.out.println("\nCopying using Unbuffered Streams...");
       bufferCopy(sourceFile, unbufferedDestFile);
    }
}

