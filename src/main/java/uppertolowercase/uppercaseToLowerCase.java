package uppertolowercase;

import java.io.*;

public class uppercaseToLowerCase {
    public static void main(String[] args) {
        String sourceFile = "C:\\my documents\\file\\input.txt";   // Input file
        String destinationFile = "C:\\my documents\\file\\output.txt"; // Output file

        try {
            convertUppercaseToLowercase(sourceFile, destinationFile);
            System.out.println("✅ File converted successfully! Check: " + destinationFile);
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public static void convertUppercaseToLowercase(String source, String destination) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase()); // Convert to lowercase
                writer.newLine(); // Maintain line breaks
            }
        }
    }
}

