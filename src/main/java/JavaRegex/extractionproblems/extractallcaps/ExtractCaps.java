package JavaRegex.extractionproblems.extractallcaps;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCaps {
    public static void main(String[] args) {
        String Text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> words = extractWords(Text);

        for (String word : words){
            System.out.println(word);
        }

    }
    static List<String> extractWords(String Text){
        List<String> words = new ArrayList<>();
        //Regex to find captial word
        String re = "\\b[A-Z][a-z]*\\b";
        //Compiling the patterns
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(Text);

        while (matcher.find()){
            words.add(matcher.group());
        }
        return words;
    }
}
