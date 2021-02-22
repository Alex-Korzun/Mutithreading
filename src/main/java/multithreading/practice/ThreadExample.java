package multithreading.practice;

public class ThreadExample extends Thread {
    private final Counter counter;

    public ThreadExample(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("Thread example started working...");
        for (int i = 0; i < 100; i++) {
            counter.setCounter(i);
            System.out.println(counter);
        }
    }
}
