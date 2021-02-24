package multithreading.practice.second;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import org.apache.commons.collections4.ListUtils;

public class ForkJoinService {
    private static final int NUMBER_OF_THREADS = 4;
    private final List<Integer> values;

    public ForkJoinService(List<Integer> values) {
        this.values = values;
    }

    public int getSum() {
        List<List<Integer>> partitions = ListUtils.partition(values,
                values.size() / NUMBER_OF_THREADS);
        List<CustomRecursiveTask> recursiveThreads = new ArrayList<>();
        for (List<Integer> part : partitions) {
            recursiveThreads.add(new CustomRecursiveTask(part));
        }
        Collection<CustomRecursiveTask> threads = ForkJoinTask.invokeAll(recursiveThreads);
        int result = 0;
        for (CustomRecursiveTask task : threads) {
            result += task.join();
        }
        return result;
    }
}
