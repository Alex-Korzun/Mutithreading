package multithreading.practice;

public class RunnableExample implements Runnable {
    private final Counter counter;

    public RunnableExample(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("Runnable example started working...");
        for (int i = 0; i < 100; i++) {
            int count = counter.getCounter();
            System.out.println(ThreadExample.currentThread().getName() + ": " + count);
            counter.setCounter(i);
        }
    }
}
