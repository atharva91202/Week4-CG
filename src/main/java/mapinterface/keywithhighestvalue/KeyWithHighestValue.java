package mapinterface.keywithhighestvalue;

import java.util.HashMap;
import java.util.Map;

public class KeyWithHighestValue {
    public static String keyWithHighestValue(HashMap<String, Integer> inputMap){
        String answerKey = "";
        int highestValue = Integer.MIN_VALUE;

        for(Map.Entry<String, Integer> entry : inputMap.entrySet()){
            if(entry.getValue() > highestValue){        // if current value is greater, update key
                answerKey = entry.getKey();
                highestValue = entry.getValue();
            }
        }

        return answerKey;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 1);

        String keyWithHighestValue = keyWithHighestValue(inputMap);
        System.out.println("Key with Highest Value : " + keyWithHighestValue);
    }
}
