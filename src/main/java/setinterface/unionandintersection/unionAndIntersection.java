package setinterface.unionandintersection;

import java.util.HashSet;
import java.util.Set;

public class unionAndIntersection {
    public static Set<Integer> union(Set<Integer>set1,Set<Integer>set2){
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
    public static Set<Integer> intersection(Set<Integer>set1,Set<Integer>set2){
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(1,2,3));
        Set<Integer> set2 = new HashSet<>(Set.of(4,3,6));
        System.out.println(union(set1,set2));
        System.out.println(intersection(set1,set2));
    }
}
