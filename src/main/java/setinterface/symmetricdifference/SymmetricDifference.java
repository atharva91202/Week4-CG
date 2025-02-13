package setinterface.symmetricdifference;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2){
        Set<T> symmetricDifferenceSet = new HashSet<>();

        // adding elements present only in set1 to symmetric difference
        for(T element : set1){
            if(!set2.contains(element)){
                symmetricDifferenceSet.add(element);
            }
        }

        // adding elements present only in set2 to symmetric difference
        for(T element : set2){
            if(!set1.contains(element)){
                symmetricDifferenceSet.add(element);
            }
        }

        // returning symmetric difference
        return symmetricDifferenceSet;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3,4,5));

        // determining symmetric difference
        Set<Integer> symmetricDifferenceSet = symmetricDifference(set1, set2);

        // displaying the difference
        System.out.println("Symmetric Difference : " + symmetricDifferenceSet);
    }
}
