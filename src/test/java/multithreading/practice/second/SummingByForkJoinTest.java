package multithreading.practice.second;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SummingByForkJoinTest {
    private SummingUtil summingUtil;
    private ForkJoinService forkJoinService;

    @BeforeEach
    void setUp() {
        summingUtil = new SummingUtil();
        forkJoinService = new ForkJoinService(summingUtil.getList());
    }

    @Test
    public void testRandomlyGeneratedList() {
        int expected = summingUtil.getSum();
        int actual = forkJoinService.getSum();
        Assertions.assertEquals(expected, actual);
    }
}