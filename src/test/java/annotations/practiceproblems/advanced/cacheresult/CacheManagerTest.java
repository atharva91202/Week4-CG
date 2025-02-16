package annotations.practiceproblems.advanced.cacheresult;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CacheManagerTest {

    @Test
    void testCaching() throws Exception {
        ExpensiveComputation computation = new ExpensiveComputation();


        int result1 = (int) CacheManager.invokeCachedMethod(computation, "computeFactorial", 4);
        assertEquals(24, result1);


        int result2 = (int) CacheManager.invokeCachedMethod(computation, "computeFactorial", 4);
        assertEquals(24, result2);
    }
}
