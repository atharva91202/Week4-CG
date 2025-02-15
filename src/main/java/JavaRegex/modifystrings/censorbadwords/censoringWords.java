package JavaRegex.modifystrings.censorbadwords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class censoringWords {
    public static void main(String[] args) {
        String text ="This is a damn bad example with some stupid words.";
        List<String> wordList = Arrays.asList("damn" ,"stupid");

        String result = censorWords(wordList,text);
        System.out.println(result);
    }
    static String censorWords(List<String> list , String text){
        for (String badword : list){
          text = text.replaceAll("(?i)\\b" + badword + "\\b" ,"*****");
        }
        return text;
    }
}
