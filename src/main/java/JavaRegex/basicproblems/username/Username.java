package JavaRegex.basicproblems.username;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Username {
    static void validation(String re , String str){
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(str);
        Boolean result = matcher.matches();

        System.out.println(result);
    }

    public static void main(String[] args) {
        String re = "^[a-zA-Z0-9_]{5,15}$";
        String str = "user_1234";
        validation(re,str);
    }
}
