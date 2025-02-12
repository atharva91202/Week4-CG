package listinterface.frequencyofelements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findFrequency {
    public static Map<String,Integer> frequency(List<String> words){
      Map<String,Integer> frequencyMap = new HashMap<>();
      for (String word : words) {
          frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) +1);
      }
      return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple","Banana" ,"Orange" ,"Apple" ,"Mango");
        System.out.println(frequency(words));
    }
}
