package JavaRegex.advancedproblems.repeatingwords;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatingWords {
    public static void main(String[] args) {
        String sentence = "This is is a repeated repeated word test.";
        findRepeatingWords(sentence);
    }

    // Method to find and print repeating words
    public static void findRepeatingWords(String sentence) {
        // Regular expression to match words
        String regex = "\\b\\w+\\b";

        // Using a HashMap to store word occurrences
        Map<String, Integer> wordCount = new HashMap<>();

        // Compile the regex and match the words
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);

        // Count the occurrences of each word
        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Convert to lowercase for case-insensitive comparison
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Print repeating words
        System.out.println("Repeating words:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}