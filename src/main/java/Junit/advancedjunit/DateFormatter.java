package Junit.advancedjunit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {

    public static String formatDate(String inputDate) {
        try {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            LocalDate date = LocalDate.parse(inputDate, inputFormatter);
            return date.format(outputFormatter);
        } catch (DateTimeParseException e) {
            return "Invalid Date";
        }
    }

    public static void main(String[] args) {
        String[] testDates = {"2025-02-15", "1999-12-31", "2024-07-27", "invalid-date"};

        for (String date : testDates) {
            System.out.println("Input: " + date + " → Output: " + formatDate(date));
        }
    }
}
