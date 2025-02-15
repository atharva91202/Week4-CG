package JavaRegex.advancedproblems.domainlanguages;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Languages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> languages = extractLanguages(text);

        for (String lang : languages){
            System.out.println(lang);
        }

    }
    static List<String> extractLanguages(String text){
        List<String> languages = new ArrayList<>();
        //Regex to find languages
        String re = "\\b(Java|Python|JavaScript|Go|C\\+\\+|Ruby|Swift)\\b";

        //Compiling the patterns
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            languages.add(matcher.group());
        }
        return languages;
    }
}
