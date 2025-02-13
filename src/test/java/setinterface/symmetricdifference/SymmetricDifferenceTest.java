package setinterface.symmetricdifference;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SymmetricDifferenceTest {

    @Test
    void testSymmetricDifferenceBasicCase() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 4, 5));

        assertEquals(expected, SymmetricDifference.symmetricDifference(set1, set2));
    }

    @Test
    void testSymmetricDifferenceWithDisjointSets() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(6, 7, 8));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3, 6, 7, 8));

        assertEquals(expected, SymmetricDifference.symmetricDifference(set1, set2));
    }

    @Test
    void testSymmetricDifferenceWithIdenticalSets() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> expected = new HashSet<>(); // No difference

        assertEquals(expected, SymmetricDifference.symmetricDifference(set1, set2));
    }

    @Test
    void testSymmetricDifferenceWithEmptySet() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3));

        assertEquals(expected, SymmetricDifference.symmetricDifference(set1, set2));
    }

    @Test
    void testSymmetricDifferenceBothEmptySets() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> expected = new HashSet<>(); // No elements

        assertEquals(expected, SymmetricDifference.symmetricDifference(set1, set2));
    }
}
