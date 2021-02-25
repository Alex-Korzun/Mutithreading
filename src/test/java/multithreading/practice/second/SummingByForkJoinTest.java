package multithreading.practice.second;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SummingByForkJoinTest {
    private RandomGeneratorUtil randomGeneratorUtil;
    private ForkJoinService forkJoinService;

    @BeforeEach
    void setUp() {
        randomGeneratorUtil = new RandomGeneratorUtil();
        forkJoinService = new ForkJoinService(randomGeneratorUtil.getList());
    }

    @Test
    public void testSummingByForkJoin() {
        int expected = getSum(randomGeneratorUtil.getList());
        int actual = forkJoinService.getSum();
        Assertions.assertEquals(expected, actual);
    }

    private int getSum(List<Integer> list) {
        return list.stream().reduce(Integer::sum).get();
    }
}
