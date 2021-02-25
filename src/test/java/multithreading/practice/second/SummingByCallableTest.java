package multithreading.practice.second;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SummingByCallableTest {
    private RandomGeneratorUtil randomGeneratorUtil;
    private ExecutorServiceForSum executorServiceForSum;

    @BeforeEach
    void setUp() {
        randomGeneratorUtil = new RandomGeneratorUtil();
        executorServiceForSum = new ExecutorServiceForSum(randomGeneratorUtil.getList());
    }

    @Test
    public void testSummingByCallable() {
        int expected = getSum(randomGeneratorUtil.getList());
        int actual = executorServiceForSum.getSum();
        Assertions.assertEquals(expected, actual);
    }

    private int getSum(List<Integer> list) {
        return list.stream().reduce(Integer::sum).get();
    }
}
