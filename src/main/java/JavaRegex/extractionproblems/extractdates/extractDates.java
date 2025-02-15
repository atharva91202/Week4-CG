package JavaRegex.extractionproblems.extractdates;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class extractDates {
    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> dates = extraction(text);

        for (String date : dates) {
            System.out.println(date);
        }
    }
    static List<String> extraction(String text){
        List<String> dates = new ArrayList<>();

        // Regex pattern for dd/mm/yyyy format
        String re = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})\\b";

        // Compile pattern and find matches
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            dates.add(matcher.group());
        }

        return dates;
    }
}