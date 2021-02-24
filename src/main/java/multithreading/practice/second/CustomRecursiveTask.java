package multithreading.practice.second;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Integer> {
    private List<Integer> values;

    public CustomRecursiveTask(List<Integer> values) {
        this.values = values;
    }

    @Override
    protected Integer compute() {
        return values.stream().reduce(0, Integer::sum);
    }
}
