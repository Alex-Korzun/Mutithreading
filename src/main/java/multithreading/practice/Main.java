package multithreading.practice;

import java.util.List;
import multithreading.practice.second.ExecutorServiceForSum;
import multithreading.practice.second.ForkJoinService;
import multithreading.practice.second.SummingUtil;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new SummingUtil().getList();
        ExecutorServiceForSum callableSum = new ExecutorServiceForSum(list);
        System.out.println(callableSum.getSum());
        ForkJoinService forkSum = new ForkJoinService(list);
        System.out.println(forkSum.getSum());
    }
}
