package JavaRegex.extractionproblems.extractlinks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class extractLinks {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> links = extraction(text);

        for (String link : links){
            System.out.println(link);
        }
    }
    static List<String> extraction(String text){
          List<String> list = new ArrayList<>();
           //Regex for identification
        String re = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}\\S*";

        //Compile pattern and find matches
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            list.add(matcher.group());
        }
       return list;
    }
}
