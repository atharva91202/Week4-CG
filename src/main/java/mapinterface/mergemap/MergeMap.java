package mapinterface.mergemap;

import java.util.HashMap;
import java.util.Map;

public class MergeMap {
    public static HashMap<String, Integer> mergeMap(HashMap<String, Integer> inputMap1, HashMap<String, Integer> inputMap2){
        HashMap<String, Integer> mergedMap = new HashMap<>(inputMap1);

        for(Map.Entry<String, Integer> entry : inputMap2.entrySet()){
            mergedMap.put(entry.getKey(), inputMap1.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        return mergedMap;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> inputMap1 = new HashMap<>();
        inputMap1.put("A", 1);
        inputMap1.put("B", 2);

        HashMap<String, Integer> inputMap2 = new HashMap<>();
        inputMap2.put("C", 2);
        inputMap2.put("B", 3);

        HashMap<String, Integer> mergedMap = mergeMap(inputMap1, inputMap2);
        System.out.println(mergedMap);
    }
}
