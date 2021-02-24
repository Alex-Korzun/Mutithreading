package multithreading.practice.second;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SummingByForkJoinTest {
    private SummingUtil summingUtil;
    private SummingByForkJoin summingByForkJoin;

    @BeforeEach
    void setUp() {
        summingUtil = new SummingUtil();
        summingByForkJoin = new SummingByForkJoin(summingUtil.getList());
    }

    @Test
    public void testRandomlyGeneratedList() {
        int expected = summingUtil.getSum();
        int actual = summingByForkJoin.getSum();
        Assertions.assertEquals(expected, actual);
    }
}