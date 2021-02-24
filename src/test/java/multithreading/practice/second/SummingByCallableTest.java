package multithreading.practice.second;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SummingByCallableTest {
    private SummingUtil summingUtil;
    private ExecutorServiceForSum executorServiceForSum;

    @BeforeEach
    void setUp() {
        summingUtil = new SummingUtil();
        executorServiceForSum = new ExecutorServiceForSum(summingUtil.getList());
    }

    @Test
    public void testSummingByCallable() {
        int expected = summingUtil.getSum();
        int actual = executorServiceForSum.getSum();
        Assertions.assertEquals(expected, actual);
    }
}