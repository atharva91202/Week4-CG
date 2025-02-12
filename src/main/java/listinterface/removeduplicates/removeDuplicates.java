package listinterface.removeduplicates;

import java.util.*;

public class removeDuplicates {
    public static List<Integer> duplicates(List<Integer> list){
        Set<Integer> actuals = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (Integer num :list){
            if (!actuals.contains(num)){
                actuals.add(num);
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,1,2,2,3,4,5,7,5,6);
        System.out.println(duplicates(list));
    }
}
