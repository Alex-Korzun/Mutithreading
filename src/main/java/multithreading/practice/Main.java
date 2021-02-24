package multithreading.practice;

import java.util.List;
import multithreading.practice.second.SummingByCallable;
import multithreading.practice.second.SummingByForkJoin;
import multithreading.practice.second.SummingUtil;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new SummingUtil().getList();
        SummingByCallable callableSum = new SummingByCallable(list);
        System.out.println(callableSum.getSum());
        SummingByForkJoin forkSum = new SummingByForkJoin(list);
        System.out.println(forkSum.getSum());
    }
}
