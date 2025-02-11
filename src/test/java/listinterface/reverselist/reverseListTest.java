package listinterface.reverselist;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class reverseListTest {

    @Test
    void reverseByArraylist() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(5, 4, 3, 2, 1);
        assertEquals(expected, reverseList.reverseByArraylist(input));
    }

    @Test
    void reverseByLinkedList() {
        LinkedList<Integer> input = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> expected = new LinkedList<>(Arrays.asList(5, 4, 3, 2, 1));
        assertEquals(expected, reverseList.reverseByLinkedList(input));
    }

}