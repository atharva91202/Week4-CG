package JavaRegex.basicproblems.hexcolour;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hexcolour {
    public static void main(String[] args) {
        String re = "^#([A-Fa-f0-9]{6})$";
        String str  = "#ff4500";
        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(str);
        boolean result = m.matches();
        if (result != true){
            System.out.println("Invalid Color Code");
        }else
            System.out.println("Valid Color Code ");

    }
}
