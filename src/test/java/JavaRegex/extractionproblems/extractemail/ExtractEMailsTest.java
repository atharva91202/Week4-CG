package JavaRegex.extractionproblems.extractemail;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExtractEMailsTest {
    // ✅ Test extracting multiple emails
    @Test
    void testMultipleEmails() {
        String text = "Contact us at support@example.com and info@company.org";
        List<String> expected = Arrays.asList("support@example.com", "info@company.org");
        assertEquals(expected, ExtractEMails.extractEmails(text));
    }

    // ✅ Test extracting a single email
    @Test
    void testSingleEmail() {
        String text = "My email is user123@gmail.com";
        List<String> expected = Collections.singletonList("user123@gmail.com");
        assertEquals(expected, ExtractEMails.extractEmails(text));
    }

    // ❌ Test when there are no emails
    @Test
    void testNoEmails() {
        String text = "This text has no email addresses.";
        assertTrue(ExtractEMails.extractEmails(text).isEmpty());
    }

    // ✅ Test email with special characters
    @Test
    void testSpecialCharacterEmail() {
        String text = "Reach me at john.doe+test@sub.example.com.";
        List<String> expected = Collections.singletonList("john.doe+test@sub.example.com");
        assertEquals(expected, ExtractEMails.extractEmails(text));
    }

    // ✅ Test emails inside text with punctuation
    @Test
    void testEmailsWithPunctuation() {
        String text = "Please contact: admin@server.net, support@domain.io.";
        List<String> expected = Arrays.asList("admin@server.net", "support@domain.io");
        assertEquals(expected, ExtractEMails.extractEmails(text));
    }
}