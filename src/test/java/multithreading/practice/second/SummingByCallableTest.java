package multithreading.practice.second;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SummingByCallableTest {
    private SummingUtil summingUtil;
    private SummingByCallable summingByCallable;

    @BeforeEach
    void setUp() {
        summingUtil = new SummingUtil();
        summingByCallable = new SummingByCallable(summingUtil.getList());
    }

    @Test
    public void testSummingByCallable() {
        int expected = summingUtil.getSum();
        int actual = summingByCallable.getSum();
        Assertions.assertEquals(expected, actual);
    }
}