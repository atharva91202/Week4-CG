package setinterface.findsubsets;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FindSubsetsTest {

    @Test
    void testSubsetTrueCase() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        assertTrue(FindSubsets.areSubsets(set1, set2));
    }

    @Test
    void testEqualSets() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3));
        assertTrue(FindSubsets.areSubsets(set1, set2));
    }

    @Test
    void testSubsetFalseCase() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(5, 6));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        assertFalse(FindSubsets.areSubsets(set1, set2));
    }

    @Test
    void testEmptySetAsSubset() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3));
        assertTrue(FindSubsets.areSubsets(set1, set2)); // An empty set is a subset of any set
    }

    @Test
    void testSuperSetCase() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(2, 3));
        assertTrue(FindSubsets.areSubsets(set1, set2));
    }

    @Test
    void testEmptySets() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        assertTrue(FindSubsets.areSubsets(set1, set2)); // An empty set is a subset of another empty set
    }
}
