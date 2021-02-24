package multithreading.practice.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SummingUtil {
    public static final int SIZE = 1_000_000;
    public static final int BOUND = 100;
    private List<Integer> list;

    public SummingUtil() {
        this.list = getRandomList();
    }

    public List<Integer> getList() {
        return list;
    }

    public int getSum() {
        return list.stream().reduce(Integer::sum).get();
    }

    private List<Integer> getRandomList() {
        return IntStream.range(0, SIZE)
                .map(i -> new Random().nextInt(BOUND))
                .boxed()
                .collect(Collectors.toList());
    }
}
