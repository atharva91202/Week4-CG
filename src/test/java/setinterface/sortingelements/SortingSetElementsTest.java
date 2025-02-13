package setinterface.sortingelements;


import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SortingSetElementsTest {

    @Test
    void testSortElementsNormalCase() {
        Set<Integer> inputSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        Set<Integer> expected = new TreeSet<>(Arrays.asList(1, 3, 5, 9));
        assertEquals(expected, SortingSetElements.sortElements(inputSet));
    }

    @Test
    void testSortElementsEmptySet() {
        Set<Integer> inputSet = new HashSet<>();
        Set<Integer> expected = new TreeSet<>();
        assertEquals(expected, SortingSetElements.sortElements(inputSet));
    }

    @Test
    void testSortElementsSingleElement() {
        Set<Integer> inputSet = new HashSet<>(Collections.singleton(42));
        Set<Integer> expected = new TreeSet<>(Collections.singleton(42));
        assertEquals(expected, SortingSetElements.sortElements(inputSet));
    }

    @Test
    void testSortElementsAlreadySorted() {
        Set<Integer> inputSet = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> expected = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(expected, SortingSetElements.sortElements(inputSet));
    }

    @Test
    void testSortElementsStringSet() {
        Set<String> inputSet = new HashSet<>(Arrays.asList("banana", "apple", "cherry"));
        Set<String> expected = new TreeSet<>(Arrays.asList("apple", "banana", "cherry"));
        assertEquals(expected, SortingSetElements.sortElements(inputSet));
    }
}
