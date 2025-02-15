package JavaRegex.extractionproblems.extractemail;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEMails {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org for more details.";
        List<String> emails = extractEmails(text);

        // Print extracted emails
        for (String email : emails) {
            System.out.println(email);
        }
    }

    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();

        // Regular expression for a valid email
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Find and add all matches
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }
}
