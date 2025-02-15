package JavaRegex.advancedproblems.validcreditcard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidCC {
    public static void main(String[] args) {
        String number = "4898238908763546";
        if (isValidCC(number)) {
            System.out.println(number + " is a valid card number");
        } else {
            System.out.println(number + " is not a valid card number");
        }
    }

    static boolean isValidCC(String number) {
        //Regex to check the card number
        String re = "^(4\\d{15}|5\\d{15})$";

        //Compiling the regex pattern for check
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}