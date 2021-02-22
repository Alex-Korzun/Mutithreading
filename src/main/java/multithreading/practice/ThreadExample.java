package multithreading.practice;

import org.apache.log4j.Logger;

public class ThreadExample extends Thread {
    private static final int ONE_HUNDRED = 100;
    private static final Logger logger = Logger.getLogger(ThreadExample.class);
    private final Counter counter;

    public ThreadExample(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        logger.info("Thread example started working...");
        while (counter.getCounter() < ONE_HUNDRED) {
            int count = counter.increment();
            logger.info(Thread.currentThread().getName() + " = " + count);
        }
        logger.info("Thread example finished working...");
    }
}
