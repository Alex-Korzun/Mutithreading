package multithreading.practice.second;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGeneratorUtil {
    public static final int SIZE = 1000000;
    public static final int BOUND = 100;
    private List<Integer> list;

    public RandomGeneratorUtil() {
        this.list = getRandomList();
    }

    public List<Integer> getList() {
        return list;
    }

    private List<Integer> getRandomList() {
        return IntStream.range(0, SIZE)
                .map(i -> new Random().nextInt(BOUND))
                .boxed()
                .collect(Collectors.toList());
    }
}
