package multiplecatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class multipleCatchTest {
    @Test
    void testValidIndex() {
        int[] arr = {10, 20, 30, 40, 50};
        assertDoesNotThrow(() -> multipleCatch.arrayTraverse(arr, 2));
    }

    @Test
    void testInvalidIndex() {
        int[] arr = {10, 20, 30, 40, 50};
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            multipleCatch.arrayTraverse(arr, 10);
        });
    }

    @Test
    void testNullArray() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            multipleCatch.arrayTraverse(null, 1);
        });
    }
}
