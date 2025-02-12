package setinterface.unionandintersection;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class unionAndIntersectionTest {

    @Test
    void union() {
        Set<Integer> set1 = new HashSet<>(Set.of(1,2,3));
        Set<Integer> set2 = new HashSet<>(Set.of(4,5,6));
        Set<Integer> expected = new HashSet<>(Set.of(1,2,3,4,5,6));
        assertEquals(expected,unionAndIntersection.union(set1,set2));
    }

    @Test
    void intersection() {
        Set<Integer> set1 = new HashSet<>(Set.of(1,2,3));
        Set<Integer> set2 = new HashSet<>(Set.of(4,5,3));
        Set<Integer> expected = new HashSet<>(Set.of(3));
        assertEquals(expected , unionAndIntersection.intersection(set1,set2));
    }
}