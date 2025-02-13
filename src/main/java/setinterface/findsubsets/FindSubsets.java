package setinterface.findsubsets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindSubsets {
    public static <T> boolean areSubsets(Set<T> set1, Set<T> set2){
        Set<T> subset = (set1.size() > set2.size()) ? set2 : set1;
        Set<T> powerSet = (set1.size() <= set2.size()) ? set2 : set1;

        for(T element : subset){
            if(!powerSet.contains(element)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1,2,3,4));

        // determining if one set is subset of another
        boolean subsets = areSubsets(set1, set2);

        if(subsets){
            System.out.println("One is subset of another");
        } else {
            System.out.println("No set is subset of another");
        }
    }
}
