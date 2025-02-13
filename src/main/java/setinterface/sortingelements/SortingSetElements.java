package setinterface.sortingelements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SortingSetElements {
    public static <T> Set<T> sortElements(Set<T> inputSet){
        // Tree set to store elements in sorted order
        Set<T> sortedSet = new TreeSet<>();

        // adding elements to treeset
        for(T element : inputSet){
            sortedSet.add(element);
        }

        // returning sorted list of elements
        return sortedSet;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5,3,9,1));

        // storing list of sorted elements
        Set<Integer> sortedSet = sortElements(set);
        System.out.println(sortedSet);
    }
}
