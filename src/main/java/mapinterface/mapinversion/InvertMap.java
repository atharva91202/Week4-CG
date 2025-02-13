package mapinterface.mapinversion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InvertMap {
    public static HashMap<Integer, ArrayList<String>> invertMap(HashMap<String, Integer> inputMap){
        HashMap<Integer, ArrayList<String>> invertedMap = new HashMap<>();

        for(Map.Entry<String, Integer> entry : inputMap.entrySet()){
            Integer value = entry.getValue();       // determining value for input map
            String key = entry.getKey();            // determining key from input map

            if(!invertedMap.containsKey(value)){        // checking if current value is present in inverted Map
                invertedMap.put(value, new ArrayList<>());  // if not present, storing value as key and initialising the list of keys to be stored
            }

            invertedMap.get(value).add(key);        // adding current key to value list of current value
        }

        return invertedMap;
    }

    public static void main(String[] args) {
        HashMap<String , Integer> inputMap = new HashMap<>();

        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);
        inputMap.put("D", 2);
        inputMap.put("E", 3);

        HashMap<Integer, ArrayList<String>> invertedMap = invertMap(inputMap);

        System.out.println(invertedMap);
    }
}
