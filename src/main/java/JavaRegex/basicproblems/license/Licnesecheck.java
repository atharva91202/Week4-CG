package JavaRegex.basicproblems.license;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Licnesecheck {
    public static void main(String[] args) {
        String re = "^[A-Z]{2}[0-9]{4}$";
        String str = "AB1234";
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(str);
        boolean result = matcher.matches();
        if (result != true) {
            System.out.println("License is not Valid ");
        } else {
            System.out.println("Licence is Valid");
        }
    }
}