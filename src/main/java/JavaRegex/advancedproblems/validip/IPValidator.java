package JavaRegex.advancedproblems.validip;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPValidator {
    public static void main(String[] args) {
        String ip = "192.168.1.1";
        if (isValidIP(ip)) {
            System.out.println(ip + " is a valid IP address.");
        }else {
            System.out.println(ip + "is not a valid IP");
        }
    }
    public static boolean isValidIP(String ip){
        // Regex pattern for valid IPv4 address
        String regex = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }
}
