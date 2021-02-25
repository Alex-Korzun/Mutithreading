package multithreading.practice.second;

import java.util.List;
import java.util.concurrent.Callable;

public class CallableExample implements Callable<Integer> {
    private List<Integer> values;

    public CallableExample(List<Integer> values) {
        this.values = values;
    }

    @Override
    public Integer call() throws Exception {
        return values.stream().reduce(0, Integer::sum);
    }
}
