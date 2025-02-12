package listinterface.rotateelements;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class rotationTest {

    @Test
    void testRotateList() {
        List<Integer> input = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> expected = Arrays.asList(30, 40, 50, 10, 20);
        assertEquals(expected, rotation.rotateList(input, 2));
    }

    @Test
    void testRotateListWithZeroRotation() {
        List<Integer> input = Arrays.asList(10, 20, 30);
        assertEquals(input, rotation.rotateList(input, 0));
    }

    @Test
    void testRotateListWithRotationEqualToSize() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        assertEquals(input, rotation.rotateList(input, 4));
    }
}
