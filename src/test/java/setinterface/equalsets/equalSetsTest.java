package setinterface.equalsets;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class equalSetsTest {

    @Test
    void testAreSetsEqual() {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 2, 1));
        assertTrue(equalSets.equalityCheck(set1, set2));
    }

    @Test
    void testAreSetsEqualWithDifferentSizes() {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2));
        Set<Integer> set2 = new HashSet<>(Set.of(1, 2, 3));
        assertFalse(equalSets.equalityCheck(set1, set2));
    }

    @Test
    void testAreSetsEqualWithEmptySets() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        assertTrue(equalSets.equalityCheck(set1, set2));
    }
}