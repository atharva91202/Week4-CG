package setinterface.equalsets;

import java.util.HashSet;
import java.util.Set;

public class equalSets {
    public static boolean equalityCheck(Set<Integer> set1, Set<Integer> set2) {
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(1,2,3));
        Set<Integer> set2 = new HashSet<>(Set.of(3,2,1));
        System.out.println(equalityCheck(set1,set2));
    }
}

