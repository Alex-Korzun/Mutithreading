package multithreading.practice.second;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.collections4.ListUtils;

public class ExecutorServiceForSum {
    private static final int NUMBER_OF_THREADS = 4;
    private final List<Integer> values;

    public ExecutorServiceForSum(List<Integer> values) {
        this.values = values;
    }

    public int getSum() {
        List<List<Integer>> partitions = ListUtils.partition(values,
                values.size() / NUMBER_OF_THREADS);
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<CallableExample> callableExamples = new ArrayList<>();
        for (List<Integer> part : partitions) {
            callableExamples.add(new CallableExample(part));
        }
        try {
            executorService.invokeAll(callableExamples);
        } catch (InterruptedException e) {
            throw new RuntimeException("Can't invoke threads" + e);
        }
        int result = 0;
        for (CallableExample thread : callableExamples) {
            try {
                result += executorService.submit(thread).get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Can't get result from threads", e);
            }
        }
        executorService.shutdown();
        return result;
    }
}
