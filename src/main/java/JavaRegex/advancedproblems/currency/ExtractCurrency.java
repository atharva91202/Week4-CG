package JavaRegex.advancedproblems.currency;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCurrency {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> currencyValues = extraction(text);

        // Print out the extracted currency values
        for (String value : currencyValues) {
            System.out.println(value);
        }
    }
    static List<String> extraction(String text){
        List<String> currencyValues = new ArrayList<>();
        //Regex expression to match values
        String re = "\\$\\d+(\\.\\d{2})?";
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(text);

        //Finding all matched currency values
        while (matcher.find()){
            currencyValues.add(matcher.group());
        }
        return currencyValues;
    }
}
